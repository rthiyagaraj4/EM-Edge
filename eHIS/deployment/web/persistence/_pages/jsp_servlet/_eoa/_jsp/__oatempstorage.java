package jsp_servlet._eoa._jsp;

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
import java.net.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __oatempstorage extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/OATempStorage.jsp", 1709119249225L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<body>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<form name=\'tempStorageForm\' id=\'tempStorageForm\'>\n\t\t<input type=\'hidden\' name=\'position\' id=\'position\' value=\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'>\n\t\t<input type=\'hidden\' name=\'addtl_splty\' id=\'addtl_splty\' value=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'>\n\t\t<input type=\"hidden\" name=\'rule_appl_yn\' id=\'rule_appl_yn\' value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'>\n\t\t<input type=\"hidden\" name=\'patient_id_temp\' id=\'patient_id_temp\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>\n\t\t<input type=\"hidden\" name=\'name_prefix_temp\' id=\'name_prefix_temp\' value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n\t\t<input type=\"hidden\" name=\'first_name_temp\' id=\'first_name_temp\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n\t\t<input type=\"hidden\" name=\'second_name_temp\' id=\'second_name_temp\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n\t\t<input type=\"hidden\" name=\'third_name_temp\' id=\'third_name_temp\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n\t\t<input type=\"hidden\" name=\'family_name_temp\' id=\'family_name_temp\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n\t\t<input type=\'hidden\' name=\'name_suffix_temp\' id=\'name_suffix_temp\' value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t\t<input type=\'hidden\' name=\'name_prefix_oth_lang_temp\' id=\'name_prefix_oth_lang_temp\' value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\t\t<input type=\'hidden\' name=\'first_name_oth_lang_temp\' id=\'first_name_oth_lang_temp\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n\t\t<input type=\'hidden\' name=\'second_name_oth_lang_temp\' id=\'second_name_oth_lang_temp\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n\t\t<input type=\'hidden\' name=\'third_name_oth_lang_temp\' id=\'third_name_oth_lang_temp\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\n\t\t<input type=\'hidden\' name=\'family_name_oth_lang_temp\' id=\'family_name_oth_lang_temp\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n\t\t<input type=\'hidden\' name=\'name_suffix_oth_lang_temp\' id=\'name_suffix_oth_lang_temp\' value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t\t<input type=\"hidden\" name=\'gender_temp\' id=\'gender_temp\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n\t\t<input type=\"hidden\" name=\'contact_no_temp\' id=\'contact_no_temp\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n\t\t<input type=\"hidden\" name=\'nationality_code_temp\' id=\'nationality_code_temp\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n\t\t<input type=\"hidden\" name=\'language_code_temp\' id=\'language_code_temp\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\n\t\t<input type=\"hidden\" name=\'term_set_id\' id=\'term_set_id\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\n\t\t<input type=\"hidden\" name=\'linking_code\' id=\'linking_code\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\t\t\n\t\t<input type=\"hidden\" name=\'apptrefno\' id=\'apptrefno\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\t\t\n\t</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );


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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
 	String position			= checkForNull(request.getParameter("position"));
	String addtl_splty		= checkForNull(request.getParameter("addtl_splty"));
	String rule_appl_yn		= checkForNull(request.getParameter("rule_appl_yn"));
	String patient_id_temp	= checkForNull(request.getParameter("patient_id_temp"));
	String name_prefix_temp	= checkForNull(request.getParameter("name_prefix_temp"));
	String first_name_temp	= checkForNull(request.getParameter("first_name_temp"));
	String second_name_temp	= checkForNull(request.getParameter("second_name_temp"));
	String third_name_temp	= checkForNull(request.getParameter("third_name_temp"));
	String family_name_temp	= checkForNull(request.getParameter("family_name_temp"));
	String name_suffix_temp	=checkForNull(request.getParameter("name_suffix_temp"));	
	String name_prefix_oth_lang_temp	=checkForNull(request.getParameter("name_prefix_oth_lang_temp"));
	String first_name_oth_lang_temp	=checkForNull(request.getParameter("first_name_oth_lang_temp"));
	String second_name_oth_lang_temp	=checkForNull(request.getParameter("second_name_oth_lang_temp"));
	String third_name_oth_lang_temp	=checkForNull(request.getParameter("third_name_oth_lang_temp"));
	String family_name_oth_lang_temp	=checkForNull(request.getParameter("family_name_oth_lang_temp"));
	String name_suffix_oth_lang_temp	=checkForNull(request.getParameter("name_suffix_oth_lang_temp"));
	String gender_temp		= checkForNull(request.getParameter("gender_temp"));
	String contact_no_temp	= checkForNull(request.getParameter("contact_no_temp"));
	String nationality_code_temp	= checkForNull(request.getParameter("nationality_code_temp"));
	String language_code_temp	= checkForNull(request.getParameter("language_code_temp"));
	String term_set_id			= checkForNull(request.getParameter("term_set_id"));
	String linking_code			= checkForNull(request.getParameter("linking_code")); 	
	String apptrefno			= checkForNull(request.getParameter("apptrefno")); 	
	//System.out.println("name_suffix_temp OATempStorage.jsp:"+name_suffix_temp);

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(position));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(addtl_splty));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(rule_appl_yn));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(patient_id_temp));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(name_prefix_temp));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(first_name_temp));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(second_name_temp));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(third_name_temp));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(family_name_temp));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(name_suffix_temp));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(name_prefix_oth_lang_temp));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(first_name_oth_lang_temp));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(second_name_oth_lang_temp));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(third_name_oth_lang_temp));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(family_name_oth_lang_temp));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(name_suffix_oth_lang_temp));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(gender_temp));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(contact_no_temp));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(nationality_code_temp));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(language_code_temp));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(linking_code));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(apptrefno));
            _bw.write(_wl_block29Bytes, _wl_block29);
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
