package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __dispmedicationdetailframeset extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/DispMedicationDetailFrameSet.jsp", 1734671356042L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<HTML>\n<HEAD>\n<TITLE>Disp Queue Medication Frameset</TITLE>\n</HEAD>\n\n<!-- <FRAMESET cols=\"20%,*\" name=\"DispMedicationDetailFrameSet\"id=\"DispMedicationDetailFrameSet\" frameborder=\"0\">\n\t<FRAMESET COLS=\"100%,0%\" name=\"DispMedicationDetailSubFrameSet_1\" id=\"DispMedicationDetailSubFrameSet_1\" frameborder=\"0\">\n\t<FRAME SRC=\"../../eCommon/html/blank.html\" name=\"DispMedicationPatFrame\" id=\"DispMedicationPatFrame\"></FRAME>\t \n\t<FRAME SRC=\"../../eCommon/html/blank.html\"  name=\"DispMedicationPatDetFrame_1\"id=\"DispMedicationPatDetFrame_1\"></FRAME>\n\t</FRAMESET>\n\t<FRAMESET rows=\"20%,80%\" name=\"DispMedicationDetailSubFrameSet_2\"id=\"DispMedicationDetailSubFrameSet_2\" frameborder=\"0\">\n\t<FRAME SRC=\"../../eCommon/html/blank.html\" name=\"DispMedicationPatDetFrame_2\" id=\"DispMedicationPatDetFrame_2\"></FRAME>\t\n\t<FRAME SRC=\"../../eCommon/html/blank.html\"  name=\"DispMedicationPatDetFrame_3\"id=\"DispMedicationPatDetFrame_3\"></FRAME>\n\t</FRAMESET>\n</FRAMESET> -->\n<body style=\"margin:2px;\">\n<div  name=\"DispMedicationDetailFrameSet\"id=\"DispMedicationDetailFrameSet\" style=\"display:flex; flex-direction: column\" > \n    <div name=\"DispMedicationDetailSubFrameSet_1\" id=\"DispMedicationDetailSubFrameSet_1\" style=\"display:flex; flex-direction: column; height:30vh;\">\n    \t<iframe SRC=\"../../eCommon/html/blank.html\" name=\"DispMedicationPatFrame\" id=\"DispMedicationPatFrame\" style=\"height: 37vh; width: 99vw;\"></iframe> \n\t\t<iframe SRC=\"../../eCommon/html/blank.html\"  name=\"DispMedicationPatDetFrame_1\"id=\"DispMedicationPatDetFrame_1\" style=\"height: 37vh; width: 64vw; display:none\"></iframe>\n    </div>\n    <div name=\"DispMedicationDetailSubFrameSet_2\"id=\"DispMedicationDetailSubFrameSet_2\" style=\"display:none; flex-direction: row; height:65vh;\">\n    \t<iframe SRC=\"../../eCommon/html/blank.html\" name=\"DispMedicationPatDetFrame_2\" id=\"DispMedicationPatDetFrame_2\" style=\"height: 90vh; width: 20vw;\"></iframe>\n\t\t<iframe SRC=\"../../eCommon/html/blank.html\"  name=\"DispMedicationPatDetFrame_3\"id=\"DispMedicationPatDetFrame_3\"style=\"height: 90vh; width: 70vw;\"></iframe>\n    </div>\n</div>\n</body>\n\n\n\n</HTML>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

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
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
