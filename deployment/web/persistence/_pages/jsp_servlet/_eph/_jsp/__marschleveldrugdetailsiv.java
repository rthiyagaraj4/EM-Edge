package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.lang.*;
import java.text.DecimalFormat;
import ePH.*;
import ePH.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __marschleveldrugdetailsiv extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/MARSchLevelDrugDetailsIV.jsp", 1709120922540L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="  \n<html>  \n\t <head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/PhCommon.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../ePH/js/MedicationAdministrationFixedTime.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../ePH/js/MedicationAdministration.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/DispMedicationAllStages.js\"></script>\n\t\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t\t<script type=\"text/javascript\" src=\"../../ePH/js/DrugDetailsDisplay.js\"></script>\n\t\t<script type=\"text/javascript\" src=\"../../eCommon/js/dchk.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../ePH/js/PPNRegimen.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\t<body  onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\n\t\t<img id=\"ball\" src=\"/images/ball.png\" style=\"visibility:hidden;\" height=\"5\"/>\n\t\t<div id=\"IVHeaderDiv\" >  \n\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"1\" id=\"iv_administration_table\" >\n\t\t\t\t<tr id=\"IVHeader\" >\n\t\t\t\t\t<td class=\"TDSTYLE\" width=\"16%\" colspan=\'2\' nowrap>\n\t\t\t\t\t\t<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\"  >\n\t\t\t\t\t\t\t<tr style=\'height:18px;\'>\n\t\t\t\t\t\t\t\t<td class=\"TDSTYLE\" width=\"16%\" colspan=\'2\' nowrap>\n\t\t\t\t\t\t\t\t\t<B>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</B>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<tr style=\'height:18px;\'>\n\t\t\t\t\t\t\t\t<td class=\"TDSTYLE\" width=\"8%\" style=\'text-align:center;\'><B>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</B></td>\n\t\t\t\t\t\t\t\t<td class=\"TDSTYLE\" width=\"8%\" style=\'text-align:center;\'><B>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</B></td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\"TDSTYLE\" width=\"20%\" ><B>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</B></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t<td class=\"TDSTYLE\" width=\"8%\" nowrap><B>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t<td class=\"TDSTYLE\" width=\"8%\" wrap><B>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="/";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</B></td>\n\t\t\t\t\t<td class=\"TDSTYLE\" width=\"8%\" nowrap><B>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</B></td>\n\t\t\t\t\t<td class=\"TDSTYLE\" width=\"7%\" nowrap><B>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</B></td>\n\t\t\t\t\t<td class=\"TDSTYLE\" width=\"6%\" ><B>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</B></td>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t\t<td class=\"TDSTYLE\" width=\"5%\">\n\t\t\t\t\t\t\t\t<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\"  >\n\t\t\t\t\t\t\t\t\t<tr style=\'height:18px;\'>\n\t\t\t\t\t\t\t\t\t\t<td class=\"TDSTYLE\" width=\"5%\"><B>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</B></td> <!-- convertDate Added for SRR - SRR20056-SCF-9369 [IN057079] -->\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t<tr style=\'height:18px;\'>\n\t\t\t\t\t\t\t\t\t\t<td class=\"TDSTYLE\" width=\"5%\" style=\'text-align:center;\'><B>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</B></td>\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\n\t\t\t\t\t<td class=\'COLUMNHEADER\' colspan=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\"  style=\"font-size:10\"><b>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</b></td>\n\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' width=\'7%\' style=\"font-size:9;text-align:center;\" nowrap rowspan=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td>\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" width=\'19%\' style=\"word-wrap:break-word;font-size:9;";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\"  >\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t\t\t\t<label style=\'color:red;font-size:12;FONT-WEIGHT: BOLDER;cursor:pointer;\' onclick=\"loadPage(\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\');\" id=\"drug_mast_det_";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="_";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">&nbsp;+&nbsp;</label>\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t\t\t<label style=\"font-size:9;font-weight:bold;color:black\" title=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =" &nbsp;&nbsp;\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/info.gif\" align=\"center\"  width=\"17\" height=\"17\" style=\"cursor:pointer;\" onClick=\"showDrugInfo(\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\',\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\')\" title=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\"></img>\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t\t\t\t<img src=\'../../ePH/images/camera.gif\' width=\'17\' height=\'15\' onclick = \"showImage(\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\');\" onmouseover=\"changeCursor(this);\">\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\t\t\t<img  id=\"ADR_img\" src=\'../../ePH/images/ADR.gif\'  title=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' onclick = \"callADRdetails(\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\');\"></img>\n";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t\t\t\t\t<img src=\'../../ePH/images/DrugInfo.gif\' width=\'17\' height=\'15\' onclick = \"showDrug(\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t\t\t</label>\t\t\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\t\t\t\t\t<br> <label id=\'iv_link_vaccine_label_";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' style=\"font-size:10;\" title=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'> ";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 =" <input type=\'text\' size=10 name=\'iv_link_vaccine_desc_";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\' id=\'iv_link_vaccine_desc_";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' value=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' disabled><input type=\'button\'  class=\'button\' value=\'?\' name=\'iv_btn_link_vaccine_";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' id=\'iv_btn_link_vaccine_";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\' onClick=\"linkVaccine(\'iv\',\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\', \'SCH\')\"></label>\n";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t\t\t\t\t\t<br><label style=\"font-size:9;color:green\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 =" </label>\n\t\t\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t\t\t\t\t\t<br>\n\t\t\t\t\t\t\t\t<label>";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="&nbsp;=&nbsp;";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="&nbsp;";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t\t\t\t\t</label>\n";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\' width=\'7%\' style=\"font-size:9;word-wrap:break-word;\" wrap>\n\t\t\t\t\t\t<img src=\"../../ePH/images/DrugRemarks.gif\" align=\"center\" style=\"cursor:pointer;\" onClick=\"displayInstructions(\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\',\'N\')\" title=";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 =" ";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="></img><!--modified for MMS-KH-SCF-0064 -->\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\' width=\'7%\' style=\"font-size:9;word-wrap:break-word;\" wrap>";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="&nbsp;\n";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\' width=\'7%\' rowspan=\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\' style=\'word-wrap:break-word;\'>\n\t\t\t\t\t\t\t\t<label style=\"color:";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 =";background-color:";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 =";font-size:9;text-align:center;\">";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="</label>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\' width=\'7%\' style=\"word-wrap:break-word;font-size:9;text-align:center;\" rowspan=\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="&nbsp;</td>\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\' width=\'5%\'  style=\"font-size:9;word-wrap:break-word;\" rowspan=\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\'>&nbsp;</td>\n";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t<tr>\n";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\"  rowspan=\'";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\'>\n";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t\t\t\t\t\t\t\t\t<label style=\'color:red;font-size:12;FONT-WEIGHT: BOLDER;cursor:pointer;\' onclick=\"loadPage(\'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n\t\t\t\t\t\t\t\t<label style=\"font-size:9;font-weight:bold;color:black\" title=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/info.gif\" align=\"center\"  width=\"17\" height=\"17\" style=\"cursor:pointer;\" onClick=\"showDrugInfo(\'";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\t\t\t\t\t\t\t\t\t<img src=\'../../ePH/images/camera.gif\' width=\'17\' height=\'15\' onclick = \"showImage(\'";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n\t\t\t\t\t\t\t\t\t<img  id=\"ADR_img\" src=\'../../ePH/images/ADR.gif\'  title=\'";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n\t\t\t\t\t\t\t\t</label>\t\t\n\t\t\t\t\t\t\t\t<br>\n\t\t\t\t\t\t\t\t<label>";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t\t\t\t\t\t\t\t</label>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\' width=\'7%\' style=\"word-wrap:break-word;font-size:9;\" wrap rowspan=\'";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\' width=\'5%\'  style=\"word-wrap:break-word;font-size:9;\" rowspan=\'";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\t\t\t\t\t\t\t\t\t\t<label style=\'color:red;font-size:12;FONT-WEIGHT: BOLDER;cursor:pointer;\' onclick=\"loadPage(\'";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\t\t\t\t\t\t\t\t\t<label style=\"font-size:9;font-weight:bold;color:black\" title=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n\t\t\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/info.gif\" align=\"center\"  width=\"17\" height=\"17\" style=\"cursor:pointer;\" onClick=\"showDrugInfo(\'";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\n\t\t\t\t\t\t\t\t\t\t<img src=\'../../ePH/images/camera.gif\' width=\'17\' height=\'15\' onclick = \"showImage(\'";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\n\t\t\t\t\t\t\t\t\t\t<img  id=\"ADR_img\" src=\'../../ePH/images/ADR.gif\'  title=\'";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\n\t\t\t\t\t\t\t\t\t\t<img src=\'../../ePH/images/DrugInfo.gif\' width=\'17\' height=\'15\' onclick = \"showDrug(\'";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\n\t\t\t\t\t\t\t\t\t\t<br><label style=\"font-size:9;color:green\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 =" </label>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n\t\t\t\t\t\t\t\t\t</label>\t\t\n\t\t\t\t\t\t\t\t\t<br>\n\t\t\t\t\t\t\t\t\t<label>";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\n\t\t\t\t\t\t\t\t\t</label>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="<!-- if condtion added for  MMS-KH-CRF-0010 -->\n\t\t\t\t\t\t\t\t\t<td   class=\"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\" rowspan=\'";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\' >\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t<img src=\"../../ePH/images/DrugRemarks.gif\" align=\"center\" style=\"cursor:pointer;\" onClick=\"displayInstructions(\'";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\',\'2\',\'";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 =" /> <!--modified for MMS-KH-SCF-0064 -->\n\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\n\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\' width=\'7%\' style=\"font-size:9;word-wrap:break-word;\" wrap rowspan=\'";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="</td>\n\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\' style=\'word-wrap:break-word;\' >\n\t\t\t\t\t\t\t\t\t<label style=\"color:";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="</label>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="&nbsp;</td>\n";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\' width=\'5%\'  style=\"font-size:9;word-wrap:break-word;\" >&nbsp;</td>\n";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\n\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t<tr>\n";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\' width=\'5%\' style=\"font-size:9;word-wrap:break-word;\" rowspan=\'";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\' width=\'5%\'  style=\"word-wrap:break-word;text-align:center;font-size:9;\"  rowspan=\'";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\'>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"order";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\" style=\'vertical-align:middle;";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\' title=\'";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<!--cancelYn,admin_by_name,drug_desc,scheKey added for JD-CRF-0200 -->\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label style=\'vertical-align:middle;";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 =";\' onClick=\"alert(\'click\');openAuditLogWindowIV(\'";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\',\'SFR\',\'SCH\',\'";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\', \'";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\',\'\',\'\');\">";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="</b></label><!--modified for MMS-KH-SCF-0064 --><!-- Modified for IN073378 -->\n";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label style=\"vertical-align:middle;cursor:pointer;";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\" onClick=\"\">";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="</label>\n";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label style=\"vertical-align:middle;cursor:pointer;";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\" onClick=\"dispAdminOptions(\'";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\',\'IV\',\'";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\',,\'\',\'\',\'\',\'\',\'";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\');\">";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="</label><!--modified for MMS-KH-SCF-0064 -->\n";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="<!--ADDED FOR JD-CRF-0200 -->\n\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/history1.jpg\" align=\"center\"  width=\"17\" height=\"17\"  title=\"Cancel History\" onclick=\"cancelHistory(\'";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\')\"></img><!--modified for MMS-KH-SCF-0064 -->\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\'>&nbsp;\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"order";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\'><label style=\'vertical-align:middle;";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 =";";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="</label></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\'>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"order";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label style=\'vertical-align:middle;";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 =";\' onClick=\"openAuditLogWindowIV(\'";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label style=\"vertical-align:middle;";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\"><B>";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="</B>";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label style=\"vertical-align:middle;";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\');\"><B>";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="<!--ADDED FOR JD-CRF-0200 -->\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/history1.jpg\" align=\"center\"  width=\"17\" height=\"17\"  title=\"Cancel History\" onclick=\"cancelHistory(\'";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\')\"></img> <!--modified for MMS-KH-SCF-0064 -->\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\n\t\t  \t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"h_iv_admin_qty_";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\" id=\"h_iv_admin_qty_";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\" value=\"";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_admin_chng_dtls_req_";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\" id=\"iv_admin_chng_dtls_req_";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\" value=\"N\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_modified_date_time_";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\" id=\"iv_modified_date_time_";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\">\t\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_dosage_seq_no_";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\" id=\"iv_dosage_seq_no_";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_end_date_";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\" id=\"iv_end_date_";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"next_schd_date_";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\" id=\"next_schd_date_";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_dtls_yn";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\" id=\"iv_dtls_yn";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\" value=\"N\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_Remarks";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\" id=\"iv_Remarks";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\" value=\"N\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_qty_in_disp_mode_";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\" id=\"iv_qty_in_disp_mode_";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\" value=\"\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_admin_date_time_";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\" id=\"iv_admin_date_time_";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_infusion_st_time_";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\" id=\"iv_infusion_st_time_";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_flow_rate_";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\" id=\"iv_flow_rate_";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sch_infusion_vol_str_unit_";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\" id=\"sch_infusion_vol_str_unit_";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sch_infusion_vol_str_unit_desc";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\" id=\"sch_infusion_vol_str_unit_desc";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\"> \n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sch_infusion_per_unit_";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\" id=\"sch_infusion_per_unit_";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_infusion_period_";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\" id=\"iv_infusion_period_";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sch_infusion_period_unit_";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\" id=\"sch_infusion_period_unit_";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"previous_batch_id_";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\" id=\"previous_batch_id_";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"previous_exp_date_";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\" id=\"previous_exp_date_";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"previous_trade_id_";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\" id=\"previous_trade_id_";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\" value=\"\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_batch_id_";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\" id=\"iv_batch_id_";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_expiry_date_";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\" id=\"iv_expiry_date_";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\" value=\"expiry_date\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_trade_name_";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\" id=\"iv_trade_name_";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\" >\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_trade_id_";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\" id=\"iv_trade_id_";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_bin_code_";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\" id=\"iv_bin_code_";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\" value=\"\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\"IV_Newly_administerderd_";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\" id=\"IV_Newly_administerderd_";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\" value=\'IV_Y\'>\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_no_of_drug_per_order_";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\" id=\"iv_no_of_drug_per_order_";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sfrFLOW_STATUS";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\" id=\"sfrFLOW_STATUS";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sfrHOLD_DATE_TIME";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\" id=\"sfrHOLD_DATE_TIME";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sfrHOLD_DURN_IN_MINS";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\" id=\"sfrHOLD_DURN_IN_MINS";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"durn_bw_std_resumed_";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="\" id=\"durn_bw_std_resumed_";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\" value=\"\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"flow_rate_changed_YN";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="\" id=\"flow_rate_changed_YN";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="\" value=\"\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sfrRESUME_DATE_TIME";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\" id=\"sfrRESUME_DATE_TIME";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sfrACT_END_DATE_TIME";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="\" id=\"sfrACT_END_DATE_TIME";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"inf_prd_hrs";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="\" id=\"inf_prd_hrs";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="\" value=\"0\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"inf_prd_min";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="\" id=\"inf_prd_min";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="\" value=\"0\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_dosage_type_";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\" id=\"iv_dosage_type_";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"completedMinutes";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="\" id=\"completedMinutes";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"completedFlow";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="\" id=\"completedFlow";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_admin_qty_";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="\" id=\"iv_admin_qty_";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="\"> \n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_qty_uom_";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="\" id=\"iv_qty_uom_";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_sch_date_tim_";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="\" id=\"iv_sch_date_tim_";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="\"><!--Added for SKR-SCF-0913[Inc : 46556] -->\n\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_drug_code_";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="\" id=\"iv_drug_code_";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_item_code_";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 ="\" id=\"iv_item_code_";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_order_id_";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 ="\" id=\"iv_order_id_";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 ="\"  value=\"";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_order_line_no_";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 ="\" id=\"iv_order_line_no_";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 ="\">\t\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_drug_class";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 ="\" id=\"iv_drug_class";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\"iv_link_vaccine_code_";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );

    private final static java.lang.String  _wl_block267 ="\" id=\"iv_link_vaccine_code_";
    private final static byte[]  _wl_block267Bytes = _getBytes( _wl_block267 );

    private final static java.lang.String  _wl_block268 ="\" value=\'";
    private final static byte[]  _wl_block268Bytes = _getBytes( _wl_block268 );

    private final static java.lang.String  _wl_block269 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"h_iv_admin_qty_";
    private final static byte[]  _wl_block269Bytes = _getBytes( _wl_block269 );

    private final static java.lang.String  _wl_block270 ="\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t <td class=\"";
    private final static byte[]  _wl_block270Bytes = _getBytes( _wl_block270 );

    private final static java.lang.String  _wl_block271 ="\"id=\"MFR_status_column_";
    private final static byte[]  _wl_block271Bytes = _getBytes( _wl_block271 );

    private final static java.lang.String  _wl_block272 ="\'><div id=\"order";
    private final static byte[]  _wl_block272Bytes = _getBytes( _wl_block272 );

    private final static java.lang.String  _wl_block273 ="\" style=\'word-wrap:break-word;vertical-align:middle;";
    private final static byte[]  _wl_block273Bytes = _getBytes( _wl_block273 );

    private final static java.lang.String  _wl_block274 ="\'><label id=\"iv_MFR_dtls_";
    private final static byte[]  _wl_block274Bytes = _getBytes( _wl_block274 );

    private final static java.lang.String  _wl_block275 ="\" name=\"iv_MFR_dtls_";
    private final static byte[]  _wl_block275Bytes = _getBytes( _wl_block275 );

    private final static java.lang.String  _wl_block276 ="\" style=\"";
    private final static byte[]  _wl_block276Bytes = _getBytes( _wl_block276 );

    private final static java.lang.String  _wl_block277 ="\" onClick=\"\" id=\'mfrRemarksLink_";
    private final static byte[]  _wl_block277Bytes = _getBytes( _wl_block277 );

    private final static java.lang.String  _wl_block278 ="\'><font color=\"red\" size=\'1\'>";
    private final static byte[]  _wl_block278Bytes = _getBytes( _wl_block278 );

    private final static java.lang.String  _wl_block279 ="</font></a>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div></td>\n";
    private final static byte[]  _wl_block279Bytes = _getBytes( _wl_block279 );

    private final static java.lang.String  _wl_block280 ="                                                                                                                      <td class=\"";
    private final static byte[]  _wl_block280Bytes = _getBytes( _wl_block280 );

    private final static java.lang.String  _wl_block281 ="\',\'\',\'\',\'\',\'\',\'";
    private final static byte[]  _wl_block281Bytes = _getBytes( _wl_block281 );

    private final static java.lang.String  _wl_block282 ="<br>";
    private final static byte[]  _wl_block282Bytes = _getBytes( _wl_block282 );

    private final static java.lang.String  _wl_block283 ="</label><br><a href=\"#\"  onMouseOver=\"changeCursor(this);\" onClick=\"showMFRRemarks(\'";
    private final static byte[]  _wl_block283Bytes = _getBytes( _wl_block283 );

    private final static java.lang.String  _wl_block284 ="\',\'Y\');\" id=\'mfrRemarksLink_";
    private final static byte[]  _wl_block284Bytes = _getBytes( _wl_block284 );

    private final static java.lang.String  _wl_block285 ="</font></a>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div></td>\n";
    private final static byte[]  _wl_block285Bytes = _getBytes( _wl_block285 );

    private final static java.lang.String  _wl_block286 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block286Bytes = _getBytes( _wl_block286 );

    private final static java.lang.String  _wl_block287 ="\" style=\"font-size:9;color:black;align:center;\" onClick=\"\">";
    private final static byte[]  _wl_block287Bytes = _getBytes( _wl_block287 );

    private final static java.lang.String  _wl_block288 =" <br>";
    private final static byte[]  _wl_block288Bytes = _getBytes( _wl_block288 );

    private final static java.lang.String  _wl_block289 ="</font></a><div></td>\n";
    private final static byte[]  _wl_block289Bytes = _getBytes( _wl_block289 );

    private final static java.lang.String  _wl_block290 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"h_iv_admin_qty_";
    private final static byte[]  _wl_block290Bytes = _getBytes( _wl_block290 );

    private final static java.lang.String  _wl_block291 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_admin_chng_dtls_req_";
    private final static byte[]  _wl_block291Bytes = _getBytes( _wl_block291 );

    private final static java.lang.String  _wl_block292 ="\" value=\"N\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_modified_date_time_";
    private final static byte[]  _wl_block292Bytes = _getBytes( _wl_block292 );

    private final static java.lang.String  _wl_block293 ="\">\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_dosage_seq_no_";
    private final static byte[]  _wl_block293Bytes = _getBytes( _wl_block293 );

    private final static java.lang.String  _wl_block294 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_end_date_";
    private final static byte[]  _wl_block294Bytes = _getBytes( _wl_block294 );

    private final static java.lang.String  _wl_block295 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"next_schd_date_";
    private final static byte[]  _wl_block295Bytes = _getBytes( _wl_block295 );

    private final static java.lang.String  _wl_block296 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_dtls_yn";
    private final static byte[]  _wl_block296Bytes = _getBytes( _wl_block296 );

    private final static java.lang.String  _wl_block297 ="\" value=\"N\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_Remarks";
    private final static byte[]  _wl_block297Bytes = _getBytes( _wl_block297 );

    private final static java.lang.String  _wl_block298 ="\" value=\"N\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_qty_in_disp_mode_";
    private final static byte[]  _wl_block298Bytes = _getBytes( _wl_block298 );

    private final static java.lang.String  _wl_block299 ="\" value=\"\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_admin_date_time_";
    private final static byte[]  _wl_block299Bytes = _getBytes( _wl_block299 );

    private final static java.lang.String  _wl_block300 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_infusion_st_time_";
    private final static byte[]  _wl_block300Bytes = _getBytes( _wl_block300 );

    private final static java.lang.String  _wl_block301 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_flow_rate_";
    private final static byte[]  _wl_block301Bytes = _getBytes( _wl_block301 );

    private final static java.lang.String  _wl_block302 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sch_infusion_vol_str_unit_";
    private final static byte[]  _wl_block302Bytes = _getBytes( _wl_block302 );

    private final static java.lang.String  _wl_block303 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sch_infusion_vol_str_unit_desc";
    private final static byte[]  _wl_block303Bytes = _getBytes( _wl_block303 );

    private final static java.lang.String  _wl_block304 ="\"> \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sch_infusion_per_unit_";
    private final static byte[]  _wl_block304Bytes = _getBytes( _wl_block304 );

    private final static java.lang.String  _wl_block305 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_infusion_period_";
    private final static byte[]  _wl_block305Bytes = _getBytes( _wl_block305 );

    private final static java.lang.String  _wl_block306 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sch_infusion_period_unit_";
    private final static byte[]  _wl_block306Bytes = _getBytes( _wl_block306 );

    private final static java.lang.String  _wl_block307 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"previous_batch_id_";
    private final static byte[]  _wl_block307Bytes = _getBytes( _wl_block307 );

    private final static java.lang.String  _wl_block308 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"previous_exp_date_";
    private final static byte[]  _wl_block308Bytes = _getBytes( _wl_block308 );

    private final static java.lang.String  _wl_block309 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"previous_trade_id_";
    private final static byte[]  _wl_block309Bytes = _getBytes( _wl_block309 );

    private final static java.lang.String  _wl_block310 ="\" value=\"\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_batch_id_";
    private final static byte[]  _wl_block310Bytes = _getBytes( _wl_block310 );

    private final static java.lang.String  _wl_block311 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_expiry_date_";
    private final static byte[]  _wl_block311Bytes = _getBytes( _wl_block311 );

    private final static java.lang.String  _wl_block312 ="\" value=\"expiry_date\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_trade_name_";
    private final static byte[]  _wl_block312Bytes = _getBytes( _wl_block312 );

    private final static java.lang.String  _wl_block313 ="\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_trade_id_";
    private final static byte[]  _wl_block313Bytes = _getBytes( _wl_block313 );

    private final static java.lang.String  _wl_block314 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_bin_code_";
    private final static byte[]  _wl_block314Bytes = _getBytes( _wl_block314 );

    private final static java.lang.String  _wl_block315 ="\" value=\"\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\"IV_Newly_administerderd_";
    private final static byte[]  _wl_block315Bytes = _getBytes( _wl_block315 );

    private final static java.lang.String  _wl_block316 ="\" value=\'IV_Y\'>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_no_of_drug_per_order_";
    private final static byte[]  _wl_block316Bytes = _getBytes( _wl_block316 );

    private final static java.lang.String  _wl_block317 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sfrFLOW_STATUS";
    private final static byte[]  _wl_block317Bytes = _getBytes( _wl_block317 );

    private final static java.lang.String  _wl_block318 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sfrHOLD_DATE_TIME";
    private final static byte[]  _wl_block318Bytes = _getBytes( _wl_block318 );

    private final static java.lang.String  _wl_block319 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sfrHOLD_DURN_IN_MINS";
    private final static byte[]  _wl_block319Bytes = _getBytes( _wl_block319 );

    private final static java.lang.String  _wl_block320 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"durn_bw_std_resumed_";
    private final static byte[]  _wl_block320Bytes = _getBytes( _wl_block320 );

    private final static java.lang.String  _wl_block321 ="\" value=\"\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"flow_rate_changed_YN";
    private final static byte[]  _wl_block321Bytes = _getBytes( _wl_block321 );

    private final static java.lang.String  _wl_block322 ="\" value=\"\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sfrRESUME_DATE_TIME";
    private final static byte[]  _wl_block322Bytes = _getBytes( _wl_block322 );

    private final static java.lang.String  _wl_block323 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"MFR_end_date_time_";
    private final static byte[]  _wl_block323Bytes = _getBytes( _wl_block323 );

    private final static java.lang.String  _wl_block324 ="\" id=\"MFR_end_date_time_";
    private final static byte[]  _wl_block324Bytes = _getBytes( _wl_block324 );

    private final static java.lang.String  _wl_block325 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"inf_prd_hrs";
    private final static byte[]  _wl_block325Bytes = _getBytes( _wl_block325 );

    private final static java.lang.String  _wl_block326 ="\" value=\"0\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"inf_prd_min";
    private final static byte[]  _wl_block326Bytes = _getBytes( _wl_block326 );

    private final static java.lang.String  _wl_block327 ="\" value=\"0\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_dosage_type_";
    private final static byte[]  _wl_block327Bytes = _getBytes( _wl_block327 );

    private final static java.lang.String  _wl_block328 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"completedMinutes";
    private final static byte[]  _wl_block328Bytes = _getBytes( _wl_block328 );

    private final static java.lang.String  _wl_block329 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"completedFlow";
    private final static byte[]  _wl_block329Bytes = _getBytes( _wl_block329 );

    private final static java.lang.String  _wl_block330 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_admin_qty_";
    private final static byte[]  _wl_block330Bytes = _getBytes( _wl_block330 );

    private final static java.lang.String  _wl_block331 ="\"> \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_sch_date_tim_";
    private final static byte[]  _wl_block331Bytes = _getBytes( _wl_block331 );

    private final static java.lang.String  _wl_block332 ="\"><!--Added for SKR-SCF-0913[Inc : 46556] -->\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"totalNoOfRows";
    private final static byte[]  _wl_block332Bytes = _getBytes( _wl_block332 );

    private final static java.lang.String  _wl_block333 ="\" id=\"totalNoOfRows";
    private final static byte[]  _wl_block333Bytes = _getBytes( _wl_block333 );

    private final static java.lang.String  _wl_block334 ="\"><!--Added for SKR-SCF-0913[Inc : 46556] -->\n";
    private final static byte[]  _wl_block334Bytes = _getBytes( _wl_block334 );

    private final static java.lang.String  _wl_block335 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block335Bytes = _getBytes( _wl_block335 );

    private final static java.lang.String  _wl_block336 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block336Bytes = _getBytes( _wl_block336 );

    private final static java.lang.String  _wl_block337 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"order";
    private final static byte[]  _wl_block337Bytes = _getBytes( _wl_block337 );

    private final static java.lang.String  _wl_block338 ="\'>\t\n";
    private final static byte[]  _wl_block338Bytes = _getBytes( _wl_block338 );

    private final static java.lang.String  _wl_block339 ="                                                                        <!--cancelYn,admin_by_name,drug_desc,scheKey added for JD-CRF-0200 -->\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label style=\'vertical-align:middle;";
    private final static byte[]  _wl_block339Bytes = _getBytes( _wl_block339 );

    private final static java.lang.String  _wl_block340 =";\' title=\'";
    private final static byte[]  _wl_block340Bytes = _getBytes( _wl_block340 );

    private final static java.lang.String  _wl_block341 ="\' onClick=\"openAuditLogWindowIV(\'";
    private final static byte[]  _wl_block341Bytes = _getBytes( _wl_block341 );

    private final static java.lang.String  _wl_block342 ="\',\'\',\'\');\"><b><br>(";
    private final static byte[]  _wl_block342Bytes = _getBytes( _wl_block342 );

    private final static java.lang.String  _wl_block343 =")</b></label><!--modified for MMS-KH-SCF-0064 --><!-- Modified for IN073378 -->\n";
    private final static byte[]  _wl_block343Bytes = _getBytes( _wl_block343 );

    private final static java.lang.String  _wl_block344 ="\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  <label style=\'vertical-align:middle;";
    private final static byte[]  _wl_block344Bytes = _getBytes( _wl_block344 );

    private final static java.lang.String  _wl_block345 ="\' onClick=\"\"><B>";
    private final static byte[]  _wl_block345Bytes = _getBytes( _wl_block345 );

    private final static java.lang.String  _wl_block346 ="</B></label>\n";
    private final static byte[]  _wl_block346Bytes = _getBytes( _wl_block346 );

    private final static java.lang.String  _wl_block347 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label style=\'vertical-align:middle;";
    private final static byte[]  _wl_block347Bytes = _getBytes( _wl_block347 );

    private final static java.lang.String  _wl_block348 ="\' onClick=\"dispAdminOptions(\'";
    private final static byte[]  _wl_block348Bytes = _getBytes( _wl_block348 );

    private final static java.lang.String  _wl_block349 ="\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label style=\"vertical-align:middle;\" >";
    private final static byte[]  _wl_block349Bytes = _getBytes( _wl_block349 );

    private final static java.lang.String  _wl_block350 ="</label>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<br>(";
    private final static byte[]  _wl_block350Bytes = _getBytes( _wl_block350 );

    private final static java.lang.String  _wl_block351 =")&nbsp;\n";
    private final static byte[]  _wl_block351Bytes = _getBytes( _wl_block351 );

    private final static java.lang.String  _wl_block352 ="\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  <label style=\"vertical-align:middle;";
    private final static byte[]  _wl_block352Bytes = _getBytes( _wl_block352 );

    private final static java.lang.String  _wl_block353 =";\" onClick=\"\"><b>";
    private final static byte[]  _wl_block353Bytes = _getBytes( _wl_block353 );

    private final static java.lang.String  _wl_block354 ="</b></label><br>(";
    private final static byte[]  _wl_block354Bytes = _getBytes( _wl_block354 );

    private final static java.lang.String  _wl_block355 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label style=\"vertical-align:middle;";
    private final static byte[]  _wl_block355Bytes = _getBytes( _wl_block355 );

    private final static java.lang.String  _wl_block356 =";\" onClick=\"dispAdminOptions(\'";
    private final static byte[]  _wl_block356Bytes = _getBytes( _wl_block356 );

    private final static java.lang.String  _wl_block357 ="\');\"><b>";
    private final static byte[]  _wl_block357Bytes = _getBytes( _wl_block357 );

    private final static java.lang.String  _wl_block358 =")&nbsp;\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block358Bytes = _getBytes( _wl_block358 );

    private final static java.lang.String  _wl_block359 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block359Bytes = _getBytes( _wl_block359 );

    private final static java.lang.String  _wl_block360 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/history1.jpg\" align=\"center\"  width=\"17\" height=\"17\"  title=\"Cancel History\" onclick=\"cancelHistory(\'";
    private final static byte[]  _wl_block360Bytes = _getBytes( _wl_block360 );

    private final static java.lang.String  _wl_block361 ="\')\"></img><!--modified for MMS-KH-SCF-0064 -->\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block361Bytes = _getBytes( _wl_block361 );

    private final static java.lang.String  _wl_block362 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<!--cancelYn,admin_by_name,drug_desc,scheKey added for JD-CRF-0200 -->\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label style=\'vertical-align:middle;";
    private final static byte[]  _wl_block362Bytes = _getBytes( _wl_block362 );

    private final static java.lang.String  _wl_block363 ="\');\"><b>(";
    private final static byte[]  _wl_block363Bytes = _getBytes( _wl_block363 );

    private final static java.lang.String  _wl_block364 =")<br></b></label><!--modified for MMS-KH-SCF-0064 --><!-- Modified for IN073378 -->\n";
    private final static byte[]  _wl_block364Bytes = _getBytes( _wl_block364 );

    private final static java.lang.String  _wl_block365 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block365Bytes = _getBytes( _wl_block365 );

    private final static java.lang.String  _wl_block366 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label style=\"vertical-align:middle;";
    private final static byte[]  _wl_block366Bytes = _getBytes( _wl_block366 );

    private final static java.lang.String  _wl_block367 =";\">";
    private final static byte[]  _wl_block367Bytes = _getBytes( _wl_block367 );

    private final static java.lang.String  _wl_block368 ="</label><br>(";
    private final static byte[]  _wl_block368Bytes = _getBytes( _wl_block368 );

    private final static java.lang.String  _wl_block369 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n";
    private final static byte[]  _wl_block369Bytes = _getBytes( _wl_block369 );

    private final static java.lang.String  _wl_block370 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"h_iv_admin_qty_";
    private final static byte[]  _wl_block370Bytes = _getBytes( _wl_block370 );

    private final static java.lang.String  _wl_block371 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_admin_chng_dtls_req_";
    private final static byte[]  _wl_block371Bytes = _getBytes( _wl_block371 );

    private final static java.lang.String  _wl_block372 ="\" value=\"N\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_modified_date_time_";
    private final static byte[]  _wl_block372Bytes = _getBytes( _wl_block372 );

    private final static java.lang.String  _wl_block373 ="\">\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_dosage_seq_no_";
    private final static byte[]  _wl_block373Bytes = _getBytes( _wl_block373 );

    private final static java.lang.String  _wl_block374 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_end_date_";
    private final static byte[]  _wl_block374Bytes = _getBytes( _wl_block374 );

    private final static java.lang.String  _wl_block375 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"next_schd_date_";
    private final static byte[]  _wl_block375Bytes = _getBytes( _wl_block375 );

    private final static java.lang.String  _wl_block376 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_dtls_yn";
    private final static byte[]  _wl_block376Bytes = _getBytes( _wl_block376 );

    private final static java.lang.String  _wl_block377 ="\" value=\"N\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_Remarks";
    private final static byte[]  _wl_block377Bytes = _getBytes( _wl_block377 );

    private final static java.lang.String  _wl_block378 ="\" value=\"N\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_qty_in_disp_mode_";
    private final static byte[]  _wl_block378Bytes = _getBytes( _wl_block378 );

    private final static java.lang.String  _wl_block379 ="\" value=\"\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_admin_date_time_";
    private final static byte[]  _wl_block379Bytes = _getBytes( _wl_block379 );

    private final static java.lang.String  _wl_block380 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_infusion_st_time_";
    private final static byte[]  _wl_block380Bytes = _getBytes( _wl_block380 );

    private final static java.lang.String  _wl_block381 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_flow_rate_";
    private final static byte[]  _wl_block381Bytes = _getBytes( _wl_block381 );

    private final static java.lang.String  _wl_block382 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sch_infusion_vol_str_unit_";
    private final static byte[]  _wl_block382Bytes = _getBytes( _wl_block382 );

    private final static java.lang.String  _wl_block383 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sch_infusion_vol_str_unit_desc";
    private final static byte[]  _wl_block383Bytes = _getBytes( _wl_block383 );

    private final static java.lang.String  _wl_block384 ="\"> \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sch_infusion_per_unit_";
    private final static byte[]  _wl_block384Bytes = _getBytes( _wl_block384 );

    private final static java.lang.String  _wl_block385 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_infusion_period_";
    private final static byte[]  _wl_block385Bytes = _getBytes( _wl_block385 );

    private final static java.lang.String  _wl_block386 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sch_infusion_period_unit_";
    private final static byte[]  _wl_block386Bytes = _getBytes( _wl_block386 );

    private final static java.lang.String  _wl_block387 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"previous_batch_id_";
    private final static byte[]  _wl_block387Bytes = _getBytes( _wl_block387 );

    private final static java.lang.String  _wl_block388 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"previous_exp_date_";
    private final static byte[]  _wl_block388Bytes = _getBytes( _wl_block388 );

    private final static java.lang.String  _wl_block389 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"previous_trade_id_";
    private final static byte[]  _wl_block389Bytes = _getBytes( _wl_block389 );

    private final static java.lang.String  _wl_block390 ="\" value=\"\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_batch_id_";
    private final static byte[]  _wl_block390Bytes = _getBytes( _wl_block390 );

    private final static java.lang.String  _wl_block391 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_expiry_date_";
    private final static byte[]  _wl_block391Bytes = _getBytes( _wl_block391 );

    private final static java.lang.String  _wl_block392 ="\" value=\"expiry_date\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_trade_name_";
    private final static byte[]  _wl_block392Bytes = _getBytes( _wl_block392 );

    private final static java.lang.String  _wl_block393 ="\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_trade_id_";
    private final static byte[]  _wl_block393Bytes = _getBytes( _wl_block393 );

    private final static java.lang.String  _wl_block394 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_bin_code_";
    private final static byte[]  _wl_block394Bytes = _getBytes( _wl_block394 );

    private final static java.lang.String  _wl_block395 ="\" value=\"\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\"IV_Newly_administerderd_";
    private final static byte[]  _wl_block395Bytes = _getBytes( _wl_block395 );

    private final static java.lang.String  _wl_block396 ="\" value=\'IV_Y\'>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_no_of_drug_per_order_";
    private final static byte[]  _wl_block396Bytes = _getBytes( _wl_block396 );

    private final static java.lang.String  _wl_block397 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sfrFLOW_STATUS";
    private final static byte[]  _wl_block397Bytes = _getBytes( _wl_block397 );

    private final static java.lang.String  _wl_block398 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sfrHOLD_DATE_TIME";
    private final static byte[]  _wl_block398Bytes = _getBytes( _wl_block398 );

    private final static java.lang.String  _wl_block399 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sfrHOLD_DURN_IN_MINS";
    private final static byte[]  _wl_block399Bytes = _getBytes( _wl_block399 );

    private final static java.lang.String  _wl_block400 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"durn_bw_std_resumed_";
    private final static byte[]  _wl_block400Bytes = _getBytes( _wl_block400 );

    private final static java.lang.String  _wl_block401 ="\" value=\"\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"flow_rate_changed_YN";
    private final static byte[]  _wl_block401Bytes = _getBytes( _wl_block401 );

    private final static java.lang.String  _wl_block402 ="\" value=\"\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sfrRESUME_DATE_TIME";
    private final static byte[]  _wl_block402Bytes = _getBytes( _wl_block402 );

    private final static java.lang.String  _wl_block403 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sfrACT_END_DATE_TIME";
    private final static byte[]  _wl_block403Bytes = _getBytes( _wl_block403 );

    private final static java.lang.String  _wl_block404 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"inf_prd_hrs";
    private final static byte[]  _wl_block404Bytes = _getBytes( _wl_block404 );

    private final static java.lang.String  _wl_block405 ="\" value=\"0\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"inf_prd_min";
    private final static byte[]  _wl_block405Bytes = _getBytes( _wl_block405 );

    private final static java.lang.String  _wl_block406 ="\" value=\"0\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_dosage_type_";
    private final static byte[]  _wl_block406Bytes = _getBytes( _wl_block406 );

    private final static java.lang.String  _wl_block407 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"completedMinutes";
    private final static byte[]  _wl_block407Bytes = _getBytes( _wl_block407 );

    private final static java.lang.String  _wl_block408 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"completedFlow";
    private final static byte[]  _wl_block408Bytes = _getBytes( _wl_block408 );

    private final static java.lang.String  _wl_block409 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_admin_qty_";
    private final static byte[]  _wl_block409Bytes = _getBytes( _wl_block409 );

    private final static java.lang.String  _wl_block410 ="\"> \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_qty_uom_";
    private final static byte[]  _wl_block410Bytes = _getBytes( _wl_block410 );

    private final static java.lang.String  _wl_block411 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_sch_date_tim_";
    private final static byte[]  _wl_block411Bytes = _getBytes( _wl_block411 );

    private final static java.lang.String  _wl_block412 ="\"><!--Added for SKR-SCF-0913[Inc : 46556] -->\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_drug_code_";
    private final static byte[]  _wl_block412Bytes = _getBytes( _wl_block412 );

    private final static java.lang.String  _wl_block413 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_item_code_";
    private final static byte[]  _wl_block413Bytes = _getBytes( _wl_block413 );

    private final static java.lang.String  _wl_block414 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_order_id_";
    private final static byte[]  _wl_block414Bytes = _getBytes( _wl_block414 );

    private final static java.lang.String  _wl_block415 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_order_line_no_";
    private final static byte[]  _wl_block415Bytes = _getBytes( _wl_block415 );

    private final static java.lang.String  _wl_block416 ="\">\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_drug_class";
    private final static byte[]  _wl_block416Bytes = _getBytes( _wl_block416 );

    private final static java.lang.String  _wl_block417 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\"iv_link_vaccine_code_";
    private final static byte[]  _wl_block417Bytes = _getBytes( _wl_block417 );

    private final static java.lang.String  _wl_block418 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block418Bytes = _getBytes( _wl_block418 );

    private final static java.lang.String  _wl_block419 ="\' width=\'5%\'  style=\"word-wrap:break-word;text-align:center;font-size:9;\" rowspan=\'";
    private final static byte[]  _wl_block419Bytes = _getBytes( _wl_block419 );

    private final static java.lang.String  _wl_block420 ="\' width=\'5%\' rowspan=\'";
    private final static byte[]  _wl_block420Bytes = _getBytes( _wl_block420 );

    private final static java.lang.String  _wl_block421 ="\' style=\"font-size:9;word-wrap:break-word;\">&nbsp;</td>\n";
    private final static byte[]  _wl_block421Bytes = _getBytes( _wl_block421 );

    private final static java.lang.String  _wl_block422 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block422Bytes = _getBytes( _wl_block422 );

    private final static java.lang.String  _wl_block423 ="\' width=\'5%\'  style=\"font-size:9;word-wrap:break-word;\"  rowspan=\'";
    private final static byte[]  _wl_block423Bytes = _getBytes( _wl_block423 );

    private final static java.lang.String  _wl_block424 ="\n\t\t\t\t\t\t\t\t\t</tr>\t\t\t\t\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block424Bytes = _getBytes( _wl_block424 );

    private final static java.lang.String  _wl_block425 ="\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"MfrYN";
    private final static byte[]  _wl_block425Bytes = _getBytes( _wl_block425 );

    private final static java.lang.String  _wl_block426 ="\" id=\"MfrYN";
    private final static byte[]  _wl_block426Bytes = _getBytes( _wl_block426 );

    private final static java.lang.String  _wl_block427 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_mfrRemarks";
    private final static byte[]  _wl_block427Bytes = _getBytes( _wl_block427 );

    private final static java.lang.String  _wl_block428 ="\" id=\"iv_mfrRemarks";
    private final static byte[]  _wl_block428Bytes = _getBytes( _wl_block428 );

    private final static java.lang.String  _wl_block429 ="\">\t\t\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_drug_code_";
    private final static byte[]  _wl_block429Bytes = _getBytes( _wl_block429 );

    private final static java.lang.String  _wl_block430 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_dispense_drug_code_";
    private final static byte[]  _wl_block430Bytes = _getBytes( _wl_block430 );

    private final static java.lang.String  _wl_block431 ="\" id=\"iv_dispense_drug_code_";
    private final static byte[]  _wl_block431Bytes = _getBytes( _wl_block431 );

    private final static java.lang.String  _wl_block432 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_drug_desc_";
    private final static byte[]  _wl_block432Bytes = _getBytes( _wl_block432 );

    private final static java.lang.String  _wl_block433 ="\" id=\"iv_drug_desc_";
    private final static byte[]  _wl_block433Bytes = _getBytes( _wl_block433 );

    private final static java.lang.String  _wl_block434 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_item_code_";
    private final static byte[]  _wl_block434Bytes = _getBytes( _wl_block434 );

    private final static java.lang.String  _wl_block435 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_order_id_";
    private final static byte[]  _wl_block435Bytes = _getBytes( _wl_block435 );

    private final static java.lang.String  _wl_block436 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_order_line_no_";
    private final static byte[]  _wl_block436Bytes = _getBytes( _wl_block436 );

    private final static java.lang.String  _wl_block437 ="\">\t\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_store_code_";
    private final static byte[]  _wl_block437Bytes = _getBytes( _wl_block437 );

    private final static java.lang.String  _wl_block438 ="\" id=\"iv_store_code_";
    private final static byte[]  _wl_block438Bytes = _getBytes( _wl_block438 );

    private final static java.lang.String  _wl_block439 ="\">\t\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_drug_class";
    private final static byte[]  _wl_block439Bytes = _getBytes( _wl_block439 );

    private final static java.lang.String  _wl_block440 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_order_pract_id_";
    private final static byte[]  _wl_block440Bytes = _getBytes( _wl_block440 );

    private final static java.lang.String  _wl_block441 ="\" id=\"iv_order_pract_id_";
    private final static byte[]  _wl_block441Bytes = _getBytes( _wl_block441 );

    private final static java.lang.String  _wl_block442 ="\"> \n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_prep_yn";
    private final static byte[]  _wl_block442Bytes = _getBytes( _wl_block442 );

    private final static java.lang.String  _wl_block443 ="\" id=\"iv_prep_yn";
    private final static byte[]  _wl_block443Bytes = _getBytes( _wl_block443 );

    private final static java.lang.String  _wl_block444 ="\"> \n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"freq_code";
    private final static byte[]  _wl_block444Bytes = _getBytes( _wl_block444 );

    private final static java.lang.String  _wl_block445 ="\" id=\"freq_code";
    private final static byte[]  _wl_block445Bytes = _getBytes( _wl_block445 );

    private final static java.lang.String  _wl_block446 ="\"> \n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_Auto_Admin_";
    private final static byte[]  _wl_block446Bytes = _getBytes( _wl_block446 );

    private final static java.lang.String  _wl_block447 ="\" id=\"iv_Auto_Admin_";
    private final static byte[]  _wl_block447Bytes = _getBytes( _wl_block447 );

    private final static java.lang.String  _wl_block448 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"disp_locn_code";
    private final static byte[]  _wl_block448Bytes = _getBytes( _wl_block448 );

    private final static java.lang.String  _wl_block449 ="\" id=\"disp_locn_code";
    private final static byte[]  _wl_block449Bytes = _getBytes( _wl_block449 );

    private final static java.lang.String  _wl_block450 ="\"\t\tvalue=\"";
    private final static byte[]  _wl_block450Bytes = _getBytes( _wl_block450 );

    private final static java.lang.String  _wl_block451 ="\">\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\"iv_discontinued";
    private final static byte[]  _wl_block451Bytes = _getBytes( _wl_block451 );

    private final static java.lang.String  _wl_block452 ="\" id=\"iv_discontinued";
    private final static byte[]  _wl_block452Bytes = _getBytes( _wl_block452 );

    private final static java.lang.String  _wl_block453 ="\'>\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\"iv_hold";
    private final static byte[]  _wl_block453Bytes = _getBytes( _wl_block453 );

    private final static java.lang.String  _wl_block454 ="\" id=\"iv_hold";
    private final static byte[]  _wl_block454Bytes = _getBytes( _wl_block454 );

    private final static java.lang.String  _wl_block455 ="\'>\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\"iv_link_vaccine_code_";
    private final static byte[]  _wl_block455Bytes = _getBytes( _wl_block455 );

    private final static java.lang.String  _wl_block456 ="\n\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block456Bytes = _getBytes( _wl_block456 );

    private final static java.lang.String  _wl_block457 ="\n\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block457Bytes = _getBytes( _wl_block457 );

    private final static java.lang.String  _wl_block458 ="\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block458Bytes = _getBytes( _wl_block458 );

    private final static java.lang.String  _wl_block459 ="</td>\n\t\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block459Bytes = _getBytes( _wl_block459 );

    private final static java.lang.String  _wl_block460 ="\n\t\t\t\t\t</table>\n\t\t\t\t</div>\n";
    private final static byte[]  _wl_block460Bytes = _getBytes( _wl_block460 );

    private final static java.lang.String  _wl_block461 ="\n\t</body>\n</html>\n";
    private final static byte[]  _wl_block461Bytes = _getBytes( _wl_block461 );
	
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
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);
 
	try{
 		request.setCharacterEncoding("UTF-8");
 		//Added  for COMMON-ICN-0182 on 17-10-2023
 		request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
 		response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
 		response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
 		//ends
		String locale					= (String) session.getAttribute("LOCALE");
		String sStyle					=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String patient_class			=	 request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
		String patient_id_test			=	 request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String order_id_test			=	 request.getParameter("order_id");
		String order_line_no_test       =	 request.getParameter("order_line_no")==null?"":request.getParameter("order_line_no");
		String mode				        =	 request.getParameter("mode");	
		//String hold_discontinue_yn      =	 request.getParameter("hold_discontinue_yn")==null?"":request.getParameter("hold_discontinue_yn");
		//String function_from			=	 request.getParameter("function_from")==null?"":request.getParameter("function_from");
		//String admin_due_date			=	 request.getParameter("admin_due_date")==null?"":request.getParameter("admin_due_date");
		String facility_id				=	 (String)session.getValue( "facility_id" );
		String encounter_id			    =	 request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
		//String assign_bed_num			=	 request.getParameter("assign_bed_num")==null?"": request.getParameter("assign_bed_num");
	//	String order_type	            =    request.getParameter("order_type")==null?"": request.getParameter("order_type"); 
//		String nursing_unit				=	 request.getParameter("nursing_unit")==null?"":request.getParameter("nursing_unit");  
//		String administration_status    =	 request.getParameter("administration_status")==null?"": request.getParameter("administration_status");
		String from_time				=	 request.getParameter("from_time")==null?"":request.getParameter("from_time");	
		String to_time					=	 request.getParameter("to_time")==null?"":request.getParameter("to_time");
		String mar_disc_dose_yn		=	 request.getParameter("mar_disc_dose_yn")==null?"":request.getParameter("mar_disc_dose_yn");	

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
 
	String bean_id_all_stages				= "DispMedicationAllStages" ;
	String bean_name_all_stages				= "ePH.DispMedicationAllStages";
	DispMedicationAllStages bean_all_stages = (DispMedicationAllStages)getBeanObject( bean_id_all_stages, bean_name_all_stages, request ) ;
	ArrayList multi_drugs					=  bean_all_stages.getMultiDrugs(patient_id_test,patient_id_test,order_line_no_test);	
	String bean_id							= "MedicationAdministrationFTBean";
	String bean_name						= "ePH.MedicationAdministrationFTBean";
	MedicationAdministrationFTBean bean		= (MedicationAdministrationFTBean)getBeanObject( bean_id, bean_name, request );
	//String drug_search_bean_id				= "DrugSearchBean";
	//String drug_search_bean_name			= "ePH.DrugSearchBean";
	//DrugSearchBean drug_bean				= (DrugSearchBean)getBeanObject( drug_search_bean_id, drug_search_bean_name , request);

	String admin_bean_id						=	  "MedicationAdministrationBean";
	String admin_bean_name						=	  "ePH.MedicationAdministrationBean";
	MedicationAdministrationBean admin_bean		=	  (MedicationAdministrationBean)getBeanObject( admin_bean_id, admin_bean_name, request );
	
	ArrayList AdminDateresult						= bean.getCurrentTimeAndAdminWithinHRS();
	String current_date_time				= (String)AdminDateresult.get(0);
	String userAuthPINYN=bean.getUserAuthPINYN(facility_id); //RUT-CRF-0035 [IN029926] Added for User Auth PIN Validation
	ArrayList result = bean.getCurrentTimeAndAdminWithinHRS();
	String adminFromDateTime		= bean.getFromDateTime(com.ehis.util.DateUtils.convertDate(current_date_time, "DMYHM",locale,"en"));
	String adminToTime			= bean.getAdiminWindowToDateTime(com.ehis.util.DateUtils.convertDate(current_date_time, "DMYHM",locale,"en"));
	if(!locale.equals("en")){
		adminFromDateTime = com.ehis.util.DateUtils.convertDate(adminFromDateTime, "DMYHM",locale,"en");
		adminToTime = com.ehis.util.DateUtils.convertDate(adminToTime, "DMYHM",locale,"en");
		from_time = com.ehis.util.DateUtils.convertDate(from_time, "DMY",locale,"en");
		to_time = com.ehis.util.DateUtils.convertDate(to_time, "DMY",locale,"en");
	}
	HashMap	drug_details		  =	(HashMap) bean.getDrugDetails();
	ArrayList altDateDayList = admin_bean.getDateDayList(from_time,to_time, "W");
	int daySize=0;
	int dispSizeMms=0;//ADDED FOR MMS-KH-CRF-0010
	int adr_count =0;
	if(altDateDayList!=null && altDateDayList.size()>0)
		daySize = altDateDayList.size();
	String iv_prep_yn			   =	"";
	String title				   =	"";
	String patient_id					=   "";

//	LinkedHashMap	hmNonIVDrugDetails				=	(LinkedHashMap) drug_details.get("NON_IV");
	LinkedHashMap hmIVDrugDetails				    =	 (LinkedHashMap) drug_details.get("IV");
	HashMap hmSchList				    =	 (HashMap) drug_details.get("SCHLIST");
	ArrayList	alTmpOrderSchDetail	=null;
	ArrayList iv_drug_details =null;
	List OrdersList = null;
	Set uniqueSchedules = null;
	String Store_locn_code				=	"";
	String sch_date_time="";
	String drug_code="", drug_desc="", drug_class="", drug_class_ind, freq_desc;
	String  route_desc, pres_catg_code, prn_remarks,slidingscaleremarks, ext_prod_id="", trade_code, imageFileURL,    dosage_type="", dosage="",  start_date_time="", end_date_time="", end_date="", start_date="";
	String     linkVacScheduleCode="", performingDeptLocCode, dose_uom_desc,  verificationremarks, pres_remarks, drug_remarks,pharma_remarks, show_remarks="", order_pract_id="", route_color="", fntColor="" ,backGrndColor="" , store_code="";
	HashMap overridereason = null;
	String classvalue ="", linkVacScheduleCode1="";
	String[] vacScheduleDetails;
	String order_id="", order_line_num="", dayLegend="", schDate="", dispDate="", schTime = "";
	String administered_yn="", admin_recorded_yn ="",   displayStyle="";
	String strength_per_value_pres_uom = "1",qty="",  freq_nature="", freq_code="", dosage_seq_no="", 			admin_drug_code	    =  "";
	String remarks="", discontinued="", hold="", admin_by_name, auth_by_name,  admin_date_time, modified_date_time="", stat_style="", showAlt="", scheKey ="", schCanAdmin="", admin_rec_disp="", split_dose_yn="", temp="",   stDispHand="", iv_sch_date_tim;//iv_sch_date_tim Added for SKR-SCF-0913[Inc : 46556]
	StringBuilder showTitle = new StringBuilder();
	String pract_id						=	"";		String against_sch_date				=	"";
	String adr_reason					=	"";		String adr_remarks					=	"";
	String adr_record_time				=	"";		String adr_recorded_by				=	"";
	String adr_details					=	"";	
	String adminStatus="";
	String encode_drug_desc				=   "";
	String next_schd_date				=	"";		String AdUOM						=	"";
	String demostring					=  "\\\'\'";
	String linkVacScheduleDescToolTip	=	"";		String linkVacScheduleYN			=	"N";
	String nonMfrFluidRemarks			=	"";		String linkVacScheduleDesc ="";
	String remarks_style="",  batch_id="", flag="", item_code="", expiry_date ="", trade_id="" ,ord_hold_date_time="", ord_disc_date_time="";

	int orderCount		 = 0;
	int dialog_height = 0;
	int rowsPan = 1;
	int schSize = 1;
	int schDayCount =0;
	int dayCount=0;
	int temp1                           =   0;
	int temp2                           =   0;		
	int temp3                           =   0;		
	int ppn_count						=   0;
	String prev_key="", curr_key="";
	String user_id=(String)session.getValue("login_user");//ADDED FOR JD-CRF-0200
	String cancelYn=bean.getMedicationAdminstrationRights(user_id); //ADDED FOR JD-CRF-0200
	int sch =0, prn_doseCount=0,  prev_prnSrlNo=0, i_prnSrlNo=1, schCount=0, prevSchCount=0;
	boolean viewAdminRemarks = bean.isSiteSpecific("PH","VIEW_ADMIN_REMARKS");//ADDED FOR MMS-KH-CRF-0010
	if(hmIVDrugDetails.size()>0){	
		String dispensed_drug_desc="", disp_drugs="", dispense_drug_code="";

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
if(viewAdminRemarks){ 
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
} 
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

					if(altDateDayList!=null && altDateDayList.size()>0){
						daySize = altDateDayList.size();
						for(int day=0; day<daySize; day+=2){
							dayLegend = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common."+(String)altDateDayList.get(day+1)+".label", "common_labels");

            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(((String)altDateDayList.get(day)),"DMY","en",locale)));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(dayLegend));
            _bw.write(_wl_block23Bytes, _wl_block23);

						}
					}

            _bw.write(_wl_block24Bytes, _wl_block24);
if(viewAdminRemarks){//Added for MMS-KH-CRF-0010
					dispSizeMms=8;
					}
				else
					dispSizeMms=7;
					
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf((daySize/2)+dispSizeMms));
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
 
		String sfrFLOW_STATUS_String="";
		String sch_infusion_rate        =   "";
		String sch_infusion_vol_str_unit=   "";
        	String sch_infusion_vol_str_unit_desc =   "";
		String sch_infusion_per_unit    =   "";
		String sch_infusion_per_unit_table_date = "";
		String trade_name               =   "";
		String qty_uom					=   "";
		String sch_infusion_period		=   "";
		String sch_infusion_period_unit =   "";
		String sch_infusion_period_unit_label =   "";
		classvalue						=	"";
		dosage_seq_no			        =   "";
		String hide_ingredient_dtls		=   "";
		iv_prep_yn						=	"";
		String prod_name				=	"";
		String sch_infusion_in_min      =   "";
		String tol_title                =   "";
		String administred_batch_id     =   "";
		String disp_batch_id		    =   "";
		String iv_no_of_drug_per_order  =   "1";
		String MfrYN					=	"N";
		String sfrFLOW_STATUS			=	"";//single flow rate
		String sfrHOLD_DATE_TIME		=	"";
		String sfrHOLD_DURN_IN_MINS		=	"";
		String sfrRESUME_DATE_TIME		=	"";
		String sfrACT_START_DATE_TIME	=	"";
		String sfrACT_END_DATE_TIME		=	"";
		String mfrRemarks				=	"";
		String completedMinutes			=	"0";
		String completedFlow			=	"0";
		String iv_order_pract_id        =""; 
		String pin_value="", statusString="";		
		boolean auth_reqd					=   false;
		String auth_reqd_script				=	"", IVclassvalue="";
		dosage_type				=	"";
		boolean mfrCompletedStatus		=	false;
		ArrayList ivSchDisplay			=	null;
		ArrayList MfrDetails			=	null;
		ArrayList work_sheet_batch_det	=   new ArrayList();
		int ivRowCount = 0;
		boolean ivnextRow = false, nextDaySch=false;
		String ordKey ="", iv_Auto_Admin="";
		HashMap hmIVDrugFluidDtls=null;
		ArrayList alIVPBDrugSchList = null;
		OrdersList = new ArrayList(hmIVDrugDetails.keySet());
		int fluidRowspan=1, drugRowspan=1, freqRowspan=1, schRowspan=1, max_dasage_seq_no=1 ;
		String ivPB_drug_code = "", ivPB_trade_code="", ivPB_drug_desc ="", ivPB_sch_infusion_rate="", ivPB_sch_infusion_vol_str_unit_desc="", ivPB_sch_infusion_per_unit="", 
		ivPB_qty="", ivPB_qty_uom="", ivPB_imageFileURL="",  ivPB_ext_prod_id="", ivPB_encode_drug_desc="", ivSchDisp="", ivSchDispStatus="";
		ArrayList alTmpIVPBDrugDtls = null;
		int no_of_doses = 1, drugIndex=0, drugCount=0;
		String MFRCount = "";
		String ack_yn = "";//GHL-CRF-0458
		String displayStyle_1 = "";//GHL-CRF-0458
		String patient_class_ord = "";//GHL-CRF-0458
		//boolean isSiteSpecMARPrint = bean.isSiteSpecific("PH","WARD_ACK");//GHL-CRF-0458 and changed MAR_PRINT_YN to WARD_ACK for AMS-CRF-0203 // commented for MMS-KH-CRF-0014 [IN:067953]
		String WardAckMarRequiredYn = admin_bean.getWardAckMarRequiredYn(); //Added for MMS-KH-CRF-0014 [IN:067953]
		boolean marForDisPatNotReqYN = bean.isSiteSpecific("PH", "MAR_FOR_DISC_PAT_NOT_REQ_YN"); // Added for KH-SCF-0010
		boolean dischargedYN = bean.getDischargedStatus(encounter_id); // Added for KH-SCF-0010
		String cancel_recorded_yn="N";//ADDED FOR JD-CRF-0200
				String cancel_recorded_yn_3="N";//ADDED FOR JD-CRF-0200
		for (int i=0;i<OrdersList.size();i++){
			ordKey = (String)OrdersList.get(i);
			iv_prep_yn = ordKey.substring(ordKey.indexOf("_")+1,ordKey.length());
			schSize=1;
			sch =0;
			schRowspan=1;
			rowsPan=1;
			drugRowspan=0;
			fluidRowspan=1;
			freqRowspan=1;
			ivRowCount =0;
			schCount=0;
			alIVPBDrugSchList = null;
			if(hmSchList.containsKey(((String)OrdersList.get(i))+"SCH")){
				uniqueSchedules = (LinkedHashSet <String>)hmSchList.get(((String)OrdersList.get(i))+"SCH");
				schSize = uniqueSchedules.size();
			}
			if(iv_prep_yn.equals("3") || iv_prep_yn.equals("4")){ 
				hmIVDrugFluidDtls =(HashMap)hmIVDrugDetails.get(ordKey);
				alTmpOrderSchDetail =(ArrayList)hmIVDrugFluidDtls.get(ordKey+"_Fluid");
				alIVPBDrugSchList =(ArrayList)hmIVDrugFluidDtls.get(ordKey+"_Drug");
				rowsPan = schSize;
				if(alIVPBDrugSchList!=null && alIVPBDrugSchList.size()>0){
					if(schSize ==1){
						rowsPan = 2;
						freqRowspan=2;
						schRowspan=2;
						drugRowspan=1;
						fluidRowspan=1;
					}
					else if(schSize%2 >0 && schSize>1){
						fluidRowspan =(schSize/2)+1;
						drugRowspan =schSize/2;
						freqRowspan = schSize/(drugRowspan+fluidRowspan);
					}
					else{
						fluidRowspan =schSize/2;
						drugRowspan =schSize/2;
						freqRowspan = schSize/(drugRowspan+fluidRowspan);
					}
				}
				else{
					fluidRowspan = rowsPan ;
				}
/*				if(iv_prep_yn.equals("4")){ //commented for MMS-KH-CRF-0017
					rowsPan = 1;
					drugRowspan=1;
					fluidRowspan=1;
				} */
			}
			else{
				alTmpOrderSchDetail = (ArrayList)hmIVDrugDetails.get((String)OrdersList.get(i));
				max_dasage_seq_no = Integer.parseInt(hmSchList.get(ordKey+"MAXSEQ")+"");
				rowsPan = (alTmpOrderSchDetail.size()/max_dasage_seq_no);
				if(!iv_prep_yn.equals("2") && !iv_prep_yn.equals("5")){ 
					freqRowspan=rowsPan;
				}
			}
			for(sch=0; sch<alTmpOrderSchDetail.size(); sch++){
				iv_drug_details =(ArrayList)alTmpOrderSchDetail.get(sch);
				iv_order_pract_id  =  (String)iv_drug_details.get(68);
				linkVacScheduleCode	="";
				dosage_seq_no	= iv_drug_details.get(13)==null?"":(String)iv_drug_details.get(13);
				admin_recorded_yn  = (String)iv_drug_details.get(23);
				if(!dosage_seq_no.equals("1") && !( iv_prep_yn.equals("3")|| iv_prep_yn.equals("4")) )
					continue;
				pres_catg_code =(String)iv_drug_details.get(49);
				if(pres_catg_code == null){
					pres_catg_code="";
				}
				auth_reqd=bean.isAuthenticationRequired(facility_id,pres_catg_code);								
				auth_reqd_script="";
				if(auth_reqd){
					if(pin_value.equals(""))
						auth_reqd_script=";pinAuthentication(this,'NP');";
					else
						auth_reqd_script=";pinAuthentication(this,'YP');";
				}
				iv_sch_date_tim      = (String)iv_drug_details.get(12);//Added for SKR-SCF-0913[Inc : 46556]
				pract_id					= (String)iv_drug_details.get(37);
				against_sch_date			= (String)iv_drug_details.get(38);
				adr_reason					= (String)iv_drug_details.get(39)==null?"":(String)iv_drug_details.get(39);
				adr_remarks					= (String)iv_drug_details.get(40);
				adr_record_time				= (String)iv_drug_details.get(41)==null?"":(String)iv_drug_details.get(41);
				adr_recorded_by				= (String)iv_drug_details.get(42);
				iv_prep_yn					= (String)iv_drug_details.get(43);	
				freq_nature					= (String)iv_drug_details.get(35);
				flag						=	"Y";
				sch_infusion_rate			= (String)iv_drug_details.get(1);

				if(sch_infusion_rate!= null && !(sch_infusion_rate.equals(""))){
					if(Float.parseFloat(sch_infusion_rate) < 1.0){ 
						sch_infusion_rate = Float.parseFloat(sch_infusion_rate)+"";
					}
				}
				sch_infusion_vol_str_unit	= (String)iv_drug_details.get(2);
				sch_infusion_vol_str_unit_desc = (String)iv_drug_details.get(66);
				sch_infusion_per_unit		= (String)iv_drug_details.get(3);
				route_desc					= (String)iv_drug_details.get(48);
				route_color                 = (String)iv_drug_details.get(67);
				if(route_color != "" && route_color != null && route_color.length()==12){
					fntColor = route_color.substring(0, 6);
					backGrndColor = route_color.substring(6, 12);
				}
				else{
					fntColor = "";
					backGrndColor = "";
				}
				patient_id					= (String)iv_drug_details.get(9);
				sch_infusion_per_unit_table_date = sch_infusion_per_unit;
									
				if(sch_infusion_per_unit.equals("H")){
					sch_infusion_per_unit = "Hrs";
					if(sch_infusion_rate!=null && !(sch_infusion_rate.equals(""))){												
						sch_infusion_in_min=bean.roundDigits(Float.parseFloat(sch_infusion_rate)/60.0+"");
					}
					tol_title=sch_infusion_in_min+"&nbsp;ML/Minute"; 
				}
				else{
					sch_infusion_per_unit = "Mins";
					tol_title="";
				}
				item_code                =   (String)iv_drug_details.get(8);
				drug_code                =   (String)iv_drug_details.get(29);
				drug_desc                =   (String)iv_drug_details.get(11);
				dispensed_drug_desc		 = 	 (String)iv_drug_details.get(77);
				disp_drugs 				 =   (String)iv_drug_details.get(78);
				dispense_drug_code 		 = 	 (String)iv_drug_details.get(79);
				if(dispense_drug_code.equals(""))
					dispense_drug_code 	 = drug_code;
				sch_date_time            =   (String)iv_drug_details.get(12);
				order_id                 =   (String)iv_drug_details.get(14);
				order_line_num           =   (String)iv_drug_details.get(15);
				qty						 =	 (String)iv_drug_details.get(16);
				if(Float.parseFloat(qty) < 1)
					qty="0"+qty; 

				qty_uom					 =	 (String)iv_drug_details.get(17);
				discontinued			 =	 (String)iv_drug_details.get(18);
				hold					 =	 (String)iv_drug_details.get(19);
				sch_infusion_period		 =	 (String)iv_drug_details.get(20);		
				
				sch_infusion_period_unit =	 (String)iv_drug_details.get(21);
				administered_yn			 =	 (String)iv_drug_details.get(22);
				store_code				 =   (String)iv_drug_details.get(30);
				end_date_time 			 =   (String)iv_drug_details.get(33);
				start_date_time			=	(String)iv_drug_details.get(69);
				freq_code				 =   (String)iv_drug_details.get(34);								
				encode_drug_desc         =   drug_desc.replaceAll(" ","%20");
				encode_drug_desc         =   java.net.URLEncoder.encode(encode_drug_desc,"UTF-8");
				encode_drug_desc         =   encode_drug_desc.replaceAll("%2520","%20");						
				ext_prod_id              =   (String)iv_drug_details.get(44);
				iv_no_of_drug_per_order  =   (String)iv_drug_details.get(45);
				trade_code			     =   (String)iv_drug_details.get(46);
				imageFileURL			 =   (String)iv_drug_details.get(47);
				Store_locn_code			 =	(String)iv_drug_details.get(65);
				iv_Auto_Admin               =   bean.getAutoAdminValue(facility_id,Store_locn_code);
				next_schd_date           =   bean.getNextSchdate(order_id,order_line_num,Integer.parseInt(dosage_seq_no.trim()),sch_date_time);//added for SCF-7528
				no_of_doses = 1;
				if(bean.getNoOfDoses(order_id,order_line_num) !=null)
					no_of_doses				 =   Integer.parseInt(bean.getNoOfDoses(order_id,order_line_num));
				linkVacScheduleCode		 =	(String)iv_drug_details.get(53);
				MfrYN					 =	(String)iv_drug_details.get(54);
				sfrFLOW_STATUS			 =	(String)iv_drug_details.get(55);
				sfrHOLD_DATE_TIME		 =	(String)iv_drug_details.get(56);
				sfrHOLD_DURN_IN_MINS	 =	(String)iv_drug_details.get(57);
				if(sfrHOLD_DURN_IN_MINS.equals(""))
					sfrHOLD_DURN_IN_MINS="0";
				sfrRESUME_DATE_TIME		 =	(String)iv_drug_details.get(58);
				sfrACT_START_DATE_TIME	 =	(String)iv_drug_details.get(59);
				if(!(sfrACT_START_DATE_TIME.equals(""))){
					sfrACT_START_DATE_TIME=com.ehis.util.DateUtils.convertDate(sfrACT_START_DATE_TIME,"DMYHM","en",locale);
				}
				
				if(sfrACT_START_DATE_TIME.equals("")){
					sfrACT_START_DATE_TIME=current_date_time;
				}
				sfrACT_END_DATE_TIME	 =(String)iv_drug_details.get(60);
				dosage_type				 =(String)iv_drug_details.get(61);
				mfrRemarks				 =	(String)iv_drug_details.get(62);
				completedMinutes		 =	(String)iv_drug_details.get(63);
				if(completedMinutes.equals(""))
					completedMinutes = "0";
				completedFlow			 =	(String)iv_drug_details.get(64);
				if(completedFlow.equals(""))
					completedFlow = "0";
				if(iv_prep_yn.equals("3")||iv_prep_yn.equals("4"))
					freq_desc			 =	(String)iv_drug_details.get(70);
				else
					freq_desc = "";
				adr_count			= bean.getADRCount(patient_id_test,drug_code);   
				schDate			 =	(String)iv_drug_details.get(71);
				schTime			 =	(String)iv_drug_details.get(72);
				String can_act_sch=(String)iv_drug_details.get(72);//ADDED FOR JD-CRF-0200
				
				schCanAdmin			 =	(String)iv_drug_details.get(73);
				ord_hold_date_time			 =	(String)iv_drug_details.get(75);
				ord_disc_date_time			 =	(String)iv_drug_details.get(76);
			cancel_recorded_yn_3=(String)iv_drug_details.get(80);//ADDED FOR JD-CRF-0200
		

				if(!mfrRemarks.equals(""))
					mfrRemarks=java.net.URLEncoder.encode(mfrRemarks,"UTF-8");

				if(!(linkVacScheduleCode==null || linkVacScheduleCode.equals(""))){
					linkVacScheduleCode1=linkVacScheduleCode.substring(0,10);									
					if(!linkVacScheduleCode1.equals("NO DEFAULT")){
						try{
							linkVacScheduleYN="Y";
							vacScheduleDetails=linkVacScheduleCode.split("~",6);
							if(vacScheduleDetails.length>0){
								linkVacScheduleCode=vacScheduleDetails[0]+"~"+vacScheduleDetails[1]+"~"+vacScheduleDetails[2]+"~"+vacScheduleDetails[5];
								linkVacScheduleDescToolTip=vacScheduleDetails[3];
								linkVacScheduleDesc=vacScheduleDetails[4];
							}
						}
						catch(Exception execu){
							execu.printStackTrace();
						}
					}
					else{
						linkVacScheduleYN="Y";
						linkVacScheduleDescToolTip="";
						linkVacScheduleDesc="";
						vacScheduleDetails=linkVacScheduleCode.split("~");
						if(vacScheduleDetails.length>0){
							linkVacScheduleCode=vacScheduleDetails[1];
						}										
					}
				}
				else{
					linkVacScheduleYN="N";
					linkVacScheduleDescToolTip="";
					linkVacScheduleDesc="";
				}			

				if(order_line_num != null && !order_line_num.equals("1"))
					hide_ingredient_dtls = "visibility:hidden;";
				else
					hide_ingredient_dtls = "";

				if(freq_nature!=null && freq_nature.equals("O")) 
					stat_style	=	"background-color:#CE00CE";
				else
					stat_style	=	"";

				administered_yn		 = "Y";
				if(iv_drug_details.get(23)==null || ((String)iv_drug_details.get(23)).equals(""))
					administered_yn = "N";
				remarks = (String)iv_drug_details.get(24);				
				if(remarks==null)
					remarks="Not Entered";

								admin_by_name   = (String)iv_drug_details.get(26);
								auth_by_name    = (String)iv_drug_details.get(32);
								if(showTitle.length()>0)
									showTitle.setLength(0);
								if(remarks!=null && !remarks.equals(""))
									showTitle.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.remarks.label", "common_labels")+"  : "+remarks+"\n");
								if(admin_by_name!=null && !admin_by_name.equals(""))
									showTitle.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.AdministeredBy.label", "common_labels")+"   : "+admin_by_name);
								if(auth_by_name!=null && !auth_by_name.equals("")){
									showTitle.append("\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.authorizedby.label", "common_labels")+"  : "+auth_by_name);
								}

				admin_date_time = "";
				if(iv_drug_details.get(27)!= null)
					admin_date_time = (String)iv_drug_details.get(27);
				if(viewAdminRemarks){
					showTitle.append("\nRecorded D/T: "+admin_date_time);//ADDED FOR MMS-KH-CRF-0010
				}
				modified_date_time = "";
				if(iv_drug_details.get(28)!= null)
					modified_date_time = (String)iv_drug_details.get(28);				
				drug_class = (String)iv_drug_details.get(31);
				drug_class_ind = bean.getDrugClassInd(drug_class);
							
				if(sch_infusion_period_unit==null)
					sch_infusion_period_unit="";

				if(sch_infusion_period_unit.equals("H"))
					sch_infusion_period_unit_label = "Hrs";
				else if(sch_infusion_period_unit.equals("M"))
					sch_infusion_period_unit_label = "Mins";



				displayStyle = bean.getDisplayStyle(freq_code,discontinued,hold,admin_recorded_yn,administered_yn);
				HashMap  administred_batch   = bean.getAdminBatchID(order_id,order_line_num,encounter_id,sch_date_time,drug_code);
				administred_batch_id = (String)administred_batch.get("BATCH_ID");						
				if(administred_batch_id == null)administred_batch_id="";
					disp_batch_id		 = (String)administred_batch.get("DISP_BATCH_ID");	
		
				if(iv_prep_yn.equals("2") ||iv_prep_yn.equals("4")){	
					work_sheet_batch_det  =(ArrayList)bean.getProductName(order_id,order_line_num);
		
					if(work_sheet_batch_det!=null && work_sheet_batch_det.size()>0){
					prod_name	=	(String)work_sheet_batch_det.get(0);
					batch_id	=	(String)work_sheet_batch_det.get(1);								
					expiry_date	=	(String)work_sheet_batch_det.get(2);
					drug_code	= "FINAL PRODUCT";
					}
				}
				else{
					prod_name	=	"";
					expiry_date=expiry_date.trim();
				 }
	  
				if(!adr_record_time.equals("") && !adr_reason.equals("")){
					adr_reason	=	admin_bean.getReasonDesc("M",adr_reason);

					adr_details	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.AgnstSchedDate.label", "ph_labels")+": " + com.ehis.util.DateUtils.convertDate(against_sch_date,"DMYHM","en",locale)+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.PostAdmnRsn.label", "ph_labels")+": "+adr_reason+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.remarks.label", "common_labels")+": "+adr_remarks.replaceAll("\"",demostring)+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.recordeddate.label", "common_labels")+": "+adr_record_time+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.RecordedBy.label", "common_labels")+": "+adr_recorded_by;
					adminStatus="PAD";
					admin_rec_disp = "display:inline";
				}
				else{
					admin_rec_disp = "display:none";
					adminStatus="";
					adr_details="";
				}
//added for MMS-KH-CRF-0010 start
if((iv_prep_yn.equals("3")||iv_prep_yn.equals("4"))){
				pres_remarks			= bean.getPrescriptionInstructions(order_id);
				drug_remarks			= bean.getDrugInstructions(order_id,"2");
				prn_remarks				= bean.getPRNInstructions(order_id,"2");
				pharma_remarks			= bean.getPharmacistInstructions(order_id,"2");
				slidingscaleremarks		= bean_all_stages.getSlidingScaleRemarks(order_id,"2");
				verificationremarks		= bean_all_stages.getVerificationRemarks(order_id,"2");	
				
				
				nonMfrFluidRemarks		= "";
				overridereason			= (HashMap)bean_all_stages.getOverrideremarks(order_id,"2");
}
else{
	pres_remarks			= bean.getPrescriptionInstructions(order_id);
	drug_remarks			= bean.getDrugInstructions(order_id,order_line_num);
	prn_remarks				= bean.getPRNInstructions(order_id,order_line_num);
	pharma_remarks			= bean.getPharmacistInstructions(order_id,order_line_num);
	slidingscaleremarks		= bean_all_stages.getSlidingScaleRemarks(order_id,order_line_num);
	verificationremarks		= bean_all_stages.getVerificationRemarks(order_id,order_line_num);	
	
	
	nonMfrFluidRemarks		= "";
	overridereason			= (HashMap)bean_all_stages.getOverrideremarks(order_id,order_line_num);
}
				show_remarks = bean.getShowRemarks(show_remarks,overridereason);
				
				int pres_size = pres_remarks.length();
				int pres_col=2;
				if(pres_size >239)
					pres_col = pres_size/120;
					
				int pharm_size = pharma_remarks.length();
				int pharm_col=2;
				if(pharm_size >239)
					pharm_col = pharm_size/120;
									
				if(drug_remarks.trim().equals("") && pharma_remarks.trim().equals("") && pres_remarks.trim().equals("") && prn_remarks.trim().equals("")&& slidingscaleremarks.trim().equals("")&& verificationremarks.equals("")&&show_remarks.equals("N") && nonMfrFluidRemarks.equals("")){
					remarks_style	=	"style='visibility:hidden'";
				}
				else {
					dialog_height = 0 ;
					remarks_style	=	"style='visibility:visible'";

					dialog_height	 = bean.getDialogHeight(prn_remarks,drug_remarks,pres_remarks,slidingscaleremarks , pharma_remarks, verificationremarks, nonMfrFluidRemarks, show_remarks , dialog_height,pharm_col);
		
					dialog_height	 += 1.4;
				} 
			
				if(Float.parseFloat(qty) < 1.0)
					qty = Float.parseFloat(qty)+""; //to prefix a zero

				if ((orderCount+1) % 2 == 0 )
					classvalue = "QRYODD" ;
				else
					classvalue = "QRYEVEN" ;	
				if(order_line_num.equals("1"))
					IVclassvalue="IVFLUID1";
				else
					IVclassvalue="IVINGREDIENT1";
				stDispHand="cursor:pointer;";
				displayStyle = "";
				if(schCanAdmin.equals("Y")){
					/*if( !mar_disc_dose_yn.equals("Y") && discontinued.equals("Y") && !sch_date_time.equals(ord_disc_date_time))
						displayStyle = "";
					else*/
					displayStyle = "COLOR:blue;text-decoration:underline;";
				}
				stDispHand="cursor:pointer;";
				if(hold.equals("Y") || (!mar_disc_dose_yn.equals("Y") && discontinued.equals("Y")&& !sch_date_time.equals(ord_disc_date_time)))
					stDispHand="";
				if(administered_yn.equals("Y") && !admin_drug_code.equals("") && !admin_drug_code.equals(drug_code) ){
					showAlt	 = ("Administered Drug : "+dispensed_drug_desc+"\n");
					showTitle.insert(0, showAlt );
					displayStyle = "BACKGROUND-COLOR:#CC99CC;COLOR:white;";
				}
				else if(admin_recorded_yn.equals("Y")){
					if(administered_yn.equals("N")) 
						displayStyle = "BACKGROUND-COLOR:#000000;COLOR:white;";
					else {
						displayStyle = "BACKGROUND-COLOR:green;COLOR:white;";
						if(discontinued.equals("Y") && com.ehis.util.DateUtils.isAfter(sch_date_time, ord_disc_date_time, "DMYHM", locale ))
							displayStyle = "BACKGROUND-COLOR:green;COLOR:Red;";
						if(hold.equals("Y") && com.ehis.util.DateUtils.isAfter(sch_date_time, ord_hold_date_time, "DMYHM", locale ))
							displayStyle = "BACKGROUND-COLOR:green;COLOR:yellow;";
					}
				}
				else if(discontinued.equals("Y")&& com.ehis.util.DateUtils.isAfter(sch_date_time, ord_disc_date_time, "DMYHM", locale )){
					displayStyle = "BACKGROUND-COLOR:red;COLOR:blue;";
					if(sch_date_time.equals(ord_disc_date_time))
						stDispHand = "cursor:pointer;";
					else
						stDispHand="";
				}
				else if(hold.equals("Y") && com.ehis.util.DateUtils.isAfter(sch_date_time, ord_hold_date_time, "DMYHM", locale )) {
					displayStyle = "BACKGROUND-COLOR:yellow;";
					stDispHand="";
				}
				if(sch==0 ){

            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(rowsPan));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(start_date_time));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(rowsPan));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(end_date_time));
            _bw.write(_wl_block32Bytes, _wl_block32);

					}

					if(!(iv_prep_yn.equals("3")||iv_prep_yn.equals("4"))){

            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(IVclassvalue));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(drug_class_ind));
            _bw.write(_wl_block35Bytes, _wl_block35);

							if (!(iv_prep_yn.equals("0")||iv_prep_yn.equals("2")||iv_prep_yn.equals("4")||iv_prep_yn.equals("6"))){

            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(sch));
            _bw.write(_wl_block39Bytes, _wl_block39);

							}

            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(prod_name));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block42Bytes, _wl_block42);

							if(ext_prod_id!=null && !ext_prod_id.equals("")&& !(iv_prep_yn.equals("2")||iv_prep_yn.equals("4"))){

            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(ext_prod_id));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(encode_drug_desc));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.DrugInformation.label", "ph_labels")));
            _bw.write(_wl_block46Bytes, _wl_block46);

							}
							if(imageFileURL!=null && !imageFileURL.equals("")){

            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(trade_code));
            _bw.write(_wl_block48Bytes, _wl_block48);

							}
							if(adr_count>0){

            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(patient_id_test));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block51Bytes, _wl_block51);

							} 

							 if(prod_name.length()==0){
								if(!(iv_prep_yn.equals("0")||iv_prep_yn.equals("2")||iv_prep_yn.equals("4")||iv_prep_yn.equals("6"))){

            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block48Bytes, _wl_block48);
													
								}
							}

            _bw.write(_wl_block53Bytes, _wl_block53);

							if(linkVacScheduleYN.equals("Y")){ 
								if(order_line_num.equals("1")){

            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(linkVacScheduleDescToolTip));
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(linkVacScheduleDesc));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block63Bytes, _wl_block63);

								}
							}
							if(dispensed_drug_desc!=null && !dispensed_drug_desc.equals("")){

            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(disp_drugs));
            _bw.write(_wl_block65Bytes, _wl_block65);

							}
							if(order_line_num.equals("1")){

            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(qty_uom));
            _bw.write(_wl_block69Bytes, _wl_block69);

							}

            _bw.write(_wl_block70Bytes, _wl_block70);
if(viewAdminRemarks){ 
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(dialog_height));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_desc,"UTF-8")));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Remarks.label", "ph_labels")));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(remarks_style));
            _bw.write(_wl_block75Bytes, _wl_block75);
} 
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(sch_infusion_rate));
            _bw.write(_wl_block77Bytes, _wl_block77);

							if(!MfrYN.equals("Y")){

            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(sch_infusion_vol_str_unit_desc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(sch_infusion_per_unit));
            _bw.write(_wl_block1Bytes, _wl_block1);

							}

            _bw.write(_wl_block79Bytes, _wl_block79);

						if(order_line_num.equals("1")){

            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(rowsPan));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(fntColor));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(backGrndColor));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(route_desc));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(rowsPan));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(freq_desc));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(rowsPan));
            _bw.write(_wl_block89Bytes, _wl_block89);

						}
					}
					else if(iv_prep_yn.equals("3")|| iv_prep_yn.equals("4")){
						ivnextRow = false;
						if(sch==0 || (ivRowCount == fluidRowspan && uniqueSchedules.contains(schTime))){
							if(sch!=0 &&(ivRowCount== fluidRowspan && alIVPBDrugSchList!=null && alIVPBDrugSchList.size()>0)){ //Drug display
								IVclassvalue="IVINGREDIENT1";
								alTmpIVPBDrugDtls = (ArrayList)alIVPBDrugSchList.get(0);
								ivPB_drug_code                =   (String)alTmpIVPBDrugDtls.get(10);
								ivPB_drug_desc                =   (String)alTmpIVPBDrugDtls.get(11);
								ivPB_encode_drug_desc         =   ivPB_drug_desc.replaceAll(" ","%20");
								ivPB_encode_drug_desc         =   java.net.URLEncoder.encode(ivPB_encode_drug_desc,"UTF-8");
								ivPB_encode_drug_desc         =   ivPB_encode_drug_desc.replaceAll("%2520","%20");						
								ivPB_ext_prod_id              =   (String)alTmpIVPBDrugDtls.get(44);
								iv_no_of_drug_per_order  =   (String)alTmpIVPBDrugDtls.get(45);
								ivPB_trade_code			     =   (String)alTmpIVPBDrugDtls.get(46);
								ivPB_imageFileURL			 =   (String)alTmpIVPBDrugDtls.get(47);
								drug_class = (String)alTmpIVPBDrugDtls.get(31);
								drug_class_ind = bean.getDrugClassInd(drug_class);
								adr_count			= bean.getADRCount(patient_id_test,ivPB_drug_code); 
								ivPB_sch_infusion_rate = bean.getIVPBSchInfusionRate((String)alTmpIVPBDrugDtls.get(1));
								sch_infusion_vol_str_unit	= (String)alTmpIVPBDrugDtls.get(2);
								ivPB_sch_infusion_vol_str_unit_desc = (String)alTmpIVPBDrugDtls.get(66);
								
								 ivPB_sch_infusion_per_unit = bean.getIVPBschInfusionUnit((String)alTmpIVPBDrugDtls.get(3));

								ivPB_qty						 =	 (String)alTmpIVPBDrugDtls.get(16);
								if(Float.parseFloat(ivPB_qty) < 1)
									ivPB_qty="0"+ivPB_qty; 

								if(Float.parseFloat(ivPB_qty) < 1.0)
									ivPB_qty = Float.parseFloat(ivPB_qty)+""; //to prefix a zero
								ivPB_qty_uom					 =	 (String)alTmpIVPBDrugDtls.get(17);
								if(sch!=0 ){
									ivnextRow = true;
									for(;schDayCount<(daySize/2); schDayCount++){

            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(freqRowspan));
            _bw.write(_wl_block89Bytes, _wl_block89);

									}

            _bw.write(_wl_block91Bytes, _wl_block91);

									schDayCount=0;
									dayCount = 0;
								}

            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(IVclassvalue));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(drug_class_ind));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(drugRowspan));
            _bw.write(_wl_block94Bytes, _wl_block94);

								if (!iv_prep_yn.equals("4")){

            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(ivPB_drug_code));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block39Bytes, _wl_block39);

								}

            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(prod_name));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(ivPB_drug_desc));
            _bw.write(_wl_block42Bytes, _wl_block42);

								if( !ivPB_ext_prod_id.equals("")&& !iv_prep_yn.equals("4")){

            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(ivPB_ext_prod_id));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(ivPB_encode_drug_desc));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.DrugInformation.label", "ph_labels")));
            _bw.write(_wl_block46Bytes, _wl_block46);

								}
								if( !ivPB_imageFileURL.equals("")){

            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(ivPB_drug_code));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(ivPB_trade_code));
            _bw.write(_wl_block48Bytes, _wl_block48);

								}
								if(adr_count>0){

            _bw.write(_wl_block99Bytes, _wl_block99);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(patient_id_test));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(ivPB_drug_code));
            _bw.write(_wl_block51Bytes, _wl_block51);

								} 
								if(!iv_prep_yn.equals("4")){

            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(ivPB_drug_code));
            _bw.write(_wl_block48Bytes, _wl_block48);
													
								}

            _bw.write(_wl_block100Bytes, _wl_block100);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(ivPB_qty));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(ivPB_qty_uom));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(drugRowspan));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(ivPB_sch_infusion_rate));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(ivPB_sch_infusion_vol_str_unit_desc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(ivPB_sch_infusion_per_unit));
            _bw.write(_wl_block32Bytes, _wl_block32);

							}
							else{ //Fluid Display
								if(sch!=0 ){
									ivnextRow = true;
									for(;schDayCount<(daySize/2); schDayCount++){

            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(freqRowspan));
            _bw.write(_wl_block89Bytes, _wl_block89);

									}

            _bw.write(_wl_block91Bytes, _wl_block91);

									schDayCount=0;
									dayCount = 0;
								}

            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(IVclassvalue));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(drug_class_ind));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(fluidRowspan));
            _bw.write(_wl_block94Bytes, _wl_block94);

									if (!(iv_prep_yn.equals("0")||iv_prep_yn.equals("2")||iv_prep_yn.equals("4")||iv_prep_yn.equals("6"))){

            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block39Bytes, _wl_block39);

									}

            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(prod_name));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block42Bytes, _wl_block42);

									if(ext_prod_id!=null && !ext_prod_id.equals("")&& !(iv_prep_yn.equals("2")||iv_prep_yn.equals("4"))){

            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(ext_prod_id));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(encode_drug_desc));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.DrugInformation.label", "ph_labels")));
            _bw.write(_wl_block46Bytes, _wl_block46);

									}
									if(imageFileURL!=null && !imageFileURL.equals("")){

            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(trade_code));
            _bw.write(_wl_block48Bytes, _wl_block48);

									}
									if(adr_count>0){

            _bw.write(_wl_block108Bytes, _wl_block108);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(patient_id_test));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block51Bytes, _wl_block51);

									} 
									if(prod_name.length()==0 && !iv_prep_yn.equals("4")){

            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block48Bytes, _wl_block48);
													
									}
									if(dispensed_drug_desc!=null && !dispensed_drug_desc.equals("")){

            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(disp_drugs));
            _bw.write(_wl_block111Bytes, _wl_block111);

									}

            _bw.write(_wl_block112Bytes, _wl_block112);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(qty_uom));
            _bw.write(_wl_block113Bytes, _wl_block113);
if(viewAdminRemarks){ 
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(rowsPan));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(dialog_height));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_desc,"UTF-8")));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Remarks.label", "ph_labels")));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(remarks_style));
            _bw.write(_wl_block118Bytes, _wl_block118);
} 
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(fluidRowspan));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(sch_infusion_rate));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(sch_infusion_vol_str_unit_desc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(sch_infusion_per_unit));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(rowsPan));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(fntColor));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(backGrndColor));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(route_desc));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(rowsPan));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(freq_desc));
            _bw.write(_wl_block124Bytes, _wl_block124);

							}
						}
					}
						if(order_line_num.equals("1") || iv_prep_yn.equals("3")|| iv_prep_yn.equals("4")) {
							if(uniqueSchedules!=null){
								if(uniqueSchedules.contains(schTime)){
									uniqueSchedules.remove(schTime);
									ivRowCount++;
									if(iv_prep_yn.equals("3")||iv_prep_yn.equals("4")){
										if(sch!=0 && !ivnextRow){
											ivnextRow = false;
											for(;schDayCount<(daySize/2); schDayCount++){

            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block126Bytes, _wl_block126);

											}

            _bw.write(_wl_block127Bytes, _wl_block127);

										}

            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(freqRowspan));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(schTime));
            _bw.write(_wl_block32Bytes, _wl_block32);

										schDayCount=0;
										dayCount = 0;
										schCount++;
									}
								}
								nextDaySch = false;
								drugCount=1;
								if(sfrFLOW_STATUS.equals("NS")){
									sfrFLOW_STATUS_String="";
								}
								else if(sfrFLOW_STATUS.equals("ST")){
									sfrFLOW_STATUS_String=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.STARTED.label","ph_labels");
								}
								else if(sfrFLOW_STATUS.equals("HO")){
									sfrFLOW_STATUS_String=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Hold.label","ph_labels");
								}
								else if(sfrFLOW_STATUS.equals("RE")){
									sfrFLOW_STATUS_String=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.RESUMED.label","ph_labels");
								}
								if(sfrFLOW_STATUS.equals("CO") || sfrFLOW_STATUS.equals("AD") || administered_yn.equals("Y")){
									sfrFLOW_STATUS_String = "";
									stDispHand = "BACKGROUND-COLOR:green;COLOR:white;;cursor:pointer;";
								}
								ivSchDispStatus="";
								if(!sfrFLOW_STATUS.equals("NS") && !sfrFLOW_STATUS.equals("CO"))
									ivSchDispStatus = sfrFLOW_STATUS_String+" <br> </label><label style='vertical-align:middle;' >";
								if(alIVPBDrugSchList!=null && alIVPBDrugSchList.size()>sch && !iv_prep_yn.equals("4"))
									drugCount=2;
								for(int day=(dayCount*2); day<daySize; day+=2){
									dispDate = (String)altDateDayList.get(day);
									scheKey = order_id+"_"+order_line_num+"_"+schCount+"_"+schDayCount+"_"+sch;//sch Added for identified issues fix
									if((com.ehis.util.DateUtils.isAfter(schDate, dispDate, "DMY", locale) ) && schDayCount ==dayCount){
										schDayCount++;
										dayCount++;
										if(dispDate.equals(schDate)){
											if(iv_prep_yn.equals("3")|| iv_prep_yn.equals("4")){
												if(!schCanAdmin.equals("Y")){
													if(administered_yn.equals("Y")){ //IV PiggyPack administered td

            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(freqRowspan));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(stDispHand));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(showTitle.toString()));
            _bw.write(_wl_block94Bytes, _wl_block94);

															if(sfrFLOW_STATUS.equals("CO") || sfrFLOW_STATUS.equals("AD")){

            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(stDispHand));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(cancelYn));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(admin_by_name));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_desc,"UTF-8")));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(admin_date_time));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(strength_per_value_pres_uom));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(patient_id_test));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(schTime));
            _bw.write(_wl_block139Bytes, _wl_block139);

															}
															else{
																if(marForDisPatNotReqYN && dischargedYN){ // if Added for KH-SCF-0010 - Start

            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(displayStyle));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(schTime));
            _bw.write(_wl_block142Bytes, _wl_block142);

																} // if Added for KH-SCF-0010 - End
																else{//cancelYn,admin_by_name,drug_desc added for JD-CRF-0200

            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(displayStyle));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(administered_yn));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(admin_recorded_yn));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(sch));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(sfrFLOW_STATUS));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(cancelYn));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(admin_by_name));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_desc,"UTF-8")));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(schTime));
            _bw.write(_wl_block148Bytes, _wl_block148);

																}
																}

            _bw.write(_wl_block149Bytes, _wl_block149);
if(cancel_recorded_yn_3.equals("Y")){
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_desc,"UTF-8")));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(patient_id_test));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(admin_date_time));
            _bw.write(_wl_block151Bytes, _wl_block151);
} 
            _bw.write(_wl_block152Bytes, _wl_block152);

													}
													else{ //IV PiggyPack can not admin td

            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(freqRowspan));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(stDispHand));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(stDispHand));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(displayStyle));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(schTime));
            _bw.write(_wl_block156Bytes, _wl_block156);

													}
												}
												else{ //IV PiggyPack can admin td

            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(freqRowspan));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(stDispHand));
            _bw.write(_wl_block94Bytes, _wl_block94);

															if(sfrFLOW_STATUS.equals("CO") || sfrFLOW_STATUS.equals("AD") || administered_yn.equals("Y")){

            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(stDispHand));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(cancelYn));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(admin_by_name));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_desc,"UTF-8")));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(admin_date_time));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(strength_per_value_pres_uom));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(patient_id_test));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(schTime));
            _bw.write(_wl_block139Bytes, _wl_block139);

															}
															else{
																if(marForDisPatNotReqYN && dischargedYN){ // if Added for KH-SCF-0010 - Start

            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(stDispHand));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(displayStyle));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(ivSchDispStatus));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(schTime));
            _bw.write(_wl_block142Bytes, _wl_block142);

																} // if Added for KH-SCF-0010 - End
															else{

            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(stDispHand));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(displayStyle));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(administered_yn));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(admin_recorded_yn));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(sch));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(sfrFLOW_STATUS));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(ivSchDispStatus));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(schTime));
            _bw.write(_wl_block142Bytes, _wl_block142);

															}
												        }

            _bw.write(_wl_block166Bytes, _wl_block166);
if(cancel_recorded_yn_3.equals("Y")){
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_desc,"UTF-8")));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(patient_id_test));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(admin_date_time));
            _bw.write(_wl_block168Bytes, _wl_block168);
}
            _bw.write(_wl_block169Bytes, _wl_block169);

												}
												drugCount=1;

            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(modified_date_time));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(end_date_time));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(next_schd_date));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(sfrACT_START_DATE_TIME));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(sch_infusion_rate));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(sch_infusion_vol_str_unit));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(sch_infusion_vol_str_unit_desc));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(sch_infusion_per_unit_table_date));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(sch_infusion_period));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(sch_infusion_period_unit));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(batch_id));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(expiry_date));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(batch_id));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(trade_name));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(trade_id));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(iv_no_of_drug_per_order));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(sfrFLOW_STATUS));
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(sfrHOLD_DATE_TIME));
            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(sfrHOLD_DURN_IN_MINS));
            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(sfrRESUME_DATE_TIME));
            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(sfrACT_END_DATE_TIME));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(dosage_type));
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(completedMinutes));
            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(completedFlow));
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf((Float.parseFloat(qty)+"")));
            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(qty_uom));
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block254Bytes, _wl_block254);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(iv_sch_date_tim));
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf((String)iv_drug_details.get(10)));
            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block258Bytes, _wl_block258);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf((String)iv_drug_details.get(8)));
            _bw.write(_wl_block259Bytes, _wl_block259);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block261Bytes, _wl_block261);
            out.print( String.valueOf((String)iv_drug_details.get(14)));
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf((String)iv_drug_details.get(15)));
            _bw.write(_wl_block264Bytes, _wl_block264);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block265Bytes, _wl_block265);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf((String)iv_drug_details.get(31)));
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(linkVacScheduleCode));
            _bw.write(_wl_block94Bytes, _wl_block94);

												if(alIVPBDrugSchList!=null && alIVPBDrugSchList.size()>sch && !iv_prep_yn.equals("4")){
													iv_drug_details =(ArrayList)alIVPBDrugSchList.get(sch);
													drugCount++;
													admin_recorded_yn  = (String)iv_drug_details.get(23);
													sch_infusion_rate			= (String)iv_drug_details.get(1);
													iv_sch_date_tim      = (String)iv_drug_details.get(12);//Added for SKR-SCF-0913[Inc : 46556]

													if(sch_infusion_rate!= null && !(sch_infusion_rate.equals(""))){
														if(Float.parseFloat(sch_infusion_rate) < 1.0){ 
															sch_infusion_rate = Float.parseFloat(sch_infusion_rate)+"";
														}
													}
													sch_date_time            =   (String)iv_drug_details.get(12);
													qty						 =	 (String)iv_drug_details.get(16);
													if(Float.parseFloat(qty) < 1)
														qty="0"+qty; 

													qty_uom					 =	 (String)iv_drug_details.get(17);
													discontinued			 =	 (String)iv_drug_details.get(18);
													hold					 =	 (String)iv_drug_details.get(19);
													sch_infusion_period		 =	 (String)iv_drug_details.get(20);		
													
													sch_infusion_period_unit =	 (String)iv_drug_details.get(21);
													administered_yn			 =	 (String)iv_drug_details.get(22);
													end_date_time 			 =   (String)iv_drug_details.get(33);
													start_date_time			=	(String)iv_drug_details.get(69);
													iv_no_of_drug_per_order  =   (String)iv_drug_details.get(45);
													
													
													next_schd_date =   bean.getNextSchdate(order_id,order_line_num,Integer.parseInt(dosage_seq_no.trim()),sch_date_time);
													//sfrFLOW_STATUS			 =	(String)iv_drug_details.get(55);
													sfrHOLD_DATE_TIME		 =	(String)iv_drug_details.get(56);
													sfrHOLD_DURN_IN_MINS	 =	(String)iv_drug_details.get(57);
													if(sfrHOLD_DURN_IN_MINS.equals(""))
														sfrHOLD_DURN_IN_MINS="0";
													sfrRESUME_DATE_TIME		 =	(String)iv_drug_details.get(58);
													sfrACT_START_DATE_TIME	 =	(String)iv_drug_details.get(59);
													if(!(sfrACT_START_DATE_TIME.equals(""))){
														sfrACT_START_DATE_TIME=com.ehis.util.DateUtils.convertDate(sfrACT_START_DATE_TIME,"DMYHM","en",locale);
													}
													
													if(sfrACT_START_DATE_TIME.equals("")){
														sfrACT_START_DATE_TIME=current_date_time;
													}
													sfrACT_END_DATE_TIME	 =(String)iv_drug_details.get(60);
													dosage_type				 =(String)iv_drug_details.get(61);
													mfrRemarks				 =	(String)iv_drug_details.get(62);
													completedMinutes		 =	(String)iv_drug_details.get(63);
													if(completedMinutes.equals(""))
														completedMinutes = "0";
													completedFlow			 =	(String)iv_drug_details.get(64);
													if(completedFlow.equals(""))
														completedFlow = "0";
													adr_count			= bean.getADRCount(patient_id_test,drug_code);   
													schDate			 =	(String)iv_drug_details.get(71);
													ord_hold_date_time			 =	(String)iv_drug_details.get(75);
													ord_disc_date_time			 =	(String)iv_drug_details.get(76);

													if(!mfrRemarks.equals(""))
														mfrRemarks=java.net.URLEncoder.encode(mfrRemarks,"UTF-8");
													remarks = iv_drug_details.get(24)==null?"Not Entered":(String)iv_drug_details.get(24);				
										admin_by_name   = (String)iv_drug_details.get(26);
										auth_by_name    = (String)iv_drug_details.get(32);
										if(showTitle.length()>0)
											showTitle.setLength(0);
										if(remarks!=null && !remarks.equals(""))
											showTitle.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.remarks.label", "common_labels")+"  : "+remarks+"\n ");
										if(admin_by_name!=null && !admin_by_name.equals(""))
											showTitle.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.AdministeredBy.label", "common_labels")+"   : "+admin_by_name);
										if(auth_by_name!=null && !auth_by_name.equals("")){
											showTitle.append("\n "+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.authorizedby.label", "common_labels")+"  : "+auth_by_name);
										}
													//ADDED FOR MMS-KH-CRF-0010 START
													pres_remarks			= bean.getPrescriptionInstructions(order_id);
													drug_remarks			= bean.getDrugInstructions(order_id,order_line_num);
													prn_remarks				= bean.getPRNInstructions(order_id,order_line_num);
													pharma_remarks			= bean.getPharmacistInstructions(order_id,order_line_num);
													slidingscaleremarks		= bean_all_stages.getSlidingScaleRemarks(order_id,order_line_num);
													verificationremarks		= bean_all_stages.getVerificationRemarks(order_id,order_line_num);	
													
									nonMfrFluidRemarks		= "";
													//if(iv_prep_yn.equals("5")){
														nonMfrFluidRemarks		= bean_all_stages.getNonMFRfluidRemarks(order_id,order_line_num);
													//}
													overridereason			= (HashMap)bean_all_stages.getOverrideremarks(order_id,"2");
													
											show_remarks = bean.getShowRemarks(show_remarks,overridereason);

									if(drug_remarks.trim().equals("") && pharma_remarks.trim().equals("") && pres_remarks.trim().equals("") && prn_remarks.trim().equals("")&& slidingscaleremarks.trim().equals("")&& verificationremarks.equals("")&&show_remarks.equals("N") && nonMfrFluidRemarks.equals("")){
														remarks_style	=	"style='visibility:hidden'";
													}
													else {
														dialog_height = 0 ;
														remarks_style	=	"style='visibility:visible'";

					dialog_height	 = bean.getDialogHeight(prn_remarks,drug_remarks,pres_remarks,slidingscaleremarks , pharma_remarks, verificationremarks, nonMfrFluidRemarks, show_remarks , dialog_height,pharm_col);											
														dialog_height	 += 1.4;
													} 
													//ADDED FOR MMS-KH-CRF-0010
													admin_date_time = "";
													if(iv_drug_details.get(27)!= null)
														admin_date_time = (String)iv_drug_details.get(27);
													modified_date_time = "";
													if(iv_drug_details.get(28)!= null)
														modified_date_time = (String)iv_drug_details.get(28);	
														linkVacScheduleCode		 =	(String)iv_drug_details.get(53);
														if(!(linkVacScheduleCode==null || linkVacScheduleCode.equals(""))){
															linkVacScheduleCode1=linkVacScheduleCode.substring(0,10);									
															if(!linkVacScheduleCode1.equals("NO DEFAULT")){
																try{
																	linkVacScheduleYN="Y";
																	vacScheduleDetails=linkVacScheduleCode.split("~",6);
																	if(vacScheduleDetails.length>0){
																		linkVacScheduleCode=vacScheduleDetails[0]+"~"+vacScheduleDetails[1]+"~"+vacScheduleDetails[2]+"~"+vacScheduleDetails[5];
																		linkVacScheduleDescToolTip=vacScheduleDetails[3];
																		linkVacScheduleDesc=vacScheduleDetails[4];
																	}
																}
																catch(Exception execu){
																	execu.printStackTrace();
																}
															}
															else{
																linkVacScheduleYN="Y";
																linkVacScheduleDescToolTip="";
																linkVacScheduleDesc="";
																vacScheduleDetails=linkVacScheduleCode.split("~");
																if(vacScheduleDetails.length>0){
																	linkVacScheduleCode=vacScheduleDetails[1];
																}										
															}
														}
														else{
															linkVacScheduleYN="N";
															linkVacScheduleDescToolTip="";
															linkVacScheduleDesc="";
														}	

            _bw.write(_wl_block269Bytes, _wl_block269);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(modified_date_time));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(end_date_time));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(next_schd_date));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(sfrACT_START_DATE_TIME));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(sch_infusion_rate));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(sch_infusion_vol_str_unit));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(sch_infusion_vol_str_unit_desc));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(sch_infusion_per_unit_table_date));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(sch_infusion_period));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(sch_infusion_period_unit));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(batch_id));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(expiry_date));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(batch_id));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(trade_name));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(trade_id));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(iv_no_of_drug_per_order));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(sfrFLOW_STATUS));
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(sfrHOLD_DATE_TIME));
            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(sfrHOLD_DURN_IN_MINS));
            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(sfrRESUME_DATE_TIME));
            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(sfrACT_END_DATE_TIME));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(dosage_type));
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(completedMinutes));
            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(completedFlow));
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf((Float.parseFloat(qty)+"")));
            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(qty_uom));
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block254Bytes, _wl_block254);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(iv_sch_date_tim));
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf((String)iv_drug_details.get(10)));
            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block258Bytes, _wl_block258);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf((String)iv_drug_details.get(8)));
            _bw.write(_wl_block259Bytes, _wl_block259);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block261Bytes, _wl_block261);
            out.print( String.valueOf((String)iv_drug_details.get(14)));
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf((String)iv_drug_details.get(15)));
            _bw.write(_wl_block264Bytes, _wl_block264);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block265Bytes, _wl_block265);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf((String)iv_drug_details.get(31)));
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(linkVacScheduleCode));
            _bw.write(_wl_block94Bytes, _wl_block94);

												}
											}
											else{
												if(MfrYN.equals("Y") ){
													MfrDetails=bean.getStatusOfMAR(order_id,"SCH");
													statusString="";
													displayStyle_1 = "color:blue;cursor:pointer;align:center;";//GHL-CRF-0458
													if(MfrDetails.size()>0){
														statusString=(String)MfrDetails.get(0);
														mfrCompletedStatus=new Boolean((String)MfrDetails.get(1)).booleanValue();
														MFRCount=(String)MfrDetails.get(2);
													}
														if(!(hold.equals("Y")) && !(discontinued.equals("Y"))){													
																if(WardAckMarRequiredYn.equalsIgnoreCase("Y")){ //GHL-CRF-0458 - start // isSiteSpecMARPrint changed to WardAckMarRequiredYn.equalsIgnoreCase("Y") for MMS-KH-CRF-0014 [IN:067953] 
																	
																patient_class_ord = bean.getOrderPatientClass(order_id);
																if(patient_class_ord==null)
																	patient_class_ord = "";
																if(patient_class_ord.equals("IP")){
																	ack_yn		 = bean.getAcknowlegeYN(order_id,order_line_num,iv_prep_yn); //iv_prep-yn added for MMS-KH-CRF-0039
																}


																if( WardAckMarRequiredYn.equalsIgnoreCase("Y") && !ack_yn.equals("A") && patient_class_ord.equals("IP")){
																	statusString = "";
																	displayStyle_1 ="color:blue;cursor:pointer;align:center;display:none"; 
																}
																	//GHL-CRF-0458 - end
																}
																if(marForDisPatNotReqYN && dischargedYN){ // if Added for KH-SCF-0010 - Start

            _bw.write(_wl_block270Bytes, _wl_block270);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block271Bytes, _wl_block271);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(rowsPan));
            _bw.write(_wl_block272Bytes, _wl_block272);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block273Bytes, _wl_block273);
            out.print( String.valueOf(stDispHand));
            _bw.write(_wl_block274Bytes, _wl_block274);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block275Bytes, _wl_block275);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block276Bytes, _wl_block276);
            out.print( String.valueOf(displayStyle_1));
            _bw.write(_wl_block277Bytes, _wl_block277);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block278Bytes, _wl_block278);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block279Bytes, _wl_block279);

																} // if Added for KH-SCF-0010 - End
															   else{
            _bw.write(_wl_block280Bytes, _wl_block280);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block271Bytes, _wl_block271);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(rowsPan));
            _bw.write(_wl_block272Bytes, _wl_block272);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block273Bytes, _wl_block273);
            out.print( String.valueOf(stDispHand));
            _bw.write(_wl_block274Bytes, _wl_block274);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block275Bytes, _wl_block275);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block276Bytes, _wl_block276);
            out.print( String.valueOf(displayStyle_1));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(administered_yn));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(admin_recorded_yn));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(sch));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(sfrFLOW_STATUS));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block281Bytes, _wl_block281);
            out.print( String.valueOf(cancelYn));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(admin_by_name));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block147Bytes, _wl_block147);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block282Bytes, _wl_block282);
            out.print( String.valueOf(statusString));
            _bw.write(_wl_block283Bytes, _wl_block283);
            out.print( String.valueOf(mfrRemarks));
            _bw.write(_wl_block284Bytes, _wl_block284);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block278Bytes, _wl_block278);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block285Bytes, _wl_block285);
                                                       }
														}
														else {
															mfrCompletedStatus=false;

            _bw.write(_wl_block286Bytes, _wl_block286);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(rowsPan));
            _bw.write(_wl_block272Bytes, _wl_block272);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block273Bytes, _wl_block273);
            out.print( String.valueOf(stDispHand));
            _bw.write(_wl_block274Bytes, _wl_block274);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block275Bytes, _wl_block275);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block287Bytes, _wl_block287);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block288Bytes, _wl_block288);
            out.print( String.valueOf(statusString));
            _bw.write(_wl_block283Bytes, _wl_block283);
            out.print( String.valueOf(mfrRemarks));
            _bw.write(_wl_block284Bytes, _wl_block284);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block278Bytes, _wl_block278);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block289Bytes, _wl_block289);

														}

            _bw.write(_wl_block290Bytes, _wl_block290);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block291Bytes, _wl_block291);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block292Bytes, _wl_block292);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(modified_date_time));
            _bw.write(_wl_block293Bytes, _wl_block293);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block294Bytes, _wl_block294);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(end_date_time));
            _bw.write(_wl_block295Bytes, _wl_block295);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(next_schd_date));
            _bw.write(_wl_block296Bytes, _wl_block296);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block297Bytes, _wl_block297);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block298Bytes, _wl_block298);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block299Bytes, _wl_block299);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block300Bytes, _wl_block300);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(sfrACT_START_DATE_TIME));
            _bw.write(_wl_block301Bytes, _wl_block301);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(sch_infusion_rate));
            _bw.write(_wl_block302Bytes, _wl_block302);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(sch_infusion_vol_str_unit));
            _bw.write(_wl_block303Bytes, _wl_block303);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(sch_infusion_vol_str_unit_desc));
            _bw.write(_wl_block304Bytes, _wl_block304);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(sch_infusion_per_unit_table_date));
            _bw.write(_wl_block305Bytes, _wl_block305);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(sch_infusion_period));
            _bw.write(_wl_block306Bytes, _wl_block306);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(sch_infusion_period_unit));
            _bw.write(_wl_block307Bytes, _wl_block307);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(batch_id));
            _bw.write(_wl_block308Bytes, _wl_block308);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(expiry_date));
            _bw.write(_wl_block309Bytes, _wl_block309);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block310Bytes, _wl_block310);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(batch_id));
            _bw.write(_wl_block311Bytes, _wl_block311);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block312Bytes, _wl_block312);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(trade_name));
            _bw.write(_wl_block313Bytes, _wl_block313);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(trade_id));
            _bw.write(_wl_block314Bytes, _wl_block314);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block315Bytes, _wl_block315);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block316Bytes, _wl_block316);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(iv_no_of_drug_per_order));
            _bw.write(_wl_block317Bytes, _wl_block317);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(sfrFLOW_STATUS));
            _bw.write(_wl_block318Bytes, _wl_block318);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(sfrHOLD_DATE_TIME));
            _bw.write(_wl_block319Bytes, _wl_block319);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(sfrHOLD_DURN_IN_MINS));
            _bw.write(_wl_block320Bytes, _wl_block320);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block321Bytes, _wl_block321);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block322Bytes, _wl_block322);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(sfrRESUME_DATE_TIME));
            _bw.write(_wl_block323Bytes, _wl_block323);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block324Bytes, _wl_block324);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(sfrACT_END_DATE_TIME));
            _bw.write(_wl_block325Bytes, _wl_block325);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block326Bytes, _wl_block326);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block327Bytes, _wl_block327);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(dosage_type));
            _bw.write(_wl_block328Bytes, _wl_block328);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(completedMinutes));
            _bw.write(_wl_block329Bytes, _wl_block329);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(completedFlow));
            _bw.write(_wl_block330Bytes, _wl_block330);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf((Float.parseFloat(qty)+"")));
            _bw.write(_wl_block331Bytes, _wl_block331);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block254Bytes, _wl_block254);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(iv_sch_date_tim));
            _bw.write(_wl_block332Bytes, _wl_block332);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block333Bytes, _wl_block333);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(MFRCount));
            _bw.write(_wl_block334Bytes, _wl_block334);

													}
													else{

            _bw.write(_wl_block335Bytes, _wl_block335);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(freqRowspan));
            _bw.write(_wl_block94Bytes, _wl_block94);

															ivSchDisplay = bean.getIVSchecdule(order_id, order_line_num, adminFromDateTime, adminToTime,iv_prep_yn,drug_code); //added iv_prep_yn,drug_code for SKR-SCF-1421
															ivSchDispStatus = ""; 
															schCount = 0;
															for(int ivSch=0; ivSch<ivSchDisplay.size();ivSch+=8){//6 CHANGED TO 8 FOR JD-CRF-0200
																dosage_seq_no = (String)ivSchDisplay.get(ivSch+5);
																sch_date_time = (String)ivSchDisplay.get(ivSch+1)+" "+(String)ivSchDisplay.get(ivSch+2);
																//sch_date_time = sfrACT_START_DATE_TIME;
																cancel_recorded_yn=(String)ivSchDisplay.get(ivSch+6);//ADDED FOR JD-CRF-0200
																can_act_sch=(String)ivSchDisplay.get(ivSch+7);//ADDED FOR JD-CRF-0200
																
																scheKey = order_id+"_"+order_line_num+"_"+schCount+"_"+schDayCount+"_"+dosage_seq_no;//ivSch Added for identified issues fix
																if(!com.ehis.util.DateUtils.isBefore((String)ivSchDisplay.get(ivSch+1), to_time, "DMY", locale))
																	break;
																sfrFLOW_STATUS = (String)ivSchDisplay.get(ivSch+3);
																schCanAdmin = (String)ivSchDisplay.get(ivSch+4);
																if(!dosage_seq_no.equals("1") && alTmpOrderSchDetail.size()>schCount+1){
																	iv_drug_details =(ArrayList)alTmpOrderSchDetail.get(schCount+1);
																	if(dosage_seq_no.equals((String)iv_drug_details.get(13))){
																		schCount++;
																		admin_recorded_yn  = (String)iv_drug_details.get(23);
																		sch_infusion_rate			= (String)iv_drug_details.get(1);
																		iv_sch_date_tim      = (String)iv_drug_details.get(12);//Added for SKR-SCF-0913[Inc : 46556]

																		if(sch_infusion_rate!= null && !(sch_infusion_rate.equals(""))){
																			if(Float.parseFloat(sch_infusion_rate) < 1.0){ 
																				sch_infusion_rate = Float.parseFloat(sch_infusion_rate)+"";
																			}
																		}
																		sch_date_time            =   (String)iv_drug_details.get(12);
																		qty						 =	 (String)iv_drug_details.get(16);
																		if(Float.parseFloat(qty) < 1)
																			qty="0"+qty; 

																		qty_uom					 =	 (String)iv_drug_details.get(17);
																		discontinued			 =	 (String)iv_drug_details.get(18);
																		hold					 =	 (String)iv_drug_details.get(19);
																		sch_infusion_period		 =	 (String)iv_drug_details.get(20);		
																		
																		sch_infusion_period_unit =	 (String)iv_drug_details.get(21);
																		administered_yn			 =	 (String)iv_drug_details.get(22);
																		end_date_time 			 =   (String)iv_drug_details.get(33);
																		start_date_time			=	(String)iv_drug_details.get(69);
																		iv_no_of_drug_per_order  =   (String)iv_drug_details.get(45);
																		
																		
																		next_schd_date =   bean.getNextSchdate(order_id,order_line_num,Integer.parseInt(dosage_seq_no.trim()),sch_date_time);
																		//sfrFLOW_STATUS			 =	(String)iv_drug_details.get(55);
																		sfrHOLD_DATE_TIME		 =	(String)iv_drug_details.get(56);
																		sfrHOLD_DURN_IN_MINS	 =	(String)iv_drug_details.get(57);
																		if(sfrHOLD_DURN_IN_MINS.equals(""))
																			sfrHOLD_DURN_IN_MINS="0";
																		sfrRESUME_DATE_TIME		 =	(String)iv_drug_details.get(58);
																		sfrACT_START_DATE_TIME	 =	(String)iv_drug_details.get(59);
																		if(!(sfrACT_START_DATE_TIME.equals(""))){
																			sfrACT_START_DATE_TIME=com.ehis.util.DateUtils.convertDate(sfrACT_START_DATE_TIME,"DMYHM","en",locale);
																		}
																		
																		if(sfrACT_START_DATE_TIME.equals("")){
																			sfrACT_START_DATE_TIME=current_date_time;
																		}
																		sfrACT_END_DATE_TIME	 =(String)iv_drug_details.get(60);
																		dosage_type				 =(String)iv_drug_details.get(61);
																		mfrRemarks				 =	(String)iv_drug_details.get(62);
																		completedMinutes		 =	(String)iv_drug_details.get(63);
																		if(completedMinutes.equals(""))
																			completedMinutes = "0";
																		completedFlow			 =	(String)iv_drug_details.get(64);
																		if(completedFlow.equals(""))
																			completedFlow = "0";
																		adr_count			= bean.getADRCount(patient_id_test,drug_code);   
																		schDate			 =	(String)iv_drug_details.get(71);
																		//schCanAdmin			 =	(String)iv_drug_details.get(71);
																		ord_hold_date_time			 =	(String)iv_drug_details.get(75);
																		ord_disc_date_time			 =	(String)iv_drug_details.get(76);

																		if(!mfrRemarks.equals(""))
																			mfrRemarks=java.net.URLEncoder.encode(mfrRemarks,"UTF-8");

																		remarks = iv_drug_details.get(24)==null?"Not Entered":(String)iv_drug_details.get(24);				
								admin_by_name   = (String)iv_drug_details.get(26);
								auth_by_name    = (String)iv_drug_details.get(32);

								if(showTitle.length()>0)
									showTitle.setLength(0);
								if(remarks!=null && !remarks.equals(""))
									showTitle.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.remarks.label", "common_labels")+"  : "+remarks+"\n ");
								if(admin_by_name!=null && !admin_by_name.equals(""))
									showTitle.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.AdministeredBy.label", "common_labels")+"   : "+admin_by_name);
								if(auth_by_name!=null && !auth_by_name.equals("")){
									showTitle.append("\n "+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.authorizedby.label", "common_labels")+"  : "+auth_by_name);
								}

																		admin_date_time = "";
																		if(iv_drug_details.get(27)!= null)
																			admin_date_time = (String)iv_drug_details.get(27);
																		modified_date_time = "";
																		if(iv_drug_details.get(28)!= null)
																			modified_date_time = (String)iv_drug_details.get(28);	
																	}
																}

																stDispHand="";
																sfrFLOW_STATUS_String="";
																ivSchDispStatus="";
																if(sfrFLOW_STATUS.equals("NS")){
																	sfrFLOW_STATUS_String="";
																}
																else if(sfrFLOW_STATUS.equals("ST")){
																	sfrFLOW_STATUS_String=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.STARTED.label","ph_labels");
																}
																else if(sfrFLOW_STATUS.equals("HO")){
																	sfrFLOW_STATUS_String=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Hold.label","ph_labels");
																}
																else if(sfrFLOW_STATUS.equals("RE")){
																	sfrFLOW_STATUS_String=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.RESUMED.label","ph_labels");
																}
																else if(sfrFLOW_STATUS.equals("CO") || sfrFLOW_STATUS.equals("AD")){
																	sfrFLOW_STATUS_String = "";
																	stDispHand = "BACKGROUND-COLOR:green;COLOR:white;;cursor:pointer;";
																}
																if(schCanAdmin.equals("Y") || !sfrFLOW_STATUS.equals("NS"))
																	displayStyle="font-size:8;color:blue;align:center;cursor:pointer;";
																else
																	displayStyle="font-size:8;color:black;align:center;";
																if(!sfrFLOW_STATUS.equals("CO"))
																	administered_yn="N";
																if(!sfrFLOW_STATUS.equals("NS") && !sfrFLOW_STATUS.equals("CO"))
																	ivSchDispStatus = sfrFLOW_STATUS_String+" <br>";
																if(!dispDate.equals((String)ivSchDisplay.get(ivSch+1)) && !nextDaySch){ //IV infuse schedule continius to next day
																	schDayCount++;
																	dayCount++;
																	nextDaySch = true;

            _bw.write(_wl_block336Bytes, _wl_block336);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(freqRowspan));
            _bw.write(_wl_block94Bytes, _wl_block94);

																}
																if(schCanAdmin.equals("Y") ){ //IV infuse schedule can be administered
																if(WardAckMarRequiredYn.equalsIgnoreCase("Y")){ //GHL-CRF-0458 - start // isSiteSpecMARPrint changed to WardAckMarRequiredYn.equalsIgnoreCase("Y") for MMS-KH-CRF-0014 [IN:067953]
																	
																patient_class_ord = bean.getOrderPatientClass(order_id);
																if(patient_class_ord==null)
																	patient_class_ord = "";
																if(WardAckMarRequiredYn.equalsIgnoreCase("Y") && patient_class_ord.equals("IP")){
																	ack_yn		 = bean.getAcknowlegeYN(order_id,order_line_num,iv_prep_yn); //iv_prep_yn added for MMS-KH-CRF-0039
																	if(ack_yn==null) //MMS-KH-CRF-0017
																		ack_yn = "";
																}
  
																	if(WardAckMarRequiredYn.equalsIgnoreCase("Y") && !ack_yn.equals("A") && patient_class_ord.equals("IP") &&  !iv_prep_yn.equals("8")) //!iv_prep_yn.equals("2") && !iv_prep_yn.equals("4") && !iv_prep_yn.equals("6") added for MMS-KH-CRF-017
																		displayStyle = "";
																		//GHL-CRF-0458 - end
																	}																	
																if(marForDisPatNotReqYN && dischargedYN){ // Added for KH-SCF-0010 - Start
																	displayStyle = "";
																	stDispHand = "";
																 } // Added for KH-SCF-0010 - End

            _bw.write(_wl_block337Bytes, _wl_block337);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(stDispHand));
            _bw.write(_wl_block338Bytes, _wl_block338);

																	if(!sfrFLOW_STATUS.equals("NS")){
																		if(sfrFLOW_STATUS.equals("CO") || sfrFLOW_STATUS.equals("AD")){

            _bw.write(_wl_block339Bytes, _wl_block339);
            out.print( String.valueOf(stDispHand));
            _bw.write(_wl_block340Bytes, _wl_block340);
            out.print( String.valueOf(showTitle.toString()));
            _bw.write(_wl_block341Bytes, _wl_block341);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(cancelYn));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(admin_by_name));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_desc,"UTF-8")));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(admin_date_time));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(strength_per_value_pres_uom));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(patient_id_test));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block342Bytes, _wl_block342);
            out.print( String.valueOf((String)ivSchDisplay.get(ivSch)));
            _bw.write(_wl_block343Bytes, _wl_block343);

																		}
																		else{
																		if(marForDisPatNotReqYN && dischargedYN){ // if Added for KH-SCF-0010 - Start

            _bw.write(_wl_block344Bytes, _wl_block344);
            out.print( String.valueOf(displayStyle));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(stDispHand));
            _bw.write(_wl_block345Bytes, _wl_block345);
            out.print( String.valueOf(ivSchDispStatus));
            _bw.write(_wl_block346Bytes, _wl_block346);

																		} // if Added for KH-SCF-0010 - End
																	   else{

            _bw.write(_wl_block347Bytes, _wl_block347);
            out.print( String.valueOf(displayStyle));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(stDispHand));
            _bw.write(_wl_block348Bytes, _wl_block348);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(administered_yn));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(admin_recorded_yn));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(sch));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(sfrFLOW_STATUS));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(rowsPan));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(ivSchDispStatus));
            _bw.write(_wl_block346Bytes, _wl_block346);

																		  } 

            _bw.write(_wl_block349Bytes, _wl_block349);
            out.print( String.valueOf((String)ivSchDisplay.get(ivSch+2)));
            _bw.write(_wl_block350Bytes, _wl_block350);
            out.print( String.valueOf((String)ivSchDisplay.get(ivSch)));
            _bw.write(_wl_block351Bytes, _wl_block351);

																		}
																	}
																	else{
																		if(marForDisPatNotReqYN && dischargedYN || displayStyle.equals("")){ // if Added for KH-SCF-0010 - Start // || displayStyle.equals("") Added for MMS-KH-CRF-0014 [IN:067953] 

            _bw.write(_wl_block352Bytes, _wl_block352);
            out.print( String.valueOf(displayStyle));
            _bw.write(_wl_block353Bytes, _wl_block353);
            out.print( String.valueOf((String)ivSchDisplay.get(ivSch+2)));
            _bw.write(_wl_block354Bytes, _wl_block354);
            out.print( String.valueOf((String)ivSchDisplay.get(ivSch)));
            _bw.write(_wl_block351Bytes, _wl_block351);

																		} // if Added for KH-SCF-0010 - End
																	   else{if(cancel_recorded_yn.equals("Y")){

            _bw.write(_wl_block355Bytes, _wl_block355);
            out.print( String.valueOf(displayStyle));
            _bw.write(_wl_block356Bytes, _wl_block356);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(administered_yn));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(admin_recorded_yn));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(sch));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(sfrFLOW_STATUS));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(rowsPan));
            _bw.write(_wl_block357Bytes, _wl_block357);
            out.print( String.valueOf(can_act_sch));
            _bw.write(_wl_block354Bytes, _wl_block354);
            out.print( String.valueOf((String)ivSchDisplay.get(ivSch)));
            _bw.write(_wl_block351Bytes, _wl_block351);

																	}
																	   else{
            _bw.write(_wl_block355Bytes, _wl_block355);
            out.print( String.valueOf(displayStyle));
            _bw.write(_wl_block356Bytes, _wl_block356);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(administered_yn));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(admin_recorded_yn));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(sch));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(sfrFLOW_STATUS));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(rowsPan));
            _bw.write(_wl_block357Bytes, _wl_block357);
            out.print( String.valueOf((String)ivSchDisplay.get(ivSch+2)));
            _bw.write(_wl_block354Bytes, _wl_block354);
            out.print( String.valueOf((String)ivSchDisplay.get(ivSch)));
            _bw.write(_wl_block358Bytes, _wl_block358);
   }
																	   }

            _bw.write(_wl_block359Bytes, _wl_block359);
if(cancel_recorded_yn.equals("Y")){
            _bw.write(_wl_block360Bytes, _wl_block360);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_desc,"UTF-8")));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(patient_id_test));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(admin_date_time));
            _bw.write(_wl_block361Bytes, _wl_block361);
}
            _bw.write(_wl_block1Bytes, _wl_block1);

																}
                                                               }
																else{ //IV infuse schedule can not administer

            _bw.write(_wl_block337Bytes, _wl_block337);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(stDispHand));
            _bw.write(_wl_block94Bytes, _wl_block94);

																		if(sfrFLOW_STATUS.equals("CO") || sfrFLOW_STATUS.equals("AD")){

            _bw.write(_wl_block362Bytes, _wl_block362);
            out.print( String.valueOf(stDispHand));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(cancelYn));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(admin_by_name));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_desc,"UTF-8")));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(admin_date_time));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(strength_per_value_pres_uom));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(patient_id_test));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(sch_infusion_per_unit_table_date));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(sch_infusion_vol_str_unit_desc));
            _bw.write(_wl_block363Bytes, _wl_block363);
            out.print( String.valueOf((String)ivSchDisplay.get(ivSch)));
            _bw.write(_wl_block364Bytes, _wl_block364);

																		}
																		else{

            _bw.write(_wl_block365Bytes, _wl_block365);
            out.print( String.valueOf(ivSchDispStatus));
            _bw.write(_wl_block366Bytes, _wl_block366);
            out.print( String.valueOf(displayStyle));
            _bw.write(_wl_block367Bytes, _wl_block367);
            out.print( String.valueOf((String)ivSchDisplay.get(ivSch+2)));
            _bw.write(_wl_block368Bytes, _wl_block368);
            out.print( String.valueOf((String)ivSchDisplay.get(ivSch)));
            _bw.write(_wl_block351Bytes, _wl_block351);

																		}

            _bw.write(_wl_block369Bytes, _wl_block369);

																}
																drugCount= 0;
																for(drugIndex=1; drugIndex<=rowsPan; drugIndex++){ 
																	if(alTmpOrderSchDetail.size() >= (rowsPan * Integer.parseInt(dosage_seq_no)) )
																		iv_drug_details =(ArrayList)alTmpOrderSchDetail.get( ((drugIndex-1) * (alTmpOrderSchDetail.size()/rowsPan)) +(Integer.parseInt(dosage_seq_no)-1) );
																	else
																		iv_drug_details =(ArrayList)alTmpOrderSchDetail.get( ((drugIndex-1) * (alTmpOrderSchDetail.size()/rowsPan)) +((alTmpOrderSchDetail.size()/rowsPan)-1));
																	if(dosage_seq_no.equals((String)iv_drug_details.get(13))){
																		drugCount++;
																		admin_recorded_yn  = (String)iv_drug_details.get(23);
																		sch_infusion_rate			= (String)iv_drug_details.get(1);
																		iv_sch_date_tim      = (String)iv_drug_details.get(12);//Added for SKR-SCF-0913[Inc : 46556]
																		if(sch_infusion_rate!= null && !(sch_infusion_rate.equals(""))){
																			if(Float.parseFloat(sch_infusion_rate) < 1.0){ 
																				sch_infusion_rate = Float.parseFloat(sch_infusion_rate)+"";
																			}
																		}
																		sch_date_time            =   (String)iv_drug_details.get(12);
																		qty						 =	 (String)iv_drug_details.get(16);
																		if(Float.parseFloat(qty) < 1)
																			qty="0"+qty; 

																		qty_uom					 =	 (String)iv_drug_details.get(17);
																		discontinued			 =	 (String)iv_drug_details.get(18);
																		hold					 =	 (String)iv_drug_details.get(19);
																		sch_infusion_period		 =	 (String)iv_drug_details.get(20);		
																		
																		sch_infusion_period_unit =	 (String)iv_drug_details.get(21);
																		administered_yn			 =	 (String)iv_drug_details.get(22);
																		end_date_time 			 =   (String)iv_drug_details.get(33);
																		start_date_time			=	(String)iv_drug_details.get(69);
																		iv_no_of_drug_per_order  =   (String)iv_drug_details.get(45);
																		
																		
																		next_schd_date =   bean.getNextSchdate(order_id,order_line_num,Integer.parseInt(dosage_seq_no.trim()),sch_date_time);
																		//sfrFLOW_STATUS			 =	(String)iv_drug_details.get(55);
																		sfrHOLD_DATE_TIME		 =	(String)iv_drug_details.get(56);
																		sfrHOLD_DURN_IN_MINS	 =	(String)iv_drug_details.get(57);
																		if(sfrHOLD_DURN_IN_MINS.equals(""))
																			sfrHOLD_DURN_IN_MINS="0";
																		sfrRESUME_DATE_TIME		 =	(String)iv_drug_details.get(58);
																		sfrACT_START_DATE_TIME	 =	(String)iv_drug_details.get(59);
																		if(!(sfrACT_START_DATE_TIME.equals(""))){
																			sfrACT_START_DATE_TIME=com.ehis.util.DateUtils.convertDate(sfrACT_START_DATE_TIME,"DMYHM","en",locale);
																		}
																		
																		if(sfrACT_START_DATE_TIME.equals("")){
																			sfrACT_START_DATE_TIME=current_date_time;
																		}
																		sfrACT_END_DATE_TIME	 =(String)iv_drug_details.get(60);
																		dosage_type				 =(String)iv_drug_details.get(61);
																		mfrRemarks				 =	(String)iv_drug_details.get(62);
																		completedMinutes		 =	(String)iv_drug_details.get(63);
																		if(completedMinutes.equals(""))
																			completedMinutes = "0";
																		completedFlow			 =	(String)iv_drug_details.get(64);
																		if(completedFlow.equals(""))
																			completedFlow = "0";
																		adr_count			= bean.getADRCount(patient_id_test,drug_code);   
																		schDate			 =	(String)iv_drug_details.get(71);
																		ord_hold_date_time			 =	(String)iv_drug_details.get(75);
																		ord_disc_date_time			 =	(String)iv_drug_details.get(76);

						if(!mfrRemarks.equals(""))
									mfrRemarks=java.net.URLEncoder.encode(mfrRemarks,"UTF-8");
								remarks = iv_drug_details.get(24)==null?"Not Entered":(String)iv_drug_details.get(24);				
								admin_by_name   = (String)iv_drug_details.get(26);
								auth_by_name    = (String)iv_drug_details.get(32);
								if(showTitle.length()>0)
									showTitle.setLength(0);
								if(remarks!=null && !remarks.equals(""))
									showTitle.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.remarks.label", "common_labels")+"  : "+remarks+"\n ");
								if(admin_by_name!=null && !admin_by_name.equals(""))
									showTitle.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.AdministeredBy.label", "common_labels")+"   : "+admin_by_name);
								if(auth_by_name!=null && !auth_by_name.equals("")){
									showTitle.append("\n "+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.authorizedby.label", "common_labels")+"  : "+auth_by_name);
								}

																		admin_date_time = "";
																		if(iv_drug_details.get(27)!= null)
																			admin_date_time = (String)iv_drug_details.get(27);
																		modified_date_time = "";
																		if(iv_drug_details.get(28)!= null)
																			modified_date_time = (String)iv_drug_details.get(28);	
																			linkVacScheduleCode		 =	(String)iv_drug_details.get(53);
																			if(!(linkVacScheduleCode==null || linkVacScheduleCode.equals(""))){
																				linkVacScheduleCode1=linkVacScheduleCode.substring(0,10);									
																				if(!linkVacScheduleCode1.equals("NO DEFAULT")){
																					try{
																						linkVacScheduleYN="Y";
																						vacScheduleDetails=linkVacScheduleCode.split("~",6);
																						if(vacScheduleDetails.length>0){
																							linkVacScheduleCode=vacScheduleDetails[0]+"~"+vacScheduleDetails[1]+"~"+vacScheduleDetails[2]+"~"+vacScheduleDetails[5];
																							linkVacScheduleDescToolTip=vacScheduleDetails[3];
																							linkVacScheduleDesc=vacScheduleDetails[4];
																						}
																					}
																					catch(Exception execu){
																						execu.printStackTrace();
																					}
																				}
																				else{
																					linkVacScheduleYN="Y";
																					linkVacScheduleDescToolTip="";
																					linkVacScheduleDesc="";
																					vacScheduleDetails=linkVacScheduleCode.split("~");
																					if(vacScheduleDetails.length>0){
																						linkVacScheduleCode=vacScheduleDetails[1];
																					}										
																				}
																			}
																			else{
																				linkVacScheduleYN="N";
																				linkVacScheduleDescToolTip="";
																				linkVacScheduleDesc="";
																			}			

            _bw.write(_wl_block370Bytes, _wl_block370);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block371Bytes, _wl_block371);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block372Bytes, _wl_block372);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(modified_date_time));
            _bw.write(_wl_block373Bytes, _wl_block373);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block374Bytes, _wl_block374);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(end_date_time));
            _bw.write(_wl_block375Bytes, _wl_block375);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(next_schd_date));
            _bw.write(_wl_block376Bytes, _wl_block376);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block377Bytes, _wl_block377);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block378Bytes, _wl_block378);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block379Bytes, _wl_block379);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block380Bytes, _wl_block380);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(sfrACT_START_DATE_TIME));
            _bw.write(_wl_block381Bytes, _wl_block381);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(sch_infusion_rate));
            _bw.write(_wl_block382Bytes, _wl_block382);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(sch_infusion_vol_str_unit));
            _bw.write(_wl_block383Bytes, _wl_block383);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(sch_infusion_vol_str_unit_desc));
            _bw.write(_wl_block384Bytes, _wl_block384);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(sch_infusion_per_unit_table_date));
            _bw.write(_wl_block385Bytes, _wl_block385);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(sch_infusion_period));
            _bw.write(_wl_block386Bytes, _wl_block386);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(sch_infusion_period_unit));
            _bw.write(_wl_block387Bytes, _wl_block387);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(batch_id));
            _bw.write(_wl_block388Bytes, _wl_block388);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(expiry_date));
            _bw.write(_wl_block389Bytes, _wl_block389);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block390Bytes, _wl_block390);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(batch_id));
            _bw.write(_wl_block391Bytes, _wl_block391);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block392Bytes, _wl_block392);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(trade_name));
            _bw.write(_wl_block393Bytes, _wl_block393);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(trade_id));
            _bw.write(_wl_block394Bytes, _wl_block394);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block395Bytes, _wl_block395);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block396Bytes, _wl_block396);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(iv_no_of_drug_per_order));
            _bw.write(_wl_block397Bytes, _wl_block397);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(sfrFLOW_STATUS));
            _bw.write(_wl_block398Bytes, _wl_block398);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(sfrHOLD_DATE_TIME));
            _bw.write(_wl_block399Bytes, _wl_block399);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(sfrHOLD_DURN_IN_MINS));
            _bw.write(_wl_block400Bytes, _wl_block400);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block401Bytes, _wl_block401);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block402Bytes, _wl_block402);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(sfrRESUME_DATE_TIME));
            _bw.write(_wl_block403Bytes, _wl_block403);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(sfrACT_END_DATE_TIME));
            _bw.write(_wl_block404Bytes, _wl_block404);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block405Bytes, _wl_block405);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block406Bytes, _wl_block406);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(dosage_type));
            _bw.write(_wl_block407Bytes, _wl_block407);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(completedMinutes));
            _bw.write(_wl_block408Bytes, _wl_block408);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(completedFlow));
            _bw.write(_wl_block409Bytes, _wl_block409);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf((Float.parseFloat(qty)+"")));
            _bw.write(_wl_block410Bytes, _wl_block410);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(qty_uom));
            _bw.write(_wl_block411Bytes, _wl_block411);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block254Bytes, _wl_block254);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(iv_sch_date_tim));
            _bw.write(_wl_block412Bytes, _wl_block412);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf((String)iv_drug_details.get(10)));
            _bw.write(_wl_block413Bytes, _wl_block413);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block258Bytes, _wl_block258);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf((String)iv_drug_details.get(8)));
            _bw.write(_wl_block414Bytes, _wl_block414);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block261Bytes, _wl_block261);
            out.print( String.valueOf((String)iv_drug_details.get(14)));
            _bw.write(_wl_block415Bytes, _wl_block415);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf((String)iv_drug_details.get(15)));
            _bw.write(_wl_block416Bytes, _wl_block416);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block265Bytes, _wl_block265);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf((String)iv_drug_details.get(31)));
            _bw.write(_wl_block417Bytes, _wl_block417);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drugCount));
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(linkVacScheduleCode));
            _bw.write(_wl_block94Bytes, _wl_block94);

																	}
																}
															}

            _bw.write(_wl_block418Bytes, _wl_block418);

														}
													}
													break;
												}
												else{ //iv no schedule day td before schedule day from start day of week till schedule daye all iv types

            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block419Bytes, _wl_block419);
            out.print( String.valueOf(freqRowspan));
            _bw.write(_wl_block89Bytes, _wl_block89);

												}
											}
											else if(com.ehis.util.DateUtils.isAfter(schDate, dispDate, "DMY", locale) && schDayCount<(daySize/2)){ //iv no schedule day td
												schDayCount++;
												dayCount++;

            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block420Bytes, _wl_block420);
            out.print( String.valueOf(freqRowspan));
            _bw.write(_wl_block421Bytes, _wl_block421);

											}
											else
												dayCount++;
										}
									}
									if(!(iv_prep_yn.equals("3")|| iv_prep_yn.equals("4"))){
										for(;schDayCount<(daySize/2); schDayCount++){ //iv no schedule day td after schedule day till end of week

            _bw.write(_wl_block422Bytes, _wl_block422);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block423Bytes, _wl_block423);
            out.print( String.valueOf(freqRowspan));
            _bw.write(_wl_block89Bytes, _wl_block89);

										}
									}
								}
								if(!(iv_prep_yn.equals("3")|| iv_prep_yn.equals("4"))){
									schDayCount=0;
									dayCount = 0;

            _bw.write(_wl_block424Bytes, _wl_block424);

								}
							}

            _bw.write(_wl_block425Bytes, _wl_block425);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block426Bytes, _wl_block426);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(MfrYN));
            _bw.write(_wl_block427Bytes, _wl_block427);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block428Bytes, _wl_block428);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(mfrRemarks));
            _bw.write(_wl_block429Bytes, _wl_block429);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block430Bytes, _wl_block430);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block431Bytes, _wl_block431);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(dispense_drug_code));
            _bw.write(_wl_block432Bytes, _wl_block432);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block433Bytes, _wl_block433);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block434Bytes, _wl_block434);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block258Bytes, _wl_block258);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block435Bytes, _wl_block435);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block261Bytes, _wl_block261);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block436Bytes, _wl_block436);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block437Bytes, _wl_block437);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block438Bytes, _wl_block438);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block439Bytes, _wl_block439);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block265Bytes, _wl_block265);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(drug_class));
            _bw.write(_wl_block440Bytes, _wl_block440);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block441Bytes, _wl_block441);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(iv_order_pract_id));
            _bw.write(_wl_block442Bytes, _wl_block442);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block443Bytes, _wl_block443);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block444Bytes, _wl_block444);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block445Bytes, _wl_block445);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(freq_code));
            _bw.write(_wl_block446Bytes, _wl_block446);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block447Bytes, _wl_block447);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(iv_Auto_Admin));
            _bw.write(_wl_block448Bytes, _wl_block448);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block449Bytes, _wl_block449);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block450Bytes, _wl_block450);
            out.print( String.valueOf(Store_locn_code));
            _bw.write(_wl_block451Bytes, _wl_block451);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block452Bytes, _wl_block452);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(discontinued));
            _bw.write(_wl_block453Bytes, _wl_block453);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block454Bytes, _wl_block454);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(hold));
            _bw.write(_wl_block455Bytes, _wl_block455);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(linkVacScheduleCode));
            _bw.write(_wl_block94Bytes, _wl_block94);

							orderCount++;
							if(iv_prep_yn.equals("3")|| iv_prep_yn.equals("4")){
								for(;schDayCount<(daySize/2); schDayCount++){

            _bw.write(_wl_block456Bytes, _wl_block456);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block423Bytes, _wl_block423);
            out.print( String.valueOf(freqRowspan));
            _bw.write(_wl_block89Bytes, _wl_block89);

								}

								schDayCount=0;
								dayCount = 0;

            _bw.write(_wl_block457Bytes, _wl_block457);

							if(alIVPBDrugSchList!=null && alIVPBDrugSchList.size()>0 && schSize ==1){
								//rowsPan = 2;
								//freqRowspan=2;
								//schRowspan=2;
								drugRowspan=1;
							//	fluidRowspan=1;
								ivnextRow = true;
								IVclassvalue="IVINGREDIENT1";
								alTmpIVPBDrugDtls = (ArrayList)alIVPBDrugSchList.get(0);
								ivPB_drug_code                =   (String)alTmpIVPBDrugDtls.get(10);
								ivPB_drug_desc                =   (String)alTmpIVPBDrugDtls.get(11);
								ivPB_encode_drug_desc         =   ivPB_drug_desc.replaceAll(" ","%20");
								ivPB_encode_drug_desc         =   java.net.URLEncoder.encode(ivPB_encode_drug_desc,"UTF-8");
								ivPB_encode_drug_desc         =   ivPB_encode_drug_desc.replaceAll("%2520","%20");						
								ivPB_ext_prod_id              =   (String)alTmpIVPBDrugDtls.get(44);
								//iv_no_of_drug_per_order  =   (String)alTmpIVPBDrugDtls.get(45);
								ivPB_trade_code			     =   (String)alTmpIVPBDrugDtls.get(46);
								ivPB_imageFileURL			 =   (String)alTmpIVPBDrugDtls.get(47);
								//drug_class = (String)alTmpIVPBDrugDtls.get(31);
								drug_class_ind = bean.getDrugClassInd((String)alTmpIVPBDrugDtls.get(31));

								adr_count			= bean.getADRCount(patient_id_test,ivPB_drug_code); 
								ivPB_sch_infusion_rate = bean.getIVPBSchInfusionRate((String)alTmpIVPBDrugDtls.get(1));
								//sch_infusion_vol_str_unit	= (String)alTmpIVPBDrugDtls.get(2);
								ivPB_sch_infusion_vol_str_unit_desc = (String)alTmpIVPBDrugDtls.get(66);
								ivPB_sch_infusion_per_unit = bean.getIVPBschInfusionUnit((String)alTmpIVPBDrugDtls.get(3));
								
								ivPB_qty						 =	 (String)alTmpIVPBDrugDtls.get(16);
								
								if(Float.parseFloat(ivPB_qty) < 1)
									ivPB_qty="0"+ivPB_qty; 

								if(Float.parseFloat(ivPB_qty) < 1.0)
									ivPB_qty = Float.parseFloat(ivPB_qty)+""; //to prefix a zero
								ivPB_qty_uom					 =	 (String)alTmpIVPBDrugDtls.get(17);


            _bw.write(_wl_block458Bytes, _wl_block458);
            out.print( String.valueOf(IVclassvalue));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(drug_class_ind));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(drugRowspan));
            _bw.write(_wl_block94Bytes, _wl_block94);

								if (!(iv_prep_yn.equals("0")||iv_prep_yn.equals("2")||iv_prep_yn.equals("4")||iv_prep_yn.equals("6"))){

            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(ivPB_drug_code));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block39Bytes, _wl_block39);

								}

            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(prod_name));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(ivPB_drug_desc));
            _bw.write(_wl_block42Bytes, _wl_block42);

								if( !ivPB_ext_prod_id.equals("")){

            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(ivPB_ext_prod_id));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(ivPB_encode_drug_desc));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.DrugInformation.label", "ph_labels")));
            _bw.write(_wl_block46Bytes, _wl_block46);

								}
								if(!ivPB_imageFileURL.equals("")){

            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(ivPB_drug_code));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(ivPB_trade_code));
            _bw.write(_wl_block48Bytes, _wl_block48);

								}
								if(adr_count>0){

            _bw.write(_wl_block99Bytes, _wl_block99);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(patient_id_test));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(ivPB_drug_code));
            _bw.write(_wl_block51Bytes, _wl_block51);

								} 
								if(!iv_prep_yn.equals("4")){

            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(ivPB_drug_code));
            _bw.write(_wl_block48Bytes, _wl_block48);
													
								}

            _bw.write(_wl_block100Bytes, _wl_block100);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(ivPB_qty));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(ivPB_qty_uom));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(drugRowspan));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(ivPB_sch_infusion_rate));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(ivPB_sch_infusion_vol_str_unit_desc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(ivPB_sch_infusion_per_unit));
            _bw.write(_wl_block459Bytes, _wl_block459);

							}
						}
					}

            _bw.write(_wl_block460Bytes, _wl_block460);

			}

            _bw.write(_wl_block461Bytes, _wl_block461);

	putObjectInBean(bean_id,bean,request);
	putObjectInBean(bean_id_all_stages,bean_all_stages,request);
//	putObjectInBean(drug_search_bean_id,drug_bean,request);
	putObjectInBean(admin_bean_id,admin_bean,request);
}
catch(Exception e){
	e.printStackTrace();
}

            _bw.write(_wl_block3Bytes, _wl_block3);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.OrderDate/Time.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Start.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.End.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MedicationName.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdminDose.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.InfusionRate.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Route.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.freq.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ScheduleTime.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.IVAdministration.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdverseDrugReaction.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.LinkVaccineShcedule.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.TotalVolume.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdverseDrugReaction.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.TotalVolume.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdverseDrugReaction.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.TotalVolume.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MFRRemarks.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MFRDetails.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MFRRemarks.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MFRDetails.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MFRRemarks.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdverseDrugReaction.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.TotalVolume.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
