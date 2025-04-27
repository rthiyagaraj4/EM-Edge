package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import ePH.*;
import eOR.*;
import ePH.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __prescriptiondisccancelorderdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/PrescriptionDiscCancelOrderDetails.jsp", 1709121209490L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<style>\n\t\t\tTD.COMPUNDRX{\n\t\t\t\tBACKGROUND-COLOR:#E4CAFF;\n\t\t\t\tFONT-SIZE: 8pt ;\n\t\t\t\theight:10;\n\t\t\t\tBORDER-STYLE: solid;\n\t\t\t}\n\t\t</style>\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'type=\'text/css\'></link>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/common.js\"></SCRIPT>\n\t\t<script language=\"JavaScript\" src=\"../js/PrescriptionTest.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\t<title></title>\n\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<form name=\"DiscCancelOrderDetailsForm\" id=\"DiscCancelOrderDetailsForm\" >\n\t\t\t<table id=\"dupDrugs\" name=\"test\" id=\"test\" cellpadding=0 cellspacing=0 width=\"100%\" align=\"center\" border=\"1\">\n\t\t\t\t<tr >\n\t\t\t\t\t<th colspan=\'12\' align=\"left\" class=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" style=\'color:blue\'nowrap><B>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</B></th>\n\t\t\t\t</tr>\n\t\t\t\t<tr><td colspan=\'12\' >&nbsp;</td></tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<th align=\"center\" class=\"small\" width=\"9%\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\n\t\t\t\t\t<th align=\"center\" class=\"small\" width=\"9%\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n\t\t\t\t\t<th align=\"center\" class=\"small\" width=\"32%\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n\t\t\t\t\t<th align=\"center\" class=\"small\" width=\"8%\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n\t\t\t\t\t<th align=\"center\" class=\"small\" width=\"12%\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</th>\n\t\t\t\t\t<th align=\"center\" class=\"small\" width=\"10%\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</th>\n\t\t\t\t\t<th align=\"center\" class=\"small\" width=\"8%\"><input type=\"checkbox\" name=\'selectAll\' id=\'selectAll\' value=\"\" onClick=\"selectAllRec(this);\" ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</th>\n\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t\t\t<tr><td colspan=\'12\' >&nbsp;</td></tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td  colspan=\'11\' class=\'label\'  ><b>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =":&nbsp;&nbsp;";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&nbsp;&nbsp;-&nbsp;&nbsp;";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="<b></td>\n\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'genericId_";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' id=\'genericId_";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n\t\t\t\t\t\t\t\t\t<td align=\"left\" nowrap ><input type=\"checkbox\" name=\'select_Gen_";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' id=\'select_Gen_";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' value=\"\" onClick=\"selectGeneric(this, \'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\')\" ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =">\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</th>\n\t\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<th align=\"left\" class=\"small\" nowrap>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="&nbsp;</th>\n\t\t\t\t\t\t\t\t<th align=\"left\" class=\"small\" nowrap>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="&nbsp;</th>\n\t\t\t\t\t\t\t\t<th align=\"left\" class=\"small\" colspan=\'10\'>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</th>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<tr></tr>\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t<tr >\n\t\t\t\t\t\t\t<td align=\"left\" class=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" nowrap>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="&nbsp;</td>\n\t\t\t\t\t\t\t<td align=\"left\" class=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" ><label style=\"color:";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="&nbsp;</label></td>\n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t\t\t\t<td align=\"left\" class=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="&nbsp;";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="&nbsp;</td>\n\t\t\t\t\t\t\t\t<td align=\"left\" class=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" ><img style=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =" src=\"../../ePH/images/DrugRemarks.gif\" height=\'20\' width=\'20\' ></img>&nbsp;</td>\n\t\t\t\t\t\t\t\t<td align=\"left\" class=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" >";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="&nbsp;</td>\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</td>\n\t\t\t\t\t\t\t\t<td align=\"left\" class=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" ><label onClick=\"callFreqDet(\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\',\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\')\" style=\"cursor:pointer;color:blue\">";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</label></td>\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\t\t\t<td align=\"left\" class=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</td>\n\t\t\t\t\t\t\t<td align=\"left\" class=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</td>\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" style=\"cursor:pointer;color:blue\"><label onClick=\"callDiagText(\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\')\">Details</label></td>\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">&nbsp;</td>\n";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t\t\t\t\t<td  align=\"left\" class=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\" nowrap>&nbsp;<input type=\"checkbox\" name=\'select_";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="_";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\' id=\'select_";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' value=\"\" ";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 =" onclick=\'checkSelectAll(this,\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\",\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\");\'>";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</td>\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"performType_";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" id=\"performType_";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" value=\"D\">\n";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\' ";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 =" onclick=\'checkSelectAll(this, \"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\" value=\"C\">\n";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t\t\t\t\t\t<td name=\"info\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"order_id_";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\" id=\"order_id_";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\" value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"pract_id_";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\" id=\"pract_id_";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"drug_code_";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" id=\"drug_code_";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"order_line_no_";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\" id=\"order_line_no_";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"pres_drug_code";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\" id=\"pres_drug_code";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"pres_generic_id";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\" id=\"pres_generic_id";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\"> <!--added for 54058-->\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t\t\t<input type=\"hidden\" name=\"genericRecCount_";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\" id=\"genericRecCount_";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\"> <!-- //added for HSA-CRF-0151 [IN:048468] -->\n";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t\t\t</table>\n\t\t\t<table cellpadding=0 cellspacing=0 width=\"100%\" align=\"center\" border=\"0\">\n\t\t\t\t<tr><td colspan=\'3\'>&nbsp;</td></tr>\n\t\t\t\t<tr><td colspan=\'3\'>&nbsp;</td></tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td colspan=\"2\" width=\'80%\'>&nbsp;</td>\n\t\t\t\t\t<td width=\'20%\'>\n\t\t\t\t\t\t<input type=\"button\" name=\"cancel\" id=\"cancel\" value=\'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\'  class=\"button\" onClick=\"discCancValue(\'";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\')\">\n\t\t\t\t\t</td>\t\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\">\n\t\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\">\n\t\t\t<input type=\"hidden\" name=\"pract_id\" id=\"pract_id\" value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\">\n\t\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\">\n\t\t\t<input type=\"hidden\" name=\"patient_class\" id=\"patient_class\" value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\">\n\t\t\t<input type=\"hidden\" name=\"order_date\" id=\"order_date\" value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\">\n\t\t\t<input type=\"hidden\" name=\"take_home\" id=\"take_home\" value=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\">\n\t\t\t<input type=\"hidden\" name=\"generic_id\" id=\"generic_id\" value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\">\n\t\t\t<input type=\"hidden\" name=\"tot_rec_count\" id=\"tot_rec_count\" value=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\">\n\t\t\t<input type=\"hidden\" name=\"genericIdsCount\" id=\"genericIdsCount\" value=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\"> <!--//added for HSA-CRF-0151 [IN:048468]-->\n\t\t\t<input type=\"hidden\" name=\"clearDupYN\" id=\"clearDupYN\" value=\"N\">\n\t\t\n\t\t</form>\n";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );
	
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
            _bw.write(_wl_block5Bytes, _wl_block5);
 
		request.setCharacterEncoding("UTF-8"); 
	//Added by Himanshu for MMS-ME-SCF-0097 Starts 
	request= new XSSRequestWrapper(request); 
	response.addHeader("X-XSS-Protection", "1; mode=block"); 
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//Added by Himanshu for MMS-ME-SCF-0097 ends

		String locale = (String) session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	try{
		String patient_id			=	request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String encounter_id			=	request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
		String generic_id			=	request.getParameter("generic_id")==null?"":request.getParameter("generic_id");
		String called_frm			=	request.getParameter("called_frm")==null?"":request.getParameter("called_frm");
		String patient_class		=	request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
		String order_date			=	request.getParameter("order_date")==null?"":request.getParameter("order_date");
		String from_date			=	request.getParameter("start_date")==null?"":request.getParameter("start_date");//Added for BRU-HIMS-CRF-403 
		String to_date				=	request.getParameter("end_date")==null?"":request.getParameter("end_date");//Added for BRU-HIMS-CRF-403 
		String call_from			=	request.getParameter("call_from")==null?"":request.getParameter("call_from");//Added for BRU-HIMS-CRF-403 
		String take_home_medication =   request.getParameter("take_home_medication")==null?"":request.getParameter("take_home_medication");//added take_home_medication for ML-BRU-SCF-1587 [IN:054876]
		String	start_date			=	"";
		String	end_date			=	"";
		String	drug_desc			=	"";
		String	practitioner_name	=	"";
		String	facility_name		=	"";
		String	location			=	"";
		String diag_text			=	"";
		String split_dose_prev		=	"";
		String order_id				=	"";
		String order_line_no		=	"";
		String freq_code			=	"";
		String freq_desc			=	"";
		String duplicate_reason		=	"";
		String allergy_reason		=	"";
		String dosage_reason		=	"";	
		String link					=	"";
		String discont_date_time	=	"";
		String perf_locn			=	"";
		String iv_prep_yn			=   "";
		String discharge_ind		=	"";
		String in_formulary_yn		=	"";
		String dosage				=	"";
		String dosage_uom			=	"";
		int order_status_type		=   0;
		String	drug_code			=   "";
		String	sliding_scale			=   "";  //added for Bru-HIMS-CRF-265 [IN:032315] 
		String	drug_view			=   "";
		String img_style="";   //added for Bru-HIMS-CRF-265 [IN:032315] 
		if(generic_id==null || generic_id.equals(""))	
			generic_id					=	"";
		else
			called_frm					=	"DUP";

		String	bean_id				= "@PrescriptionBean_1"+patient_id+encounter_id;
		String bean_name			= "ePH.PrescriptionBean_1";
		String class_name			=	"";
		ArrayList active_orders		=	new ArrayList();		
		HashMap record				=	new HashMap();
		HashMap<String, ArrayList> hmGericIdBasedRecords = null;
		String pres_drug_code ="";

		PrescriptionBean_1 bean = (PrescriptionBean_1)getBeanObject(bean_id,bean_name,request) ;
		ArrayList	presDetails 	= (ArrayList) bean.getpresDetails(); //added for HSA-CRF-0151 [IN:048468] -start
		String current_rx ="", currentrx_override="", tmp_generic_id="";
		StringBuilder sbGenericIds = new StringBuilder();
		HashMap drugDetails = null;
		int genericIdCount = 0, tot_rec_count=0, genericRecCount=0, genricIndex=0;
		for(int i=0;i<presDetails.size();i++){
			drugDetails=(HashMap) presDetails.get(i);
			current_rx			= drugDetails.get("CURRENT_RX")==null?"":(String)drugDetails.get("CURRENT_RX");	
			currentrx_override	= drugDetails.get("CURRENTRX_OVERRIDE")==null?"":(String)drugDetails.get("CURRENTRX_OVERRIDE");
			tmp_generic_id	= drugDetails.get("GENERIC_ID")==null?"":(String)drugDetails.get("GENERIC_ID");
			if(current_rx.equals("Y") || (!currentrx_override.equals("Y") || (call_from.equals("buttons") && generic_id.equals(tmp_generic_id)) || (take_home_medication.equals("Y")&&currentrx_override.equals("Y")))){//added take_home_medication condition for ML-BRU-SCF-1587 [IN:054876] // current_rx.equals("Y") && changed to current_rx.equals("Y") || for ML-MMOH-SCF-0317.1
				if(genericIdCount==0)
					sbGenericIds.append("'"+tmp_generic_id+"'");
				else
					sbGenericIds.append(", '"+tmp_generic_id+"'");
				genericIdCount++;
			}
		}
		String defSelect = bean.getCancelDiscConDupOrdersDefSelect();
		if(defSelect.equals("Y"))
			defSelect = "checked";
		else
			defSelect = ""; //added for HSA-CRF-0151 [IN:048468] -end
		int take_home	=	bean.getHomeMecdicationYn(encounter_id,(String)session.getValue("facility_id"));
		hmGericIdBasedRecords	=	bean.getPatientActiveOrdersForDC(patient_id,patient_class,order_date,take_home, sbGenericIds.toString(),from_date,to_date);//Added from_date,to_date for BRU-HIMS-CRF-403  //generic_id changed to sbGenericIds.toString() for HSA-CRF-0151 [IN:048468]
		bean.setCurrentActiveOrders(active_orders);

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(defSelect));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

				for (String key: hmGericIdBasedRecords.keySet()){ //added for HSA-CRF-0151 [IN:048468]
					genericIdCount = 0;
					for(int i=0;i<presDetails.size();i++){
						drugDetails=(HashMap) presDetails.get(i);
						tmp_generic_id	= drugDetails.get("GENERIC_ID")==null?"":(String)drugDetails.get("GENERIC_ID");
						pres_drug_code	= drugDetails.get("DRUG_CODE")==null?"":(String)drugDetails.get("DRUG_CODE");
						if(tmp_generic_id.equals(key)){
							if(genericIdCount==0){

            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(tmp_generic_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(drugDetails.get("GENERIC_NAME")==null?"":(String)drugDetails.get("GENERIC_NAME")));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(genricIndex));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(genricIndex));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(tmp_generic_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(key));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(key));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(tmp_generic_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(defSelect));
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

								genricIndex++;
							}
							start_date	=	CommonBean.checkForNull((String)drugDetails.get("START_DATE"));
							end_date	=	CommonBean.checkForNull((String)drugDetails.get("END_DATE"));
							drug_desc	=	CommonBean.checkForNull((String)drugDetails.get("DRUG_DESC"));
							genericIdCount++;

            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(start_date));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(end_date));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block34Bytes, _wl_block34);

							break;
						}
					} //added for HSA-CRF-0151 [IN:048468] -end
					active_orders = (ArrayList)hmGericIdBasedRecords.get(key);
					genericRecCount = active_orders.size(); //added for HSA-CRF-0151 [IN:048468]
					tot_rec_count+=genericRecCount; //added for HSA-CRF-0151 [IN:048468]
					for (int i=0; i<genericRecCount; i++) {
						if(i%2==0)
							class_name	=	"QRYEVENSMALL";
						else
							class_name	=	"QRYODDSMALL";

						record	=	(HashMap)	active_orders.get(i);
						start_date			=	CommonBean.checkForNull((String)record.get("start_date"));
						end_date			=	CommonBean.checkForNull((String) record.get("end_date"));
						drug_desc			=	CommonBean.checkForNull((String) record.get("drug_desc"));
						practitioner_name	=	CommonBean.checkForNull((String) record.get("practitioner_name"));
						facility_name		=	CommonBean.checkForNull((String) record.get("facility_name"));
						location			=	CommonBean.checkForNull((String) record.get("location"));
						diag_text			=	CommonBean.checkForNull((String) record.get("diag_text"));
						split_dose_prev		=	CommonBean.checkForNull((String) record.get("split_dose_prev")); 
						order_id			=	CommonBean.checkForNull((String) record.get("order_id")); 
						order_line_no		=	CommonBean.checkForNull((String) record.get("order_line_no")); 
						freq_code			=	CommonBean.checkForNull((String) record.get("freq_code"));      
						freq_desc			=	CommonBean.checkForNull((String) record.get("freq_desc")); 
						allergy_reason		=	CommonBean.checkForNull((String) record.get("allergy_reason")); 
						dosage_reason		=	CommonBean.checkForNull((String) record.get("dosage_reason")); 
						duplicate_reason	=	CommonBean.checkForNull((String) record.get("duplicate_reason")); 
						perf_locn			=	CommonBean.checkForNull((String) record.get("perf_locn")); 
						iv_prep_yn			=   CommonBean.checkForNull((String) record.get("iv_prep_yn")); 
						discharge_ind		=   CommonBean.checkForNull((String) record.get("discharge_ind")); 
						in_formulary_yn		=	CommonBean.checkForNull((String) record.get("in_formulary_yn")); 
						dosage				=	CommonBean.checkForNull((String) record.get("dosage")); 
						dosage_uom			=	CommonBean.checkForNull((String) record.get("dosage_uom_desc")); 
						drug_code			=	CommonBean.checkForNull((String) record.get("drug_code")); 
						sliding_scale		=	CommonBean.checkForNull((String) record.get("sliding_scale"));   //added for Bru-HIMS-CRF-265 [IN:032315] 

						duplicate_reason = java.net.URLEncoder.encode(duplicate_reason);
						dosage_reason	 = java.net.URLEncoder.encode(dosage_reason);
						allergy_reason	 = java.net.URLEncoder.encode(allergy_reason);

						discont_date_time	=	(String) record.get("discont_date_time"); 
						order_status_type  = Integer.parseInt((String) record.get("order_status_type"));
						String discont_color="";
						drug_view		=	"onClick=\"callMenuFunctions('View','Pharmacy','"+patient_id+"','"+encounter_id+"','"+order_id+"','"+order_line_no+"','"+order_status_type+"','','PH','"+drug_code+"','"+generic_id+"')\"  style='cursor:pointer;color:blue'";
						if(discont_date_time!=null && !discont_date_time.equals("") ){
							discont_color = "red"; 
						}
									
						if(!allergy_reason.equals("") || !dosage_reason.equals("") || !duplicate_reason.equals("")) {
							link		=	"onClick=\"showReasons('"+allergy_reason+"','"+dosage_reason+"','"+duplicate_reason+"')\"  style='cursor:pointer;color:blue'";
							img_style="display:inline;cursor:pointer;";   //added for Bru-HIMS-CRF-265 [IN:032315] 
						}
						else {
							link		=	"";
							img_style = "display:none;";
						}

						StringTokenizer st		=	new StringTokenizer(diag_text,"~");
						boolean diag_text_found	=	false;
							while(st.hasMoreTokens()) {
							String txt	= (String)st.nextToken();
							if(!txt.equals("")) {
								diag_text_found	=	true;
								break;
							}
						}

						if(iv_prep_yn.equals("1")||iv_prep_yn.equals("2")||iv_prep_yn.equals("3")||iv_prep_yn.equals("4")||iv_prep_yn.equals("5")){
							if(order_line_no.equals("1")){
								class_name = "IVFLUID";
							}
							else{
								class_name		  = "IVINGREDIENT";
								/*practitioner_name = "&nbsp;";
								facility_name	  = "&nbsp;";
								location    = "&nbsp;";
								perf_locn	= "&nbsp;";
								freq_code	= "&nbsp;";	
								start_date  = "&nbsp;";
								end_date    = "&nbsp;";*/
							}
						}
						else if(iv_prep_yn.equals("6"))
							class_name		  = "COMPUNDRX";

						if(discharge_ind.equals("D"))
							class_name	= "DISCHARGEMED";

						if(in_formulary_yn.equals("N"))
							class_name	=	"FORMULARY";

            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(start_date));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(end_date));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drug_view));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(discont_color));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block41Bytes, _wl_block41);
		
							if(split_dose_prev.equals("")) {		

            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(dosage));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(dosage_uom));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(img_style));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(link));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(freq_desc));
            _bw.write(_wl_block48Bytes, _wl_block48);
			
							}
							else{	

            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(dosage));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(dosage_uom));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(img_style));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(link));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(freq_desc));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(start_date));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(sliding_scale));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(freq_desc));
            _bw.write(_wl_block53Bytes, _wl_block53);
			
							}

            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(practitioner_name));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(location));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(perf_locn));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(facility_name));
            _bw.write(_wl_block56Bytes, _wl_block56);
			
							if(diag_text_found) {

            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(diag_text)));
            _bw.write(_wl_block58Bytes, _wl_block58);

							}
							else {

            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block59Bytes, _wl_block59);

							}
							if(order_status_type >= 25){

            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(key));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(key));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(defSelect));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(key));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(i));
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(key));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(key));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block70Bytes, _wl_block70);
				
							}
							else if(order_status_type < 25){

            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(key));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(key));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(defSelect));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(key));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(i));
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(key));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(key));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block73Bytes, _wl_block73);
						
							}

            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(key));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(key));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(key));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(key));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf((String)session.getValue("ca_practitioner_id")));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(key));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(key));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(key));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(key));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(key));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(key));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(pres_drug_code));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(key));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(key));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(tmp_generic_id));
            _bw.write(_wl_block87Bytes, _wl_block87);

					}

            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(key));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(key));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(genericRecCount));
            _bw.write(_wl_block90Bytes, _wl_block90);

				}

            _bw.write(_wl_block91Bytes, _wl_block91);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(order_date));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(take_home));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf((String)session.getValue("ca_practitioner_id")));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(order_date));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(take_home));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(tot_rec_count));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(hmGericIdBasedRecords.size()));
            _bw.write(_wl_block103Bytes, _wl_block103);

		putObjectInBean(bean_id,bean,request); 
	}
	catch(Exception e){
		e.printStackTrace();
	}

            _bw.write(_wl_block104Bytes, _wl_block104);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.CurrentRx.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.StartDate.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enddate.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DrugName.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Dosage.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.OverrideReason.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Frequency.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PrescribedBy.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderingLocation.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PerformingLocation.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.facility.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.diagnosis.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.perform.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.generic.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.selectall.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Discontinue.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DiscontinueCancelOrders.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
