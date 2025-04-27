<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%> 
<% 
/*
-------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name       Rev.Date		Rev.Name		 Description
-------------------------------------------------------------------------------------------------------------------------------
?             100           ?												created
28/02/2013	  LiveIssue		Chowminya G									the Procedure name displayed incorrectly (code same as discr_msr)
10/03/2014	  IN024984		Chowminya	 								Duplicate order recording with reason - new mandatory option	
13/03/2014	  IN047644		Karthi		 								Duplicate Override check box is still displayed and enabled even though order catalog is disabled
20/05/2016	  51135		Karthi		 									MO-CRF-20085 [IN051135]
08/05/2017	IN063816		Vijayakumar K									GHL-CRF-0445.1 [IN:063816]
15/12/2017	IN065942	Dinesh T	15/12/2017	Ramesh G	In Nuclear medicine  department we required the barcode 																	functionality at the time of Registration of order,required 																patient Id,patient name,age,sex,register date and name of 																	study.
10/05/2019  IN068926       sivabagyam      10/05/2019      Ramesh G    	 ML-MMOH-CRF-1290																	functionality at the time of Registration of order,required 																patient Id,patient name,age,sex,register date and name of 																	study.
24/12/2019	IN068314	Nijitha		  23/12/2019			Ramesh G	 ML-MMOH-CRF-1229
07/09/2020	7540			Nijitha S		07/12/2020		Nijitha S		PMG2019-MMS-CRF-0004.1
-------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*,eOR.* ,eOR.Common.*,webbeans.eCommon.ConnectionManager,java.sql.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
 <%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<style>
		textarea {
		  	resize: none;
		}
	</style>
	<link rel='StyleSheet' href="../../eCommon/html/<%=sStyle%>" type='text/css'></link>
	
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language="javascript" src="../../eCommon/js/common.js" ></script>
	<script language="javascript" src="../../eOR/js/OrCommonFunction.js"></script>

	<script>
		var testvar="test";

		function assignDummys(objFrom,objTo,type){

			if(type == "CheckBox"){
				if(objFrom.checked == true )
					objTo.checked == true ;
				else
					objTo.checked == true ;
			}

		}

		function checkBoxValidate()
		{	
			//if(document.detailLowerForm.routine_chk_for_dupl_yn)	{
			if(document.detailLowerForm.routine_chk_for_dupl_yn !=null && document.detailLowerForm.urgent_chk_for_dupl_yn.checked !=null && document.detailLowerForm.stat_chk_for_dupl_yn.checked !=null) {
				if(document.detailLowerForm.routine_chk_for_dupl_yn.checked	 == false && document.detailLowerForm.urgent_chk_for_dupl_yn.checked == false && document.detailLowerForm.stat_chk_for_dupl_yn.checked == false){
				//alert("deselect");
					document.detailLowerForm.chk_for_dupl_yn.checked = false ;
					document.detailLowerForm.routine_chk_for_dupl_yn.disabled = true ;
					document.detailLowerForm.urgent_chk_for_dupl_yn.disabled = true ;
					document.detailLowerForm.stat_chk_for_dupl_yn.disabled = true ;
					/*444444444444444444444444444*/
					document.detailLowerForm.dup_reason_reqd_yn.checked = false ;	// // IN047644
				    document.detailLowerForm.chk_for_dupl_status.selectedIndex = 0;
				    document.detailLowerForm.check_for_dupl_level.selectedIndex    = 0;
				    //document.detailLowerForm.activity_type.value	         = "";
				    //parent.parent.parent.chkActionType(detailLowerForm.activity_type);
					document.detailLowerForm.chk_for_dupl_behind_action.selectedIndex	 = 0;
					document.detailLowerForm.chk_for_dupl_behind_period.value	     = "";
					document.detailLowerForm.chk_for_dupl_behind_unit.selectedIndex    = 0;
					document.detailLowerForm.chk_for_dupl_ahead_action.selectedIndex	 = 0
					document.detailLowerForm.chk_for_dupl_ahead_period.value	     = "";
					document.detailLowerForm.chk_for_dupl_ahead_unit.selectedIndex     = 0;
				
					document.detailLowerForm.chk_for_dupl_status.disabled		    = true;
					document.detailLowerForm.check_for_dupl_level.disabled		= true;
					//document.detailLowerForm.activity_type.disabled				= true;
					document.detailLowerForm.chk_for_dupl_behind_action.disabled	= true;
					document.detailLowerForm.chk_for_dupl_behind_period.disabled	= true;
					document.detailLowerForm.chk_for_dupl_behind_unit.disabled    = true;
					document.detailLowerForm.chk_for_dupl_ahead_action.disabled	= true;
					document.detailLowerForm.chk_for_dupl_ahead_period.disabled	= true;
					document.detailLowerForm.chk_for_dupl_ahead_unit.disabled     = true;
			
						/*4444444444444444444444*/
			
				}else if(document.detailLowerForm.routine_chk_for_dupl_yn.checked == true || document.detailLowerForm.urgent_chk_for_dupl_yn.checked == true || document.detailLowerForm.stat_chk_for_dupl_yn.checked == true){
						//alert("select");
						document.detailLowerForm.chk_for_dupl_yn.checked = true ;
				}
			}
			//}
		
		}
	
	function changeValue()
	{
		var consent_req_bo = document.detailLowerForm.num_of_consent_req_bo.value;
		var consent_req_br = document.detailLowerForm.num_of_consent_req_br.value;
		if(parseInt(consent_req_bo) > 0 || parseInt(consent_req_br) == 0)
		{
			document.detailLowerForm.consent_stage.selectedIndex=0;
		}
		else if(parseInt(consent_req_br) > 0)
		{
			document.detailLowerForm.consent_stage.selectedIndex=1;
		}
		else
		{
			return false;
		}
	}
	function setValues(obj)
	{
		if(obj.value=="A")
		{
			document.detailLowerForm.num_of_consent_req_bo.value = 1;
			document.detailLowerForm.num_of_consent_req_br.value = 0;
		}
		else if(obj.value=="R")
		{
			document.detailLowerForm.num_of_consent_req_bo.value = 0;
			document.detailLowerForm.num_of_consent_req_br.value = 1;
		}
	}
	function changeConsentNoteText(obj)
	{
		var multi_consent = document.detailLowerForm.multiple_consent_yn.checked;
		if(obj.value=="V" && multi_consent==false)
		{
			document.detailLowerForm.consent_form_id.disabled = true;
			document.detailLowerForm.consent_form_id.value = "";
		}
		else if(obj.value=="F" && multi_consent==false)
		{
			document.detailLowerForm.consent_form_id.disabled = false;
		}
	}
	//IN024984 - Start
	function displayDuplicateReq(obj)
	{
		if (obj.value != '' && obj.value == 'W')
		{
			if((document.detailLowerForm.chk_for_dupl_behind_action.selectedIndex == '2') || (document.detailLowerForm.chk_for_dupl_ahead_action.selectedIndex == '2'))
				document.getElementById('dup_reason_chk').style.display ='inline';
		}
		else
		{
			if((document.detailLowerForm.chk_for_dupl_behind_action.selectedIndex == '2') || (document.detailLowerForm.chk_for_dupl_ahead_action.selectedIndex == '2'))	
				document.getElementById('dup_reason_chk').style.display ='inline';
			else
				document.getElementById('dup_reason_chk').style.display ='none';
		}
	}
	//IN024984 - End
//IN068314 Starts
	function loadfppCategory(obj){
		if('Y'==obj.value){
			fppCategoryApplicable_lbl_td.style.visibility ='visible';
			fppCategoryApplicable_td.style.visibility ='visible';
			fppCategoryApplicable_lbl_td.innerHTML 	= getLabel("eOR.FPPCATEGORYS.label","OR");
			fppCategoryApplicable_td.innerHTML 	= "<TD><select name=\"fpp_category\" id=\"fpp_category\"><option  value=\"S\" selected>"+getLabel('eOR.Simple.label','Common')+"</option><option  value=\"M\">"+getLabel('eOR.Medium.label','OR')+"</option><option  value=\"C\">"+getLabel('eOR.Complex.label','OR')+"</option></select></TD>";
		}
		else	
		{
			fppCategoryApplicable_lbl_td.style.visibility ='hidden';
			fppCategoryApplicable_td.style.visibility ='hidden';
			fppCategoryApplicable_lbl_td.innerHTML 	= "";
			fppCategoryApplicable_td.innerHTML="";
		}	
	}
//IN068314 Ends
	</script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
  <body onLoad="parent.parent.parent.defaultIntLowerFrame(),checkBoxValidate();"  onMouseDown="CodeArrest()" onKeyDown="lockKey()">

 <!--ONLOAD OF BODY= parent.parent.parent.chkDuplicateReq(document.getElementById("chk_for_dupl_yn")) -->
<form name='detailLowerForm' id='detailLowerForm' target='messageFrame' scrolling='auto' >
<%

try{


	//String readOnly = "" ;
	//String checked = "checked" ;
	/* Mandatory checks start */	
	String mode			= request.getParameter( "mode" ) ;
	String bean_id = "Or_OrderCatalog" ;
	String bean_name = "eOR.OrderCatalogBean";
	//String disabled = "" ;
	String FppModificaion =""; //IN068314
	OrderCatalogBean bean = (OrderCatalogBean)getBeanObject(bean_id, bean_name,request ) ;
	bean.setLanguageId(localeName);
	//String function_id  =bean.checkForNull(request.getParameter("function_id"));		
	//headerStore
	HashMap orderCatalogHeaderStr =	bean.getOrderCatalogHeaderStr();


/*****DEFAULT VALUES****/
	String result_auth_reqd_yn_default	   = "N";



	String eff_status					   = "E" ; //For modify mode Only

	//to display the various tab
	String StyleDefaultSyn				   = "bottom-margin:0;"  ;	
	String StyleDefaultTiming			   = "bottom-margin:0;display:none ;"  ;
	String StyleDefaultInstrns			   = "bottom-margin:0;display:none ;"  ;
	String tabFlag=request.getParameter("tabFlag");
	

	if (tabFlag.equalsIgnoreCase("Timing")){
		StyleDefaultSyn			   = "bottom-margin:0;display:none;";
		StyleDefaultTiming			   = "bottom-margin:0;";
		StyleDefaultInstrns			   = "bottom-margin:0;display:none;";
	}else if(tabFlag.equalsIgnoreCase("O")){
		StyleDefaultSyn			   = "bottom-margin:0;display:none;";
		StyleDefaultTiming			   = "bottom-margin:0;display:none;";
		StyleDefaultInstrns			   = "bottom-margin:0;";
	
	}
	String StyleDefaultDup				   = "bottom-margin:0;display:none ;"  ;
	String StyleDefaultCon				   = "bottom-margin:0;display:none ;"  ;
	String StyleDefaultexpText			   = "bottom-margin:0;display:none ;"  ;
	
	String uom_style						= "display:none";
	String ChargeTypeApplicable_style		= "display:none";


	/**********UPDATABLE DEF******************/
	 //Syn  Tab
	String catalog_synonym_directCare_updatable			 = "Y";
	String effective_status_directCare_updatable		 = "Y";
	String catalog_synonym_ancillaryDept_updatable		 = "Y";
	String effective_status_ancillaryDept_updatable		 = "Y";

	//Timing Tab
	String qty_reqd_yn_updatable						 = "Y" ;
	String split_dose_yn_updatable						 = "Y" ;
	String taper_dose_yn_updatable				 		 = "Y" ;
	String none_yn_updatable				 		 = "Y" ;
	String appl_sliding_scale_yn_updatable               = "Y" ;
	String taper_up_updatable				 		     = "Y" ;
	String none_yn_value								 =  "Y" ;
	String update_freq_yn								 = "N" ;
	String update_soft_stop_yn							 = "N" ;
	String update_cont_order_yn							 = "N" ;

	String contineous_freq_order_updatable				 = "Y";
	//**String indexed_yn_updatable						     = "Y";//moved to header frame

	String consent_reqd_yn_updatable					 = "Y" ;
	String multi_consent_yn_updatable					 = "Y" ;
	String consent_stage_updatable						 = "N" ;
	String consent_form_id_updatable					 = "N" ;
	String priority_appl_updatable                       = "Y" ;
	String refusalNoteText_appl_updatable                = "Y" ;

	String qty_reqd_yn_def								 = "N" ;
	String update_refill_cont_order_yn					 = "N" ;
	String refill_cont_order_yn_default					 = "N";

	//Duplicate
	String reqUpdatable									 = "N" ;//Dupl chk req Feild....
	
	//Expalnatory
	String explanatory_textUpdatable					 = "Y" ;

//review	//(Charting)
	String dept_only_yn_updatable						 = "Y";
	String com_on_ord_Updateble							 = "N";	
	String bill_Updateble								 = "N";	
	//**String image_link_id_Updateble						 = "N";//moved to header frame
	String chart_res_Updateble							 = "N";	//Autho req	
	//String athu_req_Updateble							 = "N";
	String ord_cat_nature_Updateble						 = "N";	
	String chart_result_type_updateble					 = "N";	
	//String discr_msr_pan_id_Updateble					 = "N";	// depend on 	chart_res_Updateble
	//String optionsLink_Updateble					 	 = "y";
	String contr_mod_id_Updateble						 = "y";// depend on
	String ChartProceApplicable							 = "Y" ;
	String proc_link_resulting_option_style				="visibility:hidden";
	/*term set store*/
	ArrayList TermSetID=new ArrayList();
	String[] record=null;
	String term_set_style								="visibility:hidden";
	String proc_term_set_style								="display:none";
	String auto_report_style;	
	String dupl_reason_set_style						="display:none";//IN024984
	//String contr_msr_panel_id_Updateble				 	 = "y";// depend on
	/***///review
	String barcode_required_yn_updatable				= "Y";	//IN063816
	//IN063816 start
	String barcodeSiteSpecificYN = "";

	boolean isSiteSpecific = false;
	boolean isfppapplicable= false;//IN068314
	Connection connection =  null;
	try{
	connection = ConnectionManager.getConnection(request); 
	isSiteSpecific = eCommon.Common.CommonBean.isSiteSpecific(connection, "OR","GHL_BARCODE_LABEL_REPORT");
	isfppapplicable = eCommon.Common.CommonBean.isSiteSpecific(connection, "OR","FPP_APPLICABLE_YN");//IN068314
	}catch(Exception e1){
		e1.printStackTrace();
	}finally{
		if(connection!=null) connection.close();
	}
	if(isSiteSpecific)
	{
		barcodeSiteSpecificYN = "Y";
	}
	else
	{
		barcodeSiteSpecificYN = "N";
	}
	//IN063816 ends


	/*Billing installed chks*/
	String bill_install_Yn ="N";
	String single_selected="selected";
	String multi_selected="";
	try
	{
		HashMap   billingChk      = bean.getSqlResult("SQL_OR_CHECK_MODULE_INSTALL_YN");
		bill_install_Yn =(String)billingChk.get("INSTALL_YN1");
		//bill_install_Yn="Y";
		if(bill_install_Yn == null)
			bill_install_Yn="N";
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	/****/



	/****Passed from Other Module*********/
	String module_id		 = bean.checkForNull(request.getParameter( "module_id"));
	//String module_id		 = "PH"; --Kavithas testing string
	String uom_code			 = bean.checkForNull(request.getParameter( "uom_code"));
	
	String uom_desc			 = bean.checkForNull(request.getParameter( "uom_desc"));

	
	String order_category	 = bean.checkForNull(request.getParameter( "order_category"));
	String order_type_code	 = bean.checkForNull(request.getParameter( "order_type_code"));
	String qry_str				= request.getQueryString();
	String tpn_item_yn	 = bean.checkForNull(request.getParameter( "tpn_item_yn"));//IN068926
	/***/
	/***if(order_category.trim().equalsIgnoreCase("RX") || order_category.trim().equalsIgnoreCase("RD")|| order_category.trim().equalsIgnoreCase("TR") )
		image_link_id_Updateble = "Y" ;****///moved to header frame



	/******Retriving Store for this tab*******/
	ArrayList  characteristicsRecStr =  bean.getCharacteristicsRecStr();

	//String proc_coding_scheme=bean.getdefaultArrListValue(characteristicsRecStr,0,"proc_coding_scheme","");						
	String term_code=bean.getdefaultArrListValue(characteristicsRecStr,0,"term_code","");	
	String term_desc=bean.getdefaultArrListValue(characteristicsRecStr,0,"term_desc","");	
	//IN068314 Starts
	String fppCategoryApplicable_style="display:none";
	String fpp_yn=bean.getdefaultArrListValue(characteristicsRecStr,0,"fpp_yn","N");	
	String fpp_category=bean.getdefaultArrListValue(characteristicsRecStr,0,"fpp_category","S");
	
	if("Y".equals(fpp_yn)){
		fppCategoryApplicable_style="";
	}
	
	//IN068314 Ends
	/********MODIFY MODE **************************/

	if ( mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) )){
		FppModificaion ="disabled"; //IN068314
 		//In modify mode if the eff status is no then all should be disabled
	//eff_status  =  bean.checkForNull((String)orderCatalogHeaderStr.get("eff_status"));
		eff_status  =  (String)orderCatalogHeaderStr.get("eff_status");
		eff_status	= eff_status.trim();
 		//PH VALIDATION
		if(module_id.trim().equalsIgnoreCase("PH")){


		//Always be checked for PH & updateble or not depends on PH
		 update_refill_cont_order_yn	   = request.getParameter("update_refill_cont_order_yn");

		 StyleDefaultSyn				   = "bottom-margin:0;display:none ";  //Primary tab to be hidden
		 if(tabFlag.equalsIgnoreCase("C")){
		 StyleDefaultTiming				   = "bottom-margin:0;display:none "  ;//Shown by default
		 StyleDefaultCon				   = "bottom-margin:0;;"  ;//Shown by default
		 }else{
			StyleDefaultTiming			   = "bottom-margin:0;"  ;//Shown by default
			StyleDefaultCon				   = "bottom-margin:0;display:none ;"  ;//Shown by default	 
		 }
		 StyleDefaultDup				   = "bottom-margin:0;display:none ;"  ;		 
		 StyleDefaultexpText			   = "bottom-margin:0;display:none ;"  ;
		 StyleDefaultInstrns			   = "bottom-margin:0;display:none ;" ; //Instr's tab to be hidden
	  } else if (!order_category.trim().equalsIgnoreCase("PH")) {
		  
	  	if (!bean.getdefaultArrListValue(characteristicsRecStr,0,"qty_uom",uom_code).equals("")) { 		uom_desc=bean.getqty_uom_desc(bean.getdefaultArrListValue(characteristicsRecStr,0,"qty_uom",uom_code));
	  	}
	  }else if(order_category.trim().equalsIgnoreCase("PH"))
		{

			 StyleDefaultSyn				   = "bottom-margin:0;display:none ";  //Primary tab to be hidden
			 if(tabFlag.equalsIgnoreCase("C")){
			 StyleDefaultTiming				   = "bottom-margin:0;display:none "  ;
			 StyleDefaultCon				   = "bottom-margin:0;;"  ;//Shown by default
			 }else{
				StyleDefaultTiming			   = "bottom-margin:0;"  ;//Shown by default
				StyleDefaultCon				   = "bottom-margin:0;display:none ;"  ;	 
			 }
			 StyleDefaultDup				   = "bottom-margin:0;display:none ;"  ;
			 StyleDefaultexpText				= "bottom-margin:0;display:none ;"  ;
			 StyleDefaultInstrns			   = "bottom-margin:0;display:none ;" ; //Instr's tab to be hidden
	  
		 }

}


	/**CALLED FROM DIFFERENT MODULE --INSERT MODE***/
	if(!module_id.equalsIgnoreCase("OR")&& !mode.equals( 								CommonRepository.getCommonKeyValue( "MODE_MODIFY" )))
	{
		if(module_id.trim().equalsIgnoreCase("PH"))
		{

		 String sql_auth_level = bean.checkForNull(request.getParameter("sql_auth_level"));
		 sql_auth_level = "SELECT A.ORDER_AUTH_LEVEL ord_auth_level,A.ORDER_COSIGN_LEVEL ord_cosign_level,A.SPL_APPR_LEVEL ord_spl_appr_level,A.DISP_AUTH_REQD_YN result_auth_reqd_yn,A.REPEAT_SINGLE_CONT_ORDER_YN FROM PH_DRUG_SCHEDULE_LANG_VW A WHERE SCHEDULE_ID='"+sql_auth_level+"' AND EFF_STATUS='E' AND A.LANGUAGE_ID = '"+localeName+"' ";
		 //checked  & updateble depends on PH
		 refill_cont_order_yn_default = request.getParameter("update_refill_cont_order_yn");;
		 update_refill_cont_order_yn  = request.getParameter("update_refill_cont_order_yn");		
		 int sizeDef =0;
		 String sqlParam[]  = {};
		 if(!(sql_auth_level.equals("") && sql_auth_level.equals("null")))
		 {
			 Hashtable defVal = bean.reviewsDefault(sql_auth_level,"auth_level",sqlParam);
			 sizeDef = defVal.size();
			 if(sizeDef != 0)
			 {
				 HashMap retRec						= (HashMap)defVal.get("*A");
				 result_auth_reqd_yn_default         = (String)retRec.get("result_auth_reqd_yn1");
			 }
		 }

		 StyleDefaultSyn				   = "bottom-margin:0;display:none ;" ;  //Primary tab to be hidden
		if(tabFlag.equalsIgnoreCase("C"))
		{
			StyleDefaultTiming				   = "bottom-margin:0;display:none "  ;
			StyleDefaultCon				   = "bottom-margin:0;;"  ;//Shown by default
		}
		else
		{
			StyleDefaultTiming			   = "bottom-margin:0;"  ;//Shown by default
			StyleDefaultCon				   = "bottom-margin:0;display:none ;"  ;	 
		}
		 StyleDefaultDup				   = "bottom-margin:0;display:none ;"  ;
		 StyleDefaultexpText			   = "bottom-margin:0;display:none ;"  ;
		 StyleDefaultInstrns			   = "bottom-margin:0;display:none ;" ; //Instr's tab to be hidden

		 qty_reqd_yn_def				   = "Y" ;

		}
	}
	/***/
%>

<!-- ------------------Synonyms------------------------- -->

<table name="synonyms"  id="synonyms" width="100%" class='grid' style="<%=StyleDefaultSyn%>">
<%
		
	if(eff_status.trim().equalsIgnoreCase("D"))
	{//only in mod mode if eff_staus is disabled
		catalog_synonym_directCare_updatable	 =  "N" ;
		catalog_synonym_ancillaryDept_updatable  =  "N" ;
		effective_status_directCare_updatable	 =  "N"	;
		effective_status_ancillaryDept_updatable =  "N"	;
		explanatory_textUpdatable				 =	"N"	;
	}
%>
 <tr>
	   <td class="COLUMNHEADER" id=""><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
	   <td class="COLUMNHEADER" id=""><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
	  <td class="COLUMNHEADER" id=""><fmt:message key="Common.active.label" bundle="${common_labels}"/></td>
 </tr>
 <tr style="bottom-margin:0;display:none">
		<td class="gridData" style="bottom-margin:0;display:none" ><fmt:message key="Common.primary.label" bundle="${common_labels}"/></td>
		<td  class="gridData"><input type=text size='40' maxlength="40"
		onBlur="makeValidString(this);"
		name='catalog_synonym_primary' id='catalog_synonym_primary' value="<%=bean.getdefaultArrListValue(characteristicsRecStr,0,"catalog_synonym_primary","")%>" readonly></td>
		<td class="gridData"><input type='checkbox' value='Y'  name='effective_status_primary' id='effective_status_primary'  <%=eHISFormatter.ChkBoxChecked("y", bean.getdefaultArrListValue(characteristicsRecStr,0,"effective_status_primary",""))%> disabled ></td>
 </tr>
 <tr>
 <%
 try
 { 
 %>
	<td class="gridData"><fmt:message key="eOR.DirectCare.label" bundle="${or_labels}"/></td>
	<td class="gridData"><input type=text size='40' maxlength="40"
	onBlur="makeValidString(this);" <%=eHISFormatter.chkReturn("y",catalog_synonym_directCare_updatable,"","disabled")%>
	name='catalog_synonym_directCare' value="<%=bean.getdefaultArrListValue(characteristicsRecStr,0,"catalog_synonym_directCare","")%>"></td>
	<td class="gridData"><input type='checkbox' value='Y'
	<%=eHISFormatter.chkReturn("y",effective_status_directCare_updatable,"","disabled")%>
	name='effective_status_directCare' <%=eHISFormatter.ChkBoxChecked("y",  bean.getdefaultArrListValue(characteristicsRecStr,0,"effective_status_directCare",""))%>  ></td>
	<%
	}
	catch(Exception e)
	{
		e.printStackTrace();		
	}
	%>
 </tr>
 <tr>
		<td class="gridData"><fmt:message key="eOR.AncillaryDept.label" bundle="${or_labels}"/></td>
		<td class="gridData"><input type=text size='40' name='catalog_synonym_ancillaryDept' id='catalog_synonym_ancillaryDept' maxlength="40"
		onBlur="makeValidString(this);"
		<%=eHISFormatter.chkReturn("y",catalog_synonym_ancillaryDept_updatable,"","disabled")%>	value="<%=bean.getdefaultArrListValue(characteristicsRecStr,0,"catalog_synonym_ancillaryDept","")%>"></td>
		<td class="gridData"><input type='checkbox'name='effective_status_ancillaryDept'  value='Y'
		<%=eHISFormatter.chkReturn("y",effective_status_ancillaryDept_updatable,"","disabled")%>
		<%=eHISFormatter.ChkBoxChecked("y", bean.getdefaultArrListValue(characteristicsRecStr,0,"effective_status_ancillaryDept",""))%> ></td>
 </tr>
</table>
<!-- ----------------------Timing------------------------------------ -->
<table border="0" name="timing"  id="timing" cellpadding=3 cellspacing=0 width="100%" align="center" style="<%=StyleDefaultTiming%>">
<%	
if(eff_status.trim().equalsIgnoreCase("D"))
{//only in mod mode if eff_staus is disabled
	qty_reqd_yn_updatable					 =  "N" ;
	catalog_synonym_ancillaryDept_updatable  =  "N" ;
	taper_dose_yn_updatable					 =  "N" ;
	appl_sliding_scale_yn_updatable          =  "N" ;
	taper_up_updatable					     =  "N" ;
	none_yn_value							 = "N";
	none_yn_updatable							 = "N";
	split_dose_yn_updatable					 =  "N" ;
	update_refill_cont_order_yn					 =  "N" ;

}
%>
 <tr>
	 <td >
		 <table name="timing_dose"  id="timing_dose" cellpadding=3 cellspacing=0 width="100%" align="center" border="0">
		 <tr>
			<!--Changes Qty/dose -->
			<td width="25%" class="label"><fmt:message key="eOR.ChangeQtydose.label" bundle="${or_labels}"/></td>
			  <td class="fields" width="15%" ><input type='checkbox' <%=eHISFormatter.chkReturn("y",qty_reqd_yn_updatable,"","disabled")%>
			  <%=eHISFormatter.ChkBoxChecked("y", bean.getdefaultArrListValue(characteristicsRecStr,0,"qty_reqd_yn",qty_reqd_yn_def))%> name='qty_reqd_yn' value='Y'  onClick='parent.parent.parent.showUOM(this,"<%=order_category.trim()%>","<%=module_id.trim()%>","<%=mode%>");'></td>


              <!-- UOM -->
  			 <%if(module_id.trim().equalsIgnoreCase("PH") || order_category.trim().equalsIgnoreCase("PH") || (bean.getdefaultArrListValue(characteristicsRecStr,0,"qty_reqd_yn",qty_reqd_yn_def).equalsIgnoreCase("Y"))){
  			 	uom_style = "";
  			 }
			  %>
			  <td  id='uom_lbl_td' class="label" ><%=(uom_style.equals(""))?"UOM":""%></td>
			  <td class="fields" id='uom_td' >
			  <%if (uom_style.equals("")) {%>			 <%--<Script>alert('<%=bean.getdefaultArrListValue(characteristicsRecStr,0,"qty_uom",uom_desc)%>')</Script>--%><%--=(module_id.trim().equalsIgnoreCase("PH") || order_category.trim().equalsIgnoreCase("PH") || eff_status.trim().equalsIgnoreCase("D"))?"disabled":""--%> 
			  <%
				String qty_uom		 = bean.checkForNull(request.getParameter( "uom_code"));
				if(qty_uom.equals(""))
					qty_uom		 = bean.getdefaultArrListValue(characteristicsRecStr,0,"qty_uom","");

			%>
			  <INPUT TYPE="hidden" name="qty_uom" id="qty_uom" value="<%=qty_uom%>">
			 <INPUT TYPE="text" name="qty_uom_desc" id="qty_uom_desc"
			  size='10' onBlur='parent.parent.parent.before_show_qty_uom_window(this,qty_uom);' value='<%=bean.getdefaultArrListValue(characteristicsRecStr,0,"qty_uom_desc",uom_desc)%>'  <%=(((module_id.trim().equalsIgnoreCase("PH") || order_category.trim().equalsIgnoreCase("PH") || eff_status.trim().equalsIgnoreCase("D")) ||( mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )))) && (!(bean.getdefaultArrListValue(characteristicsRecStr,0,"qty_uom_desc",uom_desc).equals(""))))?"disabled":""%> >
			  <INPUT type="hidden" name="qty_uom_desc_temp" id="qty_uom_desc_temp" value="">
			<%if(!module_id.trim().equalsIgnoreCase("PH") && !order_category.trim().equalsIgnoreCase("PH")){%>	  
			<input type='button' name='qty_uom_button' id='qty_uom_button' class='button' <%=(mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY")) && (!(bean.getdefaultArrListValue(characteristicsRecStr,0,"qty_uom_desc",uom_desc).equals(""))))?"disabled":""%> value='?' onclick="parent.parent.parent.show_qty_uom_window(qty_uom_desc,qty_uom);" >
				 <%}%>
			  <%}%>
			</td>
 			<!-- SPLIT -->
			 <%
			//String module_id="PH";
			if(module_id.trim().equalsIgnoreCase("PH"))
			{
			%>					
			  <td class="label"><fmt:message key="eOR.Split.label" bundle="${or_labels}"/></td>
			  <td class="fields"><input type='checkbox' value='Y'
			 <%=eHISFormatter.chkReturn("y",split_dose_yn_updatable,"","disabled")%>
			  name='split_dose_yn' <%=eHISFormatter.ChkBoxChecked("y", bean.getdefaultArrListValue(characteristicsRecStr,0,"split_dose_yn",""))%>></td>
			<!-- TAPER -->
			  <%--<td class="label">Taper</td>
			  <td ><input type='checkbox' name='taper_dose_yn' id='taper_dose_yn' value='Y'
			 <%=eHISFormatter.chkReturn("y",taper_dose_yn_updatable,"","disabled")%>
			  <%=eHISFormatter.ChkBoxChecked("y", bean.getdefaultArrListValue(characteristicsRecStr,0,"taper_dose_yn",""))%> ></td>--%>
			  <td class="label"><fmt:message key="Common.Taper.label" bundle="${common_labels}"/></td>
			  <td class="label"><fmt:message key="Common.Up.label" bundle="${common_labels}"/><input type='radio' name='taper_up' id='taper_up' value='Y'
			 <%=eHISFormatter.chkReturn("y",taper_up_updatable,"","disabled")%>
			  <%=eHISFormatter.ChkBoxChecked("y", bean.getdefaultArrListValue(characteristicsRecStr,0,"taper_up",""))%> onClick='parent.parent.parent.chkTaperRadio(this);'> 				 
			  <fmt:message key="eSM.down.label" bundle="${sm_labels}"/><input type='radio' name='taper_dose_yn' id='taper_dose_yn' value='Y'
			 <%=eHISFormatter.chkReturn("y",taper_dose_yn_updatable,"","disabled")%>
			  <%=eHISFormatter.ChkBoxChecked("y", bean.getdefaultArrListValue(characteristicsRecStr,0,"taper_dose_yn",""))%> onClick='parent.parent.parent.chkTaperRadio(this);'>
			  <%
			  if(bean.getdefaultArrListValue(characteristicsRecStr,0,"taper_up","").equals("N") && (bean.getdefaultArrListValue(characteristicsRecStr,0,"taper_dose_yn","").equals("N")))
			  {
				none_yn_value="Y";			 
			  }
			  else
				none_yn_value="N";	
			%>
			<fmt:message key="Common.Both.label" bundle="${common_labels}"/><input type='radio' name='none_yn' id='none_yn'  value='<%=none_yn_value%>' <%=eHISFormatter.chkReturn("y",taper_dose_yn_updatable,"","disabled")%> <%=eHISFormatter.ChkBoxChecked("y",none_yn_value)%>    					
			onClick='parent.parent.parent.chkTaperRadio(this);'>            
             </td>
              <td class="label"><fmt:message key="Common.SlidingScale.label" bundle="${common_labels}"/></td>
			  <td class="fields"><input type='checkbox' value='Y'
			 <%=eHISFormatter.chkReturn("y",appl_sliding_scale_yn_updatable,"","disabled")%>
			  name='appl_sliding_scale_yn' <%=eHISFormatter.ChkBoxChecked("y", bean.getdefaultArrListValue(characteristicsRecStr,0,"appl_sliding_scale_yn",""))%>></td>

			 <%}else{//this in case of  Ph to adjust the screen %>
			  <td width='' ></td>
			  <%}%>
  		 <tr>
		  </table>
	  </td>
 </tr>
 <tr><td colspan></td></tr>
  <tr>
	 <td>
		 <table name="timing_orderRepeat"  id="timing_orderRepeat" border='0' cellpadding=3 cellspacing=0 width="100%" align="center" >
		 <tr>
			<%
			String params[] = {order_category.trim(),order_type_code.trim()} ;
			HashMap   freq_chk      = bean.getSqlResultParam("SQL_OR_CATALOG_FREQ_VALIDATION",params);
			String  result_applicable_yn		=
			(String)freq_chk.get("RESULT_APPLICABLE_YN1");
			String deflt_freq_yn        =
			(String)freq_chk.get("DEFLT_FREQ_YN1");
			String deflt_soft_stop_yn   =
			(String) freq_chk.get("DEFLT_SOFT_STOP_YN1");
			String deflt_cont_order_yn1  = (String)freq_chk.get("DEFLT_CONT_ORDER_YN1");
			String deflt_cont_order_yn  = "";
			//7540 Starts
			String deflt_freq_order_split_indi_yn="N";
			deflt_freq_order_split_indi_yn = bean.getdefaultArrListValue(characteristicsRecStr,0,"freq_order_split_indvi_yn",deflt_freq_order_split_indi_yn);
			//7540 Ends

			
			update_freq_yn       =(String)freq_chk.get("UPDATE_FREQ_YN1");
			update_soft_stop_yn  =(String)freq_chk.get("UPDATE_SOFT_STOP_YN1");
			update_cont_order_yn =(String)freq_chk.get("UPDATE_CONT_ORDER_YN1");

			String cont_order_yn_options = "";

			if(deflt_freq_yn.trim().equalsIgnoreCase("N"))
			{
				deflt_soft_stop_yn	 = "N"  ;
				deflt_cont_order_yn1  = "N"  ;
				update_freq_yn		 = "N"  ;
				update_soft_stop_yn  = "N"  ;
				update_cont_order_yn = "N"  ;
			}
		  // To stop the Updatable of Stop Soft && cont when frequency  is no
			//String freqChk  =  bean.getdefaultArrListValue(characteristicsRecStr,0,"freq_applicable_yn",deflt_freq_yn);
			deflt_soft_stop_yn = bean.getdefaultArrListValue(characteristicsRecStr,0,"soft_stop_yn",deflt_soft_stop_yn);
			deflt_cont_order_yn = bean.getdefaultArrListValue(characteristicsRecStr,0,"cont_order_yn",deflt_cont_order_yn);
			/* if(freqChk.equalsIgnoreCase("N")){
				  update_cont_order_yn	 = "N" ;
  				  update_soft_stop_yn	 = "N" ;
				  deflt_soft_stop_yn     = "N" ;
				  deflt_cont_order_yn    = "N" ;
			 }
			*/

			if(deflt_cont_order_yn.trim().equalsIgnoreCase("Y"))
			{
				cont_order_yn_options = "<option 	value=''>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"</option><option value='D'   " +  eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"contineous_freq_order",""),"D") + ">Explode By Day</option>";
			}
			else
			{
				cont_order_yn_options = "<option value=''>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels")+"</option>";
			}

			if(eff_status.trim().equalsIgnoreCase("D"))
			{//only in mod mode if eff_staus is disabled
				update_freq_yn								 = "N" ;
				update_soft_stop_yn							 = "N" ;
				update_cont_order_yn						 = "N" ;
			}

			if(!order_category.equals("PH"))
			{
			%><!-- THIS LINE ADDED BY CHANNAVEER B on 14/05/2010-->             
			 <td  width='25%' class="label"><fmt:message key="eOR.FrequencyRequired.label" bundle="${or_labels}"/></td>
			 <td class="fields" width="15%"><input type='checkbox' name='freq_applicable_yn' id='freq_applicable_yn' value='Y' onClick="parent.parent.parent.chkFreq(this)" <%=eHISFormatter.ChkBoxChecked("y", bean.getdefaultArrListValue(characteristicsRecStr,0,"freq_applicable_yn",deflt_freq_yn))%><%=eHISFormatter.chkReturn("y",update_freq_yn,"","disabled")%>></td>


			 <!-- Soft Stop  -->
			 <td  Width="14.9%" class="label"><fmt:message key="eOR.SoftStopforInpatients.label" bundle="${or_labels}"/></td>
			 <td class="fields" ><input type='checkbox' name='soft_stop_yn' id='soft_stop_yn'
			 value='Y' <%=eHISFormatter.ChkBoxChecked("y",deflt_soft_stop_yn )%>
			 <%=eHISFormatter.chkReturn("Y",update_soft_stop_yn,"","disabled")%>>
			 </td>
			 
			  <td  width='25%' class="label"><fmt:message key="eOR.CreateasContinuingOrder.label" bundle="${or_labels}"/></td>
			  <td class="fields" ><input type='checkbox' name='cont_order_yn' id='cont_order_yn'  value='Y' <%=eHISFormatter.ChkBoxChecked("y",deflt_cont_order_yn)%>
			  onclick="parent.parent.parent.chkCont_order_yn(this)"
			  <%=eHISFormatter.chkReturn("y",update_cont_order_yn,"","disabled")%>>
			  </td>
			  <%}%> <!-- THIS LINE ADDED BY CHANNAVEER B -->
		  </tr>
		  <!--7540 Starts  -->
		  <tr>
		  	 <td  width='25%' class="label"><fmt:message key="eOR.FreqOrderAsIndividualOrders.label" bundle="${or_labels}"/></td>
			 <td class="fields" width="15%"><input type='checkbox' name='freq_order_split_indvi_yn' id='freq_order_split_indvi_yn' value=<%=deflt_freq_order_split_indi_yn %> onClick="parent.parent.parent.chkFreqSplitIndivialOrd(this)" <%=eHISFormatter.ChkBoxChecked("y", bean.getdefaultArrListValue(characteristicsRecStr,0,"freq_order_split_indvi_yn",deflt_freq_order_split_indi_yn))%>></td>
		  </tr>
		  <!-- 7540 Ends -->
	 	 </table>
	  </td>
  </tr>

 <tr><td colspan></td></tr>


<%
		if(eff_status.trim().equalsIgnoreCase("D")){//only in mod mode if eff_staus is disabled
			contineous_freq_order_updatable = "N";
			//**indexed_yn_updatable			= "N";//moved to header frame
		}

%>

  <tr>
	  <td>
		  <table name="refills"  id="refills" border='0' cellpadding=3 cellspacing=0 width="100%" align="center" >
	       <tr>
		  <%if(!order_category.equals("PH")){ %><!-- THIS LINE  ADDED BY CHANNAVEER B on 14/05/2010 -->
			  <td  class="label" width="25%"><fmt:message key="eOR.ContinousFrequencyAction.label" bundle="${or_labels}"/></td>		 
			  <td id="contineous_freq_order_td"><SELECT   <%=eHISFormatter.chkReturn("y",contineous_freq_order_updatable,"","disabled")%> NAME="contineous_freq_order"><%=cont_order_yn_options%>
			  </SELECT></td>
			   <%}%> <!-- THIS LINE ADDED BY CHANNAVEER B -->			
			  <!--Refill-->
			  <%if(module_id.trim().equalsIgnoreCase("PH") && deflt_cont_order_yn1.equals("Y")){%>
			  <td  class="label" width="25%"><fmt:message key="eOR.AllowRefills.label" bundle="${or_labels}"/></td>
			  <td  class="fields"><input type='checkbox'  value='Y'
			  <%=eHISFormatter.chkReturn("y",update_refill_cont_order_yn,"","disabled")%>  name='refill_cont_order_yn' <%=eHISFormatter.ChkBoxChecked("y", bean.getdefaultArrListValue(characteristicsRecStr,0,"refill_cont_order_yn",refill_cont_order_yn_default))%>></td>
			  <%}else{%>
			<td  colspan=2>&nbsp;</td>	  
			  <%}%>
	       </tr>
		 </table>
	   </td>
 </tr>

 <tr><td colspan></td></tr>

<%
	if(eff_status.trim().equalsIgnoreCase("D")){//only in mod mode if eff_staus is disabled
	priority_appl_updatable                      = "N" ;
	}
	String priority_appl = bean.getdefaultArrListValue(characteristicsRecStr,0,"priority_appl","");
%>
<tr>
	 <td>
	<table name="timing_orderConsent"  id="timing_orderConsent" border='0' cellpadding=3 cellspacing=0 width="100%" align="center" >
	<tr>
	<td  class="label"  width="25%"><fmt:message key="Common.PriorityApplicable.label" bundle="${common_labels}"/></td>
	 <td class="fields" width="15%" ><SELECT <%=eHISFormatter.chkReturn("y",priority_appl_updatable,"","disabled")%> NAME="priority_appl">	<option value='' <%=(priority_appl.equals("") ? "selected" : "")%>><fmt:message key="Common.all.label" bundle="${common_labels}"/></option><option value='2' <%=(priority_appl.equals("2") ? "selected" : "")%>><fmt:message key="eOR.RoutineUrgent.label" bundle="${or_labels}"/></option><option value='1' <%=(priority_appl.equals("1") ? "selected" : "")%>><fmt:message key="Common.routine.label" bundle="${common_labels}"/></option><option value='3' <%=(priority_appl.equals("3") ? "selected" : "")%>><fmt:message key="Common.Stat.label" bundle="${common_labels}"/></option></SELECT></td>
	
	<td></td>
</tr>
</table>

 <!-------ADD -Comment Ends ----------->
	</td>
</tr>

<tr><td colspan></td></tr>
<%if(module_id.trim().equalsIgnoreCase("PH"))
{
 try
 {
 %>
<tr>
	<td>
	 <table name="timing_orderConsent"  id="timing_orderConsent" cellpadding=3 cellspacing=0 width="100%" align="center" border='0' >
	    <tr>
		 <td class="label" width='23%'><fmt:message key="eOR.DispenseAuthRequired.label" bundle="${or_labels}"/></td>
         <td  width='25%' class="fields"><input type='checkbox' name='result_auth_reqd_yn_ph' id='result_auth_reqd_yn_ph' value='Y'  onClick='assignDummys(this,result_auth_reqd_yn,"CheckBox");'
		 <%=eHISFormatter.chkReturn("y",chart_res_Updateble,"","disabled")%>
		 <%=eHISFormatter.ChkBoxChecked("y", bean.getdefaultArrListValue(characteristicsRecStr,0,"result_auth_reqd_yn",result_auth_reqd_yn_default))%>></td>
		<td colspan></td>
		 <td colspan></td>
        </tr>
     </table>
	 </td>
</tr>
<%
  }
  catch (Exception e)
  {
	e.printStackTrace();
  }			 
}
%>

</table>
<!-- ---------------------Duplicate Check-------------------------------- -->
<table border="0" name="duplicate"  id="duplicate" cellpadding=3 cellspacing=0 width="100%" align="center" style="<%=StyleDefaultDup%>">

<tr>
 <td colspan='4'></td>
	</tr>

 <tr>
	 <td colspan='4' >
	    <table name="dup_req"  id="dup_req" border='0' cellpadding=3 cellspacing=0 width="100%" align="center" >
         <tr>
			<%
				String reqDefault		    = bean.getdefaultArrListValue(characteristicsRecStr,0,"chk_for_dupl_yn","N") ;
				reqUpdatable			    = "Y" ;
				String periodDefault	    = "";
				String unitDefault		    = "";
				String optionsStatus	    = "";
				String optionsActionType	= "";
				//String activity_type = "";
				//Values when user already seleted when val when he has visted the tab
				//String optBehindSel     = "";
				//String optAheadSel      = "";
				String optionsBehindAct =
				"<option value=''>--- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" --- </option>"+
				"<option value='R'" + eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chk_for_dupl_behind_action",""),"R") +">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Reject.label","common_labels")+"</option>" +
				"<option value='W'" + eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chk_for_dupl_behind_action",""),"W") +">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Warning.label","common_labels")+"</option>" +
				"<option value='N'" + eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chk_for_dupl_behind_action",""),"N") +">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.NoCheck.label","or_labels")+"</option>";

				String optionsAheadAct	=
				"<option value=''>--- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" --- </option>"+
				"<option value='R'" + eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chk_for_dupl_ahead_action",""),"R") +">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Reject.label","common_labels")+"</option>" +
				"<option value='W'" + eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chk_for_dupl_ahead_action",""),"W") +">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Warning.label","common_labels")+"</option>" +
				"<option value='N'" + eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chk_for_dupl_ahead_action",""),"N") +">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.NoCheck.label","or_labels")+"</option>";
			//	module_id = "PH" ;

			 if(module_id.trim().equalsIgnoreCase("PH"))
			 {
				reqDefault		 = "Y" ;
				reqUpdatable	 = "N" ;
				periodDefault	 = "N";
				unitDefault		 = "N";

				optionsStatus	 = "<option value='D'"+ eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chk_for_dupl_status",""),"D") +">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ActiveGeneric.label","or_labels")+"</option>" ;

				optionsBehindAct = "<option value='W'"+ eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chk_for_dupl_behind_action",""),"W") + ">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Warn.label","common_labels")+"</option>";

				optionsAheadAct	 = "<option value='W'" + eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chk_for_dupl_ahead_action",""),"W") + ">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Warn.label","common_labels")+"</option>";

			 }
			 else
			 {
				periodDefault	 = reqDefault;
				unitDefault		 = reqDefault;
				optionsStatus	 = "<option value=''>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"</option>"+
				
				"<option value='A' "+ eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chk_for_dupl_status",""),"A") +">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ActiveOrderableStatus.label","or_labels")+"</option>"  +
				"<option value='Z'"+ eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chk_for_dupl_status",""),"Z") +">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.AnyOrderableStatus.label","or_labels")+"</option>" +
				"<option value='C' "+ eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chk_for_dupl_status",""),"C") +">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.CompletedOrderStatus.label","or_labels")+"</option>" ; // added CompletedOrderStatus for MO-CRF-20085 [IN051135]

				optionsActionType	 = "<option value=''> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"</option>"+
				"<option value='O' "+ eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"check_for_dupl_level",""),"O") +">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ByOrderable.label","or_labels")+"</option>"  +
				"<option value='A'"+ eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"check_for_dupl_level",""),"A") +">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ByActivityType.label","or_labels")+"</option>" ;  
			 }
			 
			if(eff_status.trim().equalsIgnoreCase("D"))
			{//only in mod mode if eff_staus is disabled
				reqUpdatable = "N";
				reqDefault	 = "N";
				periodDefault= "N" ;
				unitDefault	 = "N" ;
			}
			%>
			<td  class="label" width="20%" ><fmt:message key="Common.required.label" bundle="${common_labels}"/></td>
			<td class="fields" width="20%"><input type='checkbox' value='Y' onClick="parent.parent.parent.chkDuplicateReq(this)" name='chk_for_dupl_yn' id='chk_for_dupl_yn'
			<%=eHISFormatter.chkReturn("y",reqUpdatable,"","disabled")%>
			<%=eHISFormatter.ChkBoxChecked("y", bean.getdefaultArrListValue(characteristicsRecStr,0,"chk_for_dupl_yn",reqDefault))%>></td>
			
			<td  class="label"  onClick='checkBoxValidate();' nowrap><fmt:message key="eOR.OrderPriorityApplicable.label" bundle="${or_labels}"/></td>
				<td class="label" >
				<fmt:message key="Common.routine.label" bundle="${common_labels}"/><input type='checkbox' value='Y' name='routine_chk_for_dupl_yn' id='routine_chk_for_dupl_yn' <%=eHISFormatter.chkReturn("y",reqUpdatable,"","disabled")%><%=eHISFormatter.ChkBoxChecked("Y",bean.getdefaultArrListValue(characteristicsRecStr,0,"routine_chk_for_dupl_yn","N"))%>><fmt:message key="Common.urgent.label" bundle="${common_labels}"/><input type='checkbox' value='Y' name='urgent_chk_for_dupl_yn' id='urgent_chk_for_dupl_yn'<%=eHISFormatter.chkReturn("y",reqUpdatable,"","disabled")%><%=eHISFormatter.ChkBoxChecked("Y",bean.getdefaultArrListValue(characteristicsRecStr,0,"urgent_chk_for_dupl_yn","N"))%> ><fmt:message key="Common.Stat.label" bundle="${common_labels}"/><input type='checkbox' value='Y' name='stat_chk_for_dupl_yn' id='stat_chk_for_dupl_yn' <%=eHISFormatter.chkReturn("y",reqUpdatable,"","disabled")%><%=eHISFormatter.ChkBoxChecked("Y",bean.getdefaultArrListValue(characteristicsRecStr,0,"stat_chk_for_dupl_yn","N"))%> ></td>

			</tr>
			</table>
			</td>
			</tr>				 
			<tr>
			<td colspan='4'></td>
			</tr>
			<tr>
			<td >
			<table name="dup_req"  id="dup_req" border='0' cellpadding=3 cellspacing=0 width="100%" align="center" >
			<tr>
			<td  class="label" ><fmt:message key="eOR.StatusConsidered.label" bundle="${or_labels}"/></td>
			<td   class="fields"><SELECT <%=eHISFormatter.chkReturn("y",reqDefault.trim(),"","disabled")%>   NAME="chk_for_dupl_status"><%=optionsStatus%></SELECT></td>
			<td  class="label"  ><fmt:message key="Common.ActionType.label" bundle="${common_labels}"/></td>
			<td class="fields"><SELECT 	<%=eHISFormatter.chkReturn("y",reqDefault.trim(),"","disabled")%>   NAME="check_for_dupl_level" ><%=optionsActionType%></SELECT></td>
				<!-- <td align='left'><SELECT 	<%=eHISFormatter.chkReturn("y",reqDefault.trim(),"","disabled")%>   NAME="check_for_dupl_level" onChange='parent.parent.parent.chkActionType(this)'><%=optionsActionType%></SELECT></td> -->
			<!-- <td align='right' class="label" id='chk_for_dupl_activity_type_lbl_td' ><%=((bean.getdefaultArrListValue(characteristicsRecStr,0,"check_for_dupl_level","")).equals("A"))?"Activity Type":""%></td>
			<td align='left' id='chk_for_dupl_activity_type_td'><%=((bean.getdefaultArrListValue(characteristicsRecStr,0,"check_for_dupl_level","")).equals("A"))?"<input type='text' size='20' maxlength='20' onkeypress='return CheckForSpecChars(event)'  onBlur='ChangeUpperCase(this);' "+eHISFormatter.chkReturn("y",reqDefault,"","disabled")+" name='activity_type' id='activity_type' value='"+bean.getdefaultArrListValue(characteristicsRecStr,0,"activity_type","")+"'>":"<input type='hidden' size='20' maxlength='20' name='activity_type' id='activity_type' value=''>"%>
		    </td> -->
		 </tr>
		<tr>
		<td colspan='5'></td>
		</tr>
		<tr>
			<td class=' columnheader' colspan='2' width='40%' ><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
			<td class=' columnheader'<fmt:message key="Common.Period.label" bundle="${common_labels}"/></td>
			<td class=' columnheader' colspan='2'><fmt:message key="Common.Unit.label" bundle="${common_labels}"/></td>
	     </tr>
		<!--Behind Action IN024984 included onchange event -->
		<tr>
		   <td  class="label" width="20%" ><fmt:message key="eOR.BehindAction.label" bundle="${or_labels}"/></td>
			<td class="fields" width="22%"><SELECT 	<%=eHISFormatter.chkReturn("y",reqDefault,"","disabled")%> NAME="chk_for_dupl_behind_action" onchange="displayDuplicateReq(this)"><%=optionsBehindAct%></SELECT></td>
		   <%
			String  chk_for_dupl_behind_period= bean.getdefaultArrListValue(characteristicsRecStr,0,"chk_for_dupl_behind_period","");
			if(chk_for_dupl_behind_period.trim().equals("0"))
			chk_for_dupl_behind_period = "" ;
			%>
		   <td ><input type=text size='3' maxlength='3'
		   <%=eHISFormatter.chkReturn("y",periodDefault,"","disabled")%> name='chk_for_dupl_behind_period'  class="NUMBER" onblur='checkDecimal(this)' value="<%=chk_for_dupl_behind_period%>"></td>
		   <td  colspan='2'><SELECT <%=eHISFormatter.chkReturn("y",unitDefault,"","disabled")%> NAME="chk_for_dupl_behind_unit">
			<option value=''><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
			<option value='M'  <%=eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chk_for_dupl_behind_unit",""),"M")%> ><fmt:message key="Common.months.label" bundle="${common_labels}"/></option>
			<option value='W'  <%=eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chk_for_dupl_behind_unit",""),"W")%>><fmt:message key="Common.weeks.label" bundle="${common_labels}"/></option>
			<option value='D'  <%=eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chk_for_dupl_behind_unit",""),"D")%>><fmt:message key="Common.days.label" bundle="${common_labels}"/></option>
			<option value='H'  <%=eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chk_for_dupl_behind_unit",""),"H")%>><fmt:message key="Common.hours.label" bundle="${common_labels}"/></option>
			<option value='I'  <%=eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chk_for_dupl_behind_unit",""),"I")%>><fmt:message key="Common.Minutes.label" bundle="${common_labels}"/></option>
		   </SELECT></td>
		  </tr>
			<!-- Ahead Action IN024984 included onchange event-->
		  <tr>
		   <td class="label" width="20%" ><fmt:message key="eOR.AheadAction.label" bundle="${or_labels}"/></td>
			<td class="fields" width="22%"><SELECT  <%=eHISFormatter.chkReturn("y",reqDefault,"","disabled")%>
			NAME="chk_for_dupl_ahead_action" onchange="displayDuplicateReq(this)"><%=optionsAheadAct%></SELECT></td>
			<%
			String  chk_for_dupl_ahead_period= bean.getdefaultArrListValue(characteristicsRecStr,0,"chk_for_dupl_ahead_period","")	  ;
			if(chk_for_dupl_ahead_period.trim().equals("0"))
			chk_for_dupl_ahead_period = "" ;
			%>

		   <td class="fields" width="12%"><input type=text size='3' maxlength='3'
			<%=eHISFormatter.chkReturn("y",periodDefault,"","disabled")%>   name='chk_for_dupl_ahead_period' class="NUMBER" onblur='checkDecimal(this)' value="<%=chk_for_dupl_ahead_period%>"></td>

		   <td class="fields" colspan='2'><SELECT 	<%=eHISFormatter.chkReturn("y",unitDefault,"","disabled")%> NAME="chk_for_dupl_ahead_unit">
			<option value=''><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
			<option value='M' <%=eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chk_for_dupl_ahead_unit",""),"M")%>><fmt:message key="Common.months.label" bundle="${common_labels}"/></option>
			<option value='W' <%=eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chk_for_dupl_ahead_unit",""),"W")%>><fmt:message key="Common.weeks.label" bundle="${common_labels}"/></option>
			<option value='D'  <%=eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chk_for_dupl_ahead_unit",""),"D")%>><fmt:message key="Common.days.label" bundle="${common_labels}"/></option>
			<option value='H' <%=eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chk_for_dupl_ahead_unit",""),"H")%>><fmt:message key="Common.hours.label" bundle="${common_labels}"/></option>
			<option value='I' <%=eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chk_for_dupl_ahead_unit",""),"I")%>><fmt:message key="Common.Minutes.label" bundle="${common_labels}"/></option>
		   </SELECT></td>
		 </tr>
		 <% String dup_reason_reqd1 = bean.getdefaultArrListValue(characteristicsRecStr,0,"chk_for_dupl_behind_action","") ;
			String dup_reason_reqd2 = bean.getdefaultArrListValue(characteristicsRecStr,0,"chk_for_dupl_ahead_action","") ;
		 
		 	if(dup_reason_reqd1.trim().equals("W") || dup_reason_reqd2.trim().equals("W"))
		 		dupl_reason_set_style = "display:inline";
		 %>
		 <!-- Duplicate Reason IN024984-->
		<tr id="dup_reason_chk" style="<%=dupl_reason_set_style%>">
		 <td  class="label" width="20%"  ><fmt:message key="eOR.DuplicateReasonRequired.label" bundle="${or_labels}"/></td>
			<td class="fields" width="20%" ><input type='checkbox' value='Y' name='dup_reason_reqd_yn' id='dup_reason_reqd_yn' <%=eHISFormatter.chkReturn("y",reqUpdatable,"","disabled")%>
			<%=eHISFormatter.ChkBoxChecked("y", bean.getdefaultArrListValue(characteristicsRecStr,0,"dup_reason_reqd_yn",reqDefault))%>></td> <!-- modified for IN047644 -->
		</tr>
		</table>
     </td>
 </tr>
<tr>
 <td colspan='4'></td>
</tr>

</table>

<!-- ---------------------Consent/Refusal-------------------------------- -->
	<table name="consent_refusal"  id="consent_refusal" border='0' cellpadding=3 cellspacing=0 width="100%" align="center" style="<%=StyleDefaultCon%>">

 <td colspan='6'></td>

<%
  try
  {
	String consent_reqd_yn_def	   =	bean.getdefaultArrListValue(characteristicsRecStr,0,"consent_reqd_yn","N") ;
	String consent_form_list_def   =	bean.getdefaultArrListValue(characteristicsRecStr,0,"consent_form_list","F") ;
	String consent_stage_def	   =
	bean.getdefaultArrListValue(characteristicsRecStr,0,"consent_stage","") ;
	consent_stage_updatable	   = eHISFormatter.chkReturn("Y",consent_reqd_yn_def,"Y","N");
	//bean.getdefaultArrListValue(characteristicsRecStr,0,"consent_form_id","") ;	
	consent_form_id_updatable	   = eHISFormatter.chkReturn("Y",consent_reqd_yn_def,"Y","N");
	//String multi_consent_yn_def		= "N";
	String num_of_consent_req_bo	=	bean.getdefaultArrListValue(characteristicsRecStr,0,"num_of_consent_req_bo","") ;
	String num_of_consent_req_br	=	bean.getdefaultArrListValue(characteristicsRecStr,0,"num_of_consent_req_br","") ;	
	if((num_of_consent_req_bo==null || num_of_consent_req_bo.equals("")) && (consent_stage_def.equals("") || consent_stage_def.equals("A") || consent_stage_def.equals("R")))
	{
		num_of_consent_req_bo = "0";
	}
	if((num_of_consent_req_br==null || num_of_consent_req_br.equals("")) && (consent_stage_def.equals("") || consent_stage_def.equals("R") || consent_stage_def.equals("A")))
	{
		num_of_consent_req_br = "0";
	}
	String multi_consent_yn_def		= 	bean.getdefaultArrListValue(characteristicsRecStr,0,"multiple_consent_yn","N") ; 
	multi_consent_yn_def			=	multi_consent_yn_def.equals("N")?(( (!num_of_consent_req_bo.equals("") && !num_of_consent_req_br.equals("") && (Integer.parseInt(num_of_consent_req_bo) + Integer.parseInt(num_of_consent_req_br) ) >1 ) )?"Y":"N"):multi_consent_yn_def;

	multi_consent_yn_updatable	   = eHISFormatter.chkReturn("Y",consent_reqd_yn_def,"Y","N");
	consent_stage_updatable		   = eHISFormatter.chkReturn("Y",consent_reqd_yn_def,"Y","N");
	//consent_form_id_updatable	   = eHISFormatter.chkReturn("Y",consent_reqd_yn_def,"Y","N");

	if(eff_status.trim().equalsIgnoreCase("D"))//only in mod mode if eff_staus is disabled
	{
		consent_reqd_yn_updatable				= "N" ;
		multi_consent_yn_updatable				= "N" ;	
		consent_stage_updatable					= "N" ;
		consent_form_id_updatable				= "N" ;
		priority_appl_updatable                 = "N" ;
		refusalNoteText_appl_updatable          = "N" ;
	}
	if(multi_consent_yn_def.equals("Y"))
	{
		consent_form_id_updatable				= "N" ;
		consent_stage_updatable					= "N" ;
	}
%>
	<tr>
	<td  class="label" ><fmt:message key="Common.ConsentRequired.label" bundle="${common_labels}"/></td>
	<td class="fields"><input type='checkbox' value='Y' onClick="parent.parent.parent.chkConsentReq(this)"	name='consent_reqd_yn' id='consent_reqd_yn' 	 <%=eHISFormatter.ChkBoxChecked("y",consent_reqd_yn_def)%> <%=eHISFormatter.chkReturn("y",consent_reqd_yn_updatable,"","disabled")%>></td>
	<td class="label"><fmt:message key="eOR.ConsentFormList.label" bundle="${or_labels}"/></td><td class="fields"><select <%=eHISFormatter.chkReturn("y",multi_consent_yn_updatable,"","disabled")%>  name='consent_form_list' onChange="changeConsentNoteText(this);">
		<option value='F' <%=(consent_form_list_def.equals("F")? "selected":"")%>><fmt:message key="Common.Fixed.label" bundle="${common_labels}"/></option>
		<option value='V' <%=(consent_form_list_def.equals("V")? "selected":"")%>><fmt:message key="Common.Variable.label" bundle="${common_labels}"/></option>
	</select>
	 </td>
	 <!-- Code for Maximum Duration Type Options-->
<%
		//bean.setInstructionsConsentStr();
		//HashMap instructionsConsentStr   =	 bean.getInstructionsConsentStr();
	HashMap instructionsConsentStr   =	bean.getSqlResult("SQL_OR_CATALOG_CONSENT_FORMAT");
	Integer	noOfRecConsentTemp		 = (Integer)instructionsConsentStr.get("noRec");
	int noOfRecConsent               =   noOfRecConsentTemp.intValue() ;
	StringBuffer optionsConsent      =   new StringBuffer() ;
	if(noOfRecConsent != 0)
	{
		for(int i=1 ; i <= noOfRecConsent; i++)
		{
			optionsConsent.append("<option value=\""+(String)instructionsConsentStr.get("CONSENT_FORM_ID"+i)
			+  "\"   " + 		eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"consent_form_id",""),(String)instructionsConsentStr.get("CONSENT_FORM_ID"+i))+"> "+ (String)instructionsConsentStr.get("CONSENT_FORM_LABEL"+i)+"</option>");
		}
	}
%>
	<td  class="label" width='16%' ><fmt:message key="Common.ConsentStage.label" bundle="${common_labels}"/></td>
	<td class="fields" ><select <%=eHISFormatter.chkReturn("y",consent_stage_updatable,"","disabled")%>  name='consent_stage' onChange="setValues(this);">
	<option value='A' <%=(consent_stage_def.equals("A")? "selected":"")%>><fmt:message key="eOR.BeforeOrderRelease.label" bundle="${or_labels}"/></option>
	<option value='R' <%=(consent_stage_def.equals("R")? "selected":"")%>><fmt:message key="eOR.BeforeOrderRegistration.label" bundle="${or_labels}"/></option>
	</select></td>
</tr>
<tr>
	<td colspan="2" class="label">
	</td>
	<td colspan="3" class="LABELCENTER"><B><fmt:message key="eOR.NumberOfConsentRequired.label" bundle="${or_labels}"/></B></td>
	<td class="label">
	</td>
</tr>
<tr>
	<td colspan="6" class="label">
	</td>
</tr>
<tr>
	<td width='' class="label"  nowrap><fmt:message key="eOR.MultipleConsent.label" bundle="${or_labels}"/></td>
	<td class="fields"><input type='checkbox' value='Y' onClick="parent.parent.parent.enableMultiConsent(this)"	name='multiple_consent_yn' id='multiple_consent_yn' <%=eHISFormatter.ChkBoxChecked("Y",multi_consent_yn_def)%> <%=eHISFormatter.chkReturn("Y",multi_consent_yn_updatable,"","disabled")%>></td>
	<td class="label"><fmt:message key="eOR.BeforeOrderRelease.label" bundle="${or_labels}"/></td>
	<td class="fields" width='6%'> 
		<input type=text size='3' maxlength='2'
			<%=eHISFormatter.chkReturn("y",multi_consent_yn_updatable,"","disabled")%> <%=eHISFormatter.chkReturn("N",multi_consent_yn_def,"disabled","")%>  name='num_of_consent_req_bo' class="NUMBER" onblur='OrCheckNumber(this);changeValue();parent.parent.parent.linkedConsent(this,"<%=mode%>",consent_form_list);' value="<%=num_of_consent_req_bo%>">
	</td>
	<td class="label" width='18%'><fmt:message key="eOR.BeforeOrderRegistration.label" bundle="${or_labels}"/></td>
	<td class="fields">
		<input type=text size='3' maxlength='2' <%=eHISFormatter.chkReturn("N",multi_consent_yn_def,"disabled","")%> 
			<%=eHISFormatter.chkReturn("y",multi_consent_yn_updatable,"","disabled")%>   name='num_of_consent_req_br' class="NUMBER" onblur='OrCheckNumber(this);changeValue();parent.parent.parent.linkedConsent(this,"<%=mode%>",consent_form_list);' value="<%=num_of_consent_req_br%>">
	</td>
</tr>
<tr>
	<td colspan="6" class="label">
	</td>
</tr>
<tr>
	 <td class="label" width='15%' ><fmt:message key="Common.ConsentNote.label" bundle="${common_labels}"/></td>
	 <td class="fields" width='21%'><SELECT <%=eHISFormatter.chkReturn("y",consent_form_id_updatable,"","disabled")%><%=(consent_form_list_def.equals("V")? "disabled":"")%> NAME="consent_form_id">	<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option><%=optionsConsent.toString()%></SELECT></td>
	<td class="label" width='15%'><fmt:message key="eOR.RefusalNoteText.label" bundle="${or_labels}"/></td>		
	<%	
	HashMap   PopulatelistBox      = bean.getSqlResult("SQL_OR_CATALOG_REFUSAL_NOTE_TEXT");
	Integer noOfRecRefusalTemp =(Integer)PopulatelistBox.get("noRec");
	int noOfRecRefusal               =   noOfRecRefusalTemp.intValue() ;	
	StringBuffer optionsRefusal      =   new StringBuffer() ;
	if(noOfRecRefusal != 0)
	{
		for(int i=1 ; i <= noOfRecRefusal; i++)
		{
			optionsRefusal.append("<option value=\""+(String)PopulatelistBox.get("CONSENT_FORM_ID"+i)+  "\"   " +eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"refusal_form_id",""),(String)PopulatelistBox.get("CONSENT_FORM_ID"+i))+"> "+ (String)PopulatelistBox.get("CONSENT_FORM_LABEL"+i)+"</option>");
		}
	}

	%>
	<td width="15%" class="fields" colspan="3"><select name="refusal_form_id" id="refusal_form_id" <%=eHISFormatter.chkReturn("y",refusalNoteText_appl_updatable,"","disabled")%>>
	<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option><%=optionsRefusal.toString()%>
	</select></td>
		
	</tr>
		<td colspan='6'></td>
	</table><%
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	%>

<!-- ---------------------Explanatory Text-------------------------------- -->
<table border="0" name="explanatoryText" id="explanatoryText" cellpadding=3 cellspacing=0 width="100%"  align="center" style="<%=StyleDefaultexpText%>">

<%
String explanatory_text=bean.getdefaultArrListValue(characteristicsRecStr,0,"explanatory_text","");
%>
<tr >
<td  class="label" width="25%"><fmt:message key="Common.Text.label" bundle="${common_labels}"/></td>
	<td class="fields" ><textarea name="explanatory_text" value="" onBlur="makeValidString(this);SPCheckMaxLen('Explanatory Text',this,255);" size="255" maxlength="255" rows='6' cols='60' <%=eHISFormatter.chkReturn("y",explanatory_textUpdatable,"","disabled")%>><%=explanatory_text%></textarea></td></tr>
</tr>
</table>

<!-- --------------------- CHARTING----------------------------- -->

<table border="0" name="others"  id="others" cellpadding=3 cellspacing=0 width="100%" align="center"  style="<%=StyleDefaultInstrns%>">
<%				
		String auto_report_yn								 =bean.getdefaultArrListValue(characteristicsRecStr,0,"auto_report_yn","N");
		String com_on_ord_Default	="";
		if(order_category.trim().equalsIgnoreCase("CN"))
		{
			com_on_ord_Default			=  bean.getdefaultArrListValue(characteristicsRecStr,0,"complete_on_order_yn","Y") ;
		}
		else
		{
			com_on_ord_Default			=  bean.getdefaultArrListValue(characteristicsRecStr,0,"complete_on_order_yn","N") ;
		}
		String chart_res_Default			= bean.getdefaultArrListValue(characteristicsRecStr,0,"result_applicable_yn",result_applicable_yn) ;
	//	String bill_Default					= bean.getdefaultArrListValue(characteristicsRecStr,0,"bill_yn","N") ;
		String confidential_yn_Default	    = bean.getdefaultArrListValue(characteristicsRecStr,0,"confidential_yn","N") ;
		String extrlReqForm_default 		= bean.getdefaultArrListValue(characteristicsRecStr, 0, "external_requisition_yn", "N"); //68801
		String prn_regd_ord_def = bean.getdefaultArrListValue(characteristicsRecStr,0,"prn_regd_ord","N");//IN065942

	   // String athu_req_Default				= "N";
		String ord_cat_nature_Default		= "A";
		//String optionsLink					= "";
		//String discr_msr_pan_id				= "";
		//String contr_mod_id					= "";
		String contr_msr_panel_id			= "";
	   /** String scheme						= "";
		String scheme_desc					= "";**/
	   // String chart_values					= "";
		/**ArrayList proc_code_scheme = bean.getProc_code_scheme();
		for (int i = 0; i < proc_code_scheme.size();i++) {
			String [] record = (String [])proc_code_scheme.get(i);
			scheme							= record[0];
			scheme_desc						= record[1];
		}**/
		
		String chk_complete_on_order_yn = bean.getdefaultArrListValue(characteristicsRecStr,0,"complete_on_order_yn","N") ;
	//	String dependend_updatable = "Y";
		com_on_ord_Updateble			= "y" ;
		chart_res_Updateble					= "N" ;
		chart_result_type_updateble			= "Y" ;
		//discr_msr_pan_id_Updateble			= "Y" ;
		ord_cat_nature_Updateble			= "Y" ;
		bill_Updateble						= "y" ;
		//athu_req_Updateble					= "y";
		//optionsLink_Updateble				= "y";
		contr_mod_id_Updateble				= "y";
		//contr_msr_panel_id_Updateble		= "y";
		String chart_res_hidden				= "N" ;
		String bill_hidden					= "N" ;
		//String ord_cat_nature_hidden		= "N";
		//String optionsLink_hidden			= "N";
		//String discr_msr_pan_id_hidden		= "N";
		//String ord_cat_nature_Options		= "<option value='A'>Individual</option><option value='P'>Profile</option>" ;
		String chartManHMTL					=""  ;

		//if(bill_install_Yn.trim().equalsIgnoreCase("Y")){
		//bill_Default = "Y";
		 //}else{
		if(bill_install_Yn.trim().equalsIgnoreCase("N"))
		{
			bill_Updateble = "N";
			bill_hidden	   = "Y";
		}

		if(module_id.trim().equalsIgnoreCase("PH"))
		{
			com_on_ord_Updateble	 = "N";
			bill_hidden				 = "Y";
			chart_res_Default		 = "N" ;
			confidential_yn_Default  = "N";
			chart_res_Updateble      = "N"  ;
			ord_cat_nature_Updateble = "N";
			chart_res_hidden	     = "Y"  ;
			ord_cat_nature_Default   = "N" ;
		}
		else
		{ ;
		}

		if(chk_complete_on_order_yn.trim().equalsIgnoreCase("N") &&   result_applicable_yn.trim().equalsIgnoreCase("Y"))
			chart_res_Updateble = "Y" ;
		else
			chart_res_Updateble = "N" ;
			
		if(order_category.equalsIgnoreCase("RD") || order_category.equalsIgnoreCase("RX")|| order_category.equalsIgnoreCase("PC") || order_category.equalsIgnoreCase("DS"))
		{
			auto_report_style="visibility:visible";
			if(chk_complete_on_order_yn.trim().equalsIgnoreCase("Y") &&   chart_res_Default.trim().equalsIgnoreCase("Y"))
			{
				auto_report_yn="Y";
				chart_res_Updateble = "Y" ;
			} 
		}
		else
		{
			auto_report_style="visibility:hidden";
			auto_report_yn="N";
		}


		 if(chart_res_Default.trim().equalsIgnoreCase("Y"))
		 {
			ord_cat_nature_Updateble		= "Y" ;
			chart_result_type_updateble		= "Y" ;
			//discr_msr_pan_id_Updateble	    = "Y" ;
			if(!(order_category.equalsIgnoreCase("LB")
				||order_category.equalsIgnoreCase("RD") || order_category.equalsIgnoreCase("RX")) )
			{
			chartManHMTL					="<img src='../../eCommon/images/mandatory.gif' align='center'></img>";
			}
		}
		else
		{
			ord_cat_nature_Updateble		= "N"      ;
			chart_result_type_updateble		= "N" ;
			//discr_msr_pan_id_Updateble	    = "N" ;
		}
		//IN063816 starts
		String barcode_required_yn_Default	= "";
		if(order_category.trim().equalsIgnoreCase("TR") && "Y".equals(barcodeSiteSpecificYN))
		{
			barcode_required_yn_Default			=  bean.getdefaultArrListValue(characteristicsRecStr,0,"barcode_reqd_yn","N") ;
			
		}
		//IN063816 ends
	 	if(eff_status.trim().equalsIgnoreCase("D"))
		{//only in mod mode if eff_staus is disabled
			dept_only_yn_updatable						 = "N";
			com_on_ord_Updateble						 = "N";
			bill_Updateble								 = "N";
			//** image_link_id_Updateble					 = "N";//moved to header frame
			chart_res_Updateble						 = "N";
			ord_cat_nature_Updateble					 = "N";
			chart_result_type_updateble				 = "N";
			// discr_msr_pan_id_Updateble					 = "N";
			//optionsLink_Updateble					 	 = "N";
			contr_mod_id_Updateble						 = "N";
			ChartProceApplicable						 = "N";
			
			// contr_msr_panel_id_Updateble				 = "N";
			barcode_required_yn_updatable				 = "N";//IN063816
		}

		if ( mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) )) 
		{

			String term_code_param[]={bean.getdefaultArrListValue(characteristicsRecStr,0,"term_set_id",""),bean.getdefaultArrListValue(characteristicsRecStr,0,"term_code",term_code)};
			//***String term_code_param[]={"ICD10",bean.getdefaultArrListValue(characteristicsRecStr,0,"term_code",term_code)};
			HashMap term_code_map=bean.getSqlResultParam("SQL_OR_ORDER_CATALOG_TERM_DESC",term_code_param);
			String term_desc_temp=term_code_map.get("DESCRIPTION1")==null?"":(String)term_code_map.get("DESCRIPTION1");
			term_desc=bean.getdefaultArrListValue(characteristicsRecStr,0,"term_desc",term_desc_temp);	
			term_code_param=null;
			ord_cat_nature_Updateble = "N";
			if (bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type","").equals("P")) 
			{
				chart_result_type_updateble = "N";
				chart_res_Updateble = "N";
			}
		}
 %>
 <tr>
	 <td>
		 <table name="dep_com_chr_img"  id="dep_com_chr_img" cellpadding=3 border='0' cellspacing=0 width="100%" align="center" >

			<tr>
			  <!-- Department -->
			  <td   class="label" width='25%'><fmt:message key="eOR.DepartmentOnly.label" bundle="${or_labels}"/></td>
			  <td class="fields" width='25%' ><input type='checkbox' name='dept_only_yn' id='dept_only_yn' value='Y' <%=eHISFormatter.chkReturn("y",dept_only_yn_updatable,"","disabled")%>
			  <%=eHISFormatter.ChkBoxChecked("y", bean.getdefaultArrListValue(characteristicsRecStr,0,"dept_only_yn",""))%>></td>
			  <!-- Complete on Order -->
			  <td   class="label" width='25%' ><fmt:message key="eOR.CompleteonOrder.label" bundle="${or_labels}"/></td>
			  <td class="fields" width='25%' ><input type='checkbox' onClick="parent.parent.parent.chkCompleteOnOrder(this)"
			  <%=eHISFormatter.chkReturn("y",com_on_ord_Updateble,"","disabled")%><%=eHISFormatter.ChkBoxChecked("y", bean.getdefaultArrListValue(characteristicsRecStr,0,"complete_on_order_yn",com_on_ord_Default))%>
			 name='complete_on_order_yn' id='complete_on_order_yn' value='Y' ><%if(order_category.trim().equalsIgnoreCase("CN")){%><img align=center src="../../eCommon/images/mandatory.gif"></img><%}%></td></tr><tr>
	          <!-- Billable -->
			  <%
				  //bill_hidden = "Y" ;  //Billing is hidden for time being

			  if(Boolean.valueOf(eHISFormatter.chkReturn("y",bill_hidden,"false",
				"True")).booleanValue()){%>
			  <td width='25%' style="<%=eHISFormatter.chkReturn("y",bill_hidden,"Visibility:hidden","")%>" class="label" ><fmt:message key="eOR.Billable.label" bundle="${or_labels}"/></td>
			  <td  width='25%'  style="<%=eHISFormatter.chkReturn("y",bill_hidden,"Visibility:hidden","")%>"><input type='checkbox' onClick='parent.parent.parent.showChargeTypeApplicable(this)'
			  <%=eHISFormatter.chkReturn("y",bill_Updateble,"","disabled")%>
			  <%=eHISFormatter.ChkBoxChecked("y", bean.getdefaultArrListValue(characteristicsRecStr,0,"bill_yn",""))%>
			  name='bill_yn' value='Y' ></td>
			 
			 <%

			if (bean.getdefaultArrListValue(characteristicsRecStr,0,"bill_yn","").equalsIgnoreCase("Y"))
			{
  				ChargeTypeApplicable_style = "";
  			}
			   %>
		  <td width='25%' id='ChargeTypeApplicable_lbl_td'  style="<%=eHISFormatter.chkReturn("y",bill_hidden,"Visibility:hidden","")%>" class="label" ><%=(ChargeTypeApplicable_style.equals(""))?"Charge Type Applicable":""%></td>
		  <td width='25%' id='ChargeTypeApplicable_td' style="<%=eHISFormatter.chkReturn("y",bill_hidden,"Visibility:hidden","")%>" width='8%'>
		  <%if (ChargeTypeApplicable_style.equals("")) {				  if(bean.getdefaultArrListValue(characteristicsRecStr,0,"charge_type_applicable","").equals("S")){
			  single_selected="selected";
			  multi_selected="";
		  }else{
			  single_selected="";
			  multi_selected="selected";			  
		  }%>				
		   <select name="charge_type_applicable" id="charge_type_applicable"><option  value="S" <%=single_selected%> ><fmt:message key="Common.single.label" bundle="${common_labels}"/></option><option  value="M" <%=multi_selected%>><fmt:message key="eOR.Multi.label" bundle="${or_labels}"/></option></select></td> <%
		  }

			 }else{%>
			  <td colspan='4'  class="label"></td>
			  <%}%>
			  
</tr>
<!--IN063816 -->

<% if(order_category.trim().equalsIgnoreCase("TR")&&"Y".equals(barcodeSiteSpecificYN)) {%>
		<tr>
			  <td   class="label" width='25%' ><fmt:message key="eOR.BarcodeRequired.label" bundle="${or_labels}"/></td>
			  <td class="fields" width='25%' ><input type='checkbox' onClick="parent.parent.parent.chkBarcode(this)"
			  name='barcode_reqd_yn' id='barcode_reqd_yn' value='<%=barcode_required_yn_Default%>' <%=eHISFormatter.chkReturn("y",barcode_required_yn_updatable,"","disabled")%> <%=eHISFormatter.ChkBoxChecked("y", bean.getdefaultArrListValue(characteristicsRecStr,0,"barcode_reqd_yn",barcode_required_yn_Default))%> ></td>
		</tr>
<%}%>
<!--IN063816 -->
	</table>
	 <table name="dep_com_chr_img"  id="dep_com_chr_img" cellpadding=3 border='0' cellspacing=0 width="100%" align="center" >

		<!-- <tr><td colspan='8'></td></tr>
		<tr><td colspan='8'></td></tr>
		<tr><td colspan='8'></td></tr>-->
	<tr>

			  <!-- chart -->
			 <%if(Boolean.valueOf(eHISFormatter.chkReturn("y",chart_res_hidden,"false","True")).booleanValue()){ %>
			  <td  width='25%'  style="<%=eHISFormatter.chkReturn("y",chart_res_hidden,"Visibility:hidden","")%>" class="label"><fmt:message key="eOR.ChartApplicable.label" bundle="${or_labels}"/></td>
			  <td class="fields" width='25%' style="<%=eHISFormatter.chkReturn("y",chart_res_hidden,"Visibility:hidden","")%>"><input type='checkbox'  onClick="parent.parent.parent.chkChart(this)" <%=eHISFormatter.chkReturn("y",chart_res_Updateble.trim(),"","disabled")%>  <%=eHISFormatter.ChkBoxChecked("y",chart_res_Default)%>  name='result_applicable_yn' id='result_applicable_yn' value='Y' ></td>
			  <%if ((com_on_ord_Default.equals(chart_res_hidden) && com_on_ord_Default.equals("Y")))
				  auto_report_style="visibility:hidden";
			  %>
			  <td  width='25%' class="label"  name="auto_report_yn_lbl" id="auto_report_yn_lbl" ><fmt:message key="eOR.AutoReport.label" bundle="${or_labels}"/></td>			 
			  <td   width='25%' name="auto_report_yn_id" id="auto_report_yn_id" ><input type="checkbox" name="auto_report_yn" id="auto_report_yn" value="<%=auto_report_yn%>" <%=eHISFormatter.ChkBoxChecked("Y",auto_report_yn)%>  onclick="parent.parent.parent.chkAutoReport(this);"></td>

			  <%}else{%>
			   <td  width='50%' class="label" ></td>
			  <%}%>
    </tr>
	<tr>
			<%if(Boolean.valueOf(eHISFormatter.chkReturn("y",chart_res_hidden,"false","True")).booleanValue()){%>
            <td   style="<%=eHISFormatter.chkReturn("y",chart_res_hidden,"Visibility:hidden","")%>"class="label"><fmt:message key="Common.Confidential.label" bundle="${common_labels}"/></td>

			  <td    style="<%=eHISFormatter.chkReturn("y",chart_res_hidden,"Visibility:hidden","")%>"><input type='checkbox'  onClick=""
			  <%=eHISFormatter.chkReturn("y",chart_res_Updateble.trim(),"","disabled")%>
			  <%=eHISFormatter.ChkBoxChecked("y",confidential_yn_Default)%>
			  name='confidential_yn' value='Y' ></td>
				 
			  <%} else {%>
			   <td   class="label"></td>
			  <%}%>
			<!-- External Requisition form 68801-->
			  <td style="width:25%" class="label"><fmt:message key="eOR.ExternalRequisitionForm.label" bundle="${or_labels}"/></td>
			  <td style="width:25%"><input type='checkbox'  onClick="" <%=eHISFormatter.ChkBoxChecked("y",extrlReqForm_default)%>
			  name='external_requisition_yn' value='Y' ></td>
			  </td>
		</tr>
		<% 
			//IN065942, starts
			if("RX".equalsIgnoreCase(order_category.trim()))
			{
		%>
		<tr>
			<td class="label"><fmt:message key="eOR.PrintRegStatus.label" bundle="${or_labels}"/></td>
			<td><input type='checkbox' <%=eHISFormatter.ChkBoxChecked("y", bean.getdefaultArrListValue(characteristicsRecStr,0,"prn_regd_ord",""))%> name='prn_regd_ord' onClick="parent.parent.parent.chkPrnRegStatus(this)" value='Y'></td>
		</tr>
		<%
			}	
			//IN065942, ends
		%>
		  </table>
	  </td>
 </tr>
  <tr>
	 <td>
		 <table name="resulting_despensing"  id="resulting_despensing" border='0' cellpadding=0 cellspacing=0 width="100%" align="center" >
		<tr><td class='columnheader' colspan='6' align="left"><fmt:message key="eOR.ChartingCharacteristics.label" bundle="${or_labels}"/></td></tr>		
		<tr>
		    <td  class="label" width='25%'><fmt:message key="eOR.AuthorizationRequired.label" bundle="${or_labels}"/></td>
			<td  class="fields" width='25%'><input type='checkbox' name='result_auth_reqd_yn' id='result_auth_reqd_yn'  value='Y'
			<%=eHISFormatter.chkReturn("y",chart_res_Updateble,"","disabled")%>
			<%=eHISFormatter.ChkBoxChecked("y", bean.getdefaultArrListValue(characteristicsRecStr,0,"result_auth_reqd_yn",""))%>></td>
						 <!-- Nature -->
			 <td class="label" width='25%' ><fmt:message key="Common.Nature.label" bundle="${common_labels}"/></td>
			 <td class="fields" width='25%'
			 id="order_catalog_nature_id"><SELECT
			 <%=eHISFormatter.chkReturn("y",ord_cat_nature_Updateble,"","disabled")%>
			 Onchange="parent.parent.parent.chkNature(this)" NAME="order_catalog_nature">
			 <option value='A' <%=eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"order_catalog_nature",ord_cat_nature_Default),"A")%>><fmt:message key="Common.Individual.label" bundle="${common_labels}"/>
			 </option>
			 <option value='P' <%=eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"order_catalog_nature",ord_cat_nature_Default),"P")%>><fmt:message key="Common.Panel.label" bundle="${common_labels}"/>
			 </option>
			 </SELECT>
			 </td>

	  	    
		  </tr>

		 </table>
	  </td>
  </tr>
<tr>
	 <td>
		 <table name="resulting_despensing"  id="resulting_despensing" border='0' cellpadding=3 cellspacing=0 width="100%" align="center" >
		 <!-- <tr><td colspan='6'></td></tr>
		  <tr><td colspan='6'></td></tr>
		  <tr><td colspan='6'></td></tr>-->			
		  <tr >
			  
			  <td class="label"  nowrap width='25%'><fmt:message key="eOR.ChartResultType.label" bundle="${or_labels}"/></td>
			  <td  id='chart_result_type_td'  width='5%' class="fields"><SELECT name="chart_result_type" id="chart_result_type" <%=eHISFormatter.chkReturn("y",chart_result_type_updateble.trim(),"","disabled")%>
 			   onChange='parent.parent.parent.chkResultType(this);'>
				<%if (auto_report_yn.equals("N"))
				 {
				 %>
					<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option><%
				}%>
				 <option value='D' <%=eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type",""),"D")%>><fmt:message key="Common.DiscreteMeasure.label" bundle="${common_labels}"/></option>
				<%
				if (auto_report_yn.equals("N"))
				{
				%>
					 <option value='M' <%=eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type",""),"M")%>><fmt:message key="eOR.resultmatrix.label" bundle="${or_labels}"/></option>
					<option value='N' <%=eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type",""),"N")%>><fmt:message key="Common.NoteType.label" bundle="${common_labels}"/></option>
					<%
					if(!( (eCA._ca_license_rights.getKey()).equals("CABASIC")))
					{
					%>
						<option value='C' <%=eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type",""),"C")%>><fmt:message key="eOR.Charting.label" bundle="${or_labels}"/></option>
					<%
					}
					//if( (order_category.equals("TR") || order_category.equals("PC") || order_category.equals("OT"))&&  (auto_report_yn.equals("N")) )
					if( (order_category.equals("TR")  || order_category.equals("OT"))&&  (auto_report_yn.equals("N")) )
					{
						if(!order_category.equals("PC")){
					%>
						<option value='P' <%=eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type",""),"P")%>><fmt:message key="Common.Procedure.label" bundle="${common_labels}"/></option>
					<%
					}}
			  }
			//if (order_category.equals("RD") || order_category.equals("TR") ||order_category.equals("PC") || order_category.equals("OT")) {%>
			  <!-- <option value='N' <%=eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type",""),"N")%>>Note Type</option> -->
			  <%//}%>
			  <%//if (order_category.equals("RD") || order_category.equals("TR") ||order_category.equals("PC") || order_category.equals("OT")) {%>
			  <!-- <option value='C' <%=eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type",""),"C")%>><fmt:message key="eOR.Charting.label" bundle="${or_labels}"/></option> -->
			  <%//}%>
			  <%//if (order_category.equals("RD") || order_category.equals("TR") ||order_category.equals("PC") || order_category.equals("OT")) {%>
			  <!-- <option value='I' <%=eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type",""),"I")%>><fmt:message key="Common.Intravenous.label" bundle="${common_labels}"/></option> -->
			  <%//}--%>
			 <%/*if (order_category.equals("LB") && ((bean.getdefaultArrListValue(characteristicsRecStr,0,"order_catalog_nature",ord_cat_nature_Default)).equals("A"))) {*/%>
			  <!-- <option value='T' <%=eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type",""),"T")%>>Culture Test</option> -->
			  <%//}--%>
			  <%//if (order_category.equals("LB") && ((bean.getdefaultArrListValue(characteristicsRecStr,0,"order_catalog_nature",ord_cat_nature_Default)).equals("A")))
			 /* {
				  
			  	  chart_values = bean.getComboOptions("CHART_VALUES",bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type",""),"");

			  }*/
			 
			  %>
				   
			  </SELECT>
			  </td>

			  <td align="left"  id='chrtMandatory1' name='chrtMandatory1' width='15%'  nowrap ><%=chartManHMTL%></td>
			  <%
				  if ((bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type","").equalsIgnoreCase("P")))
				 {
					proc_term_set_style = "display:visible";
  				 }		

			     String display_name = "";
			     if ((bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type","").equals("P")))
				 {
			         display_name =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Procedure.label","common_labels");
			     }
				 else if ((bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type","").equals("M")))
				 {
			         display_name =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.resultmatrix.label","or_labels");
			  	 }
				 else if ((bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type","").equals("N"))) 
				 {
			         display_name = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.note.label","common_labels");
			     } 
				 else if ((bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type","").equals("C"))&&(!((eCA._ca_license_rights.getKey()).equals("CABASIC")))) 
				 {
			         display_name=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Charting.label","or_labels"); 
			     } /*else if ((bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type","").equals("I"))) {
			         display_name = "Intravenous";
			     }*/ 
				 else if ((bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type","").equals("D"))) 
				 {
			         display_name =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DiscreteMeasure.label","common_labels");
			     } 
				 else
				 { // if ((bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type","").equals("T")))
			         display_name =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DiscreteMeasure.label","common_labels");
			     }
			 %>

		  	  <td width="25%"  name='discr_msr_panel_id_lbl' id='discr_msr_panel_id_lbl'  nowrap class="label" ><%=display_name%></td>

		  	  <%
				
		  String display_text = "";
		  String onClick_text = "";

		  if ((bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type","").equals("P"))) 
		  {
			String discr_msr_panel_id_param[]={bean.getdefaultArrListValue(characteristicsRecStr,0,"proc_coding_scheme",""),bean.getdefaultArrListValue(characteristicsRecStr,0,"discr_msr_panel_id","")};
			//**String discr_msr_panel_id_param[]={"ICD10",bean.getdefaultArrListValue(characteristicsRecStr,0,"discr_msr_panel_id","")};
			HashMap discr_msr_panel_id_map=bean.getSqlResultParam("SQL_OR_ORDER_CATALOG_TERM_DESC",discr_msr_panel_id_param);
			
			String display_text_temp=discr_msr_panel_id_map.get("DESCRIPTION1")==null?"":(String)discr_msr_panel_id_map.get("DESCRIPTION1");
			//LiveIssue  - Added if condition
			if(!display_text_temp.equals(""))
			{
				display_text = display_text_temp;
			}
			else
			{
				display_text=bean.getdefaultArrListValue(characteristicsRecStr,0,"discr_msr_panel_id_desc",display_text_temp);
			}
			discr_msr_panel_id_param=null;
			//display_text =bean.getProc_desc(bean.getdefaultArrListValue(characteristicsRecStr,0,"discr_msr_panel_id",""));
			onClick_text = "onClick='parent.parent.parent.show_window(proc_coding_scheme)'";
		  }
		  else if ((bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type","").equals("M")))
		  {
			display_text = bean.getResultMatrix_desc(bean.getdefaultArrListValue(characteristicsRecStr,0,"discr_msr_panel_id",""));
			onClick_text = "onClick='parent.parent.parent.show_ResultMatrix_window()'";
		  }
		  else if ((bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type","").equals("N"))) 
		  {
			display_text = bean.getNotes_desc(bean.getdefaultArrListValue(characteristicsRecStr,0,"discr_msr_panel_id",""));
			onClick_text = "onClick='parent.parent.parent.show_notes_window()'";
		  } 
		  else if ((bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type","").equals("C"))) 
		  {
			 display_text = bean.getChart_desc(bean.getdefaultArrListValue(characteristicsRecStr,0,"discr_msr_panel_id",""));
			 onClick_text = "onClick='parent.parent.parent.show_charting_window()'";
		  } /*else if ((bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type","").equals("I"))) {
			   display_text = bean.getProc_desc(bean.getdefaultArrListValue(characteristicsRecStr,0,"discr_msr_panel_id",""));
			   onClick_text = "";
		  }*/ 
		  else if ((bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type","").equals("D"))) 
		  {
			  display_text = bean.getdefaultArrListValue(characteristicsRecStr,0,"discr_msr_panel_id_desc","");
			  onClick_text = "onClick='parent.parent.parent.showApplUserWindow()'";
		  } 
		  else 
		  { //if ((bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type","").equals("T")))				  
			  display_text = bean.getdefaultArrListValue(characteristicsRecStr,0,"discr_msr_panel_id_desc","");			   
			  onClick_text = "onClick='parent.parent.parent.showCultureTestWindow(discr_msr_panel_id_desc,discr_msr_panel_id)'";
		  }


              %>
			<td  style="<%=proc_term_set_style%>" id="proc_coding_scheme_td"  ><select name="proc_coding_scheme" id="proc_coding_scheme" noresize ><option value="" onChange="parent.parent.parent.onChangeProcCodingScheme();">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
			<%
			TermSetID=bean.populateTermSetID();
			for(int k=0;k<TermSetID.size(); k++)
			{
				record = (String [])TermSetID.get(k);
				%>	
				<option value="<%=record[0]%>" <%=eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"term_set_id",""),record[0])%> ><%=record[1]%></option>  
				<%
			}
			TermSetID=null;
			record=null;
			%>
			</select>
			</td>
			<td id='discr_msr_panel_id_td' class='label' width="20%"><input type='text'  name='discr_msr_panel_id_desc' id='discr_msr_panel_id_desc' onfocus="javascript:blur();"  value='<%=display_text%>' size=23 maxlength=30 >
				<input type='hidden'  name='discr_msr_panel_id' id='discr_msr_panel_id' value='<%=bean.getdefaultArrListValue(characteristicsRecStr,0,"discr_msr_panel_id","")%>'>
				<%
				if (!(bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type","").equals("I"))) 
				{
				%>
					<input type='button' name='appl_button' id='appl_button' class='button'<%=eHISFormatter.chkReturn("y",chart_res_Updateble,"","disabled")%> value='?'<%=onClick_text%>></td>		
					<td name='chrtMandatory2' id='chrtMandatory2'  width="15%"><%=chartManHMTL%></td>
				<%
				}
				else 
				{
				%>
					<Input name='appl_button' id='appl_button' type='hidden' value=''>  </td>					 
					<td  id='chrtMandatory2'><%=chartManHMTL%></td>
				<%
				}
				%>			 
		  </tr>  		  
		 </table>
	  </td>
  </tr>
	<%
		String style  = "";
		if(module_id.trim().equalsIgnoreCase("OR"))
		{ //hide in case if called from OR
			style = "bottom-margin:0;display:none";
			module_id ="";
		}

		if(mode.trim().equalsIgnoreCase("2"))
		{
			style = "";
			contr_mod_id_Updateble = "N";
		}

		 module_id= bean.getdefaultArrListValue(characteristicsRecStr,0,"contr_mod_id",module_id);

		String  contr_msr_panel_desc =  "";
		contr_msr_panel_id =bean.getdefaultArrListValue(characteristicsRecStr,0,"contr_msr_panel_id","");
		contr_msr_panel_desc = 	 contr_msr_panel_id ;
	%>
  <tr>
	  <td>
		  <table name="mod_drug"  id="mod_drug" border='0' cellpadding=3 cellspacing=0 width="100%" align="center"  style="<%=style%>" >
	       <tr>
			  <td  width='25%' class="label"><fmt:message key="Common.ModuleId.label" bundle="${common_labels}"/></td>
			  <td width='25%'><input type="text"  size=2
				maxlength=2 name="contr_mod_id" id="contr_mod_id" value="<%=module_id%>" <%=eHISFormatter.chkReturn("y",contr_mod_id_Updateble,"",
			 "disabled")%>> </td>

			  <td  class="label" width='25%'><fmt:message key="eOR.MeasureDrugName.label" bundle="${or_labels}"/></td>
			  <td  width="25%" class="fields"><input type='text'  name='contr_msr_panel_desc' id='contr_msr_panel_desc' value='<%=contr_msr_panel_desc%>' size=20 maxlength=30  disabled></td>
			  <input type="hidden" name="contr_msr_panel_id" id="contr_msr_panel_id" value="<%=contr_msr_panel_id%>"></tr>
		 </table>
	   </td>
 </tr>
	
			  <tr><td colspan='6'></td></tr>
  <tr>
	 <td>
	  <table name="resulting_despensing"  id="resulting_despensing" border='0'  cellpadding=3 cellspacing=0 width="100%" align="center" >

	  <tr><td class='columnheader' colspan='6' align="left"><fmt:message key="eOR.ProcedureLink.label" bundle="${or_labels}"/></th><tr>
		<tr><td colspan='6'></td></tr>
		<tr >
		<td class='label' width='25%'><fmt:message key="Common.Applicable.label" bundle="${common_labels}"/></td>
		 <input type="hidden" name="ChartProceApplicable" id="ChartProceApplicable" value="<%=ChartProceApplicable%>">
		<td width='25%' name="proc_link_applicable_td" id="proc_link_applicable_td" >
		<select name="proc_link_applicable" id="proc_link_applicable" <%=eHISFormatter.disabled(bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type",""),"P")%> <%=eHISFormatter.chkReturn("y",chart_res_Updateble.trim(),"","disabled")%> onChange="parent.parent.parent.showProc_link_resulting_option(this);">
			
		  <option value='X' <%=eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"proc_link_applicable",""),"X")%>><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option>
<!-- 		  <option value='C' >AutoLink to Catalog Code</option>
 -->		<option value='P' <%=eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"proc_link_applicable",""),"P")%> ><fmt:message key="eOR.AutoLink.label" bundle="${or_labels}"/></option>
		  <option value='R' <%=eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"proc_link_applicable",""),"R")%>><fmt:message key="eOR.manuallink.label" bundle="${or_labels}"/></option>
			  
		  </select>
		 </td>
	      <%
			  if (bean.getdefaultArrListValue(characteristicsRecStr,0,"proc_link_applicable","").equalsIgnoreCase("R"))
				{
					
  					proc_link_resulting_option_style = "visibility:visible";

  				}
				if ( (bean.getdefaultArrListValue(characteristicsRecStr,0,"proc_link_applicable","").equalsIgnoreCase("P") || bean.getdefaultArrListValue(characteristicsRecStr,0,"proc_link_applicable","").equalsIgnoreCase("C")) )
				{
					
  					term_set_style = "visibility:visible";

  				}		
		  
		  %>	 
		<td  class='label' width='25%' name="proc_link_resulting_option_lbl" id="proc_link_resulting_option_lbl"  style='<%=proc_link_resulting_option_style%>'><fmt:message key="eOR.Atresulting.label" bundle="${or_labels}"/></td>
		  <td align='left' style='<%=proc_link_resulting_option_style%>' width='30%'>
		  <select name="proc_link_resulting_option" id="proc_link_resulting_option">
		  <option value='M' <%=eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"proc_link_resulting_option",""),"M")%>><fmt:message key="Common.Mandatory.label" bundle="${common_labels}"/></option>
		  <option value='O' <%=eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"proc_link_resulting_option",""),"O")%>><fmt:message key="Common.Optional.label" bundle="${common_labels}"/></option>
<!-- 		  <option value='' <%=eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"proc_link_resulting_option",""),"")%>>Not Applicable</option>
 -->		  </select>
		  </td> 
		</tr>
 		<tr ><td colspan='6' ></td></tr>
		
		<tr  >			
		<td width='25%' class='label' name='term_set_id_lbl' id='term_set_id_lbl' style='<%=term_set_style%>'  width='20%' ><fmt:message key="Common.TermSetID.label" bundle="${common_labels}"/></td>
		<td width='25%' name="term_set_id_td" id="term_set_id_td"  style='<%=term_set_style%>' class="fields"><select name="term_set_id" id="term_set_id" onChange="parent.parent.parent.onChangeTermSetID();" >
		<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
		<%
		
			TermSetID=bean.populateTermSetID();
			for(int k=0;k<TermSetID.size(); k++){
			record = (String [])TermSetID.get(k);
%>	
			<option value="<%=record[0]%>" <%=eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"term_set_id",""),record[0])%> ><%=record[1]%></option>  
<%
			}TermSetID=null;
			record=null;
%>
		</select><img align=center src="../../eCommon/images/mandatory.gif"></img>
		
		</td>

		<td class='label' width='23%' id='term_code_lbl'  style='<%=term_set_style%>'><fmt:message key="Common.TermCode.label" bundle="${common_labels}"/></td>
		<td width='25%' id='term_code_td' style ='<%=term_set_style%>' class="fields">
		<input type='hidden' name='term_code' id='term_code' value="<%=bean.getdefaultArrListValue(characteristicsRecStr,0,"term_code","")%>">
			
		<input type='text' width='18%' name='term_desc' id='term_desc' size='28' maxlength='30'
		<%//onBlur="parent.parent.parent.before_show_term_code_window(this,term_code);" %>
		onBlur="parent.parent.parent.before_show_term_code_window(term_set_id);"  value="<%=term_desc%>">
		<input type='button' class='button' name='term_code_button' id='term_code_button' value='?' <%// onClick="parent.parent.parent.show_term_code_window(term_desc,term_code);"%>
		onClick="parent.parent.parent.show_term_code_window(term_set_id);">
		<img src="../../eCommon/images/mandatory.gif"></img><input type="hidden" name="temp_term_desc" id="temp_term_desc" value="">
		</td> 
 	</tr> 
	  </table>
	  </td>
	  </tr>
<!--IN068314 Starts-->	  
<% if(isfppapplicable)
{
	%>
<TR>
	<td>
	<table border='0'  cellpadding=3 cellspacing=0 width="100%" align="center" >
	<tr><td class='columnheader' colspan='3' align="left"><fmt:message key="eOR.FPPDETAILS.label" bundle="${or_labels}"/></th><tr>
	<tr>
	  <td  class="label" ><fmt:message key="eOR.NONFPPPATIENT.label" bundle="${or_labels}"/></td>
	  <td  class="label"  width='25%'><input type="radio" name="fpp_yn" id="fpp_yn" value="N" width='25%' onclick="loadfppCategory(this)" <%=eHISFormatter.ChkBoxChecked("N", fpp_yn)%> <%=FppModificaion%> /></td>
	  <td  class="label"  width='50%'>&nbsp;</td>
	</tr>
	<tr>
	  <td  class="label" width='25%' ><fmt:message key="eOR.FPPPATIENT.label" bundle="${or_labels}"/> </td>
	  <td  class="label" width='50%' ><input type="radio" name="fpp_yn" id="fpp_yn" value="Y" onclick="loadfppCategory(this)" <%=eHISFormatter.ChkBoxChecked("Y", fpp_yn)%> <%=FppModificaion%> /> </td>
	   <td  class="label"  width='50%'>&nbsp;</td>
	</tr>
	<tr>
	  <td width='25%' id='fppCategoryApplicable_lbl_td'  style="<%=eHISFormatter.chkReturn("N",fpp_yn,"Visibility:hidden","")%>" class="label" ><%=(fppCategoryApplicable_style.equals(""))?"FPP Applicable Category":""%></td>
	  <TD width='25%' id='fppCategoryApplicable_td' class="label" style="<%=eHISFormatter.chkReturn("N",fpp_yn,"Visibility:hidden","")%>">
	   <select name="fpp_category" id="fpp_category">
		   <option  value="S" <%=eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"fpp_category",""),"S")%>><fmt:message key="eOR.Simple.label" bundle="${or_labels}"/></option>
		   <option  value="M" <%=eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"fpp_category",""),"M")%>><fmt:message key="eOR.Medium.label" bundle="${or_labels}"/></option>
		   <option  value="C" <%=eHISFormatter.select(bean.getdefaultArrListValue(characteristicsRecStr,0,"fpp_category",""),"C")%>><fmt:message key="eOR.Complex.label" bundle="${or_labels}"/></option>
	   </select>
	   </td>
	    <td  class="label"  width='50%'>&nbsp;</td>
	</tr>
	</table>
	</td> 
</TR>
<%
}%>
<!--IN068314 Ends-->
 

</table>
<!-- --------------------- CHARTING----------------------------- -->

<!-- ---------------------The  End-------------------------------- -->
	<input type="hidden" name="notes_sql" id="notes_sql" 	value="<%=OrRepository.getOrKeyValue("SQL_OR_CATALOG_NOTES_SELECT")%>">
	<input type="hidden" name="sql_or_catalog_discrete_auto_report_yn" id="sql_or_catalog_discrete_auto_report_yn" 	value="<%=OrRepository.getOrKeyValue("SQL_OR_CATALOG_DISCRETE_AUTO_REPORT_YN")%>">
	
	<input type="hidden" name="sql_or_catalog_discrete_profile" id="sql_or_catalog_discrete_profile" 	value="<%=OrRepository.getOrKeyValue("sql_or_catalog_discrete_profile")%>">

	<input type="hidden" name="sql_or_catalog_culture_test_atomic" id="sql_or_catalog_culture_test_atomic" 	value="<%=OrRepository.getOrKeyValue("SQL_OR_CATALOG_CULTURE_TEST_ATOMIC")%>">

	<input type="hidden" name="ResultTemplate_sql" id="ResultTemplate_sql" 	value="<%=OrRepository.getOrKeyValue("SQL_OR_CATALOG_RESULT_TEMPLATE_SELECT")%>">

	<input type="hidden" name="ResultMatrix_sql" id="ResultMatrix_sql" 	value="<%=OrRepository.getOrKeyValue("SQL_OR_CATALOG_RESULT_MATRIX_SELECT")%>">
	<input type="hidden" name="sql_or_catalog_discrete_atomic" id="sql_or_catalog_discrete_atomic" 	value="<%=OrRepository.getOrKeyValue("sql_or_catalog_discrete_atomic")%>">
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="qry_str" id="qry_str" value="<%=request.getQueryString()%>">
	<input type="hidden" name="bill_install_Yn" id="bill_install_Yn" value="<%=bill_install_Yn%>">
	<input type="hidden" name="order_category" id="order_category" value="<%=order_category%>">
	<input type="hidden" name="result_applicable_yn_db" id="result_applicable_yn_db" value="<%=result_applicable_yn%>">
	<input type="hidden" name="tabType" id="tabType" value="C">

	<input type="hidden" name="qty_uom_sql" id="qty_uom_sql" 	value="<%=OrRepository.getOrKeyValue("SQL_OR_CATALOG_QTY_UOM_SELECT")%>">

	<input type="hidden" name="chart_sql" id="chart_sql" 	value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_CATALOG_CHARTING_LOOKUP")%>">

	<input type="hidden" name="update_soft_stop_yn_db" id="update_soft_stop_yn_db" 	value='<%=(String)freq_chk.get("UPDATE_SOFT_STOP_YN1")%>'>
	<input type="hidden" name="update_cont_order_yn_db" id="update_cont_order_yn_db" 	value='<%=(String)freq_chk.get("UPDATE_CONT_ORDER_YN1")%>'>
	
	

	

	
<%if ( mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) )){

	%>
<script>
var eff_status="<%=eff_status%>";	
var flag=true;
//var order_category=document.detailLowerForm.order_category.value;
var order_category=document.getElementById('order_category').value;
if(order_category == "RD" || order_category == "RX" || order_category == "PC" || order_category == "DS")	
	{
		//parent.parent.parent.chkCompleteOnOrder(document.detailLowerForm.complete_on_order_yn);
		if((document.detailLowerForm.complete_on_order_yn.checked==true &&  document.detailLowerForm.result_applicable_yn.checked==true) || (document.detailLowerForm.complete_on_order_yn.checked==false &&  document.detailLowerForm.result_applicable_yn.checked==true))
		flag=false;
		
		
	}else{
	
		//flag=document.detailLowerForm.complete_on_order_yn.checked;
		flag=document.getElementById('complete_on_order_yn').checked;
	}

if(!flag){
	
	//if(document.detailLowerForm.result_applicable_yn!=null){
		if(document.getElementById('result_applicable_yn')!=null){
		//document.detailLowerForm.result_applicable_yn.value='<%=chart_res_Default%>';
		document.getElementById('result_applicable_yn').value='<%=chart_res_Default%>';
		//parent.parent.parent.chkChart(document.detailLowerForm.result_applicable_yn);
		parent.parent.parent.chkChart(document.getElementById('result_applicable_yn'));
	}
	//if(document.detailLowerForm.auto_report_yn !=null){
		if(document.getElementById('auto_report_yn') !=null){
		var auto_report_yn='<%=auto_report_yn%>';
		//alert("auto_report_yn="+auto_report_yn);
		//document.detailLowerForm.auto_report_yn.value=auto_report_yn;
		document.getElementById('auto_report_yn').value=auto_report_yn;
		if (auto_report_yn=="Y")
			//document.detailLowerForm.auto_report_yn.checked=true;
		    document.getElementById('auto_report_yn').checked=true;
		else
			//document.detailLowerForm.auto_report_yn.checked=false;
			document.getElementById('auto_report_yn').checked=false;
		//parent.parent.parent.chkAutoReport(document.detailLowerForm.auto_report_yn);
		parent.parent.parent.chkAutoReport(document.getElementById('auto_report_yn'));
	}
	document.detailLowerForm.order_catalog_nature.value='<%=bean.getdefaultArrListValue(characteristicsRecStr,0,"order_catalog_nature","ord_cat_nature_Default")%>';
	document.detailLowerForm.order_catalog_nature.disabled=true;
	if(document.detailLowerForm.result_applicable_yn!=null && document.detailLowerForm.result_applicable_yn.checked ==true){
	parent.parent.parent.chkNature(document.detailLowerForm.order_catalog_nature);
	document.detailLowerForm.chart_result_type.value='<%=bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type","")%>';
	parent.parent.parent.chkResultType(document.detailLowerForm.chart_result_type);
	
	

	document.detailLowerForm.proc_coding_scheme.value='<%=bean.getdefaultArrListValue(characteristicsRecStr,0,"proc_coding_scheme","")%>';
	document.detailLowerForm.proc_link_applicable.value='<%=bean.getdefaultArrListValue(characteristicsRecStr,0,"proc_link_applicable","X")%>';
	document.detailLowerForm.proc_link_resulting_option.value='<%=bean.getdefaultArrListValue(characteristicsRecStr,0,"proc_link_resulting_option","M")%>';
	if(document.detailLowerForm.chart_result_type.value=='P'){
		document.detailLowerForm.proc_link_applicable.disabled=true;		
	}
	parent.parent.parent.showProc_link_resulting_option(document.detailLowerForm.proc_link_applicable);
    document.detailLowerForm.term_set_id.value='<%=bean.getdefaultArrListValue(characteristicsRecStr,0,"term_set_id","")%>';
	document.detailLowerForm.term_code.value='<%=bean.getdefaultArrListValue(characteristicsRecStr,0,"term_code","")%>';
	var temp='<%=bean.getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type","")%>';
    document.detailLowerForm.term_desc.value='<%=term_desc%>';	
	if(order_category=="PC" )	
	{
		if(temp!= "P")
		{
			document.detailLowerForm.discr_msr_panel_id_lbl.innerText = '<%=display_name%>';
			document.detailLowerForm.discr_msr_panel_id_desc.value='<%=display_text%>';
			
			//document.getElementById("discr_msr_panel_id_lbl").innerText = '<%=display_name%>';
			//document.getElementById("discr_msr_panel_id_desc").value='<%=display_text%>';
		}
	}
	else
	{
		document.getElementById('discr_msr_panel_id_lbl').innerText = '<%=display_name%>';
		document.getElementById('discr_msr_panel_id_desc').value='<%=display_text%>'; 
		
		//document.detailLowerForm.discr_msr_panel_id_lbl.innerText = '<%=display_name%>';
		//document.detailLowerForm.discr_msr_panel_id_desc.value='<%=display_text%>';
	}
	
    document.detailLowerForm.discr_msr_panel_id.value='<%=bean.getdefaultArrListValue(characteristicsRecStr,0,"discr_msr_panel_id","")%>';
	if(document.detailLowerForm.chart_result_type.value !="" && document.detailLowerForm.discr_msr_panel_id.value !=""){
		document.detailLowerForm.chart_result_type.disabled=true;
		document.detailLowerForm.discr_msr_panel_id_desc.disabled=true;
		document.detailLowerForm.appl_button.disabled=true;
		if(document.detailLowerForm.chart_result_type.value=="P"){
			document.detailLowerForm.proc_coding_scheme.disabled=true;			
		}
	}
	if(document.detailLowerForm.ChartProceApplicable.value == "N"){
		document.detailLowerForm.proc_link_applicable.disabled = true;
		document.detailLowerForm.appl_button.disabled = true;
		
	}
}

}else{	
	if(order_category == "RD" || order_category == "RX" || order_category == "PC" || order_category == "DS")
		parent.parent.parent.chkCompleteOnOrder(document.detailLowerForm.complete_on_order_yn);
	else{
	document.detailLowerForm.result_applicable_yn.checked		    = false;
	document.detailLowerForm.result_applicable_yn.disabled		= true;
	alert(" Inside Other Details Setup Form 1945 document.detailLowerForm.result_applicable_yn : "+document.detailLowerForm.result_applicable_yn);
	parent.parent.parent.chkChart(document.detailLowerForm.result_applicable_yn);
	}
		
}
//document.detailLowerForm.order_catalog_nature.disabled=true;
		if(eff_status=="D"){
			if(document.detailLowerForm.charge_type_applicable!=null)
				document.detailLowerForm.charge_type_applicable.disabled=true;
			if(document.detailLowerForm.confidential_yn!=null)
				document.detailLowerForm.confidential_yn.disabled=true;
			document.detailLowerForm.result_auth_reqd_yn.disabled=true;
			if(document.detailLowerForm.auto_report_yn !=null)
				document.detailLowerForm.auto_report_yn.disabled=true;
			if(document.detailLowerForm.result_applicable_yn!=null){
				document.detailLowerForm.order_catalog_nature.disabled=true;
				document.detailLowerForm.chart_result_type.disabled=true;
				document.detailLowerForm.proc_coding_scheme.disabled=true;
				document.detailLowerForm.proc_link_applicable.disabled=true;
				document.detailLowerForm.proc_link_resulting_option.disabled=true;
				document.detailLowerForm.term_set_id.disabled=true;
				document.detailLowerForm.term_desc.disabled=true;
				document.detailLowerForm.term_code_button.disabled=true;
				document.detailLowerForm.discr_msr_panel_id_desc.disabled=true;
				if(document.detailLowerForm.appl_button!=null)
				document.detailLowerForm.appl_button.disabled=true;
				}
		}

</script>
<%}%>
	

 </form>

<%
	putObjectInBean(bean_id,bean,request);
}catch(Exception e){
	e.printStackTrace();

}
%>
</body>
</html>

