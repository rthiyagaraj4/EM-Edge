<!DOCTYPE html>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*,com.ehis.util.*,org.json.simple.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/dchk.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eAE/js/AEManagePatient.js'></script>
<script language='javascript' src='../../eAE/js/AEUtilities.js'></script>
<script language='javascript' src='../../eAE/js/AEPractitionerComponent.js'></script>

<!--Added by Ashwini on 10-May-2018 for ML-MMOH-CRF-1133-->
<Script src="../../eCommon/js/CommonCalendar.js" language="javascript"></Script>
<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>  
<% 
	Connection			con			=	null;
	PreparedStatement	pstmt		=	null;
	PreparedStatement	pstmt1		=	null;
	ResultSet			rs			=	null;
	ResultSet			rs1			=	null;
	String	facility_id				=	"";
	String  bl_install_yn           =	"";
	String	open_to_all_pract_yn	=	"";
	String	clinic_code				=	"";
	String	treatment_area_code		=	"",		treatment_area_desc		=	"";
	String	clinic_type				=	"",		encounter_id			=	"";
	String	queue_date				=	"",		tmt_area_prop			=	"";
	String	selection_mode			=	"";
	String	tmt_area_code			=	"";
	String	practitioner_name		=	"";
	String	pract_id				=	"";
	String	queue_status			=	"";
	String	patient_gender			=	"";
    String  regFlag					=	"",		treatment_area_gender	=	"";
	String  service_code			=   "";
	
	/* below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] */
	String sql              ="";
	String color            ="";
	String  green           ="";
	String red              ="";
    String yellow           ="";
    String unassigned       ="";
	
	/* CRF  SKR-CRF-0021 [IN028173] end  */
	
	
	String	open_to_all_prac_for_clinic_yn	=	"";
	String	speciality_code		=	"";
	int		arrIndex				=	1 ;
	String  sys_date_time="",visit_date_time="";
	String patient_id = "";
	String strCA = "";
	String bed_no = "";
	String bed_prop = "";
	String priority_zone = "";
	//String pvr = "", pvy = "", pvg ="",pvu ="";
	int countBed =0;
	String treatAreaSel ="";
	//String sex ="";
	String open_to_all_prac_for_clinic_ynSel="";
	String visit_type_code = "";
	String pract_type = "";
	String login_user="";
	String episode_id="";
	String episode_visit_num="";	
	String locale			= (String)session.getAttribute("LOCALE");
	//String loginUser			= checkForNull((String)session.getValue("login_user"));
	String brought_dead="";
	String year_value="";

	String isStartConsultationAppl = "";//Added by Thamizh selvi on 10th Oct 2017 for ML-MMOH-CRF-0623
	
	/*Added by Ashwini on 10-May-2018 for ML-MMOH-CRF-1133*/
	Boolean isEnableDateTimeAppl = false;
	String visit_adm_date_time	 = "";
	/*End ML-MMOH-CRF-1133*/

    /*Added by Arthi for ML-MMOH-CRF-1975 on 02-Nov-2022*/
	Boolean isPriorityAssgnTmtAreaAppl = false;
	String sqlFinal		 = "";
	String optSelected	 = "";
	String priority_code = "";
	/*End ML-MMOH-CRF-1975*/
	
	try
	{
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		
		con				=	(Connection)	ConnectionManager.getConnection(request);
		facility_id		=	(String) session.getValue("facility_id");
        bl_install_yn   =   (String) session.getValue("bl_operational"); 
		login_user		=   (String)session.getValue("login_user") ;
		//strCA = request.getParameter("CA");
		strCA = request.getParameter("CA")==null?"N":request.getParameter("CA");		
		String option_id =  request.getParameter("option_id");
		String start_date =  request.getParameter("start_date");
		String end_date =  request.getParameter("end_date");
		String enable_rights_yn =  request.getParameter("enable_rights_yn")==null?"":request.getParameter("enable_rights_yn");
		String min_age_for_lmp =  request.getParameter("min_age_for_lmp")==null?"":request.getParameter("min_age_for_lmp");		
		String sel_cons_yn =  request.getParameter("sel_cons_yn")==null?"":request.getParameter("sel_cons_yn");		
		String sel_triage_yn =  request.getParameter("sel_triage_yn")==null?"":request.getParameter("sel_triage_yn");		
		String pract_type1 =  request.getParameter("pract_type1")==null?"":request.getParameter("pract_type1");			
 		selection_mode			=	checkForNull(request.getParameter("selection_mode"));
		clinic_code				=	checkForNull(request.getParameter("clinic_code"));
		clinic_type				=	checkForNull(request.getParameter("clinic_type"));
		queue_date				=	checkForNull(request.getParameter("queue_date"));
		queue_status			=	checkForNull(request.getParameter("queue_status"));
		encounter_id			=	checkForNull(request.getParameter("encounter_id"));
		open_to_all_pract_yn	=	checkForNull(request.getParameter("open_to_all_pract_yn"));
		tmt_area_code			=	checkForNull(request.getParameter("treatment_area_code"));
		pract_id				=	checkForNull(request.getParameter("practitioner_id"));
		practitioner_name		=	checkForNull(request.getParameter("practitioner_name"));
		practitioner_name       =	java.net.URLDecoder.decode(practitioner_name,"UTF-8");
		patient_gender			=	checkForNull(request.getParameter("patient_gender"));
		bed_no					=	checkForNull(request.getParameter("bed_no"));
		brought_dead			=	checkForNull(request.getParameter("brought_dead"));
		bed_no=bed_no.trim();
		visit_type_code         =   checkForNull(request.getParameter("visit_type_code"));
	    pract_type              =   checkForNull(request.getParameter("pract_type"));
		priority_zone			=	checkForNull(request.getParameter("priority_zone"));

		isStartConsultationAppl	=	checkForNull(request.getParameter("isStartConsultationAppl"));//Added by Thamizh selvi on 10th Oct 2017 for ML-MMOH-CRF-0623
		
		/*Added by Ashwini on 10-May-2018 for ML-MMOH-CRF-1133*/
		isEnableDateTimeAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "AE","ENABLE_DATE_TIME"); 
		JSONObject jsonValue = eAE.AECommonBean.getRegistrationDate(con, facility_id, encounter_id);
		visit_adm_date_time	 = (String) jsonValue.get("visit_adm_date_time");
		/*End ML-MMOH-CRF-1133*/
	
		/*if(priority_zone.equals("R")) {pvr="Selected"; pvy="";pvg="";pvu="";}
		   else if(priority_zone.equals("Y")){pvr=""; pvy="Selected";pvg="";pvu="";}
				else if(priority_zone.equals("G")){pvr=""; pvy="";pvg="Selected";pvu="";}
                 else if(priority_zone.equals("U")){pvr=""; pvy="";pvg="";pvu="Selected";}*/
		patient_id				=	checkForNull(request.getParameter("patient_id"));
		regFlag					=	checkForNull(request.getParameter("regFlag"));

		//Added by Arthi for ML-MMOH-CRF-1975 on 02-Nov-2022
		isPriorityAssgnTmtAreaAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "ADD_PRIORITY_ASSGN_TMTAREA");


		if(regFlag.equals("")) regFlag ="N";
		if(strCA != null)
		{
			if (strCA.equals("Y")){// Wednesday, June 02, 2010 PE_EXE venkat s
			StringBuffer sqlPatTri = new StringBuffer();
			sqlPatTri.append("select a.PATIENT_ID, a.treatment_area_code,a.practitioner_id,  a.priority_zone,a.ae_bed_no bed_no,TO_CHAR(a.queue_date,'dd/mm/yyyy') queue_date_time,   a.queue_status,   a.visit_type_code,  b.open_to_all_pract_yn, AM_GET_DESC.AM_PRACTITIONER(a.practitioner_id,'"+locale+"','1') practitioner_full_name, (case when a.practitioner_id is not null then (select pract_type from am_practitioner where practitioner_id = a.practitioner_id) end) pract_type,	TO_CHAR(d.date_of_birth,'dd/mm/yyyy') date_of_birth, CALCULATE_AGE(TO_CHAR(d.date_of_birth,'dd/mm/yyyy'),1) year,		CALCULATE_AGE(TO_CHAR(d.date_of_birth,'dd/mm/yyyy'),2) months, CALCULATE_AGE(TO_CHAR(d.date_of_birth,'dd/mm/yyyy'),3) days, d.sex , NVL((CASE   WHEN a.treatment_area_code IS NOT NULL THEN (SELECT open_to_all_prac_for_clinic_yn  FROM ae_tmt_area_for_clinic  WHERE facility_id = a.facility_id  AND clinic_code = a.locn_code AND treatment_area_code = a.treatment_area_code)  END  ),'N') open_to_all_prac_for_clinic_yn,a.pat_priority from ae_current_patient a, op_clinic b, mp_patient d where a.facility_id = b.facility_id AND a.locn_code=b.clinic_code and a.patient_id=d.patient_id and a.facility_id = ? AND  a.encounter_id=?");
			
			pstmt		=	con.prepareStatement(sqlPatTri.toString());

			clinic_code				=	checkForNull(request.getParameter("location_code"));
			clinic_type				=	checkForNull(request.getParameter("location_type"));
			if(request.getParameter("option_id").equals("AE_REASSIGN_TA"))
			{
				selection_mode = "ReassignTreatmentArea";
			}
			episode_id			=	checkForNull(request.getParameter("episode_id"));
			
			pstmt.setString	(	1,	facility_id	);
			pstmt.setString	(	2,	encounter_id);
			rs					=	pstmt.executeQuery();
			
			
				while(rs.next())
				{

						patient_id = rs.getString("PATIENT_ID");
						open_to_all_pract_yn = checkForNull(rs.getString("open_to_all_pract_yn"));
						open_to_all_prac_for_clinic_yn =   checkForNull(rs.getString("open_to_all_prac_for_clinic_yn"));
						tmt_area_code		=	checkForNull(rs.getString("treatment_area_code"));	
						pract_id = checkForNull(rs.getString("practitioner_id"));
						practitioner_name = checkForNull(rs.getString("practitioner_full_name"));
						queue_date				=	checkForNull(rs.getString("queue_date_time"));
						queue_status			=	checkForNull(rs.getString("queue_status"));
						bed_no 		=	checkForNull(rs.getString("bed_no"));
					    priority_zone		    = checkForNull(rs.getString("priority_zone"));
					    priority_code		    = checkForNull(rs.getString("pat_priority")); //Added by Arthi for ML-MMOH-CRF-1975 on 02-Nov-2022
		                
						/* if(priority_zone.equals("R")) {pvr="Selected"; pvy="";pvg="";pvu="";}
		                else if(priority_zone.equals("Y")){pvr=""; pvy="Selected";pvg="";pvu="";}
				        else if(priority_zone.equals("G")){pvr=""; pvy="";pvg="Selected";pvu="";}
                        else if(priority_zone.equals("U")){pvr=""; pvy="";pvg="";pvu="Selected";} */
					    patient_gender 		=	checkForNull(rs.getString("sex"));
					    year_value 		=	checkForNull(rs.getString("year"));
					

                        visit_type_code     =	checkForNull(rs.getString("visit_type_code"));
	                    pract_type          =	checkForNull(rs.getString("pract_type"));

				}

				
                if (rs != null)   rs.close();
				if (pstmt != null) pstmt.close();
				if((sqlPatTri != null) && (sqlPatTri.length() > 0))
				{
					sqlPatTri.delete(0,sqlPatTri.length());
				}
		}
	}
	   /* merged with below query for PE - 11/05/2010
	   StringBuffer sqlSpl = new StringBuffer();
	   sqlSpl.append("select SPECIALITY_CODE from op_clinic ");
	   sqlSpl.append(" where clinic_code=? and facility_id=? ");
       out.println(sqlSpl.toString());
       pstmt2				=	con.prepareStatement(sqlSpl.toString());
	 
	   pstmt2.setString(1,	clinic_code); 
	   pstmt2.setString(2,	 facility_id);
		 
		 rs2					=	pstmt2.executeQuery(); 
		 if (rs2.next())
			{
				speciality_code	=rs2.getString("speciality_code");
			}

	   if (rs2 != null)   rs2.close();
	   if (pstmt2 != null) pstmt2.close();  
	   if((sqlSpl != null) && (sqlSpl.length() > 0))
		{
			sqlSpl.delete(0,sqlSpl.length());
		} 
        
        
		pstmt			=	con.prepareStatement("select  TO_CHAR(date_of_birth,'dd/mm/yyyy') date_of_birth, CALCULATE_AGE(TO_CHAR(date_of_birth,'dd/mm/yyyy'),1) year  from mp_patient where patient_id='"+patient_id+"' ");
		rs = pstmt.executeQuery();

		if(rs!= null &&  rs.next() )
		{
			year_value=rs.getString("year")==null?"":rs.getString("year");
		} 
        */

		 StringBuffer sqlVisitDt = new StringBuffer();
        sqlVisitDt.append("select to_char(a.queue_date,'dd/mm/yyyy hh24:mi') sys_date, to_char(sysdate,'dd/mm/yyyy hh24:mi') system_date, a.service_code, a.episode_id, a.OP_EPISODE_VISIT_NUM episode_visit_num, TO_CHAR(b.date_of_birth,'dd/mm/yyyy') date_of_birth, CALCULATE_AGE(TO_CHAR(b.date_of_birth,'dd/mm/yyyy'),1) year, c.SPECIALITY_CODE,a.pat_priority from ae_current_patient a, mp_patient b, op_clinic c where a.FACILITY_ID=?  and  a.encounter_id=? and a.patient_id=? and a.patient_id = b.patient_id and a.FACILITY_ID = c.facility_id and a.locn_code = c.clinic_code");
		
		
		pstmt					=	con.prepareStatement(sqlVisitDt.toString());
		pstmt.setString(1,facility_id);
		pstmt.setString(2,encounter_id);
		pstmt.setString(3,patient_id);
		
		rs=pstmt.executeQuery();
		if(rs!=null && rs.next())
        {
			visit_date_time=rs.getString("sys_date");
            sys_date_time=rs.getString("system_date");   
			service_code=rs.getString("service_code");
			episode_id=rs.getString("episode_id");
			episode_visit_num=rs.getString("episode_visit_num");
			year_value=rs.getString("year")==null?"":rs.getString("year");
			speciality_code	=rs.getString("speciality_code");
			priority_code = rs.getString("pat_priority"); //Added by Arthi for ML-MMOH-CRF-1975 on 02-Nov-2022
		}
		 if (rs != null)   rs.close();
		 if (pstmt != null) pstmt.close();
	     if((sqlVisitDt != null) && (sqlVisitDt.length() > 0))
		 {
			sqlVisitDt.delete(0,sqlVisitDt.length());
		 }
		if(selection_mode.equals("AssignReassignPractitioner"))
		{
			tmt_area_prop			=	"disabled"; 
			bed_prop                =   "disabled";
			
        }
%>
<body onload="checkStatus('<%=queue_status%>','<%=strCA%>');disboth();chkboth();" onKeyDown = 'lockKey()'>
<center>
<br>
<form name='AEMPAssgnTmtAreaForm' id='AEMPAssgnTmtAreaForm' method='POST'>
	<table border='0' cellpadding='3' cellspacing='0' width='97%'>
	<tr>
	<input type='hidden' name='gender' id='gender' value="<%=patient_gender%>">
	<input type='hidden' name='strCA' id='strCA' value="<%=strCA%>">
	<!-- changePriority(this) Added by Arthi for ML-MMOH-CRF-1975 on 02-Nov-2022 -->
		<td class='LABEL' width='25%'><fmt:message key="Common.PriorityZone.label" bundle="${common_labels}"/></td>
		<%if(regFlag.equals("Y") && (!priority_zone.equals(""))) {  %>
	  	   <td class='fields' width='25%'><select name='priority_value' id='priority_value' onchange="getValues(this,'<%=facility_id%>','<%=clinic_code%>','<%=patient_gender%>','<%=strCA%>');chkboth();<%if(isPriorityAssgnTmtAreaAppl){%>changePriority(this);<%}%>" disabled>
       <%}else if(!priority_zone.equals("")){ %>
			  <td class='fields' width='25%'><select name='priority_value' id='priority_value'  onchange="getValues(this,'<%=facility_id%>','<%=clinic_code%>','<%=patient_gender%>','<%=strCA%>');chkboth();enableOK();<%if(isPriorityAssgnTmtAreaAppl){%>changePriority(this);<%}%>"<%=tmt_area_prop%>> 
	    <%}else{%>
			<td class='fields' width='25%'><select name='priority_value' id='priority_value'   onchange="getValues(this,'<%=facility_id%>','<%=clinic_code%>','<%=patient_gender%>','<%=strCA%>');chkboth();enableOK();<%if(isPriorityAssgnTmtAreaAppl){%>changePriority(this);<%}%>" <%=tmt_area_prop%>>
		 <% }%>
         
		<!-- below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] -->
       <%
	   sql="SELECT PRIORITY_ZONE,PRIORITY_ZONE_DESC FROM AE_PRIORITY_ZONE_LANG_VW WHERE LANGUAGE_ID= ? and EFF_STATUS='E' order by PRIORITY_ZONE_ORDER ";
				
			    pstmt   = con.prepareStatement(sql.toString());
				pstmt.setString(1,locale) ;
			    rs    = pstmt.executeQuery();
				while(rs!=null && rs.next())
				{
				if(priority_zone.equals(rs.getString(1)))
				out.println("<option value='"+rs.getString(1)+"' selected>");	
			else
			   out.println("<option value='"+rs.getString(1)+"'>");	     
			   out.println(rs.getString(2));
			   out.println("</option>"); 
				}
		    
			
	   %>
		<!--CRF  SKR-CRF-0021 [IN028173] end-->
		</select><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
		
	</tr>
 
    <!-- Added by Arthi for ML-MMOH-CRF-1975 on 02-Nov-2022 -->
	<%if(isPriorityAssgnTmtAreaAppl){%>
	<tr> 
	    <td class='LABEL' width='25%' ><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
			<td class='fields' width='25%'>
				    <select name='priority11' id='priority11' >
						<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------
						<%
					   
                       StringBuffer sqlpriority = new StringBuffer();
					   sqlpriority.append("select PRIORITY_CODE,SHORT_DESC from ");
					   sqlpriority.append("ae_pat_priority_lang_vw where language_id='"+locale+"'  and PRIORITY_ZONE=? and EFF_STATUS='E'");
	                     	
						sqlFinal = sqlpriority.toString();
					
						 pstmt = con.prepareStatement(sqlFinal);
						 pstmt.setString(1,priority_zone);
					     rs = pstmt.executeQuery();
						 while(rs !=null && rs.next())
						   {
							   if(rs.getString(1).equals(priority_code))
							   {
                                    optSelected = "selected";
							   }
							   else
								   optSelected="";

							   out.println("<option value='"+rs.getString(1)+"'"+optSelected+">"+rs.getString(2)+" ");
							  
						   }
						 if(pstmt!=null) pstmt.close();
						 if(rs!=null) rs.close();
						 if((sqlpriority != null) && (sqlpriority.length() > 0))
						 {
							sqlpriority.delete(0,sqlpriority.length());
						 }
					   %>  
					</select>
			</td>
	</tr>
	<%}%>
	<!-- End ML-MMOH-CRF-1975 -->

    <tr>
		<td class='LABEL' width='25%'><fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/></td>
       <%if(regFlag.equals("Y") && (!priority_zone.equals(""))&& (!tmt_area_code.equals("")))
				{ %>
		<td class='fields' width='25%'><select name='treatment_area_code' id='treatment_area_code' onBlur='enableOK();' onChange="chkboth(); clearBed();enableOK();" <%=tmt_area_prop%>  tabindex = "1" disabled>
         <%}else if((!priority_zone.equals("")) && (!tmt_area_code.equals(""))){ %> 
            <td class='fields' width='25%'><select name='treatment_area_code' id='treatment_area_code' onBlur='enableOK();' onChange="chkboth();clearBed();populateDynamicValues('AssignTreatmentArea');" <%=tmt_area_prop%>  tabindex = "1" > 
        <%}else { %>
         <td class='fields' width='25%'><select name='treatment_area_code' id='treatment_area_code' onBlur='enableOK();' onChange="chkboth();clearBed();populateDynamicValues('AssignTreatmentArea');"  <%=tmt_area_prop%> tabindex = "1" >
         <% } %>
		<option value=''>---------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
<%
	    StringBuffer sqlTreat = new StringBuffer();
		sqlTreat.append("SELECT TREATMENT_AREA_CODE,  SHORT_DESC,open_to_all_prac_for_clinic_yn  FROM AE_TMT_AREA_FOR_CLINIC_LANG_VW WHERE  language_id='"+locale+"'  and FACILITY_ID =? AND CLINIC_CODE =?  AND PRIORITY_ZONE=? and eff_status='E' and  (gender = ? OR gender IS NULL) order by 2");
		pstmt		=	con.prepareStatement(sqlTreat.toString());
		pstmt.setString(1,facility_id);
		pstmt.setString(2,clinic_code);
		pstmt.setString(3,priority_zone);
		pstmt.setString(4,patient_gender);

		rs			=	pstmt.executeQuery();
		while(rs.next())
		{
			treatment_area_code				=	rs.getString("TREATMENT_AREA_CODE");
			treatment_area_desc				=	rs.getString("SHORT_DESC");
			open_to_all_prac_for_clinic_yn	=	rs.getString("open_to_all_prac_for_clinic_yn");
			if(open_to_all_prac_for_clinic_yn==null)
				open_to_all_prac_for_clinic_yn	=	"N";
			if(tmt_area_code.equals(treatment_area_code))	
			{
				tmt_area_prop				=	"selected";
				treatAreaSel                = treatment_area_code;
				open_to_all_prac_for_clinic_ynSel =open_to_all_prac_for_clinic_yn;
			}
			else
			{
				tmt_area_prop	=	"";
			}

			%>
			<option value='<%=treatment_area_code%>' <%=tmt_area_prop%>> <%=treatment_area_desc%> </option>
			<!-- <script>
			openToAllPractForClnYN[<%=arrIndex%>] = '<%=open_to_all_prac_for_clinic_yn %>';
			</script> -->
             <!-- treatmentGender[<%=arrIndex%>] = '<%=treatment_area_gender%>'; -->
			<%
				arrIndex++;
		}  
		open_to_all_prac_for_clinic_yn = open_to_all_prac_for_clinic_ynSel;

		if(rs!=null) rs.close(); 
    	if (pstmt != null) pstmt.close();
		if((sqlTreat != null) && (sqlTreat.length() > 0))
		 {
			sqlTreat.delete(0,sqlTreat.length());
		 }

%>		</select><img src='../../eCommon/images/mandatory.gif'></img></td>
	</tr>
	<tr>
		<td class='LABEL' width='25%'><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
		<td class='QUERYDATA' width='25%'>
	<% 
	                StringBuffer sqlSev = new StringBuffer();

                    sqlSev.append("select SHORT_DESC from AM_SERVICE_LANG_VW WHERE language_id='"+locale+"' AND SERVICE_CODE =  ?");
					 pstmt1 = con.prepareStatement(sqlSev.toString());
					 pstmt1.setString(1,service_code);

					 rs1 = pstmt1.executeQuery();
					 if (rs1 != null)
					{
					 while (rs1.next())
						{
						%>
						
							<%=rs1.getString("SHORT_DESC")%>
						<%
						}
					}
					 if(pstmt1!=null)pstmt1.close();
		             if(rs1!=null)rs1.close();
					 if((sqlSev != null) && (sqlSev.length() > 0))
					 {
						sqlSev.delete(0,sqlSev.length());
					 }
				
	%>
	</td>
	</tr>
		<%
		           // StringBuffer sqlBed = new StringBuffer(); Wednesday, June 02, 2010 PE_EXE venkat S
	                //sqlBed.append("select count(*) from ae_bed_for_trmt_area where FACILITY_ID= ? and  clinic_code= ? and  TREATMENT_AREA_CODE= ? and EFF_STATUS='E' ");
					pstmt1   = con.prepareStatement("select count(*) from ae_bed_for_trmt_area where FACILITY_ID= ? and  clinic_code= ? and  TREATMENT_AREA_CODE= ? and EFF_STATUS='E'");
					pstmt1.setString(1,facility_id);
					pstmt1.setString(2,clinic_code);
					pstmt1.setString(3,treatAreaSel);

					rs1		 = pstmt1.executeQuery(); 
					if(rs1!=null)
					{
						while(rs1.next())
							{
								countBed=rs1.getInt(1);
							}
					}
					if(pstmt1!=null) pstmt1.close();
		            if(rs1!=null) rs1.close(); 
			    
		%>
	<tr>	
		<input type='hidden' name='bed_count' id='bed_count' value=''>
		<td class='LABEL' width='25%'><fmt:message key="eAE.BedBayNo.label" bundle="${ae_labels}"/></td>
		<td class='fields' width='25%'><input type='text' name='bed_bay_no' id='bed_bay_no' size='8' maxlength='8' readonly onblur="ChangeUpperCase(this);" onKeyPress="return(CheckForSpecChars(event));enableOK();"   value='<%=bed_no%>' <%=bed_prop%> tabindex = "2"><input type=button class=button value='?' name='bed_button' id='bed_button'  onClick="callBedAvailChart();" <%=bed_prop%> tabindex = "3"><img src='../../eCommon/images/mandatory.gif' align='center' id='bed_mand' style='visibility:hidden'></img></td>
		<%
		if (countBed > 0)
		{
		%>
		<script>
				document.getElementById("bed_mand").style.visibility='visible';
		        document.forms[0].bed_count.value='Y';
		</script>
		<%}
		else
		{ 
		%>
		<script>
				document.getElementById("bed_mand").style.visibility='hidden';
		        document.forms[0].bed_count.value='N';
		</script>
		<%} %>
	</tr>
	<tr>
	<% /*Added by Rameswar on 12-Feb-16 for GDOH-CRF-081*/
		Boolean isPracApplicable	= eCommon.Common.CommonBean.isSiteSpecific(con, "AE","PRACT_MANDATORY_AE");//Dummy Column name
		if(isPracApplicable){
					
		if(tmt_area_code.equals("") || priority_zone.equals("U")){
			practitioner_name	= "";
			pract_id			= "";
		}
		}/*Added by Rameswar on 12-Feb-16 for GDOH-CRF-081*/		
		%>
		<td class='LABEL' width='25%'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
		<td class='fields' width='25%'><input type=text  name=practitioner_desc size=30 maxlength=30 value="<%=practitioner_name%>" onBlur="beforeGetPractitioner(document.forms[0].pract_button,practitioner_desc);" ><input type=hidden value="<%=pract_id%>" name='practitioner_id' id='practitioner_id' ><input type=button class=button value='?' name=pract_button   onclick="aegetPractitioner(this,practitioner_desc); "><img src='../../eCommon/images/mandatory.gif' align='center' id='pract_mand'></img><input type='hidden' name='prev_pract_name' id='prev_pract_name' value="">
		</td> 
 
		<%
			if ((selection_mode.equals("AssignReassignPractitioner")))
			{
		%>
			<script>
					document.forms[0].pract_mand.style.visibility='visible';
			</script>
		<%	}else{%>
			<script>
					document.forms[0].pract_mand.style.visibility='hidden';
			</script>
		<%	}%>
	</tr>
	<tr>
		<td class='LABEL' width='25%' ><fmt:message key="Common.datetime.label" bundle="${common_labels}"/></td>
		<!--Added by Ashwini on 10-May-2018 for ML-MMOH-CRF-1133-->
		<%if(!isEnableDateTimeAppl){%>
		<td class='fields' width='25%'><input type='text' name='assign_tmt_area_time' id='assign_tmt_area_time' value='<%=DateUtils.convertDate(sys_date_time,"DMYHM","en",locale)%>' size='16' maxlength='16'   disabled ></td>
		<%}else{%>
		<td class='fields' width='25%'>
			<input type='text' name='assign_tmt_area_time' id='assign_tmt_area_time' value='<%=DateUtils.convertDate(sys_date_time,"DMYHM","en",locale)%>' onBlur="if(validDateObj(this,'DMYHM',localeName)){chkWithSysDt(this);}" size='16' maxlength='16'><img type='image' src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].assign_tmt_area_time.select();return showCalendar('assign_tmt_area_time', null, 'hh:mm');" style="cursor='hand'"></img>&nbsp;
			<img src='..\..\eCommon/images/mandatory.gif'></img>
		</td>
		<%}%>
		<!--End ML-MMOH-CRF-1133-->
	</tr>
</table> 
<p align='center'>
<input type='button' class='BUTTON' name='ok' id='ok' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>'
   onClick='assignTreatmentArea();'  >&nbsp;  
<% if(strCA .equals("Y")) {%>   
     
      <input type='button' class='BUTTON' name='cancel' id='cancel' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>' onClick='cancelOperation1("<%=option_id%>");'>
<%}else{%>
	<input type='button' class='BUTTON' name='cancel' id='cancel' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>' onClick='cancelOperation()'>
<%}%>
</p>
<br>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>'>
<input type='hidden' name='bl_install_yn' id='bl_install_yn' value='<%=bl_install_yn%>'>
<input type='hidden' name='clinic_code' id='clinic_code' value='<%=clinic_code%>'>
<input type='hidden' name='clinic_type' id='clinic_type' value='<%=clinic_type%>'>
<input type='hidden' name='visit_type_code' id='visit_type_code' value="<%=visit_type_code%>">
<input type='hidden' name='pract_type' id='pract_type' value="<%=pract_type%>">
<input type='hidden' name='queue_date' id='queue_date'	value='<%=queue_date%>'>
<input type='hidden' name='encounter_id' id='encounter_id' value='<%=encounter_id%>'>
<input type='hidden' name='sys_date_time' id='sys_date_time' value='<%=sys_date_time%>'>
<input type='hidden' name='visit_date_time' id='visit_date_time' value='<%=visit_date_time%>'>
<input type='hidden' name='open_to_all_pract_yn' id='open_to_all_pract_yn' value='<%=open_to_all_pract_yn%>'>
<input type='hidden' name='selection_mode' id='selection_mode' value='<%=selection_mode%>'>
<input type='hidden' name='start_date' id='start_date' value='<%=start_date%>'>
<input type='hidden' name='end_date' id='end_date' value='<%=end_date%>'>
<input type='hidden' name='queue_status' id='queue_status' value='<%=queue_status%>'>
<input type='hidden' name='operation_mode' id='operation_mode' value="AssignTreatmentArea" >
<input type='hidden' name='prev_tmt_area_code' id='prev_tmt_area_code' value='<%=tmt_area_code%>'>
<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
<input type='hidden' name='userid' id='userid' value='<%=login_user%>'>
<input type='hidden' name='speciality_code' id='speciality_code' value='<%=speciality_code%>'>
<input type='hidden' name='open_to_all_prac_for_clinic_yn' id='open_to_all_prac_for_clinic_yn' value="<%=open_to_all_prac_for_clinic_yn%>">
<input type='hidden' name='pract_for_workDay_check' id='pract_for_workDay_check' value="">
<input type='hidden' name='episode_id' id='episode_id' value="<%=episode_id%>">
<input type='hidden' name='episode_visit_num' id='episode_visit_num' value="<%=episode_visit_num%>">
<input type='hidden' name='enable_rights_yn' id='enable_rights_yn' value="<%=enable_rights_yn%>">
<input type='hidden' name='pract_type1' id='pract_type1' value="<%=pract_type1%>">
<input type='hidden' name='sel_triage_yn' id='sel_triage_yn' value="<%=sel_triage_yn%>">
<input type='hidden' name='sel_cons_yn' id='sel_cons_yn' value="<%=sel_cons_yn%>">
<input type='hidden' name='brought_dead' id='brought_dead' value="<%=brought_dead%>">
<input type='hidden' name='min_age_for_lmp' id='min_age_for_lmp' value="<%=min_age_for_lmp%>">
<input type='hidden' name='year_value' id='year_value' value="<%=year_value%>">
<input type='hidden' name='isStartConsultationAppl' id='isStartConsultationAppl' value="<%=isStartConsultationAppl%>"><!--Added by Thamizh selvi on 10th Oct 2017 for ML-MMOH-CRF-0623-->

<!--Added by Ashwini on 10-May-2018 for ML-MMOH-CRF-1133-->
<input type='hidden' name='isEnableDateTimeAppl' id='isEnableDateTimeAppl' value="<%=isEnableDateTimeAppl%>">
<input type='hidden' name='visit_adm_date_time' id='visit_adm_date_time' value="<%=visit_adm_date_time%>">

</form>
<script>
	setFocusToFirstItem();
</script>
<!--Added by Rameswar on 08-Feb-16 for GDOH-CRF-081-->
<%if(isPracApplicable){%>
 <script>document.forms[0].practitioner_desc.onblur();</script>
 <%}%>
</center> 
<%	}
	catch(Exception e) 
	{
		e.printStackTrace();			
	}
	finally 
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>
</body>
</html> 
<%!
public static String checkForNull(String inputString)
{
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
}
%>

