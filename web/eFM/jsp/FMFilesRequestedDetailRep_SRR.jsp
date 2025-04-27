<!DOCTYPE html>
<%@ page import="java.util.*, java.sql.*, webbeans.eCommon.*" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
	Connection con = ConnectionManager.getConnection(request);
	PreparedStatement	pstmt = null;
	ResultSet			rs	  = null;
	//String dmy="DMY";
	String	facility_id = (String)session.getValue("facility_id");
	String	user_id		= (String)session.getValue("login_user");
	String  facilityVal = "<select name='p_req_to_facility' id='p_req_to_facility'><option value=''>--------------- "+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") + " ---------------</option>";

	try
	{
		pstmt = con.prepareStatement("Select facility_id,facility_name from sm_facility_param_lang_vw where facility_id != '"+facility_id+"' and language_id='"+localeName+"' order by facility_name"); 
		rs = pstmt.executeQuery();

		String fcy_code = "";
		String fcy_desc = "";

		if(rs != null)
		{
			while(rs.next())
			{
				fcy_code = rs.getString(1);
				fcy_desc = rs.getString(2);

				facilityVal = facilityVal + "<option value='"+fcy_code+"'>"+fcy_desc+"</option>";
			}
		}
		facilityVal = facilityVal + "</select>";
	if(rs != null)		rs.close();
	if(pstmt != null)	pstmt.close();
	}
	catch(Exception e)
	{	out.println(e);		}

	finally
	{		
		ConnectionManager.returnConnection(con,request);
	}
%>
<html>
<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>	
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language='javascript' src='../../eFM/js/FMFilesRequestedRep_SRR.js'></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



	<script>	
	function showFacilities(Obj)
	{
		if(Obj.value == "E")
			document.getElementById("facility_id_vals").innerHTML = "<%=facilityVal%>";
		else
			document.getElementById("facility_id_vals").innerHTML = "";
	}
	</script>
</head>
<body onMouseDown='CodeArrest()' onLoad='FocusFirstElement()' onKeyDown = 'lockKey();'>

	<form name='FMFilesRequested' id='FMFilesRequested' action="../../eCommon/jsp/report_options.jsp" method='' target='messageFrame'>
	<table cellpadding='3' cellspacing='0' border='0' width='90%' align='center'>
	<br>
	<tr><td colspan='4'>&nbsp;</td></tr>
	<tr>
		<td  class='label' width='25%' nowrap><fmt:message key="eFM.FSLocationIdentity.label" bundle="${fm_labels}"/></td>
		<td  width='25%'><select name='p_locn_identity' id='p_locn_identity' onChange='displayListVals(this);'>
		<option value=''>------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ------</option>
		<option value='D'><fmt:message key="Common.department.label" bundle="${common_labels}"/></option> 
		<option value='C'><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option> 
		<option value='N'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
		<option value='E'><fmt:message key="Common.ProcedureUnit.label" bundle="${common_labels}"/></option>
		<option value='Y'><fmt:message key="Common.DaycareUnit.label" bundle="${common_labels}"/></option>
		<option value='T'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option>
		</select></td>
		<td class='label' width='10%' id='facility_label'>&nbsp;</td>
		<td width='40%' id='facility_vals' class='fields'>&nbsp;</td>
	</tr>
	<tr><td colspan='2'></td>
		<td  class='label'  id='facility_id_label'></td>
		<td  class='fields' id='facility_id_vals'></td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td class='querydata' ><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
		<td>&nbsp;</td>
		<td class='querydata' ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td></tr>
	<tr>
		<td class='label'><fmt:message key="eFM.FSLocationCode.label" bundle="${fm_labels}"/></td>
		<td class='fields'><input type='text' name='p_fm_locn_code' id='p_fm_locn_code' size='8' maxlength='8'  onKeyPress='return CheckForSpecChars(event)' readOnly><input type='button' class='button' name='location1' id='location1' value='?'  onClick="searchCode(this, p_fm_locn_code);" disabled></td>
		<td  class='label'>&nbsp;</td>
		<td class='fields'><input type='text' name='p_to_locn_code' id='p_to_locn_code' size='8' maxlength='8' onKeyPress='return CheckForSpecChars(event)' readOnly><input type='button' class='button' name='location2' id='location2' value='?'  onClick="searchCode(this, p_to_locn_code);" disabled></td>
	</tr>

	<tr>
		<td  class='label'><fmt:message key="Common.ReasonCode.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type='text' name='p_fm_narration' id='p_fm_narration' size='8' maxlength='8' onKeyPress='return CheckForSpecChars(event)' ><input type='button' class='button' name='narration' id='narration' value='?'  onClick="searchCode(this, p_fm_narration);"></td>
		<td  class='label'></td>
		<td class='fields'><input type='text' name='p_to_narration' id='p_to_narration' size='8' maxlength='8' onKeyPress='return CheckForSpecChars(event)' ><input type='button' class='button' name='narration' id='narration' value='?'  onClick="searchCode(this, p_to_narration);"></td>
	</tr>
 <tr>
               <td width='35%'  class='label' ><fmt:message key="Common.date.label" bundle="${common_labels}"/> <fmt:message key="Common.criteria.label" bundle="${common_labels}"/>
	           </td>
				<td  class='fields' ><select name="p_date_criteria" id="p_date_criteria"  onchange='date_cri_link(this,"");' > 
			    <option value='1' selected><fmt:message key="Common.Request.label" bundle="${common_labels}"/> <fmt:message key="Common.date.label" bundle="${common_labels}"/> </option>
			    <option value='2' > <fmt:message key="eFM.RequireonDate.label" bundle="${fm_labels}"/> </option> </select></td>
			   </tr>
		<tr>
		<table cellpadding='3' cellspacing='0' border='0' width='90%' align='center'>
		<tr>
		<td  class='label' width='34%' id='test'><fmt:message key="Common.Request.label" bundle="${common_labels}"/> <fmt:message key="Common.date.label" bundle="${common_labels}"/> </td>
		<td class='fields' width='34%' id='test1'>&nbsp;&nbsp<input type='text5' id="fm_date" name='p_fm_date' id='p_fm_date' size='10' maxlength='10' onblur='if(validDateObj(this,"DMY","<%=localeName%>")){setDate(this);}'><img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('fm_date');"/> </td>
		<td  class='label' id='test2'></td>
		<td class='fields' width='30%'  id='test3'><input type='text' id="to_date" name='p_to_date' id='p_to_date' size='10' maxlength='10' onblur='if(validDateObj(this,"DMY","<%=localeName%>")){setDate(this);}'><img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('to_date');"/></td>
	</tr> 
  </table>
  </tr> 
	<tr>
		<table cellpadding='3' cellspacing='0' border='0' width='90%' align='center'>
		<tr>
		<td  class='label' width='35%' ><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
		<td class='fields' ><select name='p_status' id='p_status' onChange=''>
		<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
		<option value='P'><fmt:message key="Common.Pending.label" bundle="${common_labels}"/></option> 
		<option value='I'><fmt:message key="Common.Issued.label" bundle="${common_labels}"/></option> 
		<option value='C'><fmt:message key="Common.cancelled.label" bundle="${common_labels}"/></option> 
		</select></td>
		<td class='label' width=''>&nbsp;</td>
		<td width=''>&nbsp;</td>
	</tr>
</table>
</tr>
	<tr>
		<table cellpadding='3' cellspacing='0' border='0' width='90%' align='center'>
		<tr>
		<td class='label' width='35%' ><fmt:message key="Common.ReportBy.label" bundle="${common_labels}"/></td>
		<td class='fields' ><select name='p_group_by' id='p_group_by' onChange=''>
		<option value='S'><fmt:message key="Common.source.label" bundle="${common_labels}"/></option> 
		<option value='N'><fmt:message key="Common.reason.label" bundle="${common_labels}"/></option> 
		</select></td>
		<td class='label' width=''>&nbsp;</td>
		<td width=''>&nbsp;</td>
	</tr>
   </table>
   </tr>
</table>

		<input type="hidden" name="p_facility_id" id="p_facility_id"		value='<%=facility_id%>'>
		<input type="hidden" name="p_module_id" id="p_module_id" 		value='FM'>
		<input type="hidden" name="p_report_id" id="p_report_id" 		value='FMBFRQSN'>
 		<input type="hidden" name="p_user_name" id="p_user_name"		    value='<%=user_id%>'> 
		<%-- <INPUT TYPE="hidden" name="p_language_id" id="p_language_id" value="<%=localeName%>"> --%>
	</form>
</body>
</html>

