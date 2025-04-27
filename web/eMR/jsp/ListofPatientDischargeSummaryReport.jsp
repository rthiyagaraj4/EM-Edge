<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%
 
	request.setCharacterEncoding("UTF-8"); 
	String p_module_id		= "MR" ;
	String p_report_id		= "MRDISWOS";
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String locale = (String)session.getAttribute("LOCALE");
	Connection con =null;

  ResultSet rs   = null;
  Statement stmt = null;
try {
     
     String str = "select to_char(sysdate,'dd/mm/yyyy') from dual";
        String CurrentDate=" ";	
	    con  =  ConnectionManager.getConnection(request);
		stmt=con.createStatement();
		rs = stmt.executeQuery(str);	
		if(rs.next()){
			CurrentDate= rs.getString(1);
		}	
		

	

%>


<html>
<head>
   <%String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>

<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src='../js/MRReports.js' language='javascript'></script>
<script src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>


	async function searchCode(obj,target)
	{		
			var retVal = 	new String();
			var locale= "<%=locale%>"
			var dialogHeight= "78vh" ;
			var dialogWidth	= "70vw" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
					
			if(obj.name=="practitioner_id1")
			{
				var tit=getLabel('Common.practitioner.label','common')
				
                sql= "SELECT practitioner_id, practitioner_name FROM  am_practitioner_lang_vw where language_id=`"+locale+"` ";
				search_code="practitioner_id";
				search_desc="practitioner_name";
			}

			if(obj.name=="practitioner_id2")
			{
				var tit=getLabel('Common.practitioner.label','common')				
                sql= "SELECT practitioner_id, practitioner_name FROM  am_practitioner_lang_vw where language_id=`"+locale+"` ";
				search_code="practitioner_id";
				search_desc="practitioner_name";
			}

			if(obj.name=="Speciality")
			{
				var tit=getLabel('Common.speciality.label','common');
				//sql="select speciality_code, short_desc from am_speciality ";
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
			
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}
function validateDischargeToDate(obj) {
		var from = obj.value;	
		var to   = document.forms[0].CurrentDate.value; 
       var fromarray;
		var toarray;
		fromarray  = from.split("/");
		toarray    = to.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);
		//if (CheckDate(obj)){
		if (!isBeforeNow(obj.value,"DMY",localeName)){

			if(Date.parse(todt) < Date.parse(fromdt)) {
					var invaldt = getMessage("DATE1_GT_DATE2",'IP') ;
					var census_date_from=getLabel("Common.dischargedate.label","Common");
					var sys_date=getLabel("Common.CurrentDate.label","Common");
					invaldt=invaldt.replace('$',census_date_from);
					invaldt=invaldt.replace('#',sys_date);
					alert(invaldt);
					obj.value='';
					obj.focus();
					
				}
			}
		}	
function validateDischargeFromDate(obj) {
		var from = obj.value;	
		var to   = document.forms[0].CurrentDate.value; 
       var fromarray;
		var toarray;
		fromarray  = from.split("/");
		toarray    = to.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);
		//if (CheckDate(obj)){
		if (!isBeforeNow(obj.value,"DMY",localeName)){

			if(Date.parse(todt) < Date.parse(fromdt)) {
					var invaldt = getMessage("DATE1_GT_DATE2",'IP') ;
					var census_date_from=getLabel("Common.dischargedate.label","Common");
					var sys_date=getLabel("Common.CurrentDate.label","Common");
					invaldt=invaldt.replace('$',census_date_from);
					invaldt=invaldt.replace('#',sys_date);
					alert(invaldt);
					obj.value='';
					obj.focus();
					
				}
			}
		}			
	

	
</script>
</HEAD>

<body  OnMouseDown="CodeArrest()" onLoad="FocusFirstElement()"  onKeyDown = 'lockKey()'>
<br>
<br>
<form name="DischargeSummaryReport" id="DischargeSummaryReport" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">

<table width='80%' align='center' valign='top' border='0'>

		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>

	<tr>

		<td width="100%" class="Border" align='center'>

			<table width='80%' cellPadding="0" cellSpacing="0"  align='center' border="0" >

				<tr>
					<td align="center" width="30%">&nbsp;</td>
					<td class="label" width="30%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td class="label" width="40%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
	
				</tr>								

				<tr>
						<td align='left' width='30%' class="label"><fmt:message key="Common.dischargedate.label" bundle="${common_labels}"/> &nbsp;</td>
						<td width='30%'  >
							<input type=text id="P_FM_DATE"  name='P_FM_DATE' id='P_FM_DATE' size="10" maxlength="10" align="center" onBlur="if(validDateObj(this,'DMY','<%=locale%>'))validateDischargeFromDate(this);"><img  src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('P_FM_DATE');"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
						</td>
						<td width='40%'> 
							<input type=text id="P_TO_DATE"  name='P_TO_DATE' id='P_TO_DATE' size="10" maxlength="10" align="center"  onBlur="if(validDateObj(this,'DMY','<%=locale%>'))validateDischargeToDate(this);" ><img  src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('P_TO_DATE');"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
						</td>
				</tr>
 
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>				
				<tr>

						<td align='left' width='30%' class="label"><fmt:message key="Common.NursingUnitCode.label" bundle="${common_labels}"/> &nbsp;</td>
						<td class='fields' width='30%'  >						
						<input type=text  name='P_NURSING_FROM' id='P_NURSING_FROM' size="4" maxlength="4" align="center"><input type='button' name='nursing_unit_code' id='nursing_unit_code' value='?' class='button' onclick='searchCode(this, P_NURSING_FROM)'>
						</td>
						<td class='fields' width='40%'> 						 	  
						  <input type=text  name='P_NURSING_TO' id='P_NURSING_TO' size="4" maxlength="4" align="center"><input type='button' name='nursing_unit_code' id='nursing_unit_code' value='?' class='button' onclick='searchCode(this, P_NURSING_TO)'>
						</td>
				</tr>

				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>		
				
               
				<tr>
						<td align='left' width='30%' class="label"><fmt:message key="Common.Discharge.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/> &nbsp;</td>
						<td width='30%'  >						
						
						<input type=text  name='P_FM_PRACTITIONER' id='P_FM_PRACTITIONER' size="15" maxlength="15" align="center"><input type='button' name='practitioner_id1' id='practitioner_id1' value='?' class='button' onclick='searchCode(this, P_FM_PRACTITIONER)'>		
						</td>
						<td class='fields' width='40%'> 
							
                       <input type=text  name='P_TO_PRACTITIONER' id='P_TO_PRACTITIONER' size="15" maxlength="15" align="center"><input type='button' name='practitioner_id2' id='practitioner_id2' value='?' class='button' onclick='searchCode(this, P_TO_PRACTITIONER)'>
					   </td>   
				</tr>
			

				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>

	<tr>
		<td class="label"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/> &nbsp;</td>
		<td class='fields'>			
		<input type=text  name='P_SPECIALITY_FROM' id='P_SPECIALITY_FROM' size="4" maxlength="4" align="center" ><input type='button' name='Speciality' id='Speciality' value='?' class='button' onclick='searchCode(this, P_SPECIALITY_FROM)'>
		</td>		
		<td class='fields'>		 
		<input type=text  name='P_SPECIALITY_TO' id='P_SPECIALITY_TO' size="4" maxlength="4" align="center" ><input type='button' name='Speciality' id='Speciality' value='?' class='button' onclick='searchCode(this, P_SPECIALITY_TO)'>
		</td>
	</tr>		
	
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr> 
				<tr>
		<td class="label"><fmt:message key="Common.service.label" bundle="${common_labels}"/>&nbsp; <fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
		<td class='fields'>
		<input type='text' id='' name='P_SERVICE_FROM' id='P_SERVICE_FROM' size='15'  maxLength='10' ><input type='button' name='spec' id='spec' value='?' class='button' onclick='searchServices(this,from_service,P_SERVICE_FROM)'  >
		<input type="hidden" name="from_service" id="from_service" id='' value="">
		</td>
		
		<td class='fields'><input type='text' id='' name='P_SERVICE_TO' id='P_SERVICE_TO' size='15'  maxLength='10' ><input type='button' name='spec' id='spec' value='?' class='button' onclick='searchServices(this,to_service,P_SERVICE_TO)'  >
		<input type="hidden" name="to_service"  id='to_service' value="">
		</td>
	</tr>
	<tr>
	<td>&nbsp;</td>
	<Td>&nbsp;</td>
	</tr>
	<tr>
		<td class="label"><fmt:message key="Common.Discharge.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Summary.label" bundle="${common_labels}"/></td>
		<td class='fields'>
		<select name="P_DISCHARGE_SUM_FLAG" id="P_DISCHARGE_SUM_FLAG">
	    <option value="B"><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
		<option value="Y"><fmt:message key="Common.yes.label" bundle="${common_labels}"/></option>
		<option value="N"><fmt:message key="Common.no.label" bundle="${common_labels}"/></option>
		
		</select>
		</td>		
		<td class='fields'>&nbsp;</td>
	</tr>
	<tr>
	<td>&nbsp;</td>
	<Td>&nbsp;</td>
	</tr>
							
				</table>	
	</td>
</tr>
</table>
		
	<input type="hidden" name="P_facility_id" id="P_facility_id" value="<%=p_facility_id%>">
	<input type="hidden" name="p_module_id" id="p_module_id"	value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id"	value="<%= p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%= p_user_name %>">	
	<input type="hidden" name="language" id="language" value="<%=locale%>">
	<input type="hidden" name="p_location_type" id="p_location_type" value="IP">
	<input type="hidden" name="CurrentDate" id="CurrentDate" value="<%=CurrentDate%>">


</form>
</BODY>
</HTML>
<%
} catch(Exception e) {  /* out.println("in else "+e); */ e.printStackTrace();}
finally
{
	ConnectionManager.returnConnection(con,request);
}
%>

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

