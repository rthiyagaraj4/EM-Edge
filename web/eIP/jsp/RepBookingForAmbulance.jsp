<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");  %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<script>
	function reset()
	{
		f_query_add_mod.document.forms[0].reset();
	}

	function run()
	{
		var continue_yn = "Y";
		if(f_query_add_mod.document.BkgListForAmbulance.p_fm_ambl_date_time.value != "" && f_query_add_mod.document.BkgListForAmbulance.p_to_ambl_date_time.value != "")
		{
			if(!ValidateDateTime(f_query_add_mod.document.BkgListForAmbulance.p_fm_ambl_date_time,f_query_add_mod.document.BkgListForAmbulance.p_to_ambl_date_time))
			{
				continue_yn = "N";
				var errors = getMessage("TO_DT_TIME_GREATER_FROM","IP") 
				messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
			}
			else
			{
				continue_yn = "Y";
			}
		}

		if(continue_yn == "Y")
		{
		if( ValidateDates(f_query_add_mod.document.BkgListForAmbulance.p_fm_pref_date.value,f_query_add_mod.document.BkgListForAmbulance.sys_date.value,"From") )
		if( ValidateDates(f_query_add_mod.document.BkgListForAmbulance.p_to_pref_date.value,f_query_add_mod.document.BkgListForAmbulance.sys_date.value,"To") )
		if( doDateCheck(f_query_add_mod.document.BkgListForAmbulance.p_fm_pref_date,f_query_add_mod.document.BkgListForAmbulance.p_to_pref_date, messageFrame )  )
		if( CheckString('Nursing Unit Code', f_query_add_mod.document.BkgListForAmbulance.p_fm_nursing_unit,f_query_add_mod.document.BkgListForAmbulance.p_to_nursing_unit, messageFrame )  )
		if( CheckString('Specialty Code', f_query_add_mod.document.BkgListForAmbulance.p_fm_specialty_code,f_query_add_mod.document.BkgListForAmbulance.p_to_specialty_code, messageFrame )  )
		if( CheckString('Nationality Code', f_query_add_mod.document.BkgListForAmbulance.p_fm_nationality_code,f_query_add_mod.document.BkgListForAmbulance.p_to_nationality_code, messageFrame )  )
			f_query_add_mod.document.BkgListForAmbulance.submit() ;
		}
	}

	function ValidateDates(from,to,chkstr)
	{	
		var splitdate1 = from.split("/")
		 var from_date = new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]))

		 splitdate2 = to.split("/")
		 var to_date = new Date(eval(splitdate2[2]), eval(splitdate2[1]), eval(splitdate2[0]))

		 if(Date.parse(to_date) > Date.parse(from_date))
		{
			var err = getMessage("PREF_ADMDATE_LESS_SYSDATE","IP");
			messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+err;

			if(chkstr == "From")
			{
				f_query_add_mod.document.forms[0].p_fm_pref_date.focus();
				f_query_add_mod.document.forms[0].p_fm_pref_date.select();
			}
			else if(chkstr == "To")
			{
				f_query_add_mod.document.forms[0].p_to_pref_date.focus();
				f_query_add_mod.document.forms[0].p_to_pref_date.select();
			}
				 
			return false
		}
		else
		{
			return true;
		}	
	}	
</script>
<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%= source %> frameborder='0' scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe scrolling="no" name='f_query_add_mod' id='f_query_add_mod' src='../jsp/RepBookingForAmbulanceForm.jsp'  frameborder=0 style='height:80vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:40%;width:100vw'></iframe>
</html>

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

