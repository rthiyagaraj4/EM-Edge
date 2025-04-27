<!DOCTYPE html>
<%
/*
Sr No        Version              TFS              SCF/CRF           	   				 Developer Name
-------------------------------------------------------------------------------------------------------
1            V211228            26735       PMG2021-COMN-CRF-0089.1-TF-US001            Mohanapriya K
*/
%>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<HTML>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src='../../eCommon/js/CommonLookup.js'></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="javascript" src="../../eCommon/js/dchk.js"></script>
	<script language="JavaScript" src="../../eOR/js/TeleRadiologyOrders.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
		//To disable reset btn
		$(document).ready(function () {
			 commontoolbarFrame.document.forms[0].reset.disabled = true;
		});
	</script>
<%
	String params = request.getQueryString();
	System.err.println("params--"+params);
	if(params==null || params.equals("")) params="";
	String function_id=request.getParameter("function_id");
	String module_id=request.getParameter("module_id");
	if(function_id==null || function_id.equals("")) function_id="";
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?home_required_yn=Y";
	String source = url + params;
	
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder=0 scrolling='no'  noresize style='height:6vh;width:100vw'></iframe>
	<iframe name='RadiologyExamSearchHdr' id='RadiologyExamSearchHdr' src='../../eRD/jsp/RadiologyExamSearchCriteria.jsp?<%=params%>' frameborder=0 style='height:18vh;width:100vw'></iframe><iframe name='RadiologyExamSearchValues' id='RadiologyExamSearchValues' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' style='height:64vh;width:100vw'></iframe><iframe name='RadiologyExamSubmit' id='RadiologyExamSubmit' src='../../eCommon/html/blank.html' frameborder=0 style='height:7vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:5vh;width:100vw'></iframe>
</HTML>
6%,18%,64%,7%,5%
