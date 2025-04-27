<!DOCTYPE html>
<%@ page import="eST.ParameterForEntityBean" contentType="text/html;charset=UTF-8"%>
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
	String bean_id = "parameterForEntityBean" ;
	String bean_name = "eST.ParameterForEntityBean";
	ParameterForEntityBean bean = (ParameterForEntityBean)getBeanObject( bean_id, bean_name,request); 
			boolean searched			=		(request.getParameter("searched") == null) ?false:true;
	
			HashMap sqlMap				=		new HashMap();
			HashMap funcMap				=		new HashMap();
			ArrayList chkFields			=		new ArrayList();
			ArrayList displayFields		=		new ArrayList();
			sqlMap.put("sqlData", "SELECT EXPIRY_WARNING_DAYS, TRN_ACROSS_FACILITY_YN, MULTI_STORE_ISSUE_YN, MODIFIED_BY_ID, TO_CHAR(MODIFIED_DATE,'DD/MM/YYYY HH24:MI') AS MODIFIED_DATE, MODIFIED_FACILITY_ID,BL_INTERFACE_YN, GL_INTERFACE_YN, SALE_PRICE_APPL_YN, BATCH_SALE_PRICE_YN,  LESSER_SALE_PRICE_YN, PO_DETAILS_APPLICABLE_YN, INTERFACE_TO_EXTERNAL_PO_YN, PO_REQ_BY FROM ST_ACC_ENTITY_PARAM_LOG ORDER BY SRL_NO DESC");
						
			displayFields.add("BL_INTERFACE_YN");						//0
			displayFields.add("GL_INTERFACE_YN");						//1
			displayFields.add("SALE_PRICE_APPL_YN");					//2
			displayFields.add("BATCH_SALE_PRICE_YN");					//3
			displayFields.add("LESSER_SALE_PRICE_YN");					//4
			displayFields.add("PO_DETAILS_APPLICABLE_YN");				//5
			displayFields.add("INTERFACE_TO_EXTERNAL_PO_YN");			//6
			displayFields.add("PO_REQ_BY");								//7
			displayFields.add("EXPIRY_WARNING_DAYS");					//8
			displayFields.add("TRN_ACROSS_FACILITY_YN");				//9
			displayFields.add("MULTI_STORE_ISSUE_YN");					//10
			displayFields.add("MODIFIED_BY_ID");						//11
			displayFields.add("MODIFIED_FACILITY_ID");					//12
			displayFields.add("MODIFIED_DATE");							//13
		

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
		<table border="0" cellspacing="0" width="98%">
			<tr>
				<td>
				<%
					out.println(arrAuditLogs.get(1));
				%>
				</td>
			</tr>
		</table>
		<div id='table_container_left' style='overflow:auto;width:330px;height:260px;position:relative;float:left;'>
					<table   border="1" cellpadding="0" cellspacing="0" align="left"  style='border-collapse:collapse; position:absolute;'>
	
		<tr>
				<th class="COLUMNHEADER" nowrap ><b><fmt:message key="Common.modifiedby.label" bundle="${common_labels}"/></b></th>
				<th class="COLUMNHEADER" nowrap ><b><fmt:message key="Common.modifieddatetime.label" bundle="${common_labels}"/></b></th>
				<th class="COLUMNHEADER" nowrap ><b><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></b></th>
				</tr>
					<%
			
				ArrayList  arrRow= new ArrayList();
				HashMap  hshModifiedBy= new HashMap();
				HashMap  hshFacilityName= new HashMap();
				String	classvalue="";
				for(int i=2;i<intAuditLogsSize;i++){
					arrRow= new ArrayList();
					arrRow=(ArrayList)arrAuditLogs.get(i);
					if ( i % 2 == 0 )
					classvalue = "QRYEVEN" ;
					
					else
					classvalue = "QRYODD" ;

					hshModifiedBy=(HashMap)bean.fetchRecord("SELECT APPL_USER_NAME FROM SM_APPL_USER_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' and APPL_USER_ID='"+bean.checkForNull((String)arrRow.get(11))+"'");

					hshFacilityName=(HashMap)bean.fetchRecord("SELECT FACILITY_NAME FROM SM_FACILITY_PARAM_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' AND FACILITY_ID='"+bean.checkForNull((String)arrRow.get(12))+"'");

				%>
				<tr>
				<td  nowrap class="<%=classvalue%>" ><%=bean.checkForNull((String)hshModifiedBy.get("APPL_USER_NAME"))%>&nbsp;</td>
				<td  nowrap class="<%=classvalue%>" ><%=com.ehis.util.DateUtils.convertDate((String)arrRow.get(13),"DMYHM","en",locale)%>&nbsp;</td>
				<td  nowrap class="<%=classvalue%>" ><%=bean.checkForNull((String)hshFacilityName.get("FACILITY_NAME"))%>&nbsp;</td>
			
				</tr>
				<%}%>
			</table>
				</div>
					<div id='table_container_right' style='overflow:auto;width:500px;height:260px;position:relative;float:left;'>
					<table   border="1" cellpadding="0" cellspacing="0" align="left" style='border-collapse:collapse; position:absolute;'>
		<tr>
				<th class="COLUMNHEADER" nowrap ><b><fmt:message key="Common.Billing.label" bundle="${common_labels}"/></b></th>
				<th class="COLUMNHEADER" nowrap ><b><fmt:message key="Common.GeneralLedger.label" bundle="${common_labels}"/></b></th>
				<th class="COLUMNHEADER" nowrap ><b><fmt:message key="eST.SalePriceApplicable.label" bundle="${st_labels}"/></b></th>
				<th class="COLUMNHEADER" nowrap ><b><fmt:message key="eST.FolioAtBatchPrice.label" bundle="${st_labels}"/></b></th>
				<th class="COLUMNHEADER" nowrap ><b><fmt:message key="eST.MRPGreaterThanUnitPrice.label" bundle="${st_labels}"/></b></th>
				<th class="COLUMNHEADER" nowrap ><b>PO Applicable</b></th>
				<th class="COLUMNHEADER" nowrap ><b><fmt:message key="eST.InterfacetoexternalPO.label" bundle="${st_labels}"/></b></th>
				<th class="COLUMNHEADER" nowrap ><b><fmt:message key="eST.GeneratePORequestBy.label" bundle="${st_labels}"/></b></th>
				<th class="COLUMNHEADER" nowrap ><b><fmt:message key="eST.ExpiryWarningDays.label" bundle="${st_labels}"/></b></th>
				<th class="COLUMNHEADER" nowrap>
					<b><fmt:message key="eST.Transactionacrossfacility.label" bundle="${st_labels}"/></b>
				</th>
				<th class="COLUMNHEADER" nowrap ><b><fmt:message key="eST.AllowMultiStoreIssue.label" bundle="${st_labels}"/></b></th>
				
			</tr>
			<%
			
				  arrRow= new ArrayList();
				  hshModifiedBy= new HashMap();
				  hshFacilityName= new HashMap();
				 
				
				for(int i=2;i<intAuditLogsSize;i++){
					arrRow= new ArrayList();
					arrRow=(ArrayList)arrAuditLogs.get(i);
					if ( i % 2 == 0 )
					classvalue = "QRYEVEN" ;
					
					else
					classvalue = "QRYODD" ;

				
				%>
			<tr>
				<td class="<%=classvalue%>" >	
				<%

					if(bean.checkForNull((String)arrRow.get(0)).equalsIgnoreCase("Y"))
									out.println("<img src=\'../../eCommon/images/enabled.gif\' height='13px'></img>");
								else
									out.println("<img src=\'../../eCommon/images/disabled.gif\' height='13px'></img>");	
				%></td>
				<td class="<%=classvalue%>" >
					<%
					if(bean.checkForNull((String)arrRow.get(1)).equalsIgnoreCase("Y"))
									out.println("<img src=\'../../eCommon/images/enabled.gif\' height='13px'></img>");
								else
									out.println("<img src=\'../../eCommon/images/disabled.gif\' height='13px'></img>");	
				%></td>
				<td class="<%=classvalue%>" >
					<%
					if(bean.checkForNull((String)arrRow.get(2)).equalsIgnoreCase("Y"))
									out.println("<img src=\'../../eCommon/images/enabled.gif\' height='13px'></img>");
								else
									out.println("<img src=\'../../eCommon/images/disabled.gif\' height='13px'></img>");	
				%></td>
				<td class="<%=classvalue%>" >
					<%
					if(bean.checkForNull((String)arrRow.get(3)).equalsIgnoreCase("Y"))
									out.println("<img src=\'../../eCommon/images/enabled.gif\' height='13px'></img>");
								else
									out.println("<img src=\'../../eCommon/images/disabled.gif\' height='13px'></img>");	
				%></td>
				<td class="<%=classvalue%>" >
					<%
					if(bean.checkForNull((String)arrRow.get(4)).equalsIgnoreCase("Y"))
									out.println("<img src=\'../../eCommon/images/enabled.gif\' height='13px'></img>");
								else
									out.println("<img src=\'../../eCommon/images/disabled.gif\' height='13px'></img>");	
				%></td>
				<td class="<%=classvalue%>" >
					<%
					if(bean.checkForNull((String)arrRow.get(5)).equalsIgnoreCase("Y"))
									out.println("<img src=\'../../eCommon/images/enabled.gif\' height='13px'></img>");
								else
									out.println("<img src=\'../../eCommon/images/disabled.gif\' height='13px'></img>");	
				%></td>
				<td class="<%=classvalue%>" >
					<%
					if(bean.checkForNull((String)arrRow.get(6)).equalsIgnoreCase("Y"))
									out.println("<img src=\'../../eCommon/images/enabled.gif\' height='13px'></img>");
								else
									out.println("<img src=\'../../eCommon/images/disabled.gif\' height='13px'></img>");	
				%></td>
				<td  nowrap class="<%=classvalue%>" ><%
				if(bean.checkForNull((String)arrRow.get(7)).equals("MG")){%>
				Meterial Group
				<%}else if(bean.checkForNull((String)arrRow.get(7)).equals("IC")){%>
				<fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/>
				<%}else{%>
				<fmt:message key="Common.none.label" bundle="${common_labels}"/>
				<%}%>&nbsp;</td>
				<td  nowrap class="<%=classvalue%>" ><%=bean.checkForNull((String)arrRow.get(8))%>&nbsp;</td>
				<td class="<%=classvalue%>" >
					<%
					if(bean.checkForNull((String)arrRow.get(9)).equalsIgnoreCase("Y"))
									out.println("<img src=\'../../eCommon/images/enabled.gif\' height='13px'></img>");
								else
									out.println("<img src=\'../../eCommon/images/disabled.gif\' height='13px'></img>");	
				%></td>
				<td class="<%=classvalue%>" >
					<%
					if(bean.checkForNull((String)arrRow.get(10)).equalsIgnoreCase("Y"))
									out.println("<img src=\'../../eCommon/images/enabled.gif\' height='13px'></img>");
								else
									out.println("<img src=\'../../eCommon/images/disabled.gif\' height='13px'></img>");	
				%></td>
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
			out.println(CommonBean.setForm (request ,"../../eST/jsp/ParameterForEntityAuditLog.jsp", searched));
			%>

		<%
		}
		catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());	
	    }
		
		%>
</body>
</html>

