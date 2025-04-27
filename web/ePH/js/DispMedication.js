/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/* 
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			Description
--------------------------------------------------------------------------------------------------------------
?				100					?           created 
04/11/2017      IN063877   		Devindra      UnusedLocal variable
04/13/2017      KDAH-CRF-0338   Devindra      Inclusion of Bed No in the Fill and Deliver screen in Dispense Medication.
13/08/2019      IN070605		 Devindra           MMS-KH-CRF-0028
06/02/2020		IN071362                Manickavasagam J                       AAKH-CRF-0117
12/2/2020		72188		 Shazana 				SKR-SCF-1310
23/4/2020		72656		Shazana					SKR-SCF-1319 
20/11/2020		7979		Shazana					SKR-SCF-1485
17/02/2021		TFS:14131	        Manickavasagam J			     MMS-KH-CRF-0038
7/7/2021		TFS:9495	Shazana					MOHE-CRF-0026.1
10/08/2021		TFS-22325	   Prabha            MOHE-SCF-0132
19/11/2022						Sushant Tambe	ML-MMOH-CRF-1666
29/11/2023						Sushant Tambe	MMS-DM-CRF-0228
10-10-23						Himanshu Saxena	   MMS-DM-CRF-0232
03-01-24						Himanshu Saxena   GHL-CRF-0672
15-01-24                        Keerti Chaudhary  ML-MMOH-CRF-2042-US001
13-09-2024		66931			Gunasekhar									PH-GHL-CRF-0687-US001/01-Fill/Allocation Sheet-Priority

---------------------------------------------------------------------------------------------------------------
*/ 
var function_id = "" ;
var message		= "" ;
var flag		= "" ;
var result		= false ;
var selected_ws_report_1="";
var selected_ws_report_2="";
var token_valid_flag = false;
var pswd_flag="N";
var current_facility="C";
var user_id="";
var locked_date_time="";
var fill_proc_id1="";
//Code Added For Bru-HIMS-CRF-075 Start
var chkBMSTab ="";
var chkBalanceTab ="";
var toolBarString = "";//Added AMS-CRF-0068.1 [IN:050333]
var chk_req_flag = "false"; //Added AMS-CRF-0068.1 [IN:050333]
//Code Added For Bru-HIMS-CRF-075 End
var dispNos="";//added for th-kw-crf-0020.3
// This method is for Verify Order Transaction

async function showLoginWindowForVerifyPres(disp_locn_details,function_id, homepage, store_code, disp_locn_catg){//Added  homepage, store_code for Bru-HIMS-CRF-073 [IN:029939]
	var dialogHeight= "250px" ;
	var dialogWidth	= "500px" ;
	//var dialogHeight= "18" ;
	//var dialogWidth	= "32" ;
	var dialogTop = "195" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	if(homepage!='Y' || store_code=='' || store_code == undefined || disp_locn_catg=='' || disp_locn_catg == undefined ){ //if condition and else block Added for Bru-HIMS-CRF-073.1 [IN:047222]
		retVal =await window.showModalDialog("../../ePH/jsp/VerifyPresLogin.jsp?disp_locn_details="+encodeURIComponent(disp_locn_details,'UTF-8')+"&function_id="+function_id+"&homepage="+homepage+"&store_code="+store_code,arguments,features);
		if(retVal=="GOHOME" || retVal == undefined){
			//history.go(-1);
			if(homepage!='Y') //Added for Bru-HIMS-CRF-073 [IN:029939]
				window.location.href = '../../eCommon/jsp/dmenu.jsp';
			else{
				//window.close();
				parent.CommonToolbar.ShowMenu.click();
				parent.CommonToolbar.unLoadTitleName();
				const dialogTag = parent.document.getElementById("dialog_tag");
				dialogTag.close();
			}
		}
		else{
			//window.close();
			/*const dialogTag = parent.parent.document.getElementById("dialog_tag");
			dialogTag.close();*/
			document.location.href ="../../ePH/jsp/DispMedicationFrameset.jsp?function_id="+function_id;
			
		}
	}
	else{  //added for Bru-HIMS-CRF-073.1 [IN:047222] -start
		var retVal = "";
		var bean_id   = "DispMedicationBean";
		var bean_name = "ePH.DispMedicationBean";
		//var xmlDoc  = new ActiveXObject( "Microsoft.XMLDom" ) ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr += " disp_locn_catg=\"" + disp_locn_catg + "\"";
		xmlStr += " disp_locn_code=\"" + store_code + "\"";
		xmlStr += " bean_id=\""+bean_id+"\"";
		xmlStr += " bean_name=\""+bean_name+"\"";
		xmlStr += " homepage=\""+homepage+"\"";
		xmlStr +=" /></root>";
		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	xmlHttp.open("POST","DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=getDispStageverify",false);
		xmlHttp.send( xmlDoc ) ;
		eval(xmlHttp.responseText);
		if(retVal == 'GOQUERYCRITERIA')
			document.location.href ="../../ePH/jsp/DispMedicationFrameset.jsp?function_id="+function_id+"&disp_locn_catg="+disp_locn_catg+"&homepage="+homepage;
		else{
			if(retVal == 'PH_INVALID_TOKEN_SERIES_FOR_WORK_STATION')
				alert(getMessage('PH_INVALID_TOKEN_SERIES_FOR_WORK_STATION',"PH"));
			else //(retVal == 'PH_VERIFICATION_NOT_APPLI')
				alert(getMessage('PH_VERIFICATION_NOT_APPLI',"PH"));
				parent.CommonToolbar.ShowMenu.click();
				parent.CommonToolbar.unLoadTitleName();
		}
	} //added for Bru-HIMS-CRF-073.1 [IN:047222] -end
}

// Function parameter changed By Shaiju for UAT 3
//function showLoginWindow(disp_locn_details,function_id){
async function showLoginWindow(function_id, homepage, store_code, disp_locn_catg, disp_stage ){
	if(homepage!='Y'){ // if condition and else block added for Bru-HIMS-CRF-073.1 [IN:047222]
		var dialogHeight= "250px" ;
		var dialogWidth	= "500px" ;
		var dialogTop = "195" ;
		var center = "1" ;
		var status="no";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop+";scroll:no";
		var arguments	= "" ;
		// Commented  By Shaiju for UAT 3
		//window.showModalDialog("../../ePH/jsp/DispMedicationLogin.jsp?disp_locn_details="+encodeURIComponent(disp_locn_details)+"&function_id="+function_id,arguments,features);
		retVal =await window.showModalDialog("../../ePH/jsp/DispMedicationLogin.jsp?function_id="+function_id+"&homepage="+homepage+"&store_code="+store_code,arguments,features);
		if(retVal=="GOHOME" || retVal == undefined){
			//history.go(-1);
				window.location.href = '../../eCommon/jsp/dmenu.jsp';
		}
		else{
			window.close();
			//const dialogTag = parent.parent.document.getElementById("dialog_tag");
			//dialogTag.close();
			document.location.href ="../../ePH/jsp/DispMedicationFrameset.jsp?function_id="+function_id;
		}
	}
	else{ //added for Bru-HIMS-CRF-073.1 [IN:047222] -start
		var retVal = "";
		var bean_id   = "DispMedicationBean";
		var bean_name = "ePH.DispMedicationBean";
		//var xmlDoc  = new ActiveXObject( "Microsoft.XMLDom" ) ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr += " disp_locn_catg=\"" + disp_locn_catg + "\"";
		xmlStr += " disp_locn_code=\"" + store_code + "\"";
		xmlStr += " disp_stage=\"" + disp_stage + "\""; 
		xmlStr += " bean_id=\""+bean_id+"\"";
		xmlStr += " bean_name=\""+bean_name+"\"";
		xmlStr += " homepage=\""+homepage+"\"";
		xmlStr +=" /></root>";
		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	xmlHttp.open("POST","DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=getDispStage",false);
		xmlHttp.send( xmlDoc ) ;
		eval(xmlHttp.responseText);
		if(retVal == 'GOQUERYCRITERIA')
			document.location.href ="../../ePH/jsp/DispMedicationFrameset.jsp?function_id="+function_id+"&disp_locn_catg="+disp_locn_catg+"&homepage="+homepage;
		else{
			if(retVal == 'PH_INVALID_TOKEN_SERIES_FOR_WORK_STATION')
				alert(getMessage('PH_INVALID_TOKEN_SERIES_FOR_WORK_STATION',"PH"));
			else //(retVal == 'PH_VERIFICATION_NOT_APPLI')
				alert(getMessage('ACCESS_DENIED',"PH"));
			parent.CommonToolbar.ShowMenu.click();
			parent.CommonToolbar.unLoadTitleName();
		}
	} //added for Bru-HIMS-CRF-073.1 [IN:047222] -end
}

function showQueryCriteria(obj){
	
	var formObj = document.frmDispMedicationLogin;
	var catg	  = formObj.disp_locn_category.value;
	var disp_locn = formObj.disp_locn.value;
	var password  = formObj.password.value;
	var disp_locn_name 	= formObj.disp_locn.options[formObj.disp_locn.selectedIndex].text;
	if(formObj.disp_stage != null){
		var stage     = formObj.disp_stage.value;
	}

	var fields  = new Array() ;
	var names   = new Array() ;

	if(password==""){
		fields[0]   = formObj.password ;
		names[0]   = getLabel("Common.password.label","Common");
	}
	else if(disp_locn=="") {
		fields[0]   = formObj.disp_locn ;
		names[0]   = getLabel("ePH.DispenseLocation.label","PH");
	}
	else if(catg==""){
		fields[0]   = formObj.disp_locn_category ;
		names[0]   = getLabel("Common.category1.label","Common");
	}
	else if(formObj.disp_stage != null && stage==""){
		fields[0]   = formObj.disp_stage ;
		names[0]   = getLabel("ePH.DispenseStages.label","PH");
	}
	if(checkFlds( fields, names)){
		var bean_id		= formObj.bean_id.value ;
		var bean_name	= formObj.bean_name.value ;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		var curr_enc_financial_dtl_yn = "";
		if(disp_locn=="all")
		{
		curr_enc_financial_dtl_yn="Y";
		}else{
			curr_enc_financial_dtl_yn= eval("formObj.dispFinDtl_"+disp_locn).value;
		}
		xmlStr	="<root><SEARCH " ;
		xmlStr += " password=\"" + password + "\"";
		xmlStr += " disp_locn_code=\"" + disp_locn + "\"";
		xmlStr += " disp_locn_name=\"" + encodeURIComponent(disp_locn_name) + "\"";
		xmlStr += " disp_locn_catg=\"" + catg + "\"";
		xmlStr += " curr_enc_financial_dtl_yn=\"" + curr_enc_financial_dtl_yn + "\"";
		if(formObj.disp_stage != null){
			xmlStr += " disp_stage=\"" + stage + "\"";
			if(formObj.disp_locn_category.value=="I" && formObj.disp_stage.value=="F"){
				if(formObj.chk_fill_list[0].checked==true){
					xmlStr += " fill_list=\"" + formObj.chk_fill_list[0].value + "\"";
				}
				else{
					xmlStr += " fill_list=\"" + formObj.chk_fill_list[1].value + "\"";
				}
			}
			else if(formObj.disp_locn_category.value=="I" && formObj.disp_stage.value=="D"){
				if(formObj.chk_deliver_fill_list[0].checked==true){
					xmlStr += " fill_list=\"" + formObj.chk_deliver_fill_list[0].value + "\"";
				}
				else{
					xmlStr += " fill_list=\"" + formObj.chk_deliver_fill_list[1].value + "\"";
				}
			}	
		}
		else if(formObj.disp_stage == null && obj=="PrepareAdmixture")	{
			if((formObj.disp_locn_category.value=="O")){	// Outpatient
				xmlStr += " disp_stage=\"A\"";	// Allocation
			}
			else{
				xmlStr += " disp_stage=\"F\"";	// Filling
				xmlStr += " fill_list=\"WF\"";	// Without fill list
			}
		}
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=validateWSForTokenSeries", false ) ;
		xmlHttp.send( xmlDoc ) ;
		eval(xmlHttp.responseText);
		if(pswd_flag !="Y"){
			//window.close();
			
			var dialogTag = parent.parent.document.getElementById("dialog_tag");
			dialogTag.close();
		}
		else{
			try{
				document.getElementById("password").focus();
			}
			catch(e){}
		}
	}
}
//var pswd_flag="N";
function focusOnPasswordField(obj){
	pswd_flag= obj;
}
function getDrugCatg(obj, prev_disp_catg){
	var formObj = document.frmDispMedicationLogin;
	var disp_locn_code = obj.value;
	formObj.disp_locn_category.disabled=false;

	/* Below Condition  Added  by sureshkumar T For The Inc : SRR20056-SCF-7894 [29225] Upto 148*/
	if(prev_disp_catg==undefined || prev_disp_catg==null)
	prev_disp_catg="";

	if(formObj.disp_stage != null)
		formObj.disp_stage.disabled=false;
	if(obj.value != ""){
		var bean_id   = formObj.bean_id.value;
		var bean_name = formObj.bean_name.value;
		var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest();
		var xmlStr ="<root><SEARCH ";
		xmlStr += " disp_locn_code=\"" + disp_locn_code + "\"";
		/* Below prevDispCatg  Added  by sureshkumar T For The Inc : SRR20056-SCF-7894 [29225] */
		xmlStr += " prev_disp_catg=\""+prev_disp_catg+"\"";
		xmlStr += " bean_id=\""+bean_id+"\"";
		xmlStr += " bean_name=\""+bean_name+"\"";
		xmlStr +=" /></root>"; 
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=getDispCatg",false);
		xmlHttp.send( xmlDoc ) ;
		eval(xmlHttp.responseText);
	}
}
function assignDispCatg(disp_locn_catg, prev_disp_catg){
	/* Above prev_disp_catg  Added  by sureshkumar T For The Inc : SRR20056-SCF-7894 [29225] */
	var formObj = document.frmDispMedicationLogin;
	var catg_len =formObj.disp_locn_category.options.length;
	for(var i=0;i<catg_len;i++) {
		formObj.disp_locn_category.remove("disp_locn_category") ;
	}
	if(disp_locn_catg=="I"){
		var tp = "Inpatient" ;
		var opt = document.createElement("OPTION") ;
		opt.text = tp ;
		opt.value = "I" ;
		formObj.disp_locn_category.add(opt);
		formObj.disp_locn_category.disabled=true;
	}
	else if(disp_locn_catg=="O"){
		var tp = "Outpatient" ;
		var opt = document.createElement("OPTION") ;
		opt.text = tp ;
		opt.value = "O" ;
		formObj.disp_locn_category.add(opt);
		formObj.disp_locn_category.disabled=true;
	}
	else if(disp_locn_catg=="B"){
		var tp1 = "Inpatient" ;
		var opt1 = document.createElement("OPTION") ;
		opt1.text = tp1 ;
		opt1.value = "I" ;
		formObj.disp_locn_category.add(opt1);

		var tp2 = "Outpatient" ;
		var opt2 = document.createElement("OPTION") ;
		opt2.text = tp2 ;
		opt2.value = "O" ;
		formObj.disp_locn_category.add(opt2);
		formObj.disp_locn_category.disabled=false;

		/* Below Condition Added  by sureshkumar T For The Inc : SRR20056-SCF-7894 [29225] upto 216*/
		if(prev_disp_catg !="")
			formObj.disp_locn_category.value=prev_disp_catg;

	}// /* Below else if Condition  Added  by Himanshu For MMS-DM-CRF-0232  (formObj.isSite_integration_em_bd_pyxis.value=="true" && prev_disp_catg=="" && formObj.disp_locn.value=="all") */
	else if(formObj.isSite_integration_em_bd_pyxis.value=="true"  && formObj.disp_locn.value=="all")
		{
		var tp = "Inpatient & AE" ;
		var opt = document.createElement("OPTION") ;
		opt.text = tp ;
		opt.value = "IAE" ;
		formObj.disp_locn_category.add(opt);
		formObj.disp_locn_category.disabled=true;
		disp_locn_catg="IAE" ;
		}
	else{
		var tp = "----Select----" ;
		var opt = document.createElement("OPTION") ;
		opt.text = tp ;
		opt.value = "" ;
		formObj.disp_locn_category.add(opt);
		formObj.disp_locn_category.disabled=false;
	}
	var disp_locn_code = formObj.disp_locn.value;
	if(formObj.disp_stage != null ){
		getApplicableDispStages(disp_locn_catg);
	}
}

function getApplicableDispStages(disp_locn_catg){
	var formObj = document.frmDispMedicationLogin;
    var disp_locn_code = formObj.disp_locn.value;

    if(disp_locn_code!=''&& disp_locn_code!=null){
		var disp_stage_len =formObj.disp_stage.options.length;
		for(var i=0;i<disp_stage_len;i++) {
			formObj.disp_stage.remove("disp_stage") ;
		}
		if(disp_locn_catg=="B"){
			disp_locn_catg = "I";
		}
		//var disp_locn_code = formObj.disp_locn.value;
		var bean_id   = formObj.bean_id.value;
		var bean_name = formObj.bean_name.value;
		//var xmlDoc  = new ActiveXObject( "Microsoft.XMLDom" ) ;
		var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest() ;



		var xmlStr ="<root><SEARCH ";
		xmlStr += " disp_locn_catg=\"" + disp_locn_catg + "\"";
		xmlStr += " disp_locn_code=\"" + disp_locn_code + "\"";
		xmlStr += " bean_id=\""+bean_id+"\"";
		xmlStr += " bean_name=\""+bean_name+"\"";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	xmlHttp.open("POST","DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=getDispStage",false);
		xmlHttp.send( xmlDoc ) ;
		eval(xmlHttp.responseText);
	}
}

function assignApplicableDispStage(stage,stage_name){
	var formObj = document.frmDispMedicationLogin;
	if(stage=="F"){			// Filling
		var tp =  stage_name;
		var opt = document.createElement("OPTION") ;
		opt.text = tp ;
		opt.value = "F" ;
		formObj.disp_stage.add(opt);
	}
	else if(stage=="V"){	// Verification
		var tp = stage_name ;
		var opt = document.createElement("OPTION") ;
		opt.text = tp ;
		opt.value = "V" ;
		formObj.disp_stage.add(opt);
		if(formObj.isSite_integration_em_bd_pyxis.value=="true" && formObj.disp_locn_category.value=="IAE" && formObj.disp_locn.value=="all")// /* Below else if Condition  Added  by Himanshu For MMS-DM-CRF-0232
		{
			formObj.disp_stage.disabled=true;
		}
	}
	else if(stage=="A"){	// Allocation
		var tp = stage_name ;
		var opt = document.createElement("OPTION") ;
		opt.text = tp ;
		opt.value = "A" ;
		formObj.disp_stage.add(opt);
	}
	else if(stage=="B"){	// Billing
		var tp = stage_name;
		var opt = document.createElement("OPTION") ;
		opt.text = tp ;
		opt.value = "B" ;
		formObj.disp_stage.add(opt);
	}
	else if(stage=="D"){	// Delivery
		var tp =stage_name ;
		var opt = document.createElement("OPTION") ;
		opt.text = tp ;
		opt.value = "D" ;	
		formObj.disp_stage.add(opt);
	}
	else if(stage=="AS"){
		var tp = "All Stages" ;
		var opt = document.createElement("OPTION") ;
		opt.text = tp ;
		opt.value = "AS" ;
		opt.selected="selected";
		formObj.disp_stage.add(opt);
	}
}

function goHome(){
	window.returnValue="GOHOME";
	//const dialogTag = parent.parent.document.getElementById("dialog_tag");        
	window.close();
/*	const dialogTag = parent.document.getElementById("dialog_tag");
	dialogTag.close();*/
}

function hideShowCriteria(obj){
	var formObj = document.frmDispMedicationQueryCriteriaButtons;
	if(obj.value==getLabel("ePH.HideCriteria.label","PH")){
		//parent.document.DispMedicationQueryCriteriaFrameSet.rows="25,0,*,0,500";
		formObj.btnAdditionalCriteria.style.display="none";
		obj.value=getLabel("ePH.ShowCriteria.label","PH");
		
		parent.document.getElementById("f_query_criteria_token_info").style.height="6vh";
		parent.document.getElementById("f_query_criteria").style.height="0vh";
		parent.document.getElementById("f_query_criteria_buttons").style.height="7vh";
		parent.document.getElementById("f_query_criteria_additional").style.height="0vh";
		parent.document.getElementById("f_query_result").style.height="70vh";
	}
	else if(obj.value==getLabel("ePH.ShowCriteria.label","PH")){
		//parent.document.DispMedicationQueryCriteriaFrameSet.rows="25,162,*,0,0"; //rows="25,135,*,0,0"; Modified for ML-MMOH-CRF-1666 [38779]
		formObj.btnAdditionalCriteria.style="display";
		formObj.btnAdditionalCriteria.disabled = false;
		obj.value=getLabel("ePH.HideCriteria.label","PH");
		//parent.f_query_criteria_token_info.document.frmDispMedicationQueryCriteriaTokenInfo.token_no.value="";
		
		parent.document.getElementById("f_query_criteria_token_info").style.height="6vh";
		parent.document.getElementById("f_query_criteria").style.height="32vh";
		parent.document.getElementById("f_query_criteria_buttons").style.height="5vh";
		parent.document.getElementById("f_query_criteria_additional").style.height="0vh";
		parent.document.getElementById("f_query_result").style.height="70vh";
	}
}

function showAdditionalCriteria(obj,issue_token_on_regn,fill_list){ //code 'fill_list' added for Bru-HIMS-CRF-416[IN045566]
	var formObj = document.frmDispMedicationQueryCriteriaButtons;
	obj.disabled = true;
	parent.document.f_query_criteria_additional.location.href="../../ePH/jsp/DispMedicationQueryCriteriaAddn.jsp";
	if(issue_token_on_regn=="Y"){
		//parent.document.DispMedicationQueryCriteriaFrameSet.rows="25,140,40,*,0";
		
		parent.document.getElementById("f_query_criteria_token_info").style.height="4vh";
		parent.document.getElementById("f_query_criteria").style.height="22vh";
		parent.document.getElementById("f_query_criteria_buttons").style.height="8vh";
		parent.document.getElementById("f_query_criteria_additional").style.height="66vh";
		parent.document.getElementById("f_query_result").style.height="0vh";
		
	}
	else{
	  if(fill_list=="DWF" || formObj.btnHideShowCriteria.value==getLabel("ePH.HideCriteria.label","PH")){//code added for Bru-HIMS-CRF-416[IN045566] 	
			//parent.document.DispMedicationQueryCriteriaFrameSet.rows="0,135,40,*,0";	
			
		parent.document.getElementById("f_query_criteria_token_info").style.height="0vh";
		parent.document.getElementById("f_query_criteria").style.height="22vh";
		parent.document.getElementById("f_query_criteria_buttons").style.height="8vh";
		parent.document.getElementById("f_query_criteria_additional").style.height="68vh";
		parent.document.getElementById("f_query_result").style.height="0vh";

			
		}	//code added for Bru-HIMS-CRF-416[IN045566] --Start
	 else if(formObj.btnHideShowCriteria.value==getLabel("ePH.ShowCriteria.label","PH")){  
			//parent.document.DispMedicationQueryCriteriaFrameSet.rows="0,30,40,*,0";
			
			
		parent.document.getElementById("f_query_criteria_token_info").style.height="0vh";
		parent.document.getElementById("f_query_criteria").style.height="7vh";
		parent.document.getElementById("f_query_criteria_buttons").style.height="8vh";
		parent.document.getElementById("f_query_criteria_additional").style.height="66vh";
		parent.document.getElementById("f_query_result").style.height="0vh";
		}//code added for Bru-HIMS-CRF-416[IN045566]-- End
	}
}

function switchToLogin(){

	var formObjQueryCriteriaButtons = document.frmDispMedicationQueryCriteriaButtons;
	var bean_id		= formObjQueryCriteriaButtons.bean_id.value ;
	var bean_name	= formObjQueryCriteriaButtons.bean_name.value ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=getSourceValue", false ) ;
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);
}

function showCriteriaAfterSwitch(source,function_identity){
	if(function_identity=="DispMedication"){
		parent.parent.document.location.href="../../ePH/jsp/DispMedication.jsp?identityForSwitch=switch&source="+source;
	}
	else if(function_identity=="PrepareAdmixture"){
		parent.parent.document.location.href="../../ePH/jsp/PrepareAdmixture.jsp?identityForSwitch=switch&source="+source;
	}
	else{
		parent.parent.document.location.href="../../ePH/jsp/DispMedicationVerify.jsp?identityForSwitch=switch&source="+source;
	}
}

function validateDate(){	
	var disp_locn_catg = parent.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.disp_locn_catg.value;
	var formObj = "";
	if(disp_locn_catg=="O"){
		formObj=document.frmDispMedicationQueryCriteria;
	}
	else{
		formObj=document.frmDispMedicationQueryCriteriaIP;
	}
	if (formObj.order_date_from.value!="" && formObj.order_date_to.value!=""){
		if(!doDateCheck(formObj.order_date_from,formObj.order_date_to,parent.parent.messageFrame)){
			formObj.order_date_to.select();
		}
		else{
			parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
		}
	}
}

// This will call common patient search
async function callPatientSearch(){

	var disp_locn_catg = parent.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.disp_locn_catg.value
	var issue_token_on_regn = parent.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.issue_token_on_regn.value
	var formObj = "";
	if(disp_locn_catg=="O"){
		if(issue_token_on_regn =='Y')
			formObj=document.frmDispMedicationQueryCriteriaTokenInfo;
		else
			formObj=document.frmDispMedicationQueryCriteria;
	}
	else{
		formObj=document.frmDispMedicationQueryCriteriaIP;
	}
	var patient_id = formObj.patient_id.value
	if(patient_id == "")
		patient_id =await PatientSearch();
	
	//	var patient_id = PatientSearch();
	if (patient_id!= "" && patient_id != undefined){
		formObj.patient_id.value = patient_id;
		formObj.patient_id.disabled = true;
		formObj.btnPatientID.disabled = true;
        if(disp_locn_catg!="O"){
			var bean_id		= formObj.bean_id.value ;
			var bean_name	= formObj.bean_name.value ;
			var xmlDoc="";
			var xmlHttp = new XMLHttpRequest();
			xmlStr	="<root><SEARCH " ;
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST", "DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=nationalityHealthCardNo&patient_id="+patient_id, false ) ;
			xmlHttp.send( xmlDoc ) ;
			eval(xmlHttp.responseText);
		}
		else{
			var maxPatIDlength = formObj.patient_id.maxLength;
			if(issue_token_on_regn=='Y') 
				getResultForPatient(maxPatIDlength, issue_token_on_regn);
		}
	}
}

function UnLockStatus(login_user,disp_stage,disp_locn_code){
	var patient_id="";
	var xmlStr ="<root><SEARCH ";
	xmlStr+= " bean_id =\"DispMedicationAllStages\" " ;
	xmlStr+= " bean_name=\"ePH.DispMedicationAllStages\" " ;
	xmlStr+= "LOGIN_USER  =\"" + login_user + "\" " ;
	xmlStr+= "DISP_LOCN_CODE  =\"" + disp_locn_code + "\" " ;
	xmlStr+= "DISP_STAGE  =\"" + disp_stage + "\" " ;
	xmlStr+= "PATIENT_ID  =\"" + patient_id + "\" " ;
	xmlStr +=" /></root>";
	var temp_jsp="DispMedicationValidation.jsp?func_mode=CHECKLOCKREFRESH";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;		
	eval(responseText);	
 }

function UnLockStatus1(login_user,disp_stage,disp_locn_code,fill_list,fill_proc_id){
	disp_stage='DF';
	var patient_id="";
	var xmlStr ="<root><SEARCH ";
	xmlStr+= " bean_id =\"DispMedicationAllStages\" " ;
	xmlStr+= " bean_name=\"ePH.DispMedicationAllStages\" " ;
	xmlStr+= "LOGIN_USER  =\"" + login_user + "\" " ;
	xmlStr+= "DISP_LOCN_CODE  =\"" + disp_locn_code + "\" " ;
	xmlStr+= "DISP_STAGE  =\"" + disp_stage + "\" " ;
	xmlStr+= "FILL_PROC_ID  =\"" + fill_proc_id + "\" " ;
	xmlStr+= "FILL_LIST  =\"" + fill_list + "\" " ;
	xmlStr +=" /></root>";
	var temp_jsp="DispMedicationValidation.jsp?func_mode=checklockDeliverystage";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;		
	eval(responseText);	
 }

async function checkRestoreChangesUponRefresh(disp_locn_catg,issue_token,disp_stage,fill_list,login_user,disp_locn_code) {
	if(disp_locn_catg=="O" && issue_token=="Y"){/* below code added for ML-BRU-SCF-0340[IN:034556] -- Start */ 
		var token_no =  parent.document.f_query_criteria_token_info.frmDispMedicationQueryCriteriaTokenInfo.token_no.value;   
		if( (token_no == null || token_no == "" ) && parent.f_query_criteria.frmDispMedicationQueryCriteria!=undefined )
			parent.f_query_criteria.frmDispMedicationQueryCriteria.OrderingFacility.value = parent.f_query_criteria.frmDispMedicationQueryCriteria.facility_id.value;
	}  /* code added for ML-BRU-SCF-0340[IN:034556]  -- End */  
	if(disp_stage=='D' && fill_list=='DWF'){
		var formObj		= parent.f_query_criteria.document.frmDispMedicationQueryCriteriaIP;
		if(formObj.fill_proc_id.options[formObj.fill_proc_id.selectedIndex].value!=null){
			var fill_proc_id = formObj.fill_proc_id.options[formObj.fill_proc_id.selectedIndex].value;
		}
		await UnLockStatus1(login_user,disp_stage,disp_locn_code,fill_list,fill_proc_id);
	}
	else{
		await UnLockStatus(login_user,disp_stage,disp_locn_code);
	}
	if(disp_locn_catg=="I" ){
		if((disp_stage=='F' && fill_list=='WF')||(disp_stage=='D' && fill_list=='DF')||disp_stage=='V'||disp_stage=='A'){//added V & A for ML-BRU-SCF-1447[IN052188]
			var formobj=parent.f_query_criteria.frmDispMedicationQueryCriteriaIP;
			
			var dateFormat = ""; //added for MMS-DM-CRF-0228 start
			var ph_print_prescription = formobj.ph_print_prescription.value;
			if(ph_print_prescription=="true"){
				dateFormat = "DMYHM";
			}
			else{
				dateFormat = "DMY";//added for MMS-DM-CRF-0228 end
			}
			
			if(formobj.order_date_from.value==''||formobj.order_date_to.value==''){
				//alert(getMessage("PH_ORD_DATE_FM_TO_NOT_BLANK","PH"));//commented for ML-BRU-SCF-1447[IN052188]
				var msg = getMessage("PH_PRD_DATE_FM_TO_NOT_BLANK","PH");//added for ML-BRU-SCF-1447[IN052188]
				if(formobj.ip_scope.value=='R')	
					msg = msg.replace("$",getLabel("ePH.NextFillDate.label","PH"));
				else
					msg = msg.replace("$",getLabel("Common.Period.label","Common"));
				alert(msg);
				return false;
			}
			else if(!isBefore(formobj.order_date_from.value,formobj.order_date_to.value,dateFormat,formobj.Language_id.value)){ //dateFormat added for MMS-DM-CRF-0228
				var errors=getMessage('PH_MUST_GR_EQUAL','PH');
				var msg="";
				if(formobj.ip_scope.value=='R'){
					msg=getLabel("ePH.NextFillDate.label","PH")+" "+getLabel("Common.to.label","Common");
					errors = errors.replace("$",msg);
					msg=getLabel("ePH.NextFillDate.label","PH")+" "+getLabel("Common.from.label","Common");
					errors = errors.replace("#",msg);
				}
				else{
					msg=getLabel("Common.Period.label","Common")+" "+getLabel("Common.to.label","Common")+" "+getLabel("Common.date.label","Common");
					errors = errors.replace("$",msg);
					msg=getLabel("Common.Period.label","Common")+" "+getLabel("Common.from.label","Common")+" "+getLabel("Common.date.label","Common");
					errors = errors.replace("#",msg);
				}
				alert(errors);
				return false;
			}//added for ML-BRU-SCF-1447[IN052188]
		}
	}
	// check the change_status variable of query criteria screen.if its not equal to empty call the below method
	try{
		if(parent.f_query_criteria.document.forms[0].order_type != null && (parent.f_query_criteria.document.forms[0].order_type.value == "ALL" || parent.f_query_criteria.document.forms[0].order_type.value == "CDR" )){ // CDR Condition Added for ML-MMOH-CRF-0435 [IN:057357]
			parent.f_query_criteria.document.forms[0].disp_level.value = "P";
		}
	}
	catch (e){
		//alert(e.message);
	}
	var bean_id		= "DispMedicationBean"; 	//Added for INC#47651--START
	var bean_name	= "ePH.DispMedicationBean";
	//var xmlDoc  = new ActiveXObject( "Microsoft.XMLDom" ) ;
	var xmlDoc  ="";
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=showhidealert",false);
	xmlHttp.send( xmlDoc ) ;
	responseText = xmlHttp.responseText;
	var relflag = eval(responseText);  //Added for INC#47651--END
	if(disp_locn_catg=="O"){
		if(issue_token=="N"){//added for ML-BRU-SCF-1447[IN052188] -start
			if(disp_stage=='F' || disp_stage=='D' || disp_stage=='V'|| disp_stage=='A' || disp_stage=='AS'){
				var formobj=parent.f_query_criteria.frmDispMedicationQueryCriteria;
				
				var dateFormat = ""; //added for MMS-DM-CRF-0228 start
				var ph_print_prescription = formobj.ph_print_prescription.value;
				if(ph_print_prescription=="true"){
					dateFormat = "DMYHM";
				}
				else{
					dateFormat = "DMY";//added for MMS-DM-CRF-0228 end
				}
				if(formobj.order_date_from.value==''||formobj.order_date_to.value==''){
					var msg = getMessage("PH_PRD_DATE_FM_TO_NOT_BLANK","PH");
					if(formobj.order_status.value=='B')
						msg = msg.replace("$",getLabel("ePH.CollectionDate.label","PH"));
					else
						msg = msg.replace("$",getLabel("Common.Period.label","Common"));
					alert(msg);
					return false;
				}
				else if(!isBefore(formobj.order_date_from.value,formobj.order_date_to.value,dateFormat,formobj.Language_id.value)){ //dateFormat added for MMS-DM-CRF-0228
					var errors=getMessage('PH_MUST_GR_EQUAL','PH');
					var msg="";
					if(formobj.order_status.value=='B'){
						msg=getLabel("ePH.CollectionDate.label","PH")+" "+getLabel("Common.to.label","Common");
						errors = errors.replace("$",msg);
						msg=getLabel("ePH.CollectionDate.label","PH")+" "+getLabel("Common.from.label","Common");
						errors = errors.replace("#",msg);
					}
					else{
						msg=getLabel("Common.Period.label","Common")+" "+getLabel("Common.to.label","Common")+" "+getLabel("Common.date.label","Common");
						errors = errors.replace("$",msg);
						msg=getLabel("Common.Period.label","Common")+" "+getLabel("Common.from.label","Common")+" "+getLabel("Common.date.label","Common");
						errors = errors.replace("#",msg);
					}
					alert(errors);
					return false;
				}
			}
		}//added for ML-BRU-SCF-1447[IN052188] ends
		try	{
			if(parent.f_query_criteria.frmDispMedicationQueryCriteria.change_status.value!=""){
				if(!relflag)//if block Added for //Added for INC#47651
					relflag = confirm(getMessage("PH_DISPENSE_DATA_MODIFIED","PH"));
				if(relflag){
					clearAllStagesBeanValues(parent.f_query_criteria.frmDispMedicationQueryCriteria);
					if(issue_token=="N"){
						/*parent.f_query_criteria.frmDispMedicationQueryCriteria.row3.style.display="none";
						parent.f_query_criteria.frmDispMedicationQueryCriteria.row4.style.display="none";
						parent.f_query_criteria.frmDispMedicationQueryCriteria.row5.style.display="none";//code added for Bru-HIMS-CRF-416[IN045566]-- Start
						parent.f_query_criteria.frmDispMedicationQueryCriteria.row1.style.display="none";
						parent.f_query_criteria.frmDispMedicationQueryCriteria.row2.style.display="none";//code added for Bru-HIMS-CRF-416[IN045566]-- End*/
						//parent.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.btnShowCriteria.style="display"; //code commented for Bru-HIMS-CRF-416[IN045566]
						//parent.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.btnAdditionalCriteria.style.display="none";//code commented for Bru-HIMS-CRF-416[IN045566]
						parent.f_query_criteria.document.getElementById('row3').style.display="none";
						parent.f_query_criteria.document.getElementById('row4').style.display="none";
						parent.f_query_criteria.document.getElementById('row5').style.display="none";//code added for Bru-HIMS-CRF-416[IN045566]-- Start
						parent.f_query_criteria.document.getElementById('row1').style.display="none";
						parent.f_query_criteria.document.getElementById('row2').style.display="none";
						parent.f_query_criteria.document.getElementById('row6').style.display="none";
						
					} 
					await showPatientsBasedOnTheCriteria(disp_locn_catg,issue_token,disp_stage,fill_list);
				}
			}
			else{
				if(issue_token=="N"){
					try{parent.f_query_criteria.document.getElementById('row3').style.display="none";}catch(e){}
					try{parent.f_query_criteria.document.getElementById('row4').style.display="none";}catch(e){}
					try{parent.f_query_criteria.document.getElementById('row5').style.display="none";}catch(e){}
					try{parent.f_query_criteria.document.getElementById('row1').style.display="none";}catch(e){}
					try{parent.f_query_criteria.document.getElementById('row2').style.display="none";}catch(e){} 
					try{parent.f_query_criteria.document.getElementById('row6').style.display="none";}catch(e){}
					//parent.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.btnShowCriteria.style="display";//code commented for Bru-HIMS-CRF-416[IN045566]					
					//parent.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.btnAdditionalCriteria.style.display="none";	//code commented for Bru-HIMS-CRF-416[IN045566]								
			    }
				await showPatientsBasedOnTheCriteria(disp_locn_catg,issue_token,disp_stage,fill_list);
			}
		}
		catch (e){//alert(e.message);
		}
	}
	else if(disp_locn_catg=="IAE") {//	//below added By Himanshu Saxena for MMS-DM-CRF-0232 on 10-10-23 Started
		try{
			if( parent.f_query_criteria.frmDispMedicationQueryCriteriaIP.change_status.value!=""){
				if(!relflag)//if block added for Added for INC#47651
					relflag = confirm(getMessage("PH_DISPENSE_DATA_MODIFIED","PH"));
				if(relflag){
					await	clearAllStagesBeanValues(parent.f_query_criteria.frmDispMedicationQueryCriteriaIP);
					await	showPatientsBasedOnTheCriteria(disp_locn_catg,issue_token,disp_stage,fill_list);
				}
			}
			else{
				if(fill_list !='DWF'){ 
					parent.f_query_criteria.document.getElementById('row1').style.display="none";
					parent.f_query_criteria.document.getElementById('row2').style.display="none";
					parent.f_query_criteria.document.getElementById('row3').style.display="none";
					parent.f_query_criteria.document.getElementById('row4').style.display="none";
					parent.document.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.btnHideShowCriteria.value=getLabel("ePH.ShowCriteria.label","PH");
				}	
				if(fill_list !='AF' && fill_list !='DWF'){
					parent.f_query_criteria.document.getElementById('row5').style.display="none";//code added for Bru-HIMS-CRF-416[IN045566]-- End
					parent.f_query_criteria.document.getElementById('row6').style.display="none";
				}
				await clearOnRefresh();
				await showPatientsBasedOnTheCriteria(disp_locn_catg,issue_token,disp_stage,fill_list);
			}
		}
		catch(e){
			//alert(e.message);
		}
	}//	//above code added By Himanshu Saxena for MMS-DM-CRF-0232 on 10-10-23 ends
	else{
		try{
			if( parent.f_query_criteria.frmDispMedicationQueryCriteriaIP.change_status.value!=""){
				if(!relflag)//if block added for Added for INC#47651
					relflag = confirm(getMessage("PH_DISPENSE_DATA_MODIFIED","PH"));
				if(relflag){
					await clearAllStagesBeanValues(parent.f_query_criteria.frmDispMedicationQueryCriteriaIP);
					await showPatientsBasedOnTheCriteria(disp_locn_catg,issue_token,disp_stage,fill_list);
				}
			}
			else{
				if(fill_list !='DWF'){ //code added for Bru-HIMS-CRF-416[IN045566]-- Start
					parent.f_query_criteria.document.getElementById('row1').style.display="none";
					parent.f_query_criteria.document.getElementById('row2').style.display="none";
					parent.f_query_criteria.document.getElementById('row3').style.display="none";
					parent.f_query_criteria.document.getElementById('row4').style.display="none";
					parent.document.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.btnHideShowCriteria.value=getLabel("ePH.ShowCriteria.label","PH");
				}	
				if(fill_list !='AF' && fill_list !='DWF'){
					parent.f_query_criteria.document.getElementById('row6').style.display="none";
					parent.f_query_criteria.document.getElementById('row5').style.display="none";//code added for Bru-HIMS-CRF-416[IN045566]-- End					
				}
				await clearOnRefresh();
				await showPatientsBasedOnTheCriteria(disp_locn_catg,issue_token,disp_stage,fill_list);
			}
		}
		catch(e){
			//alert(e.message);
		}
	}
	return true; 
}

function clearOnRefresh(){
	var bean_id_11		=	"DispMedicationAllStages";
	var bean_name_11	=	"ePH.DispMedicationAllStages";

	var xmlStr ="<root><SEARCH ";
	xmlStr+= "bean_id =\"" + bean_id_11 + "\" " ;
	xmlStr+= "bean_name=\"" + bean_name_11 + "\" " ;
	xmlStr +=" /></root>" ;	
	var temp_jsp="DispMedicationValidation.jsp?func_mode=clearOnRefresh";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
} 

function showPatientsBasedOnTheCriteria(disp_locn_catg,issue_token,disp_stage,fill_list, customTabBasedOption){
	//alert("inside showPatientsBasedOnTheCriteria");
	token_valid_flag	=	false;
	var include_absolute_orders = "";
	var include_orders_by_freq_durn = "";
	var exclude_PRN_orders		= "";
	var group_by_ord_locn="N";
	var customGroupBy="";
	var customGroupOrder="";
	var customSortBy="";
	var customSortOrder="";
	var customTabBased="";
	var customTabBasedHrs="";
	var formIPCriteira ;
	var called_from='';
	var pat_mobile_no ="";//Added for TH-KW-CRF-0014
	var national_id ="";//Added for TH-KW-CRF-0014
	var dateFormat = ""; //added for MMS-DM-CRF-0228
	if(disp_locn_catg=="I" || disp_locn_catg=="IAE"){
		//alert("896");
		if(customTabBasedOption == null || customTabBasedOption == undefined){
			formIPCriteira = parent.document.f_query_criteria.frmDispMedicationQueryCriteriaIP;
		}
		else{
			formIPCriteira = parent.parent.parent.f_query_criteria.document.frmDispMedicationQueryCriteriaIP;
			called_from = 'tab';
		}
	}
	if(customTabBasedOption == null || customTabBasedOption == undefined)
		customTabBasedOption = '1';
	if(disp_locn_catg=="O"){
		//alert("908");
		if(parent.document.f_query_criteria.frmDispMedicationQueryCriteria.include_absolute_orders.checked==true)
			include_absolute_orders ="Y";
		else
			include_absolute_orders ="N";
		if(parent.document.f_query_criteria.frmDispMedicationQueryCriteria.group_by_ord_locn.checked==true)
			group_by_ord_locn ="Y";
		else
			group_by_ord_locn ="N";

		if(parent.document.f_query_criteria.frmDispMedicationQueryCriteria.exclude_PRN_orders.checked==true)
			exclude_PRN_orders ="Y";
		else
			exclude_PRN_orders ="N";
	 }
	 else{
		if( fill_list!="DWF"){
			//alert("925");
			// Added for SRR20056-CRF-0663 - Start
			if(formIPCriteira.include_absolute_orders.checked==true)
				include_absolute_orders ="Y";
			else
				include_absolute_orders ="N";
			// Added for SRR20056-CRF-0663 - End
			//exclude_orders_by_freq_durn changed to include_orders_by_freq_durn for SRR20056-CRF-0663 

			if( formIPCriteira.include_orders_by_freq_durn!=undefined && formIPCriteira.include_orders_by_freq_durn.checked==true)
				include_orders_by_freq_durn ="Y";
			else
				include_orders_by_freq_durn ="N";

			if(formIPCriteira.group_by_ord_locn.checked==true)
				group_by_ord_locn ="Y";
			else
				group_by_ord_locn ="N";

			if(formIPCriteira.exclude_PRN_orders.checked==true)
				exclude_PRN_orders ="Y";
			else
				exclude_PRN_orders ="N";
			//alert("948");
		}
	}
	if(disp_locn_catg=="O"){
		/*parent.document.getElementById("f_query_criteria_token_info").style.height="0vh";
		parent.document.getElementById("f_query_criteria").style.height="6vh";
		parent.document.getElementById("f_query_criteria_buttons").style.height="5vh";
		parent.document.getElementById("f_query_criteria_additional").style.height="0vh";
		parent.document.getElementById("f_query_result").style.height="90vh";*/
		//alert("951");
		if(issue_token=="Y"){
			var formObj              = parent.document.f_query_criteria_token_info.frmDispMedicationQueryCriteriaTokenInfo;
			var formObjQueryCriteria = parent.document.f_query_criteria.frmDispMedicationQueryCriteria;
            var language_id	         =   formObjQueryCriteria.Language_id.value;
            var order_id			=	formObjQueryCriteria.order_id.value;//Added for JD-CRF-0181[IN045511]
            var customSortOrder	    = "" ;// formObjQueryCriteria.customSortOrder.value; //added for ML-MMOH-CRF-1666
			var customSortBy		= "";//	formObjQueryCriteria.customSortBy.value; //added for ML-MMOH-CRF-1666
			var tab_based_group_sort_disp_op = formObjQueryCriteria.tab_based_group_sort_disp.value; //added for ML-MMOH-CRF-1666[38837]
			if(tab_based_group_sort_disp_op!=undefined && tab_based_group_sort_disp_op!='undefined' && tab_based_group_sort_disp_op!=null && tab_based_group_sort_disp_op!='null' && tab_based_group_sort_disp_op=="Y"){
				 customSortOrder	    =   formObjQueryCriteria.customSortOrder.value; //added for ML-MMOH-CRF-1666
				 customSortBy		= 	formObjQueryCriteria.customSortBy.value; 
			}
			//alert("964")//added for ML-MMOH-CRF-1666
			var ph_print_prescription = formObjQueryCriteria.ph_print_prescription.value; //added for MMS-DM-CRF-0228 start
			if(ph_print_prescription=="true"){
				dateFormat = "DMYHM";
			}
			else{
				dateFormat = "DMY";
			}//added for MMS-DM-CRF-0228 end
			
			patient_id =  formObj.patient_id.value;
			//alert("974")
			if(trimString(formObj.token_series.value) != "" && formObj.queue_date.value != ""){
				if(formObj.token_no.value!="") {
					//alert("977");
					validateTokenNo(formObj.token_no ,"btnSearch");
				} 
				else {
					token_valid_flag	=	true;
				}

				if(token_valid_flag == true){
					
					if(language_id=="ar"){ //modified for MOHE-CRF-0040
					if(formObjQueryCriteria.disp_level.value=="P")
						formObjQueryCriteria.lbl_disp_level.innerHTML = "<b> حسب ا�?�?ر�?ض</b>";
					else
						formObjQueryCriteria.lbl_disp_level.innerHTML = "<b> حسب ا�?ترت�?ب</b>";
					}
					else{
					if(formObjQueryCriteria.disp_level.value=="P"){
						parent.f_query_criteria.document.getElementById('lbl_disp_level').innerHTML = "<b> Patient Wise</b>";
					}else
						
						formObjQueryCriteria.lbl_disp_level.innerHTML = "<b> Order Wise</b>";
					} //modified for MOHE-CRF-0040
					
					formObj.token_no.disabled		=	true;
					formObj.token_series.disabled	=	true;
					formObj.queue_date.disabled	    =	true;
					parent.document.f_query_criteria_token_info.document.getElementById("Calendar").disabled	    =	true;
					//parent.document.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.btnHideShowCriteria.disabled	=	true;
					//parent.document.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.btnSwitch.disabled			=	true;
					//parent.document.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.btnSearch.disabled			=	true;
					var token_series = formObj.token_series.value; //Added for HSA-CRF-0136 [IN:048412] -start
					if(token_series == '*A')
						token_series = ''; //Added for HSA-CRF-0136 [IN:048412] -end
					var bean_id		= formObj.bean_id.value ;
					var bean_name	= formObj.bean_name.value ;
					var xmlDoc="";
					var xmlHttp = new XMLHttpRequest();
					xmlStr	="<root><SEARCH " ;
					xmlStr += " token_no=\"" + formObj.token_no.value + "\"";
					xmlStr += " token_series=\"" + token_series + "\"";
					xmlStr += " order_date_from=\"" + convertDate(formObjQueryCriteria.order_date_from.value,dateFormat,language_id,"en") + "\""; //dateFormat Added for MMS-DM-CRF-0228
					xmlStr += " order_date_to=\"" + convertDate(formObjQueryCriteria.order_date_to.value,dateFormat,language_id,"en") + "\""; //dateFormat Added for MMS-DM-CRF-0228
					xmlStr += " scope=\"" + formObjQueryCriteria.order_status.value + "\"";
					xmlStr += " priority=\"" + formObjQueryCriteria.priority.value + "\"";
					xmlStr += " order_id=\"" + formObjQueryCriteria.order_id.value + "\"";//Added for JD-CRF-0181 [IN:40699]
					//xmlStr += " patient_id=\"" + formObjQueryCriteria.patient_id.value + "\"";
					xmlStr += " patient_id=\"" + patient_id+ "\"";
					//xmlStr += " order_id=";
					if(formObjQueryCriteria.admixture_type!=null){
						xmlStr += " admixture_type=\"" + formObjQueryCriteria.admixture_type.value + "\"";
					}

					xmlStr += " disp_level=\"" + formObjQueryCriteria.disp_level.value + "\"";
					xmlStr += " ord_locn_code=\"" + formObjQueryCriteria.ord_locn_code.value + "\"";
					xmlStr += " order_type=\"" + formObjQueryCriteria.order_type.value + "\"";
					xmlStr += " ord_locn_type=\"" + formObjQueryCriteria.ord_loc_type.value + "\"";
					xmlStr += " OrderingFacility=\"" + formObjQueryCriteria.OrderingFacility.value + "\"";
					xmlStr += " group_by_ord_locn=\"" + group_by_ord_locn + "\"";
					xmlStr += " customSortOrder=\"" + customSortOrder + "\""; //added for ML-MMOH-CRF-1666
					xmlStr += " customSortBy=\"" + customSortBy + "\"";//added for ML-MMOH-CRF-1666
					xmlStr += " include_absolute_orders=\"" + include_absolute_orders + "\"";
					xmlStr += " exclude_PRN_orders=\"" + exclude_PRN_orders + "\"";
					xmlStr += " drug_medical=\"" + formObjQueryCriteria.drug_medical.value + "\"";
					xmlStr += " sort_token_series_ind=\"" + formObj.sort_token_series_ind.value + "\""; //Added for HSA-CRF-0136 [IN:048412]
					xmlStr += " disp_locn=\"" + formObjQueryCriteria.disp_locn.value + "\"";  //added By Himanshu Saxena for MMS-DM-CRF-0232 on 10-10-23 Started
					if(disp_stage=='AS'){
						xmlStr += " order_by=\"" + formObjQueryCriteria.order_by.value + "\"";
					}
					xmlStr +=" /></root>" ;
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open( "POST", "DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=storeCriteriaValues", false ) ;
					xmlHttp.send( xmlDoc ) ;
					eval(xmlHttp.responseText);
					parent.f_query_result.DispMedicationPatFrame.location.href="../../ePH/jsp/DispMedicationPatientIDFrame.jsp?patient_id="+patient_id+"&order_id="+order_id;//Added for JD-CRF-0181[IN045511]
					parent.document.DispMedicationQueryCriteriaFrameSet.rows="25,0,*,0,500";
					//parent.document.DispMedicationQueryCriteriaFrameSet.rows="25,0,*,0,530";
					  //parent.document.DispMedicationQueryCriteriaFrameSet.rows="25,0,*,0,100";
					parent.document.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.btnHideShowCriteria.value=getLabel("ePH.ShowCriteria.label","PH");
				}
			}
			else{
				//alert("1057");
				var fields  = new Array() ;
				var names   = new Array() ;
				fields[0]   = formObj.token_series ;
				names[0]   = getLabel("ePH.TokenSeries.label","PH");
               
			    fields[1]   = formObj.queue_date ;
				names[1]   = getLabel("Common.QueueDate.label","Common");

				if(checkFlds( fields, names)){
					parent.document.f_query_criteria_token_info.frmDispMedicationQueryCriteriaTokenInfo.token_series.focus();
					parent.document.DispMedicationQueryCriteriaFrameSet.rows="25,0,*,0,0";
					return false;
				}
				else{
					if(formObj.queue_date.value == ""){
					    parent.document.f_query_criteria_token_info.frmDispMedicationQueryCriteriaTokenInfo.queue_date.focus();
					}
					else {
                       parent.document.f_query_criteria_token_info.frmDispMedicationQueryCriteriaTokenInfo.token_series.focus();
					}
					//parent.document.DispMedicationQueryCriteriaFrameSet.rows="25,92,*,0,0";
					return false;
				}
			}
		}
		else if(issue_token=="N"){
			var formObjQueryCriteria = parent.document.f_query_criteria.frmDispMedicationQueryCriteria;
			var order_id			=	formObjQueryCriteria.order_id.value;//Added for JD-CRF-0181[IN045511]
			var customSortOrder	    = "" ;// formObjQueryCriteria.customSortOrder.value; //added for ML-MMOH-CRF-1666
			var customSortBy		= "";//	formObjQueryCriteria.customSortBy.value; //added for ML-MMOH-CRF-1666
			var tab_based_group_sort_disp_op = formObjQueryCriteria.tab_based_group_sort_disp.value; //added for ML-MMOH-CRF-1666[38837]
			if(tab_based_group_sort_disp_op!=undefined && tab_based_group_sort_disp_op!='undefined' && tab_based_group_sort_disp_op!=null && tab_based_group_sort_disp_op!='null' && tab_based_group_sort_disp_op=="Y"){
				 customSortOrder	    =   formObjQueryCriteria.customSortOrder.value; 
				 customSortBy		= 	formObjQueryCriteria.customSortBy.value; 
			}//added for ML-MMOH-CRF-1666
			var ph_print_prescription = formObjQueryCriteria.ph_print_prescription.value; //added for MMS-DM-CRF-0228 start
			if(ph_print_prescription=="true"){
				dateFormat = "DMYHM";
			}
			else{
				dateFormat = "DMY";
			}//added for MMS-DM-CRF-0228 end
			if(formObjQueryCriteria.chk_group_by_patient.checked == true){
				var chk_group_by_patient = "E";	// To group based on patients
			}
			else{
				var chk_group_by_patient = "D";	// To group based on orders
			}
			parent.document.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.btnHideShowCriteria.value=getLabel("ePH.ShowCriteria.label","PH");//code added for Bru-HIMS-CRF-416[IN045566] 
					
			var language_id	    =   formObjQueryCriteria.Language_id.value;

			if(language_id=="ar"){ //modified for MOHE-CRF-0040
			if(formObjQueryCriteria.disp_level.value=="P")
				formObjQueryCriteria.lbl_disp_level.innerHTML = "<b> حسب ا�?�?ر�?ض</b>";
			else
				formObjQueryCriteria.lbl_disp_level.innerHTML = "<b> حسب ا�?ترت�?ب</b>";
			}else{
			/*if(formObjQueryCriteria.disp_level.value=="P")
				document.getElementById("lbl_disp_level").innerHTML = "<b> Patient Wise</b>";
			else
				document.getElementById("lbl_disp_level").innerHTML = "<b> Order Wise</b>";*/
			} //modified for MOHE-CRF-0040
			
			var bean_id		= formObjQueryCriteria.bean_id.value ;
			var bean_name	= formObjQueryCriteria.bean_name.value ;
			var xmlDoc="";
			var xmlHttp = new XMLHttpRequest();
			var patient_id=  formObjQueryCriteria.patient_id.value;
			xmlStr	="<root><SEARCH " ;
			xmlStr += " order_date_from=\"" + convertDate(formObjQueryCriteria.order_date_from.value,dateFormat,language_id,"en") + "\""; //dateFormat Added for MMS-DM-CRF-0228
			xmlStr += " order_date_to=\"" + convertDate(formObjQueryCriteria.order_date_to.value,dateFormat,language_id,"en") + "\""; //dateFormat Added for MMS-DM-CRF-0228
			xmlStr += " scope=\"" + formObjQueryCriteria.order_status.value + "\"";
			xmlStr += " priority=\"" + formObjQueryCriteria.priority.value + "\"";
			xmlStr += " patient_id=\"" +patient_id+ "\""; //formObjQueryCriteria.patient_id.value 
			xmlStr += " order_id=\"" + formObjQueryCriteria.order_id.value + "\"";//Added for JD-CRF-0181 [IN:40699]
			//xmlStr += " order_id=";
			xmlStr += " chk_group_by_patient=\"" + chk_group_by_patient + "\"";
			if(formObjQueryCriteria.admixture_type!=null){
				xmlStr += " admixture_type=\"" + formObjQueryCriteria.admixture_type.value + "\"";
			}
			xmlStr += " disp_level=\"" + formObjQueryCriteria.disp_level.value + "\"";
			xmlStr += " ord_locn_code=\"" + formObjQueryCriteria.ord_locn_code.value + "\"";
			xmlStr += " order_type=\"" + formObjQueryCriteria.order_type.value + "\"";
			xmlStr += " ord_locn_type=\"" + formObjQueryCriteria.ord_loc_type.value + "\"";
			xmlStr += " OrderingFacility=\"" + formObjQueryCriteria.OrderingFacility.value + "\"";

			xmlStr += " group_by_ord_locn=\"" + group_by_ord_locn + "\"";
			xmlStr += " customSortOrder=\"" + customSortOrder + "\""; //added for ML-MMOH-CRF-1666
			xmlStr += " customSortBy=\"" + customSortBy + "\"";//added for ML-MMOH-CRF-1666
			xmlStr += " include_absolute_orders=\"" + include_absolute_orders + "\"";
			xmlStr += " exclude_PRN_orders=\"" + exclude_PRN_orders + "\"";
			
			xmlStr += " drug_medical=\"" + formObjQueryCriteria.drug_medical.value + "\"";
			xmlStr += " pat_mobile_no=\"" + formObjQueryCriteria.pat_mobile_no.value + "\"";//Added for TH-KW-CRF-0014
			xmlStr += " national_id=\"" + formObjQueryCriteria.national_id_no.value + "\"";//Added for TH-KW-CRF-0014
			xmlStr += " disp_locn=\"" + formObjQueryCriteria.disp_locn.value + "\"";  //added By Himanshu Saxena for MMS-DM-CRF-0232 on 10-10-23 Started

			if(disp_stage=='AS'){
			    xmlStr += " order_by=\"" + formObjQueryCriteria.order_by.value + "\"";
			}
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST", "DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=storeCriteriaValues", false ) ;
			xmlHttp.send( xmlDoc ) ;
			eval(xmlHttp.responseText);
			if(formObjQueryCriteria.chk_group_by_patient.checked==true){
				parent.f_query_result.DispMedicationPatFrame.location.href="../../ePH/jsp/DispMedicationPatientIDFrame.jsp?patient_id="+patient_id+"&order_id="+order_id;//Added for JD-CRF-0181[IN045511]
				parent.document.DispMedicationQueryCriteriaFrameSet.rows="0,20,20,0,365";//code '0,70,20,0,365' replaced by '0,20,20,0,365' added for Bru-HIMS-CRF-416[IN045566] 				
			}
			else{
				if(parent.f_query_result.DispMedicationDetailFrameSet.cols==""){
					parent.f_query_result.location.href="../../ePH/jsp/DispMedicationDetailFrameSet.jsp";
					parent.f_query_result.DispMedicationPatDetFrame_2.location.href="../../ePH/jsp/DispMedicationOrderDetails.jsp?click=Y&order_id="+order_id;//Added for JD-CRF-0181[IN045511]
				}
				else{
					parent.f_query_result.DispMedicationDetailFrameSet.cols="0%,100%";
					parent.f_query_result.DispMedicationPatDetFrame_2.location.href="../../ePH/jsp/DispMedicationOrderDetails.jsp?patient_id=&order_id="+order_id;//Added for JD-CRF-0181[IN045511]
					parent.document.DispMedicationQueryCriteriaFrameSet.rows="0,20,20,0,365";//code '0,45,20,0,365' replaced by '0,20,20,0,365' added for Bru-HIMS-CRF-416[IN045566] 				  					
				}
			}
		}
	}
	else if(disp_locn_catg=="I"){
		//alert("1183");
		var formObjQueryCriteriaIP = formIPCriteira;
	/*	if(formObjQueryCriteriaIP.nursing_unit.value ==""){
			var fields  = new Array() ;
			var names   = new Array() ;
			fields[0]   = formObjQueryCriteriaIP.nursing_unit_desc ;
			names[0]   = "Nursing Unit " ;
			checkFlds( fields, names);
			return false;
		}*/
		var patient_id='';
		var dateFormat = ""; //added for MMS-DM-CRF-0228 start
		var ph_print_prescription = formObjQueryCriteriaIP.ph_print_prescription.value;
		if(ph_print_prescription=="true"){
			dateFormat = "DMYHM";
		}
		else{
			dateFormat = "DMY";//added for MMS-DM-CRF-0228 end
		}//added for MMS-DM-CRF-0228 end
		//if(fill_list != "AF" && fill_list!="DWF")//commented for [IN:055192] and added below of condition
		if(fill_list!="DWF")
			patient_id = formObjQueryCriteriaIP.patient_id.value;
		var bean_id		= formObjQueryCriteriaIP.bean_id.value ;
		var bean_name	= formObjQueryCriteriaIP.bean_name.value ;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		//alert("1209");
		if(disp_stage=="F" && fill_list == "AF"){
			xmlStr	="<root><SEARCH " ;
			xmlStr += " nursing_unit=\"" + formObjQueryCriteriaIP.nursing_unit.value + "\"";
			xmlStr += " fill_process_date=\"" + formObjQueryCriteriaIP.fill_process_date.value + "\"";
			xmlStr += " patient_id=\"" +patient_id  + "\"";//addded for [IN:055192]
			xmlStr += " fill_type=\"" + formObjQueryCriteriaIP.fill_type.value + "\"";
			xmlStr += " fill_process_id=\"" + formObjQueryCriteriaIP.fill_process_id.value + "\"";
			xmlStr += " batches=\"" + formObjQueryCriteriaIP.batches.value + "\"";
			xmlStr += " order_status=\"" + formObjQueryCriteriaIP.order_status.value + "\"";
			xmlStr += " disp_level=\"" + formObjQueryCriteriaIP.disp_level.value + "\"";
			xmlStr += " fill_date_time=\"" + formObjQueryCriteriaIP.fill_date_time.value + "\"";
			xmlStr += " order_id=\"" + formObjQueryCriteriaIP.order_id.value + "\"";//Added for JD-CRF-0181 [IN:40699] //Uncommented for JD-CRF-0181 [IN:46160] 
			if(formObjQueryCriteriaIP.ip_scope!=null){
				xmlStr += " ip_scope=\"" + formObjQueryCriteriaIP.ip_scope.value + "\"";
			}
			else{
				xmlStr += " ip_scope=\"\"";
			}
			if(formObjQueryCriteriaIP.national_id_no!=null){
				xmlStr += " national_id_no=\"" + formObjQueryCriteriaIP.national_id_no.value + "\"";
			}
			else{
				xmlStr += " national_id_no=\"\"";
			}
			xmlStr += " order_type=\"" + formObjQueryCriteriaIP.order_type.value + "\"";		
			xmlStr += " OrderingFacility=\"" + formObjQueryCriteriaIP.OrderingFacility.value + "\"";
			xmlStr += " group_by_ord_locn=\"" + group_by_ord_locn + "\"";
			xmlStr += " include_absolute_orders=\"" + include_absolute_orders + "\"";
			xmlStr += " include_orders_by_freq_durn=\"" + include_orders_by_freq_durn + "\"";	// Added for SRR20056-CRF-0663
			xmlStr += " exclude_PRN_orders=\"" + exclude_PRN_orders + "\"";
			xmlStr += " drug_medical=\"" + formObjQueryCriteriaIP.drug_medical.value + "\"";
			xmlStr +=" /></root>" ;
			//alert("1242   "+xmlStr);
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		}
		else if(disp_stage=="D" && fill_list=="DWF"){
		   //var formObj			= document.frmDispMedicationQueryCriteriaIP;
	       var language_id	    =  formObjQueryCriteriaIP.Language_id.value;
		   var added_date		=  convertDate(formObjQueryCriteriaIP.fill_proc_date.value,dateFormat,language_id,"en");
		   if(formObjQueryCriteriaIP.nursing_unit.value!=''){
				xmlStr	="<root><SEARCH " ;
				xmlStr += " fill_proc_date=\"" + added_date + "\"";
				xmlStr += " fill_proc_type=\"" + formObjQueryCriteriaIP.fill_proc_type.value + "\"";
				xmlStr += " fill_proc_id=\"" + formObjQueryCriteriaIP.fill_proc_id.value + "\"";
				xmlStr += " nursing_unit=\"" + formObjQueryCriteriaIP.nursing_unit.value + "\"";
				xmlStr += " OrderingFacility=\"" + formObjQueryCriteriaIP.OrderingFacility.value + "\"";		
				xmlStr += " include_absolute_orders=\"" + include_absolute_orders + "\"";	// Added for SRR20056-CRF-0663
				xmlStr += " include_orders_by_freq_durn=\"" + include_orders_by_freq_durn + "\"";	// Added for SRR20056-CRF-0663
				//xmlStr += " order_id=\"" + formObjQueryCriteriaIP.order_id.value + "\"";//Added for JD-CRF-0181 [IN:40699] //Commented for  [IN:045338]
				xmlStr +=" /></root>" ;
				//alert("1260"+xmlStr);
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	
		   }
		   else{
              alert(getMessage("PH_NURSING_CANNOT_BLANK","PH"));
			  formObjQueryCriteriaIP.nursing_unit.focus();	   
		   }
		}
		else if(disp_stage=="D"){
			var language_id	    =   formObjQueryCriteriaIP.Language_id.value;
			var tab_based_group_sort_disp	    =   formObjQueryCriteriaIP.tab_based_group_sort_disp.value;
			if(tab_based_group_sort_disp == 'Y'){
				customGroupBy	    =   formObjQueryCriteriaIP.customGroupBy.value;
				customGroupOrder	    =   formObjQueryCriteriaIP.customGroupOrder.value;
				customSortBy	    =   formObjQueryCriteriaIP.customSortBy.value;
				customSortOrder	    =   formObjQueryCriteriaIP.customSortOrder.value;
				customTabBased	    =   formObjQueryCriteriaIP.customTabBased.value;
				customTabBasedHrs	    =   formObjQueryCriteriaIP.customTabBasedHrs.value;
				if(customTabBased == 'Y' && (customTabBasedHrs=="" || parseInt(customTabBasedHrs)<1)){
					alert(getMessage("TAB_BASED_HRS_CANNOT_BE_ZERO","PH") );
					return false;
				}
			}

			xmlStr	="<root><SEARCH " ;
			xmlStr += " nursing_unit=\"" + formObjQueryCriteriaIP.nursing_unit.value + "\"";
			xmlStr += " priority=\"" + formObjQueryCriteriaIP.priority.value + "\"";
			xmlStr += " patient_id=\"" +patient_id  + "\"";
			xmlStr += " disp_level=\"" + formObjQueryCriteriaIP.disp_level.value + "\"";
			xmlStr += " ip_scope=\"" + formObjQueryCriteriaIP.ip_scope.value + "\"";
			xmlStr += " national_id_no=\"" + formObjQueryCriteriaIP.national_id_no.value + "\"";
			xmlStr += " order_type=\"" + formObjQueryCriteriaIP.order_type.value + "\"";
			xmlStr += " OrderingFacility=\"" + formObjQueryCriteriaIP.OrderingFacility.value + "\"";

			xmlStr += " group_by_ord_locn=\"" + group_by_ord_locn + "\"";
			xmlStr += " include_absolute_orders=\"" + include_absolute_orders + "\"";
			xmlStr += " include_orders_by_freq_durn=\"" + include_orders_by_freq_durn + "\"";	// Added for SRR20056-CRF-0663
			xmlStr += " exclude_PRN_orders=\"" + exclude_PRN_orders + "\"";
			xmlStr += " drug_medical=\"" + formObjQueryCriteriaIP.drug_medical.value + "\"";
			xmlStr += " order_date_from=\"" + convertDate(formObjQueryCriteriaIP.order_date_from.value,dateFormat,language_id,"en") + "\""; //dateFormat Added for MMS-DM-CRF-0228
			xmlStr += " order_date_to=\"" + convertDate(formObjQueryCriteriaIP.order_date_to.value,dateFormat,language_id,"en") + "\""; //dateFormat Added for MMS-DM-CRF-0228
			xmlStr += " tab_based_group_sort_disp=\"" + tab_based_group_sort_disp + "\"";
			xmlStr += " customGroupBy=\"" + customGroupBy + "\"";
			xmlStr += " customGroupOrder=\"" + customGroupOrder + "\"";
			xmlStr += " customSortBy=\"" + customSortBy + "\"";
			xmlStr += " customSortOrder=\"" + customSortOrder + "\"";
			xmlStr += " customTabBased=\"" + customTabBased + "\"";
			xmlStr += " customTabBasedHrs=\"" + customTabBasedHrs + "\"";
			xmlStr += " customTabBasedOption=\"" + customTabBasedOption + "\"";
			xmlStr += " order_id=\"" + formObjQueryCriteriaIP.order_id.value + "\"";//Added for JD-CRF-0181 [IN:40699]
			xmlStr += " bed_no=\"" + formObjQueryCriteriaIP.bed_no.value + "\"";//Added for KDAH-CRF-0338
			xmlStr += " pat_mobile_no=\"" + formObjQueryCriteriaIP.pat_mobile_no.value + "\"";//Added for TH-KW-CRF-0014
			xmlStr += " national_id=\"" + formObjQueryCriteriaIP.national_id_no.value + "\"";//Added for TH-KW-CRF-0014
			xmlStr += " fill_doc_num=\"" + formObjQueryCriteriaIP.fill_doc_num.value + "\"";
			xmlStr +=" /></root>" ;
			//alert("1314"+xmlStr);
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			formObjQueryCriteriaIP.fill_doc_num.value="";
		}
		else{
			var language_id	    =   formObjQueryCriteriaIP.Language_id.value;
			var tab_based_group_sort_disp	    =   formObjQueryCriteriaIP.tab_based_group_sort_disp.value;
			if(tab_based_group_sort_disp == 'Y'){
				customGroupBy	    =   formObjQueryCriteriaIP.customGroupBy.value;
				customGroupOrder	    =   formObjQueryCriteriaIP.customGroupOrder.value;
				customSortBy	    =   formObjQueryCriteriaIP.customSortBy.value;
				customSortOrder	    =   formObjQueryCriteriaIP.customSortOrder.value;
				customTabBased	    =   formObjQueryCriteriaIP.customTabBased.value;
				customTabBasedHrs	    =   formObjQueryCriteriaIP.customTabBasedHrs.value;
				if(customTabBased == 'Y' && (customTabBasedHrs=="" || parseInt(customTabBasedHrs)<1)){
					alert(getMessage("TAB_BASED_HRS_CANNOT_BE_ZERO","PH") );
					return false;
				}
			}
			xmlStr	="<root><SEARCH " ;
			xmlStr += " nursing_unit=\"" + formObjQueryCriteriaIP.nursing_unit.value + "\"";
			xmlStr += " priority=\"" + formObjQueryCriteriaIP.priority.value + "\"";
			xmlStr += " patient_id=\"" + patient_id + "\"";//formObjQueryCriteriaIP.patient_id.value
			if(formObjQueryCriteriaIP.admixture_type!=null){
				xmlStr += " admixture_type=\"" + formObjQueryCriteriaIP.admixture_type.value + "\"";
			}
			xmlStr += " disp_level=\"" + formObjQueryCriteriaIP.disp_level.value + "\"";
			xmlStr += " ip_scope=\"" + formObjQueryCriteriaIP.ip_scope.value + "\"";
			xmlStr += " national_id_no=\"" + formObjQueryCriteriaIP.national_id_no.value + "\"";
			xmlStr += " order_type=\"" + formObjQueryCriteriaIP.order_type.value + "\"";
			xmlStr += " OrderingFacility=\"" + formObjQueryCriteriaIP.OrderingFacility.value + "\"";
			
			xmlStr += " group_by_ord_locn=\"" + group_by_ord_locn + "\"";
			xmlStr += " include_absolute_orders=\"" + include_absolute_orders + "\"";
			xmlStr += " include_orders_by_freq_durn=\"" + include_orders_by_freq_durn + "\"";	// Added for SRR20056-CRF-0663
			xmlStr += " exclude_PRN_orders=\"" + exclude_PRN_orders + "\"";
			xmlStr += " drug_medical=\"" + formObjQueryCriteriaIP.drug_medical.value + "\"";
			xmlStr += " order_date_from=\"" + convertDate(formObjQueryCriteriaIP.order_date_from.value,dateFormat,language_id,"en") + "\""; //dateFormat Added for MMS-DM-CRF-0228
			xmlStr += " order_date_to=\"" + convertDate(formObjQueryCriteriaIP.order_date_to.value,dateFormat,language_id,"en") + "\""; //dateFormat Added for MMS-DM-CRF-0228
			xmlStr += " tab_based_group_sort_disp=\"" + tab_based_group_sort_disp + "\"";
			xmlStr += " customGroupBy=\"" + customGroupBy + "\"";
			xmlStr += " customGroupOrder=\"" + customGroupOrder + "\"";
			xmlStr += " customSortBy=\"" + customSortBy + "\"";
			xmlStr += " customSortOrder=\"" + customSortOrder + "\"";
			xmlStr += " customTabBased=\"" + customTabBased + "\"";
			xmlStr += " customTabBasedHrs=\"" + customTabBasedHrs + "\"";
			xmlStr += " customTabBasedOption=\"" + customTabBasedOption + "\"";
			xmlStr += " order_id=\"" + formObjQueryCriteriaIP.order_id.value + "\"";//Added for JD-CRF-0181 [IN:40699]
			xmlStr += " bed_no=\"" + formObjQueryCriteriaIP.bed_no.value + "\"";//Added for KDAH-CRF-0338
			xmlStr += " pat_mobile_no=\"" + formObjQueryCriteriaIP.pat_mobile_no.value + "\"";//Added for TH-KW-CRF-0014
			xmlStr += " national_id=\"" + formObjQueryCriteriaIP.national_id_no.value + "\"";//Added for TH-KW-CRF-0014
			xmlStr += " disp_locn=\"" + formObjQueryCriteriaIP.disp_locn.value + "\"";  //added By Himanshu Saxena for MMS-DM-CRF-0232 on 10-10-23 Started
			xmlStr += " prescription_num=\"" + formObjQueryCriteriaIP.prescription_num.value + "\"";  //added By Himanshu Saxena for GHL-CRF-0672 on 10-01-24
			xmlStr +=" /></root>" ;
			//alert("1366"+xmlStr);
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			formObjQueryCriteriaIP.prescription_num.value="";
		}
		if(disp_stage=="D" && fill_list=="DWF"){
			//alert("1370");
			 if(formObjQueryCriteriaIP.nursing_unit.value!=''){
				xmlHttp.open( "POST", "DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=storeIPCriteriaValues", false ) ;
				xmlHttp.send( xmlDoc ) ;
				eval(xmlHttp.responseText);
				parent.document.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.btnAdditionalCriteria.disabled =true;
				parent.document.f_query_result.location.href="../../ePH/jsp/DispMedicationDeliveryFrames.jsp";
				parent.document.DispMedicationQueryCriteriaFrameSet.rows="0,20,20,0,220";
				//alert("1377");
			 }
		}
		else{
			//alert("1382");
			if(called_from != 'tab'){
				//alert("1384");
				xmlHttp.open( "POST", "DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=storeIPCriteriaValues", false ) ;
				xmlHttp.send( xmlDoc ) ;
				eval(xmlHttp.responseText);
				//alert(xmlDoc);
				//alert(patient_id);
				parent.f_query_result.DispMedicationPatFrame.location.href="../../ePH/jsp/DispMedicationPatientIDFrame.jsp?patient_id="+patient_id+"&order_id="+formObjQueryCriteriaIP.order_id.value;//Added for JD-CRF-0181
				//alert("1391");
				//parent.document.DispMedicationQueryCriteriaFrameSet.rows="0,20,30,0,*"; ;//code '0,135,20,0,365' replaced by '0,30,20,0,*' added for Bru-HIMS-CRF-416[IN045566]
				//alert("1393");
				parent.document.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.btnHideShowCriteria.value=getLabel("ePH.ShowCriteria.label","PH");//code added for Bru-HIMS-CRF-416[IN045566]
				//alert("1388");
			}
			else{
				xmlHttp.open( "POST", "DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=storeIPCriteriaValues", false ) ;
				xmlHttp.send( xmlDoc ) ;
				eval(xmlHttp.responseText);
				document.location.href="../../ePH/jsp/DispMedicationPatientIDDisplay.jsp?patient_id="+patient_id+"&order_id="+formObjQueryCriteriaIP.order_id.value;//Added for JD-CRF-0181
				//alert("1395");
			}
		}
		parent.document.getElementById("f_query_criteria_token_info").style.height="0vh";
		parent.document.getElementById("f_query_criteria").style.height="5vh";
		parent.document.getElementById("f_query_criteria_buttons").style.height="5vh";
		parent.document.getElementById("f_query_criteria_additional").style.height="0vh";
		parent.document.getElementById("f_query_result").style.height="90vh";
	}
	else if(disp_locn_catg=="IAE")	//added By Himanshu Saxena for MMS-DM-CRF-0232 on 10-11-23 Started
	{
		var formObjQueryCriteriaIP = formIPCriteira;
		var patient_id='';
		if(fill_list!="DWF")
			patient_id = formObjQueryCriteriaIP.patient_id.value;
		var bean_id		= formObjQueryCriteriaIP.bean_id.value ;
		var bean_name	= formObjQueryCriteriaIP.bean_name.value ;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		var language_id	    =   formObjQueryCriteriaIP.Language_id.value;
		var tab_based_group_sort_disp	    =   formObjQueryCriteriaIP.tab_based_group_sort_disp.value;
		var dateFormat = ""; //added for MMS-DM-CRF-0228 start
		var ph_print_prescription = formObjQueryCriteriaIP.ph_print_prescription.value;
		if(ph_print_prescription=="true"){
			dateFormat = "DMYHM";
		}
		else{
			dateFormat = "DMY";//added for MMS-DM-CRF-0228 end
		}//added for MMS-DM-CRF-0228 end
		
			if(tab_based_group_sort_disp == 'Y'){
				customGroupBy	    =   formObjQueryCriteriaIP.customGroupBy.value;
				customGroupOrder	    =   formObjQueryCriteriaIP.customGroupOrder.value;
				customSortBy	    =   formObjQueryCriteriaIP.customSortBy.value;
				customSortOrder	    =   formObjQueryCriteriaIP.customSortOrder.value;
				customTabBased	    =   formObjQueryCriteriaIP.customTabBased.value;
				customTabBasedHrs	    =   formObjQueryCriteriaIP.customTabBasedHrs.value;
				if(customTabBased == 'Y' && (customTabBasedHrs=="" || parseInt(customTabBasedHrs)<1)){
					alert(getMessage("TAB_BASED_HRS_CANNOT_BE_ZERO","PH") );
					return false;
				}
			}
			xmlStr	="<root><SEARCH " ;
			xmlStr += " nursing_unit=\"" + formObjQueryCriteriaIP.nursing_unit.value + "\"";
			xmlStr += " priority=\"" + formObjQueryCriteriaIP.priority.value + "\"";
			xmlStr += " patient_id=\"" + patient_id + "\"";//formObjQueryCriteriaIP.patient_id.value
			if(formObjQueryCriteriaIP.admixture_type!=null){
				xmlStr += " admixture_type=\"" + formObjQueryCriteriaIP.admixture_type.value + "\"";
			}
			xmlStr += " disp_level=\"" + formObjQueryCriteriaIP.disp_level.value + "\"";
			xmlStr += " ip_scope=\"" + formObjQueryCriteriaIP.ip_scope.value + "\"";
			xmlStr += " national_id_no=\"" + formObjQueryCriteriaIP.national_id_no.value + "\"";
			xmlStr += " order_type=\"" + formObjQueryCriteriaIP.order_type.value + "\"";
			xmlStr += " OrderingFacility=\"" + formObjQueryCriteriaIP.OrderingFacility.value + "\"";
			
			xmlStr += " group_by_ord_locn=\"" + group_by_ord_locn + "\"";
			xmlStr += " include_absolute_orders=\"" + include_absolute_orders + "\"";
			xmlStr += " include_orders_by_freq_durn=\"" + include_orders_by_freq_durn + "\"";	// Added for SRR20056-CRF-0663
			xmlStr += " exclude_PRN_orders=\"" + exclude_PRN_orders + "\"";
			xmlStr += " drug_medical=\"" + formObjQueryCriteriaIP.drug_medical.value + "\"";
			xmlStr += " order_date_from=\"" + convertDate(formObjQueryCriteriaIP.order_date_from.value,dateFormat,language_id,"en") + "\""; //dateFormat added for MMS-DM-CRF-0228
			xmlStr += " order_date_to=\"" + convertDate(formObjQueryCriteriaIP.order_date_to.value,dateFormat,language_id,"en") + "\""; //dateFormat added for MMS-DM-CRF-0228
			xmlStr += " tab_based_group_sort_disp=\"" + tab_based_group_sort_disp + "\"";
			xmlStr += " customGroupBy=\"" + customGroupBy + "\"";
			xmlStr += " customGroupOrder=\"" + customGroupOrder + "\"";
			xmlStr += " customSortBy=\"" + customSortBy + "\"";
			xmlStr += " customSortOrder=\"" + customSortOrder + "\"";
			xmlStr += " customTabBased=\"" + customTabBased + "\"";
			xmlStr += " customTabBasedHrs=\"" + customTabBasedHrs + "\"";
			xmlStr += " customTabBasedOption=\"" + customTabBasedOption + "\"";
			xmlStr += " order_id=\"" + formObjQueryCriteriaIP.order_id.value + "\"";
			xmlStr += " bed_no=\"" + formObjQueryCriteriaIP.bed_no.value + "\"";
			xmlStr += " pat_mobile_no=\"" + formObjQueryCriteriaIP.pat_mobile_no.value + "\"";
			xmlStr += " national_id=\"" + formObjQueryCriteriaIP.national_id_no.value + "\"";
			xmlStr += " disp_locn=\"" + formObjQueryCriteriaIP.disp_locn.value + "\"";
			xmlStr +=" /></root>" ;
			//alert("1466"+xmlStr);
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			if(called_from != 'tab')
			{
				xmlHttp.open( "POST", "DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=storeIPCriteriaValues", false ) ;
				xmlHttp.send( xmlDoc ) ;
				eval(xmlHttp.responseText);
				parent.f_query_result.DispMedicationPatFrame.location.href="../../ePH/jsp/DispMedicationPatientIDFrame.jsp?patient_id="+patient_id+"&order_id="+formObjQueryCriteriaIP.order_id.value;
				//parent.document.DispMedicationQueryCriteriaFrameSet.rows="0,20,30,0,*"; 
				parent.document.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.btnHideShowCriteria.value=getLabel("ePH.ShowCriteria.label","PH");
			}
			else
			{
				xmlHttp.open( "POST", "DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=storeIPCriteriaValues", false ) ;
				xmlHttp.send( xmlDoc ) ;
				eval(xmlHttp.responseText);
				document.location.href="../../ePH/jsp/DispMedicationPatientIDDisplay.jsp?patient_id="+patient_id+"&order_id="+formObjQueryCriteriaIP.order_id.value;
			}
			parent.document.getElementById("f_query_criteria_token_info").style.height="0vh";
			parent.document.getElementById("f_query_criteria").style.height="5vh";
			parent.document.getElementById("f_query_criteria_buttons").style.height="5vh";
			parent.document.getElementById("f_query_criteria_additional").style.height="0vh";
			parent.document.getElementById("f_query_result").style.height="90vh";
	}
	//alert("1466");
}

function storeAdditionalCriteria(){

	var formObj = parent.document.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons;
	formObj.btnAdditionalCriteria.disabled = false;
	var formObjAddCriteria    = parent.document.f_query_criteria_additional.frmDispMedicationQueryCriteriaAdditional;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();

	var bean_id			= formObjAddCriteria.bean_id.value;
	var bean_name		= formObjAddCriteria.bean_name.value;
	//var selected_text	=	formObjAddCriteria.nationality.options[formObjAddCriteria.nationality.selectedIndex].text;
	var selected_value	=   formObjAddCriteria.nationality.value;

	/*if(selected_value!="")
		parent.f_query_criteria.document.getElementById("lbl_nationality").innerText = selected_text;
	else 
		parent.f_query_criteria.document.getElementById("lbl_nationality").innerText = "";
*/
	if(formObjAddCriteria.practitioner_name.value=="") {
		formObjAddCriteria.practitioner_id.value="";
	}
	
	if(formObjAddCriteria.nationality_name.value=="") {//Adding start for ARYU-SCF-0073
		formObjAddCriteria.nationality.value="";
	}//Adding end for ARYU-SCF-0073 

	xmlStr	="<root><SEARCH " ;
	xmlStr += " practitioner_id=\"" + formObjAddCriteria.practitioner_id.value + "\"";
	xmlStr += " practitioner_name=\"" +encodeURIComponent(formObjAddCriteria.practitioner_name.value,'UTF-8')  + "\""; 
	xmlStr += " gender=\"" + formObjAddCriteria.gender.value + "\"";
	xmlStr += " nationality=\"" + formObjAddCriteria.nationality.value + "\"";
	xmlStr += " nationality_desc=\"" + encodeURIComponent(formObjAddCriteria.nationality_name.value,'UTF-8') + "\"";
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=storeAdditionalCriteriaValues", false ) ;
	xmlHttp.send( xmlDoc ) ;
	document.location.href="../../eCommon/html/blank.html";	
}

function cancelAdditionalCriteria(){
	var formObj = parent.document.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons;
	formObj.btnAdditionalCriteria.disabled = false;
	var formObjAddCriteria    = parent.document.f_query_criteria_additional.frmDispMedicationQueryCriteriaAdditional;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();

	var bean_id		= formObjAddCriteria.bean_id.value;
	var bean_name	= formObjAddCriteria.bean_name.value;

	xmlStr	="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=clearAdditionalCriteriaValues", false ) ;
	xmlHttp.send( xmlDoc ) ;
	document.location.href="../../eCommon/html/blank.html";
}

async function searchNursingUnit(target){
	
	var formObj = document.frmDispMedicationQueryCriteriaIP;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var language_id    = formObj.Language_id.value;
	var ordering_facility_id = formObj.OrderingFacility.options[formObj.OrderingFacility.selectedIndex].value;

	dataNameArray[0]   = "FACILITY_ID" ;
	dataValueArray[0]  = ordering_facility_id;
	dataTypeArray[0]   = STRING ;
	
	var parNameArray  = new Array() ;
	var parValueArray  = new Array() ;
	parNameArray[0] ="~LOCALE_ID`";
	parValueArray[0]=language_id;

	//argumentArray[0]   = "SELECT NURSING_UNIT_CODE CODE, SHORT_DESC DESCRIPTION FROM IP_NURSING_UNIT_LANG_VW IP_NURSING_UNIT WHERE EFF_STATUS='E' AND FACILITY_ID LIKE UPPER(?) AND upper(NURSING_UNIT_CODE) LIKE upper(?) AND upper(SHORT_DESC) LIKE upper(?) AND LANGUAGE_ID = "+"'"+language_id+"'";//SQL_PH_ALT_DISP_LOCN_SELECT1D changed for  ML-BRU-SCF-1591 [IN:055119] //Modified for MOHE-SCF-0132
	argumentArray[0]   = "";
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "2,3";
	argumentArray[5]   = target.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = CODE_DESC ;

	argumentArray[12]  = "SQL_PH_DISPMEDICATIONIP_NURSING_SELECT";
	argumentArray[13]  = "ePH.Common.PhRepository";
	argumentArray[14]  = parNameArray
	argumentArray[15]  = parValueArray
	
	var retVal = await CommonLookup( getLabel("Common.nursingUnit.label","Common"), argumentArray );
	var ret1=unescape(retVal);
	var arr=ret1.split(",");	
	if(retVal != null && retVal != "" )  {
		formObj.nursing_unit.value = arr[0] ;
		target.value = arr[1] ;
		target.disabled = true;
	}
}

async function searchCode(target,disp_locn_catg,identity){
	
	
	var formObj;
	var ord_loc_type   ="";
	var language_id    ="";
	
	if(identity=="L"){
		formObj = document.frmDispMedicationQueryCriteria;
		 ord_loc_type   = formObj.ord_loc_type.value;
		 language_id    = formObj.Language_id.value;
	}
	else if(identity=="P"){
		formObj = document.frmDispMedicationQueryCriteriaAdditional;
	}
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	
	var parNameArray  = new Array() ;
	var parValueArray  = new Array() ;
	parNameArray[0] ="~LOCALE_ID`";
	parValueArray[0]=language_id;
	
	if(identity=="L"){
			
		var ordering_facility_id = formObj.OrderingFacility.options[formObj.OrderingFacility.selectedIndex].value;
					
		dataNameArray[0]   = "facility_id" ;
		dataValueArray[0]  = ordering_facility_id;
		dataTypeArray[0]   = STRING ;
		//argumentArray[0]   = formObj.SQL_PH_DISP_MEDICATION_SELECT10.value;
		var queryString="";
		if(ord_loc_type=='C'){
			//argumentArray[0]   = "SELECT CLINIC_CODE CODE, LONG_DESC DESCRIPTION  FROM OP_CLINIC_LANG_VW OP_CLINIC WHERE  UPPER(FACILITY_ID) LIKE UPPER(?)  AND Upper(CLINIC_CODE) like Upper(?) AND Upper(LONG_DESC) LIKE Upper(?) AND EFF_STATUS='E'  AND CLINIC_TYPE ='C' AND  LANGUAGE_ID = "+"'"+language_id+"'"; //Modified for MOHE-SCF-0132
			queryString="SQL_PH_DISPMEDICATIONIP_CLINIC_SELECT";
		}
		else{
			//argumentArray[0]   = "SELECT NURSING_UNIT_CODE CODE, SHORT_DESC DESCRIPTION FROM IP_NURSING_UNIT_LANG_VW IP_NURSING_UNIT WHERE EFF_STATUS='E' AND FACILITY_ID LIKE UPPER(?) AND upper(NURSING_UNIT_CODE) LIKE upper(?) AND upper(SHORT_DESC) LIKE upper(?) AND LANGUAGE_ID = "+"'"+language_id+"'";//SQL_PH_ALT_DISP_LOCN_SELECT1D changed for  ML-BRU-SCF-1591 [IN:055119] //Modified for MOHE-SCF-0132
			queryString="SQL_PH_DISPMEDICATIONIP_NURSING_SELECT";
		}
		argumentArray[0]   ="";
		argumentArray[1]   = dataNameArray ;
		argumentArray[2]   = dataValueArray ;
		argumentArray[3]   = dataTypeArray ;
		argumentArray[4]   = "2,3";
		argumentArray[5]   = target.value ;
		argumentArray[6]   = DESC_LINK ;
		argumentArray[7]   = CODE_DESC ;
		
		argumentArray[12]  = queryString;
		argumentArray[13]  = "ePH.Common.PhRepository";
		argumentArray[14]  = parNameArray
		argumentArray[15]  = parValueArray

		var retVal = await CommonLookup( getLabel("Common.OrderingLocation.label","Common"), argumentArray );
		var str =unescape(retVal);
		var arr = str.split(",");
		if(retVal != null && retVal != "" )  {
			formObj.ord_locn_code.value = arr[0] ;
			target.value = arr[1] ;
		}
	}
	else if(identity=="P"){
		//argumentArray[0]   = formObj.SQL_PH_DISP_MEDICATION_SELECT11.value;
		argumentArray[0]   ="";
		argumentArray[1]   = dataNameArray ;
		argumentArray[2]   = dataValueArray ;
		argumentArray[3]   = dataTypeArray ;
		argumentArray[4]   = "1,2";
		argumentArray[5]   = target.value ;
		argumentArray[6]   = DESC_LINK ;
		argumentArray[7]   = CODE_DESC ;
		
		argumentArray[12]  = "SQL_PH_DISP_MEDICATION_SELECT11";
		argumentArray[13]  = "ePH.Common.PhRepository";
		argumentArray[14]  = parNameArray
		argumentArray[15]  = parValueArray

		var retVal = await CommonLookup( getLabel("Common.practitioner.label","Common"), argumentArray );
	var ret1=unescape(retVal);
	var arr=ret1.split(",");		
		if(retVal != null && retVal != "" )  {
			formObj.practitioner_id.value=arr[0];
			target.value = arr[1] ;
		}
	}
}
function clearvalues(obj1,obj2){
	obj1.value ="";
	obj2.value="";
}

function validateTokenNo(token_no,from){
	var formObj			= parent.f_query_criteria_token_info.document.frmDispMedicationQueryCriteriaTokenInfo;
	//token_series	=	formObj.token_series.value;
	if(token_no=='')
		return false;
	if(from == "btnNextToken"){
		populateToken(formObj, 'btnNextToken' );
	}
	else{
		var token_no = parseFloat(trimString(token_no.value)) ;
		//token_series	=	parent.f_query_criteria_token_info.document.frmDispMedicationQueryCriteriaTokenInfo.token_series.value;
		validateToken(parent.f_query_criteria_token_info.document.frmDispMedicationQueryCriteriaTokenInfo);
		return true;
	}		
}

function collapse(rec,tmp_rec, patient_id) {
	formObj	=	parent.patient_id_display.frmDispMedicationPatientIDDisplay;
	tot_rec	=	parent.patient_id_display.frmDispMedicationPatientIDDisplay.tot_rec.value;
	var disp_locn_catg = parent.parent.parent.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.disp_locn_catg.value;
	var print_yn=	parent.patient_id_display.frmDispMedicationPatientIDDisplay.print_yn.value;
	var scope =  "";
	var orderType= formObj.orderType.value;
	//var lock_status=formObj.lock_status.value;
	if(disp_locn_catg=="O") {
		 scope = parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteria.order_status.value;
	}
	parent.patient_id_display.document.getElementById('header').style.display='none';
	if(parent.patient_id_display.document.getElementById('nav_table')!=null)
		parent.patient_id_display.document.getElementById('nav_table').style.display='none';
	tab_based_group_sort_disp = document.frmDispMedicationPatientIDDisplay.tab_based_group_sort_disp.value;
	if(tab_based_group_sort_disp == 'Y')
		document.getElementById("customGroupTable").style.display='none';

	var bean_id		= "DispMedicationBean";
	var bean_name	= "ePH.DispMedicationBean";
	var xmlDoc  = "";
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr += " recIndex=\""+rec+"\"";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&patient_id="+patient_id+"&identity=CheckForAppointments",false);
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);

	for(i=0; i<tot_rec; i++){
		parent.patient_id_display.document.getElementById("tr_"+i).style.display='none';
        /* if(eval("parent.patient_id_display.document.getElementById("appt_list_")"+i)!=undefined){
		    eval("parent.patient_id_display.document.getElementById("appt_list_")"+i+".style='display'");
        } */

		if(i==rec) {
			parent.patient_id_display.document.getElementById("all_det_"+i).style='display';


			if(scope!='EX') {
				parent.patient_id_display.document.getElementById("all_det_th_"+i).style='display';
			}
			if(disp_locn_catg=="O" && print_yn=="Y"){
				parent.patient_id_display.document.getElementById("print_pres_"+i).style='display';
			}			
		}

		if(tmp_rec!=undefined && scope!='EX'){
			try{
				parent.patient_id_display.document.getElementById("th_"+i).style.display='none';
				if(parent.patient_id_display.document.getElementById("th1")!=null){
					var lengt = parent.patient_id_display.document.getElementById("th1").length;
					if(lengt != undefined ){
						for(var k=0; k<lengt; k++){
							parent.patient_id_display.document.getElementById("th1")[k].style.display='none';
						}
					}
				}	
				if(parent.patient_id_display.document.getElementById("th2")!=null){
					var lengt = parent.patient_id_display.document.getElementById("th2").length;
					if(lengt != undefined ){
						for(var k=0; k<lengt; k++){
							parent.patient_id_display.document.getElementById("th2")[k].style.display='none';
						}
					}
				}
			}
			catch (e){}
		} 
	}

	//parent.parent.DispMedicationDetailFrameSet.removeAttribute("cols");
	//parent.parent.DispMedicationDetailFrameSet.setAttribute("rows");

	//if(orderType != null && (orderType == 'ALL' || orderType == 'CDR')) // CDR Condition Added for ML-MMOH-CRF-0435 [IN:057357]
		//parent.parent.DispMedicationDetailFrameSet.rows="95%,5%";
	//else
	//parent.parent.DispMedicationDetailFrameSet.rows="17%,*";
	//parent.parent.DispMedicationDetailSubFrameSet_1.removeAttribute("cols");
	//parent.parent.DispMedicationDetailSubFrameSet_1.setAttribute("cols");
	//parent.parent.DispMedicationDetailSubFrameSet_1.cols="35%,*";
	//parent.parent.DispMedicationDetailSubFrameSet_2.removeAttribute("rows");
	//parent.parent.DispMedicationDetailSubFrameSet_2.setAttribute("rows");
	//parent.parent.DispMedicationDetailSubFrameSet_2.rows="0%,100%";
	
	parent.parent.DispMedicationDetailSubFrameSet_1.style.flexDirection="row";
	parent.parent.DispMedicationDetailSubFrameSet_1.style.height="20vh";
	parent.parent.DispMedicationDetailSubFrameSet_2.style.display="flex";
	parent.parent.DispMedicationPatDetFrame_1.style="display";
	
	parent.parent.document.getElementById('DispMedicationPatFrame').style.height="20vh";
	parent.parent.document.getElementById('DispMedicationPatFrame').style.width="34vw";
	parent.parent.DispMedicationPatFrame.document.getElementById('patient_id_locator').style.height="40vh";
	parent.parent.DispMedicationPatFrame.document.getElementById('patient_id_pagination').style.display="none";
	parent.parent.DispMedicationPatFrame.document.getElementById('patient_id_display').style.height="54vh";	
	
	parent.parent.document.getElementById('DispMedicationPatDetFrame_1').style="display";
	parent.parent.document.getElementById('DispMedicationPatDetFrame_1').style.height="20vh";
	parent.parent.document.getElementById('DispMedicationPatDetFrame_1').style.width="65vw";
	
	parent.parent.document.getElementById('DispMedicationPatDetFrame_2').style.display="none";
	parent.parent.document.getElementById('DispMedicationPatDetFrame_3').style.height="79vh";
	parent.parent.document.getElementById('DispMedicationPatDetFrame_3').style.width="99vw";
	
	
	if(parent.patient_id_locator.frmPatientIDLocator != undefined){
		parent.patient_id_locator.document.getElementById('bt').style="display";
		//parent.patient_id_locator.frmPatientIDLocator.bt.style.visibility="visible";
	}
	//parent.parent.DispMedicationPatDetFrame_1.document.getElementById('patient_details').style.height="70vh";

}
  //This method use for Icon Remove only.
 function dispAppointmentDtl(recIndex, next_appt_days){
	if(parent.patient_id_display.document.getElementById('appt_list_'+recIndex)!=undefined){
		parent.patient_id_display.document.getElementById('appt_list_'+recIndex).style='display';
		parent.patient_id_display.document.getElementById('next_appt_days'+recIndex).innerHTML="<B>("+next_appt_days+")</B>";
	} 
 }

function expand() {
	/*parent.parent.DispMedicationDetailFrameSet.setAttribute("rows","");
	parent.parent.DispMedicationDetailFrameSet.setAttribute("cols","100%,0%");
	//parent.parent.DispMedicationDetailFrameSet.cols="100%,0%";
	parent.parent.DispMedicationDetailSubFrameSet_1.setAttribute("cols","");
	parent.parent.DispMedicationDetailSubFrameSet_1.setAttribute("cols","100%,0%");
	//parent.parent.DispMedicationDetailSubFrameSet_1.cols="100%,0%";
	parent.parent.DispMedicationDetailSubFrameSet_2.setAttribute("rows","");
	parent.parent.DispMedicationDetailSubFrameSet_2.setAttribute("rows","20%,80%");
	//parent.parent.DispMedicationDetailSubFrameSet_2.rows="20%,80%";
*/	
	// Change the flex layout for the parent container DispMedicationDetailFrameSet
	parent.parent.DispMedicationDetailFrameSet.style.display = "flex";
	parent.parent.DispMedicationDetailFrameSet.style.flexDirection = "column";  // Set to "row" if you need a horizontal layout

	// Update the layout of DispMedicationDetailSubFrameSet_1 (for first subframe)
	parent.parent.DispMedicationDetailSubFrameSet_1.style.display = "flex";
	parent.parent.DispMedicationDetailSubFrameSet_1.style.display = "column";
	parent.parent.DispMedicationDetailSubFrameSet_1.style.height = "92vh";
	console.log(parent.parent.DispMedicationDetailSubFrameSet_1)
	console.log(parent.parent.document.getElementById('DispMedicationPatFrame'))
	parent.parent.document.getElementById('DispMedicationPatFrame').style.height ="90vh";
	parent.parent.document.getElementById('DispMedicationPatFrame').style.width ="99vw";
	parent.parent.document.getElementById('DispMedicationPatDetFrame_1').style.display ="none";
	
	
	
	
	
	

	// Update the layout of DispMedicationDetailSubFrameSet_2 (for second subframe)
	parent.parent.DispMedicationDetailSubFrameSet_2.style.display = "none";
	parent.parent.DispMedicationDetailSubFrameSet_2.style.flexDirection = "row";  // Adjust as per layout (row or column)

	/*// Adjust the height/width of iframes inside the divs as needed
	parent.parent.DispMedicationPatFrame.style.height = "90vh";  // Adjust height
	parent.parent.DispMedicationPatFrame.style.width = "99vw";   // Adjust width
	parent.parent.DispMedicationPatDetFrame_1.style.height = "0vh"; // Adjust height (set to 0 for hidden)
	parent.parent.DispMedicationPatDetFrame_1.style.width = "99vw"; // Adjust width
	parent.parent.DispMedicationPatDetFrame_2.style.height = "90vh";  // Adjust height
	parent.parent.DispMedicationPatDetFrame_2.style.width = "20vw";   // Adjust width
	parent.parent.DispMedicationPatDetFrame_3.style.height = "90vh";  // Adjust height
	parent.parent.DispMedicationPatDetFrame_3.style.width = "70vw";   // Adjust width
*/
	var formObj = parent.document.patient_id_display.frmDispMedicationPatientIDDisplay;
	var disp_locn_catg = parent.parent.parent.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.disp_locn_catg.value;
    
	var scope =  "";	
	if(disp_locn_catg=="O") {
		 scope = parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteria.order_status.value;
	}

	if(formObj != null || formObj != undefined){
/*		var row_no = formObj.patientiddisplaytable.rows.length;
		if(disp_locn_catg=="I"){	// I -Inpatient
			for (var i=1;i<row_no ; i++){
				if(formObj.patientiddisplaytable.rows[i].cells[0].style.backgroundColor=="#fde6d0"){
					formObj.patientiddisplaytable.rows[i].cells[0].style.backgroundColor="";
				}
			}
		}else{
			for (var i=0;i<row_no ; i++){
				if(formObj.patientiddisplaytable.rows[i].cells[0].style.backgroundColor=="#fde6d0"){
					formObj.patientiddisplaytable.rows[i].cells[0].style.backgroundColor="";
				}
			}
		}*/
	tot_rec	=	parent.patient_id_display.frmDispMedicationPatientIDDisplay.tot_rec.value;
	var print_yn=	parent.patient_id_display.frmDispMedicationPatientIDDisplay.print_yn.value;

	parent.patient_id_display.document.getElementById('header').style="display";
		
	if(parent.patient_id_display.document.getElementById('nav_table')!=null)
		parent.patient_id_display.document.getElementById('nav_table').style="display";

	for(i=0; i<tot_rec; i++){
	parent.patient_id_display.document.getElementById('tr_'+i).style="display";
		parent.patient_id_display.document.getElementById('all_det_'+i).style.display='none';
		if(parent.patient_id_display.document.getElementById('appt_list_'+i)!=undefined){
			parent.patient_id_display.document.getElementById('appt_list_'+i).style.display='none';
       }
		
		if(scope!="EX"){
			parent.patient_id_display.document.getElementById("th_"+i).style="display";
			parent.patient_id_display.document.getElementById("all_det_th_"+i).style.display='none';
			if(parent.patient_id_display.document.getElementById("th1")!=null){
			    parent.patient_id_display.document.getElementById("th1").style="display";
			}
			if(parent.patient_id_display.document.getElementById('th2')!=null){
		        parent.patient_id_display.document.getElementById('th2').style="display";
			}

		}
		if(disp_locn_catg=="O" && print_yn=="Y"){
				parent.patient_id_display.document.getElementById('print_pres_'+i).style.display='none';
		}
		
	}
       //hide the restore link
		if(parent.patient_id_locator.frmPatientIDLocator != undefined){
		parent.patient_id_locator.frmPatientIDLocator.bt.style.display="none";
		parent.patient_id_locator.frmPatientIDLocator.bt.style.visibility="hidden";
		}
	
	}
	parent.parent.DispMedicationPatDetFrame_1.location.href="../../eCommon/html/blank.html";
	parent.parent.DispMedicationPatDetFrame_2.location.href="../../eCommon/html/blank.html";
	parent.parent.DispMedicationPatDetFrame_3.location.href="../../eCommon/html/blank.html";
	if(parent.patient_id_locator.frmPatientIDLocator != undefined){
		parent.patient_id_display.scrolling="auto";
	}
	//alert("----------------1877-------------");
}

function showAnAlertForTokenNumber(applicable,next_token_no){

	if (applicable=="N"){
		alert(getMessage("PH_INVALID_TOKEN_NO","PH"));
		token_valid_flag = false;
		if(document.frmDispMedicationQueryCriteriaTokenInfo != undefined){
			document.frmDispMedicationQueryCriteriaTokenInfo.token_no.select();
			document.frmDispMedicationQueryCriteriaTokenInfo.token_no.focus();
			return;
		}
	}
	else{
		token_valid_flag = true;
		parent.f_query_criteria_token_info.frmDispMedicationQueryCriteriaTokenInfo.token_no.value= next_token_no;
	}
}
function validateWSForTokenSeries(obj){
	if(obj=="N"){
		alert(getMessage("PH_INVALID_TOKEN_SERIES_FOR_WORK_STATION","PH"));
		window.returnValue="GOHOME";
	}
	else{
		window.returnValue="GOQUERYCRITERIA";
	}
}
function WSForTokenSeriesNotApplicable(){
	window.returnValue="GOQUERYCRITERIA";
}
function clearTextFromPatientIdLocator(){
	var formObj =document.frmPatientIDLocator;        
	if (formObj.patient_id_locator.value==""){
		formObj.patient_id_locator.value="Enter Patient ID To ";
	}
}
function locatePatientID(){
	//expand(); //Commented for AAKH-SCF-0062[IN040468]
	var disp_locn_catg		= document.frmPatientIDLocator.disp_locn_catg.value;
	var patient_id_locator	=document.frmPatientIDLocator.patient_id_locator.value;
	var fill_list			=document.frmPatientIDLocator.fill_list.value; //Added for MMS Stess - Patient ID locator script error -start
	/* if(fill_list=="AF")// commented for [IN:055192]
		parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteriaIP.patient_id=patient_id_locator; //Added for MMS Stess - Patient ID locator script error -end*/
	if(patient_id_locator!=""){ //if block added for AAKH-SCF-0062[IN040468]
	    if(disp_locn_catg=="O"){
			var issue_token		= parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteria.issue_token_on_regn.value; //Added for  [IN:054559]  
			if(issue_token == 'Y'){  //if block and else condition Added for  [IN:054559] 
				parent.parent.parent.f_query_criteria_token_info.frmDispMedicationQueryCriteriaTokenInfo.patient_id.value=patient_id_locator;
				parent.parent.parent.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.btnSearch.click();
				parent.parent.parent.f_query_criteria_token_info.frmDispMedicationQueryCriteriaTokenInfo.patient_id.value="";
			}
			else{
				parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteria.patient_id.value=patient_id_locator;
				parent.parent.parent.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.btnSearch.click();
				parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteria.patient_id.value=""; 
			}
		}	
		else{
		   parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteriaIP.patient_id.value=patient_id_locator;
		   parent.parent.parent.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.btnSearch.click();
		   parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteriaIP.patient_id.value=""; 
		}        		
	}	
   	/*var formObj				= parent.document.patient_id_display.frmDispMedicationPatientIDDisplay;  //Commented for AAKH-SCF-0062[IN040468]- start
	var locate_page_entered	= false;
	//var row_no = formObj.patientiddisplaytable.rows.length;
	var row_no	=	parseInt(formObj.tot_rec.value);

	if(disp_locn_catg=="I"){	// I - Inpatient
		/*for (var i=1;i<row_no ; i++){
			if(formObj.patientiddisplaytable.rows[i].cells[0].style.backgroundColor=="#fde6d0"){
				formObj.patientiddisplaytable.rows[i].cells[0].style.backgroundColor="";
			}
		} //Comment close - removed for AAKH-SCF-0062[IN040468]

		for (var i=0;i<row_no ; i++){
			if (eval("formObj.patient_id"+i).value==trimString(patient_id_locator)){				
				eval("formObj.patient_id_label"+i).scrollIntoView();
				eval("formObj.patient_id_label"+i).click()
				//formObj.patientiddisplaytable.rows[i].cells[0].style.backgroundColor	= "#fde6d0";
				document.frmPatientIDLocator.patient_id_locator.value="";
				clearTextFromPatientIdLocator();
				return false;
			}
		}
	}
	else{
		/*for (var i=0;i<row_no ; i++){
			if(formObj.patientiddisplaytable.rows[i].cells[0].style.backgroundColor=="#fde6d0"){
				formObj.patientiddisplaytable.rows[i].cells[0].style.backgroundColor="";
			}
		} //Comment close - removed for AAKH-SCF-0062[IN040468]
		for (var i=0;i<row_no ; i++){
			if (eval("formObj.patient_id"+i).value==trimString(patient_id_locator)){
				eval("formObj.patient_id_label"+i).scrollIntoView();
				eval("formObj.patient_id_label"+i).click()
				//formObj.patientiddisplaytable.rows[i].cells[0].style.backgroundColor	= "#fde6d0";
				document.frmPatientIDLocator.patient_id_locator.value="";
				clearTextFromPatientIdLocator();
				return false;
			}
		}
	}
	//search the patient's page
	locatePage(trimString(patient_id_locator));
	locate_page_entered	=	true;

	if(!locate_page_entered) {
		alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
		clearTextFromPatientIdLocator();
	}  */ //Commented for AAKH-SCF-0062[IN040468] -End
}

function reset(){
	var formObj = document.f_query_add_mod.f_query_criteria.frmDispMedicationQueryCriteria;
	var issue_token_on_regn = "";
	var disp_locn_catg		= "I";	// I - Inpatient

	if(formObj != null){
		issue_token_on_regn = formObj.issue_token_on_regn.value;
		disp_locn_catg  = formObj.disp_locn_catg.value;
		function_id =document.f_query_add_mod.f_query_criteria.frmDispMedicationQueryCriteria.function_id.value;
	}
	else{
		function_id =document.f_query_add_mod.f_query_criteria.frmDispMedicationQueryCriteriaIP.function_id.value;
	}
	document.f_query_add_mod.location.href="../../ePH/jsp/DispMedicationQueryCriteriaFrameSet.jsp?issue_token_on_regn="+issue_token_on_regn+"&disp_locn_catg="+disp_locn_catg+"&function_id="+function_id;
	return false;

}
function displayOrdersForPatient(row_no,patient_id,patient_name,sex,age,nursing_unit, Ordering_Facility_id){
/* To Clear selected Transaction Order ids in the bean -- start -------- */
	var bean_id		= "DispMedicationBean";
	var bean_name	= "ePH.DispMedicationBean";
	var patient_class = eval("frmDispMedicationPatientIDDisplay.patient_class"+row_no).value;
	var encounter_id = eval("frmDispMedicationPatientIDDisplay.encounter_id"+row_no).value; // Added for GHL-CRF-0549	
	var bed_num = ""; // bed_num Added for KDAH-CRF-0338 - Start
	if(eval("frmDispMedicationPatientIDDisplay.bed_num"+row_no)!=undefined)
	   bed_num = eval("frmDispMedicationPatientIDDisplay.bed_num"+row_no).value; // bed_num Added for KDAH-CRF-0338 - End
	var locn_code = ""; // bed_num Added for BSP-SCF-0060 - Start
	if(eval("frmDispMedicationPatientIDDisplay.locn_code"+row_no)!=undefined)
		locn_code = eval("frmDispMedicationPatientIDDisplay.locn_code"+row_no).value; // locn_code Added for BSP-SCF-0060 - End
	
	if(eval("frmDispMedicationPatientIDDisplay.prescription_number_code"+row_no)!=undefined){
		var prescription_number_code = eval("frmDispMedicationPatientIDDisplay.prescription_number_code"+row_no).value;
	}
	//var xmlDoc  = new ActiveXObject( "Microsoft.XMLDom" ) ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr += " Ordering_Facility_id=\""+Ordering_Facility_id+"\"";
	xmlStr += " row_no=\""+row_no+"\"";//Added for Release Batch
	xmlStr += " patient_class=\""+patient_class+"\"";//Added for Release Batch
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=clearTrxOrderIds",false);
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);
	var order_id="";
	//alert("form name=="+eval("frmDispMedicationPatientIDDisplay.refresh_pat_details").value)
	frmDispMedicationPatientIDDisplay.refresh_pat_details.value ="NO";//Added for TH-KW-CRF-0011
	
	//alert(parent.parent.DispMedicationPatFrame.patient_id_display.refresh_pat_details.value)
	if(parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteria!=undefined)//Added for JD-CRF-0181[IN045511]
		order_id=parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteria.order_id.value;
	else if(parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteriaIP!=undefined)
		order_id=parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteriaIP.order_id.value;
/* To Clear selected Transaction Order ids in the bean -- end -------- */
	if(row_no != "NOTAPPLICABLE"){
		var disp_locn_catg = parent.parent.parent.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.disp_locn_catg.value;
		var formObj = parent.parent.DispMedicationPatFrame.patient_id_display.frmDispMedicationPatientIDDisplay;
		formObj.sel_rec.value=row_no;
		var len = parent.parent.DispMedicationPatFrame.patient_id_display.document.getElementById("patientiddisplaytable").rows.length;
	/*	if(disp_locn_catg=="I"){	// I - Inpatient
			for (var i=1;i<len ; i++){
				if(formObj.patientiddisplaytable.rows[i].cells[0].style.backgroundColor=="#fde6d0"){
					formObj.patientiddisplaytable.rows[i].cells[0].style.backgroundColor="";
				}
			}
			formObj.patientiddisplaytable.rows[parseFloat(row_no]+1).cells[0].style.backgroundColor="#fde6d0";
		}else{
			for (var i=0;i<len ; i++){
				if(formObj.patientiddisplaytable.rows[i].cells[0].style.backgroundColor=="#fde6d0"){
					formObj.patientiddisplaytable.rows[i].cells[0].style.backgroundColor="";
				}
			}			formObj.patientiddisplaytable.rows[parseFloat(row_no]).cells[0].style.backgroundColor="#fde6d0";
		} */
	}
	var episode_id = eval("document.frmDispMedicationPatientIDDisplay.episode_id"+row_no).value;// added for RUT-CRF-0083.5 [IN:041511] Start 
	var patient_class =  eval("document.frmDispMedicationPatientIDDisplay.patient_class"+row_no).value;
	assignSelectedPatDet(patient_id,episode_id, patient_class,Ordering_Facility_id); //added for RUT-CRF-0083.5 [IN:041511] Start -End
	var Disp_locn_code_Spcl_case =  eval("document.frmDispMedicationPatientIDDisplay.desp_name_code"+row_no).value;
    parent.parent.DispMedicationPatDetFrame_1.location.href="../../ePH/jsp/DispMedicationPatientOrdersFrames.jsp?patient_id="+patient_id+"&patient_name="+escape(encodeURIComponent(patient_name))+"&sex="+sex+"&age="+age+"&nursing_unit="+escape(encodeURIComponent(nursing_unit))+"&episode_id="+episode_id+"&order_id="+order_id+"&bed_num="+bed_num+"&locn_code="+locn_code+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&Disp_locn_code_Spcl_case="+Disp_locn_code_Spcl_case;//code '+"&episode_id="+episode_id' added for IN045366 // Added 'order_id' for [IN:045511] // bed_num Added for KDAH-CRF-0338 // locn_code Added for BSP-SCF-0060 // encounter_id Added for GHL-CRF-0549
    parent.parent.DispMedicationPatDetFrame_2.location.href="../../eCommon/html/blank.html";
	parent.parent.DispMedicationPatDetFrame_3.location.href="../../eCommon/html/blank.html";

}

async function showOrderComments(order_id){
	var dialogHeight= "15.5" ;
	var dialogWidth	= "25" ;
	var dialogTop = "270" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop+";scrolling :no";
	var arguments	= "" ;
	retVal =await window.showModalDialog("../../ePH/jsp/DispMedicationOrderComments.jsp?order_id="+order_id,arguments,features);
}

function showOrderLineDetails(row_no,order_id,patient_id,disp_stage,practitioner_id,practitioner_name,fillingStatus,disp_locn_catg,group_by_patient,iv_prep_yn,disp_level,orderIDS_trxRefIDS){
	//practitioner_name=unescape(practitioner_name);

	/*
		disp_locn_catg (I - Inpatient)
		group_by_patient (D - To group based on orders)
	*/
//if(disp_locn_catg!="I") {
	var formObj = "";
	var frameObj ="";

	if(group_by_patient=="D"){
		row_no = parseFloat(row_no)+1;
	}
	else{
		row_no = parseFloat(row_no);
	}
	if(parent.parent.DispMedicationPatDetFrame_1==null || parent.parent.DispMedicationPatDetFrame_1==undefined){

		formObj = parent.DispMedicationPatDetFrame_2.frmDispMedicationOrderDetails;
		var len = document.getElementById('orderdetailstable').rows.length;
	}
	else{
		 formObj = parent.parent.DispMedicationPatDetFrame_1.order_details.frmDispMedicationOrderDetails;
		 frameObj = parent.parent.DispMedicationPatDetFrame_1.order_details;
		var len = frameObj.document.getElementById('orderdetailstable').rows.length;
	}
	for (var i=0;i<len ; i++){
		if(frameObj.document.getElementById('orderdetailstable').rows[i].cells[0].style.backgroundColor=="#fde6d0"){
			for(var j=0;j<frameObj.document.getElementById('orderdetailstable').rows[i].cells.length;j++)
				frameObj.document.getElementById('orderdetailstable').rows[i].cells[j].style.backgroundColor="";
		}
	}
	
	if(disp_level=="O"){
		if(frameObj.document.getElementById('orderdetailstable').rows[parseFloat(row_no)]!=null){
			for(var k=0;k<frameObj.document.getElementById('orderdetailstable').rows[parseFloat(row_no)].cells.length;k++){
				frameObj.document.getElementById('orderdetailstable').rows[parseFloat(row_no)].cells[k].style.backgroundColor="#fde6d0";
			}
		}
	}

	var bean_id		=	"DispMedicationAllStages";
	var bean_name	=	"ePH.DispMedicationAllStages";
	//var xmlDoc  = new ActiveXObject( "Microsoft.XMLDom" ) ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr +=" /></root>" ;
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "DispMedicationValidate.jsp?bean_id=DispMedicationBean&bean_name=ePH.DispMedicationBean&identity=ClearWSAllocateBatches", false ) ;
	xmlHttp.send( xmlDoc );
	if(parent.parent.DispMedicationPatDetFrame_1==null || parent.parent.DispMedicationPatDetFrame_1==undefined){
		parent.DispMedicationPatDetFrame_3.location.href="../../ePH/jsp/DispMedicationAllStagesFrames.jsp?order_id="+order_id+"&patient_id="+patient_id+"&encounter_id=DUMMYENCOUNTERID&disp_stage="+disp_stage+"&practitioner_id="+practitioner_id+"&practitioner_name="+practitioner_name+"&filling_status="+fillingStatus+"&iv_prep_yn="+iv_prep_yn+"&orderIDS_trxRefIDS="+orderIDS_trxRefIDS+"&pat_class="+disp_locn_catg+"&called_frm=Dispense&disp_locn_code="+document.frmDispMedicationOrderDetails.disp_locn_code.value;//Added new parameter 'pat_class,called_frm,disp_locn_code'for Bru-HIMS-CRF-081
	}
	else{
		parent.parent.DispMedicationPatDetFrame_3.location.href="../../ePH/jsp/DispMedicationAllStagesFrames.jsp?order_id="+order_id+"&patient_id="+patient_id+"&encounter_id=DUMMYENCOUNTERID&disp_stage="+disp_stage+"&practitioner_id="+practitioner_id+"&practitioner_name="+practitioner_name+"&filling_status="+fillingStatus+"&iv_prep_yn="+iv_prep_yn+"&orderIDS_trxRefIDS="+orderIDS_trxRefIDS+"&pat_class="+disp_locn_catg+"&called_frm=Dispense&disp_locn_code="+document.frmDispMedicationOrderDetails.disp_locn_code.value;//Added new parameter 'pat_class,called_frm,disp_locn_code'for Bru-HIMS-CRF-081
		
	}

// }
// else {
//	 parent.parent.DispMedicationPatDetFrame_3.location.href="../../ePH/jsp/DispMedicationAllStagesFrames.jsp?order_id="+order_id+"&patient_id="+patient_id+"&encounter_id=DUMMYENCOUNTERID&disp_stage="+disp_stage+"&practitioner_id="+practitioner_id+"&practitioner_name="+practitioner_name+"&filling_status="+fillingStatus+"&iv_prep_yn="+iv_prep_yn;
 // }
}

function checkFlds( fields, names) {

	var errors = "" ;
	for( var i=0; i<fields.length; i++ ) {
		if(trimCheck(fields[i].value)) {
			fields[i].value = trimString(fields[i].value);
		}
		else{
			errors = errors + "APP-000001 " + names[i] +getLabel("Common.Cannotbeblank.label","Common") +" ..." + "\n" ;
			//if(fields[i].disabled==false){
				//fields[i].focus();
			//}
		}
	}

	if ( errors.length != 0 ) {
		alert(errors) ;
		return false ;
	}
	return true ;
}

function checkFldsForRecord( fields, names) {
	var errors = "" ;
	for( var i=0; i<fields.length; i++ ) {
		if(trimCheck(fields[i].value)) {
			//fields[i].value = trimString(fields[i].value);
		}
		else{
			errors = errors + "APP-000001 " + names[i] +getLabel("Common.Cannotbeblank.label","Common") +" ..." + "\n" ;
			//if(fields[i].disabled==false){
				//fields[i].focus();
			//}
		}
	}
	if ( errors.length != 0 ) {
		alert(errors) ;
		return false ;
	}
	return true ;
}

async function showPatientHistory(patient_id, encounter_id){
	var dialogHeight	= "90vh" ;
	var dialogWidth		= "90vw" ;
	var dialogTop		= "10" ;
	var center			= "1" ;
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "" ;
	retVal =await top.window.showModalDialog("../../eCA/jsp/EncounterInDialog.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id, arguments, features);
}

async function showAllergicDrug(patient_id){
	var dialogHeight	= "90vh" ;
	var dialogWidth		= "90vw" ;
	var dialogTop		= "0" ;
	var center			= "1" ;
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "" ;
	retVal =await top.window.showModalDialog("../../eCA/jsp/AllergyList.jsp?patient_id="+patient_id+"&called_from_ip=Y", arguments, features);
}
async function showActiveProblems(patient_id){
	var dialogHeight	= "90vh" ;
	var dialogWidth		= "90vw" ;
	var dialogTop		= "0" ;
	var center			= "1" ;
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "" ;
	retVal =await top.window.showModalDialog("../../eCA/jsp/PatProblemList.jsp?patient_id="+patient_id+"&modal_yn=Y", arguments, features);
}
async function showCurrentRx(patient_id,encounter_id,order_date,pat_class){
	encounter_id = "DUMMYENCOUNTERID";
	var dialogHeight	= "90vh" ;
	var dialogWidth		= "90vw" ;
	var dialogTop		= "20" ;
	var center			= "1" ;
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "" ;
	retVal				=await top.window.showModalDialog("../../ePH/jsp/PrescriptionActiveOrderDetailsFrame.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&called_frm=PH&order_date="+order_date+"&patient_class="+pat_class,arguments,features);
}
async function showOtherOrders(patient_id,disp_locn_code,encounter_id){
	var dialogHeight	= "90vh" ;
	var dialogWidth		= "90vw" ;
	var dialogTop		= "10" ;
	var center			= "1" ;
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "" ;
	retVal				=await top.window.showModalDialog("../../ePH/jsp/DispMedicationOtherOrders.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&disp_locn_code="+disp_locn_code,arguments,features);
}
async function showDemographics(patient_id){
	var dialogHeight	= "90vh" ;
	var dialogWidth		= "90vw" ;
	var dialogTop		= "10" ;
	var center			= "1" ;
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "" ;
	retVal				=await top.window.showModalDialog( "../../eMP/jsp/ViewPatDetailsMain.jsp?Patient_ID="+escape(patient_id), arguments, features );
}
async function showDrugProfile(patient_id,disp_locn_code,pat_class, dispMednDrugProfile,encounter_id){ // encounter_id added AAKH-CRF-0088.2
	//Modified for Bru-HIMS-CRF-081 [IN:029947]- Start
	if(dispMednDrugProfile=='Y'){
		if(parent.parent.DispMedicationPatDetFrame_3.f_disp_medication_drug_profile.location.href.indexOf("eCommon/html/blank.html")!=-1)
			parent.parent.DispMedicationPatDetFrame_3.f_disp_medication_drug_profile.location.href="../../ePH/jsp/QueryPatientDrugProfileFrames.jsp?patient_id="+patient_id+"&called_frm=Dispense&disp_locn_code="+disp_locn_code+"&pat_class="+pat_class+"&encounter_id="+encounter_id; // encounter_id added for AAKH-CRF-0088.2
		parent.parent.DispMedicationPatDetFrame_3.dispmednframeset2.cols="35%,65%";
	}
	else{
		var dialogHeight	= "90vh" ;
		var dialogWidth		= "90vw" ;
		var dialogTop		= "10" ;
		var center			= "1" ;
		var status			= "no";
		var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments		= "" ;
		retVal				=await top.window.showModalDialog( "../../ePH/jsp/QueryPatientDrugProfileFrames.jsp?patient_id="+patient_id+"&called_frm=DispenseMax&disp_locn_code="+disp_locn_code+"&pat_class="+pat_class+"&encounter_id="+encounter_id, arguments, features ); // encounter_id added for AAKH-CRF-0088.2
		/*if(retVal=="Dispense"){
			parent.parent.parent.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.btnSearch.click();
		}*/
	}
}

async function showDispDrugs(patient_id){
	var dialogHeight	= "90vh" ;
	var dialogWidth		= "90vw" ;
	var dialogTop		= "10" ;
	var center			= "1" ;
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "" ;
	retVal				=await top.window.showModalDialog( "../../ePH/jsp/QueryPresVsDispDrugFrames.jsp?patient_id="+escape(patient_id), arguments, features );
	//window.open( "../../ePH/jsp/QueryPresVsDispDrugFrames.jsp?patient_id="+escape(patient_id), arguments, features );
}

//this function used to display current status of all orders of a patient
async function showPendingOrders(patient_id,disp_locn_code){
	var dialogHeight	= "90vh" ;
	var dialogWidth		= "90vw" ;
	var dialogTop		= "10" ;
	var center			= "1" ;
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "" ;
	retVal				=await top.window.showModalDialog( "../../ePH/jsp/PendingMedicationOrderStatusOrderDetails.jsp?patient_id="+patient_id+"&disp_locn_code="+disp_locn_code+"&called_from=Dispensing", arguments, features );
	if(retVal=='NO_RECORD_FOUND_FOR_CRITERIA')
		alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
}

function  showFillCriteria(catg,stage){
	/*
		catg (I - Inpatient,O - Outpatient)
		stage(F - Filling)
	*/
	if(catg.value=="I" && stage.value =="F"){
		
		document.getElementById('fill_list_id').style="display";
		document.getElementById('fill_list_id').style.visibility="visible";
		document.getElementById('deliver_list_id').style.display="none";
		window.dialogHeight="15";
	}else if(catg.value=="I" && stage.value =="D"){
		
		document.getElementById('deliver_list_id').style="display";
		document.getElementById('deliver_list_id').style.visibility="visible";
		document.getElementById('fill_list_id').style.display="none";
		window.dialogHeight="15";
	}else{
		
		document.getElementById('fill_list_id').style.display="none";
		document.getElementById('deliver_list_id').style.display="none";
		window.dialogHeight="15";
	}

	// ICN-30405
	if( (catg.value=="I" && stage.value =="F") || (catg.value=="I" && stage.value =="D")) { 
		formObj		= 	 document.frmDispMedicationLogin
		disp_locn	= formObj.disp_locn.value;
		stage		= stage.value;

		//var disp_locn_code = formObj.disp_locn.value;
		var bean_id   = formObj.bean_id.value;
		var bean_name = formObj.bean_name.value;
		//var xmlDoc  = new ActiveXObject( "Microsoft.XMLDom" ) ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr += " disp_locn=\"" + disp_locn + "\"";
		xmlStr +=" /></root>";
		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	xmlHttp.open("POST","DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=getDefault",false);
		xmlHttp.send( xmlDoc ) ;
		eval(xmlHttp.responseText);
	}
}
function beforePost(xmlStr){
	//alert("Disp Medication(Verification)::"+xmlStr);
}
async function completeVerification(){
	var formObj			=	"";  
	 var queryFormObj	=	"";
    if(parent.parent.DispMedicationPatDetFrame_3!=undefined){
	   formObj =	parent.parent.DispMedicationPatDetFrame_3.f_disp_medication_verification;
	   parent.parent.parent.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.btnSearch.disabled	=	false;
	}
	else{
       formObj		    = parent.f_stage;
	   var queryFormObj = parent.f_query_add_mod.document.TaskListQueryCriteria;
	}

	// RUT-CRF-0035 [IN029926] PIN Authentication -- begin  
	var retVal1="1";
	 
	var totRec =0; // Added for MMS-KH-CRF-0028 [IN070605] - Start
	var chkRec =0;// Added for MMS-KH-CRF-0028 [IN070605] 
	
	var verifyChecked = false;
	
	if(formObj.DispMedicationAllStages.recCount!=undefined){
		totRec= formObj.DispMedicationAllStages.recCount.value;
	}

	for(var k=1;k<=totRec;k++){	// modified for MMS-KH-CRF-0028 [IN070605]
		   

	       if(eval("formObj.DispMedicationAllStages.verifyChecked_"+k)!=undefined && eval("formObj.DispMedicationAllStages.verifyChecked_"+k+".value") == "Y"){	    	  
	    	 
	    	   if(eval("formObj.DispMedicationAllStages.ALLERGY_VALUE"+k).value == "Y" && eval("formObj.DispMedicationAllStages.DOSELIMIT_VALUE"+k).value == "Y"  && eval("formObj.DispMedicationAllStages.CURRENTRX_VALUE"+k).value == "Y" && eval("formObj.DispMedicationAllStages.INTARACTION_VALUE"+k).value == "Y"){
	    	   verifyChecked = true;
	    		 //break;
	    	   }
	    	   else{chkRec++;
	    		   verifyChecked = false;
				   break; // added for MMS-KH-CRF-0028 [IN070605]
	    	   }   
	       }
	}
	     
	//if(!verifyChecked){
	  
		if(chkRec>0){
			
			alert(getMessage("ALL_RECORDS_SHOULD_BE_APPROVED",'PH'));
			   return;
	   }
	   else if(!verifyChecked)
		   {
		   alert(getMessage("PH_ATLEAST_ONE_SELECTED",'PH'));
	   return;
	   }
	//} // Added for MMS-KH-CRF-0028 [IN070605] - End
	
	
	if(document.getElementById('userAuthPINYN').value=='Y'){
		var dialogHeight	= "10";
		var dialogWidth		= "30";
		var dialogTop		=  window.screen.availWidth - 1100;
		var dialogLeft		=  window.screen.availWidth - 1000;
		var center			= "0";
		var status			= "no";	
		var disp_locn_catg  = document.getElementById('disp_locn_catg').value;
		var disp_locn_code  = document.getElementById('disp_locn_code').value;
		var features		= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		retVal1=await window.showModalDialog("../../ePH/jsp/UserPINAuthorization.jsp?call_from=V&disp_category="+disp_locn_catg+"&disp_locn_code="+disp_locn_code,"",features);
		if(retVal1==undefined || retVal1=='C')
			 return;
		else if(trimString(retVal1)!="0") // && trimString(retVal1)!="")
			storeUserinBean(trimString(retVal1));
	}
	mainForm	=	formObj.DispMedicationAllStages;
	if(retVal1!="0"){  // RUT-CRF-0035 [IN029926] PIN Authentication  -- end
		eval(formApply( formObj.DispMedicationAllStages,PH_CONTROLLER ));
	}
	if(!result){
		alert(message);
	}

	/*if(parent.parent.DispMedicationPatDetFrame_3!=undefined){
		parent.parent.DispMedicationPatDetFrame_2.location.href="../../eCommon/html/blank.html";
		parent.parent.DispMedicationPatDetFrame_3.location.href="../../eCommon/html/blank.html";
		parent.parent.DispMedicationPatDetFrame_1.location.reload();
	}else{
        parent.f_stage.location.href="../../eCommon/html/blank.html";
		parent.f_disp_medication_all_stages_legends.location.href="../../eCommon/html/blank.html";
		parent.dispframes.rows="8%,22%,*,0%,0%,0%,10%";
		queryFormObj.btnProceed.click();	
	}*/

	if(parent.parent.parent.document.f_query_criteria_token_info!=undefined){
		if(parent.parent.parent.document.f_query_criteria_token_info.frmDispMedicationQueryCriteriaTokenInfo!=null) {
			token_form	=	parent.parent.parent.document.f_query_criteria_token_info.frmDispMedicationQueryCriteriaTokenInfo;	
			token_form.token_no.disabled		=	false;
			token_form.token_no.value			=   "";
			token_form.token_series.disabled	=	false;
			token_form.queue_date.disabled	    =	false;
			parent.parent.parent.document.f_query_criteria_token_info.document.getElementById("Calendar").disabled	    =	false;
			reload	=	false;
		}
	}
	var homePage=""; //Added for  Bru-HIMS-CRF-073.1 [IN:047222]
	if(parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteria !=null){
		parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteria.change_status.value="";
		parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteria.order_id.value="";//Added for [IN:45893]
		homePage = parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteria.homepage.value; //Added for  Bru-HIMS-CRF-073.1 [IN:047222]
	}
	else if(parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteriaIP !=null){
		parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteriaIP.change_status.value="";
		parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteriaIP.order_id.value="";//Added for [IN:45893]
		homePage = parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteriaIP.homepage.value; //Added for  Bru-HIMS-CRF-073.1 [IN:047222]
	}
   //	parent.parent.parent.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.btnSearch.click();
	clearframes();

	// these conditions are added to display "operation completed successfully in the message frame12/2/2009
	if(parent.parent.parent.parent.messageFrame != undefined && parent.parent.parent.parent.messageFrame != null)
		parent.parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
	else if (parent.messageFrame != undefined && parent.messageFrame != null)
		parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
	else if (parent.parent.parent.document.messageFrame != undefined && parent.parent.parent.document.messageFrame != null)
		parent.parent.parent.document.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
	if(homePage=='Y' && result){ //Added for  Bru-HIMS-CRF-073.1 [IN:047222]
		parent.parent.parent.parent.parent.menuFrame.location.reload();
	}
}

/*function assignResult( _result, _message, _flag ) {
	alert("prathyusha");
	result = _result ;
	message  = _message ;
	flag = _flag ;
	
}*/
function assignResult( _result, _message, _flag,_invalidCode,_dispNos ) {//added for th-kw-crf-0020.3
	result = _result ;
	message  = _message ;
	flag = _flag ;
	dispNos=_dispNos;
	
}
function submitPKIDDetails(dispnos){   
	//alert("2206");
	     var facility_id=parent.f_disp_medication_header.document.DispMedicationAllStages.facility_id.value; 
//	alert(facility_id);  
	         var queue_pkid=parent.f_disp_medication_header.document.DispMedicationAllStages.quePkiToken.value; 
	  // alert(queue_pkid);  
	var token_num=parent.f_disp_medication_header.document.DispMedicationAllStages.quePkiNumber.value; 
	// alert(token_num);  
	  var issued_date_time=parent.f_disp_medication_header.document.DispMedicationAllStages.quePkiIsueDateTime.value;   
	// alert(issued_date_time);  
	var called_date_time=parent.f_disp_medication_header.document.DispMedicationAllStages.quePkiCallDateTime.value; 
	 // alert(called_date_time);  
	 var patient_id=parent.f_disp_medication_header.document.DispMedicationAllStages.patient_id.value;  //
	// alert(patient_id);  
	 var encounter_id=parent.f_disp_medication_header.document.DispMedicationAllStages.encounter_id.value;     //  
	// alert(encounter_id);  
	 var status_code=parent.f_disp_medication_header.document.DispMedicationAllStages.quePkiStatus.value;   
	//alert(status_code);   
	var status_text=parent.f_disp_medication_header.document.DispMedicationAllStages.quePkiStatusText.value;  
	 // alert(status_text);  
	var user_id=parent.f_disp_medication_header.document.DispMedicationAllStages.user_id.value;     
	 //alert(user_id);  
	 // alert(responseText+"<--->"+facility_id+"<--->"+queue_pkid+"<--->"+token_num+"<--->"+issued_date_time+"<--->"+called_date_time+"<--->"+patient_id+"<--->"+encounter_id+"<--->"+status_code+"<--->"+status_text+"<--->"+user_id); 
	  dispnos_result = dispnos.split(",");
	//alert(dispnos_result+"dispnos_result");
	 for(var i=0;i<dispnos_result.length;i++){    
		  //  alert(dispnos_result[i]+"dispnos_result");
		insertIntoXhQmsTable ("PHDISP", facility_id,   queue_pkid, token_num,  issued_date_time, called_date_time,   patient_id,  encounter_id,dispnos_result[i], status_code,  status_text, user_id);  
		  }  
   // alert("PHDISP");              
	}

function completeAllocation(obj, label_display) {
	if (parent.f_disp_medication_header.document.DispMedicationAllStages.queue_pkid_appl.value == true
			|| parent.f_disp_medication_header.document.DispMedicationAllStages.queue_pkid_appl.value == 'true') {// added
																													// for
																													// TH-KW-CRF-0020.3
		if (parent.f_disp_medication_header.document.DispMedicationAllStages.quePkiId.value == "") {
			
				if (confirm("Primary key of queue number is blank. Do you wish to proceed")) {
					completeAllocationQpkid(obj, label_display);
				} else{
					parent.f_disp_medication_header.document.DispMedicationAllStages.quePkiId.focus();
					return false;
				}
					
			
		}
		else {
			completeAllocationQpkid(obj, label_display);
		}

	} else {
		completeAllocationQpkid(obj, label_display);
	}
}
function completeAllocationQpkid(obj,label_display){
	
	
	var doc="";
	if(parent.f_stage==undefined){
		var formObj = parent.parent.DispMedicationPatDetFrame_3.f_disp_medication_allocation;
		if(formObj==null)
			doc=parent.parent.DispMedicationPatDetFrame_3.f_disp_medication_filling.document;
		else
			doc=parent.parent.DispMedicationPatDetFrame_3.f_disp_medication_allocation.document;
	 }
	 else{
		 var formObj = parent.f_stage
		 doc=parent.f_stage.document;
	 }

	 if(parent.f_stage==undefined){
		if(formObj == null){
			var formObj = parent.parent.DispMedicationPatDetFrame_3.f_disp_medication_filling;
			 doc=parent.parent.DispMedicationPatDetFrame_3.f_disp_medication_filling.document;
		}
	}
	else{
        var formObj = parent.f_stage
		doc=parent.f_stage.document;
	}
	mainForm	=	formObj.DispMedicationAllStages;

 // Commented for SKR-SCF-0105
 //if(doc.DispMedicationAllStages.allow_yn.value=='Y'){
	var approval_no_appl_flag = mainForm.approval_no_flag.value;  //AAKH-CRF-0117 - start
	var approval_no_app_for_patient_class = mainForm.approval_no_app_for_patient_class.value;//AAAKH-CRF-0117
   if(approval_no_app_for_patient_class=="Y" && ( approval_no_appl_flag==true || approval_no_appl_flag=="true")){
		approval_proceed_flag = getApprovalNoValidation("A",mainForm);

		if(!approval_proceed_flag){
			alert(getMessage("PH_APPROVAL_NO_CANT_BE_BLANK","PH"));
			return false;
		}
   }  //AAKH-CRF-0117 - end

	var total_rec		=	"";
	total_rec			=	mainForm.tot_rec.value;
	var rec_total		=	parseInt(total_rec);
	var found			=	false;
	var found2			=	false;
	var scope="";
	if(parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteria !=null){
		scope=parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteria.order_status.value;
		order_type =parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteria.order_type.value;
		parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteria.order_id.value="";//Added for [IN:45893]
	}
	else if(parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteriaIP !=null){
		scope=parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteriaIP.ip_scope.value;
		order_type =parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteriaIP.order_type.value;
		parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteriaIP.order_id.value="";//Added for [IN:45893]
	}
	
	 var verifyChecked = true; // Added for MMS-KH-CRF-0028 [IN070605] - Start
     
	 if(doc.DispMedicationAllStages.intractn_req_yn.value='true'){
       for(var k=1;k<rec_total;k++){		   
	       if(eval("mainForm.print_"+k)!=undefined && eval("mainForm.print_"+k+".value") == "Y" ){	    	  
	    		 verifyChecked = true;
	    		 break;
	       }
	       else {
	    		  if(k==rec_total-1){
	    			 verifyChecked = false;
	    		  }
	       }
	   }
	 }
	if(!verifyChecked && doc.DispMedicationAllStages.iv_prep_yn.value==""){
	   alert(getMessage("PH_ATLEAST_ONE_SELECTED",'PH'));
	   return;
	} // Added for MMS-KH-CRF-0028[IN070605] - End	
	
	if(scope=='H'){
		for(i=1; i<rec_total; i++) {
			if(eval("doc.release_flag"+i)!=undefined) {
				val1=   eval("doc.release_flag"+i+".value"); 
				if(val1=='Y'){
					found =true;
					break;
				}				   
			}
		}
	}
	else{	
		for(i=1; i<rec_total; i++) {
			if(eval("doc.DispMedicationAllStages.bms_qty"+i)!=undefined) {			 
				val		=	eval("doc.DispMedicationAllStages.bms_qty"+i+".value");	
				if(val!=undefined){
					if((!isNaN(parseInt(trimString(val))))){
						if((parseInt(trimString(val)))<0){								  
							found2=true;
							break;
						}
					}
				}               
			}
		}
		var alloc_bms_chk ="";
		for(i=1; i<rec_total; i++) {
			  alloc_bms_chk ="";
		   //  if(order_type==('NOR')){
			   if(eval("doc.DispMedicationAllStages.alloc_qty_"+i)!=undefined) {
					val	=	eval("doc.DispMedicationAllStages.alloc_qty_"+i+".value");
					val3	=   eval("doc.allocateyn_"+i+".value");
					if(eval("doc.DispMedicationAllStages.alloc_bms_chk_"+i)!=undefined){
						if(eval("doc.DispMedicationAllStages.alloc_bms_chk_"+i+".checked") == true)
							alloc_bms_chk	= "Y"	;
						else
							alloc_bms_chk ="N";
					}
					else
						alloc_bms_chk ="N";
				
					if(val!=undefined){
						if(((!isNaN(parseInt(trimString(val))))&&(val3=='Y')&&(parseInt(trimString(val))>0))|| alloc_bms_chk =="Y"){	
							found	= true;
							break;			
						}
					}
				} 
				else{
					if(eval("doc.alloc_qty"+i)!=undefined) {
						val		=	eval("doc.alloc_qty"+i+".innerText");
						val3    =   eval("doc.allocateyn_"+i+".value");
					  if(val!=undefined){
						if((!isNaN(parseInt(trimString(val))))&&(val3=='Y')){	
							found	= true;
							break;			
						   }
					  }
				   }	
			   } 
			/* }else{
			   if(eval("doc.alloc_qty"+i)!=undefined) {
		 
				val		=	eval("doc.alloc_qty"+i+".innerText");
				val3    =   eval("doc.allocateyn_"+i+".value");
				
				  if(val!=undefined){
					if((!isNaN(parseInt(trimString(val))))&&(val3=='Y')){	
						found	= true;
						break;			
					   }
				  }
			   }
			 }*/
	   
			 if((eval("doc.CompleteOrder"+i)!=undefined) ) {
				val1=   eval("doc.CompleteOrder"+i+".value");           
				 if( val1=='Y'){
					 found	= true;
					 break;			
				 }
			  }	
			  if((eval("doc.hold"+i)!=undefined) ) {
				val2=   eval("doc.hold"+i+".value"); 
				
				 if( val2=='Y'){
					 found	= true;
					 break;			
				 }
			  }	
			  if(eval("mainForm.alloc_bms_chk_"+i) != undefined){
				  if(eval("mainForm.alloc_bms_chk_"+i).value == 'Y')
					found = true;
			  }
		 }
	}
	if(mainForm.tpn_wrksheet_rcrd.value == 'N'&& (obj=="TPN_WS_RECORD"||obj=="TPN_WS_FINALIZE")){
		found = false;
	}
	/*=======================================================================================*/
	 if(!found2){ 
		if(found){	
			if((obj=="TPN_WS_RECORD" || obj=="WS_RECORD" || obj=="WS_FINALIZE" || obj=="TPN_WS_FINALIZE" || obj=="CYTO_WS_FINALIZE" || obj=="CYTO_WS_RECORD")){ 
				/*
					This condition will be executed for IV/TPN Worksheet Finalize...
				*/
				for(i=1; i<rec_total; i++) {
				   if(eval("doc.alloc_qty"+i)!=undefined) {
			 
						val		=	eval("doc.alloc_qty"+i+".innerText");
						if(val!=undefined){
							if((!isNaN(parseInt(trimString(val))))){	
								alloc_found	= true;
							}else{
								alloc_found	= false;
								break;
							}
						}
					}
				}

			   if((alloc_found) && label_display=="YES"){
				   callWSLabelWindow(obj,'');
				/*	var dialogHeight= "16" ;
					var dialogWidth	= "35" ;
					var dialogTop = "300" ;
					var center = "1" ;
					var status="no";
					var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
					var arguments	= "" ;
					var retVal= window.showModalDialog("../../ePH/jsp/DispMedicationWSLabel.jsp?ord_type="+obj,arguments,features);
					if(retVal !="SAVED"){
						return false;
					}*/
				}
				else{
				   alert(getMessage("PH_ISSUE_QTY_BLANK",'PH'));
				   return false;
				}
			}
			eval(formApply( formObj.DispMedicationAllStages,PH_CONTROLLER ));
		}
		else{
			alert(getMessage("PH_NO_CHANGE","PH"));
		}
	}
	else{
		 alert(getMessage("PH_ALLOC_QTY_LESS_BMS_QTY","PH"));
	}
	/*if(parent.parent.DispMedicationPatDetFrame_3!=undefined){		
			//parent.parent.DispMedicationPatDetFrame_2.location.href="../../eCommon/html/blank.html";
			//parent.parent.DispMedicationPatDetFrame_3.location.href="../../eCommon/html/blank.html";
	}*/
	var reload	=	true;
	if(parent.parent.parent.document.f_query_criteria_token_info!=undefined){
		if(parent.parent.parent.document.f_query_criteria_token_info.frmDispMedicationQueryCriteriaTokenInfo!=null) {
			token_form	=	parent.parent.parent.document.f_query_criteria_token_info.frmDispMedicationQueryCriteriaTokenInfo;	
			token_form.token_no.disabled		=	false;
			token_form.token_no.value			=   "";
			token_form.token_series.disabled	=	false;
			token_form.queue_date.disabled	    =	false;

			parent.parent.parent.document.f_query_criteria_token_info.document.getElementById("Calendar").disabled	    =	false;
			reload	=	false;
		}
	}
	
	if(parent.parent.DispMedicationPatDetFrame_1!=undefined){
		parent.parent.DispMedicationPatDetFrame_1.location.reload();
	}
	if((flag !="0"&& flag!='' ) && (obj=="WS_FINALIZE" || obj=="WS_RECORD" || obj=="TPN_WS_FINALIZE" ) ){
		//This is to display workheet id
		//if(parent.f_stage==undefined){
			
			parent.parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message+"\n Worksheet ID:<b><label style='font-size:18'>"+flag+"</label></b>";
		//}else{
		  //  parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message+"\n Worksheet ID:<b><label style='font-size:18'>"+flag+"</label></b>";
		//}
	}
	else{//alert("hi2461");
//	alert("Hi 2461"+dispNos);
//	alert(parent.f_disp_medication_header.document.DispMedicationAllStages);
//	alert(parent.f_disp_medication_header.document.DispMedicationAllStages.queue_pkid_appl.value);
	if(parent.f_disp_medication_header.document.DispMedicationAllStages.queue_pkid_appl.value==true || parent.f_disp_medication_header.document.DispMedicationAllStages.queue_pkid_appl.value=='true'){//added for TH-KW-CRF-0020.3
//	alert("2494");        
	    submitPKIDDetails(dispNos);  
	      }
//	alert("2497");
		//if(parent.f_stage==undefined){
			parent.parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
		//}else{
		  //  parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
		//}
	}
	var homePage=""; //Added for  Bru-HIMS-CRF-073.1 [IN:047222]
	if(parent.parent.parent.f_query_criteria!=undefined){
		 if(parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteria !=null){
			parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteria.change_status.value="";
			homePage = parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteria.homepage.value; //Added for  Bru-HIMS-CRF-073.1 [IN:047222]
		 }
		 else if(parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteriaIP !=null){
			parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteriaIP.change_status.value="";
			homePage = parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteriaIP.homepage.value; //Added for  Bru-HIMS-CRF-073.1 [IN:047222]
		 }
	//Commented by charles		 
	//		    parent.parent.parent.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.btnSearch.click();
	}
	if(result==true && (obj=="WS_FINALIZE" || obj=="TPN_WS_FINALIZE" )&& label_display=="YES" && flag !="0"){
		/*
			This is to show print dialog...from where user can select which report he wants to print
			(On finalizing)
		*/
		
		var dialog_result = showWSDialogForPrinting(obj);
		if(dialog_result!=undefined && dialog_result!=null) {
			dialog_result_split = dialog_result.split(":");
			selected_ws_report_1= dialog_result_split[0];
			selected_ws_report_2= dialog_result_split[1];
			selected_ws_report_3= dialog_result_split[2];
			selected_ws_report_4= dialog_result_split[3];//added for ml-mmoh-crf-0468
			selected_ws_report_5= dialog_result_split[4];//added for ml-mmoh-crf-0468
			selected_ws_report_6= dialog_result_split[5];//added for ml-mmoh-crf-2042
			callLabelPrintDialog(mainForm,flag,selected_ws_report_1,selected_ws_report_2,selected_ws_report_3,obj,selected_ws_report_4,selected_ws_report_5,selected_ws_report_6);//modified for ml-mmoh-crf-0468
		}
		clearframes();
	}
	else if(result==true && (obj=="WS_RECORD" || obj=="TPN_WS_RECORD" )&& flag !="0"){
		/*
			This is to show print dialog...from where user can select which report he wants to print
			(On recording)
		*/
		var dialog_result = showWSDialogForPrinting(obj);
		if(dialog_result!=null){
			dialog_result_split = dialog_result.split(":");
			selected_ws_report_1= dialog_result_split[0];
			selected_ws_report_2= dialog_result_split[1];
			selected_ws_report_3= dialog_result_split[2];
			callLabelPrintDialog(mainForm,flag,selected_ws_report_1,selected_ws_report_2,selected_ws_report_3,obj);
			
		}
		clearframes();
	}
	else if(result) {	
		callPrintDialog(mainForm,doc);
	}
	else{
		if(message!=''){
			 alert(message);
			 /*Below Condition is added by sureshkumar T for the incident no :  SRR20056-SCF-6413.1[Inc : 26642] */
			return false;
		}
		parent.parent.DispMedicationPatDetFrame_1.location.reload();					
		if(parent.parent.parent.f_query_criteria_buttons!=undefined){
			parent.parent.parent.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.btnSearch.click();
		} 
	}	
     // Commented for SKR-SCF-0105
	 /*}else{
			alert("Drug(s) related to selected order(s) is already in next stage.  Deliver it to process these orders.");
      }  */  
	if(homePage=='Y'){ //Added for  Bru-HIMS-CRF-073.1 [IN:047222]
		parent.parent.parent.parent.parent.menuFrame.location.reload();
	}
}

async function callPrintDialog(mainForm,doc) {
	bean_id		=	mainForm.bean_id.value;
	bean_name	=	mainForm.bean_name.value;
	bean_id_1	=	mainForm.bean_id_1.value;
	bean_name_1	=	mainForm.bean_name_1.value;
	order_id	=	mainForm.order_id.value;
	patient_id	=	mainForm.patient_id.value;
	source_code	=	mainForm.source_code.value;
	curr_stage	=	mainForm.curr_stage.value;
	disp_level	=	mainForm.disp_level.value;
	tot_rec		=	mainForm.tot_rec.value;
	ord_type	=	mainForm.ord_type.value;	
	var tot		=	parseInt(tot_rec);
	var flag="";
	var complete_order_flag="N";
	var found=false;
	var val1="";
	/*===code added for validating complete order checkbox on 11/28/2004====*/	
	var m=0;
	if(curr_stage!='AS'){
		for(k=1; k<tot; k++) {
			if((eval("doc.CompleteOrder"+k)!=undefined) ) {
				if( val1=='Y'){			
					m=m+1;				
				}
			}
		}
		if(m==tot-1){
			complete_order_flag="Y";
		}
	}
	
	for(i=1; i<tot; i++) {
		if(eval("doc.alloc_qty"+i)!=undefined) {
			val		=	eval("doc.alloc_qty"+i+".innerText");	
			if(!isNaN(parseInt(trimString(val)))){			
				found	= true;
				break;
			}
			else {
				obj =   eval("doc.order_line_status"+i);
				if (obj != null && obj != undefined){
					val2= obj.value;							
					if( val2=='RG' || val2=='VF' || val2=='AL' || val2=='DP' || val2 =='IP'){			
						found	= true;
						break;			
					}
				}
			}
		}
		else  if(eval("doc.DispMedicationAllStages.alloc_qty_"+i)!=undefined) {
			val		=	eval("doc.DispMedicationAllStages.alloc_qty_"+i+".value");
			if(curr_stage!='AS'){
				val3    =   eval("doc.allocateyn_"+i+".value");
				if(val!=undefined){
					if((!isNaN(parseInt(trimString(val))))&&(val3=='Y')){	
						found	= true;
						break;			
					}
				}
				else {
					obj=   eval("doc.order_line_status"+i)
					if (obj != null && obj != undefined){							
						val2= obj.value;  
						if( val2=='RG' || val2=='VF' || val2=='AL' || val2=='DP' || val2 =='IP'){			
							found	= true;
							break;			
						}
					}
				}
			}
			else{					
				if(val!=undefined){
					if((!isNaN(parseInt(trimString(val))))){	
						found	= true;
						break;			
					}
				}
				else {
					obj=   eval("doc.order_line_status"+i)
					if (obj != null && obj != undefined){
						val2=obj.value;  
						if( val2=='RG' || val2=='VF' || val2=='AL' || val2=='DP' || val2 =='IP'){			
							found	= true;
							break;			
						}
					}
				}
			}
		}
		if(eval("doc.alloc_bms_chk_"+i)!=undefined && eval("doc.alloc_bms_chk_"+i).value == 'Y') {
			found = true;
		}		  
	}
	var n=0;
	if(complete_order_flag !='Y'){
	   for(m=1; m<tot; m++) {
		  // if(ord_type=='NOR'){
			  if(eval("doc.bms_qty_"+i)!=undefined) {
				val		=	eval("doc.bms_qty_"+m+".value");	
				val1    =   eval("doc.CompleteOrder"+m+".value");
				 if(val!='0.0'){	
					 if(val1=='Y'){
						complete_order_flag="Y";
					 }
					 else{
						complete_order_flag="N";
					 }
				 }
			  }
		   /*}else{
			  if(eval("doc.bms_qty"+i)!=undefined) {
				val		=	eval("doc.bms_qty"+m+".value");	
				val1    =   eval("doc.CompleteOrder"+m+".value");
				
				 if(val!='0.0'){	
					 if(val1=='Y'){
						complete_order_flag="Y";
						 
					 }else{
						complete_order_flag="N";
					 }
				 }
			  }
		   }*/
		}		   
	}
	/*=============================================*/

    if(found==true){
		var xmlStr ="<root><SEARCH ";

		if(curr_stage!="AS") {
		xmlStr+= "bean_id  =\"" + bean_id_1 + "\" " ;
		xmlStr+= "bean_name =\"" + bean_name_1 + "\" " ;
		xmlStr+= "bean_id_1 =\"" + bean_id + "\" " ;
		xmlStr+= "bean_name_1=\"" + bean_name + "\" " ;
		} else {
		xmlStr+= "bean_id  =\"" + bean_id + "\" " ;
		xmlStr+= "bean_name =\"" + bean_name + "\" " ;
		xmlStr+= "bean_id_1 =\"" + bean_id_1 + "\" " ;
		xmlStr+= "bean_name_1=\"" + bean_name_1 + "\" " ;
		}
		if(disp_level=="P") {
			for(i=1; i<tot; i++){
				ord_id	=	eval("mainForm.order_id"+i+".value");
				xmlStr+= "order_id"+i+"=\"" + ord_id + "\" " ;
				if(eval("mainForm.del_detail"+i)!=undefined && eval("mainForm.del_detail"+i)!=null) {
					del_det	=	eval("mainForm.del_detail"+i+".value");
					xmlStr+= "del_detail"+i+"=\"" + del_det + "\" " ;
				}
			}
		}
		else {
			xmlStr+= "order_id=\"" + order_id + "\" " ;
		}
		xmlStr+= "patient_id=\"" + patient_id + "\" " ;
		xmlStr+= "source_code=\"" + source_code + "\" " ;
		xmlStr+= "disp_level=\"" + disp_level + "\" " ;
		xmlStr+= "tot_rec=\"" + tot_rec + "\" " ;
		xmlStr+= "complete_order_flag=\"" + complete_order_flag + "\" " ;
		xmlStr +=" /></root>";
		var temp_jsp="DispMedicationValidation.jsp?func_mode=print_reqd";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		await eval(responseText);
	}
	else{
        clearframes();
	}
}

function completeFilling(){
	if(parent.f_stage==undefined){
		var formObj =	parent.parent.DispMedicationPatDetFrame_3.f_disp_medication_filling;
		mainForm	=	formObj.DispMedicationAllStages;
		var doc		=	parent.parent.DispMedicationPatDetFrame_3.f_disp_medication_filling.document;
	}
	else{
        var formObj =	parent.f_stage;
		mainForm	=	formObj.DispMedicationAllStages;
		var doc		=	parent.f_stage.document;		
	}
	 var showFillPerson=document.getElementById('showFillPerson').value;  //added for AMS-CRF-0009[IN:030935] 
		
//if bill is settled then in against fill list transction should not proceed,to contron same below condition is written.
    if(doc.DispMedicationAllStages.fill_list.value=='AF'&& doc.DispMedicationAllStages.bPatientPaid.value =='true'){
		alert(getMessage("PH_BILL_SETTLED","PH"));
		return false;
	}
	//Adding start for ML-BRU-CRF-0473
	if(doc.DispMedicationAllStages.IncludeZeroQtyForIP !=undefined)
	  var alloc_zero_qty_ip = doc.DispMedicationAllStages.IncludeZeroQtyForIP.value;
	else
	  var alloc_zero_qty_ip="";

  //Adding end for ML-BRU-CRF-0473
	// Commented for SKR-SCF-0105
	//if(doc.DispMedicationAllStages.allow_yn.value=='Y'){

      var total_rec		=	"";
      total_rec			=	mainForm.tot_rec.value;
	  var rec_total		=	parseInt(total_rec);
	  var found			=	false;
	  var found2		=	false;
	  var scope			=	"";
	  var check_yn		=	'Y'
	  var patientId		=	mainForm.patient_id.value;
			//AAKH-CRF-0117 - start
	  	var approval_no_appl_flag = mainForm.approval_no_flag.value;
		var approval_no_app_for_patient_class = mainForm.approval_no_app_for_patient_class.value;//AAKH-CRF-0117
   		if(approval_no_app_for_patient_class=="Y" && (approval_no_appl_flag==true || approval_no_appl_flag=="true")){
		approval_proceed_flag = getApprovalNoValidation("F",mainForm);

		if(!approval_proceed_flag){
			alert(getMessage("PH_APPROVAL_NO_CANT_BE_BLANK","PH"));
			return false;
		}//AAKH-CRF-0117 - end
   }
	if(parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteria !=null){
		scope		=	parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteria.order_status.value;
		order_type	=	parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteria.order_type.value;
		parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteria.order_id.value="";//Added for [IN:45893]
	 }
	 else if(parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteriaIP !=null){ 
		 if(parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteriaIP.ip_scope!=undefined){
			scope		=	parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteriaIP.ip_scope.value;
			parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteriaIP.order_id.value="";//Added for [IN:45893]
			//order_type	=	parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteriaIP.order_type.value;
		 }
		 else{
			 check_yn='N';
		 }
	 }
     var verifyChecked = true; // Added for MMS-KH-CRF-0028[IN070605] - Start
                   
	 if(doc.DispMedicationAllStages.intractn_req_yn.value='true'){
       for(var k=1;k<rec_total;k++){		   
	       if(eval("mainForm.print_"+k)!=undefined && eval("mainForm.print_"+k+".value") == "Y" ){	    	  
	    		 verifyChecked = true;
	    		 break;
	       }
	       else {
	    		  if(k==rec_total-1){
	    			 verifyChecked = false;
	    		  }
	       }
	   }
	 }
	if(!verifyChecked && doc.DispMedicationAllStages.fill_list.value=='WF' && doc.DispMedicationAllStages.iv_prep_yn.value==""){
	   alert(getMessage("PH_ATLEAST_ONE_SELECTED",'PH'));
	   return;
	} // Added for MMS-KH-CRF-0028[IN070605] - End	 
	
	 if(doc.DispMedicationAllStages.fill_list.value=='WF' && alloc_zero_qty_ip == "Y"){//Adding start for ML-BRU-SCF-0473
                 for(k=1; k<rec_total; k++) {
			  if(eval("doc.DispMedicationAllStages.alloc_qty_"+k)!=undefined){
				 val		=	eval("doc.DispMedicationAllStages.alloc_qty_"+k+".value");
			   if(parseInt(trimString(val))==0 ){
	               if(eval("doc.DispMedicationAllStages.alloc_bms_chk_"+k)!=undefined){
						    eval("doc.DispMedicationAllStages.alloc_bms_chk_"+k).checked=true;
						    eval("doc.DispMedicationAllStages.alloc_bms_chk_"+k).value= 'Y';
						    eval("doc.DispMedicationAllStages.allocateyn_"+k).value = 'Y';
					  }
				 }
				 }
	      }
	}//Adding end for ML-BRU-CRF-0473

//if(check_yn=='Y'){
	if(scope=='H'){
		found =true;// added for SKR-SCF-1310
		for(i=1; i<rec_total; i++) {
		   if(eval("doc.release_flag"+i)!=undefined) {
			   val1=   eval("doc.release_flag"+i+".value"); 
			   if(val1=='Y'){
					found =true;
					break;
			   }				   
		   }
		}
	}
	else{
		for(i=1; i<rec_total; i++) {
			if(eval("doc.DispMedicationAllStages.bms_qty"+i)!=undefined) {			 
				val		=	eval("doc.DispMedicationAllStages.bms_qty"+i+".value");	
			//	found = true;//Added for SKR-SCF-1319 ,commented for 7979
				if(val!=undefined){
					if((!isNaN(parseInt(trimString(val))))){
						if((parseInt(trimString(val)))<0){								  
							found2=true;
							break;
						}
					}
				}               
			}
		}
		for(i=1; i<rec_total; i++) {
			if(eval("doc.DispMedicationAllStages.alloc_qty_"+i)!=undefined) {
				val		=	eval("doc.DispMedicationAllStages.alloc_qty_"+i+".value");
				var finding_remarks_yn; //ML-MMOH-SCF-2018
				finding_remarks_app = 	doc.DispMedicationAllStages.finding_remarks_app.value; //added for ML-MMOH-SCF-1871
				if(finding_remarks_app=="true"){
					finding_remarks_yn	=	eval("doc.DispMedicationAllStages.finding_remarks_yn_"+i+".value");//added for ML-MMOH-SCF-1871
				}
				val3    =   eval("doc.allocateyn_"+i+".value");	
				if(eval("doc.DispMedicationAllStages.alloc_bms_chk_"+i)!=undefined)
					if(eval("doc.DispMedicationAllStages.alloc_bms_chk_"+i+".checked") == true)
						alloc_bms_chk	= "Y"	;
					else
						alloc_bms_chk ="N";
				else
					alloc_bms_chk ="N"; 
				
			finding_remarks_app = 	doc.DispMedicationAllStages.finding_remarks_app.value; //added for ML-MMOH-SCF-1871
				if(doc.DispMedicationAllStages.fill_list.value=='WF' && parseInt(trimString(val))==0 && alloc_zero_qty_ip == "Y"){//Adding start for ML-BRU-CRF-0473
						
					  alloc_bms_chk='Y';
				}//Adding end for ML-BRU-CRF-0473
				
				if(doc.DispMedicationAllStages.fill_list.value=='WF' && parseInt(trimString(val))==0 && doc.DispMedicationAllStages.iv_prep_yn.value=="" && finding_remarks_yn == "Y" && finding_remarks_app=="true"){ //added for ML-MMOH-SCF-1871
				 
				 found=true;
				}

				if(val!=undefined){
					if(((!isNaN(parseInt(trimString(val))))&&(val3=='Y')&&(parseInt(trimString(val))>0))||alloc_bms_chk=='Y'){	
						found	= true;
						break;			
					}
				}
			}
			else{
			   if(eval("doc.alloc_qty"+i)!=undefined) {
					val		=	eval("doc.alloc_qty"+i+".innerText");
					val3    =   eval("doc.allocateyn_"+i+".value");
					if(val!=undefined){
						if((!isNaN(parseInt(trimString(val))))&&(val3=='Y')){	
							found	= true;
							break;			
						}
					}
				}
			}      
			   
			if((eval("doc.CompleteOrder"+i)!=undefined) ) {
				val1=   eval("doc.CompleteOrder"+i+".value");           
				if( val1=='Y'){
					 found	= true;
					 break;			
				}
			}	
			if((eval("doc.hold"+i)!=undefined) ) {
				val2=   eval("doc.hold"+i+".value"); 
				
				if( val2=='Y'){
					found	= true;
					break;			
				 }
			  }			  
			if(eval("mainForm.alloc_bms_chk_"+i) != undefined){
				if(eval("mainForm.alloc_bms_chk_"+i).value == 'Y') 
					found = true;
			}
		}
	}

	if(!found2){
		//added for SKR-SCF-0221 ICN 29319 -Start
		ValuesChanged="";
		if(doc.DispMedicationAllStages.ValuesChanged!=undefined)
			ValuesChanged = doc.DispMedicationAllStages.ValuesChanged.value; 
		fill_list =doc.DispMedicationAllStages.fill_list.value; 
		//added for SKR-SCF-0221 ICN 29319 -End
		if(found && ((fill_list == 'AF' && ValuesChanged =="false" ) || ( fill_list != 'AF' || ValuesChanged =="true"))){//{ && ( fill_list != 'AF' || ValuesChanged =="true") added for SKR-SCF-0221 ICN 29319 // Modified for KDAH-CRF-0231 [IN-034551] // (fill_list == 'AF' && ValuesChanged =="false" ) || ( fill_list != 'AF' || ValuesChanged =="true") chnaged to ((fill_list == 'AF' && ValuesChanged =="false" ) || ( fill_list != 'AF' || ValuesChanged =="true")) ICN - 64906
			eval(formApply( formObj.DispMedicationAllStages,PH_CONTROLLER ));
			if(showFillPerson=='Y'){//added for AMS-CRF-0009[IN:030935]
				var retVal = callFillPersonDetail(mainForm);
				if(retVal==undefined)
					return false;
			}
		}
		else{
			alert(getMessage("PH_NO_CHANGE","PH"));
			//return false; // Commented for ICN-64906
		}
	}
	else{
		alert(getMessage("PH_ALLOC_QTY_LESS_BMS_QTY","PH"));
		return false;
	}

	if(parent.parent.parent.document.f_query_criteria_token_info!=undefined){
		if(parent.parent.parent.document.f_query_criteria_token_info.frmDispMedicationQueryCriteriaTokenInfo!=null) {
			token_form	=	parent.parent.parent.document.f_query_criteria_token_info.frmDispMedicationQueryCriteriaTokenInfo;	
			token_form.token_no.disabled		=	false;
			token_form.token_no.value			=   "";
			token_form.token_series.disabled	=	false;
			token_form.queue_date.disabled	    =	false;
			parent.parent.parent.document.f_query_criteria_token_info.document.getElementById("Calendar").disabled	    =	false;
			//reload	=	false;
		}
	}
	parent.parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
	var homePage=""; //Added for  Bru-HIMS-CRF-073.1 [IN:047222]
	if(parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteria !=null){
		parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteria.change_status.value="";
		homePage = parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteria.homepage.value; //Added for  Bru-HIMS-CRF-073.1 [IN:047222]
	}
	else if(parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteriaIP !=null){
		parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteriaIP.change_status.value="";
		homePage = parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteriaIP.homepage.value; //Added for  Bru-HIMS-CRF-073.1 [IN:047222]
	} 
	//parent.parent.parent.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.btnSearch.click();

	if(result) {	
		callPrintDialog(mainForm,doc);
	}
	else{
		if(message!=''){
		     alert(message);
			   /*Below Condition is added by sureshkumar T for the incident no :  SRR20056-SCF-6413.1[Inc : 26642] */
			 return false; 
		}
		parent.parent.DispMedicationPatDetFrame_1.location.reload();					
		if(parent.parent.parent.f_query_criteria_buttons!=undefined){
			parent.parent.parent.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.btnSearch.click();
		}
	}
 /* Commented for SKR-SCF-0105
	}else{
		alert("Drug(s) related to selected order(s) is already in next stage.  Deliver it to process these orders.");
	}
  */	
	if(homePage=='Y'){ //Added for  Bru-HIMS-CRF-073.1 [IN:047222]
		parent.parent.parent.parent.parent.menuFrame.location.reload();
	}
}

function CompletedDelivery_lockStatus(p_user_name,Unlock_all_records_yn,disp_locn_code){
	var formObj				= parent.parent.f_query_criteria.document.frmDispMedicationQueryCriteriaIP;
	fill_proc_id1			= formObj.fill_proc_id.options[formObj.fill_proc_id.selectedIndex].value;
	var patient_id_status	="";
	var disp_stage			='DF';
	var p_delivery_fill_yn	='Y';
	var Icon_unlock_status	='N';
	
	if(Unlock_all_records_yn=='Y'){
		var bean_id		= "DispMedicationBean";
		var bean_name	= "ePH.DispMedicationBean";
		//var xmlDoc  = new ActiveXObject( "Microsoft.XMLDom" ) ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";

		xmlStr += " p_user_name=\"" + p_user_name + "\"";
		xmlStr += " fill_proc_id=\"" + fill_proc_id1 + "\"";
		xmlStr += " disp_stage=\"" + disp_stage + "\"";
		xmlStr += " patient_id_status=\"" + patient_id_status + "\"";
		xmlStr += " p_delivery_fill_yn=\"" + p_delivery_fill_yn + "\"";
		xmlStr += " Icon_unlock_status=\"" + Icon_unlock_status + "\"";
		xmlStr += " bean_id=\""+bean_id+"\"";
		xmlStr += " bean_name=\""+bean_name+"\"";
		xmlStr +=" /></root>";
		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","DispMedicationValidate.jsp?bean_id="+bean_id+"&p_user_name="+p_user_name+"&disp_locn_code="+disp_locn_code+"&bean_name="+bean_name+"&identity=unlockrecorddelivery_yn"+"&disp_stage="+disp_stage+"&Icon_unlock_status="+Icon_unlock_status+"&fill_proc_id="+fill_proc_id1+"&patient_id_status="+patient_id_status+"&p_delivery_fill_yn="+p_delivery_fill_yn,false);
		xmlHttp.send( xmlDoc ) ;
		//alert(xmlHttp.responseText);
		eval(xmlHttp.responseText);
	}
}

function completeFillDelivery(p_user_name,Unlock_all_records_yn,disp_locn_code){
	var formObj =parent.DispMedicationDeliveryFillList;
	eval(formApply( formObj.frmDispMedicationDeliveryFillList,PH_CONTROLLER ));
	CompletedDelivery_lockStatus(p_user_name,Unlock_all_records_yn,disp_locn_code);
	onSuccess();
	parent.parent.document.f_query_criteria.frmDispMedicationQueryCriteriaIP.fill_proc_id.onchange(); //Added for SRR20056-SCF-5401 ICN 24065
	var homePage = parent.parent.document.f_query_criteria.frmDispMedicationQueryCriteriaIP.homepage.value; //Added for  Bru-HIMS-CRF-073.1 [IN:047222]
 	if(homePage=='Y' ){ //Added for  Bru-HIMS-CRF-073.1 [IN:047222]
		var params = parent.parent.parent.parent.menuFrame.document.desktopParam.params.value;
		parent.parent.parent.parent.menuFrame.location.href ="../../ePH/jsp/PharmacistHomeMenu.jsp?"+params ;
		//parent.parent.parent.parent.menuFrame.location.reload;
	}
	//	getNursingUnit(formObj.fill_proc_id);
}

function onSuccess() {	
	//parent.parent.location.reload();	//code commended for scf 7082 by Rawther
	parent.DispMedicationDeliveryFillList.location.href="../../eCommon/html/blank.html";
	parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;

	var bean_id		= "DispMedicationBean";
	var bean_name	= "ePH.DispMedicationBean";
	//var xmlDoc  = new ActiveXObject( "Microsoft.XMLDom" ) ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";				
	xmlStr +=" /></root>";
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=ClearDispBeanvalues",false);
	xmlHttp.send( xmlDoc ) ;
	//alert(xmlHttp.responseText);
	eval(xmlHttp.responseText);
}

function completeDelivery(patient_id){
	var formObj = parent.parent.DispMedicationPatDetFrame_3.f_disp_medication_delivery.DispMedicationAllStages;
	var tot_recoeds="";
	var checkForHold = true;
	if(checkForHold == true){
		alert(getMessage("NTHNG_DLVR_ALL_RECRDS_HOLD","PH"));
		callDelivery(patient_id,"N");
	}
	else{
		callDelivery(patient_id,"Y");
	}
}

function checkOrderChanges(row_no,order_id,patient_id,disp_stage,practitioner_id,practitioner_name,fillingStatus,disp_locn_catg,group_by_patient,iv_prep_yn,disp_level,orderIDS_trxRefIDS,selectedOrderType,from_process_order_yn) {
	/*
		check the change_status variable of query criteria screen.if its not equal to empty call 
		the below method
	*/
//	from_process_order_yn="Y";
    if(	from_process_order_yn==null || from_process_order_yn==undefined)
		from_process_order_yn ="N";
	try{
		if(document.frmDispMedicationOrderDetails.continueSameOrder.value == "true"){
			return;
		}
	}
	catch (e){}
    clearOnRefresh();
	if(parent.parent.parent.f_query_criteria==null || parent.parent.parent.f_query_criteria==undefined){
		var obj = parent.parent.f_query_criteria;
	}
	else{
		var obj = parent.parent.parent.f_query_criteria;
	}
	if(disp_locn_catg=="O"){
		if(obj.frmDispMedicationQueryCriteria.change_status.value !=""){
			
	       if(from_process_order_yn=='N'){
				if(confirm(getMessage("PH_DISPENSE_DATA_MODIFIED","PH"))){
					//clearAllStagesBeanValues(obj.frmDispMedicationQueryCriteria);
					if(selectedOrderType != undefined)
						setSelectedOrder(selectedOrderType);
					clearprescription(order_id,patient_id);
					setTrxOrderIds(orderIDS_trxRefIDS, true);
					showOrderLineDetails(row_no,order_id,patient_id,disp_stage,practitioner_id,practitioner_name,fillingStatus,disp_locn_catg,group_by_patient,iv_prep_yn,disp_level,orderIDS_trxRefIDS)		//proceed with ur code
				}
		   }
		   else{
			   if(selectedOrderType != undefined)
					setSelectedOrder(selectedOrderType);

				clearprescription(order_id,patient_id);
				setTrxOrderIds(orderIDS_trxRefIDS, true);					
				showOrderLineDetails(row_no,order_id,patient_id,disp_stage,practitioner_id,practitioner_name,fillingStatus,disp_locn_catg,group_by_patient,iv_prep_yn,disp_level,orderIDS_trxRefIDS)		//proceed with ur code
		   }
		}
		else{
			setTrxOrderIds(orderIDS_trxRefIDS, false);
			showOrderLineDetails(row_no,order_id,patient_id,disp_stage,practitioner_id,practitioner_name,fillingStatus,disp_locn_catg,group_by_patient,iv_prep_yn,disp_level,orderIDS_trxRefIDS)		//proceed with ur code
		}
	}
	else{
		if(obj.frmDispMedicationQueryCriteriaIP.change_status.value !=""){
			if(from_process_order_yn=='N'){
				if(confirm(getMessage("PH_DISPENSE_DATA_MODIFIED","PH"))){
					//clearAllStagesBeanValues(obj.frmDispMedicationQueryCriteriaIP);
					if(selectedOrderType != undefined)
						setSelectedOrder(selectedOrderType);
					clearprescription(order_id,patient_id);
					setTrxOrderIds(orderIDS_trxRefIDS, true);					
					showOrderLineDetails(row_no,order_id,patient_id,disp_stage,practitioner_id,practitioner_name,fillingStatus,disp_locn_catg,group_by_patient,iv_prep_yn,disp_level,orderIDS_trxRefIDS)		//proceed with ur code
				}
			}
			else{
				if(selectedOrderType != undefined)
						setSelectedOrder(selectedOrderType);

					clearprescription(order_id,patient_id);
					setTrxOrderIds(orderIDS_trxRefIDS, true);					
					showOrderLineDetails(row_no,order_id,patient_id,disp_stage,practitioner_id,practitioner_name,fillingStatus,disp_locn_catg,group_by_patient,iv_prep_yn,disp_level,orderIDS_trxRefIDS)		//proceed with ur code
			}
		}
		else{
			setTrxOrderIds(orderIDS_trxRefIDS, false);
			showOrderLineDetails(row_no,order_id,patient_id,disp_stage,practitioner_id,practitioner_name,fillingStatus,disp_locn_catg,group_by_patient,iv_prep_yn,disp_level,orderIDS_trxRefIDS)		//proceed with ur code
		}
	}
}

function checkRestoreChanges(disp_locn_catg,login_user,disp_stage,disp_locn_code) {
	/*
		check the change_status variable of query criteria screen.if its not equal to
		empty call the below method
	*/
    UnLockStatus(login_user,disp_stage,disp_locn_code);
	if(disp_locn_catg=="O"){
		if(parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteria.change_status.value!=""){
			if(confirm(getMessage("PH_DISPENSE_DATA_MODIFIED","PH"))){
				clearAllStagesBeanValues(parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteria);
				parent.parent.parent.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.btnSearch.click(); // added for IN23897 --07/12/2010-- priya
			//	expand();  // commented for IN23897 --07/12/2010-- priya
			}
		}
		else{
			expand();
		}
	}
	else{
		if(parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteriaIP.change_status.value!=""){
			if(confirm(getMessage("PH_DISPENSE_DATA_MODIFIED","PH"))){
				clearAllStagesBeanValues(parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteriaIP);
				parent.parent.parent.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.btnSearch.click();  // added for IN23897 --07/12/2010-- priya
				//expand(); // commented for IN23897 --07/12/2010-- priya
			}
		}
		else{
			expand();
		}
	}
	return false;
}
async function callDelivery(patient_id,window_required){
	if(window_required=="Y"){
		var dialogHeight= "40" ;
		var dialogWidth	= "30" ;
		var dialogTop = "300" ;
		var center = "1" ;
		var status="no";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "" ;
		retVal = await window.showModalDialog("../../ePH/jsp/DispMedicationCollectorDetails.jsp?patient_id="+patient_id,arguments,features);	

		if(retVal=="OK"){
			var formObj =parent.parent.DispMedicationPatDetFrame_3.f_disp_medication_delivery;
			eval(formApply( formObj.DispMedicationAllStages,PH_CONTROLLER ));
			parent.parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
			return retVal;
		}
		else{
			parent.parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
		}
		return retVal;
	}
	else{
		var formObj =parent.parent.DispMedicationPatDetFrame_3.f_disp_medication_delivery;
		eval(formApply( formObj.DispMedicationAllStages,PH_CONTROLLER ));
		parent.parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+message;
	}
}

async function recordDelivery(param ){
	var formObj		="";
	var doc			="";
	if(parent.parent.DispMedicationPatDetFrame_3!=undefined||parent.parent.DispMedicationPatDetFrame_3!=null){
		formObj	=	parent.parent.DispMedicationPatDetFrame_3.f_disp_medication_delivery;
		 doc	=	parent.parent.DispMedicationPatDetFrame_3.f_disp_medication_delivery.document;
	}
	else{
        formObj	=	parent.f_stage;
		doc		=	parent.f_stage.document;
	}
	mainForm	=	formObj.DispMedicationAllStages;
	var patientClass = mainForm.patient_class.value;//MOHE-CRF-0026.1
	var settlementId = mainForm.settlement_id.value;
	var authStatusCompleted_yn =mainForm.authStatusCompleted_yn.value;//END
	 
	var approval_no_appl_flag = mainForm.approval_no_flag.value;  //AAKH-CRF-0117 - start
	var approval_no_app_for_patient_class = mainForm.approval_no_app_for_patient_class.value;//AAKH-CRF-0117
   if(approval_no_app_for_patient_class=="Y" && (approval_no_appl_flag==true || approval_no_appl_flag=="true")){
		approval_proceed_flag = getApprovalNoValidation("D",mainForm);

		if(!approval_proceed_flag){
			alert(getMessage("PH_APPROVAL_NO_CANT_BE_BLANK","PH"));
			return false;
		}
   }  //AAKH-CRF-0117 - end
   //MOHE-CRF-0026.1 start
   var iqvia_integration_flag = mainForm.iqvia_integration_flag.value; 
   var tot_rec =mainForm.tot_rec.value;  
   var patient_id = mainForm.patient_id.value;   
   var encounter_id = mainForm.encounter_id.value; 
   var iv_prep_value = mainForm.iv_prep_yn.value; 
   var postDisp_disp_data ="";
   var bean_id_1   = "DispMedicationBean";//MOHE-CRF-0026.1
	var bean_name_1 = "ePH.DispMedicationBean";//END 
   if ( iqvia_integration_flag!=undefined && (iqvia_integration_flag == true || iqvia_integration_flag == "true") && iv_prep_value=="" && patientClass=="OP" && settlementId =="X" && authStatusCompleted_yn=="Y"){ //MOHE-CRF-0026.1
	   
	   var request_type = "PHDISP";
	   var facility_id = mainForm.facility_id.value; 
	   var added_by_id = mainForm.added_by_id.value;
	   var login_at_ws_no = mainForm.login_at_ws_no.value;  	  
		for(var k=1;k<tot_rec;k++){	
				if(eval("mainForm.authChecked_"+k).disabled == true){				  
					if(eval("mainForm.authChecked_"+k).checked==true){
						var drug_code = eval("mainForm.drug_code"+k).value; 							
						var order_line_num = eval("mainForm.order_line_num"+k).value;  	
						var alloc_qty = eval("mainForm.allocate_qty"+k).value;	
						if (alloc_qty== "0.0" || alloc_qty==""){
							alert("Qty not allocated for the item");
							frmObj.alloc_qty_check.value = "Z"; 
							return false;
						}
						var uom = eval("mainForm.uom"+k).value;						
						var frequencyCode = eval("mainForm.frequencyCode"+k).value;
						var repeatValue = eval("mainForm.repeatValue"+k).value;
						var durnValue = eval("mainForm.durnValue"+k).value;
						var durationType = eval("mainForm.durationType"+k).value;
						var routeCode = eval("mainForm.routeCode"+k).value;
						var qtyValue = eval("mainForm.qtyValue"+k).value;
						var qtyUnit = eval("mainForm.qtyUnit"+k).value;  
						var dispTmpNo = eval("mainForm.dispTmpNo"+k).value;  
						var orderId = eval("mainForm.orderId"+k).value; 
				
						var xmlDoc="";
						var xmlHttp = new XMLHttpRequest();
						var xmlStr ="<root><SEARCH ";
						xmlStr += " patient_id=\""+patient_id+"\"";
						xmlStr += " encounter_id=\""+encounter_id+"\"";
						xmlStr += " orderId=\""+orderId+"\""; 
						xmlStr += " drug_code=\""+drug_code+"\""; 
						xmlStr += " order_line_num=\""+order_line_num+"\""; 
						xmlStr += " alloc_qty=\""+alloc_qty+"\""; 
						xmlStr += " uom=\""+uom+"\""; 
						xmlStr += " frequencyCode=\""+frequencyCode+"\""; 
						xmlStr += " repeatValue=\""+repeatValue+"\""; 
						xmlStr += " durnValue=\""+durnValue+"\""; 
						xmlStr += " durationType=\""+durationType+"\""; 
						xmlStr += " routeCode=\""+routeCode+"\""; 
						xmlStr += " qtyValue=\""+qtyValue+"\""; 
						xmlStr += " qtyUnit=\""+qtyUnit+"\"";  
						xmlStr += " dispTmpNo=\""+dispTmpNo+"\"";   
						xmlStr +=" /></root>" ;
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml"); 
						//xmlHttp.open( "POST", "DispMedicationValidation.jsp?func_mode=callDispense", false ) ;		
						xmlHttp.open("POST","DispMedicationValidate.jsp?bean_id="+bean_id_1+"&bean_name="+bean_name_1+"&identity=callDispense",false); //MOHE-CRF-0026.1 
						xmlHttp.send(xmlDoc); 
						eval(xmlHttp.responseText);
					}				
				}
			
		}
		
   }//MOHE-CRF-0026.1 END
	var billing_interface_yn =mainForm.billing_interface_yn.value;
	var disp_locn_catg       =mainForm.disp_locn_catg.value;
	var total_rec="";
    	total_rec=mainForm.tot_rec.value;
	var rec_total		=	parseInt(total_rec);
	var found=false;
	    		
	var deliveryChecked = true;  // Added for MMS-KH-CRF-0028 [IN070605] - Start
	
	for(var k=1;k<rec_total;k++){ 		   
	       if(eval("formObj.DispMedicationAllStages.deliveryChecked_"+k)!=undefined && eval("formObj.DispMedicationAllStages.deliveryChecked_"+k+".value")=='Y'){	    	  
	    	   deliveryChecked = true;
	    		 break;
	       }
	       else {
	    		  if(k==rec_total-1){
	    			  deliveryChecked = false;
	    		  }
	       }
	}
	     
	if(!deliveryChecked){
	   alert(getMessage("PH_ATLEAST_ONE_SELECTED",'PH'));
	   return;
	} // Added for MMS-KH-CRF-0028 [IN070605] - End
	
	for(i=1; i<rec_total; i++) {
		if(eval("doc.alloc_qty"+i)!=undefined) {
			val		=	eval("doc.alloc_qty"+i+".innerText");
			if(val!=undefined){
				if(!isNaN(parseInt(trimString(val))) && eval("doc.del_detail"+i+".value")==("Y")&& eval("doc.del_detail"+i+".disabled")==false){	
					found	= true;
					break;			
				}
				else{
					val2=   eval("doc.order_line_status"+i+".value");           
					if( (val2=='AL' || val2=='IP')&& (eval("doc.del_detail"+i+".value")==("Y"))){			
						found	= true;
						break;			
					}
				}
			}
		}
		if((eval("doc.CompleteOrder"+i)!=undefined) ) {
			val1=   eval("doc.CompleteOrder"+i+".value");           
			if( val1=='Y'){			
				found	= true;
				break;			
			}
		}
	}
	var retVal="1";  // Added for RUT-CRF-0035 [IN029926]
	var alertForOutStandingReturn = false//added for MMS-QH-CRF-0201 [IN:052255] -start
	if(found==true){
		retn_disp_med_for_outstanding = document.getElementById('retn_disp_med_for_outstanding').value;//added for MMS-QH-CRF-0201 [IN:052255] -start
		tot_groos_pat_payable = document.getElementById('tot_groos_pat_payable').value;
		patient_id = document.getElementById("patient_id").value;
		disp_locn_code = mainForm.disp_locn_code.value;
		disp_cash_coll_stage  =	document.getElementById('disp_cash_coll_stage').value;
		if(isNaN(tot_groos_pat_payable))
			tot_groos_pat_payable = 0;
		if(retn_disp_med_for_outstanding == 'Y' && billing_interface_yn == 'Y' && disp_locn_catg == 'O' &&  disp_cash_coll_stage == 'D' && parseFloat(tot_groos_pat_payable)>0 ){
			alertForOutStandingReturn = true;
			if(!confirm(getMessage("PH_CONFIRM_PATIENT_PAYABLE_AMOUNT","PH").replace("$$",tot_groos_pat_payable))){
				alert(getMessage("PH_ACCESS_RELEASE_BATCH","PH"));
				return false;
			}
		}
		else
			alertForOutStandingReturn = false;//added for MMS-QH-CRF-0201 [IN:052255] -end
		if(document.getElementById("userAuthPINYN").value=='Y'){   // Added for RUT-CRF-0035 [IN029926] -- begin
			var dialogHeight	= "50vh";
			var dialogWidth		= "50vw";
			var dialogTop		=  window.screen.availWidth - 1100;
			var dialogLeft		=  window.screen.availWidth - 1000;
			var center			= "0";
			var status			= "no";	
			var stage			= document.getElementById("disp_stage").value;
			var features		= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
			retVal= await top.window.showModalDialog("../../ePH/jsp/UserPINAuthorization.jsp?call_from="+stage+"&disp_category="+disp_locn_catg+"&disp_locn_code="+mainForm.disp_locn_code.value,"",features);
			if(retVal== undefined || retVal=='C'){
				return;
			}
			else{
				retVal=trimString(retVal);
				if(retVal!="0"){
					await storeUserinBean(retVal);
				}
			}
		}      
		if(retVal!="0"){ //RUT-CRF-0035 [IN029926] -- end
			eval(formApply( formObj.DispMedicationAllStages,PH_CONTROLLER ));
		}
	}
	else{
		alert(getMessage("NO_RECORDS_HAVE_BEEN_SELECTED","PH"));
	}
	var reload	=	true;

	if(parent.parent.parent.document.f_query_criteria_token_info!=null){
		if(parent.parent.parent.document.f_query_criteria_token_info.frmDispMedicationQueryCriteriaTokenInfo!=null) {
			token_form	=	parent.parent.parent.document.f_query_criteria_token_info.frmDispMedicationQueryCriteriaTokenInfo;
			token_form.token_no.disabled		=	false;
			token_form.token_series.disabled	=	false;
			token_form.token_no.value			=   "";
			token_form.queue_date.disabled	    =	false;
			parent.parent.parent.document.f_query_criteria_token_info.document.getElementById("Calendar").disabled	    =	false;
			reload	=	false;
		}
	}
	var homePage=""; //Added for  Bru-HIMS-CRF-073.1 [IN:047222]
    if(parent.parent.parent.f_query_criteria!=undefined){
		if(parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteria !=null){
			parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteria.change_status.value="";
			parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteria.order_id.value="";//Added for [IN:45893]
			homePage = parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteria.homepage.value; //Added for  Bru-HIMS-CRF-073.1 [IN:047222]
		}
		else if(parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteriaIP !=null){
			parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteriaIP.change_status.value="";
			parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteriaIP.order_id.value="";//Added for [IN:45893]
			homePage = parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteriaIP.homepage.value; //Added for  Bru-HIMS-CRF-073.1 [IN:047222]
		}
		parent.parent.parent.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.btnSearch.disabled	=	false;
	}
	if(result) {
		if(param=="CYTO_WS_FINALIZE" || param=="TPN_WS_FINALIZE" || param=="WS_FINALIZE"){
			await callWSLabelWindow('',mainForm.order_id.value);
		/*	var dialogHeight= "16" ;
			var dialogWidth	= "35" ;
			var dialogTop = "300" ;
			var center = "1" ;
			var status="no";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
			var arguments	= "" ;
			var retVal= window.showModalDialog("../../ePH/jsp/DispMedicationWSLabel.jsp?order_id="+mainForm.order_id.value,arguments,features);
			if( retVal !="SAVED"){
				return false;
			}
			*/
			//deliverManufactureLabel(mainForm.order_id.value);
			var dialog_result = await showWSDialogForPrinting(param);
			if(dialog_result!=null){
				dialog_result_split = dialog_result.split(":");
				selected_ws_report_1= dialog_result_split[0];
				selected_ws_report_2= dialog_result_split[1];
				selected_ws_report_3= dialog_result_split[2];
				selected_ws_report_4= dialog_result_split[3]; // Added for GHL-CRF-0468   [21/12/2017]
				selected_ws_report_5= dialog_result_split[4]; // Added for GHL-CRF-0468   [21/12/2017]
                if(selected_ws_report_1=='Y'||selected_ws_report_2=='Y' || selected_ws_report_3 != '' || selected_ws_report_4=='Y'||selected_ws_report_5=='Y'  ){ // selected_ws_report_4=='Y'||selected_ws_report_5=='Y' Added for GHL-CRF-0468   [21/12/2017]
                	await callLabelPrintDialog(mainForm,mainForm.worksheet_id.value,selected_ws_report_1,selected_ws_report_2,selected_ws_report_3,param,selected_ws_report_4,selected_ws_report_5); // selected_ws_report_4=='Y'||selected_ws_report_5=='Y' Added for GHL-CRF-0468   [21/12/2017]
				}

				billing_interface_yn =mainForm.billing_interface_yn.value;
				if(billing_interface_yn=='Y'&&disp_locn_catg=='O'){
					await getbillingdetails(mainForm.disp_locn_code.value);
				}
				else{
				   clearframes();
				}
			}
		}
   }

   if(parent.parent.parent.parent.messageFrame!=null){
		parent.parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+message;
	}
	else{
       parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+message;
	}
	
	if(parent.parent.parent.document.f_query_criteria_token_info!=null){
		if(parent.parent.parent.document.f_query_criteria_token_info.frmDispMedicationQueryCriteriaTokenInfo!=null) {
			token_form	=	parent.parent.parent.document.f_query_criteria_token_info.frmDispMedicationQueryCriteriaTokenInfo;
			token_form.token_no.disabled		=	false;
			token_form.token_series.disabled	=	false;
			token_form.queue_date.disabled	    =	false;
			parent.parent.parent.document.f_query_criteria_token_info.document.getElementById("Calendar").disabled	    =	false;
			token_form.token_no.value			=   "";
			reload	=	false;
		}
	}
	if(parent.parent.parent.f_query_criteria!=undefined){
		if(parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteria !=null){
			parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteria.change_status.value="";
		}
		else if(parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteriaIP !=null){
			parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteriaIP.change_status.value="";
		}
		parent.parent.parent.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.btnSearch.disabled	=	false;
	}

	if(result) {
		/*if(param=="CYTO_WS_FINALIZE" || param=="TPN_WS_FINALIZE" || param=="WS_FINALIZE"){
			deliverManufactureLabel(mainForm.order_id.value);
			var dialog_result = showWSDialogForPrinting(param);
			if(dialog_result!=null){
				dialog_result_split = dialog_result.split(":");
				selected_ws_report_1= dialog_result_split[0];
				selected_ws_report_2= dialog_result_split[1];
				callLabelPrintDialog(mainForm,mainForm.worksheet_id.value,selected_ws_report_1,selected_ws_report_2,param);
			}

		}else*/
		if(homePage=='Y'){ //Added for  Bru-HIMS-CRF-073.1 [IN:047222]
			parent.parent.parent.parent.parent.menuFrame.location.reload();
		}
		//MOHE-CRF-0026.1
		var currStage = mainForm.curr_stage.value; //MOHE-CRF-0026.1  
        if ( iqvia_integration_flag!=undefined && (iqvia_integration_flag == true || iqvia_integration_flag == "true") && iv_prep_value==""){
        //	alert("1234");    commented for MOHE-CRF-0026.1
        	await callInterfacePostDispense(currStage);  
        	
        }//END 
		if(param!="CYTO_WS_FINALIZE" && param!="TPN_WS_FINALIZE" && param!="WS_FINALIZE"){
			await callPrintDialog(mainForm,doc);
		  	return;
		}

		if(parent.parent.parent.parent.messageFrame!=undefined){
			parent.parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
		}

		/*if(reload) { // commented for ML-MMOH-CRF-0435 [IN:057357]
			if(parent.parent.parent.f_query_criteria_buttons!=undefined){
				parent.parent.parent.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.btnSearch.click();
			}
		}*/
		 /************************/
		if(parent.f_query_add_mod!=undefined){
			  parent.f_stage.location.href="../../eCommon/html/blank.html";
			  parent.f_disp_medication_all_stages_legends.location.href="../../eCommon/html/blank.html";
			  parent.dispframes.rows="8%,22%,*,0%,0%,0%,0%,0%,10%";
			  parent.f_query_add_mod.document.TaskListQueryCriteria.btnProceed.click();
		}
    }
	else{
		if(message!=''){
		     alert(message);
			/*Below Condition is added by sureshkumar T for the incident no :  SRR20056-SCF-6413.1[Inc : 26642] */
			 return false;
		}
		parent.parent.DispMedicationPatDetFrame_1.location.reload();					
		if(parent.parent.parent.f_query_criteria_buttons!=undefined){
			parent.parent.parent.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.btnSearch.click();
		}
	}
}

async function callWSLabelWindow(ord_type,order_id ){
//added for ml-mmoh-crf-0468 start
	
	var formObj = parent.parent.DispMedicationPatDetFrame_3.f_disp_medication_filling;
	//alert(formObj.DispMedicationAllStages);
	if(formObj != undefined && formObj != "undefined" ){ //added for ml-mmoh-crf-0468
	mainForm = formObj.DispMedicationAllStages;
	 //alert("tpn_mf_label"+mainForm.tpn_mf_label.value);
	if(mainForm !="undefined" || mainForm != undefined){
	if (order_id == "" && mainForm.order_id != null && mainForm.order_id != undefined && (mainForm.tpn_mf_label.value== true || mainForm.tpn_mf_label.value =="true" )
			&& mainForm.ord_type.value=="TD"  ) {
		order_id = eval("mainForm.order_id").value;
	//	alert(order_id);
	}
	}
	} 
	//added for ml-mmoh-crf-0468 
	
	var dialogHeight= "16" ;
	var dialogWidth	= "35" ;
	var dialogTop = "300" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var retVal=await window.showModalDialog("../../ePH/jsp/DispMedicationWSLabel.jsp?order_id="+order_id+"&ord_type="+ord_type,arguments,features);
	if( retVal !="SAVED"){
		callWSLabelWindow(ord_type,order_id );
	}
}

function getbillingdetails(disp_locn_code){
	var bean_id			=	mainForm.bean_id_1.value;
	var bean_name		=	mainForm.bean_name_1.value;
	var xmlStr ="<root><SEARCH ";
	xmlStr+= "bean_id =\"" + bean_id + "\" " ;
	xmlStr+= "bean_name=\"" + bean_name + "\" " ;
	xmlStr+= "disp_locn_code=\"" + disp_locn_code + "\" " ;
	
	xmlStr +=" /></root>" ;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","DispMedicationValidation.jsp?func_mode=GETBLDETAILS",false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);
}

function storeDispensingDetails(issue_token_on_regn_yn){
	var formObj = document.frmDispMedicationDeliveryDetails;
	var collected_by = formObj.collected_by.value;
	var gender		 = formObj.gender.value;
	var nationality  = formObj.nationality.value;
	var dispensed_by = formObj.dispensed_by.value;
	var language_id	 =formObj.Language_id.value;
	var date_time	 = convertDate(formObj.date_time.value,"DMYHM",language_id,"en");
	var Received_at	 = formObj.Received_at.value;
	var practioner_name =formObj.practioner_name.value;
	var practioner_id  =formObj.practioner_id.value;
	var practioner_name=formObj.practioner_name.value;
	var disp_locn_catg =formObj.disp_locn_catg.value;
	var token_series_code = "";
	var token_number	  = "";
	if(issue_token_on_regn_yn=="Y" && disp_locn_catg =="O"){
		token_series_code = formObj.token_series_code.value;
		token_number	  = formObj.token_number.value;
	}
	var fields  = new Array() ;
	var names   = new Array() ;
	var i=0;

	if(collected_by==""){
		fields[i]   = formObj.collected_by ;
		names[i]   = "Received By " ;
		i++;
	}else if(gender=="") {
		fields[i]   = formObj.gender ;
		names[i]   = "Gender " ;
		i++;
	}
   /* if(Received_at=='B')
	{
		if(practioner_name=="")
		{
		  fields[i]   = formObj.practioner_name ;
	     names[i]   = "Counter checked by " ;
		}
	}*/
   /*if(Received_at=='B')
	{
       if(practioner_name=="")
		{
		   alert("formObj.practioner_name"+formObj.practioner_name);
	     fields[1]   = formObj.practioner_name ;
	     names[1]   = "Counter checked by " ;
		}
   }*/
	if(checkFlds( fields, names)){
		var bean_id		= formObj.bean_id.value ;
		var bean_name	= formObj.bean_name.value ;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr += " collected_by=\"" + collected_by + "\"";
		xmlStr += " gender=\"" + gender + "\"";
		xmlStr += " nationality=\"" + nationality + "\"";
		xmlStr += " dispensed_by=\"" + dispensed_by + "\"";
		xmlStr += " date_time=\"" + date_time + "\"";

		if(issue_token_on_regn_yn=="Y"){
			xmlStr += " token_series_code=\"" + token_series_code + "\"";
			xmlStr += " token_number=\"" + token_number + "\"";
		}
		xmlStr += " Received_at=\"" + Received_at + "\"";
		xmlStr += " practioner_id=\"" + practioner_id + "\"";
		xmlStr += " practioner_name=\"" + practioner_name + "\"";
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=storeDeliveryDetails&issue_token_on_regn_yn="+issue_token_on_regn_yn, false ) ;
		xmlHttp.send( xmlDoc ) ;
/*		window.returnValue="OK";
		
		window.close();*/
		parent.document.getElementById('dialog-body').contentWindow.returnValue = "OK"; 
		parent.document.getElementById('dialog_tag').close();  
	}
}

function focusInToPassword(mode){
	if(mode=="Y"){
		document.getElementById('password').focus();
	}
}

function clearAllStagesBeanValues(obj){

	if(parent.parent.DispMedicationPatDetFrame_1 == null)
		var frmObj = parent.f_query_result.DispMedicationPatDetFrame_1.order_details.frmDispMedicationOrderDetails
	else
		var frmObj = parent.parent.DispMedicationPatDetFrame_1.order_details.frmDispMedicationOrderDetails;
	bean_id		=	frmObj.bean_id_1.value;
	bean_name	=	frmObj.bean_name_1.value

	var xmlStr ="<root><SEARCH ";
	xmlStr+= "bean_id =\"" + bean_id + "\" " ;
	xmlStr+= "bean_name=\"" + bean_name + "\" " ;
	xmlStr +=" /></root>" ;
	var temp_jsp="DispMedicationValidation.jsp?func_mode=clearBeanValues";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	obj.change_status.value="";
}
function clearprescription(order_id,patient_id){
	var frmObj = parent.parent.DispMedicationPatDetFrame_1.order_details.frmDispMedicationOrderDetails;
	bean_id		=	frmObj.bean_id_1.value;
	bean_name	=	frmObj.bean_name_1.value

	var xmlStr ="<root><SEARCH ";
	xmlStr+= "bean_id =\"" + bean_id + "\" " ;
	xmlStr+= "bean_name=\"" + bean_name + "\" " ;
	xmlStr+= "patient_id =\"" + patient_id + "\" " ;
	xmlStr+= "order_id=\"" + order_id + "\" " ;
	xmlStr +=" /></root>" ;
	var temp_jsp="DispMedicationValidation.jsp?func_mode=clearPrescription";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;

}
function showCriteria(obj){

	var formObj = parent.f_query_criteria.document;
	var formObjButtons =parent.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons;
	try{formObj.getElementById('row3').style="display";}catch(e){}
	try{formObj.getElementById('row4').style="display";}catch(e){}
	try{formObj.getElementById('row6').style="display";}catch(e){}
	try{formObj.getElementById('row5').style="display";}catch(e){}//code added for Bru-HIMS-CRF-416[IN045566]-- Start
	try{formObj.getElementById('row1').style="display";}catch(e){}
	try{formObj.getElementById('row2').style="display";}catch(e){}//code added for Bru-HIMS-CRF-416[IN045566]-- End
	//obj.style.display="none"; //code commented for Bru-HIMS-CRF-416[IN045566]
	//formObjButtons.btnAdditionalCriteria.style="display";
	document.getElementById("btnAdditionalCriteria").style="display";
	//parent.f_query_result.DispMedicationPatFrame.location.href="../../eCommon/html/blank.html";//code commented for Bru-HIMS-CRF-416[IN045566]
	var formObjQueryCriteria = parent.document.f_query_criteria.frmDispMedicationQueryCriteria;
	var tab_based_group_sort_disp	    =   formObjQueryCriteria.tab_based_group_sort_disp.value;
	
	if(tab_based_group_sort_disp=="Y"){
		//parent.DispMedicationQueryCriteriaFrameSet.rows="0,162,30,0,*";//code '0,162,*,0,0' replaced by '0,135,30,0,*'  for ML-MMOH-CRF-1666[38777]
		parent.document.getElementById("f_query_criteria_token_info").style.height="0vh";
		parent.document.getElementById("f_query_criteria").style.height="34vh";
		parent.document.getElementById("f_query_criteria_buttons").style.height="5vh";
		parent.document.getElementById("f_query_criteria_additional").style.height="0vh";
		parent.document.getElementById("f_query_result").style.height="70vh";
	}
	else
		{
		//parent.DispMedicationQueryCriteriaFrameSet.rows="0,135,30,0,*";//code '0,135,*,0,0' replaced by '0,135,30,0,*'  for Bru-HIMS-CRF-416[IN045566]
		parent.document.getElementById("f_query_criteria_token_info").style.height="0vh";
		parent.document.getElementById("f_query_criteria").style.height="30vh";
		parent.document.getElementById("f_query_criteria_buttons").style.height="5vh";
		parent.document.getElementById("f_query_criteria_additional").style.height="0vh";
		parent.document.getElementById("f_query_result").style.height="70vh";
		}
}

function getStoreCodeDesc(){

	var formObj=document.DispMedicationAllStages;

	var bean_id   = formObj.bean_id.value;
	var bean_name = formObj.bean_name.value;
	//var xmlDoc  = new ActiveXObject( "Microsoft.XMLDom" ) ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr +=" /></root>";
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=getStoreCodeDesc",false);
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);
}
function getItemCount(drug_code){

	var formObj=document.DispMedicationAllStages;
	if(formObj==undefined){
		formObj = document.frmDispMedicationWSCalSec;
		var bean_id   = formObj.bean_id.value;
		var bean_name = formObj.bean_name.value;
		//var xmlDoc  = new ActiveXObject( "Microsoft.XMLDom" ) ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr += " bean_id=\""+bean_id+"\"";
		xmlStr += " bean_name=\""+bean_name+"\"";
		xmlStr +=" /></root>";
		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		if(formObj.rf_id != null)
			var rf_id = formObj.rf_id.value;
		else
			var rf_id = "";

		xmlHttp.open("POST","DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=getItemCount&drug_code="+drug_code+"&drug_form="+formObj.drug_form.value+"&rf_id="+rf_id,false);
		xmlHttp.send( xmlDoc ) ;
		eval(xmlHttp.responseText);
	}
	else{
		var bean_id   = formObj.bean_id.value;
		var bean_name = formObj.bean_name.value;
		//var xmlDoc  = new ActiveXObject( "Microsoft.XMLDom" ) ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr += " bean_id=\""+bean_id+"\"";
		xmlStr += " bean_name=\""+bean_name+"\"";
		xmlStr +=" /></root>";
		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=getItemCount&drug_code="+drug_code,false);
		xmlHttp.send( xmlDoc ) ;
		eval(xmlHttp.responseText);
	}
}

var store_code_desc = "";
function sendStoreCodeDesc(obj){
	store_code_desc =  obj
}

var item_count = "";
function assignItemCount(obj){
	item_count = obj;
}

function assignItemCode(){
/*	window.returnValue = document.frmDispMedicationVerifyStockDetails.item_code.value;
	window.close();*/
	parent.document.getElementById('dialog-body').contentWindow.returnValue = document.frmDispMedicationVerifyStockDetails.item_code.value;
	parent.document.getElementById('dialog_tag').close(); 
}

var total_available_qty = "";
function assignTotalAvailableQty(total){
	total_available_qty = total;
}
/*function CheckPatReqd(Obj){
	alert(parent.parent.DispMedicationPatDetFrame_3.f_disp_medication_verification.forms[0].name);
var formObj = parent.parent.DispMedicationPatDetFrame_3.f_disp_medication_verification;
	if(Obj.checked==true)
		Obj.value="C";
	else
		Obj.value="";
}*/

async function callBatchSearchVerification(drug_code,row,drug_name,pres_qty,trade_code,end_date) {

	getStoreCodeDesc();
	var storeArray =  store_code_desc.split("::");
	var store_code = storeArray[0];
	getItemCount(drug_code);
	var includeZeroStockBatches ="N";
	var includeExpiredBatches ="N";
	var includeSuspendedBatches ="N";
	var searchFunction ="N";
	var multipleSelect ="Y";
	if(item_count != "1" && item_count != "0" ){

		var dialogHeight	= "90vh" ;
		var dialogWidth		= "90vw";
		var dialogTop		= "20" ;
		var dialogLeft		= "0" ;
		var status			="no";
		var features	= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "";
		retVal=await top.window.showModalDialog("../../ePH/jsp/DispMedicationVerifyStockDetails.jsp?drug_name="+escape(drug_name),arguments,features);
		if(retVal!=undefined && retVal!=""){
			var arr = retVal.split(":::");
			var item_code	=	arr[0];
			var rf_drug_flag=	arr[1];	//	RF - Reconst Fluid
			var retval=await callBatchSearchWindow(item_code,store_code,includeZeroStockBatches,includeExpiredBatches,includeSuspendedBatches,searchFunction,multipleSelect,'','','',end_date,'N');
			getTotalAvailableQunatity();
			if(parseFloat(total_available_qty)<parseFloat(pres_qty)){
				eval("parent.parent.DispMedicationPatDetFrame_3.f_disp_medication_verification.DispMedicationAllStages.stock"+row).style.backgroundColor="yellow";
			}
		}
		return false;
	}

	if(item_count == "1"){
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		var bean_id   = "DispMedicationBean";
		var bean_name = "ePH.DispMedicationBean"
		var temp_jsp="DispMedicationValidate.jsp?identity=getItemCodeForDrug&bean_id="+bean_id+"&bean_name="+bean_name+"&drug_code="+drug_code;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		eval(xmlHttp.responseText) ;
		var item_code = single_item_code;
	}
	if(item_count=="0"){
		var item_code = drug_code;
	}
	var retval=await callBatchSearchWindow(item_code,store_code,includeZeroStockBatches,includeExpiredBatches,includeSuspendedBatches,searchFunction,multipleSelect,trade_code,'','',end_date,'N');
	getTotalAvailableQunatity();
	if(parseFloat(total_available_qty)<parseFloat(pres_qty)){
		parent.parent.DispMedicationPatDetFrame_3.f_disp_medication_verification.document.getElementById('stock'+row).style.backgroundColor="yellow";
	}
}

function getTotalAvailableQunatity(){
	var bean_id  = "DispMedicationBean";
	var bean_name= "ePH.DispMedicationBean"
	//var xmlDoc  = new ActiveXObject( "Microsoft.XMLDom" ) ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr +=" /></root>";
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=getTotalAvailableQty",false);
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);
}

async function showPrintDialog(called_from,disp_no,login_user,facility_id,patient_id,locn_code,patient_class,curr_stage,complete_order_flag,billing_det, blDocSrlNo,disp_locn,ordering_facility_id){ //ordering_facility_id added for MOHE-CRF-0060
	if(parent.parent.parent.f_query_criteria!=undefined){
		if(parent.parent.parent.f_query_criteria.document.frmDispMedicationQueryCriteria!=null) {		
			order_type	=	parent.parent.parent.f_query_criteria.document.frmDispMedicationQueryCriteria.order_type.value;
		}
		else if(parent.parent.parent.f_query_criteria.document.frmDispMedicationQueryCriteriaIP!=null){
			order_type	=	parent.parent.parent.f_query_criteria.document.frmDispMedicationQueryCriteriaIP.order_type.value;
		}
    }
	var	dialogHeight	= "90vh" ;
	var dialogWidth		= "90vw";
	var dialogTop		= "10" ;
	var dialogLeft		= "10" ;
	var center			= "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" +dialogTop+";scroll=no";
	var arguments	= "" ;

	retVal =await top.window.showModalDialog("../../ePH/jsp/DispMedicationPrintDialogFrame.jsp?called_from=DispMedication&disp_no="+disp_no+"&login_user="+login_user+"&facility_id="+facility_id+"&patient_id="+patient_id+"&disp_locn="+disp_locn+"&patient_class="+patient_class+"&order_type="+order_type+"&complete_order_flag="+complete_order_flag+"&curr_stage="+curr_stage+"&locn_code="+locn_code,arguments,features);	
	//window.open("../../ePH/jsp/DispMedicationPrintDialog.jsp?called_from=DispMedication&disp_no="+disp_no+"&login_user="+login_user+"&facility_id="+facility_id+"&patient_id="+patient_id+"&disp_locn="+disp_locn+"&patient_class="+patient_class+"&order_type="+order_type+"&complete_order_flag="+complete_order_flag+"&curr_stage="+curr_stage,arguments,features);	

	if(retVal==undefined || retVal=="" || retVal=="false"){
		await showPrintDialog(called_from,disp_no,login_user,facility_id,patient_id,locn_code,patient_class,curr_stage,complete_order_flag,billing_det, blDocSrlNo,disp_locn);
	}
	else{
		if( billing_det!='' && billing_det!=null && patient_class=='O' && ( curr_stage=='D'|| curr_stage=='AS' )){
			await callbillingwindow(billing_det,disp_locn, blDocSrlNo,ordering_facility_id); //ordering_facility_id added for MOHE-CRF-0060
		}
		else{
			await clearframes();
		}
	}
}
/*function changeLang(obj,tab){
	if(tab=="P")
		document.DispMedicationPrintDialog.printDialogLang.value=obj.value;
	if(tab=="B")	
		document.DispMedicationPrintDialog.bmsTabLang.value=obj.value;
}*/

function printOnlineDispense(frmObj,type) { 
	bean_id				=	"DispMedicationAllStages" ;
	bean_name			=	"ePH.DispMedicationAllStages";

	var	bean_id_1		=	"DispMedicationBean" ;
	var	bean_name_1		=	"ePH.DispMedicationBean";

	var fields  = new Array() ;
	var names   = new Array() ;			

	var print_opt	=	"";
	var printOthers =	"";
	var selLanguage	=   "";
	var bmsLang = "";
	
	var printInclude="";//Added for RUT-CRF-0061 - Start
	var printSeparate="";
	var printOnly="";
	var printTaper="";
	var printType="";	//Added for RUT-CRF-0061 - End
	var printRefill ="";//Added for MOHE-CRF-0069
	login_user		=	frmObj.login_user.value;
	facility_id		=	frmObj.facility_id.value;
	patient_id		=	frmObj.patient_id.value;
	disp_no			=	frmObj.disp_no.value;
	locn_code		=	frmObj.locn_code.value; //disp_locn changed to locn_code for [IN:046496]-Billing - &  AMS-SCF-0300 [IN:048310]
	patient_class	=	frmObj.patient_class.value;
	order_type		=	frmObj.order_type.value;
	curr_stage		=	frmObj.curr_stage.value;
	bmsLang			=	frmObj.bmsTabLang.value;  // newly added for CRF-074 by manickam
	
	if(frmObj.storage_locn.value != ""){//Added Bru-HIMS-CRF-142 [IN:030195] - start // =="Y" changed to != "" for [IN:041201]
		var token_series ='';
		var patient_arvd ='';
	    var xmlStr ="<root><SEARCH ";
		xmlStr+= "bean_id  =\"" + bean_id + "\" " ;
		xmlStr+= "bean_name =\"" + bean_name + "\" " ;
		xmlStr+= "bean_id_1  =\"" + bean_id_1 + "\" " ;
		xmlStr+= "bean_name_1 =\"" + bean_name_1 + "\" " ;
		xmlStr+= "str_locn=\"" + frmObj.storage_locn.value + "\" " ;
		xmlStr+= "disp_locn_code=\"" + frmObj.dis_loc_code.value + "\" " ;
		xmlStr+= "curr_stage=\"" + frmObj.curr_stage.value + "\" " ;
		xmlStr+= "token_series=\"" +frmObj.token_series.value + "\" " ;
		xmlStr+= "Orderresult_id=\"" +frmObj.Orderresult_id.value + "\" " ;
		xmlStr+= "patient_arvd=\"" + patient_arvd + "\" " ;
		xmlStr+= "patient_id=\"" + patient_id + "\" " ;
		xmlStr +=" /></root>";
		var temp_jsp="DispMedicationValidation.jsp?func_mode=storage_locn1";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		
		xmlHttp.open("POST",temp_jsp,true);
		xmlHttp.send(xmlDoc);
		 //clearOnRefresh();
	}//Added for Bru-HIMS-CRF-142 [IN:030195] - end
	if(document.getElementById('enableTab') == undefined ){
		if(frmObj.bal_sheet != undefined)
			frmObj.bal_sheet.checked = false;
	}
	var print_opt_MP = "";
	if((frmObj.disp_sheet != undefined && frmObj.disp_sheet.checked) && (frmObj.bal_sheet != undefined && frmObj.bal_sheet.checked) && (frmObj.disp_label != undefined && frmObj.disp_label.checked) )
		print_opt		=	"A";
	else if((frmObj.disp_sheet != undefined && frmObj.disp_sheet.checked) && (frmObj.bal_sheet != undefined && frmObj.bal_sheet.checked ))
		print_opt		=	"DB";
	else if((frmObj.disp_sheet != undefined && frmObj.disp_sheet.checked) && (frmObj.disp_label != undefined && frmObj.disp_label.checked))
		print_opt		=	"DL";
	else if((frmObj.bal_sheet != undefined && frmObj.bal_sheet.checked) && (frmObj.disp_label != undefined && frmObj.disp_label.checked) )
		print_opt		=	"BL";
	else if((frmObj.disp_sheet != undefined && frmObj.disp_sheet.checked))
		print_opt		=	"D";
	else if(frmObj.bal_sheet != undefined && frmObj.bal_sheet.checked)
		print_opt		=	"B";
	else if(frmObj.disp_label != undefined && frmObj.disp_label.checked)
		print_opt		=	"L";
	 if(frmObj.med_plan != undefined && frmObj.med_plan.checked)//&& (frmObj.med_plan != undefined && frmObj.med_plan.checked) for  ML-BRU-CRF-072[Inc:29938] 
		print_opt_MP		=	"M";
	if(frmObj.printDialogLang!= undefined)
		selLanguage			= frmObj.printDialogLang.value;
	if(selLanguage== undefined || selLanguage=='') //if block Added for [IN:044203]
		selLanguage = 'en';
	// These condtions are added for the extra printing lables and sheets for the CRF 293 (IN014746)

	if(frmObj.certiReimbur != undefined && frmObj.certiReimbur.checked)
		printOthers		= printOthers +"CR~";

	if(frmObj.MFGLabel != undefined && frmObj.MFGLabel.checked)
		printOthers		= printOthers + "MFGL~";

	if(frmObj.medicalSupplyLabel != undefined && frmObj.medicalSupplyLabel.checked)
		printOthers		= printOthers +  "MSL~";

	if(frmObj.medicationList != undefined && frmObj.medicationList.checked)
		printOthers		= printOthers +  "ML~";

	if(frmObj.workSheet != undefined && frmObj.workSheet.checked)
		printOthers		= printOthers +  "WS~";

	if(frmObj.homeMedicationSheet != undefined && frmObj.homeMedicationSheet.checked)
		printOthers		= printOthers +  "HMS~";

	if(frmObj.refillMediationSheet != undefined && frmObj.refillMediationSheet.checked)
		printOthers		= printOthers +  "RFMS~";
	//Added for RUT-CRF-0061 - Start
	//added for ML-MMOH-CRF-1089 START
	if(frmObj.cover_bag != undefined && frmObj.cover_bag.checked)
		printOthers		= printOthers +  "COB~";

	if(frmObj.lipid_label != undefined && frmObj.lipid_label.checked)
		printOthers		= printOthers +  "LIP~";
	//added for ML-MMOH-CRF-1089 END
	//added for ML-MMOH-CRF-2042 START
	if(frmObj.lipid_label != undefined && frmObj.TPNDispenseSheet.checked)
		printOthers		= printOthers +  "TPNDS~";
	//added for ML-MMOH-CRF-2042 END							   
	if(frmObj.medn_include!=undefined && frmObj.medn_include.checked){
		printInclude="I"
	}
	if(frmObj.medn_separate!=undefined && frmObj.medn_separate.checked){
		printSeparate="S"
	}
	if(frmObj.medn_only!=undefined && frmObj.medn_only.checked){
		printOnly="O"
	}
	if(frmObj.medn_taper!=undefined && frmObj.medn_taper.checked){
		printTaper="Y"
	}
	if(frmObj.homeMedOrientation!=undefined ){
		printType= frmObj.homeMedOrientation.value;
	}
	//Added for RUT-CRF-0061 - End
	if(frmObj.refill_label!=undefined && frmObj.refill_label.checked){//Added if condition for MOHE-CRF-0069
		printRefill= "Y";
	}
	/*if(print_opt == '' && printOthers == ''){
		if(type=="OK"){
			alert(getMessage("ATLT_ONE_SLCTD","PH"));
			return false;
		}
	}*/
		var enable_tab= frmObj.enable_tab.value;
		var print_extr_pres    = "";
		if(type=="OK"){
			if(enable_tab=='Y'){
				flag=current_facility;
				if(frmObj.curr_facility[0].checked==true)
					curr_facility=frmObj.curr_facility[0].value;
				else
					curr_facility=frmObj.curr_facility[1].value;
				if(curr_facility=='C'){
					next_collection_date=	frmObj.next_collection_date1.value;//next collection_date
					next_collection_date_ref=frmObj.next_collection_date1;
				}
				else if(curr_facility=='E'){
					next_collection_date=	frmObj.next_collectiondate.value ;//next collection_date
					next_collection_date_ref=frmObj.next_collectiondate;
			 
					var referral_facility	="";
	
					if(frmObj.referral_location.value!=""){
						referral_facility	=	frmObj.referral_location.value;//other_facility_id
					}
					else{
						referral_facility	=	frmObj.referral_facility.value ;//facility_name
					}
				}
				var referral_remarks	=	frmObj.referral_remarks.value;//remarks
				var practioner_id		=	frmObj.practioner_id.value;//reffered by
	 
				if(frmObj.print_extr_pres.checked==true){
					print_extr_pres    ="Y";
				}
				else{
					print_extr_pres    ="N";
				}
				if(curr_facility=='C'){
					fields[0]   = frmObj.next_collection_date1 ;	
					names[0]    = getLabel("ePH.NextCollectionDate.label","Common")+' ';				
					fields[1]   = frmObj.disp_locations ;	
					names[1]    = getLabel("ePH.NextCollectionFrom.label","Common")+' '; 
			   }
			   else if(curr_facility=='E'){
				   var cnt	=	0;

                if(frmObj.referral_location.value!="" && frmObj.referral_facility.value!=""){ 
					fields[cnt]   = frmObj.referral_location ;	
					names[cnt]    = getLabel("Common.FacilityName.label","Common")+' ';
					cnt++;
				}
				fields[cnt]   = frmObj.next_collectiondate ;	
				names[cnt]    = getLabel("ePH.NextCollectionDate.label","PH")+' ';	
				cnt++;
				fields[cnt]   = frmObj.referral_remarks ;	
				names[cnt]    = getLabel("Common.remarks.label","Common")+' ';
				cnt++;
				fields[cnt]   = frmObj.practioner_name ;	
				names[cnt]    = getLabel("ePH.ReferedBy.label","PH")+' ';
			}

			if(curr_stage == 'D' || curr_stage =='AS'){
				validateDate =  checkFlds( fields, names);
			}
			if(validateDate){	

				var xmlStr ="<root><SEARCH ";
				xmlStr+= "bean_id  =\"" + bean_id + "\" " ;
				xmlStr+= "bean_name =\"" + bean_name + "\" " ;
				xmlStr+= "bean_id_1  =\"" + bean_id_1 + "\" " ;
				xmlStr+= "bean_name_1 =\"" + bean_name_1 + "\" " ;
				xmlStr+= "login_user  =\"" + login_user + "\" " ;
				xmlStr+= "facility_id =\"" + facility_id + "\" " ;
				xmlStr+= "patient_id =\"" + patient_id + "\" " ;
				xmlStr+= "disp_no=\"" + disp_no + "\" " ;
				xmlStr+= "locn_code=\"" + locn_code + "\" " ;
				xmlStr+= "patient_class=\"" + patient_class + "\" " ;
				xmlStr+= "print_opt=\"" + print_opt + "\" " ;
				xmlStr+= "print_extr_pres=\"" + print_extr_pres + "\" " ;		
				xmlStr+= "select_loc_lang=\"" + selLanguage + "\" " ;
				xmlStr+= "bms_sel_lang=\"" + bmsLang + "\" " ;			//newly added for CRF-074 by manickam
				xmlStr+= "order_type=\"" + frmObj.order_type.value + "\" " ;
				xmlStr+= "curr_stage=\"" + curr_stage + "\" " ; 
				xmlStr+= "printOthers=\"" + printOthers + "\" " ;
				xmlStr+= "print_opt_MP=\"" + print_opt_MP + "\" " ;
				xmlStr+= "printInclude=\"" + printInclude + "\" " ;//Added for RUT-CRF-0061 - Start
				xmlStr+= "printSeparate=\"" + printSeparate + "\" " ;
				xmlStr+= "printOnly=\"" + printOnly + "\" " ;
				xmlStr+= "printTaper=\"" + printTaper + "\" " ;
				xmlStr+= "print_Type=\"" + printType + "\" " ;//Added for RUT-CRF-0061 - End
				xmlStr+= "printRefill=\"" + printRefill + "\" " ;//Added for MOHE-CRF-0069
				xmlStr +=" /></root>";
				var temp_jsp="DispMedicationValidation.jsp?func_mode=print_dispense";
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest() ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST",temp_jsp,true);
				xmlHttp.send(xmlDoc);
				//responseText=xmlHttp.responseText ;
				 parent.window.close();
				 parent.window.returnValue='OK';
				/*parent.parent.document.getElementById('dialog-body').contentWindow.returnValue = 'OK'; 
				parent.parent.document.getElementById('dialog_tag').close(); */
			}
		}
		else{
			var xmlStr ="<root><SEARCH ";
			xmlStr+= "bean_id  =\"" + bean_id + "\" " ;
			xmlStr+= "bean_name =\"" + bean_name + "\" " ;
			xmlStr+= "bean_id_1  =\"" + bean_id_1 + "\" " ;
			xmlStr+= "bean_name_1 =\"" + bean_name_1 + "\" " ;
			xmlStr+= "login_user  =\"" + login_user + "\" " ;
			xmlStr+= "facility_id =\"" + facility_id + "\" " ;
			xmlStr+= "patient_id =\"" + patient_id + "\" " ;
			xmlStr+= "disp_no=\"" + disp_no + "\" " ;
			xmlStr+= "locn_code=\"" + locn_code + "\" " ;
			xmlStr+= "patient_class=\"" + patient_class + "\" " ;
			xmlStr+= "print_extr_pres=\"" + print_extr_pres + "\" " ;
			xmlStr+= "print_opt=\"" + print_opt + "\" " ;
			xmlStr+= "select_loc_lang=\"" + selLanguage + "\" " ;   
			xmlStr+= "bms_sel_lang=\"" + bmsLang + "\" " ;			//newly added for CRF-074 by manickam
			xmlStr+= "order_type=\"" + frmObj.order_type.value + "\" " ;
			xmlStr+= "curr_stage=\"" + curr_stage + "\" " ; 
			xmlStr+= "printOthers=\"" + printOthers + "\" " ;
			xmlStr+= "print_opt_MP=\"" + print_opt_MP + "\" " ;
			xmlStr+= "printInclude=\"" + printInclude + "\" " ;//Added for RUT-CRF-0061 - Start
			xmlStr+= "printSeparate=\"" + printSeparate + "\" " ;
			xmlStr+= "printOnly=\"" + printOnly + "\" " ;
			xmlStr+= "printTaper=\"" + printTaper + "\" " ;
			xmlStr+= "print_Type=\"" + printType + "\" " ;//Added for RUT-CRF-0061 - End
			xmlStr+= "printRefill=\"" + printRefill + "\" " ;//Added for MOHE-CRF-0069
			xmlStr +=" /></root>";
			var temp_jsp="DispMedicationValidation.jsp?func_mode=print_dispense";
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST",temp_jsp,true);
			xmlHttp.send(xmlDoc);
			//responseText=xmlHttp.responseText ;
			window.returnValue='OK';
			window.close();
			
		}
	}
	else{
		if(enable_tab=='Y'){
			flag=current_facility;
			if(frmObj.curr_facility[0].checked==true)
				curr_facility=frmObj.curr_facility[0].value;
			else
				curr_facility=frmObj.curr_facility[1].value;
			if(curr_facility=='C'){
				next_collection_date=	frmObj.next_collection_date1.value;//next collection_date
				next_collection_date_ref=frmObj.next_collection_date1;
			 }
			 else if(curr_facility=='E'){
				 next_collection_date=	frmObj.next_collectiondate.value ;//next collection_date
				 next_collection_date_ref=frmObj.next_collectiondate;
			 
				var referral_facility	="";
	
				if(frmObj.referral_location.value!=""){
					referral_facility	=	frmObj.referral_location.value;//other_facility_id
				}
				else{
					referral_facility	=	frmObj.referral_facility.value ;//facility_name
				}
			}
			var referral_remarks	=	frmObj.referral_remarks.value;//remarks
			var practioner_id		=	frmObj.practioner_id.value;//reffered by
	 
			if(frmObj.print_extr_pres.checked==true){
				print_extr_pres    ="Y";
			}
			else{
				print_extr_pres    ="N";
			}
	 
			if(curr_facility=='C'){
				fields[0]   = frmObj.next_collection_date1 ;	
				names[0]    = getLabel("ePH.NextCollectionDate.label","PH")+' ';					
				fields[1]   = frmObj.disp_locations ;	
				names[1]    = getLabel("ePH.NextCollectionFrom.label","PH")+' '; 
			}
			else if(curr_facility=='E'){
			   var cnt	=	0;

                if(frmObj.referral_location.value!="" && frmObj.referral_facility.value!=""){ 
					fields[cnt]   = frmObj.referral_location ;	
					names[cnt]    = getLabel("Common.FacilityName.label","Common")+' ';
					cnt++;
				}

				fields[cnt]   = frmObj.next_collectiondate ;	
				names[cnt]    = getLabel("ePH.NextCollectionDate.label","PH")+' ';	
				cnt++;

				fields[cnt]   = frmObj.referral_remarks ;	
				names[cnt]    = getLabel("Common.remarks.label","Common")+' ';
				cnt++;

				fields[cnt]   = frmObj.practioner_name ;	
				names[cnt]    = getLabel("ePH.ReferedBy.label","PH")+' ';
			}
			if(checkFlds( fields, names)){
    			/*parent.window.close();
				parent.window.returnValue='OK';*/
				parent.parent.document.getElementById('dialog-body').contentWindow.returnValue = 'OK'; 
				parent.parent.document.getElementById('dialog_tag').close(); 
			}
		}
		else{
			/*parent.window.close();
			parent.window.returnValue='OK';*/
			parent.parent.document.getElementById('dialog-body').contentWindow.returnValue = 'OK'; 
			parent.parent.document.getElementById('dialog_tag').close(); 
		}
	}
}

function printOnlineFilling(login_user,facility_id,patient_id,locn_code,patient_class,disp_no,order_type) {

	bean_id				=	"DispMedicationAllStages" ;
	bean_name			=	"ePH.DispMedicationAllStages";
	print_opt		=	"D";
	curr_stage		=	"F";
	var xmlStr ="<root><SEARCH ";
	xmlStr+= "bean_id  =\"" + bean_id + "\" " ;
	xmlStr+= "bean_name =\"" + bean_name + "\" " ;
	xmlStr+= "login_user  =\"" + login_user + "\" " ;
	xmlStr+= "facility_id =\"" + facility_id + "\" " ;
	xmlStr+= "patient_id =\"" + patient_id + "\" " ;
	xmlStr+= "disp_no=\"" + disp_no + "\" " ;
	xmlStr+= "locn_code=\"" + locn_code + "\" " ;
	xmlStr+= "patient_class=\"" + patient_class + "\" " ;
	xmlStr+= "print_opt=\"" + print_opt + "\" " ;
	xmlStr+= "curr_stage=\"" + curr_stage + "\" " ;
	xmlStr+= "order_type=\"" +order_type + "\" ";
	xmlStr +=" /></root>";
	var temp_jsp="DispMedicationValidation.jsp?func_mode=print_dispense";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,true);
	xmlHttp.send(xmlDoc);
	//responseText=xmlHttp.responseText ;
	//parent.window.close(); 
	parent.parent.document.getElementById('dialog_tag').close(); 
}

//	IV Admixture Worksheet related coding starts from here

async function showLoginWindowForPrepareAdmixture(disp_locn_details,function_id, homepage){
	
	var dialogHeight= "12" ;
	var dialogWidth	= "33" ;
	//var dialogHeight= "18" ;
	//var dialogWidth	= "32" ;
	var dialogTop = "195" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal =await window.showModalDialog("../../ePH/jsp/PrepareAdmixtureLogin.jsp?disp_locn_details="+disp_locn_details+"&function_id="+function_id+"&homepage="+homepage+"&store_code="+store_code,arguments,features);

	if(retVal=="GOHOME" || retVal == undefined){
//		history.go(-1);
		if(homepage!='Y')
			window.location.href = '../../eCommon/jsp/dmenu.jsp';
		else{
			window.close();
			parent.CommonToolbar.ShowMenu.click();
			parent.CommonToolbar.unLoadTitleName();
		}
	}
	else{
		window.close();
		document.location.href ="../../ePH/jsp/DispMedicationFrameset.jsp?function_id="+function_id;
	}
}

async function showWorksheetForIVAdmixture(patient_id,order_id,disp_stage,type){

	var dialogHeight	= "33" ;
	var dialogWidth		= "64";
	var dialogTop		= "200" ;
	var dialogLeft		= "200" ;
	var center			= "0" ;
	var status			="no";
	var features	= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";
	if(disp_stage=="A" ){
		if(parent.f_stage==undefined){
			var formObj = parent.f_disp_medication_allocation.DispMedicationAllStages;
		}
		else{
            var formObj = parent.f_stage.DispMedicationAllStages;
		}
	}
	else if(type=="IV" || type=="CY" || type=="CO" ){	// IV - IV Medication , CY - Cyto Medication, CO - Compounding
	    if(parent.f_stage==undefined){
			if(parent.f_disp_medication_allocation==null)
				var formObj = parent.f_disp_medication_filling.DispMedicationAllStages;
			else
				var formObj = parent.f_disp_medication_allocation.DispMedicationAllStages;
		}
		else{
             var formObj = parent.f_stage.DispMedicationAllStages;
		}
	}
	else{
        if(parent.f_stage==undefined){
			var formObj = parent.f_disp_medication_filling.DispMedicationAllStages;
		}
		else{
            var formObj = parent.f_stage.DispMedicationAllStages;
		}
	}
	var tot_num_of_drugs=formObj.tot_rec.value;
	//window.open("../../ePH/jsp/DispMedicationWorksheetForIVFrames.jsp?patient_id="+patient_id+"&order_id="+order_id+"&disp_stage="+disp_stage+"&type="+type+"&tot_num_of_drugs="+tot_num_of_drugs,arguments,features);

	retVal=await window.showModalDialog("../../ePH/jsp/DispMedicationWorksheetForIVFrames.jsp?patient_id="+patient_id+"&order_id="+order_id+"&disp_stage="+disp_stage+"&type="+type+"&tot_num_of_drugs="+tot_num_of_drugs,arguments,features);
	if(retVal=="RECORDWS"){
		if(disp_stage=="A" ){	// A- Allocation
		   if(parent.f_stage==undefined){
		   		parent.f_disp_medication_allocation.location.href="../../ePH/jsp/DispMedicationAllocation.jsp?patient_id="+patient_id+"&encounter_id=DUMMYENCOUNTERID&order_id="+order_id;
		   }
		   else{
                parent.f_stage.location.href="../../ePH/jsp/DispMedicationAllocation.jsp?patient_id="+patient_id+"&encounter_id=DUMMYENCOUNTERID&order_id="+order_id;
		   }
		}
		else if(disp_stage=="F"){	// F-Filling
			 if(parent.f_stage==undefined){
			 	parent.f_disp_medication_filling.location.href="../../ePH/jsp/DispMedicationFilling.jsp?patient_id="+patient_id+"&encounter_id=DUMMYENCOUNTERID&order_id="+order_id;
			 }
			 else{
                parent.f_stage.location.href="../../ePH/jsp/DispMedicationAllocation.jsp?patient_id="+patient_id+"&encounter_id=DUMMYENCOUNTERID&order_id="+order_id;
			 }				
		}
	}
	return retVal;
}

function previewSelectedBatches(){
	var formObjOrderDetails = parent.ws_order_details.frmDispMedicationWSOrderDetails;
	var tot_num_of_drugs = formObjOrderDetails.tot_num_of_drugs.value;
	parent.parent.ws_show_batches.location.href ="../../ePH/jsp/DispMedicationWSAllocateBatches.jsp?retval=&identity=preview&tot_num_of_drugs="+tot_num_of_drugs;
	parent.parent.ws_batches_button.location.href = "../../ePH/jsp/DispMedicationWSBatchesButton.jsp?identity=preview&tot_num_of_drugs="+tot_num_of_drugs;
	parent.parent.ws_main.rows="44%,50%,6%,0%,0%";
}

function showDisplaySection(){
	parent.parent.ws_main.rows="44%,0%,0%,50%,6%";
}

function validateWSAllocatedQty(avail_qty,alloc_qty,ordered_qty,conv_factor,no_of_decimals_allowed){
	if(parseFloat(alloc_qty.value)>parseFloat(avail_qty)){
		alert(getMessage("PH_ALLOC_QTY_LESS_OR_EQUAL_AVAIL_QTY","PH"));
		alloc_qty.focus();
	}
	if(no_of_decimals_allowed > 0){	
		if(parseFloat(ordered_qty)<parseFloat(alloc_qty.value)){
			alert(getMessage("PH_ALLOC_QTY_LESS_OR_EQUAL_ORDERED_QTY","PH"));
			alloc_qty.focus();
		}
	}
	else{
		 var ordered_qty_equl	=  Math.ceil(parseInt(ordered_qty)/parseInt(conv_factor));
		 var alloc_qty_equl	    =  Math.ceil(parseInt(alloc_qty.value)/parseInt(conv_factor));
		if (conv_factor == 'NaN' || conv_factor == 0.0){
			alert(getMessage("PH_ITEM_UOM_DEF_NOT_FOUND","PH"));
			alloc_qty.value = '';
			return false;
		}
        if((parseFloat(alloc_qty.value)%parseFloat(conv_factor))!=0){
			alert(getMessage("PH_ISSUE_UOM_MUL","PH")+conv_factor);	
			alloc_qty.focus();
			return false;
		}
		if(parseInt(ordered_qty_equl)<parseInt(alloc_qty_equl)){
			alert(getMessage("PH_ALLOC_QTY_LESS_OR_EQUAL_ORDERED_QTY","PH"));
			alloc_qty.focus();
		}
	}
}

function enableDisableButton(stock_availability_check){
	if(stock_availability_check!="Y"){
		
	}
}

function validateShowBatchesAllocQty(available_qty,obj,conv_factor,no_decimal_allowed){
	if(no_decimal_allowed==0){
		if((parseFloat(obj.value)%parseFloat(conv_factor))!=0 && obj.value>0){
			alert(getMessage("PH_ISSUE_UOM_MUL","PH")+conv_factor);
			obj.focus();
			return false;
		}
		if(parseFloat(available_qty)<parseFloat(obj.value)){
			alert(getMessage("PH_ALLOC_QTY_LESS_AVAIL_QTY","PH"));
			obj.focus();
			return false;
		}
	}
	else{
		if(parseFloat(available_qty)<parseFloat(obj.value)){
			alert(getMessage("PH_ALLOC_QTY_LESS_AVAIL_QTY","PH"));
			obj.focus();
			return false;
		}
	}
}

function defaultStageForPrepareAdmixture(obj){
	if(obj.value=="I"){		// I - Inpatient
		document.frmDispMedicationLogin.lbl_alloc.style.display="none";
		document.frmDispMedicationLogin.lbl_fill.style="display";
	}
	else if(obj.value=="O"){	// O - Outpatient
		document.frmDispMedicationLogin.lbl_alloc.style="display";
		document.frmDispMedicationLogin.lbl_fill.style.display="none";
	}
}

function showAdmixtureType(obj){
	var objValue="All Admixtures";
	if(obj.value=="I"){
		objValue = "IV Admixture";
	}else if(obj.value=="C"){
		objValue = "Cyto Admixture";
	}else if(obj.value=="T"){
		objValue = "TPN Admixture";
	}
	document.getElementById('lbl_admixture_type').innerHTML="<B>"+objValue+"</B>";
}

function saveMFGLabelDetails(mode,ord_type){
	var formObj = document.fromDispMedicationWSLabel;
	var language_id =document.fromDispMedicationWSLabel.language_id.value;

	var updateMFGDetails = document.fromDispMedicationWSLabel.UpdateMFGDetails.value;
	var fields  = new Array() ;
	var names   = new Array() ;

	fields[0]  = formObj.mfg_unit;
	names[0]   = getLabel("Common.ProductName.label","Common");

	fields[1]  = formObj.batch_id ;
	names[1]   = getLabel("Common.BatchID.label","Common");

	fields[2]  = formObj.expiry_date;
	names[2]   = getLabel("Common.expiryDate.label","Common");

	fields[3]  = formObj.qty_volume;
	names[3]   = getLabel("ePH.PreparedQty.label","PH");

	fields[4]  = formObj.qty_uom ;
	names[4]   = getLabel("ePH.QtyUOM.label","PH");

	var bean_id= formObj.bean_id.value;
	var bean_name= formObj.bean_name.value;

	if(checkFlds( fields, names)){
		if(mode == "D" || updateMFGDetails == 'Y'){
			var xmlStr ="<root><SEARCH ";
			xmlStr+= "bean_id  =\"" + bean_id + "\" " ;
			xmlStr+= "bean_name =\"" + bean_name + "\" " ;
			xmlStr+= "facility_id =\"" + formObj.facility_id.value + "\" " ;
			xmlStr+= "disp_locn =\"" + formObj.disp_locn.value + "\" " ;
			xmlStr+= "worksheet_id =\"" + formObj.worksheet_id.value + "\" " ;
			xmlStr+= "mfg_unit =\"" + encodeURIComponent(formObj.mfg_unit.value,'UTF-8') + "\" " ;
			xmlStr+= "batch_id =\"" + formObj.batch_id.value + "\" " ;
			xmlStr+= "expiry_date =\"" +convertDate(formObj.expiry_date.value,"DMYHM",language_id,"en")  + "\" " ;
			xmlStr+= "qty_volume =\"" + formObj.qty_volume.value + "\" " ;
			xmlStr+= "qty_uom =\"" + formObj.qty_uom.value + "\" " ;
			xmlStr+= "Admin_Inst =\"" + formObj.Admin_Inst.value + "\" " ;
			if(formObj.infusion_line!=null&&formObj.infusion_line!=undefined){
				xmlStr+= "infusion_line =\"" + formObj.infusion_line.value + "\" " ;
			}
			xmlStr+= "finalise_yn =\"" + formObj.finalise_yn.value + "\" " ;

			xmlStr +=" /></root>";
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST", "DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&ord_type="+ord_type+"&identity=modify_mfg_label_details", false ) ;
			xmlHttp.send(xmlDoc);
/*			window.returnValue="SAVED";
			window.close();*/
			parent.document.getElementById('dialog-body').contentWindow.returnValue = "SAVED"; 
			parent.document.getElementById('dialog_tag').close(); 
		}
		else{
			if(formObj.finalise_yn != undefined && formObj.finalise_yn.value == "Y"){
				var xmlStr ="<root><SEARCH ";
				xmlStr+= " bean_id =\"DispMedicationAllStages\" " ;
				xmlStr+= " bean_name=\"ePH.DispMedicationAllStages\" " ;
				xmlStr +=" /></root>";

				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest() ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open( "POST", "DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=checkMedicalStock", false ) ;
				xmlHttp.send(xmlDoc);
				var available = eval(xmlHttp.responseText);
				if(available == 'false'){
					alert(getMessage("PH_INSUF_QTY_MEDICALITEM","PH"));
					window.close();
					return;
				}
			}
			var xmlStr ="<root><SEARCH ";
			xmlStr+= "bean_id  =\"" + bean_id + "\" " ;
			xmlStr+= "bean_name =\"" + bean_name + "\" " ;
			xmlStr+= "mfg_unit =\"" + encodeURIComponent(formObj.mfg_unit.value,'UTF-8') + "\" " ;
			xmlStr+= "batch_id =\"" + formObj.batch_id.value + "\" " ;
			xmlStr+= "expiry_date =\"" + convertDate(formObj.expiry_date.value,"DMYHM",language_id,"en") + "\" " ;
			xmlStr+= "qty_volume =\"" + formObj.qty_volume.value + "\" " ;
			xmlStr+= "qty_uom =\"" + formObj.qty_uom.value + "\" " ;
			xmlStr+= "Admin_Inst =\"" + formObj.Admin_Inst.value + "\" " ;
			if(formObj.infusion_line!=null&&formObj.infusion_line!=undefined){
				xmlStr+= "infusion_line =\"" + formObj.infusion_line.value + "\" " ;
			}
			xmlStr+= "finalise_yn =\"" + formObj.finalise_yn.value + "\" " ;
			xmlStr +=" /></root>";
			//var xmlDoc  = new ActiveXObject( "Microsoft.XMLDom" ) ;
			var xmlHttp = new XMLHttpRequest() ;
			var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST", "DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=save_mfg_label_details", false ) ;
			xmlHttp.send(xmlDoc);
			/*window.returnValue="SAVED";
			window.close();*/
			parent.document.getElementById('dialog-body').contentWindow.returnValue = "SAVED"; 
			parent.document.getElementById('dialog_tag').close(); 
		}
	}
}

function validateExpiryDate(obj,today,tpn_param_expiary_date,ord_type){
	/*if(obj.value != ""){
		if(!doDateTimeChk(obj) ){
			alert(getMessage("INVALID_DATE_TIME","PH"));
			obj.value="";
			obj.focus();
		}
    }*/  // Commented for RollForward from SRR - SRR20056-SCF-9422
	if(obj.value != "" && today.value != ""){
		if(ValidateDateTime(obj,today)){
			alert(getMessage("PH_EXPIRY_LESS_THAN_SYS_DATE","PH"));
			obj.value="";
			obj.focus();
		}
		if(ord_type=='TA'){
			isValidFromToField(obj,tpn_param_expiary_date,getLabel("ePH.ExpiryDate/Time.label","PH"));

		}
	}
}

function isValidFromToField(fromObj, toObj, stLegend) {
	var bReturn = true;
	var stFromValue = fromObj.value;
	var stToValue = toObj;
	if ((!trimCheck(stFromValue)) || (!trimCheck(stToValue))) {
		return bReturn;
	}
	
	var arFromDate = stFromValue.split("/");
	var arToDate = stToValue.split("/");
	if (Date.parse("" + arFromDate[1] + "/" + arFromDate[0] + "/" + arFromDate[2] + "/") > Date.parse("" + arToDate[1] + "/" + arToDate[0] + "/" + arToDate[2] + "/")) {
		bReturn = false;
	}

	if ((!bReturn) ) {
		
		var stMessage = getMessage("PH_EXPIARY_DATE_GRT", "PH")+ toObj;
		
		alert(stMessage);
        fromObj.value='';
		fromObj.focus();
	}
	return bReturn;
}

function disableEnableWSItem(obj){

	if(obj.name=="fluid_item_code" && obj.value != ""){
		document.getElementById('item_code').value="";
		document.getElementById('item_code').disabled=true;
	}else if(obj.name=="fluid_item_code" && obj.value == ""){
		document.getElementById('item_code').value="";
		document.getElementById('item_code').disabled=false;
	}else if(obj.name=="item_code" && obj.value != ""){
		document.getElementById('fluid_item_code').value="";
		document.getElementById('fluid_item_code').disabled=true;
	}else if(obj.name=="item_code" && obj.value == ""){
		document.getElementById('fluid_item_code').value="";
		document.getElementById('fluid_item_code').disabled=false;
	}
}

/*function callBatchSearchWindow(item_code,store_code,includeZeroStockBatches,includeExpiredBatches,includeSuspendedBatches,searchFunction,multipleSelect){
	var dialogHeight	= "30" ;
	var dialogWidth		= "50";
	var dialogTop		= "100" ;
	var dialogLeft		= "200" ;
	var center			= "0" ;
	var status			="no";
	var features	= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";
	retVal=window.showModalDialog("../../eST/jsp/BatchSearchFrame.jsp?item_code="+item_code+"&store_code="+store_code+"&includeZeroStockBatches="+includeZeroStockBatches+"&includeExpiredBatches="+includeExpiredBatches+"&includeSuspendedBatches="+includeSuspendedBatches+"&searchFunction="+searchFunction+"&multipleSelect="+multipleSelect,arguments,features);
	return retVal;
}*/

// This method is to know the form of drug
function getDrugForm(drug_code){
	var formObj = document.frmDispMedicationWSOrderDetails;
	var bean_id		= "DispMedicationBean";
	var bean_name	= "ePH.DispMedicationBean";
	//var xmlDoc  = new ActiveXObject( "Microsoft.XMLDom" ) ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr += " drug_code=\"" + drug_code + "\"";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr +=" /></root>";
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=getDrugForm",false);
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);
}

var drug_form="";
function assignDrugForm(obj){
	drug_form = obj;
}

function callCalSection(drug_code,drug_name,qty,row_no,drug_type,order_line_num,qty_uom){

	var formObj = parent.ws_order_details.frmDispMedicationWSOrderDetails;
	formObj.selected_drug.value=row_no;
	var len=formObj.wsorderdetailstable.rows.length-1;
	for (var i=1;i<len ;i++ ){
		if(eval("formObj.ingredient_name"+i)!= null){
			
			eval("formObj.ingredient_name"+i).style.background="";
		}
	}
	for (var i=1;i<len ;i++ ){
		if(eval("formObj.fluid_name"+i)!= null){
			eval("formObj.fluid_name"+i).style.background="";
		}
	}
	/*for(var i=1;i<=formObj.tot_num_of_drugs.value;i++){
		if(i != row_no){
			if(eval("formObj.fluid_name"+i)!=null){
					("1");
				eval("formObj.fluid_name"+i).style.display="none";
				alert("2");
				eval("formObj.lbl_fluid_name"+i).style="display";
				alert("3");
			}else if(eval("formObj.ingredient_name"+i)!=null){
				alert("4");
				eval("formObj.ingredient_name"+i).style="display";
				alert("5");
				eval("formObj.lbl_ingredient_name"+i).style="display";
				alert("6");
			}else if(eval("formObj.alt_ingredient_name"+i)!=null){
				alert("7");
				eval("formObj.alt_ingredient_name"+i).style="display";
				alert("8");
				eval("formObj.lbl_alt_ingredient_name"+i).style="display";
			}
		}
	}*/
	if(drug_type=="F"){	// F - Fluid
		eval("formObj.fluid_name"+row_no).style.background="#FDE6D0";
	}
	else if(drug_type=="I"){ // I - Ingredient
		eval("formObj.ingredient_name"+row_no).style.background="#FDE6D0";
	}

	var sIngredientsType = "";

	if(formObj.orderType.value == "CO"){
		sIngredientsType = formObj.IngredientsType.value;
	}

	var patient_id  = formObj.patient_id.value;
	var order_id    = formObj.order_id.value;
	getDrugForm(drug_code);
	parent.parent.ws_cal_sec.location.href="../../ePH/jsp/DispMedicationWSCalSec.jsp?drug_code="+drug_code+"&drug_name="+drug_name+"&qty="+qty+"&drug_form="+drug_form+"&patient_id="+patient_id+"&order_id="+order_id+"&order_line_no="+order_line_num+"&qty_uom="+qty_uom+"&tot_num_of_drugs="+formObj.tot_num_of_drugs.value+"&IngType="+sIngredientsType;  // escape changed to decodeURIComponent(drug_name,"UTF-8") for reopend [Inc:41227] 

	// This page has been reloaded to get the drug details if it is already added...
	//parent.parent.ws_display_sec.location.href = "../../ePH/jsp/DispMedicationWSDisplaySec.jsp?tot_num_of_drugs="+formObj.tot_num_of_drugs.value;
}

function validateDrugPreQty(obj,existing_qty,qty_required, iNoOfDecimals){

	if(iNoOfDecimals == undefined)
		iNoOfDecimals = 0;
	var formObj			= document.frmDispMedicationWSCalSec;
	var tot_disp_qty	= formObj.tot_disp_qty.value;
	var qty = obj.value;
	if(qty=="" || qty==0){
		obj.value="0";
		alert(getMessage("PH_PREP_QTY_CANNOT_ZERO_NULL","PH"));
		obj.focus();
		return false;
	}
 
   var drug_form=formObj.drug_form.value;

    /*if(drug_form!='P'){
      qty_required=qty_required-tot_disp_qty;
	} */

	if(parseFloat(qty)>qty_required){
		alert(getMessage("PH_PREP_QTY_NOT_GREATER_THAN_QTY_REQD","PH"));
		obj.focus();
	}else{
		if(formObj.fluid_qty_preparation != null)
			formObj.fluid_qty_preparation.value = formObj.rf_qty.value * formObj.drug_qty_preparation.value;
		 var drugQtyDrawn = (formObj.drug_qty_preparation.value - formObj.drug_qty_spillage.value).toFixed(iNoOfDecimals);
		if(drugQtyDrawn < 0)
		{
			alert(getMessage("PH_SPILL_QTY_NOT_EQUAL_OR_GREATER_THAN_PREP_QTY","PH"));
			formObj.drug_qty_spillage.focus();
		}
		else
			 formObj.drug_qty_drawn.value = drugQtyDrawn;


	}
}

function alertForOrderedQtyMismatch(){
	var formObj = document.frmDispMedicationWSCalSec;
	alert(getMessage("QTY_DRAWN_GREATER_THAN_ORD_QTY"));
	formObj.drug_qty_preparation.focus();
}

function validateDrugSpillage(obj,existing_qty, newQty, iNoOfDecimals){

	var formObjCalSec = parent.ws_cal_sec.frmDispMedicationWSCalSec;
	var qty = obj.value;
	if(iNoOfDecimals == undefined)
		iNoOfDecimals = 0;
	if(parseFloat(qty)>=existing_qty){
		alert(getMessage("PH_SPILL_QTY_NOT_EQUAL_OR_GREATER_THAN_PREP_QTY","PH"));
		obj.focus();
	}else{

		var drugQtyDrawn = (formObjCalSec.drug_qty_preparation.value - formObjCalSec.drug_qty_spillage.value).toFixed(iNoOfDecimals);
		if(drugQtyDrawn < 0)
		{
			alert(getMessage("PH_SPILL_QTY_NOT_EQUAL_OR_GREATER_THAN_PREP_QTY","PH"));
			formObjCalSec.drug_qty_spillage.focus();
		}
		 else
			 formObjCalSec.drug_qty_drawn.value = drugQtyDrawn;
		if(formObjCalSec.fluid_qty_spillage != null){
			formObjCalSec.fluid_qty_drawn.value = formObjCalSec.fluid_qty_preparation.value - formObjCalSec.fluid_qty_spillage.value;
		}

		var bean_id  = formObjCalSec.bean_id.value;
		var bean_name= formObjCalSec.bean_name.value;
		//var xmlDoc  = new ActiveXObject( "Microsoft.XMLDom" ) ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr += " ordered_qty=\"" + formObjCalSec.drug_qty_drawn.value + "\"";
		xmlStr += " order_line_no=\"" + formObjCalSec.order_line_no.value +"\"";
		xmlStr += " bean_id=\""+bean_id+"\"";
		xmlStr += " bean_name=\""+bean_name+"\"";
		xmlStr +=" /></root>";
		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=drawn_from_stock",false);
		xmlHttp.send( xmlDoc ) ;
	}
}

async function callWSBatchSearch(item_code,store_code,trade_code,allowchangetradenameyn,allowmultitradeyn,end_date,allow_short_expiry_drugs_yn){
	var formObjCalSec = parent.ws_cal_sec.frmDispMedicationWSCalSec;
	getItemCount(item_code);
	drug_name  = formObjCalSec.drug_name.value;
	drug_code  = formObjCalSec.drug_code.value;
	order_id=formObjCalSec.order_id.value;//added ofr MMs-KH-CRF-0038
	patient_id =formObjCalSec.patient_id.value;//added ofr MMs-KH-CRF-0038
	order_line_no = formObjCalSec.order_line_no.value;
	tot_num_of_drugs = formObjCalSec.tot_num_of_drugs.value;
	var	qty_uom		 = formObjCalSec.qty_uom.value;
	if(formObjCalSec.rf_name != null){
		fluid_name = formObjCalSec.rf_name.value;
		rf_id	   = formObjCalSec.rf_id.value;
	}
	else{
		fluid_name = "";
		rf_id	   = "";
	}
	var rf_drug_flag=	'D';
	if(item_count != "1" && item_count != "0" ){
		if(fluid_name!="")
			var dialogHeight	= "11" ;
		else
			var dialogHeight	= "10" ;
		var dialogWidth		= "40";
		var dialogTop		= "200" ;
		var dialogLeft		= "0" ;
		var status			= "no";
		var features	= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "";
		retVal=await window.showModalDialog("../../ePH/jsp/DispMedicationVerifyStockDetails.jsp?drug_code="+drug_code+"&drug_name="+escape(drug_name)+"&fluid_name="+fluid_name+"&rf_id="+rf_id,arguments,features);
		if(retVal != undefined && retVal != "" ) {

			var arr = retVal.split(":::");
			var item_code	=	arr[0];
			rf_drug_flag=	arr[1];
		}
		else
			return;
	}

	if(item_count >= 1){
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		var bean_id   = formObjCalSec.bean_id.value;
		var bean_name = formObjCalSec.bean_name.value;
		var temp_jsp="DispMedicationValidate.jsp?identity=getItemCode&bean_id="+bean_id+"&bean_name="+bean_name;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		eval(xmlHttp.responseText) ;
		if(item_code == '' && (rf_drug_flag != undefined && rf_drug_flag != 'RF'))
			var item_code = single_item_code;
	}
	var includeZeroStockBatches ="N";
	var includeExpiredBatches ="N";
	var includeSuspendedBatches ="N";
	var searchFunction ="Y";
	var multipleSelect ="Y";
	if(rf_drug_flag != undefined && rf_drug_flag != null && rf_drug_flag == "RF")
		multipleSelect = "N";
	var retval=await callBatchSearchWindow(item_code,store_code,includeZeroStockBatches,includeExpiredBatches,includeSuspendedBatches,searchFunction,multipleSelect,trade_code,allowchangetradenameyn,allowmultitradeyn,end_date,allow_short_expiry_drugs_yn);
	/*if(retVal!=""){
			var arr = retVal.split(":::");
			//var item_code	=	arr[0];
			var rf_drug_flag=	arr[1];
		}*/
	if(retval != undefined && retval != "" ){
	 parent.ws_order_details_frame.ws_preview_details.location.href="../../ePH/jsp/DispMedicationWSPreviewDetails.jsp";

     	var	order_qty	 = "";
		if(rf_drug_flag != undefined && rf_drug_flag != null && rf_drug_flag == "RF")
			order_qty = formObjCalSec.lbl_stock_qty.innerText;
		else
			order_qty = formObjCalSec.drug_qty_drawn.value;

	   parent.ws_show_batches.location.href ="../../ePH/jsp/DispMedicationWSAllocateBatches.jsp?retval="+ encodeURIComponent(retval,"UTF-8")+"&drug_code="+drug_code+"&drug_name="+escape(drug_name)+"&order_line_no="+order_line_no+"&tot_num_of_drugs="+tot_num_of_drugs+"&fluid_name="+fluid_name+"&rf_id="+rf_id+"&rf_drug_flag="+rf_drug_flag+"&uom="+qty_uom+"&passed_item_code="+item_code+"&order_qty="+order_qty+"&order_id="+order_id+"&patient_id="+patient_id;
	//order_id,order_line_no added for MMS-KH-CRF-0038
	   parent.ws_batches_button.location.href = "../../ePH/jsp/DispMedicationWSBatchesButton.jsp?identity=alloc_batches&quantity="+order_qty+"&order_line_no="+order_line_no+"&flag="+rf_drug_flag;
	   parent.ws_main.rows="44%,51%,5%,0%,0%";
	}
}

var single_item_code="";
function assignItemCode(objValue){
	single_item_code = objValue;
}

async function callBatchSearchWindow(item_code,store_code,includeZeroStockBatches,includeExpiredBatches,includeSuspendedBatches,searchFunction,multipleSelect,trade_code,allowchangetradenameyn,allowmultitradeyn,end_date,allow_short_expiry_drugs_yn){
	end_date= end_date.substring(0,end_date.length-6);
	var dialogHeight	= "90vh" ;
	var dialogWidth		= "90vw";
	var dialogTop		= "10" ;
	var dialogLeft		= "10" ;
	var center			= "0" ;
	var status			="no";
	var features	= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";
	if(allow_short_expiry_drugs_yn=='N'){
		retVal=await top.window.showModalDialog("../../eST/jsp/BatchSearchFrame.jsp?item_code="+item_code+"&store_code="+store_code+"&includeZeroStockBatches="+includeZeroStockBatches+"&includeExpiredBatches="+includeExpiredBatches+"&includeSuspendedBatches="+includeSuspendedBatches+"&searchFunction="+searchFunction+"&multipleSelect="+multipleSelect+"&trade_code="+trade_code+"&p_list_all_trades_yn="+allowchangetradenameyn+"& p_multi_trade_select_yn="+allowmultitradeyn+"&cuttOffDate="+end_date,arguments,features);
	}
	else{
		retVal=await top.window.showModalDialog("../../eST/jsp/BatchSearchFrame.jsp?item_code="+item_code+"&store_code="+store_code+"&includeZeroStockBatches="+includeZeroStockBatches+"&includeExpiredBatches="+includeExpiredBatches+"&includeSuspendedBatches="+includeSuspendedBatches+"&searchFunction="+searchFunction+"&multipleSelect="+multipleSelect+"&trade_code="+trade_code+"&p_list_all_trades_yn="+allowchangetradenameyn+"& p_multi_trade_select_yn="+allowmultitradeyn,arguments,features);
	}
	return retVal;
}

function validateFluidSpillage(obj){
	var formObjCalSec = parent.ws_cal_sec.frmDispMedicationWSCalSec;
	if(parseFloat(obj.value)>formObjCalSec.fluid_qty_preparation.value){
		alert(getMessage("PH_FLUID_SPILL_QTY_NOT_GREATER_THAN_PREP_QTY","PH"));
		obj.focus();
	}else{
		formObjCalSec.fluid_qty_drawn.value = formObjCalSec.fluid_qty_preparation.value-obj.value
		var xmlStr ="<root><SEARCH ";
		xmlStr += " rf_id=\"" + formObjCalSec.rf_id.value + "\"";
		xmlStr += " rf_qty=\"" + formObjCalSec.fluid_qty_drawn.value + "\"";
		xmlStr +=" /></root>";
		var bean_id   = formObjCalSec.bean_id.value;
		var bean_name = formObjCalSec.bean_name.value;
		var temp_jsp="DispMedicationValidate.jsp?identity=getStockQtyUOM&bean_id="+bean_id+"&bean_name="+bean_name;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		eval(xmlHttp.responseText) ;
	}
}

function assignStockQtyUOM(stock_qty,stock_qty_uom){
	var formObjCalSec = parent.ws_cal_sec.frmDispMedicationWSCalSec;
	formObjCalSec.lbl_stock_qty.innerText = stock_qty;
	formObjCalSec.lbl_stock_qty_uom.innerText = stock_qty_uom;
}

function showWSBatches(flag,code,trade_code){
	
	var formObjCalSec = parent.ws_cal_sec.frmDispMedicationWSCalSec;
	parent.ws_main.rows="44%,50%,6%,0%,0%";
	if(flag=="D"){		// D - Drug
		var drug_name	 = formObjCalSec.drug_name.value;
		var	order_qty	 = formObjCalSec.drug_qty_drawn.value;
		//var	order_qty	 = formObjCalSec.alloc_qty.value;
	}
	else if(flag=="F"){	// F - Reconst_fluid
		var drug_name	 = formObjCalSec.rf_name.value;
		var	order_qty	 = formObjCalSec.lbl_stock_qty.innerText;
	}

	var patient_id	 = formObjCalSec.patient_id.value;
	var	order_id	 = formObjCalSec.order_id.value;
	var	order_line_no= formObjCalSec.order_line_no.value;
	var	qty_uom		 = formObjCalSec.qty_uom.value;
	var	drug_code	 = code;
	var	store_code	 = formObjCalSec.store_code.value;
	parent.ws_order_details_frame.ws_preview_details.location.href="../../ePH/jsp/DispMedicationWSPreviewDetails.jsp";
	parent.ws_show_batches.location.href = "../../ePH/jsp/DispMedicationWSShowBatches.jsp?patient_id="+patient_id+"&order_id="+order_id+"&order_line_no="+order_line_no+"&order_qty="+order_qty+"&drug_code="+drug_code+"&store_code="+store_code+"&flag="+flag+"&drug_name="+drug_name+"&uom="+qty_uom+"&trade_code="+trade_code;
	parent.ws_batches_button.location.href = "../../ePH/jsp/DispMedicationWSBatchesButton.jsp?flag="+flag+"&quantity="+order_qty+"&identity=";
}

function saveSelectedBatches(flag,quantity){
	var formObjItems = parent.ws_show_batches.frmDispMedicationWSShowBatches;
	var inner_count = formObjItems.inner_count.value;
	var outer_count = formObjItems.outer_count.value;
	var selected_inner_count = 0;
	var selected_outer_count = 0;
	var tot_qty = 0;
	var uncheckedBoxes = 0;

	var conv_factor         = formObjItems.conv_factor.value;
    var no_decimals_allowed  = formObjItems.no_decimals_allowed.value;
	var act_bms_qty_equl	=  Math.ceil(parseInt(quantity)/parseInt(conv_factor));
	//var disableBMS = parent.ws_order_details_frame.ws_order_details.document.frmDispMedicationWSOrderDetails.MakeReadOnly.value;
	if(outer_count>0 ){
		//var xmlDoc  = new ActiveXObject( "Microsoft.XMLDom" ) ;
		var xmlHttp = new XMLHttpRequest() ;
		var bean_id		= "DispMedicationBean";
		var bean_name	= "ePH.DispMedicationBean";
		var xmlStr ="<root><SEARCH ";
		xmlStr+= "bean_id  =\"" + bean_id + "\" " ;
		xmlStr+= "bean_name =\"" + bean_name + "\" " ;
		xmlStr+= "flag =\"" + flag + "\" " ;
		xmlStr+= "order_line_no =\""+formObjItems.order_line_no.value+"\" ";
		xmlStr+= "drug_code =\""+formObjItems.drug_code.value+"\" ";
		xmlStr+= "uom =\""+formObjItems.uom.value+"\" ";
		xmlStr+= "drug_name =\"" + encodeURIComponent(eval("formObjItems.drug_name").value,"UTF-8")+ "\" " ; //encode Added for [IN:041227]
		xmlStr+= "disp_locn_code  =\"" + eval("formObjItems.disp_locn_code").value+ "\" " ;
		xmlStr+= "store_code =\"" + eval("formObjItems.store_code").value+ "\" " ;
		for (var i=0;i<outer_count ;i++ ){
			selected_outer_count++;
			for (var j=0;j<inner_count ;j++ ){
				if(eval("formObjItems.chkSelect"+i+j).checked){
					if(eval("formObjItems.alloc_qty"+i+j).value != ""&&eval("formObjItems.alloc_qty"+i+j).value != "0"){
						selected_inner_count=inner_count;
						var alloc_qty = parseFloat(eval("formObjItems.alloc_qty"+i+j).value);
						var avail_qty = parseFloat(eval("formObjItems.available_qty"+i+j).value);
						if(alloc_qty > parseFloat(avail_qty)){
							alert(getMessage("PH_ALLOC_QTY_LESS_AVAIL_QTY","PH"));
							eval("formObjItems.alloc_qty"+i+j).focus();
							return false;
						}
						else if(parseInt(no_decimals_allowed)==0){
							if((parseFloat(alloc_qty)%parseFloat(conv_factor))!=0){
								alert(getMessage("PH_ISSUE_UOM_MUL","PH")+conv_factor);								
								return false;
							}
							var alloc_equl			=  Math.ceil(parseInt(alloc_qty)/parseInt(conv_factor));               
							if(alloc_equl>act_bms_qty_equl){
								alert(getMessage("PH_ALLOC_QTY_LESS_STOCK_QTY","PH"));
								eval("formObjItems.alloc_qty"+i+j).focus();
								return false;						
							}									
						}
						else if(alloc_qty > parseFloat(quantity)&&parseInt(no_decimals_allowed)>0){
							alert(getMessage("PH_ALLOC_QTY_LESS_STOCK_QTY","PH"));
							eval("formObjItems.alloc_qty"+i+j).focus();
							return false;
						}
						/*else if(disableBMS == 'true' && alloc_qty < parseFloat(quantity)){
						//added for compounding drug's ratio/percentage CRF to stop BMS delivery
							alert(getMessage("PH_ALLOC_QTY_CANNOT_LESS_STOCK_QTY","PH"));
							eval("formObjItems.alloc_qty"+i+j).focus();
							return false;
						}*/
						
						xmlStr+= "batch_id"+i+j+"  =\"" + eval("formObjItems.batch_id"+i+j).value + "\" " ;
						xmlStr+= "item_code"+i+j+"  =\"" + eval("formObjItems.item_code"+i+j).value+ "\" " ;
						xmlStr+= "item_desc"+i+j+"  =\"" + encodeURIComponent(eval("formObjItems.item_desc"+i+j).value,"UTF-8")+ "\" " ;//encode Added for [IN:041227]
						xmlStr+= "trade_name"+i+j+"  =\"" + encodeURIComponent(eval("formObjItems.trade_name"+i+j).value,"UTF-8")+ "\" " ;
						xmlStr+= "trade_id"+i+j+"  =\"" + eval("formObjItems.trade_id"+i+j).value+ "\" " ;
						xmlStr+= "manufacturer_id"+i+j+"  =\"" + eval("formObjItems.manufacturer_id"+i+j).value+ "\" " ;
						xmlStr+= "manufacturer_name"+i+j+"  =\"" + eval("formObjItems.manufacturer_name"+i+j).value+ "\" " ;
						xmlStr+= "bin_locn_code"+i+j+"  =\"" + eval("formObjItems.bin_locn_code"+i+j).value+ "\" " ;
						xmlStr+= "bin_locn_desc"+i+j+"  =\"" + eval("formObjItems.bin_locn_desc"+i+j).value+ "\" " ;
						xmlStr+= "available_qty"+i+j+"  =\"" + eval("formObjItems.available_qty"+i+j).value+ "\" " ;
						xmlStr+= "expiry_date"+i+j+"  =\"" + eval("formObjItems.expiry_date"+i+j).value + "\" " ;
						xmlStr+= "alloc_qty"+i+j+"  =\"" + alloc_qty + "\" " ;
						tot_qty = parseFloat(tot_qty)+parseFloat(alloc_qty);
					}
					else{
						alert(getMessage("PH_ISSUE_QTY_BLANK","PH"));
						eval("formObjItems.alloc_qty"+i+j).focus();
						return false;
					}
				}
				else{
					uncheckedBoxes =uncheckedBoxes+1 ;
				}
			}
		}
		if(uncheckedBoxes != 0){
			if(parent.ws_cal_sec.frmDispMedicationWSCalSec.drug_qty_spillage.value != 0){
				alert(getMessage("MANDATORY_BATCH_DTLS","PH"));
				return false;
			}
		}

		var tot_alloc_equl			=  Math.ceil(parseInt(tot_qty)/parseInt(conv_factor));
		var act_bms_qty_equl	    =  Math.ceil(parseInt(quantity)/parseInt(conv_factor));

		if(tot_alloc_equl > act_bms_qty_equl){
			alert(getMessage("PH_ALLOC_QTY_LESS_STOCK_QTY","PH"));
			return false;
		}
		/*else if(disableBMS == 'true' && alloc_qty < parseFloat(quantity))
		//added for compounding drug's ratio/percentage CRF to stop BMS delivery
		else if(alloc_qty < parseFloat(quantity)){
			alert(getMessage("PH_ALLOC_QTY_CANNOT_LESS_STOCK_QTY","PH"));
			eval("formObjItems.alloc_qty"+i+j).focus();
			return false;
		}*/
		xmlStr+= "selected_outer_count =\"" + selected_outer_count + "\" " ;
		xmlStr+= "selected_inner_count =\"" + selected_inner_count + "\" " ;
		xmlStr +=" /></root>";
		var temp_jsp="DispMedicationValidate.jsp?identity=show_batches&bean_id="+bean_id+"&bean_name="+bean_name;
		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
	}

	parent.ws_main.rows="44%,0%,0%,50%,6%";
	tot_num_of_drugs = parent.ws_cal_sec.frmDispMedicationWSCalSec.tot_num_of_drugs.value;

	var arrObj = formObjItems.elements;
	for(var i=0;i<arrObj.length;i++) {
		var val = "" ;
		var obj_name	=	"";
		obj_name		=	arrObj[i].name;
		
		if( obj_name.substring(0,9)=="alloc_qty"){
			val = arrObj[i].value;
	   }  
    }

	var drug_code		=formObjItems.drug_code.value;
	var drug_name		=eval("formObjItems.drug_name").value;
	var qty				=val;
	var formobject      =parent.ws_cal_sec.frmDispMedicationWSCalSec;
    var patient_id      =formobject.patient_id.value;
	getDrugForm(drug_code);
	var order_id		=formobject.order_id.value;
	var order_line_num	=formObjItems.order_line_no.value;
    var qty_uom         =formObjItems.uom.value;
    var formObjOrderDtls= parent.ws_order_details_frame.ws_order_details.frmDispMedicationWSOrderDetails;

	parent.parent.ws_cal_sec.location.href="../../ePH/jsp/DispMedicationWSCalSec.jsp?drug_code="+drug_code+"&drug_name="+escape(drug_name)+"&qty="+qty+"&drug_form="+drug_form+"&patient_id="+patient_id+"&order_id="+order_id+"&order_line_no="+order_line_num+"&qty_uom="+qty_uom+"&tot_num_of_drugs="+formobject.tot_num_of_drugs.value;
	//parent.parent.ws_display_sec.location.href="../../ePH/jsp/DispMedicationWSDisplaySec.jsp?tot_num_of_drugs="+formObjOrderDtls.tot_num_of_drugs.value;
	addDrug1(parent.ws_cal_sec.frmDispMedicationWSCalSec);	
	var formObj = parent.ws_order_details_frame.ws_order_details.frmDispMedicationWSOrderDetails;
	var len=formObj.wsorderdetailstable.rows.length;
	var selected_row = formObj.selected_drug.value;
	for(var i=1;i<=len;i++){			
		if((i==(parseFloat(selected_row)))){
			
			if(eval("formObj.ingredient_name"+(i+1))!= null){
               if(flag!='F'){
				 eval("formObj.ingredient_name"+(i+1)).click();
			   }
			   else{
                 eval("formObj.fluid_name"+(i)).click();
			   }
			}
			else{
               eval("formObj.ingredient_name"+(i)).click();
			}

			if(eval("formObj.alt_ingredient_name"+(i+1))!=null)
				eval("formObj.alt_ingredient_name"+(i+1)).click();
		}
	}
	parent.ws_batches_button.location.href = "../../ePH/jsp/DispMedicationWSBatchesButton.jsp?identity=preview&tot_num_of_drugs="+tot_num_of_drugs;
	parent.ws_order_details_frame.ws_preview_details.location.href="../../ePH/jsp/DispMedicationWSPreviewDetails.jsp"; 
	parent.ws_action_buttons.document.frmDispMedicationWSActionButtons.recordWSButton.disabled=false;
}

function saveAllocatedBatches(flag,quantity){
	if(flag!="CANCEL"){
		var storei = 1;
		var storej = 2;
		var formObjItems = parent.ws_show_batches.frmDispMedicationWSAllocateBatches;
		if(formObjItems.drug_item_count !=  undefined){
			var tot_qty = 0;
			var allocQty ;
			var availQty ;
			var formObjCalSec  = parent.ws_cal_sec.frmDispMedicationWSCalSec;
			var bean_id = formObjCalSec.bean_id.value;
			var bean_name = formObjCalSec.bean_name.value;

            var conv_factor          = formObjItems.conv_factor.value;
            var no_decimals_allowed  = formObjItems.no_decimals_allowed.value;
			var act_bms_qty_equl	=  Math.ceil(parseInt(quantity)/parseInt(conv_factor));

			var xmlDoc="";
			var xmlHttp = new XMLHttpRequest();
			xmlStr	=	"<root><SEARCH " ;
			xmlStr	+=	"bean_id	=\"" + bean_id + "\" " ;
			xmlStr	+=	"bean_name  =\"" + bean_name + "\" " ;

			if(flag != "RF"){	// RF - Reconst Fluid

				for (var i=1;i<=parseFloat(parent.ws_show_batches.frmDispMedicationWSAllocateBatches.drug_item_count.value) ;i++ ){
					xmlStr	+=	"item_code"+i+"  =\"" + eval("formObjItems.item_code"+i).value + "\" " ;
					xmlStr	+=	"drug_code"+i+"  =\"" + eval("formObjItems.drug_code"+i).value + "\" " ;
					var alloc_qty_count = formObjItems.alloc_qty_count.value;

					if(eval("formObjItems.row_count"+i) != null){
						var row_count = eval("formObjItems.row_count"+i).value;
						for (var k=1;k<row_count ; k++){
							if(eval("formObjItems.chkSelect"+i+k).checked){
								if( eval("formObjItems.alloc_qty"+i+k) != null && eval("formObjItems.avail_qty"+i+k) != null){

									allocQty = eval("formObjItems.alloc_qty"+i+k).value;
									availQty = eval("formObjItems.avail_qty"+i+k).value;

									if( allocQty == "" || allocQty == "0"){
										alert(getMessage("ALLOC_QTY_CANNOT_BLANK_ZERO","PH"));
										eval("formObjItems.alloc_qty"+i+k).focus();
										return false;
									}
									else if ( parseInt(allocQty) > parseInt(availQty)){
										alert(getMessage("PH_ALLOC_QTY_LESS_OR_EQUAL_AVAIL_QTY","PH"));
										eval("formObjItems.alloc_qty"+i+k).focus();
										return false;									
									}
									xmlStr	+=	"alloc_qty"+i+k+"  =\"" + allocQty + "\" " ;
									tot_qty = parseFloat(tot_qty)+parseFloat(allocQty);

									if(no_decimals_allowed>0){									
											if(parseFloat(tot_qty) > parseFloat(eval("formObjItems.ordered_qty"+i).value)){
												alert(getMessage("PH_ALLOC_QTY_LESS_BMS_QTY","PH"));
												eval("formObjItems.alloc_qty"+i+k).focus();
												return false;

											}
											else if(parseFloat(tot_qty) > parseFloat(quantity)){
													alert(getMessage("PH_ALLOC_QTY_LESS_STOCK_QTY","PH"));
													eval("formObjItems.alloc_qty"+i+k).focus();
													return false;
											}
									}else{
										var tot_qty_equl	=  Math.ceil(parseInt(tot_qty)/parseInt(conv_factor));
										var ordered_qty_equl=  Math.ceil(parseInt(eval("formObjItems.ordered_qty"+i).value)/parseInt(conv_factor));
										var quantity_equl	=  Math.ceil(parseInt(quantity)/parseInt(conv_factor));
											if(parseFloat(tot_qty_equl) > parseFloat(ordered_qty_equl)){
												alert(getMessage("PH_ALLOC_QTY_LESS_BMS_QTY","PH"));
												eval("formObjItems.alloc_qty"+i+k).focus();
												return false;

											}
											else if(parseFloat(tot_qty_equl) > parseFloat(quantity_equl)){
													alert(getMessage("PH_ALLOC_QTY_LESS_STOCK_QTY","PH"));
													eval("formObjItems.alloc_qty"+i+k).focus();
													return false;
											}
									}
								}
							}
						}
						xmlStr	+=	"row_count"+i+"  =\"" + row_count + "\" " ;
					}
				}
				xmlStr	+=	"alloc_qty_count  =\"" + formObjItems.alloc_qty_count.value + "\" " ;
				xmlStr	+=	"drug_item_count  =\"" + formObjItems.drug_item_count.value + "\" " ;
			}else if(flag=="RF"){

				var alloc_qty = formObjItems.alloc_qty1.value;
				var avail_qty = formObjItems.available_qty.value;
				if(alloc_qty > parseFloat(avail_qty)){
					alert(getMessage("PH_ALLOC_QTY_LESS_AVAIL_QTY","PH"));
					return false;
				}
				else if(alloc_qty > parseFloat(quantity)){
					alert(getMessage("PH_ALLOC_QTY_LESS_STOCK_QTY","PH"));
					return false;
				}

				var len = formObjItems.rec_count.value;
				for (var i=1;i<len ; i++){
					xmlStr	+=	"alloc_qty"+i+"  =\"" + eval("formObjItems.alloc_qty"+i).value + "\" " ;
				}
				xmlStr  +=  "rec_count    =\"" + formObjItems.rec_count.value + "\" " ;
			}
			xmlStr  +=  "order_line_no    =\"" + formObjCalSec.order_line_no.value + "\" " ;
			xmlStr	+=	" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST", "DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=alloc_batches&flag="+flag, false ) ;
			xmlHttp.send( xmlDoc ) ;

			addDrug1(parent.ws_cal_sec.frmDispMedicationWSCalSec);	
			var formObj = parent.ws_order_details_frame.ws_order_details.frmDispMedicationWSOrderDetails;
			var len=formObj.wsorderdetailstable.rows.length;
			var selected_row = formObj.selected_drug.value;
			for(var i=1;i<=len;i++){			
				if((i==(parseFloat(selected_row)))){
					if(eval("formObj.ingredient_name"+(i+1))!= null)
						eval("formObj.ingredient_name"+(i+1)).click();
					if(eval("formObj.alt_ingredient_name"+(i+1))!=null)
						eval("formObj.alt_ingredient_name"+(i+1)).click();
				}
			}
			parent.ws_action_buttons.document.frmDispMedicationWSActionButtons.recordWSButton.disabled=false;
		}
		else 
			return;
	}
	parent.ws_main.rows="44%,0%,0%,50%,6%";

}

function checkWSTotQty(quantity){
	var formObjBatches = parent.ws_show_batches.frmDispMedicationWSAllocateBatches;
	var len = formObjBatches.wsallocatebatchestable.rows.length;
	var total = "0";
	for(var i=1;i<len-2;i++){
		if(eval("formObjBatches.alloc_qty"+i) != null){
			var alloc_qty = eval("formObjBatches.alloc_qty"+i).value;
			total = parseFloat(total) + parseFloat(alloc_qty);
		}
	}
	if(parseFloat(total)<=parseFloat(quantity)){
		return true;
	}else{
		return false;
	}
}

function validateAllocQty(obj,avail_qty){
	if(parseFloat(obj.value)>parseFloat(avail_qty)){
		alert(getMessage("PH_ALLOC_QTY_LESS_OR_EQUAL_AVAIL_QTY","PH"));
		obj.select();
	}
}
async function showWSDialogForPrinting(obj){

	var dialogHeight= "13" ;
	var dialogWidth	= "30" ;
	var dialogTop = "300" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; scroll=auto;  dialogTop :" + dialogTop;
	var arguments	= "" ;
	//var retVal= window.showModalDialog("../../ePH/jsp/DispMedicationWSStabilityInfoFrames.jsp?identity="+obj,arguments,features);
	var retVal=await window.showModalDialog("../../ePH/jsp/DispMedicationWorksheetPrintDialog.jsp?identity="+obj,arguments,features);
	//var stability_info="ddddd";
	//var retVal = window.showModalDialog("../../ePH/jsp/DispMedicationWSStabilityInfo.jsp?stability_info="+stability_info,arguments,features);
     if(retVal==undefined){
		 retVal="N:N:";
	 }
	return retVal;
}

function assignSelectedReports(frmObj){
	/*
		selected_ws_report_1 - For Worksheet (Y-Print,N-Not to Print)
		selected_ws_report_2 - For Manufacturing Label (Y-Print,N-Not to Print)
	*/
	var selected_ws_report_4="N";   // Added for GHL-CRF-0468 [21/12/2017]
	var selected_ws_report_5="N";  // Added for GHL-CRF-0468  [21/12/2017]

	if(frmObj.work_sheet!= null && frmObj.work_sheet != undefined && frmObj.work_sheet.checked==true){
		selected_ws_report_1="Y";
	}else{
		selected_ws_report_1="N";
	}

	if(frmObj.manufacturing_label !=null && frmObj.manufacturing_label!= undefined){
		if(document.getElementById('manufacturing_label').checked==true){
			selected_ws_report_2="Y";
		}
	}
	else{
			selected_ws_report_2="N";
		}

	var printOthers = "";

	if(frmObj.certiReimbur != undefined && frmObj.certiReimbur.checked)
		printOthers		= printOthers +"CR~";

	if(frmObj.medicalSupplyLabel != undefined && frmObj.medicalSupplyLabel.checked)
		printOthers		= printOthers +  "MSL~";

	if(frmObj.medicationList != undefined && frmObj.medicationList.checked)
		printOthers		= printOthers +  "ML~";
	
	if(frmObj.token != undefined && frmObj.token.checked)
		printOthers		= printOthers +  "TOK~";
	
	if(frmObj.homeMedicationSheet != undefined && frmObj.homeMedicationSheet.checked)
		printOthers		= printOthers +  "HMS~";
//added for ml-mmoh-crf-0468-start
	if(frmObj.cover_bag!= null && frmObj.cover_bag != undefined && frmObj.cover_bag.checked==true){
		selected_ws_report_4="Y";
	}else{
		selected_ws_report_4="N";
	}

	if(frmObj.lipid_label !=null && frmObj.lipid_label!= undefined){
		if(document.getElementById('lipid_label').checked==true){
			selected_ws_report_5="Y";
		}
	
	else{
			selected_ws_report_5="N";
		}
	}
		//added for ml-mmoh-crf-0468 end
		//added for ML-MMOH-CRF-2042
	if(frmObj.tpn_dispense_sheet !=null && frmObj.tpn_dispense_sheet!= undefined){
		if(document.getElementById('tpn_dispense_sheet').checked==true){
			selected_ws_report_6="Y";
	}

else{
		selected_ws_report_6="N";
	}
}
	window.returnValue=selected_ws_report_1+":"+selected_ws_report_2+":"+printOthers+":"+selected_ws_report_4+":"+selected_ws_report_5+":"+selected_ws_report_6;//modified for ml-mmoh-crf-0468 ; modified for ML-MMOH-CRF-2042
}

function callLabelPrintDialog(mainForm,flag,selected_ws_report_1,selected_ws_report_2,selected_ws_report_3,obj,selected_ws_report_4,selected_ws_report_5,selected_ws_report_6){//modified for ml-mmoh-crf-0468

	  if(selected_ws_report_1=='Y' ||selected_ws_report_2=='Y'||selected_ws_report_4=='Y' ||selected_ws_report_5=='Y' || selected_ws_report_3 != ''||selected_ws_report_6=='Y'){//modified for ml-mmoh-crf-0468;modified for ml-mmoh-crf-2042
			bean_id			=	mainForm.bean_id_1.value;
			bean_name		=	mainForm.bean_name_1.value;
			work_sheet_id	=   flag;
			disp_locn_code	=   mainForm.disp_locn_code.value;
			var pid			=   mainForm.patient_id.value;
			var xmlStr ="<root><SEARCH ";
			xmlStr+= "bean_id  =\"" + bean_id + "\" " ;
			xmlStr+= "bean_name =\"" + bean_name + "\" " ;
			xmlStr+= "work_sheet_id =\"" + work_sheet_id + "\" " ;
			xmlStr+= "disp_locn_code =\"" + disp_locn_code + "\" " ;
			xmlStr+= "selected_ws_report_1 =\""+selected_ws_report_1+"\" ";
			xmlStr+= "selected_ws_report_2 =\""+selected_ws_report_2+"\" ";
			xmlStr+= "selected_ws_report_4 =\""+selected_ws_report_4+"\" ";//added for ml-mmoh-crf-0468
			xmlStr+= "selected_ws_report_5 =\""+selected_ws_report_5+"\" ";//added for ml-mmoh-crf-0468
			xmlStr+= "selected_ws_report_6 =\""+selected_ws_report_6+"\" ";//added for ml-mmoh-crf-2042
			xmlStr+= "pid =\""+pid+"\" ";//added for ml-mmoh-crf-2042																				  
			xmlStr+= "otherReports =\""+selected_ws_report_3+"\" ";
			xmlStr+= "ws_type =\""+obj+"\" ";
			xmlStr +=" /></root>";
			var temp_jsp = "DispMedicationValidation.jsp?func_mode=print_label";
			//var xmlDoc   = new ActiveXObject( "Microsoft.XMLDom" ) ;
			var xmlHttp  = new ActiveXObject( "Microsoft.XMLHTTP" ) ;
			var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST",temp_jsp,true);
			xmlHttp.send(xmlDoc);
			//responseText=xmlHttp.responseText ;
			//eval(xmlHttp.responseText) ;
	  }
}
async function ReconstituentFluidLookup(target){

	var formObj = document.frmDispMedicationWSCalSec;

	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

	argumentArray[0]   = formObj.SQL_PH_DISP_MEDICATION_SELECT38.value;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = target.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = CODE_DESC ;
	var retVal = await CommonLookup( getLabel("ePH.ReconstituentFluid.label","PH"), argumentArray );
	var ret1=unescape(retVal);
	var arr=ret1.split(",");
	if(retVal != null && retVal != "" )  {
		target.value = arr[1] ;
		formObj.rf_id.value = arr[0] ;
		target.disabled = true;
		formObj.btnStabilityInfo.style.visibility="visible";
		getRfQty(formObj.drug_code.value,formObj.rf_id.value);
		var drug_qty_as_per_order = formObj.drug_qty_as_per_order.value;
		formObj.fluid_qty_as_per_order.value = formObj.rf_qty.value * drug_qty_as_per_order;
		formObj.fluid_qty_preparation.value = formObj.rf_qty.value * formObj.drug_qty_preparation.value;
		formObj.fluid_qty_drawn.value = formObj.fluid_qty_preparation.value

		formObj.lblFluidShowBatches.style='display';

		formObj.lbl_stock_qty.style='display';
		formObj.lbl_stock_qty_uom.style='display';

		formObj.btnStockAvailability.disabled =false;
		var xmlStr ="<root><SEARCH ";
		xmlStr += " rf_id=\"" + formObj.rf_id.value + "\"";
		xmlStr += " rf_qty=\"" + formObj.fluid_qty_drawn.value + "\"";
		xmlStr += " rf_name=\"" + arr[1] + "\"";
		xmlStr +=" /></root>";
		var bean_id   = formObj.bean_id.value;
		var bean_name = formObj.bean_name.value;
		var temp_jsp="DispMedicationValidate.jsp?identity=getStockQtyUOM&bean_id="+bean_id+"&bean_name="+bean_name;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		eval(xmlHttp.responseText) ;
	}
}

function assignStabilityInfoAndRfQty(rf_qty,rf_qty_uom){

	//document.frmDispMedicationWSCalSec.stability_info.value=obj;
	document.frmDispMedicationWSCalSec.rf_qty.value=rf_qty;
	document.frmDispMedicationWSCalSec.uom_1.innerText=rf_qty_uom;
	document.frmDispMedicationWSCalSec.uom_2.innerText=rf_qty_uom;
	document.frmDispMedicationWSCalSec.uom_3.innerText=rf_qty_uom;
	document.frmDispMedicationWSCalSec.uom_4.innerText=rf_qty_uom;
}

function getRfQty(drug_code,rf_id){
	var formObj = document.frmDispMedicationWSCalSec;
	var bean_id   = formObj.bean_id.value;
	var bean_name = formObj.bean_name.value;
	//var xmlDoc  = new ActiveXObject( "Microsoft.XMLDom" ) ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr += " drug_code=\""+drug_code+"\"";
	xmlStr += " rf_id=\""+rf_id+"\"";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr += " /></root>";
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	xmlHttp.open("POST","DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=getRfQty",false);
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);
}

function clearCalSection(){
	var formObjCalSec = document.frmDispMedicationWSCalSec;
	formObjCalSec.reset();

	if(formObjCalSec.fluid_qty_as_per_order != null){
		formObjCalSec.rf_name.value="";
		formObjCalSec.fluid_qty_as_per_order.value="";
		formObjCalSec.fluid_qty_preparation.value="";
		formObjCalSec.fluid_qty_spillage.value="";
		formObjCalSec.fluid_qty_drawn.value="";
	}
	if(formObjCalSec.btnStabilityInfo != null){
		formObjCalSec.btnStabilityInfo.style.visibility="hidden";
		if(formObjCalSec.lblFluidShowBatches != null){
			formObjCalSec.lblFluidShowBatches.style.display="none";
			formObjCalSec.lbl_stock_qty.style.display ="none";
			formObjCalSec.lbl_stock_qty_uom.style.display ="none";
		}
	}
	if(formObjCalSec.rf_name != null){
		formObjCalSec.rf_name.disabled = false;
	}

	var formObjOrderDtls= parent.ws_order_details_frame.ws_order_details.frmDispMedicationWSOrderDetails;
	for(var i=1;i<=formObjOrderDtls.tot_num_of_drugs.value;i++){
		if(eval("formObjOrderDtls.fluid_name"+i)!=null){
			eval("formObjOrderDtls.fluid_name"+i).style="display";
			eval("formObjOrderDtls.lbl_fluid_name"+i).style.display="none";
		}else if(eval("formObjOrderDtls.ingredient_name"+i)!=null){
			eval("formObjOrderDtls.ingredient_name"+i).style="display";
			eval("formObjOrderDtls.lbl_ingredient_name"+i).style.display="none";
		}else if(eval("formObjOrderDtls.alt_ingredient_name"+i)!=null){
			eval("formObjOrderDtls.alt_ingredient_name"+i).style="display";
			eval("formObjOrderDtls.lbl_alt_ingredient_name"+i).style.display="none";
		}
	}
}

function addDrug(formObjCalSec){

	var formObjDispSec = parent.ws_display_sec.frmDispMedicationWSDisplaySec;
	var formObjOrderDtls= parent.ws_order_details_frame.ws_order_details.frmDispMedicationWSOrderDetails;
	var row_no = formObjDispSec.wsdisplaysectable.rows.length-3;	
	curr_row	=	formObjDispSec.wsdisplaysectable.insertRow();
	if(row_no % 2 == 0 )
		classval	=	"QRYEVEN";
	else
		classval	=	"QRYODD";

	var fields  = new Array() ;
	var names   = new Array() ;
	if(formObjCalSec.drug_qty_preparation.value == ""){
		fields[0]  = formObjCalSec.drug_qty_preparation ;
		names[0]   = getLabel("ePH.PreparationQuantity.label","PH");
	}
	else{
		if(formObjCalSec.drug_form.value=="P"){
			if(formObjCalSec.fluid_qty_preparation.value == ""){
				fields[0]  = formObjCalSec.fluid_qty_preparation ;
				names[0]   = getLabel("ePH.FldPrpQty.label","PH");
				formObjCalSec.rf_name.focus();
			}
			else if (formObjCalSec.fluid_qty_as_per_order.value == ""){
				fields[0]  = formObjCalSec.fluid_qty_as_per_order ;
				names[0]   = getLabel("ePH.FldQtyAsPerOrd.label","PH");
				formObjCalSec.rf_name.focus();
			}
		}
	}
	var strAppend = "";
	var fluidColor = "style=color:#CC00CC";

	if(checkFlds( fields, names)){
		for(var i=1;i<=formObjOrderDtls.tot_num_of_drugs.value;i++){
			if(eval("formObjOrderDtls.fluid_name"+i)!=null){
				eval("formObjOrderDtls.fluid_name"+i).style="display";
				eval("formObjOrderDtls.lbl_fluid_name"+i).style.display="none";
			}
			else if(eval("formObjOrderDtls.ingredient_name"+i)!=null){
				eval("formObjOrderDtls.ingredient_name"+i).style="display";
				eval("formObjOrderDtls.lbl_ingredient_name"+i).style.display="none";
			}
			else if(eval("formObjOrderDtls.alt_ingredient_name"+i)!=null){
				eval("formObjOrderDtls.alt_ingredient_name"+i).style="display";
				eval("formObjOrderDtls.lbl_alt_ingredient_name"+i).style.display="none";
			}
		}

		var bean_id		= formObjCalSec.bean_id.value ;
		var bean_name	= formObjCalSec.bean_name.value ;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	= " <root><SEARCH " ;
		xmlStr += " order_line_no =\""+formObjCalSec.order_line_no.value+"\"";
		xmlStr += " physical_form =\""+formObjCalSec.drug_form.value+"\"";
		for(i=0; i<6; i++)	{
			cell	=	curr_row.insertCell();
			if (i==0){
				curr_row.cells[0].className	= classval;
				curr_row.cells[0].innerHTML = "<input type='checkbox' name='chkDel"+row_no+"' id='chkDel"+row_no+"'><input type='hidden' name='order_line_no"+row_no+"' id='order_line_no"+row_no+"' value='"+formObjCalSec.order_line_no.value+"'>";
			}
			if (i==1){
				curr_row.cells[1].className	= classval;
				if(formObjCalSec.drug_form.value=="P"){
					strAppend = "<label "+fluidColor+" >"+formObjCalSec.rf_name.value+"</label>";
					xmlStr += " rf_id =\""+formObjCalSec.rf_id.value+"\"";
				}
				curr_row.cells[1].innerHTML = "<label>"+formObjCalSec.drug_name.value+"</label><br>&nbsp;&nbsp;&nbsp;"+strAppend;
				xmlStr += " drug_code =\""+formObjCalSec.drug_code.value+"\"";
			}
			if (i==2){
				curr_row.cells[2].className	= classval;
				if(formObjCalSec.drug_form.value=="P"){
					strAppend = "<label "+fluidColor+">"+formObjCalSec.fluid_qty_as_per_order.value+"</label>";
					xmlStr += " fluid_qty_as_per_order =\""+formObjCalSec.fluid_qty_as_per_order.value+"\"";
				}
				curr_row.cells[2].innerHTML = "<label>"+formObjCalSec.drug_qty_as_per_order.value+"</label><br>&nbsp;&nbsp;&nbsp;"+strAppend;
				xmlStr += " drug_qty_as_per_order =\""+formObjCalSec.drug_qty_as_per_order.value+"\"";
			}
			if (i==3){
				curr_row.cells[3].className	= classval;
				if(formObjCalSec.drug_form.value=="P"){
					strAppend = "<label "+fluidColor+">"+formObjCalSec.fluid_qty_preparation.value+"</label>";
					xmlStr += " fluid_qty_preparation =\""+formObjCalSec.fluid_qty_preparation.value+"\"";
				}
				curr_row.cells[3].innerHTML = "<label>"+formObjCalSec.drug_qty_preparation.value+"</label><br>&nbsp;&nbsp;&nbsp;"+strAppend;
				xmlStr += " drug_qty_preparation =\""+formObjCalSec.drug_qty_preparation.value+"\"";
			}
			if (i==4){
				curr_row.cells[4].className	= classval;
				if(formObjCalSec.drug_form.value=="P"){
					strAppend = "<label "+fluidColor+">"+formObjCalSec.fluid_qty_spillage.value+"</label>";
					xmlStr += " fluid_qty_spillage =\""+formObjCalSec.fluid_qty_spillage.value+"\"";
				}
				curr_row.cells[4].innerHTML = "<label>"+formObjCalSec.drug_qty_spillage.value+"</label><br>&nbsp;&nbsp;&nbsp;"+strAppend;
				xmlStr += " drug_qty_spillage =\""+formObjCalSec.drug_qty_spillage.value+"\"";
			}
			if (i==5){
				curr_row.cells[5].className	= classval;
				if(formObjCalSec.drug_form.value=="P"){
					strAppend = "<label "+fluidColor+">"+formObjCalSec.lbl_stock_qty.innerText+"</label>";
					xmlStr += " fluid_qty_drawn =\""+formObjCalSec.lbl_stock_qty.innerText+"\"";
				}
				curr_row.cells[5].innerHTML = "<label>"+formObjCalSec.drug_qty_drawn.value+"</label><br>&nbsp;&nbsp;&nbsp;"+strAppend;
				xmlStr += " drug_qty_drawn =\""+formObjCalSec.drug_qty_drawn.value+"\"";
			}
		}
		xmlStr += " /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=ws_add_drug_details",false);
		xmlHttp.send( xmlDoc ) ;
		//parent.parent.ws_display_sec.location.href="../../ePH/jsp/DispMedicationWSDisplaySec.jsp?tot_num_of_drugs="+formObjOrderDtls.tot_num_of_drugs.value;
	}
}

async function callStabilityInfo(){
	var formObj = document.frmDispMedicationWSCalSec;
	var drug_code = formObj.drug_code.value;
	var rf_id = formObj.rf_id.value;
	var dialogHeight= "10" ;
	var dialogWidth	= "25" ;
	var dialogTop = "195" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal =await window.showModalDialog("../../ePH/jsp/DispMedicationWSStabilityInfo.jsp?rf_id="+rf_id+"&drug_code="+drug_code,arguments,features);

}
// 	IV Admixture Worksheet related coding ends here


// This is to show TPN Admixture worksheet
async function showWorksheetForTPNAdmixture(patient_id,order_id,disp_stage){
	var dialogHeight	= "40" ;
	var dialogWidth		= "64";
	var dialogTop		= "86" ;
	var dialogLeft		= "120" ;
	var center			= "0" ;
	var status			="no";
	var features	= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; scroll=auto; status:no; dialogTop :" + dialogTop;
	var arguments	= "";
	if(parent.f_stage==undefined){
		if(parent.f_disp_medication_allocation==null){		
			 var formObj = parent.f_disp_medication_filling.DispMedicationAllStages;
		}else{
			var formObj = parent.f_disp_medication_allocation.DispMedicationAllStages;
		}
	}else{
        var formObj = parent.f_stage.DispMedicationAllStages;
	}
	
	var tot_num_of_drugs=formObj.tot_rec.value;
	 var tot =tot_num_of_drugs;
	for(i=1;i<tot;i++){
		var dischargeIND                 =eval("formObj.dischargeIND"+i).value;
	}
	var tpn_finalize_value = '';
	//window.open("../../ePH/jsp/TPNWorkSheet.jsp?patient_id="+patient_id+"&order_id="+order_id+"&disp_stage="+disp_stage+"&tot_num_of_drugs="+tot_num_of_drugs,arguments,features);
	var retVal=await window.showModalDialog("../../ePH/jsp/TPNWorkSheet.jsp?patient_id="+patient_id+"&order_id="+order_id+"&dischargeIND="+dischargeIND+"&disp_stage="+disp_stage+"&tot_num_of_drugs="+tot_num_of_drugs,arguments,features);
	//if(parent.f_disp_medication_allocation == null)	


		if(retVal == undefined) 
			retVal = ' :: ';
	   detail = retVal.split("::");
       var flag                         =  detail[0];
	   var billing_interface_yn         = "";
	   var tot_groos_pat_payable_str    = "";
       var tot_gross_charge_amount_str  = "";
	   

		if((flag == "YES") || (flag == "NO")){
			tpn_finalize_value = flag;
                billing_interface_yn         =  detail[1];
			if(billing_interface_yn=='Y'){
			     var tot_groos_pat_payable_str    =  detail[2];
                 var tot_gross_charge_amount_str  =  detail[3];
			}

		} else {
			tpn_finalize_value = '';
		}

	if(disp_stage!="F"){
		if(parent.f_stage==undefined){
	 	   parent.f_disp_medication_allocation.location.href="../../ePH/jsp/DispMedicationAllocation.jsp?patient_id="+patient_id+"&encounter_id=DUMMYENCOUNTERID&order_id="+order_id+"&TPN_FINALIZE=YES"+"&tot_groos_pat_payable_str="+tot_groos_pat_payable_str+"&tot_gross_charge_amount_str="+tot_gross_charge_amount_str;
        }
		else{
           parent.f_stage.location.href="../../ePH/jsp/DispMedicationAllocation.jsp?patient_id="+patient_id+"&encounter_id=DUMMYENCOUNTERID&order_id="+order_id+"&TPN_FINALIZE=YES"+"&tot_groos_pat_payable_str="+tot_groos_pat_payable_str+"&tot_gross_charge_amount_str="+tot_gross_charge_amount_str;  
		}
	}
	else if(disp_stage=="F"){
		if(parent.f_stage==undefined){
			parent.f_disp_medication_filling.location.href="../../ePH/jsp/DispMedicationFilling.jsp?patient_id="+patient_id+"&encounter_id=DUMMYENCOUNTERID&order_id="+order_id+"&TPN_FINALIZE="+tpn_finalize_value+"&tot_groos_pat_payable_str="+tot_groos_pat_payable_str+"&tot_gross_charge_amount_str="+tot_gross_charge_amount_str;
        }
		else{
            parent.f_stage.location.href="../../ePH/jsp/DispMedicationFilling.jsp?patient_id="+patient_id+"&encounter_id=DUMMYENCOUNTERID&order_id="+order_id+"&TPN_FINALIZE="+tpn_finalize_value+"&tot_groos_pat_payable_str="+tot_groos_pat_payable_str+"&tot_gross_charge_amount_str="+tot_gross_charge_amount_str;
		}
    }
}

function setLabelLanguage(objValue){
	document.getElementById("label_language").value=objValue;
}

function clearValue(obj1,obj2) {
  if(trimString(obj1.value)=="")
	   obj2.value="";
}

async function showPrintPrescription(patient_id, order_type){
	var dialogHeight	= "90vh" ;
	var dialogWidth		= "90vw" ;
	var dialogTop		= "10" ;
	var center			= "1" ;
	var status			= "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; scroll=auto;  dialogTop :" + dialogTop;
	var arguments	= "" ;

	if(order_type == undefined)
		order_type="";

	var retVal =await top.window.showModalDialog("../../ePH/jsp/PrintPrescription.jsp?patient_id="+patient_id+"&order_type="+order_type,arguments,features);
}


function SubmitLink(from,to){
	var obj				=	document.frmDispMedicationPatientIDDisplay;
	obj.from.value		=	from;
	obj.to.value		=	to;
	obj.submit();
}
//Added for MMS-DM-CRF-0228 start
function SubmitLinkForPagination(from,to,type){
	//alert("from="+from+"==To="+to);
	var ph_print_prescription = parent.patient_id_display.document.forms[0].ph_print_prescription.value;
	if(ph_print_prescription=="true"){
	var display_anchors="";
	var number="0";

	display_anchors= document.getElementById("defaultwindow").value;
	document.getElementById("disprec").innerHTML=display_anchors;
	parent.patient_id_display.document.forms[0].from.value=from;
	parent.patient_id_display.document.forms[0].to.value=to;
	parent.patient_id_display.document.forms[0].submit();
	}
}//Added for MMS-DM-CRF-0228 end

function uppercase() {
	key = window.event.keyCode;
	if((key>0x60) && (key< 0x7B))
	window.event.keyCode=key-0x20;
}

function locatePage(patient_id){
	var bean_id   = "DispMedicationAllStages";
	var bean_name = "ePH.DispMedicationAllStages"
	var xmlStr ="<root><SEARCH ";
	xmlStr+= "bean_id =\"" + bean_id + "\" " ;
	xmlStr+= "bean_name=\"" + bean_name + "\" " ;
	xmlStr+= "patient_id=\"" + patient_id + "\" " ;		
	xmlStr +=" /></root>";
	var temp_jsp="DispMedicationValidation.jsp?func_mode=page_finder";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);
	return false;
}

function showPage(index) {
	var formObj = parent.document.patient_id_display.frmDispMedicationPatientIDDisplay;
	var start	=	formObj.start.value;
	var end		=	formObj.end.value;	
	var page	=	Math.ceil(parseFloat(parseInt(index)/12));
	var total	=	formObj.tot_rec.value;
	next_start	=	(12*Math.abs(parseInt(page)-1))+1;
	next_end	=	(12*parseInt(page));
	if(page!=0) {
		//SubmitLink(next_start,next_end)
		formObj.from.value		=	next_start;
		formObj.to.value		=	next_end;
		formObj.submit();
	} 
	else if(page==0) {
		alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
	}
	return false;
}

function tryLocatingPatient() {
	var formObj		= document.frmDispMedicationPatientIDDisplay;
	var row_no		=	parseInt(formObj.tot_rec.value);

	if(parent.patient_id_locator!=null){
		url	=	parent.patient_id_locator.location.href;
		if(url.indexOf(".jsp")!="-1") {
			if(parent.patient_id_locator.frmPatientIDLocator.patient_id_locator!=null) {
				pat_id	=	parent.patient_id_locator.frmPatientIDLocator.patient_id_locator.value;
				if(pat_id.substr(0,5)!="Enter") {
					for (var i=0;i<row_no ; i++){
						if (eval("formObj.patient_id"+i).value==trimString(pat_id)){
							eval("formObj.patient_id_label"+i).scrollIntoView();
							eval("formObj.patient_id_label"+i).click()
							//formObj.patientiddisplaytable.rows[i].cells[0].style.backgroundColor	= "#fde6d0";
							parent.patient_id_locator.frmPatientIDLocator.patient_id_locator.value="";
							parent.patient_id_locator.frmPatientIDLocator.patient_id_locator.value="Enter Patient ID To "
							return false;
						}
					}
				}
			}
		}
	}
}

function checkScope(obj) {
	//Added for MMS-DM-CRF-0228 start
	var formObj = "";
	var disp_locn_catg = parent.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.disp_locn_catg.value;
	if(disp_locn_catg=="O"){
		formObj=document.frmDispMedicationQueryCriteria;
	}
	else{
		formObj=document.frmDispMedicationQueryCriteriaIP;
	}
	var ph_print_prescription = formObj.ph_print_prescription.value;	//Added for MMS-DM-CRF-0228 end;
	
	if(obj.value=="R"){
		document.frmDispMedicationQueryCriteria.order_date_from.value="";
	}
	else {
		document.frmDispMedicationQueryCriteria.order_date_from.value=document.frmDispMedicationQueryCriteria.ordering_date.value;
	}
	if(obj.value=="D"){
         document.frmDispMedicationQueryCriteria.ord_loc_type.selectedIndex=2;
	}
	else if(obj.value==""){ // This condition added for KAUH-SCF-0065 [IN034846]
		document.frmDispMedicationQueryCriteria.ord_loc_type.selectedIndex=0;
	}
	else{
		document.frmDispMedicationQueryCriteria.ord_loc_type.selectedIndex=1;
	}
    if(obj.value=="PD"){
         document.frmDispMedicationQueryCriteria.ord_loc_type.selectedIndex=0;
		 document.frmDispMedicationQueryCriteria.order_by.selectedIndex=1;
		 document.frmDispMedicationQueryCriteria.order_by.disabled=false;
	}
	else {
		/*if(obj.value!="D"){		// commented for KAUH-SCF-0065 [IN034846]
		 document.frmDispMedicationQueryCriteria.ord_loc_type.selectedIndex=1;
		} */
		 document.frmDispMedicationQueryCriteria.order_by.selectedIndex=0;
		 document.frmDispMedicationQueryCriteria.order_by.disabled=true;
	}
	if(obj.value=="B") {
		//document.getElementById("dateLegend").innerHTML = "Collection Date From";
		document.getElementById('dateLegend').innerHTML = getLabel("ePH.CollectionDateFrom.label","PH"); 
	}
	else {
		//document.getElementById("dateLegend").innerHTML = "Order Date From";//commneted for Bru-HIMS-CRF-418[IN045564]
		document.getElementById('dateLegend').innerHTML = getLabel("Common.Period.label","Common")+" "+getLabel("Common.from.label","Common"); //added for Bru-HIMS-CRF-418[IN045564
		document.frmDispMedicationQueryCriteria.order_date_from.value=document.frmDispMedicationQueryCriteria.ordering_date.value;
		//document.frmDispMedicationQueryCriteria.order_date_to.value=document.frmDispMedicationQueryCriteria.ordering_date.value;
		document.frmDispMedicationQueryCriteria.order_date_to.value=document.frmDispMedicationQueryCriteria.order_date_to.value;//changed ordering_date to order_date_to for incident no ML-BRU-SCF-0180
	}
}
//added on 18/04/2004 for calling personal detail
async function callFillPersonDetail(frmObj){		
	var dialogHeight	= "05" ;
	var dialogWidth		= "38";
	var dialogTop		= "350" ;
	var dialogLeft		= "350" ;
	var center			= "1" ;
	var status			="no";
	var features	= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";	
	retVal =await window.showModalDialog("../../ePH/jsp/DispMedicationFillPersonDetail.jsp?bean_id="+frmObj.bean_id+"&bean_name="+frmObj.bean_name,arguments,features);
	return retVal;
}

function callFillPersonInsert(formObj){	
	var fields  = new Array() ;
	var names   = new Array() ;
	fields[0]   = formObj.fill_person_name ;				
	names[0]    = "Filled Person Name" ;				

	if(checkFlds( fields, names)){					
		var xmlStr ="<root><SEARCH ";
		xmlStr+= "fill_person_name=\"" + formObj.fill_person_name.value + "\" " ;				
		xmlStr+= "bean_id =\"" + formObj.bean_id.value + "\" " ;
		xmlStr+= "bean_name=\"" + formObj.bean_name.value + "\" " ;
		xmlStr +=" /></root>";
		var temp_jsp="DispMedicationValidation.jsp?func_mode=fill_person";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");					
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;					
		eval(responseText);
		callClose("OK");
	}
}

function callClose(retval) {
	window.returnValue=retval;
	window.close();
	
}

//code added..
function checkSysDate(sysdate,next_collection_date){
	
	if(!doDateCheckAlert(sysdate,next_collection_date)){
		alert(getMessage("NEXT_COLL_GRT_SYSDATE","PH"));
		//next_collection_date.focus(); //Commented to avaoid scrpt error
		next_collection_date.value="";
		return false;
	}
	/*else{
		if(!doDateCheckAlert(next_collection_date,pres_date)){
			alert(getMessage("NEXT_COLL_NOT_BLANK"));
			next_collection_date.focus();
			return false;
		}
	}*/
	return true;
}

function setOrOrder(frmObj){
   	var language_id			=	frmObj.Language_id.value;
	order_id				=	frmObj.order_id.value;
	order_line_no			=	frmObj.order_line_no.value;
	bean_id					=	frmObj.bean_id_2.value;
	bean_name				=	frmObj.bean_name_2.value;
	curr_stage				=   frmObj.curr_stage.value;
	
    // flag   C--->current facility
	// flag   E-->External facility
	flag=current_facility;
	var bmsReasonCode="";
    if(flag=='C'){
		next_collection_date=	frmObj.next_collection_date1.value;//next collection_date
        next_collection_date_ref=frmObj.next_collection_date1;
		bmsReasonCode=frmObj.CurbmsReason.value;
	}
	else if(flag=='E'){
		 next_collection_date=	frmObj.next_collectiondate.value ;//next collection_date
		 next_collection_date_ref=frmObj.next_collectiondate;
		bmsReasonCode=frmObj.ExtbmsReason.value;
	}
	//bmsReasonCode=frmObj.bmsReason.value;

	visible					=   frmObj.visible.value;
	var referral_facility	="";

    if(frmObj.referral_location_desc.disabled==false){
	    referral_facility	=	frmObj.referral_location.value;//other_facility_id
	}
	else{
	    referral_facility	=	frmObj.referral_facility.value ;//facility_name
	}

	var referral_remarks	=	frmObj.referral_remarks.value;//remarks
	var practioner_id		=	frmObj.practioner_id.value;//reffered by
	
	disp_no		=	frmObj.disp_no.value;
	srl_no		=	frmObj.srl_no.value;

	var  disp_locn      =	"";
	if(frmObj.disp_locations!=null)
	    var   disp_location     =	frmObj.disp_locations.value;//next collection from
	if(checkSysDate(frmObj.sysdate,next_collection_date_ref)){
		var curr_facility;
		var fields  = new Array() ;
		var names   = new Array() ;

		if(frmObj.curr_facility[0].checked==true)
			curr_facility=frmObj.curr_facility[0].value;
		else
			curr_facility=frmObj.curr_facility[1].value;			

		if(visible == "true"){
			if(curr_facility=='C'){
				fields[0]   = frmObj.next_collection_date1 ;	
				names[0]    = getLabel("ePH.NextCollectionDate.label","PH");					
				
				fields[1]   = frmObj.disp_locations ;	
				names[1]    = getLabel("ePH.NextCollectionFrom.label","PH"); 
			}
			else if(curr_facility=='E'){
				if(frmObj.referral_location_desc.disabled==false){ 
					fields[0]   = frmObj.referral_location ;	
					names[0]    = getLabel("Common.FacilityName.label","Common");
                }
				else{
					fields[0]   = frmObj.referral_facility ;	
					names[0]    = getLabel("Common.FacilityName.label","Common");
				}
				fields[1]   = frmObj.next_collectiondate ;	
				names[1]    = getLabel("ePH.NextCollectionDate.label","PH");
				fields[2]   = frmObj.referral_remarks ;	
				names[2]    = getLabel("Common.remarks.label","Common");
				fields[3]   = frmObj.practioner_name ;	
				names[3]    = getLabel("ePH.ReferedBy.label","PH");
			}
			var validateDate = true;
			if(curr_stage == 'D' || curr_stage =='AS'){
				validateDate =  checkFldsForRecord( fields, names);
			}

			if(validateDate){					
				 var xmlStr ="<root><SEARCH ";
				
				xmlStr+= "order_id =\"" + order_id + "\" " ;
				xmlStr+= "order_line_no =\"" + order_line_no + "\" " ;
				xmlStr+= "disp_no =\"" + disp_no + "\" " ;
				xmlStr+= "srl_no =\"" + srl_no + "\" " ;					
				xmlStr+= "bean_id =\"" + bean_id + "\" " ;
				xmlStr+= "bean_name=\"" + bean_name + "\" " ;	
				xmlStr+= "next_collection_date=\"" +convertDate(next_collection_date,"DMY",language_id,"en")  + "\" " ;
				xmlStr+= "bmsReasonCode=\"" +bmsReasonCode  + "\" " ;
				xmlStr+= "flag=\"" + flag + "\" " ;	
				xmlStr+= "curr_stage=\""+curr_stage+ "\" " ;

				if(flag=='C'){					 
					 xmlStr+= "disp_location=\"" + disp_location + "\" " ;
				}
				else if(flag=='E'){
					 xmlStr+= "referral_facility=\"" + referral_facility + "\" " ;
					 xmlStr+= "referral_remarks=\"" + referral_remarks + "\" " ;
					 xmlStr+= "practioner_id=\"" + practioner_id + "\" " ;
				}
				xmlStr +=" /></root>";
				
				var temp_jsp="DispMedicationValidation.jsp?func_mode=orOrder";
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest() ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST",temp_jsp,false);
				xmlHttp.send(xmlDoc);
				responseText=xmlHttp.responseText ;	
				eval(responseText);
			
				/*if(type=="OK"){
					printOnlineDispense(frmObj);					 
				}
				else if(type=="Cancel")
					parent.window.close();*/
				if(document.DispMedicationPrintDialog != undefined && parent.printSelectFrame.document.getElementById("printReport").style.display != "none")//added document.DispMedicationPrintDialog.print_report for MO-GN-5434 [IN043669]
				   document.DispMedicationPrintDialog.document.getElementById("print_report").click();
				else if(parent.printSelectFrame.document.getElementById("printReport").style.display != "none")//added if document.DispMedicationPrintDialog.print_report for MO-GN-5434 [IN043669]
					parent.printSelectFrame.document.DispMedicationPrintDialog.document.getElementById("print_report").click();
			}
			else{
					parent.window.returnValue='false';
					return false;
			}
		}
		else{
			//alert("type" + type);
			/*if(type=="OK")
				printOnlineDispense(frmObj);
			else if(type=="Cancel")
				parent.window.close();*/
		}
	}
	else{
	
		parent.window.returnValue='false';
	}
}

function clickRefresh() {
	document.frmDispMedicationQueryCriteriaButtons.btnSearch.click();
}

function populateToken(formObj, called_from){
	formObj.btn_next_token.disabled	=	false;
	if(parent.f_query_criteria_buttons.document.frmDispMedicationQueryCriteriaButtons != undefined)
		parent.f_query_criteria_buttons.document.frmDispMedicationQueryCriteriaButtons.btnSearch.style.disabled	=false;
	if(called_from !='btnNextToken')
		formObj.token_no.value = ""; //Added for [IN:037465]

	//var formObj		=	document.frmDispMedicationQueryCriteriaTokenInfo;
	var bean_id		= formObj.bean_id.value ;
	var bean_name	= formObj.bean_name.value ;
	var token_series= formObj.token_series.value;
	var token_no	= formObj.token_no.value;
	var language_id = formObj.language_id.value;
	var queue_date  = formObj.queue_date.value;
	queue_date	    = convertDate(queue_date,"DMY",language_id,"en");
	if(token_series=='')
		return false;
	if(token_series=='*A')
		token_series="";
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr += " bean_id=\"" + bean_id + "\"";
	xmlStr += " bean_name=\"" + bean_name + "\"";
	xmlStr += " token_series=\"" + token_series + "\"";
	xmlStr += " token_no=\"" + token_no + "\"";	
	xmlStr += " queue_date=\"" + queue_date + "\"";			
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=populateToken", false ) ;
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);		
}

function validateToken(formObj){
	var bean_id		= formObj.bean_id.value ;
	var bean_name	= formObj.bean_name.value ;
	var token_series= formObj.token_series.value;
	var token_no	= formObj.token_no.value;
	var language_id = formObj.language_id.value;
	var queue_date  = formObj.queue_date.value;
	if(token_series=='*A') //Added for HSA-CRF-0136 [IN:048412]
		token_series = "";
	queue_date	    = convertDate(queue_date,"DMY",language_id,"en");

	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr += " bean_id=\"" + bean_id + "\"";
	xmlStr += " bean_name=\"" + bean_name + "\"";
	xmlStr += " token_series=\"" + token_series + "\"";
	xmlStr += " token_no=\"" + token_no + "\"";	
	xmlStr += " queue_date=\"" + queue_date + "\"";
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=validateToken", false ) ;
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);		
}

function assignToken(token) {
	var sys_date= convertDate(document.frmDispMedicationQueryCriteriaTokenInfo.sys_date.value,"DMY","en",document.frmDispMedicationQueryCriteriaTokenInfo.language_id.value);
	if(token=="") {
		if(document.frmDispMedicationQueryCriteriaTokenInfo!=null) {
			document.frmDispMedicationQueryCriteriaTokenInfo.token_no.value	="";
			alert(getMessage("NO_MORE_TOKENS","PH"));
            //document.frmDispMedicationQueryCriteriaTokenInfo.queue_date.value	=sys_date;
			//document.frmDispMedicationQueryCriteriaTokenInfo.btn_next_token.click();
			parent.f_query_criteria_buttons.document.frmDispMedicationQueryCriteriaButtons.btnSearch.click();
		} 
		else {
			parent.f_query_criteria_token_info.document.frmDispMedicationQueryCriteriaTokenInfo.token_no.value="";
			alert(getMessage("NO_MORE_TOKENS","PH"));
            //document.frmDispMedicationQueryCriteriaTokenInfo.queue_date.value	=sys_date;
			//document.frmDispMedicationQueryCriteriaTokenInfo.btn_next_token.click();
			parent.f_query_criteria_buttons.document.frmDispMedicationQueryCriteriaButtons.btnSearch.click();
		}
	} 
	else {
		if(document.frmDispMedicationQueryCriteriaTokenInfo.token_no.value==token ) {
			alert(getMessage("NO_MORE_TOKENS","PH"));
            //document.frmDispMedicationQueryCriteriaTokenInfo.queue_date.value	=sys_date;
			//document.frmDispMedicationQueryCriteriaTokenInfo.btn_next_token.click();
			parent.f_query_criteria_buttons.document.frmDispMedicationQueryCriteriaButtons.btnSearch.click();
		} 
		else {
			document.frmDispMedicationQueryCriteriaTokenInfo.token_no.value=token;
		}
	}
}

function validateResult(result) {
	if(result=="N") {
		if(parent.f_query_criteria_token_info.document.frmDispMedicationQueryCriteriaTokenInfo.token_no.value != ''){
			if(parent.f_query_criteria_token_info.document.frmDispMedicationQueryCriteriaTokenInfo.token_no.disabled==false) {
				alert(getMessage("INVALID_TOKEN","PH"));
			} 
			else {
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
			}
		}
	} 
	else {
		token_valid_flag	=	true;
	}
}

//code added for calling Profile...0n 28/5/2004

async function callPatientProfile(patient_id){
	var dialogHeight= "29" ;//"29"
	var dialogWidth	= "42" ;//"42"
	var dialogTop	= "70";
	var dialogLeft	= "40";//"85"
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+" ;dialogLeft="+dialogLeft+";scroll=no; status:no ";
	
	//window.open("../../eCA/jsp/PatientProfileMain.jsp?<%=request.getQueryString()%>",arguments,features);	
	var retval = await window.showModalDialog("../../eCA/jsp/PatientProfileMain.jsp?patient_id="+patient_id,arguments,features);	
}

//code added for calling Clinical event on 28/5/2004
async function showEncounterDialog(patient_id,encounter_id,facilityId){
	var dialogHeight	=	"35";
	var dialogWidth		=	"70";
	var action_url		=	'../../eCA/jsp/EncounterInDialog.jsp?patient_id='+patient_id+'&encounter_id='+encounter_id+'&from_date='+""+'&to_date='+""+'&facilityId='+facilityId;
	var arguments		=	"" ;
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no ;status:no";
	retVal				=await	window.showModalDialog(action_url,arguments,features);
}

function populateFillDate(obj){
	if(obj.value=="R"){
		document.frmDispMedicationQueryCriteriaIP.lbl_incremental.style.display="none";
		document.frmDispMedicationQueryCriteriaIP.lbl_routine.style='display';
	}
	else if(obj.value=="I"){
		document.frmDispMedicationQueryCriteriaIP.lbl_routine.style.display    ="none";
		document.frmDispMedicationQueryCriteriaIP.lbl_incremental.style="display";
	}
	var formObj  = document.frmDispMedicationQueryCriteriaIP;
	var bean_id	 = formObj.bean_id.value ;
	var bean_name	= formObj.bean_name.value ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr += " fill_type=\"" + obj.value + "\"";	
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=populateFillDate", false ) ;
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);

}
function assignFillDate(fill_date){
	
	var formObj = document.frmDispMedicationQueryCriteriaIP;
	var language_id	    = formObj.Language_id1.value;
	var fill_date1=convertDate(fill_date,"DMY","en",language_id);
	
	var element = document.createElement('OPTION') ;
	element.value		=  (fill_date) ;
	element.text		=  (fill_date) ;
	formObj.fill_date_time.add(element);
}

function clearFillDate(){
	var formObj = document.frmDispMedicationQueryCriteriaIP;
	var len		= document.frmDispMedicationQueryCriteriaIP.fill_date_time.length;
	for(var i=0;i<len;i++) {
		formObj.fill_date_time.remove("fill_date_time") ;
	}
}

function defaultDispLevel(frmObj,obj) {
	//if(obj.value=="IVAA"||obj.value=="IVAD" || obj.value=="IVWA" || obj.value=="IVID"||obj.value=="IVIA") {
   if(obj.value=="IVAA" || obj.value=="IVIA"||obj.value=="TA"||obj.value=="CA"||obj.value=="CO") {
		frmObj.disp_level.value	=	"O";
		frmObj.disp_level.selectedindex=0;
		frmObj.disp_level.disabled	=	true;
	} else {
		frmObj.disp_level.value	=	frmObj.dflt_disp_level.value;
		frmObj.disp_level.disabled	=	false;
	}
}

function enableCriteria() {
	if(parent.parent.parent.document.f_query_criteria_token_info.frmDispMedicationQueryCriteriaTokenInfo!=null) {
		token_form	=	parent.parent.parent.document.f_query_criteria_token_info.frmDispMedicationQueryCriteriaTokenInfo;
		token_form.token_no.disabled		=	false;
		token_form.token_series.disabled	=	false;
		token_form.queue_date.disabled	    =	false;
		token_form.patient_id.disabled	    =	false;
		token_form.btnPatientID.disabled	    =	false;
		token_form.patient_id.value = "";
		parent.parent.parent.document.f_query_criteria_token_info.document.getElementById("Calendar").disabled	    =	false;
	}
}

function addDrug1(formObjCalSec){
	
	var formObjOrderDtls= parent.ws_order_details_frame.ws_order_details.frmDispMedicationWSOrderDetails;
	var bean_id		= formObjCalSec.bean_id.value ;
	var bean_name	= formObjCalSec.bean_name.value ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	= " <root><SEARCH " ;
	xmlStr += " order_line_no =\""+formObjCalSec.order_line_no.value+"\"";
	xmlStr += " physical_form =\""+formObjCalSec.drug_form.value+"\"";
	for(i=0; i<6; i++)	{
		if(i==0){
		   formObjCalSec.order_line_no.value=formObjCalSec.order_line_no.value;
		}
		if (i==1){
			if(formObjCalSec.drug_form.value=="P"){
				xmlStr += " rf_id =\""+formObjCalSec.rf_id.value+"\"";
			}
			xmlStr += " drug_code =\""+formObjCalSec.drug_code.value+"\"";
		}
		if (i==2){
			if(formObjCalSec.drug_form.value=="P"){
				xmlStr += " fluid_qty_as_per_order =\""+formObjCalSec.fluid_qty_as_per_order.value+"\"";
			}
			xmlStr += " drug_qty_as_per_order =\""+formObjCalSec.drug_qty_as_per_order.value+"\"";
		}
		if (i==3){
			if(formObjCalSec.drug_form.value=="P"){
				xmlStr += " fluid_qty_preparation =\""+formObjCalSec.fluid_qty_preparation.value+"\"";
			}
			
			xmlStr += " drug_qty_preparation =\""+formObjCalSec.drug_qty_preparation.value+"\"";
		}
		if (i==4){
			if(formObjCalSec.drug_form.value=="P"){
				xmlStr += " fluid_qty_spillage =\""+formObjCalSec.fluid_qty_spillage.value+"\"";
			}
			xmlStr += " drug_qty_spillage =\""+formObjCalSec.drug_qty_spillage.value+"\"";
		}
		if (i==5){
			if(formObjCalSec.drug_form.value=="P"){
				xmlStr += " fluid_qty_drawn =\""+formObjCalSec.lbl_stock_qty.innerText+"\"";
			}
			xmlStr += " drug_qty_drawn =\""+formObjCalSec.drug_qty_drawn.value+"\"";
		}
	}
	xmlStr += " /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=ws_add_drug_details",false);
	xmlHttp.send( xmlDoc ) ;
	//parent.parent.ws_display_sec.location.href="../../ePH/jsp/DispMedicationWSDisplaySec.jsp?tot_num_of_drugs="+formObjOrderDtls.tot_num_of_drugs.value;
}
/*====== new malasiya enhancement  coded on 11/23/2004  STARTS HERE========*/
async function searchPractionerName(obj){

	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

	var formObj = document.frmDispMedicationDeliveryDetails;
	argumentArray[0]   = formObj.sql_ph_disp_locn_select10.value;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = formObj.practioner_name.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ; 	
	retVal = await CommonLookup( getLabel("Common.practitioner.label","Common"), argumentArray );	
	formObj.practioner_name.value = "" ;
	formObj.practioner_id.value = "";
	var str =unescape(retVal);
	var arr = str.split(",");
	if(retVal != null && retVal != "" )  {
		formObj.practioner_name.value = arr[1] ;
		formObj.practioner_id.value = arr[0];
		obj.disabled	=	true;
	}
}
// Practitioner lookup for referred by details
async function searchPractionerRefeffed(obj){

	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

	var formObj = document.referralDetailForm;
	argumentArray[0]   = formObj.SQL_PH_DISP_PRACT_REFERRAL_SELECT.value;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = formObj.practioner_name.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ; 	
	retVal = await CommonLookup( getLabel("Common.practitioner.label","Common"), argumentArray );	
	formObj.practioner_name.value = "" ;
	formObj.practioner_id.value = "";
	var str =unescape(retVal);
	var arr = str.split(",");
	if(retVal != undefined && retVal != "" )  {
		formObj.practioner_name.value = arr[1] ;
		formObj.practioner_id.value = arr[0];
		obj.disabled	=	true;
	}
}

function makemand(obj){
	var formObj = document.frmDispMedicationDeliveryDetails;
	
	formObj.practioner_name.value="";
	formObj.practioner_id.value="";
	formObj.practioner_search.disabled=false;

}

function getFillProc(){
	var formObj			= document.frmDispMedicationQueryCriteriaIP;
	var language_id	    = formObj.Language_id.value;
	var added_date  = formObj.fill_proc_date; 
	//var sys_date	= formObj.sys_date.value;
	var proc_type	=  formObj.fill_proc_type.value;

	//alert(formObj.OrderingFacility.value);
	/*if(ChkDate(added_date) == false) {
	if(ChkDate(added_date) == false) {
		alert(getMessage("INVALID_DATE_TIME","PH")); 
		formObj.fill_proc_date.focus(); 
	}
	else{
			*/ //Commented for ICN 31454
		/*if(!doSystemDateCheck(sys_date,added_date)){
				//formObj.fill_proc_date.value = "";
				formObj.fill_proc_date.focus();
		}else{*/
			added_date = added_date.value;
			var bean_id		= "DispMedicationBean";
			var bean_name	= "ePH.DispMedicationBean";
			//var xmlDoc  = new ActiveXObject( "Microsoft.XMLDom" ) ;
			var xmlHttp = new XMLHttpRequest() ;
			var xmlStr ="<root><SEARCH ";
			xmlStr += " added_date=\"" + convertDate(added_date,"DMY",language_id,"en") + "\"";
			xmlStr += " proc_type=\"" + proc_type + "\"";			
			xmlStr += " OrderingFacility=\"" + formObj.OrderingFacility.value + "\"";			
			xmlStr += " bean_id=\""+bean_id+"\"";
			xmlStr += " bean_name=\""+bean_name+"\"";
			xmlStr +=" /></root>";
			var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=getFillProc",false);
			xmlHttp.send( xmlDoc ) ;
			//alert(xmlHttp.responseText);
			eval(xmlHttp.responseText);
		//}
	//}//Commented for ICN 31454
}

function doSystemDateCheck(sys_date,added_date){

	var sysarray  = "";
	var addedarray  = "";
	
	if(sys_date.length > 0 && added_date.length > 0 ) {
		sysarray = sys_date.split("/");
		addedarray = added_date.split("/");
		var fromdt = new Date(sysarray[2],sysarray[1]-1,sysarray[0]);
		var todt = new Date(addedarray[2],addedarray[1]-1,addedarray[0]);
		if(Date.parse(fromdt) < Date.parse(todt)) {
			return false;
		} 
		else if(Date.parse(fromdt) >= Date.parse(todt)){
			return true;
		}
    }
}

// To populate the Nursing units for Disp Medication Deliver Fill list
function getNursingUnit(obj){
	
	var formObj			= document.frmDispMedicationQueryCriteriaIP;
	var language_id	    = formObj.Language_id.value;
	var added_date		= convertDate(formObj.fill_proc_date.value,"DMY",language_id,"en");
	var ordering_facility_id = formObj.OrderingFacility.options[formObj.OrderingFacility.selectedIndex].value;
	var fill_proc_id = formObj.fill_proc_id.value;
	var facility_id  = formObj.facility_id.value;
	var disp_locn_code  = formObj.disp_locn_code.value;
	var p_user_name  = formObj.p_user_name.value;

	var bean_id		= "DispMedicationBean";
	var bean_name	= "ePH.DispMedicationBean";
	//var xmlDoc  = new ActiveXObject( "Microsoft.XMLDom" ) ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";

	xmlStr += " added_date=\"" + added_date + "\"";
	xmlStr += " fill_proc_id=\"" + fill_proc_id + "\"";
	xmlStr += " facility_id=\"" + facility_id + "\"";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr +=" /></root>";
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","DispMedicationValidate.jsp?bean_id="+bean_id+"&p_user_name="+p_user_name+"&disp_locn_code="+disp_locn_code+"&bean_name="+bean_name+"&identity=getNursingUnit"+"&added_date="+added_date+"&fill_proc_id="+fill_proc_id+"&facility_id="+ordering_facility_id,false);
	xmlHttp.send( xmlDoc ) ;
//	alert(xmlHttp.responseText);
	eval(xmlHttp.responseText);
}
function Unlock_Delivery_Status_yn(lock_status,user_id1,locked_date_time1){
	if(lock_status=='1'){
		user_id=user_id1;
		locked_date_time=locked_date_time1;
		parent.f_query_criteria.document.frmDispMedicationQueryCriteriaIP.lock_id.style.visibility="visible";
		parent.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.btnSearch.disabled	=	true;
	}
	else if(lock_status=='0'){
		parent.f_query_criteria.document.frmDispMedicationQueryCriteriaIP.lock_id.style.visibility="hidden";
		parent.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.btnSearch.disabled	=	false;
	}	  
}

function Icon_unlock_status_return(Icon_unlock,Icon_unlock_status){
	if(Icon_unlock_status=='Y'){
		if(Icon_unlock=='N'){
			parent.f_query_criteria.document.frmDispMedicationQueryCriteriaIP.lock_id.style.visibility="hidden";
			parent.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.btnSearch.disabled	=	false;
		}
		else if(Icon_unlock=='Y'){
			parent.f_query_criteria.document.frmDispMedicationQueryCriteriaIP.lock_id.style.visibility="visible";
			parent.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.btnSearch.disabled	=	true;
		}
	}
}

function showToolTipLockStatus_delivery(obj){
	//user_id="suri";
	//locked_date_time="";
	obj.title=getLabel("Common.username.label",'Common')+" : "+user_id +"\n"+getLabel("Common.Date/Time.label",'Common')+" : "+locked_date_time;
}

function addOption(code, desc, obj) {
	var opt	= eval(document.createElement('OPTION'));
	opt.value =	trimString(code);
	opt.text = desc;
	obj.add(opt);
}

function clearData(obj) {
	obj = eval(obj);
	var len = obj.length;
	for (var i=0; i<=len; i++) {
		obj.remove("");
	}
	var opt	= document.createElement('OPTION');
	opt.value =	"";
	//opt.text = "---- Select ----";
	opt.text = " --- "+getLabel("Common.defaultSelect.label",'Common')+" --- ";
	obj.add(opt);
}

function changeCursor(obj) {
	obj.style.cursor = "pointer";
}

function enableImg(obj){
	
	if(obj.checked == true){
		document.DispMedicationPrintDialog.rfrlDtlsImg.style.visibility = "visible";
		document.DispMedicationPrintDialog.rfr_anc.style.visibility = "visible";
	}
	else if(obj.checked == false){ 
		document.DispMedicationPrintDialog.rfrlDtlsImg.style.visibility = "hidden";
		document.DispMedicationPrintDialog.rfr_anc.style.visibility = "hidden";
	}
}

async function referralLetterDetails(patient_id,order_id,order_line_no){

	var dialogHeight= "22" ;
	var dialogWidth	= "43" ;
	var dialogTop = "195" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	
	retVal =await window.showModalDialog("../../ePH/jsp/DispMedicationRefrlDetail.jsp?patient_id="+patient_id+"&order_id="+order_id+"&order_line_no="+order_line_no,arguments,features);
	
	if(retVal == "YES" ){
		document.DispMedicationPrintDialog.ref_letter.checked=true;
		document.DispMedicationPrintDialog.ref_letter.disabled=true;
		document.DispMedicationPrintDialog.ref_lab.style.visibility = "visible";
		document.DispMedicationPrintDialog.rfrlDtlsImg.style.visibility = "hidden";
		document.DispMedicationPrintDialog.rfr_anc.style.visibility = "hidden";
		document.DispMedicationPrintDialog.rec_ref1.value="Record Referral";
	}
    else if(retVal!=null ||retVal!=undefined){ 
		//document.DispMedicationPrintDialog.ref_letter.checked=false;
		//document.DispMedicationPrintDialog.rfrlDtlsImg.style.visibility = "hidden";
		//document.DispMedicationPrintDialog.rfr_anc.style.visibility = "hidden";
		referralLetterDetails(patient_id,order_id,order_line_no);
	 }
}

function referralyn(obj,order_id){
	var fields  = new Array() ;
	var names   = new Array() ;
	var ref_facility_id=obj.referral_facility.value;
	var ref_location=obj.referral_location.value;
	var ref_remarks=obj.referral_remarks.value;
	
	if(ref_facility_id ==""){   
		alert(getMessage("REF_FCTY_CANT_BLANK","PH"));
		obj.referral_facility.focus();
	}
	else if(ref_location==""){
		alert(getMessage("REF_LCN_CANT_BLANK","PH"));
		obj.referral_location.focus();
		
	}
	else if(ref_remarks==""){
		alert(getMessage("REF_REMRKS_CANT_BLANK","PH"));
		obj.referral_remarks.focus();
	}
	else{
		var bean_id		= "DispMedicationBean";
		var bean_name	= "ePH.DispMedicationBean";
		//var xmlDoc  = new ActiveXObject( "Microsoft.XMLDom" ) ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr += " ref_facility_id=\"" + ref_facility_id + "\"";
		xmlStr += " ref_location=\"" + ref_location + "\"";
		xmlStr += " ref_remarks=\"" + ref_remarks + "\"";
		xmlStr += " order_id=\"" + order_id + "\"";
		xmlStr += " bean_id=\""+bean_id+"\"";
		xmlStr += " bean_name=\""+bean_name+"\"";
		xmlStr +=" /></root>";
		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			
		xmlHttp.open("POST","DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=refApply"+"&ref_facility_id="+ref_facility_id+"&ref_location="+ref_location+"&ref_remarks="+ref_remarks+"&order_id="+order_id,false);
		xmlHttp.send( xmlDoc ) ;
		eval(xmlHttp.responseText);
/*		parent.window.returnValue="YES";
		parent.window.close();*/ 
		parent.parent.document.getElementById('dialog-body').contentWindow.returnValue = "YES"; 
		parent.parent.document.getElementById('dialog_tag').close(); 
	}
}
 
function refynstatus(obj,order_id,order_line_num){   
	if(obj.checked == true){       
		var bean_id		= "DispMedicationBean";
		var bean_name	= "ePH.DispMedicationBean";
		//var xmlDoc  = new ActiveXObject( "Microsoft.XMLDom" ) ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr += " order_id=\"" + order_id + "\"";
		xmlStr += " order_line_num=\"" + order_line_num + "\"";
		xmlStr += " bean_id=\""+bean_id+"\"";
		xmlStr += " bean_name=\""+bean_name+"\"";
		xmlStr +=" /></root>";
		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=refynstatus"+"&order_id="+order_id+"&order_line_num="+order_line_num,false);
		xmlHttp.send( xmlDoc ) ;
		eval(xmlHttp.responseText);
	}
}
function validate(){
	parent.window.returnValue='OK';
	parent.window.close();
	var bean_id		= "DispMedicationBean";
	var bean_name	= "ePH.DispMedicationBean";
	//var xmlDoc  = new ActiveXObject( "Microsoft.XMLDom" ) ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr +=" /></root>";
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=refcancel",false);
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);
	parent.window.returnValue='OK';
}

function deliverManufactureLabel(order_id,ord_type){

}

/*====ends here===================*/
function callfacillity(obj){
	
	var cuu_facility=document.DispMedicationPrintDialog.curr_facility_table;
	var extr_facility= document.DispMedicationPrintDialog.extr_facility_table;
	var trCurBMSReason=document.DispMedicationPrintDialog.trCurBMSReason;
	var trCurBMSReasonVisibility=document.DispMedicationPrintDialog.curBMSReasonVisibility.value;
	var trExtBMSReason=document.DispMedicationPrintDialog.trExtBMSReason;
	var trExtBMSReasonVisibility=document.DispMedicationPrintDialog.extBMSReasonVisibility.value;
	current_facility=obj.value;
	if(obj.value=='C'){
		parent.document.body.rows = "28,60,5,0";
		cuu_facility.style='display';
		cuu_facility.style.visibility='visible';
		trCurBMSReason.style.visibility=trCurBMSReasonVisibility;
		extr_facility.style.display='none';
		extr_facility.style.visibility='hidden';
		trExtBMSReason.style.visibility='hidden';
		extr_facility_btn_table.style='display';
		extr_facility_btn_table.style.visibility='visible';
		document.DispMedicationPrintDialog.print_extr_pres.checked=false;
		document.DispMedicationPrintDialog.print_extr_pres.value='N';
	}
	else if(obj.value=='E'){
		parent.document.body.rows = "36,60,5,0";
		extr_facility.style='display';
		extr_facility.style.visibility='visible';
		cuu_facility.style.display='none';
		cuu_facility.style.visibility='hidden';
		trCurBMSReason.style.visibility='hidden';
		extr_facility_btn_table.style='display';
		extr_facility_btn_table.style.visibility='visible';
		trExtBMSReason.style.visibility=trExtBMSReasonVisibility;
		document.DispMedicationPrintDialog.print_extr_pres.checked=true;
		document.DispMedicationPrintDialog.print_extr_pres.value='Y';
	}
}

function calltable(str){
	
	var print_report=document.DispMedicationPrintDialog.print_report_table;
	var bal_med_dtl= document.DispMedicationPrintDialog.Bal_Med_table;
	var cuu_facility=document.DispMedicationPrintDialog.curr_facility_table;
	var trCurBMSReason=document.DispMedicationPrintDialog.trCurBMSReason;
	var trCurBMSReasonVisibility=document.DispMedicationPrintDialog.curBMSReasonVisibility.value;
	var extr_facility= document.DispMedicationPrintDialog.extr_facility_table;
	var extr_facility_btn_table= document.DispMedicationPrintDialog.extr_facility_btn_table;
	var trExtBMSReason=document.DispMedicationPrintDialog.trExtBMSReason;
	var trExtBMSReasonVisibility=document.DispMedicationPrintDialog.extBMSReasonVisibility.value;
	var iRowCount=document.DispMedicationPrintDialog.iRowCount.value;
	if(str=='print_report') {
		parent.document.body.rows = iRowCount+",60,5,0";
		print_report.style='display';
		print_report.style.visibility='visible';
		bal_med_dtl.style.display='none';
		bal_med_dtl.style.visibility='hidden';
		cuu_facility.style.display='none';
		cuu_facility.style.visibility='hidden';
		trCurBMSReason.style.visibility='hidden';
		extr_facility.style.display='none';
		extr_facility.style.visibility='hidden';
		trExtBMSReason.style.visibility='hidden';
		extr_facility_btn_table.style.display='none';
		extr_facility_btn_table.style.visibility='hidden';
	}
	else if(str=='bal_med_dtl'){
		parent.document.body.rows = "28,60,5,0";
		if(document.DispMedicationPrintDialog.curr_facility[0].checked){
			document.DispMedicationPrintDialog.curr_facility[0].checked=true;
			cuu_facility.style='display';
			cuu_facility.style.visibility='visible';
			trCurBMSReason.style.visibility=trCurBMSReasonVisibility;
			extr_facility.style.display='none';
			extr_facility.style.visibility='hidden';
			trExtBMSReason.style.visibility='hidden';
		}
		else{
			parent.document.body.rows = "36,60,5,0";
			document.DispMedicationPrintDialog.curr_facility[1].checked =true;
			cuu_facility.style.display='none';
			cuu_facility.style.visibility='hidden';
			trCurBMSReason.style.visibility='hidden';
			extr_facility.style='display';
			extr_facility.style.visibility='visible';
			trExtBMSReason.style.visibility=trExtBMSReasonVisibility;
		}

		bal_med_dtl.style='display';
		bal_med_dtl.style.visibility='visible';
		print_report.style.display='none';
		print_report.style.visibility='hidden';
		//extr_facility.style.display='none';
		// extr_facility.style.visibility='hidden';
		// cuu_facility.style='display';
		// cuu_facility.style.visibility='visible';
		extr_facility_btn_table.style='display';
		extr_facility_btn_table.style.visibility='visible';
	}
}


function changeButtonColor(obj,from_name){

	if(from_name=="PH_BUTTONS"){
		cellref = document.DispMedicationPrintDialog.tab.rows[0].cells
	}
	else if(from_name=="PH_CUSTOM_GROUP"){
		cellref = document.frmDispMedicationPatientIDDisplay.customGroupTable.rows[0].cells
	}
	for(i=0; i<cellref.length; i++)	{
		if(cellref[i].id!="dummy")
			cellref[i].className = 'CAFIRSTSELECTHORZ'
		}
	obj.className = "CASECONDSELECTHORZ"
	currClass ="CASECONDSELECTHORZ";
}

function callOnMouseOver(obj){
	currClass = obj.className ;
	obj.style.cursor='hand';
	obj.className = 'CASECONDSELECTHORZ';
}

function callOnMouseOut(obj){
	obj.className = currClass;
	obj.style.cursor='normal';
}

async function searchPractioner(obj, callFrom){

	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

	var formObj = document.DispMedicationPrintDialog;
	if(callFrom =='ONCHANGE' && formObj.practioner_name.value=='')
		return false;
	
	argumentArray[0]   = formObj.SQL_PH_DISP_PRACT_REFERRAL_SELECT.value;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = formObj.practioner_name.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ; 	
	retVal = await CommonLookup( getLabel("Common.GenericName.label","Common"), argumentArray );
	var ret1=unescape(retVal);
	var arr=ret1.split(",");	
	formObj.practioner_name.value = "" ; //Added for [IN:050775]
	formObj.practioner_id.value = "";//Added for [IN:050775]
	if(retVal != null && retVal != "" )  {
		formObj.practioner_name.value = arr[1] ;
		formObj.practioner_id.value = arr[0];
		//obj.disabled	=	true; commented for[IN:050775]
		//f_query_criteria.document.getElementById("no_of_recs").style.visibility="hidden";
		//f_query_criteria.document.getElementById("tot_recs").style.visibility		 ="hidden";
	}
}

function clear_text(obj,obj1,obj2,obj3){
	if(obj.name="ref_referral_facility"){
		obj1.value="";
		obj3.value="";
		if(obj.value ==null ||obj.value=="")
			obj2.disabled=false;
	}
}

function disable_facility(obj,obj1,obj2,obj3){
	if(obj.name=='referral_facility'&& obj.value!=""&&obj.value!=null){
       obj1.disabled=true;
	   obj2.disabled=true;
	   obj3.selectedIndex = 0;
   	   obj3.disabled=true;
	}
	else{
       obj1.disabled=false;
	   obj2.disabled=false;
   	   obj3.disabled=false;
	}
}
function disable_facility1(obj,obj1){
	
	if(obj.name=='referral_location_desc'&& obj.value!=""&&obj.value!=null){
         obj1.disabled=true;   
	}
	else{
		 obj1.disabled=false;
	}

}
function reset_table(frmobj){
	if(frmobj.curr_facility[0].checked==true)
		curr_facility=frmobj.curr_facility[0].value;
	else
		curr_facility=frmobj.curr_facility[1].value;

	frmobj.reset();	
	if(curr_facility=='C'){
		document.DispMedicationPrintDialog.curr_facility[1].checked =false;
		document.DispMedicationPrintDialog.curr_facility[0].checked =true;
	}
	else{
		document.DispMedicationPrintDialog.curr_facility[0].checked =false;
		document.DispMedicationPrintDialog.curr_facility[1].checked =true;
		document.DispMedicationPrintDialog.ref_referral_facility.disabled=false;
		document.DispMedicationPrintDialog.referral_location_desc.disabled=false;
		document.DispMedicationPrintDialog.referral_facility.disabled=false;
		document.DispMedicationPrintDialog.othr_factySearch.disabled=false;				
	}
}
/*
function CheckAccessRightsDelivery(login_user,patient_id,disp_locn_code,disp_stage,user_id,allow_disp_record_lock_yn){
	
	//alert("hello--->");
	var xmlStr ="<root><SEARCH ";
	xmlStr+= "LOGIN_USER  =\"" + login_user + "\" " ;
	xmlStr+= "PATIENT_ID  =\"" + patient_id + "\" " ;
	xmlStr+= "DISP_LOCN_CODE  =\"" + disp_locn_code + "\" " ;
	xmlStr+= "DISP_STAGE  =\"" + disp_stage + "\" " ;
	xmlStr+= "USER_ID  =\"" + user_id + "\" " ;
	xmlStr+= "ALLOW_DISP_RECORD_LOCK_YN  =\"" + allow_disp_record_lock_yn + "\" " ;
	xmlStr +=" /></root>";
	var temp_jsp="DispMedicationValidation.jsp?func_mode=checkdeliveryStage";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;		
	eval(responseText);

} */

function UnLockRecordDelivery_yn(p_user_name,Unlock_all_records_yn,disp_locn_code){
           
	var formObj = parent.f_query_criteria.document.frmDispMedicationQueryCriteriaIP;
	fill_proc_id1 = formObj.fill_proc_id.options[formObj.fill_proc_id.selectedIndex].value;
	var	fill_proc_id=fill_proc_id1;
	var patient_id_status="";
	var disp_stage='DF';
	var p_delivery_fill_yn='Y';
	var Icon_unlock_status='Y';

	if(Unlock_all_records_yn=='Y'){
		var bean_id		= "DispMedicationBean";
		var bean_name	= "ePH.DispMedicationBean";
		//var xmlDoc  = new ActiveXObject( "Microsoft.XMLDom" ) ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";

		xmlStr += " p_user_name=\"" + p_user_name + "\"";
		xmlStr += " fill_proc_id=\"" + fill_proc_id + "\"";
		xmlStr += " disp_stage=\"" + disp_stage + "\"";
		xmlStr += " patient_id_status=\"" + patient_id_status + "\"";
		xmlStr += " p_delivery_fill_yn=\"" + p_delivery_fill_yn + "\"";
		xmlStr += " Icon_unlock_status=\"" + Icon_unlock_status + "\"";
		xmlStr += " bean_id=\""+bean_id+"\"";
		xmlStr += " bean_name=\""+bean_name+"\"";
		xmlStr +=" /></root>";
		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","DispMedicationValidate.jsp?bean_id="+bean_id+"&p_user_name="+p_user_name+"&disp_locn_code="+disp_locn_code+"&bean_name="+bean_name+"&identity=unlockrecorddelivery_yn"+"&disp_stage="+disp_stage+"&Icon_unlock_status="+Icon_unlock_status+"&fill_proc_id="+fill_proc_id+"&patient_id_status="+patient_id_status+"&p_delivery_fill_yn="+p_delivery_fill_yn,false);
		xmlHttp.send( xmlDoc ) ;
		eval(xmlHttp.responseText);
	}
}

/*
function UnLockRecordDelivery(login_user,patient_id,disp_locn_code,disp_stage,Unlock_all_records_yn){
           
			//alert("Unlock_all_records_yn--->"+Unlock_all_records_yn);
			var patient_id_status='Y';
			if(Unlock_all_records_yn=='Y'){
			var xmlStr ="<root><SEARCH ";
			xmlStr+= "LOGIN_USER  =\"" + login_user + "\" " ;
			xmlStr+= "PATIENT_ID  =\"" + patient_id + "\" " ;
			xmlStr+= "DISP_LOCN_CODE  =\"" + disp_locn_code + "\" " ;
			xmlStr+= "DISP_STAGE  =\"" + disp_stage + "\" " ;
			xmlStr+= "PATIENT_ID_STATUS  =\"" + patient_id_status + "\" " ;
			xmlStr +=" /></root>";
			var temp_jsp="DispMedicationValidation.jsp?func_mode=unlockrecorddelivery";
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST",temp_jsp,false);
			xmlHttp.send(xmlDoc);
			responseText=xmlHttp.responseText ;		
			eval(responseText);	
			}
} */

 /*
function Unlock_status_YN_Delivery(Unlock_status_value_yn)
{
	//alert("before-->"+eval("parent.parent.DispMedicationPatFrame.patient_id_display.frmDispMedicationPatientIDDisplay.lock_status"+j).value)
	if(Unlock_status_value_yn=='N'){
	   //eval("parent.parent.DispMedicationPatFrame.patient_id_display.frmDispMedicationPatientIDDisplay.lock_status"+j).value='0';
	   //alert("after-->"+eval("parent.parent.DispMedicationPatFrame.patient_id_display.frmDispMedicationPatientIDDisplay.lock_status"+j).value)
	  document.frmDispMedicationDeliveryFillList.Logout_gif.style.visibility="hidden";
  }
} */

/*function GetLockMessageStatusDelivery(GetMessageStatus,user_id,login_user,patient_id,disp_locn_code,disp_stage,allow_disp_record_lock_yn)
 {
	//alert("GetMessageStatus-----status--->"+GetMessageStatus);
	if(GetMessageStatus=='1'){
	alert(getMessage("PATIENT_RECORD_IS_OPENED_BY_ANOTHER_USER","PH")+" "+user_id+".  "+getMessage("ACCESS_DENIED","PH"));
	return false;
	}else if(GetMessageStatus=='0'){
	//alert("at 2756---->")
	//alert("patient_name---->"+patient_name)
	LockStatus(user_id,GetMessageStatus,login_user,patient_id,disp_locn_code,disp_stage,allow_disp_record_lock_yn);
	callProcess(patient_id,"P")
	return true; 
	}
} */

function callProcess(id,type) {

var sym_obj;
	if(type=="P") {
		sym_obj	=	document.getElementById('patsym_'+id);
	}  
	else if(type=="O") {
		sym_obj	=	document.getElementById('ordsym_'+id);
	}
	
		if(sym_obj.innerText=="+") {
			sym_obj.innerText="-";
			expandPatient(id,type);
		} 
		else {
			sym_obj.innerText="+";
			collapsePatient(id,type);
		}
}

function expandPatient(patient_id){

	var tot_rec	=	parseInt(document.frmDispMedicationDeliveryFillList.tot_rec.value);
	for(i=0; i<=tot_rec; i++){
		for(var j=0;j<=tot_rec;j++){
			order_row	=	eval(document.getElementById("PAT_"+patient_id+"_"+i+"_"+j));
			if(order_row!=undefined && order_row!=null) {
				order_row.style="display";
			}
		}
	}
}

function collapsePatient(patient_id) {
	var tot_rec	=	parseInt(document.frmDispMedicationDeliveryFillList.tot_rec.value);

	for(i=0; i<tot_rec; i++){
		for(var j=0;j<tot_rec;j++){
			order_row	=	eval(document.getElementById("PAT_"+patient_id+"_"+i+"_"+j));
			if(order_row!=undefined && order_row!=null) {
				order_row.style.display="none";
			}
		}
	}
}

function chkPatientRecords(patient_id){
	var patient_id = patient_id;
	
	frmObj  = document.frmDispMedicationDeliveryFillList;
	
	var arrObj = frmObj.elements;
    var frmObjs = new Array()
    if(frmObj.name == null)
        frmObjs = frmObj ;
    else frmObjs[0] = frmObj ;
	
	 for(var frmCount=0; frmCount<frmObjs.length; frmCount++) {
        frmObj = frmObjs[frmCount]
        var arrObj = frmObj.elements;
	
        for(var i=0;i<arrObj.length;i++) {
			var chk_order	= (arrObj[i].name).substring(3,patient_id.length+3);
			if(chk_order==patient_id){				
				if(eval("frmObj.PAT"+patient_id+".checked") == true){					
					if(arrObj[i].type=="checkbox") {
						arrObj[i].checked = true ;
					}
				}
				else{
					if(arrObj[i].type=="checkbox") {
						arrObj[i].checked = false ;
					}
				}				
			}			
		}
	 }  
	checkStockUnavailable();
}

function callDeliverLegendsFrame(patient_id,stage,tot_no_rec,tpn_finalize,DispDrugAuthYN) {
	parent.f_disp_medication_legends.location.href="../../ePH/jsp/DispMedicationAllStagesLegends.jsp?patient_id="+patient_id+"&stage="+stage+"&tot_no_rec="+tot_no_rec+"&TPN_FINALIZE="+tpn_finalize+"&DispDrugAuthYN="+DispDrugAuthYN;
}

function setValue(obj){	
	if (obj.checked)
		obj.value = "Y";
	else
		obj.value ="N";
}

function setCBoxValueOnPatClick(obj){

}

function openHistory(patient_id){	
	var HTML = "<html>"
	HTML += "<form name='historyForm' id='historyForm' action='../../eCA/jsp/OpenChartWrapper.jsp'>"
	HTML += "<input type='text' name='insert_op' id='insert_op' value= 'N'>";
	HTML += "<input type='text' name='patient_id' id='patient_id' value= '" + patient_id  + "'>";	
	HTML += "</form>"
	HTML += "</html>"

	parent.parent.parent.parent.messageFrame.document.body.insertAdjacentHTML("beforeend", HTML);
	parent.parent.parent.parent.messageFrame.document.historyForm.submit();
}

function assignNationalityHealthCardNo(nationality,healthCardNo){
	var formObj = document.frmDispMedicationQueryCriteriaIP;
	if(nationality==null || nationality == "null" ) {
		nationality="";
		}
	if(healthCardNo==null || healthCardNo == "null") {
		healthCardNo=""
	}

	formObj.national_id_no.value    = nationality;
	formObj.national_id_no.readOnly	= true;

	formObj.health_card_num.value=healthCardNo;
}


async function callOtherfactySeach(){
	var formObj				= document.DispMedicationPrintDialog;
	var argumentArray		= new Array() ;
	var dataNameArray		= new Array() ;
	var dataValueArray		= new Array() ;
	var dataTypeArray		= new Array() ;
	
	dataNameArray[0]   = "HEALTHCARE_SETTING_TYPE" ;
	dataValueArray[0]  = formObj.ref_referral_facility.value;
	dataTypeArray[0]   = STRING ;

	argumentArray[0]		= formObj.othr_facty_sql.value;
	argumentArray[1]		= dataNameArray ;
	argumentArray[2]		= dataValueArray ;
	argumentArray[3]		= dataTypeArray ;
	argumentArray[4]	    = "2,3";
	argumentArray[5]		= formObj.referral_location_desc.value ;
	argumentArray[6]		= DESC_LINK ;
	argumentArray[7]		= DESC_CODE ; 
	retVal = await CommonLookup( getLabel("Common.OtherFacility.label","Common"), argumentArray );
	var str =unescape(retVal);
	var arr = str.split(",");
	if(retVal != null && retVal != "" )  {
		formObj.referral_location_desc.value		=  arr[1] ;
		formObj.referral_location.value				=  arr[0];		
		//formObj.referral_location_desc.disabled		=  true;
		//formObj.othr_factySearch.disabled			=  true;
		disable_facility1(formObj.referral_location_desc,formObj.referral_facility);
	}
}

function assignValue(obj){
	if(obj.checked==true){
		obj.value='Y';
	}
	else{
		obj.value='N';
	}
}

function qtyValidation(obj){

	var frmObj	  =	document.fromDispMedicationWSLabel;
	var ord_type  = frmObj.ord_type.value;
	if(obj.value != ""){
		prep_qty_volume =	frmObj.prep_qty_volume.value;

		if(parseInt(obj.value) > parseInt(prep_qty_volume)){
			alert(getMessage("TPN_ML_PREP_QTY_NT_GREATER","PH")); //'can not greater than'
			obj.focus();
		}
		else{
			overage_volume =	frmObj.overage_volume.value;
			infuse_over		=	frmObj.infuse_over.value;
			qty_uom			=   frmObj.qty_uom.value;

			var flowRate	="";
            if(ord_type!='CO'){
				if(ord_type=='TA'){
				   flowRate	=   (parseInt(obj.value)-parseInt(overage_volume))/parseInt(infuse_over);
				}
				else{
				   flowRate	=   parseInt(obj.value)/parseInt(infuse_over);
				}
				flowRate		=	roundTwoDigits(flowRate);
			    document.getElementById('flow_rate').innerHTML  =	"<b>"+flowRate+" "+qty_uom+" /Hour </b>";
			}	    
		}
	}
}

function roundTwoDigits(a){
	var a=a+"";

	if (a.indexOf(".")==-1)
		bb=a.substr(0,a.length);
	else{
		bb=a.substr(a.indexOf("."),a.length);
		if (bb.length>3)
			bb=a.substr(0,a.indexOf(".")+3);
		else
			bb=a;
	}
	if (bb.indexOf(".")==-1)
		bb=bb+'.0';
	return bb;
}


function clearframes(){
	var all_stages_bean_id		= "DispMedicationAllStages" ;
	var	all_stages_bean_name	= "ePH.DispMedicationAllStages";
	var bean_id		            = "DispMedicationBean";
	var bean_name	            = "ePH.DispMedicationBean";

	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr += " all_stages_bean_id=\"" + all_stages_bean_id + "\"";
	xmlStr += " all_stages_bean_name=\"" + all_stages_bean_name + "\"";
	xmlStr += " PatientId=\"" + mainForm.patient_id.value + "\"";
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    xmlHttp.open( "POST", "DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=clearPatientValues", false ) ;	
	xmlHttp.send( xmlDoc ) ;
	var homePage=parent.parent.parent.f_query_criteria.document.forms[0].homepage.value;
	if(parent.parent.parent.f_query_criteria.document.forms[0].order_type.value == "ALL" || parent.parent.parent.f_query_criteria.document.forms[0].order_type.value == "CDR"){ // CDR Condition Added for ML-MMOH-CRF-0435 [IN:057357]
		if(getOtherOrders(mainForm)){
			disp_locn_catg =parent.parent.parent.f_query_result.frames[0].patient_id_display.document.frmDispMedicationPatientIDDisplay.disp_locn_catg.value;
			/*if(disp_locn_catg == "O")
				parent.parent.parent.f_query_result.frames[0].patient_id_display.document.getElementById("patient_id_label0").click();
			else*/ // commented for the incident SKR-SCF-573
			
			var propertyName = "S" + mainForm.patient_id.value;			
			var patientIdLength =parent.parent.DispMedicationPatFrame.patient_id_display.document.getElementById(propertyName).length;
			 // added for KAUH-SCF-0061 [IN:034820] & ML-BRU-SCF-0507 [IN:035723]
			
			if(patientIdLength!= undefined)
			  parent.parent.parent.f_query_result.frames[0].patient_id_display.document.getElementById("S"+mainForm).patient_id.value[0].click(); //if block and else condition  added for KAUH-SCF-0061 [IN:034820] & ML-BRU-SCF-0507 [IN:035723]
			else 
				parent.parent.DispMedicationPatFrame.patient_id_display.document.getElementById(propertyName).click(); 
		}
		else if(parent.parent.DispMedicationPatDetFrame_1!=null){
			//parent.parent.DispMedicationPatDetFrame_1.location.reload(); //commented for IN25292 --04/01/2011-- priya
			parent.parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
			if(parent.parent.parent.f_query_criteria_buttons!=undefined){
			    parent.parent.parent.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.btnSearch.click();
			}
		}
		else{ //added for IN25292 --04/01/2011-- priya
			if(parent.parent.parent.f_query_criteria_buttons!=undefined){
				parent.parent.parent.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.btnSearch.click();
			}
		}
	}
	else if(parent.parent.parent.f_query_criteria_buttons!=undefined){
		parent.parent.parent.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.btnSearch.click();
	}

	if(parent.parent.DispMedicationPatDetFrame_1!=null){
		//if(reload) {
		//	parent.parent.DispMedicationPatDetFrame_1.location.reload(); //commented for IN25292 --04/01/2011-- priya
		//} else {
			//parent.parent.DispMedicationPatDetFrame_1.location.href="../../eCommon/html/blank.html";
		//}

		parent.parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	}
}


function blinkText(name,textId,timeA,timeB,colourA,colourB){/* (C)2002 S Chalmers */
	if(document.getElementById){
		this.isEnabled=true;
		this.textId=document.getElementById(textId);
		this.name=name;
		this.timeA=timeA;
		this.timeB=timeB;
		this.colourA=colourA;
		this.colourB=colourB; 
		this.state=0;
		this.timer=null;
		setTimeout(this.name+'.tBlink()',10);
	}
}

blinkText.prototype.tBlink=function(){
	if(this.isEnabled){
		this.textId.style.color = (this.state^=1) ? this.colourA : this.colourB;
		this.timer=setTimeout(this.name+".tBlink()", this.state ? 
		this.timeA : this.timeB )
	}
}

blinkText.prototype.stopBlink=function(){
	this.isEnabled=false;
}

blinkText.prototype.startBlink=function(){
	if(this.isEnabled==false){
		this.isEnabled=true;
		this.tBlink();
	}
}

blinkText.prototype.toggleBlink=function(){
	if(this.isEnabled^=true);
		this.tBlink();
}

async function showApptDtls(patient_id){
	var dialogHeight= "25" ;
	var dialogWidth	= "45" ;
	var dialogTop = "220" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop+";scrolling :yes";
	var arguments	= "" ;
    var retVal=await window.showModalDialog("../../ePH/jsp/DispBalanceMedicationAppt.jsp?patientid="+patient_id,arguments,features);
}

async function callbillingwindow(doc_det_for_bl,disp_locn_code, blDocSrlNo,ordering_facility_id){ //ordering_facility_id added for MOHE-CRF-0060
	//gross_charge_display_str.append((String)message_bill.get("l_bill_doc_num")).append(",").append((String)message_bill.get("l_bill_doc_type")).append(",").append((String)message_bill.get("v_blng_group_id")).append(",").append((String)message_bill.get("p_call_disc_function_yn")).append(",").append((String)message_bill.get("l_slmt_reqd_yn")).append(",").append(doc_type_code+"-"+doc_no).append(",").append(patient_id).append(",").append(encounter_id).append(",").append(patient_class).append(",").append((String)message_bill.get("error_id_txt"));
	detail = doc_det_for_bl.split(",");
	var bill_doc_no			    =  detail[0];
	var bill_doc_type			=  detail[1];
	var bill_group_code			=  detail[2];
	var call_disc_function_yn	=  detail[3];
	var l_slmt_reqd_yn			=  detail[4];
	var doc_no					=  detail[5];
	var patient_id				=  detail[6];
	var encounter_id			=  detail[7];
	var patient_class			=  detail[8];
	var error_text				=  detail[9];
	var episode_id				= '';
	var visit_id				= '';
	if(error_text=='' ){
		if(patient_class=="E"||patient_class=="O"){
			episode_id = (encounter_id).substring(0,encounter_id.length-4);
			visit_id = (encounter_id).substring(encounter_id.length-4,encounter_id.length);
		}
		else if(patient_class=="I"||patient_class=="D"){
				//episode_id = formObj.encounter_id.value;
				episode_id = encounter_id;
				visit_id   = "1";
		}

		var retVal = new Array();		
		var center='1';
		var dialogTop = "100";
		var dialogHeight = "95vh" ;
		var dialogWidth = "95vw" ;
		var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; center:" + center + "; dialogWidth:" + dialogWidth +";status=no" ;	
		var arguments = "" ;
		var column_sizes = escape("");               
		var column_descriptions ="";					

		 var url = "../../eBL/jsp/BLCallDiscOrSlmtPage.jsp?bill_doc_type_code=" + bill_doc_type + "&bill_doc_num=" + bill_doc_no + "&store_code=" + disp_locn_code + "&blng_grp=" + bill_group_code + "&module_id=PH&column_sizes=" + column_sizes + "&column_descriptions=" + column_descriptions+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&call_disc_function_yn="+call_disc_function_yn+"&doc_no="+doc_no+"&episode_id="+episode_id+"&visit_id="+visit_id+"&slmt_reqd_yn="+l_slmt_reqd_yn+"&episode_type="+patient_class+"&bl_items_sl_no="+blDocSrlNo+"&ordering_facility_id="+ordering_facility_id; // bl_items_sl_no Added for  [IN:043103] ordering_facility_id added for MOHE-CRF-0060
		 retVal= await top.window.showModalDialog(url,arguments,features);
		 if(retVal==undefined){
			callbillingwindow(doc_det_for_bl,disp_locn_code, blDocSrlNo,ordering_facility_id);//ordering_facility_id added for MOHE-CRF-0060
		 }
		 else{
			clearframes();
		 }
		
		 if((retVal == "N" || retVal == "P") && retn_disp_med_for_outstanding == "Y"){//added for MMS-QH-CRF-0201 [IN:052255] -start
			if(confirm(getMessage("PH_CONFIRM_FOR_RETURN_MEDN","PH"))){
				if(checkReturnAccess(disp_locn_code)){
					await showReturnMedication(patient_id,disp_locn_code, patient_class );
				}
				else
					alert(getMessage("PH_RET_MED_RIGHTS","PH"));
			}
		 } //added for MMS-QH-CRF-0201 [IN:052255] -end
		/*var param = "column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"billdoctypecode="+doc_type+"&"+"billdocnum="+doc_no+"&"+"storecode="+disp_locn_code+"&"+"blnggrp="+bill_group_code+"&"+"module_id=PH";	
		 retVal=window.showModalDialog("../../eBL/jsp/BLStoreBillSlmtMain.jsp?"+param,arguments,features); */
	}
	else{
		if(error_text!= undefined)
			alert(error_text);
		clearframes();
	}	
}

function clearTokenValues(obj1,obj2, tokenseriessize){ //tokenseriessize added for KAUH-SCF-0057 [IN:034750]
	var formObj = document.frmDispMedicationQueryCriteriaTokenInfo;
	if(obj1.value!=''){
		obj2.value          = "";
		if(tokenseriessize != '3'){ //added for KAUH-SCF-0057 [IN:034750]
			var defTokenSeries = formObj.defTokenSeries.value; //added for [IN:037465]
			if(defTokenSeries!=''){//if condition and else block added for [IN:037465]   
				obj1.value	=defTokenSeries;	
				populateToken(formObj);
			}
			else{
				obj1.selectedIndex  = 0; 
				obj1.value ="";
			}
			obj1.disabled		=false;
		}  
		else{
			populateToken(formObj);
			obj1.disabled		=true;
		}
	}
}

async function callPatientHistory(patient_id){
	var dialogHeight ='93vh' ;
	var dialogWidth = '90vw' ;
	var dialogTop	= '10';
	var dialogLeft = '10' ;
	var dialogPadding= '5px';
    var dialogBorder= '1px solid black';

	var features = 'dialogBorder:' + dialogBorder + ';dialogPadding:' + dialogPadding + '; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';
	var arguments = "";
	var retVals =await top.window.showModalDialog("../../eCA/jsp/EncounterInDialog.jsp?patient_id="+patient_id,arguments,features);
}

async function DiplayPendingTokenDtls(token_series,token_no){
	if(document.frmDispMedicationQueryCriteriaTokenInfo!=undefined){
	   document.frmDispMedicationQueryCriteriaTokenInfo.token_no.value=token_no;
	}
	else{
	   parent.f_query_criteria_token_info.document.frmDispMedicationQueryCriteriaTokenInfo.token_no.value=token_no;
	}
	var dialogHeight= "30" ;
	var dialogWidth	= "60" ;	
	var dialogTop = "195" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal =await window.showModalDialog("../../ePH/jsp/PendingToken.jsp?token_series="+token_series+"&token_no="+token_no,arguments,features);
	//parent.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.btnSearch.click();

	 clearUponPendingToken();
}

function clearUponPendingToken(){
	var formObj              = parent.document.f_query_criteria_token_info.frmDispMedicationQueryCriteriaTokenInfo;
	var formObjQueryCriteria = parent.document.f_query_criteria.frmDispMedicationQueryCriteria;
	var language_id	         =   formObjQueryCriteria.Language_id.value;
	
	var dateFormat = ""; //added for MMS-DM-CRF-0228 start
	var ph_print_prescription = formObjQueryCriteria.ph_print_prescription.value;
	if(ph_print_prescription=="true"){
		dateFormat = "DMYHM";
	}
	else{
		dateFormat = "DMY";//added for MMS-DM-CRF-0228 end
	}
	
	if(language_id=="ar"){ //modified for MOHE-CRF-0040
		if(formObjQueryCriteria.disp_level.value=="P")
			formObjQueryCriteria.lbl_disp_level.innerHTML = "<b> حسب ا�?�?ر�?ض</b>";
		else
			formObjQueryCriteria.lbl_disp_level.innerHTML = "<b> حسب ا�?ترت�?ب</b>";
		}else{
		if(formObjQueryCriteria.disp_level.value=="P")
			formObjQueryCriteria.lbl_disp_level.innerHTML = "<b> Patient Wise</b>";
		else
			formObjQueryCriteria.lbl_disp_level.innerHTML = "<b> Order Wise</b>";
		} //modified for MOHE-CRF-0040

	formObj.token_no.disabled		=	true;
	formObj.token_series.disabled	=	true;
	formObj.queue_date.disabled	    =	true;

	parent.document.f_query_criteria_token_info.document.getElementById("Calendar").disabled	    =	true;

// Added for SRR20056-CRF-0663 - Start
	if( formObjQueryCriteria.include_absolute_orders.checked==true){
		include_absolute_orders ="Y";
	}
	else{
		include_absolute_orders ="N";
	}
// Added for SRR20056-CRF-0663 - End
//exclude_orders_by_freq_durn changed to include_orders_by_freq_durn for SRR20056-CRF-0663 

	if( formObjQueryCriteria.include_orders_by_freq_durn!=undefined && formObjQueryCriteria.include_orders_by_freq_durn.checked==true){
		include_orders_by_freq_durn ="Y";
	}
	else{
		include_orders_by_freq_durn ="N";
	}

	 if(formObjQueryCriteria.group_by_ord_locn.checked==true){
		group_by_ord_locn ="Y";
	}
	else{
		group_by_ord_locn ="N";
	}

	if( formObjQueryCriteria.exclude_PRN_orders.checked==true){
		exclude_PRN_orders ="Y";
	}
	else{
		exclude_PRN_orders ="N";
	}
	var patient_id = formObj.patient_id.value; //formObjQueryCriteria changed to formObj
	var bean_id		= formObj.bean_id.value ;
	var bean_name	= formObj.bean_name.value ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr += " token_no=\"" + formObj.token_no.value + "\"";
	xmlStr += " token_series=\"" + formObj.token_series.value + "\"";
	xmlStr += " order_date_from=\"" + convertDate(formObjQueryCriteria.order_date_from.value,dateFormat,language_id,"en") + "\""; // Added for MMS-DM-CRF-0228
	xmlStr += " order_date_to=\"" + convertDate(formObjQueryCriteria.order_date_to.value,dateFormat,language_id,"en") + "\""; // Added for MMS-DM-CRF-0228
	xmlStr += " scope=\"" + formObjQueryCriteria.order_status.value + "\"";
	xmlStr += " priority=\"" + formObjQueryCriteria.priority.value + "\"";
	xmlStr += " patient_id=\"" +patient_id  + "\"";
	//xmlStr += " order_id=";
	if(formObjQueryCriteria.admixture_type!=null){
		xmlStr += " admixture_type=\"" + formObjQueryCriteria.admixture_type.value + "\"";
	}
	xmlStr += " disp_level=\"" + formObjQueryCriteria.disp_level.value + "\"";
	xmlStr += " ord_locn_code=\"" + formObjQueryCriteria.ord_locn_code.value + "\"";
	xmlStr += " order_type=\"" + formObjQueryCriteria.order_type.value + "\"";
	xmlStr += " ord_locn_type=\"" + formObjQueryCriteria.ord_loc_type.value + "\"";
	xmlStr += " order_by=\"" + formObjQueryCriteria.order_by.value + "\"";

	xmlStr += " group_by_ord_locn=\"" + group_by_ord_locn + "\"";
	xmlStr += " include_absolute_orders=\"" + include_absolute_orders + "\"";
	xmlStr += " exclude_PRN_orders=\"" + exclude_PRN_orders +"\""
	xmlStr += " drug_medical=\"" + formObjQueryCriteria.drug_medical.value + "\"";

	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=storeCriteriaValues", false ) ;
	xmlHttp.send( xmlDoc ) ;
	parent.f_query_result.DispMedicationPatFrame.location.href="../../ePH/jsp/DispMedicationPatientIDFrame.jsp?patient_id="+patient_id;
	parent.document.DispMedicationQueryCriteriaFrameSet.rows="25,0,*,0,500";
	parent.document.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.btnHideShowCriteria.value=getLabel("ePH.ShowCriteria.label","PH");
}

function ClearNursingUnit(){
	document.frmDispMedicationQueryCriteriaIP.nursing_unit_desc.value="";
	document.frmDispMedicationQueryCriteriaIP.nursing_unit.value="";
}

function ClearNursingUnit1(){
	document.frmDispMedicationQueryCriteria.disp_locn_desc.value="";
	document.frmDispMedicationQueryCriteria.ord_locn_code.value="";
}
  
async function DiplayAppointmentDtls(patient_id,sysdate,getDate_plus_365){
	var dialogHeight= "30" ;
	var dialogWidth	= "60" ;	
	var dialogTop = "195" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal =await window.showModalDialog("PHQueryApptForPatientResult.jsp?patientid="+patient_id+"&apptfromdate="+sysdate+"&appttodate="+getDate_plus_365+"&incld_past_appts=Y&MODULE_ID=PH&function_id=QRY_APPT_PAT&cliniccode=&practcode=&appt_ref_no=&speciality=&care_locn=&resource_type=&short_desc=&patientname=&oth_contact_no=",arguments,features);//code 'eOA/jsp/QueryApptForPatientResultFrames.jsp' is replaced by PHQueryApptForPatientResult.jsp added for ML-BRU-SCF-1387[IN049916]
}


function OrderDefault(){
  /*formObj=document.frmDispMedicationQueryCriteriaIP;
  var len =formObj.fill_proc_id.options.length;
	for(var i=0;i<len;i++) {
		formObj.fill_proc_id.remove("fill_proc_id") ;
	}
	var tp = "---"+getLabel("Common.defaultSelect.label","Common")+"---";
	var opt = document.createElement("OPTION") ;
	opt.text = tp ;
	opt.value = "" ;
	formObj.fill_proc_id.add(opt); */
}

function uncheckOtherBoxes(encIndex,index,obj, recCount){
	encounterCount = parseInt(document.frmDispMedicationOrderDetails.encounterCount.value);

	for (var encIndx=0; encIndx<encounterCount ;encIndx++ ){
		for(var i=0;i<11;i++){
			if(encIndx!=encIndex || i != index || obj.checked == false){
				try{
					eval("document.frmDispMedicationOrderDetails.OrderType_"+encIndx+'_'+i).checked = false;
				}
				catch (e){}
	//			try{
					var levelTwoCheckBox = eval("document.frmDispMedicationOrderDetails.OrderValues_"+encIndx+'_'+i);
					if(levelTwoCheckBox != undefined){
						var highestIndex = levelTwoCheckBox.length;
						if(highestIndex == undefined){
							if(levelTwoCheckBox.value != null){
								levelTwoCheckBox.checked = false;
								levelTwoCheckBox.disabled = true;
								highestIndex =0;
							}
						}
						for(var j=0; j<highestIndex; j++){
							levelTwoCheckBox[j].checked = false;
							levelTwoCheckBox[j].disabled = true;
						}
					}
				//}
	//			catch (e){alert(e)}
			}
			else
				selectOrder(encIndex,i, recCount);
		}
	}
}

function selectSingleADM(mainIndex,subIndex,Selectedindex){ // Added Selectedindex for reopened [Inc:41227]
//	try{
		//var levelTwoCheckBox = eval("document.frmDispMedicationOrderDetails.OrderValues_"+mainIndex);// Commented  for reopened [Inc:41227]
		var levelTwoCheckBox = eval("document.frmDispMedicationOrderDetails.OrderValues_"+mainIndex+"_"+subIndex); // Added for [Inc:41227] 
		if(levelTwoCheckBox != undefined){
			var highestIndex = levelTwoCheckBox.length;
			if(highestIndex == undefined){
				highestIndex =0;
			}
			for(var j=0; j<highestIndex; j++){
				if(j != Selectedindex){ // subIndex changed to Selectedindex for [IN:041227]
					levelTwoCheckBox[j].checked = false;
				}
			}
		}
	//}
//	catch (e){alert(e)}
}
function selectOrder(encIndex,i, index){
	var levelTwoCheckBox = eval("document.frmDispMedicationOrderDetails.OrderValues_"+encIndex+'_'+i);
	var tpn_mf_label=document.frmDispMedicationOrderDetails.tpn_mf_label.value;
	var ord_type=document.frmDispMedicationOrderDetails.OrderType.value;
	
	if(levelTwoCheckBox != undefined){
		var highestIndex = levelTwoCheckBox.length;
		//If the level 2 is having only one order, then select that single order
		if(highestIndex == undefined){
			highestIndex =0;
			levelTwoCheckBox.checked = true;
			levelTwoCheckBox.onclick();
			levelTwoCheckBox.disabled = false;
		}
		var singleSelect = false;
		// Select All the order exception for Admxture orders. if i=2,4,6,10 then only one order shoule be selected
		for(var j=0; j<highestIndex; j++){//Prathyusha
			if(tpn_mf_label != undefined && (tpn_mf_label=="true" || tpn_mf_label== true) && ord_type){ //added for ml-mmoh-crf-468 
				if(i==2 || i==4 || i==10 || i==6 || i==7)
					
					singleSelect = true;
				else{
					levelTwoCheckBox[j].checked = true;
					levelTwoCheckBox[j].onclick();
				}	
			}
			else{
				if(i==2 || i==4 || i==10 || i==6 )
			
				singleSelect = true;
			else{
				levelTwoCheckBox[j].checked = true;
				levelTwoCheckBox[j].onclick();
			}
			}
			var iv_prep_yn = document.frmDispMedicationOrderDetails.iv_prep_yn.value;
			if(iv_prep_yn=='null' || iv_prep_yn ==''){
				//Commented for RUT-CRF-0088 [IN036978]
				/*var tapered_yn = eval("document.frmDispMedicationOrderDetails.tapered_yn_"+encIndex+"_"+index).value;
				var taper_order_id = eval("document.frmDispMedicationOrderDetails.taper_order_id_"+encIndex+"_"+index).value;
				//var order_id = eval("document.frmDispMedicationOrderDetails.tapered_yn_"+encIndex+"_"+i).value;
				if(tapered_yn!="" && taper_order_id !="")
					levelTwoCheckBox[j].disabled = true;
				else*/
					levelTwoCheckBox[j].disabled = false;
			}
			else
				levelTwoCheckBox[j].disabled = false;
				index++;
		}
		if(singleSelect){
			levelTwoCheckBox[0].checked = true;
			levelTwoCheckBox[0].onclick();
		}
	}
}


function selectFirstOrder(){
	firstOrderTypeCode = document.frmDispMedicationOrderDetails.firstOrderTypeCode.value
	for(var i=0;i<11;i++){
		//try		{
	    if(document.getElementById("OrderType").value=='CDR'){  // if esle condition added for ML-MMOH-CRF-0435 [IN:057357]
			if (eval("document.frmDispMedicationOrderDetails.OrderType_0_"+i) != undefined){
				break;
			}
	    } 
	    else{
	    	if (eval("document.frmDispMedicationOrderDetails.OrderType_0_"+i) != undefined){
				eval("document.frmDispMedicationOrderDetails.OrderType_0_"+i).checked = true;
				selectOrder(0,i,0, firstOrderTypeCode);
				document.frmDispMedicationOrderDetails.getValues.onclick();
				break;
			}
	    }
	    
		//}
		//catch (e){}
	}
}

//Added for NMC-JD-SCF-0251
function selectFirstOrder1(){
	firstOrderTypeCode = document.frmDispMedicationOrderDetails.firstOrderTypeCode.value
	enccounterCount = parseInt(document.frmDispMedicationOrderDetails.encounterCount.value); //Added for NMC-JD-SCF-0251 - Start
	for(var encIndx =0; encIndx<enccounterCount; encIndx++){
		for(i=0;i<11;i++){
			try{
				if(eval("document.frmDispMedicationOrderDetails.OrderType_"+encIndx+'_'+i).checked == true){
					if(document.getElementById("OrderType").value=='CDR'){  // if esle condition added for ML-MMOH-CRF-0435 [IN:057357]
						if (eval("document.frmDispMedicationOrderDetails.OrderType_0_"+i) != undefined){
							break;
						}
				    }
					else{
						if (eval("document.frmDispMedicationOrderDetails.OrderType_"+encIndx+'_'+i) != undefined){
							eval("document.frmDispMedicationOrderDetails.OrderType_"+encIndx+'_'+i).checked = true;
							selectOrder(encIndx,i,0, firstOrderTypeCode);
							document.frmDispMedicationOrderDetails.getValues.onclick();
							break;
						}
					}
					break;
				}
			 }
			catch (e){
			}
		} //Added for NMC-JD-SCF-0251 - End
	}
}


function getOrderIds(patientId,dispStage,fillingStatus,dispLocnCatg,groupByPatient,dispLevel){
	var orderIds = "";
	var i=0;
	var encounterId="";
	enccounterCount = parseInt(document.frmDispMedicationOrderDetails.encounterCount.value);
	for(var encIndx =0; encIndx<enccounterCount; encIndx++){
		for(i=0;i<11;i++){
			try{
				if(eval("document.frmDispMedicationOrderDetails.OrderType_"+encIndx+'_'+i).checked == true){
					encounterId = eval("document.frmDispMedicationOrderDetails.encounterId_"+encIndx).value;
					var levelTwoCheckBox = eval("document.frmDispMedicationOrderDetails.OrderValues_"+encIndx+'_'+i);
					if(levelTwoCheckBox != undefined){
						var highestIndex = levelTwoCheckBox.length;
						if(highestIndex == undefined){
							if(levelTwoCheckBox.checked == true){
								orderIds= levelTwoCheckBox.value+"::";
								highestIndex =0;
							}
						}
						for(var j=0; j<highestIndex; j++){
							if(levelTwoCheckBox[j].checked == true)
								orderIds += levelTwoCheckBox[j].value+"::";
						}
					}
					break;
				}
			}
			catch (e){//alert(e);
			}
		}
	}
	var selectedOrderType;
	if(i==0)
		selectedOrderType = "NOR"
	else if(i==1)
		selectedOrderType = "IVAD"
	else if(i==2)
		selectedOrderType = "IVAA"
	else if(i==3)
		selectedOrderType = "IVID"
	else if(i==4)
		selectedOrderType = "IVIA"
	else if(i==5)
		selectedOrderType = "IVWA"
	else if(i==6)
		selectedOrderType = "CO"
	else if(i==7)
		selectedOrderType = "TD"
	else if(i==8)
		selectedOrderType = "TA"
	else if(i==9)
		selectedOrderType = "CD"
	else if(i==10)
		selectedOrderType = "CA"

	//var selectedOrderType = {"NOR","IVAD","IVAA","IVID","IVIA","IVWA","CO","TD","CD","TA","CA"};

	var OldTrxOrderIds = document.frmDispMedicationOrderDetails.OldTrxOrderIds.value;
	var iv_prep_yn = document.frmDispMedicationOrderDetails.iv_prep_yn.value;
	var ivOrderId  = document.frmDispMedicationOrderDetails.iv_order_id.value;

	if((OldTrxOrderIds == orderIds) && orderIds!="" ){ // orderIds Condition Added for ML-MMOH-CRF-0435 [IN:057357]
		expandFrame();
	}
	else if(orderIds != ""){		
		if(parent.patient_details.document.getElementById("expand")==undefined){
			setTimeout("expandFrame()",500);//to give to time to upper frame loading
		}
		else{
			expandFrame();
		}
		var bean_id		= "DispMedicationBean";
		var bean_name	= "ePH.DispMedicationBean";
		//var xmlDoc  = new ActiveXObject( "Microsoft.XMLDom" ) ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr += " patientId=\""+patientId+"\"";
		xmlStr += " encounterId=\""+encounterId+"\"";
		xmlStr += " dispStage=\""+dispStage+"\"";
		xmlStr += " fillingStatus=\""+fillingStatus+"\"";
		xmlStr += " dispLocnCatg=\""+dispLocnCatg+"\"";
		xmlStr += " groupByPatient=\""+groupByPatient+"\"";
		xmlStr += " dispLevel=\""+dispLevel+"\"";
		xmlStr += " URL=\""+orderIds+"\"";
		xmlStr += " iv_prep_yn=\""+iv_prep_yn+"\"";
		xmlStr += " iv_order_id=\""+ivOrderId+"\"";
		xmlStr += " selectedOrderType=\""+selectedOrderType+"\"";
		xmlStr +=" /></root>";
		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=checkOrderChanges",false);
		xmlHttp.send( xmlDoc ) ;
		//alert(xmlHttp.responseText);
		eval(xmlHttp.responseText);
	}
	else
		alert(getMessage("NO_ORDER_SELECTED","PH"));
	document.frmDispMedicationOrderDetails.OldTrxOrderIds.value = orderIds;
}

function expandFrame(){
	var expand = "Expand";
	var collapse =  "Collapse";	
	//try
	//{
		if(parent.patient_details.document.getElementById("expand").value == expand){
			//parent.parent.DispMedicationDetailFrameSet.rows="100%,0%";
			parent.parent.document.getElementById("DispMedicationDetailSubFrameSet_2").style.display="none";
			parent.parent.document.getElementById("DispMedicationPatDetFrame_1").style.height="95vh";
			parent.parent.document.getElementById("DispMedicationPatFrame").style.height="24vh";
			//parent.parent.DispMedicationPatDetFrame_1.document.getElementById("PatientOrderFrames").rows="10%,90%";
			parent.parent.DispMedicationPatDetFrame_1.document.getElementById("patient_details").style.height="10vh";
			parent.parent.DispMedicationPatDetFrame_1.document.getElementById("order_details").style.height="85vh";
			parent.patient_details.document.getElementById("expand").value = collapse;
		}
		else{
			//parent.parent.DispMedicationDetailFrameSet.rows="17%,*";
			//parent.parent.DispMedicationPatDetFrame_1.document.getElementById("PatientOrderFrames").rows="100%,*";
			parent.parent.document.getElementById("DispMedicationDetailSubFrameSet_2").style.display="flex";
			parent.parent.document.getElementById("DispMedicationPatDetFrame_1").style.height="20vh";
			parent.parent.document.getElementById("DispMedicationPatFrame").style.height="20vh";
			parent.parent.DispMedicationPatDetFrame_1.document.getElementById("patient_details").style.height="70vh";
			parent.parent.DispMedicationPatDetFrame_1.document.getElementById("order_details").style.height="0vh";
			parent.patient_details.document.getElementById("expand").value = expand;
		}
	//}
	//catch (e){//parent.patient_details.document.frmPatientDetails.expand.value = collapse;
	//}
}

function setTrxOrderIds(orderIds, bUpdate){
	var bean_id		= "DispMedicationBean";
	var bean_name	= "ePH.DispMedicationBean";
	//var xmlDoc  = new ActiveXObject( "Microsoft.XMLDom" ) ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr += " orderIds=\""+orderIds+"\"";
	xmlStr += " bUpdate=\""+bUpdate+"\"";
	xmlStr +=" /></root>";
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=setTrxOrderIds",false);
	xmlHttp.send( xmlDoc ) ;
	//alert(xmlHttp.responseText);
	eval(xmlHttp.responseText);
}

function completeOtherOrders(){
	//if(confirm(getMessage("PH_DISPENSE_DATA_MODIFIED","PH"))){
	if(confirm(getMessage("CONTINUE_PENDING","PH"))){
		parent.parent.DispMedicationPatDetFrame_1.order_details.document.frmDispMedicationOrderDetails.continueSameOrder.value = "true";
		return true;
	}
	else{ //Cancel pending order - to list all the patient
		var bean_id		= "DispMedicationBean";
		var bean_name	= "ePH.DispMedicationBean";
		//var xmlDoc  = new ActiveXObject( "Microsoft.XMLDom" ) ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=clearPatientId",false);
		xmlHttp.send( xmlDoc ) ;
		return false;
	}
}

function getOtherOrders(mainForm){
	var bean_id		= "DispMedicationBean";
	var bean_name	= "ePH.DispMedicationBean";
	var patient_id  = mainForm.patient_id.value;
	//var xmlDoc  = new ActiveXObject( "Microsoft.XMLDom" ) ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&patient_id="+patient_id+"&identity=getOrders",false);
	xmlHttp.send( xmlDoc ) ;
	return eval(xmlHttp.responseText);
}

function setIVPrepYN(obj,ivPrepYN){
	//try{
		document.frmDispMedicationOrderDetails.iv_prep_yn.value = ivPrepYN;
		if(obj.checked == true){ //if condition Added for [IN:041227]
			document.frmDispMedicationOrderDetails.iv_order_id.value = obj.value;
		}
	//}
	//catch (e){}
}

function setColorForZeroStock(pres_qty,row){
	getTotalAvailableQunatity();

	if(parseFloat(total_available_qty)<parseFloat(pres_qty)){
		eval("parent.parent.DispMedicationPatDetFrame_3.f_disp_medication_verification.DispMedicationAllStages.stock"+row).style.backgroundColor="yellow";
	}
}

function setSelectedOrder(selectedOrderType){
	var bean_id		= "DispMedicationBean";
	var bean_name	= "ePH.DispMedicationBean";
	//var xmlDoc  = new ActiveXObject( "Microsoft.XMLDom" ) ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr += " selectedOrderType=\""+selectedOrderType+"\"";
	xmlStr +=" /></root>";
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=setSelectedOrderType",false);
	xmlHttp.send( xmlDoc ) ;
	//alert(xmlHttp.responseText);
	return eval(xmlHttp.responseText);
}

function setOrderId(orderId){
	var bean_id		= "DispMedicationBean";
	var bean_name	= "ePH.DispMedicationBean";
	//var xmlDoc  = new ActiveXObject( "Microsoft.XMLDom" ) ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr += " orderId=\""+orderId+"\"";
	xmlStr +=" /></root>";
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=setSelOrderId",false);
	xmlHttp.send( xmlDoc ) ;
	//alert(xmlHttp.responseText);
	return eval(xmlHttp.responseText);
}

function setDefQueueDateToFrom(obj){
	parent.f_query_criteria.document.frmDispMedicationQueryCriteria.order_date_from.value = obj.value;
}

function setPatientIdBasedOnCriteria(){
	var patientId = "";
	if(parent.parent.parent.f_query_criteria.document.frmDispMedicationQueryCriteria!=null && parent.parent.parent.f_query_criteria.document.frmDispMedicationQueryCriteria != undefined )
		patientId = parent.parent.parent.f_query_criteria.document.frmDispMedicationQueryCriteria.patient_id.value;
	else if(parent.parent.parent.f_query_criteria.document.frmDispMedicationQueryCriteriaIP != null && parent.parent.parent.f_query_criteria.document.frmDispMedicationQueryCriteriaIP != undefined )
		patientId = parent.parent.parent.f_query_criteria.document.frmDispMedicationQueryCriteriaIP.patient_id.value;

	if(patientId != "")	{
		var bean_id		= "DispMedicationBean";
		var bean_name	= "ePH.DispMedicationBean";
		//var xmlDoc  = new ActiveXObject( "Microsoft.XMLDom" ) ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr += " patientId=\""+patientId+"\"";
		xmlStr +=" /></root>";
		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=setPatientIdBasedOnCriteria",false);
		xmlHttp.send( xmlDoc ) ;
		//alert(xmlHttp.responseText);
		return eval(xmlHttp.responseText);
	}
}

/*function makeQtyAsReadOnly(){
	if(parent.ws_order_details_frame.ws_order_details.document.frmDispMedicationWSOrderDetails.MakeReadOnly.value == 'true')	{
		document.frmDispMedicationWSCalSec.drug_qty_preparation.readOnly = true;
		document.frmDispMedicationWSCalSec.drug_qty_spillage.readOnly = true;
	}
}*/

function changeToSingleQuotes(obj){
	var str = obj.value;
	var re  = /\"/g;
	var re1	= /\&/g;
	obj.value = str.replace(re, "''").replace(re1,"");
}

function restrictAMP(event){
	if(event.keyCode == '38')
		return false;
	return true;
}

function CheckForSpecialChars(event,site_yn){
    if(event.keyCode == '38')
		return false;

	if(site_yn==true || site_yn=="true"){
	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*/-';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	}
	return true ;
}

function resetProductName(){
	document.fromDispMedicationWSLabel.mfg_unit.value = "";
}

function checkUncheckChildChkBoxs(sPatientId,sOrderId,index, stockAvailable, obj){

	var formObj	= document.frmDispMedicationDeliveryFillList;
	if(obj.checked == true)	{
		for(var i=1;100;i++){
			try{
				if(eval("formObj.stock_"+sPatientId+"_"+sOrderId+"_"+index+"_"+i).value != 'disabled'){
					eval("formObj.PAT"+sPatientId+"_"+sOrderId+"_"+index+"_"+i).checked = true;
					eval("formObj.PAT"+sPatientId+"_"+sOrderId+"_"+index+"_"+i).value   = "Y";
				}
			}
			catch (e){
				break;
			}
		}
	}
	else{
		for(var i=1;100;i++){
			try{
				eval("formObj.PAT"+sPatientId+"_"+sOrderId+"_"+index+"_"+i).checked = false;
				eval("formObj.PAT"+sPatientId+"_"+sOrderId+"_"+index+"_"+i).value   = "N";

			}
			catch (e){
				break;
			}
		}
	}
}

function checkStockUnavailable(){
	var frmObj  = document.frmDispMedicationDeliveryFillList;
	var arrObj = frmObj.elements;
	var frmObjs = new Array()
	if(frmObj.name == null)
		frmObjs = frmObj ;
	else 
		frmObjs[0] = frmObj ;

	for(var frmCount=0; frmCount<frmObjs.length; frmCount++) {
		frmObj = frmObjs[frmCount]
		var arrObj = frmObj.elements;
		for(var i=0;i<arrObj.length;i++) {
			if(arrObj[i].type=="hidden") {
				if(arrObj[i].value == "disabled"){
					var names = arrObj[i].name.split("_");
					for(var nameIndex=1;nameIndex<100;nameIndex++){
						try{
							eval("frmObj.PAT"+names[1]+"_"+names[2]+"_"+names[3]+"_"+nameIndex).checked  = false;
							eval("frmObj.PAT"+names[1]+"_"+names[2]+"_"+names[3]+"_"+nameIndex).disabled = true;
							eval("frmObj.PAT"+names[1]+"_"+names[2]+"_"+names[3]+"_"+nameIndex).value	  = "N";
						}
						catch (e){
							break;
						}
					}
				}
			}			
		}
	 }   
}

function validateNumbers(obj,intPart,decimalPart){
	var number = obj.value;
	var dotOccurance = number.indexOf('.');
	var totalLength = number.length;

	if(dotOccurance == -1){
		if(parseInt(totalLength) > parseInt(intPart)){
			var msg = getMessage("INTEGER_NOT_VALID", "PH");
			msg = msg.replace('~', intPart);
			alert(msg);
			obj.focus();
			return false;
		}
	}
	else{
		var iPart = number.split(".")[0];
		var dPart = number.split(".")[1];

		if(parseInt(intPart)<parseInt(iPart.length)){
			var msg = getMessage("INTEGER_NOT_VALID", "PH");
			msg = msg.replace('~', intPart);
			alert(msg);
			obj.focus();
			return false;
		}
		if(parseInt(decimalPart)<dPart.length){
			var msg = getMessage("DECIMAL_NOT_VALID", "PH");
			msg = msg.replace('~', decimalPart);
			alert(msg);
			obj.focus();
			return false;
		}
	}
	return true;
  }

function checkAuthForDWF(){
	var formObj =parent.DispMedicationDeliveryFillList.document.frmDispMedicationDeliveryFillList;
    var arrObj = formObj.elements;
	var name= "";
	var drug_codes ="";

	for(var i=0;i<arrObj.length;i++) {
		if(arrObj[i].type=="checkbox") {
			name = arrObj[i].name;
			if(name.indexOf("PAT") != -1 && name.indexOf("_") != -1 && name.indexOf("drugCode") == -1){
				if(arrObj[i].checked){
					drug_codes = drug_codes+"~"+eval("formObj.drugCode_"+name).value;
				}
			}
		}
	}

	var bean_id		=	"DispMedicationAllStages";
	var bean_name	=	"ePH.DispMedicationAllStages";
	//var xmlDoc  = new ActiveXObject( "Microsoft.XMLDom" ) ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr += " drugCodes=\"" +drug_codes + "\"";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr +=" /></root>" ;
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "DispMedicationValidate.jsp?bean_id=DispMedicationBean&bean_name=ePH.DispMedicationBean&identity=checkDispAuthYN", false ) ;
	xmlHttp.send( xmlDoc );
	return eval(xmlHttp.responseText);
}

function setStockAvailable(avail){
	return avail;
}

function assignToken(token,added_facility_id) {
	var sys_date= convertDate(document.frmDispMedicationQueryCriteriaTokenInfo.sys_date.value,"DMY","en",document.frmDispMedicationQueryCriteriaTokenInfo.language_id.value)
	if(token=="") {
		if(document.frmDispMedicationQueryCriteriaTokenInfo!=null) {
			document.frmDispMedicationQueryCriteriaTokenInfo.token_no.value ="";   
			alert(getMessage("NO_MORE_TOKENS","PH"));
			//document.frmDispMedicationQueryCriteriaTokenInfo.queue_date.value =sys_date;
			//document.frmDispMedicationQueryCriteriaTokenInfo.btn_next_token.click();
			parent.f_query_criteria_buttons.document.frmDispMedicationQueryCriteriaButtons.btnSearch.click();
		} 
		else {
			parent.f_query_criteria_token_info.document.frmDispMedicationQueryCriteriaTokenInfo.token_no.value="";  
			alert(getMessage("NO_MORE_TOKENS","PH"));
			//document.frmDispMedicationQueryCriteriaTokenInfo.queue_date.value =sys_date;
			//document.frmDispMedicationQueryCriteriaTokenInfo.btn_next_token.click();
			parent.f_query_criteria_buttons.document.frmDispMedicationQueryCriteriaButtons.btnSearch.click();
		}
	}
	else {
		if(document.frmDispMedicationQueryCriteriaTokenInfo.token_no.value==token ) {
		
			alert(getMessage("NO_MORE_TOKENS","PH"));
			//document.frmDispMedicationQueryCriteriaTokenInfo.queue_date.value =sys_date;
			//document.frmDispMedicationQueryCriteriaTokenInfo.btn_next_token.click();
			parent.f_query_criteria_buttons.document.frmDispMedicationQueryCriteriaButtons.btnSearch.click();
		} 
		else {
			document.frmDispMedicationQueryCriteriaTokenInfo.token_no.value=token;
			var formObjQueryCriteria = parent.frames.f_query_criteria.document.frmDispMedicationQueryCriteria;
			// var len  = formObjQueryCriteria.fill_date_time.length;
			if(formObjQueryCriteria != undefined){
				var obj     =formObjQueryCriteria.OrderingFacility;
				var val ="";
				for(var i=0;i<obj.length;i++) {
					if(obj.options[i].value ==added_facility_id){
						formObjQueryCriteria.OrderingFacility.options[i].selected=true;
					}
				}
			}
		}
	}
}

async function NationalitySeach(target){
	var formObj        = document.frmDispMedicationQueryCriteriaAdditional;	
	var language_id    = formObj.language_id.value;

	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	
	var parNameArray  = new Array() ;
	var parValueArray  = new Array() ;
	parNameArray[0] ="~LOCALE_ID`";
	parValueArray[0]=language_id;
	
	//argumentArray[0]   = formObj.SQL_PH_DISP_MEDICATION_NAT_SEARCH.value+"'"+language_id+"'"+"order by 2";
	argumentArray[0] ="";
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = target.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = CODE_DESC ;
	
	argumentArray[12]  = "SQL_PH_DISP_MEDICATION_NAT_SEARCH";
	argumentArray[13]  = "ePH.Common.PhRepository";
	argumentArray[14]  = parNameArray;
	argumentArray[15]  = parValueArray;
	var retVal = await CommonLookup( getLabel("Common.nationality.label","Common"), argumentArray );
	var str =unescape(retVal);
	var arr = str.split(",");
	if(retVal != null && retVal != "" )  {
		formObj.nationality_name.value		=  arr[1];
		formObj.nationality.value			=  arr[0];	
	}
}

function getResultForPatient(patientIDLength){
	var tokformObj= document.frmDispMedicationQueryCriteriaTokenInfo
	var patient_id = tokformObj.patient_id.value;
	if(patient_id.length == patientIDLength){
		parent.f_query_criteria_buttons.document.frmDispMedicationQueryCriteriaButtons.btnSearch.click();
	}
	tokformObj.patient_id.disabled = false;
	tokformObj.btnPatientID.disabled = false;
	//tokformObj.patient_id.value = "";
}

function loadPatientDRugDtl(criteria_patient_id){
	var patID = document.getElementById("S"+criteria_patient_id);
	if(patID!=undefined)
		patID.click();
}

// Added for ICN-30405  -Start
function setDefaultList(fill_default, deliver_default) {
	if(document.frmDispMedicationLogin.disp_stage.value =="F"){
		document.frmDispMedicationLogin.chk_fill_list.value = fill_default;
		if(fill_default=="AF")
			document.frmDispMedicationLogin.chk_fill_list[0].checked = true;
		else
			document.frmDispMedicationLogin.chk_fill_list[1].checked = true;
	}
	else if(document.frmDispMedicationLogin.disp_stage.value =="D"){
		document.frmDispMedicationLogin.chk_deliver_fill_list.value = deliver_default;
		if(deliver_default=="DWF")
			document.frmDispMedicationLogin.chk_deliver_fill_list[0].checked = true;
		else
			document.frmDispMedicationLogin.chk_deliver_fill_list[1].checked = true;
	}
}
// Added for ICN-30405  -End

// the below method is used for leap year calculation
function CheckDateT(obj, locale){
	if(locale==undefined || locale=='')
		locale=document.frmDispMedicationQueryCriteriaTokenInfo.language_id.value;
	if(obj.value!=""){
		if(!validDate(obj.value, 'DMY',locale)){
			alert(getMessage("INVALID_DATE_FMT", "SM"));
			obj.select();
			obj.focus();
			return false;
		}
	}
	/*else{ // Commented for KAUH-SCF-0183[IN:047989]
		obj.value=convertDate(obj,'DMY',locale,'en');
	}*/
}

//Code Added for RUT-CRF-0067 Start
function validateNoOfPrints(obj, allocQty, allow_label_zero_copy){//allow_label_zero_copy,Added for ML-BRU-SCF-1122 [IN:044833]  
	var noOfPrint = obj.value;
	 if(noOfPrint == "" || parseInt(noOfPrint)==0){
	   if(allow_label_zero_copy!="Y"){//Added if and else if  for ML-BRU-SCF-1122 [IN:044833]
		 alert(getMessage("PH_NO_OF_PRINT_CANNOT_BALNK", "PH"));
		  obj.value = allocQty; //Added for [IN:033288]
		  obj.focus();
		  return false;
	   }
	   else if(noOfPrint=="" ){
			 alert(getMessage("PH_NO_OF_PRINT_CANNOT_BALNK","PH"));
			 obj.value = allocQty; 
			 obj.focus();
			 return false; 
		}
	}
	else{
		if(parseInt(noOfPrint)> parseInt(allocQty) && parseInt(noOfPrint) <1000){
			var contiueYN = confirm(getMessage("PH_NO_OF_PRINTS_GREATER_THAN_DISP_QTY", "PH")); 
			if(!contiueYN){
				obj.value = allocQty; //Added for [IN:033288]
				obj.focus();
				return false;
			}
		}
		if (parseInt(noOfPrint) >999){
			if(parseInt(allocQty) >999){
				var contiueYN = confirm(getMessage("PH_NO_OF_PRINT_MORE_THAN_1000", "PH")); 
				if(!contiueYN){
					obj.value = allocQty; //Added for [IN:033288]
					obj.focus();
					return false;
				}
			}
			else{
				alert(getMessage("PH_NO_OF_PRINT_MORE_THAN_1000", "PH"));
				obj.value = allocQty; //Added for [IN:033288]
				obj.focus();
				return false;
			}
		}   
	}
} 

//Code Added for RUT-CRF-0067 End
function selectTaperOrders(obj,order_id, encIndex, index, recCount,OrderTypeCode ){ // OrderTypeCode added for KAUH-SCF-0061 [IN:034820]
	/*var iv_prep_yn = document.frmDispMedicationOrderDetails.iv_prep_yn.value;  //Commented for RUT-CRF-0088 [IN036978]
	var num_of_orders = parseInt(eval("document.frmDispMedicationOrderDetails.encOrdCount_"+encIndex+'_'+OrderTypeCode).value); //added for KAUH-SCF-0061 [IN:034820]
	//var num_of_orders = parseInt(document.frmDispMedicationOrderDetails.num_of_orders.value); //commented for KAUH-SCF-0061 [IN:034820]
	if(iv_prep_yn =='null' || iv_prep_yn ==''){
		//for(var i=(parseInt(index)+1); i<num_of_orders; i++){
		for(var i=recCount; i<num_of_orders; i++){
			tapered_yn = eval("document.frmDispMedicationOrderDetails.tapered_yn_"+encIndex+"_"+i).value;
			taper_order_id = eval("document.frmDispMedicationOrderDetails.taper_order_id_"+encIndex+"_"+i).value;
			if(tapered_yn=="Y" && taper_order_id ==order_id)
				eval("document.frmDispMedicationOrderDetails.OrderValues_"+encIndex+"_"+index)[i].checked=obj.checked;
		}
	}*/
}

function getApplicableDispStage(disp_locn_catg){ // add this function for  ML-BRU-SCF-0097[31836]
	var formObj = document.frmDispMedicationLogin;
    var disp_locn_code = formObj.disp_locn.value;  
    if(disp_locn_code!=''&& disp_locn_code!=null){
		if(disp_locn_catg=="B"){
			disp_locn_catg = "I";
		}		
		var bean_id   = formObj.bean_id.value;
		var bean_name = formObj.bean_name.value;
		var xmlDoc  = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr += " disp_locn_catg=\"" + disp_locn_catg + "\"";
		xmlStr += " disp_locn_code=\"" + disp_locn_code + "\"";		
		xmlStr += " bean_id=\""+bean_id+"\"";
		xmlStr += " bean_name=\""+bean_name+"\"";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=getDispStageverify",false);
		xmlHttp.send(xmlDoc);
		eval(xmlHttp.responseText);
	}
}

//Code Added For Bru-HIMS-CRF-075 Start
function checkBMSTab(str){ 
	chkBMSTab = str;
	//chkBalanceTab = "true";
}
//Code Added For Bru-HIMS-CRF-075 End


function displayOrdering( order,called_from){
	if(order == 'A')
		order= 'ASC';
	else
		order = 'DESC'
	if(called_from == 'G'){
		var optionValue = document.frmDispMedicationQueryCriteriaIP.customGroupBy.value;
		if(optionValue=='NONE' || optionValue=='PRESCRIPTION_NUMBER'){
			document.getElementById('groupOrderAsc').style.display='none';
			document.getElementById('groupOrderDsc').style.display='none';
			document.getElementById('groupOrderSep').style.display='none';
			document.frmDispMedicationQueryCriteriaIP.customGroupOrder.value='';
		}
		else{
			document.frmDispMedicationQueryCriteriaIP.customGroupOrder.value=order;
			document.getElementById('groupOrderAsc').style='display';
			document.getElementById('groupOrderDsc').style='display';
			document.getElementById('groupOrderSep').style='display';
			if(order =='ASC'){
				document.getElementById('groupOrderAsc').style.color='black';
				document.getElementById('groupOrderAsc').style.cursor='default';
				document.getElementById('groupOrderAsc').style.fontWeight='bolder';

				document.getElementById('groupOrderDsc').style.color='blue';
				document.getElementById('groupOrderDsc').style.cursor='hand';
				document.getElementById('groupOrderDsc').style.fontWeight='normal';
			}
			else if(order=='DESC'){
				document.getElementById('groupOrderAsc').style.color='blue';
				document.getElementById('groupOrderAsc').style.cursor='hand';
				document.getElementById('groupOrderAsc').style.fontWeight='normal';

				document.getElementById('groupOrderDsc').style.color='black';
				document.getElementById('groupOrderDsc').style.cursor='default';
				document.getElementById('groupOrderDsc').style.fontWeight='bolder';
			}
		}
	}
	else if(called_from == 'S'){
		var optionValue = document.frmDispMedicationQueryCriteriaIP.customSortBy.value;
		if(optionValue=='NONE'  || optionValue=='PRESCRIPTION_NUMBER'){
			document.getElementById('sortOrderAsc').style.display='none';
			document.getElementById('sortOrderDsc').style.display='none';
			document.getElementById('sortOrderSep').style.display='none';
			document.frmDispMedicationQueryCriteriaIP.customSortOrder.value='';
		}
		else{
			document.frmDispMedicationQueryCriteriaIP.customSortOrder.value=order;
			document.getElementById('sortOrderAsc').style='display';
			document.getElementById('sortOrderDsc').style='display';
			document.getElementById('sortOrderSep').style='display';
			if(order=='ASC'){
				document.getElementById('sortOrderAsc').style.color='black';
				document.getElementById('sortOrderAsc').style.cursor='default';
				document.getElementById('sortOrderAsc').style.fontWeight='bolder';

				document.getElementById('sortOrderDsc').style.color='blue';
				document.getElementById('sortOrderDsc').style.cursor='hand';
				document.getElementById('sortOrderDsc').style.fontWeight='normal';
			}
			else if(order=='DESC'){
				document.getElementById('sortOrderAsc').style.color='blue';
				document.getElementById('sortOrderAsc').style.cursor='hand';
				document.getElementById('sortOrderAsc').style.fontWeight='normal';

				document.getElementById('sortOrderDsc').style.color='black';
				document.getElementById('sortOrderDsc').style.cursor='default';
				document.getElementById('sortOrderDsc').style.fontWeight='bolder';
			}
		}
	}
}

//Added for ML-MMOH-CRF-1666 start

function displayOrderingOp(order,called_from){
	if(order == 'A')
		order= 'ASC';
	else
		order = 'DESC';
			
	if(called_from == 'G'){
		var optionValue = "NURSING_UNIT";
		if(optionValue=='NONE'){
			document.getElementById('sortOrderAsc').style.display='none';
			document.getElementById('sortOrderDsc').style.display='none';
			document.getElementById('sortOrderSep').style.display='none';
			document.frmDispMedicationQueryCriteria.customSortOrder.value='';
		}
		else{
			document.frmDispMedicationQueryCriteria.customSortOrder.value=order;
			document.getElementById('sortOrderAsc').style='display';
			document.getElementById('sortOrderDsc').style='display';
			document.getElementById('sortOrderSep').style='display';
			if(order=='ASC'){
				document.getElementById('sortOrderAsc').style.color='black';
				document.getElementById('sortOrderAsc').style.cursor='default';
				document.getElementById('sortOrderAsc').style.fontWeight='bolder';

				document.getElementById('sortOrderDsc').style.color='blue';
				document.getElementById('sortOrderDsc').style.cursor='hand';
				document.getElementById('sortOrderDsc').style.fontWeight='normal';
			}
			else if(order=='DESC'){
				document.getElementById('sortOrderAsc').style.color='blue';
				document.getElementById('sortOrderAsc').style.cursor='hand';
				document.getElementById('sortOrderAsc').style.fontWeight='normal';

				document.getElementById('sortOrderDsc').style.color='black';
				document.getElementById('sortOrderDsc').style.cursor='default';
				document.getElementById('sortOrderDsc').style.fontWeight='bolder';
			}
		}
	}
	else if(called_from == 'S'){
		var optionValue = document.frmDispMedicationQueryCriteria.customSortBy.value;
		if(optionValue=='NONE'){
			document.getElementById('sortOrderAsc').style.display='none';
			document.getElementById('sortOrderDsc').style.display='none';
			document.getElementById('sortOrderSep').style.display='none';
			document.frmDispMedicationQueryCriteriaIP.customSortOrder.value='';
		}
		else{
			document.frmDispMedicationQueryCriteria.customSortOrder.value=order;
			document.getElementById('sortOrderAsc').style='display';
			document.getElementById('sortOrderDsc').style='display';
			document.getElementById('sortOrderSep').style='display';
			if(order=='ASC'){
				document.getElementById('sortOrderAsc').style.color='black';
				document.getElementById('sortOrderAsc').style.cursor='default';
				document.getElementById('sortOrderAsc').style.fontWeight='bolder';

				document.getElementById('sortOrderDsc').style.color='blue';
				document.getElementById('sortOrderDsc').style.cursor='hand';
				document.getElementById('sortOrderDsc').style.fontWeight='normal';
			}
			else if(order=='DESC'){
				document.getElementById('sortOrderAsc').style.color='blue';
				document.getElementById('sortOrderAsc').style.cursor='hand';
				document.getElementById('sortOrderAsc').style.fontWeight='normal';

				document.getElementById('sortOrderDsc').style.color='black';
				document.getElementById('sortOrderDsc').style.cursor='default';
				document.getElementById('sortOrderDsc').style.fontWeight='bolder';
			}
		}
	}
}
//Added for ML-MMOH-CRF-1666 end

function changeOrderByDisp(obj,called_from){
	displayOrdering('A',called_from);
	if(called_from=='G'){
		customTabBasedObj= document.frmDispMedicationQueryCriteriaIP.customTabBased;
		customTabBasedObj.checked=false;
		if(obj.value=='NURSING_UNIT'){
			clearSorByList();
			addSortByList('PATIENT_ID',getLabel("Common.patientId.label","Common"),'Y');
			displayOrdering('A','S');
			customTabBasedObj.disabled=true;
		}
		else{
			customTabBasedObj.disabled=false;
			clearSorByList(); 
			//addSortByList('NONE',getLabel("Common.none.label","Common"),'N'); Removed for IN[032898]
			addSortByList('NURSING_UNIT',getLabel("Common.OrderingLocation.label","Common"),'N');
			addSortByList('RELEASE_DATE_TIME',getLabel("ePH.ReleaseDate.label","PH"),'Y');
			addSortByList('PATIENT_ID',getLabel("Common.patientId.label","Common"),'N');
			addSortByList('PRIORITY',getLabel("Common.priority.label","Common"),'N');
			displayOrdering('A','S');
		}
		clickCustomTabBased(customTabBasedObj);
	}
	else if(called_from=='S' && obj.value=='NONE'){
		obj.value = 'RELEASE_DATE_TIME';
		displayOrdering('A','G');
	}
}

//Added for ML-MMOH-CRF-1666 start
function changeOrderByDispOp(obj,called_from){
	displayOrderingOp('A',called_from);
	if(called_from=='G'){
		if(obj.checked==true){
		clearSorByListOp();
		addSortByListOp('PATIENT_ID',getLabel("Common.patientId.label","Common"),'Y');
		displayOrderingOp('A','S');
		}
		else{
			clearSorByListOp();
			addSortByListOp('NURSING_UNIT',getLabel("Common.OrderingLocation.label","Common"),'N');
			addSortByListOp('RELEASE_DATE_TIME',getLabel("ePH.ReleaseDate.label","PH"),'Y');
			addSortByListOp('PATIENT_ID',getLabel("Common.patientId.label","Common"),'N');
			addSortByListOp('PRIORITY',getLabel("Common.priority.label","Common"),'N');
			displayOrderingOp('A','G');
		}
	}
	else if(called_from=='S' && obj.checked==false){
		obj.value = 'RELEASE_DATE_TIME';
		displayOrderingOp('A','G');
	}

}
//Added for ML-MMOH-CRF-1666 end

function clearSorByList(){
	var len =document.frmDispMedicationQueryCriteriaIP.customSortBy.options.length;
	for(var i=0;i<len;i++) {
		document.frmDispMedicationQueryCriteriaIP.customSortBy.remove("customSortBy") ;
	}
}
//added for ML-MMOH-CRF-1666 start
function clearSorByListOp(){
	var len =document.frmDispMedicationQueryCriteria.customSortBy.options.length;
	for(var i=0;i<len;i++) {
		document.frmDispMedicationQueryCriteria.customSortBy.remove("customSortBy") ;
	}
}//Added for ML-MMOH-CRF-1666 end

function addSortByList(code,desc,default_val)	{
	var element = document.createElement('OPTION') ;
	element.value		=  code ;
	element.text		= desc ;
	if(default_val=='Y'){
		element.selected	=	true;
	}
	document.frmDispMedicationQueryCriteriaIP.customSortBy.add(element); 
}

//Added for ML-MMOH-CRF-1666 start
function addSortByListOp(code,desc,default_val)	{
	var element = document.createElement('OPTION') ;
	element.value		=  code ;
	element.text		= desc ;
	if(default_val=='Y'){
		element.selected	=	true;
	}
	document.frmDispMedicationQueryCriteria.customSortBy.add(element); 
}
//Added for ML-MMOH-CRF-1666 end

function clickCustomTabBased(obj){
	if(obj.checked== true){
		obj.value='Y';
		document.getElementById('customTabBasedHrs').style='display';
		document.getElementById('customTabBasedLabel').style='display';
	}
	else{
		obj.value='N';
		document.frmDispMedicationQueryCriteriaIP.customTabBasedHrs.value="";
		document.getElementById('customTabBasedHrs').style.display='none';
		document.getElementById('customTabBasedLabel').style.display='none';
	}
}

function  checkForNumber(obj){
	if(obj.value !='' && isNaN(obj.value)){
		alert(getMessage("INVALID_NUMBER_FORMAT","Common"));
		obj.select();
		obj.focus();
		return false;
	}
}
//Added for RUT-CRF-0036[Inc:29925] Start
async function showLastViewMedication(patient_id,encounter_id){
	
	var dialogHeight	= "28" ;
	var dialogWidth		= "62" ;
	var dialogTop		= "272" ;
	var center			= "1" ;
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "" ;
	retVal				=await window.showModalDialog( "../../ePH/jsp/LastVisitMedicationFrames.jsp?patient_id="+patient_id+"&called_frm=Dispense&encounter_id="+encounter_id, arguments, features );
}//Added for RUT-CRF-0036[Inc:29925] End

async function showDetails(patient_id, order_id,order_line_no){

	var dialogHeight= "400px" ;
	var dialogWidth	= "700px" ;
	var dialogTop = "240" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var retVal =await top.window.showModalDialog("../../ePH/jsp/QueryPatientDrugProfileLocations.jsp?patient_id="+patient_id+"&order_id="+order_id+"&order_line_no="+order_line_no,arguments,features);
}

/* below code added for ML-BRU-SCF-0340[IN:034556] -- Start */ 
function tokenToGetFacility(formObj){
	var token_no	= formObj.token_no.value;
	if( token_no != null && token_no !=""){
		var bean_id		= formObj.bean_id.value ;
		var bean_name	= formObj.bean_name.value ;
		var token_series= formObj.token_series.value;		
		var language_id = formObj.language_id.value;
		var queue_date  = formObj.queue_date.value;
		queue_date	    = convertDate(queue_date,"DMY",language_id,"en");
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr += " bean_id=\"" + bean_id + "\"";
		xmlStr += " bean_name=\"" + bean_name + "\"";
		xmlStr += " token_series=\"" + token_series + "\"";
		xmlStr += " token_no=\"" + token_no + "\"";	
		xmlStr += " queue_date=\"" + queue_date + "\"";
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=tokenToGetFacility", false ) ;
		xmlHttp.send( xmlDoc ) ;
		eval(xmlHttp.responseText);	
	}       	  
 }

 function setorderingfacilitytotoken(facility_name){
	 if(parent.f_query_criteria.frmDispMedicationQueryCriteria != undefined)
		parent.f_query_criteria.frmDispMedicationQueryCriteria.OrderingFacility.value = facility_name;   
 }
/* code added for ML-BRU-SCF-0340[IN:034556] -- End */ 
// added for Bru-HIMS-CRF-076 [IN029942] - start
 async function callQMSToken(recIndex, token_nos){
	var tockFormObj	=	parent.parent.parent.document.f_query_criteria_token_info.frmDispMedicationQueryCriteriaTokenInfo;	
	var bean_id		= "DispMedicationBean";
	var bean_name	= "ePH.DispMedicationBean";
	var token_no= tockFormObj.token_no.value;	
	if(token_no == '')
		token_no = token_nos;
	if(token_nos.indexOf('~')>-1){ //if block added for ML-BRU-SCF-0786 [IN:039204]
		var dialogHeight= "10" ;
		var dialogWidth	= "20" ;
		var dialogTop = "195" ;
		var center = "1" ;
		var status="no";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "" ;
		token_no =await window.showModalDialog("../../ePH/jsp/DispMedicationCallQMSToken.jsp?token_nos="+token_nos,arguments,features);
		if(token_no == undefined || token_no ==''){
			return false;
		}
	}
	var language_id = tockFormObj.language_id.value;
	var queue_date  = tockFormObj.queue_date.value;
	queue_date	    = convertDate(queue_date,"DMY",language_id,"en");
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr += " bean_id=\"" + bean_id + "\"";
	xmlStr += " bean_name=\"" + bean_name + "\"";
	xmlStr += " token_no=\"" + token_no + "\"";	
	xmlStr += " recIndex=\"" + recIndex + "\"";	
	xmlStr += " queue_date=\"" + queue_date + "\"";
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=CALLQMSTOEKN", false ) ;
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);	
}

function selectToken(){	//added for ML-BRU-SCF-0786 [IN:039204]
	window.returnValue="";
	var formObj = document.frmTokensToCallQMS;
	var tokens = formObj.callToken;
	for(i=0; i<tokens.length;i++){
		if(tokens[i].checked==true){
			window.returnValue =tokens[i].value;
			break;
		}
	}
	//window.close(); 
	parent.document.getElementById('dialog_tag').close(); 
}

function assignQMSResult(QMSstatus, QMStiket, QMSerrors, recIndex){
	var msg;
	var continue_YN;
	if(QMSstatus =='1'){
		var msg = getMessage("PH_QMS_ERROR_DELIVER","PH") ;
		msg = msg.replace('$', QMSerrors);
		continue_YN = confirm(msg)
	}
	if( continue_YN || QMSstatus=='0'){
		document.getElementById('patient_id_label'+recIndex).click();
	}
}
// added for Bru-HIMS-CRF-076 [IN029942] - end
// added for Bru-HIMS-CRF-142 [IN:030195] - start
async function storageLocation(obj,curr_stage,patient_id,patient_arvd,mode,storage_locn_appl_yn,ordering_facility_id,delivery_bin_yn,encounter_id){// ordering_facility_id added for ML-BRU-SCF-0792 [IN:039236] delivery_bin_yn ADDED FOR TH-KW-CRF-0020.9
	if(obj.checked == true){
		if(mode == '2'){
			confirm_message = confirm("Do you want to update with current time");
		}
		if((mode == '1') ||((mode == '2') && confirm_message==true)){
			var formObj = parent.parent.parent.document.f_query_criteria_token_info.frmDispMedicationQueryCriteriaTokenInfo;
			var token_series = formObj.token_series.value;
			var dialogHeight= "10" ;
			var dialogWidth	= "20" ;
			var dialogTop = "195" ;
			var center = "1" ;
			var status="no";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
			var arguments	= "" ;
			retVal =await window.showModalDialog("../../ePH/jsp/DispMedStorageLocation.jsp?curr_stage="+curr_stage+"&token_series="+token_series+"&patient_arvd="+patient_arvd+"&patient_id="+patient_id+"&storage_locn_appl_yn="+storage_locn_appl_yn+"&ordering_facility_id="+ordering_facility_id+"&delivery_bin_yn="+delivery_bin_yn+"&encounter_id="+encounter_id,arguments,features);// ordering_facility_id added for ML-BRU-SCF-0792 [IN:039236]delivery_bin_yn,encounter_id added for TH_KW_CRF-0020.9
			parent.parent.parent.frames[2].frmDispMedicationQueryCriteriaButtons.btnSearch.click();
		}
	}
}

function updateStorageLocation(frmObj,token_series,patient_id,patient_arvd,encounter_id,delivery_bin_yn){//encounter_id,delivery_bin_yn added for TH-KW-CRF-0020.9
	var xmlStr ="<root><SEARCH ";
	xmlStr+= "bean_id  =\"" + frmObj.bean_id_2.value + "\" " ;
	xmlStr+= "bean_name =\"" + frmObj.bean_name_2.value + "\" " ;
	xmlStr+= "str_locn=\"" + frmObj.storage_locn.value + "\" " ;
	xmlStr+= "disp_locn_code=\"" + frmObj.disp_locn_code.value + "\" " ;
	xmlStr+= "curr_stage=\"" + frmObj.curr_stage.value + "\" " ;
	xmlStr+= "token_series=\"" + token_series + "\" " ;
	xmlStr+= "patient_arvd=\"" + patient_arvd + "\" " ;
	xmlStr+= "patient_id=\"" + patient_id + "\" " ;
	xmlStr+= "encounter_id=\"" + encounter_id + "\" " ;//Added for TH-KW-CRF-0020.9
	xmlStr+= "delivery_bin_yn=\"" + delivery_bin_yn + "\" " ;//Added for TH-KW-CRF-0020.9
	xmlStr +=" /></root>";
	var temp_jsp="DispMedicationValidation.jsp?func_mode=storage_locn";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,true);
	xmlHttp.send(xmlDoc);
	//window.close();
	parent.document.getElementById('dialog_tag').close(); 
}
// Added for Bru-HIMS-CRF-142 [IN:030195] - end
/*function callDMSLink(){ //added for RUT-CRF-0083.5 [IN:041511]

	var patient_id			=document.frmDispMedicationQueryCriteriaButtons.patient_id_DMSLink.value;  
	if(patient_id==''){
		alert("APP-PH0665 Please select a patient to proceed.");
		//alert(getMessage("PH_SELECT_PATIENT_FOR_DMS_LINK","PH"));
		return false;
	}
	var episod_id			=document.frmDispMedicationQueryCriteriaButtons.episode_id_DMSLink.value;  
	var patient_clss	= document.frmDispMedicationQueryCriteriaButtons.patient_class_DMSLink.value; 
	var facily_id			=document.frmDispMedicationQueryCriteriaButtons.Ordering_Facility_id_DMSLink.value; 
	var language_id			=document.frmDispMedicationQueryCriteriaButtons.locale.value;
	var login_user			=document.frmDispMedicationQueryCriteriaButtons.login_user.value;
	var current_locn	 	 ="";
	var resp_id			 ="";
	var module_id			='PH'; 
	var appt_date			="";
	var order_id			="";
	var surgeon_code	    ='';
	var encounter_date		=""; 
	var accession_num 		= "";
	var order_type_code		="";
	var locn_type			="";
	var cust_code			="";
	var item_code			="";
	var inv_org_id			="";
	var function_id			="";
	var access_rights		="";
	var multi_site_yn		="";
	var multi_lang_yn		="";
	var ws_no				="";
	var ext_input_key		="";
	var ext_application_id	="";
	var dms					="";
	var ext_function		="";
	var view				="";
	var pwd					="";
	var connect_string		="";
		
	var param="P_USE_ID="+login_user+"&P_PATIENT_ID="+patient_id+"&P_ORDER_ID="+order_id+"&P_LOCN_CODE="+current_locn+"&P_PHYSICIAN_ID="+surgeon_code+"&P_FACILITY_ID="+facily_id+"&P_RESP_ID="+resp_id+"&P_MODULE_ID="+module_id+"&P_ENCNTR_DATE="+encounter_date+"&P_EPISODE_TYPE="+patient_clss+"&P_EPISODE_ID="+episod_id+"&P_ACCESSION_NUM="+accession_num+"&P_ORDER_TYPE_CODE="+order_type_code+"&P_LOCN_TYPE="+locn_type+"&P_CUST_CODE="+cust_code+"&P_ITEM_CODE="+item_code+"&P_INV_ORG_ID="+inv_org_id+"&P_FUNCTION_ID="+function_id+"&P_ACCESS_RIGHTS="+access_rights+"&P_LANGUAGE_ID="+language_id+"&P_MULTI_SITE_YN="+multi_site_yn+"&P_MULTI_LANG_YN="+multi_lang_yn+"&P_WS_NO="+ws_no+"&P_Ext_Input_Key="+ext_input_key+"&P_Ext_Application_ID="+ext_application_id+"&DMS="+dms+"&P_Ext_Function="+ext_function+"&VIEW="+view+"&P_pwd="+pwd+"&P_Connect_string="+connect_string;
	
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	var temp_jsp ="../../eXH/jsp/XHExternalLink.jsp?"+param;
	var xmlDoc   = new ActiveXObject( "Microsoft.XMLDom" ) ;
	var xmlHttp  = new ActiveXObject( "Microsoft.XMLHTTP" ) ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=trimString(xmlHttp.responseText); 
}*/

function displayDMSLink(display_dms_link_yn){ //added for RUT-CRF-0083.5
	display_dms_link_yn='Y';
	document.frmDispMedicationQueryCriteriaButtons.patient_id_DMSLink.value="";  
	document.frmDispMedicationQueryCriteriaButtons.episode_id_DMSLink.value="";  
	document.frmDispMedicationQueryCriteriaButtons.patient_class_DMSLink.value=""; 
	document.frmDispMedicationQueryCriteriaButtons.Ordering_Facility_id_DMSLink.value=""; 
	if(display_dms_link_yn=='Y'){
		document.getElementById('lblDMSLink').style.visibility='visible';
	}
	else
		document.getElementById('lblDMSLink').style.visibility='hidden';
}
	
function assignSelectedPatDet(patient_id,episode_id, patient_class,Ordering_Facility_id){ //added for RUT-CRF-0083.5
	var formObj = parent.parent.parent.f_query_criteria_buttons.document.frmDispMedicationQueryCriteriaButtons
	formObj.patient_id_DMSLink.value=patient_id;  
	formObj.episode_id_DMSLink.value=episode_id;  
	formObj.patient_class_DMSLink.value=patient_class; 
	formObj.Ordering_Facility_id_DMSLink.value=Ordering_Facility_id; 
	parent.parent.parent.f_query_criteria_buttons.document.getElementById('imgDMSLink').title = getLabel("ePH.ExternalDocumentLink.label","PH")+"\n"+patient_id+" - "+episode_id
}
function ok_enter_event(e, obj){ //Added for AMS-CRF-0009[IN:030935]
	if(e.keyCode==13 || e.keyCode==32){
		obj.click();
	}
	else{
		var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_';
		var whichCode = (window.Event) ? event.which : event.keyCode;
		key = String.fromCharCode(whichCode);  // Get key value from key code
		if (strCheck.indexOf(key) == -1){
			return event.returnValue=false;
		}
		else{
			return true ;
		}
	}
}

function MinimizeDrugProfile(callFrom){//Added for Bru-HIMS-CRF-081 [IN:029947]- Start
	if(callFrom=='C'){
		if(parent.parent.parent.DispMedicationPatDetFrame_3!=undefined)
			parent.parent.parent.DispMedicationPatDetFrame_3.dispmednframeset2.cols="100%,0%";
	}
	else if(callFrom=='T'){
		if(parent.parent.parent.parent.DispMedicationPatDetFrame_3!=undefined)
			parent.parent.parent.parent.DispMedicationPatDetFrame_3.dispmednframeset2.cols="100%,0%";
	}
}

async function MaxDrugProfile(patient_id, disp_locn_code, pat_class, callFrom,ReqDb,enc_id1,called_from){//,ReqDb,enc_id1,called_from added for MMS-DM-CRF-115.4
	MinimizeDrugProfile(callFrom);
	var dialogHeight	= "90vh" ;
	var dialogWidth		= "90vw" ;
	var dialogTop		= "100" ;
	var center			= "1" ;
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "" ;
	retVal				=await window.showModalDialog( "../../ePH/jsp/QueryPatientDrugProfileFrames.jsp?patient_id="+patient_id+"&called_frm=DispenseMax&disp_locn_code="+disp_locn_code+"&pat_class="+pat_class+"&RepDb="+ReqDb+"&enc_id1="+enc_id1+"&called_from="+called_from, arguments, features );//,ReqDb,enc_id1,called_from added for MMS-DM-CRF-115.4
}//Added for Bru-HIMS-CRF-081 [IN:029947]- End
function callDispCurrEncFinDtlVal(patient_id,encounter_id){//code added for JD-CRF-0156[IN041737]--Start
	var formObj = document.formSalesHeader;	
	var store_code=formObj.store_code.value;
	var pat_class=document.getElementById("pat_class").innerText;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eST/jsp/SalesValidate.jsp?patient_id=" + patient_id + "&validate=VAL_DISPFINDTL&encounter_id=" +encounter_id+"&pat_class="+pat_class+"&store_code=" + store_code , false); 
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);  
}

function displayFinancialDtlIcon(patient_id, episode_id, visit_id, policyValid){
	parent.patient_details.document.getElementById("imgFinDtl");
	parent.patient_details.document.getElementById('imgFinDtl').style='display';
	parent.patient_details.document.frmPatientDetails.patient_id.value = patient_id;
	parent.patient_details.document.frmPatientDetails.episode_id.value = episode_id;
	parent.patient_details.document.frmPatientDetails.visit_id.value = visit_id;
	if(policyValid==false || policyValid=='false'){
		parent.patient_details.document.getElementById('policy_exp').style.visibility='visible';
	}
}

function callFinancialDetailScreen() {   
	patient_id = document.frmPatientDetails.patient_id.value;
	episodeid = document.frmPatientDetails.episode_id.value;
	visitid = document.frmPatientDetails.visit_id.value;
	ViewBLDtl(episodeid,visitid,patient_id);
	/*var visitid ="";
	var retVal       =  new String();
	var episode1     ="";
	var dialogTop    = "200";
	var dialogHeight = "42" ; 
	var dialogWidth  = "70" ; 
	var features     = "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments    = "" ;
	var search_desc  =""; 
	var title   =getLabel("eBL.PAT_ENCOUNTER_FIN_DTLS.label","BL");
	var column_sizes = escape("");               
	var column_descriptions ="";       
	var param =            "title="+title+"&column_sizes="+column_sizes+"&column_descriptions="+column_descriptions+"&episodeid="+	episodeid+"&visitid="+visitid+"&patientid="+patient_id+"&episode1="+episodeid;
	retVal=window.showModalDialog("../../eBL/jsp/BLFinDtlQryMain.jsp?"+param,arguments,features);*/
} 

function fetchRecord(obj){//Added for JD-CRF-0181 [IN:045355] - Start
	if(parent.f_query_criteria_buttons!=null && obj.value!=""){
		parent.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.btnSearch.click();	
		parent.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.btnSearch.focus();
	}
}//Added for JD-CRF-0181 [IN:045355] - End

function changeOrientation (homeMedOrientationObj){
	var printOption = "";
	//Modified for RUT-SCF-0363[IN46717] - Start
	var defPrintStatusLS = document.DispMedicationPrintDialog.defPrintStatusLS.value;
	var defPrintStatusPT = document.DispMedicationPrintDialog.defPrintStatusPT.value;
	if(homeMedOrientationObj.value=='B'){
		if(defPrintStatusLS == 'PD' || defPrintStatusPT =='PD')
			printOption = "PD";
		else
			printOption = "";
	}
	else if(homeMedOrientationObj.value=='L'){
		var printOption = document.DispMedicationPrintDialog.defPrintStatusLS.value;
	}
	else if(homeMedOrientationObj.value=='P'){
		var printOption = document.DispMedicationPrintDialog.defPrintStatusPT.value;
	}
	if(printOption=='PD'){
		if(document.DispMedicationPrintDialog.medn_include != undefined){
			document.DispMedicationPrintDialog.medn_include.value="I";
			document.DispMedicationPrintDialog.medn_include.checked=true;
		}
		if(document.DispMedicationPrintDialog.medn_separate != undefined){
			document.DispMedicationPrintDialog.medn_separate.value="S";
			document.DispMedicationPrintDialog.medn_separate.checked=true;
		}
		if(document.DispMedicationPrintDialog.medn_only != undefined){
			document.DispMedicationPrintDialog.medn_only.value="O";
			document.DispMedicationPrintDialog.medn_only.checked=true;
		}
	}
	else{
		if(document.DispMedicationPrintDialog.medn_include != undefined){
			document.DispMedicationPrintDialog.medn_include.value="";
			document.DispMedicationPrintDialog.medn_include.checked=false;
		}
		if(document.DispMedicationPrintDialog.medn_separate != undefined){
			document.DispMedicationPrintDialog.medn_separate.value="";
			document.DispMedicationPrintDialog.medn_separate.checked=false;
		}
		if(document.DispMedicationPrintDialog.medn_only != undefined){
			document.DispMedicationPrintDialog.medn_only.value="";
			document.DispMedicationPrintDialog.medn_only.checked=false;
		}
		//Modified for RUT-SCF-0363[IN46717] - End
	}
}

function ShowHideCriteria(obj,disp_stage,fill_list,disp_locn_catg){ //code added for Bru-HIMS-CRF-416[IN045566]-- Start
	 var formObj = document.frmDispMedicationQueryCriteriaButtons;
	if(disp_locn_catg=="O"){			
		if(obj.value==getLabel("ePH.ShowCriteria.label","PH")){  	
			showCriteria(obj);		
			obj.value=getLabel("ePH.HideCriteria.label","PH"); 
			formObj.btnAdditionalCriteria.disabled = false;		
		}
		else if(obj.value==getLabel("ePH.HideCriteria.label","PH")){ 
			try{parent.f_query_criteria.document.getElementById('row1').style.display="none";}catch(e){}
			try{parent.f_query_criteria.document.getElementById('row2').style.display="none";}catch(e){}
			try{parent.f_query_criteria.document.getElementById('row3').style.display="none";}catch(e){}
			try{parent.f_query_criteria.document.getElementById('row4').style.display="none";}catch(e){}
			try{parent.f_query_criteria.document.getElementById('row5').style.display="none";}catch(e){} 
			try{parent.f_query_criteria.document.getElementById('row6').style.display="none";}catch(e){}
			//parent.document.DispMedicationQueryCriteriaFrameSet.rows= "0,20,20,0,365"; 
			
			parent.document.getElementById("f_query_criteria_token_info").style.height="0vh";
			parent.document.getElementById("f_query_criteria").style.height="6vh";
			parent.document.getElementById("f_query_criteria_buttons").style.height="5vh";
			parent.document.getElementById("f_query_criteria_additional").style.height="0vh";
			parent.document.getElementById("f_query_result").style.height="70vh";
			
			
			obj.value=getLabel("ePH.ShowCriteria.label","PH");
			formObj.btnAdditionalCriteria.style.display="none";
		}
	}
	else{
		var formObjIP = parent.f_query_criteria.frmDispMedicationQueryCriteriaIP;
		var formObjFrame = parent.document.DispMedicationQueryCriteriaFrameSet;					 
		if(obj.value==getLabel("ePH.ShowCriteria.label","PH")){  
			var formObjButtons =parent.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons;
			parent.f_query_criteria.document.getElementById('row1').style="display";
			parent.f_query_criteria.document.getElementById('row2').style="display";
			parent.f_query_criteria.document.getElementById('row3').style="display";
			parent.f_query_criteria.document.getElementById('row4').style="display";
			if(fill_list!="AF")
			{
				//formObjIP.row5.style="display";
				//formObjIP.row6.style="display";    //Added for KDAH-CRF-0338
				parent.f_query_criteria.document.getElementById('row5').style="display";
				parent.f_query_criteria.document.getElementById('row6').style="display";
			}
			formObjButtons.btnAdditionalCriteria.style="display";
			//formObjFrame.rows="0,150,30,0,*"; //0,135,*,0,0 --> 0,135,30,0,* for for Bru-HIMS-CRF-416[IN045566]	// 0,135,30,0,* changed to 0,150,30,0,* for KDAH-CRF-0338
			parent.document.getElementById("f_query_criteria_token_info").style.height="0vh";
			parent.document.getElementById("f_query_criteria").style.height="29vh";
			parent.document.getElementById("f_query_criteria_buttons").style.height="5vh";
			parent.document.getElementById("f_query_criteria_additional").style.height="0vh";
			parent.document.getElementById("f_query_result").style.height="67vh";
			
			
			obj.value=getLabel("ePH.HideCriteria.label","PH"); 
			formObj.btnAdditionalCriteria.disabled = false;	
			//parent.f_query_result.DispMedicationPatFrame.location.href="../../eCommon/html/blank.html"; //commented for Bru-HIMS-CRF-416[IN045566]
		}			
		else if(obj.value==getLabel("ePH.HideCriteria.label","PH")){ 
			parent.f_query_criteria.document.getElementById('row1').style.display="none";
			parent.f_query_criteria.document.getElementById('row2').style.display="none";
			parent.f_query_criteria.document.getElementById('row3').style.display="none";
			parent.f_query_criteria.document.getElementById('row4').style.display="none";
			if(fill_list!="AF")
			{
				//formObjIP.row5.style.display="none";
				//formObjIP.row6.style.display="none";	//Added for KDAH-CRF-0338
				parent.f_query_criteria.document.getElementById('row5').style.display="none";
				parent.f_query_criteria.document.getElementById('row6').style.display="none";
			}
			//formObjFrame.rows= "0,20,20,0,365";
			parent.document.getElementById("f_query_criteria_token_info").style.height="0vh";
			parent.document.getElementById("f_query_criteria").style.height="6vh";
			parent.document.getElementById("f_query_criteria_buttons").style.height="5vh";
			parent.document.getElementById("f_query_criteria_additional").style.height="0vh";
			parent.document.getElementById("f_query_result").style.height="100vh";
			obj.value=getLabel("ePH.ShowCriteria.label","PH");
			formObj.btnAdditionalCriteria.style.display="none";			
		}
	}
} 

async function showReleaseBatch(patient_id,disp_locn_code){//Added for Bru-HIMS-CRF-416--start
	var disp_locn_catg = parent.parent.parent.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.disp_locn_catg.value;
	var formObj = "";
	var from_date;
	var to_date;
	var Agdate;
	if(disp_locn_catg=="O"){
		formObj=parent.parent.parent.f_query_criteria.document.frmDispMedicationQueryCriteria;
	}
	else {
		formObj=parent.parent.parent.f_query_criteria.document.frmDispMedicationQueryCriteriaIP;   
	}
	if(formObj.order_date_from!=undefined && formObj.order_date_to!=undefined){
		from_date= formObj.order_date_from.value
		to_date = formObj.order_date_to.value
	}
	if(formObj.fill_date_time!=undefined){
		Agdate=formObj.fill_date_time.value;
		from_date = Agdate;
		to_date = Agdate;
	}

	var frompage="dispmed";
	var dialogHeight	= "48" ;
	var dialogWidth		= "80" ;
	var dialogTop		= "100" ;
	var center			= "1" ;
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "" ;
	retVal				=await window.showModalDialog( "../../ePH/jsp/ReleaseBatches.jsp?&patient_id="+escape(patient_id)+"&frompage="+frompage+"&disp_locn_code="+disp_locn_code+"&from_date="+from_date+"&to_date="+to_date, arguments, features );
	if(retVal!=null && retVal!=undefined){
		var retvalarray = retVal.split("~");
		if(retvalarray[0]=="dispmed" && retvalarray[2]=="true"){
			parent.parent.parent.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.btnSearch.click();
		 }
		else{
			var bean_id		= "DispMedicationBean";
			var bean_name	= "ePH.DispMedicationBean";
			var xmlDoc  = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=clearOrders",false);
			xmlHttp.send( xmlDoc ) ;
		}
  	}
	else{
		var bean_id		= "DispMedicationBean";
		var bean_name	= "ePH.DispMedicationBean";
		//var xmlDoc  = new ActiveXObject( "Microsoft.XMLDom" ) ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=clearOrders",false);
		xmlHttp.send( xmlDoc ) ;
	}
}

function clickPatient(){
	var formObj		= document.frmDispMedicationPatientIDDisplay;
	var relflag;
	var ptindex;
	if(formObj.ptindex!=undefined)
	 ptindex= formObj.ptindex.value;
	if(formObj.relflag!=undefined)
	 relflag  = formObj.relflag.value;
	var bean_id		= "DispMedicationBean";
	var bean_name	= "ePH.DispMedicationBean";
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=clearOrders",false);
	xmlHttp.send( xmlDoc ) ;
	if(relflag!=undefined && relflag.length!=0 && relflag=="releasebatch"){
		eval("formObj.patient_id_label"+ptindex).click();
	}
}//Added for Bru-HIMS-CRF-416--end

function callDrugDetails(patient_id,order_id,drug_code,alt_drug,alt_drug_code,drug_color,form_code){ // Dummy method added for MMS-SCF-0306.1
}

function getDefaultDispStage(){ // Added for [IN:047788]
	var formObj = document.frmDispMedicationLogin;
    var disp_locn_code = formObj.disp_locn.value;
    var disp_locn_category = formObj.disp_locn_category.value;

    if(disp_locn_code!=''&& disp_locn_code!=null){
		var bean_id   = formObj.bean_id.value;
		var bean_name = formObj.bean_name.value;
		var xmlDoc  = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr += " disp_locn_catg=\"" + disp_locn_category + "\"";
		xmlStr += " disp_locn_code=\"" + disp_locn_code + "\"";
		xmlStr += " bean_id=\""+bean_id+"\"";
		xmlStr += " bean_name=\""+bean_name+"\"";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	
		xmlHttp.open("POST","DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=getDefaultDispStage",false);
		xmlHttp.send( xmlDoc ) ;
		eval(xmlHttp.responseText);
	}
}
function assignDefaultDispStage(stage){	// Added for [IN:047788]
	var formObj = document.frmDispMedicationLogin;
	if(stage=="VF")
		formObj.disp_stage.value = 'V';
	else if(stage=="AL")
		formObj.disp_stage.value = 'A';
	else if(stage=="FL")
		formObj.disp_stage.value = 'F';
	else if(stage=="DL")
		formObj.disp_stage.value = 'D';
	formObj.disp_stage.selected = true;
}

function DateLegendChange(ip_scopeObj, filter_on_next_fill_date){ //Added for ML-BRU-SCF-1380 [IN:049774]
	if(filter_on_next_fill_date=='Y' && ip_scopeObj.value=='R'){
		document.getElementById('dateLegend').innerHTML = getLabel("ePH.NextFillDate.label","PH")+" "+getLabel("Common.from.label","Common"); 
	}
	else{
		document.getElementById('dateLegend').innerHTML = getLabel("Common.Period.label","Common")+" "+getLabel("Common.from.label","Common"); 
	}
}

async function show_patinstructions(appt_no,patient_id){ //function added for ML-BRU-SCF-1387[IN049916] 
	var dialogHeight = "25" ;
	var dialogWidth	= "40" ;
	var dialogTop = "100" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var retVal = await window.showModalDialog("../../ePH/jsp/PHQueryApptForPatientInstruction.jsp?appt_refno="+appt_no+"&patient_id="+patient_id,arguments,features);	
}
async function request(){ ///Added AMS-CRF-0068.1 [IN:050333] start 
	var formObj = document.DispMedicationAllStages;
	var disp_locn_code = formObj.disp_locn_code.value;
	var dialogHeight= "90vh" ;
	var dialogWidth	= "95vw" ;
	var dialogTop = "10" ;
	//var dialogLeft = "200";
	var MODE_INSERT="1";
	var center = "1" ;
	var status="no";
	var function_id="ST_REQUEST";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var function_name = "Create/Review Request";	 
	var retVal =await top.window.showModalDialog("../../eST/jsp/Request.jsp?mode="+MODE_INSERT+"&function_id="+function_id+"&function_name="+function_name+"&function_type=F"+"&home_required_yn=N"+"&access=NYNNN"+"&store_code="+disp_locn_code+"&sales_req_yn=Y",arguments,features);
	window.close();
	chk_req_flag = "true";
	await restoreToolbar();
}

function restoreToolbar(){
	if(chk_req_flag == "true"){
		var bean_id = "DispMedicationBean";
		var bean_name = "ePH.DispMedicationBean";
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "DispMedicationValidate.jsp?identity=toolBar&"+toolBarString+"&bean_id="+bean_id+"&bean_name="+bean_name, false ) ;
		xmlHttp.send(xmlDoc);
		eval(xmlHttp.responseText);
		return true;
	}//end
}

async function callDiscCancelledOrders(disc_cancelled_orders, drug_name){ //Added for HSA-CRF-0138 [IN:048414]
	var dialogHeight	= '30vh' ;
	var dialogWidth		= "90vw";
	var dialogTop		= "10" ;
	var dialogLeft		= "10" ;
	var center			= "0" ;
	var status			="no";
	var features	= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";
	var retVal=await top.window.showModalDialog("../../ePH/jsp/DiscCancelledDrugDetailsDisplay.jsp?disc_cancelled_orders="+encodeURIComponent(disc_cancelled_orders,'UTF-8')+"&drug_name="+drug_name,arguments,features);
}

async function callManufacturingReceipt(drug_code,store_code){ // Added for Bru-HIMS-CRF-080[IN:029946]
	var dialogHeight= "90vh" ;
	var dialogWidth	= "90vw" ;
	var dialogTop = "10" ;
	var MODE_INSERT="1";
	var center = "1" ;
	var status="no";
	var function_id="ST_MANUFACTURING_RECEIPTS";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var function_name = "Manufacturing";	 
	var retVal =await top.window.showModalDialog("../../eST/jsp/ManufacturingReceipts.jsp?mode="+MODE_INSERT+"&function_id="+function_id+"&function_name="+function_name+"&item_code="+drug_code+"&store_code="+store_code+"&function_type=F&home_required_yn=N&access=NYNNN&mfg_req_yn=Y",arguments,features);
	if(retVal == 'OK'){
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlHttp.open( "POST", "DispMedicationValidate.jsp?identity=setStockItem&drug_code="+drug_code, false ) ;
		xmlHttp.send(xmlDoc);
		eval(xmlHttp.responseText);
		parent.window.location.reload();
	}
}

function disablePrintRep(){//added for MO-GN-5434 (BMS in print dailog when allocate qty is zero)
	if(parent.printSelectFrame.document.getElementById("printReport") != null && parent.printSelectFrame.document.getElementById("printReport") !=undefined)
		parent.printSelectFrame.document.getElementById("printReport").style.display = "none";
	if(parent.printSelectFrame.document.getElementById('enableTab')!= null && parent.printSelectFrame.document.getElementById('enableTab')!= undefined)
		parent.printSelectFrame.document.getElementById('enableTab').click();
}


async function showReturnMedication(patient_id,disp_locn_code, disp_locn_catg){//added for MMS-QH-CRF-0201 [IN:052255] -start
	var disp_locn_catg = parent.parent.parent.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.disp_locn_catg.value;
	var formObj = "";
	var from_date;
	var to_date;
	var Agdate;
	if(disp_locn_catg=="O"){
		formObj=parent.parent.parent.f_query_criteria.document.frmDispMedicationQueryCriteria;
	}
	else {
		formObj=parent.parent.parent.f_query_criteria.document.frmDispMedicationQueryCriteriaIP;   
	}
	if(formObj.order_date_from!=undefined && formObj.order_date_to!=undefined){
		from_date= formObj.order_date_from.value
		to_date = formObj.order_date_to.value
	}
	if(formObj.fill_date_time!=undefined){
		Agdate=formObj.fill_date_time.value;
		from_date = Agdate;
		to_date = Agdate;
	}
	var frompage="dispmed";
	var dialogHeight	= "48" ;
	var dialogWidth		= "80" ;
	var dialogTop		= "100" ;
	var center			= "1" ;
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= getLabel("ePH.ReturnMedication.label","PH") ;
	retVal				=await window.showModalDialog( "../../ePH/jsp/ReturnMedicationFrames.jsp?patientcat="+disp_locn_catg+"&dispLocn="+disp_locn_code+"&homepage="+frompage+"&patient_id="+patient_id, arguments, features );
	//retVal				= window.showModalDialog( "../../ePH/jsp/ReleaseBatches.jsp?&patient_id="+escape(patient_id)+"&frompage="+frompage+"&disp_locn_code="+disp_locn_code+"&from_date="+from_date+"&to_date="+to_date, arguments, features );

}

function checkReturnAccess(disp_locn_code){//added for MMS-QH-CRF-0201 [IN:052255] -start
	var retVal = "";
	var bean_id		= "DispMedicationBean";
	var bean_name	= "ePH.DispMedicationBean";
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "DispMedicationValidate.jsp?identity=getRightsForReturnMed&disp_locn_code="+disp_locn_code+"&bean_id="+bean_id+"&bean_name="+bean_name, false ) ;
	xmlHttp.send(xmlDoc);
	retVal = eval(xmlHttp.responseText);
	if(retVal=="Y")
		return true;
	else
		return false;
}
//added for GHL-CRF-0453 - start
function printPresAllocateAndFill(disp_stage,iv_prep_yn){
//alert("disp_stage==>"+disp_stage+"==iv_prep_yn===>"+iv_prep_yn);
		if(disp_stage=="A" ){
			if(parent.f_stage==undefined){
				var formObj = parent.f_disp_medication_allocation.DispMedicationAllStages;
			}
			else{
				var formObj = parent.f_stage.DispMedicationAllStages;
			}
		}
		else if(iv_prep_yn=="0" || iv_prep_yn=="2" ||iv_prep_yn=="4"||iv_prep_yn=="6"){	
			if(parent.f_stage==undefined){
				if(parent.f_disp_medication_allocation==null)
					var formObj = parent.f_disp_medication_filling.DispMedicationAllStages;
				else
					var formObj = parent.f_disp_medication_allocation.DispMedicationAllStages;
			}
			else{
				 var formObj = parent.f_stage.DispMedicationAllStages;
			}
		}
		else{
			if(parent.f_stage==undefined){
				var formObj = parent.f_disp_medication_filling.DispMedicationAllStages;
			}
			else{
				var formObj = parent.f_stage.DispMedicationAllStages;
			}
		}
		var tot_num_of_drugs=formObj.tot_rec.value;
		var print_allow_flag	=	false;
		for(var i=1;i<parseInt(tot_num_of_drugs);i++){
		if(eval("formObj.print_"+i).checked==true){
			print_allow_flag = true;
			break;
		 }
	 
		}
	 if(print_allow_flag==false){
			alert(getMessage("PH_ATLEAST_ONE_SELECTED","PH"));
			 return false;
		 }
		var bean_id = "DispMedicationAllStages";
		var bean_name = "ePH.DispMedicationAllStages";

		//bean_id				=	formObj.bean_id.value;
		//bean_name			=	formObj.bean_name.value;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		var xmlStr ="<root><SEARCH ";
			xmlStr += " bean_id=\""+bean_id+"\"";
			xmlStr += " bean_name=\""+bean_name+"\"";
			xmlStr += " patient_id=\""+formObj.patient_id.value+"\"";
			xmlStr += " patient_class=\""+formObj.patient_class.value+"\""; 
			xmlStr += " locn_code=\""+formObj.source_code.value+"\""			
		
		for(var i=1;i<parseInt(tot_num_of_drugs);i++){
			xmlStr += " order_id_"+i+"=\""+eval("formObj.order_id_"+i).value+"\"";
			//alert("order_line_num==8792==>"+eval("formObj.order_line_num_"+i).value);
			xmlStr += " order_line_num_"+i+"=\""+eval("formObj.order_line_num_"+i).value+"\"";
			xmlStr += " print_"+i+"=\""+eval("formObj.print_"+i).value+"\"";
			xmlStr += " drug_code_"+i+"=\""+eval("formObj.drug_code_"+i).value+"\"";
			
		}
		xmlStr += " tot_rec=\""+tot_num_of_drugs+"\"";
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "DispMedicationValidation01.jsp?func_mode=printPrescription&bean_id="+bean_id+"&bean_name="+bean_name, false ) ;
		xmlHttp.send(xmlDoc);
		eval(xmlHttp.responseText);
		
	    if(formObj.patient_class.value=="OP"){
			var issue_token		= parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteria.issue_token_on_regn.value; 
			if(issue_token == 'Y'){  
				parent.parent.parent.f_query_criteria_token_info.frmDispMedicationQueryCriteriaTokenInfo.patient_id.value=formObj.patient_id.value;
				parent.parent.parent.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.btnSearch.click();
				parent.parent.parent.f_query_criteria_token_info.frmDispMedicationQueryCriteriaTokenInfo.patient_id.value="";
			}
			else{
				parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteria.patient_id.value=formObj.patient_id.value;
				parent.parent.parent.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.btnSearch.click();
				parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteria.patient_id.value=""; 
			}
		}	
		else{
		   parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteriaIP.patient_id.value=formObj.patient_id.value;
		   parent.parent.parent.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.btnSearch.click();
		   parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteriaIP.patient_id.value=""; 
		}        		
	

	//	alert(parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteria);

//		return true;
	}
function setValue(obj){
	   //added for mms-kh-crf-0028 start
	   var c=1;
			if(parent.f_disp_medication_delivery !=null && parent.f_disp_medication_delivery !=undefined){
				frmObj				=	parent.f_disp_medication_delivery.DispMedicationAllStages;
				 tot_recs		=	frmObj.tot_rec.value;
			}
			else if(parent.f_disp_medication_all_stages !=null && parent.f_disp_medication_all_stages !=undefined){
				frmObj =parent.f_disp_medication_all_stages.DispMedicationAllStages;
				tot_recs		=	frmObj.tot_rec.value;
			}
			else if(parent.f_disp_medication_filling !=null && parent.f_disp_medication_filling !=undefined){
				frmObj =parent.f_disp_medication_filling.DispMedicationAllStages;
				tot_recs		=	frmObj.tot_rec.value;
			}
			else if(parent.f_disp_medication_allocation !=null && parent.f_disp_medication_allocation !=undefined){
				frmObj =parent.f_disp_medication_allocation.DispMedicationAllStages;
				tot_recs		=	frmObj.tot_rec.value;
			}
			else if(parent.parent.DispMedicationPatDetFrame_3.f_disp_medication_verification !=null && parent.parent.DispMedicationPatDetFrame_3.f_disp_medication_verification !=undefined){
				frmObj =parent.parent.DispMedicationPatDetFrame_3.f_disp_medication_verification.DispMedicationAllStages;
				 tot_recs		=	frmObj.recCount.value;
			}
		//added for mms-kh-crf-0028 end
		var disp_stage=frmObj.disp_stage.value;
		
  if(obj.checked){
   obj.value = "Y";
  }else{
  obj.value = "N";
    if(frmObj.selectAll != null && frmObj.selectAll != undefined){
     frmObj.selectAll.checked=false;
  }
  }
  
  if(frmObj.selectAll != null && frmObj.selectAll != undefined){
   
   
   if(disp_stage=="D" || disp_stage=="AS"){
		
	
	for (var i=1;i<tot_recs;i++ ){
	  if(eval("frmObj.deliveryChecked_"+i).checked)
		  c++;
   }
	}
	else if(disp_stage=="F" || disp_stage=="A"){
			
	for (var i=1;i<tot_recs;i++ ){
	  if(eval("frmObj.print_"+i).checked)
		  c++;
   }
	}
	else if(disp_stage=="V"){
	
   for (var i=1;i<tot_recs;i++ ){
	  if(eval("frmObj.verifyChecked_"+i).checked)
		  c++;
   }	
	
	}
  

   if((parseInt(tot_recs))==c)
		frmObj.selectAll.checked=true;

  }
}

function showToolTipPrint(obj,msg){

	obj.title=msg;
}
//added for GHL-CRF-0453 - end
//KDAH-CRF-0476 - start
function printDispSheet(){

var facility_id = parent.printSelectFrame.document.DispMedicationPrintDialog.facility_id.value;
var user_name   = parent.printSelectFrame.document.DispMedicationPrintDialog.user_name.value;
var report_id	= parent.printSelectFrame.document.DispMedicationPrintDialog.report_id.value;
var module_id	= parent.printSelectFrame.document.DispMedicationPrintDialog.module_id.value;
var disp_fm_no	= parent.printSelectFrame.document.DispMedicationPrintDialog.disp_fm_no.value;
var disp_to_no	= parent.printSelectFrame.document.DispMedicationPrintDialog.disp_to_no.value;
var patient_class	= parent.printSelectFrame.document.DispMedicationPrintDialog.patient_class.value;
var locale	= parent.printSelectFrame.document.DispMedicationPrintDialog.locale.value;
var language_id	= parent.printSelectFrame.document.DispMedicationPrintDialog.language_id.value;
var disp_date	= parent.printSelectFrame.document.DispMedicationPrintDialog.disp_date.value;
var reprint_yn	= parent.printSelectFrame.document.DispMedicationPrintDialog.reprint_yn.value;
var patient_id  = parent.printSelectFrame.document.DispMedicationPrintDialog.patient_id.value;

var order_type  = parent.printSelectFrame.document.DispMedicationPrintDialog.order_type.value;

document.frmPrintDialogButtons.p_report_id.value = report_id;
document.frmPrintDialogButtons.p_facility_id.value = facility_id;
document.frmPrintDialogButtons.p_user_name.value = user_name;
document.frmPrintDialogButtons.p_disp_fm_no.value = disp_fm_no;
document.frmPrintDialogButtons.p_disp_to_no.value = disp_to_no;
document.frmPrintDialogButtons.p_patient_id.value = patient_id;

/*Added for GHL-CRF-0669 start*/
var customer_id = document.frmPrintDialogButtons.customer_id.value;
if(customer_id=="MC")
	{
	document.frmPrintDialogButtons.p_patient_class.value = "";
	}
else
	{
	document.frmPrintDialogButtons.p_patient_class.value = patient_class;
	}
/*Added for GHL-CRF-0669 end*/

document.frmPrintDialogButtons.p_disp_date.value = disp_date;
document.frmPrintDialogButtons.p_order_type.value = order_type;
document.frmPrintDialogButtons.btnCancel.focus();//KDAH-CRF-0487 
//alert("facility_id"+facility_id+"user_name"+user_name+"report_id"+report_id+"module_id"+module_id+"disp_fm_no"+disp_fm_no+"disp_to_no"+disp_to_no);//KDAH-SCF-0733 added for test patch
//alert("patient_class"+patient_class+"locale"+locale+"language_id"+language_id+"disp_date"+disp_date+"reprint_yn"+reprint_yn+"patient_id"+patient_id);//KDAH-SCF-0733 added for test patch
//document.frmPrintDialogButtons.action = "../../eCommon/jsp/report_options.jsp?p_module_id=PH&p_report_id="+report_id+"&p_facility_id="+facility_id+"&p_user_name="+user_name+"&p_disp_fm_no="+disp_fm_no+"&p_disp_to_no="+disp_to_no+"&p_patient_id="+patient_id+"&p_patient_class="+patient_class+"&order_type="+order_type+"&locale="+locale+"&p_language_id="+language_id+"&p_disp_date="+disp_date+"&p_reprint_yn=Y";
document.frmPrintDialogButtons.action = "../../eCommon/jsp/report_options.jsp"; //KDAH-CRF-0487
//alert("printDispSheet before submit");
document.frmPrintDialogButtons.submit();

}//KDAH-CRF-0476 - end

function  selectAllRcordsDeliver(obj,disp_stage){
	if(disp_stage=="D"){
	frmObj				=	parent.f_disp_medication_delivery.DispMedicationAllStages;
	}
	else if(disp_stage=="AS"){
		frmObj =parent.f_disp_medication_all_stages.DispMedicationAllStages;
	}		
	else if(disp_stage=="F"){
		frmObj =parent.f_disp_medication_filling.DispMedicationAllStages;
	}
    else if(disp_stage=="A"){
		frmObj =parent.f_disp_medication_allocation.DispMedicationAllStages;
	}
    else if(disp_stage=="V"){
		frmObj =parent.parent.DispMedicationPatDetFrame_3.f_disp_medication_verification.DispMedicationAllStages;
	}	
	//added for mms-kh-crf-0028 end
	if (obj.checked==false){
		//return;
	obj.value="N";
	}
	else{
	obj.value="Y";
	}
	//added for mms-kh-crf-0028 start
	if(disp_stage=="D" || disp_stage=="AS"){
		checkcount		=	frmObj.tot_rec.value;
		
	for (var i=1;i<checkcount;i++ ){
		
		if(eval("frmObj.deliveryChecked_"+i).checked != obj.checked)  
			eval("frmObj.deliveryChecked_"+i).click(); 
	
	}
	}
	else if(disp_stage=="F" || disp_stage=="A"){
	checkcount		=	frmObj.tot_rec.value;
	
	for (var i=1;i<checkcount;i++ ){
		
		if(eval("frmObj.print_"+i).checked != obj.checked)  
			eval("frmObj.print_"+i).click(); 
	
	}	
	}
	else if(disp_stage=="V"){
		checkcount		=	frmObj.recCount.value;
	   
	for (var i=1;i<checkcount;i++ ){
		
		if(eval("frmObj.verifyChecked_"+i).checked != obj.checked)  
			eval("frmObj.verifyChecked_"+i).click(); 
	
	}	
	
	}
	//added for mms-kh-crf-0028 end
	
}
//added for AAKH-CRF-0117 - start
function getApprovalNum()
{
	  var approval_no=document.DispMedicationAllStages.approval_no.value;
	  var disp_stage=document.DispMedicationAllStages. disp_stage.value;
	  var approval_flag=false;
	 if(disp_stage=="A") {
		  tot_rec =parent.f_disp_medication_allocation.DispMedicationAllStages.tot_rec.value;
		  formObj = parent.f_disp_medication_allocation.DispMedicationAllStages;
		  formObj.approval_no.value = approval_no;//AAKH-CRF-0117
 		  for (var i=1;i<tot_rec;i++)
	      {
		   if(eval("formObj.approval_no_"+i).disabled==false){ //AAKH-CRF-0117
		     eval("formObj.approval_no_"+i).value=approval_no;
			 approval_flag = true; //AAKH-CRF-0117
		   }
	      }
	}else if(disp_stage=="F") {
		  tot_rec =parent.f_disp_medication_filling.DispMedicationAllStages.tot_rec.value;
		  formObj = parent.f_disp_medication_filling.DispMedicationAllStages;
		  formObj.approval_no.value = approval_no;//AAKH-CRF-0117
 		  for (var i=1;i<tot_rec;i++ )
	      {
			  if(eval("formObj.approval_no_"+i).disabled==false){
		     eval("formObj.approval_no_"+i).value=approval_no;
			 approval_flag = true;
			  }
	      }
	}else if(disp_stage=="AS") {
		  tot_rec =parent.f_disp_medication_all_stages.DispMedicationAllStages.tot_rec.value;
		  formObj = parent.f_disp_medication_all_stages.DispMedicationAllStages;
		  formObj.approval_no.value = approval_no;//AAKH-CRF-0117
 		  for (var i=1;i<tot_rec;i++ )
	      {
			   if(eval("formObj.approval_no_"+i).disabled==false){
		     eval("formObj.approval_no_"+i).value=approval_no;
			 approval_flag = true;
			   }
	      }
	}else if(disp_stage=="D") {
		  tot_rec =parent.f_disp_medication_delivery.DispMedicationAllStages.tot_rec.value;
		  formObj = parent.f_disp_medication_delivery.DispMedicationAllStages;
		  formObj.approval_no.value = approval_no;//AAKH-CRF-0117
 		  for (var i=1;i<tot_rec;i++ )
	      {
			   if(eval("formObj.approval_no_"+i).disabled==false){
		     eval("formObj.approval_no_"+i).value=approval_no;
			 approval_flag = true;
			   }
	      }
	}
	if(approval_flag==false)
		return false;

	//var bean_id		=  formObj.bean_id_1.value; //commented for AAKH-CRF-0117 
	//var bean_name		=  formObj.bean_name_1.value;//commented for AAKH-CRF-0117 
	if(disp_stage!="AS"){
		var bean_id		=  formObj.bean_id_1.value;
		var bean_name		=  formObj.bean_name_1.value;
	}else{
		var bean_id		=  formObj.bean_id.value; //AAKH-CRF-0117
		var bean_name		=  formObj.bean_name.value;//AAKH-CRF-0117
	}
	
	var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		var xmlStr ="<root><SEARCH ";
		xmlStr += " bean_id=\""+bean_id+"\"";
		xmlStr += " bean_name=\""+bean_name+"\"";
			 			
		
		for (var i=1;i<tot_rec;i++ ){
			xmlStr += " order_id_"+i+"=\""+eval("formObj.order_id_"+i).value+"\"";
			//alert("order_line_num==8792==>"+eval("formObj.order_line_num_"+i).value);
			xmlStr += " order_line_num_"+i+"=\""+eval("formObj.order_line_num_"+i).value+"\"";
			//xmlStr += " print_"+i+"=\""+eval("formObj.print_"+i).value+"\"";
			xmlStr += " drug_code_"+i+"=\""+eval("formObj.drug_code_"+i).value+"\"";
			 
			
		}

		xmlStr += " tot_rec=\""+tot_rec+"\"";
		xmlStr += " approval_no=\""+approval_no+"\"";
		
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "DispMedicationValidation.jsp?func_mode=ApprovalNo", false ) ;
		xmlHttp.send(xmlDoc);
		eval(xmlHttp.responseText);
		  
}
function getApprovalNumForDrug(obj,rec_count){
	  var approval_no=obj.value;

	  var disp_stage=document.DispMedicationAllStages.disp_stage.value;

		 if(disp_stage=="A") {
			  formObj = parent.f_disp_medication_allocation.DispMedicationAllStages;
		}else if(disp_stage=="F") {
			  formObj = parent.f_disp_medication_filling.DispMedicationAllStages;
		}else if(disp_stage=="AS") {
			  formObj = parent.f_disp_medication_all_stages.DispMedicationAllStages;
		}else if(disp_stage=="D") {
			  formObj = parent.f_disp_medication_delivery.DispMedicationAllStages;
		}

	if(disp_stage!="AS"){
		var bean_id		=  formObj.bean_id_1.value;
		var bean_name		=  formObj.bean_name_1.value;
	}else{
		var bean_id		=  formObj.bean_id.value; //AAKH-CRF-0117
		var bean_name		=  formObj.bean_name.value;//AAKH-CRF-0117
	}
	var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		var xmlStr ="<root><SEARCH ";
		xmlStr += " bean_id=\""+bean_id+"\"";
		xmlStr += " bean_name=\""+bean_name+"\"";
		xmlStr += " order_id=\""+eval("formObj.order_id_"+rec_count).value+"\"";
		xmlStr += " order_line_num=\""+eval("formObj.order_line_num_"+rec_count).value+"\"";
		xmlStr += " drug_code=\""+eval("formObj.drug_code_"+rec_count).value+"\"";
		xmlStr += " approval_no=\""+approval_no+"\"";
		
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "DispMedicationValidation.jsp?func_mode=ApprovalNoForDrug", false ) ;
		xmlHttp.send(xmlDoc);
		eval(xmlHttp.responseText);
}
function toUpper(obj) 
{
	obj.value=obj.value.toUpperCase();
} //added for AAKH-CRF-0117 - end
//added for AAKH-CRF-0117 - start
function getApprovalNoValidation(disp_stage,formObj){
	 
	var approval_flag=true;
	tot_rec =formObj.tot_rec.value;
	 if(disp_stage=="A" || disp_stage=="F" || disp_stage=="AS" || disp_stage=="D") { //modified for AAKH-CRF-0117
  		  for (var i=1;i<parseInt(tot_rec);i++ )
	      {
			   if(eval("formObj.approval_no_"+i).disabled==false){
				 if(eval("formObj.approval_no_"+i).value ==""){
					approval_flag = false;
					break;
				}
			   }
	      }
	} 

	if(approval_flag==false)
		return false;
	else
		return true;
} //added for AAKH-CRF-0117 - end
	//added for AAKH-CRF-0117 - start
function KeyPressSpecCharsForApprovalNo(event){
	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#%^*()';
    var whichCode = (window.Event) ? event.which : event.keyCode;

	key = String.fromCharCode(whichCode);  // Get key value from key code
	
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	
	return true ;
  
}
function CheckForSpecCharApprovalno(Obj,stage,recCount){
		
        var str = Obj.value;
        var strvalidate = "";
        for (u=0;u<str.length;u++){
            if (((str.charCodeAt(u)>=48) && (str.charCodeAt(u)<=57))||((str.charCodeAt(u)>=65) && (str.charCodeAt(u)<=90))||((str.charCodeAt(u)>=97) && (str.charCodeAt(u)<=122))||(str.charCodeAt(u)==33)||(str.charCodeAt(u)==64)||(str.charCodeAt(u)==35)||(str.charCodeAt(u)==37)||(str.charCodeAt(u)==94)||(str.charCodeAt(u)==42)||(str.charCodeAt(u)==40)||(str.charCodeAt(u)==41)){//To allow only !,@,#,%,^,*,(,) special characters
            	 
            	strvalidate=strvalidate+str.charAt(u);
            }
		}
		 if(stage=="F" || stage=="D" || stage=="A" || stage=="AS")
			 eval("document.DispMedicationAllStages.approval_no_"+recCount).value = strvalidate;
		 else if(stage=="H")
			document.DispMedicationAllStages.approval_no.value = strvalidate;
 }	//added for AAKH-CRF-0117 - end

 //added for MMS-KH-CRF-0038 - start
function validateBarcode(obj){
  if(obj.value!=""){
	  var formObj = document.frmDispMedicationWSShowBatches;
	  var outer_count =formObj.outer_count.value ;
	  var inner_count =formObj.inner_count.value ;
	  var flag = false;
	 for (i=0;i<outer_count; i++){
		 for(j=0;j<inner_count;j++){
			 barcode_id = eval("formObj.barcode_id"+i+j).value ;
			 if(barcode_id==obj.value){
			 allocate = eval("formObj.alloc_qty"+i+j).value ;
			 if(allocate=="")
				 allocate = 0;
			 eval("formObj.alloc_qty"+i+j).value = parseInt(allocate)+1;
			 flag = true;
			 break;
			 }
		 }
		 if(flag==true){
		document.frmDispMedicationWSShowBatches.barcode_id.value="";
			 break;
		 }
	 }

	if(flag==false){
	alert(getMessage("PH_NOTMATCHING_BAR_CODE","PH"));
	document.frmDispMedicationWSShowBatches.barcode_id.value="";
	}
  }
}
function validateBarcodeAllocateBatch(event,obj,alert_required_yn,disp_stage,order_id,order_line_no,item_code,act_patient_class,remarks_required_yn,encounter_id,patient_id){
  if(obj.value!=""){
	  var entry_type ="";
	  var keyVal	= parseInt(event.keyCode);
	 if(keyVal==17){
			entry_type="S";
	 }else{
			 entry_type="M";
	 }


	  var formObj = document.frmDispMedicationWSAllocateBatches;
	  var outer_count =formObj.outer_count.value ;
	  var inner_count =formObj.inner_count.value ;
	  var flag = false;

	 for (i=1;i<=outer_count; i++){
		 for(j=1;j<=inner_count;j++){
			 barcode_id = eval("formObj.barcode_id"+i+j).value ;
			 batch_id = eval("formObj.batch_id"+i+j).value ;
			 batch_id_manual = eval("formObj.batch_id_manual_"+i+j).value ;
			 if(barcode_id==obj.value){
			 allocate = eval("formObj.alloc_qty"+i+j).value ;
			 if(allocate=="")
				 allocate = 0;
			 //callManualScanRemarks()
			 if(entry_type=="M"){
				 eval("formObj.batch_id_manual_"+i+j).value = "M"
			 }
			 
			  if(entry_type =='M' && alert_required_yn =='Y' && batch_id_manual !="M"){//act_patient_class,remarks_required_yn added for MMS-DM--CRF-0170
                   retval=callManualScanRemarks(patient_id,encounter_id,disp_stage,order_id,order_line_no,item_code,batch_id,act_patient_class,remarks_required_yn);
			  }else if(entry_type=='S' || (entry_type =='M' && alert_required_yn =='N') ){
				  retval= scanBarcodeCount(patient_id,encounter_id,disp_stage,order_id,order_line_no,item_code,batch_id,entry_type,act_patient_class);
			  }
			 eval("formObj.alloc_qty"+i+j).value = parseInt(allocate)+1;
			 flag = true;
			 break;
			 }
		 }
		 if(flag==true){
		document.frmDispMedicationWSAllocateBatches.barcode_id.value="";
			 break;
		 }
	 }

	if(flag==false){
	alert(getMessage("PH_NOTMATCHING_BAR_CODE","PH"));
	document.frmDispMedicationWSAllocateBatches.barcode_id.value="";
	}
  }
}
 //added for MMS-KH-CRF-0038 - end
 //added for MOHE-CRF-0026.1 START
function setValueAuth(obj){
	   var c=1;
			if(parent.f_disp_medication_delivery !=undefined){
				frmObj				=	parent.f_disp_medication_delivery.DispMedicationAllStages;
				 tot_recs		=	frmObj.tot_rec.value;
			}
			else if( parent.f_disp_medication_all_stages !=undefined){
				frmObj =parent.f_disp_medication_all_stages.DispMedicationAllStages;
				tot_recs		=	frmObj.tot_rec.value;
			}
			
		var disp_stage=frmObj.disp_stage.value;
		
  if(obj.checked){
   obj.value = "Y";
  }else{
	  obj.value = "N";
	  if(frmObj.AuthAll != undefined){
		  frmObj.AuthAll.checked=false;
	  }
  }
  if(frmObj.AuthAll != undefined){
   if(disp_stage=="D" || disp_stage=="AS"){
	for (var i=1;i<tot_recs;i++ ){
	  if(eval("frmObj.authChecked_"+i).checked)
		  c++;
   } 
	}  
   if((parseInt(tot_recs))==c)
		frmObj.AuthAll.checked=true;
  }
}

function  authtAllRcordsDeliver(obj,disp_stage){
	if(disp_stage=="D"){
	frmObj				=	parent.f_disp_medication_delivery.DispMedicationAllStages;
	}
	else if(disp_stage=="AS"){
		frmObj =parent.f_disp_medication_all_stages.DispMedicationAllStages;
	}		
	if(disp_stage=="D" || disp_stage=="AS"){
		checkcount		=	frmObj.tot_rec.value;
		for (var i=1;i<checkcount;i++ ){
			if(eval("frmObj.authChecked_"+i).checked != obj.checked) {
				//eval("frmObj.authChecked_"+i).checked=false; 
				eval("frmObj.authChecked_"+i).click(); 

			}
		}
	}
}
//MOHE-CRF-0026.1 START
function callAuthCheck(patient_id,order_id,disp_stage){
	//alert("callAuthCheck");  //COMMENTED FOR MOHE-CRF-0026.1 
	var response = "";
	var encounter_id="";
	var authStatus ="";  
	var bean_id_1   = "DispMedicationBean";
	var bean_name_1 = "ePH.DispMedicationBean";
	if(disp_stage=="D"){
		frmObj				=	parent.f_disp_medication_delivery.DispMedicationAllStages;
		encounter_id = frmObj.encounter_id.value;
		}
		else if(disp_stage=="AS"){
			frmObj =parent.f_disp_medication_all_stages.DispMedicationAllStages;
			encounter_id = frmObj.encounter_id.value;
		}	
	var tot_rec =frmObj.tot_rec.value;
		var authdisabled = true;  
		for(var k=1;k<tot_rec;k++){ 
			if(eval("frmObj.authChecked_"+k)!=undefined){
				if(eval("frmObj.authChecked_"+k).disabled == false){	   
					authdisabled = true;
					break;
			       }
			       else {
			    		  if( k==tot_rec-1 ){
			    			  authdisabled = false;	  
			    		  }
			       }
			}	  
		}		
		if(!authdisabled){
		   alert(getMessage("PH_ATLEAST_ONE_SELECTED",'PH'));
		   return false;
		}
		
		for(var k=1;k<tot_rec;k++){
			if(eval("frmObj.authChecked_"+k)!=undefined){
				if(eval("frmObj.authChecked_"+k).disabled == false){
					if(eval("frmObj.authChecked_"+k).checked==true){
						var drug_code = eval("frmObj.drug_code"+k).value; 		
						var order_line_num = eval("frmObj.order_line_num"+k).value;  	
						var alloc_qty = eval("frmObj.allocate_qty"+k).value;	
						if (alloc_qty== "0.0" || alloc_qty==""){
							alert("Qty not allocated for the item");
							frmObj.alloc_qty_check.value = "Z"; 
							return false;
						}
						var uom = eval("frmObj.uom"+k).value;
						var frequencyCode = eval("frmObj.frequencyCode"+k).value;
						var repeatValue = eval("frmObj.repeatValue"+k).value;
						var durnValue = eval("frmObj.durnValue"+k).value;
						var durationType = eval("frmObj.durationType"+k).value;
						var routeCode = eval("frmObj.routeCode"+k).value;
						var qtyValue = eval("frmObj.qtyValue"+k).value;
						var qtyUnit = eval("frmObj.qtyUnit"+k).value;  
						var dispTmpNo = eval("frmObj.dispTmpNo"+k).value;  
						var orderId = eval("frmObj.orderId"+k).value; 
						var unitPrice = eval("frmObj.itemCost"+k).value; //MOHE-CRF-0026.1 
				
						var xmlDoc="";
						var xmlHttp = new XMLHttpRequest();
						var xmlStr ="<root><SEARCH ";
						xmlStr += " patient_id=\""+patient_id+"\"";
						xmlStr += " encounter_id=\""+encounter_id+"\"";
						xmlStr += " orderId=\""+orderId+"\""; 
						xmlStr += " drug_code=\""+drug_code+"\""; 
						xmlStr += " order_line_num=\""+order_line_num+"\""; 
						xmlStr += " alloc_qty=\""+alloc_qty+"\""; 
						xmlStr += " uom=\""+uom+"\""; 
						xmlStr += " frequencyCode=\""+frequencyCode+"\""; 
						xmlStr += " repeatValue=\""+repeatValue+"\""; 
						xmlStr += " durnValue=\""+durnValue+"\""; 
						xmlStr += " durationType=\""+durationType+"\""; 
						xmlStr += " routeCode=\""+routeCode+"\""; 
						xmlStr += " qtyValue=\""+qtyValue+"\""; 
						xmlStr += " qtyUnit=\""+qtyUnit+"\"";  
						xmlStr += " dispTmpNo=\""+dispTmpNo+"\""; 
						xmlStr += " unitPrice=\""+unitPrice+"\"";  //MOHE-CRF-0026.1 
						xmlStr +=" /></root>" ;
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						//xmlHttp.open( "POST", "DispMedicationValidation.jsp?func_mode=callAuthorizationCheck", false ) ;	
						xmlHttp.open("POST","DispMedicationValidate.jsp?bean_id="+bean_id_1+"&bean_name="+bean_name_1+"&identity=callAuthorizationCheck",false);
						xmlHttp.send(xmlDoc); 
						eval(xmlHttp.responseText);
					}				
				}
			}
		}
	 
}
function callInterfacePostDispense(disp_stage){
	/*alert("callInterfacePostDispense");
	alert("disp_stage: "+disp_stage);*///COMMENTED FOR MOHE-CRF-0026.1 
	var request_type = "PHDISP"; 
	var bean_id_1   = "DispMedicationBean";
	var bean_name_1 = "ePH.DispMedicationBean";
	var facility_id = "";
	var added_by_id = "";
	var login_at_ws_no = ""; 
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr += "request_type=\""+request_type+"\"";
	xmlStr += " disp_stage=\""+disp_stage+"\""; 
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","DispMedicationValidate.jsp?bean_id="+bean_id_1+"&bean_name="+bean_name_1+"&identity=setPostDispData",false);
	xmlHttp.send(xmlDoc); 
	eval(xmlHttp.responseText);	
	//alert("after setPostDispData"); 
	if(disp_stage=="D"){
		postDisp_disp_data = parent.f_disp_medication_delivery.DispMedicationAllStages.postDisp_disp_data.value;	
		facility_id = parent.f_disp_medication_delivery.DispMedicationAllStages.facility_id.value;		
		added_by_id = parent.f_disp_medication_delivery.DispMedicationAllStages.added_by_id.value;
		login_at_ws_no = parent.f_disp_medication_delivery.DispMedicationAllStages.login_at_ws_no.value; 
	}
	else if(disp_stage=="AS"){
		postDisp_disp_data = parent.f_disp_medication_all_stages.DispMedicationAllStages.postDisp_disp_data.value;	
		facility_id = parent.f_disp_medication_all_stages.DispMedicationAllStages.facility_id.value;	
		added_by_id = parent.f_disp_medication_all_stages.DispMedicationAllStages.added_by_id.value;
		login_at_ws_no = parent.f_disp_medication_all_stages.DispMedicationAllStages.login_at_ws_no.value;
	}
	if(request_type=="PHDISP"){
		response =PayerAuthorization(request_type,facility_id,postDisp_disp_data,added_by_id,login_at_ws_no);
	}

}
function callInterface(disp_stage,request_type){ 
	//alert("callInterface"); 
	var bean_id   = "DispMedicationBean";
	var bean_name = "ePH.DispMedicationBean";
	//alert("request_type: "+request_type); 
	var fields = "";  
	var disp_data = ""; 
	var authStatus_disp_data =""; 
	var item_data = ""; 
	if(disp_stage=="D"){
		frmObj				=	parent.f_disp_medication_delivery.DispMedicationAllStages;
		encounter_id = frmObj.encounter_id.value;
		}
		else if(disp_stage=="AS"){
			frmObj =parent.f_disp_medication_all_stages.DispMedicationAllStages;
			encounter_id = frmObj.encounter_id.value;
		}
	//alert("alloc_qty_check: "+frmObj.alloc_qty_check.value); 
	
	
	
	if (frmObj.alloc_qty_check.value == "Z"){
		return false; 
	}
	var responseStatus = frmObj.responseStatus.value;
	var disp_stage = disp_stage;
	 
	var facility_id = frmObj.facility_id.value;
	var added_by_id = frmObj.added_by_id.value;
	var login_at_ws_no = frmObj.login_at_ws_no.value;
	var disp_data ="";  
	var response ="";  
	//alert("123"); 
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr += "request_type=\""+request_type+"\"";
	xmlStr += " disp_stage=\""+disp_stage+"\""; 
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=setDispData",false);
	xmlHttp.send(xmlDoc); 
	eval(xmlHttp.responseText);
	if(disp_stage=="D"){
		disp_data = parent.f_disp_medication_delivery.DispMedicationAllStages.disp_data.value;
		authStatus_disp_data = parent.f_disp_medication_delivery.DispMedicationAllStages.authStatus_disp_data.value;
	}
	else if(disp_stage=="AS"){
		disp_data = parent.f_disp_medication_all_stages.DispMedicationAllStages.disp_data.value; 
		authStatus_disp_data = parent.f_disp_medication_all_stages.DispMedicationAllStages.authStatus_disp_data.value; 
	}
	if(request_type=="PHPREAUTH"){
		response =PayerAuthorization(request_type,facility_id,disp_data,added_by_id,login_at_ws_no);

	}
	if(request_type=="PHSTATUS"){
		response =PayerAuthorization(request_type,facility_id,authStatus_disp_data,added_by_id,login_at_ws_no);
	}
	
	fields = response.split('$!^');
	disp_data = fields[2];
//	alert("disp_data from Interface: "+disp_data);  
	item_data = disp_data.split('#');
	for(var i=0;i<item_data.length;i++){
		var item_details = item_data[i].split('~');
		
		//var statusCode = "P";
		var orderIdNo = item_details[2]; 
		//alert("orderIdNo: "+orderIdNo);  //commented for MOHE-CRF-0026.1 
		var appQty = item_details[7];//approved qty 
		var statusCode = item_details[10];
		var claimId = item_details[11];
		var respStatus = item_details[12];
		var approvalNo = item_details[13];
		var adjudicationStatus = item_details[14];
		var benefitValue = item_details[15];   
		/*alert("statusCode: "+statusCode); 
		alert("claimid: "+claimId);
		alert("respStatus: "+respStatus);	
		alert("approvalNo: "+approvalNo);	
		alert("adjudicationStatus: "+adjudicationStatus);	
		alert("benefitValue: "+benefitValue);*/	
			if(statusCode=="S" && (respStatus=="")){
				authStatus = "Sent to Insurance";
				frmObj.document.getElementById("authStatus_"+(i+1)).innerHTML =authStatus; 
				eval("frmObj.authChecked_"+(i+1)).disabled=true; 
				var alloc_qty = eval("frmObj.allocate_qty"+(i+1)).value;	
				//alert("alloc_qty: "+alloc_qty);   
				frmObj.document.getElementById("authStatus_"+(i+1)).style.fontWeight='bolder';
				frmObj.authStatusCompleted_yn.value = "N";   
			}
			else if (statusCode=="S" && respStatus=="E"){//MOHE-CRF-0026.1
				authStatus = "Rejected";
				frmObj.document.getElementById("authStatus_"+(i+1)).innerHTML =authStatus; 
				eval("frmObj.authChecked_"+(i+1)).disabled=true; 
				frmObj.document.getElementById("authStatus_"+(i+1)).style.fontWeight='bolder';
				frmObj.authStatusCompleted_yn.value = "Y"; //end  
			}
			else if (statusCode=="S" && respStatus=="P"){
				authStatus = "Approved";
				frmObj.document.getElementById("authStatus_"+(i+1)).innerHTML =authStatus; 
				eval("frmObj.authChecked_"+(i+1)).disabled=true; 
				//var alloc_qty = eval("frmObj.allocate_qty"+(i+1)).value;	
				frmObj.document.getElementById("authStatus_"+(i+1)).style.fontWeight='bolder';
				frmObj.document.getElementById("appAmtlabel_"+(i+1)).style.visibility="visible";  
				 frmObj.document.getElementById("appAmt_"+(i+1)).innerHTML =benefitValue;  
				 frmObj.authStatusCompleted_yn.value = "Y";   
			}
			else if (statusCode=="R" && respStatus=="R"){
				authStatus = "Partially Approved";
				frmObj.document.getElementById("authStatus_"+(i+1)).innerHTML =authStatus; 
				eval("frmObj.authChecked_"+(i+1)).disabled=true; 
				frmObj.document.getElementById("authStatus_"+(i+1)).style.fontWeight='bolder';
				frmObj.authStatusCompleted_yn.value = "Y"; 
			}
			frmObj.claimId.value = claimId; 
			frmObj.response_code.value = statusCode; 
			frmObj.responseStatus.value = respStatus; 
			frmObj.postAuthStatusData.value = disp_data; 
		/*	if(request_type=="PHPREAUTH"){
				var xmlDoc="";
				var xmlHttp = new XMLHttpRequest();
				var xmlStr ="<root><SEARCH ";
				xmlStr += "orderIdNo=\""+orderIdNo+"\"";
				xmlStr += " claimId=\""+claimId+"\""; 
				xmlStr += " respStatus=\""+respStatus+"\"";
				xmlStr += " statusCode=\""+statusCode+"\"";  
				xmlStr +=" /></root>" ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","DispMedicationValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=setOrderIdClaimDet",false);
				xmlHttp.send(xmlDoc); 
				eval(xmlHttp.responseText);
			}*/
			
			
	} 
}
function assignDispData(disp_data,disp_stage){

	if(disp_stage=="D"){
		parent.f_disp_medication_delivery.DispMedicationAllStages.disp_data.value = disp_data;
		}
		else if(disp_stage=="AS"){
			parent.f_disp_medication_all_stages.DispMedicationAllStages.disp_data.value = disp_data;
		}
}

function assignAuthStatusDispData(disp_data,disp_stage){

	if(disp_stage=="D"){
		parent.f_disp_medication_delivery.DispMedicationAllStages.authStatus_disp_data.value = disp_data;
		}
		else if(disp_stage=="AS"){
			parent.f_disp_medication_all_stages.DispMedicationAllStages.authStatus_disp_data.value = disp_data;
		}
	  
}
function assignPostDispData(disp_data,disp_stage){		
		if(disp_stage=="D"){
			parent.f_disp_medication_delivery.DispMedicationAllStages.postDisp_disp_data.value = disp_data;
			}
		else if (disp_stage=="AS"){
			parent.f_disp_medication_all_stages.DispMedicationAllStages.postDisp_disp_data.value = disp_data; 
		}
	}
function callAuthStatus(patient_id,order_id,disp_stage){
	//alert("callAuthStatus");  
	var val =""; 
	var encounter_id=""; 
	var bean_id_1   = "DispMedicationBean";
	var bean_name_1 = "ePH.DispMedicationBean";
	if(disp_stage=="D"){
		if(parent.f_disp_medication_delivery !=null && parent.f_disp_medication_delivery !=undefined){
			frmObj				=	parent.f_disp_medication_delivery.DispMedicationAllStages;
			encounter_id = frmObj.encounter_id.value; 
		//	alert("encounter_id: "+encounter_id); 
		}
	}
	else if(disp_stage=="AS"){
		if(parent.f_disp_medication_all_stages !=null && parent.f_disp_medication_all_stages !=undefined){
			frmObj =parent.f_disp_medication_all_stages.DispMedicationAllStages;
			encounter_id = frmObj.encounter_id.value; 
		}
	}	
	var tot_rec =frmObj.tot_rec.value;
	var claimId = frmObj.claimId.value;
	var response_code =frmObj.response_code.value;
	var responseStatus = frmObj.responseStatus.value;
	var OrderIds = "";
	if(document.DispMedicationAllStages.OrderIds == undefined)
		OrderIds = parent.f_disp_medication_header.document.DispMedicationAllStages.OrderIds.value;
	else
		OrderIds = document.DispMedicationAllStages.OrderIds.value;
	  
	for(i=1; i<tot_rec; i++) {	
		if(eval("frmObj.authChecked_"+i).checked==true){
			val	=	frmObj.document.getElementById("authStatus_"+i).innerHTML ;
		
			if(val=="Approved" || val=="Partially Approved" || val=="Rejected"){
				alert("Request not sent to interface "); 
			}else{
				
				var drug_code = eval("frmObj.drug_code"+i).value;  
				var order_line_num = eval("frmObj.order_line_num"+i).value;  
				var alloc_qty = eval("frmObj.allocate_qty"+i).value;						
				var uom = eval("frmObj.uom"+i).value;
				var orderId = eval("frmObj.orderId"+i).value; 
				var dispTmpNo = eval("frmObj.dispTmpNo"+i).value;  
				var unitPrice = eval("frmObj.itemCost"+i).value; //MOHE-CRF-0026.1 

				var xmlDoc=""; 
				var xmlHttp = new XMLHttpRequest();
				var xmlStr ="<root><SEARCH ";
				xmlStr += " patient_id=\""+patient_id+"\"";
				xmlStr += " encounter_id=\""+encounter_id+"\"";
				xmlStr += " orderId=\""+orderId+"\""; 
				xmlStr += " dispTmpNo=\""+dispTmpNo+"\""; 
				xmlStr += " order_line_num=\""+order_line_num+"\""; 
				xmlStr += " drug_code=\""+drug_code+"\""; 
				xmlStr += " alloc_qty=\""+alloc_qty+"\""; 
				xmlStr += " uom=\""+uom+"\""; 
				xmlStr += " claimId=\""+claimId+"\""; 
				xmlStr += " response_code=\""+response_code+"\""; 
				xmlStr += " responseStatus=\""+responseStatus+"\""; 
				xmlStr += " unitPrice=\""+unitPrice+"\""; //MOHE-CRF-0026.1 
				xmlStr +=" /></root>" ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			//	xmlHttp.open( "POST", "DispMedicationValidation.jsp?func_mode=callAuthorizationStatus", false ) ;
				xmlHttp.open("POST","DispMedicationValidate.jsp?bean_id="+bean_id_1+"&bean_name="+bean_name_1+"&identity=callAuthorizationStatus",false); 
				xmlHttp.send(xmlDoc); 
				eval(xmlHttp.responseText);
			}
		} 
	}
}//MOHE-CRF-0026.1 END

//TH-KW-CRF-20.3 starts


function getQUEPKICode(obj){
	//alert(document.getElementById("facility_id").value);
//	alert(document.getElementById("patient_id").value);
	//alert(document.getElementById("encounter_id").value);
	//alert(document.getElementById("user_id").value);
	//alert(obj.value);
	if(obj.value!=null && obj.value!=""){
		//var responseToken = "S$!^SUCCESS$!^1$!^105$!^09/11/2022 10:05:00$!^ 9/11/2022 10:05:00"; 
		var responseToken = getTokenDetails("PHDISP", document.getElementById("facility_id").value, obj.value, document.getElementById("patient_id").value,document.getElementById("encounter_id").value,document.getElementById("user_id").value);
		//alert(responseToken);
		document.getElementById("quePkiToken").value=responseToken;
		//alert(document.getElementById("quePkiToken").value);
		
		var queArr=responseToken.split("$!^");
		document.getElementById("quePkiStatus").value=queArr[0];
		//alert(document.getElementById("quePkiStatus").value);
		if(queArr[0] =="S"){
		//	alert("if");
			document.getElementById("quePkiId_res_id").innerText ="Token dispensed details received successfully";
		}
		else if(queArr[0] =="F"){
		//	alert("else if");
			document.getElementById("quePkiId_res_id").innerText="Invalid primary key.Token details not received";
		}
		else{//alert("else");
			document.getElementById("quePkiId_res_id").innerText="Token dispensed details could not be received";
		}
		document.getElementById("quePkiStatusText").value=queArr[1];
		//alert(document.getElementById("quePkiStatusText").value);
		document.getElementById("quePkiNumber").value=queArr[3];
		//alert(document.getElementById("quePkiNumber").value);
		document.getElementById("quePkiIsueDateTime").value=queArr[4];
		//alert(document.getElementById("quePkiIsueDateTime").value);
		document.getElementById("quePkiCallDateTime").value=queArr[5];
		//alert(document.getElementById("quePkiCallDateTime").value);
	}else{
		alert("Token dispensed details cannot be captured as primary key of queue no is blank");
		document.getElementById("quePkiStatus").value="";
		document.getElementById("quePkiStatusText").value="";
		document.getElementById("quePkiToken").value="";
		document.getElementById("quePkiNumber").value="";
		document.getElementById("quePkiIsueDateTime").value="";
		document.getElementById("quePkiCallDateTime").value="";
		//parent.f_disp_medication_header.document.DispMedicationAllStages.quePkiId.focus();
		document.getElementById("quePkiId_res_id").innerText="";
	}
}

//added for TH-KW-CRF-0020.3 end

//Added for MMS-DM-CRF-0228 start
function displayFirstLastSet(mode)
{
	var maxDisplay =parseInt(parent.patient_id_display.document.forms[0].maxdisplay.value);
    var maxDisplay1 =parseInt(parent.patient_id_display.document.forms[0].maxdisplay1.value);
    var searchthreshold = parseInt(parent.patient_id_display.document.forms[0].searchthreshold.value);
    var noofRec = 0,number=0;
    var display_anchors = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
   if(mode=="first"){
	   maxDisplay1=5;
        for ( i = 1;i<=maxDisplay1;i++) {
        	noofRec=(i-1)*12+1;
        	number=number+12;
                display_anchors += "<b><td align='right'><a href=\"javascript:SubmitLinkForPagination('"+(noofRec)+"','"+(number)+"','')\">"+i+"</a><b>";
                display_anchors += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
        }
        parent.patient_id_pagination.document.forms[0].prev.disabled = true; 
 	   	parent.patient_id_pagination.document.forms[0].next.disabled = false; 
 	   SubmitLinkForPagination('1','12','');
   }
   if(mode=="last"){
		   for ( i = maxDisplay-4;i<=maxDisplay;i++) {
	       	noofRec=(i-1)*12+1;
	       	number=noofRec+11;
	               display_anchors += "<b><td align='right'><a href=\"javascript:SubmitLinkForPagination('"+(noofRec)+"','"+(number)+"','')\">"+i+"</a><b>";
	               display_anchors += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
	       }
		   parent.patient_id_pagination.document.forms[0].next.disabled = true; 
		   parent.patient_id_pagination.document.forms[0].prev.disabled = false; 
	       parent.patient_id_display.document.forms[0].maxdisplay1.value = i-1;       
	       
	       SubmitLinkForPagination(noofRec,number,'');
	   }
        parent.patient_id_pagination.document.getElementById('disprec').innerHTML=display_anchors;
        parent.patient_id_pagination.document.forms[0].defaultwindow.value=display_anchors;

}

function displayNextSet(mode)
{
	var maxDisplay =parseInt(parent.patient_id_display.document.forms[0].maxdisplay.value);
    var maxDisplay1 =parseInt(parent.patient_id_display.document.forms[0].maxdisplay1.value);
    var searchthreshold = parseInt(parent.patient_id_display.document.forms[0].searchthreshold.value);
   // alert("maxDisplay=>"+maxDisplay+"==maxDisplay1=="+maxDisplay1+"==searchthreshold==>"+searchthreshold);
    var number=0;
	if (mode=="next")
    {
        b = maxDisplay1 - 4;
        maxDisplay2 = maxDisplay1+1; 
    }
    else
    {
        maxDisplay2 = maxDisplay1-1;
        b = maxDisplay1 - 5-1;
    }
    noofRec = 0;
    display_anchors = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    if (maxDisplay2 != maxDisplay+1)
    {
        for ( i = b;i<maxDisplay2;i++) {
                noofRec1 =parseInt(noofRec) + (searchthreshold*(i));
                number=i+1;
                display_anchors += "<b><td align='right'><a href=\"javascript:SubmitLinkForPagination('"+(noofRec1+1)+"','"+(noofRec1+12)+"','')\">"+number+"</a><b>";
                display_anchors += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
        }
        parent.patient_id_pagination.document.getElementById('disprec').innerHTML=display_anchors;
        parent.patient_id_pagination.document.forms[0].defaultwindow.value=display_anchors;
        parent.patient_id_display.document.forms[0].maxdisplay1.value = maxDisplay2;       
        parent.patient_id_pagination.document.forms[0].prev.disabled = false;
    }
    if (mode=="prev")
    {
        if (maxDisplay2 != maxDisplay)         
        {
            if (parent.patient_id_pagination.document.forms[0].next.disabled == true)
                parent.patient_id_pagination.document.forms[0].next.disabled = false;
        }
        if (b==0) parent.patient_id_pagination.document.forms[0].prev.disabled = true;
    }
    if (mode=="next")
    {
        if (maxDisplay2!=maxDisplay) {}
        else
        {
            parent.patient_id_pagination.document.forms[0].next.disabled = true;                     
            parent.patient_id_pagination.document.forms[0].maxdisplay1.value = maxDisplay2;
        }
    }
}
//Added for MMS-DM-CRF-0228 end

//function created By Himanshu Saxena for MMS-DM-CRF-0232 on 10-10-23 Started
function disable_category_dispense()
{
	var disp_locn=document.getElementById("disp_locn").value;
	var issitespecific=document.getElementById("isSite_INTEGRATION_EM_BD_PYXIS").value;
	
	if(disp_locn=="all" && issitespecific=="true")
	{
		document.getElementById("disp_locn_category").value = "IAE";
		document.getElementById("disp_stage").value = "V";
		document.getElementById("disp_locn_category").disabled = true;
		document.getElementById("disp_stage").disabled = true;	
		
		alert(document.getElementById("disp_locn_category").value);
		
	}else
	{
		document.getElementById("disp_locn_category").value = "I";
		document.getElementById("disp_stage").value = "";
		document.getElementById("disp_locn_category").disabled = false;
		document.getElementById("disp_stage").disabled = false;	
	}
	
}
function PresskeylocatePatientID(e){
	if(e.keyCode== 13){
		locatePatientID();
	}
}

function showPrescriptionNum() {
	var optionValue = document.frmDispMedicationQueryCriteriaIP.customGroupBy.value;
	  if (optionValue== "PRESCRIPTION_NUMBER") {
		  document.getElementById("pres_enable_head").style.display ="block";
		  document.getElementById("pres_enable_field").style.display ="block";
	  } else {
		  document.getElementById("prescription_num").value="";
		  document.getElementById("pres_enable_head").style.display ="none";  
		  document.getElementById("pres_enable_field").style.display ="none";
	  }
	}

//Added by Himanshu for GHL-CRF-0672
function refreshon_enter(numvalue,e,disp_locn_catg,issue_token_on_regn,disp_stage,fill_list,login_user,disp_locn_code)
{
  var isnumeric=true;
  if(numvalue.id=="fill_doc_num"){
	 isnumeric=containsOnlyNumbers(numvalue.value);
  }
	
		
	if(e.keyCode== 13)
	{	
		if(isnumeric==false){
			return;
		}else{	
		checkRestoreChangesUponRefresh(disp_locn_catg,issue_token_on_regn,disp_stage,fill_list,login_user,disp_locn_code);
		numvalue.value="";
		}
		
	}
}

function isValidInteger_check_ip(obj) {
	var key = window.event.keyCode;
	if(!(key >= 48 && key <= 57)) {
		return false;
	} else {
		return true;
	}
}

function copyPasteChk(obj){
	var difftimeperiod="";
	var string=obj.value;
	var strCheck = "0123456789";
	for(i=0;i<string.length;i++)
		{
		if (strCheck.indexOf(string.charAt(i)) == -1) {
			difftimeperiod=difftimeperiod;
        }
		else{
			difftimeperiod+=string.charAt(i);
		}
		}
	obj.value= difftimeperiod; 
}


function containsOnlyNumbers(str) {
    if (!str || str.length === 0) {
        return false;
    }
    return /^[0-9]+$/.test(str);
}

//Added by Himanshu for ML-MMOH-CRF-2094
function token_no_blank()
{
	document.getElementById("token_no").value = "";
}

//added by Himanshu Against RBU-GHL-CRF-0045
function printPresAllocateAndFill_report(disp_stage,iv_prep_yn,report_type){

	    var period_from="";
		var period_to="";
		var p_priority_type="";
		    
		   if(disp_stage=="A" ){
				if(parent.f_stage==undefined){
					var formObj = parent.f_disp_medication_allocation.DispMedicationAllStages;
				}
				else{
					var formObj = parent.f_stage.DispMedicationAllStages;
				}
			}
			 if(iv_prep_yn=="0" || iv_prep_yn=="2" ||iv_prep_yn=="4"||iv_prep_yn=="6"){	
				if(parent.f_stage==undefined){
					if(parent.f_disp_medication_allocation==null)
						var formObj = parent.f_disp_medication_filling.DispMedicationAllStages;
					else
						var formObj = parent.f_disp_medication_allocation.DispMedicationAllStages;
				}
				else{
					 var formObj = parent.f_stage.DispMedicationAllStages;
				}
			}
			else{
				if(parent.f_stage==undefined){
					var formObj = parent.f_disp_medication_filling.DispMedicationAllStages;
				}
				else{
					var formObj = parent.f_stage.DispMedicationAllStages;
				}
			}
			var tot_num_of_drugs=formObj.tot_rec.value;
			var print_allow_flag	=	false;
			for(var i=1;i<parseInt(tot_num_of_drugs);i++){
			if(eval("formObj.print_"+i).checked==true){
				print_allow_flag = true;
				break;
			 }
		 
			}
		 if(print_allow_flag==false){
				alert(getMessage("PH_ATLEAST_ONE_SELECTED","PH"));
				 return false;
			 }
		 
		 if(formObj.patient_class.value=="IP" && disp_stage=="F")
		 {
			 period_from=parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteriaIP.order_date_from.value;
			 period_to=parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteriaIP.order_date_to.value;
			 p_priority_type=parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteriaIP.priority.value;
		 }
		 if(formObj.patient_class.value=="OP" && disp_stage=="F")
		{
			period_from=parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteria.order_date_from.value;
			period_to=parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteria.order_date_to.value;
			p_priority_type=parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteria.priority.value;
		}
		 
			 if(p_priority_type=="")
			 {
			 p_priority_type=null;
			 }
			var bean_id = "DispMedicationAllStages";
			var bean_name = "ePH.DispMedicationAllStages";

			var xmlDoc="";
			var xmlHttp = new XMLHttpRequest();
			var xmlStr ="<root><SEARCH ";
				xmlStr += " bean_id=\""+bean_id+"\"";
				xmlStr += " bean_name=\""+bean_name+"\"";
				xmlStr += " patient_id=\""+formObj.patient_id.value+"\"";
				xmlStr += " patient_class=\""+formObj.patient_class.value+"\""; 
				xmlStr += " locn_code=\""+formObj.source_code.value+"\"";
				xmlStr += " report_type=\""+report_type+"\"";
				
				xmlStr += " period_from=\""+period_from+"\"";
				xmlStr += " period_to=\""+period_to+"\"";
				xmlStr += " p_priority_type=\""+p_priority_type+"\"";
			
			for(var i=1;i<parseInt(tot_num_of_drugs);i++){
				xmlStr += " order_id_"+i+"=\""+eval("formObj.order_id_"+i).value+"\"";
				//alert("order_line_num==8792==>"+eval("formObj.order_line_num_"+i).value);
				xmlStr += " order_line_num_"+i+"=\""+eval("formObj.order_line_num_"+i).value+"\"";
				xmlStr += " print_"+i+"=\""+eval("formObj.print_"+i).value+"\"";
				xmlStr += " drug_code_"+i+"=\""+eval("formObj.drug_code_"+i).value+"\"";
				
			}
			xmlStr += " tot_rec=\""+tot_num_of_drugs+"\"";
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST", "DispMedicationValidation1.jsp?func_mode=printPrescription_online_offline&bean_id="+bean_id+"&bean_name="+bean_name, false ) ;
			xmlHttp.send(xmlDoc);

			
			var result_value="";
			if(report_type=="offline")
				{
				result_value=xmlHttp.responseText;
				var array_report = result_value.split("@@@");
				
				var p_report_id="PHFILLAL";
				var P_USER_NAME=array_report[1];
				var P_FACILITY_ID=array_report[2];
				var p_module_id=array_report[3];
				var p_language_id=array_report[4];
				var P_LOCNCODE=array_report[5];
				var P_FM_ORDER_ID=array_report[6];
				var P_TO_ORDER_ID=array_report[7];
				var p_patient_id=array_report[8];
				var P_PATCLASS=array_report[9];
				var P_ORDER_ID=array_report[10];
				var p_order_catlog=array_report[11].replace(/^\s+|\s+$/g, '');
				var p_multi_order_id =array_report[12].replace(/^\s+|\s+$/g, '');//66931
				document.offline_report_form.p_report_id.value=p_report_id;
				document.offline_report_form.P_USER_NAME.value=P_USER_NAME;
				document.offline_report_form.p_facility_id.value=P_FACILITY_ID;
				document.offline_report_form.p_module_id.value=p_module_id;
				document.offline_report_form.p_language_id.value=p_language_id;
				document.offline_report_form.P_LOCNCODE.value=P_LOCNCODE;
				document.offline_report_form.P_FM_ORDER_ID.value=P_FM_ORDER_ID;
				document.offline_report_form.P_TO_ORDER_ID.value=P_TO_ORDER_ID;
				document.offline_report_form.p_patient_id.value=p_patient_id;
				document.offline_report_form.P_PATCLASS.value=P_PATCLASS;
				document.offline_report_form.P_ORDER_ID.value=P_ORDER_ID;
				document.offline_report_form.p_order_catlog.value=p_order_catlog;
				document.offline_report_form.p_period_from.value=period_from;
				document.offline_report_form.p_period_to.value=period_to;
				document.offline_report_form.p_priority.value=p_priority_type;
				document.offline_report_form.p_multi_order_id.value=p_multi_order_id;//66931

				 if(result_value!==null)
				    {
					 document.offline_report_form.action = "../../eCommon/jsp/report_options.jsp";
					 document.offline_report_form.submit();
					
				    }
				}else
					{
					result_value=xmlHttp.responseText;
					}
		          		
			
			 if(formObj.patient_class.value=="OP"){
					var issue_token		= parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteria.issue_token_on_regn.value; 
					if(issue_token == 'Y'){  
						parent.parent.parent.f_query_criteria_token_info.frmDispMedicationQueryCriteriaTokenInfo.patient_id.value=formObj.patient_id.value;
						parent.parent.parent.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.btnSearch.click();
						parent.parent.parent.f_query_criteria_token_info.frmDispMedicationQueryCriteriaTokenInfo.patient_id.value="";
					}
					else{
						parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteria.patient_id.value=formObj.patient_id.value;
						parent.parent.parent.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.btnSearch.click();
						parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteria.patient_id.value=""; 
					}
				}	
				else{
				   parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteriaIP.patient_id.value=formObj.patient_id.value;
				   parent.parent.parent.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.btnSearch.click();
				   parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteriaIP.patient_id.value=""; 
				} 
		}
		
//Added for MMS-DM-CRF-0273		
async function callPharmacyApprovalStatus(){
	
	var patient_id		= document.frmPatientDetails.patient_id.value;
	
	var facility_id    = document.frmPatientDetails.facility_id.value;
	
	var episode_id    = document.frmPatientDetails.episode_id1.value;

	var episodeType =document.frmPatientDetails.episodeType.value;
	
	var policyTypeCode =document.frmPatientDetails.policy_type_code.value;

	var custCode	=document.frmPatientDetails.cust_code.value;

	var custGroupCode	=document.frmPatientDetails.cust_group_code.value;
	
	var calledForm = "PharmacyApproval";
	var pharmApprovStats= "PHIS&DISP"; 
	
	var dialogHeight	= "90vh" ;
	var dialogWidth		= "90vw" ;
	var dialogTop		= "0px" ;
	var dialogLeft		= "0px" ;
	var center			= "1" ;
	var status			="no";
	var scroll			="yes";
	var features		= "dialogLeft:" + dialogLeft + ";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "" ;
	retVal = await top.window.showModalDialog("../../eBL/jsp/BillingPharmacyApprovalDrugDetails.jsp?patinetId="+patient_id+"&episodeId="+episode_id+"&episodeType="+episodeType+"&calledForm="+calledForm+"&policyTypeCode="+policyTypeCode+"&custCode="+custCode+"&custGroupCode="+custGroupCode+"&pharmApprovStats="+pharmApprovStats,arguments,features);
}

