package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eOR.*;
import eOR.Common.*;
import eCommon.Common.*;

public final class __ormasterreportticksheetsection extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/ORMasterReportTickSheetSection.jsp", 1709119876000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<HTML>\n<HEAD>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\' type=\'text/css\'/>\n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/common.js\"></SCRIPT>\n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/ValidateControl.js\"></SCRIPT>\n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/CommonLookup.js\"></SCRIPT>\n\n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../js/OrMasterReport.js\"></SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</HEAD>\n\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\"  onload=\"document.formOrRepTickSheetSectionCode.from_tick_sheet_section.focus();\">\n<BR>\n<FORM name=\"formOrRepTickSheetSectionCode\" id=\"formOrRepTickSheetSectionCode\" ACTION=\"../../eCommon/jsp/report_options.jsp\" TARGET=\"messageFrame\">\n\t<TABLE WIDTH=\"70%\" ALIGN=\"center\" CELLPADDING=\"0\" CELLSPACING=\"0\" BORDER=\"0\">\n\t\t<TH COLSPAN=\"3\" ALIGN=\"left\">Report Criteria</TH>\n\t\t<TR>\n\t\t\t<TD WIDTH=\"30%\">&nbsp;</TD>\n\t\t\t<TD CLASS=\"label\" ALIGN=\"left\" WIDTH=\"25%\">From</TD>\n\t\t\t<TD CLASS=\"label\" ALIGN=\"left\" WIDTH=\"45%\">To</TD>\n\t\t</TR>\n\t\t<TR>\n\t\t\t<TD ALIGN=\"right\" WIDTH=\"30%\" CLASS=\"label\">Tick Sheet Section Code &nbsp;</TD>\n\t\t\t<TD ALIGN=\"left\" WIDTH=\"25%\">\n\t\t\t<INPUT TYPE=text name=\"from_tick_sheet_section\" id=\"from_tick_sheet_section\" SIZE=\"8\" maxlength=\"8\" onBlur=\"ChangeUpperCase(this)\" onKeyPress=\"return CheckForSpecChars(event)\" tabIndex=\"1\">\n\t\t\t<INPUT TYPE=\"button\" name=\"from_button_tick_sheet_section\" id=\"from_button_tick_sheet_section\" VALUE=\"?\" CLASS=\"button\" onclick=\"searchCode(document.formOrRepTickSheetSectionCode, \'Tick Sheet Section\', from_tick_sheet_section)\"></TD>\n\t\t\t<TD ALIGN=\"left\" WIDTH=\"45%\">\n\t\t\t\t<INPUT TYPE=text name=\"to_tick_sheet_section\" id=\"to_tick_sheet_section\" SIZE=\"8\" maxlength=\"8\" onBlur=\"ChangeUpperCase(this)\" onKeyPress=\"return CheckForSpecChars(event)\" tabIndex=\"2\">\n\t\t\t\t<INPUT TYPE=\"button\" name=\"to_button_tick_sheet_section\" id=\"to_button_tick_sheet_section\" VALUE=\"?\" CLASS=\"button\" onclick=\"searchCode(document.formOrRepTickSheetSectionCode, \'Tick Sheet Section\',to_tick_sheet_section)\">\n\t\t\t</TD>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \n\t\t\t\n\t\t</TR>\n\t\t<TR>\n\t\t\t<TD COLSPAN=\"3\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR>\n\t\t\t<TD ALIGN=\"right\" WIDTH=\"30%\" CLASS=\"label\">Nature &nbsp;</TD>\n\t\t\t<TD COLSPAN=\"2\" ALIGN=\"left\">\n\t\t\t\t<SELECT name=\"o_effstat\" id=\"o_effstat\" tabIndex=\"3\">\n\t\t\t\t\t<OPTION VALUE=\"\">Both</OPTION>\n\t\t\t\t\t<OPTION VALUE=\"E\">Enabled</OPTION>\n\t\t\t\t\t<OPTION VALUE=\"D\">Disabled</OPTION>\n\t\t\t\t</SELECT>\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR>\n\t\t\t<TD COLSPAN=\"3\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR>\n\t\t\t<TD ALIGN=\"right\" WIDTH=\"25%\" CLASS=\"label\">Order By &nbsp;</TD>\n\t\t\t<TD COLSPAN=\"2\" ALIGN=\"left\">\n\t\t\t\t<SELECT name=\"o_orderby\" id=\"o_orderby\" tabIndex=\"4\">\n\t\t\t\t\t<OPTION VALUE=\"2\">Order Type Category </OPTION>\n\t\t\t\t\t<OPTION VALUE=\"3\">Order Type Code</OPTION>\n\t\t\t\t</SELECT>\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR>\n\t\t\t<TD COLSPAN=\"3\">&nbsp;</TD>\n\t\t</TR>\n\t</TABLE>\t   ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<input type=hidden  name=\'SQL_OR_REPORTS_TICK_SHEET_SECTION_LOOKUP\' id=\'SQL_OR_REPORTS_TICK_SHEET_SECTION_LOOKUP\'     value=\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' >\n\t\n\t<INPUT TYPE=\"hidden\" name=\"o_facility_id\" id=\"o_facility_id\" VALUE=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'>\n\t<INPUT TYPE=\"hidden\" NAME=o_user_name\" VALUE=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'>\n\t<INPUT TYPE=\"hidden\" name=\"o_module_id\" id=\"o_module_id\" VALUE=\"OR\">\n\t<INPUT TYPE=\"hidden\" name=\"o_report_id\" id=\"o_report_id\" VALUE=\"ORTSCFRM\">\n\t\t\t\t\t\t\t\t\t  ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n</FORM>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block5Bytes, _wl_block5);
try{
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(OrRepository.getOrKeyValue("SQL_OR_REPORTS_TICK_SHEET_SECTION_LOOKUP")));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf( session.getValue( "facility_id" ) ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf( session.getValue( "login_user" ) ));
            _bw.write(_wl_block9Bytes, _wl_block9);
}catch(Exception e){out.println(e);}
            _bw.write(_wl_block10Bytes, _wl_block10);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
