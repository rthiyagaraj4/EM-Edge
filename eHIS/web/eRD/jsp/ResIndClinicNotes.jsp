<!DOCTYPE html>
<%
/*
Sr No        Version              TFS              SCF/CRF           	   				 Developer Name
-------------------------------------------------------------------------------------------------------
1            V211228            26735      PMG2021-COMN-CRF-0089.1-TF-US001            Mohanapriya K
*/
%>
<%@page import="java.util.*,java.sql.*, eOR.* ,eOR.Common.*,eAE.resources.*,eCA.resources.*,eCA.*,eRD.* ,eRD.Common.*,webbeans.eCommon.*, eCommon.Common.*,java.util.*,java.lang.*,java.text.*" contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Report Text</title>
 
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
 	<script language="javascript" src="../../eCommon/js/dchk.js"></script>
	<script language="javascript" src="../js/RadiologyExam.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>
<%!
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
%>
<%
	String params =checkForNull(request.getParameter("params"));
	String P_FACILITY_ID = checkForNull(request.getParameter("P_FACILITY_ID"));
	String P_PATIENT_ID = checkForNull(request.getParameter("P_PATIENT_ID"));
	String P_ENCOUNTER_ID = checkForNull(request.getParameter("P_ENCOUNTER_ID"));
	String P_LOGIN_USER = checkForNull(request.getParameter("P_LOGIN_USER"));
	String P_LANGUAGE_ID = checkForNull(request.getParameter("P_LANGUAGE_ID"));
	String P_RESP_ID = checkForNull(request.getParameter("P_RESP_ID"));
	String P_REQUEST_NUM = checkForNull(request.getParameter("P_REQUEST_NUM"));
	String P_REQUEST_LINE_NUM = checkForNull(request.getParameter("P_REQUEST_LINE_NUM"));
	String P_EXT_APPL_ACCESSION_NUM = checkForNull(request.getParameter("P_EXT_APPL_ACCESSION_NUM"));
	String indicator = checkForNull(request.getParameter("indicator"));
	String index = checkForNull(request.getParameter("index"));
	String radiologist = checkForNull(request.getParameter("radiologist"));
	Connection con = ConnectionManager.getConnection();
	String report_text="";
	System.err.println("clinic note indicator"+indicator);
	try
		{
		PreparedStatement pstmt1 = null;
		ResultSet rs1 = null;
		
			System.err.println("P_FACILITY_ID--"+P_FACILITY_ID);
			System.err.println("P_REQUEST_NUM--"+P_REQUEST_NUM);
			System.err.println("P_REQUEST_LINE_NUM--"+P_REQUEST_LINE_NUM);
			System.err.println("P_LANGUAGE_ID--"+P_LANGUAGE_ID);
			
				pstmt1=con.prepareStatement("select report_text from rd_exam_view_requested WHERE operating_facility_id = ? and request_num=?  and REQUEST_LINE_NUM=?");			
				
				pstmt1.setString(1,P_FACILITY_ID);
				pstmt1.setString(2,P_REQUEST_NUM);
				pstmt1.setString(3,P_REQUEST_LINE_NUM);
				
				rs1 = pstmt1.executeQuery();
				while (rs1.next()) {
					report_text =checkForNull(rs1.getString(1));
					System.err.println("report_text--"+report_text);
				}
				


%>

<body>
	<form id="reportText" name="reportText" id="reportText" target='messageFrame' action="" method="post">
		<table>
		
		
			<% if(indicator.equals("M")){%>
			<tr>
				<td colspan='3'>
					<textarea name="clinCom" id="clinCom" rows=28 cols=130 readonly><%=report_text%></textarea>
				</td>
			</tr>
			<tr>
				<td colspan='3'>
					<textarea name="clinComm1" id="clinComm1" rows=18 cols=130 ></textarea>
				</td>
			</tr>
			<%}else{%>
			<tr>
				<td colspan='3'>
					<textarea name="clinComm1" id="clinComm1" rows=46 cols=130 ><%=report_text%></textarea>
				</td>
			</tr>
			<%	}%>
			
		<tr>
			<td align="right">		
				<input type='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>' class='button' onclick="insertNotes(<%=index%>);" />			
				<input name="close" id="close" id="close" type="button" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}" />' class="button" onClick="window.close();" />
			</td>
  		</tr>
	</table> 
			<input type="hidden" value="<%=P_FACILITY_ID%>" name="operating_facility_id<%=index%>" id="operating_facility_id<%=index%>" /> 
			<input type="hidden" value="<%=report_text%>" name="retrivedtext" id="retrivedtext" /> 
			<input type="hidden" value="<%=report_text%>" name="prevComm" id="prevComm" /> 
			<input type="hidden" value="" name="updatedText" id="updatedText" id="updatedText" /> 
			<input type="hidden" value="<%=P_PATIENT_ID%>" name="patientid<%=index%>" id="patientid<%=index%>" /> 
			 <input type="hidden" value="<%=P_ENCOUNTER_ID%>" name="enc_id<%=index%>" id="enc_id<%=index%>" /> 
			 <input type="hidden" name="User" id="User" id="User" value="<%=P_LOGIN_USER%>" />
			<input type="hidden" value="<%=P_RESP_ID%>" name="responsibility_id" id="responsibility_id" /> 
			<input type="hidden" value="<%=P_REQUEST_NUM%>" name="req_no<%=index%>" id="req_no<%=index%>" /> 
			 <input type="hidden" value="<%=P_REQUEST_LINE_NUM%>" name="REQUEST_LINE_NUM<%=index%>" id="REQUEST_LINE_NUM<%=index%>" /> <input type="hidden" name="locale" id="locale" id="locale" value="<%=P_LANGUAGE_ID%>" />
			<input type="hidden" value="<%=P_FACILITY_ID%>" name="operating_facility_id<%=index%>" id="operating_facility_id<%=index%>" /> 
			<input type="hidden" value="<%=indicator%>" name="indicator<%=index%>" id="indicator<%=index%>" /> 
			<input type="hidden" value="<%=radiologist%>" name="radiologist<%=index%>" id="radiologist<%=index%>" /> 
			 <input type="hidden" value="<%=P_EXT_APPL_ACCESSION_NUM%>" name="ext_appl_accession<%=index%>" id="ext_appl_accession<%=index%>" /> 
		<%
			}catch(Exception e)
		{
			System.out.println("Exception while retriving clinical notes :"+e);
		}finally{
			ConnectionManager.returnConnection(con, request);
		}
		%>

