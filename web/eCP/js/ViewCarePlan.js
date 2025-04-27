var temp_val = "";
var temp_hval = "";
var a_diag = new Array();
var a_goal = new Array();
var a_outcome = new Array();
var error_remarks = "";

function resetval(obj,pct,row_count,row_name)
{
	if(obj.innerText=="*")
	{
		if(row_name=="Diag")
		{
			temp_id = eval("document.view_cp_diagandgoallist.tempidvaldiag"+row_count+".value");
			chkval = eval("document.view_cp_diagandgoallist.dx_prog_pct"+row_count+".value")
			if(pct!=0)
			{
				row_id = pct/4;
				row_id = row_id + 1;
				row_id = row_id + "";
				row_id = row_id + row_count
			}
			else
			{
				row_id = 1 + "";
				row_id = row_id+row_count;
			}
			obj.innerText = "";
			var intext = document.getElementById("id"+row_i).innerText;
			if(chkval==0)
			{
				eval("document.all."+temp_id).innerText = "[";
				eval("document.all."+temp_id).style.color = "black";
				eval("document.all."+temp_id).style.fontWeight = "bolder";
			}
			else if(chkval==100)
			{
				eval("document.all."+temp_id).innerText = "]";
				eval("document.all."+temp_id).style.color = "black";
				eval("document.all."+temp_id).style.fontWeight = "bolder";
			}
			else
				eval("document.all."+temp_id).innerText = "-";

			if((intext == "-")||(intext == "|"))
				document.getElementById("id"+row_id).innerText = "|";
			else if(intext == "[")
				document.getElementById("id"+row_id).style.color = "red";
			else if(intext == "]")
			document.getElementById("id"+row_id).style.color = "green";

			eval("document.view_cp_diagandgoallist.evaluated_diag_yn"+row_count).value = "N";
			// added on nov 8
			//alert("Before "+(eval("document.view_cp_diagandgoallist.DiagmsrID"+row_count).value));
			eval("document.view_cp_diagandgoallist.DiagmsrID"+row_count).value = "";
//			alert("After "+(eval("document.view_cp_diagandgoallist.DiagmsrID"+row_count).value));
		}
		else if(row_name=="Goal")
		{
			temp_id = eval("document.view_cp_diagandgoallist.tempidvalgoal"+row_count+".value");
			chkval = eval("document.view_cp_diagandgoallist.goal_prog_pct"+row_count+".value")
			row_id = pct/4;
			row_id = row_id + 1;
			row_id = row_id + "";
			row_id = row_id + row_count
			obj.innerText = "";
			var intext = document.getElementById("ids"+row_id).innerText;
			if(chkval==0)
			{
				eval("document.all."+temp_id).innerText = "[";
				eval("document.all."+temp_id).style.color = "black";
				eval("document.all."+temp_id).style.fontWeight = "bolder";
			}
			else if(chkval==100)
			{
				eval("document.all."+temp_id).innerText = "]";
				eval("document.all."+temp_id).style.color = "black";
				eval("document.all."+temp_id).style.fontWeight = "bolder";
			}
			else
				eval("document.all."+temp_id).innerText = "-";

			if((intext == "-")||(intext == "|"))
				document.getElementById("ids"+row_id).innerText = "|";
			else
			document.getElementById("ids"+row_id).style.color = "red";
			eval("document.view_cp_diagandgoallist.evaluation_goal_yn"+row_count).value = "N";
			// added on nov 8
			//alert("Before "+(eval("document.view_cp_diagandgoallist.GoalmsrID"+row_count).value));
			eval("document.view_cp_diagandgoallist.GoalmsrID"+row_count).value = "";
			//alert("After "+(eval("document.view_cp_diagandgoallist.GoalmsrID"+row_count).value));
		}
		else if(row_name=="Outcome")
		{
			temp_id = eval("document.view_cp_intvnandoutcomelist.tempidvaloutcome"+row_count+".value");
			chkval = eval("document.view_cp_intvnandoutcomelist.outcome_prog_pct"+row_count+".value")
			row_id = pct/4;
			row_id = row_id + 1;
			row_id = row_id + "";
			row_id = row_id + row_count
			obj.innerText = "";
			var intext = document.getElementById("ids"+row_id).innerText;
			if(chkval==0)
			{
				eval("document.all."+temp_id).innerText = "[";
				eval("document.all."+temp_id).style.color = "black";
				eval("document.all."+temp_id).style.fontWeight = "bolder";
			}
			else if(chkval==100)
			{
				eval("document.all."+temp_id).innerText = "]";
				eval("document.all."+temp_id).style.color = "black";
				eval("document.all."+temp_id).style.fontWeight = "bolder";
			}
			else
				eval("document.all."+temp_id).innerText = "-";

			if((intext == "-")||(intext == "|"))
				document.getElementById("ids"+row_id).innerText = "|";
			else
				document.getElementById("ids"+row_id).style.color = "red";

			eval("document.view_cp_intvnandoutcomelist.evaluation_outcome_yn"+row_count).value = "N";
	// added on nov 8
			//alert("Before "+(eval("document.view_cp_intvnandoutcomelist.OutcomemsrID"+row_count).value));
			eval("document.view_cp_intvnandoutcomelist.OutcomemsrID"+row_count).value = "";
			//alert("After "+(eval("document.view_cp_intvnandoutcomelist.OutcomemsrID"+row_count).value));

		}
	}
}
function AllowDateFormat(event)
{
   var key = window.event.keyCode;
   if( ! ( (( key>=48 ) && ( key<58 ) ) || (key == 47)) )
	{
		return false;
	}
}
function showCal(obj, obj_id)
{
	showCalendar(obj_id);
	obj.focus();
}
function popuval()
{
	if(document.view_cp_crit.view_src.value!="")
	{
		var selected_locn_type = document.view_cp_crit.view_src.value;
		var type = "selected_locn_type";
		var htmlvalue = "<html><body><form name='dynamic_value' id='dynamic_value' method='post' action='../../eCP/jsp/ViewCarePlanDynamicValues.jsp'><input type='hidden' name='selected_locn_type' id='selected_locn_type' value='"+selected_locn_type+"'><input type='hidden' name='type' id='type' value='"+type+"'></form></body></html>"
		parent.view_cp_dyn_val.document.write(htmlvalue);
		parent.view_cp_dyn_val.document.dynamic_value.submit();
	}
}

async function show_CareManager(obj,target_desc,target_code)
{
	var retVal = 	new String();
	var dialogHeight= "76vh" ;
	var dialogWidth	= "45vw" ;
	var dialogLeft="500";
	var status = "no";
	var arguments	= "" ;
	var sql="";
	var search_code="";
	var search_desc="";
	var dispDescFirst="dispDescFirst";
	var tit="Care Manager";
	var practtype="";
	var facilty_id=document.view_cp_crit.facilty_id.value;
	sql  = "select practitioner_id,practitioner_name from am_pract_for_facility_vw where operating_facility_id =`"+facilty_id+"` and eff_status = `E` ";
	search_code = "practitioner_id";
	search_desc = "practitioner_name";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status+";dialogLeft:"+dialogLeft+";";
	retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit+"&dispDescFirst="+dispDescFirst,arguments,features);
	var arr=new Array();
	if (!(retVal == null))
	{
		var ret1=unescape(retVal);
		arr=ret1.split("::");
		target_desc.value=arr[0];
		target_code.value=arr[1];
		document.view_cp_crit.care_manager_id.value=arr[1];
	}
	else
	{
		target_desc.value="";
		target_code.value="";
	}
}

function callresult()
{

	var p_patient_id = document.getElementById('patient_id').value
	var care_manager_id = document.getElementById('care_manager_id').value
	var term_set_id = document.getElementById('view_diag').value
	
	var term_code = document.getElementById('diagnosis').value
	
	var facilty_id = document.getElementById('facilty_id').value
	var encounter_id = document.getElementById('encounter_id').value
	var from_date = document.getElementById('view_id_frmdate').value
	var to_date= document.getElementById('view_id_todate').value
	var view_plans= document.getElementById('view_plans').value
	var view_summary= document.getElementById('view_summary').value
	parent.view_cp_result.location.href = "../../eCP/jsp/ViewCarePlanActivePlansResult.jsp?p_patient_id="+p_patient_id+"&facilty_id="+facilty_id+"&encounter_id="+encounter_id+"&p_care_manager_id="+care_manager_id+"&p_term_set_id="+term_set_id+"&p_term_code="+term_code+"&p_fr_date="+from_date+"&p_to_date="+to_date+"&view_plans="+view_plans+"&view_summary="+view_summary;
	parent.view_cp_tabs.location.href = "../../eCommon/html/blank.html";
	parent.view_cp_detail.location.href = "../../eCommon/html/blank.html";
	

}

function clearresult()
{
	parent.view_cp_criteria.document.view_cp_crit.reset();
	parent.view_cp_result.location.href = "../../eCommon/html/blank.html";
	parent.view_cp_tabs.location.href = "../../eCommon/html/blank.html";
	parent.view_cp_detail.location.href = "../../eCommon/html/blank.html"
	callresult();
}

function PatientSearch() 
{
	var url     = "../../eMP/jsp/ModelPatientSearch.jsp";
	var dialogTop       = "61";
	var dialogHeight    = "35" ;
	var dialogWidth = "50" ;
	var arguments   = "" ;
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; status:no" ;
	var returnval = window.showModalDialog( url, arguments, features ) ;
	return returnval;
}
function chkfrmdate()
{
	if(!doDateCheckAlert(document.view_cp_crit.view_id_frmdate,document.view_cp_crit.view_id_todate))
	{
		alert("APP-SM0012 - To Date should be greater than or equal to From Date");
		document.view_cp_crit.view_id_todate.focus();
		document.view_cp_crit.view_id_todate.select();
	}
}

function Load_Diagnosis()
{
 clearDiagnosis();
 var frmObj=document.forms[0];
 var patient_id=frmObj.p_patient_id.value;
 var diagnosis_set=frmObj.view_diag[frmObj.view_diag.selectedIndex].value;
 var xmlDoc="" ;
 var xmlHttp = new XMLHttpRequest() ;
 xmlStr ="<root><SEARCH " ;
 xmlStr +=" /></root>" ;
 //xmlDoc.loadXML( xmlStr);
 xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
 xmlHttp.open( "POST","../../eCP/jsp/ViewCarePlanDynamicValues.jsp?diagnosis_set="+diagnosis_set+"&patient_id="+patient_id+"&type=view_diag", false);
 xmlHttp.send( xmlDoc ) ;
 responseText=xmlHttp.responseText ;
 eval(responseText);
}
function addDiagnosis(code,value)
{
   var element = document.createElement('OPTION');
   element.value =  code;
   element.text = value;
   parent.view_cp_criteria.document.forms[0].diagnosis.add(element);
   var diagnosis = parent.view_cp_criteria.document.forms[0].diagnosis;
   if(diagnosis.options[0].value)
	   {
	   var diagnosis_ele = diagnosis.options[0].value;
	   if(diagnosis_ele.includes("Select"))
		   {
		   diagnosis.options[0].value = "";
 		   }
	   }
}
function clearDiagnosis( ) {
	var len = eval("document.forms[0].diagnosis.options.length") ;
	for(var i=0;i<len;i++){
		eval("document.forms[0].diagnosis.remove(\"diagnosis\")") ;
	}
	var tp 		= "  ---Select---  " ;
	var opt  	= eval("document.createElement(\"OPTION\")") ;
	opt.text 	= tp ;
	eval("document.forms[0].diagnosis.add(opt)") ;
}
async function calltasklist(obj,care_plan_id,md_plan_id,patient_id,intvncode,encounter_id)
{

	var facilty_id = parent.view_cp_criteria.document.view_cp_crit.facilty_id.value;
	var p_care_mgr_id = parent.view_cp_result.document.view_cp_result.p_care_mgr_id.value;
	url = "../../eCA/jsp/PatTaskListGeneratePlan.jsp?care_plan_id="+care_plan_id+"&md_care_plan_id="+md_plan_id+"&PatientId="+patient_id+"&encounterId="+encounter_id+"&taskCode="+intvncode+"&ca_practitioner_id="+p_care_mgr_id+"&facility_id="+facilty_id;
	var dialogHeight = '75vh';
	var dialogWidth = '65vw' ;
	var dialogTop	= '90';
	var dialogLeft = '0' ;
	var arguments   = "" ;
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; status:no" ;
	var returnval = await top.window.showModalDialog( url, arguments, features ) ;
}

function callDetailFrame(index){
	if(parent.view_cp_result.view_cp_result!=null){
		var from=0;
		var to=0;
		if(document.view_cp_result.from.value !="")
			from=parseInt(document.view_cp_result.from.value);
		if(document.view_cp_result.to.value !="")
			to=parseInt(document.view_cp_result.to.value);
		if(document.view_cp_result.maxRecord.value !="")
			maxRecord=parseInt(document.view_cp_result.maxRecord.value)
		if(to>maxRecord)
			to=maxRecord;			
		var classVal='FONTVALS';
		for(j=from;j<=to;j++){			
			if(j==index){			
				classVal='CLASSHEADDIAGROW';
			}else{
				classVal='FONTVALS';
			}			
			cellref = document.getElementById('selectedRow'+j).cells
			for(k=0; k<cellref.length; k++)
			{
				cellref[k].className = classVal;
			}				
		}
		parent.view_cp_tabs.location.href = "../../eCP/jsp/ViewCarePlanTabs.jsp?index="+index;
	}
}
function change_common_tab(obj,called_from,index)
{ 
			if(called_from =="ON_LOAD"){
				colorChange();
				var care_plan_id = eval("parent.view_cp_result.document.view_cp_result.care_plan_id"+index).value
				var md_care_plan_id = eval("parent.view_cp_result.document.view_cp_result.md_care_plan_id"+index).value
				var patient_id =parent.view_cp_criteria.document.view_cp_crit.p_patient_id.value;
				var encounter_id = parent.view_cp_result.document.view_cp_result.encounter_id.value;
				var care_mgr_name = eval("parent.view_cp_result.document.view_cp_result.care_mgr_name"+index).value;
				var curr_status = eval("parent.view_cp_result.document.view_cp_result.curr_status"+index).value;
				var cp_start_date = eval("parent.view_cp_result.document.view_cp_result.start"+md_care_plan_id+care_plan_id+patient_id).value;
				var cp_target_date = eval("parent.view_cp_result.document.view_cp_result.target"+md_care_plan_id+care_plan_id+patient_id).value;
				parent.view_cp_detail.location.href = "../../eCP/jsp/ViewCarePlanDiagnosis.jsp?care_plan_id="+care_plan_id+"&md_care_plan_id="+md_care_plan_id+"&PatientId="+patient_id+"&encounterId="+encounter_id+"&care_mgr_name="+care_mgr_name+"&cp_start_date="+cp_start_date+"&cp_target_date="+cp_target_date+"&curr_status="+curr_status;
			}else{
				if(obj=="Diagnosis" )
				{	
					colorChange();
					var care_plan_id = eval("parent.view_cp_result.document.view_cp_result.care_plan_id"+index).value
					var curr_status = eval("parent.view_cp_result.document.view_cp_result.curr_status"+index).value;

					var md_care_plan_id = eval("parent.view_cp_result.document.view_cp_result.md_care_plan_id"+index).value
					var patient_id =parent.view_cp_criteria.document.view_cp_crit.p_patient_id.value;
					var encounter_id = parent.view_cp_result.document.view_cp_result.encounter_id.value;
					var care_mgr_name = eval("parent.view_cp_result.document.view_cp_result.care_mgr_name"+index).value
					
					var cp_start_date = eval("parent.view_cp_result.document.view_cp_result.start"+md_care_plan_id+care_plan_id+patient_id).value;
					var cp_target_date = eval("parent.view_cp_result.document.view_cp_result.target"+md_care_plan_id+care_plan_id+patient_id).value;
					parent.view_cp_detail.location.href = "../../eCP/jsp/ViewCarePlanDiagnosis.jsp?care_plan_id="+care_plan_id+"&md_care_plan_id="+md_care_plan_id+"&PatientId="+patient_id+"&encounterId="+encounter_id+"&care_mgr_name="+care_mgr_name+"&cp_start_date="+cp_start_date+"&cp_target_date="+cp_target_date+"&curr_status="+curr_status;
				}
				else if( obj=="Assessment" )
				{
					var patient_id =parent.view_cp_criteria.document.view_cp_crit.p_patient_id.value;
					var encounter_id = parent.view_cp_result.document.view_cp_result.encounter_id.value;
					var location_code = parent.view_cp_criteria.document.view_cp_crit.location_code.value;
					var location_type = parent.view_cp_criteria.document.view_cp_crit.location_type.value;
					var Sex = parent.view_cp_criteria.document.view_cp_crit.Sex.value;
					var Age = parent.view_cp_criteria.document.view_cp_crit.Age.value;
					var Dob = parent.view_cp_criteria.document.view_cp_crit.Dob.value;
					var relationship_id = parent.view_cp_criteria.document.view_cp_crit.relationship_id.value;					
					var patient_class = parent.view_cp_criteria.document.view_cp_crit.patient_class.value;					
					parent.view_cp_detail.location.href = "../../eCP/jsp/ViewCarePlanPatAssmt.jsp?p_called_from_ca=Y&appl_task_id=CP_ASSESSMENT&option_id=CP_ASSESSMENT1&patient_id="+patient_id+"&visit_id=&episode_id="+encounter_id+"&encounter_id="+encounter_id+"&location_code="+location_code+"&location_type="+location_type+"&Sex="+Sex+"&Age="+Age+"&Dob="+Dob+"&relationship_id="+relationship_id+"&patient_class="+patient_class+"&function_from=VIEW_ASSESSMENT";
					
				}
				else if(obj=="Variance")
				{
					var care_plan_id = eval("parent.view_cp_result.document.view_cp_result.care_plan_id"+index).value
					var md_care_plan_id = eval("parent.view_cp_result.document.view_cp_result.md_care_plan_id"+index).value
					var facilty_id = parent.view_cp_criteria.document.view_cp_crit.facilty_id.value;
					parent.view_cp_detail.location.href="../../eCP/jsp/ViewCarePlanVariance.jsp?p_care_plan_id="+care_plan_id+"&p_md_care_plan_id="+md_care_plan_id+"&p_var_comp_type=CP&facility_id="+facilty_id;
				}
			}
			if(top.content)
				top.content.messageFrame.location.href = "../../eCA/jsp/error1.jsp";
}

function colorChange() {
			if(document.getElementById('diagnosis'))
				document.getElementById('diagnosis').className  = "CASECONDSELECTHORZ";
			if(document.getElementById('assessment'))
				document.getElementById('assessment').className		= "CAFIRSTSELECTHORZ";
			if(document.getElementById('variance'))
				document.getElementById('variance').className		= "CAFIRSTSELECTHORZ";
}

function changeColor(obj)
{
	cellref = document.getElementById("tab").rows[0].cells

	for(i=0; i<cellref.length; i++)
	{
		cellref[i].className = 'CAFIRSTSELECTHORZ'
	}
	obj.className = "CASECONDSELECTHORZ"
	}
/***************************Diagnosis/Intervention****start**********************/
function checkForMax(obj){
	var remarks=obj.value;
	if(remarks.length > 4000){
		message=getMessage("LENGTH_CANNOT_4000");
		alert(message);
		obj.select();
		obj.focus();
	}
}
async function ShowHistory()
{
	var p_patient_id =parent.view_cp_detail.document.view_cp_detail.patient_id.value;
	var care_manager_id = parent.view_cp_detail.document.view_cp_detail.care_manager.value;
	var care_plan_id = parent.view_cp_detail.document.view_cp_detail.care_plan_id.value;
	var md_care_plan_id =parent.view_cp_detail.document.view_cp_detail.md_care_plan_id.value;
	var encounter_id = parent.view_cp_detail.document.view_cp_detail.encounter_id.value;

	var dialogHeight = '50vh';
	var dialogWidth = '60vw' ;
	var dialogTop	= '200';
	var dialogLeft = '0' ;
	var arguments   = "" ;
	var features    = "dialogHeight:"+dialogHeight+";dialogWidth:"+dialogWidth+";dialogTop:"+dialogTop+";status:no";
	var retval=new String();
	var url = "../../eCP/jsp/EvaluateCarePlanHistoryCriteria.jsp?patient_id="+p_patient_id+"&care_manager="+care_manager_id+"&care_plan_id="+care_plan_id+"&md_care_plan_id="+md_care_plan_id+"&encounter_id="+encounter_id;
	await top.window.showModalDialog(url,arguments,features);

}
/********************Assessment functions******************start****************/
function scrollViewCarePlanTable(){
	var x = document.body.scrollTop;
	if(x == 0)	{
		document.getElementById("tableStaticId").style.position = 'static';
		document.getElementById("tableStaticId").style.posTop  = 0;
	}
	else{
		document.getElementById("tableStaticId").style.position = 'relative';
		document.getElementById("tableStaticId").style.posTop  = x-1;

	}
}

//function loadViewCarePlanAddModifyFrame(status,note_desc,note_type,accession_num,assess_time,assess_date,ua_dep_desc,assess_ref_no,pat_id,pat_class,enc_id,location_code,location_type,Sex,Age,Dob,ua_dep_code,ss_dep_code,obj,reln_id,ss_dep_desc,status_flag){//IN030474
function loadViewCarePlanAddModifyFrame(status,note_desc,note_type,accession_num,assess_time,assess_date,ua_dep_desc,assess_ref_no,pat_id,pat_class,enc_id,location_code,location_type,Sex,Age,Dob,ua_dep_code,ss_dep_code,obj,reln_id,ss_dep_desc,status_flag,function_from){//IN030474

	if(status_flag != "4"){
		if(parent.patAssessmentMainFrame.framesID.rows == "10%,75%,8%,40%,0%")
			parent.patAssessmentMainFrame.framesID.rows = "10%,*,0%,0%,0%";
	//parent.patAssessmentMainFrame.patAssessmentAddModifyFrame.location.href = "../../eCP/jsp/PatientAssessmentAddModify.jsp?mode=modify&note_desc="+note_desc+"&note_type="+note_type+"&status="+status+"&assess_date="+assess_date+"&assess_time="+assess_time+"&acc_num="+accession_num+"&patient_id="+pat_id+"&patient_class="+pat_class+"&encounter_id="+enc_id+"&assess_ref_no="+assess_ref_no+"&location_code="+location_code+"&location_type="+location_type+"&Age="+Age+"&Sex="+Sex+"&Dob="+Dob+"&relationship_id="+reln_id+"&status_flag="+status_flag;//IN030474
	parent.patAssessmentMainFrame.patAssessmentAddModifyFrame.location.href = "../../eCP/jsp/PatientAssessmentAddModify.jsp?mode=modify&note_desc="+note_desc+"&note_type="+note_type+"&status="+status+"&assess_date="+assess_date+"&assess_time="+assess_time+"&acc_num="+accession_num+"&patient_id="+pat_id+"&patient_class="+pat_class+"&encounter_id="+enc_id+"&assess_ref_no="+assess_ref_no+"&location_code="+location_code+"&location_type="+location_type+"&Age="+Age+"&Sex="+Sex+"&Dob="+Dob+"&relationship_id="+reln_id+"&status_flag="+status_flag+"&function_from="+function_from;//IN030474
		if(note_type != "" && accession_num != ""){
			parent.patAssessmentMainFrame.patAssessmentPhysicianNotesFrame.location.href = "../../eCP/jsp/PatientAssessmentScoresFrames.jsp?note_type="+note_type+"&accession_num="+accession_num;
		}
	parent.patAssessmentMainFrame.patAssessmentDependencyFrame.location.href = "../../eCommon/html/blank.html";
	parent.patAssessmentMainFrame.patAssessmentDiagnosisFrame.location.href = "../../eCommon/html/blank.html";

	}
	else if(status_flag == "4")	{

		if(parent.patAssessmentMainFrame.framesID.rows == "10%,*,0%,0%,0%")
			parent.patAssessmentMainFrame.framesID.rows = "10%,75%,8%,40%,0%";
		
	parent.patAssessmentMainFrame.patAssessmentAddModifyFrame.location.href = "../../eCP/jsp/PatientAssessmentAddModify.jsp?mode=modify&note_desc="+note_desc+"&note_type="+note_type+"&status="+status+"&assess_date="+assess_date+"&assess_time="+assess_time+"&acc_num="+accession_num+"&patient_id="+pat_id+"&patient_class="+pat_class+"&encounter_id="+enc_id+"&location_code="+location_code+"&location_type="+location_type+"&Age="+Age+"&Sex="+Sex+"&Dob="+Dob+"&assess_ref_no="+assess_ref_no+"&relationship_id="+reln_id+"&status_flag="+status_flag;
		if(note_type != "" && accession_num != ""){
			parent.patAssessmentMainFrame.patAssessmentPhysicianNotesFrame.location.href = "../../eCP/jsp/PatientAssessmentScoresFrames.jsp?note_type="+note_type+"&accession_num="+accession_num;
		}
		if(ua_dep_code != "null")	{
		
			parent.patAssessmentMainFrame.patAssessmentDependencyFrame.location.href = "../../eCP/jsp/PatientAssessmentDependency.jsp?mode=modify&ststus="+status+"&ua_dep_desc="+ua_dep_desc+"&assess_ref_no="+assess_ref_no+"&ua_dep_code="+ua_dep_code+"&ss_dep_code="+ss_dep_code+"&note_type="+note_type+"&ss_dep_desc="+ss_dep_desc+"&status_flag="+status_flag;
			parent.patAssessmentMainFrame.patAssessmentDiagnosisFrame.location.href = "../../eCP/jsp/PatientAssessmentDiagnosis.jsp?mode=modify&status="+status+"&ua_dep_desc="+ua_dep_desc+"&note_type="+note_type+"&assess_ref_no="+assess_ref_no+"&note_type="+note_type+"&ss_dep_desc="+ss_dep_desc+"&status_flag="+status_flag;		
		
		}
		else if(ua_dep_code == "null"){
			parent.patAssessmentMainFrame.patAssessmentDependencyFrame.location.href = "../../eCP/jsp/PatientAssessmentDependency.jsp?mode=modify&ststus="+status+"&ua_dep_desc="+ua_dep_desc+"&assess_ref_no="+assess_ref_no+"&ua_dep_code="+ua_dep_code+"&ss_dep_code="+ss_dep_code+"&flag=modAuth&note_type="+note_type+"&accession_num="+accession_num+"&status_flag="+status_flag;
			parent.patAssessmentMainFrame.patAssessmentDiagnosisFrame.location.href = "../../eCP/jsp/PatientAssessmentDiagnosis.jsp?mode=modify&status="+status+"&ua_dep_desc="+ua_dep_desc+"&note_type="+note_type+"&assess_ref_no="+assess_ref_no+"&flag=modAuth&note_type="+note_type+"&accession_num="+accession_num+"&status_flag="+status_flag;
		}		
	}
}
/***********************Mark Error Methods***************************/
function viewCarePlanShowError(obj,plan_id,md_plan_id,current_status,patient_id,care_mgr_name)
{
	if(obj.innerText == "X")
	{
		var care_manager_id = parent.view_cp_criteria.document.view_cp_crit.care_manager_id.value;
		var term_set_id = parent.view_cp_criteria.document.view_cp_crit.view_diag.value;
		var term_code = parent.view_cp_criteria.document.view_cp_crit.diagnosis.value;
		var facilty_id = parent.view_cp_criteria.document.view_cp_crit.facilty_id.value;
		var encounter_id = parent.view_cp_criteria.document.view_cp_crit.encounter_id.value;
		var from_date = parent.view_cp_criteria.document.view_cp_crit.view_frmdate.value;
		var to_date= parent.view_cp_criteria.document.view_cp_crit.view_todate.value;
		var view_plans= parent.view_cp_criteria.document.view_cp_crit.view_plans.value;
		var view_summary= parent.view_cp_criteria.document.view_cp_crit.view_summary.value;
		var cp_start_date = eval("document.forms[0].start"+md_plan_id+plan_id+patient_id).value;
		var cp_target_date = eval("document.forms[0].target"+md_plan_id+plan_id+patient_id).value;
		var url = "";
		var encounter_id = document.forms[0].encounter_id.value;
		var dialogHeight = '31';
		var dialogWidth = window.screen.width ;
		var dialogTop	= '80';
		var dialogLeft = '0' ;
		var arguments   = "" ;
		url = "../../eCP/jsp/ViewCarePlanMarkErrorFrameset.jsp?planid="+plan_id+"&md_plan_id="+md_plan_id+"&cp_start_date="+cp_start_date+"&cp_target_date="+cp_target_date+"&care_mgr_name="+care_mgr_name+"&current_status="+current_status;
		var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; status:no" ;
		var returnval = window.showModalDialog( url, arguments, features ) ;

	}
}

function viewCarePlanShowDetail(md_plan_id,care_plan_id,eval_id)
{
	parent.view_cp_mrk_err_dtl.location.href = "../../eCP/jsp/ViewCarePlanFrameset.jsp?planid="+care_plan_id+"&md_plan_id="+md_plan_id+"&eval_id="+eval_id;
}
function viewCarePlanCallreason(md_plan_id,care_plan_id,eval_id)
{
	var dialogHeight = '15';
	var dialogWidth = '26' ;
	var dialogTop	= '250';
	var dialogLeft = '0' ;
	var arguments   = "" ;
	url = "../../eCP/jsp/ViewCarePlanMarkErrorReason.jsp?md_plan_id="+md_plan_id+"&care_plan_id="+care_plan_id+"&eval_id="+eval_id+"&error_remarks="+error_remarks;
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; status:no" ;
	var returnval = window.showModalDialog( url, arguments, features ) ;

}
// Fixing the percentage of diagnosis.
function valfix(val,obj,hval,row_count,row_name,pct,flag)
{
	if(row_name=="Diag")
	{
		eval("document.view_cp_diagandgoallist.dx_prog_pct"+row_count).value = val;
		eval("document.view_cp_diagandgoallist.tempidvaldiag"+row_count).value = obj.id;
		eval("document.view_cp_diagandgoallist.evaluated_diag_yn"+row_count).value = "Y";
		document.getElementById("id27"+row_count).innerText = "*";
		var termSetid=eval("document.view_cp_diagandgoallist.term_set_id_diag"+row_count).value
		var termcode=eval("document.view_cp_diagandgoallist.term_code_diag"+row_count).value
		if(pct!=0)
		{
			row_id = pct/4;
			row_id = row_id + 1;
			row_id = row_id + "";
			row_id = row_id + row_count
		}
		else
		{
			row_id = 1 + "";
			row_id = row_id+row_count;
		}
		var intext = document.getElementById("id"+row_id).innerText;
		var temp_ids = document.getElementById("id"+row_id+".id");
				
		if(temp_ids!=obj.id)
		{
			if(intext == "|")
				document.getElementById("id"+row_id).innerText = "-";
			else
				document.getElementById("id"+row_id).style.color='black';
		}
		if(obj.innerText!="|")
		{
			if(a_diag.length>0)
			{
				if(a_diag[hval-1])
					temp_val = a_diag[hval-1];
				else
					temp_val='';
			}
			else
			{
				temp_val = "";
			}
		}
		//Added on nov 8
		//alert(outcomecode);	
		//alert(val);
		if(flag==1){
			var xmlDoc="" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlStr ="<root><SEARCH " ;
			xmlStr +=" /></root>" ;
			xmlDoc.loadXML( xmlStr);
			xmlHttp.open( "POST","../../eCP/jsp/EvaluateCarePlanDynamicValues.jsp?termSetid="+termSetid+"&type=view_termcode_msr_ID&termcodecount="+row_count+"&score="+val+"&termcode="+termcode, false);
			xmlHttp.send( xmlDoc ) ;
			responseText=xmlHttp.responseText ;
			//alert(responseText);
			eval(responseText);
		}

	//End

	}
else if(row_name=="Goal")
	{
		eval("document.view_cp_diagandgoallist.goal_prog_pct"+row_count).value = val
		eval("document.view_cp_diagandgoallist.tempidvalgoal"+row_count).value = obj.id;
		eval("document.view_cp_diagandgoallist.evaluation_goal_yn"+row_count).value = "Y";
		document.getElementById("ids27"+row_count).innerText = "*";
		goalcode=eval("document.view_cp_diagandgoallist.goal_code"+row_count).value;
		if(pct!=0)
		{
			row_id = pct/4;
			row_id = row_id + 1;
			row_id = row_id + "";
			row_id = row_id + row_count
		}
		else
		{
			row_id = 1 + "";
			row_id = row_id+row_count;
		}
		var intext = document.getElementById("ids"+row_id).innerText ;
		var temp_ids = document.getElementById("ids"+row_id+".id");
		if(temp_ids!=obj.id)
		{
			if(intext == "|")
				document.getElementById("ids"+row_id).innerText = "-";
			else
				document.getElementById("ids"+row_id).style.color='black';
		}
		if(obj.innerText!="|")
		{
			if(a_goal.length>0)
			{
				if(a_goal[hval-1])
					temp_val = a_goal[hval-1];
				else
					temp_val='';
			}
			else
			{
				temp_val = "";
			}
		}
		if(flag==1){
			var xmlDoc="" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlStr ="<root><SEARCH " ;
			xmlStr +=" /></root>" ;
			xmlDoc.loadXML( xmlStr);
			xmlHttp.open( "POST","../../eCP/jsp/ViewCarePlanDynamicValues.jsp?outcomecode="+goalcode+"&type=view_msr_ID&outcomecount="+row_count+"&score="+val+"&objtype=Goal", false);
			xmlHttp.send( xmlDoc ) ;
			responseText=xmlHttp.responseText ;
		//	alert(responseText);
			eval(responseText);
		}
	}
	else if(row_name=="Outcome")
	{
		eval("document.view_cp_intvnandoutcomelist.outcome_prog_pct"+row_count).value = val
		eval("document.view_cp_intvnandoutcomelist.tempidvaloutcome"+row_count).value = obj.id;
		eval("document.view_cp_intvnandoutcomelist.evaluation_outcome_yn"+row_count).value = "Y";
		document.getElementById("ids27"+row_count).innerText = "*";
		outcomecode=eval("document.view_cp_intvnandoutcomelist.outcome_code"+row_count).value;
		if(pct!=0)
		{
			row_id = pct/4;
			row_id = row_id + 1;
			row_id = row_id + "";
			row_id = row_id + row_count;
		}
		else
		{
			row_id = 1 + "";
			row_id = row_id+row_count;
		}
		var intext = document.getElementById("ids"+row_id).innerText ;
		var temp_ids = document.getElementById("ids"+row_id+".id");
		if(temp_ids!=obj.id)
		{
			if(intext == "|")
				document.getElementById("ids"+row_id).innerText = "-";
			else
				document.getElementById("ids"+row_id).style.color='black';
		}
		if(obj.innerText!="|")
		{
			if(a_outcome.length>0)
			{
				if(a_outcome[hval-1])
					temp_val = a_outcome[hval-1];
				else
					temp_val='';
			}
			else
			{
				temp_val = "";
			}
		}
	//Added on nov 8
		//alert(outcomecode);	
		//alert(val);
		if(flag==1){
			var xmlDoc="" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlStr ="<root><SEARCH " ;
			xmlStr +=" /></root>" ;
			xmlDoc.loadXML( xmlStr);
			xmlHttp.open( "POST","../../eCP/jsp/EvaluateCarePlanDynamicValues.jsp?outcomecode="+outcomecode+"&type=view_msr_ID&outcomecount="+row_count+"&score="+val+"&objtype=Outcome", false);
			xmlHttp.send( xmlDoc ) ;
			responseText=xmlHttp.responseText ;
			//alert(responseText);
			eval(responseText);
		}

	//End

		
	}
	if(obj.innerText!="|")
	{
		if(temp_val!= ("document.all."+obj.id))
		{
			if(obj.innerText =="-")
				obj.innerText = "|";
			else
			{
				obj.style.color='black';
			}
			if(temp_val!="")
			{
				if(eval(temp_val).innerText == "|")
					eval(temp_val).innerText = "-";
				else
				{
					obj.style.color='black';
					eval(temp_val).style.color='black';
				}
			}
			var temp_val = document.getElementById(obj.id);

		}
		if(row_name=="Diag")
		{
			a_diag[hval-1] =  temp_val;
		}
		else if(row_name=="Goal")
		{
			a_goal[hval-1] =  temp_val;
		}
		else if(row_name=="Outcome")
		{
			a_outcome[hval-1] =  temp_val;
		}
	}
	else if(obj.innerText=='|')
	{
		obj.innerText = '|';
	}
	else
	{
		obj.innerText=intext;
		if(intext == '[')
			obj.style.color='red';
		else if(intext == ']')
			obj.style.color='green';
		var temp_val = document.getElementById(obj.id);

	}
}
function settermCodeMsrId(msrid,termcodecount){
			document.getElementById("DiagmsrID" + termcodecount).value = msrid;
}
function setMsrId(msrid,outcomecount,objtype){
//	alert(objtype);
	if(objtype=="Outcome"){
		document.getElementById("OutcomemsrID" + outcomecount).value = msrid;

	}
	else if(objtype=="Goal"){
		document.getElementById("GoalmsrID" + outcomecount).value = msrid;

	}
}
async function showDiagHistory(mode,term_set_id, term_code, term_code_srl_no, diag_desc){
	var frmObj="";
		var md_plan_id = "";
	if(mode=='error_mode'){
		frmObj = parent.frames[0].document.forms[0];
		md_plan_id = frmObj.md_plan_id.value;
	}else{
		frmObj=parent.view_cp_detail.document.view_cp_detail;
		md_plan_id = frmObj.md_care_plan_id.value;
}
var care_plan_id = frmObj.care_plan_id.value;


	var url = "../../eCP/jsp/EvaluateCarePlanChartFrameset.jsp?comp=D&care_plan_id="+care_plan_id+"&md_plan_id="+md_plan_id+"&term_set_id="+term_set_id+"&term_code="+term_code+"&term_code_srl_no="+term_code_srl_no+"&diag_desc="+diag_desc;
	var dialogTop       = "204";
	var dialogLeft       = "165";
	var dialogHeight    = "80vh" ;
	var dialogWidth = "55vw" ;
	var arguments   = "" ;
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +"; dialogLeft:" + dialogLeft + "; status:no" ;
	var returnval = await top.window.showModalDialog( url, arguments, features ) ;
	return returnval;
}

async function showGoalHistory(mode,term_set_id, term_code, term_code_srl_no, goal_code, goal_srl_no, goal_desc, diag_desc){

		var frmObj="";
		var md_plan_id = "";
	if(mode=='error_mode'){
		frmObj = parent.frames[0].document.forms[0];
		md_plan_id = frmObj.md_plan_id.value;
	}else{
		frmObj=parent.view_cp_detail.document.view_cp_detail;
		md_plan_id = frmObj.md_care_plan_id.value;
}
var care_plan_id = frmObj.care_plan_id.value;
	var url = "../../eCP/jsp/EvaluateCarePlanChartFrameset.jsp?comp=G&care_plan_id="+care_plan_id+"&md_plan_id="+md_plan_id+"&term_set_id="+term_set_id+"&term_code="+term_code+"&term_code_srl_no="+term_code_srl_no+"&goal_code="+goal_code+"&goal_srl_no="+goal_srl_no+"&goal_desc="+goal_desc+"&diag_desc="+diag_desc;
	var dialogTop       = "204";
	var dialogLeft       = "165";
	var dialogHeight    = "80vh" ;
	var dialogWidth = "55vw" ;
	var arguments   = "" ;
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +"; dialogLeft:" + dialogLeft + "; status:no" ;
	var returnval = await top.window.showModalDialog( url, arguments, features ) ;
	return returnval;
}
function callintvnandoutcomepg(planid,md_plan_id,termsetid,termcode,goalcode,eval_id)
{
	parent.view_cp_intvnandoutcome.location.href = "../../eCP/jsp/ViewCarePlanIntvnAndOutcomeList.jsp?planid="+planid+"&md_plan_id="+md_plan_id+"&term_set_id="+termsetid+"&term_code="+termcode+"&goal_code="+goalcode+"&eval_id="+eval_id;
}

async function showOutcomeHistory(mode,term_set_id, term_code, term_code_srl_no, goal_code, goal_srl_no, outcome_code, outcome_srl_no, outcome_desc)
{
	var frmObj="";
		var md_plan_id = "";
	if(mode=='error_mode'){
		frmObj = parent.frames[0].document.forms[0];
		md_plan_id = frmObj.md_plan_id.value;
	}else{
		frmObj=parent.view_cp_detail.document.view_cp_detail;
		md_plan_id = frmObj.md_care_plan_id.value;
}
var care_plan_id = frmObj.care_plan_id.value;
	var url = "../../eCP/jsp/EvaluateCarePlanChartFrameset.jsp?comp=O&care_plan_id="+care_plan_id+"&md_plan_id="+md_plan_id+"&term_set_id="+term_set_id+"&term_code="+term_code+"&term_code_srl_no="+term_code_srl_no+"&goal_code="+goal_code+"&goal_srl_no="+goal_srl_no+"&outcome_code="+outcome_code+"&outcome_srl_no="+outcome_srl_no+"&outcome_desc="+outcome_desc;
	var dialogTop       = "204";
	var dialogLeft       = "165";
	var dialogHeight    = "80vh" ;
	var dialogWidth = "55vw" ;
	var arguments   = "" ;
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +"; dialogLeft:" + dialogLeft + "; status:no" ;
	var returnval = await top.window.showModalDialog( url, arguments, features ) ;
	return returnval;
}
/********************** Prev/Next Method********************/
function callNextPrev(p_patient_id,facilty_id,encounter_id,p_care_mgr_id,p_t_set_id,p_t_code,p_fr_date,p_to_date,view_plans,view_summary,from,to){

if(document.forms[0].prevNextPlan_id1!=null){
parent.view_cp_criteria.document.view_cp_crit.prevNextPlan_id.value=document.forms[0].prevNextPlan_id1.value;
}
parent.view_cp_result.document.location.href="../../eCP/jsp/ViewCarePlanActivePlansResult.jsp?p_patient_id="+p_patient_id+"&facilty_id="+facilty_id+"&encounter_id="+encounter_id+"&p_care_manager_id="+p_care_mgr_id+"&p_term_set_id="+p_t_set_id+"&p_term_code="+p_t_code+"&p_fr_date="+p_fr_date+"&p_to_date="+p_to_date+"&view_plans="+view_plans+"&view_summary="+view_summary+"&from="+from+"&to="+to+"&prevNextPlan_id="+parent.view_cp_criteria.document.view_cp_crit.prevNextPlan_id.value;
}

async function getRemarks(obj)
{
   var dialogHeight= "18vh" ;
   var dialogWidth= "27vw" ;
   var dialogLeft="290";
   var dialogTop="190";
   var status = "no";
   var arguments= "" ;
   var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status+";dialogLeft:"+dialogLeft+";dialogTop:"+dialogTop+";";
   await top.window.showModalDialog("../../eCP/jsp/CarePlanVarianceFrameset.jsp?remarks="+obj+"&mode=1",arguments,features);
}

async function getActionPlan(obj)
{
   var dialogHeight= "18vh" ;
   var dialogWidth= "27vw" ;
   var dialogLeft="290";
   var dialogTop="190";
   var status = "no";
   var arguments= "" ;
   var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status+";dialogLeft:"+dialogLeft+";dialogTop:"+dialogTop+";";
   await top.window.showModalDialog("../../eCP/jsp/CarePlanVarianceFrameset.jsp?actionplan="+obj+"&mode=2",arguments,features);
}

