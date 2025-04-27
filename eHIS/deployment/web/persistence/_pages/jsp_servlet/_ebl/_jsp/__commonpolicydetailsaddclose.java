package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __commonpolicydetailsaddclose extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/CommonPolicyDetailsAddClose.jsp", 1709114631680L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n<html>\n<head>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<title>Insert title here</title>\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\' type=\'text/css\'/>\n<script language=\"javascript\" src=\"../../eBL/js/CommonPolicyAddTable.js\"></script>\n<script language=\"javascript\" src=\"../../eBL/js/CommonPolicyDefinition.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/CommonCalendar.js\' ></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\nfunction addRowNew(){\n\tvar frm = parent.PolicyDetailsPage.document.forms[0];\n\tvar pageInfo = frm.pageInfo.value;\n\tif(pageInfo == \'PreApprovalPopup\'){\n\t\taddRow(\'PreApprovalPopup\')\n\t}\n\t//alert(pageInfo);\n}\nfunction save(){\n\tvar table_id = parent.PolicyDetailsPage.document.getElementById(\'PolicyPreApprovalPopup\');\n\tvar totRows = table_id.rows.length;\n\ttotRows = totRows-1;\n\tfor(prevIndex=1;prevIndex<=totRows;prevIndex++){\n\n\t\tvar incExcCriteria = parent.PolicyDetailsPage.document.getElementById(\"pop_incExCriteria_\"+prevIndex).value;\n\t\tvar effFromDate = parent.PolicyDetailsPage.document.getElementById(\"pop_effFrom_\"+prevIndex).value;\n\t\tvar prevBillCode  = parent.PolicyDetailsPage.document.getElementById(\"pop_bg_code_\"+prevIndex).value;\n\t\tvar delFlag = parent.PolicyDetailsPage.document.getElementById(\"pop_delFlag\"+prevIndex);\n\t\t\n\t\tif(!delFlag.checked){\n\t\t\tif(prevBillCode.length<1) {\n\t\t\t\t\n\t\t\t}\n\t\t\telse if(incExcCriteria.length<1 || prevBillCode.length<1 || effFromDate.length<1) {\n\t\t\t\talert(\"Please enter all mandatory fields for Row Number \"+prevIndex);\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\t\t\n\t}\n\t\n\tvar frmObj = parent.PolicyDetailsPage.document.forms[0];\n\tvar priorityKey = frmObj.priorityKey.value;\n\txmlString=formXMLStringMain(frmObj);\n\t//alert(xmlString);\n\tupdation=formValidation(xmlString,\"popup\",priorityKey);\n\twindow.close();\t\n}\n</script>\n</head>\n<body>\n<form>\n<table width=\'95%\'>\n<tr>\n<td width=\'75%\'>\n\t\n</td>\n<td align=\'right\' width=\'9%\'>\n<input type=\'button\' class=\"BUTTON\" value=\'Lookup\' onClick=\'fnShowPolicyDetailReport();\'>\n</td>\n<td align=\'right\' width=\'5%\'>\n<input type=\'button\' class=\'BUTTON\' value=\'Add\' onclick=\'addRowNew()\'>\n<!-- <input type=\'button\' class=\'BUTTON\' value=\'Remove\' onclick=\'removeRowNewAddClose()\'> --></td>\n<td align=\'left\' width=\'11%\'> <input type=\'button\' class=\'BUTTON\' value=\'Close\' onclick=\'save()\'></td>\n</tr>\n</table>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

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

	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
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
