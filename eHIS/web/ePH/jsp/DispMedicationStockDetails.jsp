<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*,eST.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>

<HTML>
	<HEAD>
<%
request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//ends
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../ePH/js/DispMedicationAllStages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</HEAD>
<%
	String bean_id		= "DispMedicationAllStages" ;
	String bean_name	= "ePH.DispMedicationAllStages";
	DispMedicationAllStages bean = (DispMedicationAllStages)getBeanObject( bean_id, bean_name,request) ;
	
	String	bean_id_1		=	"DispMedicationBean" ;
	String	bean_name_1		=	"ePH.DispMedicationBean";
	
	DispMedicationBean bean_1	= (DispMedicationBean)getBeanObject( bean_id_1, bean_name_1, request);
	try{
		//bean_1.setLanguageId(locale);
		 //this parameter is used to check trade change is allowed for user or not based on dispensing rights
		String allowchangetradenameyn	=	bean_1.getDispChangeTradeNameYN();
		String allowmultitradeyn	    =	bean_1.getDispAllowMultiTradesYN();
		String allow_short_expiry_drugs_yn =bean_1.getAllow_short_expiry_drugs_yn();
		HashMap stockdtl= new HashMap();
		
		String facility_id								=  	request.getParameter("facility_id");
		stockdtl.put("facility_id", facility_id);
		String disp_locn_code							=  	request.getParameter("disp_locn_code");
		stockdtl.put("disp_locn_code", disp_locn_code);
		String drug_code								=	request.getParameter("drug_code")==null?"":request.getParameter("drug_code");
		String patient_id								=	request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String order_id									=	request.getParameter("order_id")==null?"":request.getParameter("order_id");
		String order_line_no							=	request.getParameter("order_line_no")==null?"":request.getParameter("order_line_no");
		String qty										=	request.getParameter("qty");
		String uom										=	request.getParameter("qty_uom")==null?"":request.getParameter("qty_uom");
		String uom_code									=	request.getParameter("uom_code")==null?"":request.getParameter("uom_code");
		String source									=	request.getParameter("source")==null?"":request.getParameter("source");
		String recno									=	request.getParameter("no")==null?"":request.getParameter("no");
		String end_date									=	request.getParameter("end_date")==null?"":request.getParameter("end_date");
		String drug_strength							=	request.getParameter("drug_strength")==null?"":request.getParameter("drug_strength");
		String alt_drug_strength						=	request.getParameter("alt_drug_strength")==null?"":request.getParameter("alt_drug_strength");
		String drug_class								=	request.getParameter("drug_class")==null?"":request.getParameter("drug_class");
		String stk_qty									=	request.getParameter("stk_qty")==null?"":request.getParameter("stk_qty");
		String min_end_date								=	request.getParameter("min_end_date")==null?"":request.getParameter("min_end_date");
		String main_strength_per_value_pres_uom			=	request.getParameter("main_strength_per_value_pres_uom")==null?"":request.getParameter("main_strength_per_value_pres_uom");
		String sPRNOrAbsOrder							=  	request.getParameter("PrnAbs")==null?"":request.getParameter("PrnAbs");
		String alt_drg_no								=  	request.getParameter("alt_drg_no")==null?"":request.getParameter("alt_drg_no");
		String alt_strength_uom							=  	request.getParameter("alt_strength_uom")==null?"":request.getParameter("alt_strength_uom");
		String drug_color								=	request.getParameter("drug_color")==null?"":request.getParameter("drug_color");
		String alt_drug_code							=	request.getParameter("alt_drug_code")==null?"":request.getParameter("alt_drug_code");
		String called_from								=	request.getParameter("called_from")==null?"":request.getParameter("called_from");
		String bms_strength								=	request.getParameter("bms_strength")==null?"":request.getParameter("bms_strength");
		String oper_mode								=	request.getParameter("oper_mode")==null?"":request.getParameter("oper_mode");
		String drug_desc								=	request.getParameter("drug_desc")==null?"":request.getParameter("drug_desc");
		String prescribed_strength						=  	request.getParameter("prescribed_strength")==null?"":request.getParameter("prescribed_strength");
		String barcode_id								=  	request.getParameter("barcode_id")==null?"":request.getParameter("barcode_id");
		String drg_code = request.getParameter("drg_code")==null?"":request.getParameter("drg_code"); //ML-MMOH-SCF-1829
		if(!alt_drug_code.equals("")) //ML-MMOH-SCF-1829
			drug_code = drg_code ;
		String currentdateplusFillPeriod				=  	"";		//added by Ganga for ML-BRU-SCF-0905 [IN:041285]
		boolean	endDateIsbeforeFilldate					= 	false;//added by Ganga for ML-BRU-SCF-0905 [IN:041285]

		bean_1.setBarcode_id(barcode_id);
		if(bean_1.getStockDtl()!=null && !bean_1.getStockDtl().isEmpty() ){
			stockdtl=bean_1.getStockDtl();
		}
		 
		bean_1.getBarCodeflg(facility_id,disp_locn_code);
		stockdtl.put("barcode_yn", bean_1.getBarcode_Scan_YN());
		String barCodeScanYN = bean_1.getBarcode_Scan_YN();
		if(!barcode_id.equals("")){
			bean_1.setBarcode_Scan_YN("N"); 
			//bean_1.getBatch_val().clear();//Added for KDAH-CRF-0231 [IN-034551].
		}
		if(barCodeScanYN.equals("Y") &&  !barcode_id.equals("") || !barcode_id.equals("")){
			stockdtl.put("barcode_id", barcode_id);
			if(drug_code.equals(""))
				drug_code =	stockdtl.get("drug_code").toString();
			
			if(patient_id.equals(""))
				patient_id =	stockdtl.get("patient_id").toString();
			
			if(order_id.equals(""))
				order_id =	stockdtl.get("order_id").toString();

			if(order_line_no.equals(""))
				order_line_no =	stockdtl.get("order_line_no").toString();
			
			if(qty==null || qty.equals(""))
				qty  =	stockdtl.get("bms_qty").toString();

			if(uom.equals(""))
				uom  =	stockdtl.get("strength_uom").toString();

			if(uom_code.equals(""))
				uom_code =	stockdtl.get("uom_code").toString();

			if(source.equals(""))
				source 	=	stockdtl.get("source").toString();

			if(recno.equals(""))
				recno 	=	stockdtl.get("recCount").toString();

			if(end_date.equals(""))
				end_date =	stockdtl.get("end_date").toString();

			if(drug_strength.equals(""))
				drug_strength	 =	stockdtl.get("strength_value").toString();

			if(alt_drug_strength.equals(""))
				alt_drug_strength 	=	stockdtl.get("alt_strength_value").toString();

			if(drug_class.equals(""))
				drug_class =	stockdtl.get("drug_class").toString();

			if(stk_qty.equals(""))
				stk_qty 	=	stockdtl.get("stk_qty").toString();

			if(min_end_date.equals(""))
				min_end_date =	stockdtl.get("min_end_date").toString();

			if(main_strength_per_value_pres_uom.equals(""))
				main_strength_per_value_pres_uom	=	stockdtl.get("main_strength_per_value_pres_uom").toString();

			if(sPRNOrAbsOrder.equals(""))
				sPRNOrAbsOrder	=	stockdtl.get("sPRNOrAbsOrder").toString();

			if(alt_drg_no.equals(""))
				alt_drg_no =	stockdtl.get("alt_drg_no").toString();

			if(alt_strength_uom.equals(""))
				alt_strength_uom	=	stockdtl.get("alt_strength_uom").toString();
		}
		
		stockdtl.put("drug_code", drug_code);
		stockdtl.put("patient_id", patient_id);
		stockdtl.put("order_id", order_id);     
		stockdtl.put("order_line_no", order_line_no);
		stockdtl.put("bms_qty", qty);
		stockdtl.put("strength_uom", uom);
		stockdtl.put("uom_code", uom_code);
		stockdtl.put("source", source);
		stockdtl.put("recCount", recno);
		stockdtl.put("end_date", end_date);
		stockdtl.put("strength_value", drug_strength);
		stockdtl.put("alt_strength_value", alt_drug_strength);
		stockdtl.put("drug_class", drug_class);
		stockdtl.put("stk_qty", stk_qty);
		stockdtl.put("min_end_date", min_end_date);
		stockdtl.put("main_strength_per_value_pres_uom", main_strength_per_value_pres_uom);
		stockdtl.put("sPRNOrAbsOrder", sPRNOrAbsOrder);
		stockdtl.put("alt_drg_no", alt_drg_no);
		stockdtl.put("alt_strength_uom", alt_strength_uom);
		currentdateplusFillPeriod		=  	com.ehis.util.DateUtils.plusDate(bean_1.getTodaysDate(),"DMY",locale,Integer.parseInt(bean_1.getFillPeriod()),"d").toString();  // added for ML-BRU-SCF-0905 [IN:041285] -start
		endDateIsbeforeFilldate			=  	com.ehis.util.DateUtils.isBefore(end_date,currentdateplusFillPeriod,"DMY",locale);
		if(!endDateIsbeforeFilldate){
			end_date = currentdateplusFillPeriod;
			min_end_date = currentdateplusFillPeriod;
		}//ML-BRU-SCF-0905 [IN:041285] added ends

		boolean bPRNOrAbsOrder		=  false;
		String disable				=  "enabled";
		bean_1.setStockDtl(stockdtl);

		//Added for  KDAH-CRF-0231 [IN-034551] - end

		if(sPRNOrAbsOrder != null && sPRNOrAbsOrder.equals("T"))
			bPRNOrAbsOrder			= true;

		bean.setBPRNOrAbsOrder(bPRNOrAbsOrder);

		// To reset the Quantity value in the DispMedicationAllocateDrugsWithStk.jsp page
		String strResetQty = request.getParameter("resetQty");
		bean_1.setStrResetQty(strResetQty);

		//code added for handling special char 
		String drug_name			=	"";
		String trade_code   =  (String)bean_1.gettrade_codes(order_id,order_line_no,drug_code);	

		if(drug_desc!=null){
			 drug_name		=  drug_desc; 
		}
		
		if(drug_name!=null && !drug_name.equals("")){
			drug_name	=drug_name.replaceAll(" ","%20");
			drug_name	=java.net.URLEncoder.encode(drug_name,"UTF-8");
			drug_name	=drug_name.replaceAll("%2520","%20");
		}

		String alt_drug_desc		=	request.getParameter("alt_drug_desc")==null?"":request.getParameter("alt_drug_desc");
		String altdrug_name		=  "";
		if((!alt_drug_desc.equals(""))&& (alt_drug_desc!=null))
			 altdrug_name			=  alt_drug_desc; 			
		if((!altdrug_name.equals(""))&&(altdrug_name!=null)){
			/*altdrug_name=altdrug_name.replaceAll(" ","%20");
			altdrug_name=java.net.URLEncoder.encode(altdrug_name,"UTF-8");  
			altdrug_name=altdrug_name.replaceAll("%2520","%20"); Commented By sandhya for 25007 incident*/
		}

		//	code added for sriraj demo for showing billing details 4/22/2006
		String encounter_id		=	bean_1.getEncounterID();
		String patient_class	=	bean.getEncounterPatientClass(encounter_id, patient_id);  // patient_id  added for [IN:035667] 
		String showcharge_yn	=	bean.getBLInterfaceYN();//checkforbillinginterface();

		String dis="";
		if(showcharge_yn.trim().equals("Y")){
			 dis="Style=Display:inline";
		}
		else{
			 dis="Style=Display:none";
		}
		boolean entered			=	false;
		if(drug_code==null)			
			drug_code	=	"";
		if(alt_drug_code==null)		
			alt_drug_code	=	"";

		String params			= "";

		if(!alt_drug_code.equals("")){
//			params				=	request.getQueryString().replace(drug_code,alt_drug_code);
			params				=	request.getQueryString(); //removed replace for ML-MMOH-SCF-1829

			drug_code			=	alt_drug_code;
		}
		else{ 
			 if(!(barcode_id==null || barcode_id.equals(""))){//if block to send stockdtl values on request string added for KDAH-CRF-0231 [IN-034551]
				params= "&order_id="+bean_1.getStockDtl().get("order_id").toString()+"&order_line_no="+bean_1.getStockDtl().get("order_line_no").toString()+"&drug_code="+stockdtl.get("drug_code").toString()+"&qty="+bean_1.getStockDtl().get("bms_qty").toString()+"&stk_qty="+bean_1.getStockDtl().get("stk_qty").toString()+"&end_date="+bean_1.getStockDtl().get("end_date").toString()+"&source="+bean_1.getStockDtl().get("source").toString()+"&no="+bean_1.getStockDtl().get("recCount").toString()+"&uom_code="+bean_1.getStockDtl().get("uom_code").toString();//source,no is added for incident Alpha-PH- Barcode getting script error [IN040736]
			 }
			 else{ 
				params				=	request.getQueryString();
			}
		}

		String item_code		=	"";
		String item_desc		=	"";
		String store_code		=	"";
		String store_desc		=	"";
		String stk_unit_code	=	"";
		String stk_unit_desc	=	"";
		String stk_equval_value	=	"";
		String dflt_issue_uom   =   "";
		String orig_dflt_issue_uom   =   "";
		String act_stk_equval_value  =   "";

		String base_uom			=	"";
		String display_list		=	"";
		HashMap IssueUOMAndBaseUOM =new HashMap();
		String base_to_disp_uom_equl_val ="1";
		String base_to_def_uom_equl_val  ="1";
		boolean flag            =   false;
		//boolean flag_1          =   false;
		ArrayList	stk_units	=	new ArrayList();
		String uom_desc	= "";//Added for AAKH-SCF-0338

		if(drug_code==null)
			drug_code	=	""; 
		ArrayList items		=	bean.loadItems(drug_code);
		store_code			=	bean_1.getStoreCode();
		params				+=	"&store_code="+store_code;
		store_desc			=	bean.getStoreDesc(store_code);
		ArrayList	st_items	=	new ArrayList();
		if(alt_drug_code.equals(""))
			st_items			= bean.getStockItems(drug_code);
		stk_units				= bean.loadStockUnit(drug_code);	
		HashMap issue_uom_qty_hm =  bean.getIssueUomQty();
		if(issue_uom_qty_hm.size()>0){
			if(issue_uom_qty_hm.containsKey(order_id+order_line_no+drug_code+"_uom")){
				dflt_issue_uom = (String)issue_uom_qty_hm.get(order_id+order_line_no+drug_code+"_uom");
			}
		}
		IssueUOMAndBaseUOM		=(HashMap)bean.getStoreDfltIssueUOMAndBaseUOM(store_code,drug_code);

		orig_dflt_issue_uom =	(String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM")==null?"":(String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM");
		if(dflt_issue_uom.equals("")){
			dflt_issue_uom =	(String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM")==null?"":(String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM"); //orig_dflt_issue_uom changed to dflt_issue_uom for  [IN:046372]
		}
		//added for AAKH-SCF-0338 - start
		if(stk_units!=null && stk_units.size()>0){
			if(!stk_units.contains(orig_dflt_issue_uom)){
				uom_desc = bean.getUOMDesc(orig_dflt_issue_uom);
				stk_units.add(orig_dflt_issue_uom);
				stk_units.add(uom_desc);
				stk_units.add("1");
				stk_units.add("1");
			}
		}
		//added for AAKH-SCF-0338 - end

		
		base_uom            =	(String)IssueUOMAndBaseUOM.get("BASE_UOM")==null?"":(String)IssueUOMAndBaseUOM.get("BASE_UOM");
		double base_to_disp_uom_equl    =  bean.getEqulValue ( drug_code, base_uom, uom_code);
		double base_to_def_uom_equl	    =  bean.getEqulValue ( drug_code, base_uom, orig_dflt_issue_uom);

		if(base_to_disp_uom_equl!=0 && base_to_def_uom_equl!=0){
			flag =true;
		}
		if(orig_dflt_issue_uom.equals(base_uom))
			bean.setIssueUomQty(order_id+order_line_no+drug_code+"_base_to_def_uom_equl","1");
%>
		<body onMouseDown="" onKeyDown="lockKey()">
			<form name="DispMedicationStockDetails" id="DispMedicationStockDetails">
				<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1">
					<td  class="COLUMNHEADER" colspan="2" class="label"><fmt:message key="ePH.Store/ItemDetails.label" bundle="${ph_labels}"/></td>
					<tr>
						<td  class="QRYEVENSMALL" width="30%"><fmt:message key="Common.Store.label" bundle="${common_labels}"/>&nbsp;</td>
						<td  class="QRYEVENSMALL" width="70%">&nbsp;&nbsp;<b><%=store_desc%></b></td>
					</tr>
					<tr>
						<td colspan="2" class="QRYODDSMALL" wrap>&nbsp;</td></tr>
					<tr>
						<td  class="QRYEVENSMALL" width="30%"><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/>&nbsp;</td>
						<td  width="70%" CLASS="QRYEVENSMALL">&nbsp;&nbsp;
							<select onChange="displayDescription(this,document.DispMedicationStockDetails,'<%=params%>')" name="item_select">
								<option value="">&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;</option>
<% 
								for(int i=0; i<items.size(); i+=2) { 
									item_code	=	(String)items.get(i);
									item_desc	=	(String)items.get(i+1);

									int stock_qty	=	bean.getTotalStockQty(patient_id,order_id,order_line_no);
									if(st_items.size()!=0 && st_items.contains(item_code)) {
										if(	stock_qty != 0 ) {
											entered	=	true;
%>
											<option value="<%=item_desc%>" selected><%=item_code%></option>
<%		
										}
										else{	
%>
											<option value="<%=item_desc%>"><%=item_code%></option>
<%	
										}
									}
									else if(!alt_drug_code.equals("")) {
										if(	stock_qty != 0 ) {
										entered	=	true;
%>
										<option value="<%=item_desc%>" selected><%=item_code%></option>
<%
									}
									else{	
%>
										<option value="<%=item_desc%>"><%=item_code%></option>
<%	
									}
								}
								else{
%>
									<option value="<%=item_desc%>"><%=item_code%></option>
<%
								}
							}	
%>
							</select><img src="../../eCommon/images/mandatory.gif">
							</td> 
						</tr>
						<tr>
							<td colspan="2" class="QRYODDSMALL">&nbsp;</td></tr>
						<tr>
							<td  class="QRYEVENSMALL" width="30%" ><fmt:message key="ePH.ItemDesc.label" bundle="${ph_labels}"/>&nbsp;</td>
							<td  class="QRYEVENSMALL" width="70%">&nbsp;&nbsp;<label id="item_desc_1" style="font-weight:bold"></label></td>
						</tr>
						<tr>
							<td  class="QRYEVENSMALL" width="30%" >&nbsp;</td>
							<td  CLASS="QRYEVENSMALL" width="70%">&nbsp;&nbsp;<label id="item_desc_2" style="font-weight:bold"></label></td>
						</tr>
						<tr>
							<td align="right" class="QRYEVENSMALL" width="30%" >&nbsp;</td>
							<td align="left" CLASS="QRYEVENSMALL" width="70%">&nbsp;&nbsp;<label id="item_desc_3" style="font-weight:bold"></label></td>
						</tr>
						<tr>
							<td colspan="2" class="QRYODDSMALL">&nbsp;</td></tr>
<%
						if(bean_1.getIssueByUOM().equals("D")){
							 display_list ="display:none" ;
						}
%>
						<tr style='<%=display_list%>'>
							<td align="right" class="QRYEVENSMALL" width="30%" style='<%=display_list%>'><fmt:message key="ePH.ISSUEUOM.label" bundle="${ph_labels}"/>&nbsp;</td>
							<td align="left" CLASS="QRYEVENSMALL" width="70%" style='<%=display_list%>'>&nbsp;
								<select onChange="issueUOM(this,'<%=qty%>');setIssueUom(this,'<%=order_id+order_line_no+drug_code+"_uom"%>');" name="issue_uom_select"><!--setIssueUom added for AAKH-SCF-0338 -->
<% 
								boolean bSelected = false;
								if(stk_units.size()<1){
									flag = false;
								}
								else{
									for(int i=0; i<stk_units.size(); i+=4) { 
										stk_unit_code			=	(String)stk_units.get(i);
										stk_unit_desc			=	(String)stk_units.get(i+1);
										stk_equval_value		=	(String)stk_units.get(i+2);
										act_stk_equval_value	=	(String)stk_units.get(i+3);
										if(uom_code.equals(stk_unit_code)){
											base_to_disp_uom_equl_val = stk_equval_value; 
											bean.setIssueUomQty(order_id+order_line_no+drug_code+"_base_to_disp_uom_equl",stk_equval_value);
											/*bean.setIssueUomQty(order_id+order_line_no+drug_code+"_base_to_def_uom_equl",act_stk_equval_value);
											base_to_def_uom_equl_val =  act_stk_equval_value;*/
											if(!orig_dflt_issue_uom.equals(stk_unit_code)){
												bean.setIssueUomQty(order_id+order_line_no+drug_code+"_base_to_def_uom_equl",stk_equval_value);
												base_to_def_uom_equl_val =  stk_equval_value;
											}
										}
										else{
											//base_to_def_uom_equl_val = act_stk_equval_value;//added for MMS-MD-SCF-0204  
											bean.setIssueUomQty(order_id+order_line_no+drug_code+"_base_to_disp_uom_equl",base_to_disp_uom_equl+""); //Added for  MMS-SCF-0040 [IN:041888]
											bean.setIssueUomQty(order_id+order_line_no+drug_code+"_base_to_disp_uom_equl",base_to_disp_uom_equl+""); //Added for  MMS-SCF-0040 [IN:041888]
										}

										/*if(!orig_dflt_issue_uom.equals(stk_unit_code)){
											bean.setIssueUomQty(order_id+order_line_no+drug_code+"_base_to_def_uom_equl",stk_equval_value);
											base_to_def_uom_equl_val =  stk_equval_value;
										}*/
									if(issue_uom_qty_hm.containsKey(order_id+order_line_no+drug_code+"_equl")){
										if(dflt_issue_uom.equals(stk_unit_code))
										stk_equval_value	= (String)issue_uom_qty_hm.get(order_id+order_line_no+drug_code+"_equl");
									}

										if(dflt_issue_uom.equals(stk_unit_code)){
											bSelected = true;
										
%>
											<option value="<%=stk_unit_code%>_<%=stk_equval_value%>_<%=stk_unit_desc%>_<%=act_stk_equval_value%>" selected><%=stk_unit_desc%></option>
<%
										}
										else{
%>
											<option value="<%=stk_unit_code%>_<%=stk_equval_value%>_<%=stk_unit_desc%>_<%=act_stk_equval_value%>"><%=stk_unit_desc%></option>
<%
										}
									}
								}
 %>
							</select>&nbsp;
							<label id="item_desc_3" style="font-weight:bold"></label>
							</td>
						</tr>
						<input type="hidden" name="base_to_disp_uom_equl_val" id="base_to_disp_uom_equl_val" value="<%=base_to_disp_uom_equl_val%>">
						<input type="hidden" name="base_to_def_uom_equl_val" id="base_to_def_uom_equl_val" value="<%=base_to_def_uom_equl_val%>">
						<input type="hidden" name="base_to_disp_uom_equl" id="base_to_disp_uom_equl" value="<%=base_to_disp_uom_equl%>"> <!--  Added for AAKH-SCF-0113 [IN:048937] -->
						<input type="hidden" name="base_to_def_uom_equl" id="base_to_def_uom_equl" value="<%=base_to_def_uom_equl%>">	 <!--  Added for AAKH-SCF-0113 [IN:048937] -->
						<tr>
							<td colspan="2" class="QRYODDSMALL">&nbsp;</td>
						</tr>
						<tr><td colspan="2" class="white"></td>&nbsp;</tr>
					</table>
				<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1">
					<tr>
						<td colspan="2" CLASS="white" ><input type="button" class="button" style='visibility:hidden'value="Charges"<%=dis%> onClick="viewCharges('<%=patient_id%>','<%=encounter_id%>','<%=patient_class%>','<%=qty%>')">

						<input type="button" class="button" name="stockavail" id="stockavail" value='<fmt:message key="eST.StockAvailability.label" bundle="${st_labels}"/>' onClick="callBatchSearch('<%=params%>','<%=store_code%>','<%=end_date%>','<%=trade_code%>','<%=allowchangetradenameyn%>','<%=allowmultitradeyn%>','<%=allow_short_expiry_drugs_yn%>')"></td>
					</tr>
				</table>
				<input type="hidden" name ="stk_qty" value="<%=stk_qty%>">
			</form>
		</body>
<%
		if (!bSelected){
%>
			<script>
				for(var i=0;i<document.DispMedicationStockDetails.issue_uom_select.length;i++){
					try{
						if(document.DispMedicationStockDetails.issue_uom_select.options[i].value.indexOf('<%=uom_code%>') != -1)
							document.DispMedicationStockDetails.issue_uom_select.selectedIndex = i;
					}
					catch(e){}
				}
			</script>
<%
		}
%>
		<script>
			if(document.DispMedicationStockDetails.item_select.length==2) {
<%
				if(flag){
%>			
					document.DispMedicationStockDetails.item_select.selectedIndex = 1;
					displayDescription(document.DispMedicationStockDetails.item_select,document.DispMedicationStockDetails,'<%=drug_code%>','<%=patient_id%>','<%=order_id%>','<%=order_line_no%>','<%=drug_color%>','<%=alt_drug_code%>','<%=qty%>','<%=uom%>','<%=uom_code%>','<%=source%>','<%=recno%>','<%=store_code%>','<%=end_date%>','<%=drug_strength%>','<%=alt_drug_strength%>','<%=called_from%>','<%=bms_strength%>','<%=oper_mode%>','<%=drug_class%>','<%=stk_qty%>','<%=min_end_date%>','<%=drug_name%>','<%=altdrug_name%>','<%=main_strength_per_value_pres_uom%>','<%=alt_drg_no%>','<%=alt_strength_uom%>','<%=prescribed_strength%>','<%=bean_1.getBarcode_Scan_YN()%>');//bean_1.getBarcode_Scan_YN() parameter added for KDAH-CRF-0231 [IN-034551] 
					document.DispMedicationStockDetails.item_select.disabled	=	true;
<%
				}
				else{
					if(orig_dflt_issue_uom.equals("")){
%>
						alert(getMessage("ITEM_IS_NOT_ASSIGNED","PH"));
<%  
					}
					else{
%>
						alert(getMessage("PH_ITEM_UOM_DEF_NOT_FOUND","PH"));
<%
					}
%>
					document.DispMedicationStockDetails.item_select.disabled	    =	true;
					document.DispMedicationStockDetails.issue_uom_select.disabled	=	true;
					clearItemDetail();
<%
				}
%>
			} 
			else {
<%
				if(entered)	{
					if(flag){				
%>
						displayDescription(document.DispMedicationStockDetails.item_select,document.DispMedicationStockDetails,'<%=drug_code%>','<%=patient_id%>','<%=order_id%>','<%=order_line_no%>','<%=drug_color%>','<%=alt_drug_code%>','<%=qty%>','<%=uom%>','<%=uom_code%>','<%=source%>','<%=recno%>','<%=store_code%>','<%=end_date%>','<%=drug_strength%>','<%=alt_drug_strength%>','<%=called_from%>','<%=bms_strength%>','<%=oper_mode%>','<%=drug_class%>','<%=stk_qty%>','<%=min_end_date%>','<%=drug_name%>','<%=altdrug_name%>','<%=main_strength_per_value_pres_uom%>','<%=alt_drg_no%>','<%=alt_strength_uom%>','<%=prescribed_strength%>','<%=bean_1.getBarcode_Scan_YN()%>');<!--//bean_1.getBarcode_Scan_YN() parameter added for KDAH-CRF-0231 [IN-034551] -->
<%	   
					}
					else{
						if(orig_dflt_issue_uom.equals("")){
%>				
							alert(getMessage("ITEM_IS_NOT_ASSIGNED","PH"));
<%			
						}
						else{
%>
							alert(getMessage("PH_ITEM_UOM_DEF_NOT_FOUND","PH"));
<%		
						}
%>
						 document.DispMedicationStockDetails.item_select.disabled	    =	true;
						 document.DispMedicationStockDetails.issue_uom_select.disabled	=	true;
						 clearItemDetail();
<%
					}
				}
				else{
%>
					clearItemDetail();
<%	
				}	
%>
			}
		</script>
<%
	}
	catch(Exception e){
		e.printStackTrace();
	}
%>
	</html>
<%
//putObjectInBean(bean_id,bean,request);
putObjectInBean(bean_id_1,bean_1,request);
%>

