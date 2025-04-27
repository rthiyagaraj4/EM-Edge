package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __listitemsobjectcollect extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/ListItemsObjectCollect.jsp", 1709120242000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n<html>\n<head>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\' ></script>\n<script language=\"javascript\">\n\tvar rows = new Array();\n\t \n</script>\n<script language=\"javascript\">\nfunction createXMLForListItemsDtl(){\n  var rows=window.parent.parent.frames[1].frames[1].rows;\n  //alert(window.parent.parent.frames[1].frames[1].name);//hidden frame\n  var masterFrame=window.parent.parent.frames[1].frames[0];\n // alert(window.parent.parent.frames[1].frames[0].name);//masterframe\n  var formObj=masterFrame.document.forms[0];\n  var DEF_FLAG = \"OFF\";\n  \n  var len = rows.length;\n // alert(\"Length of the rows array===\"+len);\n  var table_name = \"OT_CHECKLIST_LISTVALS_DTL\";\n  var xmlString =\"\";\n  for(var i=0;i<len;i++){\n\t  if(rows[i]!=null && rows[i].mode!=\'L\' ){\n\t\t  //alert(\"mode in OT_CHECKLIST_DTL func==\"+rows[i].mode);\n\t\t if(rows[i].mode==\"\")\n\t\t\t break;\n\t\t else if(rows[i].mode==\"I\"){\n\t\txmlString+=\"<CHECKLIST_DTL\"+i+\" \";\n\t\txmlString+=\"list_id=\\\"\"+formObj.list_id.value+\"\\\"\"+\" \";\n\t\txmlString+=\"item_description=\\\"\"+rows[i].item_description +\"\\\"\"+\" \";\n\t\txmlString+=\"item_value=\\\"\"+rows[i].item_value+\"\\\"\"+\" \";\n\t\txmlString+=\"default_value_yn=\\\"\"+rows[i].default_value_yn+\"\\\"\"+\" \";\n\t\txmlString+=\"mode=\\\"\"+rows[i].mode+\"\\\"\"+\" \";\n\t\txmlString+=\"table_name=\\\"\"+table_name+\"\\\"\"+\" />\";\n\t\t }else if(rows[i].mode==\"U\"){\n\t\t\txmlString+=\"<CHECKLIST_DTL\"+i+\" \";\n\t\txmlString+=\"list_id=\\\"\"+formObj.list_id.value+\"\\\"\"+\" \";\n\t\txmlString+=\"item_description=\\\"\"+rows[i].item_description +\"\\\"\"+\" \";\n\t\txmlString+=\"item_value=\\\"\"+rows[i].item_value+\"\\\"\"+\" \";\n\t\txmlString+=\"default_value_yn=\\\"\"+rows[i].default_value_yn+\"\\\"\"+\" \";\n\t\txmlString+=\"mode=\\\"\"+rows[i].mode+\"\\\"\"+\" \";\n\t\txmlString+=\"table_name=\\\"\"+table_name+\"\\\"\"+\" />\";\n\t\t//alert(\"xmlString in OT_CHECKLIST_DTL func==\"+xmlString);\n\t\t}\n\t\telse {\n\t\t\t//alert(\"inside delete xml of dtl\");\n\t\t\txmlString+=\"<CHECKLIST_DTL\"+i+\" \";\n\t\txmlString+=\"list_id=\\\"\"+formObj.list_id.value+\"\\\"\"+\" \";\n\t\txmlString+=\"item_description=\\\"\"+rows[i].item_description +\"\\\"\"+\" \";\n\t\txmlString+=\"item_value=\\\"\"+rows[i].item_value+\"\\\"\"+\" \";\n\t\txmlString+=\"default_value_yn=\\\"\"+rows[i].default_value_yn+\"\\\"\"+\" \";\n\t\txmlString+=\"mode=\\\"\"+rows[i].mode+\"\\\"\"+\" \";\n\t\txmlString+=\"table_name=\\\"\"+table_name+\"\\\"\"+\" />\";\n\t\t//alert(\"xmlString in OT_CHECKLIST_DTL delete func==\"+xmlString);\n\t\t}\n\t }\n  }\n return xmlString;\n}\n\nfunction createXMLForListItemsHdr(){\n\t\n  var rows=window.parent.parent.frames[1].frames[1].rows;\n  \n  var formObj =window.parent.parent.frames[1].frames[0];\n  \n  var frmObj=formObj.document.forms[0];\n  var mode = frmObj.mode.value;\n  \n  var len = rows.length;\n  \n  var table_name = \"OT_CHECKLIST_LISTVALS_HDR\";\n  var xmlString =\"\";\n   \n\t  if(frmObj.list_id!=null){\n\t\txmlString+=\"<CHECKLIST_LISTVALS_HDR\"+\" \";\n\t\txmlString+=\"list_id=\\\"\"+frmObj.list_id.value+\"\\\"\"+\" \";\n\t\txmlString+=\"description=\\\"\"+frmObj.description.value +\"\\\"\"+\" \";\n\t\txmlString+=\"mode=\\\"\"+mode.toUpperCase()+\"\\\"\"+\" \";\n\t\txmlString+=\"table_name=\\\"\"+table_name+\"\\\"\"+\" />\";\n\t }\n \n return xmlString;\n}\n\n\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<form name=\"ObjectCollectForm\" id=\"ObjectCollectForm\">\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
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
 request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block1Bytes, _wl_block1);
 String locale = (String)session.getAttribute("LOCALE"); 
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
