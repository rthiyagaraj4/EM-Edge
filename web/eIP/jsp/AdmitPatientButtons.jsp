<!DOCTYPE html>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, eCommon.XSSRequestWrapper" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%	request.setCharacterEncoding("UTF-8");
    request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); %>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>">
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../js/AdmitPatient.js' language='javascript'></script>
	<script src='../js/AdmitPatient1.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script language="JavaScript">
	async function callLastAdmission()
	{
		var patid=parent.frames[0].document.forms[0].patient_id.value;
		var retVal = 	new String();
		var dialogHeight= "700px";
		var dialogWidth = "1200px";
		var dialogTop	= "72";
		var center = "1" ;
		var status="no";
		var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "" ;
		retVal = await window.showModalDialog("../../eMP/jsp/vwEncounterDetailFrames.jsp?patientid="+patid
		,arguments,features);
	}

	async function showContactDetails()
	{
		var booking_ref_no	=	parent.frames[0].document.forms[0].booking_ref_no;
		var contact_details	=	parent.frames[2].document.forms[0].contact_details;
		var retVal			= 	new String();
		var dialogHeight	=	"28" ;
		var dialogWidth		=	"35" ;
		var status			=	"no";
		var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		var arguments		=	contact_details;
		var url				=	"../../eIP/jsp/BookAppointmentContact.jsp?booking_ref_no="+escape(booking_ref_no.value)+"&contactdetails="+escape(contact_details.value);
		retVal					=	await window.showModalDialog(url,arguments,features);		

		if(retVal != "")	
		{
			contact_details.value	=	retVal;			

			var contact_vals = retVal;
			var contacts = contact_vals.split("||");

			parent.frames[2].document.forms[0].res_tel_no.value = contacts[0];
			parent.frames[2].document.forms[0].oth_contact_no.value = contacts[1];
			parent.frames[2].document.forms[0].email_id.value = contacts[2];
			parent.frames[2].document.forms[0].postal_code.value = contacts[3];
			parent.frames[2].document.forms[0].country_code.value = contacts[4];
			parent.frames[2].document.forms[0].res_addr_line1.value = contacts[5];
			parent.frames[2].document.forms[0].res_addr_line2.value = contacts[6];
			parent.frames[2].document.forms[0].res_addr_line3.value = contacts[7];
			parent.frames[2].document.forms[0].res_addr_line4.value = contacts[8];
		}
	}
	async function showValuables()
	{
			var retVal =    new String();
			var dialogTop   = "130";
			var dialogHeight    = "19.5" ;
			var dialogWidth = "50" ;
			var features    ="dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
			var arguments ="";
			var valubl = parent.frames[2].document.forms[0].valubles.value ;

			valubl += checkForNull(parent.frames[2].document.forms[0].recorded_by.value);
			valubl += "||"+checkForNull(parent.frames[2].document.forms[0].recorded_date.value);
			valubl += "||"+checkForNull(parent.frames[2].document.forms[0].valuble_remakrs.value);
			var url   = "../../eMP/jsp/PatientValuablesMain.jsp?encounterId= patientId="+parent.frames[2].document.forms[0].patient_id.value +"&valuble="+escape(valubl);

			retVal = await window.showModalDialog(url,arguments,features);
			if(retVal != null)
			{
				if(retVal != "")
				{
					var contact_vals = new Array();
					contact_vals = retVal;
					var contacts = contact_vals.split("||");
					parent.frames[2].document.forms[0].recorded_by.value = contacts[0];
					parent.frames[2].document.forms[0].recorded_date.value = contacts[1];
					parent.frames[2].document.forms[0].valuble_remakrs.value = contacts[2];
				}
			}
			
	}
	function checkForNull(inString)
	{
		return (trimCheck(inString))	?	inString	:	"";
	}

	async function ViewRefDetails()
	{
		refid = parent.frames[0].document.Select_form.referral_id.value;
		var retVal = 	new String();
		var dialogHeight= "700px" ;
		var dialogTop = "72" ;
		var dialogWidth	= "1200px" ;
		var status = "no";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;
		var retVal = await window.showModalDialog("../../eMP/jsp/ViewPatReferral.jsp?referral_id="+refid,arguments,features);
	}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();">
<table cellpadding=0 cellspacing=0 align="right" width="20%" border=0>
<tr>
	<td class='WHITE'><input type="button" name='valuables' id='valuables' class="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientValuables.label","common_labels")%>" onClick="showValuables(this);" style="visibility:hidden" disabled tabindex='21'></td>
	<td class='WHITE'><input type="button" name='contact_details' id='contact_details' class="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ContactDetails.label","common_labels")%>" onClick="Modal_Contact_Details(this);" disabled tabindex='21'></td>
	<td class='WHITE'><input type="button" name='PrevIPVisit' id='PrevIPVisit' class="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PreviousEncounters.label","common_labels")%>" onClick="callLastAdmission()" disabled tabindex='22'></td>
	<td class='WHITE'><input type="button" name='referal_details' id='referal_details' class="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referraldetails.label","common_labels")%>" onClick="ViewRefDetails()" disabled tabindex='23'></td>
</tr>
</table>
</body>
</html>

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

