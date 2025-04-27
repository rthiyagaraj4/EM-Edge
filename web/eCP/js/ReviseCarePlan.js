/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
/*
-----------------------------------------------------------------------
Date       Edit History      Name        	Description
-----------------------------------------------------------------------
?             100            ?           	created
1/06/2012    IN032685		 Menaka V		Manage Care plan>When we Uncheck Active or Pending status we get script error during revise plan.
-----------------------------------------------------------------------
*/
function CalculateEndDate(){

 var formObj	  =	parent.f_reviseplanrecord_detail.document.getElementById("formReviseCareplanRecordchanges");
 var doc          = parent.f_reviseplanrecord_detail.document;
 var tot_rec      = formObj.tot_rec.value;//index
	for(var i=1;i<tot_rec;i++){
     start_date = doc["start_date" + i];
		duration = doc["duration" + i];
		durationtype = doc["durationtype" + i];
		end_date = doc["end_date" + i];


	   calEndDate(start_date,duration,durationtype,end_date);
	}
}

//This file is saved on 18/10/2005
function RCPcheckForNull(obj,fieldname)
{
	var ss1=getMessage("CAN_NOT_BE_BLANK","Common")
		ss1=ss1.replace("$",fieldname);
	if (obj.value == null || obj.value == "")
	{
		alert(ss1);
		return false;
	}
	else
		return true;
}

function RCPCheckNum(obj,start_date,durationtype,end_date,indx, intvncode)
{
	if (RCPcheckForNull(obj,getLabel("Common.duration.label","Common")))
	{
		if(CheckNum(obj))
		{
			if(RCPcheckForNull(start_date,getLabel("Common.StartDate.label","Common")))
			{
				calEndDate(start_date,obj,durationtype,end_date);
				UpdateIntvnDtl(indx,intvncode);
			}
		}
	}
}


function RCPCheckStartDate(obj,start_date,end_date,duration,durationtype,cur_datetime,indx,intvncode)
{
	if(RCPcheckForNull(start_date,getLabel("Common.StartDate.label","Common")))
	{
		if(checkValidDateTime(obj,start_date,end_date,duration,durationtype,cur_datetime,indx,intvncode))
		{
			if(chkvalidateSysDateTime(cur_datetime,start_date)) 
			{
				calEndDate(start_date,duration,durationtype,end_date);
				UpdateIntvnDtl(indx,intvncode);
			}
		}
	}
}

function Load_Diagnosis()
{
 clearDiagnosis();
 var frmObj=document.forms[0];
 var patient_id=frmObj.patient_id.value;
 var diagnosis_set=frmObj.diagnosis_set[frmObj.diagnosis_set.selectedIndex].value;
 var xmlDoc="" ;
 var xmlHttp = new XMLHttpRequest() ;
 xmlStr ="<root><SEARCH " ;
 xmlStr +=" /></root>" ;
 xmlDoc.loadXML( xmlStr);
 xmlHttp.open( "POST","../../eCP/jsp/ReviseCarePlanDynamicValues.jsp?diagnosis_set="+diagnosis_set+"&patient_id="+patient_id+"&validate=PATIENT", false);
 xmlHttp.send( xmlDoc ) ;
 responseText=xmlHttp.responseText ;
 eval(responseText);
}
//***********************************************************************
function addDiagnosis(code,value)
{
   var element = document.createElement('OPTION');
   element.value =  code;
   element.text = value;
   parent.frame_criteria.document.forms[0].diagnosis.add(element);
}
//***********************************************************************
function ShowActivePlansResult()
{
  var patient_id=document.ReviseCarePlanCriteria_Form.patient_id.value;
  var encounter_id=document.ReviseCarePlanCriteria_Form.encounter_id.value;
  var care_manager_id=document.ReviseCarePlanCriteria_Form.care_manager_id.value;
  var term_set_id=document.ReviseCarePlanCriteria_Form.diagnosis_set.value;
  var term_code=document.ReviseCarePlanCriteria_Form.diagnosis.value;

  parent.frame_activeplansresult.location.href="../../eCP/jsp/ReviseCarePlanActivePlansResult.jsp?patient_id="+patient_id+"&care_manager_id="+care_manager_id+"&term_set_id="+term_set_id+"&term_code="+term_code+"&encounter_id="+encounter_id;
}
//***********************************************************************
function clearDiagnosis( ) {
	var len = eval("document.forms[0].diagnosis.options.length") ;
	for(var i=0;i<len;i++){
		eval("document.forms[0].diagnosis.remove(\"diagnosis\")") ;
	}
	var tp 		= "  ---"+getLabel("Common.defaultSelect.label","Common")+"---  " ;
	var opt  	= eval("document.createElement(\"OPTION\")") ;
	opt.text 	= tp ;
	eval("document.forms[0].diagnosis.add(opt)") ;
}
//***********************************************************************
async function show_CareManager(obj,target_desc,target_code)
{
	var retVal = 	new String();
	var dialogHeight= "28" ;
	var dialogWidth	= "43" ;
	var dialogLeft="500";
	var status = "no";
	var arguments	= "" ;
	var sql="";
	var search_code="";
	var search_desc="";
	var dispDescFirst="dispDescFirst";
	var tit=getLabel("eCP.CareManager.label","CP");
	var practtype="";
	
	var facility_id=document.ReviseCarePlanCriteria_Form.facility_id.value;
	sql  = "select practitioner_id,practitioner_name from am_pract_for_facility_vw where operating_facility_id =`"+facility_id+"` and eff_status = `E` ";
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
			document.ReviseCarePlanCriteria_Form.care_manager_id.value=arr[1];
         	}
		else
		{
			target_desc.value="";
			target_code.value="";
	        }
}
//***********************************************************************
function RecordChanges(obj)
{	
  var patient_id=parent.frame_criteria.document.ReviseCarePlanCriteria_Form.patient_id.value;
  var encounter_id=parent.frame_criteria.document.ReviseCarePlanCriteria_Form.encounter_id.value;
  var care_manager_id=parent.frame_criteria.document.ReviseCarePlanCriteria_Form.care_manager_id.value;
  var term_set_id=parent.frame_criteria.document.ReviseCarePlanCriteria_Form.diagnosis_set.value;
  var term_code=parent.frame_criteria.document.ReviseCarePlanCriteria_Form.diagnosis.value;

    var frmObj		=document.forms[0];
	var care_plan_id=eval("frmObj.care_plan_id"+obj).value;
	var md_care_plan_id=eval("frmObj.md_care_plan_id"+obj).value;
	var cp_start_date=eval("frmObj.cp_start_date"+obj).value;
	var cp_target_date=eval("frmObj.cp_target_date"+obj).value;
	var cp_day_no=eval("frmObj.cp_day_no"+obj).value;
	var patient_id=frmObj.patient_id.value;
	var care_mgr_id=frmObj.care_mgr_id.value;
	var encounter_id=frmObj.encounter_id.value;
	var trRowId = document.getElementById("trRowId"+obj);
	var careManagerName = trRowId.cells[1].innerText

	var url="../../eCP/jsp/ReviseCarePlanViewFrameset.jsp?care_plan_id="+care_plan_id+'&md_care_plan_id='+md_care_plan_id+'&cp_start_date='+cp_start_date+'&cp_target_date='+cp_target_date+'&cp_day_no='+cp_day_no+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&care_mgr_id="+care_mgr_id+'&careManagerName='+careManagerName;
	var dialogHeight = '31';
	var dialogWidth = window.screen.width ;
	var dialogTop	= '80';
	var dialogLeft = '0' ;
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';
	
	var arguments = "";
	window.showModalDialog(url,arguments,features);
    document.location.href="../../eCP/jsp/ReviseCarePlanActivePlansResult.jsp?patient_id="+patient_id+"&care_manager_id="+care_manager_id+"&term_set_id="+term_set_id+"&term_code="+term_code+"&encounter_id="+encounter_id;
	//alert(top.content);


}
//**********************************************************************
function ClearActivePlansResult()
{
 parent.frames[1].location.href="../../eCommon/html/blank.html";
}
//*****************************************************************************

function updateDiagnosis(obj,termSet,termCode){
	var flag;
	if(obj.checked==true)
		flag="Y";
	else
		flag="N";

	var xmlDoc="" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	//var xmlString = getXMLString(null);  
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	//xmlDoc.loadXML( xmlStr);
	xmlHttp.open( "POST","../../eCP/jsp/ReviseCarePlanDynamicValues.jsp?termSet="+termSet+"&termCode="+termCode+"&flag="+flag+"&validate=DIAGNOSIS", false);
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	//alert(responseText);
	eval(responseText);
}

//*************************************************************************

function diagnosisCheck(termSet,termCode,GoalList,IntvnList,OutcomeList,flag,GroupList){
	formObj=parent.f_reviseplan_detail.document.formReviseCareplanDetail;
	

	var Group=new Array();
	var Groupid; 
	var labelname;
	var labelobj;

	var intervention=new Array();
	var IntvnCode;
	var IntvnStatus;
	var Intvnobjname;
	var Intvnappln_yn;
	var Intvnobj;

	var outcome=new Array();
	var outcomecode;
	var outcomeStatus;
	var outcomeobjname;
	var outcomeappln_yn;
	var outcomeobj;

	var goal=new Array();
	var goalcode;
	var goalStatus;
	var goalappln_yn;
	//var goalobjname;//IN032685
	var goalobj;

	intervention=IntvnList.split("~");
	outcome=OutcomeList.split("~");
	goal=GoalList.split("~");
	Group=GroupList.split("~");	

	for(var i=1;i<goal.length;i=i+3){
		goalcode=goal[i];
		goalStatus=goal[i+1];
		goalappln_yn=goal[i+2];
		//goalobjname=termSet+termCode+goalcode;//IN032685
		//goalobj=eval("formObj."+goalobjname);//IN032685
		goalobj=eval("parent.f_reviseplan_detail.document.formReviseCareplanDetail.diag_code_"+goalcode);//IN032685
		if(goalobj!=undefined){
			for(var k=1;k<Group.length;k=k+1){
				Groupid=Group[k];
				//labelname="lbl"+termSet+termCode+goalcode+Groupid;//IN032685
				labelname="lbl_goal_"+goalcode+Groupid;//IN032685
				var labelobj = document.getElementById(labelname);
				if(labelobj!=undefined){
					if(flag=="Y")
						labelobj.innerHTML		=	"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label style='cursor:pointer;color:Blue' onClick=\"ShowAddIntvn('"+termSet+"','"+termCode+"','"+goalcode+"','"+Groupid+"')\"><B>"+getLabel("Common.Add.label","Common")+"</B></label>"
					else
						labelobj.innerHTML		=	""
				}
			}
			if(flag=="N"){
				goalobj.disabled=true;
				goalobj.checked=false;
			}
			else{
				if(goalappln_yn=='Y')
					goalobj.checked=true;
				else
					goalobj.checked=false;

				if(goalStatus=='O' || goalStatus=='P')
					goalobj.disabled=false;
				else
					goalobj.disabled=true;
			}
	
			for(var k=1;k<intervention.length;k=k+3){
				IntvnCode=intervention[k];
				IntvnStatus=intervention[k+1];
				Intvnappln_yn=intervention[k+2];
				Intvnobjname=termSet+termCode+goalcode+IntvnCode;
				//Intvnobj=eval("formObj."+Intvnobjname);//IN032685
				Intvnobj=eval("parent.f_reviseplan_detail.document.formReviseCareplanDetail.intv_code_"+goalcode+IntvnCode);//IN032685
				if(Intvnobj !=undefined){
					if(flag=="N"){
						Intvnobj.disabled=true;
						Intvnobj.checked=false;
					}
					else{
						if(Intvnappln_yn=='Y')
							Intvnobj.checked=true;
						else
							Intvnobj.checked=false;

						if(IntvnStatus=='O' || IntvnStatus=='P')
							Intvnobj.disabled=false;
						else
							Intvnobj.disabled=true;
					}
				}
				
			}
			
			for(var k=1;k<outcome.length;k=k+3){
				outcomecode=outcome[k];
				outcomeStatus=outcome[k+1];
				outcomeappln_yn=outcome[k+2];
				outcomeobjname=termSet+termCode+goalcode+outcomecode;
				//outcomeobj=eval("formObj."+outcomeobjname);//IN032685
				outcomeobj=eval("parent.f_reviseplan_detail.document.formReviseCareplanDetail.out_code_"+goalcode+outcomecode);//IN032685
				if(outcomeobj !=undefined){
					if(flag=="N"){
						outcomeobj.disabled=true;
						outcomeobj.checked=false;
					}
					else{
						if(outcomeappln_yn=='Y')
							outcomeobj.checked=true;
						else
							outcomeobj.checked=false;
						
						if(outcomeStatus=='O' || outcomeStatus=='P')
							outcomeobj.disabled=false;
						else
							outcomeobj.disabled=true;
					}
				}
			}
		}	
	}
}

function updateGoal(obj,termSet,termCode,goalCode){
	
	var flag;
	if(obj.checked==true)
		flag="Y";
	else
		flag="N";

	var xmlDoc="" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc.loadXML( xmlStr);
	xmlHttp.open( "POST","../../eCP/jsp/ReviseCarePlanDynamicValues.jsp?termSet="+termSet+"&termCode="+termCode+"&goalCode="+goalCode+"&flag="+flag+"&validate=GOAL", false);
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	//alert(responseText);
	eval(responseText);

}

function goalCheck(termSet,termCode,goalcode,IntvnList,OutcomeList,flag,GroupList){
	//alert(GroupList);
	formObj=parent.f_reviseplan_detail.document.getElementById("formReviseCareplanDetail");

	var Group=new Array();
	var Groupid; 
	var labelname;
	var labelobj;

	Group=GroupList.split("~");	
	for(var k=1;k<Group.length;k=k+1){
		Groupid=Group[k];
		//labelname="lbl"+termSet+termCode+goalcode+Groupid;//IN032685
		labelname="lbl_goal_"+goalcode+Groupid;//IN032685
		var labelobj = document.getElementById(labelname);
		if(labelobj!=undefined){
		if(flag=="Y")
		labelobj.innerHTML		=	"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label style='cursor:pointer;color:Blue' onClick=\"ShowAddIntvn('"+termSet+"','"+termCode+"','"+goalcode+"','"+Groupid+"')\" ><B>"+getLabel("Common.Add.label","Common")+"</B></label>"
		else
		labelobj.innerHTML		=	""
		}
	}

	var intervention=new Array();
	var IntvnCode;
	var IntvnStatus;
	var Intvnobjname;
	var Intvnappln_yn;
	var Intvnobj;

	var outcome=new Array();
	var outcomecode;
	var outcomeStatus;
	var outcomeobjname;
	var outcomeappln_yn;
	var outcomeobj;

	intervention=IntvnList.split("~");	
	outcome=OutcomeList.split("~");
	for(var k=1;k<intervention.length;k=k+3){
				IntvnCode=intervention[k];
				IntvnStatus=intervention[k+1];
				Intvnappln_yn=intervention[k+2];
				Intvnobjname=termSet+termCode+goalcode+IntvnCode;
				//Intvnobj=eval("formObj."+Intvnobjname);//IN032685
				Intvnobj=eval("parent.f_reviseplan_detail.document.formReviseCareplanDetail.intv_code_"+goalcode+IntvnCode);//IN032685
				if(Intvnobj !=undefined){
					if(flag=="N"){
						Intvnobj.disabled=true;
						Intvnobj.checked=false;
					}
					else{
						if(Intvnappln_yn=='Y')
							Intvnobj.checked=true;
						else
							Intvnobj.checked=false;

						if(IntvnStatus=='O' || IntvnStatus=='P')
							Intvnobj.disabled=false;
						else
							Intvnobj.disabled=true;
					}
				}
				
			}
			//alert(outcome);
			
			for(var k=1;k<outcome.length;k=k+3){
				outcomecode=outcome[k];
				outcomeStatus=outcome[k+1];
				//alert("O  "+outcomeStatus);
				outcomeappln_yn=outcome[k+2];
				outcomeobjname=termSet+termCode+goalcode+outcomecode;
				//outcomeobj=eval("formObj."+outcomeobjname);//IN032685
				outcomeobj=eval("parent.f_reviseplan_detail.document.formReviseCareplanDetail.out_code_"+goalcode+outcomecode);//IN032685

				if(outcomeobj !=undefined){
					if(flag=="N"){
						outcomeobj.disabled=true;
						outcomeobj.checked=false;
					}
					else{
						if(outcomeappln_yn=='Y')
							outcomeobj.checked=true;
						else
							outcomeobj.checked=false;
							
						
						if(outcomeStatus=='O' || outcomeStatus=='P')
							outcomeobj.disabled=false;
						else
							outcomeobj.disabled=true;
					}
				}
				outcomecode="";
				outcomeStatus="";
				outcomeappln_yn="";
			}
}

function closeW(){
//	alert();
	
	parent.window.close();

	var xmlDoc="" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc.loadXML( xmlStr);
	xmlHttp.open( "POST","../../eCP/jsp/ReviseCarePlanDynamicValues.jsp?&validate=CLEARALL", false);
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	//alert(responseText);
	eval(responseText);
	
}

function updateIntvn(obj,termSet,termCode,goalCode,grpid1,IntvnCode){
	var flag;
	if(obj.checked==true)
		flag="Y";
	else
		flag="N";

	var xmlDoc="" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc.loadXML( xmlStr);
	xmlHttp.open( "POST","../../eCP/jsp/ReviseCarePlanDynamicValues.jsp?termSet="+termSet+"&termCode="+termCode+"&goalCode="+goalCode+"&IntvnCode="+IntvnCode+"&grpid="+grpid1+"&flag="+flag+"&validate=INTERVENTION", false);
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	//alert(responseText);
	eval(responseText);

}
function updateOutcome(obj,termSet,termCode,goalCode,grpid1,outcomeCode){
	var flag;
	if(obj.checked==true)
		flag="Y";
	else
		flag="N";

	var xmlDoc="" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc.loadXML( xmlStr);
	xmlHttp.open( "POST","../../eCP/jsp/ReviseCarePlanDynamicValues.jsp?termSet="+termSet+"&termCode="+termCode+"&goalCode="+goalCode+"&outcomeCode="+outcomeCode+"&grpid="+grpid1+"&flag="+flag+"&validate=OUTCOME", false);
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	//alert(responseText);
	eval(responseText);
}

async function showRevise(){
	formObj=parent.f_reviseplan_detail.document.formReviseCareplanDetail;
	var care_plan_id=formObj.care_plan_id.value;
	var md_care_plan_id=formObj.md_care_plan_id.value;
	var patient_id=formObj.patient_id.value;
	var encounter_id=formObj.encounter_id.value;
	var care_mgr_id=formObj.care_mgr_id.value;
	var url="../../eCP/jsp/ReviseCarePlanRecordChangesFrameset.jsp?care_plan_id="+care_plan_id+'&md_care_plan_id='+md_care_plan_id+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&care_mgr_id="+care_mgr_id;
	var dialogHeight = '90vh';
	//var dialogWidth = window.screen.width ;
	var dialogWidth = '90vw' ;
	var dialogTop	= '10';
	var dialogLeft = '0' ;
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';
	var arguments = "";
	var retVals= await top.window.showModalDialog(url,arguments,features);
	if(retVals=="SUCCESS")
	{
		window.returnValue="SUCCESS";
		window.close();
	}
}
function closewindow(){
	parent.window.close();
}

function UpdateIntvnDtl(index,intvncode){
	var formObj		=	parent.f_reviseplanrecord_detail.document.getElementById("formReviseCareplanRecordchanges");
	var locale=formObj.locale.value;
	//alert("index "+index);
	var start_dateobj		=	eval("formObj.start_date"+index);
	var start_date			=	convertDate(start_dateobj.value,"DMYHM",locale,"en");
	//alert(start_date);
	
	var frequencyobj		=	eval("formObj.frequency"+index);
		var freq_arr =frequencyobj.value;
		var freq_code =freq_arr.split(",")
		var frequency			=	freq_code[1];
		//alert("frequency"+frequency);
		
	var durationobj			=	eval("formObj.duration"+index);
	var duration			=	durationobj.value;

	var durationtypeobj		=	eval("formObj.durationtype"+index);
	var durationtype		=	durationtypeobj.value;

	var end_dateobj			=	eval("formObj.end_date"+index);
	var end_date			=	convertDate(end_dateobj.value,"DMYHM",locale,"en");
	
	var stageobj			=	eval("formObj.stage"+index);
	var stage				=	stageobj.value;

	var priorityobj			=	eval("formObj.priority"+index);
	var priority			=	priorityobj.value;

	var positonobj			=	eval("formObj.positon"+index);
	var position			=	positonobj.value;



	var revise_yn_obj		=	eval("formObj.Intvn"+index);
	var revise_yn			=	"N";
		if(revise_yn_obj.checked==true){
			 revise_yn			="Y";
		}else{
              revise_yn			="N";
		}


	/*var xmlDoc				=	new ActiveXObject( "Microsoft.XMLDom" ) ;
	var xmlHttp				=	new ActiveXObject( "Microsoft.XMLHTTP" ) ;*/
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();	
	xmlStr					=	"<root><SEARCH " ;
	xmlStr				   +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eCP/jsp/ReviseCarePlanDynamicValues.jsp?intvnCode="+intvncode+"&start_date="+start_date+"&frequency="+frequency+"&duration="+duration+"&revise_yn="+revise_yn+"&durationtype="+durationtype+"&end_date="+end_date+"&stage="+stage+"&priority="+priority+"&position="+position+"&validate=UPDATEINTVNDTL", false);
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	//alert(responseText);
	eval(responseText);
}

function apply()
{
	var formObj		=	parent.f_reviseplanrecord_detail.document.getElementById("formReviseCareplanRecordchanges");
    var tot_rec     =   formObj.tot_rec.value;
	var doc         =   parent.f_reviseplanrecord_detail.document;
    var m =0;
	for(k=1; k<=tot_rec; k++) {
				if (doc["start_date" + k] !== undefined){
					
					val1 = doc["start_date" + k].value;
					val2 = doc["duration" + k].value;

					 if( val1==''|| val1==null ||val2==''|| val2==null||val2=='0' ){	
						 m=m+1;
						 break;						
					 }     
				}
	}
	 if(m>0){

		 alert(getMessage("START_DT_AND_DURN_MUST_ENTER","CP"))
	 }else{
		formObj.submit();
	 }
	
}

function checkValidDateTime(obj,start,end,duration,durationtype,sysdatetime,index,interventioncode){
	
	if(obj.value!='')
	{
		if(!doDateTimeChk(obj))
		{
			alert(getMessage("INVALID_DATE_TIME","CP"));
		//	obj.focus();
			obj.value='';
			return false;
		}
    }
	return true;
}
//not used in RCP - 24Feb2006
function chkValidateDateTime(start,end,duration,durationtype){
	if(start.value !="" && end.value!=""){
		var flag=ValidateDateTime(start,end);
		if(!flag){
			alert(getMessage("END_DT_SHOULD_GT_START_DT","CP"));
			end.value="";
			end.focus();
			return false;
		}else{
			CalculateDuration(start.value,end.value,duration,durationtype);
			return true;
		}
	}
}
function chkvalidateSysDateTime(sysdatetime,start){
	if(sysdatetime.value !="" && start.value!=""){
		var flag=ValidateDateTime(sysdatetime,start)
		if(!flag){
			alert(getMessage("START_DT_SHOULD_GT_SYS_DT","CP"));
			start.value="";
			//start.focus();
			return false;
		}else{

			return true;
		}
	}

}
//not used in RCP - 24Feb2006
function CalculateDuration(start_date,target_date,duration,durationtype){
	
	var fromarray,toarray,fromtime,totime;
	var fromDt,fromDt1;

	if(start_date.length > 0 && target_date.length > 0 )
	{
		fromDt = start_date.split(" ");
		fromarray = fromDt[0].split("/");
		fromtime = fromDt[1].split(":");
		
		fromDt1= target_date.split(" ");		
		toarray = fromDt1[0].split("/");
		totime = fromDt1[1].split(":"); 
		//alert(plan_start_date+","+plan_tar_date);
		start_date = fromarray[2]+"/"+fromarray[1]+"/"+fromarray[0]+" "+fromtime[0]+":"+fromtime[1];
		target_date = toarray[2]+"/"+toarray[1]+"/"+toarray[0]+" "+totime[0]+":"+totime[1];
	}
	//alert(start_date+","+target_date);
	st_date = new Date();
	tr_date = new Date();
	dt_diff  = new Date();

	// Validates first date 
	st_datetemp = new Date(start_date);
	st_date.setTime(st_datetemp.getTime());

	// Validates second date 
	tr_datetemp = new Date(target_date);
	tr_date.setTime(tr_datetemp.getTime());

	// sets difference date to difference of first date and second date

	dt_diff.setTime(Math.abs(st_date.getTime() - tr_date.getTime()));


	timediff = dt_diff.getTime();
	var actualTimeDiff = timediff;
	weeks = Math.floor(timediff / (1000 * 60 * 60 * 24 * 7));
	timediff -= weeks * (1000 * 60 * 60 * 24 * 7);
	//alert("weeks ="+weeks);
	days = Math.floor(timediff / (1000 * 60 * 60 * 24)); 
	timediff -= days * (1000 * 60 * 60 * 24) ;
	//alert("days ="+days);

	hours = Math.floor(timediff / (1000 * 60 * 60)); 

	timediff -= hours * (1000 * 60 * 60);
	//alert("hours ="+hours);
	mins = Math.floor(timediff / (1000 * 60)); 
	timediff -= mins * (1000 * 60);
	//alert("mins ="+mins);
	/*secs = Math.floor(timediff / 1000); 
	timediff = secs * 1000;
	*/
	if(parseInt(mins,10) != 0)
	{

		var tempMins = 0; 
		if( weeks != 0)
		{
				tempMins = weeks * 7;
		}
		if(days != 0)
		{
			tempMins = tempMins +(days * 24);
		}
		if(hours != 0)
		{
			tempMins = tempMins +(hours * 60);
		}
		//alert( ' tempMins from Loop : '+tempMins)
		mins =mins  +  tempMins;
		duration.value=mins;
		durationtype.options[2].selected = selected ;
		//alert( ' Minutes from Loop : '+mins)
		
	}
	else if(parseInt(hours,10) != 0)
	{	
		var tempHrs = 0; 
		if( weeks != 0)
		{
				tempHrs = weeks * 7;
		}
		if(days != 0)
		{
			tempHrs = tempHrs + (tempHrs * 24);
		}
		hours += tempHrs;
		duration.value=hours;
		durationtype.options[1].selected = selected ;
		//alert('hours from Loop:'+hours);
		
	}
	else if(parseInt(days,10) != 0)
	{
		var tempDay=0 ; 
		if(weeks != 0)
		{
				tempDay = weeks * 7
		}
		days += tempDay
		duration.value=days;
		//eval("frmPrwObj.document.gen_preview_details.dur_type"+index).options[0].selected = selected ;
		durationtype.options[0].selected = selected ;
		//alert('days from Loop :'+days);
		
	}
	else if(parseInt(weeks,10) != 0)
	{
		weeks = Math.floor(actualTimeDiff / (1000 * 60 * 60 * 24 * 7));
		duration.value=weeks;
		durationtype.options[4].selected = selected ;
		//alert('weeks from Loop :'+weeks);
	}


}

function calEndDate(startdate,duration,durationtype,enddate){
	
		var start_date	=	startdate.value;
		var tmp_target_prd=0;
		var durnUnit=durationtype.value;
		var fromarray;
		var fromDt;
		var timarray;
		var finalDt="";

		if (duration.value == null || duration.value == "")
			tmp_target_prd = 0;
		else
			tmp_target_prd = duration.value;

		if(start_date.length > 0 && parseFloat(tmp_target_prd)>= 0)
		{
			fromDt = start_date.split(" ");
			fromarray = fromDt[0].split("/");
			timarray = fromDt[1].split(":");
		}
		var dt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
		dt.setHours(timarray[0], timarray[1]);
		
		if(durnUnit ==  'D'){//days
			dt.setTime(dt.getTime()+1000 * 60 * 60 * 24 * parseInt(tmp_target_prd));
		}else if(durnUnit ==  'W'){//weeks
			tmp_target_prd = tmp_target_prd * 7;
			dt.setTime(dt.getTime()+1000 * 60 * 60 * 24 * parseInt(tmp_target_prd));
		}else if(durnUnit ==  'L'){//month
			dt.setMonth(dt.getMonth()+eval(tmp_target_prd))
		}else if(durnUnit ==  'H'){//hours
			timarray[0]=dt.getHours()+parseInt(tmp_target_prd);
			dt.setHours(timarray[0], timarray[1]);
		}else if(durnUnit ==  'M'){//Minutes
			timarray[1]=dt.getMinutes()+parseInt(tmp_target_prd);
			dt.setHours(timarray[0], timarray[1]);
		}

		var date= ""+dt.getDate()+"";
		var month= ""+parseInt(dt.getMonth()+1)+"";
		var hours= ""+dt.getHours()+"";
		var minutes= ""+dt.getMinutes()+"";
		if(date.length == 1)
			date="0"+date;
		if(month.length == 1)
			month="0"+month;
		if(hours.length == 1)
			hours="0"+hours;
		if(minutes.length == 1)
			minutes="0"+minutes;
		finalDt += date + "/";
		finalDt += month + "/";
		finalDt += dt.getYear() + " ";
		finalDt += hours + ":";
		finalDt += minutes ;
		enddate.value=finalDt;
		//alert("finalDt::::"+finalDt);
}			

function onSuccess(error_num,error_value){
window.returnValue="SUCCESS"
window.close();
//alert(""+error_num);
//
}


function setduration(duration,durationtype,durationobj,durationtypeobj,IntvnCode,Index,startdate,enddate){
	//alert("durationtype"+durationtype);
	var index1=-1;
	for (i=0; i< durationtypeobj.options.length; i++){
		//alert("i "+i+" value "+durationtypeobj.options(i).value);
		if(durationtype==durationtypeobj.options(i).value){
			index1=i;
			break;
		}
	}
//	alert("index1 "+index1);
	if(index1!=-1){
		durationobj.value=duration;
		durationtypeobj.options[index1].selected=selected;
		calEndDate(startdate,durationobj,durationtypeobj,enddate)
		UpdateIntvnDtl(Index,IntvnCode);
	}
//	durationobj.focus();
}


function setstage(stagecode,stageobj,IntvnCode,Index){
var index1=-1;
for (i=0; i< stageobj.options.length; i++){
		if(stagecode==stageobj.options(i).value){
			index1=i;
			break;
		}
	}
	if(index1!=-1){
		stageobj.options[index1].selected=selected;
		UpdateIntvnDtl(Index,IntvnCode);
	}
	//stageobj.focus();
}

function setposition(positioncode,positionobj,IntvnCode,Index){
var index1=-1;
for (i=0; i< positionobj.options.length; i++){
		if(positioncode==positionobj.options(i).value){
			index1=i;
			break;
		}
	}
	if(index1!=-1){
		positionobj.options[index1].selected=selected;
		UpdateIntvnDtl(Index,IntvnCode);
	}
	//positionobj.focus();
}

function setpriority(prioritycode,priorityobj,IntvnCode,Index){
var index1=-1;
for (i=0; i< priorityobj.options.length; i++){
		if(prioritycode==priorityobj.options(i).value){
			index1=i;
			break;
		}
	}
	if(index1!=-1){
		priorityobj.options[index1].selected=selected;
		UpdateIntvnDtl(Index,IntvnCode);
	}
	//priorityobj.focus();
}

function setfrequency(freqcode,frequencyobj,IntvnCode,Index){
	var index1=-1;
	var freq_arr ;
	var freq_code;
	var frequency;
	for (i=0; i< frequencyobj.options.length; i++){
		freq_arr =frequencyobj.options(i).value;
		freq_code =freq_arr.split(",")
		frequency			=	freq_code[1];
		if(freqcode==frequency){
			index1=i;
			break;
		}
	}
//	alert("index1 "+index1);
	if(index1 != -1){
		frequencyobj.options[index1].selected=selected;
		//frequencyobj.focus();
		UpdateIntvnDtl(Index,IntvnCode);
		loadDurntypes(frequencyobj,Index,IntvnCode);
	}
}

async function ShowAddIntvn(termSet,termCode,goalCode,groupid){
	formObj=parent.f_reviseplan_detail.document.getElementById("formReviseCareplanDetail");
	care_plan_id=formObj.care_plan_id.value;
	md_care_plan_id=formObj.md_care_plan_id.value;
	var dialogHeight ='72vh' ;
	var dialogWidth = '75vw' ;
	var dialogTop	= '10';
	var dialogLeft = '10' ;
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';
	var arguments = "";
	var url="../../eCP/jsp/ReviseCarePlanAddIntvnFrameset.jsp?termSet="+termSet+"&termCode="+termCode+"&goalCode="+goalCode+"&groupid="+groupid+"&md_care_plan_id="+md_care_plan_id+"&care_plan_id="+care_plan_id;
	var retVal = await window.showModalDialog(url,arguments,features);
}

async function selectIntvn(target){
	var frmObj=document.forms[0];
		//var desc=target.value;
		var md_care_plan_id=frmObj.md_care_plan_id.value;
		var care_plan_id=frmObj.care_plan_id.value;
		var locale=frmObj.locale.value;
		if(frmObj.intvn_code.value !=""){
			frmObj.intvn_code.value="";
			frmObj.intvn_desc.value="";
		}
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
//		argumentArray[0]="SELECT   INTERVENTION_CODE CODE, SHORT_DESC DESCRIPTION, INTERVENTION_TYPE  FROM CA_INTERVENTION A WHERE INTERVENTION_CODE NOT IN (SELECT INTERVENTION_CODE FROM CP_LIBRARY_INTERVENTION WHERE (LIBRARY_ID, VERSION_NO) IN (SELECT LIBRARY_ID, VERSION_NO FROM CP_PAT_CARE_PLAN_TERM_CODE WHERE MD_CARE_PLAN_ID = '"+md_care_plan_id+"' AND CARE_PLAN_ID = '"+care_plan_id+"')) AND EFF_STATUS = 'E' AND EXISTS (SELECT B.INTERVENTION_CODE FROM CA_INTERVENTION_FREQ B WHERE B.INTERVENTION_CODE = A.INTERVENTION_CODE) AND UPPER (INTERVENTION_CODE) LIKE UPPER(?) AND UPPER (SHORT_DESC) LIKE UPPER(?) ORDER BY SHORT_DESC";
		argumentArray[0]="SELECT   INTERVENTION_CODE CODE, SHORT_DESC DESCRIPTION, INTERVENTION_TYPE  FROM CA_INTERVENTION_lang_vw A WHERE INTERVENTION_CODE NOT IN (SELECT INTERVENTION_CODE FROM CP_LIBRARY_INTERVENTION WHERE (LIBRARY_ID, VERSION_NO) IN (SELECT LIBRARY_ID, VERSION_NO FROM CP_PAT_CARE_PLAN_TERM_CODE WHERE MD_CARE_PLAN_ID = '"+md_care_plan_id+"' AND CARE_PLAN_ID = '"+care_plan_id+"')) AND EFF_STATUS = 'E' AND EXISTS (SELECT B.INTERVENTION_CODE FROM CA_INTERVENTION_FREQ B WHERE B.INTERVENTION_CODE = A.INTERVENTION_CODE) AND UPPER (INTERVENTION_CODE) LIKE UPPER(?) AND UPPER (SHORT_DESC) LIKE UPPER(?) AND language_id ='"+locale+"' ORDER BY SHORT_DESC";
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2"; 
		argumentArray[5] = frmObj.intvn_desc.value;
		argumentArray[6] = CODE_DESC_LINK;//CODE_LINK
		argumentArray[7] = CODE_DESC;//CODE_DESC
		retVal = await CommonLookup(getLabel("eCP.AddInterventions.label","CP"), argumentArray );
		var str =unescape(retVal);
		var arr = str.split(",");
		if(retVal != null && retVal != "") {
			frmObj.intvn_desc.value = arr[1] ;
			frmObj.intvn_code.value = arr[0];
			
		}
		
}

function addIntvn(){
		var frmObj=document.forms[0];
		if(frmObj.intvn_code.value!=""){
			/*var xmlDoc				=	new ActiveXObject( "Microsoft.XMLDom" ) ;
			var xmlHttp				=	new ActiveXObject( "Microsoft.XMLHTTP" ) ;*/
			var xmlDoc = "";
			var xmlHttp = new XMLHttpRequest();
			xmlStr					=	"<root><SEARCH " ;
			xmlStr				   +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST","../../eCP/jsp/ReviseCarePlanDynamicValues.jsp?termSet="+frmObj.termSet.value+"&termCode="+frmObj.termCode.value+"&goalCode="+frmObj.goalCode.value+"&groupid="+frmObj.groupid.value+"&intvn_code="+frmObj.intvn_code.value+"&intvn_type="+frmObj.intvn_type.value+"&intvn_desc="+frmObj.intvn_desc.value+"&flag=Y&validate=ADDINTVN", false);
			xmlHttp.send( xmlDoc ) ;
			responseText=xmlHttp.responseText ;
			//alert(responseText);
			eval(responseText);
		}
		frmObj.intvn_code.value="";
		frmObj.intvn_type.value="";
		frmObj.intvn_desc.value="";
		parent.ReviseCarePlanAddInterventionsResult.location.href="../../eCP/jsp/ReviseCarePlanAddIntvnResult.jsp?termSet="+frmObj.termSet.value+"&termCode="+frmObj.termCode.value+"&goalCode="+frmObj.goalCode.value+"&groupid="+frmObj.groupid.value;  

}

function UpdateIntvn(obj,intvn_code){
	if(obj.checked==true)
		flag="Y";
	else
		flag="N";
	formObj=parent.ReviseCarePlanAddInterventionsResult.document.formReviseCareplanaddIntvn;

		var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest();
	xmlStr					=	"<root><SEARCH " ;
	xmlStr				   +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eCP/jsp/ReviseCarePlanDynamicValues.jsp?termSet="+formObj.termSet.value+"&termCode="+formObj.termCode.value+"&goalCode="+formObj.goalCode.value+"&groupid="+formObj.groupid.value+"&intvn_code="+intvn_code+"&flag="+flag+"&validate=ADDINTVN", false);
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	//alert(responseText);
	eval(responseText);
}

function clearData(obj) {
	obj = eval(obj);
	var len = obj.length;
	for (var i=0; i<=len; i++) {
		obj.remove("");
	}
}

function loadDurntypes(obj,index,IntvnCode){
	var tmp_value=obj.value;
	var freq_arr = tmp_value.split(",")
	var freq_code = freq_arr[0];
	var freq_durn_value =freq_arr[1];
	var freq_durn_unit=freq_arr[2];

	var formObj		=	parent.f_reviseplanrecord_detail.document.getElementById("formReviseCareplanRecordchanges");
	var startdate=eval("formObj.start_date"+index);
	var durationobj=eval("formObj.duration"+index);
	var enddate=eval("formObj.end_date"+index);
	var obj1=eval("formObj.durationtype"+index);
	clearData(obj1);

	switch(freq_durn_unit){
			case 'M':
				var opt = document.createElement("OPTION");
				opt.text = getLabel("Common.Minutes.label","Common");
				opt.value = "M";
				eval("formObj.durationtype"+index).add(opt);
			case 'H':
				var opt = document.createElement("OPTION");
				opt.text = getLabel("Common.Hour(s).label","Common") ;
				opt.value = "H";
				eval("formObj.durationtype"+index).add(opt);
			case 'D':
				var opt = document.createElement("OPTION");
				opt.text = getLabel("Common.days.label","CP");
				opt.value = "D";
				eval("formObj.durationtype"+index).add(opt);
			case 'W':
				var opt = document.createElement("OPTION");
				opt.text = getLabel("eCP.Weeks.label","CP");
				opt.value = "W";
				eval("formObj.durationtype"+index).add(opt);
			case 'L':
				var opt = document.createElement("OPTION");
				opt.text = getLabel("eCP.Months.label","CP");
				opt.value = "L";
				eval("formObj.durationtype"+index).add(opt);
				break;
			default:
				var opt = document.createElement("OPTION");
				opt.text = getLabel("Common.Minute(s).label","Common");
				opt.value = "M";
				eval("formObj.durationtype"+index).add(opt);
				var opt = document.createElement("OPTION");
				opt.text = getLabel("Common.Hour(s).label","Common") ;
				opt.value = "H";
				eval("formObj.durationtype"+index).add(opt);
				var opt = document.createElement("OPTION");
				opt.text = getLabel("Common.days.label","CP");
				opt.value = "D";
				eval("formObj.durationtype"+index).add(opt);
				var opt = document.createElement("OPTION");
				opt.text = getLabel("eCP.Weeks.label","CP");
				opt.value = "W";
				eval("formObj.durationtype"+index).add(opt);
				var opt = document.createElement("OPTION");
				opt.text = getLabel("eCP.Months.label","CP");
				opt.value = "L";
				eval("formObj.durationtype"+index).add(opt);
				break;

	}
	if(freq_durn_unit !=''){
		calEndDate(startdate,durationobj,obj1,enddate)
		UpdateIntvnDtl(index,IntvnCode);
	}
}
