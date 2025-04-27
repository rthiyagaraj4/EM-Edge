<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*, webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
 <% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	request.setCharacterEncoding("UTF-8"); 
	String p_module_id		= "IP" ;
	String p_report_id		= "IPBDISAD" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String locale = (String)session.getAttribute("LOCALE");
	String isSpltyNurUnitToEnableYNAppl="";
%>
<%
//Added by Shanmukh on 26th-Apr-2018 for ML-MMOH-CRF-1139 starts--->
	Connection con  =  null;
	Statement stmt = null;
	Statement stmt1 = null;
	StringBuffer sql = new StringBuffer();
	StringBuffer sql1 = new StringBuffer();

	
	sql.append("Select discharge_type_code , short_desc from ip_discharge_type_lang_vw where language_id='"+locale+"'" );
	sql1.append("select discharge_status_code , short_desc from ip_discharge_status where eff_status='E'" );
	
	ResultSet rset = null;
	ResultSet rset1 = null;
	
	StringBuffer StrVal = new StringBuffer();
	StringBuffer StrVal1 = new StringBuffer();
	
	
	
    try
    {
		con  =  ConnectionManager.getConnection(request);
		isSpltyNurUnitToEnableYNAppl = eIP.IPCommonBean.getSpltyNurUnitToEnableYN(con);//Added by shanmukh on 14th-AUG-2018 for ML-MMOH-CRF-1115
		stmt = con.createStatement(); 
		stmt1 = con.createStatement(); 
		rset = stmt.executeQuery(sql.toString());
		rset1 = stmt1.executeQuery(sql1.toString());
		
        Boolean isSearchCrtForDisAdviseAppl =eCommon.Common.CommonBean.isSiteSpecific(con, "IP","SR_CRI_FOR_DISCHRG_ADVI");  
		if(rset != null)
		{
			while(rset.next())
			{
				StrVal.append(" <option value='"+rset.getString(1)+"'>"+rset.getString(2)+"</option> ");
		
			}
		}
		if(rset1 != null)
		{
			while(rset1.next())
			{
				StrVal1.append(" <option value='"+rset1.getString(1)+"'>"+rset1.getString(2)+"</option> ");
		
			}
		}
	 
%>

<html>	
<HEAD>
<TITLE></TITLE>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src='../../eIP/js/IPQueryCommon.js' language='javascript'></script>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
//Added by Shanmukh on 26th-Apr-2018 for ML-MMOH-CRF-1139 starts--->
function chkDate(Obj) { 
	if(Obj.value != '') {
		if(!validDateObj(Obj,"DMY",localeName)) {
		    Obj.value = "";
			Obj.select();
			return false;			
		 } else if (isBeforeNow(Obj.value,"DMY",localeName) == false) {
			var err1 = getMessage("DATE_NOT_GREATER_SYSDATE","Common");			
			alert(err1);
			Obj.value = "";
			Obj.focus();
			return false;
		 }
			 var p_fm_date=document.forms[0].p_fm_date.value;
			 var p_to_date=document.forms[0].p_to_date.value;
			 if(Obj.name=='p_fm_date'){
			  if(p_fm_date !='' && p_to_date !=''){
				if((!isBefore(p_fm_date,p_to_date,'DMY',localeName))) {
					alert(getMessage("FRDT_LTEQ_TODT","IP"));
					Obj.value=""; 
					Obj.select();
			    }
			}
		   }else{
		    if(document.forms[0].p_fm_date.value !=''){
			   if((!isBefore(p_fm_date,p_to_date,'DMY',localeName))) {
				alert(getMessage("TO_DT_GR_EQ_FM_DT",'SM'));
				Obj.value="";
				Obj.select();
			    }
		   }
	  }
   
	
	}	
}
async function searchCode(obj,target)
	{	
			var retVal = 	new String();
			var locale= "<%=locale%>"
			/* var dialogHeight= "28" ;
			var dialogWidth	= "43" ; */
			var dialogHeight= "400px" ;
			var dialogWidth="900px";
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
		
			if(obj.name=="Speciality")
			{
				var tit=getLabel('Common.speciality.label','common');
				
				sql="select speciality_code, short_desc from am_speciality_lang_vw where language_id=`"+locale+"`  ";
				search_code="speciality_code";
				search_desc= "short_desc";
			}

			
			if(obj.name=="nursing_unit_code")
			{
				tit=getLabel('Common.nursingUnit.label','common');
				
				sql="select nursing_unit_code, short_desc from ip_nursing_unit_lang_vw where facility_id=`<%= p_facility_id%>` and language_id=`"+locale+"` ";
				search_code="nursing_unit_code";
				search_desc= "short_desc";
			}
			if(obj.name=="discharge_type")
			{
				tit=getLabel('Common.dischargetype.label','common');
				
				sql=" select discharge_type_code , short_desc from ip_discharge_type_lang_vw where language_id=`"+locale+"` ";
				search_code="discharge_type_code";
				search_desc= "short_desc";
			}

			if(obj.name=="discharge_status")
			{
				tit=getLabel('eIP.DischargeStatus.label','IP');
				sql=" select discharge_status_code , short_desc from ip_discharge_status where eff_status=`E` ";
				search_code="discharge_status_code";
				search_desc= "short_desc";
			}

			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}
function chkShow(Obj)
{ 
    var chks=document.getElementById("chks");
	var chks1=document.getElementById("chks1");
   if(Obj.checked){
		chks.style.display="block";
		chks1.style.display="none";	
		Rep2DischargeAdviseForm.disch.disabled=true;
		Rep2DischargeAdviseForm.p_discharge_yn.value="Y";
		document.forms[0].p_fm_date.value="";
		document.forms[0].p_to_date.value="";
    }else{
		chks.style.display="none";
		chks1.style.display="block";
	    Rep2DischargeAdviseForm.p_discharge_yn.value="N";
		Rep2DischargeAdviseForm.disch.disabled=false;
		document.forms[0].p_fm_date.value="";
		document.forms[0].p_to_date.value="";
	}
	
} 
//ENDS
async function OnClick_searchEncID()
{
	var encounterID = document.forms[0].p_encounter_id.value;

	var retVal =    new String();
	var dialogTop = "10px" ;
	var dialogHeight= "700px" ;
	var dialogWidth="1200px";
	/* var dialogTop   = "72";
	var dialogHeight    = "41" ;
	var dialogWidth = "65" ; */
	var arguments   = "" ;
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; status: no" ;
	retVal = await window.showModalDialog("../../eIP/jsp/RepQueryDischargeAdvice.jsp?<%=request.getQueryString()%>&modal=yes",arguments,features);
	if(retVal != null)
	{
		document.getElementById("p_encounter_id").value = retVal;
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

function validSplchars1(obj)
{	
	var val = obj.value.toUpperCase();			
	obj.value = val;	
	var fields=new Array();
	var names=new Array();
	fields[0]=obj;
	names[0]="Encounter ID";
	if(SpecialCharCheck( fields, names,'',"A",''))
		return true;
	else
	{
		obj.select();
		obj.focus();
		return false;
	}
}

function callPatientSearch()
{
	var p_patient_id	=	PatientSearch();
	if((p_patient_id))
	{
		document.forms[0].p_patient_id.value =p_patient_id;
	}
}

 
</script>
</HEAD>

<BODY onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<br>
<br>
<form name="Rep2DischargeAdviseForm" id="Rep2DischargeAdviseForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>

<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>

<tr>
<td width="100%" class="Border" align='center'>
<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >
<!--Added by Shanmukh on 26th-Apr-2018 for ML-MMOH-CRF-1139 starts -->
   <%if(isSearchCrtForDisAdviseAppl){%>
    <tr>
    	<td align='right' width='30%' class="label"><fmt:message key="Common.DischargePatient.label" bundle="${common_labels}"/>&nbsp;</td>
	    <td align='left'  class='label'><input type='checkbox' name='p_discharge_yn' id='p_discharge_yn' value='Y' onClick='chkShow(this);'></td>
		 
	</tr>
 
	<tr>
		<td align="center" width="30%">&nbsp;</td>
		<td class="label" width="30%" style="font-weight: bold;"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
		<td class="label" width="40%" style="font-weight: bold;" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
	</tr>
	
	
    <tr>
     <td align='right' width='30%' class="label"  id="chks" name="chks" style="display:none"><fmt:message key="Common.dischargedate.label" bundle="${common_labels}"/> &nbsp;</td>
	
	 <td align='right' width='30%' class="label" id="chks1" name="chks1" style="display:block"><fmt:message key="Common.admissiondate.label" bundle="${common_labels}"/>&nbsp;&nbsp;
	
	
	<td width='30%'><input align='left' type='text'  id='p_fm_date' name='p_fm_date' id='p_fm_date' size='10' maxlength='10'  value='' onBlur='chkDate(this);'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_fm_date');"><img src='../../eCommon/images/mandatory.gif'></img></td>
	</td> 
	<td width='40%'><input align='left' type='text'  id='p_to_date' name='p_to_date' id='p_to_date' size='10' maxlength='10'  value='' onBlur='chkDate(this);' ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_to_date');"><img src='../../eCommon/images/mandatory.gif'></img>&nbsp;</td>
	
	</tr>
    <tr>
		<td>&nbsp;</td>
					
	</tr><!--Added by Shanmukh on 20th-AUG-2018 for ML-MMOH-CRF-1115-->
	<%if(isSpltyNurUnitToEnableYNAppl.equals("N")){%>
			<tr>
				<jsp:include page="CommonNursingUnitLookup.jsp">
				<jsp:param name="nursing_unit_code_Appl" value="p_nursing_unit_code"/>
				</jsp:include>
			</tr>
		<tr>
		<td>&nbsp;</td>
		</tr>
			<tr>
				<jsp:include page="CommonSpecialityLookup.jsp">
				<jsp:param name="speciality_code_Appl" value="p_spacialty_code"/>
				</jsp:include>
				
			</tr>
<%}else{%>
	<tr>
       <td align='right' width='30%' class="label"><fmt:message key="Common.NursingUnitCode.label" bundle="${common_labels}"/> &nbsp;</td>
	   <td width='30%'><input type='text'  name='p_nursing_unit_code' id='p_nursing_unit_code' size="4" maxlength="4" align="center"><input type='button' name='nursing_unit_code' id='nursing_unit_code' value='?' class='button' onclick='searchCode(this, p_nursing_unit_code)'></td>
	</tr>	
	<tr>
		<td>&nbsp;</td>
					
    </tr>
    <tr>
		<td  class='label' width='25%'><fmt:message key="Common.SpecialityCode.label" bundle="${common_labels}"/></td>
		<td width='30%'><input type='text'  name='p_spacialty_code' id='p_spacialty_code' size="4" maxlength="4" align="center" ><input type='button' name='Speciality' id='Speciality' value='?' class='button' onclick='searchCode(this, p_spacialty_code)'></td>
	</tr>
<%}%>	
	<tr>
	  <td>&nbsp;</td>
	  
    </tr>	
	<tr>
		<td class='label'  width='25%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
	    <td class='fields' width='25%'><input type='text' name='p_patient_id' id='p_patient_id' value='' size='12'    onBlur="" ><input type='button' class='button' value='?' name='srch' id='srch' onClick="callPatientSearch()"></td> 
   <%}%>
		<td align='right' width='25%' class="label"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/> &nbsp;</td>
		<td><input type='text'  name='p_encounter_id' id='p_encounter_id' size="12" maxlength="12" align="center" onKeyPress='return CheckForSpecChars(event)' onBlur="CheckNumVal(this)"><input type='button' name='but_lookup_RepDischAdvice' id='but_lookup_RepDischAdvice' value='?' class='button' onclick='OnClick_searchEncID()'>&nbsp;<%if(!isSearchCrtForDisAdviseAppl){%><img src='../../eCommon/images/mandatory.gif'></img><%}%></td>
	
    </tr>
	 <%if(isSearchCrtForDisAdviseAppl){%>
	<tr>
	  <td>&nbsp;</td>
	  
    </tr>
	<tr>
		<td align='right' width='25%' class="label"><fmt:message key="Common.dischargetype.label" bundle="${common_labels}"/>&nbsp;</td>
	    <td width='25%'><select name="p_discharge_type" id="p_discharge_type">
						<option value="">---&nbsp; <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;---</option>
						<%=StrVal.toString()%>
						</select></td>
	    <td align='right' width='25%' class="label"><fmt:message key="eIP.DischargeStatus.label" bundle="${ip_labels}"/>&nbsp;</td>
	    <td width='25%'><select name="p_discharge_status" id="p_discharge_status">
						<option value="">---&nbsp; <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;---</option>
						<%=StrVal1.toString()%>
						</select>
					</td>
	</tr>
				
	<tr>
	<td>&nbsp;</td>
	</tr>
	 <%}%>
	<!--ENDS -->
</table>
</td>
</tr>
</table>
<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
<!--Added by Shanmukh on 26th-Apr-2018 for ML-MMOH-CRF-1139 -->
<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%= p_facility_id %>"> 
<input type="hidden" id="disch" name="p_discharge_yn" id="p_discharge_yn"	value="N"> 
<input type="hidden" name="isSearchCrtForDisAdviseAppl" id="isSearchCrtForDisAdviseAppl"	value="<%= isSearchCrtForDisAdviseAppl %>">
<!--ENDS -->

</form>

<%
}
	 catch(Exception e){out.println(e);}
	 finally
	 {
		 try
		 {
			if(rset != null)    rset.close();
			if(rset1 != null)    rset1.close();
			if(stmt != null)    stmt.close();
			if(stmt1 != null)    stmt.close();
		 }
		 catch(Exception e)
		 {out.println("Exception in tryCatch : "+ e.toString());}
		if(con!=null) ConnectionManager.returnConnection(con,request);
	 }
	 //ENDS
%>	 
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

