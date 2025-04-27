package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;

public final class __creditcardguitransactions extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/CreditCardGUITransactions.jsp", 1733051214495L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<HTML>\n<HEAD>\n\n<title>Credit Card Interface</title>\n\n<script type=\"text/javascript\">\nfunction processResponse(action)\n{\t\n\tvar myObj = {};\n\tvar message = \"\";\n\tvar cardNo = document.getElementById(\"P_Preapaid_Card_Number\").value;\n\n\tif(action == \'OK\') {\n\t\tif(cardNo == \"\") {\n\t\t\talert(getMessage(\'XH0121\',\'XH\'));\n\t\t\tdocument.getElementById(\"P_Preapaid_Card_Number\").focus();\n\t\t\treturn;\n\t\t}\n\t\telse {\n\t\t\tif(cardNo.charAt(0) == \';\') {\n\t\t\t\tcardNo = cardNo.substring(1);\n\t\t\t}\n\t\t\tvar cardNoLen = cardNo.length;\n\t\t\t\n\t\t\tif(cardNo.charAt(cardNoLen - 1) == \'?\') {\n\t\t\t\tcardNo = cardNo.substring(0, cardNoLen - 1);\n\t\t\t}\n\t\t\tmessage = cardNo + \"$|#\" + \"\";\n\t\t}\n\t}\n\telse {\n\t\tretVal = getMessage(\'XH0122\',\'XH\');\n\t\tretVal = \"E\" + \"$|#\" + retVal + \"$|#\" + retVal;\n\t\tmessage = \"\" + \"$|#\" + retVal;\n\t}\n\twindow.close();\n\twindow.returnValue = message;\n} \n</script>\n<style>\n#tabTable {\n   position:fixed;\n    top: 20%;\n    left: 15%;\n}\n</style>\n<SCRIPT LANGUAGE=\"JAVASCRIPT\" SRC=\"../../eCommon/js/ValidateControl.js\"></SCRIPT>\n<SCRIPT LANGUAGE=\"JAVASCRIPT\" SRC=\'../../eCommon/js/jquery-3.6.3.js\'></SCRIPT>\n<SCRIPT LANGUAGE=\"JAVASCRIPT\" SRC=\'../../eXH/js/Validate.js\'></SCRIPT>\n<SCRIPT LANGUAGE=\"JAVASCRIPT\" SRC=\"../../eCommon/js/CommonLookup.js\"></SCRIPT>\n<SCRIPT LANGUAGE=\"JAVASCRIPT\" SRC=\'../../eCommon/js/common.js\'></SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'></link>\n</head>\n<BODY leftmargin=0 topmargin=0 onMouseDown=\"CodeArrest()\" onKeyDown=\'lockKey()\'>\n<FORM ID=\"creditCardGUI\" name=\"creditCardGUI\" id=\"creditCardGUI\">\n\t<TABLE ID=\"tabTable\">\n\t<TR>\n\t\t<TD CLASS=\"label\" COLSPAN=\"2\">Swipe Walletree Card for Patient ID - ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</TD>\n\t</TR>\n\t<TR>\n\t\t<TD CLASS=\"label\">Card # </TD>\n\t\t<TD><INPUT TYPE=\"text\" name=\"P_Preapaid_Card_Number\" id=\"P_Preapaid_Card_Number\" ID=\"P_Preapaid_Card_Number\"></TD>\n\t</TR>\n\t<TR ALIGN=\"right\">\n\t\t<TD COLSPAN=\"2\" CLASS=>\n\t\t\t<INPUT CLASS=\"BUTTON\" TYPE=\"button\" VALUE=\"Ok\" onClick=\"processResponse(\'OK\')\">\n\t\t\t<INPUT CLASS=\"BUTTON\" TYPE=\"button\" VALUE=\"Cancel\" onClick=\"processResponse(\'CANCEL\')\">\n\t\t</TD>\n\t</TR>\n\t</TABLE>\n</FORM>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block2Bytes, _wl_block2);

String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${param.P_patient_id}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block7Bytes, _wl_block7);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
