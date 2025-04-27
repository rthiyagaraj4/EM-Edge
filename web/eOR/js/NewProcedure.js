/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function checkDateRange(obj){

	var fromDate = document.newproc_search.date_from
	var toDate = document.newproc_search.date_to

	if(CheckDate(obj)){ //  this method is from ValidateControl.js

		if(doDateCheck(fromDate,toDate) == 1) { // this function is available in eOR/js/orCommonFunctions.js
			alert(getMessage("TO_DT_GR_EQ_FM_DT","SM")); // this message available in messages.js of ecommon/js
			obj.select()
			return false
		}
	}
}
function AllowDateFormat(){
   var key = window.event.keyCode;
   if( ! ( (( key>=48 ) && ( key<58 ) ) || (key == 47)) ) {
       return false;
   }

}
function doDateCheck(from,to) {
    var fromarray; var toarray;
    var fromdate = from.value ;
    var todate   = to.value ;
    if(fromdate.length > 0 && todate.length > 0 ) {
            fromarray = fromdate.split("/");
            toarray = todate.split("/");
            var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
            var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
            if(Date.parse(todt) < Date.parse(fromdt))
               return 1 ;
            else if(Date.parse(todt) > Date.parse(fromdt))
			  return  -1 ;
			else if(Date.parse(todt) == Date.parse(fromdt))
			 return  0 ;

   }

}

async function show_window()
{
	var dob = document.RecDaignosis_form.dob.value;
	var age = document.RecDaignosis_form.age.value;
	var sex = document.RecDaignosis_form.sex.value;
	var searchtext = document.RecDaignosis_form.diagprob_code.value;
	var practitioner_id = document.RecDaignosis_form.Practitioner_Id.value;
	//var term_set_id = document.RecDaignosis_form.code_set.value;
	var term_set_id = "";
	var p_auth_yn = "N";
	var retVal =    new String();
	var dialogHeight= "27.22" ;
	var dialogWidth = "44" ;
	var status = "no";
	var arguments = "";
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

	retVal = await window.showModalDialog("TermCodeSearchMainFrame.jsp?term_set_id="+term_set_id+"&termsetid="+term_set_id+"&Dob="+dob+"&Age="+age+"&Sex="+sex,arguments,features);

	if(retVal != null)
	{
		var arr = new Array();
		retcode = retVal.split("/");
		document.RecDaignosis_form.diagprob_code.value = retcode;
		document.RecDaignosis_form.diagprob_code.onblur();
	}
	
}

function getDescription()
{
	
	var diag_code = document.RecDaignosis_form.diagprob_code.value;
	var diagprob_desc = document.RecDaignosis_form.diagprob_desc.value;
	if(diag_code!="")
	{
		htmlval = "<html><body><form name='newprocedurevalidate' id='newprocedurevalidate' method='post' action='../../eOR/jsp/NewProcedureCodeValidation.jsp'><input type='none' name='term_set_id' id='term_set_id' value='"+document.RecDaignosis_form.code_set.value+"'><input type='none' name='term_set_code' id='term_set_code' value='"+diag_code+"'><input type='none' name='Age' id='Age' value='"+document.RecDaignosis_form.age.value+"'><input type='none' name='Sex' id='Sex' value='"+document.RecDaignosis_form.sex.value+"'><input type='none' name='Dob' id='Dob' value='"+document.RecDaignosis_form.dob.value+"'><input type='none' name='modal_yn' id='modal_yn' value='"+document.RecDaignosis_form.modal_yn.value +"' ></input> </form></body></html>";
		
		if(parent.NewProcedure.document.RecDaignosis_form.modal_yn.value =='Y'	)
		{
		parent.frames[5].document.body.insertAdjacentHTML('afterbegin',htmlval);
		parent.frames[5].document.MRvalidate.submit();
		}
		else
		{
			top.content.workAreaFrame.NewProcedureMain.blankframe1.document.body.insertAdjacentHTML('afterbegin',htmlval);
			top.content.workAreaFrame.NewProcedureMain.blankframe1.document.MRvalidate.submit();
		}
	}
	else{
		document.RecDaignosis_form.diagprob_desc.value = "";
		parent.NewProcBtn.document.getElementById("notice_anchor").innerText="";
	}
}
function onSuccess(){
	alert("in success");
	var diff_mode =top.frames[0].document.forms[0].diff_mode.value;
	var path = parent.frames[0].document.forms[0].qryStr.value;
	if(diff_mode =='Y')
		window.close();
	else
	{
		//top.frames[0].location.href = "../../eOR/jsp/NewProcedure.jsp?"+path;
		top.content.workAreaFrame.RecDiagnosisMain.reload();
		//top.frames[1].location.reload();
	}
}
function showProcedure(obj){
	if(obj.value!=null && obj.value!="")
	{
		document.RecDaignosis_form.procedure.disabled= false;
	//	expandColapseframe('E');
	}else{
		document.RecDaignosis_form.procedure.disabled= true;
	//	expandColapseframe('C');
	}
}
function showTable(obj)
{
	if(obj.value!=null && obj.value!="")
	{	 										
			//parent.NewProcedure.document.getElementById("DiagTable").style.display='inline';
			parent.NewProcedure.document.getElementById("DiagTable").style.display='none';
			if(parent.NewProcedure.document.RecDaignosis_form.modal_yn.value =='Y')
			{
				parent.parent.NewProcedureMain.document.getElementById("ProcMain").rows="7%,15%,3%,*,4%,0%,7%";
			}
			else
			{
				//top.content.workAreaFrame.NewProcedureMain.document.getElementById("ProcMain").rows="7%,15%,3%,*,4%,0%,7%";
top.content.workAreaFrame.NewProcedureMain.document.getElementById("ProcMain").rows="0%,0%,0%,13%,*,30%,4%,7%";
			}
			expandColapseframe('E');
	}
	else
	{
		parent.NewProcedure.document.RecDaignosis_form.DiagTable.style.display='none';		
		if(parent.NewProcedure.document.RecDaignosis_form.modal_yn.value =='Y')
		{
			parent.parent.NewProcedureMain.document.getElementById("ProcMain").rows="7%,60%,3%,*,4%,0%,7%";
		}
		else	
		{
			top.content.workAreaFrame.NewProcedureMain.document.getElementById("ProcMain").rows="7%,60%,3%,*,4%,0%,7%";
		}
		expandColapseframe('C');
	}
	

	//parent.NewProcedure.document.RecDaignosis_form.expand.disabled = true;
	//parent.NewProcedure.document.RecDaignosis_form.collapse.disabled = false;
	//parent.NewProcedure.document.RecDaignosis_form.expandcollapse.value = 'E';

}

function callDetails(Patient_Id,term_code,term_set_id,patient_class,onset_date,notifiable_yn,dob,age,sex,occur_srl_no,associate_codes,Encr_id)
{
	
	//alert("notifiable_yn=----"+notifiable_yn);
	/*modal_yn=parent.frames[1].document.query_result_form.modal_yn.value;	parent.NewProcedure.document.location.href="../../eMR/jsp/RecDiagnosisAddModify.jsp?Patient_Id="+Patient_Id+"&term_code="+term_code+"&term_set_id="+term_set_id+"&patient_class="+patient_class+"&onset_date="+onset_date+"&Dob="+dob+"&Age="+age+"&Sex="+sex+"&occur_srl_no="+occur_srl_no+"&mode=modify&associate_codes="+associate_codes+"&modal_yn="+modal_yn+"&Encounter_Id="+Encr_id+"&notifiable_yn="+notifiable_yn;

	if(parent.NewProcedure.document.RecDaignosis_form.modal_yn.value =='Y')
	{
		parent.parent.frames[1].document.getElementById("ProcMain").rows="7%,15%,3%,*,4%,0%,7%";
	}
	else
	{
		top.content.workAreaFrame.NewProcedureMain.document.getElementById("ProcMain").rows="7%,15%,3%,*,4%,0%,7%";
	}

	parent.NewProcedure.document.RecDaignosis_form.expand.disabled = true;
	parent.NewProcedure.document.RecDaignosis_form.collapse.disabled = false;
	parent.NewProcedure.document.RecDaignosis_form.expandcollapse.value = 'E';
*/
}

function showRelatedProcedure(index){

//	var frmObj = parent.parent.GeneratePlanProfile.GeneratePlanProfileDiagnosis;
	//alert("obj==="+eval("frmObj.document.getElementById("proc_tree")"+index).innerText+"==");
	var obj = eval("document.getElementById("proc_tree")"+index).innerText;
	if(obj == "+"){
		eval(document.getElementById("proc_detail"+index)).style.display='inline';
		eval(document.getElementById("proc_tree"+index)).innerHTML="<font size='1' color='#6633FF'><B>--</B></font>";
		
	}else if(obj == "--"){
		eval(document.getElementById("proc_detail"+index)).style.display='none';
	//	eval("frmObj.document.getElementById("proc_tree")"+index).innerText='+';
		eval(document.getElementById("proc_tree"+index)).innerHTML="<font size='1' color='#6633FF'><B>+</B></font>";
	}

}

function callProceduredetail(proc_code){
	return false;
	var cnt = parent.NewProcedure.document.RecDaignosis_form.code_set.options.length;
	for(var i =0;i<cnt;i++){
		var tmp_code= parent.NewProcedure.document.RecDaignosis_form.code_set.options(i).value;
		if(proc_code == tmp_code){
			parent.NewProcedure.document.RecDaignosis_form.code_set.options[i].selected = "selected" ;
			parent.NewProcedure.document.RecDaignosis_form.code_set.options[i].selected = "selected" ;
		}
	}
	expandColapseframe("E");
}

function expandColapseframe(id)
{
	if(id == "E")
	{
		parent.NewProcedure.document.getElementById("exp_coll").innerHTML="<input type='button' class='button' value='Collapse' onClick='expandColapseframe(\"C\")' name='btn_expand' id='btn_expand'>";	
		if(parent.NewProcedure.document.RecDaignosis_form.modal_yn.value =='Y')
		{
			parent.parent.frames[1].document.getElementById("ProcMain").rows="7%,15%,3%,*,4%,0%,7%";
		}
		else
		{
			//top.content.workAreaFrame.NewProcedureMain.document.getElementById("ProcMain").rows="7%,15%,3%,*,4%,0%,7%";
			//top.content.workAreaFrame.NewProcedureMain.document.getElementById("ProcMain").rows="17%,15%,3%,*,4%,0%,7%";
			top.content.workAreaFrame.NewProcedureMain.document.getElementById("ProcMain").rows="0%,0%,0%,12%,30%,*,4%,7%";
		}
		//parent.NewProcedure.document.RecDaignosis_form.expand.disabled = true;
		//parent.NewProcedure.document.RecDaignosis_form.collapse.disabled = false;
		parent.NewProcedure.document.RecDaignosis_form.expandcollapse.value = 'E';
		
	}
	else if(id =="C")
	{
		parent.NewProcedure.document.getElementById("exp_coll").innerHTML="<input type='button' class='button' value='Expand' onClick='expandColapseframe(\"E\")' name='btn_expand' id='btn_expand'>";	
		if(parent.NewProcedure.document.RecDaignosis_form.modal_yn.value =='Y')
		{
			parent.parent.frames[1].document.getElementById("ProcMain").rows="7%,60%,3%,*,4%,0%,7%";
		}
		else	
		{
			//top.content.workAreaFrame.NewProcedureMain.document.getElementById("ProcMain").rows="7%,60%,3%,*,4%,0%,7%";
		//	top.content.workAreaFrame.NewProcedureMain.document.getElementById("ProcMain").rows="17%,53%,3%,*,4%,0%,7%";
		top.content.workAreaFrame.NewProcedureMain.document.getElementById("ProcMain").rows="17%,53%,3%,*,0%,0%,4%,7%";
		}
		//parent.NewProcedure.document.RecDaignosis_form.collapse.disabled = true;
		//parent.NewProcedure.document.RecDaignosis_form.expand.disabled = false;
		parent.NewProcedure.document.RecDaignosis_form.expandcollapse.value = 'E';
	}

}


function showLongDescription()
{
	var dialogHeight= "20" ;
    var dialogWidth = "23" ;
	var a = document.forms[0].LongDescription.value;
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no";
	window.showModalDialog("../../eMR/jsp/RecDaignosisLongDescDialog.jsp?longDesc="+a,"",features);
}


async function show_window()
{
	var dob = document.RecDaignosis_form.dob.value;
	var age = document.RecDaignosis_form.age.value;
	var sex = document.RecDaignosis_form.sex.value;
	var searchtext = document.RecDaignosis_form.diagprob_desc.value;
	var practitioner_id = document.RecDaignosis_form.Practitioner_Id.value;
	var term_set_id = document.RecDaignosis_form.code_set.value;
	var p_auth_yn = "N";
	var retVal =    new String();
	var dialogHeight= "27.22" ;
	var dialogWidth = "44" ;
	var status = "no";
	var arguments = "";
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

	retVal = await window.showModalDialog("../../eMR/jsp/TermCodeSearchMainFrame.jsp?term_set_id="+term_set_id+"&termsetid="+term_set_id+"&Dob="+dob+"&Age="+age+"&Sex="+sex,arguments,features);

	if(retVal != null)
	{
		var arr = new Array();
		retcode = retVal.split("/");
		
		document.RecDaignosis_form.diagprob_code.value = retcode;
		document.RecDaignosis_form.diagprob_desc.value = retcode;
		document.RecDaignosis_form.diagprob_desc.onblur();
	}
	
}

function showSession(obj){
	if(obj.checked){
		document.RecDaignosis_form.procedure.disabled	= true;
		document.RecDaignosis_form.multi_session.value	= "Y";
		document.RecDaignosis_form.multi_session_btn.style.visibility = "visible";
	}else{
		document.RecDaignosis_form.procedure.disabled	= false;
		document.RecDaignosis_form.multi_session.value	= "N";
		document.RecDaignosis_form.multi_session_btn.style.visibility = "hidden";
	}
}

async function callTermCode(){

		/*if(document.RecDaignosis_form.code_set.value ==""){
			alert("APP - MR0002 Procedure Set Cannot be Blank");
			document.RecDaignosis_form.code_set.focus();
			return false;
		}*/
		var temp_term_code = "";
		var term_code_associated = "";
		var mode ="";
		var radioval ="";
		if(parent.proc_main_result.document.multi_procedure){
			temp_term_code = parent.proc_main_result.document.multi_procedure.temp_term_code.value;
			term_code_associated = parent.proc_main_result.document.multi_procedure.term_code_associated.value;
			mode = parent.proc_main_result.document.multi_procedure.mode.value
			radioval = parent.proc_main_result.document.multi_procedure.radioval.value
				alert(radioval);
			//	alert(term_code_associated);
			//alert(mode);
		}else
			mode = "1";
	
		var mulitple_yn = "Y";
		var term_set_id= "";
	
		var retVal = new String();
		var dialogHeight= "29" ;
		var dialogWidth = "45" ;
		var status = "no";
		
		var dialogUrl       = "../../eOR/jsp/NewProcTermCodeFrameset.jsp?title=Terminology&term_set_id="+term_set_id+"&mulitple_yn="+mulitple_yn+"&temp_term_code="+temp_term_code+"&term_code_associated="+term_code_associated+"&term_desc="+document.RecDaignosis_form.proc_text.value+"&radioval="+radioval ;
		//var dialogUrl       = "../../eMR/jsp/TermCodeFrameSet.jsp?title=&term_set_id="+term_set_id+"&mulitple_yn="+mulitple_yn+"&temp_term_code="+temp_term_code+"&term_code_associated="+term_code_associated+"&term_desc="+document.RecDaignosis_form.proc_text.value ;
		if(mode == '2'){
			dialogUrl+= "&Db_term_code="+term_code_associated;
		}
		var dialogArguments = term_set_id ;
		var dialogFeatures  = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		var returnVal = await window.showModalDialog(dialogUrl, term_set_id, dialogFeatures);

		if( returnVal == null || returnVal == "" ){
			//expandColapseframe('C');
			//alert("===here null==="+returnVal);
			if(parent.proc_main_result.document.multi_procedure){
				term_code_associated = parent.proc_main_result.document.multi_procedure.term_code_associated.value;
				
				if(term_code_associated != ""){
				var retValCode = term_code_associated.split("`") ;
				var term_code_associated ="";
				for(var i=0;i<(retValCode.length-1);i++){
					var retVal = retValCode[i].split("~") ;
					term_code =retVal[0]; 
					var level = retVal[1];
					level_desc =retVal[2];
					term_code_desc =retVal[3];
					
					term_code_associated += term_code+"~"+level+"~"+level_desc+"~"+term_code_desc+"`";
					
				}
				
				parent.proc_main_result.location.href="../../eOR/jsp/NewProcedureAddModifyMulti.jsp?mode="+mode+"&term_code_associated="+term_code_associated+"&radioval="+parent.proc_main_result.document.multi_procedure.radioval.value;
				
			//parent.proc_term_info.location.href="../../eOR/jsp/NewProcedureAddModifyMultiDetails.jsp?mode="+mode+"&term_code_associated="+term_code_associated+"&level=10&term_set=ICD10";
				
				}else{
					parent.proc_main_result.location.href="../../eOR/jsp/NewProcedureAddModifyMulti.jsp?mode="+mode;
				}
				
				//expandColapseframe('E');
			}
		}else{
		/*	var retValCode = returnVal.split("~") ;
			var term_code_associated ="";
			for(var i=0;i<(retValCode.length-1);i++){
				var retVal = retValCode[i].split("||") ;
				term_code =retVal[0];
				term_code_desc =retVal[1];
				level_desc =retVal[2];
				var level = retVal[3];
				
				//term_code_associated += term_set_id+"~"+level+"~"+level_desc+"~"+eval("document.terminology_level.lvl_code"+i).value+"*";
				term_code_associated += term_code+"~"+level+"~"+level_desc+"~"+term_code_desc+"`";
			}
		
			
		//	parent.proc_main_result.location.href="../../eOR/jsp/NewProcedureAddModifyMulti.jsp?mode="+mode+"&term_code_associated="+term_code_associated+"&level=10&term_set=ICD10";*/
		
		if(returnVal == "C" ){	
			parent.proc_main_result.location.href="../../eOR/jsp/NewProcedureAddModifyMulti.jsp?mode="+mode+"&radioval=C";
		}else{
			parent.proc_main_result.location.href="../../eOR/jsp/NewProcedureAddModifyMulti.jsp?mode="+mode+"&radioval=G";
		}
			
			
			//expandColapseframe('E');
		}
}
function chkPractType(obj){
	var pract_text="";
	if(obj.value != ""){
		var pract_arr=new Array();
		pract_text = obj.value;
		pract_arr = pract_text.split("~");
		document.multipract_form.pract_type.value = pract_arr[0];
		document.multipract_form.pract_text.value = pract_arr[1];
		//document.multipract_form.pract_desc.disabled = false;
		//document.multipract_form.pract_btn.disabled = false;
		//document.multipract_form.postn_desc.disabled = false;
		//document.multipract_form.postn_btn.disabled = false;
	}else{
		document.multipract_form.pract_type.value = "";
		document.multipract_form.pract_text.value = "";
		//document.multipract_form.pract_desc.disabled = true;
		//document.multipract_form.pract_btn.disabled = true;
		//document.multipract_form.postn_desc.disabled = true;
		//document.multipract_form.postn_btn.disabled = true;
	}

}
async function displayMultiPract(){
		var retVal = 	new String();
		var dialogHeight= "32" ;
		var dialogWidth	= "50" ;
		var status = "no";
		var arguments	= "" ;
		var tit="Pract Search";
				
		var dialogArguments = "Practitioner" ;
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		
		var sqlArray= new Array();
		var objName="";
		var sql="";
		var sqlsec="";
		//var pract_type= document.multipract_form.pract_type.value;	
		var pract_type= "";	
		//var pract_text= document.multipract_form.pract_text.value;	
		var pract_text= "";	
		//do not forget to give aliases as mentioned below	
			var open_to_all_pract_yn = "";		
			var facilityid = document.multipract_form.facilityId.value;		
			var cur_locn_code =  document.multipract_form.Locn_Code.value;		
			
			if(open_to_all_pract_yn=="Y")
			{
				sql = " SELECT  distinct a.practitioner_id  practitioner_id, a.practitioner_name practitioner_name ,b.desc_sysdef practitioner_type, c.short_desc primary_specialty, DECODE(a.gender,'M','Male','F','Female','U','Unknown') gender, DECODE(a.job_title,'CC','Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr. Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR','Trainee' ) job_title FROM am_practitioner a, am_pract_type b,am_speciality c, am_pract_for_facility d, op_clinic e WHERE a.pract_type=b.pract_type AND a.primary_speciality_code=c.speciality_code AND a.pract_type LIKE (?)  AND a.primary_speciality_code LIKE UPPER(?)  AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id))  OR  UPPER(a.practitioner_name) LIKE UPPER(NVL(?,a.practitioner_name))) AND  a.gender LIKE (?) AND (a.JOB_TITLE like (?) OR a.job_title IS NULL) and a.practitioner_id=d.practitioner_id and d.eff_status='E' and d.facility_id='"+facilityid+"' and e.facility_id=d.facility_id and e.clinic_code='"+cur_locn_code+"' and (e.speciality_code = a.primary_speciality_code or e.speciality_code in (select speciality_code from am_pract_specialities where facility_id='"+facilityid+"' and practitioner_id=a.practitioner_id)) and nvl(e.pract_type,a.pract_type) = a.pract_type order by 2 ";
				
				sqlsec=" SELECT  distinct a.practitioner_id  practitioner_id, a.practitioner_name practitioner_name ,b.desc_sysdef practitioner_type, c.short_desc primary_specialty, DECODE(a.gender,'M','Male','F','Female','U','Unknown') gender, DECODE(a.job_title,'CC','Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr. Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR','Trainee' ) job_title FROM am_practitioner a, am_pract_type b,am_speciality c, am_pract_for_facility d, op_clinic e WHERE a.pract_type=b.pract_type AND a.primary_speciality_code=c.speciality_code AND a.pract_type LIKE (?)  AND a.primary_speciality_code LIKE UPPER(?)  AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id))  and  UPPER(a.practitioner_name) LIKE UPPER(NVL(?,a.practitioner_name))) AND  a.gender LIKE (?) AND (a.JOB_TITLE like (?) OR a.job_title IS NULL) and a.practitioner_id=d.practitioner_id and d.eff_status='E' and d.facility_id='"+facilityid+"' and e.facility_id=d.facility_id and e.clinic_code='"+cur_locn_code+"' and (e.speciality_code = a.primary_speciality_code or e.speciality_code in (select speciality_code from am_pract_specialities where facility_id='"+facilityid+"' and practitioner_id=a.practitioner_id)) and nvl(e.pract_type,a.pract_type) = a.pract_type order by 2 ";
			
			}
			else
			{
				sql=" SELECT   distinct a.practitioner_id  practitioner_id, a.practitioner_name practitioner_name ,b.desc_sysdef practitioner_type, c.short_desc primary_specialty, DECODE(a.gender,'M','Male','F','Female','U','Unknown') gender, DECODE(a.job_title,'CC','Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr. Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR','Trainee' ) job_title FROM am_practitioner a, am_pract_type b,am_speciality c,op_pract_for_clinic_vw d WHERE a.pract_type=b.pract_type AND a.primary_speciality_code=c.speciality_code AND a.pract_type LIKE (?)  AND a.primary_speciality_code LIKE UPPER(?)  AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id))  OR  UPPER(a.practitioner_name) LIKE UPPER(NVL(?,a.practitioner_name))) AND  a.gender LIKE (?) AND (a.JOB_TITLE like (?) OR a.job_title IS NULL) and d.facility_id= '"+facilityid+"' and d.clinic_code=nvl('"+cur_locn_code+"',d.clinic_code) and d.eff_status='E' and a.practitioner_id=d.practitioner_id order by 2";
				
				sqlsec=" SELECT   distinct a.practitioner_id  practitioner_id, a.practitioner_name practitioner_name ,b.desc_sysdef practitioner_type, c.short_desc primary_specialty, DECODE(a.gender,'M','Male','F','Female','U','Unknown') gender, DECODE(a.job_title,'CC','Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr. Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR','Trainee' ) job_title FROM am_practitioner a, am_pract_type b,am_speciality c,op_pract_for_clinic_vw d WHERE a.pract_type=b.pract_type AND a.primary_speciality_code=c.speciality_code AND a.pract_type LIKE (?)  AND a.primary_speciality_code LIKE UPPER(?)  AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id))  and  UPPER(a.practitioner_name) LIKE UPPER(NVL(?,a.practitioner_name))) AND  a.gender LIKE (?) AND (a.JOB_TITLE like (?) OR a.job_title IS NULL) and d.facility_id= '"+facilityid+"' and d.clinic_code=nvl('"+cur_locn_code+"',d.clinic_code) and d.eff_status='E' and a.practitioner_id=d.practitioner_id order by 2";
			}
		//sqlArray[0]="<%=java.net.URLEncoder.encode(sql)%>";
		sqlArray[0]="";
		//sqlArray[1]="<%=java.net.URLEncoder.encode(sqlSec)%>";
		sqlArray[1]="";
		arguments=sqlArray;
		var pract_retval = document.multipract_form.pract_retval.value;
		if(pract_retval!=null && pract_retval!=''){
			var ret_split_val = pract_retval.split("||");
			var temp_practID="";
			for(var i=0;i<ret_split_val.length;i++){
				var temp_retVal = ret_split_val[i] ;
				var pract_detail= temp_retVal.split("~");
				temp_practID += pract_detail[0] +"*";
			}//alert(temp_practID);
		}
		//retVal = window.showModalDialog("../../eOR/jsp/NewPractLookupFrameset.jsp?practname="+document.multipract_form.Practitioner_Id.value+"&practitioner_type="+pract_type+"&specialty_code=&job_title=&gender=",arguments,features);
		retVal = await window.showModalDialog("../../eOR/jsp/NewPractLookupFrameset.jsp?practname=&practitioner_type="+pract_type+"&specialty_code=&job_title=&gender=&temp_practID="+temp_practID+"&pract_retval="+escape(pract_retval),arguments,features);
		var objName = "";
		if(retVal !=null){
			document.multipract_form.pract_retval.value = (retVal);
			PractLookupRetVal(retVal,objName);
			
		}else{
			//alert("in else part of return val");
			document.forms[0].reset();
		}
		/*
			var pract_type = document.multipract_form.pract_text.value;
			var term_code_associated = "0205~1~Level 1~Skull Plate Insertion`A02.0~1~Level 1~Salmonella enteritis. Salmonellosis`A020~1~Level 1~Salmonella Enteritis`"
			var term_code_array = new Array();
			var term_cd = new Array();
			term_code_array = term_code_associated.split("`");
			var text ="<table cellpadding=0 cellspacing=0 border=1 width='100%' align=center>";
			for(var i=0;i<(term_code_array.length - 1);i++){
				if ( i % 2 == 0 )
					classvalue = "QRYODD" ;
				else
					classvalue = "QRYEVEN" ;

				term_cd = term_code_array[i].split("~")
				text += "<tr><td colspan='' width='20%' class='"+classvalue+"'>"+pract_type+"</td><td colspan='' width='25%' class='"+classvalue+"'>"+term_cd[0]+"</td><td colspan='' width='25%' align='center' class='"+classvalue+"'><input type='text'  name='postn_desc' id='postn_desc' value='' size=20 >&nbsp;<input type='button' class='button' name='postn_btn' id='postn_btn' value='?' ></td><td colspan='' width='20%' class='"+classvalue+"'>"+term_cd[3]+"</td><td colspan='' align='center' width='10%' class='"+classvalue+"'><input type='checkbox' name='' id=''></td></tr>" ;

			}
			text += "</table>";
			document.getElementById("pract_val").innerHTML= text;
	*/



}
async function showPractWindow(practID)
{
	var url     = "../../eAM/jsp/ViewPractitionerDtls.jsp?practitioner_id="+practID+"&fcall=call";
	var dialogHeight= "30" ;
	var dialogWidth	= "40" ;
	var dialogLeft	="";
	var arguments   = "" ;
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; status=no;dialogLeft:"+dialogLeft+";";
	var reportURL   = await window.showModalDialog( url, arguments, features ) ;
}

function checkRole(){
	var flag= false;
	
	//alert(parent.proc_main_label.document.multipract_form.totalRecords.value);
	var frmObj = parent.proc_main_label.document.multipract_form;
	var cnt = frmObj.totalRecords.value;
	var role_cnt =0;
	for(var i=0;i<cnt;i++){
		var tmp_role = "";
		tmp_role = eval("frmObj.role_desc"+i).value;
		if(tmp_role == "01" ){
			flag=true;
			//break;
		}
	}
	if(flag){
		for(var i=0;i<cnt;i++){
			var tmp_role = "";
			tmp_role = eval("frmObj.role_desc"+i).value;
			for(var j=i+1;j<cnt;j++){
				var tmp_role1 = "";
				tmp_role1 = eval("frmObj.role_desc"+j).value;
				if(tmp_role == tmp_role1 && tmp_role == "01"  ){
					flag=false;
					break;
				}
			}
		}
	}
	if(!flag){
		eval("frmObj.role_desc"+0).focus();
		alert("One Main Surgeon is Mandatory");
		return false;
	}else
		return true;
}
function PractLookupRetVal(retVal,objName)
		{		
			          
            if(objName == "pract_name1")
			{
				var arr;
				if (retVal != null)
				{
				arr=retVal.split("~");
				parent.frames[1].document.forms[0].practitioner_id.value=arr[0];
				parent.frames[1].document.forms[0].pract_name1.value=arr[1];
				}
				else
					{
				parent.frames[1].document.forms[0].practitioner_id.value="";
				parent.frames[1].document.forms[0].pract_name1.value="";			
					}
			}else
			{
				//alert("here====="+retVal);
				var ret_val = retVal;
				var ret_split_val = ret_val.split("||");
				var j= 1;
				var text = "<table border=1 style='border-top-width:0;border-bottom-width:0;border-right-width:0;border-left-width:0 ' cellspacing=0 cellpadding =0 width='100%' align=center>";
				var logged_pract =  document.multipract_form.ca_practitioner_id.value;
				
				
				
				//text += "<tr><td colspan=''  align='center' width='5%' class='"+classvalue+"'><font size=1><a href=\"javascript:showPractWindow('"+logged_pract+"')\">+</a></font></td><td colspan='' width='50%' class='"+classvalue+"' align=''><font size=1>"+logged_pract+"</font></td><td colspan='' width='35%' class='"+classvalue+"'><select name='role_desc"+j+"' id='role_desc"+j+"'><option value='' disabled>--- Select ---</option><option value='01' selected >Main Surgeon</option><option value='11'>Assisting Surgeon</option><option value='21'>Anaesthetist</option><option value='41'>Consultant</option><option value='51'>Scrub Nurse</option></select> </td><td colspan='' align='center' width='10%' class='"+classvalue+"'><input type='checkbox' name='pract_chk"+j+"' id='pract_chk"+j+"' checked readonly></td></tr><input type='hidden' value='' name='pract_code"+j+"' id='pract_code"+j+"'><input type='hidden' value='' name='pract_type_code"+j+"' id='pract_type_code"+j+"'><input type='hidden' value='' name='postn_code"+j+"' id='postn_code"+j+"'><input type='hidden'  name='postn_desc"+j+"' id='postn_desc"+j+"' value=''>	" ;
				
				
				var cnt = ret_split_val.length;//alert(cnt);	
				for(var k=0;k<ret_split_val.length;k++){
					retVal = ret_split_val[k] ;
					//alert(ret_split_val[k]);
					var pract_detail= retVal.split("~");
				/*	if(j == 0){
						if(document.multipract_form.pract_desc.value == ""){
							var cnt= document.multipract_form.pract_desc.options.length;
							for(i=0;i<cnt;i++){
								var pract_val= document.multipract_form.pract_desc.options[i].value;
								var pract_split = pract_val.split("~");
								if(pract_detail[6] == pract_split[0]){
									document.multipract_form.pract_desc.options[i].selected= true;
									document.multipract_form.pract_type.value = pract_detail[6];		
									document.multipract_form.pract_text.value = pract_detail[7];
									break;
								}

								
							}
						}
						
						document.multipract_form.postn_code.value = pract_detail[0];		
						document.multipract_form.pract_description.value = pract_detail[1];		
						document.multipract_form.pract_type.value = pract_detail[6];		
						document.multipract_form.pract_text.value = pract_detail[7];		
						//document.multipract_form.pract_desc.value = pract_detail[7];		
						document.multipract_form.postn_code.value = pract_detail[8];		
						document.multipract_form.postn_description.value = pract_detail[9];		
				}else{*/
												
					if ( j % 2 == 0 )
						classvalue = "QRYODD" ;
					else
						classvalue = "QRYEVEN" ;

					text += "<tr><td colspan='' align='center' width='5%' class='"+classvalue+"'><font size=1><a href=\"javascript:showPractWindow('"+pract_detail[0]+"')\">+</a></font></td><td colspan='' width='50%' class='"+classvalue+"' align=''><font size=1>"+pract_detail[1]+"</font></td><td colspan='' width='35%' class='"+classvalue+"'><select name='role_desc"+j+"' id='role_desc"+j+"' onchange=''><option value=''>--- Select ---</option><option value='01'>Main Surgeon</option><option value='11'>Assisting Surgeon</option><option value='21'>Anaesthetist</option><option value='41'>Consultant</option><option value='51'>Scrub Nurse</option></select> </td><td colspan='' align='center' width='10%' class='"+classvalue+"'><input type='checkbox' name='pract_chk"+j+"' id='pract_chk"+j+"' checked readonly></td></tr><input type='hidden' value='"+pract_detail[0]+"' name='pract_code"+j+"' id='pract_code"+j+"'><input type='hidden' value='"+pract_detail[6]+"' name='pract_type_code"+j+"' id='pract_type_code"+j+"'><input type='hidden' value='"+pract_detail[8]+"' name='postn_code"+j+"' id='postn_code"+j+"'><input type='hidden'  name='postn_desc"+j+"' id='postn_desc"+j+"' value='"+pract_detail[9]+"'>	" ;
					//text += "<tr><td colspan='' width='5%' class='"+classvalue+"'><font size=1><a href=\"javascript:showPractWindow('"+pract_detail[0]+"')\">+</a></font></td><td colspan='' width='45%' class='"+classvalue+"' align=''><font size=1>"+pract_detail[1]+"</font></td><td colspan='' width='20%' align='center' class='"+classvalue+"'><font size=1>"+pract_detail[9]+"</font><input type='hidden'  name='postn_desc"+j+"' id='postn_desc"+j+"' value='"+pract_detail[9]+"' size=20 readonly></td><td colspan='' width='20%' class='"+classvalue+"'><select name='role_desc"+j+"' id='role_desc"+j+"'><option value=''>--- Select ---</option><option value='01'>Main Surgeon</option><option value='11'>Assisting Surgeon</option><option value='21'>Anaesthetist</option><option value='41'>Consultant</option><option value='51'>Scrub Nurse</option></select> </td><td colspan='' align='center' width='10%' class='"+classvalue+"'><input type='checkbox' name='pract_chk"+j+"' id='pract_chk"+j+"' checked readonly></td></tr><input type='hidden' value='"+pract_detail[0]+"' name='pract_code"+j+"' id='pract_code"+j+"'><input type='hidden' value='"+pract_detail[6]+"' name='pract_type_code"+j+"' id='pract_type_code"+j+"'><input type='hidden' value='"+pract_detail[8]+"' name='postn_code"+j+"' id='postn_code"+j+"'>	" ;
				//}
					
				j++;
			}

			//text += "<input type='hidden' value='"+cnt+"' name='totalRecords' id='totalRecords'>";
			document.multipract_form.totalRecords.value = cnt;
			text += "</table>";
			document.getElementById("pract_val").innerHTML= text;
		}
	}
function show_pract_window(target,code,i) {
	
  	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	
	dataNameArray[0] = "pract_type";
	//dataValueArray[0] 	= eval("formObjDetail.all.term_set")+i.value;
 	dataValueArray[0] 	= document.multipract_form.pract_type.value;
	//alert(dataValueArray[0]);
 	
	dataTypeArray[0] 	= STRING ;

 	//argumentArray[0]   = formObjDetail.all.term_set_desc_sql.value;
 	argumentArray[0]   = "select PRACTITIONER_ID CODE, PRACTITIONER_NAME DESCRIPTION from AM_PRACTITIONER where pract_type like nvl(?,pract_type) and upper(PRACTITIONER_ID) LIKE  UPPER(?) AND UPPER(PRACTITIONER_NAME) LIKE UPPER(?) order by 2";
	argumentArray[1]   = dataNameArray ;
 	argumentArray[2]   = dataValueArray ;
 	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "2,3";
	argumentArray[5]   = target.value ;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ;
  	retVal =await CommonLookup( getLabel("Common.practitioner.label","Common"), argumentArray );

	if(retVal != null && retVal != "")
	{
	  code.value=retVal[0];
	  target.value=retVal[1];
	  displayMultiPract();
    }
}
function show_postn_window(target,code,i) {
	
  	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	
	dataNameArray[0]	= "c.PRACTITIONER_ID";
	dataValueArray[0] 	= document.multipract_form.pract_code.value;
	dataTypeArray[0] 	= STRING ;
	
	dataNameArray[1]	= "c.pract_type";
 	dataValueArray[1] 	= document.multipract_form.pract_type.value;
	dataTypeArray[1] 	= STRING ;

 	//argumentArray[0]   = formObjDetail.all.term_set_desc_sql.value;
 	argumentArray[0]   = "select a.POSITION_CODE code, a.POSITION_DESC DESCRIPTION ,a.ROLE_TYPE from am_position a,am_pract_type b,am_practitioner c where staff_type = b.pract_type and b.pract_type = c.pract_type and c.PRACTITIONER_ID like upper(?)and c.pract_type like nvl(?,c.pract_type) and upper(a.POSITION_CODE) LIKE  UPPER(?) AND UPPER(a.POSITION_DESC) LIKE UPPER(?)";

	argumentArray[1]   = dataNameArray ;
 	argumentArray[2]   = dataValueArray ;
 	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "3,4";
	argumentArray[5]   = target.value ;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ;

  	retVal = await CommonLookup( "Position", argumentArray );

	if(retVal != null && retVal != "")
	{
	  code.value=retVal[0];
	  target.value=retVal[1];
	  document.getElementById("pract_role").innerHTML="<B>P</B>";
    }
}
var window_obj;
var multi_index;
function callClinicalNotes(note_type,patient_id,patient_class,encounterId,index){
		
		if(!checkRole())
			return false;
		note_type='AUDI';
		var accession_num = "";
		var accession_num_value	 = "";
		multi_index = index;//alert(multi_index);
		if(index == ''){
			accession_num = document.getElementById("accession_num");
			accession_num_value	 = document.getElementById("accession_num").value;
			document.getElementById("notes_btn").disabled = true;
		//	parent.proc_main_butn.document.getElementById("notes_btn").disabled = false;
			
		}else{
			accession_num = eval(document.getElementById("accession_num"+index));
			accession_num_value	 = eval(document.getElementById("accession_num"+index)).value;
		}
		var note_signed		 = '';
		
		if(document.body.offsetWidth > 1000){
			var dialogTop	 = "270";
			var dialogHeight = "445";
			var dialogWidth	 = "1010";
		}else{
			var dialogTop	 = "97";
			var dialogHeight = "445";
			var dialogWidth	 = "790";
		}
				
		var features = "top="+dialogTop+",height="+dialogHeight+",width="+dialogWidth+",status=no,left=0";
		var arguments = "Window_for_"+patient_id+index;
		var action_url	="../../eCA/jsp/RecClinicalNotesModal.jsp?title=Clinical Note&note_type="+note_type+"&patient_id="+patient_id+"&patient_class="+patient_class+"&episode_id="+encounterId+"&encounter_id="+encounterId+ "&Field_Ref="+accession_num+"&function_id=SPCL_NOTE&event_class=PHY$&accession_num="+accession_num_value+"&window_close=Y&note_signed="+ note_signed+"&appl_task_id=CLINICAL_NOTES&function_id=&window_close=Y";
		
 		//alert(window_obj);
		/*if(window_obj != null)
			window_obj.close();
		else*/
			window_obj = window.open(action_url,arguments,features);
		//alert(window_obj.name);
		ret_inter=setInterval('updateAccession();', 2500);
		//alert("ret_inter==="+ret_inter);
		
		
					
}
var ret_inter;
function updateAccession(){
	/*if(document.getElementById("accession_num").value != ""){
		alert("got the accession num..NT."+document.getElementById("accession_num").value+"=AN=");
		document.getElementById("notes_btn").disabled = true;
		clearInterval(ret_inter);
	
	}*/
	
	if(multi_index == ''){
		if(document.getElementById("accession_num").value != ""){
			alert("got the accession num..NT."+document.getElementById("accession_num").value+"=AN=");
			document.getElementById("notes_btn").disabled = true;
			parent.proc_main_butn.document.getElementById("record").disabled = false;
			clearInterval(ret_inter);
		}
		if(window_obj.closed){
			document.getElementById("notes_btn").disabled = false;
			parent.proc_main_butn.document.getElementById("record").disabled = false;
			clearInterval(ret_inter);
		}

	}else{
		
		
		if(eval(document.getElementById("accession_num"+multi_index)).value != ""){
			alert("got the accession num..NT."+eval(document.getElementById("accession_num"+multi_index)).value+"=AN=");
			clearInterval(ret_inter);
			window_obj.close();
		}
		//eval("document.getElementById("accession_num")"+multi_index)="ASD3453456734";
	}
	
}

function Record(){
	if(!checkRole())
		return false;
	var cnt = 0;
	if(parent.proc_main_result.document.multi_procedure)
		cnt = parent.proc_main_result.document.multi_procedure.totalRecords.value;
	//alert(cnt);
	var multi_proc_records="";
	for(var i =0;i<cnt;i++){
		//var nature = eval("parent.NewMultiProcedure.document.multi_procedure.nature"+i).value;
		var term_code = eval("parent.proc_main_result.document.multi_procedure.term_code"+i).value;
		var termdetails = eval("parent.proc_main_result.document.multi_procedure.termdetails"+i).value;
		var multi_proc_chk = "";
		if(eval("parent.proc_main_result.document.multi_procedure.multi_proc_chk"+i).checked)
			multi_proc_chk = "Y";
		else
			multi_proc_chk = "N";
		
		//multi_proc_records += nature+"~"+term_code+"~"+multi_session+"~"+onset_date+"~"+end_date+"~"+hrs+"~"+mins+"~"+multi_proc_chk+"|";
		multi_proc_records += term_code+"`"+termdetails+"`"+multi_proc_chk+"|";

	}
		var multi_session= "";
		var consent= "";
		if(parent.proc_main_search.document.RecDaignosis_form.multi_session.checked)
			multi_session = "Y";
		else
			multi_session = "N";

		if(parent.proc_main_search.document.RecDaignosis_form.consent.checked)
			consent = "Y";
		else
			consent = "N";
		
		var nature= parent.proc_main_search.document.RecDaignosis_form.nature.value;
		var priority= parent.proc_main_search.document.RecDaignosis_form.priority.value;
		var start_date= parent.proc_main_search.document.RecDaignosis_form.onset_date.value;
		var to_date= parent.proc_main_search.document.RecDaignosis_form.end_date.value;
		
		
		var anesthesia		 = parent.proc_main_desc.document.proc_outcome_form.anesthesia.value;
		alert(anesthesia);
		var anesthesia_det	 = parent.proc_main_desc.document.proc_outcome_form.anesthesia_det.value;
		var outcome			 = parent.proc_main_desc.document.proc_outcome_form.proc_outcome.value;
		var status			 = parent.proc_main_desc.document.proc_outcome_form.proc_status.value;
		var remarks			 = parent.proc_main_desc.document.proc_outcome_form.remarks.value;
		var reason			 = parent.proc_main_desc.document.proc_outcome_form.proc_reason.value;
		var accession_num	 = parent.proc_main_butn.document.getElementById("accession_num").value;
		
		parent.proc_main_label.document.multipract_form.multi_session.value	= multi_session;
		parent.proc_main_label.document.multipract_form.consent.value		= consent;

		parent.proc_main_label.document.multipract_form.consent.value		= multi_proc_records;

		parent.proc_main_label.document.multipract_form.nature.value		= nature;
		parent.proc_main_label.document.multipract_form.priority.value		= priority;
		parent.proc_main_label.document.multipract_form.start_dt.value		= start_date;
		parent.proc_main_label.document.multipract_form.end_dt.value		= to_date;

		parent.proc_main_label.document.multipract_form.anesthesia.value	= anesthesia;
		parent.proc_main_label.document.multipract_form.anesthesia_det.value= anesthesia_det;
		parent.proc_main_label.document.multipract_form.outcome.value		= outcome;
		parent.proc_main_label.document.multipract_form.status.value		= status;
		parent.proc_main_label.document.multipract_form.remarks.value		= remarks;
		parent.proc_main_label.document.multipract_form.reason.value		= reason;
		parent.proc_main_label.document.multipract_form.accession_num.value = accession_num;
		//multi_proc_records += anesthesia+"~"+med_team+"~"+indication+"||" ;
		//alert(parent.NewMultiPractProcedure.document.multipract_form.multi_proc_records.value );
		//alert(parent.NewMultiPractProcedure.document.multipract_form.totalRecords.value );
		parent.proc_main_label.document.multipract_form.action="../../servlet/eOR.NewProceduresServlet";
		parent.proc_main_label.document.multipract_form.submit();
		
}
function Cancel()
{
	/*top.content.workAreaFrame.RecDiagnosisMain.RecDiagnosisCurrentDiag.location.href ='../../eCommon/html/blank.html';
	top.content.workAreaFrame.RecDiagnosisMain.RecDiagnosisCurrentDiagLegend.location.href ='../../eCommon/html/blank.html';
	top.content.workAreaFrame.RecDiagnosisMain.RecDiagnosisAddModify.location.href ='../../eCommon/html/blank.html';
	top.content.workAreaFrame.RecDiagnosisMain.RecDiagnosisOpernToolbar.location.href ='../../eCommon/html/blank.html';
	top.content.workAreaFrame.RecDiagnosisMain.messageFrame.location.href ='../../eCommon/html/blank.html';*/
	//top.content.workAreaFrame.location.href='../../eCommon/html/blank.html';
	top.content.workAreaFrame.location.reload();
	//top.content.workAreaFrame.RecDiagnosisFrame.location.href='../../eCommon/html/blank.html';
	
}
function clearform()
{
	/*if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.mode.value == "modify")
	{
		var Practitioner_Id = parent.NewProcedure.document.RecDaignosis_form.Practitioner_Id.value;
		var relationship_id= parent.NewProcedure.document.RecDaignosis_form.relationship_id.value;
		var Locn_Code = parent.NewProcedure.document.RecDaignosis_form.Locn_Code.value;
		var Locn_Type = parent.NewProcedure.document.RecDaignosis_form.Locn_Type.value;
		var Patient_Id = parent.NewProcedure.document.RecDaignosis_form.Patient_Id.value;
		var patient_class = parent.NewProcedure.document.RecDaignosis_form.patient_class.value;
		var Encounter_Id = parent.NewProcedure.document.RecDaignosis_form.Encounter_Id.value;
		var dob= parent.NewProcedure.document.RecDaignosis_form.dob.value;
		var sex = parent.NewProcedure.document.RecDaignosis_form.sex.value;
		var age = parent.NewProcedure.document.RecDaignosis_form.age.value;
		var modal_yn = parent.NewProcedure.document.RecDaignosis_form.modal_yn.value;

		parent.RecDiagnosisAddModify.location.href ="../../eMR/jsp/RecDiagnosisAddModify.jsp?Practitioner_Id="+Practitioner_Id+"&relationship_id="+relationship_id+"&Locn_Code="+Locn_Code+"&Locn_Type="+Locn_Type+"&Patient_Id="+Patient_Id+"&patient_class="+patient_class+"&Encounter_Id="+Encounter_Id+"&Dob="+dob+"&Age="+age+"&Sex="+sex+"&modal_yn="+modal_yn;
	}	
	else
	{
		parent.RecDiagnosisAddModify.document.RecDaignosis_form.reset();
	}
	//top.content.workAreaFrame.location.reload();
	parent.NewProcedure.document.location.reload();
	//parent.NewMultiProcedure.document.multi_procedure.reset();
	parent.NewMultiProcedure.document.location.reload();
	parent.NewMultiPractProcedure.document.multipract_form.reset();
	parent.NewMultiPractProcedure.document.getElementById("pract_val").innerHTML = "&nbsp";
*/
	parent.proc_main_search.document.location.reload();
	parent.proc_main_result.document.location.href = "../../eCommon/html/blank.html";
	parent.proc_term_info.document.location.href = "../../eCommon/html/blank.html";
	parent.proc_main_label.document.location.reload();
	parent.proc_main_desc.document.location.reload();
	parent.proc_main_butn.document.getElementById("notes_btn").disabled = false;
	parent.proc_main_butn.document.getElementById("record").disabled = true;
	
}

function checkValidDateTime(obj){
	if(obj.value!='')
	{
			if(!doDateTimeChk(obj))
	    	{
	    		alert(getMessage("INVALID_DATE_TIME"));
	    		obj.focus();
	    		obj.select();
				return false;
	    	}else
				return true;
    }else
		return true;
}
function CheckPositiveNumber(obj) {
   var sequence = "0123456789";
   var obj_value = obj;
   var obj_length = obj_value.length;
   
   for (i=0; i<obj_length; i++)   {
        if(sequence.indexOf(obj_value.charAt(i))==-1){
			alert(getMessage("ONLY_POSITIVE_NUM"));
			return false;
		}
   }
   return true;
}
function calEndDate(index){
//alert(index);
//	var start_date	=	"21/04/2005 18:00";
	var frmObj ="";
	if(index != "" )
		frmObj = document.multi_procedure;
	else
		frmObj = document.RecDaignosis_form;
	var start_date	=	eval("frmObj.onset_date"+index).value;
//	var mins_add = 10; // specify the duration here
//	var hrs_add = 10; // specify the duration here
	
	var hrs_add = eval("frmObj.hrs"+index).value; // specify the duration here
	var mins_add = eval("frmObj.mins"+index).value; // specify the duration here
	
	if(hrs_add != "" && !CheckPositiveNumber(hrs_add)){
		eval("frmObj.hrs"+index).value = "";
		eval("frmObj.hrs"+index).focus();
		return false;
	}
	if(mins_add != "" && !CheckPositiveNumber(mins_add)){
		eval("frmObj.mins"+index).value = "";
		eval("frmObj.mins"+index).focus();
		return false;
	}

	if(hrs_add == '')
		hrs_add = 0;
	if(mins_add == '')
		mins_add = 0;
	var fromarray;
	var fromDt;
	var timarray;
	var finalDt="";
	var durnUnit;

	if(start_date.length > 0 )
	{
		fromDt = start_date.split(" ");
		fromarray = fromDt[0].split("/");
		timarray = fromDt[1].split(":");
	
	
		var dt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
		dt.setHours(timarray[0], timarray[1]);
		
		if(timarray[0] !=  ''){//hours
			timarray[0]=dt.getHours()+parseInt(hrs_add);
			//dt.setHours(timarray[0], timarray[1]);
		}
		if(timarray[1] !=  ''){//Minutes
			timarray[1]=dt.getMinutes()+parseInt(mins_add);
			//dt.setHours(timarray[0], timarray[1]);
		}
		dt.setHours(timarray[0], timarray[1]);

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
		//alert("finalDt::::"+finalDt);
		eval("frmObj.end_date"+index).value = finalDt;
	}
}
function doDateCheck(from,to) {
    var fromarray; var toarray;
    var fromdate = from.value ;
    var todate   = to.value ;
    if(fromdate.length > 0 && todate.length > 0 ) {
            fromarray = fromdate.split("/");
            toarray = todate.split("/");
            var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
            var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
            if(Date.parse(todt) < Date.parse(fromdt))
               return 1 ;
            else if(Date.parse(todt) > Date.parse(fromdt))
			  return  -1 ;
			else if(Date.parse(todt) == Date.parse(fromdt))
			 return  0 ;

   }

} //End of function

function CalculateDuration(index){


var frmObj ="";
if(index != "" )
	frmObj = document.multi_procedure;
else
	frmObj = document.RecDaignosis_form;
//var start_date	=	"18/10/2005 18:06";
var start_date	=	eval("frmObj.onset_date"+index).value;
//var target_date	=	"18/10/2005 19:06";
var target_date	=	eval("frmObj.end_date"+index).value;
if(checkValidDateTime(eval("frmObj.end_date"+index))){ //  this method is from ValidateControl.js
		if(doDatetimeCheckAlert(start_date,target_date)) {
			alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
			eval("frmObj.end_date"+index).value='';
			eval("frmObj.end_date"+index).focus();
			return false;
		}
}

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

hours = Math.floor(timediff / (1000 * 60 * 60)); 
timediff -= hours * (1000 * 60 * 60);

mins = Math.floor(timediff / (1000 * 60)); 

eval("frmObj.hrs"+index).value = hours; 
eval("frmObj.mins"+index).value = mins;

}

}
function showReason(obj){

	if(obj.value ==""){
		document.getElementById("tr_remarks").style.display="none";
		document.getElementById("tr_reason").style.display="none";
		return false;
	}
	if(obj.value == "I" || obj.value == "IC"){
		document.getElementById("tr_reason").style.display="inline";
		document.getElementById("td_reason").style.visibility="visible";
		document.getElementById("td_reason_legend").style.visibility="visible";
		document.proc_outcome_form.proc_reason.style.display="inline";
		document.getElementById("tr_remarks").style.display="none";
		if(obj.value == "I")
			document.proc_outcome_form.man_reason.style.visibility="visible";
		else
			document.proc_outcome_form.man_reason.style.visibility="hidden";
	}else{
		document.getElementById("tr_remarks").style.display="inline";
		document.getElementById("tr_reason").style.display="none";
		document.getElementById("td_reason").style.visibility="hidden";
		document.getElementById("td_reason_legend").style.visibility="hidden";
		document.proc_outcome_form.proc_reason.style.display="none";
		document.proc_outcome_form.man_reason.style.visibility="hidden";
	}

}
function showTermDetails(index){
		var termdetails = eval("document.multi_procedure.termdetails"+index).value;
		var mode =1;
		if(parent.proc_term_info.document.multi_procedure){
			
			var ind = parent.proc_term_info.document.multi_procedure.index.value;
			var start_date = parent.proc_term_info.document.multi_procedure.onset_date0.value;
			var hrs = parent.proc_term_info.document.multi_procedure.hrs0.value;
			var mins = parent.proc_term_info.document.multi_procedure.mins0.value;
			var end_date = parent.proc_term_info.document.multi_procedure.end_date0.value;
			if(start_date =="")
				start_date = " ";
			if(hrs =="")
				hrs = " ";
			if(mins =="")
				mins = " ";
			if(end_date =="")
				end_date = " ";
			
			var tmp_term_details= start_date+"~"+hrs+"~"+mins+"~"+end_date+"~";
			eval("document.multi_procedure.termdetails"+ind).value = tmp_term_details;
		}
		if(termdetails !=""){
			parent.proc_term_info.location.href="../../eOR/jsp/NewProcedureAddModifyMultiDetails.jsp?mode="+mode+"&termdetails="+termdetails+"&index="+index;

		}else{
			parent.proc_term_info.location.href="../../eOR/jsp/NewProcedureAddModifyMultiDetails.jsp?mode="+mode+"&termdetails=&index="+index;
		}

}
function showNature(obj){
	if(obj.value=="")
		document.RecDaignosis_form.nature_btn.style.visibility="hidden";
	else
		document.RecDaignosis_form.nature_btn.style.visibility="visible";

}


