<!DOCTYPE html>
<!--Created by Thamizh selvi on  29th Mar 2017 against GDOH-CRF-0124-->
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.text.*" %>

<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% 
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	Connection con	= null;
	try
	{
		String Patient_Id_Length	= "";
		String operstn			= checkForNull(request.getParameter("oper_stn_id"));
		String facilityID=(String)session.getValue("facility_id");

		con = ConnectionManager.getConnection(request);
		
		Patient_Id_Length = eCommon.Common.CommonBean.getPatIdLength(con);
		Patient_Id_Length = checkForNull(Patient_Id_Length,"0");

		webbeans.op.PatientData patdata = new webbeans.op.PatientData();
		patdata.setFacility_id(facilityID);


%>	

	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		
		<script src='../../eIP/js/IPQueryCommon.js' language='javascript'></script>
		<script language='javascript' src="../../eCommon/js/CommonCalendar.js"></script>
		<Script src="../../eCommon/js/DateUtils.js" language="JavaScript"></Script>
		<script src='../../eIP/js/IPCancelTransfer.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	    <Script>
			function validSplchars(obj)
			{	
				var val = obj.value.toUpperCase();			
				obj.value = val;	
				var fields=new Array();
				var names=new Array();
				fields[0]=obj;
				names[0]="Patient ID";									
				if(SpecialCharCheck( fields, names,'',"A",''))
					return true;
				else
				{
					obj.select();
					obj.focus();
					return false;
				}
			}

			function validatePatientId(obj) 
			{
				var patId = obj.value;
				if(parent.content !=null) {
					f = parent.content.frames[1];
				}else {
					f = parent.frames[1];
				}

				if(patId!=""){ 
					var xmlDoc = ""
					var xmlHttp = new XMLHttpRequest()
					xmlStr ="<root><SEARCH patientId=\""+patId+"\" action='validatePatId' /></root>"
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
					xmlHttp.open("POST","../../eIP/jsp/IPintermediate.jsp",false)
					xmlHttp.send(xmlDoc)
					responseText=xmlHttp.responseText
					responseText = trimString(responseText)
					if(responseText!=""){
						var msg = getMessage("INVALID_PATIENT","MP");
						alert(msg);
						obj.value="";
						obj.focus();
						parent.frames[2].location = "../../eCommon/html/blank.html";
					}
				}
			}

			async function showLookUp(val)
			{
				if(val == 'P')
				{
					var patientid= await PatientSearch('','','','','','','Y','','','OTHER');
					if(patientid != null)
					document.getElementById("patient_id").value = patientid;
				}
			}

			function submitPage()
			{
				if(document.forms[0].patient_id.value=="")
				{
					var msg = getMessage("CAN_NOT_BE_BLANK","common");
					msg = msg.replace('$',getLabel("Common.patientId.label","Common"))
					alert(msg);
					document.forms[0].patient_id.focus();
					return false;
				}
				var condition="";
				patientId = document.forms[0].patient_id.value;
				oper_stn = document.forms[0].operstn.value;
				parent.frames[2].location.href= '../../eIP/jsp/IPCancelTransferResult.jsp?&patient_id='+patientId+'&oper_stn_id='+oper_stn+'';
					
				parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
				
			}
	  </Script>
 </head>
 <body onLoad= 'FocusFirstElement()' onSelect="codeArrestThruSelect()" onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
 <form name='CancelTransferForm' id='CancelTransferForm' action='' target='result' >
	<table cellspacing=0 cellpadding=0 width='100%' border='0' align='center'>
 		<tr>
		 <td class='label' width="5%">&nbsp;</td>
		  <td class='label' width="10%">&nbsp;</td>
		  <td class='label' width="20%">&nbsp;</td>
		  <td class='label' width="65%">&nbsp;</td>
		</tr>
		<tr>
		  <td class='label' width="5%">&nbsp;</td>
		  <td class='label' width="10%">&nbsp;</td>
		  <td class='label' width="20%">&nbsp;</td>
		  <td class='label' width="65%">&nbsp;</td>
		</tr>
		<tr>
			<td class='label' width="5%">&nbsp;</td>
			<td class='label' width = '10%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
			<td width = '20%' class='fields'><input type='text' maxlength='<%=Patient_Id_Length%>' size='15' name='patient_id'  id='patient_id'onKeyPress='return(CheckForSpecChars(event))' onBlur='ChangeUpperCase(this);if(validSplchars(this)) validatePatientId(this);'><input type="button" class=BUTTON name="patient_search" id="patient_search" value="?" onClick="javascript:showLookUp('P')"><img src="../../eCommon/images/mandatory.gif"></td>
			
			<td class='fields' width = '65%'><input type='button' class='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onclick='submitPage()'>
			
		
		</tr>
		
		<input type='hidden' name='operstn' id='operstn' value="<%=operstn%>" >
 </form>
 </body>
<% 
}
catch(Exception e)	
{
	out.println(e);
	e.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(con,request);
}
%>
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

