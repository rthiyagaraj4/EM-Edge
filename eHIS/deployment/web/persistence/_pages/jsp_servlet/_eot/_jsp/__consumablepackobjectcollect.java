package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __consumablepackobjectcollect extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/ConsumablePackObjectCollect.jsp", 1709120202000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<html>\n<head>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"javascript\">\n\tvar rows = new Array();\n\t \n</script>\n<script language=\"javascript\">\nfunction createXMLForOT_PACKAGE_Dtl(){\n  var rows=window.parent.parent.frames[1].frames[1].rows;\n  var masterFrame=window.parent.parent.frames[1].frames[0];\n  var formObj=masterFrame.document.forms[0];\n  var len = rows.length;\n  var table_name = \"OT_PACKAGE_DTL\";\n  var xmlString =\"\";\n  for(var i=0;i<len;i++){\n\t  if(rows[i]!=null && rows[i].mode!=\'L\' ){\n\t\t if(rows[i].mode==\"\")\n\t\t\t break;\n\t\t else if(rows[i].mode==\"I\"){\n\t\t\txmlString+=\"<PACKAGE_DTL\"+i+\" \";\n\t\t\txmlString+=\"package_code=\\\"\"+formObj.package_code.value+\"\\\"\"+\" \";\n\t\t\txmlString+=\"item_code=\\\"\"+rows[i].item_code+\"\\\"\"+\" \";\n\t\t\txmlString+=\"reqd_qty=\\\"\"+rows[i].reqd_qty+\"\\\"\"+\" \";\n\t\t\txmlString+=\"mode=\\\"\"+rows[i].mode+\"\\\"\"+\" \";\n\t\t\txmlString+=\"table_name=\\\"\"+table_name+\"\\\"\"+\" />\";\n\t\t }else if(rows[i].mode==\"U\"){\n\t\t\txmlString+=\"<PACKAGE_DTL\"+i+\" \";\n\t\t\txmlString+=\"package_code=\\\"\"+formObj.package_code.value+\"\\\"\"+\" \";\n\t\t\txmlString+=\"item_code=\\\"\"+rows[i].item_code+\"\\\"\"+\" \";\n\t\t\txmlString+=\"reqd_qty=\\\"\"+rows[i].reqd_qty+\"\\\"\"+\" \";\n\t\t\txmlString+=\"mode=\\\"\"+rows[i].mode+\"\\\"\"+\" \";\n\t\t\txmlString+=\"table_name=\\\"\"+table_name+\"\\\"\"+\" />\";\n\t\t}\n\t\telse\n\t\t  {\n\t\t\txmlString+=\"<PACKAGE_DTL\"+i+\" \";\n\t\t\txmlString+=\"package_code=\\\"\"+formObj.package_code.value+\"\\\"\"+\" \";\n\t\t\txmlString+=\"item_code=\\\"\"+rows[i].item_code+\"\\\"\"+\" \";\n\t\t\txmlString+=\"reqd_qty=\\\"\"+rows[i].reqd_qty+\"\\\"\"+\" \";\n\t\t\txmlString+=\"mode=\\\"\"+rows[i].mode+\"\\\"\"+\" \";\n\t\t\txmlString+=\"table_name=\\\"\"+table_name+\"\\\"\"+\" />\";\n\t\t}\n\t }\n  }\n return xmlString;\n}\n\nfunction createXMLForOT_PACKAGE_Hdr(){\n\tvar rows=window.parent.parent.frames[1].frames[1].rows;\n\tvar formObj =window.parent.parent.frames[1].frames[0];\n    var frmObj=formObj.document.forms[0];\n\tvar mode = frmObj.mode.value;\n\tvar len = rows.length;\n    var table_name = \"OT_PACKAGE_HDR\";\n\tvar xmlString =\"\";\n\t  if(frmObj.package_code!=null){\n\t\txmlString+=\"<PACKAGE_HDR \"+\" \";\n\t\txmlString+=\"package_code=\\\"\"+frmObj.package_code.value+\"\\\"\"+\" \";\n\t\txmlString+=\"long_description=\\\"\"+frmObj.long_description.value +\"\\\"\"+\" \";\n\t\txmlString+=\"short_description=\\\"\"+frmObj.short_description.value +\"\\\"\"+\" \";\n\t\txmlString+=\"status=\\\"\"+frmObj.status.value +\"\\\"\"+\" \";\n\t\t//CRF-268 Consumable pack - Rajesh V\n\t\txmlString+=\"ss_code=\\\"\"+frmObj.ss_group_code.value +\"\\\"\"+\" \";\n\t\t//CRF-268 Consumable pack - Rajesh V\n\t\txmlString+=\"mode=\\\"\"+mode.toUpperCase()+\"\\\"\"+\" \";\n\t\txmlString+=\"table_name=\\\"\"+table_name+\"\\\"\"+\" />\";\n\t }\n \n return xmlString;\n}\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<form name=\"ObjectCollectForm\" id=\"ObjectCollectForm\">\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\">\n</form>\n</body>\n</html>\n\n";
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
 String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(locale));
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
