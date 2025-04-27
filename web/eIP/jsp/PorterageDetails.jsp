<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<title><fmt:message key="eIP.PorterageDetails.label" bundle="${ip_labels}"/></title>
<head>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<script>

// By Annadurai 3/5/2004 starts.,
function assignValue()
{
	if (document.forms[0].port_received_yn.checked == true)
		document.forms[0].port_received_yn.value	= "Y";
	else document.forms[0].port_received_yn.value	= "N";
}
// By Annadurai 3/5/2004 ends.,
function selfClose()
{
	self.close();
	return 1;
}
function close_me()
{
	
	var port_vals = "";
	port_vals = 
				
	(document.forms[0].Mode_of_Tran_desc.value.length == 0 ? " " : document.forms[0].Mode_of_Tran_desc.value) + "^^" + 
	(document.forms[0].acc_per1_desc.value.length == 0? " " : document.forms[0].acc_per1_desc.value )+ "^^" +
	(document.forms[0].acc_per2_desc.value.length == 0? " " :			
	document.forms[0].acc_per2_desc.value) + "^^" +
	(document.forms[0].acc_per3_desc.value.length == 0 ? " " :
	document.forms[0].acc_per3_desc.value) + "^^" +
	(document.forms[0].acc_per4_desc.value.length == 0 ? " " :
	document.forms[0].acc_per4_desc.value) + "^^" +
	(document.forms[0].acc_per5_desc.value.length == 0 ? " " :
	document.forms[0].acc_per5_desc.value) + "^^" +
	(document.forms[0].acc_per6_desc.value.length == 0 ? " " :	
	document.forms[0].acc_per6_desc.value) + "^^" +
	(document.forms[0].acc_per7_desc.value.length == 0 ? " " :			
	document.forms[0].acc_per7_desc.value) + "^^" +

	(document.forms[0].equip1_desc.value.length == 0 ? " " :
	document.forms[0].equip1_desc.value) + "^^" +
	(document.forms[0].equip2_desc.value.length == 0 ? " " :			
	document.forms[0].equip2_desc.value) + "^^" +
	(document.forms[0].equip3_desc.value.length == 0 ? " " :
	document.forms[0].equip3_desc.value) + "^^" +
	(document.forms[0].equip4_desc.value.length == 0 ? " " :
	document.forms[0].equip4_desc.value) + "^^" +
	(document.forms[0].equip5_desc.value.length == 0 ? " " :
	document.forms[0].equip5_desc.value) + "^^" +
	(document.forms[0].equip6_desc.value.length == 0 ? " " :			
	document.forms[0].equip6_desc.value) + "^^" +
	(document.forms[0].equip7_desc.value.length == 0 ? " " : 			
	document.forms[0].equip7_desc.value) + "^^" +
				
	(document.forms[0].bld_med1_desc.value.length == 0 ? " " : 
	document.forms[0].bld_med1_desc.value) + "^^" +
	(document.forms[0].bld_med2_desc.value.length == 0 ? " " :  			
	document.forms[0].bld_med2_desc.value) + "^^" +
	(document.forms[0].bld_med3_desc.value.length == 0 ? " " : 			
	document.forms[0].bld_med3_desc.value) + "^^" +
	(document.forms[0].bld_med4_desc.value.length == 0 ? " " : 			
	document.forms[0].bld_med4_desc.value) + "^^" +
	(document.forms[0].bld_med5_desc.value.length == 0 ? " " :  			
	document.forms[0].bld_med5_desc.value) + "^^" +
	(document.forms[0].bld_med6_desc.value.length == 0 ? " " : 			
	document.forms[0].bld_med6_desc.value) + "^^" +
	(document.forms[0].bld_med7_desc.value.length == 0 ? " " :  			
	document.forms[0].bld_med7_desc.value) + "^^" +
	(document.forms[0].bld_med8_desc.value.length == 0 ? " " :  			
	document.forms[0].bld_med8_desc.value) + "^^" +
	(document.forms[0].bld_med9_desc.value.length == 0 ? " " : 			
	document.forms[0].bld_med9_desc.value) + "^^" +
	(document.forms[0].bld_med10_desc.value.length == 0 ? " " :  			
	document.forms[0].bld_med10_desc.value) + "^^" +
				
	(document.forms[0].rec_doc1_desc.value.length == 0 ? " " :
	document.forms[0].rec_doc1_desc.value) + "^^" +
	(document.forms[0].rec_doc2_desc.value.length == 0 ? " " : 
	document.forms[0].rec_doc2_desc.value) + "^^" +
	(document.forms[0].rec_doc3_desc.value.length == 0 ? " " : 			
	document.forms[0].rec_doc3_desc.value) + "^^" +
	(document.forms[0].rec_doc4_desc.value.length == 0 ? " " : 			
	document.forms[0].rec_doc4_desc.value) + "^^" +
	(document.forms[0].rec_doc5_desc.value.length == 0 ? " " : 			
	document.forms[0].rec_doc5_desc.value) + "^^" +
				
	(document.forms[0].pat_bel1_desc.value.length == 0 ? " " :
	document.forms[0].pat_bel1_desc.value) + "^^" +
	(document.forms[0].pat_bel2_desc.value.length == 0 ? " " : 			
	document.forms[0].pat_bel2_desc.value) + "^^" +
	(document.forms[0].pat_bel3_desc.value.length == 0 ? " " : 			
	document.forms[0].pat_bel3_desc.value) + "^^" +
	(document.forms[0].pat_bel4_desc.value.length == 0 ? " " : 			
	document.forms[0].pat_bel4_desc.value) + "^^" +
	(document.forms[0].pat_bel5_desc.value.length == 0 ? " " : 			
	document.forms[0].pat_bel5_desc.value) + "^^" +
	(document.forms[0].pat_bel6_desc.value.length == 0 ? " " : 			
	document.forms[0].pat_bel6_desc.value) + "^^" +
	(document.forms[0].pat_bel7_desc.value.length == 0 ? " " : 			
	document.forms[0].pat_bel7_desc.value) + "^^" +
	(document.forms[0].pat_bel8_desc.value.length == 0 ? " " :
	document.forms[0].pat_bel8_desc.value) + "^^" +
	(document.forms[0].pat_bel9_desc.value.length == 0 ? " " :
	document.forms[0].pat_bel9_desc.value) + "^^" +
	(document.forms[0].pat_bel10_desc.value.length == 0 ? " " :
	document.forms[0].pat_bel10_desc.value)+ "^^" ;
	// By Annadurai 3/5/2004 starts.,
	if (document.forms[0].jsp_name_val.value == "PatientIn")
	{	
		port_vals = port_vals +
		(document.forms[0].port_received_yn.value.length == 0 ? " " :document.forms[0].port_received_yn.value)+ "^^" +
		(document.forms[0].received.value.length == 0 ? " " :
		document.forms[0].received.value)+ "^^" +
		(document.forms[0].port_remarks.value.length == 0 ? " " :
		document.forms[0].port_remarks.value);
	}
	// By Annadurai 3/5/2004 ends.,

	window.close();	
	window.returnValue =port_vals;
}
function populateDetails()
{
	var port_vals=parent.window.dialogArguments;
	if(port_vals == null || port_vals =='null')
	{
		port_vals='';
	}

	var arr_port_vals=port_vals.split("^^");
	if(arr_port_vals[0])
		document.forms[0].Mode_of_Tran_desc.value		= arr_port_vals[0];
	
	if(arr_port_vals[1])
		document.forms[0].acc_per1_desc.value		= arr_port_vals[1];
	if(arr_port_vals[2])
		document.forms[0].acc_per2_desc.value		= arr_port_vals[2];
	if(arr_port_vals[3])
		document.forms[0].acc_per3_desc.value		= arr_port_vals[3];
	if(arr_port_vals[4])
		document.forms[0].acc_per4_desc.value		= arr_port_vals[4];
	if(arr_port_vals[5])
		document.forms[0].acc_per5_desc.value		= arr_port_vals[5];
	if(arr_port_vals[6])
		document.forms[0].acc_per6_desc.value		= arr_port_vals[6];
	if(arr_port_vals[7])
		document.forms[0].acc_per7_desc.value		= arr_port_vals[7];
	
	if(arr_port_vals[8])
		document.forms[0].equip1_desc.value		= arr_port_vals[8];
	if(arr_port_vals[9])
		document.forms[0].equip2_desc.value		= arr_port_vals[9];
	if(arr_port_vals[10])
		document.forms[0].equip3_desc.value		= arr_port_vals[10];
	if(arr_port_vals[11])
		document.forms[0].equip4_desc.value		= arr_port_vals[11];
	if(arr_port_vals[12])
		document.forms[0].equip5_desc.value		= arr_port_vals[12];
	if(arr_port_vals[13])
		document.forms[0].equip6_desc.value		= arr_port_vals[13];
	if(arr_port_vals[14])
		document.forms[0].equip7_desc.value		= arr_port_vals[14];

	if(arr_port_vals[15])
		document.forms[0].bld_med1_desc.value		= arr_port_vals[15];
	if(arr_port_vals[16])
		document.forms[0].bld_med2_desc.value		= arr_port_vals[16];
	if(arr_port_vals[17])
		document.forms[0].bld_med3_desc.value		= arr_port_vals[17];
	if(arr_port_vals[18])
		document.forms[0].bld_med4_desc.value		= arr_port_vals[18];
	if(arr_port_vals[19])
		document.forms[0].bld_med5_desc.value		= arr_port_vals[19];
	if(arr_port_vals[20])
		document.forms[0].bld_med6_desc.value		= arr_port_vals[20];
	if(arr_port_vals[21])
		document.forms[0].bld_med7_desc.value		= arr_port_vals[21];
	if(arr_port_vals[22])
		document.forms[0].bld_med8_desc.value		= arr_port_vals[22];
	if(arr_port_vals[23])
		document.forms[0].bld_med9_desc.value		= arr_port_vals[23];
	if(arr_port_vals[24])
		document.forms[0].bld_med10_desc.value		= arr_port_vals[24];


	if(arr_port_vals[25])
		document.forms[0].rec_doc1_desc.value		= arr_port_vals[25];
	if(arr_port_vals[26])
		document.forms[0].rec_doc2_desc.value		= arr_port_vals[26];
	if(arr_port_vals[27])
		document.forms[0].rec_doc3_desc.value		= arr_port_vals[27];
	if(arr_port_vals[28])
		document.forms[0].rec_doc4_desc.value		= arr_port_vals[28];
	if(arr_port_vals[29])
		document.forms[0].rec_doc5_desc.value		= arr_port_vals[29];

	if(arr_port_vals[30])
		document.forms[0].pat_bel1_desc.value		= arr_port_vals[30];
	if(arr_port_vals[31])
		document.forms[0].pat_bel2_desc.value		= arr_port_vals[31];
	if(arr_port_vals[32])
		document.forms[0].pat_bel3_desc.value		= arr_port_vals[32];
	if(arr_port_vals[33])
		document.forms[0].pat_bel4_desc.value		= arr_port_vals[33];
	if(arr_port_vals[34])
		document.forms[0].pat_bel5_desc.value		= arr_port_vals[34];
	if(arr_port_vals[35])
		document.forms[0].pat_bel6_desc.value		= arr_port_vals[35];
	if(arr_port_vals[36])
		document.forms[0].pat_bel7_desc.value		= arr_port_vals[36];
	if(arr_port_vals[37])
		document.forms[0].pat_bel8_desc.value		= arr_port_vals[37];
	if(arr_port_vals[38])
		document.forms[0].pat_bel9_desc.value		= arr_port_vals[38];
	if(arr_port_vals[39])
		document.forms[0].pat_bel10_desc.value		= arr_port_vals[39];
	// By Annadurai 3/5/2004 start.,
	if (document.forms[0].jsp_name_val.value == "PatientIn")
	{
		if(arr_port_vals[40]) 
		{
			document.forms[0].port_received_yn.value	= arr_port_vals[40];
			if (arr_port_vals[40] == "Y")
				document.forms[0].port_received_yn.checked = true;
			else
				document.forms[0].port_received_yn.checked = false;
		}
		if(arr_port_vals[41]) 
			document.forms[0].received.value			= arr_port_vals[41];
		if(arr_port_vals[42]) 
			document.forms[0].port_remarks.value		= arr_port_vals[42];
	}
	// By Annadurai 3/5/2004 end.,
}
</script>
<%
   //   By Annadurai 3/5/2004 starts
   String jsp_name =  request.getParameter("jsp_name");
   jsp_name = (jsp_name==null) ? "" : jsp_name;
   //   By Annadurai 3/5/2004 ends
%>
<body onLoad="populateDetails();" onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<form name="Porterage_form" id="Porterage_form"  method="post"action='' target='messageFrame'> 
<table border=0 width="100%" cellpadding=0 cellspacing=0>
	<tr>
			<td  align="right" nowrap class="label" ><fmt:message key="Common.ModeOfTransport.label" bundle="${common_labels}"/></td>
			<td colspan=3 align=left>&nbsp;<input type=text name='Mode_of_Tran_desc' id='Mode_of_Tran_desc'  maxlength=30 size=30  value=""></td>
		</tr>		
		<tr ><td colspan="4" class="label" >&nbsp;</td></tr>
		<tr>			
			<td  align="right" nowrap class="label" ><fmt:message key="eIP.AccompanyingPerson.label" bundle="${ip_labels}"/></td>
			<td colspan=3 >&nbsp;<input type=text name='acc_per1_desc' id='acc_per1_desc'  maxlength=30 size=30 width="15" value="">&nbsp;<input type=text name='acc_per2_desc' id='acc_per2_desc'  maxlength=30 size=30 width="15" value="">&nbsp;<input type=text name='acc_per3_desc' id='acc_per3_desc'  maxlength=30 size=30 width="15" value=""></td>			
		</tr>
		<tr>			
			<td  align="right" nowrap class="label" >&nbsp;</td>
			<td colspan=3 >&nbsp;<input type=text name='acc_per4_desc' id='acc_per4_desc'  maxlength=30 size=30 width="15" value="">&nbsp;<input type=text name='acc_per5_desc' id='acc_per5_desc'  maxlength=30 size=30 width="15" value="">&nbsp;<input type=text name='acc_per6_desc' id='acc_per6_desc'  maxlength=30 size=30 width="15" value=""></td>			
		</tr>
		<tr>			
			<td  align="right" nowrap class="label" >&nbsp;</td>
			<td colspan=3 >&nbsp;<input type=text name='acc_per7_desc' id='acc_per7_desc'  maxlength=30 size=30 width="15" value=""></td>			
		</tr>
		<tr><td colspan="4" class="label">&nbsp;</td></tr>
		<tr>
			<td  align="right" nowrap class="label" ><fmt:message key="Common.equipment.label" bundle="${common_labels}"/></td>
			<td colspan=3 >&nbsp;<input type=text name='equip1_desc' id='equip1_desc'  maxlength=40 size=30 width="15" value="">&nbsp;<input type=text name='equip2_desc' id='equip2_desc'  maxlength=40 size=30 width="15" value="">&nbsp;<input type=text name='equip3_desc' id='equip3_desc'  maxlength=40 size=30 width="15" value=""></td>			
		</tr>
		<tr>
			<td  align="right" nowrap class="label" >&nbsp;</td>
			<td colspan=3 >&nbsp;<input type=text name='equip4_desc' id='equip4_desc'  maxlength=40 size=30 width="15" value="">&nbsp;<input type=text name='equip5_desc' id='equip5_desc'  maxlength=40 size=30 width="15" value="">&nbsp;<input type=text name='equip6_desc' id='equip6_desc'  maxlength=40 size=30 width="15" value=""></td>			
		</tr>
		<tr>			
			<td  align="right" nowrap class="label" >&nbsp;</td>
			<td colspan=3 >&nbsp;<input type=text name='equip7_desc' id='equip7_desc'  maxlength=40 size=30 width="15" value=""></td>			
		</tr>
		<tr><td colspan="4" class="label" >&nbsp;</td></tr>
		<tr>			
			<td  align="right" nowrap class="label" ><fmt:message key="eIP.BloodandMedication.label" bundle="${ip_labels}"/></td>
			<td colspan=3 >&nbsp;<input type=text name='bld_med1_desc' id='bld_med1_desc'  maxlength=40 size=30 width="15" value="">&nbsp;<input type=text name='bld_med2_desc' id='bld_med2_desc'  maxlength=40 size=30 width="15" value="">&nbsp;<input type=text name='bld_med3_desc' id='bld_med3_desc'  maxlength=40 size=30 width="15" value=""></td>
			
		</tr>
		<tr>			
			<td  align="right" nowrap class="label" >&nbsp;</td>
			<td colspan=3 >&nbsp;<input type=text name='bld_med4_desc' id='bld_med4_desc'  maxlength=40 size=30 width="15" value="">&nbsp;<input type=text name='bld_med5_desc' id='bld_med5_desc'  maxlength=40 size=30 width="15" value="">&nbsp;<input type=text name='bld_med6_desc' id='bld_med6_desc'  maxlength=40 size=30 width="15" value=""></td>			
		</tr>
		<tr>			
			<td  align="right" nowrap class="label" >&nbsp;</td>
			<td colspan=3 >&nbsp;<input type=text name='bld_med7_desc' id='bld_med7_desc'  maxlength=40 size=30 width="15" value="">&nbsp;<input type=text name='bld_med8_desc' id='bld_med8_desc'  maxlength=40 size=30 width="15" value="">&nbsp;<input type=text name='bld_med9_desc' id='bld_med9_desc'  maxlength=40 size=30 width="15" value=""></td>			
		</tr>
		<tr>			
			<td  align="right" nowrap class="label" >&nbsp;</td>
			<td colspan=3 >&nbsp;<input type=text name='bld_med10_desc' id='bld_med10_desc'  maxlength=40 size=30 width="15" value=""></td>			
		</tr>
		<tr><td colspan="4" class="label">&nbsp;</td></tr>
		<tr>			
			<td  align="right" nowrap class="label" ><fmt:message key="eIP.RecordsDocuments.label" bundle="${ip_labels}"/></td>
			<td colspan=3 >&nbsp;<input type=text name='rec_doc1_desc' id='rec_doc1_desc'  maxlength=40 size=30 width="15" value="">&nbsp;<input type=text name='rec_doc2_desc' id='rec_doc2_desc'  maxlength=40 size=30 width="15" value="">&nbsp;<input type=text name='rec_doc3_desc' id='rec_doc3_desc'  maxlength=40 size=30 width="15" value=""></td>
			
		</tr>
		<tr>			
			<td  align="right" nowrap class="label" >&nbsp;</td>
			<td colspan=3 >&nbsp;<input type=text name='rec_doc4_desc' id='rec_doc4_desc'  maxlength=40 size=30 width="15" value="">&nbsp;<input type=text name='rec_doc5_desc' id='rec_doc5_desc'  maxlength=40 size=30 width="15" value=""></td>			
		</tr>
		<tr><td colspan="4" class="label">&nbsp;</td></tr>
		<tr>
			<td  align="right" nowrap class="label" ><fmt:message key="eIP.PatientBelongings.label" bundle="${ip_labels}"/></td>
			<td colspan=3 >&nbsp;<input type=text name='pat_bel1_desc' id='pat_bel1_desc'  maxlength=40 size=30 width="15" value="">&nbsp;<input type=text name='pat_bel2_desc' id='pat_bel2_desc'  maxlength=40 size=30 width="15" value="">&nbsp;<input type=text name='pat_bel3_desc' id='pat_bel3_desc'  maxlength=40 size=30 width="15" value=""></td>			
		</tr>
		<tr>			
			<td  align="right" nowrap class="label" >&nbsp;</td>
			<td colspan=3 >&nbsp;<input type=text name='pat_bel4_desc' id='pat_bel4_desc'  maxlength=40 size=30 width="15" value="">&nbsp;<input type=text name='pat_bel5_desc' id='pat_bel5_desc'  maxlength=40 size=30 width="15" value="">&nbsp;<input type=text name='pat_bel6_desc' id='pat_bel6_desc'  maxlength=40 size=30 width="15" value=""></td>			
		</tr>
		<tr>			
			<td  align="right" nowrap class="label" >&nbsp;</td>
			<td colspan=3 >&nbsp;<input type=text name='pat_bel7_desc' id='pat_bel7_desc'  maxlength=40 size=30 width="15" value="">&nbsp;<input type=text name='pat_bel8_desc' id='pat_bel8_desc'  maxlength=40 size=30 width="15" value="">&nbsp;<input type=text name='pat_bel9_desc' id='pat_bel9_desc'  maxlength=40 size=30 width="15" value=""></td>			
		</tr>
		<tr>			
			<td  align="right" nowrap class="label" >&nbsp;</td>
			<td colspan=3 >&nbsp;<input type=text name='pat_bel10_desc' id='pat_bel10_desc'  maxlength=40 size=30 width="15" value=""></td>			
		</tr>
		<%
			// By Annadurai starts.
			if (jsp_name.equals("PatientIn"))
			{
		%>
		<tr><td colspan="4" class="label">&nbsp;</td></tr>
		<tr>			
			<td  align="right" nowrap class="label" ><fmt:message key="eIP.PorterageReceived.label" bundle="${ip_labels}"/>&nbsp;</td>
			<td><input type="checkbox" name='port_received_yn' id='port_received_yn' value="N" onClick = "assignValue();"></td>	<td  align="right" nowrap class="label" ><fmt:message key="eIP.ReceivedPartiallyFully.label" bundle="${ip_labels}"/>&nbsp;</td>
			<td>
				<select name="received" id="received">
					<option value="">&nbsp;&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;</option>
					<option value="F"><fmt:message key="eIP.ReceivedinFull.label" bundle="${ip_labels}"/></option>
					<option value="P"><fmt:message key="eIP.ReceivedPartially.label" bundle="${ip_labels}"/></option>
				</select>
			</td>			
		</tr>		
		<tr><td colspan="4" class="label">&nbsp;</td></tr>
		<tr>			
			<td  align="right" nowrap class="label" ><fmt:message key="eIP.PorterageRemarks.label" bundle="${ip_labels}"/>&nbsp;</td>
			<td colspan="3">&nbsp;<input type="text" name='port_remarks' id='port_remarks' maxlength="200" size="100"></td>			
		</tr>		
		<%
			}
			// By Annadurai End.
		%>
		<tr>
		<td >&nbsp;</td>
		<td colspan=3 align=right><input type="button" class="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onclick="close_me();">&nbsp;</td>		
		</tr>
</table>
<input type="hidden" name="jsp_name_val" id="jsp_name_val" value ="<%=jsp_name%>">
</form>
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

