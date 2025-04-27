package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import java.net.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.*;
import com.ehis.util.DateUtils;
import eMP.DLAInterfaceUtil;
import java.util.*;
import com.ehis.util.*;

public final class __dlauiinterfacesearchresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/DlauiInterfaceSearchResult.jsp", 1709118609760L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<HTML>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<HEAD>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\'javascript\' src=\'../../eMP/js/dlainterface.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t\t\t\t   \n<BODY  leftmargin=0 topmargin=0 onMouseDown=\"CodeArrest()\" onKeyDown =\'lockKey()\'>\n\n<form name=\"view_dla_interface_result_form\" id=\"view_dla_interface_result_form\" id=\"view_dla_interface_result_form\"  method=\"post\" action=\"../../servlet/eMP.DLATransactionServlet\">\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t<SCRIPT> \n\t\t\t\tvar imageFormObj = parent.image_frame.view_dla_interface_result_form1;\t\t\t\n\t\t\t\timageFormObj.document.getElementById(\"image_body\").style.visibility = \"hidden\";\n\t\t\t\tif( !confirm(\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\') )\n\t\t\t\t{\n\t\t\t\t\tparent.message_frame.location.href = \"../../eCommon/html/blank.html\";\n\t\t\t\t\tparent.image_frame.location.href   = \"../../eCommon/html/blank.html\";\n\t\t\t\t\tparent.action_frame.location.href  = \"../../eCommon/html/blank.html\";\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\timageFormObj.document.getElementById(\"image_body\").style.visibility = \"visible\";\n\t\t\t\t}\n\t\t\t\t</SCRIPT>\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<table cellspacing=0 cellpadding=4 width=\'100%\' align=center>\n<tr>\n<td class=\'COLUMNHEADER\' width=\'30%\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" </td>\n<td class=\'COLUMNHEADER\' width=\'30%\'></td>\n<td class=\'COLUMNHEADER\' width=\'20%\'></td>\n<td class=\'COLUMNHEADER\' width=\'20%\'></td>\n</tr>\n\n<tr>\n<td class=\"label\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n<td class=\'fields\'>\n\t<input type=text name= usr_title id=\"usr_title\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" size=10 disabled>&nbsp;\n\t<input type=text name= usr_name id=\"usr_name\" value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' maxlength=\"80\" size=25 disabled>\n</td>\n<td class=\"label\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n<td>\n\t<input type=text name=\"middleName\" id=\"middleName\" id=\"middleName\" value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' maxlength=\"80\" size=25 disabled>\n</td>\n</tr>\n<tr>\n<td class=\"label\">\n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n</td>\n<td>\n\t<input type=text name= sur_name id=\"sur_name\" value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' maxlength=\"80\" size=25 disabled>\n</td>\n</tr>\n<tr>\n<td class=\"label\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n<td>\n<table>\n<tr>\n<td class=\'fields\'>\n\t<input type=text name= usr_dob id=\"usr_dob\" value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' size=10 disabled >\n</td>\n<td class=\"label\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n<td class=\'fields\'>\n\t<input type=\"text\" name=\"age\" id=\"age\" id=\"age\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" size=3 disabled>\n\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n</td>\n</tr>\n</table>\n</td>\n<td class=\"label\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n<td class=\'fields\'><input type=text name= gender_disp id=\"gender_disp\" value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' size=10 disabled></td>\n</tr>\n\n<tr>\n<td class=\"label\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n<td class=\'fields\'>\n\t<input type=text name= nationlity_id id=\"nationlity_id\" value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' maxlength=\"4\" size=10 disabled>&nbsp;\n\t<input type=text name= nationlity id=\"nationlity\" value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' size=25 disabled>\n</td>\n<td class=\"label\">\n\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n</td>\n<td class=\'fields\'>\n\t<input type=\"text\" name=\"national_id\" id=\"national_id\" id=\"national_id\"  value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" maxlength=\"20\" size=25 disabled></td>\n</tr>\n\n</table>\n\n<table cellspacing=0 cellpadding=4 width=\'100%\' align=center>\n\t<tr>\n\t<td class=\"label\">";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>\n\t<td class=\'fields\'><input type=text name= addr id=\"addr\" value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' size=25 disabled></td>\n\t</tr>\n\t<tr>\n\t<td class=\"label\">";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\n\t<td class=\'fields\'>\n\t\t<input type=text name=\"loc_code\" id=\"loc_code\" id=\"loc_code\" value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' size=10 disabled>\n\t\t<input type=text name=\"loc_desc\" id=\"loc_desc\" id=\"loc_desc\" value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' size=40 disabled>\n\t</td>\n\t</tr>\n\t<tr>\n\t<td class=\"label\">\n\t\t(";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="/";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =")\n\t</td>\n\t<td class=\"label\">&nbsp;</td>\n\t</tr>\n\t<tr>\n\t<td class=\"label\">";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</td>\n\t\t<td class=\'fields\'>\n\t\t\t<input type=text name= father_name id=\"father_name\" value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' maxlength=\"30\" size=25 disabled>\n\t\t</td>\n\t</tr>\n\t<tr>\n\t<td class=\"label\">";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\n\t<td class=\'fields\'><input type=text name= mother_name id=\"mother_name\"  value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' maxlength=\"30\" size=25 disabled></td>\n\t</tr>\n\t<tr>\n\t<td class=\"label\">\n\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t</td>\n\t<td class=\'fields\'>\n\t\t<input type=text name=\"deceased_status\" id=\"deceased_status\" id=\"deceased_status\"  value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' size=1 disabled>\n\t\t<input type=\"hidden\" name=\"deceased_yn\" id=\"deceased_yn\" id=\"deceased_yn\"  value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n\t</td>\n\t</tr>\n\t<tr>\n\t<td class=\"label\">\n\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t</td>\n\t<td class=\'fields\'>\n\t\t<input type=text name=\"deceased_date\" id=\"deceased_date\" id=\"deceased_date\"  value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' size=25 disabled>\n\t</td>\n\t</tr>\n</table>\n\n<!-- Hidden fields used in dlainterface.js - getAccept function for returning the values back to MP pages-->\n\n<INPUT TYPE=\"hidden\" name=\"mode\" id=\"mode\" VALUE=\"\">\n<INPUT TYPE=\"hidden\" name=\"flag\" id=\"flag\" VALUE=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n<input type=\'hidden\' name=\'address_1\' id=\'address_1\' value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n<input type=\'hidden\' name=\'address_2\' id=\'address_2\' value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n<input type=\'hidden\' name=\'address_3\' id=\'address_3\' value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n<input type=\'hidden\' name=\'address_4\' id=\'address_4\' value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n\n<input type=\'hidden\' name=\'national_id_name\' id=\'national_id_name\' value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n<input type=\'hidden\' name=\'user_name\' id=\'user_name\' value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n<input type=\'hidden\' name=\'pass_word\' id=\'pass_word\' value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n<input type=\'hidden\' name=\'serach_mode\' id=\'serach_mode\' value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n<input type=\'hidden\' name=\'first_name\' id=\'first_name\' value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n<input type=\'hidden\' name=\'sur_name1\' id=\'sur_name1\' value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n<input type=\'hidden\' name=\'dla_usr_name\' id=\'dla_usr_name\' value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n<input type=\'hidden\' name=\'dla_usr_pswd\' id=\'dla_usr_pswd\' value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\t\n<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\t\n<input type=\'hidden\' name=\'dla_town\' id=\'dla_town\' value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n<input type=\'hidden\' name=\'dla_area\' id=\'dla_area\' value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\n<input type=\'hidden\' name=\'dla_region\' id=\'dla_region\' value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n\n<input type=\'hidden\' name=\'dla_town_code\' id=\'dla_town_code\' value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">\n<input type=\'hidden\' name=\'dla_area_code\' id=\'dla_area_code\' value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\n<input type=\'hidden\' name=\'dla_region_code\' id=\'dla_region_code\' value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n\n<input type=\'hidden\' name=\'ret_title_eng\' id=\'ret_title_eng\' value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n<input type=\'hidden\' name=\'ret_title_thai\' id=\'ret_title_thai\' value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n<input type=\'hidden\' name=\'nat_code\' id=\'nat_code\' value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\n<input type=\'hidden\' name=\'gender\' id=\'gender\' value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n<input type=\'hidden\' name=\'estDOB\' id=\'estDOB\' value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\n\n";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\n</form>\n\n</body>\n</html>\n\n\n";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
String locale = ((String)session.getAttribute("LOCALE"));	

            _bw.write(_wl_block5Bytes, _wl_block5);

String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String function_id = (String)session.getAttribute("dla_function_id");

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);


String national_id = (String)request.getParameter("national_id"); if(national_id == null) national_id = "";
String user_name = "";
String pass_word = "";
String first_name = "";
String serach_mode = "";
String sur_name = "";
String dob = "";
String nationality = "";
String nationality_code = "";
String fathername = "";
String mothername = "";
String address = "";
String gender = "";
String usr_title = "";
String deceased_yn = "";
String deceased_date = "";
String loc_code = "";
String loc_desc = "";
String address_1 = "";
String address_2 = "";
String address_3 = "";
String address_4 = "";
String dla_town = "";
String dla_area = "";
String dla_region = "";
String ret_title_eng = "";
String ret_title_thai = "";
String gender_disp = "";
String deceased_yn_disp = "Y";
String middleName = "";
String estDOB = "N";
String tempDOB = "";

String dla_area_code = "";
String dla_region_code = "";
String dla_town_code = "";

//String tempYear = "";
//String tempDeceasedDate = "";

int age = 0;
//int deceasedAge = 0;

String query = "";
String dateFormat = "";
//String dispDateFormat = "dd/MM/yyyy";
//String ageCalDateFormat = "dd-MM-yyyy";
//String procDateFormat = "yyyy-MM-dd";
//String ageCal = "";
String patient_id = "";
String dispDOB = ""; // Display variable for DOB, used only for display purpose
String dispDecDate = ""; // Display variable for deceased date, used only for display purpose

String currentDate = "";
String currentMonth = "";

boolean isWrongDecDateFormat = false;
boolean isWrongDOBFormat = false;

Connection sqlServerCon = null; 
PreparedStatement pstmt = null;
ResultSet rs = null;
CallableStatement  call = null;

try
{
	// Getting current date & month. Used incase of unknown date (yyyy0000 format)
	GregorianCalendar gregorianCal = new GregorianCalendar();
	currentDate = "" + gregorianCal.get(Calendar.DAY_OF_MONTH);	
	currentMonth = "" + (gregorianCal.get(Calendar.MONTH)+1);
	if(Integer.parseInt(currentDate) < 10) currentDate = "0" + currentDate;
	if(Integer.parseInt(currentMonth) < 10) currentMonth = "0" + currentMonth;

	String today_datetime1 = (String)session.getAttribute("today_datetime");	
	String dla_machine_name1 = (String)session.getAttribute("dla_machine_name");
	
	sqlServerCon = DLAInterfaceUtil.getConnection("DLAP");
	dateFormat = "yyyyMMdd";

	query = DLAInterfaceUtil.getSqlDBQueryByNationalID();

	pstmt = sqlServerCon.prepareStatement(query);
	pstmt.setString(1,dla_machine_name1 + "/" + today_datetime1);
	pstmt.setString(2,national_id);
	rs = pstmt.executeQuery();
	
	if(rs.next())
	{
		first_name = DLAInterfaceUtil.checkForNull(rs.getString(2));		
		sur_name = DLAInterfaceUtil.checkForNull(rs.getString(3));
		middleName = DLAInterfaceUtil.checkForNull(rs.getString(21));
		dob = DLAInterfaceUtil.checkForNull(rs.getString(4));	
		nationality = DLAInterfaceUtil.checkForNull(rs.getString(6));
		nationality_code = DLAInterfaceUtil.checkForNull(rs.getString(5));
		fathername = DLAInterfaceUtil.checkForNull(rs.getString(7));
		mothername = DLAInterfaceUtil.checkForNull(rs.getString(8));		
		address = DLAInterfaceUtil.checkForNull(rs.getString(16));
		gender = DLAInterfaceUtil.checkForNull(rs.getString(10));
		usr_title = DLAInterfaceUtil.checkForNull(rs.getString(13));
		deceased_yn = DLAInterfaceUtil.checkForNull(rs.getString(11));		
		deceased_date = DLAInterfaceUtil.checkForNull(rs.getString(12));
		loc_code = DLAInterfaceUtil.checkForNull(rs.getString(14));
		loc_code = loc_code.trim();
	//	loc_desc = DLAInterfaceUtil.checkForNull(rs.getString(15));
		address_1 = DLAInterfaceUtil.checkForNull(rs.getString(16));
		address_2 = DLAInterfaceUtil.checkForNull(rs.getString(17));
		address_3 = DLAInterfaceUtil.checkForNull(rs.getString(18));
		address_4 = DLAInterfaceUtil.checkForNull(rs.getString(19));

		if(address_1.length() > 30) address_1 = address_1.substring(0,30);
		if(address_2.length() > 30)	address_2 = address_2.substring(0,30);
		if(address_3.length() > 30)	address_3 = address_3.substring(0,30);
		if(address_4.length() > 30)	address_4 = address_4.substring(0,30);		

		gender_disp = DLAInterfaceUtil.checkForNull(rs.getString(20));
		ret_title_thai = usr_title;
			
		if(rs != null) rs.close(); 
		if(pstmt != null) pstmt.close();		

	/*	if(dob != null)
		{
			int dobLength = dob.length();
			if(dobLength != 8)
			{
				for (int i = 0; i < (8 - dobLength); i++)
				{
					dob = "0" + dob;
				}
			}
		}
	*/	
		if(dob != null && dob.length() == 8)
		{			
			// If Date & Month are 0000, then replacing with 0101
			if( "00".equals( dob.substring(6) ) ) 
			{
				dob = dob.substring(0,6) + "01";
				estDOB = "Y";
			}
			if( "00".equals( dob.substring(4,6) ) ) 
			{
				dob = dob.substring(0,4) + "01" + dob.substring(6);
				estDOB = "Y";
			}			

			if("0000".equals(dob.substring(0,4))) 
			{
				isWrongDOBFormat = true;
				dispDOB = dob.substring(6,8) + "/" + 
								dob.substring(4,6) + "/0000";
			}
			else
			{
				tempDOB = dob.substring(6,8) + "/" + 
											dob.substring(4,6) + "/" +
											dob.substring(0,4);
				if("th".equalsIgnoreCase(locale))
				{
					dispDOB = tempDOB;
				}
				else
				{
					dispDOB = dob.substring(6,8) + "/" + 
								dob.substring(4,6) + "/" +
								(Integer.parseInt(dob.substring(0,4)) - 543);
				}
				
				isWrongDOBFormat = !(DateUtils.validDate(tempDOB,"DMY","th"));
				isWrongDOBFormat = DateUtils.isAfterNow(tempDOB,"DMY","th");
			}
		}
		else
		{
			dispDOB = dob;
			isWrongDOBFormat = true;
		}

		if("Y".equalsIgnoreCase(deceased_yn))
		{			
		/*	if(deceased_date != null)
			{
				int deceasedDateLength = deceased_date.length();
				if(deceasedDateLength != 8)
				{
					for (int i = 0; i < (8 - deceasedDateLength); i++)
					{
						deceased_date = "0" + deceased_date;
					}
				}
			}
		*/	if(deceased_date != null && !deceased_date.equals("0") && deceased_date.length() == 8)
			{
				if("0000".equals(deceased_date.substring(0,4))) 
				{
					isWrongDecDateFormat = true;
					dispDecDate = deceased_date.substring(6,8) + "/" + 
										deceased_date.substring(4,6) + "/0000";
				}
				else
				{
					String tempDecDate = deceased_date.substring(6,8) + "/" + 
											deceased_date.substring(4,6) + "/" +
											deceased_date.substring(0,4);
					if("th".equalsIgnoreCase(locale))
					{
						dispDecDate = tempDecDate;
					}
					else
					{
						dispDecDate = deceased_date.substring(6,8) + "/" + 
										deceased_date.substring(4,6) + "/" +
										(Integer.parseInt(deceased_date.substring(0,4)) - 543);
					}
					
					isWrongDecDateFormat = !(DateUtils.validDate(tempDecDate,"DMY","th"));
					isWrongDecDateFormat = DateUtils.isAfterNow(tempDecDate,"DMY","th");					
					if(!isWrongDOBFormat) isWrongDecDateFormat = DateUtils.isBefore(tempDecDate,tempDOB,"DMY","th");
				}
			}
			else
			{
				dispDecDate = deceased_date;
				isWrongDecDateFormat = true;
			}
		}		

		if(isWrongDOBFormat || isWrongDecDateFormat)
		{
			String errMsg = "";
			java.util.Locale loc = new java.util.Locale(locale);
			java.util.ResourceBundle labels = java.util.ResourceBundle.getBundle( "eMP.resources.Messages",loc);			

			if(isWrongDOBFormat)
			{
				errMsg = labels.getString("INVALID_DOB");
				if(errMsg == null || "".equals(errMsg))
				{
					errMsg = "Invalid Date of Birth, Do You Want To Continue?";
				}
			}
			else
			{
				errMsg = labels.getString("INVALID_DESEASED_DATE");
				if(errMsg == null || "".equals(errMsg))
				{
					errMsg = "Invalid Deceased Date, Do You Want To Continue?";
				}
			}
			
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf( errMsg ));
            _bw.write(_wl_block9Bytes, _wl_block9);

		}
		else
		{
			String gregDOB = DLAInterfaceUtil.convert_to_greg_date_2t(dob,"th","yyyymmdd");			

			if("Y".equalsIgnoreCase(deceased_yn))
			{			
				String gregDeceasedDate = DLAInterfaceUtil.convert_to_greg_date_2t(deceased_date,"th","yyyymmdd");
										
				age = DateUtils.yearsBetween(
							DLAInterfaceUtil.convertStringDateFormats(gregDOB,"yyyy-MM-dd","dd/MM/yyyy"),
							DLAInterfaceUtil.convertStringDateFormats(gregDeceasedDate,"yyyy-MM-dd","dd/MM/yyyy"),
							"DMY","en");
			}
			else
			{
				age = DateUtils.yearsBetween(
							DLAInterfaceUtil.convertStringDateFormats(gregDOB,"yyyy-MM-dd","dd/MM/yyyy"),
							DateUtils.getCurrentDate("DMY","en"),
							"DMY","en");
			}				
		}
						
		// Retrieving the descriptions for the corresponding codes for patient(SQL Server)		
		nationality = DLAInterfaceUtil.getDescFromCode("SELECT long_desc FROM mp_country_lang_vw WHERE country_code='"+nationality_code+"' AND language_id='"+locale+"'");
		if(nationality == null || nationality.equalsIgnoreCase(""))
		{
			nationality_code = "UP";
			nationality = DLAInterfaceUtil.getDescFromCode("SELECT long_desc FROM mp_country_lang_vw WHERE country_code='UP' AND language_id='"+locale+"'");
		}
		ret_title_eng = DLAInterfaceUtil.getDescFromCode("SELECT name_prefix FROM mp_name_prefix WHERE name_prefix_loc_lang='"+usr_title+"'");		
		
		dla_town = DLAInterfaceUtil.getDescFromCode("SELECT long_desc FROM mp_res_town_lang_vw WHERE res_town_code='"+loc_code+"' AND language_id='"+locale+"'");
		if(loc_code.length() >= 4) 
		{
			dla_area = DLAInterfaceUtil.getDescFromCode("SELECT long_desc FROM mp_res_area_lang_vw WHERE res_area_code='"+loc_code.substring(0,4)+"' AND language_id='"+locale+"'");			
		}
		if(loc_code.length() >= 2)
		{
			dla_region = DLAInterfaceUtil.getDescFromCode("SELECT long_desc FROM mp_region_lang_vw WHERE region_code='"+loc_code.substring(0,2)+"' AND language_id='"+locale+"'");			
		}

		if(dla_town != null && !dla_town.equalsIgnoreCase("")) 
		{
			loc_desc = dla_town;
			dla_town_code = loc_code;
		}
		if(dla_area != null && !dla_area.equalsIgnoreCase(""))
		{
			loc_desc = loc_desc+" "+dla_area;
			dla_area_code = loc_code.substring(0,4);
		}
		if(dla_region != null && !dla_region.equalsIgnoreCase(""))
		{
			loc_desc = loc_desc+" "+dla_region;
			dla_region_code = loc_code.substring(0,2);
		}

		if(address_1 != null)
			address = address_1;
		if(address_2 != null)
			address = address+" "+address_2;
		if(address_3 != null)
			address = address+" "+address_3;
		if(address_4 != null)
			address = address+" "+address_4;

		if(!deceased_yn.equalsIgnoreCase("Y"))	
		{
			deceased_yn = "N";
			deceased_yn_disp = "";
		}
		

		String new_req = (String)session.getAttribute("new_req");

		if(new_req != null && new_req.equalsIgnoreCase("Y"))
		{												 
			String today_datetime = (String)session.getAttribute("today_datetime");
			String req_search = (String)session.getAttribute("req_search");
			String dla_machine_name = (String)session.getAttribute("dla_machine_name");

			DLAInterfaceUtil.updatePurgeStatus(today_datetime,dla_machine_name,req_search);
			session.removeAttribute("new_req");
		}
	


            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf( DLAInterfaceUtil.getLabelPrompt(locale,"FirstName") ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(usr_title));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(first_name));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf( DLAInterfaceUtil.getMiddleNamePrompt(locale) ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(middleName));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf( DLAInterfaceUtil.getLabelPrompt(locale,"FamilyName") ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(sur_name));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(dispDOB));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(age));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(gender_disp));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(nationality_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(nationality));
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(national_id));
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(address));
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(loc_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(loc_desc));
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(fathername));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(mothername));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(deceased_yn_disp));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(deceased_yn));
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(dispDecDate));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf( request.getParameter("mode")));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(address_1));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(address_2));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(address_3));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(address_4));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(national_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(user_name));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(pass_word));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(serach_mode));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(first_name));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(sur_name));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(user_name));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(pass_word));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(dla_town));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(dla_area));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(dla_region));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(dla_town_code));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(dla_area_code));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(dla_region_code));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(ret_title_eng));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(ret_title_thai));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(nationality_code));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(estDOB));
            _bw.write(_wl_block72Bytes, _wl_block72);

	}
}
catch(Exception exp)
{
	exp.printStackTrace(System.err);
}
finally
{	
	try
	{
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();							
		if(call != null) call.close();		
		DLAInterfaceUtil.closeConnection(sqlServerCon);
	}
	catch(Exception exp)
	{
		exp.printStackTrace(System.err);
	}
}

            _bw.write(_wl_block73Bytes, _wl_block73);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.searchresult.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DateofBirth.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.age.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Years.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nationality.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.CitizenId.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Address.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag7);
            return true;
        }
        _activeTag=__tag7.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
        __tag7.release();
        return false;
    }

    private boolean _jsp__tag8(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag8 = null ;
        int __result__tag8 = 0 ;

        if (__tag8 == null ){
            __tag8 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
        }
        __tag8.setPageContext(pageContext);
        __tag8.setParent(null);
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.locationcode.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag8;
        __result__tag8 = __tag8.doStartTag();

        if (__result__tag8!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag8== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag8.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag8);
            return true;
        }
        _activeTag=__tag8.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag8);
        __tag8.release();
        return false;
    }

    private boolean _jsp__tag9(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag9 = null ;
        int __result__tag9 = 0 ;

        if (__tag9 == null ){
            __tag9 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag9);
        }
        __tag9.setPageContext(pageContext);
        __tag9.setParent(null);
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Tumbon.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag9;
        __result__tag9 = __tag9.doStartTag();

        if (__result__tag9!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag9== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag9.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag9);
            return true;
        }
        _activeTag=__tag9.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag9);
        __tag9.release();
        return false;
    }

    private boolean _jsp__tag10(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag10 = null ;
        int __result__tag10 = 0 ;

        if (__tag10 == null ){
            __tag10 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag10);
        }
        __tag10.setPageContext(pageContext);
        __tag10.setParent(null);
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.District.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag10;
        __result__tag10 = __tag10.doStartTag();

        if (__result__tag10!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag10== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag10.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag10);
            return true;
        }
        _activeTag=__tag10.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag10);
        __tag10.release();
        return false;
    }

    private boolean _jsp__tag11(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag11 = null ;
        int __result__tag11 = 0 ;

        if (__tag11 == null ){
            __tag11 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag11);
        }
        __tag11.setPageContext(pageContext);
        __tag11.setParent(null);
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Province.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag11;
        __result__tag11 = __tag11.doStartTag();

        if (__result__tag11!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag11== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag11.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag11);
            return true;
        }
        _activeTag=__tag11.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag11);
        __tag11.release();
        return false;
    }

    private boolean _jsp__tag12(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag12 = null ;
        int __result__tag12 = 0 ;

        if (__tag12 == null ){
            __tag12 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag12);
        }
        __tag12.setPageContext(pageContext);
        __tag12.setParent(null);
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Father.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag12;
        __result__tag12 = __tag12.doStartTag();

        if (__result__tag12!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag12== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag12.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag12);
            return true;
        }
        _activeTag=__tag12.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag12);
        __tag12.release();
        return false;
    }

    private boolean _jsp__tag13(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag13 = null ;
        int __result__tag13 = 0 ;

        if (__tag13 == null ){
            __tag13 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag13);
        }
        __tag13.setPageContext(pageContext);
        __tag13.setParent(null);
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Mother.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag13;
        __result__tag13 = __tag13.doStartTag();

        if (__result__tag13!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag13== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag13.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag13);
            return true;
        }
        _activeTag=__tag13.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag13);
        __tag13.release();
        return false;
    }

    private boolean _jsp__tag14(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag14 = null ;
        int __result__tag14 = 0 ;

        if (__tag14 == null ){
            __tag14 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag14);
        }
        __tag14.setPageContext(pageContext);
        __tag14.setParent(null);
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.DeceasedStatus.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag14;
        __result__tag14 = __tag14.doStartTag();

        if (__result__tag14!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag14== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag14.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag14);
            return true;
        }
        _activeTag=__tag14.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag14);
        __tag14.release();
        return false;
    }

    private boolean _jsp__tag15(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag15 = null ;
        int __result__tag15 = 0 ;

        if (__tag15 == null ){
            __tag15 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag15);
        }
        __tag15.setPageContext(pageContext);
        __tag15.setParent(null);
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DeceasedDate.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag15;
        __result__tag15 = __tag15.doStartTag();

        if (__result__tag15!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag15== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag15.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag15);
            return true;
        }
        _activeTag=__tag15.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag15);
        __tag15.release();
        return false;
    }
}
