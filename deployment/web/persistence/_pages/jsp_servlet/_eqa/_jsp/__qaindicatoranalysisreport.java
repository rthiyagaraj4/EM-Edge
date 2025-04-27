package jsp_servlet._eqa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;

public final class __qaindicatoranalysisreport extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eqa/jsp/QAIndicatorAnalysisReport.jsp", 1742817543783L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n   <html>\n\t<head>\n\t";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n\t<script type=\"text/javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script type=\"text/javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script type=\"text/javascript\" src=\"../../eQA/js/QAReport.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t</head>\n      <body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n      <form name=\'QAGeneral_report\' id=\'QAGeneral_report\'    action=\"../../eCommon/jsp/report_options.jsp\"   target=\"messageFrame\">\n      <BR><BR><BR>\n\t\t<div align=\'left\' >\n      \t<table width=\'60%\' border=0 align=\'center\'>\n      \t<tr><td  valign=\'center\' width=\'60%\' style=\"background-color:#E0E1EB;\">\n\n\t\t \t<center>\n      \t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' >\n      \t <tr><td colspan=3>&nbsp</td></tr>\n      \t\n      \t\t<tr><td colspan=3>&nbsp</td></tr>\n      \t\t\t  \t\n\t\t\t<tr>\n    \t\t\t<td width=\'30%\' align=\'right\' class=\'label\'>Clinical Indicator</td>\n      \t\t    <td width=\'70%\' colspan=\'2\'>&nbsp;&nbsp;<input type=\'text\' name=\'P_QIND_CLIND_NAME\' id=\'P_QIND_CLIND_NAME\' size=\'36\' maxlength=\'35\' value=\"\" onblur=\'funClinicianGroup(this); poprep();\' ><input type=\'button\' name=\'P_QIND_CLIEND_QUEST\' id=\'P_QIND_CLIEND_QUEST\' value=\'?\' class=\'button\' OnClick=\" funClinicianGroup(P_QIND_CLIND_NAME),poprep();\"><img align=\'center\' src=\'../../eCommon/images/mandatory.gif\'></img>\n                <input type=\"hidden\" name=\'P_QIND_CLIND_ID\' id=\'P_QIND_CLIND_ID\'; value=\"\">\n   \t\t    </tr>\n\t\t   \t<tr>\n\t\t\t\t<td colspan=3>&nbsp</td>\n\t\t\t</tr>\n      \t\t<tr>\n      \t\t\t<td width=\'30%\' align=\'right\' class=\'label\'>Report Periodicity</td>\n      \t\t\t<td width=\'70%\' align=\'left\' colspan=\'2\'>&nbsp;&nbsp;\n\t\t\t\t<select name=\'P_PERIODICITY\' id=\'P_PERIODICITY\' onChange=\'funPeriodicity()\'><option value=\'\'>&nbsp;&nbsp;-------- Select --------&nbsp;&nbsp;</option><option value=\'M\' >Monthly&nbsp;<option value=\'Q\'>Quarterly &nbsp;<option value=\'B\'>Bi-Annually &nbsp;<option value=\'A\'>Annually &nbsp;</select>\n\t\t   \t\t<img align=\'center\' src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t   \t\t</td>\n\t\t\t</tr>\n\t\t<tr><td colspan=3>&nbsp</td></tr>\n<tr>\n\t<td width=\'30%\' align=\'right\' class=label nowrap>From Period</td>\n\n\t<td width=\'70%\'  colspan=\'2\'>&nbsp;&nbsp;\n\t<input type=\'text\' name=\'P_FROM_YEAR\' id=\'P_FROM_YEAR\' value=\'";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\' onblur=\'check_from_date(this);\' size=10 maxlength=4>\n\n\t<select name=\'P_FROM\' id=\'P_FROM\'>\n\t<option value=\'\'>----Select-----</option>\n\t</select>   \t\t\n\n\n\t<img src=\'../../eCommon/images/mandatory.gif\' id=\'hide\'>\n\t</td>\n\t<td >&nbsp;</td>\n\n\t</tr>\n\t\t<tr><td colspan=3>&nbsp</td></tr>\n\t<tr>\n\t\t<td width=\'30%\' align=\'right\' class=label>To Period</td>\n\t\t<td width=\'70%\'  colspan=\'2\'>&nbsp;&nbsp;\n\t\t<input type=\'text\' name=\'P_TO_YEAR\' id=\'P_TO_YEAR\' value=\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'  onblur=\'check_to_date(this);\'  size=10 maxlength=4>\n\n\t\t<select name=\'P_TO\' id=\'P_TO\' onChange =\'check_all_date(this);\' >\n\t\t<option value=\'\'>-----Select-----\n\t\t</option>\n\t\t</select>   \t\t\n\t\t</td>\t\n\t\t<td >&nbsp;</td>\n\t</tr>\n      \t\t<tr><td colspan=3>&nbsp</td></tr>\n\t\t</table>\n      \t</td>\n\t\t</tr>\n      \t</table>\n      \t</div> \n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<input type=\"hidden\" name=\"P_FACILITY_ID\" id=\"P_FACILITY_ID\"\t\tvalue=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =">\n\t\t<input type=\"hidden\" name=\"p_module_id\" id=\"p_module_id\" \t\tvalue=\"MR\">\n\t\t<input type=\"hidden\" name=\"p_report_id\" id=\"p_report_id\" \t\tvalue=\"QABCLIND\">\n\t\t<input type=\"hidden\" name=\"p_user_name\" id=\"p_user_name\"\t\t\tvalue=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =">\n      \t</form>\n      \t</body>\n      \t</html>\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );
	  String facility_id="",login_user="";
      Properties p = null;
	  

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
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(new java.util.Date().getYear()+1900));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(new java.util.Date().getYear()+1900));
            _bw.write(_wl_block6Bytes, _wl_block6);
		
			HttpSession httpSession = request.getSession(false);
			p = (Properties)httpSession.getValue("jdbc"); 
			facility_id = (String)httpSession.getValue("facility_id");
			login_user =  p.getProperty("login_user");
			//resp_id= (String)httpSession.getValue("responsibility_id");	
		
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(login_user));
            _bw.write(_wl_block9Bytes, _wl_block9);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
