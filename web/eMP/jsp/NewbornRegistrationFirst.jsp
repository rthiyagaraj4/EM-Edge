<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% 
	request.setCharacterEncoding("UTF-8");
%>
<head>
	<script src='../../eMP/js/NewbornRegistration.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<html>
<%
	String Facility_Id = (String) session.getValue("facility_id");
	String motherid = request.getParameter("patient_id")==null?"": request.getParameter("patient_id");
	if(motherid==null)motherid="";
	String function_name 	= request.getParameter( "function_name" ) ;
	if ( function_name	== null ) function_name	= "" ;		
	String function_id = request.getParameter("function_id") ;
	if(function_id == null)function_id = "" ;
	String reviewnblinksbefregyn = "";
	String accessRights = request.getParameter("accessRights");
	if( accessRights == null) accessRights="";	
	String parent_details = request.getParameter("parent_details");
	if( parent_details == null) parent_details="";
	parent_details = java.net.URLEncoder.encode(parent_details);
	String function_invoked = request.getParameter("function_invoked");
	if( function_invoked == null) function_invoked="";
	String module_invoked = request.getParameter("module_invoked")==null?"":request.getParameter("module_invoked");
	String calling_module_id = request.getParameter("calling_module_id")==null?"":request.getParameter("calling_module_id");
	String called_from_mothercare = request.getParameter("called_from_mothercare")==null?"":request.getParameter("called_from_mothercare");
	String mother_nursing_unit = request.getParameter("mother_nursing_unit")==null?"":request.getParameter("mother_nursing_unit");
	String mother_bed_no = request.getParameter("mother_bed_no")==null?"":request.getParameter("mother_bed_no");	
	String mother_patient_id = request.getParameter("mother_patient_id")==null?"":request.getParameter("mother_patient_id");	
	String ca_encounter_id		= request.getParameter("ca_encounter_id") == null ? "" : request.getParameter("ca_encounter_id");

	String ipInstallYn = "";
	String siteId = "";
	String patIidLength = "";
	String nbPatSerGrp = "";
	String nbUseMotherSer = "";
	String invkAdmFrmNBYn = "";


	if (module_invoked.equals("IP")){
		function_id=""; //added to call baby links on first invocation from IP.
	}	
	
	if(mother_patient_id.equals("")){
		mother_patient_id=motherid;
	}
	
	Connection con = null;
	PreparedStatement pstmt	= null;
	ResultSet rset		= null;

	try{
		con = ConnectionManager.getConnection(request);
		//pstmt = con.prepareStatement(" select review_nb_links_bef_reg_yn from mp_param where module_id='MP' ");
		pstmt = con.prepareStatement(" select (select install_yn from sm_module where module_id = 'IP') ip_install_yn, (select site_id from sm_site_param) site_id, (select invoke_adm_from_newborn_yn from ip_param where facility_id = ? ) invkAdmFrmNBYn, review_nb_links_bef_reg_yn, patient_id_length, newborn_pat_ser_grp, nb_use_mother_ser from mp_param where module_id='MP' ");

		pstmt.setString(1,Facility_Id);
		rset = pstmt.executeQuery();

		if(rset!=null && rset.next()){

			ipInstallYn	= rset.getString("ip_install_yn") == null?"N":rset.getString("ip_install_yn");
			siteId	= rset.getString("site_id") == null?"":rset.getString("site_id");
			invkAdmFrmNBYn	= rset.getString("invkAdmFrmNBYn") == null?"N":rset.getString("invkAdmFrmNBYn");
			reviewnblinksbefregyn	= rset.getString("review_nb_links_bef_reg_yn") == null?"":rset.getString("review_nb_links_bef_reg_yn");
			patIidLength	= rset.getString("patient_id_length");
			nbPatSerGrp	= rset.getString("newborn_pat_ser_grp") == null?"":rset.getString("newborn_pat_ser_grp");
			nbUseMotherSer	= rset.getString("nb_use_mother_ser") == null?"":rset.getString("nb_use_mother_ser");
		}
	}catch(Exception e) { 
		out.println(e.toString());
		e.printStackTrace();
	}finally{
		if (pstmt != null) pstmt.close();
		if (rset != null) rset.close();
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
	if(function_id!=""){
	%>
		<script>
		</script>
	<%}
	if(reviewnblinksbefregyn.equals("N")){
	%>
		<script>
			var motherid = "<%=motherid%>";
			var function_id = "<%=function_id%>";
			self.location.href="../../eMP/jsp/NewbornRegistrationFrames.jsp?mother_id="+motherid+"&function_id="+function_id+"&accessRights=<%=accessRights%>&parent_details=<%=parent_details%>&function_invoked=<%=function_invoked%>&module_invoked=<%=module_invoked%>&mother_nursing_unit=<%=mother_nursing_unit%>&mother_bed_no=<%=mother_bed_no%>&function_name=<%=function_name%>&calling_module_id=<%=calling_module_id%>&called_from_mothercare=<%=called_from_mothercare%>&mother_patient_id=<%=mother_patient_id%>&ca_encounter_id=<%=ca_encounter_id%>&ipInstallYn=<%=ipInstallYn%>&siteId=<%=siteId%>&patIidLength=<%=patIidLength%>&nbPatSerGrp=<%=nbPatSerGrp%>&nbUseMotherSer=<%=nbUseMotherSer%>&invkAdmFrmNBYn=<%=invkAdmFrmNBYn%>";
		</script>
	<%
	}else{%>
		<script>
		
		newBornReg();
			
		async function newBornReg(){
			
			
			var retVal = 	new String();
			//var dialogHeight= "30" ;//30
			//var dialogWidth	= "49.8" ;//49.8
			var dialogHeight= '400px' ;
			var dialogWidth	= '700px' ;
			var status = "no";
			var arguments	= "" ;
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; scroll=no; status:" + status;
			var motherid = "<%=motherid%>";
			var function_id = "<%=function_id%>";
			var module_invoked = "<%=module_invoked%>";
			if(function_id==""){
				//alert("inside function9");
				retVal = await window.showModalDialog("../../eMP/jsp/PaintNewbornMotherBabyLink.jsp?accessRights=<%=accessRights%>&calling_module_id=<%=calling_module_id%>&mother_id=<%=motherid%>&ipInstallYn=<%=ipInstallYn%>",arguments,features);if(retVal != null){
					var arr = retVal.split('`');
					if(arr[1] == 'N'){
					//	alert("inside function10");
						alert(parent.frames[1].getMessage('NO_MOTHER_BABY_LINKS','MP'));		
						self.location.href="../../eMP/jsp/NewbornRegistrationFrames.jsp?mother_id="+arr[0]+"&function_id="+function_id+"&accessRights=<%=accessRights%>&parent_details=<%=parent_details%>&function_invoked=<%=function_invoked%>&module_invoked=<%=module_invoked%>&mother_nursing_unit=<%=mother_nursing_unit%>&mother_bed_no=<%=mother_bed_no%>&function_name=<%=function_name%>&calling_module_id=<%=calling_module_id%>&called_from_mothercare=<%=called_from_mothercare%>&mother_patient_id=<%=mother_patient_id%>&ca_encounter_id=<%=ca_encounter_id%>&ipInstallYn=<%=ipInstallYn%>&siteId=<%=siteId%>&patIidLength=<%=patIidLength%>&nbPatSerGrp=<%=nbPatSerGrp%>&nbUseMotherSer=<%=nbUseMotherSer%>&invkAdmFrmNBYn=<%=invkAdmFrmNBYn%>" ;
					}else if(arr[1] == 'C'){ 
					//alert("inside function11");
						if (module_invoked != "IP") {
						create();
						} 
					}else {	
					//alert("inside function12");
					self.location.href="../../eMP/jsp/NewbornRegistrationFrames.jsp?mother_id="+arr[0]+"&function_id="+function_id+"&accessRights=<%=accessRights%>&parent_details=<%=parent_details%>&function_invoked=<%=function_invoked%>&module_invoked=<%=module_invoked%>&mother_nursing_unit=<%=mother_nursing_unit%>&mother_bed_no=<%=mother_bed_no%>&function_name=<%=function_name%>&calling_module_id=<%=calling_module_id%>&called_from_mothercare=<%=called_from_mothercare%>&mother_patient_id=<%=mother_patient_id%>&ca_encounter_id=<%=ca_encounter_id%>&ipInstallYn=<%=ipInstallYn%>&siteId=<%=siteId%>&patIidLength=<%=patIidLength%>&nbPatSerGrp=<%=nbPatSerGrp%>&nbUseMotherSer=<%=nbUseMotherSer%>&invkAdmFrmNBYn=<%=invkAdmFrmNBYn%>" ;
					}
				}
			}else{
				self.location.href="../../eMP/jsp/NewbornRegistrationFrames.jsp?mother_id="+motherid+"&function_id="+function_id+"&accessRights=<%=accessRights%>&parent_details=<%=parent_details%>&function_invoked=<%=function_invoked%>&module_invoked=<%=module_invoked%>&mother_nursing_unit=<%=mother_nursing_unit%>&mother_bed_no=<%=mother_bed_no%>&function_name=<%=function_name%>&calling_module_id=<%=calling_module_id%>&called_from_mothercare=<%=called_from_mothercare%>&mother_patient_id=<%=mother_patient_id%>&ca_encounter_id=<%=ca_encounter_id%>&ipInstallYn=<%=ipInstallYn%>&siteId=<%=siteId%>&patIidLength=<%=patIidLength%>&nbPatSerGrp=<%=nbPatSerGrp%>&nbUseMotherSer=<%=nbUseMotherSer%>&invkAdmFrmNBYn=<%=invkAdmFrmNBYn%>" ;			
				}
		}
		</script>
	<%
	}
%>
</html>

