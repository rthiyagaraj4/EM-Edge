<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
-----------------------------------------------------------------------
Date       	Edit History   Name        Description
-----------------------------------------------------------------------
28/01/2012	Created		Ramesh G	PIN number CRF
28/01/2012	IN030566	Ramesh G	When we place another Order of the same category the Pin No. is prompted again even if the Patient chart is not closed.								  
18/6/2012	IN032928	Dinesh T	Added the database hit code to check the status which is present in the Manage patient queue 									function of OP
22/08/2012  AutoClosure  Akbar      Included code changes -> when visit status is updated as "09" - Auto closure, and patient is accessed for opening the Patient chart, the message "Visit is Cancelled. Cannot proceed"  is alerted
13/06/2013	IN038776	Ramesh G	This is a child cr for  MMS-QH-CRF- 0042 to cover the Billing related changes
-----------------------------------------------------------------------
*/
%>

<%@page import="java.sql.*,java.util.*,eCA.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<% 
	//IN032928
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String l_encounter_id = request.getParameter("p_encounter_id")==null?"":request.getParameter("p_encounter_id");
	String l_facility_id=(String)session.getValue("facility_id");  //for AutoClosure issue fix
	String l_queue_status = "";
	String sql = "";
		
	//for AutoClosure issue fix - start
	//sql = "select queue_status from op_patient_queue where patient_id = ? and encounter_id = ?";
	sql = "select queue_status from op_patient_queue where patient_id = ? and encounter_id = ? and FACILITY_ID = ?";
	//for AutoClosure issue fix - end
	String chartOpenYN = "Y";
	
	try
	{		
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,patient_id);
		pstmt.setString(2,l_encounter_id);
		pstmt.setString(3,l_facility_id);    //for AutoClosure issue fix
		rs = pstmt.executeQuery();
		
		while(rs.next())
		{
			l_queue_status = rs.getString("queue_status");
		}
		//for AutoClosure issue fix - start
		//if((l_queue_status!=null || !l_queue_status.equals("")) && l_queue_status.equals("99") || l_queue_status.equals("09"))
		if((l_queue_status!=null || !l_queue_status.equals("")) && l_queue_status.equals("99"))
		//for AutoClosure issue fix - end
		{
			chartOpenYN = "N";
			out.println("false");
		}		
	}
	catch(Exception e)	
	{
		e.printStackTrace();
	}
	finally
	{
		if(pstmt!=null)
			pstmt.close();
		if(rs!=null)
			rs.close();
		if(con!=null)
		ConnectionManager.returnConnection(con,request);
	}
	//IN032928
//[IN030566] Starts
	if(chartOpenYN.equals("Y"))//IN032928
	{
		try{			
			if((session.getAttribute("TEMP_PASS")!=null) && (session.getAttribute("TEMP_PASS")!="")){
				HashMap mHash = new HashMap();
				mHash = (HashMap) session.getAttribute("TEMP_PASS");
				if(mHash.containsKey(patient_id)){
					mHash.remove(patient_id);
				}
				session.setAttribute("TEMP_PASS",mHash);
			}
			out.println("true");
		}catch(Exception ee)
		{	
			//out.println("Exception in EnterOrderValidate.jsp for TEMP_PASS Session-- "+ee.toString()+"--");//COMMON-ICN-0181
			ee.printStackTrace();
		}
	}//IN032928
	
	//[IN030566] Ends
	//[IN038776] Start.
	if((session.getAttribute(patient_id+"ScreeningServiceValues"))!=null){
		session.removeAttribute(patient_id+"ScreeningServiceValues");
	}
	if((session.getAttribute(patient_id+"Check_Boxs"))!=null){
		session.removeAttribute(patient_id+"Check_Boxs");  
	}
	//[IN038776] End.
%>
