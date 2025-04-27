package jsp_servlet._epo._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import ePO.*;
import ePO.Common.*;
import eCommon.Common.*;
import java.text.*;
import java.lang.*;
import java.util.*;
import java.util.ArrayList;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __commitmentcodedetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ePO/jsp/CommitmentCodeDetails.jsp", 1709121584872L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<head>\n\t\t<title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\' ></link>\n\t\t<script language=\"JavaScript\" src=\"../../ePO/js/PoCommon.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/messages.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePO/js/PoDuoHeader.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePO/js/MasterType.js\"></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t <script>\n        function_id\t\t\t\t=\t\t \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"\n\t\t\n    </script>\n\t\n\t</head>\n<body>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<form name=\"formcomcodedtls\" id=\"formcomcodedtls\">\n\t<table border=\'0\' cellpadding=\'2\' cellspacing=\'0\' width=\'100%\' height=\'100%\' align=center>\n\n\t\t<tr>\n\t\t<td width=\'100%\'   class=\"WHITE\">\t\n\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\'100%\' border=1 align=center  id=\"myTable\" >\n\t\t<tr>\n\t\t<th >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n\t\t<th >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n\t\t</tr>\n\t\t\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t<tr>\n\t\t\t\t<td  class=\"fields\" >\t&nbsp;\n\t\t\t\t\t<select name=\"dept_no_";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" id=\"dept_no_";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" >\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t</select>\n\t\t\t\t</td>\n\t\t\t\t<td  class=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" >\n\t\t\t\t\t<input type=\"text\" name=\"acc_no_";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" id=\"acc_no_";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" value = \"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" size=\"20\" maxlength=\"20\"  onKeyPress=\"return CheckForSpecChars(event)\" onBlur=\"checkSpecialChars(this);\">\n\t\t\t\t</td>\n\t\t\t\t<td  class=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" >\n\t\t\t\t\t<input type=\"text\" name=\"acc_no_desc_";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" id=\"acc_no_desc_";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" size=\"30\" maxlength=\"30\" >\n\t\t\t\t</td>\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\t\n\t\t\t\t\n\t\t\t\t<td  class=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" >\n\t\t\t\t\t<input type=\"text\" class=\"NUMBER\" name=\"all_budget_";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" id=\"all_budget_";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" size=\"8\" maxlength=\"8\" onkeypress=\"return isValidNumber(this,event,8,3);\" onChange=\"displaytotalbudget_insert(\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\');\" >\n\t\t\t\t</td>\n\t\t\t\t<td  class=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" >\n\t\t\t\t\t<input type=\"text\" class=\"NUMBER\" name=\"addnl_budget_";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" id=\"addnl_budget_";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\');\" >\n\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\t\n\t\t\t\t<td  class=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" size=\"8\" maxlength=\"8\" onkeypress=\"return isValidNumber(this,event,8,3);\"  onChange=\"displaytotalbudget_insert(\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\');\" onBlur=\"\" ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =" >\n\t\t\t\t</td>\n\t\t\t\t<td  class=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" size=\"8\" maxlength=\"8\" onkeypress=\"return isValidNumber(this,event,8,3);\" onChange=\"displaytotalbudget_modify(\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\',\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\');\" >\n\t\t\t\t</td>\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\n\t\t\t\t<td  class=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" >\n\t\t\t\t\t<input type=\"text\" class=\"NUMBER\" name=\"total_budget_";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" id=\"total_budget_";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" size=\"10\" maxlength=\"10\" onkeypress=\"return isValidNumber(this,event,10,3);\" disabled>\n\t\t\t\t</td>\n\t\t\t\t<td  class=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" >\n\t\t\t\t\t<input type=\"text\" class=\"NUMBER\" name=\"blocked_budget_";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" id=\"blocked_budget_";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" size=\"10\" maxlength=\"10\" onkeypress=\"return isValidNumber(this,event,10,3);\" disabled>\n\t\t\t\t</td>\n\t\t\t\t\n\t\t\t\t<td  class=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" >\n\t\t\t\t\t<input type=\"text\" name=\"from_date_";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" id=\"from_date_";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" size=\"10\" class=\'DATE\'value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 =" maxlength=\"10\" onBlur=\"CheckDate(this);\"><img src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar(\'from_date_";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\');\" ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 =" ></img>\n\t\t\t\t</td>\n\t\t\t\t<td  class=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" >\n\t\t\t\t\t<input type=\"text\" name=\"to_date_";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" id=\"to_date_";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" size=\"10\" class=\'DATE\' value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" maxlength=\"10\" onBlur=\"CheckDate(this);checkValidate(this);addRowToTable();\" ><img src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar(\'to_date_";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\');\" ></img>\n\t\t\t\t</td>\n\t\t\t\t<td  class=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" >\n\t\t\t\t\t<select name=\"override_budget_";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" id=\"override_budget_";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\" >\n\t\t\t\t\t<!--\t<option value=\"\" >&nbsp;---Select---&nbsp;</option>  -->\n\t\t\t\t\t\t<option value=\"E\" ";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 =" >Error</option>\n\t\t\t\t\t\t<option value=\"W\" ";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 =">Warning</option>\n\t\t\t\t\t\t<option value=\"N\" ";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 =">Not Applicable</option>\n\t\t\t\t</td>\n\n\t\t\t\t\n\t\t\t</tr>\n\n\t\t\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\t\t\t\n\n\t\t\t<tr>\n\t\t\t<td  class=\"fields\" >\t&nbsp;\n\t\t\t\t\t<select name=\"dept_no_";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" value = \"\" size=\"20\" maxlength=\"20\" onKeyPress=\"return CheckForSpecChars(event)\" onBlur=\"checkSpecialChars(this);\" >\n\t\t\t\t</td>\n\t\t\t\t<td  class=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" value = \"\" size=\"30\" maxlength=\"30\" >\n\t\t\t\t</td>\n\t\t\t\t<td  class=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" value = \"\" size=\"8\" maxlength=\"8\" onkeypress=\"return isValidNumber(this,event,8,3);\" onChange=\"displaytotalbudget_insert(\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\');\">\n\t\t\t\t</td>\n\t\t\t\t<td  class=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\" value = \"\" size=\"10\" maxlength=\"10\" onkeypress=\"return isValidNumber(this,event,10,3);\" disabled>\n\t\t\t\t</td>\n\t\t\t\t<td  class=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" size=\"10\" class=\'DATE\'value=\"\"  maxlength=\"10\" onBlur=\"CheckDate(this);\"><img src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar(\'from_date_";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\');\"  ></img>\n\t\t\t\t</td>\n\t\t\t\t<td  class=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" size=\"10\" class=\'DATE\' value=\"\" maxlength=\"10\" onBlur=\"CheckDate(this);checkValidate(this);addRowToTable();\" ><img src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar(\'to_date_";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\');\" ></img>\n\t\t\t\t</td>\n\n\t\t\t\t<td  class=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\" >\n\t\t\t\t\t<!--\t<option value=\"\" >&nbsp;---Select---&nbsp;</option>  -->\n\t\t\t\t\t\t<option value=\"E\" >Error</option>\n\t\t\t\t\t\t<option value=\"W\" selected>Warning</option>\n\t\t\t\t\t\t<option value=\"N\" >Not Applicable</option>\n\t\t\t\t</td>\n\t\t\t\t\n\t\t\t</tr>\n\n\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\t\t\n\t</table>\n\n\t<tr>\n\t<td  colspan=\'7\'  align=\"right\"><input type=\"button\" name=\"close\" id=\"close\" value= \'  OK  \'  class=\"button\" onClick=\"returnVals(";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 =");\">\n\t</tr>\n\n\t</td>\n\t</tr>\n\t</table>\n\t\n\t<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\">\n\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\">\n\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\">\n\t<input type=\"hidden\" name=\"finalize_yn\" id=\"finalize_yn\"\t\t\tvalue=\"No\">\n\t<input type=\"hidden\" name=\"totalRecords\" id=\"totalRecords\" value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\">\n\t<input type=\"hidden\" name=\"dept_no\" id=\"dept_no\" value=\"\">\n\t<input type=\"hidden\" name=\"function_id\" id=\"function_id\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\">\n\t\n<input type=\"hidden\" name=\"acc_no\" id=\"acc_no\" value=\"\">\n<input type=\"hidden\" name=\"acc_no_desc\" id=\"acc_no_desc\" value=\"\">\n<input type=\"hidden\" name=\"all_budget\" id=\"all_budget\" value=\"\">\n<input type=\"hidden\" name=\"addnl_budget\" id=\"addnl_budget\" value=\"\">\n<input type=\"hidden\" name=\"total_budget\" id=\"total_budget\" value=\"\">\n<input type=\"hidden\" name=\"from_date\" id=\"from_date\" value=\"\">\n<input type=\"hidden\" name=\"to_date\" id=\"to_date\" value=\"\">\n<input type=\"hidden\" name=\"master_code\" id=\"master_code\" value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\">\n<input type=\"hidden\" name=\"long_desc\" id=\"long_desc\" value=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\">\n<input type=\"hidden\" name=\"short_desc\" id=\"short_desc\" value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\">\n<input type=\"hidden\" name=\"eff_status\" id=\"eff_status\" value=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\">\n<input type=\"hidden\" name=\"comm_rec\" id=\"comm_rec\"   value=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\">\t\n\n\n\n\t\n</form>\n";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

	    request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE"); 
		
		String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf( request.getParameter("function_id") ));
            _bw.write(_wl_block10Bytes, _wl_block10);

	String	mode							=				request.getParameter( "mode" ) ;
	String bean_id							=				request.getParameter("bean_id");
	String bean_name						=				request.getParameter("bean_name");
	String master_code						=				request.getParameter( "master_code" ) ;
	String long_desc						=				request.getParameter( "long_desc" ) ;
	String short_desc						=				request.getParameter( "short_desc" ) ;
	String eff_status						=				request.getParameter( "eff_status" ) ;
	String index							=				request.getParameter( "index" ) ;
	String disabled = "";
	String dept_code = "";
	String acc_no = "";
	String acc_no_desc = "";
	String all_bdgt = "";
	String addnl_bdgt = "";
	String blocked_bdgt = "";
	String total_bdgt = "";
	String eff_dt_frm = "";
	String eff_dt_to = "";
	String override_budget = "";
//	String error_selected = "";
//	String warning_selected = "";
//	String notApplicable_selected = "";
	int y=0;

	ArrayList alResult =  new ArrayList();
	HashMap	  hmResult =  new HashMap();
	ArrayList alResult1 =  new ArrayList();
	HashMap	  hmResult1 =  new HashMap();
	String total_bdgt1 = "";
	String addnl_bdgt1 = "";
	ArrayList alParam = new ArrayList();
	alParam.add(master_code);

	
	MultipleInsertMasterTypeBean bean					=				(MultipleInsertMasterTypeBean) getBeanObject( bean_id,bean_name,request);
	bean.setLanguageId(locale);	

		ServletContext context = getServletConfig().getServletContext();
		if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);
		bean.setMode( mode ) ;
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));	

		if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) ){
			try{
				
				alResult	=	(ArrayList)bean.fetchRecords("SELECT DEPT_CODE,ACCOUNT_NO,ACCOUNT_NAME,INITIAL_BDGT_AMT,ADDL_BDGT_AMT,BLOCKED_BDGT_AMT,BALANCE_BDGT_AMT,TO_CHAR (eff_date_from, 'dd/mm/yyyy') EFF_DATE_FROM, TO_CHAR(eff_date_to,'DD/MM/YYYY') eff_date_to , OVERRIDE_BUDGET from PO_COMMTTMENT_ACCOUNT a, PO_MASTER_CODE b where a.MASTER_TYPE = b.MASTER_TYPE and a.MASTER_CODE =b.MASTER_CODE  AND A.MASTER_CODE= ? ", alParam);
			
			}catch(Exception e){
				System.err.println("Error in Master Type Transaction Details");
				e.printStackTrace();
			}
		}

		if(bean.getExpRecords()!= null && (bean.getExpRecords()).size() > 0){
		alResult  = bean.getExpRecords(Integer.parseInt(index));
		}
				
	//	java.util.Collections.reverse(alResult);
		
		
	//sys_date							=			bean.getSystemDate();
		int size = 10;

		if(alResult!= null && alResult.size()!= 0){
				size = alResult.size();
			}
			
		

	//	if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) ){
	//	disabled = "disabled";
	//	}
		


            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

			String classValue = null;
			int max_rows = Integer.parseInt(eCommon.Common.CommonRepository.getCommonKeyValue("MULTIPLE_INSERT_PAGE_SIZE"));
			for ( int cnt=0; cnt<size; cnt++ ) {
				String error_selected = "";
				String warning_selected = "";
				String notApplicable_selected = "";
			
				if(cnt%2 ==0)
					classValue="QRYEVEN";
				else
					classValue="QRYODD";
					
				if(alResult!= null)	{
					if (cnt<alResult.size())
					hmResult = (HashMap)alResult.get(cnt);
					alResult1	=	(ArrayList)bean.fetchRecords("SELECT DEPT_CODE,ACCOUNT_NO,ACCOUNT_NAME,INITIAL_BDGT_AMT,ADDL_BDGT_AMT,BLOCKED_BDGT_AMT,BALANCE_BDGT_AMT,TO_CHAR (eff_date_from, 'dd/mm/yyyy') EFF_DATE_FROM, TO_CHAR(eff_date_to,'DD/MM/YYYY') eff_date_to , OVERRIDE_BUDGET from PO_COMMTTMENT_ACCOUNT a, PO_MASTER_CODE b where a.MASTER_TYPE = b.MASTER_TYPE and a.MASTER_CODE =b.MASTER_CODE  AND A.MASTER_CODE= ? ", alParam);
					if(alResult1.size() > 0){
					hmResult1 = (HashMap)alResult1.get(cnt);
					total_bdgt1 = bean.checkForNull((String)hmResult1.get("BALANCE_BDGT_AMT"));
					addnl_bdgt1 = bean.checkForNull((String)hmResult.get("ADDL_BDGT_AMT"));
					disabled = "disabled";
					}else{
					disabled = "";
					}	
					
						dept_code = bean.checkForNull((String)hmResult.get("DEPT_CODE"));
						acc_no =  bean.checkForNull((String)hmResult.get("ACCOUNT_NO"));
						acc_no_desc = bean.checkForNull((String)hmResult.get("ACCOUNT_NAME"));
						all_bdgt = bean.checkForNull((String)hmResult.get("INITIAL_BDGT_AMT"));
						addnl_bdgt = bean.checkForNull((String)hmResult.get("ADDL_BDGT_AMT"));
						blocked_bdgt = bean.checkForNull((String)hmResult.get("BLOCKED_BDGT_AMT"));
						total_bdgt = bean.checkForNull((String)hmResult.get("BALANCE_BDGT_AMT"));
						eff_dt_frm = com.ehis.util.DateUtils.convertDate(bean.checkForNull((String)hmResult.get("EFF_DATE_FROM")),"DMY","en",locale);
						eff_dt_to = com.ehis.util.DateUtils.convertDate(bean.checkForNull((String)hmResult.get("EFF_DATE_TO")),"DMY","en",locale);
						override_budget = bean.checkForNull((String)hmResult.get("OVERRIDE_BUDGET"));
						if(blocked_bdgt.equals("") || blocked_bdgt == null){
						blocked_bdgt = "0";
						}
						
						System.out.println("Over ride Budget = "+override_budget);
						
						if(override_budget.equals("E"))
							error_selected = "selected";
						else if(override_budget.equals("W")) 
							warning_selected = "selected";
						else if(override_budget.equals("N")) 	
							notApplicable_selected = "selected";
						else if(override_budget.equals("")) 	
							warning_selected = "selected";
			}
		
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(bean.getDept(dept_code)));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(classValue ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(acc_no));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(classValue ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(acc_no_desc));
            _bw.write(_wl_block25Bytes, _wl_block25);

				
					if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")) ){
				
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(all_bdgt));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(classValue ));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(addnl_bdgt));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block33Bytes, _wl_block33);

				  }
					if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) ){
				
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(classValue ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(all_bdgt));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(classValue ));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(addnl_bdgt));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(total_bdgt1));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(addnl_bdgt1));
            _bw.write(_wl_block40Bytes, _wl_block40);
 } 
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(classValue ));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(total_bdgt));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(classValue ));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(blocked_bdgt));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(classValue ));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(eff_dt_frm));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(classValue ));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(eff_dt_to));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(classValue ));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(error_selected));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(warning_selected));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(notApplicable_selected));
            _bw.write(_wl_block64Bytes, _wl_block64);

					y=cnt;
		}
		y++;

				for ( int j=y; j<10; j++ ) {
				if(j%2 ==0)
					classValue="QRYEVEN";
				else
					classValue="QRYODD";
	
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(j));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(j));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(bean.getDept("")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(classValue ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(j));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(j));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(classValue ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(j));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(j));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(classValue ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(j));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(j));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(j));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(classValue ));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(j));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(j));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(j));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(classValue ));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(j));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(j));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(classValue ));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(j));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(j));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(classValue ));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(j));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(j));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(j));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(classValue ));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(j));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(classValue ));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(j));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(j));
            _bw.write(_wl_block76Bytes, _wl_block76);
}
	
		size = 10;
		
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(index));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(size));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(bean.getFunctionId()));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(master_code));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(long_desc));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(eff_status));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(alResult1.size()));
            _bw.write(_wl_block88Bytes, _wl_block88);

		putObjectInBean(bean_id,bean,request);
		

            _bw.write(_wl_block89Bytes, _wl_block89);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.CommitmentCodeAdditionalDetails.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${po_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.Department.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${po_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.AccountNumber.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${po_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.AccountNumberDescription.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${po_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.AllocatedBudget.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${po_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.AdditionalBudget.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${po_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.BalanceBudget.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${po_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.BlockedBudget.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${po_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.EffectiveFrom.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${po_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.EffectiveTo.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${po_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.OverrideBudgetControl.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${po_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
