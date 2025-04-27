<!DOCTYPE html>
<%--
Filename		: repfFcywisePractWorkload.jsp
Modified On		: 1-3-2005
Version			: 3
--%>

<!--script src="../../eMP/js/repClinicStatMonwise.js"></script-->
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% request.setCharacterEncoding("UTF-8"); %>
<script src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>

<script>
function reset()
{
	f_query_add_mod.document.repFcywisePractWorkloadform.reset() ;
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
	var fields = new Array( f_query_add_mod.document.repFcywisePractWorkloadform.p_fm_dt,
		f_query_add_mod.document.repFcywisePractWorkloadform.p_to_dt );
	var names = new Array(getLabel("Common.Period.label","Common")+" "+getLabel("Common.from.label","Common"),getLabel("Common.Period.label","Common")+" "+getLabel("Common.to.label","Common"));
	if(f_query_add_mod.checkFields( fields, names, messageFrame))
	{
		var fromdate = f_query_add_mod.document.repFcywisePractWorkloadform.p_fm_dt;
		var todate   = f_query_add_mod.document.repFcywisePractWorkloadform.p_to_dt ; 
		if(chkGrtr(fromdate,todate)==true)
			{
				f_query_add_mod.document.repFcywisePractWorkloadform.p_fr_date.value = fromdate.value ;
				f_query_add_mod.document.repFcywisePractWorkloadform.p_to_date.value = todate.value ;
		
		if( CheckString1(getLabel('Common.SpecialtyCode.label','Common'), f_query_add_mod.document.repFcywisePractWorkloadform.p_fm_specialty_code,f_query_add_mod.document.repFcywisePractWorkloadform.p_to_specialty_code, messageFrame )  )

		if( CheckString1(getLabel('Common.locationcode.label','Common'), f_query_add_mod.document.repFcywisePractWorkloadform.p_fm_locn,f_query_add_mod.document.repFcywisePractWorkloadform.p_to_locn, messageFrame )  )

		if(CheckString1(getLabel("Common.practitionerid.label","Common"),			f_query_add_mod.document.repFcywisePractWorkloadform.p_fm_practitoner,f_query_add_mod.document.repFcywisePractWorkloadform.p_to_practitoner,messageFrame))
			
		f_query_add_mod.document.repFcywisePractWorkloadform.submit() ;
			
		  
		}
}
}

function CheckString1(str ,fromobj,toobj,messageFrame) {

	 var arr = new Array(toobj.value,fromobj.value);
    if( trimCheck(fromobj.value) && trimCheck(toobj.value) ) {
        if(fromobj.value <= toobj.value) {
            return true;
        }
        else {
			var error=getMessage("REMARKS_MUST_GR_EQUAL","common",arr);
		
			error=error.replace("$",getLabel('Common.to.label','common_labels')+ ' ' +str);
			error=error.replace("#",str);
            messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error  ;
            return false;
        }
    }
    else {
        return true;
    }
}

</script>
<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>

<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' 		src='../../eOP/jsp/repFcywisePractWorkloadform_SRR.jsp' frameborder=0 style='height:80vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>

