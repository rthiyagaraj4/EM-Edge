<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8" %><html>

<head>
<title>eHospital Information System</title>
    <Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>

<script language="JavaScript">
   fullScreen() ;

    function fullScreen() {
        window.resizeTo( screen.availWidth, screen.availHeight ) ;
        window.moveTo( 0,0 ) ;
    }

	function resizing() {
		alert(obj.name)
	}
    
</script>

</head>
	<FRAMESET ROWS="9%,*" frameborder="0" FRAMESPACING=0 noresize>
		<FRAME SRC="header.jsp" NAME="header" SCROLLING=NO noresize>
		<frameset cols="0%,*" frameborder="0"  name="contentFrameset" BORDERCOLOR="red" >
			<frame src="../html/FloatMenu.html" name="menucontent" scrolling="NO" marginwidth=1 BORDERCOLOR="red"/>
			<frame  name="content" scrolling="no" marginwidth=1 BORDERCOLOR="red"/>
		</frameset>
	</FRAMESET>
</html>
