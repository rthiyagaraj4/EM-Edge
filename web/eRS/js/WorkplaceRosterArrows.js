var message="";
function moveForward()
{
	var next_from_date=parent.frames[0].document.forms[0].p_from_date.value;
	var next_to_date=parent.frames[0].document.forms[0].p_to_date.value;
	var onclick_of=parent.frames[0].document.forms[0].p_next_direction.value;
	var p_end=parent.frames[0].document.forms[0].p_end.value;

	if(p_end=='E'){
		//var message=getMessage("REACHED_END","RS");
		alert(getMessage("REACHED_END","RS"));
	}
	else
	{
		var workplace_code=parent.parent.frames[0].document.forms[0].workplace_code.value;
		var mode=parent.parent.frames[0].document.forms[0].mode.value;
		var  function_id=parent.parent.frames[0].document.forms[0].function_id.value;
		var  from_date=parent.parent.frames[0].document.forms[0].from_date.value;
		var  to_date=parent.parent.frames[0].document.forms[0].to_date.value;
		//var flag=parent.parent.frames[0].document.forms[0].getFlag.value;
		if((to_date == next_to_date)&&(from_date == next_from_date)){
			//var message=getMessage("REACHED_END","RS");
			alert(getMessage("REACHED_END","RS"));
		}
		else
			parent.frames[1].location.href="../../eRS/jsp/WorkplaceRosterResult.jsp?workplace_code="+workplace_code+"&mode="+mode+"&function_id="+function_id+"&from_date="+from_date+"&to_date="+to_date+"&onclick_of="+onclick_of+"&new_todate="+next_to_date+"&next_fromdate="+next_from_date ;
	}
}

function moveBack()
{
	var next_from_date=parent.frames[0].document.forms[0].p_from_date.value;
	var next_to_date=parent.frames[0].document.forms[0].p_to_date.value;
	var onclick_of=parent.frames[0].document.forms[0].p_prev_direction.value;
	var p_end=parent.frames[0].document.forms[0].p_end.value;
	if(p_end=='B')
	{
		//message=getMessage("REACHED_BEGIN","RS");
		alert(getMessage("REACHED_BEGIN","RS"));
	}
	else
	{
		var workplace_code=parent.parent.frames[0].document.forms[0].workplace_code.value;
		var mode=parent.parent.frames[0].document.forms[0].mode.value;
		var  function_id=parent.parent.frames[0].document.forms[0].function_id.value;
		var  from_date=parent.parent.frames[0].document.forms[0].from_date.value;
		var  to_date=parent.parent.frames[0].document.forms[0].to_date.value;
		var flag=parent.parent.frames[0].document.forms[0].getFlag.value;
		if((to_date == next_to_date)&&(from_date == next_from_date)){
			//message=getMessage("REACHED_BEGIN","RS");
			alert(getMessage("REACHED_BEGIN","RS"));
		}
		else
			parent.frames[1].location.href="../../eRS/jsp/WorkplaceRosterResult.jsp?workplace_code="+workplace_code+"&mode="+mode+"&function_id="+function_id+"&from_date="+from_date+"&to_date="+to_date+"&onclick_of="+onclick_of+"&new_todate="+next_to_date+"&next_fromdate="+next_from_date;
	}
}

/*function assign()
{
	parent.frames[0].document.forms[0].p_from_value=parent.parent.frames[0].document.forms[0].p_from.value;
	parent.frames[0].document.forms[0].p_to_value=parent.parent.frames[0].document.forms[0].p_to.value
}*/
