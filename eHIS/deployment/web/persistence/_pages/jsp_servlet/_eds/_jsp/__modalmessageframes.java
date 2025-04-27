package jsp_servlet._eds._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __modalmessageframes extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eds/jsp/ModalMessageFrames.jsp", 1724772112000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n<script type=\"text/javascript\" src=\"";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="/framework/js/hashtable.js\"></script>\n<script type=\'text/javascript\' src=\'";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="/eDS/js/MealPreparedServedComplaints.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<title>";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="</title>\n<script>\nfunction reset()\n{\n\twindow.returnValue=true; \n\twindow.close();\n}\n</script>\n\t<iframe name=\"linenDeliver\" id=\"linenDeliver\" scrolling=\'no\' src=\'../../eDS/jsp/MealPrepareServedRejectedItems.jsp?method=1&rejectedItem=Y&encounterId=";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="&mealType=";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="&servingDate=";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="&languageId=";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="&eventDate=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="&sourceCode=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&patientClass=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&kitchenCode=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&patientId=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&dietType=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&mealClass=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&complaintDesc=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&complaintCode=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&status=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&menuCode=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&mealCategory=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&splFoodItemYn=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&fName=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&othersComp=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&isMealComplaints=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' / style=\'height:91vh;width:97vw;border:4\'></iframe>\n\t\t<!-- Added Against ML-MOH-CRF-1125(othersComp) -- >\n\t\t\n\t\t<iframe scrolling=\"no\" name=\"messageFrame\" id=\"messageFrame\" src= \"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="/core/jsp/MessageFrame.jsp\" / style=\"height:7vh;width:100vw;border:4\"></iframe>\n</html>\n\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

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
            out.print( String.valueOf(request.getContextPath()));
            _bw.write(_wl_block1Bytes, _wl_block1);
            out.print( String.valueOf(request.getContextPath()));
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(request.getParameter("title")));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(request.getParameter("encounterId")));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(request.getParameter("mealType")));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(request.getParameter("servingDate")));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(request.getParameter("languageId")));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(request.getParameter("eventDate")));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(request.getParameter("sourceCode")));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(request.getParameter("patientClass")));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(request.getParameter("kitchenCode")));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(request.getParameter("patientId")));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(request.getParameter("dietType")));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(request.getParameter("mealClass")));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(request.getParameter("complaintDesc")));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(request.getParameter("complaintCode")));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(request.getParameter("status")));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(request.getParameter("menuCode")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(request.getParameter("mealCategory")));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(request.getParameter("splFoodItemYn")));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(request.getParameter("fName")));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(request.getParameter("othersComp")));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(request.getParameter("isMealComplaints")));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(request.getContextPath()));
            _bw.write(_wl_block24Bytes, _wl_block24);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
