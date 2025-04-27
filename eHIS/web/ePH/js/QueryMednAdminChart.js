/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
09/10/2019      IN070451		   Manickavasagam						                 SKR-SCF-1265
--------------------------------------------------------------------------------------------------------------
*/
//saved on 29/10/2005
var color;
var linkactive=true;
var facilityarray=new Array();
var lastobj=0;
var currentrowid=0;

function query(){
	f_query_add_mod.location.href="../../ePH/jsp/QueryMednAdminChartFrames.jsp";
}

function validateDate(obj){
	CheckDate(obj);
}
function validateTime(obj){

	if (obj.value.length!=0){
		var retVal=chkTime(obj.value);
		if (!(retVal)){
			alert(getMessage("ENTER_TIME_FORMAT","PH"));
			//	obj.select();
			obj.focus();  
		}
	}
}

function clickPatient(rowid,querystring,noofrows,vqstring,patient_class, called_from){//called_from Added for for PMG2014-CRF-0026 [IN:052701]
	/* check if link is active or not*/
	if (!(linkactive)){
		return;
	}
	var tabObj=document.getElementById("PatientTable");
	if (noofrows>3){
		document.getElementById("max").style="display";
		//display the top frame to skip patient details
		parent.f_subframe.location.href="QueryMednAdminChartLine.jsp?"+vqstring;
	}
	showHideRows(tabObj,rowid);

	//Adjust FrameSet to display Patient line
	parent.f_colorframe.location.href="QueryMednAdminChartColor.jsp";
	parent.f_drugdetailsframe.location.href="QueryMednAdminChartDrug.jsp?"+querystring+"&patient_class="+patient_class+"&called_from="+called_from; //called_from Added for for PMG2014-CRF-0026 [IN:052701]
	//parent.OrderFrameSet.rows="0%,10%,*,8%,0%";
	parent.document.getElementById('f_subframe').style.height="0vh";
	parent.document.getElementById('f_subframe').style.width="98vw";
	parent.document.getElementById('f_summaryframe').style.height="7vh";
	parent.document.getElementById('f_summaryframe').style.width="98vw";
	parent.document.getElementById('f_drugdetailsframe').style.height="50vh";
	parent.document.getElementById('f_drugdetailsframe').style.width="98vw";
	parent.document.getElementById('f_colorframe').style.height="8vh";
	parent.document.getElementById('f_colorframe').style.width="98vw";
	parent.document.getElementById('f_admindetailsframe').style.height="0vh";
	parent.document.getElementById('f_admindetailsframe').style.width="98vw";
	
	
	
}
//to locate bed no
function locateBedNo(obj,vqstring){

	val=trimString(obj.value);
	docobj=parent.f_summaryframe.document;
	tabObj=docobj.PatientTable;
	noofrows=tabObj.rows.length;
	for (i=2;i<=noofrows ;i++ ){
		patid=eval("docobj.QueryMednAdminChartSummary.BedNo"+i).value;
		if (patid==val){
			rowid=i;
			showHideRows(tabObj,rowid);	
			encounterid=eval("docobj.QueryMednAdminChartSummary.EncounterId"+rowid).value;
			vqstring+="&relevantencounter="+encounterid;
			parent.f_drugdetailsframe.location.href="QueryMednAdminChartDrug.jsp?"+vqstring;
			obj.value="Enter Bed No";
			return;
		}
	}
	obj.value="Enter Bed No";
	alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
}
//to locate patient id
function locatePatientId(obj,vqstring){
	val=trimString(obj.value);
	docobj=parent.f_summaryframe.document;
	tabObj=docobj.PatientTable;
	noofrows=tabObj.rows.length;

	for (i=2;i<=noofrows ;i++ ){
		patid=eval("docobj.QueryMednAdminChartSummary.PatientId"+i).value;
		if (patid==val){
			rowid=i;
			showHideRows(tabObj,rowid);	
			encounterid=eval("docobj.QueryMednAdminChartSummary.EncounterId"+rowid).value;
			vqstring+="&relevantencounter="+encounterid;
			parent.f_drugdetailsframe.location.href="QueryMednAdminChartDrug.jsp?"+vqstring;
			obj.value="Enter Patient Id";
			return;
		}
	}
	obj.value="Enter Patient Id";
	alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
}
function clearField(obj){
	obj.value="";
}
function skipPatient(vqstring){
	//first refer the patient frame's form
	docobj=parent.f_summaryframe.document;
	tabObj=docobj.PatientTable;
	noofrows=tabObj.rows.length;

	if (noofrows==currentrowid){
		alert(getMessage("PH_MEDN_ADMIN_NO_MORE_PATIENT","PH"));
		return;
	}
	parent.f_drugdetailsframe.location.href="../../eCommon/html/blank.html";
	var tmp=parseInt(currentrowid)+1;
	showHideRows(tabObj,tmp);
	//get the coresponding encounter id
	encounterid=eval("docobj.QueryMednAdminChartSummary.EncounterId"+tmp).value;
	vqstring+="&relevantencounter="+encounterid;
	//Adjust FrameSet to display Patient line
	parent.f_drugdetailsframe.location.href="QueryMednAdminChartDrug.jsp?"+vqstring;

}

function reloadDosage(obj){
	admindate			=	obj.value;
	if(admindate!="") {
		mode				=	document.AdminChart.mode.value;
		relevantencounter	=	document.AdminChart.relevantencounter.value;
		date_from			=	document.AdminChart.order_date_from.value;
		date_to				=	document.AdminChart.order_date_from.value;
		past_date           =   document.AdminChart.past_dose.value;
		var locale          =   document.AdminChart.locale.value;
		future_date         =   document.AdminChart.future_dose.value;
		patient_class       =   document.AdminChart.patient_class.value;
		called_from       =   document.AdminChart.called_from.value;//Added for for PMG2014-CRF-0026 [IN:052701]
		past_date=convertDate(past_date,"DMY",locale); 
		date_from=convertDate(date_from,"DMY",locale); 
		date_to=convertDate(date_to,"DMY",locale); 
		future_date=convertDate(future_date,"DMY",locale); 
		parent.f_drugdetailsframe.location.href="../../ePH/jsp/QueryMednAdminChartDrug.jsp?mode="+mode+"&relevantencounter="+relevantencounter+"&admindate="+admindate+"&date_from="+date_from+"&date_to="+date_to+"&admindate="+admindate+"&past_date="+past_date+"&future_date="+future_date+"&patient_class="+patient_class+"&called_from="+called_from; //called_from Added for for PMG2014-CRF-0026 [IN:052701]
		parent.f_admindetailsframe.location.href="../../eCommon/html/blank.html";
		//parent.OrderFrameSet.rows="0%,10%,*,8%,0%";//Added for for PMG2014-CRF-0026 [IN:052701]
		parent.document.getElementById('f_subframe').style.height="0vh";
		parent.document.getElementById('f_subframe').style.width="99vw";
		parent.document.getElementById('f_summaryframe').style.height="7vh";
		parent.document.getElementById('f_summaryframe').style.width="99vw";
		parent.document.getElementById('f_drugdetailsframe').style.height="71vh";
		parent.document.getElementById('f_drugdetailsframe').style.width="99vw";
		parent.document.getElementById('f_colorframe').style.height="8vh";
		parent.document.getElementById('f_colorframe').style.width="99vw";
		parent.document.getElementById('f_admindetailsframe').style.height="0vh";
		parent.document.getElementById('f_admindetailsframe').style.width="99vw";
	}
}
 
function reloadResult(from_dt,to_dt) {
	var localeName = document.AdminChart.locale.value;
	var dishd;//Added for ML-BRU-SCF-1177
	var dishdflg="N";//Added for ML-BRU-SCF-1177
	var ordval;//Added for ML-BRU-SCF-1177
	if(validateDates(document.AdminChart) ) {
		if(from_dt.value!="" && to_dt.value!="") { 
			admindate			=	"";
			mode				=	document.AdminChart.mode.value;
			relevantencounter	=	document.AdminChart.relevantencounter.value;
			ordval 				= 	document.AdminChart.orderby.value;//Added for ML-BRU-SCF-1177
			dishd =                 document.getElementById("hold_discontinue_yn");//Added for ML-BRU-SCF-1177
			if(dishd.checked)//Added for ML-BRU-SCF-1177
				dishdflg = "Y";
			patient_class       =   document.AdminChart.patient_class.value;
			called_from       =   document.AdminChart.called_from.value;//Added for for PMG2014-CRF-0026 [IN:052701]
			date_from	        =	convertDate(document.AdminChart.order_date_from.value,"DMY",localeName,"en");
			date_to	            =	convertDate(document.AdminChart.order_date_to.value,"DMY",localeName,"en");
			parent.f_drugdetailsframe.location.href="../../ePH/jsp/QueryMednAdminChartDrug.jsp?mode="+mode+"&relevantencounter="+relevantencounter+"&admindate="+admindate+"&date_from="+date_from+"&date_to="+date_to+"&patient_class="+patient_class+"&dishdflg="+dishdflg+"&ordval="+ordval+"&called_from="+called_from;//Added dishdflg,ordval for ML-BRU-SCF-1177 //called_from Added for for PMG2014-CRF-0026 [IN:052701]
			parent.f_admindetailsframe.location.href="../../eCommon/html/blank.html";
			//parent.OrderFrameSet.rows="0%,10%,*,8%,0%";//Added for for PMG2014-CRF-0026 [IN:052701]
			parent.document.getElementById('f_subframe').style.height="0vh";
			parent.document.getElementById('f_subframe').style.width="99vw";
			parent.document.getElementById('f_summaryframe').style.height="7vh";
			parent.document.getElementById('f_summaryframe').style.width="99vw";
			parent.document.getElementById('f_drugdetailsframe').style.height="71vh";
			parent.document.getElementById('f_drugdetailsframe').style.width="99vw";
			parent.document.getElementById('f_colorframe').style.height="8vh";
			parent.document.getElementById('f_colorframe').style.width="99vw";
			parent.document.getElementById('f_admindetailsframe').style.height="0vh";
			parent.document.getElementById('f_admindetailsframe').style.width="99vw";
		}
	}
}

function showHideRows(tabObj,rowid){
	
	currentrowid=rowid;
	for (i=0; i<tabObj.rows.length; i++){
		row=tabObj.rows[i];
		if (row.id==rowid){
			//Change the background color and display
			for(var k=0;k<row.cells.length;k++){
				color=row.cells[k].style.backgroundColor;
				row.cells[k].style.cursor="normal";
				row.cells[k].style.color="black";
				row.cells[k].style.backgroundColor="#FFD7D7";
				row.style="display";
				linkactive=false;
			}
		}
		else{
			//we hide the rest of the rows and change their color back to normal
			if (row.id!="header"){
				var vclass;
				if (i%2==0){
					vclass="#F0F0F2";
				}
				else{
					vclass="#E2E3F0";
				}
				for(var k=0;k<row.cells.length;k++){
					row.cells[k].style.backgroundColor=vclass;
				}					
				row.style.display="none";
			}
		}
	}
}

function expand(){
	linkactive=true;
		//Set Size..
	//parent.OrderFrameSet.rows="0%,100%,0%,0%,0%";
	parent.document.getElementById('f_subframe').style.height="0vh";
	parent.document.getElementById('f_subframe').style.width="0vw";
	parent.document.getElementById('f_summaryframe').style.height="100vh";
	parent.document.getElementById('f_summaryframe').style.width="100vw";
	parent.document.getElementById('f_drugdetailsframe').style.height="0vh";
	parent.document.getElementById('f_drugdetailsframe').style.width="0vw";
	parent.document.getElementById('f_colorframe').style.height="0vh";
	parent.document.getElementById('f_colorframe').style.width="0vw";
	parent.document.getElementById('f_admindetailsframe').style.height="0vh";
	parent.document.getElementById('f_admindetailsframe').style.width="0vw";
	//Display all rows
	docobj=document;
	docobj.max.style.display="none";
	var tabObj=docobj.PatientTable;
	for (i=0; i<tabObj.rows.length; i++){
		row=tabObj.rows[i];
		if (row.name!="header"){
			row.cells[1].style.cursor="pointer";
			row.cells[1].style.color="blue";
		}
		//Change the background color
		if (row.style.display=="none"){
			row.style="display";
		}
		else{
			if (row.name!="header"){
				for(var k=0;k<row.cells.length;k++){
					row.cells[k].style.backgroundColor=color;
				}
			}
		}
	}
}

function callResultPage(){
	var formObj		=	document.FormQueryMednAdminChart;
	var errorPage	= "../../eCommon/jsp/error.jsp" ;
	/* Check if either nursing unit or patient id or encounter id is entered */
	var pid	=	formObj.Patient_Id.value;
	var eid	=	formObj.encounterId.value;// Encounter_Id is changed to encounterId for ML-BRU-SCF-0499[IN035594] and SKR-SCF-0721[IN036365]	
	var called_from	=	formObj.called_from.value;// Added for PMG2014-CRF-0026 [IN:052701]
	var patient_class	=	formObj.patient_class.value;

	if ((pid=="")) {
		parent.parent.messageFrame.location.href=errorPage+"?err_num="+getMessage("PATIENT_ID_REQUIRED","PH"); 
		return;
	}
	parent.f_orderframe.location.href="../../ePH/jsp/QueryMednAdminChartOrderFrame.jsp?patientid="+pid+"&encounterid="+eid+"&patient_class="+patient_class+"&called_from="+called_from;
	parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
}

async function callPatientSearch(target){
	var patient_id = await PatientSearch();
	if (typeof(patient_id)=="string"){
 		 target.value = patient_id;
		 target.focus();
	}
}

function reset(){
	url=f_query_add_mod.location.href;
	if (url.indexOf('blank')!=-1){
		return;
	}

	var formObj = f_query_add_mod.f_queryCriteria.FormQueryMednAdminChart;
	
	formObj.reset();
	//added for SKR-SCF-0721 [IN:036365] - clear encounter id
	var len =formObj.Encounter_Id.options.length;
	for(var i=0;i<len;i++) {
		formObj.Encounter_Id.remove("encounterIds") ;
	}
	var element ;
	element= f_query_add_mod.f_queryCriteria.document.createElement('OPTION') ;
	element.value		=  '' ;
	element.text		= "    ---"+getLabel("Common.defaultSelect.label","common")+"---" ;
	formObj.Encounter_Id.add(element);
	//added for SKR-SCF-0721 [IN:036365] - end
	messageFrame.location.href="../../eCommon/jsp/error.jsp";
	f_query_add_mod.f_orderframe.location.href="../../eCommon/html/blank.html";
}

 async function callAdminDetails(eid,drug_code,order_id,schdatetime,facilityid,adminyn,obj,schqty) {
	changeColor(obj);
	var dialogHeight	= "400px";
	var dialogWidth		= "700px";
	var dialogTop		= "250";
	var dialogLeft		= "200";
	var center			= "0";
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "";
	retVal 				=   await window.showModalDialog("../../ePH/jsp/QueryMednAdminChartAdminFrames.jsp?order_id="+order_id+"&encounter_id="+eid+"&schdatetime="+schdatetime+"&ord_drug_code="+drug_code+"&facility_id="+facilityid+"&adminyn="+adminyn+"&schqty="+schqty,arguments,features);
}

function loadAdminDetails(eid,drug_code,drug_desc,order_id,schdatetime,facilityid,admintime,adminyn,obj,te_qty,iv_prep_yn,sch_dosage_uom_code,order_line_num, dosage_seq_no){ //order_line_num newly added for 30030
	changeColor(obj);
	if (adminyn=='Y'){
		//parent.OrderFrameSet.rows="7%,19%,39%,7%,*";
		//parent.OrderFrameSet.rows="0,10%,64%,8%,*";
		parent.document.getElementById('f_subframe').style.height="0vh";
		parent.document.getElementById('f_subframe').style.width="98vw";
		parent.document.getElementById('f_summaryframe').style.height="7vh";
		parent.document.getElementById('f_summaryframe').style.width="98vw";
		parent.document.getElementById('f_drugdetailsframe').style.height="50vh";
		parent.document.getElementById('f_drugdetailsframe').style.width="98vw";
		parent.document.getElementById('f_colorframe').style.height="8vh";
		parent.document.getElementById('f_colorframe').style.width="98vw";
		parent.document.getElementById('f_admindetailsframe').style.height="30vh";
		parent.document.getElementById('f_admindetailsframe').style.width="98vw";
	}
	else{
		//parent.OrderFrameSet.rows="7%,19%,39%,7%,*";
		//parent.OrderFrameSet.rows="0,10%,64%,8%,*";// modified for SKR-SCF-1265
		parent.document.getElementById('f_subframe').style.height="0vh";
		parent.document.getElementById('f_subframe').style.width="98vw";
		parent.document.getElementById('f_summaryframe').style.height="7vh";
		parent.document.getElementById('f_summaryframe').style.width="98vw";
		parent.document.getElementById('f_drugdetailsframe').style.height="50vh";
		parent.document.getElementById('f_drugdetailsframe').style.width="98vw";
		parent.document.getElementById('f_colorframe').style.height="8vh";
		parent.document.getElementById('f_colorframe').style.width="98vw";
		parent.document.getElementById('f_admindetailsframe').style.height="30vh";
		parent.document.getElementById('f_admindetailsframe').style.width="98vw";
	}
	var patient_class=	document.AdminChart.patient_class.value;
	var localeName = document.AdminChart.locale.value;
	schdatetime = convertDate(schdatetime,"DMY",localeName,"en");
	parent.f_admindetailsframe.location.href="../../ePH/jsp/QueryMednAdminChartAdminDetails.jsp?order_id="+order_id+"&encounter_id="+eid+"&schdatetime="+schdatetime+"&ord_drug_code="+drug_code+"&drug_desc="+encodeURIComponent(drug_desc,"UTF-8")+"&facility_id="+facilityid+"&adminyn="+adminyn+"&patient_class="+patient_class+"&admintime="+admintime+"&te_qty="+te_qty+"&iv_prep_yn="+iv_prep_yn+"&sch_dosage_uom_code="+sch_dosage_uom_code+"&order_line_num="+order_line_num+"&dosage_seq_no="+dosage_seq_no;  //order_line_num newly added for inc 30030
}

function closeAdminDtl(callFrom){ // Added for PMG2014-CRF-0026 [IN:052701]
	if(callFrom!='SCH')
	{
		//parent.OrderFrameSet.rows="0%,10%,*,8%,0%";
		parent.document.getElementById('f_subframe').style.height="0vh";
		parent.document.getElementById('f_subframe').style.width="98vw";
		parent.document.getElementById('f_summaryframe').style.height="7vh";
		parent.document.getElementById('f_summaryframe').style.width="98vw";
		parent.document.getElementById('f_drugdetailsframe').style.height="80vh";
		parent.document.getElementById('f_drugdetailsframe').style.width="98vw";
		parent.document.getElementById('f_colorframe').style.height="8vh";
		parent.document.getElementById('f_colorframe').style.width="98vw";
		parent.document.getElementById('f_admindetailsframe').style.height="0vh";
		parent.document.getElementById('f_admindetailsframe').style.width="98vw";
	}
	else
		parent.MedicationAdministrationFixedTimeFrameSet.rows="14%,*,0%,8%";
}

function changeColor(obj){
	if (lastobj!="0"){
		lastobj.style.backgroundColor="white";
	}
	obj.style.backgroundColor="#FFD7D7";
	lastobj=obj;
}

async function callAllDose() {
	fromtime			=	document.AdminChart.fromtime.value;
	totime				=	document.AdminChart.totime.value;
	mode				=	document.AdminChart.mode.value;
	facilityid			=	document.AdminChart.facilityid.value;
	helddiscontinued	=	document.AdminChart.helddiscontinued.value;
	relevantencounter	=	document.AdminChart.relevantencounter.value;	

	var dialogHeight	= "400px";
	var dialogWidth		= "700px";
	var dialogTop		= "10";
	var dialogLeft		= "200";
	var center			= "0";
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "";
	retVal 				= await window.showModalDialog("../../ePH/jsp/QueryMednAdminChartDoseFrames.jsp?fromtime="+fromtime+"&totime="+totime+"&mode="+mode+"&facilityid="+facilityid+"&helddiscontinued="+helddiscontinued+"&relevantencounter="+relevantencounter,arguments,features);
}


function callMednResult(called_from) {
	if(called_from!="") {
		callResultPage();
	}
}

function validateDates(frmObj) {
	var return_val	=	true;
	var localeName = document.AdminChart.locale.value;
	var fm_date		=	document.AdminChart.order_date_from;
	var to_date		=	document.AdminChart.order_date_to;

	var min_date	=	convertDate(frmObj.min_fm_date.value,"DMY","en",localeName);
	var max_date	=	convertDate(frmObj.max_to_date.value,"DMY","en",localeName);

	if(fm_date.value!="" && to_date.value!="") {
		
		if(min_date.value!="" && !doDateCheckAlert(min_date,fm_date))	{
			alert(getMessage("FROM_DATE_GREATER","PH")+" "+min_date);
			return_val	=	false;
		} 
		else 	if(max_date.value!="" && !doDateCheckAlert(to_date,max_date))	{
			alert(getMessage("TO_DATE_LESSER","PH")+" "+max_date);
			return_val	=	false;
		}		
	} 
	else {
		if(fm_date.value=="") {
 			alert(getMessage("PH_FROM_TIME_NOT_BLANK","PH"));
		}
		else if(to_date.value=="") {
			alert(getMessage("PH_TO_TIME_NOT_BLANK","PH"));
		}
	}
	if(!DateCheck(fm_date,to_date))
		return_val	=	false;
	return return_val;
}

function uppercase() {
	key = window.event.keyCode;
	if((key>0x60) && (key< 0x7B))
		window.event.keyCode=key-0x20;
}

function setEncounterID(retVal) { 
   /*added for ML-BRU-SCF-0499[IN035594] --Start */  
    var formObj = document.FormQueryMednAdminChart.Encounter_Id;
	var returnVal = retVal.split(',');
	var element ;  	
	for(var i=0;i<returnVal.length;i++) {
		element= document.createElement('OPTION') ;
		var returnValue = returnVal[i].split('~');		
		document.FormQueryMednAdminChart.patient_class.value = returnValue[1];
		element.value		=  returnVal[i]; /*returnValue[0] changed to returnVal[i]  for ML-BRU-SCF-0499[IN035594] and SKR-SCF-0721[IN036365] */ 
		element.text		=  returnValue[0] ;
		formObj.add(element);
	 }	
	setEncDtl(document.FormQueryMednAdminChart.Encounter_Id); //code added for ML-BRU-SCF-0499[IN035594] and SKR-SCF-0721[IN036365]
	/* added for ML-BRU-SCF-0499[IN035594] --end */	 
}
function defaultEncounter(patient_id,patient_len) {//patient_len added for ML-BRU-SCF-0499[IN035594] and SKR-SCF-0721[IN036365]
	/*code comment and added new code for ML-BRU-SCF-0499[IN035594] and SKR-SCF-0721[IN036365] */ 
	if(patient_id !=null && patient_id !=''){		
		if(patient_id.length == parseInt(patient_len)){	
			//if(trimString(patient_id)!=""){
			 /* added for ML-BRU-SCF-0499[IN035594] --Start */
			/*var formObj = document.FormQueryMednAdminChart.Encounter_Id;
			var intTotalItems= formObj.options.length;  
			for(var intCounter=intTotalItems;intCounter>=0;intCounter--){     
				formObj.remove(intCounter);
			}*/
			/* added for ML-BRU-SCF-0499[IN035594] --End */
			clearEncounterDtl();
	/*code comment and added new code for ML-BRU-SCF-0499[IN035594] and SKR-SCF-0721[IN036365] */ 
			var xmlStr ="<root><SEARCH ";
			xmlStr+= "bean_id  ='QueryMednAdminChartBean' " ;
			xmlStr+= "bean_name = 'ePH.QueryMednAdminChartBean' " ;
			xmlStr+= "patient_id =\"" + patient_id + "\" " ;
			xmlStr +=" /></root>";
			var temp_jsp="ReportsValidate.jsp?called_from=populateEncounter";
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST",temp_jsp,false); 
			xmlHttp.send(xmlDoc);
			responseText=xmlHttp.responseText ;
			eval(responseText);
	   }
	else{ // else part added for ML-BRU-SCF-0499[IN035594] and SKR-SCF-0721[IN036365]
		defaultOption();
		alert(getMessage("PH_NOT_VALID_PATIENT","PH"));
		return false;	
		}
	}	
}
/* Below functions added  for ML-BRU-SCF-0499[IN035594] and SKR-SCF-0721[IN036365] --Start */ 
function setEncDtl(obj) {
	var encDtl = obj.value;
	if(encDtl != ''){
		var encDtls = encDtl.split('~');
		document.FormQueryMednAdminChart.encounterId.value=encDtls[0];	
		document.FormQueryMednAdminChart.patient_class.value=encDtls[1];
	}
}
function  defaultOption(){
	clearEncounterDtl();
	var element ;
	element= document.createElement('OPTION') ;
	element.value		=  '' ;
	element.text		= "    ---"+getLabel("Common.defaultSelect.label","common")+"---" ;
	document.FormQueryMednAdminChart.Encounter_Id.add(element);
}

function clearEncounterDtl(){
	var len =document.FormQueryMednAdminChart.Encounter_Id.options.length;
	for(var i=0;i<len;i++) {
		document.FormQueryMednAdminChart.Encounter_Id.remove("encounterIds") ;
	}
}
/* above functions added for ML-BRU-SCF-0499[IN035594] and SKR-SCF-0721[IN036365] --End */ 
function DateCheck(from,to) {

    var fromarray;
    var toarray;
    var fromdate = from.value ;
    var todate = to.value ;

    if(fromdate.length > 0 && todate.length > 0 ) {
		if(!isBefore(fromdate,todate,'DMY', document.AdminChart.locale.value)){
			alert( getMessage("TO_DT_GR_EQ_FM_DT","PH")) ;
               return false; 
		}

/* 			fromarray = fromdate.split("/");
			toarray = todate.split("/");
            var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
            var todt = new Date(toarray[2],toarray[1],toarray[0]);

            if(Date.parse(todt) > Date.parse(fromdt)) 
            {
               alert( getMessage("TO_DT_GR_EQ_FM_DT","PH")) ;
               return false;       
            }
            else if(Date.parse(todt) <= Date.parse(fromdt)) */
		return true;
    }
    return true;
}

function CheckPositiveNum(obj) {
    if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) {
    }
    else {
        if ( obj.value.length > 0 ) {
            alert(getMessage("INVALID_POSITIVE_NUMBER", "Common"));
            obj.select();
            obj.focus();
        }
        else if ( obj.value.length == 0 )
            obj.value = "";
    }
}
function SubmitLink(from, to) {
    document.forms[0].from.value = from;
    document.forms[0].to.value = to;
    document.forms[0].submit() ;
}
 
function Duplicatecheck(){   /* Below code added for ML-BRU-SCF-0621[IN036565] -- Start */
	var patientId = document.FormQueryMednAdminChart.Patient_Id.value; 
	if( (patientId != null) && (patientId !="")){
		var	bean_id			= "QueryPatientDrugProfileBean" ;
		var	bean_name		= "ePH.QueryPatientDrugProfileBean";
		var xmlStr ="<root><SEARCH ";	
		xmlStr+= "patientId=\"" + patientId + "\" " ;
		xmlStr+= "chkPatientID=\"false\" " ;	
		xmlStr+= "bean_id=\"" + bean_id + "\" " ;	
		xmlStr+= "bean_name=\"" + bean_name + "\" " ;	
		xmlStr +=" /></root>";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "QueryPatientDrugProfileValidation.jsp?func_mode=Duplicate&bean_id=" + bean_id + "&bean_name=" +bean_name+"&patientId="+patientId, false ) ;	
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;		
		eval(responseText);		
	}	
} 

function mergedPatientAlert(main_patientid){ 
	msg = getMessage('PATIENT_MERGED_VALID','MP');
	msg= msg.replace('#',main_patientid);
	alert(msg);
	document.FormQueryMednAdminChart.Patient_Id.value=main_patientid;    
}/* code added for ML-BRU-SCF-0621[IN036565] -- End */

function showToolTipLockStatus(obj,disc_pract){//Added for ML-BRU-SCF-1177--start
	obj.title=disc_pract;
}//Added for ML-BRU-SCF-1177--end
