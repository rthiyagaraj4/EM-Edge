 function create()
 {
	f_query_add_mod.location.href = "../../eAE/jsp/addModifyAeOnlineReportRule.jsp" ;
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



function query()
{
	f_query_add_mod.location.href ="../../eAE/jsp/AeOnlineReportRuleQueryCriteria.jsp" ;
}


function apply()
{

	if (! (checkIsValidForProceed()) )
    {
        messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=&err_value=0';
        return false;
    }

	var fields = new Array ()
    var names = new Array (f_query_add_mod.getLabel("Common.Location.label",'Common'),f_query_add_mod.getLabel("Common.visittype.label",'Common'),f_query_add_mod.getLabel("Common.report.label",'Common'));
    if(f_query_add_mod.document.online_reportsrule_form.function_name.value =="insert")
    {
		fields[0]= f_query_add_mod.document.online_reportsrule_form.short_desc.options[f_query_add_mod.document.online_reportsrule_form.short_desc.options.selectedIndex]
		fields[1]=f_query_add_mod.document.online_reportsrule_form.visit_type.options[f_query_add_mod.document.online_reportsrule_form.visit_type.options.selectedIndex]
        fields[2]=f_query_add_mod.document.online_reportsrule_form.report_desc.options[f_query_add_mod.document.online_reportsrule_form.report_desc.options.selectedIndex]
    }
    else
    {
        fields[0]= f_query_add_mod.document.online_reportsrule_form.short_desc
        fields[1]=f_query_add_mod.document.online_reportsrule_form.visit_type
        fields[2]=f_query_add_mod.document.online_reportsrule_form.report_desc
    }



    if(f_query_add_mod.checkFields( fields, names, messageFrame))
    {
        f_query_add_mod.document.online_reportsrule_form.submit();
        var fn_status = f_query_add_mod.document.online_reportsrule_form.function_name.value ;
        if(fn_status == "insert")  {}
    }
}

function onSuccess()
{
	
	
	if(f_query_add_mod.document.online_reportsrule_form.function_name.value =="insert")
    {
		f_query_add_mod.location.reload() ;

    }else if(f_query_add_mod.document.online_reportsrule_form.function_name.value=="delete")
            f_query_add_mod.location.href ="../../eCommon/html/blank.html";

}

function reset()
{
  /*  if(f_query_add_mod.document.forms[0].name == "online_reportsrule_form")
    {
		f_query_add_mod.document.online_reportsrule_form.reset() ;

		if (f_query_add_mod.document.online_reportsrule_form.print_at_ci_yn1.checked == true)
			f_query_add_mod.document.online_reportsrule_form.print_at_ci_yn.value="Y";
		else
			f_query_add_mod.document.online_reportsrule_form.print_at_ci_yn.value="N";
		
		if(f_query_add_mod.document.forms[0].function_name.value=='insert')
			ClearList(f_query_add_mod.document.forms[0].visit_type);
    }
    else {
		f_query_add_mod.document.query_form.reset() ;
	}*/
	if(f_query_add_mod.location.href.indexOf("AeOnlineReportRuleQueryResult.jsp")!=-1)
		     return false;
	 else
			f_query_add_mod.location.reload() ;

}

function deleterecord()
{

	if (! (checkIsValidForProceed()) )
    {
        messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=&err_value=0';
        return false;
    }
    var status = f_query_add_mod.document.forms[0].function_name.value;
	
		
	if(status != "insert")
    {
		 if(confirm(frames[1].getMessage('DELETE_RECORD','Common')))
		{
			f_query_add_mod.document.forms[0].function_name.value="delete";
			f_query_add_mod.document.forms[0].submit();
		}
		else
			messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';
    }
    else 
    {
        messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
    }
}


/********** added on 12/2/2003******************/
function ClearList(object)
{
	if (object)
	var length  =object.length;

	var element = f_query_add_mod.document.online_reportsrule_form.document.createElement('OPTION');
	element.text= "------Select------";
    element.value="";
   	
    for(i=1;i<length;i++)
		object.remove(1);
}

/**********************************************************/

// JS Functions used in OPOnlineReportsRule.jsp

function PopService(nam,code)
		{
			if(nam=="visit_type")
			{
				var a=document.forms[0].short_desc.options.value;

				if(document.forms[0].short_desc.options.value=='')
				{
					var report_desc	= parent.document.frames[1].document.forms[0].report_desc;
					while(report_desc.options.length > 1){
					report_desc.remove(1);
					}

					var visit_type	= parent.document.frames[1].document.forms[0].visit_type;
					while(visit_type.options.length > 1){
					visit_type.remove(1);
					}

				}else 
					{
				//if (a=="*All")	a="";
				var report_desc	= document.forms[0].report_desc;
				while(report_desc.options.length > 1)
				report_desc.remove(1);

				var fnval=document.forms[0].function_name.value;
				if (fnval == "insert")
					//var n=parent.document.frames[1].document.forms[0].visit_type.options.length;
				var n = document.getElementById("visit_type").options.length;
				else
					var n=1;

				for(var i=0;i<n;i++)
				{
					//parent.document.frames[1].document.forms[0].visit_type.remove("visit_type");
					document.getElementById("visit_type").remove("visit_type");
				}

				var HTMLVal = new String();
				HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></HEAD><BODY CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eAE/jsp/OnlineReports.jsp?Chksrc="+nam+"'><input name='Common_Text' id='Common_Text' type='hidden' value='"+a+"'><input name='Service_code' id='Service_code' type='hidden' value='"+code +"'></form></BODY></HTML>";
				parent.messageFrame.document.write(HTMLVal);
				parent.messageFrame.dum_form.submit();
				}
			}
		}

