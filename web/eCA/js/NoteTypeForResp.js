/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------

17/05/2018	  IN066108		Kamalakannan	25/01/2018		Ramesh		        GHL-CRF-0497
12/06/2018	  IN067886		Kamalakannan	25/01/2018		Ramesh		        CA-GHL-CRF-0497/01
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
var j=0;
function create()
{
	f_query_add_mod.location.href='../../eCA/jsp/AddModifyNoteTypeForRespMain.jsp';
}
function query()
{
	f_query_add_mod.location.href='../../eCA/jsp/QueryCriteriaNoteTypeForResp.jsp';
}
function apply(){
	
	if(f_query_add_mod.frameNoteTypeRespHdr!=null)
	{
	if(f_query_add_mod.frameNoteTypeRespResult.document.formNoteTypeRespResults !=null&&f_query_add_mod.frameNoteTypeRespDtl.document.formNoteTypeRespDtl !=null&&f_query_add_mod.frameNoteTypeRespDtl.document.formNoteTypeRespDtl !=null)
	{
	fields = new Array(f_query_add_mod.frameNoteTypeRespHdr.document.formNoteTypeRespHdr.group_by);
	names = new Array(getLabel("Common.groupby.label",'Common'));

	if(checkFields( fields, names, messageFrame))
	{
	
	var from = trimString(f_query_add_mod.frameNoteTypeRespResult.document.formNoteTypeRespResults.fm_disp.value);
	var to = trimString(f_query_add_mod.frameNoteTypeRespResult.document.formNoteTypeRespResults.to_disp.value);

	var row_count = trimString(f_query_add_mod.frameNoteTypeRespResult.document.formNoteTypeRespResults.row_count.value);
	var inErrorParam = f_query_add_mod.frameNoteTypeRespResult.document.formNoteTypeRespResults.inErrorParam.value;//IN067886
	
	f_query_add_mod.frameNoteTypeRespDtl.document.formNoteTypeRespDtl.from.value = from;
	f_query_add_mod.frameNoteTypeRespDtl.document.formNoteTypeRespDtl.to.value = to;
	f_query_add_mod.frameNoteTypeRespDtl.document.formNoteTypeRespDtl.row_count.value = row_count;

	var formResultObj = f_query_add_mod.frameNoteTypeRespResult.document.formNoteTypeRespResults;
	var group_by		=	formResultObj.group_by.value;

	var optionValStr = "", listValue = "", listName = "",dfltValue="",dfltName="",inErrorYNName="",inErrorYNValue="";//IN066108
	var from1 = parseInt(from,10);
	var to1 = parseInt(to,10);
	for (i=from1; i<=to1; i++)
	 {
	    listValue = eval("formResultObj.select_yn"+i+".value");
	    listName  = eval("formResultObj.select_yn"+i+".name");
		if(listValue == "") listValue = "0";
		if(group_by != "NT")
		 {
	       dfltName  = eval("formResultObj.dflt_trans_yn"+i+".name");			
	       dfltValue  = eval("formResultObj.dflt_trans_yn"+i+".value");
	       if(dfltValue == "")dfltValue = "0";
         //IN066108 start
						if (group_by != "SP" && inErrorParam=="Y") {
	       inErrorYNName = eval("formResultObj.in_error_yn"+i+".name");//in_error_yn0
	       inErrorYNValue = eval("formResultObj.in_error_yn"+i+".value");//in_error_yn 0
	       if(inErrorYNValue == "")inErrorYNValue = "0";
								optionValStr += listName + "||" + listValue + "||"+ dfltName + "||" + dfltValue + "||"+ inErrorYNName + "||" + inErrorYNValue+ "~";                                                
						} else if(group_by != "SP" && inErrorParam=="N") { // IN066108
							inErrorYNName = eval("formResultObj.in_error_yn"+ i + ".name");// in_error_yn0
							inErrorYNValue = eval("formResultObj.in_error_yn"+ i + ".value");// in_error_yn 0
	       if(inErrorYNValue == "")inErrorYNValue = "0";
	       optionValStr += listName +"||"+listValue+"||"+dfltName +"||"+dfltValue+"||"+inErrorYNName+"||"+inErrorYNValue+"~";
						}else if(group_by == "SP"){
	       optionValStr += listName +"||"+listValue+"||"+dfltName +"||"+dfltValue+"~";
         }	   
		 }
		 else
		 {
			 optionValStr += listName +"||"+listValue+"~";
		 }
	  }
	  
	
	f_query_add_mod.frameNoteTypeRespDtl.document.formNoteTypeRespDtl.optionValStr.value = optionValStr;


	///*
	f_query_add_mod.frameNoteTypeRespDtl.document.forms[0].action="../../servlet/eCA.NoteTypeForResponsibilityServlet";
	f_query_add_mod.frameNoteTypeRespDtl.document.formNoteTypeRespDtl.target="messageFrame";
	f_query_add_mod.frameNoteTypeRespDtl.document.formNoteTypeRespDtl.method="post";
	f_query_add_mod.frameNoteTypeRespDtl.document.formNoteTypeRespDtl.submit();
	//*/
	
	/*
	var HTMLVal="<html><body><form name='formtemp' id='formtemp' method='get' action='../../eCA/jsp/NoteTypeForRespValidate.jsp'>"+
	"<input type='hidden' name='from' id='from' value='"+from+"'>"+
	"<input type='hidden' name='to' id='to' value='"+to+"'>"+
	"<input type='hidden' name='row_count' id='row_count' value='"+row_count+"'>"+
	"</form></body></html>";
	/*

	//parent.frames[1].frames[2].document.write(HTMLVal);
	//parent.frames[1].frames[2].document.form1.submit();
		
	parent.frames[1].frames[2].document.body.insertAdjacentHTML('afterbegin', HTMLVal);
	parent.frames[1].frames[2].document.formtemp.submit();
	/**Ends**/
	
	/*
	var varRespId=f_query_add_mod.frames[0].document.NoteTypeForResp_form1.resp_id.value;
	var varInsert=f_query_add_mod.frames[1].document.NoteTypeForResp_form2.stringInsert.value;
	var varModify=f_query_add_mod.frames[1].document.NoteTypeForResp_form2.stringModify.value;
	var insert;
	var modify;
	var forInsertion='';
	var forModification='';
	var forDeletion='';
	if(varInsert!='')
	{
		insert=varInsert.split("||");
		for (i=0;i<insert.length-1 ;i++)
		{
			var val=eval("f_query_add_mod.frames[1].document.NoteTypeForResp_form2.a"+insert[i]+".value");
	
			if(val!='')
			{
				forInsertion=insert[i]+"~"+val+"||"+forInsertion;
			}
		
		}
	
	}
	if(varModify!='')
	{
		modify=varModify.split("||");
		for (i=0;i<modify.length-1 ;i++)
		{
			var val=eval("f_query_add_mod.frames[1].document.NoteTypeForResp_form2.a"+modify[i]+".value");
			if(val=='')
			{
				forDeletion=modify[i]+"~"+val+"N||"+forDeletion;
			}
			else
				forModification=modify[i]+"~"+val+"||"+forModification;
		

		}	 

	}
	//String insertValue
    	/*var fields = new Array ( f_query_add_mod.document.NoteTypeForResp_form.resp_id,
						f_query_add_mod.document.NoteTypeForResp_form.note_type,
						f_query_add_mod.document.NoteTypeForResp_form.privilege_type
					    );
		var names = new Array ( "Responsibility",
							"Note Type",
							"Role"
					      );
	if(f_query_add_mod.checkFields( fields, names, messageFrame))*-/ 
	f_query_add_mod.frames[1].document.forms[0].forDeletion.value=forDeletion;
	f_query_add_mod.frames[1].document.forms[0].forModification.value=forModification;
	f_query_add_mod.frames[1].document.forms[0].forInsertion.value=forInsertion;
	f_query_add_mod.frames[1].document.NoteTypeForResp_form2.method="post";
	f_query_add_mod.frames[1].document.NoteTypeForResp_form2.action="../../servlet/eCA.NoteTypeForResponsibilityServlet?resp_id="+varRespId;
	/*forInsertion="+forInsertion+"&forModification="+forModification+"&forDeletion="+forDeletion+"&*-/
	f_query_add_mod.frames[1].document.NoteTypeForResp_form2.target="messageFrame"
	f_query_add_mod.frames[1].document.NoteTypeForResp_form2.submit();
	*/
	}
	}
	else
	{
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
		return false;
	}
	}
	else
	{
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
		return false;
	}

}


function deleterecord()
{

    f_query_add_mod.document.NoteTypeForResp_form.mode.value='delete';
    f_query_add_mod.document.NoteTypeForResp_form.submit();     
}   

function onSuccess()
{
	f_query_add_mod.location.reload();

	/*
	var id=f_query_add_mod.frames[0].document.forms[0].resp_id.value;
	f_query_add_mod.frames[1].location.href='../../eCA/jsp/AddModifyNoteTypeForRespNoteType.jsp?resp_id='+id;
	/*if(f_query_add_mod.document.forms[0].mode.value=="insert")
	     f_query_add_mod.location.href='../../eCA/jsp/AddModifyNoteTypeForResp.jsp';
	else if(f_query_add_mod.document.forms[0].mode.value=="modify")
            f_query_add_mod.location.reload();
        else     
	    f_query_add_mod.location.href='../../eCommon/html/blank.html';*-/
	*/

}
function reset()
{
	/*if(f_query_add_mod.document.forms[0].name=="NoteTypeForResp_form")
		f_query_add_mod.document.forms[0].reset();
	else*/
		f_query_add_mod.location.reload();
}

/*******************************/ 
function fetchDetailsRecords(obj){
	var val = obj.value;
	var msg = "";
	if(val != ""){
		parent.frameNoteTypeRespDtl.location.href="NoteTypeForRespDtl.jsp?group_by="+obj.value;
		parent.frameNoteTypeRespResult.location.href="../../eCommon/html/blank.html";
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
		if (parent.frameNoteTypeRespHdr.formNoteTypeRespHdr.searchBoxBG)
		{
		  parent.frameNoteTypeRespHdr.formNoteTypeRespHdr.searchBoxBG.style.display='none';
		}

	}else if(val == ""){
		parent.frameNoteTypeRespDtl.location.href="../../eCommon/html/blank.html";
		parent.frameNoteTypeRespResult.location.href="../../eCommon/html/blank.html";
		msg = getMessage("GROUPBY_NOT_BLANK",'CA');
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg+"&err_value=0";
		if (parent.frameNoteTypeRespHdr.formNoteTypeRespHdr.searchBoxBG)
		{
		  parent.frameNoteTypeRespHdr.formNoteTypeRespHdr.searchBoxBG.style.display='inline';
		}
		return false;
	}
}

function fetchResults(){
	var group_by	= parent.frameNoteTypeRespHdr.formNoteTypeRespHdr.group_by.value;
	var	grp_by_code = parent.frameNoteTypeRespDtl.formNoteTypeRespDtl.grp_by_code.value;
	var fldName = "";
	var msg = "";

	if(group_by == "RS")
		fldName = getLabel("Common.responsibility.label",'Common');
	else if(group_by == "PR")
		fldName = getLabel("Common.practitioner.label",'Common');
	else if(group_by == "SP")
		fldName = getLabel("Common.speciality.label",'Common');
	
	if(group_by != "" && grp_by_code != ""){
		parent.frameNoteTypeRespResult.location.href="NoteTypeForRespResult.jsp?group_by="+group_by+"&grp_by_code="+encodeURIComponent(grp_by_code);
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
	}else if(grp_by_code ==""){
		parent.frameNoteTypeRespResult.location.href=="../../eCommon/html/blank.html";
		msg = getMessage("CAN_NOT_BE_BLANK",'common');
		msg = msg.replace('$',fldName);
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg+"&err_value=0";
		return false;
	}
}

function checkVal(obj){
	document.forms[0].dispMode.value = obj;
	document.forms[0].submit();
}
function clearDetailPage()
{
	parent.frameNoteTypeRespResult.location.href="../../eCommon/html/blank.html";
}
async function callRespLookup(target,code)
{
	var group_by  = document.forms[0].group_by.value;
	var dialogTop	= "40";
	var dialogHeight	= "10" ;
	var dialogWidth= "40" ;
	var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments	= "" ;
	var search_desc	= "";
	var title			= "";
	var sql = "";
	
	if(group_by == "RS")
	{
		 sql="Select resp_id code, resp_name description from sm_resp where eff_status='E' and upper(resp_id) like upper(?) and upper(resp_name) like upper(?) order by resp_name";
		 title =getLabel("Common.responsibility.label","Common");
	}
	else if (group_by == "PR")
	{
		
		 sql="Select PRACTITIONER_ID code, PRACTITIONER_NAME description from AM_PRACTITIONER where eff_status='E' and upper(PRACTITIONER_ID) like upper(?) and upper(PRACTITIONER_NAME) like upper(?) order by 2";
 		 title =getLabel("Common.practitioner.label","Common");
	}
	else if (group_by == "SP")
	{
		
		 sql="Select speciality_code code, short_desc description from am_speciality where eff_status='E' and upper(speciality_code) like upper(?) and upper(short_desc) like upper(?) order by 2";
 		 title =getLabel("Common.speciality.label","Common");
	}
	else if (group_by == "NT")
	{
		
		 sql="select note_type code, note_type_desc description from ca_note_type where eff_status = 'E' and  upper(note_type) like upper(?) and upper(note_type_desc) like upper(?) order by note_type_desc";
 		 title =getLabel("Common.NoteType.label","Common");
	}

	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();

	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;

	retArray = await CommonLookup( title, argArray );
	
	var ret1=unescape(retArray);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if(retArray != null && retArray !="")
	{
		document.forms[0].grp_by_name.value = arr[1];
		document.forms[0].grp_by_code.value = arr[0];
	}
	else
	{
		document.forms[0].grp_by_name.value = arr[1];
		document.forms[0].grp_by_code.value = arr[0];
	}

	clearDetailPage(target);
}

function perform(ctrlChkBoxObj,rowCount,groupBy)
{
	var val ="";	
	var disp ="";
	var allow_yn ="";
	var inErrorParam = "";
	var inErrorParam = eval("document.formNoteTypeRespResults.inErrorParam").value;
	/*****************************/
	var chkCount = eval("document.formNoteTypeRespResults.chkCount").value;//alpha
	var enableCount = eval("document.formNoteTypeRespResults.enableCount").value;//alpha
	/*****************************/
	if(ctrlChkBoxObj.checked==true)
	{
		var from1 = trimString(document.formNoteTypeRespResults.from.value);
		var to1 = trimString(document.formNoteTypeRespResults.to.value);
		var from2 = parseInt(from1,10);
	    var to2 = parseInt(to1,10);
	    var in_error_yn ="";//IN066108
	    for(cnt= from2; cnt<= to2; cnt++)	
		{
	    	val = eval("document.formNoteTypeRespResults.select_yn"+cnt);
			if ((groupBy == "PR" || groupBy == "RS") && inErrorParam=="Y") {
			in_error_yn = eval("document.formNoteTypeRespResults.in_error_yn"+cnt);//IN066108
	    	 }
			if(val!= undefined)//alpha
		 {
			val.checked = true;
			val.value = "1";
			if ((groupBy == "PR" || groupBy == "RS") && inErrorParam=="Y" && in_error_yn.disabled==true) {//alpha
			in_error_yn.disabled = false;//IN066108
			in_error_yn.checked=false//IN066108
			in_error_yn.value = "N"//IN066108
			eval("document.formNoteTypeRespResults.enableCount").value = parseInt(eval("document.formNoteTypeRespResults.enableCount").value) + 1;//alpha
			}
			allow_yn = eval("document.formNoteTypeRespResults.default_allow_yn"+cnt);
			if(allow_yn.value=='Y')
			 {
			   disp = eval("document.formNoteTypeRespResults.dflt_trans_yn"+cnt);
			   disp.value = "";
			   disp.disabled = false;
			   disp.checked = false;
			  }
			  else
			  {
				  
				disp = eval("document.formNoteTypeRespResults.dflt_trans_yn"+cnt);
				disp.checked = false;
				disp.value="";
				disp.disabled = true;
			  }
		 }
		}
	 
	}
	else
	{
		  //alert("here in else"+ctrlChkBoxObj.checked);
		//document.formNoteTypeRespResults.selAllValue.value="N";
		var from1 = trimString(document.formNoteTypeRespResults.from.value);
		var to1 = trimString(document.formNoteTypeRespResults.to.value);
		var in_error_yn ="";//IN066108
		var from2 = parseInt(from1,10);
	    var to2 = parseInt(to1,10);
	     for(cnt= from2; cnt<= to2; cnt++)	
		{
			val = eval("document.formNoteTypeRespResults.select_yn"+cnt);
			disp = eval("document.formNoteTypeRespResults.dflt_trans_yn"+cnt);
			if ((groupBy == "PR" || groupBy == "RS") && inErrorParam=="Y") {
			in_error_yn = eval("document.formNoteTypeRespResults.in_error_yn"+cnt);//IN066108
			 }
            if(val!= undefined)
		 {
			val.checked = false;
			disp.checked = false;
			disp.value = "";
			disp.disabled = true;
			val.value = "";		
			var HTMLVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='tempform1' id='tempform1' method='post' action='../../eCA/jsp/NoteTypeForRespValidate.jsp'><input type='hidden' name='rowCount' id='rowCount' value="+cnt+"><input type='hidden' name='transcription_yn' id='transcription_yn' value='N'></form></body></html>";			 parent.parent.messageFrame.document.write(HTMLVal);
			parent.parent.messageFrame.document.tempform1.submit();
		 }
			if ((groupBy == "PR" || groupBy == "RS") && inErrorParam=="Y" && in_error_yn.checked!=false ) { //alpha
			eval("document.formNoteTypeRespResults.enableCount").value = parseInt(eval("document.formNoteTypeRespResults.enableCount").value) -1;//alpha
			eval("document.formNoteTypeRespResults.chkCount").value = parseInt(eval("document.formNoteTypeRespResults.chkCount").value) -1;//alpha
            in_error_yn.disabled = true;
			in_error_yn.checked=false;
			in_error_yn.value = "N"
            }else{//alpha
            	eval("document.formNoteTypeRespResults.enableCount").value = parseInt(eval("document.formNoteTypeRespResults.enableCount").value) -1;//alpha
            	in_error_yn.disabled = true;//alpha
            }
		}
	}
	onLoadInErrorSelectAll();//alpha
}
 //IN066108 start
function performSelectAll(ctrlChkBoxObj,rowCount)
{
	var chkCount = eval("document.formNoteTypeRespResults.chkCount").value;//IN066108
	var enableCount = eval("document.formNoteTypeRespResults.enableCount").value;//IN066108
	var group_by=eval("document.formNoteTypeRespResults.group_by").value;//IN066108
	var inErrorParam = eval("document.formNoteTypeRespResults.inErrorParam").value;
	var val ="";	
	var disp ="";
	var allow_yn ="";
	var valid = "";
	var select_yn = "";
	if(inErrorParam == "Y"){
	if(ctrlChkBoxObj.checked==true)
	{
		var from1 = trimString(document.formNoteTypeRespResults.from.value);
		var to1 = trimString(document.formNoteTypeRespResults.to.value);
		var from2 = parseInt(from1,10);
	    var to2 = parseInt(to1,10);
	    for(cnt= from2; cnt<= to2; cnt++)	
		{
			val = eval("document.formNoteTypeRespResults.in_error_yn"+cnt);
			valid = eval("document.formNoteTypeRespResults.valid"+cnt);
			var select = eval("document.formNoteTypeRespResults.select_yn"+cnt);
			
			if(select!= undefined)//alpha
			{//alpha
			if(group_by=="RS"){//IN066108
				//if ((valid.value != "N") && ((select.value == "3") || (select.value == "4"))) {commented for IN067794
				if ((select.value == "3") || (select.value == "4")) {//added for IN067794
				if(val!= undefined)
					 {
						val.checked = true;
						val.value = "1";
						eval("document.formNoteTypeRespResults.chkCount").value = enableCount;
					}
				}
				else{
					val.checked = false;
					val.value = "0";
					//eval("document.formNoteTypeRespResults.chkCount").value = "0";
				}
			}else if(group_by=="PR"){
				if (select.checked || valid.value!='N') {
					if(val!= undefined && val.disabled==false)//alpha
						 {
							val.checked = true;
							val.value = "1";
							eval("document.formNoteTypeRespResults.chkCount").value = enableCount;
						}
					}
					else{
						val.checked = false;
						val.value = "0";
					}
			}
			}
		}
		}
	else
	{
		var from1 = trimString(document.formNoteTypeRespResults.from.value);
		var to1 = trimString(document.formNoteTypeRespResults.to.value);
		var from2 = parseInt(from1,10);
	    var to2 = parseInt(to1,10);
	     for(cnt= from2; cnt<= to2; cnt++)	
		{
			val = eval("document.formNoteTypeRespResults.in_error_yn"+cnt);
			valid = eval("document.formNoteTypeRespResults.valid"+cnt);
            if(val!= undefined)
		 {
			val.checked = false;
			val.value = "N";	
			eval("document.formNoteTypeRespResults.chkCount").value = "0";
			var HTMLVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='tempform1' id='tempform1' method='post' action='../../eCA/jsp/NoteTypeForRespValidate.jsp'><input type='hidden' name='rowCount' id='rowCount' value="+rowCount+"></form></body></html>";
			 parent.parent.messageFrame.document.write(HTMLVal);
			parent.parent.messageFrame.document.forms[0].submit();
		 }
		}
	}
	}
}
//IN066108 end
function chkunchk(objCheck,rowCount,groupBy)
{
	//alert("rowCount"+rowCount);
	var checkbox=0;
	if(objCheck.checked==false)
	{
		objCheck.checked=false
		objCheck.value = "0";

	}else
	{		objCheck.checked= true;
			objCheck.value = "1";
	}	
	var from1 = trimString(document.formNoteTypeRespResults.from.value);
	var to1 = trimString(document.formNoteTypeRespResults.to.value);
	var headerselect = document.formNoteTypeRespResults.selAllValue.value;
	var pagecount  = document.formNoteTypeRespResults.pagecount.value;
	var chkCount = eval("document.formNoteTypeRespResults.chkCount").value;//IN067886
	var enableCount = eval("document.formNoteTypeRespResults.enableCount").value;
	var inErrorParam = eval("document.formNoteTypeRespResults.inErrorParam").value;
	var pagecount1 = parseInt(pagecount,10);
	var from2 = parseInt(from1,10);
	var to2 = parseInt(to1,10);
	//var dif = (to2+1)-from2;


	if(pagecount1 >0)
 {
	for(cnt= from2; cnt<= to2; cnt++)
	 {			
		val = eval("document.formNoteTypeRespResults.select_yn"+cnt);
		if(val!=undefined)
	  {
		if(val.checked == true)
		{
			checkbox++;
		}
	  }
	}
	  if(checkbox == pagecount1)
	{
		val = eval("document.formNoteTypeRespResults.ctrlChkBox"+headerselect);
		if(val!=undefined)
		{
			val.checked = true;
		}
	}
	else
	{
		val = eval("document.formNoteTypeRespResults.ctrlChkBox"+headerselect);
		if(val!=undefined)
		{
			val.checked = false;
		}
	}
 }
	
	
		//var objchkSelect = eval(document.getElementById('select_yn')+rowCount);
		var objchkSelect = eval("document.formNoteTypeRespResults.select_yn"+rowCount);
		var val="";
		var allow_yn="";
		var in_error_yn="";

		if(objchkSelect!=undefined)
	 {
		if(objchkSelect.checked == true)
		{
				allow_yn = eval("document.formNoteTypeRespResults.default_allow_yn"+rowCount);
				if(allow_yn.value=='Y')
			   {
				val = eval("document.formNoteTypeRespResults.dflt_trans_yn"+rowCount);
				val.disabled = false;
				val.value="";
				chkunchk1(val,rowCount);
			   }
			  else
			  {
				val = eval("document.formNoteTypeRespResults.dflt_trans_yn"+rowCount);
				val.disabled = true;
				val.value="";
				chkunchk1(val,rowCount);
			  }
			if ((groupBy == "PR" || groupBy == "RS") && inErrorParam=="Y") {
				in_error_yn = eval("document.formNoteTypeRespResults.in_error_yn"+rowCount);
				in_error_yn.disabled=false;
				in_error_yn.checked=false;
				in_error_yn.value = "N";// IN066108
				eval("document.formNoteTypeRespResults.enableCount").value = parseInt(enableCount) + 1;	
				onLoadInErrorSelectAll();//IN067886
		}
	}	else
		{
			   val = eval("document.formNoteTypeRespResults.dflt_trans_yn"+rowCount);
			   if(val!=undefined)
		  {
			   val.disabled = true;
			   val.checked = false;
			   val.value="";
			   chkunchk1(val,rowCount);
				if ((groupBy == "PR" || groupBy == "RS")&& inErrorParam=="Y") {
			   in_error_yn = eval("document.formNoteTypeRespResults.in_error_yn"+rowCount);
			  //IN067886 start
         if(in_error_yn.checked!=false){
				   in_error_yn.checked=false;
				   in_error_yn.disabled=true;
				   in_error_yn.value = "N"//IN066108
				   eval("document.formNoteTypeRespResults.chkCount").value = parseInt(chkCount)-1;
			   }
         //alpha start
         else{
        	 in_error_yn.disabled=true;
         }
         //alpha end
			   		eval("document.formNoteTypeRespResults.enableCount").value = parseInt(enableCount) - 1;//alpha
			   		onLoadInErrorSelectAll();//alpha
            //IN067886 end
		  }
			}

		}
	 }
}

function CheckForSpeChar(event)
{
   var strCheck='0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_* ';
   var whichCode = (window.Event) ? event.which : event.keyCode;
   key = String.fromCharCode(whichCode);  
   if (strCheck.indexOf(key) == -1) 
		return false;  //Not a valid key
}	

function fnSelectAllChkBox(rowCount)
{ 
	var selecthead = eval("document.formNoteTypeRespResults.ctrlChkBox"+rowCount);
	var i =0;	
	var pagecount  = document.formNoteTypeRespResults.pagecount.value;
	var from1 = trimString(document.formNoteTypeRespResults.from.value);
	var to1 = trimString(document.formNoteTypeRespResults.to.value);
	var from2 = parseInt(from1,10);
	var to2 = parseInt(to1,10);
	var pagecount1 = parseInt(pagecount,10);
  if(pagecount1 >0)
 {
	for(cnt= from2; cnt<= to2; cnt++)
	{
		val = eval("document.formNoteTypeRespResults.select_yn"+cnt);
      if (val)
      {
		  if(val.checked == true)
		{
		  i++;		  
		 }
      }
		
    }

	if(i==pagecount1)
	{
	 if(selecthead!=undefined)
		{
		 selecthead.checked = true;
		}
	}
	else 
	{
		 if(selecthead!=undefined)
		{
		 selecthead.checked = false;
		}
	}
  }
}

async function callResponsibilityLookup(target,code)
{
	await callRespLookup(target,code);
}

function chkunchk1(objCheck,rowCount)
{
    var transcription = objCheck.value;
	var group_by		=	document.formNoteTypeRespResults.group_by.value;

	if(objCheck.checked==true)
	{
		transcription_yn="Y";
	}
	else 
	{
		transcription_yn="N";
	}
		//if(objCheck.checked==true)
		//{
			 var HTMLVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='tempform1' id='tempform1' method='post' action='../../eCA/jsp/NoteTypeForRespValidate.jsp'><input type='hidden' name='rowCount' id='rowCount' value="+rowCount+"><input type='hidden' name='transcription_yn' id='transcription_yn' value="+transcription_yn+"></form></body></html>";
			 parent.parent.messageFrame.document.write(HTMLVal);
			parent.parent.messageFrame.document.tempform1.submit();
			//alert("HTMLVal"+HTMLVal);

		//}

		var start = eval(document.forms[0].from.value);
		var to = eval(document.forms[0].to.value);
		var obj ="";
		for(i=start;i<=to;i++)
		{
			if(objCheck.checked == true)
			{
				obj = eval("document.formNoteTypeRespResults.dflt_trans_yn"+i); 
				if(obj!=undefined)
				{
					if(objCheck == obj)
					 {
						//alert("objCheck"+objCheck.value);
						if(eval("document.formNoteTypeRespResults.dflt_trans_yn"+i).checked == true)
						{
							//alert("inif"+eval("document.formNoteTypeRespResults.dflt_trans_yn"+i).checked);
							if(obj!=undefined)
		                  {
							obj.checked = true;
							obj.value = "1";
						  }
						}
						else
						{
							if(obj!=undefined)
		                  {
							objCheck.checked = false;
							objCheck.value = "0";
						  }
						}
					  }
					  else
					  {
						  //alert(i);
						  eval("document.formNoteTypeRespResults.dflt_trans_yn"+i).checked = false;
						  eval("document.formNoteTypeRespResults.dflt_trans_yn"+i).value ="0";
						  //objCheck.checked = false;
						   // objCheck.value = "0";

					  }
					}
					else
					{
						if(obj!=undefined)
		               {
						obj.checked = false;
						obj.value = "0";
					   }
					}
				}
				else
				{
				 if(obj!=undefined)
				  {
					objCheck.checked = false;
					objCheck.value = "0";
				  }
				}
			}
}
 //IN066108 start
function chkunchk2(objCheck,rowCount)
{
	var group_by		=	document.formNoteTypeRespResults.group_by.value;
	var chkCount = eval("document.formNoteTypeRespResults.chkCount").value;//IN066108
	var enableCount = eval("document.formNoteTypeRespResults.enableCount").value;//IN066108
	var inErrorParam = eval("document.formNoteTypeRespResults.inErrorParam").value;
	if(inErrorParam=="Y"){
		var in_error = objCheck.value;
	if(objCheck.checked==true)
	{
		in_error_yn="Y";
		eval("document.formNoteTypeRespResults.chkCount").value = parseInt(chkCount) +1;//IN066108
	}
	else 
	{
		in_error_yn="N";
		eval("document.formNoteTypeRespResults.chkCount").value = parseInt(chkCount) -1;
	}
	if(parseInt(enableCount)!=0){
		if (parseInt(enableCount) == parseInt(eval("document.formNoteTypeRespResults.chkCount").value)) {
			eval("document.formNoteTypeRespResults.ctrlChkBoxx1").checked = true;//alpha
		} else {
			eval("document.formNoteTypeRespResults.ctrlChkBoxx1").checked = false;//alpha
		}
	}
			 var HTMLVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='tempform1' id='tempform1' method='post' action='../../eCA/jsp/NoteTypeForRespValidate.jsp'><input type='hidden' name='rowCount' id='rowCount' value="+rowCount+"><input type='hidden' name='in_error_yn' id='in_error_yn' value="+in_error_yn+"></form></body></html>";
			 parent.parent.messageFrame.document.write(HTMLVal);
			parent.parent.messageFrame.document.forms[0].submit();

		var start = eval(document.forms[0].from.value);
		var to = eval(document.forms[0].to.value);
		var obj ="";
		for(i=start;i<=to;i++)
		{
			if(objCheck.checked == true)
			{
				obj = eval("document.formNoteTypeRespResults.in_error_yn"+i); 
				if(obj!=undefined)
				{
					if(objCheck == obj)
					 {
						if(eval("document.formNoteTypeRespResults.in_error_yn"+i).checked == true)
						{
							if(obj!=undefined)
		                  {
							obj.checked = true;
							obj.value = "1";
						  }
						}
						else
						{
							if(obj!=undefined)
		                  {
							objCheck.checked = false;
							objCheck.value = "0";
						  }
						}
					  }
					 /* else
					  {
						  //alert(i);
						  eval("document.formNoteTypeRespResults.in_error_yn"+i).checked = false;
						  eval("document.formNoteTypeRespResults.in_error_yn"+i).value ="0";
						  //objCheck.checked = false;
						   // objCheck.value = "0";

					  }*/
					}
					else
					{
						if(obj!=undefined)
		               {
						obj.checked = false;
						obj.value = "0";
					   }
					}
				}
				else
				{
				 if(obj!=undefined)
				  {
					objCheck.checked = false;
					objCheck.value = "0";
				  }
				}
			}
 }
}
 //IN066108 end
function TransDisplay(obj,rowCount)
{
		var group_by		=	document.formNoteTypeRespResults.group_by.value;
		var valid	= eval("document.formNoteTypeRespResults.valid"+rowCount);
	var inErrorParam = eval("document.formNoteTypeRespResults.inErrorParam").value;
	var enableCount = eval("document.formNoteTypeRespResults.enableCount").value;
	var chkCount = eval("document.formNoteTypeRespResults.chkCount").value;
		if(group_by == "RS")
	  {
		var objchkSelect = eval(document.getElementById('select_yn'+rowCount));
		var val="";
		var in_error_yn="";//IN066108
		var allow_yn="";
		if(objchkSelect.options.selectedIndex!=0)
		{
			//insUpd="I";
			allow_yn = eval("document.formNoteTypeRespResults.default_allow_yn"+rowCount);
			if(allow_yn.value=='Y')
		   {		
			val = eval("document.formNoteTypeRespResults.dflt_trans_yn"+rowCount);
           if(val!=undefined)
		   {
			val.checked = false;
			val.value="";
			val.disabled = false;	
			chkunchk1(val,rowCount);
			//alert("val.value in if"+val.value);
		   }
		  }
		  else
		  {
			val = eval("document.formNoteTypeRespResults.dflt_trans_yn"+rowCount);
			 if(val!=undefined)
		   {
			val.checked = false;
			val.value="";
			val.disabled = true;			
			chkunchk1(val,rowCount);
			//alert("val.value in else"+val.value);
		   }
		  }
       //IN066108 start
			if(inErrorParam == "Y"){//param check
				//if (valid.value == "Y" && ((objchkSelect.options.selectedIndex == 3) || (objchkSelect.options.selectedIndex == 4))) { commented for IN067794 
				if ((objchkSelect.options.selectedIndex == 3) || (objchkSelect.options.selectedIndex == 4)) {//IN067794
			in_error_yn = eval("document.formNoteTypeRespResults.in_error_yn"+rowCount);
				if (in_error_yn != undefined && in_error_yn.disabled!=false ) {
					if(in_error_yn.checked != false){
				in_error_yn.checked = false;
				in_error_yn.value="N";
				in_error_yn.disabled = false;			
					eval("document.formNoteTypeRespResults.enableCount").value = parseInt(enableCount) + 1;
				chkunchk2(in_error_yn,rowCount);
					}
					else{
						in_error_yn.checked = false;
						in_error_yn.value = "N";
						in_error_yn.disabled = false;
						eval("document.formNoteTypeRespResults.enableCount").value = parseInt(enableCount) + 1;
						onLoadInErrorSelectAll();//IN067886
					}
			} //IN066108 end
		}else{
			in_error_yn = eval("document.formNoteTypeRespResults.in_error_yn"+rowCount);
				if (in_error_yn != undefined && in_error_yn.disabled!=true ) {
					if(in_error_yn.checked != false){
					in_error_yn.checked = false;
					in_error_yn.value = "N";
					in_error_yn.disabled = true;
					eval("document.formNoteTypeRespResults.enableCount").value = parseInt(enableCount) - 1;
					chkunchk2(in_error_yn, rowCount);
					}
					else{
						in_error_yn.disabled = true;
						eval("document.formNoteTypeRespResults.enableCount").value = parseInt(enableCount) - 1;
						//onLoadInErrorSelectAll();//IN067886
					}
				}
				onLoadInErrorSelectAll();//alpha
			}
			}//param check
		} else {
		
				val = eval("document.formNoteTypeRespResults.dflt_trans_yn"+rowCount);
			
			if (val != undefined && in_error_yn.disabled!=true) {
			    val.value="";
			    val.checked = false;
				val.disabled = true;				
				chkunchk1(val,rowCount);
         //IN066108 start
				if(inErrorParam=="Y"){
					in_error_yn = eval("document.formNoteTypeRespResults.in_error_yn"+ rowCount); // IN066108
				if(in_error_yn.checked != false){
				in_error_yn.value="N";
				in_error_yn.checked = false;
				in_error_yn.disabled = true;				
				eval("document.formNoteTypeRespResults.enableCount").value = parseInt(enableCount) - 1;
				chkunchk2(in_error_yn,rowCount);
         //IN066108 end
				}else{
					in_error_yn.disabled = true;
					eval("document.formNoteTypeRespResults.enableCount").value = parseInt(enableCount) - 1;
					//onLoadInErrorSelectAll();//IN067886
				}
				}
				
			}	
			onLoadInErrorSelectAll();//IN067886//alpha
		}
	}
}
//IN066108 start
function inErrorAllCheck(rowCount){
	var inErrorParam = eval("document.formNoteTypeRespResults.inErrorParam").value;
	if(inErrorParam=="Y"){
	var selecthead = eval("document.formNoteTypeRespResults.ctrlChkBoxx1");//alpha
	var chkCount = eval("document.formNoteTypeRespResults.chkCount");
	var enableCount = eval("document.formNoteTypeRespResults.enableCount");
	if( enableCount.value == 0){
		selecthead.disabled=true;
	}else{
		selecthead.disabled=false;
	}
	if(chkCount.value!=0 && enableCount.value!=0){
		
		if(chkCount.value==enableCount.value){
			selecthead.checked=true;
		}
	}
	}
}

function onLoadInErrorSelectAll(){
	var groupBy =eval("document.formNoteTypeRespResults.group_by").value;
	var inErrorParam =eval("document.formNoteTypeRespResults.inErrorParam").value;
	if(inErrorParam=="Y"){
		var chkCount = eval("document.formNoteTypeRespResults.chkCount").value;
		var enableCount = eval("document.formNoteTypeRespResults.enableCount").value;
		if(groupBy=="RS"||groupBy=="PR"){
			if(chkCount!=0 && enableCount!=0){
				if(chkCount==enableCount){
					eval("document.formNoteTypeRespResults.ctrlChkBoxx1").checked = true;//alpha
				}
				else{
					eval("document.formNoteTypeRespResults.ctrlChkBoxx1").checked = false;//alpha
				}
			}
      //alpha start
			if(parseInt(enableCount)==0){
				eval("document.formNoteTypeRespResults.ctrlChkBoxx1").disabled=true;
				eval("document.formNoteTypeRespResults.ctrlChkBoxx1").checked=false;
			}else{
				eval("document.formNoteTypeRespResults.ctrlChkBoxx1").disabled=false;
			}
      //alpha end
		}
	}
}
//IN066108 end


