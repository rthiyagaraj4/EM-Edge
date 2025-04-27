<!DOCTYPE html>


<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<title><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/> </title>
<head>
 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>


	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
   <%@ include file="../../eMP/jsp/PatientAddressLegends.jsp"%>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
  <script language='javascript' src='../../eAE/js/AEPatientHistory.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
        request.setCharacterEncoding("UTF-8");  
		request= new XSSRequestWrapper(request);
	    response.addHeader("X-XSS-Protection", "1; mode=block");
	    response.addHeader("X-Content-Type-Options", "nosniff");
		
        Connection con               = null;
    	Statement stmt				 = null;
        ResultSet rset               = null;
		
		String sex						= "";
	int  patient_age				= 0;
	int min_age_pregnancy			= 0;
	int max_age_paediatric			= 0;
		
// variables for arrival details
		String facilityId			 = (String)session.getValue("facility_id");
		String patient_id			 = request.getParameter("patient_id");
			   patient_id			 = (patient_id == null)?"":patient_id;
		String encounter_id			 =	request.getParameter("encounter_id");

	//variables for A&E Details
		String ambulatory_status	 ="";
		String responsivenss		 ="";
		String symptom				 ="";
		String patient_type			 ="";
		String accident_type		 ="";
		String rta					 ="";
		String loc_of_accident		 ="";
		String protective_dev_used	 ="";
		String cause_of_accident	 ="";
		String affected_site		 ="";
		String burn					 ="";
		String degree_of_burn		 ="";
		String pat_pos_during_acc	 ="";
		String trauma_case			 ="";
		String injury_type_1		 ="";
		String injury_type_2		 ="";
		String vaccinated			 ="";
		String done_during			 ="";
		String pregnant_at_present	 ="";
		String lmp_date				 ="";
		String milestone_for_age	 ="";
		String imm_uptodate			 ="";
		String height				 ="";
		String height_unit			 ="";
		String weight				 ="";
		String weight_unit			 ="";
		String circumference		 ="";
		String circumference_unit	 ="";


		try{
     con                  = ConnectionManager.getConnection(request);

	 String sqlAddVisit1	=" select sex, round((sysdate-date_of_birth)/365,0) patient_age from mp_patient where patient_id='"+patient_id.trim()+"'"; 

		stmt		=	con.createStatement();
		rset		=   stmt.executeQuery(sqlAddVisit1);

		while(rset!=null && rset.next())
		{
		sex					=	rset.getString("sex");
		patient_age			= rset.getInt("patient_age");
		}
	
		if((sex==null) || (sex.equals("null")) || (sex=="") || (sex.equals("")))
		sex ="";


		String sqlAge	=	"select MIN_AGE_FOR_PREG_DTL,MAX_AGE_FOR_PAED_DTL from ae_param where operating_facility_id='"+facilityId+"'";
        if(rset!=null)rset.close();   
		if(stmt!=null)stmt.close();

		stmt		=	con.createStatement();
		rset		=   stmt.executeQuery(sqlAge);

		while(rset!=null && rset.next())
		{
		min_age_pregnancy	= rset.getInt("MIN_AGE_FOR_PREG_DTL");
		max_age_paediatric	= rset.getInt("MAX_AGE_FOR_PAED_DTL");
		}
		if(stmt!=null) stmt.close();
		if(rset!=null) rset.close();
			

		
		

		// A & E Details

		String sqlAEDetails	=	"select ambulatory_desc,symptom_desc,accident_type_desc,accident_location,accident_cause_desc,anatomical_site_desc,burn_yn,degree_of_burn,pat_position_desc,trauma_yn,blunt_injury_yn,penetrating_injury_yn,tetanus_admin_yn,tetanus_admin_when,pregnant_yn,lmp_date,gd_for_age_yn,im_upto_date_yn,height,height_unit,weight,weight_unit,circumference,circumference_unit,responsiveness_desc,patient_desc,rta_desc,protective_device_desc from ae_pr_encounter_vw where facility_id='"+facilityId.trim()+"' and encounter_id="+encounter_id.trim()+" and patient_id='"+patient_id.trim()+"'";

		

		stmt		=	con.createStatement();
		rset		=   stmt.executeQuery(sqlAEDetails);
		while(rset!=null && rset.next())
		{
		ambulatory_status		=	rset.getString("ambulatory_desc");
		responsivenss			=	rset.getString("responsiveness_desc");
		symptom					=	rset.getString("symptom_desc");
		patient_type			=	rset.getString("patient_desc");
		accident_type			=	rset.getString("accident_type_desc");
		rta						=	rset.getString("rta_desc");
		loc_of_accident			=	rset.getString("accident_location");
		protective_dev_used		=	rset.getString("protective_device_desc");
		cause_of_accident		=	rset.getString("accident_cause_desc");
		affected_site			=	rset.getString("anatomical_site_desc");
		burn					=	rset.getString("burn_yn");
		degree_of_burn			=	rset.getString("degree_of_burn");
		pat_pos_during_acc		=	rset.getString("pat_position_desc");
		trauma_case				=	rset.getString("trauma_yn");
		injury_type_1			=	rset.getString("blunt_injury_yn");
		injury_type_2			=	rset.getString("penetrating_injury_yn");
		vaccinated				=	rset.getString("tetanus_admin_yn");
		done_during				=	rset.getString("tetanus_admin_when");
		pregnant_at_present		=	rset.getString("pregnant_yn");
		lmp_date				=	rset.getString("lmp_date");
		milestone_for_age		=	rset.getString("gd_for_age_yn");
		imm_uptodate			=	rset.getString("im_upto_date_yn");
		height					=	rset.getString("height");
		height_unit				=	rset.getString("height_unit");
		weight					=	rset.getString("weight");
		weight_unit				=	rset.getString("weight_unit");
		circumference			=	rset.getString("circumference");
		circumference_unit		=	rset.getString("circumference_unit");
		}

		if(stmt!=null) stmt.close();
		if(rset!=null) rset.close();

		if(burn.equals("Y") ) { burn ="Yes"; }
		if(burn.equals("N") ) { burn ="No"; }
		if(trauma_case.equals("Y") ) { trauma_case ="Yes"; }
		if(trauma_case.equals("N") ) { trauma_case ="No"; }
		if(injury_type_1.equals("Y") ) { injury_type_1 ="Yes"; }
		if(injury_type_1.equals("N") ) { injury_type_1 ="No"; }
		if(injury_type_2.equals("Y") ) { injury_type_2 ="Yes"; }
		if(injury_type_2.equals("N") ) { injury_type_2 ="No"; }
		if(vaccinated.equals("Y") ) { vaccinated ="Yes"; }
		if(vaccinated.equals("N") ) { vaccinated ="No"; }
		if(pregnant_at_present.equals("Y") ) { pregnant_at_present ="Yes"; }
		if(pregnant_at_present.equals("N") ) { pregnant_at_present ="No"; }
		if(milestone_for_age.equals("Y") ) { milestone_for_age ="Yes"; }
		if(milestone_for_age.equals("N") ) { milestone_for_age ="No"; }
		if(imm_uptodate.equals("Y") ) { imm_uptodate ="Yes"; }
		if(imm_uptodate.equals("N") ) { imm_uptodate ="No"; }

		

		if(height_unit!=null && height_unit.equalsIgnoreCase("C"))
		height_unit = "CM";
		else if(height_unit!=null && height_unit.equalsIgnoreCase("I"))
		height_unit = "Inch";
		if(weight_unit!=null && weight_unit.equalsIgnoreCase("K"))
		weight_unit = "KG";
		else if(weight_unit!=null && weight_unit.equalsIgnoreCase("L"))
		weight_unit = "LB";
		if(circumference_unit!=null && circumference_unit.equalsIgnoreCase("C"))
		circumference_unit = "CM";
		else if(circumference_unit!=null && circumference_unit.equalsIgnoreCase("I"))
		circumference_unit = "Inch";		




		ambulatory_status			= (ambulatory_status == null)?"":ambulatory_status;
		responsivenss				= (responsivenss == null)?"":responsivenss;
		symptom						= (symptom == null)?"":symptom;
		patient_type				= (patient_type == null)?"":patient_type;
		accident_type				= (accident_type == null)?"":accident_type;
		rta							= (rta == null)?"":rta;
		loc_of_accident				= (loc_of_accident == null)?"":loc_of_accident;
		protective_dev_used			= (protective_dev_used == null)?"":protective_dev_used;
		cause_of_accident			= (cause_of_accident == null)?"":cause_of_accident;
		affected_site				= (affected_site == null)?"":affected_site;
		degree_of_burn				= (degree_of_burn == null)?"":degree_of_burn;
		burn						= (burn == null)?"":burn;
		pat_pos_during_acc			= (pat_pos_during_acc == null)?"":pat_pos_during_acc;
		done_during					= (done_during == null)?"":done_during;
		lmp_date					= (lmp_date == null)?"":lmp_date;
		height						= (height == null)?"":height;
		weight						= (weight == null)?"":weight;
		circumference				= (circumference == null)?"":circumference;
		height_unit					= (height_unit == null)?"":height_unit;
		weight_unit					= (weight_unit == null)?"":weight_unit;
		circumference_unit			= (circumference_unit == null)?"":circumference_unit;


%>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
	 <form name="ae_pathistory_result_form" id="ae_pathistory_result_form">
	 

	<br><br><br><br>


	<table border="0" cellpadding="0" cellspacing="0" align='center' width='90%'>
		<tr>
		 <th align='left' colspan='6'><fmt:message key="Common.PatientCondition.label" bundle="${common_labels}"/></th>
     </tr>
		
	 <tr>
		      <td class='label' width='5%'>&nbsp;</td>
		      <td class='LABEL' align='RIGHT' width='20%'><fmt:message key="Common.ambulatorystatus.label" bundle="${common_labels}"/></td>
  		      <td class='QUERYDATA' align='left' width='25%'>&nbsp;&nbsp;<%=ambulatory_status%>
				
              </td>
  		      <td class='LABEL' align='right' width='20%'><fmt:message key="eAE.Responsiveness.label" bundle="${ae_labels}"/></td>
			  <td class='QUERYDATA' align='left' width='25%'>&nbsp;&nbsp;<%=responsivenss%>
				
              </td>
			  <td class='LABEL' align='RIGHT' width='5%'>&nbsp;</td>
	  </tr>
	  <tr>	
		      <td class='label' width='5%'>&nbsp;</td>
		      <td class='LABEL' align='RIGHT' width='20%'><fmt:message key="eAE.Symptom.label" bundle="${ae_labels}"/></td>
  		      <td class='QUERYDATA' align='left' width='25%'>&nbsp;&nbsp;<%=symptom%>
				
              </td>
  		      <td class='LABEL' align='right' width='20%'><fmt:message key="Common.patienttype.label" bundle="${common_labels}"/></td>
			  <td class='QUERYDATA' align='left' width='25%'>&nbsp;&nbsp;<%=patient_type%>
				
              </td>
			  <td class='LABEL' align='RIGHT' width='5%'>&nbsp;</td>
	  </tr>
		 <tr><td colspan='6'>&nbsp;</td></tr>
		<tr><td class='blankwhiterow' colspan='6'>&nbsp;</td></tr>		
     <tr>
	   	  <th align='left' colspan='6'><fmt:message key="eAE.AccidentCase.label" bundle="${ae_labels}"/></th>
     </tr>
				  
	 <tr>	
		      <td class='label' width='5%'>&nbsp;</td>
		      <td class='LABEL' align='RIGHT' width='15%'><fmt:message key="eAE.AccidentType.label" bundle="${ae_labels}"/></td>
  		      <td class='QUERYDATA' align='left' width='25%'>&nbsp;&nbsp;<%=accident_type%>
				
              </td>
  		      <td class='LABEL' align='right' width='20%'><fmt:message key="eAE.RTA.label" bundle="${ae_labels}"/></td>
			  <td class='QUERYDATA' align='left' width='25%'>&nbsp;&nbsp;<%=rta%>
				
              </td>
			  <td class='LABEL' align='RIGHT' width='5%'>&nbsp;</td>
	  </tr>
	  <tr>	
		      <td class='label' width='5%'>&nbsp;</td>
		      <td class='LABEL' align='RIGHT' width='20%'><fmt:message key="eAE.LocationofAccident.label" bundle="${ae_labels}"/></td>
  		      <td class='QUERYDATA' align='left' width='25%'>&nbsp;&nbsp;<%=loc_of_accident%>

				
              </td>
  		      <td class='LABEL' align='right' width='20%' nowrap><fmt:message key="Common.ProtectiveDeviceUsed.label" bundle="${common_labels}"/></td>
			  <td class='QUERYDATA' align='left' width='25%'>&nbsp;&nbsp;<%=protective_dev_used%>
				
              </td>
			  <td class='LABEL' align='RIGHT' width='5%'>&nbsp;</td>
	  </tr>
	  <tr>	
		      <td class='label' width='5%'>&nbsp;</td>
		      <td class='LABEL' align='RIGHT' width='20%'><fmt:message key="eAE.CauseofAccident.label" bundle="${ae_labels}"/></td>
  		      <td class='QUERYDATA' align='left' width='25%'>&nbsp;&nbsp;<%=cause_of_accident%>
				
              </td>
  		      <td class='LABEL' align='right' width='20%'><fmt:message key="eAE.AffectedSite.label" bundle="${ae_labels}"/></td>
			  <td class='QUERYDATA' align='left' width='25%'>&nbsp;&nbsp;<%=affected_site%>
				
              </td>
			  <td class='LABEL' align='RIGHT' width='5%'>&nbsp;</td>
	  </tr>
	 <tr>	
		      <td class='label' width='5%'>&nbsp;</td>
		      <td class='LABEL' align='RIGHT' width='20%'><fmt:message key="eAE.Burn.label" bundle="${ae_labels}"/></td>
  		      <td class='QUERYDATA' align='left' width='25%'>&nbsp;<%=burn%>
              </td>
  		      <td class='LABEL' align='right' width='20%'><fmt:message key="eAE.DegreeofBurn.label" bundle="${ae_labels}"/></td>
			  <td class='QUERYDATA' align='left' width='25%'>&nbsp;&nbsp;<%=degree_of_burn%>

              </td>
			  <td class='LABEL' align='RIGHT' width='5%'>&nbsp;</td>
	  </tr>
	  <tr>	
		      <td class='label' width='5%'>&nbsp;</td>
		      <td class='LABEL' align='RIGHT' width='20%' nowrap><fmt:message key="eAE.PatientPositionduringIncident.label" bundle="${ae_labels}"/></td>
  		      <td class='QUERYDATA' align='left' width='25%'>&nbsp;&nbsp;<%=pat_pos_during_acc%>
              </td>
			  <td class='LABEL' align='left' width='20%'><input type="button" name="bt_incd_remarks" id="bt_incd_remarks" class=BUTTON value="Incident Remarks" tabindex='5' onClick="callIncRemarks('<%=patient_id%>','<%=encounter_id%>')"></td>
  		      <td class='LABEL' align='left' width='20%' colspan='2'>&nbsp;</td>
	  </tr>
		 <tr><td colspan='6'>&nbsp;</td></tr>		
		<tr><td class='blankwhiterow' colspan='6'>&nbsp;</td></tr>
			  
	 <tr>
		 <th align='left' colspan='3'><fmt:message key="Common.Trauma.label" bundle="${common_labels}"/></th>
		 <th align='left' colspan='3'><fmt:message key="eAE.InjuryType.label" bundle="${ae_labels}"/></th>
     </tr>
				  
	 <tr>	
		      <td class='label' width='5%'>&nbsp;</td>
		      <td class='LABEL' align='RIGHT' width='20%'><fmt:message key="Common.CaseofTrauma.label" bundle="${common_labels}"/></td>
			  <td class='QUERYDATA' align='LEFT' width='25%'>&nbsp;&nbsp;<%=trauma_case%>
                  
              </td>
		       <td class='label' align='left' width='10%'>&nbsp;&nbsp;<fmt:message key="eAE.Blunt.label" bundle="${ae_labels}"/>&nbsp;<b><%=injury_type_1%></b></td>
			  <td class='label' align='left'           width='10%'>&nbsp;&nbsp;<fmt:message key="eAE.Penetrating.label" bundle="${ae_labels}"/>&nbsp;<b><%=injury_type_2%></b>
              </td>
			  <td class='LABEL' align='RIGHT' width='5%'>&nbsp;</td>
	  </tr>
	  <tr>
				  <td colspan='6'>&nbsp;</td>
	  </tr>
	  <tr>
				  <td class='blankwhiterow' colspan='6'>&nbsp;</td>
	  </tr>
	  <tr> 
		 <th align='left' colspan='6'><fmt:message key="eAE.TetanusVaccination.label" bundle="${ae_labels}"/></th>
      </tr>
			
	 <tr>				 
		     <td class='label' width='5%'>&nbsp;</td>
		     <td class='LABEL' align='RIGHT' width='20%'><fmt:message key="eAE.Vaccinated.label" bundle="${ae_labels}"/></td>
	 		 <td class='QUERYDATA' align='left' width='20%'>&nbsp;&nbsp;<%=vaccinated%>
             </td>
  		     <td class='LABEL' align='right' width='20%'><fmt:message key="eAE.Doneduring.label" bundle="${ae_labels}"/></td>
			 <td class='QUERYDATA' align='left' width='20%'>&nbsp;&nbsp;<%=done_during%>
	            </td>
			<td class='LABEL' align='left' width='20%'>&nbsp;</td>
     </tr>	

	 <%
		if (sex.equalsIgnoreCase("F") && (patient_age >= min_age_pregnancy))
			{
				//gynaec_yn="Y";
    %>
	 <tr><td colspan='6'>&nbsp;</td></tr>
     <tr><td class='blankwhiterow' colspan='6'>&nbsp;</td></tr>
		<tr> 
		 <th align='left' colspan='6'><fmt:message key="eAE.GynaecDetail.label" bundle="${ae_labels}"/></th>
		</tr>
				  
    <tr>
		     <td class='label' width='5%'>&nbsp;</td>
		     <td class='LABEL' align='RIGHT' width='20%'><fmt:message key="Common.PregnantatPresent.label" bundle="${common_labels}"/></td>
	 		 <td class='QUERYDATA' align='left' width='20%'>&nbsp;&nbsp;<%=pregnant_at_present%>
             </td>
			 <td class='LABEL' align='right' width='15%' ><fmt:message key="eAE.LMPDate.label" bundle="${ae_labels}"/></td>
			 <td class='QUERYDATA' align='left' width='15%' >&nbsp;&nbsp;<%=lmp_date%>
             </td>
			 <td class='LABEL' align='left' width='5%'>&nbsp;</td>
     </tr>
	<tr><td colspan='6'>&nbsp;</td></tr>
	<%
			}  // End of Gynaec Details
     	    if (patient_age <= max_age_paediatric)
			{
				
    %>
    <tr><td class='blankwhiterow' colspan='6'>&nbsp;</td></tr>
	<tr> 
		 <th align='left' colspan='6'><fmt:message key="Common.PediatricDetail.label" bundle="${common_labels}"/></th>
    </tr>
				 
	<tr>
		     <td class='label' width='5%'>&nbsp;</td>
		     <td class='LABEL' align='RIGHT' width='20%' nowrap><fmt:message key="eAE.GrowthDevelMileStoneforAge.label" bundle="${ae_labels}"/></td>
	 		 <td class='QUERYDATA' align='left' width='20%'>&nbsp;&nbsp;<%=milestone_for_age%>
             </td>
			 <td class='LABEL' align='right' width='15%' nowrap><fmt:message key="eAE.ImmunizationuptoDate.label" bundle="${ae_labels}"/></td>
			 <td class='QUERYDATA' align='left' width='15%' >&nbsp;&nbsp;<%=imm_uptodate%>
		
             </td>
			 <td class='LABEL' align='left' width='5%'>&nbsp;</td>
     </tr>
	<tr>
		     <td class='label' width='5%'>&nbsp;</td>
		     <td class='LABEL' align='RIGHT' width='20%'><fmt:message key="Common.height.label" bundle="${common_labels}"/></td>
			 <td class='QUERYDATA' align='left' width='10%'>&nbsp;&nbsp;<%=height%><%=height_unit%>
             </td>
			 <td class='label' align='left' width='10%'> <fmt:message key="Common.weight.label" bundle="${common_labels}"/>&nbsp;&nbsp;<b><%=weight%><%=weight_unit%></b></td>
 			 <td class='label' align='left' width='10%' >&nbsp;<fmt:message key="Common.Circumference.label" bundle="${common_labels}"/>&nbsp;&nbsp;<b><%=circumference%><%=circumference_unit%></b>
             </td>
			 <td class='LABEL' align='left' width='5%'>&nbsp;</td>
     </tr> 
	<% } // end of pediatric%>
	 <tr><td align='left' colspan='6'>&nbsp;</td></tr>
    </table> 


	

		 </form>
	 </body>  
<%
    } catch(Exception e)  {
        //out.print(e.toString());
		e.printStackTrace();
    }   finally   {
        if(stmt!=null)  stmt.close();
		if(rset!=null)  rset.close();
	    ConnectionManager.returnConnection(con,request);
    }
%>

</html>

