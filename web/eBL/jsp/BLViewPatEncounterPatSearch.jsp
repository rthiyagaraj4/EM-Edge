<!DOCTYPE html>
<!--
Sr No        Version           TFS/Incident        SCF/CRF            		Developer Name
---------------------------------------------------------------------------------------------
1			 V210517			 17598			Common-ICN-0034				Mohana Priya K
---------------------------------------------------------------------------------------------
-->

<%@ page import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, com.ehis.util.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8");%>

<html>
	<head>
<%	
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>		
	<script src="../../eCommon/js/CommonCalendar.js" language="javascript"></script>
	<script language="javascript" src="../../eBL/js/BLPatientEncounters.js"></script>	
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%
	request.setCharacterEncoding("UTF-8");	
	Connection con	= null;
	Statement stmt	= null;
	ResultSet rs	= null;	
	String  params="",function_id="",str_facility_id=""; 

	try
	{
		con	=	ConnectionManager.getConnection(request);
		String locale	= (String)session.getAttribute("LOCALE");	
		if(locale==null || locale.equals("")) locale="en";
		params = request.getQueryString();
		if(params == null) params="";

		function_id = request.getParameter("function_id");
		if(function_id == null) function_id="";

		String sys_date="";

		str_facility_id = (String) session.getValue("facility_id");
		if (str_facility_id==null) str_facility_id = "";

		try
		{
			String query_date="select to_char(sysdate,'dd/mm/yyyy HH24:MI:SS') from dual";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query_date) ;
			if( rs!= null ) 
			{
				while( rs.next() )
				{  
					sys_date = rs.getString(1);
				}
			}
			if (rs != null)   rs.close();
			//stmt.close();  //Commented against V210517
		}		
		catch(Exception e)
		{
			out.println("Exception :"+e);
			e.printStackTrace();
		}
%>
<script>
function funQry()
{		
	parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
	parent.frames[1].location.href='../../eCommon/html/blank.html';

	var patient_id = document.forms[0].patient_id.value;	
	var params = document.forms[0].params.value;
	var ward_clinic_code = "";

	if(patient_id=="")
	{
		var process_label = getMessage("BL0002","BL");
		parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+process_label;
		return;
	}
	var locale = document.forms[0].locale.value;				
	var episode_type=document.forms[0].episode_type.value;			
	var episode_id=document.forms[0].episode_id.value;
	var visit_id=document.forms[0].visit_id.value;		
	var encounter_from=document.forms[0].encounter_from_date.value;		
	var encounter_from_date = convertDate(encounter_from,"DMY",locale,"en");			
	var encounter_to=document.forms[0].encounter_to_date.value;		
	var encounter_to_date = convertDate(encounter_to,"DMY",locale,"en");				
	var function_id = document.forms[0].function_id.value;	
	var episode_type_leg = getLabel("Common.EpisodeType.label","common");
	if(episode_type == "I" || episode_type == "D")
	{
		ward_clinic_code = document.forms[0].ward_code.value;
	}
	else if(episode_type == "O" || episode_type == "E")
	{
		ward_clinic_code = document.forms[0].clinic_code.value;
	}
	else
	{
		ward_clinic_code = "";
	}
	/*		Name : Manivel N
	Date : 16/12/2009
	Desc : Adding the Below Loop for Reimbusrement Function Call
	*/
 
	if((function_id == "EBL_OP_OVERRIDE_REIM_DTLS" || function_id == "EBL_IP_OVERRIDE_REIM_DTLS" || function_id == "EBL_OP_OVERIDE_UNBLD_REIM_DTLS" || function_id == "EBL_IP_OVERIDE_UNBLD_REIM_DTLS") && episode_type == "")
	{
		var message = getMessage("CAN_NOT_BE_BLANK","Common");
		message = message.replace("$",episode_type_leg);
		alert(message);
		document.forms[0].episode_type.focus();
		return false;
	}
	parent.frames[1].location.href="../../eBL/jsp/BLViewPatEncounterDtls.jsp?sel_patient_id="+patient_id+"&sel_episode_type="+episode_type+"&sel_episode_id="+episode_id+"&sel_visit_id="+visit_id+"&sel_encounter_from_date="+encounter_from_date+"&sel_encounter_to_date="+encounter_to_date+"&sel_ward_clinic_code="+ward_clinic_code+"&"+params;
}

async function getPatID()
{	
	var pat_id=await PatientSearch();		
	if( pat_id != null )						
	document.forms[0].patient_id.value = pat_id ;					
}

function showCalendar_loc(Val1, Val2)
{	
	if (Val2.disabled == true)		
	{
		return false;
	}
	else
	{
		return showCalendar(Val1,null,null);
	}
}
	
function ClearFrame()
{	
	document.forms[0].reset() ;
	parent.frames[1].location.href='../../eCommon/html/blank.html';
}
	
function call_date_less_equal_chk(obj)
{	
	if(!(obj.value==""))
	{
		var locale=document.forms[0].locale.value;
		var sysdate=getCurrentDate('DMY',locale);
		if(chkDtLessEqualThanSysDateNew(obj,sysdate))
		{		
			return true;
		}
		else
		{		
			return false;
		}
	}
	else
	{	
		return false;
	}
}	

function toFromDateChk(obj)
{
	if(!(obj.value==""))
	{		
		var effFromDt = document.forms[0].encounter_from_date.value;
		var effToDt = document.forms[0].encounter_to_date.value;
		if(checkDateBL(obj))
		{
			var locale=document.forms[0].locale.value;			
			if((!isBefore(effFromDt,effToDt,'DMY',locale)))
			{		
				alert(getMessage("BL4115",'BL'));
				obj.value="";
				//obj.select();
			}
			else
			{			
				return false;
			}
		}
	}
	else
	{
		return false;
	}
}

function showWardClinic()
{
	var epi_type=document.forms[0].episode_type.value;	
	if(epi_type=='E' || epi_type=='O')
	{
		document.forms[0].ward_code.value = "";
		document.forms[0].ward_desc.value = "";
    	document.getElementById('clinic_id').style='display';
		document.getElementById('clinic_id1').style='display';
		document.getElementById('ward_id').style.display='none';
		document.getElementById('ward_id1').style.display='none';
	}
	else if(epi_type=='I' || epi_type=='D')
	{
		document.forms[0].clinic_code.value = "";
		document.forms[0].clinic_desc.value = "";
		document.getElementById('clinic_id').style.display='none';
		document.getElementById('clinic_id1').style.display='none';
		document.getElementById('ward_id').style='display';
		document.getElementById('ward_id1').style='display';
	}
	else
	{
		document.forms[0].ward_code.value = "";
		document.forms[0].ward_desc.value = "";
		document.forms[0].clinic_code.value = "";
		document.forms[0].clinic_desc.value = "";
		document.getElementById('clinic_id').style.display='none';
		document.getElementById('clinic_id1').style.display='none';
		document.getElementById('ward_id').style.display='none';
		document.getElementById('ward_id1').style.display='none';
	}
}

async function wardLookup(clng_evnt)
{
	if(clng_evnt == 'B')
	{
		if(document.forms[0].ward_desc.value == "")
		{
			document.forms[0].ward_desc.value = "";
			document.forms[0].ward_code.value = "";
			return;
		}
	}
	var retVal			= new String();	
	var dialogTop			= "40";
	var dialogHeight		= "800px" ;
	var dialogWidth			= "700px" ;
	var features			= "dialogTop:"+dialogTop+";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var sql					= "";
	var sql3				= "";		
	var locale = document.forms[0].locale.value;
	var facility_id = document.forms[0].facility_id.value;

	var title=encodeURIComponent(getLabel("Common.Ward.label","common"));
	var column_sizes = escape("10%,15%");
	var code=getLabel("Common.code.label","common");
	code=encodeURIComponent(code);
	var desc=getLabel("Common.description.label","common");
	desc=encodeURIComponent(desc);
	var column_descriptions =code+","+desc;
	var message = '';
	sql3="SELECT nursing_unit_code Code , short_desc Description from IP_NURSING_UNIT_LANG_VW where LANGUAGE_ID='"+locale+"' and facility_id='"+facility_id+"'";

	sql = escape(sql3);	
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&"+"message="+message+"&target="+encodeURIComponent(document.forms[0].ward_desc.value)+"&srch_by_clmn_index=2"+"&col_show_hide=YY";
	retVal=await window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?"+param,arguments,features);		 
	var arr=new Array();
	if(retVal == null || retVal == 'undefined' || retVal == undefined) retVal="";
	if(retVal != "")
	{
		var retVal=unescape(retVal);		 
		if(retVal != null && retVal.length>0)
		{
			arr=retVal.split("^~^");	
			document.forms[0].ward_code.value=arr[0];							  			
			document.forms[0].ward_desc.value=arr[1];
		}
	}
	else
	{
		document.forms[0].ward_code.value="";	
		document.forms[0].ward_desc.value="";	
	}
}

async function clinicLookup(clng_evnt)
{
	if(clng_evnt == 'B')
	{
		if(document.forms[0].clinic_desc.value == "")
		{
			document.forms[0].clinic_desc.value = "";
			document.forms[0].clinic_code.value = "";
			return;
		}
	}
	var retVal			= new String();	
	var dialogTop			= "40px";
	var dialogHeight		= "500px" ;
	var dialogWidth			= "700px" ;
	var features			= "dialogTop:"+dialogTop+";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var sql					= "";
	var sql3				= "";		

	var locale = document.forms[0].locale.value;
	var facility_id = document.forms[0].facility_id.value;

	var title=encodeURIComponent(getLabel("Common.clinic.label","common"));
	var column_sizes = escape("10%,15%");
	var code=getLabel("Common.code.label","common");
	code=encodeURIComponent(code);
	var desc=getLabel("Common.description.label","common");
	desc=encodeURIComponent(desc);
	var column_descriptions =code+","+desc;
	var message = '';
	sql3="SELECT CLINIC_CODE code,SHORT_DESC description from OP_CLINIC_LANG_VW where LANGUAGE_ID='"+locale+"' and facility_id='"+facility_id+"'";

	sql = escape(sql3);	
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&"+"message="+message+"&target="+encodeURIComponent(document.forms[0].clinic_desc.value)+"&srch_by_clmn_index=2"+"&col_show_hide=YY";
	retVal=await window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?"+param,arguments,features);		 
	var arr=new Array();
	if(retVal == null || retVal == "undefined" || retVal == undefined) retVal="";

	if(retVal != "")
	{
		var retVal=unescape(retVal);		 
		if(retVal != null && retVal.length>0)
		{
			arr=retVal.split("^~^");	
			document.forms[0].clinic_code.value=arr[0];							  			
			document.forms[0].clinic_desc.value=arr[1];
		}
	}
	else
	{
		document.forms[0].clinic_code.value="";	
		document.forms[0].clinic_desc.value="";	
	}
}

function disable_but()
{
	var function_id = document.forms[0].function_id.value;
	if(function_id == "EBL_OP_OVERRIDE_REIM_DTLS" || function_id == "EBL_IP_OVERRIDE_REIM_DTLS" || function_id == "EBL_OP_OVERIDE_UNBLD_REIM_DTLS" || function_id == "EBL_IP_OVERIDE_UNBLD_REIM_DTLS")
	{
		parent.parent.frames[0].document.forms[0].apply.disabled = true;
	}
}

function CheckForChar(Obj)
{
	var check_var = Obj.value;

	numList = '1234567890.';
	
	for (i=0;i<check_var.length;i++)
	{
		if (numList.indexOf(check_var.charAt(i)) == -1) 
		{
			alert(getMessage("INVALID_NUMBER_FORMAT","Common"));
			Obj.select();
			return false;  
		}
	}
	return true;
}
</script>	

<BODY onLoad="disable_but();" onKeyDown= "lockKey();" onMouseDown="CodeArrest();" 					      					  onSelect="codeArrestThruSelect();">
<FORM name='' id='' action="" method='post'>
	<TABLE border='0' cellpadding='3' cellspacing='0' align='center' width='100%'>
		<tr>
			<td class="label" width="25%"><b><fmt:message key="Common.patientId.label"   bundle="${common_labels}"/></b></td>	
			<td class="fields" width="25%"><INPUT TYPE="TEXT"  name="patient_id" id="patient_id" SIZE="10" maxlength='10' VALUE=''  onKeyPress='changeToUpper()' onBlur="" ><input type='button' class='button' name="patientidbut" id="patientidbut" value='?' onClick="return getPatID()" tabindex='2'><img src='../../eCommon/images/mandatory.gif'></td>
			<td width='25%'  class='label'><b><fmt:message key="Common.EpisodeType.label" bundle="${common_labels}"/></b></td>
			<td  width='25%' class='fields'>
				<select name='episode_type' id='episode_type' onchange='showWardClinic()'>
					<option value=''>-------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------------------</option>
	<%
		if(function_id.equals("EBL_OP_OVERRIDE_REIM_DTLS") || function_id.equals("EBL_OP_OVERIDE_UNBLD_REIM_DTLS"))
		{
	%>
			   <option value='E'><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></option>
			   <option value='O'><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></option>
			   <option value='R'><fmt:message key="Common.external.label" bundle="${common_labels}"/></option>
	<%
		}
		else if(function_id.equals("EBL_IP_OVERRIDE_REIM_DTLS") || function_id.equals("EBL_IP_OVERIDE_UNBLD_REIM_DTLS"))
		{
	%>
			   <option value='I'><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></option>
			   <option value='D'><fmt:message key="Common.daycare.label" bundle="${common_labels}"/></option>
	<%
		}
		else
		{
	%>
			   <option value='E'><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></option>
			   <option value='O'><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></option>
			   <option value='I'><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></option>
			   <option value='D'><fmt:message key="Common.daycare.label" bundle="${common_labels}"/></option>
<!--
			   <option value='R'><fmt:message key="Common.external.label" bundle="${common_labels}"/></option>
-->
	<%
		}
	%>
				</select>
		</tr>
		<tr>
			<td width='25%' class='label'><b><fmt:message key="Common.episodeid.label"	bundle="${common_labels}"/></b></td>
			<td width='25%' class="fields"><input type='text' name='episode_id' id='episode_id' size='8' maxlength='8' style='text-align:right' value='' onKeyPress='return(ChkNumberInput(this,event,0))' onBlur="CheckForChar(this)" ></td>
			<td width='25%' class='label'> <b><fmt:message key="Common.VisitID.label" bundle="${common_labels}"/></b> </td>
			<td width='25%' class="fields"><input type='text' name='visit_id' id='visit_id' size='4' maxlength='4' style='text-align:right' value=''  onKeyPress='return(ChkNumberInput(this,event,0))' onBlur="CheckForChar(this)"></td>
		</tr>
		<tr>
			<td width='25%' class='label'> <b><fmt:message key="Common.encounter.label" bundle="${common_labels}"/>     <fmt:message key="Common.fromdate.label" bundle="${common_labels}"/></b> </td>
			<td width='25%' class="fields"><input type='text' name='encounter_from_date' id='encounter_from_date' size='10' maxlength='30' value='' onBlur='return checkDateBL(document.forms[0].encounter_from_date)' ><img src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar_loc('encounter_from_date',document.forms[0].encounter_from_date);" onBlur='return checkDateBL(document.forms[0].encounter_from_date)'></td>
			<td width="25%"  class='label'><b><fmt:message key="Common.todate.label" bundle="${common_labels}"/></b></td>
			<td width='25%' class="fields"><input type='text' name='encounter_to_date' id='encounter_to_date' size='10' maxlength='30'  value='' onBlur='return toFromDateChk(document.forms[0].encounter_to_date)'><img src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar_loc('encounter_to_date',document.forms[0].encounter_to_date);" onBlur='return toFromDateChk(document.forms[0].encounter_to_date)'></td>
		</tr>
		<tr>
			<td width='25%' class='label'>
				<div id='ward_id' style='display:none'><b><fmt:message key="Common.Ward.label"	bundle="${common_labels}"/></b></div>
			</td>
			<td width='25%' class="fields">
				<div id='ward_id1' style='display:none'><input type='text' name='ward_desc' id='ward_desc' size='30' maxlength='30' value='' onBlur="wardLookup('B')" ><input type='button' class='button' name="ward_btn" id="ward_btn"   value='?'  tabindex='0' onClick="wardLookup('C')"></div><input type="hidden" name="ward_code" id="ward_code" value="">
			</td>
			<td width='25%' class='label'>
				<div id='clinic_id' style='display:none'><b><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></b></div>
			</td>
			<td width='25%' class="fields">
				<div id='clinic_id1' style='display:none'><input type='text' name='clinic_desc' id='clinic_desc' size='25' maxlength='15' value='' onBlur="clinicLookup('B')"><input type='button' class='button' name="clinic_btn" id="clinic_btn"   value='?'  tabindex='0' onClick="clinicLookup('C')"></div><input type="hidden" name="clinic_code" id="clinic_code" value="">
			</td>			
		</tr>
		<tr>
			<td width="25%"  class='labels'>
			<td width="25%"  class='labels'>
			<td width="25%"  class='labels'>
			<td width="25%"  class='labels'><input type='button'  name="search_button" id="search_button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>" class='button' onClick='funQry();'>	
			<input type='button'  name="cancel_button" id="cancel_button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>" class='button' onClick='ClearFrame()'></td>	
		</tr>
	</TABLE>
	<input type='hidden' name='locale' id='locale' value='<%=locale%>' >
	<input type='hidden' name='sys_date' id='sys_date' value='<%=sys_date%>'>
	<input type='hidden' name='params' id='params' value='<%=params%>'>
	<input type='hidden' name='function_id' id='function_id' value='<%=function_id%>'>
	<input type='hidden' name='facility_id' id='facility_id' value='<%=str_facility_id%>'>
</FORM>
</BODY>	
</HTML>
<%
	}
	catch(Exception e )
	{ 
		System.err.println("Error in BLViewPatEncounterPatSearch.jsp:"+e);
		out.println(e);
		e.printStackTrace();
	}
	finally
	{	
		if(stmt != null)	stmt.close();
		if (rs != null)   rs.close();
		ConnectionManager.returnConnection(con, request);
	}
%> 

