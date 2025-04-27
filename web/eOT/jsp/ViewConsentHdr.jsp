<!DOCTYPE html>
<%@page  import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,java.util.*, eOT.*, eOT.Common.*, eCommon.Common.*,webbeans.eCommon.*,java.sql.*,java.io.*" %>
<%@page  contentType="text/html;charset=UTF-8"%>                             
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

<script Language="JavaScript" src="../../eCommon/js/common.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<html>
<body>
<form name="ViewConsentDtlsForm" id="ViewConsentDtlsForm">
<table cellpadding=3  cellspacing="0" border="0" width="100%" >
<%
	boolean data_available_flag = false;
	String order_id = CommonBean.checkForNull(request.getParameter("order_id")); 

	String sql_order_line = "SELECT ORDER_LINE_NUM FROM OR_ORDER_LINE WHERE ORDER_ID = ? AND ORDER_LINE_STATUS NOT IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE IN ('93','95','96','97','99'))";

	String SQL1 = "SELECT GET_DESC(?,'AM_PRACTITIONER_LANG_VW','SHORT_NAME','PRACTITIONER_ID',C.PRACTITIONER_ID) PRAC_NAME,TO_CHAR(A.TAKEN_DATE_TIME,'DD/MM/YYYY HH24:MI'),GIVEN_PERSON_NAME,FORM_CONTENT FROM OR_CONSENT_REF_HDR A, OR_CONSENT_REF_DTL B,AM_PRACTITIONER C  WHERE A.CONSENT_REF_ID=B.CONSENT_REF_ID AND B.ORDER_ID=? AND B.ORDER_LINE_NUM=? AND B.TYPE ='C' AND A.TAKEN_PRACT_ID = C.PRACTITIONER_ID(+) ORDER BY B.ORDER_LINE_NUM, B.CONSENT_REF_ID";


	String consent_content = "";
	String consent_taken_from="";
	String consent_prac_name = "";
	String consent_date_time="";
	String order_line_num="";
	Clob clob_notes_content = null;
	Connection con = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt_1 = null;
	ResultSet rst = null;
	ResultSet rst_1 = null;
	try{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(sql_order_line);
		pstmt.setString(1,order_id);
		rst = pstmt.executeQuery();
		pstmt_1 = con.prepareStatement(SQL1);
		while(rst.next()){
			order_line_num = rst.getString(1);
			pstmt_1.setString(1,locale);
			pstmt_1.setString(2,order_id);
			pstmt_1.setString(3,order_line_num);
			if(rst_1!=null) rst_1.close();
			rst_1 = pstmt_1.executeQuery();
			while(rst_1.next()){
				data_available_flag = true;
				consent_prac_name = CommonBean.checkForNull(rst_1.getString(1));
				//Added convertDate for 24585 on 10/22/2010 by AnithaJ
				consent_date_time = com.ehis.util.DateUtils.convertDate(CommonBean.checkForNull(rst_1.getString(2)),"DMYHM","en",locale);
				consent_taken_from = CommonBean.checkForNull(rst_1.getString(3));
				clob_notes_content	= rst_1.getClob("FORM_CONTENT");
				if(clob_notes_content!=null){
					consent_content = clob_notes_content.getSubString(1,(int)clob_notes_content.length());
				}						
	%>
			<tr>
				<td class='columnHeaderCenter' width="25%"  >
					 <B> <fmt:message key="eOT.ConsentDateTime.Label" bundle="${ot_labels}"/></B>
				</td>
				<td width="25%" class="columnHeaderCenter">
						<%=consent_date_time%>
				</td>
			</tr>
			<tr>
				<td class='columnHeaderCenter'width="25%" >
					<B> <fmt:message key="eOT.ConsentTakenBy.Label" bundle="${ot_labels}"/>	</B>
				</td>
				<td width="25%" class="columnHeaderCenter">
					<%=consent_prac_name%>
				</td>
			</tr>
			<tr>
				<td class='columnHeaderCenter' width="25%" >
					<B><fmt:message key="eOT.ConsentTakenFrom.Label" bundle="${ot_labels}"/></B>
				</td>
				<td  class="columnHeaderCenter" width="25%">
					<%=consent_taken_from%>
				</td>
			</tr>
			
		<%
			}
			if(rst_1!=null) rst_1.close();
		}
		if(rst_1!=null) rst_1.close();
		if(pstmt_1!=null) pstmt_1.close();
		%>
	
	</table>
		<input type='hidden' name='locale' id='locale' value="<%=locale%>">
	</body>
	</html>

	<%
		if(data_available_flag == false){
	%>
			<script>
			//	var msg =getMessage("APP-OT0089","OT");
			//	alert(msg);
			//	window.returnValue="";
			//	window.close();
			</script>
	<%
		}
	}catch(Exception e){
		System.err.println("Err Msg in ViewConsentDtls.jsp"+e.getMessage());
	}finally{
		try{
			if(rst!=null)rst.close();
			if(rst_1!=null)rst.close();
			if(pstmt!=null)pstmt.close();
			if(pstmt_1!=null)pstmt.close();
			if(con!=null)
				ConnectionManager.returnConnection(con,request);
		}catch(Exception e){}
	}

%>


