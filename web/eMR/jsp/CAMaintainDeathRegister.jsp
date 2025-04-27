<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,com.ehis.util.*,webbeans.eCommon.*,java.util.StringTokenizer,java.util.TreeMap" %>
<% request.setCharacterEncoding("UTF-8"); 
//String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
%>
<html>
	<head>
		<title> <fmt:message key="eMR.MaintainDeathRegister.label" bundle="${mr_labels}"/></title>
		<script language='javascript' src='../../eCommon/js/dchk.js' ></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
	</head>
<script>
async function call_death_reg(encid, patid, practId, pat_class, spclty_code, sex, dob, pract_type,  pat_curr_locn_code,finalize_yn,visit_adm_date)
		{
			var dialogHeight="42vh";
			var dialogWidth="80vw";
			var dialogTop="100";
			var center = "1" ;
			var status="no";
			var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
			var arguments	= "" ;
			var action_url="../../eMR/jsp/DeathRegisterFrames.jsp?cause_of_death=Y&modal_yn=Y&Locn_Code="+pat_curr_locn_code+"&Sex="+sex+"&Dob="+dob+"&speciality_code="+spclty_code+"&patient_id="+patid+"&encounter_id="+encid+"&episode_id="+encid+"&practitioner_id="+practId+"&practitioner_type="+pract_type+"&patient_class="+pat_class+"&call_from=MAINTAIN_DEATH_REGISTER&episode_type=I&finalize_yn="+finalize_yn+"&visit_adm_date="+visit_adm_date;
		var title="";
		var retVal=await window.showModalDialog(action_url,title,features);
		if(retVal==undefined){
			var xmlHttp = new XMLHttpRequest();
			xmlHttp.open("POST","../../eMR/jsp/DearthRegisterValidation.jsp?mode=RemoveSessionVals",false);
			xmlHttp.send(null);		
			responseText=xmlHttp.responseText;
		}
			parent.frames[2].location.reload();
}
</script>
<%

String patient_id				=	checkForNull(request.getParameter("patient_id"));
String encounter_id			=	checkForNull(request.getParameter("encounter_id"));
String locn_code				=	checkForNull(request.getParameter("location_code"));
String gender	 					=	checkForNull(request.getParameter("Sex"));
String dob							=	checkForNull(	request.getParameter("Dob"));
String speciality_code		=	checkForNull(request.getParameter("speciality_code"));
String episode_id				=	checkForNull(request.getParameter("episode_id"));
String patient_class			=	checkForNull(request.getParameter("patient_class"));
String visit_adm_date		=	checkForNull(request.getParameter("visit_adm_date"));

String practitioner_id			=	checkForNull(request.getParameter("practitioner_id"));
String finalize_yn				=	checkForNull(request.getParameter("finalize_yn"));


Connection conn=null;
PreparedStatement pstmt=null;
ResultSet rs=null;

	String facilityId		= ((String)session.getValue("facility_id"));


try{

	conn=ConnectionManager.getConnection(request);

	session.removeAttribute("combined_map");
	session.removeAttribute("diag_dates_map");


	pstmt=conn.prepareStatement("select ATTEND_PRACTITIONER_ID,finalize_yn from mr_death_register_hdr  where encounter_id='"+encounter_id+"' and facility_id='"+facilityId+"'");
	rs=pstmt.executeQuery();

	if(rs.next()){
		practitioner_id=rs.getString("ATTEND_PRACTITIONER_ID");
		finalize_yn=rs.getString("finalize_yn");


		%>
				<!-- <frameset rows="100%">
					<frame name='CA_Death_Register_Frame' id='CA_Death_Register_Frame' src="../../eMR/jsp/DeathRegisterFrames.jsp?patient_id=<%=patient_id%>&encounter_id=<%=encounter_id%>&locn_code=<%=locn_code%>&gender=<%=gender%>&dob=<%=dob%>&speciality_code=<%=speciality_code%>&episode_id=<%=episode_id%>&practitioner_id=<%=practitioner_id%>&practitioner_type=&patient_class=<%=patient_class%>&call_from='CA'&episode_type=&mode=&finalize_yn=<%=finalize_yn%>&visit_adm_date=<%=visit_adm_date%>" frameborder='0' noresize scrolling='NO'>
					</frame>
				</frameset> -->
			<script>
				call_death_reg('<%=encounter_id%>','<%=patient_id%>','<%=practitioner_id%>','<%=patient_class%>','<%=speciality_code%>','<%=gender%>','<%=dob%>','','','<%=finalize_yn%>','<%=visit_adm_date%>');
			</script>
	<%}else{%>
	<script>
//		alert("APP-MR0137 Maintain Death Register is not applicable for this encounter.");
		var err_msg=getMessage("MR_MDR_NOT_APPLICABLE","MR")
		alert(err_msg)
	</script>
<%}
}catch(Exception ex){
	ex.printStackTrace();
}finally{
		ConnectionManager.returnConnection(conn,request);
}%>
<%!
	public static String checkForNull(String inputString){
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue){
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

