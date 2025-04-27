<!DOCTYPE html>
<!-- 
--------------------------------------------------------------------------------------------------------------------
Date       	Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------------
?             	100            	?           created
29/06/2012	  	IN030468		Dinesh T	 BRUHIMS CRF.
16/07/2012	  	IN033857		Dinesh T	 BRUHIMS CRF.
06/02/2013		IN037675		Dinesh T	IN037675
16/03/2013		IN038659		DineshT		Privilege level setup with sign is not working		
05/11/2013		IN044763		Karthi L	System Displaying Wrong count of Pending review notes, while login practitioner with other facility
------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History     Name        	Rev.Date		Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------
22/04/2014		IN047254		Karthi L		22/04/2014		Ramesh			Issue as regards to forwarding these confidentiality notes.
																				In the FD document it was stated that these notes should not be forwarded to any one who does not have access.
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
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCA/js/ReviewNotes.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
	Connection con  = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	try
	{
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
		con = ConnectionManager.getConnection(request);

		String requestedbyid		= request.getParameter("requested_by_id")==null?"":request.getParameter("requested_by_id");
		
		String requested_to = "";
		
		requested_to = request.getParameter("requested_to");
		if(requested_to==null)
			requested_to = "P";
		
		String view					= request.getParameter("view")==null?"ALL":request.getParameter("view");

		String 	clinicianid			= (String)	session.getValue("ca_practitioner_id");
		String	respid				= (String)	session.getValue("responsibility_id");
		String	faciltyid				= (String) session.getValue("facility_id");

		String code = "";
		String desc = "";
		StringBuffer sql = new StringBuffer();
		String classValue = "";

		String fromDate =request.getParameter("fromDate")==null?"":request.getParameter("fromDate");
		String ToDate =request.getParameter("ToDate")==null?"":request.getParameter("ToDate");
		String patientId = request.getParameter("patientId")==null?"":request.getParameter("patientId");
		String reqFacility = request.getParameter("reqFacility")==null?"":request.getParameter("reqFacility");//IN030468
		fromDate = com.ehis.util.DateUtils.convertDate(fromDate,"DMY",locale,"en");
		ToDate = com.ehis.util.DateUtils.convertDate(ToDate,"DMY",locale,"en");

		int i = 1;
		int total = 0;

%>
<form name="ReviewNotesTree_form" id="ReviewNotesTree_form">
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='content'>
<table  border="1" width="100%" cellspacing='0' cellpadding='3' align='center' id='tb1'>
<td class='COLUMNHEADERCENTER'><fmt:message key="eCA.NoteTypes.label" bundle="${ca_labels}"/></td>

<%		
	
		if(requested_to.equals("P"))
		{
			sql.append("select b.note_type, e.note_type_desc, count(*) grptot from ca_encntr_note_audit_log a, ca_encntr_note c,ca_note_type_for_resp b, ca_note_type_lang_vw e  WHERE a.action_status = 'RQ' " );
			if(view.equals("ALL"))
			{
				sql.append(" and a.action_type in ('RV','RS') ");
			}
			else if(view.equals("RS"))
			{
				sql.append(" and a.action_type = 'RS' ");
			}
			else if(view.equals("RQ"))
			{
				sql.append(" and a.action_type in ('RV','FS') ");
			}
			if (!patientId.equals(""))
				sql.append(" and c.patient_id=? ");
			if(!requestedbyid.equals(""))
				sql.append(" and a.request_by_id = ? ");
			sql.append(" AND a.action_by_id = ?  AND c.event_status IN ('3', '4', '5') AND c.accession_num = a.accession_num AND b.note_type = c.note_type AND b.resp_id = ? AND E.LANGUAGE_ID=? and e.note_type=b.note_type AND a.request_date_time BETWEEN to_date(?,'dd/mm/yyyy') AND to_date(?,'dd/mm/yyyy')+.9999  ");//IN030468 
			//IN030468 starts
			if(!reqFacility.equals(""))
				sql.append(" and a.facility_id = ? ");
			//sql.append(" and NVL (a.fwd_to_fac_id,DECODE ((SELECT fwd_splty_ind FROM ca_note_type WHERE note_type = b.note_type), 'A', '*', a.facility_id)) in (?,'*')");//IN037675
			sql.append(" and NVL (a.fwd_to_fac_id,DECODE ((SELECT fwd_pract_ind FROM ca_note_type WHERE note_type = b.note_type), 'A', '*A','P','*A', a.facility_id)) in (?,'*A')");//IN038659
			/*else //Chowminya
			{
				sql.append("and a.facility_id IN (SELECT b.facility_id facility_id FROM sm_facility_param a, sm_facility_for_user b WHERE a.facility_id = b.facility_id AND appl_user_id = ?)");
			}//IN030468 ends*///IN033857
			sql.append(" and 'Y' = ca_view_confidnt_event (c.facility_id, c.encounter_id, c.patient_id, c.accession_num, 'CA', c.note_type, 'CLNT', ?, ?, c.PERFORMED_BY_ID, c.AUTHORIZED_BY_ID, NULL)"); // added for IN047254
			sql.append(" GROUP BY b.note_type, e.note_type_desc");
		}
		else if(requested_to.equals("S"))
		{
			sql.append(" select b.note_type, e.note_type_desc, count(*) grptot from ca_encntr_note_audit_log a, ca_encntr_note c,ca_note_type_for_resp b, ca_note_type_lang_vw e WHERE a.action_status = 'RQ' " );
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
			if (!patientId.equals(""))
				sql.append(" and c.patient_id=? ");
			if(!requestedbyid.equals(""))
				sql.append(" and a.request_by_id = ? ");
			sql.append("AND  a.action_by_group_code = (select PRIMARY_SPECIALITY_CODE from am_practitioner where practitioner_id=?) AND c.event_status IN ('3', '4', '5') AND c.accession_num = a.accession_num AND b.note_type = c.note_type AND b.resp_id = ? AND E.LANGUAGE_ID=? and e.note_type=b.note_type AND a.request_date_time BETWEEN to_date(?,'dd/mm/yyyy') AND to_date(?,'dd/mm/yyyy')+.9999 ");//IN030468 
			//IN030468 starts
			if(!reqFacility.equals(""))
				sql.append(" and a.facility_id = ? ");			
			//sql.append("and NVL (a.fwd_to_fac_id,DECODE ((SELECT fwd_splty_ind FROM ca_note_type WHERE note_type = b.note_type), 'A', '*', a.facility_id)) in (?,'*')");//IN037675
			sql.append("and NVL (a.fwd_to_fac_id,DECODE ((SELECT fwd_splty_ind FROM ca_note_type WHERE note_type = b.note_type), 'A', '*A','P','*A', a.facility_id)) in (?,'*A')");//IN038659
			/*else //unable to see forwarded notes in other facility
			{
				sql.append("and a.facility_id IN (SELECT b.facility_id facility_id FROM sm_facility_param a, sm_facility_for_user b WHERE a.facility_id = b.facility_id AND appl_user_id = ?)");
			}//IN030468 ends//IN033857
			*/
			sql.append(" and 'Y' = ca_view_confidnt_event (c.facility_id, c.encounter_id, c.patient_id, c.accession_num, 'CA', c.note_type, 'CLNT', ?, ?, c.PERFORMED_BY_ID, c.AUTHORIZED_BY_ID, NULL)"); // added for IN047254
			sql.append(" GROUP BY b.note_type, e.note_type_desc " );
		}
		else
		{
			sql.append(" Select note_type, note_type_desc, sum(grptot) grptot from ( ");
			sql.append( "select b.note_type, e.note_type_desc, count(*) grptot from ca_encntr_note_audit_log a, ca_encntr_note c,ca_note_type_for_resp b, ca_note_type_lang_vw e  WHERE a.action_status = 'RQ' " );
			if(view.equals("ALL"))
			{
				sql.append(" and a.action_type in ('RV','RS') ");
			}
			else if(view.equals("RS"))
			{
				sql.append(" and a.action_type = 'RS' ");
			}
			else if(view.equals("RQ"))
			{
				sql.append(" and a.action_type in ('RV','FS') ");
			}
			if (!patientId.equals(""))
				sql.append(" and c.patient_id=? ");
			if(!requestedbyid.equals(""))
				sql.append(" and a.request_by_id = ? ");
			sql.append(" AND a.action_by_id = ? AND c.event_status IN ('3', '4', '5') AND c.accession_num = a.accession_num AND b.note_type = c.note_type AND b.resp_id = ? AND E.LANGUAGE_ID=? and e.note_type=b.note_type AND a.request_date_time BETWEEN to_date(?,'dd/mm/yyyy') AND to_date(?,'dd/mm/yyyy')+.9999 ");
			//IN030468 starts
			if(!reqFacility.equals(""))
				sql.append(" and a.facility_id = ? ");
			//sql.append(" and NVL (a.fwd_to_fac_id,DECODE ((SELECT fwd_pract_ind FROM ca_note_type WHERE note_type = b.note_type), 'A', '*', a.facility_id)) in (?,'*') ");//IN037675
			//sql.append(" and NVL (a.fwd_to_fac_id,DECODE ((SELECT fwd_pract_ind FROM ca_note_type WHERE note_type = b.note_type), 'A', '*A','P','*A', a.facility_id)) in (?,'*A')  ");//IN038659 // commented for IN047254 
			sql.append(" and NVL (a.fwd_to_fac_id,DECODE ((SELECT fwd_pract_ind FROM ca_note_type WHERE note_type = b.note_type), 'A', '*A','P','*A', a.facility_id)) in (?,'*A')  AND 'Y' = ca_view_confidnt_event (a.facility_id, c.encounter_id, c.patient_id, a.accession_num,'CA', c.note_type,'CLNT',?,?, c.PERFORMED_BY_ID, c.AUTHORIZED_BY_ID, NULL) ");// added for IN047254			
			/*else //Chowminya
			{
				sql.append("and a.facility_id IN (SELECT b.facility_id facility_id FROM sm_facility_param a, sm_facility_for_user b WHERE a.facility_id = b.facility_id AND appl_user_id = ?)");
			}//IN030468 ends//IN033857
			*/
			sql.append(" GROUP BY b.note_type, e.note_type_desc " );
			sql.append(" union all ");
			sql.append( " select b.note_type, e.note_type_desc, count(*) grptot from ca_encntr_note_audit_log a, ca_encntr_note c,ca_note_type_for_resp b, ca_note_type_lang_vw e WHERE a.action_status = 'RQ' " );
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
			if (!patientId.equals(""))
				sql.append(" and c.patient_id=? ");
			if(!requestedbyid.equals(""))
				sql.append(" and a.request_by_id = ? ");
			sql.append("AND  a.action_by_group_code = (select PRIMARY_SPECIALITY_CODE from am_practitioner where practitioner_id=?) AND c.event_status IN ('3', '4', '5') AND c.accession_num = a.accession_num AND b.note_type = c.note_type AND b.resp_id = ? AND E.LANGUAGE_ID=? and e.note_type=b.note_type  AND a.request_date_time BETWEEN to_date(?,'dd/mm/yyyy') AND to_date(?,'dd/mm/yyyy')+.9999 ");//IN030468
			//IN030468 starts
			if(!reqFacility.equals(""))
			sql.append(" and a.facility_id = ? ");
			//sql.append(" and NVL (a.fwd_to_fac_id,DECODE ((SELECT fwd_splty_ind FROM ca_note_type WHERE note_type = b.note_type), 'A', '*', a.facility_id)) in (?,'*') ");//IN037675
			sql.append(" and NVL (a.fwd_to_fac_id,DECODE ((SELECT fwd_splty_ind FROM ca_note_type WHERE note_type = b.note_type), 'A', '*A','P','*A', a.facility_id)) in (?,'*A') ");//IN038659
			/*else //Chowminya
			{
				sql.append("and a.facility_id IN (SELECT b.facility_id facility_id FROM sm_facility_param a, sm_facility_for_user b WHERE a.facility_id = b.facility_id AND appl_user_id = ?)");
			}
			//IN030468 ends
			*///IN033857
			sql.append(" AND 'Y' = ca_view_confidnt_event (a.facility_id, c.encounter_id, c.patient_id, a.accession_num,'CA', c.note_type,'CLNT',?,?, c.PERFORMED_BY_ID, c.AUTHORIZED_BY_ID, NULL)"); // added for IN047254
			sql.append(" GROUP BY b.note_type, e.note_type_desc ");
			sql.append(" ) GROUP BY note_type, note_type_desc  ");
		}

		sql.append(" ORDER BY 2 ");
		

		int position=0;
		pstmt=con.prepareStatement(sql.toString());			
		
		if (!patientId.equals(""))
			pstmt.setString(++position,patientId);	
		if(!requestedbyid.equals(""))
					pstmt.setString(++position,requestedbyid);	
		pstmt.setString(++position,clinicianid);	
		//pstmt.setString(++position,faciltyid);	
		pstmt.setString(++position,respid);
		pstmt.setString(++position,locale);
		pstmt.setString(++position,fromDate);
		pstmt.setString(++position,ToDate);
		//IN030468 starts
		if(!requested_to.equals("A"))
		{
			if(!reqFacility.equals(""))
				pstmt.setString(++position,reqFacility);
			/*else //Chowminya
			{
				pstmt.setString(++position,clinicianid);
			}	*///IN033857
			pstmt.setString(++position,faciltyid);//added for IN044763
			pstmt.setString(++position,clinicianid); // added for IN047254
			pstmt.setString(++position,respid); // added for IN047254
		}//IN030468 ends
		//pstmt.setString(++position,faciltyid);//IN037675 Commented for IN044763
		if(requested_to.equals("A"))
		{
			//IN030468 starts
			if(!reqFacility.equals(""))
				pstmt.setString(++position,reqFacility);
		/*	else //Chowminya
			{
				pstmt.setString(++position,clinicianid);
			}//IN030468 ends*///IN033857
			
			pstmt.setString(++position,faciltyid);//added for IN044763
			pstmt.setString(++position,clinicianid); // added for IN047254
			pstmt.setString(++position,respid); // added for IN047254
			if (!patientId.equals(""))
				pstmt.setString(++position,patientId);
			if(!requestedbyid.equals(""))
				pstmt.setString(++position,requestedbyid);				
			pstmt.setString(++position,clinicianid);	
			//pstmt.setString(++position,faciltyid);	
			pstmt.setString(++position,respid);
			pstmt.setString(++position,locale );
			pstmt.setString(++position,fromDate);
			pstmt.setString(++position,ToDate);					
			//IN030468 starts
			if(!reqFacility.equals(""))
			pstmt.setString(++position,reqFacility);
			pstmt.setString(++position,faciltyid);//IN037675
			
			pstmt.setString(++position,clinicianid); // added for IN047254
			pstmt.setString(++position,respid); // added for IN047254
			
			/*else //Chowminya
			{
				pstmt.setString(++position,clinicianid);
			}//IN030468 ends	
			*///IN033857
		
		}
			
		
		fromDate = com.ehis.util.DateUtils.convertDate(fromDate,"DMY","en",locale);
		ToDate = com.ehis.util.DateUtils.convertDate(ToDate,"DMY","en",locale);
		rs = pstmt.executeQuery();

		while(rs != null && rs.next())
		{
			if(i%2 == 0)
				classValue = "QRYEVEN";
			else
				classValue = "QRYODD";
			code = rs.getString("note_type");
			desc = rs.getString("note_type_desc");
							
			i++;
			total =total+rs.getInt("grptot");
			out.println("<tr><td class='"+classValue+"'><a name='"+i+"' href=\"javascript:filterNShowDetails('"+code+"','"+requestedbyid+"','"+requested_to+"','"+fromDate+"','"+ToDate+"','"+reqFacility+"','"+total+"')\"><font size=1>"+desc+"</a><b>&nbsp;("+rs.getInt("grptot")+")</b></font></td></tr>");//IN033857
		}
		if(i%2 == 0)
				classValue = "QRYEVEN";
		else
				classValue = "QRYODD";
		out.println("<tr><td class='CAGROUP' ><a name='"+i+"' href=\"javascript:filterNShowDetails('','"+requestedbyid+"','"+requested_to+"','"+fromDate+"','"+ToDate+"','"+reqFacility+"','"+total+"')\"><font size=1>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+"</a>&nbsp;<b>("+total+")</font></td></tr>");//IN033857
	%>
</table>
	<input type="hidden" name="patient_id" id="patient_id" value="<%=patientId%>">
</body>
</form>
<%	
	if(rs != null) rs.close();
    if(pstmt != null) pstmt.close();
	}
	catch (Exception e)	
	{
		//out.println(e);//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
	finally   
	{
	
        if(con!=null)
			ConnectionManager.returnConnection(con,request);
    }
%>
</html>

