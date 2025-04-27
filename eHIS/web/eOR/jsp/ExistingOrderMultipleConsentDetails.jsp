<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*,eOR.*,eOR.Common.*,webbeans.eCommon.*,java.sql.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<%-- Mandatory declarations end --%>

<html>
<title>
<%
String order_catalog_desc=request.getParameter("order_catalog_desc")==null?"":request.getParameter("order_catalog_desc");
%>
<fmt:message key="eOR.ConsentRequiredfor.label" bundle="${or_labels}"/>- <%=order_catalog_desc%>
</title>
<style>
TD.QRYEVEN1{
    BACKGROUND-COLOR: #F0F0F2;  
	FONT-SIZE: 9pt ;
	BORDER-STYLE: none;
	border-left-color: #B2B6D7;
	border-right-color: #B2B6D7;
	border-top-color: #E2E3F0;
	border-bottom-color: #E2E3F0;
	height:18;	

       }

TD.QRYODD1{
	FONT-SIZE: 9pt ;
    BACKGROUND-COLOR: #E2E3F0;  
	BORDER-STYLE: none;
	border-left-color: #B2B6D7;
	border-right-color: #B2B6D7;
	border-top-color: #E2E3F0;
	border-bottom-color: #E2E3F0;
	height:18;	
	
    }
</style>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../js/ConsentOrder.js"></script>
	<script language="JavaScript" src="../../eOR/js/ExistingOrder.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String bean_id = "Or_ConsentOrders" ;
	String bean_name = "eOR.ConsentOrders";
	ConsentOrders bean		= (ConsentOrders)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	String order_id = request.getParameter("order_id");
	order_id = (order_id == null) ? "":order_id;
	String order_line_num = request.getParameter("order_line_num");
	order_line_num = (order_line_num == null) ? "":order_line_num;
	String consent_ref_id = request.getParameter("consent_ref_id");
	consent_ref_id = (consent_ref_id == null) ? "":consent_ref_id;
	//String consent_name = request.getParameter("consent_name");
	//consent_name = (consent_name == null) ? "":consent_name;
	//out.println("order_id = > "+order_id);
	String consentid = request.getParameter("consentid");
	consentid = (consentid == null) ? "":consentid;
	String consent_name = bean.getConsentDescription(consentid);	
	String RecordBy = request.getParameter("RecordBy");
	RecordBy = (RecordBy == null) ? "":RecordBy;
	String RecordedDate = request.getParameter("RecordedDate");
	RecordedDate = (RecordedDate == null) ? "":RecordedDate;
	String LastRecordedBy = request.getParameter("LastRecordedBy");
	LastRecordedBy = (LastRecordedBy == null) ? "":LastRecordedBy;
	String LastRecordedDate = request.getParameter("LastRecordedDate");
	LastRecordedDate = (LastRecordedDate == null) ? "":LastRecordedDate;
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		//[IN031032] Start 17/05/2012
		/*String sqlStmt = "SELECT am_get_desc.am_practitioner(A.TAKEN_PRACT_ID,?,'1') prac_name FROM "+
						 "OR_CONSENT_REF_HDR A,OR_CONSENT_REF_DTL B WHERE A.CONSENT_REF_ID = B.CONSENT_REF_ID "+ 
						 "AND B.ORDER_ID = ?";	
		*/				 
		String sqlStmt = "SELECT am_get_desc.am_practitioner(A.TAKEN_PRACT_ID,?,'1') prac_name FROM "+
						 "OR_CONSENT_REF_HDR A,OR_CONSENT_REF_DTL B WHERE A.CONSENT_REF_ID = B.CONSENT_REF_ID "+ 
						 "AND B.ORDER_ID = ? AND B.CONSENT_REF_ID =?";
		//[IN031032] End 17/05/2012
		try 
		{
			connection = ConnectionManager.getConnection() ;
			//pstmt = connection.prepareStatement("SELECT am_get_desc.am_practitioner(ord_pract_id,?,'1') prac_name FROM or_order_line WHERE order_id=?") ;
			pstmt = connection.prepareStatement(sqlStmt) ;
			pstmt.setString( 1, localeName);
			pstmt.setString( 2, order_id);
			pstmt.setString( 3, consent_ref_id);  //[IN031032] 17/05/2012
			resultSet = pstmt.executeQuery() ;

			while( resultSet != null && resultSet.next() ) 
			{
				RecordBy = resultSet.getString("prac_name")	;
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			resultSet.close();
			pstmt.close();
			connection.close();
		}


	%>
<form method="post" name="multiple_consent_form_details" id="multiple_consent_form_details">
<table cellpadding=0 cellspacing=0 border=0 width="100%" height="100%" align=center>
<tr><td class='columnheadercenter' colspan="7"><%=consent_name%></td></tr>
<tr>
		<td class='CAHIGHERLEVELCOLOR' style='border-right:0px;border-left:0px' colspan=''><B><fmt:message key="Common.RecordedBy.label" bundle="${common_labels}"/>:&nbsp;<label id='before_release'><%=RecordBy%></label></B></td>
		<td class='CAHIGHERLEVELCOLOR' style='border-right:0px;border-left:0px' colspan=''><B><fmt:message key="eOR.RecordedDate.label" bundle="${or_labels}"/>:&nbsp;<label id='before_release'><%=com.ehis.util.DateUtils.convertDate(RecordedDate,"DMYHMS","en",localeName)%></label></B></td>
		
</tr>
<!--<tr>
		<td class='CAHIGHERLEVELCOLOR' style='border-right:0px;border-left:0px' colspan=''><B><fmt:message key="eOR.LastRecordedBy.label" bundle="${or_labels}"/>:&nbsp;<label id='before_release'><%=LastRecordedBy%></label></B></td>
		<td class='CAHIGHERLEVELCOLOR' style='border-right:0px;border-left:0px' colspan=''><B><fmt:message key="eOR.LastRecoredDate.label" bundle="${or_labels}"/>:&nbsp;<label id='before_release'><%=com.ehis.util.DateUtils.convertDate(LastRecordedDate,"DMYHMS","en",localeName)%></label></B></td>
</tr>-->
</table>
</form>
</body>
</html>

