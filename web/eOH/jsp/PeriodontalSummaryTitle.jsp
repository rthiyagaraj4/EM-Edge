<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.util.*,webbeans.eCommon.ConnectionManager" contentType=" text/html;charset=UTF-8" %>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 //String locale = (String)session.getAttribute("LOCALE"); 
 request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>
<%
	String gingival_recording_by=checkForNull(request.getParameter("gingival_recording_by"));
	String title="";
	if(gingival_recording_by.equals("Q")){

		title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.GingivalStatusSummaryOfQuad.Label","oh_labels"); 	
		//title = Gingival Status Summary Of Quadrant; 	
	}
	else{
		title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.GingivalStatusSummaryOfSextant.Label","oh_labels"); 
		//title = Gingival Status Summary Of Sextant; 	
	}
%>

<html>
	<head>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script> 
		<script language="javascript" src="../../eOH/js/PeriodontalSummary.js"></script> 
		<script language="javascript" src="../../eOH/js/GingivalStatus.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>		
		<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
			<form name="PeridontalSummary" id="PeridontalSummary" method="post" target="messageFrame">
				<!-- <table width="100%" cellpadding =4 cellspacing='1' border='1' align='center' valign='center'> -->
				<table width="100%" cellpadding ='0' cellspacing='0' border='1' align='center' valign='center'>
					<tr id="summary_head1">
							<td class="CAGROUPHEADING" width="30%" ><%=title%></td>
							<!-- <fmt:message key="eOH.GingivalStatusSummary.Label" bundle="${oh_labels}"/> -->
							<!--  <td><input type="button" class="button" name="reset" id="reset" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' onclick="GS_Tab_Reset_button1()" >
						
							</td>  -->
					</tr>
				</table>				
			</form>
		</body>
</html>

