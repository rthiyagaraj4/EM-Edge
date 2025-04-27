var show_list = false;
var message = "";
var show_position = false;
var show_shift = false;

function create() 
{
	
	f_query_add_mod.location.href = "../../eAM/jsp/ShiftForPositionFrameset.jsp?mode=1";
}

function query() 
{
	f_query_add_mod.location.href="../../eAM/jsp/ShiftForPositionQueryCriteria.jsp";
}
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
		//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		//f_query_add_mod.document.location.reload();
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 
	 var curr_val="";
    var change_insert="";

  if(frames[1].frames[2].document.forms[0]!=null){
		if(frames[1].frames[1].document.forms[0]!=null){
			var frmObj = frames[1].frames[2].document.forms[0];
			var operation = frmObj.operation.value;
			var noOfRecords = frmObj.noOfRecords.value;
			var i;
			for(i=0;i<=noOfRecords;i++)
			{
				var prev_select=eval("frmObj.prev_select"+i).value;
				if(eval("frmObj.select"+i).checked==true)
				{
					eval("frmObj.select"+i).value= "E";
					curr_val = "checked";
					if(curr_val !=prev_select)
						change_insert="true";
				}
				else
			 	{
					eval("frmObj.select"+i).value= "D";
					curr_val = "";
					if(curr_val !=prev_select)
						change_insert="true";
				}

		   }
			if(operation == 'showshifts')
			{
				 if(change_insert!="true")
				  { 
							var message=getMessage('NO_CHANGE_TO_SAVE','common');
							 messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
				  }
				  else
					frmObj.submit();
			}
			else
			{
				if(change_insert!="true")
				  { 
							var message=getMessage('NO_CHANGE_TO_SAVE','common');
							 messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
				  }
				  else
					frmObj.submit();				
			}
			//f_query_add_mod.frames[2].location.href='../../eCommon/html/blank.html';
	 }
	  else
	 {
        var message=getMessage("AM0100","AM");
		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+message;
        return false;
	}
 }
 else
 {
	    var message=getMessage("AM0100","AM");
		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+message;
        return false;
  }
}
function onSuccess() 
{
	
	f_query_add_mod.frames[2].location.href='../../eCommon/html/blank.html';

if(frames[1].frames[1].document.forms[0]!=null){
	if(f_query_add_mod.frames[1].document.forms[0].name=="frm_shift_by_shift")
	{
		f_query_add_mod.frames[1].document.forms[0].shift_code.value="" ;
		f_query_add_mod.frames[1].document.forms[0].shift_indicator.value="" ;
		f_query_add_mod.frames[1].document.forms[0].appl_for_nonworking_days.value="" ;
		f_query_add_mod.frames[1].document.forms[0].appl_for_holidays.value=""  ;
		f_query_add_mod.frames[1].document.forms[0].appl_for_working_days.value=""  ;
		f_query_add_mod.frames[1].document.forms[0].durn_hh.value=""  ;
		f_query_add_mod.frames[1].document.forms[0].durn_mm.value=""  ;
		f_query_add_mod.frames[1].document.forms[0].shift_indicator.readonly=true ;
		f_query_add_mod.frames[1].document.forms[0].appl_for_nonworking_days.readonly=true ;
		f_query_add_mod.frames[1].document.forms[0].appl_for_holidays.readonly=true  ;
		f_query_add_mod.frames[1].document.forms[0].appl_for_working_days.readonly=true ;
		f_query_add_mod.frames[1].document.forms[0].durn_hh.readonly=true ;
		f_query_add_mod.frames[1].document.forms[0].durn_mm.readonly=true ;
		f_query_add_mod.frames[1].document.forms[0].appl_for_nonworking_days.checked=false ;
		f_query_add_mod.frames[1].document.forms[0].appl_for_holidays.checked=false  ;
		f_query_add_mod.frames[1].document.forms[0].appl_for_working_days.checked=false ;
	} else
	{		
		f_query_add_mod.frames[1].document.forms[0].reset();
	}
	  }
	  else
	{
		 f_query_add_mod.document.location.reload();
	}
}

function reset() 
{
	  f_query_add_mod.document.location.reload();
}
function showPosition()
{
	
	parent.frameSelect.location.href="../../eAM/jsp/ShiftForPositionByPosition.jsp";
	parent.frameList.location.href="../../eCommon/html/blank.html";
	show_list = false;
	show_position = true;
	show_shift = false;
	message = "";
    parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
}
function showShift()
{
	parent.frameSelect.location.href="../../eAM/jsp/ShiftForPositionByShift.jsp";
	parent.frameList.location.href="../../eCommon/html/blank.html";
	show_list = false;
	show_position = false;
	show_shift = true;
	message = "";
	 parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
}
function selectShift(target)
{
	var frmObj = parent.frameSelect.frm_shift_by_shift;
	var shift_code = target.value;
	parent.frameSelect.location.href="../../eAM/jsp/ShiftForPositionByShift.jsp?shift_code="+shift_code;
	parent.frameList.location.href="../../eCommon/html/blank.html";
	show_list = false;
	show_position = false;
	show_shift = true;
}
function checkFields1( fields, names, messageFrame) {
    var errors = "" ;
    for( var i=0; i<fields.length; i++ ) {
        if(trimCheck(fields[i].value)) {
            fields[i].value = trimString(fields[i].value);
        }
        else  
		{// errors = errors + "APP-000001 " + names[i] + " cannot be blank..." + "<br>" ;
				errors = getMessage("CAN_NOT_BE_BLANK","Common");
				errors = errors.replace("$",names[i]);

		}
    }
    if ( errors.length != 0 ) {
        parent.parent.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
        return false ;
    }
    return true ;
}
function showShiftsList()
{
	var fields = new Array (parent.frames[1].document.frm_position_by_position.position);
		
	var names = new Array ( getLabel("Common.Position.label","Common")+""+getLabel("Common.code.label","Common"));	
	
	if(parent.frames[1].checkFields1( fields, names, parent.messageFrame)) 
		{	
			var position_code = parent.frames[1].document.frm_position_by_position.position.value;
			
			message = "";
			parent.parent.frames[2].location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			parent.frames[2].location.href="../../eAM/jsp/ShiftForPositionShowShifts.jsp?position_code="+position_code;

			show_list = true;
		}
}
function showPositionsList()
{
	var fields = new Array (parent.frames[1].document.frm_shift_by_shift.shift_code);

	var names = new Array ( getLabel("Common.SHIFT.label","Common"));	
	if(parent.frames[1].checkFields1( fields, names, parent.messageFrame)) 
		{

		var shift_code = document.frm_shift_by_shift.shift_code.value;
		message = "";
		parent.parent.frames[2].location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
	    parent.frames[2].location.href="../../eAM/jsp/ShiftForPositionShowPositions.jsp?shift_code="+shift_code;

		show_list = true;
		}
}
function checkActiveApplicable(target)
{
	if(target.checked == false)
	{
		target.value = "N";
		target.checked = false;
	}
	else
	{
		target.value = "Y";
		target.checked = true;
	}
}

function checkActive(target)
{
	var nameStr = 'db_action';
	var frmObj = frames[2].document.frm_list;
	var name = target.name;
	var len = name.length;
	var index = name.substr(nameStr.length,len);
	if(target.checked == false)
	{
		eval("frmObj.curr_db_action"+index).value = "I";
		target.checked = false;
	}
	else
	{
		eval("frmObj.curr_db_action"+index).value = "U";
		target.checked = true;
	}
}


function clearval()
{
	parent.frameList.location.href="../../eCommon/html/blank.html";
}
