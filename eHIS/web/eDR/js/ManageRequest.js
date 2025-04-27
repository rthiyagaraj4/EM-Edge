function reset()
{
	//parent.frames[2].frames[0].location.reload();
	parent.frames[2].frames[1].location.reload();
	//parent.frames[2].frames[2].location.reload();
}

function onSuccess() 
{
	parent.frames[2].frames[0].location.href="../../eCommon/jsp/commonToolbar.jsp?module_id=DR&function_id=DR_MANAGE_SCH_REQ&function_name=Manage%20Scheduled%20Reqeust&function_type=F&menu_id=DR_ADMIN_SETUP&access=NNNNN"
	parent.frames[2].frames[1].location.reload();
}

function onSubmit()
{
	document.forms[0].function_name.value="submit";
	document.forms[0].action='../../servlet/eDR.MergeRequestServlet'
	document.forms[0].submit();
}

function onChange()
{
	if(document.forms[0].next_execute_date.value == '')
	{
		var error=getMessage("DATE_TIME_NOT_BLANK","DR");
//		error= error.replace('$','Prepare Date');
		alert(error);

	}
	else
	{
		document.forms[0].function_name.value="change";
		document.forms[0].action='../../servlet/eDR.MergeRequestServlet'
		document.forms[0].submit();
	}
}

function onRemove()
{
	document.forms[0].function_name.value="remove";
	document.forms[0].action='../../servlet/eDR.MergeRequestServlet'
	document.forms[0].submit();
}

/*function validateDtTm(obj)
	{
		//alert(parent.frames[5].name);
	if(obj.value!="")
		{
			if(validDate(obj.value,'DMYHM',localeName)==false)
				{
					alert(getMessage("INVALID_DATE_FMT","SM"));
					obj.select();
					//obj.value='';
					return false;
			}
			else
				return true;
		}
}*/

function chkGrtr(obj1,obj2)
{
	if(obj1.value != "" && obj2.value != "")
	{
		if(isBefore(obj1.value,obj2.value,"DMYHM",localeName)==false)
		{
			var error=getMessage("ED_TIME_LESS_EQL_ST_TIME","DR");
			alert(error);	
			obj2.select();
            return false;
		}
		else 
			return true;
	}
}

function ChkDateNumberInput(fld, e, deci)
{
	if (parseInt(deci)>0)
	   var strCheck = '.0123456789 /:';
	else
	   var strCheck = '0123456789 /:';
	
   var whichCode = (window.Event) ? e.which : e.keyCode;
	if (whichCode == 13) return true;  // Enter
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
}

function checkFromDate(obj)
	{
		parent.parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num=";
		var next_exe_date= obj.value;
			
	    var sysdate1 = document.forms[0].sysdate.value;

		if(next_exe_date != "" && sysdate1 != "")
		{
			if(isBefore(sysdate1,next_exe_date,"DMYHM",localeName)==false)
			{
				var errors= getMessage('NEXT_EXE_DATE_GRT_CUR_DATE','DR')+' '+sysdate1;
				alert(errors);
				//parent.parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num="+errors+"&error_value=0" ;
				obj.focus();
				obj.select();
				return false;
			}
			else 
				return true;			
		}
	}

		

/*function chkDateVal(obj)
{
	if(obj.value != '' )
	{
		if(!doDateTimeChk(obj))
		{
			alert(getMessage("INVALID_DATE_TIME","SM"));
			obj.value = "";
			obj.focus();
			return;
		}
	}
}
function checkFromDate(obj)
	{
		parent.parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num=";
		var next_exe_date= obj.value
			
			
	    var sysdate1 = document.forms[0].sysdate.value;
		
        if(obj.value=='')
	   {
		obj.value='';
		
				
	   } 
	   else
		{
		 
        var a=  next_exe_date.split(" ")
        splitdate=a[0];
        splittime=a[1]
	
		var splitdate1 =splitdate.split("/")
		var splittime1= splittime.split(":")

		 var next_exec_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))
		 
		a=  sysdate1.split(" ")
		splitdate=a[0];
		splittime=a[1]
		splitdate1 =splitdate.split("/")
		splittime1= splittime.split(":")


		 var sysdate  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]),eval(splittime1[1]))

     
	   if(Date.parse(next_exec_date) <= Date.parse(sysdate))
       {
		   // var errors="APP-DR0019 Next Execution Date should be greater Than Sysdate:"+sysdate1;
		   var errors= getMessage('NEXT_EXE_DATE_GRT_CUR_DATE','DR')+' '+sysdate1;
		    alert(errors);
			//parent.parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num="+errors+"&error_value=0" ;
			obj.focus();
			obj.select();
			return false;
	   }
	}
        
	}*/
