<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8"); %>

<html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,webbeans.eCommon.*,org.json.simple.*"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	String facilityid = (String)session.getValue("facility_id");
	String locale	  = (String)session.getAttribute("LOCALE");
	//Added by shanmukh on 14th-AUG-2018 for ML-MMOH-CRF-1115
	Connection con  =  null;
	Statement stmt = null;
    	ResultSet rset = null;
	String isSpltyNurUnitToEnableYNAppl="";
	
	//Added by Santhosh for MOHE-CRF-0144
	String p_user_name		= (String) session.getValue( "login_user" );
	String p_resp_id		= (String)session.getValue("responsibility_id");
	Boolean repBasedOnGovernorate = false;
	String region_prompt = "";
	StringBuffer NationalityVal	=new StringBuffer();
	NationalityVal.setLength(0);
	ArrayList governateList = new ArrayList();
	ArrayList facilityList = new ArrayList();
	//END
try
    {
	con  =  ConnectionManager.getConnection(request);
	isSpltyNurUnitToEnableYNAppl = eIP.IPCommonBean.getSpltyNurUnitToEnableYN(con);
	
	//Added by Santhosh for MOHE-CRF-0144
	JSONObject Json	= eOP.OPCommonBean.getSMSiteParamDetail(con,locale);
	region_prompt = (String) Json.get("region_prompt");
	if(region_prompt==null || region_prompt.equals(""))
		region_prompt = "";
	if(region_prompt.equals("")) 
		region_prompt = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.region.label","mp_labels");
	
	repBasedOnGovernorate = eCommon.Common.CommonBean.isSiteSpecific(con, "OP", "VISIT_STAT_REP_GOVERNORATE");
	//repBasedOnGovernorate=true;
	//END
	
	}catch(Exception e){out.println(e);e.printStackTrace();}
	 finally
	 {
		if(con!=null) ConnectionManager.returnConnection(con,request);
	 }
	 //END
%>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>
	
	<script src="../../eOP/js/repOPVisitStatBySpeciality.js" language="javascript"></script>
	<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
	<script src="../js/IPQueryCommon.js" language="javascript"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



</head>
<body  onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
	<form name='Criteria_Form' id='Criteria_Form' >
		<table cellspacing=0 cellpadding=0 align='center' width='100%' border='0'>
			<!-- Modified to CommonLookup on 09/02/04 by Sridhar -->
			
<!--Added by Santhosh for MOHE-CRF-0144-->
<%if(repBasedOnGovernorate){%>
<tr>
	<td class="label" nowrap><%=region_prompt%></td>

	<td colspan = '2' class = 'fields'><select name = 'p_governorate_code' onChange = 'changeFacility(this);'>
	<option value="All"><fmt:message key="Common.AllGovernorates.label" bundle="${common_labels}"/></option>
	<%
			String gov_code = "";
			String gov_name = "";	
			
			String sql_gov = "select region_code, long_desc region_desc from mp_region_lang_vw where language_id = '"+locale+"' AND eff_status ='E' order by 2";
			
			con  =  ConnectionManager.getConnection(request);
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql_gov);

			if(rset != null)
			{
			   while(rset.next())
			   {
					gov_code = rset.getString("region_code");
					gov_name = rset.getString("region_desc");
					governateList.add(gov_code);

					if(gov_code.equals("All"))
						out.println("<option value='"+gov_code+"' selected>"+gov_name+"</option>");
					else
					    out.println("<option value='"+gov_code+"'>"+gov_name+"</option>");
			   }
			}

			if(rset != null) rset.close();
			if(stmt != null) stmt.close();
	%>
	</td>

</tr>

<tr>
	<td class="label" nowrap ><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
	<td colspan='2' class='fields'><select name='P_facilityid' id='P_facilityid' onChange = 'changeFacilityByGover(this)'>
	<option value="All"><fmt:message key="Common.AllAccessFacilities.label" bundle="${common_labels}"/></option>
	<%
			String fid;
			String fname;			
			
			String sql1 = "select u.facility_id facility_id, p.facility_name facility_name from  sm_facility_for_user u, sm_facility_param_lang_vw p where u.appl_user_id ='"+ p_user_name+"' and p.language_id='"+locale+"' and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = '"+p_resp_id+"') order by 2 ";

			con  =  ConnectionManager.getConnection(request);
			stmt = con.createStatement() ;
			rset=stmt.executeQuery(sql1);
			if(rset!=null)
			{
			   while(rset.next())
			   {
					fid=rset.getString("facility_id");
					fname=rset.getString("facility_name");
					facilityList.add(fid);
					
					if(fid.equals("All"))
						out.println("<option value='"+fid+"' selected>"+fname+"</option>");
					else
					    out.println("<option value='"+fid+"'>"+fname+"</option>");
			   }
			}

			if(rset != null) rset.close();
			if(stmt != null) stmt.close();
			
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
	%>
</td>
</tr>
<%}%>
<!--End MOHE-CRF-0144-->
		<tr><!--Added by Shanmukh on 20th-AUG-2018 for ML-MMOH-CRF-1115-->
		<%if(isSpltyNurUnitToEnableYNAppl.equals("N")){%>
				<td  class='label'  width='30%'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
				<input type=hidden name="to_nursing_unit" id="to_nursing_unit" value="">
				<%}else{%>
			
			<td  class='label'  width='30%'><fmt:message key="eIP.NursingUnitFrom.label" bundle="${ip_labels}"/>&nbsp;&nbsp;</td><%}%>
			<td>
				<input type=text  name='fr_nursing_unit_desc' id='fr_nursing_unit_desc' size="15" maxlength="15" align="center" onBlur="beforeGetNursingUnit_HospOccupancy(fr_nursing_unit,fr_nursing_unit_desc);"><input type='button' name='nursing_unit_fm' id='nursing_unit_fm' value='?' class='button' onclick='nursing_unit_lookup(fr_nursing_unit,fr_nursing_unit_desc);'><input type=hidden name='fr_nursing_unit' id='fr_nursing_unit' size="4" maxlength="4" align="center" onBlur="return makeValidQueryCriteria(this);" >
			</td><!--Added by Shanmukh on 20th-AUG-2018 for ML-MMOH-CRF-1115-->
			<%if(isSpltyNurUnitToEnableYNAppl.equals("Y")){%>
			<td  class='label' align='right'><fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
			<td>
				<input type=text  name='to_nursing_unit_desc' id='to_nursing_unit_desc' size="15" maxlength="15" align="center" onBlur="compareFrom_HospOccupancy();beforeGetNursingUnit_HospOccupancy(to_nursing_unit,to_nursing_unit_desc);" ><input type='button' name='nursing_unit_to' id='nursing_unit_to' value='?' class='button' onclick='nursing_unit_lookup(to_nursing_unit,to_nursing_unit_desc);' onBlur="compareFrom_HospOccupancy();"><input type=hidden  name='to_nursing_unit' id='to_nursing_unit' size="4" maxlength="4" align="center" onBlur="return makeValidQueryCriteria(this);">
			</td><%}%>
		</tr>
		<tr>
			<td class='label' ><fmt:message key="eIP.IncludeforHospitalCalculation.label" bundle="${ip_labels}"/>&nbsp;&nbsp;</td><td colspan=3 ><input type="checkbox" name="include_for_calc" id="include_for_calc" checked value="Y"></td>
		</tr>
	</table>
			<table align='right'>
				 <tr>
					<td align='right' class='white'>
						<input type='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='button' onclick='<%if(isSpltyNurUnitToEnableYNAppl.equals("N")){%>removeToSearch();<%}%> submitPage_HospOccupancy()'>
						<input type='button' name='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' id='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' value='Clear' class='button' onclick="clearAll_HospOccupancy()">
					</td>
					<input type=hidden name="facilityid" id="facilityid" value="<%=facilityid%>">
					<input type=hidden name="locale" id="locale" value="<%=locale%>">
				</tr>				
		  </table>
<!--Added by Santhosh for MOHE-CRF-0144-->			
			<input type="hidden" name="p_user_name" id="p_user_name" value="<%=p_user_name %>">
			<input type="hidden" name="p_resp_id" id="p_resp_id" value="<%= p_resp_id %>">
			<input type="hidden" name="facilityList" id="facilityList" value="<%= facilityList %>">
			<input type="hidden" name="repBasedOnGovernorate" id="repBasedOnGovernorate" value="<%= repBasedOnGovernorate %>">
<!--END-->
		</form>
	</body>
</html>

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

