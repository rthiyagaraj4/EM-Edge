<!DOCTYPE html>

<!--script src="../../eMP/js/repClinicStatMonwise.js"></script-->
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
	f_query_add_mod.document.repClinicStatDaywiseform.reset() ;
}

function run() 
{
var fields = new Array ( f_query_add_mod.document.repClinicStatDaywiseform.p_fm_visit_date,f_query_add_mod.document.repClinicStatDaywiseform.p_to_visit_date);
var visitDate=getLabel("Common.VisitDate.label","op_labels");
var names = new Array(getLabel("Common.from.label","Common")+" "+visitDate, 						getLabel("Common.to.label","Common")+" "+visitDate);
if(f_query_add_mod.checkFields( fields, names, messageFrame)) 
	{
		 if(chkGrtr(f_query_add_mod.document.repClinicStatDaywiseform.p_fm_visit_date,
				f_query_add_mod.document.repClinicStatDaywiseform.p_to_visit_date)==true)
			{
				f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
				f_query_add_mod.document.forms[0].target="messageFrame"; 
				f_query_add_mod.document.repClinicStatDaywiseform.submit() ;
			}

	}
}


function chkGrtr(obj1,obj2)
{
		if(isBefore(obj1.value,obj2.value,"DMY",localeName)==false)
		{
			var error=getMessage("TO_DT_GR_EQ_FM_DT","SM");
			var visitDate=getLabel('Common.VisitDate.label','op_labels')
			var visit_toDate=getLabel('Common.to.label','common_labels')+" "+visitDate;
			var visit_fromDate=getLabel('Common.from.label','common_labels')+" "+visitDate;
			error = error.replace('To Date',visit_toDate);
			error = error.replace('From Date',visit_fromDate);
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
	<iframe name='f_query_add_mod' id='f_query_add_mod' 		src='../../eOP/jsp/repClinicStatDaywiseform.jsp' frameborder=0 style='height:80vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>

