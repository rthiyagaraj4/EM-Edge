package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __multiselectionapptreschedulingresultframe extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/MultiSelectionApptReschedulingResultFrame.jsp", 1742295350931L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!--Created by Ashwini on 05-Apr-2024 for ML-MMOH-CRF-2060-->\r\n<!DOCTYPE html>\r\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \r\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\r\n\r\n<html>\r\n<head>\r\n\r\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\r\n\r\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\r\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script><script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\r\n<script language=\'javascript\' src=\'../../eOA/js/MultiSelectionApptRescheduling.js\'></script>\r\n\t\r\n</head>\r\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\r\n\r\n<frameset rows=\'*\'>\r\n<frameset cols=\'50%,4%,46%\'>\r\n\r\n\t<frame name=\'result1\' id=\'result1\' \tsrc=\'../../eOA/jsp/MultiSelectionApptReschedulingResult1.jsp?from_speciality=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&to_speciality=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&locn_type=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&from_locn=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&to_locn=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&from_resc=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&to_resc=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&from_date=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&to_date=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&from_res_class=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&to_res_class=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&oper_stn=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&from_page=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&visit_limit_rule=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' frameborder=0  scrolling=\'auto\' noresize>\r\n\t<frame name=\'gopage\' id=\'gopage\' \tsrc=\'../../eOA/jsp/MultiSelectionApptReschedulingResultGo.jsp?from_speciality=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' frameborder=0 scrolling=\'auto\' noresize>\r\n\t<frame name=\'result2\' id=\'result2\' \tsrc=\'../../eOA/jsp/MultiSelectionApptReschedulingResult2.jsp?from_speciality=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' frameborder=0 scrolling=\'auto\' noresize>\r\n\r\n</frameset>\t\t\t\t\t\r\n</frameset>\r\n\r\n</html>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	request.setCharacterEncoding("UTF-8");
	request = new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
	String from_speciality = request.getParameter("from_speciality") ;
	if(from_speciality ==null) from_speciality="";
	String to_speciality = request.getParameter("to_speciality") ;
	if(to_speciality ==null) to_speciality="";
	String locn_type=request.getParameter("locn_type");
	if(locn_type ==null) locn_type="";
	String from_locn=request.getParameter("from_locn");
	if(from_locn ==null) from_locn="";
	String to_locn=request.getParameter("to_locn");
	if(to_locn ==null) to_locn="";
	String from_resc=request.getParameter("from_resc");
	if(from_resc ==null)from_resc="";
	String to_resc=request.getParameter("to_resc");
	if(to_resc ==null) to_resc="";
	String from_date=request.getParameter("from_date");
	if(from_date ==null) from_date="";
	String to_date=request.getParameter("to_date");
	if(to_date ==null) to_date="";
	String from_res_class=request.getParameter("from_res_class");
	if(from_res_class ==null) from_res_class="";
	String to_res_class=request.getParameter("to_res_class");
	if(to_res_class ==null) to_res_class="";
	String oper_stn=request.getParameter("oper_stn");
	if(oper_stn ==null) oper_stn="";
	String from_page=request.getParameter("from_page");
	String visit_limit_rule=request.getParameter("visit_limit_rule");
	if(visit_limit_rule ==null) visit_limit_rule="N";			
	
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(from_speciality));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(to_speciality));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(locn_type));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(from_locn));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(to_locn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(from_resc));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(to_resc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(from_date));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(to_date));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(from_res_class));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(to_res_class));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(oper_stn));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(from_page));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(visit_limit_rule));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(from_speciality));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(to_speciality));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(locn_type));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(from_locn));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(to_locn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(from_resc));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(to_resc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(from_date));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(to_date));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(from_res_class));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(to_res_class));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(oper_stn));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(from_page));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(visit_limit_rule));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(from_speciality));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(to_speciality));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(locn_type));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(from_locn));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(to_locn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(from_resc));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(to_resc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(from_date));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(to_date));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(from_res_class));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(to_res_class));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(oper_stn));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(from_page));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(visit_limit_rule));
            _bw.write(_wl_block25Bytes, _wl_block25);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
