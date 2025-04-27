package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __blrcmtransresultqrybtn extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLRCMTransResultQryBtn.jsp", 1709114583946L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n<html>\n<head>\n</head>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\' type=\'text/css\'/>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script src=\'../../eBL/js/RCMTransactions.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n\n<body>\n<form name=\'BLRCMTransResultQryBtn\' id=\'BLRCMTransResultQryBtn\'>\n\n<table cellpadding=\'3\' cellspacing=\'0\'  width=\"100%\">\n\t<tr>\n\n\t\t<td width=\"70%\"  class=\'labels\' colspan=5></td>\n\t\t<td width=\"30%\" class=\'fields\'>\n\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t<input type=\'button\' name=\"send_to_insurance\" id=\"send_to_insurance\" id=\"send_to_insurance\" value=\"Send to Insurance\" class=\'button\' onclick=\'saveUserData();\' \n\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =">\n\t\t\t<input type=\'button\' name=\"export_to_excel\" id=\"export_to_excel\" id=\"export_to_excel\" value=\"Export to Excel\" class=\'button\' onclick=\"generateExcel(\'E\');\" >\n\n\t\t\t<input type=\"hidden\" name=\"p_ins_status\" id=\"p_ins_status\" id=\"p_ins_status\" value=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\" />\n\t\t\t<input type=\"hidden\" name=\"p_level_of_srch\" id=\"p_level_of_srch\" id=\"p_level_of_srch\" value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" />\n\t\t\t<input type=\"hidden\" name=\"p_sel_appr_doc_ref_no\" id=\"p_sel_appr_doc_ref_no\" id=\"p_sel_appr_doc_ref_no\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" />\n\t\t\t<input type=\"hidden\" name=\'p_facility_id\' id=\'p_facility_id\' id=\'p_facility_id\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n\t\t\t<input type=\"hidden\" name=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n\t\t\t<input type = \"hidden\" id = \"p_action_id\" name = \"p_action_id\" value = \"\" >\t\t\t\n\t\t\t\n\t\t</td>\n\t</tr>\n</table>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );
	
private String checkForNull(String inputString)
{
	return (inputString == null) ? "" :	inputString;
}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=ISO-8859-1");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);

		System.err.println("Query String in Btn.jsp:"+request.getQueryString());
		
		String disabled = "";
		String facilityId = (String)session.getAttribute("facility_id");
		String locale = (String)session.getAttribute("LOCALE");
		String listOfApprDocNum = checkForNull(request.getParameter("listOfApprDocNum"));
		String p_ins_status = checkForNull(request.getParameter("p_ins_status"));
		String p_level_of_srch = checkForNull(request.getParameter("p_level_of_srch"));

            _bw.write(_wl_block5Bytes, _wl_block5);
 if(!(p_ins_status.equals("P") || p_ins_status.equals("C") || p_ins_status.equals("**"))){ 
				disabled = "disabled";
			}
		
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(p_ins_status));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(p_level_of_srch));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(listOfApprDocNum));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(locale ));
            _bw.write(_wl_block12Bytes, _wl_block12);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
