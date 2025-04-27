package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.lang.*;
import java.text.*;
import java.util.*;
import webbeans.eCommon.*;

public final class __ipgraphicalbbedchartmain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/IPGraphicalbBedChartMain.jsp", 1738425919909L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!DOCTYPE>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\t";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<html>\n\t<head>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n\t\t<script src=\"../js/json2.js\" language=\"JavaScript\"></script>\n\t\t<!-- <script src=\"../../eIP/js/IPAdvBedMgmtTrns.js\" language=\"JavaScript\"></script> -->\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\t\t<!--<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\'    src=\'../../eCommon/jsp/commonToolbar.jsp\' frameborder=0 scrolling=\'no\' noresize style=\'height:0vh;width:0vw\'></iframe> --> \n\t\t\t<iframe name=\'TitleFrame\' id=\'TitleFrame\' src=\'IPAdvBedMgmtTitle.jsp\' noresize  frameborder=no marginheight=0 marginwidth=0 SCROLLING=\'no\' noresize style=\'height:3vh;width:100vw\'></iframe>\n\t\t\t<iframe name=\'topcrumb\' id=\'topcrumb\' src=\'IPAdvBedMgmtTopCrumb.jsp\' noresize  frameborder=no marginheight=0 marginwidth=0 SCROLLING=\'no\' noresize style=\'height:6vh;width:100vw\'></iframe>\n\t\t\t<iframe name=\'serachFrame\' id=\'serachFrame\' \t\tsrc=\'../../eIP/jsp/IPAdvBedMgmtCriteria.jsp?called_from=bed_mgmt_trns&function_id=";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\' frameborder=0 scrolling=\'auto\' style=\'height:4vh;width:100vw\'></iframe>\n\t\t\t<!-- <iframe name=\'legendFrame\' id=\'legendFrame\' src=\'../jsp/IPAdvBedMgmtColorSchema.jsp\' frameborder=0 noresize scrolling=\'auto\'> -->\n\t\t\t<iframe name=\'legendFrame\' id=\'legendFrame\' src=\'../jsp/IPAdvBedMgmtLegendPanel.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:7vh;width:100vw\'></iframe>\n\t\t\t<iframe name=\'adv_bed_mgmt\' id=\'adv_bed_mgmt\' \t\tsrc=\'../../eCommon/html/blank.html\' frameborder=0 scrolling=\'no\' style=\'height:70vh;width:100vw\'></iframe>\n\t\t\t<iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\' noresize  frameborder=0  marginheight=0 marginwidth=0 SCROLLING=\'auto\' noresize style=\'height:5vh;width:100vw\'></iframe>\n\t\t\n</html>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

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
  
		//String nursingUnit=request.getParameter("nursingUnit")==null?"":request.getParameter("nursingUnit");
		//Below code was Added by N Munisekhar on 08-JAN-2013 against [IN037130]
		String function_id=request.getParameter("function_id");
        if(function_id == null) function_id = "";
	
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block3Bytes, _wl_block3);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
