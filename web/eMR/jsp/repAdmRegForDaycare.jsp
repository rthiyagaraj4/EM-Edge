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
<script src="../../eCommon/js/common.js"></script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>

function reset()
{
f_query_add_mod.document.location.reload();
}

function run()
{     var names = new Array();
		var toLabel="";
		var fromLabel="";
		if(f_query_add_mod.document.repAdmRegFormDayCare)
		{
		var flag=true;
		var fields = new Array(f_query_add_mod.document.forms[0].p_fm_Date,f_query_add_mod.document.forms[0].p_to_Date);
		if(f_query_add_mod.document.forms[0].rep_period_type.value=='D'){
		if (!f_query_add_mod.doDateCheck(f_query_add_mod.document.forms[0].p_fm_Date,f_query_add_mod.document.forms[0].p_to_Date, messageFrame))	{
		flag=false;	
		}}
		if(f_query_add_mod.document.forms[0].rep_period_type.value=='M'){
			var names1  = new Array ( getLabel("Common.month.label","Common"));
		if( !f_query_add_mod.checkmonths( names1,f_query_add_mod.document.forms[0].p_fm_Date, f_query_add_mod.document.forms[0].p_to_Date, messageFrame ) ){
		flag=false;
		}}		}
		if(f_query_add_mod.document.forms[0].rep_period_type.value=='Y'){
			var names2  = new Array ( getLabel("Common.year.label","Common"));
			if( !f_query_add_mod.CheckString( names2,f_query_add_mod.document.forms[0].p_fm_Date, f_query_add_mod.document.forms[0].p_to_Date, messageFrame ) ){
				
			flag=false;
			}
		}
		
			
		//var names = new Array (escape("Admission From Date"),escape("Admission To Date"))
		if (f_query_add_mod.document.forms[0].p_type.value=='A')
		{
			if (f_query_add_mod.document.forms[0].rep_period_type.value=='D')
			{	
				fromLabel=getLabel("Common.admission.label","Common")+"&nbsp;"+getLabel("Common.DateFrom.label","Common");
				toLabel=getLabel("Common.admission.label","Common")+"&nbsp;"+getLabel("Common.DateTo.label","Common");
			}
			if (f_query_add_mod.document.forms[0].rep_period_type.value=='M')
			{	
				fromLabel=getLabel("Common.admission.label","Common")+"&nbsp;"+getLabel("Common.MonthFrom.label","Common");
				toLabel=getLabel("Common.admission.label","Common")+"&nbsp;"+getLabel("Common.MonthTo.label","Common");
			}
			if (f_query_add_mod.document.forms[0].rep_period_type.value=='Y')
			{	
				fromLabel=getLabel("Common.admission.label","Common")+"&nbsp;"+getLabel("Common.year.label","Common")+"&nbsp;"+getLabel("Common.from.label","Common");
				toLabel=getLabel("Common.admission.label","Common")+"&nbsp;"+getLabel("Common.year.label","Common")+"&nbsp;"+getLabel("Common.to.label","Common");
			}
		}
		else if (f_query_add_mod.document.forms[0].p_type.value=='D')
		{
			if (f_query_add_mod.document.forms[0].rep_period_type.value=='D')
			{	
				fromLabel=getLabel("Common.Discharge.label","Common")+"&nbsp;"+getLabel("Common.DateFrom.label","Common");
				toLabel=getLabel("Common.Discharge.label","Common")+"&nbsp;"+getLabel("Common.DateTo.label","Common");
			}
			if (f_query_add_mod.document.forms[0].rep_period_type.value=='M')
			{	
				fromLabel=getLabel("Common.Discharge.label","Common")+"&nbsp;"+getLabel("Common.MonthFrom.label","Common");
				toLabel=getLabel("Common.Discharge.label","Common")+"&nbsp;"+getLabel("Common.MonthTo.label","Common");
			}
			if (f_query_add_mod.document.forms[0].rep_period_type.value=='Y')
			{	
				fromLabel=getLabel("Common.Discharge.label","Common")+"&nbsp;"+getLabel("Common.year.label","Common")+"&nbsp;"+getLabel("Common.from.label","Common");
				toLabel=getLabel("Common.Discharge.label","Common")+"&nbsp;"+getLabel("Common.year.label","Common")+"&nbsp;"+getLabel("Common.to.label","Common");
			}
		}
		
		if (f_query_add_mod.document.forms[0].p_fm_Date.value == "")
		      names.push(escape(fromLabel));
		if (f_query_add_mod.document.forms[0].p_to_Date.value == ""){
			 names.push(escape(toLabel));
			 names.push(escape(toLabel));}
						
		
		if(!f_query_add_mod.checkFields( fields, names, messageFrame))
		   {
			flag=false;
		   }
			if (!f_query_add_mod.CheckString(getLabel("Common.speciality.label","Common"), f_query_add_mod.document.forms[0].P_FM_SPECIALITY_CODE,f_query_add_mod.document.forms[0].P_TO_SPECIALITY_CODE, messageFrame)){
			flag=false;
			}
			if (!f_query_add_mod.CheckString(getLabel("Common.Location.label","Common"), f_query_add_mod.document.forms[0].P_FM_CLINIC_CODE,f_query_add_mod.document.forms[0].P_TO_CLINIC_CODE, messageFrame)){
				flag=false;
			}		     
			
			if(flag==true){
				f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
				f_query_add_mod.document.forms[0].target="messageFrame";
			f_query_add_mod.document.repAdmRegFormDayCare.submit() ;
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
	<iframe scrolling="no" name='f_query_add_mod' id='f_query_add_mod' src='../jsp/repAdmRegFormForDaycare.jsp'  frameborder=0 style='height:83vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
</html>

