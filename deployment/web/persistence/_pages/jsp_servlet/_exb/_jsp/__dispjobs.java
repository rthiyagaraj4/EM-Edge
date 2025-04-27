package jsp_servlet._exb._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eXH.XHUtil;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import webbeans.eCommon.ConnectionManager;
import eXH.XHDBAdapter;

public final class __dispjobs extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exb/jsp/dispJobs.jsp", 1709117561758L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 =" \n\t\t<table width=\'100%\'>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t\t\t<META HTTP-EQUIV=\"REFRESH\" CONTENT=\"10\">\n\t\t\t<tr>\n\t\t\t\t<td colspan=\"4\" align=\"right\">\n\t\t\t\t\t<a href=\"#\" onClick=\"reloadPage()\"><FONT class=\"HYPERLINK\"><fmt:message key=\"Common.Refresh.label\" bundle=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\"/></FONT></a>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\'COLUMNHEADER\'><fmt:message key=\"Common.Process.label\" bundle=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\"/></td>\n\t\t\t\t<td class=\'COLUMNHEADER\'><fmt:message key=\"Common.LastExecution.label\" bundle=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\"/></td>\n\t\t\t\t<td class=\'COLUMNHEADER\'><fmt:message key=\"Common.NextExecution.label\" bundle=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"/></td>\n\t\t\t\t<td class=\'COLUMNHEADER\'><fmt:message key=\"Common.status.label\" bundle=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"/></td>\n\t\t\t</tr>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<tr>\n\t\t\t\t<td>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="-";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t\t<td>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t\t</tr>\n\t\t</table>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

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

	String jobWhatStr = (String)request.getAttribute("jobWhatStr");
	String jobSearchQry = "SELECT job, to_char(last_date,'dd/mm/yyyy HH24:MI:SS') last_date, to_char(next_date,'dd/mm/yyyy HH24:MI:SS') next_date, what, DECODE(NVL(failures,0),0,'Submitted','Failed') prev_status, this_date FROM dba_jobs WHERE what LIKE '"+jobWhatStr+"%'";

	Connection dbConn	= null;
	Statement statement	= null;	
	ResultSet jobRS		= null;
	int tempCount = 0;

	try
	{
		if(dbConn == null) dbConn = ConnectionManager.getConnection();
		statement = dbConn.createStatement();
		jobRS = statement.executeQuery(jobSearchQry);

		while(jobRS.next())
		{

            _bw.write(_wl_block2Bytes, _wl_block2);
		if(tempCount == 0) { 
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block8Bytes, _wl_block8);

	tempCount++;
}
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf( XHDBAdapter.checkNull(jobRS.getString("job")) ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf( XHDBAdapter.checkNull(jobRS.getString("what")) ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf( XHDBAdapter.checkNull(jobRS.getString("last_date")) ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf( XHDBAdapter.checkNull(jobRS.getString("next_date")) ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf( (jobRS.getString("this_date") == null || jobRS.getString("this_date").equals(""))?jobRS.getString("prev_status"):"Running" ));
            _bw.write(_wl_block12Bytes, _wl_block12);

		}
	}
	catch(Exception exp)
	{
		System.out.println("(dispJobs:jobSearchQry) "+jobSearchQry);
		exp.printStackTrace(System.err);
	}
	finally
	{
		try
		{
			if(jobRS != null) jobRS.close();
			if(statement != null) statement.close();
			if(dbConn != null) ConnectionManager.returnConnection(dbConn);
		}
		catch(Exception fexp)
		{
			fexp.printStackTrace(System.err);
		}
	}

            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
