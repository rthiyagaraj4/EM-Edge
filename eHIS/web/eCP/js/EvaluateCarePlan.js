
//This file is saved on 18/10/2005


var temp_val = "";
var temp_hval = "";
var a_diag = new Array();
var a_goal = new Array();
var a_outcome = new Array();

function resetval(obj,pct,row_count,row_name)
{
	if(obj.innerText=="*")
	{
		if(row_name=="Diag")
		{
			temp_id = eval("document.eval_cp_diagandgoallist.tempidvaldiag"+row_count+".value");
			chkval = eval("document.eval_cp_diagandgoallist.dx_prog_pct"+row_count+".value")
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
			var intext = document.getElementById("id"+row_id).innerText;
			if(chkval==0)
			{
				document.getElementById(temp_id).innerText = "[" ;
				document.getElementById(temp_id).style.color = "black";
				document.getElementById(temp_id).style.fontWeight = "bolder";

			}
			else if(chkval==100)
			{
				document.getElementById(temp_id).innerText = "]";
				document.getElementById(temp_id).style.color = "black";
				document.getElementById(temp_id).style.fontWeight = "bolder";

			}
			else
				document.getElementById(temp_id).innerText = "-";


			if((intext == "-")||(intext == "|"))
				document.getElementById("id"+row_id).innerText = "|";
			else if(intext == "[")
				document.getElementById("id"+row_id).style.color = "red";
			else if(intext == "]")
				document.getElementById("id"+row_id).style.color = "green";

			eval("document.eval_cp_diagandgoallist.evaluated_diag_yn"+row_count).value = "N";
			// added on nov 8
			//alert("Before "+(eval("document.eval_cp_diagandgoallist.DiagmsrID"+row_count).value));
			eval("document.eval_cp_diagandgoallist.DiagmsrID"+row_count).value = "";
//			alert("After "+(eval("document.eval_cp_diagandgoallist.DiagmsrID"+row_count).value));
		}
		else if(row_name=="Goal")
		{
			temp_id = eval("document.eval_cp_diagandgoallist.tempidvalgoal"+row_count+".value");
			chkval = eval("document.eval_cp_diagandgoallist.goal_prog_pct"+row_count+".value")
			row_id = pct/4;
			row_id = row_id + 1;
			row_id = row_id + "";
			row_id = row_id + row_count
			obj.innerText = "";
			var intext = document.getElementById("ids"+row_id).innerText;
			if(chkval==0)
			{
				document.getElementById(temp_id).innerText = "[";
                 document.getElementById(temp_id).style.color = "black";
                 document.getElementById(temp_id).style.fontWeight = "bolder";

			}
			else if(chkval==100)
			{
				document.getElementById(temp_id).innerText = "[";
                 document.getElementById(temp_id).style.color = "black";
                 document.getElementById(temp_id).style.fontWeight = "bolder";
			}
			else
				document.getElementById(temp_id).innerText = "-";

			if((intext == "-")||(intext == "|"))
				document.getElementById("ids"+row_id).innerText = "|";
			else
				document.getElementById("ids"+row_id).style.color = "red";
			eval("document.eval_cp_diagandgoallist.evaluation_goal_yn"+row_count).value = "N";
			// added on nov 8
			//alert("Before "+(eval("document.eval_cp_diagandgoallist.GoalmsrID"+row_count).value));
			eval("document.eval_cp_diagandgoallist.GoalmsrID"+row_count).value = "";
			//alert("After "+(eval("document.eval_cp_diagandgoallist.GoalmsrID"+row_count).value));
		}
		else if(row_name=="Outcome")
		{
			temp_id = eval("document.eval_cp_intvnandoutcomelist.tempidvaloutcome"+row_count+".value");
			chkval = eval("document.eval_cp_intvnandoutcomelist.outcome_prog_pct"+row_count+".value")
			row_id = pct/4;
			row_id = row_id + 1;
			row_id = row_id + "";
			row_id = row_id + row_count
			obj.innerText = "";
			var intext = document.getElementById("ids"+row_id).innerText;
			if(chkval==0)
			{
				document.getElementById(temp_id).innerText = "[";
                 document.getElementById(temp_id).style.color = "black";
                 document.getElementById(temp_id).style.fontWeight = "bolder";
			}
			else if(chkval==100)
			{
			     document.getElementById(temp_id).innerText = "]";
                 document.getElementById(temp_id).style.color = "black";
                 document.getElementById(temp_id).style.fontWeight = "bolder";
			}
			else
				document.getElementById(temp_id).innerText = "-";

			if((intext == "-")||(intext == "|"))
				document.getElementById("ids"+row_id).innerText = "|";
			else
				document.getElementById("ids"+row_id).style.color = "red";

			eval("document.eval_cp_intvnandoutcomelist.evaluation_outcome_yn"+row_count).value = "N";
	// added on nov 8
			//alert("Before "+(eval("document.eval_cp_intvnandoutcomelist.OutcomemsrID"+row_count).value));
			eval("document.eval_cp_intvnandoutcomelist.OutcomemsrID"+row_count).value = "";
			//alert("After "+(eval("document.eval_cp_intvnandoutcomelist.OutcomemsrID"+row_count).value));

		}
	}
}
// Fixing the percentage of diagnosis.
function valfix(val,obj,hval,row_count,row_name,pct,flag)
{
	/*alert("val "+val);
	alert("obj "+obj.id);
	alert("hval "+hval);
	alert("row_count "+row_count);
	alert("row_name "+row_name);
	alert("pct "+pct);
*/
	var resp=1;
	if(row_name=="Diag")
	{
		eval("document.eval_cp_diagandgoallist.dx_prog_pct"+row_count).value = val;
		eval("document.eval_cp_diagandgoallist.tempidvaldiag"+row_count).value = obj.id;
		eval("document.eval_cp_diagandgoallist.evaluated_diag_yn"+row_count).value = "Y";
		document.getElementById("id27"+row_count).innerText = "*";
		var termSetid=eval("document.eval_cp_diagandgoallist.term_set_id_diag"+row_count).value
		var termcode=eval("document.eval_cp_diagandgoallist.term_code_diag"+row_count).value
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
			xmlHttp.open( "POST","../../eCP/jsp/EvaluateCarePlanDynamicValues.jsp?termSetid="+termSetid+"&type=eval_termcode_msr_ID&termcodecount="+row_count+"&score="+val+"&termcode="+termcode, false);
			xmlHttp.send( xmlDoc ) ;
			responseText=xmlHttp.responseText ;
			//alert(responseText);
			resp=eval(responseText);				
		}

	//End

	}
	else if(row_name=="Goal")
	{
		eval("document.eval_cp_diagandgoallist.goal_prog_pct"+row_count).value = val
		eval("document.eval_cp_diagandgoallist.tempidvalgoal"+row_count).value = obj.id;
		eval("document.eval_cp_diagandgoallist.evaluation_goal_yn"+row_count).value = "Y";
		document.getElementById("ids27"+row_count).innerText = "*";
		goalcode=eval("document.eval_cp_diagandgoallist.goal_code"+row_count).value;
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
			xmlHttp.open( "POST","../../eCP/jsp/EvaluateCarePlanDynamicValues.jsp?outcomecode="+goalcode+"&type=eval_msr_ID&outcomecount="+row_count+"&score="+val+"&objtype=Goal", false);
			xmlHttp.send( xmlDoc ) ;
			responseText=xmlHttp.responseText ;
			//alert(responseText);			
			resp=eval(responseText);
			
		}
	}
	else if(row_name=="Outcome")
	{
		eval("document.eval_cp_intvnandoutcomelist.outcome_prog_pct"+row_count).value = val
		eval("document.eval_cp_intvnandoutcomelist.tempidvaloutcome"+row_count).value = obj.id;
		eval("document.eval_cp_intvnandoutcomelist.evaluation_outcome_yn"+row_count).value = "Y";
		document.getElementById("ids27"+row_count).innerText = "*";
		outcomecode=eval("document.eval_cp_intvnandoutcomelist.outcome_code"+row_count).value;
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
			xmlHttp.open( "POST","../../eCP/jsp/EvaluateCarePlanDynamicValues.jsp?outcomecode="+outcomecode+"&type=eval_msr_ID&outcomecount="+row_count+"&score="+val+"&objtype=Outcome", false);
			xmlHttp.send( xmlDoc ) ;
			responseText=xmlHttp.responseText ;
			//alert(responseText);			
			resp=eval(responseText);
		}

	//End

		
	}
	if(obj.innerText!="|")
	{
		if (temp_val != document.getElementById(obj.id))
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
			temp_val = document.getElementById(obj.id)
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
		temp_val = document.getElementById(obj.id);
	}
	if(resp==0)
	{			
		if(row_name=="Diag")
			obj1 = document.getElementById("id27"+row_count);
		else
			obj1 = document.getElementById("ids27"+row_count);
		resetval(obj1,pct,row_count,row_name);
	}	
	
}
// End..
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
	if(document.eval_cp_crit.eval_src.value!="")
	{
		var selected_locn_type = document.eval_cp_crit.eval_src.value;
		var type = "selected_locn_type";
		var htmlvalue = "<html><body><form name='dynamic_value' id='dynamic_value' method='post' action='../../eCP/jsp/EvaluateCarePlanDynamicValues.jsp'><input type='hidden' name='selected_locn_type' id='selected_locn_type' value='"+selected_locn_type+"'><input type='hidden' name='type' id='type' value='"+type+"'></form></body></html>"
		parent.eval_cp_dyn_val.document.write(htmlvalue);
		parent.eval_cp_dyn_val.document.dynamic_value.submit();
	}
}

function show_CareManager(obj,target_desc,target_code)
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
	var facilty_id=document.eval_cp_crit.facilty_id.value;
	var locale=document.eval_cp_crit.locale.value;
	//sql  = "select practitioner_id,practitioner_name from am_pract_for_facility_vw where operating_facility_id =`"+facilty_id+"` and eff_status = `E` ";
	sql  = "SELECT a.practitioner_id, b.practitioner_name FROM am_pract_for_facility_vw a, am_practitioner_lang_vw b where a.operating_facility_id =`"+facilty_id+"` AND a.eff_status = `E` AND b.practitioner_id = a.practitioner_id AND b.language_id =`"+locale+"`";
	search_code = "a.practitioner_id";
	search_desc = "b.practitioner_name";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status+";dialogLeft:"+dialogLeft+";";
	retVal = window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit+"&dispDescFirst="+dispDescFirst,arguments,features);
	var arr=new Array();
	if (!(retVal == null))
	{
		var ret1=unescape(retVal);
		arr=ret1.split("::");
		target_desc.value=arr[0];
		target_code.value=arr[1];
		document.eval_cp_crit.care_manager_id.value=arr[1];
	}
	else
	{
		target_desc.value="";
		target_code.value="";
	}
}
function showvariance()
{
	var p_patient_id = document.eval_cp_crit.patient_id.value
	var care_manager_id = document.eval_cp_crit.care_manager_id.value
	var term_set_id = document.eval_cp_crit.eval_diag.value
	var term_code = document.eval_cp_crit.diagnosis.value
	var facilty_id = document.eval_cp_crit.facilty_id.value
	var encounter_id = document.eval_cp_crit.encounter_id.value
	var from_date = document.eval_cp_crit.eval_frmdate.value
	var to_date= document.eval_cp_crit.eval_todate.value
	var url = "../../eCP/jsp/EvaluateCarePlanShowVariance.jsp?p_patient_id="+p_patient_id+"&facilty_id="+facilty_id+"&encounter_id="+encounter_id+"&p_care_manager_id="+care_manager_id+"&p_term_set_id="+term_set_id+"&p_term_code="+term_code+"&p_fr_date="+from_date+"&p_to_date="+to_date;

	var dialogHeight  = "31.5" ;
    var dialogWidth = "50" ;
	var dialogTop	= '150';
	var dialogLeft = '5' ;
    var arguments   = "" ;
    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";dialogTop:"+dialogTop+";dialogLeft:"+dialogLeft+"; status=no;";
    var retVal   = window.showModalDialog( url, arguments, features ) ;
}
function callresult()
{
	var p_patient_id = document.eval_cp_crit.patient_id.value
	var care_manager_id = document.eval_cp_crit.care_manager_id.value
	var term_set_id = document.eval_cp_crit.eval_diag.value;
	
	var term_code = document.eval_cp_crit.diagnosis.value
	var facilty_id = document.eval_cp_crit.facilty_id.value
	var encounter_id = document.eval_cp_crit.encounter_id.value
	var from_date = document.eval_cp_crit.eval_frmdate.value
	var to_date= document.eval_cp_crit.eval_todate.value
	var view_plans= document.eval_cp_crit.view_plans.value
	var view_summary= document.eval_cp_crit.view_summary.value
	parent.eval_cp_result.location.href = "../../eCP/jsp/EvaluateCarePlanActivePlansResult.jsp?p_patient_id="+p_patient_id+"&facilty_id="+facilty_id+"&encounter_id="+encounter_id+"&p_care_manager_id="+care_manager_id+"&p_term_set_id="+term_set_id+"&p_term_code="+term_code+"&p_fr_date="+from_date+"&p_to_date="+to_date+"&view_plans="+view_plans+"&view_summary="+view_summary;
}

function clearresult()
{
	parent.eval_cp_result.location.href = "../../eCommon/html/blank.html";
}

async function callplan(planid,md_plan_id,patient_id,care_mgr_name,obj,cp_day_no)
{
	if((obj.innerText == "E") || (obj.innerText == "R"))
	{
		var care_manager_id = parent.eval_cp_criteria.document.eval_cp_crit.care_manager_id.value;
		var term_set_id = parent.eval_cp_criteria.document.eval_cp_crit.eval_diag.value;
		var term_code = parent.eval_cp_criteria.document.eval_cp_crit.diagnosis.value;
		var facilty_id = parent.eval_cp_criteria.document.eval_cp_crit.facilty_id.value;
		var encounter_id = parent.eval_cp_criteria.document.eval_cp_crit.encounter_id.value;
		var from_date = parent.eval_cp_criteria.document.eval_cp_crit.eval_frmdate.value;
		var to_date= parent.eval_cp_criteria.document.eval_cp_crit.eval_todate.value;
		var cp_start_date = eval("document.forms[0].start"+md_plan_id+planid+patient_id).value;
		var cp_target_date = eval("document.forms[0].target"+md_plan_id+planid+patient_id).value;
		var view_plans= parent.eval_cp_criteria.document.eval_cp_crit.view_plans.value;
		var view_summary= parent.eval_cp_criteria.document.eval_cp_crit.view_summary.value;
		var url = "";
		var encounter_id = document.forms[0].encounter_id.value;
		if(obj.innerText == "E")
			url = "../../eCP/jsp/EvaluateCarePlanFrameset.jsp?planid="+planid+"&md_plan_id="+md_plan_id+"&patient_id="+patient_id+"&cp_start_date="+cp_start_date+"&cp_target_date="+cp_target_date+"&encounter_id="+encounter_id+"&care_mgr_name="+care_mgr_name;
		else if(obj.innerText == "R")
			url="../../eCP/jsp/ReviseCarePlanViewFrameset.jsp?care_plan_id="+planid+'&md_care_plan_id='+md_plan_id+'&cp_start_date='+cp_start_date+'&cp_target_date='+cp_target_date+'&cp_day_no='+cp_day_no+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&care_mgr_id="+care_manager_id+'&careManagerName='+care_mgr_name;
		
		var dialogHeight = '90vh';
		//var dialogWidth = window.screen.width ;
		var dialogWidth = '90vw' ;
		var dialogTop	= '0';
		var dialogLeft = '0' ;
		var arguments   = "" ;
		var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; status:no" ;
		var returnval = await top.window.showModalDialog( url, arguments, features ) ;
		if(returnval=='SUCCESS')
		document.location.href  = "../../eCP/jsp/EvaluateCarePlanActivePlansResult.jsp?p_patient_id="+patient_id+"&facilty_id="+facilty_id+"&encounter_id="+encounter_id+"&p_care_manager_id="+care_manager_id+"&p_term_set_id="+term_set_id+"&p_term_code="+term_code+"&p_fr_date="+from_date+"&p_to_date="+to_date+"&view_plans="+view_plans+"&view_summary="+view_summary;
	}
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
	if(!doDateCheckAlert(document.eval_cp_crit.eval_id_frmdate,document.eval_cp_crit.eval_id_todate))
	{
		alert(getMessage("TO_DT_GR_EQ_FM_DT","CP"));
		document.eval_cp_crit.eval_id_todate.focus();
		document.eval_cp_crit.eval_id_todate.select();
	}
}
function colorcgfront(obj)
{
	obj.style.color = "red";
}
function colorcgback(obj)
{
	obj.style.color = "#1AFF1A";
}
function callintvnandoutcomepg(planid,md_plan_id,termsetid,termcode,goalcode,eval_id,mode)
{
	parent.eval_cp_intvnandoutcome.location.href = "../../eCP/jsp/EvaluateCarePlanIntvnAndOutcomeList.jsp?planid="+planid+"&md_plan_id="+md_plan_id+"&term_set_id="+termsetid+"&term_code="+termcode+"&goal_code="+goalcode+"&eval_id="+eval_id+"&mode="+mode;
}
function funcrecord()
{
	
	parent.eval_cp_diagandgoal.document.eval_cp_diagandgoallist.outcome_count.value = parent.eval_cp_intvnandoutcome.document.eval_cp_intvnandoutcomelist.outcome_count.value;
	var outcome_Obj = parent.eval_cp_intvnandoutcome.document.eval_cp_intvnandoutcomelist.elements;
	var str = ""
	for(i=0;i<outcome_Obj.length;i++)
	{
		str += '<input type="hidden" name="'+outcome_Obj[i].name+'" id="'+outcome_Obj[i].name+'" value="'+outcome_Obj[i].value+'">'
	}
	parent.eval_cp_diagandgoal.document.getElementById("dynacreation_outcome").innerHTML = str;
	parent.eval_cp_diagandgoal.document.eval_cp_diagandgoallist.submit();
}
function wincls()
{
	window.close();
}

function checkForMax(obj){
	var remarks=obj.value;
	if(remarks.length > 4000){
		message=getMessage("LENGTH_CANNOT_4000","CP");
		alert(message);
		obj.select();
		obj.focus();
	}
}

function showDiagHistory(term_set_id, term_code, term_code_srl_no, diag_desc){
	
	var frmObj = parent.frames[0].document.forms[0];
	var care_plan_id = frmObj.care_plan_id.value;
	var md_plan_id = frmObj.md_plan_id.value;

	var url = "../../eCP/jsp/EvaluateCarePlanChartFrameset.jsp?comp=D&care_plan_id="+care_plan_id+"&md_plan_id="+md_plan_id+"&term_set_id="+term_set_id+"&term_code="+term_code+"&term_code_srl_no="+term_code_srl_no+"&diag_desc="+diag_desc;
	var dialogTop       = "204";
	var dialogLeft       = "165";
	var dialogHeight    = "35" ;
	var dialogWidth = "45" ;
	var arguments   = "" ;
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +"; dialogLeft:" + dialogLeft + "; status:no" ;
	var returnval = window.showModalDialog( url, arguments, features ) ;
	return returnval;
}

function showGoalHistory(term_set_id, term_code, term_code_srl_no, goal_code, goal_srl_no, goal_desc, diag_desc){

	var frmObj = parent.frames[0].document.forms[0];

	var care_plan_id = frmObj.care_plan_id.value;
	var md_plan_id = frmObj.md_plan_id.value;
	var url = "../../eCP/jsp/EvaluateCarePlanChartFrameset.jsp?comp=G&care_plan_id="+care_plan_id+"&md_plan_id="+md_plan_id+"&term_set_id="+term_set_id+"&term_code="+term_code+"&term_code_srl_no="+term_code_srl_no+"&goal_code="+goal_code+"&goal_srl_no="+goal_srl_no+"&goal_desc="+goal_desc+"&diag_desc="+diag_desc;
	var dialogTop       = "204";
	var dialogLeft       = "165";
	var dialogHeight    = "35" ;
	var dialogWidth = "45" ;
	var arguments   = "" ;
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +"; dialogLeft:" + dialogLeft + "; status:no" ;
	var returnval = window.showModalDialog( url, arguments, features ) ;
	return returnval;
}

function showOutcomeHistory(term_set_id, term_code, term_code_srl_no, goal_code, goal_srl_no, outcome_code, outcome_srl_no, outcome_desc)
{
	var frmObj = parent.frames[0].document.forms[0];

	var care_plan_id = frmObj.care_plan_id.value;
	var md_plan_id = frmObj.md_plan_id.value;
	var url = "../../eCP/jsp/EvaluateCarePlanChartFrameset.jsp?comp=O&care_plan_id="+care_plan_id+"&md_plan_id="+md_plan_id+"&term_set_id="+term_set_id+"&term_code="+term_code+"&term_code_srl_no="+term_code_srl_no+"&goal_code="+goal_code+"&goal_srl_no="+goal_srl_no+"&outcome_code="+outcome_code+"&outcome_srl_no="+outcome_srl_no+"&outcome_desc="+outcome_desc;
	var dialogTop       = "204";
	var dialogLeft       = "165";
	var dialogHeight    = "35" ;
	var dialogWidth = "45" ;
	var arguments   = "" ;
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +"; dialogLeft:" + dialogLeft + "; status:no" ;
	var returnval = window.showModalDialog( url, arguments, features ) ;
	return returnval;
}

function checkForMax(obj){
	var remarks=obj.value;
	if(remarks.length > 4000){
		message=getMessage("LENGTH_CANNOT_4000","CP");
		alert(message);
		obj.select();
		obj.focus();
	}
}
function Load_Diagnosis()
{
 clearDiagnosis();
 var frmObj=document.forms[0];
 var patient_id=frmObj.p_patient_id.value;
 var diagnosis_set=frmObj.eval_diag[frmObj.eval_diag.selectedIndex].value;
 var xmlDoc="" ;
 var xmlHttp = new XMLHttpRequest() ;
 xmlStr ="<root><SEARCH " ;
 xmlStr +=" /></root>" ;
 //var xmlString = getXMLString(null);  
 var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
// xmlDoc.loadXML( xmlStr);
 xmlHttp.open( "POST","../../eCP/jsp/EvaluateCarePlanDynamicValues.jsp?diagnosis_set="+diagnosis_set+"&patient_id="+patient_id+"&type=eval_diag", false);
 xmlHttp.send( xmlDoc ) ;
 responseText=xmlHttp.responseText ;
 eval(responseText);
}
function addDiagnosis(code,value)
{
   var element = document.createElement('OPTION');
   element.value =  code;
   element.text = value;
   parent.eval_cp_criteria.document.forms[0].diagnosis.add(element);
}
function clearDiagnosis( ) {
	var len = eval("document.forms[0].diagnosis.options.length") ;
	for(var i=0;i<len;i++){
		eval("document.forms[0].diagnosis.remove(\"diagnosis\")") ;
	}
	var tp 		= "  ---Select---  " ;
	var opt  	= eval("document.createElement(\"OPTION\")") ;
	opt.text 	= tp ;
	opt.value = "";
	eval("document.forms[0].diagnosis.add(opt)") ;
}
async function calltasklist(obj,care_plan_id,md_plan_id,patient_id,intvncode,encounter_id)
{
	/*alert("care_plan_id "+care_plan_id);
	alert("md_plan_id "+md_plan_id);
	alert("patient_id "+patient_id);
	alert("encounter_id "+encounter_id);
	alert("intvncode "+intvncode);
	alert("p_care_mgr_id "+p_care_mgr_id);
	alert("facilty_id "+facilty_id);*/

	var facilty_id = parent.eval_cp_criteria.document.eval_cp_crit.facilty_id.value;
	var p_care_mgr_id = parent.eval_cp_result.document.eval_cp_result.p_care_mgr_id.value;
	url = "../../eCA/jsp/PatTaskListGeneratePlan.jsp?care_plan_id="+care_plan_id+"&md_care_plan_id="+md_plan_id+"&PatientId="+patient_id+"&encounterId="+encounter_id+"&taskCode="+intvncode+"&ca_practitioner_id="+p_care_mgr_id+"&facility_id="+facilty_id;
	var dialogHeight = '90vh';
	var dialogWidth = window.screen.width ;
	var dialogWidth = '90vw' ;
	var dialogTop	= '0';
	var dialogLeft = '0' ;
	var arguments   = "" ;
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; status:no" ;
	var returnval = await top.window.showModalDialog( url, arguments, features ) ;
}
function rowcompress(obj, rowvalue)
{
	var disprow=document.getElementById("plan"+rowvalue);
	if(obj.innerText == '-')
	{
		obj.innerText = '+';
		for(i=0;i<disprow.length;i++)
		{
			document.getElementById("plan"+rowvalue)[i].style.display='none';
		}
	}
	else if(obj.innerText == '+')
	{
		obj.innerText = '-';
		for(i=0;i<disprow.length;i++)
		{
			document.getElementById("plan"+rowvalue)[i].style.display='inline';
		}
	}
}
function loadchart(texts,comp,care_plan_id,md_plan_id,term_set_id, term_code, term_code_srl_no,diag_desc, goal_code, goal_srl_no,goal_desc, outcome_code, outcome_srl_no,outcome_desc)
{
	if(texts=="Text")
		parent.bottom_frame.document.location.href = "../../eCP/jsp/EvaluateCarePlanComponentHistory.jsp?comp="+comp+"&care_plan_id="+care_plan_id+"&md_plan_id="+md_plan_id+"&term_set_id="+term_set_id+"&term_code="+term_code+"&term_code_srl_no="+term_code_srl_no+"&goal_code="+goal_code+"&goal_srl_no="+goal_srl_no+"&outcome_code="+outcome_code+"&outcome_srl_no="+outcome_srl_no+"&outcome_desc="+outcome_desc+"&diag_desc="+diag_desc+"&goal_desc="+goal_desc;
	else if(texts=="Graph")
		parent.bottom_frame.document.location.href =  "../../eCP/jsp/EvaluateCarePlanChartDetail.jsp?comp="+comp+"&care_plan_id="+care_plan_id+"&md_plan_id="+md_plan_id+"&term_set_id="+term_set_id+"&term_code="+term_code+"&term_code_srl_no="+term_code_srl_no+"&goal_code="+goal_code+"&goal_srl_no="+goal_srl_no+"&outcome_code="+outcome_code+"&outcome_srl_no="+outcome_srl_no+"&outcome_desc="+outcome_desc+"&diag_desc="+diag_desc+"&goal_desc="+goal_desc;
}
function callvar(comp,care_plan_id,md_plan_id,patient_id)
{
	var care_manager_id = parent.eval_cp_criteria.document.eval_cp_crit.care_manager_id.value;
	var term_set_id = parent.eval_cp_criteria.document.eval_cp_crit.eval_diag.value;
	var term_code = parent.eval_cp_criteria.document.eval_cp_crit.diagnosis.value;
	var facilty_id = parent.eval_cp_criteria.document.eval_cp_crit.facilty_id.value;
	var encounter_id = parent.eval_cp_criteria.document.eval_cp_crit.encounter_id.value;
	var from_date = parent.eval_cp_criteria.document.eval_cp_crit.eval_frmdate.value;
	var to_date= parent.eval_cp_criteria.document.eval_cp_crit.eval_todate.value;
	var view_plans= parent.eval_cp_criteria.document.eval_cp_crit.view_plans.value;
	var view_summary= parent.eval_cp_criteria.document.eval_cp_crit.view_summary.value;
	var url="../../eCP/jsp/CarePlanVariance.jsp?p_care_plan_id="+care_plan_id+"&p_md_care_plan_id="+md_plan_id+"&p_var_comp_type="+comp;
	var dialogHeight = '90vh';
	//var dialogWidth = window.screen.width ;
	var dialogWidth ='90vw';
	var dialogTop	= '10';
	var dialogLeft = '0' ;
	var arguments   = "" ;
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; status:no" ;
	var returnval =await  top.window.showModalDialog( url, arguments, features ) ;
	if(returnval=="SUCCESS")
		document.location.href  = "../../eCP/jsp/EvaluateCarePlanActivePlansResult.jsp?p_patient_id="+patient_id+"&facilty_id="+facilty_id+"&encounter_id="+encounter_id+"&p_care_manager_id="+care_manager_id+"&p_term_set_id="+term_set_id+"&p_term_code="+term_code+"&p_fr_date="+from_date+"&p_to_date="+to_date+"&view_plans="+view_plans+"&view_summary="+view_summary;
}

//Added on Nov 8th
async function showMsr(objtype,code,desc,count,pct){

	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var locale=document.forms[0].locale.value;
	//alert(code);
	//argumentArray[0] ="SELECT OUTCOME_MSR_ID code, OUTCOME_MSR_DESC description,cut_off_score score FROM CP_OUTCOME_MSR WHERE OUTCOME_CODE='"+code+"' AND UPPER(OUTCOME_MSR_ID) LIKE UPPER(?) AND UPPER(OUTCOME_MSR_DESC) LIKE UPPER(?) ORDER BY OUTCOME_MSR_DESC";
	  argumentArray[0] ="SELECT OUTCOME_MSR_ID code, OUTCOME_MSR_DESC description,cut_off_score score FROM CP_OUTCOME_MSR_lang_vw WHERE OUTCOME_CODE='"+code+"' AND UPPER(OUTCOME_MSR_ID) LIKE UPPER(?) AND UPPER(OUTCOME_MSR_DESC) LIKE UPPER(?) AND language_id = '"+locale+"' ORDER BY OUTCOME_MSR_DESC";
	//alert("query "+argumentArray[0]);
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2"; 
	argumentArray[5]   = "" ;
	argumentArray[6] = CODE_LINK;	//CODE_LINK
	argumentArray[7] = CODE_DESC;	//CODE_DESC
	retVal = await CommonLookup(desc, argumentArray );
	var str =unescape(retVal);
	var arr = str.split(",");
	var desc = arr[1] ;
	var id= arr[0];
	if(id != undefined){
//		alert("objtype in showmsr"+objtype);
		var xmlDoc="" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlStr ="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc.loadXML( xmlStr);
		xmlHttp.open( "POST","../../eCP/jsp/EvaluateCarePlanDynamicValues.jsp?id="+id+"&code="+code+"&type=eval_msr&count="+count+"&pct="+pct+"&iddesc="+desc+"&objtype="+objtype, false);
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		//alert(responseText);
		eval(responseText);
	}
}

function setScore(score,outcomecount,outcome_pct,msrid,objtype){
	scoreval=parseInt(score);
	count=parseInt(outcomecount); // go get the row number in the table

	if(scoreval <4)
		scoreval=4;				// if the outcomemsr score is less that 4
//	alert("score"+score);
	var value=scoreval/4;
	var colid=Math.round(parseInt(value));		// to get the progress bar number
	var col_id=colid+3;							// to know the exact col id in the table
	var td_id=parseInt(col_id);
	var progressbarscore=colid*4;				// value to be inserted in the table
	
//	alert("objtype "+objtype);
	if(objtype=='Outcome'){
		obj1=document.eval_cp_intvnandoutcomelist.outcometable.rows[count].cells;
		//alert("Obj1===>"+obj1);
		var obj=obj1[td_id];
		//alert("Obj===>"+obj);
		msridobj = eval("document.eval_cp_intvnandoutcomelist.all.OutcomemsrID"+outcomecount);
		msridobj.value=msrid
		valfix(progressbarscore,obj,outcomecount,outcomecount,'Outcome',outcome_pct,0);
	}else if(objtype=='Goal'){
		obj1=document.eval_cp_diagandgoallist.all.DiagGoalTable.rows(count+1).cells;
		var obj=obj1[td_id+1];
		msridobj = eval("document.eval_cp_diagandgoallist.all.GoalmsrID"+outcomecount);
//		alert("Before in setScore"+(eval("document.eval_cp_diagandgoallist.all.GoalmsrID"+outcomecount).value));
		msridobj.value=msrid
//		alert("After in setScore"+(eval("document.eval_cp_diagandgoallist.all.GoalmsrID"+outcomecount).value));
		valfix(progressbarscore,obj,outcomecount,outcomecount,'Goal',outcome_pct,0);
//		alert("val "+progressbarscore);
//		alert("obj "+obj.id);
//		alert("hval "+outcomecount);
//		alert("row_count "+outcomecount);
//		alert("pct "+outcome_pct);
	}
}

function setMsrId(msrid,outcomecount,objtype){
//	alert(objtype);
	if(msrid=="")
	{
		if(objtype=="Outcome"){
			alert(getMessage("EVAL_MEAS_NOT_ASSOC_OUTCOME","CP"));
		}
		else if(objtype=="Goal"){
			alert(getMessage("EVAL_MEAS_NOT_ASSOC_GOAL","CP"));
		}
		return 0;
	}
	else
	{
		if(objtype=="Outcome"){
			eval("document.eval_cp_intvnandoutcomelist.all.OutcomemsrID"+outcomecount).value=msrid;
		}
		else if(objtype=="Goal"){
		//	alert("Before"+(eval("document.eval_cp_diagandgoallist.all.GoalmsrID"+outcomecount).value));
			eval("document.eval_cp_diagandgoallist.all.GoalmsrID"+outcomecount).value=msrid;
		//	alert("After"+(eval("document.eval_cp_diagandgoallist.all.GoalmsrID"+outcomecount).value));
		}
	}
	return 1;
}

async function showTermcodeMsr(termsetId,termCode,termcodeDesc,diag_count,diag_pct){
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array();
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var desc=termcodeDesc;
	//alert(code);
	argumentArray[0] ="SELECT TERM_CODE_MSR_ID code, TERM_CODE_MSR_DESC description from CP_TERM_CODE_MSR where TERM_SET_ID='"+termsetId+"' and TERM_CODE='"+termCode+"' AND UPPER(TERM_CODE_MSR_ID) LIKE UPPER(?) AND UPPER(TERM_CODE_MSR_DESC) LIKE UPPER(?) ORDER BY TERM_CODE_MSR_DESC";
	//alert("query "+argumentArray[0]);
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2"; 
	argumentArray[5]   = "" ;
	argumentArray[6] = CODE_LINK;	//CODE_LINK
	argumentArray[7] = CODE_DESC;	//CODE_DESC
	retVal = await CommonLookup(desc, argumentArray );
	var str =unescape(retVal);
	var arr = str.split(",");
	var desc = arr[1] ;
	var id= arr[0];
	if(id!=undefined){
		var xmlDoc="" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlStr ="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc.loadXML( xmlStr);
		xmlHttp.open( "POST","../../eCP/jsp/EvaluateCarePlanDynamicValues.jsp?termsetId="+termsetId+"&termCode="+termCode+"&type=eval_termCode_msr&diag_count="+diag_count+"&diag_pct="+diag_pct+"&id="+id, false);
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		//alert(responseText);
		eval(responseText);
	}
}

function setTermCodeScore(termsetId,termCode,score,diag_count,diag_pct,msrid){
	//	alert("msrid "+msrid);
	scoreval=parseInt(score);
	count=parseInt(diag_count); // go get the row number in the table

	if(scoreval <4)
		scoreval=4;				// if the outcomemsr score is less that 4

	var value=scoreval/4;
	var colid=Math.round(parseInt(value));		// to get the progress bar number
	var col_id=colid+3;							// to know the exact col id in the table
	var td_id=parseInt(col_id);
	var progressbarscore=colid*4;				// value to be inserted in the table
	
		obj1=document.eval_cp_diagandgoallist.all.DiagGoalTable.rows(count).cells;
		var obj=obj1[td_id];
		msridobj = eval("document.eval_cp_diagandgoallist.all.DiagmsrID"+diag_count);
		//alert("Before in setScore"+(eval("document.eval_cp_diagandgoallist.all.DiagmsrID"+diag_count).value));
		msridobj.value=msrid;
		//alert("After in setScore"+(eval("document.eval_cp_diagandgoallist.all.DiagmsrID"+diag_count).value));
		valfix(progressbarscore,obj,diag_count,diag_count,'Diag',diag_pct,0);
		/*alert("val "+progressbarscore);
		alert("obj "+obj.id);
		alert("hval "+diag_count);
		alert("row_count "+diag_count);
		alert("pct "+diag_pct);*/
}

function settermCodeMsrId(msrid,termcodecount){
	//alert(msrid);
	//	alert("Before"+(eval("document.eval_cp_diagandgoallist.all.DiagmsrID"+termcodecount).value));
		if(msrid=="")
		{
			alert(getMessage("EVAL_MEAS_NOT_ASSOC_TERMCODE","CP"));
			return 0;
		}
		else
		{
			eval("document.eval_cp_diagandgoallist.all.DiagmsrID"+termcodecount).value=msrid;
			return 1;
		}
	//	alert("After"+(eval("document.eval_cp_diagandgoallist.all.DiagmsrID"+termcodecount).value));
}

function ShowHistory()
{
	var p_patient_id = parent.eval_cp_diagandgoal.document.eval_cp_diagandgoallist.patient_id.value;
	var care_manager_id = parent.eval_cp_diagandgoal.document.eval_cp_diagandgoallist.care_manager.value;
	var care_plan_id = parent.eval_cp_diagandgoal.document.eval_cp_diagandgoallist.care_plan_id.value;
	var md_care_plan_id = parent.eval_cp_diagandgoal.document.eval_cp_diagandgoallist.md_plan_id.value;
	var encounter_id = parent.eval_cp_diagandgoal.document.eval_cp_diagandgoallist.encounter_id.value;

	var dialogHeight = '20';
	var dialogWidth = '50' ;
	var dialogTop	= '200';
	var dialogLeft = '0' ;
	var arguments   = "" ;
	var features    = "dialogHeight:"+dialogHeight+";dialogWidth:"+dialogWidth+";dialogTop:"+dialogTop+";status:no";
	var retval=new String();
	//var url = "../../eCP/jsp/EvaluateCarePlanHistoryFrameSet.jsp?patient_id="+p_patient_id+"&care_manager="+care_manager_id+"&care_plan_id="+care_plan_id+"&md_care_plan_id="+md_care_plan_id+"&encounter_id="+encounter_id+"&eval_id="+eval_id+"&termset_id="+termset_id+"&termcode="+termcode+"&goalcode="+goalcode+"&start_date="+start_date+"&target_date="+target_date;
	var url = "../../eCP/jsp/EvaluateCarePlanHistoryCriteria.jsp?patient_id="+p_patient_id+"&care_manager="+care_manager_id+"&care_plan_id="+care_plan_id+"&md_care_plan_id="+md_care_plan_id+"&encounter_id="+encounter_id;//+"&eval_id="+eval_id+"&termset_id="+termset_id+"&termcode="+termcode+"&goalcode="+goalcode+"&start_date="+start_date+"&target_date="+target_date;
	window.showModalDialog(url,arguments,features);
/*	retval=window.showModalDialog(url,arguments,features);
	return retval;*/
}

function ShowRemarks(remarks)
{
	var dialogHeight = '10';
	var dialogWidth = '35' ;
	var dialogTop	= '300';
	var dialogLeft = '' ;
	var arguments   = "" ;
	var features    = "dialogHeight:"+dialogHeight+";dialogWidth:"+dialogWidth+";dialogTop:"+dialogTop+";status:no";
	var retval=new String();
	var url = "../../eCP/jsp/EvaluateCarePlanHistoryRemarks.jsp?remarks="+remarks;
	//window.showModalDialog(url,arguments,features);
	window.showModalDialog(url,arguments,features);
}

/*function ShowDiagIntvn(eval_id)
{
	var care_manager=document.eval_cp_history_criteria.care_mgr_name.value;
	var plan_id=document.eval_cp_history_criteria.planid.value;
	var md_plan_id=document.eval_cp_history_criteria.md_plan_id.value;
	var patient_id=document.eval_cp_history_criteria.patient_id.value;
	var encounter_id=document.eval_cp_history_criteria.encounter_id.value;
	var eval_date=document.eval_cp_history_criteria.eval_date.value;
	var goalcode=document.eval_cp_history_criteria.goalcode.value;
	var termcode=document.eval_cp_history_criteria.termcode.value;
	var termset_id=document.eval_cp_history_criteria.termset_id.value;

	var cp_start_date=document.eval_cp_history_criteria.start_date.value;
	var cp_target_date=document.eval_cp_history_criteria.target_date.value;
	var remarks="";

   parent.eval_cp_history_diag.location.href="../../eCP/jsp/EvaluateCarePlanDiagAndGoalList.jsp?mode=History"+"&care_mgr_name="+care_manager+"&planid="+plan_id+"&md_plan_id="+md_plan_id+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&eval_id="+eval_id+"&cp_start_date="+cp_start_date+"&cp_target_date="+cp_target_date+"&remarks="+remarks+"&eval_date="+eval_date;

   parent.eval_cp_history_intvn.location.href="../../eCP/jsp/EvaluateCarePlanIntvnAndOutcomeList.jsp?mode=History"+"&planid="+plan_id+"&md_plan_id="+md_plan_id+"&eval_id="+eval_id+"&term_set_id="+termset_id+"&term_code="+termcode+"&goal_code="+goalcode+"&eval_date="+eval_date;
}*/

