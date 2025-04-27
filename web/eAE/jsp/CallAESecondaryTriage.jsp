<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat,eCommon.XSSRequestWrapper"   contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String functionid	 = request.getParameter("functionid");
%> 

  <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
  <script language='javascript' src='../../eCommon/js/common.js'></script>  
  <script language='javascript' src='../../eCommon/js/dchk.js'></script>
 <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
  <script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
  <script language='javascript' src='../../eAE/js/AESecondaryTriage.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>  
<body onKeyDown = 'lockKey()'>
<%!  
//Conversion
public String specialCharacter(String single){
				int i=0;
				
				
		if(( single.indexOf('\'', i)!=-1)){
			single=(String)single.replace('\'',' ');
		}
	

		return single ;
			
			}
%>
<%
    	Connection con				=	null;
		PreparedStatement pstmt		=	null;
		ResultSet rs				=	null;

		String patient_id=""; 
		String encounter_id="";
		String facility_id	 =(String)session.getValue("facility_id");
		String priority_zone="";
		String practitioner_name="";
		String open_to_all_pract_yn="";
		String patient_gender="";
		String assign_tmt_area_time="";
		String queue_status="";
		String triage_area="";
		String trauma_yn="";
		String clinic_code="";
		String clinic_type="";
		String queue_date="";
		String brought_dead="";
		String orig_tmt_area_code="";
		String treatment_area_code="";
		String practitioner_id="";
		String clinic_desc="";
		String treatment_area_desc="";
		String check_in_date_time="";
		String open_to_all_prac_for_clinic_yn="";
 //      String min_age_for_lmp="";
       String year_value="";
       String disaster_yn="";
       String speciality_code="";
//       String referral_id="";
		
		String sys_date_time="";
		String sys_date_time1="";
		String selection_mode="triage";
		String queryval="";
		String function_id ="";
		int queue_status1 =0;

		try{
			    request.setCharacterEncoding("UTF-8");
				request= new XSSRequestWrapper(request);
				response.addHeader("X-XSS-Protection", "1; mode=block");
				response.addHeader("X-Content-Type-Options", "nosniff");
				
				String locale			= (String)session.getAttribute("LOCALE");
  				con = ConnectionManager.getConnection(request);
				patient_id	 = request.getParameter("patient_id");				
				encounter_id	 = request.getParameter("episode_id");
				function_id	   = request.getParameter("function_id");
				String rec_date_time		= request.getParameter("rec_date_time");//IN050047
				if((function_id==null) || (function_id.equals("null")) || (function_id=="") || (function_id.equals("")))
	            function_id= ""; 
				StringBuffer sqlTri = new StringBuffer();
				
				String page_name=request.getParameter("page_name");	//Added by santhosh for ML-MMOH-SCF-2384

				/*Added by Thamizh selvi on 3rd July 2018 against MMS-DM-CRF-0115.1 Start*/
				String called_from = checkForNull(request.getParameter("called_from"));
				String RepDb	   = checkForNull(request.getParameter("RepDb"));
				String clob_data   = checkForNull(request.getParameter("clob_data"));
				if(called_from.equals("CDR"))
					facility_id	= checkForNull(request.getParameter("facility_id"));
				/*End*/
				
				sqlTri.append("SELECT ASSIGN_CARE_LOCN_CODE clinic_code,OP_GET_DESC.OP_CLINIC ##REPDB##(facility_id,ASSIGN_CARE_LOCN_CODE,'"+locale+"','1')  clinic_desc,ASSIGN_CARE_LOCN_TYPE clinic_type, treatment_area_code treatment_area_code,  AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC ##REPDB##(facility_id, ASSIGN_CARE_LOCN_CODE,treatment_area_code,'"+locale+"','2') treatment_area_desc,  triage_area ,open_to_all_pract_yn,attend_practitioner_id practitioner_id,  AM_GET_DESC.AM_PRACTITIONER ##REPDB##(attend_practitioner_id,'"+locale+"','2') practitioner_name , TO_CHAR(queue_date,'dd/mm/yyyy hh24:mi') queue_date_time,  TO_CHAR(check_in_date_time,'dd/mm/yyyy hh24:mi') check_in_date_time,  TO_CHAR(SYSDATE,'dd/mm/yyyy hh24:mi:ss') sys_date_time,  TO_CHAR(SYSDATE,'dd/mm/yyyy hh24:mi') sys_date_time1,   TO_CHAR(assign_tmt_area_time,'dd/mm/yyyy hh24:mi') assign_date,   queue_status,  trauma_yn, brought_dead_yn  brought_dead,  open_to_all_prac_for_clinic_yn  open_to_all_prac_for_clinic_yn, sex patient_gender, date_of_birth Year, priority_zone,referral_id, disaster_yn,speciality_code  FROM  ae_pr_encounter_vw ##REPDB## WHERE  facility_id = ? AND  encounter_id=? and patient_id=? ");

				/*Added by Thamizh selvi on 3rd July 2018 against MMS-DM-CRF-0115.1 Start*/
				String sqlFinal = sqlTri.toString();
				sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
				/*End*/
				pstmt =con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 3rd July 2018 against MMS-DM-CRF-0115.1
				pstmt.setString(1,facility_id);
				pstmt.setString(2,encounter_id);
				pstmt.setString(3,patient_id);
				rs=pstmt.executeQuery();
				if(rs != null && rs.next())
				{

					disaster_yn = rs.getString("disaster_yn") == null ? "" : rs.getString("disaster_yn") ;
					speciality_code = rs.getString("speciality_code") == null ? "" : rs.getString("speciality_code") ;
					clinic_code = rs.getString("clinic_code") == null ? "" : rs.getString("clinic_code") ;
					clinic_desc = rs.getString("clinic_desc") == null ?"" :rs.getString("clinic_desc") ;
					clinic_type = rs.getString("clinic_type") == null ? "" :rs.getString("clinic_type");
					//referral_id = rs.getString("referral_id") == null ? "" :rs.getString("referral_id");
					year_value = rs.getString("Year") == null ? "" :rs.getString("Year");
                    year_value	= year_value.substring(0,2);
					
					queue_status= rs.getString("queue_status") == null? "" :rs.getString("queue_status");

					triage_area=rs.getString("triage_area") == null? "" :rs.getString("triage_area");

					trauma_yn=rs.getString("trauma_yn") == null ? "" :rs.getString("trauma_yn");

					open_to_all_pract_yn=rs.getString("open_to_all_pract_yn") == null ?"" :rs.getString("open_to_all_pract_yn");

					queue_date=rs.getString("queue_date_time") == null ? "" :rs.getString("queue_date_time");

					assign_tmt_area_time=rs.getString("assign_date") == null ? "" :rs.getString("assign_date");

					brought_dead=rs.getString("brought_dead") == null ? "" :rs.getString("brought_dead");

					orig_tmt_area_code=rs.getString("treatment_area_code") == null ? "" :rs.getString("treatment_area_code");

					treatment_area_code=rs.getString("treatment_area_code") == null ? "" :rs.getString("treatment_area_code");

					treatment_area_desc=rs.getString("treatment_area_desc")== null ? "" :rs.getString("treatment_area_desc");

					practitioner_id=rs.getString("practitioner_id") == null ?"" :rs.getString("practitioner_id");

					practitioner_name=rs.getString("practitioner_name");

					open_to_all_prac_for_clinic_yn=rs.getString("open_to_all_prac_for_clinic_yn") == null ? "" :rs.getString("open_to_all_prac_for_clinic_yn");

					check_in_date_time=rs.getString("check_in_date_time") == null ? "" :rs.getString("check_in_date_time");

					sys_date_time=rs.getString("sys_date_time");
					sys_date_time1=rs.getString("sys_date_time1");

					patient_gender=rs.getString("patient_gender") == null ? "" :rs.getString("patient_gender");

					priority_zone=rs.getString("priority_zone") == null ? "" :rs.getString("priority_zone");	 			

				}	
/*
        pstmt			=	con.prepareStatement("select min_age_for_lmp from ae_param where operating_facility_id = ? ");
		pstmt.setString	(	1,	facility_id		);
		rs = pstmt.executeQuery();

		if(rs!= null &&  rs.next() )
		{
			min_age_for_lmp=rs.getString("min_age_for_lmp")==null?"":rs.getString("min_age_for_lmp");
		} 
		
  pstmt=	con.prepareStatement("select referral_id  from op_patient_queue where facility_id = ? and encounter_id= ? ");
		pstmt.setString	(	1,	encounter_id		);
		pstmt.setString	(	2,	facility_id		);
		rs = pstmt.executeQuery();

		if(rs!= null &&  rs.next() )
		{
			referral_id=rs.getString("referral_id")==null?"":rs.getString("referral_id");
		} 
		
*/



       if((practitioner_name==null) || (practitioner_name.equals("null")) || (practitioner_name=="") || (practitioner_name.equals("")))
	            practitioner_name= ""; 
queryval="selection_mode="+selection_mode+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&queue_status="+queue_status+"&triage_area="+triage_area+"&trauma_yn="+trauma_yn+"&open_to_all_pract_yn="+open_to_all_pract_yn+"&clinic_code="+clinic_code+"&clinic_type="+clinic_type+"&queue_date="+queue_date+"&assign_tmt_area_time="+java.net.URLEncoder.encode(assign_tmt_area_time)+"&brought_dead="+brought_dead+"&orig_tmt_area_code="+orig_tmt_area_code+"&treatment_area_code="+treatment_area_code+"&practitioner_id="+practitioner_id+"&clinic_desc="+specialCharacter(clinic_desc)+"&treatment_area_desc="+specialCharacter(treatment_area_desc)+"&open_to_all_prac_for_clinic_yn="+open_to_all_prac_for_clinic_yn+"&check_in_date_time="+java.net.URLEncoder.encode(check_in_date_time)+"&sys_date_time="+java.net.URLEncoder.encode(sys_date_time)+"&sys_date_time1="+java.net.URLEncoder.encode(sys_date_time1)+"&patient_gender="+patient_gender+"&year_value="+year_value+"&disaster_yn="+disaster_yn+"&practitioner_name="+specialCharacter(practitioner_name)+"&priority_zone="+priority_zone+"&called_from_ca=Y&function_id="+function_id+"&functionid="+functionid+"&speciality_code="+speciality_code+"&rec_date_time="+rec_date_time+"&clob_data="+clob_data+"&facility_id="+facility_id+"&called_from="+called_from+"&RepDb="+RepDb+"&page_name="+page_name;//IN050047 Added recorded date time



        if(rs!=null) rs.close();
		if(pstmt!=null)pstmt.close();
		if((sqlTri != null) && (sqlTri.length() > 0))
		{
			sqlTri.delete(0,sqlTri.length());
		}
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
	ConnectionManager.returnConnection(con,request);
	}
	if (!queue_status.equals(""))
    queue_status1 = Integer.parseInt( queue_status ) ;
   if ((queue_status1>=07) && (!function_id.equals("query")))
	{
		out.println("<script>alert(getMessage('AE_CHECKED_OUT','AE'));");
		out.println("location.href='../../eCommon/html/blank.html';</script>");
	}else
	{
		out.println("<script>");
		out.println("location.href='../../eAE/jsp/AETriageFrameset.jsp?"+queryval+" ' ");		
		out.println("</script>");
	}

out.println("</body>");
out.println("</html>");

%>
<%!
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equals("null"))) ? "" : inputString );
	}
%>

