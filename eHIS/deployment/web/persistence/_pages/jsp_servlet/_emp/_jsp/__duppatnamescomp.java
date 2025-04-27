package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.HashMap;
import java.util.ArrayList;
import webbeans.eCommon.*;
import java.util.*;

public final class __duppatnamescomp extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/DupPatNamesComp.jsp", 1743484961002L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 =" \n<SCRIPT LANGUAGE=\"JavaScript\"> \nvar NamePrefixArray = new Array(); \nvar NamePrefixLocArray = new Array(); \nvar PrefixSexArray = new Array();\nvar NameSuffixArray = new Array();\nvar NameSuffixLocArray = new Array();\nvar SuffixSexArray = new Array();\n\nasync function callSearch(fromobj, toobj, field_lang)\n{\n\tvar names_in_oth_lang = document.forms[0].pat_names_in_oth_lang_yn.value;\n\tvar lang_dir = document.forms[0].language_direction.value;\t\n\tif(lang_dir == \'R\')\n\t{\n\t\tvar jsp_name =\"../../eMP/jsp/SearchStdOtherName.jsp?names_in_oth_lang=\"+names_in_oth_lang+\"&param_value=\"+encodeURIComponent(fromobj.value)+\"&field_lang=\"+field_lang;\n\t\t\t\n\t\tif(fromobj.name == \"family_name\" || fromobj.name==\"family_name_oth_lang\")\n\t\t{\n\t\t\tjsp_name =\"../../eMP/jsp/SearchStdFamilyName.jsp?names_in_oth_lang=\"+names_in_oth_lang+\"&param_value=\"+encodeURIComponent(fromobj.value)+\"&field_lang=\"+field_lang;\n\t\t}\n\n\t\tvar retVal = new String();\n\t\tvar dialogHeight = \"28\";\n\t\tvar dialogWidth = \"43\";\n\t\tvar status = \"no\";\n\t\tvar arguments = \"\";\n\t\tvar features = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; scroll=no; status:\" + status;\n\t\tretVal =await window.showModalDialog( jsp_name,arguments,features);\n\n\t\tif(retVal != null)\n\t\t{\n\t\t\tvar arr = retVal.split(\"`\");\n\t\t\tif((fromobj.name).indexOf(\"oth_lang\") == -1)\n\t\t\t{\n\t\t\t\tfromobj.value =arr[0]\n\t\t\t\ttoobj =eval(\"document.forms[0].\"+toobj)\n\t\t\t\tif(toobj != null)\n\t\t\t\t{\n\t\t\t\t\ttoobj.value = arr[1]\n\t\t\t\t}\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\ttoobj.value = arr[0]\n\t\t\t\tfromobj.value =arr[1]\n\t\t\t\tChangeInitCase(toobj)\n\t\t\t}\n\t\t\t//fromobj.focus();\n\t\t}\n\t}\n}\n\nfunction sel_prefix_gen(obj)\n{\nvar val=obj.value;\nvar prefix_length;\n\tif(obj.value != \"\")\n\t{\n\t\tif(obj.name==\"name_prefix\")\n\t\t{\n\t\tprefix_length=NamePrefixArray.length;\n\t\tfor (i = 0; i < prefix_length; i++) \n\t\t{                      \n\t\t if(unescape(NamePrefixArray[i])==val)\n\t\t {\n\t\t\tif(document.getElementById(\"name_prefix_oth_lang\"))\n\t\t\t { document.getElementById(\"name_prefix_oth_lang\").value=unescape(NamePrefixLocArray[i]);\n\t\t\t }\n\t\t\tif(unescape(PrefixSexArray[i])!=\'B\')\n\t\t\tdocument.getElementById(\"sex\").value=unescape(PrefixSexArray[i]);\n\t\t\telse\n\t\t\t\t\tdocument.getElementById(\"sex\").value=\"\";\n\t\t\t\n\t\t }\n\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\tprefix_length=NamePrefixLocArray.length;\n\t\t\tfor (i = 0; i < prefix_length; i++) \n\t\t\t{                      \n\t\t\t if(unescape(NamePrefixLocArray[i])==val)\n\t\t\t {\n\t\t\t\tif(document.getElementById(\"name_prefix\"))\n\t\t\t\t{\n\t\t\t\tdocument.getElementById(\"name_prefix\").value=unescape(NamePrefixArray[i]);\n\t\t\t\t}\n\t\t\t\tif(unescape(PrefixSexArray[i])!=\'B\')\n\t\t\t\tdocument.getElementById(\"sex\").value=unescape(PrefixSexArray[i]);\n\t\t\t\telse\n\t\t\t\t\tdocument.getElementById(\"sex\").value=\"\";\n\t\t\t\t\n\t\t\t }\n\t\t\t}\n\n\t\t}\n\t}\n\telse\n\t{\n\t\tif(document.getElementById(\"name_prefix_oth_lang\"))\n\t\tdocument.getElementById(\"name_prefix_oth_lang\").value=\"\";\n\t\tif(document.getElementById(\"name_prefix\"))\n\t\tdocument.getElementById(\"name_prefix\").value=\"\";\n\t\tdocument.getElementById(\"sex\").value=\"\";\n\t}\n\tputLocalLangPatientName();\n\tputPatientName();\n}\n\nfunction sel_suffix_gen(obj)\n{\nvar val=obj.value;\nvar prefix_length;\n\tif(obj.value != \"\")\n\t{\n\t\tif(obj.name==\"name_suffix\")\n\t\t{\n\t\tprefix_length=NameSuffixArray.length;\n\t\tfor (i = 0; i < prefix_length; i++) \n\t\t{                      \n\t\t if(unescape(NameSuffixArray[i])==val)\n\t\t {\n\t\t\tif(document.getElementById(\"name_suffix_oth_lang\"))\n\t\t\t{\tdocument.getElementById(\"name_suffix_oth_lang\").value=unescape(NameSuffixLocArray[i]);\n\t\t\t}\n\t\t\tif(unescape(SuffixSexArray[i])!=\'B\')\n\t\t\tdocument.getElementById(\"sex\").value=unescape(SuffixSexArray[i]);\n\t\t\telse\n\t\t\t\t\tdocument.getElementById(\"sex\").value=\"\";\n\t\t\t\n\t\t }\n\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\tprefix_length=NameSuffixLocArray.length;\n\t\t\tfor (i = 0; i < prefix_length; i++) \n\t\t\t{                      \n\t\t\t if(unescape(NameSuffixLocArray[i])==val)\n\t\t\t {\n\t\t\t\tif(document.getElementById(\"name_suffix\"))\n\t\t\t\t{\n\t\t\t\tdocument.getElementById(\"name_suffix\").value=unescape(NameSuffixArray[i]);\n\t\t\t\t}\n\t\t\t\tif(unescape(SuffixSexArray[i])!=\'B\')\n\t\t\t\tdocument.getElementById(\"sex\").value=unescape(SuffixSexArray[i]);\n\t\t\t\telse\n\t\t\t\t\tdocument.getElementById(\"sex\").value=\"\";\n\t\t\t\t\n\t\t\t }\n\t\t\t}\n\n\t\t}\n\t}\n\telse\n\t{\n\t\tif(document.getElementById(\"name_suffix_oth_lang\"))\n\t\tdocument.getElementById(\"name_suffix_oth_lang\").value=\"\";\n\t\tif(document.getElementById(\"name_suffix\"))\n\t\tdocument.getElementById(\"name_suffix\").value=\"\";\n\t\tdocument.getElementById(\"sex\").value=\"\";\n\t}\n\tputLocalLangPatientName();\n\tputPatientName();\n}\n</SCRIPT>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t<tr>\n\t\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t\t\t\t\t\t\t<td  class=\'LABELLEFT\'  >";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'first_name_reqd_yn\' id=\'first_name_reqd_yn\' value=\'N\'></td>\n\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'first_name_prompt\' id=\'first_name_prompt\' value=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\">\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =" <input type=\'hidden\' name=\'first_name_reqd_yn\' id=\'first_name_reqd_yn\' value=\'N\'></input></td> ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="<td class=\'LABELLEFT\' >&nbsp;</td>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t\t\t<td  class=\'LABELLEFT\' >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'second_name_reqd_yn\' id=\'second_name_reqd_yn\' value=\'Y\'></input><img src=\'../../eCommon/images/mandatory.gif\'></img></td>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'second_name_prompt\' id=\'second_name_prompt\' value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" <input type=\'hidden\' name=\'second_name_reqd_yn\' id=\'second_name_reqd_yn\' value=\'N\'></input></td> ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t\t   ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'third_name_reqd_yn\' id=\'third_name_reqd_yn\' value=\'Y\'></input><img src=\'../../eCommon/images/mandatory.gif\'></img></td>\n\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'third_name_prompt\' id=\'third_name_prompt\' value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" <input type=\'hidden\' name=\'third_name_reqd_yn\' id=\'third_name_reqd_yn\' value=\'N\'></input></td> ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t\t\t<td  class=\'LABELLEFT\'  nowrap >";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td><input type=\'hidden\' name=\'family_name_reqd_yn\' id=\'family_name_reqd_yn\' value=\'N\'></input>\n\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'family_name_prompt\' id=\'family_name_prompt\' value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n\t\t\t\t\t\t\t\t  ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="  <input type=\'hidden\' name=\'family_name_reqd_yn\' id=\'family_name_reqd_yn\' value=\'N\'></input></td> ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t<td  class=\'LABELLEFT\'  >";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t<input type=\'hidden\' name=\'family_name_reqd_yn\' id=\'family_name_reqd_yn\' value=\'Y\'></input></td>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'family_name_prompt\' id=\'family_name_prompt\' value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" <input type=\'hidden\' name=\'family_name_reqd_yn\' id=\'family_name_reqd_yn\' value=\'N\'></input></td> ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="<td class=\'LABELLEFT\' colspan=\'2\'>&nbsp;</td>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t</tr>\n\t\t\t<tr>\n\n\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t\t\t\t<td   class=\'fields\'  width=\'25%\' nowrap>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="<input type=\'button\' style=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' class=\'button\' value=\'?\' onclick=\"callSearch(first_name,\'first_name_oth_lang\',\'English\')\" name=\'bf\'></td><td class=\'label\' ></td> ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' class=\'button\' value=\'?\' onclick=\"callSearch(second_name,\'second_name_oth_lang\',\'English\')\" name=\'bs\'></td><td class=\'label\' >&nbsp;</td>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t\t\t<td class=\'fields\' width=\'25%\' nowrap>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' class=\'button\' value=\'?\' onclick=\"callSearch(third_name,\'third_name_oth_lang\',\'English\')\" name=\'bt\' id=\'bt\'></td><td class=\'label\' >&nbsp;</td> ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' class=\'button\' value=\'?\' onclick=\"callSearch(family_name,\'family_name_oth_lang\',\'English\')\" name=\'bfam\'> \n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" \n\t\t\t\t\t\t\t\t</td><td class=\'label\' >&nbsp;</td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</td>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="<td class=\'label\' colspan=\'2\'>&nbsp;</td>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t</tr>\n\t\t<tr><td colspan=\'4\'>&nbsp;</tr>\n\t   <script>\n\t\tif ( (document.getElementById(\"family_org_membership\")) && (document.forms[0].name_prefix_img) )\n\t\t{\n\t\t\tif (document.getElementById(\"family_org_membership\").value==\'1\' && document.getElementById(\"name_pfx_reqd_for_org_mem_yn\").value==\'Y\'  ){\n\t\t\t\tdocument.forms[0].name_prefix_img.style.visibility=\'visible\';\n\t\t\t}else{\n\t\t\t\tdocument.forms[0].name_prefix_img.style.visibility=\'hidden\';\n\t\t}}\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t<script>\n\t\t\t\tif ( document.forms[0].name_prefix_oth_lang)\n\t\t\t\t{\n\t\t\t\t\tif ( (document.getElementById(\"family_org_membership\")) && (document.getElementById(\"family_org_membership\").value==\'1\')  ) \n\t\t\t\t\t{\n\t\t\t\t\t\tdocument.forms[0].name_prefix_oth_lang.disabled=true;\n\t\t\t\t\t}else{\n\t\t\t\t\t\tdocument.forms[0].name_prefix_oth_lang.disabled=false;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t<tr>\n\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t\t<td  class=\'LABELLEFT\'>";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="&nbsp;";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'first_oth_name_reqd_yn\' id=\'first_oth_name_reqd_yn\' value=\'Y\'></input><img\tid=\'first_oth\' src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'first_oth_name_reqd_yn\' id=\'first_oth_name_reqd_yn\' value=\'N\'><img\tid=\'first_oth\' src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden\"></input> \n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t\t\n\t\t\t\t\t\t<input type=\'hidden\' name=\'first_name_oth_prompt\' id=\'first_name_oth_prompt\' value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n\t\t\t\t\t\t</td><td class=\'LABELLEFT\' >&nbsp;</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t<td   class=\'LABELLEFT\'>";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'second_oth_name_reqd_yn\' id=\'second_oth_name_reqd_yn\' value=\'Y\'></input><img id=\"sec_oth\" src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'second_oth_name_reqd_yn\' id=\'second_oth_name_reqd_yn\' value=\'N\'><img\tid=\'sec_oth\' src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden\"></input> \n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\t<input type=\'hidden\' name=\'second_name_oth_prompt\' id=\'second_name_oth_prompt\' value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\"> \n\t\t\t\t\t\t</td><td class=\'LABELLEFT\' >&nbsp;</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'third_oth_name_reqd_yn\' id=\'third_oth_name_reqd_yn\' value=\'Y\'></input><img id=\'third_oth\' src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'third_oth_name_reqd_yn\' id=\'third_oth_name_reqd_yn\' value=\'N\'><img\tid=\'third_oth\' src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden\"></input> \n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t\t<input type=\'hidden\' name=\'third_name_oth_prompt\' id=\'third_name_oth_prompt\' value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n\t\t\t\t\t\t</td><td class=\'LABELLEFT\' >&nbsp;</td> \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\t\t<td  class=\'LABELLEFT\' >";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'family_oth_name_reqd_yn\' id=\'family_oth_name_reqd_yn\' value=\'Y\'></input><img id=\'fam_oth\' src=\'../../eCommon/images/mandatory.gif\'  style=\'visibility:visible\'></img>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'family_oth_name_reqd_yn\' id=\'family_oth_name_reqd_yn\' value=\'N\'><img\tid=\'fam_oth\' src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden\"></input>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t<input type=\'hidden\' name=\'family_name_oth_prompt\' id=\'family_name_oth_prompt\' value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n\t\t\t\t\t\t</td><td class=\'LABELLEFT\' >&nbsp;</td>            \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="<td   class=\'LABELLEFT\' >";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 =" <input type=\'hidden\' name=\'family_oth_name_reqd_yn\' id=\'family_oth_name_reqd_yn\' value=\'N\'><img\tid=\'fam_oth\' src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden\"></input> ";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\"></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="<td class=\'v\' colspan=\'2\'>&nbsp;</td>";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t</tr>\n\t\t<tr>\n\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="<input type=\'button\' class=\'button\' value=\'?\' style=\'visibility:hidden\' onclick=\"document.forms[0].first_name_oth_lang.focus();callSearch(\'first_name_oth_lang\',\'first_name\',\'Others\')\" name=\'bfo\' id=\'bfo\'>\n\t\t\t\t\t\t</td><td class=\'label\' >&nbsp;</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="<input type=\'button\' class=\'button\' style=\'visibility:hidden\' value=\'?\'onclick=\'callSearch(second_name_oth_lang,second_name,\"Others\")\' name=\'bso\' id=\'bso\'> \n\t\t\t\t\t\t</td><td class=\'label\' >&nbsp;</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="<input type=\'button\' class=\'button\' value=\'?\' style=\'visibility:hidden\' onclick=\'callSearch(third_name_oth_lang,third_name,\"Others\")\' name=\'bto\' id=\'bto\'>\n\t\t\t\t\t\t</td><td class=\'label\' >&nbsp;</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="<input type=\'button\' class=\'button\' value=\'?\' style=\'visibility:hidden\' onclick=\'callSearch(family_name_oth_lang,family_name,\"Others\")\' name=\'bfamo\' id=\'bfamo\'>\n\t\t\t\t\t\t</td><td class=\'label\' >&nbsp;</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="</tr>\n\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t<script>if (parent.frames[0].document.getElementById(\"patient_name_loc_lang\")) parent.frames[0].document.getElementById(\"patient_name_loc_lang\").style.visibility = \'visible\';</script>";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t\t\t<td  class=\'arabic\' >\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t\t\t\t\t<td   class=\'arabic\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\">\n\t\t\t\t\t\t</td><td class=\'arabic\' >&nbsp;</td> \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\"> \n\t\t\t\t\t\t</td><td class=\'arabic\' >&nbsp;</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t\t\t\t<td  class=\'arabic\'>&nbsp;";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\n\t\t\t\t\t\t</td><td class=\'arabic\' >&nbsp;</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="<td   class=\'arabic\' >\n\t\t\t\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\t<td class=\'arabic\'  ><img src=\'../../eCommon/images/mandatory.gif\' id=\'name_prefix_oth\' style=\'visibility:hidden;\'></img>&nbsp;";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\t\t\t  \t\t\t\n\t\t\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t\t <script>\t\t\t\t\t\n\t\t\t\t\tif(document.getElementById(\"name_prefix_oth\"))\t\t\t\t\t\n\t\t\t\t\t\tdocument.getElementById(\"name_prefix_oth\").style.visibility=\'visible\';\n\t\t\t\t </script>\n\t\t\t\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t\t\t\t<script>\t\t\t\t\t\n\t\t\t\t\tif ( (document.getElementById(\"name_prefix_oth\")) && (document.forms[0].name_pfx_reqd_for_org_mem_yn.value==\'Y\')){ document.getElementById(\"name_prefix_oth\").style.visibility=\'visible\' }\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tdocument.getElementById(\"name_prefix_oth\").style.visibility=\'hidden\' \n\t\t\t\t\t}\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t\t\t<input type=\'hidden\' name=\'name_prefix_oth_name_reqd_yn\' id=\'name_prefix_oth_name_reqd_yn\' value=\'Y\'></input>\n\t\t\t\t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 =" \n\t\t\t\t <input type=\'hidden\' name=\'name_prefix_oth_name_reqd_yn\' id=\'name_prefix_oth_name_reqd_yn\' value=\'N\'></input>\n\t\t\t\t <script>\t\t\t\t\t\n\t\t\t\t\tif (document.getElementById(\"name_prefix_oth\")) \n\t\t\t\t\t{\n\t\t\t\t\t\tdocument.getElementById(\"name_prefix_oth\").style.visibility=\'hidden\'\n\t\t\t\t\t}\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t\t\t<input type=\'hidden\' name=\'name_prefix_oth_prompt\' id=\'name_prefix_oth_prompt\' value=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\">\n\t\t\t</td>\n\t\t\t<td class=\'arabic\'>&nbsp;</td>\n\t\t\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="<input type=\'hidden\' name=\'name_prefix_oth_name_reqd_yn\' id=\'name_prefix_oth_name_reqd_yn\' value=\'N\'></td> ";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t\t\t\t<td   class=\'arabic\'><Select name=\'name_suffix_oth_lang\' id=\'name_suffix_oth_lang\' onchange=\'sel_suffix_gen(this);putLocalLangPatientName(this);\' dir=\'RTL\' tabIndex=\'24\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t\t\t\t<td   class=\'arabic\'><Select name=\'name_suffix_oth_lang\' id=\'name_suffix_oth_lang\' onchange=\'sel_suffix_gen(this);putLocalLangPatientName(this);\' dir=\'RTL\' tabIndex=\'24\'>\n\t\t\t\t";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t\t\t</td>\n\t\t\t<td class=\'arabic\'>&nbsp;</td>\n\t\t\t";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="<input type=\'button\' class=\'button\' value=\'?\' style=\'";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\' onclick=\'callSearch(family_name_oth_lang,family_name,\"Others\")\' name=\'bfamo\'>\n\t\t\t\t\t\t</td><td class=\'label\' >&nbsp;</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\' onclick=\'callSearch(third_name_oth_lang,third_name,\"Others\")\' name=\'bto\'>\n\t\t\t\t\t\t</td><td class=\'label\' >&nbsp;</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="<input type=\'button\' class=\'button\' style=\'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\' value=\'?\'onclick=\'callSearch(second_name_oth_lang,second_name,\"Others\")\' name=\'bso\'> \n\t\t\t\t\t\t</td><td class=\'label\' >&nbsp;</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\' onclick=\"callSearch(first_name_oth_lang,first_name,\'Others\')\" name=\'bfo\'>\n\t\t\t\t\t\t</td><td class=\'label\' >&nbsp;</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\t\t\t\t\t<td class=\'arabic\'   ><Select name=\'name_prefix_oth_lang\' id=\'name_prefix_oth_lang\' onchange=\'sel_prefix_gen(this);putLocalLangPatientName(this);if (document.forms[0].entitlement_by_pat_cat_yn && document.forms[0].entitlement_by_pat_cat_yn.value==\"Y\"){getPatCategory();}\' dir=\'RTL\' tabIndex=\'19\' >\n\t\t\t\t\t";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n\t\t\t\t\t<td class=\'arabic\'  ><Select name=\'name_prefix_oth_lang\' id=\'name_prefix_oth_lang\' onchange=\'sel_prefix_gen(this);putLocalLangPatientName(this);if ( document.forms[0].entitlement_by_pat_cat_yn && document.forms[0].entitlement_by_pat_cat_yn.value==\"Y\"){getPatCategory();}\' dir=\'RTL\'  tabIndex=\'19\' > \n\t\t\t\t\t";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n\t\t\t\t\t<Option value=\'\'>------";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="------</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="</Select></td>\t<!-- <td class=\'label\'>&nbsp;</td> -->\n\t\t\t";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\t\t<input type=\'hidden\' name=\'language_direction\' id=\'language_direction\' value=";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 =">\n\t\t<input type=\'hidden\' name=\'pat_names_in_oth_lang_yn\' id=\'pat_names_in_oth_lang_yn\' value=";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 =">\n\t\t";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n\n";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

	public static String checkForNull(String inputString)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
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
            _bw.write(_wl_block2Bytes, _wl_block2);

    Connection conn			= null;
	PreparedStatement pstmt=null ;
    ResultSet rs=null ;
	try
	{
	String language_direction = "";
	String name_comp_visibility = "visibility:hidden";
	request.setCharacterEncoding("UTF-8");
	String facility_id=checkForNull((String)session.getAttribute("facility_id")); //added for the incident 34901

	int count=0;


	Properties p					=	 (java.util.Properties) session.getValue("jdbc");
	conn							=	 ConnectionManager.getConnection(request);
 	HashMap hash_Map				=	 new HashMap();
 	HashMap hash_Map1				=	 new HashMap();
	HashMap Name_Order 			=	 new HashMap(); 

	ArrayList array_List				=	 new ArrayList();
	



		pstmt = conn.prepareStatement( "select count(*) as total from sm_language where language_direction='R' and eff_status='E'" ) ;
		
		rs = pstmt.executeQuery() ;
             
			
        if ( rs != null && rs.next() ) 
		 {
		  count = rs.getInt("total");
		 }

		
		if ( count==1 ) 
		{
			 language_direction = "R" ;
			 name_comp_visibility = "visibility:visible";
		}else
		{
			 language_direction = "L" ;
			 name_comp_visibility = "visibility:hidden";
		}


		 if(pstmt != null) pstmt.close();
		 if(rs != null) rs.close();


	String patient_id						= checkForNull(request.getParameter("patient_id"));
	String group								= checkForNull(request.getParameter("group"));
	String CalledFromFunction			= checkForNull(request.getParameter("CalledFromFunction"));
	

	String a_family_name					= checkForNull(request.getParameter("a_family_name"));
	String a_first_name					= checkForNull(request.getParameter("a_first_name"));
	String a_second_name				= checkForNull(request.getParameter("a_second_name"));
	String a_third_name					= checkForNull(request.getParameter("a_third_name"));

	String a_name_prefix_loc_lang			= checkForNull(request.getParameter("a_name_prefix_loc_lang"));
	String a_first_name_loc_lang			= checkForNull(request.getParameter("a_first_name_loc_lang"));
	String a_second_name_loc_lang		= checkForNull(request.getParameter("a_second_name_loc_lang"));
	String a_third_name_loc_lang			= checkForNull(request.getParameter("a_third_name_loc_lang"));
	String a_family_name_loc_lang			= checkForNull(request.getParameter("a_family_name_loc_lang"));
	String a_name_suffix_loc_lang			= checkForNull(request.getParameter("a_name_suffix_loc_lang"));
	//String a_patient_name_loc_lang		= checkForNull(request.getParameter("a_patient_name_loc_lang"));

	//	out.println("a_patient_name_loc_lang "+a_patient_name_loc_lang);

	hash_Map	= eMP.ChangePatientDetails.getSetupData(facility_id,group, conn,p);
	String Name_Prefix_Accept_Yn			= checkForNull((String) hash_Map.get("Name_Prefix_Accept_Yn"));
	String Name_Prefix_Reqd_Yn			= checkForNull((String) hash_Map.get("Name_Prefix_Reqd_Yn"));
	String Name_Suffix_Accept_Yn			= checkForNull((String) hash_Map.get("Name_Suffix_Accept_Yn"));
	String Name_Suffix_Reqd_Yn			= checkForNull((String) hash_Map.get("Name_Suffix_Reqd_Yn"));
	String First_Name_Accept_Yn			= checkForNull((String) hash_Map.get("First_Name_Accept_Yn"));
	String First_Name_Prompt				= checkForNull((String) hash_Map.get("First_Name_Prompt"));
	String First_Name_Reqd_Yn				= checkForNull((String) hash_Map.get("First_Name_Reqd_Yn"));
	String Second_Name_Accept_Yn		= checkForNull((String) hash_Map.get("Second_Name_Accept_Yn"));
	String Second_Name_Prompt			= checkForNull((String) hash_Map.get("Second_Name_Prompt"));
	String Third_Name_Accept_Yn			= checkForNull((String) hash_Map.get("Third_Name_Accept_Yn"));
	String Third_Name_Prompt				= checkForNull((String) hash_Map.get("Third_Name_Prompt"));
	String Family_Name_Accept_Yn		= checkForNull((String) hash_Map.get("Family_Name_Accept_Yn"));
	String Family_Name_Prompt				= checkForNull((String) hash_Map.get("Family_Name_Prompt"));
	String Second_Name_Reqd_Yn			= checkForNull((String) hash_Map.get("Second_Name_Reqd_Yn"));
	String Third_Name_Reqd_Yn			= checkForNull((String) hash_Map.get("Third_Name_Reqd_Yn"));
	String Family_Name_Reqd_Yn			= checkForNull((String) hash_Map.get("Family_Name_Reqd_Yn"));
	String pat_name_as_multipart_yn		= checkForNull((String) hash_Map.get("pat_name_as_multipart_yn"));
	
	
	String Name_Prefix_Prompt				= checkForNull((String)hash_Map.get("Name_Prefix_Prompt"));
	String  Family_Name_Order				= checkForNull((String) hash_Map.get("Family_Name_Order"));
	String  First_Name_Order				= checkForNull((String) hash_Map.get("First_Name_Order"));
	String  Second_Name_Order			= checkForNull((String) hash_Map.get("Second_Name_Order"));
	String  Third_Name_Order				= checkForNull((String) hash_Map.get("Third_Name_Order"));

	//String  name_prefix_length				= checkForNull((String) hash_Map.get("name_prefix_length"),"0");
	String  first_name_length					= checkForNull((String) hash_Map.get("first_name_length"),"0");
	String  second_name_length			= checkForNull((String) hash_Map.get("second_name_length"),"0");
	String  third_name_length				= checkForNull((String) hash_Map.get("third_name_length"),"0");
	String  family_name_length				= checkForNull((String) hash_Map.get("family_name_length"),"0");
//	String  name_suffix_length				= checkForNull((String) hash_Map.get("name_suffix_length"),"0");

	 /* Prompts and Orders are placed in Hash Map for easy retrieval */
	Name_Order.put(Family_Name_Order,"Family_Name_Order");
	Name_Order.put(First_Name_Order,"First_Name_Order");
	Name_Order.put(Second_Name_Order,"Second_Name_Order");
	Name_Order.put(Third_Name_Order,"Third_Name_Order");

	String name_suffix			= "";
	String name_prefix			= "";
	String family_name		= "";
	String first_name			= "";
	String second_name		= "";
	String third_name			= "";

	int		 emptyCnt			= 0;  /*To Count the Missing Name Fields as per MP Param*/

	ArrayList arrayList2 = new ArrayList();
	arrayList2 = eMP.ChangePatientDetails.getResultRows(conn,"mp_name_prefix",p);
	out.println("<script>");
	int a = 0;
	for(int i=0;i<arrayList2.size();i+=3) 
	{
		out.print("NamePrefixArray["+a+"]=escape(\""+(String)arrayList2.get(i)+"\");");
		out.print("NamePrefixLocArray["+a+"]=escape(\""+(String)arrayList2.get(i+1)+"\");");
		out.print("PrefixSexArray["+a+"]=escape(\""+(String)arrayList2.get(i+2)+"\");");				
		a++;
	} 
	out.println("</script>");
	arrayList2.clear();
	arrayList2 = eMP.ChangePatientDetails.getResultRows(conn,"mp_name_suffix2",p);
	out.println("<script>");
	a = 0;
	for(int i=0;i<arrayList2.size();i+=3) 
	{
		out.print("NameSuffixArray["+a+"]=escape(\""+(String)arrayList2.get(i)+"\");");
		out.print("NameSuffixLocArray["+a+"]=escape(\""+(String)arrayList2.get(i+1)+"\");");
		out.print("SuffixSexArray["+a+"]=escape(\""+(String)arrayList2.get(i+2)+"\");");				
		a++;
	} 
	out.println("</script>");

	
	if(CalledFromFunction.equals("ChangePatDtls")) 
	{
		 hash_Map1				= eMP.ChangePatientDetails.getPatientData(patient_id, conn,p);
		 name_suffix				= checkForNull((String) hash_Map1.get("name_suffix"));
		 name_prefix			= checkForNull((String) hash_Map1.get("name_prefix"));
		 first_name				= checkForNull((String) hash_Map1.get("first_name"));
		 second_name			= checkForNull((String) hash_Map1.get("second_name"));
		 third_name				= checkForNull((String) hash_Map1.get("third_name"));
		 family_name			= checkForNull((String) hash_Map1.get("family_name"));
	}

            _bw.write(_wl_block3Bytes, _wl_block3);

						
			/*If Multi Part Name is acceptable; Based on the name order in MP Param paint the prompts for names*/
			   if  (pat_name_as_multipart_yn.equals("Y"))
			   {
				     String order = "";
					 for(int i=1;i<=4;++i)
					 {
						 if (Name_Order.get((new Integer(i)).toString()) != null)
							 order = (String)Name_Order.get((new Integer(i)).toString());
						 else
							 order = ""; 

						
						 if (order.equals("First_Name_Order"))
						 {
							if(First_Name_Accept_Yn.equals("Y")) 
							{ 
								
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(First_Name_Prompt));
            _bw.write(_wl_block5Bytes, _wl_block5);

								if(First_Name_Reqd_Yn.equals("Y")) 
								{
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(First_Name_Prompt));
            _bw.write(_wl_block7Bytes, _wl_block7);
} else 
								{ 
            _bw.write(_wl_block8Bytes, _wl_block8);
 }
									
            _bw.write(_wl_block9Bytes, _wl_block9);

							}
							 else
								emptyCnt++;
						 }
						 else
						 if (order.equals("Second_Name_Order"))
						 {
							 if(Second_Name_Accept_Yn.equals("Y")) 
							{
								
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(Second_Name_Prompt));
            _bw.write(_wl_block5Bytes, _wl_block5);
 if(Second_Name_Reqd_Yn.equals("Y")) { 
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(Second_Name_Prompt));
            _bw.write(_wl_block7Bytes, _wl_block7);
 } else { 
            _bw.write(_wl_block12Bytes, _wl_block12);
 }
								
            _bw.write(_wl_block9Bytes, _wl_block9);

							}
							else
							{
								emptyCnt++;
							}
						 }
						 else
						 if (order.equals("Third_Name_Order"))
						 {
							 if (Third_Name_Accept_Yn.equals("Y") )
							{ 
								
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(Third_Name_Prompt));
            _bw.write(_wl_block13Bytes, _wl_block13);
 if(Third_Name_Reqd_Yn.equals("Y")) { 
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(Third_Name_Prompt));
            _bw.write(_wl_block7Bytes, _wl_block7);
 } else { 
            _bw.write(_wl_block15Bytes, _wl_block15);
 }
								
            _bw.write(_wl_block9Bytes, _wl_block9);

							}
							else
							{
								emptyCnt++;
							}
						 }
						 else
						 if (order.equals("Family_Name_Order"))
						 {
							 if (Family_Name_Accept_Yn.equals("Y") ) 
							{  
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Family_Name_Prompt));
            _bw.write(_wl_block5Bytes, _wl_block5);

								 if(Family_Name_Reqd_Yn.equals("Y")) { 
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Family_Name_Prompt));
            _bw.write(_wl_block18Bytes, _wl_block18);
 } else { 
            _bw.write(_wl_block19Bytes, _wl_block19);
 }
								  
            _bw.write(_wl_block9Bytes, _wl_block9);

							}
							else
							{
								emptyCnt++;
							}
						 }
						 else
						 {
							 emptyCnt++;
						 }
					}
			   }else{ 

				if(Family_Name_Accept_Yn.equals("Y")) 
				{ 
					
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(Family_Name_Prompt));
            _bw.write(_wl_block21Bytes, _wl_block21);
  if(Family_Name_Reqd_Yn.equals("Y")) { 
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Family_Name_Prompt));
            _bw.write(_wl_block23Bytes, _wl_block23);
 } else { 
            _bw.write(_wl_block24Bytes, _wl_block24);
 }
				}}
					/*  if (pat_name_as_multipart_yn.equals("Y") */
				
				 /*To fill the blank spaces in the table with blank TDs*/
				for(int j=1;j<=emptyCnt;++j)
					{
            _bw.write(_wl_block25Bytes, _wl_block25);
}
				
            _bw.write(_wl_block26Bytes, _wl_block26);
	
			    emptyCnt = 0;
			   	if (pat_name_as_multipart_yn.equals("Y") )
				{
					 String order = "";
					 for(int i=1;i<=4;++i)
					 {
						 if (Name_Order.get((new Integer(i)).toString()) != null)
							 order = (String)Name_Order.get((new Integer(i)).toString());
						 else
							 order = ""; 

						

						 if (order.equals("First_Name_Order"))
						 {
							if(First_Name_Accept_Yn.equals("Y")) 
							{ 
								
            _bw.write(_wl_block27Bytes, _wl_block27);

								out.print("<input type='text' name='first_name' id='first_name' maxlength='"+first_name_length+"' size='"+first_name_length+"'      onblur='makeValidString(this);ChangeInitCase(this);putPatientName(this)' tabIndex='15'");
								if(CalledFromFunction.equals("ChangePatDtls") || !a_first_name.equals(""))
								{
									if(CalledFromFunction.equals("ChangePatDtls"))
									{
										if(!(((String)hash_Map1.get("first_name")).equals("")))
											out.print(" value=\""+(String)hash_Map1.get("first_name")+"\">");
										else out.print(" value=\"\" >"); 
									}
									else if(!a_first_name.equals(""))
										out.print(" value=\""+a_first_name+"\">");
									else out.print(" value=\"\" >"); 
								}
								else out.print(" value = \"\" >");
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(name_comp_visibility));
            _bw.write(_wl_block29Bytes, _wl_block29);

							}
							else
							{
								emptyCnt++;
							}
						 }
						 else
						 if (order.equals("Second_Name_Order"))
						 {
							 if (Second_Name_Accept_Yn.equals("Y")) 
							{ 
								
            _bw.write(_wl_block27Bytes, _wl_block27);
  out.print("<input type='text' name='second_name' id='second_name' maxlength='"+second_name_length+"' size='"+second_name_length+"' onblur='makeValidString(this);ChangeInitCase(this);putPatientName(this)' tabIndex='15'");
								if(CalledFromFunction.equals("ChangePatDtls") || !a_second_name.equals(""))
								{
									if(CalledFromFunction.equals("ChangePatDtls"))
									{
										if (!(((String)hash_Map1.get("second_name"))).equals(""))
											out.print(" value=\""+checkForNull((String)hash_Map1.get("second_name"))+"\">");
										else out.print(" value = \"\" >");
									}
									else if(!a_second_name.equals(""))
									{
										out.print(" value=\""+a_second_name+"\">");
									}
									else out.print(" value = \"\" >");
								} else out.print(" value = \"\" >");
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(name_comp_visibility));
            _bw.write(_wl_block30Bytes, _wl_block30);

							}
							else
							{
								emptyCnt++;
							}
						 }
						 else
						 if (order.equals("Third_Name_Order"))
						 {
							if(Third_Name_Accept_Yn.equals("Y")) 
							{ 
								
            _bw.write(_wl_block31Bytes, _wl_block31);
  out.print("<input type='text' name='third_name' id='third_name' maxlength='"+third_name_length+"' size='"+third_name_length+"'  onblur='makeValidString(this);ChangeInitCase(this);putPatientName(this)' tabIndex='15'");
								if(CalledFromFunction.equals("ChangePatDtls") || !a_third_name.equals(""))
								{
									if(CalledFromFunction.equals("ChangePatDtls"))
									{
										if(!(((String)hash_Map1.get("third_name")).equals("")))
											out.print(" value=\""+(String)hash_Map1.get("third_name")+"\">");
										else out.print(" value = \"\" >");    
									}
									else if(!a_third_name.equals(""))
									{
										out.print(" value=\""+a_third_name+"\">");
									}
									else out.print(" value = \"\" >");    
								}else out.print(" value = \"\" >");
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(name_comp_visibility));
            _bw.write(_wl_block32Bytes, _wl_block32);

							}
							else
							{
								emptyCnt++;
							}
						 }
						 else
						 if (order.equals("Family_Name_Order"))
						 {
							 if(Family_Name_Accept_Yn.equals("Y")) 
							{   
								out.print("<td  class='fields'  width='25%' nowrap><input type='text' name='family_name' id='family_name' maxlength='"+family_name_length+"' size='"+family_name_length+"'  onblur='makeValidString(this);ChangeInitCase(this);putPatientName(this)' tabIndex='15'");
								if(CalledFromFunction.equals("ChangePatDtls") || !a_family_name.equals(""))
								{
									if((CalledFromFunction.equals("ChangePatDtls")) && !(((String)hash_Map1.get("family_name")).equals("")))
										out.print(" value=\""+(String)hash_Map1.get("family_name")+"\">");
									else if(!a_family_name.equals(""))
										out.print(" value=\""+a_family_name+"\">");
									else out.print(" value = \"\" >");    
								} else out.print(" value = \"\" >");    
								if (pat_name_as_multipart_yn.equals("Y")) { 
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(name_comp_visibility));
            _bw.write(_wl_block33Bytes, _wl_block33);
 } 
            _bw.write(_wl_block34Bytes, _wl_block34);
 
							}
							else
							{
								emptyCnt++;
							}
						 }
						  else
						  {
							 emptyCnt++;
						  }
						}
			}/* END of	if (pat_name_as_multipart_yn.equals("Y") ) */
			else
			{
				 
				
			    if(Family_Name_Accept_Yn.equals("Y"))  
			    { 
				out.print("<td class='fields' nowrap ><input type='text' name='family_name' id='family_name' maxlength='"+family_name_length+"' size='"+family_name_length+"' onblur='makeValidString(this);ChangeInitCase(this);putPatientName(this);' tabIndex='18'");
				}
				if(CalledFromFunction.equals("ChangePatDtls") || !a_family_name.equals(""))
				{
					
					if( (CalledFromFunction.equals("ChangePatDtls")) && !(((String)hash_Map1.get("family_name")).equals("")))
						out.print(" value=\""+(String)hash_Map1.get("family_name")+"\">");
					else if(!a_family_name.equals(""))
						out.print(" value=\""+a_family_name+"\" >");
					else out.print(" value = \"\" >");   
				}  
				else if(Family_Name_Accept_Yn.equals("Y"))
				{
					out.print(" value = \"\" >");
				
            _bw.write(_wl_block35Bytes, _wl_block35);

				}
					
			 }
		 /*To fill the blank spaces in the table with blank TDs*/
		for(int j=1;j<=emptyCnt;++j)
			{
            _bw.write(_wl_block36Bytes, _wl_block36);
}
		
            _bw.write(_wl_block37Bytes, _wl_block37);

		if (CalledFromFunction.equals("ChangePatDtls") ) { 
            _bw.write(_wl_block38Bytes, _wl_block38);
 }
	//String names_in_oth_lang_yn	= checkForNull(request.getParameter("names_in_oth_lang_yn"));
		
	String family_name_loc_lang_prompt= checkForNull((String) hash_Map.get("family_name_loc_lang_prompt"));
	String pat_name_in_loc_lang_reqd_yn   =checkForNull(request.getParameter("pat_name_in_loc_lang_reqd_yn"),"N");
	
	String first_name_loc_lang_prompt			=checkForNull((String)hash_Map.get("first_name_loc_lang_prompt"));
	String second_name_loc_lang_prompt    =checkForNull((String)hash_Map.get("second_name_loc_lang_prompt"));
	String third_name_loc_lang_prompt       =checkForNull((String)hash_Map.get("third_name_loc_lang_prompt"));
	String name_prefix_loc_lang_prompt      =checkForNull((String)hash_Map.get("name_prefix_loc_lang_prompt"));
	
	String names_in_oth_lang_yn					= checkForNull((String)hash_Map.get("names_in_oth_lang_yn"),"N");
if(CalledFromFunction.equals("ChangePatDtls")) 
	{
		hash_Map1 = eMP.ChangePatientDetails.getPatientData(patient_id, conn,p);
	}
   String temp		= "";
   emptyCnt	= 0;  /*To Count the Missing Name Fields as per MP Param*/
   if(names_in_oth_lang_yn.equals("Y")) 
   {
	   if(!language_direction.equals("R"))
	   {
	   
            _bw.write(_wl_block39Bytes, _wl_block39);

/*If Multi Part Name is acceptable; Based on the name order in MP Param paint the prompts for names*/
		if (pat_name_as_multipart_yn.equals("Y") )
		{
			 String order = "";
			 /*Prompts and Names to be painted in Reverse Order for Local Lang*/
			 for(int i=1;i<=4;++i)
			 {
				 if (Name_Order.get((new Integer(i)).toString()) != null)
							 order = (String)Name_Order.get((new Integer(i)).toString());
						 else
							 order = ""; 
				 if (order.equals("First_Name_Order"))
				 {
					 if (First_Name_Accept_Yn.equals("Y")) 
					 { 
						
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(first_name_loc_lang_prompt));
            _bw.write(_wl_block41Bytes, _wl_block41);

						if ( (First_Name_Reqd_Yn.equals("Y") ) && pat_name_in_loc_lang_reqd_yn.equals("Y")) 
						{ 
							
            _bw.write(_wl_block42Bytes, _wl_block42);

						}
						else
						{
							
            _bw.write(_wl_block43Bytes, _wl_block43);

						}
						temp = ((first_name_loc_lang_prompt).equals("&nbsp;"))? First_Name_Prompt:first_name_loc_lang_prompt; 
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(temp));
            _bw.write(_wl_block45Bytes, _wl_block45);

					}
					else
					{
						emptyCnt++;
					}
				 }
				 else
				 if (order.equals("Second_Name_Order"))
				 {
					  if(Second_Name_Accept_Yn.equals("Y")) 
					  {
						
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(second_name_loc_lang_prompt));
            _bw.write(_wl_block21Bytes, _wl_block21);

						if ((Second_Name_Reqd_Yn.equals("Y")) && pat_name_in_loc_lang_reqd_yn.equals("Y")) 
						{
							
            _bw.write(_wl_block47Bytes, _wl_block47);

						}
						else
						{ 
							
            _bw.write(_wl_block48Bytes, _wl_block48);

						}
						temp = ((second_name_loc_lang_prompt).equals("&nbsp;")) ? Second_Name_Prompt:second_name_loc_lang_prompt; 
						
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(temp));
            _bw.write(_wl_block50Bytes, _wl_block50);

					}
					else
					{
						emptyCnt++;
					}
				 }
				 else
				 if (order.equals("Third_Name_Order"))
				 {
					  if(Third_Name_Accept_Yn.equals("Y")) 
					  { 
						
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(third_name_loc_lang_prompt));
            _bw.write(_wl_block21Bytes, _wl_block21);
 
						if ((Third_Name_Reqd_Yn.equals("Y")) && pat_name_in_loc_lang_reqd_yn.equals("Y")) 
						{ 
							
            _bw.write(_wl_block51Bytes, _wl_block51);

						}
						else
						{
							
            _bw.write(_wl_block52Bytes, _wl_block52);

						}
						temp = ((third_name_loc_lang_prompt).equals("&nbsp;")) ? Third_Name_Prompt:third_name_loc_lang_prompt; 
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(temp));
            _bw.write(_wl_block54Bytes, _wl_block54);

					}
					else
					{
						emptyCnt++;
					}
				 }
				 else
				 if (order.equals("Family_Name_Order"))
				 {
					if(Family_Name_Accept_Yn.equals("Y") ) 
					{
						
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(family_name_loc_lang_prompt));
            _bw.write(_wl_block21Bytes, _wl_block21);

						if ((Family_Name_Reqd_Yn.equals("Y")) && pat_name_in_loc_lang_reqd_yn.equals("Y")) 
						{ 
							
            _bw.write(_wl_block56Bytes, _wl_block56);

						}
						else
						{
							
            _bw.write(_wl_block57Bytes, _wl_block57);

						}
						temp = family_name_loc_lang_prompt.equals("&nbsp;") ? Family_Name_Prompt : family_name_loc_lang_prompt; 
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(temp));
            _bw.write(_wl_block59Bytes, _wl_block59);

					}
					else
					{
						emptyCnt++;
					}
			 }
			 else
			 {
				emptyCnt++;
			 }
  		  }
		}/* END of  if (pat_name_as_multipart_yn.equals("Y") )   */
		else
		{
		   if(Family_Name_Accept_Yn.equals("Y") ) 
			{
				
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(family_name_loc_lang_prompt));
            _bw.write(_wl_block61Bytes, _wl_block61);

				if ( (Family_Name_Reqd_Yn.equals("Y")) && pat_name_in_loc_lang_reqd_yn.equals("Y"))
					{
					out.print("<input type='hidden' name='family_oth_name_reqd_yn' id='family_oth_name_reqd_yn' value='Y'></input><img id='fam_oth' src='../../eCommon/images/mandatory.gif' style='visibility:visible'></img>");
				} else { 
            _bw.write(_wl_block62Bytes, _wl_block62);
 }
						temp = family_name_loc_lang_prompt.equals("&nbsp;")? Family_Name_Prompt:family_name_loc_lang_prompt ; 
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(temp));
            _bw.write(_wl_block63Bytes, _wl_block63);

			}
		}	

	
		 /*To fill the blank spaces in the table with blank TDs*/
		 for(int j=1;j<=emptyCnt;++j)
			   {
            _bw.write(_wl_block64Bytes, _wl_block64);
}
		
            _bw.write(_wl_block65Bytes, _wl_block65);
  		    
		 if (pat_name_as_multipart_yn.equals("Y") )
		 {
			 String order = "";
			 int tabIndex = 20;
			 emptyCnt = 0;
			 for(int i=1;i<=4;++i)
			 {
				 tabIndex++; // To increase the tab order
				 //order = (String)Name_Order.get((new Integer(i)).toString());
				 if (Name_Order.get((new Integer(i)).toString()) != null)
							 order = (String)Name_Order.get((new Integer(i)).toString());
						 else
							 order = ""; 
				 if (order.equals("First_Name_Order"))
				 {
					if(First_Name_Accept_Yn.equals("Y")) 
					{ 
						out.println("<td     class='fields' width='25%' nowrap><input type='text' name='first_name_oth_lang' id='first_name_oth_lang' maxlength='"+first_name_length+"' size='"+first_name_length+"' onblur='makeValidString(this);putLocalLangPatientName(this);' tabIndex='"+tabIndex+"' ");

						
						if ( CalledFromFunction.equals("ChangePatDtls")  || !a_first_name_loc_lang.equals("")  )
						{
							if (!a_first_name_loc_lang.equals(""))
								out.print(" value=\""+a_first_name_loc_lang+"\">");
							else
							if(!(((String)hash_Map1.get("first_name_loc_lang")).equals("")))
								out.print(" value=\""+(String)hash_Map1.get("first_name_loc_lang") +"\">");
							else 
							 out.print(" value = \"\" >");
								
						} else out.print(" value = \"\" >");  
						
            _bw.write(_wl_block66Bytes, _wl_block66);

					}
					else
					{
						emptyCnt++;
					}
				 }
				 else
				 if (order.equals("Second_Name_Order"))
				 {
					if(Second_Name_Accept_Yn.equals("Y")) 
					{ 
						out.println("	<td     class='fields' width='25%' nowrap><input type='text' name='second_name_oth_lang' id='second_name_oth_lang' maxlength='"+second_name_length+"' size='"+second_name_length+"' onblur='makeValidString(this);putLocalLangPatientName(this);' tabIndex='"+tabIndex+"' ");

						
						if( CalledFromFunction.equals("ChangePatDtls") || !a_second_name_loc_lang.equals("")  )
						{
							if (!a_second_name_loc_lang.equals(""))
								out.print(" value = \""+a_second_name_loc_lang+"\" >");   
							else
							if (!(((String)hash_Map1.get("second_name_loc_lang")).equals("")))
								out.print(" value=\""+(String)hash_Map1.get("second_name_loc_lang") +"\">");
							else 
								out.print(" value = \"\" >");    
						}
						else out.print(" value = \"\" >");
						
            _bw.write(_wl_block67Bytes, _wl_block67);

					}
					else
					{
						emptyCnt++;
					}
				 }
				 else
				 if (order.equals("Third_Name_Order"))
				 {
					if(Third_Name_Accept_Yn.equals("Y")) 
					{ 
						out.println("<td     class='fields' width='25%' nowrap><input type='text' name='third_name_oth_lang' id='third_name_oth_lang' maxlength='"+third_name_length+"' size='"+third_name_length+"' onblur='makeValidString(this);putLocalLangPatientName(this);' tabIndex='"+tabIndex+"' ");

						if ( CalledFromFunction.equals("ChangePatDtls") || !a_third_name_loc_lang.equals("") )
						{
							if (!a_third_name_loc_lang.equals(""))
								out.print(" value = \""+a_third_name_loc_lang+"\" >");  
							else
							if(!(((String)hash_Map1.get("third_name_loc_lang")).equals("")))
								out.print(" value=\""+(String)hash_Map1.get("third_name_loc_lang")+"\">");
							else 
								out.print(" value = \"\" >");   
						} 
						else out.print(" value = \"\" >");
						
            _bw.write(_wl_block68Bytes, _wl_block68);

					}
					else
					{
						emptyCnt++;
					}
				 }
				 else
				 if (order.equals("Family_Name_Order"))
				 {
					if(Family_Name_Accept_Yn.equals("Y")) 
					{
						out.println("<td  class='fields' width='25%' nowrap><input type='text' name='family_name_oth_lang' id='family_name_oth_lang' maxlength='"+family_name_length+"' size='"+family_name_length+"' onblur='makeValidString(this);putLocalLangPatientName(this);' tabIndex='"+tabIndex+"'");

						
						if(CalledFromFunction.equals("ChangePatDtls") || !a_family_name_loc_lang.equals("") )
						{
							if (!a_family_name_loc_lang.equals(""))
								out.print(" value = \""+a_family_name_loc_lang+"\" >");  
							else
							if(!(((String)hash_Map1.get("family_name_loc_lang")).equals("")))
								out.print(" value=\""+(String)hash_Map1.get("family_name_loc_lang")+"\">");
							else
								out.print(" value = \"\" >");    
						}
						else out.print(" value = \"\" >"); 
					
            _bw.write(_wl_block69Bytes, _wl_block69);

				  }
				  else
				  {
				 	emptyCnt++;
				  }
			  }
			  else
			  {
				 emptyCnt++;
			  }
			}
		 }
		 /* if (pat_name_as_multipart_yn.equals("Y") ) */
			else
			{
			   if(Family_Name_Accept_Yn.equals("Y") ) 
			   {
				out.print("<td  class='fields' ><input type='text' name='family_name_oth_lang' id='family_name_oth_lang' maxlength='"+family_name_length+"' size='"+family_name_length+"' onblur='makeValidString(this);putLocalLangPatientName(this);' tabIndex='20' ");

					

				if ( CalledFromFunction.equals("ChangePatDtls") || !a_name_suffix_loc_lang.equals("")  )
				{
					if(!(((String)hash_Map1.get("family_name_loc_lang")).equals("")))
						out.print(" value=\""+(String)hash_Map1.get("family_name_loc_lang")+"\">");
					else out.print(" value = \"\" >");    
				} 
				else out.print(" value = \""+a_name_suffix_loc_lang+"\" >");    
				
            _bw.write(_wl_block70Bytes, _wl_block70);

			} 
		}

		 /*To fill the blank spaces in the table with blank TDs*/
			 for(int j=1;j<=emptyCnt;++j)
			   {
            _bw.write(_wl_block36Bytes, _wl_block36);
}
			
            _bw.write(_wl_block71Bytes, _wl_block71);
	
			if(CalledFromFunction.equals("PatientRegistration")) { 
            _bw.write(_wl_block72Bytes, _wl_block72);
 }
   }
   else if(language_direction.equals("R"))
		{

	   /*******Added for Arabic*********/

	   	   
            _bw.write(_wl_block39Bytes, _wl_block39);
		   



			/*If Multi Part Name is acceptable; Based on the name order in MP Param paint the prompts for names*/
		if (pat_name_as_multipart_yn.equals("Y") )
		{
			 String order = "";
			 /*Prompts and Names to be painted in Reverse Order for Local Lang*/
			 //for(int i=1;i<=4;++i)
			 for(int i=4;i>0;--i)
			 {
				 if (Name_Order.get((new Integer(i)).toString()) != null)
							 order = (String)Name_Order.get((new Integer(i)).toString());
						 else
							 order = ""; 

				 if (order.equals("Family_Name_Order"))
				 {
					if(Family_Name_Accept_Yn.equals("Y") ) 
					{
						
            _bw.write(_wl_block73Bytes, _wl_block73);

						if ((Family_Name_Reqd_Yn.equals("Y")) && pat_name_in_loc_lang_reqd_yn.equals("Y")) 
						{ 
							
            _bw.write(_wl_block56Bytes, _wl_block56);

						}
						else
						{
							
            _bw.write(_wl_block57Bytes, _wl_block57);

						}
						
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(family_name_loc_lang_prompt));
            _bw.write(_wl_block21Bytes, _wl_block21);


						temp = family_name_loc_lang_prompt.equals("&nbsp;") ? Family_Name_Prompt : family_name_loc_lang_prompt; 
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(temp));
            _bw.write(_wl_block59Bytes, _wl_block59);

					}
					else
					{
						emptyCnt++;
					}
				 }
				 else if (order.equals("Third_Name_Order"))
				 {
					  if(Third_Name_Accept_Yn.equals("Y")) 
					  { 
						
            _bw.write(_wl_block74Bytes, _wl_block74);
 
						if ((Third_Name_Reqd_Yn.equals("Y")) && pat_name_in_loc_lang_reqd_yn.equals("Y")) 
						{ 
							
            _bw.write(_wl_block51Bytes, _wl_block51);

						}
						else
						{
							
            _bw.write(_wl_block52Bytes, _wl_block52);

						}

						
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(third_name_loc_lang_prompt));
            _bw.write(_wl_block21Bytes, _wl_block21);


						temp = ((third_name_loc_lang_prompt).equals("&nbsp;")) ? Third_Name_Prompt:third_name_loc_lang_prompt; 
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(temp));
            _bw.write(_wl_block75Bytes, _wl_block75);

					}
					else
					{
						emptyCnt++;
					}
				 }
				 else if (order.equals("Second_Name_Order"))
				 {
					  if(Second_Name_Accept_Yn.equals("Y")) 
					  {
						
            _bw.write(_wl_block74Bytes, _wl_block74);

						if ((Second_Name_Reqd_Yn.equals("Y")) && pat_name_in_loc_lang_reqd_yn.equals("Y")) 
						{
							
            _bw.write(_wl_block47Bytes, _wl_block47);

						}
						else
						{ 
							
            _bw.write(_wl_block48Bytes, _wl_block48);

						}

						
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(second_name_loc_lang_prompt));
            _bw.write(_wl_block21Bytes, _wl_block21);


						temp = ((second_name_loc_lang_prompt).equals("&nbsp;")) ? Second_Name_Prompt:second_name_loc_lang_prompt; 
						
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(temp));
            _bw.write(_wl_block76Bytes, _wl_block76);

					}
					else
					{
						emptyCnt++;
					}
				 }
				 else  if (order.equals("First_Name_Order"))
				 {
					 if (First_Name_Accept_Yn.equals("Y")) 
					 { 
						
            _bw.write(_wl_block77Bytes, _wl_block77);

						if ( (First_Name_Reqd_Yn.equals("Y") ) && pat_name_in_loc_lang_reqd_yn.equals("Y")) 
						{ 
							
            _bw.write(_wl_block42Bytes, _wl_block42);

						}
						else
						{
							
            _bw.write(_wl_block43Bytes, _wl_block43);

						}

						
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(first_name_loc_lang_prompt));
            _bw.write(_wl_block21Bytes, _wl_block21);

						temp = ((first_name_loc_lang_prompt).equals("&nbsp;"))? First_Name_Prompt:first_name_loc_lang_prompt; 
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(temp));
            _bw.write(_wl_block78Bytes, _wl_block78);

					}
					else
					{
						emptyCnt++;
					}
				 }
				 else
			 {
				emptyCnt++;
			 }
  		  }
		}/* END of  if (pat_name_as_multipart_yn.equals("Y") )   */
		else
		{
		   if(Family_Name_Accept_Yn.equals("Y") ) 
			{
				
            _bw.write(_wl_block79Bytes, _wl_block79);

				if ( (Family_Name_Reqd_Yn.equals("Y")) && pat_name_in_loc_lang_reqd_yn.equals("Y"))
					{
					out.print("<input type='hidden' name='family_oth_name_reqd_yn' id='family_oth_name_reqd_yn' value='Y'></input><img id='fam_oth' src='../../eCommon/images/mandatory.gif' style='visibility:visible'></img>");
				} else { 
            _bw.write(_wl_block62Bytes, _wl_block62);
 }
			
				
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(family_name_loc_lang_prompt));
            _bw.write(_wl_block61Bytes, _wl_block61);

						temp = family_name_loc_lang_prompt.equals("&nbsp;")? Family_Name_Prompt:family_name_loc_lang_prompt ; 
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(temp));
            _bw.write(_wl_block63Bytes, _wl_block63);

			}
		}

		 	if(Name_Prefix_Accept_Yn.equals("Y")) 
		{ 
			
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(name_prefix_loc_lang_prompt));
            _bw.write(_wl_block81Bytes, _wl_block81);
 
			if( (Name_Prefix_Reqd_Yn.equals("Y")) && pat_name_in_loc_lang_reqd_yn.equals("Y"))
			{ 
				if(Name_Prefix_Reqd_Yn.equals("Y"))
				{
				
            _bw.write(_wl_block82Bytes, _wl_block82);

				}
				else
				{
				
            _bw.write(_wl_block83Bytes, _wl_block83);

				}	
				
            _bw.write(_wl_block84Bytes, _wl_block84);

			}
			else
			{ 
				
            _bw.write(_wl_block85Bytes, _wl_block85);

			}
			temp = ((name_prefix_loc_lang_prompt).equals("&nbsp;")) ? Name_Prefix_Prompt:name_prefix_loc_lang_prompt ;
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(temp));
            _bw.write(_wl_block87Bytes, _wl_block87);

		}
		else
		{ 
			
            _bw.write(_wl_block88Bytes, _wl_block88);
 
		}




	
		 /*To fill the blank spaces in the table with blank TDs*/
		 for(int j=1;j<=emptyCnt;++j)
		// for(int j=emptyCnt;j>0;--j)
			   {
            _bw.write(_wl_block64Bytes, _wl_block64);
}
		
            _bw.write(_wl_block65Bytes, _wl_block65);


			if(Name_Suffix_Accept_Yn.equals("Y")) 
			{	 
				 if(pat_name_as_multipart_yn.equals("N")) 
				{ 
					
            _bw.write(_wl_block89Bytes, _wl_block89);

				}
				else
				{ 
				  
            _bw.write(_wl_block90Bytes, _wl_block90);
}
				if(Name_Suffix_Reqd_Yn.equals("N")) 
				{
					out.print("<Option value=''>------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label" ,"common_labels")+"------</option>");
				} 
				array_List.clear();
				array_List = eMP.ChangePatientDetails.getResultRows(conn,"mp_name_suffix1",p);
				
				for(int i=0;i<array_List.size();i+=2) 
				{
					if(!((String)array_List.get(i)).equals("")) 
					{
						out.print("<Option value=\"" + (String)array_List.get(i) + "\" ");
						if ( CalledFromFunction.equals("ChangePatDtls")  || !a_name_suffix_loc_lang.equals("") )
						{
							if ( ((String)array_List.get(i)).equals((String)hash_Map1.get("name_suffix_loc_lang")) ||
							((String)array_List.get(i)).equals(a_name_suffix_loc_lang) )
								out.print(" selected > ");
							else out.print(" > "); 
						}
						else out.print(" > "); 
						out.print((String)array_List.get(i)+"</option>");
					} 
				}
			
			
            _bw.write(_wl_block91Bytes, _wl_block91);

			}
			else
			{	
			}

		if (pat_name_as_multipart_yn.equals("Y") )
		 {
			 String order = "";
			 int tabIndex = 20;
			 emptyCnt = 0;
			 //for(int i=1;i<=4;++i)
			for(int i=4;i>0;--i)
			 {
				 tabIndex++; // To increase the tab order
				 //order = (String)Name_Order.get((new Integer(i)).toString());
				 if (Name_Order.get((new Integer(i)).toString()) != null)
							 order = (String)Name_Order.get((new Integer(i)).toString());
						 else
							 order = ""; 

				 if (order.equals("Family_Name_Order"))
				 {
					if(Family_Name_Accept_Yn.equals("Y")) 
					{
						out.println("<td  class='arabic' ><input type='text' name='family_name_oth_lang' id='family_name_oth_lang' maxlength='"+family_name_length+"' size='"+family_name_length+"' onblur='makeValidString(this);putLocalLangPatientName(this)' tabIndex='23'");

						if(language_direction.equals("R"))
							{
							out.println( "dir='RTL' ");
							}

						if(CalledFromFunction.equals("ChangePatDtls") || !a_family_name_loc_lang.equals("") )
						{
							if (!a_family_name_loc_lang.equals(""))
								out.print(" value = \""+a_family_name_loc_lang+"\" >");  
							else
							if(!(((String)hash_Map1.get("family_name_loc_lang")).equals("")))
								out.print(" value=\""+(String)hash_Map1.get("family_name_loc_lang")+"\">");
							else
								out.print(" value = \"\" >");    
						}
						else out.print(" value = \"\" >"); 
					
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(name_comp_visibility));
            _bw.write(_wl_block93Bytes, _wl_block93);

				  }
				  else
				  {
				 	emptyCnt++;
				  }
			  }
			  else 	if (order.equals("Third_Name_Order"))
				 {
					if(Third_Name_Accept_Yn.equals("Y")) 
					{ 
						out.println("<td     class='arabic'><input type='text' name='third_name_oth_lang' id='third_name_oth_lang' maxlength='"+third_name_length+"' size='"+third_name_length+"' onblur='makeValidString(this);putLocalLangPatientName(this)' tabIndex='22' ");

						if(language_direction.equals("R"))
							{
							out.println( "dir='RTL' ");
							}

						if ( CalledFromFunction.equals("ChangePatDtls") || !a_third_name_loc_lang.equals("") )
						{
							if (!a_third_name_loc_lang.equals(""))
								out.print(" value = \""+a_third_name_loc_lang+"\" >");  
							else
							if(!(((String)hash_Map1.get("third_name_loc_lang")).equals("")))
								out.print(" value=\""+(String)hash_Map1.get("third_name_loc_lang")+"\">");
							else 
								out.print(" value = \"\" >");   
						} 
						else out.print(" value = \"\" >");
						
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(name_comp_visibility));
            _bw.write(_wl_block94Bytes, _wl_block94);

					}
					else
					{
						emptyCnt++;
					}
				 }
				 else if (order.equals("Second_Name_Order"))
				 {
					if(Second_Name_Accept_Yn.equals("Y")) 
					{ 
						out.println("	<td     class='arabic'><input type='text' name='second_name_oth_lang' id='second_name_oth_lang' maxlength='"+second_name_length+"' size='"+second_name_length+"' onblur='makeValidString(this);putLocalLangPatientName(this)' tabIndex='21' ");

						if(language_direction.equals("R"))
							{
							out.println( "dir='RTL' ");
							}

						if( CalledFromFunction.equals("ChangePatDtls") || !a_second_name_loc_lang.equals("")  )
						{
							if (!a_second_name_loc_lang.equals(""))
								out.print(" value = \""+a_second_name_loc_lang+"\" >");   
							else
							if (!(((String)hash_Map1.get("second_name_loc_lang")).equals("")))
								out.print(" value=\""+(String)hash_Map1.get("second_name_loc_lang") +"\">");
							else 
								out.print(" value = \"\" >");    
						}
						else out.print(" value = \"\" >");
						
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(name_comp_visibility));
            _bw.write(_wl_block96Bytes, _wl_block96);

					}
					else
					{
						emptyCnt++;
					}
				 }
				 else  if (order.equals("First_Name_Order"))
				 {
					if(First_Name_Accept_Yn.equals("Y")) 
					{ 
						out.println("<td     class='arabic'><input type='text' name='first_name_oth_lang' id='first_name_oth_lang' maxlength='"+first_name_length+"' size='"+first_name_length+"' onblur='makeValidString(this);putLocalLangPatientName(this)' tabIndex='20' ");

						if(language_direction.equals("R"))
							{
							out.println( "dir='RTL' ");
							}

						if ( CalledFromFunction.equals("ChangePatDtls")  || !a_first_name_loc_lang.equals("")  )
						{
							if (!a_first_name_loc_lang.equals(""))
								out.print(" value=\""+a_first_name_loc_lang+"\">");
							else
							if(!(((String)hash_Map1.get("first_name_loc_lang")).equals("")))
								out.print(" value=\""+(String)hash_Map1.get("first_name_loc_lang") +"\">");
							else 
							 out.print(" value = \"\" >");
								
						} else out.print(" value = \"\" >");  
						
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(name_comp_visibility));
            _bw.write(_wl_block97Bytes, _wl_block97);

					}
					else
					{
						emptyCnt++;
					}
				 }
				 else				
			  {
				 emptyCnt++;
			  }
			}
		 }
		 /* if (pat_name_as_multipart_yn.equals("Y") ) */
			else
			{
			   if(Family_Name_Accept_Yn.equals("Y") ) 
			   {
				out.print("<td  class='arabic' ><input type='text' name='family_name_oth_lang' id='family_name_oth_lang' maxlength='"+family_name_length+"' size='"+family_name_length+"' onblur='makeValidString(this);putLocalLangPatientName(this);' tabIndex='20' ");

					if(language_direction.equals("R"))
							{
							out.println( "dir='RTL' ");
							}

				if ( CalledFromFunction.equals("ChangePatDtls") || !a_name_suffix_loc_lang.equals("")  )
				{
					if(!(((String)hash_Map1.get("family_name_loc_lang")).equals("")))
						out.print(" value=\""+(String)hash_Map1.get("family_name_loc_lang")+"\">");
					else out.print(" value = \"\" >");    
				} 
				else out.print(" value = \""+a_name_suffix_loc_lang+"\" >");    
				
            _bw.write(_wl_block70Bytes, _wl_block70);

			} 
		}
	
			if(Name_Prefix_Accept_Yn.equals("Y")) 
			{
				if(pat_name_as_multipart_yn.equals("N")) 
				{ 
					
            _bw.write(_wl_block98Bytes, _wl_block98);

				}
				else
				{ 
					
            _bw.write(_wl_block99Bytes, _wl_block99);

				} 
				//if(Name_Prefix_Reqd_Yn.equals("N")) 
				//{ 
					
            _bw.write(_wl_block100Bytes, _wl_block100);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block101Bytes, _wl_block101);

				//} 									
				array_List.clear(); 
				array_List = eMP.ChangePatientDetails.getResultRows(conn,"mp_name_prefix1",p);
				for(int i=0;i<array_List.size();i+=2) 
				{ 
					if(!((String)array_List.get(i)).equals("")) 
					{
						out.print("<option  value=\""+(String)array_List.get(i)+"\"");
						if(CalledFromFunction.equals("ChangePatDtls")  || !a_name_prefix_loc_lang.equals("") ) {
						if ( ((String)array_List.get(i)).equals((String)hash_Map1.get("name_prefix_loc_lang")) ||
							((String)array_List.get(i)).equals(a_name_prefix_loc_lang) )
								out.print(" selected >" );
							else out.print(" > " );
						}
						else out.print(" > " );
						out.print((String)array_List.get(i)+"</option>");
						}
					} 
            _bw.write(_wl_block102Bytes, _wl_block102);
}
   		    
		 

	
		 /*To fill the blank spaces in the table with blank TDs*/
			 for(int j=1;j<=emptyCnt;++j)
			   {
            _bw.write(_wl_block36Bytes, _wl_block36);
}
			
            _bw.write(_wl_block71Bytes, _wl_block71);
	
			if(CalledFromFunction.equals("PatientRegistration")) { 
            _bw.write(_wl_block72Bytes, _wl_block72);
 }

		}
		/*******end for Arabic*********/
		}
		
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(language_direction));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(names_in_oth_lang_yn));
            _bw.write(_wl_block105Bytes, _wl_block105);


		
	}
	catch(Exception e)
	{
		System.out.println("Error in PatNamesComp.jsp file :"+e.toString()+"<br>") ;
		e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(conn,request);
	}
	
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block106Bytes, _wl_block106);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
}
