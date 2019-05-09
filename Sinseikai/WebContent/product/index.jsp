<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<html class="no-js">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Flipster Demo</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="./dist/jquery.flipster.min.css">

    <script src="jquery.min.js"></script>
    <script src="./dist/jquery.flipster.min.js"></script>
</head>
<body>



<article id="demo-default" class="demo">
    <h2>Flipster Flat</h2>

    <div id="flat">
        <ul>
            <li data-flip-title="Red">
               <a href="productInto.pr?productNumber=1"><img src="./img/test1.png" width="100%" height="100%"></a><br>
                	<h2>나이키</h2>	나이키 반팔티<br><br>           	
                	36,000원                        
            </li>
            <li data-flip-title="Razzmatazz" data-flip-category="Purples">
                <img src="../img/text2.gif">
                <h2>엘페</h2>	상품2<br><br>           	
                	얼마게 원                         
             </li>
            <li data-flip-title="Deep Lilac" data-flip-category="Purples">
                <img src="../img/text3.gif">
            </li>
            <li data-flip-title="Daisy Bush" data-flip-category="Purples">
                <img src="../img/text4.gif">
            </li>
            <li data-flip-title="Cerulean Blue" data-flip-category="Blues">
                <img src="../img/text5.gif">
            </li>
            <li data-flip-title="Dodger Blue" data-flip-category="Blues">
                <img src="../img/text6.gif">
            </li>
            <li data-flip-title="Cyan" data-flip-category="Blues">
                <img src="../img/text7.jpg">
            </li>
            <li data-flip-title="Robin's Egg" data-flip-category="Blues">
                <img src="../img/text8.gif">
            </li>
            <li data-flip-title="Deep Sea" data-flip-category="Greens">
                <img src="../img/text9.gif">
            </li>
            <li data-flip-title="Apple" data-flip-category="Greens">
                <img src="../img/text10.gif">
            </li>
        </ul>
        
    </div>

<script>
    var flat = $("#flat").flipster({
        style: 'flat',
        spacing: -0.25
    });
    $("#flat").css("width","100%");
    
</script>



</article>


</body>
</html>
