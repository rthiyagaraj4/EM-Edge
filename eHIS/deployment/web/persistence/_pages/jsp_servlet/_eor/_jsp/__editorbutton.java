package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __editorbutton extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/EditorButton.jsp", 1709119684000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!--\n--------------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        Description\n--------------------------------------------------------------------------------------------------------------\n?             100            ?           created\n14/9/2011\t  IN27550\t\tDinesh T\t Changed the lines to solve the preview window issue which goes\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t behind the editor screen in the refusal in the Record Refusal\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t function\n22/03/2012    IN29559       DineshT      Record consent criteria in TaskList function\n---------------------------------------------------------------------------------------------------------------\n-->\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" id=\'test\'>\n<tr>\n\t<td class=\"LABEL\" align=\"left\" width=\"10%\">\n\t\t<font size=\'1\'>\n\t\t\t<a href=\"#\" onClick=\"showTable()\">\n\t\t\t\t<img src=\"../../eOR/images/table.gif\" title=\'Insert Table\'></img>\n\t\t\t</a>\n \t\t\t<a href=\'#\' onClick=\'addTable()\' style=\"visibility:hidden\" id=\"add_table\">\n\t\t\t\t<img src=\'../../eOR/images/AddTable.gif\' title=\'Add Row\' style=\"visibility:hidden\" id=\"add_table_gif\"></img>\n\t\t\t</a>\n \t\t\t<a href=\'#\' onClick=\'deleteTable()\' style=\"visibility:hidden\" id=\"delete_table\">\n\t\t\t\t<img src=\'../../eOR/images/DeleteTable.gif\' title=\'Delete Row\' style=\"visibility:hidden\" id=\"delete_table_gif\"></img>\n\t\t\t</a>\n\t\t\t<a href=\"#\" onClick=\"previewEditor()\">\n\t\t\t\t<img src=\"../../eOR/images/print-Preview.gif\" title=\'Preview\'></img>\n\t\t\t</a>\n\t\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t\t<a href=\"#\" onClick=\"storeEditor()\">\n\t\t\t\t<img src=\"../../eCommon/images/enabled.gif\" title=\'OK\'></img>\n\t\t\t</a>\n\t\t ";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n\t\t</font>\n\t</td>\n</tr>\n</table>\n<!--IN27550,starts-->\n<script>\nif(top.opener) //Added Condition Chowminya to handle top.opener.document is null error,IN29559\n{\n\tif(top.opener.document.getElementById(\"refusal_text\"))\n\t{\n\t\ttop.opener.document.getElementById(\"refusal_text\").innerHTML=\"<a class=\'gridLink\' href=\'javascript:showRefusalDesc()\'>\"+getLabel(\"eOR.RefusalText.label\",\"OR\")+\"</a>\";\n\t}\n}\n</script>\n<!--IN27550,ends-->\n<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:20%; visibility:hidden;\' bgcolor=\'blue\'>\n\t<table id=\'tooltiptable\' cellpadding=0 cellspacing=0 border=\'0\'  width=\'100%\' height=\'100%\' align=\'center\'>\n\t\t<tr>\n\t\t\t\t<td width=\'100%\' id=\'t\'></td>\n\t\t\t</td>\n\t\t</tr>\n\t</table>\n</div>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");
	String p_ok_button = request.getParameter("p_ok_button");
	//out.println(" p_ok_button"+ p_ok_button);
	if(p_ok_button==null) p_ok_button = "";
	// When OK Button is not need then parameter value will be passed as NO.


            _bw.write(_wl_block3Bytes, _wl_block3);
  if(p_ok_button.equals("")) { 
            _bw.write(_wl_block4Bytes, _wl_block4);
 } 
            _bw.write(_wl_block5Bytes, _wl_block5);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
