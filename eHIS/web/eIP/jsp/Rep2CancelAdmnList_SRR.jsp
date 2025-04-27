<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*, webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	request.setCharacterEncoding("UTF-8"); 
	String p_module_id		= "IP" ;
	String p_report_id		= "IPBADCLT" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String locale = (String)session.getAttribute("LOCALE");
	Connection				con		=	null;
	ResultSet				rs	=	null; 
	Statement				stmt	=	null;
%>

<html>	
<HEAD>
<TITLE></TITLE>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
async function searchCode(obj,target)
	{
			var retVal = 	new String();
			var locale= "<%=locale%>"
			var dialogHeight= "28" ;
			var dialogWidth	= "43" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			
			if(obj.name=="nursing_unit_code")
			{
				tit=getLabel('Common.nursingUnit.label','common');
				//sql="select nursing_unit_code, short_desc from ip_nursing_unit where facility_id=`<%= p_facility_id%>` ";
				sql="select nursing_unit_code, short_desc from ip_nursing_unit_lang_vw where facility_id=`<%= p_facility_id%>` and language_id=`"+locale+"` ";
				search_code="nursing_unit_code";
				search_desc= "short_desc";
			}

			if(obj.name=="Speciality")
			{
				var tit=getLabel('Common.speciality.label','common');
				//sql="select speciality_code, short_desc from am_speciality ";
				sql="select speciality_code, short_desc from am_speciality_lang_vw where language_id=`"+locale+"` ";
				search_code="speciality_code";
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


	function ChangeState(obj)
	{

	if ( Rep2CancelAdmnListForm.current_patient_yn.checked == true)
		{
			Rep2CancelAdmnListForm.current_patient_yn.value="Y";
		}
		else
		{
			Rep2CancelAdmnListForm.current_patient_yn.cheked=false;
			Rep2CancelAdmnListForm.current_patient_yn.value="N";
		}
	}

	function beforeGetAuthorised(target_id,target)
{
	if(document.forms[0].cancelled_hid.value != document.forms[0].P_CANCEL_BY.value)
	{
		if(document.forms[0].P_CANCEL_BY.value != "")
			 getAuthoriser(target_id,target);
	}
}

function getAuthoriser(target_id,target) 
{
	var facility_id = document.forms[0].p_facility_id.value;
	var locale = document.forms[0].locale.value;

	var title = getLabel("Common.cancelledby.label","Common");

	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

	var sql = "select APPL_USER_ID code, APPL_USER_NAME description from SM_APPL_USER_LANG_VW where language_id='"+locale+"' and EFF_STATUS = 'E' and upper(APPL_USER_ID) like upper(nvl(?,APPL_USER_ID)) and upper(APPL_USER_NAME) like upper(nvl(?,APPL_USER_NAME)) ";

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4]="1,2";
	argumentArray[5]=target.value;
	argumentArray[6]=CODE_DESC_LINK;
	argumentArray[7]=CODE_DESC;
			
	var retVal = CommonLookup(title,argumentArray);
	
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		document.forms[0].cancelled_hid.value		=	arr[1];		
		document.forms[0].P_CANCEL_BY.value	=	arr[0];
		document.forms[0].P_CANCEL_BY.focus();
		document.forms[0].cancelled_hid.value		= document.forms[0].P_CANCEL_BY.value;
	}
	else
	{
		document.forms[0].cancelled_hid.value		= "";		
		document.forms[0].P_CANCEL_BY.value	= "";
	}
}

function chkWithSysDt(obj){
		if(obj.value!=''){

			if(isBeforeNow(obj.value,"DMY",localeName))
				return true;
			else {
				alert(getMessage("START_DATE_GREATER_SYSDATE","COMMON"));
				obj.select();
				obj.focus();
				return false ;
			}
		}
}

</script>
</HEAD>

<BODY onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<br>
<br>
<form name="Rep2CancelAdmnListForm" id="Rep2CancelAdmnListForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>

		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>
	<tr>

		<td width="100%" class="Border" align='center'>

			<table  width='80%' cellPadding="0" cellSpacing="0"  align='center' >

				<tr>
					<td align="center" width="35%">&nbsp;</td>
					<td class="querydata" width="20%" style="font-weight: bold;"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td class="querydata" width="40%" style="font-weight: bold;"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
	
				</tr>								

				<tr>
					<td align='right' width='30%' class="label" nowrap><fmt:message key="Common.NursingUnitCode.label" bundle="${common_labels}"/> &nbsp;</td>
					<td width='40%'> 
						&nbsp;<input type=text  name='p_fm_nursing_unit' id='p_fm_nursing_unit' size="4" maxlength="4" align="center"><input type='button' name='nursing_unit_code' id='nursing_unit_code' value='?' class='button' onclick='searchCode(this, p_fm_nursing_unit)'>
					</td>
					<td width='40%'> 
						<input type=text  name='p_to_nursing_unit' id='p_to_nursing_unit' size="4" maxlength="4" align="center"><input type='button' name='nursing_unit_code' id='nursing_unit_code' value='?' class='button' onclick='searchCode(this, p_to_nursing_unit)'>
					</td>
				</tr>

				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>	

				<tr>
						<td align='right' width='30%' class="label"><fmt:message key="Common.roomno.label" bundle="${common_labels}"/>&nbsp;</td>
						<td width='40%'> 
							&nbsp;<input type=text  name='p_fm_assign_room_num' id='p_fm_assign_room_num' size="4" maxlength="4" align="center">
						</td>
						<td width='40%'> 
							<input type=text  name='p_to_assign_room_num' id='p_to_assign_room_num' size="4" maxlength="4" align="center">
						</td>
				</tr>
			
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>

				<tr>
						<td align='right' width='30%' class="label"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/> &nbsp;</td>
						<td width='40%'> 
							&nbsp;<input type=text  name='p_fm_specialty_code' id='p_fm_specialty_code' size="4" maxlength="4" align="center"><input type='button' name='Speciality' id='Speciality' value='?' class='button' onclick='searchCode(this, p_fm_specialty_code)'>
						</td>
						<td width='40%'> 
							<input type=text  name='p_to_specialty_code' id='p_to_specialty_code' size="4" maxlength="4" align="center"><input type='button' name='Speciality' id='Speciality' value='?' class='button' onclick='searchCode(this, p_to_specialty_code)'>
						</td>
				</tr>

				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>

				<tr>
						<td align='right' width='30%' class="label"><fmt:message key="eIP.CancelledDate.label" bundle="${ip_labels}"/> &nbsp;</td>
						<td width='40%'> 
							&nbsp;<input type=text id="can_date_from" name='p_fm_adt_status_set_on_date' id='p_fm_adt_status_set_on_date' size="10" maxlength="10" align="center" onblur='if(validDateObj(this,"DMY","<%=localeName%>")){chkWithSysDt(this);}'><img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('can_date_from');"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
						</td>
						<td width='40%'> 
							<input type=text id="can_date_to"  name='p_to_adt_status_set_on_date' id='p_to_adt_status_set_on_date' size="10" maxlength="10" align="center" onblur='if(validDateObj(this,"DMY","<%=localeName%>")){chkWithSysDt(this);}'><img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('can_date_to');"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
						</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>

				<tr>
				<td align='right' width='30%' class="label" nowrap><fmt:message key="eIP.CurrentInpatientsOnly.label" bundle="${ip_labels}"/> &nbsp;</td>
				<td  width='40%' class="fields"><input type='checkbox' name='current_patient_yn' id='current_patient_yn'  value = 'N' onClick="ChangeState(this)"> </td>
				</td>	
				</tr>
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
		
       <tr>
			<td  class="label" width="35%"  align='right' nowrap><fmt:message key="eIP.ReasonforCancel.label" bundle="${ip_labels}"/>&nbsp;&nbsp;</td>
			<td class="fields" >
				<select name='P_REASON_CANCEL' id='P_REASON_CANCEL' > 
				<option value="">-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>

          <%try{
			
			  String str = " Select Contact_Reason_Code, Contact_reason from AM_CONTACT_REASON where eff_status = 'E' and Cancel_Admission_Yn = 'Y'  ";
        con		=	ConnectionManager.getConnection(request);
		stmt = con.createStatement();
		rs = stmt.executeQuery(str);
		if(rs != null)
					{
						while(rs.next())
						{
							String desc = rs.getString("Contact_reason")== null ? "" : rs.getString("Contact_reason");
                            String code = rs.getString("Contact_Reason_Code")==null ? "":rs.getString("Contact_Reason_Code");
                            out.print("<option value='"+code+"' >"+desc );
							
						}
			    if(rs!=null) rs.close();
			     if(stmt!=null) stmt.close();
					}

%>

		  
				</td>
				</select>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
<tr>
			<td class="label" ><fmt:message key="Common.cancelledby.label" bundle="${common_labels}"/></td>
			<td class='fields' ><input type="text" name="P_CANCEL_BY" id="P_CANCEL_BY" maxlength="16" size="16" value="" onBlur='beforeGetAuthorised(document.forms[0].cancelled_hid,this);'><input type=button class='button' name='search_Authorised' id='search_Authorised' value='?' onclick="getAuthoriser(document.forms[0].cancelled_hid,document.forms[0].P_CANCEL_BY)"><input type=hidden name="cancelled_hid" id="cancelled_hid" value=''></td>
			</tr>

		</table>

	</td>
</tr>
</table>
	<%if(localeName.equals("en"))
	{%>
	<!-- <INPUT TYPE="hidden" name="p_passing_local_date" id="p_passing_local_date" value="N"> -->
	<%}
	else if(localeName.equals("th"))
	{%>
	<INPUT TYPE="hidden" name="P_passing_local_date" id="P_passing_local_date" value="Y">
	<%}%>
	

	<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%= p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id" 	value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" 	value="<%= p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"		value="<%= p_user_name %>">
	<input type="hidden" name="p_current_patient_yn" id="p_current_patient_yn"		value="N">
	<input type="hidden" name="locale" id="locale"		value="<%=locale%>">

</form>
<script>
 document.forms[0].p_fm_nursing_unit.focus();
</script>
</BODY>
</HTML>
<%  }catch(Exception e){
  }finally 
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

