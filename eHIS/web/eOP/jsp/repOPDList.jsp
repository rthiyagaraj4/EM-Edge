<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 

request.setCharacterEncoding("UTF-8"); 
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");

%>
<html>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function reset(){

	
	if(frames[1].document.repOPDListform){
	frames[1].document.repOPDListform.reset() ;
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

function run()
{
	if(frames[1].document.repOPDListform)
	{
	var fields = new Array( frames[1].document.repOPDListform.p_fr_appt_date,
	frames[1].document.repOPDListform.p_to_appt_date );
	var names = new Array(getLabel("Common.VisitDateFrom.label","Common"), getLabel("Common.VisitDateTo.label","Common"));
	if(frames[1].checkFields( fields, names, messageFrame))
	{
		if(chkGrtr(group_head.document.repOPDListform.p_fr_appt_date,
					group_head.document.repOPDListform.p_to_appt_date)==true)
		if( frames[1].CheckString(getLabel("Common.locationcode.label","Common"), frames[1].document.repOPDListform.p_fr_clinic_code,frames[1].document.repOPDListform.p_to_clinic_code, messageFrame ))
		if( frames[1].CheckString(getLabel("Common.speciality.label","Common"), frames[1].document.repOPDListform.p_fr_specialty_code,frames[1].document.repOPDListform.p_to_specialty_code, messageFrame ))
		if(frames[1].CheckString(getLabel("Common.medicalteam.label","Common"), frames[1].document.repOPDListform.p_fr_medical_team,frames[1].document.repOPDListform.p_to_medical_team, messageFrame ))
		if( frames[1].CheckString(getLabel("Common.practitionerid.label","Common"), frames[1].document.repOPDListform.p_fr_physician_id,frames[1].document.repOPDListform.p_to_physician_id, messageFrame ))
		if( frames[1].CheckString(getLabel("Common.visittype.label","Common"), frames[1].document.repOPDListform.p_fr_visit_type,frames[1].document.repOPDListform.p_to_visit_type, messageFrame ))
		{
			frames[1].document.forms[0].action="../../eCommon/jsp/report_options.jsp";
    		frames[1].document.forms[0].target="messageFrame"
			frames[1].document.repOPDListform.submit() ;
			
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
<iframe name='commontoolbarFrame' id='commontoolbarFrame' frameborder=0 scrolling='no' noresize src='<%=source%>' style='height:8vh;width:100vw'></iframe>
<iframe name='group_head' id='group_head'  noresize  frameborder=no marginheight=0 marginwidth=0 scrolling='no' src='../../eOP/jsp/repOPDListform.jsp' style='height:80vh;width:100vw'></iframe>
<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>
</html>

