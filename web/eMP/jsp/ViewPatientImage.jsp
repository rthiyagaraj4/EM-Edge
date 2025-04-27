<!DOCTYPE html>
<%@ page import="java.sql.*,java.io.*,org.apache.commons.codec.binary.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%
		String patient_id="";
		//int BrowserVersion=0;
		String pat_photo_in_db_yn = "" ;
		String pat_photo_http_path = "" ;
		Connection con = null;
		String locale = (String)(session.getAttribute("LOCALE")==null?"en":session.getAttribute("LOCALE"));
//		String height="";
	//	String width="";
		String title="";
	try
	{		
		request.setCharacterEncoding("UTF-8");
		//BrowserVersion = Integer.parseInt(request.getParameter("BrowserVersion")==null?"6":request.getParameter("BrowserVersion"));
		patient_id = request.getParameter("patient_id");
		patient_id = (patient_id == null)?"":patient_id;
		title = request.getParameter("title");
		 title = (title == null)?"":title;
		/*
			if(BrowserVersion<=6){
				height="250";
				width="250";
			}else{
				height="170";
				width="180";
			}			
		*/		
		if(patient_id.length() == 0){%>
			<script language="JavaScript">
				alert("APPIMG004 - Invalid Patient ID ...");
			</script><%
			out.flush();
			return;
		}
		con = ConnectionManager.getConnection(request);
		java.sql.Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("Select pat_photo_os_path, pat_photo_http_path from sm_db_info");
		if(rs != null && rs.next()){			
			pat_photo_http_path = rs.getString("pat_photo_http_path");
		}
		rs.close();	
		rs = stmt.executeQuery("Select pat_photo_in_db_yn from mp_patient where patient_id = '"+patient_id+"'");
		if(rs != null && rs.next()){
			pat_photo_in_db_yn = rs.getString("pat_photo_in_db_yn");
		}
		rs.close();		
		boolean flag = true ;
		byte [] byteArr = null;			
		if(pat_photo_in_db_yn.equalsIgnoreCase("N")){			
			//String path = getServletConfig().getServletContext().getRealPath("/")+pat_photo_http_path+patient_id+".jpg";
			String path = pat_photo_http_path+patient_id+".jpg";
			File f = new File(path);				
			if(f.exists()){
				FileInputStream fis = new FileInputStream(f);
				byteArr = new byte[(int)f.length()];
				fis.read(byteArr,0,byteArr.length);
				fis.close();
			}else{%>
				<script language="JavaScript">
					alert("APPIMG002 - Patient Image Not Uploaded To The File System...");
					parent.window.close();
					
				</script>
				<%
					flag = false;
			}
		}else if(pat_photo_in_db_yn.equalsIgnoreCase("Y")){			
			rs = stmt.executeQuery("Select PAT_PHOTO_BLOB from MP_PATIENT_PHOTO where PATIENT_ID='"+patient_id+"'");
			if(rs != null && rs.next()){
				Blob pat_photo_blob = rs.getBlob("PAT_PHOTO_BLOB");				
				byteArr = pat_photo_blob.getBytes(1,(int)pat_photo_blob.length());				
			}else{
				%>
				<script language="JavaScript">
					alert("APPIMG003 - Patient Image Not Uploaded Into The Database...");
				</script>
				<%
					flag = false;
			}
			if(rs != null)rs.close();
		}else{%>
			<script language="JavaScript">
				alert("APPIMG001 - Image Parameter In SM_DB_INFO Table Not Set...");
			</script>
			<%
				flag = false;
		}			
		if(stmt != null)stmt.close();
		String encoded = "";		
		if(flag)
		encoded = new String((new Base64()).encode(byteArr));		
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<script>
var localeName = "<%=locale%>";
function loadfun(){	
	//document.title=getLabel("eMP.photo.label","MP" );	 
	var patient_id = document.getElementById("patient_id").value
	var pat_photo_in_db_yn = document.getElementById("pat_photo_in_db_yn").value
	var pat_photo_http_path = document.getElementById("pat_photo_http_path").value	
	document.getElementById("PAT_PHOTO").innerHTML="<img id='patient_photo' src='../../eMP/jsp/PaintImage.jsp?patient_id="+patient_id+"&pat_photo_in_db_yn="+pat_photo_in_db_yn+"&pat_photo_http_path="+pat_photo_http_path+"' height = '170' width = '180' >";		
}
</script> 
<!-- <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta name="Generator" content="EditPlus">
<meta name="Author" content="">
<meta name="Keywords" content="">
<meta name="Description" content=""> -->
<script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 
 <title><%=title%></title> 
</head>
<body onload="loadfun()" onKeyDown='lockKey()' marginwidth="0" marginheight="0" leftmargin="0" topmargin="0">
<form  STYLE="margin: 0px; padding: 0px;">
<table align=center >
<tr>	
	<td align="center" id="PAT_PHOTO"></td>
</tr>
</table>
<input type = 'hidden' name = 'patient_id' id='patient_id' value = <%=patient_id%>>
<input type = 'hidden' name = 'pat_photo_http_path' id ='pat_photo_http_path'  value = <%=pat_photo_http_path%>>
<input type = 'hidden' name = 'pat_photo_in_db_yn' id='pat_photo_in_db_yn' value = <%=pat_photo_in_db_yn%>>
</form>
</body>
</html>
<%}catch(Exception exc){
		exc.printStackTrace();
	}finally{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>

