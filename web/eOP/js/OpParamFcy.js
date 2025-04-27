function create() {
    f_query_add_mod.location.href = "../../eOP/jsp/addModifyOpParamFcy.jsp" ;
}

function edit() {
    formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() {
    f_query_add_mod.location.href ="../../eOP/jsp/OpParamFcyQueryCriteria.jsp?function=OpParamFcy" ;
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
        messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=&err_value=0';
        return false;
    }

if(f_query_add_mod.document.OpParamFcy_form.function_name.value== "insert")
{
    var fields = new Array ( f_query_add_mod.document.OpParamFcy_form.operating_facility_id,
                f_query_add_mod.document.OpParamFcy_form.service_code,

                f_query_add_mod.document.OpParamFcy_form.episode_close_days_fu,
                f_query_add_mod.document.OpParamFcy_form.episode_close_days_wo_fu,
					f_query_add_mod.document.OpParamFcy_form.no_of_visits_months,
					 f_query_add_mod.document.OpParamFcy_form.no_of_future_appts_months,
				 f_query_add_mod.document.OpParamFcy_form.consecutive_no_shows,
				 f_query_add_mod.document.OpParamFcy_form.consecutive_no_shows_months
				 
				
				 
                            );
    var names = new Array ( getLabel("Common.facility.label","Common"),
                getLabel("Common.service.label","Common"),
                getLabel("Common.followup.label","Common"),
                getLabel("eOP.NoFollowup.label","Op"),
                getLabel("eOP.NoVisitsInLast.label","Op"),
                getLabel("eOP.NoFutApptsIn.label","Op"),
                getLabel("eOP.ConsecutiveNoShows.label","Op"),
                getLabel("eOP.ConsecutiveNoShows.label","Op")+' '+getLabel("Common.months.label","Common")

                  );
}
else if(f_query_add_mod.document.OpParamFcy_form.function_name.value== "modify")
{
    var fields = new Array ( f_query_add_mod.document.OpParamFcy_form.facilityid,
                f_query_add_mod.document.OpParamFcy_form.servicecode,

                f_query_add_mod.document.OpParamFcy_form.episode_close_days_fu,
                f_query_add_mod.document.OpParamFcy_form.episode_close_days_wo_fu,
					 f_query_add_mod.document.OpParamFcy_form.no_of_visits_months,
					 f_query_add_mod.document.OpParamFcy_form.no_of_future_appts_months,
				 f_query_add_mod.document.OpParamFcy_form.consecutive_no_shows,
				 f_query_add_mod.document.OpParamFcy_form.consecutive_no_shows_months
				
				
                            );
    var names = new Array ( getLabel("Common.facility.label","Common"),
                getLabel("Common.service.label","Common"),
                getLabel("Common.followup.label","Common"),
                getLabel("eOP.NoFollowup.label","Op"),
				getLabel("eOP.NoVisitsInLast.label","Op"),
                getLabel("eOP.NoFutApptsIn.label","Op"),
                getLabel("eOP.ConsecutiveNoShows.label","Op"),
                getLabel("eOP.ConsecutiveNoShows.label","Op")+' '+getLabel("Common.months.label","Common")

                  );
}
if(f_query_add_mod.checkFields( fields, names, messageFrame))
{
        f_query_add_mod.document.OpParamFcy_form.submit();
        var fn_status = f_query_add_mod.document.OpParamFcy_form.function_name.value ;
}
}

function onSuccess()
{
    if(f_query_add_mod.document.OpParamFcy_form.function_name.value== "insert")
    {
        reset();
    }
}

function OPCheckPositiveNumber(obj) {
	if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) {		
	}
	else {
  		if ( obj.value.length > 0 ) 
		{
			var error = f_query_add_mod.getMessage('ONLY_POSITIVE_NUM','SM');
			alert(error);
  			obj.select();
  			obj.focus();
  		}
  	}
}

function reset() {

  /*  if(f_query_add_mod.document.forms[0].name == "OpParamFcy_form")
	{
      
		
		ClearList(f_query_add_mod.document.OpParamFcy_form.service_code);

		f_query_add_mod.document.OpParamFcy_form.reset() ;
	
	}
    else
		{ 
	
		f_query_add_mod.document.query_form.reset() ;
		
		}*/

		if(f_query_add_mod.location.href.indexOf("OpParamFcyQueryResult.jsp")!=-1)
		     return false;
	 else
			f_query_add_mod.location.reload() ;
}

function valid_dat(Obj)
{
	if ((Obj.value=="0")||(Obj.value=="00")||(Obj.value=="000"))
	{
		alert(getMessage("INVALID_POSITIVE_NUMBER","COMMON"));
		Obj.value="";
		Obj.focus();		
	}
}
/********** added on 11/26/2003******************/
function ClearList(object)
{
    
    
	if (object)
	var length  =object.length;

	var element = f_query_add_mod.document.OpParamFcy_form.document.createElement('OPTION');
    element.text= "------"+getLabel("Common.defaultSelect.label","Common")+"------";
    element.value="";
   
    for(i=1;i<length;i++)
	    object.remove(1);
   

}
/**********************************************************/
// Functions used in addModifyOPParam.jsp

function getservice(Obj)
{
    var u1=Obj.value;
    removeitems(document.forms[0].service_code)
    aa(u1)
}

function aa(v){
	var HTMLVal = new String();
	var u=v;
	HTMLVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><BODY class='message' onKeyDown='lockKey();'><form name='form1' id='form1' method='post' action='../../eOP/jsp/getservice.jsp'><input type='hidden' name='operating_facility_id' id='operating_facility_id' value='"+u+"'></form></BODY></HTML>";
	parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.messageFrame.document.form1.submit();
}

function removeitems(obj)
{
    var len=obj.length;
    var i=1;
    while(i<len)
    {
        len=obj.length
        obj.remove(i)
    }
}

