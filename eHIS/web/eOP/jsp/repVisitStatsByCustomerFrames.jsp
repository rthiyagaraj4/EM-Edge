<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% request.setCharacterEncoding("UTF-8"); %>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src="../../eCommon/js/CommonCalendar.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src="../../eCommon/js/DateUtils.js"></script>
<script>
function reset() {
	f_query_add_mod.document.reportVisitStatsCustomerform.reset() ;
}
function run() 
{
var fields = new Array ( f_query_add_mod.document.reportVisitStatsCustomerform.p_fm_visit_date,f_query_add_mod.document.reportVisitStatsCustomerform.p_to_visit_date);
var visitDate=getLabel("Common.VisitDate.label","Common");
var names = new Array(getLabel("Common.from.label","Common")+" "+visitDate,getLabel("Common.to.label","Common")+" "+visitDate);
if(f_query_add_mod.checkFields( fields, names, messageFrame)) 
	{
		 if(chkGrtr(f_query_add_mod.document.reportVisitStatsCustomerform.p_fm_visit_date,
				f_query_add_mod.document.reportVisitStatsCustomerform.p_to_visit_date)==true)
			{			    if(f_query_add_mod.CheckString(getLabel("Common.locationcode.label","Common"),f_query_add_mod.document.forms[0].p_fm_locn_code,f_query_add_mod.document.forms[0].p_to_locn_code,messageFrame))
			//	if(f_query_add_mod.CheckString(getLabel("eOP.DisplayInReportCustomerCode1.label","OP"),f_query_add_mod.document.forms[0].p_cust_code1,messageFrame))
				//	if(f_query_add_mod.CheckString(getLabel("eOP.DisplayInReportCustomerCode2.label","OP"),f_query_add_mod.document.forms[0].p_cust_code2,messageFrame))
				
					 /* Shaik mujafar  added as per MMS-QH-CRF-0175 on 28/1/2015 */	
					if(f_query_add_mod.CheckString(getLabel("eOP.DisplayInReportCustomerGroup1.label","OP"),f_query_add_mod.document.forms[0].p_cust_code1,messageFrame))
					if(f_query_add_mod.CheckString(getLabel("eOP.DisplayInReportCustomerGroup2.label","OP"),f_query_add_mod.document.forms[0].p_cust_code2,messageFrame))
				/* mujafar end */


						if(f_query_add_mod.CheckString(getLabel("eOP.VisitRegistrationBy.label","OP"),f_query_add_mod.document.forms[0].p_payable,messageFrame))
						
						 /* Shaik mujafar  added as per MMS-QH-CRF-0175 on 28/1/2015 */
			 if(f_query_add_mod.CheckString(getLabel("Common.encountertype.label","Common"),f_query_add_mod.document.forms[0].p_encounter_type,messageFrame))
			 /* mujafar end */
						
				f_query_add_mod.document.reportVisitStatsCustomerform.submit() ;
			}
	}
}
function chkGrtr(obj1,obj2)
{
		
		if(isBefore(obj1.value,obj2.value,"DMY",localeName)==false)
		{
			var error=getMessage("TO_DT_GR_EQ_FM_DT","SM");
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

<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' 		src='../../eOP/jsp/repVisitStatsByCustomer.jsp' frameborder=0 style='height:80vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>

