<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head><!-- 여기는상품상세란 -->
<body>
<div><%@include file="/product/headmenu.jsp" %></div><br>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<head>
    <title></title>
    <style type="text/css">
        body { font-family: Lucida Sans Unicode, Arial, Sans-Serif; font-size:13px;}

        /* Structure */
        #header, #content, #comments, #sidebar, #footer { background-color:#F6F6F6; margin:10px 0px;
             -moz-border-radius:10px;  -webkit-border-radius:10px; padding:30px;}
        #header h1 { float:right; margin: 20px 0 0 0; font-size:36px; font-weight:bold;}
        #header h2 {font-size:16px; font-weight:normal; margin:0px; padding:0px;}
        #header { width:900px; margin:0px auto;}
        
        #main {width:960px; margin:0px auto; overflow:hidden;}
        #toolbox { text-align:right; float:right;}
        #content { width:540px; float:left;}
        #comments { width:540px; float:left;}
        #comments p span {display:block; font-size:16px; color:#B0232A;}
        #sidebar { width:280px; margin-left:20px; float:right;}
        #sidebar #ads { width:100%; overflow:hidden;}
        #sidebar #ads img { float:left; margin:5px; display:block;}
        #footer { width:900px; margin:0px auto;}
          
        /* Change view sprites */
        .toolbox { float:right; margin-left:10px;}
        .toolbox a { width:30px; height:20px; float:right; }

        #wideView {background: transparent url(http://store.blueb.co.kr/data/201009/IJ12847097607005/buttons.png) no-repeat scroll 0px 0px; }
        #wideView:hover { background-position:-30px 0px; }
        #wideView.wide {background-position:0px -20px; }
        #wideView.wide:hover { background-position:-30px -20px; }
     
        /* Different views */
        #content.wide { width:900px;}
        #toolbox.wide { width:960px;}
        #content.compact, #comments.compact { width:690px;}
        #sidebar.compact { width:130px;}
       
        a { color:#0000ff;}
        h3 { font-size:24px; font-weight:normal; padding:0; margin:0; color:#B0232A;}
        em { font-size:10px;}
    </style>
    
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            $("#wideView").click(function() {
                $("#content").toggleClass("wide");
                $(this).toggleClass("wide");
            });
        });
    </script>
    
</head>
<body>  
    <div id="main">
        <div id="content">
            <div class="toolbox">크게보기: <a id="wideView" href="#"></a></div>
            <h3>상품 이미지</h3>
          <span> <%@include file="/product/productIntoImg.jsp" %></span>
                <span style="float:left; margin:0 10px 10px 0;" ><br /></span>
               
               
               
               
        </div>
        <div id="sidebar">
            <h3>Sidebar</h3>
            
            <h4>Sub header</h4>
            <ul>
              	오케이4달라
            </ul>                               
        </div>
        <div id="comments">
            <h3>Comments</h3>
            <p>
                <span>Visitor 1</span>
                Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, 
                there live the blind texts. Separated they live in Bookmarksgrove right at the coast of 
                the Semantics, a large language ocean.
            </p>
            <p>
                <span>Visitor 2</span>
                Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, 
                there live the blind texts. Separated they live in Bookmarksgrove right at the coast of 
                the Semantics, a large language ocean.
            </p>
            <p>
                <span>Visitor 3</span>
                Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, 
                there live the blind texts. Separated they live in Bookmarksgrove right at the coast of 
                the Semantics, a large language ocean.
            </p>
        </div>
    </div>
    <div id="footer">Copyright © JankoAtWarpSpeed 2009.</div>
</body>
</html>
</body>
</html>