<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
	<script language='javascript' src='../../eCommon/js/common.js' ></script>
	<script language='javascript' src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language='javascript' src="../../eMR/js/MRReports.js"></script>
	<script src="../../eCommon/js/DateUtils.js"></script>
	<script language='javascript' src='../../eCommon/js/dchk.js' ></script>
</head>

<%
  request.setCharacterEncoding("UTF-8");
  request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
  
  String URL = "../../eCommon/jsp/commonToolbar.jsp?";
  String params = request.getQueryString();
  String source = URL + params;
  String call_from=request.getParameter("call_from");
  if(call_from==null) call_from="";
if (call_from.equals("MAIN"))
{
  String p_user_name		= (String) session.getValue( "login_user" ) ;
  Connection con = ConnectionManager.getConnection(request);
  ResultSet rs   = null;
  Statement stmt = null;

 // Statement stmt1=null;
 // ResultSet rs1   = null;

	

	try {
		String str = "select to_char(sysdate,'dd/mm/yyyy') from dual";
		String CurrentDate="";
		stmt=con.createStatement();
		rs = stmt.executeQuery(str);	
		while (rs.next())
			CurrentDate= rs.getString(1);
		if(stmt!=null) stmt.close();
		if(rs!=null)	rs.close();

	stmt = con.createStatement();
	String pat_length="";
    String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	rs=stmt.executeQuery("select patient_id_length from mp_param");
	if (rs!=null&&rs.next())
       pat_length = rs.getString(1);
%>

<body onLoad="FocusFirstElement()"  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey(event)'>
   <form name = 'search_form' action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
	<br><br><br><br>
      <div>
        <table cellpadding='3' cellspacing='0' width='60%'  align='center' colspan='3'>
          <tr class='label'>
            <td class='label' colspan='4'>&nbsp;</td>
           </tr>
          <tr>
					<td width='25%' class="label"><fmt:message key="Common.encountertype.label" bundle="${common_labels}"/></td>
					<td width='25%' class='fields'><select name='p_enc_type' id='p_enc_type'><option value='O'><fmt:message key="Common.Outpatients.label" bundle="${common_labels}"/><option value='I'><fmt:message key="Common.Inpatients.label" bundle="${common_labels}"/></select>
					</td>
					<td width='25%' class='label'>&nbsp;</td>
					<td width='25%' class='label'>&nbsp;</td>
          </tr>
		 <tr>
					<td class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
					<td class='fields'>
						<input type=text  name='p_patient_id' id='p_patient_id' size=<%=pat_length%> maxlength=<%=pat_length%> onBlur="ChangeUpperCase(this);disbutt(this)" align="center"><input type='button' name='patient_id' id='patient_id' value='?' class='button' onclick='callSearchScreen()'><img src="../../eCommon/images/mandatory.gif"></img>
					</td>
					<td class="label"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
					<td class='fields'>	<input type=text  name='p_encounter_id' id='p_encounter_id' size="12" maxlength="12" onKeyPress='return(ChkNumberInput(this,event,0))' onBlur="CheckNumVal(this)" align="center"><input type='button' name='encounter_id' id='encounter_id' value='?' class='button' onclick='searchCoderepProcEnc(this, p_encounter_id)' disabled><img src="../../eCommon/images/mandatory.gif"></img>
					</td>
          </tr>
		 <tr>
             <td class='label'><fmt:message key="Common.fromdate.label" bundle="${common_labels}"/></td>
             <td class='fields'>
               <input 'text' id='birthfrom' name='p_fm_proc_date' id='p_fm_proc_date' value='' size='10' maxlength='10' title='From proc Date' Onblur="validDateObj(this,'DMY','<%=localeName%>');_FromDate(this)"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('birthfrom');"/></input>
              </td>

             <td class='label'><fmt:message key="Common.todate.label" bundle="${common_labels}"/></td>
			 <td class='fields'>
               <input 'text' id='birthto' name='p_to_proc_date' id='p_to_proc_date' value='' size='10' maxlength='10' title='To proc Date' Onblur="validDateObj(this,'DMY','<%=localeName%>');_ToDate(this)"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('birthto');"/>
             </td>
		</tr>
		<!--31/12/2008 -->
		<tr>
		<td  class='label'><fmt:message key="Common.Procedure.label" bundle="${common_labels}"/> <fmt:message key="Common.Set.label" bundle="${common_labels}"/></td>
			 <td class='fields'>
			 <select name='p_proc_set' id='p_proc_set'><option value='ALL'><fmt:message key="Common.all.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;</option>
			
			<%
			 stmt = con.createStatement();
	    
		  String sql1 = "select term_set_id,term_set_desc from mr_term_set where proc_spec_yn='Y' and eff_status='E' order by term_set_desc";

	     rs = stmt.executeQuery(sql1);
	      if( rs != null )
	      {
	          while( rs.next())
	          {
	        	String term_set_id = rs.getString("term_set_id") ;
	        	String term_set_desc=rs.getString("term_set_desc");
	

%>
			<option value='<%= term_set_id %>'><%= term_set_desc %></option>
<%
			  }
		  }

			%>
			 </select>
              
             </td>
		</tr>
		   <tr class='label'><td class='label' colspan='4'>&nbsp;</td></tr>
        </table>
     </div>
	 	<%if(localeName.equals("en"))
	{%>
	<!-- <INPUT TYPE="hidden" name="p_passing_local_date" id="p_passing_local_date" value="N"> -->
	<%}
	else if(localeName.equals("th"))
	{
		%>
	<INPUT TYPE="hidden" name="P_passing_local_date" id="P_passing_local_date" value="Y">
	<%}%>
	
     <input type='hidden' name='call_function' id='call_function' value=''></input>
     <input type='hidden' name='p_report_id' id='p_report_id' value='MRBENPRC'></input>
     <input type='hidden' name='p_module_id' id='p_module_id' value='MR'></input>
     <input type= 'hidden' name='p_facility_id' id='p_facility_id' value='<%=p_facility_id%>'></input>
     <input type='hidden' name='p_user_name' id='p_user_name' value='<%=p_user_name%>'></input>
	 <input type="hidden" name="CurrentDate" id="CurrentDate"			value="<%= CurrentDate %>">
<%
     } catch(Exception e) {
         // out.println(e.toString());
		 e.printStackTrace();
          if (rs != null) rs.close();
          if (stmt != null) stmt.close();
     }
     finally {
		 try
		 {
          if (rs != null) rs.close();
          if (stmt != null) stmt.close();
		 }
catch(Exception e) { }
		  ConnectionManager.returnConnection(con,request);

     }
%>
  </form>
</body>

</html>
<%}
else
{
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder='0' scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
  <iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eMR/jsp/repProcEncounter.jsp?call_from=MAIN' scrolling='no' noresize frameborder='0' style='height:83vh;width:100vw'></iframe>
  <iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='auto' noresize' frameborder='0' style='height:8vh;width:100vw'></iframe>

<%}%>
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

