package net.product.action;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import net.action.Action;
import net.action.ActionForward;
import net.product.db.ProductBean;
import net.product.db.ProductDAO;

public class UploadAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String realFolder = "";
		String saveFolder = "img";
		realFolder = request.getRealPath(saveFolder);
		int fileSize = 5 * 1024 * 1024;
		boolean result = false;
		int i= (int)(Math.random()*1000000000);
		try {
			ActionForward forward = new ActionForward();
			MultipartRequest multi = null;
			ProductBean productbean = new ProductBean();
			ProductDAO productdao = new ProductDAO();

			multi = new MultipartRequest(request, realFolder, fileSize, "UTF-8", new DefaultFileRenamePolicy());
		//	String name = multi.getParameter("ImgAddr1");
System.out.println(multi.getParameter("brandName"));
			Enumeration<String>files = (Enumeration<String>)multi.getFileNames();
			productbean.setBrandName(multi.getParameter("brandName"));
			productbean.setModelName(multi.getParameter("proname"));
			productbean.setCoupon(multi.getParameter("coupon"));
			productbean.setDeliveryPeriod(Integer.parseInt(multi.getParameter("delibery")));
			productbean.setPrice(Integer.parseInt(multi.getParameter("setPrice")));
			productbean.setCategorycode(Integer.parseInt(multi.getParameter("category")));
			productbean.setImgAddr1(multi.getFilesystemName(files.nextElement()));
			productbean.setImgAddr2(multi.getFilesystemName(files.nextElement()));
			productbean.setImgAddr3(multi.getFilesystemName(files.nextElement()));
			productbean.setImgAddr4(multi.getFilesystemName(files.nextElement()));
			productbean.setImgAddr5(multi.getFilesystemName(files.nextElement()));
			productbean.setProductNumber(i);
			productbean.setSellerEmail(multi.getParameter("seller"));
			result = productdao.productInsert(productbean);
			// multi.getFilesystemName((String)multi.getFileNames().nextElement());
			
			productdao.close();
			if (result == false) {
				System.out.println("업로드 오류 ㅅㄱ");
				return null;
			}
			System.out.println("ㅊㅋ업로ㅊㅋ");

			forward.setRedirect(false);
			forward.setPath("./product/productRegist.jsp");
			return forward;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
