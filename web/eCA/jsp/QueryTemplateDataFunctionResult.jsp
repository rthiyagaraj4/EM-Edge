<!DOCTYPE html>
<%
/*
------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name			Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------
?             	100            		?           	?				?					created 
18/11/2015    	IN057467		 	Ramesh G		      								Query template data should also allow date field to be included for query.	
------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.sql.*,webbeans.eCommon.*,java.util.*,eCA.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
//	String qryRef = request.getParameter("qryRef")==null?"":request.getParameter("qryRef");
	String formAge = request.getParameter("formAge")==null?"":request.getParameter("formAge");
	String toAge = request.getParameter("toAge")==null?"":request.getParameter("toAge");
	String gender = request.getParameter("gender")==null?"":request.getParameter("gender");
	String toDate = request.getParameter("toDate")==null?"":request.getParameter("toDate");
	String fromDate = request.getParameter("fromDate")==null?"":request.getParameter("fromDate");
//	String qryDesc = request.getParameter("qryDesc")==null?"":request.getParameter("qryDesc");
	String fromAgeUnit = request.getParameter("fromAgeUnit")==null?"":request.getParameter("fromAgeUnit");
	String toAgeUnit = request.getParameter("toAgeUnit")==null?"":request.getParameter("toAgeUnit");

	QueryTemplateDataFunctionBean qryDataBean = (QueryTemplateDataFunctionBean)getObjectFromBean("qryDataBean","eCA.QueryTemplateDataFunctionBean",session);

	
	
	List<String> resObj = qryDataBean.getKeyComponentResults(formAge, toAge, fromDate, toDate, gender,fromAgeUnit,toAgeUnit);
	Map<String,String> dateCompMap = (HashMap<String,String>)qryDataBean.getDateCompWithDesc(); 	 //IN057467
	String excelMsg = "callServ";
	if(resObj == null)
	{
		excelMsg = "stopServ";
	}
	Set<String> datecompKey = null; //IN057467
	Integer totalColumns = 8;	//IN057467
%>
<html>
<head>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="javascript" src="../../eCA/js/QueryTemplateDataFunction.js"></script>
 </head>
 <body>
	<form name='QueryTemplateDataFunctionResult' id='QueryTemplateDataFunctionResult' action='../../servlet/eCA.QueryTemplateDataExcelBookServlet' method='post'>
	<table width='100%' cellpadding='0' cellspacing='0' border='0' id='tblCrc' name='tblCrc' id='tblCrc' >
		<tr>
			<th class='columnheader'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
			<th class='columnheader'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
			<th class='columnheader'><fmt:message key="Common.gender.label" bundle="${common_labels}"/></th>
			<th class='columnheader'><fmt:message key="Common.age.label" bundle="${common_labels}"/></th>
			<th class='columnheader'><fmt:message key="Common.DOB.label" bundle="${common_labels}"/></th>
			<th class='columnheader'><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></th>
			<th class='columnheader'><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></th>
			<th class='columnheader'><fmt:message key="eCA.NumberofOccurrences.label" bundle="${ca_labels}"/></th>
			<%
			//IN057467 Start.
			if(dateCompMap!=null){
				if(dateCompMap!=null){
					if(dateCompMap.keySet().size()>0){
						datecompKey = dateCompMap.keySet();
						for (String key : datecompKey)
						{						
							%><th class='columnheader'><%=((String)dateCompMap.get(key))%></th><%
							totalColumns++;
						}
					}
				}
			}
			//IN057467 End.
			%>
		</tr>
		<%
			Set<String> ptCnt = new HashSet<String>();
			if(resObj != null)
			{
				for(String str : resObj)
				{%>

				<tr>
				<%
					String []st = str.split("`~");
					ptCnt.add(st[0]);
					//IN057467 Start.
					//for(int i = 0; i < st.length; i++)
					//{
					%>
						
						<td class='gridData' ><%=st[0]%></td>
						<td class='gridData' ><%=st[1]%></td>
						<td class='gridData' ><%=st[2]%></td>
						<td class='gridData' ><%=st[3]%></td>
						<td class='gridData' ><%=st[4]%></td>
						<td class='gridData' ><%=st[5]%></td>
						<td class='gridData' ><%=st[6]%></td>
						<td class='gridData' ><%=st[7]%></td>
					<%//}
					if(dateCompMap!=null){
						if(dateCompMap!=null){
							for (String key : datecompKey)
							{
								
								if(key.equals(st[9])){
									%><td class='gridData' ><%=st[8]%></td><%
								}else{
									%><td class='gridData' >&nbsp;</td><%
								}
							}
						}
					}
					//IN057467 End.
					%>
				</tr>
				<%
				}
			}
		%>
		<tr>
			<td class='gridData' colspan='<%=totalColumns%>'><fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.patient.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.count.label" bundle="${common_labels}"/>:&nbsp;<%=ptCnt.size()%> </td>
		</tr>
		<%
			ptCnt = null;
		%>
	</table>
	</form>
 </body>
 <SCRIPT LANGUAGE="JavaScript">
 <!--
	parent.QryTempDataResultBtnFrm.location.href="../../eCA/jsp/QueryTemplateDataFunctionCriteriaResultButton.jsp?<%=request.getQueryString()%>&excelMsg=<%=excelMsg%>"
 //-->
 </SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 </html>

