<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<title><fmt:message key="eIP.PorterageDetails.label" bundle="${ip_labels}"/></title>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<script>

</script>
<%
	request.setCharacterEncoding("UTF-8");
	String jsp_name =  request.getParameter("function_name");
     jsp_name = (jsp_name==null) ? "" : jsp_name;
%>
<body onLoad="populateDetails();" onMouseDown='CodeArrest()' onKeyDown='lockKey();'>
<form name="Porterage_form" id="Porterage_form"  method="post"action='' target='messageFrame'> 
<table border=0 width="100%" cellpadding='2' cellspacing=0>
	<tr>
		<td colspan=6 width="100%" class='columnheader'><fmt:message key="eIP.MedicalEquipment.label" bundle="${ip_labels}"/></td>
	</tr>
 		<tr><td colspan="4" class="label">&nbsp;</td></tr>
		<tr>
			<td colspan=3 ><input type=text name='equip1_desc' id='equip1_desc'  <%if(jsp_name.equals("TransferPatientIn"))
	{%>readOnly <%}%> maxlength=40 size=25 width="15" value="" >&nbsp;<input type=text name='equip2_desc' id='equip2_desc'  <%if(jsp_name.equals("TransferPatientIn"))
	{%>readOnly <%}%> maxlength=40 size=25 width="15" value="">&nbsp;<input type=text name='equip3_desc' id='equip3_desc'  <%if(jsp_name.equals("TransferPatientIn"))
	{%>readOnly <%}%> maxlength=40 size=25 width="15" value="">&nbsp;<input type=text name='equip7_desc' id='equip7_desc'  <%if(jsp_name.equals("TransferPatientIn"))
	{%>readOnly <%}%> maxlength=40 size=25 width="15" value=""></td>			
		</tr>
		<tr>
			<td colspan=3 ><input type=text name='equip4_desc' id='equip4_desc'  <%if(jsp_name.equals("TransferPatientIn"))
	{%>readOnly <%}%> maxlength=40 size=25 width="15" value="">&nbsp;<input type=text name='equip5_desc' id='equip5_desc'  <%if(jsp_name.equals("TransferPatientIn"))
	{%>readOnly <%}%> maxlength=40 size=25 width="15" value="">&nbsp;<input type=text name='equip6_desc' id='equip6_desc'  <%if(jsp_name.equals("TransferPatientIn"))
	{%>readOnly <%}%> maxlength=40 size=25 width="15" value=""></td>			
		</tr>
	<tr>
		<td colspan=6 width="100%" class='columnheader'><fmt:message key="eIP.BloodandMedication.label" bundle="${ip_labels}"/></td>
	</tr>
 		<tr><td colspan="4" class="label">&nbsp;</td></tr>
		<tr>			
			<td colspan=3 ><input type=text name='bld_med1_desc' id='bld_med1_desc' <%if(jsp_name.equals("TransferPatientIn"))
	{%>readOnly <%}%> maxlength=40 size=25 width="15" value="">&nbsp;<input type=text name='bld_med2_desc' id='bld_med2_desc' <%if(jsp_name.equals("TransferPatientIn"))
	{%>readOnly <%}%> maxlength=40 size=25 width="15" value="">&nbsp;<input type=text name='bld_med3_desc' id='bld_med3_desc' <%if(jsp_name.equals("TransferPatientIn"))
	{%>readOnly <%}%> maxlength=40 size=25 width="15" value="">&nbsp;<input type=text name='bld_med4_desc' id='bld_med4_desc' <%if(jsp_name.equals("TransferPatientIn"))
	{%>readOnly <%}%> maxlength=40 size=25 width="15" value=""></td>
		</tr>
		<tr>			
			<td colspan=3 ><input type=text name='bld_med5_desc' id='bld_med5_desc' <%if(jsp_name.equals("TransferPatientIn"))
	{%>readOnly <%}%> maxlength=40 size=25 width="15" value="">&nbsp;<input type=text name='bld_med6_desc' id='bld_med6_desc'  <%if(jsp_name.equals("TransferPatientIn"))
	{%>readOnly <%}%> maxlength=40 size=25 width="15" value="">&nbsp;<input type=text name='bld_med7_desc' id='bld_med7_desc' <%if(jsp_name.equals("TransferPatientIn"))
	{%>readOnly <%}%>  maxlength=40 size=25 width="15" value="">&nbsp;<input type=text name='bld_med8_desc' id='bld_med8_desc' <%if(jsp_name.equals("TransferPatientIn"))
	{%>readOnly <%}%> maxlength=40 size=25 width="15" value=""></td>			
		</tr>
		<tr>			
			<td colspan=3 ><input type=text name='bld_med9_desc' id='bld_med9_desc' <%if(jsp_name.equals("TransferPatientIn"))
	{%>readOnly <%}%> maxlength=40 size=25 width="15" value="">&nbsp;<input type=text name='bld_med10_desc' id='bld_med10_desc' <%if(jsp_name.equals("TransferPatientIn"))
	{%>readOnly <%}%> maxlength=40 size=25 width="15" value=""></td>	
		</tr>
	<tr>
		<td colspan=6 width="100%" class='columnheader'><fmt:message key="eIP.RecordsDocuments.label" bundle="${ip_labels}"/></td>
	</tr>
 		<tr><td colspan="4" class="label">&nbsp;</td></tr>
		<tr>			
			<td colspan=3 ><input type=text name='rec_doc1_desc' id='rec_doc1_desc'  <%if(jsp_name.equals("TransferPatientIn"))
	{%>readOnly <%}%> maxlength=40 size=25 width="15" value="">&nbsp;<input type=text name='rec_doc2_desc' id='rec_doc2_desc' <%if(jsp_name.equals("TransferPatientIn"))
	{%>readOnly <%}%>  maxlength=40 size=25 width="15" value="">&nbsp;<input type=text name='rec_doc3_desc' id='rec_doc3_desc'  <%if(jsp_name.equals("TransferPatientIn"))
	{%>readOnly <%}%> maxlength=40 size=25 width="15" value="">&nbsp;<input type=text name='rec_doc4_desc' id='rec_doc4_desc' <%if(jsp_name.equals("TransferPatientIn"))
	{%>readOnly <%}%>  maxlength=40 size=25 width="15" value=""></td>
		</tr>
		<tr>			
			<td colspan=3 ><input type=text name='rec_doc5_desc' id='rec_doc5_desc' <%if(jsp_name.equals("TransferPatientIn"))
	{%>readOnly <%}%> maxlength=40 size=25 width="15" value="" ></td>			
		</tr>
		
		<%if(jsp_name.equals("TransferPatientIn"))
		{%>
		<tr>			
			<td  nowrap class="label" ><fmt:message key="eIP.PorterageReceived.label" bundle="${ip_labels}"/></td>			
			<td class='fields'><input type="checkbox" disabled name="port_received_yn" id="port_received_yn" value="N" onClick = "assignValue();">&nbsp;&nbsp;Partially/Fully
				<select name="received" id="received" disabled>
					<option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
					<option value="F"><fmt:message key="eIP.ReceivedinFull.label" bundle="${ip_labels}"/></option>
					<option value="P"><fmt:message key="eIP.ReceivedPartially.label" bundle="${ip_labels}"/></option>
				</select><img align="center" id="received_img" src="../../eCommon/images/mandatory.gif">
			</td>
		</tr>		
		<tr>			
			<td  nowrap class="label" ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>		
			<td class='fields'><input type="text" name='port_remarks' id='port_remarks' disabled maxlength="200" size="100" ></td>
		</tr>
	<%
		}
		else
		{
	%>
		<tr>
		<td colspan="4" class="label">&nbsp;</td>
		</tr>
		<tr>
		<td class='DEFAULTBLANKROW' colspan=4 height="53"></td>
		</tr>
	<%
		}
	%>
	<!--<tr>
	<td >&nbsp;</td>	
	<td align='right'><input type="button" class="button" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>'  onclick="submit_Form();"><input type="button" class="button" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' onclick="cancel();" onblur="tab_click('porterage_details')"></td>
	</tr>-->
</table>
<input type="hidden" name="jsp_name_val" id="jsp_name_val" value ="<%=jsp_name%>">
</form>
</body>
</html>

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

