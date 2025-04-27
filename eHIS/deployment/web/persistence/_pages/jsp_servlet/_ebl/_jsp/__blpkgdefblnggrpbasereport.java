package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __blpkgdefblnggrpbasereport extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLPkgDefBlngGrpBaseReport.jsp", 1709114571212L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<html>\n<head><title></title>\n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link>\n<script src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script src=\"../../eBL/js/PkgDef.js\" ></script>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script language=\'JavaScript\' src=\'../../eCommon/js/messages.js\'></script>\n<script language=\'JavaScript\' src=\'../../eOT/js/OTMessages.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n</head>\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<form name=\'BLReportOptionsForm\' id=\'BLReportOptionsForm\' action=\"../../eCommon/jsp/report_options.jsp\" target=\"messageFrame\">\n\t\t\n\t<input type=\"hidden\" name=\"p_module_id\" id=\"p_module_id\" \tvalue=\"BL\" />\n\t<input type=\"hidden\" name=\"p_report_id\" id=\"p_report_id\" \tvalue=\"BLPKGBLG\" />\n\t<input type=\"hidden\" name=\"p_language_id\" id=\"p_language_id\"\tvalue=\"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\"/>\n\t<input type=\"hidden\" name=\"P_PACKAGE_CODE\" id=\"P_PACKAGE_CODE\" \tvalue=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\" />\t\n\t<input type=\"hidden\" name=\"P_EFF_FROM_DT\" id=\"P_EFF_FROM_DT\" \tvalue=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\" />\t\n\t<input type=\"hidden\" name=\"P_BLNG_CLASS\" id=\"P_BLNG_CLASS\" \tvalue=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\" />\n\t<input type=\"hidden\" name=\"p_facility_id\" id=\"p_facility_id\" \tvalue=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\" />\n\t<input type=\"hidden\" name=\"P_BLNG_GRP_CODE\" id=\"P_BLNG_GRP_CODE\" value=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\" />\n\t\n</form>\n</body>\n</html>\n<script>\n\tPkgBlngGrpBaseRun();\n</script>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

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
 request.setCharacterEncoding("UTF-8");	

	String facilityId	= request.getParameter("facilityId");
	System.out.println("facilityId in Billing group "+facilityId);
	String packageCode	= request.getParameter("packageCode");
	String fromDate		= request.getParameter("fromDate");	
	String blgClsCode	= request.getParameter("blgClsCode");
	String blng_grp_code= request.getParameter("blng_grp_code");
	if(facilityId == null) facilityId="";
	if(packageCode == null) packageCode="";
	if(blgClsCode == null) blgClsCode="";
	if(blng_grp_code == null) blng_grp_code="";
	
	System.out.println("packageCode in billing grp "+packageCode);
	System.out.println("fromDate in billing grp "+fromDate);
	System.out.println("blgClsCode in billing grp "+blgClsCode);
	System.out.println("P_BLNG_GRP_CODE in billing grp "+blng_grp_code);
	
    String locale = (String)session.getAttribute("LOCALE");
	locale=locale.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(packageCode));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(fromDate));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(blgClsCode));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(blng_grp_code));
            _bw.write(_wl_block8Bytes, _wl_block8);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
