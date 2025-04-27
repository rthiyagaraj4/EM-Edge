<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History     Name      			Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
10/09/2018		IN067564		Ramya Maddena		10/09/2018		Ramesh Goli		ML-MMOH-CRF-1186
---------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,com.ehis.util.*,org.json.simple.*,eCommon.Common.*,eCA.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<HTML>
<HEAD>
 <%
		String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCA/js/CABallardScore.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 </head>
<body>


<%
    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String mode	     = request.getParameter( "mode" ) ;
	Connection con		= null;
	PreparedStatement pstmt 	= null;
	ResultSet rs 			= null;
	
	
%>
<form name='BallardScoreForm1' id='BallardScoreForm1' method ='post' target='messageFrame'>
<%
 String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
String date_from = request.getParameter("date_from")==null?"":request.getParameter("date_from");
String date_to = request.getParameter("date_to")==null?"":request.getParameter("date_to");

Properties p = (Properties)session.getValue("jdbc");
String locale	= (String) p.getProperty("LOCALE");
String facility_id	= (String) session.getValue("facility_id");
String bean_id="@caballardscore"+patient_id+encounter_id;
String bean_name="eCA.CABallardScoreBean";
	eCA.CABallardScoreBean beanObj = (eCA.CABallardScoreBean)getObjectFromBean(bean_id,bean_name,session);
	JSONArray jsonArray = beanObj.getBallardScoreAuditDetails(request,patient_id,locale,facility_id,encounter_id,date_from,date_to);
String view_history_yn  = request.getParameter("view_history_yn")==null?"N":request.getParameter("view_history_yn");		
  String encounterId ="";
 
 %>
 <form name="BallardScoreForm1" id="BallardScoreForm1" method="post" target="messageFrame">
	
	<% if(jsonArray.size() != 0){ %>
	<table  class='grid' width="100%">
	<% if(view_history_yn.equals("Y")){ %>
					<tr>
						<td class="COLUMNHEADER" width="10%" >
						<fmt:message key="Common.SrlNo.label" bundle="${common_labels}"/>
						</td>
						<td class="COLUMNHEADER" width="10%" >
								<fmt:message key="Common.practitionername.label" bundle="${common_labels}"/>
							</td>
							<td class="COLUMNHEADER" width="15%" style=>
								<fmt:message key="Common.recordeddatetime.label" bundle="${common_labels}"/>
							</td>
					<td class="COLUMNHEADER" width="10%" >
								<fmt:message key="Common.encounterid.label" bundle="${common_labels}"/>
							</td>
							<% }else{ %>
							<td class="COLUMNHEADER" width="10%" >
						<fmt:message key="Common.SrlNo.label" bundle="${common_labels}"/>
						</td>
						<td class="COLUMNHEADER" width="10%" >
								<fmt:message key="Common.practitionername.label" bundle="${common_labels}"/>
							</td>
							<td class="COLUMNHEADER" width="15%" >
								<fmt:message key="Common.recordeddatetime.label" bundle="${common_labels}"/>
							</td>
							<% } %>
					</tr>
	
	<%
	String slClassValue = "gridData";

			for(int i = 0,j=1 ; i < jsonArray.size() ; i++,j++ ) {	
				JSONObject jsonObj	= (JSONObject)jsonArray.get(i);
				
				String recordedDate		 = (String) jsonObj.get("recordedDate");
				String practitionerName  = (String) jsonObj.get("practitionerName");
				String enc_id  = (String) jsonObj.get("enc_id");
				
			%>
		
			<tr>
	<% if(view_history_yn.equals("Y")){ %>
				<td  nowrap class='<%=slClassValue%>'><%=j%> &nbsp;</td>
				<td  class='<%=slClassValue%>'><%=practitionerName%></td>
				<td  class='<%=slClassValue%>'>			
					<a href='#' onclick="ShowResult('<%=recordedDate%>','<%=enc_id%>')" id='ShowResult'><%=recordedDate%></a>
                <td style="text-align:left" class='<%=slClassValue%>'><%=enc_id %></td>					
				</td>
				<% }else{ %>
				<td  nowrap class='<%=slClassValue%>'><%=j%> &nbsp;</td>
				<td  class='<%=slClassValue%>'><%=practitionerName%></td>
				<td  class='<%=slClassValue%>'>			
					<a href='#' onclick="ShowResult('<%=recordedDate%>','<%=enc_id%>')" id='ShowResult'><%=recordedDate%></a>				
				</td>
                <% } %>
			</tr>
				
			<%
			}
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(con != null) ConnectionManager.returnConnection(con);
		
			%>
</table><% } %>			

			<input type="hidden" id="patientId" name="patientId" id="patientId" value="<%=patient_id%>"/>
			<input type="hidden"  id="facility_id" name="facility_id" id="facility_id" value="<%=facility_id%>"/>
           <input type="hidden"  id="encounterId" name="encounterId" id="encounterId" value="<%=encounter_id%>"/>
		

</form>			
</body>
</html>

