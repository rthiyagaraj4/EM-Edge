<!DOCTYPE html>
<%
/* 
------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	  Edit History      		Name        		Rev.Date		Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------------------------------
27/06/2017		IN061903		Krishna Gowtham J.			11/07/2017		Ramesh G.		Created new page for ML-MMOH-CRF-0555
------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*,eOR.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>  
<%-- Mandatory declarations end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	/* Mandatory checks start */
	String mode	   = "1";
	String patient_id = request.getParameter("patient_id");
	if(patient_id == null) patient_id = "";
	String bean_id = "@Or_CancelOrder"+patient_id ;
	String bean_name = "eOR.CancelOrder";

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	String cont_order_ind = request.getParameter("cont_order_ind");
	if(cont_order_ind == null) cont_order_ind = "";
	String ord_cat_id = request.getParameter("ord_cat_id");
	
	if(ord_cat_id == null) ord_cat_id = "";
	String from = request.getParameter("from");
	if(from == null) from = "";
	
	String catalog_code = request.getParameter("catalog_code");
	if(catalog_code == null) catalog_code = "";
	String order_type_code = request.getParameter("order_type_code");
	if(order_type_code == null) order_type_code = "";
	
	String orderId = request.getParameter("orderId");
	if(orderId == null) orderId = "";
	String order_line_num = request.getParameter("order_line_num");
	if(order_line_num == null) order_line_num = "";

	String iv_prep_yn = request.getParameter("iv_prep_yn");
	if(iv_prep_yn == null) iv_prep_yn = "";


	String bill_yn = "N";
	String ReasonCodeNotDoneYN="";
	String displayRefund = "display:none";
	
	
	
	
	ArrayList allValues = new ArrayList();
/* Mandatory checks end */
	
	/* Initialize Function specific start */

	CancelOrder bean = (CancelOrder)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
 
	bean.clear() ;
	bean.setMode( mode ) ;

	allValues		= bean.getNotDoneReason(ord_cat_id);
	String dfltDiscontinue		= "";
	dfltDiscontinue = bean.getDiscontinueRefund();
	
	con = ConnectionManager.getConnection();

	try
	{
		String qry1= "SELECT NOT_DONE_REASON_MAND_YN FROM or_order_category where order_category=?";
		pstmt = con.prepareStatement(qry1);
		pstmt.setString(1,ord_cat_id);
		rs = pstmt.executeQuery();
			
		while(rs.next())
		{
			ReasonCodeNotDoneYN = rs.getString(1);
		}
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	try
	{
		if(con != null) con.close();	
	}
	catch(Exception e)
	{
		e.printStackTrace();		
	}
%>

<html>
<head>

	<title><fmt:message key="eOR.NotDoneReason.label" bundle="${or_labels}"/></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>

	<script language="JavaScript" src="../js/CancelOrder.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body   onload='FocusFirstElement()'  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<FORM METHOD=POST name="not_done_line" id="not_done_line">
<input type="hidden" name="from" id="from" value="<%=from%>">
<table cellpadding=3 cellspacing=0 border=0 width='100%' height="100%" align=center>
<tr>
<td class=label><fmt:message key="eOR.NotDoneReason.label" bundle="${or_labels}"/></td>
	<td class='fields'><SELECT name="cancel_reason" id="cancel_reason" onchange='displayDesc(this)'>
	<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---
		<%
			try{
				

				for(int i=0; i<allValues.size(); i++){
					String[] record = (String [])allValues.get(i);
			
		%>
				<option value="<%=record[1]%>"><%=record[2]%>
		<%	
				}
			}catch(Exception e){
				//out.println(e);//COMMON-ICN-0181
                                 e.printStackTrace();//COMMON-ICN-0181
			}
		%>
	</SELECT>
	</td>
	</tr>
	<tr>
	<td class="fields" colspan="2">
	<TEXTAREA NAME="reason_desc" ROWS="10" COLS="50" onBlur = "return makeValidString(this)"  onKeyPress="return CheckMaxLength(this,255)"></TEXTAREA>
	</td>
	</tr>
	<tr><td  class='button' colspan=3><input type=button class=button name='ok' id='ok' Value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' onClick='notDoneLineRecord()'><input type=button class=button name='close' id='close' Value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick="window.close()"></td></tr>
	<td></td>
	</table>
	<input type="hidden" name="mode" id="mode" value="1">
	<input type="hidden" name="which_place" id="which_place" value="not_done_line_rec">
	<input type="hidden" name="pract_id" id="pract_id" value="<%=(String)session.getValue("ca_practitioner_id")%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<input type="hidden" name="orderId" id="orderId" value="<%=orderId%>">
	<input type="hidden" name="catalog_code" id="catalog_code" value="<%=catalog_code%>">
	<input type="hidden" name="order_type_code" id="order_type_code" value="<%=order_type_code%>">
	<input type="hidden" name="order_line_num" id="order_line_num" value="<%=order_line_num%>">
	<input type="hidden" name="cont_order_ind" id="cont_order_ind" value="<%=cont_order_ind%>">
	<input type="hidden" name="ord_cat_id" id="ord_cat_id" value="<%=ord_cat_id%>">
	<input type="hidden" name="ReasonCodeNotDoneYN" id="ReasonCodeNotDoneYN" value="<%=ReasonCodeNotDoneYN%>">
	<input type="hidden" name="iv_prep_yn" id="iv_prep_yn" value="<%=iv_prep_yn%>">
	<input type="hidden" name="DefRefundOptDiscOrder" id="DefRefundOptDiscOrder" value="N">

</FORM>
</body>
</html>

<%
	putObjectInBean(bean_id,bean,request);
%>

