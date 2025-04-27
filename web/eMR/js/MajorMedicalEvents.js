function reset()
{
	//frames[1].frames[2].document.forms[0].reset();
	//parent.frames[1].frames[1].document.forms[0].search.disabled = false;
	//frames[1].frames[1].document.forms[0].reset();
	//frames[1].frames[2].location.href = "../../eCommon/html/blank.html";
	frames[1].frames[2].document.location.reload();
}

function onSuccess(temp)
{
	
	if(temp=='update')
	{
		parent.parent.frames[1].document.location.reload();
	}
	else
	{
		parent.frames[1].frames[1].document.location.reload();
	}
}


function CheckStartDate(obj)
{
	
	//if(obj.value.length>0)
	//CheckDate(obj); // checks for valid date
	
		if(!validDateObj(obj,'DMY',localeName))
			return false;
		else
		{

				/*if(!doDateCheck1(document.forms[0].dob,obj))
				{
					var msg=getMessage("EVENT_START_GREATER_DOB",'MR');
					alert(msg);
					obj.select();
					obj.focus();
					flag1=false;
					return false;
				}*/

				var greg_EventStartDate = convertDate(obj.value,'DMY',localeName,'en');
				var Dob_Date = convertDate(document.forms[0].dob.value,'DMY',localeName,'en');

				if(isBefore(greg_EventStartDate,document.forms[0].dob.value,'DMY','en'))
				{
					if(greg_EventStartDate != Dob_Date)
					{
						var msg=getMessage("EVENT_START_GREATER_DOB",'MR');
						alert(msg);
						obj.select();
						obj.focus();
						return false;
					}
				}
				
				/*if(!doDateCheck1(obj,document.forms[0].cur_date))
				{
					var msg=getMessage("EVENT_START_LESS_SYSDATE",'MR');

					alert(msg);
					obj.select();
					obj.focus();
					flag1=false;
					return false;
				}*/

				else if(!isBeforeNow(greg_EventStartDate,'DMY','en'))
				{
					var msg=getMessage("EVENT_START_LESS_SYSDATE",'MR');
					alert(msg);
					obj.select();
					obj.focus();
					return false;
				}
				else
					return true;
		}
	//}
	//return flag1;
}

function CheckEndDate(obj)
{
	//var flag=true;
	//if(obj.value.length>0)
	//{
	//CheckDate(obj);

	if(!validDateObj(obj,'DMY',localeName))
		return false;
	else
	{
		/*if(!doDateCheck1(document.forms[0].event_sdate,obj))
		{
			alert( getMessage("END_DT_GR_START_DT",'MR' ));
			obj.select();
			obj.focus();
			flag= false;
		}*/
		var greg_EventStartDate = convertDate(document.forms[0].event_sdate.value,'DMY',localeName,'en');
		var greg_EventEndDate = convertDate(obj.value,'DMY',localeName,'en');
		
		if(!isAfter(greg_EventEndDate,greg_EventStartDate,'DMY','en'))
		{
			var error=getMessage("MRDATE1_GTR_DATE2",'MR' );
			error= error.replace('$',getLabel("Common.enddate.label","Common"));
			error= error.replace('#',getLabel("Common.StartDate.label","Common"));
			alert(error);

			obj.select();
			obj.focus();
			return false;
		}
		/*if(!doDateCheck1(obj,document.forms[0].cur_date))
		{
			//var msg=getMessage("EVENT_START_LESS_SYSDATE",'MR');
			var error=getMessage("MRDATE1_GT_DATE2",'MR');
			error= error.replace('$',getLabel("Common.EventEndDate.label","Common"));
			error= error.replace('#',getLabel("Common.SystemDate.label","Common"));
			alert(error);
			obj.select();
			obj.focus();
			flag= false;
		}*/
		
		if(!isBeforeNow(greg_EventEndDate,'DMY','en'))
		{
			var error=getMessage("MRDATE1_GT_DATE2",'MR');
			error= error.replace('$',getLabel("Common.EventEndDate.label","Common"));
			error= error.replace('#',getLabel("Common.SystemDate.label","Common"));
			alert(error);
			obj.select();
			obj.focus();
			return false;
		}
					
	}
		//		return flag;
				
}
		function doDateCheck1(from,to,messageFrame,val) 
		{

			
		var fromarray; var toarray;
		var fromdate = from.value ;
		var todate = to.value ;
		if(fromdate.length > 0 && todate.length > 0 ) 
		{
			fromarray = fromdate.split("/");
			toarray = todate.split("/");
			var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
			var todt = new Date(toarray[2],toarray[1],toarray[0]);	
			if(Date.parse(todt) < Date.parse(fromdt)) 
			{
				{
				if(val=="1")  
				{
					alert(getMessage('INVALID_FROM_DT','SM') );
					to.select();
					to.focus();
				}
				else if(val=="2") 
				{
					alert( getMessage('INVALID_TO_DT','SM') );
					from.select();
					from.focus();
				}
				else if(val=="3")
				{
					alert( getMessage('TO_DT_GR_EQ_FM_DT','SM') );
					to.select();
					to.focus();
				}
				else if(val=="4")
				{
					alert(getMessage("FROM_DATE_LESS_SYSDATE",'SM' ));
					to.select();
					to.focus();
				}
				
				else if(val=="5")
				{
					alert(getMessage('NOSHOW_FM_DT_VALIDATION','IP'));
					to.select();
					to.focus();
				}
				return false;
			}
		}
		else if(Date.parse(todt) >= Date.parse(fromdt)) return true;
	}	
return true;
}

function cancelthis()
{
		parent.parent.frames[1].document.location.href='../../eMR/jsp/mrblank.jsp?step_1=8';
		parent.parent.frames[2].document.location.href='../../eCommon/jsp/error.jsp';
}

function query() {
		
	f_query_add_mod.location.href ="../../eMR/jsp/mrblank.jsp?step_1=8";
}

function calToDate(Obj1,event_edate,entered_end,event_sdate)
{

	if(Obj1.value !='' && document.forms[0].entered_to.value !=''&&document.forms[0].event_sdate.value!='')
	{
	var HTMLVal = new String();
	//HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+document.forms[0].sStyle.value+"'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eMR/jsp/ServerValidation.jsp'><input name='param' id='param' type='hidden' value='"+Obj1.value+"'><input name='entered_date' id='entered_date' type='hidden' value='"+entered_end.value +"'><input type='hidden' name='calculateFlag' id='calculateFlag' value='to' ><input type='hidden' name='event_sdate' id='event_sdate' value='"+event_sdate.value+"'></form></BODY></HTML>";

	HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+document.forms[0].sStyle.value+"'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eMR/jsp/ServerValidation.jsp'><input name='param' id='param' type='hidden' value='"+Obj1.value+"'><input name='entered_date' id='entered_date' type='hidden' value='"+entered_end.value +"'><input type='hidden' name='calculateFlag' id='calculateFlag' value='to' ><input type='hidden' name='event_sdate' id='event_sdate' value='"+convertDate(event_sdate.value,'DMY',localeName,'en')+"'></form></BODY></HTML>";

	parent.parent.messageFrame.document.write(HTMLVal);
	parent.parent.messageFrame.document.dum_form.submit();
	}
	else
	{
		/*adding getElementbyID For end_select*/
		
	document.forms[0].event_edate.value='';document.forms[0].entered_to.value='';
	document.getElementById("end_select").options[0].selected=true;
	}

}

function calFromDate(Obj1,event_sdate,entered_start)
{

	if(Obj1.value !='' && document.forms[0].entered_start.value !='')
	{
	var HTMLVal = new String();
	HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+document.forms[0].sStyle.value+"'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eMR/jsp/ServerValidation.jsp'><input name='param' id='param' type='hidden' value='"+Obj1.value+"'><input name='entered_date' id='entered_date' type='hidden' value='"+entered_start.value +"'><input type='hidden' name='calculateFlag' id='calculateFlag' value='from' ></form></BODY></HTML>";
	parent.parent.messageFrame.document.write(HTMLVal);
	parent.parent.messageFrame.document.dum_form.submit();
	}
	else
	{
	document.forms[0].event_sdate.value='';
	document.forms[0].entered_start.value='';
	}
}

