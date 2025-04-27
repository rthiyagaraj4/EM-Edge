<!DOCTYPE html>
<%@ page import=" ePO.*, ePO.Common.* , eCommon.Common.*,  java.util.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<% 
		String sStyle		=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../ePO/js/PoCommon.js"></script>
	<script language="JavaScript" src="../../ePO/js/PoTransaction.js"></script>
	<script language="JavaScript" src="../../ePO/js/DeliveryOrder.js"></script>
	<script language="JavaScript" src="../../ePO/js/PoDuoHeader.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    <script>
        function_id				=		 "<%= request.getParameter("function_id") %>"
		
		menu_id					=		 "<%= request.getParameter("menu_id") %>"
		module_id				=		 "<%= request.getParameter("module_id") %>"
    </script>
</head>
<%

	String trn_type				=		"PO";
	String master_type			=		"DLVORD";
	String sql_from_pu			=		"SQL_PO_PURCHASE_UNIT_LIST";
	String sql_to_supp			=		"SQL_PO_SUPPLIER_LIST";
	String purchaseType 		=       "";
	String fromPurchaseUnit 	=       "";
	String po_mode			 	=       "";
	String docNoGenMethod		=		"A";
	String docNoDisable			=		"";	
	String localCurrency		=		"";	
	//String authorize			=		"No";
	String authorize			=		"Yes";
	String display_flag			= 		"visibility:hidden"; 
	String codeDisabled			=		"";
	String codeChecked 			= 		"";
	String valHidden 			= 		"";	
	request.setCharacterEncoding("UTF-8");
	String locale				=		(String)session.getAttribute("LOCALE");
	String	mode				=		request.getParameter("mode");
	mode						=		mode.trim();
	
	
	if ((mode == null) || (mode.equals(""))) 
		return;
	if (!(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))))
		return;


	String bean_id				=		"deliveryOrderBean";
	String bean_name			=		"ePO.DeliveryOrderBean";

	DeliveryOrderBean bean		=		(DeliveryOrderBean) getBeanObject(bean_id, bean_name, request  );  
	bean.setLanguageId(locale);
		
	if (mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
		bean.initialize();
	}else {
		codeDisabled						=	 "Disabled";
	}	
	
	ServletContext context					=	getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 

	bean.setLocalEJB(false);
	bean.setMode(mode.trim());
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.setMasterType(master_type);
	String[] stParameters ={bean.getLoginById()};	
	fromPurchaseUnit				=		(String)bean.fetchRecord(bean.getPoRepositoryValue(sql_from_pu),stParameters).get("CODE");
	bean.setFrom_purchase_unit(bean.checkForNull(fromPurchaseUnit));
	String[] stParameters1 ={master_type,bean.getLanguageId()};	
	purchaseType	=	(String)bean.fetchRecord(bean.getPoRepositoryValue("SQL_PO_PURCHASE_TYPE_SELECT"),stParameters1).get("MASTER_CODE");
	//bean.setPurchase_type(bean.checkForNull(purchaseType));	
	//docNoGenMethod	=	(String)bean.fetchRecord(bean.getPoRepositoryValue("SQL_PO_DOC_TYPE_SELECT_FLAG_FROM_CONTROL_TABLE")).get("PO_DOC_NO_GEN_METHOD");
	System.out.println("docNoGenMethod = "+docNoGenMethod);
	if (mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
		if(bean.checkForNull(docNoGenMethod).equals("A")){
			docNoDisable="disabled";
		}else if(bean.checkForNull(docNoGenMethod).equals("M")){
			docNoDisable="";
		}
	}else{
		docNoDisable="disabled";
	}	
	
	localCurrency	=	(String)bean.fetchRecord(bean.getPoRepositoryValue("SQL_PO_LOCAL_CURRENCY_SELECT")).get("BASE_CURRENCY");
	
	String localCurrency_desc =	bean.checkForNull((String)bean.fetchRecord("select  SHORT_DESC  from  SY_FOREIGN_CURRENCY where CURRENCY_CODE=?",new String[]{localCurrency}).get("SHORT_DESC"),"");
	
	String prq_delete_yn =	bean.checkForNull((String)bean.fetchRecord("select  DO_DELETE_ALLOWED_YN  from  PO_USER_FOR_DELVORD where USER_ID=?",new String[]{(String) session.getValue( "login_user" )}).get("DO_DELETE_ALLOWED_YN"),"N");
	
	String poReqd =		bean.checkForNull((String)bean.fetchRecord("SELECT PO_REQD_FOR_DO FROM PO_PARAMETER").get("PO_REQD_FOR_DO"),"");
	String poReqdDisabled = "";
	String tranDisabled = "";
	String doSelected = "";
	String srSelected = "";
	String reqNoDisabled = "";
		
	po_mode= bean.checkForNull(bean.getPo_mode());

	if(po_mode.equals("D"))
	   doSelected = "selected";
	else if(po_mode.equals("R")){
	   srSelected = "selected";
	   reqNoDisabled = "disabled";
	} 
	 
	String doc_date			    =		bean.checkForNull(bean.getDoc_date()) ;
	  System.out.println("doc_date in hdr= "+doc_date);	
	  
	if(bean.getBlanket_po_yn().equals("Y") && po_mode.equals("D")){
		codeChecked = "checked";
		valHidden = "visible";
	}else{
		codeChecked = "";
		valHidden = "hidden";
	}
	  
	 String budget_check_yn =		bean.checkForNull((String)bean.fetchRecord("SELECT BUDGET_CHECK_REQD_YN FROM PO_PARAMETER").get("BUDGET_CHECK_REQD_YN"),"");
	System.out.println("budget_check_yn in dtl = "+budget_check_yn); 
	 
	authorize="Y";
	
	String currentdate	   =	com.ehis.util.DateUtils.getCurrentDate("DMY",locale).toString();
	String postdate	       =    com.ehis.util.DateUtils.plusDate(currentdate,"DMY",locale,7,"d");
	
	System.out.println("post date in po hdr = "+postdate);
	
	if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) { 
		String supp_code = bean.getRequest_on_supp(); 
		System.out.println("supp_code in hdr = "+supp_code);
		String dflt_currency = "";
		HashMap hmRecord = bean.getCurrencyDesc(supp_code);
			if(hmRecord.size()>0){
				 dflt_currency = (String)hmRecord.get("CURRENCY_CODE");
			}
			System.out.println("dflt_currency in hdr = "+dflt_currency);
	}		
	
	//System.out.println("bean.getRequestToSupp in do hdr = "+bean.getRequestToSupp());
	System.out.println("mode in do hdr = "+mode);
%>
<body onLoad="FocusFirstElement();">
		
	<form name="formDeliveryOrderHeader" id="formDeliveryOrderHeader">
		
		<table border='0' cellpadding='0' cellspacing='0' width='100%' align=center>
			<tr>
				<td  class="label"><fmt:message key="ePO.DOType.label" bundle="${po_labels}"/></td>													
				<td class="fields">&nbsp;
					<select name="delivery_type" id="delivery_type" <%=codeDisabled%>>
					<%=bean.getDelivery_type_List(bean.getDelivery_type())%>
					</select>
					<%=bean.getImage("M")%>
				</td>
				
				<td  class="label"><fmt:message key="ePO.DONo.label" bundle="${po_labels}"/></td>
				<td class="fields">&nbsp;&nbsp;<input type="text" class="NUMBER" value="<%=bean.getDoc_no()%>" name="doc_no" maxLength="20" size="20" onKeyPress="return CheckForSpecialChars(event);" <%=docNoDisable%> >
				</td>

				<td  class="label"><fmt:message key="ePO.DODate.label" bundle="${po_labels}"/></td>
				<td class="fields">&nbsp;&nbsp;<input type="text" value="<%=doc_date%>" name="doc_date"  maxLength="10" size="10"  onBlur="CheckDate(this);" <%=codeDisabled%> >&nbsp;
				<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('doc_date');" <%=codeDisabled%> ></img>
				</td>
				
				
				<td  class="label"><fmt:message key="ePO.DORef.label" bundle="${po_labels}"/></td>
				<td class="fields">&nbsp;&nbsp;<input type="text" value="<%=bean.getDoc_ref()%>" name="doc_ref" maxLength="20" size="20" onKeyPress="return CheckForSpecialChars(event);"  >
				</td>
				
				
			</tr>	
				
			<tr>
				
				<td  class="label">	<fmt:message key="ePO.Supplier.label" bundle="${po_labels}"/>	</td>
				<td class='fields'>&nbsp;&nbsp;<select name='supplier_code' id='supplier_code' value="" <%=codeDisabled%>>
		<%
			//out.println(bean.getSupp_code_List());
		%>
		<%=bean.getSupp_code_List()%>
		
		</select><%=bean.getImage("M")%>
				</td>
				
				<td class='field' colspan=2 ><input type='hidden' name='po_no' id='po_no'  size=10 maxLength=15 value="" disabled  >
					<input type=button name="podetail_search" id="podetail_search" class="button" onClick="Load_PurchaseOrderDetails(po_no,supplier_code);"  value='PO Search' <%=poReqdDisabled%>>
				</td>	
				<td class="label" ><label onMouseOver="changeCursor(this);"  class="label" onClick = "AdditionalDetails('<%=bean_id%>','<%=bean_name%>','<%=mode%>');"><font class='HYPERLINK'><fmt:message key="ePO.AdditionalDetails.label" bundle="${po_labels}"/></font></label></td>
				</td>
			</tr>
			
			<tr>			
					
				<td class='label' ><fmt:message key="ePO.TransactionCurrency.label" bundle="${po_labels}"/></td>
				<td  class='fields' nowrap>&nbsp;
					<select name="currency_code" id="currency_code" onchange="setCurrCode(this);loadExRateHdr();" <%=codeDisabled%> <%=tranDisabled%>><%=bean.loadCurrencyList(bean.checkForNull(bean.getCurrency_code()))%> 
					</select>  
					<%=bean.getImage("M")%>
				</td>
			
				<td class='label' ><fmt:message key="ePO.ExchangeRate.label" bundle="${po_labels}"/></td>
				<td  class='fields' nowrap>&nbsp;&nbsp;
					<input type="text" value="<%=bean.getExc_rate()%>" name="exc_rate" class=NUMBER  maxLength="10" size="10" onKeyPress="return isValidNumber(this,event,10,3); return isValidInteger(); " onBlur="loadExRateHdr();" <%=codeDisabled%>>
					<%=bean.getImage("M")%>
				</td>
				
				<td class='label'><fmt:message key="ePO.LocalCurrency.label" bundle="${po_labels}"/></td>
				<td  class='fields' nowrap>&nbsp;&nbsp;<%=bean.checkForNull(localCurrency_desc)%>
				<input type="hidden" name="local_currency" id="local_currency"	value="<%=bean.checkForNull(localCurrency)%>">	
				</td>
				
			</tr>
				
		</table>
			
			<input type="hidden" 	name="mode" id="mode"					value="<%=mode%>">
			<input type="hidden" 	name="bean_id" id="bean_id"				value="<%=bean_id%>">
			<input type="hidden" 	name="bean_name" id="bean_name"			value="<%=bean_name%>">
			<input type='hidden' 	name="trn_type" id="trn_type"				value="PO">
			<input type="hidden" 	name="function_id" id="function_id"         	value="<%=bean.getFunctionId()%>">
			<input type='hidden' 	name="request_by_pu" id="request_by_pu"		value="<%=bean.getRequest_by_pu()%>">
			<input type='hidden' 	name="request_on_supp" id="request_on_supp"		value="<%=bean.getRequest_on_supp()%>">
			<input type='hidden' 	name="authorize_yn" id="authorize_yn"	    	value="<%=authorize%>">
			<input type='hidden' 	name="autono_yn" id="autono_yn"			value="">
			<input type='hidden' 	name="order_remarks" id="order_remarks"		value="">
			<input type='hidden' 	name="supp_code" id="supp_code"	    	value="">
			<input type="hidden"	name="prq_delete_yn" id="prq_delete_yn"		value="<%=prq_delete_yn%>">
			<input type="hidden"		name="budget_check_yn" id="budget_check_yn"			 value="<%=budget_check_yn%>">
			<input type="hidden"		name="store_code" id="store_code"			 value="">
			
						
	</form>
<% 
putObjectInBean(bean_id,bean,request);
%>
</body>
</html>



