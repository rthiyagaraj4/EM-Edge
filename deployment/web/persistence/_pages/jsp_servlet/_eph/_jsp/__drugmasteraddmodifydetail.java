package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.ArrayList;
import java.util.HashMap;
import ePH.DrugMasterBean;
import ePH.Common.*;
import eCommon.Common.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __drugmasteraddmodifydetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/DrugMasterAddModifyDetail.jsp", 1709120796784L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n <!--Fine Tuning-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></SCRIPT>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/DrugMasterDetail.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../js/PhCommon.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../ePH/js/DrugMaster.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\t<body  onKeyDown=\"lockKey()\" topmargin=\"0\">\n\t\t<form name=\"drugMasterAddModifyDetailForm\" id=\"drugMasterAddModifyDetailForm\" >\n\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"1\" id=\"detail\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t\t\t<tr>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\t\t\t\t<td width=\"35%\" class=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="<input type=\'hidden\' name=\'item_code";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' id=\'item_code";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"><input type=\'hidden\' name=\'item_desc";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' id=\'item_desc";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"></td>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"><a href=\'javascript:parent.callModify(\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\")\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</a><input type=\'hidden\' name=\'item_code";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t\t<td width=\"35%\" class=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t\t<td width=\"25%\" class=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="<input type=\'hidden\' name=\'stock_uom_code";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' id=\'stock_uom_code";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"><input type=\'hidden\' name=\'stock_uom_desc";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' id=\'stock_uom_desc";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\"></td>\n\t\t\t\t\t\t\t<td width=\"25%\" class=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="/";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="<input type=\'hidden\' name=\'base_uom";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' id=\'base_uom";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\"><input type=\'hidden\' name=\'strength_uom";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' id=\'strength_uom";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\"></td>\n\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t\t\t\t<td width=\"15%\" align=\"center\" class=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\"><input type=\'hidden\' name=\'flag";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' id=\'flag";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\"><input type=\'checkbox\' ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =" name=\'select";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' onClick=\'parent.assignValue(this);parent.updateFormModify(\"parent.drugMasterMain.document.drugMasterMainForm\")\' value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">&nbsp;<input type=\'hidden\' name=\'flag";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tparent.updateInventory(\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\");\n\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td width=\"30%\" class=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" wrap>\n\t\t\t\t\t\t\t\t<label style=\'cursor:pointer;color:blue;\'  onClick=\'parent.updateTrade(\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\",\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\")\'  id=\"trade_id\">\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t\t\t</label>\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'trade_id";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' id=\'trade_id";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'trade_name";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' id=\'trade_name";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td width=\"5\" class=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" nowrap>\n";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t\t\t\t\t<a href=\"javascript:parent.showImage(\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\');\">\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</a>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'trade_image_filename";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' id=\'trade_image_filename";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td width=\"35%\" class=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" wrap>";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="<input type=\'hidden\' name=\'manufacturer_id";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' id=\'manufacturer_id";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\"><input type=\'hidden\' name=\'manufacturer_name";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\' id=\'manufacturer_name";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\"></td>\n\t\t\t\t\t\t\t\t<td width=\"15%\" class=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\" wrap align=\"center\">";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="<input type=\'hidden\' name=\'disp_seq_no";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\' id=\'disp_seq_no";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t\t\t\t\t\t<td width=\"15%\" align=\"center\" class=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\'onClick =\'parent.assignValue(this);parent.updateFormModify(\"parent.drugMasterMain.document.drugMasterMainForm\")\' value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\"></td>\n\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'select_chk1";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\' id=\'select_chk1";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n\n";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tparent.updateTradeNames(\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\");\n\t\t\t\t\t\tparent.updateDispNo(\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td width=\"20%\" class=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'age_group_code";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\' id=\'age_group_code";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'short_desc";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\' id=\'short_desc";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\">\n\t\t\t\t\t\t\t</td> \n\t\t\t\t\t\t\t<td width=\"10%\" class=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" wrap>\n";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\t\n";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\t\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'gender";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\' id=\'gender";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\">&nbsp;</td>\n\t\t\t\t\t\t\t\t<td width=\"8%\" class=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="<input type=\'hidden\' name=\'min_age";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\' id=\'min_age";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\"></td> \n\t\t\t\t\t\t\t\t<td width=\"8%\" class=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="<input type=\'hidden\' name=\'max_age";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\' id=\'max_age";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\"></td>\n\t\t\t\t\t\t\t\t<td width=\"10%\" class=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\" wrap align=\"center\">\n";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'age_unit";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\' id=\'age_unit";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\"></td> \n";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t\t\t\t\t\t\t\t\t<td width=\"10%\" align=\"center\" class=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\"> \n\t\t\t\t\t\t\t\t\t\t<center>  \n\t\t\t\t\t\t\t\t\t\t<input type=\'checkbox\' ";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 =" name=\'select_drug_appl";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\'onClick =\'parent.assignValue(this);parent.updateFormModify(\"parent.drugMasterMain.document.drugMasterMainForm\")\'  value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\">\n\t\t\t\t\t\t\t\t\t\t<center>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'select_chk1_drug_appl";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\' id=\'select_chk1_drug_appl";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\">  \n\t\t\t\t\t\t\t\t\t<td width=\"8%\" align=\"center\" class=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 =" name=\'select_weight";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\'onClick =\'parent.assignValue(this );parent.updateFormModify(\"parent.drugMasterMain.document.drugMasterMainForm\")\'  value=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\">\n\t\t\t\t\t\t\t\t\t\t</center>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'select_chk1_weight";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\' id=\'select_chk1_weight";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\">  \n\t\t\t\t\t\t\t\t\t<!-- added for Bru-HIMS-CRF-079 IN[029945] -start -->\n\t\t\t\t\t\t\t\t\t<td width=\"8%\" align=\"center\" class=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 =" name=\'ht_mand_yn";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\">\n\t\t\t\t\t\t\t\t\t\t</center>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<!-- added for Bru-HIMS-CRF-079 IN[029945] -end -->\n\t\t\t\t\t\t\t\t\t <td width=\"10%\" align=\"center\" class=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\">\n\t\t\t\t\t\t\t\t\t\t<center> \n\t\t\t\t\t\t\t\t\t\t<input type=\'checkbox\' ";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\">\n\t\t\t\t\t\t\t\t\t\t</center>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'select_chk1";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\">\n\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'flag";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\">\n";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\">&nbsp;\n\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'flag";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tparent.updateGenericNames(\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\");\n\t\t\t\t\t\t//parent.updateDispNo(\"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\");\n\t\t\t\t\t</script>\n\t\t\t\t\n";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\n\t\t\t\t\t\t\t\t\t<td width=\"20%\" class=\"";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="<input type=\'hidden\' name=\'generic_id";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\' id=\'generic_id";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\" wrap><a href=\'javascript:parent.callModify(\"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="</a><input type=\'hidden\' name=\'generic_id";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\n\t\t\t\t\t\t\t\t<td width=\"20%\" class=\"";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\n\t\t\t\t\t\t\t<td width=\"40%\" class=\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="<input type=\'hidden\' name=\'generic_name";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\' id=\'generic_name";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\"></td>\n\t\t\t\t\t\t\t<td width=\"15%\" class=\"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="<input type=\'hidden\' name=\'drug_class";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\' id=\'drug_class";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\n\t\t\t\t\t\t\t\t<td width=\"10%\" align=\"center\" class=\"";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\");\n\t\t\t\t\t\n\t\t\t\t\t\tparent.updateDispNo(\"";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\n\t\t\t</table>\n";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\n\t\t\t\t<input type=\"hidden\" id=\"tot_rows\" name=\"rows\" id=\"rows\" value=\"";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\n\t\t\t\t<input type=\"hidden\" id=\"tot_rows\" name=\"rows\" id=\"rows\" value=\"\">\n";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\n\t\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\">\n\t\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\">\n\t\t\t<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\">\n\t\t</form>\n\t</body>\n</html>\n";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String bean_id				=	"DrugMasterBean" ;
	String bean_name			=	"ePH.DrugMasterBean";
	String mode					=	"";
	String link					=	request.getParameter("link");
	String item_code			=	"";
	String item_desc			=	"";
	String stock_uom_code		=	"";
	String stock_uom_desc		=	"";
	String base_uom				=	"";
	String strength_uom			=	"";
	String trade_id				=	"";
	String trade_name			=	"";
	String trade_image_filename	=	"";
	String manufacturer_id		=	"";
	String manufacturer_name	=	"";
	String generic_id			=	"";
	String generic_name			=	"";
	String drug_class			=	"";
	String disp_no				=	"";
	String select				=	"";
	String select_chk			=	"";
	String select_chk1			=	"";
	String flag					=	"";
	String eff_status			=	"";
	String classVal				=	"";
	String prescribing_desc		=	"";
	String age_group_code		=	"";
	String short_desc			=	"";
	String gender				=	"";
	String max_age				=	"";
	String age_unit				=	"";
	String min_age				=	"";
	String select_weight		=	"";
	String eff_status_weight	=	"";
	String select_chk_weight	=	"";
	String select_chk1_weight	=	"";
	String select_drug_appl		=	"";
	String eff_status_drug_appl	=	"";
	String select_chk_drug_appl	=	"";
	String select_chk1_drug_appl=	"";
	String ht_mand_yn = "N", ht_mand_chk = ""; //added for Bru-HIMS-CRF-079 IN[029945]
	int j						=	0;
	ArrayList inventory_values	=	null;
	ArrayList trade_values		=	null;
	ArrayList generic_values	=	null;
	ArrayList drugmastermain	=	null;
	ArrayList agegroupvalues	=	null;

	HashMap	record				=	null;

	DrugMasterBean beanObj		= (DrugMasterBean)getBeanObject(bean_id, bean_name, request);
	beanObj.setLanguageId(locale);
				mode		=	beanObj.getMode();
	drugmastermain			=	beanObj.getDrugmastermain();

	if(link.equals("inventory_tab"))	{
		inventory_values	=	beanObj.getInventory();
		prescribing_desc	=	beanObj.getPrescribingDesc();
	}
	else if(link.equals("trade_tab"))	{
		trade_values	=	beanObj.getTradeNames();
		if(!trade_values.equals("")){
			trade_values	=	beanObj.sortList(trade_values,"disp_seq_no");
		}
	}
	else if(link.equals("generic_tab"))	{
		generic_values	=	beanObj.getGenericNames();
	}
	else if(link.equals("weightrecording_tab"))	{
		agegroupvalues	=beanObj.getAgeGroups();
	}

            _bw.write(_wl_block5Bytes, _wl_block5);

		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
	
			try{
				if(inventory_values!=null && inventory_values.size()!=0){
					for(j=0; j<inventory_values.size(); j++)	{
						record	=	(HashMap)inventory_values.get(j);
						item_code			=	(String) record.get("item_code");
						item_desc			=	(String) record.get("item_desc");
						stock_uom_code		=	(String) record.get("stock_uom_code");
						stock_uom_desc		=	(String) record.get("stock_uom_desc");
						base_uom			=	(String) record.get("base_uom");

						if(mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY")))
							strength_uom		=	prescribing_desc;
						else
							strength_uom		=	(String) record.get("strength_uom");

						flag				=	(String) record.get("flag");

						if(!flag.equals("D"))	{
							if(flag.equals("I") || flag.equals("DN"))	{
								select			=	(String) record.get("select");

								if(select.equals("Y"))
									select_chk	=	"checked";
								else if(select.equals("N"))
									select_chk	=	"unchecked";
								else if(select.equals(""))
									select_chk	=	"disabled";

							}

							if(j%2 == 0)
								classVal	= "QRYEVEN";
							else
								classVal	= "QRYODD";

            _bw.write(_wl_block8Bytes, _wl_block8);
 
							if(mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY")))	{
								if(item_code.equals((String)drugmastermain.get(0)))	{

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(classVal));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(item_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(j));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(j));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(j));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(j));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(item_desc));
            _bw.write(_wl_block16Bytes, _wl_block16);
	
								}
								else{

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(classVal));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(j));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(item_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(j));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(j));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(j));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(j));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(item_desc));
            _bw.write(_wl_block16Bytes, _wl_block16);

								}
							}
							else{	

            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classVal));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(item_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(j));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(j));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(j));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(j));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(item_desc));
            _bw.write(_wl_block16Bytes, _wl_block16);
	
							}

            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(classVal));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(stock_uom_desc));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(j));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(j));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(stock_uom_code));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(j));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(j));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(stock_uom_desc));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classVal));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(base_uom));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(strength_uom));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(j));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(j));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(base_uom));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(j));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(j));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(strength_uom));
            _bw.write(_wl_block32Bytes, _wl_block32);
	
							if(flag.equals("I") || flag.equals("DB")){

            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classVal));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(j));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(flag));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(select_chk));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(j));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(select));
            _bw.write(_wl_block16Bytes, _wl_block16);

							}	
							else{	

            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classVal));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(j));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(j));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(flag));
            _bw.write(_wl_block16Bytes, _wl_block16);

							}
						}
					}

            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(inventory_values.size()));
            _bw.write(_wl_block41Bytes, _wl_block41);
 
				}
				else if(trade_values!=null && trade_values.size()!=0)	{
					for(j=0; j<trade_values.size(); j++)	{
						record	=	(HashMap)trade_values.get(j);

						trade_id			=	(String) record.get("trade_id");
						trade_name			=	(String) record.get("trade_name");
						manufacturer_id		=	(String) record.get("manufacturer_id");
						manufacturer_name	=	(String) record.get("manufacturer_name");
						disp_no				=	(String) record.get("disp_seq_no");
						flag				=	(String) record.get("flag");
						trade_image_filename =	(String) record.get("trade_image_filename")==null?"":(String) record.get("trade_image_filename");
						
						if(flag.equals("DB")||flag.equals("I") )	{
							if(flag.equals("I"))	{

								select				=	(String) record.get("select");
										
								if( select.equals("Y"))
									select_chk="checked";
								else
									select_chk="unchecked";
						
							}
							else if(flag.equals("DB")){
								eff_status =(String) record.get("eff_status");
								select =	(String) record.get("select")==null?"":(String) record.get("select");
								if(record.size()==8)
								eff_status =(String) record.get("eff_status");
								else{
								 if(((String)record.get("select")).equals("N") && ((String)record.get("eff_status")).equals("Y"))
									 eff_status="D";
									else  if( ((String)record.get("select")).equals("") && ((String)record.get("eff_status")).equals("N") )
										eff_status="D";
									else  if( ((String)record.get("select")).equals("") && ((String)record.get("eff_status")).equals("Y") )
										eff_status="E";
										
									else{
										String yy=(String) record.get("select");
										if(yy.equals("Y") )
											eff_status="E";
										else if(yy.equals("N"))
											eff_status="D";
									}
								}
								if(eff_status.equals("E")){
									select_chk="checked";
									select_chk1="Y";
								}
								else {
									select_chk="unchecked";
									select_chk1="N"; 
								}
							}
				   
							if(j%2 == 0)
								classVal	= "QRYEVEN";
							else
								classVal	= "QRYODD";

            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(classVal));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(j));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(java.net.URLEncoder.encode(trade_name,"UTF-8")));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(trade_id));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(disp_no));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(java.net.URLEncoder.encode(manufacturer_name,"UTF-8")));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(select));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(manufacturer_id));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(trade_image_filename));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(trade_name));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(j));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(j));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(trade_id));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(j));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(j));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(trade_name));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(classVal));
            _bw.write(_wl_block51Bytes, _wl_block51);

								if(!trade_image_filename.equals("")){

            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(trade_image_filename));
            _bw.write(_wl_block53Bytes, _wl_block53);

								}

            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(j));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(trade_image_filename));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(classVal));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(java.net.URLDecoder.decode(manufacturer_name,"UTF-8")));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(j));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(j));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(manufacturer_id));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(j));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(j));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(manufacturer_name));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(classVal));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(disp_no));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(j));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(j));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(disp_no));
            _bw.write(_wl_block16Bytes, _wl_block16);
		
								if(flag.equals("I")||flag.equals("DB"))	{	

            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(classVal));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(j));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(flag));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(select_chk));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(j));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(select));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(j));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(j));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(select_chk1));
            _bw.write(_wl_block71Bytes, _wl_block71);
	
								}
								else{	

            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(classVal));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(j));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(j));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(flag));
            _bw.write(_wl_block16Bytes, _wl_block16);

								}

            _bw.write(_wl_block72Bytes, _wl_block72);

						}
					}

            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(trade_values.size()));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(disp_no));
            _bw.write(_wl_block41Bytes, _wl_block41);

				}
				else if(agegroupvalues!=null && agegroupvalues.size()!=0)	{
					for(j=0; j<agegroupvalues.size(); j++)	{
						
						record	=	(HashMap)agegroupvalues.get(j);
						age_group_code			=	(String) record.get("age_group_code");
						short_desc				=	(String) record.get("short_desc");
						gender					=	(String) record.get("gender");
						max_age					=	(String) record.get("max_age");
						age_unit				=	(String) record.get("age_unit");
						flag					=	(String) record.get("flag");
						min_age					=	(String) record.get("min_age");
										
						if(flag.equals("DB")||flag.equals("I") )	{
							if(flag.equals("I"))	{
								select				=	(String) record.get("select");
								select_weight		=(String) record.get("select_weight");
								select_drug_appl=(String) record.get("select_drug_appl");
								ht_mand_yn=(String) record.get("ht_mand_yn")==null?"N":(String) record.get("ht_mand_yn");  //added for Bru-HIMS-CRF-079 IN[029945]
								if( select.equals("Y"))
									select_chk="checked";
								else
									select_chk="unchecked";
								
								if( select_weight.equals("Y"))
									select_chk_weight="checked";
								else
									select_chk_weight="unchecked";
								if( select_drug_appl.equals("Y"))
									select_chk_drug_appl="checked";
								else
									select_chk_drug_appl="unchecked";
						
							}
							else if(flag.equals("DB")){
								
								eff_status_weight	 =(String) record.get("eff_status_weight");
								eff_status			 =(String) record.get("eff_status");
								eff_status_drug_appl =(String) record.get("eff_status_drug_appl");
								select =	(String) record.get("select")==null?"":(String) record.get("select");
								select_weight		=(String) record.get("select_weight")==null?"":(String) record.get("select_weight");
								select_drug_appl=(String) record.get("select_drug_appl")==null?"":(String) record.get("select_drug_appl");
								ht_mand_yn=(String) record.get("ht_mand_yn")==null?"N":(String) record.get("ht_mand_yn");  //added for Bru-HIMS-CRF-079 IN[029945]
								if(record.size()==11) {
									eff_status = ((String)record.get("eff_status"));
								}
								else{    
									if(((String)record.get("select")).equals("N") && ((String)record.get("eff_status")).equals("Y"))
										eff_status="D";
									else  if( ((String)record.get("select")).equals("") && ((String)record.get("eff_status")).equals("N") )
										eff_status="D";
									else  if( ((String)record.get("select")).equals("") && ((String)record.get("eff_status")).equals("Y") )
										eff_status="E";
									else{
										String yy=(String) record.get("select");
										if(yy.equals("Y") )
											eff_status="E";
										else if(yy.equals("N"))
											eff_status="D";
									}
									if(select_drug_appl.equals("") && ((String)record.get("eff_status_drug_appl")).equals("N"))
										eff_status_drug_appl="N";
									else if(select_drug_appl.equals("") && ((String)record.get("eff_status_drug_appl")).equals("Y"))
										eff_status_drug_appl="Y";
									else
										eff_status_drug_appl=(String) record.get("select_drug_appl");
									
									if(select_weight.equals("") && ((String)record.get("eff_status_weight")).equals("N"))
										eff_status_weight="N";
									else if(select_weight.equals("") && ((String)record.get("eff_status_weight")).equals("Y"))
										eff_status_weight="Y";
									else
										eff_status_weight=(String) record.get("select_weight");
									ht_mand_yn=(String) record.get("ht_mand_yn")==null?"N":(String) record.get("ht_mand_yn");  //added for Bru-HIMS-CRF-079 IN[029945]
								}
								if(eff_status.equals("E")) {
									select_chk="checked";
									select_chk1="Y";
									select ="Y";
								}
								else {
									select_chk="unchecked";
									select_chk1="N"; 
									select = "N";
								}
								
								if(eff_status_weight.equals("Y")) {
									select_chk_weight="checked";
									select_chk1_weight="Y";
								}
								else {
									select_chk_weight="unchecked";
									select_chk1_weight="N"; 
								}
								if(eff_status_drug_appl.equals("Y")){
									select_chk_drug_appl="checked";
									select_chk1_drug_appl="Y";
								}
								else {
									select_chk_drug_appl="unchecked";
									select_chk1_drug_appl="N"; 
								}
							}

						if(ht_mand_yn.equals("Y")) { //added for Bru-HIMS-CRF-079 IN[029945] -start
							ht_mand_chk="checked";
						}
						else {
							ht_mand_chk="";
							ht_mand_yn="N"; 
						} //added for Bru-HIMS-CRF-079 IN[029945] -end
						if(j%2 == 0)
							classVal	= "QRYEVEN";
						else
							classVal	= "QRYODD";

            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(classVal));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(j));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(j));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(age_group_code));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(j));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(j));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(classVal));
            _bw.write(_wl_block81Bytes, _wl_block81);

								if(gender.equals("") || gender.equals("A")){

            _bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block1Bytes, _wl_block1);

								}
								else if(gender.equals("M")){

            _bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block83Bytes, _wl_block83);
	 
								}
								else if(gender.equals("F")){

            _bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block83Bytes, _wl_block83);

								}

            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(j));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(j));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(classVal));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(min_age));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(j));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(j));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(min_age));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(classVal));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(max_age));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(j));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(j));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(max_age));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(classVal));
            _bw.write(_wl_block93Bytes, _wl_block93);

								if(age_unit.equals("Y")){

            _bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block1Bytes, _wl_block1);

								}
								else if(age_unit.equals("D")){

            _bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block1Bytes, _wl_block1);

								}
								else if(age_unit.equals("M")){

            _bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block1Bytes, _wl_block1);

								}
								else if(age_unit.equals("H")){

            _bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block1Bytes, _wl_block1);

								}
								else if(age_unit.equals("N")){

            _bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block1Bytes, _wl_block1);

								}

            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(j));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(j));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(age_unit));
            _bw.write(_wl_block96Bytes, _wl_block96);
		
								if(flag.equals("I")||flag.equals("DB"))	{

            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(classVal));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(select_chk_drug_appl));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(j));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(select_drug_appl));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(j));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(j));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(select_chk1_drug_appl));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(classVal));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(select_chk_weight));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(j));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(select_weight));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(j));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(j));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(select_chk1_weight));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(classVal));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(ht_mand_chk));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(j));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(ht_mand_yn));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(classVal));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(select_chk));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(j));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(select));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(j));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(j));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(select_chk1));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(j));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(j));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(flag));
            _bw.write(_wl_block114Bytes, _wl_block114);
	
								}
								else{	

            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(classVal));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(j));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(j));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(flag));
            _bw.write(_wl_block16Bytes, _wl_block16);

								}

            _bw.write(_wl_block72Bytes, _wl_block72);

						}
					}

            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(agegroupvalues.size()));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(disp_no));
            _bw.write(_wl_block118Bytes, _wl_block118);

				}
				else if(generic_values!=null && generic_values.size()!=0)	{
					for(j=0; j<generic_values.size(); j++)	{
						record	=	(HashMap)generic_values.get(j);
						generic_id				=	(String) record.get("generic_id");
						generic_name			=	(String) record.get("generic_name");
						drug_class				=	(String) record.get("drug_class");
						disp_no					=	(String) record.get("disp_seq_no");
						flag					=	(String) record.get("flag");

						if(!flag.equals("D"))	{
							if(flag.equals("I") || flag.equals("DN"))	{

							select					=	(String) record.get("select");

							if(select.equals("Y"))
								select_chk	=	"checked";
							else if(select.equals("N"))
								select_chk	=	"unchecked";
							else if(select.equals(""))
								select_chk	=	"disabled";
							}

							if(j%2 == 0)
								classVal	= "QRYEVEN";
							else
								classVal	= "QRYODD";

            _bw.write(_wl_block8Bytes, _wl_block8);
	
							if(mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY")))	{
								if(generic_id.equals((String)drugmastermain.get(6)))	{	

            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(classVal));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(j));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(j));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
	
								}
								else{	

            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(classVal));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(j));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(j));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(j));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
	
								}
							} 
							else{	

            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(classVal));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(j));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(j));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(j));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
	
							}

            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(classVal));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(generic_name));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(j));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(j));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(generic_name));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(classVal));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(drug_class));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(j));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(j));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(drug_class));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(classVal));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(disp_no));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(j));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(j));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(disp_no));
            _bw.write(_wl_block16Bytes, _wl_block16);

							if(flag.equals("I") || flag.equals("DN"))	{	

            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(classVal));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(j));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(flag));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(select_chk));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(j));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(select));
            _bw.write(_wl_block16Bytes, _wl_block16);
	
							}
							else{	

            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(classVal));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(j));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(j));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(flag));
            _bw.write(_wl_block16Bytes, _wl_block16);

							}
						}
					}

            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(generic_values.size()));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(disp_no));
            _bw.write(_wl_block41Bytes, _wl_block41);

				}

            _bw.write(_wl_block133Bytes, _wl_block133);

			}
			catch(Exception e){
				e.printStackTrace();
			}
			if(inventory_values!=null && inventory_values.size()!=0){

            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(inventory_values.size()-1));
            _bw.write(_wl_block114Bytes, _wl_block114);

			}
			else	if(trade_values!=null && trade_values.size()!=0) {

            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(trade_values.size()-1));
            _bw.write(_wl_block114Bytes, _wl_block114);
	
			}
			else if(generic_values!=null && generic_values.size()!=0){

            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(generic_values.size()-1));
            _bw.write(_wl_block114Bytes, _wl_block114);
	
			}else if(agegroupvalues!=null && agegroupvalues.size()!=0){
	

            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(agegroupvalues.size()-1));
            _bw.write(_wl_block114Bytes, _wl_block114);
	
			}
			else{

            _bw.write(_wl_block135Bytes, _wl_block135);

			}

            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf( bean_name ));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block139Bytes, _wl_block139);

	putObjectInBean(bean_id,beanObj,request);

            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Image.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.all.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.male.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.female.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Years.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Day(s).label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.months.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Hour(s).label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Minute(s).label", java.lang.String .class,"key"));
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
}
