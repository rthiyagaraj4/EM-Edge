<!DOCTYPE html>
<!-- 
Sr No        Version           Incident        SCF/CRF             Developer Name
----------------------------------------------------------------------------------
1            V210112            7661	     MOHE-CRF-0050.1        Ram kumar S
 -->


<%@ page
	import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*,  eCommon.Common.*,  "
	contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="xmlObj" scope="page"
	class="webbeans.eCommon.XMLStringParser" />
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale = 	(String)session.getAttribute("LOCALE");
	System.err.println(sStyle);
%>
<html>
<head>
<style>
.yellow{
    background: yellow;
}
thead 		{
	position:relative; 
	top: expression(offsetParent.scrollTop); /*IE5+ only*/
	}
</style>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script language='javascript' src='../../eBL/js/json2.js'></script>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js'></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="JavaScript" src="../../eBL/js/IntermDraftReport.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
	response.setHeader("Cache-Control","no-cache"); //HTTP 1.1   
	response.setHeader("Pragma","no-cache"); //HTTP 1.0   
	response.setDateHeader ("Expires", 0); //prevents caching at the proxy server 
	String facilityId =	"";
	Connection conIntermDraft = ConnectionManager.getConnection();	
	PreparedStatement pstmtIntermDraft = null;
	ResultSet rsIntermDraft = null;

	try  
	{		 
		sStyle 	=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		facilityId =   (String) session.getValue( "facility_id" ) ;
		if(facilityId == null) facilityId="";
		String loginUser	= (String) session.getValue("login_user");
		if(loginUser == null) loginUser="";
		String str_module_id     =  request.getParameter("module_id");	
		if(str_module_id == null) str_module_id="";
	
		
%>

<body onKeyDown="lockKey();" onMouseDown="CodeArrest();" onscroll='moveFrame()'
	style="padding-left: 10px; padding-right: 10px; padding-top: 5px;">
	<form name="IntermDraftReportTableForm" id="IntermDraftReportTableForm" id="IntermDraftReportTableForm"
		action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
				<table width='100%' align="center" cellpadding="4" cellspacing="0" id="patientDtlsTbl">
					<thead>
         			<tr>
            			<td class='COLUMNHEADER' style="text-align:center;"><fmt:message key="eBL.patientno.label" bundle="${bl_labels}" /></td>
            			<td class='COLUMNHEADER' style="text-align:center;"><fmt:message key="eBL.Patient Name.label" bundle="${bl_labels}" /></td>
            			<td class='COLUMNHEADER' style="text-align:center;"><fmt:message key="eBL.EpisodeType.label" bundle="${bl_labels}" /></td>
           			<td class='COLUMNHEADER' style="text-align:center;"><fmt:message key="eBL.AdmissionNo.label" bundle="${bl_labels}" /></td>
            			<td class='COLUMNHEADER' style="text-align:center;"><fmt:message key="eBL.AdmissionDate.label" bundle="${bl_labels}" /></td>
            			<td class='COLUMNHEADER' style="text-align:center;"><fmt:message key="eBL.NursingUnit.label" bundle="${bl_labels}" /></td>
            			<td class='COLUMNHEADER' style="text-align:center;"><fmt:message key="eBL.Room.label" bundle="${bl_labels}" /></td>
            			<td class='COLUMNHEADER' style="text-align:center;"><fmt:message key="eBL.CustomerCode.label" bundle="${bl_labels}" /></td> 
            			<td class='COLUMNHEADER' style="text-align:center;"><fmt:message key="Common.Bed.label" bundle="${common_labels}" /></td>
            			<td class='COLUMNHEADER' style="text-align:center;"><fmt:message key="Common.BedClass.label" bundle="${common_labels}" /></td>
            			<td class='COLUMNHEADER' style="text-align:center;"><fmt:message key="eBL.UNBILLED_AMT.label" bundle="${bl_labels}" /></td>
            			<td class='COLUMNHEADER' style="text-align:center;"><fmt:message key="eBL.UnadjustedAmt.label" bundle="${bl_labels}" /></td>
            			<td class='COLUMNHEADER' style="text-align:center;"><fmt:message key="eBL.OutstandingAmount.label" bundle="${bl_labels}" /></td>
            			<td class='COLUMNHEADER' style="text-align:center;"><fmt:message key="eOR.TotalAmount.label" bundle="${or_labels}" /></td>
            			<td class='COLUMNHEADER' style="text-align:center;"><fmt:message key="eBL.DischargeAdvice.label" bundle="${bl_labels}" /></td>
            			<td class='COLUMNHEADER' style="text-align:center;"><fmt:message key="Common.DischargeAdvice.label" bundle="${common_labels}" />&nbsp;<fmt:message key="Common.date.label" bundle="${common_labels}" /></td>
            			<td style="display:none;"><fmt:message key="eBL.BillingGroupId.label" bundle="${bl_labels}" /></td>
            			<td style="display:none;">Credit Doc Ref Desc</td>
            		</tr>
			</thead>
            		<!-- <tr>
            		<td><input type="text" maxlength="100" name="patientId" id="patientId" id="patientId" value="" ></td>
            		<td><input type="text" maxlength="100" name="patientName" id="patientName" id="patientName" value="" ></td>
            		<td><select name="episodeType" id="episodeType" id="episodeType">       
							<option value="Select" >-Select-</option>
              			</select>
              		</td>
            		<td><input type="text" maxlength="100" name="admissionNo" id="admissionNo" id="admissionNo" value="" ></td>
            		<td><input type="text" maxlength="100" name="admissionDate" id="admissionDate" id="admissionDate" value="" ></td>
            		<td><input type="text" maxlength="100" name="nursingUnit" id="nursingUnit" id="nursingUnit" value="" ></td>
            		<td><input type="text" maxlength="100" name="room" id="room" id="room" value="" ></td>
            		<td><input type="text" maxlength="100" name="custCode" id="custCode" id="custCode" value="" ></td>
            		<td><input type="text" maxlength="100" name="bed" id="bed" id="bed" value="" ></td>
            		<td><input type="text" maxlength="100" name="bedClass" id="bedClass" id="bedClass" value="" ></td>
            		<td><input type="text" maxlength="100" name="UnbilledAmt" id="UnbilledAmt" id="UnbilledAmt" value="" ></td>
            		<td><input type="text" maxlength="100" name="unadjustAmt" id="unadjustAmt" id="unadjustAmt" value="" ></td>
            		<td><input type="text" maxlength="100" name="outstndAmt" id="outstndAmt" id="outstndAmt" value="" ></td>
            		<td><input type="text" maxlength="100" name="totAmt" id="totAmt" id="totAmt" value="" ></td>
            		<td><input type="text" maxlength="100" name="dischrgeAdviceYN" id="dischrgeAdviceYN" id="dischrgeAdviceYN" value="" ></td>
            		<td><input type="text" maxlength="100" name="dischrgeAdviceDate" id="dischrgeAdviceDate" id="dischrgeAdviceDate" value="" ></td>
            		</tr>-->
				</table>

		<input type='hidden' name='locale' id='locale' id='locale' value="<%=locale%>">
		<input type='hidden' name='facilityId' id='facilityId' id='facilityId' value="<%=facilityId%>"> 
		<input type="hidden" name="p_module_id" id="p_module_id" id="p_module_id" value="<%=str_module_id%>">
		<input type="hidden" name="p_report_id" id="p_report_id" id="p_report_id" value="">
		<input type="hidden" name="p_user_id" id="p_user_id" id="p_user_id" value="<%=loginUser%>">
		<input type="hidden" name="pgm_id" id="pgm_id" id="pgm_id" value="">
	</form>
</body>
<%
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("Exception in IntermDraft Report.jsp::"+e);
	}
%>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
		
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>
</HTML>



