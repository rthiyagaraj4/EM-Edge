package jsp_servlet._eop._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __catalogforclinicresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/CatalogForClinicResult.jsp", 1742273446176L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- /*  Developed By Prabhu.M\n\t\t Date -- 06/07/2004\n\t\t Functionality -- OP/Catalog for Clinic\n*/ -->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n\t<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n\t<script src=\'../../eOP/js/CatalogForClinic.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\n\t\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n\t<form name=\'stat_grp_nation_detail_result_form\' id=\'stat_grp_nation_detail_result_form\' action=\"../../eOP/jsp/CatalogForClinicResult.jsp\" method=\'post\' >\n\t    <table cellspacing=0 cellpadding=0 width=\'100%\' border=1>\n\n\t<TR id=\'alpha\'>\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<TD colspan=\'2\' >\n\t<a href=\"javascript:callMember(\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\')\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</a>&nbsp;&nbsp;\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t&nbsp;&nbsp;</td><td>\n\t\t\t<a href=\"javascript:callMember(\'Others\')\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</a>&nbsp;&nbsp;\n\t\t\t</TD>\n\t\t\t</TR>\n\t</table>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\n\t\t<br>\n\t\t\t<TABLE cellspacing=0 cellpadding=0 border=0 align=\'right\'>\n\t\t\t\t<TR>\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t<TD class=\'class\' id=\'prevval\'>\n\t\t\t\t\t<A  href=\'#\' onclick=\"nextprev(\'prev\')\" >";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</A>&nbsp;&nbsp;\n\t\t\t\t\t</TD>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t<td id=\'nextval\' class=\'class\'>\n\t\t\t\t\t\t<A  href=\'#\' onclick=\"nextprev(\'next\')\" >";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</A>\n\t\t\t\t\t</TD>\n\t\t\t\t</TR>\n\t\t\t</TABLE>\n\t<br><br>\n\n\t\t  <table cellspacing=0 cellpadding=0 width=\'100%\' border=1>\n\t   \t\t<tr>\n\t\t\t\t<td class=\'COLUMNHEADER\' align=\'left\' width=\'70%\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t\t\t<td class=\'COLUMNHEADER\' align=\'center\' width=\'30%\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'><input type=\'hidden\' name=code";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' >";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" </td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' align=\'center\'><input type=\'checkbox\'  name=\'inc";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' id=\'inc";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' onclick = \"remchk(this);\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' align=\'center\'><input type=\'checkbox\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" name=\'inc";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'onclick = \"remchk(this);\">\n\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t <input type =\'hidden\' name =\'visit_type_id\' value =\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'> \n\t\t <input type =\'hidden\' name =\'order_cat_id\' value =\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'> \n\t\t <input type =\'hidden\' name =\'old_param\' value =\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'> \n\t\t <input type =\'hidden\' name =\'alphabet\' value =\' \'>\n\t\t<input type =\'hidden\' name =\'dtl_flag\' value =\' \'>\n\t\t<input type =\'hidden\' name =\'totprvrec\' value =\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n\t\t<input type =\'hidden\' name =\'maxrecord\' value =\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n\t\t<input type=\'hidden\' name=\'remmem\' id=\'remmem\' value=\'R\' >\n\t\t<input type=\'hidden\' name=\'recval\' id=\'recval\' value=\'1\'>\n\t\t<input type =\'hidden\' name =\'from\' value =\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n\t\t<input type =\'hidden\' name =\'to\' value =\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n\t\t</table>\n\n\t\t</form>\n\t\t<form name=\'stat_grp_nation_detail_result_form1\' id=\'stat_grp_nation_detail_result_form1\'  method=\'post\' target=\'parent.parent.frames[2]\'>\n\t\t<input type=\'hidden\' name=\'maxrecord\' id=\'maxrecord\' value=";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =" >\n\t\t<input type=\'hidden\' name=\'insert_to_db\' id=\'insert_to_db\' value=\'\' >\n\t\t<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'insert\' >\n\t\t<input type =\'hidden\' name =\'from\' value =\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\n\t\t</form>\n\t</body>\n</html>\n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\t\n\t\n   <form name=\'stat_grp_nation_detail_result_form2\' id=\'stat_grp_nation_detail_result_form2\'> \n   <input type =\'hidden\' name =\'visit_type_id\' value =\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'>\n\t<input type =\'hidden\' name =\'order_cat_id\' value =\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'>\n\t\t    <input type =\'hidden\' name =\'alphabet\' value =\' \'>\n\t    <input type =\'hidden\' name =\'dtl_flag\' value =\' \'>\n\t<input type=\'hidden\' name=\'recval\' id=\'recval\' value=\'0\'>\n\n    <input type =\'hidden\' name =\'old_param\' value =\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>\n\t<input type =\'hidden\' name =\'from\' value =\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'>\n    <input type =\'hidden\' name =\'to\' value =\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'>\n\t\t\n";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t<script>callMember(\"A\");</script>\n\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t</form>\n     <table cellspacing=0 cellpadding=0 width=\'100%\' border=1>\n\t<TR id=\'alpha\'>\n\t\t\t<TD colspan=\'2\' >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=\'javascript:callMember(\"A\")\'>A</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'B\')\">B</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'C\')\">C</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'D\')\">D</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'E\')\">E</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'F\')\">F</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'G\')\">G</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'H\')\">H</a>&nbsp;&nbsp;\n\t\t\t<a href=\"javascript:callMember(\'I\')\">I</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'J\')\">J</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'K\')\">K</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'L\')\">L</a>&nbsp;&nbsp;\n\t\t\t<a href=\"javascript:callMember(\'M\')\">M</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'N\')\">N</a>&nbsp;&nbsp;\n\t\t\t<a href=\"javascript:callMember(\'O\')\">O</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'P\')\">P</a>&nbsp;&nbsp;\n\t\t\t<a href=\"javascript:callMember(\'Q\')\">Q</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'R\')\">R</a>&nbsp;&nbsp;\n\t\t\t<a href=\"javascript:callMember(\'S\')\">S</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'T\')\">T</a>&nbsp;&nbsp;\n\t\t\t<a href=\"javascript:callMember(\'U\')\">U</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'V\')\">V</a>&nbsp;&nbsp;\n\t\t\t<a href=\"javascript:callMember(\'W\')\">W</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'X\')\">X</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'Y\')\">Y</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'Z\')\">Z</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'Others\')\">";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</a>&nbsp;&nbsp;\n\t\t\t</TD>\n\t\t</TR>\n<tr id=\'alpha1\'><td colspan=\'2\'>&nbsp;</td></tr></table>\n";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\n\t<body onKeyDown = \'lockKey();\'>\n\t<form name=\'stat_grp_nation_detail_result_form\' id=\'stat_grp_nation_detail_result_form\'>\n\t\t<table cellspacing=0 cellpadding=0 width=\'100%\' border=1>\n\t\t\t<tr>\n\t\t\t\t<td class=\'columnheader\' >";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 =" </td>\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\'>";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 =" </td>\n\t\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n</form>\n\n<SCRIPT>\n\tfunction nextprev(choice)\n\t{\n\t\tvar start1;\n\t\tvar end1;\n\t\tvar alphabet1=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\'\n\t\tvar stat1 = \'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\';\n\t\tvar stat2 = \'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\';\n\t\tif(choice==\'next\')\n\t\t{\n\t\tstart1=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\';\n\t\tend1=\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\';\n\t\t}\n\t\telse\n\t\t{\n\t\tstart1=\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\';\n\t\t}\n\t\t// Code added for 22370\n\tif(confirm(getMessage(\'WANT_TO_SAVE\',\'common\')))\n\t{\n\tapply(\'Y\');\n\tdocument.location.href=\'../../eOP/jsp/CatalogForClinicResult.jsp?dtl_flag=insert&visit_type_id=\'+stat1+\'&order_cat_id=\'+stat2+\'&first_time=1&from=\'+start1+\'&to=\'+end1+\'&alphabet=\'+alphabet1;\n\t}\n\telse\n\t{\n\t\tdocument.location.href=\'../../eOP/jsp/CatalogForClinicResult.jsp?dtl_flag=insert&visit_type_id=\'+stat1+\'&order_cat_id=\'+stat2+\'&first_time=1&from=\'+start1+\'&to=\'+end1+\'&alphabet=\'+alphabet1;\n\t}\n\t}\n\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\tif(document.getElementById(\"nextval\"))\n\t\tdocument.getElementById(\"nextval\").style.visibility=\'hidden\'\n\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t</SCRIPT>\n\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

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
            _bw.write(_wl_block5Bytes, _wl_block5);

request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
 
	String visit_type_id="";
	String order_cat_id="";
	String checkedOnes="";
	String ord_cat="";
	String first_time=request.getParameter("first_time")==null ? "": request.getParameter("first_time");
	String param=request.getParameter("alphabet")==null ? "" : request.getParameter("alphabet");
	String from= request.getParameter("from")==null ? "" : request.getParameter("from");
	String to= request.getParameter("to")==null ? "" : request.getParameter("to");
	String frmSrch = request.getParameter("frmSrch")==null ? "" : request.getParameter("frmSrch");
	String from_hd="";
	String to_hd="";
	

	
	int start = 0 ;
	int end = 0 ;
	int j=1;
	int count1=0;

	if ( from == null || from.equals("") )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null || from.equals(""))
	  	end = 14 ;
	else
		end = Integer.parseInt( to ) ;	

	if(first_time==null)first_time="";

	HashMap statNationalRecSet= null;
	HashMap al= null;
	HashMap ArrLis= null;
	ArrayList hr=null;
	
	statNationalRecSet=(HashMap)session.getValue("StatNationalId");
	ArrLis=(HashMap)session.getValue("arrlis");
	al=(HashMap)session.getValue("al");

	
	if(first_time.equals("1")||statNationalRecSet==null)
	{

	statNationalRecSet=new HashMap();
	al=new HashMap();
	ArrLis = new HashMap();
	}

	String dtl_flag=request.getParameter("dtl_flag");
	String facilityid=(String)session.getValue("facility_id");
		
	Connection con = null;
	ResultSet rset=null ;
	Statement stmt=null;
	ResultSet rset1=null ;
	PreparedStatement pstmt = null;
	try
	{
	con = ConnectionManager.getConnection(request);
	if( dtl_flag.equals("insert"))
	{
	try{
	stmt = con.createStatement();
	
	String old_param=request.getParameter("old_param");
	if( param == null) param="";
	if( old_param == null) old_param="";
	 
	int maxrecord=0;
	int maxrecord1=0;
	
	int totprvrec=0;
	String classValue="";
	
	String totprvrec1=request.getParameter("totprvrec");
	String orcat ="";
		
	if(totprvrec1 == null)	totprvrec=0;
	else totprvrec = Integer.parseInt(totprvrec1) ;

	Collection ec= null;
	Iterator ie= null;
		
	try{
		
		for(int kk=0 ; kk<totprvrec ; kk++)
		{
			ec = statNationalRecSet.values();
			ie = ec.iterator();
			while(ie.hasNext())
			{
			String ext = (String)ie.next();
			
			if(!old_param.equals("")){
			boolean sb1 = ext.startsWith(old_param);
			if(sb1)
				{
					statNationalRecSet.remove(ext);
				}
	  		  }
			}
		}
	}catch(Exception e1){
		e1.printStackTrace();
		}

	visit_type_id=request.getParameter("visit_type_id");
	order_cat_id=request.getParameter("order_cat_id");
	String frmqry=request.getParameter("frmqry");

	
	if( visit_type_id == null) visit_type_id="";
	if( frmqry == null) frmqry="";
	if(!(frmqry.equals("")))
	{
	
	rset = stmt.executeQuery("select ORDER_CATEGORY from OR_ORDER_CATALOG where ORDER_CATALOG_CODE ='"+frmqry+"'");
	if(rset != null)
	while(rset.next()){
		orcat = rset.getString("ORDER_CATEGORY");
		out.println("asigne order_cat_id" + orcat );
	}

	order_cat_id = orcat;

	if(rset != null )rset.close();
	
	}

	if( order_cat_id == null) order_cat_id="";
	
	// Added the order by in the query for IN023645 on 06.09.2010 by Suresh M
	if(frmSrch.equals("S")) {			
		String sql_one="";
		//if(order_cat_id.equals("OH")){ // changed for CRF 485. Opening for order set
			sql_one="select distinct upper(substr(long_desc,1,1))selalpha  from or_order_catalog where ORDER_CATALOG_NATURE in ('A','P','S') and long_desc between 'A' AND 'ZZ' and ORDER_CATEGORY ='"+order_cat_id+"'  and eff_status = 'E' order by selalpha";
		//}else{
			//sql_one="select distinct upper(substr(long_desc,1,1))selalpha  from or_order_catalog where ORDER_CATALOG_NATURE in ('A','P') and long_desc between 'A' AND 'ZZ' and ORDER_CATEGORY ='"+order_cat_id+"' order by selalpha ";
		//}		
		pstmt = con.prepareStatement(sql_one);
		rset1= pstmt.executeQuery();
		if(rset1.next())
		{
			param = rset1.getString("selalpha");			
		}
        if(rset1 != null )rset1.close();
		if(pstmt != null ) pstmt.close();


		
		

		if(param.equals("")){
			String sql_others="";		 
			sql_others="select distinct upper(substr(long_desc,1,1))Others  from or_order_catalog where ORDER_CATALOG_NATURE in ('A','P','S') and long_desc is not null and ORDER_CATEGORY ='"+order_cat_id+"'  and eff_status = 'E' order by Others";		
			pstmt = con.prepareStatement(sql_others);
			rset1= pstmt.executeQuery();
			if(rset1.next()){
				param = rset1.getString("Others");			
			}
			
			if(param== null)param = "";
			if(rset1 != null )rset1.close();
			if(pstmt != null ) pstmt.close();
		}

		
		
		
	}

	

	String sql="";
	if( ! param.equals(""))
	{
		
		if( param.equals("Others")){
			
			//if(order_cat_id.equals("OH")){ // changed for CRF 485. Opening for order set
				sql=" SELECT a.order_catalog_code, b.long_desc  FROM  op_catalog_for_clinic a, or_order_catalog b WHERE b.ORDER_CATALOG_NATURE in ('A','P','S') and a.facility_id = '"+facilityid+"'   AND a.CLINIC_CODE = '"+visit_type_id+"'   AND b.order_category = '"+order_cat_id+"'   AND a.order_catalog_code = b.order_catalog_code    and upper(substr(b.long_desc,1,1)) not between 'A' and 'ZZ' UNION SELECT order_catalog_code, long_desc   FROM or_order_catalog  WHERE ORDER_CATALOG_NATURE in ('A','P','S') AND order_category = '"+order_cat_id+"'   AND eff_status = 'E'  and upper(substr(long_desc,1,1)) not between 'A' and 'ZZ' AND order_catalog_code NOT IN (SELECT e.order_catalog_code  FROM op_catalog_for_clinic e, or_order_catalog f WHERE e.facility_id ='"+facilityid+"' AND e.CLINIC_CODE = '"+visit_type_id+"' AND e.order_catalog_code = f.order_catalog_code AND f.order_category = '"+order_cat_id+"'   and upper(substr(f.long_desc,1,1)) not between 'A' and 'ZZ') order by long_desc  ";	
			//}else{
				//sql=" SELECT a.order_catalog_code, b.long_desc  FROM  op_catalog_for_clinic a, or_order_catalog b WHERE b.ORDER_CATALOG_NATURE in ('A','P') and a.facility_id = '"+facilityid+"'   AND a.CLINIC_CODE = '"+visit_type_id+"'   AND b.order_category = '"+order_cat_id+"'   AND a.order_catalog_code = b.order_catalog_code    and upper(substr(b.long_desc,1,1)) not between 'A' and 'ZZ' UNION SELECT order_catalog_code, long_desc   FROM or_order_catalog  WHERE ORDER_CATALOG_NATURE in ('A','P') AND order_category = '"+order_cat_id+"'   AND eff_status = 'E'  and upper(substr(long_desc,1,1)) not between 'A' and 'ZZ' AND order_catalog_code NOT IN (SELECT e.order_catalog_code  FROM op_catalog_for_clinic e, or_order_catalog f WHERE e.facility_id ='"+facilityid+"' AND e.CLINIC_CODE = '"+visit_type_id+"' AND e.order_catalog_code = f.order_catalog_code AND f.order_category = '"+order_cat_id+"'   and upper(substr(f.long_desc,1,1)) not between 'A' and 'ZZ') order by long_desc  ";	
			//}
		
		}else{
			//if(order_cat_id.equals("OH")){ // changed for CRF 485. Opening for order set
				sql = "SELECT a.order_catalog_code, b.long_desc   FROM op_catalog_for_clinic a, or_order_catalog b  WHERE b.ORDER_CATALOG_NATURE in ('A','P','S') and a.facility_id = '"+facilityid+"'  AND a.CLINIC_CODE = '"+visit_type_id+"'   AND b.order_category = '"+order_cat_id+"'  AND a.order_catalog_code = b.order_catalog_code   AND UPPER (b.long_desc) LIKE '"+param+"%' UNION SELECT order_catalog_code, long_desc FROM or_order_catalog WHERE ORDER_CATALOG_NATURE in ('A','P','S') AND order_category = '"+order_cat_id+"' AND eff_status = 'E' and UPPER(LONG_DESC) LIKE '"+param+"%' AND order_catalog_code NOT IN (SELECT e.order_catalog_code FROM op_catalog_for_clinic e, or_order_catalog f WHERE e.facility_id = '"+facilityid+"'  AND e.CLINIC_CODE =  '"+visit_type_id+"' AND e.order_catalog_code = f.order_catalog_code AND f.order_category = '"+order_cat_id+"' AND UPPER (f.long_desc) LIKE '"+param+"%') order by long_desc";
			//}else{

				//sql = "SELECT a.order_catalog_code, b.long_desc   FROM op_catalog_for_clinic a, or_order_catalog b  WHERE b.ORDER_CATALOG_NATURE in ('A','P') and a.facility_id = '"+facilityid+"'  AND a.CLINIC_CODE = '"+visit_type_id+"'   AND b.order_category = '"+order_cat_id+"'  AND a.order_catalog_code = b.order_catalog_code   AND UPPER (b.long_desc) LIKE '"+param+"%' UNION SELECT order_catalog_code, long_desc FROM or_order_catalog WHERE ORDER_CATALOG_NATURE in ('A','P') AND order_category = '"+order_cat_id+"' AND eff_status = 'E' and UPPER(LONG_DESC) LIKE '"+param+"%' AND order_catalog_code NOT IN (SELECT e.order_catalog_code FROM op_catalog_for_clinic e, or_order_catalog f WHERE e.facility_id = '"+facilityid+"'  AND e.CLINIC_CODE =  '"+visit_type_id+"' AND e.order_catalog_code = f.order_catalog_code AND f.order_category = '"+order_cat_id+"' AND UPPER (f.long_desc) LIKE '"+param+"%') order by long_desc";
			//}
		}

	}
	else 
	{
		//if(order_cat_id.equals("OH")){ // changed for CRF 485. Opening for order set
			sql = "SELECT   a.order_catalog_code, b.long_desc  FROM op_catalog_for_clinic a, or_order_catalog b WHERE b.ORDER_CATALOG_NATURE in ('A','P','S') and a.facility_id = '"+facilityid+"'  AND a.CLINIC_CODE = '"+visit_type_id+"' AND b.order_category = '"+order_cat_id+"' AND a.order_catalog_code = b.order_catalog_code  AND a.CLINIC_CODE = '"+visit_type_id+"'";
		//}else{
			//sql = "SELECT   a.order_catalog_code, b.long_desc  FROM op_catalog_for_clinic a, or_order_catalog b WHERE b.ORDER_CATALOG_NATURE in ('A','P') and a.facility_id = '"+facilityid+"'  AND a.CLINIC_CODE = '"+visit_type_id+"' AND b.order_category = '"+order_cat_id+"' AND a.order_catalog_code = b.order_catalog_code  AND a.CLINIC_CODE = '"+visit_type_id+"'";
		//}
	}
	
	
	
	
	rset=stmt.executeQuery(sql);
	
	String count="";
	
	
	if( ! param.equals(""))
	{
	
		if( param.equals("Others")){
			//if(order_cat_id.equals("OH")){ // changed for CRF 485. Opening for order set
				count="select count(*) as total from op_catalog_for_clinic a, or_order_catalog b WHERE b.ORDER_CATALOG_NATURE in ('A','P','S') and a.facility_id = '"+facilityid+"'   AND a.CLINIC_CODE = '"+visit_type_id+"'   AND b.order_category = '"+order_cat_id+"'   AND a.order_catalog_code = b.order_catalog_code    and upper(substr(b.long_desc,1,1)) not between 'A' and 'ZZ' UNION SELECT  count(*)  from  or_order_catalog  WHERE ORDER_CATALOG_NATURE in ('A','P','S') AND order_category = '"+order_cat_id+"' AND eff_status = 'E'  and upper(substr(long_desc,1,1)) not between 'A' and 'ZZ' AND order_catalog_code NOT IN (SELECT e.order_catalog_code FROM op_catalog_for_clinic e, or_order_catalog f WHERE e.facility_id ='"+facilityid+"' AND e.CLINIC_CODE = '"+visit_type_id+"' AND e.order_catalog_code = f.order_catalog_code AND f.order_category = '"+order_cat_id+"'   and upper(substr(f.long_desc,1,1)) not between 'A' and 'ZZ')";
			//}else{
				//count="select count(*) as total from op_catalog_for_clinic a, or_order_catalog b WHERE b.ORDER_CATALOG_NATURE in ('A','P') and a.facility_id = '"+facilityid+"'   AND a.CLINIC_CODE = '"+visit_type_id+"'   AND b.order_category = '"+order_cat_id+"'   AND a.order_catalog_code = b.order_catalog_code    and upper(substr(b.long_desc,1,1)) not between 'A' and 'ZZ' UNION SELECT  count(*)  from  or_order_catalog  WHERE ORDER_CATALOG_NATURE in ('A','P') AND order_category = '"+order_cat_id+"' AND eff_status = 'E'  and upper(substr(long_desc,1,1)) not between 'A' and 'ZZ' AND order_catalog_code NOT IN (SELECT e.order_catalog_code FROM op_catalog_for_clinic e, or_order_catalog f WHERE e.facility_id ='"+facilityid+"' AND e.CLINIC_CODE = '"+visit_type_id+"' AND e.order_catalog_code = f.order_catalog_code AND f.order_category = '"+order_cat_id+"'   and upper(substr(f.long_desc,1,1)) not between 'A' and 'ZZ')";
			//}
		}else{
		//	if(order_cat_id.equals("OH")){ // changed for CRF 485. Opening for order set
				count = "select count(*) as total from op_catalog_for_clinic a, or_order_catalog b  WHERE  b.ORDER_CATALOG_NATURE in ('A','P','S') and a.facility_id = '"+facilityid+"'  and a.CLINIC_CODE = '"+visit_type_id+"'   AND b.order_category = '"+order_cat_id+"'  AND a.order_catalog_code = b.order_catalog_code   AND UPPER (b.long_desc) LIKE '"+param+"%' UNION SELECT count(*) FROM or_order_catalog  WHERE ORDER_CATALOG_NATURE in ('A','P','S') AND order_category = '"+order_cat_id+"'  AND eff_status = 'E' AND UPPER(LONG_DESC) LIKE '"+param+"%' and order_catalog_code NOT IN (SELECT e.order_catalog_code FROM op_catalog_for_clinic e, or_order_catalog f WHERE e.facility_id = '"+facilityid+"'      AND e.CLINIC_CODE = '"+visit_type_id+"' AND e.order_catalog_code = f.order_catalog_code    AND f.order_category = '"+order_cat_id+"' AND UPPER (f.long_desc) LIKE '"+param+"%')";
			//}else{
				//count = "select count(*) as total from op_catalog_for_clinic a, or_order_catalog b  WHERE  b.ORDER_CATALOG_NATURE in ('A','P') and a.facility_id = '"+facilityid+"'  and a.CLINIC_CODE = '"+visit_type_id+"'   AND b.order_category = '"+order_cat_id+"'  AND a.order_catalog_code = b.order_catalog_code   AND UPPER (b.long_desc) LIKE '"+param+"%' UNION SELECT count(*) FROM or_order_catalog  WHERE ORDER_CATALOG_NATURE in ('A','P') AND order_category = '"+order_cat_id+"'  AND eff_status = 'E' AND UPPER(LONG_DESC) LIKE '"+param+"%' and order_catalog_code NOT IN (SELECT e.order_catalog_code FROM op_catalog_for_clinic e, or_order_catalog f WHERE e.facility_id = '"+facilityid+"'      AND e.CLINIC_CODE = '"+visit_type_id+"' AND e.order_catalog_code = f.order_catalog_code    AND f.order_category = '"+order_cat_id+"' AND UPPER (f.long_desc) LIKE '"+param+"%')";
			//}
		}

	}
	else
	{
		//if(order_cat_id.equals("OH")){ // changed for CRF 485. Opening for order set
			count="SELECT count(*) as total from  op_catalog_for_clinic a, or_order_catalog b WHERE b.ORDER_CATALOG_NATURE in ('A','P''S') and a.facility_id = '"+facilityid+"'  AND a.CLINIC_CODE = '"+visit_type_id+"' AND b.order_category = '"+order_cat_id+"' AND a.order_catalog_code = b.order_catalog_code  AND a.CLINIC_CODE = '"+visit_type_id+"' ";
		//}else{
			//count="SELECT count(*) as total from  op_catalog_for_clinic a, or_order_catalog b WHERE b.ORDER_CATALOG_NATURE in ('A','P') and a.facility_id = '"+facilityid+"'  AND a.CLINIC_CODE = '"+visit_type_id+"' AND b.order_category = '"+order_cat_id+"' AND a.order_catalog_code = b.order_catalog_code  AND a.CLINIC_CODE = '"+visit_type_id+"' ";
		//}
	}
	
	pstmt=con.prepareStatement(count);
	rset1=pstmt.executeQuery();
	if(rset1 !=null)
	{
		while(rset1.next())
		{
		maxrecord1 = rset1.getInt("total");
		maxrecord = maxrecord+maxrecord1;
		
		}
	}
		
	if(rset1 != null )rset1.close();
	if(pstmt !=null ) pstmt.close();

	int i=0;
	
	if(maxrecord==0){
	if(!first_time.equals("1")) {
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));</script>");
	return;
	}
	}
// if(param.equals("")){
if(!param.equals("") && maxrecord > 0){
	
	try{
	
	//String sqlVal="select b.long_desc from op_catalog_for_clinic a, OR_ORDER_CATALOG b where b.ORDER_CATALOG_CODE = a.ORDER_CATALOG_CODE and a.CLINIC_CODE='"+visit_type_id+"' and facility_id='"+facilityid+"' ";
	String sqlVal="";
	//if(order_cat_id.equals("OH")){ // changed for CRF 485. Opening for order set
		sqlVal="select b.ORDER_CATALOG_CODE , b.long_desc from op_catalog_for_clinic a, OR_ORDER_CATALOG b where b.ORDER_CATALOG_NATURE in ('A','P','S') and b.ORDER_CATALOG_CODE = a.ORDER_CATALOG_CODE and a.CLINIC_CODE='"+visit_type_id+"' and facility_id='"+facilityid+"' ";
	//}else{
		//sqlVal="select b.ORDER_CATALOG_CODE , b.long_desc from op_catalog_for_clinic a, OR_ORDER_CATALOG b where b.ORDER_CATALOG_NATURE in ('A','P') and b.ORDER_CATALOG_CODE = a.ORDER_CATALOG_CODE and a.CLINIC_CODE='"+visit_type_id+"' and facility_id='"+facilityid+"' ";
	//}
	
	pstmt=con.prepareStatement(sqlVal);
	rset1 = pstmt.executeQuery();           
		
            if(rset1 !=null)
            {
                 while(rset1.next())
                 {
				    statNationalRecSet.put(""+rset1.getString(1)+"",rset1.getString(1));    
				 }
                
            }
		
		if(rset1 != null )rset1.close();
		if(pstmt != null )pstmt.close();

     }catch(SQLException e){
		 e.toString();
		 e.printStackTrace();
	
	}
 }
	 al = new HashMap();
	// Added the order by in the query for IN023645 on 06.09.2010 by Suresh M
	if( maxrecord > 0 )
	{
		
		String sql_two="";
		//if(order_cat_id.equals("OH")){ // changed for CRF 485. Opening for order set
			sql_two="select distinct upper(substr(long_desc,1,1))selalpha  from or_order_catalog where ORDER_CATALOG_NATURE in ('A','P','S') and long_desc between 'A' AND 'ZZ' and ORDER_CATEGORY ='"+order_cat_id+"' and eff_status = 'E' order by selalpha";
		//}else{
			//sql_two="select distinct upper(substr(long_desc,1,1))selalpha  from or_order_catalog where ORDER_CATALOG_NATURE in ('A','P') and long_desc between 'A' AND 'ZZ' and ORDER_CATEGORY ='"+order_cat_id+"' order by selalpha";
		//}
		
		pstmt = con.prepareStatement(sql_two);
		String selalpha = "";
		hr = new ArrayList();
		rset1= pstmt.executeQuery();
		while (rset1.next())
		{
			selalpha = rset1.getString("selalpha");
			hr.add(selalpha);
			
		}
	
        if(rset1 != null )rset1.close();
		if(pstmt != null ) pstmt.close();


            _bw.write(_wl_block8Bytes, _wl_block8);

		Iterator e7 = hr.iterator();
	         
	while(e7.hasNext())
		{
		 String jj = (String)e7.next();
		 
		
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(jj));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(jj));
            _bw.write(_wl_block11Bytes, _wl_block11);
}
		
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

		String remmem=request.getParameter("remmem");
		if( remmem == null) remmem="";	
		
		/*try{
		if(!remmem.equals("R"))
		 {
			 StringTokenizer strtoken=new StringTokenizer(remmem,"|");
			while(strtoken.hasMoreTokens())
			{
				String rno=strtoken.nextToken();					
				statNationalRecSet.remove(rno);	
				ArrLis.put(""+rno+"",rno);
			}
		 }
			for(int kk=0 ; kk<totprvrec ; kk++)
				for(int in=0;in<totprvrec;in++){
				checkedOnes = request.getParameter("inc"+(in));
				if(checkedOnes==null) checkedOnes = "";
			
				if(!checkedOnes.equals(""))
                  {
				    al.put(""+checkedOnes+"",checkedOnes);
				    if(!(statNationalRecSet.containsKey(checkedOnes)))
					 {
						 statNationalRecSet.put(""+checkedOnes+"",checkedOnes);
                     }
				 }
		 	}

		}catch(Exception e){
			
			}*/
			
            _bw.write(_wl_block14Bytes, _wl_block14);
if ( !(start <= 1)  ) {
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
}
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
 
			
			String chkAttribute="";
			if ( start != 1 )
			{
				 for( int k=1; k<start; j++,k++ )
				 {
					 rset.next() ;
				 }
			}

		    count1=0;
		    if(rset!=null)
				{
					while(rset.next() && j<=end)
					{
						//ord_cat=rset.getString("long_desc");						
						ord_cat=rset.getString("order_catalog_code");
						
						if(statNationalRecSet.containsValue(ord_cat))
						{
							chkAttribute = "CHECKED";							
								
						}
						else
								chkAttribute="UNCHECKED";
             
				if ( (i+1) % 2 == 0 )
						classValue = "QRYEVEN" ;
				else
						classValue = "QRYODD" ;
						
			
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(rset.getString(1)));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(rset.getString("long_desc")));
            _bw.write(_wl_block25Bytes, _wl_block25);
 if( first_time.equals("1") ) { 
					
					
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(chkAttribute));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(ord_cat));
            _bw.write(_wl_block30Bytes, _wl_block30);
 } else {
					
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(chkAttribute));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(ord_cat));
            _bw.write(_wl_block34Bytes, _wl_block34);
 } 
            _bw.write(_wl_block35Bytes, _wl_block35);
		
					i++;
					j++;
					count1++;
					}
					maxrecord=count1;
					//maxrecord=j;
				}

		if(rset != null )rset.close();
		if(stmt != null )stmt.close();
			
			
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(visit_type_id));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(order_cat_id));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(param));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(maxrecord));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(maxrecord));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(from_hd));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(to_hd));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(maxrecord));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(from_hd));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(to_hd));
            _bw.write(_wl_block45Bytes, _wl_block45);

}
else
{ 
	String from1= request.getParameter("from")==null? "" : request.getParameter("from");
	String to1= request.getParameter("to") == null ? "" : request.getParameter("to");

            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(visit_type_id));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(order_cat_id));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(param));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(from1));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(to1));
            _bw.write(_wl_block51Bytes, _wl_block51);
	
	if(first_time.equals("1"))
	{
	
            _bw.write(_wl_block52Bytes, _wl_block52);
 
		first_time="2";
	}

	  for(int kk=0 ; kk<totprvrec ; kk++)
				for(int in=0;in<totprvrec;in++){
				checkedOnes = request.getParameter("inc"+(in));
				if(checkedOnes==null) checkedOnes = "";
			
				if(!checkedOnes.equals(""))
                  {
				    al.put(""+checkedOnes+"",checkedOnes);
				    if(!(statNationalRecSet.containsKey(checkedOnes)))
					 {
						 statNationalRecSet.put(""+checkedOnes+"",checkedOnes);
                     }
				 }
		 	}
	
	
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);
	
}

} catch(Exception e){
	out.println("here: ");
	out.println(e); 
	e.printStackTrace();
	} 
finally{
	session.setAttribute("StatNationalId", statNationalRecSet);
	session.setAttribute("arrlis", ArrLis);
	session.setAttribute("al", al);
	}
} else{

	try{
	stmt=con.createStatement();
	int maxrecord=0;
	String classValue="";	
	visit_type_id=request.getParameter("visit_type_id");
	order_cat_id=request.getParameter("order_cat_id");
	if( visit_type_id == null) visit_type_id="";
	if( order_cat_id == null) order_cat_id="";
	
	String sql="select b.long_desc from op_catalog_for_clinic a, OR_ORDER_CATALOG b where b.ORDER_CATALOG_CODE = a.ORDER_CATALOG_CODE and a.CLINIC_CODE='"+visit_type_id+"' ";
		
	rset=stmt.executeQuery(sql);
	
	String count="select count(*) as total  from op_catalog_for_clinic a, OR_ORDER_CATALOG b where b.ORDER_CATALOG_CODE = a.ORDER_CATALOG_CODE and a.CLINIC_CODE='"+visit_type_id+"' ";
		
	pstmt=con.prepareStatement(count);
	rset1=pstmt.executeQuery();
	if(rset1!=null)
	{
		while(rset1.next())
		{
		maxrecord = rset1.getInt("total");
		}
	}

	if(rset1 != null )rset1.close();
    if(pstmt != null) pstmt.close();	
 
	int i=0;

            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);
 
			 	if(rset!=null)
				{
					while(rset.next() && i<=maxrecord)
					{
						if ( i % 2 == 0 )
							classValue = "QRYEVEN" ;
						else
							classValue = "QRYODD" ;
							
				
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(rset.getString("long_desc")));
            _bw.write(_wl_block59Bytes, _wl_block59);
		
					i++;
					}
				}
   if(rset !=null )rset.close();
   if(stmt != null )stmt.close();

}
catch(Exception e) { 
	out.println(e);
	e.printStackTrace();
	}
}
	//statNationalRecSet.clear();
	//al.clear();
	//ArrLis.clear();
	//hr.clear();
}catch(Exception e){
	e.printStackTrace();
	}
finally
{
	statNationalRecSet.clear();
	try{
        if(rset != null) rset.close();
		if(rset1 != null) rset1.close();
		if(pstmt != null) pstmt.close();
		if(stmt != null) stmt.close();
	}catch(Exception e){
		e.printStackTrace();
	}
	if(con != null) ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(param));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(visit_type_id));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(order_cat_id));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(start+14));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(end+14));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(start-14));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(end-14));
            _bw.write(_wl_block66Bytes, _wl_block66);
if(count1<14){
            _bw.write(_wl_block67Bytes, _wl_block67);
}
            _bw.write(_wl_block68Bytes, _wl_block68);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.others.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ordercatalog.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Include.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.others.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.service.label", java.lang.String .class,"key"));
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
}
