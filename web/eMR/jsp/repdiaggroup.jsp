<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>

<%

	request.setCharacterEncoding("UTF-8");
	String p_module_id		= "MR" ;
	String p_report_id		= "MRBDIGRP" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
%>

<html>
<HEAD>
<TITLE></TITLE>
   <%String sStyle	=
   (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
async function searchCode(obj,target)
	{
			var retVal = 	new String();
			var dialogHeight= "28vh" ;
			var dialogWidth	= "43vw" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";

			var from_pract_type = repDiagGroup.fm_pract_type.value;
			var to_pract_type = repDiagGroup.to_pract_type.value;

			if(target.name == 'p_fm_diag_code' || target.name == 'p_to_diag_code')
			{
			tit=getLabel("eMR.DiagGroup.label","MR");
			sql="select diag_group_code ,diag_group_desc from mr_diag_group ";
			search_code="diag_group_code";
			search_desc= "diag_group_desc"
			}
			else
			if(target.name == 'p_fm_sp_code' || target.name == 'p_to_sp_code')
			{
			tit=getLabel("Common.speciality.label","Common");
			sql="select speciality_code,short_desc from am_speciality ";
			search_code="speciality_code";
			search_desc= "short_desc"
			}
			else
			if(target.name == 'p_fm_fac_id' || target.name == 'p_to_fac_id')
			{
			tit=getLabel("Common.facility.label","Common");
			sql="select facility_id,facility_name   from sm_facility_param ";
			search_code="facility_id";
			search_desc= "facility_name";
			}
			else
			if(target.name == 'p_fm_pract_id')
			{
			tit=getLabel("Common.practitioner.label","Common");
			sql="select practitioner_id,practitioner_name from am_practitioner where PRACT_TYPE=nvl(`"+from_pract_type+"`,PRACT_TYPE) ";
			search_code="practitioner_id";
			search_desc= "practitioner_name";
			}
			else
			if(target.name == 'p_to_pract_id')
			{
			tit=getLabel("Common.practitioner.label","Common");
			sql="select practitioner_id,practitioner_name from am_practitioner where PRACT_TYPE=nvl(`"+to_pract_type+"`,PRACT_TYPE) ";
			search_code="practitioner_id";
			search_desc= "practitioner_name";
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

</script>


</HEAD>

<BODY onload='FocusFirstElement()' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<br>
<br>
<form name="repDiagGroup" id="repDiagGroup" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<%
    Connection con  =  ConnectionManager.getConnection(request);
    Statement stmt = con.createStatement();
    String sql = "" ;
    sql = "Select PRACT_TYPE, DESC_USERDEF From AM_PRACT_TYPE Where EFF_STATUS = 'E' order by 2" ;
    ResultSet rset = stmt.executeQuery(sql);
	StringBuffer StrVal = new StringBuffer("");

    try
    {
		if(rset != null)
		{
			while(rset.next())
			{
				StrVal.append("<option value='"+rset.getString(1)+"'>"+rset.getString(2)+"</option>");
			}
		}
	 }
	 catch(Exception e){/* out.println(e); */ e.printStackTrace();}  
	 finally
	 {
		if(rset != null)    rset.close();
		if(stmt != null)    stmt.close();
		if(con!=null) ConnectionManager.returnConnection(con,request);
	 }

%>

<table width='80%' align='center' valign='top'>

		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>

	<tr>

		<td width="100%" class="Border" align='center'>

				<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >
					<tr>
						<td align='right' width='30%' class="label"><fmt:message key="Common.GroupType.label" bundle="${common_labels}"/>&nbsp;</td>
						<td width='20%' colspan = 3><select name = p_group_type>
							<option value = ''> --- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---
							<option value = 'D'> <fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/>
							<option value = 'P'> <fmt:message key="Common.Procedure.label" bundle="${common_labels}"/>
						</select>
						</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<Td>&nbsp;</td>
					</tr>
					<tr>
						<td align="center" width="35%">&nbsp;</td>
						<td class="querydata" width="20%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
						<td class="querydata" width="40%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					</tr>

					<tr>
						<td align='right' width='30%' class="label"><fmt:message key="eMR.DiagGroup.label" bundle="${mr_labels}"/>&nbsp;</td>
						<td width='20%'  ><input type=text  name='p_fm_diag_code' id='p_fm_diag_code' size="4" maxlength="4" align="center"><input type='button' name='diagCode' id='diagCode' value='?' class='button' onclick='searchCode(this, p_fm_diag_code)'>
						</td>
						<td width='40%'> <input type=text  name='p_to_diag_code' id='p_to_diag_code' size="4" maxlength="4" align="center"><input type='button' name='diagCode1' id='diagCode1' value='?' class='button' onclick='searchCode(this, p_to_diag_code)'>
						</td>
				</tr>

				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>

				<tr>
						<td align='right' width='30%' class="label"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/>&nbsp;</td>
						<td width='20%'  ><input type=text  name='p_fm_sp_code' id='p_fm_sp_code' size="4" maxlength="4" align="center"><input type='button' name='speciality' id='speciality' value='?' class='button' onclick='searchCode(this, p_fm_sp_code)'>
						</td>
						<td width='40%'> <input type=text  name='p_to_sp_code' id='p_to_sp_code' size="4" maxlength="4" align="center"><input type='button' name='speciality1' id='speciality1' value='?' class='button' onclick='searchCode(this, p_to_sp_code)'>
						</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>

				<tr>
					<td align='right' width='30%' class="label"><fmt:message key="Common.facility.label" bundle="${common_labels}"/>&nbsp;</td>
					<td width='20%'  ><input type=text  name='p_fm_fac_id' id='p_fm_fac_id' size="2" maxlength="2" align="center"><input type='button' name='facility' id='facility' value='?' class='button' onclick='searchCode(this, p_fm_fac_id)'>
					</td>
					<td width='40%'> <input type=text  name='p_to_fac_id' id='p_to_fac_id' size="2" maxlength="2" align="center"><input type='button' name='facility1' id='facility1' value='?' class='button' onclick='searchCode(this, p_to_fac_id)'>
					</td>
				</tr>

				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
                <tr>
                    <td align='right' width='30%' class="label"><fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/>&nbsp;</td>
                    <td width='20%'><select name="fm_pract_type" id="fm_pract_type">
						<option value="">&nbsp;------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -------&nbsp;</option>
						<%=StrVal.toString()%>
						</select>
					</td>
                    <td width='40%'><select name="to_pract_type" id="to_pract_type">
						<option value="">&nbsp;------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -------&nbsp;</option>
						<%=StrVal.toString()%>
						</select>
					</td>
                </tr>
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>

				<tr>
					<td align='right' width='30%' class="label"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>&nbsp;</td>
					<td width='20%'  ><input type=text  name='p_fm_pract_id' id='p_fm_pract_id' size="15" maxlength="15" align="center"><input type='button' name='practitioner' id='practitioner' value='?' class='button' onclick='searchCode(this, p_fm_pract_id)'>
					</td>
					<td width='40%'> <input type=text  name='p_to_pract_id' id='p_to_pract_id' size="15" maxlength="15" align="center"><input type='button' name='practitioner1' id='practitioner1' value='?' class='button' onclick='searchCode(this, p_to_pract_id)'>
					</td>
				</tr>

				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
				<tr>
					<td align='right' width='30%' class="label">
						<fmt:message key="Common.orderBy.label" bundle="${common_labels}"/> &nbsp;
					</td>
					<td  width='20%' align="left">
						<select name='p_order_by' id='p_order_by'>
						<option value='1'><fmt:message key="Common.code.label" bundle="${common_labels}"/>
						<option value='2'><fmt:message key="Common.description.label" bundle="${common_labels}"/>
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
	<input type="hidden" name="p_user_name" id="p_user_name"		value="<%= p_user_name %>">

</form>
</BODY>
</HTML>

