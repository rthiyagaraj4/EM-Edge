<!DOCTYPE html>
<%@page import="java.util.*,java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  

<html>
<head> 
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eAE/js/AETriageDetails.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	 <script language='javascript' src='../../eCommon/js/DateUtils.js'> </script> 
<title><fmt:message key="eAE.SecondaryTriage.label" bundle="${ae_labels}"/></title>
</head>
<% 
        request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		
	    String locale			= (String)session.getAttribute("LOCALE");
 

		Connection con				=	null;
		PreparedStatement pstmt		=	null;
		ResultSet rs				=	null;
		String params		 = request.getQueryString() ;
		
		String strOpenToAllPract = "";
		String strOpenToallPractForClinic = "";
		String clinic_code = "";
		String clinic_type = ""; 
		String p_clinic_desc = "";
		String treatment_area_code = "";
		String orig_tmt_area_code = "";
		String practitioner_id = "";
		String speciality_code = "";
		String treatment_area_desc = "";
		String queue_status = "";		
        String modify_flag="N";
		String sys_date_time="";
		String sys_date_time1 ="";
		String facility_id	 =(String)session.getValue("facility_id");
		/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
		String called_from = checkForNull(request.getParameter("called_from"));
		String RepDb	   = checkForNull(request.getParameter("RepDb"));
		String clob_data   = checkForNull(request.getParameter("clob_data"));
		if(called_from.equals("CDR"))
			facility_id	= checkForNull(request.getParameter("facility_id"));
		params  = params+"&facility_id="+facility_id ;
		params  = params+"&called_from="+called_from ;
		params  = params+"&RepDb="+RepDb ;
		params  = params+"&clob_data="+clob_data ;
		/*End*/
		String encounter_id	 = checkForNull(request.getParameter("encounter_id"));
		String function_id	 = checkForNull(request.getParameter("function_id"));
		
		//11-11-2009 15198
		String functionid	 = checkForNull(request.getParameter("functionid"));	
		
		String page_name	 = checkForNull(request.getParameter("page_name"));//Added by santhosh for ML-MMOH-SCF-2384
		
		String referral_id="";
		if (function_id.equals("query"))
		{
		modify_flag="Y";
		params  = params+"&function_id="+function_id ;
		params  = params+"&modify_flag="+modify_flag ;
		}
		String priority_zone	 = checkForNull(request.getParameter("priority_zone"));
		String brought_dead	 = request.getParameter("brought_dead")==null?"N":request.getParameter("brought_dead");

		String strCA		 = request.getParameter("called_from_ca");
		if ((strCA==null) || strCA.equals("null"))
		 strCA = "";
		StringBuffer sqlTriage = new StringBuffer();
		sqlTriage.append("select a.locn_code, c.long_desc locn_desc, a.locn_type, a.treatment_area_code, AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC ##REPDB##(a.FACILITY_ID,a.LOCN_CODE,a.TREATMENT_AREA_CODE,'"+locale+"' ,'2') treatment_area_desc, c.open_to_all_pract_yn,a.practitioner_id,TO_CHAR(SYSDATE,'dd/mm/yyyy hh24:mi:ss') sys_date_time, TO_CHAR(SYSDATE,'dd/mm/yyyy hh24:mi') sys_date_time1,a.queue_status,NVL((CASE WHEN a.treatment_area_code IS NOT NULL THEN (SELECT open_to_all_prac_for_clinic_yn FROM  ae_tmt_area_for_clinic ##REPDB## WHERE facility_id = a.facility_id AND clinic_code = a.locn_code AND treatment_area_code = a.treatment_area_code) END ),'N') open_to_all_prac_for_clinic_yn ,REFERRAL_ID, a.speciality_code  from  ae_current_patient ##REPDB## a, op_clinic_lang_vw ##REPDB## c  where a.facility_id = ?  and a.encounter_id=?  and c.language_id = '"+locale+"'  and a.facility_id = c.facility_id and a.locn_code = c.clinic_code  ");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
		
		if(!strCA.equals("Y"))
		{
			if(encounter_id=="")
			{
				encounter_id = request.getParameter("episode_id");
				params  = params+"&encounter_id="+encounter_id ;
			}
			try{
	        con=ConnectionManager.getConnection(request);	
			/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
			String sqlFinal = sqlTriage.toString();
			sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
			/*End*/
		    pstmt		=	con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
			pstmt.setString	(	1,	facility_id		);
			pstmt.setString	(	2,	encounter_id		);
			rs			=	pstmt.executeQuery();

			while(rs.next())
			{
				strOpenToAllPract = checkForNull(rs.getString("open_to_all_pract_yn"));;
				params  = params+"&open_to_all_pract_yn="+strOpenToAllPract ;

				strOpenToallPractForClinic  =checkForNull( rs.getString("open_to_all_prac_for_clinic_yn"));
				params  = params+"&open_to_all_prac_for_clinic_yn="+strOpenToallPractForClinic ;


				clinic_code	=	checkForNull(rs.getString("locn_code"));	
				params = params+"&clinic_code="+clinic_code ;
				
				clinic_type			=	checkForNull(rs.getString("locn_type"));	
				params = params+"&clinic_type="+clinic_type ;

				p_clinic_desc			=	checkForNull(rs.getString("locn_desc"));	
				params = params+"&clinic_desc="+URLEncoder.encode(p_clinic_desc );

				orig_tmt_area_code  = checkForNull(rs.getString("treatment_area_code"));	
				params = params+"&orig_tmt_area_code="+orig_tmt_area_code ;

				treatment_area_code		=	checkForNull(rs.getString("treatment_area_code"));	
				params = params+"&treatment_area_code="+treatment_area_code ;
				
				treatment_area_desc		=	checkForNull(rs.getString("treatment_area_desc"));	
				params = params+"&treatment_area_desc="+treatment_area_desc  ;

				practitioner_id			=	checkForNull(rs.getString("practitioner_id"));
				params = params+"&practitioner_id="+practitioner_id ;

				speciality_code			=	checkForNull(rs.getString("speciality_code"));
				params = params+"&speciality_code="+speciality_code ;

				
              
				queue_status			=	checkForNull(rs.getString("queue_status"));	
				sys_date_time           =	checkForNull(rs.getString("sys_date_time"));
				sys_date_time1          =	checkForNull(rs.getString("sys_date_time1"));
				referral_id             =	checkForNull(rs.getString("referral_id"));
	 
				params = params+"&queue_status="+queue_status ;
				params  = params+"&priority_zone="+priority_zone ;
				params  = params+"&brought_dead="+brought_dead ;
				params  = params+"&sys_date_time="+sys_date_time ;
				params  = params+"&sys_date_time1="+sys_date_time1 ;
				params  = params+"&referral_id="+referral_id ;
			}
			if(rs!=null) rs.close();
			if(pstmt!=null)	pstmt.close();
			if((sqlTriage != null) && (sqlTriage.length() > 0))
					 {
						sqlTriage.delete(0,sqlTriage.length());
					 }
			}catch(Exception e1)
			{
				e1.printStackTrace();
			} 
			finally
			{
				ConnectionManager.returnConnection(con,request);
			}
		} 

  if(called_from.equals("CDR")){//Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
	%><frameset rows='1%,*,6%' ><%
  }else if(strCA .equals("Y")) 
	{
		if (function_id.equals("query"))
		{
		%>
           <frameset rows='8%,*,1%' >	
	    <%}else{
        %>
		   <frameset rows='0%,*,4%,5%' >
        <%
		}
	}
	else if (function_id.equals("query"))
	{
	%>
         <frameset rows='8%,*,6%' >	
	<%}	else {
    %>
		<frameset rows='8%,*,4%,5%' >	
    <%
	}	
%>
<!--Modified by Ashwini on 04-Apr-2017 for GDOH-CFR-0004.3-->
	<frame name='mainFrame' <% if(!called_from.equals("CDR")){ %> src="../../eCommon/jsp/pline.jsp?EncounterId=<%=encounter_id%>&Facility_Id=<%=facility_id%>" <% }else{ %> src="" <% } %> frameborder=0 scrolling='no' noresize>
	<frameset cols='19%,80%' > 
	   <frame name='view' src="../../eAE/jsp/ViewSecondaryTriage.jsp?<%=params%>&functionid=<%=functionid%>&page_name=<%=page_name%>" frameborder=0  noresize>
	   <frame name='f_query_add_mod' src='../../eAE/jsp/AESecondaryTriage.jsp?<%=params%>&call_function=TRIAGE' frameborder=0 scrolling='auto' noresize>
	</frameset>
	<%
	if (!function_id.equals("query") )
	{
	%>
	<frame name='TriageButtonsFrame' src='../../eAE/jsp/SecondaryTriageButtons.jsp?<%=params%>' frameborder=0 noresize scrolling='no'>
	<% }
	%>
	<frame name='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto'><!--Modified scrolling to 'auto' for ML-MMOH-CRF-0645 by Thamizh selvi-->
</frameset> 
<%!
	// To Handle java.lang.NullPointerException.
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equals(""))) ? "" : inputString );
	}
%>

</html>
