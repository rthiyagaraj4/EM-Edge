<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8");  %>
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,org.json.simple.parser.JSONParser,org.json.simple.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<title><fmt:message key="eIP.PorterageDetails.label" bundle="${ip_labels}"/></title>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language ='javascript' src='../../eCommon/js/common.js'></script>	
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src="../js/TransferPatient.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
</head>
<%
	/*Added by Thamizh selvi on 8th May 2017 for ML-MMOH-CRF-0617 Start*/
	Connection con = null;
	try
	{
		con		=	ConnectionManager.getConnection(request);
		boolean isCnrmReqPatOutChngAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"IP","AUTO_CNRM_TFR_REQ_PAT_OUT_CHNG");

		JSONArray transportModeJsonArr	= new JSONArray();

		transportModeJsonArr = eIP.IPCommonBean.getTransportMode(con);
	/*End*/


   //   By Annadurai 3/5/2004 starts
   String jsp_name =  request.getParameter("function_name");
   jsp_name = (jsp_name==null) ? "" : jsp_name;
  %>
<script>
// By Annadurai 3/5/2004 starts.,
function assignValue()
{
	if (document.forms[1].port_received_yn.checked == true)
	{
		document.forms[1].port_received_yn.value	= "Y";
		parent.frames[2].document.forms[1].received.disabled	= false;
		parent.frames[2].document.forms[1].port_remarks.disabled	= false;
		parent.frames[2].document.getElementById("received_img").style.visibility			= 'visible';
	}
	else 
	{
		document.forms[1].port_received_yn.value	= "N";
		parent.frames[2].document.forms[1].received.value='';
		parent.frames[2].document.forms[1].port_remarks.value='';
		parent.frames[2].document.forms[1].received.disabled	= true;
		parent.frames[2].document.forms[1].port_remarks.disabled	= true;
		parent.frames[2].document.getElementById("received_img").style.visibility			= 'hidden';
	}
}
// By Annadurai 3/5/2004 ends.,
function selfClose()
{
	self.close();
	return 1;
}
/*function close_me()
{
	var port_vals = "";
	port_vals = 
				
	(document.forms[1].Mode_of_Tran_desc.value.length == 0 ? " " : document.forms[1].Mode_of_Tran_desc.value) + "^^" + 
	(document.forms[1].acc_per1_desc.value.length == 0? " " : document.forms[1].acc_per1_desc.value )+ "^^" +
	(document.forms[1].acc_per2_desc.value.length == 0? " " :			
	document.forms[1].acc_per2_desc.value) + "^^" +
	(document.forms[1].acc_per3_desc.value.length == 0 ? " " :
	document.forms[1].acc_per3_desc.value) + "^^" +
	(document.forms[1].acc_per4_desc.value.length == 0 ? " " :
	document.forms[1].acc_per4_desc.value) + "^^" +
	(document.forms[1].acc_per5_desc.value.length == 0 ? " " :
	document.forms[1].acc_per5_desc.value) + "^^" +
	(document.forms[1].acc_per6_desc.value.length == 0 ? " " :	
	document.forms[1].acc_per6_desc.value) + "^^" +
	(document.forms[1].acc_per7_desc.value.length == 0 ? " " :			
	document.forms[1].acc_per7_desc.value) + "^^" +

	(document.forms[1].equip1_desc.value.length == 0 ? " " :
	document.forms[1].equip1_desc.value) + "^^" +
	(document.forms[1].equip2_desc.value.length == 0 ? " " :			
	document.forms[1].equip2_desc.value) + "^^" +
	(document.forms[1].equip3_desc.value.length == 0 ? " " :
	document.forms[1].equip3_desc.value) + "^^" +
	(document.forms[1].equip4_desc.value.length == 0 ? " " :
	document.forms[1].equip4_desc.value) + "^^" +
	(document.forms[1].equip5_desc.value.length == 0 ? " " :
	document.forms[1].equip5_desc.value) + "^^" +
	(document.forms[1].equip6_desc.value.length == 0 ? " " :			
	document.forms[1].equip6_desc.value) + "^^" +
	(document.forms[1].equip7_desc.value.length == 0 ? " " : 			
	document.forms[1].equip7_desc.value) + "^^" +
				
	(document.forms[1].bld_med1_desc.value.length == 0 ? " " : 
	document.forms[1].bld_med1_desc.value) + "^^" +
	(document.forms[1].bld_med2_desc.value.length == 0 ? " " :  			
	document.forms[1].bld_med2_desc.value) + "^^" +
	(document.forms[1].bld_med3_desc.value.length == 0 ? " " : 			
	document.forms[1].bld_med3_desc.value) + "^^" +
	(document.forms[1].bld_med4_desc.value.length == 0 ? " " : 			
	document.forms[1].bld_med4_desc.value) + "^^" +
	(document.forms[1].bld_med5_desc.value.length == 0 ? " " :  			
	document.forms[1].bld_med5_desc.value) + "^^" +
	(document.forms[1].bld_med6_desc.value.length == 0 ? " " : 			
	document.forms[1].bld_med6_desc.value) + "^^" +
	(document.forms[1].bld_med7_desc.value.length == 0 ? " " :  			
	document.forms[1].bld_med7_desc.value) + "^^" +
	(document.forms[1].bld_med8_desc.value.length == 0 ? " " :  			
	document.forms[1].bld_med8_desc.value) + "^^" +
	(document.forms[1].bld_med9_desc.value.length == 0 ? " " : 			
	document.forms[1].bld_med9_desc.value) + "^^" +
	(document.forms[1].bld_med10_desc.value.length == 0 ? " " :  			
	document.forms[1].bld_med10_desc.value) + "^^" +
				
	(document.forms[1].rec_doc1_desc.value.length == 0 ? " " :
	document.forms[1].rec_doc1_desc.value) + "^^" +
	(document.forms[1].rec_doc2_desc.value.length == 0 ? " " : 
	document.forms[1].rec_doc2_desc.value) + "^^" +
	(document.forms[1].rec_doc3_desc.value.length == 0 ? " " : 			
	document.forms[1].rec_doc3_desc.value) + "^^" +
	(document.forms[1].rec_doc4_desc.value.length == 0 ? " " : 			
	document.forms[1].rec_doc4_desc.value) + "^^" +
	(document.forms[1].rec_doc5_desc.value.length == 0 ? " " : 			
	document.forms[1].rec_doc5_desc.value) + "^^" +
				
	(document.forms[1].pat_bel1_desc.value.length == 0 ? " " :
	document.forms[1].pat_bel1_desc.value) + "^^" +
	(document.forms[1].pat_bel2_desc.value.length == 0 ? " " : 			
	document.forms[1].pat_bel2_desc.value) + "^^" +
	(document.forms[1].pat_bel3_desc.value.length == 0 ? " " : 			
	document.forms[1].pat_bel3_desc.value) + "^^" +
	(document.forms[1].pat_bel4_desc.value.length == 0 ? " " : 			
	document.forms[1].pat_bel4_desc.value) + "^^" +
	(document.forms[1].pat_bel5_desc.value.length == 0 ? " " : 			
	document.forms[1].pat_bel5_desc.value) + "^^" +
	(document.forms[1].pat_bel6_desc.value.length == 0 ? " " : 			
	document.forms[1].pat_bel6_desc.value) + "^^" +
	(document.forms[1].pat_bel7_desc.value.length == 0 ? " " : 			
	document.forms[1].pat_bel7_desc.value) + "^^" +
	(document.forms[1].pat_bel8_desc.value.length == 0 ? " " :
	document.forms[1].pat_bel8_desc.value) + "^^" +
	(document.forms[1].pat_bel9_desc.value.length == 0 ? " " :
	document.forms[1].pat_bel9_desc.value) + "^^" +
	(document.forms[1].pat_bel10_desc.value.length == 0 ? " " :
	document.forms[1].pat_bel10_desc.value)+ "^^" ;
				// By Annadurai 3/5/2004 starts.,
				if (document.forms[1].jsp_name_val.value == "TransferPatientIn")
				{	
					port_vals = port_vals +
					(document.forms[1].port_received_yn.value.length == 0 ? " " :document.forms[1].port_received_yn.value)+ "^^" +
					(document.forms[1].received.value.length == 0 ? " " :
					document.forms[1].received.value)+ "^^" +
					(document.forms[1].port_remarks.value.length == 0 ? " " :
					document.forms[1].port_remarks.value);
				}
				// By Annadurai 3/5/2004 ends.,
		document.forms[0].porterage_hid.value=port_vals;
}*/
function populateDetails()
{
	var port_vals=document.forms[0].porterage_hid.value;

	if(port_vals == null || port_vals =='null')
	{
		port_vals='';
	}

	var arr_port_vals=port_vals.split("^^");

	if(arr_port_vals[0]){
		document.forms[1].Mode_of_Tran_desc.value		= arr_port_vals[0];
		/*Added by Thamizh selvi on 16th May 2017 for ML-MMOH-CRF-0617 Start*/
		if(document.forms[1].Mode_of_Tran_desc.value==""){
			document.forms[1].Mode_of_Tran_desc.value	= "";//To display "select" in the dropdown
		}/*End*/
	}
	
	/*Added by Thamizh selvi on 16th May 2017 for ML-MMOH-CRF-0617 Start*/
	var isCnrmReqPatOutChngAppl = document.forms[0].isCnrmReqPatOutChngAppl.value;
	var accompPersonVal = document.forms[0].accomp_person.value;

	if(accompPersonVal == null || accompPersonVal =='null')
		accompPersonVal = '';

	var arr_accomp_persn = accompPersonVal.split("^^");

	if(isCnrmReqPatOutChngAppl == "true")
	{
		if(arr_accomp_persn[0])
			document.forms[1].acc_per1_desc_disp.value		= arr_accomp_persn[0];
		if(arr_accomp_persn[1])
			document.forms[1].acc_per2_desc_disp.value		= arr_accomp_persn[1];
		if(arr_accomp_persn[2])
			document.forms[1].acc_per3_desc_disp.value		= arr_accomp_persn[2];
		if(arr_accomp_persn[3])
			document.forms[1].acc_per4_desc_disp.value		= arr_accomp_persn[3];
		if(arr_accomp_persn[4])
			document.forms[1].acc_per5_desc_disp.value		= arr_accomp_persn[4];
		if(arr_accomp_persn[5])
			document.forms[1].acc_per6_desc_disp.value		= arr_accomp_persn[5];
	}
	else
	{
		if(arr_port_vals[1])
			document.forms[1].acc_per1_desc.value		= arr_port_vals[1];
		if(arr_port_vals[2])
			document.forms[1].acc_per2_desc.value		= arr_port_vals[2];
		if(arr_port_vals[3])
			document.forms[1].acc_per3_desc.value		= arr_port_vals[3];
		if(arr_port_vals[4])
			document.forms[1].acc_per4_desc.value		= arr_port_vals[4];
		if(arr_port_vals[5])
			document.forms[1].acc_per5_desc.value		= arr_port_vals[5];
		if(arr_port_vals[6])
			document.forms[1].acc_per6_desc.value		= arr_port_vals[6];
	}/*End*/
	
	if(arr_port_vals[7])
		document.forms[1].acc_per7_desc.value		= arr_port_vals[7];
	
	if(arr_port_vals[8])
		document.forms[1].equip1_desc.value		= arr_port_vals[8];
	if(arr_port_vals[9])
		document.forms[1].equip2_desc.value		= arr_port_vals[9];
	if(arr_port_vals[10])
		document.forms[1].equip3_desc.value		= arr_port_vals[10];
	if(arr_port_vals[11])
		document.forms[1].equip4_desc.value		= arr_port_vals[11];
	if(arr_port_vals[12])
		document.forms[1].equip5_desc.value		= arr_port_vals[12];
	if(arr_port_vals[13])
		document.forms[1].equip6_desc.value		= arr_port_vals[13];
	if(arr_port_vals[14])
		document.forms[1].equip7_desc.value		= arr_port_vals[14];

	if(arr_port_vals[15])
		document.forms[1].bld_med1_desc.value		= arr_port_vals[15];
	if(arr_port_vals[16])
		document.forms[1].bld_med2_desc.value		= arr_port_vals[16];
	if(arr_port_vals[17])
		document.forms[1].bld_med3_desc.value		= arr_port_vals[17];
	if(arr_port_vals[18])
		document.forms[1].bld_med4_desc.value		= arr_port_vals[18];
	if(arr_port_vals[19])
		document.forms[1].bld_med5_desc.value		= arr_port_vals[19];
	if(arr_port_vals[20])
		document.forms[1].bld_med6_desc.value		= arr_port_vals[20];
	if(arr_port_vals[21])
		document.forms[1].bld_med7_desc.value		= arr_port_vals[21];
	if(arr_port_vals[22])
		document.forms[1].bld_med8_desc.value		= arr_port_vals[22];
	if(arr_port_vals[23])
		document.forms[1].bld_med9_desc.value		= arr_port_vals[23];
	if(arr_port_vals[24])
		document.forms[1].bld_med10_desc.value		= arr_port_vals[24];


	if(arr_port_vals[25])
		document.forms[1].rec_doc1_desc.value		= arr_port_vals[25];
	if(arr_port_vals[26])
		document.forms[1].rec_doc2_desc.value		= arr_port_vals[26];
	if(arr_port_vals[27])
		document.forms[1].rec_doc3_desc.value		= arr_port_vals[27];
	if(arr_port_vals[28])
		document.forms[1].rec_doc4_desc.value		= arr_port_vals[28];
	if(arr_port_vals[29])
		document.forms[1].rec_doc5_desc.value		= arr_port_vals[29];

	if(arr_port_vals[30])
		document.forms[1].pat_bel1_desc.value		= arr_port_vals[30];
	if(arr_port_vals[31])
		document.forms[1].pat_bel2_desc.value		= arr_port_vals[31];
	if(arr_port_vals[32])
		document.forms[1].pat_bel3_desc.value		= arr_port_vals[32];
	if(arr_port_vals[33])
		document.forms[1].pat_bel4_desc.value		= arr_port_vals[33];
	if(arr_port_vals[34])
		document.forms[1].pat_bel5_desc.value		= arr_port_vals[34];
	if(arr_port_vals[35])
		document.forms[1].pat_bel6_desc.value		= arr_port_vals[35];
	if(arr_port_vals[36])
		document.forms[1].pat_bel7_desc.value		= arr_port_vals[36];
	if(arr_port_vals[37])
		document.forms[1].pat_bel8_desc.value		= arr_port_vals[37];
	if(arr_port_vals[38])
		document.forms[1].pat_bel9_desc.value		= arr_port_vals[38];
	if(arr_port_vals[39])
		document.forms[1].pat_bel10_desc.value		= arr_port_vals[39];
	// By Annadurai 3/5/2004 start.,

	if (document.forms[1].jsp_name_val.value == "TransferPatientIn")
	{
		if(arr_port_vals[40]) 
		{
			document.forms[1].port_received_yn.value	= arr_port_vals[40];
			if (arr_port_vals[40] == "Y")
				document.forms[1].port_received_yn.checked = true;
			else
				document.forms[1].port_received_yn.checked = false;
		}
		if(arr_port_vals[41]) 
			document.forms[1].received.value			= arr_port_vals[41];
		if(arr_port_vals[42]) 
			document.forms[1].port_remarks.value		= arr_port_vals[42];
		}
	// By Annadurai 3/5/2004 end.,
}
// By Vinay 6/29/2004
/*
function tab_clic(objName)
{
	if (objName == 'Patient_Details' || objName == 'Patient_Details1')
    {
		document.getElementById("patientdetailtab").scrollIntoView();
		document.forms[1].Mode_of_Tran_desc.focus();

    }
	else if (objName == 'Medical_details' || objName == 'Medical_details1')
    {
		document.getElementById("medicaldetailtab").scrollIntoView();
		document.forms[1].equip1_desc.focus();
    }
}
var isShift = false;
function setShift(){
		var keyCode=window.event.keyCode;
		if(keyCode == 16) isShift=true;
		
	}
*/


</script>

<body onLoad="populateDetails();" onMouseDown='CodeArrest()' onKeyDown='lockKey();'>
<form name="Porteragedetailstab1" id="Porteragedetailstab1" method="post"action='' target='messageFrame'> 

<!--  By Vinay patientdetail tab event 6/29/2004 -->
	<!-- <a name="patientdetailtab" tabindex='0'></a>  -->
	<div id ="Patient" style = 'display:none'>
	<table width='100%' cellpadding='2' cellspacing='0' BORDER='0' >
	<tr>
	<td width='100%' class='BODYCOLORFILLED'>
		<!-- <a align ='left' href="javascript:tab_click('Occupancy_Details')" ><img  src="../../eIP/images/Occupancy Details_click.gif" border=0></a>
		<a align='left' href="javascript:tab_click('other_details')" tabindex='-1'><img  src="../../eIP/images/Other Details_click.gif" border=0></a>
		<a align='left' href="javascript:tab_click('porterage_details')" tabindex='-1'><img  src="../../eIP/images/Porterage Details.gif" border=0></a> -->

		<ul id="tablist" class="tablist">
			<li class="tablistitem" title="Occupancy Details">
				<a onclick="expandCollapse('Occupancy_Details')"  class="tabA" id="Occupancy_Details" ><span class="tabAspan" id=""><fmt:message key="eIP.OccupancyDetails.label" bundle="${ip_labels}"/></span>
				</a>
			</li>
			<li class="tablistitem" title="Other Details">
				<a onclick="expandCollapse('other_details')" class="tabA" id="other_details" ><span class="tabAspan" id=""><fmt:message key="Common.otherDetails.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			<li class="tablistitem" title="Porterage Details">
				<a onclick="expandCollapse('porterage_details')" class=" tabClicked" id="porterage_details" ><span class="tabSpanclicked" id=""><fmt:message key="eIP.PorterageDetails.label" bundle="${ip_labels}"/></span>
				</a>
			</li>
		</ul>
	</td>
	<td width='20%' class='BODYCOLORFILLED'></td></tr></table> 
	<table width='100%' cellpadding='0' cellspacing='0' BORDER='0' >
	<tr>
	<td width='100%' class='BODYCOLORFILLED'>
	
	<!-- <a align ='left' href="javascript:tab_clic('Patient_Details')" ><img  src="../../eIP/images/Patient Details.gif" border=0></a>
	<a align='left' href="javascript:tab_clic('Medical_details')" tabindex='-1'><img  src="../../eIP/images/Medical Details_click.gif" border=0></a> -->
	
	<ul id="tablist" class="tablist">
		<li class="tablistitem" title="Patient Details">
			<a onclick="expandCollapse('Patient_Details')"  class="tabClicked " id="" ><span class="tabSpanclicked" id=""><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></span>
			</a>
		</li>
		<li class="tablistitem" title="Medical details">
			<a onclick="expandCollapse('Medical_details')" class="tabA" id="" ><span class="tabAspan" id=""><fmt:message key="eIP.MedicalDetails.label" bundle="${ip_labels}"/></span>
			</a>
		</li>
	</ul>
	
	</td><td width='20%' class='BODYCOLORFILLED'></td></tr></table> 
<!--  End of patientdetail tab event 6/29/2004 -->
	<table border=0 width="100%" cellpadding='2' cellspacing=0>
	<tr><td colspan=6 class='columnheader' width="100%" ><fmt:message key="Common.ModeOfTransport.label" bundle="${common_labels}"/></td></tr>
	
	<!--Added by Thamizh selvi on 8th May 2017 for ML-MMOH-CRF-0617 Start-->
	<% if(isCnrmReqPatOutChngAppl){ %>
		<tr>
			<td colspan=3 class='fields'>
				<select name='Mode_of_Tran_desc' id='Mode_of_Tran_desc'  <%if(jsp_name.equals("TransferPatientIn")){%>disabled <%}%>>
					<option value='' ><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
					<%
						for(int i = 0; i < transportModeJsonArr.size(); i++)
						{
							JSONObject json = (JSONObject)transportModeJsonArr.get(i);
							String transportMode	= (String) json.get("transportMode");
							String transportDesc	= (String) json.get("transportDesc");
							
							out.println("<option value='"+transportMode+"'>"+transportDesc+"</option>");
						}
						
					%>
				</select>
			</td>
			<td></td>
		</tr>	
	<% }else{ %>
		<tr>
			<td colspan=3 class='fields'>
			<input type='text' <%if(jsp_name.equals("TransferPatientIn")){%>readOnly <%}%> name='Mode_of_Tran_desc'  maxlength=40 size=25   ></td>
			<td></td>
		</tr>		
	<% } %> <!--End-->
	
	<tr>
		<td colspan=6 width="100%" class='columnheader' ><fmt:message key="eIP.AccompanyingPersons.label" bundle="${ip_labels}"/></td>
	</tr>
		<tr ><td colspan="4" class="label" ></td></tr>
	
	<!--Added by Thamizh selvi on 8th May 2017 for ML-MMOH-CRF-0617 Start-->
	<% if(isCnrmReqPatOutChngAppl){ %>
		<tr>			
			<td colspan=6 class='fields'>
				<input type='hidden' name='acc_per1_desc' id='acc_per1_desc' value="">
				<input type=text name='acc_per1_desc_disp' id='acc_per1_desc_disp'  <%if(jsp_name.equals("TransferPatientIn")){%>readOnly <%}else{%> onblur='GetLookupBlur(acc_per1_desc_disp,acc_per1_desc)'<%}%> maxlength=60 size=25 width="15" value="">
				<input type='button' class='button' name='user_lookup' id='user_lookup' <%if(jsp_name.equals("TransferPatientIn")){%>disabled <%}%> value='?' onClick='GetLookup(acc_per1_desc_disp,acc_per1_desc)'>

				<input type='hidden' name='acc_per2_desc' id='acc_per2_desc' value="">
				<input type=text name='acc_per2_desc_disp' id='acc_per2_desc_disp'  <%if(jsp_name.equals("TransferPatientIn")){%>readOnly <%}else{%> onblur='GetLookupBlur(acc_per2_desc_disp,acc_per2_desc)'<%}%> maxlength=60 size=25 width="15" value="" >  
				<input type='button' class='button' name='user_lookup' id='user_lookup' <%if(jsp_name.equals("TransferPatientIn")){%>disabled <%}%> value='?' onClick='GetLookup(acc_per2_desc_disp,acc_per2_desc)'> 
				
				<input type='hidden' name='acc_per3_desc' id='acc_per3_desc' value="">
				<input type=text name='acc_per3_desc_disp' id='acc_per3_desc_disp'  <%if(jsp_name.equals("TransferPatientIn")){%>readOnly <%}else{%> onblur='GetLookupBlur(acc_per3_desc_disp,acc_per3_desc)' <%}%> maxlength=60 size=25 width="15" value="">
				<input type='button' class='button' name='user_lookup' id='user_lookup' <%if(jsp_name.equals("TransferPatientIn")){%>disabled <%}%> value='?' onClick='GetLookup(acc_per3_desc_disp,acc_per3_desc)'> 
			</td>
			<td></td>	
		</tr>
		<tr>			
			<td colspan=6 class='fields'>
				<input type='hidden' name='acc_per4_desc' id='acc_per4_desc' value="">
				<input type=text name='acc_per4_desc_disp' id='acc_per4_desc_disp'  <%if(jsp_name.equals("TransferPatientIn")){%>readOnly <%}else{%> onblur='GetLookupBlur(acc_per4_desc_disp,acc_per4_desc)'<%}%> maxlength=60 size=25 width="15" value="">
				<input type='button' class='button' name='user_lookup' id='user_lookup' <%if(jsp_name.equals("TransferPatientIn")){%>disabled <%}%> value='?' onClick='GetLookup(acc_per4_desc_disp,acc_per4_desc)'>
				
				<input type='hidden' name='acc_per5_desc' id='acc_per5_desc' value="">
				<input type=text name='acc_per5_desc_disp' id='acc_per5_desc_disp'  <%if(jsp_name.equals("TransferPatientIn")){%>readOnly <%}else{%> onblur='GetLookupBlur(acc_per5_desc_disp,acc_per5_desc)'<%}%> maxlength=60 size=25 width="15" value="">
				<input type='button' class='button' name='user_lookup' id='user_lookup' <%if(jsp_name.equals("TransferPatientIn")){%>disabled <%}%> value='?' onClick='GetLookup(acc_per5_desc_disp,acc_per5_desc)'> 

				<input type='hidden' name='acc_per6_desc' id='acc_per6_desc' value="">
				<input type=text name='acc_per6_desc_disp' id='acc_per6_desc_disp'  <%if(jsp_name.equals("TransferPatientIn")){%>readOnly <%}else{%> onblur='GetLookupBlur(acc_per6_desc_disp,acc_per6_desc)'<%}%> maxlength=60 size=25 width="15" value="">
				<input type='button' class='button' name='user_lookup' id='user_lookup' <%if(jsp_name.equals("TransferPatientIn")){%>disabled <%}%> value='?' onClick='GetLookup(acc_per6_desc_disp,acc_per6_desc)'> 
			</td>
			<td></td>
		</tr>
		<tr>			
			<td colspan=3 class='fields'><input type=text name='acc_per7_desc' id='acc_per7_desc'  <%if(jsp_name.equals("TransferPatientIn")){%>readOnly <%}%> maxlength=60 size=25 width="15" value=""></td>
			<td></td>
		</tr>
	<% }else{ %>
		<tr>			
		<td colspan=3 class='fields'>
			<input type=text name='acc_per1_desc' id='acc_per1_desc'  <%if(jsp_name.equals("TransferPatientIn")){%>readOnly <%}%> maxlength=40 size=25 width="15" value="">&nbsp; <input type=text name='acc_per2_desc' id='acc_per2_desc'  <%if(jsp_name.equals("TransferPatientIn")){%>readOnly <%}%> maxlength=40 size=25 width="15" value="" >&nbsp; <input type=text name='acc_per3_desc' id='acc_per3_desc'  <%if(jsp_name.equals("TransferPatientIn")){%>readOnly <%}%> maxlength=40 size=25 width="15" value="">
		</td>
		<td></td>	
		</tr>
		<tr>			
			<td colspan=3 class='fields'>
				<input type=text name='acc_per4_desc' id='acc_per4_desc'  <%if(jsp_name.equals("TransferPatientIn")){%>readOnly <%}%> maxlength=40 size=25 width="15" value="">&nbsp; <input type=text name='acc_per5_desc' id='acc_per5_desc'  <%if(jsp_name.equals("TransferPatientIn")){%>readOnly <%}%> maxlength=40 size=25 width="15" value="">&nbsp; <input type=text name='acc_per6_desc' id='acc_per6_desc'  <%if(jsp_name.equals("TransferPatientIn")){%>readOnly <%}%> maxlength=40 size=25 width="15" value="">
			</td>
			<td></td>
		</tr>
		<tr>			
			<td colspan=3 class='fields'><input type=text name='acc_per7_desc' id='acc_per7_desc'  <%if(jsp_name.equals("TransferPatientIn")){%>readOnly <%}%> maxlength=40 size=25 width="15" value=""></td>
			<td></td>
		</tr>
	<% } %><!--End-->
	
	<tr>
		<td colspan=6 class='columnheader' width="100%" ><fmt:message key="eIP.PatientBelongings.label" bundle="${ip_labels}"/></td>
	</tr>
		<tr>
			<td colspan=3 class='fields'><input type=text name='pat_bel1_desc' id='pat_bel1_desc'  <%if(jsp_name.equals("TransferPatientIn"))
	{%>readOnly <%}%> maxlength=40 size=25 width="15" value="" >&nbsp;<input type=text name='pat_bel2_desc' id='pat_bel2_desc'  <%if(jsp_name.equals("TransferPatientIn"))
	{%>readOnly <%}%> maxlength=40 size=25 width="15" value="">&nbsp;<input type=text name='pat_bel3_desc' id='pat_bel3_desc' <%if(jsp_name.equals("TransferPatientIn"))
	{%>readOnly <%}%>  maxlength=40 size=25 width="15" value=""></td>
			<td></td>	
		</tr>
		<tr>			
			<td colspan=3 class='fields'><input type=text name='pat_bel4_desc' id='pat_bel4_desc'  <%if(jsp_name.equals("TransferPatientIn"))
	{%>readOnly <%}%> maxlength=40 size=25 width="15" value="">&nbsp;<input type=text name='pat_bel5_desc' id='pat_bel5_desc' <%if(jsp_name.equals("TransferPatientIn"))
	{%>readOnly <%}%> maxlength=40 size=25 width="15" value="">&nbsp;<input type=text name='pat_bel6_desc' id='pat_bel6_desc'  <%if(jsp_name.equals("TransferPatientIn"))
	{%>readOnly <%}%> maxlength=40 size=25 width="15" value=""></td>	<td></td>
		</tr>
		<tr>			
	<td colspan=3 class='fields'><input type=text name='pat_bel7_desc' id='pat_bel7_desc'  <%if(jsp_name.equals("TransferPatientIn"))
	{%>readOnly <%}%> maxlength=40 size=25 width="15" value="">&nbsp;<input type=text name='pat_bel8_desc' id='pat_bel8_desc'  <%if(jsp_name.equals("TransferPatientIn"))
	{%>readOnly <%}%> maxlength=40 size=25 width="15" value="">&nbsp;<input type=text name='pat_bel9_desc' id='pat_bel9_desc' <%if(jsp_name.equals("TransferPatientIn"))
	{%>readOnly <%}%>  maxlength=40 size=25 width="15" value=""></td>	<td></td>	
		</tr>
		<tr>			
			<td colspan=3 class='fields'><input type=text name='pat_bel10_desc' id='pat_bel10_desc'  <%if(jsp_name.equals("TransferPatientIn"))
	{%>readOnly <%}%> maxlength=40 size=25 width="15" value="" ></td>	
			<td></td>
		</tr>
		<tr ><td colspan="4" class="label" ></td></tr>
	<!--<tr>
	
	<td colspan=3></td>	
	<td align='right'><input type="button" class="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>"  onclick="submit_Form();"><input type="button" class="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" 
	onclick="cancel();" onblur="tab_click('porterage_details')"></td>
	</tr> -->
    </table>
	</div>
	
	<!--  By Vinay medicaldetail tab event 6/29/2004 -->
	<!-- <a name="medicaldetailtab" tabindex='0'></a>  -->
	<div id ="Medical" style = 'display:none'>
		<table width='100%' cellpadding='0' cellspacing='0' BORDER='0' width='100%'>
	<tr>
	<td width='100%' class='BODYCOLORFILLED' >
    <!-- 	
	<a align ='left' href="javascript:tab_click('Occupancy_Details')"><img  src="../../eIP/images/Occupancy Details_click.gif" border=0></a>
	<a align='left' href="javascript:tab_click('other_details')" tabindex='-1'><img  src="../../eIP/images/Other Details_click.gif" border=0></a>
	<a align='left' href="javascript:tab_click('porterage_details')" tabindex='-1'><img  src="../../eIP/images/Porterage Details.gif" border=0></a> -->
	
	<ul id="tablist" class="tablist">
		<li class="tablistitem" title="Occupancy Details">
			<a onclick="expandCollapse('Occupancy_Details')"  class="tabA" id="Occupancy_Details" ><span class="tabAspan" id="Occu_tabspan"><fmt:message key="eIP.OccupancyDetails.label" bundle="${ip_labels}"/></span>
			</a>
		</li>
		<li class="tablistitem" title="Other Details">
			<a onclick="expandCollapse('other_details')" class="tabA" id="other_details" ><span class="tabAspan" id="othe_tabspan"><fmt:message key="Common.otherDetails.label" bundle="${common_labels}"/></span>
			</a>
		</li>
		<li class="tablistitem" title="Porterage Details">
			<a onclick="expandCollapse('porterage_details')" class="tabClicked" id="porterage_details" ><span class="tabSpanclicked" id="port_tabspan"><fmt:message key="eIP.PorterageDetails.label" bundle="${ip_labels}"/></span>
			</a>
		</li>
	</ul>

	</td><td width='20%' class='BODYCOLORFILLED' ></td></tr></table> 
	<table width='100%' cellpadding='0' cellspacing='0' BORDER='0' width='100%'>
	<tr>
	<td width='100%' class='BODYCOLORFILLED'>
	
<!-- 	<a align ='left' href="javascript:tab_clic('Patient_Details')"><img  src="../../eIP/images/Patient Details_click.gif" border=0></a>
	<a align='left' href="javascript:tab_clic('Medical_details')" tabindex='-1'><img  src="../../eIP/images/Medical Details.gif" border=0></a> -->
	
	<ul id="tablist" class="tablist">
		<li class="tablistitem" title="Patient Details">
			<a onclick="expandCollapse('Patient_Details')"  class="tabA" id="Patient_Details1" ><span class="tabAspan" id="Pat_tabspan"><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></span>
			</a>
		</li>
		<li class="tablistitem" title="Medical details">
			<a onclick="expandCollapse('Medical_details')" class="tabClicked" id="Medical_details1" ><span class="tabSpanclicked" id="Med_tabspan"><fmt:message key="eIP.MedicalDetails.label" bundle="${ip_labels}"/></span>
			</a>
		</li>
	</ul>
	
	
	</td><td width='20%' class='BODYCOLORFILLED' ></td></tr></table>
	<jsp:include page="PorterageDetailsTab2.jsp" ><jsp:param name="flush" value="true" />
	<jsp:param name="function_name" value="<%=jsp_name%>" />
	</jsp:include>

<!--  End of medicaldetail event 6/29/2004 -->
<input type="hidden" name="jsp_name_val" id="jsp_name_val" value ="<%=jsp_name%>">
<input type="hidden" name="isCnrmReqPatOutChngAppl" id="isCnrmReqPatOutChngAppl" value="<%=isCnrmReqPatOutChngAppl%>"><!--Added by Thamizh selvi on 16th May 2017 for ML-MMOH-CRF-0617-->

</div>
<%
}catch(Exception e)
{
	e.printStackTrace();
}
finally 
{
	ConnectionManager.returnConnection(con,request);
}
%>

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

