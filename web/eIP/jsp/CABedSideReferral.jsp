<!DOCTYPE html>
<%
/**
* @Module		: InPatient Management ...[IP]
* @Created By	: SRIDHAR R 
* @Created Date	: 18 Oct 2005
* @Function		: Page used for BedSide Referral when called Only from CA...
**/
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page import = "webbeans.eCommon.*,java.util.*,java.sql.*" contentType="text/html;charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	int bed_block_period_dis_int = 0;
	int dis_date_chk_days_int	= 0;
	Connection con		= null;
	Statement stmt		= null;
	ResultSet rset		= null;

	String facilityId		= (String)session.getValue("facility_id");
	String loginUser		= (String)session.getValue("login_user");
	String called_for		= checkForNull(request.getParameter("called_for"),"Request");
	String practid			= checkForNull(request.getParameter("practitioner_id"));
	String patientid		= checkForNull(request.getParameter("patient_id"));
	String encounterid		= checkForNull(request.getParameter("encounter_id"));
	String call_function	= checkForNull(request.getParameter("call_function"));
	String referral_id		= checkForNull(request.getParameter("referralID"));
	String patient_class		= checkForNull(request.getParameter("patient_class"));//Added by Arthi on 18-Nov-2022 against ML-MMOH-CRF-1978
	String oper_stn_id		= "";
	
	boolean isBedSideReferralApplforAE = false; //Added by Arthi on 18-Nov-2022 against ML-MMOH-CRF-1978

	try
	{
		con = ConnectionManager.getConnection(request);
        
		isBedSideReferralApplforAE = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "BED_SIDE_REFERRAL_FOR_AE");//Added by Arthi on 18-Nov-2022 against ML-MMOH-CRF-1978

		String opr_sql = " select a.oper_stn_id oper_stn_id from am_oper_stn a, am_user_for_oper_stn b where a.facility_id='"+facilityId+"' and a.facility_id=b.facility_id and a.oper_stn_id = b.oper_stn_id and b.appl_user_id ='"+loginUser+"' and trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate)) ";

		stmt = con.createStatement();
		rset = stmt.executeQuery(opr_sql);

		if(rset!=null)
		{
			while(rset.next())
			{
				oper_stn_id	= checkForNull(rset.getString("oper_stn_id"));
			}
		}
		if(rset!=null) rset.close();
		if(stmt!=null) stmt.close();

	}catch(Exception e) 
	{
		out.println(e.toString());
	}

	if(called_for.equals("Request"))
	{
		try
		{
			int count= 0;		
			StringBuffer sql_bl = new StringBuffer();
			//Added by Arthi on 18-Nov-2022 against ML-MMOH-CRF-1978
			if(isBedSideReferralApplforAE && patient_class.equals("EM")){
				sql_bl.append("select count(*) from AE_CURRENT_PATIENT where FACILITY_ID = '"+facilityId+"' and ENCOUNTER_ID ='"+encounterid+"' and PATIENT_ID='"+patientid+"' ");
			}//End ML-MMOH-CRF-1978
			else{
			sql_bl.append("select count(*) from IP_OPEN_ENCOUNTER where FACILITY_ID = '"+facilityId+"' and ENCOUNTER_ID ='"+encounterid+"' and PATIENT_ID='"+patientid+"' ");
			}
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql_bl.toString());
			if(rset!=null && rset.next())
			{
				count = rset.getInt(1);
			}
			if(rset!=null)rset.close();
			if(stmt!=null)stmt.close();

			if(count > 0 )
			{	
				call_function	= "ReferralPatientDetails";
			%>
				<script>
				/*	var retVal		 = 	new String();
					var dialogHeight= "34" ;
					var dialogTop	 = "125";
					var dialogWidth	= "50" ;
					var status		= "no";
					var arguments	= "" ;
					var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ;dialogTop:"+dialogTop+"; scroll=no; status:" + status;
					retVal = window.showModalDialog("../../eIP/jsp/PaintReferralPatientDetails.jsp?called_from=CA&patientid=<%=patientid%>&encounterId=<%=encounterid%>&call_function=<%=call_function%>&referral_id=<%=referral_id%>&oper_stn_id=<%=oper_stn_id%>",arguments,features);
					*/
				</script>
				<html>
					<head><title><fmt:message key="Common.ConfirmBedsideReferral.label" bundle="${common_labels}"/></title></head>
					<iframe name="PatientLine_frame" id="PatientLine_frame" src="../../eCommon/jsp/pline.jsp?Facility_Id=<%=facilityId%>&EncounterId=<%=encounterid%>"  scrolling='no' noresize style='height:0%;width:100vw'></iframe>
						<iframe name="Transfer_frame" id="Transfer_frame" src="../../eIP/jsp/addModifyRefPatientDtls.jsp?called_from=CA&encounter_id=<%=encounterid%>&patient_class=<%=patient_class%>&call_function=<%=call_function%>&referral_id=<%=referral_id%>&bed_block_period_dis=<%=bed_block_period_dis_int%>&dis_date_chk_days=<%=dis_date_chk_days_int%>&oper_stn_id=<%=oper_stn_id%>"  scrolling='no' noresize style='height:80vh;width:100vw'></iframe>
						
						<iframe src="../../eCommon/jsp/error.jsp" name="Dummy_frame" id="Dummy_frame" scrolling='auto' noresize style='height:0%;width:100vw'></iframe>
					
				</html> 
		<%	}
			else
			{
				out.println("<script>alert(getMessage('ENCOUNTER_NOT_FOUND','Common'));window.close();</script>");	
			}

		}catch(Exception e) 
		{
			out.println(e.toString());
		}
		finally
		{
			ConnectionManager.returnConnection(con,request);
		}
	}
	else if(called_for.equals("Confirm"))
	{	
		try
		{
			call_function = "BedSideReferral";
			String jsp_name = "ConfirmBedSideReferralDetail.jsp";
		%>
			<html>
				<head>
					<title><fmt:message key="Common.ConfirmBedsideReferral.label" bundle="${common_labels}"/></title>
				</head>
				<iframe name="BedsideFrame" id="BedsideFrame" src="../../eIP/jsp/ConfirmBedsideReferralQueryResult.jsp?called_from=CA&encounter_id=<%=encounterid%>&jsp_name=<%=jsp_name%>&call_function=<%=call_function%>&param=<%=call_function%>&referral_id=<%=referral_id%>&oper_stn_id=<%=oper_stn_id%>&practid=<%=practid%>&patient_id=<%=patientid%>" scrolling='no' noresize style='height:80vh;width:100vw'></iframe>
					<iframe src="../../eCommon/jsp/error.jsp" name="Dummy_frame" id="Dummy_frame" scrolling='auto' noresize style='height:8%;width:100vw'></iframe>
				
			</html>
	<%	}catch(Exception e) 
		{
			out.println(e.toString());
		}
		finally
		{
			ConnectionManager.returnConnection(con,request);
		}
	}
%>

<%!
	public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
	}
%>

