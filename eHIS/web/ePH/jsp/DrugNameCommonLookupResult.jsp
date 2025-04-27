<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,java.sql.*,webbeans.eCommon.*, ePH.*, eOR.*, java.text.DecimalFormat, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%> 
<html>
	<head>
		<title></title> 
<%
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
10/01/2019	  	IN068344	     	Manickavasagam 		  								GHL-CRF-0549 [IN068344]
07/03/2019	        IN069337                Haribabu	     									Need to show Generic name in drug search lookup
09/04/2019	        IN069511                Haribabu	     									Available Quantity for drugs need to take from interface table
29/05/2020	IN:072092	        Manickavasagam J			     GHL-CRF-0618
30/06/2020  		IN072347				Shazana											            	GHL-CRF-0619  
03/11/2020		IN:074297	        Manickavasagam J			     GHL-SCF-1527
10/11/2020	6041			Shazana       										NMC-JD-CRF-0063
04/01/2021	 TFS id:7345 Haribabu	      04/01/2021       Manickavasagam J			     MMS-DM-CRF-0177
06/01/2021   TFS-12457              Prabha		06/01/2020	Manickavasagam J  Alpha-PH -Drug master setup in Query mode
16/04/2021  	TFS id:-16341    Haribabu	 16/04/2021	 	 Manickavasagam J          NMC-JD-CRF-0097
24/08/2021      TFS-22422           Prabha    24/08/2021	 Manickavasagam J          SKR-SCF-1631
18/11/2021		TFS-26007		   Prabha 												GHL-SCF-1614
03/01/2022		TFS-26862		   Prabha												GHL-ICN-0090
--------------------------------------------------------------------------------------------------------------
*/
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086	


		String locale			= (String)session.getAttribute("LOCALE");
	
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
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
	Connection con			= null;   
	try{
		con						   = ConnectionManager.getConnection(request);//added for GHL-CRF-0549
     	  	boolean item_type_site_app = eCommon.Common.CommonBean.isSiteSpecific(con,"PH","ITEM_TYPE_APP");//added for GHL-CRF-0549
     	  	boolean ext_disp_appl = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","EXT_DISP_APPL");//Added for IN069511
		boolean formulary_billing_app = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","FORMULARY_BLG_GRP_APP"); //GHL-CRF-0618

		
		String	bean_id			=	request.getParameter("bean_id");
		String	bean_name		=	"ePH.DrugSearchBean";
		DrugSearchBean bean		=	(DrugSearchBean)getBeanObject( bean_id, bean_name, request ) ;
	    bean.setLanguageId(locale);
	    bean.setExt_disp_appl(ext_disp_appl);//Added for IN069511
		bean.setFormularyBlngApp(formulary_billing_app);//GHL-CRF-0618
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
		String normalRx_yn		= request.getParameter("normalRx_yn")==null?"":request.getParameter("normalRx_yn"); //GHL-CRF-0549
		String priviligeCheck_fromSearch = request.getParameter("priviligeCheck")==null?"":request.getParameter("priviligeCheck");        
		bean.setPriviligeDrugCheck(priviligeCheck_fromSearch);
		String drugorfluid		= bean.getDrugOrFluid();
		String search_by		= bean.getSearchBy();
		String title			= "";
		String title1			= "";//Added for NMC-JD-CRF-0001
		String store_desc		=	"";
		String store_code		=	"";
		String description		=	"";
		String description1		=	"";//Added for NMC-JD-CRF-0001
		String disp_charge_dtl_in_drug_lkp_yn	="";
		String bl_install_yn= CommonBean.checkForNull((String) session.getValue( "bl_operational" ),"N") ;
		String disp_price_type_in_drug_lkp		="";
		String drug_class						="";
		String prompt_alert_check_YN			="";
		String billing_preference_check_YN		=""; 
		String preffered_drug_alert_text		="";
		String showAlert						="";
		String encounter_id						="";
		String episodeType						= "";
		String episodeId						= "";
		String visitId							= "";
		String itemCode							= "";
		String billingPrefereneBasisInd			= "";
		String billingPreferredItemCode			= "";
		String billingErrorMsg					= "";
		String practitionerId					= "";
		String promptAlertItemCheckYN			= "";
		String showAlertOncheck					= "";
		String storeSelectedDrugs				= "";
		String uomDesc1							="";
		String uomDesc2							="";
		String qtyString1						="";
		String qtyString2						="";
		String qtySymbol						="";
		//String strengthString					= "";
		String billingPriority					= "";
		String display_generic_name_yn          =CommonBean.checkForNull(bean.getDisplayGenericNameApp(facility_id));//Added for NMC-JD-CRF-0001
		String alternateDisable					= "";//added for  JD-CRF-0198 [IN:058599]
		ArrayList billingPreferenceCheckList	=null;
		bean.setNoOfDecimals();
		int noOfDecimals						=bean.getNoOfDecimals();
		ArrayList remaining_search				= new ArrayList();			
		//Added for TFS id:7345 start
		boolean pre_alloc_appl=bean.getPreAllocAppl();
		boolean disp_appl_for_pre_alloc =true;
		boolean disp_locn_select_appl =bean.getDefaultDispLocnSelectAppl();//Added for TFS id:-16341
		
		
		if(pre_alloc_appl){
			display_generic_name_yn="Y";
		}
		//Added for TFS id:7345	end
		if(search_by.equals("D")) {
			//title	=	"Drug Name";
		    title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DrugName.label","common_labels");
		    //Added for NMC-JD-CRF-0001 start
		    if(display_generic_name_yn.equals("Y")){
		    title1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.GenericName.label","common_labels");
		    }
		    //Added for NMC-JD-CRF-0001 end
			remaining_search.add("G");
			remaining_search.add("T");
			remaining_search.add("C");
		}
		else if(search_by.equals("G")) {
			//title	=	"Generic Name";
			title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.GenericName.label","common_labels");
			//Added for NMC-JD-CRF-0001 start
		    if(display_generic_name_yn.equals("Y")){
			title1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DrugName.label","common_labels");
		    }
		    //Added for NMC-JD-CRF-0001 end
			remaining_search.add("D");
			remaining_search.add("T");
			remaining_search.add("C");
		}
		else if(search_by.equals("T")) {
			//title	=	"Trade Name";
			title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DrugName.label","common_labels");
			//Added for NMC-JD-CRF-0001 start
		    if(display_generic_name_yn.equals("Y")){
		    title1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.GenericName.label","common_labels");
		    }
		    //Added for NMC-JD-CRF-0001 end
			remaining_search.add("D");
			remaining_search.add("G");
			remaining_search.add("C");
		}
		else if(search_by.equals("C")) {
			title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DrugName.label","common_labels");  //Added for ICN 30808/30804
			//Added for NMC-JD-CRF-0001 start
		    if(display_generic_name_yn.equals("Y")){
		    title1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.GenericName.label","common_labels");
		    }
		    //Added for NMC-JD-CRF-0001 end
			remaining_search.add("D");
			remaining_search.add("G");
			remaining_search.add("T");
		}
		else if(search_by.equals("A")) {
			//title	=	"Drug Name";
			title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DrugName.label","common_labels");
			//Added for NMC-JD-CRF-0001 start
		    if(display_generic_name_yn.equals("Y")){
		    title1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.GenericName.label","common_labels");
		    }
		    //Added for NMC-JD-CRF-0001 end
			remaining_search.add("D");
			remaining_search.add("T");
			remaining_search.add("G");
			remaining_search.add("C");
		}
		else {
			//title	=	"Drug Name";
			title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DrugName.label","common_labels");
			//Added for NMC-JD-CRF-0001 start
		        if(display_generic_name_yn.equals("Y")){
			title1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.GenericName.label","common_labels");
			 }
		         //Added for NMC-JD-CRF-0001 end
			remaining_search.add("G");
			remaining_search.add("T");
			remaining_search.add("C");
		}

		if(drugorfluid==null){
			drugorfluid="";
		}

		String order_type_code  = "";
		String Classification   = "";
		String res_by_service	= "";
		String service_code		= "";
		String consider_stock	= "N";
		String patient_id		= bean.getPatientId();
		encounter_id			= bean.getEncounterId();
		
		String bean_id_2		= "@PrescriptionBean_1"+patient_id+encounter_id;
		String bean_name_2		= "ePH.PrescriptionBean_1";
		PrescriptionBean_1 bean_2		= (PrescriptionBean_1)getBeanObject( bean_id_2, bean_name_2, request ) ;	
		bean_2.setLanguageId(locale);

		//String or_bean_name				= "eOR.OrderEntryBean";
		//String or_bean_id				= "@orderentrybean"+patient_id+encounter_id;
		//OrderEntryBean orbean			= (OrderEntryBean)getBeanObject( or_bean_id,or_bean_name,request ) ;
		//added for NMC-JD-CRF-0063 START
		System.out.println("Presc getTakeHomeMedicationOp :"+bean_2.getTakeHomeMedicationOp());//added for NMC-JD-CRF-0063 START
		System.out.println("Presc getOpDischMedInd :"+bean_2.getOpDischMedInd()); 
		System.out.println("bean_2.getOpHomeMedicationVal(): "+bean_2.getOpHomeMedicationVal()); //END
		bean.setTakeHomeMedicationOp(bean_2.getTakeHomeMedicationOp());  
		bean.setOpDischMedInd(bean_2.getOpDischMedInd());//END
		System.out.println("Drugbean getTakeHomeMedicationOp :"+bean.getTakeHomeMedicationOp());//added for NMC-JD-CRF-0063 START
		System.out.println("Drugbean getOpDischMedInd :"+bean.getOpDischMedInd()); //END
       String or_bean_name				= "eOR.OrderEntryBean";
	   String or_bean_id						= "@orderentrybean"+patient_id+encounter_id;
	   OrderEntryBean orbean			= (OrderEntryBean)getBeanObject( or_bean_id,or_bean_name,request ) ;

		orbean.setLanguageId(locale);
//String servide_code					= (String) orbean.getServiceCode();

		String resp_id                  = (String) session.getValue("responsibility_id");	   
	  
        if(bean.getcalledfrom().equals("DIRECT")){
			 practitionerId			  = bean.getPractitionerId();
		}else{			    
			 practitionerId			  = orbean.getPractitionerId();
			 bean.setPractitionerId(practitionerId);			
		}
	    String drug_priv_appln_yn		= bean.getDrugPrivilegeYN();
	

		if (identity==null){
			identity="General";
		}
		bean.setIdentity(identity);
        
		ArrayList stock_params	=	bean.validateForStock();
		if(stock_params.size() > 1) {
			consider_stock					= (String)stock_params.get(0);
			disp_charge_dtl_in_drug_lkp_yn	= (String)stock_params.get(2);
			disp_price_type_in_drug_lkp		= (String)stock_params.get(3);
		}
					
		if (from == null)
			from = "";
		if (to == null)
			to = "";
		ArrayList arrList = new ArrayList();
		String alternateOrder = "N";//added for  JD-CRF-0198 [IN:058599]
		if(request.getParameter("alternateOrder")!=null)
			alternateOrder=request.getParameter("alternateOrder");
		
		if(alternateOrder.equals("Y"))
			alternateDisable = "disabled";//added for  JD-CRF-0198 [IN:058599]
		if(!search_by.equals("A")){
			if (searchBasedOn.equals("Drug")){		
				arrList	= (ArrayList)bean.searchBasedOnDataSelected(from,to, bl_install_yn, disp_charge_dtl_in_drug_lkp_yn, disp_price_type_in_drug_lkp,priviligeCheck_fromSearch,practitionerId,resp_id,drug_priv_appln_yn);
			}
			else if (searchBasedOn.equals("ATC")){
				Classification	= request.getParameter("Classification");
				if (identity.equals("MedicationOrder")){
					order_type_code		= request.getParameter("order_type_code");
					bean.setOrderTypeCode(order_type_code);
					res_by_service		= request.getParameter("res_by_service");
					bean.setResByService(res_by_service);
					service_code		 = request.getParameter("service_code");
					bean.setServiceCode(service_code);
				}
				//else{		
				arrList		= (ArrayList)bean.searchBasedOnATCClassfication(Classification,from,to, bl_install_yn, disp_charge_dtl_in_drug_lkp_yn, disp_price_type_in_drug_lkp,  priviligeCheck_fromSearch, practitionerId, resp_id, drug_priv_appln_yn); //,priviligeCheck_fromSearch,practitionerId,resp_id,drug_priv_appln_yn ADDED for INC 28155
				
				bean.setInFormulary("Y");
				//}
			}
			/*else if(searchBasedOn.equals("Pharmaco")){
				Classification = request.getParameter("Classification");
				arrList		= (ArrayList)bean.searchBasedOnPharmacoClassfication(Classification,from,to, bl_install_yn, disp_charge_dtl_in_drug_lkp_yn, disp_price_type_in_drug_lkp);
			}*/
			
			if(arrList!=null && arrList.size()<=1){
				
				bean.setSearchBy((String)remaining_search.get(0));
				search_by = (String)remaining_search.get(0);
				if (searchBasedOn.equals("Drug")){		
					arrList	= (ArrayList)bean.searchBasedOnDataSelected(from,to, bl_install_yn, disp_charge_dtl_in_drug_lkp_yn, disp_price_type_in_drug_lkp,priviligeCheck_fromSearch,practitionerId,resp_id,drug_priv_appln_yn);	
				}
				else if (searchBasedOn.equals("ATC")){
				
					Classification = request.getParameter("Classification");
					if (identity.equals("MedicationOrder")){
						order_type_code		= request.getParameter("order_type_code");
						bean.setOrderTypeCode(order_type_code);
						res_by_service		= request.getParameter("res_by_service");
						bean.setResByService(res_by_service);
						service_code		= request.getParameter("service_code");
						bean.setServiceCode(service_code);
					}		
					arrList		= (ArrayList)bean.searchBasedOnATCClassfication(Classification,from,to, bl_install_yn, disp_charge_dtl_in_drug_lkp_yn, disp_price_type_in_drug_lkp,  priviligeCheck_fromSearch, practitionerId, resp_id, drug_priv_appln_yn); //,priviligeCheck_fromSearch,practitionerId,resp_id,drug_priv_appln_yn ADDED for INC 28155
					bean.setInFormulary("Y");
				}
				/*else if(searchBasedOn.equals("Pharmaco")){
					Classification = request.getParameter("Classification");
					arrList		= (ArrayList)bean.searchBasedOnPharmacoClassfication(Classification,from,to, bl_install_yn, disp_charge_dtl_in_drug_lkp_yn, disp_price_type_in_drug_lkp);
				}*/
				
				if(arrList!=null && arrList.size()<=1){
					
					bean.setSearchBy((String)remaining_search.get(1));
					search_by = (String)remaining_search.get(1);
					if (searchBasedOn.equals("Drug")){		
						arrList	= (ArrayList)bean.searchBasedOnDataSelected(from,to, bl_install_yn, disp_charge_dtl_in_drug_lkp_yn, disp_price_type_in_drug_lkp,priviligeCheck_fromSearch,practitionerId,resp_id,drug_priv_appln_yn);		
					}
					else if (searchBasedOn.equals("ATC")){
						
						Classification = request.getParameter("Classification");
						if (identity.equals("MedicationOrder")){
							order_type_code = request.getParameter("order_type_code");
							bean.setOrderTypeCode(order_type_code);
							res_by_service = request.getParameter("res_by_service");
							bean.setResByService(res_by_service);
							service_code   = request.getParameter("service_code");
							bean.setServiceCode(service_code);
						}
						
						arrList		= (ArrayList)bean.searchBasedOnATCClassfication(Classification,from,to, bl_install_yn, disp_charge_dtl_in_drug_lkp_yn, disp_price_type_in_drug_lkp,  priviligeCheck_fromSearch, practitionerId, resp_id, drug_priv_appln_yn); //,priviligeCheck_fromSearch,practitionerId,resp_id,drug_priv_appln_yn ADDED for INC 28155
						bean.setInFormulary("Y");
					}
					/*else if(searchBasedOn.equals("Pharmaco")){
						Classification = request.getParameter("Classification");
						arrList		= (ArrayList)bean.searchBasedOnPharmacoClassfication(Classification,from,to, bl_install_yn, disp_charge_dtl_in_drug_lkp_yn, disp_price_type_in_drug_lkp);
					}*/
				}
			}
		}
		else if(search_by.equals("A")){
			
			bean.setSearchBy("A");
			if (searchBasedOn.equals("Drug")){		
				arrList	= (ArrayList)bean.searchBasedOnDataSelected(from,to, bl_install_yn, disp_charge_dtl_in_drug_lkp_yn, disp_price_type_in_drug_lkp,priviligeCheck_fromSearch,practitionerId,resp_id,drug_priv_appln_yn);		
			}
			else if (searchBasedOn.equals("ATC")){
				Classification = request.getParameter("Classification");
				if (identity.equals("MedicationOrder")){
					order_type_code = request.getParameter("order_type_code");
					bean.setOrderTypeCode(order_type_code);
					res_by_service = request.getParameter("res_by_service");
					bean.setResByService(res_by_service);
					service_code   = request.getParameter("service_code");
					bean.setServiceCode(service_code);
				}
				
				arrList		= (ArrayList)bean.searchBasedOnATCClassfication(Classification,from,to, bl_install_yn, disp_charge_dtl_in_drug_lkp_yn, disp_price_type_in_drug_lkp,  priviligeCheck_fromSearch, practitionerId, resp_id, drug_priv_appln_yn); //,priviligeCheck_fromSearch,practitionerId,resp_id,drug_priv_appln_yn ADDED for INC 28155
				
			}
		}
		if(alternateOrder.equals("Y"))//added for  JD-CRF-0198 [IN:058599]
			search_by = "";
		Hashtable ht = (Hashtable)bean.getSelectedDrugs();
		String enableDisable="";
		String in_formulary_yn	=	bean.getInFormulary();
		if(search_by.equals("G")){ 
			title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.GenericName.label","common_labels");
			//Added for NMC-JD-CRF-0001 start
		    if(display_generic_name_yn.equals("Y")){
			title1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DrugName.label","common_labels");
		    }
		  //Added for NMC-JD-CRF-0001 end
		}
		else {
			title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DrugName.label","common_labels");
			//Added for NMC-JD-CRF-0001 start
		    if(display_generic_name_yn.equals("Y")){
		    title1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.GenericName.label","common_labels");
		    }
		    //Added for NMC-JD-CRF-0001 end
		}
		if (ht.size()==0){
			enableDisable = "disabled";		
		}
%>
		<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
			<form name="frmDrugNameCommonLookupResult" id="frmDrugNameCommonLookupResult" method = "POST">
<%
				String decimalStringFormat = "#.";
				// if Condition added for IN18681 to avoid displaying decimal point after the number  --01/02/2010--   shyampriya		
				if(noOfDecimals == 0)
					decimalStringFormat = "#";
			
				for (int i=0;i<noOfDecimals;i++){
						decimalStringFormat += "#";
				}
				if (arrList.size()>1){
%>
					<table cellpadding='0' cellspacing='0' width="100%" align="center">
						<tr>
							<td width="80%" class="white">&nbsp;</td>
							<td width="20%" class="white">&nbsp;
<%
								// For display the previous/next link
								out.println(arrList.get(0));
%>
							</td>
						</tr>
					</table>
					<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center" name="resultTable" id="resultTable" id="resultTable">
						<tr>
							<td class="COLUMNHEADER" width="1%">&nbsp;</td>
<%
							if(identity.equals("MedicationOrder")){
								if(bean_2.getExternalpatient_id()==null || bean_2.getExternalpatient_id().equals("")){
%>                                  
									<td class="COLUMNHEADER" width="2">&nbsp;</td>
<%		
								}
							}
%>
							
<%						
						//GHL-CRF-0549  - start
							if(bl_install_yn.equals("Y") && normalRx_yn!=null && normalRx_yn.equals("Y") && item_type_site_app && (bean_2.getExternalpatient_id()==null || bean_2.getExternalpatient_id().equals(""))){	
%>							
							<td class="COLUMNHEADER" width="10%" nowrap><fmt:message key="ePH.ItemType.label" bundle="${ph_labels}"/></td>
<%	
							}
							//GHL-CRF-0549  - end
%>							<td class="COLUMNHEADER" width="10%"><fmt:message key="ePH.Form.label" bundle="${ph_labels}"/></td>
							<td class="COLUMNHEADER" width="40%"><%=title%></td>
							<!--Added for NMC-JD-CRF-0001 Start -->
							<%if(display_generic_name_yn.equals("Y")){ %>
							<td class="COLUMNHEADER" width="40%"><%=title1%></td>
							<%} %>
							<!--Added for NMC-JD-CRF-0001 end -->
							
<%
							if (identity.equals("MedicationOrder") ){
%>								
								 <td class="COLUMNHEADER" width="5%"></td> 
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
									if( bean_2.getExternalpatient_id()==null || bean_2.getExternalpatient_id().equals("") ){
%>
										<td class="COLUMNHEADER"><fmt:message key="ePH.AvailableQty.label" bundle="${ph_labels}"/></td>
										<td class="COLUMNHEADER"><fmt:message key="ePH.Quantity/Uom.label" bundle="${ph_labels}"/></td>
<%		
									}
								}	
								if(!drugorfluid.equals("F") && !drugorfluid.equals("IVF")&& !drugorfluid.equals("CO")) { 
%>
									<td class="COLUMNHEADER"><fmt:message key="ePH.Select.label" bundle="${ph_labels}"/></td>
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
						String trade_code		=	"";
						String trade_name		=	"";
						String generic_id		=	"";
						String generic_name		=	"";
						String disp_str			=	"";
						String error_code		=	"";
						String sys_message_id	=	"";
						String error_text		=	"";
						String external_product_id ="";
						String route_color      =""; // added for CRF RUT-CRF-0034.1[IN:037389]-start
						String fntColor         ="";
						String backgrndColor    ="";// added for CRF RUT-CRF-0034.1[IN:037389]-end
					//GHL-CRF-0549  - start
						String bl_grp_app		   = "";
						HashMap selected_drug	= bean.getSelectedDrug();
						//GHL-CRF-0618 - start
						String formulary_code = "";
						 String blg_grp_type   = "";
						 String formulary_value   = "";
						//GHL-CRF-0618 - end
						
						String mm_item_low_cost_yn = "";	
						String mm_item_high_margin_yn = "";
						String mm_item_Innovator_yn = "";
						boolean matched_entry_flow = false;
						String low_cost_green_style ="visibility:none";
						String high_margin_green_style ="visibility:none";
						String strength_value="";//added for ghl-crf-0548
						String drug_strength_uom="";//added for GHL-CRF-0548
						String high_margin_red_style   ="visibility:none";
						String low_cost_red_style	="visibility:none";
						String low_cost_grey_style ="visibility:none";
						String high_margin_grey_style ="visibility:none";
						String innovator_style		="visibility:none";
						String item_type = "";
						String onClick1  = "";
						if(item_type_site_app && (bean_2.getExternalpatient_id()==null || bean_2.getExternalpatient_id().equals("")))
						bl_grp_app = bean.getItemTypeApp(); 
						if(bl_grp_app.equals(""))
							bl_grp_app = "N";

						boolean disp_alt_window_flag = false;
						boolean mm_item_type_available  = true;
						//GHL-CRF-0618  - start
						boolean disp_non_preference_rem_window =false; 
						String preference = ""; //CRF-0618
						String preference_img = ""; //CRF-0618
						boolean non_preference_flag = false; //GHL-CRF-0618
						HashMap hm = null;
						ArrayList itemGenericType = null;

						if(formulary_billing_app){
							String blng_grp_id = bean.getBillingGrpId();
							formulary_value = bean.getFormularyBillingGrpCode(blng_grp_id);
							//formulary_value = bean.getFormularyBillingGrpCode("CBSN");
							if(!formulary_value.equals("")){
								formulary_code = formulary_value.substring(0, formulary_value.indexOf("~"));
								blg_grp_type = formulary_value.substring(formulary_value.indexOf("~")+1);
							}
 							if(!formulary_code.equals("")){
							 hm = bean.getFormularyBillingGrpCodeDtl(formulary_code,blng_grp_id,"D");//blng_grp_id added for GHL-SCF-1527
							 itemGenericType = bean.getItemGenericType();
							}
							//System.err.println("itemType=546===>"+itemGenericType);
								
						} //GHL-CRF-0618  - end
							for (int i=1;i<arrList.size();i++){
							
							String[] strArray=(String[])arrList.get(i);
							//Added for TFS id:7345 start
							 disp_appl_for_pre_alloc =true;
							if(pre_alloc_appl){
							strArray=bean.getPreAllocatedDrug(strArray[33],order_type_code,consider_stock,(String)stock_params.get(1),patient_id,encounter_id);
								if(strArray[34]!=null){
									if(strArray[34].equals(""))
									{
										strArray[34] = "T";
									}
									if(!(strArray[34].equals("T"))){  //Removed condition --> && strArray[20].equals("N") Condition added for MMS-QF-SCF-0686
										disp_appl_for_pre_alloc=false;
								
									} 
								}
							}
						//Added for TFS id:7345 end	
							//System.out.println("strArray"+strArray[32]);
							drug_code		= strArray[0];
							strength_value  = strArray[2];//added for ghl-crf-0548
							strength_value=strength_value.split(" ")[0];//added for ghl-crf-0548
							drug_strength_uom=strArray[32]==null?"":strArray[32];//added for ghl-crf-0548;
							if(search_by.equals("G")) {
								description	=	strArray[8];
								// Added for NMC-JD-CRF-0001 start
								if(display_generic_name_yn.equals("Y")){
								description1	=	strArray[1];
								}
								// Added for NMC-JD-CRF-0001 end
							}
							else {
								description	=	strArray[1];
								// Added for NMC-JD-CRF-0001 start
								if(display_generic_name_yn.equals("Y")){
								description1	=	strArray[8];
								}
								// Added for NMC-JD-CRF-0001 end
							}
							//Added for TFS id:7345 start
							if(pre_alloc_appl){
								if(disp_appl_for_pre_alloc){
									description	=	strArray[1];
									description1	=	strArray[8];
								}
								else{
									description	=	"";
									description1	=	strArray[8]+" "+ strArray[35]+" "+strArray[3];
								}
								
							}
							//Added for TFS id:7345 end
							//strArray[1]	=	java.net.URLEncoder.encode(strArray[1],"UTF-8"); Commneted for the issue num:25007 on 18/Nov/2010==By Sandhya
							
							if(strArray.length >= 14){
								in_formulary	= strArray[13];
							}
							else{
								in_formulary	= "N";
							}
							trade_code= strArray[10]==null?"":strArray[10];
							//if(trade_code ==null)
								//trade_code = "";

							trade_name=strArray[11];
							drug_class=strArray[21];
//consider_stock added during PE corrections by Naveen
							if(in_formulary.equals("Y")) {
								if (identity.equals("MedicationOrder")){
									if(order_type_code==null || order_type_code.equals(""))
										order_type_code = bean.getOrderTypeCode(drug_code);
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
							//GHL-CRF-0549  - start
							low_cost_green_style ="visibility:hidden";
							high_margin_green_style ="visibility:hidden";
							high_margin_red_style   ="visibility:hidden";
							low_cost_red_style	="visibility:hidden";
							low_cost_grey_style ="visibility:hidden";
							high_margin_grey_style ="visibility:hidden";
							innovator_style		="visibility:hidden"; 
							high_margin_grey_style = "visibility:hidden"; 
							low_cost_grey_style="visibility:hidden";
							//GHL-CRF-0549  - start
							route_color=strArray[31];// added for CRF RUT-CRF-0034.1[IN:037389]-start
							if(route_color!= null && !route_color.equals("")){
								if(route_color.length()==12){
							        fntColor= route_color.substring(0, 6);
									backgrndColor= route_color.substring(6, 12);
								 }
							}
							else{
									fntColor= "";
									backgrndColor= "";
							}// added for CRF RUT-CRF-0034.1[IN:037389]-end
		 //commented by naveen for PE correction on 5Apr2010
							//qty_uom				=	bean.getStockUOM(strArray[0]);
							if(strArray.length>26){
								qty_uom			=  strArray[27];
							}
							else{
								qty_uom				=	bean.getStockUOM(strArray[0]);
							}
							//Added if-else condition for external_product_id regarding incident:23572 on 1/Sept/2010
							if(strArray.length>26)
							external_product_id =strArray[28];
							else
							external_product_id="";	
							//ends
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
									onClick	=	"DrugSearchModify(this,'"+strArray[8]+"','"+strArray[9]+"','"+strArray[2]+"','"+strArray[3]+"','"+strArray[4]+"','"+strArray[6]+"','"+strArray[12]+"','"+strArray[0]+"','"+strArray[10]+"','"+java.net.URLEncoder.encode(strArray[11],"UTF-8")+"','"+i+"');";
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
							if(consider_stock.equals("Y")){ // if conditino added for NMC-JD-SCF-0022 [IN071220] and not null handled for DGB issue for the same scf
								if(stock_dtls!=null && stock_dtls.size()>0 && ((String)stock_dtls.get(5)).equals("Y")){
									if(Float.parseFloat(avl_qty)>0){
									  stock_yn			=	"Y";
									}else{
										stock_yn		=	"N";
									}
								}
							}
							DecimalFormat dfToInteger = new DecimalFormat(decimalStringFormat);	
							if(avl_qty != null && !avl_qty.equals("")){
								avl_qty = dfToInteger.format(Double.parseDouble(avl_qty));
							}
														
							error_code = strArray[17]==null?"":strArray[17];    
							sys_message_id = strArray[18]==null?"":strArray[18];
							error_text = strArray[19]==null?"":strArray[19]; 
							
							if (((error_code.equals("10") && (!error_text.equals(""))) ||!sys_message_id.equals(""))&&(!sys_message_id.equals("BL9743"))&&(strArray[29].equals("Y"))){
								strEnableDisable	=	"disabled";
							}
%>
							<tr >
							<!-- Modified for TFS id:7345 -->
							<%if(disp_appl_for_pre_alloc){ %>
								<td onClick="<%=plus_sign%>" onclick="disableClick(event);" class="<%=classvalue%>"><font class='HYPERLINK' onmouseover="<%=mouse_over%>">+</font></td>
								<%}else{ %>
								<td class="<%=classvalue%>" >&nbsp;</td>	
<%}	//Modified for TFS id:7345 end
								if(identity.equals("MedicationOrder")){
%>
									<input type ="hidden" name = "previligeGroupDrug_ordering_YN<%=i%>" id = "previligeGroupDrug_ordering_YN<%=i%>" value ="<%=strArray[25]%>" />
<%
                                   if(bean_2.getExternalpatient_id() == null || bean_2.getExternalpatient_id().equals("")){			
										if(consider_stock.equals("Y") && (stock_yn.equals("") || stock_yn.equals("N"))) {
										//Added for TFS id:7345 start
											if(disp_appl_for_pre_alloc){
											
%>
											<td class='INSUFFICIENTSTOCK'  width='2' title="<%=store_desc%>">&nbsp;</td>
											<%}else{ %>
											<td class='<%=classvalue%>'  width='2'>&nbsp;</td>		
<%   
										}}//Added for TFS id:7345 end
										else { 
%>
											<td class='<%=classvalue%>' width='2'></td>
<%
										}	
									}
								}
								//GHL-CRF-0549  - start
								if(bl_install_yn.equals("Y") && identity.equals("MedicationOrder") && normalRx_yn!=null && normalRx_yn.equals("Y") && item_type_site_app && (bean_2.getExternalpatient_id()==null || bean_2.getExternalpatient_id().equals(""))  ){

									disp_alt_window_flag = false;
									mm_item_type_available  = true;
									item_type= bean.getItemType(drug_code);
									
									mm_item_low_cost_yn = item_type.split("~")[0];
									mm_item_high_margin_yn = item_type.split("~")[1];
									mm_item_Innovator_yn = item_type.split("~")[2];

								//	mm_item_low_cost_yn = "Y";
								//	mm_item_high_margin_yn = "N";
								//	mm_item_Innovator_yn = "Y"; 
								if(!mm_item_low_cost_yn.equals("Y") && !mm_item_high_margin_yn.equals("Y") && !mm_item_Innovator_yn.equals("Y")){
								mm_item_type_available = false;
								}
								//GHL-CRF-0618  - start
								if(formulary_billing_app){
									mm_item_type_available=true;
									high_margin_red_style = "visibility:hidden";
									high_margin_green_style ="visibility:hidden";
									low_cost_green_style ="visibility:hidden";
									low_cost_red_style = "visibility:hidden";
									
									if(mm_item_low_cost_yn.equals("Y")){
										low_cost_grey_style = "visibility:visible";
									}else{
										low_cost_grey_style = "visibility:hidden";
									}
									if(mm_item_high_margin_yn.equals("Y")){
										high_margin_grey_style = "visibility:visible";								
									}else{
										high_margin_grey_style = "visibility:hidden";
									}
									if(mm_item_Innovator_yn.equals("Y")){
										innovator_style		="visibility:visible";
									}else{
										innovator_style		="visibility:hidden";
									}
									
								} //GHL-CRF-0618  - end

								//System.err.println("formulary_code====656=>"+formulary_code+"==blg_grp_type===>"+blg_grp_type);
					
								if(!bl_grp_app.equals("N")){
									disp_alt_window_flag = false;
									if(mm_item_low_cost_yn.equals("Y")) {
										if(bl_grp_app.equals("L")){
												low_cost_green_style ="visibility:visible";
												low_cost_red_style = "visibility:hidden";
												low_cost_grey_style = "visibility:hidden";
												
											if(mm_item_high_margin_yn.equals("Y")){
												high_margin_red_style = "visibility:visible";
												high_margin_green_style ="visibility:hidden";
												high_margin_grey_style = "visibility:hidden";
											}else{
												high_margin_grey_style = "visibility:hidden";
											}
										}else{
											if(bl_grp_app.equals("H")){
												low_cost_green_style ="visibility:hidden";
												low_cost_red_style = "visibility:visible";
												low_cost_grey_style = "visibility:hidden";
											}
										} 
									}else{
											low_cost_green_style ="visibility:hidden";
											low_cost_red_style = "visibility:hidden";
											low_cost_grey_style = "visibility:hidden";
									}
									if(mm_item_high_margin_yn.equals("Y")){
											if(bl_grp_app.equals("H")){
												high_margin_green_style ="visibility:visible";
												high_margin_red_style = "visibility:hidden";
												high_margin_grey_style = "visibility:hidden";
												if(mm_item_low_cost_yn.equals("Y")) {
												low_cost_red_style ="visibility:visible";
												low_cost_green_style = "visibility:hidden";
												low_cost_grey_style = "visibility:hidden";
												}

											}else{
												if(bl_grp_app.equals("L")){
													high_margin_red_style = "visibility:visible";
												}
											}
									}else{
										
											high_margin_green_style ="visibility:hidden";
											high_margin_red_style = "visibility:hidden";
											high_margin_grey_style = "visibility:hidden";
									}

									if(mm_item_Innovator_yn.equals("Y")){
											innovator_style		="visibility:visible";		
										}else{
											innovator_style		="visibility:hidden";		
										}
									}
								else{
									low_cost_green_style = "visibility:hidden";
									high_margin_green_style = "visibility:hidden";
									low_cost_red_style = "visibility:hidden";
									high_margin_red_style = "visibility:hidden";

									if(mm_item_low_cost_yn.equals("Y"))
										low_cost_grey_style = "visibility:visible";		
									else
										low_cost_grey_style = "visibility:hidden";					
	
									if(mm_item_high_margin_yn.equals("Y"))
										high_margin_grey_style = "visibility:visible";
									else
										high_margin_grey_style = "visibility:hidden";
									
									if(mm_item_Innovator_yn.equals("Y"))
										innovator_style		="visibility:visible";		
									else
										innovator_style		="visibility:hidden";		
								}
								//GHL-CRF-0618 - start
								if(formulary_billing_app){
									preference = "";
									preference_img = "";
									high_margin_red_style = "visibility:hidden";
									high_margin_green_style ="visibility:hidden";
									low_cost_green_style ="visibility:hidden";
									low_cost_red_style = "visibility:hidden";
									
									if(mm_item_low_cost_yn.equals("Y")){
										low_cost_grey_style = "visibility:visible";
									}else{
										low_cost_grey_style = "visibility:hidden";
									}
									if(mm_item_high_margin_yn.equals("Y")){
										high_margin_grey_style = "visibility:visible";								
									}else{
										high_margin_grey_style = "visibility:hidden";
									}
									if(mm_item_Innovator_yn.equals("Y")){
										innovator_style		="visibility:visible";
									}else{
										innovator_style		="visibility:hidden";
									}
									if(hm!=null && hm.size()>0){
									  if(itemGenericType!=null && itemGenericType.size()>0){
										if(itemGenericType.contains("D"))
											non_preference_flag = true;
									  }
										if(hm.containsKey(drug_code) && disp_appl_for_pre_alloc){//Modified for TFS id:7345
											non_preference_flag = true;
											preference = (String)hm.get(drug_code)==null?"":(String)hm.get(drug_code);
											
											if(preference.equals("P1")){
												preference_img ="<img src='../../ePH/images/Preference1.jpg' height='15' width='15' title='Prefered-1 Item' />";
											}else if(preference.equals("P2")){
												preference_img ="<img src='../../ePH/images/Preference2.jpg' height='15' width='15' title='Prefered-2 Item' />";
											}else if(preference.equals("P3")){
												preference_img ="<img src='../../ePH/images/Preference3.jpg' height='15' width='15' title='Prefered-3 Item' />"; 
											}else{
												preference_img ="<img src='../../ePH/images/Preference4.jpg' height='15' width='15' title='Non Prefered Item' />";
											}
										}else{
											if(non_preference_flag && disp_appl_for_pre_alloc)//Modified for TFS id:7345
											preference_img ="<img src='../../ePH/images/Preference4.jpg' height='15' width='15' title='Non Prefered Item' />";
										}

									}
								}
								//GHL-CRF-0618 - end
								if(selected_drug!=null && selected_drug.containsKey(drug_code)){
//System.err.println("DrugNameCommonLookupResult.jsp========697===>"+drug_code);									
									disp_alt_window_flag = true;
								}
								if(low_cost_green_style.equals("visibility:visible") || high_margin_green_style.equals("visibility:visible")){
								 disp_alt_window_flag = true;
								}
								
								if(!disp_alt_window_flag){
									if(low_cost_red_style.equals("visibility:visible") || high_margin_red_style.equals("visibility:visible")){
									 disp_alt_window_flag = false;
									}else{
										disp_alt_window_flag = true;
									}


								
								}


								}
								//if(low_cost_green_style.equals("visibility:visible") || high_margin_green_style.equals("visibility:visible")){
								 //disp_alt_window_flag = true;
								//}
								//added for GHL-CRF-0618 - start

								if(formulary_billing_app){
									disp_alt_window_flag = true;
									disp_non_preference_rem_window = false;
									if (identity.equals("MedicationOrder")){
										
											if(( strArray[24].equals("Y")) && strArray[30].equals("N")){
												if(blg_grp_type.equals("C")) {
													if(!preference.equals("")  && preference.equals("P1")){
														disp_alt_window_flag = true;
												
													}else{
														if((preference.equals("") && non_preference_flag  ) || preference.equals("P2") || preference.equals("P3")){
															disp_alt_window_flag = false;
												
														}
													}
												}else if(blg_grp_type.equals("R")){
													if(!preference.equals("")  && preference.equals("P1")){
														disp_alt_window_flag = true;
													}else{
														if(non_preference_flag)
														disp_alt_window_flag = false;
													}
												
												}
										
										}

										if(!disp_alt_window_flag){
											if(blg_grp_type.equals("C")){
												disp_non_preference_rem_window = true;
											}else{
												if(!preference.equals("P1"))
													disp_non_preference_rem_window = true;
												
											}
										
										}else{
											if(blg_grp_type.equals("C")){
												if(!preference.equals("P1"))
													disp_non_preference_rem_window = true;
											}else if(blg_grp_type.equals("R") && !preference.equals("P1") && non_preference_flag)
											strEnableDisable = "disabled";	
										}
									}
								}

								//added for GHL-CRF-0618 - end
								if(bl_install_yn.equals("Y") && identity.equals("MedicationOrder") && normalRx_yn!=null && normalRx_yn.equals("Y") && item_type_site_app  && (bean_2.getExternalpatient_id()==null || bean_2.getExternalpatient_id().equals(""))){
%>								<td class='<%=classvalue%>'>&nbsp;
								<%if(!low_cost_green_style.equals("visibility:hidden")){
								%>
								<img src="../../ePH/images/LowCostGreen.jpg" style='<%=low_cost_green_style%>' height='15' width='15' title='<fmt:message key="ePH.Matched.label" bundle="${ph_labels}"/>' ><%}
								if(!high_margin_green_style.equals("visibility:hidden")){
								%>
								<img src="../../ePH/images/HighMarginGreen.jpg" style="<%=high_margin_green_style%>" height='15' width='15' title='<fmt:message key="ePH.Matched.label" bundle="${ph_labels}"/>' >
								<%}if(!low_cost_red_style.equals("visibility:hidden")){
								%>
								<img src="../../ePH/images/LowCostRed.jpg" style="<%=low_cost_red_style%>" height='15' width='15' title='<fmt:message key="ePH.NotMatched.label" bundle="${ph_labels}"/>'><%}if(!high_margin_red_style.equals("visibility:hidden")){
								%>
								<img src="../../ePH/images/HighMarginRed.jpg" style="<%=high_margin_red_style%>" height='15' width='15' title='<fmt:message key="ePH.NotMatched.label" bundle="${ph_labels}"/>'> <%} if(!low_cost_grey_style.equals("visibility:hidden")){
								%>
								<img src="../../ePH/images/LowCost.jpg" title="Low Cost Item" style="<%=low_cost_grey_style%>" height='15' width='15' ><%} if(!high_margin_grey_style.equals("visibility:hidden")){
								%>
								<img src="../../ePH/images/HighMargin.jpg" title="High Margin Item" style="<%=high_margin_grey_style%>" height='15' width='15' ><%}if(!innovator_style.equals("visibility:hidden")){
								%>
								<img src="../../ePH/images/Innovator.jpg" title="Innovator Item" style="<%=innovator_style%>"  height='15' width='15' > <%}%>

								</td>
								<%}  	//GHL-CRF-0549  - end%>
								<td onclick="disableClick(event);" class="<%=classvalue%>" title="<%=store_desc%>"><%=strArray[5] %></td>
<%
								if (strEnableDisable != null){
									if(!strEnableDisable.equals("disabled")){				
										//commented by naveen for PE correction on 5Apr2010
										//prompt_alert_check_YN = bean.getAlertForPreferredDrug_YN(drug_code)==null?"":bean.getAlertForPreferredDrug_YN(drug_code);
										if(strArray.length>26)
										   prompt_alert_check_YN = strArray[26];
										else
										   prompt_alert_check_YN =	bean.getAlertForPreferredDrug_YN(drug_code)==null?"":bean.getAlertForPreferredDrug_YN(drug_code);
										
										encounter_id = bean.getEncounterId();
										episodeType = bean.returnEpisodeType();
										episodeId = bean.returnEpisodeID(episodeType,encounter_id);
										visitId = bean.returnVisitID(episodeType,encounter_id);
										itemCode = drug_code;
										if (bl_install_yn.equals("Y") && identity.equals("MedicationOrder"))
											billingPreferenceCheckList = bean.returnBillingPreferenceCheckValues(facility_id, patient_id, episodeType, episodeId, visitId, encounter_id,drug_code);
										if(billingPreferenceCheckList != null && billingPreferenceCheckList.size()>0){
											billing_preference_check_YN = billingPreferenceCheckList.get(0)==null?"":billingPreferenceCheckList.get(0).toString();
											billingPrefereneBasisInd = billingPreferenceCheckList.get(1)==null?"":billingPreferenceCheckList.get(1).toString();
											billingPreferredItemCode	= billingPreferenceCheckList.get(2)==null?"":billingPreferenceCheckList.get(2).toString();
											billingPriority	= billingPreferenceCheckList.get(3)==null?"":billingPreferenceCheckList.get(3).toString();
										}
										if (identity.equals("MedicationOrder") ){
											if (billing_preference_check_YN.equals("Y")){ 
												if (prompt_alert_check_YN.equals("Y")){
													showAlert="showAlert(this,'"+strArray[8]+"','"+strArray[9]+"','"+strArray[2]+"','"+strArray[3]+"','"+strArray[4]+"','"+strArray[6]+"','"+strArray[12]+"','"+strArray[0]+"','"+strArray[10]+"','"+java.net.URLEncoder.encode(strArray[11],"UTF-8")+"','"+i+"');";
													 onClick = "";
												}
												 else {
													showAlert = "";
													onClick	=	"DrugSearchModify(this,'"+strArray[8]+"','"+strArray[9]+"','"+strArray[2]+"','"+strArray[3]+"','"+strArray[4]+"','"+strArray[6]+"','"+strArray[12]+"','"+strArray[0]+"','"+strArray[10]+"','"+java.net.URLEncoder.encode(strArray[11],"UTF-8")+"','"+i+"');";
												 }
											}
											else{
												showAlert = "";
											}
										}	
									//GHL-CRF-0549  - start
									String patientClass= bean.getPatientClass();//added for GHL-CRF-0619
										onClick1 = onClick;
										if(bl_install_yn.equals("Y") && identity.equals("MedicationOrder") && normalRx_yn!=null && normalRx_yn.equals("Y") && item_type_site_app && (bean_2.getExternalpatient_id()==null || bean_2.getExternalpatient_id().equals("")) ){
										if(!disp_alt_window_flag){
											
										onClick1	=	"allowAlternateWindow('"+drug_code+"','"+java.net.URLEncoder.encode(store_desc,"UTF-8")+"','"+java.net.URLEncoder.encode(strArray[1],"UTF-8")+"','"+strArray[9]+"','"+strArray[6]+"','"+identity+"','"+drug_class+"','"+order_type_code+"','"+store_code+"','"+patient_id+"','"+encounter_id+"','"+strength_value+"','"+drug_strength_uom+"','Y','"+item_type_site_app+"','"+strArray[9]+"','"+i+"','"+strArray[2]+"','"+strArray[3]+"','"+strArray[4]+"','"+strArray[6]+"','"+strArray[12]+"','"+strArray[0]+"','"+strArray[10]+"','"+java.net.URLEncoder.encode(strArray[11],"UTF-8")+"','"+strArray[24]+"','"+strArray[30]+"','"+mm_item_type_available+"','"+formulary_billing_app+"');";//formulary_billing_app added for GHL-CRF-0618
										}
										else{
											if( non_preference_flag){ //GHL-CRF-0618  - start
											System.err.println("strArray[1]==>" + strArray[1] + "==drug_code==" + drug_code + "==after encounding==" + java.net.URLEncoder.encode(strArray[1],"UTF-8"));
												//added for GHL-CRF-0619
												if(blg_grp_type.equals("C")){
													if(disp_non_preference_rem_window){ //Modified for GHL-ICN-0086
														onClick1 = "if(checkBrand('"+drug_code+"','"+patient_id+"','"+encounter_id+"','"+bean_id+"','"+bean_name+"','"+java.net.URLEncoder.encode(strArray[1],"UTF-8")+"')){"+"if(formularyNonPreference('"+drug_code+"','"+patient_id+"','"+encounter_id+"','"+bean_id_2+"','"+bean_name_2+"')){"+onClick+"}"+"}"; //MODIFIED FOR GHL-ICN-0090
													}else{
													
														onClick1 = "if( checkBrand('"+drug_code+"','"+patient_id+"','"+encounter_id+"','"+bean_id+"','"+bean_name+"','"+java.net.URLEncoder.encode(strArray[1],"UTF-8")+"')){"+onClick+"}"; //MODIFIED FOR GHL-ICN-0090
													} //Modified for GHL-ICN-0086
													  
												}else{//GHL-CRF-0619 END
													if(disp_non_preference_rem_window){ //MODIFIED FOR GHL-SCF-1614
														onClick1 = "if(formularyNonPreference('"+drug_code+"','"+patient_id+"','"+encounter_id+"','"+bean_id_2+"','"+bean_name_2+"')){"+onClick+"}";
													}
												}//added for GHL-CRF-0619
											
											}else{  
												onClick1 = onClick;
											}
										
										}
										}
										//GHL-CRF-0549  - end
										//Modified for TFS id:7345 start
										if(!disp_appl_for_pre_alloc){
%>

										<td id="drug_name<%=i%>" onClick="" class="<%=classvalue%>" title="">
										
										<%}else{ %>
										<td id="drug_name<%=i%>" onClick="<%=showAlert%> <%=onClick1%>" class="<%=classvalue%>" title="<%=store_desc%>">
										<%} %>
										<!-- Modified for TFS id:7345 end-->
											<input type="hidden" name="drug_code<%=i%>" id="drug_code<%=i%>" value="<%=strArray[0]%>"><input type="hidden" name="line_no<%=i%>" id="line_no<%=i%>" value="<%=i%>"><input type="hidden" name="trade_code<%=i%>" id="trade_code<%=i%>" value="<%=trade_code%>"><input type="hidden" name="trade_name<%=i%>" id="trade_name<%=i%>" value="<%=trade_name%>">
											
											<font class='HYPERLINK' onmouseover="changeCursor(this);" ><%= description %>
											</font>
<%
											if(!strArray[11].equals("")){
												if(!(display_generic_name_yn.equals("Y")&&search_by.equals("G")) && disp_appl_for_pre_alloc){//Modified for TFS id:7345
%>
												<label class="label" style="font-size:xx-small;font-weight:normal" >(<%=strArray[11]%>)</label>
<%
											}}
%>
										</td>
										<!--Added for NMC-JD-CRF-0001 Start -->
										<%
										
										if(display_generic_name_yn.equals("Y")){ %>	
										<td id="drug_name<%=i%>" onClick="<%=showAlert%> <%=onClick1%>" class="<%=classvalue%>" title="<%=store_desc%>">
										<%-- <input type="hidden" name="drug_code<%=i%>" id="drug_code<%=i%>" value="<%=strArray[0]%>"><input type="hidden" name="line_no<%=i%>" id="line_no<%=i%>" value="<%=i%>"><input type="hidden" name="trade_code<%=i%>" id="trade_code<%=i%>" value="<%=trade_code%>"><input type="hidden" name="trade_name<%=i%>" id="trade_name<%=i%>" value="<%=trade_name%>"><!-- Commented for NMC-JD-SCF-0010 --> <!-- Modified comments for TFS-12457 -->--%>
											
											<font class='HYPERLINK' onmouseover="changeCursor(this);" ><%= description1 %>
											</font>	
											<%if(!strArray[11].equals("")){
												if(search_by.equals("G")){%>
											     <label class="label" style="font-size:xx-small;font-weight:normal" >(<%=strArray[11]%>)</label>
											<%}} %>
											</td>
											<%} %>
										<!--Added for NMC-JD-CRF-0001 end -->
<%	
										if (identity.equals("MedicationOrder") ){
%>
											 <td  class="<%=classvalue%>" width ="5%">&nbsp;<%=billingErrorMsg%>
<%
												if (billingPreferenceCheckList != null && disp_appl_for_pre_alloc){//Modified for TFS id:7345	
													if(billing_preference_check_YN.equals("Y") ){
														preffered_drug_alert_text="<img src='../../ePH/images/Insurance.gif' height='15' width='15' style='cursor:pointer' onClick = showPreferredDrugs('"+drug_code+"','"+billingPrefereneBasisInd+"','"+billingPreferredItemCode+"','"+searchBasedOn+"','"+identity+"','"+java.net.URLEncoder.encode(strArray[1],"UTF-8")+"','"+disp_charge_dtl_in_drug_lkp_yn+"','"+disp_price_type_in_drug_lkp+"','"+bl_install_yn+"','"+billingPriority+"'); />";
														
													} 
													else{
															preffered_drug_alert_text ="";
													}
												}
                                                //Added for IN069511 start
                                                if(stock_dtls!=null && stock_dtls.size()>0 && ((String)stock_dtls.get(5)).equals("Y") && disp_appl_for_pre_alloc){//Modified for TFS id:7345 //Modified for SKR-SCF-1631
	                                                  preffered_drug_alert_text=preffered_drug_alert_text + "&nbsp;<img src='../../ePH/images/ExternalDispensing.gif' height='18' width='20'/>"; 
                                                }
                                              //Added for IN069511 end
											  
											  
%>												<%=preffered_drug_alert_text%><%=preference_img%><!--GHL-CRF-0618   -->

											</td> 
<%                                 preffered_drug_alert_text="";//Added for IN069511
										}
										if(identity.equals("MedicationOrder")){
%>
											<td class="<%=classvalue%>" style='TEXT-ALIGN:center;'>
												<input type='hidden' name='diagnosis_found_yn<%=i%>' id='diagnosis_found_yn<%=i%>' value='<%=strArray[20]%>'>
												<input type='hidden' name='appl_for_age_grp_yn<%=i%>' id='appl_for_age_grp_yn<%=i%>' value='<%=strArray[22]%>'>
<%										
												if(drug_db_interface_yn.equals("Y")){
													if(external_product_id!=null && disp_appl_for_pre_alloc ){//Modified for TFS id:7345
													
%>
														<!-- Passing Encode URIcomponent for strArray[1] for the incident num:25007 on 18/Nov/2010 By Sandhya -->
														<img src="../../ePH/images/info.gif"  height='15' width='15' style="cursor:pointer" onClick="showDrugInfo('<%=external_product_id%>','<%=java.net.URLEncoder.encode(strArray[1],"UTF-8") %>')">
<%
													}
												}
%>
												&nbsp;</td>
<%
												if(bl_install_yn.equals("Y") && disp_charge_dtl_in_drug_lkp_yn.equals("Y") && in_formulary_yn.equals("Y")){
													if  (strArray[29].equals("Y")){
														if(strArray[16]!=null && !strArray[16].equals("")&& !strArray[16].equals("0") && disp_appl_for_pre_alloc){//Modified for TFS id:7345
															disp_str = "<img src=\"../../eCommon/images/enabled.gif\"></img>";
														}
														else{
															disp_str = "&nbsp";
														}
%>
													<td class="<%=classvalue%>" style='TEXT-ALIGN:center;'><%=disp_str%>
													</td>
<%
													if(strArray[14]!=null && !strArray[14].equals("")&& strArray[14].equals("Y") && disp_appl_for_pre_alloc){//Modified for TFS id:7345
														disp_str = "<img src=\"../../eCommon/images/enabled.gif\"></img>";
													}
													else{
														disp_str = "&nbsp";
													}
%>
													<td class="<%=classvalue%>" style='TEXT-ALIGN:center;'> <%=disp_str%>
													</td>
<%
													if(strArray[15]!=null && !strArray[15].equals("") && strArray[15].equals("Y") && disp_appl_for_pre_alloc){//Modified for TFS id:7345
														disp_str = "<img src=\"../../eCommon/images/enabled.gif\"></img>";
													}
													else{
														disp_str = "&nbsp";
													}
%>
													<td class="<%=classvalue%>" style='TEXT-ALIGN:center;'><%=disp_str%>
													</td>
<%
													if(strArray[16]!=null && !strArray[16].equals("")&& !strArray[16].equals("0") && disp_appl_for_pre_alloc){//Modified for TFS id:7345
														disp_str =strArray[16] ;
													}
													else{
														disp_str = "&nbsp";
														if (((error_code.equals("10") && (!error_text.equals(""))) ||!sys_message_id.equals(""))&&(!sys_message_id.equals("BL9743"))&&(strArray[29].equals("Y")) && disp_appl_for_pre_alloc){//Modified for TFS id:7345
															disp_str = "<font style=color:red>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")+"</font>";
														}
													}
%>
													<td class="<%=classvalue%>" style='TEXT-ALIGN:center;' title='' id='BL_ERROR<%=i%>'> <%=disp_str%>
													</td>
<%
													if (((error_code.equals("10") && (!error_text.equals(""))) ||!sys_message_id.equals(""))&&(!sys_message_id.equals("BL9743"))){
															//out.println("<script>dispTitle('"+error_code+"','"+error_text+"','"+sys_message_id+"','"+i+"');</script>");
														String check = error_text.replace("\n","");
														out.println("<script>");
														out.println("  var errorCode = '" + error_code + "';");
														out.println("  var errorText = '" + check + "';");
														out.println("  var sysMessageId = '" + sys_message_id + "';");
														out.println("  var iValue = '" + i + "';");
														out.println("  dispTitle(errorCode, errorText, sysMessageId, iValue);");
														out.println("</script>");
														}
													}
													else{
%>
														<td class="<%=classvalue%>" style='TEXT-ALIGN:center;'>&nbsp;</td>
														<td class="<%=classvalue%>" style='TEXT-ALIGN:center;'>&nbsp;</td>
														<td class="<%=classvalue%>" style='TEXT-ALIGN:center;'>&nbsp;</td>	
														<td class="<%=classvalue%>" style='TEXT-ALIGN:center;'>&nbsp;</td>
<%
													}
												}
											}
										}
										else{
%>
											<td id="drug_name<%=i%>" class="<%=classvalue%>" onclick="disableClick(event);" title="<%=store_desc%>"><input type="hidden" name="drug_code" id="drug_code<%=i%>" value="<%=strArray[0]%>"><input type="hidden" name="line_no<%=i%>" id="line_no<%=i%>"  value="<%=i%>"><input type="hidden" name="trade_code<%=i%>"  id="trade_name<%=i%>" value="<%=trade_code%>"><input type="hidden" name="trade_name<%=i%>"  id="trade_name<%=i%>" value="<%=trade_name%>">
											<label class="label" style="font-size:xx-small;font-weight:normal" onclick="disableClick(event);"><%= description %>
											</label>
<%
											if(!strArray[11].equals("")){
												if(!(display_generic_name_yn.equals("Y")&&search_by.equals("G"))){
%>
												<label class="label" style="font-size:xx-small;font-weight:normal" onclick="disableClick(event);">(<%=strArray[11]%>)</label>
<%
											}}
%>
											</td>
											<!--Added for NMC-JD-CRF-0001 Start -->
							                <%if(display_generic_name_yn.equals("Y")){ %>
											<td id="drug_name<%=i%>" class="<%=classvalue%>" onclick="disableClick(event);" title="<%=store_desc%>"><input type="hidden" name="drug_code"  id="drug_code<%=i%>" value="<%=strArray[0]%>"><input type="hidden" name="line_no<%=i%>" id="line_no<%=i%>" id="line_no<%=i%>" value="<%=i%>"><input type="hidden" name="trade_code<%=i%>" id="trade_code<%=i%>" id="trade_name<%=i%>" value="<%=trade_code%>"><input type="hidden" name="trade_name<%=i%>" id="trade_name<%=i%>" id="trade_name<%=i%>" value="<%=trade_name%>">
											<label class="label" style="font-size:xx-small;font-weight:normal" onclick="disableClick(event);"><%= description1 %>
											</label>
											
											<%if(!strArray[11].equals("")){
												if(search_by.equals("G")){%>
								                   <label class="label" style="font-size:xx-small;font-weight:normal" onclick="disableClick(event);">(<%=strArray[11]%>)</label>
                                            <%}} %> 
                                            <!--Added for NMC-JD-CRF-0001 end -->
											</td>
											<%}
											
										if (identity.equals("MedicationOrder") ){ // if else Added for IN069511 - DGB issues start
%>
											 <td  class="<%=classvalue%>" width ="5%">&nbsp;
<%										
                                                
										
                                                if(stock_dtls!=null && stock_dtls.size()>0 && ((String)stock_dtls.get(5)).equals("Y") && disp_appl_for_pre_alloc){//Modified for TFS id:7345 //Modified for SKR-SCF-1631
	                                                  preffered_drug_alert_text=preffered_drug_alert_text+"&nbsp;<img src='../../ePH/images/ExternalDispensing.gif' height='18' width='20'/>";
                                                }                                             
%>												<%=preffered_drug_alert_text%><%=preference_img%><!-- GHL-CRF-0618-->

											</td> 
<%                                 preffered_drug_alert_text="";} else{ %>
											 <td  class="<%=classvalue%>" width ="5%">&nbsp;&nbsp;</td> 
											 <%} // if else Added for IN069511 - DGB issues end  
											if(identity.equals("MedicationOrder")){
%>
												<td class="<%=classvalue%>" style='TEXT-ALIGN:center;'>
													<input type='hidden' name='diagnosis_found_yn<%=i%>' id='diagnosis_found_yn<%=i%>' value='<%=strArray[20]%>'>
													<input type='hidden' name='appl_for_age_grp_yn<%=i%>' id='appl_for_age_grp_yn<%=i%>' value='<%=strArray[22]%>'>
<%
													if(drug_db_interface_yn.equals("Y")){
														if(external_product_id!=null && disp_appl_for_pre_alloc ){//Modified for TFS id:7345
%>
															<img src="../../ePH/images/info.gif"  height='15' width='15' style="cursor:pointer" onClick="showDrugInfo('<%=external_product_id%>','<%= java.net.URLEncoder.encode(strArray[1],"UTF-8") %>')">	
<%
														}
													}
%>
												&nbsp;</td>
<%
												if(bl_install_yn.equals("Y") && disp_charge_dtl_in_drug_lkp_yn.equals("Y") && in_formulary_yn.equals("Y")){
													if(strArray[29].equals("Y")){
														if(strArray[16]!=null && !strArray[16].equals("")&& !strArray[16].equals("0") && disp_appl_for_pre_alloc){//Modified for TFS id:7345
															disp_str = "<img src=\"../../eCommon/images/enabled.gif\"></img>";
														}
														else{
															disp_str = "&nbsp";
														}
%>
													<td class="<%=classvalue%>" style='TEXT-ALIGN:center;'><%=disp_str%>
													</td>
<%
													if(strArray[14]!=null && !strArray[14].equals("")&& strArray[14].equals("Y") && disp_appl_for_pre_alloc){//Modified for TFS id:7345
														disp_str = "<img src=\"../../eCommon/images/enabled.gif\"></img>";
													}
													else{
														disp_str = "&nbsp";
													}
%>
													<td class="<%=classvalue%>" style='TEXT-ALIGN:center;'> <%=disp_str%>
													</td>
<%
													if(strArray[15]!=null && !strArray[15].equals("") && strArray[15].equals("Y") && disp_appl_for_pre_alloc){//Modified for TFS id:7345
														disp_str = "<img src=\"../../eCommon/images/enabled.gif\"></img>";
													}
													else{
														disp_str = "&nbsp";
													}
%>
													<td class="<%=classvalue%>" style='TEXT-ALIGN:center;'><%=disp_str%>
													</td>
<%
													if(strArray[16]!=null && !strArray[16].equals("")&& !strArray[16].equals("0") && disp_appl_for_pre_alloc){//Modified for TFS id:7345
														disp_str =strArray[16] ;
													}
													else{
														disp_str = "&nbsp";

														if (((error_code.equals("10") && (!error_text.equals(""))) ||!sys_message_id.equals(""))&&(!sys_message_id.equals("BL9743"))&&(strArray[29].equals("Y")) && disp_appl_for_pre_alloc){//Modified for TFS id:7345
															disp_str = "<font style=color:red>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")+"</font>";
														}
														else{
															disp_str = "&nbsp";
														}
													}
%>
													<td class="<%=classvalue%>" style='TEXT-ALIGN:center;' title='' id='BL_ERROR<%=i%>'> <%=disp_str%> 
													</td>
<%
													if (((error_code.equals("10") && (!error_text.equals(""))) ||!sys_message_id.equals(""))&&(!sys_message_id.equals("BL9743")) && disp_appl_for_pre_alloc){//Modified for TFS id:7345
														//out.println("<script>dispTitle('"+error_code+"','"+error_text+"','"+sys_message_id+"','"+i+"');</script>");
														String check = error_text.replace("\n","");
														out.println("<script>");
														out.println("  var errorCode = '" + error_code + "';");
														out.println("  var errorText = '" + check + "';");
														out.println("  var sysMessageId = '" + sys_message_id + "';");
														out.println("  var iValue = '" + i + "';");
														out.println("  dispTitle(errorCode, errorText, sysMessageId, iValue);");
														out.println("</script>");

		
													}
												}
												else{
%>

													<td class="<%=classvalue%>" style='TEXT-ALIGN:center;'>&nbsp;</td>
													<td class="<%=classvalue%>" style='TEXT-ALIGN:center;'>&nbsp;</td>
													<td class="<%=classvalue%>" style='TEXT-ALIGN:center;'>&nbsp;</td>
													<td class="<%=classvalue%>" style='TEXT-ALIGN:center;'>&nbsp;</td>
<%
												}
											}
										}										
									}
								}

								if (strArray[2] != null){
									if (!strArray[2].equals("0")){
										if(!strEnableDisable.equals("disabled")){
										str_click	=	"DrugSearchModify(eval(document.getElementById('drug_name"+i+"')),'"+strArray[8]+"','"+strArray[9]+"','"+strArray[2]+"','"+strArray[3]+"','"+strArray[4]+"','"+strArray[6]+"','"+strArray[12]+"','"+strArray[0]+"','"+strArray[10]+"','"+java.net.URLEncoder.encode(strArray[11],"UTF-8")+"','"+i+"');";
											font_class	=	"class='HYPERLINK' onMouseOver='changeCursor(this);'";
										} else {
											str_click	=	"";
											font_class	=	"style='font-size:11'";
										}
										
										/* Commented By Sandhya on 20/sep/2010 for the incidents-23841,23724,23792.from line num:833 to  870
										StringTokenizer st =new StringTokenizer(strArray[2]," ");
										if (st.hasMoreTokens()){  //
											qtyString1 = st.nextToken();
										
											if(qtyString1!=null && !qtyString1.equals("") && Float.parseFloat(qtyString1) <1)
												qtyString1 = Float.parseFloat(qtyString1)+"";
											
											int cnt = st.countTokens();
											if(cnt>3){
												uomDesc1   = st.nextToken();
												qtySymbol  = st.nextToken();
												qtyString2 = st.nextToken();
												if(qtyString2!=null && !qtyString2.equals("") && Float.parseFloat(qtyString2) <1)
													qtyString2 = Float.parseFloat(qtyString2)+"";
												
												uomDesc2   = st.nextToken();
												}
												else
												{
												uomDesc1   = "";
												qtySymbol  = "";
												qtyString2 = "";
												uomDesc2   = "";
											}
										}*/
										//commented for PE by Naveen
										/* if (!(uomDesc1.equals(""))){
											  uomDesc1 = bean.getUomDisplay(facility_id,uomDesc1);						 
										}
										if (!(uomDesc2.equals(""))){
											  uomDesc2 = bean.getUomDisplay(facility_id,uomDesc2);						 
										}*/
									  
									
										if(formulary_billing_app){ //GHL-CRF-0618
											str_click = "";
										}
%>
										<td  onClick="<%=str_click%>" class="<%=classvalue%>" title="<%=store_desc%>"><font <%=font_class%>><%=strArray[2]%>&nbsp;</font></td>
<%
									}
									else{
%>
										<td class="<%=classvalue%>">&nbsp;</td>
<%
									}
/**
				* @Name - Krishna Kiran 
				* @Date - 15/02/2010
				* @Inc# - 
				* @Desc - added the lines of code to fix the issue as the strength value is overriding for the other drugs .
*/
									uomDesc1   = "";
									qtySymbol  = "";
									qtyString2 = "";
									uomDesc2   = "";
									qtyString1 = "";
								}
%>
								<td onclick="disableClick(event);" class="<%=classvalue%>" title="<%=store_desc%>" style='color:<%=fntColor%>;background-color:<%=backgrndColor%>' >
								<%=strArray[7] %></td><!-- // added  style attribute for CRF RUT-CRF-0034.1[IN:037389]-end -->
<%
								if (identity.equals("MedicationOrder") ){
									//GHL-CRF-0618 - start
									if(formulary_billing_app){
										if((!preference.equals("") && !preference.equals("P1")) ||  ( !preference.equals("P1") && non_preference_flag) ){
											strEnableDisable  = "disabled";
										}
									} 
									//GHL-CRF-0618 - end
									if (ht.containsKey( strArray[0]+i)){
										if(( strArray[24].equals("Y")) && strArray[30].equals("N") && disp_appl_for_pre_alloc){ //strArray[30] - NPB_DRUG_YN //strArray[23].equals("Y") || Removed for ghl-crf-0548,Modified for TFS id:7345
%>
											<!-- Passing Encode URIcomponent for strArray[1] for the incident num:25007 on 18/Nov/2010 By Sandhya -->
											<!-- strength_value AND drug_strength_uom added for ghl-crf-0548 -->
											<td class="<%=classvalue%>" ><img src="../../ePH/images/altenate.jpg" style="cursor:pointer"  onClick="displayAlternateDrugs('<%=drug_code%>','<%=java.net.URLEncoder.encode(store_desc,"UTF-8")%>','<%=java.net.URLEncoder.encode(strArray[1],"UTF-8")%>','<%=strArray[9]%>','<%=strArray[6]%>','<%=identity%>','<%=drug_class%>','<%=order_type_code%>','<%=store_code%>', '<%= patient_id%>', '<%=encounter_id%>','<%=strength_value%>','<%=drug_strength_uom%>')" style="cursor:pointer;color:blue" height='15' width='15' > </td>
<% 
										}
										else{
%>
											<td class="<%=classvalue%>" >&nbsp;</td>
<%									
										}
										if(consider_stock.equals("Y")) {
											//Modified for IN069511 START
											if(disp_appl_for_pre_alloc){//Modified for TFS id:7345 start
											if(stock_dtls!=null && stock_dtls.size()>0 && ((String)stock_dtls.get(5)).equals("Y")){ //Modified for SKR-SCF-1631
%>                                          <td class="<%=classvalue%>" align="right" title="<%=store_desc%>">
											<%=avl_qty%> </td>
											<td class="<%=classvalue%>"><%=qty_uom%></td>
											<%} else{
												%>
											
											<td class="<%=classvalue%>" align="right" title="<%=store_desc%>"><font class='HYPERLINK' onmouseover="changeCursor(this);" ><label onclick="displayStock('<%=drug_code%>','<%=java.net.URLEncoder.encode(strArray[1],"UTF-8")%>','<%=trade_code%>','<%=java.net.URLEncoder.encode(store_desc)%>','<%=store_code%>');">
											<%=avl_qty%> </label></font></td>
											<td class="<%=classvalue%>"><%=qty_uom%></td>
<%}                                            //Modified for IN069511 END
										}
											else if(disp_locn_select_appl){ //Added for TFS id:-16341 start
												if(stock_dtls!=null && stock_dtls.size()>0 && ((String)stock_dtls.get(5)).equals("Y")){ //Modified for SKR-SCF-1631
													if(avl_qty.equals("0")){%>
													<td class='<%=classvalue%>' ><img src='../../ePH/images/StockUnavailable.png'  height='18' width='20' ></td>
												<%}
												else{%>
													<td class='<%=classvalue%>' ><img src='../../ePH/images/StockAvailable.png'  height='18' width='20' ></td>
												<% }
											}else{ %>
												<td class='<%=classvalue%>' ><%=avl_qty%></td>
												<%} %>
											<td class='<%=classvalue%>' >&nbsp;</td>
											<%}//Added for TFS id:-16341 end
											else{%>
											<td class='<%=classvalue%>' >&nbsp;</td>
											<td class='<%=classvalue%>' >&nbsp;</td>
											<%}} 
											//Modified for TFS id:7345 end
										if(!drugorfluid.equals("F") && !drugorfluid.equals("IVF")) {	
											if (prompt_alert_check_YN.equals("Y") && billing_preference_check_YN.equals("Y")){
												showAlertOncheck = "showAlertOnCheck("+i+",drug_code"+i+");";
												storeSelectedDrugs = "";
											}
											else{
												showAlertOncheck = "";
												storeSelectedDrugs = "storeSelectedDrugs("+i+",drug_code"+i+");";
											}
											if( !drugorfluid.equals("CO") ){
												if(disp_appl_for_pre_alloc){//Modified for TFS id:7345 start
%>
												<td class="<%=classvalue%>" style='TEXT-ALIGN:center;'>
													<input type="checkbox" name="drugSelect<%=i%>" id="drugSelect<%=i%>" value="" checked onClick='<%=showAlertOncheck%> <%=storeSelectedDrugs%>'>
												</td>
												<%} else{ %>
												<td class="<%=classvalue%>"  style='TEXT-ALIGN:center;'>
													<input type="checkbox" name="drugSelect<%=i%>" id="drugSelect<%=i%>" value="" disabled>
												</td>			
<%
												}}//Modified for TFS id:7345 end
										}
									}
									else{
										if(( strArray[24].equals("Y")) && strArray[30].equals("N") && disp_appl_for_pre_alloc){ //strArray[30] - NPB_DRUG_YN //strArray[23].equals("Y") || Removed for ghl-crf-0548,Modified for TFS id:7345
%>
											<!-- Passing Encode Uri component for strArray[1] for the incident num:25007 on 18/Nov/2010 -->
											<!-- strength_value AND drug_strength_uom added for ghl-crf-0548 -->
											<td class="<%=classvalue%>" ><img src="../../ePH/images/altenate.jpg"  height='15' width='15' style="cursor:pointer"  onClick="displayAlternateDrugs('<%=drug_code%>','<%=java.net.URLEncoder.encode(store_desc,"UTF-8")%>','<%= java.net.URLEncoder.encode(strArray[1],"UTF-8") %>','<%=strArray[9]%>','<%=strArray[6]%>','<%=identity%>','<%=drug_class%>','<%=order_type_code%>','<%=store_code%>', '<%= patient_id%>', '<%=encounter_id%>','<%=strength_value%>','<%=drug_strength_uom%>')" style="cursor:pointer;color:blue" > </td>
<% 
										}
										else{
%>
											<td class="<%=classvalue%>" >&nbsp;</td>
<%
										}
										if(consider_stock.equals("Y")) { 
											if(disp_appl_for_pre_alloc){//Modified for TFS id:7345 start
											if( bean_2.getExternalpatient_id()==null || bean_2.getExternalpatient_id().equals("")){
												//Modified for IN069511 START
												if(stock_dtls!=null && stock_dtls.size()>0 && ((String)stock_dtls.get(5)).equals("Y")){ //Modified for SKR-SCF-1631
%>                                              <td class="<%=classvalue%>" align="right" title="<%=store_desc%>"><%=avl_qty%> </td>
												<td class="<%=classvalue%>"><%=qty_uom%> </td>
												<% }else{
												%>
												<td class="<%=classvalue%>" align="right" title="<%=store_desc%>"><font class='HYPERLINK' onmouseover="changeCursor(this);" ><label  onclick="displayStock('<%=drug_code%>','<%=java.net.URLEncoder.encode(strArray[1], "UTF-8")%>','<%=trade_code%>','<%=java.net.URLEncoder.encode(store_desc, "UTF-8")%>','<%=store_code%>');"><%=avl_qty%> </label></font></td>
												<td class="<%=classvalue%>"><%=qty_uom%> </td>
<%	}//Modified for IN069511 END
											}
										}
											else if(disp_locn_select_appl){//Added for TFS id:-16341 start
												if(stock_dtls!=null && stock_dtls.size()>0 && ((String)stock_dtls.get(5)).equals("Y")){ //Modified for SKR-SCF-1631
													if(avl_qty.equals("0")){%>
														<td class='<%=classvalue%>' ><img src='../../ePH/images/StockUnavailable.png'  height='18' width='20' ></td>
													<%}
													else{%>
														<td class='<%=classvalue%>' ><img src='../../ePH/images/StockAvailable.png'  height='18' width='20' ></td>
													<% }
												}else{ %>
												<td class='<%=classvalue%>' ><%=avl_qty%></td>
												<%} %>
											<td class='<%=classvalue%>' >&nbsp;</td>
											<%}
											else{%><!-- Added for TFS id:-16341 end -->
											<td class='<%=classvalue%>' >&nbsp;</td>
											<td class='<%=classvalue%>' >&nbsp;</td>
											<%}//Modified for TFS id:7345 end
										}	
										if(strChecked.equals("checked")) { 
											strEnableDisable  = "disabled";
										}
										if(!drugorfluid.equals("F") && !drugorfluid.equals("IVF")) {	
											if (prompt_alert_check_YN.equals("Y") && billing_preference_check_YN.equals("Y")){
												showAlertOncheck = "showAlertOnCheck("+i+",drug_code"+i+");";
												storeSelectedDrugs = "";
											}
											else{
												showAlertOncheck = "";
												storeSelectedDrugs = "storeSelectedDrugs("+i+",drug_code"+i+");";
											}
											if( !drugorfluid.equals("CO") ){
												if(disp_appl_for_pre_alloc){//Modified for TFS id:7345 start
%>
												<td class="<%=classvalue%>" style='TEXT-ALIGN:center;' >
													<input type="checkbox" name="drugSelect<%=i%>" id="drugSelect<%=i%>" value="" onClick = '<%=showAlertOncheck%> <%=storeSelectedDrugs%>' <%=strEnableDisable%> <%=strChecked%> <%=alternateDisable %>><!-- //added for  JD-CRF-0198 [IN:058599] -->
												</td>
												<%}else{ %>	
												<td class="<%=classvalue%>"  style='TEXT-ALIGN:center;' >
													<input type="checkbox" name="drugSelect<%=i%>" id="drugSelect<%=i%>" value=""  <%=strEnableDisable%>><!--//Changed Disabled to strEnableDisable for MMS-QF-SCF-0686 //added for  JD-CRF-0198 [IN:058599] -->
												</td>								
<%
												}}//Modified for TFS id:7345 end
										}
									}
								 }
%>
								</tr>
								<input type="hidden" name="pres_base_uom<%=i%>" id="pres_base_uom<%=i%>" value="<%=strArray[12]%>">			<input type="hidden" name="generic_id<%=i%>" id="generic_id<%=i%>" id="generic_id<%=i%>" value="<%=strArray[9]%>"><input type="hidden" name="generic_name<%=i%>" id="generic_name<%=i%>" id="generic_name<%=i%>" value="<%=strArray[8]%>">
								<input type="hidden" name="drug_desc<%=i%>" id="drug_desc<%=i%>" id="drug_desc<%=i%>" value="<%=description%>">	
								<input type="hidden" name="drug_clicked<%=drug_code%>" id="drug_clicked<%=drug_code%>" value="N" >
<%				
							}
						}
						else if(arrList==null || arrList.size()<1 || !arrList.get(0).equals("cancel")){
%>
							<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
							//	window.close();
							</script>
<%
						}
%>
					</table>
					<input type="hidden" name="from" id="from" value="">
					<!-- <input type="hidden" name="from1" id="from1" value=""> -->
					<input type="hidden" name="to" id="to" value="">
					<!-- <input type="hidden" name="to1" id="to1" value=""> -->
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
					if (identity.equals("MedicationOrder") && arrList.size()>1){
%>			
						<br>
							<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1">
								<tr >
									<td class="white" width="1%">
										<label style="visibility:hidden">+</label>
									</td>
<%
									if(consider_stock.equals("Y")) { 
										if(bean_2.getExternalpatient_id()==null || bean_2.getExternalpatient_id().equals("")){
%>
											<td class='INSUFFICIENTSTOCK' style= "background-color:red" width='1%'>&nbsp;</td>
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
										if(bean_2.getExternalpatient_id()==null || bean_2.getExternalpatient_id().equals("")){
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
								<td class="white" align="left" nowrap>&nbsp;&nbsp;<fmt:message key="ePH.AlternateDrugs.label" bundle="${ph_labels}"/></td>	
								<td align="right" class="white"><img src='../../ePH/images/Insurance.gif'  height='15' width='15' ></td>
								<td class="white" align="left"  nowrap>&nbsp;&nbsp;<fmt:message key="ePH.PreferredDrugs CoveredUnderPolicy.label" bundle="${ph_labels}"/> </td>
								<!-- Added for IN069511 START -->
								<%if(ext_disp_appl && !(bean.getcalledfrom().equals("DIRECT"))){ %>
								<td align="right" class="white"><img src='../../ePH/images/ExternalDispensing.gif'  height='18' width='20' ></td>
								<td class="white" align="left"  nowrap>&nbsp;&nbsp;<fmt:message key="ePH.ExternalDispensing.label" bundle="${ph_labels}"/> </td>
								<%} %>
								<!-- Added for IN069511 END -->
<%								//GHL-CRF-0549  - start
								if(bl_install_yn.equals("Y") && normalRx_yn!=null && normalRx_yn.equals("Y") && 		item_type_site_app && !formulary_billing_app && (bean_2.getExternalpatient_id()==null || bean_2.getExternalpatient_id().equals(""))){ 	 %><!-- modifiedfor GHL-CRF-0618-->
								<td class="white" align="left"><img src="../../ePH/images/LowCost.jpg" height='15' width='15' >
								<td class="white" align="left" nowrap><fmt:message key="ePH.LowCostItem.label" bundle="${ph_labels}"/>
								</td >
								<td class="white" align="left"><img src="../../ePH/images/HighMargin.jpg" height='15' width='15' ></td>
								<td class="white" align="left" nowrap><fmt:message key="ePH.HighMarginItem.label" bundle="${ph_labels}"/>
								</td>
								<td class="white" align="left"><img src="../../ePH/images/Innovator.jpg" height='15' width='15' ></td><td class="white" align="left" nowrap>
								<fmt:message key="ePH.Innovator.label" bundle="${ph_labels}"/>
								</td>
								<%} 	//GHL-CRF-0549  - end%>
								<td>
									<input type="button" value='<fmt:message key="ePH.Select.label" bundle="${ph_labels}"/>' name="btnSelect" class="button" onClick="returnAllSelectedDrugs()" <%=enableDisable%>>
								</td>
							</tr>
							<%if(formulary_billing_app)  //Start of GHL-CRF-0618
						{%>
					<tr>
							<td class='white' width='1%'></td>	
							 <td class="white" align="left">
									<img src="../../ePH/images/Preference1.jpg"  height='15' width='15' >
								</td>
								<td class="white" align="left" nowrap>&nbsp;<fmt:message key="ePH.PreferedItem1.label" bundle="${ph_labels}"/>&nbsp;</td>
												
								<td class="white" align="left">
									<img src="../../ePH/images/Preference2.jpg"  height='15' width='15' >
								</td>
								<td class="white" align="left" nowrap>&nbsp;<fmt:message key="ePH.PreferedItem2.label" bundle="${ph_labels}"/>&nbsp;</td>
								
								<td class="white" align="left">
									<img src="../../ePH/images/Preference3.jpg"  height='15' width='15' >
								</td>
								<td class="white" align="left" nowrap>&nbsp;<fmt:message key="ePH.PreferedItem3.label" bundle="${ph_labels}"/>&nbsp;</td>
								
								<td class="white" align="left">
									<img src="../../ePH/images/Preference4.jpg"  height='15' width='15' >
								</td>
								<td class="white" align="left" nowrap>&nbsp;<fmt:message key="ePH.NonPreferedItem.label" bundle="${ph_labels}"/>&nbsp;</td>
							</tr>
							<%
							}%>    <!-- End of GHL-CRF-0618 -->
						</table>
<%
					}
%>
	 
				   <input type ='hidden' name ='priviligeCheck_fromSearch' id ='priviligeCheck_fromSearch' value ='<%=priviligeCheck_fromSearch%>'>
				   <input type="hidden" name="bl_install_yn" id="bl_install_yn" value="<%=bl_install_yn%>">
				   <input type="hidden" name="disp_charge_dtl_in_drug_lkp_yn" id="disp_charge_dtl_in_drug_lkp_yn" value="<%=disp_charge_dtl_in_drug_lkp_yn%>">
				   <input type="hidden" name="disp_price_type_in_drug_lkp" id="disp_price_type_in_drug_lkp" value="<%=disp_price_type_in_drug_lkp%>">
				   <input type="hidden" name="priviligeCheck" id="priviligeCheck" value= "<%=priviligeCheck_fromSearch%>" >
				</form>
			</body>
		<script language="javascript">
			defaultSearchBy('<%=bean.getSearchBy()%>');
		</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<%
		putObjectInBean(bean_id,bean,request);
		putObjectInBean(bean_id_2,bean_2,request);
	}
	catch(Exception e){
		e.printStackTrace();
	}finally{ 
        	if(con != null)
          		ConnectionManager.returnConnection(con,request);	 //added for GHL-CRF-0549
	}
%>
</html>

