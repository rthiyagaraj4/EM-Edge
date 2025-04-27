<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,webbeans.eCommon.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%@ page import="java.sql.*,webbeans.eCommon.*" %>
 
<%
    request.setCharacterEncoding("UTF-8"); 
	String p_module_id		= "IP" ;
	String p_report_id		= "IPBDRCSP" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String locale					= (String)session.getAttribute("LOCALE");
	String isSpltyNurUnitToEnableYNAppl="";
	Connection con = ConnectionManager.getConnection(request);
	isSpltyNurUnitToEnableYNAppl = eIP.IPCommonBean.getSpltyNurUnitToEnableYN(con);//Added by shanmukh on 3rd-OCT-2018 for ML-MMOH-CRF-1115.1
	Statement stmt=null;
	ResultSet rs =null;
	String str = "select to_char(sysdate,'dd/mm/yyyy') from dual";
	String CurrentDate="";
	try{
		stmt=con.createStatement();
		rs = stmt.executeQuery(str);	
		while (rs.next())
			CurrentDate= rs.getString(1);
		CurrentDate = DateUtils.convertDate(CurrentDate,"DMY","en",locale);
	}
	catch(Exception e)
	{e.printStackTrace();}
	finally
	{
		if(stmt!=null) stmt.close();
		if(rs!=null)	rs.close();
		ConnectionManager.returnConnection(con,request);
	}
%>

<html>	
<HEAD>
<TITLE></TITLE>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<!--<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link>-->
 <link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>    
 <script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
  <script language="JavaScript" src="../../eCommon/js/common.js"></script>
  <script src="../../eCommon/js/ValidateControl.js" language='JavaScript'></script>
  <script src='../../eCommon/js/dchk.js' language='javascript'></script>
  <script src="../../eCommon/js/CommonCalendar.js" language='JavaScript'></script>
  <script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	
	<script>
  async	function searchCode(obj,target)
		{
				var retVal = 	new String();
				var dialogHeight= "400px" ;
				var dialogWidth="900px";
				/* var dialogHeight= "28" ;
				var dialogWidth	= "43" ; */
				var status = "no";
				var arguments	= "" ;
				var sql="";
				var search_code="";
				var search_desc="";
				var tit="";
	
				//alert(obj.name)
				if(obj.name=="speciality_code")
				{
					tit="Speciality"
					sql="select speciality_code,short_desc from am_speciality_lang_vw where language_id = `<%=locale%>` and eff_status = `E` ";
					search_code="speciality_code";
					search_desc= "short_desc";
				}
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
				retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);
	
				if (!(retVal == null))
				{
					target.value=retVal;
				}
				else
					target.focus();
		}
		/*
		function validate_date(obj) {
			
		var from = obj.value;
		var to  = document.forms[0].CurrentDate.value;

		var fromarray;
		var toarray;
		
		fromarray  = from.split("/");
		toarray    = to.split("/");

		var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
		var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
		
		if (CheckDate(obj)){
			
			if(Date.parse(todt) < Date.parse(fromdt)) {
					var invaldt = getMessage("DATE1_GT_DATE2",'IP') ;
					var census_date_from=getLabel("eIP.CensusDateRange.label","IP");
					var sys_date=getLabel("Common.CurrentDate.label","Common");
					invaldt=invaldt.replace('$',census_date_from);
					invaldt=invaldt.replace('#',sys_date);
					alert(invaldt);
					obj.value='';
					obj.focus();
					
				}
			}
		}*/
		/*
		IncidentNo:18844
		Date:Thursday, February 04, 2010
		Modi
		*/

		function validate_date(obj) {
		

		var sysDt=document.forms[0].CurrentDate.value;
          
		var msg;
        /*
		if(obj.name=='P_FM_TRN_DATE'){

			if(obj.value=='')
			document.forms[0].P_TO_TRN_DATE.value='';

		}*/
		
	if(CheckDate(obj)){
		if(obj.name=='P_TO_TRN_DATE'){
			sysDt=document.forms[0].P_FM_TRN_DATE.value;
			if(document.forms[0].P_FM_TRN_DATE.value !='' && document.forms[0].P_TO_TRN_DATE.value !=''){
				
				fromarray  = obj.value.split("/");
		toarray    = sysDt.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
		var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);

				if(Date.parse(todt) > Date.parse(fromdt)) {
					msg=getMessage("TO_DT_GR_EQ_FM_DT",'SM');
					alert(msg);
					obj.value='';
					obj.focus();
					return;
					}
			}
			sysDt=document.forms[0].CurrentDate.value;
		fromarray  = obj.value.split("/");
		toarray    = sysDt.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
		var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
				if(Date.parse(todt) < Date.parse(fromdt)) {

				//	msg=getMessage("START_DATE_GREATER_SYSDATE");
				//	alert(msg);
				//	obj.value='';
				//	obj.focus();
				//	return;
					msg=getMessage("DATE1_GT_DATE2",'IP');
					var census_date_from=getLabel("eIP.CensusDateRange.label","IP");
					var sys_date=getLabel("Common.CurrentDate.label","Common");
					msg=msg.replace('$',census_date_from);
					msg=msg.replace('#',sys_date);
					alert(msg);
					obj.value='';
					obj.focus();
					return;

					}
		}else{
			
			//if(document.forms[0].P_FM_TRN_DATE.value !=''){
				if(document.getElementById('census_date_from').value !=''){
			fromarray  = obj.value.split("/");
		toarray    = sysDt.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
		var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);

				if(Date.parse(todt) < Date.parse(fromdt)) {
					//msg=getMessage("START_DATE_GREATER_SYSDATE");
					//alert(msg);
					//obj.value='';
					//obj.focus();
					//return;
					msg=getMessage("DATE1_GT_DATE2",'IP');
					var census_date_from=getLabel("eIP.CensusDateRange.label","IP");
					var sys_date=getLabel("Common.CurrentDate.label","Common");
					msg=msg.replace('$',census_date_from);
					msg=msg.replace('#',sys_date);
					alert(msg);
					obj.value='';
					obj.focus();
					return;
					}
			}

			if(document.forms[0].census_date_to.value !=''){
				if(!doDateCheckAlert(obj,document.forms[0].census_date_to)){
					msg=getMessage("TO_DT_GR_EQ_FM_DT",'SM');
					alert(msg);
					document.forms[0].census_date_to.focus();
				}
			}

		}
	
	}
	else{
	}
}
</script>

</HEAD>

<BODY onMouseDown="CodeArrest();" onload="FocusFirstElement()" onKeyDown='lockKey()'>
<br>
<br>
<form name="Rep2DailyIPCensusSpecialityForm" id="Rep2DailyIPCensusSpecialityForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>

	<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>

	<tr>

		<td width="100%" class="Border" align='center'>

			<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >

	<tr>
    <td >&nbsp;</td>
   			<td class="querydata" width="20%" style="font-weight: bold;"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
			<td class="querydata" width="40%" style="font-weight: bold;"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
</tr>
				<tr>
					  <td align="left" class="label" ><fmt:message key="eIP.CensusDateRange.label" bundle="${ip_labels}"/>
					 
					<td width='20%'  >
					<input type=text  name='census_date_from'  id='census_date_from'  onblur = 'validate_date(this)' size="10" maxlength="10" align="center" ><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('census_date_from');"><img align='center' src='../../eMP/images/mandatory.gif'>

					</td>

					</td>	

					<td  width='40%' align='left'>
					<input type=text name='census_date_to' id='census_date_to' onblur = 'validate_date(this)' size="10" maxlength="10" align="center" ><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('census_date_to');"><img align='center' src='../../eMP/images/mandatory.gif'>
					</td>

   </td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
				<!-- Added by shanmukh on 3rd-OCT-2018 for ML-MMOH-CRF-1115.1 -->
				<%if(isSpltyNurUnitToEnableYNAppl.equals("N")){%>
					<tr>
					<jsp:include page="CommonSpecialityLookup.jsp">
					<jsp:param name="speciality_code_Appl" value="p_fr_speciality"/>
					<jsp:param name="speciality_to_code_Appl" value="p_to_speciality"/>
					</jsp:include>
					</tr>
				<%}else{%>
				<tr>
					<td align="center" width="35%">&nbsp;</td>
					<td class="querydata" width="20%" style="font-weight: bold;"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td class="querydata" width="40%" style="font-weight: bold;"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>				

				<tr>
						<td align="left" class="label" ><fmt:message key="Common.SpecialtyCode.label" bundle="${common_labels}"/> </td> 
						<td width='20%'  >
							<input type=text  name='p_fr_speciality' id='p_fr_speciality' size="4" maxlength="4" align="center"><input type='button' name='speciality_code' id='speciality_code' value='?' class='button' onclick='searchCode(this, p_fr_speciality)'>
						</td>
						<td width='40%'>
							<input type=text  name='p_to_speciality' id='p_to_speciality' size="4" maxlength="4" align="center"><input type='button' name='speciality_code' id='speciality_code' value='?' class='button' onclick='searchCode(this, p_to_speciality)'>
						</td>
				</tr><%}%>
				
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
				
				<tr>
							<td align="left" class="label" ><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td> 
						<td width='20%'>
							<select name='p_order_by' id='p_order_by'>
							<option value="1"><fmt:message key="Common.Specialty.label" bundle="${common_labels}"/></option>
							<option value="13"><fmt:message key="eIP.PercentageofOccupancy.label" bundle="${ip_labels}"/></option>
							</select>
						</td>
				</tr>
				
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>

		</table>
	</td>
</tr>
</table>

	<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
	<input type="hidden" name="CurrentDate" id="CurrentDate"			value="<%= CurrentDate %>">

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

