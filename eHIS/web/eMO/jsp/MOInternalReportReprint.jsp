<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'>
</link> -->
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");

%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eMO/js/MOInternalReport.js'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<script>
function query() 
{
       var dialogHeight= "38";
	   var dialogWidth = "65";
	   var dialogTop = "111";
       var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+"; dialogTop:"+dialogTop+"; status=no" ;
       var arguments   = "" ;
       var encounterid = window.showModalDialog("../../eMO/jsp/MOInternalReportFrameSet.jsp",arguments,features);

      /* if(encounterid!=null)
       {
           var encounterids= encounterid.split("|")
           encounterid=encounterids[0];
				
		   document.location.href = "../../eAe/jsp/AeinternlReportReprintModal.jsp?encounterid="+encounterid+"&file_created_at_regn_yn=N";
	   }*/
}
</script>
<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' src="../../eCommon/html/blank.html" frameborder=0 style='height:100vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:50%;width:100vw'></iframe>
<script>
query();
</script>
</html>

