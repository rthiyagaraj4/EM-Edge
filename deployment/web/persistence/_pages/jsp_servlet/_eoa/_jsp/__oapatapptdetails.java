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
import webbeans.eCommon.*;
import com.ehis.util.*;
import eCommon.XSSRequestWrapper;

public final class __oapatapptdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/OAPatApptDetails.jsp", 1709119246740L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="   \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<html>\n<head>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<Script src=\"../../eOA/js/Validate.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\n</script>\n</head>\n<body  OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\' >\n<form name =\"ppp\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<table  border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' >\n\t\t\t<tr>\n\t\t\t<td class=\'CAHIGHERLEVELCOLOR\' align = \'center\' colspan=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t<td class=\'CAGROUP\' nowrap></td>\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t<td class=\'CAGROUP\' nowrap>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\t\n\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\t\t\t\n\t\t\t\t<td class=\'CAGROUP\' nowrap>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\t\t\n\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t<td class=\'CAGROUP\' nowrap>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\t\t\t\n\t\t\t<td class=\'CAGROUP\' nowrap>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\t\t\t\n\t\t\t<td class=\'CAGROUP\' nowrap>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\t\t\t\n\t\t\t</tr>\t\t\n\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t<tr id=\'Summary_row";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n\t\t\t\t<td nowrap><a href=\'javascript:ShowSummary(\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\",\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\")\' id=\"plus\">+</a></td>\n\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t<td nowrap id=\'name_prefix";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>&nbsp;";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\t\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t<td nowrap id=\'first_name";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' >&nbsp;";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t<td nowrap id=\'second_name";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\t\t\t\n\t\t\t\t<td nowrap id=\'third_name";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t<td nowrap id=\'family_name";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t<td nowrap id=\'name_suffix";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t<td nowrap id=\'name_prefix_oth_lang";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t<td nowrap id=\'first_name_oth_lang";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t<td nowrap id=\'second_name_oth_lang";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t<td nowrap id=\'third_name_oth_lang";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t<td nowrap id=\'name_suffix_oth_lang";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\t\t\t\n\t\t\t\t<td nowrap>&nbsp;";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</td>\n\t\t\t\t<td nowrap>&nbsp;";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</td>\t\t\t\t\n\t\t\t</tr>\n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t</table>\t\t\n\t<script>\t\t\t\n\t\tif(\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' == 1){\t\t\t\n\t\t\t\tdocument.getElementById(\"plus\").style.visibility=\'hidden\';\n\t\t\t\tparent.frames[1].location.href=\"../../eOA/jsp/OAPatApptSummary.jsp?name_prefix=";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="&first_name=";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="&second_name=";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="&third_name=";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="&family_name=";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="&name_suffix=";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="&name_prefix_oth_lang=";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="&first_name_oth_lang=";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="&second_name_oth_lang=";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="&third_name_oth_lang=";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="&family_name_oth_lang=";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="&name_suffix_oth_lang=";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="&patient_name=";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="&gender=";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="&contact_no=";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="&per_chk_cancld_past_appts=";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="&per_chk_cancld_fut_appts=";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="&per_chk_past_resch_appts=";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="&per_chk_fut_resch_appts=";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="&no_of_cancld_appts_for_alert=";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="&no_of_resch_appts_for_alert=";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="&Per_chk_for_no_show_alert=";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="&no_of_noshow_appts_for_alert=";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="&per_chk_for_fut_appts_alert=";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="&no_of_fut_appts_for_alert=";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\";\n\n\t\t\t}\n\t</script>\n\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t<input type=\"hidden\" name=\'name_prefix\' id=\'name_prefix\' value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">\n\t\t<input type=\"hidden\" name=\'no_of_fut_appts_for_alert\' id=\'no_of_fut_appts_for_alert\' value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\">\n\t\t<input type=\"hidden\" name=\'per_chk_for_fut_appts_alert\' id=\'per_chk_for_fut_appts_alert\' value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\">\n\t\t<input type=\"hidden\" name=\'no_of_resch_appts_for_alert\' id=\'no_of_resch_appts_for_alert\' value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\">\n\t\t<input type=\"hidden\" name=\'per_chk_past_resch_appts\' id=\'per_chk_past_resch_appts\' value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\n\t\t<input type=\"hidden\" name=\'per_chk_fut_resch_appts\' id=\'per_chk_fut_resch_appts\' value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\">\n\t\t<input type=\"hidden\" name=\'no_of_cancld_appts_for_alert\' id=\'no_of_cancld_appts_for_alert\' value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\">\n\t\t<input type=\"hidden\" name=\'per_chk_cancld_past_appts\' id=\'per_chk_cancld_past_appts\' value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\">\n\t\t<input type=\"hidden\" name=\'per_chk_cancld_fut_appts\' id=\'per_chk_cancld_fut_appts\' value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\">\n\t\t<input type=\"hidden\" name=\'no_of_noshow_appts_for_alert\' id=\'no_of_noshow_appts_for_alert\' value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\">\t\t\n\t\t<input type=\"hidden\" name=\'per_chk_for_no_show_alert\' id=\'per_chk_for_no_show_alert\' value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\">\n\t\t<input type=\"hidden\" name=\'max_no_of_records\' id=\'max_no_of_records\' value=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\">\n\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

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
            _bw.write(_wl_block5Bytes, _wl_block5);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");	
		String patient_id=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");		
		String locale=(String)session.getAttribute("LOCALE");
		String fac_id=(String) session.getValue( "facility_id");
		String name_prefix=request.getParameter("name_prefix")==null?"":request.getParameter("name_prefix");
		String first_name=request.getParameter("first_name")==null?"":request.getParameter("first_name");	
		String second_name=request.getParameter("second_name")==null?"":request.getParameter("second_name");
		String third_name=request.getParameter("third_name")==null?"":request.getParameter("third_name");
		String family_name=request.getParameter("family_name")==null?"":request.getParameter("family_name");
		String name_suffix=request.getParameter("name_suffix")==null?"":request.getParameter("name_suffix");
		String name_prefix_oth_lang=request.getParameter("name_prefix_oth_lang")==null?"":request.getParameter("name_prefix_oth_lang");
		String first_name_oth_lang=request.getParameter("first_name_oth_lang")==null?"":request.getParameter("first_name_oth_lang");	
		String second_name_oth_lang=request.getParameter("second_name_oth_lang")==null?"":request.getParameter("second_name_oth_lang");
		String third_name_oth_lang=request.getParameter("third_name_oth_lang")==null?"":request.getParameter("third_name_oth_lang");
		String family_name_oth_lang=request.getParameter("family_name_oth_lang")==null?"":request.getParameter("family_name_oth_lang");
		String name_suffix_oth_lang=request.getParameter("name_suffix_oth_lang")==null?"":request.getParameter("name_suffix_oth_lang");
		String gender=request.getParameter("gender")==null?"":request.getParameter("gender");
		String contact_no=request.getParameter("contact_no")==null?"":request.getParameter("contact_no");
		String nationality=request.getParameter("nationality")==null?"":request.getParameter("nationality");
		String language=request.getParameter("language")==null?"":request.getParameter("language");
		StringBuffer whereClause = new StringBuffer("");
		String sql="";		
		String classValue = "";
		String drvdname="";
		String prev_drvdname="";
		String patient_name = "";
		int t=0;
		int no_of_records=0;		
		Connection con = null;
		PreparedStatement ps=null ;
		ResultSet rset=null;
		/*System.out.println("name_prefix :"+name_prefix);
		System.out.println("first_name :"+first_name);
		System.out.println("second_name :"+second_name);
		System.out.println("third_name :"+third_name);
		System.out.println("family_name :"+family_name);
		System.out.println("name_suffix :"+name_suffix);
		System.out.println("name_prefix_oth_lang :"+name_prefix_oth_lang);
		System.out.println("first_name_oth_lang :"+first_name_oth_lang);
		System.out.println("second_name_oth_lang :"+second_name_oth_lang);
		System.out.println("third_name_oth_lang :"+third_name_oth_lang);
		System.out.println("family_name_oth_lang :"+family_name_oth_lang);
		System.out.println("name_suffix_oth_lang :"+name_suffix_oth_lang);*/
		
		int no_of_fut_appts_for_alert=Integer.parseInt(request.getParameter("no_of_fut_appts_for_alert")==null?"0":request.getParameter("no_of_fut_appts_for_alert"));
		int per_chk_for_fut_appts_alert=Integer.parseInt(request.getParameter("per_chk_for_fut_appts_alert")==null?"0":request.getParameter("per_chk_for_fut_appts_alert"));
		int no_of_resch_appts_for_alert=Integer.parseInt(request.getParameter("no_of_resch_appts_for_alert")==null?"0":request.getParameter("no_of_resch_appts_for_alert"));
		int per_chk_past_resch_appts=Integer.parseInt(request.getParameter("per_chk_past_resch_appts")==null?"0":request.getParameter("per_chk_past_resch_appts"));
		int per_chk_fut_resch_appts=Integer.parseInt(request.getParameter("per_chk_fut_resch_appts")==null?"0":request.getParameter("per_chk_fut_resch_appts"));
		int no_of_cancld_appts_for_alert=Integer.parseInt(request.getParameter("no_of_cancld_appts_for_alert")==null?"0":request.getParameter("no_of_cancld_appts_for_alert"));
		int per_chk_cancld_past_appts=Integer.parseInt(request.getParameter("per_chk_cancld_past_appts")==null?"0":request.getParameter("per_chk_cancld_past_appts"));
		int per_chk_cancld_fut_appts=Integer.parseInt(request.getParameter("per_chk_cancld_fut_appts")==null?"0":request.getParameter("per_chk_cancld_fut_appts"));		
		int no_of_noshow_appts_for_alert=Integer.parseInt(request.getParameter("no_of_noshow_appts_for_alert")==null?"0":request.getParameter("no_of_noshow_appts_for_alert"));
		int per_chk_for_no_show_alert=Integer.parseInt(request.getParameter("per_chk_for_no_show_alert")==null?"0":request.getParameter("per_chk_for_no_show_alert"));
		
		
		
		String name_prefix_prompt="";
		String first_name_prompt="";
		String second_name_prompt="";
		String third_name_prompt="";
		String family_name_prompt="";
		String name_suffix_prompt="";
		String name_prefix_accept_yn="";
		String first_name_accept_yn="";
		String second_name_accept_yn="";
		String third_name_accept_yn="";
		String family_name_accept_yn="";
		String name_suffix_accept_yn="";		
		String pat_name_as_multipart_yn="";
		String names_in_oth_lang_yn="";
		String name_prefix_oth_lang_prompt="";
		String first_name_oth_lang_prompt="";
		String second_name_oth_lang_prompt="";
		String third_name_oth_lang_prompt="";
		String family_name_oth_lang_prompt="";
		String name_suffix_oth_lang_prompt="";
		int count=3;
		

		try
		{	
			con = ConnectionManager.getConnection(request);
			sql="Select pat_name_as_multipart_yn,NAMES_IN_OTH_LANG_YN,NAME_PREFIX_ACCEPT_YN,NAME_PREFIX_PROMPT,FIRST_NAME_ACCEPT_YN, FIRST_NAME_PROMPT,SECOND_NAME_ACCEPT_YN, SECOND_NAME_PROMPT,THIRD_NAME_ACCEPT_YN, THIRD_NAME_PROMPT,FAMILY_NAME_ACCEPT_YN,FAMILY_NAME_PROMPT,name_suffix_accept_yn,NAME_SUFFIX_PROMPT,NAME_PREFIX_LOC_LANG_PROMPT,FIRST_NAME_LOC_LANG_PROMPT,SECOND_NAME_LOC_LANG_PROMPT,THIRD_NAME_LOC_LANG_PROMPT,FAMILY_NAME_LOC_LANG_PROMPT,NAME_SUFFIX_LOC_LANG_PROMPT from mp_param where module_id='MP'";
			ps = con.prepareStatement(sql);
			rset=ps.executeQuery();	
			if(rset!=null && rset.next()){
				pat_name_as_multipart_yn=rset.getString("pat_name_as_multipart_yn")==null?"":rset.getString("pat_name_as_multipart_yn");
				names_in_oth_lang_yn=rset.getString("NAMES_IN_OTH_LANG_YN")==null?"":rset.getString("NAMES_IN_OTH_LANG_YN");
				name_prefix_prompt=rset.getString("name_prefix_prompt")==null?"":rset.getString("name_prefix_prompt");
				first_name_prompt=rset.getString("FIRST_NAME_PROMPT")==null?"":rset.getString("FIRST_NAME_PROMPT");
				second_name_prompt=rset.getString("SECOND_NAME_PROMPT")==null?"":rset.getString("SECOND_NAME_PROMPT");
				third_name_prompt=rset.getString("THIRD_NAME_PROMPT")==null?"":rset.getString("THIRD_NAME_PROMPT");
				family_name_prompt=rset.getString("FAMILY_NAME_PROMPT")==null?"":rset.getString("FAMILY_NAME_PROMPT");
				name_suffix_prompt=rset.getString("NAME_SUFFIX_PROMPT")==null?"":rset.getString("NAME_SUFFIX_PROMPT");
				name_prefix_accept_yn=rset.getString("NAME_PREFIX_ACCEPT_YN")==null?"":rset.getString("NAME_PREFIX_ACCEPT_YN");
				first_name_accept_yn=rset.getString("FIRST_NAME_ACCEPT_YN")==null?"":rset.getString("FIRST_NAME_ACCEPT_YN");
				second_name_accept_yn=rset.getString("SECOND_NAME_ACCEPT_YN")==null?"":rset.getString("SECOND_NAME_ACCEPT_YN");
				third_name_accept_yn=rset.getString("THIRD_NAME_ACCEPT_YN")==null?"":rset.getString("THIRD_NAME_ACCEPT_YN");
				family_name_accept_yn=rset.getString("FAMILY_NAME_ACCEPT_YN")==null?"":rset.getString("FAMILY_NAME_ACCEPT_YN");
				name_suffix_accept_yn=rset.getString("name_suffix_accept_yn")==null?"":rset.getString("name_suffix_accept_yn");
				name_prefix_oth_lang_prompt=rset.getString("NAME_PREFIX_LOC_LANG_PROMPT")==null?"":rset.getString("NAME_PREFIX_LOC_LANG_PROMPT");
				first_name_oth_lang_prompt=rset.getString("FIRST_NAME_LOC_LANG_PROMPT")==null?"":rset.getString("FIRST_NAME_LOC_LANG_PROMPT");
				second_name_oth_lang_prompt=rset.getString("SECOND_NAME_LOC_LANG_PROMPT")==null?"":rset.getString("SECOND_NAME_LOC_LANG_PROMPT");
				third_name_oth_lang_prompt=rset.getString("THIRD_NAME_LOC_LANG_PROMPT")==null?"":rset.getString("THIRD_NAME_LOC_LANG_PROMPT");
				family_name_oth_lang_prompt=rset.getString("FAMILY_NAME_LOC_LANG_PROMPT")==null?"":rset.getString("FAMILY_NAME_LOC_LANG_PROMPT");
				name_suffix_oth_lang_prompt=rset.getString("NAME_SUFFIX_LOC_LANG_PROMPT")==null?"":rset.getString("NAME_SUFFIX_LOC_LANG_PROMPT");
				if(name_prefix_accept_yn.equals("Y"))
					count++;
				if(pat_name_as_multipart_yn.equals("Y") && first_name_accept_yn.equals("Y"))
					count++;
				if(pat_name_as_multipart_yn.equals("Y") && second_name_accept_yn.equals("Y"))
					count++;
				if(pat_name_as_multipart_yn.equals("Y") && third_name_accept_yn.equals("Y"))
					count++;
				if(pat_name_as_multipart_yn.equals("Y") && family_name_accept_yn.equals("Y"))
					count++;
				if(pat_name_as_multipart_yn.equals("N"))
					count++;
				if(name_suffix_accept_yn.equals("Y"))
					count++;					
				if(names_in_oth_lang_yn.equals("Y")){
					if(name_prefix_accept_yn.equals("Y"))
					count++;
					if(pat_name_as_multipart_yn.equals("Y") && first_name_accept_yn.equals("Y"))
						count++;
					if(pat_name_as_multipart_yn.equals("Y") && second_name_accept_yn.equals("Y"))
						count++;
					if(pat_name_as_multipart_yn.equals("Y") && third_name_accept_yn.equals("Y"))
						count++;
					if(pat_name_as_multipart_yn.equals("Y") && family_name_accept_yn.equals("Y"))
						count++;
					if(name_suffix_accept_yn.equals("Y"))
						count++;
				}
			}
			
			
			if(rset!=null)rset.close();
			if (!name_prefix.equals("")){					
						whereClause.append(" and name_prefix =?");					
			}
			if (!first_name.equals("")){					
						whereClause.append(" and upper(first_name) like upper(?)");					
			}
			if (!second_name.equals("")){					
						whereClause.append(" and upper(second_name) like upper(?)");					
			}
			if (!third_name.equals("")){				
						whereClause.append(" and upper(third_name) like upper(?)");						
			}
			if (!family_name.equals("")){					
						whereClause.append(" and upper(family_name) like upper(?)");											
			}
			if (!name_suffix.equals("")){					
						whereClause.append(" and name_suffix =?");					
			}
			
			if(names_in_oth_lang_yn.equals("Y")){
				if (!name_prefix_oth_lang.equals("")){					
					whereClause.append(" and NAME_PREFIX_LOC_LANG =?");					
				}
				if (!first_name_oth_lang.equals("")){					
							whereClause.append(" and upper(FIRST_NAME_LOC_LANG) like upper(?)");					
				}
				if (!second_name_oth_lang.equals("")){					
							whereClause.append(" and upper(SECOND_NAME_LOC_LANG) like upper(?)");					
				}
				if (!third_name_oth_lang.equals("")){				
							whereClause.append(" and upper(THIRD_NAME_LOC_LANG) like upper(?)");						
				}
				if (!family_name_oth_lang.equals("")){					
							whereClause.append(" and upper(FAMILY_NAME_LOC_LANG) like upper(?)");											
				}
				if (!name_suffix_oth_lang.equals("")){					
							whereClause.append(" and NAME_SUFFIX_LOC_LANG =?");					
				}
			}
			if (!contact_no.equals("")){					
						whereClause.append(" and oth_contact_no=?");											
			}
			if(!nationality.equals("")){			
						whereClause.append(" and country_code=?");					
			}

			if(!language.equals("")){				
						whereClause.append(" and language_id=?");		
					
			}
			sql="select appt_ref_no,name_prefix,first_name,second_name,third_name,family_name,NAME_SUFFIX,gender,oth_contact_no,(FIRST_NAME||second_name||Third_name||family_name||gender) drvdname,patient_name,NAME_PREFIX_LOC_LANG,FIRST_NAME_LOC_LANG,SECOND_NAME_LOC_LANG,THIRD_NAME_LOC_LANG,FAMILY_NAME_LOC_LANG,NAME_SUFFIX_LOC_LANG from oa_appt where facility_id=? and gender=?"+whereClause+" order by first_name,second_name,third_name,family_name,gender";
		
			ps = con.prepareStatement(sql);
			int psCount=1;
			ps.setString(psCount++,fac_id);
			ps.setString(psCount++,gender);
			
			if (!name_prefix.equals("")){
				ps.setString(psCount++,name_prefix);
			}
			if (!first_name.equals("")){
				ps.setString(psCount++,first_name+"%");
			}
			if (!second_name.equals("")){
				ps.setString(psCount++,second_name+"%");
			}
			if (!third_name.equals("")){				
				ps.setString(psCount++,third_name+"%");					
			}
			if (!family_name.equals("")){					
				ps.setString(psCount++,family_name+"%");										
			}
			if (!name_suffix.equals("")){					
				ps.setString(psCount++,name_suffix+"%");					
			}
			if(names_in_oth_lang_yn.equals("Y")){
				if (!name_prefix_oth_lang.equals("")){
					ps.setString(psCount++,name_prefix_oth_lang);
				}
				if (!first_name_oth_lang.equals("")){
					ps.setString(psCount++,first_name_oth_lang+"%");
				}
				if (!second_name_oth_lang.equals("")){
					ps.setString(psCount++,second_name_oth_lang+"%");
				}
				if (!third_name_oth_lang.equals("")){				
					ps.setString(psCount++,third_name_oth_lang+"%");					
				}
				if (!family_name_oth_lang.equals("")){					
					ps.setString(psCount++,family_name_oth_lang+"%");										
				}
				if (!name_suffix_oth_lang.equals("")){					
					ps.setString(psCount++,name_suffix_oth_lang+"%");					
				}
			}
			if (!contact_no.equals("")){					
				ps.setString(psCount++,contact_no);											
			}
			if(!nationality.equals("")){			
				ps.setString(psCount++,nationality);				
			}

			if(!language.equals("")){				
				ps.setString(psCount++,language);					
			}
			//System.out.println("sql:"+sql.toString());
			rset=ps.executeQuery();	
			
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(count));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
if(name_prefix_accept_yn.equals("Y")){
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(name_prefix_prompt));
            _bw.write(_wl_block13Bytes, _wl_block13);
}
            _bw.write(_wl_block14Bytes, _wl_block14);
if(first_name_accept_yn.equals("Y")){
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(first_name_prompt));
            _bw.write(_wl_block13Bytes, _wl_block13);
}
            _bw.write(_wl_block14Bytes, _wl_block14);
if(second_name_accept_yn.equals("Y")){
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(second_name_prompt));
            _bw.write(_wl_block15Bytes, _wl_block15);
}
            _bw.write(_wl_block16Bytes, _wl_block16);
if(third_name_accept_yn.equals("Y")){
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(third_name_prompt));
            _bw.write(_wl_block13Bytes, _wl_block13);
}
            _bw.write(_wl_block14Bytes, _wl_block14);
if(family_name_accept_yn.equals("Y")){
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(family_name_prompt));
            _bw.write(_wl_block13Bytes, _wl_block13);
}
            _bw.write(_wl_block14Bytes, _wl_block14);
if(pat_name_as_multipart_yn.equals("N")){
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(family_name_prompt));
            _bw.write(_wl_block13Bytes, _wl_block13);
}
            _bw.write(_wl_block18Bytes, _wl_block18);
if(name_suffix_accept_yn.equals("Y")){
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(name_suffix_prompt));
            _bw.write(_wl_block13Bytes, _wl_block13);
}
            _bw.write(_wl_block14Bytes, _wl_block14);
if(names_in_oth_lang_yn.equals("Y")){
				if(name_prefix_accept_yn.equals("Y")){
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(name_prefix_oth_lang_prompt));
            _bw.write(_wl_block20Bytes, _wl_block20);
}
				if(first_name_accept_yn.equals("Y")){
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(first_name_oth_lang_prompt));
            _bw.write(_wl_block20Bytes, _wl_block20);
}
				if(second_name_oth_lang.equals("Y")){
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(second_name_oth_lang_prompt));
            _bw.write(_wl_block20Bytes, _wl_block20);
}
				if(third_name_oth_lang.equals("Y")){
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(third_name_oth_lang_prompt));
            _bw.write(_wl_block20Bytes, _wl_block20);
}
				if(family_name_oth_lang.equals("Y")){
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(family_name_oth_lang_prompt));
            _bw.write(_wl_block20Bytes, _wl_block20);
}
				if(name_suffix_oth_lang.equals("Y")){
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(name_suffix_oth_lang_prompt));
            _bw.write(_wl_block20Bytes, _wl_block20);
}
			}
			
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

			t = 1;				
			while ( rset.next() )
			{
				if ( t % 2 == 0 )
					classValue = "QRYEVEN" ;
				else
					classValue = "QRYODD" ;
				 patient_name=rset.getString("patient_name") == null ?"" : rset.getString("patient_name");
				 name_prefix=rset.getString("name_prefix") == null ?"" : rset.getString("name_prefix");
				 first_name=rset.getString("first_name") == null ?"" : rset.getString("first_name");
				 second_name=rset.getString("second_name") == null ?"" : rset.getString("second_name");
				 third_name=rset.getString("third_name") == null ?"" : rset.getString("third_name");
				 family_name=rset.getString("family_name") == null ?"" : rset.getString("family_name");		
				 name_suffix=rset.getString("name_suffix") == null ?"" : rset.getString("name_suffix");
				 name_prefix_oth_lang=rset.getString("name_prefix_loc_lang") == null ?"" : rset.getString("name_prefix_loc_lang");
				 first_name_oth_lang=rset.getString("first_name_loc_lang") == null ?"" : rset.getString("first_name_loc_lang");
				 second_name_oth_lang=rset.getString("second_name_loc_lang") == null ?"" : rset.getString("second_name_loc_lang");
				 third_name_oth_lang=rset.getString("third_name_loc_lang") == null ?"" : rset.getString("third_name_loc_lang");
				 family_name_oth_lang=rset.getString("family_name_loc_lang") == null ?"" : rset.getString("family_name_loc_lang");		
				 name_suffix_oth_lang=rset.getString("name_suffix_loc_lang") == null ?"" : rset.getString("name_suffix_loc_lang");
				 gender=rset.getString("gender") == null ?"" : rset.getString("gender");		
				 contact_no=rset.getString("oth_contact_no") == null ?"" : rset.getString("oth_contact_no");		
				 drvdname=rset.getString("drvdname") == null ?"" : rset.getString("drvdname");
				 if(!drvdname.equals(prev_drvdname)){
					no_of_records++;
		
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(no_of_records));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(contact_no));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(java.net.URLEncoder.encode(patient_name)));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(no_of_records));
            _bw.write(_wl_block27Bytes, _wl_block27);
if(name_prefix_accept_yn.equals("Y")){
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(no_of_records));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(name_prefix));
            _bw.write(_wl_block30Bytes, _wl_block30);
}
            _bw.write(_wl_block14Bytes, _wl_block14);
if(first_name_accept_yn.equals("Y")){
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(no_of_records));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(first_name));
            _bw.write(_wl_block33Bytes, _wl_block33);
}
            _bw.write(_wl_block14Bytes, _wl_block14);
if(second_name_accept_yn.equals("Y")){
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(no_of_records));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(second_name));
            _bw.write(_wl_block33Bytes, _wl_block33);
}
            _bw.write(_wl_block16Bytes, _wl_block16);
if(third_name_accept_yn.equals("Y")){
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(no_of_records));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(third_name));
            _bw.write(_wl_block33Bytes, _wl_block33);
}
            _bw.write(_wl_block14Bytes, _wl_block14);
if(family_name_accept_yn.equals("Y")){
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(no_of_records));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(family_name));
            _bw.write(_wl_block33Bytes, _wl_block33);
}
            _bw.write(_wl_block14Bytes, _wl_block14);
if(pat_name_as_multipart_yn.equals("N")){
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(no_of_records));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(family_name));
            _bw.write(_wl_block13Bytes, _wl_block13);
}
            _bw.write(_wl_block14Bytes, _wl_block14);
if(name_suffix_accept_yn.equals("Y")){
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(no_of_records));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(name_suffix));
            _bw.write(_wl_block13Bytes, _wl_block13);
}
            _bw.write(_wl_block14Bytes, _wl_block14);
if(names_in_oth_lang_yn.equals("Y")){
				if(name_prefix_accept_yn.equals("Y")){
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(no_of_records));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(name_prefix_oth_lang));
            _bw.write(_wl_block20Bytes, _wl_block20);
}
				if(first_name_accept_yn.equals("Y")){
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(no_of_records));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(first_name_oth_lang));
            _bw.write(_wl_block20Bytes, _wl_block20);
}
				if(second_name_oth_lang.equals("Y")){
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(no_of_records));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(second_name_oth_lang));
            _bw.write(_wl_block20Bytes, _wl_block20);
}
				if(third_name_oth_lang.equals("Y")){
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(no_of_records));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(third_name_oth_lang));
            _bw.write(_wl_block20Bytes, _wl_block20);
}
				if(family_name_oth_lang.equals("Y")){
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(no_of_records));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(family_name_oth_lang));
            _bw.write(_wl_block20Bytes, _wl_block20);
}
				if(name_suffix_oth_lang.equals("Y")){
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(no_of_records));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(name_suffix_oth_lang));
            _bw.write(_wl_block20Bytes, _wl_block20);
}
			}
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(contact_no));
            _bw.write(_wl_block45Bytes, _wl_block45);
}
		t++;
		prev_drvdname=drvdname;
		}
		if(no_of_records == 0){
			out.println("<script>alert(getMessage('APPT_NOT_EXISTS_FOR_SEL_PAT','OA'));window.close();</script>");
		}
		
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(no_of_records));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(java.net.URLEncoder.encode(name_prefix)));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(java.net.URLEncoder.encode(first_name)));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(java.net.URLEncoder.encode(second_name)));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(java.net.URLEncoder.encode(third_name)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(family_name)));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(java.net.URLEncoder.encode(name_suffix)));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(java.net.URLEncoder.encode(name_prefix_oth_lang)));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(java.net.URLEncoder.encode(first_name_oth_lang)));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(java.net.URLEncoder.encode(second_name_oth_lang)));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(java.net.URLEncoder.encode(third_name_oth_lang)));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(java.net.URLEncoder.encode(family_name_oth_lang)));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(java.net.URLEncoder.encode(name_suffix_oth_lang)));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(java.net.URLEncoder.encode(patient_name)));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(contact_no));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(per_chk_cancld_past_appts));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(per_chk_cancld_fut_appts));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(per_chk_past_resch_appts));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(per_chk_fut_resch_appts));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(no_of_cancld_appts_for_alert));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(no_of_resch_appts_for_alert));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(per_chk_for_no_show_alert));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(no_of_noshow_appts_for_alert));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(per_chk_for_fut_appts_alert));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(no_of_fut_appts_for_alert));
            _bw.write(_wl_block72Bytes, _wl_block72);
}catch(Exception e){
			//out.println(e.toString());
			e.printStackTrace();
		}finally{
			ConnectionManager.returnConnection(con,request);
		}

            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(name_prefix));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(no_of_fut_appts_for_alert));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(per_chk_for_fut_appts_alert));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(no_of_resch_appts_for_alert));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(per_chk_past_resch_appts));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(per_chk_fut_resch_appts));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(no_of_cancld_appts_for_alert));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(per_chk_cancld_past_appts));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(per_chk_cancld_fut_appts));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(no_of_noshow_appts_for_alert));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(per_chk_for_no_show_alert));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(no_of_records));
            _bw.write(_wl_block85Bytes, _wl_block85);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientDetails.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.contactNo.label", java.lang.String .class,"key"));
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
}
