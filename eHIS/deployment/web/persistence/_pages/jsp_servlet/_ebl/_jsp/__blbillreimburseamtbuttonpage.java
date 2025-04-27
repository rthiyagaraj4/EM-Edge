package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.io.*;
import java.util.*;
import com.ehis.util.*;

public final class __blbillreimburseamtbuttonpage extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLBillReimburseAmtButtonPage.jsp", 1725431093824L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\'javascript\' src=\'../../eBL/js/BLBillReimburseAmtDetails.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n <script>\n\tfunction cancel()\n\t{\n\t\t//parent.window.returnValue = \"N\";\n\t\t//parent.window.close();\n\t\tlet dialogBody = parent.parent.parent.document.getElementById(\'dialog-body\');\n\t\tdialogBody.contentWindow.returnValue = \"N\"; \n\t\tconst dialogTag = parent.parent.parent.document.getElementById(\"dialog_tag\");    \n\t\tdialogTag.close(); \n\t\t\n\t}\n\tfunction funSubmit()\n\t{\n\t\t//alert(\"1\");\n\t\tvar toc_rec = parent.frames[2].document.forms[0].total_records.value;\n\n\t\tfor(var i=0;i<toc_rec;i++)\n\t\t{\n\t\t\tvar stup_reimb_YN = eval(\"parent.frames[1].document.forms[0].stup_reimb_YN_\"+i);\n\t\t\tvar stup_reimb_type = eval(\"parent.frames[1].document.forms[0].stup_reimb_type_hid_\"+i);\n\t\t\tvar stup_reimb_amt = eval(\"parent.frames[1].document.getElementById(\'stup_reimb_amt_\')\"+i);\n\n\t\t\tvar rtn_stup_reimb_YN = eval(\"parent.frames[1].document.forms[0].rtn_stup_reimb_YN_\"+i);\n\t\t\tvar rtn_stup_reimb_type = eval(\"parent.frames[1].document.forms[0].rtn_stup_reimb_type_\"+i);\n\t\t\tvar rtn_stup_reimb_amt = eval(\"parent.frames[1].document.forms[0].rtn_stup_reimb_amt_\"+i);\n\n\t\t\tvar curr_reimb_YN = eval(\"parent.frames[1].document.forms[0].curr_reimb_YN_\"+i);\n\t\t\tvar curr_reimb_type = eval(\"parent.frames[1].document.forms[0].curr_reimb_type_\"+i);\n\t\t\tvar curr_rev_amt = eval(\"parent.frames[1].document.forms[0].curr_rev_amt_\"+i);\n\n\t\t\tvar rtn_curr_reimb_YN = eval(\"parent.frames[1].document.forms[0].rtn_curr_reimb_YN_\"+i);\n\t\t\tvar rtn_curr_reimb_type = eval(\"parent.frames[1].document.forms[0].rtn_curr_reimb_type_\"+i);\n\t\t\tvar rtn_curr_rev_amt = eval(\"parent.frames[1].document.forms[0].rtn_curr_rev_amt_\"+i);\n\n\t\t\tif(stup_reimb_YN.checked)\n\t\t\t\trtn_stup_reimb_YN.value = \"Y\";\n\t\t\telse\n\t\t\t\trtn_stup_reimb_YN.value = \"N\";\n\n\t\t\trtn_stup_reimb_type.value = stup_reimb_type.value;\n\t\t\trtn_stup_reimb_amt.value = stup_reimb_amt.innerText;\n\n\t\t\tif(curr_reimb_YN.checked)\n\t\t\t\trtn_curr_reimb_YN.value = \"Y\";\n\t\t\telse\n\t\t\t\trtn_curr_reimb_YN.value = \"N\";\n\n\t\t\trtn_curr_reimb_type.value = curr_reimb_type.value;\n\t\t\trtn_curr_rev_amt.value = curr_rev_amt.value;\n\t\t}\n\n\t\tparent.frames[1].document.forms[0].target=\'submit_frame\';\n\t\tparent.frames[1].document.forms[0].action=\"../../servlet/eBL.BLBillReimburseAmtServlet\";\n\t\tparent.frames[1].document.forms[0].submit();\n\t}\n\n </script>\n</head>\n\n\t<body onLoad=\'\' onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\" onSelect = \"codeArrestThruSelect();\">\n\t<form name=\'CusrDet\' id=\'CusrDet\' method=\'post\' action=\'\'>\t\t\n\t<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' align=\'center\' width=\'100%\'>\n\t\t<tr>\n\t\t\t<td width=\"100%\" class=\'button\' colspan=\'2\'  align=\'right\'>\n<!--\t\t\t\t<input type=\'button\' name=\'apply_button\' id=\'apply_button\' onClick=\'funSubmit();\' value=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\" align=\'right\'>-->\n\t\t\t\t<input type=\'button\' name=\'close_button\' id=\'close_button\' onClick=\'cancel();\' value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\">\n\t\t\t</td>\t\n\t\t</tr>\n\t</table>\n\t</form>\n\t</body>\n\n</html>\n\n\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

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

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.apply.label","common_labels")));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")));
            _bw.write(_wl_block9Bytes, _wl_block9);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
