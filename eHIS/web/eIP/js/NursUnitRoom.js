/* ADDED BY SRIDHAR ON 28 FEB 2004 */
/* The func SelectValue() & ValueSelect() will see to it that atleast one value is selected 
in the select option with out which the check box cannot be enabled */

function SelectValue(obj1,obj2)
{
	var chk_level=eval('parent.frames[1].document.forms[0].level'+obj2);
	if(chk_level.value =="")
	{
		chk_level.focus();
		obj1.checked=false;
	}
}


function setVal(obj1,obj2)
{
		var HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='NursUnitRoomDynamicValues.jsp'><input type='hidden' name='criteria' id='criteria' value='removeValue'><input type='hidden' name='code' id='code' value='"+obj1.value+"'></form></BODY></HTML>";
		
		parent.frames[2].document.write(HTMLVal);
		parent.frames[2].document.form1.submit();
}


function ValueSelect(obj1,obj2)
{
	var chk_select=eval('parent.frames[1].document.forms[0].level'+obj2);

	if(chk_select.value =="")
		{
			chk_select.focus();
			obj1.checked=false;
		}
}


function apply()
{
	
	if(frames[1].frames[0].document.forms[0].nursing_unit_desc.value == "")
	{
		var msg = getMessage('NU_NOTNULL','IP');
		messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+msg+'&err_value=0' ;
	}
	else
	{
		//parent.frames[1].frames[1].frames[1].document.forms[0].action="../../servlet/eIP.NursUnitRoomServlet";
		frames[1].frames[1].document.forms[0].action="../../servlet/eIP.NursUnitRoomServlet";
		//parent.frames[1].frames[1].frames[1].document.forms[0].target="messageFrame";
		frames[1].frames[1].document.forms[0].target="messageFrame";
		//parent.frames[1].frames[1].frames[1].document.forms[0].submit();
		frames[1].frames[1].document.forms[0].submit();
	}
}


var nur_unit_desc="";

function create() {

	var paramStr = "../../eIP/jsp/NursingUnitMain.jsp?param=create&called_from=1";
	var params = (f_query_add_mod.location.href).split('&');

		for (i=1;i<params.length ;++i )
		{
			if 	(params[i].indexOf('function_id')>-1)
			{
				paramStr = paramStr + '&' + params[i];
			}
		}

	f_query_add_mod.location.href = paramStr ;
}

function query() {
	//f_query_add_mod.location.href ="../../eIP/jsp/NursUnitRoomCriteria.jsp" ;
	var paramStr = "../../eIP/jsp/NursUnitRoomCriteria.jsp?param=create&called_from=1";
	var params = (f_query_add_mod.location.href).split('&');

		for (i=1;i<params.length ;++i )
		{
			if 	(params[i].indexOf('function_id')>-1)
			{
				paramStr = paramStr + '&' + params[i];
			}
		}

	f_query_add_mod.location.href = paramStr ;
}

function reset()
{
	var loc=frames[1].document.forms[0]

	if (loc!=null )
	{
			f_query_add_mod.document.forms[0].reset();
	}
	else if(frames[1].frames[0])
	{
		create();
	}
}

function onSuccess() {
		//parent.frames[1].frames[1].frames[1].location.href='../../eCommon/html/blank.html';
		frames[1].location.href='../../eCommon/html/blank.html';
		//parent.frames[1].frames[1].frames[0].location.reload();
		frames[1].frames[0].location.reload();
}

var effStatus= new Array();

var temp='';
function finalSelect(Obj1,Obj2)
{
	var temp2='';
	if(Obj1.checked)
	{
	temp2=Obj1.name+"$"+Obj2.name+"$"+Obj1.value+"$"+Obj2.value
	temp+=temp2+"`"
	parent.frames[1].document.forms[0].finalSelectedValues.value=temp;
	}
}

//added from AddModifyNursUnitRoom.jsp

function submitPrevNext(from, to)
{
	document.forms[0].from.value = from;
	document.forms[0].to.value = to; 
	document.forms[0].submit();
}

function checkdis(obj)
{
	if(obj.checked==false)
	{
		var i = obj.name.substring(3);
		var room_no=obj.name.substring(3).value;
		var room_value= eval("document.forms[0].chk"+i+".value");
		if(eval("document.forms[0].no_of_beds"+i+".value") != "0")
		{
			alert(getMessage("BED_DEFINED_FOR_ROOM","IP"));
			obj.checked=true;
		}else
		{
		obj.checked=false;
		}


	}
}

function selectAll(Obj,start,end)
{
	if(Obj.checked)
	{
		for(var i=start;i<end;i++)
		{
			if(eval("document.forms[0].chk"+i))
			eval("document.forms[0].chk"+i).checked=true;
		}
	}
	else
	{
		for(var i=start;i<end;i++)
		{
			if(eval("document.forms[0].chk"+i))
			eval("document.forms[0].chk"+i).checked=false;
		}
	}
}


function RemSelectAll(obj, i)
{
	//document.forms[0].chk.checked=false;
	if(obj.checked == false)
		eval("document.forms[0].removeCode"+i).value = "Y";
	else
		eval("document.forms[0].removeCode"+i).value = "N";



}

