<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<HTML>
	<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
	<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
	<% 	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue 
		String call_function = request.getParameter("call_function");
		
	%>
	<HEAD>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/dchk.js' language='javascript'></script>
		<script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
		<script src='../js/DischargePatient.js' language='javascript'></script>
		<script src='../js/CancelDischarge.js' language='javascript'></script>
		<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
			function setTab()
			{
		
				var keyCode = window.event.keyCode;
				if(keyCode == 9)
				document.getElementById("confirm").focus();
			}

			function abortwinclose(){
				window.close();
			}
		</script>
	</HEAD>
	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey();">
		<table width="100%" cellpadding="0" cellspacing="0" align="right">
			<tr class='white'>
				<%
					if(call_function!=null && call_function.equals("CANCEL_DISCHARGE_PATIENT"))
					{
						%>
						<td  width="50%" class='label'></td>
						<td class='button' width="40%">
						<input type="button" class="button" name='confirm' id='confirm' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelDischarge.label","common_labels")%>" onclick="record(parent.frames[2].document.forms[0].bed_blocking_period);" onkeyDown="setTab();">
						<input type="button" class="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.AbortCancelDischarge.label","ip_labels")%>" onclick="abortwinclose();" onKeyDown="setTab();">
						</td>
						<%
					}
					else
					{
				%>
					<td  width="50%" class='button'><input type="button"  class= 'button' name="valuble" id="valuble" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientValuables.label","common_labels")%>" onClick ="showValuables()" id="values" style="visibility:hidden" ></td>
					<td class='button'><input type="button" class="button" name='confirm' id='confirm' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.ConfirmDischarge.label","ip_labels")%>" onclick="confirm1(parent.frames[2].document.forms[0].bed_blocking_period);" ><input type="button" class="button"  name='stay' id='stay' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.staydetails.label","common_labels")%>" onclick="callFunctions('SD')"><input type="button" class="button" name='advice' id='advice' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DischargeAdvice.label","common_labels")%>" onclick="callFunctions('DA')"><input type="button" class="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.AbortDischarge.label","ip_labels")%>" onclick="abortwinclose();"></td>
					<!--Maheshwaran K added for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013-->					
					<!--Start-->
					<script>
					setTimeout("DisableConfirm_Dummy()",500);
					function DisableConfirm_Dummy(){
					if(parent.frames[1].document.forms[0])
						{
						if(parent.frames[1].document.forms[0].mr_mds_recorded && parent.frames[1].document.forms[0].mds_chk)
							{
							DisableConfirm();
							}
						else{
							setTimeout("DisableConfirm_Dummy()",500);
							}
						}
					else{
						setTimeout("DisableConfirm_Dummy()",500);
						}			
					}
					function DisableConfirm(){
						if((parent.frames[1].document.forms[0].mr_mds_recorded.value!='Y')&&(parent.frames[1].document.forms[0].mds_chk.value!=0)){
							document.getElementById("confirm").disabled=true;
						}

					}
					</script>
					<!--End-->
				<%
					}
				%>
			</tr>
		</table> 
	</BODY>

</HTML>
<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

