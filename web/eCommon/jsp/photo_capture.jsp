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
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>

	<title>Capture Photo</title>

	<link rel='stylesheet' type ='text/css' href='../html/IeStyle.css'></link>

	<script language="JavaScript">
		function connectButton_click() {
			capturePro.connect( 0 ) ;
		}

		function previewButton_click() {
			capturePro.preview = 1 ;
		}

		function captureButton_click() {
			// By sbchand start on 21st Oct, 2002
			// Changed by hari on 31/07/2003 
            // Update sm_db_info table before using this page.
			
			var file = capture_form.ftpPath.value + capture_form.file.value ;

            //var file ="ftp://192.5.2.201/ephoto/" + capture_form.file.value ;
			var oldFileExists = capture_form.oldFileExists.value ;
			var httpPath = capture_form.httpPath.value ;

			capturePro.frameFile = file ;

			//Added by hari , create a FTP user with this username and password
			// this user should have access to the folder ftp://<server-ip>/ephoto
			// this ephoto is a simlink or shortcut to eHIS/webmob/web/pat_photo

            capturePro.FTPUserName ="ephoto";
            capturePro.FTPPassword ="ephoto";
            capturePro.captureFrame() ;

			document.getElementById("oldPhoto").src = httpPath + capture_form.file.value ;
		}

		function disconnectButton_click() {
			capturePro.disconnect() ;
			window.close() ;
		}

		function videoFormatButton_click() {
			if ( capturePro.hasDlgVideoFormat )
				capturePro.showVideoFormatDlg() ;
		}

		function videoSourceButton_click() {
			if ( capturePro.HasDlgVideoSource )
				capturePro.showVideoSourceDlg() ;
		}

		function videoCompressButton_click() {
			capturePro.showVideoCompressionDlg() ;
		}

		function changeButtonColors() {
			document.getElementById("connectButton").style.background="navy" ;
			document.getElementById("connectButton").style.color="white" ;
			document.getElementById("connectButton").style.fontWeight="700" ;
			document.getElementById("connectButton").style.borderStyle="solid" ;
/*
			document.getElementById("previewButton").style.background="navy" ;
			document.getElementById("previewButton").style.color="white" ;
			document.getElementById("previewButton").style.fontWeight="700" ;
			document.getElementById("previewButton").style.borderStyle="solid" ;
*/
			document.getElementById("captureButton").style.background="navy" ;
			document.getElementById("captureButton").style.color="white" ;
			document.getElementById("captureButton").style.fontWeight="700" ;
			document.getElementById("captureButton").style.borderStyle="solid" ;

			document.getElementById("disconnectButton").style.background="navy" ;
			document.getElementById("disconnectButton").style.color="white" ;
			document.getElementById("disconnectButton").style.fontWeight="700" ;
			document.getElementById("disconnectButton").style.borderStyle="solid" ;
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
	//String path = "" ;
	String httpPath = "" ;
	String oldFile = "" ;
	String oldFileExists = "0" ;
	// By sbchand start on 21st Oct, 2002
	String ftpPath = "" ;
	// By sbchand end on 21st Oct, 2002

	if ( file == null ) file = "patient" ;
//	file = file + ".jpg" ;

//	con = (Connection) session.getValue( "connection" ) ;
con=ConnectionManager.getConnection(request);
	// By sbchand start on 21st Oct, 2002
	// pstmt = con.prepareStatement( "select pat_photo_os_path, pat_photo_http_path from sm_db_info" ) ;
	pstmt = con.prepareStatement( "select pat_photo_os_path, pat_photo_ftp_path, pat_photo_http_path from sm_db_info" ) ;
	// By sbchand end on 21st Oct, 2002
	rs = pstmt.executeQuery() ;

	if ( rs != null && rs.next() ) {
		//path = rs.getString( "pat_photo_os_path" ) ;
		httpPath = rs.getString( "pat_photo_http_path" ) ;
		// By sbchand start on 21st Oct, 2002
		ftpPath = rs.getString( "pat_photo_ftp_path" ) ;
		// By sbchand end on 21st Oct, 2002
	}

	// By sbchand start on 21st Oct, 2002
	// oldFile = path + file ;
	oldFile = ftpPath + file ;
	// By sbchand end on 21st Oct, 2002

	try {
		File f = new File( oldFile ) ;
		if ( f.exists() )
			oldFileExists = "1" ;
	} catch ( Exception e ) {}
%>

<body onLoad="changeButtonColors();connectButton_click();" OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
	<center>

	<br>
	<br>

	<table>
		<tr>
		<%
			if ( oldFileExists.equals( "1" ) )
				out.println( "<td><img name='oldPhoto' src='" + httpPath + file + "'></td>" ) ;
			else
				out.println( "<td><img name='oldPhoto' src='" + httpPath + "blank.jpg" + "'></td>" ) ;
		%>

<!--	<p>
-->
			<td>
				<object classid="clsid:CC34CEBF-5C10-11D1-A40F-00A024229C83" id="capturePro" width="192" height="192" align="middle">
					<param name="_ExtentX" value="5080">
					<param name="_ExtentY" value="5080">
					<param name="ErrStr" value="6E500050GEP-BB301RPACP">
					<param name="ErrCode" value="1603420513">
					<param name="ErrInfo" value="1367446139">
					<param name="BorderVisible" value="1">
					<param name="BorderWidth" value="1">
					<param name="Enabled" value="1">
					<param name="Caption" value>
					<param name="ForeColor" value="0">
					<param name="Preview" value="1">
					<param name="FrameFile" value="">
					<param name="SaveJPGChromFactor" value="36">
					<param name="SaveJPGProgressive" value="0">
					<param name="SaveJPGLumFactor" value="32">
					<param name="PICPassword" value>
					<param name="AutoSave" value="0">
					<param name="Interval" value="60000">
					<param name="PreviewRate" value="15">
					<param name="CaptionLeft" value="0">
					<param name="CaptionTop" value="0">
					<param name="CaptionWidth" value="0">
					<param name="CaptionHeight" value="0">
					<param name="ShadowText" value="1">
					<param name="ClipCaption" value="0">
					<param name="StreamFile" value>
					<param name="FrameRate" value="15">
					<param name="Yield" value="0">
					<param name="CaptureAudio" value="0">
					<param name="TimeLimit" value="0">
					<param name="AudioChannels" value="1">
					<param name="AudioBits" value="8">
					<param name="AudioSampleRate" value="11025">
					<param name="FTPUserName" value>
					<param name="FTPPassword" value>
					<param name="SaveJPGSubSamling" value="2">
					<param name="AutoIncrement" value="0">
					<param name="HAlign" value="0">
					<param name="VAlign" value="0">
					<param name="ProxyServer" value>
					<param name="Overlay" value="1">
					<param name="FTPRename" value="0">
					<param name="ResX" value="0">
					<param name="ResY" value="0">
				</object>
			</td>
<!--	</p>
-->
		</tr>
	</table>

				<form name="capture_form" id="capture_form">
					<input type="button" value="Connect" 			name="connectButton" id="connectButton" 		onClick="connectButton_click()">

<!--					<input type="button" value="Click Again"			name="previewButton" id="previewButton"		onClick="previewButton_click()">
-->
					<input type="button" value="Click" 				name="captureButton" id="captureButton" 		onClick="captureButton_click()">
					<input type="button" value="Close" 				name="disconnectButton" id="disconnectButton" 	onClick="disconnectButton_click()">

<!--					<input type="button" value="Video Format..." 		name="videoFormatButton" id="videoFormatButton" 	onClick="videoFormatButton_click()">
					<input type="button" value="Video Source..." 		name="videoSourceButton" id="videoSourceButton" 	onClick="videoSourceButton_click()">
					<input type="button" value="Video Compression..." 	name="videoCompressButton" id="videoCompressButton" 	onClick="videoCompressButton_click()">
-->
					<input type="hidden" name="file" id="file" value="<%= file %>">
					<input type="hidden" name="oldFileExists" id="oldFileExists" value="<%= oldFileExists %>">
					<input type="hidden" name="httpPath" id="httpPath" value="<%= httpPath %>">

					<!-- By sbchand start on 21st Oct, 2002 -->
					<input type="hidden" name="ftpPath" id="ftpPath" value="<%= ftpPath %>">
					<!-- By sbchand end on 21st Oct, 2002 -->
				</form>

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

