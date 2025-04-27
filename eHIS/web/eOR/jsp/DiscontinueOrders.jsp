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
Date       Edit History      Name        	Description
-----------------------------------------------------------------------
?             100            ?           	created
03/01/2012	  IN028417		Menaka V		The registered lab samples can be discontinued from CA-OR even though
											the discontinuation reasons are not defined for lab module.
19/10/2012    IN033061      Chowminya G  	System doesnt display menu cancel/discontinue if the orders are IV Fluid,
											IV Fluid+Drug, IV Fluid+Drug(Frequency).
27/05/2014	  KDAH-DSC		Akbar			Performance issue fix when discontinue OT order suggested by sunil for KDAH
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Rev.Date 	Rev.Name	Description
--------------------------------------------------------------------------------------------------------------
04/09/2017    IN007187		Raja		04/09/2017	Ramesh G	GHL-SCF-1235		
14/10/2019    IN071315	    Nijitha S   23/10/2019	Ramesh G	GHL-CRF-0607		
25/03/2020	IN072752		Nijitha S	25/03/2020	Ramesh G	ML-MMOH-CRF-1229/12	
---------------------------------------------------------------------------------------------------------
-->
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
	String mode	   = "1";//request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	String patient_id = request.getParameter("patient_id");
	if(patient_id == null) patient_id = "";
	String bean_id = "@Or_CancelOrder"+patient_id ;
	String bean_name = "eOR.CancelOrder";

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	//String ord_cat = request.getParameter("ord_cat");
	//String cancelled_at = request.getParameter("cancelled_at");
	//String reason_desc = "";
	//out.println(">>>>>>>>>>>"+orderId+"<BR>");
//	out.println(cancelled_at+"<BR>");
	String cont_order_ind = request.getParameter("cont_order_ind");
	if(cont_order_ind == null) cont_order_ind = "";
	String ord_cat_id = request.getParameter("ord_cat_id");
	//out.println("<script>alert('in dicontinueORders.jsp,ord_cat_id="+ord_cat_id+"')</script>");
	if(ord_cat_id == null) ord_cat_id = "";
	String from = request.getParameter("from");
	if(from == null) from = "";
	//out.println("<script>alert('from in dicontinueORders.jsp="+from+"')</script>");	
	String catalog_code = request.getParameter("catalog_code");
	if(catalog_code == null) catalog_code = "";
	String order_type_code = request.getParameter("order_type_code");
	if(order_type_code == null) order_type_code = "";
	//out.println("<script>alert('in dicontinueORders.jsp,catalog_code="+catalog_code+"')</script>");	
	String orderId = request.getParameter("orderId");
	if(orderId == null) orderId = "";
	String order_line_num = request.getParameter("order_line_num");
	if(order_line_num == null) order_line_num = "";
	//--[IN033061] - Start
	String iv_prep_yn = request.getParameter("iv_prep_yn");
	if(iv_prep_yn == null) iv_prep_yn = "";
	//--[IN033061] - End

	String bill_yn = "N";
	String ReasonCodeHoldDisYN="";//IN028417
	String ReasonCodeHoldDiscatYN="";//IN028417
	String displayRefund = "display:none";
	String p_called_from_ca			=request.getParameter("p_called_from_ca");//IN071315
	//out.println(">>>>>>>>>>>"+ord_cat_id+"===<BR>");
	
	
	ArrayList allValues = new ArrayList();
/* Mandatory checks end */
	
	/* Initialize Function specific start */
	//CancelOrder bean = (CancelOrder)mh.getBeanObject( bean_id, request,  bean_name ) ; 
	CancelOrder bean = (CancelOrder)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
 
	bean.clear() ;
	bean.setMode( mode ) ;

	allValues		= bean.getDiscontinueReason(ord_cat_id);
	String dfltDiscontinue		= "";
	dfltDiscontinue = bean.getDiscontinueRefund();
	//out.println(allValues.size());	
	con = ConnectionManager.getConnection(); //IN028417
	String fpp_yn = "";//IN072752
	String fpp_category = "";//IN072752
	try{

		//con = ConnectionManager.getConnection(); //IN028417
		//KDAH-DSC/Changes-start
		//pstmt = con.prepareStatement("SELECT   'Y' FROM or_order_line b WHERE (b.order_id = ? or b.PARENT_ORDER_ID=?) AND b.BILL_YN ='Y' and rownum=1");
		pstmt = con.prepareStatement("SELECT 'Y' FROM or_order_line b WHERE b.order_id = ? AND b.BILL_YN ='Y' and rownum=1");
		//KDAH-DSC/Changes-end
		pstmt.setString(1,orderId);
		//pstmt.setString(2,orderId);			//KDAH-DSC - commented
		rs = pstmt.executeQuery();
		if(rs.next())
			bill_yn = rs.getString(1)==null?"N":rs.getString(1);

	

		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();

		
		if(bill_yn.equals("Y"))
			displayRefund = "display:inline";
		//IN072752 Starts
		Boolean isFPPApplicableyn =false;
		try {
		isFPPApplicableyn = eCommon.Common.CommonBean.isSiteSpecific(con, "OR","FPP_APPLICABLE_YN");
		if(isFPPApplicableyn){
		ArrayList fppDtls = bean.getFPPDetailsForOrder(orderId, order_line_num);
		
		if(null!=fppDtls && fppDtls.size()> 0){
		 if(null!=fppDtls.get(0) && null!=fppDtls.get(1)){
			fpp_yn = fppDtls.get(0).toString();
			fpp_category = fppDtls.get(1).toString();
		 }
		}
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		//IN072753 Ends

	}catch(Exception e){
		e.printStackTrace();
	}
	//IN028417 Starts
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
	}
	try
	{
		if(con != null) con.close();	
	}
	catch(Exception e)
	{
		e.printStackTrace();		
	}
	
	//IN028417 Ends
%>

<html>
<head>

	<title><fmt:message key="Common.DiscontinueReason.label" bundle="${common_labels}"/></title>
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
<table cellpadding=3 cellspacing=0 border=0 width='100%' height="100%" align=center>
<tr>
<td class=label><fmt:message key="Common.DiscontinueReason.label" bundle="${common_labels}"/></td>
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
	<tr style="<%=displayRefund%>">
		<td class=label><fmt:message key="eBL.REFUND.label" bundle="${bl_labels}"/></td>
		<td class='fields'>
			<Select name='DefRefundOptDiscOrder' id='DefRefundOptDiscOrder'>
				<Option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</Option>
				<Option value='Y' <%if(dfltDiscontinue.equals("Y")) {out.println("selected");}%>><fmt:message key="Common.yes.label" bundle="${common_labels}"/></Option>
				<Option value='N' <%if(dfltDiscontinue.equals("N")) {out.println("selected");}%>><fmt:message key="Common.no.label" bundle="${common_labels}"/></Option>
			</Select>
		</td>
	</tr>
	<tr>
	<td class="fields" colspan="2">
	<TEXTAREA NAME="reason_desc" ROWS="10" COLS="50"  style="margin-top:19px" onBlur = "return makeValidString(this)"  onKeyPress="return CheckMaxLength(this,255)"></TEXTAREA>
	</td>
	</tr>
	<tr><td  class='button' colspan=3><input type=button class=button name='ok' id='ok' Value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' onClick='discontinueLineRecord()'><input type=button class=button name='close' id='close' Value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick="window.close()"></td></tr>
	<td></td>
	</table>
	<input type="hidden" name="mode" id="mode" value="1">
	<input type="hidden" name="which_place" id="which_place" value="discontinue_line_rec">
	<input type="hidden" name="pract_id" id="pract_id" value="<%=(String)session.getValue("ca_practitioner_id")%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<input type="hidden" name="orderId" id="orderId" value="<%=orderId%>">
	<input type="hidden" name="catalog_code" id="catalog_code" value="<%=catalog_code%>">
	<input type="hidden" name="order_type_code" id="order_type_code" value="<%=order_type_code%>">
	<input type="hidden" name="order_line_num" id="order_line_num" value="<%=order_line_num%>">
	<input type="hidden" name="cont_order_ind" id="cont_order_ind" value="<%=cont_order_ind%>">
	<input type="hidden" name="ord_cat_id" id="ord_cat_id" value="<%=ord_cat_id%>">
	<!-- IN028417 Starts -->
	<input type="hidden" name="ReasonCodeHoldDisYN" id="ReasonCodeHoldDisYN" value="<%=ReasonCodeHoldDisYN%>">
	<input type="hidden" name="ReasonCodeHoldDiscatYN" id="ReasonCodeHoldDiscatYN" value="<%=ReasonCodeHoldDiscatYN%>">
	<input type="hidden" name="OldOrderStatus" id="OldOrderStatus" value="<%=request.getParameter("order_status")%>"><!--IN007187 -->
	
	<!-- IN028417 Ends -->
	<!----[IN033061]-->
	<input type="hidden" name="iv_prep_yn" id="iv_prep_yn" value="<%=iv_prep_yn%>">
	<input type="hidden" name="p_called_from_ca" id="p_called_from_ca" value="<%=p_called_from_ca%>"><!--IN071315 -->
	<input type="hidden" name="fpp_yn" id="fpp_yn" value="<%=fpp_yn%>"><!--IN072752 -->
	<input type="hidden" name="fpp_category" id="fpp_category" value="<%=fpp_category%>"><!--IN072752 -->
</FORM>
</body>
</html>

<%
	putObjectInBean(bean_id,bean,request);
%>

