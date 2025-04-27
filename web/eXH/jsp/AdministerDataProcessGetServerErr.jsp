<!DOCTYPE html>

<%@ page import ="java.util.*,java.sql.Connection,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter"%>
<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/> 

<%
Connection conn = null;
Statement stmt = null;
ResultSet rs = null; 

Hashtable hash = new Hashtable(); 
String err_msg = "";
String qryProcMsg = "";

try 
{

	hash = (Hashtable)xmlObj.parseXMLString(request);
	hash = (Hashtable)hash.get("SEARCH");

	String procID = (String)hash.get("proc_id");
	String moduleID = procID.substring(0,2);
	String tableName = moduleID + "_proc_msg";
	String fromDate = (String)hash.get("fromDate");
	String toDate = (String)hash.get("toDate");
	String facilityID = (String)hash.get("facilityID");

	/*System.out.println("tableName "+tableName);
	System.out.println("(AdministerDataProcessGetServerErr.jsp) proc_id: "+procID);
	System.out.println("(AdministerDataProcessGetServerErr.jsp) moduleID: "+moduleID);
	System.out.println("(AdministerDataProcessGetServerErr.jsp) fromDate: "+fromDate);
	System.out.println("(AdministerDataProcessGetServerErr.jsp) toDate: "+toDate);
	System.out.println("(AdministerDataProcessGetServerErr.jsp) facilityID: "+facilityID);	 */

	//qResult =	java.net.URLDecoder.decode(qResult);		

/*	if(!proc_date.equals(""))
	{
		sql1 = "SELECT TO_CHAR(msg_date_time, 'DD/MM/YYYY HH24:MI:SS')||' '||err_msg error FROM "+tableName+" WHERE PROC_ID='"+procID+"' AND msg_date_time > TO_DATE('"+proc_date+"','DD/MM/YYYY HH24:MI:SS')  ";		
	}
	else
	{
		sql1 = "SELECT TO_CHAR(msg_date_time, 'DD/MM/YYYY HH24:MI:SS')||' '||err_msg error FROM "+tableName+" WHERE PROC_ID='"+procID+"' ";
	}
*/
	qryProcMsg = "SELECT OPERATING_FACILITY_ID||' - '||" +
							"PROC_ID||' - '||"+
							"FAILED_PROC_ID||' - '||"+
							"MODULE_ID||' - '||"+
							"MSG_DATE_TIME||' - '||"+
							"APP_KEY||' - '||"+
							"APP_MSG||' - '||"+
							"ERR_MSG error "+
				"FROM "+tableName+" WHERE OPERATING_FACILITY_ID = '"+facilityID+"' AND "+
								" PROC_ID = '"+procID+"' AND "+
							//	" MODULE_ID = NVL('"+moduleID+"',MODULE_ID) AND "+								
								" MSG_DATE_TIME BETWEEN to_date('"+fromDate+"','DD/MM/YYYY HH24:MI:SS') AND to_date('"+toDate+"','DD/MM/YYYY HH24:MI:SS')";
	//AND TO_CHAR(msg_date_time, 'MM/DD/YYYY HH:MI:SS AM') > TO_CHAR('"+proc_date+"','MM/DD/YYYY HH:MI:SS AM')  ";

	System.out.println("(AdministerDataProcessServErr.jsp) qryProcMsg: "+qryProcMsg);		 
	conn = ConnectionManager.getConnection();	
	stmt = conn.createStatement();
	rs = stmt.executeQuery(qryProcMsg);
	//System.out.println("Qry Executed...");
	for(int i = 0; i < 100; i++)
	{
		if(rs.next())	err_msg = err_msg + "\n" + (String)rs.getString("error");
		else break;
	}
//	System.out.println("err_msg befr decode: "+err_msg);

	err_msg = java.net.URLEncoder.encode(err_msg);	
	out.println("parent.setServerError('"+err_msg+"')");

} // end of try
catch (Exception e) 
{
	e.printStackTrace(System.err);
}
finally
{
	if(conn != null) ConnectionManager.returnConnection(conn);
	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();
}

%>
