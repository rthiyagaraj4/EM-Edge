package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.util.*;
import java.sql.*;
import java.text.*;

public final class __maintaintreatmentpackmain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/MaintainTreatmentPackMain.jsp", 1740484175932L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \nSr No        Version           Incident             SCF/CRF             Developer Name\n--------------------------------------------------------------------------------------\n1            V210623            16777\t      PMG2021-COMN-CRF-0076      Palani Narayanan\n2            V210730            16777\t      PMG2021-COMN-CRF-0076      Mohana Priya\n3\t\t\tV230106\t\t\t\t36652\t\t\tTH-KW-CRF-0145.1\t\t\tMohanapriya\n -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n\n<HTML>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\' type=\'text/css\'/>\t\n\t<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n\t<script language=\'javascript\' src=\'../../eBL/js/json2.js\'></script>\n\t\n<script language=\'javascript\' src=\'../../eCommon/js/CommonCalendar.js\'></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script language=\"JavaScript\" src=\"../../eBL/js/MaintainTreamentPackage.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t<!-- <FRAMESET ROWS =\'6%,7%,7%,36%,35%,9%\' framespacing=0 name=\'BLMaintaintreatmentPackageframeset\'> -->\n\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t<!-- <FRAMESET ROWS =\'6%,7%,7%,36%,39%,5%\' framespacing=0 name=\'BLMaintaintreatmentPackageframeset\'> -->\n\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<!--<FRAMESET ROWS =\'6%,7%,7%,36%,39%,5%\' framespacing=0 name=\'BLMaintaintreatmentPackageframeset\'>-->\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<iframe name=\"commontoolbarFrame\" src=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\" frameborder=\"0\" scrolling=\"no\" noresize style=\"height:";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="; width:100vw\"></iframe> \n\t\t<iframe name=\"BLMaintaintreatmentPackagepat\" src=\"../../eBL/jsp/MainTreatmentPackageHdr.jsp?";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" frameborder=\"0\" style=\"height:";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="; width:100vw\"></iframe>\n\t\t<iframe name=\"BLMaintaintreatmentPackageHdr\" src=\"../../eCommon/html/blank.html\" frameborder=\"0\" style=\"height:";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="; width:100vw\"></iframe>\n\t\t<iframe name=\"BLMaintaintreatmentPackage\" src=\"../../eCommon/html/blank.html\" frameborder=\"0\" scrolling=\"auto\" style=\"height:";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="; width:100vw\"></iframe>\n\t\t<iframe name=\"BLMaintaintreatmentPackageserv\" src=\"../../eCommon/html/blank.html\" frameborder=\"0\" scrolling=\"auto\" style=\"height:";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="; width:100vw\"></iframe>\n\t\t<iframe name=\"messageFrame\" src=\"../../eCommon/jsp/error.jsp\" frameborder=\"0\" noresize scrolling=\"auto\" style=\"height:";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="; width:100vw\"></iframe>\n</HTML>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

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

	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

	String params = request.getQueryString();
	System.err.println("params--"+params);
	if(params==null || params.equals("")) params="";
	String function_id=request.getParameter("function_id");
	String module_id=request.getParameter("module_id");
	if(function_id==null || function_id.equals("")) function_id="";
	
	String calledFrom=request.getParameter("calledFrom");//V230106
	if(calledFrom==null || calledFrom.equals("")) calledFrom="";
	System.err.println("calledFrom MaintainTreatmentPackMain.jsp--"+calledFrom);
	String url ="";
    String height1, height2, height3, height4, height5, height6;
	if(calledFrom.equals("managePatientPopup")){
		url = "../../eCommon/jsp/MstCodeToolbar.jsp?home_required_yn=N";
		height1 = "6vh";  
        height2 = "9vh";   
        height3 = "8vh"; 
        height4 = "35vh";   
        height5 = "35vh";   
        height6 = "8vh";  
		
            _bw.write(_wl_block4Bytes, _wl_block4);

	}else{
		url = "../../eCommon/jsp/MstCodeToolbar.jsp?home_required_yn=Y";
		height1 = "6vh";  
        height2 = "9vh";  
        height3 = "8vh";   
        height4 = "35vh";   
        height5 = "35vh";   
        height6 = "5vh";   
		
            _bw.write(_wl_block5Bytes, _wl_block5);

	}//V230106
	
	String source = url + params;
	System.err.println("source MaintainTreatmentPackMain.jsp "+source);

            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf( source ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf( height1 ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(params));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf( height2 ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf( height3 ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf( height4 ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf( height5 ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf( height6 ));
            _bw.write(_wl_block15Bytes, _wl_block15);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
