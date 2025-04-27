package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.ConnectionManager;
import java.util.*;

public final class __viewdebuginfoheader extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/ViewDebugInfoHeader.jsp", 1709122395850L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\' type=\'text/css\'></link>\n<link rel=\'stylesheet\' href=\'../../eXH/html/menu.css\' type=\'text/css\'></link>\n\n<script language=\"javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\" ></script>\n<script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"javascript\" src=\"../../eXH/js/ViewDebugInformation.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<BODY onMouseDown=\"CodeArrest()\" onKeyDown =\'lockKey()\'>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<FORM name=\'queryCriteriaForm\' id=\'queryCriteriaForm\' target=\'queryResultsFrame\' action=\'../../eXH/jsp/viewDebugInfo.jsp\'>\n<TABLE width=\'100%\' cellspacing=0>\n<tr>\n\n<td class=\'label\' colspan=\"1\">From</td>\n<td class=\'fields\' colspan=\"1\">\n\t<input type=\'text\' name=\'fromDate\' id=\'fromDate\' id=\'fromDate\' value=\'\'>\n\t<input type=\'image\' src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'fromDate\',\'dd/mm/y\');\" >\n</td>\n\n<td class=\'label\' colspan=\"1\">To</td>\n<td class=\'fields\' colspan=\"1\">\n\t<input type=\'text\' name=\'toDate\' id=\'toDate\' id=\'toDate\' value=\'\'>\n\t<input type=\'image\' src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'toDate\',\'dd/mm/y\');\" >\n</td>\n\n<td>&nbsp;</td><td>&nbsp;</td>\n\n</tr>\n<tr>\n\n<td class=\'label\' colspan=\"1\">PGM ID</td>\n<td class=\'fields\' colspan=\"1\">\n\t<select name=\'pgmID\' id=\'pgmID\' id=\'pgmID\' multiple>\n\t\t<option value=\'\' selected>All</option>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<option value=\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</option>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t</select>\n</td>\n\n<td class=\'label\' colspan=\"1\">Client</td>\n<td class=\'fields\' colspan=\"1\">\n\t<select name=\'clientID\' id=\'clientID\' id=\'clientID\' multiple>\t\t\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t</select>\n</td>\n\n<td class=\'label\' colspan=\"1\">Mode</td>\n<td class=\'fields\' colspan=\"1\">\n\t<select name=\'mode\' id=\'mode\' ID=\'mode\'>\t\t\n\t\t<option value=\'display\'>Display Result</option>\n\t\t<option value=\'excel\'>Write to Excel</option>\n\t</select>\n</td>\n\n</TR>\n<TR ALIGN=\'right\'>\n\t<TD ALIGN=\"right\" COLSPAN=\"6\">\t\t\n\t\t<INPUT TYPE=\'button\' CLASS=\'BUTTON\' VALUE=\'Search\' onClick=\"refreshFrames();searchRecords();\">\n\t</TD>\n</TR>\n</TABLE>\n</FORM>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n</BODY>\n\n</HEAD>\n</HTML>\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

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

try
{
Connection dbConn = null;
Statement pgmStmt = null;
ResultSet pgmRS = null;
Statement clientStmt = null;
ResultSet clientRS = null;

String queryPGM = "SELECT pgmid FROM sy_pgm_events_ctl ORDER BY pgmid";
String queryClient = "SELECT DISTINCT machineid FROM sy_pgm_events_ctl ORDER BY machineid";

ArrayList pgmList = null;
ArrayList clientList = null;

try
{
	dbConn = ConnectionManager.getConnection();
	pgmStmt = dbConn.createStatement();
	pgmRS = pgmStmt.executeQuery(queryPGM);

	if(pgmRS.next())
	{
		pgmList = new ArrayList();
		pgmList.add(pgmRS.getString("pgmid"));
	}
	while(pgmRS.next())
	{
		pgmList.add(pgmRS.getString("pgmid"));
	}

	clientStmt = dbConn.createStatement();
	clientRS = clientStmt.executeQuery(queryClient);

	if(clientRS.next())
	{
		clientList = new ArrayList();
		clientList.add(clientRS.getString("machineid"));
	}
	while(clientRS.next())
	{
		clientList.add(clientRS.getString("machineid"));
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
		if(pgmRS != null) pgmRS.close();
		if(clientRS != null) clientRS.close();
		if(pgmStmt != null) pgmStmt.close();
		if(clientStmt != null) clientStmt.close();
		if(dbConn != null) ConnectionManager.returnConnection(dbConn);
	}
	catch(Exception fexp)
	{
		fexp.printStackTrace(System.err);
	}
}

            _bw.write(_wl_block5Bytes, _wl_block5);

		if(pgmList != null)
		{
			for(int i=0;i<pgmList.size();i++)
			{
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(pgmList.get(i)));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(pgmList.get(i)));
            _bw.write(_wl_block8Bytes, _wl_block8);
		}
		}
	
            _bw.write(_wl_block9Bytes, _wl_block9);

		if(clientList != null)
		{
			for(int i=0;i<clientList.size();i++)
			{
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(clientList.get(i)));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf((i==0)?"selected":""));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(clientList.get(i)));
            _bw.write(_wl_block8Bytes, _wl_block8);
		}
		}
	
            _bw.write(_wl_block12Bytes, _wl_block12);

}
catch(Exception exp)
{
	exp.printStackTrace(System.err);
}

            _bw.write(_wl_block13Bytes, _wl_block13);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
