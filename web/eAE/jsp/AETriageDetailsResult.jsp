<!DOCTYPE html>
<!-- Added/Modified By Nanda 11/8/2002 -->
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
 <%
 request.setCharacterEncoding("UTF-8");
 request= new XSSRequestWrapper(request);
 response.addHeader("X-XSS-Protection", "1; mode=block");
 response.addHeader("X-Content-Type-Options", "nosniff");
 
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
  <script language='javascript' src='../../eCommon/js/common.js'></script>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
  <script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
    <script language='javascript' src='../../eCommon/js/dchk.js'></script>
  <script language='javascript' src='../../eAE/js/AETriageDetails.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

  <Script>
  function setFocus()
  {
	     if(document.forms[0].nurse.disabled==false) 
		  { 
			  document.forms[0].nurse.focus(); 
		  }
  }
  function checkMaxSize(Obj)
			{
				if(Obj.value.length > 60)
				{
					var error = getMessage("REMARKS_CANNOT_EXCEED",'Common');
					error = error.replace("$","Complaint");
					error = error.replace("#","60");
					alert(error)
					Obj.focus();
				}
			}
</script>
</head>
<%
        Connection con						= null;
    	PreparedStatement pstmt				= null;
        ResultSet rset						= null ;
		Statement stmt						= null;
		ResultSet rs						= null;
		String facilityId					= (String)session.getValue("facility_id");
		String strCA						= request.getParameter("CA");
		String patient_id					= request.getParameter("Patient_ID");
			   patient_id					= (patient_id == null)?"":patient_id;
		String clinic_code					= request.getParameter("clinic_code");
		if(clinic_code==null || clinic_code.equals("") || clinic_code=="")
				clinic_code					= "";
		String clinic_desc					= request.getParameter("clinic_desc");
		if(clinic_desc==null || clinic_desc.equals("") || clinic_desc=="")
				clinic_desc					= "";
	    String treatment_area_desc			= request.getParameter("treatment_area_desc");
			   treatment_area_desc			= (treatment_area_desc == null)?"":treatment_area_desc;
		String treatment_area_code			= request.getParameter("treatment_area_code");
		if(treatment_area_code==null || treatment_area_code.equals("") || treatment_area_code=="")
				treatment_area_code			= "";
		String orig_tmt_area_code			= request.getParameter("orig_tmt_area_code");
		if(orig_tmt_area_code==null || orig_tmt_area_code.equals("") || orig_tmt_area_code=="")
				orig_tmt_area_code			= "";
		
		String encounter_id					= request.getParameter("encounter_id");
			   encounter_id					= (encounter_id == null)?"":encounter_id;
		String queue_status					= request.getParameter("queue_status");
			   queue_status					= (queue_status == null)?"":queue_status;
	   String practitioner_id					= request.getParameter("practitioner_id");
			   practitioner_id					= (practitioner_id == null)?"":practitioner_id;
        String operation					= request.getParameter("operation");
			   operation					= (operation == null)?"INSERT":operation;

		

        String queryString					= request.getQueryString();
		String triage_sysdate						= "";
	
		String visit_adm_date_time			= "";
		String visit_adm_date				= "";
		String open_to_all_pract_yn			= "";
		String open_to_all_prac_for_clinic_yn = ""; 
		String triage_start_date_time		= request.getParameter("triage_start_date_time");
			   triage_start_date_time		= (triage_start_date_time == null)?"":triage_start_date_time;

		String triage_start_date			= "";
		String nurse_description			= "";
  		String practitioner_description		= "";
		String triage_complaint				= "";
		String triage_end_date				= "";
		String priority_code				= "";
		String disabledField				= "";
		String readOnlyAttribute			= "";
		String sysdate						= "";
		String p_physician_id				= "",	p_physician_desc	= "";

		try{
                con                  = ConnectionManager.getConnection(request);
				// To get the open_to_all_pract_yn and  OPEN_TO_ALL_PRAC_FOR_CLINIC_YN
				String sqlClinic	 = " select OPEN_TO_ALL_PRACT_YN, "+
				" OPEN_TO_ALL_PRAC_FOR_CLINIC_YN,to_char(sysdate,'dd/mm/yyyy hh24:mi'),"+
				" short_desc treatment_area_desc "+
				" from AE_TMT_AREA_FOR_CLINIC_vw where FACILITY_ID= ? and CLINIC_CODE = ? and "+
				" TREATMENT_AREA_CODE = ? ";

				String sql_sysdate	=	"SELECT to_char(SYSDATE,'dd/mm/yyyy hh24:mi') FROM DUAL";

				pstmt = con.prepareStatement(sqlClinic);
				pstmt.setString(1, facilityId);
				pstmt.setString(2, clinic_code);
				pstmt.setString(3, orig_tmt_area_code);
				rset = pstmt.executeQuery();
				while(rset!=null && rset.next())
				{
					open_to_all_pract_yn	 = rset.getString("OPEN_TO_ALL_PRACT_YN");
					open_to_all_prac_for_clinic_yn	 = rset.getString("OPEN_TO_ALL_PRAC_FOR_CLINIC_YN");
					 sysdate						 = rset.getString(3);
					 treatment_area_desc	=	rset.getString("treatment_area_desc");
                }    
				if(rset!=null) rset.close();
				if(pstmt!=null) pstmt.close();
				// Get the visit_adm_date_time
				String sqlVisit		= " select to_char(VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') VISIT_ADM_DATE_TIME, to_char(VISIT_ADM_DATE_TIME,'dd/mm/yyyy') VISIT_ADM_DATE from PR_ENCOUNTER where FACILITY_ID = ? and ENCOUNTER_ID= ? ";
				pstmt = con.prepareStatement(sqlVisit);
				pstmt.setString(1, facilityId);
				pstmt.setString(2, encounter_id);
				rset = pstmt.executeQuery();
				while(rset!=null && rset.next())
				{
						visit_adm_date_time	 = rset.getString("VISIT_ADM_DATE_TIME");
						visit_adm_date		 = rset.getString("VISIT_ADM_DATE");
                }    
				if(rset!=null) rset.close();
				if(pstmt!=null) pstmt.close();
			
				String sqlPriority	= "select PRIORITY_CODE, SHORT_DESC, PRIORITY_NO "+
									  "from AE_PAT_PRIORITY where EFF_STATUS='E' order by SHORT_DESC ";

		if(!operation.equalsIgnoreCase("INSERT"))
			{
				String sqlQuery		= " SELECT to_char(TRIAGE_START_DATE_TIME,'dd/mm/yyyy hh24:mi') TRIAGE_START_DATE_TIME, "+
									  " CLINIC_CODE, CLINIC_DESC, TREATMENT_AREA_DESC, TREATMENT_AREA_CODE, NURSE_ID, PHYSICIAN_ID, "+  " TRIAGE_COMPLAINT, to_char(TRIAGE_END_DATE_TIME,'dd/mm/yyyy hh24:mi') TRIAGE_END_DATE_TIME,  "+
									  " PRIORITY_CODE,PHYSICIAN_NAME from AE_PAT_TRIAGE_VW "+
									  " where FACILITY_ID = ? and ENCOUNTER_ID = ? and "+
									  "	to_date(to_char(TRIAGE_START_DATE_TIME,'dd/mm/yyyy hh24:mi'),'dd/mm/yyyy hh24:mi') = to_date('"+triage_start_date_time+"','dd/mm/yyyy hh24:mi') "+
									  " and CLINIC_CODE = ? and TREATMENT_AREA_CODE = ? ";
								pstmt			=	con.prepareStatement(sqlQuery);

								pstmt.setString	(	1,	facilityId		);  // from the session
								pstmt.setString	(	2,	encounter_id	);
								pstmt.setString	(	3,	clinic_code	);
								pstmt.setString	(	4,	treatment_area_code	);
							    rset = pstmt.executeQuery();
								while(rset!=null && rset.next())
								{
									 triage_start_date			= rset.getString("TRIAGE_START_DATE_TIME");
									 triage_start_date			= (triage_start_date == null)?"":triage_start_date;
									 clinic_desc				= rset.getString("CLINIC_DESC");
 									 clinic_desc				= (clinic_desc == null)?"":clinic_desc;
									 treatment_area_desc		= rset.getString("TREATMENT_AREA_DESC");
									 treatment_area_desc		= (treatment_area_desc == null)?"":treatment_area_desc;
									 nurse_description			= rset.getString("NURSE_ID");
									 nurse_description			= (nurse_description == null)?"":nurse_description;
									 practitioner_description	= rset.getString("PHYSICIAN_ID");
									 practitioner_description	= (practitioner_description == null)?"":practitioner_description;

									 p_physician_id				= rset.getString("PHYSICIAN_ID");
									 p_physician_id	= (p_physician_id == null)?"":p_physician_id;

									 p_physician_desc			= rset.getString("PHYSICIAN_NAME");
									 p_physician_desc	= (p_physician_desc == null)?"":p_physician_desc;

									 triage_complaint			= rset.getString("TRIAGE_COMPLAINT");
 									 triage_complaint			= (triage_complaint == null)?"" : triage_complaint;
									 

									 triage_end_date			= rset.getString("TRIAGE_END_DATE_TIME");
  									 triage_end_date			= (triage_end_date == null)?"":triage_end_date;
									 priority_code				= rset.getString("PRIORITY_CODE");
								     priority_code				= (priority_code == null)?"":priority_code;
									 disabledField				= "DISABLED";
									 readOnlyAttribute			= "READONLY";
								}
					if(rset!=null) rset.close();
					if(pstmt!=null) pstmt.close();
	
			} // End of operation
				//  To populate the nurse or the practitioner
				// pract_type='NS'-- Is for Nurse
				// pract_type='MD'-- Is for Doctor
			else if(operation.equalsIgnoreCase("INSERT"))
			{
							pstmt				=	con.prepareStatement(sql_sysdate);
							rset				=	pstmt.executeQuery();
							while(rset!=null && rset.next())
							{
							triage_sysdate		=	rset.getString(1);
							}
							triage_start_date	=	triage_sysdate;
							triage_end_date		=	triage_sysdate;
							if(rset!=null)rset.close();
                			if(pstmt!=null)pstmt.close();
			}
				
				String sqlNurse		 = "";
				//String sqlPract		= "";
%>
	 <body OnMouseDown='CodeArrest()' onLoad='setFocus();' onSelect="codeArrestThruSelect()" onKeyDown = 'lockKey()' >
	 <form name="ae_triage_details_result_form" id="ae_triage_details_result_form"  action="../../servlet/eAE.AETriageDetailsServlet"  method="post" target="messageframe">
<br>
   <table border="0" cellpadding="0" cellspacing="0" align='left' width='90%'>
	 <tr>
		 <th align='left' colspan='6'><fmt:message key="Common.TriageDetails.label" bundle="${common_labels}"/></th>
     </tr>
     <tr>
	          <td class='label' width='5%'>&nbsp;</td>
			  <td class='LABEL' align='RIGHT' width='15%' nowrap><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></td>
  		      <td class='QUERYDATA' align='left' width='30%'>&nbsp;<%=ecis.utils.HTMLUtilities.getDisplayString(clinic_desc)%>
              </td>
			  <td class='LABEL' align='RIGHT' width='15%' nowrap><fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/></td>
  		      <td class='QUERYDATA' align='left' width='30%'>&nbsp;<%=ecis.utils.HTMLUtilities.getDisplayString(treatment_area_desc)%>
              </td>
	          <td class='label' width='5%'>&nbsp;</td>
	 </tr>
	<tr> 
		 <td align='left' colspan='6'>&nbsp;</td>
    </tr>
	<tr>
			  <td class='label' width='5%'>&nbsp;</td>
  		      <td class='LABEL' align='right' width='20%'><fmt:message key="Common.nurse.label" bundle="${common_labels}"/></td>
			  <td class='LABEL' align='left' width='25%'>&nbsp;<select name='nurse' id='nurse' <%=disabledField%>>
					<option value=''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					   <%
						if(open_to_all_pract_yn.equals("Y"))	
						{
							if(open_to_all_prac_for_clinic_yn.equals("Y"))
							{
								sqlNurse	=	" Select practitioner_id, practitioner_name "+
												" from am_pract_for_facility_vw where "+
												" operating_facility_id = ? and eff_status = 'E' "+
												" and pract_type = 'NS' ";
								pstmt			=	con.prepareStatement(sqlNurse);
								pstmt.setString	(	1,	facilityId		);
							}
							else if(treatment_area_code.equals(""))
							{
								sqlNurse	=	" select distinct PRACTITIONER_ID, PRACTITIONER_NAME "+
												" from AE_PRACT_FOR_TMT_AREA_VW "+
												" where FACILITY_ID = ? and CLINIC_CODE = ? "+
												" and EFF_STATUS = 'E' and PRACT_TYPE ='NS' ";
                                if(pstmt!=null) pstmt.close();
								pstmt			=	con.prepareStatement(sqlNurse);
								pstmt.setString	(	1,	facilityId		);
								pstmt.setString	(	2,	clinic_code		);
							}
							else
							{
								sqlNurse		=	" select PRACTITIONER_ID, PRACTITIONER_NAME "+
													" from AE_PRACT_FOR_TMT_AREA_VW "+
													" where FACILITY_ID = ? and CLINIC_CODE = ? "+
													" and TREATMENT_AREA_CODE = ? and EFF_STATUS = 'E' and PRACT_TYPE ='NS' ";
                                if(pstmt!=null) pstmt.close();
								pstmt			=	con.prepareStatement(sqlNurse);
								pstmt.setString	(	1,	facilityId			);
								pstmt.setString	(	2,	clinic_code			);
								pstmt.setString (	3,	treatment_area_code	);
							}
						} // End of if open_to_all_pract_yn
						else
						{
							if(open_to_all_prac_for_clinic_yn.equals("Y"))
							{
								sqlNurse			=	" Select a.PRACTITIONER_ID, a.PRACTITIONER_SHORT_NAME "+
														" PRACTITIONER_NAME "+
														" from OP_PRACT_FOR_CLINIC_VW a,AM_PRACTITIONER b where a.FACILITY_ID = ? "+
														" and a.CLINIC_CODE = ? and a.practitioner_id=b.practitioner_id and  a.EM_VISIT_TYPE_APPL_YN ='Y' "+
														" and b.pract_type='NS' and a.EFF_STATUS = 'E' ";
                                if(pstmt!=null) pstmt.close();
								pstmt				=	con.prepareStatement(sqlNurse);
								pstmt.setString	(	1,	facilityId			);
								pstmt.setString	(	2,	clinic_code			);
						}
						else if(treatment_area_code.equals(""))
						{
								sqlNurse	=	" select distinct PRACTITIONER_ID, PRACTITIONER_NAME "+
												" from AE_PRACT_FOR_TMT_AREA_VW where FACILITY_ID = ? "+
												" and CLINIC_CODE = ? and EFF_STATUS = 'E' and "+
												" PRACT_TYPE ='NS'";
                                if(pstmt!=null) pstmt.close();

								pstmt				=	con.prepareStatement(sqlNurse);

								pstmt.setString	(	1,	facilityId			);
								pstmt.setString	(	2,	clinic_code			);
						}
						else
						{
								sqlNurse			=	" select PRACTITIONER_ID, PRACTITIONER_NAME "+
														" from AE_PRACT_FOR_TMT_AREA_VW where FACILITY_ID = ? "+
														" and CLINIC_CODE = ? and TREATMENT_AREA_CODE = ? "+
														" and EFF_STATUS = 'E' and PRACT_TYPE ='NS'";
                                if(pstmt!=null) pstmt.close();
								pstmt		=	con.prepareStatement(sqlNurse);
								pstmt.setString	(	1,	facilityId			);
								pstmt.setString	(	2,	clinic_code			);
								pstmt.setString (	3,	treatment_area_code	);
						}
					}
					rset			=	pstmt.executeQuery();

					while(rset!=null && rset.next())
					{
						if(nurse_description.equalsIgnoreCase(rset.getString(1)))
							 out.println("<option value='"+rset.getString(1)+"' selected>"+rset.getString(2)+" ");
						else
							 out.println("<option value='"+rset.getString(1)+"'>"+rset.getString(2)+" ");
					}
					if(rset!=null) rset.close();
					if(pstmt!=null) pstmt.close();
					
		   %>
                   </select>
              </td>
			  <td class='LABEL' align='RIGHT' width='20%'>&nbsp;</td>
  		      <td class='LABEL' align='left' width='25%'>&nbsp;
	
				
              </td>
  		      <td class='LABEL' align='RIGHT' width='5%'>&nbsp;</td>
	</tr>
<tr> 
		 <td align='left' colspan='6'>&nbsp;</td>
    </tr>
	<tr> 
	      <td class='label' width='5%'>&nbsp;</td>
		  <td class='LABEL' align='RIGHT' width='20%'><fmt:message key="eAE.Physician.label" bundle="${ae_labels}"/></td>
		  <td class='LABEL' align='left' width='25%' colspan=2>&nbsp;<input readonly type=text name=physician_desc value="<%=p_physician_desc%>" size=30 maxlength=30><input type=hidden name=physician value="<%=p_physician_id%>"><input type=button class=button name=phy_button onClick="TriagepopulatePractitioners()" value='?' <%=disabledField%>>
		 <td class='LABEL' align='RIGHT' width='5%' colspan=3>&nbsp;</td>

	</tr>

	<tr> 
		 <td align='left' colspan='6'>&nbsp;</td>
    </tr>
	<tr>	
		      <td class='label' width='5%'>&nbsp;</td>
		      <td class='LABEL' align='RIGHT' width='15%'><fmt:message key="Common.startdatetime.label" bundle="${common_labels}"/></td>
		      <td class='LABEL' align='left' width='25%' colspan='3'>&nbsp;<input type='text'  name="start_date_time" id="start_date_time"  value="<%=ecis.utils.HTMLUtilities.getDisplayString(triage_start_date)%>" maxLength='16' size='16' onBlur='checkTiming(this);' <%=readOnlyAttribute%>>
				<img src='../../eCommon/images/mandatory.gif' align='center'></img>
              </td>
			 <td class='LABEL' align='RIGHT' width='5%'>&nbsp;</td>
     </tr>
	<tr> 
		 <td align='left' colspan='6'>&nbsp;</td>
    </tr>
    <tr>
			 <td class='LABEL' align='RIGHT' width='5%'>&nbsp;</td>
  		      <td class='LABEL' align='right' width='20%'><fmt:message key="Common.Complaint.label" bundle="${common_labels}"/></td>
			  <td class='LABEL' align='left' width='25%' colspan='3'>&nbsp;<!-- <input type='text'  name="complaint" id="complaint"  value="<%=ecis.utils.HTMLUtilities.getDisplayString(triage_complaint)%>" maxLength='60' size='60'  <%=readOnlyAttribute%> onBlur="makeValidString(this)"> --><textarea name="complaint" <%=readOnlyAttribute%> rows='2' cols='40' onKeyPress='checkMaxLimit(this,60);' onBlur='makeValidString(this);checkMaxSize(this);' onkeypress='checkMaxLimit(this,60)' ><%=ecis.utils.HTMLUtilities.getDisplayString(triage_complaint)%></textarea>
              </td>
			  <td class='LABEL' align='RIGHT' width='5%'>&nbsp;</td>
	 </tr>
	<tr> 
		 <td align='left' colspan='6'>&nbsp;</td>
    </tr>
	<tr> 
		 <td align='left' colspan='6'>&nbsp;</td>
    </tr>
	<tr>	
		      <td class='label' width='5%'>&nbsp;</td>
		      <td class='LABEL' align='RIGHT' width='15%'><fmt:message key="Common.enddatetime.label" bundle="${common_labels}"/></td>
  		      <td class='LABEL' align='left' width='25%' colspan='3'>&nbsp;<input type='text'  name="end_date_time" id="end_date_time"  value="<%=ecis.utils.HTMLUtilities.getDisplayString(triage_end_date)%>" maxLength='16' size='16' onBlur='checkEndTiming(this);' <%=readOnlyAttribute%>>
				<img src='../../eCommon/images/mandatory.gif' align='center'></img>
              </td>
			 <td class='LABEL' align='RIGHT' width='5%'>&nbsp;</td>
    </tr>
	<tr> 
		 <td align='left' colspan='6'>&nbsp;</td>
    </tr>
	<tr>	
		      <td class='label' width='5%'>&nbsp;</td>
		      <td class='LABEL' align='RIGHT' width='20%'><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
  		      <td class='LABEL' align='left' width='25%'>&nbsp;<select name='priority' id='priority' <%=disabledField%>>
				   <option value=''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					   <%
						   pstmt = con.prepareStatement(sqlPriority);
					       rset = pstmt.executeQuery();
						   while(rset!=null && rset.next())
						   {
							   if(priority_code.equalsIgnoreCase(rset.getString(1)))
									 out.println("<option value='"+rset.getString(1)+"|"+rset.getString(3)+"' selected>"+rset.getString(2)+" ");
								else
									 out.println("<option value='"+rset.getString(1)+"|"+rset.getString(3)+"'>"+rset.getString(2)+" ");
						   }
						   if(rset!=null) rset.close();
						   if(pstmt!=null) pstmt.close();
						   
					   %>
                 </select>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img>
                
              </td>
  		      <td class='LABEL' align='RIGHT' width='5%' colspan='3'>&nbsp;</td>
	</tr>
	
   	<tr> 
		    <td colspan='4' colspan='4'>&nbsp;</td>
<%
		if(strCA==null)
			{
		%>
		    <td width='auto' align='right' colspan='2'>
   		        <input type="button" class=button name='recording' id='recording' value='Record' title='Record' onClick='recordTriageResult();' <%=disabledField%> ><input type="button" class=button name='Reseting' id='Reseting' value='Reset' title='Reset' onClick='resetingTriageResult();'></input><input type="button" class=button name='close' id='close' value='Close' title='Close' onClick='parent.parent.window.close();'></input>
			</td>
		<%
			}
			else
			{
		%>
				<td width='auto' align='right' colspan='2'>
   		        <input type="button" class=button name='recording' id='recording' value='Record' title='Record' onClick='recordTriageResult();' <%=disabledField%> ><input type="button" class=button name='Reseting' id='Reseting' value='Reset' title='Reset' onClick='resetingTriageResult();'></input>
			</td>
		<%
			}
		%>
	</tr>
		</table>
			<input type='hidden' name='hdnCA' id='hdnCA' value='<%=strCA%>'>
          <input type='hidden' name='patient_id' id='patient_id' value="<%=patient_id%>">
		  <input type='hidden' name='encounter_id' id='encounter_id' value="<%=encounter_id%>">
		  <input type='hidden' name='queue_status' id='queue_status' value="<%=queue_status%>">
		  <input type='hidden' name='location_code' id='location_code' value="<%=clinic_code%>">
		  <input type='hidden' name='orig_tmt_area_code' id='orig_tmt_area_code' value="<%=orig_tmt_area_code%>">
		
				
  		  <input type='hidden' name='treatment_area_code' id='treatment_area_code' value="<%=treatment_area_code%>">
  		  <input type='hidden' name='treatment_area_desc' id='treatment_area_desc' value="<%=ecis.utils.HTMLUtilities.getDisplayString(treatment_area_desc)%>">
  		  <input type='hidden' name='clinic_desc' id='clinic_desc' value="<%=ecis.utils.HTMLUtilities.getDisplayString(clinic_desc)%>">
		  <input type='hidden' name='queryString' id='queryString' value="<%=ecis.utils.HTMLUtilities.getDisplayString(queryString)%>">
	      <input type='hidden' name='visit_adm_date_time' id='visit_adm_date_time' value="<%=ecis.utils.HTMLUtilities.getDisplayString(visit_adm_date_time)%>">
	      <input type='hidden' name='visit_adm_date' id='visit_adm_date' value="<%=ecis.utils.HTMLUtilities.getDisplayString(visit_adm_date)%>">

 		  <input type='hidden' name='nurse_val' id='nurse_val' value=''>
		  <input type='hidden' name='physician_val' id='physician_val' value=''>
		  <input type='hidden' name='start_date_time_val' id='start_date_time_val' value=''>
		  <input type='hidden' name='complaint_val' id='complaint_val' value=''>
	  	  <input type='hidden' name='duration_val' id='duration_val' value=''>
	  	  <input type='hidden' name='end_date_time_val' id='end_date_time_val' value=''>
	  	  <input type='hidden' name='priority_ind' id='priority_ind' value=''>
	  	  <input type='hidden' name='priority_val' id='priority_val' value=''>
		  <input type='hidden' name='mode' id='mode' value='<%=operation%>'>
		  <input type='hidden' name='open_to_all_pract_yn' id='open_to_all_pract_yn' value='<%=open_to_all_pract_yn%>'>
		  <input type='hidden' name='open_to_all_prac_for_clinic_yn' id='open_to_all_prac_for_clinic_yn' value='<%=open_to_all_prac_for_clinic_yn%>'>
		  <input type='hidden' name='facilityId' id='facilityId' value='<%=facilityId%>'>
		  <input type='hidden' name='practitioner_id' id='practitioner_id' value='<%=practitioner_id%>'>
	    <%
			try
			{
				String sql_sys = "select to_char(sysdate,'dd/mm/yyyy hh24:mi') cdate from dual ";

				stmt = con.createStatement();

				rs   = stmt.executeQuery(sql_sys);

				while (rs.next())
				{
					sysdate = rs.getString(1);
				}
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();

			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				if(rs!=null) rs.close();
				if (stmt!=null) stmt.close();
			}
		%>
<!-- 		   <input type='hidden' name='sysdate' id='sysdate' value="<%=ecis.utils.HTMLUtilities.getDisplayString(sysdate)%>">
 -->	 
		   <input type='hidden' name='sysdate' id='sysdate' value="<%=sysdate%>">

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
		if(rs!=null)  rs.close();
	    ConnectionManager.returnConnection(con,request);
    }
%>
</html>

