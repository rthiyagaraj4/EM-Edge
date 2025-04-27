function create()
{
	f_query_add_mod.location.href = '../../eAM/jsp/AddModifyStatisticsGrpForProg.jsp?operation=insert' ;
}
function query() 
{
	f_query_add_mod.location.href ="../../eAM/jsp/StatisticsGrpForProgQueryCriteria.jsp?operation=modify" ;
}
function deleterecord()
{
	
 if(f_query_add_mod.document.StatisticsGroupForProgram_form!=null)
	 {
	if(f_query_add_mod.document.StatisticsGroupForProgram_form.function_name.value!="insert")
		{
			if(confirm(f_query_add_mod.getMessage('DELETE_RECORD','Common')))
			{

			f_query_add_mod.document.StatisticsGroupForProgram_form.function_name.value="delete";
			f_query_add_mod.document.StatisticsGroupForProgram_form.submit();

			var fn_status = f_query_add_mod.document.StatisticsGroupForProgram_form.function_name.value ;
			return true;
			}
			else
			{

			messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num= "
			}
		}
		else
		{
		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="
		}
	 }
	 else
	{
		frames[0].location.reload();
	 }
}
	//f_query_add_mod.document.StatisticsGroupForProgram_form.function_name.value="delete";
	//f_query_add_mod.document.StatisticsGroupForProgram_form.submit();
	//create();
function checkIsValidForProceed()
  {
     var url = f_query_add_mod.location.href;
     url = url.toLowerCase();
     if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) )
        return true;
    else
        return false;
  }


function apply()
{
	if (! (checkIsValidForProceed()) )
    {
        //var msg = parent.frames[0].getMessage("AM0100","AM");
		//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		//f_query_add_mod.document.location.reload();
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 
	var fields = new Array ( f_query_add_mod.document.StatisticsGroupForProgram_form.module,
				 f_query_add_mod.document.StatisticsGroupForProgram_form.program_type,
				 f_query_add_mod.document.StatisticsGroupForProgram_form.program,				 f_query_add_mod.document.StatisticsGroupForProgram_form.statistics_group,
				 f_query_add_mod.document.StatisticsGroupForProgram_form.seq_num);

	var names = new Array ( getLabel("Common.Module.label","Common"),
							getLabel("eAM.ProgramType.label","AM"),
							getLabel("Common.Program.label","Common"),
							getLabel("Common.StatisticsGroup.label","Common"),
							getLabel("Common.SequenceNo.label","Common"));
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
	{
		f_query_add_mod.document.StatisticsGroupForProgram_form.submit();
	}

}

function CheckPositiveNumber(obj) {
	//alert('isValidIntegerFormat');
	if (!isValidIntegerFormat(obj))

	{
		alert (getMessage("NUM_ALLOWED","SM"));
		return;
	}
	if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value > 0) {		
	}
	else {
  		if ( obj.value.length > 0 ) {
  			alert(getMessage("VALUE_GREAT_ZERO","MP"));
  			obj.select();
  			obj.focus();
  		}
  		
  	}
}

function isValidIntegerFormat(Obj){ 
	var str = Obj.value;
	var validIntegerExists = true;
	for (u=0;u<str.length;u++){
		if (!((str.charCodeAt(u)>=48) && (str.charCodeAt(u)<=57))){
			validIntegerExists  = false;
			break;
		}
	}
	return validIntegerExists;
}

/* function CheckNum(obj) {
	 alert('Enter');
	if (!isValidIntegerFormat(obj)) {
		alert (getMessage("NUM_ALLOWED","SM"));
		return;
	}
	if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value > 0) 
	{		
	}
	else {
  		if ( obj.value.length > 0 ) 
		{
  			alert(getMessage("NUM_ALLOWED","SM"));
            obj.select();
  			obj.focus();
  		}
  	}
}*/
function reset()
{
	if(f_query_add_mod.document.forms[0])
		//f_query_add_mod.document.forms[0].reset() ;
		f_query_add_mod.document.location.reload();
	//f_query_add_mod.document.StatisticsGroupForProgram_form.reset();
	//f_query_add_mod.document.location.reload();
	/*if(f_query_add_mod.document.forms[0].name == "StatisticsGroupForProgram_form")
	{
		alert(f_query_add_mod.document.forms[0].function_name.value);
		if(f_query_add_mod.document.forms[0].function_name.value == 'insert')
		{
			f_query_add_mod.document.forms[0].reset();
			ClearList(f_query_add_mod.document.StatisticsGroupForProgram_form.program);
			ClearList(f_query_add_mod.document.StatisticsGroupForProgram_form.statistics_group);
		}
		else 
		{
			f_query_add_mod.location.reload();
		}
	}
	else
	f_query_add_mod.document.forms[0].reset();*/
}
function onSuccess()
{
	//if(parent.frames[1].document.frames[1].document.StatisticsGroupForProgram_form.function_name.value == 'delete') 	
	if(parent.frames[2].document.frames[1].document.StatisticsGroupForProgram_form.function_name.value == 'delete') 	
	{
		//parent.frames[1].document.frames[1].location.href='../../eCommon/html/blank.html';
			f_query_add_mod.location.href='../../eCommon/html/blank.html';
	}
	else
	{	
		f_query_add_mod.location.reload();
	}
}
function ClearList(object)
{    
   if(object)
	var length  =object.length;
   var element = f_query_add_mod.document.StatisticsGroupForProgram_form.document.createElement('OPTION');
   element.text="----"+getLabel("Common.defaultSelect.label","Common")+"----";
   element.value=""; 
   for(i=1;i<length;i++)
	   object.remove(1);   
}

/*function apply() {
    
	var toSubmit 	= new Boolean() ;
	toSubmit	= true ;

	var fields = new Array ( f_query_add_mod.document.StatisticsGroupForProgram_form.module,
				 f_query_add_mod.document.StatisticsGroupForProgram_form.program_type,
				 f_query_add_mod.document.StatisticsGroupForProgram_form.program,				 f_query_add_mod.document.StatisticsGroupForProgram_form.statistics_group,f_query_add_mod.document.StatisticsGroupForProgram_form.seq_num);

	var names = new Array ( getLabel("Common.Module.label","Common"),
							getLabel("eAM.ProgramType.label","AM"),
							getLabel("eAM.Program.label","AM"),
							getLabel("Common.StatisticsGroup.label","Common"),
							getLabel("Common.SequenceNo.label","Common"));

	if (!f_query_add_mod.checkFieldsofMst( fields, names, parent.frames[1].document.frames[2])) 
	{
		toSubmit = false;		
	}
	else
	{
		if(f_query_add_mod.document.StatisticsGroupForProgram_form.function_name.value=="insert") 
		{
			if(f_query_add_mod.checkFieldsofMst( fields, names, parent.frames[1].document.frames[2])) 
			{
				f_query_add_mod.document.StatisticsGroupForProgram_form.submit();
				var fn_status = f_query_add_mod.document.StatisticsGroupForProgram_form.function_name.value;
				f_query_add_mod.document.StatisticsGroupForProgram_form.function_name.value="insert";
			}
		}
		else if(f_query_add_mod.document.StatisticsGroupForProgram_form.function_name.value=="modify") {
				f_query_add_mod.document.StatisticsGroupForProgram_form.submit();
				var fn_status = f_query_add_mod.document.StatisticsGroupForProgram_form.function_name.value;
				//f_query_add_mod.document.StatisticsGroupForProgram_form.function_name.value="modify";
		}
	}

	//parent.frames[3].location.href="/eCIS/ph/jsp/pharmacyerror.jsp?err_num=";
	
	//reset() ;
}*/
