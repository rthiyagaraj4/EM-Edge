<!DOCTYPE html>
 <%@page contentType="text/html;charset=UTF-8" import="java.util.*,java.text.DecimalFormat, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
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

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
    <script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../ePH/js/DispMedicationAllStages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

   
</head>
<title><fmt:message key="ePH.AdMixturePreparationCharges.label" bundle="${ph_labels}"/></title>
	<body onMouseDown="" onKeyDown="lockKey()">


<%

        String gross_admx_prep_charge				= request.getParameter("gross_admx_prep_charge");
        String groos_pat_payable_admx_prep_charge	= request.getParameter("groos_pat_payable_admx_prep_charge") ;
		String markupdown							= request.getParameter("MarkupDown").equals("")?"0":request.getParameter("MarkupDown");
		String bl_decimal_format_str				= request.getParameter("BL_decimal_format_str");
		String disp_stage							= request.getParameter("disp_stage");
		String markup_readonly						="";
        if(disp_stage.equals("D")){
			markup_readonly ="readonly";
		}

		DecimalFormat dfTest							=   new DecimalFormat(bl_decimal_format_str);

		String calc_gross_admx_prep_charge				= dfTest.format(Float.parseFloat(markupdown)*Float.parseFloat(gross_admx_prep_charge));
		String calc_groos_pat_payable_admx_prep_charge  = dfTest.format(Float.parseFloat(markupdown)*Float.parseFloat(groos_pat_payable_admx_prep_charge));
		
%>
		<form name="admixturepreparationchargesform" id="admixturepreparationchargesform" >
			<table cellpadding="0" cellspacing="0" width="100%"  border='1'>	
				<tr >
					<td class='COLUMNHEADER' width='40%'></td>
					<td class='COLUMNHEADER' width='30%'><fmt:message key="Common.ChargeAmount.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADER' width='30%'><fmt:message key="ePH.PayableAmount.label" bundle="${ph_labels}"/></td>
					
				     <tr>
						  <td class="label" align="center"><fmt:message key="ePH.PerUnit.label" bundle="${ph_labels}"/></td>
						  <td class="label" align="center"><label><b><%=gross_admx_prep_charge%></b></label></td>
						  <td class="label" align="center"><label><b><%=groos_pat_payable_admx_prep_charge%></b></label></td>	  
					</tr>
					 <tr>
						  <td class="label" align="center"><fmt:message key="ePH.Markup/Down.label" bundle="${ph_labels}"/>
						  <input type="text"  size="4" onKeyPress="javascript:if(event.keyCode != 13){return allowValidNumber(this,event,4,1);}else{return false;}"  <%=markup_readonly%> maxlength="4" name="mark_up_down" value="<%=markupdown%>" onblur="javascript:if(!checkValidDecimal(this)){calculateAmounts(this,<%=gross_admx_prep_charge%>,<%=groos_pat_payable_admx_prep_charge%>,bl_decimal_format_str);}"  >
						  </td>
						  <td class="label" align="center" id="markup_gross_admx_prep_charge"><b><%=calc_gross_admx_prep_charge%></b></td>
						  <td class="label" align="center" id="markup_groos_pat_payable_admx_prep_charge"><b><%=calc_groos_pat_payable_admx_prep_charge%></b></td>	  
					</tr>
					<tr>
					<td class='white' colspan=3>&nbsp;<input type="button" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' 
					class="button" name="btnclose" onClick="formclose()"></td>
				    </tr>
					<input type="hidden" name="calc_markup_gross_admx_prep_charge" id="calc_markup_gross_admx_prep_charge" value="<%=gross_admx_prep_charge%>">
					<input type="hidden" name="calc_markup_groos_pat_payable_admx_prep_charge" id="calc_markup_groos_pat_payable_admx_prep_charge" value="<%=groos_pat_payable_admx_prep_charge%>">
					<input type="hidden" name="bl_decimal_format_str" id="bl_decimal_format_str" value="<%=bl_decimal_format_str%>">
			</table>
		</form>
	</body>
</html>

