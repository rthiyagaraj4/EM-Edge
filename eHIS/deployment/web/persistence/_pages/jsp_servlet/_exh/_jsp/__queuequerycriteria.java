package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import eXH.XHDBAdapter;
import eXH.QueueManager;
import java.util.*;
import com.ehis.util.*;

public final class __queuequerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/QueueQueryCriteria.jsp", 1733051673162L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<HTML>\n<HEAD>\t\t\t\t\t\t  \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n \n<LINK REL=\'StyleSheet\' HREF=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></LINK> \n\n<SCRIPT LANGUAGE=\'javascript\' SRC=\'../../eCommon/js/common.js\'></SCRIPT>\n<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/CommonLookup.js\"></SCRIPT>\n<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/CommonCalendar.js\"></SCRIPT>\n<SCRIPT SRC=\"../../eCommon/js/ValidateControl.js\" LANGUAGE=\"javascript\"></SCRIPT>\n<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eXH/js/ManageQueue.js\"></SCRIPT>\n<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/jquery-3.6.3.js\"></SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</HEAD>\n\n<BODY onMouseDown=\"CodeArrest()\" onKeyDown =\'lockKey()\' onLoad=\"initFunc()\">\n<FORM name=\"queueCriteria\" id=\"queueCriteria\" ID=\"queueCriteria\" METHOD=\"post\" TARGET=\"queueResultFrame\" ACTION=\"../../servlet/eXH.ManagePatientQueue\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<TABLE ALIGN=\"CENTER\">\n<TR>\n\t<TD CLASS=\"label\">PatientID</TD>\n\t<TD CLASS=\"fields\">\n\t\t<INPUT TYPE=\"text\" name=\"patientID\" id=\"patientID\" ID=\"patientID\" VALUE=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =">\t\t\n\t</TD>\n\t<TD CLASS=\"label\">Queue No</TD>\n\t<TD CLASS=\"fields\">\n\t\t<INPUT TYPE=\"text\" name=\"ticketNo\" id=\"ticketNo\" ID=\"ticketNo\" VALUE=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =">\t\t\n\t</TD>\n<!-- \t<TD CLASS=\"label\">Work Station</TD>\n\t<TD CLASS=\"fields\">\n\t\t<INPUT TYPE=\"text\" name=\"workStation\" id=\"workStation\" ID=\"workStation\" VALUE=\"\">\t\t\n\t</TD> -->\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t<TD CLASS=\"label\">Counter</TD>\n\t<TD CLASS=\"fields\">\n\t\t<INPUT TYPE=\"text\" name=\"roomNo\" id=\"roomNo\" ID=\"roomNo\" VALUE=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =">\n\t</TD>\n\t<TD CLASS=\"label\">Service No</TD>\n\t<TD CLASS=\"fields\">\n\t\t<INPUT TYPE=\"text\" name=\"serviceNo\" id=\"serviceNo\" ID=\"serviceNo\" VALUE=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =">\n\t</TD>\n\t<TD CLASS=\"label\">Practitioner ID</TD>\n\t<TD CLASS=\"fields\">\n\t\t<INPUT TYPE=\"text\" name=\"practitionerID\" id=\"practitionerID\" ID=\"practitionerID\" VALUE=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =">\n\t</TD>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t<TD CLASS=\"label\">Workstation</TD>\n\t<TD CLASS=\"fields\">\n\t\t<INPUT TYPE=\"text\" name=\"workStation\" id=\"workStation\" ID=\"workStation\" VALUE=\"\">\n\t</TD>\n\t<TD CLASS=\"label\">Workflow</TD>\n\t<TD CLASS=\"fields\">\n\t\t<INPUT TYPE=\"text\" name=\"workflow\" id=\"workflow\" ID=\"workflow\" VALUE=\"\">\n\t</TD>\n\t<TD CLASS=\"label\">Username</TD>\n\t<TD CLASS=\"fields\">\n\t\t<INPUT TYPE=\"text\" name=\"userName\" id=\"userName\" ID=\"userName\" VALUE=\"\">\n\t</TD>\n\t</TR>\n\t<TR>\n\t<TD CLASS=\"label\">Scheduled Time</TD>\n\t<TD CLASS=\"fields\">\n\t\t<INPUT TYPE=\"text\" name=\"sheduledTime\" id=\"sheduledTime\" ID=\"sheduledTime\" VALUE=\"\">\n\t</TD>\n\t<TD CLASS=\"label\">Next Station</TD>\n\t<TD CLASS=\"fields\">\n\t\t<INPUT TYPE=\"text\" name=\"nextStation\" id=\"nextStation\" ID=\"nextStation\" VALUE=\"\">\n\t</TD>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n</TR>\n</TABLE>\n<TABLE ALIGN=\"right\">\n<TR>\n\t<TD CLASS=\"button\">\n\t\t<INPUT TYPE=\"button\" onClick=\"clearFrames(this)\" VALUE=\"Save\">\n\t\t<INPUT TYPE=\"button\" onClick=\"clearFrames(this)\" VALUE=\"Search\">\n\t</TD>\n</TR>\n</TABLE>\n<INPUT TYPE=\"hidden\" ID=\"actionType\" name=\"actionType\" id=\"actionType\" value=\"\">\n<INPUT TYPE=\"hidden\" ID=\"siteID\" name=\"siteID\" id=\"siteID\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n</FORM>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
 
	request.setCharacterEncoding("UTF-8");	
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";	
	Connection dbConn = null;

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	try
	{
		dbConn = ConnectionManager.getConnection(request);
		String patientID = XHDBAdapter.checkNull(request.getParameter("patientID"));
		String encounterID = XHDBAdapter.checkNull(request.getParameter("encounterID"));
		String facilityID = XHDBAdapter.checkNull(request.getParameter("facilityID"));
		String ticketNo = XHDBAdapter.checkNull(request.getParameter("ticketNo"));
		String roomNo = XHDBAdapter.checkNull(request.getParameter("roomNo"));
		String practitionerID = XHDBAdapter.checkNull(request.getParameter("practitionerID"));
		String serviceNo = XHDBAdapter.checkNull(request.getParameter("serviceNo"));
		String selected = "";
		String siteID = request.getParameter("siteID");

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf( patientID ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf( ticketNo ));
            _bw.write(_wl_block10Bytes, _wl_block10);

if(QueueManager.BRUNEI_SITE_ID.equals(siteID))
{

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf( roomNo ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf( serviceNo ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf( practitionerID ));
            _bw.write(_wl_block14Bytes, _wl_block14);

}
else
{

            _bw.write(_wl_block15Bytes, _wl_block15);

}

            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf( siteID ));
            _bw.write(_wl_block17Bytes, _wl_block17);

	}
	catch(Exception exp)
	{
		exp.printStackTrace(System.err);
	}
	finally
	{
		ConnectionManager.returnConnection(dbConn);
	}

            _bw.write(_wl_block18Bytes, _wl_block18);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
