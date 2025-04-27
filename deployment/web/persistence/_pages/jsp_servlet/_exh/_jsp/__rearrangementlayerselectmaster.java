package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __rearrangementlayerselectmaster extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/RearrangementLayerSelectMaster.jsp", 1743587099437L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\";\n\t\t\t\tdocument.getElementById(\"toolLink\").innerHTML = tabdata;\n\t\t\t\tdocument.getElementById(\"toolLink\").style.top  = obj.offsetTop;\n\t\t\t\tdocument.getElementById(\"toolLink\").style.left  = obj.offsetLeft ;\n\t\t\t\tdocument.getElementById(\"toolLink\").style.visibility=\'visible\';\n\t\t\t\tflag=1;\n\t\t}\n\n\t\tfunction hideLinks()\n\t\t {\n\t\t \tdocument.getElementById(\"toolLink\").style.visibility=\'hidden\' ;\n\t\t\n\t\t }\nasync function show_Reference_details_results(input)\n{\nvar SystemDef_id=document.forms[0].application_id.value;\nvar event_type_id=document.forms[0].event_type_id.value;\n// var SystemDef_id=document.forms[0].SystemDefine_id.value;\n\tvar dialogHeight= \"30\" ;\n\tvar dialogWidth\t= \"45\" ;\n\tvar dialogTop = \"190\" ;\n\tvar center = \"1\" ;\n\tvar status=\"no\";\n\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\tvar arguments\t= \"\" ;\nawait window.showModalDialog(\"../../eXH/jsp/RearrangeMentDialog.jsp?SystemDef_id=\"+SystemDef_id+\"&event_type_id=\"+event_type_id+\"&input=\"+input,arguments,features);\n\n}\nfunction Remove1()\n{\n\n\n\nfields = new Array (document.forms[0].application_name,document.forms[0].event_type);\n\n names = new Array (getLabel(\"eXH.ApplicationID.Label\",\"XH\"),getLabel(\"Common.EventType.label\",\"common\"));\n\t\tif(!checkFields( fields, names, parent.parent.messageFrame))\n\t{\n\t}\nelse\n\t{\nvar uservalue=document.forms[0].UsrDefStr.value;\n\ndocument.forms[0].UserDefind_id.value=uservalue; \n\ndocument.forms[0].submit(); \n\t}\n} \n\tfunction CheckForSpecCharsforID(event){\n\t\tvar strCheck = \'0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_|^-$#%\';\n\t\n\t\t var whichCode = (window.Event) ? event.which : event.keyCode;\n\t\t key = String.fromCharCode(whichCode);  // Get key value from key code\n\t\t if (strCheck.indexOf(key) == -1) return false;  // Not a valid key\n\t\tif( (event.keyCode >= 97) && (event.keyCode <= 122) )\n\t\treturn (event.keyCode -= 32);\n\t\treturn true ;\n\t}\n\n</script>\n</HEAD>\n<BODY  leftmargin=0 topmargin=0 onMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\'>\n<!--<FORM name=\"navigator1\" id=\"navigator1\" onload=\"document.navigator.application_name.focus()\">-->\n<form name=\"navigator1\" id=\"navigator1\"  method=\'post\' target=\'messageFrame\' action=\'../../servlet/eXH.ReArrangeMentServlet\' onload=\"document.navigator.application_name.focus()\">\n<table border=0>\n<tr>\n<td>\n<table cellspacing=0 cellpadding=3 width=\'100%\' align=center border=0>\n<!---<tr>\n\t<td width=\'40%\'></td>\n\t<td width=\'60%\'></td>\n\t<td width=\'45%\'></td>\n\t<td width=\'60%\'></td>\n</tr>--------->\n<tr>\n<td class=label ><fmt:message key=\"eXH.ApplicationID.Label\" bundle=\"";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\"/></td>\n<td align=left><input type=\"text\" id=\"application_name\" value=\'\'  name =\"application_name\"   size=35> \n<input style=\"background:navy; color:white;font-size: 8pt;font-Weight:600 ;border-style: ridge;\" type=\"button\"  name=TableSearch value=\'?\' onClick=\'searchApplication();\' ><input type=\"hidden\" name=\"application_id\" id=\"application_id\" value=\"null\"></td>\n<td> </td> <td> </td>\n</tr>\n<tr>\n<td class=label ><fmt:message key=\"Common.EventType.label\" bundle=\"";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\"/></td>\n<td align=left><input type=text id=\"event_type\"  name =\"event_type\" value=\'\' onBlur=\'qrySystUsrDefStr();\' value=\'\' size=35> <input style=\"background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;\" type=\"button\"  name=TableSearch value=\'?\' onClick=\"searchEventType();\" ><input type=\"hidden\" name=\"event_type_id\" id=\"event_type_id\" value=\'\'></td>\n<td> </td> <td> </td>\n</tr>\n<tr>\n<td class=label onClick=\"show_Reference_details_results(\'System Defined Structure\')\" ><fmt:message key=\"eXH.SysDefStr.Label\" bundle=\"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\"/></td>\n<td align=left>\n<input type=\"text\"  size=\"43\" name=\"SysDefStr\" id=\"SysDefStr\"  onKeyPress=\'return CheckForSpecCharsforID(event);\' onBlur=\'arrangeTree();\'  align=\'center\' disabled><input type=\"hidden\" name=\"SystemDefind_id\" id=\"SystemDefind_id\" value=\'\' ></td>\n<td class=label onClick=\"show_Reference_details_results(\'User Defined Structure\')\" ><fmt:message key=\"eXH.UserDefinedFormat.Label\" bundle=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\"/></td>\n<td align=right><input type=\"text\"  size=\"43\" name=\"UsrDefStr\" id=\"UsrDefStr\"  onKeyPress=\'return CheckForSpecCharsforID(event);\'  onBlur=\'arrangeTree1();\'   align=\'center\' disabled ><input type=\"hidden\" name=\"UserDefind_id\" id=\"UserDefind_id\" value=\"null\" ></td>\n</td> \n</tr>\n<tr>\n\t<td width=\'40%\'></td>\n\t<td width=\'60%\'></td>\n\t<td width=\'45%\'></td>\n\t<td width=\'60%\'></td>\n</tr>\n</table>\n</FORM>\n<div id=\'toolLink\' style=\'position:absolute; visibility:hidden;overflow:overflow\'>\n</div>\n</BODY>\n\n</HTML> \n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

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
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block1Bytes, _wl_block1);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block4Bytes, _wl_block4);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
