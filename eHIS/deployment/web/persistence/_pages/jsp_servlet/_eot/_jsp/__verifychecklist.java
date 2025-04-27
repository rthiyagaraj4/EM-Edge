package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.HashMap;
import java.util.ArrayList;
import eOT.*;
import eOT.Common.*;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;

public final class __verifychecklist extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/VerifyCheckList.jsp", 1723027502000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="<html>\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\t\n<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n<!-- <script language=\"JavaScript\" src=\"../../eCommon/js/messages.js\"></script>\n<script language=\"JavaScript\" src=\"../../eOT/js/OTMessages.js\"></script> -->\n<script language=\"JavaScript\" src=\"../../eOT/js/VerifyCheckList.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<style type=\"text/css\">\n.menu1 {text-align:left;position:relative;width:860px;}\n</style>\n</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<body  ONLOAD=\'disable_reset();\' onKeyDown = \'lockKey()\' >\n\t<form name=\"VerifyCheckListForm\" id=\"VerifyCheckListForm\" method=\'POST\' action=\"../../servlet/eOT.VerifyCheckListServlet\">\n\t<table class=\'grid\' cellpadding=\"3\" cellspacing=\"0\" align=\"center\" border=\"1\" width=\"100%\">\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n\t\t\t<tr>\n\t\t\t\t<th class=\'columnHeaderCenter\'  wrap width=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" nowrap>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th> \n\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t<th class=\'columnHeaderCenter\' width=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" nowrap > \n\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</th>\n\t\t\t\t\t<th class=\'columnHeaderCenter\'  width=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" nowrap colspan=\'3\' >";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</th>\n\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t<th class=\'columnHeaderCenter\'  width=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</th>\n\t\t\t</tr>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t<tr>\t\n\t\t\t<input type=\"hidden\" name=\"checklist_code_";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" id=\"checklist_code_";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t\t\t<input type=\"hidden\" name=\"checklist_item_code_";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" id=\"checklist_item_code_";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n\t\t\t<input type=\"hidden\" name=\"checklist_item_srl_no_";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" id=\"checklist_item_srl_no_";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t\t\t<input type=\"hidden\" name=\"description_";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" id=\"description_";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t\t\t<input type=\"hidden\" name=\"accept_remarks_yn_";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" id=\"accept_remarks_yn_";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\t\t\n\t\t\t<input type=\"hidden\" name=\"checklist_type_";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" id=\"checklist_type_";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\n\t\t\t<input type=\"hidden\" name=\"list_id_";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" id=\"list_id_";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\t\t\n\n\t\t\t<input type=\"hidden\" name=\"remarks_";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" id=\"remarks_";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\t\t\t\t\n\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" width=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" style=\"font-weight:normal\" nowrap>\n\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" nowrap></td>\n\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t<input type=\"hidden\" name=\"insert_update_flag_";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" id=\"insert_update_flag_";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\"  value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" nowrap>\n\t\t\t\t\t\t<label style=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\"onClick=\"openCheckListRemarksWindow(\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\',\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\',\'200\')\" onkeypress=\"return CheckForOHSpecChars(event);\">";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</label>\n\t\t\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\"  value=\"X\">\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" nowrap></td>\n\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" style=\"font-weight:normal\" width=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\"  nowrap >\n\t\t\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\t\t\t</td>";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"insert_update_flag_";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="_";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\t\t\t\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" nowrap ><select name=\"list_value_";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\" id=\"list_value_";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" ";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 =" >\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="> \n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t\t\t\t\t\t\t\t\t</option>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t\t<input type=\"hidden\" name=\"insert_update_flag_";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\n\t\t\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t\t\t\t\t\t<td align=\"center\" class=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" nowrap >\n\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"chkbox_value_";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\" id=\"chkbox_value_";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 =" ";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 =" onClick=\"assignCheckboxValue(this);\" value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\"  align=\"center\"></td>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\t\t\t\t\t\t<td align=\"center\" class=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" nowrap >&nbsp;</td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\" nowrap >\n\t\t\t\t\t\t\t\t\t<label style=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\" onClick=\"openCheckListRemarksWindow(\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\',\'200\')\">";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="</label>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\" nowrap ></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\t\t<td class=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\"  nowrap>\n\t\t\t\t";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t\t</td>\t";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t\t\t\t\t<td align=\"center\" class=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\" >&nbsp;</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t\t\t<input type=\"hidden\" name=\"insert_update_flag_";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\">\t\t\t\n\t<td class=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\" nowrap><select name=\"list_value_";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 =" >\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="> \n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n\t\t\t\t\t\t\t\t</option>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n\t\t\t\t\t</select>\n\t\t\t\t</td>";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t\t\t\t\t</select>\n\t\t\t\t</td>\n\t\t";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n<input type=\"hidden\" name=\"insert_update_flag_";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\">\n";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\" nowrap >\n\t\t\t\t\t<input type=\"checkbox\" name=\"chkbox_value_";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\"  align=\"center\"></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\t\t<td align=\"center\" class=\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\"  align=\"center\">\n\t\t\t\t\t\n\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\n\t\t\t\t<input type=\"hidden\" name=\"total_value_";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\" id=\"total_value_";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\" nowrap>\n\t\t\t\t\t<label style=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="</label>\n\t\t\t\t</td>\n\t\t";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\" nowrap></td>\n\t";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\n\n</table>\n\n\t<input type=\'hidden\' name=\'params\' id=\'params\' value=\'";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\' >\n\t<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\' >\n\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\' >\t\n\t<input type=\"hidden\" name=\"checklist_user_id\" id=\"checklist_user_id\" value=\"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\">\n\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\">\n\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\">\n\t<input type=\"hidden\" name=\"current_level\" id=\"current_level\" value=\"";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\">\n\t<input type=\"hidden\" name=\"oper_num\" id=\"oper_num\" value=\"";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\">\n\t<input type=\"hidden\" name=\"order_id\" id=\"order_id\" value=\"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\">\n\t<input type=\"hidden\" name=\"booking_num\" id=\"booking_num\" value=\"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\">\t\n\t<input type=\"hidden\" name=\"checklist_stage\" id=\"checklist_stage\" value=\"";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\"> \n\t<input type=\"hidden\" name=\"no_of_verifications\" id=\"no_of_verifications\" value=\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\">\n\t<input type=\"hidden\" name=\"no_of_verifications_orig\" id=\"no_of_verifications_orig\" value=\"";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\">\n\t<input type=\"hidden\" name=\"apply_flag\" id=\"apply_flag\" value=\"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\">\n\t<input type=\"hidden\" name=\"size\" id=\"size\" value=\"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\">\n\t<input type=\"hidden\" name=\"access\" id=\"access\" value=\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\">\n\t<input type=\"hidden\" name=\"confirm_yn\" id=\"confirm_yn\" value=\"\">\n\t<input type=\"hidden\" name=\"booking_or_oper_flag\" id=\"booking_or_oper_flag\" value=\"";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\"> \n\t<script>\n\tsetTimeout(\"disable_apply_button()\",200);\n</script>\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

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
 request.setCharacterEncoding("UTF-8");
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

	eCommon.Common.CommonMultipleHandler mh = null ;
	try {
		if(session.getAttribute("mh" ) == null  ) {
			mh = new  eCommon.Common.CommonMultipleHandler();
			session.setAttribute( "mh",mh ) ;
		}
        else {
            mh = ( eCommon.Common.CommonMultipleHandler )session.getAttribute("mh" ) ;
        }
    } catch(Exception e) {
		session.removeValue("mh") ;
		mh = new  eCommon.Common.CommonMultipleHandler();
		session.setAttribute( "mh",mh ) ;    
    }

            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	String facility_id	= (String) session.getValue("facility_id");
	String user_id		= request.getParameter("user_id");
	String mode			= (String)CommonRepository.getCommonKeyValue("MODE_INSERT") ;
	String params		= request.getQueryString() ;
	String booking_num	= request.getParameter("booking_num");
	String oper_num		= request.getParameter("oper_num");
	String pre_or_post	= request.getParameter("pre_or_post");
	String order_id		= request.getParameter("order_id");
	String access		= request.getParameter("access");
	String no_of_verifications	= request.getParameter("no_of_verifications");
	if(no_of_verifications==null) no_of_verifications="1";
	if(no_of_verifications.equals("null")) no_of_verifications="1";
	if(no_of_verifications.equals("")) no_of_verifications="1";
	String insert_update_flag	= "";
	
	//Modified By DhanasekarV against IN024357 on date 18/10/2010
	int current_level			= 2;
	String checklist_stage		= request.getParameter("checklist_stage");
	String apply_flag		= request.getParameter("apply_flag");
	if(checklist_stage.equals("C10") || checklist_stage.equals("C50"))
		current_level = 1;
	else if(checklist_stage.equals("C20") || checklist_stage.equals("C60"))
		current_level = 2;
	else if(checklist_stage.equals("C30") || checklist_stage.equals("C70"))
		current_level = 3;
	else if(checklist_stage.equals("C40") || checklist_stage.equals("C80"))
		current_level = 4;
	String checklist_codes_count = request.getParameter("checklist_codes_count");
//	String checklist_codes = request.getParameter("checklist_codes");
	ArrayList checklist_codes_arr = new ArrayList();
	for(int i=1;i<=Integer.parseInt(checklist_codes_count);i++)
		checklist_codes_arr.add(request.getParameter("verify_checklist_code_"+i));
	String checklist_arr0		= CommonBean.checkForNull((String)checklist_codes_arr.get(0));
	String checklist_arr1="";
	int checklist_codes_count_int = Integer.parseInt(checklist_codes_count);//Added against ML-MMOH-SCF-1282_10-07-2019
	if((pre_or_post.equals("I"))||(!(CommonBean.checkForNull(request.getParameter("invoked_from"))).equals(""))&&((request.getParameter("invoked_from")).equals("CHECKINTOOR") && checklist_codes_count_int <= 3)) //Modified against ML-MMOH-SCF-1282_10-07-2019
	{
			System.err.println("63: checklist_codes_count->"+checklist_codes_count);
			checklist_arr1=CommonBean.checkForNull((String)checklist_codes_arr.get(1));
	}
	//Added against ML-MMOH-SCF-1282_10-07-2019 Starts
	else if(checklist_stage.equals("C30"))
	{
		System.err.println("68: checklist_codes_count->"+checklist_codes_count);
		try{
		checklist_arr1=CommonBean.checkForNull((String)checklist_codes_arr.get(Integer.parseInt(checklist_codes_count)-2));
		} catch(Exception ex) {
			System.err.println("Error in Integer Conversion");
			ex.printStackTrace();
		}
	}
	//Added against ML-MMOH-SCF-1282_10-07-2019 Ends
	String bean_id		= "@VerifyCheckListBean";
	String bean_name	= "eOT.VerifyCheckListBean";
	VerifyCheckListBean bean = (VerifyCheckListBean)mh.getBeanObject(bean_id,request,bean_name);
	bean.loadCheckListDetails(checklist_codes_arr);
	HashMap all_checklist_details  = bean.getVerifyCheckListDetails();
	HashMap checklist_details = null;
	
	bean.loadExistingChkListDtls(booking_num,oper_num,order_id,pre_or_post);
	HashMap all_existing_chklist_dtls = bean.getExistingChkListDtls();
	String classValue			= "";
	String list_id				= "";
	String checklist_type		= "";
	String appl_for_intra_oper="";//Maheshwaran K modified for the CHL-CRF-0043 [IN:035927] as on 26/02/2013
	String list_code_temp		= "";
	String list_code_select		= "";
	String disabled				= "";
	String checked				= "";
	ArrayList arr_list_codes	= new ArrayList();
	int item_level				= 0;
	StringBuffer print_spaces	= new StringBuffer();
	
	int remarks_width	= 8;
	int list_width		= 18;
	int desc_width		= 100-(remarks_width+((Integer.parseInt(no_of_verifications)*list_width)));
	//Maheshwaran K modified for the CHL-CRF-0043 [IN:035927] as on 26/02/2013
	//Start	
	
	if((pre_or_post.equals("I"))&&(!no_of_verifications.equals("")))
	{
		list_width = 35;
		desc_width = 40;
		remarks_width=25;
	}
	//End
	else if(no_of_verifications.equals("4"))
	{
		list_width = 14;
		desc_width = 100-(remarks_width+((Integer.parseInt(no_of_verifications)*list_width)));
	}	

	String checklist_value	 = "";
	String checklist_remarks = "";
	String accept_remarks_yn = "";
	String checklist_item_srl_no = "";
	String checklist_item_code ="";
	int row_num = 0;
try{

            _bw.write(_wl_block9Bytes, _wl_block9);
	//for the title headers
			ArrayList roles_arr		 = new ArrayList();
			String role_id_1 = CommonBean.checkForNull(request.getParameter("role_id_1"));
			String role_id_2 = CommonBean.checkForNull(request.getParameter("role_id_2"));
			String role_id_3 = CommonBean.checkForNull(request.getParameter("role_id_3"));
			String role_id_4 = CommonBean.checkForNull(request.getParameter("role_id_4"));

			if(role_id_1!=null && !role_id_1.equals("null"))
				roles_arr.add(role_id_1);
			if(role_id_2!=null && !role_id_2.equals("null"))
				roles_arr.add(role_id_2);
			if(role_id_3!=null && !role_id_3.equals("null"))
				roles_arr.add(role_id_3);
			if(role_id_4!=null && !role_id_4.equals("null"))
				roles_arr.add(role_id_4);		
		
			HashMap roles_desc = new HashMap();
			if(roles_arr.size()>0)
				roles_desc = bean.getRoleDesc(roles_arr);

			int size=roles_desc.size();
		
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(desc_width+"%"));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

					//Maheshwaran K modified for the CHL-CRF-0043 [IN:035927] as on 26/02/2013
					//Start
					if((pre_or_post.equals("I"))&&(!pre_or_post.equals("P"))&&(!pre_or_post.equals("O")))
					{
					
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(list_width+"%"));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(remarks_width+"%"));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

					}
					else
					{
					//End
				
            _bw.write(_wl_block18Bytes, _wl_block18);

					if(size>0){
				
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(list_width+"%"));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((String)roles_desc.get(role_id_1)));
            _bw.write(_wl_block12Bytes, _wl_block12);

					}
					if(size>1){
				
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(list_width+"%"));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((String)roles_desc.get(role_id_2)));
            _bw.write(_wl_block12Bytes, _wl_block12);

					}
					if(size>2){
				
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(list_width+"%"));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((String)roles_desc.get(role_id_3)));
            _bw.write(_wl_block12Bytes, _wl_block12);

					}
					if(size>3){
				
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(list_width+"%"));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((String)roles_desc.get(role_id_4)));
            _bw.write(_wl_block12Bytes, _wl_block12);

					}
				
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(remarks_width+"%"));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
			}//Maheshwaran K modified for the CHL-CRF-0043 [IN:035927] as on 26/02/2013
	StringBuffer sb_remarks = new StringBuffer();
	String previous_remarks = "";
	String style = "";
	String disable_checklist_fields = request.getParameter("disable_checklist_fields");

	String disable_all = "N";
	if(disable_checklist_fields.equals("disabled"))
		disable_all = "disabled";

	for(int i=1;i<=all_checklist_details.size();i++){
		row_num++;
		checklist_details	= (HashMap)all_checklist_details.get(i+"");
		checklist_item_code = (String)checklist_details.get("checklist_item_code");
		


		item_level			= Integer.parseInt((String)checklist_details.get("item_level"));
		list_id				= (String)checklist_details.get("list_id");
		checklist_type		= (String)checklist_details.get("checklist_type");
		//Maheshwaran K modified for the CHL-CRF-0043 [IN:035927] as on 26/02/2013
		//Start
		appl_for_intra_oper		= (String)checklist_details.get("appl_for_intra_oper");
		//End
		item_level = (item_level-1)*5;
		print_spaces.setLength(0);
		for(int s=0;s<item_level;s++)
			print_spaces.append("&nbsp;");//ML-MMOH-SCF-1018

		
		if ( row_num % 2 == 0 )
			classValue = "gridData" ;
		else
			classValue = "gridData" ;

		accept_remarks_yn = (String)checklist_details.get("accept_remarks_yn");
		checklist_item_srl_no = (String)checklist_details.get("checklist_item_srl_no");


// build the checklist_remarks here

		checklist_remarks = "";
		sb_remarks.setLength(0);
		previous_remarks = "";
		if(accept_remarks_yn!=null && accept_remarks_yn.equals("Y")){
			for(int r=1;r<=Integer.parseInt(no_of_verifications);r++){
				if(all_existing_chklist_dtls.size()>0 && (HashMap)all_existing_chklist_dtls.get(checklist_item_code+"#"+r)!=null){		
					



					if(r==current_level){
						checklist_remarks = (String)((HashMap)all_existing_chklist_dtls.get(checklist_item_code+"#"+r)).get("checklist_remarks");
					}else{
						previous_remarks  = (String)((HashMap)all_existing_chklist_dtls.get(checklist_item_code+"#"+r)).get("checklist_remarks");
						if(previous_remarks==null)
							previous_remarks="";
						else if(previous_remarks!=null && previous_remarks.equals("null"))
							previous_remarks="";
							sb_remarks.append(previous_remarks);

				// Modified by DhanasekarV against the incident IN024968   on 09/11/2010
				if(previous_remarks.length()>0) 		sb_remarks.append("\n");

					// Modified by DhanasekarV against the incident IN024357 on 15/10/2010
						//					System.err.println( " eOT remarks "+sb_remarks.toString());
						//					System.err.println( " eOT checklistremarks "+checklist_remarks);
						//					System.err.println( " eOT current_level "+current_level);
					}
				}
			}
			
			if(checklist_remarks!=null){
				if(checklist_remarks.equals("null") || checklist_remarks.equals(""))
					checklist_remarks = "";
			}else{
				checklist_remarks = "";
			}
		// Modified by DhanasekarV against the incident IN024968   on 09/11/2010
			if(sb_remarks.length()>0 || checklist_remarks.length()>0){
				style = "color:navy;cursor:pointer;font-weight:bold";
				previous_remarks = sb_remarks.toString();
			}else{
				style = "color:blue;cursor:pointer";
				previous_remarks = "";
			}

			if(previous_remarks!=null && previous_remarks.equals("null"))
				previous_remarks="";
		}
// end of building the remarks
//System.err.println("checklist_remarks  "+checklist_remarks);
//System.err.println("previous_remarks  "+previous_remarks);
checklist_remarks=java.net.URLEncoder.encode(checklist_remarks,"UTF-8");
previous_remarks=java.net.URLEncoder.encode(previous_remarks,"UTF-8");
//System.err.println("checklist_remarks 219 "+checklist_remarks);
//System.err.println("previous_remarks 219 "+previous_remarks);

            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf((String)checklist_details.get("checklist_code")));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(checklist_item_code));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(checklist_item_srl_no));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf((String)checklist_details.get("description")));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(accept_remarks_yn));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(checklist_type));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf((String)checklist_details.get("list_id")));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(checklist_remarks));
            _bw.write(_wl_block38Bytes, _wl_block38);
	if((checklist_type.equals("E"))&&(!pre_or_post.equals("I"))){
			if((!checklist_arr1.equals(""))&&(checklist_arr1.equals((String)checklist_details.get("checklist_code")))&&(!(CommonBean.checkForNull(request.getParameter("invoked_from"))).equals(""))&&((request.getParameter("invoked_from")).equals("CHECKINTOOR")))
				{}else {
	
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(desc_width+"%"));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf((String)checklist_details.get("description")));
            _bw.write(_wl_block42Bytes, _wl_block42);

				for(int cc=0;cc<Integer.parseInt(no_of_verifications);cc++){ 
			
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block44Bytes, _wl_block44);

				}
				if(accept_remarks_yn.equals("Y")){
					if(all_existing_chklist_dtls.size()>0 && (HashMap)all_existing_chklist_dtls.get(checklist_item_code+"#"+current_level)!=null){
						insert_update_flag="U";
					}else{
						insert_update_flag="I";
					}
					if(previous_remarks==null){
						previous_remarks="";
					}else if(previous_remarks!=null && previous_remarks.equals("null")){
						previous_remarks="";
					}
			
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(insert_update_flag));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(remarks_width+"%"));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(style));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(previous_remarks));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(disable_all));
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);

				}else{
			
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(remarks_width+"%"));
            _bw.write(_wl_block55Bytes, _wl_block55);

				}
				}
		}else{
			//Maheshwaran K modified for the CHL-CRF-0043 [IN:035927] as on 26/02/2013
			//Start
			//This Condition is for IntraOperative Checklist Tab
			if(((appl_for_intra_oper.equals("I"))||(appl_for_intra_oper.equals("B")))&&(pre_or_post.equals("I"))&&(!pre_or_post.equals("P"))&&(!pre_or_post.equals("O")))
					{
					String status_flag1="";
				if(checklist_arr1.equals((String)checklist_details.get("checklist_code")))
					{
					for(int f=1;f<=all_checklist_details.size();f++)
						{
						HashMap checklist_details1	= (HashMap)all_checklist_details.get(f+"");
						
							String item_code=(String)checklist_details1.get("checklist_item_code");
							String chklist_code=(String)checklist_details1.get("checklist_code");
							if(!checklist_arr0.equals(checklist_arr1))
								{
							if(chklist_code.equals(checklist_arr0)&&(item_code.equals(checklist_item_code)))
								{
								status_flag1="Y";
								}
								}
							
						
						}
					}
					if(status_flag1.equals("Y"))
						{}
						else{
					
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(desc_width+"%"));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(print_spaces));
            out.print( String.valueOf((String)checklist_details.get("description")));
            _bw.write(_wl_block59Bytes, _wl_block59);

						if(checklist_type.equals("L")){
							bean.loadListItemValues(list_id);
							for(int k=1;k<=Integer.parseInt(no_of_verifications);k++){
								checklist_value="S";
								if(all_existing_chklist_dtls.size()>0 && (HashMap)all_existing_chklist_dtls.get(checklist_item_code+"#"+k)!=null){
									checklist_value = (String)((HashMap)all_existing_chklist_dtls.get(checklist_item_code+"#"+k)). get("checklist_value");
									checklist_value=checklist_value==null?"":checklist_value;
									checklist_value=checklist_value.equalsIgnoreCase("null")?"S":checklist_value;
									insert_update_flag="U";
								}else{
									checklist_value="S";
									insert_update_flag="I";
								}
								if(k==current_level && disable_all.equals("N"))
									disabled="";
								else
									disabled="disabled";			
								
								if(k==3)
								{
					
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(k));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(k));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(insert_update_flag));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(list_width+"%"));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(k));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(k));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block66Bytes, _wl_block66);

											list_code_temp   = "";
											list_code_select = "";
											arr_list_codes = null;
											arr_list_codes = bean.getListItemValues();
											if(arr_list_codes!=null){
												for(int j=0;j<arr_list_codes.size();j=j+3){
													list_code_temp = (String)arr_list_codes.get(j);
																
														if(((String)arr_list_codes.get(j+1)).equals("Y")){
															list_code_select = "selected";
														}else if (checklist_value.equals(list_code_temp)){
																
														list_code_select = "selected";
														}else
														{
															list_code_select = "";
														}
										
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(list_code_temp));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(list_code_select));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(arr_list_codes.get(j+2)));
            _bw.write(_wl_block69Bytes, _wl_block69);

												}
											}
										
            _bw.write(_wl_block70Bytes, _wl_block70);

								}
								}
							}else if(checklist_type.equals("C")){
								for(int k=1;k<=Integer.parseInt(no_of_verifications);k++){
									checklist_value="N";
									if(all_existing_chklist_dtls.size()>0 && (HashMap)all_existing_chklist_dtls.get(checklist_item_code+"#"+k)!=null){
										insert_update_flag="U";
										checklist_value = (String)((HashMap)all_existing_chklist_dtls.get(checklist_item_code+"#"+k)). get("checklist_value");
									}else{
										checklist_value="N";
										insert_update_flag="I";
										
									}

									if(k==current_level  && disable_all.equals("N"))
										disabled="";
									else
										disabled="disabled";
									if(checklist_value.equals("Y"))
										checked = "checked";
									else
										checked = "";
							
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(k));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(k));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(insert_update_flag));
            _bw.write(_wl_block72Bytes, _wl_block72);
				//Maheshwaran K modified for the CHL-CRF-0043 [IN:035927] as on 26/02/2013
									if(k==3)
									{
									
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(list_width+"%"));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(k));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(k));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(checked));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(checklist_value));
            _bw.write(_wl_block78Bytes, _wl_block78);
}
            _bw.write(_wl_block79Bytes, _wl_block79);

									}	
							
							}
							else
								{
								
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(list_width+"%"));
            _bw.write(_wl_block81Bytes, _wl_block81);

								}
							if(accept_remarks_yn.equals("Y")){
								/*if(previous_remarks==null)
									previous_remarks="";
								else if(previous_remarks!=null && previous_remarks.equals("null"))
									previous_remarks="";*/
							previous_remarks = (previous_remarks=="null" || previous_remarks==null)?"":previous_remarks;
						
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(remarks_width+"%"));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(style));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(previous_remarks));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(disable_all));
            _bw.write(_wl_block85Bytes, _wl_block85);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block86Bytes, _wl_block86);

							}else{
						
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(remarks_width+"%"));
            _bw.write(_wl_block87Bytes, _wl_block87);

							}
					}
					}
					
			//Mahesh new
			//This IF  CONDITION is for CHECK INTO OR Functions
//else if((pre_or_post.equals("P"))&&(!pre_or_post.equals("I"))&&(!pre_or_post.equals("O"))&&(apply_flag!=null)&&(apply_flag.equals("Y"))&&((!appl_for_intra_oper.equals("N"))&&(!checklist_arr1.equals((String)checklist_details.get("checklist_code"))))&&(!(CommonBean.checkForNull(request.getParameter("invoked_from"))).equals(""))&&((request.getParameter("invoked_from")).equals("CHECKINTOOR")))

else if((pre_or_post.equals("P"))&&(!(CommonBean.checkForNull(request.getParameter("invoked_from"))).equals(""))&&((request.getParameter("invoked_from")).equals("CHECKINTOOR")))
				{
				String status_flag="";
				if(checklist_arr1.equals((String)checklist_details.get("checklist_code")))
					{
					for(int f=1;f<=all_checklist_details.size();f++)
						{
						HashMap checklist_details1	= (HashMap)all_checklist_details.get(f+"");
						
							String item_code=(String)checklist_details1.get("checklist_item_code");
							String chklist_code=(String)checklist_details1.get("checklist_code");
							if(!checklist_arr0.equals(checklist_arr1))
								{
								if(chklist_code.equals(checklist_arr0)&&(item_code.equals(checklist_item_code)))
									{
									status_flag="Y";
									}
								}
						
						}
					}
				if((status_flag.equals("Y"))||((checklist_arr1.equals((String)checklist_details.get("checklist_code")))&&(appl_for_intra_oper.equals("N"))))
					{}
				else{	
				//End
		
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(desc_width+"%"));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(print_spaces));
            out.print( String.valueOf((String)checklist_details.get("description")));
            _bw.write(_wl_block90Bytes, _wl_block90);

		if(checklist_type.equals("L")){
			bean.loadListItemValues(list_id);
			for(int k=1;k<=Integer.parseInt(no_of_verifications);k++){
				checklist_value="S";
				if(all_existing_chklist_dtls.size()>0 && (HashMap)all_existing_chklist_dtls.get(checklist_item_code+"#"+k)!=null){
					checklist_value = (String)((HashMap)all_existing_chklist_dtls.get(checklist_item_code+"#"+k)). get("checklist_value");
					checklist_value=checklist_value==null?"":checklist_value;
					checklist_value=checklist_value.equalsIgnoreCase("null")?"S":checklist_value;
					insert_update_flag="U";
				}else{
					checklist_value="S";
					insert_update_flag="I";
				}
				if(k==current_level && disable_all.equals("N"))
					disabled="";
				else
					disabled="disabled";
				//Maheshwaran K modified for the CHL-CRF-0043 [IN:035927] as on 26/02/2013
				//Start
				if(appl_for_intra_oper.equals("I"))
					{
					if((k==1||k==2)){
					
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block92Bytes, _wl_block92);
}
					else{//End
					
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(k));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(k));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(insert_update_flag));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(list_width+"%"));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(k));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(k));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block96Bytes, _wl_block96);

							list_code_temp   = "";
							list_code_select = "";
							arr_list_codes = null;
							arr_list_codes = bean.getListItemValues();
							if(arr_list_codes!=null){
								for(int j=0;j<arr_list_codes.size();j=j+3){
									list_code_temp = (String)arr_list_codes.get(j);
												
										if(((String)arr_list_codes.get(j+1)).equals("Y")){
											list_code_select = "selected";
										}else if (checklist_value.equals(list_code_temp)){
												
										list_code_select = "selected";
										}else
										{
											list_code_select = "";
										}
						
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(list_code_temp));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(list_code_select));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(arr_list_codes.get(j+2)));
            _bw.write(_wl_block99Bytes, _wl_block99);

								}
							}
						
            _bw.write(_wl_block100Bytes, _wl_block100);

						}
					}
				else{	
	
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(k));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(k));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(insert_update_flag));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(list_width+"%"));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(k));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(k));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block96Bytes, _wl_block96);

							list_code_temp   = "";
							list_code_select = "";
							arr_list_codes = null;
							arr_list_codes = bean.getListItemValues();
							if(arr_list_codes!=null){
								for(int j=0;j<arr_list_codes.size();j=j+3){
									list_code_temp = (String)arr_list_codes.get(j);
												
										if(((String)arr_list_codes.get(j+1)).equals("Y")){
											list_code_select = "selected";
										}else if (checklist_value.equals(list_code_temp)){
												
										list_code_select = "selected";
										}else
										{
											list_code_select = "";
										}
						
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(list_code_temp));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(list_code_select));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(arr_list_codes.get(j+2)));
            _bw.write(_wl_block99Bytes, _wl_block99);

								}
							}
						
            _bw.write(_wl_block101Bytes, _wl_block101);

				}
				}
			}else if(checklist_type.equals("C")){
				for(int k=1;k<=Integer.parseInt(no_of_verifications);k++){
					checklist_value="N";
					if(all_existing_chklist_dtls.size()>0 && (HashMap)all_existing_chklist_dtls.get(checklist_item_code+"#"+k)!=null){
						insert_update_flag="U";
						checklist_value = (String)((HashMap)all_existing_chklist_dtls.get(checklist_item_code+"#"+k)). get("checklist_value");
					}else{
						checklist_value="N";
						insert_update_flag="I";
					}

					if(k==current_level  && disable_all.equals("N"))
						disabled="";
					else
						disabled="disabled";
					if(checklist_value.equals("Y"))
						checked = "checked";
					else
						checked = "";
			
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(k));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(k));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(insert_update_flag));
            _bw.write(_wl_block103Bytes, _wl_block103);
				//Maheshwaran K modified for the CHL-CRF-0043 [IN:035927] as on 26/02/2013
				if(appl_for_intra_oper.equals("I"))
					{
					if((k==1||k==2)){
					
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block92Bytes, _wl_block92);
}
					else{
					
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(list_width+"%"));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(k));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(k));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(checked));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(checklist_value));
            _bw.write(_wl_block105Bytes, _wl_block105);
}
            _bw.write(_wl_block106Bytes, _wl_block106);

					}	
				else{	//End
		
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(list_width+"%"));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(k));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(k));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(checked));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(checklist_value));
            _bw.write(_wl_block108Bytes, _wl_block108);

				}
				
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(k));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(k));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf((String)checklist_details.get("checklist_code")+"|"+checklist_item_code+"|"+checklist_item_srl_no+"|"+checklist_type+"|"+(String)checklist_details.get("list_id")+"|"+checklist_remarks));
            _bw.write(_wl_block72Bytes, _wl_block72);

				}
			}
			if(accept_remarks_yn.equals("Y")){
				/*if(previous_remarks==null)
					previous_remarks="";
				else if(previous_remarks!=null && previous_remarks.equals("null"))
					previous_remarks="";*/
			previous_remarks = (previous_remarks=="null" || previous_remarks==null)?"":previous_remarks;
		
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(remarks_width+"%"));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(style));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(previous_remarks));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(disable_all));
            _bw.write(_wl_block85Bytes, _wl_block85);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block112Bytes, _wl_block112);

			}else{
		
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(remarks_width+"%"));
            _bw.write(_wl_block113Bytes, _wl_block113);

			}
				}
				}
			else if(((pre_or_post.equals("P"))&&(!appl_for_intra_oper.equals("I")))||((pre_or_post.equals("O"))&&(!appl_for_intra_oper.equals("I"))))
				{
				String status_flag2="";
				if(checklist_arr1.equals((String)checklist_details.get("checklist_code")))
					{
					for(int f=1;f<=all_checklist_details.size();f++)
						{
						HashMap checklist_details1	= (HashMap)all_checklist_details.get(f+"");
						
							String item_code=(String)checklist_details1.get("checklist_item_code");
							String chklist_code=(String)checklist_details1.get("checklist_code");
							if(chklist_code.equals(checklist_arr0)&&(item_code.equals(checklist_item_code)))
								{
								status_flag2="Y";
								}
							
						
						}
					}
				if(status_flag2.equals("Y"))	{}
				else
					{				
				//End
		
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(desc_width+"%"));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(print_spaces));
            out.print( String.valueOf((String)checklist_details.get("description")));
            _bw.write(_wl_block90Bytes, _wl_block90);

		if(checklist_type.equals("L")){
			bean.loadListItemValues(list_id);
			for(int k=1;k<=Integer.parseInt(no_of_verifications);k++){
				checklist_value="S";
				if(all_existing_chklist_dtls.size()>0 && (HashMap)all_existing_chklist_dtls.get(checklist_item_code+"#"+k)!=null){
					checklist_value = (String)((HashMap)all_existing_chklist_dtls.get(checklist_item_code+"#"+k)). get("checklist_value");
					checklist_value=checklist_value==null?"":checklist_value;
					checklist_value=checklist_value.equalsIgnoreCase("null")?"S":checklist_value;
					insert_update_flag="U";
				}else{
					checklist_value="S";
					insert_update_flag="I";
				}
				if(k==current_level && disable_all.equals("N"))
					disabled="";
				else
					disabled="disabled";			
				//Maheshwaran K modified for the CHL-CRF-0043 [IN:035927] as on 26/02/2013
				//Start
				if(appl_for_intra_oper.equals("I"))
					{
					if((k==1||k==2)){
					
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block92Bytes, _wl_block92);
}
					else{//End
					
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(k));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(k));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(insert_update_flag));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(list_width+"%"));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(k));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(k));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block96Bytes, _wl_block96);

							list_code_temp   = "";
							list_code_select = "";
							arr_list_codes = null;
							arr_list_codes = bean.getListItemValues();
							if(arr_list_codes!=null){
								for(int j=0;j<arr_list_codes.size();j=j+3){
									list_code_temp = (String)arr_list_codes.get(j);
												
										if(((String)arr_list_codes.get(j+1)).equals("Y")){
											list_code_select = "selected";
										}else if (checklist_value.equals(list_code_temp)){
												
										list_code_select = "selected";
										}else
										{
											list_code_select = "";
										}
						
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(list_code_temp));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(list_code_select));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(arr_list_codes.get(j+2)));
            _bw.write(_wl_block99Bytes, _wl_block99);

								}
							}
						
            _bw.write(_wl_block100Bytes, _wl_block100);

						}
					}
				else{	
	
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(k));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(k));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(insert_update_flag));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(list_width+"%"));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(k));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(k));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block96Bytes, _wl_block96);

							list_code_temp   = "";
							list_code_select = "";
							arr_list_codes = null;
							arr_list_codes = bean.getListItemValues();
							if(arr_list_codes!=null){
								for(int j=0;j<arr_list_codes.size();j=j+3){
									list_code_temp = (String)arr_list_codes.get(j);
												
										if(((String)arr_list_codes.get(j+1)).equals("Y")){
											list_code_select = "selected";
										}else if (checklist_value.equals(list_code_temp)){
												
										list_code_select = "selected";
										}else
										{
											list_code_select = "";
										}
						
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(list_code_temp));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(list_code_select));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(arr_list_codes.get(j+2)));
            _bw.write(_wl_block99Bytes, _wl_block99);

								}
							}
						
            _bw.write(_wl_block101Bytes, _wl_block101);

				}
				}
			}else if(checklist_type.equals("C")){
				for(int k=1;k<=Integer.parseInt(no_of_verifications);k++){
					checklist_value="N";
					if(all_existing_chklist_dtls.size()>0 && (HashMap)all_existing_chklist_dtls.get(checklist_item_code+"#"+k)!=null){
						insert_update_flag="U";
						checklist_value = (String)((HashMap)all_existing_chklist_dtls.get(checklist_item_code+"#"+k)). get("checklist_value");
						}else{
						checklist_value="N";
						insert_update_flag="I";
					}
					if(k==current_level  && disable_all.equals("N"))
						disabled="";
					else
						disabled="disabled";
					if(checklist_value.equals("Y"))
						checked = "checked";
					else
						checked = "";
			
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(k));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(k));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(insert_update_flag));
            _bw.write(_wl_block103Bytes, _wl_block103);
				//Maheshwaran K modified for the CHL-CRF-0043 [IN:035927] as on 26/02/2013
				if(appl_for_intra_oper.equals("I"))
					{
					if((k==1||k==2)){
					
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block92Bytes, _wl_block92);
}
					else{
					
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(list_width+"%"));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(k));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(k));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(checked));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(checklist_value));
            _bw.write(_wl_block105Bytes, _wl_block105);
}
            _bw.write(_wl_block106Bytes, _wl_block106);

					}	
				else{	//End
		
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(list_width+"%"));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(k));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(k));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(checked));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(checklist_value));
            _bw.write(_wl_block108Bytes, _wl_block108);

				}
				
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(k));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(k));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf((String)checklist_details.get("checklist_code")+"|"+checklist_item_code+"|"+checklist_item_srl_no+"|"+checklist_type+"|"+(String)checklist_details.get("list_id")+"|"+checklist_remarks));
            _bw.write(_wl_block72Bytes, _wl_block72);

				}
			}
			if(accept_remarks_yn.equals("Y")){
				/*if(previous_remarks==null)
					previous_remarks="";
				else if(previous_remarks!=null && previous_remarks.equals("null"))
					previous_remarks="";*/
			previous_remarks = (previous_remarks=="null" || previous_remarks==null)?"":previous_remarks;
		
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(remarks_width+"%"));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(style));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(previous_remarks));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(disable_all));
            _bw.write(_wl_block85Bytes, _wl_block85);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block112Bytes, _wl_block112);

			}else{
		
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(remarks_width+"%"));
            _bw.write(_wl_block113Bytes, _wl_block113);

			}
				}
				}
		}
		}
	
	  sb_remarks.setLength(0);
	  print_spaces.setLength(0);

            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(params));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(current_level));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(oper_num));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(booking_num));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(checklist_stage));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(no_of_verifications));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(apply_flag));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(access));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(request.getParameter("booking_or_oper_flag")));
            _bw.write(_wl_block131Bytes, _wl_block131);

	}catch(Exception e)
	{
		e.printStackTrace(System.err);
		System.err.println("caught exception e="+e);
	}finally{


			

//		bean.clear();
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ChecklistItem.Label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.SurgeonRep.Label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
}
