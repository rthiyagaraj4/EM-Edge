<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% request.setCharacterEncoding("UTF-8"); %>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script>
function reset() {
	f_query_add_mod.document.repClinicStatYearwise.reset() ;
}

function chkGrtr(obj1,obj2)
{
		
		if(isBefore(obj1.value,obj2.value,"YY",localeName)==false)
		{
			var str = getLabel("Common.to.label","Common")+" "+getLabel("Common.year.label","Common");
			var str1 = getLabel("Common.year.label","Common");

			var error=getMessage("REMARKS_MUST_GR_EQUAL","COMMON");
			error=error.replace("$",str);
			error=error.replace("#",str1);
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error ;
            return false;
		}
		else 
			return true;
}

function run() 
{

		var fromyear   = f_query_add_mod.document.repClinicStatYearwise.p_fm_yr;
		var toyear     = f_query_add_mod.document.repClinicStatYearwise.p_to_yr ;   

		f_query_add_mod.document.repClinicStatYearwise.p_fr_year.value = fromyear.value ;
		f_query_add_mod.document.repClinicStatYearwise.p_to_year.value = toyear.value ;

	var fields = new Array( f_query_add_mod.document.repClinicStatYearwise.p_fm_yr,
		f_query_add_mod.document.repClinicStatYearwise.p_to_yr );
	var names = new Array((getLabel("Common.from.label","Common")+" "+getLabel("Common.year.label","Common")), (getLabel("Common.to.label","Common")+" "+getLabel("Common.year.label","Common")));
	if(f_query_add_mod.checkFields( fields, names, messageFrame))
	{
		//if(f_query_add_mod.CheckString( getLabel("Common.year.label","Common"),f_query_add_mod.document.forms[0].p_fm_yr,f_query_add_mod.document.forms[0].p_to_yr,messageFrame))
		if(chkGrtr(frames[1].document.repClinicStatYearwise.p_fm_yr,frames[1].document.repClinicStatYearwise.p_to_year)==true)
		f_query_add_mod.document.repClinicStatYearwise.submit() ;
}
}
</script>
<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>

<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' 		src='../../eOP/jsp/repClinicStatYearwiseform.jsp' frameborder=0 style='height:80vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>

