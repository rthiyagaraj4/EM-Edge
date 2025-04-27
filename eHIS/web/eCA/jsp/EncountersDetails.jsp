<!DOCTYPE html>
<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
15/07/2013		IN034514		Karthi L		In Clinical Event History, one could see information about patient's visit as a 
												summary which included Patient Admission date, date of discharge, attending practitioner, etc													
12/08/2013		IN042319		Karthi L		In Clinical Event History at Admission details the serial number of referrals made are displayed  wrongly.
26/08/2013		IN042564		Karthi L		Visit details/ admission details are not displayed directly at Clinical Event History  for patient at other facility
24/04/2019		IN008942		Sivabagyam M		Bug found on Clinical event History The issue is related to Clinical event History and it was reported to us by a very Senior Doctor through our Quality team which also duly recorded an incident in this regard.
03/02/2020			IN071561	SIVABAGYAM M		03/02/2020		RAMESH G		GHL-CRF-0558.1
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<html>
<%@page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<head>
	 <%
		request.setCharacterEncoding("UTF-8");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		Properties p = (Properties)session.getValue("jdbc");
		String locale	= (String) p.getProperty("LOCALE");
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src="../../eCA/js/Encounters.js" language="JavaScript"></script>
</head>

<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<script language=javascript>
		document.body.style.scrollbarBaseColor = '#E2E3F0';
		document.body.style.scrollbarArrowColor = '#000080';
		document.body.style.scrollbarDarkShadowColor = '#E2E3F0';
		document.body.style.scrollbarFaceColor = '#E2E3F0';
		document.body.style.scrollbarHighlightColor = 'white';
		document.body.style.scrollbarShadowColor = '#E2E3F0';
		document.body.style.scrollbar3dlightColor = '#E2E3F0';
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<form name="currentencounter_form" id="currentencounter_form">
		<%
	Connection con					= null;
	PreparedStatement stmt			= null;
	PreparedStatement stmt1			= null;
	PreparedStatement stmt2			= null;
	PreparedStatement facIdpStmt	= null; //added for IN042564
	ResultSet rs	= null;
	ResultSet rs1	= null;
	ResultSet rs2	= null;
	ResultSet facIdrSet  = null; // added for IN042564
	StringBuffer referral_made_to=new StringBuffer();
	
	referral_made_to.append("");
	
	String disposition="";
	int ref_seq_no = 1;

	try
	{
		//String facilityid = (String) session.getValue("facility_id");
		String facilityid =  request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
		String patientid = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String episodetype = request.getParameter("episode_type")==null?"":request.getParameter("episode_type");
		//String EHR_YN = request.getParameter("EHR_YN")==null?"N":request.getParameter("EHR_YN");
		String episodeid = request.getParameter("episodeid")==null?"":request.getParameter("episodeid");
		String patient_class = request.getParameter("patient_class")==null?"":request.getParameter("patient_class");//IN034514
		String p_review_rad_yn=request.getParameter("p_review_rad_yn")==null?"N":request.getParameter("p_review_rad_yn");//IN071561
		if(episodeid.equals("")){
			episodeid = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
		}
		//added for IN034514 - Start
		if(episodetype.equals("B")){
			episodetype = patient_class;
		}
		else if(episodetype.equals("I")){
			episodetype = "IP";
		}
		else if(episodetype.equals("D")){
			episodetype = "DC";
		}
		else if(episodetype.equals("O")){
			episodetype = "OP";
		}
		else if(episodetype.equals("E")){
			episodetype = "EM";
		}
		//added for IN034514 - End
		/*if(EHR_YN.equals("N"))
		{
			facilityid =(String)session.getValue("facility_id");
		} */
		//added for IN034514 - Start
		if(facilityid.equals(""))
		{
			facilityid =(String)session.getValue("facility_id");
		}
		//added for IN034514 - End	
		con		= ConnectionManager.getConnection(request);
		String contact_reason = "",diag_desc="";
		StringBuffer sql =new StringBuffer();
		StringBuffer sql1 =new StringBuffer();
		StringBuffer sql2 =new StringBuffer();
		rs			= null;

		String facIdSql = " select facility_id from PR_ENCOUNTER_VW where PATIENT_ID = ? and ENCOUNTER_ID = ?";
		
		facIdpStmt = con.prepareStatement(facIdSql);
		
		facIdpStmt.setString(1,patientid);
		facIdpStmt.setString(2, episodeid);
		
		facIdrSet = facIdpStmt.executeQuery();
		
		while(facIdrSet.next()){
			facilityid = facIdrSet.getString("facility_id");
		}
		if(!(episodetype.equals("OP") || episodetype.equals("EM")))
		{

		sql.append("select to_char(A.visit_adm_date_time,'dd/mm/yyyy hh24:mi') ADMISSION_DATE_TIME, ");
		sql.append(" encounter_id EPISODE_ID, VISIT_TYPE_DESC ADMISSION_TYPE_CODE_DESC, AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'2')  ");
		//sql.append(" MED_SPLTY_GRP_CODE_DESC ,CASE WHEN a.attend_practitioner_id IS NOT NULL THEN am_get_desc.am_practitioner(a.attend_practitioner_id,?,'2') END PRACTITIONER_NAME, AM_GET_DESC.AM_CONTACT_REASON(a.contact_reason_code,?,'1')  CONTACT_REASON ,(select DIAG_DESC from pr_problem where ONSET_ENCOUNTER_ID=a.ENCOUNTER_ID and ONSET_FACILITY_ID=a.FACILITY_ID and PRIMARY_YN='Y' and rownum=1) DIAG_DESC, AM_GET_DESC.AM_DISPOSITION_TYPE(A.DISPOSITION_TYPE,?,'2') disposition ");//IN008942
		sql.append(" MED_SPLTY_GRP_CODE_DESC ,CASE WHEN a.attend_practitioner_id IS NOT NULL THEN am_get_desc.am_practitioner(a.attend_practitioner_id,?,'2') END PRACTITIONER_NAME, AM_GET_DESC.AM_CONTACT_REASON(a.contact_reason_code,?,'1')  CONTACT_REASON ,(select DIAG_DESC from pr_problem where ONSET_ENCOUNTER_ID=a.ENCOUNTER_ID and ONSET_FACILITY_ID=a.FACILITY_ID and PRIMARY_YN='Y' and rownum=1) DIAG_DESC, IP_GET_DESC.IP_DISCHARGE_TYPE(A.DISPOSITION_TYPE,?,'2') disposition ");//IN008942
		//sql.append(" from pr_encounter a "); // commented for IN034514
		sql.append(" from pr_encounter_vw a "); // modified for IN034514
		sql.append(" where  patient_id = ?  ");
		if(!facilityid.equals("")){
			sql.append(" and facility_id = ? ");
			}
			if(!episodeid.equals("")){
				sql.append(" and encounter_id = ? ");
			}

			stmt	= con.prepareStatement(sql.toString());
			int counter = 0;
			stmt.setString(++counter, locale);
			stmt.setString(++counter, locale);
			stmt.setString(++counter, locale);
			stmt.setString(++counter, locale);
			stmt.setString(++counter, patientid);
			if(!facilityid.equals("")){
				stmt.setString(++counter, facilityid);
			}
			if(!episodeid.equals("")){
				stmt.setString(++counter, episodeid);
			}
            
/*sql1.append("SELECT "); 
sql1.append("rtrim(DECODE(a.FROM_REF_TYPE,'L','','E','Enterprise / ','X','External / ')  || D.SHORT_DESC    ||' / '|| C.SHORT_DESC    ||' / '|| CASE WHEN A.FROM_REF_TYPE='X' THEN   (SELECT B.SHORT_DESC FROM AM_REFERRAL B WHERE B.REFERRAL_CODE=A.FROM_REF_CODE)    WHEN A.FROM_REF_TYPE IN ('E','L') THEN   (SELECT FACILITY_NAME FROM SM_FACILITY_PARAM WHERE FACILITY_ID = A.FROM_FACILITY_ID)    END    ||' / '|| CASE WHEN A.FROM_REF_TYPE='X' THEN A.FROM_LOCN_DESC         WHEN A.FROM_LOCN_TYPE IN ('C','Y','E') THEN      (SELECT SHORT_DESC FROM OP_CLINIC WHERE FACILITY_ID=A.FROM_FACILITY_ID AND CLINIC_CODE=A.FROM_LOCN_CODE)   WHEN A.FROM_LOCN_TYPE IN ('N') THEN      (SELECT SHORT_DESC FROM IP_NURSING_UNIT WHERE FACILITY_ID=A.FROM_FACILITY_ID AND NURSING_UNIT_CODE=A.FROM_LOCN_CODE)    END,' / ') REFERRAL_SOURCE ");
sql1.append("FROM  PR_REFERRAL_REGISTER A ");
sql1.append(", AM_SPECIALITY C ");
sql1.append(", AM_HCARE_SETTING_TYPE D ");
sql1.append("WHERE     A.TO_FACILITY_ID=? ");
sql1.append("AND       A.CLOSE_ENCOUNTER_ID =? ");
sql1.append("AND A.FROM_HCARE_SETTING_TYPE = D.HCARE_SETTING_TYPE_CODE ");
sql1.append("AND A.FROM_SPECIALITY_CODE = C.SPECIALITY_CODE (+) ");
sql1.append("AND ROWNUM=1 "); */

sql1.append("SELECT ");  
sql1.append("rtrim(DECODE(a.FROM_REF_TYPE,'L','','E','Enterprise / ','X','External / ')  || AM_GET_DESC.AM_HCARE_SETTING_TYPE(A.FROM_HCARE_SETTING_TYPE,?,'2')    ||' / '|| AM_GET_DESC.AM_SPECIALITY(FROM_SPECIALITY_CODE,?,'2')   ||' / '|| CASE WHEN A.FROM_REF_TYPE='X' THEN   AM_GET_DESC.AM_REFERRAL(A.FROM_rEF_CODE,?,'1')  WHEN A.FROM_REF_TYPE IN ('E','L') THEN   SM_GET_DESC.SM_FACILITY_PARAM(A.FROM_fACILITY_ID,?,'1')   END    ||' / '|| CASE WHEN A.FROM_REF_TYPE='X' THEN A.FROM_LOCN_DESC         WHEN A.FROM_LOCN_TYPE IN ('C','Y','E') THEN      OP_GET_DESC.OP_CLINIC(A.FROM_FACILITY_ID,A.FROM_LOCN_CODE,?,'1')  WHEN A.FROM_LOCN_TYPE IN ('N') THEN      IP_GET_DESC.IP_NURSING_UNIT(A.FROM_FACILITY_ID,A.FROM_LOCN_CODE,?,'1')    END,' / ') REFERRAL_SOURCE ");
sql1.append("FROM  PR_REFERRAL_REGISTER A ");
sql1.append("WHERE     A.TO_FACILITY_ID=? ");
sql1.append("AND       A.CLOSE_ENCOUNTER_ID =? ");
sql1.append("AND ROWNUM=1 ");

stmt1	= con.prepareStatement(sql1.toString());
stmt1.setString(1, locale);
stmt1.setString(2, locale);
stmt1.setString(3, locale);
stmt1.setString(4, locale);
stmt1.setString(5, locale);
stmt1.setString(6, locale);
stmt1.setString(7, facilityid);
stmt1.setString(8, episodeid);
/*
sql2.append("SELECT     RTRIM( DECODE(a.TO_REF_TYPE,'L','','E','Enterprise / ','X','External / ')");
sql2.append("||D.SHORT_DESC ");
sql2.append("|| ' / '||C.SHORT_DESC ");
sql2.append("|| ' / '||CASE WHEN A.TO_REF_TYPE='X' THEN (SELECT B.SHORT_DESC FROM AM_REFERRAL B WHERE B.REFERRAL_CODE=A.TO_REF_CODE)");
sql2.append("WHEN A.TO_REF_TYPE IN ('E','L') THEN	(SELECT FACILITY_NAME FROM SM_FACILITY_PARAM WHERE FACILITY_ID = A.TO_FACILITY_ID)  END");
sql2.append("|| ' / '||CASE WHEN A.TO_REF_TYPE='X' THEN A.TO_LOCN_DESC         WHEN A.TO_LOCN_TYPE IN ('C','Y','E') ");
sql2.append("THEN(SELECT SHORT_DESC FROM OP_CLINIC WHERE FACILITY_ID=A.TO_FACILITY_ID "); 
sql2.append("AND CLINIC_CODE=A.TO_LOCN_CODE)	WHEN A.TO_LOCN_TYPE IN ('N') THEN ");	   
sql2.append("(SELECT SHORT_DESC FROM IP_NURSING_UNIT WHERE FACILITY_ID=A.TO_FACILITY_ID "); 
sql2.append("AND NURSING_UNIT_CODE=A.TO_LOCN_CODE)  END,' / ')  REFERRAL_MADE_TO ");
sql2.append("FROM  PR_REFERRAL_REGISTER A , AM_SPECIALITY C , AM_HCARE_SETTING_TYPE D ");
sql2.append("WHERE     A.FROM_FACILITY_ID=? AND A.FROM_ENCOUNTER_ID = ? AND A.TO_HCARE_SETTING_TYPE = D.HCARE_SETTING_TYPE_CODE  AND A.TO_SPECIALITY_CODE = C.SPECIALITY_CODE ");
*/
sql2.append("SELECT     RTRIM( DECODE(a.TO_REF_TYPE,'L','','E','Enterprise / ','X','External / ')");
sql2.append("||AM_GET_DESC.AM_HCARE_SETTING_TYPE(TO_HCARE_SETTING_TYPE,?,'2') ");
sql2.append("|| ' / '||AM_GET_DESC.AM_SPECIALITY(A.TO_SPECIALITY_CODE,?,'2') ");
sql2.append("|| ' / '||CASE WHEN A.TO_REF_TYPE='X' THEN AM_GET_DESC.AM_REFERRAL(TO_REF_CODE,?,'1')");
sql2.append("WHEN A.TO_REF_TYPE IN ('E','L') THEN	SM_GET_DESC.SM_FACILITY_PARAM(A.TO_FACILITY_ID,?,'1')  END");
sql2.append("|| ' / '||CASE WHEN A.TO_REF_TYPE='X' THEN A.TO_LOCN_DESC         WHEN A.TO_LOCN_TYPE IN ('C','Y','E') ");
sql2.append("THEN OP_GET_DESC.OP_CLINIC(A.TO_FACILITY_ID,A.TO_LOCN_CODE,?,'1') "); 
sql2.append("	WHEN A.TO_LOCN_TYPE IN ('N') THEN ");	   
sql2.append("IP_GET_DESC.IP_NURSING_UNIT(A.TO_FACILITY_ID,A.TO_LOCN_CODE,?,'1') "); 
sql2.append("  END,' / ')  REFERRAL_MADE_TO ");
sql2.append("FROM  PR_REFERRAL_REGISTER A ");
sql2.append("WHERE     A.FROM_FACILITY_ID=? AND A.FROM_ENCOUNTER_ID = ?  ");

stmt2	= con.prepareStatement(sql2.toString());
			
stmt2.setString(1, locale);
stmt2.setString(2, locale);
stmt2.setString(3, locale);
stmt2.setString(4, locale);
stmt2.setString(5, locale);
stmt2.setString(6, locale);
stmt2.setString(7, facilityid);
stmt2.setString(8, episodeid);
			
			rs = stmt.executeQuery();
			rs1 = stmt1.executeQuery();
			rs2 = stmt2.executeQuery();
           	
			//String strAdmDate = rs.getString("ADMISSION_DATE_TIME");

			String strAdmDate ="";

			

			if(rs != null && rs.next())
			{
							 strAdmDate = rs.getString("ADMISSION_DATE_TIME");
							 strAdmDate		=	com.ehis.util.DateUtils.convertDate(strAdmDate,"DMYHM","en",locale);
		%>
				<table class='grid' width='100%' align='center'>
				<tr align="left"><th class='columnHeader' colspan='4' ><fmt:message key="Common.AdmissionDetails.label" bundle="${common_labels}"/></th> </tr>
				
				<tr>
					<td  class='LABEL' nowrap width='20%' ><fmt:message key="Common.datetime.label" bundle="${common_labels}"/></td>
					<td  class='DATA' ><%=strAdmDate%></td>
					<td  class='LABEL'><fmt:message key="eCA.AdmNo.label" bundle="${ca_labels}"/></td>
					<td  class='DATA' ><%=rs.getString("EPISODE_ID")%></td>
				</tr>
				<tr>
					<td  class='LABEL' width='20%' ><fmt:message key="Common.type.label" bundle="${common_labels}"/></td> 
				 	<td  class='DATA' ><%=rs.getString("ADMISSION_TYPE_CODE_DESC")%></td> 
					<td  class='LABEL' ><fmt:message key="Common.MedicalService.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
					<td  class='DATA' ><%=rs.getString("MED_SPLTY_GRP_CODE_DESC")%></td>
				</tr>
				<%
					contact_reason = rs.getString("contact_reason");
					diag_desc		=  rs.getString("diag_desc");
					disposition		=  rs.getString("disposition");
					if(contact_reason == null) contact_reason = "";
					if(diag_desc == null) diag_desc = "";
				%>
				<tr>
					<td  class='LABEL' width='10%'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
					<td  class='DATA' ><%=rs.getString("PRACTITIONER_NAME")==null?"":rs.getString("PRACTITIONER_NAME")%></td> <!-- IN034514 -->
					<%if(disposition != null){%>
						<td  class='LABEL' width='10%'><fmt:message key="Common.Disposition.label" bundle="${common_labels}"/></td>
						<td  class='DATA' ><%=disposition%></td>
					<%}else{%>
						<td colspan='2'></td>
					<%}%>
				</tr>
				
					
				<%	if(!contact_reason.equals("")){%>
						<tr>
							<td  class='LABEL' width='20%'><fmt:message key="Common.ContactReason.label" bundle="${common_labels}"/></td>
							<td  class='DATA' colspan='3'><%=contact_reason%></td>
						</tr>

					<%}%>
					<%if(!diag_desc.equals("")){%>
						<tr>
							<td  class='LABEL' width='20%'><fmt:message key="Common.Problem.label" bundle="${common_labels}"/></td>
							<td  class='DATA' colspan='3'><%=diag_desc%></td>
						</tr>
					<%}
				%>

				<tr>
				<%if(rs1 != null && rs1.next()){%>
					<td  valign=top class='LABEL' width='10%'><fmt:message key="Common.referralsource.label" bundle="${common_labels}"/></td>
					<td  colspan=3 class='DATA' align='center'><%=rs1.getString("REFERRAL_SOURCE")%></td>
					
                <%}%>
				

				</tr>
                
				<% 
					String referral_String = "";
				
					while (rs2.next())
					{
						if (!referral_made_to.toString().equals(""))
						{
							referral_String = rs2.getString("REFERRAL_MADE_TO") == null ? "" : "<BR>"+ref_seq_no +".&nbsp;"+rs2.getString("REFERRAL_MADE_TO");
							referral_made_to.append(referral_String);
							ref_seq_no++; //added for IN042319		
						}
						else
						{
							referral_String = rs2.getString("REFERRAL_MADE_TO") == null ? "" : rs2.getString("REFERRAL_MADE_TO");
							referral_made_to.append(referral_String);
							ref_seq_no++;
						}
					}
				%>
                <%if(!referral_made_to.toString().equals("")){ 
				  if (ref_seq_no==2){%>
				    <tr>
					<td align=right valign=top class='LABEL' width='10%'><fmt:message key="eCA.ReferralsMadeTo.label" bundle="${ca_labels}"/></td>
					<td  class='DATA' colspan='3'  ><%=referral_made_to.toString()%></td>
					</tr>
				<%}else{ %>
					  <tr>
					<td  valign=top class='LABEL' width='10%'><fmt:message key="eCA.ReferralsMadeTo.label" bundle="${ca_labels}"/></td>
					<td  class='DATA' colspan='3' >1. <%=referral_made_to.toString()%></td>
					</tr>
                <%}}%>
				<tr>
					<td colspan="4" class=BODYCOLORFILLED>&nbsp;</td>
				</tr>
				</table>
				<table class='grid' width='100%' align='center'>
				<tr>
					<td colspan="7" class=CAGROUP><fmt:message key="Common.staydetails.label" bundle="${common_labels}"/></td>
				</tr>
				<tr>
					<td class='columnHeader'><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
					<td class='columnHeader'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
 					<td class='columnHeader'><fmt:message key="Common.roomno.label" bundle="${common_labels}"/></td>
					<td class='columnHeader'><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></td>
					<td class='columnHeader'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
					<td class='columnHeader'><fmt:message key="Common.MedicalService.label" bundle="${common_labels}"/></td>
					<td class='columnHeader'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
				</tr>
	<%
			}
			if(stmt !=null)stmt.close();
			sql.setLength(0);

			sql.append(" select ");
		    sql.append("to_char(trn_date_time,'dd/mm/yyyy hh24:mi') trn_date_time ");
			sql.append(",decode(trn_type,'D',fr_nursing_unit_short_desc,'L',fr_nursing_unit_short_desc,to_nursing_unit_short_desc) to_nursing_unit_short_desc");
			sql.append(",decode(trn_type,'D',fr_room_no,'L',fr_room_no,to_room_no) to_room_no");
			sql.append(",decode(trn_type,'D',fr_bed_no,'L',fr_bed_no,to_bed_no) to_bed_no");
			sql.append(",decode(trn_type,'D',fr_practitioner_long_name,'L',fr_practitioner_short_name,to_practitioner_long_name) to_practitioner_short_name");
			sql.append(",decode(trn_type,'D',fr_specialty_short_desc,'L',fr_specialty_short_desc,to_specialty_short_desc) to_specialty_short_desc");
			sql.append(",remarks ");
			sql.append("from ip_adt_trn_vw ");
			sql.append("where  ");
			sql.append("encounter_id = ? and facility_id = ? ");
			sql.append("order by srl_no");
/*

			sql.append(" select ");
		    sql.append("to_char(trn_date_time,'dd/mm/yyyy hh24:mi') trn_date_time, ");
			sql.append("CASE WHEN trn_type,'D' THEN CASE WHEN A.FR_NURSING_UNIT_CODE IS NOT NULL THEN IP_GET_DESC.IP_NURSING_UNIT(A.FACILITY_ID,A.FR_NURSING_UNIT_CODE,?,'1') END,CASE WHEN trn_type ='L' THEN ");
			sql.append(" CASE WHEN A.FR_NURSING_UNIT_CODE IS NOT NULL THEN IP_GET_DESC.IP_NURSING_UNIT(A.FACILITY_ID,A.FR_NURSING_UNIT_CODE,?,'1') END, ELSE CASE WHEN A.TO_NURSING_UNIT IS NOT NULL THEN IP_GET_DESC.IP_NURSING_UNIT(A.FACILITY_ID,A.TO_NURSING_UNIT_CODE,?,'1') END");
			sql.append(",decode(trn_type,'D',fr_room_no,'L',fr_room_no,to_room_no) to_room_no");
			sql.append(",decode(trn_type,'D',fr_bed_no,'L',fr_bed_no,to_bed_no) to_bed_no");
			sql.append(",decode(trn_type,'D',fr_practitioner_long_name,'L',fr_practitioner_short_name,to_practitioner_long_name) to_practitioner_short_name");
			sql.append(",decode(trn_type,'D',fr_specialty_short_desc,'L',fr_specialty_short_desc,to_specialty_short_desc) to_specialty_short_desc");
			sql.append(",remarks ");
			sql.append("from ip_adt_trn_vw A ");
			sql.append("where  ");
			sql.append("encounter_id = ? and facility_id = ? ");
			sql.append("order by srl_no");
*/
			String className = "";
			int i=0;

			stmt	= con.prepareStatement(sql.toString());

			stmt.setString(1,episodeid);
			stmt.setString(2,facilityid);
			if(rs!=null)rs.close();
			rs = stmt.executeQuery();

			String remarks = "";
			String bed_no = "";
			String room_no  = "";
			String practioner_id = "";
			String strTrnDtTime	="";

			while(rs.next())
			{
				remarks = rs.getString("REMARKS");
				if(remarks == null) remarks = "&nbsp;";

				bed_no = rs.getString("to_bed_no");
				if(bed_no == null) bed_no = "&nbsp;";

				room_no = rs.getString("to_room_no");
				if(room_no == null) room_no = "&nbsp;";


				practioner_id = rs.getString("to_practitioner_short_name");
				if(practioner_id == null) practioner_id = "&nbsp;";

				strTrnDtTime	= rs.getString("TRN_DATE_TIME");
				if(strTrnDtTime == null) strTrnDtTime = "&nbsp;";

				if(!strTrnDtTime.equals("&nbsp;") )
					strTrnDtTime	=	com.ehis.util.DateUtils.convertDate(strTrnDtTime,"DMYHM","en",locale);

				if(i%2==0)
					className="gridData";
				else
					className="gridData";

				out.println("<tr><td class='gridData'>"+strTrnDtTime+"</font></td>");
				out.println("<td class='gridData'>"+rs.getString("to_nursing_unit_short_desc")+"</font></td>");
				out.println("<td class='gridData'>"+room_no+"</font></td>");
				out.println("<td class='gridData'>"+bed_no+"</font></td>");
				out.println("<td class='gridData'>"+practioner_id+"</font></td>");
				out.println("<td class='gridData'>"+rs.getString("to_specialty_short_desc")+"</font></td>");
				out.println("<td class='gridData'>"+remarks+"</font></td></tr>");
				i++;
			}
		}
		else
		{
	/*		sql.append(" select to_char(A.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') VISIT_REGN_DATE_TIME ");
			sql.append(" ,A.ENCOUNTER_ID EPISODE_ID ");
			sql.append(" ,1 VISIT_ID ");
			sql.append(" ,B.SHORT_DESC CLINIC_DESC ");
			sql.append(" ,A.ATTEND_PRACTITIONER_ID PHYSICIAN_ID ");
			sql.append(" ,d.practitioner_name practitioner_name  ");
			sql.append(" ,C.short_desc VISIT_TYPE_DESC, (select contact_reason from am_contact_reason where CONTACT_REASON_CODE =a.contact_reason_code) CONTACT_REASON ,(select DIAG_DESC from pr_problem where ONSET_ENCOUNTER_ID=a.ENCOUNTER_ID and ONSET_FACILITY_ID=a.FACILITY_ID and PRIMARY_YN='Y' and rownum=1) DIAG_DESC ");
			sql.append(" from PR_ENCOUNTER A ");
			sql.append(" ,OP_CLINIC B ");
			sql.append(" ,OP_VISIT_TYPE C ");
			sql.append(" ,am_practitioner d ");
			sql.append(" where d.practitioner_Id = a.ATTEND_PRACTITIONER_ID and A.PATIENT_ID = ? ");
			sql.append(" and A.ASSIGN_CARE_LOCN_CODE = B.CLINIC_CODE ");
			sql.append(" and A.VISIT_ADM_TYPE = C.VISIT_TYPE_CODE AND a.facility_id = ? and a.encounter_id=?");
    */
			sql.append(" select to_char(A.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') VISIT_REGN_DATE_TIME ");
			sql.append(" ,A.ENCOUNTER_ID EPISODE_ID ");
			sql.append(" ,1 VISIT_ID ");
			sql.append(" ,OP_GET_DESC.OP_CLINIC(?,A.ASSIGN_CARE_LOCN_CODE,?,'1') CLINIC_DESC ");
			sql.append(" ,A.ATTEND_PRACTITIONER_ID PHYSICIAN_ID ");
			sql.append(" ,OP_GET_DESC.OP_VISIT_TYPE(A.FACILITY_ID, A.VISIT_ADM_TYPE,?,'2')  VISIT_TYPE_DESC, AM_GET_DESC.AM_CONTACT_REASON(A.CONTACT_REASON_CODE,?,'1') CONTACT_REASON ,(select DIAG_DESC from pr_problem where ONSET_ENCOUNTER_ID=a.ENCOUNTER_ID and ONSET_FACILITY_ID=a.FACILITY_ID and PRIMARY_YN='Y' and rownum=1) DIAG_DESC "); 
			sql.append(" ,AM_GET_DESC.AM_CONTACT_REASON(A.CONTACT_REASON_CODE,?,'1') CONTACT_REASON ,(select DIAG_DESC from pr_problem where ONSET_ENCOUNTER_ID=a.ENCOUNTER_ID and ONSET_FACILITY_ID=a.FACILITY_ID and PRIMARY_YN='Y' and rownum=1) DIAG_DESC ");//modified for IN034514
			//sql.append(" from PR_ENCOUNTER A ");// commented for IN034514
			sql.append(" from PR_ENCOUNTER_VW A ");// modified for IN034514
			sql.append(" where  A.PATIENT_ID = ? AND a.facility_id = ? and a.encounter_id=? ");

//			out.println(sql);
			if(stmt != null) stmt.close();
			if(rs!= null) rs.close();
			stmt	= con.prepareStatement(sql.toString());

			stmt.setString(1,facilityid);
			stmt.setString(2,locale);
			stmt.setString(3,locale);
			stmt.setString(4,locale);
			stmt.setString(5,locale); 
			stmt.setString(6,patientid);
			stmt.setString(7,facilityid);
			stmt.setString(8,episodeid);

			rs = stmt.executeQuery();

			String strVisitRegnDtTime	=	"";

			if(rs.next())
			{
				strVisitRegnDtTime		=	rs.getString("VISIT_REGN_DATE_TIME");

				if(strVisitRegnDtTime == null)
					strVisitRegnDtTime	= "&nbsp;";

				if(!strVisitRegnDtTime.equals("&nbsp;"))
						strVisitRegnDtTime	= com.ehis.util.DateUtils.convertDate(strVisitRegnDtTime,"DMYHM","en",locale);

	
			%>
				<table class='grid' width='100%' align='center'>
				<tr><td class='columnHeader' colspan='4' ><fmt:message key="Common.VisitDetail.label" bundle="${common_labels}"/></td> </tr>
				<tr><td colspan="4"></td></tr>
				<tr>
					<td  class=LABEL><fmt:message key="Common.regndatetime.label" bundle="${common_labels}"/></td>
					<td class=DATA><%=strVisitRegnDtTime%></td>
					<td  class=LABEL><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
					<td class=DATA><%=rs.getString("EPISODE_ID")%></td>
				</tr>
				<tr>
					<td  class=LABEL><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></td>
					<td class=DATA><%=rs.getString("CLINIC_DESC")%></td>
					<td  class=LABEL><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
					<td class=DATA><%=rs.getString("PHYSICIAN_ID")==null?"":rs.getString("PHYSICIAN_ID")%></td> <!-- IN034514 -->
				</tr>
				<tr>
				 	<td  class=LABEL><fmt:message key="Common.visittype.label" bundle="${common_labels}"/></td>  
				 	<td class=DATA colspan=3><%=rs.getString("VISIT_TYPE_DESC")%></td> 
				</tr>
				<%
					contact_reason = rs.getString("contact_reason");
					diag_desc		=  rs.getString("diag_desc");
					if(contact_reason == null) contact_reason = "";
					if(diag_desc == null) diag_desc = "";

					if(!contact_reason.equals("") && !diag_desc.equals("")){%>
						<tr>
							<td  class='LABEL' width='20%'><fmt:message key="Common.Problem.label" bundle="${common_labels}"/></td>
							<td  class='DATA' colspan='3'><%=diag_desc%></td>
						</tr>
						<tr>
							<td  class='LABEL' width='20%'><fmt:message key="Common.ContactReason.label" bundle="${common_labels}"/></td>
							<td  class='DATA' colspan='3'><%=contact_reason%></td>
						</tr>

					<%}
				%>

				<tr><td colspan="4"></td></tr>
				</table>
			<%
			}
		}

		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
	}catch(Exception e){
			 // out.println(e);//COMMON-ICN-0181
			  e.printStackTrace();
	}
	finally
	{
		if(rs1 != null) rs1.close();
		if(rs2 != null) rs2.close();
		if(facIdrSet != null) facIdrSet.close(); // IN042564
		if(stmt1 != null) stmt1.close();
		if(stmt2 != null) stmt2.close();
		if(facIdpStmt != null) facIdpStmt.close(); // IN042564
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}
%>
</table>
</form>
</body>
</html>

