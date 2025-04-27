function apply() 
{	
	var fields = new Array ();
	var names = new Array ();
	fields[0]=  f_query_add_mod.document.mp_purge_audit_form.Purge_Date;
	names[0] =getLabel('eMP.PurgeDate.label','MP');
	if (f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
	{
	if(f_query_add_mod.purgeDateCheck(f_query_add_mod.document.mp_purge_audit_form.Purge_Date))
		{
			f_query_add_mod.document.forms[0].action="../../servlet/eMP.mpPurgeAuditServlet";
    		f_query_add_mod.document.forms[0].target="messageFrame";
			f_query_add_mod.document.mp_purge_audit_form.submit();                
		}
		else
		{
			//messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
			//f_query_add_mod.document.mp_purge_audit_form.Purge_Date.select();
			//f_query_add_mod.document.mp_purge_audit_form.Purge_Date.focus();
		}
	}
}

function call()
{
	parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num= &err_val=1'
}


function reset() {
    f_query_add_mod.document.mp_purge_audit_form.reset();
    f_query_add_mod.document.mp_purge_audit_form.Purge_Date.focus();	
}
	

function purgeDateCheck(from)
{ 	
	if(validDateObj(from,"DMY",localeName))
    {
        var fromarray;
        var toarray;
        var fromdate = self.document.forms[0].Purge_Date.value;
		var untilPurge = self.document.forms[0].purgedUntil.value;
	/*	if(localeName !="en")
		{
		fromdate=convertDate(fromdate,"DMY",localeName,"en");
		untilPurge=convertDate(untilPurge,"DMY",localeName,"en");
		}*/
        var todate = self.document.forms[0].system_date.value;
        
        if(fromdate!="" && todate!="" )
        {
			
               // fromarray = fromdate.split("/");
              //  toarray = todate.split("/");
            //    var days = eval(eval(toarray[0]));
            //    var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
            //    var todt = new Date(toarray[2],toarray[1],days);
				if (!isBeforeNow(fromdate,"DMY", localeName))
				{
					var msg = getMessage("PURGE_DATE_GR_CURRENT","MP");
                        from.focus();
                        from.select();	
						parent.frames[2].location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
                        return false;
				}
               /* if(Date.parse(fromdt)> Date.parse(todt))
                {
						var msg = getMessage("PURGE_DATE_GR_CURRENT","MP");
                        from.focus();
                        from.select();
                        parent.frames[2].location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
                        return false;
                }*/
        }
      if(fromdate.length > 0 && untilPurge.length > 0 )
      {
               // fromarray = fromdate.split("/");
             //   toarray = untilPurge.split("/");
              //  var days = eval(eval(toarray[0]));
             //   var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
            //    var todt = new Date(toarray[2],toarray[1],days);
			
				if (isBefore(fromdate,untilPurge,"DMY", localeName))
				{
					var msg = getMessage("PURGE_DATE_UNTIL","MP");
					from.focus();
					from.select();
					parent.frames[2].location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
					return false;
				}
               /* if(Date.parse(fromdt) <= Date.parse(todt))
                {
						var msg = getMessage("PURGE_DATE_UNTIL","MP");
                        from.focus();
                        from.select();
                        parent.frames[2].location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
                        return false;
                }*/
        }
		
        return true;
    }
    else
        return false;
}

 /*function CheckDate(Object2) {
    var datefield = Object2;
    if (ChkDate(Object2) == false) {
        msg = getMessage("INVALID_DATE_FMT","SM");
        parent.frames[2].location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
        datefield.select();
        datefield.focus();
        return false;
    }
    else {
        return true;
    }
}*/

function trimCheck(inString) {
    var startPos;
    var ch;
    startPos = 0;
    strlength = inString.length;

    for(var i=0;i<=strlength;i++) {
        ch = inString.charAt(startPos);
        if((ch == " ") || (ch == "\b") || (ch == "\f") || (ch == "\n") || (ch == "\r") || (ch == "\n")) {
            startPos++;
        }
    }
    if(startPos == inString.length) return false;
    else return true;
}

function trimString(inString) {
    var outString;
    var startPos;
    var endPos;
    var ch;

    // where do we start?
    startPos = 0;
    ch = inString.charAt(startPos);
    while ((ch == " ") || (ch == "\b") || (ch == "\f") || (ch == "\n") || (ch == "\r") || (ch == "\n")) {
        startPos++;
        ch = inString.charAt(startPos);
    }

    endPos = inString.length - 1;
    ch = inString.charAt(endPos);
    while ((ch == " ") || (ch == "\b") || (ch == "\f") || (ch == "\n") || (ch == "\r") || (ch == "\n")) {
        endPos--;
        ch = inString.charAt(endPos);
    }

    outString = inString.substring(startPos, endPos + 1);

    return outString;
}


function checkFieldsofMst1( fields, names, messageFrame) {
    var errors = "" ;
    for( var i=0; i<fields.length; i++ ) {
        if(trimCheck(fields[i].value)) {
            fields[i].value = trimString(fields[i].value);
        }
        else   
		{
			//errors = errors + "APP-000001 " + names[i] + " cannot be blank..." + "<br>" ;
			errors = getMessage("CAN_NOT_BE_BLANK","Common")+ "<br>" ;
			errors= errors.replace('$',names[i]);
		}
    }
    if ( errors.length != 0 ) {
        messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
        return false ;
    }
    return true ;
}


/*function ChkDate(Object3) {
    var strDate;
    var strDay;
    var strMonth;
    var strYear;
    var datefield = Object3;
    var strDateArray = new Array();
    strDate = datefield.value;
    if (strDate.length == 0) return true;

    strDateArray = strDate.split("/");
    if (strDateArray.length != 3) {
        return false;
    }
    else {
        strDay = strDateArray[0];
        strMonth = strDateArray[1];
        strYear = strDateArray[2];
    }


    if (strYear.length < 4) return false;

    if (isNaN(strDay)==true) return false;
    if (isNaN(strMonth)==true) return false;
    if (isNaN(strYear)==true) return false;

    if (strYear < 1900) return false;

        if (strMonth>12 || strMonth<1)  return false;

    if ((strMonth == 1 || strMonth == 3 || strMonth == 5 || strMonth == 7 || strMonth == 8 || strMonth == 10 || strMonth == 12) && (strDay > 31 || strDay < 1)) return false;

    if ((strMonth == 4 || strMonth == 6 || strMonth == 9 || strMonth == 11) && (strDay > 30 || strDay < 1)) return false;

    if (strMonth == 2) {
        if (strDay < 1) return false;

        if (LeapYear(strYear) == true) {
            if (strDay > 29) return false;
        }
        else {
            if (strDay > 28) return false;
        }
    }
    return true;
}*/

function onSuccess() {

    f_query_add_mod.document.location.reload() ;

}

function GenerateReport()
{
		var fields = new Array ();
        var names = new Array ();
        fields[0]=  parent.f_query_add_mod.document.mp_purge_audit_form.Purge_Date;
        names[0] = getLabel('eMP.PurgeDate.label','MP');
        if (parent.f_query_add_mod.checkFieldsofMst( fields, names, parent.messageFrame))
  //      if (checkFieldsofMst( fields, names, parent.messageFrame))
        {
            if(parent.f_query_add_mod.purgeDateCheck(parent.f_query_add_mod.document.mp_purge_audit_form.Purge_Date))
            {
				var p_purge_date = parent.f_query_add_mod.document.mp_purge_audit_form.Purge_Date.value;
				var p_facility_id = parent.f_query_add_mod.document.mp_purge_audit_form.p_facility_id.value;
				var p_module_id = parent.f_query_add_mod.document.mp_purge_audit_form.p_module_id.value;
				var p_report_id = parent.f_query_add_mod.document.mp_purge_audit_form.p_report_id.value;
				var p_user_name = parent.f_query_add_mod.document.mp_purge_audit_form.p_user_name.value;
				var p_resp_id = parent.f_query_add_mod.document.mp_purge_audit_form.p_resp_id.value;

				var params = '../../eCommon/jsp/report_options.jsp?p_report_id='+p_report_id+'&p_resp_id='+p_resp_id+'&p_module_id='+p_module_id+'&p_facility_id='+p_facility_id+'&p_user_name='+p_user_name+'&purge_date='+p_purge_date;

				parent.messageFrame.location.href= params;
            }
        }
}
