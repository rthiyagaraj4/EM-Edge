<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*, webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
 <% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	request.setCharacterEncoding("UTF-8"); 
	String p_module_id		= "IP" ;
	String p_report_id		= "IPBPRFNU" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
%>
<html>	
<HEAD>
<TITLE></TITLE>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src="../../eCommon/js/ValidateControl.js" language='JavaScript'></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
async function searchCode(obj,target)
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
			var from_pract_type = RepPractNursingUnitForm.fm_pract_type.value;
			var to_pract_type = RepPractNursingUnitForm.to_pract_type.value;
			
			if(obj.name=="practitioner_id1")
			{
				var tit=getLabel('Common.practitioner.label','common')
				sql  = " select Practitioner_id,Practitioner_name from am_pract_for_facility_vw "
				sql += " where operating_facility_id= `<%= p_facility_id %>` and PRACT_TYPE=nvl(`"+from_pract_type+"`,PRACT_TYPE) ";
				search_code="practitioner_id";
				search_desc= "Practitioner_name";
			}

			if(obj.name=="practitioner_id2")
			{
				var tit=getLabel('Common.practitioner.label','common')
				sql  = " select Practitioner_id,Practitioner_name from am_pract_for_facility_vw "
				sql += " where operating_facility_id= `<%= p_facility_id %>`  and PRACT_TYPE=nvl(`"+to_pract_type+"`,PRACT_TYPE) ";
				search_code="practitioner_id";
				search_desc= "Practitioner_name";
			}

			if(obj.name=="nursing_unit_code")
			{
				tit=getLabel('Common.nursingUnit.label','common');
				sql="select nursing_unit_code, short_desc from ip_nursing_unit where facility_id=`<%= p_facility_id%>` ";
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
</script>
</HEAD>

<BODY onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<br>
<br>
<form name="RepPractNursingUnitForm" id="RepPractNursingUnitForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<%
    Connection con  =  null;
    Statement stmt = null;

    StringBuffer sql = new StringBuffer();
    sql.append("Select PRACT_TYPE, DESC_USERDEF From AM_PRACT_TYPE Where EFF_STATUS = 'E' order by 2" );
    ResultSet rset = null;
	StringBuffer StrVal = new StringBuffer();

    try
	{
		con  =  ConnectionManager.getConnection(request);
		stmt = con.createStatement(); 
		rset = stmt.executeQuery(sql.toString());


		if(rset != null)
		{
			while(rset.next())
			{
				StrVal.append(" <option value='"+rset.getString(1)+"'>"+rset.getString(2)+"</option> ");
			}
		}
	 }
	 catch(Exception e){/* out.println(e); */ e.printStackTrace();}
	 finally
	 {
		try
		 {
			if(rset != null)    rset.close();
			if(stmt != null)    stmt.close();
		 }
		 catch(Exception e)
		 {/* out.println("Exception in tryCatch : "+ e.toString()); */ e.printStackTrace();}
		if(con!=null) ConnectionManager.returnConnection(con,request);
	 }
%>
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

				<tr>
						<td align='left' width='30%' class="label"><fmt:message key="Common.NursingUnitCode.label" bundle="${common_labels}"/> &nbsp;</td>
						<td class="fields" width='20%'  >
							<input type=text  name='p_fm_nursing_unit' id='p_fm_nursing_unit' size="4" maxlength="4" align="center"><input type='button' name='nursing_unit_code' id='nursing_unit_code' value='?' class='button' onclick='searchCode(this, p_fm_nursing_unit)'>
						</td>
						<td class="fields"  width='40%'> 
							<input type=text  name='p_to_nursing_unit' id='p_to_nursing_unit' size="4" maxlength="4" align="center"><input type='button' name='nursing_unit_code' id='nursing_unit_code' value='?' class='button' onclick='searchCode(this, p_to_nursing_unit)'>
						</td>
				</tr>
			
				<tr>
					<td class="label">&nbsp;</td>
					<Td class="label">&nbsp;</td>
				</tr>								

                <tr>
                    <td align='left' width='30%' class="label"><fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
                    <td class="fields" width='30%'><select name="fm_pract_type" id="fm_pract_type">
						<option value="">---&nbsp; <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;---</option>
						<%=StrVal.toString()%>
						</select>
					</td>
                    <td class="fields" width='40%'><select name="to_pract_type" id="to_pract_type">
						<option value="">---&nbsp;<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;---</option>
						<%=StrVal.toString()%>
						</select>
					</td>
                </tr>
                <tr>
                    <td class="label">&nbsp;</td>
                    <td class="label">&nbsp;</td>
                </tr>
			
				<tr>
						<td align='left' width='20%' class="label"><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
						<td class="fields" width='30%'  >
							<input type=text  name='p_fm_pract' id='p_fm_pract' size="15" maxlength="15" align="center"><input type='button' name='practitioner_id1' id='practitioner_id1' value='?' class='button' onclick='searchCode(this, p_fm_pract)'>
						</td>
						<td class="fields" width='30%'> 
							<input type=text  name='p_to_pract' id='p_to_pract' size="15" maxlength="15" align="center"><input type='button' name='practitioner_id2' id='practitioner_id2' value='?' class='button' onclick='searchCode(this, p_to_pract)'>
						</td>
				</tr>
			
				<tr>
					<td class="label">&nbsp;</td>
					<Td class="label">&nbsp;</td>
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

