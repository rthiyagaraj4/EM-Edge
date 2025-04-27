package jsp_servlet._esm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __responsibilityforuserdetailform extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/esm/jsp/ResponsibilityforUserDetailForm.jsp", 1742365854397L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<head>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'></link>\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></SCRIPT>\n\t<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n\t<Script src=\"../../eSM/js/ResponsibilityforUser.js\" language=\"JavaScript\"></Script>\n    <script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'> </script> \n    \n\t\n\t<script>\n\n\n\t\tfunction validate_date(to_date,from_date)\n        {\n\t\t\tif(from_date.value&&to_date.value){\n\t\t\t\n \t\t\tif(!(isBefore(from_date.value,to_date.value,\"DMY\",localeName)))\n\t\t\t{\n\t\t\t\talert(getMessage(\'TO_DT_GR_EQ_FM_DT\',\'SM\'));\n\t\t\t\tto_date.select();\n\t\t\t}\n\t\t}\n         }\n\n\n\t\t function validate_date1(from_date,to_date)\n\t\t\t{\n\t\t\t\n\t\t\t\tif(to_date.value != \'\' && from_date.value!=\'\')\n\t\t\t\t{\n\t\t\t\tif(!(isBefore(from_date.value,to_date.value,\"DMY\",localeName)))\n\t\t\t\t{\n\t\t\t\t\talert(getMessage(\'TO_DT_GR_EQ_FM_DT\',\'SM\'));\n\t\t\t\t\tto_date.select();\n\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\n\tfunction submitPrevNext(from, to)\n\t{\n\t\t\t/*document.forms[0].from.value = from;\n\t\t\tdocument.forms[0].to.value = to; \n\t\t\tdocument.forms[0].submit();*/\n\t\t\teffected_records1(from,to);\n\t}\n\tvar flag=1;\t\n\t\tfunction DateValidation(obj,oldFromDt,index)\n\t\t{\n\t\t\t\tif(validDateObj(obj,\"DMY\",localeName))\n\t\t\t\t{\n\t\t\t\tObj2=eval(\"document.forms[0].\"+oldFromDt)\n\t\t\t\t// Added on 3/23/2005 to avoid the \"Date Cannot be blank\" alert when the user tries to delete the From Date field when the select box is unchecked for the existing records.\n\t\t\t\tvar selectCB = eval(\"document.forms[0].respID\" + index);\t\t\t\t\t\n\t\t\t\tif(selectCB.checked && Obj2.value.length>0 && obj.value.length == 0)\n\t\t\t\t\t{\n\t\t\t\t\n\t\t\t\t\tflag=0;\n\t\t\t\t\t}\n\t\t\t\telse{\n\t\t\t\tcurdate = document.forms[0].cur_date;\n\t\t\t\tvar msg = getMessage(\"FROM_DATE_LESS_SYSDATE\",\'SM\');\n\t\t\t\tif(!(isAfterNow(obj.value,\"DMY\",localeName)))\n\t\t\t\t{\n\t\t\t\t\tobj.focus();\n\t\t\t\t\tobj.select();\n\t\t\t\t\talert(msg);\n\t\t\t\t\tobj.value=\'\';\n\t\t\t\t\tobj.focus();\n\t\t\t\t\tobj.focus();\n\t\t\t\t\tobj.select();\n\t\t\t\t\t\n\t\t\t\t\tflag=0;\n\t\t\t\t}\n\t\t\t\telse flag=1;\n\t\t\t}\n\t\t}\n\t}\n\n\tfunction toFromValidate(Obj,Obj2)\n\t{\n\t\tif(validDateObj(Obj,\"DMY\",localeName))\n\t\t{\n\t\t\n\n\n\t\t\n\t\t\tcurdate = document.forms[0].cur_date;\n\t\t\tvar msg = getMessage(\"TO_DATE_LESS_SYSDATE\",\'SM\');\n\t\t\t\tif(!(isAfterNow(Obj.value,\"DMY\",localeName)))\n\t\t\t\t{\n\t\t\t\t\tObj.focus();\n\t\t\t\t\tObj.select();\n\t\t\t\t\talert(msg);\n\t\t\t\t\tObj.value=\'\';\n\t\t\t\t\tObj.focus();\n\t\t\t\t\tObj.select();\n\t\t\t\t\tflag=0;\n\t\t\t\t\tchk=0;\n\t\t\t\t}\n\t\t\t\telse{\n\t\t\t\t\tflag=1;\n\t\t\t\t\tchk=1;\n\t\t\t\t}\n\t\t\t\tif(chk){\n\t\t\t\n\t\tvar msg = getMessage(\"TO_DT_GR_EQ_FM_DT\",\'SM\');\t\t\n\t\t\t\t\tif(Obj2.value!=\'\'){\n\n\t\t\tif(!(isBefore(Obj2.value,Obj.value,\"DMY\",localeName))) \n\t\t\t{\n\t\t\t\t\n\t\t\t\tObj.focus();\n\t\t\t\tObj.select();\n\t\t\t\talert(msg);\n\t\t\t\tObj.value=\'\';\n\t\t\t\tObj.focus();\n\t\t\t\tObj.select();\n\t\t\t\t\t\n\t\t\t\tflag =0;\n\t\t\t}\n\t\t\telse\tflag =1;\n\t\t\t\t}\n\t\t\t\t}\n\t\t\n\t\t\n\t\t}\n\t}\n\tfunction sorts()\n\t{\n\t\tvar count =  \'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\';\n\t\tif(count==\"2\")\n\t\t{\n\t\t\tdocument.forms[0].sorting.value=\'desc\';\n\t\t\tdocument.forms[0].count.value=\'1\';\n\t\t}\n\t\telse\n\t\t{\n\t\t\tdocument.forms[0].sorting.value=\'\';\n\t\t\tdocument.forms[0].count.value = \'2\';\n\t\t}\n\t\tdocument.forms[0].submit();\n\t}\n\n\t\n\t</script>\n\t</head>\n\t<body  onKeyDown = \'lockKey();\'  OnMouseDown=\"CodeArrest()\">\n\t<form name=\'responsibility_form\' id=\'responsibility_form\' action=\'../../eSM/jsp/ResponsibilityforUserDetailForm.jsp\' method=\'post\' >\n\t\t<p>\t\n\t\t<table align=\'right\' id=\'titletb\'>\n\t\t\n\t\t<tr>\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t<td align =\'right\' id=\'prev\'><a  href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =",";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =")\' text-decoration=\'none\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</a></td>\n\t\t\n\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t<td align =\'right\' id=\'next\' style=\'visibility:hidden\'><a  href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</a></td>\n\n\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\n\t\t</tr>\n\t\t</table>\n\t\t<br>\n\t\t<br>\n\n\t<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' id=\'titletb1\'>\n\t<th width=\'55%\' style=\'cursor:pointer\' onclick=\'sorts();\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" </th>\n\t<th width=\'15%\' nowrap>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</th>\n\t<th width=\'10%\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</th>\n\t<th width=\'5%\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</th>\n\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\n\t\t\t\t<tr>\n\n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' >";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'old_eff_from";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' id=\'old_eff_from";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'  value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' >\n\t\t\t\t\t\t<input type=\'hidden\' name=\'diffinDate";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' id=\'diffinDate";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' >\n\t\t\t\t\t\t<input type=\'text\' id=\'eff_date_from";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' name=\'eff_date_from";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =" size=\'10\' onBlur=\"if (!this.readOnly) {DateValidation(this,\'old_eff_from";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\',\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\')};validate_date1(this,eff_date_to";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =");\"  value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'  maxlength=\'10\'>\n\t\t\t\t\t\t<input type=\'image\' src=\'../../eCommon/images/CommonCalendar.gif\' ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" onClick=\"document.getElementById(\'eff_date_from";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\').focus();return showCalendar(\'eff_date_from";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\');\">\n\t\t\t\t\t</td>\n\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<input type=\'text\' id=\'eff_date_to";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' name=\'eff_date_to";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' size=\'10\' \n\t\t\t       onBlur=\'toFromValidate(this,eff_date_from";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =");validate_date(this,eff_date_from";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =");\'  value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' maxlength=\'10\'>\n\t\t\t       \t\t<input type=\'image\'  src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"document.getElementById(\'eff_date_to";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\').focus();return  showCalendar(\'eff_date_to";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\');\">\n\t\t\t       \t\t<input type=\'hidden\' name=\'db_eff_date_to";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' id=\'db_eff_date_to";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' maxlength=\'10\'>\n\t\t\t       \t</td>\n\t\t\t\t\n\t\t\t\t\t<td align=\'center\' class=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' ><input type=\'checkbox\' ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =" name=\'respID";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'  id=\'respID";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' ><input type=\'hidden\'  name=\'db_respID";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' id=\'db_respID";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' ></td>\n\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n</table>\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t<script >\n\t\t\t\tif (document.getElementById(\'next\'))\n\t\t\t\t\tdocument.getElementById(\'next\').style.visibility=\'hidden\';\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\t<script >\n\t\t\t\tif (document.getElementById(\'next\'))\n\t\t\t\t\tdocument.getElementById(\'next\').style.visibility=\'visible\';\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t\t<td>\n\t\t\t\t\t<input type=\'hidden\' name=\'old_eff_from";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' >\n\t\t\t\t\t<input type=\'hidden\' name=\'diffinDate";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\'>\n\t\t\t\t\t<input type=\'text\' id=\'eff_date_from";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\'  maxlength=\'10\'>\n\t\t\t\t\t<input type=\'image\' src=\'../../eCommon/images/CommonCalendar.gif\' ";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\');\">\n\t\t\t\t\t</td>\n\n\t\t\t\t\t<td>\n\t\t\t\t\t<input type=\'text\' id=\'eff_date_to";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\' size=\'10\'  onBlur=\'toFromValidate(this,eff_date_from";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\'  maxlength=\'10\'>\n\t\t\t\t\t<input type=\'image\' src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"document.getElementById(\'eff_date_to";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\').focus();return showCalendar(\'eff_date_to";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\');\">\n\t\t\t\t\t<input type=\'hidden\' name=\'db_eff_date_to";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\'>\n\t\t\t\t\t</td>\n\n\t\t\t\t\t<td align=\'center\' class=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\' id=\'respID";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\' ></td>\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t<script >\n\t\t\t\tif (document.getElementById(\'next\'))\n\t\t\t\t\tdocument.getElementById(\'next\').style.visibility=\'visible\';\n\t\t\t\t</script>\n\n\n\t\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\t\n\t\t\n\t\t\t<input type=hidden name=from id=\'from\' value=\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\'>\n\t\t\t<input type=hidden name=to id=\'to\' value=\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\'>\n\t\t\t<input type=hidden name=\'start\' id=\'start\' value=\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\'>\n\t\t\t<input type=hidden name=\'end\' id=\'end\' value=\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\'>\n\t\t\t<input type=\'hidden\' name=\'userID\' id=\'userID\' value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\" >\n\t\t\t<input type=\'hidden\' name=\'sorting\' id=\'sorting\' value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\" >\n\t\t\t<input type=\'hidden\' name=\'count\' id=\'count\' value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" >\n\t\t\t<input type=\'hidden\' name=\'objname\' id=\'objname\' value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" >\n\t\t\t<input type=\'hidden\' name=\'searchresp\' id=\'searchresp\' value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\" >\n\t\t\t<input type=\'hidden\' name=\'scode\' id=\'scode\' value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\" >\n\t\t\t<input type=\'hidden\' name=\'searchcriteria\' id=\'searchcriteria\' value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\" >\n\t\t\t<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'cur_date\' id=\'cur_date\' value=\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\' >\n\t\t\t<input type=\'hidden\' name=\'old_eff_date_from\' id=\'old_eff_date_from\' value=\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\'>\n\t\t\t<input type=\'hidden\' name=\'old_eff_date_to\' id=\'old_eff_date_to\' value=\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\'>\n\t\t\t<input type=\'hidden\' name=\'insert_vals\' id=\'insert_vals\' value=\"\" >\n\t\t\t<input type=\'hidden\' name=\'update_vals\' id=\'update_vals\' value=\"\" >\n\t\t\t<input type=\'hidden\' name=\'delete_vals\' id=\'delete_vals\' value=\"\" >\n\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t</form>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

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

	String old_eff_date_from="";
   	String old_eff_date_to="";
	String redOnly = "";
	String diffinDate = "0";
	String disableFld = "";
	String upd_ind1 = "";
	 int cnt=0;
	Connection con=null;
	Statement stmt3=null;
	Statement stmt=null;
	ResultSet rset=null;
	ResultSet rset1=null;

	String classValue="";
	try{
		 request.setCharacterEncoding("UTF-8");
		con = ConnectionManager.getConnection(request);
		String userID="";
		String objname="";
		String searchresp="";
		String searchcriteria="";
		String whereclause="";
		String imagesrc="";
		String sorting=request.getParameter("sorting");
		if(sorting==null) sorting="";
		String count=request.getParameter("count");
		if(count==null) count="2";
		if(count.equals("2"))
			imagesrc = "../../eSM/images/Ascending.gif";
		else
			imagesrc = "../../eSM/images/Descending.gif";
		String from = request.getParameter("from") ;
		String to = request.getParameter("to") ;
		userID=request.getParameter("userID"); 
		objname=request.getParameter("objname");
		String tableheader = "";
		searchresp=request.getParameter("searchresp")==null?"":request.getParameter("searchresp");
		String scode = searchresp.toUpperCase();
		if(objname.equals("User"))
		{
			searchcriteria=request.getParameter("searchcriteria");
			
			if(searchcriteria.equals("S"))
			whereclause = "upper(resp_name) like upper('"+scode+"%') ";
			if(searchcriteria.equals("E"))
			whereclause = "upper(resp_name) like upper('%"+scode+"') ";
			if(searchcriteria.equals("C"))
			whereclause = "upper(resp_name) like upper('%"+scode+"%') ";
			tableheader = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ResponsibilityName.label","common_labels");
		}
		else if(objname.equals("Resp"))
		{
			searchcriteria=request.getParameter("searchcriteria");
			//out.println(scode);
			if(searchcriteria.equals("S"))
			whereclause = "upper(appl_user_name) like upper('"+scode+"%') ";
			if(searchcriteria.equals("E"))
			whereclause = "upper(appl_user_name) like upper('%"+scode+"') ";
			if(searchcriteria.equals("C"))
			whereclause = "upper(appl_user_name) like upper('%"+scode+"%') ";
			tableheader = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.username.label","common_labels");
		}
		int start = 0 ;
		int end = 0 ;
		int i=1;
			if (from == null){ start = 1 ;  }   else {  start = Integer.parseInt( from ) ; }
			if (to == null){ end = 10 ; }   else {  end = Integer.parseInt( to ) ; }
			String chkAttribute="";
			
			SimpleDateFormat dateFormat = new SimpleDateFormat( "dd/MM/yyyy" ) ;
			
	
		   
            _bw.write(_wl_block6Bytes, _wl_block6);

			i = 1 ;
		stmt=con.createStatement();
		if(rset1!=null) rset1.close();
		if(stmt!=null) stmt.close();
	
            _bw.write(_wl_block7Bytes, _wl_block7);

          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(count));
            _bw.write(_wl_block10Bytes, _wl_block10);

			if ( !(start <= 1)) {
		
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((start-10)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf((end-10)));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

			}
	//		if ( !((start+10) > maxRecord )){
		
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf((start+10)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf((end+10)));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

		//	}
		
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(tableheader));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

		String resp_id="";String fromDatVal="",toDatVal="";
		if(objname.equals("User"))
		{
		//String sqlUser="Select resp_id,resp_name from sm_resp where "+whereclause+"  eff_status='E'  and ( (trunc(eff_date_from) <= trunc(sysdate) and trunc(eff_date_to) >=  trunc(sysdate) )  or (trunc(eff_date_from) <= trunc(sysdate) and eff_date_to is null )  or (trunc(eff_date_to) >= trunc(sysdate) and  eff_date_from is null)  or (eff_date_from is null and eff_date_to is null)) order by upper(resp_name)"+sorting;
		String sqlUser="Select RESP_ID, RESP_NAME, To_Char(EFF_DATE_FROM,'dd/mm/yyyy') EFF_DATE_FROM, To_Char(EFF_DATE_TO,'dd/mm/yyyy') EFF_DATE_TO, upd_ind, trunc(sysdate)-trunc(eff_date_from) diffdate  from ( Select RESP_ID, RESP_NAME, EFF_DATE_FROM,EFF_DATE_TO, 'Y' upd_ind from SM_RESP_FOR_USER_VW where APPL_USER_ID = '"+userID+"'  UNION  Select  RESP_ID, RESP_NAME, NULL EFF_DATE_FROM, NULL EFF_DATE_TO, 'N' upd_ind from  sm_resp WHERE EFF_STATUS='E' AND  ( (trunc(eff_date_from) <= trunc(sysdate) and eff_date_to is null )  or (trunc(eff_date_to) >= trunc(sysdate) and eff_date_from is null)  or (eff_date_from is null and eff_date_to is null ) or (trunc(sysdate) between trunc(eff_date_from) and trunc(eff_date_to) and eff_date_from is not null and eff_date_to is not null)) and RESP_ID not in (Select RESP_ID FROM SM_RESP_FOR_USER_VW WHERE APPL_USER_ID = '"+userID+"') ) where "+whereclause+" order by  upper (RESP_NAME) "+sorting;
		stmt = con.createStatement();
		rset=stmt.executeQuery(sqlUser);
		if(rset!=null)
		{
			if ( start != 0 )
			{
			 for( int j=1; j<start; i++,j++ ){
			  rset.next() ;
			  }
			}

			
			 while(i<=end && rset.next())
			 {
				resp_id = rset.getString("resp_id");
				fromDatVal = rset.getString("eff_date_from");
				toDatVal = rset.getString("eff_date_to");
			
			if(fromDatVal == null)
				fromDatVal="";

			if(toDatVal == null)
				toDatVal="";

			String upd_ind = rset.getString("upd_ind");
			if(upd_ind.equals("Y"))
			 {
				chkAttribute = "CHECKED";
				upd_ind1="true";
			 }
			 else
			 {
				chkAttribute = "";
				upd_ind1="false";
			 }
			 diffinDate = rset.getString("diffdate");
			if (diffinDate==null || diffinDate.equals("") || Integer.parseInt(diffinDate) < 0) diffinDate = "0"; 
					
				if((i%2) == 1)
					classValue = "QRYODD";
				else
					classValue ="QRYEVEN";
				
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(rset.getString("resp_name")));
            _bw.write(_wl_block24Bytes, _wl_block24);
if (Integer.parseInt(diffinDate) >0)
					{
					redOnly = "readonly";
					disableFld = "disabled";
					}
				else
					{
					redOnly = "";
					disableFld = "";
					}
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(fromDatVal));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(diffinDate));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(redOnly));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(DateUtils.convertDate(fromDatVal,"DMY","en",localeName)));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(disableFld));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(DateUtils.convertDate(toDatVal,"DMY","en",localeName)));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(toDatVal));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(chkAttribute));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(resp_id));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(upd_ind1));
            _bw.write(_wl_block56Bytes, _wl_block56);

				i++;
				cnt++;
			}

            _bw.write(_wl_block57Bytes, _wl_block57);
	
			if (cnt==0)
			{
				out.println("<script>document.getElementById(\"titletb\").style.visibility='hidden';document.getElementById(\"titletb1\").style.visibility='hidden';alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
				
			}
			boolean flag = false;
			if ( cnt < 10 || (!rset.next()) ) {
			
            _bw.write(_wl_block58Bytes, _wl_block58);
 flag = true;
					} else {
            _bw.write(_wl_block59Bytes, _wl_block59);
}
		if(rset!=null) rset.close();
		if(stmt!=null) stmt.close();
		}
	 }
	 else if(objname.equals("Resp"))
	{
		//String sqlUser="select appl_user_name, appl_user_id from sm_appl_user  where  "+whereclause+" eff_status='E'and ( (trunc(eff_date_from) <= trunc(sysdate) and eff_date_to is null )  or (trunc(eff_date_to) >= trunc(sysdate) and eff_date_from is null)  or (eff_date_from is null and eff_date_to is null ) or (trunc(sysdate) between trunc(eff_date_from)  and trunc(eff_date_to) and eff_date_from is not null and eff_date_to is not null))order by upper(appl_user_name)"+sorting;

		String sqlUser="Select APPL_USER_ID, APPL_USER_NAME, To_Char(EFF_DATE_FROM,'dd/mm/yyyy') EFF_DATE_FROM, To_Char(EFF_DATE_TO,'dd/mm/yyyy') EFF_DATE_TO, upd_ind , trunc(sysdate)-trunc(eff_date_from) diffdate  from ( Select APPL_USER_ID, APPL_USER_NAME, EFF_DATE_FROM,EFF_DATE_TO, 'Y' upd_ind from SM_RESP_FOR_USER_VW where RESP_ID = '"+userID+"' UNION   Select  APPL_USER_ID, APPL_USER_NAME, NULL EFF_DATE_FROM, NULL EFF_DATE_TO, 'N' upd_ind from  sm_appl_user WHERE EFF_STATUS='E' AND  ( (trunc(eff_date_from) <= trunc(sysdate) and eff_date_to is null )  or (trunc(eff_date_to) >= trunc(sysdate) and eff_date_from is null)  or (eff_date_from is null and eff_date_to is null ) or (trunc(sysdate) between trunc(eff_date_from) and trunc(eff_date_to) and eff_date_from is not null and eff_date_to is not null)) and APPL_USER_ID not in (Select APPL_USER_ID FROM SM_RESP_FOR_USER_VW WHERE RESP_ID = '"+userID+"') ) where "+whereclause+" order by  upper (APPL_USER_NAME)"+sorting;
		stmt = con.createStatement();
		rset=stmt.executeQuery(sqlUser);
		if(rset!=null)
		{
			if ( start != 0 )
			{
			 for( int j=1; j<start; i++,j++ ){
			  rset.next() ;
			  }
			}
			cnt=0;
			 
			 while( i<=end && rset.next())
			 {
				resp_id = rset.getString("APPL_USER_ID");
				fromDatVal = rset.getString("eff_date_from");
				toDatVal = rset.getString("eff_date_to");
				if(fromDatVal == null)
					fromDatVal = "";
				if(toDatVal == null)
					toDatVal = "";

				String upd_ind = rset.getString("upd_ind");
				if(upd_ind.equals("Y"))
				 {
					chkAttribute = "CHECKED";
					upd_ind1="true";
				 }
				 else
				 {
					chkAttribute = "";
					upd_ind1="false";
				 }
				 diffinDate = rset.getString("diffdate");
				 if (diffinDate==null || diffinDate.equals("") || Integer.parseInt(diffinDate) < 0) diffinDate = "0"; 
			
				if((i%2) == 1)
					classValue = "QRYODD";
				else
					classValue ="QRYEVEN";
				
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(rset.getString("appl_user_name")));
            _bw.write(_wl_block24Bytes, _wl_block24);

					if (Integer.parseInt(diffinDate) >0)
					{
					redOnly = "readonly";
					disableFld = "disabled";
					}
				else
					{
					redOnly = "";
					disableFld = "";
					}
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(fromDatVal));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(diffinDate));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(redOnly));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(DateUtils.convertDate(fromDatVal,"DMY","en",localeName)));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(disableFld));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(DateUtils.convertDate(toDatVal,"DMY","en",localeName)));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(i));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(i));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(i));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(toDatVal));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(chkAttribute));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(resp_id));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(upd_ind1));
            _bw.write(_wl_block71Bytes, _wl_block71);

				i++;
				cnt++;
			}

            _bw.write(_wl_block57Bytes, _wl_block57);
			if (cnt==0)
			{
				out.println("<script>document.getElementById(\"titletb\").style.visibility='hidden';document.getElementById(\"titletb1\").style.visibility='hidden';alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
			}
			boolean flag = false;
			if ( cnt < 10 || (!rset.next()) ) {
			
            _bw.write(_wl_block58Bytes, _wl_block58);
 flag = true;
					} else {
            _bw.write(_wl_block72Bytes, _wl_block72);
}

		if(rset!=null) rset.close();
		if(stmt!=null) stmt.close();
		}
	 }
	//}
	
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(start));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(end));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(start));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(end));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(userID));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(sorting));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(count));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(objname));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(searchresp));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(scode));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(searchcriteria));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(dateFormat.format( new java.util.Date() ) ));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(old_eff_date_from));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(old_eff_date_to));
            _bw.write(_wl_block87Bytes, _wl_block87);
	}catch(Exception e){
				out.println(e);
				e.printStackTrace();
				}
				finally {
					if(stmt!=null) stmt.close();
				if(stmt3!=null) stmt3.close();
		ConnectionManager.returnConnection(con,request);
	}	
	
            _bw.write(_wl_block88Bytes, _wl_block88);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EffectiveFrom.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EffectiveTo.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
}
