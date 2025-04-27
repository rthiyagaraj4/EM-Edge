<%
/*
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------
10/16/2023   32902      Twinkle Shah    	    Ramesh Goli      MMS-DM-CRF-0210
--------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="java.sql.*,eCA.*,webbeans.eCommon.*,java.io.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>  
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<HTML>
<HEAD>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<title>Audit Trail</title>
<style type="text/css">
	TD.gridData1
	{
		background-color: #FFFFFF;
		height:18px;
		font-family: Verdana, Arial, Helvetica, sans-serif;
		font-size: 8pt;
		color: #000000;
		font-weight:normal;
		text-align:center;
		padding-left:10px;
		padding-right:10px;
		vertical-align:middle;
		border-bottom:1px;
		border-top:0px;
		border-left:0px;
		border-right:0px;
		border-style:solid;
		border-color:#EEEEEE;
	}
	</style>
</head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

Connection		con = null;
PreparedStatement pstmt = null;
ResultSet		rs = null;

String	patient_id		=	(request.getParameter("patient_id")==null?"":request.getParameter("patient_id"));
String	encounter_id	=	(request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id"));	
String	facility_id		=	(request.getParameter("facility_id")==null?"":request.getParameter("facility_id"));	
String or_bean_id 		= "@ConsultationTaggingBean";
String or_bean_name 	= "eCA.ConsultationTaggingBean";
ConsultationTaggingBean bean= (ConsultationTaggingBean)getBeanObject( or_bean_id, or_bean_name, request ) ;
ArrayList  historyData = bean.getConsultationTagHistoryDtl(facility_id,patient_id,encounter_id);
%>

<form name="ViewAuditTrailForm" id="ViewAuditTrailForm">
<table border='0' cellspacing="0"  width='100%'>
<tr>
<td class='PANELTOOLBAR' colspan='2' align='center'><fmt:message key="Common.AuditTrail.label" bundle="${common_labels}"/>&nbsp;Consultation Tagging</td>
</tr>
</table>
<table border='0' cellspacing="0" width='100%'>
<tr>
<th NOWRAP width='26%' class='columnheadercenter' ><fmt:message key="eCA.TaggedPractitioner.label" bundle="${ca_labels}"/>&nbsp;Name</th>
<th NOWRAP width='16%' class='columnheadercenter' ><fmt:message key="Common.startdatetime.label" bundle="${common_labels}"/></th>
<th NOWRAP width='16%' class='columnheadercenter' ><fmt:message key="Common.enddatetime.label" bundle="${common_labels}"/></th>
<th NOWRAP width='11%' class='columnheadercenter' >Action</th>
<th NOWRAP width='11%' class='columnheadercenter' >Done By</th>
<th NOWRAP width='16%'><fmt:message key="Common.ActionDateTime.label" bundle="${common_labels}"/></th>
</tr>
</table>
<div style="height: 178px; overflow-y: scroll ; ">
<table class='grid' border='0' cellspacing="0"  width='100%' >
<%
		try{
			if(historyData.size()>0){
				for(int i=0;i<historyData.size();){
					ArrayList histData = (ArrayList)historyData.get(i);
			 %>
			 <TR>
				<TD NOWRAP width='26%' class='gridData'><%=histData.get(0)%></TD>
				<TD NOWRAP width='16%' class='gridData'><%=histData.get(1)%></TD>
				<TD NOWRAP width='16%' class='gridData'><%=histData.get(2)%></TD>
				<TD NOWRAP width='11%' class='gridData'><%=histData.get(3)%></TD>
				<TD NOWRAP width='11%' class='gridData'><%=histData.get(4)%></TD>
				<TD NOWRAP width='16%' class='gridData'><%=histData.get(5)%></TD>
			</TR>
			 <%
			 i++;
		}
	}
%>
</table>
</div>
<table border='0' width='100%'>
<tr>
<td class='PANELTOOLBAR'>&nbsp;</td>
</tr>
<tr>
<td  class="button" ><input type="button" name="closeWindow" id="closeWindow" value = '<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' onclick="window.close()"/></td>
</tr>
</table>
</form>
</body>
<%
	}catch(Exception ex){
		out.println(ex);
		ex.printStackTrace();
	}finally{
		if(pstmt!=null)pstmt.close();
		if(rs!=null)rs.close();
		ConnectionManager.returnConnection(con,request);
	}%>
</html>

