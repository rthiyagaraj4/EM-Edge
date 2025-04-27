package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.ConnectionManager;
import eXH.*;
import java.net.URLEncoder;
import java.util.*;

public final class __viewdebuginfo extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/viewDebugInfo.jsp", 1709122395647L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "UTF-8".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<HTML>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\n<HEAD>\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n \n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\' type=\'text/css\'></link>\n<link rel=\'stylesheet\' href=\'../../eXH/html/menu.css\' type=\'text/css\'></link>\n\n<style>\t\t\n\t.testSty\n\t{\n\t\twidth:expression(document.getElementById(\"hiddenTable\").clientWidth-document.getElementById(\"left_child\").clientWidth);\t\t\n\t}\n</style>\n\n<script language=\"javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\" ></script>\n<script language=\"javascript\" src=\"../../eCommon/js/messages.js\" ></script>\n<script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"javascript\" src=\"../../eXH/js/ViewDebugInformation.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<BODY onMouseDown=\"CodeArrest()\" onKeyDown =\'lockKey()\'>\n<table width=\"100%\" id=\"hiddenTable\"><tr><td></td></tr></table>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<FORM name=\"debugResultsForm\" id=\"debugResultsForm\" ID=\"debugResultsForm\" method=\"post\">\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<script>\nalert(getMessage(\'XH1021\'));\n</script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<TABLE WIDTH=\"100%\">\n\t\t<TR>\n\t\t\t<TD align=\"right\" class=\"CAGROUP\" > \n\t\t\t<A class=\'label\' style=\'cursor:pointer\' onClick=\"funAction(\'P\')\">";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</A>\n\t\t\t<A class=\'label\'  onClick=\"funAction(\'N\')\" style=\'cursor:pointer\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</A>\n\t\t\t</TD>\n\t\t</TR>\n\t</TABLE>\n\t<TABLE CELLSPACING=\"0\" CELLPADDING=\"4\" BORDER=\"1\" >\n\t<TR>\n\t\t<TD class=\'COLUMNHEADER\' WIDTH=\"20%\">PGM ID</TD>\n\t\t<TD class=\'COLUMNHEADER\' WIDTH=\"15%\">Machine Name</TD>\n\t\t<TD class=\'COLUMNHEADER\' WIDTH=\"10%\">Transaction Date</TD>\n\t\t<TD class=\'COLUMNHEADER\' WIDTH=\"55%\">Text</TD>\n\t</TR>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<TR>\n\t\t<TD ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</TD>\n\t\t<TD ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" NOWRAP>\n\t\t\t<a href=\"#\" onClick=\"return showText(\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\')\">\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</a>\n\t\t</TD>\n\t</TR>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n</TABLE>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\n</BODY>\n<INPUT TYPE=\"hidden\" name=\"action_type\" id=\"action_type\" ID=\"action_type\" VALUE=\"\">\n<INPUT TYPE=\"hidden\" name=\"sortMode\" id=\"sortMode\" ID=\"sortMode\" VALUE=\"\">\n<INPUT TYPE=\"hidden\" name=\"pgmID\" id=\"pgmID\" ID=\"pgmID\" VALUE=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n<INPUT TYPE=\"hidden\" name=\"clientID\" id=\"clientID\" ID=\"clientID\" VALUE=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n<INPUT TYPE=\"hidden\" name=\"strPGM\" id=\"strPGM\" ID=\"strPGM\" VALUE=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n<INPUT TYPE=\"hidden\" name=\"strClient\" id=\"strClient\" ID=\"strClient\" VALUE=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n<INPUT TYPE=\"hidden\" name=\"fromDate\" id=\"fromDate\" ID=\"fromDate\" VALUE=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n<INPUT TYPE=\"hidden\" name=\"toDate\" id=\"toDate\" ID=\"toDate\" VALUE=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n<INPUT TYPE=\"hidden\" name=\"mode\" id=\"mode\" ID=\"mode\" VALUE=\"test\">\n</FORM>\n\n</HEAD>\n</HTML>\n\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

request.setCharacterEncoding("UTF-8");
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);

Connection dbConn = null;
Statement stmt = null;
ResultSet rs = null;

String whereClause = "";
String [] pgmList = null;
String [] clientList = null;
String fromDate = null;
String toDate = null;
String strClient = null;
String strPGM = null;
StringBuffer tempBuf = null;
String strTDClass = "";

boolean boolToggle =  true;	
boolean flag = false;

try
{
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

	//System.out.println("PGM LIST "+strPGM);
	//System.out.println("CLIENT LIST "+strClient);

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

	//System.out.println("whereClause "+whereClause);

	request.setAttribute(XHQueryRender.strQueryId,"VIEW_TRACE_EVENTS");	
	request.setAttribute(XHQueryRender.col,"4");
	request.setAttribute(XHQueryRender.maxRec,"10");
	request.setAttribute(XHQueryRender.whereClause,whereClause);	
	dbConn = ConnectionManager.getConnection(request);
	HashMap resultsQry = XHQueryRender.getResults(request,session,dbConn);	
	ArrayList arrRow = (ArrayList)resultsQry.get("qry_result"); 
	ArrayList arrCol = null;

	boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
	boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
	//String strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
	//String strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");

	String strPrevious = "Previous";
	String strNext  = "Next";

	if (boolPrevious == true)
	{
//		strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
		strPrevious = "Previous";
	}
	else
	{
		strPrevious = " ";
	}
	if (boolNext== true)
	{
//		strNext = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
		strNext = "Next";
	}
	else
	{
		strNext  = " ";
	}	

            _bw.write(_wl_block5Bytes, _wl_block5);

if(arrRow.size()==0)
{

            _bw.write(_wl_block6Bytes, _wl_block6);
 } else { 
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(strPrevious ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(strNext ));
            _bw.write(_wl_block9Bytes, _wl_block9);

	for (int j=0; j<arrRow.size();j++)
	{
		arrCol = (ArrayList)arrRow.get(j);
		if (boolToggle == true)
		{
			strTDClass = "class='QRYEVEN'";
			boolToggle =  false;
		}
		else
		{
			strTDClass = "class='QRYODD'";
			boolToggle =  true;
		}

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf( XHDBAdapter.checkNull((String)arrCol.get(0))));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf( XHDBAdapter.checkNull((String)arrCol.get(3))));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf( XHDBAdapter.checkNull((String)arrCol.get(2))));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(URLEncoder.encode(XHDBAdapter.checkNull((String)arrCol.get(1)))));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf( XHDBAdapter.checkNull((String)arrCol.get(1))));
            _bw.write(_wl_block15Bytes, _wl_block15);

	}
}

            _bw.write(_wl_block16Bytes, _wl_block16);

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
	catch(Exception exp)
	{
		exp.printStackTrace(System.err);
	}
}

            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(pgmList));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(clientList));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(strPGM));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(strClient));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(fromDate));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(toDate));
            _bw.write(_wl_block23Bytes, _wl_block23);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
