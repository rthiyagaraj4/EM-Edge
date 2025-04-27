<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------
10/16/2023   32902      Twinkle Shah    	    Ramesh Goli      MMS-DM-CRF-0210
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
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<title>View - Access History to View Clinical Data for Restricted Patients </title>
<%
	
	java.sql.Connection		con = null;
	java.sql.PreparedStatement pstmt = null;
	java.sql.ResultSet		rs = null;
	
	String	practitionerId		=	(request.getParameter("practitionerId")==null?"":request.getParameter("practitionerId"));
	String	facilityId		=	(request.getParameter("facilityId")==null?"":request.getParameter("facilityId"));
	String	practitionerName			=	(request.getParameter("practitionerName")==null?"":request.getParameter("practitionerName"));	
	String or_bean_id 						= "@CAAccessRightsForViewRestrictPatientBean";
	String or_bean_name 					= "eCA.CAAccessRightsForViewRestrictPatientBean";
	CAAccessRightsForViewRestrictPatientBean bean= (CAAccessRightsForViewRestrictPatientBean)getBeanObject( or_bean_id, or_bean_name, request ) ;
	ArrayList  historyData = bean.getAccessRightsViewRestrictPatHistoryDtl(facilityId,practitionerId);
%>
<SCRIPT>
function colseWindow(){
	//window.close();
	parent.document.getElementById('dialog_tag').close();
}
</SCRIPT>
</HEAD>
<BODY>
	<TABLE border="0" cellpadding="3" cellspacing="0" width="100%" height="100%" align='center'>
		<TR height="5%">
			<TH  align="center" colspan="2"><font size="2"><B><fmt:message key="eCA.AccessHistViewClinicalRestrictedPatients.label" bundle="${ca_labels}"/></B></font></TH>
		</TR>
		<TR height="5%">
			<TH  align="center" colspan="2"><font size="1"><B><fmt:message key="Common.practitionername.label" bundle="${common_labels}"/> : <%=practitionerName%></B></font></TH>
		</TR>
			</TABLE>	
		<!-- <TR height="85%">
			<TD colspan="2"> -->
				<DIV style="width:100%; overflow: auto; height: 80vh;">
				<TABLE border="0" id="test" cellpadding="3" cellspacing="0" width="100%" align='center'>
					<TR><TH align="center" width='16%'><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></TH>
						<TH align="center" width='16%'><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></TH>
						<TH align="center" width='27%'width='33%'><fmt:message key="eCA.RecordCreatedBy.label" bundle="${ca_labels}"/></TH>
						<TH align="center" width='25%' NOWRAP><fmt:message key="eCA.RecordDate.label" bundle="${ca_labels}"/></TH>
						<TH align="center" width='16%'><fmt:message key="eCA.RecordStatus.label" bundle="${ca_labels}"/></TH>		
					</TR>
					<%
					try{
									if(historyData.size()>0){
										for(int i=0;i<historyData.size();i++){
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
							out.println("Exception from ClinicalStudiesPatientListHistDetails.jsp " + e.toString());
					}
					%>
					<TR height="5%">
			
		</TR>
				</TABLE>
				</DIV>
		<!-- 	</TD>
		</TR>
		 -->
	<!-- </TABLE> -->
	<TABLE border="0" cellpadding="3" cellspacing="0" width="100%" height="100%" align='center'>
	<tr>
	<TD align="right" colspan="2">
				<input type="button" value="Close" onClick="javascript:colseWindow();" />
	</TD>
	</tr>
	</TABLE>
	
</BODY>	
</HTML>

