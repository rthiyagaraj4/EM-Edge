package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.Enumeration;
import java.io.*;

public final class __websocketpoc extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/WebSocketPOC.jsp", 1709122417474L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<HTML>\n\t\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =" \n<HEAD>\n<meta http-equiv=\"X-UA-Compatible\" content=\"IE=10\">\n<TITLE> New Document </TITLE>\n<meta charset=\"utf-8\">\n\t<link rel=\"StyleSheet\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\" type=\"text/css\"/>\n\t<script language=\"javascript\" src=\"../../eXH/js/ExternalApplication.js\"></script>\n\t<Script src=\"../../eCommon/js/jquery-3.6.3.js\" language=\"JavaScript\"></Script>\t\n\n<script Language=\"JavaScript\">\n\n\t\n\tvar websocket;\n\t\n\t$(document).ready(function() {   \n\t\t\n\t\t$(\"#connect\").click(function() {\n\n\t\t\tvar myNav = navigator.userAgent.toLowerCase();\n\n\t\t\t$(\"#status\").val(\"\");\n\t\t\t$(\"#messagesList\").val(\"\");\n\t\t\t$(\"#insuranceid\").val(\"\");\n\n\t\t\tvar id = invokeInsuranceCardReader(\"insuranceid\",\"cardStatus\"); //invokeInsuranceCardReader(\"insuranceid\",\"cardStatus\");\t\n\n\t\t\treturn false;     \n\t\t\t\n\t\t});\n\n\t});\n\n\t/*\n\t$(document).ready(function() {   \n\n\t\t$(\"#connect\").click(function() {\t\t\t\n\n\t\t\t$(\"#status\").val(\"\");\n\t\t\t$(\"#messagesList\").val(\"\");\n\t\t\t$(\"#insuranceid\").val(\"\");\n\n\t\t\tvar socketUri = $(\"#websocketuri\").val();\t\n\n\t\t\t*/\n\n\t\t\t/* ************************\n\t\t\tvar arguments = new Array();\n\n\t\t\tvar dialogWidth\t= \"300px\";\n\t\t\tvar dialogHeight = \"300px\";\n\t\t\tvar dialogTop    = \"100\";\n\t\t\tvar dialogLeft   = \"100\";\n\n\t\t\tvar features = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+ \"; dialogLeft:\" +dialogLeft+ \"; dialogTop:\" +dialogTop+ \";status:yes;scroll:no\";\t\n\n\t\t\tvar action_url\t=\"../../eXH/jsp/WebSockets.html\";\n\n\t\t\tvar retVal = window.open(action_url,\"\",  \"toolbar=no,scrollbars=yes,resizable=yes,top=100,left=500,width=400,height=400\");\n\n\t\t\t*/\n\t\t\t\n\t\t\t/*\n\t\t\twebsocket = new WebSocket(socketUri,\"echo-protocol\");\n\n\t\t\t$(\"#status\").val(\"Connected\");\n\t\t\t\n\t\t\treturn false;     \n\t\t\t\n\t\t});\n\n\t\t$(\"#send\").click(function() {\t\n\t\t\t\n\t\t\tvar message = $(\"#request\").val();\t\n\n\t\t\twebsocket.send(message);\n\n\t\t\t$(\"#status\").val(\"Message Sent\");\n\n\t\t\t$(\"#messagesList\").val(message);\n\n\t\t\tvar data = JSON.parse(message);\n\t\t\tvar x=data.message;\n\n\t\t\t$(\"#insuranceid\").val(x);\n\n\t\t\treturn false;     \n\t\t\t\n\t\t});\n\t\t\n\t});\n\n\t*/\n\n\t\n\n\tfunction invokeInsuranceCardReader(fieldName, statusFieldName)\n\t{\n\t\tvar segment_id = \"ICR\", element_id = \"WEBSOCKET_URL\", standard_code = \"INSCARDSTD\";\n\t\n\t\tvar websocketurl = getGetSegmentData(standard_code, segment_id, element_id);\n\t\t//var websocketurl = \"wss://echo.websocket.org/\";\n\n\n\t\t$(\"#websocketuri\").val(websocketurl);\n\t\t\n\t\tvar insuranceField = \"#\"+fieldName;\n\t\t$(insuranceField).val(\"\");\n\n\t\tvar statusfield = \"#\"+statusFieldName;\n\n\t\t$(statusfield).text(\"Inside Card Reader\");\n\n\t\tinsuranceid = \"\";\n\t\t//var socketUri = $(\"#websocketuri\").val();\n\t\t//websocket = new WebSocket(\'ws://localhost:8025/ws/chat\');\n\n\t\twebsocket = new WebSocket(websocketurl);\t\t\n\t\twebsocket.onopen = function(evt) { onOpen(evt, statusFieldName) };\n\t\twebsocket.onclose = function(evt) { onClose(evt, statusFieldName) };\n\t\twebsocket.onmessage = function(evt) { onMessage(evt, fieldName, statusFieldName) };\n\t\twebsocket.onerror = function(evt) { onError(evt, fieldName, statusFieldName) };\n\n\t\treturn insuranceid;\n\t}\n\n\tfunction onOpen(evt, statusFieldName)\n\t{\n\t\t$(\"#status\").val(\"Connected\");\n\t\tvar message = $(\"#request\").val();\t\n\t\tdoSend(message, statusFieldName);\n\t}\n\n\tfunction onClose(evt, statusFieldName)\n\t{\n\t\t$(\"#status\").val(\"Disconnected\");\n\t\tvar statusfield = \"#\"+statusFieldName;\n\t\t$(statusfield).text(\"Message Received and Closed\");\n\t}\n\n\tfunction onMessage(evt, fieldName, statusFieldName)\n\t{\n\t\t$(\"#status\").val(\"Message Received\");\n\n\t\t$(\"#messagesList\").val(JSON.stringify(evt.data));\n\n\t\tvar data = JSON.parse(evt.data);\n\t\tvar insuranceData=data.message;\n\n\t\tvar insuranceField = \"#\"+fieldName;\n\t\t$(insuranceField).val(insuranceData);\n\n\t\tvar statusfield = \"#\"+statusFieldName;\n\t\t$(statusfield).text(\"Message Received\");\n\n\t\tinsuranceid = insuranceData;\n\t\twebsocket.close();\n\t}\n\n\tfunction onError(evt, fieldName, statusFieldName)\n\t{\t\t\n\t\t$(\"#status\").val( evt.data);\n\t\tvar insuranceField = \"#\"+fieldName;\n\t\t$(insuranceField).val(\"\");\n\t\tvar statusfield = \"#\"+statusFieldName;\n\t\t$(statusfield).text(evt.data);\n\t}\n\n\tfunction doSend(message, statusFieldName)\n\t{\n\t\twebsocket.send(message);\n\t\t$(\"#status\").val(\"Message Sent\");\n\t\tvar statusfield = \"#\"+statusFieldName;\n\t\t$(statusfield).text(\"Message Sent\");\n\t}\n\n\n\tfunction getDocumentMode()\n\t{\t\n\t\t\n\t\tvar documentModeStr = document.documentMode;\n\n\t\talert(documentModeStr);\t\t\n\t\t\n\t}\n\n\n\n\n\n\t\n\t\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</HEAD>\n\n<body onload = \"loadPage()\">\n\t<form>\n\t<table border=\"1\" cellpadding=\"3\" cellspacing=\"0\" align = \"center\" width=\"800\">\t\t\n\t\t<tr>\t\n\t\t\t<td width=\"25%\" class=\"label\">Card Reader URI</td>\n\t\t\t<td width=\"50%\" align=left>\t\t\t\t\n\t\t\t\t<input class=\"textbox\" type=\"textbox\" id=\"websocketuri\" name=\"websocketuri\" id=\"websocketuri\" value=\"\" size=\"50\"> \n\t\t\t</td>\n\t\t\t<td width=\"25%\" align=left>\t\t\t\t\n\t\t\t\t<input class=\"button\" type=\"button\"  id=\"connect\" name=\"connect\" id=\"connect\" value=\"Get Insurance IDs\"> \n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"25%\" class=\"label\">Request</td>\n\t\t\t<td width=\"50%\" align=left>\t\t\t\t\n\t\t\t\t<input class=\"textbox\" type=\"textbox\" id=\"request\" name=\"request\" id=\"request\" value=\'{\"message\":\"10028989, 10028990, 10028991\",\t\"sender\":\"client\",\t\"timeStamp\": \"Wed Aug 12 16:55:15 EET 2020\"}\' size=\"50\"> \n\t\t\t</td>\n\t\t\t<td width=\"25%\" align=left>\t\t\t\t\n\t\t\t\t<input class=\"button\" type=\"button\"  id=\"send\" name=\"send\" id=\"send\" value=\"Send\"> \n\t\t\t</td>\n\t\t\t\n\t\t</tr>\t\n\t\t<tr>\t\t\t\t\n\t\t\t<td width=\"25%\" align=left>\t\n\t\t\t\tStatus \n\t\t\t\t<!--<input class=\"textbox\" type=\"textbox\" id=\"status\" name=\"status\" id=\"status\" value=\"\"> -->\n\t\t\t\t<div id=\"cardStatus\"><div>\n\n\t\t\t</td>\t\t\t\n\t\t\t<td width=\"50%\" align=left>\t\n\t\t\t\tMessage Received\n\t\t\t\t<textarea id=\"messagesList\" name=\"messagesList\" rows=\"4\" cols=\"60\" disabled></textarea>\n\t\t\t</td>\n\t\t\t<td width=\"25%\" align=left>\t\n\t\t\t\tInsurance ID\'s\n\t\t\t\t<input class=\"textbox\" type=\"textbox\" id=\"insuranceid\" name=\"insuranceid\" id=\"insuranceid\" value=\"\"> \n\t\t\t</td>\t\t\t\n\t\t</tr>\t\n\t\t<tr>\t\t\t\t\n\t\t\t<td width=\"25%\" align=left>\t\t\t\t\n\t\t\t\t<input class=\"button\" type=\"button\"  id=\"DocumentMode\" name=\"DocumentMode\" id=\"DocumentMode\" value=\"DocumentMode\" onClick=\"getDocumentMode();\"> \n\t\t\t</td>\n\t\t</tr>\t\n\t</table>\t\n\n\t</form>\n</body>\n</HTML>\n\n";
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");   

	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	
 
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
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
