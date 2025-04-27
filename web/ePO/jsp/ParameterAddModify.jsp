<!DOCTYPE html>
<%@ page import="ePO.ParameterBean,eMM.MM_license_rights" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");		
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../ePO/js/PoCommon.js"></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
	<script language='javascript' src='../../ePO/js/Parameter.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<style type="text/css">
		select{
			width=140px;
		}

	</style>
</head>
<%
	String mode;
	String bean_id;
	String bean_name;
	String codeDisabled =	"";
	String codeChecked = "";
	String codeCheckedAuto = "";
	String codeCheckedManual = "";
	mode	= "" ;
	bean_id = "parameterBean" ;
	bean_name = "ePO.ParameterBean";
	ParameterBean bean = (ParameterBean)getBeanObject( bean_id, bean_name,request);  
	bean.setLanguageId(locale);
	
	//System.out.println("getDef_purchase_dept_List = "+bean.getDef_purchase_dept_List());

	bean.clear() ;
	
//	bean.setAcc_entity_id((String)session.getAttribute("ACC_ENTITY_ID"));
	bean.setLoginFacilityId((String)session.getAttribute("facility_id")) ;
	mode	=	bean.recordExists()?eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"):eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT");
	System.out.println("mode = "+mode);
	ServletContext context = getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);

	bean.setMode( mode ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	
	if ( mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {
		codeDisabled = "disabled";
		bean.loadData();
		
	}
	

	
if(!bean.checkForNull((String)	bean.fetchRecord(bean.getPoRepositoryValue("SQL_ST_ACC_ENTITY_PARAM_SELECT1"),new String[]{(String)session.getAttribute("ACC_ENTITY_ID")}).get("PO_INTERFACE_YN"),"N").equals("Y")){ 	
	%>
  <SCRIPT>alert("Purchase Module Not Applicable");window.location.href = '../../eCommon/jsp/dmenu.jsp'</SCRIPT>   
 <%
	}
%>
<body onLoad="FocusFirstElement(); ">
	<form name="formParameter" id="formParameter" onReset="FocusFirstElement();">
	<table border=0 align='center' width='100%' height='50%'>
		<tr><td align='center' class='WHITE'>
	<table border=0 cellpadding=1 cellspacing=1 align='center' width='98%'>
	
	<tr><td align='center' class='WHITE'>
		<table width='70%' border=0 cellpadding=1 cellspacing=1 align='left'>  
		
		<tr>
			<td align='right'  class='label'>Item Level Order Approval Required </td>
		&nbsp;&nbsp;<td><input type="checkbox" value="Y" <%=bean.getChecked(bean.getItmLvlOrdApReq_yn())%> name="itmLvlOrdApReq_yn" > </td>
		</tr>
		
		<tr>
			<td align='right'  class='label'>Budget Check Required </td>
		&nbsp;&nbsp;<td><input type="checkbox" value="Y" <%=bean.getChecked(bean.getBudgetCheckReq_yn())%> name="budgetCheckReq_yn" > </td>
		</tr>
		
		<tr>
			
		<td align='right'  class='label'><fmt:message key="ePO.AlowOvOrDelDt.label" bundle="${po_labels}"/></td>
		&nbsp;&nbsp;<td><select name="alowOvOrDelDt" id="alowOvOrDelDt" >
		<option value="N" <%=bean.getAlowOvOrDelDt().equals("N")?"Selected":""%>><fmt:message key="ePO.NotApplicable.label" bundle="${po_labels}"/></option>
		<option value="E" <%=bean.getAlowOvOrDelDt().equals("E")?"Selected":""%>><fmt:message key="ePO.Error.label" bundle="${po_labels}"/></option>
		<option value="W" <%=bean.getAlowOvOrDelDt().equals("W")?"Selected":""%>><fmt:message key="ePO.Warning.label" bundle="${po_labels}"/></option></select>
		</td>
		</tr> 
		
		<tr>
		<td align='right'  class='label'><fmt:message key="ePO.AlowOvOrQtRe.label" bundle="${po_labels}"/></td>
		&nbsp;&nbsp;<td><select name="alowOvOrQtRe" id="alowOvOrQtRe" >
		<option value="N" <%=bean.getAlowOvOrQtRe().equals("N")?"Selected":""%>><fmt:message key="ePO.NotApplicable.label" bundle="${po_labels}"/></option>
		<option value="E" <%=bean.getAlowOvOrQtRe().equals("E")?"Selected":""%>><fmt:message key="ePO.Error.label" bundle="${po_labels}"/></option>
		<option value="W" <%=bean.getAlowOvOrQtRe().equals("W")?"Selected":""%>><fmt:message key="ePO.Warning.label" bundle="${po_labels}"/></option></select>
		</td>
		</tr>
				
		<tr>
		<td align='right'  class='label'><fmt:message key="ePO.AlowOvOrPrRe.label" bundle="${po_labels}"/></td>
		&nbsp;&nbsp;<td><select name="alowOvOrPrRe" id="alowOvOrPrRe" >
		<option value="N" <%=bean.getAlowOvOrPrRe().equals("N")?"Selected":""%>><fmt:message key="ePO.NotApplicable.label" bundle="${po_labels}"/></option>
		<option value="E" <%=bean.getAlowOvOrPrRe().equals("E")?"Selected":""%>><fmt:message key="ePO.Error.label" bundle="${po_labels}"/></option>
		<option value="W" <%=bean.getAlowOvOrPrRe().equals("W")?"Selected":""%>><fmt:message key="ePO.Warning.label" bundle="${po_labels}"/></option></select>
		</td>
		</tr>
<!--Added By Sakti Sankar against Inc#30079-->
		<tr>
			<td align='right'  class='label'><fmt:message key="ePO.PoMendatForDevorder.label" bundle="${po_labels}"/></td>
		&nbsp;&nbsp;<td><input type="checkbox" value="Y" <%=bean.getChecked(bean.getPo_reqd_for_do_yn())%> name="po_reqd_for_do_yn" > </td>
		</tr>
		
		<tr>
			<td align='right'  class='label'><fmt:message key="ePO.AllowChangePurPrice.label" bundle="${po_labels}"/></td>
		&nbsp;&nbsp;<td><input type="checkbox" value="Y" <%=bean.getChecked(bean.getAllow_chage_to_do_price_yn())%> name="allow_chage_to_do_price_yn" > </td>
		</tr>

		<tr>
		<td align='right'  class='label'><fmt:message key="ePO.HeaderRemarks1.label" bundle="${po_labels}"/></td>
		&nbsp;&nbsp;<td><input type="text" size=100 maxlength=200 value="<%=bean.getHdr_remarks1()%>" name="hdr_remarks1" > </td>
		</tr>

		<tr>
		<td align='right'  class='label'><fmt:message key="ePO.HeaderRemarks2.label" bundle="${po_labels}"/></td>
		&nbsp;&nbsp;<td><input type="text" size=100 maxlength=200 value="<%=bean.getHdr_remarks2()%>" name="hdr_remarks2" > </td>
		</tr>

		</table>
		</td>
		
	</tr> 
	
	 
	<tr>
			<td>&nbsp;</td><td>&nbsp;</td>
	</tr>
	<!--
	<tr>
		<th align='left' colspan='4'><fmt:message key="eST.DefDocNoGenerationRule.label" bundle="${st_labels}"/></th>	
	</tr>

	<tr><td align='center' class='WHITE'>
		<table width='40%' border=0 cellpadding=1 cellspacing=0 align='left'>  
		<tr>
		<td align='right'  class='label'><fmt:message key="eST.AutogenerateDocNo.label" bundle="${st_labels}"/>
		&nbsp;&nbsp;<input type="radio" value="A" name="doc_no_generate_yn" id="doc_no_generate_yn" checked <%=codeCheckedAuto%>> </td>
		<td align='right'  class='label'><fmt:message key="eST.ManualEntry.label" bundle="${st_labels}"/>
		&nbsp;&nbsp;<input type="radio" value="M" name="doc_no_generate_yn" id="doc_no_generate_yn" <%=codeCheckedManual%>> </td>
		</tr>
		</table>
		</td>
		
	</tr> 
	<tr>
			<td>&nbsp;</td><td>&nbsp;</td>
		</tr>
		
	<tr>
		<th align='left' colspan='4'><fmt:message key="Common.OtherDefaults.label" bundle="${common_labels}"/></th>
	</tr>
	<tr>
			<td>&nbsp;</td><td>&nbsp;</td>
		</tr>
		
		 <tr><td align='center' class='WHITE'>
		<table width='40%' border=0 cellpadding=1 cellspacing=0 align='left'>  
	<tr>
		<td align='right'  class='label'><fmt:message key="eST.DefPurReqStr.label" bundle="${st_labels}"/></td>
		<td colspan='3'>&nbsp;<select name="def_store_code_for_rec" id="def_store_code_for_rec">
		<%=bean.getDef_store_code_for_rec_List()%>
		</select></td>
	</tr>
	<tr>
		<td align='right'  class='label'><fmt:message key="eST.DefPurDept.label" bundle="${st_labels}"/> </td>
		<td colspan='3'>&nbsp;<select name="def_purchase_dept" id="def_purchase_dept">
		<%=bean.getDef_purchase_dept_List()%>
		</select></td>
		</tr>
	<tr>
	<td  class="label"><fmt:message key="eST.DefaultItemSearchBy.label" bundle="${st_labels}"/></td>
	<td  align='left'>&nbsp;<select name="dflt_item_search" id="dflt_item_search" >
		<option value="IN"><fmt:message key="Common.ItemName.label" bundle="${common_labels}"/></option>
		<option value="IC"><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></option>
		<option value="MC"><fmt:message key="eST.MachineCode.label" bundle="${st_labels}"/></option>
		<option value="PN"><fmt:message key="eST.PartNumber.label" bundle="${st_labels}"/></option>
		<option value="TI"><fmt:message key="Common.TradeID.label" bundle="${mm_labels}"/></option>
		<option value="TN"><fmt:message key="Common.TradeName.label" bundle="${mm_labels}"/></option>
		<option value="AC"><fmt:message key="Common.AlphaCode.label" bundle="${mm_labels}"/></option></select></td>
	</tr>-->
	 </table>
	</td></tr> 
	
	</table>
		</td></tr>
		
	</table>
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">


	</form>
					<%
						putObjectInBean(bean_id,bean,request);
					%>
</body>
</html>

