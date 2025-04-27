<%
/*
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------
19/06/2024	  62372			Twinkle Shah		19/04/2021	ML-MMOH-CRF-2149.1
--------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="java.sql.*,eCA.*,webbeans.eCommon.*,java.io.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>  

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<HTML>
<HEAD>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<title>View - Access History to Manage Copy Previous Note for Practitioners</title>
<%
	
	java.sql.Connection		con = null;
	java.sql.PreparedStatement pstmt = null;
	java.sql.ResultSet		rs = null;
	java.util.Properties p     = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale              = (String) p.getProperty("LOCALE");
	String practitionerId	   =	(request.getParameter("practitionerId")==null?"":request.getParameter("practitionerId"));
	String facilityId		   =	(request.getParameter("facilityId")==null?"":request.getParameter("facilityId"));
	String practitionerName	   =	(request.getParameter("practitionerName")==null?"":request.getParameter("practitionerName"));	
	String or_bean_id 		   = "@CAAccessCtrlCopyPreviousNotePractBean";
	String or_bean_name 	   = "eCA.CAAccessCtrlCopyPreviousNotePractBean";
	CAAccessCtrlCopyPreviousNotePractBean bean= (CAAccessCtrlCopyPreviousNotePractBean)getBeanObject( or_bean_id, or_bean_name, request ) ;
	ArrayList  historyData = bean.getAccessRightsViewRestrictPatHistoryDtl(facilityId,practitionerId);
	String  pract_name_dtl = bean.getPractitinorNameDtls(practitionerId,locale);
%>
<SCRIPT>
function colseWindow(){
	window.close();
}
</SCRIPT>
</HEAD>
<BODY>
	<TABLE border="0" cellpadding="3" cellspacing="0" width="100%" height="100%" align='center'>
		<TR height="5%">
			<TH  align="center" colspan="2"><font size="2"><B>Access History to Manage Copy Previous Note for Practitioners</B></font></TH>
		</TR>
		<TR height="5%">
			<TH  align="center" colspan="2"><font size="1"><B><fmt:message key="Common.practitionername.label" bundle="${common_labels}"/> : <%=pract_name_dtl%></B></font></TH>
		</TR>		
		<TR height="85%">
			<TD colspan="2">
				<DIV style="width:100%; height:100%; overflow: auto;">
				<TABLE border="0" cellpadding="3" cellspacing="0" width="100%" align='center'>
					<TR><TH align="center" width='16%'><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></TD>
						<TH align="center" width='16%'><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></TD>
						<TH align="center" width='27%'width='33%'><fmt:message key="eCA.RecordCreatedBy.label" bundle="${ca_labels}"/></TD>
						<TH align="center" width='25%' NOWRAP><fmt:message key="eCA.RecordDate.label" bundle="${ca_labels}"/></TD>
						<TH align="center" width='16%'><fmt:message key="eCA.RecordStatus.label" bundle="${ca_labels}"/></TD>
					</TR>
					<%
					try{
									if(historyData.size()>0){
										for(int i=0;i<historyData.size();){
											ArrayList histData = (ArrayList)historyData.get(i);
									 %>
									 <TR>
										<TD><%=histData.get(0)%></TD>
										<TD><%=histData.get(1)%></TD>
										<TD NOWRAP><%=histData.get(2)%></TD>
										<TD NOWRAP ><%=histData.get(3)%></TD>
										<TD><%=histData.get(4)%></TD>
									</TR>
									 <%
									 i++;
								}
							}
							if(historyData.size()==0){
								%>
								<TR><TD colspan="5">&nbsp;</TD></TR>
								<TR><TD colspan="5">&nbsp;</TD></TR>
								<TR><TD colspan="5" align="center"><fmt:message key="eCA.AccessRightsHistoryNotavailable.label" bundle="${ca_labels}"/></TD></TR>
								<TR><TD colspan="5">&nbsp;</TD></TR>
								<TR><TD colspan="5">&nbsp;</TD></TR>
								<%
							}
						}catch(Exception e){
							e.printStackTrace();
					}
					%>	
				</TABLE>
				</DIV>
			</TD>
		</TR>
		<TR height="5%">
			<TD align="right" colspan="2">
				<input type="button" value="Close" onClick="javascript:colseWindow();" />
			</TD>
		</TR>
	</TABLE>
</BODY>	
</HTML>

