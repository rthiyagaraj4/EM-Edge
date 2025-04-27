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
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __facilityforuserdetailform extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/esm/jsp/FacilityforUserDetailForm.jsp", 1742358719164L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n";
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

    private final static java.lang.String  _wl_block6 ="\n\n       ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<head>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></SCRIPT>\n<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'> </script>\n<script language=\'javascript\' src=\'../../eSM/js/FacilitiesForUser.js\'> </script>\n<script>\n\tfunction submitPrevNext(from, to,searchText,label){\n\t  /*  document.forms[0].from.value = from;\n\t    document.forms[0].to.value = to; \n\t\tdocument.responsibility_form.label.value = label; \n\t\tdocument.responsibility_form.searchText.value = searchText; \n\n\t    document.forms[0].submit();*/\n\t\t\n\t\teffected_records1(from,to);\n\t}\n\t\n\tasync function getComments(Obj,comments)\n\t{\n\t\tvar url\t\t= \"../../eSM/jsp/GetComments.jsp\";\n\t\tvar dialogTop\t= \"270\";\n\t\tvar dialogHeight= \"150px\" ; \n\t\tvar dialogWidth\t= \"380px\" ;\t\n\t\tvar dialogLeft\t= \"300\" ;\n\t\tvar arguments\t= eval(\"document.forms[0].\"+comments).value;\n\t\tif(arguments == null) arguments=\"\";\n\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; dialogTop:\" + dialogTop + \"; status: no; dialogLeft: \"+dialogLeft ;\n\t\tvar returnval = await window.showModalDialog( url, arguments, features ) ;\t\n\t\t\n\t\tif(returnval == null) returnval=\"\";\n\t\teval(\"document.forms[0].\"+comments).value = returnval;\n\t}\n\nvar flag=1;\t\nfunction DateValidation(obj,oldFromDt)\n\t{\n\t\tif(obj.value!=\'\')\n\t\t{\n\t\t\tif(validDateObj(obj,\"DMY\",localeName))\n\t\t\t{\n\t\t\t    Obj2=eval(\"document.forms[0].\"+oldFromDt)\n\t\t\t\tif(Obj2.value.length>0 && obj.value.length == 0)\n\t\t\t\t{\n\t\t\t\talert(getMessage(\"FROM_DATE_CANNOT_BE_BLANK\",\"SM\"));\n\t\t\t\tobj.value=\'\';\n\t\t\t\tobj.focus();\n\t\t\t\tobj.select();\n\t\t\t\tflag=0;\n\t\t\t}\n\t\t\telse{\n\t\t\tvar msg = getMessage(\"FROM_DATE_LESS_SYSDATE\",\"SM\");\n\t\t\tif (obj.value != oldFromDt)\n\t\t\t{\n\t\t\t\tif(!(isAfterNow(obj.value,\"DMY\",localeName)))\n\t            {\n\t\t\t\t\tobj.focus(); \n\t\t\t\t\tobj.select();\n\t\t\t\t\tobj.value=\'\';\n\t\t\t\t\talert(msg);\n\t            }\n\t\t\t\telse flag=1;\n\t\t\t}\n\t\t}\n\t }\n\t}\n}\nfunction toFromValidate(Obj,Obj2)\n{\n\n\tif(validDateObj(Obj2,\"DMY\",localeName))\n{\n\tvar msg = getMessage(\"TO_DATE_LESS_SYSDATE\",\"SM\");\n\tif(Obj2.value!=\'\'){\n\t\tif(!(isAfterNow(Obj2.value,\"DMY\",localeName)))\n\t\t{\n\t\t\tObj2.focus();\n\t\t\tObj2.select();\n\t\t\talert(msg);\n\t\t\tObj2.value=\'\';\n\t\t\treturn;\n\t\t}\n\t\telse flag=1;\n\t}\n\tif(validDateObj(Obj,\"DMY\",localeName))\n\t{\n\t     var msg = getMessage(\"TO_DT_GR_EQ_FM_DT\",\"SM\");\n\n\t\t\t\t\t\t\tif(Obj.value!=\"\" && Obj2.value!=\"\")\n\t\t\t\t\t{\n\t\t\t\t\t\t\t if(!(isBefore(Obj.value,Obj2.value,\"DMY\",localeName)))\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t    alert(getMessage(\"TO_DT_GR_EQ_FM_DT\",\"SM\"));\n\t\t\t\t\t\t\t\t\t    Obj2.value=\'\';\n\t\t\t\t\t\t\t\t\t\tObj2.select();\n\t\t\t\t\t\t\t\t\t\tObj2.focus();\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t}\t\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\n\n\t}\n}\n\n</script>\n</head>\n<body   onKeyDown = \'lockKey()\';  OnMouseDown=\"CodeArrest()\">\n<form name=\'responsibility_form\' id=\'responsibility_form\' action=\'../../eSM/jsp/FacilityforUserDetailForm.jsp\' method=\'post\' >\n\t<p>\n\t<table align=\'right\'>\n\t<tr>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t    <td align =\'right\' id=\'prev\'><a href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =",";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =",\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\",\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\")\' text-decoration=\'none\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</a></td>\n\t\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t   <td align =\'right\' id=\'next\' style=\'visibility:hidden\'> <a href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</a></td>\n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\n\t\t</tr>\n\t\t</table>\n\t\t<br>\n\t\t<br>\n\n\t\n<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\'>\n<th width=\'55%\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</th>\n<th width=\'15%\' nowrap>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</th>\n<th width=\'10%\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</th>\n<th width=\'15%\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</th>\n<th width=\'5%\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</th>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t<tr>\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' >";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t<td><input type=\'hidden\' name=\'old_eff_from";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' id=\'old_eff_from";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' ><input type=\'hidden\' name=\'diffinDate";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' id=\'diffinDate";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' ><input type=\'text\' id=\'eff_date_from";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'  name=\'eff_date_from";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' size=\'10\' ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" onBlur=\"if (!this.readOnly) { DateValidation(this,\'old_eff_from";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\');toFromValidate(this,eff_date_to";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =")}\" value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'  maxlength=\'10\'><input type=\'image\' src=\'../../eCommon/images/CommonCalendar.gif\' ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" onClick=\"document.getElementById(\'eff_date_from";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\').focus();return showCalendar(\'eff_date_from";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\');\"></td>\n\t\t\t\n\t\t\t\t<td><input type=\'text\' id=\'eff_date_to";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' name=\'eff_date_to";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' size=\'10\'  onBlur=\"toFromValidate(eff_date_from";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =",this)\"   value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'  maxlength=\'10\'><input type=\'image\' src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"document.getElementById(\'eff_date_to";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\').focus();return showCalendar(\'eff_date_to";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\');\"><input type=\'hidden\'  name=\'db_eff_date_to";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' id=\'db_eff_date_to";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'   value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'></td>\n\t\t\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' ><input type=\'hidden\' name=\'comments";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' id=\'comments";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'><input type=\'hidden\' name=\'db_comments";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' id=\'db_comments";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'>\n\t\t\t\t\t<a href=javaScript:getComments(this,\'comments";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\')>";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</a></td>\n\t\t\t\t\t\n\t\t\t\t<td align=\'center\' class=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' ><input type=\'checkbox\' ";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 =" name=\'facilityID";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\'  id=\'facilityID";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' ><input type=\'hidden\' name=\'db_facilityID";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' id=\'db_facilityID";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\'  value=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\' ></td>\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t<script >\n\t\tif (document.getElementById(\'next\'))\n\t\t\tdocument.getElementById(\'next\').style.visibility=\'hidden\';\n\t\t</script>\n\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t<script >\n\t\tif (document.getElementById(\'next\'))\n\t\t\tdocument.getElementById(\'next\').style.visibility=\'visible\';\n\t\t</script>\n\n\n\n\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\t\n\t</table>\n\t\t<input type=hidden name=from id=\'from\' value=\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\'>\n\t\t<input type=hidden name=to id=\'to\' value=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\'>\n\t\t<input type=hidden name=\'start\' id=\'start\' value=\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\'>\n\t\t<input type=hidden name=\'end\' id=\'end\' value=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\'>\n\t\t<input type=\'hidden\' name=\'userID\' id=\'userID\' value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\" >\n\t\t<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'label\' id=\'label\' value=\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\'>\n\t    <input type=\'hidden\' name=\'label1\' id=\'label1\' value=\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\'>\n\t\t<!--<input type=\'hidden\' name=\'searchText\' id=\'searchText\' value=\'\'>-->\n\t\t<input type=\'hidden\' name=\'searchText\' id=\'searchText\' value=\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\'>\n\t\t<input type=\'hidden\' name=\'operation\' id=\'operation\' value=\'split\'>\n\t\t<input type=\'hidden\' name=\'cur_date\' id=\'cur_date\' value=\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\' >\n\t\t<input type=\'hidden\' name=\'old_eff_date_from\' id=\'old_eff_date_from\' value=\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\'>\n\t\t<input type=\'hidden\' name=\'old_eff_date_to\' id=\'old_eff_date_to\' value=\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\'>\n\t\t<input type=\'hidden\' name=\'filter\' id=\'filter\' value=\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\'>\n\t\t<input type=\'hidden\' name=\'insert_vals\' id=\'insert_vals\' value=\"\" >\n\t\t<input type=\'hidden\' name=\'update_vals\' id=\'update_vals\' value=\"\" >\n\t\t<input type=\'hidden\' name=\'delete_vals\' id=\'delete_vals\' value=\"\" >\n\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t</form>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

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
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String label1="";
	String old_eff_date_from="";
   	String old_eff_date_to="";
//	String diffdate = "";
	String redOnly = "";
	String diffinDate = "0";
	String disableFld = "";
	String upd_ind1 = "";
	String operation=request.getParameter("operation")==null ? "" :request.getParameter("operation");
	String searchText =request.getParameter("searchText")==null ? "" :request.getParameter("searchText");
	String filterCondition =request.getParameter("filter")==null ? "" :request.getParameter("filter");
	String searchText1=searchText;
    
   if(operation.equals("")){
	if(!searchText.equals(""))
	{
		//searchText = searchText + "%";
		if(filterCondition.equals("S"))
		{
			searchText = searchText + "%";
		}
		else if(filterCondition.equals("C"))
		{
			searchText ="%" + searchText + "%";
		}
		else if(filterCondition.equals("E"))
		{
			searchText ="%" + searchText;
		}
	}
	else
	{
		searchText = "%";
	}
 }

	Connection con=null;
//	Statement stmt3=null;

	Statement stmt=null;
	int cnt=0;

	String classValue="";
	try{
    con = ConnectionManager.getConnection(request);
	
//	ResultSet rset3=null ;
	
	
	String userID="";
	userID=request.getParameter("userID")==null ? "" : request.getParameter("userID");
	String from = request.getParameter("from") ;
	String to = request.getParameter("to") ;
	String label = request.getParameter("label") == null ? "" :request.getParameter("label");
	
	

//	int maxRecord = 0;
	int start = 0 ;
	int end = 0 ;
	int i=1;
        if (from == null){ start = 1 ;  }   else {  start = Integer.parseInt( from ) ; }
        if (to == null){ end = 11 ; }   else {  end = Integer.parseInt( to ) ; }
        
        String chkAttribute="";
        
//        String  req_start   =   "", req_end     =   "";
//        String  checkedOnes         =   "",checkedRemarks="",checkedFrDate="",checkedToDate="";
        SimpleDateFormat dateFormat = new SimpleDateFormat( "dd/MM/yyyy" ) ;
        

	
				
            _bw.write(_wl_block6Bytes, _wl_block6);
// }
        i = 1 ;
        
	ResultSet rset=null ;
	ResultSet rset1=null ;
	
	
	

   
		if(rset1!=null)rset1.close();
		if(stmt!=null)stmt.close();
	  

	
	//}


          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	    if ( !(start <= 1)) {
	
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf((start-11)));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf((end-11)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(java.net.URLEncoder.encode(searchText)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(label));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

	    }
	//    if ( !((start+11) > maxRecord )){
	
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf((start+11)));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf((end+11)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(java.net.URLEncoder.encode(searchText)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(label));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

	//    }
	
            _bw.write(_wl_block17Bytes, _wl_block17);
if(label.equals(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.user.label","common_labels"))){
	out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.facility.label","common_labels"));
    label1="User";
}
else
{
	out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.user.label","common_labels"));
  label1="Facility";
}
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

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

	String facility_id="";String commentVal="",fromDatVal="",toDatVal="";
	String sqlUser="";
	

	if(!label.equals(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.user.label","common_labels"))){
	//sqlUser="SELECT    appl_user_id,appl_user_name     FROM sm_appl_user WHERE eff_status = 'E' and upper(appl_user_name) like upper('"+searchText+"')  AND  ((eff_date_from <= TRUNC (SYSDATE)  AND eff_date_to >= TRUNC (SYSDATE)  )  OR (eff_date_to >= TRUNC (SYSDATE) AND eff_date_from IS NULL)  OR (eff_date_from IS NULL or eff_date_to IS NULL)) ORDER BY appl_user_name  ";
	sqlUser="SELECT APPL_USER_ID , APPL_USER_NAME ,TO_CHAR(EFF_DATE_FROM,'dd/mm/yyyy') EFF_DATE_FROM , TO_CHAR(EFF_DATE_TO,'dd/mm/yyyy') EFF_DATE_TO , remarks , upd_ind FROM ( SELECT APPL_USER_ID , APPL_USER_NAME ,ACCESS_EFF_DATE_FROM EFF_DATE_FROM ,ACCESS_EFF_DATE_TO EFF_DATE_TO ,REMARKS, 'Y' upd_ind  FROM SM_FACILITY_FOR_USER_VW WHERE FACILITY_ID = '"+userID+"' UNION SELECT APPL_USER_ID , APPL_USER_NAME , NULL EFF_DATE_FROM , NULL EFF_DATE_TO , NULL remarks , 'N' upd_ind FROM sm_appl_user WHERE EFF_STATUS='E' AND APPL_USER_ID not IN ( SELECT APPL_USER_ID FROM SM_FACILITY_FOR_USER_VW WHERE FACILITY_ID = '"+userID+"' ) ) where upper(APPL_USER_NAME) like upper('"+searchText+"') ORDER BY  upper(APPL_USER_NAME)";
     
	}
else
	{
	//sqlUser=" select facility_id,facility_name from sm_facility_param where upper(facility_name) like upper('"+searchText+"') order by facility_name ";

	sqlUser="SELECT FACILITY_ID , FACILITY_NAME,TO_CHAR(EFF_DATE_FROM,'dd/mm/yyyy') EFF_DATE_FROM , TO_CHAR(EFF_DATE_TO,'dd/mm/yyyy') EFF_DATE_TO , upd_ind,remarks FROM ( SELECT FACILITY_ID , FACILITY_NAME ,ACCESS_EFF_DATE_FROM EFF_DATE_FROM ,ACCESS_EFF_DATE_TO EFF_DATE_TO , 'Y' upd_ind, remarks FROM SM_FACILITY_FOR_USER_VW WHERE APPL_USER_ID = '"+userID+"' UNION SELECT FACILITY_ID , FACILITY_NAME , NULL EFF_DATE_FROM , NULL EFF_DATE_TO , 'N' upd_ind, null remarks FROM sm_facility_param WHERE STATUS='E' AND FACILITY_ID not IN ( SELECT FACILITY_ID FROM SM_FACILITY_FOR_USER_VW WHERE APPL_USER_ID = '"+userID+"' ) ) where upper(FACILITY_NAME) like upper('"+searchText+"') ORDER BY upper (FACILITY_NAME)   ";
	}

     	stmt=con.createStatement();	
	rset=stmt.executeQuery(sqlUser);
	
	if(rset!=null)
	{
		if ( start != 0 )
		{
		 for( int j=1; j<start; i++,j++ ){
		  rset.next() ;
		  }
		}
		
		 while(rset.next() && i<=end )
		 {
			
			facility_id = rset.getString(1);
			fromDatVal = rset.getString("eff_date_from");
			toDatVal = rset.getString("eff_date_to");
			commentVal = rset.getString("remarks");

			if(commentVal == null)
				commentVal= "";

			if(fromDatVal == null)
				fromDatVal= "";

			if(toDatVal == null)
				toDatVal= "";

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
		/*	if(facForUser.containsObject(facility_id)) {
				chkAttribute = "CHECKED";
			}
			else
			chkAttribute="";
			
			int recordIndex = facForUser.indexOfObject(facility_id);
			if(recordIndex!=-1)
			{
			if(chkAttribute.equals("CHECKED")) 
				{ 
				facForUser.removeObject(recordIndex);
				commentVal = (String)facForUserRemarks.getObject(recordIndex);
				facForUserRemarks.removeObject(recordIndex);
				fromDatVal=(String)facForUserFromDate.getObject(recordIndex);
				facForUserFromDate.removeObject(recordIndex);
				toDatVal=(String)facForUserToDate.getObject(recordIndex);
				facForUserToDate.removeObject(recordIndex);
                diffinDate = (String) diffBean.getObject(recordIndex);
				if (diffinDate==null || diffinDate.equals("") || Integer.parseInt(diffinDate) < 0) diffinDate = "0";
				diffBean.removeObject(recordIndex);	
				}
			}
			else
			{
				commentVal="";
				fromDatVal="";
				toDatVal="";
			}*/
	
			if((i%2) == 1)
				classValue = "QRYODD";
			else
				classValue ="QRYEVEN";
			
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(rset.getString(2)));
            _bw.write(_wl_block25Bytes, _wl_block25);

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
			
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(fromDatVal));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(diffinDate));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(redOnly));
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
            out.print( String.valueOf(DateUtils.convertDate(toDatVal,"DMY","en",localeName)));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(toDatVal));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(commentVal));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(commentVal));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(chkAttribute));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(i));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(upd_ind1));
            _bw.write(_wl_block63Bytes, _wl_block63);

			i++;
			cnt++;
		}

	}
	if (cnt==0)
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));parent.frames[2].document.location.href='../../eCommon/html/blank.html'</script>");
	}
	boolean flag = false;
	if ( cnt < 10 || (!rset.next()) ) {
	
            _bw.write(_wl_block64Bytes, _wl_block64);
 flag = true;
			} else {
            _bw.write(_wl_block65Bytes, _wl_block65);
}
	if(rset!=null)rset.close();
	if(stmt!=null)stmt.close();

            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(start));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(end));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(start));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(end));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(userID));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(label));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(label1));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(searchText1));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(dateFormat.format( new java.util.Date() ) ));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(old_eff_date_from));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(old_eff_date_to));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(filterCondition));
            _bw.write(_wl_block78Bytes, _wl_block78);
			if(stmt!=null) stmt.close();
					
	  }catch(Exception e){out.println(e);
	  e.printStackTrace();}

	finally {
					
		ConnectionManager.returnConnection(con,request);
	/*	session.setAttribute("facForUser", facForUser);
		session.setAttribute("facForUserRemarks", facForUserRemarks);
		session.setAttribute("facForUserFromDate", facForUserFromDate);
		session.setAttribute("facForUserToDate", facForUserToDate);
		session.setAttribute("diffBean", diffBean);*/
	}	
	
            _bw.write(_wl_block79Bytes, _wl_block79);
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
