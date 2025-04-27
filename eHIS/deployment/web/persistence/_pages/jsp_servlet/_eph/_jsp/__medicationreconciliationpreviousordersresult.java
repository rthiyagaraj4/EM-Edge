package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eOR.*;
import ePH.*;
import ePH.Common.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.Common.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;
import eCommon.Common.*;
import java.util.*;

public final class __medicationreconciliationpreviousordersresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/MedicationReconciliationPreviousOrdersResult.jsp", 1741325688357L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonBean.jsp", 1710760607421L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n\t<head>\n\t\t<title></title>\n\t\t<!-- <link rel=\"stylesheet\" type =\"text/css\" href=\"../../eCommon/html/IeStyle.css\"></link> -->\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/PrescriptionTest.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../ePH/js/PhCommon.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../js/MedicationReconciliation.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n\t</head>\n\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t<script>\n\t\t\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\'Common\'));\n\t\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\' style=\"overflow-x:hidden;overflow-y:scroll\">\n\t\t\t\t<form name=\"frmPrescriptionPrevOrdersResult1\" id=\"frmPrescriptionPrevOrdersResult1\" >\n\t\t\t\t<!-- Display the Previous Next link -->\n\t\t\t\t\t<div id=\"HTab\" style=\"width:100%;\" align=\'left\'>\n\t\t\t\t\t\t<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"left\" name=\"resultTable\" id=\"resultTable\" style=\'position:relative;top:expression(this.offsetParent.scrollTop-2)\'>\n\t\t\t\t\t\t\t<tr>  \t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<th  nowrap width=\"1%\" style=\"font-size:10\">&nbsp;</th>\n\t\t\t\t\t\t\t\t<th  nowrap width=\"5%\" style=\"font-size:10\" >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<th  width=\"12%\"  style=\"font-size:10\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n\t\t\t\t\t\t\t\t<th  width=\"12%\"  style=\"font-size:10\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<th width=\"8%\" style=\"font-size:10\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n\t\t\t\t\t\t\t\t<th width=\"8%\" style=\"font-size:10\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</th>\n\t\t\t\t\t\t\t\t<th  width=\"6%\"  style=\"font-size:10\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</th>\n\t\t\t\t\t\t\t\t<th width=\"7%\" style=\"font-size:10\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</th>\n\t\t\t\t\t\t\t\t<th  width=\"8%\"  style=\"font-size:10\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</th>\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<th  nowrap width=\"13%\" style=\"font-size:10\">&nbsp;</th>\n\t\t\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t</div>\n\t\t\t\t\t<div id=\"DataTab\" style=\"height:310px; width:100%;\" align=\'left\'>\n\t\t\t\t\t\t<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" name=\"resultTable\" id=\"resultTable\" id=\"resultTable\">\n\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\t\t\n\t\t\t\t\t\t\t\t<tr>\n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t\t\t\t<td width=\"1%\" class=\'CANCELLED\'>&nbsp;</td>\n\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t\t\t\t\t<td width=\"1%\" class=\'DISCONTINUED\'>&nbsp;</td>\n\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t\t\t\t\t<td width=\"1%\" class=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">&nbsp;</td>\n\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t\t\t\t\t<input type =\"hidden\" name =\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\"> \n\t\t\t\t\t\t\t\t\t\t<td width=\"5%\" class=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"   id=\'drug_";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'><input type=\"checkbox\" name=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' id=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' onClick=\" return checkDuplicate1(this,\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\',\'Previous\'); \"  value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =" ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =">\n\t\t\t\t\t\t\t\t\t\t<input type =\"hidden\" name =\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\"></td>\n\t\t\t\t\t\t\t\t\t\t<input type = \"hidden\" name =\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" value = \'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t\t\t\t\t\t<td width=\"5%\" class=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\"  >&nbsp;</td>\n\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t\t\t\t\t<input type =\"hidden\" name =\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\"></td>\n\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<td width=\"12%\" style=\"font-size:10\" class=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</td>\n\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t\t\t\t\t\t\t<td width=\"12%\" style=\"font-size:10\" class=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t\t\t\t\t<td width=\"12%\" style=\"font-size:10\" class=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\t\t\t\t\t\t\t<td width=\"8%\" style=\"font-size:10\" class=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</td>\n\t\t\t\t\t\t\t\t\t<td width=\"8%\" style=\"font-size:10\" class=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</td>\n\t\t                             \n\t\t                             <td width=\"6%\" nowrap style=\"font-size:10\" class=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</td>\n\t\t\t\t\t\t\t\t\t <td width=\"7%\" nowrap style=\"font-size:10\" class=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="&nbsp;</td>\n\t\t\t\t\t\t\t\t\t <td width=\"7%\" nowrap style=\"font-size:10\" class=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="&nbsp;</td>\n\t\t\t\t\t\t\t\t\t<td width=\"7%\" nowrap style=\"font-size:10\" class=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="&nbsp;</td>\t\t                       \t\t                             \n\t\t\t\t\t\t\t\t\t<td width=\"8%\" nowrap style=\"font-size:10\" class=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</td>\n\t\t\t\t\t\t\t\t\t<td width=\"8%\" nowrap style=\"font-size:10\" class=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\t\t\t\t\t<td width=\"13%\" nowrap style=\"font-size:10\" class=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\"><input type=\"button\" value=\"Discontinue/Cancel\" name=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\' onClick=\'discCancelOrders(this)\'></td>\n\t\t                        ";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\t\t\t\t\t<td width=\"13%\" nowrap style=\"font-size:10\" class=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">&nbsp;</td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t\t\t\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t\t\t\t</table>\n\t\t\t\t\t\t<input type=\"hidden\" name=\"from\" id=\"from\" value=\"\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"to\" id=\"to\" value=\"\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"pat_class\" id=\"pat_class\" value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"ord_status\" id=\"ord_status\" value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" name=\"presBean_id\">\n\t\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" name=\"presBean_name\">\n\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"order_from\" id=\"order_from\" value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"order_to\" id=\"order_to\" value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t\t\t<input type=\"hidden\" name=\"pract_id\" id=\"pract_id\" value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">\n";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t\t\t\t\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\">\t\n\t\t\t\t\t\t<input type=\"hidden\" name=\"drug_desc\" id=\"drug_desc\" value=\"\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"tot_rec\" id=\"tot_rec\" value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"group_by\" id=\"group_by\" value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"rx_type\" id=\"rx_type\" value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"checkcount\" id=\"checkcount\" value=";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 =">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"system_date\" id=\"system_date\" value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"log_pract_id\" id=\"log_pract_id\" value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"pract_type\" id=\"pract_type\" value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"discharge_ind\" id=\"discharge_ind\" value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\">\t<!-- added for #70618 -->\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t</form>\n\t\t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t</body>\n\n</html>\n\n";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );
	
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
---------------------------------------------------------------------------------------------------------------
Date       	Edit History            Name        		             Description
---------------------------------------------------------------------------------------------------------------
28/05/2019	IN:067951	            Devindra			              MMS-KH-CRF-0016
10/10/2019  IN070786                PRATHYUSHA                       MMS-KH-CRF-0016.1
---------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            eCommon.Common.CommonBean CommonBean= null;{
                CommonBean=(eCommon.Common.CommonBean)pageContext.getAttribute("CommonBean");
                if(CommonBean==null){
                    CommonBean=new eCommon.Common.CommonBean();
                    pageContext.setAttribute("CommonBean",CommonBean);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

    CommonBean.setProperties( (Properties) session.getValue( "jdbc" ) ) ;
	CommonBean.setLoginById( (String) session.getValue( "login_user" ) ) ;
	CommonBean.setLoginAtWsNo( CommonBean.getProperties().getProperty( "client_ip_address" ) ) ;
	CommonBean.setLoginFacilityId( (String) session.getValue( "facility_id" ) ) ;

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);

		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

		
		try{
			String pat_class	=	request.getParameter("pat_class");
			String ord_status	=	request.getParameter("ord_status");
			String order_from	=   request.getParameter("order_from");
			String order_to		=	request.getParameter("order_to");
			String pract_id		=	request.getParameter("pract_id");
			String patient_id	=	request.getParameter("patient_id");
			String encounter_id	=	request.getParameter("encounter_id");
			String discharge_ind =  request.getParameter("discharge_ind"); // added for #70618
			String group_by		=	"";
		    String called_by =  request.getParameter("called_by")==null?"":request.getParameter("called_by"); // added for #70618
			String log_pract_id	=	request.getParameter("log_pract_id");
			int l=0;
			int len=0, point=0;//added for IN070786
			String temp="";// added for IN070786
			
			String sys_date=(String) com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
			String iv_prep_yn="";
			String rx_legend="";
			String rx_type		=	request.getParameter("rx_type");
			String from	= CommonBean.checkForNull(request.getParameter("from"));
			String to	= CommonBean.checkForNull(request.getParameter("to"));
			String drug_desc = CommonBean.checkForNull(request.getParameter("drug_desc"));
			String call_from = CommonBean.checkForNull(request.getParameter("call_from")); // Added for Inc#70652
			String checkcount = CommonBean.checkForNull(request.getParameter("checkcount"),"0");
			String pract_type = CommonBean.checkForNull(request.getParameter("pract_type"),""); 
			l = Integer.parseInt(checkcount);
			String bean_id		= "@PrescriptionBean_1"+patient_id+encounter_id;
			String bean_name	= "ePH.PrescriptionBean_1";
			PrescriptionBean_1 bean		= (PrescriptionBean_1)getBeanObject( bean_id,bean_name,request );
			String presBean_id			= "PrescriptionBean"+patient_id+encounter_id;
			String presBean_name		= "ePH.PrescriptionBean";
			PrescriptionBean presBean		= (PrescriptionBean)getBeanObject(presBean_id, presBean_name, request );
			bean.setLanguageId(locale);
			String facility_id					= (String) session.getValue("facility_id");
			String DMA_bean_id				=	"DispMedicationAllStages" ;     
			String DMA_bean_name		=	"ePH.DispMedicationAllStages";

			DispMedicationAllStages DMAbean = (DispMedicationAllStages)getBeanObject( DMA_bean_id, DMA_bean_name,request);
			DMAbean.setLanguageId(locale);

			String or_bean_name				= "eOR.OrderEntryBean";
			String or_bean_id				= "@orderentrybean"+patient_id+encounter_id;
			OrderEntryBean orbean			= (OrderEntryBean)getBeanObject( or_bean_id,or_bean_name,request ) ;
		    String drugsearch_bean_Id   = "ePH.DrugSearchBean";  //  Added for ML-BRU-SCF-0958 [IN:042045] Start
			String drugsearch_bean_name = "ePH.DrugSearchBean";
		    DrugSearchBean drugbean		=	(DrugSearchBean)getBeanObject( drugsearch_bean_Id, drugsearch_bean_name, request ) ; //  Added for ML-BRU-SCF-0958 [IN:042045] End
			orbean.setLanguageId(locale);
			String resp_id = orbean.getResponsibilityId();
			ArrayList result		=	new ArrayList();
			ArrayList alphabets		=	new ArrayList();
			ArrayList prescriptions	=  bean.getPrescriptions();
			
			if(call_from.equals("SEARCH")) // Added for Inc#70652 - Satrt
				bean.copyPresClear(); // Added for Inc#70652 - End
			if(called_by.equals("SEARCH"))
				bean.setExternal_drugs_tmp(new ArrayList()); // Added for Inc#70652 - End
			
			String checked			=	"";
			boolean found			=  false; 
			if(!locale.equals("en")){
				order_from = DateUtils.convertDate(order_from, "DMY",locale,"en");
				order_to = DateUtils.convertDate(order_to, "DMY",locale,"en");
			}

			String drug_priv_appln_yn			= (String) session.getValue("PrivilegeApplicability");
			if ( drug_priv_appln_yn == null || drug_priv_appln_yn.equals("")) 
				drug_priv_appln_yn = "N";
			HashMap total_result	=	bean.getMRPreviousOrders(pat_class,pract_id,patient_id,ord_status,order_from,order_to,from,to,drug_desc,group_by,drug_priv_appln_yn,resp_id, log_pract_id);
			ArrayList prescriptionDetails=(ArrayList)bean.getpresDetails();
			if(total_result.size()!=0 && group_by.equals("DR")) {
				result		=	(ArrayList)total_result.get("RESULT");
				//alphabets	=	(ArrayList)total_result.get("ALPHABETS");
			} 
			else{
				result		=	(ArrayList)total_result.get("RESULT");
			}
			int recCount		=	0;
			String classValue	=	"";
			String disabled		=	"";
			String pres_no		=	"";
			String order_id		=	"";
			String order_line_no		=	"";
			String drug_code	=	"";
			String ord_date="";
			String sliding_scale_yn = "";
			String priv_appl_yn = "";
			boolean taper_display = false;
		    String verb_order_appr_drug_yn = ""; //Added for ML-BRU-SCF-0958 [IN:042045] 
		    String Called_from_verbal_order = drugbean.getCalled_from_verbal_order(); //Added for ML-BRU-SCF-0958 [IN:042045]
			HashMap iv_legends = (HashMap) presBean.getIVLegends();
			String taper = "";
			String qty_uom, strength_value, taper_disabled=""; //taper_disabled added for [IN:048140]
			if(result.size()<1){
		
            _bw.write(_wl_block9Bytes, _wl_block9);

				return;
			}
		
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
 		               
		                    String disContinue = "N";
							HashMap taperValues = null; //Added for RUT-CRF-0088 [IN036978]
							String order_qty ="";
							String dispense_qty = "";
						    String admin_qty = "";
						    String dosage_type				= "";//added for IN070786
							  String freq_nature		= "";//added for IN070786
							  String content_in_pres_base_uom = "";//added for IN070786
							int count = 1;
							for(int i=0; i<result.size(); i+=34) { // i+=22 to 23 Added for ML-BRU-SCF-0958 [EMR IN:1835]
							   order_qty = (String)result.get(i+24);
							     dosage_type				= (String)result.get(i+32);//added for IN070786
								   freq_nature		= (String)result.get(i+31);//added for IN070786
								   content_in_pres_base_uom = (String)result.get(i+30);//added for IN070786
								   strength_value = (String) result.get(i+33);//added for IN070786
							   		   if(!order_qty.equals(""))
								   order_qty =order_qty+" "+bean.getUomDisplay(facility_id,(String)result.get(i+25));
							  
							  dispense_qty = (String)result.get(i+23);
							  
							  if(!dispense_qty.equals(""))
								  dispense_qty =dispense_qty+" "+bean.getUomDisplay(facility_id,(String)result.get(i+25));
							  
							  admin_qty = (String)result.get(i+22);
							  
							  //added for IN070786 start
							  if(!admin_qty.equals("")  && !admin_qty.equals("0") && (dosage_type.equals("A") || dosage_type.equals("Q"))){

									len= admin_qty.length();
									if( len > 0 && Float.parseFloat(admin_qty)>1 ){
										temp = admin_qty;
										point= temp.indexOf(".")+1;
										if(point!=0 && temp.charAt(point)=='0')
											admin_qty = admin_qty.substring(0,point-1);
									}		
								}
								 
								else if(!admin_qty.equals("")  && !admin_qty.equals("0") && dosage_type.equals("S")){  
								
									admin_qty = Float.toString( Float.parseFloat(admin_qty) * Float.parseFloat(strength_value) );
									
									len= admin_qty.length();
									if( len > 0 && Float.parseFloat(admin_qty)>1 ){
										temp = admin_qty;
										point= temp.indexOf(".")+1;
										if(point!=0 && temp.charAt(point)=='0')
											admin_qty = admin_qty.substring(0,point-1);
									}						

									} 
							  if(admin_qty!=null && !admin_qty.equals("") && !admin_qty.equals("0") && freq_nature.equals("P")){ 
								  admin_qty =Float.toString( Float.parseFloat(admin_qty)*Float.parseFloat(content_in_pres_base_uom));
								  len= admin_qty.length();
								
								if( len > 0 ){
									temp = admin_qty;
									point= temp.indexOf(".")+1;
									if(point!=0 && temp.charAt(point)=='0')
										admin_qty = admin_qty.substring(0,point-1);
								}
							}
							  //added for IN070786 end
							  
							  if(!admin_qty.equals(""))
								admin_qty =admin_qty+" "+bean.getUomDisplay(facility_id,(String)result.get(i+28));
								
							    disContinue = "N";
								if(recCount%2==0)
									classValue="QRYEVENSMALL";
								else
									classValue="QRYODDSMALL";

								found	=	false;
								
								checked		=	"";
								disabled	=	"";
								order_id = (String)result.get(i+1);
								order_line_no = (String)result.get(i+2);
								drug_code = (String)result.get(i+3);
							    //verb_order_appr_drug_yn = (String)result.get(i+22); // Commented for ML-BRU-SCF-0958 [IN:042045  
								iv_prep_yn = (String)result.get(i+17);
									disContinue = (String)result.get(i+18);
									sliding_scale_yn = (String)result.get(i+19);
									priv_appl_yn = (String)result.get(i+20);
									verb_order_appr_drug_yn = (String)result.get(i+21); //  Added for ML-BRU-SCF-0958 [IN:042045]
								if(iv_prep_yn==null) 
									iv_prep_yn="";

								if(iv_prep_yn.equals(""))
									rx_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.NormalRx.label", "ph_labels");
								else if(iv_prep_yn.equals("0"))
									rx_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.OncologyRegimen.label", "ph_labels")+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Admixture.label", "ph_labels")+")";
								else if(iv_prep_yn.equals("1"))
									rx_legend=(String)iv_legends.get("IVA")+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Direct.label", "common_labels")+")";//com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.IVwithAdditives.label","common_labels");
								else if(iv_prep_yn.equals("2"))
									rx_legend= (String)iv_legends.get("IVA")+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Admixture.label", "ph_labels")+")";//com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.IVwithAdditives.label", "common_labels")+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Admixture.label", "ph_labels")+")";
								else if(iv_prep_yn.equals("3"))
									rx_legend= (String)iv_legends.get("IVI")+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Direct.label", "common_labels")+")";//"IV Piggyback (Direct)";
								else if(iv_prep_yn.equals("4"))
									rx_legend= (String)iv_legends.get("IVI")+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Admixture.label", "ph_labels")+")";//"IV piggyback (Admixture)";
								else if(iv_prep_yn.equals("5"))
									rx_legend= (String)iv_legends.get("IVWA");//com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.IVwithAdditives.label", "common_labels");
								else if(iv_prep_yn.equals("6"))
									rx_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.CompoundingRx.label", "ph_labels");
								else if(iv_prep_yn.equals("7"))
									rx_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.TPNStandardRegimen.label", "ph_labels");//"TPN Standard Regimen";
								else if(iv_prep_yn.equals("8"))
									rx_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.TPNNONStandardRegimen.label", "ph_labels");//"TPN NON Standard Regimen";
								else if(iv_prep_yn.equals("9"))
									rx_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.OncologyRegimen.label", "ph_labels")+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Direct.label", "common_labels")+")";//"Oncology Regimen (Direct)";

								if(prescriptions!= null && prescriptions.contains(result.get(i+3))){ 
									disabled	=	"disabled";
								}
								if(prescriptions!= null && prescriptions.contains(result.get(i+1)+","+result.get(i+2))){ 
									checked		=	"checked";
									disabled	=	"";
								}
								for(int j=0;j<prescriptionDetails.size();j++){
									if(((String)((HashMap) prescriptionDetails.get(j)).get("DRUG_CODE")).equals((String)result.get(i+3)) ) {
										found	=	true;
										break;
									}
								}

								if(found){
									disabled	=	"disabled";
								}
								taper_display=false; //Added for SKR-SCF-0823 [IN:041165]
								//count = DMAbean.chkfortapering(order_id,drug_code, order_line_no);//commented for RUT-CRF-0088 [IN036978]
								taperValues=DMAbean.chkfortapering(order_id,drug_code, order_line_no, patient_id);	//Modified for RUT-CRF-0088 [IN036978]  
								//count =Integer.parseInt(taperValues.get("COUNT").toString());  // Modified for RUT-CRF-0088 [IN036978]  //Commented for ML-BRU-SCF-1458 [IN:052366]
								count = bean.chkfortaperingCount(order_id);//commented for RUT-CRF-0088 [IN036978]
								if(count==1 ){
									taper_display=false;
								}

							if((count==1)||(!taper_display)){
		
            _bw.write(_wl_block19Bytes, _wl_block19);
 
									if( ((String)result.get(i)).equals("CN")){
		
            _bw.write(_wl_block20Bytes, _wl_block20);

									} 
									else if( ((String)result.get(i)).equals("DC")) { 
		
            _bw.write(_wl_block21Bytes, _wl_block21);

									}
									else{
		
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block23Bytes, _wl_block23);
	
									}

									if(rx_type.equals("") && iv_prep_yn.equals("")){
										if(disContinue.equals("Y") || (Called_from_verbal_order.equals("Y") && verb_order_appr_drug_yn.equals("N")) ||  (pract_type.equals("NS") && verb_order_appr_drug_yn.equals("N")))  //verbal order condition added for ML-BRU-SCF-0958 [IN:042045](pract_type.equals("NS") && verb_order_appr_drug_yn.equals("N")) -- //  Added for ML-BRU-SCF-0958 [EMR IN:1835] 
											disabled="disabled";

										if(prescriptions!=null && prescriptions.contains(result.get(i+1)+","+result.get(i+2))){ 
											checked		=	"checked";
											//disabled	=	"disabled";
										} 
		
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(result.get(i+1)+","+result.get(i+2)+",priv"));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(priv_appl_yn));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)result.get(i+1)));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(result.get(i+1)+","+result.get(i+2)));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(result.get(i+1)+","+result.get(i+2)));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(priv_appl_yn));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(result.get(i+3)));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(checked));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(result.get(i+1)+","+result.get(i+2)+",drug_code"));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(result.get(i+3)));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(result.get(i+1)+","+result.get(i+2)+",ord_status"));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf((String)result.get(i)));
            _bw.write(_wl_block37Bytes, _wl_block37);

									}
									else{
		
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block39Bytes, _wl_block39);

									}
		
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(result.get(i+1)+","+result.get(i+2)+",end_date"));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(result.get(i+13)));
            _bw.write(_wl_block41Bytes, _wl_block41);

									if((count>1)){
										taper = DMAbean.getTapervalue();
										taper_display = true;
									}
		
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(result.get(i+4)));
            _bw.write(_wl_block44Bytes, _wl_block44);

									if(sliding_scale_yn.equals("N")){										
										strength_value = (String) result.get(i+5);
										if(strength_value!=null && !strength_value.equals("") && Float.parseFloat(strength_value) < 1)
											strength_value = Float.parseFloat(strength_value)+"";
										qty_uom = (String) result.get(i+6);
										if(qty_uom!=null && !qty_uom.equals(""))
											qty_uom = bean.getUomDisplay(facility_id,result.get(i+6).toString());
										if(((String)result.get(i+8)).equals("(Divided)")){
		
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(strength_value+" "+qty_uom+"&nbsp;-&nbsp;<font  color=red>"+result.get(i+8)+"</font>&nbsp;for&nbsp;"+result.get(i+9)+" "+result.get(i+11)));
            _bw.write(_wl_block44Bytes, _wl_block44);

										}
										else{
		
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(strength_value+" "+qty_uom+"&nbsp;-&nbsp;"+result.get(i+8)+"&nbsp;for&nbsp;"+result.get(i+9)+" "+result.get(i+11)));
            _bw.write(_wl_block44Bytes, _wl_block44);

										}
									}
									else{
		
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(result.get(i+8)+"&nbsp;for&nbsp;"+result.get(i+9)+" "+result.get(i+11)));
            _bw.write(_wl_block44Bytes, _wl_block44);
							
									}
		
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(result.get(i+15)));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(result.get(i+16)==null?"&nbsp;":result.get(i+16)));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(result.get(i+26)));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(order_qty));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(dispense_qty));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(admin_qty));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(result.get(i+12)));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(result.get(i+13)));
            _bw.write(_wl_block55Bytes, _wl_block55);
 if(rx_type.equals("") && iv_prep_yn.equals(""))
										if(!((String)result.get(i)).equals("DC") && !((String)result.get(i)).equals("CN"))
										{
								
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(result.get(i+27)+","+result.get(i+3)+","+result.get(i+29)+","+order_id+","+order_line_no));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(result.get(i+27)+","+result.get(i+3)+","+result.get(i+29)+","+order_id+","+order_line_no));
            _bw.write(_wl_block58Bytes, _wl_block58);

										} else{
								
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block60Bytes, _wl_block60);
} 
            _bw.write(_wl_block61Bytes, _wl_block61);

							}
							order_qty ="";
							dispense_qty = "";
						    admin_qty = "";
						    
							recCount++;
						}	
		
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(pat_class));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(ord_status));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(presBean_id));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(presBean_name ));
            _bw.write(_wl_block68Bytes, _wl_block68);

						if(!locale.equals("en")){ // added if condition for the incident : SKR-SCF-0748 [IN036983]
		
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(DateUtils.convertDate(order_from, "DMY","en",locale)));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(DateUtils.convertDate(order_to, "DMY","en",locale)));
            _bw.write(_wl_block71Bytes, _wl_block71);
				}
						else{
		
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(order_from));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(order_to));
            _bw.write(_wl_block71Bytes, _wl_block71);
              
						}
		
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(pract_id));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block74Bytes, _wl_block74);
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(group_by));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(rx_type));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(l));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(sys_date));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(log_pract_id));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(pract_type));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(discharge_ind));
            _bw.write(_wl_block84Bytes, _wl_block84);
 
			} 
		catch(Exception e) {
			out.print("Exception @ medicationreconsolationResult :"+e.toString());
			e.printStackTrace();
		}
		

            _bw.write(_wl_block85Bytes, _wl_block85);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DrugName.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DosageDetail.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderedBy.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.OrderedLocation.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.facility.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PrescribedQty.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DispensedQty.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.admin.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Qty.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.StartDate.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enddate.label", java.lang.String .class,"key"));
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
}
