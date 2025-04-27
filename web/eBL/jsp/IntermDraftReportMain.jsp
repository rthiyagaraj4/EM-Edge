 <!DOCTYPE html>
<!-- 
Sr No        Version           Incident        SCF/CRF             Developer Name
----------------------------------------------------------------------------------
1            V210112            7661	     MOHE-CRF-0050.1        Ram kumar S
 -->

<%-- JSP Page specific attributes start --%>
<%@ page    contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script language='javascript' src='../../eBL/js/json2.js'></script>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eBL/js/IntermDraftReport.js"></script>
<html>
<head>
<%
	 String sStyle	=
	 (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<%
    request.setCharacterEncoding("UTF-8");
	String url = "../../eCommon/jsp/commonToolbar.jsp?";
	String params = request.getQueryString() ;
	System.out.println("params "+params);
	String source = url + params;
%>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%= source %>' frameborder=0 scrolling='no' noresize style='height:10vh;width:100vw'></iframe>
		<iframe name='IntermDraftReport' id='IntermDraftReport' id='IntermDraftReport' src='IntermDraftReport.jsp?<%=params%>'  frameborder=0 style='height:27vh;width:100vw'></iframe><iframe name='IntermDraftReportTable' id='IntermDraftReportTable' id='IntermDraftReportTable' src='IntermDraftReportTable.jsp?<%=params%>'  frameborder=0 style='height:53vh;width:100vw'></iframe><iframe name="dummy_frame" id="dummy_frame" src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:2vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:8vh;width:100vw'></iframe>
<body>
</form>	
</body>	
</html>


