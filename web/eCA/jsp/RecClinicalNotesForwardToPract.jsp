<!DOCTYPE html>
<%
/*
-----------------------------------------------------------------------
Date       Edit History      Name        	Description
-----------------------------------------------------------------------
?             100            ?           	created
26/12/2013	IN027097		Vijayakumar K	System is displaying script error window while forwarding clinical notes
-----------------------------------------------------------------------
*/ 
%>
<%@ page import="java.sql.*, java.util.*, java.text.*, java.net.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<% 
	Connection con = null;
	PreparedStatement pstmt	= null;
	ResultSet rs = null;

	try
	{
		con = ConnectionManager.getConnection(request);

		Map hash = (Map)obj.parseXMLString( request ) ;
		hash = (Map)hash.get("SEARCH") ;
		String facilityId =(String) session.getValue("facility_id");
		String locale = (String)session.getAttribute("LOCALE");
		//String clinician_id	= (String) session.getValue("ca_practitioner_id");

		String speciality_id = (String) hash.get("speciality_id");
		if(speciality_id == null) speciality_id = "";

		String note_type = (String) hash.get("note_type");
		if(note_type == null) note_type = "";

		String clinician_id = (String) hash.get("clinician_id");
		if(clinician_id == null) clinician_id = "";
		
		String sql = "";
		String clinician_name = "";
		String clinician_dtls = "";
		int i = 0;

		if(speciality_id.equals(""))
		{
			sql = "SELECT a.practitioner_id clinician_id, b.practitioner_name clinician_name FROM am_pract_for_facility a, am_practitioner_lang_vw b WHERE b.language_id = ? AND a.facility_id = ? and b.practitioner_id = a.practitioner_id AND a.practitioner_id != ? AND a.practitioner_id IN (SELECT ia.func_role_id FROM ca_note_type_for_resp ib,sm_appl_user ia, sm_resp_for_user ic WHERE ib.note_type = ? AND ib.privilege_type IN ('3', '4') AND ia.appl_user_id = ic.appl_user_id AND ic.resp_id = ib.resp_id)  order by 2"; 
			pstmt =	con.prepareStatement(sql);
			pstmt.setString( 1,	locale);
			pstmt.setString( 2,	facilityId);
			pstmt.setString( 3,	clinician_id);
			pstmt.setString( 4, note_type);
			rs = pstmt.executeQuery() ;
		}
		else
		{
			sql = "SELECT a.practitioner_id clinician_id, b.practitioner_name clinician_name FROM am_pract_for_facility a, am_practitioner_lang_vw b WHERE b.language_id = ? AND a.facility_id = ? and b.practitioner_id = a.practitioner_id AND a.practitioner_id != ? AND a.practitioner_id IN (SELECT ia.func_role_id FROM ca_note_type_for_resp ib,sm_appl_user ia, sm_resp_for_user ic WHERE ib.note_type = ? AND ib.privilege_type IN ('3', '4') AND ia.appl_user_id = ic.appl_user_id AND ic.resp_id = ib.resp_id) AND (b.primary_speciality_code = ? OR EXISTS (SELECT 1 FROM am_pract_specialities WHERE facility_id = a.facility_id AND practitioner_id = a.practitioner_id AND speciality_code = ?) ) order by 2 ";
		
			pstmt =	con.prepareStatement(sql);
			pstmt.setString( 1,	locale);
			pstmt.setString( 2,	facilityId);
			pstmt.setString( 3,	clinician_id);
			pstmt.setString( 4, note_type);
			pstmt.setString( 5,	speciality_id);
			pstmt.setString( 6,	speciality_id);
			rs = pstmt.executeQuery() ;
		}

		if (rs != null)
		{
			while(rs.next())
			{
				clinician_id = rs.getString("clinician_id") == null ? "" : rs.getString("clinician_id");
				clinician_name = rs.getString("clinician_name") == null ? "" : rs.getString("clinician_name");
				clinician_dtls = clinician_id + "~" + clinician_name;
				clinician_dtls = java.net.URLEncoder.encode(clinician_dtls,"UTF-8");//IN027097
%>
				practArry[<%=i%>] = "<%=clinician_dtls%>";
<%
				i++;
			}
		}
		if (pstmt !=null) pstmt.close();
		if (rs !=null) rs.close();
		if (hash !=null) hash.clear();
	}
	catch( Exception e )
	{
		
		e.printStackTrace();
	}
	finally
	{
		if(con !=null) ConnectionManager.returnConnection(con,request);
	}
%>	
