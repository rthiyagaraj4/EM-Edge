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

public final class __medicationadministrationftdrugdtls extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/MedicationAdministrationFTDrugDtls.jsp", 1736406763869L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>  \n\t <head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<script language=\"javascript\">\n\t\tvar headTop = -1;\n\t\tvar FloatHead1;\n\t\tvar FloatHead2;\n\t\tvar onlyiv=false;\n\t\tfunction processScroll(){\n\t\t\tif (headTop < 0){\n\t\t\t\tsaveHeadPos();\n\t\t\t}\t\t\t\t\n\t\t\tif (headTop>0){\n\t\t\t\tif (document.documentElement && document.documentElement.scrollTop){\n\t\t\t\t\ttheTop = document.documentElement.scrollTop;\n\t\t\t\t}\n\t\t\t\telse if (document.body){\n\t\t\t\t\ttheTop = document.body.scrollTop;\n\t\t\t\t}\t\t\t\t\t\n\t\t\t\tif(FloatHead2!=null){\n\t\t\t\t\tif(onlyiv){ //Only IV Drugs\n\t\t\t\t\t\tFloatHead1 = FloatHead2;\n\t\t\t\t\t}\n\t\t\t\t\telse{ //NonIV and IV Drugs\n\t\t\t\t\t\tif(document.getElementById(\"ball\").offsetTop < theTop){\n\t\t\t\t\t\t\tFloatHead1.style.visibility= \'hidden\';\n\t\t\t\t\t\t\tFloatHead1 = FloatHead2;\n\t\t\t\t\t\t\tFloatHead1.style.visibility= \'visible\';\n\t\t\t\t\t\t\tFloatHead1.style.position = \"absolute\";\t\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse {\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tFloatHead1.style.position = \"\";\t\n\t\t\t\t\t\t\tFloatHead1 = document.getElementById(\"non_iv_admin_table_row2\");\n\t\t\t\t\t\t\tFloatHead1.style.visibility= \'visible\';\n\t\t\t\t\t\t\tFloatHead1.style.position = \"relative\";\t\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\telse{ // only NON IV Drugs\n\t\t\t\t\tFloatHead1 = document.getElementById(\"non_iv_admin_table_row2\");\t\t\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\tif (theTop>headTop){\n\t\t\t\t\tFloatHead1.style.top = (theTop-headTop) + \'px\';\t\t\t\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse{\n\t\t\t\t\tFloatHead1.style.top = \'0px\';\t\t\t\t\t\t\t\n\t\t\t\t}\n\t\t\t}\t\t\t\t\n\t\t}\n\t\tfunction saveHeadPos(){\n\t\t\tparTable = document.getElementById(\"headStart\");\n\t\t\tif (parTable != null){\n\t\t\t\theadTop = parTable.offsetTop + 3;\t\t\t\t\t\n\t\t\t\tFloatHead1 = document.getElementById(\"non_iv_admin_table_row2\");\n\t\t\t\tFloatHead1.style.position = \"relative\";\n\t\t\t\tFloatHead2= document.getElementById(\"iv_admin_table_row1\");\n\t\t\t\tif (FloatHead2 != null){\t\t\t\t\t\t\n\t\t\t\t\tonlyiv=false;\n\t\t\t\t}\n\t\t\t}\n\t\t\telse{\t\t\t\t\t\n\t\t\t\tparTable = document.getElementById(\"headStart2\");\n\t\t\t\tif (parTable != null){\n\t\t\t\t\theadTop = 3;\t\n\t\t\t\t\tFloatHead2 = document.getElementById(\"iv_admin_table_row1\");\n\t\t\t\t\tFloatHead2.style.position = \"absolute\";\n\t\t\t\t\tonlyiv=true;\n\t\t\t\t}\n\t\t\t}\n\t\t}\t\t\t\n\t\twindow.onscroll = processScroll;\n\t\t</script>\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/PhCommon.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../ePH/js/MedicationAdministrationFixedTime.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../ePH/js/MedicationAdministration.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/DispMedicationAllStages.js\"></script>\n\t\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t\t<script type=\"text/javascript\" src=\"../../ePH/js/DrugDetailsDisplay.js\"></script>\n\t\t<script type=\"text/javascript\" src=\"../../eCommon/js/dchk.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../ePH/js/PPNRegimen.js\"></script>\n\t\t<style>\n\t\t.descFont{\n\t\t\tfont-size:9;\n\t\t\tfont-weight:bold;\n\t\t\tcolor:black;\n\t\t}\n\t\t/* NMC-JD-CRF-0186 - [43323] */\n\t\tTD.hiddenCheck{\n\t\t\tvisibility: false;\n\t\t\tpointer-events:none;\n\t\t\tbackground-color: blue;\n\t\t}\n\t\tTD.visibleCheck{\n\t\t\tvisibility: true;\n\t\t}\n\t\t</style>\n\t</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<body  onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t\t<form name=\"MedicationAdministrationFTDrugDetails\" id=\"MedicationAdministrationFTDrugDetails\" >\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t<table>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<title>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</title>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<script>\n\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\'Common\'));\n\t\t\tif(parent.parent.f_button != null){\n\t\t\t\tparent.parent.parent.f_search.location.href = \"../../ePH/jsp/MedicationAdministrationSearch.jsp\";\n\t\t\t}\n\t\t</script>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\t\t<div id=\"headStart\" > \n\t\t<table cellpadding=\"0\" width=\"100%\" align=\"center\" border=\"1\" id=\"non_iv_administration_table\">\n\t\t<tr id=\"non_iv_admin_table_row2\">\n\t\t<td class=\"TDSTYLE\" width=\"2%\">&nbsp;</td>\n\t\t<td class=\"TDSTYLE\"   width=\"25%\"><B>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</B></td>\n\t\t<td class=\"TDSTYLE\"   width=\"2%\">&nbsp;</td>\n\t\t<td class=\"TDSTYLE\"   width=\"2%\">&nbsp;</td>\n\t\t<td class=\"TDSTYLE\"   width=\"2%\">&nbsp;</td>\n\t\t<td class=\"TDSTYLE\"   width=\"6%\"><B>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</B></td>\n\t\t<td class=\"TDSTYLE\"   width=\"9%\"><B>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</B></td>\n\t\t<td class=\"TDSTYLE\"   width=\"10%\"><B>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</B></td>\n\t\t<td class=\"TDSTYLE\"   width=\"2%\"><B>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</B></td>\n\t\t<td class=\"TDSTYLE\"   width=\"13%\"><B>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</B></td><!-- Modified for HSA-CRF-0090[IN041241] -->\n\t\t<td class=\"TDSTYLE\"   width=\"10%\"><B>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</B></td>\n\t\t<td class=\"TDSTYLE\"   width=\"18%\"><B>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</B></td>\n\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t<td class=\"TDSTYLE\"   width=\"2%\"><B>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</B></td><!-- GHL-CRF-0482-->\n\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t<td class=\"TDSTYLE\" ><B>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</B></td>\n\t\t</tr>\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t<tr id=\"non_iv_admin_table_row1\" >\n\t\t\t<td class=\'COLUMNHEADER\' colspan=\"14\"  style=\"font-size:10\" ><b>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</b></td>\n\t\t\t</tr>\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t<tr id=\"non_iv_admin_table_row1\" >\n\t\t\t\t\t<td class=\'COLUMNHEADER\'  colspan=\"14\"  style=\"font-size:10\" ><b>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</b></td>\n\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t<tr id=\"non_iv_admin_table_row1\" >\n\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\'  colspan=\"14\"  style=\"font-size:10\" ><b>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</b></td>\n\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t<input type=\"hidden\" name=\"non_iv_sliding_scale_";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" id=\"non_iv_sliding_scale_";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\t\n\t\t\t<input type=\"hidden\" name=\"modified_date_time_";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" id=\"modified_date_time_";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t<tr id=\'new";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>\n\t\t\t\t<td id=\'medAdmInd";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' class=\"white\" width=\"2%\" style=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" onClick=\"enableData(\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\',\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\')\">";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</td>\n\t\t\t\t<td id =\'drugClassIndi";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' class=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" style=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\t\n\t\t\t\t<!-- added for AAKH-CRF-0024 [IN:038260] Start -->\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t\t<label style=\'color:red;font-size:12;FONT-WEIGHT: BOLDER;cursor:pointer;display:none;\' onclick=\"loadPage(\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\');\" id=\"drug_mast_det_";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">&nbsp;+&nbsp;</label>\n";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t<label  id=\"drug_mast_det_";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">&nbsp;</label>\n";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t<label id = \'drugDesc";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' class=\'descFont\' >";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' class=\'descFont\'>";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\t\t\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t\t<img src=\"../../ePH/images/info.gif\" align=\"center\"  width=\"17\" height=\"17\" style=\"cursor:pointer;\" onClick=\"showDrugInfo(\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\')\" title=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\"></img>\n";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t\t<img src=\'../../ePH/images/camera.gif\' width=\'17\' height=\'15\' onclick = \"showImage(\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\');\" onmouseover=\"changeCursor(this);\">\n";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t\t\t<img  id=\"ADR_img\" src=\'../../ePH/images/ADR.gif\'  title=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\' onclick = \"callADRdetails(\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\');\"></img>\n";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t\t<img src=\'../../ePH/images/DrugInfo.gif\' width=\'17\' height=\'15\' onclick = \"showDrug(\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t\t\t\t<img src=\'../../ePH/images/AddedIngredient.gif\' width=\'17\' height=\'15\' onclick = \"openPPNDisplay(\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\')\" onmouseover=\"changeCursor(this);\"\t>\t\t\t\t\t\t\t  \n";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t\t\t\t<img src=\'../../eCA/images/HI_RecordAllergies.gif\' width=\'17\' height=\'15\' onclick=\"showAllergyDetails(\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\t\t\t\n\t\t\t\t\t\t<label style=\'color:blue;text-align:right;\' onmouseover=\"changeCursor(this);\"  onclick=\"taperCurrRow(\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\')\">&nbsp;+&nbsp;";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="</label>\n";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\t\t\t\t\t\t\n\t\t\t\t\t\t<label style=\'color:black;;text-align:right;\'>&nbsp;";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t</label>\n\t\t\t\t<input type=\"hidden\" name=\"non_iv_status_flag_";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" id=\"non_iv_status_flag_";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"non_iv_dosage_seq_no_";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\" id=\"non_iv_dosage_seq_no_";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"non_iv_drug_code_";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\" id=\"non_iv_drug_code_";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"non_iv_dispense_drug_code_";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" id=\"non_iv_dispense_drug_code_";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"non_iv_item_code_";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\" id=\"non_iv_item_code_";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"non_iv_order_id_";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\" id=\"non_iv_order_id_";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"non_iv_order_line_no_";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\" id=\"non_iv_order_line_no_";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"non_iv_store_code_";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\" id=\"non_iv_store_code_";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\">\t\n\t\t\t\t<input type=\"hidden\" name=\"non_iv_end_date_";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\" id=\"non_iv_end_date_";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\">\t\n\t\t\t\t<input type=\"hidden\" name=\"non_iv_Auto_Admin_";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\" id=\"non_iv_Auto_Admin_";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"order_pract_id_";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\" id=\"order_pract_id_";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\"> <!-- //Added for [IN:040149]-->\n\t\t\t\t";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n\t\t\t\t<img src=\"../../ePH/images/history1.jpg\" align=\"center\"  width=\"17\" height=\"17\"  title=\"Cancel History\" onclick=\"cancelHistory(\'";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\')\"></img>\n\t\t\t\t";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\t\t\t\t</td>\n";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n\t\t\t\t\t<td nowrap class=\'";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\'  width=\"2%\"><img SRC=\"../../ePH/images/stop.gif\" title=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\"></img></td>\n";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\'  width=\"2%\">";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="</td> \n";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\'  width=\"2%\">&nbsp;</td>\t\t\t\t\t\n";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\t\t\t\t<td   class=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\">\n\t\t\t\t\t<img src=\"../../ePH/images/DrugRemarks.gif\" align=\"center\" width=\"50%\" height=\"60%\" style=\"cursor:pointer;\" onClick=\"displayInstructions(\'";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\',\'N\')\" title=";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="></img>\n\t\t\t\t</td>\n\n\t\t\t\t<td  class=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\n\t\t\t\t\t<label  style=\"cursor:pointer;font-size:9;color:blue\" onClick=\"showTPNDetails(\'";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\');\">";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\n\t\t\t\t\t<label  style=\"cursor:pointer;font-size:9;color:blue\" onClick=\"showDrugDetails(\'\',\'\',\'";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\',\'\',\'MAR\',\'";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\',\'N\');\">";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\',\'MAR\',\'";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\t\t\t\t\t<label  style=\"font-size:9;font-weight:bold;color:black\">&nbsp;</label>\n\n";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\t\t\t\t\t\n\t\t\t\t\t\t<label id=\"non_iv_admin_qty1_old";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\" style=\"font-size:9;font-weight:bold;color:black\">";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="</label>\t\n";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\n\t\t\t\t\t<label id=\"non_iv_admin_qty1_old";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\" style=\"font-size:9;font-weight:bold;color:black\">0</label>\n";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\n\t\t\t\t\t<label id=\'dosageDescriptionOld";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\' style=\"font-size:9;font-weight:bold;color:black\">";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\t\n\t\t\t\t\t\t <label  id=\'dosageDescriptionOld";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="</label> \n";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\n\t\t\t\t\t\t<label  id=\'dosageDescriptionOld";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\n\t\t\t\t<input type=\"text\" style=\"display:none\" id=\"non_iv_admin_qty1_";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\"  name=\"non_iv_admin_qty1_";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\" size=\"5\" maxlength=\"13\" onKeyPress=\"return allowValidNumber(this,event,6,3);\" oncopy=\"return false\" onpaste=\"return false\" onBlur=\"CheckNum(this);updateNonIvAdminQuantity(this,\'";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\'); makeDtlsMandatory(this,\'";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\',\'noniv\',\'";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\'); \" value=\"";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\" class=\"NUMBER\" style=\"font-size:11;";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\" ";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="><label id=\'dosageDescription";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\' style=\"font-size:10;display:none\" ><b>";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="</b></label>\t <!--//added for AAKH-CRF-0024 [IN:038260] -->\n";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\n\t\t\t\t\t<img src=\"../images/changeddosageindicator.gif\" align=\"center\" id=\"chng_dose_ind\" title=\"";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="------------------";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\n\t\t\t\t<input type=\"hidden\" name=\"non_iv_admin_qty_";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\" id=\"non_iv_admin_qty_";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\">\t\n\t\t\t\t<input type=\"hidden\" name=\"non_iv_bal_qty_";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\" id=\"non_iv_bal_qty_";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\"><!-- added for AAKH-CRF-0024 [IN:038260] -->\n\t\t\t\t<input type=\"hidden\" name=\"h_non_iv_admin_qty_";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\" id=\"h_non_iv_admin_qty_";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\"><!-- added for AAKH-CRF-0024 [IN:038260] -->\n";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\n\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_admin_qty_uom_";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\" id=\"non_iv_admin_qty_uom_";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\" style=\"color:";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 =";background-color:";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 =";font-size:10;\"><label> ";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="</label></td>\n\t\t\t\t";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\" id=\"non_iv_MFR_status_column_";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\n\t\t\t\t\t<!-- <label style=\"font-size:9;font-weight:bold;color:black\" >";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="</label> -->\n\t";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="<label name=\"non_iv_MFR_dtls_";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\" id=\"non_iv_MFR_dtls_";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\" style=\"font-size:10;color:blue;cursor:pointer;align:center;\" onClick=\"openMFRDetails(\'";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\',\'NotAdmin\',\'\',\'\',\'\',\'\',\'\',\'\',\'Y\');\">";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 =" <br>";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="</label>&nbsp;&nbsp;&nbsp;&nbsp <a href=\"#\"  onMouseOver=\"changeCursor(this);\" onClick=\"showMFRRemarks(\'";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\',\'Y\');\" id=\'mfrRemarksLink_";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\'>&nbsp;&nbsp;&nbsp;<font color=\"red\"><b>";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="</b></font></a>";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\n\t\t\t\t\t\t\t&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="</td>\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_mfrRemarks";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\" id=\"non_iv_mfrRemarks";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\n\t\t\t\t\t<label id=\'sch_date_time";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\' class=\'descFont\' >&nbsp;</label>\n";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\n\t\t\t\t</td>\t\t\t\t\n";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\">\n\t\t\t\t\t\t<label id=\'recordeddatetime";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\' class=\'descFont\' title=\"";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 =" : ";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\">";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="</label>\n\t\t\t\t\t\t<input type=\"text\" id=\"non_iv_time_";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\" name=\"non_iv_time_";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\" size=\"15\" maxlength=\"16\" value=\"";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 =" onBlur=\"validateAdminDateTime(\'";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\', this,\'";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\');\" style=\"font-size:11;display:none;\">\n\t\t\t\t\t</td>\n ";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\">&nbsp;</label>\n\t\t\t\t\t\t<input type=\"text\" id=\"non_iv_time_";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\');\" style=\"font-size:11;display:none;\">\n\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\n\t\t\t\t<input type=\"hidden\" name=\"non_iv_sch_date_time_";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\" id=\"non_iv_sch_date_time_";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\" ><input type=\'checkbox\'  id = \"pat_brought_med_";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\" name=\"pat_brought_med_";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\" onclick=\"enableDisableTextbox(\'";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\');\" checked disabled></td>\n";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\" ><input type=\'checkbox\' id = \"pat_brought_med_";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\');\" disabled></td>\n";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\n\t\t\t\t<input type=\"hidden\" name=\"onco_direct_drug_count_";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\" id=\"onco_direct_drug_count_";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\"><!-- added for AAKH-CRF-0024 [IN:038260] Starts -->\n\t\t\t\t<input type=\"hidden\" name=\"bat_id_lookbutton_enabled";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\" id=\"bat_id_lookbutton_enabled";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"medn_admn_dtl_reqd";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\" id=\"medn_admn_dtl_reqd";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"non_iv_drug_class";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\" id=\"non_iv_drug_class";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"non_iv_dtls_yn";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\" id=\"non_iv_dtls_yn";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\" value=\"N\">\t\n\t\t\t\t<input type=\"hidden\" name=\"non_iv_dosage_type_";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\" id=\"non_iv_dosage_type_";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"non_iv_qty_in_disp_mode_";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\" id=\"non_iv_qty_in_disp_mode_";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\" value=\"\">\n\t\t\t\t<input type=\"hidden\" name=\"Remarks";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\" id=\"Remarks";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\" value=\"N\">\n\t\t\t\t<input type=\"hidden\" name=\"iv_prep_yn_forNONIV";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\" id=\"iv_prep_yn_forNONIV";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"non_iv_trade_id_";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\" id=\"non_iv_trade_id_";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\" >\n\t\t\t\t<input type=\"hidden\" name=\"non_iv_bin_code_";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\" id=\"non_iv_bin_code_";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\" value=\"\" >\n\t\t\t\t<input type=\"hidden\" name=\"non_iv_trade_name_";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\" id=\"non_iv_trade_name_";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\" size=\"21\" maxlength=\"40\" disabled value=\"";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\" style=\"font-size:11;";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\">\t\t<!-- added for AAKH-CRF-0024 [IN:038260] Ends -->\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\n\t\t\t\t\t<label id = \'disp_batch_id";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\' style=\"font-size:9;font-weight:bold;color:black\" title=\"";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\">&nbsp;";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\' style=\"font-size:9;font-weight:bold;color:green\" title=\"";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="  ";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 =" :";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\" >&nbsp;";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\n\t\t\t\t\t</label>\n";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\t\t\t\t\t\n\t\t\t\t<input type=\"text\" id=\"non_iv_batch_id_";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\" name=\"non_iv_batch_id_";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="\" size=\"9\" maxlength=\"10\" value=\"";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="\"  style=\"font-size:11;display:none\" disabled>\n\t\t\t\t<input type=\"button\" id=\"non_iv_batch_id_but_";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\" class=\"button\" value=\"?\" name=\"non_iv_batch_id_but_";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 =" onClick=\"calcQuantityInDispensingUOM(\'NONIV\',\'";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="\');callMednBatchSearch(\'non_iv_batch_id_";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\',\'non_iv_expiry_date_";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="\',\'non_iv_trade_name_";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="\',\'non_iv_trade_id_";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\',\'non_iv_bin_code_";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="\',\'non_iv_time_";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="\',\'NONIV\',\'";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="\')\" style=\"visibility:hidden\">\n\t\t\t\t</td>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="\">\n\t\t\t\t\t<label  style=\"font-size:9;font-weight:bold;color:black\" id=\"lbl_expiry_date";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\" title=\'";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 =" &nbsp;";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="\'> &nbsp;";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="</label>\n\t\t\t\t\t<input type=\"text\" name=\"non_iv_expiry_date_";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="\" id=\"non_iv_expiry_date_";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="\" size=\"9\" maxlength=\"10\"  value=\"";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="\" disabled style=\"font-size:11;";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="\" onblur=\"ExpiryDateValidationForPatBroughtMedn(this)\"  style=\"display:none\"><IMG SRC=\"../../eCommon/images/CommonCalendar.gif\" id=\'exp_dt_cal_";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="\' onClick=\" showCalendar(\'non_iv_expiry_date_";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 ="\');\" style=\"visibility:hidden\" >\n\t\t\t\t</td>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="\" style=\"display:none\">\n\t\t\t\t\t<label  style=\"font-size:9;font-weight:bold;color:black\" id=\'lbl_trade_name";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="\'>&nbsp;";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="</label>\n\t\t\t\t</td>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 ="\"   style=\"";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 ="\n\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_admin_chng_dtls_req_";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="\" id=\"non_iv_admin_chng_dtls_req_";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 ="\" value=\"N\">\n\t\t\t\t\t<input type=\"checkbox\" id=\"non_iv_chk_";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 ="\" name=\"non_iv_chk_";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="\" value=\"E\" checked onClick=\"validateFieldsForDrug(this,\'";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 ="\') ; clearDrgRemarks(this,\'";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 ="\',\'NonIV\')\"  ";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 =" style=\"display:none\">\n\t\t\t\t\t<label id=\"non_iv_remarks_";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 ="\" name=\"non_iv_remarks_";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );

    private final static java.lang.String  _wl_block267 ="\" onClick=\"enterRemarks(\'";
    private final static byte[]  _wl_block267Bytes = _getBytes( _wl_block267 );

    private final static java.lang.String  _wl_block268 ="\',\'\',\'\',\'";
    private final static byte[]  _wl_block268Bytes = _getBytes( _wl_block268 );

    private final static java.lang.String  _wl_block269 ="\',\'\',\'";
    private final static byte[]  _wl_block269Bytes = _getBytes( _wl_block269 );

    private final static java.lang.String  _wl_block270 ="\',\'\',document.MedicationAdministrationFTDrugDetails.non_iv_admin_chng_dtls_req_";
    private final static byte[]  _wl_block270Bytes = _getBytes( _wl_block270 );

    private final static java.lang.String  _wl_block271 =",\'\',\'\',\'\',\'";
    private final static byte[]  _wl_block271Bytes = _getBytes( _wl_block271 );

    private final static java.lang.String  _wl_block272 ="\')\" style=\"display:none\">";
    private final static byte[]  _wl_block272Bytes = _getBytes( _wl_block272 );

    private final static java.lang.String  _wl_block273 ="</label>\n\t\t\t\t\t<img style=\"display:none\" src=\"../../eCommon/images/mandatory.gif\" align=\"center\" id=\"drug_remarks_mand_id_";
    private final static byte[]  _wl_block273Bytes = _getBytes( _wl_block273 );

    private final static java.lang.String  _wl_block274 ="\"></img>&nbsp; \n";
    private final static byte[]  _wl_block274Bytes = _getBytes( _wl_block274 );

    private final static java.lang.String  _wl_block275 ="\n\t\t\t\t\t\t<label id=\'adminDtls";
    private final static byte[]  _wl_block275Bytes = _getBytes( _wl_block275 );

    private final static java.lang.String  _wl_block276 ="\' style=\"font-size:9;font-weight:bold;color:black;\" title=\"";
    private final static byte[]  _wl_block276Bytes = _getBytes( _wl_block276 );

    private final static java.lang.String  _wl_block277 ="\" >";
    private final static byte[]  _wl_block277Bytes = _getBytes( _wl_block277 );

    private final static java.lang.String  _wl_block278 ="\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t<script>mandSymbolDisplayForOncology(\'ONLOAD\',\'";
    private final static byte[]  _wl_block278Bytes = _getBytes( _wl_block278 );

    private final static java.lang.String  _wl_block279 ="\')</script>\n";
    private final static byte[]  _wl_block279Bytes = _getBytes( _wl_block279 );

    private final static java.lang.String  _wl_block280 ="\t\t\t\t\t\n\t\t\t\t</td>\n\t\t\t\t<input type=\"hidden\" name=\"non_iv_mand_symbol_";
    private final static byte[]  _wl_block280Bytes = _getBytes( _wl_block280 );

    private final static java.lang.String  _wl_block281 ="\" id=\"non_iv_mand_symbol_";
    private final static byte[]  _wl_block281Bytes = _getBytes( _wl_block281 );

    private final static java.lang.String  _wl_block282 ="\">\t\t\t\t<!-- added for AAKH-CRF-0024 [IN:038260] STARTS -->\n";
    private final static byte[]  _wl_block282Bytes = _getBytes( _wl_block282 );

    private final static java.lang.String  _wl_block283 ="\n\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block283Bytes = _getBytes( _wl_block283 );

    private final static java.lang.String  _wl_block284 ="\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block284Bytes = _getBytes( _wl_block284 );

    private final static java.lang.String  _wl_block285 ="<!--GHL-CRF-0482 -->\n\t\t\t\t\t\t<!-- NMC-JD-CRF-0186-US002 [45063] -->\n\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block285Bytes = _getBytes( _wl_block285 );

    private final static java.lang.String  _wl_block286 ="\" > \n\t\t\t\t\t\t\n\t\t\t\t\t\t<input type=\"checkbox\" id=\"chk_non_iv_select_";
    private final static byte[]  _wl_block286Bytes = _getBytes( _wl_block286 );

    private final static java.lang.String  _wl_block287 ="\" name=\"chk_non_iv_select_";
    private final static byte[]  _wl_block287Bytes = _getBytes( _wl_block287 );

    private final static java.lang.String  _wl_block288 ="\" value=\"E\" ";
    private final static byte[]  _wl_block288Bytes = _getBytes( _wl_block288 );

    private final static java.lang.String  _wl_block289 =" style=\"display:none\" onClick=\"displayDosage(this,\'non_iv_admin_qty_";
    private final static byte[]  _wl_block289Bytes = _getBytes( _wl_block289 );

    private final static java.lang.String  _wl_block290 ="\', \'";
    private final static byte[]  _wl_block290Bytes = _getBytes( _wl_block290 );

    private final static java.lang.String  _wl_block291 ="\')";
    private final static byte[]  _wl_block291Bytes = _getBytes( _wl_block291 );

    private final static java.lang.String  _wl_block292 ="\">\n\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block292Bytes = _getBytes( _wl_block292 );

    private final static java.lang.String  _wl_block293 ="\">\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block293Bytes = _getBytes( _wl_block293 );

    private final static java.lang.String  _wl_block294 ="\n\t\t\t\t\t<img src=\"../../ePH/images/cancelAdmin.jpg\" align=\"center\"  width=\"17\" height=\"17\"  title=\"Cancel Admin\" onclick=\"cancelAdminstration(\'";
    private final static byte[]  _wl_block294Bytes = _getBytes( _wl_block294 );

    private final static java.lang.String  _wl_block295 ="\')\"></img></td>\n\t\t\t\t\t\n";
    private final static byte[]  _wl_block295Bytes = _getBytes( _wl_block295 );

    private final static java.lang.String  _wl_block296 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block296Bytes = _getBytes( _wl_block296 );

    private final static java.lang.String  _wl_block297 ="\" >\n\t\t\t\t\t\t\n\t\t\t\t\t\t<input type=\"checkbox\" id=\"chk_non_iv_select_";
    private final static byte[]  _wl_block297Bytes = _getBytes( _wl_block297 );

    private final static java.lang.String  _wl_block298 ="\');checkOncologyGroup(\'";
    private final static byte[]  _wl_block298Bytes = _getBytes( _wl_block298 );

    private final static java.lang.String  _wl_block299 ="\',this,\'";
    private final static byte[]  _wl_block299Bytes = _getBytes( _wl_block299 );

    private final static java.lang.String  _wl_block300 ="\">\n\t\t\t\t\t\t</td>\t\t\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block300Bytes = _getBytes( _wl_block300 );

    private final static java.lang.String  _wl_block301 ="\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block301Bytes = _getBytes( _wl_block301 );

    private final static java.lang.String  _wl_block302 ="\" ><!--GHL-CRF-0482 -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block302Bytes = _getBytes( _wl_block302 );

    private final static java.lang.String  _wl_block303 ="\n\t\t\t\t\t<!-- NMC-JD-CRF-0186-US002 [45063] -->\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block303Bytes = _getBytes( _wl_block303 );

    private final static java.lang.String  _wl_block304 ="\">\t\t\t\t\t\n\t\t\t\t\t<input type=\"checkbox\" id=\"chk_non_iv_select_";
    private final static byte[]  _wl_block304Bytes = _getBytes( _wl_block304 );

    private final static java.lang.String  _wl_block305 ="\" >\n\t\t\t\t\t";
    private final static byte[]  _wl_block305Bytes = _getBytes( _wl_block305 );

    private final static java.lang.String  _wl_block306 ="\n\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block306Bytes = _getBytes( _wl_block306 );

    private final static java.lang.String  _wl_block307 ="\t\t\t\t\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t<td class=\"white\" width=\"2%\" style=\"";
    private final static byte[]  _wl_block307Bytes = _getBytes( _wl_block307 );

    private final static java.lang.String  _wl_block308 ="</td>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block308Bytes = _getBytes( _wl_block308 );

    private final static java.lang.String  _wl_block309 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"non_iv_status_flag_";
    private final static byte[]  _wl_block309Bytes = _getBytes( _wl_block309 );

    private final static java.lang.String  _wl_block310 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"non_iv_end_date_";
    private final static byte[]  _wl_block310Bytes = _getBytes( _wl_block310 );

    private final static java.lang.String  _wl_block311 ="\">\t\t\n\t\t\t\t<input type=\"hidden\" name=\"non_iv_drug_class";
    private final static byte[]  _wl_block311Bytes = _getBytes( _wl_block311 );

    private final static java.lang.String  _wl_block312 ="\" value=\"N\">\t\t\t\t\t\t\t\n\t\t\t\t<input type=\"hidden\" name=\"medn_admn_dtl_reqd";
    private final static byte[]  _wl_block312Bytes = _getBytes( _wl_block312 );

    private final static java.lang.String  _wl_block313 ="\">\t\n\t\t\t\t<input type=\"hidden\" name=\"iv_prep_yn_forNONIV";
    private final static byte[]  _wl_block313Bytes = _getBytes( _wl_block313 );

    private final static java.lang.String  _wl_block314 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"non_iv_dosage_type_";
    private final static byte[]  _wl_block314Bytes = _getBytes( _wl_block314 );

    private final static java.lang.String  _wl_block315 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"onco_direct_drug_count_";
    private final static byte[]  _wl_block315Bytes = _getBytes( _wl_block315 );

    private final static java.lang.String  _wl_block316 ="\" value=\"\">\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t<input type=\"hidden\" name=\"Remarks";
    private final static byte[]  _wl_block316Bytes = _getBytes( _wl_block316 );

    private final static java.lang.String  _wl_block317 ="\" value=\"N\">\t\t\t\t\t\n\t\t\t\t<input type=\"hidden\" name=\"non_iv_Auto_Admin_";
    private final static byte[]  _wl_block317Bytes = _getBytes( _wl_block317 );

    private final static java.lang.String  _wl_block318 ="\"> <!-- //Added for [IN:040149]-->\n";
    private final static byte[]  _wl_block318Bytes = _getBytes( _wl_block318 );

    private final static java.lang.String  _wl_block319 ="\n\t\t\t\t\t<label style=\'color:red;font-size:12;FONT-WEIGHT: BOLDER;cursor:pointer;\' onclick=\"loadPage(\'";
    private final static byte[]  _wl_block319Bytes = _getBytes( _wl_block319 );

    private final static java.lang.String  _wl_block320 ="\n\t\t\t\t<label name=\"lbl_drug_desc\" style=\"font-size:10;\">";
    private final static byte[]  _wl_block320Bytes = _getBytes( _wl_block320 );

    private final static java.lang.String  _wl_block321 ="&nbsp;&nbsp;\n\t\t\t\t";
    private final static byte[]  _wl_block321Bytes = _getBytes( _wl_block321 );

    private final static java.lang.String  _wl_block322 ="\')\"></img>\n\t\t\t\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block322Bytes = _getBytes( _wl_block322 );

    private final static java.lang.String  _wl_block323 ="\t\t\t\t\t\n\t\t\t\t\t<img src=\"../../ePH/images/info.gif\" align=\"center\"  width=\"17\" height=\"17\" style=\"cursor:pointer;\" onClick=\"showDrugInfo(\'";
    private final static byte[]  _wl_block323Bytes = _getBytes( _wl_block323 );

    private final static java.lang.String  _wl_block324 ="\n\t\t\t\t\t\t  <img src=\'../../ePH/images/AddedIngredient.gif\' width=\'17\' height=\'15\' onclick = \"openPPNDisplay(\'";
    private final static byte[]  _wl_block324Bytes = _getBytes( _wl_block324 );

    private final static java.lang.String  _wl_block325 ="\')\" onmouseover=\"changeCursor(this);\">\t\t\t\t\t\t  \n";
    private final static byte[]  _wl_block325Bytes = _getBytes( _wl_block325 );

    private final static java.lang.String  _wl_block326 ="\n\t\t\t\t\t<img src=\'../../eCA/images/HI_RecordAllergies.gif\' width=\'17\' height=\'15\' onclick = \"showAllergyDetails(\'";
    private final static byte[]  _wl_block326Bytes = _getBytes( _wl_block326 );

    private final static java.lang.String  _wl_block327 ="\');\" onmouseover=\"changeCursor(this);\">\t\n";
    private final static byte[]  _wl_block327Bytes = _getBytes( _wl_block327 );

    private final static java.lang.String  _wl_block328 ="\t\n\t\t\t\t<img  id=\"alternate_image_";
    private final static byte[]  _wl_block328Bytes = _getBytes( _wl_block328 );

    private final static java.lang.String  _wl_block329 ="\" src=\'../../ePH/images/altenate.jpg\' style=\"cursor:pointer;";
    private final static byte[]  _wl_block329Bytes = _getBytes( _wl_block329 );

    private final static java.lang.String  _wl_block330 ="\" height=\'15\' width=\'15\' onClick=\"callAlternateDrugWindow(\'";
    private final static byte[]  _wl_block330Bytes = _getBytes( _wl_block330 );

    private final static java.lang.String  _wl_block331 ="\',\'Y\');\" title=\'";
    private final static byte[]  _wl_block331Bytes = _getBytes( _wl_block331 );

    private final static java.lang.String  _wl_block332 ="\'></img><!-- //Added for Bru-HIMS-CRF-399 [IN:043767]  and freq_nature added for Bru-HIMS-CRF-399.1-->\n";
    private final static byte[]  _wl_block332Bytes = _getBytes( _wl_block332 );

    private final static java.lang.String  _wl_block333 ="\t\t\t\n\t\t\t\t\t\t<label style=\'color:blue;text-align:right\' onmouseover=\"changeCursor(this);\"  onclick=\"taperCurrRow(\'";
    private final static byte[]  _wl_block333Bytes = _getBytes( _wl_block333 );

    private final static java.lang.String  _wl_block334 ="\t\t\t\t\t\t\n\t\t\t\t\t\t<label style=\'color:black;text-align:right\'>&nbsp;";
    private final static byte[]  _wl_block334Bytes = _getBytes( _wl_block334 );

    private final static java.lang.String  _wl_block335 ="\t\t\t\n\t\t\t\t</label>\n";
    private final static byte[]  _wl_block335Bytes = _getBytes( _wl_block335 );

    private final static java.lang.String  _wl_block336 ="\n\t\t\t\t<br><label id=\"id_dispdrugdesc_";
    private final static byte[]  _wl_block336Bytes = _getBytes( _wl_block336 );

    private final static java.lang.String  _wl_block337 ="\" style=\"font-size:9;color:green\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block337Bytes = _getBytes( _wl_block337 );

    private final static java.lang.String  _wl_block338 =" </label>\n\t\t\t\t<input type=\"hidden\" name=\"dispensed_drug_desc_";
    private final static byte[]  _wl_block338Bytes = _getBytes( _wl_block338 );

    private final static java.lang.String  _wl_block339 ="\" id=\"dispensed_drug_desc_";
    private final static byte[]  _wl_block339Bytes = _getBytes( _wl_block339 );

    private final static java.lang.String  _wl_block340 ="\n\t\t\t\t\t\t<br><label id=\'link_vaccine_label_";
    private final static byte[]  _wl_block340Bytes = _getBytes( _wl_block340 );

    private final static java.lang.String  _wl_block341 ="\' style=\"font-size:10;\" title=\'";
    private final static byte[]  _wl_block341Bytes = _getBytes( _wl_block341 );

    private final static java.lang.String  _wl_block342 ="\'> ";
    private final static byte[]  _wl_block342Bytes = _getBytes( _wl_block342 );

    private final static java.lang.String  _wl_block343 =" <input type=\'text\' size=10 name=\'link_vaccine_desc_";
    private final static byte[]  _wl_block343Bytes = _getBytes( _wl_block343 );

    private final static java.lang.String  _wl_block344 ="\' id=\'link_vaccine_desc_";
    private final static byte[]  _wl_block344Bytes = _getBytes( _wl_block344 );

    private final static java.lang.String  _wl_block345 ="\' value=\'";
    private final static byte[]  _wl_block345Bytes = _getBytes( _wl_block345 );

    private final static java.lang.String  _wl_block346 ="\' disabled><input type=button  class=\'button\' value=\'?\' name=\'btn_link_vaccine_";
    private final static byte[]  _wl_block346Bytes = _getBytes( _wl_block346 );

    private final static java.lang.String  _wl_block347 ="\' id=\'btn_link_vaccine_";
    private final static byte[]  _wl_block347Bytes = _getBytes( _wl_block347 );

    private final static java.lang.String  _wl_block348 ="\' onClick=\"linkVaccine(\'noniv\',\'";
    private final static byte[]  _wl_block348Bytes = _getBytes( _wl_block348 );

    private final static java.lang.String  _wl_block349 ="\')\"></label>\n\t\t\t\t\t\t<input type=\'hidden\' name=\"link_vaccine_code_";
    private final static byte[]  _wl_block349Bytes = _getBytes( _wl_block349 );

    private final static java.lang.String  _wl_block350 ="\" id=\"link_vaccine_code_";
    private final static byte[]  _wl_block350Bytes = _getBytes( _wl_block350 );

    private final static java.lang.String  _wl_block351 ="\" value=\'";
    private final static byte[]  _wl_block351Bytes = _getBytes( _wl_block351 );

    private final static java.lang.String  _wl_block352 ="\'>\n";
    private final static byte[]  _wl_block352Bytes = _getBytes( _wl_block352 );

    private final static java.lang.String  _wl_block353 ="\t\t\t\t\t\t\t\n\t\t\t\t</td>\n\t\t\t\t<td nowrap class=\'";
    private final static byte[]  _wl_block353Bytes = _getBytes( _wl_block353 );

    private final static java.lang.String  _wl_block354 ="\'  >&nbsp;</td>\n\t\t\t\t<td   class=\"";
    private final static byte[]  _wl_block354Bytes = _getBytes( _wl_block354 );

    private final static java.lang.String  _wl_block355 ="></img>\n\t\t\t\t</td>\n\t\t\t\t<td  class=\"";
    private final static byte[]  _wl_block355Bytes = _getBytes( _wl_block355 );

    private final static java.lang.String  _wl_block356 =" \n\t\t\t\t\t<label  style=\"cursor:pointer;font-size:9;color:blue\" onClick=\"showDrugDetails(\'\',\'\',\'";
    private final static byte[]  _wl_block356Bytes = _getBytes( _wl_block356 );

    private final static java.lang.String  _wl_block357 ="\" style=\"\">\n";
    private final static byte[]  _wl_block357Bytes = _getBytes( _wl_block357 );

    private final static java.lang.String  _wl_block358 ="\n\t\t\t\t\t<input type=\"text\" name=\"non_iv_sliding_range_";
    private final static byte[]  _wl_block358Bytes = _getBytes( _wl_block358 );

    private final static java.lang.String  _wl_block359 ="\" id=\"non_iv_sliding_range_";
    private final static byte[]  _wl_block359Bytes = _getBytes( _wl_block359 );

    private final static java.lang.String  _wl_block360 ="\" size=\"5\" maxlength=\"13\" onKeyPress=\"return allowValidNumber(this,event,6,3);\" oncopy=\"return false\" onpaste=\"return false\"  onBlur=\"CheckNum(this);findValuesRange(this,";
    private final static byte[]  _wl_block360Bytes = _getBytes( _wl_block360 );

    private final static java.lang.String  _wl_block361 =")\" value=\"\" class=\"NUMBER\" style=\"font-size:11;";
    private final static byte[]  _wl_block361Bytes = _getBytes( _wl_block361 );

    private final static java.lang.String  _wl_block362 ="><label style=\"font-size:10;";
    private final static byte[]  _wl_block362Bytes = _getBytes( _wl_block362 );

    private final static java.lang.String  _wl_block363 ="\" ><b>";
    private final static byte[]  _wl_block363Bytes = _getBytes( _wl_block363 );

    private final static java.lang.String  _wl_block364 ="</b></label>\n\t\t\t\t\t<input type=\"text\" name=\"non_iv_admin_qty_";
    private final static byte[]  _wl_block364Bytes = _getBytes( _wl_block364 );

    private final static java.lang.String  _wl_block365 ="\" size=\"5\" maxlength=\"13\" onKeyPress=\"return allowValidNumber(this,event,6,3);\" oncopy=\"return false\" onpaste=\"return false\" onBlur=\"CheckNum(this)\" value=\"\" class=\"NUMBER\" style=\"font-size:11;";
    private final static byte[]  _wl_block365Bytes = _getBytes( _wl_block365 );

    private final static java.lang.String  _wl_block366 ="</b></label> \n\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_admin_qty_uom_";
    private final static byte[]  _wl_block366Bytes = _getBytes( _wl_block366 );

    private final static java.lang.String  _wl_block367 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_range_uom_";
    private final static byte[]  _wl_block367Bytes = _getBytes( _wl_block367 );

    private final static java.lang.String  _wl_block368 ="\" id=\"non_iv_range_uom_";
    private final static byte[]  _wl_block368Bytes = _getBytes( _wl_block368 );

    private final static java.lang.String  _wl_block369 ="\n\t\t\t\t\t\t<input type=\"hidden\" name=\"sliding_scale_ranges_from_";
    private final static byte[]  _wl_block369Bytes = _getBytes( _wl_block369 );

    private final static java.lang.String  _wl_block370 ="_";
    private final static byte[]  _wl_block370Bytes = _getBytes( _wl_block370 );

    private final static java.lang.String  _wl_block371 ="\" id=\"sliding_scale_ranges_from_";
    private final static byte[]  _wl_block371Bytes = _getBytes( _wl_block371 );

    private final static java.lang.String  _wl_block372 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"sliding_scale_ranges_to_";
    private final static byte[]  _wl_block372Bytes = _getBytes( _wl_block372 );

    private final static java.lang.String  _wl_block373 ="\" id=\"sliding_scale_ranges_to_";
    private final static byte[]  _wl_block373Bytes = _getBytes( _wl_block373 );

    private final static java.lang.String  _wl_block374 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"sliding_scale_adm_qty_";
    private final static byte[]  _wl_block374Bytes = _getBytes( _wl_block374 );

    private final static java.lang.String  _wl_block375 ="\" id=\"sliding_scale_adm_qty_";
    private final static byte[]  _wl_block375Bytes = _getBytes( _wl_block375 );

    private final static java.lang.String  _wl_block376 ="\n\t\t\t\t\t<input type=\"hidden\" name=\"sliding_scale_srl_no_";
    private final static byte[]  _wl_block376Bytes = _getBytes( _wl_block376 );

    private final static java.lang.String  _wl_block377 ="\" id=\"sliding_scale_srl_no_";
    private final static byte[]  _wl_block377Bytes = _getBytes( _wl_block377 );

    private final static java.lang.String  _wl_block378 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_admin_chng_dtls_req_";
    private final static byte[]  _wl_block378Bytes = _getBytes( _wl_block378 );

    private final static java.lang.String  _wl_block379 ="\" value=\"N\">\n\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_admin_quaty_";
    private final static byte[]  _wl_block379Bytes = _getBytes( _wl_block379 );

    private final static java.lang.String  _wl_block380 ="\" id=\"non_iv_admin_quaty_";
    private final static byte[]  _wl_block380Bytes = _getBytes( _wl_block380 );

    private final static java.lang.String  _wl_block381 ="\" value=\"\"><!-- GHL-CRF-0458.1-->\n\t\t\t\t\t\n";
    private final static byte[]  _wl_block381Bytes = _getBytes( _wl_block381 );

    private final static java.lang.String  _wl_block382 ="\t\t\t\t\t\t\n\t\t\t\t\t\t<input type=\"text\" name=\"non_iv_admin_qty1_";
    private final static byte[]  _wl_block382Bytes = _getBytes( _wl_block382 );

    private final static java.lang.String  _wl_block383 ="\" id=\"non_iv_admin_qty1_";
    private final static byte[]  _wl_block383Bytes = _getBytes( _wl_block383 );

    private final static java.lang.String  _wl_block384 ="><label id=\"id_dosage_uom_";
    private final static byte[]  _wl_block384Bytes = _getBytes( _wl_block384 );

    private final static java.lang.String  _wl_block385 ="\" style=\"font-size:10;";
    private final static byte[]  _wl_block385Bytes = _getBytes( _wl_block385 );

    private final static java.lang.String  _wl_block386 ="</b></label> \n";
    private final static byte[]  _wl_block386Bytes = _getBytes( _wl_block386 );

    private final static java.lang.String  _wl_block387 ="\t\n\t\t\t\t\t\t\t<label style=\"font-size:10;";
    private final static byte[]  _wl_block387Bytes = _getBytes( _wl_block387 );

    private final static java.lang.String  _wl_block388 ="\" id = \"bal_qty_";
    private final static byte[]  _wl_block388Bytes = _getBytes( _wl_block388 );

    private final static java.lang.String  _wl_block389 ="\"><b>";
    private final static byte[]  _wl_block389Bytes = _getBytes( _wl_block389 );

    private final static java.lang.String  _wl_block390 ="&nbsp;";
    private final static byte[]  _wl_block390Bytes = _getBytes( _wl_block390 );

    private final static java.lang.String  _wl_block391 ="</b></label>\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_bal_qty_";
    private final static byte[]  _wl_block391Bytes = _getBytes( _wl_block391 );

    private final static java.lang.String  _wl_block392 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_admin_qty_";
    private final static byte[]  _wl_block392Bytes = _getBytes( _wl_block392 );

    private final static java.lang.String  _wl_block393 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_admin_qty_uom_";
    private final static byte[]  _wl_block393Bytes = _getBytes( _wl_block393 );

    private final static java.lang.String  _wl_block394 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_admin_qty_uom1_";
    private final static byte[]  _wl_block394Bytes = _getBytes( _wl_block394 );

    private final static java.lang.String  _wl_block395 ="\" id=\"non_iv_admin_qty_uom1_";
    private final static byte[]  _wl_block395Bytes = _getBytes( _wl_block395 );

    private final static java.lang.String  _wl_block396 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"h_non_iv_admin_qty_";
    private final static byte[]  _wl_block396Bytes = _getBytes( _wl_block396 );

    private final static java.lang.String  _wl_block397 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_admin_chng_dtls_req_";
    private final static byte[]  _wl_block397Bytes = _getBytes( _wl_block397 );

    private final static java.lang.String  _wl_block398 ="\" value=\"N\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_admin_quaty_";
    private final static byte[]  _wl_block398Bytes = _getBytes( _wl_block398 );

    private final static java.lang.String  _wl_block399 ="\">\n\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block399Bytes = _getBytes( _wl_block399 );

    private final static java.lang.String  _wl_block400 ="\n\t\t\t\t\t\t\t<label style=\"font-size:10;";
    private final static byte[]  _wl_block400Bytes = _getBytes( _wl_block400 );

    private final static java.lang.String  _wl_block401 ="\"><!-- GHL-CRF-0458.1-->\n";
    private final static byte[]  _wl_block401Bytes = _getBytes( _wl_block401 );

    private final static java.lang.String  _wl_block402 ="\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t<input type=\"text\" name=\"non_iv_admin_qty_";
    private final static byte[]  _wl_block402Bytes = _getBytes( _wl_block402 );

    private final static java.lang.String  _wl_block403 ="\" size=\"5\" maxlength=\"13\" onKeyPress=\"return\tallowValidNumber(this,event,6,3);\" oncopy=\"return false\" onpaste=\"return false\"  onBlur=\"CheckNum(this); makeDtlsMandatory(this,\'";
    private final static byte[]  _wl_block403Bytes = _getBytes( _wl_block403 );

    private final static java.lang.String  _wl_block404 ="\');\" value=\"";
    private final static byte[]  _wl_block404Bytes = _getBytes( _wl_block404 );

    private final static java.lang.String  _wl_block405 ="\"  style=\"font-size:10;\t";
    private final static byte[]  _wl_block405Bytes = _getBytes( _wl_block405 );

    private final static java.lang.String  _wl_block406 ="</b></label><!-- Add freq_nature in makeDtlsMandatory() function for SKR-SCF-0304[29563] -->\t\t  \t\t \n\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_admin_qty_uom_";
    private final static byte[]  _wl_block406Bytes = _getBytes( _wl_block406 );

    private final static java.lang.String  _wl_block407 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"h_non_iv_admin_qty_";
    private final static byte[]  _wl_block407Bytes = _getBytes( _wl_block407 );

    private final static java.lang.String  _wl_block408 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_admin_chng_dtls_req_";
    private final static byte[]  _wl_block408Bytes = _getBytes( _wl_block408 );

    private final static java.lang.String  _wl_block409 ="\" value=\"N\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_admin_quaty_";
    private final static byte[]  _wl_block409Bytes = _getBytes( _wl_block409 );

    private final static java.lang.String  _wl_block410 =" \n\t\t\t\t</td>\n\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block410Bytes = _getBytes( _wl_block410 );

    private final static java.lang.String  _wl_block411 ="\" style=\'color:";
    private final static byte[]  _wl_block411Bytes = _getBytes( _wl_block411 );

    private final static java.lang.String  _wl_block412 =";font-size:10;\'><label style=\"font-size:10;\"> ";
    private final static byte[]  _wl_block412Bytes = _getBytes( _wl_block412 );

    private final static java.lang.String  _wl_block413 ="</label></td>\n";
    private final static byte[]  _wl_block413Bytes = _getBytes( _wl_block413 );

    private final static java.lang.String  _wl_block414 ="\" ><label style=\"font-size:9;font-weight;color:black\">&nbsp;</label></td>\n";
    private final static byte[]  _wl_block414Bytes = _getBytes( _wl_block414 );

    private final static java.lang.String  _wl_block415 ="\n\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block415Bytes = _getBytes( _wl_block415 );

    private final static java.lang.String  _wl_block416 ="\" ><label style=\"font-size:9;font-weight;color:black\">";
    private final static byte[]  _wl_block416Bytes = _getBytes( _wl_block416 );

    private final static java.lang.String  _wl_block417 ="\" style=\"\">\n\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_sch_date_time_";
    private final static byte[]  _wl_block417Bytes = _getBytes( _wl_block417 );

    private final static java.lang.String  _wl_block418 ="\">\n\t\t\t\t\t<input type=\"text\" name=\"non_iv_time_";
    private final static byte[]  _wl_block418Bytes = _getBytes( _wl_block418 );

    private final static java.lang.String  _wl_block419 ="\" id=\"non_iv_time_";
    private final static byte[]  _wl_block419Bytes = _getBytes( _wl_block419 );

    private final static java.lang.String  _wl_block420 ="\');\" style=\"font-size:11;";
    private final static byte[]  _wl_block420Bytes = _getBytes( _wl_block420 );

    private final static java.lang.String  _wl_block421 ="\"> <!--  AdminBackLogTime changed to Sch_AdminBackLogTime for TTM-SCF-0171-907901  -->\n\t\t\t\t</td>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block421Bytes = _getBytes( _wl_block421 );

    private final static java.lang.String  _wl_block422 ="\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block422Bytes = _getBytes( _wl_block422 );

    private final static java.lang.String  _wl_block423 ="\"><input type=\'checkbox\'\tname=\"pat_brought_med_";
    private final static byte[]  _wl_block423Bytes = _getBytes( _wl_block423 );

    private final static java.lang.String  _wl_block424 ="\" id=\"pat_brought_med_";
    private final static byte[]  _wl_block424Bytes = _getBytes( _wl_block424 );

    private final static java.lang.String  _wl_block425 ="\',\'NOT\',\'";
    private final static byte[]  _wl_block425Bytes = _getBytes( _wl_block425 );

    private final static java.lang.String  _wl_block426 ="\');\"\tdisabled></td>\n\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block426Bytes = _getBytes( _wl_block426 );

    private final static java.lang.String  _wl_block427 ="\" style=\"\">\n\t\t\t\t\t\t\t<input type=\"text\" name=\"non_iv_batch_id_";
    private final static byte[]  _wl_block427Bytes = _getBytes( _wl_block427 );

    private final static java.lang.String  _wl_block428 ="\" id=\"non_iv_batch_id_";
    private final static byte[]  _wl_block428Bytes = _getBytes( _wl_block428 );

    private final static java.lang.String  _wl_block429 ="\"  size=\"9\" maxlength=\"10\" value=\"";
    private final static byte[]  _wl_block429Bytes = _getBytes( _wl_block429 );

    private final static java.lang.String  _wl_block430 ="\"  disabled > \n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"previous_non_iv_batch_id_";
    private final static byte[]  _wl_block430Bytes = _getBytes( _wl_block430 );

    private final static java.lang.String  _wl_block431 ="\" id=\"previous_non_iv_batch_id_";
    private final static byte[]  _wl_block431Bytes = _getBytes( _wl_block431 );

    private final static java.lang.String  _wl_block432 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"previous_non_iv_exp_date_";
    private final static byte[]  _wl_block432Bytes = _getBytes( _wl_block432 );

    private final static java.lang.String  _wl_block433 ="\" id=\"previous_non_iv_exp_date_";
    private final static byte[]  _wl_block433Bytes = _getBytes( _wl_block433 );

    private final static java.lang.String  _wl_block434 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"previous_non_iv_trade_id_";
    private final static byte[]  _wl_block434Bytes = _getBytes( _wl_block434 );

    private final static java.lang.String  _wl_block435 ="\" id=\"previous_non_iv_trade_id_";
    private final static byte[]  _wl_block435Bytes = _getBytes( _wl_block435 );

    private final static java.lang.String  _wl_block436 ="\" value=\"\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_batch_order_id_";
    private final static byte[]  _wl_block436Bytes = _getBytes( _wl_block436 );

    private final static java.lang.String  _wl_block437 ="\" id=\"non_iv_batch_order_id_";
    private final static byte[]  _wl_block437Bytes = _getBytes( _wl_block437 );

    private final static java.lang.String  _wl_block438 ="\"> <!-- GHL-CRF-0482-->\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_batch_order_line_no_";
    private final static byte[]  _wl_block438Bytes = _getBytes( _wl_block438 );

    private final static java.lang.String  _wl_block439 ="\" id=\"non_iv_batch_order_line_no_";
    private final static byte[]  _wl_block439Bytes = _getBytes( _wl_block439 );

    private final static java.lang.String  _wl_block440 ="\"><!-- GHL-CRF-0482-->\n";
    private final static byte[]  _wl_block440Bytes = _getBytes( _wl_block440 );

    private final static java.lang.String  _wl_block441 ="\" ><input type=\'checkbox\' name=\"pat_brought_med_";
    private final static byte[]  _wl_block441Bytes = _getBytes( _wl_block441 );

    private final static java.lang.String  _wl_block442 ="\');\"></td>\n\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block442Bytes = _getBytes( _wl_block442 );

    private final static java.lang.String  _wl_block443 ="\" style=\"\"><input type=\'checkbox\' name=\'non_iv_shared_drug_";
    private final static byte[]  _wl_block443Bytes = _getBytes( _wl_block443 );

    private final static java.lang.String  _wl_block444 ="\' id=\'non_iv_shared_drug_";
    private final static byte[]  _wl_block444Bytes = _getBytes( _wl_block444 );

    private final static java.lang.String  _wl_block445 ="\' title=\'Shared Drug\' value=\"N\" onclick=\"chkShrdDrug(this,\'";
    private final static byte[]  _wl_block445Bytes = _getBytes( _wl_block445 );

    private final static java.lang.String  _wl_block446 ="\')\" style=\'";
    private final static byte[]  _wl_block446Bytes = _getBytes( _wl_block446 );

    private final static java.lang.String  _wl_block447 ="\'><!-- Added for HSA-CRF-0090 -->\n\t\t\t\t\t\t\t<input type=\"text\" name=\"non_iv_batch_id_";
    private final static byte[]  _wl_block447Bytes = _getBytes( _wl_block447 );

    private final static java.lang.String  _wl_block448 ="\"  style=\"font-size:11;";
    private final static byte[]  _wl_block448Bytes = _getBytes( _wl_block448 );

    private final static java.lang.String  _wl_block449 ="\" disabled>\n\t\t\t\t\t\t\t<input type=\"button\" class=\"button\" value=\"?\" name=\"non_iv_batch_id_but_";
    private final static byte[]  _wl_block449Bytes = _getBytes( _wl_block449 );

    private final static java.lang.String  _wl_block450 ="\" id=\"non_iv_batch_id_but_";
    private final static byte[]  _wl_block450Bytes = _getBytes( _wl_block450 );

    private final static java.lang.String  _wl_block451 ="\',document.MedicationAdministrationFTDrugDetails.non_iv_dispense_drug_code_";
    private final static byte[]  _wl_block451Bytes = _getBytes( _wl_block451 );

    private final static java.lang.String  _wl_block452 =".value,\'";
    private final static byte[]  _wl_block452Bytes = _getBytes( _wl_block452 );

    private final static java.lang.String  _wl_block453 ="\')\" style=\"";
    private final static byte[]  _wl_block453Bytes = _getBytes( _wl_block453 );

    private final static java.lang.String  _wl_block454 ="\">\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\"Newly_administerderd_";
    private final static byte[]  _wl_block454Bytes = _getBytes( _wl_block454 );

    private final static java.lang.String  _wl_block455 ="\" id=\"Newly_administerderd_";
    private final static byte[]  _wl_block455Bytes = _getBytes( _wl_block455 );

    private final static java.lang.String  _wl_block456 ="\" value=\'NONIV_Y\'>\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"previous_non_iv_batch_id_";
    private final static byte[]  _wl_block456Bytes = _getBytes( _wl_block456 );

    private final static java.lang.String  _wl_block457 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_batch_order_id_";
    private final static byte[]  _wl_block457Bytes = _getBytes( _wl_block457 );

    private final static java.lang.String  _wl_block458 ="\"><!-- GHL-CRF-0482-->\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_batch_order_line_no_";
    private final static byte[]  _wl_block458Bytes = _getBytes( _wl_block458 );

    private final static java.lang.String  _wl_block459 ="\"><!-- GHL-CRF-0482-->\n\t\t\t\t\t\t\t<script>//Added for Bru-HIMS-CRF-399 [IN:043767] \n\t\t\t\t\t\t\tif(document.MedicationAdministrationFTDrugDetails.non_iv_batch_id_";
    private final static byte[]  _wl_block459Bytes = _getBytes( _wl_block459 );

    private final static java.lang.String  _wl_block460 =".value ==\'\'){\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tdocument.getElementById(\"id_dispdrugdesc_\"+";
    private final static byte[]  _wl_block460Bytes = _getBytes( _wl_block460 );

    private final static java.lang.String  _wl_block461 =").innerHTML = \'\';\n\t\t\t\t\t\t\t\tdocument.MedicationAdministrationFTDrugDetails.non_iv_dispense_drug_code_";
    private final static byte[]  _wl_block461Bytes = _getBytes( _wl_block461 );

    private final static java.lang.String  _wl_block462 =".value = \'";
    private final static byte[]  _wl_block462Bytes = _getBytes( _wl_block462 );

    private final static java.lang.String  _wl_block463 ="\';\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block463Bytes = _getBytes( _wl_block463 );

    private final static java.lang.String  _wl_block464 ="\n\t\t\t\t\t\t\t<script>//Added for Bru-HIMS-CRF-399 [IN:043767]\n\t\t\t\t\t\t\t document.getElementById(\"alternate_image_\"+";
    private final static byte[]  _wl_block464Bytes = _getBytes( _wl_block464 );

    private final static java.lang.String  _wl_block465 =").style.display=\"none\";\n\t\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block465Bytes = _getBytes( _wl_block465 );

    private final static java.lang.String  _wl_block466 ="\n\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block466Bytes = _getBytes( _wl_block466 );

    private final static java.lang.String  _wl_block467 ="\"><input type=\'checkbox\' name=\"pat_brought_med_";
    private final static byte[]  _wl_block467Bytes = _getBytes( _wl_block467 );

    private final static java.lang.String  _wl_block468 ="\',\'N\',\'";
    private final static byte[]  _wl_block468Bytes = _getBytes( _wl_block468 );

    private final static java.lang.String  _wl_block469 ="\');\" disabled></td>\n\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block469Bytes = _getBytes( _wl_block469 );

    private final static java.lang.String  _wl_block470 ="\" style=\"\"><input type=\'hidden\' name=\'non_iv_shared_drug_";
    private final static byte[]  _wl_block470Bytes = _getBytes( _wl_block470 );

    private final static java.lang.String  _wl_block471 ="\' value=\"N\" ><!-- Added for HSA-CRF-0090[IN041241] -->\n\t\t\t\t\t\t\t\t<input type=\"text\" name=\"non_iv_batch_id_";
    private final static byte[]  _wl_block471Bytes = _getBytes( _wl_block471 );

    private final static java.lang.String  _wl_block472 ="\" disabled style=\"font-size:11;\"><input type=\"button\" class=\"button\" name=\"non_iv_batch_id_but_";
    private final static byte[]  _wl_block472Bytes = _getBytes( _wl_block472 );

    private final static java.lang.String  _wl_block473 ="\" value=\"?\"  ";
    private final static byte[]  _wl_block473Bytes = _getBytes( _wl_block473 );

    private final static java.lang.String  _wl_block474 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"previous_non_iv_batch_id_";
    private final static byte[]  _wl_block474Bytes = _getBytes( _wl_block474 );

    private final static java.lang.String  _wl_block475 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"previous_non_iv_exp_date_";
    private final static byte[]  _wl_block475Bytes = _getBytes( _wl_block475 );

    private final static java.lang.String  _wl_block476 ="\">\t\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"previous_non_iv_trade_id_";
    private final static byte[]  _wl_block476Bytes = _getBytes( _wl_block476 );

    private final static java.lang.String  _wl_block477 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"batch_ids_size_";
    private final static byte[]  _wl_block477Bytes = _getBytes( _wl_block477 );

    private final static java.lang.String  _wl_block478 ="\" id=\"batch_ids_size_";
    private final static byte[]  _wl_block478Bytes = _getBytes( _wl_block478 );

    private final static java.lang.String  _wl_block479 ="\"><!--added for CRF-413.8 -->\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_barcode_id_";
    private final static byte[]  _wl_block479Bytes = _getBytes( _wl_block479 );

    private final static java.lang.String  _wl_block480 ="\" id=\"non_iv_barcode_id_";
    private final static byte[]  _wl_block480Bytes = _getBytes( _wl_block480 );

    private final static java.lang.String  _wl_block481 ="\"><!--added for CRF-413.8 -->\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_batch_order_id_";
    private final static byte[]  _wl_block481Bytes = _getBytes( _wl_block481 );

    private final static java.lang.String  _wl_block482 ="\"> <!-- GHL-CRF-0482-->\n";
    private final static byte[]  _wl_block482Bytes = _getBytes( _wl_block482 );

    private final static java.lang.String  _wl_block483 ="\"><input type=checkbox name=\"pat_brought_med_";
    private final static byte[]  _wl_block483Bytes = _getBytes( _wl_block483 );

    private final static java.lang.String  _wl_block484 ="\" style=\"\">\n\t\t\t\t\t\t\t\t<input type=\"text\" name=\"non_iv_batch_id_";
    private final static byte[]  _wl_block484Bytes = _getBytes( _wl_block484 );

    private final static java.lang.String  _wl_block485 ="\" size=\"9\" maxlength=\"10\" value=\"\" disabled style=\"font-size:11;\"><input type=\"button\" class=\"button\" name=\"non_iv_batch_id_but_";
    private final static byte[]  _wl_block485Bytes = _getBytes( _wl_block485 );

    private final static java.lang.String  _wl_block486 ="\"><!--added for CRF-413.8 -->\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_batch_order_id_";
    private final static byte[]  _wl_block486Bytes = _getBytes( _wl_block486 );

    private final static java.lang.String  _wl_block487 ="\"> <!-- GHL-CRF-0482-->\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_batch_order_line_no_";
    private final static byte[]  _wl_block487Bytes = _getBytes( _wl_block487 );

    private final static java.lang.String  _wl_block488 =").style.display=\"none\";\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block488Bytes = _getBytes( _wl_block488 );

    private final static java.lang.String  _wl_block489 ="\" ><input type=checkbox name=\"pat_brought_med_";
    private final static byte[]  _wl_block489Bytes = _getBytes( _wl_block489 );

    private final static java.lang.String  _wl_block490 ="\');\" disabled ></td>\n\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block490Bytes = _getBytes( _wl_block490 );

    private final static java.lang.String  _wl_block491 ="\' value=\"N\" ><!-- Added for HSA-CRF-0090[IN041241] -->\n\t\t\t\t\t\t\t<select name=\"non_iv_batch_id_";
    private final static byte[]  _wl_block491Bytes = _getBytes( _wl_block491 );

    private final static java.lang.String  _wl_block492 ="\" onChange=\"assignBatchDetails(\'";
    private final static byte[]  _wl_block492Bytes = _getBytes( _wl_block492 );

    private final static java.lang.String  _wl_block493 ="\',\'NON_IV\',this,\'";
    private final static byte[]  _wl_block493Bytes = _getBytes( _wl_block493 );

    private final static java.lang.String  _wl_block494 ="\',\'Y\',\'";
    private final static byte[]  _wl_block494Bytes = _getBytes( _wl_block494 );

    private final static java.lang.String  _wl_block495 ="\')\"><!-- disp_drug_code,order_id,order_line_num,Freq_nature,disp_drugs added for BRU-CRF-399.1-->\n\t\t\t\t\t\t\t<option value=\"\">---";
    private final static byte[]  _wl_block495Bytes = _getBytes( _wl_block495 );

    private final static java.lang.String  _wl_block496 ="---</option>\n";
    private final static byte[]  _wl_block496Bytes = _getBytes( _wl_block496 );

    private final static java.lang.String  _wl_block497 ="\n\t\t\t\t\t\t\t\t\t<option  selected value=\"";
    private final static byte[]  _wl_block497Bytes = _getBytes( _wl_block497 );

    private final static java.lang.String  _wl_block498 ="</option>\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"previous_non_iv_batch_id_";
    private final static byte[]  _wl_block498Bytes = _getBytes( _wl_block498 );

    private final static java.lang.String  _wl_block499 ="\">\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"previous_non_iv_exp_date_";
    private final static byte[]  _wl_block499Bytes = _getBytes( _wl_block499 );

    private final static java.lang.String  _wl_block500 ="\">\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"previous_non_iv_trade_id_";
    private final static byte[]  _wl_block500Bytes = _getBytes( _wl_block500 );

    private final static java.lang.String  _wl_block501 ="\n\t\t\t\t\t\t\t\t\t<option  value=\"";
    private final static byte[]  _wl_block501Bytes = _getBytes( _wl_block501 );

    private final static java.lang.String  _wl_block502 ="</option>\n";
    private final static byte[]  _wl_block502Bytes = _getBytes( _wl_block502 );

    private final static java.lang.String  _wl_block503 ="\n\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block503Bytes = _getBytes( _wl_block503 );

    private final static java.lang.String  _wl_block504 ="\t\t\t\t\t\t\n\t\t\t\t\t\t\t</select>\t\n\t\t\t\t\t<input type=\"hidden\" name=\"batch_ids_size_";
    private final static byte[]  _wl_block504Bytes = _getBytes( _wl_block504 );

    private final static java.lang.String  _wl_block505 ="\"><!--added for CRF-413.8 -->\n\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_batch_order_id_";
    private final static byte[]  _wl_block505Bytes = _getBytes( _wl_block505 );

    private final static java.lang.String  _wl_block506 ="\"><!-- GHL-CRF-0482-->\n\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_batch_order_line_no_";
    private final static byte[]  _wl_block506Bytes = _getBytes( _wl_block506 );

    private final static java.lang.String  _wl_block507 ="\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_barcode_id_";
    private final static byte[]  _wl_block507Bytes = _getBytes( _wl_block507 );

    private final static java.lang.String  _wl_block508 ="\">\n\t\t\t\t\t\t  <input type=\"hidden\" name=\"non_iv_alt_drug_code_";
    private final static byte[]  _wl_block508Bytes = _getBytes( _wl_block508 );

    private final static java.lang.String  _wl_block509 ="\" id=\"non_iv_alt_drug_code_";
    private final static byte[]  _wl_block509Bytes = _getBytes( _wl_block509 );

    private final static java.lang.String  _wl_block510 ="\">\n\t\t\t\t\t\t  <input type=\"hidden\" name=\"non_iv_batch_id_alt_";
    private final static byte[]  _wl_block510Bytes = _getBytes( _wl_block510 );

    private final static java.lang.String  _wl_block511 ="\" id=\"non_iv_batch_id_alt_";
    private final static byte[]  _wl_block511Bytes = _getBytes( _wl_block511 );

    private final static java.lang.String  _wl_block512 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_batch_order_id_";
    private final static byte[]  _wl_block512Bytes = _getBytes( _wl_block512 );

    private final static java.lang.String  _wl_block513 ="\">  <!-- GHL-CRF-0482-->\n\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_batch_order_line_no_";
    private final static byte[]  _wl_block513Bytes = _getBytes( _wl_block513 );

    private final static java.lang.String  _wl_block514 ="\t\t\t\t\t\t<input type=\"hidden\" name=\"placed_from_verbal_order_";
    private final static byte[]  _wl_block514Bytes = _getBytes( _wl_block514 );

    private final static java.lang.String  _wl_block515 ="\" id=\"placed_from_verbal_order_";
    private final static byte[]  _wl_block515Bytes = _getBytes( _wl_block515 );

    private final static java.lang.String  _wl_block516 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"batch_assigned_verbal_order_";
    private final static byte[]  _wl_block516Bytes = _getBytes( _wl_block516 );

    private final static java.lang.String  _wl_block517 ="\" id=\"batch_assigned_verbal_order_";
    private final static byte[]  _wl_block517Bytes = _getBytes( _wl_block517 );

    private final static java.lang.String  _wl_block518 ="\" value=\"\"><!-- added for GHL-CRF-0509 -->\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block518Bytes = _getBytes( _wl_block518 );

    private final static java.lang.String  _wl_block519 ="\" style=\"\">\n\t\t\t\t\t\t\t<input type=\"text\" name=\"non_iv_expiry_date_";
    private final static byte[]  _wl_block519Bytes = _getBytes( _wl_block519 );

    private final static java.lang.String  _wl_block520 ="\" onblur=\"ExpiryDateValidationForPatBroughtMedn(this)\"><IMG SRC=\"../../eCommon/images/CommonCalendar.gif\" id=\'exp_dt_cal_";
    private final static byte[]  _wl_block520Bytes = _getBytes( _wl_block520 );

    private final static java.lang.String  _wl_block521 ="\');\" style=\"display:none\" >\n\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block521Bytes = _getBytes( _wl_block521 );

    private final static java.lang.String  _wl_block522 ="\t\n\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block522Bytes = _getBytes( _wl_block522 );

    private final static java.lang.String  _wl_block523 ="\');\"></td>\n\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block523Bytes = _getBytes( _wl_block523 );

    private final static java.lang.String  _wl_block524 ="\" style=\"\">\n\t\t\t\t\t\t<input type=\"text\" name=\"non_iv_batch_id_";
    private final static byte[]  _wl_block524Bytes = _getBytes( _wl_block524 );

    private final static java.lang.String  _wl_block525 ="\" size=\"9\" maxlength=\"10\" value=\"\"  style=\"font-size:11;";
    private final static byte[]  _wl_block525Bytes = _getBytes( _wl_block525 );

    private final static java.lang.String  _wl_block526 ="\" disabled><input type=\"button\" name=\"non_iv_batch_id_but_";
    private final static byte[]  _wl_block526Bytes = _getBytes( _wl_block526 );

    private final static java.lang.String  _wl_block527 ="\" class=\"button\" value=\"?\" disabled \n\t\t\t\t\t\tonClick=\"\" style=\"";
    private final static byte[]  _wl_block527Bytes = _getBytes( _wl_block527 );

    private final static java.lang.String  _wl_block528 ="\">\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block528Bytes = _getBytes( _wl_block528 );

    private final static java.lang.String  _wl_block529 ="\" style=\"\">\n\t\t\t\t\t\t<input type=\"text\" name=\"non_iv_expiry_date_";
    private final static byte[]  _wl_block529Bytes = _getBytes( _wl_block529 );

    private final static java.lang.String  _wl_block530 ="\" size=\"9\" maxlength=\"10\"  value=\"\" disabled onblur=\"ExpiryDateValidationForPatBroughtMedn(this)\"><IMG SRC=\"../../eCommon/images/CommonCalendar.gif\" id=\'exp_dt_cal_";
    private final static byte[]  _wl_block530Bytes = _getBytes( _wl_block530 );

    private final static java.lang.String  _wl_block531 ="\" checked disabled></td>\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block531Bytes = _getBytes( _wl_block531 );

    private final static java.lang.String  _wl_block532 ="\" style=\"\">\n\t\t\t\t\t<input type=\"text\" name=\"non_iv_batch_id_";
    private final static byte[]  _wl_block532Bytes = _getBytes( _wl_block532 );

    private final static java.lang.String  _wl_block533 ="\"><input type=\"button\" class=\"button\" value=\"?\" disabled onClick=\"\" style=\"";
    private final static byte[]  _wl_block533Bytes = _getBytes( _wl_block533 );

    private final static java.lang.String  _wl_block534 ="\"  name=\"non_iv_batch_id_but_";
    private final static byte[]  _wl_block534Bytes = _getBytes( _wl_block534 );

    private final static java.lang.String  _wl_block535 ="\">\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block535Bytes = _getBytes( _wl_block535 );

    private final static java.lang.String  _wl_block536 ="\" style=\"\">\n\t\t\t\t\t<input type=\"text\" name=\"non_iv_expiry_date_";
    private final static byte[]  _wl_block536Bytes = _getBytes( _wl_block536 );

    private final static java.lang.String  _wl_block537 ="\" size=\"9\" maxlength=\"10\"  value=\"\" onblur=\"ExpiryDateValidationForPatBroughtMedn(this)\"><IMG SRC=\"../../eCommon/images/CommonCalendar.gif\" id=\'exp_dt_cal_";
    private final static byte[]  _wl_block537Bytes = _getBytes( _wl_block537 );

    private final static java.lang.String  _wl_block538 ="\');\">\n\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block538Bytes = _getBytes( _wl_block538 );

    private final static java.lang.String  _wl_block539 ="\" style=\"display:none\">\n\t\t\t\t<input type=\"hidden\" name=\"non_iv_trade_id_";
    private final static byte[]  _wl_block539Bytes = _getBytes( _wl_block539 );

    private final static java.lang.String  _wl_block540 ="\">\n\t\t\t\t</td>\n";
    private final static byte[]  _wl_block540Bytes = _getBytes( _wl_block540 );

    private final static java.lang.String  _wl_block541 =">\n";
    private final static byte[]  _wl_block541Bytes = _getBytes( _wl_block541 );

    private final static java.lang.String  _wl_block542 ="\n\t\t\t\t\t<input type=\"checkbox\" name=\"non_iv_chk_";
    private final static byte[]  _wl_block542Bytes = _getBytes( _wl_block542 );

    private final static java.lang.String  _wl_block543 ="\" id=\"non_iv_chk_";
    private final static byte[]  _wl_block543Bytes = _getBytes( _wl_block543 );

    private final static java.lang.String  _wl_block544 =" style=\"";
    private final static byte[]  _wl_block544Bytes = _getBytes( _wl_block544 );

    private final static java.lang.String  _wl_block545 ="\"  ";
    private final static byte[]  _wl_block545Bytes = _getBytes( _wl_block545 );

    private final static java.lang.String  _wl_block546 =">\n\t\t\t\t\t\n\t\t\t\t\t<label name=\"non_iv_remarks_";
    private final static byte[]  _wl_block546Bytes = _getBytes( _wl_block546 );

    private final static java.lang.String  _wl_block547 ="\',document.MedicationAdministrationFTDrugDetails.non_iv_admin_chng_dtls_req_";
    private final static byte[]  _wl_block547Bytes = _getBytes( _wl_block547 );

    private final static java.lang.String  _wl_block548 =")\" style=\"";
    private final static byte[]  _wl_block548Bytes = _getBytes( _wl_block548 );

    private final static java.lang.String  _wl_block549 ="</label>\n\t\t\t\t\t\n\t\t\t\t\t<img src=\"../../eCommon/images/mandatory.gif\" align=\"center\" id=\"drug_remarks_mand_id_";
    private final static byte[]  _wl_block549Bytes = _getBytes( _wl_block549 );

    private final static java.lang.String  _wl_block550 ="></img>\n";
    private final static byte[]  _wl_block550Bytes = _getBytes( _wl_block550 );

    private final static java.lang.String  _wl_block551 ="\n\t\t\t\t</td>\t\n\t\t\t\t<input type=\"hidden\" name=\"non_iv_mand_symbol_";
    private final static byte[]  _wl_block551Bytes = _getBytes( _wl_block551 );

    private final static java.lang.String  _wl_block552 ="\">\t\t\t\t\n";
    private final static byte[]  _wl_block552Bytes = _getBytes( _wl_block552 );

    private final static java.lang.String  _wl_block553 ="\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block553Bytes = _getBytes( _wl_block553 );

    private final static java.lang.String  _wl_block554 ="\"> <!-- GHL-CRF-0482-->\n\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"non_iv_patient_stock_";
    private final static byte[]  _wl_block554Bytes = _getBytes( _wl_block554 );

    private final static java.lang.String  _wl_block555 ="\" id=\"non_iv_patient_stock_";
    private final static byte[]  _wl_block555Bytes = _getBytes( _wl_block555 );

    private final static java.lang.String  _wl_block556 ="\" onclick=\"PatientStockCheck(this,\'";
    private final static byte[]  _wl_block556Bytes = _getBytes( _wl_block556 );

    private final static java.lang.String  _wl_block557 ="\')\" ";
    private final static byte[]  _wl_block557Bytes = _getBytes( _wl_block557 );

    private final static java.lang.String  _wl_block558 =" >\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<!--  Charanges for NMC-JD-CRF-0186 [43323]-->\n\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block558Bytes = _getBytes( _wl_block558 );

    private final static java.lang.String  _wl_block559 ="\n\t\t\t\t\t\t<input type=\"checkbox\" name=\"chk_non_iv_select_";
    private final static byte[]  _wl_block559Bytes = _getBytes( _wl_block559 );

    private final static java.lang.String  _wl_block560 ="\" id=\"chk_non_iv_select_";
    private final static byte[]  _wl_block560Bytes = _getBytes( _wl_block560 );

    private final static java.lang.String  _wl_block561 =" onClick=\"displayDosage(this,";
    private final static byte[]  _wl_block561Bytes = _getBytes( _wl_block561 );

    private final static java.lang.String  _wl_block562 =",\'";
    private final static byte[]  _wl_block562Bytes = _getBytes( _wl_block562 );

    private final static java.lang.String  _wl_block563 ="\')\"  ";
    private final static byte[]  _wl_block563Bytes = _getBytes( _wl_block563 );

    private final static java.lang.String  _wl_block564 ="  >\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<!--  Charanges for NMC-JD-CRF-0186[43323]-->\n\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block564Bytes = _getBytes( _wl_block564 );

    private final static java.lang.String  _wl_block565 ="\"><!-- GHL-CRF-0482-->\n\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"non_iv_patient_stock_";
    private final static byte[]  _wl_block565Bytes = _getBytes( _wl_block565 );

    private final static java.lang.String  _wl_block566 =" >\n\t\t\t\t\t</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block566Bytes = _getBytes( _wl_block566 );

    private final static java.lang.String  _wl_block567 ="\" onClick=\"displayDosage(this,";
    private final static byte[]  _wl_block567Bytes = _getBytes( _wl_block567 );

    private final static java.lang.String  _wl_block568 ="\');validateQtyAck(this,\'";
    private final static byte[]  _wl_block568Bytes = _getBytes( _wl_block568 );

    private final static java.lang.String  _wl_block569 ="\n\t\t\t\t\t<!--  Charanges for NMC-JD-CRF-0186[43323] -->\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block569Bytes = _getBytes( _wl_block569 );

    private final static java.lang.String  _wl_block570 ="\">  \n\t\t\t\t\t";
    private final static byte[]  _wl_block570Bytes = _getBytes( _wl_block570 );

    private final static java.lang.String  _wl_block571 ="\n\t\t\t\t\t<input type=\"checkbox\" name=\"chk_non_iv_select_";
    private final static byte[]  _wl_block571Bytes = _getBytes( _wl_block571 );

    private final static java.lang.String  _wl_block572 ="\" >\n\t\t\t\t\t</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block572Bytes = _getBytes( _wl_block572 );

    private final static java.lang.String  _wl_block573 ="\n\t\t\t\t</tr>\n\t\t\t\t<input type=\"hidden\" name=\"allowed_yn_";
    private final static byte[]  _wl_block573Bytes = _getBytes( _wl_block573 );

    private final static java.lang.String  _wl_block574 ="\" id=\"allowed_yn_";
    private final static byte[]  _wl_block574Bytes = _getBytes( _wl_block574 );

    private final static java.lang.String  _wl_block575 ="\" value = \"\"><!--added for GHL-CRF-0458 and recCount added for IN066062 -->\n\t\t\t\t<input type=\"hidden\" name=\"alt_dosage_";
    private final static byte[]  _wl_block575Bytes = _getBytes( _wl_block575 );

    private final static java.lang.String  _wl_block576 ="\" id=\"alt_dosage_";
    private final static byte[]  _wl_block576Bytes = _getBytes( _wl_block576 );

    private final static java.lang.String  _wl_block577 ="\"><!--BRU-CRF-399.1 -->\n\t\t\t\t<input type=\"hidden\" name=\"alt_dosage_uom_";
    private final static byte[]  _wl_block577Bytes = _getBytes( _wl_block577 );

    private final static java.lang.String  _wl_block578 ="\" id=\"alt_dosage_uom_";
    private final static byte[]  _wl_block578Bytes = _getBytes( _wl_block578 );

    private final static java.lang.String  _wl_block579 ="\"><!--BRU-CRF-399.1 -->\n\t\t\t\t<input type=\"hidden\" name=\"alt_MAR_YN_";
    private final static byte[]  _wl_block579Bytes = _getBytes( _wl_block579 );

    private final static java.lang.String  _wl_block580 ="\" id=\"alt_MAR_YN_";
    private final static byte[]  _wl_block580Bytes = _getBytes( _wl_block580 );

    private final static java.lang.String  _wl_block581 ="\" value=\"N\"><!--BRU-CRF-399.1 -->\n\t\t\t\t<input type=\"hidden\" name=\"future_or_late_";
    private final static byte[]  _wl_block581Bytes = _getBytes( _wl_block581 );

    private final static java.lang.String  _wl_block582 ="\" id=\"future_or_late_";
    private final static byte[]  _wl_block582Bytes = _getBytes( _wl_block582 );

    private final static java.lang.String  _wl_block583 ="\" value = \"";
    private final static byte[]  _wl_block583Bytes = _getBytes( _wl_block583 );

    private final static java.lang.String  _wl_block584 ="\"><!-- Added for GHL-CRF-0482 [IN:064955] -->\n\t\t\t\t<input type=\"hidden\" name=\"patient_brgt_medn_";
    private final static byte[]  _wl_block584Bytes = _getBytes( _wl_block584 );

    private final static java.lang.String  _wl_block585 ="\" id=\"patient_brgt_medn_";
    private final static byte[]  _wl_block585Bytes = _getBytes( _wl_block585 );

    private final static java.lang.String  _wl_block586 ="\"> <!--GHL-CRF-0482 -->\n";
    private final static byte[]  _wl_block586Bytes = _getBytes( _wl_block586 );

    private final static java.lang.String  _wl_block587 ="\n\t\t\t\t\t\t<tr >\n\t\t\t\t\t\t<td class=\"white\" style=\"background:#CC99CC\" width=\'2%\'>&nbsp;</td>\n\t\t\t\t\t\t<td style=\"font-size:09;\" style=\"color:#CC99CC\" color=\"#CC99CC\" class=\"";
    private final static byte[]  _wl_block587Bytes = _getBytes( _wl_block587 );

    private final static java.lang.String  _wl_block588 ="\">&nbsp;&nbsp;&nbsp;&nbsp;<b>";
    private final static byte[]  _wl_block588Bytes = _getBytes( _wl_block588 );

    private final static java.lang.String  _wl_block589 ="</b>\n\t\t\t\t\t\t<input type=\"hidden\" name=\"alt_drug_code_";
    private final static byte[]  _wl_block589Bytes = _getBytes( _wl_block589 );

    private final static java.lang.String  _wl_block590 ="\" id=\"alt_drug_code_";
    private final static byte[]  _wl_block590Bytes = _getBytes( _wl_block590 );

    private final static java.lang.String  _wl_block591 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"main_drug_code_";
    private final static byte[]  _wl_block591Bytes = _getBytes( _wl_block591 );

    private final static java.lang.String  _wl_block592 ="\" id=\"main_drug_code_";
    private final static byte[]  _wl_block592Bytes = _getBytes( _wl_block592 );

    private final static java.lang.String  _wl_block593 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"alt_dosage_seq_no_";
    private final static byte[]  _wl_block593Bytes = _getBytes( _wl_block593 );

    private final static java.lang.String  _wl_block594 ="\" id=\"alt_dosage_seq_no_";
    private final static byte[]  _wl_block594Bytes = _getBytes( _wl_block594 );

    private final static java.lang.String  _wl_block595 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"alt_item_code_";
    private final static byte[]  _wl_block595Bytes = _getBytes( _wl_block595 );

    private final static java.lang.String  _wl_block596 ="\" id=\"alt_item_code_";
    private final static byte[]  _wl_block596Bytes = _getBytes( _wl_block596 );

    private final static java.lang.String  _wl_block597 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"alt_order_id_";
    private final static byte[]  _wl_block597Bytes = _getBytes( _wl_block597 );

    private final static java.lang.String  _wl_block598 ="\" id=\"alt_order_id_";
    private final static byte[]  _wl_block598Bytes = _getBytes( _wl_block598 );

    private final static java.lang.String  _wl_block599 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"alt_order_line_no_";
    private final static byte[]  _wl_block599Bytes = _getBytes( _wl_block599 );

    private final static java.lang.String  _wl_block600 ="\" id=\"alt_order_line_no_";
    private final static byte[]  _wl_block600Bytes = _getBytes( _wl_block600 );

    private final static java.lang.String  _wl_block601 ="\">\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td style=\"font-size:09;\" class=\"";
    private final static byte[]  _wl_block601Bytes = _getBytes( _wl_block601 );

    private final static java.lang.String  _wl_block602 ="\">&nbsp;&nbsp;</td>\n\t\t\t\t\t\t<td style=\"font-size:09;\" class=\"";
    private final static byte[]  _wl_block602Bytes = _getBytes( _wl_block602 );

    private final static java.lang.String  _wl_block603 ="\">\n\t\t\t\t\t\t<input type=\"text\" name=\"alt_admin_qty_";
    private final static byte[]  _wl_block603Bytes = _getBytes( _wl_block603 );

    private final static java.lang.String  _wl_block604 ="\" id=\"alt_admin_qty_";
    private final static byte[]  _wl_block604Bytes = _getBytes( _wl_block604 );

    private final static java.lang.String  _wl_block605 ="\" size=\"1\" maxlength=\"4\" onKeyPress=\"return allowValidNumber(this,event,6,3);\" onBlur=\"CheckNum(this); makeDtlsMandatory(this,\'";
    private final static byte[]  _wl_block605Bytes = _getBytes( _wl_block605 );

    private final static java.lang.String  _wl_block606 ="\',\'alt\',\'";
    private final static byte[]  _wl_block606Bytes = _getBytes( _wl_block606 );

    private final static java.lang.String  _wl_block607 ="\" class=\"NUMBER\" style=\"font-size:11\"><label style=\"font-size:10\" id=\"\"><b>";
    private final static byte[]  _wl_block607Bytes = _getBytes( _wl_block607 );

    private final static java.lang.String  _wl_block608 ="</b></label> \n\t\t\t\t\t\t<input type=\"hidden\" name=\"h_alt_admin_qty_";
    private final static byte[]  _wl_block608Bytes = _getBytes( _wl_block608 );

    private final static java.lang.String  _wl_block609 ="\" id=\"h_alt_admin_qty_";
    private final static byte[]  _wl_block609Bytes = _getBytes( _wl_block609 );

    private final static java.lang.String  _wl_block610 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"alt_admin_qty_uom_";
    private final static byte[]  _wl_block610Bytes = _getBytes( _wl_block610 );

    private final static java.lang.String  _wl_block611 ="\" id=\"alt_admin_qty_uom_";
    private final static byte[]  _wl_block611Bytes = _getBytes( _wl_block611 );

    private final static java.lang.String  _wl_block612 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"alt_store_code_";
    private final static byte[]  _wl_block612Bytes = _getBytes( _wl_block612 );

    private final static java.lang.String  _wl_block613 ="\" id=\"alt_store_code_";
    private final static byte[]  _wl_block613Bytes = _getBytes( _wl_block613 );

    private final static java.lang.String  _wl_block614 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"alt_end_date_";
    private final static byte[]  _wl_block614Bytes = _getBytes( _wl_block614 );

    private final static java.lang.String  _wl_block615 ="\" id=\"alt_end_date_";
    private final static byte[]  _wl_block615Bytes = _getBytes( _wl_block615 );

    private final static java.lang.String  _wl_block616 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"alt_admin_chng_dtls_req_";
    private final static byte[]  _wl_block616Bytes = _getBytes( _wl_block616 );

    private final static java.lang.String  _wl_block617 ="\" id=\"alt_admin_chng_dtls_req_";
    private final static byte[]  _wl_block617Bytes = _getBytes( _wl_block617 );

    private final static java.lang.String  _wl_block618 ="\" value=\"N\">\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block618Bytes = _getBytes( _wl_block618 );

    private final static java.lang.String  _wl_block619 =";font-size:10;\"><label style=\"font-size:10;\"> ";
    private final static byte[]  _wl_block619Bytes = _getBytes( _wl_block619 );

    private final static java.lang.String  _wl_block620 ="</label></td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block620Bytes = _getBytes( _wl_block620 );

    private final static java.lang.String  _wl_block621 ="\n\t\t\t\t\t\t<td style=\"font-size:09;\" class=\"";
    private final static byte[]  _wl_block621Bytes = _getBytes( _wl_block621 );

    private final static java.lang.String  _wl_block622 ="\">\n\t\t\t\t\t\t<input type=\"text\" name=\"alt_schedule_time_";
    private final static byte[]  _wl_block622Bytes = _getBytes( _wl_block622 );

    private final static java.lang.String  _wl_block623 ="\" id=\"alt_schedule_time_";
    private final static byte[]  _wl_block623Bytes = _getBytes( _wl_block623 );

    private final static java.lang.String  _wl_block624 ="\" size=\"5\" maxlength=\"5\" value=\"\" readOnly style=\"font-size:11;text-align:right\">\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td style=\"font-size:09;\" class=\"";
    private final static byte[]  _wl_block624Bytes = _getBytes( _wl_block624 );

    private final static java.lang.String  _wl_block625 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"alt_schedule_date_time_";
    private final static byte[]  _wl_block625Bytes = _getBytes( _wl_block625 );

    private final static java.lang.String  _wl_block626 ="\" id=\"alt_schedule_date_time_";
    private final static byte[]  _wl_block626Bytes = _getBytes( _wl_block626 );

    private final static java.lang.String  _wl_block627 ="\">\n\t\t\t\t\t\t<input type=\"text\" name=\"alt_time_";
    private final static byte[]  _wl_block627Bytes = _getBytes( _wl_block627 );

    private final static java.lang.String  _wl_block628 ="\" id=\"alt_time_";
    private final static byte[]  _wl_block628Bytes = _getBytes( _wl_block628 );

    private final static java.lang.String  _wl_block629 ="\" onBlur=\"validateAdminDateTime(\'";
    private final static byte[]  _wl_block629Bytes = _getBytes( _wl_block629 );

    private final static java.lang.String  _wl_block630 ="\');\" style=\"font-size:11\" onBlur=\"\">\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td style=\"font-size:09;\" class=\"";
    private final static byte[]  _wl_block630Bytes = _getBytes( _wl_block630 );

    private final static java.lang.String  _wl_block631 ="\n\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'alt_shared_drug_";
    private final static byte[]  _wl_block631Bytes = _getBytes( _wl_block631 );

    private final static java.lang.String  _wl_block632 ="\' id=\'alt_shared_drug_";
    private final static byte[]  _wl_block632Bytes = _getBytes( _wl_block632 );

    private final static java.lang.String  _wl_block633 ="\'><!-- Added for HSA-CRF-0090[IN041241] -->\n\t\t\t\t\t\t\t<input type=\"text\" name=\"alt_batch_id_";
    private final static byte[]  _wl_block633Bytes = _getBytes( _wl_block633 );

    private final static java.lang.String  _wl_block634 ="\" id=\"alt_batch_id_";
    private final static byte[]  _wl_block634Bytes = _getBytes( _wl_block634 );

    private final static java.lang.String  _wl_block635 ="\" style=\"font-size:11\" disabled>\n\t\t\t\t\t\t\t<input type=\"button\" class=\"button\" value=\"?\" onClick=\"calcQuantityInDispensingUOM(\'ALT\',\'";
    private final static byte[]  _wl_block635Bytes = _getBytes( _wl_block635 );

    private final static java.lang.String  _wl_block636 ="\');callMednBatchSearch(\'alt_batch_id_";
    private final static byte[]  _wl_block636Bytes = _getBytes( _wl_block636 );

    private final static java.lang.String  _wl_block637 ="\',\'alt_expiry_date_";
    private final static byte[]  _wl_block637Bytes = _getBytes( _wl_block637 );

    private final static java.lang.String  _wl_block638 ="\',\'alt_trade_name_";
    private final static byte[]  _wl_block638Bytes = _getBytes( _wl_block638 );

    private final static java.lang.String  _wl_block639 ="\',\'alt_trade_id_";
    private final static byte[]  _wl_block639Bytes = _getBytes( _wl_block639 );

    private final static java.lang.String  _wl_block640 ="\',\'alt_bin_code_";
    private final static byte[]  _wl_block640Bytes = _getBytes( _wl_block640 );

    private final static java.lang.String  _wl_block641 ="\',\'alt_time_";
    private final static byte[]  _wl_block641Bytes = _getBytes( _wl_block641 );

    private final static java.lang.String  _wl_block642 ="\',\'ALT\',\'";
    private final static byte[]  _wl_block642Bytes = _getBytes( _wl_block642 );

    private final static java.lang.String  _wl_block643 ="\')\" >\n";
    private final static byte[]  _wl_block643Bytes = _getBytes( _wl_block643 );

    private final static java.lang.String  _wl_block644 ="\t\t\t\t\t\t\t<input type=\'hidden\' name=\'alt_shared_drug_";
    private final static byte[]  _wl_block644Bytes = _getBytes( _wl_block644 );

    private final static java.lang.String  _wl_block645 ="\' value=\"N\" ><!-- Added for HSA-CRF-0090[IN041241] -->\n\t\t\t\t\t\t\t<select name=\"alt_batch_id_";
    private final static byte[]  _wl_block645Bytes = _getBytes( _wl_block645 );

    private final static java.lang.String  _wl_block646 ="\" style=\"font-size:11;\">\n\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block646Bytes = _getBytes( _wl_block646 );

    private final static java.lang.String  _wl_block647 ="</option>\n\t\t\t\t\t\t\t</select>\t\t\t\t\t\n";
    private final static byte[]  _wl_block647Bytes = _getBytes( _wl_block647 );

    private final static java.lang.String  _wl_block648 ="\t\t\t\t\t\t\t<input type=\'hidden\' name=\"alt_shared_drug_";
    private final static byte[]  _wl_block648Bytes = _getBytes( _wl_block648 );

    private final static java.lang.String  _wl_block649 ="\" id=\"alt_shared_drug_";
    private final static byte[]  _wl_block649Bytes = _getBytes( _wl_block649 );

    private final static java.lang.String  _wl_block650 ="\" value=\"N\" ><!-- Added for HSA-CRF-0090[IN041241] -->\n\t\t\t\t\t\t\t<select name=\"alt_batch_id_";
    private final static byte[]  _wl_block650Bytes = _getBytes( _wl_block650 );

    private final static java.lang.String  _wl_block651 ="\" style=\"font-size:11;\" onChange=\"assignBatchDetails(\'";
    private final static byte[]  _wl_block651Bytes = _getBytes( _wl_block651 );

    private final static java.lang.String  _wl_block652 ="\',\'ALT_NON_IV\',this,\'";
    private final static byte[]  _wl_block652Bytes = _getBytes( _wl_block652 );

    private final static java.lang.String  _wl_block653 ="\n\t\t\t\t\t\t\t\t\t<option selected value=\"";
    private final static byte[]  _wl_block653Bytes = _getBytes( _wl_block653 );

    private final static java.lang.String  _wl_block654 ="\n\t\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block654Bytes = _getBytes( _wl_block654 );

    private final static java.lang.String  _wl_block655 ="\t\t\t\t\t\t\n\t\t\t\t\t\t\t</select>\t\t\t\t\t\n";
    private final static byte[]  _wl_block655Bytes = _getBytes( _wl_block655 );

    private final static java.lang.String  _wl_block656 ="\t\t\t\t\t\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td style=\"font-size:09;\" class=\"";
    private final static byte[]  _wl_block656Bytes = _getBytes( _wl_block656 );

    private final static java.lang.String  _wl_block657 ="\">\n\t\t\t\t\t\t<input type=\"text\" name=\"alt_expiry_date_";
    private final static byte[]  _wl_block657Bytes = _getBytes( _wl_block657 );

    private final static java.lang.String  _wl_block658 ="\" id=\"alt_expiry_date_";
    private final static byte[]  _wl_block658Bytes = _getBytes( _wl_block658 );

    private final static java.lang.String  _wl_block659 ="\" disabled style=\"font-size:11\">\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td style=\"font-size:09;\" class=\"";
    private final static byte[]  _wl_block659Bytes = _getBytes( _wl_block659 );

    private final static java.lang.String  _wl_block660 ="\" style=\"display:none\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"alt_trade_name_";
    private final static byte[]  _wl_block660Bytes = _getBytes( _wl_block660 );

    private final static java.lang.String  _wl_block661 ="\" id=\"alt_trade_name_";
    private final static byte[]  _wl_block661Bytes = _getBytes( _wl_block661 );

    private final static java.lang.String  _wl_block662 ="\" style=\"font-size:11\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"alt_trade_id_";
    private final static byte[]  _wl_block662Bytes = _getBytes( _wl_block662 );

    private final static java.lang.String  _wl_block663 ="\" id=\"alt_trade_id_";
    private final static byte[]  _wl_block663Bytes = _getBytes( _wl_block663 );

    private final static java.lang.String  _wl_block664 ="\" >\n\t\t\t\t\t\t<input type=\"hidden\" name=\"alt_bin_code_";
    private final static byte[]  _wl_block664Bytes = _getBytes( _wl_block664 );

    private final static java.lang.String  _wl_block665 ="\" id=\"alt_bin_code_";
    private final static byte[]  _wl_block665Bytes = _getBytes( _wl_block665 );

    private final static java.lang.String  _wl_block666 ="\" value=\"\" >\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td style=\"font-size:09;\" class=\"";
    private final static byte[]  _wl_block666Bytes = _getBytes( _wl_block666 );

    private final static java.lang.String  _wl_block667 ="\">\n\t\t\t\t\t\t<input type=\"checkbox\" name=\"alt_chk_";
    private final static byte[]  _wl_block667Bytes = _getBytes( _wl_block667 );

    private final static java.lang.String  _wl_block668 ="\" id=\"alt_chk_";
    private final static byte[]  _wl_block668Bytes = _getBytes( _wl_block668 );

    private final static java.lang.String  _wl_block669 ="\" value=\"E\" checked onClick=\"\">\n\t\t\t\t\t\t<label name=\"alt_remarks_";
    private final static byte[]  _wl_block669Bytes = _getBytes( _wl_block669 );

    private final static java.lang.String  _wl_block670 ="\" style=\"font-size:10;color:blue;cursor:pointer;align:center\" onClick=\"enterRemarks(\'";
    private final static byte[]  _wl_block670Bytes = _getBytes( _wl_block670 );

    private final static java.lang.String  _wl_block671 ="\',\'\',\'\',\'\',\'\',\'\',\'\',\'";
    private final static byte[]  _wl_block671Bytes = _getBytes( _wl_block671 );

    private final static java.lang.String  _wl_block672 ="</label>&nbsp;\n\t\t\t\t\t\t<img src=\"../../eCommon/images/mandatory.gif\" align=\"center\" id=\"alt_drug_remarks_mand_id_";
    private final static byte[]  _wl_block672Bytes = _getBytes( _wl_block672 );

    private final static java.lang.String  _wl_block673 ="\" ></img>\n\t\t\t\t\t\t<input type=\"hidden\" name=\"alt_mand_symbol_";
    private final static byte[]  _wl_block673Bytes = _getBytes( _wl_block673 );

    private final static java.lang.String  _wl_block674 ="\" id=\"alt_mand_symbol_";
    private final static byte[]  _wl_block674Bytes = _getBytes( _wl_block674 );

    private final static java.lang.String  _wl_block675 ="\" value=\"style=\'display:inline\'\"\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block675Bytes = _getBytes( _wl_block675 );

    private final static java.lang.String  _wl_block676 ="\" >\n\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"non_iv_patient_stock_";
    private final static byte[]  _wl_block676Bytes = _getBytes( _wl_block676 );

    private final static java.lang.String  _wl_block677 =" >\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block677Bytes = _getBytes( _wl_block677 );

    private final static java.lang.String  _wl_block678 ="\n\t\t\t\t\t\t</td><!-- GHL-CRF-0482-->\n\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block678Bytes = _getBytes( _wl_block678 );

    private final static java.lang.String  _wl_block679 ="\">\n\t\t\t\t\t\t<input type=\"checkbox\" name=\"chk_alt_non_iv_select_";
    private final static byte[]  _wl_block679Bytes = _getBytes( _wl_block679 );

    private final static java.lang.String  _wl_block680 ="\" id=\"chk_alt_non_iv_select_";
    private final static byte[]  _wl_block680Bytes = _getBytes( _wl_block680 );

    private final static java.lang.String  _wl_block681 ="\" value=\"E\" checked>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t";
    private final static byte[]  _wl_block681Bytes = _getBytes( _wl_block681 );

    private final static java.lang.String  _wl_block682 ="\n\t\t</table>\n\t\t</div>\n";
    private final static byte[]  _wl_block682Bytes = _getBytes( _wl_block682 );

    private final static java.lang.String  _wl_block683 ="\t\n\t<br>\n\t<input type=\"hidden\" name=\"iv_records\" id=\"iv_records\"\tvalue=\"\">\n\t";
    private final static byte[]  _wl_block683Bytes = _getBytes( _wl_block683 );

    private final static java.lang.String  _wl_block684 =" \n\t";
    private final static byte[]  _wl_block684Bytes = _getBytes( _wl_block684 );

    private final static java.lang.String  _wl_block685 ="  \n\t";
    private final static byte[]  _wl_block685Bytes = _getBytes( _wl_block685 );

    private final static java.lang.String  _wl_block686 ="\n\t\t";
    private final static byte[]  _wl_block686Bytes = _getBytes( _wl_block686 );

    private final static java.lang.String  _wl_block687 =" \n\t\t\t";
    private final static byte[]  _wl_block687Bytes = _getBytes( _wl_block687 );

    private final static java.lang.String  _wl_block688 ="\t\n";
    private final static byte[]  _wl_block688Bytes = _getBytes( _wl_block688 );

    private final static java.lang.String  _wl_block689 ="\n\t  <table align=\"center\"><tr><td colspan=\"222\" class=\"white\">&nbsp;</td><td  class=\"white\" ><input type=\"button\" class=\"button\" name=\"cancel\" id=\"cancel\" value=\'";
    private final static byte[]  _wl_block689Bytes = _getBytes( _wl_block689 );

    private final static java.lang.String  _wl_block690 ="\' onclick=\"callCancel()\"></td><td   class=\"white\" ><input type=\"button\" class=\"button\" name=\"record\" id=\"record\" value=\'";
    private final static byte[]  _wl_block690Bytes = _getBytes( _wl_block690 );

    private final static java.lang.String  _wl_block691 ="\' onclick=\"callrecord()\"></td></tr>\n\t  </table>\n";
    private final static byte[]  _wl_block691Bytes = _getBytes( _wl_block691 );

    private final static java.lang.String  _wl_block692 ="\n<script language=\"javascript\">\n\tif(parent.parent.frames[1].document.getElementById(\"barcode_id\")!=undefined){\n\t\tparent.parent.frames[1].document.getElementById(\"barcode_id\").disabled=false;\n\t\tparent.parent.frames[1].document.getElementById(\"barcode_id\").focus();\n}\n";
    private final static byte[]  _wl_block692Bytes = _getBytes( _wl_block692 );

    private final static java.lang.String  _wl_block693 ="\n\t\t parent.parent.commontoolbarFrame.document.getElementById(\"apply\").disabled=true;\n\t\t\n";
    private final static byte[]  _wl_block693Bytes = _getBytes( _wl_block693 );

    private final static java.lang.String  _wl_block694 ="\n\n\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n";
    private final static byte[]  _wl_block694Bytes = _getBytes( _wl_block694 );

    private final static java.lang.String  _wl_block695 ="\n\t</form>\n\t</body>\n\t<div name=\"tooltiplayer\" id=\"tooltiplayer\" style=\"position:absolute; width:15%;visibility:hidden;\" bgcolor=\"blue\">\n\t<table id=\"tooltiptable\" cellpadding=0 cellspacing=0 border=\"0\" width=\"100%\" height=\"100%\" align=\"center\">\n\t<tr><td id=\"t\"></td></tr>\n\t</table>\n\t</div>\n\t</html>\n\t\n\n";
    private final static byte[]  _wl_block695Bytes = _getBytes( _wl_block695 );
	
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


	public String roundDigits(String a){
		try{
			String bb = "";
			if (a.indexOf(".")==-1){
				bb=a.substring(0,a.length());
			}
			else{
				bb=a.substring(a.indexOf("."),a.length());
				if (bb.length() > 2){
					bb=a.substring(0,a.indexOf(".")+2);
				}
				else{
					bb=a;
				}
			}
			return bb;
		}
		catch (Exception e){
			return a;
		}
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
 
/*
---------------------------------------------------------------------------------------------------------------------------------	
Date		Edit History	Name		Rev.Date   	Rev.By 			Description
--------------------------------------------------------------------------------------------------------------------------------
03/02/2017	IN061410		Chithra		01/02/2017	Manickkam 		TTM-SCF-0171
03/01/2018	IN066125		Dinesh T	01/02/2017	Ramesh G		EM run on window 10 and IE 11
																	Vaccine course display schedule before select, displayed wrong icon symbol, unscheduled displayed in pending Rx for MAR
07/03/2019      IN067953        Devindra       ?           ?            MMS-KH-CRF-0014 																	
19/08/2019		IN071056		Manickavasagam				 		SKR-SCF-1264
6/12/2019		IN071721	    Shazana  											SKR-SCF-1290
24/12/2020		11726		        Manickavasagam J			     SKR-SCF-1534
31/1/2021		6771		        Manickavasagam J			     SKR-SCF-1429
22/02/2021		6596		        Manickavasagam J			     ML-MMOH-SCF-1674
26/04/2021		16605		 	Manickavasagam J				     ML-MMOH-SCF-1767
11/05/2023      43323           SREENADH.M               RAMESH.G    NMC-JD-CRF-0186
16/05/2023      45063           SREENADH                             NMC-JD-CRF-0186
15/06/2023      46294       SREENADH.M           RAMESH.G               NMC-JD-CRF-0186 
-------------------------------------------------------------------------------------------------------------------------------
*/ 

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

		System.out.println("------------------------->MedicationAdministrationFTDrugDtls.jsp");
 		request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String locale = (String) session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String patient_id_test			=	 request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String order_id_test			=	 request.getParameter("order_id");
		String str_row_no				=	 request.getParameter("row_no")==null?"0":request.getParameter("row_no");
		String order_line_no_test       =	 request.getParameter("order_line_no")==null?"":request.getParameter("order_line_no");
		String mode				        =	 request.getParameter("mode");	
		String hold_discontinue_yn      =	 request.getParameter("hold_discontinue_yn")==null?"":request.getParameter("hold_discontinue_yn");
		String function_from			=	 request.getParameter("function_from")==null?"":request.getParameter("function_from");
		String admin_due_date			=	 request.getParameter("admin_due_date")==null?"":request.getParameter("admin_due_date");
		String facility_id				=	 (String)session.getValue( "facility_id" );
		String encounter_id			    =	 request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
		String assign_bed_num			=	 request.getParameter("assign_bed_num")==null?"": request.getParameter("assign_bed_num");
		String order_type	            =    request.getParameter("order_type")==null?"": request.getParameter("order_type"); 
		String Auto_Admin				=    "";
		String admin_from_date			=	 request.getParameter("admin_from_date")==null?"":request.getParameter("admin_from_date");
		String admin_to_date			=	 request.getParameter("admin_to_date")==null?"":request.getParameter("admin_to_date");
		String from_time				=	 request.getParameter("from_time")==null?"":request.getParameter("from_time");	
		String to_time					=	 request.getParameter("to_time")==null?"":request.getParameter("to_time");
		if(!locale.equals("en") && (function_from.equals("CP") || function_from.equals("CA"))){ //function_from Added for RUT-SCF-0323 [IN:044818]
			admin_from_date = com.ehis.util.DateUtils.convertDate(admin_from_date, "DMYHM",locale,"en");
			admin_to_date = com.ehis.util.DateUtils.convertDate(admin_to_date, "DMYHM",locale,"en");
			from_time = com.ehis.util.DateUtils.convertDate(from_time, "DMYHM",locale,"en");
			to_time = com.ehis.util.DateUtils.convertDate(to_time, "DMYHM",locale,"en");
		}
		String nursing_unit				=	 request.getParameter("nursing_unit")==null?"":request.getParameter("nursing_unit");
		String administration_status    =	 request.getParameter("administration_status")==null?"": request.getParameter("administration_status");
		String display_order_by			=	 request.getParameter("display_order_by")==null?"":request.getParameter("display_order_by");	
		String route_admin				=	 request.getParameter("route_admin")==null?"":request.getParameter("route_admin");	
		String admin_route_categ		=	 request.getParameter("admin_route_categ")==null?"":request.getParameter("admin_route_categ");
		String callFrom		=	 request.getParameter("callFrom")==null?"":request.getParameter("callFrom");
		boolean boolAllergy_icon	=	false;	//Added for RUT-CRF-0065.1 [IN:43255]
		boolean alt_flag		= false;//BRU-CRF-399.1
		boolean disp_with_alt	= false;//BRU-CRF-399.1
		boolean alt_multi_drug_flag = false; //BRU-CRF-399.1
		String  alt_batch_drug	= ""; //BRU-CRF-399.1
		HashMap batchIdforOrders = null; //GHL-CRF-0482

		String 	strAllergyreason =	"",generic_id="",generic_name="";//Added for RUT-CRF-0065.1 [IN:43255]
		String disp_schedule_uom_desc="", admin_uom_desc = "",dispense_drug_code="",alt_drug_display="";
		ArrayList arrAltDrugs = new ArrayList();//Added for Bru-HIMS-CRF-399 [IN:043767]
		float ret_qty=0;//added below Variables  for incident NO:33194
		float returned_qty=0;
		float tot_administered_qty=0;
		float disp_qty=0;
		float ward_return_qty=0;// adding end
		DecimalFormat dfTest = new DecimalFormat("0.########");
		if(route_admin.equals("undefined")){
			route_admin="";
		}
		if(admin_route_categ.equals("undefined")){
			admin_route_categ="";
		}
		String dob			=	 request.getParameter("dob")==null?"":request.getParameter("dob");//IN066125

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8Bytes, _wl_block8);
 
try{
	String drugCode					=    "";
	String selDateTime				=    "";
	String flag						=    "";
			
	if(mode!=null && mode.equals("NOTIME")){
		drugCode					=	request.getParameter("drug_code");
		selDateTime					=	request.getParameter("selDateTime");
	}
	if(function_from.equals("CP")){
		drugCode					=	request.getParameter("p_ord_drug_code");
		mode						=	"CP";
	}
	int row_no								= Integer.parseInt(str_row_no);
	String bean_id_all_stages				= "DispMedicationAllStages" ;
	String bean_name_all_stages				= "ePH.DispMedicationAllStages";
	DispMedicationAllStages bean_all_stages = (DispMedicationAllStages)getBeanObject( bean_id_all_stages, bean_name_all_stages, request ) ;
	bean_all_stages.setLanguageId(locale);
	bean_all_stages.setModuleId("1");
	ArrayList multi_drugs					=  bean_all_stages.getMultiDrugs(patient_id_test,patient_id_test,order_line_no_test);	
	String bean_id							= "MedicationAdministrationFTBean";
	String bean_name						= "ePH.MedicationAdministrationFTBean";
	MedicationAdministrationFTBean bean		= (MedicationAdministrationFTBean)getBeanObject( bean_id, bean_name, request );
	bean.setLanguageId(locale);
	bean.setCurrentTimeAndAdminWithinHRS();
	String drug_search_bean_id				= "DrugSearchBean";
	String drug_search_bean_name			= "ePH.DrugSearchBean";
	DrugSearchBean drug_bean				= (DrugSearchBean)getBeanObject( drug_search_bean_id, drug_search_bean_name , request);
	drug_bean.setLanguageId(locale);
	ArrayList result						= bean.getCurrentTimeAndAdminWithinHRS();
	String current_date_time				= (String)result.get(0);
	String AdminBackLogTime					= "";
	if(admin_from_date.equals(""))	
		AdminBackLogTime					= bean.getFromDateTime(com.ehis.util.DateUtils.convertDate(current_date_time, "DMYHM",locale,"en"));		
	else
		AdminBackLogTime					= admin_from_date;
	HashMap drug_details					= new HashMap();					
	String order_id							= "";
	String userAuthPINYN=bean.getUserAuthPINYN(facility_id); //RUT-CRF-0035 [IN029926] Added for User Auth PIN Validation
	userAuthPINYN=userAuthPINYN==null?"":userAuthPINYN;// Added for RUT-CRF-0035 [IN029926] 
	if(!callFrom.equals("RELOADTAPER"))
		bean.clearDrugDetails();
	if(bean.getDrugDetails_Added() == null ){   //Added for RUT-CRF-0088 [IN036978]
		if(mode!=null && (mode.equals("NOTIME") || mode.equals("CP"))){
			String shedule_date_time			= request.getParameter("shedule_date_time");
			order_id							= request.getParameter("order_id");
			if(function_from.equals("CP")){	

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

				shedule_date_time				 =	request.getParameter("p_start_date_time");
				order_id					     =	request.getParameter("order_id");
			} // Function from CP loop ends	
			drug_details		  =	(HashMap) bean.getDrugDetails(encounter_id,order_id,shedule_date_time,drugCode,hold_discontinue_yn,administration_status,order_type,display_order_by,route_admin,admin_route_categ,patient_id_test,"");// added	patient_id_test and "" string for the incident IN037217			
			bean.setDrugDetails_Added(drug_details);  //Added for RUT-CRF-0088 [IN036978]
		}	// Mode from CP loop ends
		else{	
			drug_details		  =	(HashMap) bean.getDrugDetails(encounter_id,admin_from_date,admin_to_date,hold_discontinue_yn,administration_status,order_type,to_time,from_time,display_order_by,route_admin,admin_route_categ);
			bean.setDrugDetails_Added(drug_details);  //Added for RUT-CRF-0088 [IN036978]
		}   
	}
	else{   //Added for RUT-CRF-0088 [IN036978]
		drug_details		  = bean.getDrugDetails_Added();
	}	
	String iv_prep_yn			   =	"";
	String title				   =	"";
	if(!order_type.equals("A")){
		iv_prep_yn				=  drug_details.get("iv_prep_yn")==null?"":(String)drug_details.get("iv_prep_yn");
		if(function_from.equals("CP"))
			iv_prep_yn	=	bean.IVType(order_id);
		if(iv_prep_yn.equals("7") || iv_prep_yn.equals("8"))
			title	   =	com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.TPN.label", "ph_labels");
		else if(iv_prep_yn.equals("0") || iv_prep_yn.equals("9"))
			title	   =	com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Oncology.label", "ph_labels");
		else
			title	   =   com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.NON_IV.label", "ph_labels");
	} //if ends 
	ArrayList	non_iv_drug_details				=	 (ArrayList) drug_details.get("NON_IV");
	String cancel_recorded_yn    ="N";//added for JD-CRF-0200
	ArrayList iv_drug_details				    =	 (ArrayList) drug_details.get("IV");
	String admin_bean_id						=	  "MedicationAdministrationBean";
	String admin_bean_name						=	  "ePH.MedicationAdministrationBean";
	MedicationAdministrationBean admin_bean		=	  (MedicationAdministrationBean)getBeanObject( admin_bean_id, admin_bean_name, request );
	admin_bean.setLanguageId(locale);
	String totalTaperQtyDisplay = admin_bean.getTotalTaperQtyDisplay();//Added for RUT-CRF-0088 [IN036978]
	String allowMAR_share_drug = admin_bean.getAllowMARShareDrug();//Added for HSA-CRF-0090[IN041241] -start
	String allow_mar_alternate_drug_yn = admin_bean.getAllow_auto_disp_alt_drug_mar();//Added for Bru-HIMS-CRF-399 [IN:043767]
	String shared_drug_disp = "";
	
	
	admin_bean.setNursingUnit(nursing_unit);
	admin_bean.setPatientId(patient_id_test);
	admin_bean.setEncounterId(encounter_id);
	admin_bean.setBedNo(assign_bed_num);
	HashMap defaultValues				=	new HashMap();
	defaultValues						=	admin_bean.getNONIVDrugDetails();
	String	defaultDate					=	"";
	String  defaultBatch				=	"";
	String	defaultTradeId				=	"";
	String	defaultExpiryDate			=	"";
	String schedule_uom_desc			=   "";
	String schedule_uom_code			=   "";
	if (defaultValues.containsKey(selDateTime)){
		try{
			ArrayList alreadyEnteredValues=(ArrayList)defaultValues.get(selDateTime);
			defaultDate				=	(String)alreadyEnteredValues.get(2)==null?"":(String)alreadyEnteredValues.get(2);
			defaultBatch			=	(String)alreadyEnteredValues.get(9)==null?"":(String)alreadyEnteredValues.get(9);
			defaultExpiryDate		=	(String)alreadyEnteredValues.get(10)==null?"":(String)alreadyEnteredValues.get(10);
			defaultTradeId			=	(String)alreadyEnteredValues.get(11)==null?"":(String)alreadyEnteredValues.get(11);
		}
		catch (Exception e){
			defaultDate			="";
			defaultBatch		="";
			defaultExpiryDate	="";
			defaultTradeId		="";
		}
	} 
	int tot_records						=   0;		int recCount		 = 0;
	int altRecCount						=   0;		int newRecCount		 = 0;
//	int ivRecCount						=   0;		
	String patient_id					=   "";
	int no_of_alt_drus_selected			=   0;	
	String stat_style					=   "";
	String classvalue					=   "";		String store_code	  =	"";
	String drug_class					=   "";		String drug_class_ind = "";
	String  short_desc					=   "";	
	String  drug_code					=   "";
	String  disp_drug_code				=   "";
	String  uom_code					=   "";
	String  drug_desc					=   "";		String  qty			  = "";
	String encode_drug_desc				=   "";
	String ordered_qty					=   "";		String  batch_id	  = ""; 
	String  expiry_date					=   "";		String  tradename	  =	"";	                     
	String  item_code					=   "";		order_id		      = "";
	String order_line_num				=   "";		ArrayList batch_ids   = new ArrayList(); 
	String sch_date_time				=   "";		String dosage_seq_no  = "";
	String trade_id						=   "";		String dis_continued  = "";
	String hold							=   "";		String administered   = "";
	String could_not_administer ="";//Added for AAKH-CRF-0024 [IN:038260]
	String admin_recorded_yn			=   "";		String remarks		  =	"";
	String admindrugdetails				=   "";
	String admin_drug_code				=   "";		String admin_drug_desc=	"";
	String Store_locn_code				=	"";
	String sch_date_time_in_locale		=	"";
	String Storelocn_code				=	"";
	String iv_incred					=	"";
	String iv_incred1					=	"";
	String iv_incred2					=	"";
	String route_desc					=	"";
	String pres_catg_code				=   "";
	String pres_base_uom				 =  "";		//added for SKR-SCF-0304
	boolean auth_reqd					=   false;
	String auth_reqd_script				=	"";
	StringTokenizer stadmindrugdetails	=	null;
	StringTokenizer stiv_incred			=	null;	
	String admin_by_name				=	"";		String auth_by_name					=	"";
	String end_date_time				=	"";		String freq_code					=	"";
	String AdUOM						=	"";
	String pract_id						=	"";		String against_sch_date				=	"";
	String adr_reason					=	"";		String adr_remarks					=	"";
	String adr_record_time				=	"";		String adr_recorded_by				=	"";
	String img_path						=	"";		String adr_details					=	"";
	String freq_nature					=	"";		String stat_title					=	"";
	String mand_display					=	"";		String drug_remarks					=	"";
	String prn_remarks					=	"";		String slidingscaleremarks	        =   "";
	String pharma_remarks				=	"";		String verificationremarks			=	"";
	String pres_remarks					=	"";		String remarks_style				=	"";	
	String select_status				=	"";		String dtl_style					=	"";	
	String pres_dosage					=	"";		String pres_unit					=	"";	
	String medn_admn_dtl_reqd_yn		=	"";	    String select_status_1				=   "";
	String ext_prod_id					=   "";		String show_remarks					=	"N";
	String imageFileURL					=	"";		String patient_brgt_medn			=	"N";
	String trade_code					=	"";     String sliding_scale_applicable		=   "N";
	String strength_value_prn			=	"";     String sch_strength_value_prn		=	"";
	String sch_strength_uom_prn			=	"";     String sch_strength_uom_desc_prn	=	"";
	String dosage_uom_code				=	"";     String dosage_uom_desc				=	"";
	String dosage_type					=	"";     String dosage						=	"";
	String adminsted_pat_brought_medn	=	"N";    String content_in_pres_base_uom		=	"1";
	String tempDosage					=	"";     String onco_direct_drug_count		=	"1";
	String demostring					=  "\\\'\'";String linkVacScheduleCode			=	"";
	String admn_dose_chng_reason_code   =	"";		String linkVacScheduleDesc			=	"";
	String linkVacScheduleDescToolTip	=	"";		String linkVacScheduleYN			=	"N";
	String performingDeptLocCode		=	"";	    String future_or_late_admin = ""; // Added for GHL-CRF-0482 [IN:064955]
	String future_date_time		            =	"";    // Added for GHL-CRF-0482 [IN:064955]
	//String nonMfrFluidRemarks			=	"";
	String strength_per_value_pres_uom = "1";
	String route_color 	=   "";   // Code Added For RUT-CRF-0034 Start
	String fntColor                     =   "#OOOOOO";
	String backGrndColor                =   "#FFFFFF";   // Code Added For RUT-CRF-0034 End
	String order_pract_id 	=   "";  //Added for [IN:040149]
	String bat_id_lookbutton_enabled="Y", auto_Admin_dis="", verbalOrder="";
	String pin_value=bean.getPinNumber();
	String mfr_yn	= "";//ML-MMOH-CRF-1014- start
	String statusString = "";
	String placed_from_verbal_order="";//added for ghl-crf-0509
	boolean mfrCompletedStatus		=	false;
	String patient_stock_display	= "";//Added for GHL-CRF-0482
	String patient_stock_check_display = "";//Added for GHL-CRF-0482
	ArrayList MfrDetails			=	new ArrayList();//ML-MMOH-CRF-1014- end
//	DecimalFormat dfToInteger = new DecimalFormat("####.##");
	ArrayList work_sheet_batch_det1		=	new ArrayList();
	ArrayList sliding_scale_details		=	new ArrayList();
	int temp1                           =   0;
	int temp2                           =   0;		
	int temp3                           =   0;		
	int inc								=   0;
	float dialog_height					=	0;
	HashMap overridereason				=	new HashMap();
	int ppn_count						=   0;
	String sch_date_time_in_en = "";//added for skr-scf-1290
	String drug_indication_remarks="";
	String taper_yn	=	 "N", addedTaperSch="";  //Added for RUT-CRF-0088 [IN036978]
	ArrayList totQty =null,  WardReturnQty= null;
	boolean marForDisPatNotReqYN = bean.isSiteSpecific("PH", "MAR_FOR_DISC_PAT_NOT_REQ_YN"); // Added for KH-SCF-0010
	boolean dischargedYN = bean.getDischargedStatus(encounter_id); // Added for KH-SCF-0010
	boolean isSite_spec_patient_stock = bean.isSiteSpecific("PH","PATIENT_STOCK_REQUIRED");//ADDED FOR GHL-CRF-0482
//	boolean verify_adm_drug	= bean.isSiteSpecific("PH", "VERIFY_ADM_DRUG"); //MMS-KH-CRF-0017 and commented for MMS-KH-CRF-0017
//	isSite_spec_patient_stock = true;
		String user_id=(String)session.getValue("login_user");//ADDED FOR JD-CRF-0200
		String cancelYn=bean.getMedicationAdminstrationRights(user_id); //ADDED FOR JD-CRF-0200
		
	if((non_iv_drug_details.size()==0) &&(iv_drug_details.size()==0)){

            _bw.write(_wl_block11Bytes, _wl_block11);
		
		return;
	}
	if(non_iv_drug_details.size()>0){
					

            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
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

			if(isSite_spec_patient_stock) 
				patient_stock_display	=	""; 
			else
				patient_stock_display	=	"display:none";



			if(isSite_spec_patient_stock){
		
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

			}
		
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

		if(!order_type.equals("A")){ 

            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(title));
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
	
		}
		if(mode!=null && (mode.equals("NOTIME") || mode.equals("CP"))){				
			//inc=79;   //Changed from 69 to 72 //Incremented from 68 to 69 for RUT-CRF-0088 [IN036978]	// 69 to 70 for RUT-CRF-0065.1 [IN:43255] and 72 to 74 for ML-MMOH-CRF-1014 and 75 to 78 for GHL-CRF-0482
		//74 to 75 changed for GHL-CRF-0509
			inc=80; //added for JD-CRF-0200
		}
		else{ 
			//inc=89;  //Changed from 79 to 82   //Incremented from 77 to 78 for RUT-CRF-0088 [IN036978]  //Code Modified For RUT-CRF-0034  // 78 to 79 for RUT-CRF-0065.1 [IN:43255] // 82 to 84 for ML-MMOH-CRF-1014 and 85 to 88 for GHL-CRF-0482
		//	 84 TO 85 changed for GHL-CRF-0509
			inc=90; //added for JD-CRF-0200
		}
		String alt_drug_code, alt_drug_desc, alt_qty, alt_qty_uom, alt_expiry_date,  alt_trade_id, alt_trade_name, linkVacScheduleCode1;
		ArrayList alt_batch_ids = null;
		String[] vacScheduleDetails;
		String administred_batch_id, disp_batch_id, disp_exp_dt, disp_trade_id, admin_dose_prn="", non_iv_admin_quaty=""; // added for SKR-SCF-0304
		String sl_srl_no="", sl_rg_fro, sl_rg_to, sl_adm_qty, rangeUOM, dosageDescription="", showTitle, admin_date_time, modified_date_time, alt_drug, displayStyle, statusFlag, addDisplayStyle , checked, dispensed_drug_desc = "", disp_drugs="",ward_ack_yn="";
		boolean isSiteSpecMARPrint = false;//bean.isSiteSpecific("PH","WARD_ACK");//GHL-CRF-0458 and changed MAR_PRINT_YN to WARD_ACK for AMS-CRF-0203 // "bean.isSiteSpecific("PH","WARD_ACK");" changed to "false" for MMS-KH-CRF-0014 [IN:067953]
		String WardAckMarRequiredYn = admin_bean.getWardAckMarRequiredYn(); //Added for MMS-KH-CRF-0014 [IN:067953]
		HashMap splitDoseYN = bean.getSplitDoseYN();//ML-MMOH-SCF-1439
		 String verification_req_yn=admin_bean.getverfreqdbefmedAdmin();//added for MMS-KH-SCF-0056
		if(WardAckMarRequiredYn.equalsIgnoreCase("Y")){
			isSiteSpecMARPrint = true;
		}
		boolean issitespec_verbal_order_yn = bean.isSiteSpecific("PH","PLACED_VERBAL_ORDER_YN");//ADDED FOR GHL-CRF-0509
		
		String patient_class_ord = "";//GHL-CRF-0458
		String mfrRemarks		 = "";//added for ml-mmoh-crf-1014
		String admin_uom		 = "";//BRU-CRF-399.1
		String order_status		 = ""; //GHL-CRF-0482
		boolean ack_flag = false;//GHL-CRF-0458
		//added for GHL-CRF-0482 - start
		HashMap drugMap = new HashMap();
		ArrayList orderList = new ArrayList();
		String disp_drug_code_for_batch = "";
		String drug_code_for_batch = "";
		String order_id_for_drug   = "";
		String order_line_no_for_drug   = "";
		String patient_stock_yn = "";
		String patient_stock_required = "";
		String patient_stock_completed	= "";
		String patient_stock_checked    = "";
		String patient_stock_disabled	= "";
		String verification_status = "N";//added for MMS-KH-SCF-0056
	   
		for (int k=0;k<non_iv_drug_details.size();k=k+inc){	
		
			order_id_for_drug	    = (String)non_iv_drug_details.get(k+13);
			order_line_no_for_drug  = (String)non_iv_drug_details.get(k+14);

			if(inc == 90 ){//89 TO 90 MODIFIED for JD-CRF-0200
				disp_drug_code_for_batch = (String)non_iv_drug_details.get(k+81);
			}else if(inc == 80 ){//79 T0 80 MODIFIED for JD-CRF-0200
				disp_drug_code_for_batch = (String)non_iv_drug_details.get(k+71);
			}
			drug_code_for_batch = (String)non_iv_drug_details.get(k+28);
			if(disp_drug_code_for_batch.equals(""))
				disp_drug_code_for_batch = drug_code_for_batch;
			if(drugMap!=null ){
			 if(drugMap.containsKey(disp_drug_code_for_batch)){
				 
				 orderList = (ArrayList)drugMap.get(disp_drug_code_for_batch);
				if(!orderList.contains(order_id_for_drug)){
					orderList.add(order_id_for_drug);
					orderList.add(order_line_no_for_drug);
					drugMap.put(disp_drug_code_for_batch,orderList);
				}
			 }else{
					orderList = new ArrayList();
					orderList.add(order_id_for_drug);
					orderList.add(order_line_no_for_drug);
					drugMap.put(disp_drug_code_for_batch,orderList);
			 }
			}
		}
		//added for GHL-CRF-0482 - end
		for (int i=0;i<non_iv_drug_details.size();i=i+inc){					
			ppn_count = 0;
			linkVacScheduleCode="";
			linkVacScheduleYN ="N";
			patient_stock_checked = "";//GHL-CRF-0482
			patient_stock_disabled = "";
			ward_ack_yn = "";//GHL-CRF-0458
			statusString = "";//ML-MMOH-CRF-1014
			could_not_administer = "";//SKR-SCF-1264
			if(inc == 90 ){//84 to 85 changed for GHL-CRF-0509  // 89 TO 90 MODIFIED for JD-CRF-0200
				iv_prep_yn			= non_iv_drug_details.get(i+44)==null?"":(String)non_iv_drug_details.get(i+44);
				iv_incred			= (String)non_iv_drug_details.get(i+53);
				route_desc			= (String)non_iv_drug_details.get(i+54);
				pres_catg_code		= (String)non_iv_drug_details.get(i+55)==null?"":(String)non_iv_drug_details.get(i+55);
				medn_admn_dtl_reqd_yn	= (String)non_iv_drug_details.get(i+45);
				prn_remarks			= (String)non_iv_drug_details.get(i+46);				
				slidingscaleremarks	= (String)non_iv_drug_details.get(i+47);
				ext_prod_id			= (String)non_iv_drug_details.get(i+50);
				trade_code			= (String)non_iv_drug_details.get(i+51);
				imageFileURL		= (String)non_iv_drug_details.get(i+52);
				schedule_uom_desc	= (String)non_iv_drug_details.get(i+56);
				schedule_uom_code	= (String)non_iv_drug_details.get(i+57);
				patient_brgt_medn	= (String)non_iv_drug_details.get(i+58);
				sliding_scale_applicable	= (String)non_iv_drug_details.get(i+59);
				strength_value_prn	= (String)non_iv_drug_details.get(i+60)==null?"":(String)non_iv_drug_details.get(i+60);
				sch_strength_value_prn	= (String)non_iv_drug_details.get(i+61)==null?"":(String)non_iv_drug_details.get(i+61);
				adminsted_pat_brought_medn	= (String)non_iv_drug_details.get(i+62);	
				dosage_type			= (String)non_iv_drug_details.get(i+63);
				dosage				= (String)non_iv_drug_details.get(i+64);
				dosage_uom_code		= (String)non_iv_drug_details.get(i+65);
				dosage_uom_desc		= (String)non_iv_drug_details.get(i+66);
				content_in_pres_base_uom= (String)non_iv_drug_details.get(i+67);
				sch_strength_uom_prn	= (String)non_iv_drug_details.get(i+68)==null?"":(String)non_iv_drug_details.get(i+68);
				sch_strength_uom_desc_prn	= (String)non_iv_drug_details.get(i+69)==null?"":(String)non_iv_drug_details.get(i+69);	
				admn_dose_chng_reason_code	= (String) non_iv_drug_details.get(i+70)==null?"":(String)non_iv_drug_details.get(i+70);	
				onco_direct_drug_count		= (String)non_iv_drug_details.get(i+71);
				linkVacScheduleCode			= (String)non_iv_drug_details.get(i+72);
				performingDeptLocCode		= (String)non_iv_drug_details.get(i+73)==null?"":(String)non_iv_drug_details.get(i+73);
				pres_base_uom				= (String)non_iv_drug_details.get(i+3);  //added for SKR-SCF-0304
				adminsted_pat_brought_medn	= adminsted_pat_brought_medn.trim();
				verificationremarks	= bean_all_stages.getVerificationRemarks((String)non_iv_drug_details.get(i+13),(String)non_iv_drug_details.get(i+14));
				overridereason		= (HashMap)bean_all_stages.getOverrideremarks((String)non_iv_drug_details.get(i+13),(String)non_iv_drug_details.get(i+14));
				pres_remarks		= bean.getPrescriptionInstructions((String)non_iv_drug_details.get(i+13));
				drug_remarks		= bean.getDrugInstructions((String)non_iv_drug_details.get(i+13),(String)non_iv_drug_details.get(i+14));
				pharma_remarks		= bean.getPharmacistInstructions((String)non_iv_drug_details.get(i+13),(String)non_iv_drug_details.get(i+14));
				show_remarks		= "N";
				boolAllergy_icon	= false;// Added for RUT-CRF-0065.1 [IN:43255]
				order_pract_id  =(String)non_iv_drug_details.get(i+76)==null?"":(String)non_iv_drug_details.get(i+76); //Added for [IN:040149]
				route_color                 = (String)non_iv_drug_details.get(i+75)==null?"":(String)non_iv_drug_details.get(i+75);	//Code Added For RUT-CRF-0034 Start
				mfr_yn = (String)non_iv_drug_details.get(i+82)==null?"":(String)non_iv_drug_details.get(i+82);//ML-MMOH-CRF-1014
				mfrRemarks				 =	(String)non_iv_drug_details.get(i+83)==null?"":(String)non_iv_drug_details.get(i+83);//added for ml-mmoh-crf-1014
				placed_from_verbal_order				 =	(String)non_iv_drug_details.get(i+84)==null?"":(String)non_iv_drug_details.get(i+84);//added for GHL-CRF-0509
				order_status = (String)non_iv_drug_details.get(i+85)==null?"":(String)non_iv_drug_details.get(i+85);//added for GHL-CRF-0482
				patient_stock_required = (String)non_iv_drug_details.get(i+86)==null?"":(String)non_iv_drug_details.get(i+86);//added for GHL-CRF-0482
				patient_stock_completed = (String)non_iv_drug_details.get(i+87)==null?"":(String)non_iv_drug_details.get(i+87);//added for GHL-CRF-0482
				patient_stock_yn = (String)non_iv_drug_details.get(i+88)==null?"":(String)non_iv_drug_details.get(i+88);//added for GHL-CRF-0482
				cancel_recorded_yn = (String)non_iv_drug_details.get(i+89)==null?"":(String)non_iv_drug_details.get(i+89);//added for JD-CRF-0200
			
		       	if(route_color != "" && route_color != null && route_color.length()==12){
					fntColor = route_color.substring(0, 6);
					backGrndColor = route_color.substring(6, 12);
				}//Code Added For RUT-CRF-0034 End
				if(ext_prod_id!=null && !ext_prod_id.equals("")){
					if(overridereason.size()>1){
						show_remarks="Y";
						strAllergyreason = (String)overridereason.get("ALLERGY_OVERRIDE_REASON");
						if(strAllergyreason!=null && !strAllergyreason.equals(""))//if Added for RUT-CRF-0065.1 [IN:43255]
							boolAllergy_icon = true;
					}	
				}
				else{
					if(overridereason.size()>0){
						show_remarks="Y";
						strAllergyreason = (String)overridereason.get("ALLERGY_OVERRIDE_REASON");
						if(strAllergyreason!=null && !strAllergyreason.equals(""))//if Added for RUT-CRF-0065.1 [IN:43255]
							boolAllergy_icon = true;
					}
				}
				if(order_type.equals("A"))		  // if and else block Added for RUT-CRF-0088 [IN036978]		
					taper_yn		= (String)non_iv_drug_details.get(i+77);
				else
					taper_yn		= (String)non_iv_drug_details.get(i+76); 
				addedTaperSch = "";
				generic_id  =(String)non_iv_drug_details.get(i+78)==null?"":(String)non_iv_drug_details.get(i+78); // Added for RUT-CRF-0065.1 [IN:43255]
				dispensed_drug_desc		 = (String)non_iv_drug_details.get(i+79);
				disp_drugs = (String)non_iv_drug_details.get(i+80);
				dispense_drug_code = (String)non_iv_drug_details.get(i+81);
			} //end if (inc == 75 )
			else if(inc == 80 ){//74 to 75 changed for GHL-CRF-0509 and 75 to 78 for GHL-CRF-0482// 79 TO 80 MODIFIED for JD-CRF-0200
				medn_admn_dtl_reqd_yn	=	non_iv_drug_details.get(i+44)==null?"":(String)non_iv_drug_details.get(i+44);
				ext_prod_id             =   non_iv_drug_details.get(i+45)==null?"":(String)non_iv_drug_details.get(i+45);
				iv_incred		        =   non_iv_drug_details.get(i+46)==null?"":(String)non_iv_drug_details.get(i+46);
				route_desc		        =   non_iv_drug_details.get(i+47)==null?"":(String)non_iv_drug_details.get(i+47);
				pres_catg_code          =   non_iv_drug_details.get(i+48)==null?"":(String)non_iv_drug_details.get(i+48);
				schedule_uom_desc	    =   non_iv_drug_details.get(i+49)==null?"":(String)non_iv_drug_details.get(i+49);
				schedule_uom_code	    =   non_iv_drug_details.get(i+50)==null?"":(String)non_iv_drug_details.get(i+50);
				sliding_scale_applicable	=	(String)non_iv_drug_details.get(i+51);
				patient_brgt_medn		=	(String)non_iv_drug_details.get(i+52);
				strength_value_prn		=	(String)non_iv_drug_details.get(i+53)==null?"":(String)non_iv_drug_details.get(i+53);
				sch_strength_value_prn		=	(String)non_iv_drug_details.get(i+54)==null?"":(String)non_iv_drug_details.get(i+54);
				content_in_pres_base_uom	=	(String)non_iv_drug_details.get(i+55);
				sch_strength_uom_prn	=	(String)non_iv_drug_details.get(i+56)==null?"":(String)non_iv_drug_details.get(i+56);
				sch_strength_uom_desc_prn	=	(String)non_iv_drug_details.get(i+57)==null?"":(String)non_iv_drug_details.get(i+57);
				dosage_type				=	(String)non_iv_drug_details.get(i+58);
				dosage					=	(String)non_iv_drug_details.get(i+59);
				dosage_uom_code			=	(String)non_iv_drug_details.get(i+60);
				dosage_uom_desc			=	(String)non_iv_drug_details.get(i+61);
				admn_dose_chng_reason_code =(String)non_iv_drug_details.get(i+62);
				linkVacScheduleCode		=	(String)non_iv_drug_details.get(i+63);
				performingDeptLocCode	=   (String)non_iv_drug_details.get(i+64)==null?"":(String)non_iv_drug_details.get(i+64);
				pres_base_uom				= (String)non_iv_drug_details.get(i+65);  //added for SKR-SCF-0304
				adminsted_pat_brought_medn	= adminsted_pat_brought_medn.trim();
				verificationremarks		= bean_all_stages.getVerificationRemarks((String)non_iv_drug_details.get(i+13),(String)non_iv_drug_details.get(i+14));
				overridereason			= (HashMap)bean_all_stages.getOverrideremarks((String)non_iv_drug_details.get(i+13),(String)non_iv_drug_details.get(i+14));
				pres_remarks			= bean.getPrescriptionInstructions((String)non_iv_drug_details.get(i+13));
				drug_remarks			= bean.getDrugInstructions((String)non_iv_drug_details.get(i+13),(String)non_iv_drug_details.get(i+14));
				pharma_remarks			= bean.getPharmacistInstructions((String)non_iv_drug_details.get(i+13),(String)non_iv_drug_details.get(i+14));
				show_remarks		= "N";
				boolAllergy_icon	= false;// Added for RUT-CRF-0065.1 [IN:43255]
				order_pract_id  =(String)non_iv_drug_details.get(i+67)==null?"":(String)non_iv_drug_details.get(i+67); //Added for [IN:040149]
				generic_id  =(String)non_iv_drug_details.get(i+68)==null?"":(String)non_iv_drug_details.get(i+68); // Added for RUT-CRF-0065.1 [IN:43255]
				route_color                 = (String)non_iv_drug_details.get(i+66)==null?"":(String)non_iv_drug_details.get(i+66);	//Code Added For RUT-CRF-0034 Start
				dispensed_drug_desc		 = (String)non_iv_drug_details.get(i+69);
				disp_drugs = (String)non_iv_drug_details.get(i+70);
				dispense_drug_code = (String)non_iv_drug_details.get(i+71);
				placed_from_verbal_order				 =	(String)non_iv_drug_details.get(i+72)==null?"":(String)non_iv_drug_details.get(i+72);//added for GHL-CRF-0509
				order_status = (String)non_iv_drug_details.get(i+72)==null?"":(String)non_iv_drug_details.get(i+72);//added for GHL-CRF-0482
				patient_stock_required = (String)non_iv_drug_details.get(i+76)==null?"":(String)non_iv_drug_details.get(i+76);//added for GHL-CRF-0482
				patient_stock_completed = (String)non_iv_drug_details.get(i+77)==null?"":(String)non_iv_drug_details.get(i+77);//added for GHL-CRF-0482
				patient_stock_yn = (String)non_iv_drug_details.get(i+78)==null?"":(String)non_iv_drug_details.get(i+78);//added for GHL-CRF-0482
				cancel_recorded_yn = (String)non_iv_drug_details.get(i+79)==null?"":(String)non_iv_drug_details.get(i+79);//added for JD-CRF-0200
				if(route_color != "" && route_color != null && route_color.length()==12 ){
					fntColor = route_color.substring(0, 6);
					backGrndColor = route_color.substring(6, 12);
			   	}//Code Added For RUT-CRF-0034 End
				if(ext_prod_id!=null && !ext_prod_id.equals("")){
					if(overridereason.size()>1){
						show_remarks="Y";
						strAllergyreason = (String)overridereason.get("ALLERGY_OVERRIDE_REASON");
						if(strAllergyreason!=null && !strAllergyreason.equals(""))//if Added for RUT-CRF-0065.1 [IN:43255]
							boolAllergy_icon = true;
					}			
				}
				else{
					if(overridereason.size()>0){
						show_remarks="Y";
						strAllergyreason = (String)overridereason.get("ALLERGY_OVERRIDE_REASON");
						if(strAllergyreason!=null && !strAllergyreason.equals(""))//if Added for RUT-CRF-0065.1 [IN:43255]
							boolAllergy_icon = true;
					}
				}	
			} // end else if(inc == 66 )
		
		//added for GHL-CRF-0482 - start
			if(!iv_prep_yn.equals(""))
				patient_stock_disabled="disabled";
			if(patient_brgt_medn.equals("Y"))
				patient_stock_disabled="disabled";
		//added for GHL-CRF-0482 - end			

			if(!(linkVacScheduleCode==null || linkVacScheduleCode.equals(""))){
				linkVacScheduleCode1=linkVacScheduleCode.substring(0,10);						
				if(!linkVacScheduleCode1.equals("NO DEFAULT")){
					try{
						linkVacScheduleYN="Y";
						vacScheduleDetails=linkVacScheduleCode.split("~");
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
			tempDosage				=	dosage;
			strength_value_prn		=	strength_value_prn.trim();
			sch_strength_value_prn	=	sch_strength_value_prn.trim();
			iv_incred2="";
			if(content_in_pres_base_uom==null || content_in_pres_base_uom.equals(""))
				content_in_pres_base_uom="1";
			if(iv_incred != null){
				stiv_incred = new StringTokenizer(iv_incred,"|");
				while(stiv_incred.hasMoreTokens()){
					iv_incred1 = stiv_incred.nextToken();
					if(stiv_incred.hasMoreTokens())
						iv_incred2 = stiv_incred.nextToken();						
				}
			} 
			auth_reqd=bean.isAuthenticationRequired(facility_id,pres_catg_code);											
			
			if(patient_stock_required.equals("")) //GHL-CRF-0482
				patient_stock_required = "N";
			
			if(auth_reqd){							
				if(pin_value.equals(""))
					auth_reqd_script=";pinAuthentication(this,'NP');";
				else
					auth_reqd_script=";pinAuthentication(this,'YP');";
			}
			if(order_type.equals("A")){
				if(iv_prep_yn.equals("0") || iv_prep_yn.equals("9")){
					temp1++;
					temp2=0;
					temp3=0;
				}
				else if(iv_prep_yn.equals("8") ||iv_prep_yn.equals("7")){
					temp1=0;
					temp2=0;
					temp3++;
				}
				else{
					 temp1=0;
					 temp3=0;
					 temp2++;
				} 

				if(	temp1==1){

            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
 
				} // end if (temp1==1)
				else if(temp2==1){ 

            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

				}
				else if(temp3==1){ 

            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

				}
			} // end 	if(order_type.equals("A"))
			if(recCount==0)	
				recCount = 1;						
			if ( recCount % 2 == 0 )
				classvalue = "QRYODD" ;
			else
				classvalue = "QRYEVEN" ;						
			flag="Y";
			disp_drug_code	= (String)non_iv_drug_details.get(i);
			drug_code		= (String)non_iv_drug_details.get(i+28);
			if(dispense_drug_code.equals(""))
				dispense_drug_code = drug_code;
			store_code		= (String)non_iv_drug_details.get(i+29);	
			drug_class		= non_iv_drug_details.get(i+30)==null?"":(String)non_iv_drug_details.get(i+30);
			end_date_time	= (String)non_iv_drug_details.get(i+32);
			drug_desc		= (String)non_iv_drug_details.get(i+1);	
			encode_drug_desc= drug_desc.replaceAll(" ","%20");
			encode_drug_desc= java.net.URLEncoder.encode(encode_drug_desc,"UTF-8");
			encode_drug_desc= encode_drug_desc.replaceAll("%2520","%20");
			int adr_count			= bean.getADRCount(patient_id_test,drug_code);  //newly added for RUT-SCF-0144 [IN:033371] 
			qty				= non_iv_drug_details.get(i+2)==null?"0":(String)non_iv_drug_details.get(i+2);
			ordered_qty		= non_iv_drug_details.get(i+2)==null?"0":(String)non_iv_drug_details.get(i+2);
			short_desc		= non_iv_drug_details.get(i+3)==null?"":(String)non_iv_drug_details.get(i+3);
			batch_id		= non_iv_drug_details.get(i+4)==null?"":(String)non_iv_drug_details.get(i+4);
			expiry_date		= non_iv_drug_details.get(i+5)==null?"":(String)non_iv_drug_details.get(i+5); 
			tradename		= non_iv_drug_details.get(i+6)==null?"":(String)non_iv_drug_details.get(i+6);
			item_code		= (String)non_iv_drug_details.get(i+7);
			order_id	    = (String)non_iv_drug_details.get(i+13);
			order_line_num  = (String)non_iv_drug_details.get(i+14);
			patient_id	    = (String)non_iv_drug_details.get(i+15);
			sch_date_time   = (String)non_iv_drug_details.get(i+16);
			if(dob==null || dob.equals("")) //added for ARYU-SCF-023
				dob = bean.getPatientDOB(patient_id);
			sch_date_time_in_locale = sch_date_time; // 26119 : sch_date_time is again converted into eng date so compare date is giving wrong result. hence storing it in another var before convertion.
					//added for skr-scf-1290
					if(!locale.equals("en")){
						sch_date_time_in_en= com.ehis.util.DateUtils.convertDate(sch_date_time, "DMYHM",locale,"en");
					}
			uom_code		= (String)non_iv_drug_details.get(i+43);
			disp_schedule_uom_desc= schedule_uom_desc.replaceAll(" ","%20");
			disp_schedule_uom_desc= java.net.URLEncoder.encode(disp_schedule_uom_desc,"UTF-8");
			disp_schedule_uom_desc= disp_schedule_uom_desc.replaceAll("%2520","%20");
			admin_uom_desc= short_desc.replaceAll(" ","%20");
			admin_uom_desc= java.net.URLEncoder.encode(admin_uom_desc,"UTF-8");
			admin_uom_desc= admin_uom_desc.replaceAll("%2520","%20");
		//GHL-CRF-0482 - start
			if(patient_stock_completed.equals("Y"))
				patient_stock_checked = "checked";
			else
				patient_stock_checked = "";
		//GHL-CRF-0482-end
			if(iv_prep_yn.equals("9") &&  Integer.parseInt(onco_direct_drug_count)>1 && order_line_num.equals("1"))
				classvalue="IVFLUID1";
			if(iv_prep_yn !=null && iv_prep_yn.equals("7"))
				   ppn_count = bean.getPPNIOrderValues(order_id, patient_id);

			    Store_locn_code	= performingDeptLocCode;
			//IF condtion added for ghl-crf-0509
			    if(issitespec_verbal_order_yn)
					{
					Storelocn_code="";
					}
					else
			    {
						Storelocn_code	= bean.getStoreLocnnCode(nursing_unit);
			    }
		
			if(!Storelocn_code.equals("")  ){
				non_iv_drug_details.set(i+29,Storelocn_code);
				store_code		= Storelocn_code;
			}
			if(Storelocn_code.equals("")) //added for AAKH-CRF-0024 [IN:038260]
				Storelocn_code=Store_locn_code;
			if(iv_prep_yn.equals("6") ||iv_prep_yn.equals("0")){	
				work_sheet_batch_det1  =(ArrayList)bean.getProductName(order_id,order_line_num);								
				batch_id	=	work_sheet_batch_det1.get(1)==null?"":(String)work_sheet_batch_det1.get(1);
				expiry_date	=	work_sheet_batch_det1.get(2)==null?"":(String)work_sheet_batch_det1.get(2);
				drug_code	= "FINAL PRODUCT";															
			}
			else if(iv_prep_yn.equals("8")){
				work_sheet_batch_det1  =(ArrayList)bean.getTPNProductName(order_id,order_line_num);
				batch_id	=	work_sheet_batch_det1.get(1)==null?"":(String)work_sheet_batch_det1.get(1);
				expiry_date	=	work_sheet_batch_det1.get(2)==null?"":(String)work_sheet_batch_det1.get(2);
				drug_code	= "FINAL PRODUCT";
			}
			Auto_Admin					 =  bean.getAutoAdminValue(facility_id,Store_locn_code);
			HashMap  administred_batch   =  bean.getAdminBatchID(order_id,order_line_num,encounter_id,sch_date_time,drug_code);						
			administred_batch_id         = (String)administred_batch.get("BATCH_ID")==null?"":(String)administred_batch.get("BATCH_ID");
			disp_batch_id		 = (String)administred_batch.get("DISP_BATCH_ID")==null?"":(String)administred_batch.get("DISP_BATCH_ID");					
			disp_exp_dt			 = (String)administred_batch.get("DISP_EXPIRY_DATE")==null?"":(String)administred_batch.get("DISP_EXPIRY_DATE");
			disp_trade_id		 = (String)administred_batch.get("DISP_TRADE_ID")==null?"":(String)administred_batch.get("DISP_TRADE_ID");
			if(!locale.equals("en")){
				sch_date_time = com.ehis.util.DateUtils.convertDate(sch_date_time, "DMYHM",locale,"en");
				expiry_date = com.ehis.util.DateUtils.convertDate(expiry_date, "DMY",locale,"en");
			}	
						
			if(!locale.equals("en"))
				disp_exp_dt = com.ehis.util.DateUtils.convertDate(disp_exp_dt, "DMY",locale,"en");
			dosage_seq_no		= (String)non_iv_drug_details.get(i+17);
			trade_id			= (String)non_iv_drug_details.get(i+18)==null?"":(String)non_iv_drug_details.get(i+18);			
			dis_continued		= (String)non_iv_drug_details.get(i+19);
			hold				= (String)non_iv_drug_details.get(i+20);
			administered		= (String)non_iv_drug_details.get(i+21)==null?"":(String)non_iv_drug_details.get(i+21);
			//administered		= (String)non_iv_drug_details.get(i+22)==null?"N":(String)non_iv_drug_details.get(i+22);
			admin_recorded_yn   = request.getParameter("admin_recorded_yn")==null?"Y":request.getParameter("admin_recorded_yn"); 	
			if(non_iv_drug_details.get(i+22) == null || !((String)non_iv_drug_details.get(i+22)).equals("Y"))
			  admin_recorded_yn = "N";
			remarks				=  non_iv_drug_details.get(i+23)==null?"Not Entered":(String)non_iv_drug_details.get(i+23);
			admindrugdetails	= (String)non_iv_drug_details.get(i+24);
			pract_id			= (String)non_iv_drug_details.get(i+36);
			against_sch_date	= (String)non_iv_drug_details.get(i+37);
			if(!locale.equals("en"))
			   against_sch_date = com.ehis.util.DateUtils.convertDate(against_sch_date, "DMYHM",locale,"en");
			adr_reason			= (String)non_iv_drug_details.get(i+38);
			adr_remarks			= non_iv_drug_details.get(i+39)==null?"":(String)non_iv_drug_details.get(i+39);
			adr_record_time		= (String)non_iv_drug_details.get(i+40);
			adr_recorded_by		= (String)non_iv_drug_details.get(i+41);
			pres_dosage			= (String)non_iv_drug_details.get(i+42);
			pres_unit			= (String)non_iv_drug_details.get(i+43);
			admin_drug_code	    =  "";
			admin_drug_desc 	=  "";
						
			if( (bean.getPractitionerType(pract_id)).equals("NS")){
				tradename = bean.getTradeNameForNewEntry(encounter_id,sch_date_time,drug_code);
			}
			if(admindrugdetails != null){
				stadmindrugdetails = new StringTokenizer(admindrugdetails,":");
				while(stadmindrugdetails.hasMoreTokens()){
					admin_drug_code = stadmindrugdetails.nextToken();
					if(stadmindrugdetails.hasMoreTokens())
						admin_drug_desc = stadmindrugdetails.nextToken();
					if(stadmindrugdetails.hasMoreTokens())
						admin_dose_prn  = stadmindrugdetails.nextToken();	   // added for SKR-SCF-0304
					if(stadmindrugdetails.hasMoreTokens())
						admin_uom = stadmindrugdetails.nextToken();//admin_uom added for BRU-CRF-399.1
				}
			}
			admin_by_name = (String)non_iv_drug_details.get(i+25);
			auth_by_name  = (String)non_iv_drug_details.get(i+31);
			freq_code	  = (String)non_iv_drug_details.get(i+33);
			freq_nature	  = (String)non_iv_drug_details.get(i+34);
			showTitle = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.remarks.label", "common_labels")+"  : "+remarks+"\n "+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.AdministeredBy.label", "common_labels")+"   : "+admin_by_name;
			if(auth_by_name!=null && !auth_by_name.equals("")){
				showTitle =showTitle + "\n "+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.authorizedby.label", "common_labels")+"  : "+auth_by_name ;
			}
			admin_date_time = "";
			if(non_iv_drug_details.get(i+26)!= null){
				admin_date_time = (String)non_iv_drug_details.get(i+26);
				if(!locale.equals("en"))
					admin_date_time = com.ehis.util.DateUtils.convertDate(admin_date_time, "DMYHM",locale,"en");
			}
			modified_date_time = non_iv_drug_details.get(i+27)==null?"":(String)non_iv_drug_details.get(i+27);
			if(freq_nature!=null && freq_nature.equals("O")) 
				stat_style	=	"background-color:#CE00CE";
			else if(freq_nature!=null && freq_nature.equals("P"))
				stat_style	=	"background-color:#804040";
			else 
				stat_style	=	"";

			alt_drug			=	bean_all_stages.checkMultiStrength(drug_code);
			bean_all_stages.addDrugs(patient_id,patient_id,drug_code,alt_drug,order_line_num);	
			float tot_alt_qty       = 0.0f;

			if(multi_drugs!=null && multi_drugs.size()>0){ // added for regration issue
			for(int n=0; n<multi_drugs.size(); n+=5){ 
				tot_alt_qty += Float.parseFloat((String)multi_drugs.get(n+3));
			}
			}
            patient_class_ord = bean.getOrderPatientClass(order_id);//GHL-CRF-0458 Moved this to here  for NMC-JD-CRF-0186:  46294
			displayStyle		=	"";
			statusFlag		=	"YES";	// Whether it has to be considered for transaction or not.	// It won't be considered if Alternate Drug is selected.
			addDisplayStyle	=	"";
			checked			=	"";
			// START NMC-JD-CRF-0186 [43323]
			String  episode_type = "";
			String  visit_id = "";
			String  classValSelect = "visibleCheck";
			String  isEnabled = "enable";
			boolean  billChecked = true;
			String unbilledMedicateYN =  bean.getUnbilledMedicateYN(facility_id);
			ArrayList epVisitResult =  bean.getDetails(facility_id, patient_id, encounter_id);
			if(epVisitResult.size() != 0){ 
				episode_type =(String)epVisitResult.get(0);
				visit_id =(String)epVisitResult.get(1);
			 }
			boolean mar_unbill_med_blueColor_disable =  bean.isSiteSpecific("PH","ALLOW_MAR_DISP_UNBILL_MED");//added for NMC-JD-CRF-0186 US002&03 [45063]		
			String billStatus =  bean.getBillStatus(facility_id,patient_id,encounter_id.substring(0,8),episode_type,visit_id,order_id,order_line_num)==null?"":bean.getBillStatus(facility_id,patient_id,encounter_id.substring(0,8),episode_type,visit_id,order_id,order_line_num);  // "" - episode_id
			
			if(billStatus.equals("UNBILLED") && (unbilledMedicateYN.equals("N") 
					|| unbilledMedicateYN == "N") && mar_unbill_med_blueColor_disable && administered.equals("N") && (patient_class_ord.equals("OP")||patient_class_ord.equals("EM"))){ /* [45063] Added for NMC-JD-CRF-0186[46294] */ 
				classValSelect  = "hiddenCheck"; 
				isEnabled  = "disabled"; 
				billChecked  = false; 
			} 
			//END NMC-JD-CRF-0186 [43323]
			select_status_1			=   "";
			  if(admin_bean.getEarlyOrLateAdminYn().equals("Y")){ // Added for GHL-CRF-0482 [IN:064955] - Start
					future_or_late_admin = ""; 
			  } // Added for GHL-CRF-0482 [IN:064955] - End
			
			if(bean.getCurrentTimeAndAdminWithinHRS().size()>2){
			  future_date_time   = com.ehis.util.DateUtils.plusDate(current_date_time,"DMYHM",locale,Integer.parseInt(bean.getCurrentTimeAndAdminWithinHRS().get(1).toString()),"h").toString(); 
			}		
			if (admin_bean.compareDates(sch_date_time_in_locale,admin_from_date) && !(freq_nature.equals("P"))){
				medn_admn_dtl_reqd_yn = "Y";
			  if(admin_bean.getEarlyOrLateAdminYn().equals("Y")){ // Added for GHL-CRF-0482 [IN:064955] - Start
				future_or_late_admin = "L"; 
			  } // Added for GHL-CRF-0482 [IN:064955] - End
			}
			else if(admin_bean.getEarlyOrLateAdminYn().equals("Y") && admin_bean.compareDates(future_date_time,sch_date_time_in_locale) &&  !(freq_nature.equals("P"))){ // Added for GHL-CRF-0482 [IN:064955] - Start
				medn_admn_dtl_reqd_yn = "Y";
				future_or_late_admin = "F";
			} // Added for GHL-CRF-0482 [IN:064955] - End
			if(medn_admn_dtl_reqd_yn == null)
				medn_admn_dtl_reqd_yn="N";
			if(medn_admn_dtl_reqd_yn.equals("Y")) 
				mand_display	=	"style='display:inline'";
			else
				mand_display	=	"style='display:none'";

			select_status	=	"";
			dtl_style		=	"font-size:10;color:blue;cursor:pointer;align:center";
		
			if(!locale.equals("en"))
				sch_date_time = com.ehis.util.DateUtils.convertDate(sch_date_time, "DMYHM","en",locale);
			if(freq_code!=null && freq_code.equals("STAT"))//added by abdul for SCF# 5899
				displayStyle	=	"background-color:#CE00CE;";
			else if(dis_continued.equals("Y"))
				displayStyle = "BACKGROUND-COLOR:red;";
			else if(hold.equals("Y"))
				displayStyle = "BACKGROUND-COLOR:yellow;";
			else if(admin_recorded_yn.equals("Y")){
				if(administered.equals("N")) {
					displayStyle = "BACKGROUND-COLOR:#000000;cursor:pointer;";//added for AAKH-CRF-0024 [IN:038260]
					could_not_administer = "Y";
				} 
				else{  
					displayStyle = "BACKGROUND-COLOR:green;";
					batch_ids	= new ArrayList();
				}
			}
			verbalOrder="";	
			if((bean.getPractitionerType(pract_id)).equals("NS"))
				verbalOrder="<b>V<b>";
			if(admin_recorded_yn.equals("Y") && !admin_drug_code.equals("") && !admin_drug_code.equals(drug_code) ){
				showTitle =  ("Ordered Drug : "+drug_desc+"\n") + showTitle;
				displayStyle = "BACKGROUND-COLOR:#CC99CC;";
			}
			if(drug_class!=null && drug_class.equals("N"))
				drug_class_ind = "background:#66FFFF";
			else if(drug_class!=null && drug_class.equals("C"))
				drug_class_ind = "background:#CCFFCC";
			else if(iv_prep_yn.equals("6"))
				drug_class_ind = "background:#E4CAFF";
			else
				drug_class_ind = "";
			adr_reason	=	admin_bean.getReasonDesc("M",adr_reason);
			adr_details	=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.AgnstSchedDate.label", "ph_labels")+	":"+com.ehis.util.DateUtils.convertDate(against_sch_date,"DMYHM","en",locale)+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.PostAdmnRsn.label", "ph_labels")+": "+adr_reason+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.remarks.label", "common_labels")+":"+adr_remarks.replaceAll("\"",demostring)+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.recordeddate.label", "common_labels")+" :"+adr_record_time+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.RecordedBy.label", "common_labels")+": "+adr_recorded_by;									
			if(!admin_date_time.equals("")){
				img_path	=	"<img SRC='../../eOR/images/Authorized.gif' onClick=\"recordADR('"+encounter_id+"','"+drug_code+"','1',this,'"+sch_date_time+"','"+order_id+"')\" title='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.RecordPostAdministrationDetails.label", "ph_labels")+"' style='cursor:pointer'></img>";
			}
			 drug_indication_remarks=bean_all_stages.getdrugIntaractions(order_id,order_line_num);
			
			if(drug_indication_remarks.trim().equals("") && drug_remarks.trim().equals("") && pharma_remarks.trim().equals("") && pres_remarks.trim().equals("") && prn_remarks.trim().equals("")&& slidingscaleremarks.trim().equals("")&& verificationremarks.equals("")&&show_remarks.equals("N")){
				remarks_style	=	"style='visibility:hidden'";
			}
			else{
				dialog_height = 0 ;
				if(!prn_remarks.trim().equals(""))
					dialog_height	 += 6.5;
				if(!drug_remarks.trim().equals(""))
					dialog_height	 += 6.5;
				if(!pres_remarks.trim().equals(""))
					dialog_height	 += 6.5;
				if(!slidingscaleremarks.trim().equals(""))
					dialog_height	 += 6.5;
				if(!verificationremarks.trim().equals(""))
					dialog_height	 += 6.5;
				if(show_remarks.equals("Y"))
					dialog_height	 += 13;
				remarks_style	=	"style='visibility:visible'";
				dialog_height	 += 1.4;
			}												
			if(sliding_scale_applicable.equals("Y")){
				sliding_scale_details=bean.getSlidingScaleTemplateDetails(order_id,order_line_num);
				AdUOM="";
				if(sliding_scale_details.size()>0)
					AdUOM=(String)sliding_scale_details.get(6);
			}
			alt_drug_display="display:none";				//Added for Bru-HIMS-CRF-399 [IN:043767] start
			arrAltDrugs = bean_all_stages.getAlternateDrugs(drug_code,generic_id);
			if(allow_mar_alternate_drug_yn.equals("Y") && Auto_Admin.equals("Y") && alt_drug.equals("Y") && arrAltDrugs.size()>0){
				alt_drug_display="display:inline";			//Added for Bru-HIMS-CRF-399 [IN:043767] end
				alt_flag = true;
			}

            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(sliding_scale_applicable));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(modified_date_time));
            _bw.write(_wl_block37Bytes, _wl_block37);

			if(admin_recorded_yn.equals("Y") || dis_continued.equals("Y") || hold.equals("Y")){
				if(admin_recorded_yn.equals("Y") && administered.equals("N"))
					batch_ids       =   bean.getAllBatchIDS(order_id,order_line_num,"N");
				else if(admin_recorded_yn.equals("Y") && administered.equals("Y")){//Added for INC#48901--start
					batch_ids.add(batch_id);
					batch_ids.add(expiry_date);
					batch_ids.add(trade_id);
					batch_ids.add(tradename);//Added for INC#48901--end
					batch_ids.add("");
					batch_ids.add("");
					batch_ids.add("");//added for GHL-CRF-458
					batch_ids.add("");//added for GHL-CRF-482
					batch_ids.add("");//added for GHL-CRF-482

				}
				else
					batch_ids       =   bean.getAllBatchIDS(order_id,order_line_num,"Y");

            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(displayStyle));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(current_date_time));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(administered));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(admin_recorded_yn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(admin_from_date));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(admin_to_date));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(verbalOrder));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(drug_class_ind));
            _bw.write(_wl_block47Bytes, _wl_block47);
	
				if(!(iv_prep_yn.equals("0")||iv_prep_yn.equals("2")||iv_prep_yn.equals("4")||iv_prep_yn.equals("6")||iv_prep_yn.equals("7")||iv_prep_yn.equals("8"))) {

            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(disp_drug_code));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block50Bytes, _wl_block50);
				}
				else{

            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block52Bytes, _wl_block52);

				}/*added for AAKH-CRF-0024 [IN:038260] ends  */
				if(admin_recorded_yn.equals("Y") && !admin_drug_code.equals("") && !admin_drug_code.equals(drug_code) ){												

            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(admin_drug_desc));
            _bw.write(_wl_block1Bytes, _wl_block1);
								
				}
				else{												

            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block56Bytes, _wl_block56);

				}
				if(ext_prod_id!=null && !ext_prod_id.equals("")&& !(iv_prep_yn.equals("0"))&& !(iv_prep_yn.equals("9")&&order_line_num.equals("1")&&(Integer.parseInt(onco_direct_drug_count)>1)) && !(iv_prep_yn.equals("6"))){

            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(ext_prod_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(java.net.URLEncoder.encode(admin_drug_desc,"UTF-8")));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.DrugInformation.label", "ph_labels")));
            _bw.write(_wl_block59Bytes, _wl_block59);

				}
				if(imageFileURL!=null && !imageFileURL.equals("")){

            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(trade_code));
            _bw.write(_wl_block61Bytes, _wl_block61);

				}
				if(adr_count>0){ // added for RUT-SCF-0144 [IN:033371]  -- start

            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(patient_id_test));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block64Bytes, _wl_block64);

				} //added for RUT-SCF-0144 [IN:033371]  -- end
				if(!(iv_prep_yn.equals("0")||iv_prep_yn.equals("2")||iv_prep_yn.equals("4")||iv_prep_yn.equals("6"))){

            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block61Bytes, _wl_block61);
										
				}
				if(iv_prep_yn.equals("7")){
					if(ppn_count >0){

            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(Store_locn_code));
            _bw.write(_wl_block67Bytes, _wl_block67);
	
					}
				}
				if(boolAllergy_icon){

            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(java.net.URLEncoder.encode(generic_name,"UTF-8")));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(encode_drug_desc));
            _bw.write(_wl_block61Bytes, _wl_block61);
					
				}
				if(taper_yn.equals("Y") && totalTaperQtyDisplay.equals("Y") ){   //if and else Added for RUT-CRF-0088 [IN036978]
					addedTaperSch = bean.getAddedTaperSch(facility_id+"~"+encounter_id+"~"+order_id+"~"+drug_code+"~"+sch_date_time);
					if(addedTaperSch.equals("N") && administered.equals("Y") ){  // Checks whether this row has been taperd or not

            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(inc));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block70Bytes, _wl_block70);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);

					}
					else{

            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);
				
					}
					if(addedTaperSch.equals("Y"))
						addedTaperSch = "disabled";
				}

            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(statusFlag));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(dispense_drug_code));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(end_date_time));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(Auto_Admin));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(order_pract_id));
            _bw.write(_wl_block95Bytes, _wl_block95);
if(cancel_recorded_yn.equals("Y")){
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(encode_drug_desc));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(admin_date_time));
            _bw.write(_wl_block97Bytes, _wl_block97);
}
            _bw.write(_wl_block98Bytes, _wl_block98);

				if(adr_reason!=null && !adr_reason.equals("")) {

            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(adr_details));
            _bw.write(_wl_block101Bytes, _wl_block101);

				} 
				else if(!admin_date_time.equals("") && administered.equals("Y")){

            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(img_path));
            _bw.write(_wl_block103Bytes, _wl_block103);

				}
				else{

            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block104Bytes, _wl_block104);
	
				}

            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(dialog_height));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(encode_drug_desc));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Remarks.label", "ph_labels")));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(remarks_style));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block37Bytes, _wl_block37);

				if(iv_prep_yn.equals("8")){ 

            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block110Bytes, _wl_block110);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);

				}
				else if(iv_prep_yn.equals("0") || iv_prep_yn.equals("9")){	

            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(Store_locn_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(sliding_scale_applicable));
            _bw.write(_wl_block113Bytes, _wl_block113);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);

				}
				else if(iv_prep_yn.equals("6")){	

            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(Store_locn_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(sliding_scale_applicable));
            _bw.write(_wl_block113Bytes, _wl_block113);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);

				}
				else{	

            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(Store_locn_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(sliding_scale_applicable));
            _bw.write(_wl_block113Bytes, _wl_block113);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);

				}

            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block37Bytes, _wl_block37);
				
				if(alt_flag){//BRU-CRF-399.1
					schedule_uom_desc = bean.getUomDisplay(facility_id,admin_uom);
					short_desc		  = schedule_uom_desc;
				}
				if(Float.parseFloat(qty) < 1.0){
					qty = Float.parseFloat(qty)+""; 
				}
				if((dis_continued.equals("Y") || hold.equals("Y"))&& !(admin_recorded_yn.equals("Y")) && sliding_scale_applicable.equals("Y")){
					AdUOM="&nbsp;";

            _bw.write(_wl_block116Bytes, _wl_block116);
				}
				else{
					if(freq_nature.equals("P")) {//	added  for SCF-7692 -- incident no 27804 -- start
						qty=admin_dose_prn;
						
					} // Added for SKR-SCF-304
					if(could_not_administer.equals("")){ //if added for SKR-SCF-1264
					if(dosage_type.equals("S")){

            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block119Bytes, _wl_block119);
					}
					else  { // for others (absolute, quantity.)

            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block119Bytes, _wl_block119);

					}//SCF-7692 -- incident no 27804 -- end
					}else{ //else block added for SKR-SCF-1264

            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block121Bytes, _wl_block121);
					}  
				}
				if(sliding_scale_applicable.equals("Y")){

            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(AdUOM));
            _bw.write(_wl_block71Bytes, _wl_block71);

					dosageDescription = AdUOM;
				}
				else{
					if(freq_nature.equals("P")){ //PRN


            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(schedule_uom_desc));
            _bw.write(_wl_block125Bytes, _wl_block125);

						 dosageDescription = schedule_uom_desc;
					}
					else{

            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block71Bytes, _wl_block71);

						dosageDescription = short_desc;
					}
				}

            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(strength_value_prn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(dosage_type));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(content_in_pres_base_uom));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(strength_per_value_pres_uom));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(disp_with_alt));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(freq_nature));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(addDisplayStyle));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(select_status));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(dosageDescription));
            _bw.write(_wl_block137Bytes, _wl_block137);

				if(!(admn_dose_chng_reason_code.equals(""))){
					String admn_chng_dose_reason_desc = (String) bean. getAdmn_chng_dose_reason_desc(admn_dose_chng_reason_code);

            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.ChangedAdminDosageReason.label", "ph_labels") +"\n"));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf("\n"+admn_chng_dose_reason_desc));
            _bw.write(_wl_block59Bytes, _wl_block59);

				}

            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block146Bytes, _wl_block146);

				if(freq_nature.equals("P")){	

            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(schedule_uom_code));
            _bw.write(_wl_block37Bytes, _wl_block37);

				}
				else{ 

            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(uom_code));
            _bw.write(_wl_block37Bytes, _wl_block37);

				}

            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(fntColor));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(backGrndColor));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(route_desc));
            _bw.write(_wl_block152Bytes, _wl_block152);

				   fntColor ="000000";    //Code Changed For RUT-CRF-0034 Route Color
				   backGrndColor="FFFFFF";
				
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block37Bytes, _wl_block37);

				if(!(sch_date_time==null || freq_nature.equals("P"))){

            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block156Bytes, _wl_block156);
				if(mfr_yn.equals("Y")){//ML-MMOH-CRF-1014- start
							MfrDetails=bean.getStatusOfMAR(order_id,"");

							if(MfrDetails.size()>0){
								statusString=(String)MfrDetails.get(0);
								mfrCompletedStatus=new Boolean((String)MfrDetails.get(1)).booleanValue(); 														
							}
							if(!mfrCompletedStatus ){// if added for ml-mmoh-crf-1014
								select_status="disabled";
							}
							
            _bw.write(_wl_block157Bytes, _wl_block157);
if(order_line_num.equals("1")){
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_desc,"UTF-8")));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(Store_locn_code));
            _bw.write(_wl_block161Bytes, _wl_block161);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(statusString));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(mfrRemarks));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block165Bytes, _wl_block165);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block166Bytes, _wl_block166);
}else{
            _bw.write(_wl_block167Bytes, _wl_block167);
}
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(mfrRemarks));
            _bw.write(_wl_block37Bytes, _wl_block37);
						}else{ 
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block71Bytes, _wl_block71);
					}
				}
				else{

            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block171Bytes, _wl_block171);

				}

            _bw.write(_wl_block172Bytes, _wl_block172);

				if(!admin_date_time.equals("")){
					if(!locale.equals("en")){
						modified_date_time = com.ehis.util.DateUtils.convertDate(modified_date_time, "DMYHM","en",locale);
						admin_date_time = com.ehis.util.DateUtils.convertDate(admin_date_time, "DMYHM","en",locale);
					}

            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.recordeddatetime.label", "common_labels")));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(modified_date_time));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(admin_date_time));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(defaultDate.equals("")?current_date_time:defaultDate));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(select_status));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(admin_date_time));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(current_date_time));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block183Bytes, _wl_block183);

				}
				else{
					if(!locale.equals("en")){
						modified_date_time = com.ehis.util.DateUtils.convertDate(modified_date_time, "DMYHM","en",locale);
					}

            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.recordeddatetime.label", "common_labels")));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(modified_date_time));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(defaultDate.equals("")?current_date_time:defaultDate));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(select_status));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(modified_date_time));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(current_date_time));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block185Bytes, _wl_block185);

				}

            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block146Bytes, _wl_block146);

				bat_id_lookbutton_enabled="Y"; //Added FOR  [IN:043702] -Start
				if(!(sliding_scale_applicable.equals("Y")&& batch_ids.size()==0)){		
					if(iv_prep_yn.equals("6") ||iv_prep_yn.equals("0")||iv_prep_yn.equals("8"))
							bat_id_lookbutton_enabled="NOT";
					else if(batch_ids.size()==0){
						bat_id_lookbutton_enabled="Y";
						if(auto_Admin_dis.equals("disabled")||select_status.equals("disabled"))
							bat_id_lookbutton_enabled="N";
					}
					else if(batch_ids.size()==9){//changed 4 to 6 for CRF-413.8 and 6 to 7 for GHL-CRF-0458 //and 7 to 9 for GHL-CRF-0482
						batch_id = (String)batch_ids.get(0);
						expiry_date = (String)batch_ids.get(1);
						trade_id    = (String)batch_ids.get(2);
						tradename   = (String)batch_ids.get(3);
						select_status="disabled";
						totQty =(ArrayList)bean.getTotQty(patient_id,drug_code,admin_from_date,admin_to_date,order_id,order_line_num);
						for(int j=0;j<totQty.size();j=j+4){
							returned_qty = (Float)totQty.get(j+2);
							tot_administered_qty=  (Float)totQty.get(j+3);
						} 
						WardReturnQty =(ArrayList)bean.getWardRetrunQty(patient_id,order_id,performingDeptLocCode,facility_id);
						for(int k=0;k<WardReturnQty.size();k=k+2){
						  disp_qty =(Float)WardReturnQty.get(k);
						  ward_return_qty =(Float)WardReturnQty.get(k+1);
						}
						ret_qty=disp_qty-(returned_qty+ward_return_qty+tot_administered_qty);
						bat_id_lookbutton_enabled="N";
						if(ret_qty>0){
							batch_id="";
							expiry_date="";
							select_status="";
						}
					}
					else
						bat_id_lookbutton_enabled="NOT";
				}
				else
					bat_id_lookbutton_enabled="N"; //Added for  [IN:043702] -end //onclick="enableDisableTextbox - aaded for [IN:043702]
				if(adminsted_pat_brought_medn.equals("Y")){

            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(adminsted_pat_brought_medn));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(medn_admn_dtl_reqd_yn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(bat_id_lookbutton_enabled));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block191Bytes, _wl_block191);
				}
				else{

            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(adminsted_pat_brought_medn));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(medn_admn_dtl_reqd_yn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(bat_id_lookbutton_enabled));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block193Bytes, _wl_block193);
									
				}

            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(onco_direct_drug_count));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(bat_id_lookbutton_enabled));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(medn_admn_dtl_reqd_yn));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(drug_class));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(dosage_type));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(trade_id));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(defaultTradeId.equals("")?tradename:defaultTradeId));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(addDisplayStyle));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block37Bytes, _wl_block37);

				if(batch_id.equals(disp_batch_id) || disp_batch_id.equals("")){

            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.TradeName.label", "common_labels")));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(tradename));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(batch_id));
            _bw.write(_wl_block71Bytes, _wl_block71);

				}
				else{

            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.DispBatchId.label", "ph_labels")));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(disp_batch_id));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.DispExpiryDate.label", "ph_labels")));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(disp_exp_dt));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.DispTradeId.label", "ph_labels")));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(disp_trade_id));
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(batch_id));
            _bw.write(_wl_block228Bytes, _wl_block228);

				}

            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf(defaultBatch.equals("")?batch_id:defaultBatch));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(select_status));
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(Storelocn_code));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.expiryDate.label", "common_labels")));
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(expiry_date, "DMY","en",locale)));
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(expiry_date, "DMY","en",locale)));
            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(defaultExpiryDate.equals("")?expiry_date:defaultExpiryDate));
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(addDisplayStyle));
            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block254Bytes, _wl_block254);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(tradename));
            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(stat_style));
            _bw.write(_wl_block37Bytes, _wl_block37);

				if(!(iv_prep_yn.equals("9")&&!(order_line_num.equals("1")))){

            _bw.write(_wl_block258Bytes, _wl_block258);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block259Bytes, _wl_block259);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block261Bytes, _wl_block261);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf("N"));
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block264Bytes, _wl_block264);
            out.print( String.valueOf(select_status_1));
            _bw.write(_wl_block265Bytes, _wl_block265);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(dtl_style));
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf(encode_drug_desc));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(drug_class));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(freq_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block269Bytes, _wl_block269);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(medn_admn_dtl_reqd_yn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block270Bytes, _wl_block270);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block271Bytes, _wl_block271);
            out.print( String.valueOf(administered));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(admin_recorded_yn));
            _bw.write(_wl_block272Bytes, _wl_block272);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block273Bytes, _wl_block273);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block274Bytes, _wl_block274);
	
					if(admin_recorded_yn.equals("Y")){

            _bw.write(_wl_block275Bytes, _wl_block275);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block276Bytes, _wl_block276);
            out.print( String.valueOf(showTitle));
            _bw.write(_wl_block277Bytes, _wl_block277);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);

					}
				}
				else { 
					if(mand_display.equals("style='display:inline'")){//if block added for AAKH-CRF-0024 [IN:038260]

            _bw.write(_wl_block278Bytes, _wl_block278);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(medn_admn_dtl_reqd_yn));
            _bw.write(_wl_block279Bytes, _wl_block279);
 
					}//added for AAKH-CRF-0024 [IN:038260] Ends				
				}

            _bw.write(_wl_block280Bytes, _wl_block280);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block281Bytes, _wl_block281);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(mand_display));
            _bw.write(_wl_block282Bytes, _wl_block282);

				if(iv_prep_yn.equals("9")){	
					if(!order_line_num.equals("1")){
						select_status_1="disabled";

            _bw.write(_wl_block283Bytes, _wl_block283);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block284Bytes, _wl_block284);
            _bw.write(_wl_block285Bytes, _wl_block285);
            out.print( String.valueOf(classValSelect));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(patient_stock_display));
            _bw.write(_wl_block286Bytes, _wl_block286);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block287Bytes, _wl_block287);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block288Bytes, _wl_block288);
            out.print( String.valueOf(billChecked));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(isEnabled));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(select_status_1));
            _bw.write(_wl_block289Bytes, _wl_block289);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(pres_dosage));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(pres_unit));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(freq_nature));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(disp_schedule_uom_desc));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(admin_uom_desc));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(AdminBackLogTime));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(current_date_time));
            _bw.write(_wl_block290Bytes, _wl_block290);
            out.print( String.valueOf(defaultDate.equals("")?current_date_time:defaultDate));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block291Bytes, _wl_block291);
            out.print( String.valueOf(auth_reqd_script));
            _bw.write(_wl_block292Bytes, _wl_block292);

					}
					else{

            _bw.write(_wl_block283Bytes, _wl_block283);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block293Bytes, _wl_block293);
if(!freq_nature.equals("P") && cancelYn.equals("Y") &&!dis_continued.equals("Y") && !hold.equals("Y") &&(iv_prep_yn.equals("") || iv_prep_yn==null || iv_prep_yn.equals("1") || iv_prep_yn.equals("3") || iv_prep_yn.equals("5") || iv_prep_yn.equals("9"))){//ADDED FOR JD-CRF-0200 and freq_nature added for SKR-SCF-1429 
            _bw.write(_wl_block294Bytes, _wl_block294);
            out.print( String.valueOf(encode_drug_desc));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(admin_by_name));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(admin_date_time));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(strength_per_value_pres_uom));
            _bw.write(_wl_block295Bytes, _wl_block295);

					}	

            _bw.write(_wl_block296Bytes, _wl_block296);
            _bw.write(_wl_block285Bytes, _wl_block285);
            out.print( String.valueOf(classValSelect));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(patient_stock_display));
            _bw.write(_wl_block297Bytes, _wl_block297);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block287Bytes, _wl_block287);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block288Bytes, _wl_block288);
            out.print( String.valueOf(billChecked));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(isEnabled));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(select_status_1));
            _bw.write(_wl_block289Bytes, _wl_block289);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(pres_dosage));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(pres_unit));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(freq_nature));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(disp_schedule_uom_desc));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(admin_uom_desc));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(AdminBackLogTime));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(current_date_time));
            _bw.write(_wl_block290Bytes, _wl_block290);
            out.print( String.valueOf(defaultDate.equals("")?current_date_time:defaultDate));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block298Bytes, _wl_block298);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(onco_direct_drug_count));
            _bw.write(_wl_block299Bytes, _wl_block299);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block291Bytes, _wl_block291);
            out.print( String.valueOf(auth_reqd_script));
            _bw.write(_wl_block300Bytes, _wl_block300);
					}
				}
				else{

            _bw.write(_wl_block301Bytes, _wl_block301);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(patient_stock_display));
            _bw.write(_wl_block302Bytes, _wl_block302);
            _bw.write(_wl_block303Bytes, _wl_block303);
            out.print( String.valueOf(classValSelect));
            _bw.write(_wl_block304Bytes, _wl_block304);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block287Bytes, _wl_block287);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block288Bytes, _wl_block288);
            out.print( String.valueOf(billChecked));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(isEnabled));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(select_status_1));
            _bw.write(_wl_block289Bytes, _wl_block289);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(pres_dosage));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(pres_unit));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(freq_nature));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(disp_schedule_uom_desc));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(admin_uom_desc));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(AdminBackLogTime));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(current_date_time));
            _bw.write(_wl_block290Bytes, _wl_block290);
            out.print( String.valueOf(defaultDate.equals("")?current_date_time:defaultDate));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block291Bytes, _wl_block291);
            out.print( String.valueOf(auth_reqd_script));
            _bw.write(_wl_block305Bytes, _wl_block305);
if(!freq_nature.equals("P") && cancelYn.equals("Y") &&!dis_continued.equals("Y") && !hold.equals("Y")&&(iv_prep_yn.equals("") || iv_prep_yn==null || iv_prep_yn.equals("1") || iv_prep_yn.equals("3") || iv_prep_yn.equals("5") || iv_prep_yn.equals("9"))){//ADDED FOR JD-CRF-0200 and freq_nature added for SKR-SCF-1429 
            _bw.write(_wl_block294Bytes, _wl_block294);
            out.print( String.valueOf(encode_drug_desc));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(admin_by_name));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(admin_date_time));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(strength_per_value_pres_uom));
            _bw.write(_wl_block295Bytes, _wl_block295);

					}	} //added for AAKH-CRF-0024 [IN:038260] Ends

            _bw.write(_wl_block306Bytes, _wl_block306);

			} // end 	if(admin_recorded_yn.equals("Y") || dis_continued.equals("Y") || hold.equals("Y")) on line no. 841
			else{
				//GHL-CRF-0482 - start

			if(patient_stock_required!=null && patient_stock_required.equals("Y")) 
				patient_stock_check_display	=	"display:inline"; 
			else
				patient_stock_check_display	=	"display:none";

				if(patient_stock_required!=null && patient_stock_required.equals("Y") && iv_prep_yn.equals("")){
						batchIdforOrders = bean.getBatchIdForOrders();
						if(batchIdforOrders!=null && batchIdforOrders.containsKey(drug_code)){
							int rec_count   =	bean.getDispDetailCount(order_id,order_line_num);
							 if(rec_count>0 || (patient_stock_yn.equals("Y") && order_status.equals("DF")))
								batch_ids = (ArrayList)batchIdforOrders.get(drug_code);
							 else
								batch_ids = new ArrayList();
						}else{
							int rec_count   =	bean.getDispDetailCount(order_id,order_line_num);
							if(rec_count>0 || (patient_stock_yn.equals("Y") && order_status.equals("DF")))
								batch_ids       =   bean.getAllBatchIDSForPatientStock(patient_id,facility_id,encounter_id,drug_code);
							else
								batch_ids = new ArrayList();
						}
					
				}else{ 				//GHL-CRF-0482 - end
					batch_ids       =   bean.getAllBatchIDS(order_id,order_line_num,"N");	
				}

				if(batch_ids!=null && batch_ids.size()>0 && !disp_drug_code.equals(drug_code) && !iv_prep_yn.equals("6") && !iv_prep_yn.equals("0") && !iv_prep_yn.equals("8") ){ //added for BRU-CRF-399.1 - start
					if(disp_drugs!=null && disp_drugs.indexOf(",")!=-1){
					alt_multi_drug_flag = true;
					}
				}//added for BRU-CRF-399.1 - end


            _bw.write(_wl_block307Bytes, _wl_block307);
            out.print( String.valueOf(displayStyle));
            _bw.write(_wl_block277Bytes, _wl_block277);
            out.print( String.valueOf(verbalOrder));
            _bw.write(_wl_block308Bytes, _wl_block308);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(drug_class_ind));
            _bw.write(_wl_block309Bytes, _wl_block309);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(statusFlag));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(dispense_drug_code));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block310Bytes, _wl_block310);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(end_date_time));
            _bw.write(_wl_block311Bytes, _wl_block311);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(drug_class));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block312Bytes, _wl_block312);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(medn_admn_dtl_reqd_yn));
            _bw.write(_wl_block313Bytes, _wl_block313);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block314Bytes, _wl_block314);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(dosage_type));
            _bw.write(_wl_block315Bytes, _wl_block315);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(onco_direct_drug_count));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block316Bytes, _wl_block316);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block317Bytes, _wl_block317);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(Auto_Admin));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(order_pract_id));
            _bw.write(_wl_block318Bytes, _wl_block318);

				if ((iv_prep_yn.equals("0"))||(iv_prep_yn.equals("2"))||(iv_prep_yn.equals("4"))||(iv_prep_yn.equals("6"))||(iv_prep_yn.equals("7"))||(iv_prep_yn.equals("8"))) {

            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block52Bytes, _wl_block52);

				}
				else{

            _bw.write(_wl_block319Bytes, _wl_block319);
            out.print( String.valueOf(disp_drug_code));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block50Bytes, _wl_block50);

				}

            _bw.write(_wl_block320Bytes, _wl_block320);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block321Bytes, _wl_block321);
if(cancel_recorded_yn.equals("Y")){
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(encode_drug_desc));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(admin_date_time));
            _bw.write(_wl_block322Bytes, _wl_block322);
			}	
				if(ext_prod_id!=null && !ext_prod_id.equals("") && !(iv_prep_yn.equals("0"))&& !(iv_prep_yn.equals("9")&&order_line_num.equals("1")&&(Integer.parseInt(onco_direct_drug_count)>1))&& !(iv_prep_yn.equals("6"))){

            _bw.write(_wl_block323Bytes, _wl_block323);
            out.print( String.valueOf(ext_prod_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_desc,"UTF-8")));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.DrugInformation.label", "ph_labels")));
            _bw.write(_wl_block59Bytes, _wl_block59);

				}
				if(imageFileURL!=null && !imageFileURL.equals("")){

            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(trade_code));
            _bw.write(_wl_block61Bytes, _wl_block61);

				}
				if(adr_count>0){ // added for RUT-SCF-0144 [IN:033371]  -- start

            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(patient_id_test));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block64Bytes, _wl_block64);

				} // added for RUT-SCF-0144 [IN:033371]  -- end
				if(!(iv_prep_yn.equals("0")||iv_prep_yn.equals("2")||iv_prep_yn.equals("4")||iv_prep_yn.equals("6"))){

            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block61Bytes, _wl_block61);
						
				}
				if(iv_prep_yn.equals("7")){
					if(ppn_count >0){

            _bw.write(_wl_block324Bytes, _wl_block324);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(Store_locn_code));
            _bw.write(_wl_block325Bytes, _wl_block325);
					}
				}
				if(boolAllergy_icon){

            _bw.write(_wl_block326Bytes, _wl_block326);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(java.net.URLEncoder.encode(generic_name,"UTF-8")));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(encode_drug_desc));
            _bw.write(_wl_block327Bytes, _wl_block327);

				}
				

            _bw.write(_wl_block328Bytes, _wl_block328);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block329Bytes, _wl_block329);
            out.print( String.valueOf(alt_drug_display));
            _bw.write(_wl_block330Bytes, _wl_block330);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(encode_drug_desc));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(expiry_date));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(uom_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(freq_nature));
            _bw.write(_wl_block331Bytes, _wl_block331);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block332Bytes, _wl_block332);
				
				if(taper_yn.equals("Y")&& totalTaperQtyDisplay.equals("Y")){   //if and else Added for RUT-CRF-0088 [IN:036978]
					addedTaperSch = bean.getAddedTaperSch(facility_id+"~"+encounter_id+"~"+order_id+"~"+drug_code+"~"+sch_date_time);
					if(addedTaperSch.equals("N") && administered.equals("Y")){  // Checks whether this row has been taperd or not

            _bw.write(_wl_block333Bytes, _wl_block333);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(inc));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block70Bytes, _wl_block70);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);

					}
					else{

            _bw.write(_wl_block334Bytes, _wl_block334);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);
				
					}
					if(addedTaperSch.equals("Y"))
						addedTaperSch = "disabled";
				}

            _bw.write(_wl_block335Bytes, _wl_block335);

				if(dispensed_drug_desc==null || dispensed_drug_desc.equals(""))
					disp_drugs="";

            _bw.write(_wl_block336Bytes, _wl_block336);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block337Bytes, _wl_block337);
            out.print( String.valueOf(disp_drugs));
            _bw.write(_wl_block338Bytes, _wl_block338);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block339Bytes, _wl_block339);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(disp_drugs));
            _bw.write(_wl_block37Bytes, _wl_block37);

				if(linkVacScheduleYN.equals("Y")){ 
					if((!(iv_prep_yn.equals("9")||iv_prep_yn.equals("6")))||(iv_prep_yn.equals("9")&&order_line_num.equals("1"))){

            _bw.write(_wl_block340Bytes, _wl_block340);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block341Bytes, _wl_block341);
            out.print( String.valueOf(linkVacScheduleDescToolTip));
            _bw.write(_wl_block342Bytes, _wl_block342);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block343Bytes, _wl_block343);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block344Bytes, _wl_block344);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block345Bytes, _wl_block345);
            out.print( String.valueOf(linkVacScheduleDesc));
            _bw.write(_wl_block346Bytes, _wl_block346);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block347Bytes, _wl_block347);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block348Bytes, _wl_block348);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block349Bytes, _wl_block349);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block350Bytes, _wl_block350);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block351Bytes, _wl_block351);
            out.print( String.valueOf(linkVacScheduleCode));
            _bw.write(_wl_block352Bytes, _wl_block352);
					}
				}

            _bw.write(_wl_block353Bytes, _wl_block353);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block354Bytes, _wl_block354);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(dialog_height));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(encode_drug_desc));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Remarks.label", "ph_labels")));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(remarks_style));
            _bw.write(_wl_block355Bytes, _wl_block355);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block37Bytes, _wl_block37);
  
				if(iv_prep_yn.equals("8")){ 

            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block110Bytes, _wl_block110);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);

				}
				if(iv_prep_yn.equals("0") || iv_prep_yn.equals("9")){	

            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(Store_locn_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(sliding_scale_applicable));
            _bw.write(_wl_block113Bytes, _wl_block113);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);

				}
				else if(iv_prep_yn.equals("6")){

            _bw.write(_wl_block356Bytes, _wl_block356);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(Store_locn_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(sliding_scale_applicable));
            _bw.write(_wl_block113Bytes, _wl_block113);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);

				}
				else if(!iv_prep_yn.equals("8")){

            _bw.write(_wl_block356Bytes, _wl_block356);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(Store_locn_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(sliding_scale_applicable));
            _bw.write(_wl_block113Bytes, _wl_block113);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);

				}

            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block357Bytes, _wl_block357);
								
				if(sliding_scale_applicable.equals("Y") && sliding_scale_details.size()>0){								
					rangeUOM=(String)sliding_scale_details.get(5);

            _bw.write(_wl_block358Bytes, _wl_block358);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block359Bytes, _wl_block359);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block360Bytes, _wl_block360);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block361Bytes, _wl_block361);
            out.print( String.valueOf(addDisplayStyle));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(select_status));
            _bw.write(_wl_block362Bytes, _wl_block362);
            out.print( String.valueOf(addDisplayStyle));
            _bw.write(_wl_block363Bytes, _wl_block363);
            out.print( String.valueOf(rangeUOM));
            _bw.write(_wl_block364Bytes, _wl_block364);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block365Bytes, _wl_block365);
            out.print( String.valueOf(addDisplayStyle));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(select_status));
            _bw.write(_wl_block362Bytes, _wl_block362);
            out.print( String.valueOf(addDisplayStyle));
            _bw.write(_wl_block363Bytes, _wl_block363);
            out.print( String.valueOf(AdUOM));
            _bw.write(_wl_block366Bytes, _wl_block366);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(AdUOM));
            _bw.write(_wl_block367Bytes, _wl_block367);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block368Bytes, _wl_block368);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(rangeUOM));
            _bw.write(_wl_block37Bytes, _wl_block37);

					for(int sl=0;sl<sliding_scale_details.size();sl+=7){
						sl_srl_no=(String)sliding_scale_details.get(sl+1);
						sl_rg_fro=(String)sliding_scale_details.get(sl+2);
						sl_rg_to=(String)sliding_scale_details.get(sl+3);
						sl_adm_qty=(String)sliding_scale_details.get(sl+4);

            _bw.write(_wl_block369Bytes, _wl_block369);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block370Bytes, _wl_block370);
            out.print( String.valueOf(sl_srl_no));
            _bw.write(_wl_block371Bytes, _wl_block371);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block370Bytes, _wl_block370);
            out.print( String.valueOf(sl_srl_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(sl_rg_fro));
            _bw.write(_wl_block372Bytes, _wl_block372);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block370Bytes, _wl_block370);
            out.print( String.valueOf(sl_srl_no));
            _bw.write(_wl_block373Bytes, _wl_block373);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block370Bytes, _wl_block370);
            out.print( String.valueOf(sl_srl_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(sl_rg_to));
            _bw.write(_wl_block374Bytes, _wl_block374);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block370Bytes, _wl_block370);
            out.print( String.valueOf(sl_srl_no));
            _bw.write(_wl_block375Bytes, _wl_block375);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block370Bytes, _wl_block370);
            out.print( String.valueOf(sl_srl_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(sl_adm_qty));
            _bw.write(_wl_block37Bytes, _wl_block37);

					}

            _bw.write(_wl_block376Bytes, _wl_block376);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block377Bytes, _wl_block377);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(sl_srl_no));
            _bw.write(_wl_block378Bytes, _wl_block378);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block259Bytes, _wl_block259);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block379Bytes, _wl_block379);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block380Bytes, _wl_block380);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block381Bytes, _wl_block381);

				} // end if sliding scale applicable
				else{
					if(dosage==null || dosage.equals("")) //ML-MMOH-SCF-1439 - start
						dosage = "0";
					String split_dose_yn = "N";
					if(splitDoseYN!=null && splitDoseYN.size()>0)
						split_dose_yn = (String)splitDoseYN.get(order_id+order_line_num);

					if(split_dose_yn ==null || split_dose_yn.equals(""))
						split_dose_yn="N";

					if(!split_dose_yn.equals("Y") && !freq_nature.equals("P") ){ //!freq_nature.equals("P") added for SKR-SCF-1534
					if(Float.parseFloat(qty)!=Float.parseFloat(dosage))
						qty = dosage;

					}//ML-MMOH-SCF-1439 - end
					if(split_dose_yn.equals("Y")){ //ML-MMOH-SCF-1674
						qty = bean.getSplitDosage(order_id,order_line_num,sch_date_time.split(" ")[1]);
					}
					if(freq_nature.equals("P")){													
						if(!dosage_seq_no.equals("2")){ //dosage sequence number will start from 2 only, for PRN orders
							if(allow_mar_alternate_drug_yn.equals("Y") && Auto_Admin.equals("Y") && alt_drug.equals("Y") && arrAltDrugs.size()>0){ //added for CRF-399.1
								if(dosage.equals(""))
									dosage=sch_strength_value_prn;

							}
							else{
								dosage=sch_strength_value_prn;
							}
							dosage_uom_code=sch_strength_uom_prn;
							dosage_uom_desc=dosage_uom_desc;// changed from sch_strength_uom_desc_prn to dosage_uom_desc for incident No:32773
						}	
						
						if(dosage_type.equals("S")){
							strength_per_value_pres_uom = bean.getStrengthPerValuePresUOM(drug_code);
							non_iv_admin_quaty=new Float(((Float.parseFloat(dosage)/Float.parseFloat(strength_value_prn))*Float.parseFloat(strength_per_value_pres_uom))/Float.parseFloat(content_in_pres_base_uom))+"";	//ceil removed and *strength_per_value_pres_uom added for IN24768 --19/11/2010-- priya
							if(Float.parseFloat(non_iv_admin_quaty)>Float.parseFloat(qty)){
								non_iv_admin_quaty=qty; //added for SRR20056-SCF-7400
							}	// added for SKR-SCF-304
							dosage = pres_dosage;
						}
						else{
							non_iv_admin_quaty=new Float(Float.parseFloat(dosage)/Float.parseFloat(content_in_pres_base_uom))+"";			
							if(Float.parseFloat(non_iv_admin_quaty)>Float.parseFloat(qty)){
								non_iv_admin_quaty=qty;
							} // added for SKR-SCF-304
							//dosage = pres_dosage;
						}
						if(Float.parseFloat(dosage) < 1.0){
							dosage = Float.parseFloat(dosage)+"";
						} //BRU-CRF-399.1 - start
						if(!disp_drug_code.equals(drug_code) && !iv_prep_yn.equals("6") && !iv_prep_yn.equals("0") && !iv_prep_yn.equals("8") && !alt_multi_drug_flag && !iv_prep_yn.equals("7") && !alt_flag ){
							String alt_dos_detail= bean.getAltDosageDetails(drug_code,disp_drug_code,order_id,order_line_num);
							if(alt_dos_detail.indexOf("~")!=-1){
							if(!split_dose_yn.equals("Y")){  //added for ML-MMOH-SCF-1757 & { added for ML-MMOh-SCF-1757
							dosage = alt_dos_detail.split("~")[0];
							uom_code = alt_dos_detail.split("~")[1];
							dosage_uom_desc = alt_dos_detail.split("~")[2];
							disp_with_alt=true;
							pres_dosage = dosage;
							pres_unit   = dosage_uom_desc;
							admin_uom_desc = dosage_uom_desc ;
							disp_schedule_uom_desc = dosage_uom_desc;
							}
							}
						}//BRU-CRF-399.1 - end

            _bw.write(_wl_block382Bytes, _wl_block382);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block383Bytes, _wl_block383);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(strength_value_prn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(dosage_type));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(content_in_pres_base_uom));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(strength_per_value_pres_uom));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(disp_with_alt));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(freq_nature));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(dosage));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(addDisplayStyle));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(select_status));
            _bw.write(_wl_block384Bytes, _wl_block384);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block385Bytes, _wl_block385);
            out.print( String.valueOf(addDisplayStyle));
            _bw.write(_wl_block363Bytes, _wl_block363);
            out.print( String.valueOf(dosage_uom_desc));
            _bw.write(_wl_block386Bytes, _wl_block386);

						if(qty!=null && !qty.equals("") && freq_nature.equals("P"))
							qty =Float.toString( Float.parseFloat(qty)*Float.parseFloat(content_in_pres_base_uom));
						int len= qty.length();
						if( len > 0 ){
							String temp = qty;
							int point= temp.indexOf(".")+1;
							if(temp.charAt(point)=='0')
								qty = qty.substring(0,point-1);
							else{//added for SKR-SCF-1429 - start
								if(Float.parseFloat(qty)>1){ 
								if(temp.charAt(point)=='6' || temp.charAt(point)=='7' || temp.charAt(point)=='8' || temp.charAt(point)=='9'){
								 qty = Math.ceil(Float.parseFloat(qty))+"";
								}
								}
							} //added for SKR-SCF-1429 - end
						}
						if(dosage_type.equals("S")){ //if Condition is added by sureshkumar T for the IncidentNo :  SRR20056-SCF-7039 [inc : 26763] upto 1494

            _bw.write(_wl_block387Bytes, _wl_block387);
            out.print( String.valueOf(addDisplayStyle));
            _bw.write(_wl_block388Bytes, _wl_block388);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block389Bytes, _wl_block389);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            out.print( String.valueOf(qty));
            _bw.write(_wl_block390Bytes, _wl_block390);
            out.print( String.valueOf(pres_base_uom));
            _bw.write(_wl_block391Bytes, _wl_block391);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block392Bytes, _wl_block392);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(non_iv_admin_quaty));
            _bw.write(_wl_block393Bytes, _wl_block393);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(dosage_uom_code));
            _bw.write(_wl_block394Bytes, _wl_block394);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block395Bytes, _wl_block395);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(dosage_uom_code));
            _bw.write(_wl_block396Bytes, _wl_block396);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(dosage));
            _bw.write(_wl_block397Bytes, _wl_block397);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block259Bytes, _wl_block259);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block398Bytes, _wl_block398);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block380Bytes, _wl_block380);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(non_iv_admin_quaty));
            _bw.write(_wl_block399Bytes, _wl_block399);

						}
						else{

            _bw.write(_wl_block400Bytes, _wl_block400);
            out.print( String.valueOf(addDisplayStyle));
            _bw.write(_wl_block388Bytes, _wl_block388);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block363Bytes, _wl_block363);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            out.print( String.valueOf(qty));
            _bw.write(_wl_block390Bytes, _wl_block390);
            out.print( String.valueOf(dosage_uom_desc));
            _bw.write(_wl_block391Bytes, _wl_block391);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block392Bytes, _wl_block392);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(non_iv_admin_quaty));
            _bw.write(_wl_block393Bytes, _wl_block393);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(dosage_uom_code));
            _bw.write(_wl_block394Bytes, _wl_block394);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block395Bytes, _wl_block395);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(dosage_uom_code));
            _bw.write(_wl_block396Bytes, _wl_block396);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(dosage));
            _bw.write(_wl_block397Bytes, _wl_block397);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block259Bytes, _wl_block259);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block398Bytes, _wl_block398);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block380Bytes, _wl_block380);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(non_iv_admin_quaty));
            _bw.write(_wl_block401Bytes, _wl_block401);
										
						}	
					} // end  if(freq_nature.equals("P"))
					else{ 						
						if(dosage.equals(""))
							dosage = pres_dosage;
						if(!iv_prep_yn.equals("0") && !iv_prep_yn.equals("2") && !iv_prep_yn.equals("4") && !iv_prep_yn.equals("6") && !iv_prep_yn.equals("8")){  // added for regration issue
						if(dosage_type.equals("S")){//added for GHL-CRF-0458.1 -start
							strength_per_value_pres_uom = bean.getStrengthPerValuePresUOM(drug_code);
							non_iv_admin_quaty=new Float(((Float.parseFloat(dosage)/Float.parseFloat(strength_value_prn))*Float.parseFloat(strength_per_value_pres_uom))/Float.parseFloat(content_in_pres_base_uom))+"";	
							if(Float.parseFloat(non_iv_admin_quaty)>Float.parseFloat(qty)){
								non_iv_admin_quaty=qty; 
							}	
							
						}
						else{
							non_iv_admin_quaty=new Float(Float.parseFloat(dosage)/Float.parseFloat(content_in_pres_base_uom))+"";			
							if(Float.parseFloat(non_iv_admin_quaty)>Float.parseFloat(qty)){
								non_iv_admin_quaty=qty;
							} 
						
						}
						}
//added for GHL-CRF-0458.1 -end
						if(Float.parseFloat(qty) < 1.0){
									//qty = dfTest.format(Float.parseFloat(qty)); commeted for 	ML-MMOH-SCF-1529						
							if(qty.indexOf(".")!=-1){ //if condtion added for ML-MMOH-SCF-1529
								String f_qty = qty.substring(qty.indexOf("."),qty.length());
								if(f_qty.length()>8)
									qty = dfTest.format(Float.parseFloat(qty));
								   
								 qty =Float.parseFloat(qty)+"";
							}
							
						}//BRU-CRF-399.1 - start				
						if(!disp_drug_code.equals(drug_code) && !iv_prep_yn.equals("6") && !iv_prep_yn.equals("0") && !iv_prep_yn.equals("8") && !alt_multi_drug_flag && !iv_prep_yn.equals("7") && !alt_flag){
							String alt_dos_detail1= bean.getAltDosageDetails(drug_code,disp_drug_code,order_id,order_line_num);
							if(alt_dos_detail1.indexOf("~")!=-1){

							if(!split_dose_yn.equals("Y")){  //if added for ML-MMOH-SCF-1757 & { added for ML-MMOh-SCF-1757
							qty = alt_dos_detail1.split("~")[0];
							uom_code = alt_dos_detail1.split("~")[1];
							short_desc = alt_dos_detail1.split("~")[2];
							pres_dosage = qty;
							pres_unit   = short_desc;
							admin_uom_desc = short_desc ;}
							}
				System.err.println("MedicationAdministrationFTDrugDtls.jsp==alt_dos_detail=====1622=====>"+alt_dos_detail1);
						}//BRU-CRF-399.1 - end


            _bw.write(_wl_block402Bytes, _wl_block402);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block403Bytes, _wl_block403);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(freq_nature));
            _bw.write(_wl_block404Bytes, _wl_block404);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(addDisplayStyle));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(select_status));
            _bw.write(_wl_block384Bytes, _wl_block384);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block405Bytes, _wl_block405);
            out.print( String.valueOf(addDisplayStyle));
            _bw.write(_wl_block363Bytes, _wl_block363);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block406Bytes, _wl_block406);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(uom_code));
            _bw.write(_wl_block407Bytes, _wl_block407);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block408Bytes, _wl_block408);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block259Bytes, _wl_block259);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block409Bytes, _wl_block409);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block380Bytes, _wl_block380);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(non_iv_admin_quaty));
            _bw.write(_wl_block401Bytes, _wl_block401);

					}								
				}	// end else of end if sliding scale applicable						

            _bw.write(_wl_block410Bytes, _wl_block410);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block411Bytes, _wl_block411);
            out.print( String.valueOf(fntColor));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(backGrndColor));
            _bw.write(_wl_block412Bytes, _wl_block412);
            out.print( String.valueOf(route_desc));
            _bw.write(_wl_block413Bytes, _wl_block413);
 
					fntColor  =   "#OOOOOO"; // Code Changed for RUT-CRF-0034 Route Color
	                backGrndColor =   "#FFFFFF";
					if(freq_nature.equals("P")){

            _bw.write(_wl_block283Bytes, _wl_block283);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block414Bytes, _wl_block414);

					}
					else{
						if(mfr_yn.equals("Y")){//ML-MMOH-CRF-1014- start
							MfrDetails=bean.getStatusOfMAR(order_id,"");

							if(MfrDetails.size()>0){
								statusString=(String)MfrDetails.get(0);
								mfrCompletedStatus=new Boolean((String)MfrDetails.get(1)).booleanValue();														
							}
							if(!mfrCompletedStatus ){// if added for ml-mmoh-crf-1014
								select_status="disabled";
							}
							
            _bw.write(_wl_block415Bytes, _wl_block415);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block177Bytes, _wl_block177);
if(order_line_num.equals("1")){
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_desc,"UTF-8")));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(Store_locn_code));
            _bw.write(_wl_block161Bytes, _wl_block161);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(statusString));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(mfrRemarks));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block165Bytes, _wl_block165);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block166Bytes, _wl_block166);
}else{
            _bw.write(_wl_block167Bytes, _wl_block167);
}
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(mfrRemarks));
            _bw.write(_wl_block37Bytes, _wl_block37);
						}else{//ML-MMOH-CRF-1014- end

            _bw.write(_wl_block283Bytes, _wl_block283);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block416Bytes, _wl_block416);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block413Bytes, _wl_block413);

					}
					}
					
					//added for SKR-SCF-1290
					String Sch_AdminBackLogTime = "";
					if(!locale.equals("en")){
						 Sch_AdminBackLogTime=bean.getAdminBackLogTime(sch_date_time_in_en);
						Sch_AdminBackLogTime = com.ehis.util.DateUtils.convertDate(Sch_AdminBackLogTime, "DMYHM","en",locale);
					}else{
						 Sch_AdminBackLogTime=bean.getAdminBackLogTime(sch_date_time);// added for TTM-SCF-0171-907901	
					}
	 				 

            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block417Bytes, _wl_block417);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block418Bytes, _wl_block418);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block419Bytes, _wl_block419);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(defaultDate.equals("")?current_date_time:defaultDate));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(select_status));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(Sch_AdminBackLogTime));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(current_date_time));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block420Bytes, _wl_block420);
            out.print( String.valueOf(addDisplayStyle));
            _bw.write(_wl_block421Bytes, _wl_block421);
							
					 //patient_class_ord = bean.getOrderPatientClass(order_id);//GHL-CRF-0458 commeted for NMC-JD-CRF-0186 [46294]
					verification_status	=	bean.getVerificationStatus(patient_class_ord,facility_id,Store_locn_code,verification_req_yn,WardAckMarRequiredYn);//added for MMS-KH-SCF-0056
					System.out.println("verification_status"+verification_status);		
				if(patient_class_ord==null)
					patient_class_ord = "";
				if(!patient_brgt_medn.equals("Y")){										
					if(!(sliding_scale_applicable.equals("Y")&& batch_ids.size()==0)){		
						if(iv_prep_yn.equals("6") ||iv_prep_yn.equals("0")||iv_prep_yn.equals("8")){

            _bw.write(_wl_block422Bytes, _wl_block422);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block423Bytes, _wl_block423);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block424Bytes, _wl_block424);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(patient_brgt_medn));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(medn_admn_dtl_reqd_yn));
            _bw.write(_wl_block425Bytes, _wl_block425);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block426Bytes, _wl_block426);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block427Bytes, _wl_block427);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block428Bytes, _wl_block428);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block429Bytes, _wl_block429);
            out.print( String.valueOf((String)work_sheet_batch_det1.get(1)));
            _bw.write(_wl_block430Bytes, _wl_block430);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block431Bytes, _wl_block431);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf((String)work_sheet_batch_det1.get(1)));
            _bw.write(_wl_block432Bytes, _wl_block432);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block433Bytes, _wl_block433);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf((String)work_sheet_batch_det1.get(2)));
            _bw.write(_wl_block434Bytes, _wl_block434);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block435Bytes, _wl_block435);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block436Bytes, _wl_block436);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block437Bytes, _wl_block437);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block438Bytes, _wl_block438);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block439Bytes, _wl_block439);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block440Bytes, _wl_block440);
					
						}
						else if(batch_ids.size()==0){
								
							if(Storelocn_code.equals(""))
								Storelocn_code=Store_locn_code;
							auto_Admin_dis="";									
							if(Auto_Admin.equals("N"))
								auto_Admin_dis="disabled";
							else 
								auto_Admin_dis="";
							bat_id_lookbutton_enabled="Y";
							if(auto_Admin_dis.equals("disabled")||select_status.equals("disabled")){
								bat_id_lookbutton_enabled="N";
							}
							if(iv_prep_yn.trim().length()!=0 || !allowMAR_share_drug.equalsIgnoreCase("Y")) 
								shared_drug_disp = "display:none";//Added for HSA-CRF-0090[IN041241] end
							else
								shared_drug_disp = "";
							

            _bw.write(_wl_block415Bytes, _wl_block415);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block441Bytes, _wl_block441);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block424Bytes, _wl_block424);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(patient_brgt_medn));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(medn_admn_dtl_reqd_yn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(bat_id_lookbutton_enabled));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block442Bytes, _wl_block442);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block443Bytes, _wl_block443);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block444Bytes, _wl_block444);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block445Bytes, _wl_block445);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block446Bytes, _wl_block446);
            out.print( String.valueOf(shared_drug_disp));
            _bw.write(_wl_block447Bytes, _wl_block447);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block428Bytes, _wl_block428);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf(defaultBatch.equals("")?batch_id:defaultBatch));
            _bw.write(_wl_block448Bytes, _wl_block448);
            out.print( String.valueOf(addDisplayStyle));
            _bw.write(_wl_block449Bytes, _wl_block449);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block450Bytes, _wl_block450);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(select_status));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(auto_Admin_dis));
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block451Bytes, _wl_block451);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block452Bytes, _wl_block452);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(Storelocn_code));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block453Bytes, _wl_block453);
            out.print( String.valueOf(addDisplayStyle));
            _bw.write(_wl_block454Bytes, _wl_block454);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block455Bytes, _wl_block455);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block456Bytes, _wl_block456);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block431Bytes, _wl_block431);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(defaultBatch.equals("")?batch_id:defaultBatch));
            _bw.write(_wl_block432Bytes, _wl_block432);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block433Bytes, _wl_block433);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(defaultExpiryDate.equals("")?expiry_date:defaultExpiryDate));
            _bw.write(_wl_block434Bytes, _wl_block434);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block435Bytes, _wl_block435);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(defaultTradeId.equals("")?trade_id:defaultTradeId));
            _bw.write(_wl_block457Bytes, _wl_block457);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block437Bytes, _wl_block437);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block458Bytes, _wl_block458);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block439Bytes, _wl_block439);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block459Bytes, _wl_block459);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block460Bytes, _wl_block460);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block461Bytes, _wl_block461);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block462Bytes, _wl_block462);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block463Bytes, _wl_block463);
			if(verification_status.equals("Y") && (iv_prep_yn.equals("") || iv_prep_yn== null)  && (order_status.equals("OS") || order_status.equals("RG")))
{//added for mms-kh-scf0056
	select_status_1="disabled";
}
if(WardAckMarRequiredYn.equalsIgnoreCase("Y") && patient_class_ord.equals("IP") && !(iv_prep_yn.equals("0") || iv_prep_yn.equals("2") || iv_prep_yn.equals("4")|| iv_prep_yn.equals("6") || iv_prep_yn.equals("8"))) // isSiteSpecMARPrint chnaged to WardAckMarRequiredYn.equalsIgnoreCase("Y") for MMS-KH-CRF-0014 [IN:067953]
									select_status_1="disabled";

						}
						else if(batch_ids.size()==9){//changed 4 to 6 for CRF-413.8 and 6 to 7 for GHL-CRF-0458 and 7 to 9 for GHL-CRF-0482
							expiry_date = (String)batch_ids.get(1);
							trade_id    = (String)batch_ids.get(2);
							tradename   = (String)batch_ids.get(3);
							//added for GHL-CRF-0458 - start
							ward_ack_yn = (String)batch_ids.get(6)==null?"":(String)batch_ids.get(6);
							
							if(WardAckMarRequiredYn.equalsIgnoreCase("Y") && !ward_ack_yn.equals("A") && patient_class_ord.equals("IP") && !(iv_prep_yn.equals("0") || iv_prep_yn.equals("2") || iv_prep_yn.equals("4")|| iv_prep_yn.equals("6") || iv_prep_yn.equals("8"))) // isSiteSpecMARPrint chnaged to WardAckMarRequiredYn.equalsIgnoreCase("Y") for MMS-KH-CRF-0014 [IN:067953]
								select_status_1="disabled";
							if(marForDisPatNotReqYN && dischargedYN){ // Added for KH-SCF-0010 - Start
								select_status_1 = "disabled";
							} // Added for KH-SCF-0010 - End
							//added for GHL-CRF-0458 - end
							select_status="disabled";

            _bw.write(_wl_block464Bytes, _wl_block464);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block465Bytes, _wl_block465);
							totQty =(ArrayList)bean.getTotQty(patient_id,drug_code,admin_from_date,admin_to_date,order_id,order_line_num);
							for(int j=0;j<totQty.size();j=j+4){
								returned_qty = (Float)totQty.get(j+2);
								tot_administered_qty=  (Float)totQty.get(j+3);
							} 
							WardReturnQty =(ArrayList)bean.getWardRetrunQty(patient_id,order_id,performingDeptLocCode,facility_id);
							for(int k=0;k<WardReturnQty.size();k=k+2){
                              disp_qty =(Float)WardReturnQty.get(k);
							  ward_return_qty =(Float)WardReturnQty.get(k+1);
							}
							ret_qty=disp_qty-(returned_qty+ward_return_qty+tot_administered_qty);
							if(ret_qty<=0){// adding end for 33194

            _bw.write(_wl_block466Bytes, _wl_block466);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block467Bytes, _wl_block467);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block424Bytes, _wl_block424);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(patient_brgt_medn));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(medn_admn_dtl_reqd_yn));
            _bw.write(_wl_block468Bytes, _wl_block468);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block469Bytes, _wl_block469);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block470Bytes, _wl_block470);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block444Bytes, _wl_block444);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block471Bytes, _wl_block471);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block428Bytes, _wl_block428);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf((String)batch_ids.get(0)));
            _bw.write(_wl_block472Bytes, _wl_block472);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block450Bytes, _wl_block450);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block473Bytes, _wl_block473);
            out.print( String.valueOf(select_status));
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block453Bytes, _wl_block453);
            out.print( String.valueOf(addDisplayStyle));
            _bw.write(_wl_block474Bytes, _wl_block474);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block431Bytes, _wl_block431);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf((String)batch_ids.get(0)));
            _bw.write(_wl_block475Bytes, _wl_block475);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block433Bytes, _wl_block433);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(defaultExpiryDate.equals("")?expiry_date:defaultExpiryDate));
            _bw.write(_wl_block476Bytes, _wl_block476);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block435Bytes, _wl_block435);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(defaultTradeId.equals("")?trade_id:defaultTradeId));
            _bw.write(_wl_block477Bytes, _wl_block477);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block478Bytes, _wl_block478);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(batch_ids.size()));
            _bw.write(_wl_block479Bytes, _wl_block479);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block480Bytes, _wl_block480);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf((String)batch_ids.get(5)));
            _bw.write(_wl_block481Bytes, _wl_block481);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block437Bytes, _wl_block437);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf((String)batch_ids.get(7)));
            _bw.write(_wl_block438Bytes, _wl_block438);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block439Bytes, _wl_block439);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf((String)batch_ids.get(8)));
            _bw.write(_wl_block482Bytes, _wl_block482);
 
							}
							else{
								expiry_date="";
								select_status="";

            _bw.write(_wl_block466Bytes, _wl_block466);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block483Bytes, _wl_block483);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block424Bytes, _wl_block424);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(patient_brgt_medn));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(medn_admn_dtl_reqd_yn));
            _bw.write(_wl_block468Bytes, _wl_block468);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block469Bytes, _wl_block469);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block484Bytes, _wl_block484);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block428Bytes, _wl_block428);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block485Bytes, _wl_block485);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block450Bytes, _wl_block450);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block473Bytes, _wl_block473);
            out.print( String.valueOf(select_status));
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block453Bytes, _wl_block453);
            out.print( String.valueOf(addDisplayStyle));
            _bw.write(_wl_block474Bytes, _wl_block474);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block431Bytes, _wl_block431);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf((String)batch_ids.get(0)));
            _bw.write(_wl_block475Bytes, _wl_block475);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block433Bytes, _wl_block433);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(defaultExpiryDate.equals("")?expiry_date:defaultExpiryDate));
            _bw.write(_wl_block476Bytes, _wl_block476);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block435Bytes, _wl_block435);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(defaultTradeId.equals("")?trade_id:defaultTradeId));
            _bw.write(_wl_block477Bytes, _wl_block477);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block478Bytes, _wl_block478);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(batch_ids.size()));
            _bw.write(_wl_block479Bytes, _wl_block479);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block480Bytes, _wl_block480);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf((String)batch_ids.get(5)));
            _bw.write(_wl_block486Bytes, _wl_block486);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block437Bytes, _wl_block437);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf((String)batch_ids.get(7)));
            _bw.write(_wl_block487Bytes, _wl_block487);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block439Bytes, _wl_block439);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf((String)batch_ids.get(8)));
            _bw.write(_wl_block482Bytes, _wl_block482);

							}
						}
						else{//added below condition for incident NO:33194

            _bw.write(_wl_block464Bytes, _wl_block464);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block488Bytes, _wl_block488);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block489Bytes, _wl_block489);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block424Bytes, _wl_block424);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(patient_brgt_medn));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(medn_admn_dtl_reqd_yn));
            _bw.write(_wl_block425Bytes, _wl_block425);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block490Bytes, _wl_block490);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block470Bytes, _wl_block470);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block444Bytes, _wl_block444);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block491Bytes, _wl_block491);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block428Bytes, _wl_block428);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(addDisplayStyle));
            _bw.write(_wl_block492Bytes, _wl_block492);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block493Bytes, _wl_block493);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block269Bytes, _wl_block269);
            out.print( String.valueOf(disp_drug_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(freq_nature));
            _bw.write(_wl_block494Bytes, _wl_block494);
            out.print( String.valueOf(disp_drugs));
            _bw.write(_wl_block495Bytes, _wl_block495);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block496Bytes, _wl_block496);

							int mm =1;//CRF-413.8
							System.err.println("MedicationAdministrationFTDrugDtls.jsp====batch_ids.size()============1666==>"+batch_ids.size());
							for(int kk=0;kk<batch_ids.size();kk=kk+9){//changed 4 to 6 for CRF-413.8 and 6 to 7 for GHL-CRF-0458 and 7 to 9 for GHL-CRF-0482
							System.err.println("defaultBatch===>"+defaultBatch+"==(String)batch_ids.get(kk)===>"+(String)batch_ids.get(kk));
								if (defaultBatch.equals((String)batch_ids.get(kk))){

            _bw.write(_wl_block497Bytes, _wl_block497);
            out.print( String.valueOf((String)batch_ids.get(kk)));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf((String)batch_ids.get(kk)));
            _bw.write(_wl_block498Bytes, _wl_block498);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block431Bytes, _wl_block431);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf((String)batch_ids.get(kk)));
            _bw.write(_wl_block499Bytes, _wl_block499);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block433Bytes, _wl_block433);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(defaultExpiryDate.equals("")?expiry_date:defaultExpiryDate));
            _bw.write(_wl_block500Bytes, _wl_block500);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block435Bytes, _wl_block435);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(defaultTradeId.equals("")?trade_id:defaultTradeId));
            _bw.write(_wl_block37Bytes, _wl_block37);

								}
								else{

            _bw.write(_wl_block501Bytes, _wl_block501);
            out.print( String.valueOf((String)batch_ids.get(kk)));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf((String)batch_ids.get(kk)));
            _bw.write(_wl_block502Bytes, _wl_block502);

								}
						

            _bw.write(_wl_block503Bytes, _wl_block503);
							}

            _bw.write(_wl_block504Bytes, _wl_block504);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block478Bytes, _wl_block478);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(batch_ids.size()));
            _bw.write(_wl_block505Bytes, _wl_block505);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block437Bytes, _wl_block437);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block506Bytes, _wl_block506);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block439Bytes, _wl_block439);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block440Bytes, _wl_block440);

						for(int kk=0;kk<batch_ids.size();kk=kk+9){ //6 to 7 for GHL-CRF-0458 and 7 to 9 for GHL-CRF-0482
							

            _bw.write(_wl_block507Bytes, _wl_block507);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block370Bytes, _wl_block370);
            out.print( String.valueOf(mm));
            _bw.write(_wl_block480Bytes, _wl_block480);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block370Bytes, _wl_block370);
            out.print( String.valueOf(mm));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf((String)batch_ids.get(kk+5)));
            _bw.write(_wl_block508Bytes, _wl_block508);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block370Bytes, _wl_block370);
            out.print( String.valueOf(mm));
            _bw.write(_wl_block509Bytes, _wl_block509);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block370Bytes, _wl_block370);
            out.print( String.valueOf(mm));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf((String)batch_ids.get(kk+4)));
            _bw.write(_wl_block510Bytes, _wl_block510);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block370Bytes, _wl_block370);
            out.print( String.valueOf(mm));
            _bw.write(_wl_block511Bytes, _wl_block511);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block370Bytes, _wl_block370);
            out.print( String.valueOf(mm));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf((String)batch_ids.get(kk)));
            _bw.write(_wl_block512Bytes, _wl_block512);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block370Bytes, _wl_block370);
            out.print( String.valueOf(mm));
            _bw.write(_wl_block437Bytes, _wl_block437);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block370Bytes, _wl_block370);
            out.print( String.valueOf(mm));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf((String)batch_ids.get(kk+7)));
            _bw.write(_wl_block513Bytes, _wl_block513);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block370Bytes, _wl_block370);
            out.print( String.valueOf(mm));
            _bw.write(_wl_block439Bytes, _wl_block439);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block370Bytes, _wl_block370);
            out.print( String.valueOf(mm));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf((String)batch_ids.get(kk+8)));
            _bw.write(_wl_block482Bytes, _wl_block482);
						mm++;//CRF-413.8

					

						}
						//added for GHL-CRF-0458 - start
						for(int kk=0;kk<batch_ids.size();kk=kk+9){ // 7 to 9 for GHL-CRF-0482
							ward_ack_yn = (String)batch_ids.get(kk+6)==null?"":(String)batch_ids.get(kk+6);
							if(WardAckMarRequiredYn.equalsIgnoreCase("Y") && ward_ack_yn.equals("A") && !(iv_prep_yn.equals("0") || iv_prep_yn.equals("2") || iv_prep_yn.equals("4")|| iv_prep_yn.equals("6") || iv_prep_yn.equals("8"))){ // // isSiteSpecMARPrint chnaged to WardAckMarRequiredYn.equalsIgnoreCase("Y") for MMS-KH-CRF-0014 [IN:067953]
								select_status_1="";
								ack_flag = true;
								break;
							}
							//added for GHL-CRF-0458 - end
						}
						//commented for MOHE-SCF-0127
						
						if(!ack_flag && WardAckMarRequiredYn.equalsIgnoreCase("Y") && patient_class_ord.equals("IP")) //&& patient_class_ord.equals("IP") added for GHL-CRF-0482 // // isSiteSpecMARPrint chnaged to WardAckMarRequiredYn.equalsIgnoreCase("Y") for MMS-KH-CRF-0014 [IN:067953]
							select_status_1="disabled";

						}

						//added for MMS-KH-CRF-0039 - start
						if(WardAckMarRequiredYn.equalsIgnoreCase("Y") && (iv_prep_yn.equals("0") || iv_prep_yn.equals("2") || iv_prep_yn.equals("4")|| iv_prep_yn.equals("6"))){
						 ward_ack_yn = bean.getAcknowlegeYN(order_id,order_line_num,iv_prep_yn);
					
						 if(ward_ack_yn==null)
							 ward_ack_yn="";
						
						 if(!ward_ack_yn.equals("A")){
						    select_status="disabled";
							select_status_1="disabled";
						 }
						}

						//added for GHL-CRF-0509 start
						if(issitespec_verbal_order_yn && placed_from_verbal_order.equals("Y")){
							select_status_1="";
						} //added for GHL-CRF-0509 end
						if(marForDisPatNotReqYN && dischargedYN){ // Added for KH-SCF-0010 - Start
							select_status_1 = "disabled";
						} // Added for KH-SCF-0010 - End

            _bw.write(_wl_block514Bytes, _wl_block514);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block515Bytes, _wl_block515);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(placed_from_verbal_order));
            _bw.write(_wl_block516Bytes, _wl_block516);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block517Bytes, _wl_block517);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block518Bytes, _wl_block518);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block519Bytes, _wl_block519);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(defaultExpiryDate.equals("")?expiry_date:defaultExpiryDate));
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(addDisplayStyle));
            _bw.write(_wl_block520Bytes, _wl_block520);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block521Bytes, _wl_block521);

					} //end if(!(sliding_scale_applicable.equals("Y")&& batch_ids.size()==0))
					else{

            _bw.write(_wl_block522Bytes, _wl_block522);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block489Bytes, _wl_block489);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block424Bytes, _wl_block424);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(patient_brgt_medn));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(medn_admn_dtl_reqd_yn));
            _bw.write(_wl_block468Bytes, _wl_block468);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block523Bytes, _wl_block523);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block524Bytes, _wl_block524);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block428Bytes, _wl_block428);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block525Bytes, _wl_block525);
            out.print( String.valueOf(addDisplayStyle));
            _bw.write(_wl_block526Bytes, _wl_block526);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block450Bytes, _wl_block450);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block527Bytes, _wl_block527);
            out.print( String.valueOf(addDisplayStyle));
            _bw.write(_wl_block528Bytes, _wl_block528);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block529Bytes, _wl_block529);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block530Bytes, _wl_block530);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block521Bytes, _wl_block521);
					}
				}// end of if(!patient_brgt_medn.equals("Y"))
				else{								
	
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block441Bytes, _wl_block441);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block424Bytes, _wl_block424);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(patient_brgt_medn));
            _bw.write(_wl_block531Bytes, _wl_block531);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block532Bytes, _wl_block532);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block428Bytes, _wl_block428);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block525Bytes, _wl_block525);
            out.print( String.valueOf(addDisplayStyle));
            _bw.write(_wl_block533Bytes, _wl_block533);
            out.print( String.valueOf(addDisplayStyle));
            _bw.write(_wl_block534Bytes, _wl_block534);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block535Bytes, _wl_block535);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block536Bytes, _wl_block536);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block537Bytes, _wl_block537);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block538Bytes, _wl_block538);

				}

            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block539Bytes, _wl_block539);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(trade_id));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(defaultTradeId.equals("")?tradename:defaultTradeId));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(addDisplayStyle));
            _bw.write(_wl_block540Bytes, _wl_block540);

				if(!stat_style.equals("") && freq_nature.equals("O")){
					stat_title	=	"title='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.STATDose.label", "ph_labels")+"'";
				}
				else if(!stat_style.equals("") && freq_nature.equals("P")){
					stat_title	=	"title='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.PRNDose.label", "ph_labels")+"'";
				}
				else{
					stat_title	=	"";
				}
				if(patient_brgt_medn.equals("Y")){
					mand_display="style='display:inline'";	
				}

            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(stat_style));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(stat_title));
            _bw.write(_wl_block541Bytes, _wl_block541);

				if(!(iv_prep_yn.equals("9")&&!(order_line_num.equals("1")))){

            _bw.write(_wl_block542Bytes, _wl_block542);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block543Bytes, _wl_block543);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(medn_admn_dtl_reqd_yn));
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block264Bytes, _wl_block264);
            out.print( String.valueOf(select_status_1));
            _bw.write(_wl_block544Bytes, _wl_block544);
            out.print( String.valueOf(addDisplayStyle));
            _bw.write(_wl_block545Bytes, _wl_block545);
            out.print( String.valueOf(addedTaperSch));
            _bw.write(_wl_block546Bytes, _wl_block546);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(dtl_style));
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf(encode_drug_desc));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(drug_class));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(freq_code));
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(medn_admn_dtl_reqd_yn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block547Bytes, _wl_block547);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block548Bytes, _wl_block548);
            out.print( String.valueOf(addDisplayStyle));
            _bw.write(_wl_block177Bytes, _wl_block177);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block549Bytes, _wl_block549);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block545Bytes, _wl_block545);
            out.print( String.valueOf(mand_display));
            _bw.write(_wl_block550Bytes, _wl_block550);

				}
				else{ 	
					if(mand_display.equals("style='display:inline'")){

            _bw.write(_wl_block278Bytes, _wl_block278);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(medn_admn_dtl_reqd_yn));
            _bw.write(_wl_block279Bytes, _wl_block279);

					}
				}

            _bw.write(_wl_block551Bytes, _wl_block551);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block281Bytes, _wl_block281);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(mand_display));
            _bw.write(_wl_block552Bytes, _wl_block552);

				if(sliding_scale_applicable.equals("Y") && batch_ids.size()==0){	
					select_status_1="disabled";
				}
				String fieldname="non_iv_admin_qty_"+recCount;
				String short_desc1=short_desc;
				if(freq_nature.equals("P")){
					fieldname   = "non_iv_admin_qty1_"+recCount;
					short_desc1 = schedule_uom_desc; 
					pres_dosage = tempDosage;
				}
				admin_uom_desc= short_desc1.replaceAll(" ","%20");
				admin_uom_desc= java.net.URLEncoder.encode(admin_uom_desc,"UTF-8");
				admin_uom_desc= admin_uom_desc.replaceAll("%2520","%20");
				if(!disp_drug_code.equals(drug_code) && !iv_prep_yn.equals("6") && !iv_prep_yn.equals("0") && !iv_prep_yn.equals("8") && batch_ids.size()==9){ //BRU-CRF-399.1 and 7 to 9 for GHL-CRF-0482
					pres_dosage = dosage;
					admin_uom_desc = dosage_uom_desc ;
				}
				if(iv_prep_yn.equals("9")){	
					if(!order_line_num.equals("1")){
						select_status_1="disabled";

            _bw.write(_wl_block553Bytes, _wl_block553);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(patient_stock_display));
            _bw.write(_wl_block554Bytes, _wl_block554);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block555Bytes, _wl_block555);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(patient_stock_completed));
            _bw.write(_wl_block556Bytes, _wl_block556);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block557Bytes, _wl_block557);
            out.print( String.valueOf(patient_stock_checked));
            _bw.write(_wl_block544Bytes, _wl_block544);
            out.print( String.valueOf(patient_stock_check_display));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(patient_stock_disabled));
            _bw.write(_wl_block558Bytes, _wl_block558);
            out.print( String.valueOf(classValSelect));
            _bw.write(_wl_block284Bytes, _wl_block284);
            _bw.write(_wl_block559Bytes, _wl_block559);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block560Bytes, _wl_block560);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block288Bytes, _wl_block288);
            out.print( String.valueOf(billChecked));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(isEnabled));
            _bw.write(_wl_block561Bytes, _wl_block561);
            out.print( String.valueOf(fieldname));
            _bw.write(_wl_block562Bytes, _wl_block562);
            out.print( String.valueOf(pres_dosage));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(pres_unit));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(freq_nature));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(disp_schedule_uom_desc));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(admin_uom_desc));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(AdminBackLogTime));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(current_date_time));
            _bw.write(_wl_block290Bytes, _wl_block290);
            out.print( String.valueOf(defaultDate.equals("")?current_date_time:defaultDate));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block291Bytes, _wl_block291);
            out.print( String.valueOf(auth_reqd_script));
            _bw.write(_wl_block292Bytes, _wl_block292);

					}
					else{

            _bw.write(_wl_block283Bytes, _wl_block283);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(patient_stock_display));
            _bw.write(_wl_block554Bytes, _wl_block554);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block555Bytes, _wl_block555);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(patient_stock_completed));
            _bw.write(_wl_block556Bytes, _wl_block556);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block563Bytes, _wl_block563);
            out.print( String.valueOf(patient_stock_checked));
            _bw.write(_wl_block544Bytes, _wl_block544);
            out.print( String.valueOf(patient_stock_check_display));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(patient_stock_disabled));
            _bw.write(_wl_block564Bytes, _wl_block564);
            out.print( String.valueOf(classValSelect));
            _bw.write(_wl_block284Bytes, _wl_block284);
            _bw.write(_wl_block559Bytes, _wl_block559);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block560Bytes, _wl_block560);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block288Bytes, _wl_block288);
            out.print( String.valueOf(billChecked));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(isEnabled));
            _bw.write(_wl_block561Bytes, _wl_block561);
            out.print( String.valueOf(fieldname));
            _bw.write(_wl_block562Bytes, _wl_block562);
            out.print( String.valueOf(pres_dosage));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(pres_unit));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(freq_nature));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(disp_schedule_uom_desc));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(admin_uom_desc));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(AdminBackLogTime));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(current_date_time));
            _bw.write(_wl_block290Bytes, _wl_block290);
            out.print( String.valueOf(defaultDate.equals("")?current_date_time:defaultDate));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block298Bytes, _wl_block298);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(onco_direct_drug_count));
            _bw.write(_wl_block299Bytes, _wl_block299);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block291Bytes, _wl_block291);
            out.print( String.valueOf(auth_reqd_script));
            _bw.write(_wl_block300Bytes, _wl_block300);
					}
				}
				else{

            _bw.write(_wl_block301Bytes, _wl_block301);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(patient_stock_display));
            _bw.write(_wl_block565Bytes, _wl_block565);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block555Bytes, _wl_block555);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(patient_stock_completed));
            _bw.write(_wl_block556Bytes, _wl_block556);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block557Bytes, _wl_block557);
            out.print( String.valueOf(patient_stock_checked));
            _bw.write(_wl_block544Bytes, _wl_block544);
            out.print( String.valueOf(patient_stock_check_display));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(patient_stock_disabled));
            _bw.write(_wl_block566Bytes, _wl_block566);
if(patient_brgt_medn.equals("Y")){ 
            _bw.write(_wl_block559Bytes, _wl_block559);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block560Bytes, _wl_block560);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block288Bytes, _wl_block288);
            out.print( String.valueOf(checked));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(select_status_1));
            _bw.write(_wl_block544Bytes, _wl_block544);
            out.print( String.valueOf(addDisplayStyle));
            _bw.write(_wl_block567Bytes, _wl_block567);
            out.print( String.valueOf(fieldname));
            _bw.write(_wl_block562Bytes, _wl_block562);
            out.print( String.valueOf(pres_dosage));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(pres_unit));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(freq_nature));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(disp_schedule_uom_desc));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(admin_uom_desc));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(AdminBackLogTime));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(current_date_time));
            _bw.write(_wl_block290Bytes, _wl_block290);
            out.print( String.valueOf(defaultDate.equals("")?current_date_time:defaultDate));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block568Bytes, _wl_block568);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(disp_drug_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(isSiteSpecMARPrint));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(patient_class_ord));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(batch_ids.size()));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(patient_stock_yn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(patient_brgt_medn));
            _bw.write(_wl_block291Bytes, _wl_block291);
            out.print( String.valueOf(auth_reqd_script));
            _bw.write(_wl_block305Bytes, _wl_block305);
}else{ 
            _bw.write(_wl_block569Bytes, _wl_block569);
            out.print( String.valueOf(classValSelect));
            _bw.write(_wl_block570Bytes, _wl_block570);
            _bw.write(_wl_block571Bytes, _wl_block571);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block560Bytes, _wl_block560);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block288Bytes, _wl_block288);
            out.print( String.valueOf(billChecked));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(isEnabled));
            _bw.write(_wl_block561Bytes, _wl_block561);
            out.print( String.valueOf(fieldname));
            _bw.write(_wl_block562Bytes, _wl_block562);
            out.print( String.valueOf(pres_dosage));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(pres_unit));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(freq_nature));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(disp_schedule_uom_desc));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(admin_uom_desc));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(AdminBackLogTime));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(current_date_time));
            _bw.write(_wl_block290Bytes, _wl_block290);
            out.print( String.valueOf(defaultDate.equals("")?current_date_time:defaultDate));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block568Bytes, _wl_block568);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(disp_drug_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(isSiteSpecMARPrint));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(patient_class_ord));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(batch_ids.size()));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(patient_stock_yn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(patient_brgt_medn));
            _bw.write(_wl_block291Bytes, _wl_block291);
            out.print( String.valueOf(auth_reqd_script));
            _bw.write(_wl_block572Bytes, _wl_block572);
} 
            _bw.write(_wl_block1Bytes, _wl_block1);
				}

            _bw.write(_wl_block573Bytes, _wl_block573);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block574Bytes, _wl_block574);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block575Bytes, _wl_block575);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block576Bytes, _wl_block576);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(pres_dosage));
            _bw.write(_wl_block577Bytes, _wl_block577);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block578Bytes, _wl_block578);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(disp_schedule_uom_desc));
            _bw.write(_wl_block579Bytes, _wl_block579);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block580Bytes, _wl_block580);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block581Bytes, _wl_block581);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block582Bytes, _wl_block582);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block583Bytes, _wl_block583);
            out.print( String.valueOf(future_or_late_admin));
            _bw.write(_wl_block584Bytes, _wl_block584);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block585Bytes, _wl_block585);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block583Bytes, _wl_block583);
            out.print( String.valueOf(patient_brgt_medn));
            _bw.write(_wl_block586Bytes, _wl_block586);

				altRecCount=0;
				if(recCount==row_no && multi_drugs.size()>0){
					no_of_alt_drus_selected ++;
					if(iv_prep_yn.trim().length()!=0 || !allowMAR_share_drug.equalsIgnoreCase("Y")) 
						shared_drug_disp = "display:none";//Added for HSA-CRF-0090[IN041241] end
					else
						shared_drug_disp = "";
					for(int n=0; n<multi_drugs.size(); n+=5){ 
						altRecCount++;
						alt_drug_code			=	(String)multi_drugs.get(n);
						alt_drug_desc			=   (String)multi_drugs.get(n+1);
						alt_qty=(String)multi_drugs.get(n+3);
						alt_qty_uom =(String)multi_drugs.get(n+4);
						alt_batch_ids = bean.getAllBatchIDS(order_id,order_line_num,"N");
						alt_expiry_date = "";
						alt_trade_id	   = "";
						alt_trade_name  = "";

            _bw.write(_wl_block587Bytes, _wl_block587);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block588Bytes, _wl_block588);
            out.print( String.valueOf(alt_drug_desc));
            _bw.write(_wl_block589Bytes, _wl_block589);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block590Bytes, _wl_block590);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(alt_drug_code));
            _bw.write(_wl_block591Bytes, _wl_block591);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block592Bytes, _wl_block592);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block593Bytes, _wl_block593);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block594Bytes, _wl_block594);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block595Bytes, _wl_block595);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block596Bytes, _wl_block596);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block597Bytes, _wl_block597);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block598Bytes, _wl_block598);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block599Bytes, _wl_block599);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block600Bytes, _wl_block600);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block601Bytes, _wl_block601);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block602Bytes, _wl_block602);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block602Bytes, _wl_block602);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block602Bytes, _wl_block602);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block602Bytes, _wl_block602);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block603Bytes, _wl_block603);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block604Bytes, _wl_block604);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block605Bytes, _wl_block605);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block606Bytes, _wl_block606);
            out.print( String.valueOf(freq_nature));
            _bw.write(_wl_block404Bytes, _wl_block404);
            out.print( String.valueOf(alt_qty));
            _bw.write(_wl_block607Bytes, _wl_block607);
            out.print( String.valueOf(alt_qty_uom));
            _bw.write(_wl_block608Bytes, _wl_block608);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block609Bytes, _wl_block609);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(alt_qty));
            _bw.write(_wl_block610Bytes, _wl_block610);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block611Bytes, _wl_block611);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(alt_qty_uom));
            _bw.write(_wl_block612Bytes, _wl_block612);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block613Bytes, _wl_block613);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block614Bytes, _wl_block614);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block615Bytes, _wl_block615);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(end_date_time));
            _bw.write(_wl_block616Bytes, _wl_block616);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block617Bytes, _wl_block617);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block618Bytes, _wl_block618);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(fntColor));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(backGrndColor));
            _bw.write(_wl_block619Bytes, _wl_block619);
            out.print( String.valueOf(route_desc));
            _bw.write(_wl_block620Bytes, _wl_block620);

						   fntColor ="000000";      //Code Changed For RUT-CRF-0034 Route Color
						   backGrndColor="FFFFFF";					   
						
            _bw.write(_wl_block621Bytes, _wl_block621);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block622Bytes, _wl_block622);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block623Bytes, _wl_block623);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block624Bytes, _wl_block624);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block625Bytes, _wl_block625);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block626Bytes, _wl_block626);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block627Bytes, _wl_block627);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block628Bytes, _wl_block628);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(current_date_time));
            _bw.write(_wl_block629Bytes, _wl_block629);
            out.print( String.valueOf(AdminBackLogTime));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(current_date_time));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block630Bytes, _wl_block630);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block37Bytes, _wl_block37);

						if(alt_batch_ids.size()==0){

            _bw.write(_wl_block631Bytes, _wl_block631);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block632Bytes, _wl_block632);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block445Bytes, _wl_block445);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block446Bytes, _wl_block446);
            out.print( String.valueOf(shared_drug_disp));
            _bw.write(_wl_block633Bytes, _wl_block633);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block634Bytes, _wl_block634);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf(defaultBatch));
            _bw.write(_wl_block635Bytes, _wl_block635);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block636Bytes, _wl_block636);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block637Bytes, _wl_block637);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block638Bytes, _wl_block638);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block639Bytes, _wl_block639);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block640Bytes, _wl_block640);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block641Bytes, _wl_block641);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block642Bytes, _wl_block642);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block643Bytes, _wl_block643);

						}
						else if(alt_batch_ids.size()==9){ //changed 4 to 6 for CRF-413.8 and 6 to 7 for GHL-CRF-0458 and 7 to 9 for GHL-CRF-0482
							alt_expiry_date = (String)alt_batch_ids.get(1);
							alt_trade_id    = (String)alt_batch_ids.get(2);
							alt_trade_name  = (String)alt_batch_ids.get(3);

            _bw.write(_wl_block644Bytes, _wl_block644);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block632Bytes, _wl_block632);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block645Bytes, _wl_block645);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block634Bytes, _wl_block634);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block646Bytes, _wl_block646);
            out.print( String.valueOf((String)alt_batch_ids.get(0)));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf((String)alt_batch_ids.get(0)));
            _bw.write(_wl_block647Bytes, _wl_block647);

						}
						else{

            _bw.write(_wl_block648Bytes, _wl_block648);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block649Bytes, _wl_block649);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block650Bytes, _wl_block650);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block634Bytes, _wl_block634);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block651Bytes, _wl_block651);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block652Bytes, _wl_block652);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block269Bytes, _wl_block269);
            out.print( String.valueOf(disp_drug_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(freq_nature));
            _bw.write(_wl_block494Bytes, _wl_block494);
            out.print( String.valueOf(disp_drugs));
            _bw.write(_wl_block495Bytes, _wl_block495);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block496Bytes, _wl_block496);

							for(int kk=0;kk<alt_batch_ids.size();kk=kk+9){////changed 4 to 6 for CRF-413.8 and 6 to 7 for GHL-CRF-0458 and 7 to 9 for GHL-CRF-0482
								if (defaultBatch.equals((String)alt_batch_ids.get(kk))){

            _bw.write(_wl_block653Bytes, _wl_block653);
            out.print( String.valueOf((String)alt_batch_ids.get(kk)));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf((String)alt_batch_ids.get(kk)));
            _bw.write(_wl_block502Bytes, _wl_block502);

								}
								else{

            _bw.write(_wl_block654Bytes, _wl_block654);
            out.print( String.valueOf((String)alt_batch_ids.get(kk)));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf((String)alt_batch_ids.get(kk)));
            _bw.write(_wl_block502Bytes, _wl_block502);

								}
							}

            _bw.write(_wl_block655Bytes, _wl_block655);

						}

            _bw.write(_wl_block656Bytes, _wl_block656);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block657Bytes, _wl_block657);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block658Bytes, _wl_block658);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(alt_expiry_date));
            _bw.write(_wl_block659Bytes, _wl_block659);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block660Bytes, _wl_block660);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block661Bytes, _wl_block661);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(alt_trade_name));
            _bw.write(_wl_block662Bytes, _wl_block662);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block663Bytes, _wl_block663);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(alt_trade_id));
            _bw.write(_wl_block664Bytes, _wl_block664);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block665Bytes, _wl_block665);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block666Bytes, _wl_block666);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block667Bytes, _wl_block667);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block668Bytes, _wl_block668);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block669Bytes, _wl_block669);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block670Bytes, _wl_block670);
            out.print( String.valueOf(alt_drug_desc));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(drug_class));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(alt_drug_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(freq_code));
            _bw.write(_wl_block671Bytes, _wl_block671);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block672Bytes, _wl_block672);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block673Bytes, _wl_block673);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block674Bytes, _wl_block674);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block675Bytes, _wl_block675);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(patient_stock_display));
            _bw.write(_wl_block676Bytes, _wl_block676);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block555Bytes, _wl_block555);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block288Bytes, _wl_block288);
            out.print( String.valueOf(patient_stock_checked));
            _bw.write(_wl_block544Bytes, _wl_block544);
            out.print( String.valueOf(patient_stock_check_display));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(patient_stock_disabled));
            _bw.write(_wl_block677Bytes, _wl_block677);
if(!freq_nature.equals("P") && cancelYn.equals("Y") &&!dis_continued.equals("Y") && !hold.equals("Y")&&(iv_prep_yn.equals("") || iv_prep_yn==null || iv_prep_yn.equals("1") || iv_prep_yn.equals("3") || iv_prep_yn.equals("5") || iv_prep_yn.equals("9"))){//ADDED FOR JD-CRF-0200 and freq_nature added for SKR-SCF-1429 
            _bw.write(_wl_block294Bytes, _wl_block294);
            out.print( String.valueOf(encode_drug_desc));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(admin_by_name));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(admin_date_time));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(strength_per_value_pres_uom));
            _bw.write(_wl_block295Bytes, _wl_block295);

					}
            _bw.write(_wl_block678Bytes, _wl_block678);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block679Bytes, _wl_block679);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block680Bytes, _wl_block680);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block681Bytes, _wl_block681);
	
					}	// end for(int n=0; n<multi_drugs.size(); n+=5) on line no. 1293
				} // end if(recCount==row_no && multi_drugs.size()>0) on line no. 1290==End of Alt Non IV
			} // end else on line no. 1068
			recCount++;
		} // end for (int i=0;i<non_iv_drug_details.size();i=i+inc) on line no.339

            _bw.write(_wl_block682Bytes, _wl_block682);

	} // end if(non_iv_drug_details.size()>0) on line no.294

            _bw.write(_wl_block683Bytes, _wl_block683);
            {java.lang.String __page ="MedicationAdministrationFTDrugDtlsIV.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("recCount"), weblogic.utils.StringUtils.valueOf(String.valueOf(recCount)
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block1Bytes, _wl_block1);

	recCount	= recCount -1;
	tot_records = (recCount+newRecCount+altRecCount)-no_of_alt_drus_selected;

	String parvalues=current_date_time+"~"+encounter_id+"~"+admin_due_date+"~"+assign_bed_num+"~"+Store_locn_code+"~"+nursing_unit+"~"+patient_id+"~"+patient_id_test+"~"+order_id_test+"~"+order_line_no_test+"~"+str_row_no+"~"+bean_id+"~"+bean_name+"~"+CommonRepository.getCommonKeyValue( "MODE_INSERT" )+"~"+tot_records+"~"+recCount+"~"+altRecCount+"~"+newRecCount+"~"+mode+"~"+drugCode+"~"+selDateTime+"~"+hold_discontinue_yn+"~"+locale+"~"+from_time+"~"+freq_nature+"~"+freq_nature+"~"+userAuthPINYN+"~"+admin_from_date+"~"+admin_to_date+"~"+dob+"~"+isSite_spec_patient_stock+"~";

            _bw.write(_wl_block686Bytes, _wl_block686);
            {java.lang.String __page ="../../ePH/jsp/MedicationAdministrationFTDrugDtls01.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("parvalues"), weblogic.utils.StringUtils.valueOf(parvalues
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block688Bytes, _wl_block688);
 
	if(function_from.equals("CP")){ //&& flag.equals("Y") removed for SKR-SCF-1172

            _bw.write(_wl_block689Bytes, _wl_block689);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block690Bytes, _wl_block690);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block691Bytes, _wl_block691);

	} 
	putObjectInBean(bean_id,bean,request);
	putObjectInBean(bean_id_all_stages,bean_all_stages,request);
	putObjectInBean(drug_search_bean_id,drug_bean,request);
	putObjectInBean(admin_bean_id,admin_bean,request);
if(mode!=null && !mode.equals("CP")){

            _bw.write(_wl_block692Bytes, _wl_block692);
}
   if(mode!=null && mode.equals("NOTIME")){

            _bw.write(_wl_block693Bytes, _wl_block693);
 
	}

            _bw.write(_wl_block694Bytes, _wl_block694);
}
catch(Exception e){
	e.printStackTrace();
}

            _bw.write(_wl_block695Bytes, _wl_block695);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MedicationAdministration.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Drugs.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdminDose.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.RouteOfAdministration.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ScheduledTime.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdminDate/Time.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.BroughtByPatient.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BatchID.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.expiryDate.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdminDtls.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PatientStockCompleted.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Select.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Administration.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Oncology.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Administration.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Rx.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Administration.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.TPN.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Administration.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdverseDrugReaction.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Taper.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Taper.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Rx.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Rx.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Rx.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Rx.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MFRDetails.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MFRRemarks.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag28(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag28 = null ;
        int __result__tag28 = 0 ;

        if (__tag28 == null ){
            __tag28 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag28);
        }
        __tag28.setPageContext(pageContext);
        __tag28.setParent(null);
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Dtl.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag28;
        __result__tag28 = __tag28.doStartTag();

        if (__result__tag28!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag28== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag28.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag28);
            return true;
        }
        _activeTag=__tag28.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag28);
        __tag28.release();
        return false;
    }

    private boolean _jsp__tag29(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag29 = null ;
        int __result__tag29 = 0 ;

        if (__tag29 == null ){
            __tag29 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag29);
        }
        __tag29.setPageContext(pageContext);
        __tag29.setParent(null);
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Detail.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag29;
        __result__tag29 = __tag29.doStartTag();

        if (__result__tag29!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag29== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag29.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag29);
            return true;
        }
        _activeTag=__tag29.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag29);
        __tag29.release();
        return false;
    }

    private boolean _jsp__tag30(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag30 = null ;
        int __result__tag30 = 0 ;

        if (__tag30 == null ){
            __tag30 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag30);
        }
        __tag30.setPageContext(pageContext);
        __tag30.setParent(null);
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdverseDrugReaction.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag30;
        __result__tag30 = __tag30.doStartTag();

        if (__result__tag30!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag30== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag30.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag30);
            return true;
        }
        _activeTag=__tag30.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag30);
        __tag30.release();
        return false;
    }

    private boolean _jsp__tag31(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag31 = null ;
        int __result__tag31 = 0 ;

        if (__tag31 == null ){
            __tag31 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag31);
        }
        __tag31.setPageContext(pageContext);
        __tag31.setParent(null);
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AlternateDrugs.label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag31;
        __result__tag31 = __tag31.doStartTag();

        if (__result__tag31!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag31== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag31.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag31);
            return true;
        }
        _activeTag=__tag31.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag31);
        __tag31.release();
        return false;
    }

    private boolean _jsp__tag32(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag32 = null ;
        int __result__tag32 = 0 ;

        if (__tag32 == null ){
            __tag32 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag32);
        }
        __tag32.setPageContext(pageContext);
        __tag32.setParent(null);
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Taper.label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag32;
        __result__tag32 = __tag32.doStartTag();

        if (__result__tag32!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag32== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag32.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag32);
            return true;
        }
        _activeTag=__tag32.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag32);
        __tag32.release();
        return false;
    }

    private boolean _jsp__tag33(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag33 = null ;
        int __result__tag33 = 0 ;

        if (__tag33 == null ){
            __tag33 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag33);
        }
        __tag33.setPageContext(pageContext);
        __tag33.setParent(null);
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Taper.label", java.lang.String .class,"key"));
        __tag33.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag33;
        __result__tag33 = __tag33.doStartTag();

        if (__result__tag33!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag33== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag33.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag33);
            return true;
        }
        _activeTag=__tag33.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag33);
        __tag33.release();
        return false;
    }

    private boolean _jsp__tag34(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag34 = null ;
        int __result__tag34 = 0 ;

        if (__tag34 == null ){
            __tag34 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag34);
        }
        __tag34.setPageContext(pageContext);
        __tag34.setParent(null);
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.LinkVaccineShcedule.label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag34;
        __result__tag34 = __tag34.doStartTag();

        if (__result__tag34!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag34== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag34.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag34);
            return true;
        }
        _activeTag=__tag34.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag34);
        __tag34.release();
        return false;
    }

    private boolean _jsp__tag35(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag35 = null ;
        int __result__tag35 = 0 ;

        if (__tag35 == null ){
            __tag35 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag35);
        }
        __tag35.setPageContext(pageContext);
        __tag35.setParent(null);
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Rx.label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag35;
        __result__tag35 = __tag35.doStartTag();

        if (__result__tag35!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag35== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag35.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag35);
            return true;
        }
        _activeTag=__tag35.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag35);
        __tag35.release();
        return false;
    }

    private boolean _jsp__tag36(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag36 = null ;
        int __result__tag36 = 0 ;

        if (__tag36 == null ){
            __tag36 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag36);
        }
        __tag36.setPageContext(pageContext);
        __tag36.setParent(null);
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Rx.label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag36;
        __result__tag36 = __tag36.doStartTag();

        if (__result__tag36!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag36== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag36.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag36);
            return true;
        }
        _activeTag=__tag36.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag36);
        __tag36.release();
        return false;
    }

    private boolean _jsp__tag37(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag37 = null ;
        int __result__tag37 = 0 ;

        if (__tag37 == null ){
            __tag37 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag37);
        }
        __tag37.setPageContext(pageContext);
        __tag37.setParent(null);
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Rx.label", java.lang.String .class,"key"));
        __tag37.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag37;
        __result__tag37 = __tag37.doStartTag();

        if (__result__tag37!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag37== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag37.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag37);
            return true;
        }
        _activeTag=__tag37.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag37);
        __tag37.release();
        return false;
    }

    private boolean _jsp__tag38(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag38 = null ;
        int __result__tag38 = 0 ;

        if (__tag38 == null ){
            __tag38 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag38);
        }
        __tag38.setPageContext(pageContext);
        __tag38.setParent(null);
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Rx.label", java.lang.String .class,"key"));
        __tag38.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag38;
        __result__tag38 = __tag38.doStartTag();

        if (__result__tag38!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag38== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag38.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag38);
            return true;
        }
        _activeTag=__tag38.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag38);
        __tag38.release();
        return false;
    }

    private boolean _jsp__tag39(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag39 = null ;
        int __result__tag39 = 0 ;

        if (__tag39 == null ){
            __tag39 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag39);
        }
        __tag39.setPageContext(pageContext);
        __tag39.setParent(null);
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Bal.label", java.lang.String .class,"key"));
        __tag39.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag39;
        __result__tag39 = __tag39.doStartTag();

        if (__result__tag39!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag39== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag39.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag39);
            return true;
        }
        _activeTag=__tag39.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag39);
        __tag39.release();
        return false;
    }

    private boolean _jsp__tag40(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag40 = null ;
        int __result__tag40 = 0 ;

        if (__tag40 == null ){
            __tag40 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag40);
        }
        __tag40.setPageContext(pageContext);
        __tag40.setParent(null);
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Bal.label", java.lang.String .class,"key"));
        __tag40.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag40;
        __result__tag40 = __tag40.doStartTag();

        if (__result__tag40!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag40== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag40.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag40);
            return true;
        }
        _activeTag=__tag40.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag40);
        __tag40.release();
        return false;
    }

    private boolean _jsp__tag41(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag41 = null ;
        int __result__tag41 = 0 ;

        if (__tag41 == null ){
            __tag41 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag41);
        }
        __tag41.setPageContext(pageContext);
        __tag41.setParent(null);
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MFRDetails.label", java.lang.String .class,"key"));
        __tag41.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag41;
        __result__tag41 = __tag41.doStartTag();

        if (__result__tag41!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag41== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag41.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag41);
            return true;
        }
        _activeTag=__tag41.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag41);
        __tag41.release();
        return false;
    }

    private boolean _jsp__tag42(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag42 = null ;
        int __result__tag42 = 0 ;

        if (__tag42 == null ){
            __tag42 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag42);
        }
        __tag42.setPageContext(pageContext);
        __tag42.setParent(null);
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MFRRemarks.label", java.lang.String .class,"key"));
        __tag42.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag42;
        __result__tag42 = __tag42.doStartTag();

        if (__result__tag42!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag42== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag42.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag42);
            return true;
        }
        _activeTag=__tag42.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag42);
        __tag42.release();
        return false;
    }

    private boolean _jsp__tag43(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag43 = null ;
        int __result__tag43 = 0 ;

        if (__tag43 == null ){
            __tag43 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag43);
        }
        __tag43.setPageContext(pageContext);
        __tag43.setParent(null);
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Select.label", java.lang.String .class,"key"));
        __tag43.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag43;
        __result__tag43 = __tag43.doStartTag();

        if (__result__tag43!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag43== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag43.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag43);
            return true;
        }
        _activeTag=__tag43.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag43);
        __tag43.release();
        return false;
    }

    private boolean _jsp__tag44(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag44 = null ;
        int __result__tag44 = 0 ;

        if (__tag44 == null ){
            __tag44 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag44);
        }
        __tag44.setPageContext(pageContext);
        __tag44.setParent(null);
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Dtl.label", java.lang.String .class,"key"));
        __tag44.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag44;
        __result__tag44 = __tag44.doStartTag();

        if (__result__tag44!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag44== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag44.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag44);
            return true;
        }
        _activeTag=__tag44.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag44);
        __tag44.release();
        return false;
    }

    private boolean _jsp__tag45(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag45 = null ;
        int __result__tag45 = 0 ;

        if (__tag45 == null ){
            __tag45 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag45);
        }
        __tag45.setPageContext(pageContext);
        __tag45.setParent(null);
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Select.label", java.lang.String .class,"key"));
        __tag45.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag45;
        __result__tag45 = __tag45.doStartTag();

        if (__result__tag45!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag45== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag45.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag45);
            return true;
        }
        _activeTag=__tag45.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag45);
        __tag45.release();
        return false;
    }

    private boolean _jsp__tag46(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag46 = null ;
        int __result__tag46 = 0 ;

        if (__tag46 == null ){
            __tag46 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag46);
        }
        __tag46.setPageContext(pageContext);
        __tag46.setParent(null);
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Detail.label", java.lang.String .class,"key"));
        __tag46.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag46;
        __result__tag46 = __tag46.doStartTag();

        if (__result__tag46!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag46== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag46.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag46);
            return true;
        }
        _activeTag=__tag46.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag46);
        __tag46.release();
        return false;
    }

    private boolean _jsp__tag47(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag47 = null ;
        int __result__tag47 = 0 ;

        if (__tag47 == null ){
            __tag47 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag47);
        }
        __tag47.setPageContext(pageContext);
        __tag47.setParent(null);
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
        __tag47.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag47;
        __result__tag47 = __tag47.doStartTag();

        if (__result__tag47!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag47== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag47.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag47);
            return true;
        }
        _activeTag=__tag47.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag47);
        __tag47.release();
        return false;
    }

    private boolean _jsp__tag48(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag48 = null ;
        int __result__tag48 = 0 ;

        if (__tag48 == null ){
            __tag48 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag48);
        }
        __tag48.setPageContext(pageContext);
        __tag48.setParent(null);
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.record.label", java.lang.String .class,"key"));
        __tag48.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag48;
        __result__tag48 = __tag48.doStartTag();

        if (__result__tag48!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag48== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag48.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag48);
            return true;
        }
        _activeTag=__tag48.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag48);
        __tag48.release();
        return false;
    }
}
