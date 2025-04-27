function create()
{
	f_query_add_mod.location.href = "../../eMO/jsp/addModifyBedForArea.jsp" ;
}

function edit() 
{
	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query()
{
	f_query_add_mod.location.href ="../../eMO/jsp/BedForAreaQueryCriteria.jsp?function=MO_BED_AREA";
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
  
function apply() {
    if (! (checkIsValidForProceed()) )
    {
        messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    }
		var fields = new Array ( f_query_add_mod.document.MOBayForArea_form.bed_no );
		var names  =  new Array (getLabel('Common.Location.label','Common'));
		var error_page = "../../eCommon/jsp/MstCodeError.jsp";
	    if(f_query_add_mod.SpecialCharCheck(fields,names,messageFrame,"M", error_page)){
		var fields = new Array ( f_query_add_mod.document.MOBayForArea_form.area_code,
 		      f_query_add_mod.document.MOBayForArea_form.bed_no);
		var names = new Array (getLabel('Common.area.label','Common'),
					 getLabel('Common.Location.label','Common'));
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))  
		{
			f_query_add_mod.document.MOBayForArea_form.submit();
			var fn_status = f_query_add_mod.document.MOBayForArea_form.function_name.value ;
		}
	}
}

function onSuccess() {
 if(f_query_add_mod.document.MOBayForArea_form.function_name.value=="insert")
  {
	f_query_add_mod.document.MOBayForArea_form.area_code.value	= "" ;
	f_query_add_mod.document.MOBayForArea_form.bed_no.value	= "" ;
	f_query_add_mod.document.MOBayForArea_form.eff_status.checked	=true ;
  }
  f_query_add_mod.location.reload();
}	

function reset() 
{
  if(f_query_add_mod.document.forms[0])
	f_query_add_mod.document.forms[0].reset() ;
}

function checkCond(bed,capacity)
{
	var ac =document.forms[0].area_code.value	
	var htmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><BODY CLASS='MESSAGE' onKeyDown = 'lockKey()'></head>"
	htmlVal += "<form name='frm_temp' id='frm_temp' method='post' action='../../eMO/jsp/MOBedForAreaCapacityCheck.jsp' target='blankFrame'>"
	htmlVal += "<input type=hidden name=area_code value=" +ac + ">"
	htmlVal += "</form></body></html>"
	parent.frames[3].document.write(htmlVal);
	parent.f_query_add_mod.MOBayForArea_form.submit();
       
	 
}

function change() {
if (MOBayForArea_form.eff_status.checked == true)
MOBayForArea_form.eff_status.value="E";
else
MOBayForArea_form.eff_status.value="D";
}

