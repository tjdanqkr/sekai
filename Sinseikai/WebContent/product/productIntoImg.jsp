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
#album {width:800px; height:800px;border:0px solid #aaa;margin:0 auto 40px auto;}
.gallery {padding:0; margin:300px 0 0 0; list-style-type:none; position:relative; width:500px; float:left;}
.gallery ul {width :500px; float:left; }
.gallery img {border:0;}

.gallery img {
    width: 540px;
    height: auto;
}
.gallery li a, .gallery li a:visited {font-size:11px; top:-180px; float:left; text-decoration:none; color:#000; background:#fff; text-align:center; width:30px; height:26px; line-height:24px; border:1px solid #444;margin:1px; margin-top :300px}
.gallery li a img {position:absolute; top:-180px; left:0; visibility:hidden; border:0;}
.gallery li a img.landscape {top:-280px;}
.gallery li a img.portrait {left:-100;border-left:40px solid #eee;border-right:40px solid #eee;}
.gallery li a:hover {background:#ddd;}
.gallery li a:active, .gallery li a:focus {background:#444;color:#fff;}
.gallery li a:active img, .gallery li a:focus img {visibility:visible;}
</style>

<div id="album">
<ul class="gallery">
	<li><a href="#nogo">01<img class="landscape" src="img/a1.jpg" /></a></li>
	<li><a href="#nogo">02<img class="landscape" src="img/a2.jpg" /></a></li>
	<li><a href="#nogo">03<img class="landscape" src="img/a3.jpg" /></a></li>
	<li><a href="#nogo">04<img class="landscape" src="img/a4.jpg" /></a></li>
</ul>
</div>
<script type="text/javascript">



</script>
</body>

</html>