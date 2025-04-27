<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
   <script src="../../eMR/js/MRReports.js" language="javascript"></script>
         <script src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		 <script>
		 function resetValues(){
			 document.forms[0].p_fr_diagnosis_code.value="";
			 document.forms[0].p_to_diagnosis_code.value="";
			 document.forms[0].p_fr_clinic_code.value="";
		
			 
			 document.forms[0].p_to_clinic_code.value="";
   }



   function ComparePeriodFromToTime(from,to)
    {
	
    var frdt = from.value;
	var tdt = to.value;
	var greg_tdt = "";
	var greg_frdt = "";

	if(frdt !="" && validDate(frdt,"DMY","en"))
	{
		greg_frdt = convertDate(frdt,"DMY",localeName,"en");
		
	}

	if(to !="" && validDate(tdt,"DMY","en"))
	{
		greg_tdt = convertDate(tdt,"DMY",localeName,"en");
	}

	if(greg_frdt != "" && greg_tdt !="")
	{

		
		if(greg_tdt < greg_frdt)
		{
		
			alert( getMessage("TO_DT_GR_EQ_FM_DT",'SM') );
			document.forms[0].p_to_diag_date.focus();
			document.forms[0].p_to_diag_date.select();
		}
	}
}

//july 13 2010
function validate_date(obj) {
	
		if(obj.value!=''){

			if(isBeforeNow(obj.value,"DMY",localeName))
				return true;
			else {
				alert(getMessage("START_DATE_GREATER_SYSDATE","COMMON"));
				obj.select();
				obj.focus();
				return false ;
			}
		}
  }
		 </script>



</head>


<%
  request.setCharacterEncoding("UTF-8");
  request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
  String Step = request.getParameter("Step");
  if(Step == null || Step.equals("null"))	Step = "";
  
  if(Step.equals("TWO"))
  {
    String p_module_id      = "MR" ;
    String p_report_id      = "MRROPNOT" ;
    String p_facility_id    = (String) session.getValue( "facility_id" ) ;
    String p_user_name      = (String) session.getValue( "login_user" ) ;

	%>
  
	<%
		Connection con =null;
		 
		Statement stmt=null;
     ResultSet rs=null;
%>

	<BODY onMouseDown="CodeArrest();" onKeyDown='lockKey()' onLoad="Focusing('p_fr_diag_date')">
	<br>
	<br>
	<form name="repNotifiableCases" id="repNotifiableCases" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
	<%
		
     String str = "select to_char(sysdate,'dd/mm/yyyy') from dual";
     String CurrentDate=" ";
	try{
		 con  =  ConnectionManager.getConnection(request);
		stmt=con.createStatement();
		rs = stmt.executeQuery(str);	
		while (rs.next())
			CurrentDate= rs.getString(1);
		

	}
	catch(Exception e)
	{}
	finally
	{
		if(stmt!=null) stmt.close();
		if(rs!=null)	rs.close();
		ConnectionManager.returnConnection(con,request);
	}
%>
	<%
		
		 con  =  ConnectionManager.getConnection(request);
	   
		stmt = con.createStatement(); 
		String sql = "" ;
		String sql1="";
		



		//sql = "Select PRACT_TYPE, DESC_USERDEF From AM_PRACT_TYPE Where EFF_STATUS = 'E' order by 2" ;
		sql= "Select PRACT_TYPE, DESC_USERDEF From AM_PRACT_TYPE_lang_vw Where language_id='"+localeName+"' AND EFF_STATUS = 'E' order by 2";
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
		 //}
		 /*catch(Exception e){/* out.println(e); e.printStackTrace();}
		 finally
		 {
			 try
			 {
			if(rset != null)    rset.close();
			if(stmt != null)    stmt.close();
			 }
			 catch(Exception e){}
			 ConnectionManager.returnConnection(con,request);
		 }*/

	%>
	

	<table width='80%' align='center' valign='top' cellPadding='3' cellSpacing='0'>
		<tr>
		<td class="COLUMNHEADER" colspan='3'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></td>
		</tr>
					<tr class='label'>
						<td class='label' colspan='3'>&nbsp;</td>
					</tr>
					<tr>
						<td width='30%' class="label"><fmt:message key="Common.encountertype.label" bundle="${common_labels}"/></td>
						<td width='25%' class='fields'>
						<select name="encounter_type" id="encounter_type">
						<option value="I"><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></option>
						<option value="O"><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></option>
						</select>
						</td>
						<td width='25%' class='label'>&nbsp;</td>
					</tr>
					<tr>
						<td class='label' >&nbsp;</td>
						<td class="querydata" ><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
						<td class="querydata" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					</tr>
					<tr>
						<td class="label"><fmt:message key="Common.DiagnosisDate.label" bundle="${common_labels}"/></td>
						<td class='fields'>
						<input type='text' id='birthfrom' name='p_fr_diag_date' id='p_fr_diag_date' size="10" maxlength="10" align="center" onblur="validDateObj(this,'DMY','<%=localeName%>');validate_date(this);"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('birthfrom');"/>

						<td class='fields'> 
						<input type='text' id='birthto' name='p_to_diag_date' id='p_to_diag_date' size="10" maxlength="10" align="center" onblur="validDateObj(this,'DMY','<%=localeName%>');validate_date(this);"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('birthto');"/>
					</tr>

<!--02/01/2008 spr-6747 -->
					<tr>
						<td class="label">
						<fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Set.label" bundle="${common_labels}"/>
						</td>
						<td class='fields' colspan="3">
							<select name='p_diag_set' id='p_diag_set' onchange="resetValues()">
							<option value=''>------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -------</option>
							
			<%
				stmt = con.createStatement();
	    
				sql1 = "select term_set_id,term_set_desc from mr_term_set where diag_spec_yn='Y'   and EFF_STATUS='E'  order by term_set_desc";
				rs = stmt.executeQuery(sql1);
				if( rs != null )
				{
					 while( rs.next())
					{
				String term_set_id = rs.getString("term_set_id") ;
				String	term_set_desc=rs.getString("term_set_desc");
	


			%>

				<option value='<%=term_set_id%>'><%=term_set_desc%></option>
				<%
					}
				}
				


					%>
							</select><img src='../../eCommon/images/mandatory.gif' id='user_id_img' style="visibility"></td>
					</tr>


					<tr>
						<td class="label"><fmt:message key="Common.DiagnosisCode.label" bundle="${common_labels}"/></td>
						<td class='fields'><input type=text  name='p_fr_diagnosis_code' id='p_fr_diagnosis_code' size="5" maxlength="5" align="center"><input type='button' name='Diagnosis' id='Diagnosis' value='?' class='button' onclick='searchCoderepVisitNotifiable(this, p_fr_diagnosis_code)'></td>
						<td class='fields'> <input type=text  name='p_to_diagnosis_code' id='p_to_diagnosis_code' size="5" maxlength="5" align="center"><input type='button' name='Diagnosis' id='Diagnosis' value='?' class='button' onclick='searchCoderepVisitNotifiable(this, p_to_diagnosis_code)'></td>
					</tr>
					<tr>
						<td class="label"><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/></td>
						<td class='fields'><input type=text  name='p_fr_clinic_code' id='p_fr_clinic_code' size="4" maxlength="4" align="center"><input type='button' name='locationcode' id='locationcode' value='?' class='button' onclick='searchCoderepVisitNotifiable(this, p_fr_clinic_code)'></td>
						<td class='fields'> <input type=text  name='p_to_clinic_code' id='p_to_clinic_code' size="4" maxlength="4" align="center"><input type='button' name='locationcode' id='locationcode' value='?' class='button' onclick='searchCoderepVisitNotifiable(this, p_to_clinic_code)'></td>
					</tr>
					<tr>
						<td class="label"><fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/></td>
						<td class='fields'><select name="fm_pract_type" id="fm_pract_type">
							<option value="">&nbsp;------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -------&nbsp;</option>
							<%=StrVal.toString()%>
							</select>
						</td>
						<td class='fields'><select name="to_pract_type" id="to_pract_type">
							<option value="">&nbsp;------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -------&nbsp;</option>
							<%=StrVal.toString()%>
							</select>
						</td>
					</tr>
					<tr>
						<td class="label"><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></td>
						<td class='fields'  ><input type=text  name='p_fr_physician_id' id='p_fr_physician_id' size="15" maxlength="15" align="center"><input type='button' name='Practitionerid1' id='Practitionerid1' value='?' class='button' onclick='searchCoderepVisitNotifiable(this, p_fr_physician_id)'></td>
						<td class='fields'> <input type=text  name='p_to_physician_id' id='p_to_physician_id' size="15" maxlength="15" align="center"><input type='button' name='Practitionerid2' id='Practitionerid2' value='?' class='button' onclick='searchCoderepVisitNotifiable(this, p_to_physician_id)'></td>
					</tr>
					<tr class='label'>
						<td class='label' colspan='3'>&nbsp;</td>
					</tr>
	</table>
		 	 	<%if(localeName.equals("en"))
	{%>
	<!-- <INPUT TYPE="hidden" name="p_passing_local_date" id="p_passing_local_date" value="N"> -->
	<%}
	else if(localeName.equals("th"))
	{%>
	<INPUT TYPE="hidden" name="P_passing_local_date" id="P_passing_local_date" value="Y">
	<%}%>
	
	<input type="hidden" name="p_facility_id" id="p_facility_id"       value="<%= p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id"         value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id"         value="<%= p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"         value="<%= p_user_name %>">
	<input type="hidden" name="CurrentDate" id="CurrentDate"	 value="<%= CurrentDate %>">

	<% 
		}catch(Exception e){/* out.println(e); */e.printStackTrace();}
		 finally
		 {
			 try
			 {
			if(rset != null)    rset.close();
			if(stmt != null)    stmt.close();

			if (rs != null) rs.close();
			//if (stmt != null) stmt.close();
			 }
			 catch(Exception e){}
			 ConnectionManager.returnConnection(con,request);
		 }
		 %>
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

<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder='0' scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
  <iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eMR/jsp/repVisitNotifiableCases.jsp?Step=TWO' scrolling='no' noresize frameborder='0' style='height:84vh;width:100vw'></iframe>
  <iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='auto' noresize' frameborder='0' style='height:8vh;width:100vw'></iframe>

<%
  }
%>
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

