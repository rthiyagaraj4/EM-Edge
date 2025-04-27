<!DOCTYPE html>
<!-- 
--------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date	Rev.Name	Description
--------------------------------------------------------------------------------------------------------------------
?             	100            		?		created
06/02/2013	IN037675			Dinesh T	IN037675
27/02/2013	IN038176		DineshT		Privilege level setup with sign is not working		
16/03/2013	IN038659		DineshT		Privilege level setup with sign is not working		
15/09/2015  IN057492		Vijayakumar K	16/09/2015	Dinesh T	PMG2015-CRF-AAKH-CA-0001
01-FEB-2015 INT-CA004_CA	RAJA S									Script Error found issue which checking IE11 in Patient Assessment
05/06/2018	IN67872			Dinesh T		05/06/2018	Ramesh G		GHL-CRF-0497.1	
--------------------------------------------------------------------------------------------------------------------
-->
<%@page import="java.sql.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<title><fmt:message key="eCA.SignNotes.label" bundle="${ca_labels}"/></title>
	
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	

    <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language='javascript' src='../../eCA/js/SignNotes.js'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	Connection con  = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try
	{
		con = ConnectionManager.getConnection(request);
		Properties p = (Properties)session.getValue("jdbc");
		String locale				= (String) p.getProperty("LOCALE");
		//Added By Archana Dhal on 22/01/2010 related to IN18229.
		String requestedbyid = request.getParameter("requested_by_id")==null?"":(String)request.getParameter("requested_by_id");
		if (requestedbyid.equals("ALL")) requestedbyid="";
	//	String	respid		=	(String)	session.getValue("responsibility_id");

		
		String 	clinicianid	=	(String)	session.getValue("ca_practitioner_id");
		String 	userid	=	(String)	session.getValue("login_user");
		String	facilityid	=	(String)	session.getValue("facility_id");
		String	respid		=	(String)	session.getValue("responsibility_id");
		
		String fromDate =request.getParameter("fromDate")==null?"":request.getParameter("fromDate");
		String ToDate =request.getParameter("ToDate")==null?"":request.getParameter("ToDate");
		String patientId = request.getParameter("patientId")==null?"":request.getParameter("patientId");
		String p_called_func =request.getParameter("p_called_func")==null?"":request.getParameter("p_called_func"); //IN057492

		/*Added by Deepa on 2/1/2010 at 10:52 AM for IN018729*/
		/*to pass the date that is NOT converted, to the next page*/
		String fromDateParam = fromDate;
		String ToDateParam = ToDate;
		/*Added by Deepa on 2/1/2010 at 10:52 AM for IN018729*/	

		//Start Added by Sridhar Reddy on 20/01/2009 PMGCRF0359 For Frame Reference in Servlet
		String option_id =request.getParameter("option_id")==null?"":request.getParameter("option_id");
		//End

		if (ToDate.equals(""))
			ToDate = com.ehis.util.DateUtils.getCurrentDate("DMY",locale);

		/*Added by Deepa on 2/1/2010 at 10:52 AM for IN018729*/
		/*converted the date to english, that has to be passed to the query*/

		fromDate = com.ehis.util.DateUtils.convertDate(fromDate,"DMY",locale,"en");
	    ToDate = com.ehis.util.DateUtils.convertDate(ToDate,"DMY",locale,"en");

		/*Added by Deepa on 2/1/2010 at 10:52 AM for IN018729*/		

		String code = "";
		String desc = "";

		StringBuffer sql =new StringBuffer();
		String gridData = "";
		int i = 1;
		int total = 0;
%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='content'>
<form name="SignNotesTree_form" id="SignNotesTree_form">
<table  width="100%" class='grid' align='center' id='tb1'>
 	<td class='COLUMNHEADERCENTER'><fmt:message key="Common.NoteType.label" bundle="${common_labels}"/></td>
	<%		if(sql.length() > 0) sql.delete(0,sql.length());
			/*
			sql.append(" select note_type,note_type_desc, ");
			sql.append(" sum(grptot)  grptot ");
			sql.append(" from  ( ");

			sql.append(" select a.note_type, a.note_type_desc, count(*) grptot ");
			sql.append(" from ca_encntr_note_audit_log_view a, ca_note_type_for_resp b ");
			sql.append(" where facility_id=? ");
			sql.append(	" and a.action_type = 'SN' and a.ACTION_STATUS ='RQ' ");
			sql.append(" and a.action_by_id = ? and a.note_type=b.note_type ");
			if(!requestedbyid.equals(""))
			sql.append(" and a.request_by_id = ? ");
			sql.append("and b.resp_id =? group by a.note_type,a.note_type_desc ");

			sql.append(" union all ");
			sql.append(" select  c.note_type , b.note_type_desc ");
			sql.append(" , count(*) grptot  from ca_encntr_note c ,ca_note_type b,ca_note_type_for_resp a ");
			sql.append("  where  c.facility_id=?  and c.event_status='1' ");
			sql.append("  and c.added_by_id = ? ");
			if(!requestedbyid.equals(""))
			 sql.append(" and c.performed_by_id = ? ");
				sql.append(" and b.note_type=c.note_type and a.resp_id =? and a.note_type=c.note_type ");
			sql.append(" group by c.note_type ");
			sql.append(" , b.note_type_desc ");
			sql.append(" )  ");
			sql.append(" group by note_type,note_type_desc ");
			*/

			/*sql.append(" select note_type,note_type_desc, ");
			sql.append(" sum(grptot)  grptot ");
			sql.append(" from  ( ");

			sql.append(" select a.note_type, CA_GET_DESC.CA_NOTE_TYPE(a.note_type,?,'1') note_type_desc, count(*) grptot ");
			sql.append(" from ca_encntr_note_audit_log_view a, ca_note_type_for_resp b ");
			sql.append(" where facility_id=? ");
			sql.append(	" and a.action_type = 'SN' and a.ACTION_STATUS ='RQ' ");
			sql.append(" and a.action_by_id = ? and a.note_type=b.note_type ");
			if(!requestedbyid.equals(""))
			sql.append(" and a.request_by_id = ? ");
			sql.append("and b.resp_id =? group by a.note_type,a.note_type_desc ");

			sql.append(" union all ");
			sql.append(" select  c.note_type , b.note_type_desc ");
			sql.append(" , count(*) grptot  from ca_encntr_note c ,ca_note_type_lang_vw  b,ca_note_type_for_resp a ");
			sql.append("  where  c.facility_id=?  and c.event_status='1' ");
			sql.append("  and c.added_by_id = ? ");
			if(!requestedbyid.equals(""))
			 sql.append(" and c.performed_by_id = ? ");
				sql.append(" and b.note_type=c.note_type and b.language_id = ? and a.resp_id =? and a.note_type=c.note_type ");
			sql.append(" group by c.note_type ");
			sql.append(" , b.note_type_desc ");
			sql.append(" )  ");
			sql.append(" group by note_type,note_type_desc ");

			*/
	/*		fromDate = "";
			ToDate = "";  */
			//sql.append("SELECT oa.note_type, ca_get_desc.ca_note_type(oa.note_type,?,1) note_type_desc, SUM (grptot) grptot FROM (SELECT   d.note_type, COUNT (*) grptot FROM ca_encntr_note_audit_log a, CA_ENCNTR_NOTE D,ca_note_type_for_resp b WHERE a.facility_id = ? AND a.action_type = 'SN' AND a.action_status = 'RQ' AND a.action_by_id = ? and d.facility_id=a.FACILITY_ID and d.ACCESSION_NUM=a.ACCESSION_NUM and D.event_status !=9 AND b.note_type = d.note_type AND b.resp_id = ? ");//IN037675
			//sql.append("SELECT oa.note_type, ca_get_desc.ca_note_type(oa.note_type,?,1) note_type_desc, SUM (grptot) grptot FROM (SELECT   d.note_type, COUNT (*) grptot FROM ca_encntr_note_audit_log a, CA_ENCNTR_NOTE D,ca_note_type_for_resp b WHERE a.facility_id = ? AND a.action_type = 'SN' AND a.action_status = 'RQ' AND a.action_by_id = ? and d.facility_id=a.FACILITY_ID and d.ACCESSION_NUM=a.ACCESSION_NUM and D.event_status !=9 AND b.note_type = d.note_type AND b.resp_id = ? and NVL (a.fwd_to_fac_id,DECODE ((SELECT fwd_pract_ind FROM ca_note_type WHERE note_type = b.note_type), 'A', '*', a.facility_id)) in (?,'*')");//IN037675//IN038176
			//sql.append("SELECT oa.note_type, ca_get_desc.ca_note_type(oa.note_type,?,1) note_type_desc, SUM (grptot) grptot FROM (SELECT   d.note_type, COUNT (*) grptot FROM ca_encntr_note_audit_log a, CA_ENCNTR_NOTE D,ca_note_type_for_resp b WHERE a.FWD_TO_FAC_ID = ? AND a.action_type = 'SN' AND a.action_status = 'RQ' AND a.action_by_id = ? and d.facility_id=a.FACILITY_ID and d.ACCESSION_NUM=a.ACCESSION_NUM and D.event_status !=9 AND b.note_type = d.note_type AND b.resp_id = ? and NVL (a.fwd_to_fac_id,DECODE ((SELECT fwd_pract_ind FROM ca_note_type WHERE note_type = b.note_type), 'A', '*', a.facility_id)) in (?,'*')");//IN037675//IN038176
			//sql.append("SELECT oa.note_type, ca_get_desc.ca_note_type(oa.note_type,?,1) note_type_desc, SUM (grptot) grptot FROM (SELECT   d.note_type, COUNT (*) grptot FROM ca_encntr_note_audit_log a, CA_ENCNTR_NOTE D,ca_note_type_for_resp b WHERE a.action_type = 'SN' AND a.action_status = 'RQ' AND a.action_by_id = ? and d.facility_id=a.FACILITY_ID and d.ACCESSION_NUM=a.ACCESSION_NUM and D.event_status !=9 AND b.note_type = d.note_type AND b.resp_id = ? and NVL (a.fwd_to_fac_id,DECODE ((SELECT fwd_pract_ind FROM ca_note_type WHERE note_type = b.note_type), 'A', '*', a.facility_id)) in (?,'*')");//IN037675//IN038176//IN038176
			
			//sql.append("SELECT oa.note_type, ca_get_desc.ca_note_type(oa.note_type,?,1) note_type_desc, SUM (grptot) grptot FROM (SELECT   d.note_type, COUNT (*) grptot FROM ca_encntr_note_audit_log a, CA_ENCNTR_NOTE D,ca_note_type_for_resp b WHERE a.action_type = 'SN' AND a.action_status = 'RQ' AND a.action_by_id = ? and d.facility_id=a.FACILITY_ID and d.ACCESSION_NUM=a.ACCESSION_NUM and D.event_status !=9 AND b.note_type = d.note_type AND b.resp_id = ? and NVL (a.fwd_to_fac_id,DECODE ((SELECT fwd_pract_ind FROM ca_note_type WHERE note_type = b.note_type), 'A', '*A','P','*A' ,a.facility_id)) in (?,'*A')");//IN038659//IN67872
			sql.append("SELECT oa.note_type, ca_get_desc.ca_note_type(oa.note_type,?,1) note_type_desc, SUM (grptot) grptot FROM (SELECT   d.note_type, COUNT (*) grptot FROM ca_encntr_note_audit_log a, CA_ENCNTR_NOTE D,ca_note_type_for_resp b WHERE a.action_type = 'SN' AND a.action_status = 'RQ' AND a.action_by_id = ? and d.facility_id=a.FACILITY_ID and d.ACCESSION_NUM=a.ACCESSION_NUM and D.event_status not in ('9','8') AND b.note_type = d.note_type AND b.resp_id = ? and NVL (a.fwd_to_fac_id,DECODE ((SELECT fwd_pract_ind FROM ca_note_type WHERE note_type = b.note_type), 'A', '*A','P','*A' ,a.facility_id)) in (?,'*A')");//IN038659//IN67872
			//---[IN057492]/Start------
			if(!p_called_func.equals("MC")) 
			{
				//sql.append(" AND d.note_type not in ( SELECT note_type FROM ca_note_type WHERE note_group_id = (SELECT note_group FROM ca_note_group WHERE appl_task_id = 'MC_CONSULT')) ");//IN67872
				sql.append(" AND d.note_type not in ( SELECT note_type FROM ca_note_type WHERE note_group_id = (SELECT note_group FROM ca_note_group a WHERE appl_task_id = 'MC_CONSULT' and a.note_group=note_group_id)) ");//IN67872
			}
			//---[IN057492]/End------
			if(!requestedbyid.equals(""))
		{
			sql.append(" and a.request_by_id = ? ");
		}
			sql.append("  and nvl(ca_view_confidnt_event (d.facility_id,d.ENCOUNTER_ID,d.PATIENT_ID,d.accession_num,'CA',d.NOTE_TYPE,'CLNT','"+clinicianid+"','"+respid+"',d.PERFORMED_BY_ID,d.AUTHORIZED_BY_ID,null),'N')='Y' ");  // INT-CA004_CA

			if(!fromDate.equals("")&&(!ToDate.equals("")))
		{
			sql.append( " and a.request_date_time between to_date(?,'DD/MM/YYYY') and to_date(?,'DD/MM/YYYY')+.9999 ");
		}
		//Added By Archana Dhal on 22/01/2010 related to IN18229.
			else if(!fromDate.equals("") && (ToDate.equals("")))//
		{
			sql.append(" 	and a.request_date_time >= to_date( ?, 'DD/MM/YYYY' ) ");
		}
		else if(fromDate.equals("") && !ToDate.equals(""))
		{
			sql.append(" 	and a.request_date_time <= to_date( ?,'DD/MM/YYYY' )+.9999 ");
		}
			if(!patientId.equals(""))
			sql.append( "and d.patient_id =? ");

		//---[IN057492]/Start------
		//sql.append("GROUP BY d.note_type UNION ALL SELECT c.note_type, COUNT (*) grptot FROM ca_encntr_note c,ca_note_type_for_resp b //WHERE c.facility_id = ? AND c.event_status = '1' AND c.added_by_id = ? and c.contr_mod_accession_num is null AND //b.note_type = C.note_type AND b.resp_id = ? ");
		
		if(!p_called_func.equals("MC")) 
		{
			sql.append("GROUP BY d.note_type UNION ALL SELECT c.note_type, COUNT (*) grptot FROM ca_encntr_note c,ca_note_type_for_resp b WHERE c.facility_id = ? AND c.event_status = '1' AND c.added_by_id = ? and c.contr_mod_accession_num is null AND b.note_type = C.note_type AND b.resp_id = ? ");
		}
		else 
		{
			//sql.append("GROUP BY d.note_type UNION ALL SELECT c.note_type, COUNT (*) grptot FROM ca_encntr_note c,ca_note_type_for_resp b WHERE c.facility_id = ? AND c.event_status = '1' AND c.added_by_id = ? and c.contr_mod_accession_num is not null and c.note_type IN (select note_type from ca_note_type where note_group_id = (select note_group from ca_note_group where appl_task_id = 'MC_CONSULT')) AND b.note_type = C.note_type AND b.resp_id = ? ");//IN67872
			sql.append("GROUP BY d.note_type UNION ALL SELECT c.note_type, COUNT (*) grptot FROM ca_encntr_note c,ca_note_type_for_resp b WHERE c.facility_id = ? AND c.event_status = '1' AND c.added_by_id = ? and c.contr_mod_accession_num is not null and c.note_type IN (select note_type from ca_note_type where note_group_id = (select note_group from ca_note_group a where appl_task_id = 'MC_CONSULT' and a.note_group=note_group_id)) AND b.note_type = C.note_type AND b.resp_id = ? ");//IN67872			
		}
		//---[IN057492]/End------
		sql.append("  and nvl(ca_view_confidnt_event (c.facility_id,c.ENCOUNTER_ID,c.PATIENT_ID,c.accession_num,'CA',c.NOTE_TYPE,'CLNT','"+clinicianid+"','"+respid+"',c.PERFORMED_BY_ID,c.AUTHORIZED_BY_ID,null),'N')='Y' ");   // INT-CA004_CA
		
		if(!fromDate.equals("")&&(!ToDate.equals("")))
		{
			sql.append( " and c.event_date_time between to_date(?,'DD/MM/YYYY') and to_date(?,'DD/MM/YYYY')+.9999 ");
		}
		else if(!fromDate.equals("") && (ToDate.equals("")))
		{
			sql.append(" 	and c.event_date_time >= to_date( ?, 'DD/MM/YYYY' ) ");
		}
		else if(fromDate.equals("") && !ToDate.equals(""))
		{
			sql.append(" 	and c.event_date_time <= to_date( ?,'DD/MM/YYYY' )+.9999 ");
		}

			if(!patientId.equals(""))
			sql.append( "and c.patient_id =? ");

			sql.append("GROUP BY c.note_type) oa ");
			sql.append( " GROUP BY oa.note_type order by 2 ");


			
			pstmt=con.prepareStatement(sql.toString());

			//variable binding
			int count=0;

			pstmt.setString(++count,locale);
			//pstmt.setString(++count,facilityid);//IN038176
			pstmt.setString(++count,clinicianid);
			pstmt.setString(++count,respid);
			if(!requestedbyid.equals(""))
		{
			pstmt.setString(++count,requestedbyid);
			//out.println("requestedbyid"+requestedbyid);
		}
			pstmt.setString(++count,facilityid);//IN037675
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

			pstmt.setString(++count,facilityid);
			pstmt.setString(++count,userid);
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
			if(!patientId.equals(""))
				pstmt.setString(++count,patientId);

			
			
			//pstmt.setString(++count,locale);
			/*if(!requestedbyid.equals(""))
				pstmt.setString(++count,requestedbyid);
			pstmt.setString(++count,respid); 
			pstmt.setString(++count,facilityid);
			pstmt.setString(++count,userid);
			if(!requestedbyid.equals(""))
				pstmt.setString(++count,requestedbyid);
			pstmt.setString(++count,locale);
			pstmt.setString(++count,respid); */

			/*Added by Deepa on 2/1/2010 at 11:11 AM for IN018729*/
			/*Passing the date that is NOT converted, to the next page, since the date gets converted again in the next page*/
			rs = pstmt.executeQuery();
			while(rs != null && rs.next())
			{
				if(i%2 == 0)
					gridData = "QRYEVEN";
				else
					gridData = "QRYODD";
				code = rs.getString("note_type");
				desc = rs.getString("note_type_desc");
				out.println("<tr><td class='gridData'><a class='gridLink' name='"+i+"' href=\"javascript:filterNShowDetails(this,'"+code+"','"+fromDateParam+"','"+ToDateParam+"','"+requestedbyid+"')\">"+desc+"</a><b>&nbsp;("+rs.getInt("grptot")+")</b></td></tr>");
				i++;
				total =total+rs.getInt("grptot");
			}
			if(i%2 == 0)
					gridData = "QRYEVEN";
			else
					gridData = "QRYODD";
			out.println("<tr><td class='CAGROUP' ><a class='gridLink' name='"+i+"' href=\"javascript:filterNShowDetails(this,'','"+fromDateParam+"','"+ToDateParam+"','"+requestedbyid+"')\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+"</a>&nbsp;<b>("+total+")</td></tr>");
			/*Added by Deepa on 2/1/2010 at 11:11 AM for IN018729*/
	%>
</table>
	<input type="hidden" name="patient_id" id="patient_id" value="<%=patientId%>">
	<!-- Start Added by Sridhar Reddy on 20/01/2009 PMGCRF0359 For Frame Reference in Servlet-->
<input type="hidden" name="optionID" id="optionID" value="<%=option_id%>">	
<!--End-->
</form>
</body>
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

