<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%
	request.setCharacterEncoding("UTF-8");
    Connection con =null;
	Statement stmt = null;
	PreparedStatement pstmt = null ;
	ResultSet rs = null;
	String sys_date = "";

	String resp_id=(String) session.getValue("responsibility_id");
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String user_id = (String) session.getValue("login_user");

try 
{
con=ConnectionManager.getConnection(request);

try 
{
	String sql1 = "select to_char(sysdate,'mm/yyyy') from dual ";
	pstmt = con.prepareStatement(sql1);
	rs = pstmt.executeQuery();
	while(rs.next())
	{
		sys_date = rs.getString(1);
	}
	if (rs!=null) rs.close();
	if (pstmt!=null)pstmt.close();

}
catch (Exception e)
{
	//out.println(e.toString());
	e.printStackTrace();
}
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>


<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eMR/js/MRReports.js' language='javascript'>


</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>




</head>
<body  OnMouseDown="CodeArrest()" onLoad="FocusFirstElement()"  onKeyDown = 'lockKey()'>
<form name="morbidity" id="morbidity" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<BR><BR><BR><BR>
<table border="0" width='60%' cellpadding="3" cellspacing="0"  align='center'>

	  <tr>
		  <td class='label' colspan='3'>&nbsp;</td>
	  </tr>
      <tr>
      <td class="label" width='20%'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
      <td class='fields' width='20%'><select name="p_facilityid" id="p_facilityid" >
<%
		  try
	{
		
		//String sql = "Select 'ALL' facility_id, 'All Access Facilities' facility_name from dual union select u.facility_id facility_id,p.facility_name facility_name from sm_facility_for_user u, sm_facility_param p where u.appl_user_id ='"+user_id+"' and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id ='"+resp_id+"') order by 2";

		String sql="Select 'ALL' facility_id, 'All Access Facilities' facility_name from dual union select u.facility_id facility_id,SM_GET_DESC.SM_FACILITY_PARAM(u.facility_id,'"+localeName+"','1') facility_name from sm_facility_for_user u, sm_facility_param p where u.appl_user_id ='"+user_id+"' and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id ='"+resp_id+"') order by 2";

	    pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		  
	      if( rs != null )
	      {
	          while( rs.next())
	          {
	        	String classname = rs.getString("facility_id") ;
	        	String classname1=rs.getString("facility_name");

				if(classname.equalsIgnoreCase("ALL"))
						classname=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");
				if(classname1.equalsIgnoreCase("All Access Facilities"))										classname1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AllAccessFacilities.label","common_labels");
%>
			<option value='<%= classname %>'><%= classname1 %>
<%
	          }
	      }
		  }catch(Exception e) { }
					finally
					{
						try 
						{
						if(pstmt!=null) pstmt.close();
						
						if(rs!=null)rs.close();
						}
						catch(Exception e) { }
					}

%>
    </select></td>
    <td class='label' width='20%'>&nbsp;</td>
	</tr>

	<tr>
	<td class="label"><fmt:message key="Common.print.label" bundle="${common_labels}"/></td>
	<td class='fields' colspan='2'><select name="p_diag_disp_opt" id="p_diag_disp_opt">
    <option value='C'><fmt:message key="Common.DiagnosisCode.label" bundle="${common_labels}"/></option>
	<option value='D' selected><fmt:message key="Common.DiagnosisDescription.label" bundle="${common_labels}"/></option>
	<option value='B'><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
	</select><img src='../../eCommon/images/mandatory.gif'></img>
	</tr>
	
	
	<tr>
	<td class="label"><fmt:message key="eMR.NationalGroupReq.label" bundle="${mr_labels}"/></td>
	<td class='fields' colspan='2'><input type="checkbox" name="p_incl_nat_grp_val" id="p_incl_nat_grp_val" value='Y' onclick='val(this);' checked></td>
	
	</tr>


	<tr>
      <td class="label" width='20%'><fmt:message key="Common.AgeRange.label" bundle="${common_labels}"/></td>
      <td class='fields' width='20%' colspan='2'><select name="range_id" id="range_id" >
	  <option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%
	    if(rs != null)rs.close();
		if(stmt != null)stmt.close();
	      stmt = con.createStatement();
	      //String sql1 = "Select range_id, short_desc from am_summ_range where range_type = 'A' order by short_desc";
		  String sql1 = "Select range_id, short_desc from am_summ_range_lang_vw where language_id='"+localeName+"' AND range_type = 'A' order by short_desc";

	      rs = stmt.executeQuery(sql1);
	      if( rs != null )
	      {
	          while( rs.next())
	          {
	        	String classname = rs.getString("short_desc") ;
	        	String classname1=rs.getString("range_id");

%>
				<option value='<%= classname1 %>'><%= classname %>
<%
	          }
	      }

%>
    </select><img src='../../eCommon/images/mandatory.gif'></img></td>
	</tr>
					<tr>
						<td class='label'>&nbsp;</td>
						<td class="querydata"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
						<td class="querydata"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					</tr>
					<tr>
						<td class="label"><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></td>
						<td class='fields'><input type=text  name='p_fm_nationality' id='p_fm_nationality' size="4" maxlength="4" align="center"><input type='button' name='locn' id='locn' value='?' class='button' onclick='searchCoderepMorbidityStatsNat(this, p_fm_nationality)'>
						</td>
						<td class='fields'><input type=text  name='p_to_nationality' id='p_to_nationality' size="4" maxlength="4" align="center"><input type='button' name='locn1' id='locn1' value='?' class='button' onclick='searchCoderepMorbidityStatsNat(this, p_to_nationality)'>
						</td>
				</tr>
		<tr>
			<td class="label"><fmt:message key="eMR.PrefMonth.label" bundle="${mr_labels}"/></td>
			<td class='fields'><input type='text'  name='pref_month_from' id='pref_month_from' size='8' onBlur='validDateObj(this,"MY",localeName);' maxlength='10'>
			 <img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('pref_month_from', 'mm/y', null);"/></td>

			<td class='fields'><input type='text'  name='pref_month_to' id='pref_month_to' size='8' onBlur='validDateObj(this,"MY",localeName);_GRDate(this);' maxLength='10'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('pref_month_to', 'mm/y', null);"/></td>
		</tr>
         <tr>
	   <td align ='left' class = "label" id=""><fmt:message key="Common.diagnosis.label" bundle="${mr_labels}"/>&nbsp;<fmt:message key="Common.Set.label" bundle="${mr_labels}"/></td>
	   <td id="p_mds_type" align ='left' colspan='2'>
	   <SELECT name="p_diag_set" id="p_diag_set"  >
	   <option value=''>------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -------</option>
	  

	  <%
		  if(stmt!=null)stmt=null;
	       if(rs!=null) rs=null;
		   stmt = con.createStatement();
		   rs = stmt.executeQuery("select term_set_id,term_set_desc from mr_term_set where diag_spec_yn='Y'   and EFF_STATUS='E'  order by term_set_desc ");

			if(rs != null)
			{									
			while (rs.next())
			{	%>
				<option value='<%=rs.getString("term_set_id")%>'><%=rs.getString("term_set_desc")%></option>
			<%	
			}
			}
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			%>	   
	   </SELECT><img src='../../eCommon/images/mandatory.gif'  style="visibility">
	 </td>
     </tr>
 	<tr>
	<td class="label"><fmt:message key="eMR.IncludeFreeTextDiagnosis.label" bundle="${mr_labels}"/></td>
	<td class='fields' colspan='2'><input type="checkbox" name="p_include_free_text_yn_val" id="p_include_free_text_yn_val" value='' onclick='chkVal(this);'></td>
	</tr>


<tr><td class='label' colspan='3'>&nbsp;</td></tr>

   </table>

<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%=p_facility_id%>">
<input type="hidden" name="p_module_id" id="p_module_id" 		value="MR">
<input type="hidden" name="p_report_id" id="p_report_id" 		value="MRRMBNAT">
<input type="hidden" name="p_user_name" id="p_user_name"		value="<%=user_id%>">
<input type="hidden" name="P_RESP_ID" id="P_RESP_ID"		value="<%=resp_id%>">
<input type="hidden" name="p_incl_nat_grp" id="p_incl_nat_grp"		value="">
<input type="hidden" name="p_include_free_text_yn" id="p_include_free_text_yn"		value="">
<input type="hidden" name="CurrentDate" id="CurrentDate"		value="<%=sys_date%>">


	<%if(localeName.equals("en"))
	{%>
	<!-- <INPUT TYPE="hidden" name="p_passing_local_date" id="p_passing_local_date" value="N"> -->
	<%}
	else if(localeName.equals("th"))
	{%>
	<INPUT TYPE="hidden" name="P_passing_local_date" id="P_passing_local_date" value="Y">
	<%}%>
	

</form>
</body>
</html>
<%
} catch(Exception e) {  /* out.println("in else "+e); */e.printStackTrace();}
finally
{
	try
	{
	if(rs != null)rs.close();
	if(stmt != null)stmt.close();
	}
	catch(Exception e) {  }
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

