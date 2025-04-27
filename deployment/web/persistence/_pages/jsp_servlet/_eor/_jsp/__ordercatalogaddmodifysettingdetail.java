package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eOR.*;
import eOR.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __ordercatalogaddmodifysettingdetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator , javax.servlet.SingleThreadModel
{

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
        if (sci.isResourceStale("/eor/jsp/OrderCatalogAddModifySettingDetail.jsp", 1729940138000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<!--this is for futher simulteanous user -->\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\n\t\n\t<script language=\"javascript\" src=\"../js/OrCommonFunction.js\"></script>\n\t<script language=\"javascript\" src=\"../js/OrderCatalog.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n\n\n<!-- Before onLoad of the page this funtion was called \'ptClsSettingDisableInPH();\' now it is removed by Archana Dhal on 6/2/2010 related to the IN021612. -->\n<body  OnMouseDown=\"CodeArrest()\"; onKeyDown=\"lockKey()\" onLoad=\"\">\n<!--   -->\n<form name=\'detailUpperForm\' id=\'detailUpperForm\' onMouseDown=\"CodeArrest()\"  onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<table class=\'grid\' width=\'100%\'>\n\n  <tr>\n\t<td class=\"COLUMNHEADER\"  nowrap>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t<td class=\"COLUMNHEADER\"  nowrap>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t<td class=\"COLUMNHEADER\" nowrap>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t<td class=\"COLUMNHEADER\"  nowrap style=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n    <td class=\"COLUMNHEADER\"  nowrap>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t<td class=\"COLUMNHEADER\"  nowrap style = \"bottom-margin:0;display:none\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n  </tr>\n\n\n<tr>\n   <td nowrap class=\'gridData\' width=\'15%\' >";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n   <INPUT TYPE=\"hidden\" name=\"patient_class0\" id=\"patient_class0\" value=\"*A\">\n\n\n\t<!--Applicability SuperSeding all the rules -->\n\n\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\n\n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\n\n\t  ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="<!--ML-MMOH-SCF-2542  -->\n\t   <td class=\"gridData\"><SELECT name=\"setting_applicability0\" id=\"setting_applicability0\"  ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" onchange=\'parent.parent.parent.chkApplSetting(this,\"0\",\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\");\'><!--ML-MMOH-SCF-2542  -->\n\t    <option value=\'A\' ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</option>\n\t    <option value=\'X\' ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</option>\n\t\t</SELECT>\n\t\t</td>\n\n\n\n\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\n    <!-- AGE GROUP CODE -->\n\n\t   ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n        <td  class=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' nowrap><SELECT ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" NAME=\"age_group_code0\"><option value=\"\">--- ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" ---</option>\n        ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</SELECT></td>\n\n   <td  class=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' nowrap><input type=text name=\'qty_value0\' id=\'qty_value0\' size=\'12\' maxlength=\'12\'  class=\"NUMBER\" onKeyPress=\'return(checkValid(this,event,6,5))\' onBlur=\"quantityCheck(this);\" ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" ></td> ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\n   <td  class=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' nowrap style=";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =">\n   ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n   <input type=text name=\'qty_uom0\' id=\'qty_uom0\' size=\'3\' maxlength=\'3\'\n   ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n   value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" >\n   \t</td>\n\n\n\t<!-- FREQ CODE -->\n\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n   <td  class=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =" NAME=\"freq_code0\" onchange=\'parent.parent.parent.getDurnType(this,\"0\")\'><option value=\"\">--- ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =" ---</option>\n\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</SELECT></td>\n\n\n\t<!-- Code to Build Durn Legend -->\n\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\n\n    <!-- Durn Val/Durn Desc -->\n \t<td  class=\"gridData\" nowrap>\n\t<input type=\"text\" name=\"durn_value0\" id=\"durn_value0\" size=\'3\' maxlength=\'3\'\tclass=\"number\"\t onBlur=\"OrCheckPositiveNumber(this);parent.parent.parent.chkMaxDurn(\'0\',this)\" ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\t\n\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\tvalue=\"\"\n\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\t\t\tvalue=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\"\n\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n>/<input type=\"text\"   disabled name=\"durn_desc0\" id=\"durn_desc0\"\t size=\'3\' \n\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\n\t\t></td>\n\t<input type=\"hidden\" name=\"durn_type0\" id=\"durn_type0\"\t\t\n\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 =">\n\n<!-- \t<td align=\"center\" class=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' width=\'20%\' nowrap id=\"durn_type_td0\">&nbsp;";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</td>\n\t<input type=\"hidden\" name=\"durn_type0\" id=\"durn_type0\" value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n\t<input type=\"hidden\" name=\"durn_value0\" id=\"durn_value0\" value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n\t<input type=\"hidden\" name=\"durn_desc0\" id=\"durn_desc0\" value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\"> -->\n\n   <!-- Code for Maximum Duration Type Options-->\n\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\n    <td  class=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' ><input type=text name=\'max_durn_value0\' id=\'max_durn_value0\' size=\'3\' maxlength=\'3\'  class=\"NUMBER\" onBlur=\"OrCheckPositiveNumber(this);parent.parent.parent.chkEnteredMaxVal(this,\'0\');\" ";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 =" ><SELECT ";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 =" NAME=\"max_durn_type0\" onchange=\'\'><option value=\'\'>--- ";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 =" ---</option>\n\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\t\t\n\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t</SELECT></td>\n\n\n\n    <td  class=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\'  nowrap>\n\t<SELECT name=\"chk_for_max_durn_action0\" id=\"chk_for_max_durn_action0\"  ";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="  onchange=\'parent.parent.parent.chkAction(this,\"0\")\'>\n\t<option value=\'\'>--- ";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 =" ---</option>\t\n\t<option value=\"W\" \n\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 =" ";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 =">Warn</option>\n\t<option value=\"R\"\n\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</option>\n\t<option value=\"A\"\n\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="</option>\n\n\t</SELECT>\n\t</td>\n\n\t<!-- Code to Chk athu level Updation -->\n\n    <td  class=\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\' nowrap style = \"bottom-margin:0;display:none\"><input type=text name=\'ord_auth_level0\' id=\'ord_auth_level0\' size=\'1\' maxlength=\'1\'\n\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\tonBlur=\"OrCheckPositiveNumber(this);parent.parent.parent.chkSecurityLevel(this)\" value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\" ></td>\n\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n    <td align=\"center\" name=\"msg_td0\" id=\"msg_td0\" class=\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\' nowrap><A name=\'msg0\' HREF=\'javascript:parent.parent.parent.showMsgDialog(\"0\")\'>";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="</A></td>\n\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t<td align=\"center\" name=\"msg_td0\" id=\"msg_td0\" class=\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\' ></td>\n\t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t<INPUT TYPE=\"hidden\" name=\"prompt_msg0\" id=\"prompt_msg0\" value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\" nowrap>\n  </tr>\n\n\t";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\n\n\n<!-----------RECORDS FROM DATABASE--------------------->\n\n\n\n\n\n<INPUT TYPE=\"hidden\" name=\"noOfRecords\" id=\"noOfRecords\" value=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\">\n\n";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\n\n\n<tr>\n   <td  nowrap class=\'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\'>";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="</td>\n   <INPUT TYPE=\"hidden\" name=\"patient_class";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\" id=\"patient_class";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\" value=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\">\n\n\n\n   ";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="<!--ML-MMOH-SCF-2542  -->\n\t<td class=\'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\'><SELECT name=\"setting_applicability";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\" id=\"setting_applicability";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\" onchange=\'parent.parent.parent.chkApplSetting(this,\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\",\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\")\' ";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="><!--ML-MMOH-SCF-2542  -->\n   <option value=\'X\' ";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="</option>\n   <option value=\'A\' ";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="</option>\n   </SELECT>\n   </td>\n\n\n\n  ";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\n  <!-- This Code to get Age Group combo take care the selected values by client in prevoius visit to  the page-->\n\n\t";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\n\n\t<td class=\'";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\' nowrap><SELECT name=\"age_group_code";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\" id=\"age_group_code";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\" ";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 =" ><option value=\"\">--- ";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="</SELECT></td>\n\n  <td  class=\'";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\' nowrap><input type=text name=\'qty_value";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\' id=\'qty_value";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\' size=\'12\' maxlength=\'12\'  class=\"NUMBER\" onKeyPress=\'return(checkValid(this,event,6,5))\' onBlur=\"quantityCheck(this);\" ";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\n\n  <td align=\"center\" class=\'";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 =" >\n  ";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n  <input type=text name=\'qty_uom";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\' id=\'qty_uom";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\' size=\'3\' maxlength=\'3\' nowrap\n  ";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\" >\n  \n </td>\n\n\n<!-- This Code to get Frequency combo take care the selected values by client in prevoius visit to  the page-->\n\n\t";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\n\n\n\t<td  class=\'";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\' nowrap><SELECT name=\"freq_code";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\" id=\"freq_code";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 =" onchange=\'parent.parent.parent.getDurnType(this,\"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\")\'><option value=\"\">--- ";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="</SELECT></td>\n\n\t<!-- Code to Build Durn Legend depending upon values Entered -->\n\t";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\n\n\t<!-- Durn Val/Durn Desc -->\n \t<td nowrap class=\'";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\'>\n\t<input type=\"text\" name=\"durn_value";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\" id=\"durn_value";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\" size=\'3\' maxlength=\'3\'\tclass=\"number\" \tonBlur=\"OrCheckPositiveNumber(this);parent.parent.parent.chkMaxDurn(\'";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\',this)\" ";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\n\t>/<input type=\"text\"   disabled name=\"durn_desc";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\" id=\"durn_desc";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\"\t size=\'3\' \t\n\t\t";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\"";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="> </td>\n\t<input type=\"hidden\" name=\"durn_type";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\" id=\"durn_type";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 =">\n\n\n\t<!-- Code for Maximum Duration Type Options-->\n\n\t";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\'>\n\t<input type=text name=\'max_durn_value";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\' id=\'max_durn_value";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\' size=\'3\' maxlength=\'3\' class=\"NUMBER\"\n   onBlur=\"OrCheckPositiveNumber(this);parent.parent.parent.chkEnteredMaxVal(this,\'";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\');\"\n\t";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="  \n\t\t";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\n\t\t><SELECT name=\"max_durn_type";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\" id=\"max_durn_type";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 =" onchange=\'\'><option value=\"\">--- ";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 =" ---</option>";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="</SELECT></td>\n\n    <td align=\"center\" class=\'";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\' nowrap>\n\t<SELECT name=\"chk_for_max_durn_action";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\" id=\"chk_for_max_durn_action";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\"  ";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="  onchange=\'parent.parent.parent.chkAction(this,\"";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\")\'>\n\t<option value=\'\'>--- ";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 =" ---</option>\n\t<option value=\"W\" ";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 =">Warn</option>\n\t<option value=\"R\" ";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 =">Reject</option>\n\t<option value=\"A\" ";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 =">Request for Authorize</option>\n\t</SELECT></td>\n\n\n\t<td  class=\'";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\' style=\"bottom-margin:0;display:none\"><input type=text name=\'ord_auth_level";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\' id=\'ord_auth_level";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\' size=\'1\' maxlength=\'1\'\n\tonBlur=\"OrCheckPositiveNumber(this);parent.parent.parent.chkSecurityLevel(this)\"\n\t";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="  value=\"";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\n\t<td  name=\"msg_td";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\" id=\"msg_td";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\" class=\'";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\' >&nbsp;&nbsp;<A name=\'msg";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\' HREF=\'javascript:parent.parent.parent.showMsgDialog(\"";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\")\'>";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="</A></td> \n\t";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\' >&nbsp;&nbsp;&nbsp;</td>\n\t";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\n\t<INPUT TYPE=\"hidden\" name=\"prompt_msg";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\" id=\"prompt_msg";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\">\n\t</tr>\n";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\n\n\n</table>\n\n<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\">\n<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\">\n<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\">\n<input type=\"hidden\" name=\"qry_str\" id=\"qry_str\" value=\"";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\">\n<input type=\"hidden\" name=\"function_id\" id=\"function_id\" value=\"";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\">\n<input type=\"hidden\" name=\"module_id\" id=\"module_id\" value=\"";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\">\n<input type=\"hidden\" name=\"tabType\" id=\"tabType\" value=\"Se\">\n\n<!-- Characteristis Tab Value -->\n<input type=\"hidden\" name=\"qty_reqd_yn\" id=\"qty_reqd_yn\"          value=\"";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\">\n<input type=\"hidden\" name=\"freq_applicable_yn\" id=\"freq_applicable_yn\"  value=\"";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\">\n<input type=\"hidden\" name=\"soft_stop_yn\" id=\"soft_stop_yn\"\t\t value=\"";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\">\n<input type=\"hidden\" name=\"localeName\" id=\"localeName\" value=\"";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\">\n<!-- -->\n\n</form>\n\n";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );
	
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


	/***DEFAULTS***********/
	String qty_uom_default							="";
	String qty_value_default						="1";
	String freq_code_default						="";
	String age_group_code_default					="";
	String max_durn_type_default					="";
	String max_durn_value_default					="";
	String chk_for_max_durn_action_default			="";
	String ord_auth_level_default					="";
	String prompt_msg_default						="";
	String setting_applicability_default			="X";
	String durn_type_default						="";
	String durn_desc_default						="";
	String durn_value_default						="";
	/**/

	/***UPDATABLE***********/
	String qty_uom_updatable						="N";
	String qty_value_updatable						="N";
	String freq_code_updatable						="Y";
	String age_group_code_updatable					="Y";
	String durn_value_updatable						="N";
	String max_durn_type_updatable					="N";
	String max_durn_value_updatable					="N";
	String chk_for_max_durn_action_updatable		="N" ;
	String ord_auth_level_updatable					="N";
	String setting_applicability_updatable			="Y";
	/**/


	public void defaultIntialisation()	
	{
		qty_uom_default						="";
		qty_value_default						="1";
		freq_code_default						="";
		age_group_code_default					="";
		max_durn_type_default					="";
		max_durn_value_default					="";
		chk_for_max_durn_action_default		="";
		ord_auth_level_default					="";
		prompt_msg_default						="";
		setting_applicability_default			="X";
		durn_type_default						="";
		durn_desc_default						="";
		durn_value_default						="";
	}

	public void updatableIntialisation()
	{

		qty_uom_updatable					="N";
		qty_value_updatable				="N";
		freq_code_updatable				="Y";
		age_group_code_updatable			="Y";
		max_durn_type_updatable			="N";
		durn_value_updatable               ="N";
		max_durn_value_updatable			="N";
		chk_for_max_durn_action_updatable	="N" ;
		ord_auth_level_updatable			="N";
		setting_applicability_updatable	="Y";
	}

	String decode(String code)
	{
	  if(code.equalsIgnoreCase("H")) return "Hour(s)";
	  if(code.equalsIgnoreCase("D")) return "Day(s)";
	  if(code.equalsIgnoreCase("W")) return "Week(s)";
	  //Modified by Ambiga.M on 2/8/2010 for 18924
	  //if(code.equalsIgnoreCase("M") || code.equalsIgnoreCase("L")) return "Months";
	  if(code.equalsIgnoreCase("L")) return "Month(s)";
  	  if(code.equalsIgnoreCase("M")) return "Minute(s)";
	  return "";
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
            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
            _bw.write(_wl_block2Bytes, _wl_block2);


try
{

	//String readOnly = "" ;
	//String checked = "checked" ;
	/* Mandatory checks start */
	 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String mode		    = request.getParameter( "mode" ) ;
	/*Enumeration enum = request.getParameterNames();
	if(enum.hasMoreElements()) {

	}*/

//	String function_id  = request.getParameter( "function_id" ) ;
	String bean_id      = "Or_OrderCatalog" ;
	String bean_name    = "eOR.OrderCatalogBean";
	//String disabled		= "" ;

	String uom_style    = "display:none" ;

	//String max_durn_value					="";
	String eff_status						="E";
	//String ord_auth_level					="";

	/**DEFAULT VALUES IN UPDATE MODE/OTHER MODULE CALLED*************/
	 Hashtable defVal						=new Hashtable();
	/**/

	defaultIntialisation();//Always intailise when the page is loaded to get default value
	updatableIntialisation();//Always intailise when the page is loaded to get default value
	OrderCatalogBean bean = (OrderCatalogBean)getBeanObject(bean_id, bean_name,request ) ;

	bean.setLanguageId(localeName);
	String order_catalog_code				= bean.checkForNull(request.getParameter("order_catalog_code" ));


	/*String long_desc						=bean.checkForNull(request.getParameter("long_desc"));

	String short_desc						=bean.checkForNull(request.getParameter("short_desc"));*/

	String order_category					= bean.checkForNull(request.getParameter("order_category"));

	String module_id						= bean.checkForNull(request.getParameter("module_id"));
	//String security_level					="";
    String qty_uom_val 						= "";

	//int size								=  0;

	String classValue = "gridData";//to Chabge class of the alternate rows


	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" )) ))
	return ;

	bean.setMode( mode ) ;

	/*******MODIFY MODE********/
	if ( mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) )) 
	{

	//headerStore
		HashMap orderCatalogHeaderStr =	bean.getOrderCatalogHeaderStr();

	//In modify mode if the eff status is no then all Feild should be disabled
		eff_status  = (String)orderCatalogHeaderStr.get("eff_status");
		eff_status	= eff_status.trim();

		order_catalog_code =
		(String)orderCatalogHeaderStr.get("order_catalog_code");
		 String sqlParam[]  = {order_catalog_code.trim()};
		if(module_id.trim().equalsIgnoreCase("PH"))
		{
			 String sql_setting = bean.checkForNull(request.getParameter("sql_setting"));
			 if(sql_setting == null || sql_setting.equals(""))
				 //sql_setting = "SELECT A.DRUG_CATG_CODE,A.PATIENT_CLASS,A.MAX_DURN_VALUE,A.MAX_DURN_TYPE,A.ACTION CHK_FOR_MAX_DURN_ACTION,A.ORD_AUTH_LEVEL,A.PROMPT_MSG FROM PH_DRG_CTG_RLE_BY_PTCL_LANG_VW A WHERE A.DRUG_CATG_CODE=? AND A.LANGUAGE_ID = ? ";
			 sql_setting = "SELECT A.DRUG_CATG_CODE,A.PATIENT_CLASS,A.MAX_DURN_VALUE,A.MAX_DURN_TYPE,A.ACTION CHK_FOR_MAX_DURN_ACTION,A.ORD_AUTH_LEVEL,A.PROMPT_MSG FROM PH_DRG_CTG_RLE_BY_PTCL_LANG_VW A WHERE A.DRUG_CATG_CODE = (SELECT PRES_CATG_CODE FROM PH_DRUG WHERE DRUG_CODE = ?) AND A.LANGUAGE_ID = ?";

			 String sqlParam1[]  = {order_catalog_code.trim(),localeName};

			 if(!sql_setting.equals("") && !sql_setting.equals("null"))
			 {
				 Hashtable defVal1 = bean.settingsDefault(sql_setting,"sql_setting",sqlParam1);
				 out.println("<input type='hidden' name='defVal1' id='defVal1' value='"+defVal1.size()+"'>");

				 defVal = bean.settingsDefault("SQL_OR_CATALOG_LOAD_CATALOG_BY_SETTINGS","update",sqlParam);

				 for (Enumeration en = defVal.keys() ; en.hasMoreElements() ;) 
				 {
					String key = (String)en.nextElement();
					if (defVal1.containsKey(key)) 
					{
						defVal1.remove(key);
						defVal1.put(key,defVal.get(key));
					} 
					else
					{
					//if(defVal1.equals(""))
					//{
						 //Below code is commented by Archana Dhal on 6/2/2010 related to the IN021612.			 
						 //defVal1.put(key,defVal.get(key));
					//}
			 		}
				 }
				 //ML-MMOH-SCF-2542-Start.
				 /*if(defVal1.size()!=0)
				 {
					defVal = defVal1;
				 }
				 else
				 {
					  for (Enumeration en = defVal.keys() ; en.hasMoreElements() ;) 
					 {
						String key = (String)en.nextElement();
						if (!key.equals("*A")) 
						{
							defVal.remove(key);
						} 
					 }
				 }*/ 
				 //ML-MMOH-SCF-2542-End.


				//int sizeDef = defVal.size();

				/*if(sizeDef == 0){//Allow Updation
					ord_auth_level_updatable			=  "Y";	
				}else{//UPdation chk at all particular records
				   ord_auth_level_updatable			=  "N";
				}*/
			}
		} 
		else 
		{
			defVal = bean.settingsDefault("SQL_OR_CATALOG_LOAD_CATALOG_BY_SETTINGS","update",sqlParam);
		}		
	}
	/***/

	/**CALLED FROM DIFFERENT MODULE IN INSERT MODE***/
	if(!module_id.equalsIgnoreCase("OR") && !mode.equals(CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ))
	{

		if(module_id.trim().equalsIgnoreCase("PH"))
		{

			 String sql_setting = bean.checkForNull(request.getParameter("sql_setting"));
			 String sqlParam[]  = {};


			
			if(!sql_setting.equals("") && !sql_setting.equals("null"))
			 defVal = bean.settingsDefault(sql_setting,"sql_setting",sqlParam);
			 out.println("<input type='hidden' name='defVal1' id='defVal1' value='"+defVal.size()+"'>");
			// int sizeDef = defVal.size();

			/* if(sizeDef == 0){//Allow Updation
				;
			 }else{//UPdation chk at all particular records
			 }*/

		}
	}
	/***/


	 /***GET THE STORE FOR THIS TAB***/
	ArrayList  settingsRecStr		 =  bean.getSettingsRecStr();


	/**CHARACTERISTICS VALUE*************/
	ArrayList  characteristicsRecStr =  bean.getCharacteristicsRecStr();
	String qty_reqd_yn				 = bean.getdefaultArrListValue(characteristicsRecStr,0,"qty_reqd_yn","N");

	String freq_applicable_yn		 =
	bean.getdefaultArrListValue(characteristicsRecStr,0,"freq_applicable_yn","N");


	//String qty_uom		 =	bean.getdefaultArrListValue(characteristicsRecStr,0,"qty_uom","");

	String qty_uom		 = bean.checkForNull(request.getParameter( "uom_code"));
	if(qty_uom.equals(""))
		qty_uom		 = bean.getdefaultArrListValue(characteristicsRecStr,0,"qty_uom","");

	String soft_stop_yn				 =
	bean.getdefaultArrListValue(characteristicsRecStr,0,"soft_stop_yn","N");

	/**/

	/**FREQUENCY APPLICABLE VALUE*******/
	ArrayList frequencyRecStr	= bean.getFrequencyRecStr();
	String frequencyFrom		= bean.getFrequencyFrom();
	/**/

	//Display logic of UOM
	 if(order_category.trim().equalsIgnoreCase("PH") || module_id.trim().equalsIgnoreCase("PH") || (!qty_uom.equals("")))
	 uom_style = "";


	/**TO LOAD FREQUENCY VALUE************/
	//String oc=((String)orderCatalogHeaderStr.get("order_catalog_code")).trim();


	bean.setSettingsFreqStr(order_category.trim(),order_catalog_code.trim());
	HashMap   settingsFreqStr		 =  bean.getSettingsFreqStr();

	Integer	noOfRecTemp				 = (Integer)settingsFreqStr.get("noRec");
	int noOfRecordsFreq				 = noOfRecTemp.intValue() ;
	/**/

	/**TO LOAD FREQUENCY VALUE************/
	bean.setSettingsAgeGroupStr();
	HashMap   settingsAgeGroupStr	 =  bean.getSettingsAgeGroupStr();
	Integer	noOfRecTempAgeGroup		 = (Integer)settingsAgeGroupStr.get("noRec");
	int noOfRecordsAgeGroup			 = noOfRecTempAgeGroup.intValue() ;
	/**/


            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(uom_style));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

		setting_applicability_default = "A";//for all patient Class(*A) by deafult


		if(settingsRecStr.isEmpty())
		{//Page is Visited for First Time
			if(defVal.containsKey("*A"))
			{//Some default val is there ...modify mode/called from  other module

				HashMap currRec					=(HashMap)defVal.get("*A");
				setting_applicability_default   =(String)currRec.get("setting_applicability");
				qty_uom_default					=(String)currRec.get("qty_uom");
				qty_value_default				=eHISFormatter.chkReturn((String)currRec.get("qty_value"),"0","",(String)currRec.get("qty_value"));
				freq_code_default				=(String)currRec.get("freq_code");
				age_group_code_default			=(String)currRec.get("age_group_code");
				max_durn_type_default			=(String)currRec.get("max_durn_type");
				max_durn_value_default		 	=eHISFormatter.chkReturn((String)currRec.get("max_durn_value"),"0","",(String)currRec.get("max_durn_value"));
				chk_for_max_durn_action_default	=(String)currRec.get("chk_for_max_durn_action");
				ord_auth_level_default			=eHISFormatter.chkReturn((String)currRec.get("ord_auth_level"),"0","",(String)currRec.get("ord_auth_level"));
				durn_type_default				=(String)currRec.get("durn_type");
				prompt_msg_default				=(String)currRec.get("prompt_msg");
				durn_desc_default				=(String)currRec.get("durn_desc");
				durn_value_default				=eHISFormatter.chkReturn((String)currRec.get("durn_value"),"0","",(String)currRec.get("durn_value"));
			}
		}


		String setting_applicability_chk = bean.getdefaultArrListValue(settingsRecStr,0,"setting_applicability",setting_applicability_default);



		/***VALIDATION BASED ON THE CHARACTERISTICS VALUE***************/
		if(qty_reqd_yn.trim().equalsIgnoreCase("Y"))
		{
			if(module_id.trim().equalsIgnoreCase("PH") || order_category.trim().equalsIgnoreCase("PH")) 
			{
				qty_uom_updatable	= "Y";
			} 
			else 
			{
				qty_uom_updatable	= "N";
			}
			qty_value_updatable = "Y";
		}


		if(module_id.trim().equalsIgnoreCase("PH") || (!qty_uom.equals("")))
		{
			qty_uom_default = qty_uom ;
		}

		 /****/

		/**CHK FOR ACTION TAG****/
		String 	chk_for_max_durn_actionO	= bean.getdefaultArrListValue(settingsRecStr,0,"chk_for_max_durn_action",chk_for_max_durn_action_default);

		if(chk_for_max_durn_actionO.equalsIgnoreCase("A"))
		ord_auth_level_updatable			 = "Y";
		/***/

		//CALLED FROM OTHER MODULE & VALUE IS ***NOT PASSED*** FOR PAT CLASS  THEN ONLY SETTING APPLICABILTY IS DEFAULTED TO NOT APPLICABLE IF 		defVal SIZE IS ZERO
		if(!defVal.containsKey("*A") && module_id.equalsIgnoreCase("PH")&& !(module_id.equalsIgnoreCase("OR") || module_id.equalsIgnoreCase("")) )
		{
			if(settingsRecStr.isEmpty() && defVal.size() != 0)
			{//Page is Visited for First Time
				setting_applicability_default = "X" ;
				setting_applicability_chk = "X" ;
			}
		}
		
            _bw.write(_wl_block19Bytes, _wl_block19);
if(eff_status.trim().equalsIgnoreCase("D"))
		{//only in modify mode if eff_staus is disabled
			updatableIntialisation();
			setting_applicability_updatable			="N";
		}

		if(setting_applicability_updatable.trim().equalsIgnoreCase("N"))
		{
			freq_code_updatable					="N";
			age_group_code_updatable               ="N";
		}		

		if(module_id.trim().equalsIgnoreCase("PH"))
		{
			if((defVal.size())!=0&&!defVal.containsKey("*A"))
			{
				setting_applicability_updatable="N";
			}
		}
		
            _bw.write(_wl_block20Bytes, _wl_block20);
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",setting_applicability_updatable,"","")));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(order_category.trim()));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,0,"setting_applicability",setting_applicability_default),"A")));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,0,"setting_applicability",setting_applicability_default),"X")));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

		String 	max_durn_val_chk = bean.getdefaultArrListValue(settingsRecStr,0,"max_durn_value",
		max_durn_value_default) ;


		if(!max_durn_val_chk.trim().equals("") && !setting_applicability_updatable.trim().equalsIgnoreCase("N") )
		chk_for_max_durn_action_updatable = "Y";



		//Applicability---//SuperRiding All the Roles
		if(setting_applicability_chk.trim().equalsIgnoreCase("X"))
		{//this condn over rides all the prevoius rule
			qty_value_updatable					= "N" ;
			qty_uom_updatable			        = "N" ;
			freq_code_updatable			        = "N" ;
			age_group_code_updatable	        = "N" ;
			max_durn_type_updatable		        = "N" ;
			max_durn_value_updatable            = "N" ;
			chk_for_max_durn_action_updatable   = "N" ;
			ord_auth_level_updatable			= "N" ;
		}


	
            _bw.write(_wl_block26Bytes, _wl_block26);

       StringBuffer optionsAgeGroup = new StringBuffer() ;

		if(noOfRecordsAgeGroup != 0)
		{
    		for(int i=1 ; i <= noOfRecordsAgeGroup; i++)
			{

    			optionsAgeGroup.append("<option value=\""+(String)settingsAgeGroupStr.get("AGE_GROUP_CODE"+i) + "\"  "+  eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,0,"age_group_code",age_group_code_default),(String)settingsAgeGroupStr.get("AGE_GROUP_CODE"+i))+">"+(String)settingsAgeGroupStr.get("AGE_GROUP_DESC"+i)+"</option>");
    	    }
        }
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",age_group_code_updatable,"","disabled")));
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(optionsAgeGroup.toString()));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",qty_value_updatable,"","disabled")));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(bean.getdefaultArrListValue(settingsRecStr,0,"qty_value",
	qty_value_default)));
            _bw.write(_wl_block34Bytes, _wl_block34);
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(uom_style));
            _bw.write(_wl_block37Bytes, _wl_block37);

  	if (order_category.equalsIgnoreCase("PH") || module_id.equalsIgnoreCase("PH"))
  		qty_uom_val = bean.getdefaultArrListValue(settingsRecStr,0,"qty_uom",qty_uom_default);
  	else
  		qty_uom_val = qty_uom_default;
	
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",qty_uom_updatable,"","disabled")));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(qty_uom_val));
            _bw.write(_wl_block40Bytes, _wl_block40);

		StringBuffer optionsFreq = new StringBuffer() ;

		/*if(noOfRecordsFreq != 0){
			for(int i=1 ; i <= noOfRecordsFreq; i++){
				if (frequencyFrom.equals("F")) {
					if ((bean.getdefaultArrListValue(frequencyRecStr,i-1,"applicable_yn","N")).equals("Y")) {
		        		optionsFreq.append("<option value=\""+(String)settingsFreqStr.get("FREQ_CODE"+i) + "\"  "+  eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,0,"freq_code",freq_code_default),(String)settingsFreqStr.get("FREQ_CODE"+i))+">"+(String)settingsFreqStr.get("FREQ_DESC"+i)+"</option>");
		        	}
		        } else {
		        	optionsFreq.append("<option value=\""+(String)settingsFreqStr.get("FREQ_CODE"+i) + "\"  "+  eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,0,"freq_code",freq_code_default),(String)settingsFreqStr.get("FREQ_CODE"+i))+">"+(String)settingsFreqStr.get("FREQ_DESC"+i)+"</option>");
		        }
			}
		}*/

		if(noOfRecordsFreq != 0)
		{


			if (frequencyFrom.equals("F")) 
			{
				for(int i=1 ; i <= noOfRecordsFreq; i++)
				{
					boolean optionFlag = false;
					String code = "";
					String desc = "";
					int applicableCount = frequencyRecStr.size();	

					if (applicableCount > 0) 
					{
						for (int j = 0; j < applicableCount; j++) 
						{
							HashMap tempHash = (HashMap)frequencyRecStr.get(j);

							if (((String)tempHash.get("frequency_code")).equals((String)settingsFreqStr.get("FREQ_CODE"+i))) 
							{
								if (((String)tempHash.get("applicable_yn")).equalsIgnoreCase("Y")) 
								{
									
									optionFlag 	= true;
									code		= (String)tempHash.get("frequency_code");
									desc		= (String)tempHash.get("frequency_desc");
									break;
								} 
								else 
								{
									optionFlag = false;
								}
							}  
							else 
							{
								optionFlag = false;
							}
						}
					}
					if (optionFlag == true) 
					{
						optionsFreq.append("<option value=\""+code + "\"  "+  eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,0,"freq_code",freq_code_default),code)+">"+desc+"</option>");
					}
				}
            } 
			else 
			{
				if (mode.equals("1"))
				{

					for(int i=1 ; i <= noOfRecordsFreq; i++)
					{
						optionsFreq.append("<option value=\""+(String)settingsFreqStr.get("FREQ_CODE"+i) + "\"  "+  eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,0,"freq_code",freq_code_default),(String)settingsFreqStr.get("FREQ_CODE"+i))+">"+(String)settingsFreqStr.get("FREQ_DESC"+i)+"</option>");
					}
				}
				else
				{


					for(int i=1 ; i <= noOfRecordsFreq; i++)
					{
						boolean optionFlag = false;
						String code = "";
						String desc = "";
						int applicableCount = frequencyRecStr.size();

						if (applicableCount > 0) 
						{
							for (int j = 0; j < applicableCount; j++) 
							{
								HashMap tempHash = (HashMap)frequencyRecStr.get(j);

								if (((String)tempHash.get("frequency_code")).equals((String)settingsFreqStr.get("FREQ_CODE"+i))) 
								{
									if (((String)tempHash.get("applicable_yn")).equalsIgnoreCase("Y")) 
									{
										
										optionFlag 	= true;
										code		= (String)tempHash.get("frequency_code");
										desc		= (String)tempHash.get("frequency_desc");
										break;
									} 
									else 
									{
										optionFlag = false;
									}
								}  
								else 
								{
									optionFlag = false;
								}
							}
						}
						if (optionFlag == true) 
						{
							optionsFreq.append("<option value=\""+code + "\"  "+  eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,0,"freq_code",freq_code_default),code)+">"+desc+"</option>");
						}
					}

				}
			}
        }
	
            _bw.write(_wl_block41Bytes, _wl_block41);
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",freq_code_updatable,"","disabled")));
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(optionsFreq.toString()));
            _bw.write(_wl_block45Bytes, _wl_block45);

	String freq_codeTemp	 = bean.getdefaultArrListValue(settingsRecStr,0,"freq_code",freq_code_default);
	//String durn_ValueAllTemp =
	bean.getdefaultArrListValue(settingsRecStr,0,"durn_value",durn_value_default) ;
	//String durn_typeAllTemp  =
	bean.getdefaultArrListValue(settingsRecStr,0,"durn_type",durn_type_default) ;
	//String durn_descAllTemp  =
	bean.getdefaultArrListValue(settingsRecStr,0,"durn_desc",durn_desc_default) ;
	String durn_legend       = "&nbsp;" ;

	if(!freq_codeTemp.trim().equals("") && freq_code_updatable.trim().equalsIgnoreCase("Y")){
	durn_value_updatable	 = "Y";
	max_durn_value_updatable = "Y";
	}
	if(bean.getdefaultArrListValue(settingsRecStr,0,"durn_type",durn_type_default).equals(""))
	{
		durn_value_updatable="N";
		max_durn_value_updatable = "N";
	}
	
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",durn_value_updatable,"","disabled")));
            _bw.write(_wl_block47Bytes, _wl_block47);
if(optionsFreq.length()==0){
            _bw.write(_wl_block48Bytes, _wl_block48);
}else{
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(bean.getdefaultArrListValue(settingsRecStr,0,"durn_value",durn_value_default)));
            _bw.write(_wl_block50Bytes, _wl_block50);
}
            _bw.write(_wl_block51Bytes, _wl_block51);
if(optionsFreq.length()==0){
            _bw.write(_wl_block48Bytes, _wl_block48);
}else{
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(decode(bean.getdefaultArrListValue(settingsRecStr,0,"durn_type",durn_type_default))));
            _bw.write(_wl_block50Bytes, _wl_block50);
}
            _bw.write(_wl_block52Bytes, _wl_block52);
if(optionsFreq.length()==0){
            _bw.write(_wl_block48Bytes, _wl_block48);
}else{
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(bean.getdefaultArrListValue(settingsRecStr,0,"durn_type",durn_type_default)));
            _bw.write(_wl_block50Bytes, _wl_block50);
}
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(durn_legend));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(bean.getdefaultArrListValue(settingsRecStr,0,"durn_type",durn_type_default)));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(bean.getdefaultArrListValue(settingsRecStr,0,"durn_value",durn_value_default)));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(bean.getdefaultArrListValue(settingsRecStr,0,"durn_desc",durn_desc_default)));
            _bw.write(_wl_block58Bytes, _wl_block58);

		bean.setSettingsDurnStr();
		HashMap durn_type_str =	 bean.getSettingsDurnStr();
		Integer	noOfRecDurnTemp = (Integer)durn_type_str.get("noRec");
		int noOfRecDurn   = noOfRecDurnTemp.intValue() ;
		StringBuffer optionsDurn = new StringBuffer() ;
		if(noOfRecDurn != 0){
		for(int i=1 ; i <= noOfRecDurn; i++){
        optionsDurn.append("<option value=\""+(String)durn_type_str.get("DURN_TYPE"+i) +  "\"  "  +  eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,0,"max_durn_type",max_durn_type_default),(String)durn_type_str.get("DURN_TYPE"+i))+">"+(String)durn_type_str.get("DURN_DESC"+i)+"</option>");
		}
	}



	
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",max_durn_value_updatable,"","disabled")));
            _bw.write(_wl_block61Bytes, _wl_block61);
if(optionsFreq.length()==0){
            _bw.write(_wl_block48Bytes, _wl_block48);
}else{
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(bean.getdefaultArrListValue(settingsRecStr,0,"max_durn_value",max_durn_value_default)));
            _bw.write(_wl_block50Bytes, _wl_block50);
}
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",max_durn_type_updatable,"","disabled")));
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);
if(optionsFreq.length()!=0){
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(optionsDurn.toString()));
}
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",chk_for_max_durn_action_updatable,"","disabled")));
            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);
if(optionsFreq.length()!=0){
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,0,"chk_for_max_durn_action",chk_for_max_durn_action_default),"W")));
            _bw.write(_wl_block72Bytes, _wl_block72);
}
            _bw.write(_wl_block73Bytes, _wl_block73);
if(optionsFreq.length()!=0){
            out.print( String.valueOf(eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,0,"chk_for_max_durn_action",chk_for_max_durn_action_default),"R")));
            _bw.write(_wl_block72Bytes, _wl_block72);
}
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);
if(optionsFreq.length()!=0){
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,0,"chk_for_max_durn_action",chk_for_max_durn_action_default),"A")));
            _bw.write(_wl_block72Bytes, _wl_block72);
}
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",ord_auth_level_updatable,"","disabled")));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(bean.getdefaultArrListValue(settingsRecStr,0,"ord_auth_level",
	ord_auth_level_default)));
            _bw.write(_wl_block79Bytes, _wl_block79);
if(!((String)bean.getdefaultArrListValue(settingsRecStr,0,"chk_for_max_durn_action",chk_for_max_durn_action_default)).equals("")){
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block82Bytes, _wl_block82);
}else{
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block84Bytes, _wl_block84);
}
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(bean.getdefaultArrListValue(settingsRecStr,0,"prompt_msg",prompt_msg_default).trim()));
            _bw.write(_wl_block86Bytes, _wl_block86);

	HashMap pat_class =	bean.getSqlResult("SQL_OR_PATIENT_CLASS_LIST");
	Integer	noOfRecordsTemp = (Integer)pat_class.get("noRec");
	int noOfRecords   = noOfRecordsTemp.intValue() ;
	int fm_disp		  = 1 ;
	int to_disp		  = noOfRecords ;
	

            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(noOfRecords));
            _bw.write(_wl_block88Bytes, _wl_block88);

	if(noOfRecords != 0){
	for(int i=fm_disp ; i <= to_disp; i++){
		String patient_class  = (String)pat_class.get("PATIENT_CLASS"+i);
		String patient_class_short_desc  = (String)pat_class.get("SHORT_DESC"+i);
		classValue			=( (i%2)==0 )? "gridData" : "gridData";

            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(patient_class_short_desc));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(i));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(i));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block94Bytes, _wl_block94);

	/**ReInitaise for every Loop (Default&Updatables) Very IMP******/
	defaultIntialisation();
	updatableIntialisation();

	if(settingsRecStr.isEmpty())
	{//Page is Visited for First Time
	
		if(defVal.containsKey(patient_class.trim()))
		{//Some default val is there ...modify mode/called from  other module

			HashMap currRec					=(HashMap)defVal.get(patient_class.trim());
			setting_applicability_default   =(String)currRec.get("setting_applicability");
			if(setting_applicability_default.trim().equalsIgnoreCase("A"))
			{
				qty_uom_default					=(String)currRec.get("qty_uom");
				qty_value_default				=eHISFormatter.chkReturn((String)currRec.get("qty_value"),"0","",(String)currRec.get("qty_value"));
				freq_code_default				=(String)currRec.get("freq_code");
				age_group_code_default			=(String)currRec.get("age_group_code");
				max_durn_type_default			=(String)currRec.get("max_durn_type");
				max_durn_value_default			=eHISFormatter.chkReturn((String)currRec.get("max_durn_value"),"0","",(String)currRec.get("max_durn_value"));
				chk_for_max_durn_action_default	=(String)currRec.get("chk_for_max_durn_action");
				ord_auth_level_default			=(String)currRec.get("ord_auth_level");
				prompt_msg_default				=(String)currRec.get("prompt_msg");
				setting_applicability_default	=(String)currRec.get("setting_applicability");
				durn_type_default				=(String)currRec.get("durn_type");
				durn_desc_default				=(String)currRec.get("durn_desc");
				durn_value_default				=eHISFormatter.chkReturn((String)currRec.get("durn_value"),"0","",(String)currRec.get("durn_value"));
			}
		 }
	 }

     setting_applicability_chk = bean.getdefaultArrListValue(settingsRecStr,i,"setting_applicability",setting_applicability_default);


	 //CALLED FROM OTHER MODULE & VALUE IS PASSED FOR PAT CLASS THEN ONLY SETTING APPLICABILTY IS DISABLED
	if(!defVal.containsKey(patient_class.trim()) && 	  !(module_id.equalsIgnoreCase("OR") || module_id.equalsIgnoreCase("")) )
	{
		setting_applicability_updatable		= "N" ;
		setting_applicability_chk = "X" ;//Only to make other feild's disabled
	}


	if(qty_reqd_yn.trim().equalsIgnoreCase("Y"))
	{//awalys set with default value
		if(module_id.trim().equalsIgnoreCase("PH") || order_category.trim().equalsIgnoreCase("PH")) 
		{
			qty_uom_updatable	= "Y";
		} 
		else 
		{
			qty_uom_updatable	= "N";
		}
		qty_value_updatable = "Y";
	}


	/***VALIDATION BASED ON THE CHARACTERISTICS VALUE***************/
	String 	chk_for_max_durn_actionVar = bean.getdefaultArrListValue(settingsRecStr,i,"chk_for_max_durn_action",
    chk_for_max_durn_action_default)		;
	String ord_auth_level_updatableVar = "N";

	if(chk_for_max_durn_actionVar.equalsIgnoreCase("A"))
		ord_auth_level_updatableVar = "Y";

	qty_uom_default                     = qty_uom ;

	if(freq_applicable_yn.trim().equalsIgnoreCase("Y"))
	{//Default freq chk form other tab condn
		if(module_id.trim().equalsIgnoreCase("PH"))
			chk_for_max_durn_action_updatable	= "N" ;	 //For Pharmacy
	}
	else
	{
	}
	/****/
	
	if(eff_status.trim().equalsIgnoreCase("D"))
	{//only in mod mode if eff_staus is disabled
		 updatableIntialisation();
		 setting_applicability_updatable		="N";
	}

	if(setting_applicability_updatable.trim().equalsIgnoreCase("N"))
	{
		 freq_code_updatable					="N";
		 age_group_code_updatable				="N";
	}

	
            _bw.write(_wl_block41Bytes, _wl_block41);
            _bw.write(_wl_block41Bytes, _wl_block41);
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(i));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(i));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(i));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(order_category.trim()));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",setting_applicability_updatable,"","")));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,i,"setting_applicability",setting_applicability_chk),"X") ));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,i,"setting_applicability",setting_applicability_chk),"A")));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block103Bytes, _wl_block103);


	max_durn_val_chk = bean.getdefaultArrListValue(settingsRecStr,i,"max_durn_value",
		max_durn_value_default) ;


	if(!max_durn_val_chk.equalsIgnoreCase(""))
		chk_for_max_durn_action_updatable = "Y";



	if(setting_applicability_chk.trim().equalsIgnoreCase("X")){//this condn overrides all the prevoius rule
		qty_value_updatable					= "N" ;
		qty_uom_updatable					= "N" ;
		freq_code_updatable					= "N" ;
		age_group_code_updatable			= "N" ;
		max_durn_type_updatable				= "N" ;
		max_durn_value_updatable			= "N" ;
		chk_for_max_durn_actionVar			= "N" ;
		chk_for_max_durn_action_updatable	= "N" ;
		ord_auth_level_updatableVar			= "N" ;
		}


  
            _bw.write(_wl_block104Bytes, _wl_block104);


		StringBuffer optionsAgeGroupVar = new StringBuffer() ;
		if(noOfRecordsAgeGroup != 0){
		for(int j=1 ; j <= noOfRecordsAgeGroup; j++){
			optionsAgeGroupVar.append("<option value=\""+(String)settingsAgeGroupStr.get("AGE_GROUP_CODE"+j) + "\"  "+  eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,i,"age_group_code",age_group_code_default),(String)settingsAgeGroupStr.get("AGE_GROUP_CODE"+j))+">"+(String)settingsAgeGroupStr.get("AGE_GROUP_DESC"+j)+"</option>");
	    }
	}

	
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(i));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(i));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",age_group_code_updatable,"","disabled")));
            _bw.write(_wl_block109Bytes, _wl_block109);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(optionsAgeGroupVar.toString()));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(i));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(i));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",qty_value_updatable,"","disabled")));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(bean.getdefaultArrListValue(settingsRecStr,i,"qty_value",
  qty_value_default)));
            _bw.write(_wl_block34Bytes, _wl_block34);
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(uom_style));
            _bw.write(_wl_block115Bytes, _wl_block115);

  	if (order_category.equalsIgnoreCase("PH") || module_id.equalsIgnoreCase("PH")){
	  if(qty_uom.equals(""))
  	      qty_uom_val = bean.getdefaultArrListValue(settingsRecStr,i,"qty_uom",qty_uom_default);
	  else
		  qty_uom_val = qty_uom;

  }else
  		qty_uom_val = qty_uom_default;
	
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(i));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(i));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",qty_uom_updatable,"","disabled")));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(qty_uom_val));
            _bw.write(_wl_block119Bytes, _wl_block119);


		StringBuffer optionsFreqVar = new StringBuffer() ;
		/*if(noOfRecordsFreq != 0){
			for(int j=1 ; j <= noOfRecordsFreq; j++){
				if (frequencyFrom.equals("F")) {
					if ((bean.getdefaultArrListValue(frequencyRecStr,j-1,"applicable_yn","N")).equals("Y")) {
		        		optionsFreqVar.append("<option value=\""+(String)settingsFreqStr.get("FREQ_CODE"+j) + "\"  "+  eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,0,"freq_code",freq_code_default),(String)settingsFreqStr.get("FREQ_CODE"+j))+">"+(String)settingsFreqStr.get("FREQ_DESC"+j)+"</option>");
		        	}
		        } else {
		        	optionsFreqVar.append("<option value=\""+(String)settingsFreqStr.get("FREQ_CODE"+j) + "\"  "+  eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,0,"freq_code",freq_code_default),(String)settingsFreqStr.get("FREQ_CODE"+j))+">"+(String)settingsFreqStr.get("FREQ_DESC"+j)+"</option>");
		        }
	        //optionsFreqVar.append("<option value=\""+(String)settingsFreqStr.get("FREQ_CODE"+j) + "\" "+  eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,i,"freq_code",freq_code_default),(String)settingsFreqStr.get("FREQ_CODE"+j))+">"+(String)settingsFreqStr.get("FREQ_DESC"+j)+"</option>");
			}
		}*/
		if(noOfRecordsFreq != 0){
			if (frequencyFrom.equals("F")) {
				for(int indx=1 ; indx <= noOfRecordsFreq; indx++){
					boolean optionFlag = false;
					String code = "";
					String desc = "";
					int applicableCount = frequencyRecStr.size();

					if (applicableCount > 0) {
						for (int j = 0; j < applicableCount; j++) {
							HashMap tempHash = (HashMap)frequencyRecStr.get(j);


							if (((String)tempHash.get("frequency_code")).equals((String)settingsFreqStr.get("FREQ_CODE"+indx))) {
								if (((String)tempHash.get("applicable_yn")).equalsIgnoreCase("Y")) {
									
									optionFlag 	= true;
									code		= (String)tempHash.get("frequency_code");
									desc		= (String)tempHash.get("frequency_desc");
									break;
								} else {
									optionFlag = false;
								}
							}  else {
								optionFlag = false;
							}
						}
					}
					if (optionFlag == true) {
						optionsFreqVar.append("<option value=\""+code + "\"  "+  eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,i,"freq_code",freq_code_default),code)+">"+desc+"</option>");
					}

				}
            } else {
            	/*for(int indx=1 ; indx <= noOfRecordsFreq; indx++){
            		optionsFreqVar.append("<option value=\""+(String)settingsFreqStr.get("FREQ_CODE"+indx) + "\"  "+  eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,i,"freq_code",freq_code_default),(String)settingsFreqStr.get("FREQ_CODE"+indx))+">"+(String)settingsFreqStr.get("FREQ_DESC"+indx)+"</option>");
					*/
				if (mode.equals("1")){

            	for(int indx=1 ; indx <= noOfRecordsFreq; indx++){

            		optionsFreqVar.append("<option value=\""+(String)settingsFreqStr.get("FREQ_CODE"+indx) + "\"  "+  eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,i,"freq_code",freq_code_default),(String)settingsFreqStr.get("FREQ_CODE"+indx))+">"+(String)settingsFreqStr.get("FREQ_DESC"+indx)+"</option>");

					
            	}

				}else{


					for(int indx=1 ; indx <= noOfRecordsFreq; indx++){
					boolean optionFlag = false;
					String code = "";
					String desc = "";
					int applicableCount = frequencyRecStr.size();
					
					if (applicableCount > 0) {
						for (int j = 0; j < applicableCount; j++) {
							HashMap tempHash = (HashMap)frequencyRecStr.get(j);

							if (((String)tempHash.get("frequency_code")).equals((String)settingsFreqStr.get("FREQ_CODE"+indx))) {
								if (((String)tempHash.get("applicable_yn")).equalsIgnoreCase("Y")) {
									
									optionFlag 	= true;
									code		= (String)tempHash.get("frequency_code");
									desc		= (String)tempHash.get("frequency_desc");
									break;
								} else {
									optionFlag = false;
								}
							}  else {
								optionFlag = false;
							}
						}
					}
					if (optionFlag == true) {
						optionsFreqVar.append("<option value=\""+code + "\"  "+  eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,i,"freq_code",freq_code_default),code)+">"+desc+"</option>");
					}
				}

            }
		
            
            }
        }


	
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(i));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(i));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",freq_code_updatable,"","disabled")));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(i));
            _bw.write(_wl_block124Bytes, _wl_block124);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(optionsFreqVar.toString()));
            _bw.write(_wl_block125Bytes, _wl_block125);

	String freq_codeTempVar		= bean.getdefaultArrListValue(settingsRecStr,i,"freq_code",freq_code_default);
	//String durn_ValueAllTempVar =
	bean.getdefaultArrListValue(settingsRecStr,i,"durn_value",durn_value_default) ;
	//String durn_typeAllTempVar  =
	bean.getdefaultArrListValue(settingsRecStr,i,"durn_type",durn_type_default) ;
	//String durn_descAllTempVar  =
	bean.getdefaultArrListValue(settingsRecStr,i,"durn_desc",durn_desc_default) ;


	//String durn_legend_var       = "&nbsp;" ;

	if(!freq_codeTempVar.trim().equals("") && freq_code_updatable.trim().equals("Y")){
	durn_value_updatable	 = "Y";
	max_durn_value_updatable = "Y";
	}
	if(bean.getdefaultArrListValue(settingsRecStr,i,"durn_type",durn_type_default).equals(""))
	{
		durn_value_updatable="N";
		max_durn_value_updatable = "N";
	}

	
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(i));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(i));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(i));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",durn_value_updatable,"","disabled")));
            _bw.write(_wl_block61Bytes, _wl_block61);
if(optionsFreqVar.length()==0){
            _bw.write(_wl_block48Bytes, _wl_block48);
}else{
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(bean.getdefaultArrListValue(settingsRecStr,i,"durn_value",durn_value_default)));
            _bw.write(_wl_block50Bytes, _wl_block50);
}
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(i));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(i));
            _bw.write(_wl_block133Bytes, _wl_block133);
if(optionsFreqVar.length()==0){
            _bw.write(_wl_block48Bytes, _wl_block48);
}else{
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(decode(bean.getdefaultArrListValue(settingsRecStr,i,"durn_type",durn_type_default))));
            _bw.write(_wl_block134Bytes, _wl_block134);
}
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(i));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(i));
            _bw.write(_wl_block50Bytes, _wl_block50);
if(optionsFreqVar.length()==0){
            _bw.write(_wl_block48Bytes, _wl_block48);
}else{
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(bean.getdefaultArrListValue(settingsRecStr,i,"durn_type",durn_type_default)));
            _bw.write(_wl_block134Bytes, _wl_block134);
}
            _bw.write(_wl_block137Bytes, _wl_block137);

		bean.setSettingsDurnStr();
		HashMap durn_type_str_var =	 bean.getSettingsDurnStr();
		Integer	noOfRecDurnTempVar = (Integer)durn_type_str_var.get("noRec");
		int noOfRecDurnvar   = noOfRecDurnTempVar.intValue() ;
		StringBuffer optionsDurnVar = new StringBuffer() ;
		if(noOfRecDurnvar != 0){
		for(int k=1 ; k <= noOfRecDurnvar; k++){
        optionsDurnVar.append("<option value=\""+(String)durn_type_str_var.get("DURN_TYPE"+k) +   "\"  "  +  eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,i,"max_durn_type",max_durn_type_default),(String)durn_type_str_var.get("DURN_TYPE"+k))+">"+(String)durn_type_str_var.get("DURN_DESC"+k)+"</option>");
		}
	}

		if(module_id.trim().equalsIgnoreCase("PH"))
			chk_for_max_durn_action_updatable	= "N" ;	 //For Pharmacy

	
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(i));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(i));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(i));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",max_durn_value_updatable,"","disabled")));
            _bw.write(_wl_block142Bytes, _wl_block142);
if(optionsFreqVar.length()==0){
            _bw.write(_wl_block48Bytes, _wl_block48);
}else{
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(bean.getdefaultArrListValue(settingsRecStr,i,"max_durn_value",max_durn_value_default)));
            _bw.write(_wl_block50Bytes, _wl_block50);
}
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(i));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(i));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",max_durn_type_updatable,"","disabled")));
            _bw.write(_wl_block145Bytes, _wl_block145);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block146Bytes, _wl_block146);
if(optionsFreqVar.length()!=0){
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(optionsDurnVar.toString()));
}
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(i));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(i));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",chk_for_max_durn_action_updatable,"","disabled")));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(i));
            _bw.write(_wl_block152Bytes, _wl_block152);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block153Bytes, _wl_block153);
if(optionsFreqVar.length()!=0){
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,i,"chk_for_max_durn_action",chk_for_max_durn_action_default),"W")));
}
            _bw.write(_wl_block154Bytes, _wl_block154);
if(optionsFreqVar.length()!=0){
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,i,"chk_for_max_durn_action",chk_for_max_durn_action_default),"R")));
            _bw.write(_wl_block72Bytes, _wl_block72);
}
            _bw.write(_wl_block155Bytes, _wl_block155);
if(optionsFreqVar.length()!=0){
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(eHISFormatter.select(bean.getdefaultArrListValue(settingsRecStr,i,"chk_for_max_durn_action",chk_for_max_durn_action_default),"A")));
}
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(i));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(i));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",ord_auth_level_updatableVar,"","disabled")));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(bean.getdefaultArrListValue(settingsRecStr,i,"ord_auth_level",
    ord_auth_level_default)));
            _bw.write(_wl_block79Bytes, _wl_block79);
if(!((String)bean.getdefaultArrListValue(settingsRecStr,i,"chk_for_max_durn_action",chk_for_max_durn_action_default)).equals("")){
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(i));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(i));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(i));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(i));
            _bw.write(_wl_block166Bytes, _wl_block166);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block167Bytes, _wl_block167);
}else{
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(i));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(i));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block168Bytes, _wl_block168);
}
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(i));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(i));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(bean.getdefaultArrListValue(settingsRecStr,i,"prompt_msg",prompt_msg_default)));
            _bw.write(_wl_block171Bytes, _wl_block171);
}

}
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(bean.getFunctionId()));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(module_id.trim()));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(qty_reqd_yn));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(freq_applicable_yn));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(soft_stop_yn));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block182Bytes, _wl_block182);

	putObjectInBean(bean_id,bean,request);	
}
catch(Exception e)
{
	e.printStackTrace();
}
            _bw.write(_wl_block183Bytes, _wl_block183);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientclass.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Applicability.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.agegroup.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ChangeQtydose.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.uom.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Frequency.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.DurnValueType.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.MaxValueDurnType.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.action.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AuthorizationLevel.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.Msg.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.all.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Applicable.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.notapplicable.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Reject.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.RequestforAuthorize.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.Msg.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.notapplicable.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Applicable.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.Msg.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
