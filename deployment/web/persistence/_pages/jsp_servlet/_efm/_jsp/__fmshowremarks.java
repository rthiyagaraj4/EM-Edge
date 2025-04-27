package jsp_servlet._efm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;

public final class __fmshowremarks extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMShowRemarks.jsp", 1734323019102L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<HTML>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<HEAD>\n\t<TITLE>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</TITLE>\n\t<!-- <LINK REL=\"stylesheet\" TYPE=\"text/css\" HREF=\"../../eCommon/html/IeStyle.css\"></LINK> -->\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'></link>\n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/common.js\"></SCRIPT>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n<style>\ntextarea {\n    overflow-y: scroll;\n    height: 100px;\n    resize: none; /* Remove this if you want the user to resize the textarea */\n}\n</style>\n\n\t<SCRIPT>\n\t\tvar chkBlank = \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\tfunction checkMaxLimit(obj, maxSize, keycode) {\n\n\t\t\t\n\t\t\t// code added for icn:19422 date:Wednesday, February 24, 2010  charcter restrict for 19717\n\t\t\n  \t\t\n\t\t//\tkeycode == 37  || keycode == 43 || keycode == 35||\n\t\t\t\n\t\t\tif (keycode == 96 || keycode == 126 ||  keycode == 39 ||\n\t\t\t\tkeycode == 34 || obj.value.length >= maxSize) return false;\n\t\t\telse return true;\n\t\t}\n\n\t\tfunction chkForBlank() {\n\t\t\tif (trimCheck(document.getElementById(\"comments\").value)) {\n\t\t\t\treturn true;\n\t\t\t}\n\t\t\telse {\n\t\t\t\t//alert(\"APP-000001 - Remarks cannot be blank\");\n\t\t\t\tvar errmsg=getMessage(\"CAN_NOT_BE_BLANK\",\"common\");\n\t\t\t\terrmsg=errmsg.replace(\'$\',getLabel(\"Common.remarks.label\",\"common\"));\n\t\t\t\talert(errmsg);\n\t\t\t\tdocument.getElementById(\"comments\").focus();\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\n\t\tfunction closeWin() {\n\t\t\tif (chkBlank == \"true\") {\n\t\t\t\tif (chkForBlank()) {\n\t\t\t\t\tif (document.getElementById(\"comments\").value.length > ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =") {\n\t\t\t\t\t//\talert(\"APP-SM0045 - Remarks cannot exceed \" + ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="  + \" characters\");\n\t\t\t\t\t\tvar errmsg=getMessage(\"REMARKS_CANNOT_EXCEED\",\"common\");\n\t\t\t\t\t\terrmsg=errmsg.replace(\'$\',getLabel(\"Common.remarks.label\",\"common\"));\n\t\t\t\t\t\terrmsg=errmsg.replace(\'#\',";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =");\n\t\t\t\t\t\talert(errmsg);\n\t\t\t\t\t\tdocument.getElementById(\"comments\").focus();\n\t\t\t\t\t}\n\t\t\t\t\telse {\n\t\t\t\t\t\twindow.returnValue = document.getElementById(\"comments\").value;\n\t\t\t\t\t\tparent.document.getElementById(\"dialog_tag\").close(); \n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t\telse {\n\t\t\t\tif (document.getElementById(\"comments\").value.length > ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =") {\n\t\t\t\t\t//alert(\"APP-SM0045 - Remarks cannot exceed \" + ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="  + \" characters\");\n\t\t\t\t\tvar errmsg=getMessage(\"REMARKS_CANNOT_EXCEED\",\"common\");\n\t\t\t\t\terrmsg=errmsg.replace(\'$\',getLabel(\"Common.remarks.label\",\"common\"));\n\t\t\t\t\terrmsg=errmsg.replace(\'#\',";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =");\n\t\t\t\t\n\t\t\t\t\talert(errmsg);\n\t\t\t\t\tdocument.getElementById(\"comments\").focus();\n\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse {\n\t\t\t\t\twindow.returnValue = document.getElementById(\"comments\").value;\n\t\t\t\t\tparent.document.getElementById(\"dialog_tag\").close(); \n\t\t\t\t}\n\t\t\t}\n\t\t}\n\n\t\t\n\n\t</SCRIPT>\n</HEAD>\n\n<BODY onUnload=\"closeWin()\" onKeyDown = \'lockKey()\' >\n<!-- <p style=\"margin-bottom: 0px;\">Request Remarks</p> -->\n<TABLE WIDTH=\"100%\" BORDER=\"0\" CELLSPACING=\"0\" CELLPADDING=\"3\" ALIGN=\"center\" >\n\t<TR>\n\t\t<TD CLASS=\"label\" WIDTH=\"10%\"></TD>\n\t</TR>\n\t<TR>\n\t\t<TD WIDTH=\"90%\" CLASS=\"label\">&nbsp;<TEXTAREA id=\"comments\" NAME=\"comments\" ROWS=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" COLS=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" onKeyPress=\"return checkMaxLimit(this,\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\', event.keyCode);\" onBlur=\"makeValidString(this);\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</TEXTAREA>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\' id=\"mand\" style=\"Visibility:\'Hidden\'\"></img></TD>\n\t</TR>\n\t\n\t\n\t<tr>\n\t<td align=\"center\" class=\'labelcenter\'><INPUT  TYPE=\"button\" CLASS=\"button\" name=\"Ok\" id=\"Ok\" VALUE=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" onClick=\"closeWin()\"></td>\n\t</tr>\n\t<!-- <tr><td class=\'label\'>&nbsp;</td></tr> -->\n</TABLE>\n<!-- <CENTER><INPUT TYPE=\"button\" CLASS=\"button\" name=\"Ok\" id=\"Ok\" VALUE=\"    Ok    \" onClick=\"closeWin()\"></CENTER> -->\n<script>\n\tif (\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\"==\"true\")\n\t\t document.getElementById(\"mand\").style.visibility=\'Visible\';\n\telse document.getElementById(\"mand\").style.visibility=\'Hidden\';\n</script>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );
	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString == "") ||(inputString.equals("null"))) ? defaultValue : inputString);
	}


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
	String curr_remarks = request.getParameter("curr_remarks");
	String title = request.getParameter("title");
	String editable = request.getParameter("editable");
	String rows = request.getParameter("rows");
	String cols = request.getParameter("cols");
	String maxLimit = request.getParameter("maxLimit");
	String chkBlank = request.getParameter("chkBlank");
   String funct= request.getParameter("funct");
	
	if(funct==null) funct="";
	if (rows == null) rows = "5";
	if (cols == null) cols = "60";
	if (maxLimit == null) maxLimit= "100";
	if (chkBlank == null) chkBlank= "false";
	if (editable == null) editable="";
	
	if (curr_remarks==null) curr_remarks="";
 /* if(funct.equals("req"))
	{
	curr_remarks=java.net.URLDecoder.decode(curr_remarks,"UTF-8");
	}  */

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf( title ));
            _bw.write(_wl_block7Bytes, _wl_block7);

	
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf( chkBlank ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf( maxLimit ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf( maxLimit ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf( maxLimit ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf( maxLimit ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf( maxLimit ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf( maxLimit ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf( rows ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf( cols ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf( editable ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(maxLimit));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf( curr_remarks));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(chkBlank));
            _bw.write(_wl_block23Bytes, _wl_block23);
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
