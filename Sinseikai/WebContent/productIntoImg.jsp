<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<style type="text/css">
a, a:visited, a:hover, a:active {color:#000;}
#album {width:350px; height:400
px;border:0px solid #aaa;margin:0 auto 20px auto;}
.gallery {padding:0; margin:300px 0 0 0; list-style-type:none; position:relative; width:500px; float:left;}

.gallery img {border:0;}
.gallery li {float:left;}

.gallery li a, .gallery li a:visited {font-size:11px; float:left; text-decoration:none; color:#000; background:#fff; text-align:center; width:26px; height:26px; line-height:24px; border:1px solid #444;margin:1px;}
.gallery li a img {position:absolute; top:-180px; left:0; visibility:hidden; border:0;}
.gallery li a img.landscape {top:-280px;}
.gallery li a img.portrait {left:-100;border-left:40px solid #eee;border-right:40px solid #eee;}
.gallery li a:hover {background:#ddd;}
.gallery li a:active, .gallery li a:focus {background:#444;color:#fff;}
.gallery li a:active img, .gallery li a:focus img {visibility:visible;}
</style>

<div id="album">
<ul class="gallery">
	<li><a href="#nogo">01<img class="landscape" src="http://www.blueb.co.kr/SRC1/image/Chrome.png" /></a></li>
	<li><a href="#nogo">02<img class="landscape" src="http://www.blueb.co.kr/SRC1/image/IE.png" /></a></li>
	<li><a href="#nogo">03<img class="landscape" src="http://www.blueb.co.kr/SRC1/image/Safari.png" /></a></li>
	<li><a href="#nogo">04<img class="landscape" src="http://www.blueb.co.kr/SRC1/image/Opera.png" /></a></li>
	<li><a href="#nogo">05<img class="landscape" src="http://www.blueb.co.kr/SRC1/image/Netscape.png" /></a></li>
	<li><a href="#nogo">06<img class="landscape" src="http://www.blueb.co.kr/SRC1/image/Firefox.png" /></a></li>
	<li><a href="#nogo">07<img class="landscape" src="http://www.blueb.co.kr/SRC1/image/Chrome.png" /></a></li>
	<li><a href="#nogo">08<img class="landscape" src="http://www.blueb.co.kr/SRC1/image/IE.png" /></a></li>
</ul>
</div>
</body>
</html>