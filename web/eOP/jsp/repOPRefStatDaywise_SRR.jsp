<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function reset(){
	
	if(parent.frames[1].frames[1].document.repOPRefStatDaywiseform){
	parent.frames[1].frames[1].document.location.reload() ;
	}else{
	frames[1].document.location.reload() ;
	}

}
function run() 
{
	var fields = new Array ( f_query_add_mod.document.repOPRefStatDaywiseform.p_fm_mon_yr);
		
	 //var names = new Array(getLabel("Common.month.label","Common")+"/"+getLabel("Common.year.label","Common"));
	 var names = new Array(getLabel("eOP.ForMonthYear.label","OP"));

	if(f_query_add_mod.checkFields( fields, names, messageFrame)) {
		
		/*var month = f_query_add_mod.document.repOPRefStatDaywiseform.p_p_month;
		var year     = f_query_add_mod.document.repOPRefStatDaywiseform.p_p_year ;   
		  
		f_query_add_mod.document.repOPRefStatDaywiseform.p_month.value = month.value + '/' + year.value ;	*/

      var mon_yr=f_query_add_mod.document.repOPRefStatDaywiseform.p_fm_mon_yr.value;
	  f_query_add_mod.document.repOPRefStatDaywiseform.p_month.value=mon_yr;
//alert(f_query_add_mod.document.repOPRefStatDaywiseform.p_month.value);
		if(CheckString1(getLabel("Common.SpecialtyCode.label","Common"),f_query_add_mod.document.forms[0].p_specialty_from,f_query_add_mod.document.forms[0].p_specialty_to,messageFrame))  
		if(CheckString1(getLabel("Common.locationcode.label","Common"),f_query_add_mod.document.forms[0].p_loc_from,f_query_add_mod.document.forms[0].p_loc_to,messageFrame))
		
		f_query_add_mod.document.repOPRefStatDaywiseform.submit() ;
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
<iframe name='commontoolbarFrame' id='commontoolbarFrame' frameborder=0 scrolling='no' noresize src='<%=source%>' style='height:8vh;width:100vw'></iframe>
<iframe name='f_query_add_mod' id='f_query_add_mod'  noresize  frameborder=no marginheight=0 marginwidth=0 scrolling='no' src='../../eOP/jsp/repOPRefStatDaywiseform_SRR.jsp' style='height:80vh;width:100vw'></iframe>
<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>
</html>

