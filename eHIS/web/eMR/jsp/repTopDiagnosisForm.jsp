<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,org.json.simple.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %><!--oracle.jdbc.driver.*,-->
<%
	request.setCharacterEncoding("UTF-8");
	Connection con=null;
	String resp_id=(String) session.getValue("responsibility_id");
	String fac_id    	= (String) session.getValue( "facility_id" ) ;
    String locale = (String)session.getAttribute("LOCALE");
	String user_id = (String) session.getValue("login_user");
	String region_prompt="";
try
{
	
	Statement stmt = null;
	PreparedStatement pstmt = null ;
	ResultSet rset=null;
	ResultSet rs=null;
	con  =  ConnectionManager.getConnection(request);
%>
<% 
String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
Boolean isVISIT_STAT_REP_GOVERNORATE  = eCommon.Common.CommonBean.isSiteSpecific(con,"OP","VISIT_STAT_REP_GOVERNORATE"); //<!--added by Himanshu Saxena for MOHE-CRF-0135 on 13-04-2023 -->

//<!--added by Himanshu Saxena for MOHE-CRF-0135 on 13-04-2023 Started -->
JSONObject Json	= eOP.OPCommonBean.getSMSiteParamDetail(con,locale);
region_prompt = (String) Json.get("region_prompt");
if(region_prompt==null || region_prompt.equals(""))
	region_prompt = "";
if(region_prompt.equals("")) 
	region_prompt = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.region.label","mp_labels");
//<!--added by Himanshu Saxena for MOHE-CRF-0135 on 13-04-2023 Ends-->

%>

<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src="../../eCommon/js/ValidateControl.js" language='javascript'></script>
<script src="../../eCommon/js/common.js" language='javascript'></script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src="../../eCommon/js/DateUtils.js"></script>
<script src='../js/repTopDiagnosis.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

 <%
				String sys_date	 ="";
					
					String sql1 = "select to_char(sysdate,'dd/mm/yyyy') from dual ";
					pstmt = con.prepareStatement(sql1);
					rs = pstmt.executeQuery();
					while(rs.next())
					{
						sys_date = rs.getString(1);
					}
					if (rs!=null) rs.close();
					if (pstmt!=null)pstmt.close();

					
	%>

<body  OnMouseDown="CodeArrest()" onLoad="FocusFirstElement()"  onKeyDown = 'lockKey()'>
<form name="repTopDiagnosisForm" id="repTopDiagnosisForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<BR><BR><BR><BR>
<table border="0" width='80%' cellpadding="0" cellspacing="0"  align='center'>

	 	<tr>
			<td   class="label"><fmt:message key="Common.from.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.DiagnosisDate.label" bundle="${common_labels}"/></td>
			<td class='fields' >
			<input type=text  id='morbstatnatagefrom' name='p_from_date' id='p_from_date' size="10" value="<%=sys_date%>" maxlength="10" align="center" onblur="validDateObj(this,'DMY',localeName);"><img align="center" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('morbstatnatagefrom');"/>&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif">
          <td   class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.DiagnosisDate.label" bundle="${common_labels}"/></td>
			<td class='fields' > 
			<input type=text id='morbstatnatageto'  name='p_to_date' id='p_to_date' size="10" value="<%=sys_date%>" maxlength="10" align="center" onblur="validDateObj(this,'DMY',localeName);chkGrtrDate(document.forms[0].p_from_date,document.forms[0].p_to_date);"><img align="center" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('morbstatnatageto');"/>&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif"></td>
</tr>
<tr><td colspan=4 class='label'>&nbsp;</td></tr>

<tr>
	<td  class="label"><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>			
	<td class='fields' >
		<SELECT name="p_patient_class" id="p_patient_class">
			<option selected value='ALL'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
			<option value='DC'><fmt:message key="Common.daycare.label" bundle="${common_labels}"/></option>
			<option value='IP'><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></option>
			<option value='EM'><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></option>
			<option value='OP'><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></option>
			</SELECT> &nbsp;<img align="center" src="../../eCommon/images/mandatory.gif"></td>

<td  class = "label" id=""><fmt:message key="Common.diagnosis.label" bundle="${mr_labels}"/>&nbsp;<fmt:message key="Common.Set.label" bundle="${mr_labels}"/></td>
	   <td id="p_mds_type" colspan='2'  >
	   <SELECT name="p_diag_set" id="p_diag_set"  >
	   	<option selected value='ALL'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
	  <%
		  try{

		  pstmt = con.prepareStatement("select term_set_id,term_set_desc from mr_term_set where diag_spec_yn='Y' and EFF_STATUS='E'  order by term_set_desc ");
		   rs = pstmt.executeQuery();

			if(rs != null)
			{									
			while (rs.next())
			{	%>
				<option value='<%=rs.getString("term_set_id")%>'><%=rs.getString("term_set_desc")%></option>
			<%	
			}
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
	  }catch(Exception e) { }
		
	  %>
	  </SELECT>&nbsp;<img src='../../eCommon/images/mandatory.gif'>
	  </td>
</tr>
<tr><td colspan=4 class='label'>&nbsp;</td></tr>
<tr>
			<td   class="label"><fmt:message key="Common.count.label" bundle="${common_labels}"/></td>
			<td class='fields' ><input type=text id='p_count' name='p_count' id='p_count' size="5" maxlength="5" onkeypress ='return allowNumeric(event)' onblur='checkzero(this);return removeSpec()'>&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif"></td>

<!--added by Himanshu Saxena for MOHE-CRF-0135 on 13-04-2023 Started (Chronic diagnosis filter added)-->
		<%if(isVISIT_STAT_REP_GOVERNORATE){ %>
			<td   class="label"><fmt:message key="eMR.ChronicDiagnosis.label" bundle="${common_labels}"/></td>
			<td class="fields">
	 		<SELECT name="chronic_diagnosis" id="chronic_diagnosis" id="chronic_diagnosis">
	 		<option value='' selected>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------
			<option value='N'><fmt:message key="Common.no.label" bundle="${common_labels}"/></option>
			<option value='Y'><fmt:message key="Common.yes.label" bundle="${common_labels}"/></option>
			</SELECT>
			</td>
	
</tr>
<!--added by Himanshu Saxena for MOHE-CRF-0135 on 13-04-2023 Ended-->



<tr><td colspan=4 class='label'>&nbsp;</td></tr>
<tr>

<!--added by Himanshu Saxena for MOHE-CRF-0135 on 13-04-2023 Started (Governate filter added)-->
<td class="label" width="22%"><%=region_prompt %></td>
	 <td class='fields'><select name='P_governorate' id='P_governorate' onChange=changeFacility(this)>
	 <option value="All"><fmt:message key="Common.AllGovernorates.label" bundle="${common_labels}"/></option>
	  <% 
	try
	  {
		String gid;
		String gname;
		String sql0 = "SELECT   a.region_code, a.long_desc region_desc FROM mp_region_lang_vw a WHERE a.language_id = '"+locale+"' AND a.eff_status = 'E' ORDER BY 2";
		pstmt = con.prepareStatement(sql0) ;
		rset=pstmt.executeQuery();
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
	  }catch(Exception e)
	 {
		  //out.println(e);
		  e.printStackTrace();
	}
	 %>
	 </SELECT> &nbsp;<img align="center" src="../../eCommon/images/mandatory.gif"></td>
	 <% } %>
	 <!--added by Himanshu Saxena for MOHE-CRF-0135 on 13-04-2023 Ended-->
	 
	 
			
	<td class="label" width="22%"><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
	 <td class="fields"><select name='p_facility_id' id='p_facility_id'>
	 <option value='' selected><fmt:message key="Common.AllAccessFacilities.label" bundle="${common_labels}"/></option>
	 <%
	 // added By Himanshu for MOHE-CRF-0135 on 13-04-2023 -->
	 if(isVISIT_STAT_REP_GOVERNORATE){ 
		 pstmt = con.prepareStatement("select u.facility_id facility_id, p.facility_name facility_name from  sm_facility_for_user u, sm_facility_param_lang_vw p where u.appl_user_id ='"+ user_id+"' and p.language_id='"+locale+"' and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = '"+resp_id+"') order by 2 ");
	 }else{
	  pstmt = con.prepareStatement("select facility_id,facility_name from SM_FACILITY_PARAM_LANG_VW where language_id='"+locale+"' order by 2");
	 }
	  
	  try
	  {
	  rs = pstmt.executeQuery();
	  if(rs!=null)
	  {
		  while(rs.next())
		  {
			String id=rs.getString(1);
			String name = rs.getString(2);
			if(id.equals(fac_id))
			  {
				 if(isVISIT_STAT_REP_GOVERNORATE){ 
			%>
				<option value=<%=id%>><%=name%></option>
		  <%
				 }else{
					 
					 %>
						<option value=<%=id%> selected><%=name%></option>
				  <%
				 }
				 
				 }
			  else
			  {%>
				<option value=<%=id%> ><%=name%> </option> 
			<%	}
				}
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
	  }
	  }catch(Exception e){/* out.println(e); */ e.printStackTrace();}
	 finally
	 {
		if(con!=null) ConnectionManager.returnConnection(con,request); 
	 }
	 %>
</tr>
		
</table>

<input type="hidden" name="p_module_id" id="p_module_id" 	value="MR">
<input type="hidden" name="p_report_id" id="p_report_id" 	value="MRTOPDIA">
<input type="hidden" name="p_user_name" id="p_user_name"		value="<%=user_id%>">
<input type="hidden" name="P_RESP_ID" id="P_RESP_ID"		value="<%=resp_id%>">

<!--added by Himanshu Saxena for MOHE-CRF-0135 on 13-04-2023 Started -->
<input type="hidden" name='locale' id='locale'	value="<%=locale%>">
<!--added by Himanshu Saxena for MOHE-CRF-0135 on 13-04-2023 End -->


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
	}catch(Exception e) 
	{  
		//out.println("Exception : "+e);
		e.printStackTrace();
	}
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

