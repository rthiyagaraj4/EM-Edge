<!DOCTYPE html>
<%@ page import="ePO.DocumentNumberControlBean,eMM.MM_license_rights" contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.*, ePO.Common.*, ePO.* " contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
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
	<script language='javascript' src='../../ePO/js/DocumentNumberControl.js'></script>
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

	mode	= "" ;
	
	bean_id = "documentNumberControlBean" ;
	bean_name = "ePO.DocumentNumberControlBean";
	DocumentNumberControlBean bean = (DocumentNumberControlBean)getBeanObject( bean_id, bean_name,request);  
	bean.setLanguageId(locale);
	
	bean.clear() ;
		
	bean.setLoginFacilityId((String)session.getAttribute("facility_id")) ;

	mode	=	bean.recordExists()?eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"):eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT");
	
	ServletContext context = getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);

	bean.setMode( mode ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	
	if ( mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {
			bean.loadData();
	}
	
	
	int POCount	= Integer.parseInt((String)bean.fetchRecord("SELECT COUNT(*) COUNT FROM PO_ORDER_HDR").get("COUNT"));
	int PRCount	= Integer.parseInt((String)bean.fetchRecord("SELECT COUNT(*) COUNT FROM PO_REQUEST_HEADER").get("COUNT"));
	int DOCount	= Integer.parseInt((String)bean.fetchRecord("SELECT COUNT(*) COUNT FROM PO_DELV_ORD_HDR").get("COUNT"));
	int QuotCount	= Integer.parseInt((String)bean.fetchRecord("SELECT COUNT(*) COUNT FROM PO_QUOT_HDR").get("COUNT"));
	//int POCount = 0;
	//int PRCount = 0;
	//int DOCount = 0;
	//int QuotCount = 0;
	int DocCount	= Integer.parseInt((String)bean.fetchRecord("SELECT COUNT(*) COUNT FROM PO_DOCNO_CONTROL").get("COUNT"));
	//Added by Rabbani #inc no:30078(Bru-HIMS-CRF-119) on 27-MAY-2013
	int TndrCount	= Integer.parseInt((String)bean.fetchRecord("SELECT COUNT(*) COUNT FROM PO_TENDER_HDR").get("COUNT"));
	
	
	
	
	
	String po_next_srlno = "";
	String po_start_srlno = "";
	String pr_next_srlno = "";
	String pr_start_srlno = "";
	String do_next_srlno = "";
	String do_start_srlno = "";
	String quot_next_srlno = "";
	String quot_start_srlno = "";
	String tndr_next_srlno = ""; //Added by Rabbani #inc no:30078(Bru-HIMS-CRF-119) on 27-MAY-2013
	String tndr_start_srlno = ""; //Added by Rabbani #inc no:30078(Bru-HIMS-CRF-119) on 27-MAY-2013
	
	String POdisabled = "";
	String PRdisabled = "";
	String DOdisabled = "";
	String Quotdisabled = "";
	String Tndrdisabled = ""; //Added by Rabbani #inc no:30078(Bru-HIMS-CRF-119) on 27-MAY-2013

	if(POCount>0 && DocCount>0){
		po_start_srlno = 	(String)bean.fetchRecord("SELECT PO_START_SRLNO FROM PO_DOCNO_CONTROL").get("PO_START_SRLNO");
		po_next_srlno = 	(String)bean.fetchRecord("SELECT PO_NEXT_SRLNO FROM PO_DOCNO_CONTROL").get("PO_NEXT_SRLNO");
		if((po_next_srlno != null && po_next_srlno != "") && (po_start_srlno != null && po_start_srlno != "")){
			POdisabled = "disabled";
		}else{
			POdisabled = "";
		}
	}
	if(PRCount>0 && DocCount>0){
		pr_start_srlno = 	(String)bean.fetchRecord("SELECT REQ_START_SRLNO FROM PO_DOCNO_CONTROL").get("REQ_START_SRLNO");
		pr_next_srlno = 	(String)bean.fetchRecord("SELECT REQ_NEXT_SRLNO FROM PO_DOCNO_CONTROL").get("REQ_NEXT_SRLNO");
		if((pr_next_srlno != null && pr_next_srlno != "") && (pr_start_srlno != null && pr_start_srlno != "")){
			PRdisabled = "disabled";
		}else{
			PRdisabled = "";
		}
	}
	if(DOCount>0 && DocCount>0){
		do_start_srlno = 	(String)bean.fetchRecord("SELECT DO_START_SRLNO FROM PO_DOCNO_CONTROL").get("DO_START_SRLNO");
		do_next_srlno = 	(String)bean.fetchRecord("SELECT DO_NEXT_SRLNO FROM PO_DOCNO_CONTROL").get("DO_NEXT_SRLNO");
		if((do_next_srlno != null && do_next_srlno != "") && (do_start_srlno != null && do_start_srlno != "")){
			DOdisabled = "disabled";
		}else{
			DOdisabled = "";
		}
	}
	if(QuotCount>0 && DocCount>0){
		quot_start_srlno = 	(String)bean.fetchRecord("SELECT QUOT_START_SRLNO FROM PO_DOCNO_CONTROL").get("QUOT_START_SRLNO");
		quot_next_srlno = 	(String)bean.fetchRecord("SELECT QUOT_NEXT_SRLNO FROM PO_DOCNO_CONTROL").get("QUOT_NEXT_SRLNO");
		if((quot_next_srlno != null && quot_next_srlno != "") && (quot_start_srlno != null && quot_start_srlno != "")){
			Quotdisabled = "disabled";
		}else{
			Quotdisabled = "";
		}
	}	
	 if(TndrCount>0 && DocCount>0){//Added by Rabbani #inc no:30078(Bru-HIMS-CRF-119) on 27-MAY-2013
		tndr_start_srlno = 	(String)bean.fetchRecord("SELECT TNDR_START_SRLNO FROM PO_DOCNO_CONTROL").get("TNDR_START_SRLNO");
		tndr_next_srlno = 	(String)bean.fetchRecord("SELECT TNDR_NEXT_SRLNO FROM PO_DOCNO_CONTROL").get("TNDR_NEXT_SRLNO");
		if((tndr_next_srlno != null && tndr_next_srlno != "") && (tndr_start_srlno != null && tndr_start_srlno != "")){
			Tndrdisabled = "disabled";
		}else{
			Tndrdisabled = "";
		}
	}	//ends
	
	String currentdate	   =	com.ehis.util.DateUtils.getCurrentDate("DMY",locale).toString();
 
	
	String dateParts[] = currentdate.split("/");
	String month  = dateParts[0];
	String day  = dateParts[1];
	String year = dateParts[2];
	System.out.println("year = "+year);

%>
<body>
	<form name="formDocNoGenControl" id="formDocNoGenControl" onReset="FocusFirstElement();">
	
	
	<table width='90%' border=1 cellpadding=1 cellspacing=0 align='center'>
	
	<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
	<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
	<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
	<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
	<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
	<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
		
				<tr>
				<th><fmt:message key="ePO.TransactionType.label" bundle="${po_labels}"/></th>
				<th><fmt:message key="ePO.DocGenMethod.label" bundle="${po_labels}"/></th>
				<th><fmt:message key="ePO.PrefixPurchaseUnit.label" bundle="${po_labels}"/></th>
				<th><fmt:message key="ePO.PrefixFacility.label" bundle="${po_labels}"/></th>
				<th><fmt:message key="ePO.PrefixYear.label" bundle="${po_labels}"/></th>
				<th><fmt:message key="ePO.Year.label" bundle="${po_labels}"/></th>
				<th><fmt:message key="ePO.StartDocNo.label" bundle="${po_labels}"/></th>
				<th><fmt:message key="ePO.NextDocNo.label" bundle="${po_labels}"/></th>
				
				
			</tr>
			
		
			<tr>	
			<td class='label'><b><fmt:message key="ePO.PurchaseRequest.label" bundle="${po_labels}"/></b><input type="hidden" value="REQ" name="pr_name" id="pr_name" ></td>
			<td class='label'><select name="pr_auto" id="pr_auto" onchange="prManualDisplay()" <%=PRdisabled%>>
			<option value='A' <%=bean.getPr_auto().equals("A")?"Selected":""%> ><fmt:message key="ePO.AutoGenerate.label" bundle="${po_labels}"/></option>
			<option value='M' <%=bean.getPr_auto().equals("M")?"Selected":""%> ><fmt:message key="ePO.Manual.label" bundle="${po_labels}"/></option></select></td>
			<td align=center><input type="checkbox" value="Y" name="pr_purunit_yn" id="pr_purunit_yn" <%=bean.getChecked(bean.getPr_purunit_yn())%>  <%=PRdisabled%> ></td>
			<td align=center><input type="checkbox" value="Y" name="pr_facility_yn" id="pr_facility_yn" <%=bean.getChecked(bean.getPr_facility_yn())%>  <%=PRdisabled%>></td>
			<td align=center><input type="checkbox" value="Y" name="pr_year_yn" id="pr_year_yn" <%=bean.getChecked(bean.getPr_year_yn())%>  <%=PRdisabled%>></td>
			<td align=center><input type="text" value="<%=year%>" disabled name="pr_year" size="4"></td>
			<td align=center><input type="text" value="<%=bean.checkForNull(bean.getPr_start_no())%>" name="pr_start_no" size="12" maxlength="12" onkeypress="return isValidNumber(this,event,12,'');"  <%=PRdisabled%>></td>
			<td align=center><input type="text" value="<%=bean.checkForNull(bean.getPr_next_no())%>" name="pr_next_no" size="12" maxlength="12" onkeypress="return isValidNumber(this,event,12,'');"  <%=PRdisabled%>></td>
			
			</tr>
			
		
			<tr>
			<td class='label'><b><fmt:message key="ePO.PurchaseOrder.label" bundle="${po_labels}"/></b><input type="hidden" value="PO" name="po_name" id="po_name" ></td>
			<td class='label'><select name="po_auto" id="po_auto" onchange="poManualDisplay()"  <%=POdisabled%>>
			<option value='A' <%=bean.getPo_auto().equals("A")?"Selected":""%>><fmt:message key="ePO.AutoGenerate.label" bundle="${po_labels}"/></option>
			<option value='M' <%=bean.getPo_auto().equals("M")?"Selected":""%>><fmt:message key="ePO.Manual.label" bundle="${po_labels}"/></option></select></td>
			<td align=center><input type="checkbox" value="Y" name="po_purunit_yn" id="po_purunit_yn" <%=bean.getChecked(bean.getPo_purunit_yn())%>   <%=POdisabled%>></td>
			<td align=center><input type="checkbox" value="Y" name="po_facility_yn" id="po_facility_yn" <%=bean.getChecked(bean.getPo_facility_yn())%>  <%=POdisabled%>></td>
			<td align=center><input type="checkbox" value="Y" name="po_year_yn" id="po_year_yn" <%=bean.getChecked(bean.getPo_year_yn())%>  <%=POdisabled%>></td>
			<td align=center><input type="text" value="<%=year%>" disabled name="po_year" size="4"></td>
			<td align=center><input type="text" value="<%=bean.checkForNull(bean.getPo_start_no())%>" name="po_start_no" size="12" maxlength="12" onkeypress="return isValidNumber(this,event,12,'');"  <%=POdisabled%>></td>
			<td align=center><input type="text" value="<%=bean.checkForNull(bean.getPo_next_no())%>" name="po_next_no" size="12" maxlength="12" onkeypress="return isValidNumber(this,event,12,'');"  <%=POdisabled%>></td>
			</tr>
			
			
			<tr>
			<td class='label'><b><fmt:message key="ePO.DeliveryOrder.label" bundle="${po_labels}"/></b><input type="hidden" value="DO" name="do_name" id="do_name" ></td>
			<td class='label'><select name="do_auto" id="do_auto" onchange="doManualDisplay()"  <%=DOdisabled%>>
			<option value='A' <%=bean.getDo_auto().equals("A")?"Selected":""%>><fmt:message key="ePO.AutoGenerate.label" bundle="${po_labels}"/></option>
			<td align=center>NA</td>
			<td align=center><input type="checkbox" value="Y" name="do_facility_yn" id="do_facility_yn" <%=bean.getChecked(bean.getDo_facility_yn())%>  <%=DOdisabled%>></td>
			<td align=center><input type="checkbox" value="Y" name="do_year_yn" id="do_year_yn" <%=bean.getChecked(bean.getDo_year_yn())%>  <%=DOdisabled%>></td>
			<td align=center><input type="text" value="<%=year%>" disabled name="do_year" size="4"></td>
			<td align=center><input type="text" value="<%=bean.checkForNull(bean.getDo_start_no())%>" name="do_start_no" size="12" maxlength="12" onkeypress="return isValidNumber(this,event,12,'');"  <%=DOdisabled%>></td>
			<td align=center><input type="text" value="<%=bean.checkForNull(bean.getDo_next_no())%>" name="do_next_no" size="12" maxlength="12" onkeypress="return isValidNumber(this,event,12,'');"  <%=DOdisabled%>></td>
			</tr>
			
			<tr>
			<td class='label'><b><fmt:message key="ePO.Quotation.label" bundle="${po_labels}"/></b><input type="hidden" value="Quot" name="quot_name" id="quot_name" ></td>
			<td class='label'><select name="quot_auto" id="quot_auto" onchange="quotManualDisplay()"  <%=Quotdisabled%>>
			<option value='A' <%=bean.getQuot_auto().equals("A")?"Selected":""%>><fmt:message key="ePO.AutoGenerate.label" bundle="${po_labels}"/></option>
			<td align=center>NA</td>
			<td align=center><input type="checkbox" value="Y" name="quot_facility_yn" id="quot_facility_yn" <%=bean.getChecked(bean.getQuot_facility_yn())%>  <%=Quotdisabled%>></td>
			<td align=center><input type="checkbox" value="Y" name="quot_year_yn" id="quot_year_yn" <%=bean.getChecked(bean.getQuot_year_yn())%>  <%=Quotdisabled%>></td>
			<td align=center><input type="text" value="<%=year%>" disabled name="quot_year" size="4"></td>
			<td align=center><input type="text" value="<%=bean.checkForNull(bean.getQuot_start_no())%>" name="quot_start_no" size="12" maxlength="12" onkeypress="return isValidNumber(this,event,12,'');"  <%=Quotdisabled%>></td>
			<td align=center><input type="text" value="<%=bean.checkForNull(bean.getQuot_next_no())%>" name="quot_next_no" size="12" maxlength="12" onkeypress="return isValidNumber(this,event,12,'');"  <%=Quotdisabled%>></td>
			</tr>
			<!--Added by Rabbani #inc no:30078(Bru-HIMS-CRF-119) on 27-MAY-2013-->
			<tr>
			<td class='label'><b><fmt:message key="ePO.Tender.label" bundle="${po_labels}"/><input type="hidden" value="Tndr" name="tndr_name" id="tndr_name" ></td>
			<td class='label'><select name="tndr_auto" id="tndr_auto" onchange="tenderManualDisplay()"  <%=Tndrdisabled%>>
			<option value='A' <%=bean.getTndr_auto().equals("A")?"Selected":""%>><fmt:message key="ePO.AutoGenerate.label" bundle="${po_labels}"/></option>
			<td align=center>NA</td>
			<td align=center><input type="checkbox" value="Y" name="tndr_facility_yn" id="tndr_facility_yn" <%=bean.getChecked(bean.getTndr_facility_yn())%>  <%=Tndrdisabled%>></td>
			<td align=center><input type="checkbox" value="Y" name="tndr_year_yn" id="tndr_year_yn" <%=bean.getChecked(bean.getTndr_year_yn())%>  <%=Tndrdisabled%>></td>
			<td align=center><input type="text" value="<%=year%>" disabled name="tndr_year" size="4"></td>
			<td align=center><input type="text" value="<%=bean.checkForNull(bean.getTndr_start_no())%>" name="tndr_start_no" size="12" maxlength="12" onkeypress="return isValidNumber(this,event,12,'');"  <%=Tndrdisabled%>></td>
			<td align=center><input type="text" value="<%=bean.checkForNull(bean.getTndr_next_no())%>" name="tndr_next_no" size="12" maxlength="12" onkeypress="return isValidNumber(this,event,12,'');"  <%=Tndrdisabled%>></td>
			</tr>
			<!-- ends -->
		</table>
	<br><br><br><br><br>
	
		
	
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
	<input type="hidden" name="POCount" id="POCount" value="<%=POCount%>">
	<input type="hidden" name="PRCount" id="PRCount" value="<%=PRCount%>">
	<input type="hidden" name="DocCount" id="DocCount" value="<%=DocCount%>">
	<input type="hidden" name="DOCount" id="DOCount" value="<%=DOCount%>">
	<input type="hidden" name="QuotCount" id="QuotCount" value="<%=QuotCount%>">
	<input type="hidden" name="TndrCount" id="TndrCount" value="<%=TndrCount%>">
	
	

	
	
	</form>
					<%
						putObjectInBean(bean_id,bean,request);
					%>
</body>
</html>

