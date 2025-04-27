 function create()
 {
	f_query_add_mod.location.href = "../../eOP/jsp/addModifyOpOnlinereportsrule.jsp" ;
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
	f_query_add_mod.location.href ="../../eOP/jsp/OponlinereportsruleQueryCriteria.jsp" ;
}

async function onBlurgetLoc(fac_id,target)
{

		
		if(target.value == "")
		{
			target.value="";
			document.forms[0].short_desc.value="";
			return;
		}

 await getLocn(fac_id,target);

}

 async function getLocn(fac_id,target) {
	
			   var retVal =    new String();
			   var argumentArray  = new Array() ;
			   var dataNameArray  = new Array() ;
			   var dataValueArray = new Array() ;
			   var dataTypeArray  = new Array() ;
			   var tit="";	   
			   tit=getLabel('Common.Location.label','Common');		
			   
			  sql="SELECT clinic_code code,long_desc  description FROM (SELECT '*All'  clinic_code,'*All' long_desc FROM dual UNION SELECT clinic_code code,long_desc  description FROM op_clinic WHERE facility_id='"+fac_id+"' AND eff_status='E')WHERE UPPER(clinic_code) LIKE UPPER(?) AND UPPER(long_desc) LIKE UPPER(?) ORDER BY 2";

				argumentArray[0] = sql;
				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4] = "1,2";
				argumentArray[5] = target.value;
				argumentArray[6] = DESC_LINK  ;
				argumentArray[7] = DESC_CODE ;				
				retVal = await CommonLookup( tit, argumentArray );							
				if(retVal != null && retVal != "" ) {
					 var ret1=unescape(retVal);
					  arr=ret1.split(",");
					  target.value=arr[1];					
					  document.forms[0].short_desc.value=arr[0];
					  PopService('visit_type');
					  
					/*  PopService.document.forms[1];*/
                 } else {
					target.value = "";
				}				
     }

function apply()
{

	if (! (checkIsValidForProceed()) )
    {
        messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=&err_value=0';
        return false;
    }

	var fields = new Array ()
    var names = new Array (getLabel("Common.Location.label","Common"),
                getLabel("Common.visittype.label","Common"),
                getLabel("Common.report.label","Common")
                );    
	if(f_query_add_mod.document.online_reportsrule_form.function_name.value =="insert")
    {
		//fields[0]= f_query_add_mod.document.online_reportsrule_form.short_desc.options[f_query_add_mod.document.online_reportsrule_form.short_desc.options.selectedIndex]

		fields[0]=f_query_add_mod.document.online_reportsrule_form.short_desc;
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
	if(f_query_add_mod.location.href.indexOf("OponlinereportsruleQueryResult.jsp")!=-1)
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
		 if(confirm(frames[1].getMessage('DELETE_RECORD','COMMON')))
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
	element.text= "------"+getLabel("Common.defaultSelect.label","Common")+"------";
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
				var a=document.forms[0].short_desc.value;				
			//	if (a=="*All")	a="";
				var fnval=document.forms[0].function_name.value;
				
				if (fnval == "insert"){
					
					
					
					var n=document.getElementById("visit_type").options.length;
					var n1=document.getElementById("report_desc").options.length;
				}	
					
				for(var i=0;i<n;i++)
				{
					document.getElementById('visit_type').remove("visit_type");					
				}

				for(var i=0;i<n1;i++)
				{
					document.getElementById('report_desc').remove("report_desc");								
				}

				var HTMLVal = new String();
				HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown='lockKey();'><form name='dum_form' id='dum_form' method='post' action='../../eOP/jsp/OnlieReports.jsp?Chksrc="+nam+"'><input name='Common_Text' id='Common_Text' type='hidden' value='"+a+"'><input name='Service_code' id='Service_code' type='hidden' value='"+code +"'></form></BODY></HTML>";
				parent.messageFrame.document.write(HTMLVal);				
				parent.messageFrame.document.dum_form.submit();
				
			}
		  
		}


