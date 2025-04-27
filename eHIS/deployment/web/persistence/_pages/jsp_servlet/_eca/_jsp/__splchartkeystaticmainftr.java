package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;

public final class __splchartkeystaticmainftr extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/SplChartKeyStaticMainFtr.jsp", 1731061457369L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n\t\t<title>SplChartKeyStaticMainFtr</title>\n\t\t<script src=\'../../eCA/js/SplChartKey.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t<script language=\"JavaScript\">\n\t\t\tfunction addMoreRows()\n\t\t\t{\n\t\t\t\tvar formObj = parent.frameSplChartKeyStaticMainDtl.document.SplChartKeyStaticMainDtl;\n\t\t\t\tvar total\t= formObj.rec_count.value;\n\t\t\t\tvar count\t= parseInt(total) + 5; \n\t\t\t\tclassval = \"gridData\";\n\t\t\t\tfor (j=parseInt(total)+1;j<=count;j++ )\n\t\t\t\t{\n\t\t\t\t\t/*if(j % 2 == 0 )\n\t\t\t\t\t{\n\t\t\t\t\t\tclassval\t=\t\"QRYEVEN\";\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tclassval\t=\t\"QRYODD\";\n\t\t\t\t\t}*/\n\t\t\t\t\tcurr_row\t= parent.frameSplChartKeyStaticMainDtl.document.getElementById(\'splchart_details\').insertRow();\n\t\t\t\t\t\t\t\n\t\t\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\t\t\tcurr_row.cells[0].className = \'gridNumericData\';\n\t\t\t\t\tcurr_row.cells[0].innerHTML = \"&nbsp;\"+(j)+\"&nbsp;\";\n\t\t\t\t\tcurr_row.cells[0].align = \"right\";\n\t\t\t\t\t\n\t\t\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\t\t\tcurr_row.cells[1].className = classval;\n\t\t\t\t\tcurr_row.cells[1].innerHTML = \"<input type=\'text\'  name=\\\"start_value\"+j+\"\\\" id=\\\"start_value\"+j+\"\\\" maxlength=11 value=\'\' onkeypress=\\\"return allowPositiveNumber();\\\"  onBlur=\\\"checkPositiveNumber(this);\\\" readOnly>\";\n\t\t\t\t\tcurr_row.cells[1].align = \"center\";\n\t\t\t\t\n\t\t\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\t\t\tcurr_row.cells[2].className = classval;\n\t\t\t\t\tcurr_row.cells[2].innerHTML = \"<input type=\'text\'  name=\\\"end_value\"+j+\"\\\" id=\\\"end_value\"+j+\"\\\" maxlength=11 value=\'\' onkeypress=\\\"return checkval3(\"+j+\")\\\"  onBlur=\\\"if(checkPositiveNumber(this)) if(checkval2(\"+j+\")) setNextFirstValue(this,\"+j+\");\\\">\";\n\t\t\t\t\tcurr_row.cells[2].align = \"center\";\n\t\t\t\t}\n\t\t\t\tvar j = parseInt(total);\n\t\t\t\tformObj.elements[j*2].value = formObj.elements[(j*2)-1].value;\n\t\t\t\tformObj.elements[(j*2)+1].focus();\n\t\t\t\t\n\t\t\t\tformObj.rec_count.value = count;\n\t\t\t}\n\t\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n</head>\n\n<body OnMouseDown=\"CodeArrest()\"; onKeyDown=\"lockKey()\">\n<br>\n<table cellpadding=\'3\' cellspacing=\'0\' border=\'0\' width=\'98%\' align=\'center\'>\n\n<tr>\n\t<td align=\'right\'><input type=\'button\' class=\'button\' \n\tvalue = \'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' onClick=\'addMoreRows()\'/></td>\n</tr>\n\n</table>\n</body>\n</html>\n\n";
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

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AddRows.label","ca_labels")));
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
