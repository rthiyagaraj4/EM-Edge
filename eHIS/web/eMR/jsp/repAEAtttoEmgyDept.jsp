<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
</head>
<script src='../js/Rep2MasterList.js' language='javascript'></script>
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
	var errors = "" ; 

	if(f_query_add_mod.document.repAEAtttoEmgyDeptForm)
	{
		var function_id = f_query_add_mod.document.forms[0].function_id.value;
		var emrg_clinic = "";
		var emrg_clinic_desc = "";

		if(function_id == "MRAECSCT_V2003")
		{
			emrg_clinic = f_query_add_mod.document.repAEAtttoEmgyDeptForm.p_clinic_code;
			emrg_clinic_desc = getLabel("eMR.EmergencyClinicCode.label","MR");
		}
		
		if(function_id == "MRAECSCT_V2003")
		{
			var fields = new Array ( f_query_add_mod.document.forms[0].p_fm_Date,f_query_add_mod.document.forms[0].p_to_Date,emrg_clinic);
		}else
		{
			var fields = new Array ( f_query_add_mod.document.forms[0].p_fm_Date,f_query_add_mod.document.forms[0].p_to_Date);
		}

		var reptype=f_query_add_mod.document.getElementById("report_type").value;
		 if(reptype=="Y")
		{
			 if(function_id == "MRAECSCT_V2003")
			{
				var names  = new Array ( getLabel("Common.from.label","Common")+' '+getLabel("Common.year.label","Common"),getLabel("Common.to.label","Common")+' '+getLabel("Common.year.label","Common"),emrg_clinic_desc);
			}else
			{
				var names  = new Array ( getLabel("Common.from.label","Common")+' '+getLabel("Common.year.label","Common"),getLabel("Common.to.label","Common")+' '+getLabel("Common.year.label","Common"));
			}
			var names1  = new Array ( getLabel("Common.year.label","Common"));
			if ( f_query_add_mod.checkFields( fields, names, messageFrame) )
			{
					if( f_query_add_mod.CheckString( names1,f_query_add_mod.document.forms[0].p_fm_Date, f_query_add_mod.document.forms[0].p_to_Date, messageFrame ) )
						f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
					f_query_add_mod.document.forms[0].target="messageFrame";
						f_query_add_mod.document.repAEAtttoEmgyDeptForm.submit() ;
			}
		}
		else
		if(reptype=="M")
		{		
			var names1  = new Array ( getLabel("Common.month.label","Common"));
			if(function_id == "MRAECSCT_V2003")
			{
				var names  = new Array ( getLabel("Common.from.label","Common")+' '+getLabel("Common.month.label","Common"),getLabel("Common.to.label","Common")+' '+getLabel("Common.month.label","Common"),emrg_clinic_desc);
			}else
			{
				var names  = new Array ( getLabel("Common.from.label","Common")+' '+getLabel("Common.month.label","Common"),getLabel("Common.to.label","Common")+' '+getLabel("Common.month.label","Common"));
			}
			if(f_query_add_mod.checkFields( fields, names, messageFrame))
			{
				if( f_query_add_mod.checkmonths( names1,f_query_add_mod.document.forms[0].p_fm_Date, f_query_add_mod.document.forms[0].p_to_Date, messageFrame ) )
					f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
				f_query_add_mod.document.forms[0].target="messageFrame";
					f_query_add_mod.document.repAEAtttoEmgyDeptForm.submit() ;
			}	
		}
		else
		{
			if(function_id == "MRAECSCT_V2003")
			{
				var names  = new Array ( getLabel("Common.fromdate.label","Common"),getLabel("Common.todate.label","Common"),emrg_clinic_desc);
			}else
			{
				var names  = new Array ( getLabel("Common.fromdate.label","Common"),getLabel("Common.todate.label","Common"));
			}
			var names1  = new Array ( getLabel("Common.date.label","Common"));
			if(f_query_add_mod.checkFields( fields, names, messageFrame))
			{
					if( f_query_add_mod.doDateCheck( f_query_add_mod.document.forms[0].p_fm_Date, f_query_add_mod.document.forms[0].p_to_Date, messageFrame ) )
						f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
					f_query_add_mod.document.forms[0].target="messageFrame";
						f_query_add_mod.document.repAEAtttoEmgyDeptForm.submit() ;
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
	
	//Added by Ashwini on 08-Apr-2021 for ML-MMOH-CRF-1604
	String function_id = checkForNull(request.getParameter("function_id")) ;
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%= source %> frameborder='0' scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe scrolling="no" name='f_query_add_mod' id='f_query_add_mod' src='../jsp/repAEAtttoEmgyDeptForm.jsp?function_id=<%=function_id%>' frameborder=0 style='height:83vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
</html>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

