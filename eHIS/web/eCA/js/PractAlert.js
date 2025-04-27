/*--------------------Author  Arvind Singh Pal Created on 4/1/2009 */

function doDateCheckLoc(fromDate,toDate,currDate,format,locale,fromFld)
{
	if(CheckDate(fromDate) && CheckDate(toDate))
	{
		if (!(fromDate.value == null || fromDate.value == "" ))
		{
							
			if(isBeforeNow(fromDate.value, format, locale))
			{
				if (!(toDate.value == null || toDate.value == "" ))
				{
					if(isBeforeNow(toDate.value, format, locale))
					{
						if(!isAfter(toDate.value, fromDate.value, format, locale))
						{
							alert(top.header.getMessage("TO_DT_GR_EQ_FM_DT","CA"));							
							
								toDate.focus();
								return false;							
						}
				
					}
					else
					{
						alert(top.header.getMessage("DATE_NOT_GREATER_SYSDATE","Common"));
						toDate.focus();
						toDate.value = getCurrentDate("DMY",locale);
						return false;
					}
				}
			}
			else
			{
				alert(top.header.getMessage("DATE_NOT_GREATER_SYSDATE","Common"));
				fromDate.focus();
				fromDate.value = getCurrentDate("DMY",locale);
				return false;
			}
		}
	}
	else{
		return false;
	}
 }

 function showCalendarValidate(str)
{
	var flg = showCalendar(str);
	document.getElementById(str).focus();
	return flg;
}

function searchClick()
	{
		
	var group_By=document.forms[0].group_By.value;	
	var fromDate = document.forms[0].from_date.value;
	var toDate = document.forms[0].to_date.value;		
	var locale = document.forms[0].locale.value;		
	var fields = new Array(document.forms[0].from_date,document.forms[0].to_date);
	var names = new Array(getLabel("Common.fromdate.label","COMMON"),getLabel("Common.todate.label","COMMON"));
	
	if(checkFieldsofMst( fields, names, top.content.messageFrame))
	{		
		var passurl = '../jsp/PractAlertResult.jsp?fromDate='+fromDate+'&toDate='+toDate+'&group_By='+group_By;

		top.content.PractAlertResultFr.location.href = passurl ;
		
	}
	else
		document.forms[0].search.disabled = false;
}	

function clearClick()
{	
	top.content.PractAlertResultFr.location.href="../../eCommon/html/blank.html";
	document.location.reload();	
}
