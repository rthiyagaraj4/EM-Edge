package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.net.*;
import webbeans.eCommon.ConnectionManager;
import eXH.XHDBAdapter;
import org.apache.poi.hssf.model.*;
import org.apache.poi.hssf.usermodel.*;

public final class __debuginfo2xl extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

    private static void _releaseTags(javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag t) {
        while (t != null) {
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, t);
            if(t instanceof javax.servlet.jsp.tagext.Tag) {
                javax.servlet.jsp.tagext.Tag tmp = (javax.servlet.jsp.tagext.Tag)t;
                t = ((javax.servlet.jsp.tagext.Tag) t).getParent();
                try {
                    tmp.release();
                } catch(java.lang.Exception ignore) {}
            }
            else {
                t = ((javax.servlet.jsp.tagext.SimpleTag)t).getParent();
            }
        }
    }

    public boolean _isStale(){
        boolean _stale = _staticIsStale((weblogic.servlet.jsp.StaleChecker) getServletConfig().getServletContext());
        return _stale;
    }

    public static boolean _staticIsStale(weblogic.servlet.jsp.StaleChecker sci) {
        if (sci.isResourceStale("/exh/jsp/debugInfo2XL.jsp", 1709122322429L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n<SCRIPT> var debugLogArray = []; </SCRIPT>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\" ></script>\n<script language=\"javascript\" src=\"../../eCommon/js/messages.js\" ></script>\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\nalert(getMessage(\'XH1021\'));\n</script>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

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
{
            _bw.write(_wl_block3Bytes, _wl_block3);
}
            _bw.write(_wl_block4Bytes, _wl_block4);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
