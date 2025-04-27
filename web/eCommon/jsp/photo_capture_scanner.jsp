<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.io.*, java.sql.*,webbeans.eCommon.*" %>

<head>

	<title>Capture Scan</title>

	<link rel='stylesheet' type ='text/css' href='../html/IeStyle.css'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>

	<script language="JavaScript">
		function connectButton_click() {
			//TwainPRO1.SelectSource();
			if (document.getElementById("showUI").value == 'true')TwainPRO1.ShowUI='True';
			else TwainPRO1.ShowUI='False';
			TwainPRO1.StartSession();
			Xpress1.BorderType = 2;
			Xpress1.ScrollBars = 3;
			Xpress1.hDib = TwainPRO1.hDib;
			Xpress1.PICResize(160,180);
		}

		function captureButton_click() {
			var file = "ftp://" + document.location.hostname + "/pat_photo/" + capture_form.file.value ;
			var oldFileExists = capture_form.oldFileExists.value ;
			Xpress1.SaveFileName = file ;
			Xpress1.SaveFile();
			setTimeout("RefreshPage()",1500);			
		}

		function RefreshPage(){
			var httpPath = document.getElementById("httpPath").value ;
			document.getElementById("oldPhoto").src = httpPath + document.getElementById("file").value ;
			document.location.reload(true);
		}

		function disconnectButton_click() {
			window.close() ;
		}
	</script>
</head>

<%!
	Connection con ;
	PreparedStatement pstmt ;
	ResultSet rs ;
%>

<%
	try{

			request.setCharacterEncoding("UTF-8");	

	String file = request.getParameter( "file" ) ;
	String showUI = request.getParameter( "showUI" ) ;
	if (showUI == null) showUI = "false"; 
	String path = "" ;
	String httpPath = "" ;
	String oldFile = "" ;
	String oldFileExists = "0" ;

	if ( file == null ) file = "patient" ;		

//	con = (Connection) session.getValue( "connection" ) ;
	con=ConnectionManager.getConnection(request);
	pstmt = con.prepareStatement( "select pat_photo_os_path, pat_photo_http_path from sm_db_info" ) ;
	rs = pstmt.executeQuery() ;

	if ( rs != null && rs.next() ) {
		path = rs.getString( "pat_photo_os_path" );
		httpPath = rs.getString( "pat_photo_http_path" ) ;
	}

	oldFile = path + file ;

	try {
		File f = new File( oldFile ) ;
		if ( f.exists() )
			oldFileExists = "1" ;
	} catch ( Exception e ) {}
%>

<body  onKeyDown = 'lockKey()' onLoad="connectButton_click()">
	<table width='100%' height='100%' align=center cellspacing=0 cellpadding=0>
		<tr>
			<td>
				<object classid="clsid:7B0207CE-7FF6-11D4-A13A-004005FA6275 VIEWASTEXT" id="Xpress1" width="192" height="192" align="middle">
					<PARAM NAME="_ExtentX" VALUE="5080">
					<PARAM NAME="_ExtentY" VALUE="5080">					
					<PARAM NAME="ErrStr" VALUE="7V0000M0000-X0306MPXET">
					<PARAM NAME="ErrCode" VALUE="57566898">
					<PARAM NAME="ErrInfo" VALUE="1704862304">
					<PARAM NAME="Persistence" VALUE="7980">
					<PARAM NAME="_cx" VALUE="1952671082">
					<PARAM NAME="_cy" VALUE="0">
					<PARAM NAME="Font" VALUE="MS Sans Serif">
					<PARAM NAME="BackColor" VALUE="2147483663">
					<PARAM NAME="ScrollBarLargeChangeH" VALUE="10">
					<PARAM NAME="ScrollBarSmallChangeH" VALUE="1">
					<PARAM NAME="OLEDropMode" VALUE="0">
					<PARAM NAME="ScrollBarLargeChangeV" VALUE="10">
					<PARAM NAME="ScrollBarSmallChangeV" VALUE="1">
					<PARAM NAME="DisplayProgressive" VALUE="-1">
					<PARAM NAME="SaveTIFByteOrder" VALUE="0">
					<PARAM NAME="LoadRotated" VALUE="0">
					<PARAM NAME="FTPUserName" VALUE="">
					<PARAM NAME="FTPPassword" VALUE="">
					<PARAM NAME="ProxyServer" VALUE="">
				</object>
				<OBJECT id=TwainPRO1 classid="clsid:12B127F7-CC36-4A39-A334-AA39689155CE VIEWASTEXT">
					<PARAM NAME="ErrStr" VALUE="7V0000M0000-X0306MPXET">
					<PARAM NAME="ErrCode" VALUE="57566898">
					<PARAM NAME="ErrInfo" VALUE="1704862304">
					<PARAM NAME="_cx" VALUE="847">
					<PARAM NAME="_cy" VALUE="847">
					<PARAM NAME="Caption" VALUE="">
					<PARAM NAME="ForeColor" VALUE="1163087439">
					<PARAM NAME="Font" VALUE="MS Sans Serif">
					<PARAM NAME="ProductName" VALUE="">
					<PARAM NAME="ProductFamily" VALUE="">
					<PARAM NAME="Manufacturer" VALUE="">
					<PARAM NAME="VersionInfo" VALUE="">
					<PARAM NAME="MaxImages" VALUE="-1">
					<PARAM NAME="ShowUI" VALUE="-1">
					<PARAM NAME="SaveJPGLumFactor" VALUE="32">
					<PARAM NAME="SaveJPGChromFactor" VALUE="36">
					<PARAM NAME="SaveJPGSubSampling" VALUE="2">
					<PARAM NAME="SaveJPGProgressive" VALUE="0">
					<PARAM NAME="PICPassword" VALUE="">
					<PARAM NAME="FTPUserName" VALUE="">
					<PARAM NAME="FTPPassword" VALUE="">
					<PARAM NAME="ProxyServer" VALUE="">
					<PARAM NAME="SaveTIFCompression" VALUE="0">
					<PARAM NAME="SaveMultiPage" VALUE="0">
					<PARAM NAME="CaptionLeft" VALUE="0">
					<PARAM NAME="CaptionTop" VALUE="0">
					<PARAM NAME="CaptionWidth" VALUE="0">
					<PARAM NAME="CaptionHeight" VALUE="0">
					<PARAM NAME="ShadowText" VALUE="-1">
					<PARAM NAME="ClipCaption" VALUE="0">
					<PARAM NAME="HAlign" VALUE="0">
					<PARAM NAME="VAlign" VALUE="0">
					<PARAM NAME="EnableExtCaps" VALUE="-1">
					<PARAM NAME="CloseOnCancel" VALUE="-1">
					<PARAM NAME="TransferMode" VALUE="0">
				</OBJECT>
			</td>
			<%
			if ( oldFileExists.equals( "1" ) )
				out.println( "<td><img name='oldPhoto' src='" + httpPath + file + "'></td>" ) ;
			else
				out.println( "<td><img name='oldPhoto' src='" + httpPath + "blank.jpg" + "'></td>" ) ;
			%>
		</tr>
	</table>

				
					<input type="hidden" name="file" id="file" value="<%= file %>">
					<input type="hidden" name="oldFileExists" id="oldFileExists" value="<%= oldFileExists %>">
					<input type="hidden" name="httpPath" id="httpPath" value="<%= httpPath %>">
					<input type="hidden" name="oldFile" id="oldFile" value="<%= oldFile %>">
					<input type="hidden" name="showUI" id="showUI" value="<%= showUI %>">
	</center>
</body>

<%
	try {
		if ( rs != null ) rs.close() ;
		if ( pstmt != null ) pstmt.close() ;
	} catch ( Exception e ) {}
}catch(Exception e){out.println(e);}
finally{
if(con!=null)
	ConnectionManager.returnConnection(con,request);
}
%>

