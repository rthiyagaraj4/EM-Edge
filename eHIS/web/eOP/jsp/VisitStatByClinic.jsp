<!DOCTYPE html>

<%--
Filename		: VisitStatByClinic.jsp
Modified On		: 1-3-2005
Version			: 3
--%>

<%@ page import="java.sql.*, webbeans.eCommon.*,org.json.simple.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
	String p_facility_id		= (String) session.getValue( "facility_id" );
	String p_user_name		= (String) session.getValue( "login_user" );
	String p_resp_id		= (String)session.getValue("responsibility_id");
	String locale=(String)session.getAttribute("LOCALE");
	StringBuffer NationalityVal	=new StringBuffer();
	NationalityVal.setLength(0);
%>
<html>
<HEAD>
 <link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src="../../eCommon/js/common.js"></script>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src="../../eOP/js/repOPVisitStatByClinic.js" language="javascript"></script>
<script src='../../eOP/js/OPPractitionerComponent.js'  language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<center>
<!--Added for this SCF TTM-SCF-0154 -->
<script>
function valDate(obj, format, localeName)
	{ 
		if(obj.name=="p_fm_date_1")
		{ 
				var from ='';
				if(obj.value!=''){
					from = convertDate(obj.value,"DMY",localeName,"en");
					document.forms[0].p_fm_date.value = from;
				}else{
					document.forms[0].p_fm_date.value = '';
				}
				
		}
		if(obj.name=="p_to_date_1")
		{ 
				var from ='';
				if(obj.value!=''){
					from = convertDate(obj.value,"DMY",localeName,"en");
					document.forms[0].p_to_date.value = from;
				}else{
					document.forms[0].p_to_date.value = '';
				}
				
		}
		
	}



</script>
<BODY OnMouseDown="CodeArrest()"onload = 'FocusFirstElement()' onKeyDown ='lockKey()'>
<form name="VisitByStatus_form" id="VisitByStatus_form"  action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<%
    Connection con  =null;
    Statement stmt = null;
    ResultSet rset = null;
	String sql = "" ;
	StringBuffer StrVal =new StringBuffer();
	String isSpltyNurUnitToEnableYNAppl="";
	Boolean isGovernorateInRepCrit = false;
	String region_prompt = "";
	try
    {
	con  =  ConnectionManager.getConnection(request);
	isSpltyNurUnitToEnableYNAppl = eIP.IPCommonBean.getSpltyNurUnitToEnableYN(con);//Added by shanmukh on 3rd-OCT-2018 for ML-MMOH-CRF-1115.1
	isGovernorateInRepCrit = eCommon.Common.CommonBean.isSiteSpecific(con, "OP", "VISIT_STAT_REP_GOVERNORATE"); //Added by Ajay Hatwate for MOHE-CRF-0147
	JSONObject Json	= eOP.OPCommonBean.getSMSiteParamDetail(con,locale);
	region_prompt = (String) Json.get("region_prompt");
	if(region_prompt==null || region_prompt.equals(""))
		region_prompt = "";
	if(region_prompt.equals("")) 
		region_prompt = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.region.label","mp_labels");
    stmt = con.createStatement(); 

    //sql = "Select PRACT_TYPE, DESC_USERDEF From AM_PRACT_TYPE Where EFF_STATUS = 'E' order by 2" ;
	sql = "Select PRACT_TYPE, DESC_USERDEF From AM_PRACT_TYPE_lang_vw Where EFF_STATUS = 'E' and language_id='"+locale+"' order by 2" ;
	rset = stmt.executeQuery(sql);
	StrVal.setLength(0);
  
		if(rset != null)
		{
			while(rset.next())
			{
				StrVal.append( "<option value='"+rset.getString(1)+"'>"+rset.getString(2)+"</option>");
			}
		}
	if(rset != null) rset.close();
	if(stmt != null) stmt.close();
 %>
<br>
<table cellpadding='0' border = '0' cellspacing='0' width='80%'>
<th class='columnheader' align="left" width='100%'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
</table>
<table cellpadding='2' border = '0' cellspacing='0' width='80%'>
<!-- START MOHE-CRF-0147 by Ajay Hatwate  -->
<% if(isGovernorateInRepCrit){ %>
<tr>
<td class="label" nowrap ><%=region_prompt%></td>
<td colspan='2' class='fields'><select name='P_governorate' id='P_governorate' onChange=changeFacility(this)>
	<option value="All"><fmt:message key="Common.AllGovernorates.label" bundle="${common_labels}"/></option>
<% 
String gid;
String gname;
String sql0 = "SELECT   a.region_code, a.long_desc region_desc FROM mp_region_lang_vw a WHERE a.language_id = '"+locale+"' AND a.eff_status = 'E' ORDER BY 2";
stmt = con.createStatement() ;
rset=stmt.executeQuery(sql0);
if(rset!=null)
{
   while(rset.next())
   {
		gid=rset.getString("region_code");
		gname=rset.getString("region_desc");
		if(gid.equals("All"))
			out.println("<option value='"+gid+"' selected>"+gname+"</option>");
		else
		    out.println("<option value='"+gid+"'>"+gname+"</option>");
   }
}
if(rset != null) rset.close();
if(stmt != null) stmt.close();
%>
</select>
</tr>
<%} %>
<!-- END MOHE-CRF-0147 by Ajay Hatwate  -->
<tr>
	<td class="label" nowrap ><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
	<td colspan='2' class='fields'><select name='P_facilityid' id='P_facilityid'>
	<option value="ALL"><fmt:message key="Common.AllAccessFacilities.label" bundle="${common_labels}"/></option>
	<%
			String fid;
			String fname;
			//String sql1 = "select 'All' facility_id, 'All Access Facilities' facility_name from dual union select u.facility_id facility_id, p.facility_name facility_name from  sm_facility_for_user u, sm_facility_param p where u.appl_user_id ='"+ p_user_name+"' and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = '"+p_resp_id+"') order by 2 ";			
			
//			String sql1 = "select 'All' facility_id, 'All Access Facilities' facility_name from dual union select u.facility_id facility_id, p.facility_name facility_name from  sm_facility_for_user u, sm_facility_param_lang_vw p where u.appl_user_id ='"+ p_user_name+"' and p.language_id='"+locale+"' and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = '"+p_resp_id+"') order by 2 ";

			String sql1 = "select u.facility_id facility_id, p.facility_name facility_name from  sm_facility_for_user u, sm_facility_param_lang_vw p where u.appl_user_id ='"+ p_user_name+"' and p.language_id='"+locale+"' and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = '"+p_resp_id+"') order by 2 ";
			
			
			stmt = con.createStatement() ;
			rset=stmt.executeQuery(sql1);
			if(rset!=null)
			{
			   while(rset.next())
			   {
					fid=rset.getString("facility_id");
					fname=rset.getString("facility_name");
					if(fid.equals("All"))
						out.println("<option value='"+fid+"' selected>"+fname+"</option>");
					else
					    out.println("<option value='"+fid+"'>"+fname+"</option>");
			   }
			}

			if(rset != null) rset.close();
			if(stmt != null) stmt.close();

			//sql1  = "Select country_code, long_desc from MP_COUNTRY Order by 2";
			sql1  = "Select country_code, long_desc from MP_COUNTRY_lang_vw where language_id='"+locale+"' Order by 2";
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql1);
			if(rset!=null)
			{
			   while(rset.next())
			   {
					NationalityVal.append("<option 	value='"+rset.getString(1)+"'>"+rset.getString(2)+"</option>");
			   }
			}

			if(rset != null) rset.close();
			if(stmt != null) stmt.close();

		}catch(Exception e){out.println(e);}
		finally
		{
			ConnectionManager.returnConnection(con,request);
		}
	%>
	</select><img src='../../eCommon/images/mandatory.gif'align='center'></img>
</td>
</tr>
<tr>
	<td class="label" ><fmt:message key="Common.nationality.label" bundle="${common_labels}"/> </td>
	<td colspan="2" class='fields'><select name='p_nationality' id='p_nationality'>
		<option value="">&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;</option>
		<%=NationalityVal.toString()%>
		</select><img src='../../eCommon/images/mandatory.gif'align='center'></img>
	</td>
</tr>
<tr>
<td width='33%'>&nbsp;</td>
<td class="querydata" width='33%' style="font-weight: bold;"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
<td class="querydata" width='33%' style="font-weight: bold;"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
</tr>
<tr>
	<td class="label"><fmt:message key="eOP.StatisticsDate.label" bundle="${op_labels}"/></td>
	<td class='fields'><input type=text  name='p_fm_date_1' id='p_fm_date_1' size="10" maxlength="10" align="left" onBlur='valDate(this,"DMY",localeName);validDateObj(this,"DMY",localeName);'><img name= "dob" src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].p_fm_date_1.select();return showCalendar('p_fm_date_1');" style="cursor='hand'"></img><img src='../../eCommon/images/mandatory.gif'></img>
	</td>	
	<td class='fields'><input type=text  name='p_to_date_1' id='p_to_date_1' size="10" maxlength="10" align="left" onBlur='valDate(this,"DMY",localeName);validDateObj(this,"DMY",localeName);'><img name= "dob" src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].p_to_date_1.select();return showCalendar('p_to_date_1');" style="cursor='hand'"></img><img src='../../eCommon/images/mandatory.gif'></img>
	</td>
	<input type="hidden" name="p_fm_date" id="p_fm_date">
			<input type="hidden" name="p_to_date" id="p_to_date">
</tr>
<tr>
	<td class="label"><fmt:message key="Common.VisitTypeCode.label" bundle="${common_labels}"/></td>

	<td class='fields'><input type="text" name="p_fm_visit_type" id="p_fm_visit_type" size="2" maxlength="2" onBlur='searchCode(fromvtype,this)'><input type='button' name='fromvtype' id='fromvtype' value='?' class='button' onclick='searchCode(this, p_fm_visit_type)'>
	</td>
	<td class='fields'>
	    <input type="text" name="p_to_visit_type" id="p_to_visit_type" size="2" maxlength="2" onBlur='searchCode(tovtype,this)'><input type='button' name='tovtype' id='tovtype' value='?' class='button' onclick='searchCode(this, p_to_visit_type)'>
	</td>
</tr>

<tr>
	<td class="label"><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/></td>

	<td class='fields'><input type="text" name="p_fm_locn_code" id="p_fm_locn_code" size="4" maxlength="4" onBlur='searchCode(fromlocn,this)'><input type='button' name='fromlocn' id='fromlocn' value='?' class='button' onclick='searchCode(this, p_fm_locn_code)'>
	</td>

	<td class='fields'>
	    <input type="text" name="p_to_locn_code" id="p_to_locn_code" size="4" maxlength="4" onBlur='searchCode(tolocn,this)'><input type='button' name='tolocn' id='tolocn' value='?' class='button' onclick='searchCode(this, p_to_locn_code)'>
	</td>
</tr>
<!-- Added by shanmukh on 3rd-OCT-2018 for ML-MMOH-CRF-1115.1 -->
<%if(isSpltyNurUnitToEnableYNAppl.equals("N")){%>
					<tr>
					<jsp:include page="../../eIP/jsp/CommonSpecialityLookup.jsp">
					<jsp:param name="speciality_code_Appl" value="p_fm_specialty_code"/>
					<jsp:param name="speciality_to_code_Appl" value="p_to_specialty_code"/>
					</jsp:include>
					</tr>
<%}else{%>
<tr>
	<td class="label"><fmt:message key="Common.SpecialtyCode.label" bundle="${common_labels}"/></td>

	<td class='fields'><input type="text" name="p_fm_specialty_code" id="p_fm_specialty_code" size="4" maxlength="4" onBlur='searchCode(fromspecialty,this)'><input type='button' name='fromspecialty' id='fromspecialty' value='?' class='button' onclick='searchCode(this, p_fm_specialty_code)'>
	</td>	

	<td class='fields'>
	    <input type="text" name="p_to_specialty_code" id="p_to_specialty_code" size="4" maxlength="4" onBlur='searchCode(tospecialty,this)'><input type='button' name='tospecialty' id='tospecialty' value='?' class='button' onclick='searchCode(this, p_to_specialty_code)'>
	</td>
</tr><%}%>
<tr>
	<td class="label"><fmt:message key="Common.ServiceCode.label" bundle="${common_labels}"/></td>

	<td class='fields'><input type="text" name="p_fm_service_code" id="p_fm_service_code" size="4" maxlength="4" onBlur='searchCode(fromservice,this)'><input type='button' name='fromservice' id='fromservice' value='?' class='button' onclick='searchCode(this, p_fm_service_code)'></td>

	

	<td class='fields'>
	    <input type="text" name="p_to_service_code" id="p_to_service_code" size="4" maxlength="4" onBlur='searchCode(toservice,this)'><input type='button' name='toservice' id='toservice' value='?' class='button' onclick='searchCode(this, p_to_service_code)'>
	</td>
</tr>

				<tr>
                    <td class="label"><fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/></td>
                    <td class='fields'><select name="fm_pract_type" id="fm_pract_type">
						<option value="">&nbsp;-------- <fmt:message key="Common.defaultSelect.label" 
						bundle="${common_labels}"/> --------&nbsp;</option>
						<%=StrVal.toString()%>
						</select>
					</td>
					<td class='fields'><select name="to_pract_type" id="to_pract_type">
						<option value="">&nbsp;-------- <fmt:message key="Common.defaultSelect.label" 
						bundle="${common_labels}"/> --------&nbsp;</option>
						<%=StrVal.toString()%>
						</select>
					</td>
                </tr>

<tr>
	<td class="label"><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></td>
	
	<td class='fields'><input type="text" name="p_fm_pract_id" id="p_fm_pract_id" size="15" maxlength="15" onBlur='searchCode(pract_id1,this)'><input type='button' name='pract_id1' id='pract_id1' value='?' class='button' onclick='searchCode(this, p_fm_pract_id)'>
	</td>	
	
	<td class='fields'><input type="text" name="p_to_pract_id" id="p_to_pract_id" size="15" maxlength="15" onBlur='searchCode(pract_id2,this)'><input type='button' name='pract_id2' id='pract_id2' value='?' class='button' onclick='searchCode(this, p_to_pract_id)'>
	
	</td>
</tr>

</table>

	<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%=p_facility_id %>">
		<input type="hidden" name="p_facility" id="p_facility"  		value="<%=p_facility_id %>">
		
		<input type="hidden" name="p_module_id" id="p_module_id" 		value="OP">
		<input type="hidden" name="p_report_id" id="p_report_id" 		value="OPVSBCLS"> 

		<input type="hidden" name="p_user_name" id="p_user_name"		    value="<%=p_user_name %>">
		<input type="hidden" name="p_resp_id" id="p_resp_id"			value="<%= p_resp_id %>"></input>
		<input type="hidden" name='locale' id='locale'				value="<%=locale%>">

		<input type="hidden" name="p_clinic_from" id="p_clinic_from"		value="">
		<input type="hidden" name="p_clinic_to" id="p_clinic_to" 		value="">
		
		<input type="hidden" name="p_pract_from" id="p_pract_from" 		value="">
		<input type="hidden" name="p_pract_to" id="p_pract_to"		    value="">
		
		<input type="hidden" name="p_incl_no_show" id="p_incl_no_show" 		value="">
		<input type="hidden" name="p_visit_status" id="p_visit_status"		value="">
		
		<input type="hidden" name="p_date_from" id="p_date_from"		    value="">
		<input type="hidden" name="p_date_to" id="p_date_to" 		    value="">

	<%-- <INPUT TYPE="hidden" name="p_language_id" id="p_language_id" value="<%=localeName%>">	--%>

<%
  StrVal.setLength(0);
  NationalityVal.setLength(0);
%>

</form>
</body>
</center>
</html>

