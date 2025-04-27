<!DOCTYPE html>
<!-- 
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
?				100					?           created
05/11/2020      IN074347           Prabha      05/11/2020     Manickavasagam J          SKR-SCF-1462
-------------------------------------------------------------------------------------------------------------
---->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>
<html>
	<head>
		
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086	

		String locale			= (String)session.getAttribute("LOCALE");
		String billing_preference_basis = request.getParameter("billing_preference_basis");
		String drugDesc			= request.getParameter("drugDesc");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")? (String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		if (billing_preference_basis.equals("G")){					
%>
			<title><fmt:message key="ePH.PreferredDrugsByGenericfor.label" bundle="${ph_labels}"/> <%=drugDesc%></title>
<%
		}
		else{				
%>
			<title><fmt:message key="ePH.PreferredDrugsBySpecficfor.label" bundle="${ph_labels}"/> <%=drugDesc%></title>
<%
		}
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="Javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
		<script language="JavaScript" src="../../ePH/js/DrugDetailsDisplay.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%
		//String drugDesc			="";
		try{

		String	bean_id			=	request.getParameter("bean_id");
		String	bean_name		=	"ePH.DrugSearchBean";
		DrugSearchBean bean		=	(DrugSearchBean)getBeanObject( bean_id, bean_name, request ) ;
	    bean.setLanguageId(locale);
	    String facility_id					= (String) session.getValue("facility_id");
		String param_bean_id				= "@DrugInterfaceControlBean";
		String param_bean_name				= "ePH.DrugInterfaceControlBean";
		DrugInterfaceControlBean param_bean	= (DrugInterfaceControlBean)getBeanObject( param_bean_id, param_bean_name, request );
		param_bean.setLanguageId(locale);
		String drug_db_interface_yn			=	param_bean.getDrugDBInterface_yn(facility_id); 
	

		String from				=	request.getParameter("from");
		String to				=	request.getParameter("to");
		String searchBasedOn	=	request.getParameter("searchBasedOn");
		String identity			= request.getParameter("identity");
	
		String drugorfluid		= bean.getDrugOrFluid();
		String search_by		= bean.getSearchBy();
		String title			= "";
		String store_desc		=	"";
		String store_code		=	"";
		String description		=	"";
		String disp_charge_dtl_in_drug_lkp_yn="";
		String disp_price_type_in_drug_lkp="";
		String disp_charge_dtl_in_drug_lkp_yn1 ="";
		String disp_price_type_in_drug_lkp1 ="";
		disp_charge_dtl_in_drug_lkp_yn	=	request.getParameter("disp_charge_dtl_in_drug_lkp_yn");
		disp_price_type_in_drug_lkp	=	request.getParameter("disp_price_type_in_drug_lkp");
		String bl_install_yn	=	request.getParameter("bl_install_yn");
		String billingPriority	=	request.getParameter("billingPriority");
		String drug_class="";
		String prompt_alert_check_YN="";
		String billing_preference_check_YN=""; 
		String preffered_drug_alert_text="";
		String showAlert ="";
		String encounter_id ="";
		String episodeType = "";
		String episodeId = "";
		String visitId = "";
		String itemCode = "";
		String billingPrefereneBasisInd= "";
		String billingPreferredItemCode = "";
		String billingErrorMsg = "";
		String item_code = request.getParameter("item_code");
		String prev_drug_code = request.getParameter("drugCode");
		String generic_id = "";
		//String billing_preference_basis = request.getParameter("billing_preference_basis");
		String patient_id				= bean.getPatientId();
		String or_bean_name				= "eOR.OrderEntryBean";
		String or_bean_id				= "@orderentrybean"+patient_id+encounter_id;
		OrderEntryBean orbean			= (OrderEntryBean)getBeanObject( or_bean_id,or_bean_name,request ) ;
		orbean.setLanguageId(locale);
		//String resp_id					= orbean.getResponsibilityId();
		String resp_id                  = (String) session.getValue("responsibility_id");	
		bean.setRespId(resp_id);
		String practitionerId			= orbean.getPractitionerId();
		String drug_priv_appln_yn		= (String) session.getValue("PrivilegeApplicability");
		
		if(billing_preference_basis.equals("S")){
			item_code = item_code;	
		}
		else{
			item_code = prev_drug_code;
		}
		ArrayList remaining_search = new ArrayList();			
		if(search_by.equals("D")) {
			//title	=	"Drug Name";
		    title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DrugName.label","common_labels");
			remaining_search.add("G");
			remaining_search.add("T");
		}
		else if(search_by.equals("G")) {
			//title	=	"Generic Name";
			title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.GenericName.label","common_labels");
			remaining_search.add("D");
			remaining_search.add("T");
		}
		else if(search_by.equals("T")) {
			//title	=	"Trade Name";
			title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TradeName.label","common_labels");
			remaining_search.add("D");
			remaining_search.add("G");
		}
		else if(search_by.equals("A")) {
			//title	=	"Drug Name";
			title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DrugName.label","common_labels");
			remaining_search.add("D");
			remaining_search.add("T");
			remaining_search.add("G");
		}
		else {
			//title	=	"Drug Name";
			title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DrugName.label","common_labels");
			remaining_search.add("G");
			remaining_search.add("T");
		}

		if(drugorfluid==null){
			drugorfluid="";
		}

		String order_type_code = "";
		String Classification = "";
		String res_by_service	= "";
		String service_code		= "";
		String consider_stock	=	"N";
		String bean_id_2		= "@PrescriptionBean_1"+patient_id;
		String bean_name_2		= "ePH.PrescriptionBean_1";

		PrescriptionBean_1 bean_2		= (PrescriptionBean_1)getBeanObject( bean_id_2, bean_name_2, request ) ;	
		bean_2.setLanguageId(locale);
		if (identity==null){
			identity="General";
		}
		bean.setIdentity(identity);
		ArrayList stock_params	=	bean.validateForStock();

		if(stock_params.size() > 1) {
			consider_stock	=	(String)stock_params.get(0);
			disp_charge_dtl_in_drug_lkp_yn=(String)stock_params.get(2);
			disp_price_type_in_drug_lkp = (String)stock_params.get(3);
		}

		if (from == null)
			from = "";
		if (to == null)
			to = "";
		ArrayList arrList = new ArrayList();
		generic_id = bean.getGenericId(item_code);

		if(!search_by.equals("A")){
			if ((searchBasedOn.equals("Drug"))||(searchBasedOn.equals("ATC"))){		
				arrList	= (ArrayList)bean.searchBasedOnDataSelected_preferred(from,to, bl_install_yn, disp_charge_dtl_in_drug_lkp_yn, disp_price_type_in_drug_lkp,generic_id,item_code,billing_preference_basis,drug_priv_appln_yn,billingPriority);	
			}
		}
		else if(search_by.equals("A")){
			bean.setSearchBy("A");
			if ((searchBasedOn.equals("Drug"))||(searchBasedOn.equals("ATC"))){		
				arrList	= (ArrayList)bean.searchBasedOnDataSelected_preferred(from,to, bl_install_yn, disp_charge_dtl_in_drug_lkp_yn, disp_price_type_in_drug_lkp,generic_id,item_code,billing_preference_basis,drug_priv_appln_yn,billingPriority);
			}
		}

		Hashtable ht = (Hashtable)bean.getSelectedDrugs();
		String enableDisable="";
		String in_formulary_yn	=	bean.getInFormulary();
		if (ht.size()==0){
			enableDisable = "disabled";		
		}
%>
		<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
			<form name="frmDrugNameCommonLookupResult" id="frmDrugNameCommonLookupResult">
<%
				if (arrList.size()>=1){
%>
					<br>
					<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center" name="resultTable" id="resultTable" id="resultTable">
						<tr>
							<td class="COLUMNHEADER" width="1%">&nbsp;</td>
<%
							if(identity.equals("MedicationOrder")){
								if(((bean_2.getExternalpatient_id()==null)||   (bean_2.getExternalpatient_id()).equals("") || 	(bean_2.getExternalpatient_id()=="") ) ){ /*Modified For SKR-SCF-1642 */
%>                                  
									<td class="COLUMNHEADER" width="2">&nbsp;</td>
<%		
								}
							}
%>
							<td class="COLUMNHEADER" width="10%"><fmt:message key="ePH.Form.label" bundle="${ph_labels}"/></td>
							<td class="COLUMNHEADER" width="40%"><%=title%></td>
							
<%
							if (identity.equals("MedicationOrder") ){
%>								
								
								<td class="COLUMNHEADER" width="3%"><fmt:message key="ePH.Information.label" bundle="${ph_labels}"/></td>
<%
								if(bl_install_yn.equals("Y") && disp_charge_dtl_in_drug_lkp_yn.equals("Y") && in_formulary_yn.equals("Y")){
%>
									<td class="COLUMNHEADER"><fmt:message key="ePH.Pay.label" bundle="${ph_labels}"/>
									</td>
									<td class="COLUMNHEADER"><fmt:message key="Common.Reimburse.label" bundle="${common_labels}"/>
									</td>
									<td class="COLUMNHEADER"><fmt:message key="ePH.National.label" bundle="${ph_labels}"/>
									</td>
									<td class="COLUMNHEADER"><fmt:message key="Common.UnitPrice.label" bundle="${common_labels}"/>
									</td>
<%
								}
							}
%>
							<td class="COLUMNHEADER" width="18%"><fmt:message key="Common.Strength.label" bundle="${common_labels}"/></td>
							<td class="COLUMNHEADER" width="12%"><fmt:message key="ePH.AdminRoute.label" bundle="${ph_labels}"/></td>
<%
							if (identity.equals("MedicationOrder") ){
%>
								<td class="COLUMNHEADER">&nbsp;</td>
<%
	
								if(consider_stock.equals("Y")) { 
									if( ( (bean_2.getExternalpatient_id()==null)|| (bean_2.getExternalpatient_id()).equals("") || 	(bean_2.getExternalpatient_id()=="") ) ){ /*Modified For SKR-SCF-1642 */
%>
										<td class="COLUMNHEADER"><fmt:message key="ePH.AvailableQty.label" bundle="${ph_labels}"/></td>
										<td class="COLUMNHEADER"><fmt:message key="ePH.Quantity/Uom.label" bundle="${ph_labels}"/></td>
<%		
									}
								}	
								if(!drugorfluid.equals("F") && !drugorfluid.equals("IVF")) { 
%>
								
<%
								}
							}
%>
						</tr>
<%
							String strEnableDisable =	"";
							String strChecked		=	"";
							String classvalue		=	"";
							Hashtable htDisableDrugs = bean.getDrugsAsDisabled();	

							String onClick			=	"";
							String plus_sign		=	"";
							String mouse_over		=	"";
							ArrayList stock_dtls	=	null;
							String stock_yn			=   "";
							String avl_qty			=	"";
							String qty_uom			=	"";
							String drug_code		=	"";
							String in_formulary		=	"";
							String str_click		=	"";
							String font_class		=	"";
							String trade_code="";
							String trade_name ="";
							String disp_str ="";
							String error_code = "";
							String sys_message_id = "";
							String error_text = "";

							for (int i=0;i<arrList.size();i++){
								String[] strArray=(String[])arrList.get(i);

								drug_code		= strArray[0];
								if(search_by.equals("G")) {
									description	=	strArray[8];
								} 
								else {
									description	=	strArray[1];
								}

								strArray[1]	=	java.net.URLEncoder.encode(strArray[1],"UTF-8");
								if(strArray.length >= 14){
									in_formulary	= strArray[13];
								}
								else{
									in_formulary	= "N";
								}
								trade_code= strArray[10];
								if(trade_code ==null)
									trade_code = "";
								trade_name=strArray[11];
								drug_class=strArray[21];

								if(in_formulary.equals("Y")) {
									if (identity.equals("MedicationOrder")){
										//consider_stock added during PE corrections by Naveen
										stock_dtls		= bean.checkStock(drug_code, trade_code, drug_class, order_type_code,consider_stock,(String)stock_params.get(1),patient_id,encounter_id);
									}
								}

								classvalue		 =	"";
								strEnableDisable =	"";
								stock_yn		 =   "";
								avl_qty			 =	"";
								qty_uom			 =	"";
								store_desc		 =  "";
								store_code		 =  "";

								qty_uom				=	bean.getStockUOM(strArray[0]);
								qty_uom = qty_uom==null?"&nbsp;":qty_uom;

								if ( i % 2 == 0 )
									classvalue = "QRYODD" ;
								else
									classvalue = "QRYEVEN" ;
								plus_sign	=	"callDrugDetailsDisplay('"+strArray[0]+"')";
								mouse_over	=	"changeCursor(this);";

								if(htDisableDrugs !=null){
									if (htDisableDrugs.contains(strArray[0])){
										strEnableDisable = "disabled";
										strChecked	="checked";
										onClick		=	"";
										//plus_sign	=	"";
										//mouse_over	=	"";
									}
									else{
										strEnableDisable = "";
										strChecked="";
										onClick	=	"preferredDrugSearchModify(this,'"+strArray[8]+"','"+strArray[9]+"','"+strArray[2]+"','"+strArray[3]+"','"+strArray[4]+"','"+strArray[6]+"','"+strArray[12]+"','"+strArray[0]+"','"+strArray[10]+"','"+java.net.URLEncoder.encode(strArray[11],"UTF-8")+"','"+i+"');";
										//plus_sign	=	"callDrugDetailsDisplay('"+strArray[0]+"')";
										//mouse_over	=	"changeCursor(this);";
									}
								}
							if(consider_stock.equals("Y")  && (in_formulary.equals("Y"))) {
									if(stock_dtls!=null && stock_dtls.size() > 0) {
										stock_yn			=	(String)stock_dtls.get(0);
										avl_qty				=	(String)stock_dtls.get(1);
										store_desc			=	(String)stock_dtls.get(2)==null?"":(String)stock_dtls.get(2);
										if(store_desc.indexOf('|') != -1)
											store_desc = store_desc.substring(0,store_desc.indexOf('|'));
										if(strEnableDisable.equals(""))
											strEnableDisable	=	(String)stock_dtls.get(3);						
										store_code			=	(String)stock_dtls.get(4)==null?"":(String)stock_dtls.get(4);
									}
									
									if(identity.equals("MedicationOrder") && stock_params.size() > 1 ) {
										String allow_yn	=	(String)stock_params.get(1);
										
										if(allow_yn.equals("N") && (stock_dtls.size()==0 || avl_qty.equals(""))) {
											strEnableDisable	=	"disabled";
										} 
									}
								} 
								else {
									if(stock_dtls!=null && stock_dtls.size() > 0) {
										avl_qty				=	(String)stock_dtls.get(1);
										store_desc			=	(String)stock_dtls.get(2)==null?"":(String)stock_dtls.get(2);	
										if(store_desc.indexOf('|') != -1)
											store_desc = store_desc.substring(0,store_desc.indexOf('|'));
										store_code			=	(String)stock_dtls.get(4)==null?"":(String)stock_dtls.get(4);	
										if(avl_qty.equals("") || avl_qty.equals("0"))
											stock_yn			=	"N";
										else					
											stock_yn			=	"Y";
									}
								}

								if(avl_qty.equals("") || avl_qty.equals("0")) {
									avl_qty	=	"0";
								}
								error_code = strArray[17]==null?"":strArray[17];    
								sys_message_id = strArray[18]==null?"":strArray[18];
								error_text = strArray[19]==null?"":strArray[19]; 

								if (((error_code.equals("10") && (!error_text.equals(""))) ||!sys_message_id.equals(""))&&(!sys_message_id.equals("BL9743"))){
									strEnableDisable	=	"disabled";
								}
%>
								
								<tr >
									<td onClick="<%=plus_sign%>" onclick="disableClick(event);" class="<%=classvalue%>"><font class='HYPERLINK' onmouseover="<%=mouse_over%>">+</font></td>	
<%	
									
                                  if(identity.equals("MedicationOrder")){%>
									  <input type ="hidden" name = "previligeGroupDrug_ordering_YN<%=i%>" value ="<%=strArray[25]%>" />
                                 <%  if( ( (bean_2.getExternalpatient_id()==null)||  (bean_2.getExternalpatient_id()).equals("") || 	(bean_2.getExternalpatient_id()==""))){			/*Modified For SKR-SCF-1642 */
										if(consider_stock.equals("Y") && (stock_yn.equals("") || stock_yn.equals("N"))) { 
%>
											<td class='INSUFFICIENTSTOCK' width='2' title="<%=store_desc%>">&nbsp;</td>		
<%   
										}
										else { 
%>
											<td class='<%=classvalue%>' width='2'></td>
<%
										}	
									}
								  }
%>
									<td onclick="disableClick(event);" class="<%=classvalue%>" title="<%=store_desc%>"><%= strArray[5] %></td>
<%
	
									if (strEnableDisable != null){
										if(!strEnableDisable.equals("disabled")){								
									

%>
									<td id="drug_name<%=i%>" onClick="<%=onClick%>" class="<%=classvalue%>" title="<%=store_desc%>">
										<input type="hidden" name="drug_code<%=i%>" id="drug_code<%=i%>" id="drug_code<%=i%>" value="<%=strArray[0]%>"><input type="hidden" name="line_no<%=i%>" id="line_no<%=i%>" id="line_no<%=i%>" value="<%=i%>"><input type="hidden" name="trade_code<%=i%>" id="trade_code<%=i%>" id="trade_code<%=i%>" value="<%=trade_code%>"><input type="hidden" name="trade_name<%=i%>" id="trade_name<%=i%>" id="trade_name<%=i%>" value="<%=trade_name%>">
											<font class='HYPERLINK' onmouseover="changeCursor(this);" ><%= description %>
											</font>
<%
											if(!strArray[11].equals("")){
%>
												<label class="label" style="font-size:xx-small;font-weight:normal" >(<%=strArray[11]%>)</label>
<%
											}
%>
										</td>
										
								

<%   
										if(identity.equals("MedicationOrder")){
%>
											<td class="<%=classvalue%>" style='TEXT-ALIGN:center;'>&nbsp;
												<input type='hidden' name='diagnosis_found_yn<%=i%>' id='diagnosis_found_yn<%=i%>' value='<%=strArray[20]%>'>
												<input type='hidden' name='appl_for_age_grp_yn<%=i%>' id='appl_for_age_grp_yn<%=i%>' value='<%=strArray[22]%>'>
<%										
												  if(drug_db_interface_yn.equals("Y")){
													if(bean.getExternalProductId(strArray[0])!=null  ){
%>
														<img src="../../ePH/images/info.gif"  height='15' width='15' style="cursor:pointer" onClick='showDrugInfo("<%=bean.getExternalProductId(strArray[0])%>","<%=java.net.URLEncoder.encode(strArray[1],"UTF-8")%>")'>
<%
													}
												 }
%>
											</td>
<%
											if(bl_install_yn.equals("Y") && disp_charge_dtl_in_drug_lkp_yn.equals("Y") && in_formulary_yn.equals("Y")){
												if(strArray[16]!=null && !strArray[16].equals("")&& !strArray[16].equals("0")){
													disp_str = "<img src=\"../../eCommon/images/enabled.gif\"></img>";
												}
												else{
													disp_str = "&nbsp";
												}
%>
												<td class="<%=classvalue%>" style='TEXT-ALIGN:center;'><%=disp_str%>												
												</td>
<%
												if(strArray[14]!=null && !strArray[14].equals("")&& strArray[14].equals("Y")){
													disp_str = "<img src=\"../../eCommon/images/enabled.gif\"></img>";
												}
												else{
													disp_str = "&nbsp";
												}
%>
												<td class="<%=classvalue%>" style='TEXT-ALIGN:center;'> <%=disp_str%>
												</td>
<%
												if(strArray[15]!=null && !strArray[15].equals("") && strArray[15].equals("Y")){
													disp_str = "<img src=\"../../eCommon/images/enabled.gif\"></img>";
												}
												else{
													disp_str = "&nbsp";
												}
%>
												<td class="<%=classvalue%>" style='TEXT-ALIGN:center;'><%=disp_str%>
												</td>
<%
												if(strArray[16]!=null && !strArray[16].equals("")&& !strArray[16].equals("0")){
													disp_str =strArray[16] ;
												}
												else{
													disp_str = "&nbsp";
													if (((error_code.equals("10") && (!error_text.equals(""))) ||!sys_message_id.equals(""))&&(!sys_message_id.equals("BL9743"))){
														disp_str = "<font style=color:red>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")+"</font>";
													}
												}
%>
												<td class="<%=classvalue%>" style='TEXT-ALIGN:center;' title='' id='BL_ERROR<%=i%>'> <%=disp_str%>
												</td>
<%
												if (((error_code.equals("10") && (!error_text.equals(""))) ||!sys_message_id.equals(""))&&(!sys_message_id.equals("BL9743"))){
													out.println("<script>dispTitle('"+error_code+"','"+error_text+"','"+sys_message_id+"','"+i+"');</script>");
												}
											}
										}
									}
									else{
%>
										<td id="drug_name<%=i%>" class="<%=classvalue%>" onclick="disableClick(event);" title="<%=store_desc%>"><input type="hidden" name="drug_code" id="drug_code" id="drug_code<%=i%>" value="<%=strArray[0]%>"><input type="hidden" name="line_no<%=i%>" id="line_no<%=i%>" id="line_no<%=i%>" value="<%=i%>"><input type="hidden" name="trade_code<%=i%>" id="trade_code<%=i%>" id="trade_name<%=i%>" value="<%=trade_code%>"><input type="hidden" name="trade_name<%=i%>" id="trade_name<%=i%>" id="trade_name<%=i%>" value="<%=trade_name%>">
										<label class="label" style="font-size:xx-small;font-weight:normal" onclick="disableClick(event);"><%= description %>
										</label>
<%
										if(!strArray[11].equals("")){
%>
											<label class="label" style="font-size:xx-small;font-weight:normal" onclick="disableClick(event);">(<%=strArray[11]%>)</label>
<%
										}
%>
										</td>
										<!--  <td  class="<%=classvalue%>" width ="5%">&nbsp;&nbsp;</td>  -->


<%   
										if(identity.equals("MedicationOrder")){
%>
											<td class="<%=classvalue%>" style='TEXT-ALIGN:center;'>
												<input type='hidden' name='diagnosis_found_yn<%=i%>' id='diagnosis_found_yn<%=i%>' value='<%=strArray[20]%>'>
												<input type='hidden' name='appl_for_age_grp_yn<%=i%>' id='appl_for_age_grp_yn<%=i%>' value='<%=strArray[22]%>'>
<%
											  if(drug_db_interface_yn.equals("Y")){
												if(bean.getExternalProductId(strArray[0])!=null ){
%>
													<img src="../../ePH/images/info.gif"  height='15' width='15' style="cursor:pointer" onClick="showDrugInfo('<%=bean.getExternalProductId(strArray[0])%>','<%= strArray[1] %>')">	
<%
												}
										    }
%>
											&nbsp;</td>
<%
											if(bl_install_yn.equals("Y") && disp_charge_dtl_in_drug_lkp_yn.equals("Y") && in_formulary_yn.equals("Y")){
												if(strArray[16]!=null && !strArray[16].equals("")&& !strArray[16].equals("0")){
													disp_str = "<img src=\"../../eCommon/images/enabled.gif\"></img>";
												}
												else{
													disp_str = "&nbsp";
												}
%>
												<td class="<%=classvalue%>" style='TEXT-ALIGN:center;'><%=disp_str%>												
												</td>
<%
												if(strArray[14]!=null && !strArray[14].equals("")&& strArray[14].equals("Y")){
													disp_str = "<img src=\"../../eCommon/images/enabled.gif\"></img>";
												}
												else{
													disp_str = "&nbsp";
												}
%>
												<td class="<%=classvalue%>" style='TEXT-ALIGN:center;'> <%=disp_str%>
												</td>
<%
												if(strArray[15]!=null && !strArray[15].equals("") && strArray[15].equals("Y")){
													disp_str = "<img src=\"../../eCommon/images/enabled.gif\"></img>";
												}
												else{
													disp_str = "&nbsp";
												}
%>
												<td class="<%=classvalue%>" style='TEXT-ALIGN:center;'><%=disp_str%>
												</td>
<%
												if(strArray[16]!=null && !strArray[16].equals("")&& !strArray[16].equals("0")){
													disp_str =strArray[16] ;
												}
												else{
													disp_str = "&nbsp";

													if (((error_code.equals("10") && (!error_text.equals(""))) ||!sys_message_id.equals(""))&&(!sys_message_id.equals("BL9743"))){
														disp_str = "<font style=color:red>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")+"</font>";
													}
												}
%>
												<td class="<%=classvalue%>" style='TEXT-ALIGN:center;' title='' id='BL_ERROR<%=i%>'> <%=disp_str%>
												</td>
<%
												if (((error_code.equals("10") && (!error_text.equals(""))) ||!sys_message_id.equals(""))&&(!sys_message_id.equals("BL9743"))){
													out.println("<script>dispTitle('"+error_code+"','"+error_text+"','"+sys_message_id+"','"+i+"');</script>");
												}
											}
										}										
									}
								}

								if (strArray[2] != null){
									if (!strArray[2].equals("0")){
										if(!strEnableDisable.equals("disabled")){
										//str_click	=	"preferredDrugSearchModify(eval(document.getElementById("drug_name"+i+"')),'"+strArray[8]+"','"+strArray[9]+"','"+strArray[2]+"','"+strArray[3]+"','"+strArray[4]+"','"+strArray[6]+"','"+strArray[12]+"','"+strArray[0]+"','"+strArray[10]+"','"+java.net.URLEncoder.encode(strArray[11],"UTF-8")+"','"+i+"');";
										str_click = "preferredDrugSearchModify(eval(document.getElementById('drug_name' + i)), '" + 
												    strArray[8] + "', '" + 
												    strArray[9] + "', '" + 
												    strArray[2] + "', '" + 
												    strArray[3] + "', '" + 
												    strArray[4] + "', '" + 
												    strArray[6] + "', '" + 
												    strArray[12] + "', '" + 
												    strArray[0] + "', '" + 
												    strArray[10] + "', '" + 
												    java.net.URLEncoder.encode(strArray[11], "UTF-8") + "', '" + 
												    i + "');";
													
										font_class	=	"class='HYPERLINK' onMouseOver='changeCursor(this);'";
										} else {
											str_click	=	"";
											font_class	=	"style='font-size:11'";
										}					
%>
										<td  onClick="<%=str_click%>" class="<%=classvalue%>" title="<%=store_desc%>"><font <%=font_class%>><%= strArray[2] %>&nbsp;</font></td>
<%
									}
									else{
%>
										<td class="<%=classvalue%>">&nbsp;</td>
<%
									}
								}
%>
							
							<td onclick="disableClick(event);" class="<%=classvalue%>" title="<%=store_desc%>"><%= strArray[7] %></td>
<%
							if (identity.equals("MedicationOrder") ){
								if (ht.containsKey( strArray[0]+i)){
									if((strArray[23].equals("Y") || strArray[24].equals("Y")) && strArray[26].equals("N")){ //strArray[26] - NPB_DRUG_YN 
%>
										<td class="<%=classvalue%>" ><img src="../../ePH/images/altenate.jpg" style="cursor:pointer"  onClick="displayAlternateDrugs('<%=drug_code%>','<%=java.net.URLEncoder.encode(store_desc,"UTF-8")%>','<%=strArray[1]%>','<%=strArray[9]%>','<%=strArray[6]%>','<%=identity%>','<%=drug_class%>','<%=order_type_code%>','<%=store_code%>', '<%= patient_id%>', '<%=encounter_id%>')" style="cursor:pointer;color:blue" height='15' width='15' > </td>
<% 
									}
									else{
%>
										<td class="<%=classvalue%>" >&nbsp;</td>
<%									
									}
									if(consider_stock.equals("Y")) { 
%>
										<td class="<%=classvalue%>" align="right" title="<%=store_desc%>"><font class='HYPERLINK' onmouseover="changeCursor(this);" ><label onclick="displayStock('<%=drug_code%>','<%=strArray[1]%>','<%=trade_code%>','<%=java.net.URLEncoder.encode(store_desc)%>','<%=store_code%>');"><%=avl_qty%></label></font></td>
										<td class="<%=classvalue%>"><%=qty_uom%></td>
<%
									}

									//if(!drugorfluid.equals("F") && !drugorfluid.equals("IVF")) {	
%>
										
<%	
									//}
								}
								else{
									if((strArray[23].equals("Y") || strArray[24].equals("Y"))&& strArray[26].equals("N")){ //strArray[26] - NPB_DRUG_YN 
%>
										<td class="<%=classvalue%>" ><img src="../../ePH/images/altenate.jpg"  height='15' width='15' style="cursor:pointer"  onClick="displayAlternateDrugs('<%=drug_code%>','<%=java.net.URLEncoder.encode(store_desc,"UTF-8")%>','<%= strArray[1] %>','<%=strArray[9]%>','<%=strArray[6]%>','<%=identity%>','<%=drug_class%>','<%=order_type_code%>','<%=store_code%>', '<%= patient_id%>', '<%=encounter_id%>')" style="cursor:pointer;color:blue" > </td>
<% 
									}
									else{
%>
										<td class="<%=classvalue%>" >&nbsp;</td>
<%
									}
									if(consider_stock.equals("Y")) { 
										if( ( (bean_2.getExternalpatient_id()==null)||  (bean_2.getExternalpatient_id()).equals("") || (bean_2.getExternalpatient_id()=="") ) ){ /*Modified For SKR-SCF-1642 */
%>
											<td class="<%=classvalue%>" align="right" title="<%=store_desc%>"><font class='HYPERLINK' onmouseover="changeCursor(this);" ><label  onclick="displayStock('<%=drug_code%>','<%=strArray[1]%>','<%=trade_code%>','<%=java.net.URLEncoder.encode(store_desc, "UTF-8")%>','<%=store_code%>');"><%=avl_qty%></label></font></td>
											<td class="<%=classvalue%>"><%=qty_uom%></td>
<%	
										}
									}	
									if(strChecked.equals("checked")) { 
										strEnableDisable  = "disabled";
									}
									//if(!drugorfluid.equals("F") && !drugorfluid.equals("IVF")) {	
%>
										
<%
									//}
								}
							 }
%>
							</tr>
								<input type="hidden" name="pres_base_uom<%=i%>" id="pres_base_uom<%=i%>" value="<%=strArray[12]%>">				
<%				
						}
					}
					else if(arrList==null || arrList.size()<1 || !arrList.get(0).equals("cancel")){
				
%>
					 <script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
					 window.close();
					</script> 
<%
					} 
%>
				</table>
				<input type="hidden" name="from" id="from" value="">
				<input type="hidden" name="to" id="to" value="">
				<input type="hidden" name="identity" id="identity" value="<%=identity%>">
				<input type="hidden" name="drugorfluid" id="drugorfluid" value="<%=drugorfluid%>">
				<input type="hidden" name="order_type_code" id="order_type_code" value="<%=order_type_code%>">
				<input type="hidden" name="res_by_service" id="res_by_service" value="<%=res_by_service%>">
				<input type="hidden" name="service_code" id="service_code" value="<%=service_code%>">
				<input type="hidden" name="Classification" id="Classification" value="<%=Classification%>">
				<input type="hidden" name="searchBasedOn" id="searchBasedOn" value="">
				<input type="hidden" name="bean_id" id="bean_id" value="<%= bean_id %>">
				<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<%
				if (identity.equals("MedicationOrder") && arrList.size()>=1){
	%>			<br>
						<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1">
							<tr >
								<td class="white" width="1%">
									<label style="visibility:hidden">+</label>
								</td>
<%
								if(consider_stock.equals("Y")) { 
									if( ( (bean_2.getExternalpatient_id()==null)||  (bean_2.getExternalpatient_id()).equals("") || 	(bean_2.getExternalpatient_id()=="") ) ){ /*Modified For SKR-SCF-1642 */
%>
										<td class='INSUFFICIENTSTOCK' width='1%'>&nbsp;</td>
<%
									}
									else{
%>
										<td class='white' width='1%'>&nbsp;</td>
<%
									}
%>
									<td class='white'>&nbsp;&nbsp;
<%
									if( ( (bean_2.getExternalpatient_id()==null)|| (bean_2.getExternalpatient_id()).equals("") || 	(bean_2.getExternalpatient_id()==""))){   /*Modified For SKR-SCF-1642 */
%>
										<label style="font-size:10;color:red;font-weight:bold"><fmt:message key="ePH.NoStockinDispenseLocation.label" bundle="${ph_labels}"/></label>
<%
									}
									else{
%>
										<label style="font-size:10;color:red;font-weight:bold">&nbsp;</label>
<%
									}
%>
								</td>
<%
							}
%>
							<td class="white" align="right">
								<img src="../../ePH/images/altenate.jpg"  height='15' width='15' >
							</td>
							<td class="white" align="left">&nbsp;&nbsp;<fmt:message key="ePH.AlternateDrugs.label" bundle="${ph_labels}"/></td>	
							
							
						</tr>
					</table>
					<br><br>
					<table  cellpadding="0" cellspacing="0" width="100%" align="center" border="1">
					<TR>
						<TD COLSPAN="2"  class="white" align="right" ><input type="button" value="Close"  class="button"	onClick="parent.window.close()"></TD>
					</TR>
	<%
				}		
	%>
	       
			</form>
			
			
		</body>
	</html>
	
<%

	putObjectInBean(bean_id,bean,request);
	putObjectInBean(bean_id_2,bean_2,request);
}
catch(Exception e){
	e.printStackTrace();
}
%>

