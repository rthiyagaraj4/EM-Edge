<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Date     	  Edit History      	Name     			Description
--------------------------------------------------------------------------------------------------------------
30-OCT-2018      100           	Subha Sundari M          Created
---------------------------------------------------------------------------------------------------------------
-->
<%@page import="webbeans.op.CurrencyFormat"%>
<%@ page
	import="eBL.*,eBL.Common.*,java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"
	contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>

<html>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language="javascript" src=../../eBL/js/PkgDef.js"></script>
<script language='javascript' src='../../eCommon/js/jquery.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%!
	public String checkNull(String str) {
		if (str == null || "null".equals(str.trim())) {
			return "";
		}
		return str;
	}

	public String formatDate(String inputDate) {
		if (inputDate == null || inputDate.trim().equals("")) {
			return "";
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Timestamp inputTimeStamp = null;
			String outputDate = inputDate;
			long longTimeStamp = 0;
			inputTimeStamp = Timestamp.valueOf(inputDate);
			longTimeStamp = inputTimeStamp.getTime();
			outputDate = sdf.format(longTimeStamp);
			return outputDate;
		}
	}
%>
<%
String strJobWithSessId = "", oraJobId = "", oraSessionId = "", sql = "", tabType = "", facilityId = "";
Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
	try {
		facilityId = (String) session.getAttribute("facility_id");
		if (facilityId == null) {
			facilityId = "";
		}
		strJobWithSessId = (String) request.getParameter("jobId");
		tabType = (String) request.getParameter("tabType");
		System.out.println("BLAutoBillGenResultError.jsp -> strJobWithSessId: "+strJobWithSessId);
		if(null != strJobWithSessId && !strJobWithSessId.equals("") && strJobWithSessId.contains("^")) {
			oraJobId = strJobWithSessId.split("\\^")[0].toString();
			oraSessionId = strJobWithSessId.split("\\^")[1].toString();
		}
		con = ConnectionManager.getConnection();
		if("witherror".equals(tabType)) {
			sql = BlRepository.getBlKeyValue("AUTO_BILL_JOB_STS_DTL_WITHERR");
		} else {
			sql = BlRepository.getBlKeyValue("AUTO_BILL_JOB_STS_DTL_WITHOUTERR");
		}
		sql += " ORDER BY 1,2,3";
		System.out.println("BLAutoBillGenResultError.jsp -> sql: "+sql);
		CurrencyFormat cf = new CurrencyFormat();
%>
<body onKeyDown="lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();">
	<div id="BLAutoBillGenJobStErrorDiv"
		STYLE="width: 100%; height: 120; overflow: auto;">
		<table border="" width="100%" cellspacing='0' cellpadding='0'>
		<thead>
			<tr>
				<td class='COLUMNHEADER' nowrap><fmt:message
						key="Common.patientId.label" bundle="${common_labels}" /></td>
				<td class='COLUMNHEADER' nowrap><fmt:message
						key="Common.VisitDate.label" bundle="${common_labels}" /></td>
				<td class='COLUMNHEADER' nowrap><fmt:message
						key="Common.type.label" bundle="${common_labels}" /></td>
				<td class='COLUMNHEADER' nowrap><fmt:message
						key="eBL.EpisodeNo.label" bundle="${bl_labels}" /></td>
				<td class='COLUMNHEADER' nowrap><fmt:message
						key="Common.Visit.label" bundle="${common_labels}" /></td>
				<td class='COLUMNHEADER' nowrap><fmt:message
						key="Common.Location.label" bundle="${common_labels}" /></td>
				<td class='COLUMNHEADER' nowrap><fmt:message
						key="eBL.Description.label" bundle="${bl_labels}" /></td>
				<% if(!"witherror".equals(tabType)) { %>
				<td class='COLUMNHEADER' nowrap><fmt:message
						key="eBL.BILL_DOC_NO.label" bundle="${bl_labels}" /></td>
				<% } %>
				<td class='COLUMNHEADER' nowrap><fmt:message
						key="eBL.PAYER.label" bundle="${bl_labels}" /> <fmt:message
						key="eBL.Amount.label" bundle="${bl_labels}" /></td>
				<%if("witherror".equals(tabType)) { %>
				<td class='COLUMNHEADER' ><fmt:message
						key="eBL.ErrorDesc.label" bundle="${bl_labels}" /></td>
				<%} %>
			</tr>
		</thead>
		<tbody>
			<%
			int noofdecimal = 2;
			pstmt = con.prepareStatement("select nvl(no_of_decimal,2) from  sm_acc_entity_param");
			ResultSet rscurr = pstmt.executeQuery();	
			while(rscurr.next())
			{
				noofdecimal  =  rscurr.getInt(1);		
			}
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, facilityId);
			pstmt.setString(2, oraJobId);
			pstmt.setString(3, oraSessionId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
			%>
			<tr>
				<td class='fields' nowrap style="text-align:center"><%=rs.getString("PATIENT_ID") %></td>
				<td class='fields' nowrap style="text-align:center"><%=rs.getString("VISIT_ADM_DATE_TIME") %></td>
				<td class='fields' nowrap style="text-align:center"><%=rs.getString("EPISODE_TYPE") %></td>
				<td class='fields' nowrap style="text-align:center"><%=rs.getString("EPISODE_ID") %></td>
				<td class='fields' nowrap style="text-align:center"><%=rs.getString("VISIT_ID") %></td>
				<td class='fields' nowrap style="text-align:center"><%=rs.getString("LOCN_CODE") %></td>
				<td class='fields' nowrap style="text-align:center"><%=rs.getString("LOCN_DESC") %></td>
				<%
				if(!"witherror".equals(tabType)) {
				%>
				<td class='fields'><%=checkNull(rs.getString("BILL_NO")) %>&nbsp;</td>
				<%
				}
				%>
				<td class='fields' nowrap style="text-align:right"><%=cf.formatCurrency(rs.getString("PAYER_UNBILLED_AMT").trim(), noofdecimal) %></td>
				<%if("witherror".equals(tabType)) { %>
				<td class='fields' ><%=rs.getString("ERR_MSG") %></td>
				<%} %>
			</tr>
			<%
			}
			%>
			</tbody>
		</table>
	</div>
	<br>
	<!-- <table border=0 width="80%" cellspacing='0' cellpadding='3'
		align='center'>
		<tr>
			<td width="100%" align="left"><input type="button"
				id='exportExcelButton' value="Export"></td>
		</tr>
	</table> -->
</body>
<%
	} catch(Exception e) {
		e.printStackTrace();
		System.err.println("Error in BLAutoBillGenResultError.jsp: "+e);
	}
%>
</html>

