<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,webbeans.eCommon.*" %>

<%@ page import="java.sql.*,webbeans.eCommon.*" %>
<%@ page language="java"%>
<html>
<head>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link>
</head>
<script src='../../eIP/js/Rep2MasterList.js' language='javascript'></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js" language='javascript'></script>
<script src="../../eCommon/js/common.js" language='javascript'></script>
<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<script src="../../eCommon/js/messages.js" language='javascript'></script>


<script>
function reset() 
{
	f_query_add_mod.document.Rep2DailyIPCensusSpecialityForm.reset() ;
}

function run() 
{
	
		/*var frmdate = f_query_add_mod.document.Rep2DailyIPCensusSpecialityForm.P_FM_TRN_DATE;
		var todate     = f_query_add_mod.document.Rep2DailyIPCensusSpecialityForm.P_TO_TRN_DATE ; 
		
		
		if(frmdate.value == "") 
		{
			var err = getMessage('FROM_DATE_CANNOT_BE_BLANK');
				err = err.replace('$','From Date');


		if(todate.value == "")
			{
	
			  err = err +'<br>'+ getMessage('TO_DT_NOT_BLANK');
				err = err.replace('$','To Date');
				

			}
			messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+err;

			return false;
		}
		
	if(todate.value != "")
		{
			if(doDateCheckAlert(frmdate,todate) == false ) {
				    todate.focus();
                    todate.select();
					var msg = getMessage("FM_DATE_GR_TO_DATE");
                    	messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg;
                }
			else			
			f_query_add_mod.document.Rep2DailyIPCensusSpecialityForm.submit() ;
		}
		else
	{
			var err1 = getMessage('TO_DT_NOT_BLANK');
				todate.focus();
		                
				//err1 = err1.replace('$','To Date');
				messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+err1;
			return false;
		}*/

		if(f_query_add_mod.document.Rep2DailyIPCensusSpecialityForm)
		 {
		 /*
		var fields = new Array(f_query_add_mod.document.Rep2DailyIPCensusSpecialityForm.P_FM_TRN_DATE,f_query_add_mod.document.Rep2DailyIPCensusSpecialityForm.P_TO_TRN_DATE);
		 var names = new Array (getLabel('eIP.CensusDateRange.label','IP')+' '+getLabel('Common.from.label','Common') ,getLabel('eIP.CensusDateRange.label','IP')+' '+getLabel('Common.to.label','Common'))

	    // if(f_query_add_mod.checkFields( fields, names, messageFrame))

	     if(f_query_add_mod.checkFields( fields, names, messageFrame))
		 {
		  f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
          f_query_add_mod.document.forms[0].target="messageFrame"
		  f_query_add_mod.document.Rep2DailyIPCensusSpecialityForm.submit() ;
		 }
		 }*/

		 if(f_query_add_mod.document.Rep2DailyIPCensusSpecialityForm)
		 {
		 var fields = new Array(f_query_add_mod.document.Rep2DailyIPCensusSpecialityForm.census_date_from,f_query_add_mod.document.Rep2DailyIPCensusSpecialityForm.census_date_to);
		 var names = new Array (getLabel('eIP.CensusDateRange.label','IP')+' '+getLabel('Common.from.label','Common') ,getLabel('eIP.CensusDateRange.label','IP')+' '+getLabel('Common.to.label','Common'))

	     if(f_query_add_mod.checkFields( fields, names, messageFrame))
		 {
			  if(chkGrtr(f_query_add_mod.document.Rep2DailyIPCensusSpecialityForm.census_date_from,
				f_query_add_mod.document.Rep2DailyIPCensusSpecialityForm.census_date_to)==true)
			{
				 f_query_add_mod.document.Rep2DailyIPCensusSpecialityForm.submit() ;
			
			}
		
		 }


		 }
		
			
		
	}

	

</script>

<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%= source %> frameborder='0' scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe scrolling="no" name='f_query_add_mod' id='f_query_add_mod' src='../../eIP/jsp/Rep2DateRangeCensusSpecialty.jsp'  frameborder=0 style='height:83vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
</html>

