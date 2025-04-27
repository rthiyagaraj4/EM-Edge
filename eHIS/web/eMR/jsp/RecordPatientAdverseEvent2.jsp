<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*" %>
<%@ page language="java"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
	<head>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
		<script src="../../eCommon/js/messages.js"></script>
	   <script src="../../eMR/js/RecordPatientAdverseEvent.js"></script>
	</head>
<style>
textarea {
  resize: none;
}
</style>	

	<%
	String sPhInstalled_YN = "N";
	String PatientId=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String Encounter_Id=request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");

	String Pract_id=request.getParameter("Pract_id")==null?"":request.getParameter("Pract_id");
	String practitioner_type=request.getParameter("practitioner_type")==null?"":request.getParameter("practitioner_type");
	String patient_class=request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
	String Dob=request.getParameter("Dob")==null?"":request.getParameter("Dob");
	String CA=request.getParameter("CA")==null?"":request.getParameter("CA");
	String Locn_Code=request.getParameter("Locn_Code")==null?"":request.getParameter("Locn_Code");
	if(Locn_Code.equals(""))
		Locn_Code				= checkForNull(request.getParameter("location_code"));
	String location_type			= checkForNull(request.getParameter("location_type"));   
		if(location_type.equals("")) location_type="C";
	String speciality_code		= checkForNull(request.getParameter("speciality_code"));
	String p_called_from_widget = request.getParameter("p_called_from_widget")==null?"":(String)request.getParameter("p_called_from_widget"); //CHL-CRF- 0008 - IN:001472 
     /*Below line added for this CRF Bru-HIMS-CRF-133*/	
      String isPatientEncMovement=request.getParameter("isPatientEncMovement")==null?"":request.getParameter("isPatientEncMovement");
      String Sydate=request.getParameter("Sydate")==null?"":request.getParameter("Sydate");
      String p_queue_date=request.getParameter("p_queue_date")==null?"":request.getParameter("p_queue_date");
      String p_queue_status=request.getParameter("p_queue_status")==null?"":request.getParameter("p_queue_status");
	  //End this CRF Bru-HIMS-CRF-133
	//10/23/2008 codenaddded by anjaneya reddy  10:03 AM
	session.removeAttribute("DETAILS_CODE");
	
	Connection con = ConnectionManager.getConnection(request);
	  ResultSet rs = null;
	  Statement stmt = con.createStatement();
	  PreparedStatement pstmt = null;
	  String allergy_conf_reqd_yn="";
	  try{
		  String sql="SELECT allergy_conf_reqd_yn FROM mr_parameter";
		  
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				allergy_conf_reqd_yn=checkForNull(rs.getString("allergy_conf_reqd_yn"),"N");
			}
			
			//Added against TTM-SCF-0107 - start
			String facility_id = (String)session.getAttribute("facility_id");
			String sql_phExists = "select decode(count(*),0,'N','Y') PH_INSTALLED_YN from SM_MODULES_FACILITY where module_id='PH' and facility_id='"+facility_id+"' and OPERATIONAL_YN='Y'";
			
			pstmt=con.prepareStatement(sql_phExists); 
			rs=pstmt.executeQuery();
			while(rs.next())
			{			
				sPhInstalled_YN=rs.getString("PH_INSTALLED_YN");
			}System.err.println("sPhInstalled_YN..."+sPhInstalled_YN);
			//passing this parameter -sPhInstalled_YN in the below frames - RecordPatientAdverseEventsearch.jsp and RecordPatientAdverseEvent5.jsp
			//Added against TTM-SCF-0107 - end
			
	  }catch(Exception e){
		  e.printStackTrace();
	  }finally{
		  if (stmt != null) stmt.close();
			if (rs != null) rs.close();
			if(con!=null) ConnectionManager.returnConnection(con,request);
	  }
	
	String disable_event_type="";
	String disable_known_allergy="";
	if(allergy_conf_reqd_yn.equals("Y")){
		disable_event_type="disabled";
		disable_known_allergy="disabled";
	}

	%>
	<title><%=checkForNull(request.getParameter("title"))%></title>
<!-- <body onLoad="clear_session()" OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()' >   -->

<!--<frameset id ='allergy_recording' rows='18%,30%,45%,25%,5%,0%,5%' >-->
<%if(CA.equals("Y") && "".equals(p_called_from_widget)) //CHL-CRF- 0008 - IN:001472
{%><frameset id ='allergy_recording' rows='8%,6%,1%,11%,5%,0%,5%' >
<%}else{%>
<!--<frameset id ='allergy_recording' rows='8%,8%,1%,8%,5%,0%,5%,2%' >-->
<frameset id ='allergy_recording' rows='15%,6%,1%,11%,5%,0%,5%,2%' >  
<%}%>
	<frame scrolling='no' name='resultpage' src='../../eMR/jsp/RecordPatientAdverseEventsearch.jsp?CA=<%=CA%>&PatientId=<%=PatientId%>&Encounter_Id=<%=Encounter_Id%>&Pract_id=<%=Pract_id%>&practitioner_type=<%=practitioner_type%>&patient_class=<%=patient_class%>&allergy_conf_reqd_yn=<%=allergy_conf_reqd_yn%>&sPhInstalled_YN=<%=sPhInstalled_YN%>' noresize frameborder=0 >
	<frame scrolling='auto' name='resultpage' src='../../eMR/jsp/RecordPatientAdverseEvent4.jsp?norecord=noreords&status_val=A&modeResult=result&PatientId=<%=PatientId%>&Encounter_Id=<%=Encounter_Id%>&Pract_id=<%=Pract_id%>&practitioner_type=<%=practitioner_type%>&patient_class=<%=patient_class%>&sPhInstalled_YN=<%=sPhInstalled_YN%>' noresize frameborder=0 >
	<frame scrolling='no' name='staticcolorpage' src='../../eMR/jsp/RecordPatientAdverseEvent7.jsp?PatientId=<%=PatientId%>&Encounter_Id=<%=Encounter_Id%>&Pract_id=<%=Pract_id%>&practitioner_type=<%=practitioner_type%>&patient_class=<%=patient_class%>' noresize frameborder=0 > 
	<!-- Below lines scrolling added by venkatesh.S against ML-MMOH-CRF-0366 -->
	<frame scrolling='auto' name='Headerpage' src='../../eMR/jsp/RecordPatientAdverseEvent5.jsp?PatientId=<%=PatientId%>&Encounter_Id=<%=Encounter_Id%>&Pract_id=<%=Pract_id%>&practitioner_type=<%=practitioner_type%>&patient_class=<%=patient_class%>&Dob=<%=Dob%>&Locn_Code=<%=Locn_Code%>&location_type=<%=location_type%>&speciality_code=<%=speciality_code%>&disable_event_type=<%=disable_event_type%>&allergy_conf_reqd_yn=<%=allergy_conf_reqd_yn%>&disable_known_allergy=<%=disable_known_allergy%>&isPatientEncMovement=<%=isPatientEncMovement%>&Sydate=<%=Sydate%>&p_queue_date=<%=p_queue_date%>&p_queue_status=<%=p_queue_status%>&sPhInstalled_YN=<%=sPhInstalled_YN%>'  noresize frameborder=0 >
	<frame  id='reaction_details_page' scrolling="auto" name='reaction_view'  src='../../eMR/jsp/RecordPatientAdverseEvent13.jsp?PatientId=<%=PatientId%>&Encounter_Id=<%=Encounter_Id%>&Pract_id=<%=Pract_id%>&practitioner_type=<%=practitioner_type%>&patient_class=<%=patient_class%>&allergy_conf_reqd_yn=<%=allergy_conf_reqd_yn%>&isPatientEncMovement=<%=isPatientEncMovement%>&Sydate=<%=Sydate%>&p_queue_date=<%=p_queue_date%>&p_queue_status=<%=p_queue_status%>'  noresize frameborder=0> 
	<frame scrolling="no" name='detail_view' src='../../eMR/jsp/RecordPatientAdverseEvent6.jsp?PatientId=<%=PatientId%>&Encounter_Id=<%=Encounter_Id%>&Pract_id=<%=Pract_id%>&practitioner_type=<%=practitioner_type%>&patient_class=<%=patient_class%>'  noresize frameborder=0> 
	<frame name='submitframe'  src='../../eMR/jsp/RecordPatientAdverseEvent9.jsp?p_called_from_widget=<%=p_called_from_widget%>'  frameborder=0 noresize scrolling='no'> <!-- CHL-CRF- 0008 - IN:001472 -- >
	<!--Above line modified for this CRF Bru-HIMs-CRF-133 -->
	<%if(!(CA.equals("Y")) || !"".equals(p_called_from_widget)){ //CHL-CRF- 0008 - IN:001472%>
	<frame name='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='no'>
	<%}%>
	</frameset>

</body>	
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
