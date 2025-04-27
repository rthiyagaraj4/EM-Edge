	var linkContent = "";

	function create()
	{
		f_query_add_mod.location.href='../../eCA/jsp/SpltyAssTaskAddModify.jsp';
	}

	function reset(){
	f_query_add_mod.frames[0].document.forms[0].reset();
	}

	function query(){
		f_query_add_mod.location.href="../../eCA/jsp/SpltyAssTaskQueryCriteria.jsp";
	}

	function apply(){
	 
	var mode= f_query_add_mod.document.specialityAssTaskForm.mode.value;
	var fields = new Array(f_query_add_mod.document.specialityAssTaskForm.module,f_query_add_mod.document.specialityAssTaskForm.splty_event,f_query_add_mod.document.specialityAssTaskForm.category,f_query_add_mod.document.specialityAssTaskForm.taskType,f_query_add_mod.document.specialityAssTaskForm.taskTypeDesc)
		
	var names = new Array(getLabel("Common.Module.label",'COMMON'),getLabel("eCA.SpecialityEvent.label",'CA'),getLabel("Common.category1.label",'COMMON'),getLabel("eCA.TaskType.label",'CA'),getLabel("eCA.TaskDesc.label",'CA'));
    if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
   {
		
		if(mode =="insert")
		{
		f_query_add_mod.document.specialityAssTaskForm.submit();
		}
		if(mode=="delete")
		{
			//deleterecord();
			 if (checkIsValidForProceed() ) {
		message  = getMessage("NO_CHANGES_TO_UPDATE","CA");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message;
		return false ;
	 }
		}
		
	 }
	   else
	   {
	   	  //var error=getMessage("RECORD_CANNOT_DELETE",'CA');	
	//		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="
	   }
  
 }

function deleterecord()
  {
	
	if(f_query_add_mod.document.specialityAssTaskForm!=null && f_query_add_mod.document.specialityAssTaskForm.mode!=null)
	{
		var mode = f_query_add_mod.document.specialityAssTaskForm.mode.value;

		if(mode != "insert"){
			var chkJsp = f_query_add_mod.location.href;
			var mode1="delete";
			var msg=getMessage("DELETE_RECORD",'common');
			if(confirm(msg) == true)
			{	
				
				f_query_add_mod.document.specialityAssTaskForm.module.disabled=false;
				f_query_add_mod.document.specialityAssTaskForm.category.disabled=false;
				f_query_add_mod.document.specialityAssTaskForm.taskType.disabled=false;
				f_query_add_mod.document.specialityAssTaskForm.mode.value=mode1;
				f_query_add_mod.document.specialityAssTaskForm.submit();
			}
			else
			{
				commontoolbarFrame.location.reload();
			}
		}
		else
		{
		
			var error=getMessage("RECORD_CANNOT_DELETE",'CA');	
			messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error
		}
	  }
	else
		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
   }
	
	function reset()
   {
		if(f_query_add_mod.document.forms[0])
			f_query_add_mod.document.forms[0].reset();
   }
	
	function onSuccess()
  {
	 	// alert(f_query_add_mod.document.forms[0].mode.value);
		if(f_query_add_mod.document.forms[0].mode.value=="insert")
			f_query_add_mod.location.href='../../eCA/jsp/SpltyAssTaskAddModify.jsp?mode=insert';
		else if(f_query_add_mod.document.forms[0].mode.value=="modify")
	   { // alert("reload");
			f_query_add_mod.location.reload();
	   }
		else     
			f_query_add_mod.location.href='../../eCA/jsp/SpltyAssTaskAddModify.jsp?mode=insert';
  }
	
	function getspltyEvent1(code,target)
   {
	var retVal			=  new String();
	var title			= getLabel("eCA.SpecialityEvent.label",'ca');
	var module_id		= document.specialityAssTaskForm.module.value;
	
	//alert("module_id===="+module_id	 );
	var sql="SELECT SPLTY_EVENT_CODE code,SPLTY_EVENT_DESC  description FROM CA_SPLTY_EVENT WHERE eff_status='E' and upper(SPLTY_EVENT_CODE) like upper(?) and upper(SPLTY_EVENT_DESC) like upper(?) and UPPER(module_id)='"+module_id+"'";
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
	retArray = CommonLookup( title, argArray );

	if(retArray != null && retArray !="")
	{
		code.value = retArray[0];
		target.value = retArray[1];
	}
	else
	{
		code.value = "";
		target.value = "";
	}
	
}
function getspltyEvent()
   {
	var retVal			=  new String();
	var title			= getLabel("eCA.SpecialityEvent.label",'ca');
	var module_id		= document.specialityAssTaskForm.module.value;
	
	//alert("module_id===="+module_id	 );
	var sql="SELECT SPLTY_EVENT_CODE code,SPLTY_EVENT_DESC  description FROM CA_SPLTY_EVENT WHERE eff_status='E' and upper(SPLTY_EVENT_CODE) like upper(?) and upper(SPLTY_EVENT_DESC) like upper(?) and UPPER(module_id)='"+module_id+"'";
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();

	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = "";
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	retArray = CommonLookup( title, argArray );

	if(retArray != null && retArray !="")
	{
		document.specialityAssTaskForm.event_id.value = retArray[0];
		document.specialityAssTaskForm.splty_event.value = retArray[1];
	}
	else
	{
		document.specialityAssTaskForm.splty_event.value = "";
		document.specialityAssTaskForm.event_id.value = "";
	}
	
}

	function getTaskType()
 {
	
	var retVal			=  new String();
	var title			= getLabel("eCA.SpecialityEvent.label",'ca');
	var taskType		= document.specialityAssTaskForm.taskType.value;
	 var sql="";
	//alert("module_id===="+taskType	 );	 
	if(	taskType == "N")
	sql="SELECT NOTE_TYPE code,NOTE_TYPE_DESC  description FROM ca_note_type WHERE eff_status='E' and upper(NOTE_TYPE) like upper(?) and upper(NOTE_TYPE_DESC) like upper(?)";
	else
	sql="SELECT CHART_ID code,SHORT_DESC  description FROM ca_chart WHERE eff_status='E' and upper(CHART_ID) like upper(?) and upper(SHORT_DESC) like upper(?)";
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();

	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = "";
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	retArray = CommonLookup( title, argArray );

	if(retArray != null && retArray !="")
	{
		document.specialityAssTaskForm.taskTypeCode.value = retArray[0];
		document.specialityAssTaskForm.taskTypeDesc.value = retArray[1];
	}
	else
	{
		document.specialityAssTaskForm.taskTypeDesc.value = "";
		document.specialityAssTaskForm.taskTypeCode.value = "";
	}
	
}

 	function getTaskType1(code,target)
 {
	
	var retVal			=  new String();
	var title			= getLabel("eCA.SpecialityEvent.label",'ca');
	var taskType		= document.specialityAssTaskForm.taskType.value;
	 var sql="";
	//alert("module_id===="+taskType	 );	 
	if(	taskType == "N")
	sql="SELECT NOTE_TYPE code,NOTE_TYPE_DESC  description FROM ca_note_type WHERE eff_status='E' and upper(NOTE_TYPE) like upper(?) and upper(NOTE_TYPE_DESC) like upper(?)";
	else
	sql="SELECT CHART_ID code,SHORT_DESC  description FROM ca_chart WHERE eff_status='E' and upper(CHART_ID) like upper(?) and upper(SHORT_DESC) like upper(?)";
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
	retArray = CommonLookup( title, argArray );

	if(retArray != null && retArray !="")
	{
		code.value = retArray[0];
		target.value = retArray[1];
	}
	else
	{
		code.value = "";
		target.value = "";
	}
	
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

function enable(obj)
{
	
	document.specialityAssTaskForm.taskTypeDesc.value="";
	if(obj.value=="")
	{
	document.specialityAssTaskForm.taskTypeDesc.disabled=true;
	document.specialityAssTaskForm.buttonTaskType.disabled=true;
	}
	else
	{
		document.specialityAssTaskForm.taskTypeDesc.disabled=false;
		document.specialityAssTaskForm.buttonTaskType.disabled=false;
	}
}
