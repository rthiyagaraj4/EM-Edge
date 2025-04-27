<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% request.setCharacterEncoding("UTF-8"); %>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script>
function reset() {
	f_query_add_mod.document.repWalkinWithoutApptform.reset() ;
}

/*function chkGrtrMth(obj1,obj2)
{
		
		if(isBefore(obj1.value,obj2.value,"MM",localeName)==false)
		{
			var str = getLabel("Common.to.label","Common")+" "+getLabel("Common.month.label","Common");
			var str1 = getLabel("Common.month.label","Common");

			var error=getMessage("REMARKS_MUST_GR_EQUAL","common");
			error=error.replace("$",str);
			error=error.replace("#",str1);
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error ;
            return false;
		}
		else 
			return true;
}
function chkGrtrYear(obj1,obj2)
{
		
		if(isBefore(obj1.value,obj2.value,"YY",localeName)==false)
		{
			var str = getLabel("Common.to.label","Common")+" "+getLabel("Common.year.label","Common");
			var str1 = getLabel("Common.year.label","Common");

			var error=getMessage("REMARKS_MUST_GR_EQUAL","common");
			error=error.replace("$",str);
			error=error.replace("#",str1);
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error ;
            return false;
		}
		else 
			return true;
}*/

function chkGrtr(obj1,obj2)
{	
		if(isBefore(obj1.value,obj2.value,'MY',localeName)==false)
		{
			var error=getMessage("TO_DT_GR_EQ_FM_DT","SM");
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error ;
            return false;
		}
		else 
			return true;
		
}


function run() 
{
	/*var fields = new Array( f_query_add_mod.document.repWalkinWithoutApptform.p_fm_mon,
	f_query_add_mod.document.repWalkinWithoutApptform.p_to_mon,
	f_query_add_mod.document.repWalkinWithoutApptform.p_fm_year,
	f_query_add_mod.document.repWalkinWithoutApptform.p_to_year);*/
	var fields = new Array( f_query_add_mod.document.repWalkinWithoutApptform.p_fm_mon_yr,
	f_query_add_mod.document.repWalkinWithoutApptform.p_to_mon_yr)
	

	/*var names = new Array(getLabel("Common.month.label","Common")+" "+getLabel("Common.from.label","Common"), getLabel("Common.month.label","Common")+" "+getLabel("Common.to.label","Common"),getLabel("Common.year.label","Common")+" "+getLabel("Common.from.label","Common"),getLabel("Common.year.label","Common")+" "+getLabel("Common.to.label","Common"));*/

	var names = new Array(getLabel("Common.month.label","Common")+"/"+getLabel("Common.year.label","Common")+" "+getLabel("Common.from.label","Common"), getLabel("Common.month.label","Common")+"/"+getLabel("Common.year.label","Common")+" "+getLabel("Common.to.label","Common"));


	if(f_query_add_mod.checkFields( fields, names, messageFrame))
	{	
	/*var frommon = f_query_add_mod.document.repWalkinWithoutApptform.p_fm_mon;
	var tomon     = f_query_add_mod.document.repWalkinWithoutApptform.p_to_mon ;   
	var fromyear = f_query_add_mod.document.repWalkinWithoutApptform.p_fm_year;
	var toyear     = f_query_add_mod.document.repWalkinWithoutApptform.p_to_year ; 
	
	if(fromyear.value == toyear.value)
    {
	  if(chkGrtrMth(frommon,tomon) == true)
	  {
		if(chkGrtrYear(fromyear,toyear) == true) 
		{
			if (frommon.value!="" && fromyear.value!="")
			*/
			if(chkGrtr(f_query_add_mod.document.repWalkinWithoutApptform.p_fm_mon_yr,f_query_add_mod.document.repWalkinWithoutApptform.p_to_mon_yr)==true){
			/*f_query_add_mod.document.repWalkinWithoutApptform.p_fr_month.value = frommon.value + '/' + fromyear.value ;
			if (tomon.value!="" && toyear.value!="")
			f_query_add_mod.document.repWalkinWithoutApptform.p_to_month.value = tomon.value + '/' + toyear.value ;*/
            f_query_add_mod.document.repWalkinWithoutApptform.p_fr_month.value=f_query_add_mod.document.repWalkinWithoutApptform.p_fm_mon_yr.value;
			f_query_add_mod.document.repWalkinWithoutApptform.p_to_month.value=f_query_add_mod.document.repWalkinWithoutApptform.p_to_mon_yr.value;


			if(f_query_add_mod.CheckString( getLabel("Common.locationcode.label","Common"),f_query_add_mod.document.repWalkinWithoutApptform.p_fm_locn_code,f_query_add_mod.document.repWalkinWithoutApptform.p_to_locn_code,messageFrame))
			if(f_query_add_mod.CheckString( getLabel("Common.SpecialtyCode.label","Common"),f_query_add_mod.document.repWalkinWithoutApptform.p_fm_specialty_code,f_query_add_mod.document.repWalkinWithoutApptform.p_to_specialty_code,messageFrame))
			if(f_query_add_mod.CheckString( getLabel("Common.ServiceCode.label","Common"),f_query_add_mod.document.repWalkinWithoutApptform.p_fm_service_code,f_query_add_mod.document.repWalkinWithoutApptform.p_to_service_code,messageFrame)){
			f_query_add_mod.document.repWalkinWithoutApptform.submit() ;
			}
			}
		//}
	  //}		
	//}
	/*else
	{
		if(chkGrtrYear(fromyear,toyear) == true) 
		{
			f_query_add_mod.document.repWalkinWithoutApptform.p_fr_month.value = frommon.value + '/' + fromyear.value ;
			f_query_add_mod.document.repWalkinWithoutApptform.p_to_month.value = tomon.value + '/' + toyear.value ;
			if(f_query_add_mod.CheckString( getLabel("Common.locationcode.label","Common"),f_query_add_mod.document.repWalkinWithoutApptform.p_fm_locn_code,f_query_add_mod.document.repWalkinWithoutApptform.p_to_locn_code,messageFrame))
			if(f_query_add_mod.CheckString( getLabel("Common.SpecialtyCode.label","Common"),f_query_add_mod.document.repWalkinWithoutApptform.p_fm_specialty_code,f_query_add_mod.document.repWalkinWithoutApptform.p_to_specialty_code,messageFrame))
			if(f_query_add_mod.CheckString( getLabel("Common.ServiceCode.label","Common"),f_query_add_mod.document.repWalkinWithoutApptform.p_fm_service_code,f_query_add_mod.document.repWalkinWithoutApptform.p_to_service_code,messageFrame)){
				f_query_add_mod.document.repWalkinWithoutApptform.submit() ;
			}
		}
	}*/

		/*if(frommon.value == "" && fromyear.value != "") 
		{
			var err = getMessage('CAN_NOT_BE_BLANK','COMMON');
				err = err.replace('$',getLabel("Common.from.label","Common")+""+getLabel("Common.month.label","Common"));
				alert(err);
			return false;
		}

		if(frommon.value != "" && fromyear.value == "")
		{
			var err = getMessage('CAN_NOT_BE_BLANK','COMMON');
				err = err.replace('$',getLabel("Common.from.label","Common")+""+getLabel("Common.year.label","Common"));
				alert(err);
			return false;
		}
		
		if(tomon.value == "" && toyear.value != "") 
		{
			var err = getMessage('CAN_NOT_BE_BLANK','COMMON');
				err = err.replace('$',getLabel("Common.to.label","Common")+""+getLabel("Common.month.label","Common"));
				alert(err);
			return false;
		}

		if(tomon.value != "" && toyear.value == "")
		{
			var err = getMessage('CAN_NOT_BE_BLANK','COMMON');
				err = err.replace('$',getLabel("Common.to.label","Common")+""+getLabel("Common.year.label","Common"));
				alert(err);
			return false;
		}

	if(fromyear.value == toyear.value)
    {
	  if( f_query_add_mod.CheckString(getLabel("Common.month.label","Common"), frommon , tomon, messageFrame ) ) 
	  {
		if( f_query_add_mod.CheckString(getLabel("Common.year.label","Common"), fromyear , toyear, messageFrame ) ) 
		{
			if (frommon.value!="" && fromyear.value!="")
			f_query_add_mod.document.repWalkinWithoutApptform.p_fr_month.value = frommon.value + '/' + fromyear.value ;
			if (tomon.value!="" && toyear.value!="")
			f_query_add_mod.document.repWalkinWithoutApptform.p_to_month.value = tomon.value + '/' + toyear.value ;
			if(f_query_add_mod.CheckString( getLabel("Common.locationcode.label","Common"),f_query_add_mod.document.repWalkinWithoutApptform.p_fm_locn_code,f_query_add_mod.document.repWalkinWithoutApptform.p_to_locn_code,messageFrame))
			if(f_query_add_mod.CheckString( getLabel("Common.speciality.label","Common"),f_query_add_mod.document.repWalkinWithoutApptform.p_fm_specialty_code,f_query_add_mod.document.repWalkinWithoutApptform.p_to_specialty_code,messageFrame))
			if(f_query_add_mod.CheckString( getLabel("Common.ServiceCode.label","Common"),f_query_add_mod.document.repWalkinWithoutApptform.p_fm_service_code,f_query_add_mod.document.repWalkinWithoutApptform.p_to_service_code,messageFrame)){
			f_query_add_mod.document.repWalkinWithoutApptform.submit() ;
			}
		}
	  }		
	}
	else
	{
		if( f_query_add_mod.CheckString(getLabel("Common.year.label","Common"), fromyear , toyear, messageFrame ) ) 
		{
			f_query_add_mod.document.repWalkinWithoutApptform.p_fr_month.value = frommon.value + '/' + fromyear.value ;
			f_query_add_mod.document.repWalkinWithoutApptform.p_to_month.value = tomon.value + '/' + toyear.value ;
			if(f_query_add_mod.CheckString( getLabel("Common.locationcode.label","Common"),f_query_add_mod.document.repWalkinWithoutApptform.p_fm_locn_code,f_query_add_mod.document.repWalkinWithoutApptform.p_to_locn_code,messageFrame))
			if(f_query_add_mod.CheckString( getLabel("Common.SpecialtyCode.label","Common"),f_query_add_mod.document.repWalkinWithoutApptform.p_fm_specialty_code,f_query_add_mod.document.repWalkinWithoutApptform.p_to_specialty_code,messageFrame))
			if(f_query_add_mod.CheckString( getLabel("Common.ServiceCode.label","Common"),f_query_add_mod.document.repWalkinWithoutApptform.p_fm_service_code,f_query_add_mod.document.repWalkinWithoutApptform.p_to_service_code,messageFrame)){
				f_query_add_mod.document.repWalkinWithoutApptform.submit() ;
			}
		}
	}*/
}
}
</script>
<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>

<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' 		src='../../eOP/jsp/repWalkinWithoutApptform_SRR.jsp' frameborder=0 style='height:80vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>

