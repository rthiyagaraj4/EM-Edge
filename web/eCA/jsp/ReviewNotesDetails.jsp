<!DOCTYPE html>
<!-- 
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------------
?             100            ?           created
29/06/2012	  IN030468		Dinesh T	 BRUHIMS CRF.
16/07/2012	  IN033857		Dinesh T	 BRUHIMS CRF-Linked Issue
06/02/2013		IN037675	Dinesh T	IN037675
16/03/2013	IN038659		DineshT		Privilege level setup with sign is not working	
14/05/2013	IN038659-ForwardingNotes	vijayakumark 	We are not able to get all notes which are forwarded from 1 speciality to another speciality in the Practitioner's homepage ( Pending Notes Review )  as well as in the navigator under ( Review Notes ).
26/12/2013	IN046001		Ramesh G	Bru-HIMS-CRF-391-42552/11
18/03/2020	IN071264		Nijitha S	GHL-CRF-0604
--------------------------------------------------------------------------------------------------------------------
-->
<%@page import="java.sql.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<title><fmt:message key="eCA.ReviewNotes.label" bundle="${ca_labels}"/></title>

	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	

    <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language='javascript' src='../../eCA/js/ReviewNotes.js'></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
</head>
<%
	Connection con  = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String requested_to = "";
	
	try
	{
		con = ConnectionManager.getConnection(request);

		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");		
		String 	clinicianid	=	(String)	session.getValue("ca_practitioner_id");
		String	respid		=	(String)	session.getValue("responsibility_id");
		String	facilityid	=	(String)	session.getValue("facility_id");
		String notetypecode = request.getParameter("note_type_code")==null?"":request.getParameter("note_type_code");
		String patientId = request.getParameter("patientId")==null?"":request.getParameter("patientId");
		String fromDate =request.getParameter("fromDate")==null?"":request.getParameter("fromDate");
		String ToDate =request.getParameter("ToDate")==null?"":request.getParameter("ToDate");
		String requestedbyid = request.getParameter("requested_by_id")==null?"":request.getParameter("requested_by_id");
		String view = request.getParameter("view")==null?"ALL":request.getParameter("view");
		String reqFacility = request.getParameter("reqFacility")==null?"":request.getParameter("reqFacility");//IN030468
		fromDate = com.ehis.util.DateUtils.convertDate(fromDate,"DMY",locale,"en");
		ToDate = com.ehis.util.DateUtils.convertDate(ToDate,"DMY",locale,"en");

		requested_to = request.getParameter("requested_to");
		if(requested_to==null)
			requested_to = "P";
		//String code = "";
		//String desc = "";
		StringBuffer sql = new StringBuffer(); 
		String classValue = "";
		String prevnotetype = "";
		String value = "";
		String valueForNotes = "";
		String curr_patient_id = "";
		String curr_episode_id = "";
		//String list = "";
		String actionType ="",preActionType="";
		String action_by_group_code	="";
		String action_group_desc	="";
		String action_by_type		="";
		String facility_id			="";
		String request_date_time	="";
		String actionType1			="";
		String patient_class = "";
		String img = "";
		String doc_linked  = "";
		int i = 0;
%>
<form name="ReviewNotesDetails_form" id="ReviewNotesDetails_form" action="../../servlet/eCA.ReviewNotesServlet" method="post" target=messageFrame>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='content'>
<table  border="1" width="100%" cellspacing='0' cellpadding='3' align='center'>
	<td class='COLUMNHEADERCENTER' ><fmt:message key="Common.Reviewed.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADERCENTER'><fmt:message key="eCA.Subject.label" bundle="${ca_labels}"/></td>
	<td class='COLUMNHEADERCENTER'><fmt:message key="eCA.RequestedAt.label" bundle="${ca_labels}"/></td>
	<td class='COLUMNHEADERCENTER'><fmt:message key="Common.RequestedBy.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADERCENTER'><fmt:message key="Common.Requested.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/>
	<td class='COLUMNHEADERCENTER'><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADERCENTER'>&nbsp;</td>
	<td class='COLUMNHEADERCENTER'>&nbsp;&nbsp;</td>
	<%		if(sql.length() > 0) sql.delete(0,sql.length());
			
		/*	sql.append( " select a.note_type,CA_GET_DESC.CA_NOTE_TYPE(a.note_type,?,'1') note_type_desc, a.facility_id, a.accession_num ");
			sql.append( ", to_char(a.request_date_time,'dd/mm/yyyy hh24:mi') request_date_time ");
			sql.append( " ,a.request_by_id,AM_GET_DESC.AM_PRACTITIONER(a.request_by_id,?,'1') request_by_name ");
			sql.append( " ,get_patient.get_line_detail(a.facility_id,a.encounter_id,?) pline");
			sql.append( " ,b.privilege_type,a.patient_id patient_id, a.encounter_id encounter_id,a.ACTION_COMMENT subject,decode(PATIENT_CLASS,'OP','O','EM','O','I') EPISODE_TYPE,decode(a.action_type,'RS','Response','RV','Request','Forwarded to Specialty') action_type, ");
			sql.append("a.action_by_group_code action_group_code,a.action_by_type action_by_type, (select short_desc from am_speciality where speciality_code=a.action_by_group_code) action_group_desc ");
			sql.append( " from ca_encntr_note_audit_log_view a ");
			sql.append(" ,ca_note_type_for_resp b where a.action_status = 'RQ'");
			if (requested_to.equals("P"))
				sql.append(" and a.action_by_id = ? and a.action_type in ('RV','RS')  ");
			else if (requested_to.equals("S"))
				sql.append(" and a.ACTION_BY_GROUP_CODE = (select PRIMARY_SPECIALITY_CODE from am_practitioner where practitioner_id = ? ) ");
			else 
				sql.append(" and ( (a.action_by_id = ? and a.action_type in ('RV','RS') ) or a.ACTION_BY_GROUP_CODE = (select PRIMARY_SPECIALITY_CODE from am_practitioner where practitioner_id = ? ))");

			//sql.append( " where a.action_by_id = ? ");
			//sql.append(" and a.facility_id = ? "); //IN030468
			sql.append(" and a.event_status != '9'"); 
			sql.append(" and b.note_type = a.note_type "); 
			sql.append(" and b.resp_id = ? ");
			//sql.append(" and a.action_status = 'RQ' ");

			if(view.equals("ALL"))
			{
				sql.append(" and a.action_type in ('RV','RS','FS') ");
			}
			else if(view.equals("RS"))
			{
				sql.append(" and a.action_type = 'RS' ");
			}
			else if(view.equals("RQ"))
			{
				sql.append(" and a.action_type in ('RV','FS') ");
			}
			if(!notetypecode.equals(""))
			sql.append(" and a.note_type =? ");
			if(!requestedbyid.equals(""))
			sql.append(" and a.request_by_id = ? ");
			if(requested_to!=null && (requested_to.equalsIgnoreCase("P") || requested_to.equalsIgnoreCase("S")))
			{
				sql.append(" and a.action_by_type = ? ");
			}
			sql.append(" order by a.action_type,a.note_type_desc "); */
			
		// new 
		/*In Below query this condition is appended  decode(PATIENT_CLASS,'XT',get_patient.get_line_detail(c.patient_id,?) as  for new born cases the application shows blank for patient details.
		Added by Archana on 4/16/2010 at 9:31 AM for IN020707*/

			//sql.append(" SELECT c.note_type,ca_get_desc.ca_note_type (c.note_type, ?,'1') note_type_desc,nvl2(c.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, a.facility_id, a.accession_num,TO_CHAR (a.request_date_time, 'dd/mm/yyyy hh24:mi') request_date_time, a.request_by_id, am_get_desc.am_practitioner (a.request_by_id,?, '1' ) request_by_name,decode(PATIENT_CLASS,'XT',get_patient.get_line_detail(c.patient_id,?), get_patient.get_line_detail (a.facility_id, c.encounter_id, ? ) ) pline, b.privilege_type, c.patient_id patient_id, c.encounter_id encounter_id, a.action_comment subject, DECODE (c.patient_class, 'OP', 'O', 'EM', 'O', 'I') episode_type, DECODE (a.action_type, 'RS', 'Response', 'RV', 'Request', 'Forwarded to Specialty' ) action_type, a.action_by_group_code action_group_code, a.action_by_type action_by_type, am_get_desc.am_speciality (a.action_by_group_code,?,1) action_group_desc,c.patient_class patient_class  FROM ca_encntr_note_audit_log a, ca_encntr_note c,ca_note_type_for_resp b WHERE a.action_status = 'RQ' ");
			//IN038659-ForwardingNotes Start
			//sql.append(" SELECT c.note_type,ca_get_desc.ca_note_type (c.note_type, ?,'1') note_type_desc,nvl2(c.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, a.facility_id, a.accession_num,TO_CHAR (a.request_date_time, 'dd/mm/yyyy hh24:mi') request_date_time, a.request_by_id, am_get_desc.am_practitioner (a.request_by_id,?, '1' ) request_by_name,decode(PATIENT_CLASS,'XT',get_patient.get_line_detail(c.patient_id,?), get_patient.get_line_detail (c.facility_id, c.encounter_id, ? ) ) pline, b.privilege_type, c.patient_id patient_id, c.encounter_id encounter_id, a.action_comment subject, DECODE (c.patient_class, 'OP', 'O', 'EM', 'O', 'I') episode_type, DECODE (a.action_type, 'RS', 'Response', 'RV', 'Request', 'Forwarded to Specialty' ) action_type, a.action_by_group_code action_group_code, a.action_by_type action_by_type, am_get_desc.am_speciality (a.action_by_group_code,?,1) action_group_desc,c.patient_class patient_class  FROM ca_encntr_note_audit_log a, ca_encntr_note c,ca_note_type_for_resp b WHERE a.action_status = 'RQ' ");//DineshT 7/24/2012
			/*
			//IN038659-ForwardingNotes End.
			if (requested_to.equals("P"))
			{
				sql.append(" and a.action_by_id = ? and a.action_type in ('RV','RS')  ");
				//sql.append(" AND NVL (a.fwd_to_fac_id,DECODE ((SELECT fwd_pract_ind FROM ca_note_type WHERE note_type = b.note_type), 'A', '*', a.facility_id)) in (?,'*')");//IN037675
				sql.append(" AND NVL (a.fwd_to_fac_id,DECODE ((SELECT fwd_pract_ind FROM ca_note_type WHERE note_type = b.note_type), 'A', '*A','P','*A', a.facility_id)) in (?,'*A')");//IN038659
			}
			else if (requested_to.equals("S"))
			{
				sql.append(" and a.ACTION_BY_GROUP_CODE = (select PRIMARY_SPECIALITY_CODE from am_practitioner where practitioner_id = ? ) ");
				//sql.append(" AND NVL (a.fwd_to_fac_id,DECODE ((SELECT fwd_splty_ind FROM ca_note_type WHERE note_type = b.note_type), 'A', '*', a.facility_id)) in (?,'*')");//IN037675
				sql.append(" AND NVL (a.fwd_to_fac_id,DECODE ((SELECT fwd_splty_ind FROM ca_note_type WHERE note_type = b.note_type), 'A', '*A','P','*A', a.facility_id)) in (?,'*A')");//IN038659
			}
			else 
			{
				//sql.append(" and ( (a.action_by_id = ? and a.action_type in ('RV','RS') ) or a.ACTION_BY_GROUP_CODE = (select PRIMARY_SPECIALITY_CODE from am_practitioner where practitioner_id = ? ))");
				sql.append(" and a.action_by_id = ? and a.action_type in ('RV','RS')  ");//IN038659
				sql.append(" AND NVL (a.fwd_to_fac_id,DECODE ((SELECT fwd_pract_ind FROM ca_note_type WHERE note_type = b.note_type), 'A', '*A','P','*A', a.facility_id)) in (?,'*A')");//IN038659
				//sql.append(" or a.ACTION_BY_GROUP_CODE = (select PRIMARY_SPECIALITY_CODE from am_practitioner where practitioner_id = ? ) ");//IN038659
				//sql.append(" AND NVL (a.fwd_to_fac_id,DECODE ((SELECT fwd_splty_ind FROM ca_note_type WHERE note_type = b.note_type), 'A', '*A','P','*A', a.facility_id)) in (?,'*A')");//IN038659
			}
			
						 
			sql.append(" AND c.event_status in ('3','4','5')  and c.accession_num=a.accession_num AND b.note_type = c.note_type AND b.resp_id = ? ");//IN030468

			if(view.equals("ALL"))
			{
				sql.append(" and a.action_type in ('RV','RS','FS') ");
			}
			else if(view.equals("RS"))
			{
				sql.append(" and a.action_type = 'RS' ");
			}
			else if(view.equals("RQ"))
			{
				sql.append(" and a.action_type in ('RV','FS') ");
			}
			if(!notetypecode.equals(""))
			sql.append(" and c.note_type =? ");
			if(!requestedbyid.equals(""))
			sql.append(" and a.request_by_id = ? ");
			
			*/ //IN038659-ForwardingNotes
		/*	commendedt to fix SRR20056-SCF-3902 (16832)
			if(requested_to!=null && (requested_to.equalsIgnoreCase("P") || requested_to.equalsIgnoreCase("S")))
			{
			sql.append(" and a.action_by_type = ? ");
			}*/
			/*  //IN038659-ForwardingNotes
			if(!fromDate.equals("")&&(!ToDate.equals("")))
			{
				sql.append( " and a.request_date_time between to_date(?,'DD/MM/YYYY') and to_date(?,'DD/MM/YYYY')+.9999 ");
			}
			else if(!fromDate.equals("") && (ToDate.equals("")))
			{
				sql.append(" 	and a.request_date_time >= to_date( ?, 'DD/MM/YYYY' ) ");
			}
			else if(fromDate.equals("") && !ToDate.equals(""))
			{
				sql.append(" 	and a.request_date_time <= to_date( ?,'DD/MM/YYYY' )+.9999 ");
			}
			if(!patientId.equals(""))
			sql.append( "and c.patient_id =? ");
			//IN030468 starts
			if(!reqFacility.equals(""))
			sql.append("and a.facility_id = ?");
		//unable to see forwarded notes in other facility	
		
		*/  //IN038659-ForwardingNotes
		/*else
		{
			sql.append("and a.facility_id IN (SELECT b.facility_id facility_id FROM sm_facility_param a, sm_facility_for_user b WHERE a.facility_id = b.facility_id AND appl_user_id = ?)");
		}*/	
		
		//IN030468 ends//IN033857
		
			/********MODIFIED BY Deepa on 10/5/2009 at 2:22 PM for IN015076**************************/
			//sql.append(" ORDER BY a.action_type,2 ");
			
			// sql.append(" ORDER BY a.action_type,2,a.request_date_time desc ");  //IN038659-ForwardingNotes Start.
			/********MODIFIED BY Deepa on 10/5/2009 at 2:22 PM for IN015076**************************/

			/*  //IN038659-ForwardingNotes Start.
			pstmt=con.prepareStatement(sql.toString());

			//*********parameter binding
			int count=0;
			pstmt.setString(++count,locale);
			pstmt.setString(++count,locale);
			pstmt.setString(++count,locale);
			pstmt.setString(++count,locale);
			//Added by Archana on 4/16/2010 at 9:31 AM for IN020707.
			pstmt.setString(++count,locale);
			
			if (requested_to.equals("P")||requested_to.equals("S"))
			{
				pstmt.setString(++count,clinicianid);
				pstmt.setString(++count,(String)session.getValue("facility_id"));//IN037675
			}
			else
			{
				pstmt.setString(++count,clinicianid);
				pstmt.setString(++count,(String)session.getValue("facility_id"));//IN038659
				//pstmt.setString(++count,clinicianid);
				//pstmt.setString(++count,(String)session.getValue("facility_id"));//IN038659
			}
			//pstmt.setString(++count,clinicianid);
			//pstmt.setString(++count,(String) session.getValue("facility_id"));
			pstmt.setString(++count,respid);
			if(!notetypecode.equals(""))
				pstmt.setString(++count,notetypecode);
			if(!requestedbyid.equals(""))
				pstmt.setString(++count,requestedbyid); 
			*/  //IN038659-ForwardingNotes Start.
			/*if(requested_to!=null && (requested_to.equalsIgnoreCase("P") || requested_to.equalsIgnoreCase("S")))
			{
				pstmt.setString(++count,requested_to);
			}*/
			/*  //IN038659-ForwardingNotes Start.
			if(!fromDate.equals("")&&(!ToDate.equals("")))
			{
				pstmt.setString(++count,fromDate);
				pstmt.setString(++count,ToDate);
			}
			else if(!fromDate.equals("") && (ToDate.equals("")))
		  {
				pstmt.setString(++count,fromDate);
		  }
          else if(fromDate.equals("") && !ToDate.equals(""))
		  {
			pstmt.setString(++count,ToDate);
		  }

			if(!patientId.equals(""))
				pstmt.setString(++count,patientId);
			//IN030468 starts
			if(!reqFacility.equals(""))
				pstmt.setString(++count,reqFacility);
			*/ //IN038659-ForwardingNotes Start.
			/*else //unable to see forwarded notes in other facility
			{
				pstmt.setString(++count,clinicianid);
			}//IN030468 ends	*///IN033857
			
			//IN038659-ForwardingNotes starts
			if (requested_to.equals("P") || requested_to.equals("A"))
			{
			
				sql.append(" SELECT c.note_type,ca_get_desc.ca_note_type (c.note_type, ?,'1') note_type_desc,nvl2(c.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, a.facility_id, a.accession_num,TO_CHAR (a.request_date_time, 'dd/mm/yyyy hh24:mi') request_date_time, a.request_by_id, am_get_desc.am_practitioner (a.request_by_id,?, '1' ) request_by_name,decode(PATIENT_CLASS,'XT',get_patient.get_line_detail(c.patient_id,?), get_patient.get_line_detail (c.facility_id, c.encounter_id, ? ) ) pline, b.privilege_type, c.patient_id patient_id, c.encounter_id encounter_id, a.action_comment subject, DECODE (c.patient_class, 'OP', 'O', 'EM', 'O', 'I') episode_type, DECODE (a.action_type, 'RS', 'Response', 'RV', 'Request', 'Forwarded to Specialty' ) action_type, a.action_by_group_code action_group_code, a.action_by_type action_by_type, am_get_desc.am_speciality (a.action_by_group_code,?,1) action_group_desc,c.patient_class patient_class  FROM ca_encntr_note_audit_log a, ca_encntr_note c,ca_note_type_for_resp b WHERE a.action_status = 'RQ' ");
				//IN046001 Start.
				sql.append("  and nvl(ca_view_confidnt_event (c.facility_id,c.ENCOUNTER_ID,c.PATIENT_ID,c.accession_num,'CA',c.NOTE_TYPE,'CLNT','"+clinicianid+"','"+respid+"',c.PERFORMED_BY_ID,c.AUTHORIZED_BY_ID,null),'N')='Y' ");
				//IN046001 End.
				
				sql.append(" and a.action_by_id = ? and a.action_type in ('RV','RS')  ");
				sql.append(" AND NVL (a.fwd_to_fac_id,DECODE ((SELECT fwd_pract_ind FROM ca_note_type WHERE note_type = b.note_type), 'A', '*A','P','*A', a.facility_id)) in (?,'*A')");//IN038659
				
				sql.append(" AND c.event_status in ('3','4','5')  and c.accession_num=a.accession_num AND b.note_type = c.note_type AND b.resp_id = ? ");//IN030468

				if(!fromDate.equals("")&&(!ToDate.equals("")))
				{
					sql.append( " and a.request_date_time between to_date(?,'DD/MM/YYYY') and to_date(?,'DD/MM/YYYY')+.9999 ");
				}
				else if(!fromDate.equals("") && (ToDate.equals("")))
				{
					sql.append(" 	and a.request_date_time >= to_date( ?, 'DD/MM/YYYY' ) ");
				}
				else if(fromDate.equals("") && !ToDate.equals(""))
				{
					sql.append(" 	and a.request_date_time <= to_date( ?,'DD/MM/YYYY' )+.9999 ");
				}

				if(view.equals("ALL"))
				{
					sql.append(" and a.action_type in ('RV','RS','FS') ");
				}
				else if(view.equals("RS"))
				{
					sql.append(" and a.action_type = 'RS' ");
				}
				else if(view.equals("RQ"))
				{
					sql.append(" and a.action_type in ('RV','FS') ");
				}

				if(!notetypecode.equals(""))
				sql.append(" and c.note_type =? ");
				
				if(!requestedbyid.equals(""))
				sql.append(" and a.request_by_id = ? ");

				if(!patientId.equals(""))
				sql.append( "and c.patient_id =? ");
				
				//IN030468 starts
				if(!reqFacility.equals(""))
				sql.append("and a.facility_id = ?");

				
			}

			if(requested_to.equals("A"))
			{
				sql.append(" union all ");
			}			
			
			if (requested_to.equals("S") || requested_to.equals("A"))
			{
			
				sql.append(" SELECT c.note_type,ca_get_desc.ca_note_type (c.note_type, ?,'1') note_type_desc,nvl2(c.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, a.facility_id, a.accession_num,TO_CHAR (a.request_date_time, 'dd/mm/yyyy hh24:mi') request_date_time, a.request_by_id, am_get_desc.am_practitioner (a.request_by_id,?, '1' ) request_by_name,decode(PATIENT_CLASS,'XT',get_patient.get_line_detail(c.patient_id,?), get_patient.get_line_detail (c.facility_id, c.encounter_id, ? ) ) pline, b.privilege_type, c.patient_id patient_id, c.encounter_id encounter_id, a.action_comment subject, DECODE (c.patient_class, 'OP', 'O', 'EM', 'O', 'I') episode_type, DECODE (a.action_type, 'RS', 'Response', 'RV', 'Request', 'Forwarded to Specialty' ) action_type, a.action_by_group_code action_group_code, a.action_by_type action_by_type, am_get_desc.am_speciality (a.action_by_group_code,?,1) action_group_desc,c.patient_class patient_class  FROM ca_encntr_note_audit_log a, ca_encntr_note c,ca_note_type_for_resp b WHERE a.action_status = 'RQ' ");
				//IN046001 Start.
				sql.append("  and nvl(ca_view_confidnt_event (c.facility_id,c.ENCOUNTER_ID,c.PATIENT_ID,c.accession_num,'CA',c.NOTE_TYPE,'CLNT','"+clinicianid+"','"+respid+"',c.PERFORMED_BY_ID,c.AUTHORIZED_BY_ID,null),'N')='Y' ");
				//IN046001 End.
				sql.append(" and a.ACTION_BY_GROUP_CODE = (select PRIMARY_SPECIALITY_CODE from am_practitioner where practitioner_id = ? ) ");
				sql.append(" AND NVL (a.fwd_to_fac_id,DECODE ((SELECT fwd_splty_ind FROM ca_note_type WHERE note_type = b.note_type), 'A', '*A','P','*A', a.facility_id)) in (?,'*A') ");//IN038659
				
				sql.append(" AND c.event_status in ('3','4','5')  and c.accession_num=a.accession_num AND b.note_type = c.note_type AND b.resp_id = ? ");//IN030468

				if(!fromDate.equals("")&&(!ToDate.equals("")))
				{
					sql.append( " and a.request_date_time between to_date(?,'DD/MM/YYYY') and to_date(?,'DD/MM/YYYY')+.9999 ");
				}
				else if(!fromDate.equals("") && (ToDate.equals("")))
				{
					sql.append(" 	and a.request_date_time >= to_date( ?, 'DD/MM/YYYY' ) ");
				}
				else if(fromDate.equals("") && !ToDate.equals(""))
				{
					sql.append(" 	and a.request_date_time <= to_date( ?,'DD/MM/YYYY' )+.9999 ");
				}
				
				if(view.equals("ALL"))
				{
					sql.append(" and a.action_type in ('RV','RS','FS') ");
				}
				else if(view.equals("RS"))
				{
					sql.append(" and a.action_type = 'RS' ");
				}
				else if(view.equals("RQ"))
				{
					sql.append(" and a.action_type in ('RV','FS') ");
				}

				if(!notetypecode.equals(""))
				sql.append(" and c.note_type =? ");
				if(!requestedbyid.equals(""))
				sql.append(" and a.request_by_id = ? ");

				if(!patientId.equals(""))
				sql.append( " and c.patient_id =? ");
				//IN030468 starts
				if(!reqFacility.equals(""))
				sql.append(" and a.facility_id = ? ");

				
			}
			
			sql.append(" ORDER BY action_type,2,request_date_time desc ");
			
						
			System.out.println("Line No:173 ReviewNotesDetails.jsp sql>"+sql);
			pstmt=con.prepareStatement(sql.toString());

			//*********parameter binding
			int count=0;
			
			
			if (requested_to.equals("P") || requested_to.equals("A"))
			{
				pstmt.setString(++count,locale);
				pstmt.setString(++count,locale);
				pstmt.setString(++count,locale);
				pstmt.setString(++count,locale);
				//Added by Archana on 4/16/2010 at 9:31 AM for IN020707.
				pstmt.setString(++count,locale);
				pstmt.setString(++count,clinicianid);
				pstmt.setString(++count,facilityid);
				pstmt.setString(++count,respid);
				
				if(!fromDate.equals("")&&(!ToDate.equals("")))
				{
					pstmt.setString(++count,fromDate);
					
					pstmt.setString(++count,ToDate);
					
				}
				else if(!fromDate.equals("") && (ToDate.equals("")))
				{
					pstmt.setString(++count,fromDate);
					
				}
				else if(fromDate.equals("") && !ToDate.equals(""))
				{
					pstmt.setString(++count,ToDate);
					
				}
				
				if(!notetypecode.equals(""))
				{
				
					pstmt.setString(++count,notetypecode);
				}
				if(!requestedbyid.equals(""))
				{
				
					pstmt.setString(++count,requestedbyid);
				}
				if(!patientId.equals(""))
				{
				
					pstmt.setString(++count,patientId);
				}
				if(!reqFacility.equals(""))
				{
				
					pstmt.setString(++count,reqFacility);
				}
			}
			
			if(requested_to.equals("S") || requested_to.equals("A"))
			{
				pstmt.setString(++count,locale);
				pstmt.setString(++count,locale);
				pstmt.setString(++count,locale);
				pstmt.setString(++count,locale);
				pstmt.setString(++count,locale);
				pstmt.setString(++count,clinicianid);
				pstmt.setString(++count,facilityid);
				pstmt.setString(++count,respid);
				
				if(!fromDate.equals("")&&(!ToDate.equals("")))
			{
				pstmt.setString(++count,fromDate);
				
				pstmt.setString(++count,ToDate);
				
			}
			else if(!fromDate.equals("") && (ToDate.equals("")))
			{
				pstmt.setString(++count,fromDate);
				
			}
			else if(fromDate.equals("") && !ToDate.equals(""))
			{
				pstmt.setString(++count,ToDate);
				
			}
			
			if(!notetypecode.equals(""))
			{
				pstmt.setString(++count,notetypecode);
			}
			
			if(!requestedbyid.equals(""))
			{
				pstmt.setString(++count,requestedbyid);
			}

			if(!patientId.equals(""))
			{
				pstmt.setString(++count,patientId);
			}
			
			if(!reqFacility.equals(""))
			{
				pstmt.setString(++count,reqFacility);
			}
			}
			//IN038659-ForwardingNotes ends		
			
			rs = pstmt.executeQuery();
			
			while(rs != null && rs.next())
			{	
				if(i%2 == 0)
					classValue = "QRYEVEN";
				else
					classValue = "QRYODD";
				String patdetails = rs.getString("pline");
				if (patdetails== null) patdetails="";
				String notetypedesc = rs.getString("note_type_desc");
				if (notetypedesc== null) notetypedesc="";
			
				doc_linked						=			rs.getString("doc_linked")==null?"N":rs.getString("doc_linked");
							

				String	note_type	=	rs.getString("note_type");
				if (note_type== null) note_type="";
				
				img = "";
				if(doc_linked.equals("Y"))
				img = "<img src='../../eCA/images/DOCUL.gif' onClick='openDocWindow(\""+rs.getString("accession_num")+"\",\""+note_type+"\")' height='20' title='View Linked File' >";
				else
				img = "&nbsp;";

				String privilegetype = rs.getString("privilege_type");
				if (privilegetype== null) privilegetype="";
				curr_patient_id		=	rs.getString("patient_id");
				patient_class		=	rs.getString("patient_class") == null?"":rs.getString("patient_class");
				curr_episode_id 	=	rs.getString("encounter_id");
				String	subject	=	(rs.getString("subject")==null)?"&nbsp;":rs.getString("subject");
				String  requested_by_id = rs.getString("request_by_id")==null?"":rs.getString("request_by_id");
				action_by_group_code = rs.getString("action_group_code");
				if (action_by_group_code==null)
					action_by_group_code = "";
				action_group_desc = rs.getString("action_group_desc");
				if (action_group_desc==null)
					action_group_desc = "";
				action_by_type = rs.getString("action_by_type");
				if (action_by_type==null)
					action_by_type = "P";
				facility_id = rs.getString("facility_id");

				actionType = rs.getString("action_type");
				if(actionType.equals("Response"))
				{
					actionType1 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Response.label","common_labels");
				}
				else if(actionType.equals("Request"))
				{
					actionType1 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Request.label","common_labels");
				}
				else if(actionType.equals("Forwarded to Specialty"))
				{
					actionType1 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Forward.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.to.label","common_labels")+" "+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");
				}			
				
				request_date_time = rs.getString("request_date_time");
				if (request_date_time==null)
					request_date_time = "";
				if(!actionType.equals(preActionType))
					out.println("<tr><td class='gridData' colspan='13'><b>"+actionType1+"</b></td></tr>");
				if(!notetypedesc.equals(prevnotetype))
					out.println("<tr><td class='gridData' colspan='13' ><b>"+notetypedesc+"</b></td></tr>");
				patdetails = patdetails.replace('|',',');

				value = privilegetype+"~"+rs.getString("accession_num")+"~"+clinicianid+"~"+rs.getString("facility_id")+"~"+rs.getString("note_type_desc")+"~"+requested_by_id+"~"+action_by_type+"~"+curr_patient_id+"~"+curr_episode_id+"~"+note_type;// Added patient id,encounter id, note type for IN071264
				

				if(actionType.equals("Response"))
					value = value + "P";

				/**********/
				valueForNotes = privilegetype+"~"+rs.getString("accession_num")+"~"+clinicianid+"~"+rs.getString("facility_id")+"~"+notetypedesc+"~"+note_type+"~"+curr_patient_id+"~"+curr_episode_id+"~"+rs.getString("EPISODE_TYPE")+"~"+patient_class;
				/*********/

				out.println("<tr><td class='gridData' ><input type='checkbox' name='chk_"+i+"' id='chk_"+i+"' value='"+value+"' onClick =\"callSendBackWindow(this,'"+i+"','"+actionType+"')\" ></td>");
				out.println("<td class='gridData'>"+ subject 	+"</td>");
				out.println("<td class='gridData' > "+com.ehis.util.DateUtils.convertDate(rs.getString("request_date_time"),"DMYHM","en",locale)+"</td>");
				out.println("<td class='gridData' >"+rs.getString("request_by_name")+"</td>");
				if(action_by_type.equals("") || action_by_type.equalsIgnoreCase("P"))
				{
					out.println("<td class='gridData'  >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.self.label","common_labels")+"</td>");
				}
				else if(action_by_type.equalsIgnoreCase("S"))
				{
					out.println("<td class='gridData' >("+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+" :"+action_group_desc+")</td>");
				}

				out.println("<td class='gridData'>"+patdetails+"</td>");
				out.println("<td class='gridData'>"+img+"</td>");
				out.println("<td class='gridData'><a class='gridLink'  href=\"javascript:showDetails(escape(document.forms[0].valueForNotes"+i+".value))\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.view.label","common_labels")+"</a><input type='hidden' name= 'value"+i+"' value=\""+value+"\"><input type='hidden' name='valueForNotes"+i+"' id='valueForNotes"+i+"' value=\""+valueForNotes+"\"></td></tr>");
				i++;
				
				prevnotetype=notetypedesc;
				preActionType = actionType;
			}%>
				<script>if(parent.ReviewNotesCriteriaFrame.document.getElementById("search")!=null)
				parent.ReviewNotesCriteriaFrame.document.getElementById("search").disabled=false;</script>
			<%

			 if(i==0){ %>
		<Script language=javascript>
		alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
		</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



		  <%}
	%>
</table>
</body>
<input type="hidden" name="noofrec" id="noofrec" value="<%=i%>">
<input type="hidden" name="facility_id" id="facility_id" value="<%=facilityid%>">
<input type="hidden" name="final_values" id="final_values" value="">
<input type='hidden' name='requested_to' id='requested_to' value="<%=requested_to%>">
<!--this remarks hidden will be used only for one entry at a time-->
<input type="hidden" name="remarks" id="remarks" value="">
</form>
<%	 if(rs != null) rs.close();
         if(pstmt != null) pstmt.close();
        
	}
	catch (Exception e)	
	{
		
        e.printStackTrace() ;
		//out.println(e);
	}
	finally    {
	
		 if(con!=null)
			 ConnectionManager.returnConnection(con,request);
    }
%>
</html>

