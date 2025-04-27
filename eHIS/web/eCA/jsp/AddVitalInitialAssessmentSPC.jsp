<!DOCTYPE html>
<%@page import="java.sql.*, java.util.*, java.io.*, webbeans.eCommon.*"%>
<%@ page contentType="text/html;charset=UTF-8" %>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
/*  							 
---------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
----------------------------------------------------------------------------------------------
03/06/2014	  IN037701		Chowminya											SKR-CRF-0036
----------------------------------------------------------------------------------------------
*/
	Connection con = null;
try
{
	request.setCharacterEncoding("UTF-8");
	PreparedStatement stmt = null;
	ResultSet rs = null;
	Properties properties			= (Properties) session.getValue( "jdbc" );
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
	
	hash = (Hashtable)hash.get( "SEARCH" ) ;
	String locale = (String) properties.getProperty("LOCALE") == null ? "" : (String) properties.getProperty("LOCALE");	
   	String panel_id 	 = (String)hash.get("panel_id");
	String disc_id= (String)hash.get("disc_id") ;
	String facility_id=(String)session.getAttribute("facility_id");
	String user_id=(String)session.getAttribute("login_user");
	String ws_no =properties.getProperty("client_ip_address");
	String patient_id =(String)hash.get("patient_id");
	String episode_id = (String)hash.get("episode_id");
	String patient_class = (String)hash.get("patient_class");
	String last_record_date = (String)hash.get("last_record_date");
	String rs_type = "";
	int count = 0;

	boolean transaction_success = true;

	con = ConnectionManager.getConnection(request);
	String sql_count = "select count(*) count from ca_encntr_discr_msr where PATIENT_ID = ? AND ENCOUNTER_ID = ? AND DISCR_MSR_PANEL_OR_FORM_ID = ? and  DISCR_MSR_ID = ? ";
	stmt = con.prepareStatement(sql_count);
	stmt.setString(1,patient_id );
	stmt.setString(2,episode_id );
	stmt.setString(3,panel_id );
	stmt.setString(4,disc_id );
		
	rs = stmt.executeQuery(); 
	while(rs.next())
	{
		count = rs.getInt(1);
	}
	if(rs != null) rs.close(); 
	if(	count == 0)
	{
		String sql = "Select result_type from am_discr_msr where discr_msr_id= ? and eff_status = 'E' ";
		stmt = con.prepareStatement(sql);
		stmt.setString(1,disc_id );
		rs = stmt.executeQuery(); 
		while(rs.next())
		{
			rs_type = rs.getString(1);
		}
		if(rs != null) rs.close(); 
		String insertsql = " insert into ca_encntr_discr_msr(FACILITY_ID,ACCESSION_NUM,ENCOUNTER_ID, PATIENT_ID,PATIENT_CLASS,TEST_OBSERV_DT_TM,PERFORMING_PRACT_ID,DISCR_MSR_ID, DISCR_MSR_RESULT_TYPE,DISCR_MSR_RESULT_NUM,DISCR_MSR_RESULT_NUM_UOM, DISCR_MSR_RESULT_STR,DISCR_MSR_RESULT_DATA,NORMAL_LOW,NORMAL_HIGH,CRITICAL_LOW, CRITICAL_HIGH,NORM_ABNORM_IND,DISCR_MSR_PANEL_OR_FORM_ID,ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID,ADDED_AT_WS_NO,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO) values(?, 'DM$'||to_char(sysdate,'YYYY')||'$'||lpad(CA_DISCR_MSR_SEQ.NEXTVAL,16,0),?,?,?, to_date( ? ,'dd/mm/yyyy hh24:mi:ss'),?,?,?,?,?,?,empty_clob(),?,?,?,?,?,?,?,sysdate,?,?,?, sysdate,?,?)";
		
		if(stmt != null) stmt.close();	
		stmt = con.prepareStatement(insertsql);

		stmt.setString(1, facility_id);
		stmt.setString(2, episode_id);
		stmt.setString(3, patient_id);
		stmt.setString(4, patient_class);
		stmt.setString(5, last_record_date);
		stmt.setString(6, user_id);
		stmt.setString(7, disc_id);
		stmt.setString(8, rs_type);
		stmt.setString(9, "");
		stmt.setString(10,"");
		stmt.setString(11,"");
		stmt.setString(12,"");
		stmt.setString(13,"");
		stmt.setString(14,"");
		stmt.setString(15,"");
		stmt.setString(16,"");
		stmt.setString(17,panel_id);
		stmt.setString(18,user_id);
		stmt.setString(19,facility_id);
		stmt.setString(20,ws_no);
		stmt.setString(21,user_id);
		stmt.setString(22,facility_id);
		stmt.setString(23,ws_no);

		int  rsinsertsql = stmt.executeUpdate(); 
		
			if(rsinsertsql !=0)	
			{
				transaction_success = true;
				con.commit();
			}
	}else
	{
		transaction_success = false;
	}
		out.println(transaction_success);
		if(stmt != null) stmt.close(); 
		
}
catch(Exception ee)
{
	//out.println("Exception in try-1 of AddVitalInitialAssessmentSPC.jsp "+ee.toString());//COMMON-ICN-0181
      ee.printStackTrace();//COMMON-ICN-0181
	con.rollback();
}
finally
{
	if(con != null) ConnectionManager.returnConnection(con);
		
}
%>
