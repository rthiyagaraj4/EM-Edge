<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<% request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff"); %>
<html>
<head>
  <%String sStyle	=
   (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
  <link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
  <Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
  <script src="../../eCommon/js/common.js" language="javascript"></script>
  <script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
  <script src="../../eCommon/js/DateUtils.js"></script>
<script src="../../eMR/js/MRReports.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%

  String sys_date = "";
  String Step = request.getParameter("Step");
  if(Step == null || Step.equals("null"))	Step = "";
  
  if(Step.equals("TWO"))
  {
    String p_module_id      = "MR" ;
    String p_report_id      = "MRRMICDS" ;
    String p_facility_id    = (String) session.getValue( "facility_id" ) ;
    String p_user_name      = (String) session.getValue( "login_user" ) ;
%>

		<BODY onMouseDown="CodeArrest();" onKeyDown='lockKey()' onLoad="Focusing('p_fr_discharge_date')">
		<br>
		<br>
		<form name="repDischargeStats" id="repDischargeStats" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
		<table width='60%' align='center' valign='top' cellpadding='3' cellspacing='0'>
			<tr>
			<td class="COLUMNHEADER" colspan='3'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></td>
			</tr>
						<tr>
							<td class='label' width="30%">&nbsp;</td>
							<td class="querydata" width="30%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
							<td class="querydata" width="40%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
						</tr>
						<tr>
							<td class="label"><fmt:message key="Common.dischargedate.label" bundle="${common_labels}"/></td>
							<td class='fields'>
							<input type=text  name='p_fr_discharge_date' id='p_fr_discharge_date' size="10" maxlength="10" align="center" onblur="validDateObj(this,'DMY',localeName);"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_fr_discharge_date');"/>

							<td class='fields'> 
							<input type=text  name='p_to_discharge_date' id='p_to_discharge_date' size="10" maxlength="10" align="center" onblur="validDateObj(this,'DMY',localeName);_GRDate1(this);"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_to_discharge_date');"/>
						</tr>
						<tr>
							<td class="label"><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
							<td class='fields' colspan='2'><select name="p_type" id="p_type" onChange="setValue(this);">
								<option value="S"><fmt:message key="Common.Summary.label" bundle="${common_labels}"/></option>
								<option value="D"><fmt:message key="Common.Detail.label" bundle="${common_labels}"/></option>
								</select>
							</td>
						</tr>
						<tr>
	   <td align ='left' class = "label" id=""><fmt:message key="Common.diagnosis.label" bundle="${mr_labels}"/>&nbsp;<fmt:message key="Common.Set.label" bundle="${mr_labels}"/></td>
	   <td id="p_mds_type" align ='left' colspan='2'>
	   <SELECT name="p_diag_set" id="p_diag_set"  >
	   <option value=''>------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -------</option>
	  

	  <%
		  Connection con =null;
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null ;

		 
	 con=ConnectionManager.getConnection(request);
	 stmt = con.createStatement();

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
						//out.println(e.toString());
						e.printStackTrace();
					}
		   try 
			 {
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
}catch(Exception e) { }
					finally
					{
						try 
						{
						if(stmt!=null) stmt.close();
						if(rs!=null) rs.close();
						if(con!=null) con.close();
						}
						catch(Exception e) { }
					}


					
			%>	   
	   </SELECT><img src='../../eCommon/images/mandatory.gif'  style="visibility">
	 </td>
     </tr>
						<tr>
							<td class='label' colspan='3'>&nbsp;</td>
						</tr>
		</table>
		<input type="hidden" name="p_facility_id" id="p_facility_id"       value="<%= p_facility_id %>">
		<input type="hidden" name="p_module_id" id="p_module_id"         value="<%= p_module_id %>">
		<input type="hidden" name="p_report_id" id="p_report_id"         value="<%= p_report_id %>">
		<input type="hidden" name="p_user_name" id="p_user_name"         value="<%= p_user_name %>">
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

		
	<%
  }
  else
  {
	  String URL = "../../eCommon/jsp/commonToolbar.jsp?";
	  String params = request.getQueryString();
	  String source = URL + params;
%>

<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder='0' scrolling='no'  style='height:8vh;width:100vw'></iframe>
  <iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eMR/jsp/repDischargeStatbyICDSex.jsp?Step=TWO' scrolling='no'  frameborder='0' style='height:80vh;width:100vw'></iframe>
  <iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='auto'  frameborder='0' style='height:12vh;width:100vw'></iframe>

<%
  }
%>
</html>


