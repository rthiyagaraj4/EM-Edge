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
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __marschleveldrugdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/MARSchLevelDrugDetails.jsp", 1709120921556L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n/*\n--------------------------------------------------------------------------------------------------------------------------------\nDate\t\tEdit History\tName\t\tRev.Date   \tRev.By \t\tDescription\n--------------------------------------------------------------------------------------------------------------------------------\n03/01/2018\tIN066125\t\tDinesh T\t01/02/2017\tRamesh G\t\tEM run on window 10 and IE 11\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tVaccine course display schedule before select, displayed wrong icon symbol, unscheduled displayed in pending Rx for MAR\n-------------------------------------------------------------------------------------------------------------------------------\n07/03/2019 IN067953         Devindra       ?           ?            MMS-KH-CRF-0014 \n6/10/2020\tIN074154\t\t Shazana\t\t\t\t\t\t\t\tML-MMOH-SCF-1621 \n22/02/2021\t9596\t\t \tManickavasagam J\t\t\t\t\t\t\tML-MMOH-SCF-1674 \n26/04/2021\t16605\t\t \tManickavasagam J\t\t\t\t\t\t\tML-MMOH-SCF-1767 \n24/04/2022                  Chandrashekar raju A                    ML-MMOH-SCF-1964\n11/05/2023      44335          SREENADH.M        RAMESH.G               NMC-JD-CRF-0186\n16/05/2023      45063       SREENADH.M                                  NMC-JD-CRF-0186\n15/06/2023      46294       SREENADH.M           RAMESH.G               NMC-JD-CRF-0186 \n---------------------------------------------------------------------------------------------------------------------------------------\n*/ \n\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="      \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t <head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<script language=\"javascript\">\n\t\tvar headTop = -1;\n\t\tvar FloatHead1;\n\t\tvar FloatHead2;\n\t\tvar onlyiv=false;\n\t\tfunction processScroll(){\n\t\t\tif (headTop < 0){\n\t\t\t\tsaveHeadPos();\n\t\t\t}\t\t\t\t\n\t\t\tif (headTop>0){\n\t\t\t\tif (document.documentElement && document.documentElement.scrollTop){\n\t\t\t\t\ttheTop = document.documentElement.scrollTop;\n\t\t\t\t}\n\t\t\t\telse if (document.body){\n\t\t\t\t\ttheTop = document.body.scrollTop;\n\t\t\t\t}\t\t\t\t\t\n\t\t\t\tif(FloatHead2!=null){\n\t\t\t\t\tif(onlyiv){ //Only IV Drugs\n\t\t\t\t\t\tFloatHead1 = FloatHead2;\n\t\t\t\t\t}\n\t\t\t\t\telse{ //NonIV and IV Drugs\n\t\t\t\t\t\tif(document.getElementById(\"ball\").offsetTop < theTop){\n\t\t\t\t\t\t\tFloatHead1.style.visibility= \'hidden\';\n\t\t\t\t\t\t\tFloatHead1 = FloatHead2;\n\t\t\t\t\t\t\tFloatHead1.style.visibility= \'visible\';\n\t\t\t\t\t\t\tFloatHead1.style.position = \"absolute\";\t\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse {\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tFloatHead1.style.position = \"\";\t\n\t\t\t\t\t\t\tFloatHead1 = document.getElementById(\"nonIVHeader\");\n\t\t\t\t\t\t\tFloatHead1.style.visibility= \'visible\';\n\t\t\t\t\t\t\tFloatHead1.style.position = \"relative\";\t\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\telse{ // only NON IV Drugs\n\t\t\t\t\tFloatHead1 = document.getElementById(\"nonIVHeader\");\t\t\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\tif (theTop>headTop){\n\t\t\t\t\tFloatHead1.style.top = (theTop-headTop)+5 + \'px\';\t\t\t\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse{\n\t\t\t\t\tFloatHead1.style.top = \'0px\';\t\t\t\t\t\t\t\n\t\t\t\t}\n\t\t\t}\t\t\t\t\n\t\t}\n\n\t\tfunction saveHeadPos(){\n\t\t\tparTable = document.getElementById(\"nonIVHeaderDiv\");\n\t\t\tif (parTable != null){\n\t\t\t\theadTop = parTable.offsetTop + 5;\n\t\t\t\tFloatHead1 = document.getElementById(\"nonIVHeader\");\n\t\t\t\tFloatHead1.style.position = \"relative\";\n\t\t\t\tFloatHead2= document.getElementById(\"IVHeader\");\n\t\t\t\tif (FloatHead2 != null){\t\t\t\t\t\t\n\t\t\t\t\tonlyiv=false;\n\t\t\t\t}\n\t\t\t}\n\t\t\telse{\t\t\t\t\t\n\t\t\t\tparTable = document.getElementById(\"IVHeaderDiv\");\n\t\t\t\tif (parTable != null){\n\t\t\t\t\t//headTop = 3;\t\n\t\t\t\t\theadTop = parTable.offsetTop + 3;\t\n\t\t\t\t\tFloatHead2 = document.getElementById(\"IVHeader\");\n\t\t\t\t\tFloatHead2.style.position = \"absolute\";\n\t\t\t\t\tonlyiv=true;\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\twindow.onscroll = processScroll;\n\t\t</script>\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/PhCommon.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../ePH/js/MedicationAdministrationFixedTime.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../ePH/js/MedicationAdministration.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/DispMedicationAllStages.js\"></script>\n\t\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t\t<script type=\"text/javascript\" src=\"../../ePH/js/DrugDetailsDisplay.js\"></script>\n\t\t<script type=\"text/javascript\" src=\"../../eCommon/js/dchk.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../ePH/js/PPNRegimen.js\"></script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t\t<style>\n\t\t/*  changes NMC-JD-CRF-0186[44335] */\n\t\tTD.hiddenCheck{\n\t\t\tvisibility: false;\n\t\t\tpointer-events:none;\n\t\t\tbackground-color: blue;\n\t\t\tdisabled: true;\n\t\t}\n\t\tTD.visibleCheck{\n\t\t\tvisibility: true;\n\t\t\tenabled: true;\n\t\t}\n\t\t</style>\n\t</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<body  onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t\t<form name=\"MedicationAdministrationSchLevelDrugDtls\" id=\"MedicationAdministrationSchLevelDrugDtls\" >\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t<script>\n\t\t\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\'Common\'));\n\t\t\t\t</script>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t<script>\n\t\t\t\t\tshowHideCriteria(\'H\');\n\t\t\t\t</script>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t<div id=\"nonIVHeaderDiv\" > \n\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"1\" id=\"non_iv_administration_table\" >\n\t\t\t\t\t\t<tr id=\"nonIVHeader\">\n\t\t\t\t\t\t\t<td class=\"TDSTYLE\" width=\"16%\" colspan=\'2\' nowrap>\n\t\t\t\t\t\t\t\t<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\"  >\n\t\t\t\t\t\t\t\t\t<tr style=\'height:14px;\'>\n\t\t\t\t\t\t\t\t\t\t<td class=\"TDSTYLE\" width=\"16%\" colspan=\'2\' nowrap>\n\t\t\t\t\t\t\t\t\t\t\t<B>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</B>\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t<tr style=\'height:14px;\'>\n\t\t\t\t\t\t\t\t\t\t<td class=\"TDSTYLE\" width=\"8%\" style=\'text-align:center;\'><B>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</B></td>\n\t\t\t\t\t\t\t\t\t\t<td class=\"TDSTYLE\" width=\"8%\" style=\'text-align:center;\'><B>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</B></td>\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t</td>\n\n\t\t\t\t\t\t\t<td class=\"TDSTYLE\" width=\"20%\" wrap><B>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</B></td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="<!-- added or mms-kh-crf-0010 -->\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<td class=\"TDSTYLE\" width=\"2%\" ><B>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t\t<td class=\"TDSTYLE\" width=\"8%\" nowrap><B>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</B></td>\n\t\t\t\t\t\t\t<td class=\"TDSTYLE\" width=\"8%\" nowrap><B>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</B></td>\n\t\t\t\t\t\t\t<td class=\"TDSTYLE\" width=\"7%\" nowrap><B>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t\t<td class=\"TDSTYLE\" width=\"2%\"><B>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t\t<td class=\"TDSTYLE\" width=\"6%\" ><B>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</B></td>\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t\t\t\t<td class=\"TDSTYLE\" width=\"5%\">\n\t\t\t\t\t\t\t\t\t\t<table   border=\"1\" cellpadding=\"0\" cellspacing=\"0\"  >\n\t\t\t\t\t\t\t\t\t\t\t<tr style=\'height:14px;\'>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"TDSTYLE\" width=\"5%\"><B>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</B></td><!-- convertDate Added for SRR - SRR20056-SCF-9369 [IN057079] --> \n\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t<tr style=\'height:14px;\'>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"TDSTYLE\" width=\"5%\" style=\'text-align:center;\'><B>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</B></td>\n\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t<tr id=\"nonIVOrderTypeHdr\" >\n\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' colspan=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\"  style=\"font-size:10\" ><b>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</b></td>\n\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t\t\t\t<tr id=\"nonIVOrderTypeHdr\" >\n\t\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\'  colspan=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</b></td>\n\t\t\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =" ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_sliding_scale_";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" id=\"non_iv_sliding_scale_";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\t\n\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' width=\'7%\' style=\"font-size:9;text-align:center;\" nowrap rowspan=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\n\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</td>\n\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" width=\'19%\' style=\"word-wrap:break-word;font-size:9;";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\"  rowspan=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t\t\t\t\t\t<label style=\'color:red;font-size:12;FONT-WEIGHT: BOLDER;cursor:pointer;\' onclick=\"loadPage(\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\');\" id=\"drug_mast_det_";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">&nbsp;+&nbsp;</label>\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\t\n\t\t\t\t\t\t\t\t\t<label  style=\"font-size:9;font-weight:bold;color:black\">";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\t\t\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/info.gif\" align=\"center\"  width=\"17\" height=\"17\" style=\"cursor:pointer;\" onClick=\"showDrugInfo(\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\',\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\')\" title=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\"></img>\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\t\t\t\t\t\t<img src=\'../../ePH/images/camera.gif\' width=\'17\' height=\'15\' onclick = \"showImage(\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\');\" onmouseover=\"changeCursor(this);\">\n";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\t\t\t\t\t\t<img  id=\"ADR_img\" src=\'../../ePH/images/ADR.gif\'  title=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' onclick = \"callADRdetails(\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\');\"></img>\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\t\t\t\t\t\t\t<img src=\'../../ePH/images/DrugInfo.gif\' width=\'17\' height=\'15\' onclick = \"showDrug(\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t\t\t\t\t\t\t\t<img src=\'../../ePH/images/AddedIngredient.gif\' width=\'17\' height=\'15\' onclick = \"openPPNDisplay(\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\')\" onmouseover=\"changeCursor(this);\">\t\t\t\t\t\t  \n";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t\t\t\t\t\t\t\t\t<br><label id=\'link_vaccine_label_";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\' style=\"font-size:10;\" title=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\'> ";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 =" <input type=\'text\' size=10 name=\'link_vaccine_desc_";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\' id=\'link_vaccine_desc_";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\' value=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\' disabled><input type=button  class=\'button\' value=\'?\' name=\'btn_link_vaccine_";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\' id=\'btn_link_vaccine_";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\' onClick=\"linkVaccine(\'noniv\',\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\', \'SCH\')\"></label>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\"link_vaccine_code_";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" id=\"link_vaccine_code_";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\" value=\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<br>";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="&nbsp;<label id=\'PRN_BAL_QTY_";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\' >";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="</label>&nbsp;";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t<br><label style=\'color:blue;\'>";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 =":&nbsp;";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="</label>\n";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t\t\t\t\t\t\t\t\t</label>\n";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t\t\t\t\t\t\t\t<br><label style=\"font-size:9;color:green\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 =" </label>\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"dispensed_drug_desc_";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\" id=\"dispensed_drug_desc_";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\">\n";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<!-- added for MMS-KH-CRF-0010 start-->\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t\t\t\t\t\t\t<td   class=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\" rowspan=\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\'>\n\t\t\t\t\t<img src=\"../../ePH/images/DrugRemarks.gif\" align=\"center\" style=\"cursor:pointer;\" onClick=\"displayInstructions(\'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\',\'N\')\" title=";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="></img>\n\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\t\t\t\t\t<!-- added for MMS-KH-CRF-0010  end-->\n\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\' width=\'7%\' style=\'word-wrap:break-word;\' rowspan=\'";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\'><label style=\"color:";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 =";background-color:";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 =";font-size:9;text-align:center;\">";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="</label></td>\n\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\' width=\'7%\' style=\"word-wrap:break-word;font-size:9;text-align:center;";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="</td>\n";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\' width=\'7%\' style=\"font-size:9;text-align:center;word-wrap:break-word;\" rowspan=\'";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="&nbsp;";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\" width=\'3%\' style=\"word-wrap:break-word;font-size:9;\"  rowspan=\'";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\' width=\'5%\' style=\"text-align:center;font-size:9;COLOR:blue;text-decoration:underline;word-wrap:break-word;\" wrap>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"order";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\"><label style=\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\" onClick=\"dispAdminOptions(\'";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\',\'N\',\'N\',\'NONIV\',\'";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\',\'\')\"  onMouseOver=\"hideAdminOptions(\'";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\')\"><u>";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="</u></label>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"dosage_seq_no_";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="_";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\" id=\"dosage_seq_no_";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"SrlNo";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\" id=\"SrlNo";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sch_date_";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\" id=\"sch_date_";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sch_time_";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\" id=\"sch_time_";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sch_date_time_";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\" id=\"sch_date_time_";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"admin_date_time_";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\" id=\"admin_date_time_";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\" value=\"\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"dosage_";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\" id=\"dosage_";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"dosage_uom_code_";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\" id=\"dosage_uom_code_";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"discontinued_dose_";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\" id=\"discontinued_dose_";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\"> \n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"discontiuned_sch_";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\" id=\"discontiuned_sch_";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\"> \n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"hold_sch_";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\" id=\"hold_sch_";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\"> \n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"recExists_";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\" id=\"recExists_";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\" value=\"N\"> \n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"allowPRN_";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\" id=\"allowPRN_";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\" value=\"Y\"> \n";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\' width=\'5%\' style=\"word-wrap:break-word;text-align:center;font-size:9;";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\" wrap>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"order";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\" >";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\' width=\'5%\'  style=\"font-size:9;word-wrap:break-word;\">&nbsp;</td>\n";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\n\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t<tr>\n";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\n\t\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\' width=\'5%\' style=\"font-size:9;word-wrap:break-word;\" >";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\' width=\'7%\' style=\"font-size:9;text-align:center;word-wrap:break-word;\" >";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="</td><!-- modified for IN074154 -->\n";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\' width=\'5%\' style=\"font-size:9;word-wrap:break-word;\">";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\' width=\'5%\'  style=\"word-wrap:break-word;text-align:center;font-size:9;";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\" wrap>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"order";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\" title=\'";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\'><label style=\"vertical-align:middle;cursor:pointer;\" onClick=\"\">";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="</label>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img SRC=\"../../ePH/images/stop.gif\" title=\"";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\" id=\'PADtls";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\' onClick=\"recordADR(\'";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\',\'1\',\'\',\'";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\',\'SCH\', \'";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\', \'VPAD\');\" title=\'";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\' style=\'cursor:pointer;";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\'></img>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="    \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\" wrap>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<!-- //cancelYn,admin_by_name,drug_desc added for JD-CRF-0200 -->\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"order";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\'><label style=\"vertical-align:middle;cursor:pointer;\" onClick=\"dispAdminOptions(\'";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\', \'";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\',\'\',\'\',\'\',\'\',\'";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\');\" onMouseOver=\"hideAdminOptions(\'";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\')\">";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="</label><!--modified for MMS-KH-SCF-0064 -->\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img SRC=\"../../ePH/images/stop.gif\" title=\"";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\'></img>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t                                          ";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/history1.jpg\" align=\"center\"  width=\"17\" height=\"17\"  title=\"Cancel History\" onclick=\"cancelHistory(\'";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\')\"></img> <!--modified for MMS-KH-SCF-0064 -->\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\n\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\"><label style=\'vertical-align:middle;";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="</label></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\' >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</label>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\')\"></img><!--modified for MMS-KH-SCF-0064 -->\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\n                                                        <td class=\'";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\'>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label style=\"vertical-align:middle;";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\" onClick=\"\">\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\'>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label style=\"vertical-align:middle;";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\" onClick=\"\">\n";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<!-- //cancelYn,admin_by_name,drug_desc added for JD-CRF-0200 -->\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 =" <!-- NMC-JD-CRF-0186 US002&03[45063] Modified for 46294 -->\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label style=\"vertical-align:middle;";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\" onClick=\"#\" onMouseOver=\"hideAdminOptions(\'";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\')\"><!--modified for MMS-KH-SCF-0064 -->\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\')\"><!--modified for MMS-KH-SCF-0064 -->\n";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"allowPRN_";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\" value=\"Y\"> \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</label>\n";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img SRC=\"../../ePH/images/stop.gif\" title=\"";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\'></img>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\" wrap> <div id=\"order";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label id=\"non_iv_MFR_dtls_";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\"  style=\'vertical-align:middle;COLOR:blue;cursor:pointer;\' name=\"non_iv_MFR_dtls_";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\"  onClick=\"dispAdminOptions(\'";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\',\'NONIV\',\'";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\',\'\',\'";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\');\" >";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="<br>";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="</label><br><a href=\"#\"  onMouseOver=\"changeCursor(this);\" onClick=\"showMFRRemarks(\'";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\',\'Y\');\" id=\'mfrRemarksLink_";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\'><font color=\"red\" size=\'1\'>";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="</font></a>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\n\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\n";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\' width=\'5%\'  style=\"word-wrap:break-word;text-align:center;font-size:9;COLOR:blue;text-decoration:underline;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"order";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 =";\" onClick=\"dispAdminOptions(\'";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="</u></label></td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"dosage_seq_no_";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\' width=\'5%\'  style=\"text-align:center;font-size:9;word-wrap:break-word;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\' width=\'5%\'  style=\"text-align:center;font-size:9;word-wrap:break-word;\">&nbsp;</td>\n";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\n                                                   <td class=\'";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\" wrap>\n\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"order";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\"> <label style=\"";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\" onClick=\"\">";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="</label>\n\t\t\t\t\t\t\t\t\t\t\t\t<img SRC=\"../../ePH/images/stop.gif\" title=\"";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\'></img>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</td> \n";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\');\"  onMouseOver=\"hideAdminOptions(\'";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\'></img>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\' width=\'5%\' >&nbsp;</td>\n";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="\'> <label style=\"cursor:pointer;\" onClick=\"dispAdminOptions(\'";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"order";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\" ><label style=\'vertical-align:middle;\' >";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="\" > <label style=\"";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="\')\" onMouseOver=\"hideAdminOptions(\'";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="</label>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img SRC=\"../../ePH/images/stop.gif\" title=\"";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="\'></img>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="\' width=\'5%\'  style=\"word-wrap:break-word;text-align:center;font-size:9;\" >&nbsp;</td>\n";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\n\t\t\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\teval(\'document.getElementById(\"PRN_BAL_QTY_\")";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="\').innerText=\'";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="\';\n\t\t\t\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"dosage_seq_no_";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\"><!--sch===>schDayCount -->\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"SrlNo";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sch_date_";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sch_time_";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sch_date_time_";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"admin_date_time_";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"dosage_";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"dosage_uom_code_";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"discontinued_dose_";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="\"> \n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"discontiuned_sch_";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 ="\"> \n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"hold_sch_";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="\"> \n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"recExists_";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="\"> \n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sch_dosage_qty";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="\" id=\"sch_dosage_qty";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"future_admin_";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 ="\" id=\"future_admin_";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="\"> <!-- future_admin  Added for GHL-CRF-0482 --> \n";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 ="\' width=\'5%\' style=\"text-align:center;font-size:9;COLOR:blue;text-decoration:underline;word-wrap:break-word;";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 ="\" >\n\t\t\t\t\t\t\t\t\t\t\t<div id=\"order";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="</u></label>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"dosage_seq_no_";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 ="\"><!-- i_prnSrlNo schDayCount-->\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"SrlNo";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sch_date_";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sch_time_";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sch_date_time_";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );

    private final static java.lang.String  _wl_block267 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"admin_date_time_";
    private final static byte[]  _wl_block267Bytes = _getBytes( _wl_block267 );

    private final static java.lang.String  _wl_block268 ="\" value=\"\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"dosage_";
    private final static byte[]  _wl_block268Bytes = _getBytes( _wl_block268 );

    private final static java.lang.String  _wl_block269 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"dosage_uom_code_";
    private final static byte[]  _wl_block269Bytes = _getBytes( _wl_block269 );

    private final static java.lang.String  _wl_block270 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"discontinued_dose_";
    private final static byte[]  _wl_block270Bytes = _getBytes( _wl_block270 );

    private final static java.lang.String  _wl_block271 ="\"> \n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"discontiuned_sch_";
    private final static byte[]  _wl_block271Bytes = _getBytes( _wl_block271 );

    private final static java.lang.String  _wl_block272 ="\"> \n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"hold_sch_";
    private final static byte[]  _wl_block272Bytes = _getBytes( _wl_block272 );

    private final static java.lang.String  _wl_block273 ="\"> \n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"recExists_";
    private final static byte[]  _wl_block273Bytes = _getBytes( _wl_block273 );

    private final static java.lang.String  _wl_block274 ="\" value=\"N\"> \n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"allowPRN_";
    private final static byte[]  _wl_block274Bytes = _getBytes( _wl_block274 );

    private final static java.lang.String  _wl_block275 ="\' width=\'5%\' style=\"word-wrap:break-word;text-align:center;font-size:9;\" >\n\t\t\t\t\t\t\t\t\t\t\t<div id=\"order";
    private final static byte[]  _wl_block275Bytes = _getBytes( _wl_block275 );

    private final static java.lang.String  _wl_block276 ="</div>\n\t\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block276Bytes = _getBytes( _wl_block276 );

    private final static java.lang.String  _wl_block277 ="\' width=\'5%\' style=\"font-size:9;\" >&nbsp;</td>\n";
    private final static byte[]  _wl_block277Bytes = _getBytes( _wl_block277 );

    private final static java.lang.String  _wl_block278 ="\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_drug_code_";
    private final static byte[]  _wl_block278Bytes = _getBytes( _wl_block278 );

    private final static java.lang.String  _wl_block279 ="\" id=\"non_iv_drug_code_";
    private final static byte[]  _wl_block279Bytes = _getBytes( _wl_block279 );

    private final static java.lang.String  _wl_block280 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_dispense_drug_code_";
    private final static byte[]  _wl_block280Bytes = _getBytes( _wl_block280 );

    private final static java.lang.String  _wl_block281 ="\" id=\"non_iv_dispense_drug_code_";
    private final static byte[]  _wl_block281Bytes = _getBytes( _wl_block281 );

    private final static java.lang.String  _wl_block282 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_drug_desc_";
    private final static byte[]  _wl_block282Bytes = _getBytes( _wl_block282 );

    private final static java.lang.String  _wl_block283 ="\" id=\"non_iv_drug_desc_";
    private final static byte[]  _wl_block283Bytes = _getBytes( _wl_block283 );

    private final static java.lang.String  _wl_block284 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_order_id_";
    private final static byte[]  _wl_block284Bytes = _getBytes( _wl_block284 );

    private final static java.lang.String  _wl_block285 ="\" id=\"non_iv_order_id_";
    private final static byte[]  _wl_block285Bytes = _getBytes( _wl_block285 );

    private final static java.lang.String  _wl_block286 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_order_line_no_";
    private final static byte[]  _wl_block286Bytes = _getBytes( _wl_block286 );

    private final static java.lang.String  _wl_block287 ="\" id=\"non_iv_order_line_no_";
    private final static byte[]  _wl_block287Bytes = _getBytes( _wl_block287 );

    private final static java.lang.String  _wl_block288 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_store_code_";
    private final static byte[]  _wl_block288Bytes = _getBytes( _wl_block288 );

    private final static java.lang.String  _wl_block289 ="\" id=\"non_iv_store_code_";
    private final static byte[]  _wl_block289Bytes = _getBytes( _wl_block289 );

    private final static java.lang.String  _wl_block290 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_end_date_";
    private final static byte[]  _wl_block290Bytes = _getBytes( _wl_block290 );

    private final static java.lang.String  _wl_block291 ="\" id=\"non_iv_end_date_";
    private final static byte[]  _wl_block291Bytes = _getBytes( _wl_block291 );

    private final static java.lang.String  _wl_block292 ="\">\t\t\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_drug_class";
    private final static byte[]  _wl_block292Bytes = _getBytes( _wl_block292 );

    private final static java.lang.String  _wl_block293 ="\" id=\"non_iv_drug_class";
    private final static byte[]  _wl_block293Bytes = _getBytes( _wl_block293 );

    private final static java.lang.String  _wl_block294 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_dtls_yn";
    private final static byte[]  _wl_block294Bytes = _getBytes( _wl_block294 );

    private final static java.lang.String  _wl_block295 ="\" id=\"non_iv_dtls_yn";
    private final static byte[]  _wl_block295Bytes = _getBytes( _wl_block295 );

    private final static java.lang.String  _wl_block296 ="\" value=\"N\">\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"freq_code";
    private final static byte[]  _wl_block296Bytes = _getBytes( _wl_block296 );

    private final static java.lang.String  _wl_block297 ="\" id=\"freq_code";
    private final static byte[]  _wl_block297Bytes = _getBytes( _wl_block297 );

    private final static java.lang.String  _wl_block298 ="\">\t\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_prep_yn";
    private final static byte[]  _wl_block298Bytes = _getBytes( _wl_block298 );

    private final static java.lang.String  _wl_block299 ="\" id=\"iv_prep_yn";
    private final static byte[]  _wl_block299Bytes = _getBytes( _wl_block299 );

    private final static java.lang.String  _wl_block300 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_dosage_type_";
    private final static byte[]  _wl_block300Bytes = _getBytes( _wl_block300 );

    private final static java.lang.String  _wl_block301 ="\" id=\"non_iv_dosage_type_";
    private final static byte[]  _wl_block301Bytes = _getBytes( _wl_block301 );

    private final static java.lang.String  _wl_block302 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"onco_direct_drug_count_";
    private final static byte[]  _wl_block302Bytes = _getBytes( _wl_block302 );

    private final static java.lang.String  _wl_block303 ="\" id=\"onco_direct_drug_count_";
    private final static byte[]  _wl_block303Bytes = _getBytes( _wl_block303 );

    private final static java.lang.String  _wl_block304 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"onco_iv_prep_yn_";
    private final static byte[]  _wl_block304Bytes = _getBytes( _wl_block304 );

    private final static java.lang.String  _wl_block305 ="\" id=\"onco_iv_prep_yn_";
    private final static byte[]  _wl_block305Bytes = _getBytes( _wl_block305 );

    private final static java.lang.String  _wl_block306 ="\"><!--added for MMS-KH-CRF-0017.1 -->\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_qty_in_disp_mode_";
    private final static byte[]  _wl_block306Bytes = _getBytes( _wl_block306 );

    private final static java.lang.String  _wl_block307 ="\" id=\"non_iv_qty_in_disp_mode_";
    private final static byte[]  _wl_block307Bytes = _getBytes( _wl_block307 );

    private final static java.lang.String  _wl_block308 ="\" value=\"\">\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"Remarks";
    private final static byte[]  _wl_block308Bytes = _getBytes( _wl_block308 );

    private final static java.lang.String  _wl_block309 ="\" id=\"Remarks";
    private final static byte[]  _wl_block309Bytes = _getBytes( _wl_block309 );

    private final static java.lang.String  _wl_block310 ="\" value=\"N\">\t\t\t\t\t\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"non_iv_Auto_Admin_";
    private final static byte[]  _wl_block310Bytes = _getBytes( _wl_block310 );

    private final static java.lang.String  _wl_block311 ="\" id=\"non_iv_Auto_Admin_";
    private final static byte[]  _wl_block311Bytes = _getBytes( _wl_block311 );

    private final static java.lang.String  _wl_block312 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"order_pract_id_";
    private final static byte[]  _wl_block312Bytes = _getBytes( _wl_block312 );

    private final static java.lang.String  _wl_block313 ="\" id=\"order_pract_id_";
    private final static byte[]  _wl_block313Bytes = _getBytes( _wl_block313 );

    private final static java.lang.String  _wl_block314 ="\"> \n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"discontinued";
    private final static byte[]  _wl_block314Bytes = _getBytes( _wl_block314 );

    private final static java.lang.String  _wl_block315 ="\" id=\"discontinued";
    private final static byte[]  _wl_block315Bytes = _getBytes( _wl_block315 );

    private final static java.lang.String  _wl_block316 ="\"> \n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"ord_disc_date_time";
    private final static byte[]  _wl_block316Bytes = _getBytes( _wl_block316 );

    private final static java.lang.String  _wl_block317 ="\" id=\"ord_disc_date_time";
    private final static byte[]  _wl_block317Bytes = _getBytes( _wl_block317 );

    private final static java.lang.String  _wl_block318 ="\"> \n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"hold";
    private final static byte[]  _wl_block318Bytes = _getBytes( _wl_block318 );

    private final static java.lang.String  _wl_block319 ="\" id=\"hold";
    private final static byte[]  _wl_block319Bytes = _getBytes( _wl_block319 );

    private final static java.lang.String  _wl_block320 ="\"> \n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"freq_nature_";
    private final static byte[]  _wl_block320Bytes = _getBytes( _wl_block320 );

    private final static java.lang.String  _wl_block321 ="\" id=\"freq_nature_";
    private final static byte[]  _wl_block321Bytes = _getBytes( _wl_block321 );

    private final static java.lang.String  _wl_block322 ="\"> \n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"maxdosecount_";
    private final static byte[]  _wl_block322Bytes = _getBytes( _wl_block322 );

    private final static java.lang.String  _wl_block323 ="\" id=\"maxdosecount_";
    private final static byte[]  _wl_block323Bytes = _getBytes( _wl_block323 );

    private final static java.lang.String  _wl_block324 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"MfrYN";
    private final static byte[]  _wl_block324Bytes = _getBytes( _wl_block324 );

    private final static java.lang.String  _wl_block325 ="\" id=\"MfrYN";
    private final static byte[]  _wl_block325Bytes = _getBytes( _wl_block325 );

    private final static java.lang.String  _wl_block326 ="\"><!--ML-MMOH-CRF-1014 -->\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"placed_from_verbal_order";
    private final static byte[]  _wl_block326Bytes = _getBytes( _wl_block326 );

    private final static java.lang.String  _wl_block327 ="\" id=\"placed_from_verbal_order";
    private final static byte[]  _wl_block327Bytes = _getBytes( _wl_block327 );

    private final static java.lang.String  _wl_block328 ="\"><!--added FOR GHL-CRF-509 -->\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block328Bytes = _getBytes( _wl_block328 );

    private final static java.lang.String  _wl_block329 ="\t\n\t\t\t\t\t</table>\n\t\t\t\t</div>\n\t\t\t\t<br>\n";
    private final static byte[]  _wl_block329Bytes = _getBytes( _wl_block329 );

    private final static java.lang.String  _wl_block330 ="\n\t\t\t\t";
    private final static byte[]  _wl_block330Bytes = _getBytes( _wl_block330 );

    private final static java.lang.String  _wl_block331 =" \n\t\t\t\t";
    private final static byte[]  _wl_block331Bytes = _getBytes( _wl_block331 );

    private final static java.lang.String  _wl_block332 ="  \n\t\t\t\t";
    private final static byte[]  _wl_block332Bytes = _getBytes( _wl_block332 );

    private final static java.lang.String  _wl_block333 ="\n\t\t\t\t<input type=\"hidden\" name=\"mar_disc_dose_yn\" id=\"mar_disc_dose_yn\"\tvalue=\"";
    private final static byte[]  _wl_block333Bytes = _getBytes( _wl_block333 );

    private final static java.lang.String  _wl_block334 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"mar_iv_compl_dt_ind\" id=\"mar_iv_compl_dt_ind\"\tvalue=\"";
    private final static byte[]  _wl_block334Bytes = _getBytes( _wl_block334 );

    private final static java.lang.String  _wl_block335 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\"\tvalue=\"";
    private final static byte[]  _wl_block335Bytes = _getBytes( _wl_block335 );

    private final static java.lang.String  _wl_block336 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"patient_class\" id=\"patient_class\"\tvalue=\"";
    private final static byte[]  _wl_block336Bytes = _getBytes( _wl_block336 );

    private final static java.lang.String  _wl_block337 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block337Bytes = _getBytes( _wl_block337 );

    private final static java.lang.String  _wl_block338 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\"\t\tvalue=\"";
    private final static byte[]  _wl_block338Bytes = _getBytes( _wl_block338 );

    private final static java.lang.String  _wl_block339 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"patient_id_selected\" id=\"patient_id_selected\" value=\"";
    private final static byte[]  _wl_block339Bytes = _getBytes( _wl_block339 );

    private final static java.lang.String  _wl_block340 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"current_date_time\" id=\"current_date_time\"\tvalue=\"";
    private final static byte[]  _wl_block340Bytes = _getBytes( _wl_block340 );

    private final static java.lang.String  _wl_block341 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"admin_due_date\" id=\"admin_due_date\"\t\tvalue=\"";
    private final static byte[]  _wl_block341Bytes = _getBytes( _wl_block341 );

    private final static java.lang.String  _wl_block342 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"assign_bed_num\" id=\"assign_bed_num\"\t\tvalue=\"";
    private final static byte[]  _wl_block342Bytes = _getBytes( _wl_block342 );

    private final static java.lang.String  _wl_block343 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"nursing_unit\" id=\"nursing_unit\"\t\tvalue=\"";
    private final static byte[]  _wl_block343Bytes = _getBytes( _wl_block343 );

    private final static java.lang.String  _wl_block344 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block344Bytes = _getBytes( _wl_block344 );

    private final static java.lang.String  _wl_block345 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block345Bytes = _getBytes( _wl_block345 );

    private final static java.lang.String  _wl_block346 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"mode\" id=\"mode\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block346Bytes = _getBytes( _wl_block346 );

    private final static java.lang.String  _wl_block347 ="\">\t\n\t\t\t\t<input type=\"hidden\" name=\"non_iv_records\" id=\"non_iv_records\"\t\tvalue=\"";
    private final static byte[]  _wl_block347Bytes = _getBytes( _wl_block347 );

    private final static java.lang.String  _wl_block348 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"func_mode\" id=\"func_mode\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block348Bytes = _getBytes( _wl_block348 );

    private final static java.lang.String  _wl_block349 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"hold_discontinue_yn\" id=\"hold_discontinue_yn\" value=\"";
    private final static byte[]  _wl_block349Bytes = _getBytes( _wl_block349 );

    private final static java.lang.String  _wl_block350 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"administration_status\" id=\"administration_status\" value=\"";
    private final static byte[]  _wl_block350Bytes = _getBytes( _wl_block350 );

    private final static java.lang.String  _wl_block351 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"adr_recorded\" id=\"adr_recorded\"\t\tvalue=\"N\">\n\t\t\t\t<input type=\"hidden\" name=\"admin_recorded\" id=\"admin_recorded\"\t\tvalue=\"N\">\n\t\t\t\t<input type=\"hidden\" name=\"locale\" id=\"locale\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block351Bytes = _getBytes( _wl_block351 );

    private final static java.lang.String  _wl_block352 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"from_time\" id=\"from_time\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block352Bytes = _getBytes( _wl_block352 );

    private final static java.lang.String  _wl_block353 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"to_time\" id=\"to_time\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block353Bytes = _getBytes( _wl_block353 );

    private final static java.lang.String  _wl_block354 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"userAuthPINYN\" id=\"userAuthPINYN\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block354Bytes = _getBytes( _wl_block354 );

    private final static java.lang.String  _wl_block355 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"adminFromDateTime\" id=\"adminFromDateTime\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block355Bytes = _getBytes( _wl_block355 );

    private final static java.lang.String  _wl_block356 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"adminToTime\" id=\"adminToTime\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block356Bytes = _getBytes( _wl_block356 );

    private final static java.lang.String  _wl_block357 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"dob\" id=\"dob\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block357Bytes = _getBytes( _wl_block357 );

    private final static java.lang.String  _wl_block358 ="\"><!--IN066125-->\n\t\t\t</form>\n\t\t</body>\n\t\t<div name=\"tooltiplayer\" id=\"tooltiplayer\" style=\"position:absolute; width:10%;visibility:hidden;\" bgcolor=\"blue\">\n\t\t\t<table id=\"tooltiptable\" cellpadding=0 cellspacing=0 border=\"0\" width=\"100%\" height=\"100%\" align=\"center\">\n\t\t\t\t<tr><td id=\"tooltiptd\"></td></tr>\n\t\t\t</table>\n\t\t</div>\n\t</html>\n";
    private final static byte[]  _wl_block358Bytes = _getBytes( _wl_block358 );
	
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
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);
 
try{
	System.out.println("==============in==========>MARSchLevelDrugDetails.jsp");
 		request.setCharacterEncoding("UTF-8");
		String locale					= (String) session.getAttribute("LOCALE");
		String sStyle					=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String patient_class			=	 request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
		String patient_id_test			=	 request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
//		String order_id_test			=	 request.getParameter("order_id");
//		String order_line_no_test       =	 request.getParameter("order_line_no")==null?"":request.getParameter("order_line_no");
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
		String mar_disc_dose_yn		=	 request.getParameter("mar_disc_dose_yn")==null?"":request.getParameter("mar_disc_dose_yn");	
		String mar_iv_compl_dt_ind	=	 request.getParameter("mar_iv_compl_dt_ind")==null?"":request.getParameter("mar_iv_compl_dt_ind");	
		String Auto_Admin	=    "", recExists="", schKey="";
		String future_date_time		            =	"";    // Added for GHL-CRF-0482 [IN:064955]
		String future_admin          = ""; // Added for GHL-CRF-0482 [IN:064955]
				String cancel_recorded_yn="Y";//ADDED FOR JD-CRF-0200
				String verification_status = "N";//added for MMS-KH-SCF-0056
//		float ret_qty=0;
		int prevSch=0;
//		float returned_qty=0;
//		float tot_administered_qty=0;
//		float disp_qty=0;
//		float ward_return_qty=0;
		boolean allowPRNAdmin= true, prevAllowPRNAdmin=false;;
		DecimalFormat dfTest = new DecimalFormat("0.########");

		if(route_admin.equals("undefined")){
			   route_admin="";
		}
		if(admin_route_categ.equals("undefined")){
			   admin_route_categ="";
		}
		String dob	=	 request.getParameter("dob")==null?"":request.getParameter("dob");//IN066125

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            _bw.write(_wl_block9Bytes, _wl_block9);
 
			String bean_id_all_stages				= "DispMedicationAllStages" ;
			String bean_name_all_stages				= "ePH.DispMedicationAllStages";
			DispMedicationAllStages bean_all_stages = (DispMedicationAllStages)getBeanObject( bean_id_all_stages, bean_name_all_stages, request ) ;
			bean_all_stages.setLanguageId(locale);
			bean_all_stages.setModuleId("1");
//			ArrayList multi_drugs					=  bean_all_stages.getMultiDrugs(patient_id_test,patient_id_test,order_line_no_test);	
			String bean_id							= "MedicationAdministrationFTBean";
			String bean_name						= "ePH.MedicationAdministrationFTBean";
			MedicationAdministrationFTBean bean		= (MedicationAdministrationFTBean)getBeanObject( bean_id, bean_name, request );
			bean.setLanguageId(locale);
			bean.setCurrentTimeAndAdminWithinHRS();
			bean.clearDrugDetails();
			if(dob==null || dob.equals("")) //added for ARYU-SCF-023
				dob = bean.getPatientDOB(patient_id_test);

			String drug_search_bean_id				= "DrugSearchBean";
			String drug_search_bean_name			= "ePH.DrugSearchBean";
			DrugSearchBean drug_bean				= (DrugSearchBean)getBeanObject( drug_search_bean_id, drug_search_bean_name , request);
			drug_bean.setLanguageId(locale);

			String admin_bean_id						=	  "MedicationAdministrationBean";
			String admin_bean_name						=	  "ePH.MedicationAdministrationBean";
			MedicationAdministrationBean admin_bean		=	  (MedicationAdministrationBean)getBeanObject( admin_bean_id, admin_bean_name, request );
			admin_bean.setLanguageId(locale);
			int admin_within_hrs =  0; // Added for GHL-CRF-0482 - Start
			if(bean.getCurrentTimeAndAdminWithinHRS().size()>2){
				admin_within_hrs = Integer.parseInt(bean.getCurrentTimeAndAdminWithinHRS().get(1).toString()); 
			} // Added for GHL-CRF-0482 - End
			
			ArrayList AdminDateresult						= bean.getCurrentTimeAndAdminWithinHRS();
			String current_date_time				= (String)AdminDateresult.get(0);
			String userAuthPINYN=bean.getUserAuthPINYN(facility_id); //RUT-CRF-0035 [IN029926] Added for User Auth PIN Validation
			//ArrayList result = bean.getCurrentTimeAndAdminWithinHRS();
			String adminFromDateTime		= bean.getFromDateTime(com.ehis.util.DateUtils.convertDate(current_date_time, "DMYHM",locale,"en"));
			String adminToTime			= bean.getAdiminWindowToDateTime(com.ehis.util.DateUtils.convertDate(current_date_time, "DMYHM",locale,"en"));
			if(!locale.equals("en")){
				adminFromDateTime = com.ehis.util.DateUtils.convertDate(adminFromDateTime, "DMYHM",locale,"en");
				adminToTime = com.ehis.util.DateUtils.convertDate(adminToTime, "DMYHM",locale,"en");
				from_time = com.ehis.util.DateUtils.convertDate(from_time, "DMY",locale,"en");
				to_time = com.ehis.util.DateUtils.convertDate(to_time, "DMY",locale,"en");
			}

			HashMap	drug_details		  =	(HashMap) bean.getDrugDetailsSchLevel(encounter_id,hold_discontinue_yn,administration_status,order_type, adminFromDateTime, adminToTime,display_order_by,route_admin,admin_route_categ,from_time,to_time);
			ArrayList altDateDayList = admin_bean.getDateDayList(from_time,to_time, "W");
			int daySize=0;
			int dispSizeMms=0;//added for MMS-KH-CRF-0010
			int adr_count =0;
			if(altDateDayList!=null && altDateDayList.size()>0)
				daySize = altDateDayList.size();
			String iv_prep_yn			   =	"";
			String title				   =	"";
			String order_status            ="";//ADDED FOR MMS-KH-SCF-0056
			String patient_id					=   "";
			//int no_of_alt_drus_selected			=   0;	
			LinkedHashMap	hmNonIVDrugDetails				=	(LinkedHashMap) drug_details.get("NON_IV");
			LinkedHashMap hmIVDrugDetails				    =	 (LinkedHashMap) drug_details.get("IV");
			HashMap hmSchList				    =	 (HashMap) drug_details.get("SCHLIST");
			ArrayList	non_iv_drug_details	=null;
			ArrayList	alTmpOrderSchDetail	=null;
//			ArrayList iv_drug_details =null;
			List OrdersList = null;
			Set uniqueSchedules = null;
			String Store_locn_code				=	"";
			String sch_date_time="";
			String Storelocn_code				=	"";
			String drug_code="", drug_desc="", drug_class="", drug_class_ind, freq_desc;
			String  route_desc, pres_catg_code, prn_remarks,medn_admn_dtl_reqd_yn="", slidingscaleremarks, ext_prod_id="", trade_code, imageFileURL, schedule_uom_desc, schedule_uom_code, patient_brgt_medn, sliding_scale_applicable, strength_value, adminsted_pat_brought_medn, dosage_type="", dosage="", dosage_uom_code="", dosage_uom_desc="", content_in_pres_base_uom="", start_date_time="", end_date_time="", end_date="", start_date="";
			String dosage_uom_desc_sch="";//added forML-MMOH-SCF-1463
			String sch_strength_uom, admn_dose_chng_reason_code, onco_direct_drug_count="",  linkVacScheduleCode="", performingDeptLocCode, dose_uom_desc,  verificationremarks="", pres_remarks="", drug_remarks="",pharma_remarks="", show_remarks="", order_pract_id="", route_color="", fntColor="" ,backGrndColor="", sch_strength_value ,sch_strength_uom_desc, store_code="", disp_drug_code  ;
		//verificationremarks, pres_remarks, drug_remarks,pharma_remarks uncommented for mms-kh-crf-0010
    	HashMap overridereason = null;
			String classvalue ="", linkVacScheduleCode1="";
			String[] vacScheduleDetails;
			String order_id="", order_line_num="", dayLegend="", schDate="", dispDate="", schTime = "",dispensed_drug_desc="",disp_drugs="",dispense_drug_code="";
			String administered_yn="", admin_recorded_yn ="", doseDisplay="", non_iv_admin_quaty, displayStyle="", displayFreqStyle="";
			String strength_per_value_pres_uom = "1",qty="", pres_dosage="", fieldname="", dose_uom_desc1="", tempDosage="" , freq_nature="", freq_code="", dosage_seq_no="", 	admin_drug_code	    =  "", admin_drug_desc 	=  "", admindrugdetails;
			String admin_dose_prn="", remarks="", discontinued="", hold="", admin_by_name, auth_by_name,  admin_date_time, modified_date_time="", showAlt="", scheKey ="", schCanAdmin="", admin_rec_disp="", split_dose_yn="", temp="", prn_qty_desc="", prn_admin_date="", callMenu="", prnSrlNo="", stDispHand="", sch_dosage_qty="";//iv_sch_date_tim Added for SKR-SCF-0913[Inc : 46556]
			String admin_uom = "";//BRU-CRF-399.1
			StringBuilder showTitle = new StringBuilder();
			StringTokenizer stadmindrugdetails	=	null;
//			StringTokenizer stiv_incred			=	null;	
			//String pract_id						=	"";	
			String mfrRemarks					=	"";
			String against_sch_date				=	"";
			String adr_reason					=	"";		String adr_remarks					=	"";
			String adr_record_time				=	"";		String adr_recorded_by				=	"";
			String adr_details					=	"";	
			String adminStatus="";
			String encode_drug_desc				=   "";//ADDED FOR MMS-KH-CRF-0010
			encode_drug_desc= drug_desc.replaceAll(" ","%20");
			encode_drug_desc= java.net.URLEncoder.encode(encode_drug_desc,"UTF-8");
			encode_drug_desc= encode_drug_desc.replaceAll("%2520","%20");
			drug_desc=encode_drug_desc;
//			String next_schd_date				=	"";		String AdUOM						=	"";
			String demostring					=  "\\\'\'";
			String linkVacScheduleDescToolTip	=	"";		String linkVacScheduleYN			=	"N";
			//String nonMfrFluidRemarks			=	"";		
			String linkVacScheduleDesc ="";
      //remarks_style added for mms-kh-crf-0010
			String remarks_style="",/*,  batch_id="", flag="", item_code="", expiry_date ="", AdminBackLogTime="", defaultBatch="", defaultExpiryDate="", defaultTradeId ="", trade_id="" */ ord_hold_date_time="", ord_disc_date_time="", discontinued_sch="", discontinued_dose="", hold_sch="", prev_freq_nature="", prev_end_date="",  prev_order_line_num="", prev_order_id="",prev_dosage_seq_no="", prev_schDate="", prev_schTime="", prev_dosage="", prev_dosage_uom_code="", prev_discontinued_dose="", prev_discontinued_sch="", prev_hold_sch="", prev_displayStyle="", prev_sch_date_time="", prev_hold="", prev_discontinued="";

			int orderCount		 = 0, prev_orderCount =0;
			int recCount = 0;
			int dialog_height = 0;//uncommented for mms-kh-crf-0010
			int rowsPan = 1;
			int schSize = 1;
			int schDayCount =0;
			int dayCount=0;
			int temp1                           =   0;
			int temp2                           =   0;		
			int temp3                           =   0;		
			int ppn_count						=   0;
			String couldAdminReason="";//ADDED FOR MMS-KH-CRF-0010
			String adminReasondDetails="";//ADDED FOR MMS-KH-CRF-0010
//			String prev_key="", curr_key="";
			int sch =0, prn_doseCount=0,  prev_prnSrlNo=0, i_prnSrlNo=1, schCount=0, prevSchCount=0;
			boolean isSite_spec_patient_stock = bean.isSiteSpecific("PH","PATIENT_STOCK_REQUIRED");//ADDED FOR GHL-CRF-0482
			//isSite_spec_patient_stock = true;
			boolean viewAdminRemarks =bean.isSiteSpecific("PH","VIEW_ADMIN_REMARKS");//ADDED FOR MMS-KH-CRF-0010
			String user_id=(String)session.getValue("login_user");//ADDED FOR JD-CRF-0200
			String cancelYn=bean.getMedicationAdminstrationRights(user_id); //ADDED FOR JD-CRF-0200
			if(viewAdminRemarks){//Added for MMS-KH-CRF-0010
				dispSizeMms=8;
				}
			else
				dispSizeMms=7;
				
			
			if((hmNonIVDrugDetails.size()==0) &&(hmIVDrugDetails.size()==0)){

            _bw.write(_wl_block10Bytes, _wl_block10);
		
				return;
			}
			else{

            _bw.write(_wl_block11Bytes, _wl_block11);
		
			}
			if(hmNonIVDrugDetails.size()>0){

			    future_date_time   = com.ehis.util.DateUtils.plusDate(current_date_time,"DMYHM",locale,admin_within_hrs,"h").toString();   // Added for GHL-CRF-0482 [IN:064955] - Start				
				
			    if(admin_bean.getEarlyOrLateAdminYn().equals("Y")){ 
					future_admin = "";
			    }
			    
			    if(admin_bean.getEarlyOrLateAdminYn().equals("Y") && admin_bean.compareDates(future_date_time,sch_date_time) &&  !(freq_nature.equals("P"))){
					future_admin = "F";
                            } // Added for GHL-CRF-0482 [IN:064955] - End

            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
if(viewAdminRemarks){
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
} 
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
 //moved from down to up for GHL-CRF-0482
							iv_prep_yn				=    (String)drug_details.get("iv_prep_yn");
							if(iv_prep_yn == null)
							iv_prep_yn =    "";
						
							if(function_from.equals("CP"))
							iv_prep_yn	=	bean.IVType(order_id);

							if(isSite_spec_patient_stock){ 
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
}
							
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

							if(altDateDayList!=null && altDateDayList.size()>0){
								daySize = altDateDayList.size();
								for(int day=0; day<daySize; day+=2){
									dayLegend = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common."+(String)altDateDayList.get(day+1)+".label", "common_labels");

            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(((String)altDateDayList.get(day)),"DMY","en",locale)));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(dayLegend));
            _bw.write(_wl_block26Bytes, _wl_block26);

								}
							}

            _bw.write(_wl_block27Bytes, _wl_block27);

					if(!order_type.equals("A")){ 
					/*	iv_prep_yn				=    (String)drug_details.get("iv_prep_yn"); //commented moved to up GHL-CRF-0482
						if(iv_prep_yn == null)
							iv_prep_yn =    "";
						if(function_from.equals("CP"))
							iv_prep_yn	=	bean.IVType(order_id); */
						if(iv_prep_yn.equals("7") || iv_prep_yn.equals("8"))
							title	   =	com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.TPN.label", "ph_labels");
						else if(iv_prep_yn.equals("0") || iv_prep_yn.equals("9"))
							title	   =	com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Oncology.label", "ph_labels");
						else
							title	   =   com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.NON_IV.label", "ph_labels");

            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf((daySize/2)+dispSizeMms));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(title));

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
	
					}
					OrdersList = new ArrayList(hmNonIVDrugDetails.keySet());
	//added for GHL-CRF-0458 - start
					//boolean isSiteSpecMARPrint = bean.isSiteSpecific("PH","WARD_ACK");//GHL-CRF-0458 and changed MAR_PRINT_YN to WARD_ACK for AMS-CRF-0203 // commented for MMS-KH-CRF-0014 [IN:067953]
			        String WardAckMarRequiredYn = admin_bean.getWardAckMarRequiredYn(); //Added for MMS-KH-CRF-0014 [IN:067953]
			        String verification_req_yn=admin_bean.getverfreqdbefmedAdmin();//added for MMS-KH-SCF-0056
					boolean issitespec_verbal_order_yn = bean.isSiteSpecific("PH","PLACED_VERBAL_ORDER_YN");//ADDED FOR GHL-CRF-0509
					boolean marForDisPatNotReqYN = bean.isSiteSpecific("PH", "MAR_FOR_DISC_PAT_NOT_REQ_YN"); // Added for KH-SCF-0010
					boolean dischargedYN = bean.getDischargedStatus(encounter_id); // Added for KH-SCF-0010
					String orderID = "";
					String orderLineNum = "";
					String ack_yn = "";
					String patient_class_ord = "";
					String mfr_yn	= "N";//ML-MMOH-CRF-1014
					String statusString = "";//ML-MMOH-CRF-1014
					String placed_from_verbal_order="N";//added for ghl-crf-0509
				//added for GHL-CRF-0482 - start
					String patient_stock_status_str = "";
					String patient_stock_status_str_disp = "";
//					String order_id_for_drug	= "";
					//String order_line_no_for_drug = "";
					String patient_stock_completed="";
					String patient_stock_required = "";
					patient_brgt_medn = "";
					HashMap drugMap = new HashMap();
					HashMap hm_iv_prep = new HashMap();//MMS-KH-CRF-0039
					ArrayList orderList = new ArrayList();
					HashMap hmPatientStockStatusForOrder = new HashMap(); 
					for (int i=0;i<OrdersList.size();i++){
						iv_prep_yn="";//MMS-KH-CRF-0039
						orderID = ((String)OrdersList.get(i)).split("_")[0];
						orderLineNum = ((String)OrdersList.get(i)).split("_")[1];
						alTmpOrderSchDetail = (ArrayList)hmNonIVDrugDetails.get((String)OrdersList.get(i));
						for(int j=0; j<alTmpOrderSchDetail.size(); j++){
							patient_stock_status_str = "";
							non_iv_drug_details	   = (ArrayList)alTmpOrderSchDetail.get(j);
							administered_yn        = (String)non_iv_drug_details.get(21);
							admin_recorded_yn      = (String)non_iv_drug_details.get(22);
							patient_brgt_medn      = (String)non_iv_drug_details.get(58);
							disp_drug_code		   = (String)non_iv_drug_details.get(0);
							iv_prep_yn			   = (String)non_iv_drug_details.get(44)==null?"":(String)non_iv_drug_details.get(44);
						
							hm_iv_prep.put(orderID,iv_prep_yn);//MMS-KH-CRF-0039
							if(iv_prep_yn.equals("")){
								if(drugMap!=null ){
								 if(drugMap.containsKey(disp_drug_code)){
									 orderList = (ArrayList)drugMap.get(disp_drug_code);
									if(!orderList.contains(orderID)){
										orderList.add(orderID);
										orderList.add(orderLineNum);
										drugMap.put(disp_drug_code,orderList);
									}
								 }else{
										orderList = new ArrayList();
										orderList.add(orderID);
										orderList.add(orderLineNum);
										drugMap.put(disp_drug_code,orderList);
								 }
								} 
							
								patient_stock_required = (String)non_iv_drug_details.get(93)==null?"N":(String)non_iv_drug_details.get(93);
								patient_stock_completed = (String)non_iv_drug_details.get(94)==null?"N":(String)non_iv_drug_details.get(94);
							}
							if(patient_brgt_medn.equals("Y") || patient_stock_required.equals("N")){
								patient_stock_status_str = "NA";
								break;
							}
							if(administered_yn.equals("N") && patient_stock_completed.equals("N")){
								patient_stock_status_str = "A";
								break;
							}else{
								patient_stock_status_str = "C";
							}
						}
						hmPatientStockStatusForOrder.put(orderID+orderLineNum,patient_stock_status_str);
					}
					bean.setOrderIdListForSameDrug(drugMap); //added for GHL-CRF-0482

//added for GHL-CRF-0482 - end
				//added for GHL-CRF-0458 - end
				for (int i=0;i<OrdersList.size();i++){
					mfr_yn = "N";//ML-MMOH-CRF-1014
					patient_stock_status_str_disp = ""; //added for GHL-CRF-0482
					alTmpOrderSchDetail = (ArrayList)hmNonIVDrugDetails.get((String)OrdersList.get(i));
					schSize=1;
					sch =0;
					prn_doseCount=0;
					allowPRNAdmin = true;
					//if(schCount>4)
						//rowsPan = 4;
	
					//added for GHL-CRF-0458 - start
					orderID = ((String)OrdersList.get(i)).split("_")[0];
					orderLineNum = ((String)OrdersList.get(i)).split("_")[1];
					patient_class_ord = bean.getOrderPatientClass(orderID);
						if(patient_class_ord==null)
							patient_class_ord = "";
					if(WardAckMarRequiredYn.equalsIgnoreCase("Y") && patient_class_ord.equals("IP")){ // isSiteSpecMARPrint changed to WardAckMarRequiredYn for MMS-KH-CRF-0014 [IN:067953]
					   iv_prep_yn = (String)hm_iv_prep.get(orderID)==null?"":(String)hm_iv_prep.get(orderID);//MMS-KH-CRF-0039

						ack_yn	= bean.getAcknowlegeYN(orderID,orderLineNum,iv_prep_yn);
						if(ack_yn==null)
							ack_yn = "";
					}
					//added for GHL-CRF-0458 - end	
					//added for GHL-CRF-0482 - start
					patient_stock_status_str = (String)hmPatientStockStatusForOrder.get(orderID+orderLineNum);
					if(patient_stock_status_str.equals("C"))
						patient_stock_status_str_disp = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.completed.label", "common_labels");
					else if(patient_stock_status_str.equals("A"))
						patient_stock_status_str_disp = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.available.label", "common_labels");
					else
						patient_stock_status_str_disp = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.notapplicable.label", "common_labels");
					//added for GHL-CRF-0482 - end
					for(sch=0; sch<alTmpOrderSchDetail.size(); sch++){
						showAlt="";
						recExists = "Y";
						non_iv_drug_details = (ArrayList)alTmpOrderSchDetail.get(sch);
						drug_code		= (String)non_iv_drug_details.get(28);	
						disp_drug_code		= (String)non_iv_drug_details.get(0);	
						drug_desc		= (String)non_iv_drug_details.get(1);
						encode_drug_desc= drug_desc.replaceAll(" ","%20");
						encode_drug_desc= java.net.URLEncoder.encode(encode_drug_desc,"UTF-8");
						encode_drug_desc= encode_drug_desc.replaceAll("%2520","%20");
						//drug_desc=encode_drug_desc;
						qty				= (String)non_iv_drug_details.get(2)==null?"0":(String)non_iv_drug_details.get(2);
						dose_uom_desc	= (String)non_iv_drug_details.get(3); 
						order_id	    = (String)non_iv_drug_details.get(13);
						order_line_num  = (String)non_iv_drug_details.get(14);
						order_status=bean.getOrderstatus(order_id,order_line_num);//added for mms-kh-scf-0056	
						sch_date_time   = (String)non_iv_drug_details.get(16);
						dosage_seq_no		= (String)non_iv_drug_details.get(17);
						discontinued		= (String)non_iv_drug_details.get(19);
						hold				= (String)non_iv_drug_details.get(20);
						administered_yn  = (String)non_iv_drug_details.get(21);
						admin_recorded_yn  = (String)non_iv_drug_details.get(22);
						admindrugdetails  = (String)non_iv_drug_details.get(24);
						admin_by_name = (String)non_iv_drug_details.get(25)==null?"":(String)non_iv_drug_details.get(25);
						drug_class	= (String)non_iv_drug_details.get(30);
						auth_by_name  = (String)non_iv_drug_details.get(31)==null?"":(String)non_iv_drug_details.get(31);
						end_date_time	= (String)non_iv_drug_details.get(32);
						freq_code	  = (String)non_iv_drug_details.get(33);
						freq_nature	  = (String)non_iv_drug_details.get(34);
						//prnSrlNo	  = (String)non_iv_drug_details.get(35);
		//System.err.println("==order_id=="+order_id+"==freq_nature===>"+freq_nature);
						prnSrlNo	  = sch+"";
						adr_reason			= (String)non_iv_drug_details.get(38);
						adr_remarks			= (String)non_iv_drug_details.get(39);
						adr_record_time		= (String)non_iv_drug_details.get(40);
						adr_recorded_by		= (String)non_iv_drug_details.get(41);

						pres_dosage			= (String)non_iv_drug_details.get(42);
						iv_prep_yn			= (String)non_iv_drug_details.get(44);
						route_desc			= (String)non_iv_drug_details.get(54);
						pres_catg_code		= (String)non_iv_drug_details.get(55);							
						medn_admn_dtl_reqd_yn	= (String)non_iv_drug_details.get(45);

						prn_remarks			= (String)non_iv_drug_details.get(46);	
						slidingscaleremarks	= (String)non_iv_drug_details.get(47);
						ext_prod_id			= (String)non_iv_drug_details.get(50);
						trade_code			= (String)non_iv_drug_details.get(51);
						imageFileURL		= (String)non_iv_drug_details.get(52);
						schedule_uom_desc	= (String)non_iv_drug_details.get(56);
						schedule_uom_code	= (String)non_iv_drug_details.get(57);
						patient_brgt_medn	= (String)non_iv_drug_details.get(58);
						sliding_scale_applicable	= (String)non_iv_drug_details.get(59);
						strength_value	= (String)non_iv_drug_details.get(60);
						sch_strength_value	=(String)non_iv_drug_details.get(61);
						adminsted_pat_brought_medn	= (String)non_iv_drug_details.get(62);
						dosage_type			= (String)non_iv_drug_details.get(63);
						dosage				= (String)non_iv_drug_details.get(64);
						dosage_uom_code		= (String)non_iv_drug_details.get(65);
						dosage_uom_desc		= (String)non_iv_drug_details.get(66);
						content_in_pres_base_uom= (String)non_iv_drug_details.get(67);
						sch_strength_uom	= (String)non_iv_drug_details.get(68);
						sch_strength_uom_desc	= (String)non_iv_drug_details.get(69);	
						admn_dose_chng_reason_code	=  (String)non_iv_drug_details.get(70);	
						onco_direct_drug_count		= (String)non_iv_drug_details.get(71);
						linkVacScheduleCode			= (String)non_iv_drug_details.get(72);
						performingDeptLocCode		= (String)non_iv_drug_details.get(73);
						start_date_time	= (String)non_iv_drug_details.get(77);
						freq_desc	= (String)non_iv_drug_details.get(78);
						schDate	= (String)non_iv_drug_details.get(79);
						schTime	= (String)non_iv_drug_details.get(80);
						schCanAdmin	= (String)non_iv_drug_details.get(81);
						split_dose_yn	= (String)non_iv_drug_details.get(82);
						ord_hold_date_time	= (String)non_iv_drug_details.get(83);
						ord_disc_date_time	= (String)non_iv_drug_details.get(84);
						sch_dosage_qty	= (String)non_iv_drug_details.get(85);
						dispensed_drug_desc	= (String)non_iv_drug_details.get(86);
						disp_drugs = (String)non_iv_drug_details.get(87);
						dispense_drug_code = (String)non_iv_drug_details.get(88);
						mfr_yn			   = (String)non_iv_drug_details.get(90);//ML-MMOH-CRF-1014
						mfrRemarks			   = (String)non_iv_drug_details.get(91);//ML-MMOH-CRF-1014
						placed_from_verbal_order=(String)non_iv_drug_details.get(92);//added for ghl-crf-0509
						cancel_recorded_yn=(String)non_iv_drug_details.get(96)== null?"N":(String)non_iv_drug_details.get(96);//ADDED FOR JD-CRF-0200
						couldAdminReason=(String)non_iv_drug_details.get(97)== null?"N":(String)non_iv_drug_details.get(97);//ADDED FOR MMS-KH-CRF-0010
						adminReasondDetails=(String)non_iv_drug_details.get(23)== null?"N":(String)non_iv_drug_details.get(23);//ADDED FOR MMS-KH-CRF-0010
						//added for MMS-KH-CRF-0010 start
						verificationremarks		= bean_all_stages.getVerificationRemarks(order_id,order_line_num);
						overridereason			= (HashMap)bean_all_stages.getOverrideremarks(order_id,order_line_num);
						pres_remarks			= bean.getPrescriptionInstructions(order_id);
						drug_remarks			= bean.getDrugInstructions(order_id,order_line_num);
						pharma_remarks			= bean.getPharmacistInstructions(order_id,order_line_num);
						show_remarks		= "N";
						//added for MMS-KH-CRF-0010	 end
						
						System.out.println("590 non_iv_drug_details"+non_iv_drug_details);
						if(admin_bean.getEarlyOrLateAdminYn().equals("Y")){ // Added for GHL-CRF-0482 [IN:064955] - Start
							future_admin = "";
					        }
						if(admin_bean.getEarlyOrLateAdminYn().equals("Y") && admin_bean.compareDates(future_date_time,sch_date_time) &&  !(freq_nature.equals("P"))){
							future_admin = "F";
						}
						
						if(dispense_drug_code.equals(""))
							dispense_drug_code = drug_code;
						adminsted_pat_brought_medn	= adminsted_pat_brought_medn.trim();
						if(freq_nature.equals("P") && sch_dosage_qty.equals("0")){
							schCanAdmin = "N";
							allowPRNAdmin = false;
							prevAllowPRNAdmin = false;
						}//added for ML-MMOH-SCF-1964 start
						 if(qty!=null && !qty.equals("") && freq_nature.equals("P")){
							 sch_dosage_qty =Float.toString( Float.parseFloat(sch_dosage_qty)*Float.parseFloat(content_in_pres_base_uom))+"";
						}
						//added for MMS-KH-SCF-0182 start
						if(sch_dosage_qty.equals("0")){	
							sch_dosage_qty="0.0";	
						} 
						//added MMS-KH-SCF-0182 end
								int len1= sch_dosage_qty.length();
								if( len1 > 0 ){
									temp = sch_dosage_qty;
									int point= temp.indexOf(".")+1;
									if(temp.charAt(point)=='0')
										sch_dosage_qty = sch_dosage_qty.substring(0,point-1);
									else{//added for SKR-SCF-1429 - start
										if(Float.parseFloat(sch_dosage_qty)>1){ 
										if(temp.charAt(point)=='6' || temp.charAt(point)=='7' || temp.charAt(point)=='8' || temp.charAt(point)=='9'){
											sch_dosage_qty = Math.ceil(Float.parseFloat(sch_dosage_qty))+"";
										}
										}
									} 
								}//added for ML-MMOH-SCF-1964 end
						doseDisplay = "";
						non_iv_admin_quaty="";
						discontinued_dose = "N";
						if(sch_date_time.equals(ord_disc_date_time))
							discontinued_dose="Y";
						tempDosage				=	dosage;
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
						/*if(sliding_scale_applicable.equals("Y") && sliding_scale_details.size()>0){	
							if(sliding_scale_applicable.equals("Y") && batch_ids.size()==0){	
								select_status_1="disabled";
							}
						}
						else{
						*/
						if(admindrugdetails != null){ //if block moved from down to up for AAKH-SCF-0210 [IN:055624]
							stadmindrugdetails = new StringTokenizer(admindrugdetails,":");
							if(stadmindrugdetails.hasMoreTokens()){
								admin_drug_code = stadmindrugdetails.nextToken();
								if(stadmindrugdetails.hasMoreTokens())
									admin_drug_desc = stadmindrugdetails.nextToken();
								if(stadmindrugdetails.hasMoreTokens())
									admin_dose_prn  = stadmindrugdetails.nextToken();	
								if(stadmindrugdetails.hasMoreTokens())
									admin_uom = stadmindrugdetails.nextToken();//admin_uom added for BRU-CRF-399.1
							}
						}
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
						if(freq_nature.equals("P")){													
							if(administered_yn.equals("Y"))//if block added for AAKH-SCF-0210 [IN:055624]
								qty=admin_dose_prn;
							if(!dosage_seq_no.equals("2")){ //dosage sequence number will start from 2 only, for PRN orders
								dosage=sch_strength_value;
								dosage_uom_code=sch_strength_uom;
								dosage_uom_desc=dosage_uom_desc;// changed from sch_strength_uom_desc_prn to dosage_uom_desc for incident No:32773
							}	
							/*if(dosage_type.equals("Q") && !disp_drug_code.equals(drug_code)){//in case of alternate drug dispense and order by quantity, calculate new dosage- abdul 02/09/10
								ArrayList listArray=bean.getAlternateDrugsEqualQuantity(dosage,drug_code,disp_drug_code);
								if(listArray!=null){
									dosage=(String)listArray.get(0);
									dosage_uom_desc=(String)listArray.get(1);
								}
							}	*/			
							fieldname="non_iv_admin_qty_"+orderCount;
							dose_uom_desc1=dose_uom_desc;
							fieldname   = "non_iv_admin_qty1_"+orderCount;
							dose_uom_desc1 = schedule_uom_desc; 
							pres_dosage = tempDosage;
							if(qty!=null && !qty.equals("") && !administered_yn.equals("Y"))//!administered_yn.equals("Y") added for AAKH-SCF-0210 [IN:055624]
								qty =Float.toString( Float.parseFloat(qty)*Float.parseFloat(content_in_pres_base_uom));
							int len= qty.length();
							if( len > 0 ){
								temp = qty;
								int point= temp.indexOf(".")+1;
								if(temp.charAt(point)=='0')
									qty = qty.substring(0,point-1);
							}
							if(dosage_type.equals("S"))
								prn_qty_desc = dose_uom_desc;
							else
								prn_qty_desc = dosage_uom_desc;
						}
						else{ 
						/*if(dosage_type.equals("Q") && !disp_drug_code.equals(drug_code)){//in case of alternate drug dispense and order by quantity, calculate new dosage- abdul 02/09/10
								ArrayList listArray = bean.getAlternateDrugsEqualQuantity(qty,drug_code,disp_drug_code);							
								if(listArray!=null){
									qty=(String)listArray.get(0);
									dose_uom_desc=(String)listArray.get(1);
								}
						}*/
						if(qty.equals(""))
							qty = "0";
							if(Float.parseFloat(qty) < 1.0){
								//qty = dfTest.format(Float.parseFloat(qty)); //added for ML-MMOH-SCF-1767
								 if(qty.indexOf(".")!=-1){ //added for ML-MMOH-SCF-1674
										String f_qty = qty.substring(qty.indexOf("."),qty.length());
										if(f_qty.length()>8)
											qty = dfTest.format(Float.parseFloat(qty));
										   
										 qty =Float.parseFloat(qty)+"";
								}
							}									
						}
						if(dosage_type.equals("S")){
							strength_per_value_pres_uom = bean.getStrengthPerValuePresUOM(drug_code);
							/*non_iv_admin_quaty=new Float(((Float.parseFloat(dosage)/Float.parseFloat(strength_value))*Float.parseFloat(strength_per_value_pres_uom))/Float.parseFloat(content_in_pres_base_uom))+"";	
							if(Float.parseFloat(non_iv_admin_quaty)>Float.parseFloat(qty)){
								non_iv_admin_quaty=qty; 
							}	*/
							dosage = pres_dosage;
						}
						else{
							/*non_iv_admin_quaty=new Float(Float.parseFloat(dosage)/Float.parseFloat(content_in_pres_base_uom))+"";			
							if(Float.parseFloat(non_iv_admin_quaty)>Float.parseFloat(qty)){
								non_iv_admin_quaty=qty;
							}*/
							dosage = pres_dosage;
						}
						try{
							if(Float.parseFloat(dosage) < 1.0)
								dosage = Float.parseFloat(dosage)+"";
						}
						catch(Exception e){
							System.err.println("=====order_id=>"+order_id+" ===order_line_num====>"+order_line_num+"=====>"+dosage_seq_no+"==="+dosage);
							e.printStackTrace();
						}
						//if(admindrugdetails != null){} moved from here to above for AAKH-SCF-0210 [IN:055624] 
						admin_drug_code = "";
						if(administered_yn.equals("Y")){
							dosage_uom_desc_sch = bean.getUomDisplay(facility_id,admin_uom);//BRU-CRF-399.1//dosage_uom_desc canged to dosage_uom_desc_sch  ML-MMOH-SCF-1463
							if(dosage_uom_desc_sch.equals(""))
								dosage_uom_desc_sch = dose_uom_desc;//MMS-KH-SCF-0064
							doseDisplay = qty+" "+dosage_uom_desc_sch+" / ";//dosage_uom_desc canged to dosage_uom_desc_sch forML-MMOH-SCF-1463
						}
						if(remarks==null){
							remarks="Not Entered";
						}
						if(showTitle.length()>0)
							showTitle.setLength(0);
						if(remarks!=null && !remarks.equals(""))
							showTitle.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.remarks.label", "common_labels")+"  : "+remarks+"\n ");
						/*if(admin_by_name!=null && !admin_by_name.equals(""))
							showTitle.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.AdministeredBy.label", "common_labels")+"   : "+admin_by_name);*/
 
						

						admin_date_time = (String)non_iv_drug_details.get(26);

						if(admin_date_time==null) //null handled for MMS-KH-CRF-0017.1
							admin_date_time="";
						prn_admin_date="";
						if(!admin_date_time.equals("")){
							//if(!locale.equals("en"))
								//admin_date_time = com.ehis.util.DateUtils.convertDate(admin_date_time, "DMYHM",locale,"en");
							prn_admin_date = admin_date_time.substring(0,10);
						}
						modified_date_time = "";
						if(non_iv_drug_details.get(27)!= null){
							modified_date_time = (String)non_iv_drug_details.get(27);
						}
						if(admin_recorded_yn.equals("Y")){//added for MMS-DM-SCF-0453 
							if(administered_yn.equals("N")){
							if(admin_by_name!=null && !admin_by_name.equals(""))
								if(viewAdminRemarks){
								showTitle.append("Reason: "+couldAdminReason+"\n");//ADDED FOR MMS-KH-CRF-0010
							    showTitle.append("Remarks: "+adminReasondDetails+"\n");//ADDED FOR MMS-KH-CRF-0010
								showTitle.append("Could Not Administered By: "+admin_by_name+"\n");
							    showTitle.append("Recorded D/T: "+admin_date_time);//ADDED FOR MMS-KH-CRF-0010
								}
								else
									showTitle.append("Could Not Administered By: "+admin_by_name);
							}
							else{
								if(viewAdminRemarks){//added for MMS-KH-CRF-0010
									
									showTitle.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.AdministeredBy.label", "common_labels")+"   : "+admin_by_name);
									if(auth_by_name!=null && !auth_by_name.equals(""))	
								 showTitle.append("\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.authorizedby.label", "common_labels")+"  : "+auth_by_name);
								
									showTitle.append("\nRemarks: "+adminReasondDetails+"\n");//ADDED FOR MMS-KH-CRF-0010
								    showTitle.append("Recorded D/T: "+admin_date_time);//ADDED FOR MMS-KH-CRF-0010
								}
								else
								if(admin_by_name!=null && !admin_by_name.equals(""))
							showTitle.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.AdministeredBy.label", "common_labels")+"   : "+admin_by_name);
							}
						}else{
						
						if(admin_by_name!=null && !admin_by_name.equals(""))
							{showTitle.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.AdministeredBy.label", "common_labels")+"   : "+admin_by_name);
							}
							
						}
						if(auth_by_name!=null && !auth_by_name.equals("") && !viewAdminRemarks){//viewAdminRemarks  added for MMS-KH-CRF-0010
							showTitle.append("\n "+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.authorizedby.label", "common_labels")+"  : "+auth_by_name);
						}
						
						//verificationremarks	= bean_all_stages.getVerificationRemarks(order_id,order_line_num);
						//overridereason		= (HashMap)bean_all_stages.getOverrideremarks(order_id,order_line_num);
						//pres_remarks		= bean.getPrescriptionInstructions(order_id);
						//drug_remarks		= bean.getDrugInstructions(order_id,order_line_num);
						//pharma_remarks		= bean.getPharmacistInstructions(order_id,order_line_num);
						show_remarks		= "N";
						order_pract_id  =(String)non_iv_drug_details.get(76); //Added for [IN:040149]
						route_color                 =(String)non_iv_drug_details.get(75);	//Code Added For RUT-CRF-0034 Start
						if(route_color != "" && route_color != null && route_color.length()==12 ){
							fntColor = route_color.substring(0, 6);
							backGrndColor = route_color.substring(6, 12);
						}
						else{
							fntColor = "";
							backGrndColor = "";
						}
						if( !ext_prod_id.equals("")){
							if(overridereason!=null && overridereason.size()>1){
								show_remarks="Y";
							}			
						}
						else{
							if(overridereason!=null && overridereason.size()>0){
								show_remarks="Y";
							}
						}
						//added for MMS-KH-CRF-0010 start
						if(drug_remarks.trim().equals("") && pharma_remarks.trim().equals("") && pres_remarks.trim().equals("") && prn_remarks.trim().equals("")&& slidingscaleremarks.trim().equals("")&& verificationremarks.equals("")&&show_remarks.equals("N")){
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
						//added for MMS-KH-CRF-0010 end
						strength_value		=	strength_value.trim();
						sch_strength_value	=	sch_strength_value.trim();
						adr_count			= bean.getADRCount(patient_id_test,drug_code); 
						Store_locn_code	= performingDeptLocCode;
						Storelocn_code	= bean.getStoreLocnnCode(nursing_unit);

						if(!Storelocn_code.equals("")){
							non_iv_drug_details.set(29,Storelocn_code);
							store_code		= Storelocn_code;
						}
						verification_status	=	bean.getVerificationStatus(patient_class_ord,facility_id,Store_locn_code,verification_req_yn,WardAckMarRequiredYn);//added for MMS-KH-SCF-0056
						discontinued_sch = "";
						hold_sch="";
						displayFreqStyle = "";
						displayStyle = "";
						if(schCanAdmin.equals("Y")){
							if( !mar_disc_dose_yn.equals("Y") && discontinued.equals("Y") && !sch_date_time.equals(ord_disc_date_time))
								displayStyle = "";
							else
								displayStyle = "COLOR:blue;text-decoration:underline;";
						//added for GHL-CRF-0458
						stDispHand="cursor:pointer;";
						//issitespec_verbal_order_yn and placed_from_verbal_order added for ghl-crf-0509
						//ADDED FOR MMS-KH-SCF-0056
						  if(verification_status.equals("Y") &&(iv_prep_yn.equals("") || iv_prep_yn== null) && (order_status.equals("OS") || order_status.equals("RG")) ){
							displayStyle = "";
							stDispHand = "";
						}  
						if(!iv_prep_yn.equals("8") && WardAckMarRequiredYn.equalsIgnoreCase("Y") && !ack_yn.equals("A") && patient_class_ord.equals("IP") && !patient_brgt_medn.equals("Y") && (!hold.equals("Y") || !discontinued.equals("Y")) ){ // isSiteSpecMARPrint changed to !WardAckMarRequiredYn for MMS-KH-CRF-0014 [IN:067953]	and changed iv_prep_yn.equals("") to !iv_prep_yn.equals("8") for MMS-KH-CRF-0039 						
							
							displayStyle = "";
							stDispHand = "";
							}
							
						}
						if(issitespec_verbal_order_yn && placed_from_verbal_order.equals("Y")){
							displayStyle = "";
							stDispHand = "";
						}
						if(hold.equals("Y") || (!mar_disc_dose_yn.equals("Y") && discontinued.equals("Y")&& !sch_date_time.equals(ord_disc_date_time)))
							stDispHand="";
						if(administered_yn.equals("Y") && !admin_drug_code.equals("") && !admin_drug_code.equals(drug_code) ){
							showAlt	 = ("Administered Drug : "+admin_drug_desc+"\n");
							showTitle.insert(0, showAlt);
							displayStyle = "BACKGROUND-COLOR:#CC99CC;COLOR:white;";
						}
						else if(admin_recorded_yn.equals("Y")){
							if(administered_yn.equals("N")){ 
								displayStyle = "BACKGROUND-COLOR:#000000;COLOR:white;";
							}
							else {
								displayStyle = "BACKGROUND-COLOR:green;COLOR:white;";
								if(discontinued.equals("Y") && com.ehis.util.DateUtils.isAfter(adr_record_time, ord_disc_date_time, "DMYHM", locale ))//sch_date_time changed to  adr_record_time for ML-BRU-SCF-1177.1 [IN:049200]
									displayStyle = "BACKGROUND-COLOR:green;COLOR:Red;";
								if(hold.equals("Y") && com.ehis.util.DateUtils.isAfter(sch_date_time, ord_hold_date_time, "DMYHM", locale ))
									displayStyle = "BACKGROUND-COLOR:green;COLOR:yellow;";
							}
						}
						if(marForDisPatNotReqYN && dischargedYN){ // Added for KH-SCF-0010 - Start
							displayStyle = "";								
							stDispHand = "";
						} // Added for KH-SCF-0010 - End
						if(discontinued.equals("Y")&& com.ehis.util.DateUtils.isAfter(sch_date_time, ord_disc_date_time, "DMYHM", locale )){
							if(admin_recorded_yn.equals("Y") && administered_yn.equals("N"))
								displayStyle = "BACKGROUND-COLOR:#000000;COLOR:red;";
							else if(!admin_recorded_yn.equals("Y"))
								displayStyle = "BACKGROUND-COLOR:red;COLOR:blue;";
							if(sch_date_time.equals(ord_disc_date_time) && mar_disc_dose_yn.equals("Y"))
								stDispHand = "cursor:pointer;";
							else
								stDispHand="";
						}
						else if(hold.equals("Y") && com.ehis.util.DateUtils.isAfter(sch_date_time, ord_hold_date_time, "DMYHM", locale )) {
							displayStyle = "BACKGROUND-COLOR:yellow;";
							stDispHand="";
						}
						if(discontinued.equals("Y")&& !com.ehis.util.DateUtils.isAfter(sch_date_time, ord_disc_date_time, "DMYHM", locale )){
							discontinued_sch="N";
						}
						if(hold.equals("Y") && !com.ehis.util.DateUtils.isAfter(sch_date_time, ord_hold_date_time, "DMYHM", locale )) {
							hold_sch="N";
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

            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf((daySize/2)+dispSizeMms));
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
 
								} 
								else if(temp2==1){ 

            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf((daySize/2)+dispSizeMms));
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

								}
								else if(temp3==1){ 

            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf((daySize/2)+dispSizeMms));
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

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

            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(sliding_scale_applicable));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(rowsPan));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(start_date_time));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(rowsPan));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(end_date_time));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(drug_class_ind));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(rowsPan));
            _bw.write(_wl_block44Bytes, _wl_block44);

									if(!(iv_prep_yn.equals("0")||iv_prep_yn.equals("2")||iv_prep_yn.equals("4")||iv_prep_yn.equals("6")||iv_prep_yn.equals("7")||iv_prep_yn.equals("8"))) {

            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(disp_drug_code));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block47Bytes, _wl_block47);
			
									}

            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block49Bytes, _wl_block49);
				
									if(ext_prod_id!=null && !ext_prod_id.equals("") && !(iv_prep_yn.equals("0"))&& !(iv_prep_yn.equals("9")&&order_line_num.equals("1")&&(Integer.parseInt(onco_direct_drug_count)>1))&& !(iv_prep_yn.equals("6"))){

            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(ext_prod_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_desc,"UTF-8")));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.DrugInformation.label", "ph_labels")));
            _bw.write(_wl_block53Bytes, _wl_block53);

									}
									if(imageFileURL!=null && !imageFileURL.equals("")){

            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(trade_code));
            _bw.write(_wl_block55Bytes, _wl_block55);

									}
									if(adr_count>0){

            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(patient_id_test));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block58Bytes, _wl_block58);

									}
									if(!(iv_prep_yn.equals("0")||iv_prep_yn.equals("2")||iv_prep_yn.equals("4")||iv_prep_yn.equals("6"))){

            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block55Bytes, _wl_block55);
						
									}
									if(iv_prep_yn.equals("7")){
										if(ppn_count >0){

            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(Store_locn_code));
            _bw.write(_wl_block61Bytes, _wl_block61);
										}
									}
									if(linkVacScheduleYN.equals("Y")){ 
										if((!(iv_prep_yn.equals("9")||iv_prep_yn.equals("6")))||(iv_prep_yn.equals("9")&&order_line_num.equals("1"))){

            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(linkVacScheduleDescToolTip));
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(linkVacScheduleDesc));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(linkVacScheduleCode));
            _bw.write(_wl_block44Bytes, _wl_block44);

										}
									}
									if(freq_nature.equals("P")){

									/*	if(sch_dosage_qty!=null && !sch_dosage_qty.equals(""))//Adding start for ML-MMOH-SCF-1964
											sch_dosage_qty =Float.toString( Float.parseFloat(sch_dosage_qty)*Float.parseFloat(content_in_pres_base_uom));//Adding end for ML-MMOH-SCF-1964*/

            _bw.write(_wl_block74Bytes, _wl_block74);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(sch_dosage_qty));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(prn_qty_desc));
            _bw.write(_wl_block1Bytes, _wl_block1);

										if(!prn_remarks.equals("")){

            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(prn_remarks));
            _bw.write(_wl_block80Bytes, _wl_block80);

										}
									}

            _bw.write(_wl_block81Bytes, _wl_block81);
 									if(dispensed_drug_desc!=null && !dispensed_drug_desc.equals("")){

            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(disp_drugs));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(disp_drugs));
            _bw.write(_wl_block85Bytes, _wl_block85);

									}

            _bw.write(_wl_block86Bytes, _wl_block86);
if(viewAdminRemarks){ 
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(rowsPan));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(dialog_height));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(encode_drug_desc));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Remarks.label", "ph_labels")));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(remarks_style));
            _bw.write(_wl_block91Bytes, _wl_block91);
} 
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(rowsPan));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(fntColor));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(backGrndColor));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(route_desc));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(displayFreqStyle));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(rowsPan));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(freq_desc));
            _bw.write(_wl_block99Bytes, _wl_block99);

								if(!split_dose_yn.equals("Y")){

            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(rowsPan));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(dosage));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(dosage_uom_desc));
            _bw.write(_wl_block99Bytes, _wl_block99);

								}
								//added for GHL-CRF-0482 - start
								patient_stock_status_str = "";
								if(isSite_spec_patient_stock){

            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(rowsPan));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(patient_stock_status_str_disp));
            _bw.write(_wl_block99Bytes, _wl_block99);
								}	//added for GHL-CRF-0482 - end					
							}
							if(uniqueSchedules!=null){
				 				schKey = schTime;
								if(freq_nature.equals("P"))
									schKey = dosage_seq_no;
								if(uniqueSchedules.contains(schKey)){
									uniqueSchedules.remove(schKey);
									prevAllowPRNAdmin = allowPRNAdmin;
									if(sch!=0){
										schDayCount++;
										for(;schDayCount<=(daySize/2); schDayCount++){ //loop to complete the prev dosage row
											dispDate = (String)altDateDayList.get((schDayCount-1)*2);
											if(prev_discontinued.equals("Y"))
												prev_displayStyle = "BACKGROUND-COLOR:red;";
											else if(prev_hold.equals("Y"))
												prev_displayStyle = "BACKGROUND-COLOR:yellow;";
											else
												prev_displayStyle = "";
											if(prev_freq_nature.equals("P") && com.ehis.util.DateUtils.isAfter(prev_end_date, dispDate, "DMY", locale) ){
												//dispDate = (String)altDateDayList.get(schDayCount*2);
												prev_sch_date_time = dispDate+" "+schTime;
												end_date = end_date_time.substring(0,10);
												prev_prnSrlNo++;
												//prevSch++;
												scheKey = prev_order_id+"_"+prev_order_line_num+"_"+prevSchCount+"_"+schDayCount;//+"_"+prev_prnSrlNo;
												if(com.ehis.util.DateUtils.isBetween(  adminFromDateTime.substring(0,10),  adminToTime.substring(0,10), dispDate, "DMY", locale) && !prev_discontinued.equals("Y") && !prev_hold.equals("Y") && prevAllowPRNAdmin){
													//prevAllowPRNAdmin = false;

            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(stDispHand));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(prev_orderCount));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(prevSchCount));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(prevSch));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block111Bytes, _wl_block111);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(prev_orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(prevSchCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(prev_orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(prevSchCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(prev_dosage_seq_no));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(prev_orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(prevSchCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(prev_orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(prevSchCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(prev_prnSrlNo));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(prev_orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(prevSchCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(prev_orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(prevSchCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(dispDate));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(prev_orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(prevSchCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(prev_orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(prevSchCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(prev_schTime));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(prev_orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(prevSchCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(prev_orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(prevSchCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(prev_sch_date_time));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(prev_orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(prevSchCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(prev_orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(prevSchCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(prev_orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(prevSchCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(prev_orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(prevSchCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(prev_dosage));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(prev_orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(prevSchCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(prev_orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(prevSchCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(prev_dosage_uom_code));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(prev_orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(prevSchCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(prev_orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(prevSchCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(prev_discontinued_dose));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(prev_orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(prevSchCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(prev_orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(prevSchCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(prev_discontinued_sch));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(prev_orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(prevSchCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(prev_orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(prevSchCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(prev_hold_sch));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(prev_orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(prevSchCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(prev_orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(prevSchCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(prev_orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(prevSchCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(prev_orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(prevSchCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block139Bytes, _wl_block139);

												}
												else{

            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(prev_displayStyle));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block142Bytes, _wl_block142);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block143Bytes, _wl_block143);

												}
											}
											else{

            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block145Bytes, _wl_block145);

											}
										}

            _bw.write(_wl_block146Bytes, _wl_block146);

										schDayCount=0;
										dayCount = 0;
										prev_prnSrlNo =0;
										//prevAllowPRNAdmin = false;
									}
									if(freq_nature.equals("P")){

            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block148Bytes, _wl_block148);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            out.print( String.valueOf(++prn_doseCount));
            _bw.write(_wl_block99Bytes, _wl_block99);

									}
									else{
										if(split_dose_yn.equals("Y")){
											qty = bean.getSplitDosage(order_id,order_line_num,schTime);//added for ML-MMOH-SCF-1674

            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(Float.parseFloat(qty)));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(dosage_uom_desc));
            _bw.write(_wl_block151Bytes, _wl_block151);

										}

            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(schTime));
            _bw.write(_wl_block99Bytes, _wl_block99);

									}
									schCount++;
								}
								//NMC-JD-CRF-0186[44335]
								// START NMC-JD-CRF-0186[44335]
								String episode_type = "";
								String visit_id = "";
								String classValSelect = "visibleCheck";
								
								ArrayList epVisitResult = bean.getDetails(facility_id, patient_id_test, encounter_id);
								if(epVisitResult.size()!=0){
									episode_type = (String) epVisitResult.get(0);
									visit_id = (String) epVisitResult.get(1);
								}
								boolean mar_unbill_med_blueColor_disable = bean.isSiteSpecific("PH","ALLOW_MAR_DISP_UNBILL_MED");//added for NMC-JD-CRF-0186 US002&03 [45063]	
								String billStatus = bean.getBillStatus(facility_id,patient_id_test,encounter_id.substring(0,8),episode_type,visit_id,order_id,order_line_num)==null?"":bean.getBillStatus(facility_id,patient_id_test,encounter_id.substring(0,8),episode_type,visit_id,order_id,order_line_num);  // "" - episode_id
								String unbilledMedicateYN = bean.getUnbilledMedicateYN(facility_id);
								
								if(billStatus.equals("UNBILLED") && (unbilledMedicateYN.equals("N")
										|| unbilledMedicateYN == "N") && mar_unbill_med_blueColor_disable && administered_yn.equals("N") && (patient_class_ord.equals("OP")||patient_class_ord.equals("EM"))){ //Modified for NMC-JD-CRF-0186 [46294]
									classValSelect = "hiddenCheck";
									displayStyle = "COLOR:white;text-decoration;";
								}
								// END NMC-JD-CRF-0186[44335]				
								for(int day=(dayCount*2); day<daySize; day+=2){
									schDayCount++;
									dayCount++;
									dispDate = (String)altDateDayList.get(day);
									/*if(freq_nature.equals("P")){
										scheKey = order_id+"_"+order_line_num+"_"+schCount+"_"+schDayCount+"_"+prnSrlNo;
									}
									else*/
										scheKey = order_id+"_"+order_line_num+"_"+schCount+"_"+schDayCount;//+"_"+dosage_seq_no;
									end_date = end_date_time.substring(0,10);
									start_date = start_date_time.substring(0,10);
									schDate	= (String)non_iv_drug_details.get(79);
									if(freq_nature.equals("P") && !com.ehis.util.DateUtils.isBetween(from_time,to_time, schDate, "DMY", locale) && com.ehis.util.DateUtils.isBetween( start_date, end_date, dispDate,"DMY", locale)){ //if block added for SKR-SCF-1001 [IN:048680]
										schDate = dispDate;
										administered_yn = "";
										if(!com.ehis.util.DateUtils.isBetween(  adminFromDateTime.substring(0,10),  adminToTime.substring(0,10), dispDate, "DMY", locale)){
											schCanAdmin="N";
											stDispHand="";
											displayStyle="";
										}
										else{
											schCanAdmin="Y";
											displayStyle = "COLOR:blue;text-decoration:underline;";
											stDispHand="cursor:pointer;";
											recExists="N";
										}
									}
									else if(freq_nature.equals("P") && com.ehis.util.DateUtils.isBetween(  adminFromDateTime.substring(0,10),  adminToTime.substring(0,10), dispDate, "DMY", locale) && !schCanAdmin.equals("Y") && !administered_yn.equals("Y")){
										administered_yn = "";
										schCanAdmin="Y";
										displayStyle = "COLOR:blue;text-decoration:underline;";
										stDispHand="cursor:pointer;";
									}
		//System.err.println("=schDate==>"+schDate+" ===dispDate=>"+dispDate+" freq_nature="+freq_nature+" prn_admin_date="+prn_admin_date+" schDayCount="+schDayCount+" dayCount="+dayCount+" end_date==>"+end_date+" start_date="+start_date);
									if((com.ehis.util.DateUtils.isAfter(schDate, dispDate, "DMY", locale) || (freq_nature.equals("P") && dispDate.equals(prn_admin_date))) && schDayCount ==dayCount){
										if(dispDate.equals(schDate) || (freq_nature.equals("P") && (dispDate.equals(prn_admin_date)))){
											if(!schCanAdmin.equals("Y")){
													if(administered_yn.equals("Y")){
														if(freq_nature.equals("P"))
															callMenu="PRN";
														else 
															callMenu = "NONIV";
														if(marForDisPatNotReqYN && dischargedYN){ // if Added for KH-SCF-0010 - Start

            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(displayStyle));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(showTitle.toString()));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(doseDisplay));
            out.print( String.valueOf(schTime));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(adr_details));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block163Bytes, _wl_block163);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(admin_rec_disp));
            _bw.write(_wl_block165Bytes, _wl_block165);

														} // if Added for KH-SCF-0010 - End
														else{

            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(displayStyle));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(showTitle.toString()));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(administered_yn));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(admin_recorded_yn));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(callMenu));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(sch));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(adminStatus));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(cancelYn));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(admin_by_name));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_desc,"UTF-8")));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(admin_date_time));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(strength_per_value_pres_uom));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(doseDisplay));
            out.print( String.valueOf(schTime));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(adr_details));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block163Bytes, _wl_block163);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(admin_rec_disp));
            _bw.write(_wl_block174Bytes, _wl_block174);
if(cancel_recorded_yn.equals("Y")){
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_desc,"UTF-8")));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(patient_id_test));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(admin_date_time));
            _bw.write(_wl_block176Bytes, _wl_block176);
}
            _bw.write(_wl_block177Bytes, _wl_block177);

														}
														}
													else if(freq_nature.equals("P")){

            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(displayStyle));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(stDispHand));
            _bw.write(_wl_block76Bytes, _wl_block76);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block179Bytes, _wl_block179);

													}
													else{//changes NMC-JD-CRF-0186 [44335] added classValSelect instead of classvalue

            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(classValSelect));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(displayStyle));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(stDispHand));
            _bw.write(_wl_block180Bytes, _wl_block180);
if(iv_prep_yn.equals("9")){  //added for MMS-KH-CRF-0017.1 start
																if(!order_line_num.equals("2")){
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(schTime));
            _bw.write(_wl_block181Bytes, _wl_block181);

															}}else{
															
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(schTime));
            _bw.write(_wl_block181Bytes, _wl_block181);
}//added for MMS-KH-CRF-0017.1 end 
            _bw.write(_wl_block182Bytes, _wl_block182);
if(cancel_recorded_yn.equals("Y")){
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_desc,"UTF-8")));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(patient_id_test));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(admin_date_time));
            _bw.write(_wl_block183Bytes, _wl_block183);
}
            _bw.write(_wl_block184Bytes, _wl_block184);

													}
												}
												else{
													if(freq_nature.equals("P")){
														callMenu="PRN";
													}
													else 
														callMenu = "NONIV";
													if(!mfr_yn.equals("Y")){
														if(marForDisPatNotReqYN && dischargedYN){ // if Added for KH-SCF-0010 - Start

            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(displayStyle));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(showTitle.toString()));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(stDispHand));
            _bw.write(_wl_block187Bytes, _wl_block187);

														} // if Added for KH-SCF-0010 - End
													else{//Srinad changes NMC-JD-CRF-0186[44335] added classValSelect instead of classvalue
 
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(classValSelect));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(displayStyle));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(showTitle.toString()));
            _bw.write(_wl_block188Bytes, _wl_block188);
 //GHL-CRF-0482
														if(stDispHand.equals("")){ 
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(stDispHand));
            _bw.write(_wl_block190Bytes, _wl_block190);
														}else{
														
            _bw.write(_wl_block191Bytes, _wl_block191);
if(billStatus.equals("UNBILLED")&& (unbilledMedicateYN.equals("N")
																|| unbilledMedicateYN == "N") && mar_unbill_med_blueColor_disable && administered_yn.equals("N") && (patient_class_ord.equals("OP")||patient_class_ord.equals("EM"))){ 
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(stDispHand));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block194Bytes, _wl_block194);
}else{
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(stDispHand));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(administered_yn));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(admin_recorded_yn));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(callMenu));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(sch));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(adminStatus));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(cancelYn));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(admin_by_name));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_desc,"UTF-8")));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(admin_date_time));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(strength_per_value_pres_uom));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block195Bytes, _wl_block195);
                                                      
																} /* NMC-JD-CRF-0186 US002&03 [45063] */
															}
							                            }
														if(freq_nature.equals("P") && !administered_yn.equals("Y")){
															allowPRNAdmin = false;

            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block197Bytes, _wl_block197);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);

														}
														else{
															////ML-MMOH-CRF-1014 - end
//System.err.println("order_line_num=sd==1233=>"+order_line_num+"==iv_prep_yn===>"+iv_prep_yn);
															if(iv_prep_yn.equals("9")){  //added for MMS-KH-CRF-0017.1 -start
																if(!order_line_num.equals("2")){

            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(doseDisplay));
            out.print( String.valueOf(schTime));
            _bw.write(_wl_block181Bytes, _wl_block181);
}
															}else{ 
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(doseDisplay));
            out.print( String.valueOf(schTime));
            _bw.write(_wl_block181Bytes, _wl_block181);
} //added for MMS-KH-CRF-0017.1 end 
            _bw.write(_wl_block198Bytes, _wl_block198);
															
														}

            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(adr_details));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block163Bytes, _wl_block163);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(admin_rec_disp));
            _bw.write(_wl_block200Bytes, _wl_block200);
if(cancel_recorded_yn.equals("Y")){
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_desc,"UTF-8")));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(patient_id_test));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(admin_date_time));
            _bw.write(_wl_block183Bytes, _wl_block183);
}
            _bw.write(_wl_block201Bytes, _wl_block201);
													}else{ 
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(displayStyle));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(showTitle.toString()));
            _bw.write(_wl_block44Bytes, _wl_block44);

															if(mfr_yn.equals("Y")){//ML-MMOH-CRF-1014 - start

																ArrayList MfrDetails=bean.getStatusOfMAR(order_id,"SCH");
																String completed_flow = "";
																

																if(MfrDetails.size()>0){
																	statusString=(String)MfrDetails.get(0);
																	completed_flow =(String)MfrDetails.get(1);
												
																}
																if(order_line_num.equals("1")){ 
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(administered_yn));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(admin_recorded_yn));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(sch));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(mfr_yn));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(completed_flow));
            _bw.write(_wl_block208Bytes, _wl_block208);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(statusString));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(mfrRemarks));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block212Bytes, _wl_block212);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block213Bytes, _wl_block213);
																}
															
															}	

            _bw.write(_wl_block214Bytes, _wl_block214);
if(cancel_recorded_yn.equals("Y")){
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_desc,"UTF-8")));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(patient_id_test));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(admin_date_time));
            _bw.write(_wl_block176Bytes, _wl_block176);
}
            _bw.write(_wl_block215Bytes, _wl_block215);
												}
												}
												break;
											}
											else if(freq_nature.equals("P")&&  com.ehis.util.DateUtils.isAfter( dispDate,start_date, "DMY", locale) &&  com.ehis.util.DateUtils.isAfter(end_date, dispDate, "DMY", locale)){
												if(com.ehis.util.DateUtils.isBetween( start_date, end_date, dispDate,"DMY", locale) && com.ehis.util.DateUtils.isBetween(  adminFromDateTime.substring(0,10),  adminToTime.substring(0,10), dispDate, "DMY", locale) && prevAllowPRNAdmin){

            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(stDispHand));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(prev_orderCount));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(prevSch));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block111Bytes, _wl_block111);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(prev_orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(prev_orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(prev_dosage_seq_no));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(prev_orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(prev_orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(prev_prnSrlNo));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(prev_orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(prev_orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(dispDate));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(prev_orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(prev_orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(prev_schTime));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(prev_orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(prev_orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(prev_sch_date_time));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(prev_orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(prev_orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(prev_orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(prev_orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(prev_dosage));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(prev_orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(prev_orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(prev_dosage_uom_code));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(prev_orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(prev_orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(prev_discontinued_dose));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(prev_orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(prev_orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(prev_discontinued_sch));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(prev_orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(prev_orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(prev_hold_sch));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(prev_orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(prev_orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(prev_orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(prev_orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block139Bytes, _wl_block139);

													//break;
												}
												else{

            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block219Bytes, _wl_block219);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block99Bytes, _wl_block99);

												}
											}
											else {

            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block220Bytes, _wl_block220);

											}
										}
										else if(com.ehis.util.DateUtils.isAfter(schDate, dispDate, "DMY", locale) && schDayCount<(daySize/2)){
											end_date = end_date_time.substring(0,10);
											if(freq_nature.equals("P") && com.ehis.util.DateUtils.isAfter(end_date, dispDate, "DMY", locale) ){

            _bw.write(_wl_block221Bytes, _wl_block221);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block1Bytes, _wl_block1);

											}
											else{

            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block145Bytes, _wl_block145);

											}
											schDayCount++;
											dayCount++;
										}
										else if(freq_nature.equals("P") && (dispDate.equals(prn_admin_date))){
											if(!schCanAdmin.equals("Y"))
												callMenu = "NONIV";
											else
												callMenu = "PRN";
											if(marForDisPatNotReqYN && dischargedYN){ // if Added for KH-SCF-0010 - Start

            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(displayStyle));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(stDispHand));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(doseDisplay));
            out.print( String.valueOf(schTime));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(adr_details));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block163Bytes, _wl_block163);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(admin_rec_disp));
            _bw.write(_wl_block227Bytes, _wl_block227);

											} // if Added for KH-SCF-0010 - End
										 else{

            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(displayStyle));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(stDispHand));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(administered_yn));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(admin_recorded_yn));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(callMenu));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(sch));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(adminStatus));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(doseDisplay));
            out.print( String.valueOf(schTime));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(adr_details));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block163Bytes, _wl_block163);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(admin_rec_disp));
            _bw.write(_wl_block229Bytes, _wl_block229);
                                       }
											schDayCount++;
											dayCount++;
										}
										else{

            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block230Bytes, _wl_block230);

											dayCount++;
										}
									}
								}
								else{
									dayCount=0;
										for(int day=0; day<daySize; day+=2){
											dispDate = (String)altDateDayList.get(day);
											/*if(freq_nature.equals("P"))
												scheKey = order_id+"_"+order_line_num+"_"+schCount+"_"+schDayCount+"_"+prnSrlNo;
											else*/
												scheKey = order_id+"_"+order_line_num+"_"+schCount+"_"+schDayCount;//+"_"+dosage_seq_no;
											if(dispDate.equals(schDate)){
												if(!schCanAdmin.equals("Y")){
													if(administered_yn.equals("Y")){
														if(freq_nature.equals("P"))
															callMenu="PRN";
														else 
															callMenu = "NONIV";

            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(displayStyle));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(showTitle.toString()));
            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(administered_yn));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(admin_recorded_yn));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(callMenu));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(sch));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(adminStatus));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(doseDisplay));
            out.print( String.valueOf(schTime));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(adr_details));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block163Bytes, _wl_block163);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(admin_rec_disp));
            _bw.write(_wl_block165Bytes, _wl_block165);

													}
													else{

            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(displayStyle));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf(schTime));
            _bw.write(_wl_block179Bytes, _wl_block179);

													}
												}
												else{

            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(displayStyle));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(stDispHand));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(administered_yn));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(admin_recorded_yn));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(sch));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(adminStatus));
            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(doseDisplay));
            out.print( String.valueOf(schTime));
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(adr_details));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block163Bytes, _wl_block163);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(admin_rec_disp));
            _bw.write(_wl_block237Bytes, _wl_block237);

													schDayCount++;
												}
											}
											else{

            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block238Bytes, _wl_block238);

											}
										dayCount++;
									}

            _bw.write(_wl_block239Bytes, _wl_block239);

								}
								//prnSrlNo = (Integer.parseInt(prnSrlNo)+1) +"";
								prev_freq_nature=freq_nature;
								if(freq_nature.equals("P")){
									prev_end_date=end_date_time.substring(0,10);
									prev_prnSrlNo=Integer.parseInt(prnSrlNo);
									prev_order_line_num=order_line_num;
									prev_order_id=order_id;
									prev_dosage_seq_no = dosage_seq_no;
									prev_schDate = schDate;
									prev_schTime = schTime;
									prev_dosage = dosage;
									prev_dosage_uom_code = dosage_uom_code;
									prev_discontinued_dose = discontinued_dose;
									prev_discontinued_sch = discontinued_sch;
									prev_hold_sch = hold_sch;
									prev_displayStyle = displayStyle;
									prev_discontinued = discontinued;
									prev_hold = hold;
									prev_dosage_seq_no = dosage_seq_no;
									prevSchCount = schCount;
									prevSch = sch+1;
                                 //System.err.println("sch_dosage_qty@@@@==="+sch_dosage_qty);
									/* if(sch_dosage_qty!=null && !sch_dosage_qty.equals("")){//Adding start for ML-MMOH-SCF-1964
											//sch_dosage_qty =Float.toString( Float.parseFloat(sch_dosage_qty)*Float.parseFloat(content_in_pres_base_uom));//Adding end for ML-MMOH-SCF-1964											
										//	sch_dosage_qty = Math.ceil(Float.parseFloat(sch_dosage_qty)*Float.parseFloat(content_in_pres_base_uom))+"";
									}
						 */		
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(sch_dosage_qty));
            _bw.write(_wl_block242Bytes, _wl_block242);

								}

            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(prnSrlNo));
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(schDate));
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(schTime));
            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(admin_date_time));
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(dosage));
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(dosage_uom_code));
            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(discontinued_dose));
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(discontinued_sch));
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(hold_sch));
            _bw.write(_wl_block254Bytes, _wl_block254);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(recExists));
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(sch_dosage_qty));
            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block258Bytes, _wl_block258);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(future_admin));
            _bw.write(_wl_block259Bytes, _wl_block259);

								recCount++;
								prev_orderCount  = orderCount;
								recExists = "N";
							}
							i_prnSrlNo = sch-1;
							for(schDayCount++;schDayCount<=(daySize/2); schDayCount++){
								dispDate = (String)altDateDayList.get((schDayCount-1)*2);
								sch_date_time = dispDate+" "+schTime;
								end_date = end_date_time.substring(0,10);
								if(discontinued.equals("Y"))
									displayStyle = "BACKGROUND-COLOR:red;";
								else if(prev_hold.equals("Y"))
									displayStyle = "BACKGROUND-COLOR:yellow;";
								else
									displayStyle = "";
								if(freq_nature.equals("P") && com.ehis.util.DateUtils.isAfter(end_date, dispDate, "DMY", locale)){
									i_prnSrlNo++;
									scheKey = order_id+"_"+order_line_num+"_"+schCount+"_"+schDayCount;//+"_"+prev_prnSrlNo;
									if(com.ehis.util.DateUtils.isBetween(adminFromDateTime.substring(0,10),  adminToTime.substring(0,10), dispDate, "DMY", locale) && prevAllowPRNAdmin){
										//prevAllowPRNAdmin = false;

            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(displayStyle));
            _bw.write(_wl_block261Bytes, _wl_block261);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(stDispHand));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(prevSch));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block111Bytes, _wl_block111);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(dosage_seq_no));
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(prnSrlNo));
            _bw.write(_wl_block264Bytes, _wl_block264);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(dispDate));
            _bw.write(_wl_block265Bytes, _wl_block265);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(schTime));
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(sch_date_time));
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(dosage));
            _bw.write(_wl_block269Bytes, _wl_block269);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(dosage_uom_code));
            _bw.write(_wl_block270Bytes, _wl_block270);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(discontinued_dose));
            _bw.write(_wl_block271Bytes, _wl_block271);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(discontinued_sch));
            _bw.write(_wl_block272Bytes, _wl_block272);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(hold_sch));
            _bw.write(_wl_block273Bytes, _wl_block273);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block274Bytes, _wl_block274);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(schDayCount));
            _bw.write(_wl_block139Bytes, _wl_block139);

									}
									else{

            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block275Bytes, _wl_block275);
            out.print( String.valueOf(scheKey));
            _bw.write(_wl_block142Bytes, _wl_block142);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block276Bytes, _wl_block276);

									}
								}
								else{

            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block277Bytes, _wl_block277);

								}
							}

            _bw.write(_wl_block278Bytes, _wl_block278);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block279Bytes, _wl_block279);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block280Bytes, _wl_block280);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block281Bytes, _wl_block281);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(dispense_drug_code));
            _bw.write(_wl_block282Bytes, _wl_block282);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block283Bytes, _wl_block283);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block284Bytes, _wl_block284);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block285Bytes, _wl_block285);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block286Bytes, _wl_block286);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block287Bytes, _wl_block287);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block288Bytes, _wl_block288);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block289Bytes, _wl_block289);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block290Bytes, _wl_block290);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block291Bytes, _wl_block291);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(end_date_time));
            _bw.write(_wl_block292Bytes, _wl_block292);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block293Bytes, _wl_block293);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(drug_class));
            _bw.write(_wl_block294Bytes, _wl_block294);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block295Bytes, _wl_block295);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block296Bytes, _wl_block296);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block297Bytes, _wl_block297);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(freq_code));
            _bw.write(_wl_block298Bytes, _wl_block298);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block299Bytes, _wl_block299);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block300Bytes, _wl_block300);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block301Bytes, _wl_block301);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(dosage_type));
            _bw.write(_wl_block302Bytes, _wl_block302);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block303Bytes, _wl_block303);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(onco_direct_drug_count));
            _bw.write(_wl_block304Bytes, _wl_block304);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block305Bytes, _wl_block305);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block306Bytes, _wl_block306);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block307Bytes, _wl_block307);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block308Bytes, _wl_block308);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block309Bytes, _wl_block309);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block310Bytes, _wl_block310);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block311Bytes, _wl_block311);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(Auto_Admin));
            _bw.write(_wl_block312Bytes, _wl_block312);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block313Bytes, _wl_block313);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(order_pract_id));
            _bw.write(_wl_block314Bytes, _wl_block314);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block315Bytes, _wl_block315);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(discontinued));
            _bw.write(_wl_block316Bytes, _wl_block316);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block317Bytes, _wl_block317);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(ord_disc_date_time));
            _bw.write(_wl_block318Bytes, _wl_block318);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block319Bytes, _wl_block319);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(hold));
            _bw.write(_wl_block320Bytes, _wl_block320);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block321Bytes, _wl_block321);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(freq_nature));
            _bw.write(_wl_block322Bytes, _wl_block322);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block323Bytes, _wl_block323);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(schCount));
            _bw.write(_wl_block324Bytes, _wl_block324);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block325Bytes, _wl_block325);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(mfr_yn));
            _bw.write(_wl_block326Bytes, _wl_block326);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block327Bytes, _wl_block327);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(placed_from_verbal_order));
            _bw.write(_wl_block328Bytes, _wl_block328);

						schDayCount=0;
						dayCount = 0;
						orderCount++;
					}

            _bw.write(_wl_block329Bytes, _wl_block329);

			} 

            _bw.write(_wl_block330Bytes, _wl_block330);
            {java.lang.String __page ="MARSchLevelDrugDetailsIV.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("recCount"), weblogic.utils.StringUtils.valueOf(String.valueOf(recCount)
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block333Bytes, _wl_block333);
            out.print( String.valueOf(mar_disc_dose_yn));
            _bw.write(_wl_block334Bytes, _wl_block334);
            out.print( String.valueOf(mar_iv_compl_dt_ind));
            _bw.write(_wl_block335Bytes, _wl_block335);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block336Bytes, _wl_block336);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block337Bytes, _wl_block337);
            out.print( String.valueOf(patient_id_test));
            _bw.write(_wl_block338Bytes, _wl_block338);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block339Bytes, _wl_block339);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block340Bytes, _wl_block340);
            out.print( String.valueOf(current_date_time));
            _bw.write(_wl_block341Bytes, _wl_block341);
            out.print( String.valueOf(admin_due_date));
            _bw.write(_wl_block342Bytes, _wl_block342);
            out.print( String.valueOf(assign_bed_num));
            _bw.write(_wl_block343Bytes, _wl_block343);
            out.print( String.valueOf(nursing_unit));
            _bw.write(_wl_block344Bytes, _wl_block344);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block345Bytes, _wl_block345);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block346Bytes, _wl_block346);
            out.print( String.valueOf(CommonRepository.getCommonKeyValue( "MODE_INSERT" )));
            _bw.write(_wl_block347Bytes, _wl_block347);
            out.print( String.valueOf(orderCount));
            _bw.write(_wl_block348Bytes, _wl_block348);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block349Bytes, _wl_block349);
            out.print( String.valueOf(hold_discontinue_yn));
            _bw.write(_wl_block350Bytes, _wl_block350);
            out.print( String.valueOf(administration_status));
            _bw.write(_wl_block351Bytes, _wl_block351);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block352Bytes, _wl_block352);
            out.print( String.valueOf(from_time));
            _bw.write(_wl_block353Bytes, _wl_block353);
            out.print( String.valueOf(to_time));
            _bw.write(_wl_block354Bytes, _wl_block354);
            out.print( String.valueOf(userAuthPINYN));
            _bw.write(_wl_block355Bytes, _wl_block355);
            out.print( String.valueOf(adminFromDateTime));
            _bw.write(_wl_block356Bytes, _wl_block356);
            out.print( String.valueOf(adminToTime));
            _bw.write(_wl_block357Bytes, _wl_block357);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block358Bytes, _wl_block358);

	putObjectInBean(bean_id,bean,request);
	putObjectInBean(bean_id_all_stages,bean_all_stages,request);
	putObjectInBean(drug_search_bean_id,drug_bean,request);
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Route.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.freq.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.OrderDosage.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PatientStock.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Administration.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Oncology.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Rx.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.TPN.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdverseDrugReaction.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.LinkVaccineShcedule.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Bal.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PRN.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PRN.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PRN.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Dose.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PostAdministrationDetails.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PostAdministrationDetails.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PRN.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PRN.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PostAdministrationDetails.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MFRDetails.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MFRRemarks.label", java.lang.String .class,"key"));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PRN.label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PRN.label", java.lang.String .class,"key"));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PRN.label", java.lang.String .class,"key"));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PostAdministrationDetails.label", java.lang.String .class,"key"));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PostAdministrationDetails.label", java.lang.String .class,"key"));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PostAdministrationDetails.label", java.lang.String .class,"key"));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PostAdministrationDetails.label", java.lang.String .class,"key"));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PRN.label", java.lang.String .class,"key"));
        __tag38.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PRN.label", java.lang.String .class,"key"));
        __tag39.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
