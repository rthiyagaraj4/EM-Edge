<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"  language="java"%>
<% request.setCharacterEncoding("UTF-8");  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<script src='../js/Rep2MasterList_SRR.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>

function run(){
	var error="";

	var Deceasedperiod=getLabel('Common.admissiondate.label','common');
		var names = new Array(getLabel("Common.from.label","Common")+" "+Deceasedperiod,getLabel("Common.to.label","Common")+" "+Deceasedperiod);

	if(f_query_add_mod.document.forms[0].p_fm_admission_date.value==""
	&&f_query_add_mod.document.forms[0].p_to_admission_date.value=="")
	{

		for(i=0;i<2;i++)
		{
		error += getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(names[i])))+"<br>";

		}
		
	}
	else if(f_query_add_mod.document.forms[0].p_fm_admission_date.value!=""
	&&f_query_add_mod.document.forms[0].p_to_admission_date.value=="")
	{

		error = getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(names[1])))+"<br>";

}
	else  if(f_query_add_mod.document.forms[0].p_fm_admission_date.value==""
	&&f_query_add_mod.document.forms[0].p_to_admission_date.value!="")
	{
		error = getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(names[0])))+"<br>";

	}
	else if(f_query_add_mod.document.forms[0].p_fm_admission_date.value!=""
	&&f_query_add_mod.document.forms[0].p_to_admission_date.value!="")
	{

		var obj1=f_query_add_mod.document.forms[0].p_fm_admission_date;
		var obj2=f_query_add_mod.document.forms[0].p_to_admission_date;

		if(isBefore(obj1.value,obj2.value,"DMYHM",localeName)==false)
		{
			var error=getMessage("TO_DT_GR_EQ_FM_DT","SM");
			var Deceasedperiod=getLabel("Common.admissiondate.label","common"); 
			var from_Deceased=getLabel('Common.to.label','common_labels')+" "+Deceasedperiod;
			var to_Deceased=getLabel('Common.from.label','common_labels')+" "+Deceasedperiod;
			error = error.replace('To Date',from_Deceased);
			error = error.replace('From Date',to_Deceased);
		//	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error ;
		}
		
	}
	 if ( error.length != 0 )
		{
        
		   messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+error;
       
        }
		else
		{
       
		var dttime 
		 var dt
        var time
		var p_fm_admission_date=f_query_add_mod.document.forms[0].p_fm_admission_date.value;

			dttime = p_fm_admission_date.split(" ");
			var from=f_query_add_mod.document.forms[0].p_fm_admission_date.value;
			var to=f_query_add_mod.document.forms[0].p_to_admission_date.value;

			 if(dttime.length>1)
			{
					  dt=dttime[0]
				time=dttime[1]
			}

			f_query_add_mod.document.forms[0].p_fm_admission_date.value=dt+time;


			   var p_to_admission_date=f_query_add_mod.document.forms[0].p_to_admission_date.value;

				 dttime = p_to_admission_date.split(" ");

			 if(dttime.length>1)
			{
					  dt=dttime[0]
				time=dttime[1]
			}

			f_query_add_mod.document.forms[0].p_to_admission_date.value=dt+time;;
					
			f_query_add_mod.document.Rep2AdmissionForm.submit() ;

			f_query_add_mod.document.forms[0].p_fm_admission_date.value=from;
			f_query_add_mod.document.forms[0].p_to_admission_date.value=to;
		}
	}
</script>
<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%= source %> frameborder='0' scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe scrolling="no" name='f_query_add_mod' id='f_query_add_mod' src='../jsp/Rep2AdmissionDet_SRR.jsp'  frameborder=0 style='height:80vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:40%;width:100vw'></iframe>
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

