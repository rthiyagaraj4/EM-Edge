package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __swabandinstrumentstemplateobjectcollect extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/SwabAndInstrumentsTemplateObjectCollect.jsp", 1709120392000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<html>\n<head>\n<script language=\"javascript\">\n\tvar rows = new Array();\n</script>\n<script type=\'text/javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\"javascript\">\nfunction createXMLForSWAB_INSTR_TMPL_Dtl(){\n  var rows=window.parent.parent.frames[1].frames[1].rows;\n  ////alert(window.parent.parent.frames[1].frames[1].name);//hidden frame\n  var masterFrame=window.parent.parent.frames[1].frames[0];\n // //alert(window.parent.parent.frames[1].frames[0].name);//masterframe\n  var formObj=masterFrame.document.forms[0];\n  \n  var len = rows.length;\n // //alert(\"Length of the rows array===\"+len);\n  var table_name = \"OT_SWAB_INSTR_TMPL_DTL\";\n  var xmlString =\"\";\n  for(var i=0;i<len;i++){\n\t  if(rows[i]!=null && rows[i].mode!=\'L\' ){\n\t\t // //alert(\"mode in SWAB_INSTR_TMPL_DTL func==\"+rows[i].mode);\n\t\t if(rows[i].mode==\"\")\n\t\t\t break;\n\t\t else if(rows[i].mode==\"I\"){\n\t\t\t//alert(\"before xml of DTL\");\n\t\txmlString+=\"<SWAB_INSTR_TMPL_DTL\"+i+\" \";\n\t\txmlString+=\"template_id=\\\"\"+formObj.template.value+\"\\\"\"+\" \";\n\t\txmlString+=\"srl_no=\\\"\"+rows[i].srl_no +\"\\\"\"+\" \";\n\t\txmlString+=\"item_code=\\\"\"+rows[i].item_code+\"\\\"\"+\" \";\n\t\txmlString+=\"initial_count=\\\"\"+(rows[i].initial_count).replace(\"&nbsp;\",\"\")+\"\\\"\"+\" \";\n\t\txmlString+=\"mode=\\\"\"+rows[i].mode+\"\\\"\"+\" \";\n\t\txmlString+=\"table_name=\\\"\"+table_name+\"\\\"\"+\" />\";\n\t\t }else if(rows[i].mode==\"U\"){\n\t\t\txmlString+=\"<SWAB_INSTR_TMPL_DTL\"+i+\" \";\n\t\txmlString+=\"template_id=\\\"\"+formObj.template_id.value+\"\\\"\"+\" \";\n\t\txmlString+=\"srl_no=\\\"\"+rows[i].srl_no +\"\\\"\"+\" \";\n\t\txmlString+=\"item_code=\\\"\"+rows[i].item_code+\"\\\"\"+\" \";\n\t\txmlString+=\"initial_count=\\\"\"+(rows[i].initial_count).replace(\"&nbsp;\",\"\")+\"\\\"\"+\" \";\n\t\txmlString+=\"mode=\\\"\"+rows[i].mode+\"\\\"\"+\" \";\n\t\txmlString+=\"table_name=\\\"\"+table_name+\"\\\"\"+\" />\";\n\t\t//alert(\"after xml of DTL\");\n\t\t}\n\t\telse\n\t\t  {\n\t\t\t//alert(\"inside delete xml of dtl\");\n\t\t\txmlString+=\"<SWAB_INSTR_TMPL_DTL\"+i+\" \";\n\t\txmlString+=\"template_id=\\\"\"+formObj.template_id.value+\"\\\"\"+\" \";\n\t\txmlString+=\"srl_no=\\\"\"+rows[i].srl_no +\"\\\"\"+\" \";\n\t\txmlString+=\"item_code=\\\"\"+rows[i].item_code+\"\\\"\"+\" \";\n\t\txmlString+=\"initial_count=\\\"\"+(rows[i].initial_count).replace(\"&nbsp;\",\"\")+\"\\\"\"+\" \";\n\t\txmlString+=\"mode=\\\"\"+rows[i].mode+\"\\\"\"+\" \";\n\t\txmlString+=\"table_name=\\\"\"+table_name+\"\\\"\"+\" />\";\n\t\t//alert(\"xmlString in delete of dtl===\"+xmlString);\n\t\t//alert(\"after delete xml of DTL\");\n\t\t}\n\t }\n  }\n  //alert(xmlString);\n return xmlString;\n}\n\nfunction createXMLForSWAB_INSTR_TMPL_Hdr(){\n\t//alert(\"inside hdr func\");\n\t\n  var rows=window.parent.parent.frames[1].frames[1].rows;\n  \n  var formObj =window.parent.parent.frames[1].frames[0];\n  \n  var frmObj=formObj.document.forms[0];\n  var mode = frmObj.mode.value;\n  \n  var len = rows.length;\n  \n  var table_name = \"OT_SWAB_INSTR_TMPL_HDR\";\n  var xmlString =\"\";\n   \n\t  if(frmObj.template!=null){\n\t\t  //alert(\"before xml of HDR\");\n\t\txmlString+=\"<SWAB_INSTR_TMPL_HDR \"+\" \";\n\t\txmlString+=\"template_id=\\\"\"+frmObj.template.value+\"\\\"\"+\" \";\n\t\txmlString+=\"description=\\\"\"+frmObj.description.value +\"\\\"\"+\" \";\n\t\txmlString+=\"status=\\\"\"+frmObj.status.value +\"\\\"\"+\" \";\n\t\txmlString+=\"mode=\\\"\"+mode.toUpperCase()+\"\\\"\"+\" \";\n\t\txmlString+=\"table_name=\\\"\"+table_name+\"\\\"\"+\" />\";\n\t\t//alert(\"after xml of HDR\");\n\t }\n \n return xmlString;\n}\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<form name=\"ObjectCollectForm\" id=\"ObjectCollectForm\">\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
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
