<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
 <script>
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
	   
	  

		var fromdate = f_query_add_mod.document.forms[0].fm_date;
		var todate = f_query_add_mod.document.forms[0].to_date;
		
	

		var fields = new Array ( f_query_add_mod.document.forms[0].fm_date,f_query_add_mod.document.forms[0].to_date);
		var names = new Array ( getLabel("Common.fromdate.label","Common"),getLabel("Common.todate.label","Common"));
		if(f_query_add_mod.checkFields( fields, names, messageFrame)) 
		{
			f_query_add_mod.document.forms[0].p_fm_locn_code.value = f_query_add_mod.document.forms[0].fm_locn_code.value;
			f_query_add_mod.document.forms[0].p_to_locn_code.value = f_query_add_mod.document.forms[0].to_locn_code.value;
			
			f_query_add_mod.document.forms[0].p_fm_practitioner_id.value = f_query_add_mod.document.forms[0].fm_practitioner_id.value;
			f_query_add_mod.document.forms[0].p_to_practitioner_id.value = f_query_add_mod.document.forms[0].to_practitioner_id.value;
			if( chkGrtr(fromdate, todate) == true ) 
			{
				f_query_add_mod.document.forms[0].p_fm_date.value = fromdate.value;
				f_query_add_mod.document.forms[0].p_to_date.value = todate.value;
				
         if(CheckString1(getLabel("Common.locationcode.label","Common"),f_query_add_mod.document.forms[0].fm_locn_code,f_query_add_mod.document.forms[0].to_locn_code,messageFrame))
	         if(CheckString1(getLabel("Common.practitionerid.label","Common"),f_query_add_mod.document.forms[0].fm_practitioner_id,f_query_add_mod.document.forms[0].to_practitioner_id,messageFrame))
				 
			 if(CheckString1(getLabel("Common.SpecialtyCode.label","Common"),f_query_add_mod.document.forms[0].p_fm_specialty_code,f_query_add_mod.document.forms[0].p_to_specialty_code,messageFrame))  
				f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
				f_query_add_mod.document.forms[0].target="messageFrame";
				f_query_add_mod.document.forms[0].submit();
			}	
		}
	
	
	
}


function reset() 
{
	f_query_add_mod.document.forms[0].reset();
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
</head>
<%
		String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;
		
%>

<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source%> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' 	src='../../eOP/jsp/repWaitTimeDetailsList.jsp' frameborder=0 style='height:80vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>

</html>

