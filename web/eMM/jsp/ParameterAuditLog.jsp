<!DOCTYPE html>
<%@ page import="eMM.ParameterBean" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<title><fmt:message key="Common.AuditTrail.label" bundle="${common_labels}"/></title>
	<head> 
		<%
			request.setCharacterEncoding("UTF-8");
			String locale			=	 (String)session.getAttribute("LOCALE");
			String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
			<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
			<script language="javascript" src="../../eCommon/js/common.js"></script>
			<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<body>
<%
	try{
	String bean_id = "ParameterBean" ;
	String bean_name = "eST.ParameterBean";
	ParameterBean bean = (ParameterBean)getBeanObject( bean_id, bean_name,request); 
			boolean searched			=		(request.getParameter("searched") == null) ?false:true;
	
			HashMap sqlMap				=		new HashMap();
			HashMap funcMap				=		new HashMap();
			ArrayList chkFields			=		new ArrayList();
			ArrayList displayFields		=		new ArrayList();
			sqlMap.put("sqlData", "SELECT   RECEIVE_BONUS_YN, RECEIVE_SAMPLE_YN, MODIFIED_BY_ID, TO_CHAR(MODIFIED_DATE,'DD/MM/YYYY HH24:MI') AS MODIFIED_DATE, MODIFIED_FACILITY_ID FROM MM_PARAMETER_LOG ORDER BY SRL_NO DESC");
						
			displayFields.add("RECEIVE_BONUS_YN");
			displayFields.add("RECEIVE_SAMPLE_YN");
			displayFields.add("MODIFIED_BY_ID");
			displayFields.add("MODIFIED_DATE");
			displayFields.add("MODIFIED_FACILITY_ID");


			// Adding function related array list into the HashMap
			funcMap.put("displayFields", displayFields);
			funcMap.put("chkFields", chkFields);

			ArrayList arrAuditLogs=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
			int intAuditLogsSize=0;
			if(arrAuditLogs!=null){
				intAuditLogsSize=arrAuditLogs.size();
			}
%>
<%if((intAuditLogsSize>=3) && (!(((String) arrAuditLogs.get(0)).equals("0"))) && (!(((String) arrAuditLogs.get(1)).equalsIgnoreCase("prevnext")))){%>
<br>
		<table border="0" cellspacing="0" width="100%">
			<tr>
				<td>
				<%
					out.println(arrAuditLogs.get(1));
				%>
				</td>
			</tr>
		</table>
		<table border="1" cellspacing="0" width="100%">
			
			<tr>
				<td class="COLUMNHEADER" width="18%"><b><fmt:message key="Common.modifiedby.label" bundle="${common_labels}"/></b></td>
				<td class="COLUMNHEADER" width="18%"><b><fmt:message key="Common.modifieddatetime.label" bundle="${common_labels}"/></b></td>
				<td class="COLUMNHEADER" width="34%"><b><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></b></td>
				<td class="COLUMNHEADER" width="15%"><b><fmt:message key="eMM.AllowBonusEntry.label" bundle="${mm_labels}"/></b></td>			
				<td class="COLUMNHEADER" width="15%"><b><fmt:message key="eMM.AllowSampleEntry.label" bundle="${mm_labels}"/></b></td>
				
			</tr>
			<%
				ArrayList  arrRow= new ArrayList();
				HashMap  hshModifiedBy= new HashMap();
				HashMap  hshFacilityName= new HashMap();
				for(int i=2;i<intAuditLogsSize;i++){
					arrRow= new ArrayList();
					arrRow=(ArrayList)arrAuditLogs.get(i);

					hshModifiedBy=(HashMap)bean.fetchRecord("SELECT APPL_USER_NAME FROM SM_APPL_USER_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' and APPL_USER_ID='"+bean.checkForNull((String)arrRow.get(2))+"'");

					hshFacilityName=(HashMap)bean.fetchRecord("SELECT FACILITY_NAME FROM SM_FACILITY_PARAM_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' AND FACILITY_ID='"+bean.checkForNull((String)arrRow.get(4))+"'");

				%>
			<tr>
				<td class="QRYEVEN"><%=bean.checkForNull((String)hshModifiedBy.get("APPL_USER_NAME"))%>&nbsp;</td>
				<td class="QRYEVEN"><%=bean.checkForNull((String)arrRow.get(3))%>&nbsp;</td>
				<td class="QRYEVEN"><%=bean.checkForNull((String)hshFacilityName.get("FACILITY_NAME"))%>&nbsp;</td>				
				<td class="QRYEVEN">
				<%

					if(bean.checkForNull((String)arrRow.get(0)).equalsIgnoreCase("Y"))
									out.println("<img src=\'../../eCommon/images/enabled.gif\'></img>");
								else
									out.println("<img src=\'../../eCommon/images/disabled.gif\'></img>");	
				%>				
				</td>
				<td class="QRYEVEN">
				<%

					if(bean.checkForNull((String)arrRow.get(1)).equalsIgnoreCase("Y"))
									out.println("<img src=\'../../eCommon/images/enabled.gif\'></img>");
								else
									out.println("<img src=\'../../eCommon/images/disabled.gif\'></img>");	
				%>
				</td>
			</tr>
			<%
				}
			%>
		</table>
			<%
				out.flush();					
				}else{
			%>
				<script>
					alert(getMessage("NO_RECORD_FOUND","Common"));
					document.location.href="../../eCommon/html/blank.html";
				</script>			
				
			<%}
			out.println(CommonBean.setForm (request ,"../../eMM/jsp/ParameterAuditLog.jsp", searched));
			%>

		<%
		}
		catch(Exception e) {
		//out.print("Exception @ Result JSP :"+e.toString());
		e.printStackTrace(); // COMMON-ICN-0184
	    }
		
		%>
</body>
</html>

