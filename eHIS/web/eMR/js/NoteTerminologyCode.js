var lookup_string ="";
var gb_trm_code = "";
var gb_term_code_associated="";
var gb_Db_term_code = "";
var gb_chkValues = "";//Maheshwaran K added for PMG2014-MOD-CRF-0004 
var gb_returnVal2 = "";//Maheshwaran K added for PMG2014-MOD-CRF-0004 

var function_id="NoteTerminologyCode";
var message="";
var qry_string="";
function create() {
	f_query_add_mod.location.href = "../../eMR/jsp/NoteTerminologyCodeAddModify.jsp?mode=1&function_id="+function_id ;
}

function query() {
	f_query_add_mod.location.href='../../eMR/jsp/NoteTerminologyCodeQueryCriteria.jsp?function_id='+function_id ;
}

function checkIsValidForProceed()
{
	 var url = f_query_add_mod.location.href;
	 url = url.toLowerCase();
	 if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
		  return true;
	 else
		  return false;
}
function apply() {

	if (! checkIsValidForProceed() ) {

		message  = getMessage("APPLY_NOT_VALID",'MR');
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		message=""; /* To empty message string */
		return false ;
	}
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
	var formObj = f_query_add_mod.term_set.document.note_terminology ;
	var fields = new Array ( formObj.service_code  
							 ,formObj.proc_code  
							 ,formObj.term_set  
							   
						);

	var names = new Array ( getLabel("Common.ServiceCode.label","Common")
							,getLabel("Common.note.label","Common")
							,getLabel("Common.TerminologySet.label","Common")
				);	
   
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {
		
		var frmObj=f_query_add_mod.term_associated.document ;
		var ftmTopObj = f_query_add_mod.term_set.document.getElementById('note_terminology') ;
		var qry_string ="";
		qry_string += "service_code="+ftmTopObj.service_code.value+"&service_desc="+ftmTopObj.service_desc.value+"&note_type="+ftmTopObj.proc_code.value+"&note_type_desc="+ftmTopObj.proc_desc.value+"&term_set="+ftmTopObj.term_set_id.value+"&term_set_desc="+ftmTopObj.term_set_desc.value+"&level="+ftmTopObj.lvl.value ;
		//qry_string += "&service_code="+d.getElementById("service_code").value+"&service_desc="+ftmTopObj.getElementById("service_desc").value+"&note_type="+ftmTopObj.getElementById("proc_code").value+"&note_type_desc="+ftmTopObj.getElementById("proc_desc").value+"&term_set="+ftmTopObj.getElementById("term_set_id").value+"&term_set_desc="+ftmTopObj.getElementById("term_set_desc").value+"&level="+ftmTopObj.getElementById("lvl").value ;
		var cnt = f_query_add_mod.term_associated.document.term_code_associated.totalRecords.value;
		if(f_query_add_mod.term_associated.document.getElementById('tbl_term_code0').innerText == ' ' && f_query_add_mod.term_associated.document.getElementById('term_code_desc0').innerText==' '){
			message = getMessage("TERM_CODE_LEVEL_1_IS_MANDATORY",'MR');
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message;
			message = ""; /* To empty message string */
			return false;
		}
		var flag= false;
		for(var i=0;i<cnt;i++){
			var code_val = eval("frmObj.term_code_associated.code_level"+i).value;
			if(code_val == 1){
				if(eval("frmObj.term_code_associated.term_chk"+i).checked){
					flag = true;
				}
			}if(flag)
				break;
		}
		if(!flag){
			message = getMessage("TERM_CODE_LEVEL_1_IS_MANDATORY",'MR');
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message;
			message = "";
			return false;
		}
		f_query_add_mod.term_associated.document.term_code_associated.action="../../servlet/eMR.NoteTerminologyCode"; 
		f_query_add_mod.term_associated.document.term_code_associated.target="messageFrame";
		f_query_add_mod.term_associated.document.term_code_associated.submit();
	}
}

function onSuccess() {
	var mode = f_query_add_mod.term_associated.document.term_code_associated.mode.value;
	if( mode == "1" ) {
		f_query_add_mod.location.href = "../../eMR/jsp/NoteTerminologyCodeAddModify.jsp?mode=1&function_id="+function_id ;
	}
	if(mode == "2"){
		frames[1].term_associated.location.href='../../eMR/jsp/NoteTerminologyCodeSingle.jsp?mode='+mode+'&level='+f_query_add_mod.term_set.note_terminology.lvl.value+"&term_set="+f_query_add_mod.term_set.note_terminology.term_set_id.value+"&service_code="+f_query_add_mod.term_set.note_terminology.service_code.value+"&note_type="+f_query_add_mod.term_set.note_terminology.proc_code.value ;
	}
}

function reset() {
	var loc=frames[1].document.forms[0];
	var href;
	if(loc!=null)
	{
		parent.frames[2].frames[1].document.location.reload();
		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
		//href=loc.document.location.href;
		href="";
		//href=href.toLowerCase();
		if(href.indexOf("criteria.jsp")!=-1) 
		{
			frames[1].document.forms[0].document.location.reload();
		}
		else 
			if(href.indexOf("result.jsp")!=-1)
			{
			}
	}
	else
	{
		var loc1=f_query_add_mod.document.location.href;
		loc1=loc1.toLowerCase();
		if(!(loc1.indexOf("blank")==-1))
		{
		}
		else if(loc1.indexOf("addmodify")!=-1)
		{
			if(f_query_add_mod.term_associated.document.location.href!=null)
			{
				var loc2=f_query_add_mod.term_associated.document.location.href;
				var obj=f_query_add_mod.term_set.document.note_terminology;
				if(loc2.indexOf("blank")!=-1)
				{
					obj.reset();
				}
				else if(loc2!=null)
				{
			    	var mode=obj.mode.value;
				    if(mode=="1")
					{				
						f_query_add_mod.document.location.href='../../eMR/jsp/NoteTerminologyCodeAddModify.jsp?mode=1';
						f_query_add_mod.term_associated.location.href='../../eCommon/html/blank.html'
					}
					else if (mode=="2")
					{
//					   f_query_add_mod.frames[0].document.forms[0].reset();
						frames[1].term_associated.location.href='../../eMR/jsp/NoteTerminologyCodeSingle.jsp?mode='+mode+'&level='+f_query_add_mod.term_set.note_terminology.lvl.value+"&term_set="+f_query_add_mod.term_set.note_terminology.term_set_id.value+"&service_code="+f_query_add_mod.term_set.note_terminology.service_code.value+"&note_type="+f_query_add_mod.term_set.note_terminology.proc_code.value ;
					}
				}
			}
		}
	}
	messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp' ;
}

async function departLookup(target){	
		var frmObj=document.note_terminology;
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;

		argumentArray[0] = frmObj.sql_dept.value;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_LINK ;//CODE_LINK
		argumentArray[7] = CODE_DESC ;//CODE_DESC

		retVal = await CommonLookup(getLabel("Common.department.label","Common"), argumentArray );
		
		if(retVal != null && retVal != "" )
		{
			//eval("frmObj.discr_msr_id"+index).value = retVal[0];
			target.value = retVal[1];
			frmObj.dept_code.value = retVal[0];

		}else
		{
			target.value = "";
			frmObj.dept_code.value = "";
			
		}
}

async function serviceLookup(target,validate_text)
{	
	var frmObj=document.note_terminology;
	if(target.value == '' && validate_text == 'N')
		return false;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

	argumentArray[0] = frmObj.sql_service.value;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_LINK ;//CODE_LINK
	argumentArray[7] = CODE_DESC ;//CODE_DESC

	retVal = await CommonLookup(getLabel("Common.service.label","Common"), argumentArray );
	
	if(retVal != null && retVal != "" )
	{
//		console.log("Here") ;
//		console.log(retVal) ;
		//eval("frmObj.discr_msr_id"+index).value = retVal[0];
		target.value = retVal[0].split(',')[1];
		frmObj.service_code.value = retVal[0].split(',')[0];

	}else
	{
		target.value = "";
		frmObj.service_code.value = "";
		
	}
	
}

async function procLookup(target)
{	
	var frmObj=document.note_terminology;

		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;

		argumentArray[0] = frmObj.sql_proc_note.value;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_LINK ;//CODE_LINK
		argumentArray[7] = CODE_DESC ;//CODE_DESC

		retVal = await CommonLookup(getLabel("Common.Procedure.label","Common")+' '+getLabel("Common.note.label","Common"), argumentArray );
		
		if(retVal != null && retVal != "" ){
			frmObj.proc_code.value = retVal[0].split(',')[0];
			target.value = retVal[0].split(',')[1];
			}else{
			target.value = "";
			frmObj.proc_code.value = "";
		}
}
async function levelLookup(target,index)
{	
	var frmObj=document.terminology_level;

		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;

		argumentArray[0] = frmObj.sql_level.value;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_LINK ;//CODE_LINK
		argumentArray[7] = CODE_DESC ;//CODE_DESC

		retVal = await CommonLookup(getLabel("Common.TerminologySet.label","Common")+' '+getLabel("Common.Level.label","Common"), argumentArray );
		
		if(retVal != null && retVal != "" ){
			eval("frmObj.lvl_code"+index).value = retVal[0];
			target.value = retVal[1];
		}else{
			target.value = "";
			eval("frmObj.lvl_code"+index).value = "";
		}
}

function displayLevel(obj){
	
	parent.parent.frames[2].location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
	var formObj = document.note_terminology ;
	var fields = new Array ( formObj.service_code  
							 ,formObj.proc_code  
							);

	var names = new Array ( getLabel("Common.ServiceCode.label","Common")
							,getLabel("Common.note.label","Common")
						   );	

	if(checkFieldsofMst( fields, names, parent.parent.frames[2])) {
		var frmObj=document.note_terminology;
		var tmp_val = obj.value;
		if(tmp_val != ""){
			var split_val=tmp_val.split(",");
			frmObj.term_set_id.value= split_val[0];
			frmObj.term_set_desc.value= split_val[1];
			frmObj.lvl.value= split_val[2];
/* If the value in service_description or Note description is null the function should not display the Term Associated table.*/			
			if ( (obj.value!="")&&(frmObj.service_desc.value!="")&&(frmObj.proc_desc.value!="") )
			{
				document.note_terminology.term_code_btn.style.visibility='visible';
			}
			else
			{
				document.note_terminology.term_code_btn.style.visibility='hidden';
				document.note_terminology.term_set.options.selectedIndex=0;
				var msg=getMessage("CAN_NOT_BE_BLANK","Common");
				msg= msg.replace('$',getLabel("Common.service.label","Common"));

  			    parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg;
				return false;
			}

			document.getElementById('level').innerHTML = "<div class='label'>"+getLabel("eMR.NoofLevels.label","MR")+"&nbsp;&nbsp&nbsp<B>"+split_val[2]+"</B></div>";
			var mode=frmObj.mode.value ;
			mode = '2';
			//frmObj.service_desc.readOnly = true;
			//frmObj.proc_desc.readOnly = true;
			frmObj.service_desc.disabled = true;
			frmObj.proc_desc.disabled = true;
			frmObj.service_butn.disabled = true;
			frmObj.proc_butn.disabled = true;
			parent.term_associated.location.href='../jsp/NoteTerminologyCodeSingle.jsp?mode='+mode+'&term_code_associated=&level='+split_val[2]+"&service_code="+frmObj.service_code.value+"&service_desc="+frmObj.service_desc.value+"&note_type="+frmObj.proc_code.value+"&note_type_desc="+frmObj.proc_desc.value+"&term_set="+frmObj.term_set_id.value+"&term_set_desc="+frmObj.term_set_desc.value  ;
			
		}else{
			document.getElementById('level').innerHTML = "<div class='label'>"+getLabel("eMR.NoofLevels.label","MR")+"&nbsp;&nbsp&nbsp</div>";
			document.getElementById('term_code_btn').style.visibility ='hidden';
			parent.term_associated.location.href='../../eCommon/html/blank.html';
		}
	}
}
async function callTermCode(obj){

		var temp_term_code = "";
		var term_code_associated = "";
		var DB_term_code_associated = "";
		//var bLvl_In_DB		 = parent.term_associated.document.term_code_associated.bLvl_In_DB.value;
		var bLvl_In_DB		 = parent.term_associated.document.getElementById("bLvl_In_DB").value;
		if (bLvl_In_DB==null)
		{
			bLvl_In_DB = "";
		}
		var mode ="";

		if(parent.term_associated.document.term_code_associated){
			temp_term_code = parent.term_associated.document.term_code_associated.temp_term_code.value;
		/*Commented by vinod - 08/09/2005 - For 
					1. The records are not getting updated on click of apply 
					2. The value of the previous record is getting prefixed for the TermCode*/
			term_code_associated = parent.term_associated.document.term_code_associated.term_code_associated.value;
			DB_term_code_associated = parent.term_associated.document.term_code_associated.DB_term_code_associated.value;

			mode = parent.term_associated.document.term_code_associated.mode.value
		}else
			mode = document.note_terminology.mode.value;
				
		var mulitple_yn = "Y";
		var term_set_id= obj.value;
	
		var retVal = new String();
		var dialogHeight= "60vh" ;
		var dialogWidth = "45vw" ;
		var status = "no";
		
		var dialogUrl       = "../../eMR/jsp/TermCodeFrameSet.jsp?title="+document.note_terminology.term_set_desc.value+"&term_set_id="+term_set_id+"&mulitple_yn="+mulitple_yn+"&temp_term_code="+temp_term_code+"&term_code_associated="+term_code_associated+"&title=Term Code Lookup" ;
		if(mode == '2'){
			dialogUrl+= "&Db_term_code="+DB_term_code_associated;
		}

		var dialogArguments = term_set_id ;
		var dialogFeatures  = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		var returnVal = await top.window.showModalDialog(dialogUrl, term_set_id, dialogFeatures);
		
		if ( returnVal == null || returnVal == "" )
		{
		}
		else
		{
			var retValCode = returnVal.split("~") ;
			var term_code_associated ="";
			for (var i=0;i<(retValCode.length-1);i++)
			 {
				var retVal = retValCode[i].split("||") ;
				term_code =retVal[0];
				term_code_desc =retVal[1];
				level_desc =retVal[2];
				var level = retVal[3];
				//term_code_associated += term_set_id+"~"+level+"~"+level_desc+"~"+eval("document.terminology_level.lvl_code"+i).value+"*";
				term_code_associated += term_code+"~"+level+"~"+level_desc+"~"+term_code_desc+"`";
			}
			//var mode= document.note_terminology.mode.value;
			document.note_terminology.term_set.disabled =  true;
			parent.term_associated.location.href='../../eMR/jsp/NoteTerminologyCodeSingle.jsp?mode='+mode+'&term_code_associated='+term_code_associated+'&level='+document.note_terminology.lvl.value+"&term_set="+document.note_terminology.term_set_id.value+"&service_code="+document.note_terminology.service_code.value+"&note_type="+document.note_terminology.proc_code.value+"&DB_term_code="+DB_term_code_associated+"&bLvl_In_DB="+bLvl_In_DB;
		}
}

function search()
{
	
	if(document.CriteriaForm.term_set.value == ''){
		
		document.CriteriaForm.Search.disabled = false;
		message = getMessage("TERM_SET_SHOULD_NOT_BE_BLANK",'MR');
		alert(message);
		document.CriteriaForm.term_set.focus();
		return false;
	}
	else
		if(document.CriteriaForm.search_text.value == '')
		{
			
			document.CriteriaForm.Search.disabled = false;
			if(document.CriteriaForm.search_by.value == 'D')
			{
				
				message = getMessage("TERM_DESC_SHOULD_NOT_BE_BLANK",'MR');
				alert(message);
			}
			else 
			{
				
				message = getMessage("TERM_CODE_SHOULD_NOT_BE_BLANK",'MR');
				alert(message);
			}
			document.CriteriaForm.search_text.focus();
			
			return false;
		}
		
		document.CriteriaForm.Search.disabled = true;

		var term_set_id		 = document.CriteriaForm.term_set.value;
		var code_level		 = document.CriteriaForm.level.value;
		var search_by		 = document.CriteriaForm.search_by.value;
		var term_code		 = document.CriteriaForm.search_text.value;
		var term_group_id		 = document.CriteriaForm.term_group_id.value;
		if(term_code.indexOf("'")!=-1)
		{			
			term_code = term_code.replace("'","''");
		}

		var search_criteria	 = document.CriteriaForm.search_criteria.value;
		var multiple_yn		 = document.CriteriaForm.multiple_yn.value;
		var temp_term_code	 = document.CriteriaForm.temp_term_code.value;
		var returnVal1	 = document.CriteriaForm.returnVal1.value;
		//var term_code_associated = document.CriteriaForm.term_code_associated.value;
		//var Db_term_code		 = document.CriteriaForm.Db_term_code.value;
		//var term_code_associated1 = term_code_associated.split("`") ;
		//var term_code_associated2 ="";

		/*for(var i=0;i< (term_code_associated1.length-1);i++)
		{
			var retVal = term_code_associated1[i].split("~") ;
			term_code_associated2 += retVal[0]+"||"+retVal[3]+"||"+retVal[2]+"||"+retVal[1]+"~";
		} 
		term_code_associated =term_code_associated2;
		*/
		//parent.lookup_detail.location.href = "../../eMR/jsp/TermCodeQueryResult.jsp?term_set_id="+term_set_id+"&term_group_id="+term_group_id+"&term_code="+term_code+"&code_level="+code_level+"&sc="+search_criteria+"&multiple_yn="+multiple_yn+"&search_by="+search_by+"&temp_term_code="+temp_term_code+"&term_code_associated="+term_code_associated+"&Db_term_code="+Db_term_code;
		parent.lookup_detail.location.href = "../../eMR/jsp/TermCodeQueryResult.jsp?term_set_id="+term_set_id+"&term_group_id="+term_group_id+"&term_code="+term_code+"&code_level="+code_level+"&sc="+search_criteria+"&multiple_yn="+multiple_yn+"&search_by="+search_by+"&temp_term_code="+temp_term_code+"&returnVal1="+returnVal1;
		
}

function retainChk()
{
	var frmObj =parent.lookup_detail.document.all;
	var cnt = frmObj.cnt.value;
	var retVal = frmObj.temp_term_code1.value;
	var ret_term_code = "";
	ret_term_code = frmObj.ret_term_code.value;
	
	if(eval("frmObj.term_chk2")){
	for(var i=2;i<cnt;i++){ 
		if(eval("frmObj.term_chk"+i).checked){
			var code1=frmObj.result_tbl.rows[i-1].cells[0].innerText;
			var test_code1 = code1+"~";
			if(retVal.indexOf(test_code1) == -1){
				retVal += code1+"~";
				var code1=frmObj.result_tbl.rows[i-1].cells[0].innerText;
				var code2=frmObj.result_tbl.rows[i-1].cells[1].innerText;
				var code3=frmObj.result_tbl.rows[i-1].cells[2].innerText;
				var code4=frmObj.result_tbl.rows[i-1].cells[3].children[0].value;
				ret_term_code += code1 + "||" + code2 + "||" + code3 + "||" + code4 +"~";
			}
		}else{
			var code1=frmObj.result_tbl.rows[i-1].cells[0].innerText;
			if(retVal.indexOf(code1) != -1){
				var ind = retVal.indexOf(code1);
				var tmp_equ, tmp_equ1 ,tmp_equ2 ;
				if(ind != 0){
					tmp_equ = retVal.substring(0,ind);
					tmp_equ2= retVal.substring(ind , retVal.length);
					tmp_equ1= retVal.substring(0 , (tmp_equ2.indexOf("~")));
				}else{
					tmp_equ1 = retVal.substring(0,(retVal.indexOf("~")));
				}

				if(code1 == tmp_equ1){
					var tmp="";var tmp1="";
					if((retVal.indexOf(code1)) != 0){
						tmp=retVal.substring(0,(retVal.indexOf(code1)));
						var tmp_1= retVal.substring((retVal.indexOf(code1))+1,tmp.length);
						tmp1 = tmp_1.substring((tmp_1.indexOf("~"))+1,tmp_1.length );
					}else{
						tmp = retVal.substring((retVal.indexOf("~"))+1,retVal.length );
					}
					retVal = tmp + tmp1;
				}
			}
		}
	}
	}
	lookup_string = frmObj.qry_string.value;
	var ind_val = lookup_string.indexOf("&temp_term_code=");
	lookup_string = lookup_string.substring(0,ind_val);
	var ind_val1 = lookup_string.indexOf("&chkValues=");
	lookup_string = lookup_string.substring(0,ind_val1);
	var ind_val2 = lookup_string.indexOf("&returnVal1=");
	lookup_string = lookup_string.substring(0,ind_val2);
	frmObj.temp_term_code.value = retVal; 
	frmObj.ret_term_code.value = ret_term_code; 
	gb_trm_code =retVal;
	gb_term_code_associated = frmObj.ret_term_code.value;
	gb_Db_term_code = frmObj.db_term_code.value;
	gb_chkValues=frmObj.chkValues1.value;//Maheshwaran K added for PMG2014-MOD-CRF-0004 
	gb_returnVal2=frmObj.returnVal2.value;//Maheshwaran K added for PMG2014-MOD-CRF-0004 
	}

function SubmitLink(from, to) {
	document.QueryForm.from.value = from;
    document.QueryForm.to.value = to;
	//document.QueryForm.action = "../../eMR/jsp/TermCodeQueryResult.jsp?"+lookup_string+"&chkValues="+gb_chkValues+"&temp_term_code="+escape(gb_trm_code)+"&term_code_associated="+escape(gb_term_code_associated)+"&Db_term_code="+gb_Db_term_code;
	//Maheshwaran K modified for PMG2014-MOD-CRF-0004 
document.QueryForm.action = "../../eMR/jsp/TermCodeQueryResult.jsp?"+lookup_string+"&returnVal1="+escape(gb_returnVal2)+"&chkValues="+escape(gb_chkValues)+"&temp_term_code="+escape(gb_trm_code);
	document.QueryForm.submit() ;
}
function changeCursor(obj) {
	obj.style.cursor = "hand" ;
}

function disableClick(evnt) {
	evnt.cancelBubble = true ;
}
function initializeText() {
    var argArray = window.dialogArguments ;
	alert(argArray[5]);
    document.getElementById('search_text').value = argArray[5] ;
    //makeValidString( document.getElementById('search_text') ) ;
    if(argArray[5] !='' )
    {
        fromCalledPage = true
        CallDescFrame() ;
    }
}

function Modify(obj){
    var code1=obj.cells[0].innerText;
    var code2=obj.cells[1].innerText;
    var code3=obj.cells[2].innerText;
    var retVal = code1 + "||" + code2 + "||" + code3 +"~";
	top.window.returnValue = retVal ;
    top.close()
}

function resetForm( formObj )
{
    formObj.reset();
	setSearch(document.CriteriaForm.search_by)
	parent.lookup_head.document.CriteriaForm.Search.disabled = false;
    parent.lookup_detail.location.href = "../../eCommon/html/blank.html";

}
function setSearch(obj){
		document.forms[0].search_text.value="";
		if(obj.value=="D"){
			document.getElementById('term').innerHTML=getLabel("eMR.TermDescription.label","MR");
		}else if(obj.value=="C"){
			document.getElementById('term').innerHTML=getLabel("Common.TermCode.label","Common");
		}
}

/*To check for special characters in the Term Description / Code  text  field.*/
function CheckForSpecChars_term(event){
    var strCheck = '"';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return true;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return false ;
}
/*************************************************************/
