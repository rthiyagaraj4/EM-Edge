package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eOR.*;
import eOR.Common.*;
import eCommon.Common.*;
import java.net.URLEncoder;
import webbeans.eCommon.ConnectionManager;
import java.sql.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __patorderbyprsearchresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/PatOrderByPRSearchResult.jsp", 1739448880000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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

    private final static java.lang.String  _wl_block6 =" \n<html>\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/dchk.js\"></script>\n\t<!-- used for date validation-->\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n \t<script language=\"JavaScript\" src=\"../js/PatOrderByPrivReln.js\"></script>\n \t<script language=\"JavaScript\" src=\"../js/PatOrderByPrivRelnTracking.js\"></script>\n\n \t<script language=\"JavaScript\" src=\"../js/OrCommonFunction.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<!--IN029948 Starts-->\n\t<script>\n\tasync function showDetailsPH(patient_id,orderid,order_line_no,line_status_text)\n\t{\n\tvar dialogHeight= \"15\" ;\n\tvar dialogWidth\t= \"50\" ;\n\tvar dialogTop = \"240\" ;\n\tvar center = \"1\" ;\n\tvar status=\"no\";\n\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\tvar arguments\t= \"\" ;\n\tvar retVal = await window.showModalDialog(\"../../ePH/jsp/QueryPatientDrugProfileLocations.jsp?patient_id=\"+patient_id+\"&order_id=\"+orderid+\"&order_line_no=\"+order_line_no+\"&line_status_text=\"+line_status_text,arguments,features);\n\t}\n\t</script>\n\t<!--IN029948 ENDS-->\n\t<Style>     </Style>\n\t<!--IN065091 start-->\n\t<style>\n\tTD.QRY11 \n\t{\n\t\tBACKGROUND-COLOR: #05bbea;\n\t\tFONT-SIZE: 9PT ;\n\t\tBORDER-COLOR:\tBLACK;\n\t\tBORDER-LEFT-COLOR: #D5E2E5;\n\t\tBORDER-RIGHT-COLOR: #D5E2E5;\n\t\tBORDER-TOP-COLOR: #D5E2E5;\n\t\tBORDER-BOTTOM-COLOR: #D5E2E5;\n\t}\n\t</style>\n\t<!--IN065091 Ends-->\n</head>\n<body  onscroll=\'processScroll()\'  onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\"  >\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="<script>\n\t\tparent.framePatOrderByPrivRelnSearch.document.PatOrderByPrivReln_search.search.disabled= false;\n\t\tif(parent.framePatOrderByPrHeaderDtl)\n\t\t{\n\t\t\tparent.framePatOrderByPrHeaderDtl.document.location.href=\"../../eCommon/html/blank.html\"\n\t\t}\n\t\tparent.framePatOrderByPrColor.document.location.href=\"../../eCommon/html/blank.html\"\n\t\t</script>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<form name=\'formPatOrderByPRSearchResult\' id=\'formPatOrderByPRSearchResult\' action=\"../../eOR/jsp/PatOrderByPRSearchResult.jsp\"  method=\"post\" >\n<div id=\"divHeadSep\" \">\n\t<table name=\'\' id=\'\' border=\'1\' cellspacing=\'0\' cellpadding = \'3\' width=\'100%\' id=\"tableresult\" class=\"grid\">\n\t\t<tr id=\"heading\">\n\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t<td class=\'columnheader\' width=\'\' nowrap></td>\n\t\t\t\t<td class=\'columnheader\' width=\'\' nowrap></td>\n\t\t\t\t<!--IN065091 Start-->\n\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t<td class=\'columnheader\' width=\'\' nowrap></td>\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t<td class=\'columnheader\' width=\'\' nowrap>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t\t\t\t<td class=\'columnheader\' width=\'\' nowrap>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t<td class=\'columnheader\' width=\'\' nowrap>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t\t<td class=\'columnheader\' width=\'\' nowrap>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" </td>\n\t\t\t<td class=\'columnheader\' width=\'\' nowrap>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\n\t\t\t<!---Arvind-->\n\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t<td class=\'columnheader\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t<!---end-->\n\t\t\t<!---19112 Start.-->\n\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t<!---19112 End.-->\n\t\t\t<td class=\'columnheader\' width=\'\' nowrap>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="<br><Input Type=\'CheckBox\' name=\'CheckPrint\' id=\'CheckPrint\' value=\"\" class=\'Header\'  align =\'center\' onClick=\'clickAll()\' ></td>\n   \n\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t<td class=\'columnheader\' width=\'\' nowrap></td>\n\t\t\t<td class=\'columnheader\' width=\'\' nowrap></td>\n\t\t\t<!--IN065091 Start-->\n\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t<td class=\'columnheader\' width=\'\' nowrap >";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t<td class=\'columnheader\' width=\'\' nowrap>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td>\n\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n\t\t\t\t<td class=\'columnheader\' width=\'\' nowrap>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n\t\t\t<!---19112 Start.-->\n\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t<Input Type=\'CheckBox\' name=\'CheckPrint\' id=\'CheckPrint\' value=\"\" class=\'Header\'  align =\'center\' onClick=\'clickAll()\' ></td>\n\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t<td  class=\'columnheader\' width=\'\' nowrap></td>\n\t\t\t<td  class=\'columnheader\' width=\'\' nowrap></td>\n\t\t\t<!--IN065091 Start-->\n\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td>\n\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t\t<td class=\'columnheader\' width=\'\' nowrap>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</td>\n\t\t\t\t\t\t<td class=\'columnheader\' width=\'\' nowrap>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</td>\n\t\t\t\t<!---19112 Start.-->\n\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t<td class=\'columnheader\'  width=\'\' nowrap>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t<!---19112 End.-->\n\t\t\t\t<td class=\'columnheader\' width=\'\' nowrap> ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t<Input Type=\'CheckBox\' name=\'CheckPrint\' id=\'CheckPrint\' value=\"\" class=\'Header\'  align =\'center\' onClick=\'clickAll()\' ></td>\t\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n</tr>\t\n\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\t\t\t<tr align=\"right\">\n\t\t\t\t\t<!--IN065091 Start-->\n\t\t\t\t\t<!--<td colspan=\"11\">-->\n\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t<td colspan=\"13\">\n\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t<td colspan=\"12\">\n\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t<td colspan=\"11\">\n\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t<!--IN065091 Start-->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =" \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="   \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\t\t\t\t\t \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="  \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t<tr>\n\t\t\t<td colspan=\'100%\'  class =\'CAGROUPHEADING\' style=\"border-top: 0.2em solid #a59d9d;border-bottom: 1px solid lightgray;\">";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</td>\n\t\t</tr>\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t<tr>\n\n\t<td width=\'\' nowrap class=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' ></td>\n\t<td width=\'\' nowrap class=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' ></td>\n\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t<td width=\'\' nowrap class=\'QRY11\'></td>\n\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t<td width=\'\' nowrap class=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\'></td>\n\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t<td width=\'\' nowrap class=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\'>\n\t\t<font size=1>";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</font>\n\t</td>\n";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\'>\n\t\t\t\t<font size=1>";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</font>\n\t\t\t</td>\n";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\'><font size=1>&nbsp;</font></td>\n";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\' >\n\t\t<font size=1>";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</font>\n\t</td>\n\n\t<td width=\'\' nowrap class=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</font>\n\t</td>\n\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t<td width=\'\' nowrap class=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\' title=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\'>\n\t\t<!-- \t<font size=1><a class=\'gridLink\' href=\'#\'  onClick=\"callMenuFunctions(\'View\',\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\',\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\')\">";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</font>  -->\n\t\t\t<font size=1><a class=\'gridLink\' href=\'#\'  onClick=\"callMenuFunctions(\'View\',\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="</font><!-- //ord_track -->\n\t\t<!--IN029948 Start-->\t\n\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t<a href=\'javascript: dummy()\' onClick=\"showDetailsPH(\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\')\">\n\t\t<img width=\'20\' height=\'20\' src=\'../../ePH/images/altenate.jpg\'/>\n\t\t</a>\n\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\n\t\t<!--IN029948 Ends-->\n\t\t</td>\n\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="</font>\n\t</td>\n\n\t<td width=\'\' nowrap style=\'height:18px;\tfont-family: Verdana, Arial, Helvetica, sans-serif;\tfont-size: 8pt;\tfont-weight:normal;text-align:left;padding-left:10px;padding-right:10px;vertical-align:middle;border-top:0px;border-left:0px;border-right:0px;border-style:solid;\' class=\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\' >\t\t\t<font size=1>\n";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t\t<img width=\'20\' height=\'20\' src=\'../../eCA/images/modifiedresult.png\' alt=\'Result Modified\'/>\n\t\t\t\t\t\n\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 =" <!--call Notes view  -->\n\t<!-- <a href=\"javascript:showNotes(\'";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="</a> -->\n\t\t\t<a class=\'gridLink\' href=\'#\' onClick=\"resultViewOrder(\'Result\',\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\',\'\',\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="</a>\n\t\t\t\t\n";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 =" <!-- Result View --> \n\t\t\t<a class=\'gridLink\' href=\'#\' onClick=\"resultViewOrder(\'Result\',\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="</a>\n";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t<input type=\"hidden\" name=\"Appt";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\" id=\"Appt";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\" value=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\">\n\t\t<input type=\"hidden\" name=\"Appt_date";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\" id=\"Appt_date";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\">\n\t\t<!--<input type=\"hidden\" name=\"performing_facility_id";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\" id=\"performing_facility_id";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\">--> <!-- IN054720 -->\n\t\t<input type=\"hidden\" name=\"appt_locn";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\" id=\"appt_locn";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\">\n\t\t<input type=\"hidden\" name=\"appt_resched_yn";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\" id=\"appt_resched_yn";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\">\n\t\t<input type=\"hidden\" name=\"appt_resched_reason";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\" id=\"appt_resched_reason";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\">\n\t\t<input type=\"hidden\" name=\"no_of_reschedules";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\" id=\"no_of_reschedules";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\">\n\t\t<input type=\"hidden\" name=\"item_narration";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\" id=\"item_narration";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\"> <!--IN059315-->\n\t\t<input type=\"hidden\" name=\"Order_Id";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\" id=\"Order_Id";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\"><!--IN64543-->\n\t\t<input type=\"hidden\" name=\"Order_line_num";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\" id=\"Order_line_num";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\"><!--IN64543-->\n ";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\n\t\t\t\t<a class=\"gridLink\" href=\"javascript:viewApptData(escape(\'";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\'))\"> \n";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n\t\t\t\t<a class=\"gridLink\" href=\"javascript:viewOAApptData(escape(\'";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\'))\"> \t\t\t\n";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\n\t\t\t\t<a class=\'gridLink\' href=\'#\' onClick=\"resultViewForRegisteredOrder(\'Result\',\'";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="</a>\n\t\t\t\t";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n\t\t<img title=\'";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\' src=\"../../eCA/images/MarkError.gif\"/>\n\t\t";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\n\t\t</font>\n\t\t</td>\n\t\t<!---Arvind-->\n\t\t";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\'>\n\t\t\t ";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\n\t\t\t\t<table><tr><a href=\'javascript:viewMedication(\"";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\",\"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\")\'><td \n\t\t\t\tstyle=\'BACKGROUND-COLOR:";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 =";\n\t\t\t\t\twidth:20px;\n\t\t\t\t\theight:20px;\' title=";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="></td></a></tr></table>\n\t\t\t";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\n\t\t\t</td> \n\t\t";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\n\t\t<!--ens-->\t\t\t\n\t\t<!-- 19112 Start.-->\n\t\t";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\t\t\n\t\t<td width=\'\' nowrap class=\'";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\'>&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\'>&nbsp;</td>\t\n\t\t";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\n\t\t<!-- 19112 End.-->\t\t\t\t\n\t\t<!-- added by Arvind -->\n\t\t<td  width=\'\' nowrap  class=\'";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\'><input type=\"checkbox\" name=\"chk";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\" id=\"chk";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\" value=\"N\" onClick=\'clickLine(this)\'  \n\t\t\t";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 =" ";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 =">\n\t\t\n\t\t<input type=\"hidden\" name=\"order_category";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\" id=\"order_category";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\">\n\t\t<input type=\"hidden\" name=\"order_status_";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\" id=\"order_status_";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\">\n\t\t<input type=\"hidden\" name=\"ord_typ_code";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\" id=\"ord_typ_code";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\" >\n\t\t<input type=\"hidden\" name=\"ord_typ_desc";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\" id=\"ord_typ_desc";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\" >\n\t\t<input type=\"hidden\" name=\"ord_id";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\" id=\"ord_id";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\" >\n\t\t<input type=\"hidden\" name=\"source_type";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\" id=\"source_type";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\" >\n\t\t<input type=\"hidden\" name=\"location_type";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\" id=\"location_type";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\" >\n\t\t<!--<input type=\"hidden\" name=\"location_code";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\" id=\"location_code";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\" >--><!--IN68663-->\n\t\t<input type=\"hidden\" name=\"location_code";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\" ><!--IN68663-->\n\t\t<input type=\"hidden\" name=\"cont_order_ind";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\" id=\"cont_order_ind";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\" ><!--IN054500-->\n\t\t<input type=\"hidden\" name=\"performing_facility_id";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\" ><!-- IN054720 -->\n";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\n\t\t<input type=\"hidden\" name=\"patient_class";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\" id=\"patient_class";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\" >\n\t\t<input type=\"hidden\" name=\"priority";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\" id=\"priority";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\" >\n";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\n\t\t</td>\n\t\t\n\t</tr>\n";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\n\t\t<tr>\n\t\t\t<td colspan=\'100%\'  class =\'CAGROUPHEADING\'>";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="</td>\n\t\t</tr>\n\n";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\n\n<tr>\n\n\t<td width=\'\' nowrap class=\'";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="</font>\n\t</td>\n\n";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\' >\n\t\t\t\t<font size=1>";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\' >\t<font size=1>&nbsp;</font></td>\n";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\n\n\t\t<td width=\'\' nowrap class=\'";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\'>\n\t\t\t<font size=1><a class=\'gridLink\' href=\'#\' onClick=\"callMenuFunctions(\'View\',\'";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="</font>\n<!--IN029948 Start-->\t\n\t\t";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\n\t\t\n\t\t\n<!--IN029948 Ends-->\n\t\t</td>\n\t";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\n\n\t<td width=\'\' nowrap class=\'";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\' >\t\t\t\t\t\t\t\t\t<font size=1>\n";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\n\t\t\t<img width=\'20\' height=\'20\' src=\'../../eCA/images/modifiedresult.png\' alt=\'Result Modified\'/>\n\t\t\t\t\t\t\n\t\t";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 =" <!--call Notes view  -->\n\t\t\t\t<a class=\'gridLink\' href=\'#\' onClick=\"resultViewOrder(\'Result\',\'";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 =" <!-- Result View --> \n \t\t\t\t<a class=\'gridLink\' href=\'#\' onClick=\"resultViewOrder(\'Result\',\'";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\n\t\t\t<input type=\"hidden\" name=\"Appt";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\">\n\t\t\t<input type=\"hidden\" name=\"Appt_date";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\">\n\t\t\t<input type=\"hidden\" name=\"appt_locn";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\">\n\t\t\t<input type=\"hidden\" name=\"appt_resched_yn";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\">\n\t\t\t<input type=\"hidden\" name=\"appt_resched_reason";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\">\n\t\t\t<input type=\"hidden\" name=\"no_of_reschedules";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\">\n\t\t\t<input type=\"hidden\" name=\"item_narration";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\"> <!--IN059315-->\n\t\t\t<input type=\"hidden\" name=\"Order_Id";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\"><!--IN64543-->\n\t\t\t<input type=\"hidden\" name=\"Order_line_num";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\"><!--IN64543-->\n";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\n\t\t\t\t\t<a class=\"gridLink\" href=\"javascript:viewApptData(escape(\'";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\n\t\t\t\t\t<a class=\"gridLink\" href=\"javascript:viewOAApptData(escape(\'";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\n\t</font>\n\t</td>\n\t<!-- 19112 Start.-->\n\t";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="</td>\n\t";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\'>&nbsp;</td>\t\n\t";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\n\t<!-- 19112 End.-->\t\n\t<td  width=\'\' nowrap class=\'";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\" value=\"N\" onClick=\'clickLine(this)\' ";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 =">\n\t\t<input type=\"hidden\" name=\"order_category";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\" >\n\t\t<input type=\"hidden\" name=\"location_code";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\">\n\t\t<input type=\"hidden\" name=\"cont_order_ind";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\n\t</td>\n\n</tr>\n";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\n\t\t<tr>\n\t\t\t<td colspan=\'100%\' class =\'CAGROUPHEADING\'>";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\n<tr>\n\n\t<td width=\'\' nowrap class=\'";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\' >\n\t\t\t\t<font size=1>&nbsp;</font>\n\t\t\t</td>\n";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\'>\n\t\t\t<!-- <font size=1><a class=\'gridLink\' href=\'#\' onClick=\"callMenuFunctions(\'View\',\'";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\')\"> ";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="</font> -->\n\t\t\t<font size=1><a class=\'gridLink\' href=\'#\' onClick=\"callMenuFunctions(\'View\',\'";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="</font><!-- //ord_track -->\n\t\t\t<!--IN029948 Start-->\t\n\t\t";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\n\t</font>\n\t</td>\n\t<!-- 19112 Start.-->\n\t\t";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\n\t<!-- 19112 End.-->\t\n\t<td width=\'\' nowrap class=\'";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\" >\n\t\t<input type=\"hidden\" name=\"cont_order_ind";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\n\t</td>\n</tr>\n";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\n\t\t\t\t<tr>\n\t\t\t\t\t<td colspan=\'100%\'  class =\'CAGROUPHEADING\'>";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="/";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="</td>\n\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\n<tr>\n\t<td width=\'\' nowrap class=\'";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\' >\t\n\t\t<font size=1>";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\' >\t\n\t\t\t\t<font size=1>";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\' >\n\t\t\t<!-- <font size=1><a class=\'gridLink\' href=\'#\' onClick=\"callMenuFunctions(\'View\',\'";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="</font> -->\n\t\t\t <font size=1><a class=\'gridLink\' href=\'#\' onClick=\"callMenuFunctions(\'View\',\'";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="</font><!-- //ord_track --> \n\t\t\t\n<!--IN029948 Start-->\t\n\t\t";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\'>";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\n\t<!-- 19112 End.-->\t\n\t<td  width=\'\' nowrap  class=\'";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\n<tr>\n\n\t\t<td width=\'\' nowrap class=\'";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\' ></td>\n\t\t<td width=\'\' nowrap class=\'";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\' ></td>\n\t\t";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\' >\t\n\t\t\t<font size=1>";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="</font>\n\t\t</td>\n";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\' >\n\t\t\t<font size=1>";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\n\t\t\t\t<td width=\'\' nowrap class=\'";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\' >\t\n\t\t\t\t\t<font size=1>";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="</font>\n\t\t\t\t</td>\n";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="</font>\n\t\t</td>\n\n\t\t<td width=\'\' nowrap class=\'";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="</font>\n\t\t</td>\n\t\t";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="\'>\n\t\t\t\t<!-- <font size=1><a class=\'gridLink\' href=\'#\' onClick=\"callMenuFunctions(\'View\',\'";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="</font> -->\n\t\t\t\t<font size=1><a class=\'gridLink\' href=\'#\' onClick=\"callMenuFunctions(\'View\',\'";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="</font><!-- //ord_track -->\n\t\t\t\t\n<!--IN029948 Start-->\t\n\t\t";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="\n\t\t\n\t\t\n<!--IN029948 Ends-->\n\t\t\t</td>\n\t\t";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 =" <!-- Result View --> \n\t\t\t\t<a class=\'gridLink\' href=\'#\' onClick=\"resultViewOrder(\'Result\',\'";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="</font>\n\t\t</td>\n\n";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="</font>\n\t\t</td>\n\n\t\t<td width=\'\' nowrap  class=\'";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\'>\n\t\t<!-- \t\t<font size=1><a class=\'gridLink\' href=\'#\' onClick=\"callMenuFunctions(\'View\',\'";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="</font> -->\n\t\t<font size=1><a class=\'gridLink\' href=\'#\' onClick=\"callMenuFunctions(\'View\',\'";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="</font><!-- //ord_track --> \n\n<!--IN029948 Start-->\t\n\t\t";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 =" <!--call Notes view  -->\n\t\t\t\t<!-- <a href=\"javascript:showNotes(\'";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="</a> -->\n\t\t\t\t<a class=\'gridLink\' href=\'#\' onClick=\"resultViewOrder(\'Result\',\'";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\n\t<!-- 19112 End.-->\t\n\t<td  width=\'\' nowrap Align=\'left\' class=\'";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="\" ><!--IN054500 -->\n\t\t<input type=\"hidden\" name=\"performing_facility_id";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="\n</table>\n\t<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="\">\n\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="\">\n\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="\">\n\t<input type=\"hidden\" name=\"order_entry\" id=\"order_entry\" value=\"ExistingOrder\">\n\t<input type=\"hidden\" name=\"patientId\" id=\"patientId\" value=\"";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="\">\n\t<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\" value=\"";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="\">\n\n";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="\n\t<input type=\"hidden\" name=\"total_recs\" id=\"total_recs\" value=\"";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 ="\" >\n\t<input type=\"hidden\" name=\"hidden_cunt\" id=\"hidden_cunt\" value=\"";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="\" >\n <!-- Parameters from the search screen --> \n\n\t<input type=\"hidden\" name=\"order_status\" id=\"order_status\" value=\"";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="\" >\n\t<input type=\"hidden\" name=\"pat_id1\" id=\"pat_id1\" value=\"";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="\" >\n\t<input type=\"hidden\" name=\"encounterId\" id=\"encounterId\" value=\"";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 ="\" >\n\t<input type=\"hidden\" name=\"period_from\" id=\"period_from\" value=\"";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 ="\" >\n\t<input type=\"hidden\" name=\"period_to\" id=\"period_to\" value=\"";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="\" >\n\t<input type=\"hidden\" name=\"location_type\" id=\"location_type\" value=\"";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 ="\" >\n\t<input type=\"hidden\" name=\"locn\" id=\"locn\" value=\"";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 ="\" >\n\t<input type=\"hidden\" name=\"order_cat\" id=\"order_cat\" value=\"";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="\" >\n\t<input type=\"hidden\" name=\"order_type\" id=\"order_type\" value=\"";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 ="\" >\n\t<input type=\"hidden\" name=\"order_by\" id=\"order_by\" value=\"";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 ="\" >\n\t<input type=\"hidden\" name=\"view_by\" id=\"view_by\" value=\"";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 ="\" >\n\t<input type=\"hidden\" name=\"curr_sys_date\" id=\"curr_sys_date\" value=\"";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 ="\" >\n\t<input type=\"hidden\" name=\"order_catelog\" id=\"order_catelog\" value=\"";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );

    private final static java.lang.String  _wl_block267 ="\" >\n\t<input type=\"hidden\" name=\"ordering_pract\" id=\"ordering_pract\" value=\"";
    private final static byte[]  _wl_block267Bytes = _getBytes( _wl_block267 );

    private final static java.lang.String  _wl_block268 ="\" >\n\t<input type=\"hidden\" name=\"priority\" id=\"priority\" value=\"";
    private final static byte[]  _wl_block268Bytes = _getBytes( _wl_block268 );

    private final static java.lang.String  _wl_block269 ="\" >\n\t<input type=\"hidden\" name=\"search_crt\" id=\"search_crt\" value=\"";
    private final static byte[]  _wl_block269Bytes = _getBytes( _wl_block269 );

    private final static java.lang.String  _wl_block270 ="\" >\n\t<input type=\"hidden\" name=\"practitioner_id\" id=\"practitioner_id\" value=\"";
    private final static byte[]  _wl_block270Bytes = _getBytes( _wl_block270 );

    private final static java.lang.String  _wl_block271 ="\" >\n\t<input type=\"hidden\" name=\"activity_type\" id=\"activity_type\" value=\"";
    private final static byte[]  _wl_block271Bytes = _getBytes( _wl_block271 );

    private final static java.lang.String  _wl_block272 ="\" >\n\t<input type=\"hidden\" name=\"elapsed_orders\" id=\"elapsed_orders\" value=\"";
    private final static byte[]  _wl_block272Bytes = _getBytes( _wl_block272 );

    private final static java.lang.String  _wl_block273 ="\" >\n\t<input type=\"hidden\" name=\"sys_cancelled_orders\" id=\"sys_cancelled_orders\" value=\"";
    private final static byte[]  _wl_block273Bytes = _getBytes( _wl_block273 );

    private final static java.lang.String  _wl_block274 ="\" >\n\t<input type=\"hidden\" name=\"current_ip_list_check\" id=\"current_ip_list_check\" value=\"";
    private final static byte[]  _wl_block274Bytes = _getBytes( _wl_block274 );

    private final static java.lang.String  _wl_block275 ="\" ><!--IN049050-->\n\t<!-- Till here --> \n\t<!-- Next, Prev --> \n\t<input type=\"hidden\" name=\"from\" id=\"from\" value=\"";
    private final static byte[]  _wl_block275Bytes = _getBytes( _wl_block275 );

    private final static java.lang.String  _wl_block276 ="\" >\n\t<input type=\"hidden\" name=\"to\" id=\"to\" value=\"";
    private final static byte[]  _wl_block276Bytes = _getBytes( _wl_block276 );

    private final static java.lang.String  _wl_block277 ="\" >\n\t<input type=\"hidden\" name=\"BTColorYN\" id=\"BTColorYN\" value=\"";
    private final static byte[]  _wl_block277Bytes = _getBytes( _wl_block277 );

    private final static java.lang.String  _wl_block278 ="\" ><!--IN065091-->\n\t<input type=\"hidden\" name=\"eSignatureYN\" id=\"eSignatureYN\" value=\"";
    private final static byte[]  _wl_block278Bytes = _getBytes( _wl_block278 );

    private final static java.lang.String  _wl_block279 ="\" > <!-- 25671  -->\n\t<input type=\"hidden\" name=\"includeESignature\" id=\"includeESignature\" value=\"\" > <!-- 25671  -->\n\t<!-- Next, Prev Till here--> \n\t<script>\n\t\t//if(parent.framePatOrderByPrHeaderDtl.document.getElementById(\"tableheader\")==null)\n\t\t//{\n\t\t\t//setTimeout(\"alignHeading();\",300);\n\t\t//}\n\t\t//else \n\t\t\t//alignHeading();\n\t</script>\n</form>\n<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:12%; visibility:hidden;\' bgcolor=\'blue\'>\n\t<table id=\'tooltiptable\' cellpadding=0 cellspacing=0 border=\'0\'  width=\'100%\' height=\'100%\' align=\'center\'>\n\t\t<tr>\n\t\t\t<td width=\'100%\' id=\'t\'></td>\n\t\t</tr>\n\t</table>\n</div>\n</body>\n<script>parent.framePatOrderByPrivRelnSearch.document.PatOrderByPrivReln_search.search.disabled= false;</script>\n<script>\n\tif(\'";
    private final static byte[]  _wl_block279Bytes = _getBytes( _wl_block279 );

    private final static java.lang.String  _wl_block280 ="\' == \'H\')\n\t\tondetail();\n</script>\n</html>\n\n \n\n";
    private final static byte[]  _wl_block280Bytes = _getBytes( _wl_block280 );

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
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
*/
/*
----------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        		Rev.Date		Rev.Name			Description
----------------------------------------------------------------------------------------------------------------------------------------------
?             100            ?           										created
26/06/2012    IN033488      Chowminya G      									Incident No: IN033488 -  Error Marking - Result completed indicator> 
24/07/2012    IN033493      Chowminya G      									Incident No: IN033493 -  Order Tracking>hyperlink-appointment details with text 
12/12/2012    IN035317      Chowminya G      									Incident No: IN035317 -  System should also display the external prescription record at CA - Order Tracking 
20/12/2012    IN035618	    Vijayakumar K	    								No Hyper Link For Partial Resulted
09/04/2013    IN039195      Chowminya G        									Not able To View Results For Resulted Modified In Order Tracking
05/06/2013    IN029948		Nijitha  S     							 			Bru-HIMS-CRF-082
06/06/2013    IN040198.1    Chowminya G       									Reopen - Status of the Order Catalog is displayed wrongly
04/09/2013	  IN042630		Karthi L											The color displayed wrongly at Medication Administration details in Order tracking.	
05/02/2014 	  IN047918		NijithaS											KDAH-CRF-0284
08/05/2014	  IN048935		Nijitha S											ML-BRU-SCF-1318	- In the existing order tab, once a drug has been discontinued, the order status changes to Discontinued However the MAR status in the existing order still remains as In Progress
04/05/2014	  IN049050		Nijitha S											KDAH-CRF-0284/01 - Discharged Patient displayed in Order Tracking Function
04/03/2014	  IN053433		Nijitha S											ML-BRU-SCF-1545
17/03/2015	  IN054500		Vijayakumar K										Specimen result report is not printing 
03/06/2015	  IN054720		Vijayakumar K	03/06/2015							ML-BRU-SCF-1580 [IN:054720]																				
09/10/2015	  IN055910		Karthi L	    									From Clinician Access, modified result shall be identified by include "!" in Blue color																				
21/10/2015	  IN058125		Karthi L											Modified icon is showing for Registration Status.								
08/03/2016		IN059490		Karthi L										After placing orders, in Existing order â?? keeping the Status as active and click search takes more than 1 minute to display the ordered details.[AAKH-SCF-0252]							
15/08/2016		IN059315		Raja S										When an appointment is given is RIS PACS for a radiology order placed from eHIS the order status in eHIS changes to Appointment Scheduled. But the actual appointment display is in order comments and in the Audit trail.
12/05/2017	IN063781		Krishna Gowtham J	12/05/2017		Ramesh G		ML-MMOH-CRF-0804	
28/08/2017	IN065091		Krishna Gowtham J 	29/08/2017		Ramesh G		GHL-CRF-0440.1
24/04/2018  	IN067360		Sharanraj			24/04/2018		Ramesh G	 OR-ML-MMOH-CRF-1071/01-Order Tracking
17/04/2018        IN066414		Sharanraj	  17/04/2018		Ramesh G		ML-MMOH-CRF-1071
11/06/2018        IN067921              Sharanraj         11/06/2018            Ramesh G                OR-Common-Order Tracking
06/06/2018    	  IN08078		Sharanraj	  12/06/2018		Ramesh G		ML-MMOH-SCF-1011
07/09/2018   	  IN068616		sivabagyam M      18/07/2018		Ramesh G		GHL-CRF-0433
17/09/2018		IN068663		Dinesh T			17/09/2018		Ramesh G	MMS-QF-SCF-0589	
05/11/2018		IN068986		Ramya Maddena		05/11/2018		Ramesh G	MO-CRF-20137.1
28/09/2020		ord_track		Nijitha S			28/09/2020		Nijitha S	Interaction Dtls not working in order tracking			
16/08/2021		19112			Ramesh												NMC-JD-CRF-0106
24/02/2022	 	25671			Ramesh G									NMC-JD-CRF-0091.2
03/07/2022		29803			Ramesh G									ML-BRU-CRF-0635
----------------------------------------------------------------------------------------------------------------------------------------------
*/ 

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            eOR.PatOrderByPrivRelQueryBean bean= null;{
                bean=(eOR.PatOrderByPrivRelQueryBean)pageContext.getAttribute("bean");
                if(bean==null){
                    bean=new eOR.PatOrderByPrivRelQueryBean();
                    pageContext.setAttribute("bean",bean);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);
  
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	/* Mandatory checks start */
			String bean_id = "Or_PatOrderByPrivRelnBean" ;
			String bean_name = "eOR.PatOrderByPrivRelnBean";
		bean.setLanguageId(localeName);

	/* Mandatory checks end */

//		PatOrderByPrivRelnBean bean = (PatOrderByPrivRelnBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
		//PatOrderByPrivRelnBean beanObj = (PatOrderByPrivRelnBean)getBeanObject( bean_id, bean_name, request ) ;
  		String mode	   = "1";//request.getParameter( "mode" ) ;
		//beanObj.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
		//beanObj.setMode( mode ) ;

		String from	 = bean.checkForNull(request.getParameter( "from" ),"1") ;
		String to	 = bean.checkForNull(request.getParameter( "to" ),"7") ;
		String TrackingDate="";
		String TrackingEndDate="";
 		int start	 = Integer.parseInt(from);
		int end		 = Integer.parseInt(to);
		String total_query_records = "0";
		String practitioner_type = (String) session.getValue("practitioner_type");
		if(practitioner_type== null) practitioner_type = "";
/* 		if(from!=null && from.equals("1")) {
 			beanObj.clear() ;
		}
*/
		//String session_id= bean.getSessionId();
		//String tmpstr =new String();
		String slClassValue = "";
		int check_count = 0;

		//ArrayList searchData=new ArrayList();
		//19112 Start.
		Connection connection =  null;	
		boolean isSiteSpecificBillStatus = false; 
		boolean isSiteSpecificESignature = false;  //25671
		try{
			connection = ConnectionManager.getConnection(request); 	
			isSiteSpecificBillStatus = eCommon.Common.CommonBean.isSiteSpecific(connection, "OR","BILL_STATUS_DISPLAY");
			isSiteSpecificESignature = eCommon.Common.CommonBean.isSiteSpecific(connection, "OR","ESIGNATURE_REQUIRED");   //25671
		}catch(Exception e){
			out.println("Exception@1: "+e);
		}finally{
			if(connection!=null)	ConnectionManager.returnConnection(connection,request);
		}
		//19112 End.
		//25671 Start.
		String eSignatureYN ="N";
		if(isSiteSpecificESignature)
			eSignatureYN ="Y";
		//25671 End.
Properties properties		= (Properties) session.getValue( "jdbc" );  

String order_status = request.getParameter( "order_status" ) ;
if(order_status == null || order_status.equals("null")) order_status =""; else order_status = order_status.trim();

String patientId = request.getParameter( "pat_id1");
if(patientId == null || patientId.equals("null")) patientId =""; else patientId = patientId.trim();

String encounterId = request.getParameter( "encounterId");
if(encounterId == null || encounterId.equals("null")) encounterId =""; else
	encounterId = encounterId.trim();

String period_from = request.getParameter( "period_from" ) ;
if(period_from == null || period_from.equals("null")) period_from =""; else
	period_from = period_from.trim();

String period_to = request.getParameter( "period_to" ) ;
if(period_to == null || period_to.equals("null")) period_to =""; else
		period_to = period_to.trim();

String location_type = request.getParameter( "location_type");
if(location_type == null || location_type.equals("null")) location_type =""; else location_type = location_type.trim();

String locn = request.getParameter( "locn");
if(locn == null || locn.equals("null")) locn =""; else locn = locn.trim();

String ord_category = request.getParameter( "order_cat");
if(ord_category == null || ord_category.equals("null")) ord_category =""; else ord_category = ord_category.trim();

String order_type = request.getParameter( "order_type");
if(order_type == null || order_type.equals("null")) order_type =""; else order_type = order_type.trim();

String order_by = request.getParameter( "order_by");
if(order_by == null || order_by.equals("null")) order_by =""; else order_by = order_by.trim();

String view_by = request.getParameter("view_by");
if(view_by == null || view_by.equals("null")) view_by = ""; else view_by = view_by.trim();

String curr_sys_date = 	 request.getParameter( "curr_sys_date");
if(curr_sys_date == null || curr_sys_date.equals("null")) curr_sys_date =""; else curr_sys_date = curr_sys_date.trim();

String order_catelog= request.getParameter( "order_catelog");
if(order_catelog == null || order_catelog.equals("null")) order_catelog =""; else order_catelog = order_catelog.trim();

String ordering_pract= request.getParameter( "ordering_pract");
if(ordering_pract == null || ordering_pract.equals("null")) ordering_pract =""; else ordering_pract = ordering_pract.trim();

String priority= request.getParameter( "priority");
if(priority == null || priority.equals("null")) priority =""; else priority = priority.trim();

String search_crt=request.getParameter("search_crt");

if(search_crt == null || search_crt.equals("null")) search_crt =""; else search_crt = search_crt.trim();

//IN065091 start
String BTColorYN = request.getParameter("BTColorYN");
if(BTColorYN == null || BTColorYN.equals("null")) BTColorYN = ""; else BTColorYN = BTColorYN.trim();
//IN065091 ends
String practitioner_id=request.getParameter("practitioner_id");
if(practitioner_id == null || practitioner_id.equals("null")) practitioner_id =""; else practitioner_id = practitioner_id.trim();
String elapsed_orders=request.getParameter("elapsed_orders");
if(elapsed_orders == null || elapsed_orders.equals("null")) elapsed_orders =""; else elapsed_orders = elapsed_orders.trim();
String sys_cancelled_orders=request.getParameter("sys_cancelled_orders");
if(sys_cancelled_orders == null || sys_cancelled_orders.equals("null")) sys_cancelled_orders =""; else sys_cancelled_orders = sys_cancelled_orders.trim();

String activity_type = request.getParameter("activity_type")==null?"":request.getParameter("activity_type");
//String practitioner_type = (String)session.getValue("practitioner_type");
String facility_id = (String)session.getValue("facility_id");
bean.setLoginFacilityId(facility_id);//IN053433
//String resp_id = (String)session.getValue("responsibility_id");
String rd_install = "N";
String ot_install = "N";
//rd_install = bean.getRadiology(facility_id);
//included condition for --[IN033493]
if(ord_category.equals("RD") || ord_category.equals("OT") || ord_category.equals(""))
{
	rd_install = bean.getFacilityModuleInstallYn("RD", facility_id, properties);
	ot_install = bean.getFacilityModuleInstallYn("OT", facility_id, properties);
}

//ot_install = bean.getOTModule(facility_id);
String current_ip_list_check = request.getParameter("current_ip_list_check")==null?"N":request.getParameter("current_ip_list_check");//IN047918

String appt_ref_num ="";
String appt_date    = "";
String appt_locn	 ="";
String appt_resched_yn    = "N";
String appt_resched_reason ="";
String no_of_reschedules     = "";
String item_narration= ""; //IN059315
String ph_colors	= "";
int i= 0;

String last_action_type		= "";
String accession_num 		= "";
String ext_appl_accession_num 		= "";
String accession_num_tooltip 		= "";
String action_type    = "";//--[IN033488]
String action_date_time    = "";
String action_by_id    = "";
ArrayList ErrStatusChk		= null;
String bt_ack_YN = "";//IN065091
ArrayList resultData=new ArrayList();
//ArrayList AppointmentDetails  = null;

try
{
    if (location_type.equals("W")) location_type = "N";
//	if(from!=null && from.equals("1")) {
  		//resultData=(ArrayList)bean.getSearchResultDetails(properties, order_status,patientId,encounterId,period_from,period_to,location_type,locn,ord_category,order_type,order_catelog, priority,search_crt,order_by,practitioner_id,ordering_pract,activity_type,view_by,practitioner_type,elapsed_orders,sys_cancelled_orders,start,end);//IN047918		
  		resultData=(ArrayList)bean.getSearchResultDetails(properties, order_status,patientId,encounterId,period_from,period_to,location_type,locn,ord_category,order_type,order_catelog, priority,search_crt,order_by,practitioner_id,ordering_pract,activity_type,view_by,practitioner_type,elapsed_orders,sys_cancelled_orders,start,end,current_ip_list_check);//IN047918
		// Setting as a persistence bean
//		beanObj.setDetails(resultData);
		// Persist it
//		putObjectInBean(bean_id,beanObj,request);
 //	} else {
//		resultData=beanObj.getDetails();
 // 	}
 
}catch(Exception e){
	e.printStackTrace();
}

if(resultData!=null && resultData.size() == 0)
{
		{
            _bw.write(_wl_block9Bytes, _wl_block9);
}					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common')); location.href='../../eCommon/html/blank.html' </script>");
}

/* Initialize Function specific end */

            _bw.write(_wl_block10Bytes, _wl_block10);

			if(order_by.equals("P"))
			{
		
            _bw.write(_wl_block11Bytes, _wl_block11);
 if("L".equals(view_by)&&"Y".equals(BTColorYN)){
            _bw.write(_wl_block12Bytes, _wl_block12);

				}//IN065091 ends
				if(view_by.equals("H"))
				{
			
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

				}
				else
				{
			
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

				}
			
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
 if((ord_category.equals("PH")||ord_category.equals(""))&&view_by.equals("L")){
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
}
            _bw.write(_wl_block21Bytes, _wl_block21);
 if(isSiteSpecificBillStatus && view_by.equals("L")){
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
}
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

		}
		else if(order_by.equals("T"))
		{
		
            _bw.write(_wl_block24Bytes, _wl_block24);
 if("L".equals(view_by)&&"Y".equals(BTColorYN)){
            _bw.write(_wl_block12Bytes, _wl_block12);

				}//IN065091 ends
			
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

			if(view_by.equals("H"))
			{
			
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

			}
			else
			{
		
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

			}
		
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
 if(isSiteSpecificBillStatus && view_by.equals("L")){
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
}
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

		}
		else
		{
		
            _bw.write(_wl_block31Bytes, _wl_block31);
 if("L".equals(view_by)&&"Y".equals(BTColorYN)){
            _bw.write(_wl_block12Bytes, _wl_block12);

				}//IN065091 ends
			
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

				if(view_by.equals("H"))
				{
			
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

					}
					else
					{
				
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

					}
				
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);
 if(isSiteSpecificBillStatus && view_by.equals("L")){
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
}
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);
}
            _bw.write(_wl_block39Bytes, _wl_block39);

try
{

	String Pat_details		= "";
	String Order_cat		= "";
	String Order_type		= "";
	String Loc_details		= "";
	String Loc_detail		= "";
	String location			= "";
	String Date_details		= "";
	String temp_grpby		= "";
	String sex				= "";
	String Pat_Id			= "";
	String Order_Id			= "";
	String result_link		= "";
	String cont_order_ind	= "";
	String Order_cat_code	= "";
	String age				= "";
	String Priority_desc	= "";
	String source_type		= "";
	String Pat_name			= "";
	String sex1				= "";
	String descpriority		= "";
	String check_enable		= "";
	String displayChk		= "";
	String orderStatus		= "";
	ArrayList GroupBy		= null;
	String [] colorString	= {"X","X","X","X"};
	StringTokenizer colorTokenizer = null;
	String performing_facility_id = facility_id;

	//String color_string  = "";
	//String Ord_status="";
	String Order_line_num="";
	StringTokenizer menu_options = null;
	String Replaced_Order = "";
	String Original_Order = "";
	StringBuffer strOrderCtl = new StringBuffer();	
	String tepm_order_id="";
	String alternate="";//IN029948
	String lb_rslt_mod_status = ""; //HSA-CRF-0257.1 - IN055910
	String isResultModified = ""; //HSA-CRF-0257.1-02 IN058125	
	String ord_catalog_code = ""; //HSA-CRF-0257.1-02 IN058125
	ArrayList specList = null; //HSA-CRF-0257.1-02 IN058125	
	String pat_encounter_id = "";//ord_track
	String billingStatus="";//19112
	//String Order_catalog="";
	//if(resultData.size() < 7 || end > resultData.size()) {
	//			end = resultData.size();
	// }	
	//for(int i=0;i<resultData.size();i++){		
	for(int k=0;k<resultData.size();k++)
	{
	//	for(int k=(start-1);k<end;k++){
 		GroupBy	=(ArrayList)resultData.get(k);

		if(k==0)
		{ 
			if(view_by.equals("L"))
			{				
				//IN068986 Start.
				/*if(GroupBy.size()>=46) //Modified for IN059315
					total_query_records = bean.checkForNull((String)GroupBy.get(45),"0"); //Added for IN065091
				*/
				/* if(GroupBy.size()>=47) //Modified for IN059315
					total_query_records = bean.checkForNull((String)GroupBy.get(46),"0"); */
				//IN068986 End.
				//19112 Start.
				//if(GroupBy.size()>=48) //Modified for IN059315//ord_track
				//	total_query_records = bean.checkForNull((String)GroupBy.get(47),"0");//ord_track
				if(GroupBy.size()>=49) //Modified for IN059315//Ramesh
					total_query_records = bean.checkForNull((String)GroupBy.get(48),"0");//Ramesh	
				//19112 End.
			}
			else
			{
				//IN054720 starts
				/*if(GroupBy.size()>=29)
					total_query_records = bean.checkForNull((String)GroupBy.get(28),"0");*/
			/*	if(GroupBy.size()>=30)
					total_query_records = bean.checkForNull((String)GroupBy.get(29),"0"); */
				//IN054720 ends - commented for HSA-CRF-0257.1 - IN055910 
				/*IN067921 starts*/
				//if(GroupBy.size()>=31)
				//if(GroupBy.size()>=34)//IN68663
					//total_query_records = bean.checkForNull((String)GroupBy.get(30),"0");
					//total_query_records = bean.checkForNull((String)GroupBy.get(33),"0");
					//total_query_records = bean.checkForNull((String)GroupBy.get(33),"0");//IN68663
				/*IN067921 Ends*/		
				//HSA-CRF-0257.1 - IN055910 - End		
				//IN68663, starts
			/* 	if(GroupBy.size()>=34)
					total_query_records = bean.checkForNull((String)GroupBy.get(33),"0"); */
				//IN68663, ends
				if(GroupBy.size()>=35)//ord_track
					total_query_records = bean.checkForNull((String)GroupBy.get(34),"0");//ord_track
			}
			if((Integer.parseInt(total_query_records)>0) || (start>1))
			{

            _bw.write(_wl_block40Bytes, _wl_block40);
 if("L".equals(view_by)&&"Y".equals(BTColorYN) && isSiteSpecificBillStatus){
            _bw.write(_wl_block41Bytes, _wl_block41);

				}else if("L".equals(view_by)&& ("Y".equals(BTColorYN) ||isSiteSpecificBillStatus)){
            _bw.write(_wl_block42Bytes, _wl_block42);

				}else{
				
            _bw.write(_wl_block43Bytes, _wl_block43);

					}
				
            _bw.write(_wl_block44Bytes, _wl_block44);
            {java.lang.String __page ="ResultScrolling.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("from"), weblogic.utils.StringUtils.valueOf(start
                        )},{ weblogic.utils.StringUtils.valueOf("to"), weblogic.utils.StringUtils.valueOf(end
                        )},{ weblogic.utils.StringUtils.valueOf("total_size"), weblogic.utils.StringUtils.valueOf(total_query_records
                        )},{ weblogic.utils.StringUtils.valueOf("check_box_name"), weblogic.utils.StringUtils.valueOf("chk")},{ weblogic.utils.StringUtils.valueOf("form_name"), weblogic.utils.StringUtils.valueOf("formPatOrderByPRSearchResult")},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block51Bytes, _wl_block51);

			}
		}  
		Pat_details			= bean.checkForNull((String)GroupBy.get(17),"");
		Pat_name			= bean.checkForNull((String)GroupBy.get(17),"");		
		Order_cat			= bean.checkForNull((String)GroupBy.get(1),"");			
		Order_cat_code	= bean.checkForNull((String)GroupBy.get(0),""); 
		Order_type			= bean.checkForNull((String)GroupBy.get(3),"");		
		Loc_details			= bean.checkForNull((String)GroupBy.get(10),"");		
		Date_details		= bean.checkForNull((String)GroupBy.get(14),"");		
		orderStatus		= bean.checkForNull((String)GroupBy.get(9),"");		
		if(!localeName.equals("en"))
		{ 
			Date_details=com.ehis.util.DateUtils.convertDate(Date_details,"DMY","en",localeName);
		}
		
		Pat_Id					= bean.checkForNull((String)GroupBy.get(11),"");
		Order_Id				= bean.checkForNull((String)GroupBy.get(13),"");
		if(view_by.equals("L"))
		{
			if(!tepm_order_id.equals(Order_Id))
			{
				check_enable  = "";
				tepm_order_id = Order_Id; 
				
			}
			else
			{
				check_enable = "style='display:none'";
				//displayChk="style='display:none'";
				check_count++;
			}
		}
		else
		{
			check_enable = "";
		}
		Priority_desc		= bean.checkForNull((String)GroupBy.get(4),"");
		source_type		= bean.checkForNull((String)GroupBy.get(5),"");
		descpriority			= bean.checkForNull((String)GroupBy.get(4),"");
		if(view_by.equals("L"))
		{
			sex								= bean.checkForNull((String)GroupBy.get(20),"");
			age								= bean.checkForNull((String)GroupBy.get(35),"");
			result_link						= bean.checkForNull((String)GroupBy.get(21),"");
			cont_order_ind					= bean.checkForNull((String)GroupBy.get(22),"");
			performing_facility_id			= bean.checkForNull((String)GroupBy.get(36),"");
			Order_line_num					= bean.checkForNull((String)GroupBy.get(23),"");
			menu_options					= new StringTokenizer((String)GroupBy.get(38),"|");
			alternate						= bean.checkForNull((String)GroupBy.get(41),"");//IN029948
			ord_catalog_code				= bean.checkForNull((String)GroupBy.get(42),"");//HSA-CRF-0257.1-02 IN058125
			pat_encounter_id 				= bean.checkForNull((String)GroupBy.get(46),"");//ord_track
			//19112 Start.
			billingStatus					= bean.checkForNull((String)GroupBy.get(47),"");//19112
			if("B".equals(billingStatus))
				billingStatus	= "Billed&nbsp;<img src='../../eOR/images/Billed.png' border='0'  title='Billed'/>";
			else if("U".equals(billingStatus))
				billingStatus	= "Unbilled&nbsp;<img src='../../eOR/images/Unbilled.png' border='0'  title='Unbilled'/>";
			
			if("DC".equals(orderStatus)||"CN".equals(orderStatus))
				billingStatus = "";
			//19112 End.			
		}
		else
		{
			sex								= bean.checkForNull((String)GroupBy.get(18),"");
			age								= bean.checkForNull((String)GroupBy.get(24),"");
			result_link						= bean.checkForNull((String)GroupBy.get(19),"");
			cont_order_ind	 				= bean.checkForNull((String)GroupBy.get(20),"");
			Order_line_num					= "";
			menu_options					= new StringTokenizer((String)GroupBy.get(25),"|");
			performing_facility_id			= bean.checkForNull((String)GroupBy.get(28),"");//IN054720
			pat_encounter_id 				= bean.checkForNull((String)GroupBy.get(33),"");//ord_track
		}
		
		if(menu_options.hasMoreTokens())
		{
			Replaced_Order					= menu_options.nextToken();  //VIEW_REPLACED_ORDER
			if(menu_options.hasMoreTokens())//IN067360
			Original_Order					= menu_options.nextToken();  //VIEW_ORIGINAL_ORDER			
		}
		if(view_by.equals("L"))
		{
			GroupBy.set(39,Replaced_Order);//VIEW_REPLACED_ORDER
			GroupBy.set(40,Original_Order);//VIEW_ORIGINAL_ORDER	
		}
		else
		{
			/*IN067360 starts*/
			//GroupBy.set(26,Replaced_Order);//VIEW_REPLACED_ORDER
			if(!appt_ref_num.equals(""))
			{
				GroupBy.set(26,Replaced_Order);//VIEW_REPLACED_ORDER	
			}
			/*IN067360 ends*/
			GroupBy.set(27,Original_Order);//VIEW_ORIGINAL_ORDER
		}
		//Ord_status	= (String)GroupBy.get(16);
		//Order_line_num= (String)GroupBy.get(23);
		//Order_catalog = (String)GroupBy.get(15);
		String order_details = (String)GroupBy.get(15);
		if(order_details.indexOf("$$RD##")!=-1)
		{
			String[] str = (String[])order_details.split("!~!");
			String order_detail ="";
			String[] strtitle = null;
			for(int s=0;s<str.length;s++)
			{
				if(str[s].indexOf("$$RD##")!=-1)
				{
					String line_order = (String)str[s];
					strtitle  =line_order.split("::");
					String titleText = "";
					if(strtitle[1].length()>0)
					{
						titleText = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderedFromRadiology.label","or_labels")+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Reason.label","or_labels")+":"+ strtitle[1];
					}
					else
					{
						titleText = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderedFromRadiology.label","or_labels");
					}
					strtitle[0] = "<img src='../../eOR/images/IN_RD_ADD_TEST.gif' title='"+titleText+"'>";
					order_detail = order_detail+strtitle[0]+strtitle[2]+", ";
				}
				else
				{
					order_detail = order_detail+str[s]+", ";
				}
			}
			order_details = order_detail;
			if(order_details.lastIndexOf(",") ==((order_details.length())-2))
			{
				order_details = order_details .substring(0,((order_details.length())-2));
			}
		}
		if(order_details.indexOf("!~!")!=-1)
		{
			order_details = order_details.replace("!~!",",");
		}
			
		if(descpriority.equals("R"))
		{
			descpriority=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
		}
		else if(descpriority.equals("U"))
		{
			descpriority=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");
		}
		else if(descpriority.equals("S"))
		{
			descpriority=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels");
		}
		
		if (sex.equalsIgnoreCase("M"))
			 sex1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
		else if(sex.equalsIgnoreCase("F"))
			sex1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");

		if(source_type.equalsIgnoreCase("C"))
		{
			location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
		}
		else if(source_type.equalsIgnoreCase("N"))
		{
			location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
		}
		else if(source_type.equalsIgnoreCase("R"))
		{
			location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referral.label","common_labels");
		}
		else //--[IN035317]
		{
			location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels");
		}
		Loc_detail=source_type+"/"+Loc_details;
		Pat_details=Pat_name+","+sex1+"/"+age+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ID:.label","or_labels")+Pat_Id;
	
		if(view_by.equals("L"))
		{
			ph_colors									= bean.checkForNull((String)GroupBy.get(26),"");
			appt_date									= bean.checkForNull((String)GroupBy.get(27),"");
			appt_ref_num							= bean.checkForNull((String)GroupBy.get(28),"");
			appt_locn									= bean.checkForNull((String)GroupBy.get(29),"");
			appt_resched_yn						= bean.checkForNull((String)GroupBy.get(30),"");
			appt_resched_reason				= bean.checkForNull((String)GroupBy.get(31),"");
			no_of_reschedules					= bean.checkForNull((String)GroupBy.get(32),"");
			last_action_type						= bean.checkForNull((String)GroupBy.get(33),"");
			accession_num							= bean.checkForNull((String)GroupBy.get(34),"");
			ext_appl_accession_num			= bean.checkForNull((String)GroupBy.get(37),"");
			item_narration		= bean.checkForNull((String)GroupBy.get(43),""); //IN059315
			bt_ack_YN			= bean.checkForNull((String)GroupBy.get(44),""); //IN065091
		}
		else
		{
			ph_colors									= bean.checkForNull((String)GroupBy.get(23),"");
			/*IN067360 Starts*/
			//appt_date									= "";
			//appt_date      = bean.checkForNull((String)GroupBy.get(24),"");
			//appt_ref_num							= "";
			//appt_ref_num	= bean.checkForNull((String)GroupBy.get(25),"");
			//appt_locn									= "";
			//appt_locn  = bean.checkForNull((String)GroupBy.get(26),"");
			/*IN067360 ends*/
			//required?, starts
			appt_resched_yn						= "";
			appt_resched_reason				= "";
			no_of_reschedules					= "";
			//required?, ends
			last_action_type						= "";
			//accession_num							= ""; // commented for HSA-CRF-0257.1 - IN055910
			ext_appl_accession_num			= "";
			accession_num			= bean.checkForNull((String)GroupBy.get(29),""); // modified for HSA-CRF-0257.1 - IN055910 
			item_narration			=	""; //IN059315
			bt_ack_YN				=	"";//IN065091
			/*IN067360 Starts*/
			//appt_date									= "";
			appt_date      = bean.checkForNull((String)GroupBy.get(30),"");
			//appt_ref_num							= "";
			appt_ref_num	= bean.checkForNull((String)GroupBy.get(31),"");
			//appt_locn									= "";
			appt_locn  = bean.checkForNull((String)GroupBy.get(32),"");
			/*IN067360 ends*/
		}

		if(ph_colors==null || ph_colors.equals("")) ph_colors = "X,X,X";
		if(appt_ref_num==null) appt_ref_num= "";
		if(appt_date==null) appt_date= "";
		if(appt_locn==null) appt_locn= "";
		if(appt_resched_yn==null) appt_resched_yn= "";
		if(appt_resched_reason==null) appt_resched_reason= "";
		if(no_of_reschedules==null) no_of_reschedules= "";
		if(last_action_type==null) last_action_type= "";
		if(accession_num==null) accession_num= "";
	 
		if(result_link == null || result_link.equals("null")) 
			result_link =""; 
		else 
			result_link = result_link.trim();
		
		//IN063781 starts
		if("PF".equals(orderStatus) && !("RD".equals(Order_cat_code) && "Y".equals(result_link)))
		{
			result_link = "N";
		}
		//IN063781 Ends

		slClassValue="gridData";
        
//        if (Order_cat_code.equals("PH"))
		{
            // color_string = bean.getColors(facility_id,Order_Id,Order_catalog,Order_line_num);
             colorTokenizer = new StringTokenizer(ph_colors,",");
            int index = 0;
            while(colorTokenizer.hasMoreTokens()) {
                String tempToken = colorTokenizer.nextToken();
                if (tempToken.equals("#7FFF00"))
                    colorString[index] = "QRY1";
                else if (tempToken.equals("#008000"))
                    colorString[index] = "QRY2";
                else if (tempToken.equals("#A52A2A"))
                    colorString[index] = "QRY3";
                else if (tempToken.equals("#FF0000"))
                    colorString[index] = "QRY4";
                else if (tempToken.equals("#0000CD"))
                    colorString[index] = "QRY5";
                else if (tempToken.equals("#808000"))
                    colorString[index] = "QRY6";
                else if (tempToken.equals("#CD5C5C"))
                    colorString[index] = "QRY7";
				else if (tempToken.equals("#D8BFD8"))
                    colorString[index] = "QRY8";
				else if (tempToken.equals("#DDA0DD"))  
                    colorString[index] = "QRY9";
				else if (tempToken.equals("#F4A460"))
                    colorString[index] = "QRY10";
				else if (tempToken.equals("LIGHTYELLOW"))
                    colorString[index] = "LIGHTYELLOW";
				else if (tempToken.equals("BROWN"))
                    colorString[index] = "BROWN";
                else if (tempToken.equals("X"))
                    colorString[index] = slClassValue;
                index++;
            }
        }
	//HSA-CRF-0257.1 - IN055910 - Start
	
	if(Order_cat_code.equals("LB")) { 
		//isResultModified = bean.getResultStatFromStatusAppl(view_by, Order_Id, Order_line_num); // AAKH-SCF-0252  // commented for PERF issue - Karthi
		isResultModified = bean.getResultStatFromStatusAppl(view_by, Order_Id, Order_line_num, patientId); // modified for PERF issue - Karthi
		if(isResultModified == null) isResultModified = ""; // AAKH-SCF-0252
		if("Y".equals(isResultModified)) { //AAKH-SCF-0252
			//specList = bean.getIntervalTestSpecNos(Order_Id); // commented for PERF issue - Karthi
			specList = bean.getIntervalTestSpecNos(Order_Id, patientId); // modified for PERF issue - Karthi
			if(specList != null && specList.size()>1){
				//lb_rslt_mod_status = bean.getLBModStatForIntTest(specList); // commented for PERF issue- Karthi
				lb_rslt_mod_status = bean.getLBModStatForIntTest(specList, patientId);// modified for PERF issue - Karthi
			}
			else {
				//lb_rslt_mod_status =  bean.getLabOrderStatusBySpecNo(accession_num, view_by, ord_catalog_code); // commented for PERF issue - Karthi
				lb_rslt_mod_status =  bean.getLabOrderStatusBySpecNo(accession_num, view_by, ord_catalog_code, patientId); // modified for PERF issue - Karthi
			}
			if(lb_rslt_mod_status == null) lb_rslt_mod_status ="";
		}	
		//isResultModified = bean.getResultStatFromStatusAppl(view_by, Order_Id, Order_line_num); //HSA-CRF-0257.1-02 [IN058125]
		//if(isResultModified == null) isResultModified = ""; //HSA-CRF-0257.1-02 [IN058125]
	}
	//HSA-CRF-0257.1 - IN055910 - End
 	if(order_by.equals("P"))
	{
        if (!temp_grpby.equals(Pat_details))
		{
			temp_grpby = Pat_details;

            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(temp_grpby));
            _bw.write(_wl_block53Bytes, _wl_block53);

		}

            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(((colorString[0].equals("X"))?slClassValue:colorString[0])));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(((colorString[2].equals("X"))?slClassValue:colorString[2])));
            _bw.write(_wl_block56Bytes, _wl_block56);
 
	//IN065091 start
	if("L".equals(view_by)&&"Y".equals(BTColorYN)){
		if("Y".equals(bt_ack_YN))
		{
	
            _bw.write(_wl_block57Bytes, _wl_block57);

		}
		else
		{
	
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block59Bytes, _wl_block59);

		}
	}
		//IN065091 ends
	if(!localeName.equals("en"))
	{ 
		if(view_by.equals("L"))
		{
			TrackingDate = com.ehis.util.DateUtils.convertDate((String)GroupBy.get(18),"DMYHM","en",localeName);
		}
		else
		{
			TrackingDate = com.ehis.util.DateUtils.convertDate((String)GroupBy.get(14),"DMYHM","en",localeName);
		}
	}
	else
	{
		if(view_by.equals("L"))
		{
			TrackingDate=bean.checkForNull((String)GroupBy.get(18),"");
		}
		else
		{
			TrackingDate=bean.checkForNull((String)GroupBy.get(14),"");
		}
	}
	if(view_by.equals("L"))
	{
		TrackingEndDate=bean.checkForNull((String)GroupBy.get(19),"");
		if(!localeName.equals("en"))
		{ 
			TrackingEndDate = com.ehis.util.DateUtils.convertDate(TrackingEndDate,"DMYHM","en",localeName);
			if(TrackingEndDate.equals("null") || (TrackingEndDate.equals(" "))) TrackingEndDate = "";
		}
		if(bean.checkForNull((String)GroupBy.get(0),"").equalsIgnoreCase("PH")&&bean.checkForNull((String)GroupBy.get(2),"").equalsIgnoreCase("MS"))
		{
			TrackingEndDate = "";
		}
	}
	
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(TrackingDate));
            _bw.write(_wl_block62Bytes, _wl_block62);

	if(view_by.equals("L"))
	{
		if(ext_appl_accession_num != null && !ext_appl_accession_num.equals(""))
			accession_num_tooltip = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ExternalApplicationAccessionNo.label","or_labels")+" "+ext_appl_accession_num;
		else
			accession_num_tooltip= "";
		if(!TrackingEndDate.equals(""))
		{

            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(TrackingEndDate));
            _bw.write(_wl_block64Bytes, _wl_block64);

		}
		else
		{

            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block65Bytes, _wl_block65);

		}
	}

            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(descpriority==null?"&nbsp;":descpriority));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf((String)GroupBy.get(3)));
            _bw.write(_wl_block68Bytes, _wl_block68);

	if(view_by.equals("L"))
	{
		Replaced_Order = (String)GroupBy.get(39);
		Original_Order = (String)GroupBy.get(40);
	}
	else
	{
		Replaced_Order = (String)GroupBy.get(26);
		Original_Order = (String)GroupBy.get(27);
	}
	if((Replaced_Order.equalsIgnoreCase("Y"))||((Original_Order.equalsIgnoreCase("Y"))))
	{
		
		strOrderCtl.append("<td width='' nowrap id='orderctl"+i+"' style='cursor:pointer' class='gridDataBlue' ");
		strOrderCtl.append("  onClick=\"displayToolTip(''+getLabel('Common.view.label','Common')+',"+((Replaced_Order.trim().equals("Y"))?"'+getLabel('eOR.ViewReplacedOrder.label','OR')+'":"")+","+((Original_Order.trim().equals("Y"))?"'+getLabel('eOR.ViewOriginalOrder.label','OR')+'":"")+"','"+Order_cat+"','"+Order_Id+"','"+sex+"','"+Pat_Id+"','"+Order_line_num+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
		strOrderCtl.append(order_details);
		//IN029948 Start
		if( view_by.equals("L") && Order_cat_code.equalsIgnoreCase("PH") && "Y".equals(alternate))
		{
			strOrderCtl.append("<a href='javascript: dummy()' onClick=\"showDetailsPH('"+patientId+"','"+Order_Id+"','"+Order_line_num+"','"+orderStatus+"')\">");
			strOrderCtl.append("<img width='20' height='20' src='../../ePH/images/altenate.jpg'/>");
			strOrderCtl.append("</a>");				
		}
		//IN029948 End
		strOrderCtl.append("<img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow"+i+"'></td>");
		out.println(strOrderCtl.toString());
		strOrderCtl.setLength(0);
		
	}
	else
	{
	
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(accession_num_tooltip));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(Order_cat));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_Id));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Pat_Id));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_line_num));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(order_details));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(Order_cat));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_Id));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Pat_Id));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_line_num));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(pat_encounter_id));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(order_details));
            _bw.write(_wl_block75Bytes, _wl_block75);

		if( view_by.equals("L") && Order_cat_code.equalsIgnoreCase("PH") && "Y".equals(alternate))
		{
			System.out.println("PatOrderByPRSearchResult.jsp:Line:738");
		
		
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_Id));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_line_num));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(orderStatus));
            _bw.write(_wl_block77Bytes, _wl_block77);

		}
	    
            _bw.write(_wl_block78Bytes, _wl_block78);

	}
	
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf((String)GroupBy.get(7)));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(((colorString[3].equals("X"))?slClassValue:colorString[3])));
            _bw.write(_wl_block80Bytes, _wl_block80);

	//HSA-CRF-0257.1 - IN055910 - Start
	if(Order_cat_code.equals("LB") && lb_rslt_mod_status.equals("C") && isResultModified.equals("Y")) 
	
            _bw.write(_wl_block81Bytes, _wl_block81);
 //HSA-CRF-0257.1 - IN055910  - End
	if(result_link.equals("Y"))
	{
	//IN035618 starts
		if(!Order_cat_code.equals("RX") || (Order_cat_code.equals("RX") && (orderStatus.equals("RS")||orderStatus.equals("RM")||orderStatus.equals("RA")||orderStatus.equals("MA")||orderStatus.equals("MP"))) ) //IN039195 //newly added orderStatus.equals("MP") for 29803
		{
		
		if(last_action_type!=null && last_action_type.equals("NT"))
		{

            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf((String)GroupBy.get(16)));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(Order_cat));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_Id));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(cont_order_ind));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Pat_Id));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_cat_code));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf((String)GroupBy.get(16)));
            _bw.write(_wl_block85Bytes, _wl_block85);
 
		}
		else
		{

            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(Order_cat));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_Id));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(cont_order_ind));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Pat_Id));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_cat_code));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf((String)GroupBy.get(16)));
            _bw.write(_wl_block87Bytes, _wl_block87);
 
		}
		}
		else {
		out.println((String)GroupBy.get(16));}
		//IN035618 ends
	}
	else
	{
		/*AppointmentDetails = bean.getOrderApptDetails((String)GroupBy.get(13));
		for(int k=0;k<AppointmentDetails.size();k++) {
			String[] record = (String [])AppointmentDetails.get(k);
			appt_ref_num 	= record[0];
			appt_date		= record[1];
			if(appt_ref_num==null) appt_ref_num= "";
			if(appt_date==null) appt_date= "";
		}*/
 
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(i));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(appt_ref_num));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(i));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(appt_date));
            _bw.write(_wl_block93Bytes, _wl_block93);
 //=i
            _bw.write(_wl_block94Bytes, _wl_block94);
 //=i
            _bw.write(_wl_block90Bytes, _wl_block90);
 //=performing_facility_id
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(i));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(appt_locn));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(i));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(appt_resched_yn));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(i));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(appt_resched_reason));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(i));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(no_of_reschedules));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(i));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(item_narration));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(i));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(Order_Id));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(i));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(Order_line_num));
            _bw.write(_wl_block109Bytes, _wl_block109);
	
		if((!appt_ref_num.equals("")) && (!appt_date.equals(""))&&(orderStatus.equals("AB")))
		{
			/*commented and added for IN08078 starts*/
			//if( ((((String)GroupBy.get(0)).equals("RD")) && rd_install.equals("Y")) || ((((String)GroupBy.get(0)).equals("OT")) && ot_install.equals("Y")) )
			if( ((((String)GroupBy.get(0)).equals("RD")) ) || ((((String)GroupBy.get(0)).equals("OT")) && ot_install.equals("Y")) )	
			/*commented and added for IN08078 ends*/
			{ 

            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(i));
            _bw.write(_wl_block111Bytes, _wl_block111);
		
			}
			else
			{ 

            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(i));
            _bw.write(_wl_block113Bytes, _wl_block113);
		
			}
			out.println((String)GroupBy.get(16));
			out.println("</a>");
		}
		else {
			//IN068986 Start.
			if(view_by.equals("L"))
			{
				if("LB".equals(Order_cat_code) && "RG".equals(orderStatus) && "Y".equals((String)GroupBy.get(45))){
				
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(Order_cat));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_Id));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(cont_order_ind));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Pat_Id));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_cat_code));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(orderStatus));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf((String)GroupBy.get(16)));
            _bw.write(_wl_block115Bytes, _wl_block115);

				}else{
					out.println((String)GroupBy.get(16));
				}
			}else{
			//IN068986 End.
				out.println((String)GroupBy.get(16));
			} //IN068986
		}
	}
	//--[IN033488]
	StringBuffer error_desc=new StringBuffer();	
	error_desc.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.MarkedasError.label","ca_labels"));
	error_desc.append(" ");
	error_desc.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.by.label","common_labels"));
	error_desc.append(" ");
	if(orderStatus.equals("RS") ||orderStatus.equals("RM"))
	{
		ErrStatusChk  = bean.getRltNoteSts(Order_Id,localeName); 		
			if(ErrStatusChk!=null)
			{
				for(int j=0; j<ErrStatusChk.size(); j++)
				{
					String[] record 						= (String[])ErrStatusChk.get(j);
					action_type				= bean.checkForNull(record[2],"");
					action_date_time		= bean.checkForNull(record[1],"");
					action_by_id			= bean.checkForNull(record[0],"");
				}
			}
		if(action_type.equals("ER"))
		{
		
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(error_desc));
            out.print( String.valueOf(action_by_id));
            _bw.write(_wl_block117Bytes, _wl_block117);

		action_type = "";// IN040198.1
		}
	}
		
	//--[IN033488]

            _bw.write(_wl_block118Bytes, _wl_block118);
 
		if((ord_category.equals("PH")||ord_category.equals(""))&&view_by.equals("L"))
		{
			String med_admin_status_imd="";
			String med_admin_status_title="";			
			String med_admin_status=bean.getMedAdminStatus(patientId,encounterId,facility_id,Order_Id,Order_line_num);			
			if(med_admin_status.equals("P") && !"DC".equals(orderStatus) && !"CN".equals(orderStatus) && !"FC".equals(orderStatus))//IN048935
			{ 
				//med_admin_status_imd="green"; // commented for IN042630
				med_admin_status_imd="yellow"; //  modified for IN042630
				med_admin_status_title="Progress";
			}
			else if(med_admin_status.equals("C") && !"DC".equals(orderStatus) && !"CN".equals(orderStatus) && !"FC".equals(orderStatus))//IN048935
			{
				//med_admin_status_imd="yellow"; // commented for IN042630
				med_admin_status_imd="green"; //  modified for IN042630
				med_admin_status_title="Completed";
			}
			else
			{
				med_admin_status_imd="";
				med_admin_status_title="";
			}
		
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block120Bytes, _wl_block120);
if(!med_admin_status.equals("N")&&(!med_admin_status.equals("")) && !"DC".equals(orderStatus) && !"CN".equals(orderStatus) && !"FC".equals(orderStatus) ) //IN048935
		    { 
		    
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(GroupBy.get(11)));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(GroupBy.get(6)));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(GroupBy.get(14)));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(GroupBy.get(24)));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(med_admin_status_imd));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(med_admin_status_title));
            _bw.write(_wl_block125Bytes, _wl_block125);
 
			} 
			
            _bw.write(_wl_block126Bytes, _wl_block126);
 } 
            _bw.write(_wl_block127Bytes, _wl_block127);

		if("L".equals(view_by) && isSiteSpecificBillStatus && !"".equals(billingStatus))
		{
		
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(billingStatus));
            _bw.write(_wl_block27Bytes, _wl_block27);

		}else if("L".equals(view_by)&& isSiteSpecificBillStatus)
		{
		
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block130Bytes, _wl_block130);

		}
		
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(i));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(i));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(check_enable));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(displayChk));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(i));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(0)));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(i));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(9)));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(i));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(2)));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(i));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(3)));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(i));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(13)));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(i));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(5)));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(i));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(5)));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(i));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(10)));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(i));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(6)));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(i));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(cont_order_ind));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(i));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(performing_facility_id));
            _bw.write(_wl_block156Bytes, _wl_block156);

		if(view_by.equals("L"))
		{

            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(i));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(24)));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(i));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(25)));
            _bw.write(_wl_block161Bytes, _wl_block161);

		}
		else
		{

            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(i));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(21)));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(i));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(22)));
            _bw.write(_wl_block161Bytes, _wl_block161);

		}

            _bw.write(_wl_block162Bytes, _wl_block162);

	}

	if(order_by.equals("C"))
	{
        if(!temp_grpby.equals(Order_cat))
		{
			temp_grpby = Order_cat;

            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(temp_grpby));
            _bw.write(_wl_block164Bytes, _wl_block164);

		}

            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(((colorString[0].equals("X"))?slClassValue:colorString[0])));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(((colorString[2].equals("X"))?slClassValue:colorString[2])));
            _bw.write(_wl_block56Bytes, _wl_block56);

	//IN065091 start
	if("L".equals(view_by)&&"Y".equals(BTColorYN)){
		if("Y".equals(bt_ack_YN))
		{
	
            _bw.write(_wl_block57Bytes, _wl_block57);

		}
		else
		{
	
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block59Bytes, _wl_block59);

		}
	}
		//IN065091 ends
	
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(Pat_details));
            _bw.write(_wl_block62Bytes, _wl_block62);

	if(!localeName.equals("en"))
	{ 
		if(view_by.equals("L"))
			TrackingDate = com.ehis.util.DateUtils.convertDate((String)GroupBy.get(18),"DMYHM","en",localeName);
		else
			TrackingDate = com.ehis.util.DateUtils.convertDate((String)GroupBy.get(14),"DMYHM","en",localeName);
	}
	else
	{
		if(view_by.equals("L"))
			TrackingDate = bean.checkForNull((String)GroupBy.get(18),"");
		else
			TrackingDate = bean.checkForNull((String)GroupBy.get(14),"");
	}
	if(view_by.equals("L"))
	{
		TrackingEndDate=bean.checkForNull((String)GroupBy.get(19),"");
		if(!localeName.equals("en"))
		{ 
			TrackingEndDate = com.ehis.util.DateUtils.convertDate(TrackingEndDate,"DMYHM","en",localeName);
			if(TrackingEndDate.equals("null") || (TrackingEndDate.equals(" "))) TrackingEndDate="";
		}
		if(bean.checkForNull((String)GroupBy.get(0),"").equalsIgnoreCase("PH")&&bean.checkForNull((String)GroupBy.get(2),"").equalsIgnoreCase("MS"))
		{
			TrackingEndDate = "";
		}
	}

            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(TrackingDate));
            _bw.write(_wl_block166Bytes, _wl_block166);

	if(view_by.equals("L"))
	{
		if(ext_appl_accession_num != null && !ext_appl_accession_num.equals(""))
			accession_num_tooltip = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ExternalApplicationAccessionNo.label","or_labels")+" "+ext_appl_accession_num;
		else
			accession_num_tooltip= "";

		if(!TrackingEndDate.equals(""))
		{

            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf( TrackingEndDate ));
            _bw.write(_wl_block64Bytes, _wl_block64);

		}
		else
		{

            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block168Bytes, _wl_block168);

		}
	}

            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(descpriority));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf((String)GroupBy.get(3)));
            _bw.write(_wl_block68Bytes, _wl_block68);

	if(view_by.equals("L"))
	{
		Replaced_Order = (String)GroupBy.get(39);
		Original_Order = (String)GroupBy.get(40);
	}
	else
	{
		Replaced_Order = (String)GroupBy.get(26);
		Original_Order = (String)GroupBy.get(27);
	}
	if((Replaced_Order.equalsIgnoreCase("Y"))||((Original_Order.equalsIgnoreCase("Y"))))
	{
		strOrderCtl.append("<td width='' nowrap id='orderctl"+i+"' style='cursor:pointer' class='gridDataBlue' ");
		strOrderCtl.append("  onClick=\"displayToolTip(''+getLabel('Common.view.label','Common')+',"+((Replaced_Order.trim().equals("Y"))?"'+getLabel('eOR.ViewReplacedOrder.label','OR')+'":"")+","+((Original_Order.trim().equals("Y"))?"'+getLabel('eOR.ViewOriginalOrder.label','OR')+'":"")+"','"+Order_cat+"','"+Order_Id+"','"+sex+"','"+Pat_Id+"','"+Order_line_num+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
		strOrderCtl.append(order_details);
		//IN029948 Start
		
if( view_by.equals("L") && Order_cat_code.equalsIgnoreCase("PH") && "Y".equals(alternate))
		{
			strOrderCtl.append("<a href='javascript: dummy()' onClick=\"showDetailsPH('"+patientId+"','"+Order_Id+"','"+Order_line_num+"','"+orderStatus+"')\">");
			strOrderCtl.append("<img width='20' height='20' src='../../ePH/images/altenate.jpg'/>");
			strOrderCtl.append("</a>");				
		}
		
//IN029948 End
		strOrderCtl.append("<img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow"+i+"'></td>");
		out.println(strOrderCtl.toString());
		strOrderCtl.setLength(0);
	}
	else
	{
	
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(accession_num_tooltip));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(Order_cat));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_Id));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Pat_Id));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_line_num));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(order_details));
            _bw.write(_wl_block171Bytes, _wl_block171);

		if( view_by.equals("L") && Order_cat_code.equalsIgnoreCase("PH") && "Y".equals(alternate))
		{
		
		
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_Id));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_line_num));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(orderStatus));
            _bw.write(_wl_block77Bytes, _wl_block77);

		}
	    
            _bw.write(_wl_block172Bytes, _wl_block172);

	}
	
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf((String)GroupBy.get(7)));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(((colorString[3].equals("X"))?slClassValue:colorString[3])));
            _bw.write(_wl_block174Bytes, _wl_block174);

		//HSA-CRF-0257.1 - IN055910 - Start
		if(Order_cat_code.equals("LB") && lb_rslt_mod_status.equals("C") && isResultModified.equals("Y")) 
		
            _bw.write(_wl_block175Bytes, _wl_block175);
 //HSA-CRF-0257.1 - IN055910  - End
		if(result_link.equals("Y"))
		{
		//IN035618 starts
		if(!Order_cat_code.equals("RX") || (Order_cat_code.equals("RX") && (orderStatus.equals("RS")||orderStatus.equals("RM")||orderStatus.equals("RA")||orderStatus.equals("MA")||orderStatus.equals("MP"))) ) //IN039195 //newly added orderStatus.equals("MP") for 29803
		{
			if(last_action_type!=null && last_action_type.equals("NT"))
			{

            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(Order_cat));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_Id));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(cont_order_ind));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Pat_Id));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_cat_code));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf((String)GroupBy.get(16)));
            _bw.write(_wl_block87Bytes, _wl_block87);

			}
			else
			{

            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(Order_cat));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_Id));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(cont_order_ind));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Pat_Id));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_cat_code));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf((String)GroupBy.get(16)));
            _bw.write(_wl_block87Bytes, _wl_block87);

			}
			}else {
			out.println((String)GroupBy.get(16));}
		//IN035618 ends
		}
		else
		{
				/*AppointmentDetails = bean.getOrderApptDetails((String)GroupBy.get(13));
	 			for(int k=0;k<AppointmentDetails.size();k++) {
					String[] record = (String [])AppointmentDetails.get(k);
					appt_ref_num 	= record[0];
					appt_date		= record[1];
					if(appt_ref_num==null) appt_ref_num= "";
					if(appt_date==null) appt_date= "";
				}*/

            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(i));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(appt_ref_num));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(i));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(appt_date));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(i));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(appt_locn));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(i));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(appt_resched_yn));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(i));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(appt_resched_reason));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(i));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(no_of_reschedules));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(i));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(item_narration));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(i));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(Order_Id));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(i));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(Order_line_num));
            _bw.write(_wl_block187Bytes, _wl_block187);

			if((!appt_ref_num.equals("")) && (!appt_date.equals(""))&&(orderStatus.equals("AB")))
			{
				/*commentted and added for IN08078 Starts*/
				//if( ( (((String)GroupBy.get(0)).equals("RD")) && rd_install.equals("Y"))  || ((((String)GroupBy.get(0)).equals("OT")) && ot_install.equals("Y")) )
				if( ( (((String)GroupBy.get(0)).equals("RD")))  || ((((String)GroupBy.get(0)).equals("OT")) && ot_install.equals("Y")) )
				/*commentted and added for IN08078 Ends*/	
				{ 

            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(i));
            _bw.write(_wl_block111Bytes, _wl_block111);

				}
				else
				{

            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(i));
            _bw.write(_wl_block113Bytes, _wl_block113);

				}
				out.println((String)GroupBy.get(16));
				out.println("</a>");
			}
			else 
				out.println((String)GroupBy.get(16));
		}
		//--[IN033488]
	StringBuffer error_desc=new StringBuffer();	
	error_desc.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.MarkedasError.label","ca_labels"));
	error_desc.append(" ");
	error_desc.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.by.label","common_labels"));
	error_desc.append(" ");
	if(orderStatus.equals("RS") ||orderStatus.equals("RM"))
	{
		ErrStatusChk  = bean.getRltNoteSts(Order_Id,localeName); 		
			if(ErrStatusChk!=null)
			{
				for(int j=0; j<ErrStatusChk.size(); j++)
				{
					String[] record 						= (String[])ErrStatusChk.get(j);
					action_type				= bean.checkForNull(record[2],"");
					action_date_time		= bean.checkForNull(record[1],"");
					action_by_id			= bean.checkForNull(record[0],"");
				}
			}
		if(action_type.equals("ER"))
		{
		
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(error_desc));
            out.print( String.valueOf(action_by_id));
            _bw.write(_wl_block117Bytes, _wl_block117);

		action_type = "";// IN040198.1
		}
	}
		
	//--[IN033488]

            _bw.write(_wl_block190Bytes, _wl_block190);

	if("L".equals(view_by) && isSiteSpecificBillStatus && !"".equals(billingStatus))
	{
	
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(billingStatus));
            _bw.write(_wl_block191Bytes, _wl_block191);

	}else if("L".equals(view_by)&& isSiteSpecificBillStatus)
	{
	
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block192Bytes, _wl_block192);

	}
	
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(i));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(i));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(check_enable));
            out.print( String.valueOf(displayChk));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(i));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(0)));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(i));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(9)));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(i));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(2)));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(i));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(3)));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(i));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(13)));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(i));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(5)));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(i));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(5)));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(i));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(10)));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(i));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(cont_order_ind));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(i));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(performing_facility_id));
            _bw.write(_wl_block156Bytes, _wl_block156);

		if(view_by.equals("L"))
		{

            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(i));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(24)));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(i));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(25)));
            _bw.write(_wl_block161Bytes, _wl_block161);

		}
		else
		{

            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(i));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(21)));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(i));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(22)));
            _bw.write(_wl_block161Bytes, _wl_block161);

		}

            _bw.write(_wl_block198Bytes, _wl_block198);

	}

	if(order_by.equals("T"))
	{
        if(!temp_grpby.equals(Order_type))
		{
			temp_grpby = Order_type;

            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(temp_grpby));
            _bw.write(_wl_block53Bytes, _wl_block53);

		}

            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(((colorString[0].equals("X"))?slClassValue:colorString[0])));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(((colorString[2].equals("X"))?slClassValue:colorString[2])));
            _bw.write(_wl_block56Bytes, _wl_block56);

	//IN065091 start
	if("L".equals(view_by)&&"Y".equals(BTColorYN)){
		if("Y".equals(bt_ack_YN))
		{
	
            _bw.write(_wl_block57Bytes, _wl_block57);

		}
		else
		{
	
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block59Bytes, _wl_block59);

		}
	}
		//IN065091 ends
	
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(Pat_details));
            _bw.write(_wl_block62Bytes, _wl_block62);

	if(!localeName.equals("en"))
	{ 
		if(view_by.equals("L"))
			TrackingDate = com.ehis.util.DateUtils.convertDate((String)GroupBy.get(18),"DMYHM","en",localeName);
		else
			TrackingDate = com.ehis.util.DateUtils.convertDate((String)GroupBy.get(14),"DMYHM","en",localeName);
	}
	else
	{
		if(view_by.equals("L"))
			TrackingDate=bean.checkForNull((String)GroupBy.get(18),"");
		else
			TrackingDate=bean.checkForNull((String)GroupBy.get(14),"");
	}
	if(view_by.equals("L"))
	{
		TrackingEndDate=bean.checkForNull((String)GroupBy.get(19),"");
		if(!localeName.equals("en"))
		{ 
			TrackingEndDate 	=com.ehis.util.DateUtils.convertDate(TrackingEndDate,"DMYHM","en",localeName);
			if(TrackingEndDate.equals("null") || (TrackingEndDate.equals(" "))) TrackingEndDate="";
		}
		if(bean.checkForNull((String)GroupBy.get(0),"").equalsIgnoreCase("PH")&&bean.checkForNull((String)GroupBy.get(2),"").equalsIgnoreCase("MS"))
		{
			TrackingEndDate = "";
		}
	}

            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(TrackingDate));
            _bw.write(_wl_block166Bytes, _wl_block166);

	if(view_by.equals("L"))
	{
		if(ext_appl_accession_num != null && !ext_appl_accession_num.equals(""))
			accession_num_tooltip = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ExternalApplicationAccessionNo.label","or_labels")+" "+ext_appl_accession_num;
		else
			accession_num_tooltip= "";
		if(!TrackingEndDate.equals(""))
		{

            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf( TrackingEndDate ));
            _bw.write(_wl_block64Bytes, _wl_block64);

		}
		else
		{

            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block201Bytes, _wl_block201);

		}
	}

            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(descpriority));
            _bw.write(_wl_block68Bytes, _wl_block68);

	if(view_by.equals("L"))
	{
		Replaced_Order = (String)GroupBy.get(39);
		Original_Order = (String)GroupBy.get(40);
	}
	else
	{
		Replaced_Order = (String)GroupBy.get(26);
		Original_Order = (String)GroupBy.get(27);
	}
	if((Replaced_Order.equalsIgnoreCase("Y"))||((Original_Order.equalsIgnoreCase("Y"))))
	{
		strOrderCtl.append("<td width='' nowrap id='orderctl"+i+"' style='cursor:pointer' class='gridDataBlue' ");
		strOrderCtl.append("  onClick=\"displayToolTip(''+getLabel('Common.view.label','Common')+',"+((Replaced_Order.trim().equals("Y"))?"'+getLabel('eOR.ViewReplacedOrder.label','OR')+'":"")+","+((Original_Order.trim().equals("Y"))?"'+getLabel('eOR.ViewOriginalOrder.label','OR')+'":"")+"','"+Order_cat+"','"+Order_Id+"','"+sex+"','"+Pat_Id+"','"+Order_line_num+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
		strOrderCtl.append(order_details);
		//IN029948 Start
		
if( view_by.equals("L") && Order_cat_code.equalsIgnoreCase("PH") && "Y".equals(alternate))
		{
			strOrderCtl.append("<a href='javascript: dummy()' onClick=\"showDetailsPH('"+patientId+"','"+Order_Id+"','"+Order_line_num+"','"+orderStatus+"')\">");
			strOrderCtl.append("<img width='20' height='20' src='../../ePH/images/altenate.jpg'/>");
			strOrderCtl.append("</a>");				
		}
		
//IN029948 End
		strOrderCtl.append("<img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow"+i+"'></td>");
		out.println(strOrderCtl.toString());
		strOrderCtl.setLength(0);
	}
	else
	{
	
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(accession_num_tooltip));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(Order_cat));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_Id));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Pat_Id));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_line_num));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(order_details));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(Order_cat));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_Id));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Pat_Id));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_line_num));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(pat_encounter_id));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(order_details));
            _bw.write(_wl_block205Bytes, _wl_block205);

		if( view_by.equals("L") && Order_cat_code.equalsIgnoreCase("PH") && "Y".equals(alternate))
		{
		
		
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_Id));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_line_num));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(orderStatus));
            _bw.write(_wl_block77Bytes, _wl_block77);

		}
	    
            _bw.write(_wl_block172Bytes, _wl_block172);

	}
	
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf((String)GroupBy.get(7)));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(((colorString[3].equals("X"))?slClassValue:colorString[3])));
            _bw.write(_wl_block174Bytes, _wl_block174);

		//HSA-CRF-0257.1 - IN055910 - Start
		if(Order_cat_code.equals("LB") && lb_rslt_mod_status.equals("C") && isResultModified.equals("Y")) 
		
            _bw.write(_wl_block175Bytes, _wl_block175);
 //HSA-CRF-0257.1 - IN055910  - End
		if(result_link.equals("Y"))
		{ 
		//IN035618 starts
		if(!Order_cat_code.equals("RX") || (Order_cat_code.equals("RX") && (orderStatus.equals("RS")||orderStatus.equals("RM")||orderStatus.equals("RA")||orderStatus.equals("MA")||orderStatus.equals("MP"))) ) //IN039195 //newly added orderStatus.equals("MP") for 29803
		{
			if(last_action_type!=null && last_action_type.equals("NT"))
			{

            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(Order_cat));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_Id));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(cont_order_ind));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Pat_Id));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_cat_code));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf((String)GroupBy.get(16)));
            _bw.write(_wl_block87Bytes, _wl_block87);

			}
			else
			{

            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(Order_cat));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_Id));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(cont_order_ind));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Pat_Id));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_cat_code));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf((String)GroupBy.get(16)));
            _bw.write(_wl_block87Bytes, _wl_block87);

			}
			}else {
			out.println((String)GroupBy.get(16));}
		//IN035618 ends
		}
		else
		{
			/*AppointmentDetails = bean.getOrderApptDetails((String)GroupBy.get(13));
			for(int k=0;k<AppointmentDetails.size();k++) {
				String[] record = (String [])AppointmentDetails.get(k);
				appt_ref_num 	= record[0];
				appt_date		= record[1];
				if(appt_ref_num==null) appt_ref_num= "";
				if(appt_date==null) appt_date= "";
			}*/

            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(i));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(appt_ref_num));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(i));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(appt_date));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(i));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(appt_locn));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(i));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(appt_resched_yn));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(i));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(appt_resched_reason));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(i));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(no_of_reschedules));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(i));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(item_narration));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(i));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(Order_Id));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(i));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(Order_line_num));
            _bw.write(_wl_block187Bytes, _wl_block187);
	
			if((!appt_ref_num.equals("")) && (!appt_date.equals(""))&&(orderStatus.equals("AB")))
			{
				/*commentted and added for IN08078 Starts*/			
				//if( ( (((String)GroupBy.get(0)).equals("RD")) && rd_install.equals("Y")) || ((((String)GroupBy.get(0)).equals("OT")) && ot_install.equals("Y")) )
				if( ( (((String)GroupBy.get(0)).equals("RD")) ) || ((((String)GroupBy.get(0)).equals("OT")) && ot_install.equals("Y")) )
				/*commentted and added for IN08078 Ends*/	
				{ 

            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(i));
            _bw.write(_wl_block111Bytes, _wl_block111);
		
				}
				else
				{

            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(i));
            _bw.write(_wl_block113Bytes, _wl_block113);
	
				} 
				out.println((String)GroupBy.get(16));
				out.println("</a>");
			}
			else 
				out.println((String)GroupBy.get(16));
		}
		//--[IN033488]
	StringBuffer error_desc=new StringBuffer();	
	error_desc.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.MarkedasError.label","ca_labels"));
	error_desc.append(" ");
	error_desc.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.by.label","common_labels"));
	error_desc.append(" ");
	if(orderStatus.equals("RS") ||orderStatus.equals("RM"))
	{
		ErrStatusChk  = bean.getRltNoteSts(Order_Id,localeName); 		
			if(ErrStatusChk!=null)
			{
				for(int j=0; j<ErrStatusChk.size(); j++)
				{
					String[] record 						= (String[])ErrStatusChk.get(j);
					action_type				= bean.checkForNull(record[2],"");
					action_date_time		= bean.checkForNull(record[1],"");
					action_by_id			= bean.checkForNull(record[0],"");
				}
			}
		if(action_type.equals("ER"))
		{
		
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(error_desc));
            out.print( String.valueOf(action_by_id));
            _bw.write(_wl_block117Bytes, _wl_block117);

		action_type = "";// IN040198.1
		}
	}
		
	//--[IN033488]

            _bw.write(_wl_block206Bytes, _wl_block206);

		if("L".equals(view_by) && isSiteSpecificBillStatus && !"".equals(billingStatus))
		{
		
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(billingStatus));
            _bw.write(_wl_block27Bytes, _wl_block27);

		}else if("L".equals(view_by)&& isSiteSpecificBillStatus)
		{
		
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block130Bytes, _wl_block130);

		}
		
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(i));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(i));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(check_enable));
            out.print( String.valueOf(displayChk));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(i));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(0)));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(i));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(9)));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(i));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(2)));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(i));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(3)));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(i));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(13)));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(i));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(5)));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(i));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(5)));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(i));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(10)));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(i));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(cont_order_ind));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(i));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(performing_facility_id));
            _bw.write(_wl_block156Bytes, _wl_block156);

		if(view_by.equals("L"))
		{

            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(i));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(24)));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(i));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(25)));
            _bw.write(_wl_block161Bytes, _wl_block161);

		}
		else
		{

            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(i));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(21)));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(i));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(22)));
            _bw.write(_wl_block161Bytes, _wl_block161);

		}

            _bw.write(_wl_block209Bytes, _wl_block209);

	}

	if(order_by.equals("L"))
	{
        if(!temp_grpby.equals(Loc_detail))
		{
			temp_grpby = Loc_detail;
			//Modified the check to display external PH orders without empty location data - IN035317 - Start
			if(!("/").equals(temp_grpby))
			{

            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(location));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(Loc_details));
            _bw.write(_wl_block212Bytes, _wl_block212);

			}
			else
			{

            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(location));
            _bw.write(_wl_block212Bytes, _wl_block212);

			}
			//IN035317 - End
		}

            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(((colorString[0].equals("X"))?slClassValue:colorString[0])));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(((colorString[2].equals("X"))?slClassValue:colorString[2])));
            _bw.write(_wl_block56Bytes, _wl_block56);

	//IN065091 start
	if("L".equals(view_by)&&"Y".equals(BTColorYN)){
		if("Y".equals(bt_ack_YN))
		{
	
            _bw.write(_wl_block57Bytes, _wl_block57);

		}
		else
		{
	
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block59Bytes, _wl_block59);

		}
	}
		//IN065091 ends
	
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(Pat_details));
            _bw.write(_wl_block62Bytes, _wl_block62);

	if(!localeName.equals("en"))
	{ 
		if(view_by.equals("L"))
			TrackingDate = com.ehis.util.DateUtils.convertDate((String)GroupBy.get(18),"DMYHM","en",localeName);
		else
			TrackingDate = com.ehis.util.DateUtils.convertDate((String)GroupBy.get(14),"DMYHM","en",localeName);
	}
	else
	{
		if(view_by.equals("L"))
			TrackingDate = bean.checkForNull((String)GroupBy.get(18),"");
		else
			TrackingDate = bean.checkForNull((String)GroupBy.get(14),"");
	}
	if(view_by.equals("L"))
	{
		TrackingEndDate = bean.checkForNull((String)GroupBy.get(19),"");
		if ( !localeName.equals("en") )
		{ 
			TrackingEndDate = com.ehis.util.DateUtils.convertDate(TrackingEndDate,"DMYHM","en",localeName);
			if(TrackingEndDate.equals("null") || (TrackingEndDate.equals(" "))) TrackingEndDate = "";
		}
		if(bean.checkForNull((String)GroupBy.get(0),"").equalsIgnoreCase("PH")&&bean.checkForNull((String)GroupBy.get(2),"").equalsIgnoreCase("MS"))
		{
			TrackingEndDate = "";
		}
	}

            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(TrackingDate));
            _bw.write(_wl_block166Bytes, _wl_block166);

	if(view_by.equals("L"))
	{
		if(ext_appl_accession_num != null && !ext_appl_accession_num.equals(""))
			accession_num_tooltip = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ExternalApplicationAccessionNo.label","or_labels")+" "+ext_appl_accession_num;
		else
			accession_num_tooltip= "";
		if(!TrackingEndDate.equals(""))
		{

            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf( TrackingEndDate ));
            _bw.write(_wl_block64Bytes, _wl_block64);

		}
		else
		{

            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block201Bytes, _wl_block201);

		}
	}

            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(descpriority));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf((String)GroupBy.get(3)));
            _bw.write(_wl_block68Bytes, _wl_block68);

	if(view_by.equals("L"))
	{
		Replaced_Order = (String)GroupBy.get(39);
		Original_Order = (String)GroupBy.get(40);
	}
	else
	{
		Replaced_Order = (String)GroupBy.get(26);
		Original_Order = (String)GroupBy.get(27);
	}
	if((Replaced_Order.equalsIgnoreCase("Y"))||((Original_Order.equalsIgnoreCase("Y"))))
	{
		strOrderCtl.append("<td width='' nowrap id='orderctl"+i+"' style='cursor:pointer' class='gridDataBlue' ");
		strOrderCtl.append("  onClick=\"displayToolTip(''+getLabel('Common.view.label','Common')+',"+((Replaced_Order.trim().equals("Y"))?"'+getLabel('eOR.ViewReplacedOrder.label','OR')+'":"")+","+((Original_Order.trim().equals("Y"))?"'+getLabel('eOR.ViewOriginalOrder.label','OR')+'":"")+"','"+Order_cat+"','"+Order_Id+"','"+sex+"','"+Pat_Id+"','"+Order_line_num+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
		strOrderCtl.append(order_details);
		//IN029948 Start
		
if( view_by.equals("L") && Order_cat_code.equalsIgnoreCase("PH") && "Y".equals(alternate))
		{
			strOrderCtl.append("<a href='javascript: dummy()' onClick=\"showDetailsPH('"+patientId+"','"+Order_Id+"','"+Order_line_num+"','"+orderStatus+"')\">");
			strOrderCtl.append("<img width='20' height='20' src='../../ePH/images/altenate.jpg'/>");
			strOrderCtl.append("</a>");				
		}
		
//IN029948 End
		strOrderCtl.append("<img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow"+i+"'></td>");
		out.println(strOrderCtl.toString());
		strOrderCtl.setLength(0);
		
	}
	else
	{
	
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(accession_num_tooltip));
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(Order_cat));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_Id));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Pat_Id));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_line_num));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(order_details));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(Order_cat));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_Id));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Pat_Id));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_line_num));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(pat_encounter_id));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(order_details));
            _bw.write(_wl_block218Bytes, _wl_block218);

		if( view_by.equals("L") && Order_cat_code.equalsIgnoreCase("PH") && "Y".equals(alternate))
		{
		
		
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_Id));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_line_num));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(orderStatus));
            _bw.write(_wl_block77Bytes, _wl_block77);

		}
	    
            _bw.write(_wl_block172Bytes, _wl_block172);

	}
	
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf((String)GroupBy.get(7)));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(((colorString[3].equals("X"))?slClassValue:colorString[3])));
            _bw.write(_wl_block174Bytes, _wl_block174);

		//HSA-CRF-0257.1 - IN055910 - Start
		if(Order_cat_code.equals("LB") && lb_rslt_mod_status.equals("C") && isResultModified.equals("Y")) 
		
            _bw.write(_wl_block175Bytes, _wl_block175);
 //HSA-CRF-0257.1 - IN055910  - End
		if(result_link.equals("Y"))
		{ 
		//IN035618 starts
		if(!Order_cat_code.equals("RX") || (Order_cat_code.equals("RX") && (orderStatus.equals("RS")||orderStatus.equals("RM")||orderStatus.equals("RA")||orderStatus.equals("MA")||orderStatus.equals("MP"))) ) //IN039195 //newly added orderStatus.equals("MP") for 29803
		{
			if(last_action_type!=null && last_action_type.equals("NT"))
			{ 

            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(Order_cat));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_Id));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(cont_order_ind));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Pat_Id));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_cat_code));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf((String)GroupBy.get(16)));
            _bw.write(_wl_block87Bytes, _wl_block87);
 
			}
			else
			{ 

            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(Order_cat));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_Id));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(cont_order_ind));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Pat_Id));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_cat_code));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf((String)GroupBy.get(16)));
            _bw.write(_wl_block87Bytes, _wl_block87);
 
			}
			}else {
			out.println((String)GroupBy.get(16));}
		//IN035618 ends
		}
		else
		{
			/*AppointmentDetails = bean.getOrderApptDetails((String)GroupBy.get(13));
			for(int k=0;k<AppointmentDetails.size();k++) {
				String[] record = (String [])AppointmentDetails.get(k);
				appt_ref_num 	= record[0];
				appt_date		= record[1];
				if(appt_ref_num==null) appt_ref_num= "";
				if(appt_date==null) appt_date= "";
			}*/

            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(i));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(appt_ref_num));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(i));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(appt_date));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(i));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(appt_locn));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(i));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(appt_resched_yn));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(i));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(appt_resched_reason));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(i));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(no_of_reschedules));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(i));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(item_narration));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(i));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(Order_Id));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(i));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(Order_line_num));
            _bw.write(_wl_block187Bytes, _wl_block187);
		 
			if((!appt_ref_num.equals("")) && (!appt_date.equals(""))&&(orderStatus.equals("AB")))
			{
				/*Commented and added for IN08078 starts*/
				//if( ( (((String)GroupBy.get(0)).equals("RD")) && rd_install.equals("Y")) || ((((String)GroupBy.get(0)).equals("OT")) && ot_install.equals("Y")) )
				if( ( (((String)GroupBy.get(0)).equals("RD")) ) || ((((String)GroupBy.get(0)).equals("OT")) && ot_install.equals("Y")) )
				/*Commented and added for IN08078 Ends*/
				{ 

            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(i));
            _bw.write(_wl_block111Bytes, _wl_block111);

				}
				else
				{

            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(i));
            _bw.write(_wl_block113Bytes, _wl_block113);

				} 
				out.println((String)GroupBy.get(16));
				out.println("</a>");
		    }
			else 
				out.println((String)GroupBy.get(16));
		}
		//--[IN033488]
	StringBuffer error_desc=new StringBuffer();	
	error_desc.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.MarkedasError.label","ca_labels"));
	error_desc.append(" ");
	error_desc.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.by.label","common_labels"));
	error_desc.append(" ");
	if(orderStatus.equals("RS") ||orderStatus.equals("RM"))
	{
		ErrStatusChk  = bean.getRltNoteSts(Order_Id,localeName); 		
			if(ErrStatusChk!=null)
			{
				for(int j=0; j<ErrStatusChk.size(); j++)
				{
					String[] record 						= (String[])ErrStatusChk.get(j);
					action_type				= bean.checkForNull(record[2],"");
					action_date_time		= bean.checkForNull(record[1],"");
					action_by_id			= bean.checkForNull(record[0],"");
				}
			}
		if(action_type.equals("ER"))
		{
		
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(error_desc));
            out.print( String.valueOf(action_by_id));
            _bw.write(_wl_block117Bytes, _wl_block117);

		action_type = "";// IN040198.1
		}
	}
		
	//--[IN033488]

            _bw.write(_wl_block206Bytes, _wl_block206);

		if("L".equals(view_by) && isSiteSpecificBillStatus && !"".equals(billingStatus))
		{
		
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(billingStatus));
            _bw.write(_wl_block27Bytes, _wl_block27);

		}else if("L".equals(view_by)&& isSiteSpecificBillStatus)
		{
		
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block130Bytes, _wl_block130);

		}
		
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(i));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(i));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(check_enable));
            out.print( String.valueOf(displayChk));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(i));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(0)));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(i));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(9)));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(i));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(2)));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(i));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(3)));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(i));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(13)));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(i));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(5)));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(i));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(5)));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(i));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(10)));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(i));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(cont_order_ind));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(i));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(performing_facility_id));
            _bw.write(_wl_block156Bytes, _wl_block156);

		if(view_by.equals("L"))
		{

            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(i));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(24)));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(i));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(25)));
            _bw.write(_wl_block161Bytes, _wl_block161);

		}
		else
		{

            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(i));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(21)));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(i));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(22)));
            _bw.write(_wl_block161Bytes, _wl_block161);

		}

            _bw.write(_wl_block209Bytes, _wl_block209);

	}

	if(order_by.equals("D"))
	{
        if(!temp_grpby.equals(Date_details))
		{
			temp_grpby = Date_details;

            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(temp_grpby));
            _bw.write(_wl_block164Bytes, _wl_block164);

		}

            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(((colorString[0].equals("X"))?slClassValue:colorString[0])));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(((colorString[2].equals("X"))?slClassValue:colorString[2])));
            _bw.write(_wl_block223Bytes, _wl_block223);

		//IN065091 start
	if("L".equals(view_by)&&"Y".equals(BTColorYN)){
		if("Y".equals(bt_ack_YN))
		{
	
            _bw.write(_wl_block57Bytes, _wl_block57);

		}
		else
		{
	
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block59Bytes, _wl_block59);

		}
	}
		//IN065091 ends
	
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(Pat_details));
            _bw.write(_wl_block225Bytes, _wl_block225);

		if ( !localeName.equals("en") )
		{ 
			 if(view_by.equals("L"))
				TrackingDate = com.ehis.util.DateUtils.convertDate((String)GroupBy.get(18),"DMYHM","en",localeName);
			 else
				TrackingDate = com.ehis.util.DateUtils.convertDate((String)GroupBy.get(14),"DMYHM","en",localeName);
		}
		else
		{
			if(view_by.equals("L"))
				TrackingDate=bean.checkForNull((String)GroupBy.get(18),"");
			else
				TrackingDate=bean.checkForNull((String)GroupBy.get(14),"");
		}
		if(view_by.equals("L"))
		{
			TrackingEndDate=bean.checkForNull((String)GroupBy.get(19),"");
			if(!localeName.equals("en"))
			{ 
				TrackingEndDate = com.ehis.util.DateUtils.convertDate(TrackingEndDate,"DMYHM","en",localeName);
				if(TrackingEndDate.equals("null") || (TrackingEndDate.equals(" "))) TrackingEndDate = "";
			}
			if(bean.checkForNull((String)GroupBy.get(0),"").equalsIgnoreCase("PH")&&bean.checkForNull((String)GroupBy.get(2),"").equalsIgnoreCase("MS"))
			{
				TrackingEndDate = "";
			}
		}

            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(TrackingDate));
            _bw.write(_wl_block225Bytes, _wl_block225);

		if(view_by.equals("L"))
		{
			if(ext_appl_accession_num != null && !ext_appl_accession_num.equals(""))
				accession_num_tooltip = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ExternalApplicationAccessionNo.label","or_labels")+" "+ext_appl_accession_num;
			else
				accession_num_tooltip= "";
			if(!TrackingEndDate.equals(""))
			{

            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf( TrackingEndDate ));
            _bw.write(_wl_block229Bytes, _wl_block229);

			}
			else
			{

            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block168Bytes, _wl_block168);

			}
		}

            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(descpriority));
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf((String)GroupBy.get(3)));
            _bw.write(_wl_block231Bytes, _wl_block231);

		if(view_by.equals("L"))
		{
			Replaced_Order = (String)GroupBy.get(39);
			Original_Order = (String)GroupBy.get(40);
		}
		else
		{
			Replaced_Order = (String)GroupBy.get(26);
			Original_Order = (String)GroupBy.get(27);
		}
		if((Replaced_Order.equalsIgnoreCase("Y"))||((Original_Order.equalsIgnoreCase("Y"))))
		{
			strOrderCtl.append("<td width='' nowrap id='orderctl"+i+"' style='cursor:pointer' class='gridDataBlue' ");
			strOrderCtl.append("  onClick=\"displayToolTip(''+getLabel('Common.view.label','Common')+',"+((Replaced_Order.trim().equals("Y"))?"'+getLabel('eOR.ViewReplacedOrder.label','OR')+'":"")+","+((Original_Order.trim().equals("Y"))?"'+getLabel('eOR.ViewOriginalOrder.label','OR')+'":"")+"','"+Order_cat+"','"+Order_Id+"','"+sex+"','"+Pat_Id+"','"+Order_line_num+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
			strOrderCtl.append(order_details);
			//IN029948 Start
		
if( view_by.equals("L") && Order_cat_code.equalsIgnoreCase("PH") && "Y".equals(alternate))
		{
			strOrderCtl.append("<a href='javascript: dummy()' onClick=\"showDetailsPH('"+patientId+"','"+Order_Id+"','"+Order_line_num+"','"+orderStatus+"')\">");
			strOrderCtl.append("<img width='20' height='20' src='../../ePH/images/altenate.jpg'/>");
			strOrderCtl.append("</a>");				
		}
		
//IN029948 End
			strOrderCtl.append("<img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow"+i+"'></td>");
			out.println(strOrderCtl.toString());
			strOrderCtl.setLength(0);
		}
		else
		{
		
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(accession_num_tooltip));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(Order_cat));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_Id));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Pat_Id));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_line_num));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(order_details));
            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf(Order_cat));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_Id));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Pat_Id));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_line_num));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(pat_encounter_id));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(order_details));
            _bw.write(_wl_block234Bytes, _wl_block234);

		if( view_by.equals("L") && Order_cat_code.equalsIgnoreCase("PH") && "Y".equals(alternate))
		{
		
		
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_Id));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_line_num));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(orderStatus));
            _bw.write(_wl_block77Bytes, _wl_block77);

		}
	    
            _bw.write(_wl_block235Bytes, _wl_block235);

		}
		
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf((String)GroupBy.get(7)));
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(((colorString[3].equals("X"))?slClassValue:colorString[3])));
            _bw.write(_wl_block174Bytes, _wl_block174);

		//HSA-CRF-0257.1 - IN055910 - Start
		if(Order_cat_code.equals("LB") && lb_rslt_mod_status.equals("C") && isResultModified.equals("Y")) 
		
            _bw.write(_wl_block175Bytes, _wl_block175);
 //HSA-CRF-0257.1 - IN055910  - End
		if(result_link.equals("Y"))
		{ 
		//IN035618 starts
		if(!Order_cat_code.equals("RX") || (Order_cat_code.equals("RX") && (orderStatus.equals("RS")||orderStatus.equals("RM")||orderStatus.equals("RA")||orderStatus.equals("MA")||orderStatus.equals("MP"))) ) //IN039195 //newly added orderStatus.equals("MP") for 29803
		{
			if(last_action_type!=null && last_action_type.equals("NT"))
			{

            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(Order_cat));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_Id));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(cont_order_ind));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Pat_Id));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_cat_code));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf((String)GroupBy.get(16)));
            _bw.write(_wl_block87Bytes, _wl_block87);

			}
			else
			{ 

            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(Order_cat));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_Id));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(cont_order_ind));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Pat_Id));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_cat_code));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf((String)GroupBy.get(16)));
            _bw.write(_wl_block87Bytes, _wl_block87);
 
			}
			}else {
			out.println((String)GroupBy.get(16));}
		//IN035618 ends			
		}
		else
		{

			/*AppointmentDetails = bean.getOrderApptDetails((String)GroupBy.get(13));
			for(int k=0;k<AppointmentDetails.size();k++) {
				String[] record = (String [])AppointmentDetails.get(k);
				appt_ref_num 	= record[0];
				appt_date		= record[1];
				if(appt_ref_num==null) appt_ref_num= "";
				if(appt_date==null) appt_date= "";
			}*/

            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(i));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(appt_ref_num));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(i));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(appt_date));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(i));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(appt_locn));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(i));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(appt_resched_yn));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(i));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(appt_resched_reason));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(i));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(no_of_reschedules));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(i));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(item_narration));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(i));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(Order_Id));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(i));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(Order_line_num));
            _bw.write(_wl_block187Bytes, _wl_block187);
		 
			if((!appt_ref_num.equals("")) && (!appt_date.equals(""))&&(orderStatus.equals("AB")))
			{
				/*Commented and added for IN08078 starts*/
				//if( ( (((String)GroupBy.get(0)).equals("RD")) && rd_install.equals("Y")) || ((((String)GroupBy.get(0)).equals("OT")) && ot_install.equals("Y")) )
				if( ( (((String)GroupBy.get(0)).equals("RD")) ) || ((((String)GroupBy.get(0)).equals("OT")) && ot_install.equals("Y")) )	
				/*Commented and added for IN08078 Ends*/	
				{ 

            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(i));
            _bw.write(_wl_block111Bytes, _wl_block111);
		
				}
				else
				{

            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(i));
            _bw.write(_wl_block113Bytes, _wl_block113);
	
				} 
				out.println((String)GroupBy.get(16));
				out.println("</a>");
		    }
			else 
				out.println((String)GroupBy.get(16));
		}
		//--[IN033488]
	StringBuffer error_desc=new StringBuffer();	
	error_desc.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.MarkedasError.label","ca_labels"));
	error_desc.append(" ");
	error_desc.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.by.label","common_labels"));
	error_desc.append(" ");
	if(orderStatus.equals("RS") ||orderStatus.equals("RM"))
	{
		ErrStatusChk  = bean.getRltNoteSts(Order_Id,localeName); 		
			if(ErrStatusChk!=null)
			{
				for(int j=0; j<ErrStatusChk.size(); j++)
				{
					String[] record 						= (String[])ErrStatusChk.get(j);
					action_type				= bean.checkForNull(record[2],"");
					action_date_time		= bean.checkForNull(record[1],"");
					action_by_id			= bean.checkForNull(record[0],"");
				}
			}
		if(action_type.equals("ER"))
		{
		
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(error_desc));
            out.print( String.valueOf(action_by_id));
            _bw.write(_wl_block117Bytes, _wl_block117);

		action_type = "";// IN040198.1
		}
	}
		
	//--[IN033488]

            _bw.write(_wl_block206Bytes, _wl_block206);

		if("L".equals(view_by) && isSiteSpecificBillStatus && !"".equals(billingStatus))
		{
		
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(billingStatus));
            _bw.write(_wl_block27Bytes, _wl_block27);

		}else if("L".equals(view_by)&& isSiteSpecificBillStatus)
		{
		
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block130Bytes, _wl_block130);

		}
		
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(i));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(i));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(check_enable));
            out.print( String.valueOf(displayChk));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(i));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(0)));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(i));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(9)));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(i));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(2)));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(i));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(3)));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(i));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(13)));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(i));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(5)));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(i));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(5)));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(i));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(10)));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(i));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(cont_order_ind));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(i));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(performing_facility_id));
            _bw.write(_wl_block156Bytes, _wl_block156);

		if(view_by.equals("L"))
		{

            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(i));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(24)));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(i));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(25)));
            _bw.write(_wl_block161Bytes, _wl_block161);

		}
		else
		{

            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(i));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(21)));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(i));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(22)));
            _bw.write(_wl_block161Bytes, _wl_block161);

		}

            _bw.write(_wl_block209Bytes, _wl_block209);

	}
	else if(order_by.equals("U"))
	{
        if(!temp_grpby.equals(descpriority))
		{
			temp_grpby = descpriority;

            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(temp_grpby));
            _bw.write(_wl_block164Bytes, _wl_block164);

		}

            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(((colorString[0].equals("X"))?slClassValue:colorString[0])));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(((colorString[2].equals("X"))?slClassValue:colorString[2])));
            _bw.write(_wl_block223Bytes, _wl_block223);

		//IN065091 start
	if("L".equals(view_by)&&"Y".equals(BTColorYN)){
		if("Y".equals(bt_ack_YN))
		{
	
            _bw.write(_wl_block57Bytes, _wl_block57);

		}
		else
		{
	
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block59Bytes, _wl_block59);

		}
	}
		//IN065091 ends
	
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(Pat_details));
            _bw.write(_wl_block225Bytes, _wl_block225);
	
		if ( !localeName.equals("en") )
		{ 
			if(view_by.equals("L"))
				TrackingDate = com.ehis.util.DateUtils.convertDate((String)GroupBy.get(18),"DMYHM","en",localeName);
			else
				TrackingDate = com.ehis.util.DateUtils.convertDate((String)GroupBy.get(14),"DMYHM","en",localeName);
		}
		else
		{
			if(view_by.equals("L"))
				TrackingDate=bean.checkForNull((String)GroupBy.get(18),"");
			else
				TrackingDate=bean.checkForNull((String)GroupBy.get(14),"");
		}
		if(view_by.equals("L"))
		{
			TrackingEndDate=bean.checkForNull((String)GroupBy.get(19),"");
			if ( !localeName.equals("en") )
			{ 
				TrackingEndDate 	=com.ehis.util.DateUtils.convertDate(TrackingEndDate,"DMYHM","en",localeName);
				if(TrackingEndDate.equals("null") || (TrackingEndDate.equals(" "))) TrackingEndDate="";
			}
			if(bean.checkForNull((String)GroupBy.get(0),"").equalsIgnoreCase("PH")&&bean.checkForNull((String)GroupBy.get(2),"").equalsIgnoreCase("MS"))
			{
				TrackingEndDate = "";
			}
		}

            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(TrackingDate));
            _bw.write(_wl_block237Bytes, _wl_block237);

		if(view_by.equals("L"))
		{
			if(ext_appl_accession_num != null && !ext_appl_accession_num.equals(""))
				accession_num_tooltip = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ExternalApplicationAccessionNo.label","or_labels")+" "+ext_appl_accession_num;
			else
				accession_num_tooltip= "";
			if(!TrackingEndDate.equals(""))
			{

            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf( TrackingEndDate ));
            _bw.write(_wl_block229Bytes, _wl_block229);

			}
			else
			{

            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block168Bytes, _wl_block168);

			}
		}

            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(descpriority));
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf((String)GroupBy.get(3)));
            _bw.write(_wl_block231Bytes, _wl_block231);

		if(view_by.equals("L"))
		{
			Replaced_Order = (String)GroupBy.get(39);
			Original_Order = (String)GroupBy.get(40);
		}
		else
		{
			Replaced_Order = (String)GroupBy.get(26);
			Original_Order = (String)GroupBy.get(27);
		}
		if((Replaced_Order.equalsIgnoreCase("Y"))||((Original_Order.equalsIgnoreCase("Y"))))
		{
			strOrderCtl.append("<td width='' nowrap id='orderctl"+i+"' style='cursor:pointer' class='gridDataBlue' ");
			strOrderCtl.append("  onClick=\"displayToolTip(''+getLabel('Common.view.label','Common')+',"+((Replaced_Order.trim().equals("Y"))?"'+getLabel('eOR.ViewReplacedOrder.label','OR')+'":"")+","+((Original_Order.trim().equals("Y"))?"'+getLabel('eOR.ViewOriginalOrder.label','OR')+'":"")+"','"+Order_cat+"','"+Order_Id+"','"+sex+"','"+Pat_Id+"','"+Order_line_num+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
			strOrderCtl.append(order_details);
			//IN029948 Start
		
if( view_by.equals("L") && Order_cat_code.equalsIgnoreCase("PH") && "Y".equals(alternate))
		{
			strOrderCtl.append("<a href='javascript: dummy()' onClick=\"showDetailsPH('"+patientId+"','"+Order_Id+"','"+Order_line_num+"','"+orderStatus+"')\">");
			strOrderCtl.append("<img width='20' height='20' src='../../ePH/images/altenate.jpg'/>");
			strOrderCtl.append("</a>");				
		}
		
//IN029948 End
			strOrderCtl.append("<img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow"+i+"'></td>");
			out.println(strOrderCtl.toString());
			strOrderCtl.setLength(0);
		
		}
		else
		{
		
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(accession_num_tooltip));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(Order_cat));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_Id));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Pat_Id));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_line_num));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(order_details));
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(Order_cat));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_Id));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Pat_Id));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_line_num));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(pat_encounter_id));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(order_details));
            _bw.write(_wl_block241Bytes, _wl_block241);

		if( view_by.equals("L") && Order_cat_code.equalsIgnoreCase("PH") && "Y".equals(alternate))
		{
		
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_Id));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_line_num));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(orderStatus));
            _bw.write(_wl_block77Bytes, _wl_block77);

		}
	    
            _bw.write(_wl_block235Bytes, _wl_block235);

		}
		
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf((String)GroupBy.get(7)));
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(((colorString[3].equals("X"))?slClassValue:colorString[3])));
            _bw.write(_wl_block174Bytes, _wl_block174);

		//HSA-CRF-0257.1 - IN055910 - Start
		if(Order_cat_code.equals("LB") && lb_rslt_mod_status.equals("C") && isResultModified.equals("Y")) 
		
            _bw.write(_wl_block175Bytes, _wl_block175);
 //HSA-CRF-0257.1 - IN055910  - End
		if(result_link.equals("Y"))
		{
		//IN035618 starts
		if(!Order_cat_code.equals("RX") || (Order_cat_code.equals("RX") && (orderStatus.equals("RS")||orderStatus.equals("RM")||orderStatus.equals("RA")||orderStatus.equals("MA")||orderStatus.equals("MP"))) ) //IN039195 //newly added orderStatus.equals("MP") for 29803
		{
			if(last_action_type!=null && last_action_type.equals("NT"))
			{ 

            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf((String)GroupBy.get(16)));
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf(Order_cat));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_Id));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(cont_order_ind));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Pat_Id));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_cat_code));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf((String)GroupBy.get(16)));
            _bw.write(_wl_block87Bytes, _wl_block87);

			}
			else
			{

            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(Order_cat));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_Id));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(cont_order_ind));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Pat_Id));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Order_cat_code));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf((String)GroupBy.get(16)));
            _bw.write(_wl_block87Bytes, _wl_block87);
 
			}
			}else {
			out.println((String)GroupBy.get(16));}
		//IN035618 ends
		}
		else
		{
			/*AppointmentDetails = bean.getOrderApptDetails((String)GroupBy.get(13));
			for(int k=0;k<AppointmentDetails.size();k++) {
				String[] record = (String [])AppointmentDetails.get(k);
				appt_ref_num 	= record[0];
				appt_date		= record[1];
				if(appt_ref_num==null) appt_ref_num= "";
				if(appt_date==null) appt_date= "";
			}*/

            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(i));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(appt_ref_num));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(i));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(appt_date));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(i));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(appt_locn));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(i));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(appt_resched_yn));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(i));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(appt_resched_reason));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(i));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(no_of_reschedules));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(i));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(item_narration));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(i));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(Order_Id));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(i));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(Order_line_num));
            _bw.write(_wl_block187Bytes, _wl_block187);
		 
			if((!appt_ref_num.equals("")) && (!appt_date.equals(""))&&(orderStatus.equals("AB")))
			{
				/*Commented and added for IN08078 starts*/			
				//if( ( (((String)GroupBy.get(0)).equals("RD")) && rd_install.equals("Y")) || ((((String)GroupBy.get(0)).equals("OT")) && ot_install.equals("Y")) )
				if( ( (((String)GroupBy.get(0)).equals("RD")) ) || ((((String)GroupBy.get(0)).equals("OT")) && ot_install.equals("Y")) )
				/*Commented and added for IN08078 Ends*/	
				{ 

            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(i));
            _bw.write(_wl_block111Bytes, _wl_block111);
	
				}
				else
				{

            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(i));
            _bw.write(_wl_block113Bytes, _wl_block113);
	
				} 
				out.println((String)GroupBy.get(16));
				out.println("</a>");
		    }
			else 
				out.println((String)GroupBy.get(16));
		}
		//--[IN033488]
	StringBuffer error_desc=new StringBuffer();	
	error_desc.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.MarkedasError.label","ca_labels"));
	error_desc.append(" ");
	error_desc.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.by.label","common_labels"));
	error_desc.append(" ");
	if(orderStatus.equals("RS") ||orderStatus.equals("RM"))
	{
		ErrStatusChk  = bean.getRltNoteSts(Order_Id,localeName); 		
			if(ErrStatusChk!=null)
			{
				for(int j=0; j<ErrStatusChk.size(); j++)
				{
					String[] record 						= (String[])ErrStatusChk.get(j);
					action_type				= bean.checkForNull(record[2],"");
					action_date_time		= bean.checkForNull(record[1],"");
					action_by_id			= bean.checkForNull(record[0],"");
				}
			}
		if(action_type.equals("ER"))
		{
		
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(error_desc));
            out.print( String.valueOf(action_by_id));
            _bw.write(_wl_block117Bytes, _wl_block117);

		action_type = "";// IN040198.1
		}
	}
		
	//--[IN033488]

            _bw.write(_wl_block206Bytes, _wl_block206);

		if("L".equals(view_by) && isSiteSpecificBillStatus && !"".equals(billingStatus))
		{
		
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(billingStatus));
            _bw.write(_wl_block27Bytes, _wl_block27);

		}else if("L".equals(view_by)&& isSiteSpecificBillStatus)
		{
		
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block130Bytes, _wl_block130);

		}
		
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(i));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(i));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(check_enable));
            out.print( String.valueOf(displayChk));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(i));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(0)));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(i));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(9)));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(i));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(2)));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(i));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(3)));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(i));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(13)));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(i));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(5)));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(i));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(10)));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(i));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(cont_order_ind));
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(i));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(performing_facility_id));
            _bw.write(_wl_block156Bytes, _wl_block156);

		if(view_by.equals("L"))
		{

            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(i));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(24)));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(i));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(25)));
            _bw.write(_wl_block161Bytes, _wl_block161);

		}
		else
		{

            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(i));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(21)));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(i));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)GroupBy.get(22)));
            _bw.write(_wl_block161Bytes, _wl_block161);

		}

            _bw.write(_wl_block209Bytes, _wl_block209);

	}
 	i++; 
	}

            _bw.write(_wl_block2Bytes, _wl_block2);

	}
	catch(Exception e)
	{
		e.printStackTrace();
	}

            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf( bean_name ));
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block251Bytes, _wl_block251);
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(i));
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf(check_count));
            _bw.write(_wl_block254Bytes, _wl_block254);
            out.print( String.valueOf(order_status));
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf(encounterId));
            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(period_from));
            _bw.write(_wl_block258Bytes, _wl_block258);
            out.print( String.valueOf(period_to));
            _bw.write(_wl_block259Bytes, _wl_block259);
            out.print( String.valueOf(location_type));
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(locn));
            _bw.write(_wl_block261Bytes, _wl_block261);
            out.print( String.valueOf(ord_category));
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(order_type));
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.print( String.valueOf(order_by));
            _bw.write(_wl_block264Bytes, _wl_block264);
            out.print( String.valueOf(view_by));
            _bw.write(_wl_block265Bytes, _wl_block265);
            out.print( String.valueOf(curr_sys_date));
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf(order_catelog));
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf(ordering_pract));
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(priority));
            _bw.write(_wl_block269Bytes, _wl_block269);
            out.print( String.valueOf(search_crt));
            _bw.write(_wl_block270Bytes, _wl_block270);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block271Bytes, _wl_block271);
            out.print( String.valueOf(activity_type));
            _bw.write(_wl_block272Bytes, _wl_block272);
            out.print( String.valueOf(elapsed_orders));
            _bw.write(_wl_block273Bytes, _wl_block273);
            out.print( String.valueOf(sys_cancelled_orders));
            _bw.write(_wl_block274Bytes, _wl_block274);
            out.print( String.valueOf(current_ip_list_check));
            _bw.write(_wl_block275Bytes, _wl_block275);
            out.print( String.valueOf(from));
            _bw.write(_wl_block276Bytes, _wl_block276);
            out.print( String.valueOf(to));
            _bw.write(_wl_block277Bytes, _wl_block277);
            out.print( String.valueOf(BTColorYN));
            _bw.write(_wl_block278Bytes, _wl_block278);
            out.print( String.valueOf(eSignatureYN));
            _bw.write(_wl_block279Bytes, _wl_block279);
            out.print( String.valueOf(view_by));
            _bw.write(_wl_block280Bytes, _wl_block280);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.OrderedAt.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderType.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ordercatalog.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderedBy.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.MedAdmindetails.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.BillingStatus.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.print.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientDetails.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.OrderedAt.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.StartDate.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enddate.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ordercatalog.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderedBy.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.BillingStatus.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.print.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientDetails.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.OrderedAt.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.StartDate.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enddate.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderType.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ordercatalog.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderedBy.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.BillingStatus.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.print.label", java.lang.String .class,"key"));
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
}
