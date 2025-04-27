package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import ePH.*;
import ePH.Common.*;
import eCommon.Common.*;
import java.text.DecimalFormat;
import eST.*;
import eST.Common.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __dispmedicationorderdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/DispMedicationOrderDetails.jsp", 1709120731317L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n/*******************************************************************************\n * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.\n *  \n * Warning: This computer program is protected by copyright law and international treaties.\n * Unauthorized reproduction or distribution of this program, or any portion of it, \n * may result in severe civil and criminal penalties, and will be prosecuted to \n * the maximum extent possible under the law.\n ******************************************************************************/\n/*\n--------------------------------------------------------------------------------------------------------------\nDate\t\t\tEdit History       Name\t\t\t     Description\n--------------------------------------------------------------------------------------------------------------\n?\t\t\t\t100\t\t\t\t\t?                created\t\n03/01/2022\t\tTFS-26302         Prabha \t\t\t NMC-JD-SCF-0251\n---------------------------------------------------------------------------------------------------------------\n \n*/ -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n<html>\n\t<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../ePH/js/DispMedication.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t</head>\n\t<body onMouseDown=\"\" onKeyDown=\"lockKey()\">\n\t\t<form name=\"frmDispMedicationOrderDetails\" id=\"frmDispMedicationOrderDetails\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"1\" id=\"orderdetailstable\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t<td class=\"COLUMNHEADER\" style=\"font-size:9\" width=\"15%\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\"COLUMNHEADER\" style=\"font-size:9\" width=\"15%\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\"COLUMNHEADER\" style=\"font-size:9\" width=\"14%\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\t<TR>\n\t\t\t\t\t\t\t\t<td colspan =\"8\" ><font style=\"font-size:12\">&nbsp;&nbsp;<B>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</B></font>\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"encounterId_";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" id=\"encounterId_";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"> \n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</TR>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t\t\t\t\t<TR><td colspan =\"8\" class=\"commontoolbarfunction\"><input type =\"checkbox\" name = \"OrderType_";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="_";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="  onclick=\"uncheckOtherBoxes(\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\',\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\',this,\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\')\"><font style=\"font-size:11\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</font> </td> </TR> <!-- Added for NMC-JD-SCF-0251 -->\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t\t\t\t\t\t<TR><td colspan = 8 class=\"commontoolbarfunction\"><input type =\"checkbox\" name = \"OrderType_";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" onclick=\"uncheckOtherBoxes(\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</font></td> </TR> <!-- Added for NMC-JD-SCF-0251 -->\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\')\"><font style=\"font-size:11\"> ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</font></td></TR> <!-- Added for NMC-JD-SCF-0251 -->\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t\t\t\t\t<TR><td colspan = 8 class=\"commontoolbarfunction\"><input type =\"checkbox\"  name = \"OrderType_";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\"  ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" </font></td> </TR> <!-- Added for NMC-JD-SCF-0251 -->\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t\t\t\t<!-- added for GHL-CRF-0453 - start-->\n\t\t\t\t\t\t\t\t\t<tr><td width=\"4%\">\n\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t\t\t\t\t\t\t<img  src=\"../../ePH/images/printed_fully.gif\" height=\'20\'  width=\'20\' onmouseover = \"showToolTipPrint(this,\'Fully Printed\')\"></img>\n\n\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t\t\t\t\t\t<img  src=\"../../ePH/images/printed_partial.gif\" height=\'20\'  width=\'20\' onmouseover = \"showToolTipPrint(this,\'Partially Printed\')\"></img>\n\n\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t\t\t\t&nbsp;\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<!-- added for GHL-CRF-0453 - end-->\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t\t\t\t\t\t<td width=\"2%\"><input type =\"checkbox\" name = \"OrderValues_";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =" ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =" onclick = \"selectSingleADM(\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\');setIVPrepYN(this,\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\');\" disabled value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\"></td> <!-- Added for NMC-JD-SCF-0251 -->\n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =" onclick =\"setIVPrepYN(this,\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\');selectTaperOrders(this,\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\');\" value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\"></td>  <!-- Added for NMC-JD-SCF-0251 -->\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t\t\t\t\t\t<td style=\"font-size:9\" width=\"13%\" class=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="&nbsp;&nbsp;[";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="]\n\t\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\t\t\t\t\t\t\t<td style=\"font-size:9\" width=\"13%\" class=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t<b>";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</b>\n\t\t\t\t\t\t\t\t\t\t\t\t</font>\n\t\t\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</b>&nbsp;\n\t\t\t\t\t\t\t\t\t\t\t\t</font>\n\t\t\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t\t\t\t\t\t\t<td style=\"font-size:9\" width=\"17%\" class=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="&nbsp;\n\t\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t\t\t\t\t\t\t\t<td style=\"font-size:9\" width=\"15%\" class=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t\t\t\t\t\t\t\t<td style=\"font-size:9\" width=\"10%\" class=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t<font class=\"HYPERLINK\" onclick=\"showOrderComments(\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\')\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"cursor:pointer\">&nbsp;";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t\t\t\t\t\t\t\t\t\t</font>\n\t\t\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t&nbsp;\n\t\t\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t\t\t\t\t\t\t\t<td style=\"font-size:9\" width=\"14%\" class=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="&nbsp;\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"encOrdCount_";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" id=\"encOrdCount_";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\"> <!--added for KAUH-SCF-0061 [IN:034820] -->\n";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t\t\t\t\t\t\t<tr>\n";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t\t\t\t\t\t\t\t<td style=\"font-size:9\" width=\"13%\" class=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\">\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="]\n\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\">\n\t\t\t\t\t\t\t\t\t\t<font class=\"HYPERLINK\"\n\t\t\t\t\t\t\t\t\t\t\tonClick=\"checkOrderChanges(\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\' ,\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\')\" \n\t\t\t\t\t\t\t\t\t\t\tstyle=\"cursor:pointer\" id=\"font_order_id";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\">";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t\t\t\t\t\t\t\t\t</font>\n\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\">\n\t\t\t\t\t\t\t\t\t\t<font style=\"color:brown\"\n\t\t\t\t\t\t\t\t\t\t\tonClick=\"checkOrderChanges(\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\')\"\n\t\t\t\t\t\t\t\t\t\t\tstyle=\"cursor:pointer\">";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t\t\t\t\t\t\t\t\t<td style=\"font-size:9\" width=\"17%\" class=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="&nbsp;\n\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t\t\t\t\t\t\t<td style=\"font-size:9\" width=\"15%\" class=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t\t\t\t\t\t\t\t\t<td style=\"font-size:9\" width=\"10%\" class=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\">\n\t\t\t\t\t\t\t\t\t\t\t<font class=\"HYPERLINK\" onclick=\"showOrderComments(\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\')\"\n\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"cursor:pointer\">&nbsp;";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\t\t\t\t\t\t\t\t\t\t\t</font>\n\t\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\">\n\t\t\t\t\t\t\t\t\t\t\t&nbsp;\n\t\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t\t\t\t\t\t\t\t<td style=\"font-size:9\" width=\"14%\" class=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="&nbsp;\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"encOrdCount_";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\">  <!--added for KAUH-SCF-0061 [IN:034820]-->\n";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\t\t\t</table>\n\t\t\t<input type=\"hidden\" name=\"bean_id_1\" id=\"bean_id_1\" value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\">\n\t\t\t<input type=\"hidden\" name=\"bean_name_1\" id=\"bean_name_1\" value=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\">\n\t\t\t<input type=\"hidden\" name=\"encounterCount\" id=\"encounterCount\" value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\"> <!--  added  for SKR-SCF-0330 ICN 29789-->\n\t\t\t<input type=\"hidden\" name=\"num_of_orders\" id=\"num_of_orders\" value=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\">\n";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\t\t\t\t<input type=\"button\" name=\"getValues\" id=\"getValues\" value=\'";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\' onClick=\"getOrderIds(\'";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\')\">\n";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n\t\t\t<input type=\"hidden\" name=\"continueSameOrder\" id=\"continueSameOrder\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"OldTrxOrderIds\" id=\"OldTrxOrderIds\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"iv_prep_yn\" id=\"iv_prep_yn\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"iv_order_id\" id=\"iv_order_id\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"function_id\" id=\"function_id\" value=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\">\n\t\t\t<input type=\"hidden\" name=\"firstOrderTypeCode\" id=\"firstOrderTypeCode\" value=\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\">\n\t\t\t<input type=\"hidden\" name=\"disp_locn_code\" id=\"disp_locn_code\" value=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\"><!-- Added for for Bru-HIMS-CRF-081 -->\n\t\t\t<input type=\"hidden\" name=\"OrderType\" id=\"OrderType\" value=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\"> <!-- OrderType Added for ML-MMOH-CRF-0435 [IN:057357] -->\n\t\t     <input type=\"hidden\" name=\"tpn_mf_label\" id=\"tpn_mf_label\" value=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\"> \n\t\t</form>\n\t\t<script language=\"javascript\">\n\t\t";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n\t\t\t\t   selectFirstOrder();\n\t\t";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\n\t\t\t\t\tdocument.getElementById(\"font_order_id0\").click();\n";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\n\t\t\t\t\tcheckOrderChanges(\'\',\'\',\'";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\',\'\',\'\',\'";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\',\'\',\'";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\');\n";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\n\t\t\t\tselectFirstOrder1();\n";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\n\t\t\t\tselectFirstOrder();\n";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\n\t\t\t\t\tsetTimeout(\"displayFinancialDtlIcon(\'";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\')\",\'50\');;\n";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\n\t\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</body>\n</html>\n";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );
	
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
            _bw.write(_wl_block5Bytes, _wl_block5);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
			String locale = (String) session.getAttribute("LOCALE");

			String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

Connection con			= null;  // Added for ML-MMOH-CRF-0468
          try{
			con				= ConnectionManager.getConnection(request);//added for ml-mmoh-crf-0468
			boolean tpn_mf_label = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","TPN_MF_LABEL");// Added for ML-MMOH-CRF-0468 
			boolean encounter_order_check = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","ENCOUNTER_ORDER_CHECK"); //Added for NMC-JD-SCF-0251
			
			String bean_id = "DispMedicationBean";
			String bean_name = "ePH.DispMedicationBean";
			DispMedicationBean bean = (DispMedicationBean) getBeanObject(bean_id, bean_name, request);
			bean.setLanguageId(locale);
			//this function is used to clear modified date values 
			bean.setOrderIDOrderDate();
			bean.setDispencePeriod(bean.getDispLocnCode());

			String patient_id = request.getParameter("patient_id");
			String Order_id		=	request.getParameter("order_id")==null?"":request.getParameter("order_id");//Added for JD-CRF-0181 [IN:45511]
			String enc_id		=	request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id"); //Added for NMC-JD-SCF-0251
			bean.setCollectorDtlsFlag("N");
			String disp_stage = bean.getDispStage();
			String filling_status = bean.getFillingStatus();
			String disp_locn_catg = bean.getDispLocnCatg();
			ArrayList arrTokenList = new ArrayList();//Added for HSA-CRF-0136 [IN:048412]
			String disp_level = bean.getDispLevelValue();
			if (disp_level.equals("")) {
				disp_level = "O";
				bean.setDispLevelValue(disp_level);
			}
			String token_yn = bean.getIssueTokenOnRegnYN();//Adde here for below for ML-BRU-SCF-1870
			if (token_yn.equals("Y") && disp_locn_catg.equals("O")) {//Adding start for ML-BRU-SCF-1870
				//bean.getOrderlingFacilityID(patient_id.trim());
			}//Adding end for ML-BRU-SCF-1870 and commented for SKR-SCF-1512
			ArrayList result = bean.getOrders(patient_id.trim());
			ArrayList IVlegends = (ArrayList)bean.getIVLegends();
			String[] strIVLegends = new String[5];
			int k = 0;

			for(int i=1;i<IVlegends.size();i=i+2){
				strIVLegends[k++]  = (String) IVlegends.get(i); 
			}
			/*boolean displayFacility = false;
			 for(int i=0;i<result.size();i=i+10){
			 if(result.get(i+5)!=null){
			 displayFacility = true;
			 break;
			 }
			 }*/
			HashMap hmEncbasedRecs = new HashMap(); //added  for SKR-SCF-0330 ICN 29789
			String encounter_id=""; //added  for SKR-SCF-0330 ICN 29789
			/*String tapered_yn=""; //added  for SKR-SCF-0330 ICN 29789
			String taper_order_id=""; //added  for SKR-SCF-0330 ICN 29789*/
			ArrayList[] alResults = null;//new ArrayList[11];		
			int iOrderTypeCode = -1, iFirstOrderTypeCode=-1;
			for (int i = 0; i < result.size(); i = i + 11) {	//10 ->11  for SKR-SCF-0330 ICN 29789   //Modified for RUT-CRF-0088 [IN036978] 13->11
				 //added  for SKR-SCF-0330 ICN 29789 -Start
				if(!Order_id.equals("")){//Added for JD-CRF-0181 [IN:45511]
					if(result.get(i+1).equals(Order_id)){
						encounter_id = result.get(i+10)==null?"11111":(String)result.get(i+10);
				
						if(hmEncbasedRecs.containsKey(encounter_id))
							alResults = (ArrayList[])hmEncbasedRecs.get(encounter_id);
						else{
							alResults= new ArrayList[11];
							for (int indx = 0; indx < 11; indx++) {		
								alResults[indx] = new ArrayList();
							}
						}
						//added  for SKR-SCF-0330 ICN 29789 -End
						if(result.get(i + 8) == null)
							iOrderTypeCode =  0;
						else if (result.get(i + 8).toString().equals("0"))
							iOrderTypeCode = 10;
						else
							iOrderTypeCode = Integer.parseInt(result.get(i + 8).toString());
						if(iFirstOrderTypeCode == -1)
							iFirstOrderTypeCode = iOrderTypeCode;

						for (int j = 0; j < 11; j++) {	//10 ->11 for SKR-SCF-0330 ICN 29789  	//Modified for RUT-CRF-0088 [IN036978]  13->11
							alResults[iOrderTypeCode].add(result.get(i + j));	
						}
						hmEncbasedRecs.put(encounter_id, alResults);  //added  for SKR-SCF-0330 ICN 29789
					}
				}
				else{
					encounter_id = result.get(i+10)==null?"11111":(String)result.get(i+10);
				
					if(hmEncbasedRecs.containsKey(encounter_id))
						alResults = (ArrayList[])hmEncbasedRecs.get(encounter_id);
					else{
						alResults= new ArrayList[11];
						for (int indx = 0; indx < 11; indx++) {		
							alResults[indx] = new ArrayList();
						}
					}
				 	//added  for SKR-SCF-0330 ICN 29789 -End
					if(result.get(i + 8) == null)
						iOrderTypeCode =  0;
					else if (result.get(i + 8).toString().equals("0"))
						iOrderTypeCode = 10;
					else
						iOrderTypeCode = Integer.parseInt(result.get(i + 8).toString());
					if(iFirstOrderTypeCode == -1)
						iFirstOrderTypeCode = iOrderTypeCode;

					for (int j = 0; j < 11; j++) {	//10 ->11 for SKR-SCF-0330 ICN 29789  	//Modified for RUT-CRF-0088 [IN036978]  13->11
						alResults[iOrderTypeCode].add(result.get(i + j));	
					}
					hmEncbasedRecs.put(encounter_id, alResults);  //added  for SKR-SCF-0330 ICN 29789
				}
				if(i==0){ //if block added for ICN 31563 
					bean.setEncounterID(encounter_id);
				}
			}

			List encounterList = new ArrayList(hmEncbasedRecs.keySet());  //added  for SKR-SCF-0330 ICN 29789

			String bean_id_1 = "DispMedicationAllStages";
			String bean_name_1 = "ePH.DispMedicationAllStages";

			DispMedicationAllStages bean_1 = (DispMedicationAllStages) getBeanObject(bean_id_1, bean_name_1, request);
			bean_1.setLanguageId(locale);
			bean_1.clearPatient(patient_id);
			bean_1.addPatient(patient_id);
			bean.setTodaysDate();//added for GHL-SCF-1244 
			//HashMap pat_details = (HashMap)bean_1.getPatient();
			bean_1.setModuleId("2");
			bean_1.setObject(bean);

			String group_by_patient = bean.getChkGroupByPatient();
			if (group_by_patient == null)
				group_by_patient = "E";
			if (group_by_patient.equals(""))
				group_by_patient = "E";

			// Store the collector details in bean
			String date_time = bean.getTodaysDateTime();

			ArrayList arr_list = bean.getPatientDetails();
			int index = arr_list.indexOf(patient_id);

			String collected_by = "";
			String nationality = "";
			String gender = "";
			//code added on 2/5/2004 to set patient_id ...
			bean.setPatientID(patient_id);
			if (arr_list.size() > 0) {
				collected_by = (String) arr_list.get(index + 1);
				nationality = (String) arr_list.get(index + 2);
				gender = (String) arr_list.get(index + 3);
			}

			String dispensed_by = bean_1.getPharmacistID();
			String disp_locn_code = bean.getDispLocnCode();
			String token_series = bean.checkForNull(bean.getTokenSeriesCode());

			StringBuffer orderIDS_trxRefIDS = new StringBuffer();

			if (disp_locn_catg.equals("I")) {
				bean.setIssueTokenOnRegnYN("N");
			}

		//	String token_yn = bean.getIssueTokenOnRegnYN();//Commented here and added above for ML-BRU-SCF-1870
			if (token_yn.equals("Y") && disp_locn_catg.equals("O")) {
				bean.setDeliveryDetails(collected_by, gender, nationality, dispensed_by, date_time, token_series, "", "", "");
			} 
			else {
				bean.setDeliveryDetails(collected_by, gender, nationality,dispensed_by, date_time, "", "", "");
			}

            _bw.write(_wl_block8Bytes, _wl_block8);

				//if (disp_level.equals("O") || disp_level.equals("")) {
				if (group_by_patient.equals("D")){

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

				}
				//}

				String classvalue = "";
				String token_no = "", pract_name,strLocation;
				int recCount = 0, encRecCount=0; // encRecCount added for KAUH-SCF-0061 [IN:034820]
				String iv_prep_yn = null;
				//added for GHL-CRF-0453 - start
				String print_value = "";
				String min_value   = "0";//GHL-CRF-0453
				String max_value   = "0";//GHL-CRF-0453
				String print_msg   = "";
				String print_spilt = "";//GHL-CRF-0453
				HashMap printValueForOrders = bean.getPrintValueForOrders(); //CRF-453
				//added for GHL-CRF-0453 - end
				if (bean.getCriteriaOrderType().equals("ALL") || bean.getCriteriaOrderType().equals("CDR") || (tpn_mf_label && bean.getCriteriaOrderType().equals("TD"))){//TD added for ml-mmoh-crf-0468 // CDR Condition Added for ML-MMOH-CRF-0435 [IN:057357]
					iOrderTypeCode = -1;
					 //added  for SKR-SCF-0330 ICN 29789 -Start
					if(hmEncbasedRecs!=null && hmEncbasedRecs.size()>0){ 
						for(int encCount=0; encCount<encounterList.size(); encCount++){ 
							encounter_id = (String) encounterList.get(encCount)==null?"":(String) encounterList.get(encCount); 
							alResults = (ArrayList[])hmEncbasedRecs.get(encounter_id);  
							if(encCount==0){ //if block added for ICN 31563 
								bean.setEncounterID(encounter_id);
							}
							//Added for NMC-JD-SCF-0251
							String order_checked = "";
							String order_disabled="disabled";
							if(encounter_order_check){
								if(enc_id.equals(encounter_id)){
									order_checked="checked";
									order_disabled="";
								}
							}
							//Added for NMC-JD-SCF-0251

            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(encounter_id.equals("11111")?"&nbsp;":encounter_id ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(encCount));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(encCount));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block18Bytes, _wl_block18);

							 //added  for SKR-SCF-0330 ICN 29789 -End
							for(int j=0;j<11;j++){
								encRecCount = 0; // added for KAUH-SCF-0061 [IN:034820]
								result = (ArrayList)alResults[j];
								if(result != null && result.size() >0){
									if(result.get(8) == null)
										iOrderTypeCode =  0;
									else if (result.get(8).toString().equals("0"))
										iOrderTypeCode = 10;
									else
										iOrderTypeCode = Integer.parseInt(result.get(8).toString());
									//iOrderTypeCode = result.get(8) == null?10:Integer.parseInt(result.get(8).toString());
									if(iOrderTypeCode == 0){

            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(encCount));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(j));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(order_checked));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(encCount));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(j));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(iOrderTypeCode));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

									}
									else if(iOrderTypeCode == 10){

            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(encCount));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(j));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(order_checked));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(encCount));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(j));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(iOrderTypeCode));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

									}
									else if( iOrderTypeCode> 0 && iOrderTypeCode <6){

            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(encCount));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(j));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(order_checked));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(encCount));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(j));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(iOrderTypeCode));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strIVLegends[iOrderTypeCode-1]));
            _bw.write(_wl_block31Bytes, _wl_block31);

									}
									else if( iOrderTypeCode == 6){

            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(encCount));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(j));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(order_checked));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(encCount));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(j));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(iOrderTypeCode));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

									}
									else if( iOrderTypeCode == 7){

            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(encCount));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(j));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(order_checked));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(encCount));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(j));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(iOrderTypeCode));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

									}
									else if( iOrderTypeCode == 8){

            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(encCount));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(j));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(order_checked));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(encCount));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(j));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(iOrderTypeCode));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

									}
									else if(iOrderTypeCode == 9){

            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(encCount));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(j));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(order_checked));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(encCount));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(j));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(iOrderTypeCode));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

									}
								}
								k=0; // This is used to set the index for the second level checkboxes
								if(token_series.equals("*A"))//Added for HSA-SCF-0081 [IN:050227]
									token_series="";
								for (int i = 0; i < result.size(); i=i+11, recCount++) { //10-->11	//Modified for RUT-CRF-0088 [IN036978] 13->11
									encRecCount++; // added for KAUH-SCF-0061 [IN:034820]
									iv_prep_yn = (String) result.get(i + 8);
									bean_1.addPrescription(patient_id, (String) result.get(i + 1));
									//tapered_yn =(String)result.get(i + 11)==null?"":(String)result.get(i + 11); // Commented for RUT-CRF-0088 [IN036978] 
									//taper_order_id =(String)result.get(i + 12)==null?"":(String)result.get(i + 12);

									//HashMap pat_details_1 = (HashMap)bean_1.getPatient();
									if (token_yn.equals("Y") && disp_locn_catg.equals("O")) {
										//token_no	=	bean.getTokenDetails(disp_locn_code,patient_id,token_series,(String)result.get(i+1));
										token_no = bean.getTokenNo();
										if (!token_no.equals("") && !token_series.equals(""))//Condition && !token_series.equals("") added for HSA-CRF-0136 [IN:048412]
											bean_1.setTokenVals((String) result.get(i + 1), token_series+"_"+token_no);//Moved here for HSA-CRF-0136 [IN:048412]
										if (token_no.equals("") || token_series.equals("")) {//Condition || token_series.equals("") added for HSA-CRF-0136 [IN:048412]
											arrTokenList = bean.getTokenDetails(disp_locn_code, patient_id, token_series, (String) result.get(i + 1));
											if(arrTokenList!=null && arrTokenList.size()>0){//Added for HSA-CRF-0136 [IN:048412] start
												token_no = (String)arrTokenList.get(1);
												bean_1.setTokenVals((String) result.get(i + 1), (String)arrTokenList.get(0)+"_"+(String)arrTokenList.get(1));
											}//Added for HSA-CRF-0136 [IN:048412] end
										}
										//bean_1.setTokenVals((String) result.get(i + 1), token_no); //commented for HSA-CRF-0136 [IN:048412] 
									}
									if (disp_level.equals("O")) {
										orderIDS_trxRefIDS = new StringBuffer();
									}
									orderIDS_trxRefIDS.append((String) result.get(i + 1)).append("::").append((String) result.get(i + 9)).append("::");

									if (recCount % 2 == 0)
										classvalue = "QRYODD";
									else
										classvalue = "QRYEVEN";

									// Dispense By Orders
									//if (disp_level.equals("O") || disp_level.equals("")) {

            _bw.write(_wl_block35Bytes, _wl_block35);
					//	System.err.println("DispMedicationOrderDetails.jsp=====324=printValueForOrders===dssd====>"+printValueForOrders);
									if(printValueForOrders!=null && printValueForOrders.size()>0)
									{
										print_value = "";
											print_spilt = (String)printValueForOrders.get(result.get(i + 1));//GHL-CRF-0453 8/2/2017
											if(print_spilt!=null){//GHL-CRF-0453
												min_value = ((String)printValueForOrders.get(result.get(i + 1))).split("~")[0];
												max_value = ((String)printValueForOrders.get(result.get(i + 1))).split("~")[1];
											}
											if(Integer.parseInt(max_value)==1)
												print_value = "1";
											
										//	System.err.println("min_value=339=>"+min_value+"==max_value==>"+max_value);
											if(Integer.parseInt(min_value)!=Integer.parseInt(max_value))
												print_msg = "P";

											if(Integer.parseInt(min_value)!=0 && Integer.parseInt(min_value)==Integer.parseInt(max_value))
												print_msg = "F";

									//	System.err.println("DispMedicationOrderDetails.jsp===print_msg=====346====>"+print_msg);
									}
									if(print_value.equals("1")){
										if(print_msg.equals("F")){

            _bw.write(_wl_block36Bytes, _wl_block36);
											}else{ 
            _bw.write(_wl_block37Bytes, _wl_block37);
											}
									}else{ 
            _bw.write(_wl_block38Bytes, _wl_block38);
 								}

            _bw.write(_wl_block39Bytes, _wl_block39);
 
									if(j==2 || j==4 || j==10 || j==6  || (j==7 && tpn_mf_label)){// only for Admixture orders (single order should be selected)

            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(encCount));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(j));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(order_checked));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(order_disabled));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(encCount));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(j));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(result.get(i + 1)));
            _bw.write(_wl_block45Bytes, _wl_block45);

									}
									else{

            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(encCount));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(j));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(order_checked));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(order_disabled));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(result.get(i + 1)));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(encCount));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(j));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(iOrderTypeCode));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(result.get(i + 1)));
            _bw.write(_wl_block49Bytes, _wl_block49);

									}
									if (token_yn.equals("Y") && (!disp_locn_catg.equals("I"))) {

            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate((String) result.get(i + 2), "DMY","en", locale)));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(token_no));
            _bw.write(_wl_block53Bytes, _wl_block53);

										}
										else {

            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate((String) result.get(i + 2), "DMYHM","en", locale)));
            _bw.write(_wl_block56Bytes, _wl_block56);

										}
										if ((result.get(i)).equals("R")) {

											pract_name = (String) result.get(i + 3);
											/*if(!pract_name.equals("")&&pract_name!=null){
											 pract_name=pract_name.replaceAll(" ","%20");
											 pract_name=	java.net.URLEncoder.encode(pract_name);
											 pract_name=pract_name.replaceAll("%2520","%20");
											 }*/

            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(result.get(i + 1)));
            _bw.write(_wl_block58Bytes, _wl_block58);

										} 
										else if ((result.get(i)).equals("U")) {
											pract_name = (String) result.get(i + 3);
											/*if(!pract_name.equals("")&&pract_name!=null){
											 pract_name=pract_name.replaceAll(" ","%20");
											 pract_name=	java.net.URLEncoder.encode(pract_name);
											 pract_name=pract_name.replaceAll("%2520","%20");
											 }*/

            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(result.get(i + 1)));
            _bw.write(_wl_block59Bytes, _wl_block59);

										}

            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(result.get(i + 3)));
            _bw.write(_wl_block61Bytes, _wl_block61);

										strLocation = "&nbsp;";
										if (result.get(i + 4) == null) {
											strLocation = "";
										} 
										else {
											strLocation = (String) result.get(i + 4);
										}

            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(strLocation));
            _bw.write(_wl_block61Bytes, _wl_block61);

										if ((((String) result.get(i + 6)).trim()).equals("Y")) {

            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(result.get(i + 1)));
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);

										} 
										else {

            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block67Bytes, _wl_block67);

										}

            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(result.get(i + 5) == null ? "&nbsp;": result.get(i + 5)));
            _bw.write(_wl_block69Bytes, _wl_block69);
            _bw.write(_wl_block70Bytes, _wl_block70);

							//}
								}

            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(encCount));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(j));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(encCount));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(j));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(encRecCount));
            _bw.write(_wl_block73Bytes, _wl_block73);

							}
						}
					}
				}
				else{
					 //added  for SKR-SCF-0330 ICN 29789 -Start
					if(hmEncbasedRecs!=null && hmEncbasedRecs.size()>0){ 
						for(int encCount=0; encCount<encounterList.size(); encCount++){ 
							encRecCount = 0; // added for KAUH-SCF-0061 [IN:034820]
							encounter_id = (String) encounterList.get(encCount); 
							alResults = (ArrayList[])hmEncbasedRecs.get(encounter_id);  
							if(encCount==0){ //if block added for ICN 31563 
								bean.setEncounterID(encounter_id);
							}

            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf((String) encounterList.get(encCount)));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(encCount));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(encCount));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block18Bytes, _wl_block18);

							 //added  for SKR-SCF-0330 ICN 29789 -End
						result = (ArrayList)alResults[iOrderTypeCode]; //0 changed to iOrderTypeCode for ICN 31563
						if(token_series.equals("*A")) //Added for HSA-SCF-0081 [IN:050227]
							token_series="";
						for (int i = 0; i < result.size(); i = i + 11, recCount++) { //10->11 for SKR-SCF-0330 ICN 29789
							encRecCount++; // added for KAUH-SCF-0061 [IN:034820]
							iv_prep_yn = (String) result.get(i + 8);
							bean_1.addPrescription(patient_id, (String) result.get(i + 1));
							//tapered_yn =(String)result.get(i + 11)==null?"":(String)result.get(i + 11); //Commented for RUT-CRF-0088 [IN036978] 
							//taper_order_id =(String)result.get(i + 12)==null?"":(String)result.get(i + 12);
							//HashMap pat_details_1 = (HashMap)bean_1.getPatient();
							if (token_yn.equals("Y") && disp_locn_catg.equals("O")) {
								//token_no	=	bean.getTokenDetails(disp_locn_code,patient_id,token_series,(String)result.get(i+1));
								token_no = bean.getTokenNo();
								if (!token_no.equals("") && !token_series.equals(""))//Condition && !token_series.equals("") added for HSA-CRF-0136 [IN:048412]
									bean_1.setTokenVals((String) result.get(i + 1), token_series+"_"+token_no);//Moved here for HSA-CRF-0136 [IN:048412]
								if (token_no.equals("") || token_series.equals("")) {//Condition || token_series.equals("") added for HSA-CRF-0136 [IN:048412]
									arrTokenList = bean.getTokenDetails(disp_locn_code, patient_id, token_series, (String) result.get(i + 1));//Changed as ArrayList for HSA-CRF-0136 [IN:048412]
									if(arrTokenList!=null && arrTokenList.size()>0){//Added for HSA-CRF-0136 [IN:048412] start
										token_no = (String)arrTokenList.get(1);
										bean_1.setTokenVals((String) result.get(i + 1), (String)arrTokenList.get(0)+"_"+(String)arrTokenList.get(1));
									}//Added for HSA-CRF-0136 [IN:048412] end
								}
								//bean_1.setTokenVals((String) result.get(i + 1), token_no);//commented for HSA-CRF-0136 [IN:048412] 
							}
							if (disp_level.equals("O")) {
								orderIDS_trxRefIDS = new StringBuffer();
							}
							orderIDS_trxRefIDS.append((String) result.get(i + 1)).append("::").append((String) result.get(i + 9)).append("::");

							if (recCount % 2 == 0)
								classvalue = "QRYODD";
							else
								classvalue = "QRYEVEN";
							// Dispense By Orders
							if (disp_level.equals("O") || disp_level.equals("")) {

            _bw.write(_wl_block74Bytes, _wl_block74);

								if (token_yn.equals("Y") && (!disp_locn_catg.equals("I"))) {

            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate((String) result.get(i + 2), "DMY","en", locale)));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(token_no));
            _bw.write(_wl_block77Bytes, _wl_block77);

								} 
								else {

            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate((String) result.get(i + 2), "DMYHM","en", locale)));
            _bw.write(_wl_block78Bytes, _wl_block78);

								}
								if ((result.get(i)).equals("R")) {

									pract_name = (String) result.get(i + 3);
									/*if(!pract_name.equals("")&&pract_name!=null){
									 pract_name=pract_name.replaceAll(" ","%20");
									 pract_name=	java.net.URLEncoder.encode(pract_name);
									 pract_name=pract_name.replaceAll("%2520","%20");
									 }*/

            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(result.get(i +1)));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(disp_stage));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(result.get(i + 7)));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(java.net.URLEncoder.encode(pract_name, "UTF-8")));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(filling_status));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(disp_locn_catg));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(group_by_patient));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(disp_level));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(java.net.URLEncoder.encode(orderIDS_trxRefIDS.toString())));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(result.get(i + 1)));
            _bw.write(_wl_block83Bytes, _wl_block83);

								} 
								else if ((result.get(i)).equals("U")) {
									pract_name = (String) result.get(i + 3);
									/*if(!pract_name.equals("")&&pract_name!=null){
									 pract_name=pract_name.replaceAll(" ","%20");
									 pract_name=	java.net.URLEncoder.encode(pract_name);
									 pract_name=pract_name.replaceAll("%2520","%20");
									 }*/

            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(result.get(i + 1)));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(disp_stage));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(result.get(i + 7)));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(java.net.URLEncoder.encode(pract_name,"UTF-8")));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(filling_status));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(disp_locn_catg));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(group_by_patient));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(disp_level));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(java.net.URLEncoder.encode(orderIDS_trxRefIDS.toString())));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(result.get(i + 1)));
            _bw.write(_wl_block83Bytes, _wl_block83);

								}

            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i + 3)));
            _bw.write(_wl_block87Bytes, _wl_block87);

									strLocation = "&nbsp;";
									if (result.get(i + 4) == null) {
										strLocation = "";
									} 
									else {
										strLocation = (String) result.get(i + 4);
									}

            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(strLocation));
            _bw.write(_wl_block87Bytes, _wl_block87);

									if ((((String) result.get(i + 6)).trim()).equals("Y")) {

            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(result.get(i + 1)));
            _bw.write(_wl_block91Bytes, _wl_block91);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block92Bytes, _wl_block92);

									} 
									else {

            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block93Bytes, _wl_block93);

									}

            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i + 5) == null ? "&nbsp;": result.get(i + 5)));
            _bw.write(_wl_block95Bytes, _wl_block95);
            _bw.write(_wl_block70Bytes, _wl_block70);

								}
							}

            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(encCount));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(iOrderTypeCode));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(encCount));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(iOrderTypeCode));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(encRecCount));
            _bw.write(_wl_block97Bytes, _wl_block97);

						}
					}
				}

            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(bean_id_1));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(bean_name_1));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(encounterList.size()));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block102Bytes, _wl_block102);

			if (bean.getCriteriaOrderType().equals("ALL") || bean.getCriteriaOrderType().equals("CDR") || (tpn_mf_label && bean.getCriteriaOrderType().equals("TD")) ){  //Td added for ml-mmoh-crf-0468 // CDR Condition Added for ML-MMOH-CRF-0435 [IN:057357]

            _bw.write(_wl_block103Bytes, _wl_block103);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(disp_stage));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(filling_status));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(disp_locn_catg));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(group_by_patient));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(disp_level));
            _bw.write(_wl_block105Bytes, _wl_block105);

			}

            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(bean.getSFunctionId()));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(iFirstOrderTypeCode));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(disp_locn_code));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(bean.getCriteriaOrderType()));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(tpn_mf_label));
            _bw.write(_wl_block111Bytes, _wl_block111);
//if moved from else block for  GHL-ICN-0013
		if((tpn_mf_label && bean.getCriteriaOrderType().equals("TD"))){// if Added for GHL-ICN-0011
		
            _bw.write(_wl_block112Bytes, _wl_block112);

		}
		else if(!bean.getCriteriaOrderType().equals("ALL") && !bean.getCriteriaOrderType().equals("CDR")){  // CDR Condition Added for ML-MMOH-CRF-0435 [IN:057357]//(tpn_mf_label && bean.getCriteriaOrderType().equals("TD") IS REMOVED FOR GHL-ICN-0011
			if(recCount!=0 && disp_level.equals("O")){

            _bw.write(_wl_block113Bytes, _wl_block113);

				}	
				else{	

            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(disp_stage));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(filling_status));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(disp_locn_catg));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(group_by_patient));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(disp_level));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(java.net.URLEncoder.encode(orderIDS_trxRefIDS.toString())));
            _bw.write(_wl_block117Bytes, _wl_block117);
	
				}
			}
			else{
				if(encounter_order_check){ //Modified for NMC-JD-SCF-0251

            _bw.write(_wl_block118Bytes, _wl_block118);

			}else{

            _bw.write(_wl_block119Bytes, _wl_block119);
			
			}	 //Modified for NMC-JD-SCF-0251
			}
			if(bean.getCurrEncFinancialDtl().equals("Y")){ //code added for JD-CRF-0156[IN041737]--Start
				encounter_id = bean.getEncounterID();
				ArrayList encounterId_details	 = bean.getEpisodeDetails(patient_id,encounter_id); 
				if(encounterId_details.size()>0){
					String 	episode_id		 = (String)encounterId_details.get(0);					
					String  patient_class	 = (String)encounterId_details.get(1);	
					String visit_id="";
					boolean policyValid = bean.getPolicyExp(encounter_id,patient_class,patient_id);
					if(patient_class.equals("OP") &&  encounter_id.length()>4)
						visit_id = encounter_id.substring(encounter_id.length()-4, encounter_id.length());

            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(visit_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(policyValid));
            _bw.write(_wl_block121Bytes, _wl_block121);

				}
			}

            _bw.write(_wl_block122Bytes, _wl_block122);

	putObjectInBean(bean_id, bean, request);
	putObjectInBean(bean_id_1, bean_1, request);
          }
          catch(Exception e){
          	e.printStackTrace();
          }
          finally{ // Added for ML-MMOH-SCF-0468 - start
          	
          	if(con != null)
          		ConnectionManager.returnConnection(con,request);	
          } // Added for ML-MMOH-crf-0468 end

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderDate.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderDate.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderID.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderingFacility.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.RxOrder.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.OncologyAdmixture.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.CompoundingOrder.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.TPNStandard.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.TPNAdmixture.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.OncologyOrder.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ProcessOrders.label", java.lang.String .class,"key"));
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
}
