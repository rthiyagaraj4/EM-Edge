package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __blcommonmenuframe extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLCommonMenuFrame.jsp", 1709728617789L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n<html>\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<title>Insert title here</title>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\nfunction refresh(){\n\tparent.refresh();\n}\n\nfunction closeWindow(){\n\tparent.closeWindow();\n}\n</script>\n</head>\n\t\n\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t<iframe name=\'BillingBanner\' id=\'BillingBanner\'\tsrc=\'../../eBL/jsp/InvokeBanner.jsp?episodetype=";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="&custgroupcode=";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="&custcode=";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="&userid=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="&functionid=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&blnggrpid=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'  frameborder=0  noresize style=\'height:50vh;width:100vw\'></iframe> \t\t\t\t\n\t\t<iframe name=\'BillingMenu\' id=\'BillingMenu\' \tframeborder=\'0\'\tsrc=\"../../eBL/jsp/BLToolbarDisplay.jsp?userid=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"  scrolling=\'no\' noresize style=\'height:50vh;width:100vw\'></iframe>\n\t\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t<iframe name=\'pline\' id=\'pline\' \t\tframeborder=\'0\'\tsrc=\"../../eCommon/jsp/pline.jsp?Patient_Id=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"  scrolling=\'no\' noresize style=\'height:30vh;width:100vw\'></iframe>\n\t\t<iframe name=\'BillingBanner\' id=\'BillingBanner\'\tsrc=\'../../eBL/jsp/InvokeBanner.jsp?episodetype=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"  scrolling=\'no\' noresize style=\'height:20vh;width:100vw\'></iframe>\n\t\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\n</html>\n\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

private String checkForNull(String input){
	if(input == null || "null".equals(input)){
		input = "";
	}
	return input;
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
            _bw.write(_wl_block2Bytes, _wl_block2);

String FacilityId = (String)session.getAttribute("facility_id");
String userId = (String) session.getValue("login_user");
String functionId= checkForNull(request.getParameter("functionId"));
functionId = "RS_LEAVE_DET";
String blng_grp_id= checkForNull(request.getParameter("blngGrpId"));
blng_grp_id = "CASH";
String payerGroup= checkForNull(request.getParameter("payerGroup"));
String payer= checkForNull(request.getParameter("payer"));
String episode_type= checkForNull(request.getParameter("episodeType"));
episode_type = "O";
String patient_id = checkForNull(request.getParameter("patientId"));



            _bw.write(_wl_block3Bytes, _wl_block3);
if("".equals(patient_id)){ 
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(episode_type ));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(payerGroup ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(payer ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(userId ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(functionId ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(blng_grp_id ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(userId ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(functionId ));
            _bw.write(_wl_block11Bytes, _wl_block11);
}else{ 
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(episode_type ));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(payerGroup ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(payer ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(userId ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(functionId ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(blng_grp_id ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(userId ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(functionId ));
            _bw.write(_wl_block14Bytes, _wl_block14);
} 
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
