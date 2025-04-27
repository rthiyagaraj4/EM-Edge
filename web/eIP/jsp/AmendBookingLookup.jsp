<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../js/AmendBooking.js'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
    request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	String url					= "../../eCommon/jsp/commonToolbar.jsp?";
	String params				= request.getQueryString();
	String source				= url + params;
	String facilityId			= (String)session.getValue("facility_id");
	String loginUser			= (String)session.getValue("login_user");
	String function_id			= request.getParameter("function_id");
        if(function_id == null) function_id = "";

	Connection con				= null;
	PreparedStatement stmt		= null;
	Statement stmt1				= null;
	PreparedStatement pstmt 	= null;
	ResultSet rs 				= null; 
	ResultSet rs1 				= null; 
	ResultSet rset 				= null;
	String oper_stn_id			= "";  
	String revise_booking_yn	= "";
	String cancel_booking_yn	= "";
	String reject_admission_yn	= "";
	String confirm_booking_yn	= "";
	String create_booking_yn	= "";
	String create_booking_with_conf_yn = "";
	String ismult_bkg_yn		= "";
	String bkg_grace_period		= "";
	String bl_interfaced_yn		= "";
	String capture_fin_dtls_yn	= "";
	String noshow_bkng_period   = "";//Added for Bru-HIMS-CRF-153 [IN:030273] by Srinivas
	try
	{
		con						= ConnectionManager.getConnection(request);	
		//The below query is modified   for Bru-HIMS-CRF-153 [IN:030273] by Srinivas
		String ip_paramSql      = "select multi_book_pat_yn,bkg_grace_period,bl_interfaced_yn,capture_fin_dtls_yn,NOSHOW_BKNG_PERIOD from ip_param where facility_id='"+facilityId+"'";
		pstmt					= con.prepareStatement(ip_paramSql);
		rs = pstmt.executeQuery() ;
		if(rs.next())
		{
			ismult_bkg_yn		= checkForNull(rs.getString("multi_book_pat_yn"));
			bkg_grace_period	= checkForNull(rs.getString("bkg_grace_period"));
			bl_interfaced_yn	= checkForNull(rs.getString("bl_interfaced_yn"));
			capture_fin_dtls_yn = checkForNull(rs.getString("capture_fin_dtls_yn"));
			noshow_bkng_period  = checkForNull(rs.getString("NOSHOW_BKNG_PERIOD"));//Added for Bru-HIMS-CRF-153 [IN:030273] by Srinivas
			
			String accessCheck	= "Select  AM_OPER_STN_ACCESS_CHECK('"+facilityId+"','"+loginUser+"','N','','REVISE_BOOKING_YN') revise_booking_yn, AM_OPER_STN_ACCESS_CHECK('"+facilityId+"','"+loginUser+"','N','','CANC_BOOKING_YN') canc_booking_yn, AM_OPER_STN_ACCESS_CHECK('"+facilityId+"','"+loginUser+"','N','','REJECT_ADMISSION_YN') reject_admission_yn, DECODE(AM_OPER_STN_ACCESS_CHECK('"+facilityId+"','"+loginUser+"','N','','CONFIRM_BOOKING_YN'),'1','N','2','N','3','N','4','N','Y') confirm_booking_yn, DECODE(AM_OPER_STN_ACCESS_CHECK('"+facilityId+"','"+loginUser+"','N','','CREATE_BOOKING_YN'),'1','N','2','N','3','N','4','N','Y') create_booking_yn, DECODE(AM_OPER_STN_ACCESS_CHECK('"+facilityId+"','"+loginUser+"','N','','CREATE_BOOKING_WITH_CONF_YN'),'1','N','2','N','3','N','4','N','Y') create_booking_with_conf_yn FROM dual";
			stmt = con.prepareStatement(accessCheck);
			rs = stmt.executeQuery() ;

			rs.next();
			revise_booking_yn	= checkForNull(rs.getString("revise_booking_yn"));

			if((!revise_booking_yn.equals("1")) && (!revise_booking_yn.equals("2")) && (!revise_booking_yn.equals("3")) && (!revise_booking_yn.equals("4")))
			{
				oper_stn_id			=  revise_booking_yn;
				revise_booking_yn   = "Y";
			}
			else
			{
				revise_booking_yn   = "N";
			}

			cancel_booking_yn		= checkForNull(rs.getString("canc_booking_yn"));
			if((!cancel_booking_yn.equals("1")) && (!cancel_booking_yn.equals("2")) && (!cancel_booking_yn.equals("3")) && (!cancel_booking_yn.equals("4")))
			{
				oper_stn_id			=  cancel_booking_yn;
				cancel_booking_yn   = "Y";
			}
			else
			{
				cancel_booking_yn   = "N";
			}

			reject_admission_yn		= checkForNull(rs.getString("reject_admission_yn"));
			if((!reject_admission_yn.equals("1")) && (!reject_admission_yn.equals("2")) && (!reject_admission_yn.equals("3")) && (!reject_admission_yn.equals("4")))
			{
				oper_stn_id =  reject_admission_yn;
				reject_admission_yn = "Y";
			}
			else
			{
				reject_admission_yn = "N";
			}

			confirm_booking_yn		= checkForNull(rs.getString("confirm_booking_yn"));
			create_booking_yn		= checkForNull(rs.getString("create_booking_yn"));
			create_booking_with_conf_yn = checkForNull(rs.getString("create_booking_with_conf_yn"));

			if((revise_booking_yn.equals("Y")) || (cancel_booking_yn.equals("Y")) ||(reject_admission_yn.equals("Y")))
			{	%>
				<iframe name = 'commontoolbarFrame'	src = <%=source%> frameborder=0 scrolling = 'no' noresize style='height:7vh;width:100vw'></iframe>
					<iframe name='f_query_add_mod' id='f_query_add_mod' src="../jsp/BookingReferenceLookup.jsp?function_id=<%=function_id%>&oper_stn_id=<%=oper_stn_id%>&revise_booking_yn=<%=revise_booking_yn%>&cancel_booking_yn=<%=cancel_booking_yn%>&confirm_booking_yn=<%=confirm_booking_yn%>&create_booking_yn=<%=create_booking_yn%>&create_booking_with_conf_yn=<%=create_booking_with_conf_yn%>&ismult_bkg_yn=<%=ismult_bkg_yn%>&bkg_grace_period=<%=bkg_grace_period%>&bl_interfaced_yn=<%=bl_interfaced_yn%>&capture_fin_dtls_yn=<%=capture_fin_dtls_yn%>&noshow_bkng_period=<%=noshow_bkng_period%>"  frameborder=0 scrolling='auto' style='height:84vh;width:100vw'></iframe>
					<!-- modified   for Bru-HIMS-CRF-153 [IN:030273] by Srinivas-->
					<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:8vh;width:100vw'></iframe>
		<%	}
			else
			{	%>
				<script>
					alert(getMessage('OPER_STN_FUNC_RESTRN','IP'))
					document.location.href ='../../eCommon/jsp/dmenu.jsp'
				</script>
		<%	}
		}
		else %>
            <script>alert(getMessage('IP_PARAM_NOT_FOUND','IP'));
			document.location.href= '../../eCommon/jsp/dmenu.jsp'
			</script>

<%		if(rset != null)	rset.close();
		if(rs != null)		rs.close();
		if(rs1 != null)		rs1.close();
		if(stmt != null)	stmt.close();
		if(pstmt != null)	pstmt.close();
		if(stmt1 != null)	stmt1.close();
	}catch(Exception e)
	{	
		//out.println("Exception in tryCatch : "+ e.toString());
		e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>	
</html>
<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

