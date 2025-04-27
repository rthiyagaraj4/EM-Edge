<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Date     	  Edit History      	Name     			Description
--------------------------------------------------------------------------------------------------------------
30-OCT-2018      100           	Subha Sundari M          Created
---------------------------------------------------------------------------------------------------------------
-->

<%@ page
	import="java.sql.*,java.util.*,webbeans.eCommon.*,eBL.Common.*,eCommon.Common.*"
	contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session.getAttribute("PREFERRED_STYLE")	: "IeStyle.css";
%>

<html>
<head>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/Tabs.css'></link>
	<script language='javascript' src='../../eCommon/js/CommonCalendar.js'></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
	<script language="JavaScript" src="../../eBL/js/BLAutoBillGenJobStatus.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%
	response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1   
	response.setHeader("Pragma", "no-cache"); //HTTP 1.0   
	response.setDateHeader("Expires", 0); //prevents caching at the proxy server
%>
<%
	request.setCharacterEncoding("UTF-8");
	HttpSession httpSession = request.getSession(false);
	Connection con = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;
	String facilityId = "";
	String loginUser = "";
	String visitFrom = "";
	String visitTo = "";
	String episodeType = "";
	String custGroupCode = "";
	String custCode = "";
	String jobId = "";
	String sql = "";
	String oraJobId = "", jobStatus = "", jobSubUser = "", jobSubDate = "", oraSessionId = "";
	try {
		con = ConnectionManager.getConnection(request);
		facilityId = checkForNull(request.getParameter("facilityId"));
		loginUser = checkForNull(request.getParameter("loginUser"));
		visitFrom = checkForNull(request.getParameter("visitFrom"));
		visitTo = checkForNull(request.getParameter("visitTo"));
		episodeType = checkForNull(request.getParameter("episode_type"));
		custGroupCode = checkForNull(request.getParameter("cust_group_code"));
		if(custGroupCode.equals("**")) {
			custGroupCode = "";
		}
		custCode = checkForNull(request.getParameter("cust_code"));
		if(custCode.equals("**")) {
			custCode = "";
		}
		jobId = checkForNull(request.getParameter("job_id"));
%>
<body onKeyDown="lockKey();" onMouseDown="CodeArrest();"
	onSelect="codeArrestThruSelect();">
	<form id="joblist" name="joblist" id="joblist">
		<div id='BLAutoBillJobListDiv'>
			<%
					sql = "SELECT A.ORAJOBID, DECODE(NVL(A.STATUS,'I'),'C','Completed','F','Failed','Inprogress') STATUS, A.USER_ID, " 
							+ " TO_CHAR(A.SUBMISSION_DATE, 'dd/MM/yyyy HH24:MI:SS') SUBMISSION_DATE,  A.ORASESSIONID "
							+ " FROM BL_BACKGROUND_PROCESS A "
							+ " WHERE A.ORAJOBID <> 'XXXXX' AND A.OPERATING_FACILITY_ID = '"+facilityId+"'"
							+ " AND TRUNC(A.SUBMISSION_DATE) BETWEEN  TRUNC(TO_DATE('"+visitFrom+"', 'dd/MM/yyyy')) AND TRUNC(TO_DATE ('"+visitTo+"', 'dd/MM/yyyy')) " 
							+ " AND A.ORAJOBID = NVL('"+jobId+"', A.ORAJOBID) AND PATIENT_ID IS NULL ORDER BY A.ORAJOBID";
					pstmt = con.prepareStatement(sql);
					rs = pstmt.executeQuery();
					System.out.println("sql: " + sql);
			%>
			<br>
			<TABLE width="100%" CELLSPACING=0 cellpadding=3 align='center'>
				<tr>
					<td class="columnheader">
						<center><fmt:message key="eBL.JobList.label" bundle="${bl_labels}" /></center>
					</td>
				</tr>
			</TABLE>
			<br>
			<table align='center' cellpadding=3 cellspacing=0 border=0
				width='100%' id="panel_categories_table_header"
				name="panel_categories_table_header" id="panel_categories_table_header" scrolling='auto'>
				<tr>
					<td class='COLUMNHEADER' align="left" width="4%"><fmt:message
							key="eBL.IRBSelect.label" bundle="${bl_labels}" /></td>
					<td class='COLUMNHEADER' align="left" width="7%"><fmt:message
							key="Common.SerialNo.label" bundle="${common_labels}" /></td>
					<td class='COLUMNHEADER' align="left" width="7%"><fmt:message
							key="eBL.JobId.label" bundle="${bl_labels}" /></td>
					<td class='COLUMNHEADER' align="left" width="7%"><fmt:message
							key="eBL.JobStatus.label" bundle="${bl_labels}" /></td>
					<td class='COLUMNHEADER' align="left" width="7%"><fmt:message
							key="eBL.JobSubmittedUser.label" bundle="${bl_labels}" /></td>
					<td class='COLUMNHEADER' align="left" width="8%"><fmt:message
							key="eBL.JobSubmittedDateTime.label" bundle="${bl_labels}" /></td>
				</tr>

			</table>
		</div>

		<div id="BLJobListDiv" name="BLJobListDiv"
			style="width: 100%; height: 80px; overflow: auto;">
			<table align='center' cellpadding=3 cellspacing=0 width='100%'
				id="panel_categories_table" name="panel_categories_table" id="panel_categories_table" border="1">
				<%
					int i = 0;
					if (rs != null) {
						while (rs.next()) {
							oraJobId = checkForNull(rs.getString(1));
							jobStatus = checkForNull(rs.getString(2));
							jobSubUser = checkForNull(rs.getString(3));
							jobSubDate = checkForNull(rs.getString(4));
							oraSessionId = checkForNull(rs.getString(5));
				%>
				<tr>
					<td class='fields' width="4%">
					<% if(i == 0) { %>
						<input class='radio' type='radio' name='radiobtn' id='radiobtn' id='radio_<%=i%>' value = '<%=oraJobId+"^"+oraSessionId%>' checked>
					<% } else { %>
						<input class='radio' type='radio' name='radiobtn' id='radiobtn' id='radio_<%=i%>' value = '<%=oraJobId+"^"+oraSessionId%>' >
					<% } %>
					</td>
					<td class='fields' width="7%"><%=i+1%></td>
					<td class='fields' width="7%"><%=oraJobId%></td>
					<td class='fields' width="7%"><%=jobStatus%></td>
					<td class='fields' width="7%"><%=jobSubUser%></td>
					<td class='fields' width="8%"><%=jobSubDate%></td>
				</tr>
				<%
						i++;
						}
					}
					if(i == 0){
						out.println("<script>$('#BLAutoBillGenJobStatusResultDiv').load('../../eCommon/html/blank.html');</script>");
						out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
					}
				%>
			</table>
		</div>

		<%
			if (i > 0) {
				out.println("<script>resultOnLoad();</script>");
		%>
		<br>
		<table cellpadding=3 cellspacing=0 border=0 width='100%'
			align="center">
			<tr width='100%'>
				<td width="100%" class="white">
					<ul id='tablist' class='tablist'>
						<li class="tablistitem">
							<div id='tabADiv'>
								<a onclick="clickValue(0);" class="tabClicked"
									id="ProcessedWithoutError"> <span class="tabSpanclicked"
									id="ProcessedWithoutErrorspan"> Processed Without Error
								</span></a>
							</div>
						</li>
						<li class="tablistitem">
							<div id='tabBDiv'>
								<a onclick="clickValue(1);" class="tabA" id="ProcessedWithError">
									<span class="tabAspan" id="ProcessedWithErrorspan">
										Processed With Error </span>
								</a>
							</div>
						</li>
						<li>
							<div>
								<img id="resizeBtn" alt="" defValue="expand"
									src="../../eOT/images/ShowLess.gif"
									style="visibility: visible;"></a>
							</div>
						</li>
					</ul>
				</td>
			</tr>
			<tr>
				<td><div id='ProcessedDataDiv'></div></td>
			</tr>
		</table>
		<%
			}
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println("Exception in BLAutoBillGenJobStatusResult.jsp--->"+ e);
			} finally {
				if (con != null) {
					ConnectionManager.returnConnection(con, request);
				}
			}
		%>
		<script>
			$(document).ready(function() {
				$("#resizeBtn").click(function() {
					var defValue = $(this).attr('defValue');
					if (defValue == 'expand') {
						$('#tableHeaderDiv').hide();
						$('#BLJobListDiv').hide();
						$(parent.BLAutoBillGenJobStatusReport.document).find('#BLAutoBillGenJobStatusReportDiv').hide();
						$(this).attr('src', '../../eOT/images/ShowMore.gif');
						$(this).attr('defValue', 'shrink');
					} else if (defValue == 'shrink') {
						$(this).attr('defValue', 'expand');
						$('#tableHeaderDiv').show();
						$('#BLJobListDiv').show();
						$(parent.BLAutoBillGenJobStatusReport.document).find('#BLAutoBillGenJobStatusReportDiv').show();
						$(this).attr('src','../../eOT/images/ShowLess.gif');
					}
				});
			
				$(".radio").click(function() {
					var strJobId = $(this).val();
					document.forms[0].selectedJobId.value = strJobId;
					parent.BLAutoBillGenJobStatusBtn.document.forms[0].export_button.disabled = false;
					$("#ProcessedDataDiv").load("../../eBL/jsp/BLAutoBillGenResultError.jsp", {
										jobId : strJobId,
										tabType : "withouterror"
									});
					$("#tabADiv").html("<a class='tabClicked' id='ProcessedWithoutError'><span class='tabSpanclicked' id='ProcessedWithoutErrorspan'>Processed Without Error</span></a>");
					$("#tabBDiv").html("<a class='tabA' id='ProcessedWithError' ><span class='tabAspan' id='ProcessedWithErrorspan'>Processed With Error</span></a>");
		  		});
				
				$("#tabADiv").click(function(){
					var radios = jQuery("input[type='radio']");
					var strJobId =  radios.filter(":checked");
					$("#ProcessedDataDiv").load("../../eBL/jsp/BLAutoBillGenResultError.jsp",{jobId:strJobId.val(),tabType:"withouterror"});
					$("#tabADiv").html("<a class='tabClicked' id='ProcessedWithoutError'><span class='tabSpanclicked' id='ProcessedWithoutErrorspan'>Processed Without Error</span></a>");
					$("#tabBDiv").html("<a class='tabA' id='ProcessedWithError' ><span class='tabAspan' id='ProcessedWithErrorspan'>Processed With Error</span></a>"); 
				});
				 
				$("#tabBDiv").click(function(){
					
					var radios = jQuery("input[type='radio']");
					var strJobId =  radios.filter(":checked");
					
					$("#ProcessedDataDiv").load("../../eBL/jsp/BLAutoBillGenResultError.jsp",{jobId:strJobId.val(),tabType:"witherror"});
					$("#tabADiv").html("<a class='tabA' id='ProcessedWithoutError'><span class='tabAspan' id='ProcessedWithoutErrorspan'>Processed Without Error</span></a>");
					$("#tabBDiv").html("<a class='tabClicked' id='ProcessedWithError' ><span class='tabSpanclicked' id='ProcessedWithErrorspan'>Processed With Error</span></a>"); 
				});
			});
		</script>
		<input type='hidden' name='selectedJobId' id='selectedJobId' id='selectedJobId' />
</body>
<%!private String checkForNull(String inputString) {
		return (inputString == null) ? "" : inputString;
	}%>
</html>

