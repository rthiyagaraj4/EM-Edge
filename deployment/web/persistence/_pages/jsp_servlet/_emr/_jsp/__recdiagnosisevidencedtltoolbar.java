package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;

public final class __recdiagnosisevidencedtltoolbar extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/RecDiagnosisEvidenceDtlToolBar.jsp", 1740481578889L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n    ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCA/html/CAStyle.css\"></link>\n\n\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\n<script language=\'JavaScript\'>\nfunction close_function()\n{\n\t\n\tif(parent.frames[0].document.forms[0].flag.value==0 && parent.frames[1].document.forms[0].flag.value==0)\n\t{\n\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));\n\t\twindow.close();\n\t}\n}\n\nfunction  subwindow(obj,nature)\n{\n\tvar factors = \"\";\n\tvar cnt = 0;\n\tvar cnt1 = 0;\n\tif(nature!=\"W\" && nature!=\"\")\n\t{\n\t\tvar ilCount = parent.frames[0].document.forms[0].ilCount.value\n\t\tfor(var index  = 0; index< parseInt(ilCount);index++)\n\t\t{\n\t\t\tvar objCheck = eval(\"parent.frames[0].document.forms[0].evidence\"+index)\n\t\t\tif(objCheck.checked==true)\n\t\t\t{\n\t\t\t\tif(factors==\"\")\n\t\t\t\tfactors = objCheck.value\n\t\t\t\telse\n\t\t\t\tfactors = factors + \"~\" +  objCheck.value\n\t\t\t\tcnt++;\n\t\t\t}\n\t\t }\n\t}\n\t  var ilRow = parent.frames[1].document.forms[0].ilRow.value;\n\t  var defn_chars = \"\"\n\t  for(var index  = 0; index < parseInt(ilRow);index++)\n\t  {\n\t\tvar objCheck = eval(\"parent.frames[1].document.forms[0].evidence\"+index)\n\t\tif(objCheck.checked==true)\n\t\t\t{\n\t\t\t\tif(defn_chars==\"\")\n\t\t\t\tdefn_chars = objCheck.value\n\t\t\t\telse\n\t\t\t\tdefn_chars = defn_chars + \"~\" +  objCheck.value\n\t\t\t\tcnt++;\n\t\t\t}\n\t  }\n\n\t\t/*if((cnt == 0 && ( nature!=\"W\" && nature!=\"\")) && cnt1 == 0 )\n\t\t{\n\t\talert(getMessage(\'MR_SELECT_ONE_FTR_CODE\',\'MR\'));\n\t\t\tobj.disabled = true;\n\t\t\treturn false;\n\t\t}\n\t\telse if( cnt1 == 0 && ( nature==\"W\" || nature==\"\"))\n\t\t{\n\t\talert(getMessage(\'MR_SELECT_ONE_FTR_CODE\',\'MR\'));\n\t\t\tobj.disabled = true;\n\t\t\treturn false;\n\t\t}*/\n\t\tif(cnt == 0)\n\t\t{\n\t\t\t\n\t\t\talert(getMessage(\'MR_SELECT_ONE_FTR_CODE\',\'MR\'));\n\t\t\tobj.disabled = true;\n\t\t\treturn false;\n\t\t}\n\t\telse\n\t\t{\n\t\t\t var p_factor_type =\"\";\n\t\t\t if(nature!=\"W\" && nature!=\"\")\n\t\t\t{\n\t\t\t\t  p_factor_type= parent.frames[0].document.forms[0].Eve_factor_type.value;\n\t\t\t}\n\t\t\t var d_factor_type = parent.frames[1].document.forms[0].define_factor_type.value;\n\t\t\twindow.returnValue = factors + \"||\" + defn_chars+\"#\"+p_factor_type + \"^\" + d_factor_type;\n\t\t\t window.close();\n\t\t}\n}\n\nfunction closew()\n{\t\n\twindow.returnValue=\'\'\n\twindow.parent.close();\n}\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<body onKeyDown=\'lockKey()\'>\n<form name=\"RecDiagnosisEvidenceDtlToolbarForm\" id=\"RecDiagnosisEvidenceDtlToolbarForm\">\n\n\t<input type=\"hidden\" name = \"as_evidenced_by_fact\" value=\"\">\n\t<input type=\"hidden\" name = \"as_evidenced_by_defn\" value=\"\">\t\n\t<input type=\"hidden\" name = \"p_factor_type\" value=\'\'>\n\t<input type=\"hidden\" name = \"d_factor_type\" value=\'\'>\t\n\n<div align=\'right\'>\n<table  cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' height=\'100%\' >\n\t\t\t<tr align=\"center\">\n\t\t\t\t<td colspan=\'4\'>&nbsp;</td>\n\t\t\t\t<td class=\'button\' align=\"right\">\n\t\t\t\t<input type=\'button\' name=\'OK\' id=\'OK\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' onClick=\"subwindow(this,\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\')\" class=\'button\'>\n\t\t\t\t<input type=\'button\' name=\'Cancel\' id=\'Cancel\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' onClick=\'window.close();\' class=\'button\'>\n\t\t\t\t</td>\n\t\t\t</tr>\n</form>\n</table>\t\n</div>\n<script>\n\tsetTimeout(\'close_function()\',1000)\n</script>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

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
 request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	String nature= request.getParameter("nature")==null?"":request.getParameter("nature");

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(nature));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
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
