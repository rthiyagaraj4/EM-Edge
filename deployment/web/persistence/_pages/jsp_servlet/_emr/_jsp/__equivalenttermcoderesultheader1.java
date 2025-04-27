package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __equivalenttermcoderesultheader1 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/EquivalentTermCodeResultHeader1.jsp", 1709118919126L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n<html>\n<head>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\"></link>\n<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script> \n<script language=\"JavaScript\" src=\"../../eCommon/js/messages.js\"></script>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<SCRIPT LANGUAGE=\"JavaScript\">\n\nfunction callresult(values)\n{\n\tvar termsetid = document.term_code_result_header.termsetid.value;\n\tvar search_criteria = document.term_code_result_header.search_criteria.value;\n\tvar search_text = document.term_code_result_header.search_text.value;\n\tvar termcode = document.term_code_result_header.termcode.value;\n\tvar codelevel = document.term_code_result_header.codelevel.value;\n\tif(codelevel==\"\") codelevel = \"1\";\n\tvar srch_text = search_text.toUpperCase();\n\tvar hypval = values;\n\tif(termsetid!=null)\n\t{\n\t\tif(search_criteria==\"S\")\n\t\t{\n\t\t\tif(search_text!=\"\")\n\t\t\t{\n\t\t\t\tif((search_text==hypval) || (srch_text==hypval))\n\t\t\t\t{\n\t\t\t\t\tparent.f_term_code_result.location.href=\"../../eMR/jsp/EquivalentTermCodeResult.jsp?termdesc=\"+values+\"&termsetid=\"+termsetid+\"&search_criteria=\"+search_criteria+\"&search_text=\"+search_text+\"&termcode=\"+termcode+\"&codelevel=\"+codelevel+\"\";\n\t\t\t\t\tdocument.term_code_result_header.submit();\n\t\t\t\t}\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tparent.f_term_code_result.location.href=\"../../eMR/jsp/EquivalentTermCodeResult.jsp?termdesc=\"+values+\"&termsetid=\"+termsetid+\"&search_criteria=\"+search_criteria+\"&search_text=\"+search_text+\"&termcode=\"+termcode+\"&codelevel=\"+codelevel+\"\";\n\t\t\t\tdocument.term_code_result_header.submit();\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\t\n\t\t\tif(document.term_code_result_header.className.value==\"className\")\n\t\t\t\tclassName = \"className\";\n\t\t\telse\n\t\t\t\tclassName = \"\";\n\t\t\tparent.f_term_code_result.location.href=\"../../eMR/jsp/EquivalentTermCodeResult.jsp?termdesc=\"+values+\"&termsetid=\"+termsetid+\"&search_criteria=\"+search_criteria+\"&search_text=\"+search_text+\"&termcode=\"+termcode+\"&codelevel=\"+codelevel+\"&className=\"+className+\"\";\n\t\t\tdocument.term_code_result_header.submit();\n\t\t}\n\t}\n\tparent.messageFrame.document.location.href = \"../../eCommon/jsp/MstCodeError.jsp\";\n}\nfunction callres()\n{\n\tvar termsetid = document.term_code_result_header.termsetid.value;\n\tvar search_criteria = document.term_code_result_header.search_criteria.value;\n\tvar search_text = document.term_code_result_header.search_text.value;\n\tvar termcode = document.term_code_result_header.termcode.value;\n\tvar codelevel = document.term_code_result_header.codelevel.value;\n\tif(codelevel==\"\") codelevel = \"1\";\n\tsearch_text = search_text.toUpperCase();\n\tif(document.term_code_result_header.class_lvl.value==document.term_code_result_header.codelevel.value)\n\t\tclassName = \"className\";\n\telse\n\t\tclassName = \"\";\n\tif(termsetid!=null)\n\t{\n\t\tparent.parent.f_term_code_result.location.href=\"../../eMR/jsp/EquivalentTermCodeResult.jsp?termsetid=\"+termsetid+\"&search_criteria=\"+search_criteria+\"&search_text=\"+search_text+\"&termcode=\"+termcode+\"&codelevel=\"+codelevel+\"&className=\"+className+\"\";\n\t\tdocument.term_code_result_header.submit();\n\t}\n\tparent.messageFrame.document.location.href = \"../../eCommon/jsp/MstCodeError.jsp\";\n}\n</SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body OnMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'>\n<FORM METHOD=\'POST\' name=\'term_code_result_header\' id=\'term_code_result_header\' target=\'blankFrame\' ACTION=\"../../eMR/jsp/EquivalentTermCodeResult.jsp\">\n<TABLE border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\'center\'>\n<TR>\n\t<TD>&nbsp;</TD>\n\t<TD class=\"QUERYDATA\" width=\"35%\" id=\"dynlevel\" align=\'left\' >&nbsp;</TD>\n\t<TD width=\"35%\" class=\'label\' align=\'left\'>&nbsp;&nbsp;Search&nbsp;<INPUT TYPE=\"text\" name=\"search_text\" id=\"search_text\" maxlength=\'100\' size=\'40\'>\n\t</TD>\n\t<TD align=\'left\'><SELECT name=\"search_criteria\" id=\"search_criteria\">\n\t<OPTION Value=\"C\">Contains</OPTION>\n\t<OPTION value=\"S\">Starts With</OPTION>\n\t<OPTION Value=\"E\">Ends With</OPTION>\n\t</SELECT><INPUT TYPE=\"button\" class=\"button\" value=\"Search\" onclick=\"callres()\">\n\t</TD>    \n</TR>\n</TABLE>\n<TABLE border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\'center\'>\n<TR>\n\t<TD>&nbsp;</TD>\n\t<TD>&nbsp;</TD>\n\t<TD>&nbsp;</TD>\n\t<TD>&nbsp;</TD>\n\t<TD class=\"label\"><A HREF=\"javascript:callresult(\'All\')\"><U>All</U></A></TD>\n\t<TD class=\"label\"><A HREF=\"javascript:callresult(\'A\')\"><U>A</U></A></TD>\n\t<TD class=\"label\"><A HREF=\"javascript:callresult(\'B\')\"><U>B</U></A></TD>\n\t<TD class=\"label\"><A HREF=\"javascript:callresult(\'C\')\"><U>C</U></A></TD>\n\t<TD class=\"label\"><A HREF=\"javascript:callresult(\'D\')\"><U>D</U></A></TD>\n\t<TD class=\"label\"><A HREF=\"javascript:callresult(\'E\')\"><U>E</U></A></TD>\n\t<TD class=\"label\"><A HREF=\"javascript:callresult(\'F\')\"><U>F</U></A></TD>\n\t<TD class=\"label\"><A HREF=\"javascript:callresult(\'G\')\"><U>G</U></A></TD>\n\t<TD class=\"label\"><A HREF=\"javascript:callresult(\'H\')\"><U>H</U></A></TD>\n\t<TD class=\"label\"><A HREF=\"javascript:callresult(\'I\')\"><U>I</U></A></TD>\n\t<TD class=\"label\"><A HREF=\"javascript:callresult(\'J\')\"><U>J</U></A></TD>\n\t<TD class=\"label\"><A HREF=\"javascript:callresult(\'K\')\"><U>K</U></A></TD>\n\t<TD class=\"label\"><A HREF=\"javascript:callresult(\'L\')\"><U>L</U></A></TD>\n\t<TD class=\"label\"><A HREF=\"javascript:callresult(\'M\')\"><U>M</U></A></TD>\n\t<TD class=\"label\"><A HREF=\"javascript:callresult(\'N\')\"><U>N</U></A></TD>\n\t<TD class=\"label\"><A HREF=\"javascript:callresult(\'O\')\"><U>O</U></A></TD>\n\t<TD class=\"label\"><A HREF=\"javascript:callresult(\'P\')\"><U>P</U></A></TD>\n\t<TD class=\"label\"><A HREF=\"javascript:callresult(\'Q\')\"><U>Q</U></A></TD>\n\t<TD class=\"label\"><A HREF=\"javascript:callresult(\'R\')\"><U>R</U></A></TD>\n\t<TD class=\"label\"><A HREF=\"javascript:callresult(\'S\')\"><U>S</U></A></TD>\n\t<TD class=\"label\"><A HREF=\"javascript:callresult(\'T\')\"><U>T</U></A></TD>\n\t<TD class=\"label\"><A HREF=\"javascript:callresult(\'U\')\"><U>U</U></A></TD>\n\t<TD class=\"label\"><A HREF=\"javascript:callresult(\'V\')\"><U>V</U></A></TD>\n\t<TD class=\"label\"><A HREF=\"javascript:callresult(\'W\')\"><U>W</U></A></TD>\n\t<TD class=\"label\"><A HREF=\"javascript:callresult(\'X\')\"><U>X</U></A></TD>\n\t<TD class=\"label\"><A HREF=\"javascript:callresult(\'Y\')\"><U>Y</U></A></TD>\n\t<TD class=\"label\"><A HREF=\"javascript:callresult(\'Z\')\"><U>Z</U></A></TD>\n\t<TD class=\"label\">&nbsp;</TD>\n\t<TD class=\"label\">&nbsp;</TD>\n\t<TD class=\"label\"><A HREF=\"javascript:callresult(\'OT\')\"><U>Others</U></A></TD>\n</TR>\n</TABLE>\n<INPUT TYPE=\"hidden\" name=\'termsetid\' id=\'termsetid\' value=\'\'>\n<INPUT TYPE=\"hidden\" name=\'termdesc\' id=\'termdesc\' value=\'\'>\n<INPUT TYPE=\"hidden\" name=\'termcode\' id=\'termcode\' value=\'\'>\n<INPUT TYPE=\"hidden\" name=\'codelevel\' id=\'codelevel\' value=\'\'>\n<INPUT TYPE=\"hidden\" name=\"className\" id=\"className\" value=\"\">\n<INPUT TYPE=\"hidden\" name=\"class_lvl\" id=\"class_lvl\" value=\"\">\n</FORM>\n</body>\n</html>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}


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
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);
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
