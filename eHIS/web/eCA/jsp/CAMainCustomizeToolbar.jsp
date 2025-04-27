<!DOCTYPE html>
<%@ page import="java.sql.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	webbeans.eCommon.RecordSet CustomizeIcons = (webbeans.eCommon.RecordSet)getObjectFromBean("CustomizeIcons","webbeans.eCommon.RecordSet",session);
%>


<html>
<head>
<title><fmt:message key="eCA.CustomizeIcons.label" bundle="${ca_labels}"/></title>
<%
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src='../../eCommon/js/ValidateControl.js'></script>
	<script src='../../eCommon/js/common.js'></script>
	<script src='../js/CAMenu.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 <style>
TR.DISPHEADER 
{
   	background-position:top;
	background-color:#D3E2E6;
    color: black;
}
TABLE.DISPHEADER 
{
    
	background-position:top;
	background-color:#D3E2E6;
    color: black;
}
FRAME.DISPHEADER 
{
    
	background-position:top;
	background-color:#D3E2E6;
    color: black;
}
</style>  
</head>
	
<%	
	String practitioner_id	= (String) session.getValue("ca_practitioner_id");
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String menu_id = request.getParameter("menuId")==null?"MED_DFLT":request.getParameter("menuId");
	//String patientclass = request.getParameter("patientclass")==null?"":request.getParameter("patientclass");
	//String mode = request.getParameter("mode")==null?"V":request.getParameter("mode");
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Connection con = null;

	//String facility_id = (String)session.getValue("facility_id");
	String occurance = request.getParameter("occurance");

	if(occurance == null) {
			occurance = "";
			CustomizeIcons.clearAll();
		}

	try
	{
		con = ConnectionManager.getConnection(request);
		String option_id	= "";
		String checkStatus  = "";
		StringBuffer sql = new StringBuffer();
		StringBuffer strOption = new StringBuffer();
		boolean Self_menu_exists = false;

		strOption.append("SELECT '1' FROM ca_custom_option a WHERE practitioner_id = ? and exists (select '1' from ca_option where option_id = a.option_id AND DESKTOP_YN = ? )AND ROWNUM=1");
		pstmt = con.prepareStatement(strOption.toString());
		pstmt.setString(1,practitioner_id);
		if(!patient_id.equals(""))
			pstmt.setString(2,"N");
		else
			pstmt.setString(2,"Y");
	
		rs = pstmt.executeQuery();
		if(rs.next())
		{
			Self_menu_exists = true;
		}
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		
		sql.append("select A.OPTION_ID ");

		if(Self_menu_exists)
			sql.append(",  NVL((select 'Y' from ca_custom_option where practitioner_id = ? and option_id = a.option_id),'N') checked ");
		else
			sql.append("  , a.Dflt_toolbar_option_yn checked ");			

		sql.append(" from ca_option a, CA_MENU_DETAIL b where ");

		if(!patient_id.equals(""))
		{
			sql.append(" a.DESKTOP_YN = 'N' ");
		}
		else
		{
			sql.append(" a.DESKTOP_YN = 'Y' ");
		}
		sql.append(" and b.MENU_ID = ? and b.option_id = a.option_id and a.ICON_FILE_NAME is not null");

		pstmt = con.prepareStatement(sql.toString());
	
		if(Self_menu_exists)
		{
			pstmt.setString(1,practitioner_id);
			pstmt.setString(2,menu_id);
		}
		else
			pstmt.setString(1,menu_id);
		rs = pstmt.executeQuery();
		
		while(rs.next())
		{
			option_id = rs.getString("OPTION_ID")==null?"":rs.getString("OPTION_ID");
			checkStatus = rs.getString("checked")==null?"":rs.getString("checked");



			if(checkStatus.equals("Y"))
			{
				if(!(CustomizeIcons.containsObject(option_id))){
					CustomizeIcons.putObject(option_id);
				}
			}
		}
		putObjectInBean("CustomizeIcons", CustomizeIcons,session);
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
	}
	catch(Exception e)
	{
		e.printStackTrace(System.err);
	}
	finally
	{
		if(con != null) ConnectionManager.returnConnection(con,request);
	}
%>
	<iframe name="detailFrame" id="detailFrame" SRC="../../eCA/jsp/CAMainCustomizeToolbarDtl.jsp?<%=request.getQueryString()%>"  frameborder="no" scrolling="no" noresize style="height:75vh;width:100vw"></iframe>
	<iframe name="buttonFrame" id="buttonFrame" frameborder="no" scrolling="no" noresize src="../../eCA/jsp/CAMainCustomizeButton.jsp?<%=request.getQueryString()%>" style="height:7vh;width:100vw"></iframe>
	<iframe name="messageFrame" id="messageFrame" frameborder="no" scrolling="no" noresize src="../../eCommon/jsp/error.jsp" style="height:0vh;width:100vw"></iframe> 
	

</html>

