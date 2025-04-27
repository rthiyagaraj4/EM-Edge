package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __selecttermcodedisplaylevels extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/SelectTermCodeDisplayLevels.jsp", 1722521800972L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"></link>\n<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\n\n\n<script language=\"JavaScript\" src=\"../js/TerminologyCode.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<script>\nfunction dispresultpg(codelevel,termsetid)\n{ \n\tvar  termcode\t\n\tif(codelevel==1)\n\t{\n\t\ttermcode = \'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'\n\t\tparent.parent.f_term_result_header.document.term_code_result_header.termcode.value = \'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\';\n\t\tparent.parent.f_term_result_header.document.term_code_result_header.codelevel.value = codelevel;\n\t\tdocument.term_code_displvl.termcode2.value=\"\";\n\t\tdocument.term_code_displvl.termcode3.value=\"\";\n\t\tdocument.term_code_displvl.termcode4.value=\"\";\n\t\tdocument.term_code_displvl.termcode5.value=\"\";\n\t\tdocument.term_code_displvl.termcode6.value=\"\";\n\t\tdocument.term_code_displvl.termcode7.value=\"\";\n\t\tdocument.term_code_displvl.termcode8.value=\"\";\n\t\tdocument.term_code_displvl.termcode9.value=\"\";\n\t\tdocument.term_code_displvl.termcode10.value=\"\";\n\t\tparent.parent.f_term_selected_frms.f_term_selected_value.document.location.href=\"../../eMR/jsp/SelectTermCodeSelectedValues.jsp\";\n\t}\n\telse if (codelevel==2)\n\t{\t\n\t\ttermcode = document.term_code_displvl.termcode2.value;\n\t\tparent.parent.f_term_result_header.document.term_code_result_header.termcode.value = termcode;\n\t\tparent.parent.f_term_result_header.document.term_code_result_header.codelevel.value = codelevel;\n\t\tdocument.term_code_displvl.termcode3.value=\"\";\n\t\tdocument.term_code_displvl.termcode4.value=\"\";\n\t\tdocument.term_code_displvl.termcode5.value=\"\";\n\t\tdocument.term_code_displvl.termcode6.value=\"\";\n\t\tdocument.term_code_displvl.termcode7.value=\"\";\n\t\tdocument.term_code_displvl.termcode8.value=\"\";\n\t\tdocument.term_code_displvl.termcode9.value=\"\";\n\t\tdocument.term_code_displvl.termcode10.value=\"\";\n\t}\n\telse if (codelevel==3)\n\t{\n\t\ttermcode = document.term_code_displvl.termcode3.value;\n\t\tparent.parent.f_term_result_header.document.term_code_result_header.termcode.value = termcode;\n\t\tparent.parent.f_term_result_header.document.term_code_result_header.codelevel.value = codelevel;\n\t\tdocument.term_code_displvl.termcode4.value=\"\";\n\t\tdocument.term_code_displvl.termcode5.value=\"\";\n\t\tdocument.term_code_displvl.termcode6.value=\"\";\n\t\tdocument.term_code_displvl.termcode7.value=\"\";\n\t\tdocument.term_code_displvl.termcode8.value=\"\";\n\t\tdocument.term_code_displvl.termcode9.value=\"\";\n\t\tdocument.term_code_displvl.termcode10.value=\"\";\n\t}\n\telse if (codelevel==4)\n\t{\n\t\ttermcode = document.term_code_displvl.termcode4.value;\n\t\tparent.parent.f_term_result_header.document.term_code_result_header.termcode.value = termcode;\n\t\tparent.parent.f_term_result_header.document.term_code_result_header.codelevel.value = codelevel;\n\t\tdocument.term_code_displvl.termcode5.value=\"\";\n\t\tdocument.term_code_displvl.termcode6.value=\"\";\n\t\tdocument.term_code_displvl.termcode7.value=\"\";\n\t\tdocument.term_code_displvl.termcode8.value=\"\";\n\t\tdocument.term_code_displvl.termcode9.value=\"\";\n\t\tdocument.term_code_displvl.termcode10.value=\"\";\n\t}\n\telse if (codelevel==5)\n\t{\n\t\ttermcode = document.term_code_displvl.termcode5.value;\n\t\tparent.parent.f_term_result_header.document.term_code_result_header.termcode.value = termcode;\n\t\tparent.parent.f_term_result_header.document.term_code_result_header.codelevel.value = codelevel;\n\t\tdocument.term_code_displvl.termcode6.value=\"\";\n\t\tdocument.term_code_displvl.termcode7.value=\"\";\n\t\tdocument.term_code_displvl.termcode8.value=\"\";\n\t\tdocument.term_code_displvl.termcode9.value=\"\";\n\t\tdocument.term_code_displvl.termcode10.value=\"\";\n\t}\n\telse if (codelevel==6)\n\t{\n\t\ttermcode = document.term_code_displvl.termcode6.value;\n\t\tparent.parent.f_term_result_header.document.term_code_result_header.termcode.value = termcode;\n\t\tparent.parent.f_term_result_header.document.term_code_result_header.codelevel.value = codelevel;\n\t\tdocument.term_code_displvl.termcode7.value=\"\";\n\t\tdocument.term_code_displvl.termcode8.value=\"\";\n\t\tdocument.term_code_displvl.termcode9.value=\"\";\n\t\tdocument.term_code_displvl.termcode10.value=\"\";\n\t}\n\telse if (codelevel==7)\n\t{\n\t\ttermcode = document.term_code_displvl.termcode7.value;\n\t\tparent.parent.f_term_result_header.document.term_code_result_header.termcode.value = termcode;\n\t\tparent.parent.f_term_result_header.document.term_code_result_header.codelevel.value = codelevel;\n\t\tdocument.term_code_displvl.termcode8.value=\"\";\n\t\tdocument.term_code_displvl.termcode9.value=\"\";\n\t\tdocument.term_code_displvl.termcode10.value=\"\";\n\t}\n\telse if (codelevel==8)\n\t{\n\t\ttermcode = document.term_code_displvl.termcode8.value;\n\t\tparent.parent.f_term_result_header.document.term_code_result_header.termcode.value = termcode;\n\t\tparent.parent.f_term_result_header.document.term_code_result_header.codelevel.value = codelevel;\n\t\tdocument.term_code_displvl.termcode9.value=\"\";\n\t\tdocument.term_code_displvl.termcode10.value=\"\";\n\t}\n\telse if (codelevel==9)\n\t{\n\t\ttermcode = document.term_code_displvl.termcode9.value;\n\t\tparent.parent.f_term_result_header.document.term_code_result_header.termcode.value = termcode;\n\t\tparent.parent.f_term_result_header.document.term_code_result_header.codelevel.value = codelevel;\n\t\tdocument.term_code_displvl.termcode10.value=\"\";\n\t}\n\telse if (codelevel==10)\n\t{\n\t\ttermcode = document.term_code_displvl.termcode10.value;\n\t\tparent.parent.f_term_result_header.document.term_code_result_header.termcode.value = termcode;\n\t\tparent.parent.f_term_result_header.document.term_code_result_header.codelevel.value = codelevel;\n\t}\n\tif(termcode!=\"\")\n\t{\n\t\tparent.parent.f_term_code_result.location.href=\"../../eMR/jsp/SelectTermCodeResult.jsp?termcode=\"+termcode+\"&termsetid=\"+termsetid+\"&codelevel=\"+codelevel+\"\";\n\t}\n\telse\n\t{\n\t\talert(getMessage(\"HIGHER_LVL_SEL\",\'MR\'));\n\t\treturn false;\n\t}\n\t// This part is wriiten for deleteing the the rows according to the classification\n\t// level selected in this we take the length of the row and subtract it with the \n\t// rwlen value which we store as hidden field in this page.\n\tif(codelevel!=1)\n\t{\n\t\tcddlvl = eval(codelevel);\n\t\trwlen = parent.parent.f_term_selected_frms.f_term_selected_value.document.getElementById(\"tableId\").rows.length;\n\t\tif(cddlvl <= rwlen)\n\t\t{\n\t\t\tvar baseCounter = cddlvl-1;\n\t\t\tfor(var i=baseCounter;i<rwlen;i++)\n\t\t\t{\n\t\t\t\tparent.parent.f_term_selected_frms.f_term_selected_value.document.getElementById(\"tableId\").deleteRow(baseCounter);\n\t\t\t}\n\t\t}\n\t}\n\t// End of deleting row.\n}\n</script>\n</head>\n<body OnMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'>\n<form name=\'term_code_displvl\' id=\'term_code_displvl\'>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' align=\'center\'  width=\'80%\' >\n<tr>\n\t<th style=\"color: #0000EE;\" nowrap colspan=\'2\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n</tr>\n<tr>\n\t<td style=\"color: #0000EE;\" class=\'ATCQRYEVEN\'onclick=\'dispresultpg(1,\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\")\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td><td class=\'ATCQRYEVEN\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n</tr>\n<tr>\n\t<td style=\"color: #0000EE;\" class=\'ATCQRYODD\'onclick=\'dispresultpg(2,\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td><td class=\'ATCQRYODD\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n</tr>\n<tr>\t\n\t<td style=\"color: #0000EE;\" class=\'ATCQRYEVEN\'onclick=\'dispresultpg(3,\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n</tr>\n<tr>\n\t<td style=\"color: #0000EE;\" class=\'ATCQRYODD\'onclick=\'dispresultpg(4,\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n</tr>\n<tr>\n\t<td style=\"color: #0000EE;\" class=\'ATCQRYEVEN\'onclick=\'dispresultpg(5,\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n</tr>\n<tr>\n\t<td style=\"color: #0000EE;\" class=\'ATCQRYODD\'onclick=\'dispresultpg(6,\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n</tr>\n<tr>\n\t<td style=\"color: #0000EE;\" class=\'ATCQRYEVEN\'onclick=\'dispresultpg(7,\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n</tr>\n<tr>\n\t<td style=\"color: #0000EE;\" class=\'ATCQRYODD\'onclick=\'dispresultpg(8,\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n</tr>\n<tr>\n\t<td style=\"color: #0000EE;\" class=\'ATCQRYEVEN\'onclick=\'dispresultpg(9,\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n</tr>\n<tr>\n\t<td style=\"color: #0000EE;\" class=\'ATCQRYODD\'onclick=\'dispresultpg(10,\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n</tr>\n</table>\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n<INPUT TYPE=\"hidden\" name=\"termcode2\" id=\"termcode2\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n<INPUT TYPE=\"hidden\" name=\"termcode3\" id=\"termcode3\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n<INPUT TYPE=\"hidden\" name=\"termcode4\" id=\"termcode4\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n<INPUT TYPE=\"hidden\" name=\"termcode5\" id=\"termcode5\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n<INPUT TYPE=\"hidden\" name=\"termcode6\" id=\"termcode6\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n<INPUT TYPE=\"hidden\" name=\"termcode7\" id=\"termcode7\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n<INPUT TYPE=\"hidden\" name=\"termcode8\" id=\"termcode8\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n<INPUT TYPE=\"hidden\" name=\"termcode9\" id=\"termcode9\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n<INPUT TYPE=\"hidden\" name=\"termcode10\" id=\"termcode10\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block2Bytes, _wl_block2);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String termsetid = request.getParameter("termsetid");
String codelevel = request.getParameter("codelevel");
if (codelevel==null) codelevel = "";
String termcode2 = "";
String termcode3 = "";
String termcode4 = "";
String termcode5 = "";
String termcode6 = "";
String termcode7 = "";
String termcode8 = "";
String termcode9 = "";
String termcode10 = "";
if (codelevel.equals("2")) 
termcode2 = request.getParameter("termcode");
else if (codelevel.equals("3")) 
termcode3 = request.getParameter("termcode");
else if (codelevel.equals("4")) 
termcode4 = request.getParameter("termcode");
else if (codelevel.equals("5")) 
termcode5 = request.getParameter("termcode");
else if (codelevel.equals("6")) 
termcode6 = request.getParameter("termcode");
else if (codelevel.equals("7")) 
termcode7 = request.getParameter("termcode");
else if (codelevel.equals("8")) 
termcode8 = request.getParameter("termcode");
else if (codelevel.equals("9")) 
termcode9 = request.getParameter("termcode");
else if (codelevel.equals("10")) 
termcode10 = request.getParameter("termcode");

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(termsetid));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(termsetid));
            _bw.write(_wl_block11Bytes, _wl_block11);

Connection con = null;
Statement displvlStmt = null;
ResultSet displvlRs = null;
String displvlSql = "";
String displvl1 = "";
String displvl2 = "";
String displvl3 = "";
String displvl4 = "";
String displvl5 = "";
String displvl6 = "";
String displvl7 = "";
String displvl8 = "";
String displvl9 = "";
String displvl10 = "";
String level_1_code_length = "";
String level_2_code_length = "";
String level_3_code_length = "";
String level_4_code_length = "";
String level_5_code_length = "";
String level_6_code_length = "";
String level_7_code_length = "";
String level_8_code_length = "";
String level_9_code_length = "";
String level_10_code_length = "";
//int displvlcnt = 0;
//int i = 0;
if(termsetid ==null) termsetid="";
try
{
	con = ConnectionManager.getConnection(request);
	displvlSql = "select level_1_desc,level_1_code_length,level_2_code_length,level_3_code_length,level_4_code_length,level_5_code_length,level_6_code_length,level_7_code_length,level_8_code_length,level_9_code_length,level_10_code_length,level_2_desc,level_3_desc,level_4_desc,level_5_desc,level_6_desc,level_7_desc,level_8_desc,level_9_desc,level_10_desc from mr_term_set where term_set_id='"+termsetid+"'";
	displvlStmt = con.createStatement();
	displvlRs = displvlStmt.executeQuery(displvlSql);
	
	if(displvlRs!=null)
	{
		if(displvlRs.next())
		{
			displvl1 = displvlRs.getString("level_1_desc");
			if(displvl1==null) displvl1="";
			displvl2 = displvlRs.getString("level_2_desc");
			if(displvl2==null) displvl2="";
			displvl3 = displvlRs.getString("level_3_desc");
			if(displvl3==null) displvl3="";
			displvl4 = displvlRs.getString("level_4_desc");
			if(displvl4==null) displvl4="";
			displvl5 = displvlRs.getString("level_5_desc");
			if(displvl5==null) displvl5="";
			displvl6 = displvlRs.getString("level_6_desc");
			if(displvl6==null) displvl6="";
			displvl7 = displvlRs.getString("level_7_desc");
			if(displvl7==null) displvl7="";
			displvl8 = displvlRs.getString("level_8_desc");
			if(displvl8==null) displvl8="";
			displvl9 = displvlRs.getString("level_9_desc");
			if(displvl9==null) displvl9="";
			displvl10 = displvlRs.getString("level_10_desc");
			if(displvl10==null) displvl10="";
			level_1_code_length = displvlRs.getString("level_1_code_length");
			level_2_code_length = displvlRs.getString("level_2_code_length");
			level_3_code_length = displvlRs.getString("level_3_code_length");
			level_4_code_length = displvlRs.getString("level_4_code_length");
			level_5_code_length = displvlRs.getString("level_5_code_length");
			level_6_code_length = displvlRs.getString("level_6_code_length");
			level_7_code_length = displvlRs.getString("level_7_code_length");
			level_8_code_length = displvlRs.getString("level_8_code_length");
			level_9_code_length = displvlRs.getString("level_9_code_length");
			level_10_code_length = displvlRs.getString("level_10_code_length");
			if(level_1_code_length==null) level_1_code_length="";
			if(level_2_code_length==null) level_2_code_length="";
			if(level_3_code_length==null) level_3_code_length="";
			if(level_4_code_length==null) level_4_code_length="";
			if(level_5_code_length==null) level_5_code_length="";
			if(level_6_code_length==null) level_6_code_length="";
			if(level_7_code_length==null) level_7_code_length="";
			if(level_8_code_length==null) level_8_code_length="";
			if(level_9_code_length==null) level_9_code_length="";
			if(level_10_code_length==null) level_10_code_length="";
		}
 	if(displvlRs!=null) displvlRs.close();
	if(displvlStmt!=null) displvlStmt.close();
	}
if(!termsetid.equals(""))
{

            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(termsetid));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(displvl1));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(level_1_code_length));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(termsetid));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(displvl2));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(level_2_code_length));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(termsetid));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(displvl3));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(level_3_code_length));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(termsetid));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(displvl4));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(level_4_code_length));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(termsetid));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(displvl5));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(level_5_code_length));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(termsetid));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(displvl6));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(level_6_code_length));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(termsetid));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(displvl7));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(level_7_code_length));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(termsetid));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(displvl8));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(level_8_code_length));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(termsetid));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(displvl9));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(level_9_code_length));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(termsetid));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(displvl10));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(level_10_code_length));
            _bw.write(_wl_block26Bytes, _wl_block26);

}
}
catch(Exception e)
{
	//out.println(e);
	e.printStackTrace();
}
finally 
{
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(termcode2));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(termcode3));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(termcode4));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(termcode5));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(termcode6));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(termcode7));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(termcode8));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(termcode9));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(termcode10));
            _bw.write(_wl_block36Bytes, _wl_block36);
            _bw.write(_wl_block3Bytes, _wl_block3);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ClassificationLevels.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }
}
