<!DOCTYPE html>
<%@page import="java.sql.*,java.io.*,webbeans.eCommon.*,java.util.*,com.ehis.util.*" contentType=" text/html;charset=UTF-8"%>
<html>
<head>		
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>

<%
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");
java.util.Properties p = (Properties) session.getValue("jdbc");
String facilityId = (String) session.getValue( "facility_id" ) ;
String clientIpAddress = p.getProperty("client_ip_address");
String  addedById = p.getProperty( "login_user" );
String sessionId = (String) session.getId();
String appServerURL = "";

Connection con = null;
PreparedStatement pstmt = null;
ResultSet res = null;

// STARTS
PreparedStatement pstmt1 = null;
ResultSet res1 = null;
PreparedStatement pstmt2 = null;
ResultSet res2 = null;
String secCode = "";
String testCode = request.getParameter("test") == null ? "" : request.getParameter("test");
String filePath = "";
String pathExist="";
String writeAccess="";
// ENDS

//Added by Sanjay on 17-Mar-15 against ML-BRU-SCF-1502(IN052800)
secCode = request.getParameter("secCode") == null ? "" : request.getParameter("secCode");
//System.out.println("ManageLISSpecimenImageFileUpload.jsp request.getQueryString:" + request.getQueryString());

try
{
	con = ConnectionManager.getConnection(request);
	pstmt = con.prepareStatement("SELECT APP_SERVER_URL FROM RL_EXT_INTERFACE_PARAM	where EXT_APPL_ID='LBIMG'  ");
	res = pstmt.executeQuery();

	while(res.next())
	{
		appServerURL = res.getString("APP_SERVER_URL") == null ? "" : res.getString("APP_SERVER_URL");
	}

	if(res != null) res.close();
	if(pstmt != null) pstmt.close();

	
	// STARTS
	// Query to get Section Code STARTS here
	/*
				pstmt1 = con.prepareStatement("select section_code from rl_test_code where TEST_CODE = ?");
				pstmt1.setString(1,testCode);
				res1 = pstmt1.executeQuery();
				while(res1.next())
				{
					secCode = res1.getString(1) == null ? "" : res1.getString(1);
				}
				if(res1 != null) res1.close();
				if(pstmt1 != null) pstmt1.close();
				*/
	//System.out.println("ManageLISSpecimenImageFileUpload.jsp secCode:" + secCode);
	// Query to get Section Code ENDS here
	// ENDS

	// Query to get file path for copying uploaded Image STARTS here
	String sqlFilePath = "select IMAGE_FILE_HOME_IDR from RL_SECTION_CTL where OPERATING_FACILITY_ID = ? and SECTION_CODE = ?";
	pstmt2 = con.prepareStatement(sqlFilePath);
	pstmt2.setString(1,facilityId);
	//secCode = "G";//Sanjay
	pstmt2.setString(2,secCode);
	
	res2 = pstmt2.executeQuery();
	while(res2.next())
	{
		filePath = res2.getString(1) == null ? "" : res2.getString(1);
	}
	if(res2 != null) res2.close();
	if(pstmt2 != null) pstmt2.close();
	// Query to get file path for copying uploaded Image ENDS here
	//System.out.println("ManageLISSpecimenImageFileUpload.jsp filePath:" + filePath);
	filePath = filePath.replace("\\", "/");
	String separator = System.getProperty( "file.separator" );
	File f = new File(filePath);
	if(f.exists())
	{
		pathExist="true";
		File file1 = new File(filePath+separator+System.currentTimeMillis()+".txt"); 
		try
		{
			if (file1.createNewFile())
			{
				writeAccess="true";
				file1.delete();
			}
			else
			{
				writeAccess="false";
			}
		}
		catch (IOException e)
        {
			writeAccess="false";
        }
	}
	else
	{
		pathExist="false";
	}
	//System.out.println("ManageLISSpecimenImageFileUpload.jsp filePath after:" + filePath);
	
	
}
catch(Exception e)
{
	//System.out.println("Exception in try of ManageLISSpecimenImageFileUpload.jsp --"+e.toString());
	//out.println("Exception in try of ManageLISSpecimenImageFileUpload.jsp --"+e.toString());
	e.printStackTrace(System.err);
}
finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}

%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<!-- Commented by Sanjay for 10.x conversion --> 
<!-- <script src="../../eCA/js/CAMessages.js" language="javascript"></script> -->
<script language="JavaScript" src="../../eCommon/js/common.js"></script>

<script src="../../eBT/js/ManageLISSpecimenImage.js" language="javascript"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>


		
</head>
<body>
<form name='LISImgFileUploadForm' id='LISImgFileUploadForm' enctype='multipart/form-data'>
<table class='CAGROUP' border='0' width='100%' cellpadding='1' cellspacing='0' align='center'>
<tr>

<td align='right'><input type='file' name='uploadImageFile' id='uploadImageFile'><img src='../../eCommon/images/mandatory.gif'></td>

<td align='right'><input type='button' class='button' name='upload' id='upload' value='<fmt:message key="Common.UploadFile.label" bundle="${common_labels}"/>' onclick='uploadFile()'></td>

</tr>			
</table>
<input type='hidden' name='facilityId' id='facilityId' value='<%=facilityId%>'>
<input type='hidden' name='clientIpAddress' id='clientIpAddress' value='<%=clientIpAddress%>'>
<input type='hidden' name='addedById' id='addedById' value='<%=addedById%>'>
<input type='hidden' name='sessionId' id='sessionId' value='<%=sessionId%>'>
<input type='hidden' name='test' id='test' value='<%=request.getParameter("test")%>'>
<input type='hidden' name='specNum' id='specNum' value='<%=request.getParameter("specNum")%>'>
<input type='hidden' name='anatomy' id='anatomy' value='<%=request.getParameter("anatomy")%>'>
<input type='hidden' name='sampleId' id='sampleId' value='<%=request.getParameter("sampleId")%>'>	 
<input type='hidden' name='filePath' id='filePath' value='<%=filePath%>'>	 
<input type='hidden' name='applServerURL' id='applServerURL' value='<%=appServerURL%>'>	
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='pathExist' id='pathExist' value='<%=pathExist%>'>	
<input type='hidden' name='writeAccess' id='writeAccess' value="<%=writeAccess%>">
</form>
</body>
</html>

