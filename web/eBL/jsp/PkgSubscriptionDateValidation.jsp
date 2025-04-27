<!DOCTYPE html>
<%@ page import="java.sql.*,java.text.*,eBL.Common.BLHelper,java.util.Calendar,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat,java.io.*,java.util.*"	contentType="text/html;charset=UTF-8"%>
<%@page import="org.json.simple.JSONObject"%>
<%
	/* Page Added by Karthik for MMS-MD-SCF-0006 [IN:060039] 4/28/2016 */
	String strfacilityid = (String) session.getValue("facility_id");
	if (strfacilityid == null)	strfacilityid = "";
	String strloggeduser = (String) session.getValue("login_user");
	if (strloggeduser == null)	strloggeduser = "";
	HttpSession httpSession = request.getSession(false);
	Properties p = (Properties) httpSession.getValue("jdbc");
	String strwsno = p.getProperty("client_ip_address");	
	String fromDate= request.getParameter("fromDate")==null? "": request.getParameter("fromDate");
	String toDate =request.getParameter("toDate")==null? "": request.getParameter("toDate");
	
	if(fromDate.equals("")==false ){
	    String dateFormat = "dd/MM/yyyy HH:mm:ss";
	    SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
	    Calendar c = Calendar.getInstance();
	    c.setTime(sdf.parse(fromDate));
	    c.add(Calendar.DATE, 1);
	    c.add(Calendar.SECOND, -1);
	    toDate = sdf.format(c.getTime());
	}
    
 	if(fromDate.equals("") && toDate.equals("")){
 		Connection connection=ConnectionManager.getConnection();
		fromDate=BLHelper.getSysDate(connection,"dd/mm/yyyy HH24:MI:SS");
		toDate="";
	}
	 
	
	JSONObject obj = new JSONObject();
	obj.put("flag", "N");
	obj.put("validityDays", "1");
	obj.put("fromDate", fromDate);
	obj.put("toDate", toDate);
	out.print(obj);
	out.flush();
	
%>

