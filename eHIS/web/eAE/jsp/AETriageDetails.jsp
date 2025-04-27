<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
  <script language='javascript' src='../../eCommon/js/common.js'></script>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
  <script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
  <script language='javascript' src='../../eAE/js/AETriageDetails.js'></script>
  <script language='javascript'>
    // To Make RTA Enabled or Disabled
	function setRTA(obj)
	{
		 if(obj.value != '')
	     { 
			var values			= obj.value.split("::");
			var accident_type	= values[0];
			var rta_yn			= values[1];
			document.forms[0].accident_type_val.value=accident_type;
			if(rta_yn=="Y")
				 document.forms[0].rta.disabled = false;
			else
			 {
		 		 document.forms[0].rta.disabled = true;
 		 		 document.forms[0].rta.value = '';
             }
		 }  
	}
  </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
        Connection con               = null;
    	PreparedStatement pstmt		 = null;
        ResultSet rset               = null ;
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		
		String strCA	=	request.getParameter("CA");
		String encounter_type		 = "";
		String heightDesc			 = "";
		String weightDesc			 = "";
		String circumDesc			 = "";
		String sysDateWithoutTime	 = "";
		String heightVal			 = "";
		String weightVal			 = "";
		String circumVal			 = "";
		int min_age_pregnancy		 = 0;
		int max_age_paediatric		 = 0;
		String sex					 = "";
		int  patient_age			 = 0;
		String paediatric_yn		 = "";
		String gynaec_yn			 = "";

		// Variables
		String ambulatory_status	 = "";
		String ambulatory_desc		 = "";
		String patient_type			 = "";
		String patient_desc			 = "";

		String accident_location	 = "";
		String protective_device_code= "";
		String protective_device_desc= "";
    	String burn_yn				 = "N";
		String degree_of_burn		 = "";
		String pat_position_code	 = "";
		String pat_position_desc	 = "";
		String incident_remarks		 = "";
		String trauma_yn			 = "";
		String blunt_injury_yn		 = "";
		String penetrating_injury_yn = "";
		String tetanus_admin_yn		 = "";
		String tetanus_admin_when	 = "";
		String pregnant_yn			 = "";
		String lmp_date				 = "";
		String gd_for_age_yn		 = "";
		String im_upto_date_yn		 = "";
		String height				 = "";
		String height_unit			 = "";
		String weight				 = "";
		String weight_unit			 = "";
		String circumference		 = "";
		String circumference_unit	 = "";	
		String disabledField		 = "";
		String height_code			 = "";
		String weight_code			 = "";
		String circumference_code	 = "";

		String facilityId			 = (String)session.getValue("facility_id");
			String patient_id		 = request.getParameter("patient_id");
			   patient_id			 = (patient_id == null)?"":patient_id;
	   	String clinic_code			 = request.getParameter("clinic_code");
			   clinic_code			 = (clinic_code == null)?"":clinic_code;
		String clinic_type			 = request.getParameter("clinic_type");
			   clinic_type			 = (clinic_type == null)?"":clinic_type;
		String clinic_desc			 = request.getParameter("clinic_desc");
		if(clinic_desc==null || clinic_desc.equals("") || clinic_desc=="")
				clinic_desc			 = "";
	    String treatment_area_code	 = request.getParameter("treatment_area_code");
			   treatment_area_code	 = (treatment_area_code == null)?"":treatment_area_code;
	    String treatment_area_desc	 = request.getParameter("treatment_area_desc");
			   treatment_area_desc	 = (treatment_area_desc == null)?"":treatment_area_desc;
		String encounter_id			 = request.getParameter("encounter_id");
			   encounter_id			 = (encounter_id == null)?"":encounter_id;
		String queue_status			 = request.getParameter("queue_status");
			   queue_status			 = (queue_status == null)?"":queue_status;

		try{
                con                  = ConnectionManager.getConnection(request);
				String sqlAmbulatory = " select AMBULATORY_STATUS, SHORT_DESC from AM_AMBULATORY_STATUS "+
									   " where EFF_STATUS='E' and nvl(eff_date_from,sysdate) >= sysdate "+
								       " and nvl(eff_date_to,sysdate) <= sysdate order by SHORT_DESC ";


				String sqlPatType	 = " select PATIENT_TYPE, SHORT_DESC from AM_PATIENT_TYPE "+
									   " where EFF_STATUS='E' and nvl(eff_date_from,sysdate) >= sysdate "+
									   " and nvl(eff_date_to,sysdate) <= sysdate order by SHORT_DESC ";


				String sqlProtDevice = " select PROTECTIVE_DEVICE_CODE, SHORT_DESC from AE_PROTECTIVE_DEVICE "+
									   " where EFF_STATUS='E' and  PROTECTIVE_DEVICE_CODE like '%%' order by SHORT_DESC ";


				String sqlPosition	= " select PAT_POSITION_CODE, SHORT_DESC from AE_PAT_POSITION "+
									  " where EFF_STATUS='E' order by SHORT_DESC ";

				String sqlUnit	    = " select UNIT_OF_LENGTH_NB, UNIT_OF_WT_NB, UNIT_OF_CIRCUM_NB,ALT_ID1_TYPE  from MP_PARAM ";

				String nationalDisp = " select NATIONAL_ID_NO, to_char(ALT_ID1_EXP_DATE,'dd/mm/yyyy'), SEX, round((sysdate-date_of_birth)/365,0) patient_age from MP_PATIENT  where PATIENT_ID = ? ";
				
		
				String displayVisit = " SELECT VISIT_BACKDATING_ALLOWED_YN, MIN_AGE_FOR_PREG_DTL, "+
									  " MAX_AGE_FOR_PAED_DTL, TO_CHAR(SYSDATE,'dd/mm/yyyy hh24:mi') end_date, "+
									  "	TO_CHAR(SYSDATE-(DECODE(VISIT_BACKDATING_ALLOWED_YN,'Y',MAX_HOURS_ALLOW_INSERT,0)*60)/1440,'dd/mm/yyyy hh24:mi') start_date FROM AE_PARAM  where  OPERATING_FACILITY_ID='"+facilityId+"'";
				
				
				
				String pat_emer_chk	=	"SELECT AE_ENCOUNTER_TYPE FROM AE_PAT_EMERGENCY_DETAIL b WHERE "+" FACILITY_ID = ? AND ENCOUNTER_ID= ? ";
				 pat_emer_chk=pat_emer_chk+" AND B.RECORDED_DATE=(SELECT MAX(RECORDED_DATE) FROM AE_PAT_EMERGENCY_DETAIL WHERE facility_id = b.facility_id AND encounter_id = b.encounter_id AND rownum < 2)";


				String sqlQuery		= " SELECT AMBULATORY_STATUS, AMBULATORY_DESC " +
									  "  PATIENT_TYPE, PATIENT_DESC, "+
					                  "  ACCIDENT_LOCATION, PROTECTIVE_DEVICE_CODE, PROTECTIVE_DEVICE_DESC, " +
									   " BURN_YN, DEGREE_OF_BURN, PAT_POSITION_CODE, PAT_POSITION_DESC, INCIDENT_REMARKS, " +
									  " TRAUMA_YN , BLUNT_INJURY_YN ,PENETRATING_INJURY_YN, TETANUS_ADMIN_YN, TETANUS_ADMIN_WHEN, "+
									  " PREGNANT_YN, to_char(LMP_DATE,'dd/mm/yyyy') LMP_DATE, "+
									  " to_char(SYSDATE,'dd/mm/yyyy')  sysDateWithoutTime , "+
									  " GD_FOR_AGE_YN , IM_UPTO_DATE_YN, HEIGHT, HEIGHT_UNIT, WEIGHT, "+
									  " WEIGHT_UNIT,  CIRCUMFERENCE, CIRCUMFERENCE_UNIT from AE_PR_ENCOUNTER_VW where "+
									  " FACILITY_ID = ? and ENCOUNTER_ID = ? ";

										pstmt = con.prepareStatement(sqlQuery);
										pstmt.setString(1, facilityId);
										pstmt.setString(2, encounter_id);
										rset = pstmt.executeQuery();
								    while(rset!=null && rset.next())
								    {
										ambulatory_status		= rset.getString("AMBULATORY_STATUS");
										ambulatory_status 		= (ambulatory_status== null)?"":ambulatory_status;
										ambulatory_desc			= rset.getString("AMBULATORY_DESC");
										ambulatory_desc 		= (ambulatory_desc== null)?"":ambulatory_desc;
										patient_type			= rset.getString("PATIENT_TYPE");
										patient_type 			= (patient_type== null)?"":patient_type;
										patient_desc			= rset.getString("PATIENT_DESC");
										patient_desc 			= (patient_desc== null)?"":patient_desc;
										accident_location		= rset.getString("ACCIDENT_LOCATION");
										accident_location 		= (accident_location== null)?"":accident_location;
										protective_device_code	= rset.getString("PROTECTIVE_DEVICE_CODE");
										protective_device_code	= (protective_device_code== null)?"":protective_device_code;
										protective_device_desc	= rset.getString("PROTECTIVE_DEVICE_DESC");
										protective_device_desc 	= (protective_device_desc== null)?"":protective_device_desc;

									
									  	burn_yn					= rset.getString("BURN_YN");
										if(burn_yn==null || burn_yn.equals("") || burn_yn=="")
										  burn_yn				= "N";
										degree_of_burn			= rset.getString("DEGREE_OF_BURN");
										degree_of_burn			= (degree_of_burn== null)?"":degree_of_burn;
										pat_position_code		= rset.getString("PAT_POSITION_CODE");
										pat_position_code		= (pat_position_code== null)?"":pat_position_code;
										pat_position_desc		= rset.getString("PAT_POSITION_DESC");
										pat_position_desc 		= (pat_position_desc== null)?"":pat_position_desc;
										incident_remarks		= rset.getString("INCIDENT_REMARKS");
										if(incident_remarks==null || incident_remarks.equals("") || incident_remarks=="")	
									    {
										   disabledField		= "";
										   incident_remarks		= "";
										}
										else
											disabledField		= "YES";
										trauma_yn				= rset.getString("TRAUMA_YN");
										if(trauma_yn==null || trauma_yn.equals("") || trauma_yn=="")	
										  trauma_yn				= "N";
										blunt_injury_yn			= rset.getString("BLUNT_INJURY_YN");
										if(blunt_injury_yn==null || blunt_injury_yn.equals("") || blunt_injury_yn=="")	
										  blunt_injury_yn		= "N";
										penetrating_injury_yn	= rset.getString("PENETRATING_INJURY_YN");
										if(penetrating_injury_yn==null || penetrating_injury_yn.equals("") || penetrating_injury_yn=="")	
										  penetrating_injury_yn	= "N";

										tetanus_admin_yn		= rset.getString("TETANUS_ADMIN_YN");
										if(tetanus_admin_yn==null || tetanus_admin_yn.equals("") || tetanus_admin_yn=="")	
										  tetanus_admin_yn		= "N";
										tetanus_admin_when		= rset.getString("TETANUS_ADMIN_WHEN");
										tetanus_admin_when		= (tetanus_admin_when== null)?"":tetanus_admin_when;
										pregnant_yn				= rset.getString("PREGNANT_YN");
										if(pregnant_yn==null || pregnant_yn.equals("") || pregnant_yn=="")	
										  pregnant_yn			= "N";
										lmp_date				= rset.getString("LMP_DATE");
										lmp_date				= (lmp_date== null)?"":lmp_date;
										sysDateWithoutTime		= rset.getString("sysDateWithoutTime");
										sysDateWithoutTime		= (sysDateWithoutTime== null)?"":sysDateWithoutTime;
										
										gd_for_age_yn			= rset.getString("GD_FOR_AGE_YN");
										if(gd_for_age_yn==null || gd_for_age_yn.equals("") || gd_for_age_yn=="")	
										  gd_for_age_yn			= "N";
										im_upto_date_yn			= rset.getString("IM_UPTO_DATE_YN");
										if(im_upto_date_yn==null || im_upto_date_yn.equals("") || im_upto_date_yn=="")	
										  im_upto_date_yn		= "N";
										height					= rset.getString("HEIGHT");
										height 					= (height== null)?"":height;
										height_unit				= rset.getString("HEIGHT_UNIT");
										height_unit				= (height_unit==null)?"":height_unit;
										height_code				= height_unit;
										if(height_unit!=null && !height_unit.equals("") && height_unit.equalsIgnoreCase("C"))
										height_unit				= "CM";
										else if(height_unit!=null && !height_unit.equals("") &&  height_unit.equalsIgnoreCase("I"))
										height_unit				= "Inch";
										
										weight					= rset.getString("WEIGHT");
										weight					= (weight== null)?"":weight;
										weight_unit				= rset.getString("WEIGHT_UNIT");
										weight_unit 			= (weight_unit== null)?"":weight_unit;
										weight_code			    = weight_unit;
										if(weight_unit!=null && !weight_unit.equals("") && weight_unit.equalsIgnoreCase("K"))
										weight_unit = "KG";
										else if(weight_unit!=null &&  !weight_unit.equals("") && weight_unit.equalsIgnoreCase("L"))
										weight_unit = "LB";
					   					
										circumference			= rset.getString("CIRCUMFERENCE");
										circumference			= (circumference== null)?"":circumference;
										circumference_unit		= rset.getString("CIRCUMFERENCE_UNIT");
										circumference_unit		= (circumference_unit== null)?"":circumference_unit;
										circumference_code		= circumference_unit;
										if(circumference_unit!=null && !circumference_unit.equals("")  && circumference_unit.equalsIgnoreCase("C"))
										circumference_unit		= "CM";
										else if(circumference_unit!=null && !circumference_unit.equals("") && circumference_unit.equalsIgnoreCase("I"))
										circumference_unit		= "Inch";	
									}
									if(pstmt!=null) pstmt.close();
									if(rset!=null) rset.close();
%>
	 <body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
	 <form name="ae_triage_details_form" id="ae_triage_details_form"  action="../../servlet/eAE.AETriageDetailsServlet"  method="post"  target="messageframe">
	 		 <%
	                   // To display the legend like height,weight,etc
					   pstmt = con.prepareStatement(sqlUnit);
				       rset = pstmt.executeQuery();
					   while(rset!=null && rset.next())
					   {
                             heightDesc = rset.getString(1);
							 weightDesc = rset.getString(2);
							 circumDesc = rset.getString(3);
					   }
					   heightVal = heightDesc;
					   weightVal = weightDesc;
				       circumVal = circumDesc;
					   if(pstmt!=null) pstmt.close();
					   if(rset!=null) rset.close();
					   if(heightDesc!=null && heightDesc.equalsIgnoreCase("C"))
							heightDesc = "CM";
					   else if(heightDesc!=null && heightDesc.equalsIgnoreCase("I"))
							heightDesc = "Inch";
					   if(weightDesc!=null && weightDesc.equalsIgnoreCase("K"))
							weightDesc = "KG";
					   else if(weightDesc!=null && weightDesc.equalsIgnoreCase("L"))
							weightDesc = "LB";
					   if(circumDesc!=null && circumDesc.equalsIgnoreCase("C"))
							circumDesc = "CM";
					   else if(circumDesc!=null && circumDesc.equalsIgnoreCase("I"))
							circumDesc = "Inch";		
			      %>
					   
	     <%
					   // To get the Patient Sex, Nationality, Expiry Date,Alternate Id,etc.				   
					   pstmt = con.prepareStatement(nationalDisp);
					   pstmt.setString(1,patient_id);
					   
					   rset = pstmt.executeQuery();
				
					   while(rset!=null && rset.next())
					   {
						  sex			 = rset.getString("SEX");
						  patient_age	 = rset.getInt("patient_age");

						  if((sex==null) || (sex.equals("null")) || (sex=="") || (sex.equals("")))
						   sex ="";
					   }
					   if(pstmt!=null) pstmt.close();
					   if(rset!=null) rset.close();
				    // Get the Min Age For Pregnancy and Max Age for Paediatric
						   pstmt = con.prepareStatement(displayVisit);
					       rset = pstmt.executeQuery();
						   while(rset!=null && rset.next())
						   {
								min_age_pregnancy	= rset.getInt("MIN_AGE_FOR_PREG_DTL");
								max_age_paediatric	= rset.getInt("MAX_AGE_FOR_PAED_DTL");
              			   }
						   if(pstmt!=null) pstmt.close();
						   if(rset!=null) rset.close();

	  	%>
	 <table border="0" cellpadding="0" cellspacing="0" align='center' width='95%'>
	<%
		  if (sex.equalsIgnoreCase("F") && (patient_age >= min_age_pregnancy))
		  {
          }
          if (patient_age <= max_age_paediatric)
		  {

          }
		 if (sex.equalsIgnoreCase("M") && patient_age > max_age_paediatric)
		  {
          }

    %>
	 <tr>
		 <th align='left' colspan='6'<fmt:message key="eAE.AEDetails.label" bundle="${ae_labels}"/>s</th>
     </tr>
     <tr>
	          <td class='label' width='5%'>&nbsp;</td>
			  <td class='LABEL' align='RIGHT' width='15%' nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
  		      <td class='QUERYDATA' align='left' width='30%' nowrap>&nbsp;
 				   <%=ecis.utils.HTMLUtilities.getDisplayString(clinic_desc)%>
              </td>
			  <td class='LABEL' align='RIGHT' width='15%' nowrap><fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/></td>
  		      <td class='QUERYDATA' align='left' width='30%' nowrap>&nbsp;
 				   <%=ecis.utils.HTMLUtilities.getDisplayString(treatment_area_desc)%>
              </td>
	          <td class='label' width='5%'>&nbsp;</td>
	 </tr>
     <tr>
		 <th align='left' colspan='6'><fmt:message key="Common.PatientCondition.label" bundle="${common_labels}"/></th>
     </tr>
	 <tr>
		      <td class='label' width='5%'>&nbsp;</td>
		      <td class='LABEL' align='RIGHT' width='20%'><fmt:message key="Common.ambulatorystatus.label" bundle="${common_labels}"/></td>
	 		  <td class='QUERYDATA' align='left' width='25%'>&nbsp;
			<% if(!ambulatory_status.equals("")) { %>
 		     <%=ecis.utils.HTMLUtilities.getDisplayString(ambulatory_desc)%> 
			 <input type='hidden' name='ambulatory_status_val' id='ambulatory_status_val' value="<%=ecis.utils.HTMLUtilities.getDisplayString(ambulatory_status)%>">
			<% } else { %>
				 <select name='ambulatory_status_val' id='ambulatory_status_val'>
				  <option value=''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					   <%
						   pstmt = con.prepareStatement(sqlAmbulatory);
					       rset = pstmt.executeQuery();
						   while(rset!=null && rset.next())
						   {
                              out.println("<option value='"+rset.getString(1)+"'>"+rset.getString(2)+" ");
						   }
						   if(pstmt!=null) pstmt.close();
						   if(rset!=null) rset.close();
					   %>
                 </select>
              <% } %>  
              </td>
  		  <td></td>
						   <td></td>
					  			  <td class='LABEL' align='RIGHT' width='5%'>&nbsp;</td>
	  </tr>
	  <tr>	
		   <td></td>
           <td></td>
           <td></td>
				      <td class='LABEL' align='right' width='20%'><fmt:message key="Common.patienttype.label" bundle="${common_labels}"/></td>
			   <td class='QUERYDATA' align='left' width='25%'>&nbsp;
			<% if(!patient_type.equals("")) { %>
 		      <%=ecis.utils.HTMLUtilities.getDisplayString(patient_desc)%>
			  <input type='hidden' name='patient_type_val' id='patient_type_val' value="<%=ecis.utils.HTMLUtilities.getDisplayString(patient_type)%>">
			<% } else { %>
				<select name='patient_type_val' id='patient_type_val'>
					<option value=''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					   <%
						   pstmt = con.prepareStatement(sqlPatType);
					       rset = pstmt.executeQuery();
						   while(rset!=null && rset.next())
						   {
                              out.println("<option value='"+rset.getString(1)+"'>"+rset.getString(2)+" ");
						   }
						   if(pstmt!=null) pstmt.close();
						   if(rset!=null) rset.close();
					   %>
                 </select>
			<%  } %>
              </td>
			  <td class='LABEL' align='RIGHT' width='5%'>&nbsp;</td>
	  </tr>
  
	 <%
						   pstmt = con.prepareStatement(pat_emer_chk);
						   pstmt.setString(1, facilityId);
						   pstmt.setString(2, encounter_id);
						   rset = pstmt.executeQuery();
						   while(rset!=null && rset.next())
						   {
						    encounter_type	=	rset.getString(1);
						   }
	
			 if(encounter_type.equals("A"))  
			{	
	  %>
     <tr>
	   	  <th align='left' colspan='6'></th>
     </tr>
	 <tr>	
		     <td></td>
		     <td></td>
		     <td></td>
	         <td></td>
             <td></td>
			   <td class='LABEL' align='RIGHT' width='5%'>&nbsp;</td>
	  </tr>
	  <tr>	
		      <td class='label' width='5%'>&nbsp;</td>
		      <td class='LABEL' align='RIGHT' width='20%'><fmt:message key="eAE.LocationofAccident.label" bundle="${ae_labels}"/></td>
  		      <td class='QUERYDATA' align='left' width='25%'>&nbsp;
			<% if(!accident_location.equals("")) { %>
					<%=ecis.utils.HTMLUtilities.getDisplayString(accident_location)%>
		 		   	 <input type='hidden' name="location_of_accident_val" id="location_of_accident_val" value="<%=ecis.utils.HTMLUtilities.getDisplayString(accident_location)%>">
			<% } else { %>
					<input type='text'  name="location_of_accident_val" id="location_of_accident_val"  value="" maxLength='30' size='25' onBlur="makeValidString(this)">
			<% } %>
              </td>
  		      <td class='LABEL' align='right' width='20%' nowrap><fmt:message key="Common.ProtectiveDeviceUsed.label" bundle="${common_labels}"/></td>
			  <td class='QUERYDATA' align='left' width='25%'>&nbsp;
			<% if(!protective_device_code.equals("")) { %>
 				<%=ecis.utils.HTMLUtilities.getDisplayString(protective_device_desc)%>
				<input type='hidden' name='protective_device_val' id='protective_device_val' value="<%=ecis.utils.HTMLUtilities.getDisplayString(protective_device_code)%>">		     
			<% } else { %>
				<select name='protective_device_val' id='protective_device_val'>
				  <option value=''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					   <%
						   pstmt = con.prepareStatement(sqlProtDevice);
					       rset = pstmt.executeQuery();
						   while(rset!=null && rset.next())
						   {
                              out.println("<option value='"+rset.getString(1)+"'>"+rset.getString(2)+" ");
						   }
						   if(pstmt!=null) pstmt.close();
						   if(rset!=null) rset.close();
					   %>
                 </select>
		    <% } %>
              </td>
			  <td class='LABEL' align='RIGHT' width='5%'>&nbsp;</td>
	  </tr>
	  <tr>	
		      <td class='label' width='5%'>&nbsp;</td>
		       <td></td>
				<td></td>		   
			   --><td></td>
				   <td></td>
			 <td class='LABEL' align='RIGHT' width='5%'>&nbsp;</td>
	  </tr>
	 <tr>	
		      <td class='label' width='5%'>&nbsp;</td>
		      <td class='LABEL' align='RIGHT' width='20%'><fmt:message key="eAE.Burn.label" bundle="${ae_labels}"/></td>
		      <td class='QUERYDATA' align='left' width='25%'>&nbsp;<% if(burn_yn.equals("N")){ %><input type='checkbox'  name="burn_yn_val" id="burn_yn_val"  value="<%=ecis.utils.HTMLUtilities.getDisplayString(burn_yn)%>" onClick='chkValue(this);'> <% } else { %>&nbsp;Yes<input type='hidden' name='burn_yn_val' id='burn_yn_val' value="<%=ecis.utils.HTMLUtilities.getDisplayString(burn_yn)%>">		     <% } %>
              </td>
  		      <td class='LABEL' align='right' width='20%'><fmt:message key="eAE.DegreeofBurn.label" bundle="${ae_labels}"/></td>
			  <td class='QUERYDATA' align='left' width='25%'>&nbsp;
			<% if(!degree_of_burn.equals("")) { %>
 				<%=ecis.utils.HTMLUtilities.getDisplayString(degree_of_burn)%>
	     	    <input type='hidden' name='degree_of_burn_val' id='degree_of_burn_val' value="<%=ecis.utils.HTMLUtilities.getDisplayString(degree_of_burn)%>">		     
			<% } else { %>
				<input type='text'  name="degree_of_burn_val" id="degree_of_burn_val"  value="" maxLength='20' size='20' onBlur="makeValidString(this)">
			<% } %>
              </td>
			  <td class='LABEL' align='RIGHT' width='5%'>&nbsp;</td>
	  </tr>
	  <tr>	
		      <td class='label' width='5%'>&nbsp;</td>
		      <td class='LABEL' align='RIGHT' width='20%' nowrap><fmt:message key="eAE.PatientPositionduringIncident.label" bundle="${ae_labels}"/></td>
  		      <td class='QUERYDATA' align='left' width='25%'>&nbsp;
			<% if(!pat_position_code.equals("")) { %>
 				<%=ecis.utils.HTMLUtilities.getDisplayString(pat_position_desc)%>
	   		  <input type='hidden' name='patient_position_during_incident_val' id='patient_position_during_incident_val' value="<%=ecis.utils.HTMLUtilities.getDisplayString(pat_position_code)%>">		     
			<% } else { %>
				 <select name='patient_position_during_incident_val' id='patient_position_during_incident_val'>
				    <option value=''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					   <%
						   pstmt = con.prepareStatement(sqlPosition);
					       rset = pstmt.executeQuery();
						   while(rset!=null && rset.next())
						   {
                              out.println("<option value='"+rset.getString(1)+"'>"+rset.getString(2)+" ");
						   }
						   if(pstmt!=null) pstmt.close();
						   if(rset!=null) rset.close();
					   %>
                  </select>
			<% } %>
              </td>
			  <td class='LABEL' align='left' width='20%' colspan='2'>&nbsp;&nbsp;<input type="button" name="incident_remarks_val" id="incident_remarks_val" class=BUTTON value="Incident Remarks" onClick="callIncidentRemarks()"></td>
  		      <td class='LABEL' align='left' width='20%' colspan='2'>&nbsp;</td>
	  </tr>
		
			  <% 
			   }else if(encounter_type.equals("E"))
				  {
			  %>

			 <tr>
	   	  <th align='left' colspan='6'><fmt:message key="eAE.AccidentCase.label" bundle="${ae_labels}"/></th>
     </tr>
	 <tr>	
		      <td class='label' width='5%'>&nbsp;</td>
		      <td></td> 
			 <td></td>
			  <td></td>
			<td></td>

			  <td class='LABEL' align='right' width='20%'><fmt:message key="eAE.RTA.label" bundle="${ae_labels}"/></td>
			  <td class='QUERYDATA' align='left' width='25%'>&nbsp;
			  <td class='LABEL' align='RIGHT' width='5%'>&nbsp;</td>
	  </tr>
	  <tr>	
		      <td class='label' width='5%'>&nbsp;</td>
		      <td class='LABEL' align='RIGHT' width='20%'><fmt:message key="eAE.LocationofAccident.label" bundle="${ae_labels}"/></td>
  		      <td class='QUERYDATA' align='left' width='25%'>&nbsp;
			<% if(!accident_location.equals("")) { %>
					<%=ecis.utils.HTMLUtilities.getDisplayString(accident_location)%>
		 		   	 <input type='hidden' name='location_of_accident_val' id='location_of_accident_val' value="<%=ecis.utils.HTMLUtilities.getDisplayString(accident_location)%>">		     
			<% } else { %>
					<input type='text'  name="location_of_accident_val" id="location_of_accident_val"  value='' maxLength='30' size='25' disabled>
			<% } %>
              </td>
  		      <td class='LABEL' align='right' width='20%' nowrap><fmt:message key="Common.ProtectiveDeviceUsed.label" bundle="${common_labels}"/></td>
			  <td class='QUERYDATA' align='left' width='25%'>&nbsp;
			<% if(!protective_device_code.equals("")) { %>
 				<%=ecis.utils.HTMLUtilities.getDisplayString(protective_device_desc)%>
				<input type='hidden' name='protective_device_val' id='protective_device_val' value="<%=ecis.utils.HTMLUtilities.getDisplayString(protective_device_code)%>">		     
			<% } else { %>
				<select name='protective_device_val' id='protective_device_val' disabled>
				  <option value=''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					   <%  /*
						   pstmt = con.prepareStatement(sqlProtDevice);
					       rset = pstmt.executeQuery();
						   while(rset!=null && rset.next())
						   {
                              out.println("<option value='"+rset.getString(1)+"'>"+rset.getString(2)+" ");
						   }
						   if(pstmt!=null) pstmt.close();
						   if(rset!=null) rset.close();  */
					   %>
                 </select>
		    <% } %>
              </td>
			  <td class='LABEL' align='RIGHT' width='5%'>&nbsp;</td>
	  </tr>
	  <tr>	
		      
					   <td class='label' width='5%'>&nbsp;</td>
		      <td></td>
           <td></td>
					   <td class='LABEL' align='RIGHT' width='20%'><fmt:message key="eAE.CauseofAccident.label" bundle="${ae_labels}"/></td>
  		      <td class='QUERYDATA' align='left' width='25%'>&nbsp;
			 <td></td>
                  <td></td>
			 
			  <td class='LABEL' align='RIGHT' width='5%'>&nbsp;</td>
	  </tr>
	 <tr>	
		      <td class='label' width='5%'>&nbsp;</td>
		      <td class='LABEL' align='RIGHT' width='20%'><fmt:message key="eAE.Burn.label" bundle="${ae_labels}"/></td>
		      <td class='QUERYDATA' align='left' width='25%'>&nbsp;<% if(burn_yn.equals("N")){ %><input type='checkbox'  name="burn_yn_val" id="burn_yn_val"  value="<%=ecis.utils.HTMLUtilities.getDisplayString(burn_yn)%>" onClick='chkValue(this);' disabled> <% } else { %>&nbsp;Yes<input type='hidden' name='burn_yn_val' id='burn_yn_val' value="<%=ecis.utils.HTMLUtilities.getDisplayString(burn_yn)%>">		     <% } %>
              </td>
  		      <td class='LABEL' align='right' width='20%'><fmt:message key="eAE.DegreeofBurn.label" bundle="${ae_labels}"/></td>
			  <td class='QUERYDATA' align='left' width='25%'>&nbsp;
			<% if(!degree_of_burn.equals("")) { %>
 				<%=ecis.utils.HTMLUtilities.getDisplayString(degree_of_burn)%>
	     	    <input type='hidden' name='degree_of_burn_val' id='degree_of_burn_val' value="<%=ecis.utils.HTMLUtilities.getDisplayString(degree_of_burn)%>">		     
			<% } else { %>
				<input type='text'  name="degree_of_burn_val" id="degree_of_burn_val"  value='' maxLength='20' size='20' disabled>
			<% } %>
              </td>
			  <td class='LABEL' align='RIGHT' width='5%'>&nbsp;</td>
	  </tr>
	  <tr>	
		      <td class='label' width='5%'>&nbsp;</td>
		      <td class='LABEL' align='RIGHT' width='20%' nowrap><fmt:message key="eAE.PatientPositionduringIncident.label" bundle="${ae_labels}"/></td>
  		      <td class='QUERYDATA' align='left' width='25%'>&nbsp;
			<% if(!pat_position_code.equals("")) { %>
 				<%=ecis.utils.HTMLUtilities.getDisplayString(pat_position_desc)%>
	   		  <input type='hidden' name='patient_position_during_incident_val' id='patient_position_during_incident_val' value="<%=ecis.utils.HTMLUtilities.getDisplayString(pat_position_code)%>">		     
			<% } else { %>
				 <select name='patient_position_during_incident_val' id='patient_position_during_incident_val' disabled>
				    <option value=''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					   <%  /*
						   pstmt = con.prepareStatement(sqlPosition);
					       rset = pstmt.executeQuery();
						   while(rset!=null && rset.next())
						   {
                              out.println("<option value='"+rset.getString(1)+"'>"+rset.getString(2)+" ");
						   }
						   if(pstmt!=null) pstmt.close();
						   if(rset!=null) rset.close();  */
					   %>
                  </select>
			<% } %>
              </td>
			  <td class='LABEL' align='left' width='20%' colspan='2'>&nbsp;&nbsp;<input type="button" name="incident_remarks_val" id="incident_remarks_val" class=BUTTON value="Incident Remarks" onClick="callIncidentRemarks()" disabled></td>
  		      <td class='LABEL' align='left' width='20%' colspan='2'>&nbsp;</td>
	  </tr>
	  <% } %>
	 <tr>
		 <th align='left' colspan='3'><fmt:message key="eAE.TraumaDetails.label" bundle="${ae_labels}"/></th>
  		 <th align='left' >&nbsp;</th>
		 <th align='left' colspan='2'><fmt:message key="eAE.InjuryType.label" bundle="${ae_labels}"/></th>
     </tr>
	 <tr>	
		      <td class='label' width='5%'>&nbsp;</td>
		      <td class='LABEL' align='RIGHT' width='20%'><fmt:message key="Common.CaseofTrauma.label" bundle="${common_labels}"/></td>
			  <td class='QUERYDATA' align='LEFT' width='25%'>&nbsp;<% if(trauma_yn.equals("N")) { %><input type='checkbox'  name="case_of_trauma_yn_val" id="case_of_trauma_yn_val"  value="<%=ecis.utils.HTMLUtilities.getDisplayString(trauma_yn)%>" onClick='chkValue(this);'><% } else { %>Yes <input type='hidden'  name="case_of_trauma_yn_val" id="case_of_trauma_yn_val"  value="<%=ecis.utils.HTMLUtilities.getDisplayString(trauma_yn)%>"><% } %>
              </td>
		      <td class='LABEL' align='RIGHT' width='20%'><fmt:message key="eAE.Blunt.label" bundle="${ae_labels}"/><%if(blunt_injury_yn.equals("N")) { %><input type='checkbox'  name="blunt_yn_val" id="blunt_yn_val"  value="<%=ecis.utils.HTMLUtilities.getDisplayString(blunt_injury_yn)%>" onClick='chkValue(this);' >	<% }else  { %><b>&nbsp;<fmt:message key="Common.yes.label" bundle="${common_labels}"/></b> <input type='hidden'  name="blunt_yn_val" id="blunt_yn_val"  value="<%=ecis.utils.HTMLUtilities.getDisplayString(blunt_injury_yn)%>"><% } %>
			   </td>
			  <td class='LABEL' align='RIGHT' width='20%'><fmt:message key="eAE.Penetrating.label" bundle="${ae_labels}"/>&nbsp;<% if(penetrating_injury_yn.equals("N")) { %><input type='checkbox'  name="penetrating_yn_val" id="penetrating_yn_val"  value="<%=ecis.utils.HTMLUtilities.getDisplayString(penetrating_injury_yn)%>" onClick='chkValue(this);' >	<% } else { %> <b> &nbsp;<fmt:message key="Common.yes.label" bundle="${common_labels}"/> </b><input type='hidden'  name="penetrating_yn_val" id="penetrating_yn_val"  value="<%=ecis.utils.HTMLUtilities.getDisplayString(penetrating_injury_yn)%>"><% } %>
              </td>
			  <td class='LABEL' align='RIGHT' width='5%'>&nbsp;</td>
	  </tr>
	 <tr> 
		 <th align='left' colspan='6'><fmt:message key="eAE.TetanusVaccination.label" bundle="${ae_labels}"/></th>
     </tr>
	 <tr>				 
		     <td class='label' width='5%'>&nbsp;</td>
		     <td class='LABEL' align='RIGHT' width='20%'><fmt:message key="eAE.Vaccinated.label" bundle="${ae_labels}"/></td>
	 		 <td class='QUERYDATA' align='left' width='20%'>&nbsp;<% if(tetanus_admin_yn.equals("N")) { %><input type='checkbox'  name="vaccinated_yn_val" id="vaccinated_yn_val"  value="<%=ecis.utils.HTMLUtilities.getDisplayString(tetanus_admin_yn)%>" onClick='chkValue(this);setDoneDuring(this);'>	<% } else { %>&nbsp;Yes<input type='hidden'  name="vaccinated_yn_val" id="vaccinated_yn_val"  value="<%=ecis.utils.HTMLUtilities.getDisplayString(tetanus_admin_yn)%>" >	<% } %> 
             </td>
  		     <td class='LABEL' align='right' width='20%'><fmt:message key="eAE.Doneduring.label" bundle="${ae_labels}"/></td>
			 <td class='QUERYDATA' align='left' width='15%'>&nbsp;
			<% if(!tetanus_admin_when.equals("")) { %>
				<%=ecis.utils.HTMLUtilities.getDisplayString(tetanus_admin_when)%>
		 	  <input type='hidden'  name="done_during_val" id="done_during_val"  value="<%=ecis.utils.HTMLUtilities.getDisplayString(tetanus_admin_when)%>" >
			<% } else { if(tetanus_admin_yn.equals("Y")) {%>
					<input type='text'  name="done_during_val" id="done_during_val"  value="<%=ecis.utils.HTMLUtilities.getDisplayString(tetanus_admin_when)%>"  maxLength='15' size='15'  onBlur="makeValidString(this)">
			<% } else{%>
						<input type='text'  name="done_during_val" id="done_during_val"  value="<%=ecis.utils.HTMLUtilities.getDisplayString(tetanus_admin_when)%>"  maxLength='15' size='15' READONLY onBlur="makeValidString(this)">
           <% } } %>
            </td>
			<td class='LABEL' align='left' width='20%'>&nbsp;</td>
     </tr>
    <%
		if (sex.equalsIgnoreCase("F") && (patient_age >= min_age_pregnancy))
			{
				gynaec_yn="Y";
    %>
	<tr> 
		 <th align='left' colspan='6'><fmt:message key="eAE.GynaecDetails.label" bundle="${ae_labels}"/></th>
    </tr>
    <tr>
		     <td class='label' width='5%'>&nbsp;</td>
		     <td class='LABEL' align='RIGHT' width='20%'><fmt:message key="Common.PregnantatPresent.label" bundle="${common_labels}"/></td>
			 <td class='LABEL' align='left' width='20%'>&nbsp;<% if(pregnant_yn.equals("N")) { %><input type='checkbox'  name="pregnant_at_present_yn_val" id="pregnant_at_present_yn_val"  value="<%=ecis.utils.HTMLUtilities.getDisplayString(pregnant_yn)%>" onClick='chkValue(this);'><% } else { %>&nbsp;<b><fmt:message key="Common.yes.label" bundle="${common_labels}"/></b><input type='hidden'  name="pregnant_at_present_yn_val" id="pregnant_at_present_yn_val"  value="<%=ecis.utils.HTMLUtilities.getDisplayString(pregnant_yn)%>"><% } %>
			 </td>
			 <td class='LABEL' align='right' width='15%' ><fmt:message key="eAE.LMPDate.label" bundle="${ae_labels}"/></td>
			 <td class='QUERYDATA' align='left' width='15%' >&nbsp;
			<% if(!lmp_date.equals("")) { %>
					<%=ecis.utils.HTMLUtilities.getDisplayString(lmp_date)%>
					<input type='hidden'  name="lmp_date_val" id="lmp_date_val"  value="<%=ecis.utils.HTMLUtilities.getDisplayString(lmp_date)%>" >
			<% } else { %>
					<input type='text'  name="lmp_date_val" id="lmp_date_val"  value="<%=ecis.utils.HTMLUtilities.getDisplayString(lmp_date)%>" maxLength='10' size='10' onBlur='CheckSysdate(lmp_date_val,sysDateWithoutTime,this);'>
			<% } %>
             </td>
			 <td class='LABEL' align='left' width='5%'>&nbsp;</td>
     </tr>
    <%
			}  // End of Gynaec Details
	   	    if (patient_age <= max_age_paediatric)
			{
				paediatric_yn = "Y";
			
    %>
	<tr> 
		 <th align='left' colspan='6'><fmt:message key="eAE.PediatricDetails.label" bundle="${ae_labels}"/></th>
    </tr>
	<tr>
		     <td class='label' width='5%'>&nbsp;</td>
		     <td class='LABEL' align='RIGHT' width='20%' nowrap><fmt:message key="eAE.GrowthDevelMileStoneforAge.label" bundle="${ae_labels}"/></td>
			 <td class='LABEL' align='left' width='20%'>&nbsp;<% if(gd_for_age_yn.equals("N")) { %><input type='checkbox'  name="developmental_mile_stone_yn_val" id="developmental_mile_stone_yn_val"  value="<%=ecis.utils.HTMLUtilities.getDisplayString(gd_for_age_yn)%>" onClick='chkValue(this);'><% } else { %>&nbsp;<b><fmt:message key="Common.yes.label" bundle="${common_labels}"/></b><input type='hidden'  name="developmental_mile_stone_yn_val" id="developmental_mile_stone_yn_val"  value="<%=ecis.utils.HTMLUtilities.getDisplayString(gd_for_age_yn)%>"><% } %>
             </td>
			 <td class='LABEL' align='right' width='15%' nowrap><fmt:message key="eAE.ImmunizationuptoDate.label" bundle="${ae_labels}"/></td>
			 <td class='LABEL' align='left' width='15%' >&nbsp;<% if(im_upto_date_yn.equals("N")) { %><input type='checkbox'  name="immunization_upto_date_yn_val" id="immunization_upto_date_yn_val"  value="<%=ecis.utils.HTMLUtilities.getDisplayString(im_upto_date_yn)%>" onClick='chkValue(this);'><% } else { %>&nbsp;<b><fmt:message key="Common.yes.label" bundle="${common_labels}"/></b><input type='hidden'  name="immunization_upto_date_yn_val" id="immunization_upto_date_yn_val"  value="<%=ecis.utils.HTMLUtilities.getDisplayString(im_upto_date_yn)%>"><% } %>
             </td>
			 <td class='LABEL' align='left' width='5%'>&nbsp;</td>
     </tr>
	<tr>
		     <td class='label' width='5%'>&nbsp;</td>
		     <td class='LABEL' align='RIGHT' width='20%'><fmt:message key="Common.height.label" bundle="${common_labels}"/></td>
			 <td class='LABEL' align='left' width='20%' nowrap>&nbsp;&nbsp;<% if(!height.equals("")) { %><%=ecis.utils.HTMLUtilities.getDisplayString(height)%>&nbsp;<b><%=height_unit%></b><% } else { %><input type='text'  name="height_val" id="height_val"  value='' maxLength='5' size='5' onBlur="AECheckNum(this)" onKeyPress="return(ChkNumberInput(this,event,'2'))">&nbsp;<b><%=heightDesc%></b> <% } %>
			 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Weight&nbsp;</td>
			 <td class='LABEL' align='left' width='10%' ><% if(!weight.equals("")) { %><%=ecis.utils.HTMLUtilities.getDisplayString(weight)%>&nbsp;<b><%=weight_unit%></b><% } else { %><input type='text'  name="weight_val" id="weight_val"  value='' maxLength='5' size='5' onBlur="AECheckNum(this)" onKeyPress="return(ChkNumberInput(this,event,'2'))">&nbsp;<b><%=weightDesc%></b><% } %>
			 <td class='LABEL' align='left' width='15%' >&nbsp;<fmt:message key="Common.Circumference.label" bundle="${common_labels}"/>&nbsp;<% if(!circumference.equals("")) { %><%=ecis.utils.HTMLUtilities.getDisplayString(circumference)%>&nbsp;<b><%=circumference_unit%></b><% } else { %><input type='text'  name="circumference_val" id="circumference_val"  value='' maxLength='5' size='5' onBlur="AECheckNum(this)" onKeyPress="return(ChkNumberInput(this,event,'2'))">&nbsp;<b><%=circumDesc%></b> <% } %>
			 </td>
			 <td class='LABEL' align='left' width='5%'>&nbsp;</td>
     </tr>
    <% } // end of pediatric%>
	<tr> 
		 <td align='left' colspan='6'>&nbsp;</td>
    </tr>
   		<tr> 
		    <td colspan='4' colspan='4'>&nbsp;</td>
		    <td width='auto' align='right' colspan='2'>
		<%
			if(strCA==null)
			{
		%>
   		        <input type="button" class=button name='recording' id='recording' value='Record' title='Record' onClick='recordTriage();'><input type="button" class=button name='Reseting' id='Reseting' value='Reset' title='Reset' onClick='reseting();'><input type="button" class=button name='close' id='close' value='Close' title='close' onClick='parent.window.close();'></input>
			<%
			}
				else
			{
			%>
			 <input type="button" class=button name='recording' id='recording' value='Record' title='Record' onClick='recordTriage();'><input type="button" class=button name='Reseting' id='Reseting' value='Reset' title='Reset' onClick='reseting();'>
			<%
			}
				%>
			     </td>
			</tr>
		</table>
 <input type='hidden' name='queryString' id='queryString' value="<%=request.getQueryString()%>">
    	  <input type='hidden' name='location_code' id='location_code' value='<%=clinic_code%>'>
		  <input type='hidden' name='location_type' id='location_type' value='<%=clinic_type%>'>
		  <input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>'>
		  <input type='hidden' name='encounter_id' id='encounter_id' value='<%=encounter_id%>'>
		  <input type='hidden' name='clinic_desc' id='clinic_desc' value='<%=ecis.utils.HTMLUtilities.getDisplayString(clinic_desc)%>'>
		  <input type='hidden' name='treatment_area_desc' id='treatment_area_desc' value='<%=ecis.utils.HTMLUtilities.getDisplayString(treatment_area_desc)%>'>
		  <input type='hidden' name='treatment_area_code' id='treatment_area_code' value='<%=treatment_area_code%>'>
		
		  <input type='hidden' name='queue_status' id='queue_status' value='<%=queue_status%>'>
          <% if(!incident_remarks.equals("")) { %>
		  <input type='hidden' name='incident_Remarks_val' id='incident_Remarks_val' value="<%=ecis.utils.HTMLUtilities.getDisplayString(incident_remarks)%>">	  			 
		  <% } else { %>
  		  <input type='hidden' name='incident_Remarks_val' id='incident_Remarks_val' value="">	  			 
          <% } %>
  	      <input type='hidden' name='disabledField' id='disabledField' value='<%=disabledField%>'>
	  	  <input type='hidden'  name="height_val" id="height_val" value="<%=ecis.utils.HTMLUtilities.getDisplayString(height)%>" >
		  <input type='hidden'  name="weight_val" id="weight_val" value="<%=ecis.utils.HTMLUtilities.getDisplayString(weight)%>" >
		  <input type='hidden'  name="circumference_val" id="circumference_val" value="<%=ecis.utils.HTMLUtilities.getDisplayString(circumference)%>" >

		  <% if(!height_code.equals("")) { %> 
		  <input type='hidden'  name="height_desc" id="height_desc" value="<%=ecis.utils.HTMLUtilities.getDisplayString(heightVal)%>" >
          <% } else { %>
		  <input type='hidden'  name="height_desc" id="height_desc" value="<%=ecis.utils.HTMLUtilities.getDisplayString(height_code)%>" >
		  <% } %>	

		  <% if(!weight_code.equals("")) { %>
		  <input type='hidden'  name="weight_desc" id="weight_desc" value="<%=ecis.utils.HTMLUtilities.getDisplayString(weightVal)%>" >
          <% } else { %>
		  <input type='hidden'  name="weight_desc" id="weight_desc" value="<%=ecis.utils.HTMLUtilities.getDisplayString(weight_code)%>" >
		  <% } %>	
		  <% if(!circumference_code.equals("")) { %>
		  <input type='hidden'  name="circumference_desc" id="circumference_desc" value="<%=ecis.utils.HTMLUtilities.getDisplayString(circumVal)%>" >
          <% } else { %>
		  <input type='hidden'  name="circumference_desc" id="circumference_desc" value="<%=ecis.utils.HTMLUtilities.getDisplayString(circumference_code)%>" >
		  <% } %>	

		   <input type='hidden' name='paediatric_yn' id='paediatric_yn' value='<%=paediatric_yn%>'>
   		   <input type='hidden' name='gynaec_yn' id='gynaec_yn' value='<%=gynaec_yn%>'>
   		   <input type='hidden' name='mode' id='mode' value='TriageDetails'>	   
		  <input type='hidden' name='sysDateWithoutTime' id='sysDateWithoutTime' value='<%=sysDateWithoutTime%>'>
</form>
	 </body>
<%
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
    finally
    {
        if(pstmt!=null)  pstmt.close();
		if(rset!=null)  rset.close();
	    ConnectionManager.returnConnection(con,request);
    }
%>
</html>

