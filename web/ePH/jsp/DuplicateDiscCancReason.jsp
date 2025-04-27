<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*,eOR.*,ePH.*,java.sql.*,webbeans.eCommon.* " %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>  
<%-- Mandatory declarations end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<title>
				<fmt:message key="Common.reason.label" bundle="${common_labels}"/>
		</title>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../ePH/js/PrescriptionTest.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body     OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">

<%
	String mode	   = "1";//request.getParameter( "mode" ) ;
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String generic_id = request.getParameter("generic_id")==null?"":request.getParameter("generic_id");
	String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String disc_vals = request.getParameter("disc_vals")==null?"":request.getParameter("disc_vals");
	String cancel_vals = request.getParameter("cancel_vals")==null?"":request.getParameter("cancel_vals");
	String bean_id 			= "@Or_CancelOrder"+patient_id ;
	String bean_name 		= "eOR.CancelOrder";
	String bean_id1			= "@PrescriptionBean_1"+patient_id+encounter_id;
	String bean_name1		= "ePH.PrescriptionBean_1";
	CancelOrder bean = (CancelOrder)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.clear() ;
	bean.setMode( mode ) ;
	PrescriptionBean_1 pres_bean		= (PrescriptionBean_1)getBeanObject(bean_id1,bean_name1,request);
	String presBean_id			= "PrescriptionBean"+patient_id+encounter_id;
	String presBean_name		= "ePH.PrescriptionBean";
	PrescriptionBean presBean		= (PrescriptionBean)getBeanObject(presBean_id, presBean_name, request );

	try{
		String cont_order_ind = request.getParameter("cont_order_ind")==null?"":request.getParameter("cont_order_ind");
		String ord_cat_id = request.getParameter("ord_cat_id")==null?"":request.getParameter("ord_cat_id");
		String from = request.getParameter("from")==null?"":request.getParameter("from");
		String catalog_code = request.getParameter("catalog_code")==null?"":request.getParameter("catalog_code");
		String order_type_code = request.getParameter("order_type_code")==null?"":request.getParameter("order_type_code");
		String orderId = request.getParameter("orderId")==null?"":request.getParameter("orderId");
		String order_line_num = request.getParameter("order_line_num")==null?"":request.getParameter("order_line_num");
		String alternate_amend_yn = request.getParameter("alternate_amend_yn")==null?"":request.getParameter("alternate_amend_yn");// Added for JD-CRF-0198 [IN058599] 
		String bill_yn = "N";
		String displayRefund = "display:none", disc_display="display:none", cance_display="display:none", discOrdersYN="",cancelOrdersYN="" ;
		String dfltDiscontinue		= "";
		ArrayList discReasons = null;
		ArrayList cancelReasons = null;
		if(alternate_amend_yn.equals("Y"))// Added for JD-CRF-0198 [IN058599] 
			pres_bean.setAmend_alternate_yn("Y");

		if(!disc_vals.equals("")){
			disc_display="display:inline";
			discOrdersYN = "Y";
			discReasons		= bean.getDiscontinueReason(ord_cat_id);
			dfltDiscontinue = bean.getDiscontinueRefund();
			bill_yn = presBean.getBilledYN(orderId);
			if(bill_yn!=null && bill_yn.equals("Y"))
				displayRefund = "display:inline";
		}
		if(!cancel_vals.equals("")){
			cancelReasons		= bean.getCancelReason(ord_cat_id);
			cance_display="display:inline";
			cancelOrdersYN="Y";
		}
		String[] record  = null;
%>
			<FORM METHOD=POST name="discontinue_line" id="discontinue_line">
				<input type="hidden" name="from" id="from" value="<%=from%>">
				<table  cellpadding='0' cellspacing='0' border='0' width='100%' height="95%" align='center'>
					<tr>
						<td class='label' width='24%' style='<%=disc_display%>' nowrap>
							<fmt:message key="Common.DiscontinueReason.label" bundle="${common_labels}"/>
						</td>
						<td class='label' width='24%' style='<%=disc_display%>' nowrap><SELECT name="disc_reason" id="disc_reason" onchange='displayDesc(this,"D")'>
							<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---
<%
							if(discReasons!=null){
								for(int i=0; i<discReasons.size(); i++){
									record = (String [])discReasons.get(i);
%>
									<option value="<%=record[1]%>"><%=record[2]%>
<%	
								}
							}
%>
							</SELECT> &nbsp;<img  src="../../eCommon/images/mandatory.gif" style='<%=disc_display%>'></img>
							<input type='hidden' name = 'discOrdersYN' value='<%=discOrdersYN%>'>
							</td>

						<td class='label' width='24%' style='<%=cance_display%>' nowrap>
						<fmt:message key="eOR.CancelReason.label" bundle="${or_labels}"/>
						</td>
						<td class='label' width='24%' style='<%=cance_display%>' nowrap><SELECT name="cancel_reason" id="cancel_reason" onchange='displayDesc(this,"C")'>
							<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---
<%
							if(cancelReasons!=null ){
								for(int i=0; i<cancelReasons.size(); i++){
									record = (String [])cancelReasons.get(i);
%>
									<option value="<%=record[1]%>"><%=record[2]%>
<%	
								}
							}
%>
							</SELECT> &nbsp;<img  src="../../eCommon/images/mandatory.gif" style='<%=cance_display%>'></img>
							<input type='hidden' name = 'cancelOrdersYN' value='<%=cancelOrdersYN%>'>
						</td>
						<td>&nbsp;</td>

					</tr>
					<tr>
						<td class="label" style='<%=disc_display%>' colspan='2'>&nbsp;<TEXTAREA NAME="disc_reason_desc" ROWS="10" COLS="40"  onKeyPress="return ChkMaxLen('<fmt:message key='Common.remarks.label' bundle='${common_labels}'/>',this,255)" onblur ="return checkDrugIndMaxLimit(this,255);"></TEXTAREA>
						</td>
						<td class="label"  style='<%=cance_display%>' colspan='2'>&nbsp;<TEXTAREA NAME="cancel_reason_desc" ROWS="10" COLS="40" onBlur = "return checkDrugIndMaxLimit(this,255);"  onKeyPress="return ChkMaxLen('<fmt:message key='Common.remarks.label' bundle='${common_labels}'/>',this,255)" onblur='return checkDrugIndMaxLimit(this,255);'></TEXTAREA>
						</td>
					</tr>
<% 
					if( !disc_vals.equals("")){
%>
						<tr style="<%=displayRefund%>">
							<td class=label width='24%'><fmt:message key="eBL.REFUND.label" bundle="${bl_labels}"/></td>
							<td class='label'  colspan='3'>
								<Select name='DefRefundOptDiscOrder' id='DefRefundOptDiscOrder'>
									<Option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</Option>
									<Option value='Y' <%if(dfltDiscontinue.equals("Y")) {out.println("selected");}%>><fmt:message key="Common.yes.label" bundle="${common_labels}"/></Option>
									<Option value='N' <%if(dfltDiscontinue.equals("N")) {out.println("selected");}%>><fmt:message key="Common.no.label" bundle="${common_labels}"/></Option>
								</Select> 
							</td>
						</tr>
<% 
					}
%>	
					<tr>
						<td  class='button' colspan='4' > 
						<input type='button' class='button' name='ok' id='ok' Value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' onClick="discCancelLineRecord('<%=disc_vals%>','<%=cancel_vals%>')">
						<input type='button' class='button' name='close' id='close' Value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick="closeReason();"></td>
					</tr>
				</table>
			<input type="hidden" value="<%=presBean_id%>" name="presBean_id">
			<input type="hidden" value="<%=presBean_name %>" name="presBean_name">
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
			<input type="hidden" name="bean_id1" id="bean_id1" value="<%=bean_id1%>">
			<input type="hidden" name="bean_name1" id="bean_name1" value="<%= bean_name1 %>">
			<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
			<input type="hidden" name="generic_id" id="generic_id" value="<%=generic_id%>">
			<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
		</FORM>
<%
			putObjectInBean(bean_id,bean,request);
			putObjectInBean(presBean_id,presBean,request);
		}
		catch(Exception e){
			e.printStackTrace();
		}
%>
	</body>
</html>

