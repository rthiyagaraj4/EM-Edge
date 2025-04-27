<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src="../../eOP/js/repResetRunList_SRR.js"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function reset(){
	if(frames[1].document.repPatRecallList){
	frames[1].document.repPatRecallList.reset() ;
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

	if(frames[1].document.repPatRecallList)
	{

	//if( parent.frames[1].frames[1].doDateCheck('Visit Due Date', parent.frames[1].frames[1].document.repPatRecallList.p_fm_visit_due_date,parent.frames[1].frames[1].document.repPatRecallList.p_to_visit_due_date, messageFrame ))
    
	var fields = new Array(frames[1].document.repPatRecallList.p_fm_visit_due_date,
		frames[1].document.repPatRecallList.p_to_visit_due_date );
	var names = new Array((getLabel("eOP.VisitDueDate.label","OP")+" "+getLabel("Common.from.label","Common")), (getLabel("eOP.VisitDueDate.label","OP")+" "+getLabel("Common.to.label","Common")));
	if(frames[1].checkFields( fields, names, messageFrame))
	{

	if(chkGrtr(group_head.document.repPatRecallList.p_fm_visit_due_date,
					group_head.document.repPatRecallList.p_to_visit_due_date)==true)
	if( frames[1].CheckString(getLabel("Common.ServiceCode.label","Common"), frames[1].document.repPatRecallList.p_fm_service_code,frames[1].document.repPatRecallList.p_to_service_code, messageFrame ))
	/*if(frames[1].CheckString(getLabel("eOP.SubServiceCode.label","Op"), frames[1].document.repPatRecallList.p_fm_subservice_code,frames[1].document.repPatRecallList.p_to_subservice_code, messageFrame ))*/
	if( frames[1].CheckString(getLabel("Common.patientId.label","Common"), frames[1].document.repPatRecallList.p_fm_patient_id,frames[1].document.repPatRecallList.p_to_patient_id, messageFrame ))

	if( frames[1].CheckString(getLabel("Common.locationcode.label","Common"), frames[1].document.repPatRecallList.p_fm_locn_code,frames[1].document.repPatRecallList.p_to_locn_code, messageFrame ))
	if( frames[1].CheckString(getLabel("Common.practitionerid.label","Common"), frames[1].document.repPatRecallList.p_fm_pract_id,frames[1].document.repPatRecallList.p_to_pract_id, messageFrame ))
	//if( frames[1].CheckString('Patient type', frames[1].document.repPatRecallList.p_fm_pat_type,frames[1].document.repPatRecallList.p_to_pat_type, messageFrame ))
	frames[1].document.repPatRecallList.submit() ;
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
<iframe name='group_head' id='group_head'  noresize  frameborder=no marginheight=0 marginwidth=0 scrolling='no' src='../../eOP/jsp/repPatRecallList_SRR.jsp' style='height:80vh;width:100vw'></iframe>
<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>
</html>

