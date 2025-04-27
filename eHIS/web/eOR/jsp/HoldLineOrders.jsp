<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- 
-----------------------------------------------------------------------
Date       Edit History      Name        		Description
-----------------------------------------------------------------------
?             100            ?           		created
07/08/2013	  IN042100      Chowminya G		Ph Category  -  Hold Order Option line level with MAR status P included to handle script errors		
-----------------------------------------------------------------------
-->
<%@ page contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*,eOR.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"%>
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
	String mode	   = "1";//request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_CancelOrder" ;
	String bean_name = "eOR.CancelOrder";

	//String ord_cat = request.getParameter("ord_cat");
	//String cancelled_at = request.getParameter("cancelled_at");
	//String reason_desc = "";
	//out.println(">>>>>>>>>>>"+orderId+"<BR>");
//	out.println(cancelled_at+"<BR>");
	String cont_order_ind = request.getParameter("cont_order_ind");
	if(cont_order_ind == null) cont_order_ind = "";
	String ord_cat_id = request.getParameter("ord_cat_id");
	if(ord_cat_id == null) ord_cat_id = "";
	String orderId = request.getParameter("orderId");
	if(orderId == null) orderId = "";
	String order_line_num = request.getParameter("order_line_num");
	if(order_line_num == null) order_line_num = "";
 	String order_status = request.getParameter("order_status");
	if(order_status == null) order_status = "";
	String from = request.getParameter("from");
	if(from == null) from = "";
	String catalog_code = request.getParameter("catalog_code");
	if(catalog_code == null) catalog_code = "";
	String ord_typ_code = request.getParameter("ord_typ_code");
	if(ord_typ_code == null) ord_typ_code = "";
	Connection con = null;				//IN042100
	PreparedStatement pstmt = null;		//IN042100
	ResultSet rs = null;				//IN042100
	
	String ReasonCodeHoldDisYN="";//IN042100
	String ReasonCodeHoldDiscatYN="";//IN042100
	
	ArrayList allValues = new ArrayList();
/* Mandatory checks end */
	
	/* Initialize Function specific start */
	//CancelOrder bean = (CancelOrder)mh.getBeanObject( bean_id, request,  bean_name ) ; 
	CancelOrder bean = (CancelOrder)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
 
	bean.clear() ;
	bean.setMode( mode ) ;
	con = ConnectionManager.getConnection(); //IN042100
	//IN042100 Starts
	try
	{
		String qry1= "SELECT a.HOLD_DISCONTINUE_REASON_YN,b.HOLD_DISCONTINUE_CATEGORY_YN FROM or_param a,or_order_category b where B.order_category=?";
		pstmt = con.prepareStatement(qry1);
		pstmt.setString(1,ord_cat_id);
		rs = pstmt.executeQuery();
			
		while(rs.next())
		{
			ReasonCodeHoldDisYN = rs.getString(1);
			ReasonCodeHoldDiscatYN = rs.getString(2);
		}
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}finally{
		try
		{
			if(con != null) con.close();	
		}
		catch(Exception e)
		{
			e.printStackTrace();		
		}
	}
	
	//IN042100 Ends	

	allValues		= bean.getDiscontinueReason(ord_cat_id);
	//out.println(allValues.size());
%>

<html>
<head>

	<title><fmt:message key="Common.HoldReason.label" bundle="${common_labels}"/></title>
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
<FORM METHOD=POST name="discontinue_line" id="discontinue_line">
<input type="hidden" name="from" id="from" value="<%=from%>">
<table cellpadding=3 cellspacing=0 border=0 width='100%' height='100%' align=center>
<tr><td class=label><fmt:message key="Common.HoldReason.label" bundle="${common_labels}"/></td>
	<td class=fields><SELECT name="cancel_reason" id="cancel_reason" onchange='displayDesc(this)'>
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
	<TEXTAREA NAME="reason_desc" ROWS="10" COLS="50" onBlur = "return CheckMaxLength(this,255);makeValidString(this)"  onKeyPress="return CheckMaxLength(this,255)"></TEXTAREA>
	</td>
	</tr>
	<tr><td colspan=3 class='button'><input type=button class=button name='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' id='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' Value="Record" onClick='discontinueLineRecord()'><input type=button class=button name='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' id='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' Value="Close" onClick="window.close()"></td></tr>
	</table>
	<input type="hidden" name="mode" id="mode" value="1">
	<!-- <input type="hidden" name="which_place" id="which_place" value="hold_line_rec">// purposely it  is commented since while multi user perform various operations on the same order there was a conflict ... since from is passed as header -->
	<input type="hidden" name="which_place" id="which_place" value="hold_line_rec">
	<input type="hidden" name="pract_id" id="pract_id" value="<%=(String)session.getValue("ca_practitioner_id")%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="orderId" id="orderId" value="<%=orderId%>">
	<input type="hidden" name="order_line_num" id="order_line_num" value="<%=order_line_num%>"><!-- this value is also  commented purposely since it misleads to chk other validations which is not applicable for from=header validation  -->
	<input type="hidden" name="cont_order_ind" id="cont_order_ind" value="<%=cont_order_ind%>">
	<input type="hidden" name="order_status" id="order_status" value="<%=order_status%>">
	<input type="hidden" name="ord_typ_code" id="ord_typ_code" value="<%=ord_typ_code%>">
	<input type="hidden" name="catalog_code" id="catalog_code" value="<%=catalog_code%>">
	<!--IN042100-->
	<input type="hidden" name="ReasonCodeHoldDisYN" id="ReasonCodeHoldDisYN" value="<%=ReasonCodeHoldDisYN%>">
	<input type="hidden" name="ReasonCodeHoldDiscatYN" id="ReasonCodeHoldDiscatYN" value="<%=ReasonCodeHoldDiscatYN%>">

</FORM>
</body>
</html>

<%
		putObjectInBean(bean_id,bean,request);
%>

