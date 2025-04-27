<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8"); %>
<%
	String p_module_id		= "MR" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name	= (String) session.getValue( "login_user" ) ;

%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<% 
Connection con=null;
Statement stmt = null;
PreparedStatement pstmt = null ;
ResultSet rset=null;
ResultSet rs=null;
con  =  ConnectionManager.getConnection(request);
%>
<html>	
<HEAD>
<TITLE></TITLE>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src="../../eCommon/js/CommonCalendar.js"></script>
<script src="../../eCommon/js/DateUtils.js"></script>
<script src="../../eMR/js/MRReports.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
		function validateDate(obj)
		{
			if (obj.value != "")
			{
				if(validDate(obj.value,"DMY",localeName) == false)
				{
					alert(getMessage("INVALID_DATE_FMT", "SM"));
					obj.select();
					return false;
				}
				else
					return true;
					
			}
		}
</script>
</HEAD>
	  <%
				String sys_date	 ="";
					try 
					{
					String sql1 = "select to_char(sysdate,'dd/mm/yyyy') from dual ";
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
						out.println(e.toString());
					}
	%>
<BODY OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onload='repvisibile();' >
<br>
<br>
<form name="RepTablistStat" id="RepTablistStat" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table border="0" width='60%' cellpadding="3" cellspacing="0"  align='center'>
 <tr>
	<td colspan='3' class='label'>&nbsp;</td>
</tr> 
<tr>
	<td  class="label"><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>			
	<td class='fields' colspan='2'>
		<SELECT name="p_patient_class" id="p_patient_class">
			<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
			<option value='DC'><fmt:message key="Common.daycare.label" bundle="${common_labels}"/></option>
			<option value='IP'><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></option>
			<option value='EM'><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></option>
			<option value='OP'><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></option>
			</SELECT> &nbsp;<img align="center" src="../../eCommon/images/mandatory.gif"></td>
	</td>
</tr>
<tr>
	<td class="label" ><fmt:message key="Common.ReportBy.label" bundle="${common_labels}"/></td>			
	<td class='fields' colspan='2'>
		<SELECT name="p_report_by" id="p_report_by" onchange="repvisibile()">
			<option value='DC'><fmt:message key="Common.Summary.label" bundle="${common_labels}"/></option>
			<option value='IP'><fmt:message key="Common.Detail.label" bundle="${common_labels}"/></option>
			</SELECT>
	</td>
</tr>
<!-- <tr>
	<td class="label"><fmt:message key="eMR.ReportFor.label" bundle="${mr_labels}"/></td>			
	<td class='fields'>
		<SELECT name="p_report_for" id="p_report_for" onchange="mychange()">
			<option value='D'><fmt:message key="Common.day.label" bundle="${common_labels}"/></option>
			<option value='P'><fmt:message key="Common.Period.label" bundle="${common_labels}"/></option>
			</SELECT>
	</td>
</tr>
 -->
	<tr>
			<td class='label'  >&nbsp;</td>
			<td class="querydata"  ><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
			<td class="querydata"  ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
	</tr>
	<tr>
			<td   class="label"><fmt:message key="Common.VisitAdmDate.label" bundle="${common_labels}"/></td>
			<td class='fields' >
			<input type=text  id='morbstatnatagefrom' name='P_FM_DATE' id='P_FM_DATE' size="10" maxlength="10" align="center" onblur="validDateObj(this,'DMY',localeName);_GRDate2(this);"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('morbstatnatagefrom');"/>&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif">

			<td class='fields' > 
			<input type=text id='morbstatnatageto'  name='P_TO_DATE' id='P_TO_DATE' size="10" maxlength="10" align="center" onblur="validDateObj(this,'DMY',localeName);_GRDate2(this);chkGrtrDate(document.forms[0].P_FM_DATE,document.forms[0].P_TO_DATE)"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('morbstatnatageto');"/>&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif"></td>
</tr>
<!--  <tr>
			
	<td id = "MY2" class="label"><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type='text' id='birthfrom' name='P_FM_DATE' id='P_FM_DATE' size='10' onBlur='validDateObj(this,"DMY",localeName);' maxLength='10'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('birthfrom');">&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif"></td>
</tr>
 -->
 <tr><td class="label" colspan="2"><p id="test"></p></td><td class='fields'><p id="test1"></p></td></tr>

<tr>
<td  align ='left'  class = "label" id=""><fmt:message key="Common.diagnosis.label" bundle="${mr_labels}"/>&nbsp;<fmt:message key="Common.Set.label" bundle="${mr_labels}"/></td>
	   <td id="p_mds_type"   align ='left' colspan="2"  >
	   <SELECT name="p_diag_set" id="p_diag_set"  >
	   <option value=''>------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -------</option>
	  

	  <%
		  try{
		   // con  =  ConnectionManager.getConnection(request);
		 stmt = con.createStatement();
		   rset = stmt.executeQuery("select term_set_id,term_set_desc from mr_term_set where diag_spec_yn='Y'   and EFF_STATUS='E'  order by term_set_desc ");

			if(rset != null)
			{									
			while (rset.next())
			{	%>
				<option value='<%=rset.getString("term_set_id")%>'><%=rset.getString("term_set_desc")%></option>
			<%	
			}
			}
			if(rset != null) rset.close();
			if(stmt != null) stmt.close();
	  }catch(Exception e){/* out.println(e); */e.printStackTrace(); }
	  %>
	  </SELECT><img src='../../eCommon/images/mandatory.gif'  style="visibility">
	  </td>
</tr>

 
<!-- <tr>
	<td id="MY1" class="label">&nbsp;</td>
	<td id="MY" class='fields'>&nbsp;</td>
</tr>
<tr>
	<td id='rep1' class="label">&nbsp;</td>			
	<td id='rep2' class='fields'>&nbsp;</td>
</tr> -->
<tr>
	<td  id='r1'  class="label" style="display:none" ><fmt:message key="Common.AgeRange.label" bundle="${common_labels}"/></td>
	<td id='r2' class='fields'  colspan='2' align="left"><select &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; name="p_range_id" id="p_range_id" >
					<option value='' >---------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------------</option>
						<%
						try
						{
							pstmt 	= con.prepareStatement( "select range_id, long_desc from am_summ_range_lang_vw where range_type='A' and language_id='"+localeName+"' and  eff_status ='E' order by 2");

					      	rs = pstmt.executeQuery() ;

							if( rs != null )
							{
								while( rs.next() )
								{
									String range_id 	= rs.getString( "range_id" ) ;
									String long_desc 	= rs.getString( "long_desc" ) ;
									out.println( "<option value='"+range_id+"' >"+long_desc+"</option>") ;
								}
					      	}
						}catch(Exception e) { }
						finally
						{
							try
							{
							if (rs != null) rs.close();
							if (pstmt != null) pstmt.close();
							if(con!=null) ConnectionManager.returnConnection(con,request);
							}
							catch(Exception e) { }
						}
				
					%>	</select><img  id='imgAgeGrop' src='../../eCommon/images/mandatory.gif' style="display:none" ></img>
				</td>
			</tr>
			<tr><td class='label' colspan='3'>&nbsp;</td></tr>
<!-- <tr><tr>
	<td colspan=2 class='label'>&nbsp;</td>
</tr> -->
</table>
<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" value="">
<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
<input type="hidden" name="p_module_id" id="p_module_id" 	value="<%= p_module_id %>">
<input type="hidden" name="p_user_name" id="p_user_name"	value="<%= p_user_name %>">
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

