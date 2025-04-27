<!DOCTYPE html>
<%@ page import="java.sql.*,java.net.*"%>
<%@ page import="webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter"%>
<%@ page import="org.apache.poi.hssf.model.*,org.apache.poi.hssf.usermodel.*"%>

<SCRIPT> var debugLogArray = []; </SCRIPT>
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script language="javascript" src="../../eCommon/js/messages.js" ></script>

<%
Connection dbConn = null;
Statement stmt = null;
ResultSet rs = null;

String [] pgmList = null;
String [] clientList = null;
String fromDate = null;
String toDate = null;
String strClient = null;
String strPGM = null;
String whereClause = "";
String queryTrace = "SELECT pgm_id,text,rx_date,machineid FROM xh_trace";
StringBuffer tempBuf = null;

HSSFWorkbook wb = new HSSFWorkbook();

int recCount = 0;
boolean flag = false;

try
{	
	HSSFSheet sheet = wb.createSheet("Debug Log");				
	HSSFRow row = null;

	fromDate = XHDBAdapter.checkNull(request.getParameter("fromDate"));
	toDate = XHDBAdapter.checkNull(request.getParameter("toDate"));
	pgmList = request.getParameterValues("pgmID");
	clientList = request.getParameterValues("clientID");	

	tempBuf = new StringBuffer();
	for(int i=0;i<pgmList.length;i++)
	{	
		tempBuf = tempBuf.append("'"+pgmList[i]+"',");		
	}

	strPGM = tempBuf.toString();	
	strPGM = strPGM.substring(0,strPGM.length()-1);	
	tempBuf.delete(0,tempBuf.length());
	
	for(int i=0;i<clientList.length;i++)
	{		
		tempBuf = tempBuf.append("'"+clientList[i]+"',");
	}
	strClient = tempBuf.toString();
	strClient = strClient.substring(0,strClient.length()-1);
	tempBuf.delete(0,tempBuf.length());

//	System.out.println("PGM LIST "+strPGM);
//	System.out.println("CLIENT LIST "+strClient);

	if(strPGM != null && !strPGM.equals("''"))
	{
		flag = true;
		whereClause = whereClause+" WHERE pgm_id IN ("+strPGM+")";
	}
	
	if(strClient != null && !strClient.equals("") && !strClient.equals("'ALL'"))
	{
		if(flag) whereClause = whereClause+" AND machineid IN ("+strClient+")";
		else whereClause = whereClause+" WHERE machineid IN ("+strClient+")";
	}

	if(fromDate != null && !fromDate.equals(""))
	{
		if(flag) 
		{
			if(toDate != null && !toDate.equals(""))
			{
				whereClause = whereClause+" AND TO_NUMBER(to_CHAR(RX_DATE,'RRRRMMDDHH24MISS')) BETWEEN TO_NUMBER(to_CHAR(TO_DATE('"+fromDate+"','DD/MM/RRRR HH24:MI:SS'),'RRRRMMDDHH24MISS')) AND TO_NUMBER(to_CHAR(TO_DATE('"+toDate+"'),'RRRRMMDDHH24MISS'))";
			}
			else
			{
				whereClause = whereClause+" AND TO_NUMBER(to_CHAR(RX_DATE,'RRRRMMDDHH24MISS')) >= TO_NUMBER(to_CHAR(TO_DATE('"+fromDate+"','DD/MM/RRRR HH24:MI:SS'),'RRRRMMDDHH24MISS'))";
			}
		}
		else 
		{
			if(toDate != null && !toDate.equals(""))
			{
				whereClause = whereClause+" WHERE TO_NUMBER(to_CHAR(RX_DATE,'RRRRMMDDHH24MISS')) BETWEEN TO_NUMBER(to_CHAR(TO_DATE('"+fromDate+")','DD/MM/RRRR HH24:MI:SS','RRRRMMDDHH24MISS')) AND TO_NUMBER(to_CHAR(TO_DATE('"+toDate+"'),'RRRRMMDDHH24MISS'))";
			}
			else
			{
				whereClause = whereClause+" WHERE TO_NUMBER(to_CHAR(RX_DATE,'RRRRMMDDHH24MISS')) >= TO_NUMBER(to_CHAR(TO_DATE('"+fromDate+")','DD/MM/RRRR HH24:MI:SS','RRRRMMDDHH24MISS'))";
			}
		}
	}
	
	queryTrace = queryTrace+whereClause;
//	System.out.println("queryTrace "+queryTrace);

	dbConn = ConnectionManager.getConnection();
	stmt = dbConn.createStatement();
	rs = stmt.executeQuery(queryTrace);	
	
	HSSFCellStyle cs = wb.createCellStyle();
	HSSFFont font = wb.createFont();	
	font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	font.setFontName("Trebuchet MS");
	cs.setFont(font);


	row = sheet.createRow((short)0);
	HSSFCell cell = row.createCell((short)0);
	cell.setCellValue("Machine ID");
	cell.setCellStyle(cs);

	cell = row.createCell((short)1);
	cell.setCellValue("PGM ID");
	cell.setCellStyle(cs);

	cell = row.createCell((short)2);
	cell.setCellValue("Date");
	cell.setCellStyle(cs);

	cell = row.createCell((short)3);
	cell.setCellValue("Text");
	cell.setCellStyle(cs);

	for(int i=1;rs.next();i++)
	{
		row = sheet.createRow((int)i);
		row.createCell((short)0).setCellValue(rs.getString("MACHINEID"));
		row.createCell((short)1).setCellValue(rs.getString("PGM_ID"));
		row.createCell((short)2).setCellValue(rs.getString("RX_DATE"));
		row.createCell((short)3).setCellValue(rs.getString("Text"));
		recCount = i;
	}		
}
catch(Exception exp)
{
	exp.printStackTrace(System.err);
}
finally
{	
	try
	{
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
		if(dbConn != null) ConnectionManager.returnConnection(dbConn);
	}
	catch(Exception fexp)
	{
		fexp.printStackTrace(System.err);
	}
}
if(recCount > 1)
{
	response.setContentType("application/vnd.ms-excel");
	ServletOutputStream op = response.getOutputStream();
	wb.write(op);
	op.flush();
	op.close();
}
else
{%>
<script>
alert(getMessage('XH1021'));
</script>
<%}%>

