package jsp_servlet._est._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eST.*;
import eST.Common.*;
import eCommon.Common.*;
import java.util.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.lang.*;
import eST.IssueBean;
import java.util.ArrayList;
import java.util.HashMap;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __issuelistheader extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/IssueListHeader.jsp", 1720606690226L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<head>\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' ></link>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t<script language=\"javascript\" src=\"../../eST/js/StCommon.js\"></script>\n\t<script language=\"javascript\" src=\"../../eST/js/StTransaction.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eST/js/Issue.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n<style>\ntextarea {\n  resize: none;\n}\n</style>\n\t\n\t \n \t\t\n \t\t \n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t</head>\n\t<body onLoad=\"FocusFirstElement();GoBarcode();\">\n\t<form name=\"formIssueListHeader\" id=\"formIssueListHeader\">\n\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' height=\'50%\'>\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<tr>\n\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t<td colspan=6 align=left class=\'label\' colspan=2><input type=\'text\' name=\'barcode\' id=\'barcode\'  size=80 maxLength=100 value=\"\" onkeypress=\"callBarCodeBatchSearchforBarcode1(event,barcode,trn_type_barcode,parent.parent.frameIssueHeader.document.formIssueHeader.from_store_code,parent.parent.frameIssueHeader.document.formIssueHeader.to_store_code,this.form,\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\',\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\',\'IssueListHeader\',\'IssueListDetail\',\'IssueDetail\');\" ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" ></td>\t<!--Modified for IN:073577 increased size from 70 to 80 -->\t\t\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t<tr>\n\t\t\t<td class=label align=left>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t\t<td colspan=6 align=left class=\'label\' colspan=2>\n\t\t\t<input type=\"hidden\" name=\"item_desc_temp\" id=\"item_desc_temp\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" >\n\t\t\t\t <!-- Code Added for #incident 41572 start -->\n\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t<input type=text name=item_desc size=70 maxlength=60 onkeypress=\"callBarCodeBatchSearch(event,barcode,trn_type,parent.parent.frameIssueHeader.document.formIssueHeader.from_store_code,parent.parent.frameIssueHeader.document.formIssueHeader.to_store_code,this.form,\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\',\'IssueListHeader\',\'IssueListDetail\',\'IssueDetail\');\"    value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =">\n\t\t\t\t<input type=button name=\"item_search\" id=\"item_search\" class=\"button\" ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" onClick=\"callBarCodeBatchSearch(event,barcode,trn_type,parent.parent.frameIssueHeader.document.formIssueHeader.from_store_code,parent.parent.frameIssueHeader.document.formIssueHeader.to_store_code,this.form,\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\',\'IssueListHeader\',\'IssueListDetail\',\'IssueDetail\');\"  value=\'?\' ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" >";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t<input type=text name=item_desc size=70 maxlength=60 onkeypress=\"callBarCodeBatchSearch(event,item_desc,trn_type,parent.parent.frameIssueHeader.document.formIssueHeader.from_store_code,parent.parent.frameIssueHeader.document.formIssueHeader.to_store_code,this.form,\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" onClick=\"callBarCodeBatchSearch(event,item_desc,trn_type,parent.parent.frameIssueHeader.document.formIssueHeader.from_store_code,parent.parent.frameIssueHeader.document.formIssueHeader.to_store_code,this.form,\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t<!--  Code Added for #incident 41572 end-->\n\t\t\t\t<input type=\"hidden\" name=\"item_code\" id=\"item_code\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"Auth_status\" id=\"Auth_status\" value=\"1\"><!-- // added for GHl-CRF-0465 -->\n\t\t\t\t<b><span id=\"id_uom\">";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</span></b>\n\t\t\t\t<!-- Added by Rabbani#AMS-CRF-0068(49822) on 08-AUG-2014 -->\n\t\t\t\t&nbsp;\n\t\t\t<label id=\"id_min_stk_label\" style=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" >Min.Level:</label>\n\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t<label id=\"id_min_str_stk\" style=\"background-color:red;color:yellow; ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\"  ><b>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</b></label>\n\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t<label id=\"id_min_str_stk\" style=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" ><b>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t&nbsp;\n\t\t\t<label id=\"id_stk_rol_label\" style=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" >ROL:</label>\n\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t<label  id=\"id_stk_rol\" style=\"background-color:red;color:yellow;";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t<label  id=\"id_stk_rol\"  style=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =" \t\n\n\t\t\t<label class=\"label\" style = \"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\"><a name =\"iss_history\" id =\"iss_history\" class=\'gridLink\' href=\"javascript:viewIssueHistory();\"> <B>Issue History</B><a></label><!-- Added for MO-CRF-20166 href modified for IN19719-->\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t<td id=\"kit_template\"  class=\"label\" STYLE=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" colspan=\'2\' >";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =" \n\t\t\t\t\n\t\t&nbsp;&nbsp;<input type=\"text\" name=\"kit_template_uom\" id=\"kit_template_uom\" value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" size=\"10\"readonly>\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=label align=left width=80>";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</td>\n\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t<td class=\'label\' width=170>\n\t\t\t\t<select name=\'iss_uom_code\' id=\'iss_uom_code\' onchange = \"calculateConversion();\" onBlur=\"checkUOMConvFactor();\" ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =">\n\t\t\t\t\t<option>&nbsp;&nbsp;&nbsp;&nbsp;--- ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\t---&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t</option>\n\t\t\t\t</select><img src=\"../../eCommon/images/mandatory.gif\" align=center>\n\t\t\t</td>\n\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =":</td>\n\t\t\t<td class=\'label\'><label id=\"id_iss_uom_conv\" align=\"right\">";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</label></td>\n\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\t\n\t\t\t<td class=\'label\' width=170><select name=\'iss_uom_code\' id=\'iss_uom_code\' onchange = \"calculateConversion();\" onBlur=\"checkUOMConvFactor();\"  ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</select><img src=\"../../eCommon/images/mandatory.gif\" align=center></td>\n\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =":</td>\t\n\n\t\t\t<td class=\'label\' align=\"right\">&nbsp;&nbsp;&nbsp;<label id=\"id_iss_uom_conv\">";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\n\t\t\t<td  class=\"label\">";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="&nbsp;</td>\n\t\t\t<td class=\'label\'><input type=\"text\" name=\"iss_uom_qty\" id=\"iss_uom_qty\" size=10 maxlength=12 class=\"NUMBER\" onkeypress=\"return isValidNumber(this,event,7,";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 =");\"  onBlur=\"valueChange(this);checkDoubleFormat(this);calIssueQty();checkminmaxstatus();return CheckQuantity();\" value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 =">&nbsp;<img src=\"../../eCommon/images/mandatory.gif\" align=center></td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\'label\' align=\"left\">";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</td>\n\t\t\t<td class=\"label\"><input type=text name=item_qty id=item_qty size=10 maxlength=15 class=\"NUMBER\" value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" disabled>";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="<b><span id = \"uom_desc\" width=60>";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</span></b></td>&nbsp;&nbsp;\n\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 =":</td>\n\t\t\t<td class= \'label\' align=\"left\"><label id=\"id_stock_available\" align=\"right\">";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</label></td>\n\t\t\t<td class=\'label\' align=\'left\'><label id=\"id_item_unit_cost_label\" style=";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 =">";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 =":</label>\n\t\t\t<label id=\"id_item_unit_cost\" style=";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</label></td>\n\t\t\t<td align=left   class=\'label\'><label id=\"id_item_sal_value_label\" style=";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 =":&nbsp;</label><label id=\"id_item_sal_value\" style=";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="</label></td>\n\t\t</tr>\n\t\t <tr>\n\t\t\t<td class=label align=left>";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="</td>\n\t\t\t<td colspan=6 align=left class=\'label\'><textarea rows=2 cols=60 name=\"remarks\" onKeyPress=\"return false;\"  >";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="</textarea><input type=\"hidden\" name=\"remarks_code\" id=\"remarks_code\" value = \"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" >\n\t\t<input type=\'button\' class=\'BUTTON\' name=\'remark\' id=\'remark\' value=\'?\' onClick=\"searchRemarks(remarks_code,remarks);\" ><img id =\"remarks_mandatory\" src=\"../../eCommon/images/mandatory.gif\" align=center style =\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\"></td>\n\n \t\t<script>\n\t\t//alert(parent.parent.frameIssueHeader.document.formIssueHeader.trn_type.value );\n\t\tif(parent.parent.frameIssueHeader.document.formIssueHeader.trn_type.value==\"ISS\"){\n\t\t\tdocument.formIssueListHeader.remarks.disabled=false;\n\t\t\tdocument.formIssueListHeader.remark.disabled=false;\n\t\t}\n\t\tif(parent.parent.frameIssueHeader.document.formIssueHeader.trn_type.value==\"URG\"){\n\t\t\t//document.formIssueListHeader.remark.disabled=true;\n\t\t}\n\t\t</script>\n\t\t\t</tr>\n\t</table>\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"2\" width=\"100%\"> \n\t\t\t<tr>\n\t\t\t\t<!-- <td colspan = \'8\' class =\"label\">&nbsp;</td> -->\n\t\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t<td class=label align=left colspan=\'7\'><input type=button name=\"edit\" id=\"edit\" value=\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\' class=button onclick=\"editViewBatch();\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 =">\n\t\t<input type=button name=batchsearch value=\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\' class=button onclick=\"callBatchSearch();\"  ";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 =" >\n\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\t<input type=button name=\"apply\" id=\"apply\" value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\" class=button onclick= \" addToListforBarCode(\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="  \',parent.parent.frameIssueHeader.document.formIssueHeader.barcode_applicable1,\'IssueListHeader\',\'IssueListDetail\',\'IssueDetail\');\">\n\t\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" class=button onclick= \"calIssueQty(); addToListforBarCode(\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t<input type=button name=Cancel value=\'";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\' class=button onclick=\"cancel_me();\">\n\t\t\t<input class=\"button\" type=\"button\" name=\"ItemDetails\" id=\"ItemDetails\" value=\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\' onClick=\"ItemDetail();\" ";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="></td>\n\t\t</tr>\n\t</table>\n\t\t<input type=\"hidden\"\tname=\"stock_item_yn\" id=\"stock_item_yn\"\t\t\t\t\t\tvalue=\"Y\"><!-- Modified for IN073190 -->\n\t\t<input type=\"hidden\"\tname=\"store_code\" id=\"store_code\"\t\t\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\">\n\t\t<input type=\"hidden\"\tname=\"expiry_yn\" id=\"expiry_yn\"\t\t\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\">\n\t\t<input type=\"hidden\"\tname=\"doc_srl_no\" id=\"doc_srl_no\"\t\t\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\">\n\t\t<input type=\"hidden\"\tname=\"uom_code\" id=\"uom_code\"\t\t\t\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\">\n\t\t<input type=\"hidden\"\tname=\"index\" id=\"index\"\t\t\t\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\">\n\t\t<input type=\"hidden\"\tname=\"for_bin_to_store_hidden\" id=\"for_bin_to_store_hidden\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\">\n\t\t<input type=\"hidden\"\tname=\"iss_conv_fact\" id=\"iss_conv_fact\"\t\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\">\n\t\t<input type=\"hidden\"\tname=\"item_unit_cost\" id=\"item_unit_cost\"\t\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\">\n\t\t<input type=\"hidden\"\tname=\"set_flag\" id=\"set_flag\"\t\t\t\t\t\t\t\tvalue=\"\">\n\t\t<input type=\"hidden\"\tname=\"frm_store_qty_on_hand\" id=\"frm_store_qty_on_hand\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\">\n\t\t<input type=\"hidden\"\tname=\"frm_store_min_stk_level\" id=\"frm_store_min_stk_level\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\">\n\t\t<input type=\"hidden\"\tname=\"frm_store_max_stk_level\" id=\"frm_store_max_stk_level\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\">\n\t\t<input type=\"hidden\"\tname=\"frm_store_reorder_level\" id=\"frm_store_reorder_level\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\">\n\t\t<input type=\"hidden\"\tname=\"to_store_qty_on_hand\" id=\"to_store_qty_on_hand\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\">\n\t\t<input type=\"hidden\"\tname=\"frm_store_uom_desc\" id=\"frm_store_uom_desc\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\">\n\t\t<input type=\"hidden\"\tname=\"to_store_uom_desc\" id=\"to_store_uom_desc\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\">\n\t\t<input type=\"hidden\"\tname=\"to_store_min_stk_level\" id=\"to_store_min_stk_level\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\">\n\t\t<input type=\"hidden\"\tname=\"to_store_max_stk_level\" id=\"to_store_max_stk_level\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\">\n\t\t<input type=\"hidden\"\tname=\"to_store_reorder_level\" id=\"to_store_reorder_level\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\">\n\t\t<input type=\"hidden\"\tname=\"to_store_uom_code\" id=\"to_store_uom_code\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\">\n\t\t<input type=\"hidden\"\tname=\"to_store_code\" id=\"to_store_code\"\t\t\t\t\t\tvalue=\"\">\n\t\t<input type=\"hidden\"\tname=\"tmp_conv\" id=\"tmp_conv\"\t\t\t\t\t\t\t\tvalue=\"\">\n\t\t<input type=\"hidden\"\tname=\"frm_conv_fact\" id=\"frm_conv_fact\"\t\t\t\t\t\tvalue=\"\">\n\t\t<input type=\"hidden\"\tname=\"kit\" id=\"kit\"\t\t\t\t\t\t\t\t\tvalue=\"\">\n\t\t<input type=\"hidden\"\tname=\"iss_uom_conv\" id=\"iss_uom_conv\"\t\t\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\">\n\t\t<input type=\"hidden\"\tname=\"iss_uom_qty_chk\" id=\"iss_uom_qty_chk\"\t\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\">\n\t\t<input type=\"hidden\"\tname=\"phy_inv_id\" id=\"phy_inv_id\"\t\t\t\t\t\t\tvalue=\"\">\n\t\t<input type=\"hidden\"\tname=\"doc_qty\" id=\"doc_qty\"\t\t\t\t\t\t\t\tvalue=\"\">\n\t\t<input type=\"hidden\"\tname=\"lang_id\" id=\"lang_id\"\t\t\t\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\">\n\t\t<input type=\"hidden\"\tname=\"mode\" id=\"mode\"\t\t\t\t\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\">\n\t\t<input type=\"hidden\"\tname=\"rem_trans_type\" id=\"rem_trans_type\"\t\t\t\t\t\tvalue=\"ISS\">\n\t\t<input type=\"hidden\"\tname=\"kit_item_yn\" id=\"kit_item_yn\"\t\t\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\">\n\t\t<input type=\"hidden\"\tname=\"SQL_ST_TRN_REMARKS_LOOKUP_SELECT\" id=\"SQL_ST_TRN_REMARKS_LOOKUP_SELECT\"\t\tvalue=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\">\n\t\t<input type=\"hidden\"\tname=\"bean_trans_type_1\" id=\"bean_trans_type_1\"\t\t\t\t\t\tvalue=\'";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\'>\n\t\t<input type=\"hidden\" name=\"from_multiples\" id=\"from_multiples\"\t\t\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\">\n\t\t<input type=\"hidden\" name=\"to_multiples\" id=\"to_multiples\"\t\t\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\">\n\t\t<input type=\"hidden\" name=\"batch_multiples\" id=\"batch_multiples\"\t\t\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\">\n\t\t<input type=\"hidden\" name=\"issue_uom_multiples\" id=\"issue_uom_multiples\"\t\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\">\n\t\t<input type=\"hidden\" name=\"barcode_scanned_yn\" id=\"barcode_scanned_yn\"\t\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\">\n\t\t\n\t\t\n<!-- \t/**\n\t* @Name - Mahesh\n\t* @Date - 20/01/2010\n\t* @Inc# - IN015496\n\t* @Desc - Code added to accept decimal values dynamically.\n\t*/\n\n -->\t\n\t\t<input type=\"hidden\" name=\"dec_allowed_yn\" id=\"dec_allowed_yn\" value=\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\">\n\t\t<input type=\"hidden\" name=\"no_of_decimals\" id=\"no_of_decimals\" value=\"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\">\n\t\t<input type=\"hidden\" name=\"no_of_decimals_for_cost\" id=\"no_of_decimals_for_cost\" value=\'";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\'>\n\n\n\t\t<input type=\"hidden\"    name=\"trn_type\" id=\"trn_type\"\t\t\t\t\t\t\t    value=\'";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\' >\n\t\t<input type=\"hidden\"    name=\"BARCODE_YN\" id=\"BARCODE_YN\"\t\t\t\t\t\t\t    value=\'";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\' >\n\t\t<input type=\"hidden\"    name=\"barcode_applicable\" id=\"barcode_applicable\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\" >\n\t\t<input type=\"hidden\"    name=\"bar_or_item_code\" id=\"bar_or_item_code\"\t\t\t\t\t\tvalue=\"\" >\n\t\t<input type=\"hidden\"    name=\"billable_item_yn\" id=\"billable_item_yn\"\t\t\t\tvalue=\"\" ><!--dummy-->\n\t\t<input type=\"hidden\"    name=\"sale_req_qty\" id=\"sale_req_qty\"\t\t\t\tvalue=\"\" ><!--dummy-->\n        <input type=\"hidden\"  name=\"kit_temp_code\" id=\"kit_temp_code\"\t          value=\"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\" >\n\t\t<input type=\"hidden\"  name=\"usage_type\" id=\"usage_type\"\t                    value=\"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\" >\n\t\t<input type=\"hidden\"  name=\"noofbatchesforbarcode\" id=\"noofbatchesforbarcode\"\tvalue=\"1\" >\n\t\t\n\t\t<!--  Added By Rabbani #Inc no:27060 (MO-CRF-20048) on 17-Feb-2014 -->\n\t\t<input type=\"hidden\" name=\"iss_item_hold_yn\" id=\"iss_item_hold_yn\"\t\t value=\"";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\">\n\t\t<input type=\"hidden\" name=\"iss_item_hold_chk\" id=\"iss_item_hold_chk\"\t\t value = \"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\">\n\t\t<input type=\"hidden\" name=\"iss_item_hold_qty\" id=\"iss_item_hold_qty\"\t\t value = \"";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\">\n\t\t<!-- ends -->\n\t\t<input type=\"hidden\"    name=\"site\" id=\"site\"\t value=\"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\"><!--Added against GHL-CRF-0413 -->\n\t\t<input type=\"hidden\"    name=\"trn_type_barcode\" id=\"trn_type_barcode\"\t value=\"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\"><!--Added against GHL-CRF-0413.2-US002 -->\n\t\t<input type=\"hidden\"    name=\"auth_qty\" id=\"auth_qty\"\t value=\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\"><!--Added against GHL-CRF-0413.2-US002 -->\n\t\t<input type=\"hidden\"   name=\"auth_qty_1\" id=\"auth_qty_1\"  value =\"\"><!-- Added against GHL-CRF-0465-->\n\t\t\t<input type=\"hidden\"   name=\"issue_qty_1\" id=\"issue_qty_1\"  value =\"\"><!-- Added against GHL-CRF-0465-->\n\t\t<input type=\"hidden\"   name=\"issue_history_durn\" id=\"issue_history_durn\"  value =\"";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\"><!-- Added against MOD-CRF-20166-->\n\t</form>\n\t<script>\n\tif(parent.parent.frameIssueHeader.document.formIssueHeader.trn_type!= null)\n\t{\n\t\tif(parent.parent.frameIssueHeader.document.formIssueHeader.trn_type.value !=null)\n\t\t{\n\t\t\tif(parent.parent.frameIssueHeader.document.formIssueHeader.trn_type.value == \"URG\" && document.formIssueListHeader.item_code.value == \"\"){\n\t\t\t\tdocument.formIssueListHeader.item_search.disabled=false;\n\t\t\t}\n\t\t\telse{\n\t\t\t\tdocument.formIssueListHeader.item_search.disabled=true;\n\t\t\t}\n\t\t }\n\t}\n\tif(document.formIssueListHeader.item_search.disabled==false)\n\t\tdocument.formIssueListHeader.item_search.focus();\n\t\t</script>\n";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\n</body>\n</html>\n<script>\nSetitemdesc(document.formIssueListHeader.item_desc_temp);\n</script>\n\n";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );
	
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
/*
--------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name				Rev.Date   		Rev.By 				Description
--------------------------------------------------------------------------------------------------------------------------------
22/06/2020	IN073190		B Haribabu          22/06/2020     	                    ML-BRU-SCF-2033
07/08/2020  IN073577        B Haribabu          07/08/2020                          MMS-DM-CRF-0174.2
17/05/2021                  Chandrashekar Arram                                     MO-CRF-20166
-------------------------------------------------------------------------------------------------------------------------------
*/ 

            _bw.write(_wl_block1Bytes, _wl_block1);
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

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			=	 (String)session.getAttribute("LOCALE");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	IssueBean bean						=		(IssueBean)getBeanObject( "issueBean","eST.IssueBean", request  );
	bean.setLanguageId(locale); 

	String bean_id = "issueBean";
	String bean_name = "eST.IssueBean";
	//Added for GHL-CRF-0413 starts
	boolean site=bean.isSite_spec_yn();
	String auth_qty = "";//Added against GHL-CRF-0413.2-US002
	System.out.println("after setting in bean===="+site);
	//Added for GHL-CRF-0413 ends

	//String stButtonLegend				=		"  Add  ";
	String stButtonLegend				=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels");
	String index						=		bean.checkForNull(request.getParameter("index"),"-1");
	String mode							=		bean.checkForNull(request.getParameter("mode"),"1");
	String disabled						=		"";
	String disable_add					=		"disabled";
	if(mode != null && mode.equals("2")) {
		disabled						=		"disabled";
	}
	String doc_srl_no					=		bean.checkForNull(request.getParameter("doc_srl_no"),"-1");
	String item_code					=		"";
	String item_desc					=		"";
	String uom							=		"";
	String stock_uom_desc				=		"";
	String uom_code						=		"";
	String stock_available				=		"";
	String item_unit_cost				=		"";
	String item_qty						=		"";
	String for_bin_to_store_hidden		=		"";
	String item_sal_value				=		"";
	String remarks						=		"";
	String remarks_code					=		"";
	String expiry_yn					=		"";
	String codeDisabled					=		"";
	String stock_item_yn				=		"";
	String store_code					=		"";
	String iss_uom_code					=		"";
	String iss_uom_qty					=		"";
	String iss_conv_fact				=		"";
	String frm_store_qty_on_hand		=		"";
	String frm_store_min_stk_level		=		"";
	String frm_store_max_stk_level		=		"";
	String frm_store_reorder_level		=		"";
	String to_store_qty_on_hand			=		"";
	String to_store_min_stk_level		=		"";
	String to_store_max_stk_level		=		"";
	String to_store_reorder_level		=		"";
	String to_store_uom_code			=		"";
	String gen_uom_code					=		"";
	String frm_store_uom_desc			=		"";
	String to_store_uom_desc			=		"";
	String display_flag					=		"visibility:hidden";
	String imgMandatory					=		"visibility:hidden";
	String kit_template_uom				=		"";
	String kit_item_yn					=		"";
	String iss_uom_conv_text			=		"";
	String	display_style				=			 "display:none";
	String from_multiples				=		"1";
	String to_multiples					=		"1";
	String batch_multiples				=		"1";
	String issue_uom_multiples			=		"1";
	String kit_temp_code                =        "";
	String usage_type                   =        "";  
    
  //Added By Rabbani #Inc no:27060 (MO-CRF-20048) on 17-Feb-2014
	String iss_item_hold_yn              =        "N";
	String iss_item_hold_chk             =        "N";
	String iss_item_hold_qty             =        "";
	//ends	
	
	//Added by Rabbani#AMS-CRF-0068(49822) on 12-AUG-2014
	String min_stk_flag					=		"visibility:hidden";
	String rol_flag					    =		"visibility:hidden";
	boolean min_stk                     =       false;
	boolean rol_stk                     =       false;
	String	iss_history_style		=			 "visibility:hidden";//Adding start for MOD-CRF-20166
	String issue_history_durn = bean.getIssueHistoryDurn();
		if(issue_history_durn ==null || issue_history_durn.equals("0"))
		 issue_history_durn ="";
	//adding end for MO-CRF-20166
	
 	/**
	* @Name - Mahesh
	* @Date - 20/01/2010
	* @Inc# - IN015496
	* @Desc - No of Decimal is brought here in order to pass a value to setNumber Function and isValidNumber Function.
	*/

	int no_of_decimals					=			bean.getNoOfDecimals();

		
	String  trn_type  = "URG";
	String  trn_type_barcode  = bean.checkForNull(bean.getTrn_type(), "URG");//Added against GHL-CRF-0413.2-US002
	System.out.println("trn_type_barcode--->"+trn_type_barcode);
	String	BARCODE_YN = request.getParameter("BARCODE_YN")==null?"FALSE":request.getParameter("BARCODE_YN");
	String  barcode_applicable = "";
	String   editqty_appl     =	bean.checkForNull(bean.getBarcodeEditQtyAppl(),"N");
	String Qty_disabled = "";
	String mode1= bean.getMode();
	//if(mode1.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")) && BARCODE_YN.equals("TRUE") && editqty_appl.equals("N")) Modified for GHL-CRF-0413
	if(mode1.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")) && BARCODE_YN.equals("TRUE") && editqty_appl.equals("N") && !site){
		Qty_disabled  = "disabled"	;
	}


	//String to_store_code				=		request.getParameter("to_store_code");
	String stModifyLegend				=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels");
	if(!index.equals("-1")){
		HashMap hmRecord = new HashMap();

		//HashMap hmRecord				=		bean.getDtlRecord(Integer.parseInt(index));

		if (BARCODE_YN.equals("TRUE")){
		hmRecord		=		(HashMap)bean.getDtlRecordforBarCode(Integer.parseInt(index));
		barcode_applicable = "Y";
		}
		else{
		hmRecord		=	    bean.getDtlRecord(Integer.parseInt(index));
		barcode_applicable = "N";
		}

		//System.out.println("hmRecord===119==>"+hmRecord);



 	/**
	* @Name - Mahesh
	* @Date - 12/01/2010
	* @Inc# - IN015496
	* @Desc - Making No.of Decimals to zero if Decimal is not allowed by the item.
	*/
		item_code						=		(String)hmRecord.get("item_code");
		if((bean.getAllowDecimalsYN(item_code)).equals("N")){
			no_of_decimals = 0;
		}
		
		stButtonLegend					=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels");
		doc_srl_no						=		(String)hmRecord.get("doc_srl_no");
		item_desc						=		(String)hmRecord.get("item_desc");
		uom								=		(String)hmRecord.get("uom_desc");
		stock_uom_desc					=		(String)hmRecord.get("stock_uom_desc");
		uom_code						=		(String)hmRecord.get("uom_code");
		stock_available					=		bean.setNumber((String)hmRecord.get("stock_available"),no_of_decimals);
		item_unit_cost					=		(String)hmRecord.get("item_unit_cost");
		for_bin_to_store_hidden			=		(String)hmRecord.get("for_bin_to_store_hidden") ;
		item_sal_value					=		(String)hmRecord.get("item_cost_value");
		//remarks						=		(String)hmRecord.get("remarks");
		remarks							=		bean.checkForNull((String)hmRecord.get("remarks"),"");
		remarks_code					=	bean.checkForNull((String)hmRecord.get("remarks_code"),"");		
		
		expiry_yn						=		(String)hmRecord.get("expiry_yn");
		codeDisabled					=		"disabled";
		disable_add						=		"";
		stock_item_yn					=		(String)hmRecord.get("stock_item_yn");
		store_code						=		(String)hmRecord.get("store_code");
		iss_uom_code					=		(String)hmRecord.get("issue_uom");
		iss_conv_fact					=		(String)hmRecord.get("issue_uom_conv");
		iss_uom_conv_text				=		(String)hmRecord.get("iss_uom_conv_text");
		iss_uom_qty						=		bean.setNumber((String)hmRecord.get("issue_uom_qty"),no_of_decimals);
		//auth_qty						=		bean.setNumber((String)hmRecord.get("issue_uom_qty"),no_of_decimals);//Un used Variable
		from_multiples					=		bean.checkForNull((String)hmRecord.get("from_multiples"),"1");
		to_multiples					=		bean.checkForNull((String)hmRecord.get("to_multiples"),"1");
		batch_multiples					=		bean.checkForNull((String)hmRecord.get("batch_multiples"),"1");
		issue_uom_multiples				=		bean.checkForNull((String)hmRecord.get("issue_uom_multiples"),"1");
		item_qty						= ""+	Double.parseDouble((String)hmRecord.get("issue_uom_qty"))*Double.parseDouble((String)hmRecord.get("issue_uom_conv"));
		if((bean.getAllowDecimalsYN(item_code)).equals("Y")){
			item_qty						=		bean.setNumber(item_qty,no_of_decimals);
		}else{
			item_qty						=		bean.setNumber(item_qty,0);
		}
		kit_template_uom				=		bean.checkForNull((String)hmRecord.get("kit_template_uom"),"");
		kit_temp_code                   =       bean.checkForNull((String)hmRecord.get("kit_temp_code"),""); //01/08/12
		usage_type                      =       bean.checkForNull((String)hmRecord.get("usage_type"),""); //17/09/12
		kit_item_yn						=		bean.checkForNull((String)hmRecord.get("kit_item_yn"),"N");
		if(kit_item_yn.equals("Y")){
		display_style				=			 "display:inline";
		}else{
		display_style				=			 "display:none";
		}
		frm_store_uom_desc				=		bean.getShortDesc(item_code,store_code);
		to_store_uom_desc				=		bean.getShortDesc(item_code,(String)request.getParameter("to_store_code"));

		//HashMap hmMinMaxRecord			=		bean.getMinMaxRecord(Integer.parseInt(index));
		HashMap hmMinMaxRecord = new HashMap();

		if (BARCODE_YN.equals("TRUE")){
		hmMinMaxRecord=bean.getMinMaxRecordforBarcode(Integer.parseInt(index));
		}else{
		hmMinMaxRecord=bean.getMinMaxRecord(Integer.parseInt(index));
		}

		//frm_store_qty_on_hand			=		(String)hmRecord.get("stock_available"); // Availabe Qty has to be taken based on document no without commited qty , hmMinMaxRecord.get("frm_store_qty_on_hand") will not give doc no based available qty
		frm_store_qty_on_hand			=		(String)hmMinMaxRecord.get("frm_store_qty_on_hand"); // Availabe Qty has to be taken based on document no without commited qty , hmMinMaxRecord.get("frm_store_qty_on_hand") will not give doc no based available qty
		frm_store_min_stk_level			=		bean.checkForNull((String)hmMinMaxRecord.get("frm_store_min_stk_level"),"0");
		frm_store_max_stk_level			=		(String)hmMinMaxRecord.get("frm_store_max_stk_level");
		frm_store_reorder_level			=		bean.checkForNull((String)hmMinMaxRecord.get("frm_store_reorder_level"),"0");
		to_store_qty_on_hand			=		(String)hmMinMaxRecord.get("to_store_qty_on_hand");
		to_store_min_stk_level			=		(String)hmMinMaxRecord.get("to_store_min_stk_level");
		to_store_max_stk_level			=		(String)hmMinMaxRecord.get("to_store_max_stk_level");
		to_store_reorder_level			=		(String)hmMinMaxRecord.get("to_store_reorder_level");
		//to_store_uom_code				=		bean.getToStoreUomCode(item_code,to_store_code);
		gen_uom_code					=		bean.getGenItemUOM(item_code);

		if(((String)bean.getAccessCostDetails()).equals("Y"))
			display_flag				=		"visibility:visible";
			
			//Added By Rabbani #Inc no:27060 (MO-CRF-20048) on 17-Feb-2014
		iss_item_hold_yn					=		bean.checkForNull((String)hmRecord.get("iss_item_hold_yn"),"Y");
		iss_item_hold_chk					=		bean.checkForNull((String)hmRecord.get("iss_item_hold_chk"),"N");
		iss_item_hold_qty                   =       bean.checkForNull((String)hmRecord.get("iss_item_hold_qty"),"");
		
		if(iss_item_hold_qty.equals(""))
		//iss_item_hold_qty					=		bean.setNumber((String)hmRecord.get("issue_uom_qty"),no_of_decimals);
		iss_item_hold_qty					=	    bean.setNumber((String)hmRecord.get("authorized_item_qty"),no_of_decimals);
		
		//ends
		
		//Added by Rabbani#AMS-CRF-0068(49822) on 11-AUG-2014 
		if(bean.getMin_Rol_yn(bean.getLoginById(),store_code)){
		 if(!frm_store_min_stk_level.equals("0")){
		   if ((Double.parseDouble(stock_available) - Double.parseDouble(iss_uom_qty))  <  Double.parseDouble(frm_store_min_stk_level)){
	    	   min_stk = true;
	        }
		   min_stk_flag = "visibility:visible"; 
		   } 
		   if(!frm_store_reorder_level.equals("0")){
	     if ((Double.parseDouble(stock_available) - Double.parseDouble(iss_uom_qty))  <  Double.parseDouble(frm_store_reorder_level)){
	    	   rol_stk = true;
	       }
	     rol_flag	   = "visibility:visible";
		  }
		} //ends
	}

/**
 * @Name - Priya
 * @Date - 18/05/2010
 * @Inc# - 
 * @Desc -  To get no of decimals for cost and assign it to 'no_of_decimals_for_cost' hidden field 
 */
	String noOfDecimalsForCost=bean.getNoOfDecimalsCost();
	//Added by sakti against ML-BRU-SCF-0963[INC#42099]	
			item_desc = item_desc.replaceAll(" ","%20");
			item_desc = java.net.URLEncoder.encode(item_desc,"UTF-8");
			item_desc = item_desc.replaceAll("%2520","%20");
		//Added ends
		if(!item_desc.equals("") && !issue_history_durn.equals(""))//Added for MO-CRF-20166
	           iss_history_style          =            "visibility:visible";//Added for MOD-CRF-20166		 


 	
            _bw.write(_wl_block9Bytes, _wl_block9);
 if(site){//Added for GHL-CRF-0413 starts
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(codeDisabled));
            _bw.write(_wl_block14Bytes, _wl_block14);
} //Added for GHL-CRF-0413 ends
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(item_desc));
            _bw.write(_wl_block17Bytes, _wl_block17);
 if(site){ 
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(item_desc));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(codeDisabled));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(codeDisabled));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(bean.getImage("M")));
            _bw.write(_wl_block25Bytes, _wl_block25);
}else{ 
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(item_desc));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(codeDisabled));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(codeDisabled));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(bean.getImage("M")));
            _bw.write(_wl_block25Bytes, _wl_block25);
} 
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(stock_uom_desc));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(min_stk_flag));
            _bw.write(_wl_block31Bytes, _wl_block31);
if(min_stk){ 
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(min_stk_flag));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(frm_store_min_stk_level));
            _bw.write(_wl_block34Bytes, _wl_block34);
}else{ 
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(min_stk_flag));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(frm_store_min_stk_level));
            _bw.write(_wl_block34Bytes, _wl_block34);
} 
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(rol_flag));
            _bw.write(_wl_block38Bytes, _wl_block38);
if(rol_stk) {
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(rol_flag));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(frm_store_reorder_level));
            _bw.write(_wl_block34Bytes, _wl_block34);
}else{ 
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(rol_flag));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(frm_store_reorder_level));
            _bw.write(_wl_block34Bytes, _wl_block34);
} 
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(iss_history_style));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(display_style));
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(kit_template_uom));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);

			if(!stButtonLegend.equals(stModifyLegend)){
		
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(codeDisabled));
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(iss_uom_conv_text));
            _bw.write(_wl_block51Bytes, _wl_block51);
}else{
		
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(codeDisabled));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(bean.getPur_uom_code_Modify_List(gen_uom_code,iss_uom_code,item_code)));
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(iss_uom_conv_text));
            _bw.write(_wl_block51Bytes, _wl_block51);
}
            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(no_of_decimals));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(iss_uom_qty));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(Qty_disabled));
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(item_qty));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(bean.getImage("M")));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(uom));
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(stock_available));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(display_flag));
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(display_flag));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(item_unit_cost));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(display_flag));
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(display_flag));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(item_sal_value));
            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(remarks));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(remarks_code));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(imgMandatory));
            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(codeDisabled));
            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf( BARCODE_YN.equals("TRUE") && !site && mode1.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))?codeDisabled:""));
            _bw.write(_wl_block77Bytes, _wl_block77);
if(site){//Added for GHL-CRF-0413.2 starts 
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(stButtonLegend));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block80Bytes, _wl_block80);
}else{ //Added for GHL-CRF-0413.2 starts
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(stButtonLegend));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block80Bytes, _wl_block80);
} 
            _bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block83Bytes, _wl_block83);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(disable_add));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(expiry_yn));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(doc_srl_no));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(uom_code));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(index));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(for_bin_to_store_hidden));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(iss_conv_fact));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(item_unit_cost));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(frm_store_qty_on_hand));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(frm_store_min_stk_level));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(frm_store_max_stk_level));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(frm_store_reorder_level));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(to_store_qty_on_hand));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(frm_store_uom_desc));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(to_store_uom_desc));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(to_store_min_stk_level));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(to_store_max_stk_level));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(to_store_reorder_level));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(to_store_uom_code));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(iss_conv_fact));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(iss_uom_qty));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(kit_item_yn));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf( eST.Common.StRepository.getStKeyValue("SQL_ST_TRN_REMARKS_LOOKUP_SELECT")));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(bean.checkForNull(bean.getTrnTypeForRemarks(bean.checkForNull(bean.getDoc_no(),"")),"")));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(from_multiples));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(to_multiples));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(batch_multiples));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(issue_uom_multiples));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(bean.checkForNull(request.getParameter("barcode_scanned_yn"),"N")));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(bean.getAllowDecimalsYN(item_code)));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(no_of_decimals));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(noOfDecimalsForCost));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(trn_type));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(BARCODE_YN));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(barcode_applicable));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(kit_temp_code));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(usage_type));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(iss_item_hold_yn));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(iss_item_hold_chk ));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(iss_item_hold_qty ));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(site));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(trn_type_barcode));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(auth_qty));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(issue_history_durn));
            _bw.write(_wl_block131Bytes, _wl_block131);
 
	putObjectInBean("issueBean",bean,request);

            _bw.write(_wl_block132Bytes, _wl_block132);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.BarcodeId.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.item.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.KitTemplateUOM.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.IssueUOM.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.ConvFactorRule.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.ConvFactorRule.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.IssueUOMQuantity.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Quantity.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.AvailableQty.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Cost.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Value.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.Edit/View.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.BatchSearch.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.StockLevel.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
