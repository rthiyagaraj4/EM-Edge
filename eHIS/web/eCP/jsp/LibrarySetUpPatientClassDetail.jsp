<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@ page language="java" import ="java.sql.*, webbeans.eCommon.*, java.util.*, com.ehis.eslp.* ,java.net.*" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="LibrarySetup" class="webbeans.eCommon.RecordSet" scope="session"/> 
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- jsp:useBean id="mh" scope="session" class="CommonMultipleHandler" --%>
<%-- To call the Common MultipleHandler where the id will be as mh--%>
<%@ include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%-- Mandatory declarations end --%>

<HTML>
  <HEAD>
<%
//This file is saved on 18/10/2005.
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>	
	<SCRIPT language="JavaScript" src="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT language="javascript" src="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT language="JavaScript" src="../../eCP/js/LibrarySetUp.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

  </HEAD>
  <%
		  Connection connection 	      = null;
		  Statement stmt	      = null;
		  ResultSet rs				  = null;
		  String code="";
		  int  patClassNo=1;
		  String classValue="";
		   String patientClassQuery="SELECT PATIENT_CLASS, SHORT_DESC FROM AM_PATIENT_CLASS_lang_vw where language_id='"+locale+"' ORDER BY 2";
		    try
			{
				connection = ConnectionManager.getConnection(request);
				stmt = connection.createStatement();
				
	 %>
  <BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<FORM name="LibraryPatientClassForm" id="LibraryPatientClassForm" >

		<!-- Table to display Patient Class -->
<TABLE cellpadding=0 cellspacing=0 width="90%" align="center" border="1" id="PatientClass" >
	<TR  colspan="2"><TD></TD></TR>
	<TH><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></TH>
	<TH><fmt:message key="Common.Applicability.label" bundle="${common_labels}"/></TH>
	<%
			
			rs=stmt.executeQuery(patientClassQuery);
			while(rs!=null && rs.next()){
			
				code=(String)rs.getString(1);
				if( patClassNo%2 == 0)  classValue="QRYODD";
				else
				classValue="QRYEVEN";
	%>
		<TR>
			<TD class="<%=classValue%>"><%=(String)rs.getString(2)%><INPUT type="hidden" name="patClassCode_<%=patClassNo%>" id="patClassCode_<%=patClassNo%>"  value="<%=code%>"></TD>
			<TD align="center" class="<%=classValue%>">
				<INPUT type="checkbox" name="patientchk_<%=patClassNo%>" id="patientchk_<%=patClassNo%>"  value="<%=code%>" onclick="updateObj(this)">
			</TD>
		</TR>
	<%
		patClassNo++;
		}
		rs=null;
	%>
</TABLE>
<input type='hidden' name='patClassNo' id='patClassNo' value='<%=patClassNo%>'>
</FORM>
		<Script>
			defaultValues('LibraryPatientClassForm')
		</Script>
</BODY>
<%
	  }catch(Exception e){
		 // out.println("Error is--->"+e);//common-icn-0181
		 e.printStackTrace();//COMMON-ICN-0181
	  }
	finally
	{
			if(rs != null){ rs.close(); }
			if(stmt != null){ stmt.close(); }
			
			if(connection != null)
				ConnectionManager.returnConnection(connection,request);
	}
%> 
</HTML>

