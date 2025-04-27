package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.text.DecimalFormat;
import java.util.*;
import ePH.*;
import ePH.Common.*;
import eST.*;
import eST.Common.*;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __dispmedicationallocatedrugswithstk extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/DispMedicationAllocateDrugsWithStk.jsp", 1709120711317L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n/*******************************************************************************\n * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.\n *  \n * Warning: This computer program is protected by copyright law and international treaties.\n * Unauthorized reproduction or distribution of this program, or any portion of it, \n * may result in severe civil and criminal penalties, and will be prosecuted to \n * the maximum extent possible under the law.\n ******************************************************************************/\n/*\n--------------------------------------------------------------------------------------------------------------\nDate\t\t\tEdit History       Name\t\t\t     Description\n--------------------------------------------------------------------------------------------------------------\n?\t\t\t\t100\t\t\t\t\t?                created\n05/12/2017      [IN:064158]     Devindra    Change in barcode scanning functionality in Dispense Medication(in each scan one quantity need to add).\n11/5/2022\t\tTFS:25853\t\t\tShazana\t\t\t\tSKR-SCF-1643\n11/5/2022\t\tTFS:25854\t\t\tShazana\t\t\t\tSKR-SCF-1644\n11/5/2022\t\tTFS:25855\t\t\tShazana\t\t\t\tSKR-SCF-1645\n31/07/2022                          Chandrashekar Raju  MMS-MD-SCF-0204\n---------------------------------------------------------------------------------------------------------------\n*/ -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<HTML>\n\t<HEAD>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\t\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/common.js\"></SCRIPT>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/DispMedicationAllStages.js\"></script>\n\t\t<SCRIPT LANGUAGE=\"Javascript\" SRC=\"../../eCommon/js/ValidateControl.js\"></SCRIPT>\n\t\t<SCRIPT LANGUAGE=\"JavaScript\" SRC=\"../../ePH/js/PhCommon.js\"></SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</HEAD>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<!-- <body> -->\n\t<body onMouseDown=\"\" onKeyDown=\"lockKey()\" > \n\t\t<form name=\"DispMedicationAllocateDrugsWithStock\" id=\"DispMedicationAllocateDrugsWithStock\">\n\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"1\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\t\t\t\t\t\t<tr><td colspan=\"8\"  class=\"CURRTEXT\"><font size=\"1\" style=\"font-weight:bold\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" : ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</font></td></tr>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td  width=\"10%\" class=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"item_drug_code";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" id=\"item_drug_code";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"><input type=\"hidden\" name=\"item_drug_color";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" id=\"item_drug_color";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">&nbsp;";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="<input type=\"hidden\" name=\"expiry_date";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" id=\"expiry_date";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<td  width=\"10%\" class=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="<input type=\"hidden\" name=\"batch_id";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" id=\"batch_id";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"></td>\n\t\t\t\t\t\t\t\t\t\t<td  width=\"20%\" class=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t\t\t\t\t\t<img style=\"cursor:pointer;\" src=\"../../ePH/images/camera.gif\" height=20  width=20 onClick=\"showImage(\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\',\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\')\">\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"trade_id";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" id=\"trade_id";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<td  width=\"20%\" class=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>\n\t\t\t\t\t\t\t\t\t\t<td  width=\"15%\" class=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="<input type=\"hidden\" name=\"bin_locn_code";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" id=\"bin_locn_code";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\"></td>\n\t\t\t\t\t\t\t\t\t\t<td  width=\"10%\" class=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="<input type=\"hidden\" name=\"alloc_qty";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" id=\"alloc_qty";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\"></td>\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t\t\t\t\t\t<td  width=\"15%\" class=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"flat\" size=\"8\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" name=\"issue_qty";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" style=\"text-align:right\"   onKeyPress=\"if(event.keyCode!=13) {return allowValidNumber(this,event,6,0);}else{return false;}\"  onBlur=\"if(validateQty(this,\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\')){setQtyBsdOnIssueUOM(this,\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\')};\" maxlength=\"5\">&nbsp;<b><label class=\"label\" id=\"issue_uom_lbl";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" style=\"font-size:9\">";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</label></b> <!--MMS-SCF-0040 uom_code - > base_uom -->\n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"base_uom";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" id=\"base_uom";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"issue_uom";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" id=\"issue_uom";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"disp_uom";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" id=\"disp_uom";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"base_to_disp_uom_equl";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" id=\"base_to_disp_uom_equl";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"base_to_def_uom_equl";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" id=\"base_to_def_uom_equl";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"issue_qty_old";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" id=\"issue_qty_old";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"issue_uom_qty";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" id=\"issue_uom_qty";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" value=\"\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"issue_uom_uom";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\" id=\"issue_uom_uom";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" value=\"\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"issue_uom_desc";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" id=\"issue_uom_desc";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\" value=\"\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"issue_uom_equl";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" id=\"issue_uom_equl";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\" value=\"\">\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<td  width=\"5%\" class=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\"><input type=\"checkbox\"  name=\"select";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" id=\"select";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" ";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 =" onClick=\"validateCheck(this,\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\')\"></td>\n\t\t\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t\t\t\t\t<tr><td colspan=\"8\"  class=\"CURRTEXT\"><font size=\"1\" style=\"font-weight:bold\">";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td  width=\"10%\" class=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"item_drug_code";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\">\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td  width=\"10%\" class=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\"></td>\n\t\t\t\t\t\t\t<td  width=\"20%\" class=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t\t\t\t\t\t<img style=\"cursor:pointer;\" src=\"../../ePH/images/camera.gif\" height=20  width=20 onClick=\"showImage(\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"trade_id";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\">\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td  width=\"20%\" class=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="</td>\n\t\t\t\t\t\t\t<td  width=\"15%\" class=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\"></td>\n\t\t\t\t\t\t\t<td  width=\"10%\" class=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t\t\t\t\t<td  width=\"15%\" class=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\">\n\t\t\t\t\t\t\t\t<input type=\"text\" class=\"flat\" size=\"8\" value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\" style=\"text-align:right\"  onKeyPress=\"if(event.keyCode!=13) {return allowValidNumber(this,event,6,0);}else{return false;}\"  onBlur=\"if(validateQty(this,\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="</label></b>\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"base_uom";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"issue_uom";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"disp_uom";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"base_to_disp_uom_equl";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"base_to_def_uom_equl";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"issue_qty_old";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"issue_uom_qty";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\" value=\"\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"issue_uom_uom";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\" value=\"\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"issue_uom_desc";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\" value=\"\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"issue_uom_equl";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\" value=\"\">\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td  width=\"5%\" class=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\')\"></td>\n\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t\t\t</table>\n\t\t\t<br>\n\t\t\t<br>\n\t\t\t<br>\n\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"0\">\n";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\t\t\t\t\t<tr><td  class=\"DISPDTL\"><font color=\"WHITE\" size=\"2\">";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 =" :";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 =" </font></td></tr>\n";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t\t\t</table>\n\t\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\">\n\t\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\">\n\t\t\t<input type=\"hidden\" name=\"drug_code\" id=\"drug_code\" value=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\"> \n\t\t\t<input type=\"hidden\" name=\"totalRecords\" id=\"totalRecords\" value=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\"> \n\t\t\t<input type=\"hidden\" name=\"alt_drug_code\" id=\"alt_drug_code\" value=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\"> \n\t\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\"> \n\t\t\t<input type=\"hidden\" name=\"order_id\" id=\"order_id\" value=\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\"> \n\t\t\t<input type=\"hidden\" name=\"sys_date\" id=\"sys_date\" value=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\">\n\t\t\t<input type=\"hidden\" name=\"uom\" id=\"uom\" value=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\">\n\t\t\t<input type=\"hidden\" name=\"bms_qty\" id=\"bms_qty\" value=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\">\n\t\t\t<input type=\"hidden\" name=\"order_line_no\" id=\"order_line_no\" value=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\">\n\t\t\t<input type=\"hidden\" name=\"source\" id=\"source\" value=\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\">\n\t\t\t<input type=\"hidden\" name=\"recno\" id=\"recno\" value=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\">\n\t\t\t<input type=\"hidden\" name=\"tot_qty\" id=\"tot_qty\" value=\"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\">\n\t\t\t<input type=\"hidden\" name=\"item_cost\" id=\"item_cost\" value=\"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\">\n\t\t\t<input type=\"hidden\" name=\"oper_mode\" id=\"oper_mode\" value=\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\">\n\t\t\t<input type=\"hidden\" name=\"drug_class\" id=\"drug_class\" value=\"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\">\n\t\t\t<input type=\"hidden\" name=\"disp_narcotic_yn\" id=\"disp_narcotic_yn\" value=\"";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\">\n\t\t\t<input type=\"hidden\" name=\"disp_controlled_yn\" id=\"disp_controlled_yn\" value=\"";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\"> <!--added for SKR-SCF-0688 [IN:036036]-->\n\t\t\t<input type=\"hidden\" name=\"disp_auth_yn\" id=\"disp_auth_yn\" value=\"";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\">\n\t\t\t<input type=\"hidden\" name=\"issuebyuom\" id=\"issuebyuom\" value=\"";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\">\n\t\t\t<input type=\"hidden\" name=\"alt_drg_no\" id=\"alt_drg_no\" value=\"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\">\n\t\t\t<input type=\"hidden\" name=\"userAuthPINYN\" id=\"userAuthPINYN\"\tvalue=\"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\">  <!-- Added for RUT-CRF-0035 [IN029926] -->\n\t\t\t<input type=\"hidden\" name=\"pres_qty_alert\" id=\"pres_qty_alert\" value=\"";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\"><!-- code added for AMS-CRF-0035[IN033551] -->   \n\t\t\t<input type=\"hidden\" name=\"disp_decimal_dtls_yn\" id=\"disp_decimal_dtls_yn\" value=\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\"> <!-- Added for AAKH-SCF-0113 [IN:048937] -->\n\t\t\t<input type=\"hidden\" name=\"allow_decimals_yn\" id=\"allow_decimals_yn\" value=\"";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\">  <!-- Added for AAKH-SCF-0113 [IN:048937] -->\n";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\n\t\t\t<input type=\"hidden\" name=\"AllowMoreThanPresQty\" id=\"AllowMoreThanPresQty\" value=\"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\">\n\n\t\t</form>\n\t</body>\n\t<script>\n";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\n\t\tcontrolStockImage(\'";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\')// added for KDAH-CRF-0231 [IN-034551]\n\t\t</script>\n";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\n\t<script>\n\t\tissueUOM(parent.f_stock_dtls.DispMedicationStockDetails.issue_uom_select);\n\t</script>\n\t";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\n</html>\n";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );
	
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

 
	DecimalFormat dfToInteger = new DecimalFormat("#.##");
	private String retunFormatedInt(String sValue){
		if(sValue != null && !sValue.equals("")){
			return dfToInteger.format(Double.parseDouble(sValue));
		}
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String facility_id			= (String)session.getAttribute("facility_id");  //Added for RUT-CRF-0035 [IN029926]
		
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	try{
	String drug_code			=	CommonBean.checkForNull(request.getParameter("drug_code"));
	String item_code			=	CommonBean.checkForNull(request.getParameter("item_code"));
	String patient_id			=	CommonBean.checkForNull(request.getParameter("patient_id"));
	String order_id				=	CommonBean.checkForNull(request.getParameter("order_id"));
	String order_line_no		=	CommonBean.checkForNull(request.getParameter("order_line_no"));
	String drug_color			=	CommonBean.checkForNull(request.getParameter("drug_color"));
	String alt_drug_code		=	CommonBean.checkForNull(request.getParameter("alt_drug_code"));
	String qty					=	CommonBean.checkForNull(request.getParameter("qty"));
	String uom					=	CommonBean.checkForNull(request.getParameter("uom_code"));
	String uom_code				=	CommonBean.checkForNull(request.getParameter("uom_code"));
	String source				=	CommonBean.checkForNull(request.getParameter("source"));
	String recno				=	CommonBean.checkForNull(request.getParameter("no"));
	String store_code			=	CommonBean.checkForNull(request.getParameter("store_code"));
	String end_date				=	CommonBean.checkForNull(request.getParameter("end_date"));
	String drug_strength		=	CommonBean.checkForNull(request.getParameter("drug_strength"));
	String alt_drug_strength	=	CommonBean.checkForNull(request.getParameter("alt_drug_strength"));
	String called_from			=	CommonBean.checkForNull(request.getParameter("called_from"));
	String bms_strength			=	CommonBean.checkForNull(request.getParameter("bms_strength"));
	String oper_mode			=	CommonBean.checkForNull(request.getParameter("oper_mode"));
	String drug_class			=	CommonBean.checkForNull(request.getParameter("drug_class"));
	String stk_qty				=	CommonBean.checkForNull(request.getParameter("stk_qty"));	
	String min_end_date			=	CommonBean.checkForNull(request.getParameter("min_end_date"));
    String main_strength_per_value_pres_uom =CommonBean.checkForNull(request.getParameter("main_strength_per_value_pres_uom"));
    String alt_drg_no			=	CommonBean.checkForNull(request.getParameter("alt_drg_no"));
    String prescribed_strength	=	CommonBean.checkForNull(request.getParameter("prescribed_strength"));
    String barcode_flg			=	request.getParameter("barcode_flg");//Added for KDAH-CRF-0231 [IN-034551]
	String all_params			=	request.getQueryString();
	String bms_qty				=	qty;
	String main_drug_bms_qty    =   qty; 
	if(drug_strength==null)		
	     drug_strength		=	"";
	if(alt_drug_strength==null) 
	     alt_drug_strength	=	"";
	if(called_from==null)		
	     called_from			=	"";
	if(oper_mode==null)			
	      oper_mode	=	"";

	String class_name			=	"";
	String batch_id				=	"";
	String expiry_date			=	"";
	String issue_qty			=	"";
	String item_drug_code		=	"";
	String trade_name			=	"";
	String manufacturer_name	=	"";
	String bin_location			=	"";
	String trade_id				=	"";
	String bin_locn_code		=	"";
	String fractroundupyn       =   "";
	String drug_pack_size       =   "";
	String repeat_value		    =   "";
	String strength_value       =   "";
	String qty_value		    =   "";
	String strength_per_value_pres_uom="";
//	String tot_strength			=   "";	
	String bms_strength_1		=	"";	
	String dflt_issue_uom		=   "";
	String base_uom				=	"";
	String sOrigBatchId			=	"";
	String sPastExpDate			=	"";
	String sPastBinLocn			=	"";
	String  disp_avail_qty = ""; //Added for  MMS-SCF-0040 [IN:041888]
	boolean bConsiderOldBatchDetails	=false;
	int duration				=   0;	
	int duration1				=   0;
	if(drug_color==null)	
				drug_color		=	"";
	if(alt_drug_code==null)	
				alt_drug_code	=	"";

	HashMap		stock				=	new HashMap();
	ArrayList   for_stock_1			=	new ArrayList();
	ArrayList   for_stock_2			=	new ArrayList();
	ArrayList	stock_detail		=	new ArrayList();
	HashMap		drug_detail			=	new HashMap();
	ArrayList	all_drug_detail		=	new ArrayList();

	ArrayList batch_val=new ArrayList();//new list object added for KDAH-CRF-0231 [IN-034551] 
	String bean_id					= "DispMedicationAllStages" ;
	String bean_name				= "ePH.DispMedicationAllStages";
	DispMedicationAllStages bean	= (DispMedicationAllStages)getBeanObject( bean_id, bean_name , request) ;
	bean.setLanguageId(locale);

	String	bean_id_1				=	"DispMedicationBean" ;
	String	bean_name_1				=	"ePH.DispMedicationBean";	
	DispMedicationBean bean_1		= (DispMedicationBean)getBeanObject( bean_id_1, bean_name_1, request);
	bean_1.setLanguageId(locale);

	String Image_bean_id				= "@DrugTradeImageBean";
	String Image_bean_name				= "ePH.DrugTradeImageBean";
	DrugTradeImageBean drug_trade_bean	= (DrugTradeImageBean)getBeanObject( Image_bean_id, Image_bean_name, request );

    String	bean_id_2				=	"StUtilities" ;
	String	bean_name_2				=	"eST.Common.StUtilities";

	String	bean_id_3				=	"batchSearchBean" ;
	String	bean_name_3				=	"eST.BatchSearchBean";

	String disp_auth_yn				=   CommonBean.checkForNull((String)bean_1.getDispAutharizationYN(drug_code));	
	String strResetQty				=	bean_1.getStrResetQty()==null?"":bean_1.getStrResetQty();
	boolean bPRNOrAbsOrder			=	bean.getBPRNOrAbsOrder();
	if( strResetQty.equals("null"))
     	strResetQty="";
   
	int opdispperiod			   = Integer.parseInt(bean_1.getFillPeriod());

	if(bPRNOrAbsOrder)
		opdispperiod = 999;

	String sRepeatFreqCode		= "";
	String sFreqCode			= "";
	// For Multi Frequency 
	String  st_disp_decimal_dtls_yn="", st_allow_decimals_yn="N"; //Added for AAKH-SCF-0113 [IN:048937] start
	st_disp_decimal_dtls_yn =bean.getSt_disp_decimal_dtls_yn(); // Added for AAKH-SCF-0113 [IN:048937] -end

	sRepeatFreqCode			=	bean_1.getFreqRepeatCode(order_id, order_line_no).split("~")[0];
	sFreqCode				=	bean_1.getFreqRepeatCode(order_id, order_line_no).split("~")[1];

	Float fTotalDuration = Float.parseFloat(bean_1.getDurationValue(order_id+order_line_no));

	String sOrigDispUnit	= bean_1.getStrChangedDispenseUnit() != null?bean_1.getStrChangedDispenseUnit():"D";
	String sOrigDispPeriod	= bean_1.getStrChangedDispensePeriod() != null?bean_1.getStrChangedDispensePeriod():"1";

	String userAuthPINYN		= bean.getUserAuthPINRequiredYN(); //RUT-CRF-0035 [IN029926] Added for User Auth PIN Validation
    String medical_applicable=bean.checkMedicalItemYN(item_code);//added for ghl-crf-0548
	if(sRepeatFreqCode.equals("W")){
		if(sOrigDispUnit.equals("H")){
			//opdispperiod = (int) Math.ceil((Float.parseFloat(opdispperiod+"")/(24*7)))*7; // divide by 24 to make day and divide by 7 to convert to week and ceil it.
			opdispperiod = (int) Math.ceil((Float.parseFloat(opdispperiod+"")/7)*7);//Added for ARYU-SCF-0077 removed 24 because opdispperiod already converted to day in validation page
		}else if(sOrigDispUnit.equals("D")){
			//opdispperiod = (int) Math.ceil((Float.parseFloat(opdispperiod+"")/7))*7;//Commented for ARYU-SCF-0077
			opdispperiod = (int) Math.ceil((Float.parseFloat(opdispperiod+"")/7)*7);//Added for ARYU-SCF-0077
		}else if(sOrigDispUnit.equals("M"))
			opdispperiod = (int) Integer.parseInt(sOrigDispPeriod)*4*7;
	}
	else if(sRepeatFreqCode.equals("M")){
		if(sOrigDispUnit.equals("H"))
			opdispperiod = (int) Math.ceil((Float.parseFloat(opdispperiod+"")/(24*30)))*30; 
		else if(sOrigDispUnit.equals("D"))
			opdispperiod = (int) Math.ceil((Float.parseFloat(opdispperiod+"")/30))*30;
		else if(sOrigDispUnit.equals("W"))
			opdispperiod = (int)Math.ceil((Float.parseFloat(opdispperiod+"")/4))*30 ;
	}

	if(sFreqCode.equals("H"))
		fTotalDuration = fTotalDuration/24;
	else if(sFreqCode.equals("W"))
		fTotalDuration = fTotalDuration*7;
	else if(sFreqCode.equals("L"))
		fTotalDuration = fTotalDuration*30;
	else if(sFreqCode.equals("Y"))
		fTotalDuration = fTotalDuration*365;

    String allow_short_expiry_drugs_yn =bean_1.getAllow_short_expiry_drugs_yn();
	String	sys_date		=	bean.getCurrDate();
	ArrayList disp_info		=	new ArrayList(2);
	if(!oper_mode.equals("auto")) {
		disp_info	=	bean.getLastDispense(order_id,order_line_no);
	}

	/** Stock Bean Integration -Start ***/
	StUtilities bean_2=null;
	try { 
		bean_2 = (StUtilities) getBeanObject( bean_id_2,  bean_name_2, request );
		bean_2.setLanguageId(locale);
	}	
	//catch (eST.Common.InsufficientBatchException exception) {
	//	out.println(exception.getAvailableQuantity());
	//	exception.printStackTrace();
	//}
	catch (Exception exception) {
		out.println(exception);
		exception.printStackTrace();
	}

	BatchSearchBean bean_3	= (BatchSearchBean)getBeanObject( bean_id_3, bean_name_3, request);
	bean_3.setLanguageId(locale);
	/** Stock Bean Integration -End ***/ 
	if(strResetQty.equals("") || strResetQty.equals("false")){
		if(alt_drug_code.equals("")) {
			//stock_qty			=	bean.getTotalStockQty(patient_id,order_id,order_line_no);
			all_drug_detail		=	bean.getDrugDetail(patient_id,order_id,order_line_no);
		}
		else {
			//stock_qty			=	bean.getTotalAlternateStockQty(patient_id,order_id,order_line_no);
			all_drug_detail		=	bean.getAlternateDrugDetail(patient_id,order_id,order_line_no,alt_drug_code);
		}
	}
	else{
		if(alt_drug_code.equals("")) {
		      bean.setDrugDetail(patient_id,order_id,order_line_no,new ArrayList());
		}
		else{
			  bean.setAlternateDrugDetail(patient_id,order_id, order_line_no,new ArrayList(),alt_drug_code);
		}
	}
	if(all_drug_detail.size()!=0) {
		for(int k=0; k<all_drug_detail.size(); k+=10) { //9->10 for MMS-SCF-0040 [IN:041888]
			for_stock_1		=	new ArrayList();
			batch_id		=	(String)all_drug_detail.get(k+1);
			expiry_date		=	(String)all_drug_detail.get(k+2);
			bin_locn_code	=	(String)all_drug_detail.get(k+7);				
			for_stock_1.add(batch_id);
			for_stock_1.add(expiry_date);
			for_stock_1.add(bin_locn_code);
			for_stock_2.add(for_stock_1);
		}
	}
	
	sOrigBatchId	= batch_id;
	sPastExpDate	= expiry_date;
	sPastBinLocn	= bin_locn_code;
	if(called_from != null && called_from.equals("stock")&& sOrigBatchId!=null && !sOrigBatchId.equals("")&& sPastExpDate!=null && !sPastExpDate.equals("")&& sPastBinLocn!=null && !sPastBinLocn.equals("")){
		bConsiderOldBatchDetails = true;
	}

	if(alt_drug_code.equals("")){
		item_drug_code	=	drug_code;
	}
	else{
		item_drug_code	=	alt_drug_code;
	}

	if(!called_from.equals("")) {
		bean.setStockAvailability(order_id+order_line_no,item_code);
	} 

	String tmp_drug_code		=	item_drug_code;
	String tmp_drug_color		=	drug_color;
	String item_drug_color		=	drug_color; 
	String tmp_item_code		=	"";
	String quantity				=	"";
	String select_status		=	"";
	String Order_qty            =   "";
	String split_yn				=   "";
	ArrayList stock_items		=	new ArrayList();
	String  image_path			=   "";
	String default_yn			=   "N";
	double base_to_disp_uom_equl	=   0;
	double base_to_def_uom_equl	=	0; 
	double conv_factor				=   0;
	double  issue_qty_val     = 0;
	double  issue_qty_val_1   = 0;
	//Added for KDAH-CRF-0231 [IN-034551]
	int temp_count=0;
	ArrayList batch_chk_list=new ArrayList();
	HashMap batch_chk_map=new HashMap();
	HashMap st_batch_map=new HashMap();
	int tot_alt_drug_qty        = 0;
	//Added for KDAH-CRF-0231 [IN-034551]
	HashMap tempstock=new HashMap();
	//Added for KDAH-CRF-0231 [IN-034551]
	if(alt_drug_code.equals("")) {
		bean.addItems(drug_code,item_code);
		qty		=	new Float(qty).intValue()+"";
	}
	else {
		bean.removeItems(drug_code);
		bean.addItems(alt_drug_code,item_code);
		//HashMap pack_dtls	=	bean.getPackSize(alt_drug_code);
		fractroundupyn      =   bean.getFractRoundupYN(alt_drug_code);
		//int pack_size		=	1;

		/*if(pack_dtls.containsKey("PACK_SIZE")) {
			if(!((String)pack_dtls.get("PACK_SIZE")).equals("")) {
				pack_size	=	Integer.parseInt(((String)pack_dtls.get("PACK_SIZE")));
			}		
		}*/

         ArrayList  multi_drugs	    = bean.getMultiDrugs(patient_id,order_id,order_line_no);
		 String alt_qty1        	= "";
		 String alt_strength_value1 = "";
		 String alt_drug_code1		="";
		 ArrayList alt_qty			= new ArrayList();
		 HashMap pack_dtls1			= new HashMap();
		 HashMap alternateHmAllowMoreQty=new HashMap(); //newly added for IN035407 ML-BRU-SCF-0474
		 float tmp_alloc			= 0;
		 float pack_size1              = 0; //changed from int to float type for  [IN:036634]
		 float strength_per_value1  =0;
		 
         for(int n=0; n<multi_drugs.size(); n+=5)	{ /* code added for SCF 24184 -start*/
			alt_qty1		          =	 bean.getAlternateDrugQuantity(patient_id,order_id,order_line_no,alt_drug_code); 
			alt_strength_value1     =	(String)multi_drugs.get(n+3);
			alt_drug_code1		  =	(String)multi_drugs.get(n);
			pack_dtls1              =	 bean.getPackSize(alt_drug_code1);
			if(pack_dtls1.containsKey("PACK_SIZE")) {
				if(!((String)pack_dtls1.get("PACK_SIZE")).equals("")) {
					pack_size1	        =	Float.parseFloat(((String)pack_dtls1.get("PACK_SIZE"))); // Integer.parseInt changed to Float.parseFloat for [IN:036634]
					if(!medical_applicable.equals("Y")){//added for ghl-crf-0548
							strength_per_value1	=	Float.parseFloat(((String)pack_dtls1.get("STRENGTH_PER_VALUE_PRES_UOM")));
				
					}}		
			}

			if(bean_1.getAlternateHmAllowMoreQty(alt_drug_code1,locale).equals("Y")){//if else newly added for IN035407 ML-BRU-SCF-0474 -- start
				alternateHmAllowMoreQty.put(alt_drug_code1,"Y");
			}
			else{
				alternateHmAllowMoreQty.put(alt_drug_code1,"N");
			}
			bean_1.setHmAllowMoreQty(alternateHmAllowMoreQty); //if else newly added for IN035407 ML-BRU-SCF-0474 -- end
			if(!alt_qty1.equals("") && !alt_qty1.equals("0")) {
				//alt_qty.add(alt_drug_code1);
				//alt_qty.add(alt_qty1);				
				//alt_qty.add(alt_strength_value1);
				if(!alt_drug_code1.equals(alt_drug_code) && !medical_applicable.equals("Y") )
					tmp_alloc	+=	 ((Float.parseFloat(alt_strength_value1)) * Float.parseFloat(alt_qty1)*pack_size1)/strength_per_value1 ; // Integer.parseInt changed to Float.parseFloat for ML-BRU-SCF-1249 [IN:047253]
			}
		}
		if(Float.parseFloat(prescribed_strength)>0)
			bms_strength = (Float.parseFloat(prescribed_strength) - tmp_alloc)+"";/* code added for SCF 24184 -start -End*/

		if(fractroundupyn.equals("N")){

			HashMap qty_dtls	        = bean.getqtyvalue(alt_drug_code,order_id,order_line_no);		
			if(!medical_applicable.equals("Y")){//added for ghl-crf-0548
			strength_per_value_pres_uom =(String)qty_dtls.get("STRENGTH_PER_VALUE_PRES_UOM");
			}
			
			//tot_strength			    = (String)qty_dtls.get("TOT_STRENGTH");	
			//tot_alt_drug_qty	=	new Float(Math.ceil((Float.parseFloat(tot_strength)/Float.parseFloat(alt_drug_strength))/(Float.parseFloat(strength_per_value_pres_uom)))).intValue();
			if(!medical_applicable.equals("Y")){//added for ghl-crf-0548
			tot_alt_drug_qty	=	new Float(Math.ceil((Float.parseFloat(bms_strength)*(Float.parseFloat(strength_per_value_pres_uom))/Float.parseFloat(alt_drug_strength)))).intValue();
			}
			HashMap pack_dtls	    = bean.getPackSize(alt_drug_code);

			if(pack_dtls.containsKey("PACK_SIZE")) {
				if(!((String)pack_dtls.get("PACK_SIZE")).equals("")) {
					drug_pack_size	=	(String)pack_dtls.get("PACK_SIZE");			
					tot_alt_drug_qty = (int)Math.ceil(tot_alt_drug_qty/Float.parseFloat(drug_pack_size));
				 }		
		    }
			
			if(!bms_strength.equals("") && !alt_drug_strength.equals("") && !bms_strength.equals("0.0")) { //modified for ghl-crf-0548
				//bms_qty	=	new Float(Math.ceil((Float.parseFloat(bms_strength)/Float.parseFloat(alt_drug_strength))/(Float.parseFloat(strength_per_value_pres_uom)))).intValue()+"";
				bms_qty	=	new Float(Math.ceil((Float.parseFloat(bms_strength)*(Float.parseFloat(strength_per_value_pres_uom))/Float.parseFloat(alt_drug_strength)))).intValue()+"";
				qty		=	bms_qty = tot_alt_drug_qty+"";
			} 
			else if(!medical_applicable.equals("Y")) {//ghl-crf-0548
				bms_qty=qty;
				tot_alt_drug_qty =Integer.parseInt(qty);
			}
			//if(bean_1.getDispLocnCatg().equals("O") ){
				 String disp_locn_code	= bean_1.getDispLocnCode();
				// opdispperiod           = bean_1.getopdispperiod( disp_locn_code);
				//opdispperiod  = Integer.parseInt(bean_1.getFillPeriod());
				 strength_value			= (String)qty_dtls.get("STRENGTH_VALUE");
			//}
		}
		else{
			//if(bean_1.getDispLocnCatg().equals("O") ){
			duration					=  0;
			String disp_locn_code		= bean_1.getDispLocnCode();
			duration					=  new Float(Math.ceil(fTotalDuration)).intValue();
			HashMap qty_dtls			= bean.getqtyvalue(alt_drug_code,order_id,order_line_no);
			repeat_value				= (String)qty_dtls.get("repeat_value");
			strength_value				= (String)qty_dtls.get("STRENGTH_VALUE");
			strength_per_value_pres_uom= (String)qty_dtls.get("STRENGTH_PER_VALUE_PRES_UOM");
			qty_value					= (String)qty_dtls.get("QTY_VALUE");
			split_yn					= (String)qty_dtls.get("SPLIT_DOSE_YN");
			// opdispperiod			=  0;
			// tot_strength			= (String)qty_dtls.get("TOT_STRENGTH");	
			// opdispperiod           = bean_1.getopdispperiod( disp_locn_code);	

			if(strength_per_value_pres_uom.equals(""))
				strength_per_value_pres_uom = "0";

			if(alt_drug_strength.equals(""))
				alt_drug_strength = "0";

			//if(tot_strength.equals(""))
			//tot_strength = "0";

			tot_alt_drug_qty	=	new Float(Math.ceil((Float.parseFloat(bms_strength)/Float.parseFloat(alt_drug_strength))/(Float.parseFloat(strength_per_value_pres_uom)))).intValue();

			duration1              = duration;
			if(repeat_value.equals("")||repeat_value==null){
				repeat_value = "1";
			}

			Order_qty	=(String)bean.getOrderqty(order_id,order_line_no);
			if(split_yn.equals("Y")){
				qty_value = (new Float(Math.ceil(Float.parseFloat(qty_value)/Float.parseFloat(repeat_value))).intValue())+"";
			}
			if(!Order_qty.equals(qty)){
				duration			=	duration-opdispperiod;
				//String per_day_qty	=	( new Float((Math.ceil(Float.parseFloat(Order_qty)/duration1 ))).intValue())+"" ;
				float per_day_qty	=	Float.parseFloat(Order_qty)/duration1 ;
				duration			= ( new Float((Math.ceil(Float.parseFloat(qty)/per_day_qty ))).intValue()) ;
			}
			if(duration!=duration1){
				bms_qty				=	((int) (((Math.ceil((Float.parseFloat(bms_strength)/((Float.parseFloat(strength_value)))))*(duration))/duration1))*(Float.parseFloat(main_strength_per_value_pres_uom)))+"";
			}
			else{
				bms_qty				=	((int) ((Math.ceil((Float.parseFloat(bms_strength)/((Float.parseFloat(strength_value)))))*(duration))/duration1))+"";
			}

			qty		=	bms_qty;
			/*}else{
				HashMap qty_dtls			= bean.getqtyvalue(alt_drug_code,order_id,order_line_no);		
				strength_per_value_pres_uom = (String)qty_dtls.get("STRENGTH_PER_VALUE_PRES_UOM");

				if(!bms_strength.equals("") && !alt_drug_strength.equals("")) { 
					bms_qty	=	new Float(Math.ceil((Float.parseFloat(bms_strength)/	Float.parseFloat(alt_drug_strength)))).intValue()+"";
					qty		=	bms_qty;
				}else{
					 bms_qty=qty;
			   }        
			}	*/	 
		}
	} 
//-----code for validating OP_DISP_PERIOD in ph_disp_locn starts---------------
	duration				=   0;
	// opdispperiod			=   0;
	//if(bean_1.getDispLocnCatg().equals("O") ){
	if(!alt_drug_code.equals("")){
		String disp_locn_code	= bean_1.getDispLocnCode();			
		duration                = new Float(Math.ceil(fTotalDuration)).intValue();
		//opdispperiod            = bean_1.getopdispperiod( disp_locn_code);
		HashMap pack_dtls	    = bean.getPackSize(alt_drug_code);
		duration1				= duration;
		if(pack_dtls.containsKey("PACK_SIZE")) {
			if(!((String)pack_dtls.get("PACK_SIZE")).equals("")) {
				drug_pack_size	=	(String)pack_dtls.get("PACK_SIZE");			
			}		
		}
		if(opdispperiod !=0 ){
			Order_qty=(String)bean. getOrderqty(order_id,order_line_no);

			float per_day_qty=Float.parseFloat(Order_qty)/duration1 ;
			if(!Order_qty.equals(qty)){
				duration=duration-opdispperiod;
				duration= new Float(Math.ceil((Float.parseFloat(main_drug_bms_qty))/per_day_qty)).intValue()  ;
			}
			if(duration >opdispperiod){ 
				// quantity=  (new Float (Math.ceil((Float.parseFloat(bms_qty)*opdispperiod)/duration1)).intValue())+""; 
				// quantity=  (new Float (Math.ceil((Float.parseFloat(bms_qty/((Float.parseFloat(Order_qty)/duration1 )))*opdispperiod)/duration1)).intValue())+""; 
				quantity= ((int)Math.ceil(((float)tot_alt_drug_qty/(float)duration1 )*((float)opdispperiod)))+"";
				//quantity=( new Float(Math.ceil((Float.parseFloat(quantity)*(Float.parseFloat(strength_per_value_pres_uom)))/ Float.parseFloat(drug_pack_size))).intValue())+"" ;	
				//quantity=( new Float(Math.ceil((Float.parseFloat(quantity)*(Float.parseFloat(strength_per_value_pres_uom))))).intValue())+"" ;	
				//if(!quantity.equals(""))
			if(!medical_applicable.equals("Y")){//added for ghl-crf-0548
					qty   =   quantity; 	
			}
			
			}
			/*else{
				bms_strength_1=(Float.parseFloat(bms_qty))*(Float.parseFloat(strength_value))+"";
				if(Float.parseFloat(bms_strength_1)>Float.parseFloat(bms_strength)){
					  bms_qty=(Float.parseFloat(bms_strength))/(Float.parseFloat(strength_value))+"";
				}
				quantity=( new Float(Math.ceil(Float.parseFloat(bms_qty)*(Float.parseFloat(strength_per_value_pres_uom))/Float.parseFloat(drug_pack_size))).intValue())+"" ; 
				qty=quantity; 
			}*/
		}
		else{
			bms_strength_1=((Float.parseFloat(bms_qty))*(Float.parseFloat(strength_value)))+"";
			if(Float.parseFloat(bms_strength_1)>Float.parseFloat(bms_strength)){
				bms_qty=(Float.parseFloat(bms_strength))/(Float.parseFloat(strength_value))+"";
			}
			quantity=( new Float(Math.ceil((Float.parseFloat(bms_qty)*(Float.parseFloat(strength_per_value_pres_uom)))/ Float.parseFloat(drug_pack_size))).intValue())+"" ;     
			qty=quantity;   
		}
	}
	else{
		String disp_locn_code	= bean_1.getDispLocnCode();
		duration                = new Float(Math.ceil(fTotalDuration)).intValue();
		//opdispperiod            = bean_1.getopdispperiod( disp_locn_code);
		HashMap pack_dtls	    = bean.getPackSize(drug_code);
		duration1				= duration;

		if(pack_dtls.containsKey("PACK_SIZE")) {
			if(!((String)pack_dtls.get("PACK_SIZE")).equals("")) {
				drug_pack_size	=	(String)pack_dtls.get("PACK_SIZE");			
			}		
		}

		if(opdispperiod !=0 ){
			Order_qty=(String)bean. getOrderqty(order_id,order_line_no);
			float per_day_qty=Float.parseFloat(Order_qty)/duration1 ;
			if(!Order_qty.equals(quantity)){
				//String per_day_qty=( new Float((Math.ceil(Float.parseFloat(Order_qty)/duration1 ))).intValue())+"" ;
				duration= new Float(Math.ceil(Float.parseFloat(qty)/per_day_qty )).intValue();
			}
			if(opdispperiod >duration1){ 
				opdispperiod =duration1;
			}

			/*if(!Order_qty.equals(quantity)){					
			quantity=( new Float((Math.ceil(Float.parseFloat(Order_qty)/duration1 ))*opdispperiod).intValue())+"" ;
			}else{		
			quantity=  (new Float (Math.ceil((Float.parseFloat(quantity)*opdispperiod)/duration)).intValue())+"";		
			}
			quantity=( new Float(Math.ceil(Float.parseFloat(quantity)/ Float.parseFloat(drug_pack_size))).intValue())+"" ;	
			*/

			//	if(bms_qty.equals("")){
			//   quantity= (new Float(Math.ceil(((Float.parseFloat(Order_qty)/(Float.parseFloat(duration1+"")) ))*((float)opdispperiod))).intValue())+"";
			//}else{
			// quantity= (new Float(Math.ceil(((Float.parseFloat(bms_qty)/((float)duration1) ))*((float)opdispperiod))).intValue())+"";

			quantity= new Float(Math.ceil(per_day_qty*(float)opdispperiod)).intValue()+"";
			if(Float.parseFloat(quantity)>Float.parseFloat(bms_qty)) // Integer.parseInt changed to Float.parseFloat for ML-BRU-SCF-1249 [IN:047253]
				quantity =bms_qty ;

			//quantity= (new Float(Math.ceil(((Float.parseFloat(bms_qty)/(Float.parseFloat(duration+"")) ))*((float)opdispperiod))).intValue())+"";
			//}

			//quantity=( new Float(Math.ceil((Float.parseFloat(quantity)*(Float.parseFloat(strength_per_value_pres_uom))))).intValue())+"" ;	
			qty   =   quantity; 

			/*	}else{	
			if(!Order_qty.equals(quantity)){         
			//quantity=( new Float(Math.ceil(Float.parseFloat(quantity)/ Float.parseFloat(drug_pack_size))).intValue())+"" ;
			}            
			}*/
		}
	}
	//}

	if(alt_drug_code.equals("")) {
		stock_items				=	bean.getItems(drug_code);
	}
	else {
		stock_items				=	bean.getItems(alt_drug_code);
		HashMap pack_dtls	    =   bean.getPackSize(alt_drug_code);
		float pack_size			=	1;
		if(pack_dtls.containsKey("PACK_SIZE")) {
			if(!((String)pack_dtls.get("PACK_SIZE")).equals("")) {
				pack_size	=	Float.parseFloat(((String)pack_dtls.get("PACK_SIZE")));	
			}		
		}
		/*
		if(!bms_strength.equals("")) {
			//bms_qty=qty;
		}*/
		// charles bms_qty       =( new Float(Math.ceil((Float.parseFloat(bms_qty))/ pack_size)).intValue())+"" ;     
		/*if(bean_1.getDispLocnCatg().equals("I") ){

		qty       =( new Float(Math.ceil((Float.parseFloat(qty))/ pack_size)).intValue())+"" ;     
		quantity  =	qty;   
		bms_qty   = qty;
		}*/
	}

	long diff_qty	=0;
	if(alt_drug_code.equals("")){
		diff_qty		    =	(Long.parseLong(stk_qty))-(Long.parseLong(qty));
	}

	HashMap params			=	new HashMap();
	ArrayList st_detail	=	new ArrayList();
	String item_cost	= "";
	ArrayList stk_dtls =  new ArrayList();
	if(alt_drug_code.equals("")){
		stk_dtls =(ArrayList)bean.getStockItems(item_code);
	}
	String iv_prep_yn						=  CommonBean.checkForNull((String)bean.getIVFlag(order_id),"N");
	HashMap IssueUOMAndBaseUOM		=(HashMap)bean.getStoreDfltIssueUOMAndBaseUOM(store_code,drug_code);
	if(dflt_issue_uom.equals("")){
		dflt_issue_uom	 =	(String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM");
	}
	base_uom			 = (String)IssueUOMAndBaseUOM.get("BASE_UOM");
	st_allow_decimals_yn	= CommonBean.checkForNull((String)IssueUOMAndBaseUOM.get("ALLOW_DECIMALS_YN")); //  Added for AAKH-SCF-0113 [IN:048937]
	if( (stk_dtls.size()>0 && stk_dtls.get(0).equals("Y"))|| !alt_drug_code.equals("") || !iv_prep_yn.equals("7") || (iv_prep_yn.equals("7")&& allow_short_expiry_drugs_yn.equals("Y")) ){ //!iv_prep_yn.equals("7") -->  added for [IN:045912]
		/*==code added to handle if dispense uom and default uom in item store is different=====*/
		HashMap IssueUomQty=(HashMap)bean.getIssueUomQty();
		/*if(IssueUomQty.containsKey((order_id+order_line_no+drug_code+"_base_to_disp_uom_equl"))){
			base_to_disp_uom_equl	=Double.parseDouble(((String)IssueUomQty.get(order_id+order_line_no+drug_code+"_base_to_disp_uom_equl")));
		}
		if(IssueUomQty.containsKey((order_id+order_line_no+drug_code+"_base_to_def_uom_equl"))){
			base_to_def_uom_equl	=Double.parseDouble(((String)IssueUomQty.get(order_id+order_line_no+drug_code+"_base_to_def_uom_equl")));
		}*/ //Commented for  MMS-SCF-0040 [IN:041888]
		if(base_to_disp_uom_equl ==0)
			base_to_disp_uom_equl    =	bean.getEqulValue ( item_code, base_uom, uom_code);
		if(base_to_def_uom_equl ==0)
			base_to_def_uom_equl	 =  bean.getEqulValue ( item_code, base_uom,dflt_issue_uom);
		if(base_to_disp_uom_equl!=base_to_def_uom_equl){
			conv_factor = bean.lcm( base_to_disp_uom_equl,base_to_def_uom_equl);
			if(conv_factor == 0)
				conv_factor=1;
			issue_qty_val_1  =  new Double(Math.ceil(Float.parseFloat(qty)*base_to_disp_uom_equl)); // Integer.parseInt changed to Float.parseFloat for ML-BRU-SCF-1249 [IN:047253]
			issue_qty_val  = new Double(Math.ceil(((Math.ceil(issue_qty_val_1/conv_factor))*(conv_factor))/base_to_def_uom_equl));
			issue_qty_val_1  =  new Float(Math.ceil(issue_qty_val*base_to_def_uom_equl)).doubleValue(); //Added for  MMS-SCF-0040 [IN:041888]
		}
		else{
			 if(uom_code!=base_uom){  //if block and else condition added for  MMS-SCF-0040 [IN:041888]
				 conv_factor    = bean.lcm( base_to_disp_uom_equl,base_to_def_uom_equl);
				 issue_qty_val  = new Double(Math.ceil(Float.parseFloat(qty)*base_to_disp_uom_equl)); // Integer.parseInt changed to Float.parseFloat for ML-BRU-SCF-1249 [IN:047253]
			 }
			 else{
				issue_qty_val     = Double.parseDouble(qty);	
			 }	
			issue_qty_val_1    = issue_qty_val;	
		}

		if(!alt_drug_code.equals("")){
			HashMap pack_dtls	    = bean.getPackSize(alt_drug_code);
			duration1				= duration;
			if(pack_dtls.containsKey("PACK_SIZE")) {
				if(!((String)pack_dtls.get("PACK_SIZE")).equals("")) {
					drug_pack_size	=	(String)pack_dtls.get("PACK_SIZE");			
				}		
			}
		}
		else{
			HashMap pack_dtls	    = bean.getPackSize(drug_code);
			duration1				= duration;
			if(pack_dtls.containsKey("PACK_SIZE")) {
				if(!((String)pack_dtls.get("PACK_SIZE")).equals("")) {
					drug_pack_size	=	(String)pack_dtls.get("PACK_SIZE");			
				}		
			}	
		}
		//if(!drug_pack_size.equals(""))//COMMENTD FOR 26145 BY NAVEEN ON 3Feb2011
		//issue_qty_val_1 = issue_qty_val_1 * Double.parseDouble(drug_pack_size);

		/*===============ends here==========================================================*/
		String trade_code   =  (String)bean_1.gettrade_codes(order_id,order_line_no,drug_code);

		if( !(trade_code.equals(""))&& all_drug_detail.size()==0){
			params.put("ITEM_CODE",item_code+"="+trade_code); 	
		}
		else{
			params.put("ITEM_CODE",item_code);
		}
		//qty =issue_qty_val+""; //commented for MMS-SCF-0040 [IN:041888]
		qty =issue_qty_val_1+""; //added for MMS-SCF-0040 [IN:041888]
		bms_qty =qty; //added for MMS-SCF-0040 [IN:041888]
		if(!alt_drug_code.equals("") && base_to_disp_uom_equl!=base_to_def_uom_equl && uom_code!=base_uom ){ // Added for ML-BRU-SCF-1880 - Start
			bms_qty =(Math.ceil((float)tot_alt_drug_qty *Float.parseFloat(qty)))+"";
		} // Added for ML-BRU-SCF-1880 - End
		params.put("STORE_CODE",store_code);
		//params.put("TRN_QTY",qty);
		if(bean_1.getOrderType().equals("NOR") && ((bean_1.getBarcode_id()!=null && !bean_1.getBarcode_id().equals("")) || bean_1.getBarcode_Scan_YN().equals("Y"))) // if condition added for [IN:064158] else condition for existing functionality  - Start // getBarcode_Scan_YN() Added for GHL-CRF-0463
		   params.put("TRN_QTY","1"+"");
		else
		   params.put("TRN_QTY",issue_qty_val_1+""); // if condition added for [IN:064158]/[IN:006614] else condition for existing functionality - End
		params.put("INCLUDE_SUSPENDED","FALSE");
		params.put("INCLUDE_EXPIRED","FALSE");
		params.put("CUT_OFF_DATE",end_date);
		params.put("VERIFY_INSUFFICIENT_QTY","FALSE");
		params.put("MIN_EXP_DATE",min_end_date);
		params.put("BARCODE_ID",bean_1.getBarcode_id());
		//System.err.println("bean_1.getBarcode_id()==="+bean_1.getBarcode_id());
		if(bean_1.get2DBarcodeApplicable().equals("Y") && !bean_1.getBarcode_id().equals("")){//Added if condition for MMS-DM-CRF-0174.5
			stock = (HashMap)bean_2.get2DBarcodeDetails(params);
		}else{
			stock	  = (HashMap)bean_2.getBatches(params);
		}
		if(bean_1.getBarcode_id()!=null && !bean_1.getBarcode_id().equals("") && !stock.containsKey("EXCEPTION")){//if & else block added for KDAH-CRF-0231 [IN-034551]
			bean_1.setBarcode_Scan_YN("Y");
			//Commented for KDAH-CRF-0231 [IN-034551]
				/*barcode_flg="Y";
				if(bean_1.getStockDtl().containsKey("barcode_id")){
				    bean_1.setStockDtlKey("EXCEPTION", "EXCEPTION");
				    bean_1.setStockDtlKey("autoalloc","Y");
				}
		}else if(bean_1.getBarcode_id()!=null && !bean_1.getBarcode_id().equals("")){// if stock contains data without exception set list to bean added for KDAH-CRF-0231 [IN-034551]*/
		//Commented for KDAH-CRF-0231 [IN-034551]
		batch_val=(ArrayList)stock.get("BATCH_DATA");
		//Added for KDAH-CRF-0231 [IN-034551]
		bean_1.setStockDtlKey("barcode_applicable"+item_code,"Y");
		//Added for KDAH-CRF-0231 [IN-034551] - Start
		Iterator batch_chk=bean_1.getBatch_val().iterator();
		while(batch_chk.hasNext()){
			batch_chk_list=(ArrayList)batch_chk.next();
			ArrayList batch_temp_val=batch_chk_list;
			HashMap batch_val_map=new HashMap();
			HashMap batch_val_map1=new HashMap();
			Iterator batch_val_iterate=batch_temp_val.iterator();
			if(batch_val_iterate.hasNext()){
				while(batch_val_iterate.hasNext()){
					batch_val_map=(HashMap)batch_val_iterate.next();
					batch_val_map1.put(batch_val_map.get("BATCH_ID").toString()+batch_val_map.get("ITEM_CODE").toString(), batch_val_map.get("BATCH_ID").toString());
				}
			}
			else{
				batch_chk_map=(HashMap)batch_chk_list.get(0);
			}
			st_batch_map=(HashMap)batch_val.get(0);
			if(batch_val_map1.containsKey(st_batch_map.get("BATCH_ID").toString()+st_batch_map.get("ITEM_CODE").toString())){
				temp_count++;
				batch_val_map1.clear();
				break;
			}
			else{
				batch_chk_map=(HashMap)batch_chk_list.get(0);
				String batch_chk_cmp=batch_chk_map.get("BATCH_ID").toString()+batch_chk_map.get("ITEM_CODE").toString();
				if(batch_chk_cmp.equals(st_batch_map.get("BATCH_ID").toString()+st_batch_map.get("ITEM_CODE").toString())){//34551
					temp_count++;
					if(temp_count>1){
						break;
					}
				  }	
			   } 
			}
			if(temp_count<1){
				bean_1.setBatch_val(batch_val);//Assign list of batch data to setter method added for KDAH-CRF-0231 [IN-034551]
			}//Added for KDAH-CRF-0231 [IN-034551] - End
		}
		item_cost	=	bean.getItemCost(item_code,store_code,issue_qty_val+"",end_date);
		if(item_cost.equals("")) 
			item_cost		=	"0";
		else
			item_cost		=	Float.parseFloat(item_cost)+"";

		stock_detail		=	(ArrayList)stock.get("BATCH_DATA");
		if(called_from.equals("stock") && bean_3.getSelectedList()!=null) {
			st_detail.add(bean_3.getSelectedList());
			batch_val.clear();//batch_val list is cleared on stockavailibility button click scenario added for KDAH-CRF-0231 [IN-034551]
			barcode_flg="N";//Added for KDAH-CRF-0231 [IN-034551]	-Start
			bean_1.getBatch_val().clear();
			bean_1.setStockDtlKey("barcode_applicable"+item_code,"Y");	//Added for KDAH-CRF-0231 [IN-034551]	-End
		} 
		else if(all_drug_detail.size()!=0 && bean_1.getBarcode_id()!=null && bean_1.getBarcode_id().equals("")) { //&& bean_1.getBarcode_id()!=null && bean_1.getBarcode_id().equals("") added for KDAH-CRF-0231 [IN-034551] 
			if(allow_short_expiry_drugs_yn.equals("Y"))
				params.put("CUT_OFF_DATE","");
			stock			=	bean_2.getBatches(params,for_stock_2);
			st_detail.add((ArrayList)stock.get("BATCH_DATA"));
		}
		else {
			st_detail.add((ArrayList)stock.get("BATCH_DATA"));
		}
	}
	
	String pres_qty_alert = bean_1.getPresQtyAlert();//code added for AMS-CRF-0035[IN033551]	

            _bw.write(_wl_block8Bytes, _wl_block8);
	
				double tot_qty		=	0;
				tmp_item_code		=	"";
				//double tmp_qty		=	0;
				int rec_no			=	0;
				String fill_period	=	null;
				String fill_unit	=	null;	
				
				for(int i=0; i<st_detail.size(); i++)	{
					batch_id			=	"";
					expiry_date			=	"";
					issue_qty			=	"";
					//qty_uom				=	"";
					trade_id			=	"";
					bin_locn_code		=	"";
					item_drug_code		=	tmp_drug_code;
					item_drug_color		=	tmp_drug_color;
					drug_color			=	item_drug_color;
					//Commented for KDAH-CRF-0231 [IN-034551]
					/*if(bean_1.getBarcode_Scan_YN().equals("N")){//if block added for KDAH-CRF-0231 [IN-034551] 
					    barcode_flg="N";
					}*/
					//Commented for KDAH-CRF-0231 [IN-034551]
					if(st_detail.get(i) != null)
						stock_detail		=	(ArrayList) st_detail.get(i);
						
						Iterator batch_chk1=bean_1.getBatch_val().iterator();//Added for KDAH-CRF-0231 [IN-034551] - Start
						String temp_code="";
						String batch_id_chk="";
						while(batch_chk1.hasNext()){
						    batch_chk_list=(ArrayList)batch_chk1.next();
						    batch_chk_map=(HashMap)batch_chk_list.get(0);
						    st_batch_map=(HashMap)stock_detail.get(0);
						    temp_code=batch_chk_map.get("ITEM_CODE").toString();
						    if(temp_code.equals(tmp_drug_code)){
							   barcode_flg="N";
							   break;
						    }
						}
						//Added for KDAH-CRF-0231 [IN-034551] - End
					if((batch_val.size()!=0 || bean_1.getBatch_val().size()>0 && temp_code.equals(tmp_drug_code)) && (bean_1.getBarcode_Scan_YN().equals("Y") && alt_drug_code.equals(""))){//Added for KDAH-CRF-0231 [IN-034551] // && (barcode_flg.equals("Y") && !alt_drug_code.equals("")) Added for MMS-DM-SCF-0083//&& !bean_1.getOrderType().equals("NOR") removed chandra
					    //bean_1.setBatch_val(stock_detail);//Assign list of batch data to setter method added for KDAH-CRF-0231 [IN-034551]
					    bean_1.setStockDtlKey("barcode_applicable"+item_drug_code,"Y");//Added for KDAH-CRF-0231 [IN-034551]
						//Added for KDAH-CRF-0231 [IN-034551]    
						Set stockDtlset = new HashSet(bean_1.getBatch_val()); // Assign list value to set which removes duplicate value on the list added for KDAH-CRF-0231 [IN-034551]
						Iterator stockDtllist=stockDtlset.iterator(); // iterate the set value from the list added for KDAH-CRF-0231 [IN-034551]
						while(stockDtllist.hasNext()){
							stk_dtls.add("Y");
							bean.setStockItems(drug_code,stk_dtls);
							batch_val=(ArrayList)stockDtllist.next(); // Assign set value to list to get each batch data added for KDAH-CRF-0231 [IN-034551]
							Iterator stockDtllist1=batch_val.iterator(); //Iterate the list to excecute the batch data added for KDAH-CRF-0231 [IN-034551]
							while(stockDtllist1.hasNext()){ 
								drug_detail			=	(HashMap)stockDtllist1.next();// Assign each batch list to map to get key element from the batch added for KDAH-CRF-0231 [IN-034551]
								issue_qty			=	(String)drug_detail.get("AVAIL_QTY");
								if(Double.parseDouble(issue_qty)<1.0)
									continue;
								item_drug_code		=	(String)drug_detail.get("ITEM_CODE");	
								expiry_date			=	(String)drug_detail.get("EXPIRY_DATE");	
								batch_id			=	(String)drug_detail.get("BATCH_ID");	
								trade_id			=	(String)drug_detail.get("TRADE_ID");	
								trade_name			=	(String)drug_detail.get("TRADE_NAME");	
								manufacturer_name	=	(String)drug_detail.get("MANUFACTURER_NAME");	
								bin_locn_code		=	(String)drug_detail.get("BIN_LOCATION_CODE");
								bin_location		=	(String)drug_detail.get("BIN_DESC");
								if(tmp_drug_code.equals(drug_detail.get("ITEM_CODE").toString())){//Added for KDAH-CRF-0231 [IN-034551]
									issue_qty			=	retunFormatedInt(Math.floor(Double.parseDouble(issue_qty))+""); // To make avaiilable qty as whole quantity
									quantity			=	"";
									select_status		=	"";
									tot_qty		+=	Double.parseDouble(issue_qty);
									if(2==0)
										class_name	=	"QRYEVENSMALL"; 
									else
										class_name	=	"QRYODDSMALL";

									// For getting the allocated quantity
									if(alt_drug_code.equals("")){
										 if(strResetQty.equals("") || strResetQty.equals("false")){
											// This condion is added to default the qty same like old batch Id. If the batch id is different also
											// the calculated qty should be same. ref spira id #IN015288
											if(bConsiderOldBatchDetails) {
												quantity	=	bean.getStockQuantity(patient_id,order_id,order_line_no,item_drug_code,sOrigBatchId,sPastExpDate,sPastBinLocn);
											}
											else
												quantity	=	bean.getStockQuantity(patient_id,order_id,order_line_no,item_drug_code,batch_id,expiry_date,bin_locn_code);
										  }
										  else{
											  quantity	= "";
										  }
									}
									else{
										if(strResetQty.equals("") || strResetQty.equals("false")){
											// This condion is added to default the qty same like old batch Id. If the batch id is different also
											// the calculated qty should be same. ref spira id #IN015288
											if(bConsiderOldBatchDetails)
												quantity	=	bean.getAlternateStockQuantity(patient_id,order_id,order_line_no,alt_drug_code,item_drug_code,sOrigBatchId,sPastExpDate,sPastBinLocn);
											else
												quantity	=	bean.getAlternateStockQuantity(patient_id,order_id,order_line_no,alt_drug_code,item_drug_code,batch_id,expiry_date,bin_locn_code);
										}
										else{
											quantity	= "";
										}
									}
									disp_avail_qty = quantity;
									//Added for KDAH-CRF-0231 [IN-034551] - Start
									 ArrayList batch_det=(ArrayList)stock.get("BATCH_DATA");
									 HashMap batch_det_stock=(HashMap)batch_det.get(0);
									
									if(temp_count>=1 && batch_det_stock.get("BATCH_ID").equals(batch_id)){
										if(bean_1.getStockDtl().containsKey("batchqty"+item_drug_code+batch_id)){
										
										  quantity = Integer.parseInt(bean_1.getStockDtl().get("batchqty"+item_drug_code+batch_id).toString())+"";//Added of r INC 49122

										 
										quantity =  new Double(Math.ceil(Float.parseFloat(quantity)/conv_factor))+"";//Added of r INC 49122
										 quantity=Double.parseDouble(quantity)+1+"";
											System.err.println("quantity @@ 899 ==="+quantity);
										}
									}
									else{
										if(!bean_1.getStockDtl().containsKey("batchqty"+item_drug_code+batch_id)){//Added ! for MMS-ICN-0128
											
											//quantity=bean_1.getStockDtl().get("batchqty"+item_drug_code+batch_id).toString();
											//Commented and added below condition by Ganga 
											if(batch_det_stock.get("BATCH_ID").equals(batch_id)){
												quantity=batch_det_stock.get("QTY").toString();
											//Commented for MMS-ICN-0128	
											 /*if(all_drug_detail.size()>0 && bean_1.getBarcode_Scan_YN().equals("Y") && bean_1.getOrderType().equals("NOR")){ // Added for [IN:064158] - Start
												for(int k=0; k<all_drug_detail.size(); k+=10){
												   if(((String)all_drug_detail.get(k+1)).equals(batch_id)){
													   quantity = (String)all_drug_detail.get(k+3);
												       //break;
												   }
												}
											 }*/ // Added for [IN:064158] - End//Commenteing end for MMS_ICN-0128
												
											}
											else{
												quantity=bean_1.getStockDtl().get("batchqty"+item_drug_code+batch_id).toString();
												
										}
									}else{//Adding start for MMS-ICN-0128

										if(bean_1.getStockDtl().containsKey("batchqty"+item_drug_code+batch_id)){
										     quantity=(String)bean_1.getStockDtl().get("batchqty"+item_drug_code+batch_id).toString();
											quantity =  new Double(Math.ceil(Float.parseFloat(quantity)/conv_factor))+"";//Added of r INC 49122
System.err.println("quantity @@ 931 ==="+quantity);
											 if(quantity.equals("0") || quantity.equals("0.0")){//Added for Manual allocation screen QTY not allocation properly
												 if(batch_det_stock.get("BATCH_ID").equals(batch_id)){
												    quantity=batch_det_stock.get("QTY").toString();
													quantity =  new Double(Math.ceil(Float.parseFloat(quantity)/conv_factor))+"";//Added of r INC 49122
													System.err.println("quantity @@ 935 ==="+quantity);
												 }
											 }
										}else{
										   if(batch_det_stock.get("BATCH_ID").equals(batch_id)){
												quantity=batch_det_stock.get("QTY").toString();
												quantity =  new Double(Math.ceil(Float.parseFloat(quantity)/conv_factor))+"";//Added of r INC 49122
												System.err.println("quantity @@ 941 ==="+quantity);
												//quantity= new Float(Math.ceil(((Math.ceil((Float.parseFloat((Double.parseDouble(quantity)*base_to_def_uom_equl)+""))/(conv_factor)))*(conv_factor))/base_to_disp_uom_equl)).intValue()+"";
												
										   }
										}
									 }//Adding end for MMS-ICN-0128
									}										//Added for KDAH-CRF-0231 [IN-034551]- End
									
									String stock_qty="";
									if(item_drug_code.equals(bean_1.getStockDtl().get("drug_code").toString()) && bean_1.getStockDtl().containsKey(item_drug_code)){
										stock_qty=bean_1.getStockDtl().get(item_drug_code).toString();
									}
									else{
										stock_qty=quantity;
									}
									tempstock.put(item_drug_code+"~"+batch_id,order_id+"~"+order_line_no+"~"+stock_qty+"~"+item_cost+"~"+uom_code+"~"+base_uom);//Added for KDAH-CRF-0231 [IN-034551] //base_uom is added for [IN:049778]
									bean_1.setTempStockDtls(tempstock);
									//Added for KDAH-CRF-0231 [IN-034551]

									if(quantity.equals("") ||bConsiderOldBatchDetails==true) {
										if( (Double.parseDouble(qty) < Double.parseDouble(issue_qty))) {
											quantity	=	qty;
											qty		    =	(Double.parseDouble(qty) - (int)Double.parseDouble(issue_qty))+"";
											if(Float.parseFloat(qty)<0){
												qty=0+"";
											}
										//qty_arrived	=	true;
										}
										else  {
											quantity	=	issue_qty;
											qty		    =	(Double.parseDouble(qty) - (int)Double.parseDouble(issue_qty))+"";
											//qty			=	tmp_qty+"";
										}				
									}
				 
									int  alloc_qty      = 0;
									disp_avail_qty = issue_qty; //"0"; //Commented for  MMS-SCF-0040 [IN:041888]//uncommented for MMC-ICN-0128
									if(base_to_disp_uom_equl!=base_to_def_uom_equl  ){
										if(all_drug_detail.size()==0){
											quantity       = ( new Float(Math.ceil(((Float.parseFloat(quantity))/base_to_disp_uom_equl))).intValue())+"";
										}
										//disp_avail_qty = new Float(Math.ceil(((Math.ceil((Float.parseFloat((Double.parseDouble(issue_qty)*base_to_def_uom_equl)+""))/(conv_factor)))*(conv_factor))/base_to_disp_uom_equl)).intValue()+"";  //Commented for  MMS-SCF-0040 [IN:041888]
									}
									else{
										disp_avail_qty = retunFormatedInt(issue_qty);
									}
									quantity =retunFormatedInt(quantity);
									// Check/Uncheck Select checkbox based on quantity value
									if(!quantity.equals(""))
										select_status	=	"checked";

									if(stock_items.size() > 1) {
										if(!item_drug_code.equals(tmp_item_code)) {
											tmp_item_code		=	item_drug_code;

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(tmp_item_code));
            _bw.write(_wl_block11Bytes, _wl_block11);

										}
									}
								//	bean_1.setStockDtlKey("batchqty"+item_drug_code+batch_id,quantity) ; //Added for KDAH-CRF-0231 [IN-034551] brought from down to here for MMS-ICN-0128
									quantity= new Double(Math.ceil(((Math.ceil((Float.parseFloat((Double.parseDouble(quantity)*base_to_def_uom_equl)+""))/(conv_factor)))*(conv_factor))/base_to_disp_uom_equl)).intValue()+"";//Added for MMS-ICN_0128
									quantity =retunFormatedInt(quantity);
									//System.err.println("quantity@@@999=="+quantity);
									bean_1.setStockDtlKey("batchqty"+item_drug_code+batch_id,quantity) ; //Added for KDAH-CRF-0231 [IN-034551] brought from down to here for MMS-ICN-0128
												

            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(item_drug_code));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(item_drug_color));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(expiry_date,"DMY","en",locale)));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(expiry_date));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(batch_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(batch_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(trade_name));
            _bw.write(_wl_block1Bytes, _wl_block1);

										image_path				=  drug_trade_bean.getImagePath(drug_code,trade_id);	
										if ((image_path!=null)&& !(image_path.equals(""))){

            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(trade_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
  
										}

            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(trade_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(manufacturer_name));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(bin_location));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(bin_locn_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(issue_qty));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(disp_avail_qty+""));
            _bw.write(_wl_block37Bytes, _wl_block37);
	
										int tmp_unit_qty =	0;

            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf((int)Math.floor(Double.parseDouble(quantity))));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(bean.getUOMDesc(base_uom)));
            _bw.write(_wl_block45Bytes, _wl_block45);

									//	bean_1.setStockDtlKey("batchqty"+item_drug_code+batch_id,quantity) ; //Added for KDAH-CRF-0231 [IN-034551]//Moved to above for MMS-ICN-0128

            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(base_uom));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(dflt_issue_uom));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(uom_code));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(base_to_disp_uom_equl));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(base_to_def_uom_equl));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(quantity));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(select_status));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block71Bytes, _wl_block71);
	
									bean_1.setStockDtlKey("stockQty", (int)Math.floor(Double.parseDouble(quantity))+"");// stockQty key added for KDAH-CRF-0231 [IN-034551]
									rec_no++;
							 }
						}//Added for KDAH-CRF-0231 [IN-034551]
					}
				  	bean_1.setBarcode_multi_id("N");//Added for KDAH-CRF-0231 [IN-034551]
				}
				else{
				    //Added for KDAH-CRF-0231 [IN-034551] - Start
				    if(barcode_flg==null){
						barcode_flg="";
				    }    //Added for KDAH-CRF-0231 [IN-034551]	-End
					issue_qty = issue_qty_val_1+""; //Added for  MMS-SCF-0040 [IN:041888]
					for(int j=0; j<stock_detail.size(); j++ ) {
					  //if(!bean_1.getOrderType().equals("NOR")) // if condition added for GHL-CRF-0463 and commented for MMS-KH-CRF-0038
					    //bean_1.setBarcode_Scan_YN("N"); 

						stk_dtls.add("Y");
						bean.setStockItems(drug_code,stk_dtls);
						drug_detail			=	(HashMap)stock_detail.get(j);
						issue_qty			=	(String)drug_detail.get("AVAIL_QTY");
						if(Double.parseDouble(issue_qty)<1.0)
							continue;
						item_drug_code		=	(String)drug_detail.get("ITEM_CODE");	
						expiry_date			=	(String)drug_detail.get("EXPIRY_DATE");	
						batch_id			=	(String)drug_detail.get("BATCH_ID");	
						trade_id			=	(String)drug_detail.get("TRADE_ID");	
						trade_name			=	(String)drug_detail.get("TRADE_NAME");	
						manufacturer_name	=	(String)drug_detail.get("MANUFACTURER_NAME");	
						bin_locn_code		=	(String)drug_detail.get("BIN_LOCATION_CODE");
						bin_location		=	(String)drug_detail.get("BIN_DESC");
						issue_qty			=	retunFormatedInt(Math.floor(Double.parseDouble(issue_qty))+""); // To make avaiilable qty as whole quantity
						
					//	System.err.println("barcode_flg@@==="+barcode_flg+"getTempStockDtls=="+bean_1.getTempStockDtls()+"item_drug_code=="+item_drug_code+"bean_1.getStockDtl()==="+bean_1.getStockDtl());
						if(!barcode_flg.equals("") && barcode_flg.equals("N") ||  bean_1.getTempStockDtls().containsKey(item_drug_code) && bean_1.getTempStockDtls().get(item_drug_code).equals(item_drug_code)|| bean_1.getStockDtl().containsKey("barcode_applicable"+item_drug_code) && bean_1.getStockDtl().get("barcode_applicable"+item_drug_code).equals("Y") || bean_1.getStockDtl().containsKey("allocated"+item_drug_code+batch_id) && bean_1.getStockDtl().get("allocated"+item_drug_code+batch_id).equals(item_drug_code) || all_drug_detail.contains(item_drug_code)){ //if block Added for KDAH-CRF-0231 [IN-034551]//all_drug_detail.contains(item_drug_code) Added for MMS-DM-CRF-0174.5
							bean_1.setStockDtlKey("barcode_applicable"+item_drug_code,"N");
							if(!barcode_flg.equals("") && barcode_flg.equals("Y")){
								bean_1.setBatch_val(stock_detail);
							}
						}
						quantity			=	"";
						select_status		=	"";
						tot_qty				+=	Double.parseDouble(issue_qty);
						if(j%2==0)
							class_name	=	"QRYEVENSMALL"; 
						else
							class_name	=	"QRYODDSMALL";

						// For getting the allocated quantity
						if(alt_drug_code.equals("")){
							 if(strResetQty.equals("") || strResetQty.equals("false")){
								// This condion is added to default the qty same like old batch Id. If the batch id is different also
								// the calculated qty should be same. ref spira id #IN015288
								if(bConsiderOldBatchDetails) {
									quantity	=	bean.getStockQuantity(patient_id,order_id,order_line_no,item_drug_code,sOrigBatchId,sPastExpDate,sPastBinLocn);
								}
								else
									quantity	=	bean.getStockQuantity(patient_id,order_id,order_line_no,item_drug_code,batch_id,expiry_date,bin_locn_code);
								/*if(quantity==null || quantity.equals("")) //added for MMS-KH-CRF-0038
									quantity="0";*/ //commented for SKR-SCF-1643,SKR-SCF-1644,SKR-SCF-1645  

							  }
							  else{
								  quantity	= "";
							  }
						}
						else{ // else block added for KDAH-CRF-0231 [IN-034551] -start
							if(strResetQty.equals("") || strResetQty.equals("false")){
								// This condion is added to default the qty same like old batch Id. If the batch id is different also
								// the calculated qty should be same. ref spira id #IN015288
								if(bConsiderOldBatchDetails)
									quantity	=	bean.getAlternateStockQuantity(patient_id,order_id,order_line_no,alt_drug_code,item_drug_code,sOrigBatchId,sPastExpDate,sPastBinLocn);
								else
									quantity	=	bean.getAlternateStockQuantity(patient_id,order_id,order_line_no,alt_drug_code,item_drug_code,batch_id,expiry_date,bin_locn_code);
								if(uom_code!=base_uom && !quantity.equals("") ){  //if block added for  ML-BRU-SCF-1803 - Start
									 conv_factor    = bean.lcm( base_to_disp_uom_equl,base_to_def_uom_equl);
									// quantity       = new Double(Math.ceil(Float.parseFloat(quantity)*base_to_disp_uom_equl))+"";//Commented for ML-BRU-SCF-1443
								 } //if block added for  ML-BRU-SCF-1803 - End
							}
							else{
								quantity	= "";

							}
						}
						//disp_avail_qty = quantity; //Added for  MMS-SCF-0040 [IN:041888]
						if(quantity.equals("") ||bConsiderOldBatchDetails==true) {
							if( (Double.parseDouble(qty) < Double.parseDouble(issue_qty))) {
							  if(bean_1.getBarcode_Scan_YN().equals("Y") && !alt_drug_code.equals("") && bean_1.getOrderType().equals("NOR")) // if else Added for MMS-DM-SCF-0083
								  quantity ="0";
							  else
								quantity	=	qty; 
								qty		    =	(Double.parseDouble(qty) - (int)Double.parseDouble(issue_qty))+"";
								if(Float.parseFloat(qty)<0){
									qty=0+"";
								}
							//qty_arrived	=	true;
							}
							else  {
								quantity	=	issue_qty;
								qty		    =	(Double.parseDouble(qty) - (int)Double.parseDouble(issue_qty))+"";
								//qty			=	tmp_qty+"";
							}				
						}
						int  alloc_qty      = 0;
						disp_avail_qty = issue_qty; //"0"; //Commented for  MMS-SCF-0040 [IN:041888]
						if(base_to_disp_uom_equl!=base_to_def_uom_equl  ){
							if(all_drug_detail.size()==0){
								quantity       = ( new Float(Math.ceil(((Float.parseFloat(quantity))/base_to_disp_uom_equl))).intValue())+"";
								if(uom_code!=base_uom && !quantity.equals("")){  //if block added for  ML-BRU-SCF-1803 - Start
									 conv_factor    = bean.lcm( base_to_disp_uom_equl,base_to_def_uom_equl);
									 quantity       = new Double(Math.ceil(Float.parseFloat(quantity)*base_to_disp_uom_equl))+"";
								 } //if block added for  ML-BRU-SCF-1803 - End
							}
							//disp_avail_qty = new Float(Math.ceil(((Math.ceil((Float.parseFloat((Double.parseDouble(issue_qty)*base_to_def_uom_equl)+""))/(conv_factor)))*(conv_factor))/base_to_disp_uom_equl)).intValue()+"";  //Commented for  MMS-SCF-0040 [IN:041888]
							if(Double.parseDouble(issue_qty)<Double.parseDouble(disp_avail_qty)) //if block added for  MMS-SCF-0040 [IN:041888]
								quantity = "0";
						}
						else{ 
							disp_avail_qty = retunFormatedInt(issue_qty);
							/*if(all_drug_detail.size()==0){
							//quantity       = ( new Float(Math.ceil(((Float.parseFloat(quantity))/base_to_disp_uom_equl))).intValue())+"";
							}*/
						}
						quantity =retunFormatedInt(quantity);

						// Check/Uncheck Select checkbox based on quantity value
						if(!quantity.equals("")) 
							select_status	=	"checked";

						if(stock_items.size() > 1) {
							if(!item_drug_code.equals(tmp_item_code)) { 
								tmp_item_code		=	item_drug_code;

            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(tmp_item_code));
            _bw.write(_wl_block11Bytes, _wl_block11);

							}
						}

            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(item_drug_code));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(item_drug_color));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(expiry_date,"DMY","en",locale)));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(expiry_date));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(batch_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(batch_id));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(trade_name));
            _bw.write(_wl_block1Bytes, _wl_block1);

							image_path				=  drug_trade_bean.getImagePath(drug_code,trade_id);	
							if ((image_path!=null)&& !(image_path.equals(""))){

            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(trade_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
   
							}

            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(trade_id));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(manufacturer_name));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(bin_location));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(bin_locn_code));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(issue_qty));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(disp_avail_qty+""));
            _bw.write(_wl_block37Bytes, _wl_block37);
	
							int tmp_unit_qty =	0;
							bean_1.setStockDtlKey("batchqty"+item_drug_code+batch_id,quantity); // Added for KDAH-CRF-0231 [IN-034551]

            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf((int)Math.floor(Double.parseDouble(quantity))));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(bean.getUOMDesc(base_uom)));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(base_uom));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(dflt_issue_uom));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(uom_code));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(base_to_disp_uom_equl));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(base_to_def_uom_equl));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(quantity));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(select_status));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block96Bytes, _wl_block96);
	
						
						rec_no++;
						bean_1.setBarcode_multi_id("N");
					//}
					} //Added for KDAH-CRF-0231 [IN-034551]
				}
			}

            _bw.write(_wl_block97Bytes, _wl_block97);
 	
				if(disp_info.size() > 0 && (((String)disp_info.get(1)).equals("Y")) ) { 
					String info		=	((String)disp_info.get(0)).substring(31,36) +"&nbsp;&nbsp;"+((String)disp_info.get(0)).substring(52,((String)disp_info.get(0)).length());

            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(info));
            _bw.write(_wl_block100Bytes, _wl_block100);
	
				} 

            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(alt_drug_code));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(bean_1.getSelectedPatientID()));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(sys_date));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(uom));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(bms_qty));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(source));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(recno));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(tot_qty));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(item_cost));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(oper_mode));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(drug_class));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(bean_1.getDispNarcoticYN()));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(bean_1.getDispControlledYN()));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(disp_auth_yn));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(bean_1.getIssueByUOM()));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(alt_drg_no));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(userAuthPINYN));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(pres_qty_alert));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(st_disp_decimal_dtls_yn));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(st_allow_decimals_yn));
            _bw.write(_wl_block127Bytes, _wl_block127);

			HashMap hmAllowMoreQty = bean_1.getHmAllowMoreQty();
			if(hmAllowMoreQty == null)
				hmAllowMoreQty = new HashMap();

            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(hmAllowMoreQty.get(drug_code)));
            _bw.write(_wl_block129Bytes, _wl_block129);

		all_params=all_params+"&source="+bean_1.getStockDtl().get("source").toString();//34551

            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(tot_qty));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(bms_qty));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(all_params));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(barcode_flg));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(bean_1.getStockDtl().get("barcode_id")));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block131Bytes, _wl_block131);

//added for MMS-KH-CRF-0038
		if(bean_1.getBarcode_id()!=null && bean_1.getBarcode_id().equals("")) //if added for MMS-KH-CRF-0038
		{
            _bw.write(_wl_block132Bytes, _wl_block132);
}
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

	// objects nullified after usage
	stock				=	null;
	for_stock_1			=	null;
	for_stock_2			=	null;
	stock_detail		=	null;
	drug_detail			=	null;
	all_drug_detail		=	null;
	stock_items			=	null;
	params				=	null;
	st_detail			=	null;

            _bw.write(_wl_block133Bytes, _wl_block133);

	putObjectInBean(bean_id,bean,request);
	putObjectInBean(bean_id_1,bean_1,request);
	putObjectInBean(bean_id_2,bean_2,request);
	putObjectInBean(bean_id_3,bean_3,request);
}
catch(Exception e){
	e.printStackTrace();
}

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.item.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AlreadyDispensed-Todayat.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
