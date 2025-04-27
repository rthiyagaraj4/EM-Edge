<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.io.*, java.sql.*,webbeans.eCommon.*" %>
<%
			request.setCharacterEncoding("UTF-8");	

	String params = request.getQueryString();
	
	String file = request.getParameter( "file" ) ;
	String path = "" ;
	String httpPath = "" ;
	String oldFile = "" ;
	String oldFileExists = "0" ;

	Connection con=ConnectionManager.getConnection(request);
	PreparedStatement pstmt = con.prepareStatement( "select pat_photo_os_path, pat_photo_http_path from sm_db_info" ) ;
	ResultSet rs = pstmt.executeQuery() ;

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
<html>
	<head>
		<link rel='stylesheet' type ='text/css' href='../html/IeStyle.css'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script language="JavaScript">
		var process = "";
			function captureButton_click(){
			   process="webcam";
			   if (document.getElementById("UI").checked == true){
					parent.frames[0].location.href = "photo_capture_webcam.jsp?<%=params%>&showUI=true";
				}else{
					parent.frames[0].location.href = "photo_capture_webcam.jsp?<%=params%>&showUI=false";
				}
			}
			function scanButton_click(){
				process="scanner";
				if (document.getElementById("UI").checked == true){
					parent.frames[0].location.href = "photo_capture_scanner.jsp?<%=params%>&showUI=true";
				}else{
					parent.frames[0].location.href = "photo_capture_scanner.jsp?<%=params%>&showUI=false";
				}	
			}
			function storeButton_click(){
				var file = "ftp://" + document.location.hostname + "/pat_photo/" + document.getElementById("saveFile").value ;
				if (process == "scanner"){
					parent.frames[0].document.getElementById("Xpress1").SaveFileType = 8;
					parent.frames[0].document.getElementById("Xpress1").SaveFileName = file;
					parent.frames[0].document.getElementById("Xpress1").SaveFile();
					parent.frames[0].document.getElementById("oldPhoto").src = document.getElementById("httpPath").value + document.getElementById("saveFile").value ;
					setTimeout("RefreshPage()",2000);	
				}else if (process == "webcam"){
					parent.frames[0].document.getElementById("capturePro").preview=false;
					parent.frames[0].document.getElementById("capturePro").frameFile = file;
					parent.frames[0].document.getElementById("capturePro").captureFrame();
					parent.frames[0].document.getElementById("oldPhoto").src = document.getElementById("httpPath").value + document.getElementById("saveFile").value;
				}
			}
			function RefreshPage(){
				parent.frames[0].RefreshPage();
			}
			function closeButton_click(){
				if (process == "scanner"){
					parent.frames[0].document.getElementById("TwainPRO1").CloseSession();					
				}else if (process == "webcam"){
					parent.frames[0].document.getElementById("capturePro").disconnect() ;			
				}				
				document.parentWindow.close();
			}
		</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onKeyDown = 'lockKey()'>
		<table align=center width='100%' border=0 cellpadding=0 cellspacing=0>
			<tr>
				<td class='label' align=center>
				Show UI &nbsp;&nbsp;<input type="checkbox" name="UI" id="UI">
				</td>
			</tr>
			<tr>
				<td class='label' align=center>
				<input class="button" type="button" value="Capture" 				name="captureButton" id="captureButton" 		onClick="captureButton_click()">
				<input class="button" type="button" value="Scan" 				name="scanButton" id="scanButton" 		onClick="scanButton_click()">
				<input class="button" type="button" value="Store" 				name="storeButton" id="storeButton" 		onClick="storeButton_click()">
				<input class="button" type="button" value="Close" 				name="closeButton" id="closeButton" 		onClick="closeButton_click()">
				</td>
			</tr>
		</table>
		<%
			if ( oldFileExists.equals( "1" ) ){
			 %>
				<input name='oldPhoto' id='oldPhoto' value='<%=httpPath+file%>'>
			 <%	 				
			}else{
			  %>
				<input name='oldPhoto' id='oldPhoto' value='<%=httpPath+"blank.jpg"%>'>
			  <%			
			}				
		%>
		<input name='saveFile' id='saveFile' value='<%=file%>'>
		<input name='httpPath' id='httpPath' value='<%=httpPath%>'>
	</body>
</html>
<%
	rs.close();
	pstmt.close();
	ConnectionManager.returnConnection(con,request);
%>

