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
import java.math.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __prescriptionheader_2 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/PrescriptionHeader_2.jsp", 1709121222474L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 =" <!-- java.math.* Added for ML-MMOH-CRF-1004 -->\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="  \n<html>\n\t<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../js/Prescription_1.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../js/Prescription_2.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../js/PrescriptionTest.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t\t<!-- <script language=\"JavaScript\" src=\"../js/PhMessages.js\"></script> -->\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../js/PregnancyCategory.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<script>\t\n\t\t\t\tparent.parent.parent.parent.parent.orderMainTab.OrCommonForm.ph_load_yn.value=\"Y\";\n\t\t\t</script>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t\t\t\t<form name=\"prescription_header_form\" id=\"prescription_header_form\">\n\t\t\t\t\t<table cellpadding=0 cellspacing=0 width=\"100%\" align=\"center\" border=\"1\">\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td class=\"label\" width=\"9%\" >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" :</td>\n\t\t\t\t\t\t\t<td class=\"label\" width=\"5%\" >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&nbsp;<b>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</b></td>\t\t\n\t\t\t\t\t\t\t<td class=\"label\" width=\"8%\" >";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</b></td>\t\t\n\t\t\t\t\t\t     ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t    <td class=\"label\" width=\"5%\" >";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" m&sup2;</label></td>\n\t\t\t\t\t\t\t<td class=\"label\" width=\"5%\" >";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" :</td>\n\t\t\t\t\t\t\t<td class=\"label\" width=\"8%\" >";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" kg/m&sup2;</label></td>\n\t\t\t\t\t\t   ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t\t<td class=\"label\" width=\"5%\" >";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t\t\t\t\t\t\t<td class=\"label\" width=\"5%\" >";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t\t<td class=\"label\" width=\"10%\" >";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" :&nbsp;</td>\n\t\t\t\t\t\t\t<td class=\"label\" width=\"10%\" ><b>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</b></td>\n\t\t\t\t\t\t\t<td class=\"label\" width=\"10%\" >";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" :</td>\n\t\t\t\t\t\t\t<td class=\"label\" width=\"16%\" ><b>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</b></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t\t<table cellpadding=0 cellspacing=0 width=\"100%\" align=\"center\" border=\"0\">\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td class=\"label\" width=\"12%\"  nowrap>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" :</td>\n\t\t\t\t\t\t\t<td class=\"label\" width=\"20%\"  nowrap>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n\t\t\t\t\t\t\t<td class=\"label\" width=\"25%\"  nowrap>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="<!-- Take Home Medication -->&nbsp;&nbsp;<input type=\"checkbox\" value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' name=\"take_home_medication\" nowrap ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" disabled></td>\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t\t\t<td class=\"label\" width=\"25%\"  nowrap>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="&nbsp;&nbsp;<input type=\"checkbox\" name=\"home_leave_medication\" id=\"home_leave_medication\" nowrap ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" disabled>\n\t\t\t\t\t\t\t\t<br>(";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =" - ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" )\n\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t\t<td class=\"label\" width=\"23%\"  nowrap><label>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =": <b>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</b></label></td>\n\t\t\t\t\t\t\t<td class=\"label\" width=\"15%\"  nowrap>\n\t\t\t\t\t\t\t\t<a href=\"javascript:callOrderRemarks();\" title=\"Remarks\">&nbsp;";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</a>\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="   \n\t\t\t\t\t\t\t\t<a href=\"javascript:callADRdetails(\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\');\" title=\"Clinical Comments\">&nbsp;&nbsp;&nbsp;ADR</a>\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t\t    <label onClick=\"javascript:callDiagText(\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\',\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\',\'Header\');\" style=\"visibility:hidden\" id=\"diag_text\" title=\"Diag Text\">&nbsp;&nbsp;";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</label>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td>\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t\t\t\t<td class=\"label\"  nowrap >&nbsp;&nbsp;<a href=\"javascript:showPregnancyRemarks(\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\');\" title=\"Pregnancy Remarks \">&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =" </a>&nbsp;&nbsp;</td>\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td class=\"label\" width=\"10%\" nowrap>\n";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t\t \t\t<a href=\"javascript:callAmendDiagText(\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\');\" title=\"Remarks\">&nbsp;";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</a> \n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\t\t\t\t&nbsp;&nbsp;\n";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\t\t\t\n\t\t\t\t\t\t\t</td>\t\t\t\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" name=\"presBean_id\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" name=\"presBean_name\">\n\t\t\t\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"order_id\" id=\"order_id\" value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"order_line_num\" id=\"order_line_num\" value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"priority\" id=\"priority\" value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"or_date_time\" id=\"or_date_time\" value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"patient_class\" id=\"patient_class\" value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"actual_patient_class\" id=\"actual_patient_class\" value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"location_type\" id=\"location_type\" value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"location_code\" id=\"location_code\" value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"source_type\" id=\"source_type\" value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"source_code\" id=\"source_code\" value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" name=\"facility_id\">\t\t\n\t\t\t\t\t<input type=\"hidden\" name=\"order_remarks\" id=\"order_remarks\" value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\">\n\t\t\t\t\t\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\" name=\"schedule_yn\">\t\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" name=\"called_from\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\" name=\"sys_date\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\" name=\"attend_pract_id\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" name=\"pract_id\">\n\t\t\t\t\t<input type=\"hidden\" name=\"pract_name\" id=\"pract_name\" value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" >\t\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\" name=\"resp_id\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\" name=\"iv_prep_yn\">\n\t\t\t\t\t<input type=\"hidden\" name=\"allergic_yn\" id=\"allergic_yn\" value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\">\t\t\n\t\t\t\t\t<input type=\"hidden\" name=\"patient_height\" id=\"patient_height\" value=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\"> \n\t\t\t\t\t<input type=\"hidden\" name=\"bed_num\" id=\"bed_num\"\t\t\t\t\t  value=\"\"> \n\t\t\t\t\t<input type=\"hidden\" name=\"room_num\" id=\"room_num\"\t\t\t\t\t  value=\"\"> \n\t\t\t\t\t<input type=\"hidden\" name=\"height\" id=\"height\"\t\t\t\t\t  value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\"> \n\t\t\t\t\t<input type=\"hidden\" name=\"height_unit\" id=\"height_unit\"\t\t\t\t  value=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"patient_weight\" id=\"patient_weight\"\t\t\t  value=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"weight\" id=\"weight\"\t\t\t\t\t  value=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"weight_unit\" id=\"weight_unit\"\t\t\t\t  value=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"bsa\" id=\"bsa\"\t\t\t\t\t\t  value=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"bmi\" id=\"bmi\"\t\t\t\t\t\t  value=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\">\t\n\t\t\t\t\t<input type=\"hidden\" name=\"administered_yn\" id=\"administered_yn\"           value=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"problem_ind\" id=\"problem_ind\"               value=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\">\t\t\n\t\t\t\t\t<input type=\"hidden\" name=\"diag_size\" id=\"diag_size\"                 value=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"take_home_medi_val\" id=\"take_home_medi_val\"        value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\">\n\t\t\t\t\t\n\t\t\t\t\t<!--External Drug Interface Controls -->\t   \n\t\t\t\t\t<input type=\"hidden\" name=\"drug_db_interface_yn\" id=\"drug_db_interface_yn\"       value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\"> \n\t\t\t\t\t<input type=\"hidden\" name=\"drug_db_product_id\" id=\"drug_db_product_id\"         value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\"> \n\t\t\t\t\t<input type=\"hidden\" name=\"drug_db_dosecheck_yn\" id=\"drug_db_dosecheck_yn\"       value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\"> \n\t\t\t\t\t<input type=\"hidden\" name=\"drug_db_duptherapy_yn\" id=\"drug_db_duptherapy_yn\"      value=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\"> \n\t\t\t\t\t<input type=\"hidden\" name=\"drug_db_interact_check_yn\" id=\"drug_db_interact_check_yn\"  value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"drug_db_contraind_check_yn\" id=\"drug_db_contraind_check_yn\" value=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"drug_db_allergy_check_yn\" id=\"drug_db_allergy_check_yn\"   value=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"adr_count\" id=\"adr_count\"                  value=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"narcotic_aprvl_form_req_yn\" id=\"narcotic_aprvl_form_req_yn\" value=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\"> \n\t\t\t\t\t<input type=\"hidden\" name=\"print_narcotic_form_by_default\" id=\"print_narcotic_form_by_default\" value=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\"> \n\n\t\t\t\t\t<!--Billing Display flags -->\t   \n\t\t\t\t\t<input type=\"hidden\" name=\"bl_disp_charge_dtl_in_rx_yn\" id=\"bl_disp_charge_dtl_in_rx_yn\" value=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"bl_install_yn\" id=\"bl_install_yn\" value=\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"dc_mar_appl_yn\" id=\"dc_mar_appl_yn\" value=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"em_mar_appl_yn\" id=\"em_mar_appl_yn\" value=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"ip_mar_appl_yn\" id=\"ip_mar_appl_yn\" value=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"op_mar_appl_yn\" id=\"op_mar_appl_yn\" value=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"disch_med_mar_appl_yn\" id=\"disch_med_mar_appl_yn\" value=\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"max_durn_for_ip_pres\" id=\"max_durn_for_ip_pres\" value=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"chk_for_ip_max_durn_action\" id=\"chk_for_ip_max_durn_action\" value=\"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"max_durn_for_op_pres\" id=\"max_durn_for_op_pres\" value=\"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"chk_for_op_max_durn_action\" id=\"chk_for_op_max_durn_action\" value=\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"max_durn_for_dm_pres\" id=\"max_durn_for_dm_pres\" value=\"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\"><!--  added for ML-MMOH-SCF-0498\t-->\n\t\t\t\t\t<input type=\"hidden\" name=\"chk_for_dm_max_durn_action\" id=\"chk_for_dm_max_durn_action\" value=\"";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\"><!--  added for ML-MMOH-SCF-0498\t-->\n\t\t\t\t\t<input type=\"hidden\" name=\"trade_display_yn\" id=\"trade_display_yn\" value=\"";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"man_rem_on_prn_freq_yn\" id=\"man_rem_on_prn_freq_yn\" value=\"";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"max_length_prn_reason\" id=\"max_length_prn_reason\" value=\"";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"rx_qty_by_pres_base_uom_yn\" id=\"rx_qty_by_pres_base_uom_yn\" value=\"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"atc_allergy_alert_level\" id=\"atc_allergy_alert_level\" value=\"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"drug_interaction_check_yn\" id=\"drug_interaction_check_yn\" value=\"";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"print_mar_label_yn\" id=\"print_mar_label_yn\" value=\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\"><!-- added for MMS-QH-CRF-0080 [IN:038064] -->\n\t\t\t\t\t<input type=\"hidden\" name=\"buildMAR_yn\" id=\"buildMAR_yn\" value=\"N\"><!-- added for MMS-QH-CRF-0080 [IN:038064] -->\n\t\t\t\t\t<input type=\"hidden\" name=\"excludeADRAllergyAlert_yn\" id=\"excludeADRAllergyAlert_yn\" value=\"";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\"><!--Added for HSA-SCF-0011 [IN:042444] -->\n\t\t\t\t\t<input type=\"hidden\" name=\"preview_rx_yn\" id=\"preview_rx_yn\" value=\"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\"><!-- //added for ML-MMOH-CRF-0341 [IN:057179] -->\n\t\t\t\t\t <input type=\"hidden\" name=\"drug_indication_mdry\" id=\"drug_indication_mdry\" value=\"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\"><!-- Added for JD-CRF-0220 -->\n\t\t\t</form>\n\t\t</body>\n";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\n\t\t<script>loadAllOtherFrames();</script>\n";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\n\t\t\t<script>loadAllOtherFrames_1();</script>\n";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\n</html>\n\n";
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
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);

 		request.setCharacterEncoding("UTF-8"); 
		//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
	    request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	    response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	    response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	    //ends
		String locale = (String) session.getAttribute("LOCALE");
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	try{
		String iv_prep_yn = request.getParameter("iv_prep_yn");
		if(iv_prep_yn == null) 
			iv_prep_yn="";
			
		String facility_id		= (String) session.getValue("facility_id");
		String patient_id		= request.getParameter("patient_id"); 
		String encounter_id		= request.getParameter("encounter_id");
		String patient_class	= request.getParameter("patient_class");
		String act_patient_class= request.getParameter("patient_class");
		if(encounter_id==null || encounter_id.equals("") || encounter_id.equals("null"))  // if condition is added for  ML-MMOH-CRF-0343 [IN:057182]
			act_patient_class = "XT";
		if(patient_class.equals("DC")) 
			patient_class="IP";
		if(!patient_class.equals("IP")) 
			patient_class="OP";

		String location_type	= request.getParameter("location_type");
		String location_code	= request.getParameter("location_code");
		String bean_id					= "@PrescriptionBean_1"+patient_id+encounter_id;
		String mode						= CommonRepository.getCommonKeyValue( "MODE_MODIFY" );
		String bean_name				= "ePH.PrescriptionBean_1";
		PrescriptionBean_1 bean			= (PrescriptionBean_1)getBeanObject( bean_id,bean_name,request);
		bean.setLanguageId(locale);
		bean.setActPatientClass_frm_Hdr(act_patient_class); // RUT-CRF-0062 - 32086 Added to get Build MAR Rule 
		bean.setEncounterId(encounter_id); //MMS-KH-CRF-0029
		int adr_count =(int)bean.getADRCount(patient_id,"%");
		String presBean_id			= "PrescriptionBean"+patient_id+encounter_id;
		String presBean_name		= "ePH.PrescriptionBean";
		PrescriptionBean presBean		= (PrescriptionBean)getBeanObject(presBean_id, presBean_name, request );
		presBean.setLanguageId(locale);
		boolean default_dose_type_yn = presBean.isSiteSpecific("OR", "OR_ORDER_SET"); // Added for ML-MMOH-CRF-1004
		String bl_disp_charge_dtl_in_rx_yn	= "";
		String bl_install_yn				= (String) session.getValue( "bl_operational" )==null?"N":(String) session.getValue( "bl_operational" ) ;
		String dc_mar_appl_yn				= "";
		String em_mar_appl_yn				= "";
		String ip_mar_appl_yn				= "";
		String op_mar_appl_yn				= "";
		String disch_med_mar_appl_yn		= "";
		String max_durn_for_ip_pres			= "";
		String chk_for_ip_max_durn_action	= "";
		String max_durn_for_op_pres			= "";
		String chk_for_op_max_durn_action	= "";
		String max_durn_for_dm_pres			= "";//added for ML-MMOH-SCF-0498 --chithra	
		String chk_for_dm_max_durn_action	= "";//added for ML-MMOH-SCF-0498	
		String trade_display_yn				= "";
		String narcotic_aprvl_form_req_yn	= "";
		String print_narcotic_form_by_default = "";
		String mandatory_rem_on_prn_freq_yn = "";
		String max_length_prn_reason		= "";
		String rx_qty_by_pres_base_uom_yn	= "";
		String atc_allergy_alert_level	= "";
		String drug_interaction_check_yn	= "";
		String  print_mar_label_yn="";//added for crf Bru-HIMS-CRF-093[29960]
		String diag_for_medn_order_by="P"; //MMS-SCF-0325 [IN:048069]
		String preview_rx_yn ="";//added for ML-MMOH-CRF-0341 [IN:057179]
		String drug_indication_mdry="";//added for jd-crf-0220
				ArrayList param_vals				= bean.getParameterValues();
		if(param_vals!=null && param_vals.size()!=0) {
			if(bl_install_yn!=null && bl_install_yn.equals("Y")){
				bl_disp_charge_dtl_in_rx_yn =	(String)param_vals.get(2);
			}
			dc_mar_appl_yn =	(String)param_vals.get(5);
			em_mar_appl_yn =	(String)param_vals.get(6);
			ip_mar_appl_yn =	(String)param_vals.get(7);
			op_mar_appl_yn =	(String)param_vals.get(8);
			disch_med_mar_appl_yn =	(String)param_vals.get(9);
			narcotic_aprvl_form_req_yn		=	(String)param_vals.get(12);
			print_narcotic_form_by_default	=	(String)param_vals.get(13);
			//mandatory_rem_on_prn_freq_yn =(String)param_vals.get(14);
			rx_qty_by_pres_base_uom_yn		=   (String)param_vals.get(14);
			atc_allergy_alert_level			=   (String)param_vals.get(15);
			print_mar_label_yn			=   (String)param_vals.get(17); //added for MMS-QH-CRF-0080 [IN:038064]			
			max_length_prn_reason			=   (String)param_vals.get(18);// incresing get value +1 for CRF MMS-QH-CRF-0068 [IN:037980]-start

			/*max_durn_for_ip_pres =	(String)param_vals.get(12);
			chk_for_ip_max_durn_action =	(String)param_vals.get(13);
			max_durn_for_op_pres =	(String)param_vals.get(14);
			chk_for_op_max_durn_action =	(String)param_vals.get(15);
			trade_display_yn =	(String)param_vals.get(18);*/
			max_durn_for_ip_pres =	(String)param_vals.get(25);//added for ML-MMOH-SCF-0498			
			diag_for_medn_order_by=(String)param_vals.get(20);//20 //MMS-SCF-0325 [IN:048069]
			preview_rx_yn		=	(String)param_vals.get(22);//22//added for ML-MMOH-CRF-0341 [IN:057179]

			chk_for_ip_max_durn_action =	(String)param_vals.get(26);
			max_durn_for_op_pres =	(String)param_vals.get(27);
			chk_for_op_max_durn_action =	(String)param_vals.get(28);//added for ML-MMOH-SCF-0498	
			max_durn_for_dm_pres=(String)param_vals.get(29);
			chk_for_dm_max_durn_action=(String)param_vals.get(30);//end
			trade_display_yn =	(String)param_vals.get(31);
			drug_interaction_check_yn =	(String)param_vals.get(32);
			drug_indication_mdry=bean.getDrugIndicationMdry();//added for jd-crf-0220
			System.out.println("drug_indication_mdry prescriptionheader_2"+drug_indication_mdry);
	
			// incresed get value by one for CRF MMS-QH-CRF-0068 [IN:037980]-end
		}
		String or_bean_name				= "eOR.OrderEntryBean";
		String or_bean_id						= "@orderentrybean"+patient_id+encounter_id;
		OrderEntryBean orbean			= (OrderEntryBean)getBeanObject( or_bean_id, or_bean_name,request ) ;
		orbean.setLanguageId(locale);
		
		String iv_bean_id			= "@IVPrescriptionBean"+patient_id+encounter_id;
		String iv_bean_name			= "ePH.IVPrescriptionBean";
		IVPrescriptionBean iv_bean	= (IVPrescriptionBean)getBeanObject( iv_bean_id,iv_bean_name,request) ;
		iv_bean.setLanguageId(locale);
		iv_bean.setIVCalcInfuseBy(bean.getIVCalcInfuseBy()); //Added for MMS-QH-CRF-0080 [IN:038064]
		String called_from		=	orbean.getCalledFromFunction(); //Added for Bru-HIMS-CRF-400 [IN:044502] start
		String order_id ="";
		if(called_from.equals("RENEW_ORDER")){
			StringBuilder sbRenewOrderIds = new StringBuilder();
			HashMap hmRenewOrders = orbean.getRenewOrderIds();
			if(hmRenewOrders!=null && hmRenewOrders.size()>0){
				List renewDrugList = new ArrayList(hmRenewOrders.keySet());
				for(int i=0; i<renewDrugList.size(); i++){
					if(i == (renewDrugList.size()-1))
						sbRenewOrderIds.append( (String)hmRenewOrders.get((String)renewDrugList.get(i)));
					else
						sbRenewOrderIds.append( (String)hmRenewOrders.get((String)renewDrugList.get(i))+"' , '");
				}
			}
			order_id = sbRenewOrderIds.toString();
		}
		else //Bru-HIMS-CRF-400 [IN:044502] -end
			order_id			= (String) orbean.getOrderId();
		String order_line_num	= (String) orbean.getOrderLineNo();
		String attend_pract_id	= (String) orbean.getAttendPractitionerId();
		String pract_id			= (String) orbean.getPractitionerId();
		String servide_code		= (String) orbean.getServiceCode();
		String resp_id			= (String) orbean.getResponsibilityId();

		String height_unit		= "";
		String weight_unit		= "";	
		String priority			= "";
		String or_date_time		= "";
		String practioner		= "";	
		String take_home_medi	= "";
		String priority_code = "";
		String diag_text		= "";
		String height			= "";
		String weight			= "";
		String bsa				= "";
		String take_home_chk	= "";
		String schedule_yn		= "";
		String bmi              = "";
		String home_leave_med   ="";
		String home_leave_chk   ="", home_leave_yn_val="",leave_fm =null,leave_to=null;
		int homeleave_rec =0;//added for crf Bru-HIMS-CRF-093[29960]
		String excludeADRAllergyAlert_yn = bean.getExcludeADRAllergyAlert();//Added for HSA-SCF-0011 [IN:042444]
		if(patient_class.equals("IP")){			//if block added  for Bru-HIMS-CRF-093 [IN:029960]
			homeleave_rec=(int)presBean.getHomeLeaveYn(encounter_id,facility_id);
		}
		HashMap homeleave_vals	=	presBean.getHomeLeaveDates(encounter_id,facility_id);//Added for Bru-HIMS-CRF-093-DD1[IN047223]--start
		ArrayList takeHomeDates = new ArrayList();
		if(homeleave_vals.size()>0){
			leave_fm = (String)homeleave_vals.get("LEAVE_FR_DATE");
			leave_to = (String)homeleave_vals.get("LEAVE_TO_DATE");
			takeHomeDates.add(leave_fm);
			takeHomeDates.add(leave_to);
			bean.setTakeHomeDates(takeHomeDates);//Added for Bru-HIMS-CRF-093-DD1[IN047223]--end
		}
		int administered_yn     =0;
		HashMap drugDetails		= null;

		if(patient_class.equals("IP") && !order_line_num.equals("")) {
			order_line_num	=	"1";
		}
		bean.setPatientClass(patient_class);
		bean.setamendOrderID(order_id);
		ArrayList drugData		= new ArrayList();
		
		if(iv_prep_yn.equals("7")|| iv_prep_yn.equals("8")){
			drugData	=  bean.loadAmendDetailsForTPN(order_id,patient_id,order_line_num,called_from);
		}
		else if(iv_prep_yn.equals("1")|| iv_prep_yn.equals("2") || iv_prep_yn.equals("3")|| iv_prep_yn.equals("4") || iv_prep_yn.equals("5")){
			drugData   =  iv_bean.loadAmendDetails(order_id,patient_id,act_patient_class);  // RUT-CRF-0062 Added actual patient class to get the Build MAR Rule
		}
		else {
			drugData   = bean.loadAmendDetails(order_id,patient_id,order_line_num,called_from,resp_id); 
		}
		int medication_rec=(int)bean.getHomeMecdicationYn(encounter_id,facility_id);
		if(bl_install_yn.equals("Y"))
            presBean.getDecimalFormatString();

		bean.savePresRemarks(bean.getAmendRemarks(order_id));
		iv_bean.setAmendRemarks(iv_bean.getAmendRemarks(order_id));
		String order_remarks	=	bean.getAmendRemarks(order_id);
		String allergic_yn		=	"";
		String problem_ind="";
		String oncology_bean_id				= "@OncologyRegimenBean"+patient_id+encounter_id;
		String oncology_bean_name			= "ePH.OncologyRegimenBean";
		OncologyRegimenBean oncology_bean	= (OncologyRegimenBean)getBeanObject( oncology_bean_id, oncology_bean_name, request );
		oncology_bean.setLanguageId(locale);
		HashMap	regimenValues				= (HashMap)oncology_bean.getRegimenValues(servide_code);
		if(regimenValues!=null){
			 problem_ind					=	(String)regimenValues.get("problem_ind");
		}
		if(iv_prep_yn.equals("9")  || iv_prep_yn.equals("0")){
			HashMap CYTOHeaderDetails = oncology_bean.getExistingCYTOOrderDetails(order_id);
			priority		= (String) CYTOHeaderDetails.get("PRIORITY");
			or_date_time	= (String) CYTOHeaderDetails.get("ORD_DATE_TIME");
			practioner		= (String) CYTOHeaderDetails.get("PRACTITIONER_NAME");
			height			= (String) CYTOHeaderDetails.get("HEIGHT");
			weight			= (String) CYTOHeaderDetails.get("WEIGHT");
			bsa				= (String) CYTOHeaderDetails.get("BSA");
			diag_text		= (String) CYTOHeaderDetails.get("DIAG_TEXT");
			schedule_yn		= (String) CYTOHeaderDetails.get("SCHEDULED_YN");
			take_home_medi	= (String) CYTOHeaderDetails.get("TAKE_HOME");
			height_unit		= (String) CYTOHeaderDetails.get("HEIGHT_UOM");
			weight_unit		= (String) CYTOHeaderDetails.get("WEIGHT_UOM");
		}
		int num =0;
		   num=  bean.loadallergydetail(patient_id);
		
		if(num>0){
			allergic_yn="YES";
		}
		else{
			allergic_yn="NO";
		}
		//check for recorded diagnosis
		int diag_size = 0;
		ArrayList diagnosis	=	bean.checkDiagnosis(patient_id, encounter_id, diag_for_medn_order_by);			
		if(diagnosis != null){
			diag_size	=	(diagnosis).size();
		}

		if(drugData!= null && drugData.size()>0){
			for(int i=0;i<drugData.size();i++){
				drugDetails		= (HashMap)drugData.get(i);
				priority		= (String) drugDetails.get("PRIORITY");
				or_date_time	= (String) drugDetails.get("ORD_DATE_TIME");
				practioner		= (String) drugDetails.get("PRACTITIONER_NAME");
				height			= (String) drugDetails.get("HEIGHT");
				weight			= (String) drugDetails.get("WEIGHT");
				bsa				= (String) drugDetails.get("BSA");
				if(!bsa.equals("") && default_dose_type_yn){ // Added for ML-MMOH-CRF-1004 - Start
					bsa = BigDecimal.valueOf(Double.valueOf(bsa)).setScale(2, BigDecimal.ROUND_UP).toString();
				} // Added for ML-MMOH-CRF-1004 - End
				diag_text		= (String) drugDetails.get("DIAG_TEXT");
				schedule_yn		= (String) drugDetails.get("SCHEDULED_YN");
				take_home_medi	= (String) drugDetails.get("TAKE_HOME");
				height_unit		= (String) drugDetails.get("HEIGHT_UOM");
				weight_unit		= (String) drugDetails.get("WEIGHT_UOM");
				mandatory_rem_on_prn_freq_yn = (String) drugDetails.get("MANDATORY_REM_ON_PRN_FREQ_YN");
				home_leave_med = drugDetails.get("HOME_LEAVE")==null?"":(String) drugDetails.get("HOME_LEAVE"); //added for Bru-HIMS-CRF-093
			}	
		}
			if(homeleave_rec>0 ||  home_leave_med.equals("Y")){//added for Bru-HIMS-CRF-093 -start
				home_leave_yn_val	= "Y";
			}
			else{
				home_leave_yn_val	= "N"; 
			}
			home_leave_chk="";
			if( home_leave_med.equals("Y")){
				home_leave_chk="checked";
			} //added for Bru-HIMS-CRF-093 -end

			if(height_unit==null)
				height_unit= com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Cms.label", "ph_labels");
			if(weight_unit==null)
				weight_unit= com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Kgs.label", "common_labels");
			if(!height.equals("") && !weight.equals("")) {
				bmi=(Float.parseFloat(weight)/((Float.parseFloat(height)/100)*(Float.parseFloat(height)/100)))+"";	
				int index	=	bmi.indexOf(".");
		
				if(bmi.length()>=(index+3) ) {
					bmi	=(bmi.substring(0,index+3));
				}	
			}
			if(bmi.equals("0.0")) bmi= "";
			if(take_home_medi!=null && ( take_home_medi.equals("Y") || take_home_medi.equals("D")) ){
				take_home_chk="checked";
			}
			else{
				take_home_chk="";
			}

            _bw.write(_wl_block9Bytes, _wl_block9);

			if(called_from.equals("RENEW_ORDER")) {
				mode						= CommonRepository.getCommonKeyValue( "MODE_INSERT" );
				or_date_time				=DateUtils.getCurrentDate("DMYHM",locale);
				bean.setCalledFrom(called_from);
				iv_bean.setOrderDate(or_date_time);
			}
			else if(called_from.equals("AMEND_ORDER")) {
				mode						= CommonRepository.getCommonKeyValue( "MODE_MODIFY" );
				bean.setCalledFrom(called_from);	
				 administered_yn =iv_bean.administered_yn(order_id,encounter_id);
				 if(!iv_prep_yn.equals("")){
					 if(!locale.equals("en"))
						 if(!iv_prep_yn.equals("9")  && !iv_prep_yn.equals("0")){
						    or_date_time = DateUtils.convertDate(or_date_time, "DMYHM","en",locale);
					     }
				 }
			}
			//getting the External Drug Interface Controls 
			String param_bean_id					= "@DrugInterfaceControlBean"+patient_id;
			String param_bean_name				= "ePH.DrugInterfaceControlBean";
			DrugInterfaceControlBean param_bean			= (DrugInterfaceControlBean)getBeanObject( param_bean_id, param_bean_name, request );
			String drug_db_interface_yn			=	param_bean.getDrugDBInterface_yn(facility_id);    
			String drug_db_product_id			=	param_bean.getDrugDBProductID(facility_id);    
			String drug_db_dosecheck_yn			=	param_bean.getDrugDBDosecheck_yn(facility_id);    
			String drug_db_duptherapy_yn		=	param_bean.getDrugDBDuptherapy_yn(facility_id);
			String drug_db_interact_check_yn	=	param_bean.getDrugDBInteract_check_yn(facility_id);  
			String drug_db_contraind_check_yn	=	param_bean.getDrugDBContraind_check_yn(facility_id);
			String drug_db_allergy_check_yn		=	param_bean.getDrugDBAllergy_check_yn(facility_id);   
			param_bean.clear();

			if(priority.equalsIgnoreCase("Routine")){
				priority=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
				priority_code = "R";
			}
			else if(priority.equalsIgnoreCase("Urgent")){
				priority=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");
				priority_code = "U";
			}

            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(height));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(height_unit));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(weight));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(weight_unit));
            _bw.write(_wl_block14Bytes, _wl_block14);
if(default_dose_type_yn){ // if else condition Added for ML-MMOH-CRF-1004 -Start 
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(bsa));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(bmi));
            _bw.write(_wl_block18Bytes, _wl_block18);
} else{
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(bsa));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(bmi));
            _bw.write(_wl_block21Bytes, _wl_block21);
} // if else condition Added for ML-MMOH-CRF-1004 -End 
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(priority));
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(or_date_time));
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(practioner));
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(take_home_medi));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(take_home_chk));
            _bw.write(_wl_block31Bytes, _wl_block31);
                          
							if(home_leave_yn_val.equals("Y")){ //added for crf Bru-HIMS-CRF-093[29960] -start

            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(home_leave_chk));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(leave_fm));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(leave_to));
            _bw.write(_wl_block36Bytes, _wl_block36);

							}//added for crf Bru-HIMS-CRF-093[29960] -end

            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(allergic_yn));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
                     
							if(adr_count >0){
 
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
                     
							}

            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);

							String pregn_bean_id = "PregnancyCategory" ;
							String pregn_bean_name = "ePH.PregnancyCategoryBean";
							PregnancyCategoryBean pregn_bean = (PregnancyCategoryBean)getBeanObject( pregn_bean_id, pregn_bean_name, request ) ;
							HashMap maternityMap= pregn_bean.getPregnancyRemarks(patient_id);
							String lmpValue = maternityMap.get("LMP").toString();
							String gestationValue = maternityMap.get("GESTATION").toString();
							String eddValue = maternityMap.get("EDD").toString();
							String asOnDateValue = maternityMap.get("ASONDATE").toString();
							if (!((lmpValue.equals(""))&&(gestationValue.equals(""))&&(eddValue.equals("")))){

            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(lmpValue));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(gestationValue));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(eddValue));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(asOnDateValue));
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);

							}

            _bw.write(_wl_block50Bytes, _wl_block50);

							if(diag_text!=null && !(diag_text.equals(""))){

            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(diag_text));
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);
	
							}
							else{	

            _bw.write(_wl_block54Bytes, _wl_block54);

							}

            _bw.write(_wl_block55Bytes, _wl_block55);

	//This part is commented and new variable priority_code is introduced to store the priority in hidden variable
	// IN24413 --14/10/2010-- priya
			/*		if(priority.startsWith("R") || priority.startsWith("r")) { 
						priority	=	"R";
					}
					else  if(priority.startsWith("U") || priority.startsWith("u")) {
						priority	=	"U";
					} */


            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(presBean_id));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(presBean_name ));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf( bean_name ));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf( priority_code ));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf( or_date_time ));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf( patient_class ));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(act_patient_class));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(location_type));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(location_code));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(location_type));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(location_code));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(order_remarks));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(schedule_yn));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(or_date_time));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(attend_pract_id));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(pract_id));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(practioner));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(resp_id));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(allergic_yn));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(height));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(height));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(height_unit));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(weight));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(weight));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(weight_unit));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(bsa));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(bmi));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(administered_yn));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(problem_ind));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(diag_size));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(take_home_medi));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(drug_db_interface_yn));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(drug_db_product_id));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(drug_db_dosecheck_yn));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(drug_db_duptherapy_yn));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(drug_db_interact_check_yn));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(drug_db_contraind_check_yn));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(drug_db_allergy_check_yn));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(adr_count));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(narcotic_aprvl_form_req_yn));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(print_narcotic_form_by_default));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(bl_disp_charge_dtl_in_rx_yn));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(bl_install_yn));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(dc_mar_appl_yn));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(em_mar_appl_yn));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(ip_mar_appl_yn));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(op_mar_appl_yn));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(disch_med_mar_appl_yn));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(max_durn_for_ip_pres));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(chk_for_ip_max_durn_action));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(max_durn_for_op_pres));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(chk_for_op_max_durn_action));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(max_durn_for_dm_pres));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(chk_for_dm_max_durn_action));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(trade_display_yn));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(mandatory_rem_on_prn_freq_yn));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(max_length_prn_reason));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(rx_qty_by_pres_base_uom_yn));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(atc_allergy_alert_level));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(drug_interaction_check_yn));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(print_mar_label_yn));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(excludeADRAllergyAlert_yn));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(preview_rx_yn));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(drug_indication_mdry));
            _bw.write(_wl_block129Bytes, _wl_block129);

		if(iv_prep_yn.equals("1") || iv_prep_yn.equals("2") || iv_prep_yn.equals("3") || iv_prep_yn.equals("4") || iv_prep_yn.equals("5") || iv_prep_yn.equals("6") || iv_prep_yn.equals("7") || iv_prep_yn.equals("8") ||iv_prep_yn.equals("9")  || iv_prep_yn.equals("0")){

            _bw.write(_wl_block130Bytes, _wl_block130);

		}
		else{

            _bw.write(_wl_block131Bytes, _wl_block131);

		}
		putObjectInBean(bean_id,bean,request);
		putObjectInBean(oncology_bean_id,oncology_bean,request);
		putObjectInBean(iv_bean_id,iv_bean,request);
		putObjectInBean(or_bean_id,orbean,request);
		putObjectInBean(presBean_id,presBean,request);
	}
	catch(Exception e){
		e.printStackTrace();
	}
 
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.height.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.weight.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BSA.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BMI.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BSA.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BMI.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Date/Time.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DischargeRx.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.HomeLeaveMedication.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.KnownCaseofAllergy.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ClinicalComments.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.diagnosis.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PregnancyRemarks.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DiagnosisText.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
