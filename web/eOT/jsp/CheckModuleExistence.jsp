<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import= "java.sql.Connection,java.sql.PreparedStatement,java.sql.CallableStatement,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,eCommon.Common.CommonBean,java.sql.Types" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends
%>
<% String locale = (String)session.getAttribute("LOCALE"); %>

<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<%	
	String facility_id  = (String) session.getValue("facility_id");
	String params = request.getQueryString()+"&facility_id="+facility_id;
	String function_id  = request.getParameter("function_id");
    String url = "";
    String source = "";

	String modules_list = "";
	String ca_module_yn="";
	Connection connection = null;
	PreparedStatement pstmt = null;
	CallableStatement cstmt = null;
	try{
		connection = ConnectionManager.getConnection(request);
		//for checking whether the ca, or module is installed or not
		cstmt=connection.prepareCall("{call GET_OPERATIONAL_MODULES(?,?)}");
		cstmt.setString(1,facility_id);
		cstmt.registerOutParameter(2,Types.VARCHAR);
		cstmt.execute();
		modules_list=cstmt.getString(2);
		if(modules_list.indexOf("OR|")>=0)
			ca_module_yn="Y";	// When CA is  Operational
		else
			ca_module_yn="N";	// When CA is not Operational
 
	}catch(Exception e){
		 System.err.println("Err Msg in CheckModuleExistence: "+e.getMessage());
	}finally{
		try{
			if(cstmt!=null)cstmt.close();
			if(connection!=null)
			ConnectionManager.returnConnection(connection,request);
		}catch(Exception e){}
	}
// alert the user if CA doesnot exist or populate the respective function
	if(ca_module_yn.equals("N")){
%>
		<script>
			alert(getMessage("CA_NOT_INSTALLED","Common"));
			window.location.href = "../../eCommon/jsp/dmenu.jsp";
		</script>
<%
		}else{			
			if(function_id.equals("OT_SLATE_JAVA"))     //Operations Menu
				url = "../../eOT/jsp/OTSlate.jsp?";
			else if(function_id.equals("OT_CHECK_OUT_FROM_WARD"))
				url = "../../eOT/jsp/OTCheckOutFromWard.jsp?";
			else if(function_id.equals("OT_CHECK_IN"))
				url = "../../eOT/jsp/OTCheckIn.jsp?";
			else if(function_id.equals("OT_CANCEL_CHECKED_IN_CASES"))
				url = "../../eOT/jsp/OTCancelCheckedInCases.jsp?";
			else if(function_id.equals("OT_RECORD_ANESTHESIA"))  // Anaesthesia Menu
				url = "../../eOT/jsp/AT_RecordAnesthesia.jsp?";
			else if(function_id.equals("OT_SURGERY_HISTORY"))   // Queries
				url = "../../eOT/jsp/SurgeryHistory.jsp?";
			else if(function_id.equals("OT_INTERACTIVE_OPER_REGISTER"))
				url = "../../eOT/jsp/InteractiveOperationRegister.jsp?";
			else if(function_id.equals("OT_ANAESTHESIA_HISTORY"))
				url = "../../eOT/jsp/AT_AnaesthesiaHistory.jsp?";			
			else if(function_id.equals("OT_PICK_LIST")) // Bookings Menu
				url = "../../eOT/jsp/OTPicklist.jsp?";
			else if(function_id.equals("OT_SLATE_VIEW_SETTINGS"))
				url = "../../eOT/jsp/OTSlateViewSettings.jsp?";
			else if(function_id.equals("OT_SLATE_VIEW_RESULTS"))
				url = "../../eOT/jsp/OTSlateViewResults.jsp?";
			//else if(function_id.equals("OT_NOTIF_LIST_BY_WARD"))
				//url = "../..//eOT/jsp/OtReportsMain.jsp?report_id=OTROTNWR&";				
			//else if(function_id.equals("OT_BOOKING"))
			//	url = "../..//eOT/jsp/OTBooking.jsp?";
			//else if(function_id.equals("OT_BOOKING_VERIFICATION"))
			//	url = "../..//eOT/jsp/OTBookingVerification.jsp?";
			//else if(function_id.equals("OT_TO_BE_RESCHD_CASES"))
			//	url = "../..//eOT/jsp/ToBeRescheduledCases.jsp?";
			//else if(function_id.equals("OT_BOOKING_CANCEL_TRANSFER"))
			//	url = "../..//eOT/jsp/OTBookingCancelTransfer.jsp?";
			//else if(function_id.equals("OT_PICK_LIST"))
			//	url = "../..//eOT/jsp/OTPicklist.jsp?";
			//else if(function_id.equals("OT_BOOKING_QUERY"))
			//	url = "../..//eOT/jsp/BookingQuery.jsp?";
			source = url + params ;

%>
		<script>
			parent.frames[2].document.location.href = "<%=source%>";
		</script>
<%
		}
%>

