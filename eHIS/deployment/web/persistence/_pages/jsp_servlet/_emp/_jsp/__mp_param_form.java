package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eCommon.Common.*;
import eXH.InterfaceUtil;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __mp_param_form extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/mp_param_form.jsp", 1742479587357L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n\n<!-- Last Modified Date Time : 9/13/2006 1:48 PM -->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"></link>\n<script src=\"../js/mp_param.js\"></script>\n<script src=\"../../eCommon/js/common.js\"></script>\n<script src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n<script src=\"../../eCommon/js/CommonLookup.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<Script>\n\n\t\t\t\tfunction expandCollapse(calledFrom) {\t\t\t\t\t\n\n\t\t\t\t\tif(calledFrom == \'pat_admin_tab\') {\n\n\t\t\t\t\t\tdocument.getElementById(\'PATADMIN\').style.display = \'inline\';\n\t\t\t\t\t\tdocument.getElementById(\'LNAMES\').style.display = \'none\';\n\t\t\t\t\t\tdocument.getElementById(\'ALTID\').style.display = \'none\';\n\t\t\t\t\t\tdocument.getElementById(\'NEWBORN\').style.display = \'none\';\n\t\t\t\t\t\tif(document.getElementById(\'AADHAAR\'))\n\t\t\t\t\t\tdocument.getElementById(\'AADHAAR\').style.display = \'none\';\n\n\t\t\t\t\t\tdocument.getElementById(\'OTHERS\').style.display = \'none\';\n\t\t\t\t\t\t\n\t\t\t\t\t} else if(calledFrom == \'legal_names_tab\') {\n\n\t\t\t\t\t\tdocument.getElementById(\'PATADMIN\').style.display = \'none\';\n\t\t\t\t\t\tdocument.getElementById(\'LNAMES\').style.display = \'inline\';\n\t\t\t\t\t\tdocument.getElementById(\'ALTID\').style.display = \'none\';\n\t\t\t\t\t\tdocument.getElementById(\'NEWBORN\').style.display = \'none\';\n\t\t\t\t\t\tdocument.getElementById(\'OTHERS\').style.display = \'none\';\n\t\t\t\t\t\tif(document.getElementById(\'AADHAAR\')) \n\t\t\t\t\t\tdocument.getElementById(\'AADHAAR\').style.display = \'none\';\n\t\t\t\t\t\t\n\t\t\t\t\t} else if(calledFrom == \'alt_id_chk_tab\') {\n\n\t\t\t\t\t\tdocument.getElementById(\'PATADMIN\').style.display = \'none\';\n\t\t\t\t\t\tdocument.getElementById(\'LNAMES\').style.display = \'none\';\n\t\t\t\t\t\tdocument.getElementById(\'ALTID\').style.display = \'inline\';\n\t\t\t\t\t\tdocument.getElementById(\'NEWBORN\').style.display = \'none\';\n\t\t\t\t\t\tdocument.getElementById(\'OTHERS\').style.display = \'none\';\n\t\t\t\t\t\tif(document.getElementById(\'AADHAAR\')) \n\t\t\t\t\t\tdocument.getElementById(\'AADHAAR\').style.display = \'none\';\n\t\t\t\t\t\t\n\t\t\t\t\t} else if(calledFrom == \'new_born_tab\') {\n\n\t\t\t\t\t\tdocument.getElementById(\'PATADMIN\').style.display = \'none\';\n\t\t\t\t\t\tdocument.getElementById(\'LNAMES\').style.display = \'none\';\n\t\t\t\t\t\tdocument.getElementById(\'ALTID\').style.display = \'none\';\n\t\t\t\t\t\tdocument.getElementById(\'NEWBORN\').style.display = \'inline\';\n\t\t\t\t\t\tdocument.getElementById(\'OTHERS\').style.display = \'none\';\n\t\t\t\t\t\tif(document.getElementById(\'AADHAAR\')) \n\t\t\t\t\t\tdocument.getElementById(\'AADHAAR\').style.display = \'none\';\n\t\t\t\t\t\t\n\t\t\t\t\t} else if(calledFrom == \'others_tab\') {\n\n\t\t\t\t\t\tdocument.getElementById(\'PATADMIN\').style.display = \'none\';\n\t\t\t\t\t\tdocument.getElementById(\'LNAMES\').style.display = \'none\';\n\t\t\t\t\t\tdocument.getElementById(\'ALTID\').style.display = \'none\';\n\t\t\t\t\t\tdocument.getElementById(\'NEWBORN\').style.display = \'none\';\n\t\t\t\t\t\tdocument.getElementById(\'OTHERS\').style.display = \'inline\';\n\t\t\t\t\t\tif(document.getElementById(\'AADHAAR\')) \n\t\t\t\t\t\tdocument.getElementById(\'AADHAAR\').style.display = \'none\';\n\t\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t\telse if(calledFrom == \'aadhar_tab\') {\n\n\t\t\t\t\t\tdocument.getElementById(\'PATADMIN\').style.display = \'none\';\n\t\t\t\t\t\tdocument.getElementById(\'LNAMES\').style.display = \'none\';\n\t\t\t\t\t\tdocument.getElementById(\'ALTID\').style.display = \'none\';\n\t\t\t\t\t\tdocument.getElementById(\'NEWBORN\').style.display = \'none\';\n\t\t\t\t\t\tdocument.getElementById(\'OTHERS\').style.display = \'none\';\n\t\t\t\t\t\tif(document.getElementById(\'AADHAAR\')) \n\t\t\t\t\t\tdocument.getElementById(\'AADHAAR\').style.display = \'inline\';\n\t\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t}\n\n\t\tfunction tab_click1(id) \n\t\t{\n\t\t\tselectTab(id);\n\t\t\tif (id == \'pat_admin_tab\')\n\t\t\t   parent.frames[1].tab1.scrollIntoView();         \n\t\t\telse if (id == \'legal_names_tab\')\n\t\t\t\tparent.frames[1].tab4.scrollIntoView();\n\t\t\telse if (id == \'alt_id_chk_tab\')\n\t\t\t\tparent.frames[1].tab5.scrollIntoView();\n\t\t\telse if (id == \'new_born_tab\')\n\t\t\t\tparent.frames[1].tab7.scrollIntoView();\n\t\t\telse if(id == \'others_tab\')\n\t\t\t\t{\n\t\t\tif(parent.frames[1].tab10)    \n\t\t\tparent.frames[1].tab10.scrollIntoView();\n\t\t\t}\n\t\t\telse if(id == \'aadhar_tab\') //Added by PRITHIVI ON 10/05/2017 FOR KDAH-CRF-0362\n\t\t\t{\n\t\t\t\tif(parent.frames[1].tab11)    \n\t\t        parent.frames[1].tab11.scrollIntoView();\n\t\t\t}\n\t\t}\n\tfunction allowAlphaNumeric(UID)\n\t\t{\n\t\tUID.value=UID.value.split(/[^a-zA-Z0-9]/).join(\'\');\n\t\t}\n\t</Script>\n</head>\n<body  onLoad=\"FocusFirstElement(); ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="enableStartWith();";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="enableMarital(\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\',\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\');checkDefaultFather(\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\')";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" onSelect=\"codeArrestThruSelect()\" OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\'>\n\n<form name=\"mp_param_form\" id=\"mp_param_form\" method=\"post\" action=\"../../servlet/eMP.MpParamServlet\" \ntarget=\"messageFrame\">\n<input type=\"hidden\" name=\"section0\" id=\"section0\" value=\'\'>\n<input type=\"hidden\" name=\"section1\" id=\"section1\" value=\'\'>\n<input type=\"hidden\" name=\"section2\" id=\"section2\" value=\'\'>\n<input type=\"hidden\" name=\"section3\" id=\"section3\" value=\'\'>\n<input type=\"hidden\" name=\"section4\" id=\"section4\" value=\'\'>\n\n<div id = \'PATADMIN\'>\n\n<table cellspacing=\'0\' cellpadding=\'0\' width=\'100%\' border=0>\n\t<tr>\n\t\t<td width= \"100%\" class=\"white\">\n\t\t<ul id=\"tablist\" class=\"tablist\" style=\"padding-left:0px;\">\n\t\t\t <li class=\"tablistitem\" title=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n\t\t\t\t<a class=\"tabClicked\" id=\"pat_number_tab\" >\n\t\t\t\t\t<span class=\"tabSpanclicked\" id=\"pat_number_tabspan\" onClick=\'javascript:expandCollapse(\"pat_admin_tab\")\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\t\t\n\t\t\t<li class=\"tablistitem\" title=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n\t\t\t\t<a class=\"tabA\" id=\"legal_names_tab\" >\n\t\t\t\t\t<span class=\"tabAspan\" id=\"legal_names_tabspan\" onClick=\'javascript:expandCollapse(\"legal_names_tab\")\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\t\n\t\t\t<li class=\"tablistitem\" title=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" \'>\n\t\t\t\t<a class=\"tabA\" id=\"alt_id_chk_tab\" >\n\t\t\t\t\t<span class=\"tabAspan\" id=\"alt_id_chk_tabspan\" onClick=\'javascript:expandCollapse(\"alt_id_chk_tab\")\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n\t\t\t\t<a class=\"tabA\" id=\"new_born_tab\" >\n\t\t\t\t\t<span class=\"tabAspan\" id=\"new_born_tabspan\" onClick=\'javascript:expandCollapse(\"new_born_tab\")\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n\t\t\t\t<a class=\"tabA\" id=\"others_tab\" >\n\t\t\t\t\t<span class=\"tabAspan\" id=\"others_tabspan\" onClick=\'javascript:expandCollapse(\"others_tab\")\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\n\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" <!-- Added by PRITHIVI ON 10/05/2017 FOR KDAH-CRF-0362 -->\n\t        <li class=\"tablistitem\" title=\'Aadhaar Function Configuration\'>\n\t\t\t\t<a class=\"tabA\" id=\"aadhar_tab\" >\n\t\t\t\t\t<span class=\"tabAspan\" id=\"aadhar_tabspan\" onClick=\'javascript:expandCollapse(\"aadhar_tab\")\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\n\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t</ul>\n\t<script>prevTabObj=\'pat_admin_tab\'</script>\n </td></tr>\n</table>\n\n<table border=\'0\' cellpadding=\'2\' cellspacing=\'0\' width=\'100%\'>\n<tr>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t<td class=\"COLUMNHEADER\" colspan=\'4\'>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t<td class=\"COLUMNHEADER\" colspan=\'4\'>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\t\t\t\n\t\t\t</tr>\n                    <tr>\n                        ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t<td width=\"75%\" colspan=\'3\'>\n\t\t\t\t\t\t<TABLE>\n\t\t\t\t\t\t<TR>\n\t\t\t\t\t\t <td width=\"23%\" class=\"fields\">\n                        ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n                            <img src=\'../images/mandatory.gif\'></img>\n                        </td>\n                        <td class=\"label\" >";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</td>\n\n                        <td class=\"fields\" >";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n                        </td>\n\t\t\t\t\t\t</TR>\t\t\n\t\t\t\t\t\t</TABLE >\n\t\t\t\t\t\t</td>\n                    </tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</td>\t\n\t\t\t\t\n\n\t\t\t\t\t \n\t\t\t\t\t <td class=\"fields\" >\n\t\t\t\t\t\t\t\t   ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n                                </td>\n\t\t\t\t                \n\t\t\t\t\t \n\n<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\t\n\n<td class=\"fields\" >\n\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\n\n\n\n\n\t\t\t </td>\n\n\t\t\t\t </TR>\n\t\t\t\t \n\n<td width=\"75%\" colspan=\'3\'>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\"COLUMNHEADER\" colspan=\'4\'>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</td>\n\t\t\t\t\t</tr>\n\n\t\t\t\t   <tr>\n                        <td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</td>\n\t\t\t\t\t\t<td class=\"fields\" width=\'25%\'><input type=\'checkbox\' name=\'accept_national_id_no_yn\' id=\'accept_national_id_no_yn\' value=\'Y\' ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =" onClick=\"enableNatFields(this,\'Y\')\"></td>\n\t\t\t\t\t\t<td class=\'label\' nowrap width=\'25%\'>";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</td>\n                        \n                        ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t<!--\n                        <td class=\"fields\" width=\'25%\'><input type=\'checkbox\' name=\'ext_system_interface_yn\' id=\'ext_system_interface_yn\' value=\'Y\'  ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =" onclick=\'chk_chg_allowed_ser(this);\'></td>\n\t\t\t\t\t\t-->\n\t\t\t\t\t\t<td class=\"fields\" width=\'25%\'><input type=\'checkbox\' name=\'ext_system_interface_yn\' id=\'ext_system_interface_yn\' value=\'Y\'  ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =" ></td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</td>\n\t\t\t\t\t\t<td class=\"fields\" width=\'25%\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</td>\n                        <td class=\"fields\" width=\'25%\'>\n                         ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n                        </td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\t\n\t\t\t\t\t\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n                        <td class=\'label\' >";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</td>\n                        <td class=\"fields\">\n                        ";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n                        </td>\n                        <td class=\"label\" >";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</td>\n                        <td class=\"fields\" nowrap >\n                        ";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n                            <img src=\'../images/mandatory.gif\' style=\'visibility:hidden;\' name=\'nat_gif\'></img>\n                        </td>\n\n                        \n\n                       </tr>\n                        \n                        <tr>\n                        <td class=\'label\' nowrap>";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\n\t\t\t\t\t\t<!-- Commented by Marimuthu for DLA Changes -->\n\n\t\t\t\t\t\t<!--\n                        <td class=\"fields\"><input type=\'checkbox\' name=\'nat_reqd_for_all_ser\' id=\'nat_reqd_for_all_ser\' value=\'Y\'  ";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 =" onClick=\'series(this)\'></td>\n\t\t\t\t\t\t-->\n\n\t\t\t\t\t\t<!-- End of Comment -->\n\n\t\t\t\t\t\t <td class=\"fields\"><input type=\'checkbox\' name=\'nat_reqd_for_all_ser\' id=\'nat_reqd_for_all_ser\' value=\'Y\' ";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="></td>\n\n\t\t\t\t\t\t<td class=\'label\' nowrap>";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</td>                        \n                        <td\tclass=\"fields\">\n                            <select name=\'id_change_allowed_for_series\' id=\'id_change_allowed_for_series\'>\n                                <option value=\'\' >----------";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="---------</option>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n                                </select>\n                        </td>\n                         \n                    </tr>\n                    <tr>\n                        <td class=\'label\'>";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="&nbsp;";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="  \n                        </td>\n                       \n                        <td class=\'label\' nowrap>";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</td>\n                        \n                         ";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\n                        <td class=\"fields\">\n                        ";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n                                <option value=\'\'>---------------";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="--------------</option>\n                                ";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n                            </select>\n                        </td>\n                    </tr>\n                    \n                        <!-- To fetch Routine Name  -->\n                            ";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n                        <!--Ends Here-->\n\n                    <tr>\n                        ";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\n                        <td class=\'label\' nowrap>";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n                        </td>\n                        <td class=\'label\' nowrap>";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="</td>\n                        <td class=\"fields\">\n                         ";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n                         <option value=\'\'>----------------";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="-----------------</option>\n                                ";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n                            </select>\n                        </td>\n                        \n                       \n                        \n                        \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'label\' nowrap>";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="</td>\n\t\t\t\t\t\t<td class=\'fields\'>\n\t\t\t\t\t\t<input type=\'text\' name=\'dft_national_id\' id=\'dft_national_id\' id=\'UID\' value=\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\' maxlength=\'20\' onkeyup=\'allowAlphaNumeric(this)\' ";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="></input>\n                        \n\t\t\t\t\t\t </td>\n\t\t\t\t\t\t </tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t\t\t\t\t\n\t\t\t\t\t\t <!--Added by Himanshu Saxena on 03-July-2023 for AAKH-CRF-0175 UserStory1 Starts-->\n                       ";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n                        <tr>\n\t                         <td class=\'label\' nowrap>";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="</td>\n\t                        <td class=\"fields\">\n\t                        ";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t                        </td>\n                        </tr>\n                        \n                       ";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n                        <!--Added by Himanshu Saxena on 03-July-2023 for AAKH-CRF-0175 US1 Ends-->\n\t\t\t\t\t\t \n                    </tr>\n\n        <tr>\n            ";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t<td class=\"COLUMNHEADER\" colspan=\'4\'>";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="</td>\n        ";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="</td>\n\t\t";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t\t</tr>\n\n                    <tr >\n                        <td class=\"label\" >";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="</td>\n\n                        <td class=\"fields\"><select name=\"gen_pat_ser_grp\" id=\"gen_pat_ser_grp\" style=\'width: 175px\'>\n                            <option value =\'\'>--------- ";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="---------\n                            ";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n                            </select>\n                        </td>\n                        \n                        <td class=\"label\" >";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="</td>\n\n                        <td class=\"fields\"><select name=\"newborn_pat_ser_grp\" id=\"newborn_pat_ser_grp\" style=\'width: 175px\'>\n                                <option value =\'\'>--------- ";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="---------</option>\n                            ";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n                            </select>\n                        </td>\n                    </tr>\n\n                    <tr>\n                        <td class=\"label\" nowrap>";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="</td>\n\n                        <td class=\"fields\"><select name=\"nat_id_pat_ser_grp\" id=\"nat_id_pat_ser_grp\" style=\'width: 175px\'>\n                            <option value =\'\'>---------";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n                            </select>\n                        </td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\t\n\t\t\t\t\t\t\t\n                        <td class=\"label\" >";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="</td>\n\n                        <td class=\"fields\"><select name=\"emeg_pat_ser_grp\" id=\"emeg_pat_ser_grp\" style=\'width: 175px\'>\n                            <option value =\'\'>---------";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n                            </select>\n                        </td>\n                        \n                    </tr>\n\n                    <tr >\n                        <td class=\"label\" nowrap>";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="</td>\n\n                        <td class=\"fields\"><select name=\"alt_id_pat_ser_grp\" id=\"alt_id_pat_ser_grp\" style=\'width: 175px\'>\n                            <option value =\'\'>--------- ";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n                            </select>\n                        </td>\n                        <td class=\"label\">";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="</td>\n\t\t\t\t\t\t<!-- Added by Mallikarjuna on 12/3/2003 -->\n\t\t\t\t\t\t<!-- code for getting of Count of Id_Type from mp_pat_ser_grp table-->\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t<!-- End of the code for getting of Count of Id_Type from mp_pat_ser_grp table-->\n                        <td class=\"fields\" nowrap><select name=\"dflt_pat_ser_grp_type\" id=\"dflt_pat_ser_grp_type\" style=\'width: 175px\'>\n                            ";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\n                            </select>\n                            <img src=\'../images/mandatory.gif\'></img>\n                        </td>\n                    </tr>\n<!-- Border test start -->\n\n  <!--   </td>\n    </tr> -->\n    </table>\n\n\n<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'100%\'>\n \n\n\t\t     <tr >\n            <td class=\'COLUMNHEADER\' colspan=\'4\'>";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="</td>\n        </tr>\n\n \t\t<tr>\n\t\t\t\t";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\n\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\n\n\t\t\t\t\t\t\t\t<td class=\"label\" width=\'25%\'>";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="</td>\n\n\t\t\t\t\t\t\t\t<td class=\'fields\' width=\'25%\'>\n\t\t\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'create_file\' id=\'create_file\' onClick=\'chkMedicalAdminFields(this);\' ";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 =">\n\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'create_file_yn\' id=\'create_file_yn\' value=\'";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\'>\n\t\t\t\t\t\t\t\t</td>\n\n\t\t\t\t\t\t\t\t<td class=\"label\" width=\'25%\'>";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="</td>\n\n                                <td class=\'fields\' width=\'25%\'>\n                                    ";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\'maintain_doc_or_file\' id=\'maintain_doc_or_file\' value=\'F\'>\n                                    </td>\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</tr>\n\t\t\t                 <tr>  \n                                    <td class=\"label\">";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="</td>\n                                   <td class=\"fields\" colspan=\'3\'>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\n                                    </td>\n                                </tr>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\n\t\t\t\t\t\t\t\t\t<tr><td align=\'left\' colspan=\'4\'><B><span class=\'label\'>";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="</span></B></td>\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\n\t\t\t\t\t\t\t\t\t <td class=\'label\' nowrap >";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="</td>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\n\t\t\t\t\t\t\t\t\t<td class=\'label\' nowrap >";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\n\t\t\t\t\t\t\t\t\t<td class=\"fields\">\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\n\t\t\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'create_file_at_pat_regn_yn\' id=\'create_file_at_pat_regn_yn\' value=\'Y\' checked onclick=\'GeneralClick()\'>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\n\t\t\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'create_file_at_pat_regn_yn\' id=\'create_file_at_pat_regn_yn\' value=\'N\'  onclick=\'GeneralClick()\'>\n\t\t\t\t\t\t\t    \t";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\n\t\t\t\t\t\t\t\t\t<input type=\'checkbox\' onload=\'GeneralClick()\' name=\'create_file_at_pat_regn_yn\' id=\'create_file_at_pat_regn_yn\' value=\'Y\' disabled checked>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\n\t\t\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'create_file_at_pat_regn_yn\' id=\'create_file_at_pat_regn_yn\' value=\'N\' disabled>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=\'label\' nowrap >";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="</td>\n\t\t\t\t\t\t\t\t\t<td class=\"fields\">\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\n\t\t\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'create_file_at_admission\' id=\'create_file_at_admission\' value=\'Y\' checked onclick=\'GeneralClick()\'>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\n\t\t\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'create_file_at_admission\' id=\'create_file_at_admission\' value=\'N\'  onclick=\'GeneralClick()\' >\n\t\t\t\t\t\t\t    \t";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\n\t\t\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'create_file_at_admission\' id=\'create_file_at_admission\' value=\'Y\' disabled checked>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\n\t\t\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'create_file_at_admission\' id=\'create_file_at_admission\' value=\'N\' disabled>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t <td class=\'label\' nowrap >";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\n\t\t\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'create_file_at_reg_visit_yn\' id=\'create_file_at_reg_visit_yn\' value=\'Y\' checked onclick=\'GeneralClick()\'>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\n\t\t\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'create_file_at_reg_visit_yn\' id=\'create_file_at_reg_visit_yn\' value=\'N\'  onclick=\'GeneralClick()\'>\n\t\t\t\t\t\t\t    \t";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\n\t\t\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'create_file_at_reg_visit_yn\' id=\'create_file_at_reg_visit_yn\' value=\'Y\' disabled checked>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\n\t\t\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'create_file_at_reg_visit_yn\' id=\'create_file_at_reg_visit_yn\' value=\'N\' disabled>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t <td class=\'label\' nowrap >";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\n\t\t\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'create_file_at_reg_att_yn\' id=\'create_file_at_reg_att_yn\' value=\'Y\' checked onclick=\'GeneralClick()\'>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\n\t\t\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'create_file_at_reg_att_yn\' id=\'create_file_at_reg_att_yn\' value=\'N\'  onclick=\'GeneralClick()\'>\n\t\t\t\t\t\t\t    \t";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\n\t\t\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'create_file_at_reg_att_yn\' id=\'create_file_at_reg_att_yn\' value=\'Y\' disabled checked>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\n\t\t\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'create_file_at_reg_att_yn\' id=\'create_file_at_reg_att_yn\' value=\'N\' disabled>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t    </tr>\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td class=\'label\' nowrap >";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\n\t\t\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'create_file_at_dc_admission_yn\' id=\'create_file_at_dc_admission_yn\' value=\'Y\' checked onclick=\'GeneralClick()\'>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\n\t\t\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'create_file_at_dc_admission_yn\' id=\'create_file_at_dc_admission_yn\' value=\'N\'  onclick=\'GeneralClick()\'>\n\t\t\t\t\t\t\t    \t";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\n\t\t\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'create_file_at_dc_admission_yn\' id=\'create_file_at_dc_admission_yn\' value=\'Y\' disabled checked>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\n\t\t\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'create_file_at_dc_admission_yn\' id=\'create_file_at_dc_admission_yn\' value=\'N\' disabled>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=\"label\" >&nbsp;</td>\n\t\t\t\t\t\t\t\t\t<td class=\"label\" >&nbsp;</td>\n\t\t\t\t\t\t\t\t    </tr>\n\t\t\t\t\t\t\t\t\t\n           \n\t\t</table>\n\n\t <table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'100%\'>\n\n\n\t\t\t\t<tr>\n                <td  colspan=\'4\'  class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="/";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="</td>\n\t\t\t\t</tr>\n\n\n\n\t\t\t\t\t\t\t<tr >\n                        <td class=\"label\" width=\'25%\'>";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="</td>\n\t\t\t\t\t\t\t<td class=\'fields\' width=\'25%\'>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'family_no_link_yn_new\' id=\'family_no_link_yn_new\' value=\'N\'>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td class=\"label\"  width=\'25%\'>";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="</td>\t\t\t\t\t\t\n\t\t\t\t\t\t<td class=\'fields\' width=\'25%\'>\n\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class =\'label\' >";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="</td>\n\t\t\t\t\t\t<td class=\"fields\"  >\n\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\n\t\t\t\t\t\t\t\t\t\t\t<select name=\'org_member_relationship_code\' id=\'org_member_relationship_code\' disabled>\n\t\t\t\t\t\t\t\t\t\t\t<option value=\'\'>----------";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="----------</option>\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\n\t\t\t\t\t\t\t</select><img src=\'../images/mandatory.gif\' id=\'rlnsp\' style=\'visibility:hidden\'></img>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t ";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\n\t\t\t\t\t\t <td class=\"label\" width=\'25%\'>";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="</td>\n\t\t\t\t\t\t<td class=\"fields\"  width=\'25%\'disabled>\n\t\t\t\t\t\t<select name=\'mapped_alt_id_org_member_id_ins\' id=\'mapped_alt_id_org_member_id_ins\' disabled>\n\t\t\t\t\t\t<option value=\'\' selected >----";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="----</option>\n\t\t\t\t\t\t<!--<option value=\'ID1\' selected >";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="1</option>-->\n\t\t\t\t\t\t</select>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\n\t\t\t\t\t\t<td class=\"label\" width=\'25%\'>";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="</td>\n\t\t\t\t\t\t<td class=\"fields\"  width=\'25%\' id=\'altidmbr\'>\n\t\t\t\t\t\t\t<select name=\'mapped_alt_id_org_member_id\' id=\'mapped_alt_id_org_member_id\' disabled>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\n\t\t\t\t\t\t\t\t<option value=\'\'>&nbsp;&nbsp;&nbsp;&nbsp;</option>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\n\t\t\t\t\t\t\t\t<option value=\'ID1\' selected >";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="1</option>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\n\t\t\t\t\t\t\t</select>\t\n\t\t\t\t\t\t  </td>\n\t\t\t\t\t\t  ";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="<td  width=\'25%\' colspan=\'2\'>&nbsp;</td>";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\n\t\t\t\t\t\t</tr>\n\n\n\n</table> \n\n</div>\n\n<!-- <a  name=\"tab4\" nowrap></a>   -->\n\n<div id = \'LNAMES\' style = \'display:none\'>\n\n<!--<a  name=\"tab4\" nowrap></a>-->\n<table cellspacing=\'0\' cellpadding=\'0\' width=\'100%\' border=0>\n\t<tr>\n\t\t<td width= \"100%\" class=\"white\">\n\t\t<ul id=\"tablist\" class=\"tablist\" style=\"padding-left:0px;\">\n\t\t\n\t\t\t<li class=\"tablistitem\" title=\'";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\'>\n\t\t\t\t<a class=\"tabA\" id=\"pat_admin_tab\" >\n\t\t\t\t\t<span class=\"tabAspan\" id=\"pat_admin_tabspan\" onClick=\'javascript:expandCollapse(\"pat_admin_tab\")\'>";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\n\t\t\t\n\t\t\t<li class=\"tablistitem\" title=\'";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\'>\n\t\t\t\t<a class=\"tabClicked\" id=\"legal_names_tab\" >\n\t\t\t\t\t<span class=\"tabSpanclicked\" id=\"legal_names_tabspan\" onClick=\'javascript:expandCollapse(\"legal_names_tab\")\'>";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\n\t\t\t<!-- Added by prithivi for kdah-crf-0362  -->\n\t\t\t";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\t\t\t\t\n\t\t\t<li class=\"tablistitem\" title=\'Aadhaar Function Configuration\'>\n\t\t\t\t<a class=\"tabA\" id=\"aadhar_tab\" >\n\t\t\t\t\t<span class=\"tabAspan\" id=\"aadhar_tabspan\" onClick=\'javascript:expandCollapse(\"aadhar_tab\")\'>";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\n\t\t\t</ul>\n\t </td></tr>\n\t</table>\n\n     <table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'100%\' border=0>\n\t\t\t\t\t<tr >\n                        \n\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\n\t\t\t\t\t\t<td  class=\"label\" width=\"30%\" >";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="</td>\n                        ";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\n\t\t\t\t\t\t<td width=\"25%\" class=\'fields\'> \n                            ";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\n                            <input type=\'checkbox\' name=\'name_in_oth_lang_yn\' id=\'name_in_oth_lang_yn\' onfocus=\'callfocusfun()\'\tonClick=\'setLocLang();\' value=\'Y\' ";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 =">\n                        </td>\n                  <td class=\"label\" width=\"25%\" >";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="</td>\n\n                        <td width=\"20%\" class=\'fields\'>\n\n\t\t\t\t\t\t<select name=\"dflt_sndx_type\" id=\"dflt_sndx_type\"  disabled>\n                            ";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\n                            </select>\n\t                        </td>\n                    </tr>\n\t\t\t\t\t<tr> \n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\n\t\t\t\t\t\t\t<td  class=\"label\" nowrap>";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\n\t\t\t\t\t\t<td  class=\"label\" nowrap>";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\n\t\t\t\t\t\t<td class=\'fields\' colspan=\'3\'>\n                            \n\t\t\t\t\t <!-- Added by Mallikarjuna on 12/2/2003 ** Accept Patient name as multiParts-->\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="</td>\n\t\t\t\t\t\t\t<!-- End of the addition for Accept Patient name as multiParts-->\n\t\t\t\t\t</tr>\n                </table>\n                <table border=\'1\' cellpadding=\'3\' cellspacing=\'0\' width=\'100%\'>\n                    <tr >\n                        <td class=\"COLUMNHEADER\" width=\"12%\" >&nbsp;&nbsp;</td>\n\n                        <td class=\"COLUMNHEADER\" width=\"7%\" >";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="</td>\n\n\t\t\t\t\t\t<td class=\"COLUMNHEADER\" width=\"9%\" >";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="</td>\n\n\t\t\t\t\t\t<td class=\"COLUMNHEADER\" width=\"12%\"> ";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="</td>\n\n                        <td class=\"COLUMNHEADER\" width=\"8%\" >";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="</td>\n\t\t\t\t\t\t\n                        <td class=\"COLUMNHEADER\" width=\"12%\" >";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="</td>\n                        <td class=\"COLUMNHEADER\" width=\"20%\" >";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="</td>\n                        <td class=\"COLUMNHEADER\" width=\"18%\" >";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="</td>\n                    </tr>\n\n                    <tr >\n                        <td class=\"label\" width=\"12%\" nowrap>";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="</td>\n\n                        <td width=\"7%\" class=\'fields\'>\n                        ";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\n                        </td>\n\t\t\t\t\t\t<td width=\"9%\" class=\'fields\'>\n                        ";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\n                        </td>\n\n\t\t\t\t\t\t<td width=\"12%\" class=\'fields\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\n\t\t\t\t\t\t</td>\n\n                        <td width=\"8%\" class=\'fields\'>\n                        ";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\n\t\t\t\t\t\t<input type=\'hidden\' name=\'name_prefix_reqd_yn_new\' id=\'name_prefix_reqd_yn_new\' value=\'N\'>\n                        </td>\n\n                        <td width=\"10%\">&nbsp;</td>\n                        <td width=\"20%\" class=\'fields\'>\n                            <input type=\"text\" name=\"name_prefix_prompt\" id=\"name_prefix_prompt\" size=\"15\" maxlength=\"15\" value=\"";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\" onFocus=\'checkLegalNames(1)\' onBlur=\"makeValidString(this)\">\n                        </td>\n                        <td width=\"18%\" class=\'fields\'>\n                           <!--  <input type=\"text\" name=\"name_prefix_loc_lang_prompt\" id=\"name_prefix_loc_lang_prompt\" size=\"15\" maxlength=\"15\" value=\"";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\" onFocus=\'checkLegalNames(1)\' ";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 =" onblur=\'makeValidString(this)\' > -->\n\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\n                        </td>\n                    </tr>\n                    <tr >\n                        <td class=\"label\" nowrap>";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="</td>\n\n                        <td class=\'fields\'>\n                        ";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\n                        </td>\n\t\t\t\t\t<td width=\"10%\">&nbsp;</td>\n                        <td class=\'fields\'>\n                        ";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\n                        </td>\n\t\n                        <td class=\'fields\'>\n                        ";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\n                        </td>\n\n                        <td class=\'fields\'>\n                            <input type=\"text\" name=\"first_name_prompt\" id=\"first_name_prompt\" size=\"15\" maxlength=\"15\" value=\"";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\" onFocus=\"checkLegalNames(2)\" onBlur=\"makeValidString(this)\">\n                        </td>\n                        <td class=\'fields\'>\n                           <!--  <input type=\"text\" name=\"first_name_loc_lang_prompt\" id=\"first_name_loc_lang_prompt\" size=\"15\" maxlength=\"15\" value=\"";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\" onFocus=\"checkLegalNames(2)\" ";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 =" > -->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\n\t\t\t\t\t\t  \n                        </td>\n                    </tr>\n\n                    <tr >\n                        <td class=\"label\" nowrap>";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\n                        </td>\n\n                        <td class=\'fields\'>\n                            <input type=\"text\" name=\"second_name_prompt\" id=\"second_name_prompt\" size=\"15\" maxlength=\"15\" value=\"";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\" onFocus=\'checkLegalNames(3)\' onBlur=\"makeValidString(this)\">\n                        </td>\n                        <td class=\'fields\'>\n                            <!-- <input type=\"text\" name=\"second_name_loc_lang_prompt\" id=\"second_name_loc_lang_prompt\" size=\"15\" maxlength=\"15\" value=\"";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\" onFocus=\'checkLegalNames(3)\' ";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 =" onblur=\'makeValidString(this)\'> -->\n\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\n                        </td>\n                    </tr>\n\n                    <tr >\n                        <td class=\"label\" nowrap>";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\n                        </td>\n\n                        <td class=\'fields\'>\n                            <input type=\"text\" name=\"third_name_prompt\" id=\"third_name_prompt\" size=\"15\" maxlength=\"15\" value=\"";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\" onFocus=\'checkLegalNames(4)\' onBlur=\"makeValidString(this)\">\n                        </td>\n                        <td class=\'fields\'>\n                            <!-- <input type=\"text\" name=\"third_name_loc_lang_prompt\" id=\"third_name_loc_lang_prompt\" size=\"15\" maxlength=\"15\" value=\"";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\" onFocus=\'checkLegalNames(4)\' ";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\n                        </td>\n\n                        <td class=\'fields\'>\n                            <input type=\"text\" name=\"family_name_prompt\" id=\"family_name_prompt\" size=\"15\" maxlength=\"15\" value=\"";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\" onFocus=\'checkLegalNames(5)\' onBlur=\"makeValidString(this)\">\n                        </td>\n                        <td class=\'fields\'>\n                            <!-- <input type=\"text\" name=\"family_name_loc_lang_prompt\" id=\"family_name_loc_lang_prompt\" size=\"15\" maxlength=\"15\" value=\"";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\" onFocus=\'checkLegalNames(5)\' ";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\n                        </td>\n                    </tr>\n\n                    <tr >\n                        <td class=\"label\">";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\n                        </td>\n\t\t\t\t\t\t<td width=\"10%\">&nbsp;</td>\n                        <td class=\'fields\'>\n                        ";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\n                        </td>\n\n                        <td class=\'label\'>\n                            &nbsp;\n                        </td>\n\n                        <td class=\'fields\'>\n                            <input type=\"text\" name=\"name_suffix_prompt\" id=\"name_suffix_prompt\" size=\"15\" maxlength=\"15\" value=\"";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\" onFocus=\'checkLegalNames(6)\' onBlur=\"makeValidString(this)\">\n                        </td>\n                        <td class=\'fields\' colspan=2>\n                        <!-- <input type=\"text\" name=\"name_suffix_loc_lang_prompt\" id=\"name_suffix_loc_lang_prompt\" size=\"15\" maxlength=\"15\" value=\"";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\" onFocus=\'checkLegalNames(6)\' ";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 =" onblur=\'makeValidString(this)\'>  -->\n\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\n                        </td>\n                    </tr>\n                </table>\n\t\t\t<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'100%\'>\n\t\t\t\t<tr> <td class=\'COLUMNHEADER\' colspan=\'4\'>";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="</td>\n\t\t\t</tr>\n\t\t\t <tr>\n                       <td class=\"label\" nowrap width=\'30%\'>";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="</td>\n                        <td  nowrap class=\'fields\' colspan=\'3\'>\n                        ";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\n\t\t\t\t\t\t <img src=\'../images/mandatory.gif\'></img>\n                        </td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'label\' nowrap >";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="\n              \t\t\t<img src=\'../images/mandatory.gif\' id=\'myimage\' style=\'visibility:hidden\'></img>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr >\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="\n\t\t\t\t\t\t\t<td class=\'label\' nowrap >";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="\n\t\t\t\t\t\t\t<td class=\'fields\' colspan=\'3\'><input type=\'text\' size=\'30\' maxlength=\'15\'  name = \'dflt_patient_name\' value=\'";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="\'>\n\t\t\t\t\t\t\t<img src=\'../images/mandatory.gif\' id=\'dflt_patient_name_mand\' style=\'visibility:hidden\'></img></td>\n                    </tr>\n\t\t\t\t\t\n\t\t\n    </table>\n\n\t\t<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'100%\'>\n\t\t\t\t<tr> <td class=\'COLUMNHEADER\' colspan=\'4\'>";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\n\t\t\t\t\t\t<!--  <img src=\'../images/mandatory.gif\'></img> -->\n                        </td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'label\' nowrap >";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="\n              \t\t\t\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\n    </table>\n\t\n\t<!--Added by Ashwini on 12-Oct-2020 for ML-MMOH-CRF-1551-->\n\t";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="\n\t<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'100%\'>\n\t\t<tr>\n\t\t\t<td class=\'COLUMNHEADER\' colspan=\'4\'>";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="</td>\n\t\t</tr>\n\t\t<tr>\n\t\t    <td class=\"label\" nowrap width=\'30%\'>";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="</td>\n\t\t\t<td  nowrap class=\'fields\' colspan=\'3\'>\n\t\t\t\t";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\n\t\t\t<img src=\'../images/mandatory.gif\'></img>\n\t\t\t</td>\n\t\t</tr>\n    </table>\n\t\n\t<!--Added by Ashwini on 12-Oct-2020 for ML-MMOH-CRF-1551.1-->\n\t<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'100%\'>\n\t\t<tr>\n\t\t\t<td class=\'COLUMNHEADER\' colspan=\'4\'>";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="\n\t\t\t<img src=\'../images/mandatory.gif\'></img>\n\t\t\t</td>\n\t\t</tr>\n    </table>\n\t<!--End ML-MMOH-CRF-1551.1-->\n\t";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="\n\t<!--End ML-MMOH-CRF-1551-->\n\n<!-- Border test start -->\n\n    </td>\n    </tr>\n    </table>\n\n\t</div>\n\n<!-- Border test end -->\n\n<!-- Ends Here -->\n\n<!-- Border test start --> \n\n\n<input type=\"hidden\" name=\"vairable_patient_id_length\" id=\"vairable_patient_id_length\" value=\"\">\n<input type=\"hidden\" name=\"nb_use_mother_ser1\" id=\"nb_use_mother_ser1\" value=\"";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="\">\n   <!-- INCLUDE HERE 9/13/2006 -->\n   \n   ";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="\n   ";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="\t\n   ";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="\n\t\t";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 =" \n\t\t";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="\n\t\t\n\t\t";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 ="\n\n\t\t";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="   \n\t\t";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="\t\t\t\n\t\t";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="\t\t\n\t\t";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 ="\t\n\t\t";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 =" \t\n\t\t";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="\t\n\t\t\n\t\t";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 =" \t\t\t\n\t\t";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 ="  \n\t\t";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="\n\t    ";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 =" \n\t    ";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 ="\n\t    \n";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 ="\ny";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 ="\n\n<!-- Border test end --> \n\n    \n    <!-- For tab 2 -->\n\n    <input type=\"hidden\" name=\"ethnic_sndx_type\" id=\"ethnic_sndx_type\"        value=\"";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );

    private final static java.lang.String  _wl_block267 ="\">\n    <input type=\'hidden\' name=\'general_alert_yn\' id=\'general_alert_yn\' value=\'N\'>\n    <!-- For tab 3 -->\n\n\t<!-- Hidden values of nat_id_count and alt_id_count-->\n\t\n\t<input type=\"hidden\" name=\"nat_id_count\" id=\"nat_id_count\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block267Bytes = _getBytes( _wl_block267 );

    private final static java.lang.String  _wl_block268 ="\">\n\t<input type=\"hidden\" name=\"alt_id_count\" id=\"alt_id_count\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block268Bytes = _getBytes( _wl_block268 );

    private final static java.lang.String  _wl_block269 ="\">\n\t\n\t<input type=\"hidden\" name=\"dflt_contact_mode1\" id=\"dflt_contact_mode1\"      value=\"";
    private final static byte[]  _wl_block269Bytes = _getBytes( _wl_block269 );

    private final static java.lang.String  _wl_block270 ="\">\n    <input type=\"hidden\" name=\"dflt_contact_mode2\" id=\"dflt_contact_mode2\"      value=\"";
    private final static byte[]  _wl_block270Bytes = _getBytes( _wl_block270 );

    private final static java.lang.String  _wl_block271 ="\">\n    <input type=\"hidden\" name=\"dflt_contact_mode3\" id=\"dflt_contact_mode3\"      value=\"";
    private final static byte[]  _wl_block271Bytes = _getBytes( _wl_block271 );

    private final static java.lang.String  _wl_block272 ="\">\n    <input type=\"hidden\" name=\"dflt_contact_mode4\" id=\"dflt_contact_mode4\"      value=\"";
    private final static byte[]  _wl_block272Bytes = _getBytes( _wl_block272 );

    private final static java.lang.String  _wl_block273 ="\">\n    <input type=\"hidden\" name=\"dflt_contact_mode5\" id=\"dflt_contact_mode5\"      value=\"";
    private final static byte[]  _wl_block273Bytes = _getBytes( _wl_block273 );

    private final static java.lang.String  _wl_block274 ="\">\n    <input type=\"hidden\" name=\"family_org_id_accept_yn_new\" id=\"family_org_id_accept_yn_new\"      value=\"N\">\n    <!--<input type=\"hidden\" name=\"name_in_oth_lang_yn\" id=\"name_in_oth_lang_yn\"     value=\"";
    private final static byte[]  _wl_block274Bytes = _getBytes( _wl_block274 );

    private final static java.lang.String  _wl_block275 ="\">-->\n\t\n\t<!--Added by Ashwini on 12-Oct-2020 for ML-MMOH-CRF-1551-->\n\t<input type=\"hidden\" name=\"isNameDervnLogicNBAppl\" id=\"isNameDervnLogicNBAppl\" value=\"";
    private final static byte[]  _wl_block275Bytes = _getBytes( _wl_block275 );

    private final static java.lang.String  _wl_block276 ="\">\n\n    <!-- For tab 6 -->\n\t\n    <input type=\"hidden\" name=\"hr_interface_yn\" id=\"hr_interface_yn\"     value=\"";
    private final static byte[]  _wl_block276Bytes = _getBytes( _wl_block276 );

    private final static java.lang.String  _wl_block277 ="\">\n    <input type=\"hidden\" name=\"his_interface_yn\" id=\"his_interface_yn\"        value=\"";
    private final static byte[]  _wl_block277Bytes = _getBytes( _wl_block277 );

    private final static java.lang.String  _wl_block278 ="\">\n    <input type=\"hidden\" name=\"age_limit_for_service\" id=\"age_limit_for_service\"   value=\"";
    private final static byte[]  _wl_block278Bytes = _getBytes( _wl_block278 );

    private final static java.lang.String  _wl_block279 ="\">\n    <input type=\"hidden\" name=\"hr_check_digit_scheme\" id=\"hr_check_digit_scheme\"   value=\"";
    private final static byte[]  _wl_block279Bytes = _getBytes( _wl_block279 );

    private final static java.lang.String  _wl_block280 ="\">\n    \n    <input type=\"hidden\" name=\"operation\" id=\"operation\"           value=\"";
    private final static byte[]  _wl_block280Bytes = _getBytes( _wl_block280 );

    private final static java.lang.String  _wl_block281 ="\">\n\t <input type=\"hidden\" name=\"module_instal_ind\" id=\"module_instal_ind\"     value=\"";
    private final static byte[]  _wl_block281Bytes = _getBytes( _wl_block281 );

    private final static java.lang.String  _wl_block282 ="\">\n";
    private final static byte[]  _wl_block282Bytes = _getBytes( _wl_block282 );

    private final static java.lang.String  _wl_block283 ="\n\t\t<input type=\"hidden\" name=\"chart_maintenance\" id=\"chart_maintenance\"       value=\"";
    private final static byte[]  _wl_block283Bytes = _getBytes( _wl_block283 );

    private final static java.lang.String  _wl_block284 ="\">\n        <input type=\"hidden\" name=\"separate_file_no_yn\" id=\"separate_file_no_yn\"     value=\"";
    private final static byte[]  _wl_block284Bytes = _getBytes( _wl_block284 );

    private final static java.lang.String  _wl_block285 ="\">\n        <input type=\"hidden\" name=\"name_prefix_accept_yn\" id=\"name_prefix_accept_yn\"   value=\"";
    private final static byte[]  _wl_block285Bytes = _getBytes( _wl_block285 );

    private final static java.lang.String  _wl_block286 ="\">\n        <input type=\"hidden\" name=\"name_prefix_reqd_yn\" id=\"name_prefix_reqd_yn\"     value=\"";
    private final static byte[]  _wl_block286Bytes = _getBytes( _wl_block286 );

    private final static java.lang.String  _wl_block287 ="\">\n        <input type=\"hidden\" name=\"first_name_accept_yn\" id=\"first_name_accept_yn\"    value=\"";
    private final static byte[]  _wl_block287Bytes = _getBytes( _wl_block287 );

    private final static java.lang.String  _wl_block288 ="\">\n        <input type=\"hidden\" name=\"first_name_reqd_yn\" id=\"first_name_reqd_yn\"      value=\"";
    private final static byte[]  _wl_block288Bytes = _getBytes( _wl_block288 );

    private final static java.lang.String  _wl_block289 ="\">\n        <input type=\"hidden\" name=\"second_name_accept_yn\" id=\"second_name_accept_yn\"   value=\"";
    private final static byte[]  _wl_block289Bytes = _getBytes( _wl_block289 );

    private final static java.lang.String  _wl_block290 ="\">\n        <input type=\"hidden\" name=\"second_name_reqd_yn\" id=\"second_name_reqd_yn\"     value=\"";
    private final static byte[]  _wl_block290Bytes = _getBytes( _wl_block290 );

    private final static java.lang.String  _wl_block291 ="\">\n        <input type=\"hidden\" name=\"second_name_order\" id=\"second_name_order\"       value=\"";
    private final static byte[]  _wl_block291Bytes = _getBytes( _wl_block291 );

    private final static java.lang.String  _wl_block292 ="\">\n        <input type=\"hidden\" name=\"third_name_accept_yn\" id=\"third_name_accept_yn\"    value=\"";
    private final static byte[]  _wl_block292Bytes = _getBytes( _wl_block292 );

    private final static java.lang.String  _wl_block293 ="\">\n        <input type=\"hidden\" name=\"third_name_reqd_yn\" id=\"third_name_reqd_yn\"      value=\"";
    private final static byte[]  _wl_block293Bytes = _getBytes( _wl_block293 );

    private final static java.lang.String  _wl_block294 ="\">\n        <input type=\"hidden\" name=\"third_name_order\" id=\"third_name_order\"        value=\"";
    private final static byte[]  _wl_block294Bytes = _getBytes( _wl_block294 );

    private final static java.lang.String  _wl_block295 ="\">\n        <input type=\"hidden\" name=\"family_name_accept_yn\" id=\"family_name_accept_yn\"   value=\"";
    private final static byte[]  _wl_block295Bytes = _getBytes( _wl_block295 );

    private final static java.lang.String  _wl_block296 ="\">\n        <input type=\"hidden\" name=\"family_name_reqd_yn\" id=\"family_name_reqd_yn\"     value=\"";
    private final static byte[]  _wl_block296Bytes = _getBytes( _wl_block296 );

    private final static java.lang.String  _wl_block297 ="\">\n        <input type=\"hidden\" name=\"family_name_order\" id=\"family_name_order\"       value=\"";
    private final static byte[]  _wl_block297Bytes = _getBytes( _wl_block297 );

    private final static java.lang.String  _wl_block298 ="\">\n        <input type=\"hidden\" name=\"name_suffix_accept_yn\" id=\"name_suffix_accept_yn\"   value=\"";
    private final static byte[]  _wl_block298Bytes = _getBytes( _wl_block298 );

    private final static java.lang.String  _wl_block299 ="\">\n        <input type=\"hidden\" name=\"name_suffix_reqd_yn\" id=\"name_suffix_reqd_yn\"     value=\"";
    private final static byte[]  _wl_block299Bytes = _getBytes( _wl_block299 );

    private final static java.lang.String  _wl_block300 ="\">\n        <input type=\"hidden\" name=\"alt_id1_type\" id=\"alt_id1_type\"            value=\"";
    private final static byte[]  _wl_block300Bytes = _getBytes( _wl_block300 );

    private final static java.lang.String  _wl_block301 ="\">\n        <input type=\"hidden\" name=\"alt_id1_length\" id=\"alt_id1_length\"      value=\"";
    private final static byte[]  _wl_block301Bytes = _getBytes( _wl_block301 );

    private final static java.lang.String  _wl_block302 ="\">\n        <input type=\"hidden\" name=\"alt_id1_len_validation_yn\" id=\"alt_id1_len_validation_yn\" value =\"";
    private final static byte[]  _wl_block302Bytes = _getBytes( _wl_block302 );

    private final static java.lang.String  _wl_block303 ="\"> \n        <input type=\"hidden\" name=\"alt_id1_reqd_yn\" id=\"alt_id1_reqd_yn\"     value=\"";
    private final static byte[]  _wl_block303Bytes = _getBytes( _wl_block303 );

    private final static java.lang.String  _wl_block304 ="\">\n        <input type=\"hidden\" name=\"alt_id1_exp_date_accept_yn\" id=\"alt_id1_exp_date_accept_yn\" value =\"";
    private final static byte[]  _wl_block304Bytes = _getBytes( _wl_block304 );

    private final static java.lang.String  _wl_block305 ="\"> \n        <input type=\"hidden\" name=\"alt_id1_unique_yn\" id=\"alt_id1_unique_yn\"       value=\"";
    private final static byte[]  _wl_block305Bytes = _getBytes( _wl_block305 );

    private final static java.lang.String  _wl_block306 ="\">\n        <input type=\"hidden\" name=\"alt_id1_exp_warn_yn\" id=\"alt_id1_exp_warn_yn\"     value=\"";
    private final static byte[]  _wl_block306Bytes = _getBytes( _wl_block306 );

    private final static java.lang.String  _wl_block307 ="\">\n        <input type=\"hidden\" name=\"alt_id2_type\" id=\"alt_id2_type\"            value=\"";
    private final static byte[]  _wl_block307Bytes = _getBytes( _wl_block307 );

    private final static java.lang.String  _wl_block308 ="\">\n        <input type=\"hidden\" name=\"alt_id2_length\" id=\"alt_id2_length\"      value=\"";
    private final static byte[]  _wl_block308Bytes = _getBytes( _wl_block308 );

    private final static java.lang.String  _wl_block309 ="\">\n        <input type=\"hidden\" name=\"alt_id2_len_validation_yn\" id=\"alt_id2_len_validation_yn\" value =\"";
    private final static byte[]  _wl_block309Bytes = _getBytes( _wl_block309 );

    private final static java.lang.String  _wl_block310 ="\">\n        <input type=\"hidden\" name=\"alt_id2_reqd_yn\" id=\"alt_id2_reqd_yn\"     value=\"";
    private final static byte[]  _wl_block310Bytes = _getBytes( _wl_block310 );

    private final static java.lang.String  _wl_block311 ="\">\n        <input type=\"hidden\" name=\"alt_id2_exp_date_accept_yn\" id=\"alt_id2_exp_date_accept_yn\" value =\"";
    private final static byte[]  _wl_block311Bytes = _getBytes( _wl_block311 );

    private final static java.lang.String  _wl_block312 ="\">\n        <input type=\"hidden\" name=\"alt_id2_unique_yn\" id=\"alt_id2_unique_yn\"       value=\"";
    private final static byte[]  _wl_block312Bytes = _getBytes( _wl_block312 );

    private final static java.lang.String  _wl_block313 ="\">\n        <input type=\"hidden\" name=\"alt_id2_exp_warn_yn\" id=\"alt_id2_exp_warn_yn\"     value=\"";
    private final static byte[]  _wl_block313Bytes = _getBytes( _wl_block313 );

    private final static java.lang.String  _wl_block314 ="\">\n        <input type=\"hidden\" name=\"alt_id3_type\" id=\"alt_id3_type\"            value=\"";
    private final static byte[]  _wl_block314Bytes = _getBytes( _wl_block314 );

    private final static java.lang.String  _wl_block315 ="\">\n        <input type=\"hidden\" name=\"alt_id3_length\" id=\"alt_id3_length\"      value=\"";
    private final static byte[]  _wl_block315Bytes = _getBytes( _wl_block315 );

    private final static java.lang.String  _wl_block316 ="\">\n        <input type=\"hidden\" name=\"alt_id3_len_validation_yn\" id=\"alt_id3_len_validation_yn\" value =\"";
    private final static byte[]  _wl_block316Bytes = _getBytes( _wl_block316 );

    private final static java.lang.String  _wl_block317 ="\">\n        <input type=\"hidden\" name=\"alt_id3_reqd_yn\" id=\"alt_id3_reqd_yn\"     value=\"";
    private final static byte[]  _wl_block317Bytes = _getBytes( _wl_block317 );

    private final static java.lang.String  _wl_block318 ="\">\n        <input type=\"hidden\" name=\"alt_id3_exp_date_accept_yn\" id=\"alt_id3_exp_date_accept_yn\" value =\"";
    private final static byte[]  _wl_block318Bytes = _getBytes( _wl_block318 );

    private final static java.lang.String  _wl_block319 ="\">\n        <input type=\"hidden\" name=\"alt_id3_unique_yn\" id=\"alt_id3_unique_yn\"       value=\"";
    private final static byte[]  _wl_block319Bytes = _getBytes( _wl_block319 );

    private final static java.lang.String  _wl_block320 ="\">\n        <input type=\"hidden\" name=\"alt_id3_exp_warn_yn\" id=\"alt_id3_exp_warn_yn\"     value=\"";
    private final static byte[]  _wl_block320Bytes = _getBytes( _wl_block320 );

    private final static java.lang.String  _wl_block321 ="\">\n        <input type=\"hidden\" name=\"alt_id4_type\" id=\"alt_id4_type\"            value=\"";
    private final static byte[]  _wl_block321Bytes = _getBytes( _wl_block321 );

    private final static java.lang.String  _wl_block322 ="\">\n        <input type=\"hidden\" name=\"alt_id4_length\" id=\"alt_id4_length\"      value=\"";
    private final static byte[]  _wl_block322Bytes = _getBytes( _wl_block322 );

    private final static java.lang.String  _wl_block323 ="\">\n        <input type=\"hidden\" name=\"alt_id4_len_validation_yn\" id=\"alt_id4_len_validation_yn\" value =\"";
    private final static byte[]  _wl_block323Bytes = _getBytes( _wl_block323 );

    private final static java.lang.String  _wl_block324 ="\">\n        <input type=\"hidden\" name=\"alt_id4_reqd_yn\" id=\"alt_id4_reqd_yn\"     value=\"";
    private final static byte[]  _wl_block324Bytes = _getBytes( _wl_block324 );

    private final static java.lang.String  _wl_block325 ="\">\n        <input type=\"hidden\" name=\"alt_id4_exp_date_accept_yn\" id=\"alt_id4_exp_date_accept_yn\" value =\"";
    private final static byte[]  _wl_block325Bytes = _getBytes( _wl_block325 );

    private final static java.lang.String  _wl_block326 ="\">\n        <input type=\"hidden\" name=\"alt_id4_unique_yn\" id=\"alt_id4_unique_yn\"       value=\"";
    private final static byte[]  _wl_block326Bytes = _getBytes( _wl_block326 );

    private final static java.lang.String  _wl_block327 ="\">\n        <input type=\"hidden\" name=\"alt_id4_exp_warn_yn\" id=\"alt_id4_exp_warn_yn\"     value=\"";
    private final static byte[]  _wl_block327Bytes = _getBytes( _wl_block327 );

    private final static java.lang.String  _wl_block328 ="\">\n\n        <input type=\"hidden\" name=\"mpDisableFieldsNBFather\" id=\"mpDisableFieldsNBFather\"     value=\"";
    private final static byte[]  _wl_block328Bytes = _getBytes( _wl_block328 );

    private final static java.lang.String  _wl_block329 ="\">\n       \n\t\t<input type=\"hidden\" name=\"dcount\" id=\"dcount\" >\n\t\t<input type=\"hidden\" name=\"ccount\" id=\"ccount\" >\n\t\t<input type=\"hidden\" name=\"fcount\" id=\"fcount\" >\n\t\t<input type=\"hidden\" name=\"ecount\" id=\"ecount\">\n\t\t<input type=\"hidden\" name=\"ocount\" id=\"ocount\">\n\t\t<input type=\"hidden\" name=\"ncount\" id=\"ncount\">\n        ";
    private final static byte[]  _wl_block329Bytes = _getBytes( _wl_block329 );

    private final static java.lang.String  _wl_block330 ="\n\t\t<input type=\"hidden\" name=\"dcount\" id=\"dcount\" >\n\t\t<input type=\"hidden\" name=\"ccount\" id=\"ccount\" >\n\t\t<input type=\"hidden\" name=\"fcount\" id=\"fcount\" >\n\t\t<input type=\"hidden\" name=\"ecount\" id=\"ecount\">\n\t\t<input type=\"hidden\" name=\"ocount\" id=\"ocount\">\n\t\t<input type=\"hidden\" name=\"ncount\" id=\"ncount\">\n\t\t";
    private final static byte[]  _wl_block330Bytes = _getBytes( _wl_block330 );

    private final static java.lang.String  _wl_block331 ="\n    </form>\n</center>\n\t\t<script>\n\t\t\t//onLoad=\'enableNatFields(document.mp_param_form.accept_national_id_no_yn);\'\n\t\t\tenableNatFields(document.mp_param_form.accept_national_id_no_yn,\'Y\');\n\t\t\tassignCountValues();\n\t\t</script>\n</body>\n<script>checkValidity()</script>\n";
    private final static byte[]  _wl_block331Bytes = _getBytes( _wl_block331 );

    private final static java.lang.String  _wl_block332 ="\n\t\t<script>document.getElementById(\'dflt_patient_name_mand\').style.visibility= \'visible\';</script>\n\t\t";
    private final static byte[]  _wl_block332Bytes = _getBytes( _wl_block332 );

    private final static java.lang.String  _wl_block333 ="\n</html>\n\n\t";
    private final static byte[]  _wl_block333Bytes = _getBytes( _wl_block333 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);


	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection con=null ;
    PreparedStatement pstmt=null ;
    ResultSet rs=null ;
    PreparedStatement pstmt1=null ;
    ResultSet rs1=null ;
    java.sql.Statement stmt11 = null;
    ResultSet rset11 = null;
    java.sql.Statement stmt = null ;
    ResultSet rset = null;
	PreparedStatement pst=null;
	PreparedStatement pst1=null;
	ResultSet res=null;
	ResultSet res1=null;
	
	//<!--Added by Himanshu Saxena on 30-Jun-2023 for AAKH-CRF-0175 US1 Starts-->
	PreparedStatement pstmt_rh=null ;
	ResultSet rs_rh=null;
	String function_name="";
	//<!--Added by Himanshu Saxena on 30-Jun-2023 for AAKH-CRF-0175 US1 ends-->

	int count=0;
	
	String enabledisable = "disabled" ;
	
	//Added by Ashwini on 12-Oct-2020 for ML-MMOH-CRF-1551
	Boolean isNameDervnLogicNBAppl = false;
	Boolean isStartWith = false; 

	try
	{
    con = ConnectionManager.getConnection(request);

	Boolean isUHID_valid_appl = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","UHID_VALID_DAYS_APPL"); // Added by mujafar for AMRI-CRF-0357

	isStartWith = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","MP_START_WITH"); 
	isNameDervnLogicNBAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"MP","NEWBORN_NAME_DERV_LOGIC");
	Boolean mpDisableFieldsNBFather = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","MP_DISABLE_FIELDS_NB_FATHER");
	String name_dervn_logic_nb = "";
		boolean isNatIdAltIdMandVisaType	= eCommon.Common.CommonBean.isSiteSpecific(con, "MP","MP_VAL_VISA_TYPE");	//Maheshwaran added for AAKH-CRF-0145 as on 22-04-2022
	//Added by Ashwini on 12-Oct-2020 for ML-MMOH-CRF-1551.1
	String name_dervn_logic_nb_sb = "";
	
	String dflt_alt_id1_in_emp_id_yn     =  checkForNull(request.getParameter("dflt_alt_id1_in_emp_id_yn")); 
	String accept_pw_in_chng_pat_dtl_yn     =  checkForNull(request.getParameter("accept_pw_in_chng_pat_dtl_yn")); 
	String acpt_appt_rfrl_in_reg_pat_yn  =  checkForNull(request.getParameter("acpt_appt_rfrl_in_reg_pat_yn"));
	String module_id                     =  checkForNull(request.getParameter( "module_id"            )) ;
    String patient_id_length             =  checkForNull(request.getParameter( "patient_id_length"        ));
    String patient_no_ctrl               =  checkForNull(request.getParameter( "patient_no_ctrl"      ));

	String gen_pat_ser_grp               =  checkForNull(request.getParameter( "gen_pat_ser_grp"      ));
    String nat_id_pat_ser_grp            =  checkForNull(request.getParameter( "nat_id_pat_ser_grp"       ));
    String alt_id_pat_ser_grp            =  checkForNull(request.getParameter( "alt_id_pat_ser_grp"       )) ;
    String family_no_pat_ser_grp         =  checkForNull(request.getParameter( "family_no_pat_ser_grp"    ));
    String dflt_pat_ser_grp_type         =  checkForNull(request.getParameter( "dflt_pat_ser_grp_type"    ));
    String emeg_pat_ser_grp              =  checkForNull(request.getParameter( "emeg_pat_ser_grp"         ));
    String newborn_pat_ser_grp           =  checkForNull(request.getParameter( "newborn_pat_ser_grp"      ));
    String nat_id_length                 =  checkForNull(request.getParameter( "nat_id_length"            ));
    String name_dervn_logic              =  checkForNull(request.getParameter( "name_dervn_logic"         ));
    String name_dervn_logic_oth_lang     =  checkForNull(request.getParameter( "name_dervn_logic_oth_lang"         ));

	String name_dervn_logic_long              =  checkForNull(request.getParameter( "name_dervn_logic_long"         ));
    String name_dervn_logic_oth_lang_long     =  checkForNull(request.getParameter( "name_dervn_logic_oth_lang_long"         ));

    String dflt_patient_name     =  checkForNull(request.getParameter( "dflt_patient_name"         ));
    String ethnic_sndx_type              =  checkForNull(request.getParameter( "ethnic_sndx_type"         ));
    String family_no_link_yn             =  checkForNull(request.getParameter( "family_no_link_yn"        ));
    String head_patient_no_use_yn        =  checkForNull(request.getParameter( "head_patient_no_use_yn"   ));
    String family_org_id_accept_yn       =  checkForNull(request.getParameter( "family_org_id_accept_yn"  ));
    String citizen_nationality_code      =  checkForNull(request.getParameter( "citizen_nationality_code"     ));
    String default_race_code		     =  checkForNull(request.getParameter( "default_race_code"     ));
	
    String default_relationship_code		     =  checkForNull(request.getParameter( "default_relationship_code"     ));
    String general_alert_yn              =  checkForNull(request.getParameter( "general_alert_yn"         ));
    String suspend_service_yn            =  checkForNull(request.getParameter( "suspend_service_yn"       ));
    String single_or_multi_files_ind     =  checkForNull(request.getParameter( "single_or_multi_files_ind"    ));
    String separate_file_no_yn           =  checkForNull(request.getParameter( "separate_file_no_yn"      ));
    String ext_system_interface_yn       =  checkForNull(request.getParameter( "ext_system_interface_yn"  ));
	if(ext_system_interface_yn==null || ext_system_interface_yn=="")
    ext_system_interface_yn="N";
    String name_prefix_accept_yn         =  checkForNull(request.getParameter( "name_prefix_accept_yn"    ));
    String name_prefix_reqd_yn           =  checkForNull(request.getParameter( "name_prefix_reqd_yn"      ));
    String name_prefix_prompt            =  checkForNull(request.getParameter( "name_prefix_prompt"       ));
    String name_prefix_loc_lang_prompt   =  checkForNull(request.getParameter( "name_prefix_loc_lang_prompt" ));
    String first_name_accept_yn          =  checkForNull(request.getParameter( "first_name_accept_yn"     ));
    String first_name_reqd_yn            =  checkForNull(request.getParameter( "first_name_reqd_yn"       ));
    String first_name_order              =  checkForNull(request.getParameter( "first_name_order"         ));
    String first_name_prompt             =  checkForNull(request.getParameter( "first_name_prompt"        ));
    String first_name_loc_lang_prompt    =  checkForNull(request.getParameter( "first_name_loc_lang_prompt"  ));
    String second_name_accept_yn         =  checkForNull(request.getParameter( "second_name_accept_yn"    ));
    String second_name_reqd_yn           =  checkForNull(request.getParameter( "second_name_reqd_yn"      ));
    String second_name_order             =  checkForNull(request.getParameter( "second_name_order"        ));
    String second_name_prompt            =  checkForNull(request.getParameter( "second_name_prompt"       ));
    String second_name_loc_lang_prompt   =  checkForNull(request.getParameter( "second_name_loc_lang_prompt"       ));
	String pat_name_as_multipart_yn		 =  checkForNull(request.getParameter("pat_name_as_multipart_yn"));
	String third_name_accept_yn          =  checkForNull(request.getParameter( "third_name_accept_yn"     ));
    String third_name_reqd_yn            =  checkForNull(request.getParameter( "third_name_reqd_yn"       ));
    String third_name_order              =  checkForNull(request.getParameter( "third_name_order"         ));
    String third_name_prompt             =  checkForNull(request.getParameter( "third_name_prompt"        ));
    String third_name_loc_lang_prompt    =  checkForNull(request.getParameter( "third_name_loc_lang_prompt"  ));
    String family_name_accept_yn         =  checkForNull(request.getParameter( "family_name_accept_yn"    ));
    String family_name_reqd_yn           =  checkForNull(request.getParameter( "family_name_reqd_yn"      ));
    String family_name_order             =  checkForNull(request.getParameter( "family_name_order"        ));
    String family_name_prompt            =  checkForNull(request.getParameter( "family_name_prompt"       ));
    String family_name_loc_lang_prompt   =  checkForNull(request.getParameter( "family_name_loc_lang_prompt"));
    String family_name_prefix_yn         =  checkForNull(request.getParameter( "family_name_prefix_yn"    ));
    String name_suffix_accept_yn         =  checkForNull(request.getParameter( "name_suffix_accept_yn"    ));
    String name_suffix_reqd_yn           =  checkForNull(request.getParameter( "name_suffix_reqd_yn"      ));
    String name_suffix_prompt            =  checkForNull(request.getParameter( "name_suffix_prompt"       ));
    String name_suffix_loc_lang_prompt   =  checkForNull(request.getParameter( "name_suffix_loc_lang_prompt" ));
    String names_in_oth_lang_yn          =  checkForNull(request.getParameter( "names_in_oth_lang_yn"     ));
    String dflt_sndx_type                =  checkForNull(request.getParameter( "dflt_sndx_type"           ));
    String dflt_coded_pseudo_name        =  checkForNull(request.getParameter( "dflt_coded_pseudo_name"   ));
    String alt_id1_type                  =  checkForNull(request.getParameter( "alt_id1_type"         ));
    String alt_id1_length                =  checkForNull(request.getParameter( "alt_id1_length"           ));
    String alt_id1_chk_digit_scheme      =  checkForNull(request.getParameter( "alt_id1_chk_digit_scheme" ));
    String alt_id1_reqd_yn               =  checkForNull(request.getParameter( "alt_id1_reqd_yn"      ));
    String alt_id1_unique_yn             =  checkForNull(request.getParameter( "alt_id1_unique_yn"        ));
    String alt_id1_exp_warn_yn           =  checkForNull(request.getParameter( "alt_id1_exp_warn_yn"      ));
    String alt_id1_exp_grace_days        =  checkForNull(request.getParameter( "alt_id1_exp_grace_days"   ));
    String alt_id2_type                  =  checkForNull(request.getParameter( "alt_id2_type"         ));
    String alt_id2_length                =  checkForNull(request.getParameter( "alt_id2_length"           ));
    String alt_id2_chk_digit_scheme      =  checkForNull(request.getParameter( "alt_id2_chk_digit_scheme" ));
    String alt_id2_reqd_yn               =  checkForNull(request.getParameter( "alt_id2_reqd_yn"      ));
    String alt_id2_unique_yn             =  checkForNull(request.getParameter( "alt_id2_unique_yn"        ));
    String alt_id2_exp_warn_yn           =  checkForNull(request.getParameter( "alt_id2_exp_warn_yn"      ));
    String alt_id2_exp_grace_days        =  checkForNull(request.getParameter( "alt_id2_exp_grace_days"));
    String alt_id3_type                  =  checkForNull(request.getParameter( "alt_id3_type"         ));
    String alt_id3_length                =  checkForNull(request.getParameter( "alt_id3_length"           ));
    String alt_id3_chk_digit_scheme      =  checkForNull(request.getParameter( "alt_id3_chk_digit_scheme" ));
    String alt_id3_reqd_yn               =  checkForNull(request.getParameter( "alt_id3_reqd_yn"      ));
    String alt_id3_unique_yn             =  checkForNull(request.getParameter( "alt_id3_unique_yn"        ));
    String alt_id3_exp_warn_yn           =  checkForNull(request.getParameter( "alt_id3_exp_warn_yn"      ));
    String alt_id3_exp_grace_days        =  checkForNull(request.getParameter( "alt_id3_exp_grace_days"   ));
    String alt_id4_type                  =  checkForNull(request.getParameter( "alt_id4_type"         ));
    String alt_id4_length                =  checkForNull(request.getParameter( "alt_id4_length"           ));
    String alt_id4_chk_digit_scheme      =  checkForNull(request.getParameter( "alt_id4_chk_digit_scheme" ));
    String alt_id4_reqd_yn               =  checkForNull(request.getParameter( "alt_id4_reqd_yn"      ));
    String alt_id4_unique_yn             =  checkForNull(request.getParameter( "alt_id4_unique_yn"        ));
    String alt_id4_exp_warn_yn           =  checkForNull(request.getParameter( "alt_id4_exp_warn_yn"      ));
    String alt_id4_exp_grace_days        =  checkForNull(request.getParameter( "alt_id4_exp_grace_days"   ));
    String family_no_prompt              =  checkForNull(request.getParameter( "family_no_prompt"     ));
    String pat_access_hist_no_rec        =  checkForNull(request.getParameter( "pat_access_hist_no_rec"   ));
    String pat_access_hist_bld_method    =  checkForNull(request.getParameter( "pat_access_hist_bld_method"   ));
    String dflt_contact_mode1            =  checkForNull(request.getParameter( "dflt_contact_mode1"       ));
    String dflt_contact_mode2            =  checkForNull(request.getParameter( "dflt_contact_mode2"       ));
    String dflt_contact_mode3            =  checkForNull(request.getParameter( "dflt_contact_mode3"       ));
    String dflt_contact_mode4            =  checkForNull(request.getParameter( "dflt_contact_mode4"       ));
    String dflt_contact_mode5            =  checkForNull(request.getParameter( "dflt_contact_mode5"       ));
    String dflt_addr_type1               =  checkForNull(request.getParameter( "dflt_addr_type1"      ));
    String dflt_addr_type2               =  checkForNull(request.getParameter( "dflt_addr_type2"      ));
    String dflt_addr_type3               =  checkForNull(request.getParameter( "dflt_addr_type3"      ));
    String dflt_addr_type4               =  checkForNull(request.getParameter( "dflt_addr_type4"      ));
    String dflt_addr_type5               =  checkForNull(request.getParameter( "dflt_addr_type5"      ));
    String dflt_rel_contact_role1        =  checkForNull(request.getParameter( "dflt_rel_contact_role1"   ));
    String dflt_rel_contact_role2        =  checkForNull(request.getParameter( "dflt_rel_contact_role2"   ));
    String dflt_rel_contact_role3        =  checkForNull(request.getParameter( "dflt_rel_contact_role3"   ));
    String dflt_rel_contact_role4        =  checkForNull(request.getParameter( "dflt_rel_contact_role4"   ));
    String dflt_rel_contact_role5        =  checkForNull(request.getParameter( "dflt_rel_contact_role5"   ));
    String dflt_doc1_type                =  checkForNull(request.getParameter( "dflt_doc1_type"           ));
    String dflt_doc2_type                =  checkForNull(request.getParameter( "dflt_doc2_type"           ));
    String dflt_doc3_type                =  checkForNull(request.getParameter( "dflt_doc3_type"           ));
    String dflt_doc4_type                =  checkForNull(request.getParameter( "dflt_doc4_type"           ));
    String dflt_doc5_type                =  checkForNull(request.getParameter( "dflt_doc5_type"           ));
    String dflt_pat_fin_class            =  checkForNull(request.getParameter( "dflt_pat_fin_class"       ));
    String prompt_pat_fin_class_yn       =  checkForNull(request.getParameter( "prompt_pat_fin_class_yn"  ));
    String allow_nb_regn_within_days     =  checkForNull(request.getParameter( "allow_nb_regn_within_days"    ));
	String mul_birth_regn_within_hours     =  checkForNull(request.getParameter( "mul_birth_regn_within_hours"    ));
	String min_age_of_moth               =  checkForNull(request.getParameter( "nb_mother_min_age"    ));
   	String max_age_of_moth               =  checkForNull(request.getParameter( "nb_mother_upper_age"    ));
	String cut_age_of_moth               =  checkForNull(request.getParameter( "nb_mother_cutoff_age"    ));
	String dft_rel_male_nb               =  checkForNull(request.getParameter( "nb_male_relnship"    ));
	String dft_rel_female_nb             =  checkForNull(request.getParameter( "nb_female_relnship"    ));
	String dft_rel_unknown_nb            =  checkForNull(request.getParameter( "nb_unknown_relnship"    ));
	String allow_nb_regn_unit            =  checkForNull(request.getParameter( "allow_nb_regn_unit"    ));
	String Accept_oth_alt_id_yn          =  checkForNull(request.getParameter( "Accept_oth_alt_id_yn"    ));
    String min_age_of_fath               =  checkForNull(request.getParameter( "nb_father_min_age"    ));
    String unit_of_wt_nb                 =  checkForNull(request.getParameter( "unit_of_wt_nb"            ));
    String unit_of_circum_nb             =  checkForNull(request.getParameter( "unit_of_circum_nb"        ));
    String unit_of_chest_circum_nb             =  checkForNull(request.getParameter( "unit_of_chest_circum_nb"        ));
    String unit_of_length_nb             =  checkForNull(request.getParameter( "unit_of_length_nb"        ));
    String unit_of_gest_nb               =  checkForNull(request.getParameter( "unit_of_gest_nb" ));
    String sub_multi_birth_hw               =  checkForNull(request.getParameter( "sub_multi_birth_hw" ));
    String name_suffix_male_nb           =  checkForNull(request.getParameter( "name_suffix_male_nb"      ));
    String name_suffix_female_nb         =  checkForNull(request.getParameter( "name_suffix_female_nb"    ));
    String name_prefix_male_nb           =  checkForNull(request.getParameter( "name_prefix_male_nb"      ));  
    String name_prefix_unknown_nb           =  checkForNull(request.getParameter( "name_prefix_unknown_nb"      )); // Added by Afruddin for ML-MMOH-CRF-1520 US001 on 4.05.2020
    String name_prefix_female_nb         =  checkForNull(request.getParameter( "name_prefix_female_nb"    ));
	String still_born_prefix			 = "";
	// New parameter is added for RUT-CRF-0007-MPI (IN023391) on 16.09.2010 by Suresh M
	String pat_photo_renewal_alert_days	= "";

	
	String fatherValue	= "";
	String maritalValue	= "";
	String enable_marital_status    = checkForNull( request.getParameter( "enable_marital_status") ) ;
    String dflt_father_first_name_prompt    = checkForNull( request.getParameter( "dflt_father_first_name_prompt") ) ;
    String dflt_father_Second_name_prompt    = checkForNull( request.getParameter( "dflt_father_Second_name_prompt") ) ;
    String dflt_father_third_name_prompt    = checkForNull( request.getParameter( "dflt_father_third_name_prompt") ) ;
    String dflt_father_family_name_prompt    = checkForNull( request.getParameter( "dflt_father_family_name_prompt") ) ;


	String nb_father_name_mandatory_yn   =  checkForNull(request.getParameter( "nb_father_name_mandatory_yn"    ));
	String nb_mother_dtls_update_yn=checkForNull(request.getParameter( "nb_mother_dtls_update_yn"    ));//Added for HSA-CRF-0182

	/*Below Added by Rameswar on 3rd July 2015 for MO-CRF-20099 [IN054280]*/
	String ALT_ID1_PAT_SCH_EXACT_YN=checkForNull(request.getParameter( "ALT_ID1_PAT_SCH_EXACT_YN"    ));
	String ALT_ID2_PAT_SCH_EXACT_YN=checkForNull(request.getParameter( "ALT_ID2_PAT_SCH_EXACT_YN"    ));
	String ALT_ID3_PAT_SCH_EXACT_YN=checkForNull(request.getParameter( "ALT_ID3_PAT_SCH_EXACT_YN"    ));
	String ALT_ID4_PAT_SCH_EXACT_YN=checkForNull(request.getParameter( "ALT_ID4_PAT_SCH_EXACT_YN"    ));
	

	String data_upd_allowed_aft_final_yn            =  checkForNull(request.getParameter( "data_upd_allowed_aft_final_yn"    ));
	String upt_contact_dtls_oa_yn		 = "";//added  changes   for HSA-CRF-0226 [IN:050599] 
	String accept_names_for_live_birth_yn="";

	String dflt_race_nat_setup_nb_as_per=  checkForNull(request.getParameter( "dflt_race_nat_setup_nb_as_per"    ));

    String review_nb_links_bef_reg_yn    =  checkForNull(request.getParameter( "review_nb_links_bef_reg_yn"   ));

	
	String length_of_baby_yn     = checkForNull( request.getParameter( "length_of_baby_yn") );
	String head_circumference_of_baby_yn     = checkForNull( request.getParameter( "head_circumference_of_baby_yn") );
	
	String mandate_first_newborn_yn = checkForNull( request.getParameter( "mandate_first_newborn_yn") );
	String mandate_first_newborn_ip_yn = checkForNull( request.getParameter( "mandate_first_newborn_ip_yn") );
	String mandate_first_newborn_ae_yn = checkForNull( request.getParameter( "mandate_first_newborn_ae_yn") );
	String mandate_second_newborn_yn = checkForNull( request.getParameter( "mandate_second_newborn_yn") );
	String mandate_second_newborn_ip_yn = checkForNull( request.getParameter( "mandate_second_newborn_ip_yn") );
	String mandate_second_newborn_ae_yn = checkForNull( request.getParameter( "mandate_second_newborn_ae_yn") );
	String mandate_third_newborn_yn = checkForNull( request.getParameter( "mandate_third_newborn_yn") );
	String mandate_third_newborn_ip_yn = checkForNull( request.getParameter( "mandate_third_newborn_ip_yn") );
	String mandate_third_newborn_ae_yn = checkForNull( request.getParameter( "mandate_third_newborn_ae_yn") );
	String mand_antenatal_newborn_yn = checkForNull( request.getParameter( "mand_antenatal_newborn_yn") );
	String mand_antenatal_newborn_ip_yn = checkForNull( request.getParameter( "mand_antenatal_newborn_ip_yn") );
	String mand_antenatal_newborn_ae_yn = checkForNull( request.getParameter( "mand_antenatal_newborn_ae_yn") );
	//Added by Jeyachitra ML-MMOH-CRF-1759.1-US001 starts
	String mand_parity_newborn_yn = checkForNull( request.getParameter( "mand_parity_newborn_yn") );
	String mand_parity_newborn_ip_yn = checkForNull( request.getParameter( "mand_parity_newborn_ip_yn") );
	String mand_parity_newborn_ae_yn = checkForNull( request.getParameter( "mand_parity_newborn_ae_yn") );
	String invoke_menstrual_history_yn = checkForNull(request.getParameter("invoke_menstrual_history_yn"));
	//ML-MMOH-CRF-1759.1-US001 ends	
	
	String allow_ext_nb_regn_within_days = checkForNull( request.getParameter( "allow_ext_nb_regn_within_days") );

    String single_stage_nb_reg_appl_yn    =  checkForNull(request.getParameter( "single_stage_nb_reg_appl_yn"   ));
	String mod_birth_reg_appl_yn      = checkForNull( request.getParameter( "mod_birth_reg_appl_yn") ); //Added by Prakash on 03rd Oct 2023 ML-MMOH-CRF-2046
    //String invoke_chg_pat_dtls_fm_nb_yn    =  checkForNull(request.getParameter( "invoke_chg_pat_dtls_fm_nb_yn"   ));
    String nb_use_mother_ser             =  checkForNull(request.getParameter( "nb_use_mother_ser"   ));
    String search_threshold_records      =  checkForNull(request.getParameter( "search_threshold_records" ));
    String sex_hist_yn                   =  checkForNull(request.getParameter( "sex_hist_yn"          ));
    String birth_date_hist_yn            =  checkForNull(request.getParameter( "birth_date_hist_yn"       ));
    String legal_name_hist_yn            =  checkForNull(request.getParameter( "legal_name_hist_yn"       ));
    String alias_name_hist_yn            =  checkForNull(request.getParameter( "alias_name_hist_yn"       ));
    String coded_pseudo_name_hist_yn     =  checkForNull(request.getParameter( "coded_pseudo_name_hist_yn"    ));
    String contact_no_hist_yn            =  checkForNull(request.getParameter( "contact_no_hist_yn"       ));
    String address_hist_yn               =  checkForNull(request.getParameter( "address_hist_yn"      ));
    String ocpn_n_empl_hist_yn           =  checkForNull(request.getParameter( "ocpn_n_empl_hist_yn"      ));
    String general_alert_info_hist_yn    =  checkForNull(request.getParameter( "general_alert_info_hist_yn"   ));
    String suspend_reinstate_hist_yn     =  checkForNull(request.getParameter( "suspend_reinstate_hist_yn"    ));
    String inactivate_activate_hist_yn   =  checkForNull(request.getParameter( "inactivate_activate_hist_yn"));
    String rec_revoke_death_hist_yn      =  checkForNull(request.getParameter( "rec_revoke_death_hist_yn" ));
    String added_by_id                   =  checkForNull(request.getParameter( "added_by_id"          ));
    String added_date                    =  checkForNull(request.getParameter( "added_date"           ));
    String added_at_ws_no                =  checkForNull(request.getParameter( "added_at_ws_no"           ));
    String modified_by_id                =  checkForNull(request.getParameter( "modified_by_id"           ));
    String modified_date                 =  checkForNull(request.getParameter( "modified_date"            ));
    String modified_at_ws_no             =  checkForNull(request.getParameter( "modified_at_ws_no"        ));
    String hr_interface_yn               =  checkForNull(request.getParameter( "hr_interface_yn"      ));
    String hr_check_digit_scheme         =  checkForNull(request.getParameter( "hr_check_digit_scheme"    ));
    String his_interface_yn              =  checkForNull(request.getParameter( "his_interface_yn"     ));
    String age_limit_for_service         =  checkForNull(request.getParameter( "age_limit_for_service"    ));
    String alt_id1_len_validation_yn     =  checkForNull(request.getParameter("alt_id1_len_validation_yn"));
    String alt_id2_len_validation_yn     =  checkForNull(request.getParameter("alt_id2_len_validation_yn"));
    String alt_id3_len_validation_yn     =  checkForNull(request.getParameter("alt_id3_len_validation_yn"));
    String alt_id4_len_validation_yn     =  checkForNull(request.getParameter("alt_id4_len_validation_yn"));
    String alt_id1_exp_date_accept_yn   =  checkForNull(request.getParameter("alt_id1_exp_date_accept_yn"));
    String alt_id2_exp_date_accept_yn   =  checkForNull(request.getParameter("alt_id2_exp_date_accept_yn"));
    String alt_id3_exp_date_accept_yn   =  checkForNull(request.getParameter("alt_id3_exp_date_accept_yn"));
    String alt_id4_exp_date_accept_yn   =  checkForNull(request.getParameter("alt_id4_exp_date_accept_yn"));
    String alt_id1_routine_name         =  checkForNull(request.getParameter("alt_id1_routine_name"));
    String alt_id2_routine_name         =  checkForNull(request.getParameter("alt_id2_routine_name"));
    String alt_id3_routine_name         =  checkForNull(request.getParameter("alt_id3_routine_name"));
    String alt_id4_routine_name         =  checkForNull(request.getParameter("alt_id4_routine_name"));
    String alt_id1_invoke_routine       =  checkForNull(request.getParameter("alt_id1_invoke_routine"));
    String alt_id2_invoke_routine       =  checkForNull(request.getParameter("alt_id2_invoke_routine"));
    String alt_id3_invoke_routine       =  checkForNull(request.getParameter("alt_id3_invoke_routine"));
    String alt_id4_invoke_routine       =  checkForNull(request.getParameter("alt_id4_invoke_routine"));
    String id_change_allowed_for_series =  checkForNull(request.getParameter("id_change_allowed_for_series"));
    String alt_id1_adv_alert_reqd_yn    =  checkForNull(request.getParameter("alt_id1_adv_alert_reqd_yn"));
    String alt_id1_adv_alert_days       =  checkForNull(request.getParameter("alt_id1_adv_alert_days"));
    String alt_id2_adv_alert_reqd_yn    =  checkForNull(request.getParameter("alt_id2_adv_alert_reqd_yn"));
    String alt_id2_adv_alert_days       =  checkForNull(request.getParameter("alt_id2_adv_alert_days"));
    String alt_id3_adv_alert_reqd_yn    =  checkForNull(request.getParameter("alt_id3_adv_alert_reqd_yn"));
    String alt_id3_adv_alert_days       =  checkForNull(request.getParameter("alt_id3_adv_alert_days"));
    String alt_id4_adv_alert_reqd_yn    =  checkForNull(request.getParameter("alt_id4_adv_alert_reqd_yn"));
    String alt_id4_adv_alert_days       =  checkForNull(request.getParameter("alt_id4_adv_alert_days"));
	String alt_id1_accept_oth_pat_ser_yn = "";
	String alt_id1_chng_allowed_yn = "";
	String alt_id1_accept_alphanumeric_yn  = "";
	String chkdisAcceptAlphanumeric = "";
	String chkdisAcceptothpatser = "";
	String max_patient_age = "";
	String terminal_digit_reqd_yn       =  checkForNull(request.getParameter("terminal_digit_reqd_yn"));
    String terminal_digit_count         =  checkForNull(request.getParameter("terminal_digit_count"));
    String terminal_digit1_position       =  checkForNull(request.getParameter("terminal_digit1_position"));
    String terminal_digit2_position       =  checkForNull(request.getParameter("terminal_digit2_position"));
    String terminal_digit3_position       =  checkForNull(request.getParameter("terminal_digit3_position"));
    String terminal_digit4_position       =  checkForNull(request.getParameter("terminal_digit4_position"));
    String terminal_digit5_position       =  checkForNull(request.getParameter("terminal_digit5_position"));
    String addl_field1_prompt       =  checkForNull(request.getParameter("addl_field1_prompt"));
    String addl_field1_length           =  checkForNull(request.getParameter("addl_field1_length"));
    String addl_field1_section       =  checkForNull(request.getParameter("addl_field1_section"));
    String addl_field2_prompt       =  checkForNull(request.getParameter("addl_field2_prompt"));
    String addl_field2_length           =  checkForNull(request.getParameter("addl_field2_length"));
    String addl_field2_section       =  checkForNull(request.getParameter("addl_field2_section"));
    String addl_field3_prompt       =  checkForNull(request.getParameter("addl_field3_prompt"));
    String addl_field3_length           =  checkForNull(request.getParameter("addl_field3_length"));
    String addl_field3_section       =  checkForNull(request.getParameter("addl_field3_section"));
    String addl_field4_prompt       =  checkForNull(request.getParameter("addl_field4_prompt"));
    String addl_field4_length           =  checkForNull(request.getParameter("addl_field4_length"));
    String addl_field4_section       =  checkForNull(request.getParameter("addl_field4_section"));
    String addl_field5_prompt       =  checkForNull(request.getParameter("addl_field5_prompt"));
    String addl_field5_length           =  checkForNull(request.getParameter("addl_field5_length"));
    String addl_field5_section       =  checkForNull(request.getParameter("addl_field5_section"));
    
	String start_with = ""; 
	String alt_id1_start_with = ""; 
	String alt_id2_start_with = ""; 
	String alt_id3_start_with = ""; 
	String alt_id4_start_with = ""; 
	
    String nat_prompt  ="";
	String dft_national_id ="";
    String nat_reqd_for_all_ser ="";
    String nat_chk_dig_scheme = "";
    String chk_len = "" ;
    String nat_invoke_routine ="";
	String chkAcceptNat = "";
	String accept_national_id_no_yn = "";
	//String accept_residency_status = "";
	String entitlement_by_pat_cat_yn = "";
	String mapped_alt_id_org_member_id = "";
	String org_member_relationship_code = "";
    String col1="";
    String col2="";
    String col3="";
    String chk1="";
    String chk2="";
    String chk3="";
    String chk4="";
    String terminal=""; 
    String dig0="";
    String dig3="";
    String dig4="";
    String dig5="";
    String sec11="";
    String sec12="";
    String sec13="";
    String sec14="";
    String sec15="";
    String sec16="";
    String sec21="";
    String sec22="";
    String sec23="";
    String sec24="";
    String sec25="";
    String sec26="";
    String sec31="";
    String sec32="";
    String sec33="";
    String sec34="";
    String sec35="";
    String sec36="";
    String sec41="";
    String sec42="";
    String sec43="";
    String sec44="";
    String sec45="";
    String sec46="";
    String sec51="";
    String sec52="";
    String sec53="";
    String sec54="";
    String sec55="";
    String sec56="";
	String sec57="";
	String sec58="";
	String sec59="";
	String sec60="";
	String sec61="";
	String pat_search_tab ="";
    String name_in_oth_lang_yn    =  request.getParameter("name_in_oth_lang_yn")==null ?"N":request.getParameter("name_in_oth_lang_yn");
    String nat_id_routine_name    = "";
	String min_weight = "";
	String display_new_born_age="";
	String age_not_consider_natid=""; //Added by Ashwini on 06-Mar-2019 for MO-CRF-20148
	String no_days_UHID_valid=""; // Added by mujafar for AMRI-CRF-0357 
	String age_not_consider_natid_altid=""; //Added by Dharma on 20th Mar 2019 NMC-JD-CRF-0018 [IN:069750]
	String max_weight = "";
	String min_length = "";
	String max_length = "";
	String min_head_circum = "";
	String max_head_circum = "";
	String min_chest_circum = "";
	String max_chest_circum = "";
	String min_gestation = "";
	String max_gestation = "";
	String gestation_two_del = "";
	String gen_slno_unknown_pat_yn = "";
    String operation              =  checkForNull(request.getParameter( "operation" ));
	String create_file_at_pat_regn_yn = "";
    String create_file_at_admission = "";
	String create_file_at_reg_visit_yn = "";
	String create_file_at_reg_att_yn = "";
	String create_file_at_dc_admission_yn = "";
	String maintain_doc_or_file = "";
	String disable_mr_admin = "";
	String mr_file_select = "";
	String mr_doc_select = "";
	String name_prefix_length = "";
	String first_name_length = "";
	String second_name_length = "";
	String third_name_length = "";
	String family_name_length = "";
	String name_suffix_length = "";
	String inv_pat_search_in_reg_pat_yn ="N";
	String race_required_yn ="N";
	String round_dob_estd_age ="N";
	//Maheshwaran K added for the Bru-HIMS-CRF-171 as on 03/12/2012
	//Start
	String mortuary_release_yn="N";
	String no_days_before_deceased="";
	String cancel_reason_code="";
	//End
	String dflt_language_id="";
	String dflt_relgn_code="";
	String language_direction="";
	String name_pfx_reqd_for_org_mem_yn="";
//CC ON 2/26/2008
	String gen_pid_using_aid1_rule_yn="";
	//String gen_pid_ald1_disable="";
	//String gen_pid_ald1_checked="";

	String nat_id_accept_alphanumeric_yn="";
	String chkAcceptAlpha = "";
	String create_file_yn = "Y";
	String single_patient_numbering_yn="";
	//String status="";
	//String chksinpatyn="";
   //	String display_new_born_age_in _hr ;
		/*String alt_id2_accept_alphanumeric_yn ="";
	String alt_id3_accept_alphanumeric_yn ="";
	String alt_id4_accept_alphanumeric_yn ="";*/


	//Added On 3/5/2008
//	String relationship_level_length="";

	//String dis_id_chg_all_ser = "";
// New parameter Added  against GHL-CRF-0312 [IN:039856] By saanthaakumar
	String country_reqd_yn ="N";
String region_reqd_yn ="N";
String mobile_no_reqd_yn ="N";
// New parameter Added  against KDAH-CRF-0273 [IN:045012]  By saanthaakumar
String email_id_reqd_yn ="N";
// New parameter Added  against AMRI-CRF-0388  By Shagar
String postal_cd_reqd_yn ="N";
String area_reqd_yn ="N";
//New parameter Added against ML-MMOH-CRF-0736 by Mano
String religion_reqd_yn ="N";

String pat_ser_access_by_user_yn="N";//added for MO-CRF-20074
String patientcategory_reqd_yn ="N"; //Added by Suji keerthi on 19-Nov-2019 for KDAH-CRF-0522
String town_reqd_yn ="N"; //Added by Suji keerthi on 19-Nov-2019 for KDAH-CRF-0522


/*Added by Dharma on Apr 2nd 2015 against HSA-CRF-0191 [IN:049772] Start */
String alt_id2_accept_oth_pat_ser_yn		= "";
String alt_id2_chng_allowed_yn				= "";
String alt_id2_accept_alphanumeric_yn		= "";
String alt_id3_accept_oth_pat_ser_yn		= "";
String alt_id3_chng_allowed_yn				= "";
String alt_id3_accept_alphanumeric_yn		= "";
String alt_id4_accept_oth_pat_ser_yn		= "";
String alt_id4_chng_allowed_yn				= "";
String alt_id4_accept_alphanumeric_yn		= "";
/*Added by Dharma on Apr 2nd 2015 against HSA-CRF-0191 [IN:049772] End */

/*Added By Dharma against GHL-CRF-0524.1 [IN:068022] on 25th July 2108 Start */
String alt_id1_alphanum_validate_yn			= "N";
String alt_id2_alphanum_validate_yn			= "N";
String alt_id3_alphanum_validate_yn			= "N";
String alt_id4_alphanum_validate_yn			= "N";
/*Added By Dharma against GHL-CRF-0524.1 [IN:068022] on 25th July 2108 End */
String upd_pat_dtls_referral_yn				= "N"; //Added by Dharma against HSA-CRF-0303 [IN:054572] on Apr 8th 2016
String disp_cancelled_previous_enc_yn="Y";
String unmask_aadhaar_num_yn	= "N"; 	
String unmask_abha_num_addr_yn  ="N";	

String biometric_authentication_yn="";
String reason_biomtrc_auth_fail_yn="";


//Added by PRITHIVI ON 10/05/2017 FOR KDAH-CRF-0362
String aadharProfileYN = InterfaceUtil.isInterfaceProfileExisting("AADHAARPROF1");
String aadhaar_config_enabled_yn	= checkForNull( request.getParameter( "aadhar_config_enabled_yn"),"N" );
String aadhaar_option_value	= checkForNull( request.getParameter( "aadhar_option_value"),"" );


String death_reg_form_req_yn = "N";//Added by Ajay Hatwate for AAKH-CRF-0179 on 14/08/2023
String occupation_reqd_yn      = "N";
String marital_status_reqd_yn  ="N";
String mand_visit_admssn_reg_yn  ="N";

String abha_eng_audio_path="";
String abha_hin_audio_path="";
	try
	{
	pstmt_rh = con.prepareStatement("select nvl(VALUE_2,'00') VALUE_2 from sm_function_control a,SM_SITE_PARAM b  where module_id='MP' and FUNCTIONALITY_ID='SMART_CARD_INTG' and a.SITE_ID=B.CUSTOMER_ID");
    rs_rh = pstmt_rh.executeQuery();	
	if(rs_rh!=null && rs_rh.next())
	{
	function_name=rs_rh.getString("VALUE_2");
	}
	}catch(SQLException esql)
	{
		esql.printStackTrace();
	}finally
	{
	 if(pstmt_rh != null)pstmt_rh.close();
	 if(rs_rh != null)rs_rh.close();
	}
//<!--Added by Himanshu Saxena on  30-Jun-2023 for AAKH-CRF-0175 US1 ends-->	


String module_instal_ind="";
	        pstmt1 = con.prepareStatement( "select MODULE_INSTALL_IND from sm_module where module_id='MP' " ) ;
			  rs1 = pstmt1.executeQuery() ;
if ( rs1 != null && rs1.next() ) 
		  {
           
            module_instal_ind  = rs1.getString( "MODULE_INSTALL_IND") == null?"":rs1.getString( "MODULE_INSTALL_IND");
             

}
    
	
	if ( operation == null )
		operation = "" ;
		//operation="insert";
		  if ( operation.equalsIgnoreCase( "modify" ) )
		  {
		      pstmt = con.prepareStatement( "select * from MP_PARAM");
			  rs = pstmt.executeQuery();
             
			
          
		  
		  if ( rs != null && rs.next() ) 
		  { 
            no_days_UHID_valid = rs.getString ("UHID_VALID_DAYS") == null?"":rs.getString("UHID_VALID_DAYS"); // Added by mujafar for AMRI-CRF-0357
            display_new_born_age=rs.getString   ( "DISPLAY_NEW_BORN_AGE_IN_HRS");
			if(display_new_born_age==null) display_new_born_age="";
			single_patient_numbering_yn=rs.getString   ( "single_patient_numbering_yn");
			entitlement_by_pat_cat_yn  = rs.getString   ( "entitlement_by_pat_cat_yn");
            family_org_id_accept_yn     = rs.getString   ( "family_org_id_accept_yn");
            mapped_alt_id_org_member_id     = rs.getString   ( "mapped_alt_id_org_member_id");
            org_member_relationship_code     = rs.getString   ( "org_member_relationship_code");
            pat_search_tab                 =rs.getString( "PAT_SEARCH_DFLT_TAB");
			
			module_id                     = rs.getString( "module_id");
            patient_id_length             = rs.getString( "patient_id_length");
            patient_no_ctrl               = rs.getString( "patient_no_ctrl");
            gen_pat_ser_grp               = rs.getString( "gen_pat_ser_grp");
            nat_id_pat_ser_grp            = rs.getString( "nat_id_pat_ser_grp");
            alt_id_pat_ser_grp            = rs.getString( "alt_id_pat_ser_grp");
            family_no_pat_ser_grp         = rs.getString( "family_no_pat_ser_grp");
            dflt_pat_ser_grp_type         = rs.getString( "dflt_pat_ser_grp_type");
            emeg_pat_ser_grp              = rs.getString( "emeg_pat_ser_grp");
            newborn_pat_ser_grp           = rs.getString( "newborn_pat_ser_grp");
            nat_id_length                 = rs.getString( "nat_id_length");
            name_dervn_logic              = rs.getString( "name_dervn_logic");
            name_dervn_logic_oth_lang     = rs.getString( "name_dervn_logic_oth_lang");

			name_dervn_logic_long              = rs.getString( "name_dervn_logic_long");
            name_dervn_logic_oth_lang_long     = rs.getString( "name_dervn_logic_oth_lang_long");

			//Added by Ashwini on 12-Oct-2020 for ML-MMOH-CRF-1551
			name_dervn_logic_nb           = rs.getString( "name_dervn_logic_nb" );
			//Added by Ashwini on 12-Oct-2020 for ML-MMOH-CRF-1551.1
			name_dervn_logic_nb_sb		  = rs.getString( "name_dervn_logic_nb_sb" );

            dflt_patient_name     = rs.getString( "dflt_patient_name");
			  dft_national_id     = rs.getString( "dft_national_id");
			gen_slno_unknown_pat_yn       = rs.getString("gen_slno_unknown_pat_yn"); 
            ethnic_sndx_type              = rs.getString( "ethnic_sndx_type");
            family_no_link_yn             = rs.getString( "family_no_link_yn");
            head_patient_no_use_yn        = rs.getString( "head_patient_no_use_yn");
            family_org_id_accept_yn       = rs.getString( "family_org_id_accept_yn");
            mapped_alt_id_org_member_id = checkForNull(rs.getString( "mapped_alt_id_org_member_id"),"");
            org_member_relationship_code = checkForNull(rs.getString("org_member_relationship_code"),"");
            citizen_nationality_code      = rs.getString( "citizen_nationality_code");
			default_race_code			  = rs.getString( "default_race_code");	 
			default_relationship_code			  = rs.getString( "nb_dflt_relnship_code");	
            general_alert_yn              = rs.getString( "general_alert_yn");
            suspend_service_yn            = rs.getString( "suspend_service_yn");
            single_or_multi_files_ind     = rs.getString( "single_or_multi_files_ind")==null?"S":rs.getString( "single_or_multi_files_ind");
            separate_file_no_yn           = rs.getString( "separate_file_no_yn");
            ext_system_interface_yn       = rs.getString( "ext_system_interface_yn");
           	pat_name_as_multipart_yn	  = rs.getString("pat_name_as_multipart_yn");
			name_prefix_accept_yn         = rs.getString( "name_prefix_accept_yn");
            name_prefix_reqd_yn           = rs.getString( "name_prefix_reqd_yn");
            name_prefix_prompt            = rs.getString( "name_prefix_prompt");
			name_prefix_loc_lang_prompt   = rs.getString( "name_prefix_loc_lang_prompt");
            first_name_accept_yn          = rs.getString( "first_name_accept_yn");
            first_name_reqd_yn            = rs.getString( "first_name_reqd_yn");
            first_name_order              = rs.getInt( "first_name_order")+"";
            first_name_prompt             = rs.getString( "first_name_prompt");
            first_name_loc_lang_prompt    = rs.getString( "first_name_loc_lang_prompt");
            second_name_accept_yn         = rs.getString( "second_name_accept_yn");
            second_name_reqd_yn           = rs.getString( "second_name_reqd_yn");
            second_name_order             = rs.getInt   ( "second_name_order") + "" ;
            second_name_prompt            = rs.getString( "second_name_prompt");
            second_name_loc_lang_prompt   = rs.getString( "second_name_loc_lang_prompt");
            third_name_accept_yn          = rs.getString( "third_name_accept_yn" );
            third_name_reqd_yn            = rs.getString( "third_name_reqd_yn");
            third_name_order              = rs.getInt   ( "third_name_order") + ""  ;
            third_name_prompt             = rs.getString( "third_name_prompt" );
            third_name_loc_lang_prompt    = rs.getString( "third_name_loc_lang_prompt" );
            family_name_accept_yn         = rs.getString( "family_name_accept_yn" );
            family_name_reqd_yn           = rs.getString( "family_name_reqd_yn" );
            family_name_order             = rs.getInt   ( "family_name_order" ) + ""  ;
            family_name_prompt            = rs.getString( "family_name_prompt" )       ;
            family_name_loc_lang_prompt   = rs.getString( "family_name_loc_lang_prompt" )       ;
            family_name_prefix_yn         = rs.getString( "family_name_prefix_yn");
            name_suffix_accept_yn         = rs.getString( "name_suffix_accept_yn" );
            name_suffix_reqd_yn           = rs.getString( "name_suffix_reqd_yn");
            name_suffix_prompt            = rs.getString( "name_suffix_prompt");
            name_suffix_loc_lang_prompt   = rs.getString( "name_suffix_loc_lang_prompt");
            names_in_oth_lang_yn          = rs.getString( "names_in_oth_lang_yn");
            dflt_sndx_type                = rs.getString( "dflt_sndx_type");
            dflt_coded_pseudo_name        = rs.getString( "dflt_coded_pseudo_name");
            alt_id1_type                  = rs.getString( "alt_id1_type");
            alt_id1_length                = rs.getInt   ( "alt_id1_length") + ""  ;
            alt_id1_chk_digit_scheme      = rs.getString( "alt_id1_chk_digit_scheme");
            alt_id1_reqd_yn               = rs.getString( "alt_id1_reqd_yn");
            alt_id1_unique_yn             = rs.getString( "alt_id1_unique_yn");
            alt_id1_exp_warn_yn           = rs.getString( "alt_id1_exp_warn_yn");
            alt_id1_exp_grace_days        = rs.getInt   ( "alt_id1_exp_grace_days") + ""  ;
            alt_id2_type                  = rs.getString( "alt_id2_type");
            alt_id2_length                = rs.getInt   ( "alt_id2_length") + ""  ;
            alt_id2_chk_digit_scheme      = rs.getString( "alt_id2_chk_digit_scheme");
            alt_id2_reqd_yn               = rs.getString( "alt_id2_reqd_yn");
            alt_id2_unique_yn             = rs.getString( "alt_id2_unique_yn");
            alt_id2_exp_warn_yn           = rs.getString( "alt_id2_exp_warn_yn");
            alt_id2_exp_grace_days        = rs.getInt   ( "alt_id2_exp_grace_days") + ""  ;
            alt_id3_type                  = rs.getString( "alt_id3_type");
            alt_id3_length                = rs.getInt   ( "alt_id3_length") + ""  ;
            alt_id3_chk_digit_scheme      = rs.getString( "alt_id3_chk_digit_scheme");
            alt_id3_reqd_yn               = rs.getString( "alt_id3_reqd_yn");
            alt_id3_unique_yn             = rs.getString( "alt_id3_unique_yn");
            alt_id3_exp_warn_yn           = rs.getString( "alt_id3_exp_warn_yn");
			alt_id3_exp_grace_days        = rs.getInt   ( "alt_id3_exp_grace_days") + ""  ;
            alt_id4_type                  = rs.getString( "alt_id4_type");
            alt_id4_length                = rs.getInt   ( "alt_id4_length") + ""  ;
            alt_id4_chk_digit_scheme      = rs.getString( "alt_id4_chk_digit_scheme");
            alt_id4_reqd_yn               = rs.getString( "alt_id4_reqd_yn");
            alt_id4_unique_yn             = rs.getString( "alt_id4_unique_yn");
            alt_id4_exp_warn_yn           = rs.getString( "alt_id4_exp_warn_yn");
            alt_id4_exp_grace_days        = rs.getInt   ( "alt_id4_exp_grace_days") + ""  ;
            family_no_prompt              = rs.getString( "family_no_prompt");
            dflt_contact_mode1            = rs.getString( "dflt_contact_mode1");
            dflt_contact_mode2            = rs.getString( "dflt_contact_mode2");
            dflt_contact_mode3            = rs.getString( "dflt_contact_mode3");
            dflt_contact_mode4            = rs.getString( "dflt_contact_mode4");
            dflt_contact_mode5            = rs.getString( "dflt_contact_mode5");
            dflt_addr_type1               = rs.getString( "dflt_addr_type1");
            dflt_addr_type2               = rs.getString( "dflt_addr_type2");
            dflt_addr_type3               = rs.getString( "dflt_addr_type3");
            dflt_addr_type4               = rs.getString( "dflt_addr_type4");
            dflt_addr_type5               = rs.getString( "dflt_addr_type5");
            dflt_rel_contact_role1        = rs.getString( "dflt_rel_contact_role1");
            dflt_rel_contact_role2        = rs.getString( "dflt_rel_contact_role2");
            dflt_rel_contact_role3        = rs.getString( "dflt_rel_contact_role3");
            dflt_rel_contact_role4        = rs.getString( "dflt_rel_contact_role4");
            dflt_rel_contact_role5        = rs.getString( "dflt_rel_contact_role5");
            dflt_doc1_type                = rs.getString( "dflt_doc1_type");
            dflt_doc2_type                = rs.getString( "dflt_doc2_type");
            dflt_doc3_type                = rs.getString( "dflt_doc3_type");
            dflt_doc4_type                = rs.getString( "dflt_doc4_type");
            dflt_doc5_type                = rs.getString( "dflt_doc5_type");
            dflt_pat_fin_class            = rs.getString( "dflt_pat_fin_class");
            prompt_pat_fin_class_yn       = rs.getString( "prompt_pat_fin_class_yn");
            allow_nb_regn_within_days     = rs.getString( "allow_nb_regn_within_days");
			mul_birth_regn_within_hours   = rs.getString( "max_multiple_birth_regn_hrs"); 
			dflt_alt_id1_in_emp_id_yn     = rs.getString( "dflt_alt_id1_in_emp_id_yn");
            acpt_appt_rfrl_in_reg_pat_yn  = rs.getString( "acpt_appt_rfrl_in_reg_pat_yn");
			min_age_of_moth               = rs.getString( "nb_mother_min_age");
            max_age_of_moth               = rs.getString( "nb_mother_upper_age");
			cut_age_of_moth               = rs.getString( "nb_mother_cutoff_age");
			dft_rel_male_nb               = rs.getString( "nb_male_relnship");
			dft_rel_female_nb             = rs.getString( "nb_female_relnship");
			dft_rel_unknown_nb            = rs.getString( "nb_unknown_relnship");
			allow_nb_regn_unit            = rs.getString( "allow_nb_regn_unit");
			Accept_oth_alt_id_yn          = rs.getString( "Accept_oth_alt_id_yn");
            min_age_of_fath               = rs.getString( "nb_father_min_age");
            unit_of_wt_nb                 = rs.getString( "unit_of_wt_nb");
            unit_of_circum_nb             = rs.getString( "unit_of_circum_nb");
            unit_of_length_nb             = rs.getString( "unit_of_length_nb");
            unit_of_chest_circum_nb       = rs.getString( "unit_of_chest_circum_nb");
            unit_of_gest_nb               = rs.getString( "unit_of_gest_nb");
            sub_multi_birth_hw               = rs.getString( "sub_multi_birth_hw");
            name_suffix_male_nb           = rs.getString( "name_suffix_male_nb");
            name_suffix_female_nb         = rs.getString( "name_suffix_female_nb");
            name_prefix_male_nb           = rs.getString( "name_prefix_male_nb");
            name_prefix_unknown_nb           = rs.getString( "name_prefix_unknown_nb"); // Added by Afruddin for ML-MMOH-CRF-1520 US001 on 4.05.2020
            name_prefix_female_nb         = rs.getString( "name_prefix_female_nb");
            
            
            still_born_prefix			  = checkForNull(rs.getString( "still_born_prefix"));  
            pat_photo_renewal_alert_days			  = checkForNull(rs.getString( "pat_photo_renewal_alert_days"));  
			
			//Added by Ashwini on 06-Mar-2019 for MO-CRF-20148
			age_not_consider_natid = checkForNull(rs.getString ("AGE_NOT_CONSIDER_NATID"));
			age_not_consider_natid_altid = checkForNull(rs.getString ("AGE_NOT_CONSIDER_NATID_ALTID"));	//Added by Dharma on 20th Mar 2019 NMC-JD-CRF-0018 [IN:069750]
			
			nb_father_name_mandatory_yn   = rs.getString( "nb_father_name_mandatory_yn");  
			nb_mother_dtls_update_yn=rs.getString( "nb_mother_dtls_update_yn");//Added for HSA-CRF-0182
			data_upd_allowed_aft_final_yn = rs.getString( "data_upd_allowed_aft_final_yn");  
			accept_names_for_live_birth_yn= rs.getString( "accept_names_for_live_birth_yn"); 
		    if ( accept_names_for_live_birth_yn         == null ) accept_names_for_live_birth_yn    = "Y" ;

			dflt_race_nat_setup_nb_as_per = rs.getString( "dflt_race_nat_setup_nb_as_per");
			
            review_nb_links_bef_reg_yn    = rs.getString( "review_nb_links_bef_reg_yn");
	    allow_ext_nb_regn_within_days    = rs.getString( "allow_ext_nb_regn_within_days");
			
            length_of_baby_yn    = rs.getString( "length_of_baby_yn");
            head_circumference_of_baby_yn    = rs.getString( "head_circumference_of_baby_yn");
			
            mandate_first_newborn_yn    = rs.getString( "Mandate_First_NewBorn_yn");
            mandate_first_newborn_ip_yn    = rs.getString( "Mandate_First_NewBorn_IP_yn");
            mandate_first_newborn_ae_yn    = rs.getString( "Mandate_First_NewBorn_AE_yn");
            mandate_second_newborn_yn    = rs.getString( "Mandate_Second_NewBorn_yn");
            mandate_second_newborn_ip_yn    = rs.getString( "Mandate_Second_NewBorn_IP_yn");
            mandate_second_newborn_ae_yn    = rs.getString( "Mandate_Second_NewBorn_AE_yn");
            mandate_third_newborn_yn    = rs.getString( "Mandate_Third_NewBorn_yn");
            mandate_third_newborn_ip_yn    = rs.getString( "Mandate_Third_NewBorn_IP_yn");
            mandate_third_newborn_ae_yn    = rs.getString( "Mandate_Third_NewBorn_AE_yn");
            mand_antenatal_newborn_yn    = rs.getString( "Mand_Antenatal_NewBorn_yn");
            mand_antenatal_newborn_ip_yn    = rs.getString( "Mand_Antenatal_NewBorn_IP_yn");
            mand_antenatal_newborn_ae_yn    = rs.getString( "Mand_Antenatal_NewBorn_AE_yn");
			
            enable_marital_status    = checkForNull(rs.getString( "ENABLE_MARITAL_STATUS"));
            dflt_father_first_name_prompt    = checkForNull(rs.getString( "DFLT_FATHER_FIRST_NAME_PROMPT"));
            dflt_father_Second_name_prompt    = checkForNull(rs.getString( "DFLT_FATHER_SECOND_NAME_PROMPT"));
            dflt_father_third_name_prompt    = checkForNull(rs.getString( "DFLT_FATHER_THIRD_NAME_PROMPT"));
            dflt_father_family_name_prompt    = checkForNull(rs.getString( "DFLT_FATHER_FAMILY_NAME_PROMPT"));
            
          
            mand_parity_newborn_yn = rs.getString("mand_parity_newborn_yn");
            mand_parity_newborn_ip_yn = rs.getString("mand_parity_newborn_ip_yn");
            mand_parity_newborn_ae_yn = rs.getString("mand_parity_newborn_ae_yn"); 
            invoke_menstrual_history_yn = rs.getString("invoke_menstrual_history_yn");
            

            single_stage_nb_reg_appl_yn    = rs.getString( "single_stage_nb_reg_appl_yn");
            mod_birth_reg_appl_yn    = rs.getString( "mod_birth_reg_appl_yn"); //Added by Prakash on 03rd Oct 2023 ML-MMOH-CRF-2046
            //invoke_chg_pat_dtls_fm_nb_yn    = rs.getString( "invoke_chg_pat_dtls_fm_nb_yn");
            nb_use_mother_ser               = rs.getString( "nb_use_mother_ser");
            search_threshold_records      = rs.getString( "search_threshold_records");
            sex_hist_yn                   = rs.getString( "sex_hist_yn");
            birth_date_hist_yn            = rs.getString( "birth_date_hist_yn");
            legal_name_hist_yn            = rs.getString( "legal_name_hist_yn");
            alias_name_hist_yn            = rs.getString( "alias_name_hist_yn");
            coded_pseudo_name_hist_yn     = rs.getString( "coded_pseudo_name_hist_yn");
            contact_no_hist_yn            = rs.getString( "contact_no_hist_yn");
            address_hist_yn               = rs.getString( "address_hist_yn");
            ocpn_n_empl_hist_yn           = rs.getString( "ocpn_n_empl_hist_yn");
            general_alert_info_hist_yn    = rs.getString( "general_alert_info_hist_yn");
            suspend_reinstate_hist_yn     = rs.getString( "suspend_reinstate_hist_yn");
            gen_pid_using_aid1_rule_yn     = rs.getString( "gen_pid_using_aid1_rule_yn");
           // display_new_born_age_in _hr  = rs.getString( "display_new_born_age_in _hrs");
              //if(display_new_born_age_in _hrs.equals()) display_new_born_age_in _hrs="";
//            relationship_level_length     = rs.getString( "relationship_level_length")==null?"":rs.getString( "relationship_level_length");
		
			//For FM
			create_file_at_pat_regn_yn   =  rs.getString ( "create_file_at_pat_regn_yn");
			create_file_at_admission     =  rs.getString ( "create_file_at_admission");
			create_file_at_reg_visit_yn  =  rs.getString ( "create_file_at_reg_visit_yn");
			create_file_at_reg_att_yn    =  rs.getString ( "create_file_at_reg_att_yn");
			create_file_at_dc_admission_yn = rs.getString ("create_file_at_dc_admission_yn");
			//For MR Admin
			maintain_doc_or_file =  rs.getString ( "maintain_doc_or_file");			
			create_file_yn		 =  rs.getString ("create_file_yn") == null?"Y":rs.getString("create_file_yn");			
			upt_contact_dtls_oa_yn		 =  rs.getString ("UPT_CONTACT_DTLS_OA_YN") == null?"N":rs.getString("UPT_CONTACT_DTLS_OA_YN");	//added  changes   for HSA-CRF-0226 [IN:050599] 	
			
			/*Below Added by Rameswar on 3rd July 2015 for MO-CRF-20099 [IN054280]*/
			ALT_ID1_PAT_SCH_EXACT_YN=rs.getString ("ALT_ID1_PAT_SCH_EXACT_YN") == null?"N":rs.getString("ALT_ID1_PAT_SCH_EXACT_YN");
			ALT_ID2_PAT_SCH_EXACT_YN=rs.getString ("ALT_ID2_PAT_SCH_EXACT_YN") == null?"N":rs.getString("ALT_ID2_PAT_SCH_EXACT_YN");
			ALT_ID3_PAT_SCH_EXACT_YN=rs.getString ("ALT_ID3_PAT_SCH_EXACT_YN") == null?"N":rs.getString("ALT_ID3_PAT_SCH_EXACT_YN");
			ALT_ID4_PAT_SCH_EXACT_YN=rs.getString ("ALT_ID4_PAT_SCH_EXACT_YN") == null?"N":rs.getString("ALT_ID4_PAT_SCH_EXACT_YN");
			/*Added by PRITHIVI ON 10/05/2017 FOR KDAH-CRF-0362*/
			aadhaar_config_enabled_yn = rs.getString ("aadhar_config_enabled_yn") == null?"N":rs.getString("aadhar_config_enabled_yn");
			aadhaar_option_value = rs.getString ("aadhar_option_value") == null?"":rs.getString("aadhar_option_value");

			// <!--Added by Himanshu Saxena on 03-July-2023 for AAKH-CRF-0175 US1 Starts-->
			biometric_authentication_yn=rs.getString ("BIOMETRIC_AUTHENTICATION_YN") == null?"N":rs.getString("BIOMETRIC_AUTHENTICATION_YN");
			// <!--Added by Himanshu Saxena on 03-July-2023 for AAKH-CRF-0175 US1 Ends-->
			

			if(maintain_doc_or_file.equals("F"))
			  {
				if(operation.equals("modify"))
				{
					disable_mr_admin = "disabled";
					mr_file_select =   "selected";
					mr_doc_select = "";}
				}
				else if(maintain_doc_or_file.equals("D")) /* Only File is allowed now*/
				{				
				/*	if(operation.equals("modify"))
					{disable_mr_admin = "disabled";
					mr_file_select =   "";
					mr_doc_select = "selected";}
				*/
				}
		
            rec_revoke_death_hist_yn      = rs.getString( "rec_revoke_death_hist_yn");
            hr_interface_yn             = rs.getString( "hr_interface_yn");
            hr_check_digit_scheme         = rs.getString( "hr_check_digit_scheme");
            his_interface_yn            = rs.getString( "his_interface_yn");
            age_limit_for_service       = rs.getInt( "age_limit_for_service") + "" ;

            alt_id1_len_validation_yn = rs.getString("ALT_ID1_LEN_VALIDATION_YN");
            alt_id2_len_validation_yn = rs.getString("ALT_ID2_LEN_VALIDATION_YN");
            alt_id3_len_validation_yn  = rs.getString("ALT_ID3_LEN_VALIDATION_YN");
            alt_id4_len_validation_yn = rs.getString("ALT_ID4_LEN_VALIDATION_YN");

            alt_id1_exp_date_accept_yn = rs.getString("alt_id1_exp_date_accept_yn");
            alt_id2_exp_date_accept_yn = rs.getString("alt_id2_exp_date_accept_yn");
            alt_id3_exp_date_accept_yn = rs.getString("alt_id3_exp_date_accept_yn");
            alt_id4_exp_date_accept_yn = rs.getString("alt_id4_exp_date_accept_yn");
            name_in_oth_lang_yn        = rs.getString("names_in_oth_lang_yn");
       
            alt_id1_routine_name       = rs.getString("alt_id1_data_source_id");
            alt_id2_routine_name       = rs.getString("alt_id2_data_source_id");
            alt_id3_routine_name       = rs.getString("alt_id3_data_source_id");
            alt_id4_routine_name       = rs.getString("alt_id4_data_source_id"); 

            alt_id1_invoke_routine     = rs.getString("alt_id1_routine_yn");
            alt_id2_invoke_routine     = rs.getString("alt_id2_routine_yn");
            alt_id3_invoke_routine     = rs.getString("alt_id3_routine_yn");
            alt_id4_invoke_routine     = rs.getString("alt_id4_routine_yn");
		
		
			alt_id1_accept_oth_pat_ser_yn = rs.getString("alt_id1_accept_oth_pat_ser_yn")==null?"N":rs.getString("alt_id1_accept_oth_pat_ser_yn");
			alt_id1_accept_alphanumeric_yn = rs.getString("alt_id1_accept_alphanumeric_yn")==null?"N":rs.getString("alt_id1_accept_alphanumeric_yn");



			/*Added by Dharma on Apr 2nd 2015 against HSA-CRF-0191 [IN:049772] Start */
			alt_id2_accept_oth_pat_ser_yn			= checkForNull(rs.getString("alt_id2_accept_oth_pat_ser_yn"),"N");
			alt_id2_chng_allowed_yn					= checkForNull(rs.getString("alt_id2_chng_allowed_yn"),"N");
			alt_id2_accept_alphanumeric_yn			= checkForNull(rs.getString("alt_id2_accept_alphanumeric_yn"),"N");
			alt_id3_accept_oth_pat_ser_yn			= checkForNull(rs.getString("alt_id3_accept_oth_pat_ser_yn"),"N");
			alt_id3_chng_allowed_yn					= checkForNull(rs.getString("alt_id3_chng_allowed_yn"),"N");
			alt_id3_accept_alphanumeric_yn			= checkForNull(rs.getString("alt_id3_accept_alphanumeric_yn"),"N");
			alt_id4_accept_oth_pat_ser_yn			= checkForNull(rs.getString("alt_id4_accept_oth_pat_ser_yn"),"N");
			alt_id4_chng_allowed_yn					= checkForNull(rs.getString("alt_id4_chng_allowed_yn"),"N");
			alt_id4_accept_alphanumeric_yn			= checkForNull(rs.getString("alt_id4_accept_alphanumeric_yn"),"N");
			/*Added by Dharma on Apr 2nd 2015 against HSA-CRF-0191 [IN:049772] End */

			/*Added By Dharma against GHL-CRF-0524.1 [IN:068022] on 25th July 2108 Start */
			alt_id1_alphanum_validate_yn			= checkForNull(rs.getString("alt_id1_alphanum_validate_yn"),"N");
			alt_id2_alphanum_validate_yn			= checkForNull(rs.getString("alt_id2_alphanum_validate_yn"),"N");
			alt_id3_alphanum_validate_yn			= checkForNull(rs.getString("alt_id3_alphanum_validate_yn"),"N");
			alt_id4_alphanum_validate_yn			= checkForNull(rs.getString("alt_id4_alphanum_validate_yn"),"N");
			
			if(isStartWith){
			alt_id1_start_with			= checkForNull(rs.getString("alt_id1_start_with"));
			alt_id2_start_with			= checkForNull(rs.getString("alt_id2_start_with"));
			alt_id3_start_with			= checkForNull(rs.getString("alt_id3_start_with"));
			alt_id4_start_with			= checkForNull(rs.getString("alt_id4_start_with"));
			}
		
			
			upd_pat_dtls_referral_yn				= checkForNull(rs.getString("UPD_PAT_DTLS_REFERRAL_YN"),"N");

			id_change_allowed_for_series = rs.getString("id_change_allowed_for_series")==null?"":rs.getString("id_change_allowed_for_series");

            ext_system_interface_yn = rs.getString("ext_system_interface_yn")==null?"N":rs.getString("ext_system_interface_yn");
		
			disp_cancelled_previous_enc_yn				= checkForNull(rs.getString("disp_cancel_prev_enc_yn"),"Y"); 
			occupation_reqd_yn			           = checkForNull(rs.getString("occupation_reqd_yn"),"N");
			marital_status_reqd_yn			       = checkForNull(rs.getString("marital_status_reqd_yn"),"N");
			mand_visit_admssn_reg_yn			       = checkForNull(rs.getString("mand_visit_admssn_reg_yn"),"N");
			
			unmask_aadhaar_num_yn   = checkForNull(rs.getString("UNMASK_AADHAR_NO"),"N"); 	
			
			unmask_abha_num_addr_yn   = checkForNull(rs.getString("UNMASK_ABHA_NO_ADDRESS"),"N"); 

			//if(ext_system_interface_yn.equals("N"))	
			//{
				if (id_change_allowed_for_series.equals("N"))
				  {
					col1="selected";
					col2="";
					col3="";
					//dis_id_chg_all_ser = "";
				  }
				else if (id_change_allowed_for_series.equals("A"))
				  {
					col2="selected";
					col1="";
					col3="";
					//dis_id_chg_all_ser = "";
				  }
				else if (id_change_allowed_for_series.equals("B"))
				  {
					col3="selected";
					col1="";
					col2="";
					//dis_id_chg_all_ser = "";
				  }
				  /*
			}
			
			else if(ext_system_interface_yn.equals("Y"))
			{
				dis_id_chg_all_ser = "disabled";
				//col4="selected";
			}
			*/

		  
            alt_id1_adv_alert_reqd_yn = rs.getString("alt_id1_adv_alert_reqd_yn")==null?"N":rs.getString("alt_id1_adv_alert_reqd_yn");
            if (alt_id1_adv_alert_reqd_yn.equals("Y"))
                chk1 = "Checked";
            else if (alt_id1_adv_alert_reqd_yn.equals("N"))
                chk1 = "";

            alt_id1_adv_alert_days   = rs.getInt( "alt_id1_adv_alert_days") + ""  ;
            alt_id2_adv_alert_reqd_yn = rs.getString("alt_id2_adv_alert_reqd_yn")==null?"N":rs.getString("alt_id2_adv_alert_reqd_yn");
            if (alt_id2_adv_alert_reqd_yn.equals("Y"))
                chk2 = "Checked";
            else if (alt_id2_adv_alert_reqd_yn.equals("N"))
                chk2 = "";

            alt_id2_adv_alert_days   = rs.getInt( "alt_id2_adv_alert_days") + ""  ;
            alt_id3_adv_alert_reqd_yn = rs.getString("alt_id3_adv_alert_reqd_yn")==null?"N":rs.getString("alt_id3_adv_alert_reqd_yn");
            if (alt_id3_adv_alert_reqd_yn.equals("Y"))
                chk3 = "Checked";
            else if (alt_id3_adv_alert_reqd_yn.equals("N"))
                chk3 = "";
			
            alt_id3_adv_alert_days   = rs.getInt( "alt_id3_adv_alert_days") + ""  ;
            alt_id4_adv_alert_reqd_yn = rs.getString("alt_id4_adv_alert_reqd_yn")==null?"N":rs.getString("alt_id4_adv_alert_reqd_yn");
            if (alt_id4_adv_alert_reqd_yn.equals("Y"))
                chk4 = "Checked";
            else if (alt_id4_adv_alert_reqd_yn.equals("N"))
                chk4 = "";

            alt_id4_adv_alert_days   = rs.getInt( "alt_id4_adv_alert_days") + ""  ;
            terminal_digit_reqd_yn = rs.getString("terminal_digit_reqd_yn")==null?"N":rs.getString("terminal_digit_reqd_yn");
            if  (terminal_digit_reqd_yn.equals("Y"))
                terminal="Checked";
            else if (terminal_digit_reqd_yn.equals("N"))
                terminal="";
            
            terminal_digit_count = rs.getString("terminal_digit_count")==null?"0":rs.getString("terminal_digit_count");
			
             if (terminal_digit_count.equals("0"))
              {
                dig0="Selected";
              }
            else if (terminal_digit_count.equals("3"))
              {
                dig3="Selected";
              }
            else if (terminal_digit_count.equals("4"))
              {
                dig4="Selected";
              }
            else if (terminal_digit_count.equals("5"))
              {
                dig5="Selected";
              }
		
            terminal_digit1_position = rs.getString("terminal_digit1_position")==null?"":rs.getString("terminal_digit1_position");
            terminal_digit2_position = rs.getString("terminal_digit2_position")==null?"":rs.getString("terminal_digit2_position");
            terminal_digit3_position = rs.getString("terminal_digit3_position")==null?"":rs.getString("terminal_digit3_position");
            terminal_digit4_position = rs.getString("terminal_digit4_position")==null?"":rs.getString("terminal_digit4_position");
            terminal_digit5_position = rs.getString("terminal_digit5_position")==null?"":rs.getString("terminal_digit5_position");

            addl_field1_prompt = rs.getString("addl_field1_prompt")==null?"":rs.getString("addl_field1_prompt");
            addl_field1_length = rs.getString("addl_field1_length")==null?"":rs.getString("addl_field1_length");
            addl_field1_section = rs.getString("addl_field1_section")==null?"":rs.getString("addl_field1_section");
        
             if (addl_field1_section.equals(""))
              {
                sec11="Selected";
              }
            else if (addl_field1_section.equals("D"))
              {
                sec12="Selected";
              }
            else if (addl_field1_section.equals("C"))
              {
                sec13="Selected";
              }
            else if (addl_field1_section.equals("N"))
              {
                sec14="Selected";
              }
            else if (addl_field1_section.equals("E"))
              {
                sec15="Selected";
              }
            else if (addl_field1_section.equals("O"))
              {
                sec16="Selected";
              }
			  else if (addl_field1_section.equals("F"))
              {
				sec57="Selected";
              }

         
            addl_field2_prompt = rs.getString("addl_field2_prompt")==null?"":rs.getString("addl_field2_prompt");
            addl_field2_length = rs.getString("addl_field2_length")==null?"":rs.getString("addl_field2_length");
            addl_field2_section = rs.getString("addl_field2_section")==null?"":rs.getString("addl_field2_section");

             if (addl_field2_section.equals(""))
              {
                sec21="Selected";
              }
            else if (addl_field2_section.equals("D"))
              {
                sec22="Selected";
              }
            else if (addl_field2_section.equals("C"))
              {
                sec23="Selected";
              }
            else if (addl_field2_section.equals("N"))
              {
                sec24="Selected";
              }
            else if (addl_field2_section.equals("E"))
              {
                sec25="Selected";
              }
            else if (addl_field2_section.equals("O"))
              {
                sec26="Selected";
              }
			  else if (addl_field2_section.equals("F"))
              {
				sec58="Selected";
              }
			
            addl_field3_prompt = rs.getString("addl_field3_prompt")==null?"":rs.getString("addl_field3_prompt");
            addl_field3_length = rs.getString("addl_field3_length")==null?"":rs.getString("addl_field3_length");
            addl_field3_section = rs.getString("addl_field3_section")==null?"":rs.getString("addl_field3_section");
             if (addl_field3_section.equals(""))
              {
                sec31="Selected";
              }
            else if (addl_field3_section.equals("D"))
              {
                sec32="Selected";
              }
            else if (addl_field3_section.equals("C"))
              {
                sec33="Selected";
              }
            else if (addl_field3_section.equals("N"))
              {
                sec34="Selected";
              }
            else if (addl_field3_section.equals("E"))
              {
                sec35="Selected";
              }
            else if (addl_field3_section.equals("O"))
              {
                sec36="Selected";
              }
              else if (addl_field3_section.equals("F"))
              {
				sec59="Selected";
              }
            addl_field4_prompt = rs.getString("addl_field4_prompt")==null?"":rs.getString("addl_field4_prompt");
            addl_field4_length = rs.getString("addl_field4_length")==null?"":rs.getString("addl_field4_length");
            addl_field4_section = rs.getString("addl_field4_section")==null?"":rs.getString("addl_field4_section");

             if (addl_field4_section.equals(""))
              {
                sec41="Selected";
              }
            else if (addl_field4_section.equals("D"))
              {
                sec42="Selected";
              }
            else if (addl_field4_section.equals("C"))
              {
                sec43="Selected";
              }
            else if (addl_field4_section.equals("N"))
              {
                sec44="Selected";
              }
            else if (addl_field4_section.equals("E"))
              {
                sec45="Selected";
              }
            else if (addl_field4_section.equals("O"))
              {
                sec46="Selected";
              }
			  else if (addl_field4_section.equals("F"))
              {
				sec60="Selected";
              }
           
            addl_field5_prompt = rs.getString("addl_field5_prompt")==null?"":rs.getString("addl_field5_prompt");
            addl_field5_length = rs.getString("addl_field5_length")==null?"":rs.getString("addl_field5_length");
            addl_field5_section = rs.getString("addl_field5_section")==null?"":rs.getString("addl_field5_section");

             if (addl_field5_section.equals(""))
              {
                sec51="Selected";
              }
            else if (addl_field5_section.equals("D"))
              {
                sec52="Selected";
              }
            else if (addl_field5_section.equals("C"))
              {
                sec53="Selected";
              }
            else if (addl_field5_section.equals("N"))
              {
                sec54="Selected";
              }
            else if (addl_field5_section.equals("E"))
              {
                sec55="Selected";
              }
            else if (addl_field5_section.equals("O"))
              {
                sec56="Selected";
              }
			  else if (addl_field5_section.equals("F"))
              {
				sec61="Selected";
              }
			if(isStartWith){  
            start_with = rs.getString("start_id_with")==null?"":rs.getString("start_id_with"); //Added By Gaurav Aginst MMS-MEA-CRF-0004
			}
            nat_prompt = rs.getString("nat_id_prompt")==null?"":rs.getString("nat_id_prompt");
            nat_reqd_for_all_ser = rs.getString("nat_id_reqd_all_series")==null?"N":rs.getString("nat_id_reqd_all_series");
            nat_id_routine_name  = rs.getString("nat_data_source_id")==null?"":rs.getString("nat_data_source_id");
            nat_chk_dig_scheme  = rs.getString("nat_id_check_digit_id")==null?"":rs.getString("nat_id_check_digit_id");
            chk_len  = rs.getString("nat_id_chk_len")==null?"N":rs.getString("nat_id_chk_len");
            nat_invoke_routine   = rs.getString("invoke_routine")==null?"N":rs.getString("invoke_routine");

			accept_national_id_no_yn  = rs.getString("accept_national_id_no_yn")==null?"N":rs.getString("accept_national_id_no_yn");

			if (alt_id1_accept_alphanumeric_yn.equals("Y"))
				chkdisAcceptAlphanumeric = "Checked disabled";
			else
				chkdisAcceptAlphanumeric = "disabled";
			
			if (alt_id1_accept_oth_pat_ser_yn.equals("Y"))
				chkdisAcceptothpatser = "Checked disabled";
			else
				chkdisAcceptothpatser = "disabled";

			if (accept_national_id_no_yn.equals("Y"))
				chkAcceptNat = "Checked disabled";
			else
				chkAcceptNat = "disabled";

			max_patient_age = rs.getString("max_patient_age")==null?"":rs.getString("max_patient_age");
	
			min_weight = rs.getString("min_weight")==null?"":rs.getString("min_weight");
			max_weight = rs.getString("max_weight")==null?"":rs.getString("max_weight");
			min_length = rs.getString("min_length")==null?"":rs.getString("min_length");
			max_length = rs.getString("max_length")==null?"":rs.getString("max_length");
			min_head_circum = rs.getString("min_head_circum")==null?"":rs.getString("min_head_circum");
			max_head_circum = rs.getString("max_head_circum")==null?"":rs.getString("max_head_circum");
			min_chest_circum = rs.getString("min_chest_circum")==null?"":rs.getString("min_chest_circum");
			max_chest_circum = rs.getString("max_chest_circum")==null?"":rs.getString("max_chest_circum");
			min_gestation = rs.getString("min_gestation")==null?"":rs.getString("min_gestation");
			max_gestation = rs.getString("max_gestation")==null?"":rs.getString("max_gestation");
			gestation_two_del = rs.getString("nb_min_gest_bet_2_dely")==null?"":rs.getString("nb_min_gest_bet_2_dely");
			name_prefix_length = rs.getString("name_prefix_length")==null?"":rs.getString("name_prefix_length");
			first_name_length = rs.getString("first_name_length")==null?"":rs.getString("first_name_length");
			second_name_length = rs.getString("second_name_length")==null?"":rs.getString("second_name_length");
			third_name_length = rs.getString("third_name_length")==null?"":rs.getString("third_name_length");
			family_name_length = rs.getString("family_name_length")==null?"":rs.getString("family_name_length");
			name_suffix_length = rs.getString("name_suffix_length")==null?"":rs.getString("name_suffix_length");
			alt_id1_chng_allowed_yn = rs.getString("alt_id1_chng_allowed_yn")==null?"N":rs.getString("alt_id1_chng_allowed_yn");
			accept_pw_in_chng_pat_dtl_yn = rs.getString("accept_pw_in_chng_pat_dtl_yn")==null?"N":rs.getString("accept_pw_in_chng_pat_dtl_yn");


			dflt_language_id  = rs.getString("DFLT_LANGUAGE_ID")==null?"":rs.getString("DFLT_LANGUAGE_ID");
			dflt_relgn_code  = rs.getString("DFLT_RELGN_CODE")==null?"":rs.getString("DFLT_RELGN_CODE");
			inv_pat_search_in_reg_pat_yn  = rs.getString("INV_PAT_SEARCH_IN_REG_PAT_YN")==null?"N":rs.getString("INV_PAT_SEARCH_IN_REG_PAT_YN");
			race_required_yn  = rs.getString("RACE_REQUIRED_YN")==null?"N":rs.getString("RACE_REQUIRED_YN");
			round_dob_estd_age  = rs.getString("round_dob_estd_age")==null?"N":rs.getString("round_dob_estd_age");
			name_pfx_reqd_for_org_mem_yn  = rs.getString("name_pfx_reqd_for_org_mem_yn")==null?"N":rs.getString("name_pfx_reqd_for_org_mem_yn");

			nat_id_accept_alphanumeric_yn  = rs.getString("nat_id_accept_alphanumeric_yn")==null?"N":rs.getString("nat_id_accept_alphanumeric_yn");
			/*alt_id2_accept_alphanumeric_yn = rs.getString("alt_id2_accept_alphanumeric_yn")==null?"N":rs.getString("alt_id2_accept_alphanumeric_yn");
			alt_id3_accept_alphanumeric_yn = rs.getString("alt_id3_accept_alphanumeric_yn")==null?"N":rs.getString("alt_id3_accept_alphanumeric_yn");
			alt_id4_accept_alphanumeric_yn = rs.getString("alt_id4_accept_alphanumeric_yn")==null?"N":rs.getString("alt_id4_accept_alphanumeric_yn");*/
			//Maheshwaran K added for the Bru-HIMS-CRF-171 as on 03/12/2012
			//Start
			mortuary_release_yn=rs.getString("CANCEL_ONLY_FOR_MO_PATIENTS_YN")==null?"N":rs.getString("CANCEL_ONLY_FOR_MO_PATIENTS_YN");
			no_days_before_deceased=rs.getString("CANCEL_CUT_OFF_PERIOD_IN_DAYS")==null?"":rs.getString("CANCEL_CUT_OFF_PERIOD_IN_DAYS");
			cancel_reason_code=rs.getString("CANCEL_REASON_CODE")==null?"":rs.getString("CANCEL_REASON_CODE");
			//End
// Newly added against GHL-CRF-0312 [IN:039856] By saanthaakumar
country_reqd_yn  	= rs.getString("COUNTRY_REQD_YN")==null?"N":rs.getString("COUNTRY_REQD_YN");
region_reqd_yn		= rs.getString("REGION_REQD_YN")==null?"N":rs.getString("REGION_REQD_YN");
mobile_no_reqd_yn	= rs.getString("MOBILE_NO_REQD_YN")==null?"N":rs.getString("MOBILE_NO_REQD_YN");
// Newly added against KDAH-CRF-0273 [IN:045012]  By saanthaakumar
email_id_reqd_yn	= rs.getString("EMAIL_ID_REQD_YN")==null?"N":rs.getString("EMAIL_ID_REQD_YN");
// Newly added against AMRI-CRF-0388  By SHAGAR
postal_cd_reqd_yn	= rs.getString("postal_cd_reqd_yn")==null?"N":rs.getString("postal_cd_reqd_yn");
area_reqd_yn	= rs.getString("area_reqd_yn")==null?"N":rs.getString("area_reqd_yn");
//Below added by Mano ML-MMOH-CRF-0736
religion_reqd_yn    = rs.getString("RELIGION_REQD_YN")==null?"N":rs.getString("RELIGION_REQD_YN");
patientcategory_reqd_yn	= rs.getString("PAT_CATEGORY_REQD_YN")==null?"N":rs.getString("PAT_CATEGORY_REQD_YN"); //Added by Suji keerthi on 19-Nov-2019 for KDAH-CRF-0522
town_reqd_yn	= rs.getString("TOWN_REQD_YN")==null?"N":rs.getString("TOWN_REQD_YN"); //Added by Suji keerthi on 19-Nov-2019 for KDAH-CRF-0522
pat_ser_access_by_user_yn	= rs.getString("pat_ser_access_by_user_yn")==null?"N":rs.getString("pat_ser_access_by_user_yn");//added for MO-CRF-20074
death_reg_form_req_yn = rs.getString("ENBL_DEATH_REG_FORM_DECEASED") == null? "N" : rs.getString("ENBL_DEATH_REG_FORM_DECEASED");//Added by Ajay hatwate for AAKH-CRF-0179 on 14/08/2023
	abha_eng_audio_path=rs.getString("ABHA_ENG_AUDIO_PATH")==null?"":rs.getString("ABHA_ENG_AUDIO_PATH");
	abha_hin_audio_path=rs.getString("ABHA_HIN_AUDIO_PATH")==null?"":rs.getString("ABHA_HIN_AUDIO_PATH");
       }
		
    }
          /*out.println("<script>alert('name_prefix_length:"+name_prefix_length+"');</script>");
          out.println("<script>alert('first_name_length:"+first_name_length+"');</script>");
          out.println("<script>alert('second_name_length:"+second_name_length+"');</script>");
          out.println("<script>alert('third_name_length:"+third_name_length+"');</script>");
          out.println("<script>alert('family_name_length:"+family_name_length+"');</script>");
          out.println("<script>alert('name_suffix_length:"+name_suffix_length+"');</script>");*/

    if ( module_id                     == null ) module_id                     = "" ;
    if ( patient_id_length             == null ) patient_id_length             = "" ;
    if (( patient_no_ctrl               == null )||(patient_no_ctrl == "") )patient_no_ctrl               = "Z" ;
    if ( gen_pat_ser_grp               == null ) gen_pat_ser_grp               = "" ;
    if ( nat_id_pat_ser_grp            == null ) nat_id_pat_ser_grp            = "" ;
    if ( alt_id_pat_ser_grp            == null ) alt_id_pat_ser_grp            = "" ;
    if ( family_no_pat_ser_grp         == null ) family_no_pat_ser_grp         = "" ;
    if ( dflt_pat_ser_grp_type         == null ) dflt_pat_ser_grp_type         = "" ;
    if ( emeg_pat_ser_grp              == null ) emeg_pat_ser_grp              = "" ;
    if ( newborn_pat_ser_grp           == null ) newborn_pat_ser_grp           = "" ;
    if ( nat_id_length                 == null ) nat_id_length                 = "" ;
    if ( name_dervn_logic              == null ) name_dervn_logic              = "PR+< , >+FN" ;
    if ( name_dervn_logic_oth_lang     == null ) name_dervn_logic_oth_lang     = "" ;
	
	if ( name_dervn_logic_long              == null ) name_dervn_logic_long              = "" ;
    if ( name_dervn_logic_oth_lang_long     == null ) name_dervn_logic_oth_lang_long     = "" ;

	//Added by Ashwini on 12-Oct-2020 for ML-MMOH-CRF-1551
    if ( name_dervn_logic_nb == null ) name_dervn_logic_nb = "" ;
	//Added by Ashwini on 12-Oct-2020 for ML-MMOH-CRF-1551.1
    if ( name_dervn_logic_nb_sb == null ) name_dervn_logic_nb_sb = "" ;


    if ( dflt_patient_name     == null ) dflt_patient_name     = "" ;
	if ( dft_national_id     == null ) dft_national_id     = "" ;
    if ( ethnic_sndx_type              == null ) ethnic_sndx_type              = "U" ;
    if ( family_no_link_yn             == null ) family_no_link_yn             = "N" ;
    if ( head_patient_no_use_yn        == null ) head_patient_no_use_yn        = "N" ;
    if ( family_org_id_accept_yn       == null ) family_org_id_accept_yn       = "N" ;
    if ( citizen_nationality_code      == null ) citizen_nationality_code      = "" ;
	if ( default_race_code			   == null ) default_race_code		       = "" ;
	if ( default_relationship_code			   == null ) default_relationship_code		       = "" ;
    if ( general_alert_yn              == null ) general_alert_yn              = "N" ;
    if ( suspend_service_yn            == null ) suspend_service_yn            = "N" ;
    //if ( single_or_multi_files_ind     == null ) single_or_multi_files_ind     = "S" ;
    if ( separate_file_no_yn           == null ) separate_file_no_yn           = "N" ;
    if ( ext_system_interface_yn       == null ) ext_system_interface_yn       = "N" ;
    // Added
	
	if(pat_name_as_multipart_yn		== null) pat_name_as_multipart_yn		= "N";
	// End 
	if(acpt_appt_rfrl_in_reg_pat_yn == null) acpt_appt_rfrl_in_reg_pat_yn   = "N";
	if(dflt_alt_id1_in_emp_id_yn    == null) dflt_alt_id1_in_emp_id_yn       = "N";
	if ( name_prefix_accept_yn         == null ) name_prefix_accept_yn         = "N" ;
	if ( (entitlement_by_pat_cat_yn  == null ) || ( entitlement_by_pat_cat_yn  == "" ) ) entitlement_by_pat_cat_yn         = "N" ;
	if ( mapped_alt_id_org_member_id     == null ) mapped_alt_id_org_member_id  = "" ;
	if ( name_prefix_reqd_yn           == null ) name_prefix_reqd_yn           = "N" ;
    if ( name_prefix_prompt            == null ) name_prefix_prompt            = "" ;
    if ( name_prefix_loc_lang_prompt   == null ) name_prefix_loc_lang_prompt            = "" ;
    if ( first_name_accept_yn          == null ) first_name_accept_yn          = "N" ;
    if ( first_name_reqd_yn            == null ) first_name_reqd_yn            = "N" ;
    if ( first_name_order              == null ) first_name_order              = "" ;
    if ( first_name_prompt             == null ) first_name_prompt             = "" ;
    if ( first_name_loc_lang_prompt    == null ) first_name_loc_lang_prompt             = "" ;
    if ( second_name_accept_yn         == null ) second_name_accept_yn         = "N" ;
    if ( second_name_reqd_yn           == null ) second_name_reqd_yn           = "N" ;
    if ( second_name_order             == null ) second_name_order             = "" ;
    if ( second_name_prompt            == null ) second_name_prompt            = "" ;
    if ( second_name_loc_lang_prompt    == null ) second_name_loc_lang_prompt             = "" ;
    if ( third_name_accept_yn          == null ) third_name_accept_yn          = "N" ;
    if ( third_name_reqd_yn            == null ) third_name_reqd_yn            = "N" ;
    if ( third_name_order              == null ) third_name_order              = "" ;
    if ( third_name_prompt             == null ) third_name_prompt             = "" ;
    if ( third_name_loc_lang_prompt    == null ) third_name_loc_lang_prompt             = "" ;
    if ( family_name_accept_yn         == null ) family_name_accept_yn         = "N" ;
    if ( family_name_reqd_yn           == null ) family_name_reqd_yn           = "N" ;
    if ( family_name_order             == null ) family_name_order             = "" ;
    if ( family_name_prompt            == null ) family_name_prompt            = "" ;
    if ( family_name_loc_lang_prompt    == null ) family_name_loc_lang_prompt             = "" ;
    if ( family_name_prefix_yn         == null ) family_name_prefix_yn         = "N" ;
    if ( name_suffix_accept_yn         == null ) name_suffix_accept_yn         = "N" ;
    if ( name_suffix_reqd_yn           == null ) name_suffix_reqd_yn           = "N" ;
    if ( name_suffix_prompt            == null ) name_suffix_prompt            = "" ;
    if ( name_suffix_loc_lang_prompt   == null ) name_suffix_loc_lang_prompt            = "" ;
    if ( names_in_oth_lang_yn          == null ) names_in_oth_lang_yn          = "N" ;
    if ( dflt_sndx_type                == null ) dflt_sndx_type                = "" ;
    if ( dflt_coded_pseudo_name        == null ) dflt_coded_pseudo_name        = "" ;
    if ( alt_id1_type                  == null ) alt_id1_type                  = "" ;
    if ( alt_id1_length                == null ) alt_id1_length                = "" ;
    if ( alt_id1_chk_digit_scheme      == null ) alt_id1_chk_digit_scheme      = "" ;
    if ( alt_id1_reqd_yn               == null ) alt_id1_reqd_yn               = "N" ;
    if ( alt_id1_unique_yn             == null ) alt_id1_unique_yn             = "N" ;
    if ( alt_id1_exp_warn_yn           == null ) alt_id1_exp_warn_yn           = "N" ;
    if ( alt_id1_exp_grace_days        == null ) alt_id1_exp_grace_days        = "" ;
    if ( alt_id2_type                  == null ) alt_id2_type                  = "" ;
    if ( alt_id2_length                == null ) alt_id2_length                = "" ;
    if ( alt_id2_chk_digit_scheme      == null ) alt_id2_chk_digit_scheme      = "" ;
	if ( alt_id2_reqd_yn               == null ) alt_id2_reqd_yn               = "N" ;
    if ( alt_id2_unique_yn             == null ) alt_id2_unique_yn             = "N" ;
    if ( alt_id2_exp_warn_yn           == null ) alt_id2_exp_warn_yn           = "N" ;
    if ( alt_id2_exp_grace_days        == null ) alt_id2_exp_grace_days        = "" ;
    if ( alt_id3_type                  == null ) alt_id3_type                  = "" ;
    if ( alt_id3_length                == null ) alt_id3_length                = "" ;
    if ( alt_id3_chk_digit_scheme      == null ) alt_id3_chk_digit_scheme      = "" ;
    if ( alt_id3_reqd_yn               == null ) alt_id3_reqd_yn               = "N" ;
    if ( alt_id3_unique_yn             == null ) alt_id3_unique_yn             = "N" ;
    if ( alt_id3_exp_warn_yn           == null ) alt_id3_exp_warn_yn           = "N" ;
    if ( alt_id3_exp_grace_days        == null ) alt_id3_exp_grace_days        = "" ;
    if ( alt_id4_type                  == null ) alt_id4_type                  = "" ;
    if ( alt_id4_length                == null ) alt_id4_length                = "" ;
    if ( alt_id4_chk_digit_scheme      == null ) alt_id4_chk_digit_scheme      = "" ;
    if ( alt_id4_reqd_yn               == null ) alt_id4_reqd_yn               = "N" ;
    if ( alt_id4_unique_yn             == null ) alt_id4_unique_yn             = "N" ;
    if ( alt_id4_exp_warn_yn           == null ) alt_id4_exp_warn_yn           = "N" ;
    if ( alt_id4_exp_grace_days        == null ) alt_id4_exp_grace_days        = "" ;
    if ( family_no_prompt              == null ) family_no_prompt              = "" ;
    if ( pat_access_hist_no_rec        == null ) pat_access_hist_no_rec        = "" ;
    if ( pat_access_hist_bld_method    == null ) pat_access_hist_bld_method    = "" ;
    if ( dflt_contact_mode1            == null ) dflt_contact_mode1            = "PRN" ;
    if ( dflt_contact_mode2            == null ) dflt_contact_mode2            = "ORN" ;
    if ( dflt_contact_mode3            == null ) dflt_contact_mode3            = "" ;
    if ( dflt_contact_mode4            == null ) dflt_contact_mode4            = "" ;
    if ( dflt_contact_mode5            == null ) dflt_contact_mode5            = "" ;
    if ( dflt_addr_type1               == null ) dflt_addr_type1               = "RES" ;
    if ( dflt_addr_type2               == null ) dflt_addr_type2               = "MAI" ;
    if ( dflt_addr_type3               == null ) dflt_addr_type3               = "" ;
    if ( dflt_addr_type4               == null ) dflt_addr_type4               = "" ;
    if ( dflt_addr_type5               == null ) dflt_addr_type5               = "" ;
    if ( dflt_rel_contact_role1        == null ) dflt_rel_contact_role1        = "" ;
    if ( dflt_rel_contact_role2        == null ) dflt_rel_contact_role2        = "" ;
    if ( dflt_rel_contact_role3        == null ) dflt_rel_contact_role3        = "" ;
    if ( dflt_rel_contact_role4        == null ) dflt_rel_contact_role4        = "" ;
    if ( dflt_rel_contact_role5        == null ) dflt_rel_contact_role5        = "" ;
    if ( dflt_doc1_type                == null ) dflt_doc1_type                = "" ;
    if ( dflt_doc2_type                == null ) dflt_doc2_type                = "" ;
    if ( dflt_doc3_type                == null ) dflt_doc3_type                = "" ;
    if ( dflt_doc4_type                == null ) dflt_doc4_type                = "" ;
    if ( dflt_doc5_type                == null ) dflt_doc5_type                = "" ;
    if ( dflt_pat_fin_class            == null ) dflt_pat_fin_class            = "" ;
    if ( prompt_pat_fin_class_yn       == null ) prompt_pat_fin_class_yn       = "N" ;
    if ( min_age_of_moth       == null ) min_age_of_moth       = "" ;
   
	if ( max_age_of_moth       == null ) max_age_of_moth       = "" ;
    if ( cut_age_of_moth       == null ) cut_age_of_moth       = "" ;
    if ( dft_rel_male_nb       == null ) dft_rel_male_nb       = "" ;
    if ( dft_rel_unknown_nb       == null ) dft_rel_unknown_nb       = "" ;
    if ( dft_rel_female_nb       == null ) dft_rel_female_nb       = "" ;
    if ( allow_nb_regn_unit       == null ) allow_nb_regn_unit       = "H" ;
    if ( Accept_oth_alt_id_yn       == null ) Accept_oth_alt_id_yn       = "N" ;
           
    if ( min_age_of_fath       == null ) min_age_of_fath       = "" ;
    if ( allow_nb_regn_within_days     == null ) allow_nb_regn_within_days     = "" ;
	if ( mul_birth_regn_within_hours     == null ) mul_birth_regn_within_hours     = "" ;

    if ( unit_of_wt_nb                 == null ) unit_of_wt_nb                 = "" ;
    if ( unit_of_circum_nb             == null ) unit_of_circum_nb             = "" ;
    if ( unit_of_chest_circum_nb          == null ) unit_of_chest_circum_nb    = "" ;
    if ( unit_of_length_nb             == null ) unit_of_length_nb             = "" ;
    if ( unit_of_gest_nb               == null ) unit_of_gest_nb               = "" ;
    if ( sub_multi_birth_hw               == null ) sub_multi_birth_hw               = "H" ;
	if (( sub_multi_birth_hw == null )||(sub_multi_birth_hw == "") )sub_multi_birth_hw = "H" ;	
    if ( name_suffix_male_nb           == null ) name_suffix_male_nb           = "" ;
    if ( name_suffix_female_nb         == null ) name_suffix_female_nb         = "" ;
    
    if ( name_prefix_male_nb           == null ) name_prefix_male_nb           = "" ;
    if ( name_prefix_female_nb         == null ) name_prefix_female_nb         = "" ;
    if ( name_prefix_unknown_nb         == null ) name_prefix_unknown_nb         = "" ; //Added by Afruddin for ML-MMOH-CRF-1520 US001 on 4.05.2020
   
    if ( nb_father_name_mandatory_yn         == null ) nb_father_name_mandatory_yn			= "N" ;
	
	if(nb_father_name_mandatory_yn.equals("Y")) fatherValue = "Y";
	else fatherValue = "N";
    if ( nb_mother_dtls_update_yn         == null ) nb_mother_dtls_update_yn			= "N" ;
    if ( data_upd_allowed_aft_final_yn         == null ) data_upd_allowed_aft_final_yn		= "N" ;
   // if ( accept_names_for_live_birth_yn         == null ) accept_names_for_live_birth_yn    = "Y" ;
    if ( dflt_race_nat_setup_nb_as_per         == null ) dflt_race_nat_setup_nb_as_per      = "M" ;

    if ( review_nb_links_bef_reg_yn    == null ) review_nb_links_bef_reg_yn    = "N" ;
	
    if ( length_of_baby_yn    == null ) length_of_baby_yn    = "N" ;
    if ( head_circumference_of_baby_yn    == null ) head_circumference_of_baby_yn    = "N" ;
	
    if ( mandate_first_newborn_yn    == null ) mandate_first_newborn_yn    = "N" ;
    if ( mandate_first_newborn_ip_yn    == null ) mandate_first_newborn_ip_yn    = "N" ;
    if ( mandate_first_newborn_ae_yn    == null ) mandate_first_newborn_ae_yn    = "N" ;
    if ( mandate_second_newborn_yn    == null ) mandate_second_newborn_yn    = "N" ;
    if ( mandate_second_newborn_ip_yn    == null ) mandate_second_newborn_ip_yn    = "N" ;
    if ( mandate_second_newborn_ae_yn    == null ) mandate_second_newborn_ae_yn    = "N" ;
    if ( mandate_third_newborn_yn    == null ) mandate_third_newborn_yn    = "N" ;
    if ( mandate_third_newborn_ip_yn    == null ) mandate_third_newborn_ip_yn    = "N" ;
    if ( mandate_third_newborn_ae_yn    == null ) mandate_third_newborn_ae_yn    = "N" ;
    if ( mand_antenatal_newborn_yn    == null ) mand_antenatal_newborn_yn    = "N" ;
    if ( mand_antenatal_newborn_ip_yn    == null ) mand_antenatal_newborn_ip_yn    = "N" ;
    if ( mand_antenatal_newborn_ae_yn    == null ) mand_antenatal_newborn_ae_yn    = "N" ;
	
	if ( allow_ext_nb_regn_within_days    == null ) allow_ext_nb_regn_within_days    = "" ;
	if ( enable_marital_status    == null ) enable_marital_status    = "N" ;
    if ( dflt_father_first_name_prompt    == null ) dflt_father_first_name_prompt    = "N" ;
    if ( dflt_father_Second_name_prompt    == null ) dflt_father_Second_name_prompt    = "N" ;
    if ( dflt_father_third_name_prompt    == null ) dflt_father_third_name_prompt    = "N" ;
    if ( dflt_father_family_name_prompt    == null ) dflt_father_family_name_prompt    = "N" ;
	if	(enable_marital_status.equals("Y")) maritalValue = "Y";
	else maritalValue = "N";
    if ( single_stage_nb_reg_appl_yn    == null ) single_stage_nb_reg_appl_yn    = "N" ;
    if ( mod_birth_reg_appl_yn    == null ) mod_birth_reg_appl_yn    = "N" ; //Added by Prakash on 03rd Oct 2023 ML-MMOH-CRF-2046
  //  if ( invoke_chg_pat_dtls_fm_nb_yn    == null ) invoke_chg_pat_dtls_fm_nb_yn    = "N" ;
    if ( nb_use_mother_ser    == null ) nb_use_mother_ser    = "N" ;
    
    if ( search_threshold_records      == null ) search_threshold_records      = "" ;
    if ( sex_hist_yn                   == null ) sex_hist_yn                   = "N" ;
    if ( birth_date_hist_yn            == null ) birth_date_hist_yn            = "N" ;
    if ( legal_name_hist_yn            == null ) legal_name_hist_yn            = "N" ;
    if ( alias_name_hist_yn            == null ) alias_name_hist_yn            = "N" ;
    if ( coded_pseudo_name_hist_yn     == null ) coded_pseudo_name_hist_yn     = "N" ;
    if ( contact_no_hist_yn            == null ) contact_no_hist_yn            = "N" ;
    if ( address_hist_yn               == null ) address_hist_yn               = "N" ;
    if ( ocpn_n_empl_hist_yn           == null ) ocpn_n_empl_hist_yn           = "N" ;
    if ( general_alert_info_hist_yn    == null ) general_alert_info_hist_yn    = "N" ;
    if ( suspend_reinstate_hist_yn     == null ) suspend_reinstate_hist_yn     = "N" ;
    if ( inactivate_activate_hist_yn   == null ) inactivate_activate_hist_yn   = "N" ;
    if ( rec_revoke_death_hist_yn      == null ) rec_revoke_death_hist_yn      = "N" ;
    if ( added_by_id                   == null ) added_by_id                   = "" ;
    if ( added_date                    == null ) added_date                    = "" ;
    if ( added_at_ws_no                == null ) added_at_ws_no                = "" ;
    if ( modified_by_id                == null ) modified_by_id                = "" ;
    if ( modified_date                 == null ) modified_date                 = "" ;
    if ( modified_at_ws_no             == null ) modified_at_ws_no             = "" ;
    if ( hr_interface_yn               == null ) hr_interface_yn               = "N" ;
    if ( hr_check_digit_scheme         == null ) hr_check_digit_scheme         = "" ;
    if ( his_interface_yn              == null ) his_interface_yn              = "N" ;
    if ( age_limit_for_service       == null ) age_limit_for_service       = "" ;

	if ( alt_id1_len_validation_yn       == null )alt_id1_len_validation_yn    = "N" ;
    if ( alt_id2_len_validation_yn       == null ) alt_id2_len_validation_yn   = "N" ;
    if ( alt_id3_len_validation_yn       == null ) alt_id3_len_validation_yn   = "N" ;
    if ( alt_id4_len_validation_yn       == null ) alt_id4_len_validation_yn   = "N" ; 

    if ( alt_id1_exp_date_accept_yn      == null ) alt_id1_exp_date_accept_yn      = "N" ;
    if ( alt_id2_exp_date_accept_yn      == null ) alt_id2_exp_date_accept_yn      = "N" ;
    if ( alt_id3_exp_date_accept_yn      == null ) alt_id3_exp_date_accept_yn      = "N" ;
    if ( alt_id4_exp_date_accept_yn      == null ) alt_id4_exp_date_accept_yn      = "N" ;

    if ( alt_id1_invoke_routine       == null )alt_id1_invoke_routine    = "N" ;
    if ( alt_id2_invoke_routine       == null ) alt_id2_invoke_routine   = "N" ;
    if ( alt_id3_invoke_routine       == null ) alt_id3_invoke_routine   = "N" ;
    if ( alt_id4_invoke_routine       == null ) alt_id4_invoke_routine   = "N" ; 

    if ( alt_id1_routine_name      == null ) alt_id1_routine_name      = "" ;
    if ( alt_id2_routine_name      == null ) alt_id2_routine_name      = "" ;
    if ( alt_id3_routine_name      == null ) alt_id3_routine_name      = "" ;
    if ( alt_id4_routine_name      == null ) alt_id4_routine_name      = "" ;
    
    //ML-MMOH-CRF-1759.1-US001 starts
    if(mand_parity_newborn_ae_yn == null) mand_parity_newborn_ae_yn = "N";
    if(mand_parity_newborn_ip_yn == null) mand_parity_newborn_ip_yn = "N";
    if(mand_parity_newborn_yn == null) mand_parity_newborn_yn = "N";
    if(invoke_menstrual_history_yn==null) invoke_menstrual_history_yn="N";
    //ML-MMOH-CRF-1759.1-US001 ends
		if(pstmt != null) pstmt.close();
		if(rs != null) rs.close();


		pstmt = con.prepareStatement( "select count(*) as total from sm_language where language_direction='R' and eff_status='E'" ) ;
		
		rs = pstmt.executeQuery() ;
             
			
          if ( rs != null && rs.next() ) 
		  {
			count = rs.getInt("total");
		  }

		if ( count==1 ) 
		{
			 language_direction = "R" ;
		}else
		{
			 language_direction = "L" ;
		}


            _bw.write(_wl_block8Bytes, _wl_block8);
if(isStartWith){
            _bw.write(_wl_block9Bytes, _wl_block9);
}
            _bw.write(_wl_block10Bytes, _wl_block10);
if(mpDisableFieldsNBFather){
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(fatherValue));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(maritalValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(maritalValue));
            _bw.write(_wl_block14Bytes, _wl_block14);
}
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
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

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
 if("Y".equalsIgnoreCase(aadharProfileYN)) {
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
 } 
            _bw.write(_wl_block26Bytes, _wl_block26);
 if(module_instal_ind.equals("DMS")) { 
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
} else { 
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
}
            _bw.write(_wl_block31Bytes, _wl_block31);
 if(module_instal_ind.equals("DMS")) { 
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
 } else {
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
 }
            _bw.write(_wl_block34Bytes, _wl_block34);

                            if ( operation.equalsIgnoreCase( "insert" ) )
                                out.println( "<input type='text' name='patient_id_length' id='patient_id_length' size='2' maxlength='2' value='" + patient_id_length + "' onkeypress='return allowValidNumber(this,event,2, 0);' onBlur='CheckNum(this);checkDecimal(this);'>" ) ;
                            else if (operation.equalsIgnoreCase( "modify" ) )
                                out.println( "<input type='text' name='patient_id_length' id='patient_id_length' size='2' maxlength='2' value='" + patient_id_length + "' disabled>" ) ;
                        
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);

                 
						if ( operation.equalsIgnoreCase( "insert" ) ) {
                                if ( patient_no_ctrl.equals( "Z" ) )
                                    out.println( "<input type='radio' name='patient_no_ctrl' id='patient_no_ctrl' value='Z' checked >"+com.ehis.util.BundleMessage.getBundleMessage( pageContext,"Common.by.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Site.label","common_labels")+"&nbsp;" ) ;
                                else
                                    out.println( "<input type='radio' name='patient_no_ctrl' id='patient_no_ctrl' value='Z'>"+com.ehis.util.BundleMessage.getBundleMessage( pageContext,"Common.by.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Site.label","common_labels")+"&nbsp;" ) ;

                                if ( patient_no_ctrl.equals( "U" ) )
                                    out.println( "<input type='radio' name='patient_no_ctrl' id='patient_no_ctrl' value='U' checked >"+com.ehis.util.BundleMessage.getBundleMessage( pageContext,"Common.by.label","common_labels")+" "+ com.ehis.util.BundleMessage.getBundleMessage( pageContext,"Common.facility.label","common_labels")+"&nbsp;" ) ;
                                else
                                    out.println( "<input type='radio' name='patient_no_ctrl' id='patient_no_ctrl' value='U' >"+com.ehis.util.BundleMessage.getBundleMessage( pageContext,"Common.by.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage( pageContext,"Common.facility.label","common_labels")+"&nbsp;" ) ;

                                if ( patient_no_ctrl.equals( "C" ) )
                                    out.println( "<input type='radio' name='patient_no_ctrl' id='patient_no_ctrl' value='C' checked >"+com.ehis.util.BundleMessage.getBundleMessage( pageContext,"Common.by.label","common_labels")+" "+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Combination.label","mp_labels")+"&nbsp;" ) ;
                                else
                                    out.println( "<input type='radio' name='patient_no_ctrl' id='patient_no_ctrl' value='C' >"+com.ehis.util.BundleMessage.getBundleMessage( pageContext,"Common.by.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Combination.label","mp_labels")+"&nbsp;" ) ;
                                   
                            }

                            if ( operation.equalsIgnoreCase( "modify" ) ) {
                                if ( patient_no_ctrl.equals( "Z" ) )
                                    out.println("<input type='radio' name='patient_no_ctrl' id='patient_no_ctrl' value='Z' checked disabled>"+com.ehis.util.BundleMessage.getBundleMessage( pageContext,"Common.by.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Site.label","common_labels")+"&nbsp;" ) ;
                                else
                                    out.println( "<input type='radio' name='patient_no_ctrl' id='patient_no_ctrl' value='Z' disabled>"+com.ehis.util.BundleMessage.getBundleMessage( pageContext,"Common.by.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Site.label","common_labels")+"&nbsp;" ) ;

                                if ( patient_no_ctrl.equals( "U" ) )
                                    out.println("<input type='radio' name='patient_no_ctrl' id='patient_no_ctrl' value='U' checked disabled>"+com.ehis.util.BundleMessage.getBundleMessage( pageContext,"Common.by.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage( pageContext,"Common.facility.label","common_labels")+"&nbsp;" ) ;
                                else
                                    out.println("<input type='radio' name='patient_no_ctrl' id='patient_no_ctrl' value='U' disabled>"+com.ehis.util.BundleMessage.getBundleMessage( pageContext,"Common.by.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage( pageContext,"Common.facility.label","common_labels")+"&nbsp;" ) ;

                                if ( patient_no_ctrl.equals( "C" ) )
                                    out.println("<input type='radio' name='patient_no_ctrl' id='patient_no_ctrl' value='C' checked disabled>"+com.ehis.util.BundleMessage.getBundleMessage( pageContext,"Common.by.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Combination.label","mp_labels")+"&nbsp;" ) ;
                                else
                                    out.println("<input type='radio' name='patient_no_ctrl' id='patient_no_ctrl' value='C' disabled>"+com.ehis.util.BundleMessage.getBundleMessage( pageContext,"Common.by.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Combination.label","mp_labels")+"&nbsp;" ) ;
                            }
                        
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

										
									//CC
										if ( operation.equalsIgnoreCase( "insert" ) ) 
											{
													out.println("<input type='checkbox' name='gen_patid_using_altid_rl_yn' id='gen_patid_using_altid_rl_yn' value='N'              onclick=generateAltIDRule(this)>");
										}
										
													if(gen_pid_using_aid1_rule_yn.equals("Y"))
												{
										       single_patient_numbering_yn="N";
												}
										
										if(single_patient_numbering_yn.equals("Y")){
										gen_pid_using_aid1_rule_yn="N";
																					}
										
										if ( operation.equalsIgnoreCase( "modify" )) 
											{
													if(gen_pid_using_aid1_rule_yn.equals("Y"))
												
																								{
												out.println("<input type='checkbox' name='gen_patid_using_altid_rl_yn' id='gen_patid_using_altid_rl_yn' value='Y'  	   disabled checked					onclick=generateAltIDRule(this)>  ");
												}
												else 
								
								out.println("<input type='checkbox'   name='gen_patid_using_altid_rl_yn' id='gen_patid_using_altid_rl_yn' value='N'  disabled onclick=generateAltIDRule(this) >" ); 
									}
	                               
									
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

										
									//CC
										if ( operation.equalsIgnoreCase( "insert" )) 
											{
													out.println("<input type='checkbox' name='single_patient_numbering_yn' value='N' onclick=generateSinglePatientNoAppl(this) ");
										}
										
										
										if ( operation.equalsIgnoreCase( "modify")) 
											{
													
													if(single_patient_numbering_yn.equals("Y"))
												
																								{
												
												out.println("<input type='checkbox' name='single_patient_numbering_yn' value='Y'  	   disabled checked ");
												}
												else 
								
								out.println("<input type='checkbox'   name='single_patient_numbering_yn' id='single_patient_numbering_yn' value='Y'  disabled>" ); 
									}
	                               
									
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(chkAcceptNat));
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);

                            String ext_intf_chked = "" ;
                          
                            if ( operation.equalsIgnoreCase( "modify" ) )
                            {
                                if(ext_system_interface_yn.equals("Y"))
                                    ext_intf_chked = "checked";
                            }
                        
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(ext_intf_chked));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(ext_intf_chked));
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);

							
						/*if ( operation.equalsIgnoreCase( "modify" ) )
                        {
						if (nat_id_accept_alphanumeric_yn.equals("Y"))
							chkAcceptAlpha = "Checked disabled";
						}*/
						if ( operation.equalsIgnoreCase( "modify" ) )
                            {
                                if(nat_id_accept_alphanumeric_yn.equals("Y")) 
                                    chkAcceptAlpha = "checked" ;
                            }
                            if ( operation.equalsIgnoreCase( "insert" ) )
                                out.println("<input type='checkbox' name='nat_id_accept_alphanumeric_yn' id='nat_id_accept_alphanumeric_yn' value='Y' onclick='enaChkDigit(this);'>");
                            else if ( operation.equalsIgnoreCase( "modify" ) )
                                out.println("<input type='checkbox' name='nat_id_accept_alphanumeric_yn' id='nat_id_accept_alphanumeric_yn' value='Y' "+chkAcceptAlpha+" disabled >");

						
            _bw.write(_wl_block50Bytes, _wl_block50);
if(isStartWith){
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);

                        
						if ( operation.equalsIgnoreCase( "insert" ) )
                                out.println( "<input type='text' name='start_with' id='start_with' id='start_with' value='' onBlur='chkStartWith(this.value,this.name)' maxlength='4' size='4'>" ) ;

                        if ( operation.equalsIgnoreCase( "modify" ) )
                                out.println( "<input type='text' name='start_with' id='start_with' id='start_with' value=\""+start_with+"\" onBlur='chkStartWith(this.value,this.name)' maxlength='4' size='4'>" ) ;
                        
            _bw.write(_wl_block53Bytes, _wl_block53);
}
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);

                        /*Modified by Ashwini on 18-Jan-2017 for ML-MMOH-CRF-0895*/
						if ( operation.equalsIgnoreCase( "insert" ) )
                                out.println( "<input type='text' name='nat_prompt' id='nat_prompt' value='' maxlength='10' size='10' onBlur='makeValidString(this); removeSpace(this);'>" ) ;

                        if ( operation.equalsIgnoreCase( "modify" ) )
                                out.println( "<input type='text' name='nat_prompt' id='nat_prompt' value=\""+nat_prompt+"\" onBlur='makeValidString(this); removeSpace(this);' maxlength='10' size='10' dis>" ) ;
                        
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);

                       
						if ( operation.equalsIgnoreCase( "insert" ) )
                                out.println( "<input type='text' name='nat_id_length' id='nat_id_length' size='2' maxlength='2' onkeypress='return allowValidNumber(this,event,2, 0);' onBlur='CheckNum(this);checkDecimal(this);checkNatIdLength();'>" ) ;

                            if ( operation.equalsIgnoreCase( "modify" ) )

                                out.println( "<input type='text' name='nat_id_length' id='nat_id_length' size='2' maxlength='2' value='" + nat_id_length + "' disabled>" ) ;
                        
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);

                            String chked = "" ;
                          
                            if ( operation.equalsIgnoreCase( "modify" ) )
                            {
                                if(nat_reqd_for_all_ser.equals("Y"))
                                    chked = "checked";
                            }
                        
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(chked));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(chked));
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);

									out.println("<Option value='N' "+col1+" >National ID series");
                                    out.println("<Option value='A' "+col2+">All series");
                                    out.println("<Option value='B' "+col3+">New Born");

									/* - Commented by Marimuthu for DLA Changes 

									
                                    if (nat_reqd_for_all_ser.equals("Y"))
                                    {
                                        {out.println("<Option value='N' "+col1+" >National ID series");}
                                        {out.println("<Option value='A' "+col2+">All series");}
                                        {out.println("<Option value='B' "+col3+">New Born");}
                                    }
                                    else
                                    {
                                        {out.println("<Option value='N' "+col1+" >National ID series");}
                                    } 
									

									End of Comment */
                                
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);

                            chked="" ;
					
                            if ( operation.equalsIgnoreCase( "modify" ) )
                            {
                                if(chk_len.equals("Y")) 
                                    chked = "checked" ;
                            }
                            if ( operation.equalsIgnoreCase( "insert" ) )
                                out.println("<input type='checkbox' name='chk_len' id='chk_len' value='Y'>");
                            else if ( operation.equalsIgnoreCase( "modify" ) )
                                out.println("<input type='checkbox' name='chk_len' id='chk_len' value='Y' "+chked+" disabled >");
                        
            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);

                            ArrayList chk_digit_code = new ArrayList();
                            ArrayList chk_digit_val = new ArrayList();
                            String sql ="select * from mp_check_digit_scheme where eff_status='E'";

                            stmt11 = con.createStatement() ;
                            rset11 = stmt11.executeQuery(sql) ;
							
				
							
                            if(rset11 != null)
                            {
                                while(rset11.next())
                                {
                                    chk_digit_code .add(rset11.getString("SCHEME_ID")) ;
                                    chk_digit_val  .add(rset11.getString("SCHEME_NAME")) ;
                                }
                            }
                        
            _bw.write(_wl_block68Bytes, _wl_block68);

							if ( operation.equalsIgnoreCase( "modify" ) )
                                out.println( "<select name='nat_chk_dig_scheme' id='nat_chk_dig_scheme' disabled>" ) ;
						    if ( operation.equalsIgnoreCase( "insert" ) )
						          out.println( "<select name='nat_chk_dig_scheme' id='nat_chk_dig_scheme' >" ) ;
                           
                        
            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);

									for(int i=0;i<chk_digit_code.size();i++)
                                    {
										String sel = "" ;
                                        if(nat_chk_dig_scheme.equals((String)chk_digit_code.get(i)))
                                          sel = "selected";
										/* Only MOD 11 should be displayed */
                                        if (chk_digit_code.get(i).equals("M11")) 
										out.println( "<option value='"+chk_digit_code.get(i)+"' "+sel+">"+chk_digit_val.get(i)+"</option>" ) ;

										if (chk_digit_code.get(i).equals("M05")) 
										out.println( "<option value='"+chk_digit_code.get(i)+"' "+sel+">"+chk_digit_val.get(i)+"</option>" ) ;
                                    }								
                                
            _bw.write(_wl_block71Bytes, _wl_block71);

                                ArrayList routine_names = new ArrayList();
                                ArrayList routine_ids   = new ArrayList();
								if(pstmt!=null) pstmt.close();
								if(rs!=null) rs.close();
                                pstmt = con.prepareStatement("select initcap(ROUTINE_DESC)ROUTINE_NAME,DATASOURCE_ID from mp_custom_routine ");
                                
                                rs = pstmt.executeQuery();
								
                                while( rs.next() )
                                {
                                    routine_names.add(rs.getString("ROUTINE_NAME")) ;
                                    routine_ids.add(rs.getString("DATASOURCE_ID")) ;
                                }
                                if(pstmt != null)    pstmt.close();
                                if(rs != null)    rs.close();
								
                            
            _bw.write(_wl_block72Bytes, _wl_block72);

                            chked="" ;
                            if ( operation.equalsIgnoreCase( "modify" ) )
                                if(nat_invoke_routine.equals("Y")) 
                                    chked = "checked" ;
                        
            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);

                            if ( operation.equalsIgnoreCase( "insert" ) )
                                out.println("<input type='checkbox' name='nat_invoke_routine' id='nat_invoke_routine' value='Y' onclick='chkRoutine(this,nat_id_routine_name)' >");
                            else if ( operation.equalsIgnoreCase( "modify" ) )
                                out.println("<input type='checkbox' name='nat_invoke_routine' id='nat_invoke_routine' value='Y' "+chked+" disabled >");
                        
            _bw.write(_wl_block74Bytes, _wl_block74);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block75Bytes, _wl_block75);

                           
						String disabled = "disabled";
                                if(nat_invoke_routine.equals("Y")) 
                                    disabled = "";
                                if ( operation.equalsIgnoreCase( "insert" ) )
                                    out.println("<select name='nat_id_routine_name' id='nat_id_routine_name' "+disabled+ " >");
                                else if ( operation.equalsIgnoreCase( "modify" ) )
                                    out.println("<select name='nat_id_routine_name' id='nat_id_routine_name' disabled >");
                         
            _bw.write(_wl_block76Bytes, _wl_block76);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);


                        
									for(int i=0;i<routine_names.size();i++)
                                    {
                                        String sel = "" ;
                                        if(nat_id_routine_name.equals((String)routine_ids.get(i)) && disabled.equals("") )
                                            sel = "selected";
                                        
                                     if ( operation.equalsIgnoreCase( "insert" ) )
                                        {
                                           out.println("<option value='"+routine_ids.get(i)+"' "+sel+">"+routine_names.get(i)+"</option>") ;
                                        }

                                     else if( operation.equalsIgnoreCase( "modify" ) )
                                        {
                                           out.println("<option value='"+routine_ids.get(i)+"' "+sel+" >"+routine_names.get(i)+"</option>") ;
                                        }
                                   } 
                                
            _bw.write(_wl_block78Bytes, _wl_block78);
if(isNatIdAltIdMandVisaType) {
							String enableDisableNatIdDft = "";
							if(dft_national_id.equals(""))
							enableDisableNatIdDft="";
							else
							enableDisableNatIdDft="disabled";							
							
            _bw.write(_wl_block79Bytes, _wl_block79);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(dft_national_id));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(enableDisableNatIdDft));
            _bw.write(_wl_block82Bytes, _wl_block82);
}
            _bw.write(_wl_block83Bytes, _wl_block83);
  
                       
                       String disbled="disabled";
                      if(function_name.equals("01")){
                       		chked="" ;
                           if ( operation.equalsIgnoreCase( "modify" ) )
                               if(biometric_authentication_yn.equals("Y")) {
                                   chked = "checked" ;
                                   disbled="";
                               }
                       
                       
            _bw.write(_wl_block84Bytes, _wl_block84);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block85Bytes, _wl_block85);

	                            if ( operation.equalsIgnoreCase( "insert" ) )
	                                out.println("<input type='checkbox' name='biometric_authentication' id='biometric_authentication' id='biometric_authentication' value='Y' "+chked+" >");
	                            else if ( operation.equalsIgnoreCase( "modify" ) )
	                                out.println("<input type='checkbox' name='biometric_authentication' id='biometric_authentication' id='biometric_authentication' value='Y' "+chked+" >");
	                        
            _bw.write(_wl_block86Bytes, _wl_block86);
 } 
            _bw.write(_wl_block87Bytes, _wl_block87);
 if(module_instal_ind.equals("DMS")) { 
            _bw.write(_wl_block88Bytes, _wl_block88);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block89Bytes, _wl_block89);
} else { 
            _bw.write(_wl_block88Bytes, _wl_block88);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block90Bytes, _wl_block90);
}
            _bw.write(_wl_block91Bytes, _wl_block91);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block92Bytes, _wl_block92);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block93Bytes, _wl_block93);


                                pstmt = con.prepareStatement( "select pat_ser_grp_code, short_Desc from mp_pat_ser_grp where id_type in('G','U') order by short_Desc" ) ;
                                rs = pstmt.executeQuery() ;
								
								
                                if( rs != null ) {
                                    while( rs.next() ) {
                                        String groupCode = rs.getString( "pat_ser_grp_code" ) ;
                                        String groupName = rs.getString( "short_Desc" ) ;

                                        if ( groupCode.equals( gen_pat_ser_grp ) )
                                            out.println( "<option selected value='" + groupCode + "' >"+ groupName ) ;
                                        else
                                            out.println( "<option value='" + groupCode + "' >" + groupName ) ;
                                    }
                                }

                                if(pstmt!=null) pstmt.close() ;
								if(rs!=null) rs.close();
                            
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block95Bytes, _wl_block95);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block96Bytes, _wl_block96);

                                stmt = con.createStatement() ;
                                rset = stmt.executeQuery ( " select short_Desc, Pat_Ser_grp_Code from MP_PAT_SER_GRP where ID_Type in('B','U')  order by short_Desc" ) ;
								
								
                                if(rset != null)
                                {
                                    while(rset.next())
                                    {
                                        chked = "" ;
                                        
                                        if(newborn_pat_ser_grp.equals(rset.getString("Pat_Ser_grp_Code")))
                                            chked = "selected" ;
                                            out.println( "<option value='"+rset.getString("Pat_Ser_grp_Code")+"' "+chked+">"+rset.getString("Short_Desc")+"</option>" ) ; 
                                    }
                                }

                            
            _bw.write(_wl_block97Bytes, _wl_block97);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block96Bytes, _wl_block96);


                                pstmt = con.prepareStatement( "select pat_ser_grp_code, short_Desc from mp_pat_ser_grp where id_type in('N','U') order by short_Desc" ) ;
                                rs = pstmt.executeQuery() ;
									
                                if( rs != null ) {
                                    while( rs.next() ) {
                                        String groupCode = rs.getString( "pat_ser_grp_code" ) ;
                                        String groupName = rs.getString( "short_Desc" ) ;

                                        if ( groupCode.equals( nat_id_pat_ser_grp ) )
                                            out.println( "<option selected value='" + groupCode + "' >"+ groupName ) ;
                                        else
                                            out.println( "<option value='" + groupCode + "' >" + groupName ) ;
                                    }
                                }

                                if(pstmt!=null) pstmt.close() ;
								if(rs!=null) rs.close();
                            
            _bw.write(_wl_block99Bytes, _wl_block99);

							if (accept_national_id_no_yn.equals("Y"))						
								out.println("<script>document.mp_param_form.nat_id_pat_ser_grp.disabed= false;</script>");
							else																			out.println("<script>document.mp_param_form.nat_id_pat_ser_grp.disabled=	true;</script>");
						
            _bw.write(_wl_block100Bytes, _wl_block100);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block101Bytes, _wl_block101);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block96Bytes, _wl_block96);


                                rset = stmt.executeQuery ( " select short_Desc, Pat_Ser_grp_Code from MP_PAT_SER_GRP where ID_Type in('E','U') and GEN_PID_USING_ALT_ID1_RULE_YN='N'  order by short_Desc" ) ;
							
                                if(rset != null)
                                {                                   
                                    while(rset.next()) 
                                    {
                                        chked = "" ;
                                        if(emeg_pat_ser_grp.equals(rset.getString("Pat_Ser_grp_Code")))
                                            chked = "selected" ;
                                            out.println( "<option value='"+rset.getString("Pat_Ser_grp_Code")+"' "+chked+">"+rset.getString("Short_Desc")+"</option>" ) ; 
                                    }
                                }
                                if(stmt != null)    stmt.close();
                                if(rset != null)    rset.close();
                            
            _bw.write(_wl_block102Bytes, _wl_block102);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block103Bytes, _wl_block103);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block96Bytes, _wl_block96);


                                pstmt = con.prepareStatement( "select pat_ser_grp_code, short_Desc from mp_pat_ser_grp where id_type in('A','U') order by short_Desc" ) ;
                                rs = pstmt.executeQuery() ;
                          
                                if( rs != null ) {
                                    while( rs.next() ) {
                                        String groupCode = rs.getString( "pat_ser_grp_code" ) ;
                                        String groupName = rs.getString( "short_Desc" ) ;

                                        if ( groupCode.equals( alt_id_pat_ser_grp ) )
                                            out.println( "<option selected value='" + groupCode + "' >"+ groupName ) ;
                                        else
                                            out.println( "<option value='" + groupCode + "' >" + groupName ) ;
                                    }
                                }

                               if(pstmt!=null) pstmt.close() ;
							   if(rs!=null) rs.close();
                            
            _bw.write(_wl_block104Bytes, _wl_block104);

            if (_jsp__tag49(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block105Bytes, _wl_block105);

								String nat_id_count = "";
								String alt_id_count = "";

								pst = con.prepareStatement("select count(1) nat_id_count from mp_pat_ser_grp where id_type='N'");
								res = pst.executeQuery();
							
								if(res.next())
								{
									nat_id_count = res.getString("nat_id_count");
									
								}
																
								pst1=con.prepareStatement("select count(1) alt_id_count from mp_pat_ser_grp where id_type='A'");
								res1 = pst1.executeQuery();
							
								if(res1.next())
								{
									alt_id_count = res1.getString("alt_id_count");
									
								}
							
            _bw.write(_wl_block106Bytes, _wl_block106);

                                if ( dflt_pat_ser_grp_type.equals( "G" ) )
                                    out.println( "<option selected value='G'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.general.label","common_labels")+"</Option>");
                                else
                                    out.println( "<option value='G'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.general.label","common_labels")+"</Option>");

                                if ( dflt_pat_ser_grp_type.equals( "N" ) )
                                    out.println( "<option selected value='N'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.NationalID.label","mp_labels")+"</Option>");
                                else
                                    out.println( "<option value='N'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.NationalID.label","mp_labels")+"</Option>");

                                if ( dflt_pat_ser_grp_type.equals( "A" ) )
									out.println( "<option selected value='A'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AlternateID.label","common_labels")+"1</Option>");
                                else
                                   out.println( "<option value='A'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AlternateID.label","common_labels")+"1</Option>");
                            
            _bw.write(_wl_block107Bytes, _wl_block107);

            if (_jsp__tag50(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block108Bytes, _wl_block108);
            _bw.write(_wl_block109Bytes, _wl_block109);

									String chk_create_file = "";
									String dis_create_file = "";

									if ( operation.equalsIgnoreCase( "insert" ) ) 
									{ 
										chk_create_file = "checked";
										dis_create_file = "";
									}
									else if (operation.equalsIgnoreCase( "modify" ))
									{
										if(create_file_yn.equals("Y"))
											chk_create_file = "checked";
										else
											chk_create_file = "";

										dis_create_file = "disabled";
									}
								
            _bw.write(_wl_block110Bytes, _wl_block110);

            if (_jsp__tag51(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(chk_create_file));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(dis_create_file));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(create_file_yn));
            _bw.write(_wl_block113Bytes, _wl_block113);

            if (_jsp__tag52(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block114Bytes, _wl_block114);

                                  
									if ( operation.equalsIgnoreCase( "insert" ) ) { 
									   
                                            out.println( "<input type='radio' name='single_or_multi_files_ind' id='single_or_multi_files_ind' value='S' onClick='checkNumberingControl(\"S\")' checked >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.single.label","common_labels")+"&nbsp;" ) 
;										                                       
                                            out.println( "<input type='radio' name='single_or_multi_files_ind' id='single_or_multi_files_ind' value='M' onClick='checkNumberingControl(\"M\")' checked >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.multiple.label","common_labels") ) ;

											out.println( "<input type='radio' name='single_or_multi_files_ind' id='single_or_multi_files_ind' value='B' disabled onClick='checkNumberingControl(\"B\")' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.none.label","common_labels") ) ;
                                        
									}
									if ( operation.equalsIgnoreCase( "modify" ) ) { 
									    if ( single_or_multi_files_ind.equals( "S" ) )
                                            out.println( "<input type='radio' name='single_or_multi_files_ind' id='single_or_multi_files_ind' value='S' onClick='checkNumberingControl(\"S\")'  checked disabled>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.single.label","common_labels")+"&nbsp;" ) 
;
                                        else
                                            out.println( "<input type='radio' name='single_or_multi_files_ind' id='single_or_multi_files_ind' value='S' onClick='checkNumberingControl(\"S\")' disabled>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.single.label","common_labels")+"&nbsp;" ) ;

                                        if ( single_or_multi_files_ind.equals( "M" ) )
                                            out.println( "<input type='radio' name='single_or_multi_files_ind' id='single_or_multi_files_ind' value='M' onClick='checkNumberingControl(\"M\")' checked disabled>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.multiple.label","common_labels") ) ;
                                        else
                                            out.println( "<input type='radio' name='single_or_multi_files_ind' id='single_or_multi_files_ind' value='M' onClick='checkNumberingControl(\"M\")' disabled>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.multiple.label","common_labels") ) ;

										if (single_or_multi_files_ind.equals("B") )
                                            out.println( "<input type='radio' name='single_or_multi_files_ind' id='single_or_multi_files_ind' value='B' checked onClick='checkNumberingControl(\"B\")' disabled>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.none.label","common_labels") ) ;
                                        else
                                            out.println( "<input type='radio' name='single_or_multi_files_ind' id='single_or_multi_files_ind' value='B' onClick='checkNumberingControl(\"B\")' disabled>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.none.label","common_labels") ) ;
									}
                                    
            _bw.write(_wl_block115Bytes, _wl_block115);

            if (_jsp__tag53(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag54(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block116Bytes, _wl_block116);

                                        if ( operation.equalsIgnoreCase( "insert" ) ) {
                                            if ( separate_file_no_yn.equals( "Y" ) )
                                                out.println( "<input type='radio' name='separate_file_no_yn' id='separate_file_no_yn' value='Y' checked onClick='checkNumberingControl(\"A\")'   >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.AllowseparateMRN.label","mp_labels")+"&nbsp;" ) ;
                                            else
                                                out.println( "<input type='radio' name='separate_file_no_yn' id='separate_file_no_yn' value='Y' onClick='checkNumberingControl(\"F\")' checked >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.AllowseparateMRN.label","mp_labels")+"&nbsp;" ) ;

                                            if ( separate_file_no_yn.equals( "N" ) )
                                                out.println( "&nbsp;&nbsp;<input type='radio' name='separate_file_no_yn' id='separate_file_no_yn' value='N' onClick='checkNumberingControl(\"A\")' checked >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.KeepFileNumbersameasPatientID.label","mp_labels") ) ;
                                            else
                                                out.println( "&nbsp;&nbsp;<input type='radio' name='separate_file_no_yn' id='separate_file_no_yn' value='N' onClick='checkNumberingControl(\"F\")'  >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.KeepFileNumbersameasPatientID.label","mp_labels") ) ;

											if ( separate_file_no_yn.equals( "B" ) )
												out.println( "&nbsp;&nbsp;<input type='radio' name='separate_file_no_yn' id='separate_file_no_yn' value='B' checked onClick='checkNumberingControl(\"B\")' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.none.label","common_labels") ) ;   
											else
												out.println( "&nbsp;&nbsp;<input type='radio' name='separate_file_no_yn' id='separate_file_no_yn' value='B' disabled onClick='checkNumberingControl(\"B\")' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.none.label","common_labels") ) ;   
												
                                        }
										String enabledisable1 = "";
									
										if(single_or_multi_files_ind.equals("M"))
											enabledisable1="";
										else
											enabledisable1="disabled";
                                        if ( operation.equalsIgnoreCase( "modify" ) ) {
                                            if ( separate_file_no_yn.equals( "Y" ) )
                                                out.println( "<input type='radio' name='d_separate_file_no_yn' id='d_separate_file_no_yn' value='Y' checked disabled>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.AllowseparateMRN.label","mp_labels")+"&nbsp;" ) ;
                                            else
                                                out.println( "<input type='radio' name='d_separate_file_no_yn' id='d_separate_file_no_yn' value='Y' disabled>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.AllowseparateMRN.label","mp_labels")+"&nbsp;" ) ;

                                            if ( separate_file_no_yn.equals( "N" ) )
                                                out.println( "<input type='radio' name='d_separate_file_no_yn' id='d_separate_file_no_yn' value='N' checked disabled>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.KeepFileNumbersameasPatientID.label","mp_labels") ) ;
                                            else
                                                out.println( "<input type='radio' name='d_separate_file_no_yn' id='d_separate_file_no_yn' value='N' disabled>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.KeepFileNumbersameasPatientID.label","mp_labels") ) ;

											if (separate_file_no_yn.equals("B") )
                                                out.println( "<input type='radio' name='d_separate_file_no_yn' id='d_separate_file_no_yn' value='B' checked onClick='checkNumberingControl(\"B\")' disabled>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.none.label","common_labels") ) ;
                                            else
                                                out.println( "<input type='radio' name='d_separate_file_no_yn' id='d_separate_file_no_yn' value='B' onClick='checkNumberingControl(\"B\")' disabled>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.none.label","common_labels") ) ;
                                        }
                                    
            _bw.write(_wl_block117Bytes, _wl_block117);

									  if(create_file_at_pat_regn_yn.equals("Y"))
										enabledisable = "";
									  else
										enabledisable = "disabled";   
									
            _bw.write(_wl_block118Bytes, _wl_block118);

            if (_jsp__tag55(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block119Bytes, _wl_block119);
 if(module_instal_ind.equals("DMS")) { 
            _bw.write(_wl_block120Bytes, _wl_block120);

            if (_jsp__tag56(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block121Bytes, _wl_block121);
 } else{
            _bw.write(_wl_block122Bytes, _wl_block122);

            if (_jsp__tag57(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block121Bytes, _wl_block121);
}
            _bw.write(_wl_block123Bytes, _wl_block123);

									if(operation.equalsIgnoreCase("insert" )){
									if(create_file_at_pat_regn_yn.equals("Y")){
									
            _bw.write(_wl_block124Bytes, _wl_block124);
}else{
            _bw.write(_wl_block125Bytes, _wl_block125);
}
									}if(operation.equalsIgnoreCase("modify")){
									if(create_file_at_pat_regn_yn.equals("Y")){
									
            _bw.write(_wl_block126Bytes, _wl_block126);
}else{
            _bw.write(_wl_block127Bytes, _wl_block127);
}}
            _bw.write(_wl_block128Bytes, _wl_block128);

            if (_jsp__tag58(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block129Bytes, _wl_block129);

									
									if(operation.equalsIgnoreCase("insert" )){
									if(create_file_at_admission.equals("Y")){
									
            _bw.write(_wl_block130Bytes, _wl_block130);
}else{
            _bw.write(_wl_block131Bytes, _wl_block131);
}
									}if(operation.equalsIgnoreCase("modify")){
									if(create_file_at_admission.equals("Y")){
									
            _bw.write(_wl_block132Bytes, _wl_block132);
}else{
            _bw.write(_wl_block133Bytes, _wl_block133);
}}
            _bw.write(_wl_block134Bytes, _wl_block134);

            if (_jsp__tag59(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block129Bytes, _wl_block129);

									if(operation.equalsIgnoreCase("insert" )){
									if(create_file_at_reg_visit_yn.equals("Y")){
									
            _bw.write(_wl_block135Bytes, _wl_block135);
}else{
            _bw.write(_wl_block136Bytes, _wl_block136);
}
									}if(operation.equalsIgnoreCase("modify")){
									if(create_file_at_reg_visit_yn.equals("Y")){
									
            _bw.write(_wl_block137Bytes, _wl_block137);
}else{
            _bw.write(_wl_block138Bytes, _wl_block138);
}}
            _bw.write(_wl_block139Bytes, _wl_block139);

            if (_jsp__tag60(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag61(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block129Bytes, _wl_block129);

									if(operation.equalsIgnoreCase("insert" )){
									if(create_file_at_reg_att_yn.equals("Y")){
									
            _bw.write(_wl_block140Bytes, _wl_block140);
}else{
            _bw.write(_wl_block141Bytes, _wl_block141);
}
									}if(operation.equalsIgnoreCase("modify")){
									if(create_file_at_reg_att_yn.equals("Y")){
									
            _bw.write(_wl_block142Bytes, _wl_block142);
}else{
            _bw.write(_wl_block143Bytes, _wl_block143);
}}
            _bw.write(_wl_block144Bytes, _wl_block144);

            if (_jsp__tag62(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag63(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block129Bytes, _wl_block129);

										
									if(operation.equalsIgnoreCase("insert" )){
									if(create_file_at_dc_admission_yn.equals("Y")){
									
            _bw.write(_wl_block145Bytes, _wl_block145);
}else{
            _bw.write(_wl_block146Bytes, _wl_block146);
}
									}if(operation.equalsIgnoreCase("modify")){
									if(create_file_at_dc_admission_yn.equals("Y")){
									
            _bw.write(_wl_block147Bytes, _wl_block147);
}else{
            _bw.write(_wl_block148Bytes, _wl_block148);
}}
            _bw.write(_wl_block149Bytes, _wl_block149);

            if (_jsp__tag64(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block150Bytes, _wl_block150);

            if (_jsp__tag65(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block151Bytes, _wl_block151);

            if (_jsp__tag66(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block152Bytes, _wl_block152);

								if (operation.equalsIgnoreCase( "insert" ) )
										out.println( "<input type='checkbox' name='family_no_link_yn' id='family_no_link_yn' value='' onclick='sel_familyLink(this)'>" ) ;

									if (operation.equalsIgnoreCase( "modify" ) ) {
										if ( family_no_link_yn.equals( "Y" ) )
											out.println( "<input type='checkbox' name='family_no_link_yn' id='family_no_link_yn' value='Y' checked disabled>" ) ;
										else
											out.println( "<input type='checkbox' name='family_no_link_yn' id='family_no_link_yn' value='Y' disabled>" ) ;
									}
								
            _bw.write(_wl_block153Bytes, _wl_block153);

            if (_jsp__tag67(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block154Bytes, _wl_block154);

								if (operation.equalsIgnoreCase( "insert" ) ){
							           out.println( "<input type='checkbox' name='family_org_id_accept_yn' id='family_org_id_accept_yn' value='N' Onclick='maintainOrgMembership(this);' >");
								}else{
                                if (operation.equalsIgnoreCase( "modify" ) ) {
                                    if ( family_org_id_accept_yn.equals("Y") )
                                        out.println( "<input type='checkbox' name='family_org_id_accept_yn' id='family_org_id_accept_yn' value='Y'  checked disabled>" ) ;
                                    else
                                        out.println( "<input type='checkbox' name='family_org_id_accept_yn' id='family_org_id_accept_yn' value='N' disabled>" ) ;
                                }
							}
                            
            _bw.write(_wl_block155Bytes, _wl_block155);

            if (_jsp__tag68(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block156Bytes, _wl_block156);

									 if ( family_org_id_accept_yn.equals( "N" ) )				
										out.println("<select name='org_member_relationship_code' id='org_member_relationship_code' disabled> <option value='' selected>----------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"----------</option>");
									else
									{

										if ( operation.equalsIgnoreCase( "insert" ) )
										{
            _bw.write(_wl_block157Bytes, _wl_block157);

            if (_jsp__tag69(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block158Bytes, _wl_block158);
}
										else if ( operation.equalsIgnoreCase( "modify" ) )
										{
											stmt = con.createStatement();
											rs = stmt.executeQuery("select short_desc from mp_relationship where relationship_code='"+org_member_relationship_code+"'");
												out.println("<select name='org_member_relationship_code' id='org_member_relationship_code' disabled>");
											if (rs.next()){
												out.println("<option value='"+org_member_relationship_code+"'>"+rs.getString("short_desc")+"</option>");
												//out.println("<img src='../images/mandatory.gif'></img>");
											}
											else
												out.println("<option value=''>&nbsp;&nbsp;</option>");
										}
									}
								
            _bw.write(_wl_block159Bytes, _wl_block159);
if ( operation.equalsIgnoreCase( "insert" ) ){
            _bw.write(_wl_block160Bytes, _wl_block160);

            if (_jsp__tag70(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block161Bytes, _wl_block161);

            if (_jsp__tag71(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block162Bytes, _wl_block162);

            if (_jsp__tag72(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block163Bytes, _wl_block163);
}else {if ( family_org_id_accept_yn.equals( "Y" ) ){
            _bw.write(_wl_block164Bytes, _wl_block164);

            if (_jsp__tag73(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block165Bytes, _wl_block165);
  if ( family_org_id_accept_yn.equals( "N" ) )	 {
            _bw.write(_wl_block166Bytes, _wl_block166);
}  else {
            _bw.write(_wl_block167Bytes, _wl_block167);

            if (_jsp__tag74(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block168Bytes, _wl_block168);
}
            _bw.write(_wl_block169Bytes, _wl_block169);
}else{
            _bw.write(_wl_block170Bytes, _wl_block170);
}}
            _bw.write(_wl_block171Bytes, _wl_block171);

            if (_jsp__tag75(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block172Bytes, _wl_block172);

            if (_jsp__tag76(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block173Bytes, _wl_block173);

            if (_jsp__tag77(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block174Bytes, _wl_block174);

            if (_jsp__tag78(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag79(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag80(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag81(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag82(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag83(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag84(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block175Bytes, _wl_block175);
 if("Y".equalsIgnoreCase(aadharProfileYN)) {
            _bw.write(_wl_block176Bytes, _wl_block176);

            if (_jsp__tag85(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
 } 
            _bw.write(_wl_block177Bytes, _wl_block177);
 if(module_instal_ind.equals("DMS")) { 
            _bw.write(_wl_block178Bytes, _wl_block178);

            if (_jsp__tag86(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block179Bytes, _wl_block179);
}else{
            _bw.write(_wl_block178Bytes, _wl_block178);

            if (_jsp__tag87(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
} 
            _bw.write(_wl_block180Bytes, _wl_block180);

                                chked = "checked" ;
                                if(name_in_oth_lang_yn.equals("N"))
                                {
                                    chked ="" ;
                                }
                            
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(chked));
            _bw.write(_wl_block182Bytes, _wl_block182);

            if (_jsp__tag88(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block183Bytes, _wl_block183);

                            
						if ( dflt_sndx_type.equals("") )
                                    out.println( "<option selected value=''>--"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"--" ) ;
                                else
                                    out.println( "<option value=''>--"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"--" ) ;

                                if ( dflt_sndx_type.equals( "G" ) )
                                    out.println( "<option selected value='G'>Generic" ) ;
                                else
                                    out.println( "<option value='G'>Generic" ) ;

                                if ( dflt_sndx_type.equals( "E" ) )
									out.println( "<option selected value='E'>Ethnic" ) ;
                                else
                                   out.println( "<option value='E'>Ethnic" ) ;

                            
            _bw.write(_wl_block184Bytes, _wl_block184);
 if(module_instal_ind.equals("DMS")) { 
            _bw.write(_wl_block185Bytes, _wl_block185);

            if (_jsp__tag89(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block179Bytes, _wl_block179);
}else{
            _bw.write(_wl_block186Bytes, _wl_block186);

            if (_jsp__tag90(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
}
            _bw.write(_wl_block187Bytes, _wl_block187);
		//code for Insert  Mode
                              if ( operation.equalsIgnoreCase( "insert" ) ) {
                                if ( pat_name_as_multipart_yn.equals( "Y" ) )
                                    out.println( "<input type='checkbox' name='pat_name_as_multipart_yn' id='pat_name_as_multipart_yn' value='Y' onClick='enableNames();' checked>" ) ;                  
								else
                                    out.println( "<input type='checkbox' name='pat_name_as_multipart_yn' id='pat_name_as_multipart_yn' value='Y' onClick='enableNames();' >" ) ;
                            }
								// Code for Modify Mode
                            if ( operation.equalsIgnoreCase( "modify" ) ) {
                                if ( pat_name_as_multipart_yn.equals( "Y" ) )
                                    out.println( "<input type='checkbox' name='pat_name_as_multipart_yn' id='pat_name_as_multipart_yn' checked disabled>" ) ;
                                else
                                    out.println( "<input type='checkbox' name='pat_name_as_multipart_yn' id='pat_name_as_multipart_yn' disabled >" ) ;
                            }
                        
            _bw.write(_wl_block188Bytes, _wl_block188);

            if (_jsp__tag91(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block189Bytes, _wl_block189);

            if (_jsp__tag92(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block190Bytes, _wl_block190);

            if (_jsp__tag93(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block191Bytes, _wl_block191);

            if (_jsp__tag94(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block192Bytes, _wl_block192);

            if (_jsp__tag95(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block193Bytes, _wl_block193);

            if (_jsp__tag96(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block194Bytes, _wl_block194);

            if (_jsp__tag97(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block195Bytes, _wl_block195);

            if (_jsp__tag98(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block196Bytes, _wl_block196);

						String ena_dis_loc_lang = "";
                            if (name_in_oth_lang_yn.equals("N"))
                                ena_dis_loc_lang = "disabled";
                            else
                                ena_dis_loc_lang = "";

                            if ( operation.equalsIgnoreCase( "insert" ) ) {
                                if ( name_prefix_accept_yn.equals( "Y" ) )
                                    out.println( "<input type='checkbox' name='name_prefix_accept_yn' id='name_prefix_accept_yn' value='Y' onClick='checkLegalNames(1)' checked>" ) ;                                else
                                    out.println( "<input type='checkbox' name='name_prefix_accept_yn' id='name_prefix_accept_yn' value='Y' onClick='checkLegalNames(1)' >" ) ;
                            }

                            if ( operation.equalsIgnoreCase( "modify" ) ) {
                                if ( name_prefix_accept_yn.equals( "Y" ) )
                                    out.println( "<input type='checkbox' name='d_name_prefix_accept_yn' id='d_name_prefix_accept_yn' checked disabled>" ) ;
                                else
                                    out.println( "<input type='checkbox' name='d_name_prefix_accept_yn' id='d_name_prefix_accept_yn' disabled >" ) ;
                            }
                        
            _bw.write(_wl_block197Bytes, _wl_block197);

                            if ( operation.equalsIgnoreCase( "insert" ) ) {
                                    out.println( "<input type='text' name='name_prefix_length' id='name_prefix_length' value='"+name_prefix_length+"' maxlength='2' size='2' onblur='validatelength(this)'>" ) ;                     
                            }

                            if ( operation.equalsIgnoreCase( "modify" ) ) {
                                    out.println( "<input type='text' name='name_prefix_length' id='name_prefix_length' value='"+name_prefix_length+"' maxlength='2' size='2' onblur='validatelength(this)' disabled>" ) ; 
                            }
                        
            _bw.write(_wl_block198Bytes, _wl_block198);

						if ( operation.equalsIgnoreCase( "insert" ) ) {
							out.println("<input type='checkbox' name='name_pfx_reqd_for_org_mem_yn' id='name_pfx_reqd_for_org_mem_yn'  value='N' onclick='check_fmorg_fun(this)' disabled>");
						}else if(operation.equalsIgnoreCase( "modify" )){
							if(name_pfx_reqd_for_org_mem_yn.equals("Y"))
								out.println("<input type='checkbox' name='name_pfx_reqd_for_org_mem_yn' id='name_pfx_reqd_for_org_mem_yn'  value='Y' checked disabled>");
							else
								out.println("<input type='checkbox' name='name_pfx_reqd_for_org_mem_yn' id='name_pfx_reqd_for_org_mem_yn'  value='N' disabled>");
						}
						
            _bw.write(_wl_block199Bytes, _wl_block199);

                     
						if ( operation.equalsIgnoreCase( "insert" ) ) {
                                if ( name_prefix_reqd_yn.equals( "Y" ) )
                                    out.println( "<input type='checkbox' name='name_prefix_reqd_yn' id='name_prefix_reqd_yn' value='Y' onClick='checkLegalNames(1)' checked>" ) ;
                                else
                                    out.println( "<input type='checkbox' name='name_prefix_reqd_yn' id='name_prefix_reqd_yn' value='Y' onClick='checkLegalNames(1)'>" ) ;
                            }

                            if ( operation.equalsIgnoreCase( "modify" ) ) {
                                if ( name_prefix_reqd_yn.equals( "Y" ) )
                                    out.println( "<input type='checkbox' name='d_name_prefix_reqd_yn' id='d_name_prefix_reqd_yn' checked disabled>" ) ;
                                else
                                    out.println( "<input type='checkbox' name='d_name_prefix_reqd_yn' id='d_name_prefix_reqd_yn' disabled>" ) ;
                            }
                        
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf( name_prefix_prompt ));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf( name_prefix_loc_lang_prompt ));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(ena_dis_loc_lang));
            _bw.write(_wl_block203Bytes, _wl_block203);


							out.println("<input type='text' name='name_prefix_loc_lang_prompt' id='name_prefix_loc_lang_prompt' size='15' maxlength='15' value='"+ name_prefix_loc_lang_prompt +"' onFocus='checkLegalNames(1)' '"+ena_dis_loc_lang+"' onblur='makeValidString(this)'");

							if(language_direction.equals("R"))
							{
							out.println( "dir='RTL'> ");
							}else
							{
							out.println( " > ");
							}

								
            _bw.write(_wl_block204Bytes, _wl_block204);

            if (_jsp__tag99(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block205Bytes, _wl_block205);

                       
						if ( operation.equalsIgnoreCase( "insert" ) ) {
                                if ( first_name_accept_yn.equals( "Y" ) )
                                    out.println( "<input type='checkbox' name='first_name_accept_yn' id='first_name_accept_yn' value='Y'  onClick='checkLegalNames(2)' checked>" ) ;
                                else
                                    out.println( "<input type='checkbox' name='first_name_accept_yn' id='first_name_accept_yn' value='Y' onClick='checkLegalNames(2)' >" ) ;
                            }

                            if ( operation.equalsIgnoreCase( "modify" ) ) {
                                if ( first_name_accept_yn.equals( "Y" ) )
                                    out.println( "<input type='checkbox' name='d_first_name_accept_yn' id='d_first_name_accept_yn' checked disabled>" ) ;
                                else
                                    out.println( "<input type='checkbox' name='d_first_name_accept_yn' id='d_first_name_accept_yn' disabled>" ) ;
                            }
                        
            _bw.write(_wl_block197Bytes, _wl_block197);

                            if ( operation.equalsIgnoreCase( "insert" ) ) {
                                    out.println( "<input type='text' name='first_name_length' id='first_name_length' value='"+first_name_length+"' maxlength='2' size='2' onblur='validatelength(this)'>" ) ;                     
                            }

                            if ( operation.equalsIgnoreCase( "modify" ) ) {
                                   out.println( "<input type='text' name='first_name_length' id='first_name_length' value='"+first_name_length+"' maxlength='2' size='2' onblur='validatelength(this)' disabled>" ) ; 
									
                            }
                        
            _bw.write(_wl_block206Bytes, _wl_block206);

                          
						if ( operation.equalsIgnoreCase( "insert" ) ) {
                                if ( first_name_reqd_yn.equals( "Y" ) )
                                    out.println( "<input type='checkbox' name='first_name_reqd_yn' id='first_name_reqd_yn' value='Y' onFocus='checkLegalNames(2)' onClick='checkLegalNames(2)' checked>" ) ;
                                else
                                    out.println( "<input type='checkbox' name='first_name_reqd_yn' id='first_name_reqd_yn' value='Y' onFocus='checkLegalNames(2)' onClick='checkLegalNames(2)' >" ) ;
                            }

                            if ( operation.equalsIgnoreCase( "modify" ) ) {
                                if ( first_name_reqd_yn.equals( "Y" ) )
                                    out.println( "<input type='checkbox' name='d_first_name_reqd_yn' id='d_first_name_reqd_yn' checked disabled>" ) ;
                                else
                                    out.println( "<input type='checkbox' name='d_first_name_reqd_yn' id='d_first_name_reqd_yn' disabled>" ) ;
                            }
                        
            _bw.write(_wl_block207Bytes, _wl_block207);

                        
						if ( operation.equalsIgnoreCase( "insert" ) )
                                out.println( "<input type='text' name='first_name_order' id='first_name_order' size='1' maxlength='1' value='" + first_name_order +"' onFocus='checkLegalNames(2)' onBlur='CheckNum(this);checkDecimal(this);checkZero(this)'>" ) ;
                            if ( operation.equalsIgnoreCase( "modify" ) )
                                out.println( "<input type='text' name='d_first_name_order' id='d_first_name_order' size='1' maxlength='1' value='" + first_name_order +"' disabled >" ) ;
                        
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf( first_name_prompt ));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf( first_name_loc_lang_prompt ));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(ena_dis_loc_lang));
            _bw.write(_wl_block211Bytes, _wl_block211);

							out.println( "<input type='text' name='first_name_loc_lang_prompt' id='first_name_loc_lang_prompt' size='15' maxlength='15' value='"+ first_name_loc_lang_prompt+"' onFocus='checkLegalNames(2)' '"+ena_dis_loc_lang+"' ");
							
							if(language_direction.equals("R"))
							{
							out.println( "dir='RTL'> ");
							}else
							{
							out.println( " > ");
							}


							
            _bw.write(_wl_block212Bytes, _wl_block212);

            if (_jsp__tag100(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block205Bytes, _wl_block205);

                            if ( operation.equalsIgnoreCase( "insert" ) ) {
                                if ( second_name_accept_yn.equals( "Y" ) )
                                    out.println( "<input type='checkbox' name='second_name_accept_yn' id='second_name_accept_yn' value='Y'  onClick='checkLegalNames(3)' checked>" ) ;
                                else
                                    out.println( "<input type='checkbox' name='second_name_accept_yn' id='second_name_accept_yn' value='Y' onClick='checkLegalNames(3)' >" ) ;
                            }

                            if ( operation.equalsIgnoreCase( "modify" ) ) {
                                if ( second_name_accept_yn.equals( "Y" ) )
                                    out.println( "<input type='checkbox' name='d_second_name_accept_yn' id='d_second_name_accept_yn' value='Y' checked disabled>" ) ;
                                else
                                    out.println( "<input type='checkbox' name='d_second_name_accept_yn' id='d_second_name_accept_yn' value='Y' disabled>" ) ;
                            }
                        
            _bw.write(_wl_block197Bytes, _wl_block197);

                            if ( operation.equalsIgnoreCase( "insert" ) ) {
                                    out.println( "<input type='text' name='second_name_length' id='second_name_length' value='"+second_name_length+"' maxlength='2' size='2' onblur='validatelength(this)'>" ) ;                     
                            }

                            if ( operation.equalsIgnoreCase( "modify" ) ) {
                                    out.println( "<input type='text' name='second_name_length' id='second_name_length' value='"+second_name_length+"' maxlength='2' size='2' onblur='validatelength(this)' disabled>" ) ; 

									 
                            }
                        
            _bw.write(_wl_block206Bytes, _wl_block206);

                            if ( operation.equalsIgnoreCase( "insert" ) ) {
                                if ( second_name_reqd_yn.equals( "Y" ) )
                                    out.println( "<input type='checkbox' name='second_name_reqd_yn' id='second_name_reqd_yn' value='Y' onFocus='checkLegalNames(3)' onClick='checkLegalNames(3)' checked>" ) ;
                                else
                                    out.println( "<input type='checkbox' name='second_name_reqd_yn' id='second_name_reqd_yn' value='Y' onFocus='checkLegalNames(3)' onClick='checkLegalNames(3)' >" ) ;
                            }

                            if ( operation.equalsIgnoreCase( "modify" ) ) {
                                if ( second_name_reqd_yn.equals( "Y" ) )
                                    out.println( "<input type='checkbox' name='d_second_name_reqd_yn' id='d_second_name_reqd_yn' checked disabled>" ) ;
                                else
                                    out.println( "<input type='checkbox' name='d_second_name_reqd_yn' id='d_second_name_reqd_yn' disabled>" ) ;
                            }
                        
            _bw.write(_wl_block207Bytes, _wl_block207);

                            if ( operation.equalsIgnoreCase( "insert" ) )
                                out.println( "<input type='text' name='second_name_order' id='second_name_order' size='1' maxlength='1' value='" + second_name_order +"' onFocus='checkLegalNames(3)' onBlur='CheckNum(this);checkDecimal(this);checkZero(this)'>" ) ;

                            if ( operation.equalsIgnoreCase( "modify" ) )
                                out.println( "<input type='text' name='d_second_name_order' id='d_second_name_order' size='1' maxlength='1' value='" + second_name_order +"' disabled >" ) ;                        
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf( second_name_prompt ));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf( second_name_loc_lang_prompt ));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(ena_dis_loc_lang));
            _bw.write(_wl_block216Bytes, _wl_block216);

							
							out.println("<input type='text' name='second_name_loc_lang_prompt' id='second_name_loc_lang_prompt' size='15' maxlength='15' value='"+second_name_loc_lang_prompt+"' onFocus='checkLegalNames(3)' '"+ena_dis_loc_lang+"' onblur='makeValidString(this)'");

							if(language_direction.equals("R"))
							{
							out.println( "dir='RTL'> ");
							}else
							{
							out.println( " > ");
							}

							
            _bw.write(_wl_block217Bytes, _wl_block217);

            if (_jsp__tag101(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block205Bytes, _wl_block205);

                            if ( operation.equalsIgnoreCase( "insert" ) ) {
                                if ( third_name_accept_yn.equals( "Y" ) )
                                    out.println( "<input type='checkbox' name='third_name_accept_yn' id='third_name_accept_yn' value='Y'  onClick='checkLegalNames(4)' checked>" ) ;
                                else
                                    out.println( "<input type='checkbox' name='third_name_accept_yn' id='third_name_accept_yn' value='Y' onClick='checkLegalNames(4)' >" ) ;
                            }

                            if ( operation.equalsIgnoreCase( "modify" ) ) {
                                if ( third_name_accept_yn.equals( "Y" ) )
                                    out.println( "<input type='checkbox' name='d_third_name_accept_yn' id='d_third_name_accept_yn' checked disabled>" ) ;
                                else
                                    out.println( "<input type='checkbox' name='d_third_name_accept_yn' id='d_third_name_accept_yn' disabled>" ) ;
                            }
                        
            _bw.write(_wl_block197Bytes, _wl_block197);

                            if ( operation.equalsIgnoreCase( "insert" ) ) {
                                    out.println( "<input type='text' name='third_name_length' id='third_name_length' value='"+third_name_length+"' maxlength='2' size='2' onblur='validatelength(this)'>" ) ;                     
                            }

                            if ( operation.equalsIgnoreCase( "modify" ) ) {
                                    out.println( "<input type='text' name='third_name_length' id='third_name_length' value='"+third_name_length+"' maxlength='2' size='2' onblur='validatelength(this)' disabled>" ) ; 

									 
                            }
                        
            _bw.write(_wl_block206Bytes, _wl_block206);

                   
						if ( operation.equalsIgnoreCase( "insert" ) ) {
                                if ( third_name_reqd_yn.equals( "Y" ) )
                                    out.println( "<input type='checkbox' name='third_name_reqd_yn' id='third_name_reqd_yn' value='Y' onFocus='checkLegalNames(4)' onClick='checkLegalNames(4)' checked>" ) ;
                                else
                                    out.println( "<input type='checkbox' name='third_name_reqd_yn' id='third_name_reqd_yn' value='Y' onFocus='checkLegalNames(4)' onClick='checkLegalNames(4)' >" ) ;
                            }

                            if ( operation.equalsIgnoreCase( "modify" ) ) {
                                if ( third_name_reqd_yn.equals( "Y" ) )
                                    out.println( "<input type='checkbox' name='d_third_name_reqd_yn' id='d_third_name_reqd_yn' checked disabled>" ) ;
                                else
                                    out.println( "<input type='checkbox' name='d_third_name_reqd_yn' id='d_third_name_reqd_yn' disabled >" ) ;
                            }
                        
            _bw.write(_wl_block207Bytes, _wl_block207);

                            if ( operation.equalsIgnoreCase( "insert" ) )
                                out.println( "<input type='text' name='third_name_order' id='third_name_order' size='1' maxlength='1' value='" + third_name_order +"' onFocus='checkLegalNames(4)' onBlur='CheckNum(this);checkDecimal(this);checkZero(this)'>" ) ;

                            if ( operation.equalsIgnoreCase( "modify" ) )
                                out.println( "<input type='text' name='d_third_name_order' id='d_third_name_order' size='1' maxlength='1' value='" + third_name_order +"' disabled >" ) ;
                        
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf( third_name_prompt ));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf( third_name_loc_lang_prompt ));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(ena_dis_loc_lang));
            _bw.write(_wl_block216Bytes, _wl_block216);


							out.println("<input type='text' name='third_name_loc_lang_prompt' id='third_name_loc_lang_prompt' size='15' maxlength='15' value='"+third_name_loc_lang_prompt+"' onFocus='checkLegalNames(4)' '"+ena_dis_loc_lang+"' onblur='makeValidString(this)'");


							if(language_direction.equals("R"))
							{
							out.println( "dir='RTL'> ");
							}else
							{
							out.println( " > ");
							}

							
            _bw.write(_wl_block217Bytes, _wl_block217);

            if (_jsp__tag102(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block205Bytes, _wl_block205);

                       
						if ( operation.equalsIgnoreCase( "insert" ) ) {
                                if ( family_name_accept_yn.equals( "Y" ) )
                                    out.println( "<input type='checkbox' name='family_name_accept_yn' id='family_name_accept_yn' value='Y' onClick='checkLegalNames(5)' checked>" ) ;
                                else
                                    out.println( "<input type='checkbox' name='family_name_accept_yn' id='family_name_accept_yn' value='Y' onClick='checkLegalNames(5)' >" ) ;
                            }

                            if ( operation.equalsIgnoreCase( "modify" ) ) {
                                if ( family_name_accept_yn.equals( "Y" ) )
                                    out.println( "<input type='checkbox' name='d_family_name_accept_yn' id='d_family_name_accept_yn' checked disabled>" ) ;
                                else
                                    out.println( "<input type='checkbox' name='d_family_name_accept_yn' id='d_family_name_accept_yn' disabled >" ) ;
                            }
                        
            _bw.write(_wl_block197Bytes, _wl_block197);

                            if ( operation.equalsIgnoreCase( "insert" ) ) {
                                    out.println( "<input type='text' name='family_name_length' id='family_name_length' value='"+family_name_length+"' maxlength='2' size='2' onblur='validatelength(this)'>" ) ;                     
                            }

                            if ( operation.equalsIgnoreCase( "modify" ) ) {
                                    out.println( "<input type='text' name='family_name_length' id='family_name_length' value='"+family_name_length+"' maxlength='2' size='2' onblur='validatelength(this)' disabled>" ) ; 

									
                            }
                        
            _bw.write(_wl_block206Bytes, _wl_block206);

                      
						if ( operation.equalsIgnoreCase( "insert" ) ) {
                                if ( family_name_reqd_yn.equals( "Y" ) )
                                    out.println( "<input type='checkbox' name='family_name_reqd_yn' id='family_name_reqd_yn' value='Y' onFocus='checkLegalNames(5)' onClick='checkLegalNames(5)' checked>" ) ;
                                else
                                    out.println( "<input type='checkbox' name='family_name_reqd_yn' id='family_name_reqd_yn' value='Y' onFocus='checkLegalNames(5)' onClick='checkLegalNames(5)' >" ) ;
                            }

                            if ( operation.equalsIgnoreCase( "modify" ) ) {
                                if ( family_name_reqd_yn.equals( "Y" ) )
                                    out.println( "<input type='checkbox' name='d_family_name_reqd_yn' id='d_family_name_reqd_yn' checked disabled>" ) ;
                                else
                                    out.println( "<input type='checkbox' name='d_family_name_reqd_yn' id='d_family_name_reqd_yn' disabled>" ) ;
                            }
                        
            _bw.write(_wl_block207Bytes, _wl_block207);

                       
						if ( operation.equalsIgnoreCase( "insert" ) )
                                out.println( "<input type='text' name='family_name_order' id='family_name_order' size='1' maxlength='1' value='" + family_name_order +"' onFocus='checkLegalNames(5)' onBlur='CheckNum(this);checkDecimal(this);checkZero(this)'>" ) ;

                            if ( operation.equalsIgnoreCase( "modify" ) )
                                out.println( "<input type='text' name='d_family_name_order' id='d_family_name_order' size='1' maxlength='1' value='" + family_name_order +"' disabled >" ) ;                        
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf( family_name_prompt ));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf( family_name_loc_lang_prompt ));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(ena_dis_loc_lang));
            _bw.write(_wl_block216Bytes, _wl_block216);

							out.println("<input type='text' name='family_name_loc_lang_prompt' id='family_name_loc_lang_prompt' size='15' maxlength='15' value='"+family_name_loc_lang_prompt+"' onFocus='checkLegalNames(5)' '"+ena_dis_loc_lang+"' onblur='makeValidString(this)'");

							if(language_direction.equals("R"))
							{
							out.println( "dir='RTL'> ");
							}else
							{
							out.println( " > ");
							}

							
            _bw.write(_wl_block224Bytes, _wl_block224);

            if (_jsp__tag103(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block205Bytes, _wl_block205);

                        
						if ( operation.equalsIgnoreCase( "insert" ) ) {
                                if ( name_suffix_accept_yn.equals( "Y" ) )
                                    out.println( "<input type='checkbox' name='name_suffix_accept_yn' id='name_suffix_accept_yn' value='Y'  onClick='checkLegalNames(6)' checked>" ) ;
                                else
                                    out.println( "<input type='checkbox' name='name_suffix_accept_yn' id='name_suffix_accept_yn' value='Y' onClick='checkLegalNames(6)' >" ) ;
                            }

                            if ( operation.equalsIgnoreCase( "modify" ) ) {
                                if ( name_suffix_accept_yn.equals( "Y" ) )
                                    out.println( "<input type='checkbox' name='d_name_suffix_accept_yn' id='d_name_suffix_accept_yn' checked disabled>" ) ;
                                else
                                    out.println( "<input type='checkbox' name='d_name_suffix_accept_yn' id='d_name_suffix_accept_yn' disabled>" ) ;
                            }
                        
            _bw.write(_wl_block197Bytes, _wl_block197);

                            if ( operation.equalsIgnoreCase( "insert" ) ) {
                                    out.println( "<input type='text' name='name_suffix_length' id='name_suffix_length' value='"+name_suffix_length+"' maxlength='2' size='2' onblur='validatelength(this)'>" ) ;                     
                            }

                            if ( operation.equalsIgnoreCase( "modify" ) ) {
                                    out.println( "<input type='text' name='name_suffix_length' id='name_suffix_length' value='"+name_suffix_length+"' maxlength='2' size='2' onblur='validatelength(this)' disabled>" ) ; 
                            }
                        
            _bw.write(_wl_block225Bytes, _wl_block225);

                       
						if ( operation.equalsIgnoreCase( "insert" ) ) {
                                if ( name_suffix_reqd_yn.equals( "Y" ) )
                                    out.println( "<input type='checkbox' name='name_suffix_reqd_yn' id='name_suffix_reqd_yn' value='Y' onFocus='checkLegalNames(6)' onClick='checkLegalNames(6)' checked>" ) ;
                                else
                                    out.println( "<input type='checkbox' name='name_suffix_reqd_yn' id='name_suffix_reqd_yn' value='Y' onFocus='checkLegalNames(6)' onClick='checkLegalNames(6)' >" ) ;
                            }

                            if ( operation.equalsIgnoreCase( "modify" ) ) {
                                if ( name_suffix_reqd_yn.equals( "Y" ) )
                                    out.println( "<input type='checkbox' name='d_name_suffix_reqd_yn' id='d_name_suffix_reqd_yn' checked disabled>" ) ;
                                else
                                    out.println( "<input type='checkbox' name='d_name_suffix_reqd_yn' id='d_name_suffix_reqd_yn' disabled>" ) ;
                            }
                        
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf( name_suffix_prompt ));
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf( name_suffix_loc_lang_prompt ));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(ena_dis_loc_lang));
            _bw.write(_wl_block229Bytes, _wl_block229);


						out.println("<input type='text' name='name_suffix_loc_lang_prompt' id='name_suffix_loc_lang_prompt' size='15' maxlength='15' value='"+name_suffix_loc_lang_prompt+"' onFocus='checkLegalNames(6)' '"+ena_dis_loc_lang+"' onblur='makeValidString(this)'");

						if(language_direction.equals("R"))
						{
						out.println( "dir='RTL'> ");
						}else
						{
						out.println( " > ");
						}

						
            _bw.write(_wl_block230Bytes, _wl_block230);

            if (_jsp__tag104(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block231Bytes, _wl_block231);

            if (_jsp__tag105(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block232Bytes, _wl_block232);

                            if ( operation.equalsIgnoreCase( "insert" ))
                                out.println( "<input type='text' name='name_dervn_logic' id='name_dervn_logic' value='" + name_dervn_logic + "' size='30' maxlength='50' onkeypress='return SplCharsChkForNameDrvn(event);' onBlur='checkNameDervnLogic(this);'>" ) ;

                            if (operation.equalsIgnoreCase( "modify" ))
                                out.println( "<input type='text' name='name_dervn_logic' id='name_dervn_logic' value='" + name_dervn_logic + "' size='30' maxlength='50' disabled>" ) ;
                        
            _bw.write(_wl_block233Bytes, _wl_block233);

            if (_jsp__tag106(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block232Bytes, _wl_block232);

						if (operation.equalsIgnoreCase( "insert" ))
							{
                                out.println( "<input type='text' name='for_loc_lang' id='for_loc_lang' value='" + name_dervn_logic_oth_lang + "' size='30' maxlength='50' onkeypress='return SplCharsChkForNameDrvn(event);' onBlur='checkNameDervnLogic(this);return SplCharsChkForNameDrvn(event)' ");

								if(language_direction.equals("R"))
								{
								out.println("dir='RTL'");
								}
												
								//out.println(" readonly>" ) ;
								out.println(" disabled >" ) ;
							}

                            if (operation.equalsIgnoreCase( "modify" ) )
							{	
                                out.println( "<input type='text' name='for_loc_lang' id='for_loc_lang' value='" + name_dervn_logic_oth_lang + "' size='30' maxlength='50' ") ;
								
								if(language_direction.equals("R"))
								{
								out.println("dir='RTL'");
								}
												
								out.println(" disabled >" ) ;
							}
                        
            _bw.write(_wl_block234Bytes, _wl_block234);
 if(module_instal_ind.equals("DMS")) { 
            _bw.write(_wl_block235Bytes, _wl_block235);

            if (_jsp__tag107(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block236Bytes, _wl_block236);
}else {
            _bw.write(_wl_block235Bytes, _wl_block235);

            if (_jsp__tag108(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block236Bytes, _wl_block236);
}
            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf(dflt_patient_name));
            _bw.write(_wl_block238Bytes, _wl_block238);

            if (_jsp__tag109(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block231Bytes, _wl_block231);

            if (_jsp__tag110(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block232Bytes, _wl_block232);

                            if ( operation.equalsIgnoreCase( "insert" ))
                                out.println( "<input type='text' name='long_name_dervn_logic' id='long_name_dervn_logic' value='" + name_dervn_logic_long + "' size='60' maxlength='100' onkeypress='return SplCharsChkForNameDrvn(event);' onBlur='checkNameDervnLogic(this);'>" ) ;

                           String dis_able="";
						   if(! name_dervn_logic_long.equals("")){
							   dis_able="disabled";
						   }
							
							if (operation.equalsIgnoreCase( "modify" ))
                                out.println( "<input type='text' name='long_name_dervn_logic' id='long_name_dervn_logic' value='" + name_dervn_logic_long + "' size='60' maxlength='100' "+dis_able+">" ) ;
                        
            _bw.write(_wl_block239Bytes, _wl_block239);

            if (_jsp__tag111(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block232Bytes, _wl_block232);

						if (operation.equalsIgnoreCase( "insert" ))
							{
                                out.println( "<input type='text' name='long_name_dervn_logic_local' id='long_name_dervn_logic_local' value='" + name_dervn_logic_oth_lang_long + "' size='60' maxlength='100' onkeypress='return SplCharsChkForNameDrvn(event);' onBlur='checkNameDervnLogic(this);return SplCharsChkForNameDrvn(event)' ");

								if(language_direction.equals("R"))
								{
								out.println("dir='RTL'");
								}
												
								//out.println(" >" ) ;
								out.println(" disabled >" ) ;
							}

                            if (operation.equalsIgnoreCase( "modify" ) )
							{	
                                out.println( "<input type='text' name='long_name_dervn_logic_local' id='long_name_dervn_logic_local'  value='" + name_dervn_logic_oth_lang_long + "' size='60' maxlength='100' ") ;
								
								if(language_direction.equals("R"))
								{
								out.println("dir='RTL'");
								}
												
								//out.println("  >" ) ;
								out.println(" disabled >" ) ;
							}
                        
            _bw.write(_wl_block240Bytes, _wl_block240);
if(isNameDervnLogicNBAppl){
            _bw.write(_wl_block241Bytes, _wl_block241);

            if (_jsp__tag112(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block242Bytes, _wl_block242);

            if (_jsp__tag113(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block243Bytes, _wl_block243);

					String disable_dervn_logic_nb = "";
					
					if (name_dervn_logic_nb.equals(""))
					{
						disable_dervn_logic_nb = "";
					}else
					{
						disable_dervn_logic_nb = "disabled";
					}
					
					out.println( "<input type='text' name='name_dervn_logic_nb' id='name_dervn_logic_nb' value='" + name_dervn_logic_nb + "' size='30' maxlength='100' onkeypress='return SplCharsChkForNBNameDrvn(event);' onBlur='checkNBNameDervnLogic(this);' "+disable_dervn_logic_nb+">" ) ;
				
            _bw.write(_wl_block244Bytes, _wl_block244);

            if (_jsp__tag114(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block242Bytes, _wl_block242);

            if (_jsp__tag115(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block243Bytes, _wl_block243);

					String disable_dervn_logic_nb_sb = "";
					
					if (name_dervn_logic_nb_sb.equals(""))
					{
						disable_dervn_logic_nb_sb = "";
					}else
					{
						disable_dervn_logic_nb_sb = "disabled";
					}
					
					out.println( "<input type='text' name='name_dervn_logic_nb_sb' id='name_dervn_logic_nb_sb' value='" + name_dervn_logic_nb_sb + "' size='30' maxlength='100' onkeypress='return SplCharsChkForNBNameDrvn(event);' onBlur='checkNBNameDervnLogic(this);' "+disable_dervn_logic_nb_sb+">" ) ;
				
            _bw.write(_wl_block245Bytes, _wl_block245);
}
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(nb_use_mother_ser));
            _bw.write(_wl_block247Bytes, _wl_block247);
            {java.lang.String __page ="../../eMP/jsp/mp_param_form_include.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("module_instal_ind"), weblogic.utils.StringUtils.valueOf(module_instal_ind
                        )},{ weblogic.utils.StringUtils.valueOf("operation"), weblogic.utils.StringUtils.valueOf(operation
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id1_accept_alphanumeric_yn"), weblogic.utils.StringUtils.valueOf(alt_id1_accept_alphanumeric_yn
                        )},{ weblogic.utils.StringUtils.valueOf("Accept_oth_alt_id_yn"), weblogic.utils.StringUtils.valueOf(Accept_oth_alt_id_yn
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id1_type"), weblogic.utils.StringUtils.valueOf(alt_id1_type
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id2_type"), weblogic.utils.StringUtils.valueOf(alt_id2_type
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id3_type"), weblogic.utils.StringUtils.valueOf(alt_id3_type
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id4_type"), weblogic.utils.StringUtils.valueOf(alt_id4_type
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id1_chk_digit_scheme "), weblogic.utils.StringUtils.valueOf(alt_id1_chk_digit_scheme
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id2_chk_digit_scheme"), weblogic.utils.StringUtils.valueOf(alt_id2_chk_digit_scheme
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id3_chk_digit_scheme"), weblogic.utils.StringUtils.valueOf(alt_id3_chk_digit_scheme
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id4_chk_digit_scheme"), weblogic.utils.StringUtils.valueOf(alt_id4_chk_digit_scheme
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id1_length"), weblogic.utils.StringUtils.valueOf(alt_id1_length
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id2_length"), weblogic.utils.StringUtils.valueOf(alt_id2_length
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id3_length"), weblogic.utils.StringUtils.valueOf(alt_id3_length
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id4_length"), weblogic.utils.StringUtils.valueOf(alt_id4_length
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id1_len_validation_yn"), weblogic.utils.StringUtils.valueOf(alt_id1_len_validation_yn
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id2_len_validation_yn"), weblogic.utils.StringUtils.valueOf(alt_id2_len_validation_yn
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id3_len_validation_yn"), weblogic.utils.StringUtils.valueOf(alt_id3_len_validation_yn
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id4_len_validation_yn"), weblogic.utils.StringUtils.valueOf(alt_id4_len_validation_yn
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id1_reqd_yn"), weblogic.utils.StringUtils.valueOf(alt_id1_reqd_yn
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id2_reqd_yn"), weblogic.utils.StringUtils.valueOf(alt_id2_reqd_yn
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id3_reqd_yn"), weblogic.utils.StringUtils.valueOf(alt_id3_reqd_yn
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id4_reqd_yn"), weblogic.utils.StringUtils.valueOf(alt_id4_reqd_yn
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id1_unique_yn"), weblogic.utils.StringUtils.valueOf(alt_id1_unique_yn
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id2_unique_yn"), weblogic.utils.StringUtils.valueOf(alt_id2_unique_yn
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id3_unique_yn"), weblogic.utils.StringUtils.valueOf(alt_id3_unique_yn
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id4_unique_yn"), weblogic.utils.StringUtils.valueOf(alt_id4_unique_yn
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id1_exp_date_accept_yn"), weblogic.utils.StringUtils.valueOf(alt_id1_exp_date_accept_yn
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id2_exp_date_accept_yn"), weblogic.utils.StringUtils.valueOf(alt_id2_exp_date_accept_yn
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id3_exp_date_accept_yn"), weblogic.utils.StringUtils.valueOf(alt_id3_exp_date_accept_yn
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id4_exp_date_accept_yn"), weblogic.utils.StringUtils.valueOf(alt_id4_exp_date_accept_yn
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id1_exp_warn_yn"), weblogic.utils.StringUtils.valueOf(alt_id1_exp_warn_yn
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id2_exp_warn_yn"), weblogic.utils.StringUtils.valueOf(alt_id2_exp_warn_yn
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id3_exp_warn_yn"), weblogic.utils.StringUtils.valueOf(alt_id3_exp_warn_yn
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id4_exp_warn_yn"), weblogic.utils.StringUtils.valueOf(alt_id4_exp_warn_yn
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id1_invoke_routine"), weblogic.utils.StringUtils.valueOf(alt_id1_invoke_routine
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id2_invoke_routine"), weblogic.utils.StringUtils.valueOf(alt_id2_invoke_routine
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id3_invoke_routine"), weblogic.utils.StringUtils.valueOf(alt_id3_invoke_routine
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id4_invoke_routine"), weblogic.utils.StringUtils.valueOf(alt_id4_invoke_routine
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id1_routine_name"), weblogic.utils.StringUtils.valueOf(alt_id1_routine_name
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id2_routine_name"), weblogic.utils.StringUtils.valueOf(alt_id2_routine_name
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id3_routine_name"), weblogic.utils.StringUtils.valueOf(alt_id3_routine_name
                        )},{ weblogic.utils.StringUtils.valueOf("allow_nb_regn_within_days"), weblogic.utils.StringUtils.valueOf(allow_nb_regn_within_days
                        )},{ weblogic.utils.StringUtils.valueOf("allow_nb_regn_unit"), weblogic.utils.StringUtils.valueOf(allow_nb_regn_unit
                        )},{ weblogic.utils.StringUtils.valueOf("mul_birth_regn_within_hours"), weblogic.utils.StringUtils.valueOf(mul_birth_regn_within_hours
                        )},{ weblogic.utils.StringUtils.valueOf("nb_use_mother_ser"), weblogic.utils.StringUtils.valueOf(nb_use_mother_ser
                        )},{ weblogic.utils.StringUtils.valueOf("review_nb_links_bef_reg_yn"), weblogic.utils.StringUtils.valueOf(review_nb_links_bef_reg_yn
                        )},{ weblogic.utils.StringUtils.valueOf("length_of_baby_yn"), weblogic.utils.StringUtils.valueOf(length_of_baby_yn
                        )},{ weblogic.utils.StringUtils.valueOf("head_circumference_of_baby_yn"), weblogic.utils.StringUtils.valueOf(head_circumference_of_baby_yn
                        )},{ weblogic.utils.StringUtils.valueOf("single_stage_nb_reg_appl_yn"), weblogic.utils.StringUtils.valueOf(single_stage_nb_reg_appl_yn
                        )},{ weblogic.utils.StringUtils.valueOf("mod_birth_reg_appl_yn"), weblogic.utils.StringUtils.valueOf(mod_birth_reg_appl_yn
                        )},{ weblogic.utils.StringUtils.valueOf("min_age_of_moth"), weblogic.utils.StringUtils.valueOf(min_age_of_moth
                        )},{ weblogic.utils.StringUtils.valueOf("max_age_of_moth"), weblogic.utils.StringUtils.valueOf(max_age_of_moth
                        )},{ weblogic.utils.StringUtils.valueOf("cut_age_of_moth"), weblogic.utils.StringUtils.valueOf(cut_age_of_moth
                        )},{ weblogic.utils.StringUtils.valueOf("min_age_of_fath"), weblogic.utils.StringUtils.valueOf(min_age_of_fath
                        )},{ weblogic.utils.StringUtils.valueOf("min_weight"), weblogic.utils.StringUtils.valueOf(min_weight
                        )},{ weblogic.utils.StringUtils.valueOf("max_weight"), weblogic.utils.StringUtils.valueOf(max_weight
                        )},{ weblogic.utils.StringUtils.valueOf("unit_of_wt_nb"), weblogic.utils.StringUtils.valueOf(unit_of_wt_nb
                        )},{ weblogic.utils.StringUtils.valueOf("min_length"), weblogic.utils.StringUtils.valueOf(min_length
                        )},{ weblogic.utils.StringUtils.valueOf("max_length"), weblogic.utils.StringUtils.valueOf(max_length
                        )},{ weblogic.utils.StringUtils.valueOf("unit_of_circum_nb"), weblogic.utils.StringUtils.valueOf(unit_of_circum_nb
                        )},{ weblogic.utils.StringUtils.valueOf("min_head_circum"), weblogic.utils.StringUtils.valueOf(min_head_circum
                        )},{ weblogic.utils.StringUtils.valueOf("max_head_circum"), weblogic.utils.StringUtils.valueOf(max_head_circum
                        )},{ weblogic.utils.StringUtils.valueOf("unit_of_length_nb"), weblogic.utils.StringUtils.valueOf(unit_of_length_nb
                        )},{ weblogic.utils.StringUtils.valueOf("min_chest_circum"), weblogic.utils.StringUtils.valueOf(min_chest_circum
                        )},{ weblogic.utils.StringUtils.valueOf("max_chest_circum"), weblogic.utils.StringUtils.valueOf(max_chest_circum
                        )},{ weblogic.utils.StringUtils.valueOf("unit_of_chest_circum_nb"), weblogic.utils.StringUtils.valueOf(unit_of_chest_circum_nb
                        )},{ weblogic.utils.StringUtils.valueOf("min_gestation"), weblogic.utils.StringUtils.valueOf(min_gestation
                        )},{ weblogic.utils.StringUtils.valueOf("max_gestation"), weblogic.utils.StringUtils.valueOf(max_gestation
                        )},{ weblogic.utils.StringUtils.valueOf("unit_of_gest_nb"), weblogic.utils.StringUtils.valueOf(unit_of_gest_nb
                        )},{ weblogic.utils.StringUtils.valueOf("sub_multi_birth_hw"), weblogic.utils.StringUtils.valueOf(sub_multi_birth_hw
                        )},{ weblogic.utils.StringUtils.valueOf("gestation_two_del"), weblogic.utils.StringUtils.valueOf(gestation_two_del
                        )},{ weblogic.utils.StringUtils.valueOf("name_prefix_male_nb"), weblogic.utils.StringUtils.valueOf(name_prefix_male_nb
                        )},{ weblogic.utils.StringUtils.valueOf("display_new_born_age"), weblogic.utils.StringUtils.valueOf(display_new_born_age
                        )},{ weblogic.utils.StringUtils.valueOf("name_prefix_female_nb"), weblogic.utils.StringUtils.valueOf(name_prefix_female_nb
                        )},{ weblogic.utils.StringUtils.valueOf("name_prefix_unknown_nb"), weblogic.utils.StringUtils.valueOf(name_prefix_unknown_nb
                        )},{ weblogic.utils.StringUtils.valueOf("name_suffix_male_nb"), weblogic.utils.StringUtils.valueOf(name_suffix_male_nb
                        )},{ weblogic.utils.StringUtils.valueOf("name_suffix_female_nb"), weblogic.utils.StringUtils.valueOf(name_suffix_female_nb
                        )},{ weblogic.utils.StringUtils.valueOf("age_not_consider_natid"), weblogic.utils.StringUtils.valueOf(age_not_consider_natid
                        )},{ weblogic.utils.StringUtils.valueOf("nb_father_name_mandatory_yn"), weblogic.utils.StringUtils.valueOf(nb_father_name_mandatory_yn
                        )},{ weblogic.utils.StringUtils.valueOf("data_upd_allowed_aft_final_yn"), weblogic.utils.StringUtils.valueOf(data_upd_allowed_aft_final_yn
                        )},{ weblogic.utils.StringUtils.valueOf("nb_mother_dtls_update_yn"), weblogic.utils.StringUtils.valueOf(nb_mother_dtls_update_yn
                        )},{ weblogic.utils.StringUtils.valueOf("accept_names_for_live_birth_yn"), weblogic.utils.StringUtils.valueOf(accept_names_for_live_birth_yn
                        )},{ weblogic.utils.StringUtils.valueOf("dflt_race_nat_setup_nb_as_per"), weblogic.utils.StringUtils.valueOf(dflt_race_nat_setup_nb_as_per
                        )},{ weblogic.utils.StringUtils.valueOf("dft_rel_male_nb"), weblogic.utils.StringUtils.valueOf(dft_rel_male_nb
                        )},{ weblogic.utils.StringUtils.valueOf("dft_rel_female_nb"), weblogic.utils.StringUtils.valueOf(dft_rel_female_nb
                        )},{ weblogic.utils.StringUtils.valueOf("dft_rel_unknown_nb"), weblogic.utils.StringUtils.valueOf(dft_rel_unknown_nb
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id1_adv_alert_reqd_yn"), weblogic.utils.StringUtils.valueOf(alt_id1_adv_alert_reqd_yn
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id2_adv_alert_reqd_yn"), weblogic.utils.StringUtils.valueOf(alt_id2_adv_alert_reqd_yn
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id3_adv_alert_reqd_yn"), weblogic.utils.StringUtils.valueOf(alt_id3_adv_alert_reqd_yn
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id4_adv_alert_reqd_yn"), weblogic.utils.StringUtils.valueOf(alt_id4_adv_alert_reqd_yn
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id1_adv_alert_days"), weblogic.utils.StringUtils.valueOf(alt_id1_adv_alert_days
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id2_adv_alert_days"), weblogic.utils.StringUtils.valueOf(alt_id2_adv_alert_days
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id3_adv_alert_days"), weblogic.utils.StringUtils.valueOf(alt_id3_adv_alert_days
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id4_adv_alert_days"), weblogic.utils.StringUtils.valueOf(alt_id4_adv_alert_days
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id1_exp_grace_days"), weblogic.utils.StringUtils.valueOf(alt_id1_exp_grace_days
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id2_exp_grace_days"), weblogic.utils.StringUtils.valueOf(alt_id2_exp_grace_days
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id3_exp_grace_days"), weblogic.utils.StringUtils.valueOf(alt_id3_exp_grace_days
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id4_exp_grace_days"), weblogic.utils.StringUtils.valueOf(alt_id4_exp_grace_days
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id4_routine_name"), weblogic.utils.StringUtils.valueOf(alt_id4_routine_name
                        )},{ weblogic.utils.StringUtils.valueOf("addl_field1_prompt"), weblogic.utils.StringUtils.valueOf(addl_field1_prompt
                        )},{ weblogic.utils.StringUtils.valueOf("addl_field2_prompt"), weblogic.utils.StringUtils.valueOf(addl_field2_prompt
                        )},{ weblogic.utils.StringUtils.valueOf("addl_field3_prompt"), weblogic.utils.StringUtils.valueOf(addl_field3_prompt
                        )},{ weblogic.utils.StringUtils.valueOf("addl_field4_prompt"), weblogic.utils.StringUtils.valueOf(addl_field4_prompt
                        )},{ weblogic.utils.StringUtils.valueOf("addl_field5_prompt"), weblogic.utils.StringUtils.valueOf(addl_field5_prompt
                        )},{ weblogic.utils.StringUtils.valueOf("addl_field1_length"), weblogic.utils.StringUtils.valueOf(addl_field1_length
                        )},{ weblogic.utils.StringUtils.valueOf("addl_field2_length"), weblogic.utils.StringUtils.valueOf(addl_field2_length
                        )},{ weblogic.utils.StringUtils.valueOf("addl_field3_length"), weblogic.utils.StringUtils.valueOf(addl_field3_length
                        )},{ weblogic.utils.StringUtils.valueOf("addl_field4_length"), weblogic.utils.StringUtils.valueOf(addl_field4_length
                        )},{ weblogic.utils.StringUtils.valueOf("addl_field5_length"), weblogic.utils.StringUtils.valueOf(addl_field5_length
                        )},{ weblogic.utils.StringUtils.valueOf("sec11"), weblogic.utils.StringUtils.valueOf(sec11
                        )},{ weblogic.utils.StringUtils.valueOf("sec12"), weblogic.utils.StringUtils.valueOf(sec12
                        )},{ weblogic.utils.StringUtils.valueOf("sec13"), weblogic.utils.StringUtils.valueOf(sec13
                        )},{ weblogic.utils.StringUtils.valueOf("sec21"), weblogic.utils.StringUtils.valueOf(sec21
                        )},{ weblogic.utils.StringUtils.valueOf("sec22"), weblogic.utils.StringUtils.valueOf(sec22
                        )},{ weblogic.utils.StringUtils.valueOf("sec23"), weblogic.utils.StringUtils.valueOf(sec23
                        )},{ weblogic.utils.StringUtils.valueOf("sec31"), weblogic.utils.StringUtils.valueOf(sec31
                        )},{ weblogic.utils.StringUtils.valueOf("sec32"), weblogic.utils.StringUtils.valueOf(sec32
                        )},{ weblogic.utils.StringUtils.valueOf("sec33"), weblogic.utils.StringUtils.valueOf(sec33
                        )},{ weblogic.utils.StringUtils.valueOf("sec41"), weblogic.utils.StringUtils.valueOf(sec41
                        )},{ weblogic.utils.StringUtils.valueOf("sec42"), weblogic.utils.StringUtils.valueOf(sec42
                        )},{ weblogic.utils.StringUtils.valueOf("sec43"), weblogic.utils.StringUtils.valueOf(sec43
                        )},{ weblogic.utils.StringUtils.valueOf("sec51"), weblogic.utils.StringUtils.valueOf(sec51
                        )},{ weblogic.utils.StringUtils.valueOf("sec52"), weblogic.utils.StringUtils.valueOf(sec52
                        )},{ weblogic.utils.StringUtils.valueOf("sec53"), weblogic.utils.StringUtils.valueOf(sec53
                        )},{ weblogic.utils.StringUtils.valueOf("chkAcceptNat"), weblogic.utils.StringUtils.valueOf(chkAcceptNat
                        )},{ weblogic.utils.StringUtils.valueOf("chkdisAcceptothpatser"), weblogic.utils.StringUtils.valueOf(chkdisAcceptothpatser
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id1_accept_oth_pat_ser_yn"), weblogic.utils.StringUtils.valueOf(alt_id1_accept_oth_pat_ser_yn
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id1_chng_allowed_yn"), weblogic.utils.StringUtils.valueOf(alt_id1_chng_allowed_yn
                        )},{ weblogic.utils.StringUtils.valueOf("dflt_relgn_code"), weblogic.utils.StringUtils.valueOf(dflt_relgn_code
                        )},{ weblogic.utils.StringUtils.valueOf("citizen_nationality_code"), weblogic.utils.StringUtils.valueOf(citizen_nationality_code
                        )},{ weblogic.utils.StringUtils.valueOf("default_race_code"), weblogic.utils.StringUtils.valueOf(default_race_code
                        )},{ weblogic.utils.StringUtils.valueOf("default_relationship_code"), weblogic.utils.StringUtils.valueOf(default_relationship_code
                        )},{ weblogic.utils.StringUtils.valueOf("max_patient_age"), weblogic.utils.StringUtils.valueOf(max_patient_age
                        )},{ weblogic.utils.StringUtils.valueOf("dflt_alt_id1_in_emp_id_yn"), weblogic.utils.StringUtils.valueOf(dflt_alt_id1_in_emp_id_yn
                        )},{ weblogic.utils.StringUtils.valueOf("entitlement_by_pat_cat_yn"), weblogic.utils.StringUtils.valueOf(entitlement_by_pat_cat_yn
                        )},{ weblogic.utils.StringUtils.valueOf("suspend_service_yn"), weblogic.utils.StringUtils.valueOf(suspend_service_yn
                        )},{ weblogic.utils.StringUtils.valueOf("acpt_appt_rfrl_in_reg_pat_yn"), weblogic.utils.StringUtils.valueOf(acpt_appt_rfrl_in_reg_pat_yn
                        )},{ weblogic.utils.StringUtils.valueOf("accept_pw_in_chng_pat_dtl_yn"), weblogic.utils.StringUtils.valueOf(accept_pw_in_chng_pat_dtl_yn
                        )},{ weblogic.utils.StringUtils.valueOf("dflt_language_id"), weblogic.utils.StringUtils.valueOf(dflt_language_id
                        )},{ weblogic.utils.StringUtils.valueOf("inv_pat_search_in_reg_pat_yn"), weblogic.utils.StringUtils.valueOf(inv_pat_search_in_reg_pat_yn
                        )},{ weblogic.utils.StringUtils.valueOf("race_required_yn"), weblogic.utils.StringUtils.valueOf(race_required_yn
                        )},{ weblogic.utils.StringUtils.valueOf("round_dob_estd_age"), weblogic.utils.StringUtils.valueOf(round_dob_estd_age
                        )},{ weblogic.utils.StringUtils.valueOf("gen_slno_unknown_pat_yn"), weblogic.utils.StringUtils.valueOf(gen_slno_unknown_pat_yn
                        )},{ weblogic.utils.StringUtils.valueOf("gen_pid_using_aid1_rule_yn"), weblogic.utils.StringUtils.valueOf(gen_pid_using_aid1_rule_yn
                        )},{ weblogic.utils.StringUtils.valueOf("patient_id_length"), weblogic.utils.StringUtils.valueOf(patient_id_length
                        )},{ weblogic.utils.StringUtils.valueOf("still_born_prefix"), weblogic.utils.StringUtils.valueOf(still_born_prefix
                        )},{ weblogic.utils.StringUtils.valueOf("pat_photo_renewal_alert_days"), weblogic.utils.StringUtils.valueOf(pat_photo_renewal_alert_days
                        )},{ weblogic.utils.StringUtils.valueOf("mortuary_release_yn"), weblogic.utils.StringUtils.valueOf(mortuary_release_yn
                        )},{ weblogic.utils.StringUtils.valueOf("no_days_before_deceased"), weblogic.utils.StringUtils.valueOf(no_days_before_deceased
                        )},{ weblogic.utils.StringUtils.valueOf("cancel_reason_code"), weblogic.utils.StringUtils.valueOf(cancel_reason_code
                        )},{ weblogic.utils.StringUtils.valueOf("pat_search_tab"), weblogic.utils.StringUtils.valueOf(pat_search_tab
                        )},{ weblogic.utils.StringUtils.valueOf("country_reqd_yn"), weblogic.utils.StringUtils.valueOf(country_reqd_yn
                        )},{ weblogic.utils.StringUtils.valueOf("region_reqd_yn"), weblogic.utils.StringUtils.valueOf(region_reqd_yn
                        )},{ weblogic.utils.StringUtils.valueOf("mobile_no_reqd_yn"), weblogic.utils.StringUtils.valueOf(mobile_no_reqd_yn
                        )},{ weblogic.utils.StringUtils.valueOf("email_id_reqd_yn"), weblogic.utils.StringUtils.valueOf(email_id_reqd_yn
                        )},{ weblogic.utils.StringUtils.valueOf("postal_cd_reqd_yn"), weblogic.utils.StringUtils.valueOf(postal_cd_reqd_yn
                        )},{ weblogic.utils.StringUtils.valueOf("area_reqd_yn"), weblogic.utils.StringUtils.valueOf(area_reqd_yn
                        )},{ weblogic.utils.StringUtils.valueOf("religion_reqd_yn"), weblogic.utils.StringUtils.valueOf(religion_reqd_yn
                        )},{ weblogic.utils.StringUtils.valueOf("pat_ser_access_by_user_yn"), weblogic.utils.StringUtils.valueOf(pat_ser_access_by_user_yn
                        )},{ weblogic.utils.StringUtils.valueOf("upt_contact_dtls_oa_yn"), weblogic.utils.StringUtils.valueOf(upt_contact_dtls_oa_yn
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id2_accept_oth_pat_ser_yn"), weblogic.utils.StringUtils.valueOf(alt_id2_accept_oth_pat_ser_yn
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id2_chng_allowed_yn"), weblogic.utils.StringUtils.valueOf(alt_id2_chng_allowed_yn
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id2_accept_alphanumeric_yn"), weblogic.utils.StringUtils.valueOf(alt_id2_accept_alphanumeric_yn
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id3_accept_oth_pat_ser_yn"), weblogic.utils.StringUtils.valueOf(alt_id3_accept_oth_pat_ser_yn
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id3_chng_allowed_yn"), weblogic.utils.StringUtils.valueOf(alt_id3_chng_allowed_yn
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id3_accept_alphanumeric_yn"), weblogic.utils.StringUtils.valueOf(alt_id3_accept_alphanumeric_yn
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id4_accept_oth_pat_ser_yn"), weblogic.utils.StringUtils.valueOf(alt_id4_accept_oth_pat_ser_yn
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id4_chng_allowed_yn"), weblogic.utils.StringUtils.valueOf(alt_id4_chng_allowed_yn
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id4_accept_alphanumeric_yn"), weblogic.utils.StringUtils.valueOf(alt_id4_accept_alphanumeric_yn
                        )},{ weblogic.utils.StringUtils.valueOf("upd_pat_dtls_referral_yn"), weblogic.utils.StringUtils.valueOf(upd_pat_dtls_referral_yn
                        )},{ weblogic.utils.StringUtils.valueOf("disp_cancelled_previous_enc_yn"), weblogic.utils.StringUtils.valueOf(disp_cancelled_previous_enc_yn
                        )},{ weblogic.utils.StringUtils.valueOf("unmask_aadhaar_num_yn"), weblogic.utils.StringUtils.valueOf(unmask_aadhaar_num_yn
                        )},{ weblogic.utils.StringUtils.valueOf("unmask_abha_num_addr_yn"), weblogic.utils.StringUtils.valueOf(unmask_abha_num_addr_yn
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id1_alphanum_validate_yn"), weblogic.utils.StringUtils.valueOf(alt_id1_alphanum_validate_yn
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id2_alphanum_validate_yn"), weblogic.utils.StringUtils.valueOf(alt_id2_alphanum_validate_yn
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id3_alphanum_validate_yn"), weblogic.utils.StringUtils.valueOf(alt_id3_alphanum_validate_yn
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id4_alphanum_validate_yn"), weblogic.utils.StringUtils.valueOf(alt_id4_alphanum_validate_yn
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id1_start_with"), weblogic.utils.StringUtils.valueOf(alt_id1_start_with
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id2_start_with"), weblogic.utils.StringUtils.valueOf(alt_id2_start_with
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id3_start_with"), weblogic.utils.StringUtils.valueOf(alt_id3_start_with
                        )},{ weblogic.utils.StringUtils.valueOf("alt_id4_start_with"), weblogic.utils.StringUtils.valueOf(alt_id4_start_with
                        )},{ weblogic.utils.StringUtils.valueOf("ALT_ID1_PAT_SCH_EXACT_YN"), weblogic.utils.StringUtils.valueOf(ALT_ID1_PAT_SCH_EXACT_YN
                        )},{ weblogic.utils.StringUtils.valueOf("ALT_ID2_PAT_SCH_EXACT_YN"), weblogic.utils.StringUtils.valueOf(ALT_ID2_PAT_SCH_EXACT_YN
                        )},{ weblogic.utils.StringUtils.valueOf("ALT_ID3_PAT_SCH_EXACT_YN"), weblogic.utils.StringUtils.valueOf(ALT_ID3_PAT_SCH_EXACT_YN
                        )},{ weblogic.utils.StringUtils.valueOf("ALT_ID4_PAT_SCH_EXACT_YN"), weblogic.utils.StringUtils.valueOf(ALT_ID4_PAT_SCH_EXACT_YN
                        )},{ weblogic.utils.StringUtils.valueOf("aadhar_config_enabled_yn"), weblogic.utils.StringUtils.valueOf(aadhaar_config_enabled_yn
                        )},{ weblogic.utils.StringUtils.valueOf("aadhar_option_value"), weblogic.utils.StringUtils.valueOf(aadhaar_option_value
                        )},{ weblogic.utils.StringUtils.valueOf("isUHID_valid_appl"), weblogic.utils.StringUtils.valueOf(isUHID_valid_appl
                        )},{ weblogic.utils.StringUtils.valueOf("no_days_UHID_valid"), weblogic.utils.StringUtils.valueOf(no_days_UHID_valid
                        )},{ weblogic.utils.StringUtils.valueOf("age_not_consider_natid_altid"), weblogic.utils.StringUtils.valueOf(age_not_consider_natid_altid
                        )},{ weblogic.utils.StringUtils.valueOf("patientcategory_reqd_yn"), weblogic.utils.StringUtils.valueOf(patientcategory_reqd_yn
                        )},{ weblogic.utils.StringUtils.valueOf("town_reqd_yn"), weblogic.utils.StringUtils.valueOf(town_reqd_yn
                        )},{ weblogic.utils.StringUtils.valueOf("death_reg_form_req_yn"), weblogic.utils.StringUtils.valueOf(death_reg_form_req_yn
                        )},{ weblogic.utils.StringUtils.valueOf("allow_ext_nb_regn_within_days"), weblogic.utils.StringUtils.valueOf(allow_ext_nb_regn_within_days
                        )},{ weblogic.utils.StringUtils.valueOf("mandate_first_newborn_yn"), weblogic.utils.StringUtils.valueOf(mandate_first_newborn_yn
                        )},{ weblogic.utils.StringUtils.valueOf("mandate_first_newborn_ip_yn"), weblogic.utils.StringUtils.valueOf(mandate_first_newborn_ip_yn
                        )},{ weblogic.utils.StringUtils.valueOf("mandate_first_newborn_ae_yn"), weblogic.utils.StringUtils.valueOf(mandate_first_newborn_ae_yn
                        )},{ weblogic.utils.StringUtils.valueOf("mandate_second_newborn_yn"), weblogic.utils.StringUtils.valueOf(mandate_second_newborn_yn
                        )},{ weblogic.utils.StringUtils.valueOf("mandate_second_newborn_ip_yn"), weblogic.utils.StringUtils.valueOf(mandate_second_newborn_ip_yn
                        )},{ weblogic.utils.StringUtils.valueOf("mandate_second_newborn_ae_yn"), weblogic.utils.StringUtils.valueOf(mandate_second_newborn_ae_yn
                        )},{ weblogic.utils.StringUtils.valueOf("mandate_third_newborn_yn"), weblogic.utils.StringUtils.valueOf(mandate_third_newborn_yn
                        )},{ weblogic.utils.StringUtils.valueOf("mandate_third_newborn_ip_yn"), weblogic.utils.StringUtils.valueOf(mandate_third_newborn_ip_yn
                        )},{ weblogic.utils.StringUtils.valueOf("mandate_third_newborn_ae_yn"), weblogic.utils.StringUtils.valueOf(mandate_third_newborn_ae_yn
                        )},{ weblogic.utils.StringUtils.valueOf("mand_antenatal_newborn_yn"), weblogic.utils.StringUtils.valueOf(mand_antenatal_newborn_yn
                        )},{ weblogic.utils.StringUtils.valueOf("mand_antenatal_newborn_ip_yn"), weblogic.utils.StringUtils.valueOf(mand_antenatal_newborn_ip_yn
                        )},{ weblogic.utils.StringUtils.valueOf("mand_antenatal_newborn_ae_yn"), weblogic.utils.StringUtils.valueOf(mand_antenatal_newborn_ae_yn
                        )},{ weblogic.utils.StringUtils.valueOf("mand_parity_newborn_yn"), weblogic.utils.StringUtils.valueOf(mand_parity_newborn_yn
                        )},{ weblogic.utils.StringUtils.valueOf("mand_parity_newborn_ip_yn"), weblogic.utils.StringUtils.valueOf(mand_parity_newborn_ip_yn
                        )},{ weblogic.utils.StringUtils.valueOf("mand_parity_newborn_ae_yn"), weblogic.utils.StringUtils.valueOf(mand_parity_newborn_ae_yn
                        )},{ weblogic.utils.StringUtils.valueOf("invoke_menstrual_history_yn"), weblogic.utils.StringUtils.valueOf(invoke_menstrual_history_yn
                        )},{ weblogic.utils.StringUtils.valueOf("first_name_accept_yn"), weblogic.utils.StringUtils.valueOf(first_name_accept_yn
                        )},{ weblogic.utils.StringUtils.valueOf("first_name_reqd_yn"), weblogic.utils.StringUtils.valueOf(first_name_reqd_yn
                        )},{ weblogic.utils.StringUtils.valueOf("first_name_order"), weblogic.utils.StringUtils.valueOf(first_name_order
                        )},{ weblogic.utils.StringUtils.valueOf("first_name_prompt"), weblogic.utils.StringUtils.valueOf(first_name_prompt
                        )},{ weblogic.utils.StringUtils.valueOf("second_name_accept_yn"), weblogic.utils.StringUtils.valueOf(second_name_accept_yn
                        )},{ weblogic.utils.StringUtils.valueOf("second_name_reqd_yn"), weblogic.utils.StringUtils.valueOf(second_name_reqd_yn
                        )},{ weblogic.utils.StringUtils.valueOf("second_name_order"), weblogic.utils.StringUtils.valueOf(second_name_order
                        )},{ weblogic.utils.StringUtils.valueOf("second_name_prompt"), weblogic.utils.StringUtils.valueOf(second_name_prompt
                        )},{ weblogic.utils.StringUtils.valueOf("third_name_accept_yn"), weblogic.utils.StringUtils.valueOf(third_name_accept_yn
                        )},{ weblogic.utils.StringUtils.valueOf("third_name_reqd_yn"), weblogic.utils.StringUtils.valueOf(third_name_reqd_yn
                        )},{ weblogic.utils.StringUtils.valueOf("third_name_order"), weblogic.utils.StringUtils.valueOf(third_name_order
                        )},{ weblogic.utils.StringUtils.valueOf("third_name_prompt"), weblogic.utils.StringUtils.valueOf(third_name_prompt
                        )},{ weblogic.utils.StringUtils.valueOf("family_name_accept_yn"), weblogic.utils.StringUtils.valueOf(family_name_accept_yn
                        )},{ weblogic.utils.StringUtils.valueOf("family_name_reqd_yn"), weblogic.utils.StringUtils.valueOf(family_name_reqd_yn
                        )},{ weblogic.utils.StringUtils.valueOf("family_name_order"), weblogic.utils.StringUtils.valueOf(family_name_order
                        )},{ weblogic.utils.StringUtils.valueOf("family_name_prompt"), weblogic.utils.StringUtils.valueOf(family_name_prompt
                        )},{ weblogic.utils.StringUtils.valueOf("enable_marital_status"), weblogic.utils.StringUtils.valueOf(enable_marital_status
                        )},{ weblogic.utils.StringUtils.valueOf("dflt_father_first_name_prompt"), weblogic.utils.StringUtils.valueOf(dflt_father_first_name_prompt
                        )},{ weblogic.utils.StringUtils.valueOf("dflt_father_Second_name_prompt"), weblogic.utils.StringUtils.valueOf(dflt_father_Second_name_prompt
                        )},{ weblogic.utils.StringUtils.valueOf("dflt_father_third_name_prompt"), weblogic.utils.StringUtils.valueOf(dflt_father_third_name_prompt
                        )},{ weblogic.utils.StringUtils.valueOf("dflt_father_family_name_prompt"), weblogic.utils.StringUtils.valueOf(dflt_father_family_name_prompt
                        )},{ weblogic.utils.StringUtils.valueOf("occupation_reqd_yn"), weblogic.utils.StringUtils.valueOf(occupation_reqd_yn
                        )},{ weblogic.utils.StringUtils.valueOf("marital_status_reqd_yn"), weblogic.utils.StringUtils.valueOf(marital_status_reqd_yn
                        )},{ weblogic.utils.StringUtils.valueOf("abha_eng_audio_path"), weblogic.utils.StringUtils.valueOf(abha_eng_audio_path
                        )},{ weblogic.utils.StringUtils.valueOf("abha_hin_audio_path"), weblogic.utils.StringUtils.valueOf(abha_hin_audio_path
                        )},{ weblogic.utils.StringUtils.valueOf("mand_visit_admssn_reg_yn"), weblogic.utils.StringUtils.valueOf(mand_visit_admssn_reg_yn
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block265Bytes, _wl_block265);
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf( ethnic_sndx_type         ));
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf( nat_id_count));
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf( alt_id_count ));
            _bw.write(_wl_block269Bytes, _wl_block269);
            out.print( String.valueOf( dflt_contact_mode1       ));
            _bw.write(_wl_block270Bytes, _wl_block270);
            out.print( String.valueOf( dflt_contact_mode2       ));
            _bw.write(_wl_block271Bytes, _wl_block271);
            out.print( String.valueOf( dflt_contact_mode3       ));
            _bw.write(_wl_block272Bytes, _wl_block272);
            out.print( String.valueOf( dflt_contact_mode4       ));
            _bw.write(_wl_block273Bytes, _wl_block273);
            out.print( String.valueOf( dflt_contact_mode5       ));
            _bw.write(_wl_block274Bytes, _wl_block274);
            out.print( String.valueOf( name_in_oth_lang_yn));
            _bw.write(_wl_block275Bytes, _wl_block275);
            out.print( String.valueOf(isNameDervnLogicNBAppl));
            _bw.write(_wl_block276Bytes, _wl_block276);
            out.print( String.valueOf( hr_interface_yn      ));
            _bw.write(_wl_block277Bytes, _wl_block277);
            out.print( String.valueOf( his_interface_yn     ));
            _bw.write(_wl_block278Bytes, _wl_block278);
            out.print( String.valueOf( age_limit_for_service    ));
            _bw.write(_wl_block279Bytes, _wl_block279);
            out.print( String.valueOf( hr_check_digit_scheme    ));
            _bw.write(_wl_block280Bytes, _wl_block280);
            out.print( String.valueOf( operation ));
            _bw.write(_wl_block281Bytes, _wl_block281);
            out.print( String.valueOf( module_instal_ind  ));
            _bw.write(_wl_block282Bytes, _wl_block282);

    if ( operation.equalsIgnoreCase( "modify" ) ) {

            _bw.write(_wl_block283Bytes, _wl_block283);
            out.print( String.valueOf( single_or_multi_files_ind ));
            _bw.write(_wl_block284Bytes, _wl_block284);
            out.print( String.valueOf( separate_file_no_yn  ));
            _bw.write(_wl_block285Bytes, _wl_block285);
            out.print( String.valueOf( name_prefix_accept_yn    ));
            _bw.write(_wl_block286Bytes, _wl_block286);
            out.print( String.valueOf( name_prefix_reqd_yn  ));
            _bw.write(_wl_block286Bytes, _wl_block286);
            out.print( String.valueOf( name_prefix_reqd_yn  ));
            _bw.write(_wl_block287Bytes, _wl_block287);
            out.print( String.valueOf( first_name_accept_yn     ));
            _bw.write(_wl_block288Bytes, _wl_block288);
            out.print( String.valueOf( first_name_reqd_yn   ));
            _bw.write(_wl_block289Bytes, _wl_block289);
            out.print( String.valueOf( second_name_accept_yn    ));
            _bw.write(_wl_block290Bytes, _wl_block290);
            out.print( String.valueOf( second_name_reqd_yn  ));
            _bw.write(_wl_block291Bytes, _wl_block291);
            out.print( String.valueOf( second_name_order        ));
            _bw.write(_wl_block292Bytes, _wl_block292);
            out.print( String.valueOf( third_name_accept_yn     ));
            _bw.write(_wl_block293Bytes, _wl_block293);
            out.print( String.valueOf( third_name_reqd_yn   ));
            _bw.write(_wl_block294Bytes, _wl_block294);
            out.print( String.valueOf( third_name_order     ));
            _bw.write(_wl_block295Bytes, _wl_block295);
            out.print( String.valueOf( family_name_accept_yn    ));
            _bw.write(_wl_block296Bytes, _wl_block296);
            out.print( String.valueOf( family_name_reqd_yn  ));
            _bw.write(_wl_block297Bytes, _wl_block297);
            out.print( String.valueOf( family_name_order        ));
            _bw.write(_wl_block298Bytes, _wl_block298);
            out.print( String.valueOf( name_suffix_accept_yn    ));
            _bw.write(_wl_block299Bytes, _wl_block299);
            out.print( String.valueOf( name_suffix_reqd_yn  ));
            _bw.write(_wl_block300Bytes, _wl_block300);
            out.print( String.valueOf( alt_id1_type         ));
            _bw.write(_wl_block301Bytes, _wl_block301);
            out.print( String.valueOf( alt_id1_length       ));
            _bw.write(_wl_block302Bytes, _wl_block302);
            out.print( String.valueOf( alt_id1_len_validation_yn ));
            _bw.write(_wl_block303Bytes, _wl_block303);
            out.print( String.valueOf( alt_id1_reqd_yn      ));
            _bw.write(_wl_block304Bytes, _wl_block304);
            out.print( String.valueOf( alt_id1_exp_date_accept_yn ));
            _bw.write(_wl_block305Bytes, _wl_block305);
            out.print( String.valueOf( alt_id1_unique_yn        ));
            _bw.write(_wl_block306Bytes, _wl_block306);
            out.print( String.valueOf( alt_id1_exp_warn_yn  ));
            _bw.write(_wl_block307Bytes, _wl_block307);
            out.print( String.valueOf( alt_id2_type         ));
            _bw.write(_wl_block308Bytes, _wl_block308);
            out.print( String.valueOf( alt_id2_length       ));
            _bw.write(_wl_block309Bytes, _wl_block309);
            out.print( String.valueOf( alt_id2_len_validation_yn ));
            _bw.write(_wl_block310Bytes, _wl_block310);
            out.print( String.valueOf( alt_id2_reqd_yn      ));
            _bw.write(_wl_block311Bytes, _wl_block311);
            out.print( String.valueOf( alt_id2_exp_date_accept_yn ));
            _bw.write(_wl_block312Bytes, _wl_block312);
            out.print( String.valueOf( alt_id2_unique_yn        ));
            _bw.write(_wl_block313Bytes, _wl_block313);
            out.print( String.valueOf( alt_id2_exp_warn_yn  ));
            _bw.write(_wl_block314Bytes, _wl_block314);
            out.print( String.valueOf( alt_id3_type         ));
            _bw.write(_wl_block315Bytes, _wl_block315);
            out.print( String.valueOf( alt_id3_length       ));
            _bw.write(_wl_block316Bytes, _wl_block316);
            out.print( String.valueOf( alt_id3_len_validation_yn ));
            _bw.write(_wl_block317Bytes, _wl_block317);
            out.print( String.valueOf( alt_id3_reqd_yn      ));
            _bw.write(_wl_block318Bytes, _wl_block318);
            out.print( String.valueOf( alt_id3_exp_date_accept_yn ));
            _bw.write(_wl_block319Bytes, _wl_block319);
            out.print( String.valueOf( alt_id3_unique_yn        ));
            _bw.write(_wl_block320Bytes, _wl_block320);
            out.print( String.valueOf( alt_id3_exp_warn_yn  ));
            _bw.write(_wl_block321Bytes, _wl_block321);
            out.print( String.valueOf( alt_id4_type         ));
            _bw.write(_wl_block322Bytes, _wl_block322);
            out.print( String.valueOf( alt_id4_length       ));
            _bw.write(_wl_block323Bytes, _wl_block323);
            out.print( String.valueOf( alt_id4_len_validation_yn ));
            _bw.write(_wl_block324Bytes, _wl_block324);
            out.print( String.valueOf( alt_id4_reqd_yn      ));
            _bw.write(_wl_block325Bytes, _wl_block325);
            out.print( String.valueOf( alt_id4_exp_date_accept_yn ));
            _bw.write(_wl_block326Bytes, _wl_block326);
            out.print( String.valueOf( alt_id4_unique_yn        ));
            _bw.write(_wl_block327Bytes, _wl_block327);
            out.print( String.valueOf( alt_id4_exp_warn_yn  ));
            _bw.write(_wl_block328Bytes, _wl_block328);
            out.print( String.valueOf(mpDisableFieldsNBFather));
            _bw.write(_wl_block329Bytes, _wl_block329);
 }else
			{
            _bw.write(_wl_block330Bytes, _wl_block330);
}
            _bw.write(_wl_block331Bytes, _wl_block331);

	// Onload event function for Accept Patient name as multiParts
	if (operation.equals("insert"))
		out.println("<script>enableName();</script>");
	if(pst1!=null) pst1.close();
    if(pstmt != null ) pstmt.close() ;
	if(pst!=null) pst.close();
	if(stmt11 != null)    stmt11.close();
	if(stmt != null)    stmt.close();
	if(res1!=null) res1.close();
    if(rset != null)    rset.close();
    if(rset11 != null)    rset11.close();
	if(rs!= null ) rs.close() ;
	if(res!=null) res.close();
		if(name_in_oth_lang_yn.equals("Y")){
		
            _bw.write(_wl_block332Bytes, _wl_block332);
}					
	}
	catch( Exception ce ) {ce.printStackTrace();}
    finally
    {
        
        if(con != null) ConnectionManager.returnConnection(con,request);
    }

            _bw.write(_wl_block333Bytes, _wl_block333);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientAdministration.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientAdministration.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.LegalNames.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.LegalNames.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.AlternateIDChecks.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.AlternateIDChecks.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.NewBorn.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.NewBorn.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.others.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.others.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.AADHAAR.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.UM_PatientNumbering.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.PatientNumbering.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.UM_PatientIDLength.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.PatientIDLength.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.NumberingControl.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag16(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag16 = null ;
        int __result__tag16 = 0 ;

        if (__tag16 == null ){
            __tag16 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag16);
        }
        __tag16.setPageContext(pageContext);
        __tag16.setParent(null);
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.AltID1RuleAppl.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag16;
        __result__tag16 = __tag16.doStartTag();

        if (__result__tag16!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag16== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag16.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag16);
            return true;
        }
        _activeTag=__tag16.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag16);
        __tag16.release();
        return false;
    }

    private boolean _jsp__tag17(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag17 = null ;
        int __result__tag17 = 0 ;

        if (__tag17 == null ){
            __tag17 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag17);
        }
        __tag17.setPageContext(pageContext);
        __tag17.setParent(null);
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.SinglePatientNoAppl.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag17;
        __result__tag17 = __tag17.doStartTag();

        if (__result__tag17!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag17== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag17.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag17);
            return true;
        }
        _activeTag=__tag17.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag17);
        __tag17.release();
        return false;
    }

    private boolean _jsp__tag18(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag18 = null ;
        int __result__tag18 = 0 ;

        if (__tag18 == null ){
            __tag18 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag18);
        }
        __tag18.setPageContext(pageContext);
        __tag18.setParent(null);
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.NationalIDChecks.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag18;
        __result__tag18 = __tag18.doStartTag();

        if (__result__tag18!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag18== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag18.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag18);
            return true;
        }
        _activeTag=__tag18.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag18);
        __tag18.release();
        return false;
    }

    private boolean _jsp__tag19(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag19 = null ;
        int __result__tag19 = 0 ;

        if (__tag19 == null ){
            __tag19 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag19);
        }
        __tag19.setPageContext(pageContext);
        __tag19.setParent(null);
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Accept.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag19;
        __result__tag19 = __tag19.doStartTag();

        if (__result__tag19!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag19== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag19.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag19);
            return true;
        }
        _activeTag=__tag19.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag19);
        __tag19.release();
        return false;
    }

    private boolean _jsp__tag20(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag20 = null ;
        int __result__tag20 = 0 ;

        if (__tag20 == null ){
            __tag20 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag20);
        }
        __tag20.setPageContext(pageContext);
        __tag20.setParent(null);
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ExternalInterfaceRequired.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag20;
        __result__tag20 = __tag20.doStartTag();

        if (__result__tag20!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag20== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag20.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag20);
            return true;
        }
        _activeTag=__tag20.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag20);
        __tag20.release();
        return false;
    }

    private boolean _jsp__tag21(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag21 = null ;
        int __result__tag21 = 0 ;

        if (__tag21 == null ){
            __tag21 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag21);
        }
        __tag21.setPageContext(pageContext);
        __tag21.setParent(null);
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.AcceptAlphanumeric.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag21;
        __result__tag21 = __tag21.doStartTag();

        if (__result__tag21!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag21== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag21.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag21);
            return true;
        }
        _activeTag=__tag21.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag21);
        __tag21.release();
        return false;
    }

    private boolean _jsp__tag22(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag22 = null ;
        int __result__tag22 = 0 ;

        if (__tag22 == null ){
            __tag22 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag22);
        }
        __tag22.setPageContext(pageContext);
        __tag22.setParent(null);
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.StartWith.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag22;
        __result__tag22 = __tag22.doStartTag();

        if (__result__tag22!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag22== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag22.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag22);
            return true;
        }
        _activeTag=__tag22.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag22);
        __tag22.release();
        return false;
    }

    private boolean _jsp__tag23(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag23 = null ;
        int __result__tag23 = 0 ;

        if (__tag23 == null ){
            __tag23 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag23);
        }
        __tag23.setPageContext(pageContext);
        __tag23.setParent(null);
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Prompt.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag23;
        __result__tag23 = __tag23.doStartTag();

        if (__result__tag23!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag23== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag23.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag23);
            return true;
        }
        _activeTag=__tag23.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag23);
        __tag23.release();
        return false;
    }

    private boolean _jsp__tag24(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag24 = null ;
        int __result__tag24 = 0 ;

        if (__tag24 == null ){
            __tag24 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag24);
        }
        __tag24.setPageContext(pageContext);
        __tag24.setParent(null);
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.length.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag24;
        __result__tag24 = __tag24.doStartTag();

        if (__result__tag24!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag24== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag24.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag24);
            return true;
        }
        _activeTag=__tag24.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag24);
        __tag24.release();
        return false;
    }

    private boolean _jsp__tag25(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag25 = null ;
        int __result__tag25 = 0 ;

        if (__tag25 == null ){
            __tag25 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag25);
        }
        __tag25.setPageContext(pageContext);
        __tag25.setParent(null);
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.RequiredforAllSeries.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag25;
        __result__tag25 = __tag25.doStartTag();

        if (__result__tag25!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag25== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag25.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag25);
            return true;
        }
        _activeTag=__tag25.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag25);
        __tag25.release();
        return false;
    }

    private boolean _jsp__tag26(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag26 = null ;
        int __result__tag26 = 0 ;

        if (__tag26 == null ){
            __tag26 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag26);
        }
        __tag26.setPageContext(pageContext);
        __tag26.setParent(null);
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Changeallowedforseries.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag26;
        __result__tag26 = __tag26.doStartTag();

        if (__result__tag26!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag26== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag26.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag26);
            return true;
        }
        _activeTag=__tag26.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag26);
        __tag26.release();
        return false;
    }

    private boolean _jsp__tag27(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag27 = null ;
        int __result__tag27 = 0 ;

        if (__tag27 == null ){
            __tag27 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag27);
        }
        __tag27.setPageContext(pageContext);
        __tag27.setParent(null);
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag27;
        __result__tag27 = __tag27.doStartTag();

        if (__result__tag27!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag27== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag27.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag27);
            return true;
        }
        _activeTag=__tag27.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag27);
        __tag27.release();
        return false;
    }

    private boolean _jsp__tag28(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag28 = null ;
        int __result__tag28 = 0 ;

        if (__tag28 == null ){
            __tag28 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag28);
        }
        __tag28.setPageContext(pageContext);
        __tag28.setParent(null);
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Check.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag28;
        __result__tag28 = __tag28.doStartTag();

        if (__result__tag28!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag28== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag28.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag28);
            return true;
        }
        _activeTag=__tag28.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag28);
        __tag28.release();
        return false;
    }

    private boolean _jsp__tag29(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag29 = null ;
        int __result__tag29 = 0 ;

        if (__tag29 == null ){
            __tag29 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag29);
        }
        __tag29.setPageContext(pageContext);
        __tag29.setParent(null);
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.length.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag29;
        __result__tag29 = __tag29.doStartTag();

        if (__result__tag29!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag29== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag29.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag29);
            return true;
        }
        _activeTag=__tag29.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag29);
        __tag29.release();
        return false;
    }

    private boolean _jsp__tag30(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag30 = null ;
        int __result__tag30 = 0 ;

        if (__tag30 == null ){
            __tag30 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag30);
        }
        __tag30.setPageContext(pageContext);
        __tag30.setParent(null);
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.CheckDigitScheme.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag30;
        __result__tag30 = __tag30.doStartTag();

        if (__result__tag30!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag30== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag30.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag30);
            return true;
        }
        _activeTag=__tag30.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag30);
        __tag30.release();
        return false;
    }

    private boolean _jsp__tag31(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag31 = null ;
        int __result__tag31 = 0 ;

        if (__tag31 == null ){
            __tag31 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag31);
        }
        __tag31.setPageContext(pageContext);
        __tag31.setParent(null);
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag31;
        __result__tag31 = __tag31.doStartTag();

        if (__result__tag31!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag31== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag31.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag31);
            return true;
        }
        _activeTag=__tag31.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag31);
        __tag31.release();
        return false;
    }

    private boolean _jsp__tag32(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag32 = null ;
        int __result__tag32 = 0 ;

        if (__tag32 == null ){
            __tag32 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag32);
        }
        __tag32.setPageContext(pageContext);
        __tag32.setParent(null);
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.InvokeRoutine.label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag32;
        __result__tag32 = __tag32.doStartTag();

        if (__result__tag32!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag32== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag32.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag32);
            return true;
        }
        _activeTag=__tag32.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag32);
        __tag32.release();
        return false;
    }

    private boolean _jsp__tag33(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag33 = null ;
        int __result__tag33 = 0 ;

        if (__tag33 == null ){
            __tag33 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag33);
        }
        __tag33.setPageContext(pageContext);
        __tag33.setParent(null);
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.RoutineName.label", java.lang.String .class,"key"));
        __tag33.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag33;
        __result__tag33 = __tag33.doStartTag();

        if (__result__tag33!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag33== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag33.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag33);
            return true;
        }
        _activeTag=__tag33.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag33);
        __tag33.release();
        return false;
    }

    private boolean _jsp__tag34(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag34 = null ;
        int __result__tag34 = 0 ;

        if (__tag34 == null ){
            __tag34 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag34);
        }
        __tag34.setPageContext(pageContext);
        __tag34.setParent(null);
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag34;
        __result__tag34 = __tag34.doStartTag();

        if (__result__tag34!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag34== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag34.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag34);
            return true;
        }
        _activeTag=__tag34.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag34);
        __tag34.release();
        return false;
    }

    private boolean _jsp__tag35(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag35 = null ;
        int __result__tag35 = 0 ;

        if (__tag35 == null ){
            __tag35 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag35);
        }
        __tag35.setPageContext(pageContext);
        __tag35.setParent(null);
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.DftNationalID.label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag35;
        __result__tag35 = __tag35.doStartTag();

        if (__result__tag35!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag35== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag35.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag35);
            return true;
        }
        _activeTag=__tag35.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag35);
        __tag35.release();
        return false;
    }

    private boolean _jsp__tag36(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag36 = null ;
        int __result__tag36 = 0 ;

        if (__tag36 == null ){
            __tag36 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag36);
        }
        __tag36.setPageContext(pageContext);
        __tag36.setParent(null);
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.BiometricAuthentication.label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag36;
        __result__tag36 = __tag36.doStartTag();

        if (__result__tag36!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag36== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag36.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag36);
            return true;
        }
        _activeTag=__tag36.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag36);
        __tag36.release();
        return false;
    }

    private boolean _jsp__tag37(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag37 = null ;
        int __result__tag37 = 0 ;

        if (__tag37 == null ){
            __tag37 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag37);
        }
        __tag37.setPageContext(pageContext);
        __tag37.setParent(null);
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.UM_PatientSeries.label", java.lang.String .class,"key"));
        __tag37.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag37;
        __result__tag37 = __tag37.doStartTag();

        if (__result__tag37!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag37== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag37.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag37);
            return true;
        }
        _activeTag=__tag37.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag37);
        __tag37.release();
        return false;
    }

    private boolean _jsp__tag38(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag38 = null ;
        int __result__tag38 = 0 ;

        if (__tag38 == null ){
            __tag38 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag38);
        }
        __tag38.setPageContext(pageContext);
        __tag38.setParent(null);
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.PatientSeries.label", java.lang.String .class,"key"));
        __tag38.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag38;
        __result__tag38 = __tag38.doStartTag();

        if (__result__tag38!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag38== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag38.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag38);
            return true;
        }
        _activeTag=__tag38.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag38);
        __tag38.release();
        return false;
    }

    private boolean _jsp__tag39(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag39 = null ;
        int __result__tag39 = 0 ;

        if (__tag39 == null ){
            __tag39 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag39);
        }
        __tag39.setPageContext(pageContext);
        __tag39.setParent(null);
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.general.label", java.lang.String .class,"key"));
        __tag39.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag39;
        __result__tag39 = __tag39.doStartTag();

        if (__result__tag39!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag39== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag39.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag39);
            return true;
        }
        _activeTag=__tag39.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag39);
        __tag39.release();
        return false;
    }

    private boolean _jsp__tag40(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag40 = null ;
        int __result__tag40 = 0 ;

        if (__tag40 == null ){
            __tag40 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag40);
        }
        __tag40.setPageContext(pageContext);
        __tag40.setParent(null);
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag40.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag40;
        __result__tag40 = __tag40.doStartTag();

        if (__result__tag40!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag40== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag40.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag40);
            return true;
        }
        _activeTag=__tag40.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag40);
        __tag40.release();
        return false;
    }

    private boolean _jsp__tag41(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag41 = null ;
        int __result__tag41 = 0 ;

        if (__tag41 == null ){
            __tag41 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag41);
        }
        __tag41.setPageContext(pageContext);
        __tag41.setParent(null);
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.NewBorn.label", java.lang.String .class,"key"));
        __tag41.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag41;
        __result__tag41 = __tag41.doStartTag();

        if (__result__tag41!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag41== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag41.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag41);
            return true;
        }
        _activeTag=__tag41.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag41);
        __tag41.release();
        return false;
    }

    private boolean _jsp__tag42(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag42 = null ;
        int __result__tag42 = 0 ;

        if (__tag42 == null ){
            __tag42 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag42);
        }
        __tag42.setPageContext(pageContext);
        __tag42.setParent(null);
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag42.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag42;
        __result__tag42 = __tag42.doStartTag();

        if (__result__tag42!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag42== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag42.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag42);
            return true;
        }
        _activeTag=__tag42.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag42);
        __tag42.release();
        return false;
    }

    private boolean _jsp__tag43(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag43 = null ;
        int __result__tag43 = 0 ;

        if (__tag43 == null ){
            __tag43 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag43);
        }
        __tag43.setPageContext(pageContext);
        __tag43.setParent(null);
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.WithNationalID.label", java.lang.String .class,"key"));
        __tag43.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag43;
        __result__tag43 = __tag43.doStartTag();

        if (__result__tag43!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag43== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag43.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag43);
            return true;
        }
        _activeTag=__tag43.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag43);
        __tag43.release();
        return false;
    }

    private boolean _jsp__tag44(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag44 = null ;
        int __result__tag44 = 0 ;

        if (__tag44 == null ){
            __tag44 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag44);
        }
        __tag44.setPageContext(pageContext);
        __tag44.setParent(null);
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag44.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag44;
        __result__tag44 = __tag44.doStartTag();

        if (__result__tag44!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag44== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag44.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag44);
            return true;
        }
        _activeTag=__tag44.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag44);
        __tag44.release();
        return false;
    }

    private boolean _jsp__tag45(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag45 = null ;
        int __result__tag45 = 0 ;

        if (__tag45 == null ){
            __tag45 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag45);
        }
        __tag45.setPageContext(pageContext);
        __tag45.setParent(null);
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.emergency.label", java.lang.String .class,"key"));
        __tag45.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag45;
        __result__tag45 = __tag45.doStartTag();

        if (__result__tag45!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag45== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag45.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag45);
            return true;
        }
        _activeTag=__tag45.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag45);
        __tag45.release();
        return false;
    }

    private boolean _jsp__tag46(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag46 = null ;
        int __result__tag46 = 0 ;

        if (__tag46 == null ){
            __tag46 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag46);
        }
        __tag46.setPageContext(pageContext);
        __tag46.setParent(null);
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag46.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag46;
        __result__tag46 = __tag46.doStartTag();

        if (__result__tag46!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag46== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag46.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag46);
            return true;
        }
        _activeTag=__tag46.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag46);
        __tag46.release();
        return false;
    }

    private boolean _jsp__tag47(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag47 = null ;
        int __result__tag47 = 0 ;

        if (__tag47 == null ){
            __tag47 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag47);
        }
        __tag47.setPageContext(pageContext);
        __tag47.setParent(null);
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.WithAlternateID.label", java.lang.String .class,"key"));
        __tag47.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag47;
        __result__tag47 = __tag47.doStartTag();

        if (__result__tag47!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag47== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag47.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag47);
            return true;
        }
        _activeTag=__tag47.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag47);
        __tag47.release();
        return false;
    }

    private boolean _jsp__tag48(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag48 = null ;
        int __result__tag48 = 0 ;

        if (__tag48 == null ){
            __tag48 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag48);
        }
        __tag48.setPageContext(pageContext);
        __tag48.setParent(null);
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag48.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag48;
        __result__tag48 = __tag48.doStartTag();

        if (__result__tag48!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag48== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag48.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag48);
            return true;
        }
        _activeTag=__tag48.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag48);
        __tag48.release();
        return false;
    }

    private boolean _jsp__tag49(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag49 = null ;
        int __result__tag49 = 0 ;

        if (__tag49 == null ){
            __tag49 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag49);
        }
        __tag49.setPageContext(pageContext);
        __tag49.setParent(null);
        __tag49.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Default.label", java.lang.String .class,"key"));
        __tag49.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag49;
        __result__tag49 = __tag49.doStartTag();

        if (__result__tag49!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag49== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag49.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag49);
            return true;
        }
        _activeTag=__tag49.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag49);
        __tag49.release();
        return false;
    }

    private boolean _jsp__tag50(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag50 = null ;
        int __result__tag50 = 0 ;

        if (__tag50 == null ){
            __tag50 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag50);
        }
        __tag50.setPageContext(pageContext);
        __tag50.setParent(null);
        __tag50.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.MedicalRecordsAdministration.label", java.lang.String .class,"key"));
        __tag50.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag50;
        __result__tag50 = __tag50.doStartTag();

        if (__result__tag50!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag50== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag50.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag50);
            return true;
        }
        _activeTag=__tag50.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag50);
        __tag50.release();
        return false;
    }

    private boolean _jsp__tag51(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag51 = null ;
        int __result__tag51 = 0 ;

        if (__tag51 == null ){
            __tag51 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag51);
        }
        __tag51.setPageContext(pageContext);
        __tag51.setParent(null);
        __tag51.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.CreateFile.label", java.lang.String .class,"key"));
        __tag51.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag51;
        __result__tag51 = __tag51.doStartTag();

        if (__result__tag51!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag51== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag51.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag51);
            return true;
        }
        _activeTag=__tag51.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag51);
        __tag51.release();
        return false;
    }

    private boolean _jsp__tag52(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag52 = null ;
        int __result__tag52 = 0 ;

        if (__tag52 == null ){
            __tag52 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag52);
        }
        __tag52.setPageContext(pageContext);
        __tag52.setParent(null);
        __tag52.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.FileMaintenance.label", java.lang.String .class,"key"));
        __tag52.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag52;
        __result__tag52 = __tag52.doStartTag();

        if (__result__tag52!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag52== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag52.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag52);
            return true;
        }
        _activeTag=__tag52.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag52);
        __tag52.release();
        return false;
    }

    private boolean _jsp__tag53(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag53 = null ;
        int __result__tag53 = 0 ;

        if (__tag53 == null ){
            __tag53 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag53);
        }
        __tag53.setPageContext(pageContext);
        __tag53.setParent(null);
        __tag53.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.File.label", java.lang.String .class,"key"));
        __tag53.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag53;
        __result__tag53 = __tag53.doStartTag();

        if (__result__tag53!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag53== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag53.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag53);
            return true;
        }
        _activeTag=__tag53.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag53);
        __tag53.release();
        return false;
    }

    private boolean _jsp__tag54(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag54 = null ;
        int __result__tag54 = 0 ;

        if (__tag54 == null ){
            __tag54 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag54);
        }
        __tag54.setPageContext(pageContext);
        __tag54.setParent(null);
        __tag54.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.NumberingControl.label", java.lang.String .class,"key"));
        __tag54.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag54;
        __result__tag54 = __tag54.doStartTag();

        if (__result__tag54!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag54== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag54.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag54);
            return true;
        }
        _activeTag=__tag54.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag54);
        __tag54.release();
        return false;
    }

    private boolean _jsp__tag55(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag55 = null ;
        int __result__tag55 = 0 ;

        if (__tag55 == null ){
            __tag55 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag55);
        }
        __tag55.setPageContext(pageContext);
        __tag55.setParent(null);
        __tag55.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.CreateFileduring.label", java.lang.String .class,"key"));
        __tag55.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag55;
        __result__tag55 = __tag55.doStartTag();

        if (__result__tag55!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag55== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag55.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag55);
            return true;
        }
        _activeTag=__tag55.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag55);
        __tag55.release();
        return false;
    }

    private boolean _jsp__tag56(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag56 = null ;
        int __result__tag56 = 0 ;

        if (__tag56 == null ){
            __tag56 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag56);
        }
        __tag56.setPageContext(pageContext);
        __tag56.setParent(null);
        __tag56.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.UM_PatientRegistrationTitle.label", java.lang.String .class,"key"));
        __tag56.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag56;
        __result__tag56 = __tag56.doStartTag();

        if (__result__tag56!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag56== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag56.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag56);
            return true;
        }
        _activeTag=__tag56.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag56);
        __tag56.release();
        return false;
    }

    private boolean _jsp__tag57(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag57 = null ;
        int __result__tag57 = 0 ;

        if (__tag57 == null ){
            __tag57 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag57);
        }
        __tag57.setPageContext(pageContext);
        __tag57.setParent(null);
        __tag57.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.PatientRegistrationTitle.label", java.lang.String .class,"key"));
        __tag57.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag57;
        __result__tag57 = __tag57.doStartTag();

        if (__result__tag57!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag57== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag57.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag57);
            return true;
        }
        _activeTag=__tag57.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag57);
        __tag57.release();
        return false;
    }

    private boolean _jsp__tag58(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag58 = null ;
        int __result__tag58 = 0 ;

        if (__tag58 == null ){
            __tag58 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag58);
        }
        __tag58.setPageContext(pageContext);
        __tag58.setParent(null);
        __tag58.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.IPAdmission.label", java.lang.String .class,"key"));
        __tag58.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag58;
        __result__tag58 = __tag58.doStartTag();

        if (__result__tag58!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag58== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag58.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag58);
            return true;
        }
        _activeTag=__tag58.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag58);
        __tag58.release();
        return false;
    }

    private boolean _jsp__tag59(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag59 = null ;
        int __result__tag59 = 0 ;

        if (__tag59 == null ){
            __tag59 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag59);
        }
        __tag59.setPageContext(pageContext);
        __tag59.setParent(null);
        __tag59.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.OPVisitRegistration.label", java.lang.String .class,"key"));
        __tag59.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag59;
        __result__tag59 = __tag59.doStartTag();

        if (__result__tag59!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag59== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag59.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag59);
            return true;
        }
        _activeTag=__tag59.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag59);
        __tag59.release();
        return false;
    }

    private boolean _jsp__tag60(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag60 = null ;
        int __result__tag60 = 0 ;

        if (__tag60 == null ){
            __tag60 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag60);
        }
        __tag60.setPageContext(pageContext);
        __tag60.setParent(null);
        __tag60.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.EM.label", java.lang.String .class,"key"));
        __tag60.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag60;
        __result__tag60 = __tag60.doStartTag();

        if (__result__tag60!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag60== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag60.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag60);
            return true;
        }
        _activeTag=__tag60.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag60);
        __tag60.release();
        return false;
    }

    private boolean _jsp__tag61(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag61 = null ;
        int __result__tag61 = 0 ;

        if (__tag61 == null ){
            __tag61 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag61);
        }
        __tag61.setPageContext(pageContext);
        __tag61.setParent(null);
        __tag61.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RegisterAttendance.label", java.lang.String .class,"key"));
        __tag61.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag61;
        __result__tag61 = __tag61.doStartTag();

        if (__result__tag61!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag61== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag61.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag61);
            return true;
        }
        _activeTag=__tag61.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag61);
        __tag61.release();
        return false;
    }

    private boolean _jsp__tag62(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag62 = null ;
        int __result__tag62 = 0 ;

        if (__tag62 == null ){
            __tag62 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag62);
        }
        __tag62.setPageContext(pageContext);
        __tag62.setParent(null);
        __tag62.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.daycare.label", java.lang.String .class,"key"));
        __tag62.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag62;
        __result__tag62 = __tag62.doStartTag();

        if (__result__tag62!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag62== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag62.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag62);
            return true;
        }
        _activeTag=__tag62.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag62);
        __tag62.release();
        return false;
    }

    private boolean _jsp__tag63(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag63 = null ;
        int __result__tag63 = 0 ;

        if (__tag63 == null ){
            __tag63 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag63);
        }
        __tag63.setPageContext(pageContext);
        __tag63.setParent(null);
        __tag63.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admission.label", java.lang.String .class,"key"));
        __tag63.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag63;
        __result__tag63 = __tag63.doStartTag();

        if (__result__tag63!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag63== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag63.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag63);
            return true;
        }
        _activeTag=__tag63.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag63);
        __tag63.release();
        return false;
    }

    private boolean _jsp__tag64(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag64 = null ;
        int __result__tag64 = 0 ;

        if (__tag64 == null ){
            __tag64 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag64);
        }
        __tag64.setPageContext(pageContext);
        __tag64.setParent(null);
        __tag64.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.family.label", java.lang.String .class,"key"));
        __tag64.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag64;
        __result__tag64 = __tag64.doStartTag();

        if (__result__tag64!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag64== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag64.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag64);
            return true;
        }
        _activeTag=__tag64.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag64);
        __tag64.release();
        return false;
    }

    private boolean _jsp__tag65(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag65 = null ;
        int __result__tag65 = 0 ;

        if (__tag65 == null ){
            __tag65 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag65);
        }
        __tag65.setPageContext(pageContext);
        __tag65.setParent(null);
        __tag65.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Organization.label", java.lang.String .class,"key"));
        __tag65.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag65;
        __result__tag65 = __tag65.doStartTag();

        if (__result__tag65!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag65== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag65.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag65);
            return true;
        }
        _activeTag=__tag65.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag65);
        __tag65.release();
        return false;
    }

    private boolean _jsp__tag66(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag66 = null ;
        int __result__tag66 = 0 ;

        if (__tag66 == null ){
            __tag66 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag66);
        }
        __tag66.setPageContext(pageContext);
        __tag66.setParent(null);
        __tag66.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.MaintainFamilyLink.label", java.lang.String .class,"key"));
        __tag66.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag66;
        __result__tag66 = __tag66.doStartTag();

        if (__result__tag66!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag66== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag66.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag66);
            return true;
        }
        _activeTag=__tag66.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag66);
        __tag66.release();
        return false;
    }

    private boolean _jsp__tag67(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag67 = null ;
        int __result__tag67 = 0 ;

        if (__tag67 == null ){
            __tag67 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag67);
        }
        __tag67.setPageContext(pageContext);
        __tag67.setParent(null);
        __tag67.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.MaintainOrganizationMembership.label", java.lang.String .class,"key"));
        __tag67.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag67;
        __result__tag67 = __tag67.doStartTag();

        if (__result__tag67!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag67== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag67.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag67);
            return true;
        }
        _activeTag=__tag67.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag67);
        __tag67.release();
        return false;
    }

    private boolean _jsp__tag68(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag68 = null ;
        int __result__tag68 = 0 ;

        if (__tag68 == null ){
            __tag68 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag68);
        }
        __tag68.setPageContext(pageContext);
        __tag68.setParent(null);
        __tag68.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.RelationshipforOrganizationMember.label", java.lang.String .class,"key"));
        __tag68.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag68;
        __result__tag68 = __tag68.doStartTag();

        if (__result__tag68!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag68== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag68.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag68);
            return true;
        }
        _activeTag=__tag68.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag68);
        __tag68.release();
        return false;
    }

    private boolean _jsp__tag69(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag69 = null ;
        int __result__tag69 = 0 ;

        if (__tag69 == null ){
            __tag69 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag69);
        }
        __tag69.setPageContext(pageContext);
        __tag69.setParent(null);
        __tag69.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag69.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag69;
        __result__tag69 = __tag69.doStartTag();

        if (__result__tag69!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag69== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag69.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag69);
            return true;
        }
        _activeTag=__tag69.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag69);
        __tag69.release();
        return false;
    }

    private boolean _jsp__tag70(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag70 = null ;
        int __result__tag70 = 0 ;

        if (__tag70 == null ){
            __tag70 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag70);
        }
        __tag70.setPageContext(pageContext);
        __tag70.setParent(null);
        __tag70.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.AlternateIDTypeforMembershipID.label", java.lang.String .class,"key"));
        __tag70.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag70;
        __result__tag70 = __tag70.doStartTag();

        if (__result__tag70!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag70== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag70.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag70);
            return true;
        }
        _activeTag=__tag70.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag70);
        __tag70.release();
        return false;
    }

    private boolean _jsp__tag71(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag71 = null ;
        int __result__tag71 = 0 ;

        if (__tag71 == null ){
            __tag71 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag71);
        }
        __tag71.setPageContext(pageContext);
        __tag71.setParent(null);
        __tag71.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag71.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag71;
        __result__tag71 = __tag71.doStartTag();

        if (__result__tag71!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag71== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag71.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag71);
            return true;
        }
        _activeTag=__tag71.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag71);
        __tag71.release();
        return false;
    }

    private boolean _jsp__tag72(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag72 = null ;
        int __result__tag72 = 0 ;

        if (__tag72 == null ){
            __tag72 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag72);
        }
        __tag72.setPageContext(pageContext);
        __tag72.setParent(null);
        __tag72.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.identification.label", java.lang.String .class,"key"));
        __tag72.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag72;
        __result__tag72 = __tag72.doStartTag();

        if (__result__tag72!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag72== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag72.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag72);
            return true;
        }
        _activeTag=__tag72.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag72);
        __tag72.release();
        return false;
    }

    private boolean _jsp__tag73(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag73 = null ;
        int __result__tag73 = 0 ;

        if (__tag73 == null ){
            __tag73 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag73);
        }
        __tag73.setPageContext(pageContext);
        __tag73.setParent(null);
        __tag73.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.AlternateIDTypeforMembershipID.label", java.lang.String .class,"key"));
        __tag73.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag73;
        __result__tag73 = __tag73.doStartTag();

        if (__result__tag73!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag73== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag73.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag73);
            return true;
        }
        _activeTag=__tag73.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag73);
        __tag73.release();
        return false;
    }

    private boolean _jsp__tag74(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag74 = null ;
        int __result__tag74 = 0 ;

        if (__tag74 == null ){
            __tag74 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag74);
        }
        __tag74.setPageContext(pageContext);
        __tag74.setParent(null);
        __tag74.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.identification.label", java.lang.String .class,"key"));
        __tag74.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag74;
        __result__tag74 = __tag74.doStartTag();

        if (__result__tag74!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag74== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag74.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag74);
            return true;
        }
        _activeTag=__tag74.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag74);
        __tag74.release();
        return false;
    }

    private boolean _jsp__tag75(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag75 = null ;
        int __result__tag75 = 0 ;

        if (__tag75 == null ){
            __tag75 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag75);
        }
        __tag75.setPageContext(pageContext);
        __tag75.setParent(null);
        __tag75.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientAdministration.label", java.lang.String .class,"key"));
        __tag75.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag75;
        __result__tag75 = __tag75.doStartTag();

        if (__result__tag75!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag75== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag75.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag75);
            return true;
        }
        _activeTag=__tag75.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag75);
        __tag75.release();
        return false;
    }

    private boolean _jsp__tag76(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag76 = null ;
        int __result__tag76 = 0 ;

        if (__tag76 == null ){
            __tag76 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag76);
        }
        __tag76.setPageContext(pageContext);
        __tag76.setParent(null);
        __tag76.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientAdministration.label", java.lang.String .class,"key"));
        __tag76.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag76;
        __result__tag76 = __tag76.doStartTag();

        if (__result__tag76!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag76== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag76.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag76);
            return true;
        }
        _activeTag=__tag76.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag76);
        __tag76.release();
        return false;
    }

    private boolean _jsp__tag77(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag77 = null ;
        int __result__tag77 = 0 ;

        if (__tag77 == null ){
            __tag77 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag77);
        }
        __tag77.setPageContext(pageContext);
        __tag77.setParent(null);
        __tag77.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.LegalNames.label", java.lang.String .class,"key"));
        __tag77.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag77;
        __result__tag77 = __tag77.doStartTag();

        if (__result__tag77!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag77== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag77.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag77);
            return true;
        }
        _activeTag=__tag77.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag77);
        __tag77.release();
        return false;
    }

    private boolean _jsp__tag78(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag78 = null ;
        int __result__tag78 = 0 ;

        if (__tag78 == null ){
            __tag78 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag78);
        }
        __tag78.setPageContext(pageContext);
        __tag78.setParent(null);
        __tag78.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.LegalNames.label", java.lang.String .class,"key"));
        __tag78.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag78;
        __result__tag78 = __tag78.doStartTag();

        if (__result__tag78!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag78== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag78.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag78);
            return true;
        }
        _activeTag=__tag78.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag78);
        __tag78.release();
        return false;
    }

    private boolean _jsp__tag79(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag79 = null ;
        int __result__tag79 = 0 ;

        if (__tag79 == null ){
            __tag79 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag79);
        }
        __tag79.setPageContext(pageContext);
        __tag79.setParent(null);
        __tag79.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.AlternateIDChecks.label", java.lang.String .class,"key"));
        __tag79.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag79;
        __result__tag79 = __tag79.doStartTag();

        if (__result__tag79!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag79== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag79.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag79);
            return true;
        }
        _activeTag=__tag79.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag79);
        __tag79.release();
        return false;
    }

    private boolean _jsp__tag80(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag80 = null ;
        int __result__tag80 = 0 ;

        if (__tag80 == null ){
            __tag80 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag80);
        }
        __tag80.setPageContext(pageContext);
        __tag80.setParent(null);
        __tag80.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.AlternateIDChecks.label", java.lang.String .class,"key"));
        __tag80.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag80;
        __result__tag80 = __tag80.doStartTag();

        if (__result__tag80!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag80== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag80.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag80);
            return true;
        }
        _activeTag=__tag80.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag80);
        __tag80.release();
        return false;
    }

    private boolean _jsp__tag81(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag81 = null ;
        int __result__tag81 = 0 ;

        if (__tag81 == null ){
            __tag81 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag81);
        }
        __tag81.setPageContext(pageContext);
        __tag81.setParent(null);
        __tag81.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.NewBorn.label", java.lang.String .class,"key"));
        __tag81.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag81;
        __result__tag81 = __tag81.doStartTag();

        if (__result__tag81!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag81== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag81.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag81);
            return true;
        }
        _activeTag=__tag81.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag81);
        __tag81.release();
        return false;
    }

    private boolean _jsp__tag82(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag82 = null ;
        int __result__tag82 = 0 ;

        if (__tag82 == null ){
            __tag82 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag82);
        }
        __tag82.setPageContext(pageContext);
        __tag82.setParent(null);
        __tag82.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.NewBorn.label", java.lang.String .class,"key"));
        __tag82.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag82;
        __result__tag82 = __tag82.doStartTag();

        if (__result__tag82!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag82== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag82.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag82);
            return true;
        }
        _activeTag=__tag82.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag82);
        __tag82.release();
        return false;
    }

    private boolean _jsp__tag83(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag83 = null ;
        int __result__tag83 = 0 ;

        if (__tag83 == null ){
            __tag83 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag83);
        }
        __tag83.setPageContext(pageContext);
        __tag83.setParent(null);
        __tag83.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.others.label", java.lang.String .class,"key"));
        __tag83.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag83;
        __result__tag83 = __tag83.doStartTag();

        if (__result__tag83!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag83== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag83.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag83);
            return true;
        }
        _activeTag=__tag83.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag83);
        __tag83.release();
        return false;
    }

    private boolean _jsp__tag84(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag84 = null ;
        int __result__tag84 = 0 ;

        if (__tag84 == null ){
            __tag84 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag84);
        }
        __tag84.setPageContext(pageContext);
        __tag84.setParent(null);
        __tag84.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.others.label", java.lang.String .class,"key"));
        __tag84.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag84;
        __result__tag84 = __tag84.doStartTag();

        if (__result__tag84!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag84== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag84.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag84);
            return true;
        }
        _activeTag=__tag84.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag84);
        __tag84.release();
        return false;
    }

    private boolean _jsp__tag85(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag85 = null ;
        int __result__tag85 = 0 ;

        if (__tag85 == null ){
            __tag85 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag85);
        }
        __tag85.setPageContext(pageContext);
        __tag85.setParent(null);
        __tag85.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.AADHAAR.label", java.lang.String .class,"key"));
        __tag85.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag85;
        __result__tag85 = __tag85.doStartTag();

        if (__result__tag85!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag85== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag85.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag85);
            return true;
        }
        _activeTag=__tag85.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag85);
        __tag85.release();
        return false;
    }

    private boolean _jsp__tag86(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag86 = null ;
        int __result__tag86 = 0 ;

        if (__tag86 == null ){
            __tag86 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag86);
        }
        __tag86.setPageContext(pageContext);
        __tag86.setParent(null);
        __tag86.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.UM_AcceptPatientNameinLocalLanguage.label", java.lang.String .class,"key"));
        __tag86.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag86;
        __result__tag86 = __tag86.doStartTag();

        if (__result__tag86!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag86== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag86.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag86);
            return true;
        }
        _activeTag=__tag86.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag86);
        __tag86.release();
        return false;
    }

    private boolean _jsp__tag87(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag87 = null ;
        int __result__tag87 = 0 ;

        if (__tag87 == null ){
            __tag87 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag87);
        }
        __tag87.setPageContext(pageContext);
        __tag87.setParent(null);
        __tag87.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.AcceptPatientNameinLocalLanguage.label", java.lang.String .class,"key"));
        __tag87.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag87;
        __result__tag87 = __tag87.doStartTag();

        if (__result__tag87!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag87== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag87.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag87);
            return true;
        }
        _activeTag=__tag87.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag87);
        __tag87.release();
        return false;
    }

    private boolean _jsp__tag88(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag88 = null ;
        int __result__tag88 = 0 ;

        if (__tag88 == null ){
            __tag88 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag88);
        }
        __tag88.setPageContext(pageContext);
        __tag88.setParent(null);
        __tag88.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.DefaultSoundexType.label", java.lang.String .class,"key"));
        __tag88.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag88;
        __result__tag88 = __tag88.doStartTag();

        if (__result__tag88!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag88== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag88.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag88);
            return true;
        }
        _activeTag=__tag88.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag88);
        __tag88.release();
        return false;
    }

    private boolean _jsp__tag89(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag89 = null ;
        int __result__tag89 = 0 ;

        if (__tag89 == null ){
            __tag89 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag89);
        }
        __tag89.setPageContext(pageContext);
        __tag89.setParent(null);
        __tag89.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.UM_AcceptPatientNameasMultiparts.label", java.lang.String .class,"key"));
        __tag89.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag89;
        __result__tag89 = __tag89.doStartTag();

        if (__result__tag89!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag89== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag89.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag89);
            return true;
        }
        _activeTag=__tag89.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag89);
        __tag89.release();
        return false;
    }

    private boolean _jsp__tag90(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag90 = null ;
        int __result__tag90 = 0 ;

        if (__tag90 == null ){
            __tag90 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag90);
        }
        __tag90.setPageContext(pageContext);
        __tag90.setParent(null);
        __tag90.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.AcceptPatientNameasMultiparts.label", java.lang.String .class,"key"));
        __tag90.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag90;
        __result__tag90 = __tag90.doStartTag();

        if (__result__tag90!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag90== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag90.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag90);
            return true;
        }
        _activeTag=__tag90.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag90);
        __tag90.release();
        return false;
    }

    private boolean _jsp__tag91(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag91 = null ;
        int __result__tag91 = 0 ;

        if (__tag91 == null ){
            __tag91 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag91);
        }
        __tag91.setPageContext(pageContext);
        __tag91.setParent(null);
        __tag91.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Accept.label", java.lang.String .class,"key"));
        __tag91.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag91;
        __result__tag91 = __tag91.doStartTag();

        if (__result__tag91!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag91== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag91.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag91);
            return true;
        }
        _activeTag=__tag91.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag91);
        __tag91.release();
        return false;
    }

    private boolean _jsp__tag92(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag92 = null ;
        int __result__tag92 = 0 ;

        if (__tag92 == null ){
            __tag92 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag92);
        }
        __tag92.setPageContext(pageContext);
        __tag92.setParent(null);
        __tag92.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.length.label", java.lang.String .class,"key"));
        __tag92.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag92;
        __result__tag92 = __tag92.doStartTag();

        if (__result__tag92!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag92== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag92.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag92);
            return true;
        }
        _activeTag=__tag92.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag92);
        __tag92.release();
        return false;
    }

    private boolean _jsp__tag93(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag93 = null ;
        int __result__tag93 = 0 ;

        if (__tag93 == null ){
            __tag93 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag93);
        }
        __tag93.setPageContext(pageContext);
        __tag93.setParent(null);
        __tag93.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ReqdforOrgnMember.label", java.lang.String .class,"key"));
        __tag93.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag93;
        __result__tag93 = __tag93.doStartTag();

        if (__result__tag93!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag93== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag93.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag93);
            return true;
        }
        _activeTag=__tag93.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag93);
        __tag93.release();
        return false;
    }

    private boolean _jsp__tag94(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag94 = null ;
        int __result__tag94 = 0 ;

        if (__tag94 == null ){
            __tag94 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag94);
        }
        __tag94.setPageContext(pageContext);
        __tag94.setParent(null);
        __tag94.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.required.label", java.lang.String .class,"key"));
        __tag94.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag94;
        __result__tag94 = __tag94.doStartTag();

        if (__result__tag94!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag94== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag94.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag94);
            return true;
        }
        _activeTag=__tag94.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag94);
        __tag94.release();
        return false;
    }

    private boolean _jsp__tag95(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag95 = null ;
        int __result__tag95 = 0 ;

        if (__tag95 == null ){
            __tag95 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag95);
        }
        __tag95.setPageContext(pageContext);
        __tag95.setParent(null);
        __tag95.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Ordering.label", java.lang.String .class,"key"));
        __tag95.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag95;
        __result__tag95 = __tag95.doStartTag();

        if (__result__tag95!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag95== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag95.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag95);
            return true;
        }
        _activeTag=__tag95.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag95);
        __tag95.release();
        return false;
    }

    private boolean _jsp__tag96(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag96 = null ;
        int __result__tag96 = 0 ;

        if (__tag96 == null ){
            __tag96 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag96);
        }
        __tag96.setPageContext(pageContext);
        __tag96.setParent(null);
        __tag96.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Legend.label", java.lang.String .class,"key"));
        __tag96.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag96;
        __result__tag96 = __tag96.doStartTag();

        if (__result__tag96!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag96== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag96.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag96);
            return true;
        }
        _activeTag=__tag96.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag96);
        __tag96.release();
        return false;
    }

    private boolean _jsp__tag97(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag97 = null ;
        int __result__tag97 = 0 ;

        if (__tag97 == null ){
            __tag97 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag97);
        }
        __tag97.setPageContext(pageContext);
        __tag97.setParent(null);
        __tag97.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.LegendforLocLang.label", java.lang.String .class,"key"));
        __tag97.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag97;
        __result__tag97 = __tag97.doStartTag();

        if (__result__tag97!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag97== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag97.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag97);
            return true;
        }
        _activeTag=__tag97.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag97);
        __tag97.release();
        return false;
    }

    private boolean _jsp__tag98(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag98 = null ;
        int __result__tag98 = 0 ;

        if (__tag98 == null ){
            __tag98 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag98);
        }
        __tag98.setPageContext(pageContext);
        __tag98.setParent(null);
        __tag98.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.prefix.label", java.lang.String .class,"key"));
        __tag98.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag98;
        __result__tag98 = __tag98.doStartTag();

        if (__result__tag98!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag98== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag98.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag98);
            return true;
        }
        _activeTag=__tag98.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag98);
        __tag98.release();
        return false;
    }

    private boolean _jsp__tag99(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag99 = null ;
        int __result__tag99 = 0 ;

        if (__tag99 == null ){
            __tag99 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag99);
        }
        __tag99.setPageContext(pageContext);
        __tag99.setParent(null);
        __tag99.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.FirstName.label", java.lang.String .class,"key"));
        __tag99.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag99;
        __result__tag99 = __tag99.doStartTag();

        if (__result__tag99!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag99== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag99.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag99);
            return true;
        }
        _activeTag=__tag99.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag99);
        __tag99.release();
        return false;
    }

    private boolean _jsp__tag100(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag100 = null ;
        int __result__tag100 = 0 ;

        if (__tag100 == null ){
            __tag100 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag100);
        }
        __tag100.setPageContext(pageContext);
        __tag100.setParent(null);
        __tag100.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SecondName.label", java.lang.String .class,"key"));
        __tag100.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag100;
        __result__tag100 = __tag100.doStartTag();

        if (__result__tag100!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag100== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag100.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag100);
            return true;
        }
        _activeTag=__tag100.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag100);
        __tag100.release();
        return false;
    }

    private boolean _jsp__tag101(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag101 = null ;
        int __result__tag101 = 0 ;

        if (__tag101 == null ){
            __tag101 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag101);
        }
        __tag101.setPageContext(pageContext);
        __tag101.setParent(null);
        __tag101.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ThirdName.label", java.lang.String .class,"key"));
        __tag101.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag101;
        __result__tag101 = __tag101.doStartTag();

        if (__result__tag101!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag101== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag101.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag101);
            return true;
        }
        _activeTag=__tag101.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag101);
        __tag101.release();
        return false;
    }

    private boolean _jsp__tag102(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag102 = null ;
        int __result__tag102 = 0 ;

        if (__tag102 == null ){
            __tag102 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag102);
        }
        __tag102.setPageContext(pageContext);
        __tag102.setParent(null);
        __tag102.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.FamilyName.label", java.lang.String .class,"key"));
        __tag102.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag102;
        __result__tag102 = __tag102.doStartTag();

        if (__result__tag102!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag102== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag102.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag102);
            return true;
        }
        _activeTag=__tag102.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag102);
        __tag102.release();
        return false;
    }

    private boolean _jsp__tag103(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag103 = null ;
        int __result__tag103 = 0 ;

        if (__tag103 == null ){
            __tag103 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag103);
        }
        __tag103.setPageContext(pageContext);
        __tag103.setParent(null);
        __tag103.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Suffix.label", java.lang.String .class,"key"));
        __tag103.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag103;
        __result__tag103 = __tag103.doStartTag();

        if (__result__tag103!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag103== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag103.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag103);
            return true;
        }
        _activeTag=__tag103.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag103);
        __tag103.release();
        return false;
    }

    private boolean _jsp__tag104(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag104 = null ;
        int __result__tag104 = 0 ;

        if (__tag104 == null ){
            __tag104 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag104);
        }
        __tag104.setPageContext(pageContext);
        __tag104.setParent(null);
        __tag104.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.PatientNameDerivationLogic.label", java.lang.String .class,"key"));
        __tag104.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag104;
        __result__tag104 = __tag104.doStartTag();

        if (__result__tag104!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag104== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag104.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag104);
            return true;
        }
        _activeTag=__tag104.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag104);
        __tag104.release();
        return false;
    }

    private boolean _jsp__tag105(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag105 = null ;
        int __result__tag105 = 0 ;

        if (__tag105 == null ){
            __tag105 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag105);
        }
        __tag105.setPageContext(pageContext);
        __tag105.setParent(null);
        __tag105.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ForEnglish.label", java.lang.String .class,"key"));
        __tag105.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag105;
        __result__tag105 = __tag105.doStartTag();

        if (__result__tag105!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag105== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag105.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag105);
            return true;
        }
        _activeTag=__tag105.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag105);
        __tag105.release();
        return false;
    }

    private boolean _jsp__tag106(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag106 = null ;
        int __result__tag106 = 0 ;

        if (__tag106 == null ){
            __tag106 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag106);
        }
        __tag106.setPageContext(pageContext);
        __tag106.setParent(null);
        __tag106.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ForLocLang.label", java.lang.String .class,"key"));
        __tag106.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag106;
        __result__tag106 = __tag106.doStartTag();

        if (__result__tag106!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag106== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag106.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag106);
            return true;
        }
        _activeTag=__tag106.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag106);
        __tag106.release();
        return false;
    }

    private boolean _jsp__tag107(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag107 = null ;
        int __result__tag107 = 0 ;

        if (__tag107 == null ){
            __tag107 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag107);
        }
        __tag107.setPageContext(pageContext);
        __tag107.setParent(null);
        __tag107.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.UM_DefaultPatientNameInEnglish.label", java.lang.String .class,"key"));
        __tag107.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag107;
        __result__tag107 = __tag107.doStartTag();

        if (__result__tag107!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag107== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag107.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag107);
            return true;
        }
        _activeTag=__tag107.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag107);
        __tag107.release();
        return false;
    }

    private boolean _jsp__tag108(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag108 = null ;
        int __result__tag108 = 0 ;

        if (__tag108 == null ){
            __tag108 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag108);
        }
        __tag108.setPageContext(pageContext);
        __tag108.setParent(null);
        __tag108.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.DefaultPatientNameInEnglish.label", java.lang.String .class,"key"));
        __tag108.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag108;
        __result__tag108 = __tag108.doStartTag();

        if (__result__tag108!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag108== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag108.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag108);
            return true;
        }
        _activeTag=__tag108.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag108);
        __tag108.release();
        return false;
    }

    private boolean _jsp__tag109(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag109 = null ;
        int __result__tag109 = 0 ;

        if (__tag109 == null ){
            __tag109 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag109);
        }
        __tag109.setPageContext(pageContext);
        __tag109.setParent(null);
        __tag109.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.PatientLongNameDerivationLogic.label", java.lang.String .class,"key"));
        __tag109.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag109;
        __result__tag109 = __tag109.doStartTag();

        if (__result__tag109!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag109== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag109.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag109);
            return true;
        }
        _activeTag=__tag109.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag109);
        __tag109.release();
        return false;
    }

    private boolean _jsp__tag110(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag110 = null ;
        int __result__tag110 = 0 ;

        if (__tag110 == null ){
            __tag110 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag110);
        }
        __tag110.setPageContext(pageContext);
        __tag110.setParent(null);
        __tag110.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ForEnglish.label", java.lang.String .class,"key"));
        __tag110.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag110;
        __result__tag110 = __tag110.doStartTag();

        if (__result__tag110!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag110== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag110.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag110);
            return true;
        }
        _activeTag=__tag110.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag110);
        __tag110.release();
        return false;
    }

    private boolean _jsp__tag111(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag111 = null ;
        int __result__tag111 = 0 ;

        if (__tag111 == null ){
            __tag111 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag111);
        }
        __tag111.setPageContext(pageContext);
        __tag111.setParent(null);
        __tag111.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ForLocLang.label", java.lang.String .class,"key"));
        __tag111.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag111;
        __result__tag111 = __tag111.doStartTag();

        if (__result__tag111!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag111== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag111.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag111);
            return true;
        }
        _activeTag=__tag111.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag111);
        __tag111.release();
        return false;
    }

    private boolean _jsp__tag112(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag112 = null ;
        int __result__tag112 = 0 ;

        if (__tag112 == null ){
            __tag112 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag112);
        }
        __tag112.setPageContext(pageContext);
        __tag112.setParent(null);
        __tag112.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.NewbornNameDervLogic.label", java.lang.String .class,"key"));
        __tag112.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag112;
        __result__tag112 = __tag112.doStartTag();

        if (__result__tag112!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag112== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag112.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag112);
            return true;
        }
        _activeTag=__tag112.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag112);
        __tag112.release();
        return false;
    }

    private boolean _jsp__tag113(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag113 = null ;
        int __result__tag113 = 0 ;

        if (__tag113 == null ){
            __tag113 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag113);
        }
        __tag113.setPageContext(pageContext);
        __tag113.setParent(null);
        __tag113.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ForEnglish.label", java.lang.String .class,"key"));
        __tag113.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag113;
        __result__tag113 = __tag113.doStartTag();

        if (__result__tag113!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag113== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag113.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag113);
            return true;
        }
        _activeTag=__tag113.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag113);
        __tag113.release();
        return false;
    }

    private boolean _jsp__tag114(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag114 = null ;
        int __result__tag114 = 0 ;

        if (__tag114 == null ){
            __tag114 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag114);
        }
        __tag114.setPageContext(pageContext);
        __tag114.setParent(null);
        __tag114.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.NewbornNameDervLogicSB.label", java.lang.String .class,"key"));
        __tag114.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag114;
        __result__tag114 = __tag114.doStartTag();

        if (__result__tag114!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag114== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag114.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag114);
            return true;
        }
        _activeTag=__tag114.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag114);
        __tag114.release();
        return false;
    }

    private boolean _jsp__tag115(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag115 = null ;
        int __result__tag115 = 0 ;

        if (__tag115 == null ){
            __tag115 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag115);
        }
        __tag115.setPageContext(pageContext);
        __tag115.setParent(null);
        __tag115.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ForEnglish.label", java.lang.String .class,"key"));
        __tag115.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag115;
        __result__tag115 = __tag115.doStartTag();

        if (__result__tag115!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag115== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag115.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag115);
            return true;
        }
        _activeTag=__tag115.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag115);
        __tag115.release();
        return false;
    }
}
