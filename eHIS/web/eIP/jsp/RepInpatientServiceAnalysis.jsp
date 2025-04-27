<!DOCTYPE html>
<%@ page language="java"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,webbeans.eCommon.*" %>
<html>
<head>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link>
</head>
<script src='../js/Rep2MasterList.js' language='javascript'></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<script>
function reset() 
{
	f_query_add_mod.document.Rep2InpatientServiceAnalysisForm.reset() ;
}

function run() 
{
		if(f_query_add_mod.document.Rep2InpatientServiceAnalysisForm)
		 {
		 var fields = new Array(f_query_add_mod.document.Rep2InpatientServiceAnalysisForm.P_FM_TRN_DATE,f_query_add_mod.document.Rep2InpatientServiceAnalysisForm.P_TO_TRN_DATE);
		 var names = new Array (getLabel('eIP.CensusDateRange.label','IP')+' '+getLabel('Common.from.label','Common') ,getLabel('eIP.CensusDateRange.label','IP')+' '+getLabel('Common.to.label','Common'))

	     if(f_query_add_mod.checkFields( fields, names, messageFrame))
		 {

			 if(chkGrtr(f_query_add_mod.document.Rep2InpatientServiceAnalysisForm.P_FM_TRN_DATE,
				f_query_add_mod.document.Rep2InpatientServiceAnalysisForm.P_TO_TRN_DATE)==true)
			{
				 f_query_add_mod.document.Rep2InpatientServiceAnalysisForm.submit() ;
			
			}


		
		 }
		 }
	   	}

		function chkGrtr(obj1,obj2)
{
		if(isBefore(obj1.value,obj2.value,"DMY",localeName)==false)
		{
			var error=getMessage("TO_DT_GR_EQ_FM_DT","SM");
		
			var Deceasedperiod=getLabel("eIP.CensusDateRange.label" ,"IP"); 
			var from_Deceased=getLabel('Common.to.label','common_labels')+" "+Deceasedperiod;
			var to_Deceased=getLabel('Common.from.label','common_labels')+" "+Deceasedperiod;
			error = error.replace('To Date',from_Deceased);
			error = error.replace('From Date',to_Deceased);
		
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error ;
            return false;
		}
		else 
			return true;
}


</script>

<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;

	
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%= source %> frameborder='0' scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe scrolling="no" name='f_query_add_mod' id='f_query_add_mod' src='../jsp/Rep2InpatientServiceAnalysis.jsp'  frameborder=0 style='height:80vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:40%;width:100vw'></iframe>
</html>

