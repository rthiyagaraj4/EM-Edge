<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*,eCommon.Common.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>  

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<!--<object id="locale" classid="clsid:C0276E18-D808-4F12-829E-BC186831D396" CODEBASE="../../eCommon/js/Locale.CAB#version=1,0,0,0"></object>-->

    <script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script> 
    <Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script> 
    <Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
    <Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
	<Script src="../../eAE/js/AEDownTimePatientsList.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

  
	<%
	Connection        con					= null;
	try {
			con=ConnectionManager.getConnection(request);
			String Site							= request.getParameter("Site");
			if(Site == null)	
				Site="DS";
			request.setCharacterEncoding("UTF-8");
			String locale						= (String)session.getAttribute("LOCALE");
			String facility_id					= (String)session.getValue("facility_id");
			String selected						="" ;



			String p_module_id				= "AE" ;
			String p_report_id				= "AEDTPATL" ;
			String p_resp_id				= (String)session.getValue("responsibility_id");
			
			Properties p;		
			p = (Properties) session.getValue("jdbc");
			String userId						= (String)session.getAttribute("login_user");
		
			
			HashMap hashMap						= new HashMap();
			hashMap								= eMP.ChangePatientDetails.getSetupData(facility_id,"",con,p);
			String pat_ser_access_by_user_yn	= checkForNull((String)hashMap.get("PAT_SER_ACCESS_BY_USER_YN"));
			hashMap.clear();
						

			HashMap ResultParamHashMap			= new HashMap();
			HashMap sqlColumns					= new HashMap();
			sqlColumns.put("emeg_pat_ser_grp","S");
			
			String whereClause					= "where module_id='MP'";
			ResultParamHashMap					= CommonBean.getParamDetails(sqlColumns,whereClause,"MP_PARAM",con);
			String emeg_pat_ser_grp				= (String) ResultParamHashMap.get("emeg_pat_ser_grp");
			emeg_pat_ser_grp					= emeg_pat_ser_grp==null?"":emeg_pat_ser_grp;
			sqlColumns.clear();
			ResultParamHashMap.clear();
			String userAccessSql				= "";
			String callCount					= "N";
			String result						= "";
			String totPatientCount				= "";
			String usedPatientCount				= "";
			String unUsedpatientCount			= "";

			if(pat_ser_access_by_user_yn.equals("Y")){
				userAccessSql	= " and pat_ser_grp_code IN (SELECT pat_ser_grp_code FROM MP_PAT_SER_GRP_FOR_USER WHERE APPL_USER_ID = '"+userId+"') ";
			}
			Map ResultParamTreeMap			= eAE.AECommonBean.getDisasterPatientSeries(con,userId,locale,Site,facility_id,pat_ser_access_by_user_yn);
			


			%>
  <body onSelect="codeArrestThruSelect()" OnMouseDown="CodeArrest()"  onKeyDown = "lockKey()">
    <form name='downTimePatientListForm' id='downTimePatientListForm'  action="../../eCommon/jsp/report_options.jsp" target='messageFrame'  >
	<br><br><br><br><br><br><br><br>
<!--	<script>alert('Main')</script> -->
    <table width='20%' cellpadding='3' cellspacing='3' border='0' align='center'>
		<tr>
			<td  class='label'  nowrap width='10%'><fmt:message key="eMP.PatientSeries.label" bundle="${mp_labels}"/></td>
            <td class='fields'  width='10%'>
            <%
				%>
	
						<select name='p_pat_ser_grp_code' id='p_pat_ser_grp_code' onchange="return geDownTimePatientListCount(this.value)">
							<option value=''>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</Option>
							<%
								ResultParamTreeMap = CommonBean.sortByValuesMap(ResultParamTreeMap);
								Iterator count = ResultParamTreeMap.entrySet().iterator();
								while (count.hasNext()) {
									
									Map.Entry patSeries	 = (Map.Entry)count.next();
									String patSerCode	 = (String) patSeries.getKey();
									String patSerDesc	 = (String) patSeries.getValue();
									selected			 = emeg_pat_ser_grp.equals(patSerCode)?"selected":"";
									if(selected.equals("selected")){
										callCount		 = "Y";
									}
									out.println("<option value=\""+patSerCode+"\" "+selected+">"+patSerDesc+"</option>");
									count.remove();
								}
							%>
						</select><img src='../../eCommon/images/mandatory.gif' align='center'></img>
            </td>
			</tr>
			<%
				if(callCount.equals("Y")){
						result	= eAE.AECommonBean.getDownTimePatientsListCount(con,emeg_pat_ser_grp,facility_id);

						StringTokenizer st = new StringTokenizer(result,"||");
						int i	= 0;
						while(st.hasMoreTokens()){
							if(i==1){
								usedPatientCount	= st.nextToken();
							}
							if(i==2){
								unUsedpatientCount	= st.nextToken();
							}
							if(i==3){
								totPatientCount	= st.nextToken();
							}
							i++;
						}
				}
							
			%>

			<tr>
				<td  class='label' nowrap><fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Patients.label" bundle="${common_labels}"/></td>
				<td class='fields'><input type='textbox' name='p_total_patients' id='p_total_patients' disabled size="6" value="<%=totPatientCount%>" ></td>
			</tr>
			<tr>
				<td  class='label' nowrap><fmt:message key="Common.used.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Patients.label" bundle="${common_labels}"/></td>
				<td class='fields'><input type='textbox' name='p_used_patients' id='p_used_patients' disabled size="6"  value="<%=usedPatientCount%>"></td>
			</tr>
			<tr>
				<td  class='label' nowrap><fmt:message key="Common.unused.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Patients.label" bundle="${common_labels}"/></td>
				<td class='fields'><input type='textbox' name='p_unused_patients' id='p_unused_patients' disabled size="6"  value="<%=unUsedpatientCount%>"></td>
			</tr>
			
			<tr>
				<td  class='label' nowrap><fmt:message key="Common.patient.label" bundle="${common_labels}"/>&nbsp<fmt:message key="Common.Selection.label" bundle="${common_labels}"/></td>
				<td class='fields'>
					<select name='p_list_value' id='p_list_value'>
						<option value='U'><fmt:message key="Common.used.label" bundle="${common_labels}"/></Option>
						<option value='UN' selected><fmt:message key="Common.unused.label" bundle="${common_labels}"/></Option>
						<option value='ALL'><fmt:message key="Common.all.label" bundle="${common_labels}"/></Option>
					</select>
				</td>
			</tr>

			<tr>
				<td  class='label' nowrap><fmt:message key="eAE.NoOfPatientIDsToBePrinted.label" bundle="${ae_labels}"/></td>
				<td class='fields'><input type="radio" name="p_patient_selection" id="p_patient_selection" onclick="fnEnableTextBox(this);" value="N"/> <input type="textbox" name="p_patient_count" id="p_patient_count" size="6" maxlength="6" disabled onkeypress="return allowValidNumber(this,event,6, 0);" onblur="fnChkAlphaNumericForAltIds(this)"/><img src='../../eCommon/images/mandatory.gif' align='center' name="man_gif" style="visibility:hidden;"></td>
			</tr>
			<tr>
				<td  class='label' nowrap><fmt:message key="Common.all.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.patientId.label" bundle="${common_labels}"/>s</td>
				<td class='fields'><input type="radio" name="p_patient_selection" id="p_patient_selection" onclick="fnEnableTextBox(this);" value="A" checked/> </td>
			</tr>
			
	</table>
	<br>

	<input type='hidden' name='default_p_pat_ser_grp_code' id='default_p_pat_ser_grp_code' value='<%=emeg_pat_ser_grp%>' />
	<input type="hidden" name="p_dtype" id="p_dtype"			value="Y">
	<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= userId %>">
	<input type="hidden" name="p_resp_id" id="p_resp_id"			value="<%= p_resp_id %>">

 <%
		 }
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
   finally
      {
  	    ConnectionManager.returnConnection(con,request);
      }
 %>	
 


   </form>
	</body>
	<%!
	// To Handle java.lang.NullPointerException.
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equals(""))) ? "" : inputString );
	}

%>
	</html> 

