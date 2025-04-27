<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
 <% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	request.setCharacterEncoding("UTF-8"); 
	Connection con=null;
	Statement stmt=null;
	ResultSet rs =null;

	String p_module_id		= "MR" ;
	String p_report_id		= "MRMOHLST" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String locale = (String)session.getAttribute("LOCALE");
	String pat_length = "";
	try{
	con  =  ConnectionManager.getConnection(request);
	stmt=con.createStatement();
   
	rs=stmt.executeQuery("select patient_id_length from MP_PARAM_lang_vw where language_id='"+locale+"'");
	if (rs!=null&&rs.next())
       pat_length = rs.getString(1);
	}catch(Exception e) {/* out.println(e.toString()); */	e.printStackTrace();}
	finally
	{
		try
		{
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();
		}
		catch(Exception e)
		{
		}
		ConnectionManager.returnConnection(con,request);
	}
%>

<html>	
<HEAD>
<TITLE></TITLE>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>

<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<script>
    async function callSearchScreen(){ 
			document.forms[0].p_encounter_id.value='';
            var patientid=await PatientSearch('','','','','','','Y','','','Visitreg');
			if(patientid !=null)
            document.forms[0].p_patient_id.value = patientid;
             document.forms[0].p_patient_id.focus();
			 if (document.forms[0].p_patient_id.value!="")
			 {		//document.forms[0].p_encounter_id.value='';
					document.forms[0].encounter_id.disabled=false;
			 }
			 else
			 {
				 	document.forms[0].encounter_id.disabled=true;
					document.forms[0].p_encounter_id.value='';
			 }
			 
        }

    function disbutt(obj)
	{
	 if (obj.value!="")
	 {		
			document.forms[0].encounter_id.disabled=false;
	 }
			
	 else
	 {
			document.forms[0].encounter_id.disabled=true;
			//document.forms[0].p_encounter_id.value=''; // commented by mujafar for ML-MMOH-CRF-0615
	 }

	}
function CheckNumVal(obj)
{
	if (parseInt(obj.value) <= 0)
	{
		alert(getMessage('IP_VAL_NOT_LESS_ZERO','IP'));
		obj.select();
	}
	else
	{
		CheckNum(obj);
		
	}
}

//Start MLMMOH-CRF-0615
function PatientValidation(){  

var patient_id=document.Rep2MovementHistForm.p_patient_id.value;
var p_encounter_id=document.Rep2MovementHistForm.p_encounter_id.value;


        if(patient_id !="" )
		{

			var xmlDoc = ""
			var xmlHttp = new XMLHttpRequest()
			xmlStr ="<root><SEARCH patient_id=\""+patient_id+"\" p_encounter_id=\""+p_encounter_id+"\" steps='CheckPatientId' /></root>"
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
			xmlHttp.open("POST","../../eMR/jsp/AdverseEventType.jsp",false)
			xmlHttp.send(xmlDoc)
			responseText=xmlHttp.responseText
			responseText = trimString(responseText)
			var chk = responseText;
			
			
			var fields = chk.split('$$');
			var chk1=fields[0];
			var chk2=fields[1];
			
			
			
			if(chk1 == 0 )
			{ 
				
				var msg=getMessage("INVALID_VALUE", "COMMON");
				
				alert(msg.replace('#',getLabel("Common.patientId.label","Common")));
				
				document.forms[0].p_patient_id.value="";
				document.forms[0].encounter_id.disabled=true;
			}
			else if(chk1 > 0 && p_encounter_id != "" && chk2 ==0 )
			{
				
				alert(getMessage("MISMATCH_PATIENT_ENCOUNTER","MR"));
				document.forms[0].p_patient_id.value="";
				document.forms[0].p_encounter_id.value="";
				document.forms[0].encounter_id.disabled=true;
			}
			
		}
				
			
	
}

function EncounterValidation(){ 

var patient_id=document.Rep2MovementHistForm.p_patient_id.value;
var p_encounter_id=document.Rep2MovementHistForm.p_encounter_id.value;


        if(p_encounter_id !="" )
		{

			var xmlDoc = "";
			var xmlHttp = new XMLHttpRequest();
			xmlStr ="<root><SEARCH patient_id=\""+patient_id+"\" p_encounter_id=\""+p_encounter_id+"\" steps='CheckEncounterId' /></root>"
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","../../eMR/jsp/AdverseEventType.jsp",false);
			xmlHttp.send(xmlDoc)
			responseText=xmlHttp.responseText
			responseText = trimString(responseText)
			var chk = responseText;
			
			var fields = chk.split('$$');
			var chk1=fields[0];
			var chk2=fields[1];
			
			if(chk1 == 0 )
			{ 
				
				var msg=getMessage("INVALID_VALUE", "COMMON");
				
				alert(msg.replace('#',getLabel("Common.encounterid.label","Common")));
				
				document.forms[0].p_encounter_id.value="";
				if(document.forms[0].p_patient_id.value=="")
				document.forms[0].encounter_id.disabled=true;
				else
				document.forms[0].encounter_id.disabled=false;	
			}
			else if(chk1 > 0 && patient_id != "" && chk2 ==0 )
			{
				
				
				alert(getMessage("MISMATCH_PATIENT_ENCOUNTER","MR"));
				document.forms[0].p_patient_id.value="";
				document.forms[0].p_encounter_id.value="";
				document.forms[0].encounter_id.disabled=true;
			}
			
			
			
		}
				
			
	
}
//End MLMMOH-CRF-0615


	async function searchCode(obj,target)
	{
			var retVal = 	new String();
			var locale= "<%=locale%>"
			var dialogHeight= "400px" ;//10
			var dialogWidth	= "700px" ;//43
			var dialogTop	= "10px" ;//95

			var features	="dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
			var arguments	= "" ;
			retVal = await window.showModalDialog("../jsp/AllEncounterDisplayFrame.jsp?patient_id="+document.forms[0].p_patient_id.value,arguments,features);
			if(retVal !=null)
				target.value = retVal;
				target.focus();
	}

</script>
</HEAD>

<BODY onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<br>
<br>
<form name="Rep2MovementHistForm" id="Rep2MovementHistForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>

		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>

	<tr>

		<td width="100%" class="Border" align='center'>

			<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td align='right' width='30%' class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/> &nbsp;</td>
					<td><input type=text  name='p_patient_id' id='p_patient_id' size=<%=pat_length%> maxlength=<%=pat_length%> onBlur="ChangeUpperCase(this);disbutt(this);PatientValidation();" align="center"><input type='button' name='patient_id' id='patient_id' value='?' class='button' onclick='callSearchScreen()'></td>
					<td align='right' width='30%' class="label"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/> &nbsp;</td>
					<td  nowrap ><input type=text  name='p_encounter_id' id='p_encounter_id' size="12" maxlength="12" onKeyPress='return(ChkNumberInput(this,event,0))' onBlur="CheckNumVal(this);EncounterValidation();" align="center"><input type='button' name='encounter_id' id='encounter_id' value='?' class='button' onclick='searchCode(this, p_encounter_id)' disabled><img src="../../eCommon/images/mandatory.gif"></img></td>
				</tr>
				
				<tr>
					<td>&nbsp;</td>
				</tr>
		</table>
	</td>
</tr>
</table>

	<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
	

</form>
</BODY>
</HTML>

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

