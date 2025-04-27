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
	<script language="JavaScript" src="../../ePO/js/PurchaseOrder.js"></script>
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
	String master_type			=		"PORDER";
	String sql_from_pu			=		"SQL_PO_PURCHASE_UNIT_LIST";
	String sql_to_supp			=		"SQL_PO_SUPPLIER_LIST";
	String purchaseType 		=       "";
	String fromPurchaseUnit 	=       "";
	String po_mode			 	=       "";
	String docNoGenMethod		=		"";
	String docNoDisable			=		"";	
	String localCurrency		=		"";	
	String authorize			=		"No";
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


	String bean_id				=		"purchaseOrderBean";
	String bean_name			=		"ePO.PurchaseOrderBean";

	PurchaseOrderBean bean		=		(PurchaseOrderBean) getBeanObject(bean_id, bean_name, request  );  
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
	docNoGenMethod	=	(String)bean.fetchRecord(bean.getPoRepositoryValue("SQL_PO_DOC_TYPE_SELECT_FLAG_FROM_CONTROL_TABLE")).get("PO_DOC_NO_GEN_METHOD");
	
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
	
	String prq_delete_yn =		bean.checkForNull((String)bean.fetchRecord("select  PO_DELETE_ALLOWED_YN  from  PO_USER_FOR_PUNIT where PUR_UNIT_CODE=? and USER_ID=?",new String[]{bean.getRequest_by_pu(),(String) session.getValue( "login_user" )}).get("PO_DELETE_ALLOWED_YN"),"N");
	
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
	  
	  
	if(bean.getBlanket_po_yn().equals("Y") && po_mode.equals("D")){
		codeChecked = "checked";
		valHidden = "visible";
	}else{
		codeChecked = "";
		valHidden = "hidden";
	}
	  
	 String budget_check_yn =		bean.checkForNull((String)bean.fetchRecord("SELECT BUDGET_CHECK_REQD_YN FROM PO_PARAMETER").get("BUDGET_CHECK_REQD_YN"),"");
	
	 
	authorize="Y";
	
	String currentdate	   =	com.ehis.util.DateUtils.getCurrentDate("DMY",locale).toString();
	String postdate	       =    com.ehis.util.DateUtils.plusDate(currentdate,"DMY",locale,7,"d");
	
	
	
	if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) { 
		String supp_code = bean.getRequest_on_supp(); 
		
		String dflt_currency = "";
		HashMap hmRecord = bean.getCurrencyDesc(supp_code);
			if(hmRecord.size()>0){
				 dflt_currency = (String)hmRecord.get("CURRENCY_CODE");
			}
			
%>
<body onLoad="onLoadCurrCode('<%=dflt_currency%>');updateValues();loadPOMode('<%=po_mode%>');">
<% } else { %>
<body onLoad="FocusFirstElement();updateValues();loadPOMode('<%=po_mode%>');">
<% } %>
		
	<form name="formPurchaseOrderHeader" id="formPurchaseOrderHeader">
		
		<table border='0' cellpadding='2' cellspacing='0' width='102%' height='100%' align=center>
			<tr>
				<td  class="label"><fmt:message key="ePO.POMode.label" bundle="${po_labels}"/></td>													
				<td class="fields">&nbsp;
					<select name="po_mode" id="po_mode" onchange="modeorder(this)" <%=codeDisabled%>>
						<option value="D" <%=doSelected%> selected>Direct Order</option>
						<option value="R" <%=srSelected%>>Order Based on Request</option>
					</select>
					<%=bean.getImage("M")%>
				</td>
				
				<td  class="label"><fmt:message key="ePO.PORaisedBy.label" bundle="${po_labels}"/></td>
				<td class="fields">&nbsp;
					<select name="from_purchase_unit" id="from_purchase_unit" onchange="docnoEnableYN(this)" <%=codeDisabled%>>
					<%=bean.getRequestFromPurchaseUnit(bean.getRequest_by_pu())%>
					</select>
					<%=bean.getImage("M")%>
				</td>

				<td  class="label"><fmt:message key="ePO.Supplier.label" bundle="${po_labels}"/></td>
				<td class="fields">&nbsp;
					<select name="to_supplier" id="to_supplier" onChange="loadCurrency(this)" <%=codeDisabled%> >	<%=bean.getRequestToSupp(bean.getRequest_on_supp())%> 
					</select>					
					<%=bean.getImage("M")%>
				</td>
				
				
				<td  class="label"><fmt:message key="ePO.PurchaseType.label" bundle="${po_labels}"/></td>
				<td class="fields">&nbsp;
					<select name="purchase_type" id="purchase_type" <%=codeDisabled%>>
					<%=bean.getPurchase_type_List(bean.getPurchase_type())%>
					</select>
					<%=bean.getImage("M")%>
				</td>
				
				
			</tr>	
				
			<tr>
				
				<td  class="label">	<fmt:message key="ePO.PoDate.label" bundle="${po_labels}"/>	</td>
				<td class="fields">&nbsp;&nbsp;<input type="text" value="<%=doc_date%>" name="doc_date"  maxLength="10" size="10"  onBlur="CheckDate(this);checkDocDate();" <%=codeDisabled%> >&nbsp;
				<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('doc_date');" <%=codeDisabled%> ></img>
				</td>
					
				<td  class="label"><fmt:message key="ePO.PONo.label" bundle="${po_labels}"/></td>
				<td class="fields">&nbsp;&nbsp;<input type="text" class="NUMBER" value="<%=bean.getDoc_no()%>" name="doc_no" maxLength="20" size="20" onKeyPress="return CheckForSpecialChars(event);"  onBlur="checkSpecialChars(this);" <%=docNoDisable%> >
				</td>
					
				<td  class="label"><fmt:message key="ePO.PORef.label"   bundle="${po_labels}"/></td>
				<td class="fields">&nbsp;&nbsp;<input type="text" value="<%=bean.getDoc_ref()%>" name="doc_ref"  maxLength="15" size="15" >
				</td>	
				
				<td  class="label" colspan=2 style=visibility:visible id='Blanket_order'  ><fmt:message key="ePO.BlanketPurchase.label" bundle="${po_labels}"/>
				
					<input type="checkbox" value="Y" name="blanket_po_yn" id="blanket_po_yn" onclick="displayValidUpto(this);" <%=codeChecked%> <%=codeDisabled%>>
					<span id="validUptoHidden" style=visibility:<%=valHidden%>>
					<label id='valid_upto_label' class="label" >&nbsp;<fmt:message key="ePO.ValidUpto.label" bundle="${po_labels}"/></label>
							
					<input type="text" value="<%=bean.getValid_upto()%>" name="valid_upto"  maxLength="10" size="10"  onBlur="CheckDate(this);checkValidate(this);" <%=codeDisabled%> >&nbsp;
				<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('valid_upto');" name='val_img' ></img>
				<%=bean.getImage("M")%>
				</span>
				</td>
					
				
			</tr>
			<tr>
				<td class=label align=right colspan=2>
					<a href="javascript:OrderRemarks('<%=bean_id%>','<%=bean_name%>','<%=mode%>')">Order Remarks</a>
				</td>	
				<td class=label align=right colspan=2>
					<a href="javascript:AdditionalDetails('<%=bean_id%>','<%=bean_name%>','<%=mode%>')">Additional Details</a>
				</td>	

				<td class='label' id = 'reqid' style="<%=display_flag%>" >Req Doc No</td>
				<td class='field' style="<%=display_flag%>" >&nbsp;&nbsp;<input type='text' name='ReqDocNO' id='ReqDocNO' id= 'reqiddocno'   size=10 maxLength=15 value="" disabled  >
					<input type=button name="doc_no_search" id="doc_no_search" id = 'doc_search'  class="button"   onClick="searchDetails()"  value='?'  ></td>
			
				<td  class="label">	<fmt:message key="ePO.ExpDelDate.label" bundle="${po_labels}"/>	</td>
				<% if(bean.checkForNull(bean.getExp_date()) != "" && bean.checkForNull(bean.getExp_date()) != null) {%>
					<td class="fields">&nbsp;&nbsp;<input type="text" value="<%=bean.checkForNull(bean.getExp_date())%>" name="exp_date"  maxLength="10" size="10"  onBlur="CheckDate(this);loadDelDate(this); checkexpdate(this);" <%=codeDisabled%> >&nbsp;
				<% } else { %>
					<td class="fields">&nbsp;&nbsp;<input type="text" value="<%=postdate%>" name="exp_date"  maxLength="10" size="10"  onBlur="CheckDate(this);loadDelDate(this);checkexpdate(this);checkDocDate();" <%=codeDisabled%>>&nbsp;
				<% } %>
			<!--	<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('exp_date');loadDelDate(this);" id='exp_img' style=visibility:visible ></img>  -->
				<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('exp_date');loadDelDate(this);" name='exp_img' id='exp_img' style=visibility:visible <%=codeDisabled%>></img> 
				<%=bean.getImage("M")%>
				</td>	
			 
			</tr>
			
			<tr>			
					
				<td class='label' ><fmt:message key="ePO.TransactionCurrency.label" bundle="${po_labels}"/></td>
				<td  class='fields' nowrap>&nbsp;
					<select name="currency_code" id="currency_code" onchange="setCurrCode(this)" <%=codeDisabled%>><%=bean.loadCurrencyList(bean.checkForNull(bean.getCurrency_code()))%>
					</select>  
					<%=bean.getImage("M")%>
				</td>
			
				<td class='label' ><fmt:message key="ePO.ExchangeRate.label" bundle="${po_labels}"/></td>
				<td  class='fields' nowrap>&nbsp;&nbsp;
					<input type="text" value="<%=bean.getExc_rate()%>" name="exc_rate" class=NUMBER  maxLength="8" size="8" onKeyPress="return isValidNumber(this,event,8,3); return isValidInteger(); " onBlur="" <%=codeDisabled%>>
					<%=bean.getImage("M")%>
				</td>
				
				<td class='label'><fmt:message key="ePO.LocalCurrency.label" bundle="${po_labels}"/></td>
				<td  class='fields' nowrap>&nbsp;&nbsp;<%=bean.checkForNull(localCurrency)%>
				<input type="hidden" name="local_currency" id="local_currency"	value="<%=bean.checkForNull(localCurrency)%>">	
				</td>
				
				
				<td class='label'><fmt:message key="ePO.OldPurchaseOrderNo.label" bundle="${po_labels}"/></td>
				<td>&nbsp;
				<input type="text" name="old_po_no" id="old_po_no" size="20" maxlength="20"  value="" <%=codeDisabled%> >
		
				<!-- <input type="button" value="?" class="button" onClick="" >&nbsp; -->
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
						
	</form>
<% 
putObjectInBean(bean_id,bean,request);
%>
</body>
</html>



