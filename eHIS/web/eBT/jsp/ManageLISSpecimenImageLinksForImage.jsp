<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ page import="java.sql.*,java.io.*,webbeans.eCommon.*,java.util.*,com.ehis.util.*" contentType=" text/html;charset=UTF-8"%>
<html>
<html>
<head>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<%
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

String specNum = request.getParameter("specNum") == null ? "0" : request.getParameter("specNum");
String p_resp_id = request.getParameter("p_resp_id") == null ? "" : request.getParameter("p_resp_id");
//Sanjay for removing Delete Option when viewed from Review
String calledFromForms = request.getParameter("calledFromForms") == null ? "" : request.getParameter("calledFromForms");
String facilityId = (String) session.getValue("facility_id") == null ? "" : (String) session.getValue("facility_id");
String applServerURL = "";
String appleHISServerURL = "";
String secCode = "";
String oper_facilityId="";//Added by Nandhini against GHL-SCF-1354 on 26/June/2018

Connection con = null;
PreparedStatement pstmt = null;
ResultSet res = null;
// to get filePath STARTS here
PreparedStatement pstmt1 = null;
ResultSet res1 = null;
PreparedStatement pstmt2 = null;
ResultSet res2 = null;
String filePath = "";
// to get filePath ENDS here
StringBuffer sql = new StringBuffer("select INTERFACE_FILE_ID, to_char(ADDED_DATE,'dd/mm/yyyy hh24:mi:ss') added_date_time from rl_specimen_image_dtls where OPERATING_FACILITY_ID = ? and SPECIMEN_NO = ? ");

String test = "";
String sampleId = "";
String anatomy = "";
int cnt = 1;

try
{
	if(!p_resp_id.equals("RL_MANAGER"))
	con = ConnectionManager.getConnection(request);
	else
	{
		con = ConnectionManager.getConnection();
	}

	//Added by Nandhini against GHL-SCF-1354 on 26/June/2018 
		
			try
			{
			pstmt = con.prepareStatement("SELECT OPERATING_FACILITY_ID FROM rl_request_header where SPECIMEN_NO=? and ORDERED_FACILITY_ID=?");
			pstmt.setString(1,specNum);
			pstmt.setString(2,facilityId);
			res = pstmt.executeQuery();	
		
			if(res.next()  )
			{
				oper_facilityId = res.getString("OPERATING_FACILITY_ID") == null ? "" : res.getString("OPERATING_FACILITY_ID");
				facilityId=oper_facilityId;
				System.out.println("ManageLISSpecimenImageServlet.java facilityId:" +facilityId);
			}
			
			}
			catch(Exception e1)
		{
			System.out.println("Ex1:"+e1);
			if(res != null) res.close();
			if(pstmt != null) pstmt.close();
//Added by Nandhini against GHL-SCF-1354 on 26/June/2018 
		}

	test = request.getParameter("test") == null ? "" : request.getParameter("test");
	sampleId = request.getParameter("sampleId") == null ? "" : request.getParameter("sampleId");
	anatomy = request.getParameter("anatomy") == null ? "" : request.getParameter("anatomy");

	//Added by Sanjay on 17-Mar-15 against ML-BRU-SCF-1502(IN052800)
	secCode = request.getParameter("secCode") == null ? "" : request.getParameter("secCode");	

	String interfaceFileId = "";
	String addedDate = "";
	String classValue = "";

	//int cnt = 1;//Sanjay		
	pstmt = con.prepareStatement("SELECT APP_SERVER_URL FROM RL_EXT_INTERFACE_PARAM where EXT_APPL_ID='LBIMG' ");
	res = pstmt.executeQuery();
	
	while(res.next())
	{
		applServerURL = res.getString("APP_SERVER_URL") == null ? "" : res.getString("APP_SERVER_URL");
	}

	if(res != null) res.close();
	if(pstmt != null) pstmt.close();

	pstmt = con.prepareStatement("SELECT APP_SERVER_URL FROM CA_EXT_INT_PARAM ");
	res = pstmt.executeQuery();
	
	while(res.next())
	{
		appleHISServerURL = res.getString("APP_SERVER_URL") == null ? "" : res.getString("APP_SERVER_URL");
	}

	if(res != null) res.close();
	if(pstmt != null) pstmt.close();

	if(facilityId.equals(""))
	facilityId = request.getParameter("facility_id") == null ? "" : request.getParameter("facility_id");

	if(p_resp_id.equals("RL_MANAGER"))
	{
		%>
		<link rel='StyleSheet' href='<%=appleHISServerURL%>eCommon/html/IeStyle.css' type='text/css' />
		<%
	}
	else
	{
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<%
	}
	//Commented by Sanjay on 17-Mar-15 against ML-BRU-SCF-1502(IN052800)
	// Query to get Section Code STARTS here
	/*
				pstmt1 = con.prepareStatement("select section_code from rl_test_code where TEST_CODE = ?");
				pstmt1.setString(1,test);
				res1 = pstmt1.executeQuery();
				while(res1.next())
				{
					secCode = res1.getString(1) == null ? "" : res1.getString(1);
				}
				if(res1 != null) res1.close();
				if(pstmt1 != null) pstmt1.close();
	*/	
	// Query to get Section Code ENDS here

	// Query to get file path for copying uploaded Image STARTS here
	String sqlFilePath = "select IMAGE_FILE_HOME_IDR from RL_SECTION_CTL where OPERATING_FACILITY_ID = ? and SECTION_CODE = ?";
	pstmt2 = con.prepareStatement(sqlFilePath);
	pstmt2.setString(1,facilityId);	
	pstmt2.setString(2,secCode);
	
	res2 = pstmt2.executeQuery();
	while(res2.next())
	{
		filePath = res2.getString(1) == null ? "" : res2.getString(1);
	}
	if(res2 != null) res2.close();
	if(pstmt2 != null) pstmt2.close();
	// Query to get file path for copying uploaded Image ENDS here	
	filePath = filePath.replace("\\", "/");
	// ENDS

	%>		
	<title><fmt:message key="eBT.ImageLinks.label" bundle="${bt_labels}"/></title>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script src="../../eBT/js/ManageLISSpecimenImage.js" language="javascript"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	</head>
	<body>
	<form name='showImageLinksForm' id='showImageLinksForm'>
	<table border='1' width='100%' cellpadding='1' cellspacing='0' align='center'>
	<tr>
	<td class='CAGROUP' colspan='6'><fmt:message key="eBT.SpecimenNo.label" bundle="${bt_labels}"/> <%=specNum%></td>
	</tr>
	<tr>
	<th align='left'><fmt:message key="eBT.UploadedDate.label" bundle="${bt_labels}"/></th>
	<th align='left'><fmt:message key="eSS.ImagePreview.label" bundle="${ss_labels}"/></th>
	<!--<th align='left'><fmt:message key="eSS.ImagePreview.label" bundle="${ss_labels}"/></th>-->
	<%
	if (!calledFromForms.equalsIgnoreCase("RL_REVIEW")) {
		%>
		<th align='left'>Delete</th>
		<%
	}
	%>
	</tr>	
	
	<%
	if(!test.equals("")) sql.append("  and TEST_CODE = ? ");
	if(!sampleId.equals("")) sql.append(" and SAMPLE_ID = ? ");
	if(!anatomy.equals("")) sql.append(" and ANATOMY_SITE_CODE = ? ");
	sql.append(" order by 2 ");	
	pstmt = con.prepareStatement(sql.toString());
	pstmt.setString(1,facilityId);
	pstmt.setString(2,specNum);
	if(!test.equals(""))
	pstmt.setString(3,test);
	if(!sampleId.equals(""))
	pstmt.setString(4,sampleId);
	if(!anatomy.equals(""))
	pstmt.setString(5,anatomy);
	res = pstmt.executeQuery();

	while(res.next())
	{
		if(cnt % 2 != 0) classValue = "QRYEVEN";
		else classValue = "QRYODD";
		out.println("<tr>");
		interfaceFileId = res.getString("INTERFACE_FILE_ID") == null ? "" : res.getString("INTERFACE_FILE_ID");
		addedDate = res.getString("added_date_time") == null ? "" : res.getString("added_date_time");
		addedDate = DateUtils.convertDate(addedDate,"DMYHMS","en",locale);//added by Sanjay for 10.x conversion
		out.println("<td class='"+classValue+"'>"+addedDate+"</td>");
		//Modified by Sanjay on 17-Mar-15 against ML-BRU-SCF-1502(IN052800)
		out.println("<td class='"+classValue+"'><a style='cursor:pointer;color:blue' onclick=\"javascript:imageView('"+specNum+"','"+test+"','"+sampleId+"','"+secCode+"','"+anatomy+"','"+facilityId+"','"+interfaceFileId+"')\">Image </a></td>");
		//Sanjay for removing Delete Option when viewed from Review
		if (!calledFromForms.equalsIgnoreCase("RL_REVIEW")) {					
			out.println("<td class='"+classValue+"'><input type='checkbox' name='chkavilable"+cnt+"' id='chkavilable"+cnt+"' onClick=chkDelete('"+interfaceFileId+"',this)></td>");
			//out.println("<td class='"+classValue+"'><input type='checkbox' name='chkavilable"+cnt+"' id='chkavilable"+cnt+"'</td>");
		}
		out.println("</tr>");
		cnt++;
	}
	%>
	<!-- <td colspan='2' align='center' width='25%' > -->
	
	<%
	if(res != null) res.close();
	if(pstmt != null) pstmt.close();
}
catch(Exception e)
{
	//System.out.println("Exception in try of ManageLISSpecimenImageLinksForImage.jsp--"+e.toString());
	out.println("Exception in try of ManageLISSpecimenImageLinksForImage.jsp--"+e.toString());
	e.printStackTrace(System.err);
}
finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
	//System.out.println("ManageLISSpecimenImageLinksForImage.jsp");
}
%>
</table>
<input type='hidden' name='applServerURL' id='applServerURL' value='<%=applServerURL%>'>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='cnt' id='cnt' value="<%=cnt%>">
<input type='hidden' name='hdInterfaceFileId' id='hdInterfaceFileId' value="">
<!-- <input type='hidden' name='hdInterfaceFileId1' id='hdInterfaceFileId1' value=""> -->
<input type='hidden' name='params' id='params' value="<%=request.getQueryString()%>"> 
<input type='hidden' name='filePath' id='filePath' value="<%=filePath%>">
</form> 
<!-- added by Sanjay on 08-May-13 for Deleting Image STARTS -->				
<form name='DeleteButton' id='DeleteButton' method='POST' action = '../../eBT/jsp/ManageLISSpecimenImageLinksForImage.jsp'>
<tr></tr>
<tr></tr>
<tr>	<td colspan='4' align='center' width='50%'>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<%
//Condtion added by Sanjay for hiding Apply button when called from review
if (!calledFromForms.equalsIgnoreCase("RL_REVIEW")) {
	%>
	<input type="button" class="button" name="apply" id="apply" value="Apply" onClick="applyAll();">
	<%
}
//added by Sanjay for hiding Apply button when called from review
%>
</td>						
<td colspan='4' align='center' width='50%'>
<input type="button" class="button" name="reset" id="reset" value="Close" 	onClick="resetAll();">
</td>
</tr>				
</form>		
<!-- added by Sanjay on 08-May-13 for Deleting Image ENDS -->

</body>
</html>

