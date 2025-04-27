<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,com.ehis.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String FacilityId		= (String) session.getValue( "facility_id" ) ;
	String loginUser = (String)session.getValue("login_user");
	String locale	= (String) session.getAttribute("LOCALE");
	String sql ;
	String PatientId		=	request.getParameter("PatientId") ;
	//String AdmissionDate	=	request.getParameter("AdmissionDate") ;
	String Admission_From_Date	=	request.getParameter("admission_from_date") ;
	String Admission_To_Date	=	request.getParameter("admission_to_date") ;
	String EncounterId		=	request.getParameter("EncounterId") ;
	//String DischargeDate	=	request.getParameter("DischargeDate") ;
	String Discharge_From_Date	=	request.getParameter("discharge_from_date") ;
	String Discharge_To_Date	=	request.getParameter("discharge_to_date") ;
	
	String deceased_from_date	=	request.getParameter("deceased_from_date") ;
	String deceased_to_date	=	request.getParameter("deceased_to_date") ;
	String status	=	request.getParameter("status") ;
	String discharged_yn = "";


	


	if(PatientId	== null || PatientId.equals("null"))		PatientId = "";
	if(EncounterId	== null || EncounterId.equals("null"))		EncounterId = "";
	//if(AdmissionDate == null || AdmissionDate.equals("null"))	AdmissionDate = "";
	//if(DischargeDate	== null || DischargeDate.equals("null"))DischargeDate = "";
	if(Admission_From_Date == null || Admission_From_Date.equals("null"))	Admission_From_Date = "";
	if(Admission_To_Date	== null || Admission_To_Date.equals("null"))	Admission_To_Date = "";
	if(Discharge_From_Date == null || Discharge_From_Date.equals("null"))	Discharge_From_Date = "";
	if(Discharge_To_Date	== null || Discharge_To_Date.equals("null"))	Discharge_To_Date = "";

	if(deceased_from_date == null || deceased_from_date.equals("null"))	deceased_from_date = "";
	if(deceased_to_date	== null || deceased_to_date.equals("null"))	deceased_to_date = "";
	if(status	== null || status.equals("null"))	status = "";


	String whereClause = request.getParameter("whereclause");
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	if(whereClause	== null || whereClause.equals("null"))	whereClause = "";
	int start = 0 ;
	int end = 0 ;
    int i=1;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
		end = 20 ;
	else
		end = Integer.parseInt( to ) ;

	PreparedStatement pstmt		= null;
	ResultSet rs				= null;
	Connection conn = ConnectionManager.getConnection(request);	
try {
	%>
<HTML>
<head>
	<script src="../../eOP/js/menu.js" language="JavaScript1.2"></script>
	<script src="../../eOA/js/QueryLocnForDay.js"></script>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script language='javascript' src="../../eMR/js/CreatePatientFile.js"></script>
	<script>
		/*function call_death_reg(encid, patid, practId, pat_class, spclty_code, sex, dob, pract_type,  pat_curr_locn_code)
		{
			
			/*var dialogHeight= "41";
			var dialogWidth = "65";
			var dialogTop	= "72";
			var center = "1" ;
			var status="no";
			var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
			var arguments	= "" ;
			retVal = 	
			//window.showModalDialog("../../eMR/jsp/PaintDeathRegisterPatient.jsp?Patient_Id="+patid+"&encounter_id="+encid+"&practitioner_id="+practId+"&call_from=MAINTAIN_DEATH_REGISTER",arguments,features);
			window.open("../../eMR/jsp/RecDiagnosis.jsp?cause_of_death=Y&modal_yn=Y&Locn_Code="+pat_curr_locn_code+"&Sex="+sex+"&Dob="+dob+"&speciality_code="+spclty_code+"&patient_id="+patid+"&encounter_id="+encid+"&episode_id="+encid+"&practitioner_id="+practId+"&practitioner_type="+pract_type+"&patient_class="+pat_class+"&call_from=MAINTAIN_DEATH_REGISTER&episode_type=I",arguments,features);
			*/

			/*var dialogHeight="41";
			var dialogWidth="65";
			var dialogTop="72";
			var center = "1" ;
			var status="no";
			var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
			var arguments	= "" ;
			var bodwidth  = window.screen.width+window.screen.width;
	        var	bodheight = window.screen.height+window.screen.height;

			var action_url="../../eMR/jsp/RecDiagnosis.jsp?cause_of_death=Y&modal_yn=Y&Locn_Code="+pat_curr_locn_code+"&Sex="+sex+"&Dob="+dob+"&speciality_code="+spclty_code+"&patient_id="+patid+"&encounter_id="+encid+"&episode_id="+encid+"&practitioner_id="+practId+"&practitioner_type="+pract_type+"&patient_class="+pat_class+"&call_from=MAINTAIN_DEATH_REGISTER&episode_type=I";


	var title="";

	window.open(action_url,title,"height="+bodheight+",width="+bodwidth+",top=0,status=0,toolbar=no,menubar=no,location=no,left=0,right=0,bottom=0,this.minimise=no");
		
			parent.frames[2].location.href="../../eMR/jsp/DeathRegisterResult.jsp?PatientId="+'<%=PatientId%>'+"&EncounterId="+'<%=EncounterId%>'+"&admission_from_date="+'<%=Admission_From_Date%>'+"&admission_to_date="+'<%=Admission_To_Date%>'+"&discharge_from_date="+'<%=Discharge_From_Date%>'+"&discharge_to_date="+'<%=Discharge_To_Date%>';
		}*/
		async function call_death_reg(encid, patid, practId, pat_class, spclty_code, sex, dob, pract_type,  pat_curr_locn_code,finalize_yn,visit_adm_date)
		{
			/*var dialogHeight= "41";
			var dialogWidth = "65";
			var dialogTop	= "72";
			var center = "1" ;
			var status="no";
			var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
			var arguments	= "" ;
			retVal = 	
			//window.showModalDialog("../../eMR/jsp/PaintDeathRegisterPatient.jsp?Patient_Id="+patid+"&encounter_id="+encid+"&practitioner_id="+practId+"&call_from=MAINTAIN_DEATH_REGISTER",arguments,features);
			window.open("../../eMR/jsp/RecDiagnosis.jsp?cause_of_death=Y&modal_yn=Y&Locn_Code="+pat_curr_locn_code+"&Sex="+sex+"&Dob="+dob+"&speciality_code="+spclty_code+"&patient_id="+patid+"&encounter_id="+encid+"&episode_id="+encid+"&practitioner_id="+practId+"&practitioner_type="+pract_type+"&patient_class="+pat_class+"&call_from=MAINTAIN_DEATH_REGISTER&episode_type=I",arguments,features);
			*/

			var dialogHeight="1000px";
			var dialogWidth="1650px";
			var dialogTop="100";
			var center = "1" ;
			var status="no";
			var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
			var arguments	= "" ;
//			var bodwidth  = window.screen.width+window.screen.width;
//	        var	bodheight = window.screen.height+window.screen.height;

//			var action_url="../../eMR/jsp/RecDiagnosis.jsp?cause_of_death=Y&modal_yn=Y&Locn_Code="+pat_curr_locn_code+"&Sex="+sex+"&Dob="+dob+"&speciality_code="+spclty_code+"&patient_id="+patid+"&encounter_id="+encid+"&episode_id="+encid+"&practitioner_id="+practId+"&practitioner_type="+pract_type+"&patient_class="+pat_class+"&call_from=MAINTAIN_DEATH_REGISTER&episode_type=I";
			var action_url="../../eMR/jsp/DeathRegisterFrames.jsp?cause_of_death=Y&modal_yn=Y&Locn_Code="+pat_curr_locn_code+"&Sex="+sex+"&Dob="+dob+"&speciality_code="+spclty_code+"&patient_id="+patid+"&encounter_id="+encid+"&episode_id="+encid+"&practitioner_id="+practId+"&practitioner_type="+pract_type+"&patient_class="+pat_class+"&call_from=MAINTAIN_DEATH_REGISTER&episode_type=I&finalize_yn="+finalize_yn+"&visit_adm_date="+visit_adm_date;
		var title="";
		var retVal=await top.window.showModalDialog(action_url,title,features);
		if(retVal==undefined){
			var xmlHttp 	= new XMLHttpRequest();
			xmlHttp.open("POST","../../eMR/jsp/DearthRegisterValidation.jsp?mode=RemoveSessionVals",false);
			xmlHttp.send(null);		
			responseText=xmlHttp.responseText;
	}
			parent.frames[2].location.reload();
				//parent.frames[2].location.href="../../eMR/jsp/DeathRegisterResult.jsp?PatientId="+'<%=PatientId%>'+"&EncounterId="+'<%=EncounterId%>'+"&admission_from_date="+'<%=Admission_From_Date%>'+"&admission_to_date="+'<%=Admission_To_Date%>'+"&discharge_from_date="+'<%=Discharge_From_Date%>'+"&discharge_to_date="+'<%=Discharge_To_Date%>'+"&deceased_from_date="+'<%=deceased_to_date%>'+"&deceased_to_date="+'<%=deceased_to_date%>'+"&status="+'<%=status%>';
}

		async function modify_death_date(encid, patid,deceasedDate,dischargeDate,admissionDate,admission_type,pract_id,remarks)
		{
			
			var dialogHeight= "25vh";
			var dialogWidth = "50vw";
			var dialogTop	= "center";
			var center = "1" ;
			var status="no";
			var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
			var arguments	= "" ;
			
			//alert("admission_type:"+admission_type);
			//alert("pract_name:"+pract_name)
			retVal = 	
		
			//window.showModalDialog("../../eMR/jsp/AddModifyDeceasedDetailsFrame.jsp?patient_id="+patid+"&encounter_id="+encid+"&deceaseddate="+deceasedDate+"&dischargeDate="+dischargeDate+"&admissionDate="+admissionDate+"&admission_type="+unescape(admission_type)+"&pract_id="+pract_id+"&pract_name="+pract_name+"&remarks="+remarks+"&call_from=MODIFY_DEATH_DETAILS&episode_type=I",arguments,features);
			//window.showModalDialog("../../eMR/jsp/AddModifyDeceasedDetailsFrame.jsp?patient_id="+patid+"&encounter_id="+encid+"&deceaseddate="+deceasedDate+"&dischargeDate="+dischargeDate+"&admissionDate="+admissionDate+"&admission_type="+encodeURIComponent(admission_type)+"&pract_id="+pract_id+"&pract_name="+encodeURIComponent(pract_name)+"&remarks="+encodeURIComponent(remarks)+"&call_from=MODIFY_DEATH_DETAILS&episode_type=I",arguments,features);

			await window.showModalDialog("../../eMR/jsp/AddModifyDeceasedDetailsFrame.jsp?patient_id="+patid+"&encounter_id="+encid+"&deceaseddate="+deceasedDate+"&dischargeDate="+dischargeDate+"&admissionDate="+admissionDate+"&admission_type="+encodeURIComponent(admission_type)+"&pract_id="+pract_id+"&remarks="+encodeURIComponent(remarks)+"&call_from=MODIFY_DEATH_DETAILS&episode_type=I",arguments,features);
		
			parent.frames[2].location.href="../../eMR/jsp/DeathRegisterResult.jsp?PatientId="+'<%=PatientId%>'+"&EncounterId="+'<%=EncounterId%>'+"&admission_from_date="+'<%=Admission_From_Date%>'+"&admission_to_date="+'<%=Admission_To_Date%>'+"&discharge_from_date="+'<%=Discharge_From_Date%>'+"&discharge_to_date="+'<%=Discharge_To_Date%>'+"&deceased_from_date="+'<%=deceased_to_date%>'+"&deceased_to_date="+'<%=deceased_to_date%>'+"&status="+'<%=status%>';
		}
	</script>
</head>
<body OnMouseDown='CodeArrest();' onKeyDown='lockKey()'>
<form name='DeathRegisterResult' id='DeathRegisterResult'   method="post"  target ="messageFrame">
<%

		StringBuffer aesql = new StringBuffer();
		String oper_stn_id = "";
		
		aesql.append(" select oper_stn_id from am_user_for_oper_stn ");
		  aesql.append(" where appl_user_id= ? ");
		  aesql.append(" and facility_id=  ? ");
		
		  pstmt = conn.prepareStatement(aesql.toString());
		  pstmt.setString(1, loginUser);
		  pstmt.setString(2, FacilityId);

		  rs = pstmt.executeQuery();
		  if(rs.next())
			oper_stn_id=rs.getString(1);

		  if(rs!=null)rs.close();
		  if(pstmt!=null)pstmt.close();
		  if((aesql != null) && (aesql.length() > 0))
			{
				aesql.delete(0,aesql.length());
			} 


	StringBuffer Where = new StringBuffer();

	//Where.append(" where b.patient_id  = a.patient_id  and a.encounter_id = c.encounter_id  and a.facility_id = ? and a.patient_id = nvl(?,a.patient_id) and a.encounter_id = nvl(?,a.encounter_id) and trunc(visit_adm_date_time)=nvl(to_date(?,'dd/mm/yyyy'),trunc(visit_adm_date_time)) and trunc(discharge_date_time)=nvl(to_date(?,'dd/mm/yyyy'),trunc(discharge_date_time)) and nvl(c.finalize_yn,'N')='N' ");

	//Where.append(" where b.patient_id  = a.patient_id  and a.encounter_id = c.encounter_id  and a.facility_id = ? and a.facility_id =c.facility_id and d.practitioner_id = a.attend_practitioner_id and d.pract_type = e.pract_type and a.patient_id = nvl(?,a.patient_id) and a.encounter_id = nvl(?,a.encounter_id) and trunc(visit_adm_date_time)>=nvl(to_date(?,'dd/mm/yyyy'),trunc(visit_adm_date_time)) and trunc(discharge_date_time)<=nvl(to_date(?,'dd/mm/yyyy'),trunc(discharge_date_time)) and nvl(c.finalize_yn,'N')='N' ");

	Where.append(" where b.patient_id  = a.patient_id  and a.encounter_id = c.encounter_id  and a.facility_id = ? and a.facility_id =c.facility_id  ");

	//9/14/2009
	Where.append(" AND (a.facility_id,a.assign_care_locn_type,a.assign_care_locn_code) in (select facility_id, locn_type, locn_code from AM_OS_USER_LOCN_ACCESS_VW where facility_id ='"+FacilityId+"' and oper_stn_id ='"+oper_stn_id+"' and appl_user_id = '"+loginUser+"' and MAINTAIN_DEATH_REGISTER_YN = 'Y')   ");

	if(!PatientId.equals(""))
		Where.append(" and a.patient_id like '"+PatientId+"' ");

	//and a.patient_id = nvl(?,a.patient_id) and a.encounter_id = nvl(?,a.encounter_id) ");

	if(!Admission_From_Date.equals("") && !Admission_To_Date.equals(""))		
		Where.append(" and trunc(a.visit_adm_date_time) between to_date(?,'dd/mm/yyyy') and to_date(?,'dd/mm/yyyy') ");
	
	if(!Discharge_From_Date.equals("") && !Discharge_To_Date.equals(""))	
		Where.append(" and trunc(a.discharge_date_time) between to_date(?,'dd/mm/yyyy') and to_date(?,'dd/mm/yyyy') ");

	if(!deceased_from_date.equals("") && !deceased_to_date.equals(""))	
		Where.append(" and trunc(c.death_date_time) between to_date(?,'dd/mm/yyyy') and to_date(?,'dd/mm/yyyy') ");

	if(!status.equals(""))
	{
		if(status.equals("R"))
		{
			Where.append(" and c.finalize_yn = 'N' ");
		}
		else if(status.equals("F"))
		{
			Where.append(" and c.finalize_yn = 'Y' ");
		}

	}
		
	//Where.append(" and nvl(c.finalize_yn,'N')='N' ");

	int maxRecord = 0;
		
	//sql = " select a.encounter_id, to_char(a.discharge_date_time,'dd/mm/yyyy hh24:mi') discharge_date, to_char(a.visit_adm_date_time,'dd/mm/yyyy hh24:mi') admission_date, a.patient_id, b.patient_name, b.sex, a.attend_practitioner_id from PR_ENCOUNTER a, MP_PATIENT b, MR_DEATH_REGISTER_HDR c " + Where.toString() ;

	//sql = "select a.encounter_id, to_char(a.discharge_date_time,'dd/mm/yyyy hh24:mi') discharge_date,		to_char(a.visit_adm_date_time,'dd/mm/yyyy hh24:mi') admission_date, a.patient_id, decode('"+locale+"','en',b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) patient_name, b.sex, a.attend_practitioner_id, a.patient_class, d.pract_type, a.specialty_code, To_char(b.date_of_birth,'dd/mm/yyyy') date_of_birth, a.pat_curr_locn_code from PR_ENCOUNTER a, MP_PATIENT b, MR_DEATH_REGISTER_HDR c, AM_PRACTITIONER d, AM_PRACT_TYPE e " + Where.toString() ;  
	
	//sql = "select a.encounter_id, to_char(a.discharge_date_time,'dd/mm/yyyy hh24:mi') discharge_date,		to_char(a.visit_adm_date_time,'dd/mm/yyyy hh24:mi') admission_date, a.patient_id, decode('"+locale+"','en',b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) patient_name, b.sex, a.attend_practitioner_id, a.patient_class, d.pract_type, a.specialty_code, To_char(b.date_of_birth,'dd/mm/yyyy') date_of_birth, a.pat_curr_locn_code,to_char(a.deceased_date_time,'dd/mm/yyyy hh24:mi') deceased_date_time, decode(a.patient_class, 'IP',IP_GET_DESC.IP_ADMISSION_TYPE(a.visit_adm_type,'"+locale+"','2'),'DC',IP_GET_DESC.IP_ADMISSION_TYPE(a.visit_adm_type,'"+locale+"','2'),OP_GET_DESC.OP_VISIT_TYPE(a.facility_id,a.visit_adm_type,'"+locale+"','2')) admission_type,c.auth_practitioner_id,AM_GET_DESC.AM_PRACTITIONER(c.auth_practitioner_id,'"+locale+"','2') auth_practitioner_name,c.remarks,c.finalize_yn from PR_ENCOUNTER a, MP_PATIENT b, MR_DEATH_REGISTER_HDR c, AM_PRACTITIONER d, AM_PRACT_TYPE e " + Where.toString() ;  

		sql = "SELECT   a.encounter_id, TO_CHAR (a.discharge_date_time, 'dd/mm/yyyy hh24:mi') discharge_date,TO_CHAR (a.EXP_DISCHARGE_DATE_TIME, 'dd/mm/yyyy hh24:mi') exp_discharge_date,        TO_CHAR (a.visit_adm_date_time, 'dd/mm/yyyy hh24:mi') admission_date,a.patient_id,DECODE ('"+locale+"','"+locale+"', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name,b.sex, a.attend_practitioner_id, a.patient_class,a.specialty_code,TO_CHAR (b.date_of_birth, 'dd/mm/yyyy') date_of_birth,a.pat_curr_locn_code,TO_CHAR (c.death_date_time,      'dd/mm/yyyy hh24:mi') deceased_date_time,DECODE(a.patient_class,'IP', ip_get_desc.ip_admission_type (a.visit_adm_type, 'en', '2'),'DC', ip_get_desc.ip_admission_type (a.visit_adm_type, 'en', '2'),    op_get_desc.op_visit_type (a.facility_id,a.visit_adm_type,'"+locale+"','2')) admission_type,c.auth_practitioner_id, am_get_desc.am_practitioner(c.auth_practitioner_id,'"+locale+"','2') auth_practitioner_name,c.remarks, c.finalize_yn,(select pract_type from am_practitioner where practitioner_id =  c.auth_practitioner_id) pract_type FROM pr_encounter a,mp_patient b,    mr_death_register_hdr c  " + Where.toString() ;  

	
	

	sql = sql +" order by encounter_id";
	//pstmt=conn.prepareStatement(sql.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	pstmt=conn.prepareStatement(sql.toString());
	pstmt.setString(1,FacilityId);
	//pstmt.setString(2,PatientId);
	//pstmt.setString(3,EncounterId);
	if(!Admission_From_Date.equals("") && !Admission_To_Date.equals(""))	
	{
		/*pstmt.setString(4,Admission_From_Date);
		pstmt.setString(5,Admission_To_Date);*/
		pstmt.setString(2,Admission_From_Date);
		pstmt.setString(3,Admission_To_Date);
	}
	
	if((!Admission_From_Date.equals("") && !Admission_To_Date.equals("")) && (!Discharge_From_Date.equals("") && !Discharge_To_Date.equals("")))	
	{
		/*pstmt.setString(4,Discharge_From_Date);
		pstmt.setString(5,Discharge_To_Date);*/
		pstmt.setString(4,Discharge_From_Date);
		pstmt.setString(5,Discharge_To_Date);
	}

	if((Admission_From_Date.equals("") && Admission_To_Date.equals("")) && (!Discharge_From_Date.equals("") && !Discharge_To_Date.equals("")))	
	{
		/*pstmt.setString(4,Discharge_From_Date);
		pstmt.setString(5,Discharge_To_Date);*/
		pstmt.setString(2,Discharge_From_Date);
		pstmt.setString(3,Discharge_To_Date);
	}
	
	if(!deceased_from_date.equals("") && !deceased_to_date.equals(""))	
	{
		pstmt.setString(4,deceased_from_date);
		pstmt.setString(5,deceased_to_date);
	}

	if((!Admission_From_Date.equals("") && !Admission_To_Date.equals("")) && (!Discharge_From_Date.equals("") && !Discharge_To_Date.equals("")) && (!deceased_from_date.equals("") && !deceased_to_date.equals("")))	
	{
		/*pstmt.setString(4,Discharge_From_Date);
		pstmt.setString(5,Discharge_To_Date);*/
		pstmt.setString(6,Discharge_From_Date);
		pstmt.setString(7,Discharge_To_Date);
	}
	rs = pstmt.executeQuery();

/*	if(rs != null)
	{
		rs.last();
		maxRecord = rs.getRow();
        rs.beforeFirst();
	}
	if (maxRecord==0)		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));//document.location.href='../../eCommon/html/blank.html'</script>");
	else
	{*/
		if ( start != 1 )
			for( int j=1; j<start; i++,j++ )
				rs.next() ;

		while (i<=end &&  rs.next())
		{
			if(maxRecord==0)
			{

		%>
		<P>
		<table align='right'>
		<tr>
		
		<%
		if ( !(start <= 1) )
			//out.println("<td align ='right' id='prev'><A HREF='../../eMR/jsp/DeathRegisterResult.jsp?PatientId="+PatientId+"&EncounterId="+EncounterId+"&AdmissionDate="+AdmissionDate+"&DischargeDate="+DischargeDate+"&from="+(start-20)+"&to="+(end-20)+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
			out.println("<td align ='right' id='prev'><A HREF='../../eMR/jsp/DeathRegisterResult.jsp?status="+status+"&PatientId="+PatientId+"&EncounterId="+EncounterId+"&admission_from_date="+Admission_From_Date+"&admission_to_date="+Admission_To_Date+"&discharge_from_date="+Discharge_From_Date+"&discharge_to_date="+Discharge_To_Date+"&deceased_from_date="+deceased_from_date+"&deceased_to_date="+deceased_to_date+"&from="+(start-20)+"&to="+(end-20)+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
		//if ( !( (start+20) > maxRecord ) )
			//out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eMR/jsp/DeathRegisterResult.jsp?PatientId="+PatientId+"&EncounterId="+EncounterId+"&AdmissionDate="+AdmissionDate+"&DischargeDate="+DischargeDate+"&from="+(start+20)+"&to="+(end+20)+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");

			out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eMR/jsp/DeathRegisterResult.jsp?status="+status+"&PatientId="+PatientId+"&EncounterId="+EncounterId+"&admission_from_date="+Admission_From_Date+"&admission_to_date="+Admission_To_Date+"&discharge_from_date="+Discharge_From_Date+"&discharge_to_date="+Discharge_To_Date+"&deceased_from_date="+deceased_from_date+"&deceased_to_date="+deceased_to_date+"&from="+(start+20)+"&to="+(end+20)+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
		%>
		
		</tr>
		</table><br>
		</P>
		<table border="1" width="100%" cellspacing='0' cellpadding='0'>
		<th class='columnheader' nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
		<th class='columnheader' nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
		<th class='columnheader' nowrap><fmt:message key="Common.gender.label" bundle="${common_labels}"/></th>
		<th class='columnheader' nowrap><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></th>
		<th class='columnheader' nowrap><fmt:message key="Common.status.label" bundle="${common_labels}"/></th>
		<th class='columnheader' nowrap><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></th>
		<th class='columnheader' nowrap><fmt:message key="Common.admissiondate.label" bundle="${common_labels}"/></th>
		<th class='columnheader' nowrap><fmt:message key="Common.dischargedate.label" bundle="${common_labels}"/></th>
		<th class='columnheader' nowrap><fmt:message key="eMR.dischargeYN.label" bundle="${mr_labels}"/></th>
		<th class='columnheader' nowrap><fmt:message key="Common.DeceasedDate.label" bundle="${common_labels}"/></th> 
		<%
			}
	String classValue	 = "";
	//if ( rs != null )
	//{
		/*if ( start != 1 )
		 for( int j=1; j<start; i++,j++ )
			  rs.next() ;
		*/
		//while ( rs.next() && i<=end )
		//{
			if ( i % 2 == 0 )
				classValue = "QRYEVENSMALL";
			else
				classValue = "QRYODDSMALL"; 
			String EncounterID		= rs.getString("encounter_id");				
			String Discharge_Date	= rs.getString("discharge_date");
			String VisitAdmDate		= rs.getString("admission_date");
			String PatientID		= rs.getString("patient_id");
			String PatientName		= rs.getString("patient_name");
			String Sex				= rs.getString("sex");
			String gender			= rs.getString("sex");
			String Practitioner		= rs.getString("attend_practitioner_id");
			String patient_class	= rs.getString("patient_class");
			String pract_type		= rs.getString("pract_type");
			String speciality_code	= rs.getString("specialty_code");
			String date_of_birth	= rs.getString("date_of_birth");
			String pat_curr_locn_code	= rs.getString("pat_curr_locn_code");
			String deceased_date_time	= checkForNull(rs.getString("deceased_date_time"));	
			
			if(!(Discharge_Date==null || Discharge_Date.equals("")))
				discharged_yn = "Y";
			else
				discharged_yn = "N";



			if(!(deceased_date_time==null || deceased_date_time.equals("")))
				deceased_date_time = DateUtils.convertDate(deceased_date_time,"DMYHM","en",locale);
			String Discharge_Date_display = DateUtils.convertDate(Discharge_Date,"DMYHM","en",locale);
			String VisitAdmDate_display = DateUtils.convertDate(VisitAdmDate,"DMYHM","en",locale);
			String admission_type			= rs.getString("admission_type");	
			String auth_practitioner_id	= rs.getString("auth_practitioner_id");		
			String auth_practitioner_name	= rs.getString("auth_practitioner_name");	
			String remarks					= rs.getString("remarks");	
			String finalize_yn					= rs.getString("finalize_yn");
			
			if(finalize_yn.equals("") || finalize_yn == null)
				finalize_yn="N";

			String finalize_status = "";
			

			/*out.println("<script>alert(\"admission_type:"+admission_type+"\");</script>");
			out.println("<script>alert(\"auth_practitioner_name:"+auth_practitioner_name+"\");</script>");
			out.println("<script>alert(\"auth_practitioner_name:"+auth_practitioner_id+"\");</script>");
		*/
		
			
			if(EncounterID==null	|| EncounterID.equals("null"))		EncounterID = "";
			//if(VisitAdmDate==null	|| VisitAdmDate.equals("null"))		VisitAdmDate = "";
			//if(DischargeDate==null	|| DischargeDate.equals("null"))	DischargeDate = "";
			if(PatientName==null	|| PatientName.equals("null"))		PatientName = "";
			if(Practitioner==null	|| Practitioner.equals("null"))		Practitioner = "";
			if(patient_class==null	|| patient_class.equals("null"))	patient_class = "";
			if(pract_type==null		|| pract_type.equals("null"))		pract_type = "";
			if(speciality_code==null|| speciality_code.equals("null"))	speciality_code = "";
			if(date_of_birth==null|| date_of_birth.equals("null"))	date_of_birth = "";
			if(pat_curr_locn_code==null|| pat_curr_locn_code.equals("null"))	pat_curr_locn_code = "";
			if(auth_practitioner_id==null|| auth_practitioner_id.equals("null"))	auth_practitioner_id = "";
			if(admission_type==null|| admission_type.equals("null"))	admission_type = "";
			if(auth_practitioner_name==null|| auth_practitioner_name.equals("null"))	auth_practitioner_name = "";
			if(remarks==null|| remarks.equals("null"))	remarks = "";
			if(VisitAdmDate_display==null|| VisitAdmDate_display.equals(""))VisitAdmDate_display = "&nbsp;";
			if(Discharge_Date_display==null|| Discharge_Date_display.equals(""))Discharge_Date_display = "&nbsp;";
			if(deceased_date_time==null|| deceased_date_time.equals(""))deceased_date_time = "&nbsp;";


			if(Sex == null )
				Sex="";
			else if (Sex.equals("M"))
				Sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
			else if (Sex.equals("F"))
				Sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
			else 
				Sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
			if(finalize_yn.equals("Y"))
			{
				finalize_status="Finalized";				
				out.println("<tr><td class='"+classValue+"' style='font-weight:normal;background-color:white'>");
				out.println("<a href=javascript:call_death_reg('"+EncounterID+"','"+PatientID+"','"+Practitioner+"','"+patient_class+"','"+speciality_code+"','"+gender+"','"+date_of_birth+"','"+pract_type+"','"+pat_curr_locn_code+"','"+finalize_yn+"','"+java.net.URLEncoder.encode(VisitAdmDate)+"')>"+PatientID+"</a>");
				out.println("</td>");
				out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:white'>"+PatientName+"</td>");			
				out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:white'>"+Sex+"</td>");	
				out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:white'>"+patient_class+"</td>");				
				out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:white'>"+finalize_status+"</td>");				
				out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:white'>"+EncounterID+"</td>");
				out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:white'>"+VisitAdmDate_display+"</td>");
				out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:white'>" +Discharge_Date_display+"</td>");
				out.println("<td  class='"+classValue+"' style='font-weight:normal;background-color:white;text-align:center;'>" +discharged_yn+"</td>");
				out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:white'>"+deceased_date_time+"</td>");


			}
			else
			{
				finalize_status="Recorded";
				out.println("<tr><td class='"+classValue+"' style='font-weight:normal;background-color:lightblue'>");
				out.println("<a href=javascript:call_death_reg('"+EncounterID+"','"+PatientID+"','"+Practitioner+"','"+patient_class+"','"+speciality_code+"','"+gender+"','"+date_of_birth+"','"+pract_type+"','"+pat_curr_locn_code+"','"+finalize_yn+"','"+java.net.URLEncoder.encode(VisitAdmDate)+"')>"+PatientID+"</a>");
				out.println("</td>");
				out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:lightblue'>"+PatientName+"</td>");			
				out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:lightblue'>"+Sex+"</td>");	
				out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:lightblue'>"+patient_class+"</td>");				
				out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:lightblue'>"+finalize_status+"</td>");				
				out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:lightblue'>"+EncounterID+"</td>");
				out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:lightblue'>"+VisitAdmDate_display+"</td>");
				out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:lightblue'>" +Discharge_Date_display+"</td>");
				out.println("<td class='"+classValue+"'  style='font-weight:normal;background-color:lightblue;text-align:center;'>" +discharged_yn+"</td>");
				out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:lightblue'>"+deceased_date_time+"</td>");
			}


			//out.println("<a href=javascript:modify_death_date('"+EncounterID+"','"+PatientID+"','"+java.net.URLEncoder.encode(deceased_date_time)+"','"+java.net.URLEncoder.encode(Discharge_Date_display)+"','"+java.net.URLEncoder.encode(VisitAdmDate_display)+"',\""+java.net.URLEncoder.encode(admission_type, "UTF-8")+"\",'"+java.net.URLEncoder.encode(auth_practitioner_id)+"',\""+java.net.URLEncoder.encode(auth_practitioner_name)+"\",'"+java.net.URLEncoder.encode(remarks)+"')>"+deceased_date_time+"</a>");
			//out.println("<a href=javascript:modify_death_date('"+EncounterID+"','"+PatientID+"',\""+java.net.URLEncoder.encode(deceased_date_time)+"\", \""+java.net.URLEncoder.encode(Discharge_Date_display)+"\",\""+java.net.URLEncoder.encode(VisitAdmDate_display)+"\",\""+admission_type+"\",'"+auth_practitioner_id+"',\""+auth_practitioner_name+"\",\""+remarks+"\")>"+deceased_date_time+"</a>");
			%>
			<!-- <a href="javascript:modify_death_date('<%=EncounterID%>','<%=PatientID%>','<%=deceased_date_time%>','<%=Discharge_Date_display%>','<%=VisitAdmDate_display%>','<%=admission_type%>','<%=auth_practitioner_id%>','<%=remarks%>')"><%=deceased_date_time%></a> -->
			<%//out.println("</td>");
			//out.println("</font></tr>");
			out.println("</tr>");
			i++;
			maxRecord++;
		}
	//}
			
		if ( maxRecord < 20 || (!rs.next()) )
		{	%>
			<script >
				if (document.getElementById("next"))
					document.getElementById("next").style.visibility='hidden';
			</script>
	<% 	}
		else
		{	%>
			<script >
				if (document.getElementById("next"))
					document.getElementById("next").style.visibility='visible';
			</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	<%	}

		if(maxRecord==0)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
		}
%>
	</table>
	<br><center>
<%	//}
}catch ( Exception e )
{
	//out.println("Exception @ DeathRegisterResult.jsp"+e.toString());
	e.printStackTrace();
}
finally
{
	out.println("<script>parent.frames[1].document.forms[0].search.disabled=false;</script>");
	try
	{
		if ( pstmt != null ) pstmt.close() ;
		if ( rs != null ) rs.close() ;
	}
	catch(Exception e)	{	}
		ConnectionManager.returnConnection(conn,request);
	}
%>
</center>
</form>
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

