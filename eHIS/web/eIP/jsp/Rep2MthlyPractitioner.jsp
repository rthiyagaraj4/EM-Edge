<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*, webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
 <% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	request.setCharacterEncoding("UTF-8"); 
	String p_module_id		= "IP" ;
	String p_report_id		= "IPBPRMY" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String p_resp_id		= (String) session.getValue("responsibility_id");
	String locale			= (String)session.getAttribute("LOCALE");
	Connection	con		=	null;
	Statement	stmt	=	null;
	ResultSet	rset	=	null;
%>

<html>	
<HEAD>
<TITLE></TITLE>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src="../../eCommon/js/CommonCalendar.js"></script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src="../../eCommon/js/DateUtils.js"></script>
<!-- <script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->

<script>

async function searchCode(obj,target)
{
	var retVal = 	new String();
	var locale= "<%=locale%>"
	var dialogHeight= "400px" ;
	var dialogWidth	= "700px" ;
	var status = "no";
	var arguments	= "" ;
	var sql="";
	var search_code="";
	var search_desc="";
	var tit="";

	if(obj.name=="fm_pract_id")
	{
		var tit=getLabel('Common.practitioner.label','common')
		var fm_pract_type = document.forms[0].fm_pract_type.value;
		//sql="select PRACTITIONER_ID, PRACTITIONER_NAME from am_practitioner where pract_type = nvl(`"+fm_pract_type+"`,pract_type)";
		sql="select PRACTITIONER_ID, PRACTITIONER_NAME from am_practitioner_lang_vw where language_id=`"+locale+"` and pract_type = nvl(`"+fm_pract_type+"`,pract_type)";
		search_code="PRACTITIONER_ID";
		search_desc= "PRACTITIONER_NAME"
	}
	if(obj.name=="to_pract_id")
	{
		var tit=getLabel('Common.practitioner.label','common')
		var to_pract_type = document.forms[0].to_pract_type.value;
		//sql="select PRACTITIONER_ID, PRACTITIONER_NAME from am_practitioner where pract_type = nvl(`"+to_pract_type+"`,pract_type)";
		sql="select PRACTITIONER_ID, PRACTITIONER_NAME from am_practitioner_lang_vw where language_id=`"+locale+"` and pract_type = nvl(`"+to_pract_type+"`,pract_type)";
		search_code="PRACTITIONER_ID";
		search_desc= "PRACTITIONER_NAME"
	}
	if(obj.name=="Speciality")
			{
				var tit=getLabel('Common.speciality.label','common');
				//sql="select speciality_code, short_desc from am_speciality ";

				sql="select speciality_code, short_desc from am_speciality_lang_vw where language_id=`"+locale+"`";
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
</script>
</HEAD>

<BODY onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<br>
<br>
<form name="Rep2MthlyPractitionerForm" id="Rep2MthlyPractitionerForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>
		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>
	<tr>
		<td width="100%" class="Border" align='center'>
			<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >
			<!-- To Populate Facility List -->
			<tr>
				<td class="label">&nbsp;</td>
				<Td class="label">&nbsp;</td>
			</tr>
				<tr>
					<td class="label" ><fmt:message key="Common.facility.label" bundle="${common_labels}"/>&nbsp;</td>
					<td colspan ="3"> <select name='p_all_facility_id' id='p_all_facility_id' >
						<%
							String practtype="";
							StringBuffer fm_strt = new StringBuffer();
							StringBuffer to_strt	= new StringBuffer();
							String practtypedesc="";	
							String isSpltyNurUnitToEnableYNAppl="";
						try
						{	
							con		=	ConnectionManager.getConnection(request);
							isSpltyNurUnitToEnableYNAppl = eIP.IPCommonBean.getSpltyNurUnitToEnableYN(con);//Added by shanmukh on 3rd-OCT-2018 for ML-MMOH-CRF-1115.1
							stmt=con.createStatement();
							//String sqlt = "select pract_type,Desc_Userdef  from am_pract_type order by 2";
							String sqlt = "select pract_type,Desc_Userdef  from am_pract_type_lang_vw where language_id='"+locale+"' order by 2";
							rset	= stmt.executeQuery( sqlt) ;			
							fm_strt.append(" <select name='fm_pract_type' id='fm_pract_type'><option value=''>-------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"------- ");
							to_strt.append("<select name='to_pract_type' id='to_pract_type'><option value=''>-------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"------- ");
							while(rset!=null&&rset.next()) 
							 {
								practtype=rset.getString("pract_type");
								practtypedesc=rset.getString("Desc_Userdef");
								fm_strt.append(" <option value='"+practtype+"' onClick='checkpract()' >"+practtypedesc+" ");
								to_strt.append(" <option value='"+ practtype+"' onClick='checkpract()' >"+practtypedesc+" ");
							 }
							 if(rset!=null)rset.close();
							 if(stmt!=null)stmt.close();
							fm_strt.append("</select>");
							to_strt.append("</select>");
							String fid;
							String fname;
							//String sql1 = "select 'All' facility_id, 'All Access Facilities' facility_name from dual union select u.facility_id facility_id, p.facility_name facility_name from  sm_facility_for_user u, sm_facility_param p where u.appl_user_id ='"+ p_user_name+"' and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = '"+p_resp_id+"') order by 2 ";
							
							String all_access = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AllAccessFacilities.label","common_labels");

							String sql1 = "select 'All' facility_id, '"+all_access+"' facility_name from dual union select u.facility_id facility_id, p.facility_name facility_name from  sm_facility_for_user u, sm_facility_param_lang_vw p where u.appl_user_id ='"+ p_user_name+"'  and p.language_id='"+locale+"'  and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = '"+p_resp_id+"') order by 2";

							stmt=con.createStatement();
							rset=stmt.executeQuery(sql1);
							if(rset!=null)
							{
							   while(rset.next())
							   {
								fid=rset.getString("facility_id");
								fname=rset.getString("facility_name");
								if(fid.equals("All"))
								out.println("<option value='"+fid+ "'  selected>"+fname+"</option>");
								else
								out.println("<option value='"+fid+ "' >"+fname+"</option>");
							   }
							}
								if(rset!=null)rset.close();
								if(stmt!=null)stmt.close();
							}catch(Exception e)
							{
								out.println(e);
							}
							finally 
							{
								ConnectionManager.returnConnection(con,request);
							}
						%>	
						</select>
					</td>
				</tr>

				<tr>
				<td class="label">&nbsp;</td>
				<Td class="label">&nbsp;</td>
			</tr>
			<tr>
				<td align="center" width="35%">&nbsp;</td>
				<td class="querydata" width="20%" style="font-weight: bold;"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
				<td class="querydata" width="40%" style="font-weight: bold;">&nbsp;&nbsp;&nbsp; <fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
			</tr>
			<!-- Added by shanmukh on 3rd-OCT-2018 for ML-MMOH-CRF-1115.1 -->
			<%if(isSpltyNurUnitToEnableYNAppl.equals("N")){%>
					<tr>
					<jsp:include page="CommonSpecialityLookup.jsp">
					<jsp:param name="speciality_code_Appl" value="p_fr_splt_code"/>
					<jsp:param name="speciality_to_code_Appl" value="p_to_splt_code"/>
					</jsp:include>
					</tr>
			<%}else{%>
			<tr>
					<td width='40%' class="label"><fmt:message key="Common.SpecialityCode.label" bundle="${common_labels}"/> </td>
					<td class="fields" width='30%'  >
						<input type=text  name='p_fr_splt_code' id='p_fr_splt_code' size="8" maxlength="8" align="center"><input type='button' name='Speciality' id='Speciality' value='?' class='button' onclick='searchCode(this, p_fr_splt_code)'>
					</td>
					<td class="fields" width='40%'>&nbsp;&nbsp;&nbsp; 
						<input type=text  name='p_to_splt_code' id='p_to_splt_code' size="8" maxlength="8" align="center"><input type='button' name='Speciality' id='Speciality' value='?' class='button' onclick='searchCode(this, p_to_splt_code)'>
					</td>
			</tr><%}%>
				
				<tr>
				<td class="label">&nbsp;</td>
				<Td class="label">&nbsp;</td>
			</tr>



			
			   <tr>
			<td  class="label">
				<fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/>&nbsp;</td>
			<td><%=fm_strt.toString()%>
			</td>
			<td>
				&nbsp;&nbsp;
				<%=to_strt.toString()%>
			</td>
			<td width='10%'>&nbsp;</td>
			</tr>
			<tr>
				<td class="label">&nbsp;</td>
				<Td class="label">&nbsp;</td>
			</tr>
			<tr>
				<td width='30%' class="label"><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/>&nbsp;</td>
				<td class="fields" width='20%'  ><input type=text  name='p_fm_pract_id' id='p_fm_pract_id' size="15" maxlength="15" align="center"><input type='button' name='fm_pract_id' id='fm_pract_id' value='?' class='button' onclick='searchCode(this, p_fm_pract_id)'>
				</td>
				<td class="fields" width='40%'> &nbsp;&nbsp;&nbsp;
					<input type=text  name='p_to_pract_id' id='p_to_pract_id' size="15" maxlength="15" align="center"><input type='button' name='to_pract_id' id='to_pract_id' value='?' class='button' onclick='searchCode(this, p_to_pract_id)'>
				</td>
			</tr>
			<tr>
				<td class="label">&nbsp;</td>
				<Td class="label">&nbsp;</td>
			</tr>

			<tr>
				<td width='30%' class="label"><fmt:message key="eIP.TransactionMonthYear.label" bundle="${ip_labels}"/>&nbsp;</td>
				<td class="fields" width='20%'><input type=text  name='p_fm_admission_date' id='p_fm_admission_date' size="7" maxlength="7" align="center" onblur='validDateObj(this,"MY",localeName);'><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('p_fm_admission_date','mm/y',null)">
				</td>
				<td class="fields" width='40%'>&nbsp;&nbsp;&nbsp;			
					<input type=text  name='p_to_admission_date' id='p_to_admission_date' size="7" maxlength="7" align="center" onblur='validDateObj(this,"MY",localeName);'><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('p_to_admission_date','mm/y',null)">
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
	<input type="hidden" name="p_resp_id" id="p_resp_id"		value="<%= p_resp_id %>">

	<%if(localeName.equals("en"))
	{%>
	<!-- <INPUT TYPE="hidden" name="p_passing_local_date" id="p_passing_local_date" value="N"> -->
	<%}
	else if(localeName.equals("th"))
	{%>
	<INPUT TYPE="hidden" name="P_passing_local_date" id="P_passing_local_date" value="Y">
	<%}%>
	

</form>
<script>
document.forms[0].p_all_facility_id.focus()
</script>
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

