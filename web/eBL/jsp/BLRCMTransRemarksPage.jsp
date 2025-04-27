<!DOCTYPE html>
<%@page import="java.sql.Date"%>
<%@ page import ="eBL.*,eBL.Common.*,java.sql.*,java.sql.PreparedStatement,java.sql.ResultSet,java.sql.Connection,java.math.*,java.net.*,java.text.*,webbeans.eCommon.*,org.apache.commons.codec.binary.Base64"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
			
%>
<%
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rst=null;
	try
	{
		con=ConnectionManager.getConnection(request);
		
		String sql = "";
		int row_cnt = 0;
		String called_from = checkForNull(request.getParameter("called_from"));
		String appr_doc_type_code = checkForNull(request.getParameter("appr_doc_type_code"));
		String appr_doc_num = checkForNull(request.getParameter("appr_doc_num"));
		String appr_doc_ref_num = checkForNull(request.getParameter("appr_doc_ref_num"));		
		String bill_doc_type_code = checkForNull(request.getParameter("bill_doc_type_code"));
		String bill_doc_num = checkForNull(request.getParameter("bill_doc_num"));	
		String blng_serv_code = checkForNull(request.getParameter("blng_serv_code"));	
		String facilityId = (String)session.getAttribute("facility_id");
		
		System.err.println("blng_serv_code in Remarks Popup = "+blng_serv_code);
		System.err.println("appr_doc_ref_num in Remarks Popup = "+appr_doc_ref_num);
		System.err.println("bill_doc_type_code in Remarks Popup = "+bill_doc_type_code);
		System.err.println("bill_doc_num in Remarks Popup = "+bill_doc_num);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=request.getParameter("title")%></title>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eBL/js/RCMTransactions.js"></script>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%!
     private String checkForNull(String inputString) {
 		return (inputString == null) ? "" : inputString;
 	}
	
	private String checkForStatus(String inputString) {
 		return (inputString == null) ? "I" : inputString;
 	}
%>
<form name="BLRCMTransRemarksPage" id="BLRCMTransRemarksPage">
	<table class='grid' border='1' width='100%' cellpadding='3'  cellspacing=0 align="center" >  
		<tr>
			<td class='COLUMNHEADER' nowrap  width="10%"><fmt:message key="Common.no.label" bundle="${common_labels}"/>&nbsp;</td>
			<td class='COLUMNHEADER' nowrap  width="50%"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/>&nbsp;</td>
			<td class='COLUMNHEADER' nowrap  width="20%"><fmt:message key="eBL.Status.label" bundle="${bl_labels}"/>&nbsp;</td>
			<td class='COLUMNHEADER' nowrap  width="20%"><fmt:message key="eBL.Date.label" bundle="${bl_labels}"/>&nbsp;</td>
		</tr>
<%
	sql = "SELECT remarks, b.LIST_ELMT_LABEL as claim_status_desc,to_char(a.ADDED_DATE,'dd/MM/yyyy HH24:mi:ss') as ADDED_DATE, a.REMARKS REMARKS "+
				"FROM BL_CLAIM_BILL_SERVICE_LOG a, sm_list_item b "+
				"WHERE a.operating_facility_id = ? " +
				" AND a.INS_STATUS = b.LIST_ELMT_VALUE "+
				" AND b.MODULE_ID = 'BL' "+
				" AND b.LIST_REF = 'L_INS_CLAIM_STATUS' " +
				" AND a.BILL_DOC_TYPE_CODE = ? AND BILL_DOC_NUM = ? ";
				
	if("B".equals(called_from)){
		sql = sql +  "AND BLNG_SERV_CODE is null";
	} else if("S".equals(called_from)){
		sql = sql +  "AND BLNG_SERV_CODE is not null AND BLNG_SERV_CODE = ?";
	}
	sql = sql + " ORDER BY a.ADDED_DATE";
	pstmt = con.prepareStatement(sql);
	System.err.println("sql in remarks popup:"+sql);
	pstmt.setString(1,facilityId);
//	pstmt.setString(2,appr_doc_ref_num);
	pstmt.setString(2,bill_doc_type_code);
	pstmt.setString(3,bill_doc_num);	
	if("S".equals(called_from)){
		pstmt.setString(4,blng_serv_code);
	}
	
	rst = pstmt.executeQuery();		

		while ( rst.next() )
		{
			row_cnt++;
%>
			<tr>
				<td	 class='label'><%=row_cnt%></td> 
				<td  class='label'><%=checkForNull(rst.getString("REMARKS"))%></td> 
				<td  class='label'><%=checkForNull(rst.getString("claim_status_desc"))%></td> 
				<td  class='label'><%=checkForNull(rst.getString("ADDED_DATE"))%></td>
			<tr>	
<%
		}
%>		
	<tr>
		<td colspan=4 align="right">
			<input class='button' type='button' name="close_btn" id="close_btn" id="close_btn" value="Close" onclick="window.close();" >
		</td>
	</tr>
	</table>
</form>
</body>
<%	
		}catch(Exception e){
			out.println("Exception in BLRCMTransRemarksPage.jsp: "+e);
			System.err.println("Exception in BLRCMTransRemarksPage.jsp: "+e);
		}finally{
			if(pstmt!=null)	pstmt.close();
			if(rst!=null)	rst.close();
			ConnectionManager.returnConnection(con,request);		
		}
%>

</html>

