<!DOCTYPE html>
<!--Created by Ashwini on 24-May-2017 for ML-MMOH-CRF-0610-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*,com.ehis.util.*,webbeans.eCommon.*,org.json.simple.parser.JSONParser,org.json.simple.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
  
  <link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
  <link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
  <Script language='javaScript' src="../../eCommon/js/CommonCalendar.js"></Script>  
  <script language='javascript' src='../../eCommon/js/common.js' ></script>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>  
  <script language='javascript' src='../../eCommon/js/dchk.js' ></script>
  <script language='javascript' src="../../eCommon/js/FieldFormatMethods.js"></script>  
  <script language='javascript' src='../../eCommon/js/DateUtils.js'></script>  
  <script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
  <script src='../../eOA/js/OAAppointmentHistory.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>

<script>
function clearResult()
{	
	parent.frames[2].document.location.href="../../eCommon/html/blank.html";
}
</script>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
Connection con = null;
Statement stmt=null;
ResultSet rset=null;
Statement stmt1=null;
ResultSet rs=null;
String p_module_id	= "OA" ;
String p_report_id	= "OAAPHISD" ;
String p_user_name	= (String) session.getValue( "login_user" ) ;
String locale = (String)session.getAttribute("LOCALE");
String facility_id = checkForNull((String)session.getValue("facility_id"));
String function_id = request.getParameter("function_id")==null?"":request.getParameter("function_id");

try
{
	con = ConnectionManager.getConnection(request);
	
	stmt1 = con.createStatement();
	String pat_length="";

	rs=stmt1.executeQuery("select patient_id_length from mp_param");
	if (rs!=null && rs.next())
		pat_length = checkForNull(rs.getString(1));

	if(rs!=null)	rs.close();
	if(stmt1!=null)	stmt1.close();

	if(pat_length == null || pat_length.equals("null")) pat_length = "10";

%>
	<body onLoad="FocusFirstElement();populateLocations(document.forms[0].location_type)"  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
	   <form name = 'Appt_history_form'  target="messageFrame" <%if(function_id.equals("APPT_HISTORY_REPORT")){%>action='../../eCommon/jsp/report_options.jsp'<%}%> >	
	  
			<table cellpadding='2' cellspacing='0' width='95%' align='center' > 
				<tr><td colspan='3'>&nbsp;</td></tr>
				<tr>
					<td width='20%' class='label' nowrap><fmt:message key="Common.AppointmentDate.label" bundle="${common_labels}"/> <fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td width='20%' class="fields"><input 'text' id='datefrom' name='frm_appt_date' id='frm_appt_date' value='' size='10' maxlength='10' onblur="ComparePeriodFromToTime(this,to_appt_date); validDateObj(this, 'DMY', locale);" onkeypress="return Valid_DT(event)"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('datefrom');"></img> 
					</td>

					<td width='20%' class='label' nowrap><fmt:message key="Common.AppointmentDate.label" bundle="${common_labels}"/> <fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					<td width='20%' class="fields"><input 'text' id='dateto' name='to_appt_date' id='to_appt_date' value='' size='10' maxlength='10' onblur="ComparePeriodFromToTime(frm_appt_date,this); validDateObj(this, 'DMY', locale);" onkeypress="return Valid_DT(event)" ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('dateto');"></img>
					</td>
				</tr>
				
				<tr>
					<td width='20%' class=label ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
					<td width='20%' class='fields'>
						<select name='speciality' id='speciality'> 
						<option value=''>-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -------- </option>
						<%
						JSONArray SpecJsonArr	= new JSONArray();
						SpecJsonArr  = eOA.OACommonBean.getSpeciality(con,locale);
						String speciality_code ="";
						
						for(int i = 0 ; i < SpecJsonArr.size() ; i++) 
						{
								JSONObject json	= (JSONObject)SpecJsonArr.get(i);
								String Spec_short_desc  = (String) json.get("short_desc");
								speciality_code  = (String) json.get("speciality_code");
								
								out.println("<option value='"+speciality_code+ "'>"+Spec_short_desc+"</option>");	
						}
						%>
						</select>
					</td>

					<td width='20%' class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/> </td>
					<td class="fields" width='20%'>
						<input type=text  name='PatientId' id='PatientId'  onBlur="makeValidString(this);ChangeUpperCase(this);validatePatientId(this);" onKeypress='return CheckForSpecChars(event);' align="center" size="" maxlength=<%=pat_length%>><input type='button' name='patient_id' id='patient_id' value='?' class='button' onclick='callSearchScreen()'><img src="../../eCommon/images/mandatory.gif"></img>
					</td>	
				</tr>

				 <tr>
					<td width='20%' class=label ><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
					<td width='20%' class='fields' >
						<select name='location_type' id='location_type' onChange="javascript:populateLocations(this)">
						<option value=''>-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -------- </option>
						<%
						JSONArray LocJsonArr	= new JSONArray();
						LocJsonArr  = eOA.OACommonBean.getLocationType(con,locale);	
						
						for(int i = 0 ; i < LocJsonArr.size() ; i++) 
						{
								JSONObject json1	= (JSONObject)LocJsonArr.get(i);
								String loc_short_desc  = (String) json1.get("short_desc");
								String care_locn_type_ind  = (String) json1.get("care_locn_type_ind");
								
								out.println("<option value='"+care_locn_type_ind+ "'>"+loc_short_desc+"</option>");	
						}
						%>
						</select>
					</td>
						
					<td width='20%' class=label ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>		
					<td class='fields' width='20%'>
						<input type='text' name='b_loc_val' id='b_loc_val' size='25' maxlength='25' value='' onBlur="ena_loc_lookup(this);"><input type='button' name="b_loc_search" id="b_loc_search" value="?" onClick="open_loc_lookup()" class='button' >
					<input type="hidden" name="b_loc" id="b_loc" value="">
					<input type="hidden" name="b_loc_id" id="b_loc_id" value="">
					</td>
				</tr>	

				<tr>
					<td width='20%' class="label" nowrap><fmt:message key="Common.resourcetype.label" bundle="${common_labels}"/></td>			
					<td width='20%' class='fields'>
					  <SELECT name='resourceType_1' id='resourceType_1'  onchange="enable_dsiable_res(this)" disabled>
						<option value=''>-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -------- </option>
						<option value='P' ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/> </option>
						<option value='E'><fmt:message key="Common.equipment.label" bundle="${common_labels}"/></option>
						<option value='R'><fmt:message key="Common.room.label" bundle="${common_labels}"/> </option>
						<option value='O'><fmt:message key="Common.other.label" bundle="${common_labels}"/> </option>
					 </SELECT>	
					</td>
					<jsp:include page="../../eOA/jsp/OAResourcelookupframe.jsp" ><jsp:param name="flush" value="true" />
					<jsp:param name ="from_page" value= "query" />
					<jsp:param name ="pract_value" value= "" />
					</jsp:include>
			   </tr>
			   <tr>
					<td width='20%' class="label" nowrap><fmt:message key="Common.service.label" bundle="${common_labels}"/> <fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td width='20%' class='fields'>
						<input type="text" name="p_fm_service_code" id="p_fm_service_code" size="20" maxlength="20" onblur='onBlurServLkp(this, p_fm_service_code,p_fm_service,service_frm)'><input type="hidden" name="p_fm_service" id="p_fm_service"><input type='button' name='service' id='service' value='?' class='button' onclick='serviceLkp(this, p_fm_service_code,p_fm_service, service_frm)'>
						<input type="hidden" name="service_frm" id="service_frm" value="">
					</td>
					<td width='20%' class="label" nowrap><fmt:message key="Common.service.label" bundle="${common_labels}"/> <fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					<td width='20%' class='fields'>
						<input type="text" name="p_to_service_code" id="p_to_service_code" size="20" maxlength="20" onblur='onBlurServLkp(this, p_to_service_code,p_to_service, service_to)'><input type="hidden" name="p_to_service" id="p_to_service"><input type='button' name='service1' id='service1' value='?' class='button' onclick='serviceLkp(this, p_to_service_code,p_to_service, service_to)'>
						<input type="hidden" name="service_to" id="service_to" value="">
					</td>
				</tr>
		
		<tr><td colspan='3'>&nbsp;</td></tr>
			<%if(function_id.equals("QRY_APPT_HISTORY")){%>
				<tr> 
					<td colspan='3' class='label'>&nbsp;</td>
					<td class='button'><input type='button' class='button' name='search' id='search'   value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onClick='searchResult();'>&nbsp;<input type='button' class='button' name='clear' id='clear'   value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' onClick='clearResult();'></td>
				</tr>
		   <%}%>
		   </table>	
		   <input type='hidden' name='function_id' id='function_id' value='<%=function_id%>'></input>
		   <input type='hidden' name='locale' id='locale' value='<%=locale%>'></input>
		   <input type="hidden" name="p_module_id" id="p_module_id" value="<%=p_module_id%>"></input>
		   <input type="hidden" name="p_report_id" id="p_report_id" value="<%=p_report_id%>"></input>
		   <input type="hidden" name="p_facility_id" id="p_facility_id" value="<%=facility_id%>"></input>
		   <input type="hidden" name="p_language_id" id="p_language_id" value="<%=locale%>"></input>
		   <input type="hidden" name="from_appt_date" id="from_appt_date" value=""></input>
		   <input type="hidden" name="p_speciality_code" id="p_speciality_code" value=""></input>
		   <input type="hidden" name="p_patient_id" id="p_patient_id" value=""></input>
		   <input type="hidden" name="p_location_type" id="p_location_type" value=""></input>
		   <input type="hidden" name="p_location" id="p_location" value=""></input>
		   <input type="hidden" name="p_resource_type" id="p_resource_type" value=""></input>
		   <input type="hidden" name="p_resource_id" id="p_resource_id" value=""></input>
		   <input type="hidden" name="from_service_code" id="from_service_code" value=""></input>
		   <input type="hidden" name="to_service_code" id="to_service_code" value=""></input> 
		   <input type='hidden' name='p_user_name' id='p_user_name' value='<%=p_user_name%>'></input>
	  </form>
	</body>
</html>
<%
}catch(Exception e)
{
	//out.print(e.toString());
	e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally   
{
	if(rset!=null)	rset.close();
	if(stmt!=null)	stmt.close();
	if(con != null)
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

