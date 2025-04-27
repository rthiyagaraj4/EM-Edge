<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <%String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<script src='../js/Rep2MasterList.js' language='javascript'></script>
<!-- <script src='../../eCommon/js/dchk.js' language='javascript'></script> -->
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>

function reset()
{
f_query_add_mod.document.location.reload();
}

function run()
{     
		if(f_query_add_mod.document.repAdmRegForm)
		{
		var fields = new Array(f_query_add_mod.document.forms[0].P_fm_DATE,f_query_add_mod.document.forms[0].P_to_DATE);
		if (f_query_add_mod.doDateCheck(f_query_add_mod.document.forms[0].P_fm_DATE,f_query_add_mod.document.forms[0].P_to_DATE, messageFrame))	 
			{
		//var names = new Array (escape("Admission From Date"),escape("Admission To Date"))
		if (f_query_add_mod.document.forms[0].p_type.value == "A")
		     var names = new Array (escape(getLabel("eIP.AdmDateFrom.label","IP")),escape(getLabel("eIP.AdmDateTo.label","IP")))
		else if (f_query_add_mod.document.forms[0].p_type.value == "D")
			 var names = new Array (escape(getLabel("eIP.DischargeDateFrom.label","IP")),escape(getLabel("eIP.DischargeDateTo.label","IP")))
		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		   {
			if (f_query_add_mod.CheckString(getLabel("Common.speciality.label","Common"), f_query_add_mod.document.forms[0].P_FM_SPECIALITY_CODE,f_query_add_mod.document.forms[0].P_TO_SPECIALITY_CODE, messageFrame))
			
			if (f_query_add_mod.CheckString(getLabel("Common.Location.label","Common"), f_query_add_mod.document.forms[0].P_FM_CLINIC_CODE,f_query_add_mod.document.forms[0].P_TO_CLINIC_CODE, messageFrame))
				f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
			    f_query_add_mod.document.forms[0].target="messageFrame";
		     f_query_add_mod.document.repAdmRegForm.submit() ;
			}
			}
		}
}
</script>
<%
	request.setCharacterEncoding("UTF-8");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%= source %> frameborder='0' scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe scrolling="no" name='f_query_add_mod' id='f_query_add_mod' src='../jsp/repAdmRegForm.jsp'  frameborder=0 style='height:83vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
</html>

