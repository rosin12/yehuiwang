<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录链接</title>
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <script src='login/spon_base64.js'></script>

  <script type="text/javascript">
  	function sub1(){
  		document.getElementById("form1").submit();
  	}
  	
  	function sub2(){
  		document.getElementById("form2").submit();
  	}
  	function md1() {
  	var t=document.getElementById("test1");
  	if(t.value==1){
  		var pwd = document.getElementById("password1");
		  console.log(pwd);
		  pwd.value = hex_md5(hex_md5(pwd.value).toUpperCase()).toUpperCase();
		  console.log(pwd.value);
		  document.getElementById("form3").submit();
		  
  	 	 t.value="2";
		}else{
  		 
  		window.open("http://m2mled.net/suggest.html?path=notification-redirect");
  		//window.open("http://m2mled.net/login/cardControl");
  	}
  		 
  		  
	}
	function md2() {
  		var t=document.getElementById("test2");
  		
  		if(t.value==1){
  		var pwd = document.getElementById("password2");
		  console.log(pwd);
		  pwd.value = hex_md5(hex_md5(pwd.value).toUpperCase()).toUpperCase();
		  console.log(pwd.value);
		  document.getElementById("form5").submit();
		  t.value="2";
		}else{
  		 
  		window.open("http://ledaips.com/cardControl");
  	}
  		
  		
  		  
	}
	function sub3(){
  		document.getElementById("form4").submit();
  	}
	function Linkto()
	{
		// 1. 传入参数为： {"username":"test","password":"123456","isadmin":"1","display":"路人甲"}
		var username = "admin";
		var password = "admin";
		var display = "超级管理员";
		var isadmin = "1";         // 1为管理员， 0为普通用户
		var context = "{'username':'" + username + "','password':'" + password + "','display':'" + display + "','isadmin':'" + isadmin + "'}";
		
		// 2. 参数加密
		var b = new SPON_Base64();
		var encoderData = b.encode(context);
		
		// 3. 链接方式为： http://192.168.1.100/?spon_token=
		//self.location = 'http://192.168.1.100/?spon_token=' + encoderData;
		//document.getElementById("iftest").src = 'http://192.168.1.100/?spon_token=' + encoderData;
		//document.getElementById("iftest").src = 'http://192.168.6.17:81/?spon_token=' + encoderData;
		window.open("http://192.168.6.17:81/?spon_token=" + encoderData);
	}
		
  </script>
    <script src="login/md5.min.js"></script>
  <body>

    <!-- 晶和红谷滩 -->
    <form action="Login" method="post" target="_blank" id="form1">
    	<input type="hidden" name="opr" id="opr" value="hgt">
    	<input type="hidden">
    	<input type="hidden">
    	<a  href="javascript:;" onclick="sub1()">晶和红谷滩灯控平台</a>
    </form>
     <!-- 晶和南沙项目 -->
    <form action="Login" method="post" target="_blank" id="form2">
    	<input type="hidden" name="opr" id="opr" value="jhns">
    	<input type="hidden">
    	<input type="hidden">
    	<a  href="javascript:;" onclick="sub2()">晶和南沙灯控平台</a>
    </form>
<!-- 中节能晶和照明项目 -->
    <form method="post" role="form" target="_blank" action="http://m2mled.net/login" id="form3">
		<input type="hidden" name="account" value="latticeshow" required="true" >
		<input type="hidden" id="password1" value="jinghe123456" name="password">
		<input type="hidden" id="test1" name="test1" value="1">
		<a href="javascript:;" onclick="md1()" id="clicked1">中节能晶和照明显示屏</a>
	</form>
	<!-- 中节能晶和照明项目 -->
    <form method="post" role="form" target="_blank" action="http://ledaips.com/login" id="form5">
		<input type="hidden" name="account" value="latticeshow" required="true" placeholder="账号">
		<input type="hidden" id="password2" value="jinghe123456" name="password" >
		<input type="hidden" id="test2" name="test2" value="1">
		<a href="javascript:;" onclick="md2()" id="clicked2">中节能晶和照明显示屏英文</a>
	</form>
	
	<!--中节能晶和照明项目园区管理平台 -->
	<form action="Login" method="post" target="_blank" id="form4">
    	<input type="hidden" name="opr" id="opr" value="yuanqu">
    	<input type="hidden">
    	<input type="hidden">
    	<a  href="javascript:;" onclick="sub3()">园区管理平台</a>
    </form>
	
		
		<a href="javascript:;" onclick="Linkto()" id="clicked2">世邦IP网络对讲广播系统</a>
	
  </body>
</html>
