package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __blrcmtransresultqrybtn1 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eBL/jsp/BLRCMTransResultQryBtn1.jsp", 1726114655730L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n<html>\r\n<head>\r\n</head>\r\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\r\n\r\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\r\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\' type=\'text/css\'/>\r\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\r\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\r\n<script src=\'../../eBL/js/RCMTransactions.js\' language=\'javascript\'></script>\r\n\r\n\r\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\r\n\r\n\r\n<body>\r\n<form name=\'BLRCMTransResultQryBtn\'>\r\n\r\n<table cellpadding=\'3\' cellspacing=\'0\'  width=\"100%\">\r\n\t<tr>\r\n\r\n\t\t<td width=\"40%\"  class=\'labels\' colspan=5></td>\r\n\t\t<td width=\"60%\" class=\'fields\' align=\"right\">\r\n\t\t\r\n\t\t\r\n\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\r\n\t\t\t\r\n\t\t\t<input type=\'button\' name=\"exportAsOffline_excel\" id=\"exportAsOffline_excel\" value=\"Generate Claim Offline\" class=\'button\' onclick=\"generateOfflineClaim(\'O\')\" >\r\n\t\t\r\n\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\r\n\t\t\r\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\r\n\t\t\t<input type=\'button\' name=\"reviewApprove\" id=\"reviewApprove\" value=\"Review & Approve\" class=\'button\' onclick=\"reviewApproveStatus();\" >\r\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\r\n\t\t\t<input type=\'button\' name=\"revertStatus\" id=\"revertStatus\" value=\"Revert Status\" class=\'button\' onclick=\"revertTransStatus();\" >\t\r\n\t\t\t<input type=\'button\' name=\"sendToInsurance\" id=\"sendToInsurance\" value=\"Send to Insurance\" class=\'button\' onclick=\'saveInsData();\' >\r\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\r\n\t\t<input type=\'button\' name=\"markAsFinal\" id=\"markAsFinal\" value=\"Mark as Finalized\" class=\'button\' onclick=\'markAsFinalized();\' >\r\n\t\t<input type=\'button\' name=\"sendToInsurance\" id=\"sendToInsurance\" value=\"Send to Insurance\" class=\'button\' onclick=\'saveInsData();\' >\r\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\r\n\t\t\t<input type=\'button\' name=\"sendToInsurance\" id=\"sendToInsurance\" value=\"Send to Insurance\" class=\'button\' onclick=\'saveInsData();\' >\r\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\r\n\t\t\r\n\t\t<input type=\'button\' name=\"exportToExcel\" id=\"exportToExcel\" value=\"Export to Excel\" class=\'button\' onclick=\"generateExcel(\'E\');\" >\r\n\t\t\r\n\t\t\t<input type=\"hidden\" name=\"p_ins_status\" id=\"p_ins_status\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" />\r\n\t\t\t<input type=\"hidden\" name=\'p_facility_id\' id=\'p_facility_id\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\r\n\t\t\t<input type=\"hidden\" name=\'locale\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\r\n\t\t\t<input type = \"hidden\" id = \"p_action_id\" name = \"p_action_id\" value = \"\" >\t\t\r\n\t\t\t<input type=\"hidden\" name=\"p_level_of_srch\" id=\"p_level_of_srch\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" />\t\t\t\r\n\t\t\t<input type = \"hidden\" id = \"p_where_condition\" name = \"p_where_condition\" value = \"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" >\r\n\t\r\n\t\t</td>\r\n\t</tr>\r\n</table>\r\n</form>\r\n</body>\r\n</html>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );
	
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

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

		
		String disabled = "";
		String facilityId = (String)session.getAttribute("facility_id");
		String locale = (String)session.getAttribute("LOCALE");
		String p_ins_status = checkForNull(request.getParameter("p_ins_status"));
		String eligibleForResubmit = checkForNull(request.getParameter("eligibleForResubmit"));
		String p_level_of_srch = checkForNull(request.getParameter("p_level_of_srch"));
		System.err.println("p_level_of_srch in BLRCMTransResultQryBtn1.jsp: "+p_level_of_srch);		
		String sql_for_export = checkForNull(request.getParameter("sql_for_export"));
		System.err.println("sql_for_export is: "+sql_for_export);

            _bw.write(_wl_block4Bytes, _wl_block4);
 if("N".equals(p_ins_status) || "R".equals(p_ins_status) || "L".equals(p_ins_status) || "E".equals(p_ins_status) ){ 
            _bw.write(_wl_block5Bytes, _wl_block5);
} 
            _bw.write(_wl_block6Bytes, _wl_block6);
 if(p_ins_status.equals("P")){ 
				//disabled = "disabled";
			
		
            _bw.write(_wl_block7Bytes, _wl_block7);
 }else if("N".equals(p_ins_status)){ 
            _bw.write(_wl_block8Bytes, _wl_block8);
  }else if("Y".equals(eligibleForResubmit) && ("R".equals(p_ins_status) || "L".equals(p_ins_status) || "B".equals(p_ins_status))){ 
            _bw.write(_wl_block9Bytes, _wl_block9);
 } else if(p_ins_status.equals("E")){
            _bw.write(_wl_block10Bytes, _wl_block10);
 } 
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(p_ins_status));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(locale ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(p_level_of_srch));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(sql_for_export));
            _bw.write(_wl_block16Bytes, _wl_block16);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
