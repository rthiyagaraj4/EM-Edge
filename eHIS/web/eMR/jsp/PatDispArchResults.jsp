<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*, java.text.* ,javax.servlet.*,javax.servlet.http.*,webbeans.eCommon.*,org.json.simple.parser.JSONParser,org.json.simple.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<% 
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
	<Script language='javascript' src='../js/PatDispArch.js'></Script> 
	<script language="JavaScript" src="../../eCommon/js/tableheaderscroll.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<script>
		window.onload=function(){
			if(document.getElementById("patientList")!=null)			
				fxheaderInit('patientList',480);
		};
	</script>
	<style>
		
    </style>
	</style>
</head>
<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<form name="test_form" id="test_form" action="../../servlet/eMR.PatDispArchServlet" method="post" target="messageFrame"  >
<%
	Connection con = null;
	
	try	{

		con = ConnectionManager.getConnection(request);
		JSONArray batchIdDtlsJsonArr	= new JSONArray();
		String batchId		= checkForNull(request.getParameter("batchId"));
		String locale			= (String)session.getAttribute("LOCALE");
		String classValue	= "";
		batchIdDtlsJsonArr  = eMR.MRPatDisposalArchivalBean.getBatchIdDtls(con,locale,batchId);

%>
			
		
			<table  border='1' cellpadding='0' cellspacing='0'   width="98%" id="patientList" style="margin-left:3px;" >
				<tr>
					<th class="COLUMNHEADER" width="5%" nowrap><fmt:message key="Common.SlNo.label" bundle="${common_labels}"/></th>
					<th class="COLUMNHEADER" width="10%" nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
					<th class="COLUMNHEADER"  width="17%" nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
					<th class="COLUMNHEADER"  width="12%" nowrap><fmt:message key="Common.dischargedate.label" bundle="${common_labels}"/></th>
					<th class="COLUMNHEADER"  width="10%" nowrap><fmt:message key="Common.Specialty.label" bundle="${common_labels}"/></th>
					<th class="COLUMNHEADER"  width="10%" nowrap><fmt:message key="Common.age.label" bundle="${common_labels}"/></th>
					<th class="COLUMNHEADER" width="10%"nowrap >
					<!--<fmt:message key="Common.National.label" bundle="${common_labels}"/> / <fmt:message key="Common.AlternateID.label" bundle="${common_labels}"/>-->
<fmt:message key="Common.NRICAltID.label" bundle="${common_labels}"/>
					</th>
					<th class="COLUMNHEADER"  width="10%" nowrap><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></th>
					<th class="COLUMNHEADER"  width="8%" nowrap><fmt:message key="Common.status.label" bundle="${common_labels}"/></th>

					<th class="COLUMNHEADER" width="8%"nowrap ><fmt:message key="Common.selectall.label" bundle="${common_labels}"/>  <input type="checkbox" name="chkAll" id="chkAll" onclick="chkSelAll(this);"/></th>					
				</tr>
				<%for(int i = 0 ; i < batchIdDtlsJsonArr.size() ; i++) {

					JSONObject batchIdDtlsJson		= (JSONObject)batchIdDtlsJsonArr.get(i);
					String patient_id		= (String) batchIdDtlsJson.get("patient_id");
					String patient_name	= (String) batchIdDtlsJson.get("patient_name");
					String last_disch_date	= (String) batchIdDtlsJson.get("last_disch_date");
					String last_enc_speciality	= (String) batchIdDtlsJson.get("last_enc_speciality");
					String pat_age	= (String) batchIdDtlsJson.get("pat_age");
					String alternate_id	= (String) batchIdDtlsJson.get("alternate_id");
					String last_enc_pat_class	= (String) batchIdDtlsJson.get("last_enc_pat_class");
					String pat_status	= (String) batchIdDtlsJson.get("pat_status");
					int j= i+1;
					if (j%2 == 0)
					classValue = "QRYEVEN" ;
					else
					classValue = "QRYODD" ;
					
				%>
					<tr>
					<td  class="<%=classValue%>" width="5%"><%=j%></td>
					<td  class="<%=classValue%>" width="10%"><%=patient_id%></td>
					<td  class="<%=classValue%>" style='width:17%;word-wrap: break-word; word-break: break-all;'><%=patient_name%></td>
					<td  class="<%=classValue%>" width="12%"><%=last_disch_date%>&nbsp;</td>
					<td  class="<%=classValue%>" width="10%"><%=last_enc_speciality%>&nbsp;</td>
					<td  class="<%=classValue%>" width="10%"><%=pat_age%>&nbsp;</td>
					<td  class="<%=classValue%>" width="10%"><%=alternate_id%>&nbsp;</td>
					<td  class="<%=classValue%>" width="10%"><%=last_enc_pat_class%>&nbsp;</td>
					<td  class="<%=classValue%>" width="8%"><%=pat_status%>&nbsp;</td>
					<td  class="<%=classValue%>" width="8%"><input type="checkbox" name="chkApproval" id="chkApproval" value="<%=patient_id%>" /> &nbsp;</td>
					</tr>
				<%}%>

			</table>

			<input type="hidden" name="batchId" id="batchId" value="<%=batchId%>" />
			<input type="hidden" name="action" id="action" value="disposal" />
			<input type="hidden" name="approval_disp_no" id="approval_disp_no" value="" />
			<input type="hidden" name="approval_date" id="approval_date" value="" />
			<input type="hidden" name="actType" id="actType" value="" />
			<input type="hidden" name="selectedPatientIds" id="selectedPatientIds" />
	
</form>

</body>
</html>

<%

	} catch(Exception e) {
		e.printStackTrace();
		
		//out.println(e.getMessage());
		}
	
	finally {
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>

<%!	
	private String checkForNull(String inputString)	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

