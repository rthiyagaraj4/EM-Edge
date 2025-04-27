<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,org.json.simple.*" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
%>
<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script language='javascript' src='../../eFM/js/FMEncFileVolumeAudit.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<title>
			<fmt:message key="Common.AuditTrail.label" bundle="${common_labels}"/>
		</title>
	</head>

	<%
		Connection con			=	null;
		try	{
			con						=  ConnectionManager.getConnection(request);
			String reqPatientId		= checkForNull(request.getParameter("patient_id"));
			String reqFileNo		= checkForNull(request.getParameter("file_no"));
			String reqFileType		= checkForNull(request.getParameter("file_type"));
			String file_type_appl_yn		= checkForNull(request.getParameter("file_type_appl_yn"));
			String showPline		= checkForNull(request.getParameter("showPline"));
			String locale			= (String) session.getValue( "LOCALE" ) ;

			int currentPageNo 	= 1;
			int recordsPerPage 	= 14;

			if(request.getParameter("currentPageNo") != null)
			currentPageNo = Integer.parseInt(request.getParameter("currentPageNo"));
			JSONObject jsonObj  =  eFM.FMLinkEncFileVolumeBean.getEncFileVolumeAuditDtls(con,reqPatientId,reqFileNo,reqFileType,locale,currentPageNo,recordsPerPage);

			
			int curPageNo		= 0;
			curPageNo		= (Integer) jsonObj.get("currentPageNo");
				
			int noOfRecords		= 0;
			noOfRecords		= (Integer) jsonObj.get("noOfRecords");
		

			int noOfPages		= 0;
			noOfPages		= (Integer) jsonObj.get("noOfPages");

			int prevPageNo	= curPageNo - 1;		
			int nextPageNo	= curPageNo + 1;
			JSONArray fileVolumeAuditDtlsArr 			= (JSONArray)jsonObj.get("fileVolumeAuditDtls");
			int fileVolumeAuditDtlCount					= fileVolumeAuditDtlsArr.size();
		%>
		<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
			<form name="resultForm" id="resultForm" method="post" >
				<%
				if(noOfRecords > 0){
			%>
				<table align='right'>
					<tr>
					<% if ( curPageNo > 1 ){ %>
						<td align ='right' id='prev'><A HREF="../../eFM/jsp/FMEncFileVolumeAuditResult.jsp?patient_id=<%=reqPatientId%>&file_no=<%=reqFileNo%>&file_type=<%=reqFileType%>&currentPageNo=<%=prevPageNo%>&file_type_appl_yn=<%=file_type_appl_yn%>&showPline=<%=showPline%>" text-decoration='none'" ><fmt:message key="Common.previous.label" bundle="${common_labels}" /></A></td>
					<%}
					if ( curPageNo >=1 && curPageNo != noOfPages ){%>
						<td align ='right' id='next'><A HREF="../../eFM/jsp/FMEncFileVolumeAuditResult.jsp?patient_id=<%=reqPatientId%>&file_no=<%=reqFileNo%>&file_type=<%=reqFileType%>&currentPageNo=<%=nextPageNo%>&file_type_appl_yn=<%=file_type_appl_yn%>&showPline=<%=showPline%>" text-decoration='none' "><fmt:message key="Common.next.label" bundle="${common_labels}"/></A></td>
					<%}%>
					</tr>
				</table>
				<br>
				<table cellspacing='0' cellpadding='0' align='center' width='100%' border='1' >
					<tr>
						<th width='11%' class="columnheadercenter" align='center' nowrap>
							<fmt:message key="Common.encountertype.label" bundle="${common_labels}"/>&nbsp;
						</th>
						
						<th width='11%' class="columnheadercenter" align='center' nowrap>
							<fmt:message key="Common.encounterid.label" bundle="${common_labels}"/>&nbsp;
						</th>
					
						<th width='11%' class="columnheadercenter" align='center' nowrap>
							<fmt:message key="Common.encounterdatetime.label" bundle="${common_labels}"/>&nbsp;
						</th>

						<th width='11%' class="columnheadercenter" align='center' nowrap>
							<fmt:message key="Common.Location.label" bundle="${common_labels}"/>&nbsp;
						</th>
						<th width='5%' class="columnheadercenter" align='center' nowrap>
							<fmt:message key="Common.action.label" bundle="${common_labels}"/>&nbsp;
						</th>

						<th width='10%' class="columnheadercenter" align='center' nowrap>
							<%if("Y".equals(file_type_appl_yn)){%>
								<fmt:message key="Common.filetype.label" bundle="${common_labels}"/>&nbsp;
							<%}else{%>
								<fmt:message key="Common.fileno.label" bundle="${common_labels}"/>&nbsp;
							<%}%>
						</th>
						<th width='8%' class="columnheadercenter" align='center' nowrap>
							<fmt:message key="eFM.FileVolume.label" bundle="${fm_labels}"/>&nbsp;
						</th>
				
						<th width='11%' class="columnheadercenter" align='center' nowrap>
							<fmt:message key="Common.DoneBy.label" bundle="${common_labels}"/>&nbsp;
						</th>
												
						<th width='11%' class="columnheadercenter" align='center' nowrap>
							<fmt:message key="Common.ActionDateTime.label" bundle="${common_labels}"/>
						</th>
					</tr>
					<%
						for(int i = 0 ; i < fileVolumeAuditDtlCount ; i++) {
							JSONObject fileVolumeAuditDtls	= (JSONObject)fileVolumeAuditDtlsArr.get(i);
							String encounterType			= (String) fileVolumeAuditDtls.get("encounterType");
							String encounterID				= (String) fileVolumeAuditDtls.get("encounterID");
							String encounterDateTime		= (String) fileVolumeAuditDtls.get("encounterDateTime");
							String location					= (String) fileVolumeAuditDtls.get("location");
							String fileNO					= (String) fileVolumeAuditDtls.get("fileNO");
							String fileTypeCode				= (String) fileVolumeAuditDtls.get("fileTypCode");
							String fileTypeDesc				= (String) fileVolumeAuditDtls.get("fileTypeDesc");
							String fileVolumeNo				= (String) fileVolumeAuditDtls.get("fileVolumeNo");
							String activity					= (String) fileVolumeAuditDtls.get("activity");
							String activityDateTime			= (String) fileVolumeAuditDtls.get("activityDateTime");
							String doneBy					= (String) fileVolumeAuditDtls.get("doneBy");
							String classVal					= "QRYODD";
							String fileDispText				= fileNO;
							if("Y".equals(file_type_appl_yn)){
								fileDispText				= fileTypeDesc;
							}
							int row	= i;
							if(row%2==0){
								classVal					= "QRYEVEN";
							}else{
								classVal					= "QRYODD";
							}
						%>
						<tr>
							<td nowrap class="<%=classVal%>"> <%=encounterType%></td>
							<td nowrap class="<%=classVal%>"> <%=encounterID%></td>
							<td nowrap class="<%=classVal%>"> <%=encounterDateTime%></td>
							<td nowrap class="<%=classVal%>"> <%=location%></td>
							<td nowrap class="<%=classVal%>"> <%=activity%></td>
							<td nowrap class="<%=classVal%>"> <%=fileDispText%></td>
							<td nowrap class="<%=classVal%>"> <%=fileVolumeNo%></td>
							<td nowrap class="<%=classVal%>"> <%=doneBy%></td>
							<td nowrap class="<%=classVal%>"> <%=activityDateTime%></td>
						</tr>
				<%}%>
		
				</table>
				<%if(!showPline.equals("N")){%>
					<script>
						parent.patient_line_frame.document.location.href="../../eCommon/jsp/pline.jsp?Patient_ID="+"<%=reqPatientId%>";
						parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp";
					</script>
				<%}%>
				
				<%}else{%>
					<script>
						fnShowNoRecords();
					</script>
			<%}%>

		<%

		} catch(Exception e)	{
			e.printStackTrace();
		} finally{
			ConnectionManager.returnConnection(con,request);
		}
		%>

			</form>
		</body>
</html>

<%!

public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")) || (inputString.equals("undefined"))) ? "" : inputString);
}

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null")) || (inputString.equals("")) || (inputString.equals("undefined"))) ? defaultValue : inputString);
}

%>

