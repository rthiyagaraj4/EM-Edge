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

public final class __marschleveldrugdetailsmonthly extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/MARSchLevelDrugDetailsMonthly.jsp", 1709120923634L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n  \n\t <head>\n\t <style media=\"screen\" type=\"text/css\">\n\t/*\t#nonIVHeader { position:fixed; top:0; left:0; }\n\t\t\ttable {padding-top:15px; }*/\n\t</style>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<script language=\"javascript\">\n\t\tvar headTop = -1;\n\t\tvar FloatHead1;\n\t\tvar FloatHead2;\n\t\tvar onlyiv=false;\n\t\tfunction processScroll(){\n\t\t\tif (headTop < 0){\n\t\t\t\tsaveHeadPos();\n\t\t\t}\t\t\t\t\n\t\t\tif (headTop>0){\n\t\t\t\tif (document.documentElement && document.documentElement.scrollTop){\n\t\t\t\t\ttheTop = document.documentElement.scrollTop;\n\t\t\t\t}\n\t\t\t\telse if (document.body){\n\t\t\t\t\ttheTop = document.body.scrollTop;\n\t\t\t\t}\t\t\t\t\t\n\t\t\t\tif(FloatHead2!=null){\n\t\t\t\t\tif(onlyiv){ //Only IV Drugs\n\t\t\t\t\t\tFloatHead1 = FloatHead2;\n\t\t\t\t\t}\n\t\t\t\t\telse{ //NonIV and IV Drugs\n\t\t\t\t\t\tif(document.getElementById(\"ball\").offsetTop < theTop){\n\t\t\t\t\t\t\tFloatHead1.style.visibility= \'hidden\';\n\t\t\t\t\t\t\tFloatHead1 = FloatHead2;\n\t\t\t\t\t\t\tFloatHead1.style.visibility= \'visible\';\n\t\t\t\t\t\t\tFloatHead1.style.position = \"absolute\";\t\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse {\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tFloatHead1.style.position = \"\";\t\n\t\t\t\t\t\t\tFloatHead1 = document.getElementById(\"nonIVHeader\");\n\t\t\t\t\t\t\tFloatHead1.style.visibility= \'visible\';\n\t\t\t\t\t\t\tFloatHead1.style.position = \"relative\";\t\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\telse{ // only NON IV Drugs\n\t\t\t\t\tFloatHead1 = document.getElementById(\"nonIVHeader\");\t\t\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\tif (theTop>headTop){\n\t\t\t\t\tFloatHead1.style.top = (theTop-headTop) + \'px\';\t\t\t\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse{\n\t\t\t\t\tFloatHead1.style.top = \'0px\';\t\t\t\t\t\t\t\n\t\t\t\t}\n\t\t\t}\t\t\t\t\n\t\t}\n\n\t\tfunction saveHeadPos(){\n\t\t\tparTable = document.getElementById(\"nonIVHeaderDiv\");\n\t\t\tif (parTable != null){\t\t\t\t\t\n\t\t\t\theadTop = parTable.offsetTop + 3;\t\t\t\t\t\n\t\t\t\tFloatHead1 = document.getElementById(\"nonIVHeader\");\n\t\t\t\tFloatHead1.style.position = \"relative\";\n\t\t\t\tFloatHead2= document.getElementById(\"IVHeader\");\n\t\t\t\tif (FloatHead2 != null){\t\t\t\t\t\t\n\t\t\t\t\tonlyiv=false;\n\t\t\t\t}\n\t\t\t}\n\t\t\telse{\t\t\t\t\t\n\t\t\t\tparTable = document.getElementById(\"IVHeaderDiv\");\n\t\t\t\tif (parTable != null){\n\t\t\t\t\theadTop = 3;\t\n\t\t\t\t\tFloatHead2 = document.getElementById(\"IVHeader\");\n\t\t\t\t\tFloatHead2.style.position = \"absolute\";\n\t\t\t\t\tonlyiv=true;\n\t\t\t\t}\n\t\t\t}\n\t\t}\t\t\t\n\t\twindow.onscroll = processScroll;\n\t\t</script>\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/PhCommon.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../ePH/js/MedicationAdministrationFixedTime.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../ePH/js/MedicationAdministration.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/DispMedicationAllStages.js\"></script>\n\t\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t\t<script type=\"text/javascript\" src=\"../../ePH/js/DrugDetailsDisplay.js\"></script>\n\t\t<script type=\"text/javascript\" src=\"../../eCommon/js/dchk.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../ePH/js/PPNRegimen.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<body  onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t<form name=\"MedicationAdministrationSchLevelDrugDtls\" id=\"MedicationAdministrationSchLevelDrugDtls\" >\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<script>\n\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\'Common\'));\n\t\t</script>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<div id=\"nonIVHeaderDiv\" > \n\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"1\" id=\"non_iv_administration_table\">\n\t\t\t\t<tr id=\"nonIVHeader\">\n\t\t\t\t\t<td class=\"TDSTYLE\" width=\"19%\" ><B>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</B></td>\n\t\t\t\t\t<td class=\"TDSTYLE\" width=\"6%\"><B>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</B></td>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t\t<td class=\"TDSTYLE\" width=\"2%\"><B>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t</tr>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t<tr id=\"nonIVOrderTypeHdr\" >\n\t\t\t\t\t<td class=\'COLUMNHEADER\' colspan=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"  style=\"font-size:10\" ><b>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</b></td>\n\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t\t<tr id=\"nonIVOrderTypeHdr\" >\n\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\'  colspan=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</b></td>\n\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" width=\'19%\' style=\"font-size:9;";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" rowspan=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t\t\t<label style=\'color:red;font-size:12;FONT-WEIGHT: BOLDER;cursor:pointer;\' onclick=\"loadPage(\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\');\" id=\"drug_mast_det_1\">&nbsp;+&nbsp;</label>\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\t\n\t\t\t\t\t\t\t<label  style=\"font-size:9;font-weight:bold;color:black\">";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\t\t\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\t\t\t\t\t\n\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/info.gif\" align=\"center\"  width=\"17\" height=\"17\" style=\"cursor:pointer;\" onClick=\"showDrugInfo(\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\',\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\')\" title=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\"></img>\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t\t\t\t\t<img src=\'../../ePH/images/AddedIngredient.gif\' width=\'17\' height=\'15\' onclick = \"openPPNDisplay(\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\')\" onmouseover=\"changeCursor(this);\">\t\t\t\t\t\t  \n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t\t</label>\n\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' width=\'2%\'  style=\"font-size:9;\">";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</td>\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' width=\'2%\'  style=\"font-size:9;\">&nbsp;</td>\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' width=\'2%\' style=\"font-size:9;\" >";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' width=\'2%\'  style=\"text-align:center;font-size:9;";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">&nbsp;\n\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"order";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" ><img SRC=\"../../ePH/images/stop.gif\" title=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" id=\'PADtls";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'  title=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' style=\'cursor:pointer;";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'></img>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">&nbsp;</td>\n";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' width=\'2%\'  style=\"text-align:center;font-size:9;\">&nbsp;</td>\n";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">&nbsp;\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"order";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" >\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t<img SRC=\"../../ePH/images/stop.gif\" title=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' title=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\'></img>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' width=\'2%\' style=\"text-align:center;font-size:9;\" >\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' width=\'2%\' style=\"font-size:9;\" >&nbsp;</td>\n";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t</table>\n\t\t</div>\n";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\t\n\t<br>\n";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t<img id=\"ball\" src=\"/images/ball.png\" style=\"visibility:hidden\" height=\"5\"/>\n\t\t\t<div id=\"IVHeaderDiv\" > \n\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"1\" id=\"iv_administration_table\">\n\t\t\t\t\t<tr id=\"IVHeader\">\n\t\t\t\t\t\t<td class=\"TDSTYLE\" width=\"19%\" ><B>";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</B></td>\n\t\t\t\t\t\t<td class=\"TDSTYLE\" width=\"6%\"><B>";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t\t\t\t\t<td class=\"TDSTYLE\" width=\"2%\"><B>";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t\t\t\t<tr>\n";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\"  >\n";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t\t\t\t\t\t<label style=\"font-size:9;font-weight:bold;color:black\" title=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\">";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 =" &nbsp;&nbsp;\n";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/info.gif\" align=\"center\"  width=\"17\" height=\"17\" style=\"cursor:pointer;\" onClick=\"showDrugInfo(\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\t\t\t\t\t</label>\t\t\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\' width=\'5%\'  style=\"font-size:9;\" rowspan=\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\'>&nbsp;</td>\n";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t<tr>\n";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\"  rowspan=\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t\t\t\t\t\t\t\t<label style=\'color:red;font-size:12;FONT-WEIGHT: BOLDER;cursor:pointer;\' onclick=\"loadPage(\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t\t\t\t\t\t<label style=\"font-size:9;font-weight:bold;color:black\" title=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/info.gif\" align=\"center\"  width=\"17\" height=\"17\" style=\"cursor:pointer;\" onClick=\"showDrugInfo(\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t\t\t\t\t\t\t</label>\t\t\n\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t\t\t\t\t\t\t\t<label style=\'color:red;font-size:12;FONT-WEIGHT: BOLDER;cursor:pointer;\' onclick=\"loadPage(\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t\t\t\t\t\t\t\t<label style=\"font-size:9;font-weight:bold;color:black\" title=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t\t\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/info.gif\" align=\"center\"  width=\"17\" height=\"17\" style=\"cursor:pointer;\" onClick=\"showDrugInfo(\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t\t\t\t\t\t\t\t\t</label>\t\t\n\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t<tr>\n";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\' width=\'5%\' style=\"font-size:9;\" >";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\" >\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t<img SRC=\"../../ePH/images/stop.gif\" title=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\">&nbsp;\n\t\t\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n\t\t\t\t\t\t\t\t</label>\t\t\n\t\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t</div>\n";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\"\tvalue=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\">\n\t<input type=\"hidden\" name=\"patient_class\" id=\"patient_class\"\tvalue=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\">\n\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\">\n\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\"\t\tvalue=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\">\n\t<input type=\"hidden\" name=\"patient_id_selected\" id=\"patient_id_selected\" value=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\">\n\t<input type=\"hidden\" name=\"admin_due_date\" id=\"admin_due_date\"\t\tvalue=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\">\n\t<input type=\"hidden\" name=\"assign_bed_num\" id=\"assign_bed_num\"\t\tvalue=\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\">\n\t<input type=\"hidden\" name=\"disp_locn_code\" id=\"disp_locn_code\"\t\tvalue=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\">\n\t<input type=\"hidden\" name=\"nursing_unit\" id=\"nursing_unit\"\t\tvalue=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\">\n\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\">\n\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\">\n\t<input type=\"hidden\" name=\"mode\" id=\"mode\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\">\t\n\t<input type=\"hidden\" name=\"non_iv_records\" id=\"non_iv_records\"\t\tvalue=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\">\n\t<input type=\"hidden\" name=\"func_mode\" id=\"func_mode\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\">\n\t<input type=\"hidden\" name=\"hold_discontinue_yn\" id=\"hold_discontinue_yn\" value=\"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\">\n\t<input type=\"hidden\" name=\"adr_recorded\" id=\"adr_recorded\"\t\tvalue=\"N\">\n\t<input type=\"hidden\" name=\"admin_recorded\" id=\"admin_recorded\"\t\tvalue=\"N\">\n\t<input type=\"hidden\" name=\"locale\" id=\"locale\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\">\n\t<input type=\"hidden\" name=\"from_time\" id=\"from_time\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\">\n\t</form>\n\t</body>\n\t<div name=\"tooltiplayer\" id=\"tooltiplayer\" style=\"position:absolute; width:15%;visibility:hidden;\" bgcolor=\"blue\">\n\t\t<table id=\"tooltiptable\" cellpadding=0 cellspacing=0 border=\"0\" width=\"100%\" height=\"100%\" align=\"center\">\n\t\t\t<tr><td id=\"tooltiptd\"></td></tr>\n\t\t</table>\n\t</div>\n\t</html>\n";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );
	
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

try{
 		request.setCharacterEncoding("UTF-8");
 		//Added by Himanshu for MMS-ME-SCF-0097 Starts 
 		request= new XSSRequestWrapper(request); 
 		response.addHeader("X-XSS-Protection", "1; mode=block"); 
 		response.addHeader("X-Content-Type-Options", "nosniff"); 
 		//Added by Himanshu for MMS-ME-SCF-0097 ends
		String locale					= (String) session.getAttribute("LOCALE");
		String sStyle					=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String patient_class			=	 request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
		String patient_id_test			=	 request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String order_id_test			=	 request.getParameter("order_id");
		String order_line_no_test       =	 request.getParameter("order_line_no")==null?"":request.getParameter("order_line_no");
		String mode				        =	 request.getParameter("mode");	
		String hold_discontinue_yn      =	 request.getParameter("hold_discontinue_yn")==null?"":request.getParameter("hold_discontinue_yn");
		String function_from			=	 request.getParameter("function_from")==null?"":request.getParameter("function_from");
		String admin_due_date			=	 request.getParameter("admin_due_date")==null?"":request.getParameter("admin_due_date");
		String facility_id				=	 (String)session.getValue( "facility_id" );
		String encounter_id			    =	 request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
		String assign_bed_num			=	 request.getParameter("assign_bed_num")==null?"": request.getParameter("assign_bed_num");
		String order_type	            =    request.getParameter("order_type")==null?"": request.getParameter("order_type"); 
		String nursing_unit				=	 request.getParameter("nursing_unit")==null?"":request.getParameter("nursing_unit");
		String administration_status    =	 request.getParameter("administration_status")==null?"": request.getParameter("administration_status");
		String from_time				=	 request.getParameter("from_time")==null?"":request.getParameter("from_time");	
		String to_time					=	 request.getParameter("to_time")==null?"":request.getParameter("to_time");
		String display_order_by			=	 request.getParameter("display_order_by")==null?"":request.getParameter("display_order_by");	
		String route_admin				=	 request.getParameter("route_admin")==null?"":request.getParameter("route_admin");	
		String admin_route_categ		=	 request.getParameter("admin_route_categ")==null?"":request.getParameter("admin_route_categ");	
		String Auto_Admin				=    "";
		float ret_qty=0;
		float returned_qty=0;
		float tot_administered_qty=0;
		float disp_qty=0;
		float ward_return_qty=0;

		DecimalFormat dfTest = new DecimalFormat("0.########");

		if(route_admin.equals("undefined")){
			   route_admin="";
		}
		if(admin_route_categ.equals("undefined")){
			   admin_route_categ="";
		}

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8Bytes, _wl_block8);
 
	String bean_id							= "MedicationAdministrationFTBean";
	String bean_name						= "ePH.MedicationAdministrationFTBean";
	MedicationAdministrationFTBean bean		= (MedicationAdministrationFTBean)getBeanObject( bean_id, bean_name, request );
	bean.setLanguageId(locale);
	bean.setCurrentTimeAndAdminWithinHRS();

	String admin_bean_id						=	  "MedicationAdministrationBean";
	String admin_bean_name						=	  "ePH.MedicationAdministrationBean";
	MedicationAdministrationBean admin_bean		=	  (MedicationAdministrationBean)getBeanObject( admin_bean_id, admin_bean_name, request );
	admin_bean.setLanguageId(locale);
	
	HashMap	drug_details		  =	(HashMap) bean.getMARDetailsMonthView(encounter_id,hold_discontinue_yn,administration_status,order_type,from_time,to_time,display_order_by,route_admin,admin_route_categ);
	ArrayList altDateDayList = admin_bean.getDateDayList(from_time,to_time, "M");
	int daySize=0;
	if(altDateDayList!=null && altDateDayList.size()>0)
		daySize = altDateDayList.size();
	String iv_prep_yn			   =	"";
	String title				   =	"";
	String patient_id					=   "";
	int no_of_alt_drus_selected			=   0;	
	LinkedHashMap	hmNonIVDrugDetails				=	 (LinkedHashMap) drug_details.get("NON_IV");
	LinkedHashMap hmIVDrugDetails				    =	 (LinkedHashMap) drug_details.get("IV");
	HashMap hmSchList				    =	 (HashMap) drug_details.get("SCHLIST");
	ArrayList	non_iv_drug_details	=null;
	ArrayList	alTmpOrderSchDetail	=null;
	ArrayList iv_drug_details =null;
	List OrdersList = null;
	Set uniqueSchedules = null;
	Iterator<String> itrSch = null;
	String Store_locn_code				=	"";
	String sch_date_time="";
	String Storelocn_code				=	"";
	String drug_code="", drug_desc="", drug_class="", drug_class_ind="";
	String  prn_remarks, ext_prod_id="",  start_date_time="", end_date_time="", end_date="";
	String  order_pract_id="",  disp_drug_code  ;
	HashMap overridereason = null;
	String classvalue ="";
	String order_id="", order_line_num="", dayLegend="", schDate="", dispDate="", schTime = "";
	String administered_yn="", doseDisplay="", non_iv_admin_quaty, displayStyle="", displayFreqStyle="", admin_recorded_yn="";
	String strength_per_value_pres_uom = "1",qty="", pres_dosage="", fieldname="", dose_uom_desc1="", tempDosage="" , freq_nature="", freq_code="", dosage_seq_no="", 			admin_drug_code	    =  "", admin_drug_desc 	=  "", admindrugdetails, ord_hold_date_time="", ord_disc_date_time="", discontinued_sch="", discontinued_dose="", hold_sch="";
	String admin_dose_prn, remarks="", discontinued, hold,  stat_style="", scheKey ="", schCanAdmin="", admin_rec_disp="", split_dose_yn="", temp="", prn_qty_desc="";
	StringTokenizer stadmindrugdetails	=	null;
	StringTokenizer stiv_incred			=	null;	
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
	String remarks_style="",  batch_id="", flag="", item_code="", expiry_date ="", AdminBackLogTime="", defaultBatch="", defaultExpiryDate="", defaultTradeId ="", trade_id="" ;
	int orderCount		 = 0, prn_doseCount=0;
	int recCount = 0;
	int dialog_height = 0;
	int rowsPan = 1;
	int schSize = 1;
	int schDayCount =0;
	int dayCount=0;
	int temp1                           =   0;
	int temp2                           =   0;		
	int temp3                           =   0;		
	int ppn_count						=   0;
	String prev_key="", curr_key="", schKey="", prev_freq_nature="", prev_end_date="";


	if((hmNonIVDrugDetails.size()==0) &&(hmIVDrugDetails.size()==0)){

            _bw.write(_wl_block9Bytes, _wl_block9);
		
		return;
	}
	if(hmNonIVDrugDetails.size()>0){
					

            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

					if(altDateDayList!=null && altDateDayList.size()>0){
						daySize = altDateDayList.size();
						for(int day=0; day<daySize; day+=2){

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf((String)altDateDayList.get(day+1)));
            _bw.write(_wl_block12Bytes, _wl_block12);

						}
					}

            _bw.write(_wl_block14Bytes, _wl_block14);

			if(!order_type.equals("A")){ 
				iv_prep_yn				=    (String)drug_details.get("iv_prep_yn");
				if(iv_prep_yn == null)
					iv_prep_yn =    "";
				if(function_from.equals("CP"))
					iv_prep_yn	=	bean.IVType(order_id);
				if(iv_prep_yn.equals("7") || iv_prep_yn.equals("8"))
					title	   =	com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.TPN.label", "ph_labels");
				else if(iv_prep_yn.equals("0") || iv_prep_yn.equals("9"))
					title	   =	com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Oncology.label", "ph_labels");
				else
					title	   =   com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.NON_IV.label", "ph_labels");

            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf((daySize/2)+7));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(title));

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
	
		}
		OrdersList = new ArrayList(hmNonIVDrugDetails.keySet());
		for (int i=0;i<OrdersList.size();i++){	
			alTmpOrderSchDetail = (ArrayList)hmNonIVDrugDetails.get((String)OrdersList.get(i));
			schSize=1;
			prn_doseCount=0;
			//if(schCount>4)
				//rowsPan = 4;
			for(int sch=0; sch<alTmpOrderSchDetail.size(); sch++){
				non_iv_drug_details = (ArrayList)alTmpOrderSchDetail.get(sch);
				drug_code		= (String)non_iv_drug_details.get(0);	
				disp_drug_code		= (String)non_iv_drug_details.get(0);	
				drug_desc		= (String)non_iv_drug_details.get(1);	
				order_id	    = (String)non_iv_drug_details.get(2);
				order_line_num  = (String)non_iv_drug_details.get(3);
				sch_date_time   = (String)non_iv_drug_details.get(5);
				dosage_seq_no		= (String)non_iv_drug_details.get(6);
				discontinued		= (String)non_iv_drug_details.get(7);
				hold				= (String)non_iv_drug_details.get(8);
				administered_yn  = (String)non_iv_drug_details.get(9);
				admin_recorded_yn	= (String)non_iv_drug_details.get(10);
				end_date_time	= (String)non_iv_drug_details.get(11);
				freq_nature	  = (String)non_iv_drug_details.get(12);
				adr_reason			= (String)non_iv_drug_details.get(15);
				adr_remarks			= (String)non_iv_drug_details.get(16);
				adr_record_time		= (String)non_iv_drug_details.get(17);
				adr_recorded_by		= (String)non_iv_drug_details.get(18);
				prn_remarks			= (String)non_iv_drug_details.get(19);				
				start_date_time	= (String)non_iv_drug_details.get(21);
				ext_prod_id			= (String)non_iv_drug_details.get(22);
				schDate	= (String)non_iv_drug_details.get(24);
				schTime	= (String)non_iv_drug_details.get(25);
				split_dose_yn	= (String)non_iv_drug_details.get(26);
				iv_prep_yn			= (String)non_iv_drug_details.get(27);
				ord_hold_date_time	= (String)non_iv_drug_details.get(29);
				ord_disc_date_time	= (String)non_iv_drug_details.get(30);

				if(!adr_record_time.equals("") && !adr_reason.equals("")){
					adr_reason	=	admin_bean.getReasonDesc("M",adr_reason);
					adr_details	=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.AgnstSchedDate.label", "ph_labels")+	":"+com.ehis.util.DateUtils.convertDate(against_sch_date,"DMYHM","en",locale)+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.PostAdmnRsn.label", "ph_labels")+": "+adr_reason+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.remarks.label", "common_labels")+":"+adr_remarks.replaceAll("\"",demostring)+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.recordeddate.label", "common_labels")+" :"+adr_record_time+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.RecordedBy.label", "common_labels")+": "+adr_recorded_by;	
					adminStatus="PAD";
					admin_rec_disp = "display:inline";
				}
				else{
					admin_rec_disp = "display:none";
					adminStatus="";
					adr_details="";
				}

				if(remarks==null){
					remarks="Not Entered";
				}
		
				displayFreqStyle = "";
				displayStyle = "";
				
				if(administered_yn.equals("Y") && !admin_drug_code.equals("") && !admin_drug_code.equals(drug_code) ){
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
				}
				else if(hold.equals("Y") && com.ehis.util.DateUtils.isAfter(sch_date_time, ord_hold_date_time, "DMYHM", locale )) {
					displayStyle = "BACKGROUND-COLOR:yellow;";
				}
				if( freq_code.equals("STAT") || freq_nature.equals("O")) {
					displayFreqStyle	=	"BACKGROUND-COLOR:#CE00CE;";
				} 
				if(sch==0){
					uniqueSchedules = null;
					if(hmSchList.containsKey(((String)OrdersList.get(i))+"SCH")){
						uniqueSchedules = (LinkedHashSet <String>)hmSchList.get(((String)OrdersList.get(i))+"SCH");
						schSize = uniqueSchedules.size();
					}
					/*if(schSize>4)
						rowsPan=4;
					else*/
						rowsPan = schSize;
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

            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(daySize+2));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
 
						} 
						else if(temp2==1){ 

            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(daySize+2));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

						}
						else if(temp3==1){ 

            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(daySize+2));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

						}
					} 
							
					if ((orderCount+1) % 2 == 0 )
						classvalue = "QRYODD" ;
					else
						classvalue = "QRYEVEN" ;	
				
					if(drug_class!=null && drug_class.equals("N")){
						drug_class_ind = "background:#66FFFF;";
					}
					else if(drug_class!=null && drug_class.equals("C")){
						drug_class_ind = "background:#CCFFCC;";
					}
					else if(iv_prep_yn.equals("6")){
						drug_class_ind = "background:#E4CAFF;";
					}
					else{
						drug_class_ind = "";
					}

            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(drug_class_ind));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(rowsPan));
            _bw.write(_wl_block24Bytes, _wl_block24);

							if(!(iv_prep_yn.equals("0")||iv_prep_yn.equals("2")||iv_prep_yn.equals("4")||iv_prep_yn.equals("6")||iv_prep_yn.equals("7")||iv_prep_yn.equals("8"))) {

            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(disp_drug_code));
            _bw.write(_wl_block26Bytes, _wl_block26);
			
							}

            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block28Bytes, _wl_block28);
				
							if( !ext_prod_id.equals("") && !(iv_prep_yn.equals("0"))&& !(iv_prep_yn.equals("9")&&order_line_num.equals("1"))){

            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(ext_prod_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_desc,"UTF-8")));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.DrugInformation.label", "ph_labels")));
            _bw.write(_wl_block32Bytes, _wl_block32);

							}
							if(iv_prep_yn.equals("7")){
								if(ppn_count >0){

            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(Store_locn_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
								}
							}

            _bw.write(_wl_block35Bytes, _wl_block35);

					}
					if(uniqueSchedules!=null){
						schKey = schTime;
						if(freq_nature.equals("P"))
							schKey = dosage_seq_no;
						if(uniqueSchedules.contains(schKey)){
							uniqueSchedules.remove(schKey);
							if(sch!=0){
								schDayCount++;
								for(;schDayCount<=(daySize/2); schDayCount++){
									dispDate = (String)altDateDayList.get((schDayCount-1)*2);
									if(prev_freq_nature.equals("P") && com.ehis.util.DateUtils.isAfter(prev_end_date, dispDate, "DMY", locale) ){

            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

									}
									else{

            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block39Bytes, _wl_block39);

									}
								}

            _bw.write(_wl_block40Bytes, _wl_block40);

								schDayCount=0;
								dayCount = 0;
							}
							if(freq_nature.equals("P")){

            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            out.print( String.valueOf(++prn_doseCount));
            _bw.write(_wl_block38Bytes, _wl_block38);

							}
							else{

            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(schTime));
            _bw.write(_wl_block38Bytes, _wl_block38);

							}
						}
						for(int day=(dayCount*2); day<daySize; day+=2){
							dispDate = (String)altDateDayList.get(day);
							if(com.ehis.util.DateUtils.isAfter(schDate, dispDate, "DMY", locale) && schDayCount ==dayCount){
								schDayCount++;
								dayCount++;
									if(dispDate.equals(schDate)){
										scheKey = order_id+"_"+order_line_num+"_"+dayCount+"_"+dosage_seq_no;
										if(administered_yn.equals("Y")){

            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(displayStyle));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(adr_details));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(admin_rec_disp));
            _bw.write(_wl_block50Bytes, _wl_block50);

										}
										else if(freq_nature.equals("P") ){

            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

										}
										else{

            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(displayStyle));
            _bw.write(_wl_block51Bytes, _wl_block51);

										}
										break;
									}
									else{

            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block52Bytes, _wl_block52);

									}
								}
								else if(com.ehis.util.DateUtils.isAfter(schDate, dispDate, "DMY", locale) && schDayCount<(daySize/2)){
									schDayCount++;
									dayCount++;

            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block39Bytes, _wl_block39);

								}
								else
									dayCount++;
							}
						}
						else{
							dayCount=0;
								for(int day=0; day<daySize; day+=2){
									dispDate = (String)altDateDayList.get(day);
									if(dispDate.equals(schDate)){
											if(administered_yn.equals("Y")){

            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(displayStyle));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(adr_details));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(admin_rec_disp));
            _bw.write(_wl_block58Bytes, _wl_block58);

											}
											else if(prev_freq_nature.equals("P") ){

            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

											}
											else{

            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(displayStyle));
            _bw.write(_wl_block51Bytes, _wl_block51);

											}
									}
									else{

            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block52Bytes, _wl_block52);

									}
									dayCount++;
							}

            _bw.write(_wl_block59Bytes, _wl_block59);

					}
					prev_freq_nature=freq_nature;
					prev_end_date=end_date_time.substring(0,10);
					recCount++;
				}
				schDayCount++;
				for(;schDayCount<=(daySize/2); schDayCount++){
					dispDate = (String)altDateDayList.get((schDayCount-1)*2);
					end_date = end_date_time.substring(0,10);
					scheKey = order_id+"_"+order_line_num+"_"+schDayCount+"_"+dosage_seq_no;
					if(freq_nature.equals("P") && com.ehis.util.DateUtils.isBetween(start_date_time.substring(0,10),end_date, dispDate, "DMY", locale)){

            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);

					}
					else{

            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block64Bytes, _wl_block64);

					}
				}

            _bw.write(_wl_block14Bytes, _wl_block14);

			schDayCount=0;
			dayCount = 0;
			orderCount++;
		}

            _bw.write(_wl_block65Bytes, _wl_block65);

	} 

            _bw.write(_wl_block66Bytes, _wl_block66);

		if(hmIVDrugDetails.size()>0){
					

            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

						if(altDateDayList!=null && altDateDayList.size()>0){
							daySize = altDateDayList.size();
							for(int day=0; day<daySize; day+=2){

            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf((String)altDateDayList.get(day+1)));
            _bw.write(_wl_block12Bytes, _wl_block12);

							}
						}

            _bw.write(_wl_block70Bytes, _wl_block70);

					String IVclassvalue= "", prod_name="";
			int ivRowCount = 0;
			boolean ivnextRow = false;
			int fluidRowspan=1, drugRowspan=1, freqRowspan=1, schRowspan=1 ;
			String ivPB_drug_code = "", ivPB_trade_code="", ivPB_drug_desc ="", ivPB_sch_infusion_rate="", ivPB_sch_infusion_vol_str_unit_desc="", ivPB_sch_infusion_per_unit="", 
			ivPB_qty="", ivPB_qty_uom="", ivPB_imageFileURL="",  ivPB_ext_prod_id="", ivPB_encode_drug_desc="";
			ArrayList alTmpIVPBDrugDtls = null;
			HashMap hmIVDrugFluidDtls=null;
			ArrayList alIVPBDrugSchList = null;
		OrdersList = new ArrayList(hmIVDrugDetails.keySet());
		for (int i=0;i<OrdersList.size();i++){
			alTmpOrderSchDetail = (ArrayList)hmIVDrugDetails.get((String)OrdersList.get(i));
			schSize=1;
			//if(schCount>4)
				//rowsPan = 4;
			for(int sch=0; sch<alTmpOrderSchDetail.size(); sch++){
				iv_drug_details =(ArrayList)alTmpOrderSchDetail.get(sch);
				drug_code		= (String)iv_drug_details.get(2);	
				disp_drug_code		= (String)iv_drug_details.get(2);	
				drug_desc		= (String)iv_drug_details.get(3);	
				order_id	    = (String)iv_drug_details.get(6);
				order_line_num  = (String)iv_drug_details.get(7);
				sch_date_time   = (String)iv_drug_details.get(4);
				dosage_seq_no		= (String)iv_drug_details.get(5);
				discontinued		= (String)iv_drug_details.get(8);
				hold				= (String)iv_drug_details.get(9);
				administered_yn  = (String)iv_drug_details.get(10);
				admin_recorded_yn	= (String)iv_drug_details.get(11);
				end_date_time	= (String)iv_drug_details.get(12);
				freq_nature	  = (String)iv_drug_details.get(13);
				adr_reason			= (String)iv_drug_details.get(16)==null?"":(String)iv_drug_details.get(16);
				adr_remarks			= (String)iv_drug_details.get(17);
				adr_record_time		= (String)iv_drug_details.get(18)==null?"":(String)iv_drug_details.get(18);
				adr_recorded_by		= (String)iv_drug_details.get(19);
				iv_prep_yn			= (String)iv_drug_details.get(20);
				start_date_time	= (String)iv_drug_details.get(23);
				ext_prod_id			= (String)iv_drug_details.get(21);
				schDate	= (String)iv_drug_details.get(24);
				schTime	= (String)iv_drug_details.get(25);
				split_dose_yn	= (String)iv_drug_details.get(26);
				ord_hold_date_time	= (String)iv_drug_details.get(28);
				ord_disc_date_time	= (String)iv_drug_details.get(29);
				if(!adr_record_time.equals("") && !adr_reason.equals("")){
					adr_reason	=	admin_bean.getReasonDesc("M",adr_reason);
					adr_details	=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.AgnstSchedDate.label", "ph_labels")+	":"+com.ehis.util.DateUtils.convertDate(against_sch_date,"DMYHM","en",locale)+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.PostAdmnRsn.label", "ph_labels")+": "+adr_reason+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.remarks.label", "common_labels")+":"+adr_remarks.replaceAll("\"",demostring)+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.recordeddate.label", "common_labels")+" :"+adr_record_time+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.RecordedBy.label", "common_labels")+": "+adr_recorded_by;	
					adminStatus="PAD";
					admin_rec_disp = "display:inline";
				}
				else{
					admin_rec_disp = "display:none";
					adminStatus="";
					adr_details="";
				}

				if(remarks==null){
					remarks="Not Entered";
				}
		
				displayFreqStyle = "";
				displayStyle = "";
				
				if(administered_yn.equals("Y") && !admin_drug_code.equals("") && !admin_drug_code.equals(drug_code) ){
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
				}
				else if(hold.equals("Y") && com.ehis.util.DateUtils.isAfter(sch_date_time, ord_hold_date_time, "DMYHM", locale )) {
					displayStyle = "BACKGROUND-COLOR:yellow;";
				}
				if( freq_code.equals("STAT") || freq_nature.equals("O")) {
					displayFreqStyle	=	"BACKGROUND-COLOR:#CE00CE;";
				} 
				if ((orderCount+1) % 2 == 0 )
					classvalue = "QRYODD" ;
				else
					classvalue = "QRYEVEN" ;	
				if(order_line_num.equals("1"))
					IVclassvalue="IVFLUID1";
				else
					IVclassvalue="IVINGREDIENT1";
				if(sch==0){
					uniqueSchedules = null;
					if(hmSchList.containsKey(((String)OrdersList.get(i))+"SCH")){
						uniqueSchedules = (LinkedHashSet <String>)hmSchList.get(((String)OrdersList.get(i))+"SCH");
						schSize = uniqueSchedules.size();
					}
					rowsPan = schSize;
				if(sch==0 ){

            _bw.write(_wl_block71Bytes, _wl_block71);

					}

					if(!(iv_prep_yn.equals("3")||iv_prep_yn.equals("4"))){

            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(IVclassvalue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(drug_class_ind));
            _bw.write(_wl_block73Bytes, _wl_block73);

							if (!(iv_prep_yn.equals("0")||iv_prep_yn.equals("2")||iv_prep_yn.equals("4")||iv_prep_yn.equals("6"))){

            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block26Bytes, _wl_block26);

							}

            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(prod_name));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block76Bytes, _wl_block76);

							if(ext_prod_id!=null && !ext_prod_id.equals("")&& !(iv_prep_yn.equals("2")||iv_prep_yn.equals("4"))){

            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(ext_prod_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(encode_drug_desc));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.DrugInformation.label", "ph_labels")));
            _bw.write(_wl_block32Bytes, _wl_block32);

							}

            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(rowsPan));
            _bw.write(_wl_block80Bytes, _wl_block80);

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
								drug_class = (String)alTmpIVPBDrugDtls.get(31);
								if(drug_class!=null && drug_class.equals("N"))
									drug_class_ind = "background:#66FFFF";
								else if(drug_class!=null && drug_class.equals("C"))
									drug_class_ind = "background:#CCFFCC";
								else
									drug_class_ind = "";
								
								ivPB_sch_infusion_rate			= (String)alTmpIVPBDrugDtls.get(1);

								if(ivPB_sch_infusion_rate!= null && !(ivPB_sch_infusion_rate.equals(""))){
									if(Float.parseFloat(ivPB_sch_infusion_rate) < 1.0){ 
										ivPB_sch_infusion_rate = Float.parseFloat(ivPB_sch_infusion_rate)+"";
									}
								}
								ivPB_sch_infusion_per_unit		= (String)alTmpIVPBDrugDtls.get(3);
								if(ivPB_sch_infusion_per_unit.equals("H")){
									ivPB_sch_infusion_per_unit = "Hrs";
								}
								else{
									ivPB_sch_infusion_per_unit = "Mins";
								}
								ivPB_qty						 =	 (String)alTmpIVPBDrugDtls.get(16);
								if(Float.parseFloat(ivPB_qty) < 1)
									ivPB_qty="0"+ivPB_qty; 

								if(Float.parseFloat(ivPB_qty) < 1.0)
									ivPB_qty = Float.parseFloat(ivPB_qty)+""; //to prefix a zero
								ivPB_qty_uom					 =	 (String)alTmpIVPBDrugDtls.get(17);
								if(sch!=0 ){
									ivnextRow = true;
									for(;schDayCount<(daySize/2); schDayCount++){

            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(freqRowspan));
            _bw.write(_wl_block80Bytes, _wl_block80);

									}

            _bw.write(_wl_block81Bytes, _wl_block81);

									schDayCount=0;
									dayCount = 0;
								}

            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(IVclassvalue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(drug_class_ind));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(drugRowspan));
            _bw.write(_wl_block24Bytes, _wl_block24);

								if (!iv_prep_yn.equals("4")){

            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(ivPB_drug_code));
            _bw.write(_wl_block26Bytes, _wl_block26);

								}

            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(prod_name));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(ivPB_drug_desc));
            _bw.write(_wl_block76Bytes, _wl_block76);

								if( !ivPB_ext_prod_id.equals("")&& !iv_prep_yn.equals("4")){

            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(ivPB_ext_prod_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(ivPB_encode_drug_desc));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.DrugInformation.label", "ph_labels")));
            _bw.write(_wl_block32Bytes, _wl_block32);

								}

            _bw.write(_wl_block87Bytes, _wl_block87);

							}
							else{ //Fluid Display
								if(sch!=0 ){
									ivnextRow = true;
									for(;schDayCount<(daySize/2); schDayCount++){

            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(freqRowspan));
            _bw.write(_wl_block80Bytes, _wl_block80);

									}

            _bw.write(_wl_block81Bytes, _wl_block81);

									schDayCount=0;
									dayCount = 0;
								}

            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(IVclassvalue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(drug_class_ind));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(fluidRowspan));
            _bw.write(_wl_block24Bytes, _wl_block24);

									if (!(iv_prep_yn.equals("0")||iv_prep_yn.equals("2")||iv_prep_yn.equals("4")||iv_prep_yn.equals("6"))){

            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block26Bytes, _wl_block26);

									}

            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(prod_name));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block76Bytes, _wl_block76);

									if(ext_prod_id!=null && !ext_prod_id.equals("")&& !(iv_prep_yn.equals("2")||iv_prep_yn.equals("4"))){

            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(ext_prod_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(encode_drug_desc));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.DrugInformation.label", "ph_labels")));
            _bw.write(_wl_block32Bytes, _wl_block32);

									}

            _bw.write(_wl_block91Bytes, _wl_block91);

							}
						}
					}
						if(order_line_num.equals("1")) {
							if(uniqueSchedules!=null){
								if(uniqueSchedules.contains(schTime)){
									uniqueSchedules.remove(schTime);
									ivRowCount++;
									if(iv_prep_yn.equals("3")||iv_prep_yn.equals("4")){
										if(sch!=0 && !ivnextRow){
											ivnextRow = false;
											for(;schDayCount<(daySize/2); schDayCount++){

            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(freqRowspan));
            _bw.write(_wl_block80Bytes, _wl_block80);

											}

            _bw.write(_wl_block92Bytes, _wl_block92);

										}

            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(schTime));
            _bw.write(_wl_block38Bytes, _wl_block38);

										schDayCount=0;
										dayCount = 0;
									}
								}
						for(int day=(dayCount*2); day<daySize; day+=2){
							dispDate = (String)altDateDayList.get(day);
							if(com.ehis.util.DateUtils.isAfter(schDate, dispDate, "DMY", locale) && schDayCount ==dayCount){
								schDayCount++;
								dayCount++;
									if(dispDate.equals(schDate)){
										scheKey = order_id+"_"+order_line_num+"_"+dayCount+"_"+dosage_seq_no;
										if(administered_yn.equals("Y")){

            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(displayStyle));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(adr_details));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(admin_rec_disp));
            _bw.write(_wl_block50Bytes, _wl_block50);

										}
										else{

            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(displayStyle));
            _bw.write(_wl_block95Bytes, _wl_block95);

										}
										break;
									}
									else{

            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block52Bytes, _wl_block52);

									}
								}
								else if(com.ehis.util.DateUtils.isAfter(schDate, dispDate, "DMY", locale) && schDayCount<(daySize/2)){
									schDayCount++;
									dayCount++;

            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block39Bytes, _wl_block39);

								}
								else
									dayCount++;
							}
							}
						}
						else{
							dayCount=0;
								for(int day=0; day<daySize; day+=2){
									dispDate = (String)altDateDayList.get(day);
									if(dispDate.equals(schDate)){
											if(administered_yn.equals("Y")){

            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(displayStyle));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(adr_details));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(admin_rec_disp));
            _bw.write(_wl_block58Bytes, _wl_block58);

											}
											else{

            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(displayStyle));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block96Bytes, _wl_block96);

											}
									}
									else{

            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block52Bytes, _wl_block52);

									}
									dayCount++;
								}
							}
							schDayCount=0;
							dayCount = 0;

            _bw.write(_wl_block97Bytes, _wl_block97);

							if(alIVPBDrugSchList!=null && alIVPBDrugSchList.size()>0 && schSize ==1){
								rowsPan = 2;
								freqRowspan=2;
								schRowspan=2;
								drugRowspan=1;
								fluidRowspan=1;
								ivnextRow = true;
								IVclassvalue="IVINGREDIENT1";
								alTmpIVPBDrugDtls = (ArrayList)alIVPBDrugSchList.get(0);
								ivPB_drug_code                =   (String)alTmpIVPBDrugDtls.get(10);
								ivPB_drug_desc                =   (String)alTmpIVPBDrugDtls.get(11);
								ivPB_encode_drug_desc         =   ivPB_drug_desc.replaceAll(" ","%20");
								ivPB_encode_drug_desc         =   java.net.URLEncoder.encode(ivPB_encode_drug_desc,"UTF-8");
								ivPB_encode_drug_desc         =   ivPB_encode_drug_desc.replaceAll("%2520","%20");						
								ivPB_ext_prod_id              =   (String)alTmpIVPBDrugDtls.get(44);
								drug_class = (String)alTmpIVPBDrugDtls.get(31);
								if(drug_class!=null && drug_class.equals("N"))
									drug_class_ind = "background:#66FFFF";
								else if(drug_class!=null && drug_class.equals("C"))
									drug_class_ind = "background:#CCFFCC";
								else
									drug_class_ind = "";
								
								ivPB_sch_infusion_rate			= (String)alTmpIVPBDrugDtls.get(1);

								if(ivPB_sch_infusion_rate!= null && !(ivPB_sch_infusion_rate.equals(""))){
									if(Float.parseFloat(ivPB_sch_infusion_rate) < 1.0){ 
										ivPB_sch_infusion_rate = Float.parseFloat(ivPB_sch_infusion_rate)+"";
									}
								}
								ivPB_sch_infusion_per_unit		= (String)alTmpIVPBDrugDtls.get(3);
								if(ivPB_sch_infusion_per_unit.equals("H")){
									ivPB_sch_infusion_per_unit = "Hrs";
								}
								else{
									ivPB_sch_infusion_per_unit = "Mins";
								}
								ivPB_qty						 =	 (String)alTmpIVPBDrugDtls.get(16);
								if(Float.parseFloat(ivPB_qty) < 1)
									ivPB_qty="0"+ivPB_qty; 

								if(Float.parseFloat(ivPB_qty) < 1.0)
									ivPB_qty = Float.parseFloat(ivPB_qty)+""; //to prefix a zero
								ivPB_qty_uom					 =	 (String)alTmpIVPBDrugDtls.get(17);


            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(IVclassvalue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(drug_class_ind));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(drugRowspan));
            _bw.write(_wl_block24Bytes, _wl_block24);

								if (!(iv_prep_yn.equals("0")||iv_prep_yn.equals("2")||iv_prep_yn.equals("4")||iv_prep_yn.equals("6"))){

            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(ivPB_drug_code));
            _bw.write(_wl_block26Bytes, _wl_block26);

								}

            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(prod_name));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(ivPB_drug_desc));
            _bw.write(_wl_block76Bytes, _wl_block76);

								if( !ivPB_ext_prod_id.equals("")){

            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(ivPB_ext_prod_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(ivPB_encode_drug_desc));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.DrugInformation.label", "ph_labels")));
            _bw.write(_wl_block32Bytes, _wl_block32);

								}

            _bw.write(_wl_block99Bytes, _wl_block99);

							}
						}
					}
				}

            _bw.write(_wl_block100Bytes, _wl_block100);

		}

            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(patient_id_test));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(admin_due_date));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(assign_bed_num));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(Store_locn_code));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(nursing_unit));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(CommonRepository.getCommonKeyValue( "MODE_INSERT" )));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(hold_discontinue_yn));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(from_time));
            _bw.write(_wl_block118Bytes, _wl_block118);

	putObjectInBean(bean_id,bean,request);
	putObjectInBean(admin_bean_id,admin_bean,request);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MedicationName.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ScheduleTime.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Administration.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Oncology.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Administration.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Rx.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Administration.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.TPN.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Administration.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PRN.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Dose.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.RecordPostAdministrationDetails.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PRN.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.RecordPostAdministrationDetails.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PRN.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PRN.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MedicationName.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ScheduleTime.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.RecordPostAdministrationDetails.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.RecordPostAdministrationDetails.label", java.lang.String .class,"key"));
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
}
