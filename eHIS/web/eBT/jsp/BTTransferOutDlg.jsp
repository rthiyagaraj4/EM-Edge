<!DOCTYPE html>
<!--Created by Ashwini on 26-Feb-2017 for ML-MMOH-CRF-0589-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*,org.json.simple.*"  contentType="text/html; charset=UTF-8"%>
<html>
<%	request.setCharacterEncoding("UTF-8");	%>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>


<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<head>

<Title><fmt:message key="eBT.ExternalTransfer.label" bundle="${bt_labels}"/></title>

<script type='text/javascript' src='../../eCommon/js/common.js'></script>
<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<Script Language="JavaScript" src="../../eBT/js/BTMessage.js"></Script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<Script Language="JavaScript" src="../../eBT/js/BTMaster.js"></Script>
<Script Language="JavaScript" src="../../eBT/js/BTTransaction.js"></Script>

<script language='javascript'>

function closeWindow()
{
	parent.window.close();
}

function transferDlgSubmit()
{
	try
	{
		if(validateNull()==false) return;
		var objFrm=document.forms[0];
		//Code changes made for 73815 - Regression-BT-3T-Blood Unit Consumption-Transfer by Sethu on 31/08/2020
		// Function var data = funBTXMLFormApplyOut(objFrm); commented due to the impact of code changes made for MMS-CRF-0157 and 0170
		//var data = funBTXMLFormApply(objFrm);
		var data = funBTXMLFormApplyOut(objFrm);
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		
		xmlDoc.loadXML(data);

		xmlHttp.open("POST", "../../servlet/eBT.BTTransferServlet", false);

		xmlHttp.send(xmlDoc);

		var resTxt=xmlHttp.responseText;
	
		parent.window.returnValue=resTxt;
			
		parent.window.close();
	}
	catch(e)
	{
		e.printStackTrace();
		alert('exception'+e);
	}		
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	 

<style>

.wrapper {
    text-align: center;
}

</style>

</head>

 <body onLoad="checkTransDateTime(document.forms[0].transfer_date_time,document.forms[0].ISSUED_DATE,document.forms[0].RESERVED_DATE,document.forms[0].SYDATE,document.forms[0].EXPIRY_DATE);">
    <form name='TransferOutForm' id='TransferOutForm' method='post' action='' target='messageFrame'> 

   	 <%
		String login_user;
		String strFid = "";
		Connection con = null;
		Properties p = null;
		HttpSession httpSession = request.getSession(false);
		p = (Properties)httpSession.getValue("jdbc"); 
		strFid = ""+httpSession.getAttribute("facility_id");
		login_user = p.getProperty("login_user");
		String locale = (String)session.getAttribute("LOCALE");
		locale = (locale == null || locale.equals(""))?"en":locale;
		java.util.Locale loc = new java.util.Locale(locale);
		java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);
		String Facility_Id = (String) session.getValue("facility_id");

		String strUnitNo;
		String strSpecimenNo;
		String strProductCode;
		String strFacilityId;
		String strPatientId;
		String strTransferVol;
		String strTransfusedUnits;
		String strLocationCode;
		String strRowId;
		String strIssuedDate;
		String strReservedDate;
		String strSysDate;
		String strExpiryDate="";
		String loginUserName="";

		strUnitNo			= request.getParameter("UNIT_NO");
		strSpecimenNo		= request.getParameter("SPECIMEN_NO");
		strProductCode		= request.getParameter("PRODUCT_CODE");
		strFacilityId		= request.getParameter("OPERATING_FACILITY_ID");
		strPatientId		= request.getParameter("PATIENT_ID");
		strTransferVol		= request.getParameter("CURRENT_VOLUME");
		strLocationCode		= request.getParameter("STORAGE_LOC_CODE");
		strRowId			= request.getParameter("ROW_ID");
		strTransfusedUnits	= request.getParameter("VOLUME_UNITS");
		strIssuedDate		= com.ehis.util.DateUtils.convertDate(request.getParameter("ISSUED_DATE"),"DMYHM","en",locale);
		strReservedDate		= com.ehis.util.DateUtils.convertDate(request.getParameter("RESERVED_DATE"),"DMYHM","en",locale);
		strExpiryDate		= com.ehis.util.DateUtils.convertDate(request.getParameter("EXPIRY_DATE"),"DMYHM","en",locale);
		strSysDate			= com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);

try
{
	con = ConnectionManager.getConnection(request);

	JSONArray TransferToJsonArr = new JSONArray();
	TransferToJsonArr = eBT.BTCommonBean.getTransferToReferral(con, locale);

	JSONObject jsonValue = eBT.BTCommonBean.getLoginUser(con, login_user);
	loginUserName = (String) jsonValue.get("loginUserName");

	JSONArray TransferReasonJsonArr = new JSONArray();
	TransferReasonJsonArr = eBT.BTCommonBean.getTransferReason(con, locale);
%>
			
<table width='100%' cellpadding='0' cellspacing='0' border='0'>

<tr>
	<td colspan='2' class='label'>&nbsp;</td>
</tr> 

<tr>
	<td class='label' align='left'><fmt:message key="Common.Transfer.label" bundle="${common_labels}"/> <fmt:message key="Common.to.label" bundle="${common_labels}"/></td>

	<td class='querydata'>
		&nbsp;&nbsp;<select name="transfer_to" id="transfer_to">
		<option value="">----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
		<%
			for(int i = 0 ; i < TransferToJsonArr.size() ; i++) 
			{
				JSONObject json	= (JSONObject)TransferToJsonArr.get(i);
				String referral_code  = (String) json.get("referral_code");;
				String referral_desc  = (String) json.get("referral_desc");;
				out.println("<option value='"+referral_code+ "'>"+referral_desc+"</option>");	
			}		
		%>
		</select>
		<img src='../../eCommon/images/mandatory.gif' align='center'></img>
	</td>
</tr>

<tr>
	<td colspan='2' class='label'>&nbsp;</td>
</tr> 

<tr>
	<td class='label' align='left'><fmt:message key="eBT.TransferBy.label" bundle="${bt_labels}"/></td>

	<td class='label' align='left'>
		<input type='text' name='transfer_by' id='transfer_by' maxlength='30' size='25' value= "<%=loginUserName%>" RECORD_TYPE='S' disabled>
		<input type='button' class='Button' value='?' onClick="funBTCheckDetail1('4')" name='bs' id='bs'>
		<img src='..\..\eCommon/images/mandatory.gif'></img>
	</td>
</tr>

<tr>
	<td colspan='2' class='label'>&nbsp;</td>
</tr> 

<tr>
	<td class='label' align='left'><fmt:message key="Common.Transfer.label" bundle="${common_labels}"/> <fmt:message key="Common.Date/Time.label" bundle="${common_labels}"/></td>

	<td class='label' align='left'>
		<input type='text' name='transfer_date_time' id='transfer_date_time' maxlength='19' size='19' value= "<%=strSysDate%>" RECORD_TYPE='S' Onblur="if(validDateObj(this,'DMYHM',localeName)){checkTransDateTime(this,document.forms[0].ISSUED_DATE,document.forms[0].RESERVED_DATE,document.forms[0].SYDATE,document.forms[0].EXPIRY_DATE);}">      
		<img type='image' src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('transfer_date_time','dd/mm/y','hh:mm:ss');"></img>&nbsp;
		<img src='..\..\eCommon/images/mandatory.gif'></img>
	</td>
</tr> 

<tr>
	<td colspan='2' class='label'>&nbsp;</td>
</tr> 

<tr>
	<td class='label' align='left'><fmt:message key="Common.Transfer.label" bundle="${common_labels}"/> <fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>

	<td class='querydata'>
		&nbsp;&nbsp;<select name="transfer_reason" id="transfer_reason">
		<option value="">----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
		<%
			for(int i = 0 ; i < TransferReasonJsonArr.size() ; i++) 
			{
				JSONObject json	= (JSONObject)TransferReasonJsonArr.get(i);
				String reason_code  = (String) json.get("reason_code");;
				String reason_desc  = (String) json.get("reason_desc");;
				out.println("<option value='"+reason_code+ "'>"+reason_desc+"</option>");	
			}		
		%>
		</select>
		<img src='../../eCommon/images/mandatory.gif' align='center'></img>
	</td>
</tr>

<tr>
	<td colspan='2' class='label'>&nbsp;</td>
</tr>

<tr>
	<td class='label' align='left'><fmt:message key="Common.Transfer.label" bundle="${common_labels}"/> <fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>

	<td colspan='2' class='label' align='left'>
	 <textarea NAME="TRANSFER_REMARKS" ROWS="5" COLS="80" maxlength="2000" onkeyup='return imposeMaxLength(this);' RECORD_TYPE='S'></textarea>
	</td>
</tr>

<tr>
	<td colspan='2' class='label'>&nbsp;</td>
</tr>

<tr>
	<td colspan='2' class='label'>&nbsp;</td>
</tr>

<tr>
	<td colspan='2' class ='label' align='center'>
		<div class="wrapper">
			<input type='Button' class='button' name="save" id="save" value= '<%=common_labels.getString("Common.Transfer.label")%>'
			OnClick='transferDlgSubmit()'> 
			&nbsp;&nbsp;<input type='Button' class='button' name="cancel" id="cancel" value= '<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick='javascript:closeWindow()'>
		</div>
	</td>
</tr>

</table>
 
<input type='hidden' name='SYDATE' id='SYDATE' value='<%=strSysDate%>'>
<input type='hidden' name='ISSUED_DATE' id='ISSUED_DATE' value='<%=strIssuedDate%>'>
<input type='hidden' name='RESERVED_DATE' id='RESERVED_DATE' value='<%=strReservedDate%>'>
<input type='hidden' name='EXPIRY_DATE' id='EXPIRY_DATE' value='<%=strExpiryDate%>'>
<input type='hidden' name='LOGIN_USER' id='LOGIN_USER' value='<%=login_user%>'>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='FID' id='FID' value='<%=strFid%>' > 
<input type='hidden' name='FACILITY_ID' id='FACILITY_ID' value='<%=strFacilityId%>'>
<input type='hidden' name='EXTERNAL_TRANSFER' id='EXTERNAL_TRANSFER' value='ExternalTransfer' >
<input type='hidden' name='PATIENT_ID' id='PATIENT_ID' value='<%=strPatientId%>' RECORD_TYPE='S'>
<input type='hidden' name='UNIT_NO' id='UNIT_NO' value='<%=strUnitNo%>' RECORD_TYPE='S'>
<input type='hidden' name='SPECIMEN_NO' id='SPECIMEN_NO' value='<%=strSpecimenNo%>' RECORD_TYPE='S'>
<input type='hidden' name='PRODUCT_CODE' id='PRODUCT_CODE' value='<%=strProductCode%>' RECORD_TYPE='S'>
<input type='hidden' name='PRACTIONER_CODE' id='PRACTIONER_CODE' value='<%=strProductCode%>' RECORD_TYPE='S'>
<input type='hidden' name='CURRENT_VOLUME' id='CURRENT_VOLUME' value='<%=strTransferVol%>' RECORD_TYPE='S'>
<input type='hidden' name='STORAGE_LOC_CODE' id='STORAGE_LOC_CODE' value='<%=strLocationCode%>' RECORD_TYPE='S'>
<input type='hidden' name='OPERATING_FACILITY_ID' id='OPERATING_FACILITY_ID' value='<%=strFacilityId%>' RECORD_TYPE='S'>
<input type='hidden' name='ROW_ID' id='ROW_ID' value='<%=strRowId%>' RECORD_TYPE='S'> 
<input type='hidden' name='transfer_by_id' id='transfer_by_id' value='<%=login_user%>' RECORD_TYPE='S'>
<input type='hidden' name='transfer_to_code' id='transfer_to_code' value='' RECORD_TYPE='S'>
<input type='hidden' name='transfer_reason_code' id='transfer_reason_code' value='' RECORD_TYPE='S'>

<%
}
catch(Exception ee)
{
	ee.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(con,request);
}%>
</form>
</body>
</html>

