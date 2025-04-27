package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eOR.*;
import eMR.*;
import eOR.Common.*;
import eCommon.Common.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __specimencollectionlistandlabelssearchresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/SpecimenCollectionListAndLabelsSearchResult.jsp", 1736505300000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!--\n--------------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        Description\n--------------------------------------------------------------------------------------------------------------\n?             100            ?           created\n02/11/2011    IN29355        Menaka      Manage Specimen>New List\n\t\t\t\t\t\t\t\t\t\t System not allow to record new list if orders were placed from Place Order function\n23/02/2012\t  IN030589\t\tMenaka\t\t System should check & prompt for unbilled lab orders at Manage specimen. \n03/02/2012\t  IN:030168    VIJAY R\t\t introduced new filter parameter \'ordering practitiner\' in manage specimens page, search functionality.\n12/7/2012\t  IN33889\t\tDineshT\t\tModified the selectAll functionality to add the records to the bean\t\t\t\t \n10/04/2013  IN039158    Nijitha S\t\tFrom manage specimen function, whenever the Ordering facility is Select, Collection barcode label cant be printed and not appear in printing job queue.\t\t\t\n04/06/2013\t  IN035837\t\t Karthi L \t\tRequirement for managing future order and specimen number generation.[Bru-HIMS-CRF-320]\t \n13/06/2013\t  IN040758\t\tNijitha S  CRF-CA-Bru-HIMS-CRF-320/02- Record Collection->Future Order can be recorded\n25/06/2013\t  IN041127\t\t Karthi L\t Wrong message prompt is displayed\n--------------------------------------------------------------------------------------------------------------\nDate       Edit History      Name       Rev.Date   Rev.By    Description\n--------------------------------------------------------------------------------------------------------------\n29/08/2014\t  \tIN049737\t   \tChowminya\t \t\t\t\t\t\tMMS-CRF-194.1 Unbilled services will be regrouped into a new order\n28/05/2015\t\tIN052230\t\tKarthi L\t\t\t\t\t\t\tOrder Management-Missing specimens-Dispatch Slip\n06/10/2015\t\tIN055737\t\tKarthi L\t\t\t\t\t\t\tIN055737 HSA-CRF-0250.1 - Dispatch Slip\n20/10/2015\t\tIN058099\t\tKarthi L\t\t\t\t\t\t\tHSA-CRF-0250.1/02- System does not Select All when a record is Unselected and Selected again using scanner..\n22/08/2016\t\tIN060590\t\tKarthi L\t\t\t\t\t\t\tHAAD Colour coding for Identification of Infectious disease in Patient BANNER[AAKH-CRF-0083.1].\n02/01/2017\t\tIN061888\t\tKarthi L\t\t\t\t\t\t\tTo record collection all at 1 go\n26/07/2017\tIN064835\t\tVijayakumar K\t\t\t\t\t\t\t\t\tML-MMOH-CRF-0578.1 [IN:064835]\n24/11/2017\t\tIN063974\t\tPrakash C\t\t\t\t\t\t\t\tSS-CRF-0059[IN:063974]\n22/02/2018\t\tIN066671\t\tPrakash C\t\t\t\t\t\t\t\t\tSS-CRF-0059.1\n 11/10/2023                 36727             Krishna Pranay   12/10/2023 Ramesh Goli           NMC-JD-CRF-0190\n---------------------------------------------------------------------------------------------------------------\n--> \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\n\t\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/dchk.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t<!-- used for date validation-->\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOR/js/OrCommon.js\"></script>\n \t<script language=\"JavaScript\" src=\"../../eOR/js/SpecimenOrder.js\"></script>\n \t<script language=\"JavaScript\" src=\"../../eOR/js/OrCommonFunction.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<style>\n\t.haad_disease\n\t\t{\n\t\t\twidth:12px;\n\t\t\theight:5px;\n\t\t\tborder:1px solid #000;\n\t\t}\n\t.photo {\n\n\t\t\t opacity: 0.5;\n\t\t\tfilter: alpha(opacity=30);\n\t}\n\t</style>\n</head>\n \n<body onscroll=\'processScroll()\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<form name=\'specimen_reporting_dtl\' id=\'specimen_reporting_dtl\' action=\"../../eOR/jsp/SpecimenCollectionListAndLabelsSearchResult.jsp\" method=\"post\">\n<div id=\"divHeadSep\" style=\"position: \">\n<table cellpadding=3 cellspacing=0 border=\'1\' width=\"100%\" height=\"\" id=\"tableresult\" class=\"grid\">\n<tr id=\"heading\">\n\t\t<!-- AAKH-CRF-0083.1 [IN060590] -->\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t<td class=columnheader width = \'90px\' wrap>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t<!-- AAKH-CRF-0083.1 [IN060590] -->\n\t\t<td class=columnheader width=\'\' nowrap>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t<!--IN063974 start-->\t\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t<td class=columnheader width=\'\' nowrap>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="<!--IN063974 start-->\n\t\t<td class=columnheader width=\'\' nowrap>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t<td class=columnheader width=\'\' nowrap>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t<td class=columnheader width=\'\' nowrap id=\'select_td\'  style=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" >\n\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t<a  class=\"gridLink\" id=\'hdr\'  ><font color=\'white\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</a><input type=checkbox  name=\'check_all\' id=\'check_all\'  ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="title=\'Select/Unselect action will affect records available in all pages\' ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="onClick=\'clickAll(this);";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="selectAllForLocnUpdate()";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'  disabled ></td><!--IN33889 IN41127-->\n\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" <!-- ML-MMOH-CRF-0540 [IN061888] -->\n\t\t\t\t<a  class=\"gridLink\" id=\'hdr\'  ><font color=\'white\'>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</a><input type=checkbox  name=\'check_all\' id=\'check_all\'  title=\'Select/Unselect action will affect records available in current page only\' onClick=\'checkAllRecCollection(this);\' > </td>  <!-- ML-MMOH-CRF-0540 [IN061888] -->\t\n\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n</tr>\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t<tr align=\"right\">\n\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t<td colspan=\"6\">\t\t\n\t\t<!--IN063974 starts-->\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t<td colspan=\"6\">\n\t\t<!--IN063974 starts-->\n\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t<td colspan=\"5\">\n\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" \n\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="   \n\t\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\t\t\t\t\t \n\t\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="  \n\t\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t</td>\n\t\t    </tr>\n\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'columnheader\' colspan=\'100%\' > <font size=1>";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</font></td>\n\t\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t<tr>\n\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="  \n\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =" \n\t\t\t<td width=\'\' wrap class=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' id=\'ord_detail";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'> <font size=1>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</font></td>\n\t\t\t<!--IN066671 starts-->\n\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\t\t\n\t\t\t\t<td \twidth=\'\'  nowrap class=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'>&nbsp;&nbsp;<img align=\'middle\' width=\'20\' height=\'20\'  src=\"../../eCommon/images/PI_Photo.gif\" class=\'patphotoimg\' title=\'Click to view photo\' onclick=\'showPhoto(";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 =")\'></td>\t\n\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =" \n\t\t\t<!--IN066671 ends-->\n\t\t\t<td width=\'\' nowrap class=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'><font size=1>";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</font></td>\n\t\t\t<td width=\'\' nowrap class=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' ><font size=1 ><a class=\"gridLink\" href=\'#\' onClick=\"callMenuFunctions(\'View\',\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\',\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\')\">";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</a></font></td>\n\t\t\t<td width=\'\' nowrap class=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' id = \'start_date";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\' ><font size=1 >";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</font></td>\n            <td width=\'\' nowrap class=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' id=\'status";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\' style=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\"><font size=1><input type=checkbox name=\'select";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\' id=\'select";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\'value=\"E\"  ";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="Checked";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 =" onClick=\'clickLine(this,";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 =")\' ";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="><a class=\"gridLink\" id=\'lins";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\'></a></font></td><!-- IN040758, IN052230 -->\n          \n            <input type=\"hidden\" name=\"specimen_date_time";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" id=\"specimen_date_time";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\" value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\">\n\t\t\t<input type=\"hidden\" name=\"specimen_remarks";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" id=\"specimen_remarks";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"collected_by";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\" id=\"collected_by";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"dispatch_mode";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" id=\"dispatch_mode";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\" value=\"\">\n\t\t\t<Input type=\'hidden\' name=\'seq_no";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\' id=\'seq_no";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\' value=\"-1\">\n\t\t\t<input type=\"hidden\" name=\"order_id";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\" id=\"order_id";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\">\n\t\t\t<input type=\"hidden\" name=\"source_type";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\" id=\"source_type";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\">\n\t\t\t<input type=\"hidden\" name=\"source_code";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\" id=\"source_code";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\">\n\t\t\t<input type=\"hidden\" name=\"order_type_code";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\" id=\"order_type_code";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\">\n\t\t\t<input type=\"hidden\" name=\"specimen_no";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\" id=\"specimen_no";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\">  <!-- Ramesh -->\n\t\t\t<input type=\"hidden\" name=\"lab_chking";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\" id=\"lab_chking";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\">\n\t\t\t<input type=\"hidden\" name=\"specimen_type";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\" id=\"specimen_type";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\">\n\t\t\t<input type=\"hidden\" name=\"order_date_time";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\" id=\"order_date_time";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\">\n\t\t\t<input type=\"hidden\" name=\"priority";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\" id=\"priority";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\">\n\t\t\t<input type=\"hidden\" name=\"coll_label_gen_rule";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\" id=\"coll_label_gen_rule";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\">\n\t\t\t<input type=\"hidden\" name=\"specimen_collect_yn";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\" id=\"specimen_collect_yn";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\">\n\t\t\t<input type=\"hidden\" name=\"order_category";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\" id=\"order_category";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\">\n\t\t\t<input type=\"hidden\" name=\"patient_class";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\" id=\"patient_class";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\">\n\t\t\t<input type=\"hidden\" name=\"start_date_time";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\" id=\"start_date_time";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\"> <!-- added for CRF 320 -->\n\t\t\t<input type=\"hidden\" name=\"old_start_date_time";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\" id=\"old_start_date_time";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\"> <!-- added for CRF 320 -->\n\t\t\t<input type=\"hidden\" name=\"specimen_collect_date_time";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\" id=\"specimen_collect_date_time";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\"><!--IN039158-->\n\n\t\t\t<input type=\"hidden\" name=\"cont_order_ind";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\" id=\"cont_order_ind";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\">\n\t\t\t<input type=\"hidden\" name=\"order_catalog_code";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\" id=\"order_catalog_code";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\">\n\t\t\t<input type=\"hidden\" name=\"performing_facility_id";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\" id=\"performing_facility_id";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\">\n\t\t\t\n\t\t\t<input type=\"hidden\" name=\"ordering_facility_id";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\" id=\"ordering_facility_id";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\"><!--IN039158-->\n\t\t\t<input type=\"hidden\" name=\"interval_test_yn";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\" id=\"interval_test_yn";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\" value=\"\">\n\t\t\t<input type=\'hidden\' name = \'catalogDesc";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\' value = \'";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\'/>\n\t\t\t<input type=\"hidden\" name=\"patient_id";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\" id=\"patient_id";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\"><!-- IN049737 -->\n\t\t\t<input type=\"hidden\" name=\"encounter_id";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\" id=\"encounter_id";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\"><!-- IN049737 -->\n\t\t\t<input type=\"hidden\" name=\"split_yn";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\" id=\"split_yn";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\"><!-- IN049737 -->\n\t\t\t<!-- IN052230 - Start -->\n\t\t\t<input type=\"hidden\" name=\"rds_order_id";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\" id=\"rds_order_id";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\">\n\t\t\t<input type=\"hidden\" name=\"rds_patient_id";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\" id=\"rds_patient_id";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\">\n\t\t\t<input type=\"hidden\" name=\"rds_specimen_no";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\" id=\"rds_specimen_no";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\">\n\t\t\t<input type=\"hidden\" name=\"rds_encounter_id";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\" id=\"rds_encounter_id";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\">\n\t\t\t<!-- IN052230 - End -->\n\t\t\t<input type=\"hidden\" name=\"rec_coll_individual_check_yn";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\" id=\"rec_coll_individual_check_yn";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\">\n\t\t\t\n\t\t</tr>\n\n\t";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\n\t\t\t<script>\n\t\t\t\tdocument.getElementById(\"check_all\").checked = true\n\t\t\t\tdocument.getElementById(\"check_all\").disabled = false\n\t\t\t</script>\n\t";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\n\t\t\t<script>\n\t\t\t\tdocument.getElementById(\"check_all\").disabled = false\n\t\t\t</script>\n\t";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\t\n\t\t\t<script>\n\t\t\t\tparent.SpecimenOrderSearch.document.specimen_order_search.specimen_no.focus();\n\t\t\t\tdocument.getElementById(\"check_all\").checked = true\n\t\t\t\tdocument.getElementById(\"check_all\").disabled = false\n\t\t\t</script>\n\t";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\t\n\t\t\t<script>\n\t\t\t\tparent.SpecimenOrderSearch.document.specimen_order_search.specimen_no.focus();\n\t\t\t\tdocument.getElementById(\"check_all\").checked = false\n\t\t\t\tdocument.getElementById(\"check_all\").disabled = false\n\t\t\t</script>\n\t";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\n\t<script>\n\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"common\"));\n\t\tparent.SpecimenOrderSearch.document.specimen_order_search.search_btn.disabled=false;\n\t\t//parent.SpecimenOrderHeader.location.href = \"../../eCommon/html/blank.html\"\n\t\tparent.SpecimenOrderResult.location.href = \"../../eCommon/html/blank.html\"\n\t\tparent.SpecimenOrderBtn.location.href = \"../../eCommon/html/blank.html\"\n\t</script>\n\t";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\n</table>\n</div>\n<input type=\"hidden\" name=\"total_recs\" id=\"total_recs\" value=\'";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\'>\n<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\">\n<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\">\n<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\">\n<input type=\"hidden\" name=\"function_id\" id=\"function_id\" value=\"";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\">\n<input type=\"hidden\" name=\"option_list\" id=\"option_list\" value=\"\">\n<input type=\"hidden\" name=\"specimen_hdr_date_time\" id=\"specimen_hdr_date_time\" value=\"\">\n<input type=\"hidden\" name=\"specimen_hdr_collected_by\" id=\"specimen_hdr_collected_by\" value=\"\">\n<input type=\"hidden\" name=\"specimen_hdr_specimen_remarks\" id=\"specimen_hdr_specimen_remarks\" value=\"\">\n<input type=\"hidden\" name=\"specimen_hdr_dispatch_mode\" id=\"specimen_hdr_dispatch_mode\" value=\"\">\n<input type=\"hidden\" name=\"lb_module\" id=\"lb_module\" value=\"";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\">\n<input type=\"hidden\" name=\"session_id\" id=\"session_id\" value=\"";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\">\n<input type=\"hidden\" name=\"curr_sys_date\" id=\"curr_sys_date\" value=\"";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\">\n\n<Input type=\"hidden\" name=\"collection_list\" id=\"collection_list\" value=\"";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\">\n<Input type=\"hidden\" name=\"print_locn_type\" id=\"print_locn_type\" value=\"";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\">\n<Input type=\"hidden\" name=\"print_locn\" id=\"print_locn\" value=\"";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\">\n<Input type=\"hidden\" name=\"date_from\" id=\"date_from\" value=\"";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\">\n<Input type=\"hidden\" name=\"date_to\" id=\"date_to\" value=\"";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\">\n<Input type=\"hidden\" name=\"priority\" id=\"priority\" value=\"";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\">\n<Input type=\"hidden\" name=\"location_type\" id=\"location_type\" value=\"";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\">\n<Input type=\"hidden\" name=\"locn\" id=\"locn\" value=\"";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\">\n<Input type=\"hidden\" name=\"locn1\" id=\"locn1\" value=\"";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\">\n<Input type=\"hidden\" name=\"order_type\" id=\"order_type\" value=\"";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\">\n<Input type=\"hidden\" name=\"order_type1\" id=\"order_type1\" value=\"";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\">\n<Input type=\"hidden\" name=\"option\" id=\"option\" value=\"";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\">\n<Input type=\"hidden\" name=\"select_specific_order\" id=\"select_specific_order\" value=\"";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\">\n<Input type=\"hidden\" name=\"patientId\" id=\"patientId\" value=\"";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\">\n<Input type=\"hidden\" name=\"order_id\" id=\"order_id\" value=\"";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\">\n<Input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\">\n<Input type=\"hidden\" name=\"auto_collect\" id=\"auto_collect\" value=\"";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\">\n<Input type=\"hidden\" name=\"specimen_no\" id=\"specimen_no\" value=\"";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\"> \n<Input type=\"hidden\" name=\"ordering_facility\" id=\"ordering_facility\" value=\"";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\"> \n<Input type=\"hidden\" name=\"performing_facility\" id=\"performing_facility\" value=\"";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\"> \n<Input type=\"hidden\" name=\"status\" id=\"status\" value=\"";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\"> \n<input type=\"hidden\" name=\"specimen_new_list_date_time\" id=\"specimen_new_list_date_time\" value=\"\">\n<input type=\"hidden\" name=\"specimen_new_list_collected_by\" id=\"specimen_new_list_collected_by\" value=\"\">\n<input type=\"hidden\" name=\"specimen_new_list_specimen_remarks\" id=\"specimen_new_list_specimen_remarks\" value=\"\">\n<input type=\"hidden\" name=\"specimen_new_list_seq_no\" id=\"specimen_new_list_seq_no\" value=\"\">\n<input type=\"hidden\" name=\"localeName\" id=\"localeName\" value=\"";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\"><!-- IN049737 -->\n<input type=\"hidden\" name=\"selectedRecords\" id=\"selectedRecords\" value=\"";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\"><!-- IN052230 -->\n<input type=\"hidden\" name=\"clonedMapcount\" id=\"clonedMapcount\" value=\"";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\"><!-- IN052230 -->\n<input type=\"hidden\" name=\"isSpecBarCodeSearchYN\" id=\"isSpecBarCodeSearchYN\" value=\"";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\"><!-- IN055737 - / IN058099 -->\n<Input type=\"hidden\" name=\"option_id\" id=\"option_id\" value=\"";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\"><!-- IN063354 -->\n<input type=\"hidden\"id=\"allowRedirectMulRecord\" name=\"allowRedirectMulRecord\" id=\"allowRedirectMulRecord\" value=\"";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\"><!-- 36727-->\n<input type=\"hidden\"id=\"isAllowRedirectMulRecord\" name=\"isAllowRedirectMulRecord\" id=\"isAllowRedirectMulRecord\" value=\"";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\"><!-- 36727-->\n\n<input type=\"hidden\" name=\"chk_counter\" id=\"chk_counter\" value=\"";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\">\n  ";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\n<Input type=\"hidden\" name=\"p_function_from\" id=\"p_function_from\" value=\"";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\">\n<input type=\'hidden\' name=\'totalChecked\' id=\'totalChecked\' value = \'0\'/>\n<Input type=\"hidden\" name=\"called_from\" id=\"called_from\" value=\"\"><!-- IN049737 -->\n\n<!-- For Next & previous -->\n<input type=\'hidden\' name=\'from\' id=\'from\' value=\'";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\'>\n<input type=\'hidden\' name=\'to\' id=\'to\' value=\'";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\'>\n<input type=\"hidden\" name=\"specimen_date_time\" id=\"specimen_date_time\" value=\"\">\n<input type=\"hidden\" name=\"specimen_remarks\" id=\"specimen_remarks\" value=\"\">\n<input type=\"hidden\" name=\"collected_by\" id=\"collected_by\" value=\"\">\n<input type=\"hidden\" name=\"dispatch_mode\" id=\"dispatch_mode\" value=\"\">\n<!-- [IN:030168] Start -->\n<input type=\"hidden\" name=\"ordering_pract\" id=\"ordering_pract\" value=\"";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\">\n<input type=\'hidden\' name=\'selectedOrders\' id=\'selectedOrders\' value=\'\'/>\n\n<!-- [IN:030168] End -->\n<input type=\'hidden\' name=\'reRoutePrinterId\' id=\'reRoutePrinterId\' value=\'\'/><!-- IN064835 -->\n <!-- For Next & previous -->\n<script>\n\t\t\t//if(parent.SpecimenOrderHeader.document.getElementById(\"tableheader\")==null)\n\t\t\t//{\n\t\t\t\t//setTimeout(\"alignHeading();\",300);\n\t\t\t//}\n\t\t\t//else \n\t\t\t\t//alignHeading();\n</script>\n</form>\n<script>ondetail();\n\t</script>\n</body>\n<script> parent.SpecimenOrderSearch.document.specimen_order_search.search_btn.disabled=false;</script>\n\n</html>\n";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );
	
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



    private boolean compareDate(String from_date,String to_date) {
    try{
        java.text.SimpleDateFormat formatter
             = new java.text.SimpleDateFormat ("dd/MM/yyyy kk:mm");

         // Parse the previous string back into a Date.
         java.text.ParsePosition pos = new java.text.ParsePosition(0);
         java.util.Date from = formatter.parse(from_date, pos);
         java.util.Date to = formatter.parse(to_date, pos);
         int result = from.compareTo(to);
         if (result > 0) { 
            return false;
         } else {
            return true;
         }
    } catch(Exception e) {
        System.out.println("error:"+e.getMessage());
		e.printStackTrace();
    }
    return true;
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);
 
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
            _bw.write(_wl_block3Bytes, _wl_block3);

	Connection con = null; //AAKH-CRF-0083.1 - IN060590
	try{
	/* Mandatory checks start */
				String bean_id = "Or_SpecimenOrder" ;
				String bean_name = "eOR.SpecimenOrder";
	/* Mandatory checks end */
		SpecimenOrder bean = (SpecimenOrder)getBeanObject( bean_id, bean_name , request ) ;
		bean.setLanguageId(localeName);
		String labchk="";
		//String lab_chking="";
		String mode	   = "1";
		request.setCharacterEncoding("UTF-8");
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
		bean.clear() ;
		bean.setMode( mode ) ;
		String lb_module="";
		//String lb_module = bean.getLbInstall("RL"); //Lab is installed or not changed on 7/16/2007 for lb_module logic change
		
		String session_id= bean.getSessionId();
		String slClassValue = "";
		String loc_dlts="";
		String order_detail="";
		String patient_details="";
		String location="";
		String priority_desc="";
		String HAAD_Data = ""; //AAKH-CRF-0083.1 - IN060590
		boolean isSiteSpecific  = false; //AAKH-CRF-0083.1 - IN060590
		boolean allowRedirectMulRecord=false;//36727
		String isAllowRedirectMulRecord="N";//36727
		String color_code_display = ""; //AAKH-CRF-0083.1 - IN060590;
		String login_facility_id = (String) session.getValue("facility_id");
		String select_all_spec_rec_collect_yn = bean.getCheckAllSpecRecCollection(login_facility_id);
	
		int count = 0;

		
		ArrayList searchData=new ArrayList();

		con = ConnectionManager.getConnection(); //AAKH-CRF-0083.1 - IN060590
		
		isSiteSpecific = CommonBean.isSiteSpecific(con, "OR","HAAD_DISEASE");	 //AAKH-CRF-0083.1 - IN060590
		//36727 start
		allowRedirectMulRecord = CommonBean.isSiteSpecific(con, "OR","ALLOW_MUL_REDIRECT_RECORD");	 
		if(allowRedirectMulRecord)
		{
			isAllowRedirectMulRecord="Y";
		}
                   //36727 end
		String date_from = request.getParameter( "date_from" ) ;
		String date_to = request.getParameter( "date_to" ) ;
		String priority = request.getParameter( "priority");
		String location_type = request.getParameter( "location_type");
		String locn = request.getParameter( "locn");
		String locn1 = request.getParameter( "locn1");
		String order_type = request.getParameter( "order_type");
		String order_type1 = request.getParameter( "order_type1");
		// [IN:030168] Start
		String practitioner_id = request.getParameter( "ordering_pract");
		// [IN:030168] End
		String option = request.getParameter( "option");
		option = (option == null) ? "" : option.trim();
		String select_td_style="";
		if(option.equals("S"))
		select_td_style="display:;visibility:hidden";
		else{
		select_td_style="display:;visibility:hidden";
		}
		String collection_list = request.getParameter( "collection_list");
		String select_specific_order = request.getParameter( "select_specific_order");
		String patientId = request.getParameter( "patientId");
		String order_id = request.getParameter( "order_id");
		String encounter_id = request.getParameter( "encounter_id");
		String curr_sys_date = 	 "";
		ArrayList sysdate = (ArrayList)bean.getSysDateTime();
		if (sysdate.size() == 3)
		curr_sys_date =  (String)sysdate.get(2);
		if ( !localeName.equals("en") )
{ 

		if (curr_sys_date.equals(" ") || curr_sys_date.equals("null")) curr_sys_date="";
		curr_sys_date = com.ehis.util.DateUtils.convertDate(curr_sys_date,"DMYHM","en",localeName);// thai date validations 15/02/2007
}

		String function_id = request.getParameter( "function_id" ) ;
		String p_function_from = request.getParameter( "p_function_from" ) ;
		String ordered_location = request.getParameter( "ordered_location" ) ;
		String ordered_location_val = request.getParameter( "ordered_location_val" ) ;
		

		String ordering_facility = bean.checkForNull(request.getParameter("ordering_facility"),"");
		String performing_facility = bean.checkForNull(request.getParameter("performing_facility"),"");
		String status = bean.checkForNull(request.getParameter("status"),"");

		
		String print_locn_type	= (bean.checkForNull(request.getParameter("prn_loctype")));
		
		String print_locn		= (bean.checkForNull(request.getParameter("prn_loc")));
		String auto_collect		= (bean.checkForNull(request.getParameter("auto_collect")));
		String specimen_no		= (bean.checkForNull(request.getParameter("specimen_no")));
		String option_id = (bean.checkForNull(request.getParameter("option_id"))); // ML-MMOH-CRF-0540 [IN061888]
		String practitioner_type = (String)session.getValue("practitioner_type");
		
		String cont_order_ind = "", order_catalog_code = "", performing_facility_id = "";
		String  ordering_facility_id="";//IN039158
		String multiSelect =  (bean.checkForNull(request.getParameter("multiSelect"))); //IN052230
		String total_query_records  = "0";
		String from	 = bean.checkForNull(request.getParameter( "from" ),"1") ;
		String to	 = bean.checkForNull(request.getParameter( "to" ),"7") ;
		int start	 = Integer.parseInt(from);
		int end		 = Integer.parseInt(to);

		if(date_from==null||date_from.equals("")||date_from.equals("null")){					date_from="";		}
		if(date_to==null ||date_to.equals("")||date_to.equals("null")){						date_to="";			}
		if(priority==null ||priority.equals("")||priority.equals("null")){					priority="";			}
		if(location_type==null ||location_type.equals("")||location_type.equals("null")){			location_type="";	}
		if(locn==null||locn.equals("")||locn.equals("null")){							locn="";				}
		if(locn1==null||locn1.equals("")||locn1.equals("null")){							locn1="";				}
		if(order_type==null||order_type.equals("")||order_type.equals("null")){				order_type="";			}
		if(order_type1==null||order_type1.equals("")||order_type1.equals("null")){				order_type1="";			}
		//[IN:030168] Start
		if(practitioner_id==null||practitioner_id.equals("")||practitioner_id.equals("null")){				practitioner_id="";			}
		//[IN:030168] End
		if(option==null||option.equals("")||option.equals("null")){						option="";				}
		if(collection_list==null||collection_list.equals("")||collection_list.equals("null")){		collection_list="";	}
		if(select_specific_order==null||select_specific_order.equals("")||select_specific_order.equals("null")){		select_specific_order="";			}
		if(patientId==null||patientId.equals("")||patientId.equals("null")){					patientId="";		}
		if(order_id==null||order_id.equals("")||order_id.equals("null")){					order_id="";				}
		if(encounter_id==null||encounter_id.equals("")||encounter_id.equals("null")){			encounter_id="";		}
		if(curr_sys_date==null||curr_sys_date.equals("")||curr_sys_date.equals("null")){			curr_sys_date="";		}

		if(print_locn_type==null||print_locn_type.equals("")||print_locn_type.equals("null")){			print_locn_type="";		}
		if(print_locn==null||print_locn.equals("")||print_locn.equals("null"))			 {			print_locn="";		}
		if(auto_collect==null||auto_collect.equals("")||auto_collect.equals("null"))			 {			auto_collect="";		}
		if(ordered_location==null||ordered_location.equals("")||ordered_location.equals("null"))			 {			ordered_location="";		}
		if(ordered_location_val==null||ordered_location_val.equals("")||ordered_location_val.equals("null"))			 {			ordered_location_val="";		}


		String temp_ord_cat="";

		String start_date_time = "";
		String or_collection_due = "";
		String order_stage = "";
		String collect     = "";
		String applicability = "";
		String split_yn = "N";//IN049737
		// IN052230 - Start
		HashMap dispatchMap = null; 
		HashMap cloneMap = null;
		int rds_start = 0; 
		rds_start = start; 
		int chk_counter = 0;
		int selectedRecords = 0;
		int clone_map_count = 0;
		
		String isBarCodeSearchConfigEnabled = ""; //IN055737 HSA-CRF-0250.1 
		isBarCodeSearchConfigEnabled = bean.getBarcodeSearchConfigValue(); //IN055737 HSA-CRF-0250.1 	
		
		if(multiSelect.equalsIgnoreCase("LOAD_ON_FIRST") && option.equals("S") && "N".equalsIgnoreCase(isBarCodeSearchConfigEnabled)) {
			bean.removeAllPatientDispSlipSelected();
			bean.removeAllClonedPatientDispSlipRecords(); //IN055694
		} 
		// IN052230 - End
		// IN055737 HSA-CRF-0250.1 - Start 
		if(option.equals("S") && multiSelect.equalsIgnoreCase("LOAD_ON_FIRST") && "Y".equalsIgnoreCase(isBarCodeSearchConfigEnabled)) {
			bean.removeAllClonedPatientDispSlipRecords(); 
		} 
		//IN055737 HSA-CRF-0250.1 - End
		//date_from="20/03/2008 10:44";
// [IN:030168] Start
//  searchData=(ArrayList)bean.getSearchDetails(practitioner_type,date_from,date_to,priority,location_type,locn,locn1,order_type,order_type1,option,patientId,order_id,encounter_id,specimen_no,ordering_facility,performing_facility,status,ordered_location,ordered_location_val,start,end);//,practitioner_id); 
//searchData=(ArrayList)bean.getSearchDetails(practitioner_type,date_from,date_to,priority,location_type,locn,locn1,order_type,order_type1,option,patientId,order_id,encounter_id,specimen_no,ordering_facility,performing_facility,status,ordered_location,ordered_location_val,start,end,practitioner_id); // commented for IN052230
//	searchData=(ArrayList)bean.getSearchDetails(practitioner_type,date_from,date_to,priority,location_type,locn,locn1,order_type,order_type1,option,patientId,order_id,encounter_id,specimen_no,ordering_facility,performing_facility,status,ordered_location,ordered_location_val,start,end,practitioner_id, multiSelect); // modified for IN052230 //commented for IN055737 HSA-CRF-0250.1 - Start
	searchData=(ArrayList)bean.getSearchDetails(practitioner_type,date_from,date_to,priority,location_type,locn,locn1,order_type,order_type1,option,patientId,order_id,encounter_id,specimen_no,ordering_facility,performing_facility,status,ordered_location,ordered_location_val,start,end,practitioner_id, multiSelect, isBarCodeSearchConfigEnabled); //modified for IN055737 HSA-CRF-0250.1 
// [IN:030168] End
/* Initialize Function specific end */
	 
	// commented for IN052230 - Start
	/*String select_style="";
	if(option.equals("S")){
		select_style="display:none";}
	else{
		select_style="display:inline;visibility:visible";
	}*/
	
	String select_style = "display:;visibility:visible"; 
	if(multiSelect.equalsIgnoreCase("LOAD_ON_FIRST") && option.equals("S") && "N".equalsIgnoreCase(isBarCodeSearchConfigEnabled) ) { // IN055737 HSA-CRF-0250.1 
			bean.setClonedPatientDispSlipRecords(bean.getPatientDispSlipSelected());
	}
	if(option.equals("S")) {
		cloneMap = bean.getClonedPatientDispSlipRecords();
		if(cloneMap != null) {
			clone_map_count = cloneMap.size();
		}
	}
	// IN055737 HSA-CRF-0250.1 - Start 
	if("Y".equalsIgnoreCase(isBarCodeSearchConfigEnabled) && option.equals("S") && "".equals(specimen_no) && multiSelect.equalsIgnoreCase("LOAD_ON_FIRST") ) {
		bean.removeAllPatientDispSlipSelected();
	}
	// IN055737 HSA-CRF-0250.1 - End
	
	multiSelect = "";	
	dispatchMap = bean.getPatientDispSlipSelected();
	if(dispatchMap != null){
		selectedRecords = dispatchMap.size();
	}
	
	//IN052230 - End

            _bw.write(_wl_block10Bytes, _wl_block10);
if(isSiteSpecific) { 
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
 } 
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
	if(option.equals("N")||option.equals("C"))
	  {
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
}
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(select_style));
            _bw.write(_wl_block20Bytes, _wl_block20);
 if (option.equals("D") || option.equals("N") || option.equals("S")) {
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
if(option.equals("S")){
            _bw.write(_wl_block23Bytes, _wl_block23);
}
            _bw.write(_wl_block24Bytes, _wl_block24);
if(!option.equals("S")){
            _bw.write(_wl_block25Bytes, _wl_block25);
}
            _bw.write(_wl_block26Bytes, _wl_block26);
 } else if (option.equals("C") && select_all_spec_rec_collect_yn.equals("Y") && !"".equals(patientId) && !"".equals(option_id)) { 
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
} else {

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
}
            _bw.write(_wl_block30Bytes, _wl_block30);
for(int i=0;i<searchData.size();i++){
	ArrayList specimen_result=(ArrayList)searchData.get(i);
	if(i==0 && searchData.size() > 0 && count == 0){
		if(option.equals("D")){
			//if(specimen_result.size()>=38)//IN039158
			if(specimen_result.size()>=39)//IN039158
			total_query_records = bean.checkForNull((String)specimen_result.get(38),"0");}//IN039158
		else
		{   //if(specimen_result.size()>=37)//IN039158
			if(specimen_result.size()>=38)//IN039158
			
                       total_query_records = bean.checkForNull((String)specimen_result.get(37),"0");}//IN039158
			
	if((Integer.parseInt(total_query_records)>0) || (start>1)){
            _bw.write(_wl_block31Bytes, _wl_block31);
 if(isSiteSpecific){ 
            _bw.write(_wl_block32Bytes, _wl_block32);
 }else if(option.equals("N")||option.equals("C")){ 
            _bw.write(_wl_block33Bytes, _wl_block33);
 }else{ 
            _bw.write(_wl_block34Bytes, _wl_block34);
 } 
            _bw.write(_wl_block35Bytes, _wl_block35);
            {java.lang.String __page ="ResultScrolling.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("from"), weblogic.utils.StringUtils.valueOf(start
                        )},{ weblogic.utils.StringUtils.valueOf("to"), weblogic.utils.StringUtils.valueOf(end
                        )},{ weblogic.utils.StringUtils.valueOf("total_size"), weblogic.utils.StringUtils.valueOf(total_query_records
                        )},{ weblogic.utils.StringUtils.valueOf("check_box_name"), weblogic.utils.StringUtils.valueOf("select")},{ weblogic.utils.StringUtils.valueOf("form_name"), weblogic.utils.StringUtils.valueOf("specimen_reporting_dtl")},{ weblogic.utils.StringUtils.valueOf("option"), weblogic.utils.StringUtils.valueOf(option
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block41Bytes, _wl_block41);
}
		}

		/*if(i % 2 == 0){
			slClassValue = "QRYEVEN";
		}else{
			slClassValue = "QRYODD";
		}*/
		slClassValue="gridData";

		if((String)specimen_result.get(0)==null)specimen_result.set(0,"");
		if((String)specimen_result.get(1)==null)specimen_result.set(1,"");
		if((String)specimen_result.get(2)==null)specimen_result.set(2,"");
		if((String)specimen_result.get(3)==null)specimen_result.set(3,"");
		if((String)specimen_result.get(4)==null)specimen_result.set(4,"");
		if((String)specimen_result.get(5)==null)specimen_result.set(5,"");
		if((String)specimen_result.get(6)==null)specimen_result.set(6,"");
		if((String)specimen_result.get(7)==null)specimen_result.set(7,"");
		if((String)specimen_result.get(8)==null)specimen_result.set(8,"");
		if((String)specimen_result.get(9)==null)specimen_result.set(9,"");
		if((String)specimen_result.get(10)==null)specimen_result.set(10,"");
		if((String)specimen_result.get(11)==null)specimen_result.set(11,"");
		if((String)specimen_result.get(12)==null)specimen_result.set(12,"");
		if((String)specimen_result.get(13)==null)specimen_result.set(13,"");
		if((String)specimen_result.get(14)==null)specimen_result.set(14,"");
		if((String)specimen_result.get(15)==null)specimen_result.set(15,"");
		if((String)specimen_result.get(16)==null)specimen_result.set(16,"");
		if((String)specimen_result.get(17)==null)specimen_result.set(17,"");
		if((String)specimen_result.get(18)==null)specimen_result.set(18,"");
		if((String)specimen_result.get(19)==null)specimen_result.set(19,"");
		if((String)specimen_result.get(20)==null)specimen_result.set(20,"");
		if((String)specimen_result.get(21)==null)specimen_result.set(21,"");
		if((String)specimen_result.get(22)==null)specimen_result.set(22,"");
		if((String)specimen_result.get(23)==null)specimen_result.set(23,"");
		if((String)specimen_result.get(24)==null)specimen_result.set(24,"");
		if((String)specimen_result.get(25)==null)specimen_result.set(25,"");
		if((String)specimen_result.get(26)==null)specimen_result.set(26,"");
		if((String)specimen_result.get(27)==null)specimen_result.set(27,"");
		if((String)specimen_result.get(28)==null)specimen_result.set(28,"");
		if((String)specimen_result.get(29)==null)specimen_result.set(29,"");
		if((String)specimen_result.get(30)==null)specimen_result.set(30,"");
		if((String)specimen_result.get(31)==null)specimen_result.set(31,"");
		if((String)specimen_result.get(32)==null)specimen_result.set(32,"");
		if((String)specimen_result.get(33)==null)specimen_result.set(33,"");
		if((String)specimen_result.get(34)==null)specimen_result.set(34,"");
		if((String)specimen_result.get(35)==null)specimen_result.set(35,"");
		if((String)specimen_result.get(36)==null)specimen_result.set(36,"");//IN039158

		if(option.equals("D"))
		{
			//if((String)specimen_result.get(36)==null)specimen_result.set(36,"");
			if((String)specimen_result.get(37)==null)specimen_result.set(37,"");
		}

		if(((String)specimen_result.get(4)).compareTo("R")==0){
					priority_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
										
				}
					else if(((String)specimen_result.get(4)).compareTo("U")==0)
				{
					
					priority_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");
									

				}
					else if(((String)specimen_result.get(4)).compareTo("S")==0)
				{
				
				priority_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels");
					

				}
				
				String sex1;
				sex1="";
				if (((String)specimen_result.get(26)).equalsIgnoreCase("M"))
				  sex1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
			  else if(((String)specimen_result.get(26)).equalsIgnoreCase("F"))
			sex1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");

			if(((String)specimen_result.get(14)).equalsIgnoreCase("C"))
			{
				location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
			}
			else if(((String)specimen_result.get(14)).equalsIgnoreCase("N"))
			{
				location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
			}
			else if(((String)specimen_result.get(14)).equalsIgnoreCase("R"))
			{
				location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referral.label","common_labels");
			}//Modification Starts for issue IN29355 by Menaka
			else if(((String)specimen_result.get(14)).equalsIgnoreCase("E"))
			{
				location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels");
			}//Modification Ends for issue IN29355 by Menaka
		patient_details=((String)specimen_result.get(32))+","+sex1+"/"+((String)specimen_result.get(13))+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ID:.label","or_labels")+((String)specimen_result.get(9))+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Encounter Dtls:.label","or_labels")+((String)specimen_result.get(10))+","+location+"/"+((String)specimen_result.get(7))+",";
		loc_dlts=location+"/"+((String)specimen_result.get(7));
		if(((String)specimen_result.get(31))==null)
		order_detail=((String)specimen_result.get(12));
		else
		order_detail=((String)specimen_result.get(12))+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.SpecimenNo.label","or_labels")+":-"+(String)specimen_result.get(31);

		start_date_time = (String)specimen_result.get(28);
		/* Thai date validations start 15/02/2007*/
		if(start_date_time.equals(" ") || start_date_time.equals("null")) start_date_time="";
		if ( !localeName.equals("en") )
{ 

			start_date_time = com.ehis.util.DateUtils.convertDate(start_date_time,"DMYHM","en",localeName);
}
			String order_date_time=(String)specimen_result.get(11);
			if(order_date_time.equals(" ") || order_date_time.equals("null")) order_date_time="";
			if ( !localeName.equals("en") )
{ 

			order_date_time = com.ehis.util.DateUtils.convertDate(order_date_time,"DMYHM","en",localeName);
}
			/*String specimen_collect_date_time="";
			if(option.equals("D")){
			specimen_collect_date_time=(String)specimen_result.get(31);
			if(specimen_collect_date_time.equals(" ") || specimen_collect_date_time.equals("null")) specimen_collect_date_time="";
			specimen_collect_date_time = com.ehis.util.DateUtils.convertDate(specimen_collect_date_time,"DMYHM","en",localeName);
			}*/
		/* Thai date validations end 15/02/2007*/
			
		/* Thai date validations end 15/02/2007*/
		
		or_collection_due = (String)specimen_result.get(30);

		StringTokenizer stoken = new StringTokenizer(or_collection_due,"!");

		int counter = 0;
		while (stoken.hasMoreTokens()) 
		{
		  if (counter == 0) 
		  {
		      order_stage = stoken.nextToken();
              counter++;
		  } 
		  else if (counter == 1) 
		  {
		      collect = stoken.nextToken();
		      counter++;
		  } 
		  else if (counter == 2) 
		  {
		      applicability = stoken.nextToken();
		      counter++;
		  }//IN049737 - Start
		  else if (counter == 3) 
		  {
			  split_yn = stoken.nextToken();
		      counter++;
		  }//IN049737 - End
		}		

		String chkColor = slClassValue;

		if(!option.equals("S")){
			if (order_stage.equals("FUTURE")) {
			  chkColor = "QRY7";
			} else if (order_stage.equals("DUE")) {
			  chkColor = "QRY2";
			} else if (order_stage.equals("OVERDUE")) {
			  chkColor = "QRY3";
			}
			else if (order_stage.equals("NOTPAID")) {//[IN030589]
			  chkColor = "QRY5";//[IN030589]
			}//[IN030589]
		}
	
            _bw.write(_wl_block2Bytes, _wl_block2);

		String rec_coll_individual_check_yn = "Y"; // ML-MMOH-CRF-0540 [IN061888]
		//IN040758 Starts
		String isDisabled = "";
		if(collect.equals("N") || (!option.equals("N") && order_stage.equals("FUTURE")))
		{
			isDisabled = "disabled";
			rec_coll_individual_check_yn = "N";  // ML-MMOH-CRF-0540 [IN061888]
		}
		else if(option.equals("S")){ //IN052230 - Start
			isDisabled = "enabled";
		} //IN052230 - End
		//IN040758 Ends
		if (!applicability.equals("X")) 
		{
			if(!(temp_ord_cat.equals(loc_dlts)))
			{
				temp_ord_cat = loc_dlts;
			
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(temp_ord_cat));
            _bw.write(_wl_block43Bytes, _wl_block43);

			}
		cont_order_ind			= (String)specimen_result.get(33);
		performing_facility_id			= (String)specimen_result.get(34);
		order_catalog_code			= (String)specimen_result.get(35);	
		ordering_facility_id = (String)specimen_result.get(36);	//IN039158
		//SpecimenDetails = (ArrayList)bean.getSpecimenDetails((String)specimen_result.get(8));
		// if(SpecimenDetails!=null && SpecimenDetails.size() > 0)
	      //{
		labchk = bean.checkForNull(bean.getmoduleRL(order_catalog_code,(String)specimen_result.get(0),(String)specimen_result.get(17),(String) session.getValue( "facility_id")),"");
		  //}//added on 7/16/2007 for lb_module instal check by uma

	 // Get the cont_order_id & performing_facility_id & order_catalog_code for the order_id
	 //if(lb_module.equals("Y"))changed on 7/16/2007 for lb_instal_yn
	 //if(labchk.equalsIgnoreCase("IBARL"))//added on 7/16/2007 for lb_module by uma 
	 //{
		 ///cont_order_id = ""; order_catalog_code = ""; performing_facility_id = "";
	     // SpecimenDetails = (ArrayList)bean.getSpecimenDetails((String)specimen_result.get(8)); // order_id
	      //if(SpecimenDetails!=null && SpecimenDetails.size() > 0)
	      //{
	      	 	      	  	
	      //}
	// }
		String displaying="";
		displaying=patient_details;
		String specimenDetail = (String)specimen_result.get(12);
		if(order_detail.indexOf("!~!")!=-1)
		{
			order_detail = order_detail.replace("!~!",",");
			specimenDetail  = specimenDetail.replace("!~!",",");
		}
		
		if(isSiteSpecific) {
			HAAD_Data =eMR.MRHaadcolorConfigBean.getHAADPlinecontext(con,(String)specimen_result.get(9),(String) session.getValue("facility_id")); //AAKH-CRF-0083.1 - IN060590
			if(HAAD_Data != null){
				
				String[] result = null;
				StringTokenizer token = new StringTokenizer(HAAD_Data, "|");
				StringBuilder colorCodeBuilder = new StringBuilder();
				colorCodeBuilder.append("<td class="+slClassValue+" ><table><tr>");
				while(token.hasMoreTokens()){
					colorCodeBuilder.append("<td><div class='haad_disease' style = 'background:");
					result = token.nextToken().split("~");
					for(int k=0;k<result.length-1;k++){
						if("".equals(result[1]) || result[1] == null)
							result[1] = "#FFFFFF";
						colorCodeBuilder.append(result[1]);
						colorCodeBuilder.append("' title ='"+result[0] +"'> </div></td>");
					}
				}
				colorCodeBuilder.append("</tr>  </table></td>");
				color_code_display = colorCodeBuilder.toString();
			}
			if("".equals(color_code_display) || color_code_display == null) {
				color_code_display = "<td width='' wrap class='"+ slClassValue+ "'</td> ";
			}
		}
		
            _bw.write(_wl_block44Bytes, _wl_block44);
if(isSiteSpecific) { 
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(color_code_display));
            _bw.write(_wl_block46Bytes, _wl_block46);
 } 
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(count));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(displaying));
            _bw.write(_wl_block50Bytes, _wl_block50);
if(option.equals("N")||option.equals("C"))
			{
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(count));
            _bw.write(_wl_block53Bytes, _wl_block53);
}
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf((String)specimen_result.get(8)));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf((String)specimen_result.get(1)));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf((String)specimen_result.get(8)));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf((String)specimen_result.get(26)));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf((String)specimen_result.get(9)));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf((String)specimen_result.get(6)));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf((String)specimen_result.get(10)));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(order_detail));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(count));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(start_date_time));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(chkColor));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(i));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(select_style));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(count));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(count));
            _bw.write(_wl_block68Bytes, _wl_block68);
if(dispatchMap.containsKey((String)specimen_result.get(31))) { chk_counter++; 
            _bw.write(_wl_block69Bytes, _wl_block69);
}
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(count));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(isDisabled));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(count));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(count));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(count));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(curr_sys_date));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(count));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(count));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(count));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(count));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(count));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(count));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(count));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(count));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(count));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(count));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf((String)specimen_result.get(8)));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(count));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(count));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf((String)specimen_result.get(14)));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(count));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(count));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf((String)specimen_result.get(15)));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(count));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(count));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf((String)specimen_result.get(17)));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(count));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(count));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf((String)specimen_result.get(31)));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(count));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(count));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(labchk));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(count));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(count));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf((String)specimen_result.get(24)));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(count));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(count));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(order_date_time));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(count));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(count));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf((String)specimen_result.get(16)));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(count));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(count));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf((String)specimen_result.get(23)));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(count));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(count));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf((String)specimen_result.get(25)));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(count));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(count));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf((String)specimen_result.get(0)));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(count));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(count));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf((String)specimen_result.get(27)));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(count));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(count));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(start_date_time));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(count));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(count));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(start_date_time));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(count));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(count));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf((option.equals("D"))?(String)specimen_result.get(37):""));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(count));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(count));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(cont_order_ind));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(count));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(count));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(count));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(count));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(performing_facility_id));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(count));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(count));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(ordering_facility_id));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(count));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(count));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(count));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(specimenDetail));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(count));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(count));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf((String)specimen_result.get(9)));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(count));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(count));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf((String)specimen_result.get(10)));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(count));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(count));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(split_yn));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(rds_start));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(rds_start));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf((String)specimen_result.get(8)));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(rds_start));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(rds_start));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf((String)specimen_result.get(9)));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(rds_start));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(rds_start));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf((String)specimen_result.get(31)));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(rds_start));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(rds_start));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf((String)specimen_result.get(10)));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(count));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(count));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(rec_coll_individual_check_yn));
            _bw.write(_wl_block144Bytes, _wl_block144);
	count++;
		rds_start++; // IN052230
		}
	}
	//IN052230 - Start
	//if(option.equals("S")) {// - commented for IN055737 HSA-CRF-0250.1
	if(option.equals("S") && isBarCodeSearchConfigEnabled.equals("N"))  { //added for IN055737 HSA-CRF-0250.1
		if(selectedRecords !=0 && clone_map_count == selectedRecords){
	
            _bw.write(_wl_block145Bytes, _wl_block145);
	
		}else {
	
            _bw.write(_wl_block146Bytes, _wl_block146);
	
		}
	//} //IN052230 - End
	} else if(option.equals("S") && isBarCodeSearchConfigEnabled.equals("Y"))  { //added for IN055737 HSA-CRF-0250.1
		if(selectedRecords !=0 && clone_map_count == selectedRecords){
	
            _bw.write(_wl_block147Bytes, _wl_block147);

		} else {
	
            _bw.write(_wl_block148Bytes, _wl_block148);

		}
	}
	//added for IN055737 HSA-CRF-0250.1 - End
	if(count == 0)
	{ 
	
            _bw.write(_wl_block149Bytes, _wl_block149);
	
	}	
	
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(count));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf( bean_name ));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(lb_module));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(session_id));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(curr_sys_date));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(collection_list));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(print_locn_type));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(print_locn));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(date_from));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(date_to));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(priority));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(location_type));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(locn));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(locn1));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(order_type));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(order_type1));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(option));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(select_specific_order));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(auto_collect));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(specimen_no));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(ordering_facility));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(performing_facility));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(status));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(selectedRecords));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(clone_map_count));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(isBarCodeSearchConfigEnabled));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(option_id));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(allowRedirectMulRecord));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(isAllowRedirectMulRecord));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(chk_counter));
            _bw.write(_wl_block187Bytes, _wl_block187);
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(p_function_from));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(from));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(to));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block192Bytes, _wl_block192);

putObjectInBean(bean_id,bean,request);
}
catch(Exception e){
	System.out.println(" Exception in SpecimenCollectionListAndLabelsSearchResult.jsp ==>  " +e.toString());
	e.printStackTrace();
}
finally {
	if(con != null)
		con.close();
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.diseasecode.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.PatientOrderDetail.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.PatientPhoto.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderID.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ordercatalog.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.startdatetime.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
}
