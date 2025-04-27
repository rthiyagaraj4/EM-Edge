<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eCP.*, eCommon.Common.*,com.ehis.eslp.* " %>
<%@ page language="java" import ="java.sql.*, webbeans.eCommon.*,webbeans.eCommon.*,java.net.*,java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>

<jsp:useBean id="ReviseCarePlan" class="webbeans.eCommon.RecordSet" scope="session"/>

<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<HTML>
<HEAD>
<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>		
<SCRIPT language='javascript' src='../../eCommon/js/ValidateControl.js' ></SCRIPT>
		<SCRIPT language='javascript' src='../../eCommon/js/FieldFormatMethods.js' ></SCRIPT>
		<SCRIPT language="javascript" src="../js/ReviseCarePlan.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</HEAD>
<FORM name="formReviseCareplanaddIntvn" id="formReviseCareplanaddIntvn" >
<%
	String termSet=request.getParameter("termSet");
	String termCode=request.getParameter("termCode");
	String goalCode=request.getParameter("goalCode");
	String grpid1=request.getParameter("groupid");
	String temptermSet="";
	String temptermCode="";
	String intvnstatus="";
	String intvnyn="";
	int index=0;
	int gindex=0;

	ArrayList Diagnosis			=	new ArrayList();
	ArrayList Goal				=	null;
	HashMap InterventionOutcome	=	null;
	HashMap IOGroup				=	null;
	ArrayList Intervention		=	null;

	ArrayList sessionList		=	(ArrayList)ReviseCarePlan.getRecordSetHandle();
	if(sessionList.size()>0)
	{
		Diagnosis=(ArrayList)ReviseCarePlan.getObject(0);
	}
%>
	<TABLE border='1'cellpadding='0' cellspacing='0' align='center' width='100%'>
	<TR>
		<TH width="18%"><fmt:message key="Common.code.label" bundle="${common_labels}"/></TH>
		<TH><fmt:message key="Common.description.label" bundle="${common_labels}"/></TH>
		<TH WIDTH='4%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></TH>
	</TR>

	<%
	for(int i=0;i<Diagnosis.size();i=i+11){

		temptermSet=(String)Diagnosis.get(i);
		temptermCode=(String)Diagnosis.get(i+1);

		if(termSet.equals(temptermSet) && termCode.equals(temptermCode)){
			index=Diagnosis.indexOf(termCode);
			Goal=(ArrayList)Diagnosis.get(index+4);
			if(Goal.contains(goalCode)){
				gindex=Goal.indexOf(goalCode);
				InterventionOutcome=(HashMap)Goal.get(gindex+2);
				IOGroup=(HashMap)InterventionOutcome.get(grpid1);
				Intervention=(ArrayList)IOGroup.get("I");
				for(int k=0;k<Intervention.size();k=k+6){
					intvnstatus=(String)Intervention.get(k+3);
					intvnyn=(String)Intervention.get(k+4);
					if(intvnstatus.equals("W")&& intvnyn.equals("Y")){
	%>
		<TR>
			<TD CLASS='LABEL'><%=Intervention.get(k+0)%></TD>
			<TD CLASS='LABEL'><%=Intervention.get(k+1)%></TD>
			<TD><INPUT TYPE="checkbox" checked name="<%=Intervention.get(k+0)%>" id="<%=Intervention.get(k+0)%>" ONCLICK="UpdateIntvn(this,'<%=Intervention.get(k)%>')"></TD>
		</TR>
	<%

					}
				}
				//System.err.println("in lookup  "+Intervention);
			}
		}
	}
%>
</table>
<INPUT TYPE="hidden" name="termSet" id="termSet" value="<%=termSet%>">
	<INPUT TYPE="hidden" name="termCode" id="termCode" value="<%=termCode%>">
	<INPUT TYPE="hidden" name="goalCode" id="goalCode" value="<%=goalCode%>">
	<INPUT TYPE="hidden" name="groupid" id="groupid" value="<%=grpid1%>">
</form>
</html>
	

