//This file is saved on 18/10/2005


var goal_flag = false;
var result = false;
var validDictionary	=new Map();
var validDiagnosis	=new Map();
var lib_term_code_arr = new Array();

async function show_caremanager_window( target )
{
	var argumentArray  = new Array() ; 
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var pract_desc	   = document.care_planmanager.pract_desc.value;
	argumentArray[0]   = parent.frames[0].document.care_planmanager.caremanager_sql.value;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = target.value ;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ;
	//if(target.value == ""){
		retVal = await CommonLookup( getLabel("eCP.CareManager.label","CP"), argumentArray );
		var str =unescape(retVal);
		var arr = str.split(",");
		if(retVal != null && retVal != ""){
			
			target.value = arr[1];
			parent.frames[0].document.care_planmanager.gpcaremanager.value=arr[0];
		}
		else 
		{			
			if(pract_desc!="")
			{
				target.value = pract_desc;
			}
			else
			{
				target.value = "";
				target.focus();
			}
		}
	//}
}

function populateLibrary(index){
	var frmObj =  parent.parent.GeneratePlanType.GeneratePlanTypeTop ;

	var casetype_code="";
	var casetype_desc= eval("parent.GeneratePlanProfileType.document.generate_case_type.casetype_desc"+index).value
	var i= parent.GeneratePlanProfileType.document.generate_case_type.i.value;
	for(var tmp=0;tmp<i;tmp++)
	{
		if(eval("parent.GeneratePlanProfileType.document.generate_case_type.chk_casetype"+tmp).checked == true){
			casetype_code += eval("parent.GeneratePlanProfileType.document.generate_case_type.casetype_code"+tmp).value+"~";
		}
	}
	
	var patient_id= parent.GeneratePlanProfileType.document.generate_case_type.patient_id.value
	var finalString = parent.GeneratePlanProfileType.document.generate_case_type.finalStr.value;
	finalString += "&patient_id="+patient_id+"&casetype_code="+casetype_code
		
	var HtmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'><script></script></head><body class=MESSAGE><form name='tempform' id='tempform' method='post' action='GCPGenerateCarePlanIntermediate.jsp'><input type=hidden name='casetype_code' id='casetype_code' value='"+casetype_code+"'><input type=hidden name='textName' id='textName' value='case_type_code'></form></body></html>";
	parent.parent.TempFrame.document.write(HtmlVal);
	parent.parent.TempFrame.document.tempform.submit();

	//if (top.content) {
		//top.content.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	//}
}
/*******************************************************************/
// This code is to validate the dependent diagnosis for the selected case types.....
function callDisable(){

	if(parent.GeneratePlanProfileDiagnosis.tmp_termset_id.length>0){
		for(var cnt=0;cnt<parent.GeneratePlanProfileDiagnosis.document.generate_diagnosis.i.value;cnt++){
			eval("parent.GeneratePlanProfileDiagnosis.document.generate_diagnosis.chk_diag"+cnt).disabled = false;
			eval("parent.GeneratePlanProfileDiagnosis.document.generate_diagnosis.chk_diag"+cnt).checked = false;
		}
		
		if(parent.GeneratePlanProfileDiagnosis.xx == 0)
			parent.GeneratePlanProfileDiagnosis.tmp_count =new Array();
		if(parent.GeneratePlanProfileDiagnosis.tmp_count.length>0){
		for(var cnt=0;cnt<parent.GeneratePlanProfileDiagnosis.tmp_count.length;cnt++){
			var z=0;
			z= parent.GeneratePlanProfileDiagnosis.tmp_count[cnt];
			eval("parent.GeneratePlanProfileDiagnosis.document.generate_diagnosis.chk_diag"+z).checked = true;

		}
	}
	for(var x=0;x<parent.GeneratePlanProfileDiagnosis.tmp_termset_id.length;x++)
	{	
		for(var t=0;t<parent.GeneratePlanProfileDiagnosis.termset_id_arr.length;t++){
		
			var tmp_termset_id = parent.GeneratePlanProfileDiagnosis.tmp_termset_id[x];
			var tmp_term_code = parent.GeneratePlanProfileDiagnosis.tmp_term_code[x];
			var tmp_man_yn = parent.GeneratePlanProfileDiagnosis.tmp_man_yn[x];

			var termset_id_arr = parent.GeneratePlanProfileDiagnosis.termset_id_arr[t];
			var term_code_arr = parent.GeneratePlanProfileDiagnosis.term_code_arr[t];


			if( tmp_termset_id == termset_id_arr && tmp_term_code == term_code_arr){

				if(tmp_man_yn == "Y"){
					eval("parent.GeneratePlanProfileDiagnosis.document.generate_diagnosis.chk_diag"+t).checked = true;
					eval("parent.GeneratePlanProfileDiagnosis.document.generate_diagnosis.chk_diag"+t).disabled = true;

				}else{
					eval("parent.GeneratePlanProfileDiagnosis.document.generate_diagnosis.chk_diag"+t).checked = true;

				}
			}
		}
	}
	}else{
		for(var cnt=0;cnt<parent.GeneratePlanProfileDiagnosis.document.generate_diagnosis.i.value;cnt++){
			eval("parent.GeneratePlanProfileDiagnosis.document.generate_diagnosis.chk_diag"+cnt).disabled = false;
			eval("parent.GeneratePlanProfileDiagnosis.document.generate_diagnosis.chk_diag"+cnt).checked = false;
		}
		if(parent.GeneratePlanProfileDiagnosis.tmp_count.length>0){
			for(var cnt=0;cnt<parent.GeneratePlanProfileDiagnosis.tmp_count.length;cnt++){
				var z=0;
				z= parent.GeneratePlanProfileDiagnosis.tmp_count[cnt];
				eval("parent.GeneratePlanProfileDiagnosis.document.generate_diagnosis.chk_diag"+z).checked = true;
			}
		}
	}
}

async function callDiable1(index){

	//if (top.content) {
			//top.content.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	//}

	var casetype_value = "";
	var casetype_code = eval("parent.GeneratePlanProfileType.document.generate_case_type.casetype_code"+index).value;
	var ind = eval(index)+1;
	var validcheck= eval("parent.GeneratePlanProfileType.document.generate_case_type.validDiagCode"+ind).value;
	if(eval("parent.GeneratePlanProfileType.document.generate_case_type.chk_casetype"+index).checked){
		if (!validDictionary.has(casetype_code)){
			validDictionary.set(casetype_code, validcheck);
		}
		casetype_value = "Y";
	}else{
		if (validDictionary.has(casetype_code)){
			validDictionary.delete(casetype_code);
		}
		casetype_value = "N";
	}
	var selected_diags="";
	selected_diags=((validDictionary.values()).toArray()).toString();

	var tmp_id=new Array();
	var tmp_code=new Array();
	var tmp_manyn=new Array();
	if(selected_diags !=""){
		var valid_val		=	"";
		var hiddenValidArray=new Array();
		var hiddenValidArray1=new Array();
		hiddenValidArray1	= selected_diags.split(",");

		selected_diags="";
		for(var h=0; h<(hiddenValidArray1.length); h++){
			selected_diags +=hiddenValidArray1[h];
		}

		hiddenValidArray	= selected_diags.split("|");
		var validLen=Math.abs(hiddenValidArray.length) ;
		for(var j=0; j<(validLen-1); j++){
			valid_val	=	hiddenValidArray[j];
			var set_vals = new Array();
			set_vals = valid_val.split("*");
			tmp_id[j] =set_vals[0];
			tmp_code[j] = set_vals[1];
			tmp_manyn[j] = set_vals[2];
		}
	}

	parent.GeneratePlanProfileDiagnosis.tmp_termset_id = tmp_id;
	parent.GeneratePlanProfileDiagnosis.tmp_term_code = tmp_code;
	parent.GeneratePlanProfileDiagnosis.tmp_man_yn = tmp_manyn;

	await callDisable();

	var HtmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'><script></script></head><body class=MESSAGE><form name='tempform' id='tempform' method='post' action='GCPGenerateCarePlanIntermediate.jsp'><input type=hidden name='casetype_code' id='casetype_code' value='"+casetype_code+"'><input type=hidden name='casetype_value' id='casetype_value' value='"+casetype_value+"'><input type=hidden name='textName' id='textName' value='case_type_code'></form></body></html>";
		
	parent.parent.TempFrame.document.write(HtmlVal);
	parent.parent.TempFrame.document.tempform.submit();

}

function showLibrary(obj){
	var show_diag="";
	show_diag = obj;
	
	var frmProfObj = parent.parent.GeneratePlanProfile.GeneratePlanProfileDiagnosis
	var i =frmProfObj .document.generate_diagnosis.i.value;
	
	var termset_id="",term_code="",limit_lib="";
	var sel_diags="";
	var encounterId=""; //60772
	var diag_flag=false;
	
	for(var tmp=0;tmp<i;tmp++){
		if(eval("frmProfObj.document.generate_diagnosis.chk_diag"+tmp).checked == true){
			diag_flag=true;
			sel_diags += "(~"+eval("frmProfObj.document.generate_diagnosis.termset_id"+tmp).value+"~,~"+eval("frmProfObj.document.generate_diagnosis.term_code"+tmp).value+"~),";
			termset_id += eval("frmProfObj.document.generate_diagnosis.termset_id"+tmp).value+",";
			term_code += eval("frmProfObj.document.generate_diagnosis.term_code"+tmp).value+",";
			encounterId += eval("frmProfObj.document.generate_diagnosis.encounterId"+tmp).value+","; //60772
		}
	}
	var case_type_frmObj=parent.parent.GeneratePlanProfile.GeneratePlanProfileType.document.generate_case_type;
	var case_type_count =case_type_frmObj.i.value;
	var case_type_flag=false;
	for(var j=0;j<case_type_count;j++){
		if(eval("case_type_frmObj.chk_casetype"+j).checked == true){
			case_type_flag=true;
			break;
		}
	}
	if(!(diag_flag || case_type_flag)){
		alert(getMessage("ATLEAST_ONE_SELECTED","Common"));
		return false;
	}
	
	var HtmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'><script></script></head><body class=MESSAGE><form name='tempform' id='tempform' method='post' action='GCPGenerateCarePlanIntermediate.jsp'><input type=hidden name='termset_id' id='termset_id' value='"+termset_id+"'><input type=hidden name='term_code' id='term_code' value='"+term_code+"'><input type=hidden name='sel_diags' id='sel_diags' value='"+sel_diags+"'><input type=hidden name='encounterId' id='encounterId' value='"+encounterId+"'><input type=hidden name='textName' id='textName' value='setLimited_lib'></form></body></html>";
	parent.parent.TempFrame.document.write(HtmlVal);
	parent.parent.TempFrame.document.tempform.submit();

	var finalString = parent.parent.GeneratePlanProfile.GeneratePlanProfileType.document.generate_case_type.finalStr.value;
	
	//parent.parent.document.getElementById("gpParentFrame").rows="0%,0%,*,0%";
	parent.parent.document.getElementById("GeneratePlanManager").style.height="0vh";
	parent.parent.document.getElementById("GeneratePlanProfile").style.height="0vh";
	parent.parent.document.getElementById("GeneratePlanType").style.height="100vh";
	parent.parent.document.getElementById("TempFrame").style.height="0vh";
	
	//parent.document.getElementById("planFrame").rows='0%,70%,0%,0%,4%,0%';
	parent.document.getElementById("GeneratePlanTypeShowBtn").style.height="0vh";
	parent.document.getElementById("GeneratePlanTypeTop").style="display";
	parent.document.getElementById("GeneratePlanTypeTop").style.height="70vh";
	parent.document.getElementById("GeneratePlanTypeTop").style.width="98vw";
	parent.document.getElementById("GeneratePlanTypeBottom").style.height="0vh";
	parent.document.getElementById("GeneratePlanDetail").style.height="0vh";
	parent.document.getElementById("GeneratePlanTypeBtn").style="display";
	parent.document.getElementById("GeneratePlanTypeLinks").style.height="0vh";
	parent.document.getElementById("GeneratePlanTypeShowBtn").style.width="98vw";
	parent.document.getElementById("GeneratePlanTypeTop").style.width="98vw";
	parent.document.getElementById("GeneratePlanTypeBottom").style.width="98vw";
	parent.document.getElementById("GeneratePlanDetail").style.width="98vw";
	parent.document.getElementById("GeneratePlanTypeBtn").style.height="4vh";
	parent.document.getElementById("GeneratePlanTypeBtn").style.width="98vw";
	parent.document.getElementById("GeneratePlanTypeLinks").style.width="98vw";
	//parent.document.getElementById("GeneratePlanTypeShowBtn").style="display";
	//parent.document.getElementById("GeneratePlanTypeBottom").style="display";
	//parent.document.getElementById("GeneratePlanDetail").style="display";
	//parent.document.getElementById("GeneratePlanTypeLinks").style="display";
	//parent.parent.GeneratePlanType.GeneratePlanTypeTop.location.href="../../eCP/jsp/GCPGeneratePlanTypeTop.jsp?&finalString="+finalString+"&show_diag="+show_diag+"&Library=EntireLibrary";
	parent.parent.GeneratePlanType.GeneratePlanTypeTop.location.href="../../eCP/jsp/GCPGeneratePlanTypeTop.jsp?&finalString="+finalString+"&show_diag="+show_diag+"&encounterId="+encounterId+"&Library=EntireLibrary";  //60772
	parent.GeneratePlanTypeBtn.location.href="../../eCP/jsp/GCPGeneratePlanTypeBtn.jsp?&preview=true";	
	//if (top.content) {
		//top.content.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	//}
}

function LibClear(){
	parent.parent.GeneratePlanProfile.GeneratePlanProfileDiagnosis.xx=0;
	
	var frmObj =  parent.parent.GeneratePlanType.GeneratePlanTypeTop ;
	parent.parent.GeneratePlanProfile.GeneratePlanProfileDiagnosis.document.generate_diagnosis.reset();
	parent.parent.GeneratePlanProfile.GeneratePlanProfileType.document.generate_case_type.reset();
	for(var cnt=0;cnt<parent.parent.GeneratePlanProfile.GeneratePlanProfileDiagnosis.document.generate_diagnosis.i.value;cnt++){
		eval("parent.parent.GeneratePlanProfile.GeneratePlanProfileDiagnosis.document.generate_diagnosis.chk_diag"+cnt).disabled = false;
	}
}

function populateLibrary1(index){
	//if (top.content) {
		//top.content.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	//}

	var frmObj =  parent.parent.GeneratePlanType.GeneratePlanTypeTop ;
	var termset_id =eval("parent.GeneratePlanProfileDiagnosis.document.generate_diagnosis.termset_id"+index).value
	var diag_code= eval("parent.GeneratePlanProfileDiagnosis.document.generate_diagnosis.term_code"+index).value
	var diag_desc= eval("parent.GeneratePlanProfileDiagnosis.document.generate_diagnosis.term_code_desc"+index).value
	if(eval("parent.GeneratePlanProfileDiagnosis.document.generate_diagnosis.chk_diag"+index).checked == true){
		var xy= parent.GeneratePlanProfileDiagnosis.xx;
		parent.GeneratePlanProfileDiagnosis.tmp_count[xy]=index;
		parent.GeneratePlanProfileDiagnosis.xx = ++xy;
	}else{
		var HtmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'><script></script></head><body class=MESSAGE><form name='tempform' id='tempform' method='post' action='GCPGenerateCarePlanIntermediate.jsp'><input type=hidden name='diag_code' id='diag_code' value='"+diag_code+"'><input type=hidden name='textName' id='textName' value='setDiagCode'></form></body></html>";
			
		parent.parent.TempFrame.document.write(HtmlVal);
		parent.parent.TempFrame.document.tempform.submit();
		parent.parent.GeneratePlanType.GeneratePlanTypeTop.location.reload();
	}
	for(var ttp=0;ttp<parent.GeneratePlanProfileDiagnosis.xx;ttp++){
		if(index == parent.GeneratePlanProfileDiagnosis.tmp_count[ttp])
		{	
			if(eval("parent.GeneratePlanProfileDiagnosis.document.generate_diagnosis.chk_diag"+index).checked == false){
					parent.GeneratePlanProfileDiagnosis.tmp_count[ttp] = "";
			}
		}
	}
}

function populateLibDetails(index){
	var frmObj =  parent.parent.GeneratePlanType.GeneratePlanTypeTop ;
	var casetype_code =	eval("frmObj.document.generate_libraires.casetype_code"+index).value; 
	var casetype_value="";
	
	var case_flag = false;
	var	value_str = "";var selected_value = "";
	var lib_id = "";var term_set_id = "",term_code="";
	var version_no = "";
	lib_id = eval("frmObj.document.generate_libraires.library_code"+index).value;
	version_no =eval("frmObj.document.generate_libraires.version_no"+index).value;
	term_set_id = eval("frmObj.document.generate_libraires.term_set_id"+index).value; 
	term_code =	eval("frmObj.document.generate_libraires.term_code"+index).value;
	casetype_code = lib_id+"~"+version_no+"~"+casetype_code;	
	lib_term_code_arr = term_code.split("|");
	var selcted_diags="";
	var sel_diag=new Array();
	var ind="";var tmp_ind ="";
	
	if (lib_term_code_arr.length > 1)
	{
		cnt=eval(lib_term_code_arr.length-1);
	}else
		cnt=lib_term_code_arr.length;
	
	for(var i=0;i<cnt;i++){
		if(eval("frmObj.document.generate_libraires.chk_library"+index).checked == true){
			if (!validDiagnosis.has(lib_term_code_arr[i])){
				validDiagnosis.set(lib_term_code_arr[i], index);
			}else{
				ind = validDiagnosis.get(lib_term_code_arr[i])
				selected_diags=Array.from(validDiagnosis.Keys()).toString();;
				sel_diag = selected_diags.split(",")
				for(var tmp=0;tmp<sel_diag.length;tmp++){
					tmp_ind=validDiagnosis.get(sel_diag[tmp])
					if(ind == tmp_ind){
						validDiagnosis.delete(sel_diag[tmp]);
					}
				}
				for(var i=0;i<cnt;i++){
					validDiagnosis.set(lib_term_code_arr[i], index);
				}
				case_flag = true;
				break;
			}
		}else{
			validDiagnosis.delete(lib_term_code_arr[i]);
		}
	}
	var remove_lib="";var case_code="";
	if(case_flag == true){
		eval("frmObj.document.generate_libraires.chk_library"+ind).checked = false;
		lib = eval("frmObj.document.generate_libraires.library_code"+ind).value;
		vers =eval("frmObj.document.generate_libraires.version_no"+ind).value;
		
		remove_lib = lib+"~"+vers;
		case_code = eval("frmObj.document.generate_libraires.casetype_code"+ind).value;
		case_code = remove_lib+"~"+case_code;
	}
	if(term_set_id == ""){
		term_set_id = " ";
		term_code = " ";
	}
	value_str += lib_id+","+version_no+","+term_set_id+","+term_code+"~";
	if(eval("frmObj.document.generate_libraires.chk_library"+index).checked == true){
		casetype_value = "Y";
		selected_value = "Y";
	}else{
		casetype_value = "N";
		selected_value = "N";
	}
	var HtmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'><script></script></head><body class=MESSAGE><form name='tempform' id='tempform' method='post' action='GCPGenerateCarePlanIntermediate.jsp'><input type=hidden name='case_code' id='case_code' value='"+casetype_code+"'><input type=hidden name='casetype_value' id='casetype_value' value='"+casetype_value+"'><input type=hidden name='selected_lib' id='selected_lib' value='"+value_str+"'><input type=hidden name='selected_value' id='selected_value' value='"+selected_value+"'><input type=hidden name='remove_lib' id='remove_lib' value='"+remove_lib+"'><input type=hidden name='case_cd' id='case_cd' value='"+case_code+"'><input type=hidden name='textName' id='textName' value='setcase_status'></form></body></html>";
		
	parent.parent.TempFrame.document.write(HtmlVal);
	parent.parent.TempFrame.document.tempform.submit();
}

function checkExistingDiags(){
	var frmObj =  parent.parent.GeneratePlanType.GeneratePlanTypeTop ;
	var term_set_id = "";
	var term_code = "";var count=0;
	var cnt = frmObj.document.generate_libraires.i.value; 
	for(var i=0;i<cnt;i++){
		if(eval("frmObj.document.generate_libraires.chk_library"+i).checked == true){
			 term_set_id =	eval("frmObj.document.generate_libraires.term_set_id"+i).value; 
			 term_code = eval("frmObj.document.generate_libraires.term_code"+i).value; 
			 lib_term_code_arr = term_code.split("|");
			 if (lib_term_code_arr.length > 1)
				count=eval(lib_term_code_arr.length-1);
			 else
				count=lib_term_code_arr.length;
			 for(var j=0;j<count;j++){
				if (!validDiagnosis.Exists(lib_term_code_arr[j])){
					validDiagnosis.add(lib_term_code_arr[j], i);}	
			}
		}
	}
}
function populateLibDetails1(index){
	var frmObj =  parent.parent.GeneratePlanType.GeneratePlanTypeTop ;
	
	var term_set_id =	eval("frmObj.document.generate_libraires.term_set_id"+index).value; 
	var term_code = eval("frmObj.document.generate_libraires.term_code"+index).value; 
	var term_flag = false ;var cnt="";var ind="",tmp_ind="";
	var selcted_diags="";
	var sel_diag=new Array();
	lib_term_code_arr = term_code.split("|");
	if (lib_term_code_arr.length > 1)
	{
		cnt=eval(lib_term_code_arr.length-1);
	}else
		cnt=lib_term_code_arr.length;
	
	for(var i=0;i<cnt;i++){
		if(eval("frmObj.document.generate_libraires.chk_library"+index).checked == true){
			if (!validDiagnosis.has(lib_term_code_arr[i])){
				validDiagnosis.set(lib_term_code_arr[i], index);
			}else{
				ind = validDiagnosis.get(lib_term_code_arr[i])
				selected_diags=Array.from(validDiagnosis.Keys()).toString();;
				sel_diag = selected_diags.split(",")
				for(var tmp=0;tmp<sel_diag.length;tmp++){
					tmp_ind=validDiagnosis.get(sel_diag[tmp])
					if(ind == tmp_ind){
						validDiagnosis.delete(sel_diag[tmp]);
					}
				}
				for(var i=0;i<cnt;i++){
					validDiagnosis.set(lib_term_code_arr[i], index);
				}
				term_flag = true;
				break;
			}
		}else{
			validDiagnosis.delete(lib_term_code_arr[i]);
		}
	}
	var lib="",vers="";var remove_lib="";var case_code="";
	if(term_flag == true){
		eval("frmObj.document.generate_libraires.chk_library"+ind).checked = false;
		lib = eval("frmObj.document.generate_libraires.library_code"+ind).value;
		vers =eval("frmObj.document.generate_libraires.version_no"+ind).value;
		case_code = eval("frmObj.document.generate_libraires.casetype_code"+ind).value;
		remove_lib = lib+"~"+vers;
		case_code = remove_lib+"~"+case_code;
	}

	var termcode_value="";	
	var	value_str = "";
	var selected_value = "";
	var term_cd_value="";
	var lib_id = "";
	var version_no = "";
	var i = frmObj.document.generate_libraires.i.value;
	
	lib_id = eval("frmObj.document.generate_libraires.library_code"+index).value;
	version_no =eval("frmObj.document.generate_libraires.version_no"+index).value;
	if(term_set_id == ""){
		term_set_id = " ";
		term_code = " ";
	}
	value_str += lib_id+","+version_no+","+term_set_id+","+term_code+"~";
	
	if(eval("frmObj.document.generate_libraires.chk_library"+index).checked == true){
		termcode_value = "Y";
		selected_value = "Y";
	}else{
		termcode_value = "N";
		selected_value = "N";
	}
	term_cd_value = lib_id+"~"+version_no+"~"+term_set_id+"~"+term_code+"~";
	term_code =term_set_id+"~"+term_code+"~";

	var HtmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'><script></script></head><body class=MESSAGE><form name='tempform' id='tempform' method='post' action='GCPGenerateCarePlanIntermediate.jsp'><input type=hidden name='term_code' id='term_code' value='"+term_code+"'><input type=hidden name='termcode_value' id='termcode_value' value='"+termcode_value+"'><input type=hidden name='term_cd_value' id='term_cd_value' value='"+term_cd_value+"'><input type=hidden name='selected_lib' id='selected_lib' value='"+value_str+"'><input type=hidden name='selected_value' id='selected_value' value='"+selected_value+"'><input type=hidden name='remove_lib' id='remove_lib' value='"+remove_lib+"'><input type=hidden name='case_code' id='case_code' value='"+case_code+"'><input type=hidden name='textName' id='textName' value='setterm_code'></form></body></html>";
		
	parent.parent.TempFrame.document.write(HtmlVal);
	parent.parent.TempFrame.document.tempform.submit();
}

function chkValid(index){
	var frmObjBottom =  parent.parent.GeneratePlanType.GeneratePlanTypeBottom ;
	
	var inter_cnt=eval("frmObjBottom.document.generate_summary.inter_cnt"+index).value;
	var outcome_cnt=eval("frmObjBottom.document.generate_summary.outcome_cnt"+index).value;

	var library_id="",version_no="",term_set_id= "",term_code= "",intervention_code="",outcome_code="",goal_code="", target_date="" ;
	var tmp_intervention_code="",tmp_outcome_code="",selected_diag_val="",group_id="";
	var selected_diag="";

	library_id = eval("frmObjBottom.document.generate_summary.library_id"+index).value;
	version_no = eval("frmObjBottom.document.generate_summary.version_no"+index).value;
	term_set_id = eval("frmObjBottom.document.generate_summary.term_set_id"+index).value;
	term_code = eval("frmObjBottom.document.generate_summary.term_code"+index).value;
	goal = eval("frmObjBottom.document.generate_summary.goal"+index).value;
	target_date = eval("frmObjBottom.document.generate_summary.dtarget_date"+index).value;

	if(eval("frmObjBottom.document.generate_summary.chk_goal"+index).checked == true){	
		for(var tmp=0;tmp<inter_cnt;tmp++){	
			eval("frmObjBottom.document.generate_summary.chk_inter"+tmp+index).checked = true;
			tmp_intervention_code = eval("frmObjBottom.document.generate_summary.inter_code"+tmp+index).value;
			group_id = eval("frmObjBottom.document.generate_summary.int_group_id"+tmp+index).value;
			intervention_code += tmp_intervention_code +"*"+group_id+"|";
			
		}
		for(var tmp=0;tmp<outcome_cnt;tmp++){	
			eval("frmObjBottom.document.generate_summary.chk_outcome"+tmp+index).checked = true;
			tmp_outcome_code = eval("frmObjBottom.document.generate_summary.outcome_code"+tmp+index).value;
			group_id = eval("frmObjBottom.document.generate_summary.out_group_id"+tmp+index).value;
			outcome_code += tmp_outcome_code+"*"+group_id+"|";
		}
		if(intervention_code == "")
			intervention_code = " *";
		if(outcome_code == "")
			outcome_code = " *";

		selected_diag_val	= target_date+","+intervention_code+","+outcome_code+"~";
	}
	else{
		for(var tmp=0;tmp<inter_cnt;tmp++){	
			eval("frmObjBottom.document.generate_summary.chk_inter"+tmp+index).checked = false;
		}
		for(var tmp=0;tmp<outcome_cnt;tmp++){	
			eval("frmObjBottom.document.generate_summary.chk_outcome"+tmp+index).checked = false;
		}
		
	}
	selected_diag =  library_id+","+version_no+","+term_set_id+","+term_code+","+goal+"," ;
	var HtmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'><script></script></head><body class=MESSAGE><form name='tempform' id='tempform' method='post' action='GCPGenerateCarePlanIntermediate.jsp'><input type=hidden name='selected_diag' id='selected_diag' value='"+selected_diag+"'><input type=hidden name='selected_diag_val' id='selected_diag_val' value='"+selected_diag_val+"'><input type=hidden name='textName' id='textName' value='setSelectedIntvn'><input type=hidden name='textMode' id='textMode' value='Goal'></form></body></html>";
		
	parent.parent.TempFrame.document.write(HtmlVal);
	parent.parent.TempFrame.document.tempform.submit();

}
function chkValidate(obj,index1,index){
	var frmObjBottom =  parent.parent.GeneratePlanType.GeneratePlanTypeBottom ;
	
	var library_id="",version_no="",term_set_id= "",term_code= "",intervention_code="",outcome_code="",goal_code="", target_date="" ;
	var tmp_intervention_code="",tmp_outcome_code="",selected_diag_val="",group_id="";
	var selected_diag="";
	
	library_id = eval("frmObjBottom.document.generate_summary.library_id"+index).value;
	version_no = eval("frmObjBottom.document.generate_summary.version_no"+index).value;
	term_set_id = eval("frmObjBottom.document.generate_summary.term_set_id"+index).value;
	term_code = eval("frmObjBottom.document.generate_summary.term_code"+index).value;
	goal = eval("frmObjBottom.document.generate_summary.goal"+index).value;
	target_date = eval("frmObjBottom.document.generate_summary.dtarget_date"+index).value;
	
	if(obj == "Inter"){
		var inter_cnt=eval("frmObjBottom.document.generate_summary.inter_cnt"+index).value;
		if(eval("frmObjBottom.document.generate_summary.chk_inter"+index1+index).checked == true){
			eval("frmObjBottom.document.generate_summary.chk_goal"+index).checked = true;
		}

		for(var tmp=0;tmp<inter_cnt;tmp++){	
			if(eval("frmObjBottom.document.generate_summary.chk_inter"+tmp+index).checked == true){
				goal_flag = true;
				tmp_intervention_code = eval("frmObjBottom.document.generate_summary.inter_code"+tmp+index).value;
				group_id = eval("frmObjBottom.document.generate_summary.int_group_id"+tmp+index).value;
				intervention_code += tmp_intervention_code+"*"+group_id+"|";
			}
		}
		
		var outcome_cnt=eval("frmObjBottom.document.generate_summary.outcome_cnt"+index).value;
		for(var tmp=0;tmp<outcome_cnt;tmp++){	
			if(eval("frmObjBottom.document.generate_summary.chk_outcome"+tmp+index).checked == true){
				tmp_outcome_code = eval("frmObjBottom.document.generate_summary.outcome_code"+tmp+index).value;
				group_id = eval("frmObjBottom.document.generate_summary.out_group_id"+tmp+index).value;
				outcome_code += tmp_outcome_code+"*"+group_id+"|";
				
			}
		}
		if(goal_flag ==  true){
			eval("frmObjBottom.document.generate_summary.chk_goal"+index).checked = true;
			goal_flag =false;
		}else{
			var outcome_cnt=eval("frmObjBottom.document.generate_summary.outcome_cnt"+index).value;
			for(var tmp=0;tmp<outcome_cnt;tmp++)
			{	
				if(eval("frmObjBottom.document.generate_summary.chk_outcome"+tmp+index).checked == true){
					goal_flag = true;break;
				}
			}if(goal_flag ==  true){
				eval("frmObjBottom.document.generate_summary.chk_goal"+index).checked = true;
				goal_flag =false;
			}else
				eval("frmObjBottom.document.generate_summary.chk_goal"+index).checked = false;
		}
	
	}
	else if(obj == "Outer"){
		var outcome_cnt=eval("frmObjBottom.document.generate_summary.outcome_cnt"+index).value;
		
		if(eval("frmObjBottom.document.generate_summary.chk_outcome"+index1+index).checked == true){
			eval("frmObjBottom.document.generate_summary.chk_goal"+index).checked = true;
		}

		for(var tmp=0;tmp<outcome_cnt;tmp++){	
			if(eval("frmObjBottom.document.generate_summary.chk_outcome"+tmp+index).checked == true){
				goal_flag = true;tmp_outcome_code = eval("frmObjBottom.document.generate_summary.outcome_code"+tmp+index).value;
				group_id = eval("frmObjBottom.document.generate_summary.out_group_id"+tmp+index).value;
				outcome_code += tmp_outcome_code+"*"+group_id+"|";
			}
		}
		var inter_cnt=eval("frmObjBottom.document.generate_summary.inter_cnt"+index).value;
		for(var tmp=0;tmp<inter_cnt;tmp++){	
			if(eval("frmObjBottom.document.generate_summary.chk_inter"+tmp+index).checked == true){
				tmp_intervention_code = eval("frmObjBottom.document.generate_summary.inter_code"+tmp+index).value;
				group_id = eval("frmObjBottom.document.generate_summary.int_group_id"+tmp+index).value;
				intervention_code += tmp_intervention_code+"*"+group_id+"|";
			}
		}

		if(goal_flag ==  true){
			eval("frmObjBottom.document.generate_summary.chk_goal"+index).checked = true;
			goal_flag =false;
		}else{

			var inter_cnt=eval("frmObjBottom.document.generate_summary.inter_cnt"+index).value;
			for(var tmp=0;tmp<inter_cnt;tmp++)
			{	
				if(eval("frmObjBottom.document.generate_summary.chk_inter"+tmp+index).checked == true){
					goal_flag = true;break;
				}
			}if(goal_flag ==  true){
			eval("frmObjBottom.document.generate_summary.chk_goal"+index).checked = true;
			goal_flag =false;
		}else
			eval("frmObjBottom.document.generate_summary.chk_goal"+index).checked = false;

		}
	}
	if(intervention_code == "")
			intervention_code= " *";
	if(outcome_code == "")
			outcome_code= " *";
	
	selected_diag =  library_id+","+version_no+","+term_set_id+","+term_code+","+goal+"," ;
	selected_diag_val	=target_date+","+intervention_code+","+outcome_code+"~";
	if(intervention_code == " " && outcome_code == " "){
			selected_diag_val= "";
	}
	var HtmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'><script></script></head><body class=MESSAGE><form name='tempform' id='tempform' method='post' action='GCPGenerateCarePlanIntermediate.jsp'><input type=hidden name='selected_diag' id='selected_diag' value='"+selected_diag+"'><input type=hidden name='selected_diag_val' id='selected_diag_val' value='"+selected_diag_val+"'><input type=hidden name='textName' id='textName' value='setSelectedIntvn'></form></body></html>";
		
	parent.parent.TempFrame.document.write(HtmlVal);
	parent.parent.TempFrame.document.tempform.submit();
}

function PlanClear(){
	var frmObj =  parent.parent.GeneratePlanType.GeneratePlanTypeTop ;
	var i= parent.parent.GeneratePlanProfile.GeneratePlanProfileDiagnosis.document.generate_diagnosis.i.value;
	for(var tmp=0;tmp<i; tmp++){
		eval("parent.parent.GeneratePlanProfile.GeneratePlanProfileDiagnosis.document.generate_diagnosis.chk_diag"+tmp).disabled = false;
	}
	parent.parent.GeneratePlanProfile.GeneratePlanProfileDiagnosis.location.reload() ;
	parent.parent.GeneratePlanProfile.GeneratePlanProfileType.location.reload() ;
	parent.parent.GeneratePlanProfile.GeneratePlanProfileType.document.generate_case_type.reset();
	parent.parent.GeneratePlanType.GeneratePlanTypeTop.document.generate_libraires.reset();
	//parent.parent.document.getElementById("gpParentFrame").rows="0%,*,7%,0%";
	parent.parent.document.getElementById("GeneratePlanManager").style.height="0vh";
	parent.parent.document.getElementById("GeneratePlanProfile").style.height="92vh";
	parent.parent.document.getElementById("GeneratePlanType").style.height="7vh";
	parent.parent.document.getElementById("TempFrame").style.height="0vh";
	//parent.document.getElementById("planFrame").rows='0%,0%,0%,0%,6%,0%';
	parent.document.getElementById("GeneratePlanTypeShowBtn").style.height="0vh";
	parent.document.getElementById("GeneratePlanTypeTop").style.height="0vh";
	parent.document.getElementById("GeneratePlanTypeBottom").style.height="0vh";
	parent.document.getElementById("GeneratePlanDetail").style.height="0vh";
	parent.document.getElementById("GeneratePlanTypeBtn").style.height="6vh";
	parent.document.getElementById("GeneratePlanTypeLinks").style.height="0vh";
	parent.document.getElementById("GeneratePlanTypeShowBtn").style="display";
	parent.document.getElementById("GeneratePlanTypeTop").style="display";
	parent.document.getElementById("GeneratePlanTypeBottom").style="display";
	parent.document.getElementById("GeneratePlanDetail").style="display";
	parent.document.getElementById("GeneratePlanTypeBtn").style="display";
	parent.document.getElementById("GeneratePlanTypeLinks").style="display";
	parent.parent.GeneratePlanType.GeneratePlanTypeTop.location.href="../../eCommon/html/blank.html";
	parent.GeneratePlanTypeBottom.location.href="../../eCP/jsp/GCPGeneratePlanTypeBtn.jsp?&shw_nothing=Nothing";
	parent.GeneratePlanDetail.location.href="../../eCP/jsp/GCPGeneratePlanTypeBtn.jsp?&shw_nothing=Nothing";
	parent.parent.GeneratePlanType.GeneratePlanTypeBtn.location.href="../../eCP/jsp/GCPGeneratePlanTypeBtn.jsp";
	parent.parent.GeneratePlanProfile.GeneratePlanProfileType.document.generate_case_type.reset();
	parent.parent.GeneratePlanType.GeneratePlanTypeLinks.location.reload() ;
}

function dummmy(){
}

function onSuccess(error_num,error_value) {
	if(error_value == "1"){
		top.content.workAreaFrame.location.reload();
		top.content.messageFrame.location.href = '../../eCommon/jsp/error.jsp?err_val=1&err_num='+error_num;
	}
	else if(error_value == "0"){
		top.content.messageFrame.location.href = '../../eCommon/jsp/error.jsp?err_val=0&err_num='+error_num;
	}
}

function PreviewRecord(){
	var frmPrwObj = parent.parent.GeneratePlanType.GeneratePlanDetail ; 
	var selected_diagnosis = frmPrwObj.document.gen_preview_details.selected_diagnosis.value;
	var locale = frmPrwObj.document.gen_preview_details.locale.value;
	var count=frmPrwObj.document.gen_preview_details.count.value;
	if(count > 0){
		frmPrwObj.document.gen_preview_details.curr_care_manager.value = parent.parent.GeneratePlanManager.document.care_planmanager.gpcaremanager.value ;
		frmPrwObj.document.gen_preview_details.care_plan_start_date.value =convertDate(parent.parent.GeneratePlanManager.document.care_planmanager.start_date.value,'DMYHM',locale,"en");
		frmPrwObj.document.gen_preview_details.care_plan_end_date.value = convertDate(parent.parent.GeneratePlanManager.document.care_planmanager.target_date.value,'DMYHM',locale,"en");
		frmPrwObj.document.gen_preview_details.submit();
		if (top.content) {
			var msg= getMessage("RECORD_INSERTED","CP");
		}
	}else{

		alert(getMessage('NO_INTERVENTION_TO_RECORD','CP'));
	}
}

function checkValidDateTime(obj,locale){
	if(obj.value!='')	{
		if(!doDateTimeChk(obj)){
			alert(getMessage("INVALID_DATE_TIME","CP"));
			obj.value="";
			//obj.focus();
			return false;
		}
    }
	else if(obj.value=='' && locale!=undefined)
	{
		obj.value=getCurrentDate("DMYHM",locale);			
	}
	else if(obj.value=='')
	{
		alert(getMessage("INVALID_DATE_TIME","CP"));
		//obj.focus();
	}
	return true;
}

function callFocus(obj,index){
	var obj_name = obj;
	if(obj_name=="start_date")
		parent.GeneratePlanManager.document.care_planmanager.start_date.focus();
	if(obj_name=="target_date")
		parent.GeneratePlanManager.document.care_planmanager.target_date.focus();
	if(obj_name=="st_date" && index !="")
		eval("parent.GeneratePlanTypeBottom.document.generate_summary.start_date"+index).focus();
	if(obj_name=="trg_date" && index !="")
		eval("parent.GeneratePlanTypeBottom.document.generate_summary.target_date"+index).focus();
	if(obj_name=="dtarget_date" && index !="")
		eval("parent.GeneratePlanTypeBottom.document.generate_summary.dtarget_date"+index).focus();
}

function checkGRDate(frmObj,toObj){
	var from = frmObj.value;
	var to = toObj.value;
	if(doDatetimeCheckAlert(from,to)) {
		alert(getMessage("TO_DT_GR_EQ_FM_DT","CP"));
		toObj.value="";
		toObj.focus();
		return false;
	}
	return true;
}

function doDatetimeCheckAlert(from,to) {
	var fromarray;
	var toarray;
	var fromDt;
	var fromdate = from;
	var todate = to;
	if(fromdate.length > 0 && todate.length > 0 ){
	  	fromDt = fromdate.split(" ");
	  	fromarray = fromDt[0].split("/");

	  	toDt = todate.split(" ");
	  	toarray = toDt[0].split("/");

		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);
		if(Date.parse(todt) == Date.parse(fromdt))	{
			fromTime = fromDt[1];
			toTime   = toDt[1];

			if(toTime < fromTime){
				return true;
			}
		}

		if(Date.parse(todt) < Date.parse(fromdt)){
			return true;
		}
		else{
			if(Date.parse(todt) >= Date.parse(fromdt))
			return false;
		}
	}
}

function doDatetimeCheckAlert1(from,to) {
	var fromarray;
	var toarray;
	var fromDt;
	var fromdate;
	var todate;
	if(from==undefined)
		fromdate="";
	else
		fromdate = from;
	if(to==undefined)
		todate="";
	else
		todate = to;

	if(fromdate.length > 0 && todate.length > 0 ){
	  	fromDt = fromdate.split(" ");
	  	fromarray = fromDt[0].split("/");

	  	toDt = todate.split(" ");
	  	toarray = toDt[0].split("/");

		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);
		if(Date.parse(todt) == Date.parse(fromdt))	{
			fromTime = fromDt[1];
			toTime   = toDt[1];

			if(toTime <= fromTime)	{
				return true;
			}
		}

		if(Date.parse(todt) < Date.parse(fromdt)){
			return true;
		}
		else{
			if(Date.parse(todt) >= Date.parse(fromdt))
			return false;
		}
	}
}

async function showDescription(termset_id,term_code,lib_id,version_no,patient_class){
	var dialogHeight ='30vh';
	var dialogWidth = '50vw' ;
	var dialogTop	= '10';
	var dialogLeft = '10' ;
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=yes; status=no';
	var finalString	= "";
	finalString +="&termset_id="+termset_id+"&term_code="+term_code+"&lib_id="+lib_id+"&versn_no="+version_no+"&patient_class=" +patient_class+"&read_only=readonly" ;
	var arguments = "";
	var retVals = await top.window.showModalDialog("../../eCP/jsp/GCPGeneratePlanTypeTop.jsp?"+finalString,arguments,features);
}

function callDiagCaseScreen(){
	parent.GeneratePlanTypeLinks.document.getElementById("diag").innerHTML="<b><a href=# onclick='callDiagCaseScreen()'><font size='1' class='LINKINSTATUS' color=''>["+getLabel("eCP.DiagnosisCaseType.label","CP")+"]</font></a>&nbsp;</b>";
	parent.GeneratePlanTypeLinks.document.getElementById("lib").innerHTML="<b><a href=# onclick='callLibraryScreen()'><font size='1' class='' color=''>["+getLabel("eCP.StandardCarePlans.label","CP")+"]</font></a>&nbsp;</b>";
	parent.GeneratePlanTypeLinks.document.getElementById("summ").innerHTML="<b><a href=# onclick='callSummaryScreen()'><font size='1' color=''>["+getLabel("eCP.PlanSummary.label","CP")+"]</font></a></b>";
	parent.GeneratePlanTypeLinks.document.getElementById("detail").innerHTML="<b><a href=# onclick='callDetailScreen()'><font size='1' color=''>["+getLabel("eCP.PlanDetail.label","CP")+"]</font></a>&nbsp;</b>";
	parent.GeneratePlanTypeLinks.document.getElementById("record").innerHTML="";

	var fm_name = parent.parent.GeneratePlanType.GeneratePlanTypeBottom.document.forms[0].name;
	if(fm_name == "generate_summary"){
		 var to_proceed ="";
		to_proceed = chkDiagSelected();
		if(!to_proceed)
			return false;
		to_proceed = chkGroupSelected();
		if(!to_proceed)
			return false;
	}
	if(parent.parent.GeneratePlanType.GeneratePlanDetail.document.forms[0].name == "gen_preview_details"){
		var frmPrwObj = parent.parent.GeneratePlanType.GeneratePlanDetail ; 
		var count=frmPrwObj.document.gen_preview_details.count.value;
		var intervention_code = "";var freq_code="";var durn_type="";var duration= 0;var select_code="";
		var end_date="";var cp_stage="",prior="",postn="",start_date="";
		for (var tmp = 0;tmp < count ;tmp++ ){
			
			cp_stage = eval("frmPrwObj.document.gen_preview_details.intvn_stage"+tmp).value;
			prior	=eval("frmPrwObj.document.gen_preview_details.prior"+tmp).value;
			postn=eval("frmPrwObj.document.gen_preview_details.postn"+tmp).value;
			start_date=eval("frmPrwObj.document.gen_preview_details.st_date"+tmp).value;
			intervention_code = eval("frmPrwObj.document.gen_preview_details.inter_code"+tmp).value;
			freq_code = eval("frmPrwObj.document.gen_preview_details.freq_code"+tmp).value;
			duration =  eval("frmPrwObj.document.gen_preview_details.durn_value"+tmp).value;
			durn_type = eval("frmPrwObj.document.gen_preview_details.durn_type"+tmp).value;
			end_date = eval("frmPrwObj.document.gen_preview_details.end_date"+tmp).value;
			
			if(freq_code == "")
				freq_code=" ";
			if(duration == "")
				duration=" ";
			if(durn_type == "")
				durn_type=" ";
			if(end_date == "")
				end_date=" ";
			select_code += intervention_code+"~"+cp_stage+","+prior+","+postn+","+start_date+","+freq_code+","+duration+","+durn_type+","+end_date+"`";
		}
		var HtmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'><script></script></head><body class=MESSAGE><form name='tempform' id='tempform' method='post' action='GCPGenerateCarePlanIntermediate.jsp'><input type=hidden name='select_code' id='select_code' value='"+select_code+"'><input type=hidden name='textName' id='textName' value='setInterDetails'></form></body></html>";
		parent.parent.TempFrame.document.write(HtmlVal);
		parent.parent.TempFrame.document.tempform.submit();
	}
	//parent.parent.document.getElementById("gpParentFrame").rows="6%,47%,*,0%";
	parent.parent.document.getElementById("GeneratePlanManager").style.height="6vh";
	parent.parent.document.getElementById("GeneratePlanProfile").style.height="47vh";
	parent.parent.document.getElementById("GeneratePlanType").style.height="43vh";
	parent.parent.document.getElementById("TempFrame").style.height="0vh";
	parent.parent.document.getElementById("GeneratePlanManager").style="display";
	//parent.document.getElementById("planFrame").rows='0%,10%,0%,0%,1.5%,0%';
	parent.document.getElementById("GeneratePlanTypeShowBtn").style.height="0vh";
	parent.document.getElementById("GeneratePlanTypeTop").style.height="10vh";
	parent.document.getElementById("GeneratePlanTypeBottom").style.height="0vh";
	parent.document.getElementById("GeneratePlanDetail").style.height="0vh";
	parent.document.getElementById("GeneratePlanTypeBtn").style.height="1.5vh";
	parent.document.getElementById("GeneratePlanTypeLinks").style.height="0vh";
	parent.document.getElementById("GeneratePlanTypeShowBtn").style="display";
	parent.document.getElementById("GeneratePlanTypeTop").style="display";
	parent.document.getElementById("GeneratePlanTypeBottom").style="display";
	parent.document.getElementById("GeneratePlanDetail").style="display";
	parent.document.getElementById("GeneratePlanTypeBtn").style="display";
	parent.document.getElementById("GeneratePlanTypeLinks").style="display";
	parent.GeneratePlanTypeTop.location.href="../../eCommon/html/blank.html";
	parent.GeneratePlanTypeBtn.location.href="../../eCP/jsp/GCPGeneratePlanTypeBtn.jsp";
	//if (top.content) {
			//top.content.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	//}
}

function callLibraryScreen(){
	parent.GeneratePlanTypeLinks.document.getElementById("diag").innerHTML="<b><a href=# onclick='callDiagCaseScreen()'><font size='1' class='' color=''>["+getLabel("eCP.DiagnosisCaseType.label","CP")+"]</font></a>&nbsp;</b>";
	parent.GeneratePlanTypeLinks.document.getElementById("lib").innerHTML="<b><a href=# onclick='callLibraryScreen()'><font size='1' class='LINKINSTATUS' color=''>["+getLabel("eCP.StandardCarePlans.label","CP")+"]</font></a>&nbsp;</b>";
	parent.GeneratePlanTypeLinks.document.getElementById("summ").innerHTML="<b><a href=# onclick='callSummaryScreen()'><font size='1' color=''>["+getLabel("eCP.PlanSummary.label","CP")+"]</font></a></b>";
	parent.GeneratePlanTypeLinks.document.getElementById("detail").innerHTML="<b><a href=# onclick='callDetailScreen()'><font size='1' color=''>["+getLabel("eCP.PlanDetail.label","CP")+"]</font></a>&nbsp;</b>";
	parent.GeneratePlanTypeLinks.document.getElementById("record").innerHTML="";
	var fm_name = parent.parent.GeneratePlanType.GeneratePlanTypeBottom.document.forms[0].name;
	if(fm_name == "generate_summary"){
	 
	var to_proceed = chkGroupSelected();
	if(!to_proceed)
		return false;
	}
	if(parent.parent.GeneratePlanType.GeneratePlanDetail.document.forms[0].name == "gen_preview_details"){

		var frmPrwObj = parent.parent.GeneratePlanType.GeneratePlanDetail ; 
		var count=frmPrwObj.document.gen_preview_details.count.value;
		var intervention_code = "";var freq_code="";var durn_type="";var duration= 0;var select_code="";
		var end_date="";var cp_stage="",prior="",postn="",start_date="";

		for (var tmp = 0;tmp < count ;tmp++ ){
			
			cp_stage = eval("frmPrwObj.document.gen_preview_details.intvn_stage"+tmp).value;
			prior	=eval("frmPrwObj.document.gen_preview_details.prior"+tmp).value;
			postn=eval("frmPrwObj.document.gen_preview_details.postn"+tmp).value;
			start_date=eval("frmPrwObj.document.gen_preview_details.st_date"+tmp).value;
			intervention_code = eval("frmPrwObj.document.gen_preview_details.inter_code"+tmp).value;
			freq_code = eval("frmPrwObj.document.gen_preview_details.freq_code"+tmp).value;
			duration =  eval("frmPrwObj.document.gen_preview_details.durn_value"+tmp).value;
			durn_type = eval("frmPrwObj.document.gen_preview_details.durn_type"+tmp).value;
			end_date = eval("frmPrwObj.document.gen_preview_details.end_date"+tmp).value;
			
			if(freq_code == "")
				freq_code=" ";
			if(duration == "")
				duration=" ";
			if(durn_type == "")
				durn_type=" ";
			if(end_date == "")
				end_date=" ";
			select_code += intervention_code+"~"+cp_stage+","+prior+","+postn+","+start_date+","+freq_code+","+duration+","+durn_type+","+end_date+"`";
		}
		var HtmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'><script></script></head><body class=MESSAGE><form name='tempform' id='tempform' method='post' action='GCPGenerateCarePlanIntermediate.jsp'><input type=hidden name='select_code' id='select_code' value='"+select_code+"'><input type=hidden name='textName' id='textName' value='setInterDetails'></form></body></html>";
		parent.parent.TempFrame.document.write(HtmlVal);
		parent.parent.TempFrame.document.tempform.submit();
	}
	//parent.parent.document.getElementById("gpParentFrame").rows="0%,0%,*,0%";
	parent.parent.document.getElementById("GeneratePlanManager").style.height="0vh";
	parent.parent.document.getElementById("GeneratePlanProfile").style.height="0vh";
	parent.parent.document.getElementById("GeneratePlanType").style.height="100vh";
	parent.parent.document.getElementById("TempFrame").style.height="0vh";
	//parent.document.getElementById("planFrame").rows='0%,70%,0%,0%,4%,0%';
	parent.document.getElementById("GeneratePlanTypeShowBtn").style.height="0vh";
	parent.document.getElementById("GeneratePlanTypeTop").style.height="70vh";
	parent.document.getElementById("GeneratePlanTypeTop").style.width="99vw";
	parent.document.getElementById("GeneratePlanTypeBottom").style.height="0vh";
	parent.document.getElementById("GeneratePlanDetail").style.height="0vh";
	parent.document.getElementById("GeneratePlanTypeBtn").style.height="4vh";
	parent.document.getElementById("GeneratePlanTypeBtn").style.width="99vw";
	parent.document.getElementById("GeneratePlanTypeLinks").style.height="0vh";
	parent.document.getElementById("GeneratePlanTypeShowBtn").style="display";
	parent.document.getElementById("GeneratePlanTypeTop").style="display";
	parent.document.getElementById("GeneratePlanTypeBottom").style="display";
	parent.document.getElementById("GeneratePlanDetail").style="display";
	parent.document.getElementById("GeneratePlanTypeBtn").style="display";
	parent.document.getElementById("GeneratePlanTypeLinks").style="display";
	
	var finalString = parent.parent.GeneratePlanProfile.GeneratePlanProfileType.document.generate_case_type.finalStr.value;

	parent.GeneratePlanTypeTop.location.href="../../eCP/jsp/GCPGeneratePlanTypeTop.jsp?&finalString="+finalString+"&Library=EntireLibrary";
	parent.GeneratePlanTypeBtn.location.href="../../eCP/jsp/GCPGeneratePlanTypeBtn.jsp?&preview=true";
	parent.GeneratePlanTypeBottom.location.href="../../eCP/jsp/GCPGeneratePlanTypeBtn.jsp?&shw_nothing=Nothing";
}

async function callSummaryScreen(){

	var frmObj =  parent.parent.GeneratePlanType.GeneratePlanTypeTop ;
    var encounterId = frmObj.document.generate_libraires.encounterId.value;  //60772
	var sel_flag= false;
	var i = frmObj.document.generate_libraires.i.value;
	for (var tmp=0;tmp<i ;tmp++ ){
		if(eval("frmObj.document.generate_libraires.chk_library"+tmp).checked){
			sel_flag= true;
			break;
		}
	}
	if(sel_flag == false){
		alert(getMessage("DETAILIB_NOT_SELECT","CP"));
		return false;
	}

	parent.GeneratePlanTypeLinks.document.getElementById("diag").innerHTML="<b><a href=# onclick='callDiagCaseScreen()'><font size='1' class='' color=''>["+getLabel("eCP.DiagnosisCaseType.label","CP")+"]</font></a>&nbsp;</b>";
	parent.GeneratePlanTypeLinks.document.getElementById("lib").innerHTML="<b><a href=# onclick='callLibraryScreen()'><font size='1' class='' color=''>["+getLabel("eCP.StandardCarePlans.label","CP")+"]</font></a>&nbsp;</b>";
	parent.GeneratePlanTypeLinks.document.getElementById("summ").innerHTML="<b><a href=# onclick='callSummaryScreen()'><font size='1' class='LINKINSTATUS' color=''>["+getLabel("eCP.PlanSummary.label","CP")+"]</font></a></b>";
	parent.GeneratePlanTypeLinks.document.getElementById("detail").innerHTML="<b><a href=# onclick='callDetailScreen()'><font size='1' color=''>["+getLabel("eCP.PlanDetail.label","CP")+"]</font></a>&nbsp;</b>";
	parent.GeneratePlanTypeLinks.document.getElementById("record").innerHTML="";

	var fm_name = parent.parent.GeneratePlanType.GeneratePlanTypeBottom.document.forms[0].name;

	if(fm_name == "generate_summary"){
		var to_proceed =await chkGroupSelected();
		if(!to_proceed)
			return false;
	}
	if(parent.parent.GeneratePlanType.GeneratePlanDetail.document.forms[0].name == "gen_preview_details"){

		var frmPrwObj = parent.parent.GeneratePlanType.GeneratePlanDetail ; 
		var count=frmPrwObj.document.gen_preview_details.count.value;
		var intervention_code = "";var freq_code="";var durn_type="";var duration= 0;var select_code="";
		var end_date="";var cp_stage="",prior="",postn="",start_date="";

		for (var tmp = 0;tmp < count ;tmp++ ){
			
			cp_stage = eval("frmPrwObj.document.gen_preview_details.intvn_stage"+tmp).value;
			prior	=eval("frmPrwObj.document.gen_preview_details.prior"+tmp).value;
			postn=eval("frmPrwObj.document.gen_preview_details.postn"+tmp).value;
			start_date=eval("frmPrwObj.document.gen_preview_details.st_date"+tmp).value;
			intervention_code = eval("frmPrwObj.document.gen_preview_details.inter_code"+tmp).value;
			freq_code = eval("frmPrwObj.document.gen_preview_details.freq_code"+tmp).value;
			duration =  eval("frmPrwObj.document.gen_preview_details.durn_value"+tmp).value;
			durn_type = eval("frmPrwObj.document.gen_preview_details.durn_type"+tmp).value;
			end_date = eval("frmPrwObj.document.gen_preview_details.end_date"+tmp).value;
			
			if(freq_code == "")
				freq_code=" ";
			if(duration == "")
				duration=" ";
			if(durn_type == "")
				durn_type=" ";
			if(end_date == "")
				end_date=" ";
			select_code += intervention_code+"~"+cp_stage+","+prior+","+postn+","+start_date+","+freq_code+","+duration+","+durn_type+","+end_date+"`";
		}
		//var HtmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'><script></script></head><body class=MESSAGE><form name='tempform' method='post' action='GCPGenerateCarePlanIntermediate.jsp'><input type=hidden name='select_code' value='"+select_code+"'><input type=hidden name='textName' value='setInterDetails'></form></body></html>"; //60772
		var HtmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'><script></script></head><body class=MESSAGE><form name='tempform' id='tempform' method='post' action='GCPGenerateCarePlanIntermediate.jsp'><input type=hidden name='select_code' value='"+select_code+"'><input type=hidden name='encounterId' value='"+encounterId+"'><input type=hidden name='textName' value='setInterDetails'></form></body></html>"; //60772
 
			
		parent.parent.TempFrame.document.write(HtmlVal);
		parent.parent.TempFrame.document.tempform.submit();
	}
	//parent.parent.document.getElementById("gpParentFrame").rows="28%,0%,*,0%";
	parent.parent.document.getElementById("GeneratePlanManager").style="display";
	parent.parent.document.getElementById("GeneratePlanManager").style.height="28vh";
	parent.parent.document.getElementById("GeneratePlanManager").style.width="99vw";
	
	parent.parent.document.getElementById("GeneratePlanProfile").style.display="none";
	parent.parent.document.getElementById("GeneratePlanProfile").style.height="0vh";
	
	parent.parent.document.getElementById("TempFrame").style.display="none";
	parent.parent.document.getElementById("TempFrame").style.height="0vh";
	
	parent.parent.document.getElementById("GeneratePlanType").style="display";
	parent.parent.document.getElementById("GeneratePlanType").style.height="70vh";
	parent.parent.document.getElementById("GeneratePlanType").style.width="99vw";
	
	parent.parent.GeneratePlanManager.document.getElementById("summ_head").style="display";
	parent.parent.GeneratePlanManager.document.getElementById("intvn_head").style.display='none';
	var finalString="";
	finalString=parent.GeneratePlanTypeTop.document.generate_libraires.finalStr.value;
	//parent.document.getElementById("planFrame").rows='0%,0%,70%,0%,6%,0%';
	parent.document.getElementById("GeneratePlanTypeShowBtn").style.display="none";	
	parent.document.getElementById("GeneratePlanTypeShowBtn").style.height="0vh";
	

	parent.document.getElementById("GeneratePlanTypeTop").style.display="none";
	parent.document.getElementById("GeneratePlanTypeTop").style.height="0vh";	

	parent.document.getElementById("GeneratePlanTypeBottom").style="display";
	parent.document.getElementById("GeneratePlanTypeBottom").style.height="70vh";
	parent.document.getElementById("GeneratePlanTypeBottom").style.width="99vw";
	
	parent.document.getElementById("GeneratePlanDetail").style.display="none";
	parent.document.getElementById("GeneratePlanDetail").style.height="0vh";
	
	parent.document.getElementById("GeneratePlanTypeBtn").style="display";
	parent.document.getElementById("GeneratePlanTypeBtn").style.height="6vh";
	parent.document.getElementById("GeneratePlanTypeBtn").style.width="99vw";
	
	parent.document.getElementById("GeneratePlanTypeLinks").style.display="none";
	parent.document.getElementById("GeneratePlanTypeLinks").style.height="0vh";
	
	
	//parent.GeneratePlanTypeBottom.location.href="../../eCP/jsp/GCPGeneratePlanShowLibrary.jsp?&finalString="+finalString;
	parent.GeneratePlanTypeBottom.location.href="../../eCP/jsp/GCPGeneratePlanShowLibrary.jsp?&finalString="+finalString+"&encounterId="+encounterId;//60772
	parent.GeneratePlanTypeBtn.location.href="../../eCP/jsp/GCPGeneratePlanTypeBtn.jsp?&preview=true&show_back=summary";
	parent.GeneratePlanDetail.location.href="../../eCP/jsp/GCPGeneratePlanTypeBtn.jsp?&shw_nothing=Nothing&fm_name=disp_nothing";

	//if (top.content) {
			//top.content.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	//}
}

async function callDetailScreen(){
	parent.GeneratePlanTypeLinks.document.getElementById("diag").innerHTML="<b><a href=# onclick='callDiagCaseScreen()'><font size='1' class='' color=''>["+getLabel("eCP.DiagnosisCaseType.label","CP")+"]</font></a>&nbsp;</b>";
	parent.GeneratePlanTypeLinks.document.getElementById("lib").innerHTML="<b><a href=# onclick='callLibraryScreen()'><font size='1' class='' color=''>["+getLabel("eCP.StandardCarePlans.label","CP")+"]</font></a>&nbsp;</b>";
	parent.GeneratePlanTypeLinks.document.getElementById("summ").innerHTML="<b><a href=# onclick='callSummaryScreen()'><font size='1' class='' color=''>["+getLabel("eCP.PlanSummary.label","CP")+"]</font></a></b>";
	parent.GeneratePlanTypeLinks.document.getElementById("detail").innerHTML="<b><a href=# onclick='callDetailScreen()'><font size='1' class='LINKINSTATUS'  color=''>["+getLabel("eCP.PlanDetail.label","CP")+"]</font></a>&nbsp;</b>";

	var to_proceed= false;
	var fm_name = parent.parent.GeneratePlanType.GeneratePlanTypeBottom.document.forms[0].name;
	if(fm_name == "generate_summary"){
		to_proceed= await chkDiagSelected();
		if(!to_proceed)
			return false;

		var frmObjBottom =  parent.parent.GeneratePlanType.GeneratePlanTypeBottom ;
		var i="" ;

		i = eval("frmObjBottom.document.generate_summary.i").value;
		if(i==0){
			alert(getMessage("INTVN_NOT_SELECT","CP"));
			return false;
		}
		var flag = false,out_flag=false;
		var inter_code="",tmp_inter_code="";
		var gcnt="";
		var g_cnt="",gout_cnt="";

		for(var t=0;t<i;t++){
			var inter_cnt=eval("frmObjBottom.document.generate_summary.inter_cnt"+t).value;
			var outer_cnt=eval("frmObjBottom.document.generate_summary.outcome_cnt"+t).value;
			flag = false;
			gcnt = eval("frmObjBottom.document.generate_summary.gcnt"+t).value;
			var tmp_gcnt=0,tmp_gcnt1=0;
			var tmp_goutcnt=0,tmp_goutcnt1=0;
			if(gcnt==0)
				eval("frmObjBottom.document.generate_summary.chk_goal"+t).checked = false;

			if(eval("frmObjBottom.document.generate_summary.chk_goal"+t).checked == true){
				for(var t1=0;t1<gcnt;t1++){
					g_cnt = eval("frmObjBottom.document.generate_summary.gint_cnt"+t1+t).value;
					gout_cnt = eval("frmObjBottom.document.generate_summary.gout_cnt"+t1+t).value;

					tmp_goutcnt1 =eval(tmp_goutcnt1) +eval(gout_cnt);
					for(var t_out=tmp_goutcnt;t_out<tmp_goutcnt1;t_out++){
						out_flag = false;
						if(eval("frmObjBottom.document.generate_summary.chk_outcome"+t_out+t).checked == true){
							out_flag = true;
							break;
						}
					}
					tmp_gcnt1 =eval(tmp_gcnt1) +eval(g_cnt);
					flag = false;

					//if(out_flag == true){
					for(var t2=tmp_gcnt;t2<tmp_gcnt1;t2++){
						if(eval("frmObjBottom.document.generate_summary.chk_inter"+t2+t).checked == true){
							flag = true;
							break;
						}
					}
					tmp_gcnt = eval(tmp_gcnt)+eval(g_cnt);
					//}
					//else
						//flag = false; 

					tmp_goutcnt = eval(tmp_goutcnt)+eval(gout_cnt);

					if(flag ^ out_flag){
						alert(getMessage("INTVN_PER_GRP","CP"));
						return false;
					}
				}
				for(var tp=0;tp<inter_cnt;tp++){
					if(eval("frmObjBottom.document.generate_summary.chk_inter"+tp+t).checked == true){
						tmp_inter_code =  eval("frmObjBottom.document.generate_summary.inter_code"+tp+t).value;
						inter_code += "~"+tmp_inter_code+"~,";
					}
				}
			}
		}
		var HtmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'><script></script></head><body class=MESSAGE><form name='tempform' id='tempform' method='post' action='GCPGenerateCarePlanIntermediate.jsp'><input type=hidden name='tmp_inter_code' value="+inter_code+"><input type=hidden name='textName' value='setInterCode'></form></body></html>";

		parent.parent.TempFrame.document.write(HtmlVal);
		parent.parent.TempFrame.document.tempform.submit();


		}
		else if(parent.parent.GeneratePlanType.GeneratePlanDetail.document.forms[0].name == "gen_preview_details"){
				
			var frmPrwObj = parent.parent.GeneratePlanType.GeneratePlanDetail ; 
			var count=frmPrwObj.document.gen_preview_details.count.value;
			var intervention_code = "";var freq_code="";var durn_type="";var duration= 0;var select_code="";
			var end_date="";var cp_stage="",prior="",postn="",start_date="";

			for (var tmp = 0;tmp < count ;tmp++ ){
				
				cp_stage = eval("frmPrwObj.document.gen_preview_details.intvn_stage"+tmp).value;
				prior	=eval("frmPrwObj.document.gen_preview_details.prior"+tmp).value;
				postn=eval("frmPrwObj.document.gen_preview_details.postn"+tmp).value;
				start_date=eval("frmPrwObj.document.gen_preview_details.st_date"+tmp).value;
				intervention_code = eval("frmPrwObj.document.gen_preview_details.inter_code"+tmp).value;
				freq_code = eval("frmPrwObj.document.gen_preview_details.freq_code"+tmp).value;
				duration =  eval("frmPrwObj.document.gen_preview_details.durn_value"+tmp).value;
				durn_type = eval("frmPrwObj.document.gen_preview_details.durn_type"+tmp).value;
				end_date = eval("frmPrwObj.document.gen_preview_details.end_date"+tmp).value;
				
				if(freq_code == "")
					freq_code=" ";
				if(duration == "")
					duration=" ";
				if(durn_type == "")
					durn_type=" ";
				if(end_date == "")
					end_date=" ";
				select_code += intervention_code+"~"+cp_stage+","+prior+","+postn+","+start_date+","+freq_code+","+duration+","+durn_type+","+end_date+"`";
			}
			var HtmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'><script></script></head><body class=MESSAGE><form name='tempform' id='tempform' method='post' action='GCPGenerateCarePlanIntermediate.jsp'><input type=hidden name='select_code' id='select_code' value='"+select_code+"'><input type=hidden name='textName' id='textName' value='setInterDetails'></form></body></html>";
			parent.parent.TempFrame.document.write(HtmlVal);
			parent.parent.TempFrame.document.tempform.submit();

		}
		else if(fm_name == "")	{
			alert(getMessage("INTVN_ACHIEVE_GOAL","CP"));
			return false;
		}
		var finalString	= "";
		finalString= parent.GeneratePlanTypeBottom.document.generate_summary.finalStr.value;
		//parent.parent.document.getElementById("gpParentFrame").rows="28%,0%,*,0%";

		parent.parent.document.getElementById("GeneratePlanManager").style="display";
		parent.parent.document.getElementById("GeneratePlanManager").style.height="28vh";
		parent.parent.document.getElementById("GeneratePlanManager").style.width="99vw";
		
		parent.parent.document.getElementById("GeneratePlanType").style="display";
		parent.parent.document.getElementById("GeneratePlanType").style.height="70vh";
		parent.parent.document.getElementById("GeneratePlanType").style.width="99vw";
		
		parent.parent.document.getElementById("GeneratePlanProfile").style.height="0vh";	
		parent.parent.document.getElementById("TempFrame").style.height="0vh";
		
		parent.parent.GeneratePlanManager.document.getElementById("tb_scplan").style='display';
		parent.parent.GeneratePlanManager.document.getElementById("summ_head").style.display='none';
		parent.parent.GeneratePlanManager.document.getElementById("intvn_head").style='display';
		
		parent.parent.GeneratePlanManager.document.care_planmanager.start_date.readOnly =true;
		parent.parent.GeneratePlanManager.document.care_planmanager.target_pd.readOnly =true;
		parent.parent.GeneratePlanManager.document.care_planmanager.target_date.readOnly =true;
		parent.parent.GeneratePlanManager.document.getElementById("st_cal").disabled =true;
		parent.parent.GeneratePlanManager.document.getElementById("end_cal").disabled =true;

		//parent.document.getElementById("planFrame").rows='0%,0%,0%,70%,6%,0%';
		parent.document.getElementById("GeneratePlanTypeShowBtn").style="display";
		parent.document.getElementById("GeneratePlanTypeShowBtn").style.height="0vh";
	
		parent.document.getElementById("GeneratePlanTypeTop").style="display";
		parent.document.getElementById("GeneratePlanTypeTop").style.height="0vh";
		
		parent.document.getElementById("GeneratePlanTypeBottom").style="display";
		parent.document.getElementById("GeneratePlanTypeBottom").style.height="0vh";
		
		parent.document.getElementById("GeneratePlanDetail").style="display";
		parent.document.getElementById("GeneratePlanDetail").style.height="75vh";
		parent.document.getElementById("GeneratePlanDetail").style.width="99vw";
		
		parent.document.getElementById("GeneratePlanTypeBtn").style="display";
		parent.document.getElementById("GeneratePlanTypeBtn").style.height="6vh";		
		parent.document.getElementById("GeneratePlanTypeBtn").style.width="99vw";
		
		parent.document.getElementById("GeneratePlanTypeLinks").style="display";
		parent.document.getElementById("GeneratePlanTypeLinks").style.height="0vh";
	
		parent.GeneratePlanDetail.location.href="../../eCP/jsp/GCPGeneratePlanPreviewDtl.jsp?&finalString="+finalString;
		parent.GeneratePlanTypeBtn.location.href="../../eCP/jsp/GCPGeneratePlanTypeBtn.jsp?&preview=true&show_back=library";
}

function FinalizePlan(){

	var frmObj =  parent.parent.GeneratePlanType.GeneratePlanTypeTop ;
	var sel_flag= false;
	var i = frmObj.document.generate_libraires.i.value;
	for (var tmp=0;tmp<i ;tmp++ ){
		if(eval("frmObj.document.generate_libraires.chk_library"+tmp).checked){
			sel_flag= true;
			break;
		}
	}
	if(sel_flag == false){
		alert(getMessage("DETAILIB_NOT_SELECT","CP"));
		return false;
	}

	var HtmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'><script></script></head><body class=MESSAGE><form name='tempform' id='tempform' method='post' action='GCPGenerateCarePlanIntermediate.jsp'><input type=hidden name='textName' id='textName' value='FinalizePlan'></form></body></html>";
	
	parent.parent.TempFrame.document.write(HtmlVal);
	parent.parent.TempFrame.document.tempform.submit();

	var finalString	= "";
	finalString= parent.GeneratePlanTypeTop.document.generate_libraires.finalStr.value;
	//parent.parent.document.getElementById("gpParentFrame").rows="28%,0%,*,0%";
	parent.parent.document.getElementById("GeneratePlanManager").style="display";
	parent.parent.document.getElementById("GeneratePlanManager").style.height="28vh";
	parent.parent.document.getElementById("GeneratePlanManager").style.width="99vw";
	
	
	
	parent.parent.document.getElementById("GeneratePlanType").style="display";
	parent.parent.document.getElementById("GeneratePlanType").style.height="70vh";
	parent.parent.document.getElementById("GeneratePlanType").style.width="99vw";
	
	parent.parent.document.getElementById("GeneratePlanProfile").style.height="0vh";
	parent.parent.document.getElementById("TempFrame").style.height="0vh";
	
	parent.parent.GeneratePlanManager.document.getElementById("summ_head").style.display='none';
	parent.parent.GeneratePlanManager.document.getElementById("intvn_head").style="display";
	parent.parent.GeneratePlanManager.document.care_planmanager.start_date.readOnly =true;
	parent.parent.GeneratePlanManager.document.care_planmanager.target_pd.readOnly =true;
	parent.parent.GeneratePlanManager.document.care_planmanager.target_date.readOnly =true;
	parent.parent.GeneratePlanManager.document.getElementById("st_cal").disabled =true;
	parent.parent.GeneratePlanManager.document.getElementById("end_cal").disabled =true;

	//parent.document.getElementById("planFrame").rows='0%,0%,0%,70%,6%,0%';
	parent.document.getElementById("GeneratePlanTypeShowBtn").style.display="none";
	parent.document.getElementById("GeneratePlanTypeShowBtn").style.height="0vh";
	parent.document.getElementById("GeneratePlanTypeTop").style.display="none";
	parent.document.getElementById("GeneratePlanTypeTop").style.height="0vh";
	parent.document.getElementById("GeneratePlanTypeBottom").style.display="none";
	parent.document.getElementById("GeneratePlanTypeBottom").style.height="0vh";
	parent.document.getElementById("GeneratePlanDetail").style="display";
	parent.document.getElementById("GeneratePlanDetail").style.height="75vh";
	parent.document.getElementById("GeneratePlanDetail").style.width="99vw";
	parent.document.getElementById("GeneratePlanTypeBtn").style="display";
	parent.document.getElementById("GeneratePlanTypeBtn").style.height="6vh";
	parent.document.getElementById("GeneratePlanDetail").style.width="99vw";
	parent.document.getElementById("GeneratePlanTypeLinks").style.display="none";
	parent.document.getElementById("GeneratePlanTypeLinks").style.height="0vh";
	

	parent.GeneratePlanTypeBottom.location.href="../../eCP/jsp/GCPGeneratePlanShowLibrary.jsp?&finalString="+finalString;
	parent.GeneratePlanDetail.location.href="../../eCP/jsp/GCPGeneratePlanPreviewDtl.jsp?&finalString="+finalString;
	parent.GeneratePlanTypeBtn.location.href="../../eCP/jsp/GCPGeneratePlanTypeBtn.jsp?&preview=true&show_back=library";
} 

function populateLibDetails2(index,index1){
	var frmObj =  parent.parent.GeneratePlanType.GeneratePlanTypeTop ;
	var i =eval("frmObj.document.generate_libraires.i"+index1).value;
	var j= frmObj.document.generate_libraires.j.value;
	for(var tmp=0;tmp<i;tmp++){
		if(index != tmp ){
			eval("frmObj.document.generate_libraires.chk_library"+tmp+index1).checked = false;
		}
	}
	
	var term_set_id = "";
	term_set_id = eval("frmObj.document.generate_libraires.term_set_id"+index+index1).value; 
	var term_code = "";
	term_code = eval("frmObj.document.generate_libraires.term_code"+index+index1).value; 
	var casetype_code = "";
	casetype_code =	eval("frmObj.document.generate_libraires.casetype_code"+index+index1).value; 

	var lib_id = "";
	var version_no = "";var term_set_id1 = "",term_code1 = "",term_cd_value="";
	var HtmlVal ="";var value_str = "",selected_value = "";
	lib_id = eval("frmObj.document.generate_libraires.library_code"+index+index1).value;
	version_no =eval("frmObj.document.generate_libraires.version_no"+index+index1).value;
	term_set_id1 = term_set_id;
	term_code1 = term_code;
	
	if(term_set_id1 == ""){
		term_set_id1 = " ";
		term_code1 = " ";
	}	
	value_str += lib_id+","+version_no+","+term_set_id1+","+term_code1+"~";

	if(term_set_id != "" && term_code !=""){
		term_cd_value = lib_id+"~"+version_no+"~"+term_set_id+"~"+term_code+"~";	
		term_code =term_set_id+"~"+term_code+"~";
		var termcode_value="";
		if(eval("frmObj.document.generate_libraires.chk_library"+index+index1).checked == true){
			termcode_value = "Y";
			selected_value = "Y";
		}else{
			termcode_value = "N";
			selected_value = "N";
		}
		HtmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'><script></script></head><body class=MESSAGE><form name='tempform' id='tempform' method='post' action='GCPGenerateCarePlanIntermediate.jsp'><input type=hidden name='term_code' id='term_code' value='"+term_code+"'><input type=hidden name='termcode_value' id='termcode_value' value='"+termcode_value+"'><input type=hidden name='term_cd_value' id='term_cd_value' value='"+term_cd_value+"'><input type=hidden name='selected_lib' id='selected_lib' value='"+value_str+"'><input type=hidden name='selected_value' id='selected_value' value='"+selected_value+"'><input type=hidden name='textName' id='textName' value='setterm_code'></form></body></html>";
		
	}
	else if(casetype_code != ""){
		var casetype_value="";
		if(eval("frmObj.document.generate_libraires.chk_library"+index).checked == true){
			casetype_value = "Y";
			selected_value = "Y";
		}else{
			casetype_value = "N";
			selected_value = "N";
		}
		HtmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'><script></script></head><body class=MESSAGE><form name='tempform' id='tempform' method='post' action='GCPGenerateCarePlanIntermediate.jsp'><input type=hidden name='case_code' id='case_code' value='"+casetype_code+"'><input type=hidden name='casetype_value' id='casetype_value' value='"+casetype_value+"'><input type=hidden name='selected_lib' id='selected_lib' value='"+value_str+"'><input type=hidden name='selected_value' id='selected_value' value='"+selected_value+"'><input type=hidden name='textName' id='textName' value='setcase_status'></form></body></html>";
	}
	parent.parent.TempFrame.document.write(HtmlVal);
	parent.parent.TempFrame.document.tempform.submit();
}

async function chkDuration(index,obj){
	var frmPrwObj = parent.parent.GeneratePlanType.GeneratePlanDetail ; 
	var tmp_value=eval("frmPrwObj.document.gen_preview_details.freq_select"+index).value;
	if(tmp_value == ""){
		eval("frmPrwObj.document.gen_preview_details.durn_value"+index).value= 0;
		eval("frmPrwObj.document.gen_preview_details.dur_type"+index).options[0].selected = selected ;
		eval("frmPrwObj.document.gen_preview_details.durn_value"+index).readOnly= true;
		eval("frmPrwObj.document.gen_preview_details.dur_type"+index).disabled= true;
		eval("frmPrwObj.document.gen_preview_details.end_date"+index).value= eval("frmPrwObj.document.gen_preview_details.st_date"+index).value;
	}
	else{
		eval("frmPrwObj.document.gen_preview_details.durn_value"+index).readOnly= false;
		eval("frmPrwObj.document.gen_preview_details.dur_type"+index).disabled= false;
	}
	var freq_code	="";
	var freq_durn_value="";var freq_durn_unit="";
	var freq_durn_unit="";
	var freq_arr = new Array();
	freq_arr = tmp_value.split(",")
	freq_code = freq_arr[0];
	freq_durn_value =freq_arr[1];
	freq_durn_unit=freq_arr[2];
	var retVal =new Array();
	if(freq_code == "*O"){
		retVal =await show_frequency_window();
		var str =unescape(retVal);
		var arr = str.split(",");
		if(retVal != null && retVal != ""){
			freq_code = arr[0];
			freq_durn_unit = arr[2];
			freq_durn_value = 0;
		}
		else{
			freq_code = "*O" ; 
			freq_durn_unit = "";
			freq_durn_value= 0;
		}
	}
	eval("frmPrwObj.document.gen_preview_details.freq_code"+index).value=freq_code;
	eval("frmPrwObj.document.gen_preview_details.durn_type"+index).value=freq_durn_unit;
	eval("frmPrwObj.document.gen_preview_details.durn_value"+index).focus();
	var select_count=eval("frmPrwObj.document.gen_preview_details.dur_type"+index).length;
	for (var i = 0 ; i < select_count ;i++)
		eval("frmPrwObj.document.gen_preview_details.dur_type"+index).remove(eval("frmPrwObj.document.gen_preview_details.dur_type"+index).options[0].text);
	if(freq_durn_unit == "null" || freq_durn_unit == '' ){

		var opt = document.createElement("OPTION");
		opt.text = "Minute(s)" ;
		opt.value = "M";
		eval("frmPrwObj.document.gen_preview_details.dur_type"+index).add(opt);

		opt = document.createElement("OPTION");
		opt.text = "Hour(s)" ;
		opt.value = "H";
		eval("frmPrwObj.document.gen_preview_details.dur_type"+index).add(opt);

		opt = document.createElement("OPTION");
		opt.text = "Day(s)" ;
		opt.value = "D";
		eval("frmPrwObj.document.gen_preview_details.dur_type"+index).add(opt);

		opt = document.createElement("OPTION");
		opt.text = "Week(s)" ;
		opt.value = "W";
		eval("frmPrwObj.document.gen_preview_details.dur_type"+index).add(opt);

		opt = document.createElement("OPTION");
		opt.text = "Month(s)" ;
		opt.value = "L";
		eval("frmPrwObj.document.gen_preview_details.dur_type"+index).add(opt);

		eval("frmPrwObj.document.gen_preview_details.durn_value"+index).focus();
	}
	else{
		switch(freq_durn_unit){
			case 'M':
				var opt = document.createElement("OPTION");
				opt.text = "Minute(s)" ;
				opt.value = "M";
				eval("frmPrwObj.document.gen_preview_details.dur_type"+index).add(opt);
			case 'H':
				var opt = document.createElement("OPTION");
				opt.text = "Hour(s)" ;
				opt.value = "H";
				eval("frmPrwObj.document.gen_preview_details.dur_type"+index).add(opt);
			case 'D':
				var opt = document.createElement("OPTION");
				opt.text = "Day(s)" ;
				opt.value = "D";
				eval("frmPrwObj.document.gen_preview_details.dur_type"+index).add(opt);
			case 'W':
				var opt = document.createElement("OPTION");
				opt.text = "Week(s)" ;
				opt.value = "W";
				eval("frmPrwObj.document.gen_preview_details.dur_type"+index).add(opt);
			case 'L':
				var opt = document.createElement("OPTION");
				opt.text = "Month(s)" ;
				opt.value = "L";
				eval("frmPrwObj.document.gen_preview_details.dur_type"+index).add(opt);
			default:
				eval("frmPrwObj.document.gen_preview_details.durn_value"+index).focus();
		}
		eval("frmPrwObj.document.gen_preview_details.dur_type"+index).options[0].selected = true ;
		eval("frmPrwObj.document.gen_preview_details.dur_type"+index).options[0].style.color = "#990000" ;
	}
	/*
	if(freq_durn_unit == 'M'){
		eval("frmPrwObj.document.gen_preview_details.dur_type"+index).options[0].selected = selected ;
	}
	else if(freq_durn_unit == 'H'){
		eval("frmPrwObj.document.gen_preview_details.dur_type"+index).options[1].selected = selected ;
	}
	else if(freq_durn_unit == 'D'){
		eval("frmPrwObj.document.gen_preview_details.dur_type"+index).options[2].selected = selected ;
	}
	else if(freq_durn_unit == 'W'){
		eval("frmPrwObj.document.gen_preview_details.dur_type"+index).options[3].selected = selected ;
	}else if(freq_durn_unit == 'M'){
		eval("frmPrwObj.document.gen_preview_details.dur_type"+index).options[4].selected = selected ;
	}
	else if(freq_durn_unit == "null" || freq_durn_unit == '' ){
		eval("frmPrwObj.document.gen_preview_details.durn_value"+index).focus();
	}*/
}	

function addDurnUnit(unit, legend,index){
	eval("frmPrwObj.document.gen_preview_details.dur_type"+index)
}

function calToDate(obj,index,form_name){
	var start_date ="";
	if(form_name == "care_planmanager")
		start_date = parent.GeneratePlanManager.document.care_planmanager.start_date.value;
	else if(form_name == "generate_summary")
		start_date = eval("parent.GeneratePlanTypeBottom.document.generate_summary.start_date"+index).value;

	var target_period = "";
	target_period = obj.value;
	if(target_period == "")
		return false;
		
	var fromarray;
	var fromDt;
	var timarray;
	var finalDt="";
	if(start_date.length > 0 && parseFloat(target_period) > 0 ){
		fromDt = start_date.split(" ");
		fromarray = fromDt[0].split("/");
		timarray = fromDt[1].split(":");
		
		var dt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
		dt.setTime(dt.getTime()+1000 * 60 * 60 * 24 * parseInt(target_period));
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
		finalDt += dt.getFullYear() + " ";
		finalDt += hours + ":";
		finalDt += minutes ;
		setToDate(finalDt,index,form_name);
	}
	return true;
}

async function setToDate(val,index,form_name){

	var frmObjBottom = "";var to_proceed=false;
	if(form_name == "care_planmanager")
		frmObjBottom = parent.GeneratePlanType.GeneratePlanTypeBottom ;
	if(form_name == "generate_summary"){
		var fld_name= val;
		frmObjBottom = parent.parent.GeneratePlanType.GeneratePlanTypeBottom ;
		if((val == "gettar_date")|| (val == "dtarget_date"))
			val = eval("frmObjBottom.document.generate_summary.target_date"+index).value;
		if(val == "dtarget_date")
			val = eval("frmObjBottom.document.generate_summary.dtarget_date"+index).value;
		
	}

	if(index!=""){
		var target_date = parent.parent.GeneratePlanManager.document.care_planmanager.target_date.value 
		if(doDatetimeCheckAlert(val,target_date)) {
			var tar_pd = eval("frmObjBottom.document.generate_summary.target_pd"+index).value ;
	
			var confirm_val= true ;
			if(confirm_val){
				eval("parent.parent.GeneratePlanManager.document.care_planmanager.target_date").value = val;
				if(fld_name == "gettar_date"){
					to_proceed= await	checkDiagTargetDate(val,form_name,"diff_target_pd");
					if(!to_proceed)
						return false;
				}
				else
					to_proceed= await	checkDiagTargetDate(val,form_name,"");
					if(!to_proceed)
						return false;
			}
			else{
				eval("frmObjBottom.document.generate_summary.target_date"+index).value = "";
				return false;
			}
		}
		else{
			eval("frmObjBottom.document.generate_summary.target_date"+index).value = val;
			to_proceed= await	checkDiagTargetDate(val,form_name,"no_pperiod");
			if(!to_proceed)
				return false;
		}
		var i = eval("frmObjBottom.document.generate_summary.i").value;
		i = eval("frmObjBottom.document.generate_summary.dgroup_cnt"+index).value;
		var dtarget_dt="";var trg_date_arr=new Array();var tt=0;
		for(var tmp=index;tmp<i;tmp++){
			dtarget_dt = eval("frmObjBottom.document.generate_summary.dtarget_date"+tmp).value ;
			trg_date_arr[tt]=dtarget_dt ;
			tt++;
		}
		if(trg_date_arr.length >0){
			if(trg_date_arr.length ==1)
				target_date=trg_date_arr[0];
			for(var tmp1=1;tmp1<trg_date_arr.length;tmp1++){
				var fromarray;
				var toarray;
				var fromDt;
				var fromdate = trg_date_arr[0];
				var todate =trg_date_arr[tmp1];
				if(fromdate.length > 0 && todate.length > 0 )	{
					fromDt = fromdate.split(" ");
					fromarray = fromDt[0].split("/");

					toDt = todate.split(" ");
					toarray = toDt[0].split("/");

					var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
					var todt = new Date(toarray[2],toarray[1],toarray[0]);
					if(Date.parse(todt) < Date.parse(fromdt)){
						target_date = fromdate;
					}
					else{
						if(Date.parse(todt) >= Date.parse(fromdt)){
							target_date = todate;
						}
						if(Date.parse(todt) == Date.parse(fromdt))	{
							fromTime = fromDt[1];
							toTime   = toDt[1];
							if(toTime < fromTime)
								target_date = fromdate;
							else
								target_date = todate;
						}
					}
				}
			}
			tmp_target_dt = target_date;
		}
		if(doDatetimeCheckAlert(tmp_target_dt,val)) {
			alert(getMessage("DIAGTARTGET_GREATER_DATE","CP"));
			eval("frmObjBottom.document.generate_summary.dtarget_date"+index).value=val;
			eval("frmObjBottom.document.generate_summary.target_date"+index).focus();
			return false;
		}
		else{
			eval("frmObjBottom.document.generate_summary.target_date"+index).value = val;
		}

	}
	else{
		eval("parent.GeneratePlanManager.document.care_planmanager.target_date").value = val;
		eval("parent.GeneratePlanManager.document.care_planmanager.target_date").focus();
	}
	if(form_name=="generate_summary");
		return true;

}

function chkGroupSelected(){
	var frmObjBottom =  parent.parent.GeneratePlanType.GeneratePlanTypeBottom ;
	var i="" ;
	i = eval("frmObjBottom.document.generate_summary.i").value;

	var flag = false,out_flag=false;var inter_code="",tmp_inter_code="";var gcnt="",gout_cnt ="";
	for (var tmp=0;tmp< i;tmp++){
		var inter_cnt=eval("frmObjBottom.document.generate_summary.inter_cnt"+tmp).value;
		flag = false;
		gcnt = eval("frmObjBottom.document.generate_summary.gcnt"+tmp).value;
		var tmp_gcnt=0,tmp_gcnt1=0;
		var tmp_goutcnt=0,tmp_goutcnt1=0;
		if(eval("frmObjBottom.document.generate_summary.chk_goal"+tmp).checked == true){
			for(var t1=0;t1<gcnt;t1++){
				g_cnt = eval("frmObjBottom.document.generate_summary.gint_cnt"+t1+tmp).value;
				gout_cnt = eval("frmObjBottom.document.generate_summary.gout_cnt"+t1+tmp).value;
			
				tmp_goutcnt1 =eval(tmp_goutcnt1) +eval(gout_cnt);
				for(var t_out=tmp_goutcnt;t_out<tmp_goutcnt1;t_out++){
					out_flag = false;
					if(eval("frmObjBottom.document.generate_summary.chk_outcome"+t_out+tmp).checked == true){
						out_flag = true;
						break;
					}
				}
				tmp_gcnt1 =eval(tmp_gcnt1) +eval(g_cnt);
				flag = false;
				if(out_flag == true){
					for(var t2=tmp_gcnt;t2<tmp_gcnt1;t2++){					
						if(eval("frmObjBottom.document.generate_summary.chk_inter"+t2+tmp).checked == true){
							flag = true;
							break;
						}
					}
					tmp_gcnt = eval(tmp_gcnt)+eval(g_cnt);
				}
				else
					flag= true;

				tmp_goutcnt = eval(tmp_goutcnt)+eval(gout_cnt);

				if(flag == false){
					alert(getMessage("INTVN_PER_GRP","CP"));
					return false;
				}
			}
			for(var tp=0;tp<inter_cnt;tp++){
				if(eval("frmObjBottom.document.generate_summary.chk_inter"+tp+tmp).checked == true){
					tmp_inter_code =  eval("frmObjBottom.document.generate_summary.inter_code"+tp+tmp).value;
					inter_code += "~"+tmp_inter_code+"~,";
				}
			}
		}
	}
	var HtmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'><script></script></head><body class=MESSAGE><form name='tempform' id='tempform' method='post' action='GCPGenerateCarePlanIntermediate.jsp'><input type=hidden name='tmp_inter_code' id='tmp_inter_code' value="+inter_code+"><input type=hidden name='textName' id='textName' value='setInterCode'></form></body></html>";
	parent.parent.TempFrame.document.write(HtmlVal);
	parent.parent.TempFrame.document.tempform.submit();
	return true;
}

async function checkStartDate(obj){
	var plan_start_dt = obj.value;
	var frmObjBottom = parent.GeneratePlanType.GeneratePlanTypeBottom;
	var i = frmObjBottom.document.generate_summary.i.value;
	var plan_target_date= document.care_planmanager.target_date.value ;
	var form_name = "care_planmanager";
	var gp_cnt =0;
	if(i>0){
	
		var dg_cnt=0;var dgroup_count =0; 
				
		while(gp_cnt >=0){
			dg_cnt= eval("frmObjBottom.document.generate_summary.dgroup_cnt"+gp_cnt).value;
			var tmp_start_date = eval("frmObjBottom.document.generate_summary.start_date"+gp_cnt).value;
			var tmp_start_date = eval("frmObjBottom.document.generate_summary.start_date"+gp_cnt).value;

			if(tmp_start_date=="" || plan_start_dt=="" )
				return false;
			if(!doDatetimeCheckAlert(tmp_start_date,plan_start_dt)) {
				eval("frmObjBottom.document.generate_summary.start_date"+gp_cnt).value = plan_start_dt;
				await calculateDiagTrgDate();			
			}
			else{
				var fromarray,toarray,fromtime,totime;
				var fromDt,fromDt1;
			
				fromDt = plan_start_dt.split(" ");
				fromarray = fromDt[0].split("/");
				fromtime = fromDt[1].split(":");
				
				fromDt1= plan_target_date.split(" ");		
				toarray = fromDt1[0].split("/");
				totime = fromDt1[1].split(":"); 
				plan_start_date = fromarray[2]+"/"+fromarray[1]+"/"+fromarray[0]+" "+fromtime[0]+":"+fromtime[1];
				plan_tar_date = toarray[2]+"/"+toarray[1]+"/"+toarray[0]+" "+totime[0]+":"+totime[1];
				await calcTarPrd(plan_start_date,plan_tar_date,form_name,"","")
			}	
			gp_cnt = eval(dg_cnt) + eval(gp_cnt);
			if(i <= gp_cnt)
				break;
		}
	}
	return true;
}

async function checkDiagTargetDate(obj,fm_name,change){
	var form_name= fm_name;
	if(form_name=="care_planmanager"){
		var plan_trg_dt = obj.value;
		var frmObjBottom = parent.GeneratePlanType.GeneratePlanTypeBottom;
	}
	else{
		var plan_trg_dt = obj;
		var frmObjBottom = parent.GeneratePlanTypeBottom;
	}
	if(diag_dt == "")
		return false;
	
	var i = frmObjBottom.document.generate_summary.i.value;
	if(i>0){
		var gp_cnt=0;var dg_cnt=0;var dgroup_count =0; var initial_cnt=0;var d_dt="";
		while(gp_cnt >=0){

			dg_cnt= eval("frmObjBottom.document.generate_summary.dgroup_cnt"+gp_cnt).value;
			var diag_dt = eval("frmObjBottom.document.generate_summary.target_date"+gp_cnt).value ;
					
			if(diag_dt=="" || plan_trg_dt=="" )
				return false;
			for(var tt=initial_cnt;tt<gp_cnt;tt++){
				d_dt = eval("frmObjBottom.document.generate_summary.dtarget_date"+tt).value;
			}
			initial_cnt = gp_cnt;
			if(doDatetimeCheckAlert(diag_dt,plan_trg_dt)) {
				if(form_name=="care_planmanager"){
					alert(getMessage("PTARGET_GREATER_DATE","CP"));
					parent.GeneratePlanManager.document.care_planmanager.target_date.value="";	
				//parent.GeneratePlanManager.document.care_planmanager.target_date.focus();
				}
				else{
					if(change == "no_pperiod")
						return true;
					else
						eval("frmObjBottom.document.generate_summary.target_date"+gp_cnt).focus();
				}
				return false;
			}
			else{
				if(fm_name=="generate_summary"){
					var plan_tar_date=eval("frmObjBottom.document.generate_summary.target_date"+gp_cnt).value;
					var plan_start_date=eval("frmObjBottom.document.generate_summary.start_date"+gp_cnt).value;
				}
				else{
					var plan_tar_date=parent.GeneratePlanManager.document.care_planmanager.target_date.value;
					var plan_start_date=parent.GeneratePlanManager.document.care_planmanager.start_date.value;
				}
				var fromarray,toarray,fromtime,totime;
				var fromDt,fromDt1;
				
				if(plan_start_date.length > 0 && plan_tar_date.length > 0 ){
					fromDt = plan_start_date.split(" ");
					fromarray = fromDt[0].split("/");
					fromtime = fromDt[1].split(":");
					
					fromDt1= plan_tar_date.split(" ");		
					toarray = fromDt1[0].split("/");
					totime = fromDt1[1].split(":"); 
					plan_start_date = fromarray[2]+"/"+fromarray[1]+"/"+fromarray[0]+" "+fromtime[0]+":"+fromtime[1];
					plan_tar_date = toarray[2]+"/"+toarray[1]+"/"+toarray[0]+" "+totime[0]+":"+totime[1];
					if(fm_name=="generate_summary"){
						await calcTarPrd(plan_start_date,plan_tar_date,form_name,gp_cnt,change);
					}
					else{
						await calcTarPrd(plan_start_date,plan_tar_date,form_name,"",change);
					}
				}
			}
			gp_cnt = eval(dg_cnt) + eval(gp_cnt);
			if(i <= gp_cnt)
				break;
		}
	}
	return true;
}

async function calculateDiagTrgDate(){
	var frmObjBottom = parent.GeneratePlanType.GeneratePlanTypeBottom;
	var i = frmObjBottom.document.generate_summary.i.value;
	var gp_cnt =0;
	if(i>0){
	
		var dg_cnt=0;var dgroup_count =0; 
		var tmp_grp_cnt=0;
		var gp_cnt = dgroup_count;

		while(gp_cnt >=0){
			dg_cnt= eval("frmObjBottom.document.generate_summary.dgroup_cnt"+gp_cnt).value;
			start_date = eval("frmObjBottom.document.generate_summary.start_date"+gp_cnt).value ;
			
			for(var tmp=tmp_grp_cnt;tmp<dg_cnt;tmp++){
				var tmp_target_dt1 = eval("frmObjBottom.document.generate_summary.dtarget_date"+tmp).value ;
				var tmp_target_prd = eval("frmObjBottom.document.generate_summary.tar_prd"+tmp).value ;
				
				var fromarray;
				var fromDt;
				var timarray;
				var finalDt="";
				if(start_date.length > 0 && tmp_target_dt1.length > 0 ){
					fromDt = start_date.split(" ");
					fromarray = fromDt[0].split("/");
							
					timarray = fromDt[1].split(":");
					
					var dt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
					dt.setTime(dt.getTime()+1000 * 60 * 60 * 24 * parseInt(tmp_target_prd));
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
					finalDt += dt.getFullYear() + " ";
					finalDt += hours + ":";
					finalDt += minutes ;
					eval("frmObjBottom.document.generate_summary.dtarget_date"+tmp).value = finalDt ;
				}
			}
			tmp_grp_cnt = eval(tmp_grp_cnt)+eval(dg_cnt);
			gp_cnt = eval(dg_cnt) + eval(gp_cnt);
			if(i <= gp_cnt)
				break;
		}
		await calculatePlanDiagTargetDate("care_planmanager");
	}
}

function calculatePlanDiagTargetDate(frm_name){
	var frmObjBottom ="";var frmObj ="";
	if(frm_name == "care_planmanager")
		frmObjBottom = parent.GeneratePlanType.GeneratePlanTypeBottom;
	else if(frm_name == "generate_summary")
		frmObjBottom = parent.parent.GeneratePlanType.GeneratePlanTypeBottom;

	var i = frmObjBottom.document.generate_summary.i.value;
	var target_date="",target_prd="";
	var target_dt_arr = new Array();
	var target_prd_arr = new Array();
	var trg_date_arr = new Array();
	var trg_prd_arr = new Array();
	var tmp_target_dt="",tmp_target_prd="",tmp_target_dt1="",tmp_target_prd1="";

	var gcnt="";var target_arr_cnt=0;
	if(i>0){
		var dg_cnt=0;var dgroup_count =0; 
		var tmp_grp_cnt=0;
		var gp_cnt = dgroup_count;

		while(gp_cnt >=0){
			dg_cnt= eval("frmObjBottom.document.generate_summary.dgroup_cnt"+gp_cnt).value;

			for(var tmp=tmp_grp_cnt;tmp<dg_cnt;tmp++){
				tmp_target_dt1 = eval("frmObjBottom.document.generate_summary.dtarget_date"+tmp).value ;
				tmp_target_prd1 = eval("frmObjBottom.document.generate_summary.tar_prd"+tmp).value ;
				trg_date_arr[tmp] = tmp_target_dt1;
				trg_prd_arr[tmp] = tmp_target_prd1;

				if(tmp == tmp_grp_cnt){
					tmp_target_dt = target_date;
					tmp_target_prd = target_prd;
					target_date=tmp_target_dt1 ;
					target_prd=tmp_target_prd1 ; 
				}

				if(trg_date_arr.length >0){
					for(var tmp1=tmp_grp_cnt;tmp1<trg_date_arr.length;tmp1++){
						var fromarray;
						var toarray;
						var fromDt;
						var trPeriod=target_prd;
						var trPd = trg_prd_arr[tmp1];
						var fromdate = target_date;
						var todate =trg_date_arr[tmp1];
						if(fromdate.length > 0 && todate.length > 0 )	{
							fromDt = fromdate.split(" ");
							fromarray = fromDt[0].split("/");
							toDt = todate.split(" ");
							toarray = toDt[0].split("/");

							var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
							var todt = new Date(toarray[2],toarray[1],toarray[0]);
							if(Date.parse(todt) < Date.parse(fromdt)){
								target_date = fromdate;
								target_prd = trPeriod;
							}
							else{
								if(Date.parse(todt) >= Date.parse(fromdt)){
									target_date = todate;
									target_prd = trPd;	
								}
								if(Date.parse(todt) == Date.parse(fromdt))	{
									fromTime = fromDt[1];
									toTime   = toDt[1];
									if(toTime < fromTime){
										target_date = fromdate;
										target_prd = trPeriod;
									}
									else{
										target_date = todate;
										target_prd = trPd;
									}
								}
							}
						}
					}
					tmp_target_dt = target_date;
					tmp_target_prd = target_prd;
				}
			}
			tmp_grp_cnt = eval(tmp_grp_cnt)+eval(dg_cnt);
			var tr_date=eval("frmObjBottom.document.generate_summary.target_date"+gp_cnt).value;
		
			if(tr_date !=""){
				if(!doDatetimeCheckAlert(tr_date,tmp_target_dt)) {
					eval("frmObjBottom.document.generate_summary.target_date"+gp_cnt).value = tmp_target_dt ;
					eval("frmObjBottom.document.generate_summary.target_pd"+gp_cnt).value = tmp_target_prd ;
				}
			}
			else{
				eval("frmObjBottom.document.generate_summary.target_date"+gp_cnt).value = tmp_target_dt ;

				eval("frmObjBottom.document.generate_summary.target_pd"+gp_cnt).value = tmp_target_prd ;
			}
			target_dt_arr[target_arr_cnt]		= tmp_target_dt ;
			target_prd_arr[target_arr_cnt]		= tmp_target_prd ;
			target_arr_cnt++;
			gp_cnt = eval(dg_cnt) + eval(gp_cnt);
			if(i <= gp_cnt)
				break;
		}
		if(target_dt_arr.length > 1){
			for(var tmp1=1;tmp1<target_dt_arr.length;tmp1++){
				var fromarray;
				var toarray;
				var fromDt;
				var trPeriod=target_prd_arr[0];
				var trPd = target_prd_arr[tmp1];
				var fromdate = target_dt_arr[0];
				var todate =target_dt_arr[tmp1];
				if(fromdate.length > 0 && todate.length > 0 ){
					fromDt = fromdate.split(" ");
					fromarray = fromDt[0].split("/");
					toDt = todate.split(" ");
					toarray = toDt[0].split("/");

					var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
					var todt = new Date(toarray[2],toarray[1],toarray[0]);
					if(Date.parse(todt) < Date.parse(fromdt)){
						target_date = fromdate;
						target_prd = trPeriod;
					}
					else	{
						if(Date.parse(todt) >= Date.parse(fromdt)){
							target_date = todate;
							target_prd = trPd;	
						}
						if(Date.parse(todt) == Date.parse(fromdt))	{
							fromTime = fromDt[1];
							toTime   = toDt[1];
							if(toTime < fromTime){
								target_date = fromdate;
								target_prd = trPeriod;
							}
							else{
								target_date = todate;
								target_prd = trPd;
							}
						}
					}
				}
			}
			tmp_target_dt	=  target_date;
			tmp_target_prd  =  target_prd;

		}
		else{
			tmp_target_dt	=  target_dt_arr[0];
			tmp_target_prd  = target_prd_arr[0];
		}

		if(frm_name == "care_planmanager")
			frmObj = parent.GeneratePlanManager;
		else if(frm_name == "generate_summary")
			frmObj = parent.parent.GeneratePlanManager;

		var target_dt = frmObj.document.care_planmanager.target_date.value
		if(!doDatetimeCheckAlert(target_dt,tmp_target_dt)) {
			var target_prd = frmObj.document.care_planmanager.target_pd.value;
			if(parseInt(target_prd)>tmp_target_prd)
				tmp_target_prd = target_prd;
			frmObj.document.care_planmanager.target_pd.value = tmp_target_prd;
			frmObj.document.care_planmanager.target_date.value = tmp_target_dt;
			
		}
	}
}

async function calcTarPrd(start_date,target_date,form_name,index,change){
	st_date = new Date();
	tr_date = new Date();
	dt_diff  = new Date();

	st_datetemp = new Date(start_date);
	st_date.setTime(st_datetemp.getTime());
	tr_datetemp = new Date(target_date);
	tr_date.setTime(tr_datetemp.getTime());

	dt_diff.setTime(Math.abs(st_date.getTime() - tr_date.getTime()));
	timediff = dt_diff.getTime();
	weeks = Math.floor(timediff / (1000 * 60 * 60 * 24 * 7));
	days = Math.floor(timediff / (1000 * 60 * 60 * 24)); 
	timediff -= days * (1000 * 60 * 60 * 24);

	hours = Math.floor(timediff / (1000 * 60 * 60)); 
	timediff -= hours * (1000 * 60 * 60);

	mins = Math.floor(timediff / (1000 * 60)); 
	timediff -= mins * (1000 * 60);

	secs = Math.floor(timediff / 1000); 
	timediff -= secs * 1000;
	var difference = days;
	if(form_name=="care_planmanager"){
		parent.GeneratePlanManager.document.care_planmanager.target_pd.value = days;
	}
	if(form_name=="generate_summary"){
		
		if(parseFloat(index) >=0 && change !="dtarget_prd"){
			if(change == "diff_target_pd")
				eval("parent.GeneratePlanTypeBottom.document.generate_summary.target_pd"+index).value =days ;
		}
		else if(parseFloat(index) >=0 && change =="dtarget_prd"){
			eval("parent.GeneratePlanTypeBottom.document.generate_summary.tar_prd"+index).value =days ;
			eval("parent.GeneratePlanTypeBottom.document.generate_summary.tar_prd_unt"+index).value ="D" ;
		}
		if(change!= "no_pperiod" && change != "dtarget_prd"){
			var plan_tar_date=parent.parent.GeneratePlanManager.document.care_planmanager.target_date.value;
			var plan_start_date=parent.parent.GeneratePlanManager.document.care_planmanager.start_date.value;
			var fromarray,toarray,fromtime,totime;
			var fromDt,fromDt1;
			if(plan_start_date.length > 0 && plan_tar_date.length > 0 ){
				fromDt = plan_start_date.split(" ");
				fromarray = fromDt[0].split("/");
				fromtime = fromDt[1].split(":");
				
				fromDt1= plan_tar_date.split(" ");		
				toarray = fromDt1[0].split("/");
				totime = fromDt1[1].split(":"); 
				plan_start_date = fromarray[2]+"/"+fromarray[1]+"/"+fromarray[0]+" "+fromtime[0]+":"+fromtime[1];
				plan_tar_date = toarray[2]+"/"+toarray[1]+"/"+toarray[0]+" "+totime[0]+":"+totime[1];
				if(index >=0){
					await calcTarPrd(plan_start_date,plan_tar_date,"generate_summary","","no_pperiod");
				}
					
			}
			parent.parent.GeneratePlanManager.document.care_planmanager.target_pd.value = days;
		}
	}
	if( form_name == "gen_preview_details")
		eval("parent.GeneratePlanDetail.document.gen_preview_details.durn_value"+index).value = days ;
}

function checkGRDiagDate(index){
}

async function calcDiagTrgDate(index,obj){
	var plan_start_dt = parent.parent.GeneratePlanManager.document.care_planmanager.start_date.value;
	var frmObjBottom = parent.GeneratePlanTypeBottom;
	var gp_cnt =0;var dg_cnt=0;
	dg_cnt= eval("frmObjBottom.document.generate_summary.dgroup_cnt"+index).value;
	if(dg_cnt>0){
		var tmp_start_date = eval("frmObjBottom.document.generate_summary.start_date"+index).value;

		for(var tmp=index;tmp<dg_cnt;tmp++){
			if(tmp_start_date=="" || plan_start_dt=="" )
				return false;
			if(!doDatetimeCheckAlert(plan_start_dt,tmp_start_date)) {
				var tmp_target_prd = eval("frmObjBottom.document.generate_summary.tar_prd"+tmp).value ;
				if(obj!="AssignGoal_dt"){
					var fromarray;
					var fromDt;
					var timarray;
					var finalDt="";
					if(tmp_start_date.length > 0 && parseFloat(tmp_target_prd)> 0 ){
						fromDt = tmp_start_date.split(" ");
						fromarray = fromDt[0].split("/");
						timarray = fromDt[1].split(":");
						
						var dt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
						dt.setTime(dt.getTime()+1000 * 60 * 60 * 24 * parseInt(tmp_target_prd));
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
						finalDt += dt.getFullYear() + " ";
						finalDt += hours + ":";
						finalDt += minutes ;
						eval("frmObjBottom.document.generate_summary.dtarget_date"+tmp).value = finalDt ;
					}
					else
						eval("frmObjBottom.document.generate_summary.dtarget_date"+tmp).value = tmp_start_date;
				}
			}
			else{
				alert(getMessage("DIAGSTART_LESS_DATE","CP"));
				eval("frmObjBottom.document.generate_summary.start_date"+index).focus();
				return false;
			}	
		}
		var tmp_tar_date = eval("frmObjBottom.document.generate_summary.target_date"+index).value;
		var fromarray,toarray,fromtime,totime;
		var fromDt,fromDt1;
			
		fromDt = tmp_start_date.split(" ");
		fromarray = fromDt[0].split("/");
		fromtime = fromDt[1].split(":");
		fromDt1= tmp_tar_date.split(" ");		
		toarray = fromDt1[0].split("/");
		totime = fromDt1[1].split(":"); 

		plan_start_date = fromarray[2]+"/"+fromarray[1]+"/"+fromarray[0]+" "+fromtime[0]+":"+fromtime[1];
		plan_tar_date = toarray[2]+"/"+toarray[1]+"/"+toarray[0]+" "+totime[0]+":"+totime[1];
			
		await calcTarPrd(plan_start_date,plan_tar_date,"generate_summary",index,"diff_target_pd")
		await calculatePlanDiagTargetDate("generate_summary");
	}
	return true;
}

function showPrevious(obj){
	if(obj == "summary"){
		var fm_name = parent.parent.GeneratePlanType.GeneratePlanTypeBottom.document.forms[0].name;
		if(fm_name == "generazte_summary"){
			var to_proceed ="";
			to_proceed = chkDiagSelected();
			if(!to_proceed)
				return false;
			to_proceed = chkGroupSelected();
			if(!to_proceed)
				return false;
		}
		//parent.parent.document.getElementById("gpParentFrame").rows="0%,0%,*,0%";
		parent.parent.document.getElementById("GeneratePlanManager").style.height="0vh";
	parent.parent.document.getElementById("GeneratePlanProfile").style.height="0vh";
	parent.parent.document.getElementById("GeneratePlanProfile").style.display="none";
	parent.parent.document.getElementById("GeneratePlanType").style.height="100vh";
	parent.parent.document.getElementById("TempFrame").style.height="0vh";
		//parent.document.getElementById("planFrame").rows='0%,70%,0%,0%,5%,0%';
		parent.document.getElementById("GeneratePlanTypeBottom").style.display="none";
		parent.document.getElementById("GeneratePlanDetail").style.display="none";
		parent.document.getElementById("GeneratePlanTypeLinks").style.display="none";
		parent.document.getElementById("GeneratePlanTypeShowBtn").style.display="none";
		parent.document.getElementById("GeneratePlanTypeShowBtn").style.height="0vh";
		parent.document.getElementById("GeneratePlanTypeTop").style="display";
		parent.document.getElementById("GeneratePlanTypeBtn").style="display";
		parent.document.getElementById("GeneratePlanTypeTop").style.height="70vh";
		parent.document.getElementById("GeneratePlanTypeTop").style.width="99vw";
		parent.document.getElementById("GeneratePlanTypeBottom").style.height="0vh";
		parent.document.getElementById("GeneratePlanDetail").style.height="0vh";
		parent.document.getElementById("GeneratePlanTypeBtn").style.height="5vh";
		parent.document.getElementById("GeneratePlanTypeBtn").style.width="99vw";
		parent.document.getElementById("GeneratePlanTypeLinks").style.height="0vh";
		var finalString= "";	
		finalString= parent.GeneratePlanTypeBottom.document.generate_summary.finalStr.value;
		parent.GeneratePlanTypeTop.location.href= "../../eCP/jsp/GCPGeneratePlanTypeTop.jsp?&finalString="+finalString+"&Library=EntireLibrary";
		parent.GeneratePlanTypeBtn.location.href="../../eCP/jsp/GCPGeneratePlanTypeBtn.jsp?&preview=true";
		parent.GeneratePlanTypeBottom.location.href="../../eCP/jsp/GCPGeneratePlanTypeBtn.jsp?&shw_nothing=Nothing";
		parent.GeneratePlanTypeBottom.location.href = "../../eCP/jsp/GCPGeneratePlanShowLibrary.jsp?&obj="+obj; //60772
	}
	else if(obj == "library"){
		var frmPrwObj = parent.parent.GeneratePlanType.GeneratePlanDetail ; 
		var count=frmPrwObj.document.gen_preview_details.count.value;var plan_start_dt="";
		var intervention_code = "";var freq_code="";var durn_type="";var duration= 0;var select_code="";
		var end_date="";var cp_stage="",prior="",postn="",start_date="";var oth_freq="";var freq_val="";
		
		plan_start_dt = parent.parent.GeneratePlanManager.document.care_planmanager.start_date.value;
		for (var tmp = 0;tmp < count ;tmp++ ){
				
			cp_stage = eval("frmPrwObj.document.gen_preview_details.intvn_stage"+tmp).value;
			prior	=eval("frmPrwObj.document.gen_preview_details.prior"+tmp).value;
			postn=eval("frmPrwObj.document.gen_preview_details.postn"+tmp).value;
			start_date=eval("frmPrwObj.document.gen_preview_details.st_date"+tmp).value;
			
			if(!doDatetimeCheckAlert1(start_date,plan_start_dt)){
				eval("frmPrwObj.document.gen_preview_details.st_date"+tmp).focus();
				eval("frmPrwObj.document.gen_preview_details.st_date"+tmp).select();
				return false;
			}
			intervention_code = eval("frmPrwObj.document.gen_preview_details.inter_code"+tmp).value;
			freq_code = eval("frmPrwObj.document.gen_preview_details.freq_code"+tmp).value;
			freq_val = eval("frmPrwObj.document.gen_preview_details.freq_select"+tmp).value;
			if(freq_val.indexOf('*O')!= -1){
				freq_code += "*O";
			}
			duration =  eval("frmPrwObj.document.gen_preview_details.durn_value"+tmp).value;
			durn_type = eval("frmPrwObj.document.gen_preview_details.dur_type"+tmp).value;
			end_date = eval("frmPrwObj.document.gen_preview_details.end_date"+tmp).value;
			if(freq_code == "")
				freq_code=" ";
			if(duration == "")
				duration=" ";
			if(durn_type == "")
				durn_type=" ";
			if(end_date == "")
				end_date=" ";
			if(oth_freq == "")
				oth_freq=" ";
			select_code += intervention_code+"~"+cp_stage+","+prior+","+postn+","+start_date+","+freq_code+","+duration+","+durn_type+","+end_date+","+oth_freq+"`";
		}
		var HtmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'><script></script></head><body class=MESSAGE><form name='tempform' id='tempform' method='post' action='GCPGenerateCarePlanIntermediate.jsp'><input type=hidden name='select_code' id='select_code' value='"+select_code+"'><input type=hidden name='textName' id='textName' value='setInterDetails'></form></body></html>";
		parent.parent.TempFrame.document.write(HtmlVal);
		parent.parent.TempFrame.document.tempform.submit();
		//parent.document.getElementById("planFrame").rows='0%,0%,70%,0%,6%,0%';
		parent.document.getElementById("GeneratePlanTypeBottom").style="display";
		parent.document.getElementById("GeneratePlanTypeBtn").style="display";
		parent.document.getElementById("GeneratePlanTypeShowBtn").style.height="0vh";
		parent.document.getElementById("GeneratePlanTypeTop").style.height="0vh";
		parent.document.getElementById("GeneratePlanTypeBottom").style.height="70vh";
		parent.document.getElementById("GeneratePlanTypeBottom").style.width="99vw";
		parent.document.getElementById("GeneratePlanDetail").style.height="0vh";
		parent.document.getElementById("GeneratePlanTypeBtn").style.height="6vh";
		parent.document.getElementById("GeneratePlanTypeLinks").style.height="0vh";
	
		parent.parent.GeneratePlanManager.document.getElementById("summ_head").style="display";
		parent.parent.GeneratePlanManager.document.getElementById("intvn_head").style.display='none';
		parent.parent.GeneratePlanManager.document.care_planmanager.start_date.readOnly =false;
		parent.parent.GeneratePlanManager.document.care_planmanager.target_pd.readOnly =false;
		parent.parent.GeneratePlanManager.document.care_planmanager.target_date.readOnly =false;
		parent.parent.GeneratePlanManager.document.getElementById("st_cal").disabled =false;
		parent.parent.GeneratePlanManager.document.getElementById("end_cal").disabled =false;
		var finalString= "";	
		finalString=parent.GeneratePlanDetail.document.gen_preview_details.finalStr.value;
		parent.GeneratePlanTypeBottom.location.href="../../eCP/jsp/GCPGeneratePlanShowLibrary.jsp?&finalString="+finalString;
		parent.GeneratePlanTypeBtn.location.href="../../eCP/jsp/GCPGeneratePlanTypeBtn.jsp?&preview=true&show_back=summary";
		parent.GeneratePlanDetail.location.href="../../eCP/jsp/GCPGeneratePlanTypeBtn.jsp?&shw_nothing=Nothing";

	}
	else{
		//parent.parent.document.getElementById("gpParentFrame").rows="0%,*,7%,0%";
		parent.parent.document.getElementById("GeneratePlanManager").style.height="0vh";
	parent.parent.document.getElementById("GeneratePlanProfile").style.height="87vh";
	parent.parent.document.getElementById("GeneratePlanType").style.height="10vh";
	parent.parent.document.getElementById("TempFrame").style.height="0vh";
		//parent.document.getElementById("planFrame").rows='0%,0%,0%,0%,10%,0%';
		parent.document.getElementById("GeneratePlanTypeShowBtn").style.display="none";
	parent.document.getElementById("GeneratePlanTypeTop").style.display="none";
	parent.document.getElementById("GeneratePlanTypeBottom").style.display="none";
	parent.document.getElementById("GeneratePlanDetail").style.display="none";
	parent.document.getElementById("GeneratePlanTypeBtn").style="display";
	parent.document.getElementById("GeneratePlanTypeLinks").style.display="none";
		parent.document.getElementById("GeneratePlanTypeShowBtn").style.height="0vh";
		parent.document.getElementById("GeneratePlanTypeTop").style.height="0vh";
		parent.document.getElementById("GeneratePlanTypeBottom").style.height="0vh";
		parent.document.getElementById("GeneratePlanDetail").style.height="0vh";
		parent.document.getElementById("GeneratePlanTypeBtn").style.height="40vh";
		parent.document.getElementById("GeneratePlanTypeLinks").style.height="0vh";

		parent.GeneratePlanTypeTop.location.href="../../eCommon/html/blank.html";
		parent.GeneratePlanTypeBottom.location.href="../../eCP/jsp/GCPGeneratePlanTypeBtn.jsp?&shw_nothing=Nothing";
		parent.GeneratePlanTypeBtn.location.href="../../eCP/jsp/GCPGeneratePlanTypeBtn.jsp";
	}
}

function showTermCode(index){
	var frmObj = parent.parent.GeneratePlanProfile.GeneratePlanProfileDiagnosis;
	var obj = frmObj.document.getElementById("trmCode_tree"+index).innerText;
	if(obj == "+"){
		frmObj.document.getElementById("term_cd"+index).style="display";
		frmObj.document.getElementById("trmCode_tree"+index).innerHTML="<font size='1' color='#6633FF'><B>--</B></font>";
		
	}else if(obj == "--"){
		frmObj.document.getElementById("term_cd"+index).style.display='none';
		frmObj.document.getElementById("trmCode_tree"+index).innerHTML="<font size='1' color='#6633FF'><B>+</B></font>";
	}
}

function showFactor(index){
	var frmObj = parent.parent.GeneratePlanProfile.GeneratePlanProfileDiagnosis;
	var obj = frmObj.document.getElementById("factCode_tree"+index).innerText;
	if(obj == "+"){
		frmObj.document.getElementById("factor"+index).style="display";
		frmObj.document.getElementById("factCode_tree"+index).innerHTML="<font size='1' color='#6633FF'><B>--</B></font>";
		
	}else if(obj == "--"){
		frmObj.document.getElementById("factor"+index).style.display='none';
		frmObj.document.getElementById("factCode_tree"+index).innerHTML="<font size='1' color='#6633FF'><B>+</B></font>";
	}
}

function showRelatedDiagnosis(index){
	var frmObj = parent.parent.GeneratePlanProfile.GeneratePlanProfileType;
	var obj = frmObj.document.getElementById("CaseCode_tree"+index).innerText;
	if(obj == "+"){
		frmObj.document.getElementById("termcd_desc"+index).style="display";
		frmObj.document.getElementById("CaseCode_tree"+index).innerHTML="<font size='1' color='#6633FF'><B>--</B></font>";
		
	}else if(obj == "--"){
		frmObj.document.getElementById("termcd_desc"+index).style.display='none';
		frmObj.document.getElementById("CaseCode_tree"+index).innerHTML="<font size='1' color='#6633FF'><B>+</B></font>";
	}
}

async function CalDiagnosisTargDt(index){
	var frmObjBottom = parent.GeneratePlanTypeBottom;
	var gp_cnt =0;var dg_cnt=0;
	var tmp=index;	
	var tmp_target_prd = eval("frmObjBottom.document.generate_summary.tar_prd"+tmp).value ;
	var plan_tar_date=eval("frmObjBottom.document.generate_summary.dtarget_date"+tmp).value;
	var plan_start_date=eval("frmObjBottom.document.generate_summary.start_date"+0).value;
	if(plan_tar_date == "")
	{
		eval("frmObjBottom.document.generate_summary.dtarget_date"+tmp).value=eval("frmObjBottom.document.generate_summary.gl_tar_dt"+tmp).value
		return false;
		
	}
	if(!doDatetimeCheckAlert(plan_start_date,plan_tar_date)) {
		var fromarray,toarray,fromtime,totime;
		var fromDt,fromDt1;
		if(plan_start_date.length > 0 && plan_tar_date.length > 0 ){
			fromDt = plan_start_date.split(" ");
			fromarray = fromDt[0].split("/");
			fromtime = fromDt[1].split(":");
			
			fromDt1= plan_tar_date.split(" ");		
			toarray = fromDt1[0].split("/");
			totime = fromDt1[1].split(":"); 
			
			plan_start_date = fromarray[2]+"/"+fromarray[1]+"/"+fromarray[0]+" "+fromtime[0]+":"+fromtime[1];
			plan_tar_date = toarray[2]+"/"+toarray[1]+"/"+toarray[0]+" "+totime[0]+":"+totime[1];
			await calcTarPrd(plan_start_date,plan_tar_date,"generate_summary",tmp,"dtarget_prd");
		}
	}
	else{
		alert(getMessage("GOALTARGET_GREATER_DATE","CP"));
		eval("frmObjBottom.document.generate_summary.dtarget_date"+tmp).focus();
		return false;
	}
	await calculatePlanDiagTargetDate("generate_summary");
	return true;
}

async function setDatesToBean(){
	var frmObjBottom =  parent.parent.GeneratePlanType.GeneratePlanTypeBottom ;
	var lib_id = "",version_no ="",term_set_id ="",term_code ="";
	var dst_dt="",dprd="",dtrg_dt="",gtrg_dt="";
	var sel_key="", sel_dts="";
	var gcnt=0,gout_cnt="";var tmp_gcnt=0;var lmt_cnt=0;
	var i = frmObjBottom.document.generate_summary.i.value;
	var locale=document.generate_summary.locale.value;
	while(tmp_gcnt < i ){
	
		gcnt = eval("frmObjBottom.document.generate_summary.dgroup_cnt"+tmp_gcnt).value;
		lib_id = eval("frmObjBottom.document.generate_summary.library_id"+tmp_gcnt).value;
		version_no =eval("frmObjBottom.document.generate_summary.version_no"+tmp_gcnt).value;
		term_set_id =eval("frmObjBottom.document.generate_summary.term_set_id"+tmp_gcnt).value;
		term_code =eval("frmObjBottom.document.generate_summary.term_code"+tmp_gcnt).value;
		
		dst_dt = eval("frmObjBottom.document.generate_summary.start_date"+tmp_gcnt).value;
		dprd = eval("frmObjBottom.document.generate_summary.target_pd"+tmp_gcnt).value;
		dtrg_dt = eval("frmObjBottom.document.generate_summary.target_date"+tmp_gcnt).value;
		//dst_dt=eval('convertDate(dst_dt,"DMYHM",locale,"en")');
		//dtrg_dt=eval('convertDate(dtrg_dt,"DMYHM",locale,"en")');
		if(dst_dt=="" || dprd=="" || dtrg_dt=="")
			return false;
		if(i == gcnt){
			gcnt = gcnt - lmt_cnt;
		}
		lmt_cnt = eval(tmp_gcnt) + eval(gcnt);
		gtrg_dt = "";
		for(var t1=tmp_gcnt;t1<lmt_cnt;t1++){
			gtrg_dt += convertDate(eval("frmObjBottom.document.generate_summary.dtarget_date"+t1).value,'DMYHM',locale,"en")+"$";
		}
		tmp_gcnt = lmt_cnt;
		if(dst_dt == "")
			dst_dt = " ";
		if(dprd == "")
			dprd = " ";
		if(dtrg_dt == "")
			dtrg_dt = " ";
		if(gtrg_dt == "")
			gtrg_dt = " ";
		
		sel_key +=lib_id+","+version_no+","+term_set_id+","+term_code+"||";
		sel_dts +=convertDate(dst_dt,'DMYHM',locale,"en")+","+dprd+","+convertDate(dtrg_dt,'DMYHM',locale,"en")+","+gtrg_dt+"||";
		
		if(i == lmt_cnt)
			break;
	}
	var HtmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'><script></script></head><body class=MESSAGE><form name='tempform' id='tempform' method='post' action='GCPGenerateCarePlanIntermediate.jsp'><input type=hidden name='selected_key' id='selected_key' value='"+sel_key+"'><input type=hidden name='selected_dates' id='selected_dates' value='"+sel_dts+"'><input type=hidden name='textName' id='textName' value='setDates'></form></body></html>";
	parent.parent.TempFrame.document.write(HtmlVal);
	parent.parent.TempFrame.document.tempform.submit();
	return true;
}

function setPlanDate(){
	var frmObj=parent.GeneratePlanManager.document.care_planmanager;	
	var pract_desc = frmObj.gpcaremanager_desc.value;
	var plan_start_date = frmObj.start_date.value;
	var plan_targ_date = frmObj.target_date.value;				
	var HtmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'><script></script></head><body class=MESSAGE><form name='tempform' id='tempform' method='post' action='GCPGenerateCarePlanIntermediate.jsp'><input type=hidden name='pract_desc' id='pract_desc' value='"+pract_desc+"'><input type=hidden name='plan_start_date' id='plan_start_date' value='"+plan_start_date+"'><input type=hidden name='plan_targ_date' id='plan_targ_date' value='"+plan_targ_date+"'><input type=hidden name='textName' id='textName' value='setPlanDate'></form></body></html>";
	parent.TempFrame.document.write(HtmlVal);
	parent.TempFrame.document.tempform.submit();
}

function calculateEndDt(index,obj,obj1){

	var plan_start_dt = parent.parent.GeneratePlanManager.document.care_planmanager.start_date.value;
	var plan_end_date = parent.parent.GeneratePlanManager.document.care_planmanager.target_date.value;
	var frmObjBottom = parent.GeneratePlanDetail;
	var tmp_start_date ="";
	var tmp_value ="";
	if(eval("frmObjBottom.document.gen_preview_details.st_date"+index)!= undefined)
	{		
		tmp_start_date = eval("frmObjBottom.document.gen_preview_details.st_date"+index).value;		
	}
	if(eval("frmObjBottom.document.gen_preview_details.freq_select"+index)!= undefined)
		tmp_value=eval("frmObjBottom.document.gen_preview_details.freq_select"+index).value;
	if(doDatetimeCheckAlert1(tmp_start_date,plan_start_dt)) {
		if(eval("frmObjBottom.document.gen_preview_details.durn_value"+index)!= undefined)
			var tmp_target_prd = eval("frmObjBottom.document.gen_preview_details.durn_value"+index).value ;
		var fromarray;
		var fromDt;
		var timarray;
		var finalDt="";
		var durnUnit;
		if(tmp_start_date.length > 0 && parseFloat(tmp_target_prd)>= 0){
			fromDt = tmp_start_date.split(" ");
			fromarray = fromDt[0].split("/");
			timarray = fromDt[1].split(":");
			durnUnit = tmp_value.split(",");
			if(eval("frmObjBottom.document.gen_preview_details.durn_type"+index)!= undefined)
			{
				if(durnUnit[0] =='*O'){
					durnUnit[2] = eval("frmObjBottom.document.gen_preview_details.durn_type"+index).value;
				}
				if(obj1 == 'dur_type'){
					durnUnit[2] = eval("frmObjBottom.document.gen_preview_details.dur_type"+index).value;
					eval("frmObjBottom.document.gen_preview_details.durn_type"+index).value=durnUnit[2] ;
				}
			}
			var dt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
			dt.setHours(timarray[0], timarray[1]);
			if(durnUnit[2] ==  'D'){
				dt.setTime(dt.getTime()+1000 * 60 * 60 * 24 * parseInt(tmp_target_prd));
			}
			else if(durnUnit[2] ==  'W'){
				tmp_target_prd = tmp_target_prd * 7;
				dt.setTime(dt.getTime()+1000 * 60 * 60 * 24 * parseInt(tmp_target_prd));
			}
			else if(durnUnit[2] ==  'L'){
				dt.setMonth(dt.getMonth()+eval(tmp_target_prd))
			}
			else if(durnUnit[2] ==  'H'){
				timarray[0]=dt.getHours()+parseInt(tmp_target_prd);
				dt.setHours(timarray[0], timarray[1]);
			}
			else if(durnUnit[2] ==  'M'){
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
			finalDt += dt.getFullYear() + " ";
			finalDt += hours + ":";
			finalDt += minutes ;
			if(eval("frmObjBottom.document.gen_preview_details.end_date"+index)!= undefined)
			{
				if(!doDatetimeCheckAlert(finalDt,plan_end_date)) 
				{				
						eval("frmObjBottom.document.gen_preview_details.end_date"+index).value = finalDt ;
				}
				else{
					if(obj == true){
						if(finalDt !=""){
							parent.parent.GeneratePlanManager.document.care_planmanager.target_date.value = finalDt;
							eval("frmObjBottom.document.gen_preview_details.end_date"+index).value = finalDt ;
							parent.parent.GeneratePlanManager.document.care_planmanager.target_date.focus();
						}
					}
					else{
						parent.parent.GeneratePlanManager.document.care_planmanager.target_date.value = finalDt;
						eval("frmObjBottom.document.gen_preview_details.end_date"+index).value = finalDt ;
						parent.parent.GeneratePlanManager.document.care_planmanager.target_date.focus();
					}
				}
			}
		}		
	}
	else{
		alert(getMessage("INTVN_START_DATE","CP"));
		return false;
	}	
	return true;		
}

function chkDate(obj,index){
	if(obj.value != ''){
		var plan_start_dt = parent.parent.GeneratePlanManager.document.care_planmanager.start_date.value;
		var plan_end_date = parent.parent.GeneratePlanManager.document.care_planmanager.target_date.value;
		var frmObjBottom = parent.GeneratePlanDetail;
		var tmp_start_date = eval("frmObjBottom.document.gen_preview_details.st_date"+index).value;
		var tmp_value=eval("frmObjBottom.document.gen_preview_details.freq_select"+index).value;

		if(doDatetimeCheckAlert1(tmp_start_date,plan_start_dt)){
			var tmp_target_prd = eval("frmObjBottom.document.gen_preview_details.durn_value"+index).value ;
			var fromarray;
			var fromDt;
			var timarray;
			var durnUnit;
			var finalDt="";
			if(tmp_start_date.length > 0 && parseFloat(tmp_target_prd)>= 0 ){
				fromDt = tmp_start_date.split(" ");
				fromarray = fromDt[0].split("/");
						
				timarray = fromDt[1].split(":");
				
				durnUnit = tmp_value.split(",");
				if(durnUnit[0] =='*O'){
					durnUnit[1] = eval("frmObjBottom.document.gen_preview_details.durn_type"+index).value;
				}
				var dt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
				dt.setHours(timarray[0], timarray[1]);
				if(durnUnit[1] ==  'D'){
					dt.setTime(dt.getTime()+1000 * 60 * 60 * 24 * parseInt(tmp_target_prd));
				}
				else if(durnUnit[1] ==  'W'){
						tmp_target_prd = tmp_target_prd * 7;
						dt.setTime(dt.getTime()+1000 * 60 * 60 * 24 * parseInt(tmp_target_prd));
				}
				else if(durnUnit[1] ==  'L'){
					tmp_target_prd = tmp_target_prd * 30
					dt.setTime(dt.getTime()+1000 * 60 * 60 * 24 * parseInt(tmp_target_prd));
				}
				else if(durnUnit[1] ==  'H'){
					timarray[0]=dt.getHours()+parseInt(tmp_target_prd);
					dt.setHours(timarray[0], timarray[1]);
				}else if(durnUnit[1] ==  'M'){
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
				finalDt += dt.getFullYear() + " ";
				finalDt += hours + ":";
				finalDt += minutes ;
				
				if(!doDatetimeCheckAlert(finalDt,plan_end_date)) 
					eval("frmObjBottom.document.gen_preview_details.end_date"+index).value = finalDt ;
				else{
					eval("frmObjBottom.document.gen_preview_details.end_date"+index).value = finalDt ;
					parent.parent.GeneratePlanManager.document.care_planmanager.target_date.value= finalDt ;
					parent.parent.GeneratePlanManager.document.care_planmanager.target_date.focus();
				}
			}
		}
		else{
			alert(getMessage("INTVN_START_DATE","CP"));
			eval("frmObjBottom.document.gen_preview_details.st_date"+index).value=plan_start_dt;
			return false;
		}
	}
	return true;
}

function retFocus(obj,index){
	var frmObjBottom = parent.GeneratePlanDetail;
	if(obj== "st_date")
		eval("frmObjBottom.document.gen_preview_details.st_date"+index).focus();
	else if(obj== "end_date")
		eval("frmObjBottom.document.gen_preview_details.end_date"+index).focus();
}

function chkEndDate(index){

	var plan_start_dt = parent.parent.GeneratePlanManager.document.care_planmanager.start_date.value;
	var plan_end_date = parent.parent.GeneratePlanManager.document.care_planmanager.target_date.value;
	var frmObjBottom = parent.GeneratePlanDetail;
	var tmp_start_date = eval("frmObjBottom.document.gen_preview_details.st_date"+index).value;
	var tmp_end_date = eval("frmObjBottom.document.gen_preview_details.end_date"+index).value;
	if(tmp_end_date == "")
		return false;
	if(!doDatetimeCheckAlert1(tmp_end_date,tmp_start_date)){
		alert(getMessage("INTVN_END_DATE","CP"));
		eval("frmObjBottom.document.gen_preview_details.end_date"+index).focus();
		eval("frmObjBottom.document.gen_preview_details.end_date"+index).select();
		return false;
	}
	if(doDatetimeCheckAlert(plan_end_date,tmp_end_date)){
		var tmp_target_prd = eval("frmObjBottom.document.gen_preview_details.durn_value"+index).value ;
		var fromarray,toarray,fromtime,totime;
		var fromDt,fromDt1;
			
		fromDt = tmp_start_date.split(" ");
		fromarray = fromDt[0].split("/");
		fromtime = fromDt[1].split(":");
		
		fromDt1= tmp_end_date.split(" ");		
		toarray = fromDt1[0].split("/");
		totime = fromDt1[1].split(":"); 
		plan_start_date = fromarray[2]+"/"+fromarray[1]+"/"+fromarray[0]+" "+fromtime[0]+":"+fromtime[1];
		plan_tar_date = toarray[2]+"/"+toarray[1]+"/"+toarray[0]+" "+totime[0]+":"+totime[1];
			
		st_date = new Date();
		tr_date = new Date();
		dt_diff  = new Date();

		st_datetemp = new Date(plan_start_date);
		st_date.setTime(st_datetemp.getTime());

		tr_datetemp = new Date(plan_tar_date);
		tr_date.setTime(tr_datetemp.getTime());

		dt_diff.setTime(Math.abs(st_date.getTime() - tr_date.getTime()));
		timediff = dt_diff.getTime();
		strMonth = toarray[1];
		strYear = toarray[2];
		month="";
		if  (strMonth == 1 || strMonth == 3 || strMonth == 5 || strMonth == 7 || strMonth == 8 || strMonth == 10 || strMonth == 12)
		  month = 31;
		else if (strMonth == 4 || strMonth == 6 || strMonth == 9 || strMonth == 11)
			month = 30;
		else if (strMonth == 2) {
			if (LeapYear(strYear) == true) 
				month = 29;
			else
				month = 28;
		}
		months = Math.floor(timediff / (1000 * 60 * 60 * 24 * month));
		weeks = Math.floor(timediff / (1000 * 60 * 60 * 24 * 7));
		days = Math.floor(timediff / (1000 * 60 * 60 * 24)); 
		hours = Math.floor(timediff / (1000 * 60 * 60)); 
		mins = Math.floor(timediff / (1000 * 60)); 
		secs = Math.floor(timediff / 1000); 

		var durn_length=eval("parent.GeneratePlanDetail.document.gen_preview_details.dur_type"+index).length;
		var sel_index=-1;
		if(parseFloat(mins) <= 99){
			for(i=0;i<durn_length;i++){
				if(eval("frmObjBottom.document.gen_preview_details.durn_type"+index).options[i].value == 'M'){
					sel_index=i;
					break;
				}
			}
			if(sel_index >=0){
				eval("parent.GeneratePlanDetail.document.gen_preview_details.durn_value"+index).value = mins ;
				eval("parent.GeneratePlanDetail.document.gen_preview_details.dur_type"+index).selectedIndex = sel_index ;
				//eval("frmObjBottom.document.gen_preview_details.durn_type"+index).value='M';
			}
		}
		else if(parseFloat(hours) <= 99){
			for(i=0;i<durn_length;i++){
				if(eval("frmObjBottom.document.gen_preview_details.dur_type"+index).options[i].value == 'H'){
					sel_index=i;
					break;
				}
			}
			if(sel_index >=0){
				eval("parent.GeneratePlanDetail.document.gen_preview_details.durn_value"+index).value = hours ;
				eval("parent.GeneratePlanDetail.document.gen_preview_details.dur_type"+index).selectedIndex = sel_index ;
				//eval("frmObjBottom.document.gen_preview_details.durn_type"+index).value='H';
			}
		}
		else if(parseFloat(days) <= 99){
			for(i=0;i<durn_length;i++){
				if(eval("frmObjBottom.document.gen_preview_details.dur_type"+index).options[i].value == 'D'){
					sel_index=i;
					break;
				}
			}
			if(sel_index >=0){
				eval("parent.GeneratePlanDetail.document.gen_preview_details.durn_value"+index).value = days ;
				eval("parent.GeneratePlanDetail.document.gen_preview_details.dur_type"+index).selectedIndex = sel_index ;
				//eval("frmObjBottom.document.gen_preview_details.durn_type"+index).value='D';
			}
		}
		else if(parseFloat(weeks) <= 99){
			for(i=0;i<durn_length;i++){
				if(eval("frmObjBottom.document.gen_preview_details.dur_type"+index).options[i].value == 'W'){
					sel_index=i;
					break;
				}
			}
			if(sel_index >=0){
				eval("parent.GeneratePlanDetail.document.gen_preview_details.durn_value"+index).value = weeks ;
				eval("parent.GeneratePlanDetail.document.gen_preview_details.dur_type"+index).selectedIndex = sel_index ;
				//eval("frmObjBottom.document.gen_preview_details.durn_type"+index).value='W';
			}
		}
		else if(parseFloat(months) <= 99){
			for(i=0;i<durn_length;i++){
				if(eval("frmObjBottom.document.gen_preview_details.dur_type"+index).value == 'L'){
					sel_index=i;
					break;
				}
			}
			if(sel_index >=0){
				eval("parent.GeneratePlanDetail.document.gen_preview_details.durn_value"+index).value = months ;
				eval("parent.GeneratePlanDetail.document.gen_preview_details.dur_type"+index).selectedIndex = sel_index ;
				//eval("frmObjBottom.document.gen_preview_details.durn_type"+index).value='L';	
			}
		}
		if(sel_index < 0){
			eval("parent.GeneratePlanDetail.document.gen_preview_details.dur_type"+index).selectedIndex = 0 ;
			var durn_unit=eval("parent.GeneratePlanDetail.document.gen_preview_details.dur_type"+index).value;
			switch(durn_unit){
				case 'M':
					eval("parent.GeneratePlanDetail.document.gen_preview_details.durn_value"+index).value=mins;
					break;
				case 'H':
					eval("parent.GeneratePlanDetail.document.gen_preview_details.durn_value"+index).value = hours ;
					break;
				case 'D':
					eval("parent.GeneratePlanDetail.document.gen_preview_details.durn_value"+index).value = days ;
					break;
				case 'W':
					eval("parent.GeneratePlanDetail.document.gen_preview_details.durn_value"+index).value = weeks ;
					break;
				case 'L':
					eval("parent.GeneratePlanDetail.document.gen_preview_details.durn_value"+index).value = months ;
					break;

			}
			//eval("frmObjBottom.document.gen_preview_details.durn_type"+index).value='W';
			//eval("parent.GeneratePlanDetail.document.gen_preview_details.durn_value"+index).value = weeks ;
		}
			eval("parent.GeneratePlanDetail.document.gen_preview_details.durn_value"+index).focus() ;
		var difference = days;
	}
	else{
		if(tmp_end_date != ""){
			parent.parent.GeneratePlanManager.document.care_planmanager.target_date.value = tmp_end_date;
			parent.parent.GeneratePlanManager.document.care_planmanager.target_date.focus();
		}
	}
	return true;
}

async function show_frequency_window(){
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	
	argumentArray[0]   = parent.GeneratePlanDetail.document.gen_preview_details.freq_sql.value;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";//positionVal
	argumentArray[5]   = "" ;
	argumentArray[6]   = CODE_LINK ;//linkFields
	argumentArray[7]   = CODE_DESC ;//Display Order

	retVal = await CommonLookup( getLabel("Common.Frequency.label","Common"), argumentArray );
	return retVal;
}

function chkStage(fm_name){
	var frmObj="",frmDtl="";
	if(fm_name == "care_planmanager" ){
		frmObj= parent.GeneratePlanManager;
		frmDtl= parent.GeneratePlanType.GeneratePlanDetail;
		fm_name = parent.GeneratePlanType.GeneratePlanDetail.document.forms[0].name;
	}
	else{
		frmObj= parent.parent.GeneratePlanManager;
		frmDtl= parent.GeneratePlanDetail;
		fm_name = parent.GeneratePlanDetail.document.forms[0].name;
	}
	var stage_val = frmObj.document.care_planmanager.cp_stage.value ;
	
	if(fm_name == "gen_preview_details"){
		var i = frmDtl.document.gen_preview_details.count.value;
		if( i > 0){
			var option_val="";var optn_length;
			if(eval("frmDtl.document.gen_preview_details.intvn_stage"+tmp)!= undefined)
			{
				for(var tmp=0;tmp<i;tmp++){
					if(stage_val != '*A' ){					
						optn_length = eval("frmDtl.document.gen_preview_details.intvn_stage"+tmp).options.length;
						for(var j=0; j<optn_length; j++){
							option_val = eval("frmDtl.document.gen_preview_details.intvn_stage"+tmp).options[j].value;
							if(stage_val == option_val){
								eval("frmDtl.document.gen_preview_details.intvn_stage"+tmp).options[j].selected = selected ;
								break;
							}
						}
						eval("frmDtl.document.gen_preview_details.intvn_stage"+tmp).disabled = true;
					}
					else{
						eval("frmDtl.document.gen_preview_details.intvn_stage"+tmp).disabled= false;
					}
				}
			}
		}
	}
}

function chkDiagSelected(){
	var frmObjBottom =  parent.parent.GeneratePlanType.GeneratePlanTypeBottom ;
	var gcnt="";var tmp_gcnt=0;var lmt_cnt=0;var grp_flag=false;
	var i = frmObjBottom.document.generate_summary.i.value;

	while(tmp_gcnt < i ){
		gcnt = eval("frmObjBottom.document.generate_summary.dgroup_cnt"+tmp_gcnt).value;
		if(i == gcnt){
			gcnt = gcnt - lmt_cnt;
		}
		lmt_cnt = eval(tmp_gcnt) + eval(gcnt);
		gtrg_dt = "";
		grp_flag=false;
		
		for(var t1=tmp_gcnt;t1<lmt_cnt;t1++){
			if(eval("frmObjBottom.document.generate_summary.chk_goal"+t1).checked == true){
				grp_flag=true;
				break;
			}
			else
				grp_flag=false;
		}
		if(grp_flag == false){
			alert(getMessage("GOAL_PER_DIAGNOSIS","CP"));
			return false;
			break;
		}
		tmp_gcnt = lmt_cnt;
		if(i == lmt_cnt)
			break;
	}
	return true;
}

/**************************************************************************/
async function addInterventions(diag_code, goal_code, library_id,version_no, term_set_id, term_code, target_date){
	var frmObj=parent.frames[2].document.forms[0];
	var sel_lib_ids=frmObj.sel_lib_ids.value;
	var dialogHeight ='50vh' ;
	var dialogWidth = '50vw' ;
	var dialogTop	= '10';
	var dialogLeft = '10' ;
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';
	var arguments = "";
	var url="../../eCP/jsp/GCPGenerateCarePlanAddInterventionsFrameset.jsp?diag_code="+diag_code+"&goal_code="+goal_code+"&library_id="+library_id+"&version_no="+version_no+"&term_set_id="+term_set_id+"&term_code="+term_code+"&target_date="+target_date+"&sel_lib_ids="+sel_lib_ids;
	var retVal = await top.window.showModalDialog(url,arguments,features);
}

/*************************************************/
async function selectIntvn(call_mode, target, sel_libs, term_set_id, term_code){
	var count=parseInt(parent.frames[1].document.forms[0].intvn_count.value);
	if(count<10){

		var frmObj=document.forms[0];
		var desc=target.value;
		if((call_mode='T')&&(desc=''))
			return false;
		if(frmObj.intvn_code.value !=""){
			frmObj.intvn_code.value="";
			frmObj.intvn_desc.value="";
		}
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		if(sel_libs=="")
			sel_lib="\'\'";
		for(i=0;i<sel_libs.length;i++)
			sel_libs=sel_libs.replace('~',"'");
		argumentArray[0]="select intervention_code code,short_desc description from ca_intervention a where intervention_code not in (select intervention_code from cp_library_intervention where library_id||version_no in ("+sel_libs+") and term_set_id='"+term_set_id+"' and term_code='"+term_code+"' ) and eff_status = 'E'  AND EXISTS (SELECT b.intervention_code FROM ca_intervention_freq b WHERE b.intervention_code = a.intervention_code) AND UPPER (intervention_code) LIKE UPPER (?) AND UPPER (short_desc) LIKE UPPER (?) ORDER BY short_desc";
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2"; 
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_DESC_LINK;//CODE_LINK
		argumentArray[7] = CODE_DESC;//CODE_DESC
		retVal = await CommonLookup(getLabel("eCP.CaseType.label","CP"), argumentArray );
		var str =unescape(retVal);
		var arr = str.split(",");
		if(retVal != null && retVal != "") {
			target.value = arr[1] ;
			var intvn_desc= arr[1] ;
			frmObj.intvn_code.value = arr[0];
		}
	}
}

/************************************************/
function Close(){
	window.close();
}

/************************************************/
function addIntvn(library_id, version_no, term_set_id, term_code, goal_code, target_date){
	var intvn_code=document.forms[0].intvn_code.value;
	var intvn_desc=document.forms[0].intvn_desc.value;
	var intvn_groupID=document.forms[0].intvn_groupID.value;
	if(intvn_code != ''){
		var count=parseInt(parent.frames[1].document.forms[0].intvn_count.value);
		if(count<10){
			parent.frames[1].document.getElementById("intvn"+count).style='display';
			parent.frames[1].document.getElementById("intvn_desc"+count).innerText=intvn_desc;
			eval("parent.frames[1].document.forms[0].intvn_code"+count).value=intvn_code;
			eval("parent.frames[1].document.forms[0].intvn_groupID"+count).value=intvn_groupID;
			eval("parent.frames[1].document.forms[0].intvn_chk"+count).checked=true;
			count++;
			parent.frames[1].document.forms[0].intvn_count.value=count;
			document.forms[0].intvn_code.value='';
			document.forms[0].intvn_desc.value='';

			var intervention_code="";
			for(var tmp=0;tmp<count;tmp++){	
				if(eval("parent.frames[1].document.forms[0].intvn_chk"+tmp).checked==true){
					goal_flag = true;
					tmp_intervention_code = eval("parent.frames[1].document.forms[0].intvn_code"+tmp).value;
					group_id = eval("parent.frames[1].document.forms[0].intvn_groupID"+tmp).value;
					intervention_code += tmp_intervention_code+"*"+group_id+"|";
				}		
			}
			selected_diag =  "#"+library_id+","+version_no+","+term_set_id+","+term_code+","+goal_code+"," ;
			selected_diag_val	=intervention_code+"~";
			if(intervention_code == " " )
					selected_diag_val= "";

			var HtmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'><script></script></head><body class=MESSAGE><form name='tempform' id='tempform' method='post' action='GCPGenerateCarePlanIntermediate.jsp'><input type=hidden name='selected_diag' id='selected_diag' value='"+selected_diag+"'><input type=hidden name='selected_diag_val' id='selected_diag_val' value='"+selected_diag_val+"'><input type=hidden name='intvn_code' id='intvn_code' value='"+intervention_code+"'><input type=hidden name='textName' id='textName' value='setSelectedGenIntvn'></form></body></html>";
			parent.Dummy.document.write(HtmlVal);
			parent.Dummy.document.tempform.submit();
		}
	}
}

/************************************************/
function clearIntvns(library_id, version_no, term_set_id, term_code, goal_code, target_date){
	document.forms[0].reset();
	parent.frames[1].location.href='../../eCP/jsp/GCPGenerateCarePlanAddInterventionsResult.jsp';

	var selected_diag =  "#"+library_id+","+version_no+","+term_set_id+","+term_code+","+goal_code+"," ;
	var selected_diag_val= "";

	var HtmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'><script></script></head><body class=MESSAGE><form name='tempform' id='tempform' method='post' action='GCPGenerateCarePlanIntermediate.jsp'><input type=hidden name='selected_diag' id='selected_diag' value='"+selected_diag+"'><input type=hidden name='selected_diag_val' id='selected_diag_val' value='"+selected_diag_val+"'><input type=hidden name='textName' id='textName' value='setSelectedGenIntvn'></form></body></html>";
	parent.Dummy.document.write(HtmlVal);
	parent.Dummy.document.tempform.submit();
}

/*************************************************/
function addRemoveIntvn(index,library_id, version_no, term_set_id, term_code, goal_code, target_date){
	var count=parseInt(parent.frames[1].document.forms[0].intvn_count.value);
	var intervention_code="";
	for(var tmp=0;tmp<count;tmp++){	
		if(eval("parent.frames[1].document.forms[0].intvn_chk"+tmp).checked==true){
			goal_flag = true;
			tmp_intervention_code = eval("parent.frames[1].document.forms[0].intvn_code"+tmp).value;
			group_id = eval("parent.frames[1].document.forms[0].intvn_groupID"+tmp).value;
			intervention_code += tmp_intervention_code+"*"+group_id+"|";
		}		
	}
	selected_diag =  "#"+library_id+","+version_no+","+term_set_id+","+term_code+","+goal_code+"," ;
	selected_diag_val	=intervention_code+"~";
	if(intervention_code == " " )
			selected_diag_val= "";

	var HtmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'><script></script></head><body class=MESSAGE><form name='tempform' id='tempform' method='post' action='GCPGenerateCarePlanIntermediate.jsp'><input type=hidden name='selected_diag' id='selected_diag' value='"+selected_diag+"'><input type=hidden name='selected_diag_val' id='selected_diag_val' value='"+selected_diag_val+"'><input type=hidden name='intvn_code' id='intvn_code' value='"+intervention_code+"'><input type=hidden name='textName' id='textName' value='setSelectedGenIntvn'></form></body></html>";
	parent.Dummy.document.write(HtmlVal);
	parent.Dummy.document.tempform.submit();
}

