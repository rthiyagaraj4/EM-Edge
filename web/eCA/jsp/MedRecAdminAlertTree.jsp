<!DOCTYPE html>
<%--Author  Archana Kumari Dhal Created on 4/3/2009 --%>
<%@page import="java.sql.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<title><fmt:message key="eCA.SignNotes.label" bundle="${ca_labels}"/></title>	
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	

    <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language='javascript' src='../../eCA/js/MedRecAdminAlert.js'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></SCRIPT>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	Connection con  = null;
	//PreparedStatement pstmt = null;
	PreparedStatement pstmt1 = null;
	//ResultSet rs = null;
	ResultSet rs1 = null;
	try
	{
		con = ConnectionManager.getConnection(request);
		Properties	p			= (Properties)session.getValue("jdbc");		
		String		locale		= (String) p.getProperty("LOCALE");		
		//String		facilityid	= (String) session.getValue("facility_id");		
		String		fromDate	=  request.getParameter("fromDate") == null ? "" : request.getParameter("fromDate");
		String toDate			=	request.getParameter("ToDate") == null ? "" : request.getParameter("ToDate");
		
		if(!localeName.equals("en"))
		{
           fromDate		=	com.ehis.util.DateUtils.convertDate(fromDate,"DMY",locale,"en");
		   toDate	=	com.ehis.util.DateUtils.convertDate(toDate,"DMY",locale,"en");
		}
		
		String group_by = request.getParameter("group_by")==null?"":request.getParameter("group_by");		
		String practitioner_id =request.getParameter("practitioner_id")==null?"":request.getParameter("practitioner_id");		

		if (toDate.equals(""))
			toDate = com.ehis.util.DateUtils.getCurrentDate("DMY",locale);		
		//String sql = "";		
		String desc = "";
		String code = "";
		StringBuffer sql1 =new StringBuffer();
		String gridData = "";
		//int maxRecord = 0;
		int i = 1;
		int sum = 0;
%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='content'>
<form name="MedRecAdminAlertTree_Form" id="MedRecAdminAlertTree_Form">&nbsp;
<table  width="100%" class='grid' align='center' id='tb1'>
 	<!-- <td class='COLUMNHEADERCENTER'><fmt:message key="Common.NoteType.label" bundle="${common_labels}"/></td> -->
 	 <td class='COLUMNHEADERCENTER'><fmt:message key="eCA.AlertCategory.label" bundle="${ca_labels}"/></td> 
	<%	
        /*   sql = "SELECT a.ALERT_CATEG_DESC,a.ALERT_CATEG_CODE FROM CA_ALERT_CATEG_LANG a,CA_ALERT_ACTION_LOG b WHERE a.ALERT_CATEG_CODE=b.ALERT_CATEG_CODE and a.LANGUAGE_ID = ?";
		   pstmt=con.prepareStatement(sql);*/
		sql1.append("SELECT a.ALERT_CATEG_DESC,a.ALERT_CATEG_CODE, Count(*) as total FROM CA_ALERT_CATEG_LANG_VW a,CA_ALERT_ACTION_LOG b WHERE a.ALERT_CATEG_CODE=b.ALERT_CATEG_CODE and  b.ACTION_PEND_DATETIME BETWEEN to_date(?,'DD/MM/YYYY') and To_Date(?,'DD/MM/YYYY') and a.LANGUAGE_ID = ?  "); 			

		 if(!(practitioner_id.equals("")||practitioner_id.equals("null"))){
					sql1.append( "and b.ACTION_BY_USER_ID =? ");
				}	
				
				sql1.append( " GROUP BY a.ALERT_CATEG_DESC,a.ALERT_CATEG_CODE ");
				pstmt1 = con.prepareStatement(sql1.toString());
				pstmt1.setString(1,fromDate);
		        pstmt1.setString(2,toDate);
		        pstmt1.setString(3,locale);
				if(!(practitioner_id.equals("")||practitioner_id.equals("null"))){
					pstmt1.setString(4,practitioner_id);
				}        

		        rs1 = pstmt1.executeQuery();
		  int count=0;
		 		 // pstmt.setString(1,locale);
		 // rs = pstmt.executeQuery();
		 	
			while(rs1!= null && rs1.next())
			{	
				if(i%2 == 0)
					gridData = "QRYEVEN";
				else
					gridData = "QRYODD";
				desc=rs1.getString("ALERT_CATEG_DESC")==null?"":rs1.getString("ALERT_CATEG_DESC");				code=rs1.getString("ALERT_CATEG_CODE")==null?"":rs1.getString("ALERT_CATEG_CODE");				
				count=rs1.getInt("total");		
		
				out.println("<tr><td class='gridData'><a class='gridLink' name='"+i+"' href=\"javascript:filterNShowDetails(this,'"+code+"','"+practitioner_id+"','"+fromDate+"','"+toDate+"')\">"+desc+"</a><b>&nbsp;("+count+")</b></td></tr>");
				i++;
				sum =sum+count;				
			}
			if(i%2 == 0)
					gridData = "QRYEVEN";
			else
					gridData = "QRYODD";	

			out.println("<tr><td class='CAGROUP' ><a class='gridLink' name='"+i+"' href=\"javascript:filterNShowDetails(this,'','"+practitioner_id+"','"+fromDate+"','"+toDate+"')\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+"</a>&nbsp;<b>("+sum+")</td></tr>");			
			
	%>
</table>
<input type="hidden" name="group_by" id="group_by" value="<%=group_by%>">

</form>
</body>
<%	
		// if(rs != null) rs.close();
		 if(rs1 != null) rs1.close();
		//	 if(pstmt != null) pstmt.close();
		 if(pstmt1 != null) pstmt1.close();
	}
	catch (Exception e)
	{
		//out.println(e);//COMMON-ICN-0181
                e.printStackTrace();//COMMON-ICN-0181
	}
	finally   
	{
        if(con!=null)
			ConnectionManager.returnConnection(con,request);
    }

%>
</html>

