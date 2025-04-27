package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import eCommon.Common.*;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __operationsproceduresaddmodify extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/OperationsProceduresAddModify.jsp", 1732945704000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'/>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script language=\'javascript\' src=\'../../eOT/js/OperationsProcedures.js\'></script>\n<script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\nvar subCategory=getLabel(\"eOT.SubCategory.Label\",\"OT\");\nvar category=getLabel(\"Common.category1.label\",\"common\");\nvar checklist=getLabel(\"eOT.Checklist.Label\",\"OT\");\nvar orderCatalog=getLabel(\"Common.ordercatalog.label\",\"common\");\nvar operationType=getLabel(\"eOT.OperationType.Label\",\"OT\");\nvar swabandInstrumentCount=getLabel(\"eOT.SwabandInstrumentCount.Label\",\"OT\");\nfunction oper_type_validate(obj,oper_type_code,oper_type_desc){\n\tif(obj.value!=\'\' && obj.value!=null)\n\t\tsearchlkp(\'Operation Type Search\',operationType,oper_type_code,oper_type_desc); \n\telse\n\t\toper_type_code=\"\";\n}\nfunction butdisable(){\nif (parent.commontoolbarFrame.document.forms[0].apply.disabled==true)\n{\n\tparent.commontoolbarFrame.document.forms[0].apply.disabled=false;\n} else {\n\treturn false;\n\t}\n}\n</script>\n<style>\ntextarea {\n  resize: none;\n}\n</style>\n</head>\n\n<!--body onload=\"butdisable()\" OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'-->\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'> <!--Modified Against GHL-SCF-1519-->\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<form name=\"OperProcForm\" id=\"OperProcForm\"  onload=\'FocusFirstElement(); \'  action=\"../../servlet/eOT.OperationsProceduresServlet\" method=\"post\" target=\"messageFrame\"> \n\n<table border=0 align=\'center\' cellspacing=0 cellpadding=3 width=\'100%\'  >\n\n<tr>\n\t<td class=label width=\'25%\' >\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t</td>\n\t<td width=\'25%\' class=\"fields\" colspan=\"3\">\n\t\t<input style=\"text-transform:uppercase\" type=\"text\" name=\"speciality_desc\" id=\"speciality_desc\" ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"  size=\'25\' maxlength=\"60\" onBlur=\"if(this.value!=\'\')searchSpeciality(speciality_desc,speciality_code);else clearValues();\"><input type=\"button\" class=\"button\" ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" value=\"?\" name=\"splty\" onClick=\"searchSpeciality(speciality_desc,speciality_code);searchOrderType(speciality_desc);\" ><img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t<input type=\'hidden\' name=\'speciality_code\' id=\'speciality_code\'  value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n\t</td>\n</tr>\n<tr>\n\t<td width=\"25%\" class=\"label\" nowrap>\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" \n\t</td>\n\t<td width=\'25%\' class=\"fields\" colspan=\"3\">\n\t<!--\n\t\t\t\t<select name=\"diag_code_scheme\" id=\"diag_code_scheme\" value=\"\" > \n\t\t\t\t<option value=\"1\" >\n\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" \n\t\t\t\t</option>\n\t\t\t\t<option value=\"2\" >\n\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" \n\t\t\t\t</option>\n\t\t\t\t<option value=\"3\" >\n\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" \n\t\t\t\t</option>\n\t\t\t\t<option value=\"4\" >\n\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" \n\t\t\t\t</option>\t\t\n\t\t\t  </select>\n\t-->\n\n\t\t<input type=\"hidden\" name=\"diag_code_scheme\" id=\"diag_code_scheme\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"   >\n\t\t<input type=\"text\" name=\"diag_code_scheme_desc\" id=\"diag_code_scheme_desc\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"   size=\'25\'  maxlength=\'15\'  disabled>\n\n\t  </td>\n</tr>\n<tr>\n\t<td class=label width=\'25%\' nowrap>\n\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t</td>\n\t\t<td width=\'32%\' class=\"fields\" >\n\t\t\t<input style=\"text-transform:uppercase\" type=\"text\" name=\"oper_code\" id=\"oper_code\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" size=\'25\'  maxlength=10 onkeypress=\"return CheckForSpecChars(event)\" ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" onBlur=\'ChangeUpperCase(this);\' >\n\t\t\t<input type=\'button\' class=\'button\' value=\'?\' name=\'opercode\' id=\'opercode\' onClick=\"searchOperlkp(oper_code,long_desc);\" disabled><img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t</td>\n\t<td class=label width=\'25%\' >\n\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t<input type=\"checkbox\" name=\"status\" id=\"status\" onClick=\'setCheckValue();\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" >\n\t</td>\n\t<td width=\'25%\' class=\"fields\" >\n\t\n\t</td>\n</tr>\n\n<tr>\n\t<td class=label width=\'25%\' >\n\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t</td>\n\t<td width=\'25%\' class=\"fields\" colspan=\'3\'>\n\t\t\t<input type=\"text\" name=\"long_desc\" id=\"long_desc\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"  size=\'60\' maxlength=\'60\'> <!-- Modified Against ML-MMOH-CRF-0432 -->\n\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n\t</td>\n\t\n</tr>\n\t\n<tr>\n\t<td class=label width=\'25%\' >\n\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t</td>\n\t<td width=\'25%\' class=\"fields\" colspan=\'3\'>\n\t\t<input type=\"text\" name=\"short_desc\" id=\"short_desc\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" onkeypress=\"return restrictSpecialChars_op(event);\" size=\'40\' maxlength=\'40\' > <!-- Modified Against ML-MMOH-CRF-0432 -->\n\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n\t</td>\n\t<!-- Added against ML-BRU-SCF-1401 (restrictSpecialChars_op) -->\n</tr> \n\n<tr>\n\t<td class=label width=\'25%\' >\n\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t</td>\n\t<td width=\'25%\' class=\"fields\" colspan=\'3\'>\n\t\t\t<input type=\'text\' name=\'oper_type_desc\' id=\'oper_type_desc\' size=\'25\'  value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\"  onBlur=\"oper_type_validate(this,oper_type_code,oper_type_desc);\" ><input type=\'hidden\' name=\'oper_type_code\' id=\'oper_type_code\'  value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" ><input type=\'button\' class=\'button\' value=\'?\' name=\'opertype\' id=\'opertype\' onClick=\"searchlkp(\'Operation Type Search\',operationType,oper_type_code,oper_type_desc);\"><img src=\'../../eCommon/images/mandatory.gif\'>\n\t</td>\n\t\n</tr>\n<tr>\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t<td class=\"label\" width=\"25%\" >\n\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t</td>\n\t<td class=\"label\" width=\"25%\" >\n\t\t<input type=\"checkbox\" name=\"link_status\" id=\"link_status\" onClick=\'setLinkValue();\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' onBlur=\"\" >\n\t</td>\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t<td class=\'label\' width=\'25%\'>\n\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\n\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\n\t\t<select name=\"order_type\" id=\"order_type\">\n\t\t\t<option value=\"\">";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</option>\n\t\t</select>\n\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t<img id=\"img1\" src=\'../../eCommon/images/mandatory.gif\' >\n\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t<img id=\"img1\" src=\'../../eCommon/images/Blank1.gif\' >\n\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t<td class=\'fields\' width=\'25%\' colspan=\"3\">\n\t\t<input type=\"text\" name=\"order_type_desc\" id=\"order_type_desc\" value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' readOnly>\n\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t</td>\n\t<td class=\'fields\' width=\'25%\'>\n\t</td>\n</tr>\n<tr>\n\t<td class=label width=\'25%\' >\n\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t</td>\n\t<td width=\'25%\' class=\"fields\" colspan=\'3\'>\n\t\t\t<input type=\'text\' name=\'order_catalog_desc\' id=\'order_catalog_desc\' size=\'25\' maxlength=\'30\' value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =" \n\t\t\tonBlur=\"if(this.value!=\'\')searchOrderCatlkp(\'Order Catalog Search\',orderCatalog ,order_catalog_code, order_catalog_desc);\" readOnly><input type=\'hidden\' name=\'order_catalog_code\' id=\'order_catalog_code\'  value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" ><input type=\'button\' class=\'button\' value=\'?\' name=\'ordercat\' id=\'ordercat\' onClick=\"searchOrderCatlkp(\'Order Catalog Search\',orderCatalog ,order_catalog_code, order_catalog_desc);\"  ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =" disabled>\n\t\t\t\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t<img id=\"img2\" src=\'../../eCommon/images/Blank1.gif\' ></td>\n\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t<img id=\"img2\" src=\'../../eCommon/images/mandatory.gif\' ></td>\n\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t</td>\n</tr>\n\n<tr>\n\t<td class=label width=\'25%\' >\n\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t</td>\n\t<td width=\'25%\' class=\"fields\" colspan=\'3\'>\n\t\t\t<input type=\'text\' name=\'duration\' id=\'duration\' size=\'6\' maxlength=\'5\' value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" onkeypress=\"return checkForSpecCharsforID(event);\" onBlur=\"validateDuration(this)\"><img src=\'../../eCommon/images/mandatory.gif\'> (hh24:mi)\n\t</td>\t\n</tr>\t\n\n<tr>\n\t<td class=label width=\'25%\'>\n\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t</td>\n\t<td class=\"fields\" width=\"25%\" colspan=\"3\">\n\t\t\t<input type=\"checkbox\" name=\"side_appl\" id=\"side_appl\" onClick=\'checkVal();\' value=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 =" >\n\t</td>\t\n</tr>\n</table>\n<table border=0 align=\'centre\' cellspacing=0 cellpadding=3 width=\'100%\'  >\n<tr>\n\n\t<td class=label width=\'25%\' >\n\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t</td>\n\t<td width=\'25%\' class=\"fields\" >\n\t\t\t<input type=\'hidden\' name=\'pre_op_check_list\' id=\'pre_op_check_list\'  value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n\t\t\t<input type=\'text\' name=\'pre_op_check_list_desc\' id=\'pre_op_check_list_desc\' size=\'25\' maxlength=\'60\' value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" onBlur=\"if(this.value!=\'\')searchlkp(\'Checklist Search\',checklist, pre_op_check_list,pre_op_check_list_desc); else pre_op_check_list.value=\'\' \"><input type=\'button\' class=\'button\' value=\'?\' name=\'prechk\' id=\'prechk\' onClick=\"searchlkp(\'Checklist Search\',checklist, pre_op_check_list,pre_op_check_list_desc);\" >\n\t\t</td>\n\t<td></td><td></td>\n\n</tr>\n\n<tr>\t\t\n\t<td class=label width=\'25%\'>\n\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t</td>\n\t<td width=\'25%\' class=\"fields\" >\n\t\t\t<input type=\'hidden\' name=\'post_op_check_list\' id=\'post_op_check_list\'  value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n\t\t\t<input type=\'text\' name=\'post_op_check_list_desc\' id=\'post_op_check_list_desc\' size=\'25\' maxlength=\'30\' value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" onBlur=\"if(this.value!=\'\')searchlkp(\'Checklist Search\',checklist, post_op_check_list,post_op_check_list_desc); else post_op_check_list.value=\'\'\" ><input type=\'button\' class=\'button\' value=\'?\' name=\'postchk\' id=\'postchk\' onClick=\"searchlkp(\'Checklist Search\',checklist, post_op_check_list,post_op_check_list_desc);\" >\n\t</td>\n\t\t<td></td><td></td>\n</tr>\n\n\n<tr>\t\t\n\t<td class=label width=\'25%\'> \n\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t</td>\n\t<td width=\'25%\' class=\"fields\" >\n\t\t\t<input type=\'hidden\' name=\'swab_instr_tmpl_id\' id=\'swab_instr_tmpl_id\'  value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">\n\t\t\t<input type=\'text\' name=\'swab_instr_tmpl_desc\' id=\'swab_instr_tmpl_desc\' size=\'25\' maxlength=\'30\' value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" onBlur=\"if(this.value!=\'\')searchlkp(\'Swab / Instrument Template Search\', swabandInstrumentCount,swab_instr_tmpl_id,swab_instr_tmpl_desc); else swab_instr_tmpl_id.value=\'\'\" ><input type=\'button\' class=\'button\' value=\'?\' name=\'swab\' id=\'swab\' onClick=\"searchlkp(\'Swab / Instrument Template Search\', swabandInstrumentCount,swab_instr_tmpl_id,swab_instr_tmpl_desc);\" >\n\t</td>\n\t\t<td></td><td></td>\n</tr>\n\t<input type=\'hidden\' name=\'instr_in_english_\' id=\'instr_in_english_\'  value=\"\">\n\t<input type=\'hidden\' name=\'instr_in_local_\' id=\'instr_in_local_\'  value=\"\">\n<tr>\t\t\n\t<td class=label width=\'25%\' >\n\t\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t</td>\n\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t<td width=\'25%\' class=\"fields\" >\n\t\t\t<input type=\'hidden\' name=\'oper_cat_code\' id=\'oper_cat_code\'  value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n\t\t\t<input type=\'text\' name=\'oper_cat_desc\' id=\'oper_cat_desc\' size=\'25\' maxlength=\'30\' value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" \n\t\t\tonBlur=\"if(this.value!=\'\')searchlkp(\'Category Search\',category, oper_cat_code,oper_cat_desc); else oper_cat_code.value=\'\'\" readonly disabled><!-- <input type=\'button\' class=\'button\' value=\'?\' name=\'catg\' id=\'catg\' disabled\n\t\t\tonClick=\"searchlkp(\'Category Search\',category, oper_cat_code,oper_cat_desc);\" > -->\n\t</td>\n\t\t<td></td><td></td>\n\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t<td width=\'25%\' class=\"fields\" >\n\t\t\t<input type=\'hidden\' name=\'oper_cat_code\' id=\'oper_cat_code\'  value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\" \n\t\t\tonBlur=\"if(this.value!=\'\')searchlkp(\'Category Search\',category, oper_cat_code,oper_cat_desc); else oper_cat_code.value=\'\'\"><input type=\'button\' class=\'button\' value=\'?\' name=\'catg\' id=\'catg\'\n\t\t\tonClick=\"searchlkp(\'Category Search\',category, oper_cat_code,oper_cat_desc);\" >\n\t</td>\t<td></td><td></td>\n\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n</tr>\n\n<tr>\t\t\n\t<td class=label width=\'25%\' >\n\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\n\t<td width=\'25%\' class=\"fields\" >\n\t\t\t<input type=\'hidden\' name=\'oper_sub_cat_code\' id=\'oper_sub_cat_code\'  value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">\n\t\t\t<input type=\'text\' name=\'oper_sub_cat_desc\' id=\'oper_sub_cat_desc\' size=\'25\' maxlength=\'30\' value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\"\n\t\t\tonBlur=\"if(this.value!=\'\')searchlkp(\'Sub Category Search\',subCategory, oper_sub_cat_code,oper_sub_cat_desc); else oper_sub_cat_code.value=\'\' \" readonly disabled><!-- <input type=\'button\' class=\'button\' value=\'?\' name=\'subcatg\' id=\'subcatg\' onClick=\"searchlkp(\'Sub Category Search\',subCategory, oper_sub_cat_code,oper_sub_cat_desc);\" disabled > -->\n\t</td>\t<td></td><td></td>\n\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t<td width=\'25%\' class=\"fields\" >\n\t\t\t<input type=\'hidden\' name=\'oper_sub_cat_code\' id=\'oper_sub_cat_code\'  value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\"\n\t\t\tonBlur=\"if(this.value!=\'\')searchlkp(\'Sub Category Search\',subCategory, oper_sub_cat_code,oper_sub_cat_desc); else oper_sub_cat_code.value=\'\' \"><input type=\'button\' class=\'button\' value=\'?\' name=\'subcatg\' id=\'subcatg\' onClick=\"searchlkp(\'Sub Category Search\',subCategory, oper_sub_cat_code,oper_sub_cat_desc);\" >\n\t</td>\t<td></td><td></td>\n\n\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\n</tr>\n<!-- \n <tr>\n\t<td class=label width=\'25%\' >Patient Information Document</td>\n\t<td width=\'25%\' class=\"fields\"><input type=\"text\" name=\"patient_info_file_id\" id=\"patient_info_file_id\" value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\"  size=60 maxlength=100   > <input type=\'button\' class=\'button\' value=\'?\' name=\'open_dialog\' id=\'open_dialog\' title=\"Open Dialog Window\"> <input type=\'button\' class=\'button\' value=\'?\' name=\'open_doc\' id=\'open_doc\' title=\"Open Specified File\"> </td>\n\t<td  colspan=\"6\"></td>\n</tr> -->\n  </table> \n\n<table border=0 cellspacing=0 cellpadding=3 width=\'100%\'  align=\'center\'> \n\n<tr>\n\t\t<td class=\"label\">\n\t\t\t\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t</td>\n\t\t<td class=\"label\" colspan=3>\n\t\t\t\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t\t</td>\n</tr>\n<tr>\n\t  \n\t  <td class=\"label\" width=\"58%\">\n\t\t\t<textarea  rows=\"5\" cols=\"40\" name=\"instr_in_english\" value=\"\" disabled > \n\t\t\t</textarea>\n\t\t</td>\n\t\t\n\t\t<td class=\"label\" colspan=3>\n\t\t\t<textarea rows=\"5\" cols=\"40\" name=\"instr_in_local\" value=\"\" disabled > \n\t\t\t</textarea>\n\t\t</td>\n</tr> \n\n\n</table>\n\n<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\'>\n<input type=\'hidden\' name=\'oper_code_scheme\' id=\'oper_code_scheme\' value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\">\n<input type=\'hidden\' name=\'oper_code_scheme_desc\' id=\'oper_code_scheme_desc\' value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\">\n<input type=\'hidden\' name=\'type\' id=\'type\'  value=\"appt_time\">\n<input type=\'hidden\' name=\'order_type_code\' id=\'order_type_code\'  value=\"\">\n<input type=\'hidden\' name=\'diag_code_scheme_ot_param\' id=\'diag_code_scheme_ot_param\'  value=\"\">\n<input type=\'hidden\' name=\'duration_db_value\' id=\'duration_db_value\' value=\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\'>\n<input type=\'hidden\' name=\'order_catalog_code1\' id=\'order_catalog_code1\' value=\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\'>\n<input type=\'hidden\' name=\'side_appl1\' id=\'side_appl1\' value=\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\'>\n<input type=\'hidden\' name=\'db_oper_cat_code\' id=\'db_oper_cat_code\'     value=\'";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\'>\n<input type=\'hidden\' name=\'db_oper_sub_cat_code\' id=\'db_oper_sub_cat_code\' value=\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\'>\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\">\n<input type=\'hidden\' name=\'params\' id=\'params\' value=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\">\n</form>\n\n</body>\n</html>\n\n<SCRIPT LANGUAGE=\"JavaScript\">\n\tcheck_ena_dis(); \n\tif(document.OperProcForm.mode.value==\"modify\"){\n\t\tgetDtlsForQuery();\n\t}\n</SCRIPT> \n\n\n\n";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.trim()!="" && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return (checkForNull(inputString).intern()!="") ? inputString:defaultValue;
	}

public HashMap CToHashMap( Hashtable table ) {
		if( table == null ) return null;
		return new HashMap(table);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String locale = (String)session.getAttribute("LOCALE");
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

//request parameter
String mode=checkForNull(request.getParameter("mode"));
String oper_code = checkForNull(request.getParameter( "oper_code" ));
//cannoicalization of empty String
String empty = "".intern();
String oper_code_scheme = empty;       String disable_oper_code = empty;
String chk_checked="checked";          String chk_value="E";
String disable_flag=empty;             String cat_dis_flag=empty;
String readonly_flag=empty;            String surgery_disable=empty;
String long_desc=empty;                String short_desc=empty;
String oper_type_desc=empty;           String oper_type_code=empty;
String order_catalog_desc=empty;       String order_catalog_code = empty;
String speciality_desc=empty;		   String side_checked=empty;
String side_appl ="N";				   String duration =empty;
String duration_db_value_jsp =empty;   String speciality_code=empty;
String pre_op_check_list=empty;		   String pre_op_check_list_desc=empty;
String post_op_check_list=empty;	   String post_op_check_list_desc=empty;
String swab_instr_tmpl_id =empty;	   String swab_instr_tmpl_desc =empty;
String oper_cat_code = empty;		   String oper_cat_desc = empty;
String oper_sub_cat_code=empty;		   String oper_sub_cat_desc =empty;
String db_oper_cat_code = empty;	   String db_oper_sub_cat_code=empty;
String patient_info_file_id=empty;	   String status=empty;
String link_status=empty;			   String sql=empty;
String diag_code_scheme=empty;		   String order_type_desc=empty; 	
String diag_code_scheme_desc = empty;
if(mode.equals("modify")){	
	disable_oper_code="readOnly";
}
Connection con=null;
PreparedStatement stmt=null;
//PreparedStatement pstmt=null;
ResultSet rs=null;
//ResultSet rst=null;
//String diag_code_scheme_selected = "";
if(mode.equals("insert")){
	try{
		con=ConnectionManager.getConnection(request);
		String sql_1="SELECT OPER_CODE_SCHEME  FROM   OT_PARAM";
		stmt=con.prepareStatement(sql_1);
		rs=stmt.executeQuery();
		while(rs!=null && rs.next())
		{
			oper_code_scheme=rs.getString("oper_code_scheme");
		}
	}
	catch(Exception e){
		e.printStackTrace();
	}finally{
		if(rs!=null)rs.close();
        if(stmt!=null)stmt.close();
		if(con!=null)
		ConnectionManager.returnConnection(con,request); 
	}
}

if(mode.equals("modify")){
	cat_dis_flag="disabled";
	try{
		con=ConnectionManager.getConnection(request);
		//sql="Select  a.long_desc, a.short_desc, a.oper_type_code , b.short_desc oper_type_desc, a.order_catalog_code, c.short_desc order_catalog_desc, to_char(c.appt_time, 'hh24:mi') duration, a.speciality_code, d.short_desc speciality_desc, nvl(appl_right_left_flag,'N') appl_right_left_flag, a.pre_op_check_list , e.description pre_op_check_list_desc, a.post_op_check_list , f.description post_op_check_list_desc , g.oper_cat_code oper_cat_code, g.oper_sub_cat_code oper_sub_cat_code,  a.swab_instr_tmpl_id swab_instr_tmpl_id, j.description swab_instr_tmpl_desc, nvl(a.status,'E') status from OT_OPER_MAST_LANG_VW a, OT_OPER_TYPE_LANG_VW b, OR_ORDER_CATALOG_LANG_VW c , AM_SPECIALITY_LANG_VW d , OT_CHECKLIST_HDR_LANG_VW e, OT_CHECKLIST_HDR_LANG_VW f , OT_OPER_FOR_GROUP_CAT g, OT_SWAB_INSTR_TMPL_HDR_LANG_VW j where a.language_id = '"+locale+"' AND a.language_id = b.language_id AND a.oper_type_code = b.oper_type and a.language_id = c.language_id AND a.order_catalog_code = c.order_catalog_code and a.language_id = d.language_id AND a.speciality_code = d.speciality_code and a.language_id = e.language_id(+) AND a.pre_op_check_list = e.checklist_code(+) and a.language_id= f.language_id(+) AND a.post_op_check_list = f.checklist_code(+) and a.oper_code = g.oper_code(+) and a.speciality_code = g.oper_group_code(+) and a.language_id = j.language_id(+) AND a.swab_instr_tmpl_id = j.template_id(+) and a.oper_code =?";
		sql=" SELECT  A.LONG_DESC, A.SHORT_DESC, A.OPER_TYPE_CODE , GET_DESC(?,'OT_OPER_TYPE_LANG_VW','SHORT_DESC','OPER_TYPE',B.OPER_TYPE) OPER_TYPE_DESC, A.ORDER_CATALOG_CODE, GET_DESC(?,'OR_ORDER_CATALOG_LANG_VW','SHORT_DESC','ORDER_CATALOG_CODE',A.ORDER_CATALOG_CODE) ORDER_CATALOG_DESC, TO_CHAR(C.APPT_TIME, 'HH24:MI') DURATION, A.SPECIALITY_CODE, GET_DESC(?,'AM_SPECIALITY_LANG_VW','SHORT_DESC','SPECIALITY_CODE',A.SPECIALITY_CODE) SPECIALITY_DESC, NVL(APPL_RIGHT_LEFT_FLAG,'N') APPL_RIGHT_LEFT_FLAG, A.PRE_OP_CHECK_LIST , GET_DESC(?,'OT_CHECKLIST_HDR_LANG_VW','DESCRIPTION','CHECKLIST_CODE',A.PRE_OP_CHECK_LIST) PRE_OP_CHECK_LIST_DESC, A.POST_OP_CHECK_LIST , GET_DESC(?,'OT_CHECKLIST_HDR_LANG_VW','DESCRIPTION','CHECKLIST_CODE',A.POST_OP_CHECK_LIST) POST_OP_CHECK_LIST_DESC ,G.OPER_CAT_CODE OPER_CAT_CODE, (SELECT LONG_DESC FROM OT_OPER_CATEGORY_LANG_VW Y WHERE Y.OPER_GROUP_CODE=I.OPER_GROUP_CODE AND Y.OPER_CAT_CODE = I.OPER_CAT_CODE AND Y.LANGUAGE_ID=?) OPER_CAT_DESC, G.OPER_SUB_CAT_CODE OPER_SUB_CAT_CODE,  (SELECT LONG_DESC FROM OT_OPER_SUB_CATEGORY_LANG_VW X WHERE X.OPER_GROUP_CODE=I.OPER_GROUP_CODE AND X.OPER_CAT_CODE = I.OPER_CAT_CODE AND X.OPER_SUB_CAT_CODE=I.OPER_SUB_CAT_CODE AND X.LANGUAGE_ID=?) OPER_SUB_CAT_DESC, A.SWAB_INSTR_TMPL_ID SWAB_INSTR_TMPL_ID, GET_DESC(?,'OT_SWAB_INSTR_TMPL_HDR_LANG_VW','DESCRIPTION','TEMPLATE_ID',J.TEMPLATE_ID) SWAB_INSTR_TMPL_DESC, NVL(A.STATUS,'E') STATUS, NVL(A.LINK_CATALOG_YN,'N') LINK_CATALOG_YN,A.DIAG_CODE_SCHEME,(SELECT ORDER_TYPE_CODE||'-'||SHORT_DESC FROM OR_ORDER_TYPE AA WHERE AA.ORDER_TYPE_CODE = C.ORDER_TYPE_CODE) ORDER_TYPE_DESC FROM OT_OPER_MAST_LANG_VW A, OT_OPER_TYPE B, OR_ORDER_CATALOG C , AM_SPECIALITY D , OT_CHECKLIST_HDR E, OT_CHECKLIST_HDR F , OT_OPER_FOR_GROUP_CAT G, OT_OPER_CATEGORY H, OT_OPER_SUB_CATEGORY I, OT_SWAB_INSTR_TMPL_HDR J WHERE A.LANGUAGE_ID=? AND A.OPER_TYPE_CODE = B.OPER_TYPE AND A.ORDER_CATALOG_CODE = C.ORDER_CATALOG_CODE(+) AND A.SPECIALITY_CODE = D.SPECIALITY_CODE AND A.PRE_OP_CHECK_LIST = E.CHECKLIST_CODE(+) AND A.POST_OP_CHECK_LIST = F.CHECKLIST_CODE(+) AND A.OPER_CODE = G.OPER_CODE(+) AND A.SPECIALITY_CODE = G.OPER_GROUP_CODE(+) AND G.OPER_CAT_CODE = H.OPER_CAT_CODE(+) AND G.OPER_CAT_CODE = I.OPER_CAT_CODE(+) AND G.OPER_SUB_CAT_CODE =   I.OPER_SUB_CAT_CODE(+) AND A.SWAB_INSTR_TMPL_ID = J.TEMPLATE_ID(+) AND A.OPER_CODE= ?";

		stmt=con.prepareStatement(sql);
		stmt.setString(1,locale);
		stmt.setString(2,locale);
		stmt.setString(3,locale);
		stmt.setString(4,locale);
		stmt.setString(5,locale);
		stmt.setString(6,locale);
		stmt.setString(7,locale);
		stmt.setString(8,locale);
		stmt.setString(9,locale);
		stmt.setString(10,oper_code);
		rs=stmt.executeQuery();

		while(rs.next()){
			long_desc			=		checkForNull(rs.getString("long_desc") );
			short_desc			=		checkForNull(rs.getString("short_desc") );
			short_desc = short_desc.replace("\"","");//ML-BRU-SCF-1401
			oper_type_code			=		checkForNull(rs.getString("oper_type_code") );
			oper_type_desc			=		checkForNull(rs.getString("oper_type_desc") );
			order_catalog_code		=		checkForNull(rs.getString("order_catalog_code") );
			order_catalog_desc		=		checkForNull(rs.getString("order_catalog_desc"));
			duration			=		checkForNull(rs.getString("duration"));
			duration_db_value_jsp		=		checkForNull(rs.getString("duration"));
			side_appl			=		checkForNull(rs.getString("appl_right_left_flag") );
			speciality_code			=		checkForNull(rs.getString("speciality_code") );
			speciality_desc			=		checkForNull(rs.getString("speciality_desc") );
			pre_op_check_list		=		checkForNull(rs.getString("pre_op_check_list"));
			pre_op_check_list_desc 	 	=		checkForNull(rs.getString("pre_op_check_list_desc"));
			post_op_check_list		=		checkForNull(rs.getString("post_op_check_list"));
			post_op_check_list_desc 	=		checkForNull(rs.getString("post_op_check_list_desc"));
			oper_cat_code			=		checkForNull(rs.getString("oper_cat_code"));
			oper_cat_desc			=		checkForNull(rs.getString("oper_cat_desc"));	
			oper_sub_cat_code		=		checkForNull(rs.getString("oper_sub_cat_code"));
			oper_sub_cat_desc		=		checkForNull(rs.getString("oper_sub_cat_desc"));
			swab_instr_tmpl_id		=		checkForNull(rs.getString("swab_instr_tmpl_id"));
			swab_instr_tmpl_desc		=		checkForNull(rs.getString("swab_instr_tmpl_desc"));
			status				=		checkForNull(rs.getString("status"));
			link_status			=		checkForNull(rs.getString("link_catalog_yn"));
			diag_code_scheme		=		checkForNull(rs.getString("diag_code_scheme"));
			order_type_desc			=		checkForNull(rs.getString("ORDER_TYPE_DESC"));
		}
		db_oper_cat_code = oper_cat_code;
		db_oper_sub_cat_code = oper_sub_cat_code;
		if(status.equals("E")){
			chk_checked="checked";
			disable_flag="";
			readonly_flag="";
		}else{
			chk_checked="";
			disable_flag="disabled";
			chk_value="D";
		}
if(mode.equals("modify")) {
	String sql_ot_param="";
	
	String sql_ot_splty="SELECT DIAG_CODE_SCHEME,GET_DESC(?,'MR_TERM_SET_LANG_VW','TERM_SET_DESC','TERM_SET_ID',DIAG_CODE_SCHEME) DIAG_CODE_DESC FROM OT_SPECIALITIES WHERE SPECIALITY_CODE= ? ";
		if(rs!=null)rs.close();
        if(stmt!=null)stmt.close();
		stmt=con.prepareStatement(sql_ot_splty);
		stmt.setString(1,locale);
		stmt.setString(2,speciality_code);
		rs=stmt.executeQuery();
		while(rs.next()){
			diag_code_scheme=checkForNull(rs.getString("DIAG_CODE_SCHEME"));
			diag_code_scheme_desc=checkForNull(rs.getString("DIAG_CODE_DESC"));	
		}
	if(diag_code_scheme.equals("")){
		sql_ot_param="SELECT OPER_CODE_SCHEME,GET_DESC(?,'MR_TERM_SET_LANG_VW','TERM_SET_DESC','TERM_SET_ID',OPER_CODE_SCHEME) DIAG_CODE_DESC FROM OT_PARAM";
		if(rs!=null)rs.close();
        if(stmt!=null)stmt.close();
		stmt=con.prepareStatement(sql_ot_param);
		stmt.setString(1,locale);
		rs=stmt.executeQuery();
		while(rs.next()){
			diag_code_scheme=checkForNull(rs.getString("OPER_CODE_SCHEME"));
			diag_code_scheme_desc=checkForNull(rs.getString("DIAG_CODE_DESC"));  
		}
	}
}
		side_checked = ("Y".equals(side_appl))?"checked":"";
		surgery_disable="disabled";	
	}
	catch(Exception e){
		e.printStackTrace();
}finally{
		if(rs!=null)rs.close();
	        if(stmt!=null)stmt.close();
		if(con!=null)
		ConnectionManager.returnConnection(con,request); 
	}
  
}
speciality_desc=speciality_desc==null?"":speciality_desc;
speciality_desc=speciality_desc.equals("null")?"":speciality_desc;

order_catalog_desc=order_catalog_desc==null?"":order_catalog_desc;
order_catalog_desc=order_catalog_desc.equals("null")?"":order_catalog_desc;




            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(disable_oper_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(speciality_desc));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(cat_dis_flag));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(diag_code_scheme));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(diag_code_scheme_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(oper_code));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(disable_oper_code));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(chk_value));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(chk_checked));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(long_desc));
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(oper_type_desc));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(oper_type_code));
            _bw.write(_wl_block32Bytes, _wl_block32);

if(!mode.equals("modify")){

            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(chk_value));
            _bw.write(_wl_block35Bytes, _wl_block35);

	}

            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);

		if(order_type_desc.equals("")){
	
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
 if(link_status.equals("")){
            _bw.write(_wl_block40Bytes, _wl_block40);
}else{
            _bw.write(_wl_block41Bytes, _wl_block41);
}
		}else{
	
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(order_type_desc));
            _bw.write(_wl_block43Bytes, _wl_block43);

		}
	
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(order_catalog_desc));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(cat_dis_flag));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(cat_dis_flag));
            _bw.write(_wl_block49Bytes, _wl_block49);
 if(order_catalog_desc.equals("")){
            _bw.write(_wl_block50Bytes, _wl_block50);
}else{
            _bw.write(_wl_block51Bytes, _wl_block51);
}
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(duration));
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(side_appl));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(side_checked));
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(pre_op_check_list));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(pre_op_check_list_desc));
            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(post_op_check_list));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(post_op_check_list_desc));
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(swab_instr_tmpl_id));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(swab_instr_tmpl_desc));
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);

	if(mode.equals("modify")){
	
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(oper_cat_code));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(oper_cat_desc));
            _bw.write(_wl_block69Bytes, _wl_block69);
} else {
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(oper_cat_code));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(oper_cat_desc));
            _bw.write(_wl_block71Bytes, _wl_block71);
}
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);

	if(mode.equals("modify")){
	
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(oper_sub_cat_code));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(oper_sub_cat_desc));
            _bw.write(_wl_block75Bytes, _wl_block75);
}else {
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(oper_sub_cat_code));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(oper_sub_cat_desc));
            _bw.write(_wl_block77Bytes, _wl_block77);
}
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(patient_info_file_id));
            _bw.write(_wl_block79Bytes, _wl_block79);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(oper_code_scheme));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(diag_code_scheme_desc));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(duration_db_value_jsp));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(side_appl));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(db_oper_cat_code));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(db_oper_sub_cat_code));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block91Bytes, _wl_block91);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ProcedureCodingScheme.Label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.UserDefined.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.icd10pcs.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CPT4.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ICD9CM.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.OperationCode.Label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enabled.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.longdescription.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.shortdescription.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.OperationType.Label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.LinkCatalog.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderType.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CatalogCrossReference.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.duration.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.SideApplicable.Label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.PreOperativeCheckList.Label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.PostOperativeCheckList.Label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.SwabandInstrumentCount.Label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.category1.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.SubCategory.Label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.StandardInstructions.Label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.StandInstrnsinLocalLang.Label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
