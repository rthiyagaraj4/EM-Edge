package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eCA.*;
import eCA.Common.*;
import eCommon.Common.*;
import java.text.DecimalFormat;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;
import eCommon.Common.*;
import java.util.*;

public final class __medicationordersresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/MedicationOrdersResult.jsp", 1736157589854L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="  \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n \n<html>\n\t<head>\n\t\t<title></title>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'></link>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCA/js/MedicationOrders.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n\t\t<script type=\"text/javascript\">\n\t\t\tfunction initScroll() {\n\t\t\t\tvar rightDivSize = document.body.offsetWidth-371;\n\t\t\t\tvar leftDiv = document.getElementById(\'table_container_left\');\n\t\t\t\tvar rightDiv = document.getElementById(\'table_container_right\');\n\t\t\t\tif(rightDiv!=undefined && leftDiv!=undefined && rightDivSize!=-371){\n\t\t\t\t\trightDiv.style.width=rightDivSize+\'px\';\n\t\t\t\t\trightDiv.onscroll = function() {\n\t\t\t\t\t\tleftDiv.scrollTop = this.scrollTop;\n\t\t\t\t\t\tleftDiv.scrollTop = this.scrollTop;\n\t\t\t\t\t};\n\t\t\t\t}\n\t\t\t}\n\t\t\t\n\t\t\tfunction tableresize()\n\t\t\t{\t\n\t\t\t\tif(document.getElementById(\'table_container_left_1\')){\n\t\t\t\tvar rows = document.getElementById(\'table_container_left_1\').getElementsByTagName(\"tr\").length;\n\t\t\t\tvar tbl = document.getElementById(\'table_container_left_1\').rows;\n\t\t\t\tvar x=document.getElementById(\'table_container_right_1\').rows;\n\t\t\t\tvar rows1 = document.getElementById(\'table_container_right_1\').getElementsByTagName(\"tr\").length;\n\t\t\tfor(var i=0;i<rows;i++){\n\t\t\t\tif(tbl[i].offsetHeight>x[i].offsetHeight){\n\t\t\t\tdocument.getElementById(\"table_container_right_1\").rows[i].style.height =tbl[i].offsetHeight+\"px\" ;\n\t\t\t\t}else\n\t\t\t\tif(tbl[i].offsetHeight<x[i].offsetHeight){\n\t\t\tdocument.getElementById(\"table_container_left_1\").rows[i].style.height =x[i].offsetHeight+\"px\" ;\n\t\t\t}\n\t\t\t} \n\t\t\t}\n\t\t\t}\n\t\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\n\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onLoad=\"initScroll();tableresize();\" onresize=\"initScroll();tableresize();\">\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t<div id=\'table_container_left\' style=\'overflow:hidden;width:360px;height:";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =";position:relative;float:left;\' >   <!-- local:360px and main:225px FOr BSP-SCF-0037 -->\n\t\t\t\t\t<table   border=\"1\" cellpadding=\"0\" cellspacing=\"0\" align=\"left\" id=\'table_container_left_1\'>\n\t\t\t\t\t\t<tr style=\'height:40px;\' style=\'position:relative\' style=\'top:expression(this.offsetParent.scrollTop-2)\'>\n\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' style=\"border:none\">&nbsp;&nbsp;&nbsp;&nbsp;</td>\n\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' nowrap>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>   <!--nowrap Added for IN:063627 --><!--nowrap Added for BSP-SCF-0037 --><!--nowrap Added for BSP-SCF-0042 -->\n\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="          \n\t\t\t\t\t\t\t\t\t\t<tr style=\'height:50px;\' id =\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n\t\t\t\t\t\t\t\t\t\t\t<td  style=\"background-color:#FF9999\" title=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" >&nbsp;&nbsp;</td>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n\t\t\t\t\t\t\t\t\t\t\t<td  style=\"background-color:";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" title=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" ><font class=\"hyperlink\" style=\"cursor:pointer;\" onClick=\"showMedicationDetails(\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\')\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</font>\n\t\t\t\t\t\t\t\t\t\t<label id=\'lblDiscCancelledOrders_";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' style=\'cursor:pointer;";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' title=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>&nbsp;&nbsp;<img id=\'discCancelledOrders_";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' src=\"../../ePH/images/DiscCancelledIndicator.png\" onclick=\'callDiscCancelledOrders(\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\", \"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\");\'  ></label>\n\t\t\t\t\t\t\t\t\t\t<br><label style=\"color:brown\">";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</label></td>\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\"  title=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\"><font color=\'black\'>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</font><label id=\'lblDiscCancelledOrders_";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'  title=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\");\'></label>\n\t\t\t\t\t\t\t\t\t\t\t<br><label style=\"color:green\">";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\"><font color=\'white\'>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\");\'></label>\n\t\t\t\t\t\t\t\t\t\t\t<br><label style=\"color:Green\">";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</label> </td>\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<td width=\"111px\" class=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="&nbsp;</td>\n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t</table>\n\t\t\t\t</div>\n";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t<div id=\'table_container_right\' style=\'overflow:";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =";height:";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =";position:relative;float:right;\' ><!--  Modified for Bru-HIMS-CRF-081 -->\n\t\t\t\t\t<table   border=\"1\" cellpadding=\"0\" cellspacing=\"0\" align=\"left\" id=\'table_container_right_1\' >\n\t\t\t\t\t\t<tr style=\'height:40px;\' style=\'position:relative\' style=\'top:expression(this.offsetParent.scrollTop-2)\'>\n\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' style=\'width:0px;border-right:0\' ></td>\n\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' nowrap style=\'border-left:0\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' nowrap>";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</td>\n\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' nowrap>";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</td>\n\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' nowrap>&nbsp;&nbsp;";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="&nbsp;&nbsp;</td>\n\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' nowrap>&nbsp;&nbsp;";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="&nbsp;&nbsp;</td>\n\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' nowrap>";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</td>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' colspan=2 >\n\t\t\t\t\t\t\t\t<table   border=\"1\" cellpadding=\"0\" cellspacing=\"0\"  >\n\t\t\t\t\t\t\t\t\t<tr style=\'height:14px;\'>\n\t\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' colspan=2 nowrap>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t<tr style=\'height:1px;\'></tr>\n\t\t\t\t\t\t\t\t\t<tr style=\'height:14px;\'>\n\t\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' nowrap width=\'50%\'>&nbsp;";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' nowrap width=\'50%\'>&nbsp;";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="&nbsp;</td>\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' colspan=2 >\n\t\t\t\t\t\t\t\t<table   border=\"1\" cellpadding=\"0\" cellspacing=\"0\" >\n\t\t\t\t\t\t\t\t\t<tr style=\'height:14px;\'>\n\t\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' colspan=2 nowrap>&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="&nbsp;&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' nowrap width=\'50%\'>";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="&nbsp;</td>\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t</td>\n\n\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' nowrap >";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</td>\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<!-- PrescribedQuantity added for mms-kh-crf-0014 -->\n\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' nowrap>";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 =" / ";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t\t\t\t\n<!-- \t\t\t\t\t\t\t<td class=\'COLUMNHEADER\'></td> -->\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\t\t\t\t\t\n\t\t\t\t\t       <td class=\'COLUMNHEADER\' nowrap>";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' nowrap>";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="/ ";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</td>\n";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</td>\n\t\t\t\t\t\t\t<th class=\'COLUMNHEADER\' nowrap>";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="&nbsp;";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="</th>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\t\t\n\t\t\t\t\t\t<tr style=\'height:50px;\'><td style=\'width:0px;border-right:0;\' >&nbsp;</td>\n";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\t\t\t\n\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" style=\"display:none\" title=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="&nbsp;</td>\n\t\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" >";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 =" \n\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="&nbsp;</td> \n \t\t\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 =" \n\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" >&nbsp;</td> \n";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\" style=\'width:0px;border-left:0\' title=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t\t\t\t\t\t\t\t\t<br><label style=\'color:blue;cursor:pointer;\' onclick=\"viewOutsourceDtls(\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\',\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\');\">";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="</label>\n";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\t\n\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\">\n";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t\t\t\t\t\t\t\t\t\t<font >&nbsp;</font>\t\t\t\t\n";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t\t\t\t\t\t\t\t\t\t<font class=\"HYPERLINK\" style=\"cursor:pointer\" onClick=\"showRemarks(\'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\', \'";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\',\'\',\'";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="</font><!-- code \'";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="added for ML-BRU-SCF-0971[IN042220] //Added called_from,encounter_id,ReqDb for MMS-DM-CRF-115.4-->\n";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n\t\t\t\t\t\t\t\t\t</td>\t\n";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\t\n\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="</td>\t\n";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\" id=\"disc_cancel_id\">";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 =" \n\t\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\" width=\"53%\"  align=\"left\" >";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="</td>\n\t\t\t\t\t\t\t\t\t\t\t<!-- //style=\"border-bottom-color:white\">";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="</td>pres_uom -->\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\"  align=\"left\" > ";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="</td><!-- </td> -->\n";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\" align=\"right\" >&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\" align=\"left\" >&nbsp;</td>\n";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\" width=\"52%\" >&nbsp;</td><!-- </td> -->\n\t\t\t\t\t\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\" width=\"52%\" >";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="</td><!-- </td> -->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\" width=\"52%\" >&nbsp;</td><!-- </td> -->\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\" nowrap  >";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\" align=\"right\" >&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\"  align=\"left\" >&nbsp;</td>\n";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\" nowrap align=\"left\" >&nbsp;<font class=\"HYPERLINK\" style=\"cursor:pointer\" onClick=\"showDetails(\'";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\', \'\', \'";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\',\'\',\'\',\'";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\')\"><!--code \',\'";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\'\' added for IN046252  modified parameters fror mms-icn-0115-->\n\t\t\t\t\t\t\t\t\t\t\t<img  src=\'../../ePH/images/altenate.jpg\' height=\'15\' width=\'15\' align=\'top\' title=\'";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 =" ";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\' align=\"center\"></img>\n\t\t\t\t\t\t\t\t\t\t\t</font>\n";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<font class=\"HYPERLINK\" style=\"cursor:pointer\" onClick=\"showAltDrugRemarks(\'";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\n\t\t\t\t\t\t\t\t\t\t\t\t</font>\n";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\" nowrap align=\"left\">&nbsp;<font class=\"HYPERLINK\" style=\"cursor:pointer\" onClick=\"showDetails(\'";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\'\' added for IN046252 modified parameters fror mms-icn-0115-->\n\t\t\t\t\t\t\t\t\t\t\t<img  src=\'../../ePH/images/altenate.jpg\' height=\'15\' width=\'15\' align=\'top\'  title=\'";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\n\t\t\t\t\t\t\t\t\t\t\t<font class=\"HYPERLINK\" style=\"cursor:pointer\" onClick=\"showAltDrugRemarks(\'";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\n\t\t\t\t\t\t\t\t\t\t\t</font>\n";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\n\t\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\n\t                                   <td> <img  src=\'../../ePH/images/altenate.jpg\' height=\'15\' width=\'15\' align=\'top\' title=\'";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\' align=\"center\"></img>\n\t\t\t\t\t\t\t\t\t   </td>\n\t\t\t\t\t\t\t\t\t   <td> <img  src=\'../../ePH/images/altenate.jpg\' height=\'15\' width=\'15\' align=\'top\' title=\'";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\' align=\"center\"></img>\n\t\t\t\t\t\t\t\t\t   </td>\n";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\n\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<!--<td class=\"";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\" nowrap >";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 =" &nbsp;";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="&nbsp;</td>--><!--Commented for ML-BRU-SCF-1394[IN0501010] -->\n";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\',\'return\', \'";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\')\"><img  src=\'../../ePH/images/altenate.jpg\' height=\'15\' width=\'15\' align=\'top\' title=\'";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\' align=\"center\"></img><!--modified parameters fror mms-icn-0115 -->\n\t\t\t\t\t\t\t\t\t</font>\n";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\n\t\t\t\t\t\t\t\t\t\t<font class=\"HYPERLINK\" style=\"cursor:pointer\" onClick=\"showAltDrugRemarks(\'";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\n\t\t\t\t\t\t\t\t\t\t</font>\n";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\" nowrap title=\"";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\">&nbsp;\n\t\t\t\t\t\t\t\t<!---Added Newly in if condition  && (dosage_type.equals(\"A\") || dosage_type.equals(\"Q\"))   for the SKR-SCF-0489 on 18/05/2012 --->\n";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 =" \t\t\t\t\t\t\t\t\t\t\t\t\t<!-- pres_qty and uom added for MMS-KH-CRF-0014-->\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 =" /";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 =" \t\t\t\t\t\t\t\t\t\t\t\t\t<!-- pres_qty and uom added for MMS-KH-CRF-0014-->\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\n\t\t\t\t\t\t\t\t\t\t\t<img src=\"../images/changeddosageindicator.gif\" title=\'";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\' align=\"center\" id=\"chng_dose_ind\"></img>\n";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\n<!--=================Date convesion done for ret_med and Reissuemedication time regnd incident num:26236==By Sandhya==01/FEB/2011================-->\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<!-- <td class=\"";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="&nbsp;</td> -->\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<!--<td class=\"";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\"nowrap>";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="&nbsp;\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\n\t\t\t\t\t\t\t\t\t\t&nbsp;";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="&nbsp;</td>--><!--Commented for ML-BRU-SCF-1394[IN0501010]-->\n";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\t\t\t\t\t\t&nbsp;";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\',\'reissue\', \'";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\' align=\"center\"></img><!---modified parameters fror mms-icn-0115-->\n\t\t\t\t\t\t\t\t\t\t\t</font>\n";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="</font>\n";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\n\t\t\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\" style=\'color:";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 =";background-color:";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\' title=\"";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\" nowrap>\n\t\t\t\t\t\t\t\t\t\t\t<a HREF=\"#\" onMouseOver=\"changeCursor(this);\" onClick=\"showMultipleFlowRate(\'";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\');\" id=\'mfrLink\'>";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="</a></td>\n";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\" nowrap>\n";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\" nowrap>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<div name=\"divSlidingdetail";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\" id=\"divSlidingdetail";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\" style=\"position:absolute; width:100%;display:none;border:1px solid black;\">\n\t\t\t\t\t\t\t\t\t\t\t\t<table id=\"tblSlidingdetail\" border=\"1\"  width=\"100%\" height=\"100%\" align=\"center\" cellpadding=\"1\" cellspacing=\"0\" >\n";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<th style=\"font-size:13; border-bottom:1px solid white;\" colspan=6 > ";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="</th>\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<th align=\"left\" style=\"font-size:9\" nowrap>";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="</th>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<th align=\"left\" style=\"font-size:9\" nowrap>";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="</th>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<th align=\"left\" style=\"font-size:9\" nowrap width=\'150px\' >";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="</th>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td nowrap>";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td nowrap>";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="</td>\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td nowrap>";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td width=\'150px\'>";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="</td>\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<th style=\"font-size:13; border-bottom:1px solid white;\" colspan=6 >No Templates Found</th>\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<label id=\'lblslidingscale\' style=\"color:red;cursor:pointer\" onmouseover=\'dispSlidingDtl(\"";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\");\' onmouseout=\'hideSlidingDtl(\"";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\");\' onClick=\"showSlidingDetails(\'";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="</label> \n";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\n\t\t\t\t\t\t\t\t\t\t<label id=\'lblDosagedtl\' title=\"";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\"> ";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="&nbsp;</label>\n";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\n\t\t\t\t\t\t\t\t\t\t  /";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 =" \n\t\t\t\t\t\t\t\t\t\t\t<br><font class=\"HYPERLINK\" style=\"cursor:pointer\" onClick=\"showDetails(\'";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\', \'\',\'";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\')\"><!--modified parameters fror mms-icn-0115-->\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 =" \n\t\t\t\t\t\t\t\t\t\t\t</font>\n";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));\n\t\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\n\t\t\t\t\t</table> \n\t\t\t\t</div>\n";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\n\t\t\t\t\n";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\n\t\t\t\t<script>\n\t\t\t\t\t//document.f_status_frame.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));\n\t\t\t\t</script>\n";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\n\t</body>\n";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\n</html>\n\n";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );
	
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
--------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------

05/08/2020  IN072762    chandrashekar                                   MO-CRF-20101.11
---------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);
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
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block3Bytes, _wl_block3);
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

            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block7Bytes, _wl_block7);

		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String locale			= (String)session.getAttribute("LOCALE");
		String facility_id					= (String) session.getValue("facility_id");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

		
		String patient_id	= request.getParameter("patient_id") ==null?"":request.getParameter("patient_id");
		String dt_from		= request.getParameter("from_date")==null?"":request.getParameter("from_date");
		String dt_to		= request.getParameter("to_date")==null?"":request.getParameter("to_date");
		String generic_id	= request.getParameter("generic_id")==null?"":request.getParameter("generic_id");
		String drug_code	= request.getParameter("drug_id")==null?"":request.getParameter("drug_id");
		String pat_class	= request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
		String status		= request.getParameter("status")==null?"":request.getParameter("status");
		String encounter_id	    =	request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
		String req_facility_id		=	request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
		String pract_id		=	request.getParameter("pract_id")==null?"":request.getParameter("pract_id");
		String selTab		=	request.getParameter("selTab")==null?"":request.getParameter("selTab");
		String order_type		=	request.getParameter("order_type")==null?"":request.getParameter("order_type");
		String date_order		=	request.getParameter("date_order")==null?"":request.getParameter("date_order");

		if(date_order.equals(""))
		    date_order ="D";
		
		String date_append ="";
		String ret_uom1		=	"";
		String ret_uom2		=	"";
		String reissue_uom1		=	"";
		String reissue_uom2		=	"";
		String heightpx		=	"";
		String scroll		=	"scroll";
		String scroll_id ="";
		String	bean_id			=	"MedicationOrdersBean" ;
		String	bean_name		=	"ePH.MedicationOrdersBean";

		MedicationOrdersBean bean = (MedicationOrdersBean)getBeanObject( bean_id,bean_name, request) ;
		bean.setLanguageId(locale);
		
		HashMap disc_cancel         = new HashMap();
		String discontinued_link_yn = "N";
		String cancel_link_yn       = "N";
		String disc_cancel_style	= "";
		String on_click				= "";
		String pres_disp_unit_value		= "";
		String dispnsd_disp_unit_value	= "";
		String disp_stock_uom			= "";
		String dosage_type				= "";
		String admin_dose_chng_reason_cnt  = "";
		String dosage_uom_desc             = "" ;
		String linkYN                      ="";
		bean.setNoOfDecimals();
		int noOfDecimals = bean.getNoOfDecimals();
		String alt_drug_remarks_ind = bean.getAltDrugRemarksInd();
		 Connection con				= null;
		 con						= ConnectionManager.getConnection(request);
		boolean site = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","TRANSCRIBED_BY");//Added for ML-MMOH-CRF-0510[IN060510] END
		boolean display_transfer_locn= eCommon.Common.CommonBean.isSiteSpecific(con, "PH","PATIENT_TRANSFER_LOCN_UPD");//SKR-SCF-1239
		boolean siteOrder = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","ORDER_LOCATION"); /* Added for ML-MMOH-CRF-0532 [IN061327]  */
		String decimalStringFormat = "#.";
		if(noOfDecimals == 0) 
			decimalStringFormat = "#.#"; 
		for (int i=0;i<noOfDecimals;i++){
			decimalStringFormat = decimalStringFormat+"#";
		}
		int len=0, point=0;
		String temp="";
		DecimalFormat dfToInteger = new DecimalFormat(decimalStringFormat);	

		boolean searched	= request.getParameter( "searched" ) == null ? false : true  ;
		try{
			String classvalue			=	"";
			patient_id	 = CommonBean.checkForNull( patient_id );
			dt_from		 = CommonBean.checkForNull( dt_from);
			dt_to		 = CommonBean.checkForNull( dt_to );
			generic_id	 = CommonBean.checkForNull( generic_id );
			drug_code	 = CommonBean.checkForNull( drug_code );
			pat_class	 = CommonBean.checkForNull( pat_class );
			ArrayList result=bean.getDrugDetails(con,locale,patient_id,encounter_id,pract_id,dt_from,dt_to,selTab,pat_class,req_facility_id,status,drug_code,generic_id,"D",  order_type,date_order,site,display_transfer_locn,siteOrder);
			if(result.size()>0){

				//Retriving the records from result arraylist
				StringBuffer title_buffer	= new StringBuffer();
				ArrayList records	=new ArrayList();
				String ht_wt_title	=	"";

				String order_line_no	=	"";
				String line_iv_prep_yn	=	"";
				String dtls				=	"";
				String discharge_med	=	"";
				String pres_qty			=	"";
				String disp_qty			=	"";
				String ret_qty			=	"";
				String disp_uom			=	"";
				String stock_uom        =   "";
				String ret_uom			=	"";
				String ret_date			=	"";
				String disp_drugs		=	"";
				String tot_admin_qty	=	"";
				String admin_uom		=	"";
				String ret_diff			=	"";
				String line_status		=	"";
				String child_order		=	"";
				String reissue_qty		=	"";
				String classVal			=	"";
				String pres_uom			=	"";
				String patient_class	=	"";
				String reissue_uom		=	"";
				String strength_per_pres_uom = "";
				String content_in_pres_base_uom = "";
				String reissue_date_time = "";
				String line_status_text			= "";
				String strIVPrepYN = "";
				String drug_status = "";
				String order_id    = "";	
				String order_line_num	= "";
				String sr_no			= "";
				String future_yn		=	"";
				String expiry_yn		=	"";
				String formulary_item_yn		=	"";
				String sliding_scale_yn		=	"";
				String alternates		= "N";
				String freq_nature		= "";
				String route_color="";   // Coded Added For CRF 0034
				String pres_base_uom = ""; //Added for ML-BRU-SCF-1190 [IN:045647]
				String home_leave_medn_yn = "";//Added for Bru-HIMS-CRF-093-DD1[IN047223]
				String ref_sent_remarks="";//Added for HSA-CRF-0155 [IN048487]
				String amended_by_id ="";   /* code Added for ML-BRU-SCF-0098 [IN031837] -- Start*/	
				String amend_reason ="";  
				String amend_reason_code ="";  
				String amended_date ="";  	/*code Added for ML-BRU-SCF-0098 [IN031837] -- End*/	
				String disc_cancelled_orders = "", disc_cancelled_orders_display="display:none", last_dispensed_date=""; //Added for HSA-CRF-0138 [IN:048414]

				String strength_value =""; // Added for IN-30262
				String alt_drug_remarks ="", stkey; // Added for Bru-HIMS-CRF-082 [IN:029948]
				String pregnancy_override_reason =""; // Added for RUT-CRF-0063 [IN:029601]
				String complete_reason 		= null;//Added for MMS-SCF-0196
				String allocate_remarks_code="", allocate_finding = "", fill_remarks_code="", fill_finding = "", delivery_remarks_code="", delivery_finding= "", verify_remarks="";//Code added for ML-BRU-SCF-0971[IN042220]
				String dispense_count ="";
				String order_qty="";//Added for ARYU-SCF-0034
				
				    heightpx="380px";
				

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(heightpx));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

						for(int recCount=0; recCount<result.size(); recCount++) {
							strIVPrepYN		=	"";       
							drug_status		=	"";       
							order_id		=	"";	   
							order_line_num	=	"";  
							sr_no			=	"";  
							future_yn		=	"";
							expiry_yn		=	"";
							//freq_nature		=	"";
							ht_wt_title		=	"";
							if ( recCount % 2 == 0 )
								classvalue = "QRYODD" ;
							else
								classvalue = "QRYEVEN" ;

							records=(ArrayList) result.get( recCount );
							for(int colCount=0; colCount<records.size(); colCount++){
								title_buffer	= new StringBuffer();
								if(records.get(19)!=null) {
									title_buffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.height.label","common_labels"));
									title_buffer.append(":");
									title_buffer.append(CommonBean.checkForNull((String)records.get(19)));
									title_buffer.append("; ");
									title_buffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.weight.label","common_labels"));
									title_buffer.append(":");
									title_buffer.append(CommonBean.checkForNull((String)records.get(21)));
									title_buffer.append("; ");
									title_buffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BSA.label","common_labels"));
									title_buffer.append(":");
									title_buffer.append(CommonBean.checkForNull((String)records.get(23)));
									title_buffer.append("; ");
									title_buffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BMI.label","common_labels"));
									title_buffer.append(":");
									title_buffer.append(CommonBean.checkForNull((String)records.get(38)));
								}	
								// Added Newly for the KAUH-SCF-049[Inc:33575] Start
								pres_qty		= CommonBean.checkForNull((String)records.get(27));
								if(pres_qty!=null && !pres_qty.equals(""))
									pres_qty = dfToInteger.format(Double.parseDouble(pres_qty));
								disp_qty		= CommonBean.checkForNull((String)records.get(28));
								if(disp_qty!=null && !disp_qty.equals(""))
									disp_qty = dfToInteger.format(Double.parseDouble(disp_qty));
								ret_qty			= CommonBean.checkForNull((String)records.get(29));
								if(ret_qty!=null && !ret_qty.equals(""))
									ret_qty = dfToInteger.format(Double.parseDouble(ret_qty));

								ret_date		= CommonBean.checkForNull((String)records.get(30));
								line_status				= CommonBean.checkForNull((String)records.get(35));
								disp_drugs				= CommonBean.checkForNull((String)records.get(32));
								/*if(!ret_date.equals("") && ret_qty.equals(pres_qty)){
									line_status_text = "Return-Medication";
								}
								else{*/
								line_status_text = CommonBean.checkForNull((String)records.get(44));
								//}
								//Added Newly for the KAUH-SCF-049[Inc:33575] End
								formulary_item_yn		= CommonBean.checkForNull((String)records.get(45));
								child_order				= CommonBean.checkForNull((String)records.get(36));
								discharge_med			= CommonBean.checkForNull((String)records.get(25));
								route_color				= CommonBean.checkForNull((String)records.get(58));//Code added for CRF 0034
								
								amended_by_id			= CommonBean.checkForNull((String)records.get(59));/*below code Added for ML-BRU-SCF-0098 [IN031837] -- Start*/
								amend_reason			= CommonBean.checkForNull((String)records.get(60));
								amend_reason_code		= CommonBean.checkForNull((String)records.get(61));
								amended_date			= CommonBean.checkForNull((String)records.get(62));/*Above code Added for ML-BRU-SCF-0098 [IN031837] -- End*/
							   							   						   
							   	complete_reason 		= CommonBean.checkForNull((String)records.get(50));//Added for MMS-SCF-0196
							   	home_leave_medn_yn = CommonBean.checkForNull((String)records.get(74));//Added for Bru-HIMS-CRF-093-DD1[IN047223]
							   	disc_cancelled_orders = CommonBean.checkForNull((String)records.get(76));//Added for HSA-CRF-0138 [IN:048414] - start
							   	last_dispensed_date = CommonBean.checkForNull((String)records.get(77));//Added for HSA-CRF-0138 [IN:048414] - start
								scroll_id =CommonBean.checkForNull((String)records.get(9));
								if(!disc_cancelled_orders.equals("") && last_dispensed_date.equals(""))
									disc_cancelled_orders_display="display";
								else
									disc_cancelled_orders_display="display:none";
								if (colCount>18)
									continue;
								if (colCount ==0 || colCount==1){
									strIVPrepYN =(String)records.get( 0 );
									if (colCount==0){						
										continue;
									}
									else{
										if (strIVPrepYN.equals("N")){
											linkYN = "N";
										}
										else if (strIVPrepYN.equals("Y")&&(records.get( 1 ) != null)){
											linkYN = "Y";
										}
									}
								}
								else if (colCount == 3){
									drug_status = "";
									disc_cancel = bean.isCancelDiscontinuedApplicable((String)records.get( 15 ),(String)records.get( 16 ));	
									cancel_link_yn       = (String)disc_cancel.get("CANCEL");
									future_yn	=	bean.compareDate((String)records.get(9));
									expiry_yn	=	bean.compareDate((String)records.get(10));
									patient_class	= CommonBean.checkForNull((String)records.get(11));
									disp_qty		= CommonBean.checkForNull((String)records.get(28));
									if(!ret_qty.equals("") ){
										if (line_status.equals("DC"))
											drug_status = "#C40062";
										//else if(expiry_yn.equals("N"))
										//	drug_status = "#FFB66C";
										else
											drug_status = "#FFB66C";
											//DD AND DE added for mms-kh-crf-0014
										if((status.equals("A") || status.equals("*A")) && (line_status.equals("DP") || line_status.equals("DF") || line_status.equals("DD") || line_status.equals("DE")) && (future_yn.equals("N")) && !expiry_yn.equals("N")){
											classVal	= "ACTIVE";
										}
										else{
											if(future_yn.equals("Y")) 
												classVal	= "FUTURE_Rx";
											else if(expiry_yn.equals("N")){
												classVal	= "EXPIRED_MEDICATION";
											}
											else if (line_status.equals("CN"))
												classVal	= "CANCEL";
											else if (line_status.equals("DC"))
												classVal	= "DIS-CONTINUED";
											else if(discharge_med.equals("D"))
												classVal="DISCHARGEMED1";
											else if (line_status.equals("HD") || line_status.equals("HC"))
												classVal	= "HOLD";
											else
												classVal	= "ACTIVE";
												//classVal	= "ReturnedMedication";	
										}
									}
									else if (line_status.equals("CN")){
										drug_status = "#990000";
										if(expiry_yn.equals("N"))
											classVal	= "EXPIRED_MEDICATION";
										else
											classVal	= "CANCEL";
									}
									else if (line_status.equals("DC")){
										drug_status = "#C40062";
										if(expiry_yn.equals("N"))
											classVal	= "EXPIRED_MEDICATION";
										else
											classVal	= "DIS-CONTINUED";
									}
									//DD AND DE added for mms-kh-crf-0014
									else if( ((((String)records.get( colCount )).trim()).equals("ACTIVE")) || ((patient_class.equals("IP") || patient_class.equals("DC")) && (line_status.equals("OS") || line_status.equals("RG") || line_status.equals("IP") || line_status.equals("VF")) ) || ((patient_class.equals("OP") || patient_class.equals("EM")) && (line_status.equals("OS") || line_status.equals("RG") || line_status.equals("IP") || line_status.equals("VF") || line_status.equals("DP") || line_status.equals("DF")|| line_status.equals("DD") || line_status.equals("DE")) )){
										//(line_status.equals("DP") || line_status.equals("DF") )

										if(future_yn.equals("Y")) { 
											drug_status = "#99FFCC";
											classVal	= "FUTURE_Rx";
										}
										else{
											drug_status = "#FF5E5E";
											if(expiry_yn.equals("N")){
												drug_status = "#D9B86C";
												classVal	= "EXPIRED_MEDICATION";
											}
											else {
												if(discharge_med.equals("D")){
													drug_status = "#FF9DFF"; // #D9B86C changed to #FF9DFF for ML-BRU-SCF-0941.1 [IN:045176]
													classVal="DISCHARGEMED1";
												}
												else 
													classVal	= "ACTIVE";
											}
											// for outpatient active orders, who are not yet dispensed.
											if((patient_class.equals("OP") || patient_class.equals("EM")) && disp_qty.equals("") && complete_reason.equals("")){
												drug_status = "#8204FF";
											}
										}
									}
									else if(child_order.equals("Y")){
										drug_status = "#B6BC8B";
										if(future_yn.equals("Y")) 
											classVal	= "FUTURE_Rx";
										else
											classVal	= "Refill_Rx";
									}
									else if(future_yn.equals("Y")) { 
										drug_status = "#99FFCC";
										classVal	= "FUTURE_Rx";						
									}
									else if(cancel_link_yn.equals("Y") || (line_status.equals("IP") || line_status.equals("PO") || line_status.equals("PS") || line_status.equals("AL") || line_status.equals("VF")) || (disp_qty.equals("") && !tot_admin_qty.equals("") && complete_reason.equals("")) )  {
										drug_status = "#8204FF";
										if(expiry_yn.equals("N"))
											classVal	= "EXPIRED_MEDICATION";
										else
											classVal	= "YET_TO_BE_DISPENSED";
									}
									else if (line_status.equals("HD") || line_status.equals("HC")){
										if(expiry_yn.equals("N"))
											drug_status = "#D9B86C";
										else
											drug_status = "#F0F000";
										classVal	= "HOLD";
									}
									else if ((((String)records.get( colCount )).trim()).equals("INACTIVE")&&line_status.equals("DF")){
										classVal	= "ACTIVE";
										drug_status = "#FF5E5E";
										//Added Code for Checking Expired Drugs  on 5/Oct/2010 For the incident num:24069 ---By Sandhya
										if(expiry_yn.equals("N")){
											drug_status = "#D9B86C";
											classVal	= "EXPIRED_MEDICATION";
										} //Ends
									}
									else if(expiry_yn.equals("N")){
										drug_status = "#D9B86C";										
										classVal	= "EXPIRED_MEDICATION";
									}
									else {
										drug_status = "";
										classVal	= classvalue;
									}

									if(line_status.equals("PO") || line_status.equals("PS")){
										title_buffer.append(" / ");
										title_buffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.PndngFrAppr.label","ph_labels"));
									}
									ht_wt_title = title_buffer.toString();
									if(line_iv_prep_yn.equals("1") || line_iv_prep_yn.equals("2") || line_iv_prep_yn.equals("3") || line_iv_prep_yn.equals("4") || line_iv_prep_yn.equals("5")){
										if(order_line_no.equals("1"))
											drug_status="#478F8F";
										else
											drug_status="#92C9C9";
									}

									if((status.equals("C") || status.equals("*A")) && ((patient_class.equals("OP") || patient_class.equals("EM")) && (line_status.equals("DP") || line_status.equals("DF") ||line_status.equals("DD")|| line_status.equals("DE")) ) && expiry_yn.equals("N")){
										if(ret_qty.equals("") )
											drug_status="#D9B86C";
										classVal	= "EXPIRED_MEDICATION";
									}

									if(status.equals("C") && ((patient_class.equals("OP") || patient_class.equals("EM")) && line_status.equals("OS") ) && child_order.equals("Y") && ret_qty.equals("")){
										drug_status="#D9B86C";
									}

									if(line_status.equals("PO"))
										drug_status="#0099FF";
									else if(line_status.equals("PC"))
										drug_status="#33CC99";
									else if(line_status.equals("PS"))
										drug_status="#C48400";
									if(home_leave_medn_yn.equalsIgnoreCase("Y"))//Added for Bru-HIMS-CRF-093-DD1[IN047223]
										drug_status = "#959500";
									if(formulary_item_yn.equals("N")){

            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(scroll_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(ht_wt_title));
            _bw.write(_wl_block16Bytes, _wl_block16);

									}
									else{

            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(scroll_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(drug_status));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(ht_wt_title));
            _bw.write(_wl_block16Bytes, _wl_block16);

									}
								}
								if(line_status.equals("PO") || line_status.equals("PS")){
									title_buffer.append(" / ");
									title_buffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.PndngFrAppr.label","ph_labels"));
								}
								ht_wt_title = title_buffer.toString();
								if (colCount==5){
									if(linkYN.equals("Y")){
										order_id=(String)records.get( 15 );

            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(classVal));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(ht_wt_title));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf((String)records.get( colCount )));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(disc_cancelled_orders_display));
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(disc_cancelled_orders));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(java.net.URLEncoder.encode((String)records.get( colCount ),"UTF-8")));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(disp_drugs));
            _bw.write(_wl_block29Bytes, _wl_block29);
 
									}
									else{
										if (classVal.equals("FUTURE_Rx")|| classVal.equals("EXPIRED_MEDICATION")|| classVal.equals("HOLD") || classVal.equals("DISCHARGEMED1") || drug_status.equals("")||line_status.equals("PC") || drug_status.equals("#959500")){ // drug_status.equals("#959500") Added for ML-BRU-SCF-1877 

            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(classVal));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(ht_wt_title));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf((String)records.get( colCount )));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(disc_cancelled_orders_display));
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(disc_cancelled_orders));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(java.net.URLEncoder.encode((String)records.get( colCount ),"UTF-8")));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(disp_drugs));
            _bw.write(_wl_block29Bytes, _wl_block29);

										}
										else { 

            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(classVal));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(ht_wt_title));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf((String)records.get( colCount )));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(disc_cancelled_orders_display));
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(disc_cancelled_orders));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(java.net.URLEncoder.encode((String)records.get( colCount ),"UTF-8")));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(disp_drugs));
            _bw.write(_wl_block38Bytes, _wl_block38);
 
										}
									}
								}
								title_buffer	= null;
								if (colCount==18){ ////added 18 for AAKH-CRF-0088 [IN:060357]  
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(ht_wt_title));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf((String)records.get( 79 )));
            _bw.write(_wl_block41Bytes, _wl_block41);
								}
							}
							

            _bw.write(_wl_block42Bytes, _wl_block42);

						}

            _bw.write(_wl_block43Bytes, _wl_block43);

				
				
				    heightpx="400px";
				

            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(scroll));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(heightpx));
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);
 //Added for ml-mmoh-crf-0510 start  [IN060510]
							if(site){
								
            _bw.write(_wl_block61Bytes, _wl_block61);
	} else{
								
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);
	} ////Added for ml-mmoh-crf-0510 end  [IN060510] 
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);
            _bw.write(_wl_block67Bytes, _wl_block67);
// Added for ml-mmoh-crf-0510 start  [IN060510]
							if(site){
								
								 
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);
	} // Added for ml-mmoh-crf-0510 end [IN060510] 
            _bw.write(_wl_block71Bytes, _wl_block71);

						String backgrndColor=""; 
						String fntColor="";
						StringTokenizer st = null;
						for(int recCount=0; recCount<result.size(); recCount++){
							strIVPrepYN				= "";       
							drug_status				= "";       
							order_id				= "";	   
							order_line_num			= "";  
							sr_no					= "";  
							future_yn				= "";
							expiry_yn				= "";
							pres_disp_unit_value	= "";
							dispnsd_disp_unit_value	= "";
							disp_stock_uom			= "";
							alternates				= "N";
							freq_nature				= "";
							dosage_uom_desc         = "";
							fntColor = "";
							backgrndColor = "";

							if ( recCount % 2 == 0 )
								classvalue = "QRYODD" ;
							else
								classvalue = "QRYEVEN" ;

							records=(ArrayList) result.get( recCount );

							ht_wt_title		= "";
							title_buffer	= new StringBuffer(); 
							if(records.get(19)!=null) {
								title_buffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.height.label","common_labels"));
								title_buffer.append(":");
								title_buffer.append(CommonBean.checkForNull((String)records.get(19)));
								title_buffer.append("; ");
								title_buffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.weight.label","common_labels"));
								title_buffer.append(":");
								title_buffer.append(CommonBean.checkForNull((String)records.get(21)));
								title_buffer.append("; ");
								title_buffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BSA.label","common_labels"));
								title_buffer.append(":");
								title_buffer.append(CommonBean.checkForNull((String)records.get(23)));
								title_buffer.append("; ");
								title_buffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BMI.label","common_labels"));
								title_buffer.append(":");
								title_buffer.append(CommonBean.checkForNull((String)records.get(38)));
							}	
		
							line_iv_prep_yn	= CommonBean.checkForNull((String)records.get(24));
							order_line_no	= CommonBean.checkForNull((String)records.get(16));
							discharge_med	= CommonBean.checkForNull((String)records.get(25));
							
							pres_qty		= CommonBean.checkForNull((String)records.get(27));
							disp_qty		= CommonBean.checkForNull((String)records.get(28));
							
							if(disp_qty!=null && !disp_qty.equals(""))
								disp_qty = dfToInteger.format(Double.parseDouble(disp_qty));
								
							ret_qty			= CommonBean.checkForNull((String)records.get(29));
							if(ret_qty!=null && !ret_qty.equals(""))
								ret_qty = dfToInteger.format(Double.parseDouble(ret_qty));

							ret_date		= CommonBean.checkForNull((String)records.get(30));
							stock_uom       = CommonBean.checkForNull((String)records.get(31));
							disp_drugs		= CommonBean.checkForNull((String)records.get(32));
							tot_admin_qty	= CommonBean.checkForNull((String)records.get(33));
							ret_diff		= CommonBean.checkForNull((String)records.get(34));
							line_status		= CommonBean.checkForNull((String)records.get(35));
							child_order		= CommonBean.checkForNull((String)records.get(36));
							admin_uom		= CommonBean.checkForNull((String)records.get(37));//DOSAGE_UOM_CODE
							reissue_qty	    = CommonBean.checkForNull((String)records.get(39));
							pres_uom		= CommonBean.checkForNull((String)records.get(40));//PRESCRIBED_UOM
							patient_class	= CommonBean.checkForNull((String)records.get(11));
							strength_per_pres_uom = CommonBean.checkForNull((String)records.get(41));
							content_in_pres_base_uom = CommonBean.checkForNull((String)records.get(42));
							reissue_date_time = CommonBean.checkForNull((String)records.get(43));
							// Added Newly for the KAUH-SCF-049[Inc:33575] Start
							/*if(!ret_date.equals("") && ret_qty.equals(pres_qty)){
								line_status_text = "Return-Medication";
							}
							else{*/
							line_status_text = CommonBean.checkForNull((String)records.get(44));
							//}
							//Added Newly for the KAUH-SCF-049[Inc:33575] End
							order_id		 = CommonBean.checkForNull((String)records.get( 15 ));
							freq_nature		= CommonBean.checkForNull((String)records.get(51));
							dosage_type		= CommonBean.checkForNull((String)records.get(52));
							admin_dose_chng_reason_cnt = CommonBean.checkForNull((String)records.get(53));
							dosage_uom_desc  = CommonBean.checkForNull((String)records.get(54));
							route_color = CommonBean.checkForNull((String)records.get(58));// Code Added CRF -0034 Start
							if(route_color!= null && !route_color.equals("")){
								if(route_color.length()==12){
									fntColor= route_color.substring(0, 6);
									backgrndColor= route_color.substring(6, 12);
								}
							}
                           //Code Added  CRF -0034 End
						   /*below code Added for ML-BRU-SCF-0098 [IN031837] -- Start*/
							amended_by_id		= CommonBean.checkForNull((String)records.get(59));						  
							amend_reason			= CommonBean.checkForNull((String)records.get(60));
							amend_reason_code	= CommonBean.checkForNull((String)records.get(61));
							amended_date			= CommonBean.checkForNull((String)records.get(62));
							/*Above code Added for ML-BRU-SCF-0098 [IN031837] -- End*/
							strength_value		= CommonBean.checkForNull((String)records.get(63));// Added for IN-30262
							alt_drug_remarks		= CommonBean.checkForNull((String)records.get(64));// Added for IN-30262
							pregnancy_override_reason		= CommonBean.checkForNull((String)records.get(65));// Added for RUT-CRF-0063 [IN:029601]
							allocate_remarks_code 	= CommonBean.checkForNull((String)records.get(66));//code added for ML-BRU-SCF-0971[IN042220]--Start
							allocate_finding 	= CommonBean.checkForNull((String)records.get(67));
							fill_remarks_code 		= CommonBean.checkForNull((String)records.get(68));
							fill_finding 		= CommonBean.checkForNull((String)records.get(69));
							delivery_remarks_code 	= CommonBean.checkForNull((String)records.get(70));
							delivery_finding 	= CommonBean.checkForNull((String)records.get(71));
							pres_base_uom 	= CommonBean.checkForNull((String)records.get(73)); //Added for ML-BRU-SCF-1190 [IN:045647]
							ref_sent_remarks = CommonBean.checkForNull((String)records.get(75));//Added for HSA-CRF-0155 [IN048487] 
							verify_remarks = CommonBean.checkForNull((String)records.get(78));//Added for ML-MMOH-SCF-0327 [IN:058772] 
							order_qty      = CommonBean.checkForNull((String)records.get(82));//Added for ARYU-SCF-0034
							if(!allocate_finding.equals("")){
								allocate_finding=allocate_finding.replaceAll(" ","%20");
								allocate_finding=	java.net.URLEncoder.encode(allocate_finding,"UTF-8");
								allocate_finding=allocate_finding.replaceAll("%2520","%20");
							}
							if(!fill_finding.equals("")){
								fill_finding=fill_finding.replaceAll(" ","%20");
								fill_finding=	java.net.URLEncoder.encode(fill_finding,"UTF-8");
								fill_finding=fill_finding.replaceAll("%2520","%20");
							}				
							if(!delivery_finding.equals("")){
								delivery_finding=delivery_finding.replaceAll(" ","%20");
								delivery_finding=	java.net.URLEncoder.encode(delivery_finding,"UTF-8");
								delivery_finding=delivery_finding.replaceAll("%2520","%20");
							}// code added for ML-BRU-SCF-0971[IN042220]--End	
							if(line_iv_prep_yn.equals("0") || line_iv_prep_yn.equals("9")){
								//content_in_pres_base_uom = bean.getPackSizeFluid(order_id);
							}

							disp_uom		=	pres_uom;
							ret_uom			=	stock_uom+"  - ";
							//admin_uom		=	pres_uom;
							reissue_uom		=	stock_uom+"  - ";
                            sliding_scale_yn        =(String)records.get(46)==null?"N":(String)records.get(46);
							
                            if(((String)records.get(46)).equals("Y")){
								tot_admin_qty = CommonBean.checkForNull((String)records.get(47));//sliding_scale_adm_unit
								admin_uom     = CommonBean.checkForNull((String)records.get(48));//sliding_scale_adm_uom
							}
							alternates		= CommonBean.checkForNull((String)records.get(49));//alternates

							if(alternates.equals("Y")){
								disp_qty		= "";
								dispnsd_disp_unit_value = "";
								disp_uom		=  "";
								disp_stock_uom	=  "";
							}

							if(disp_qty.equals("")) {
								disp_uom		=  "";
								disp_stock_uom	=  "";
							}

							if(line_status.equals("IP") && disp_qty.equals("")) 
								disp_qty	="";

							if((ret_qty.trim()).equals("")){ //trim() added for KAUH-SCF-013 [IN:032157]
								ret_uom	=	"";
							}
							else{		
								st =new StringTokenizer(ret_uom, " ");
								while (st.hasMoreTokens()){
									ret_uom1 = st.nextToken();
									ret_uom2 = st.nextToken();
								}
								ret_uom= bean.getUomDisplay(facility_id,ret_uom1)+"  - ";
							}
							if(line_iv_prep_yn.equals("6"))
								admin_uom= (String)records.get( 54 );
							
							if(tot_admin_qty.equals("")) {
								admin_uom	=	"";
							}
							else{
								if(Float.parseFloat(tot_admin_qty)<1 && Float.parseFloat(tot_admin_qty)>0)
									tot_admin_qty="0"+tot_admin_qty;
							}
							if(!disp_drugs.equals("")) 
								disp_drugs	=	" / "+disp_drugs;

							if((reissue_qty.trim()).equals("")){ //trim() added for KAUH-SCF-013 [IN:032157]
								reissue_uom	=	"";
							}
							else{	//ADDED for 26236-reopen==Else condition	
								st =new StringTokenizer(reissue_uom, " ");
								while (st.hasMoreTokens()){
								reissue_uom1 = st.nextToken();
								reissue_uom2 = st.nextToken();
							}
							reissue_uom= bean.getUomDisplay(facility_id,reissue_uom1)+"  - ";
						}
						if(ret_diff.equals("")) 
							ret_diff	=	"0";
						
						if(line_iv_prep_yn.equals("N") || line_iv_prep_yn.equals("I")){
							if(order_line_no.equals("1"))
								classVal="IVFLUID";
							else
								classVal="IVINGREDIENT";
						}
						else if(discharge_med.equals("D")){
							classVal="DISCHARGEMED1";
						}

            _bw.write(_wl_block72Bytes, _wl_block72);

							for(int colCount=0; colCount<records.size(); colCount++){

								/*	 0	--->    IV_PREP_YN
									 1	--->	INFUSE_OVER
									 2	--->	TRN_TYPE_IND (To decide whether it is direct dispensing or via prescription)
									 3	--->	STATUS	(To decide whether the drug is cancelled,hold,discontinued or active)
									 4	--->	Drug Code
									 6	--->	Route Code
									 11	--->	Remarks	*/

								order_id=(String)records.get( 15 );
								order_line_num=(String)records.get( 16 );
								sr_no         =(String)records.get( 17 );

								//if (colCount>18)//changed to 18 for AAKH-CRF-0088 [IN:060357]  
									//continue;
									//added ADDED_BY_ID  for ml-mmoh-crf-0510 [IN060510] start
									if(site){
										if (colCount>19)
											continue;
									}
									else{
										if (colCount>17)
											continue;

									}
								//added ADDED_BY_ID  for ml-mmoh-crf-0510 [IN060510] end
								if (colCount ==0 || colCount==1){
									strIVPrepYN =(String)records.get( 0 );
									if (colCount==0){						
										continue;
									}
									else{
										if (strIVPrepYN.equals("N")){
											linkYN = "N";
										}
										else if (strIVPrepYN.equals("Y")&&(records.get( 1 ) != null)){
											linkYN = "Y";
										}
									}
								}
								else if (colCount==2 ){
								}
								else if (colCount == 3) {

									drug_status = "";
									disc_cancel = bean.isCancelDiscontinuedApplicable((String)records.get( 15 ),(String)records.get( 16 ));	
									cancel_link_yn       = (String)disc_cancel.get("CANCEL");
									future_yn	=	bean.compareDate((String)records.get(9));
									expiry_yn	=	bean.compareDate((String)records.get(10));

									if(!ret_qty.equals("") ){
										if (line_status.equals("DC"))
											drug_status = "#C40062";
										//else if(expiry_yn.equals("N"))
										//	drug_status = "#FFB66C";
										else
											drug_status = "#FFB66C";
										if((status.equals("A") || status.equals("*A")) && (line_status.equals("DP") || line_status.equals("DF")|| line_status.equals("DD")|| line_status.equals("DE")) && (future_yn.equals("N")) && !expiry_yn.equals("N")){	//DD AND DD added for mms-kh-crf-0014
											classVal	= "ACTIVE";
										}
										else{
											if(future_yn.equals("Y")) 
												classVal	= "FUTURE_Rx";
											else if(expiry_yn.equals("N"))
												classVal	= "EXPIRED_MEDICATION";
											else if (line_status.equals("CN"))
												classVal	= "CANCEL";
											else if (line_status.equals("DC"))
												classVal	= "DIS-CONTINUED";
											else if(discharge_med.equals("D"))
												classVal="DISCHARGEMED1";
											else if (line_status.equals("HD") || line_status.equals("HC"))
												classVal	= "HOLD";
											else
												classVal	= "ACTIVE";
												//classVal	= "ReturnedMedication";	
										}
									}
									else if (line_status.equals("CN")){
										drug_status = "#990000";
										if(expiry_yn.equals("N"))
											classVal	= "EXPIRED_MEDICATION";
										else
											classVal	= "CANCEL";
									}
									else if (line_status.equals("DC")){
										drug_status = "#C40062";
										if(expiry_yn.equals("N"))
											classVal	= "EXPIRED_MEDICATION";
										else
											classVal	= "DIS-CONTINUED";
									}
									else if( ((((String)records.get( colCount )).trim()).equals("ACTIVE")) || ((patient_class.equals("IP") || patient_class.equals("DC")) && (line_status.equals("OS") || line_status.equals("RG") || line_status.equals("IP") || line_status.equals("VF")) ) || ((patient_class.equals("OP") || patient_class.equals("EM")) && (line_status.equals("DP") || line_status.equals("DF") ) )){
										if(future_yn.equals("Y")) { 
											drug_status = "#99FFCC";
											classVal	= "FUTURE_Rx";
										}
										else{
											drug_status = "#FF5E5E";
											if(expiry_yn.equals("N")){
												classVal	= "EXPIRED_MEDICATION";
												drug_status = "#D9B86C";
											}
											else 
												classVal	= "ACTIVE";
										}
									}
									else if(child_order.equals("Y")){
										drug_status = "#B6BC8B";
										if(future_yn.equals("Y")) 
											classVal	= "FUTURE_Rx";
										else
											classVal	= "Refill_Rx";
									}
									else if(future_yn.equals("Y")) { 
										drug_status = "#99FFCC";
										classVal	= "FUTURE_Rx";						
									}
									else if(cancel_link_yn.equals("Y") || (line_status.equals("IP") || line_status.equals("PO") || line_status.equals("PS") || line_status.equals("AL") || line_status.equals("VF")) || (disp_qty.equals("") && !tot_admin_qty.equals("") && complete_reason.equals(""))){
										drug_status = "#8204FF";
										if(expiry_yn.equals("N"))
											classVal	= "EXPIRED_MEDICATION";
										else
											classVal	= "YET_TO_BE_DISPENSED";
									}
									else if (line_status.equals("HD") || line_status.equals("HC")){
										if(expiry_yn.equals("N"))
											drug_status = "#D9B86C";
										else
											drug_status = "#F0F000";
										classVal	= "HOLD";
									
									} 
									else if(expiry_yn.equals("N")){
										drug_status = "#D9B86C";
										classVal	= "EXPIRED_MEDICATION";
									}
									else {
										drug_status = "";
										classVal	= classvalue;
									}
									/* if(expiry_yn.equals("N")){
										drug_status = "#D9B86C";
										classVal	= "EXPIRED_MEDICATION";
									}*/
									if(line_status.equals("PO") || line_status.equals("PS")){
										title_buffer.append(" / ");
										title_buffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.PndngFrAppr.label","ph_labels"));
									}
									ht_wt_title = title_buffer.toString();
								}
								
								else if (colCount==4 || colCount==6 || colCount==15 || colCount==16 || colCount==17){	
								
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(ht_wt_title));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf((String)records.get( colCount )));
            _bw.write(_wl_block75Bytes, _wl_block75);
								}
						     //Added for ML-MMOH-CRF-0510[IN060510] START
								else if (colCount==18){ //added 18 for AAKH-CRF-0088 [IN:060357] 
									
										if(((String)records.get( 80 )) != null){

            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf((String)records.get( 80 )));
            _bw.write(_wl_block41Bytes, _wl_block41);
								}else{

            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf((String)records.get( 12 )));
            _bw.write(_wl_block79Bytes, _wl_block79);
									}
 									}
                              else if (colCount==19){ //added 18 for AAKH-CRF-0088 [IN:060357] 
									
										if(((String)records.get( 81 )) != null){
										 
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf((String)records.get( 81 )));
            _bw.write(_wl_block41Bytes, _wl_block41);
 								}else if(((String)records.get( 80 )) != null && ((String)records.get( 81 )) == null){ 

            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf((String)records.get( 12 )));
            _bw.write(_wl_block79Bytes, _wl_block79);
								}else{

            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block81Bytes, _wl_block81);
									}
 									}//Added for ML-MMOH-CRF-0510[IN060510] END							}


								else if(colCount==9||colCount==10){

									String date	=	com.ehis.util.DateUtils.convertDate((String)records.get(colCount),"DMYHM","en",locale);
									out.print("<td style='background-color:#FFFFFF'class='"+classvalue+" '>"); 
									out.print(date+"&nbsp;"); 
									out.print("</td>");
								}
								else if (colCount==5){

            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(ht_wt_title));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(line_status_text));
            _bw.write(_wl_block1Bytes, _wl_block1);

									if(line_status.equals("IS")){ //if block added for Bru-HIMS-CRF-087 [IN:029953]

            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block85Bytes, _wl_block85);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block86Bytes, _wl_block86);

									}

            _bw.write(_wl_block87Bytes, _wl_block87);

								}
								else if (colCount==11 ){

            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(ht_wt_title));
            _bw.write(_wl_block89Bytes, _wl_block89);

									if ( !(((String)records.get(3)).trim()).equals("CANCEL") && !(((String)records.get(3)).trim()).equals("HOLD") && ((String)records.get( 18 )).equals("0") && ((String)records.get( 26 ))==null && ret_date.equals("") && ((String)records.get( 50 ))==null && (((String)records.get(57))==null || ((String)records.get(57)).equals("")) && (ret_qty==null || ret_qty.equals("")) && (amended_by_id == null || amended_by_id.equals(""))  && (amend_reason==null || amend_reason.equals("")) && (amend_reason_code==null || amend_reason_code.equals("")) && pregnancy_override_reason.equals("")&& allocate_finding.equals("") && fill_finding.equals("")&& delivery_finding.equals("") && ref_sent_remarks.equals("") ) { // added  || (ret_qty==null || ret_qty.equals("") ML-BRU-SCF-0037[030949]  and  amended_by_id, amend_reason added for ML-BRU-SCF-0098 [IN031837]  rtn_qty condition replaced with && code allocate_finding.equals("") && fill_finding.equals("")&& delivery_finding.equals("") added for ML-BRU-SCF-0971[IN042220]

            _bw.write(_wl_block90Bytes, _wl_block90);
	
									}
									else{
										//Display remarks hyper link for orders with Cancelled/Held/Remarks enterd/LAST_ACTION_REASON_DESC/COMPLETED/PRN_REMARKS 

            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(sr_no));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(line_status));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf((String)records.get(56)));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(sliding_scale_yn));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(amended_by_id));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(amended_date));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf( java.net.URLDecoder.decode(amend_reason,"UTF-8")));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(amend_reason_code));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(allocate_finding));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(fill_finding));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(delivery_finding));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(allocate_remarks_code));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(fill_remarks_code));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(delivery_remarks_code));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(java.net.URLEncoder.encode(ref_sent_remarks,"UTF-8")));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(java.net.URLEncoder.encode(verify_remarks,"UTF-8")));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(patient_id ));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(allocate_finding));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(fill_finding));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(delivery_finding));
            _bw.write(_wl_block95Bytes, _wl_block95);
	
									}

            _bw.write(_wl_block96Bytes, _wl_block96);
 
									if((discharge_med.equals("D"))){ // if else condition added for ML-MMOH-SCF-0328 [IN058775]

            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(ht_wt_title));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf("OP"));
            _bw.write(_wl_block98Bytes, _wl_block98);

									}
									else { 

            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(ht_wt_title));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf((String)records.get( colCount )));
            _bw.write(_wl_block66Bytes, _wl_block66);
 
									}
								}
								else if(colCount==10){

									dtls = CommonBean.checkForNull((String)records.get( colCount ));
									disc_cancel = bean.isCancelDiscontinuedApplicable((String)records.get( 15 ),(String)records.get( 16 ));	
									
									discontinued_link_yn = (String)disc_cancel.get("DISCONTINUE");
									cancel_link_yn       = (String)disc_cancel.get("CANCEL");

																		if(discontinued_link_yn!=null && discontinued_link_yn.equals("Y"))
										disc_cancel_style = "";
									else if(cancel_link_yn!=null && cancel_link_yn.equals("Y"))
										disc_cancel_style = "";
									else
										disc_cancel_style = "";
									
									if(discontinued_link_yn!=null && discontinued_link_yn.equals("Y")){
										//on_click = "discontinueTheDrug('"+(String)records.get( 15 )+"','"+(String)records.get( 16 )+"','"+called_frm+"')";
									}
									else if(cancel_link_yn!=null && cancel_link_yn.equals("Y")){
										//on_click = "cancelTheDrug('"+(String)records.get( 15 )+"','"+(String)records.get( 16 )+"','"+called_frm+"')";
									}
									else{
										on_click = "";
									}
									
									//else{

            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(ht_wt_title));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(dtls));
            _bw.write(_wl_block100Bytes, _wl_block100);

									//}
								}
								else{
									// Added for ml-mmoh-crf-0510 start
									//dtls = CommonBean.checkForNull((String)records.get( colCount ));
									if(site){
									if(colCount == 12){
										dtls = "";
									}
									else{
										dtls = CommonBean.checkForNull((String)records.get( colCount ));
									}
									}
									else{
										
										dtls = CommonBean.checkForNull((String)records.get( colCount ));
									
									}
									// Added for ml-mmoh-crf-0510 end
//code added for 24361 on 29Nov2010
									if((line_iv_prep_yn.equals("1") || line_iv_prep_yn.equals("2") || line_iv_prep_yn.equals("3") || line_iv_prep_yn.equals("4")||line_iv_prep_yn.equals("9")||line_iv_prep_yn.equals("0"))&& (colCount==7)){
										if(!order_line_no.equals("1")){
										    dtls ="&nbsp;";
										}
								    }//ends here
									if(line_iv_prep_yn.equals("N") || line_iv_prep_yn.equals("I")){
										if(!order_line_no.equals("1")){
											if(colCount==9 || colCount==12 || colCount==13 || colCount==14 )
												dtls = "&nbsp;";
										}
									}
									if(colCount==12) { 
										/* if(!pres_base_uom.equals(pres_uom)){ //Added for ML-BRU-SCF-1190 [IN:045647] 
											convFactor = bean.getConvFactor(pres_uom,pres_base_uom );
											pres_qty = Float.parseFloat(pres_qty)/Float.parseFloat(convFactor)+"";
										} *///comment for BH-4760(wrong pres qty in pateint drug profile)
										if(pres_qty!=null && !pres_qty.equals(""))
											pres_qty = dfToInteger.format(Double.parseDouble(pres_qty));
										if(!dosage_type.equals("A")){
											if(!freq_nature.equals("P")){
												//pres_disp_unit_value		=  (new Double(Math.ceil(Float.parseFloat(pres_qty)/Float.parseFloat(content_in_pres_base_uom))).intValue())+"";//Commented for ARYU-SCF-0034
												pres_disp_unit_value=order_qty;//Added for ARYU-SCF-0033
											}
											else{
												pres_disp_unit_value=pres_qty;
												pres_uom=stock_uom;
											}
										}
										else{
											if(!line_iv_prep_yn.equals("5") && !line_iv_prep_yn.equals("") && !line_iv_prep_yn.equals("9") && !line_iv_prep_yn.equals("0")){ //added 9 and 0 condition for IN26750 --14/03/2011-- priya
												pres_disp_unit_value=pres_qty;
												//pres_uom=stock_uom;
											}
											else{
												   //pres_disp_unit_value		=  (new Double(Math.ceil(Float.parseFloat(pres_qty)/Float.parseFloat(content_in_pres_base_uom))).intValue())+"";
												if(!dosage_type.equals("A")){
													pres_disp_unit_value		=  (new Double(Math.ceil(Float.parseFloat(pres_qty)/Float.parseFloat(content_in_pres_base_uom))).intValue())+"";
												}
												else{
													//Added IF-Else Condition For getting Prescribed Pres &Dispensing Quantities of PRNAbsolute &Absolute orders regarding incident num:25141,25131 on 25/Nov/2010==By Sandhya
												   /*  if(freq_nature.equals("P")){
														   pres_disp_unit_value		=  pres_qty+"";
													 }
													 else{*/
													pres_disp_unit_value		=  (new Double(Math.ceil(Float.parseFloat(pres_qty)/Float.parseFloat(content_in_pres_base_uom))).intValue())+"";
													// }										
												}
												if(dosage_type.equals("A") || freq_nature.equals("P")){ //added for ARYU-SCF-104
													pres_disp_unit_value = order_qty;
												}
											}
										}
										if(disp_qty != null && disp_qty != ""){
											if(!pres_uom.equals(stock_uom)){
												if(line_iv_prep_yn.equals("2")||line_iv_prep_yn.equals("4")||line_iv_prep_yn.equals("6")||line_iv_prep_yn.equals("0")){
													dispnsd_disp_unit_value	=  Double.parseDouble(disp_qty)/Float.parseFloat(content_in_pres_base_uom)+"";
												}
												else{										
													if(!dosage_type.equals("A")){
													   dispnsd_disp_unit_value		=  (new Double(Math.ceil(Float.parseFloat(disp_qty)/Float.parseFloat(content_in_pres_base_uom))).intValue())+"";
													}
													else{
														//Added IF-Else Condition For getting Dispensed Pres & Dispense Quantities  of PRNAbsolute & Absolute Orders regarding incident num:25141 on 25/Nov/2010==By Sandhya
														if(freq_nature.equals("P")){
														   //dispnsd_disp_unit_value		=disp_qty+"";
														   dispnsd_disp_unit_value		=disp_qty+"";
														   disp_qty		=  (new 		Double(Math.ceil(Float.parseFloat(disp_qty)*Float.parseFloat(content_in_pres_base_uom))).intValue())+"";
														}
														else{ 
															dispnsd_disp_unit_value     =disp_qty+"";
															disp_qty		=  (new 		Double(Math.ceil(Float.parseFloat(disp_qty)*Float.parseFloat(content_in_pres_base_uom))).intValue())+"";
														}
													}
												}
											}
											else{
												dispnsd_disp_unit_value		= disp_qty;
											}
											disp_stock_uom				=  stock_uom;
										}

										if(!pres_qty.equals("")){
											/*if(dosage_type.equals("A")){//Added if for ML-BRU-SCF-1307
												pres_base_uom = stock_uom;
											}*/ //Commented for SKR-SCF-1036.1 [IN:052023]
											//if(!dosage_type.equals("A") && freq_nature.equals("P")){//Added if for BSP-SCF-0017[62586]  --start//!dosage_type.equals("A")added for Aryu-scf-0101
										//	pres_base_uom = stock_uom;
										//	}//end
											if(freq_nature.equals("P") || dosage_type.equals("A")){ //added for ARYU-SCF-0104
												 pres_qty = (new  		Double(Math.ceil(Float.parseFloat(pres_qty)*Float.parseFloat(content_in_pres_base_uom))).intValue())+"";
											}


            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(pres_qty));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(CommonBean.checkForNull(bean.getUomDisplay(facility_id,pres_base_uom))));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(pres_qty));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(pres_uom));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(pres_disp_unit_value));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(CommonBean.checkForNull(bean.getUomDisplay(facility_id,stock_uom))));
            _bw.write(_wl_block106Bytes, _wl_block106);

										}
										else{

            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block108Bytes, _wl_block108);

										}
										if(alternates.equals("N")){
											if(!disp_qty.equals("")){									
												if(disp_qty != null && !disp_qty.equals("")){
													disp_qty = dfToInteger.format(Double.parseDouble(disp_qty));
												}
												/*if(dosage_type.equals("A")){//Added if for ML-BRU-SCF-1307
													disp_uom = disp_stock_uom;
												}*/////Commented for SKR-SCF-1036.1 [IN:052023]
												if(!dosage_type.equals("A") && freq_nature.equals("P")){//Added if for BSP-SCF-0017[62586]  --start//!dosage_type.equals("A")added for Aryu-scf-0101
													disp_uom = stock_uom;
												}//end
												//if else condtion added for IN007846
												if(disp_qty.equals("0")){
													
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block110Bytes, _wl_block110);
			}
												else{
													 
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(disp_qty));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(CommonBean.checkForNull(bean.getUomDisplay(facility_id,disp_uom))));
            _bw.write(_wl_block113Bytes, _wl_block113);
						}
												if(dispnsd_disp_unit_value != null && !dispnsd_disp_unit_value.equals("")){
													dispnsd_disp_unit_value = dfToInteger.format(Double.parseDouble(dispnsd_disp_unit_value));
												}
												//if else condtion added for IN007846
												if(dispnsd_disp_unit_value.equals("0")){
													
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block114Bytes, _wl_block114);
													
												}else{

            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(dispnsd_disp_unit_value));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(CommonBean.checkForNull(bean.getUomDisplay(facility_id,disp_stock_uom))));
            _bw.write(_wl_block116Bytes, _wl_block116);
}
											}
											else{

            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block118Bytes, _wl_block118);

											}
										}
										else if(alternates.equals("Y") ){ //Added  && ReqDb.equals("") for MMS-DM-CRF-115.4s

            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(line_status_text));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(allocate_finding));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(fill_finding));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(allocate_remarks_code));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(fill_remarks_code));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(java.net.URLEncoder.encode(verify_remarks,"UTF-8")));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(allocate_finding));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(fill_finding));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(allocate_remarks_code));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(fill_remarks_code));
            _bw.write(_wl_block123Bytes, _wl_block123);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block124Bytes, _wl_block124);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block125Bytes, _wl_block125);

											if(alt_drug_remarks!=null && !alt_drug_remarks.equals("")){
												stkey = order_id+"~"+order_line_num;
												if(!alt_drug_remarks.equals(""))
													bean.setAltDrugRemarks(stkey, alt_drug_remarks);

            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(stkey));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(alt_drug_remarks_ind));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block127Bytes, _wl_block127);

											}

            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(line_status_text));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(allocate_finding));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(fill_finding));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(allocate_remarks_code));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(fill_remarks_code));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(java.net.URLEncoder.encode(verify_remarks,"UTF-8")));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(allocate_finding));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(fill_finding));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(allocate_remarks_code));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(fill_remarks_code));
            _bw.write(_wl_block130Bytes, _wl_block130);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block124Bytes, _wl_block124);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block125Bytes, _wl_block125);

										if(alt_drug_remarks!=null && !alt_drug_remarks.equals("")){
											stkey = order_id+"~"+order_line_num;
											stkey = order_id+"~"+order_line_num;
											if(!alt_drug_remarks.equals(""))
												bean.setAltDrugRemarks(stkey, alt_drug_remarks);

            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(stkey));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(alt_drug_remarks_ind));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block132Bytes, _wl_block132);

										}

            _bw.write(_wl_block133Bytes, _wl_block133);

									}else if (alternates.equals("Y")){//Added if else condition for MMS-DM-CRF-115.4
	
            _bw.write(_wl_block134Bytes, _wl_block134);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block124Bytes, _wl_block124);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block135Bytes, _wl_block135);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block124Bytes, _wl_block124);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block136Bytes, _wl_block136);

									}
									if(tot_admin_qty!=null && !tot_admin_qty.equals("") && !tot_admin_qty.equals("0") && freq_nature.equals("P")){ /* Added !tot_admin_qty.equals("0") for SKR-SCF-0550[Inc:33338] curly bracket added for MMS-KH-SCF-0037 */ 
										tot_admin_qty =Float.toString( Float.parseFloat(tot_admin_qty)*Float.parseFloat(content_in_pres_base_uom));
										len= tot_admin_qty.length();
										//Below condition is added by sureshkumar T for the Incident no : SRR20056-SCF-7039 [inc : 26763]
										if( len > 0 ){
											temp = tot_admin_qty;
											point= temp.indexOf(".")+1;
											if(point!=0 && temp.charAt(point)=='0')
												tot_admin_qty = tot_admin_qty.substring(0,point-1);
										}// {} added for MMS-KH-SCF-0037
									}
									//tot_admin_qty=total_admin_qty_format.format(Float.parseFloat(tot_admin_qty));

            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(ht_wt_title));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(ret_qty));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(ret_uom));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(ret_date,"DMYHM","en",locale)));
            _bw.write(_wl_block140Bytes, _wl_block140);

								if(alternates.equals("N") || ret_date.equals("")){//Added for ML-BRU-SCF-1394[IN0501010]-Start
									if(!ret_qty.equals("")) //if added for SKR-SCF-1218
									ret_uom = bean.getReturnMedicationUom(order_id,order_line_no); // Added for ICN-69026 - Start

									if(ret_qty.equals("")){ //if condition added for SKR-SCF-1218
										ret_uom = "";
									}
								
								if(!ret_uom.equals(""))
									ret_uom = bean.getUomDisplay(facility_id,ret_uom); // Added for ICN-69026 - End

            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(ht_wt_title));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(ret_qty));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(ret_uom));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(ret_date,"DMYHM","en",locale)));
            _bw.write(_wl_block41Bytes, _wl_block41);
 
								}
							    else if(alternates.equals("Y") && !ret_date.equals("")){

            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(line_status_text));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(allocate_finding));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(fill_finding));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(allocate_remarks_code));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(fill_remarks_code));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(java.net.URLEncoder.encode(verify_remarks,"UTF-8")));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block142Bytes, _wl_block142);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block124Bytes, _wl_block124);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block143Bytes, _wl_block143);

									if(alt_drug_remarks!=null && !alt_drug_remarks.equals("")){
										stkey = order_id+"~"+order_line_num;
										stkey = order_id+"~"+order_line_num;
										if(!alt_drug_remarks.equals(""))
											bean.setAltDrugRemarks(stkey, alt_drug_remarks);

            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(stkey));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(alt_drug_remarks_ind));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block145Bytes, _wl_block145);

									}

            _bw.write(_wl_block87Bytes, _wl_block87);

								}//Added for ML-BRU-SCF-1394[IN0501010]-End

            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(ht_wt_title));
            _bw.write(_wl_block147Bytes, _wl_block147);

										if(!tot_admin_qty.equals("")  && !tot_admin_qty.equals("0") && (dosage_type.equals("A") || dosage_type.equals("Q"))){  //Added !tot_admin_qty.equals("0") for SKR-SCF-0550[Inc:33338]
											len= tot_admin_qty.length();
											if( len > 0 && Float.parseFloat(tot_admin_qty)>1 ){ //&& Float.parseFloat(tot_admin_qty)>1 added for MMS-KH-SCF-0037
												temp = tot_admin_qty;
												point= temp.indexOf(".")+1;
												if(point!=0 && temp.charAt(point)=='0')
													tot_admin_qty = tot_admin_qty.substring(0,point-1);
											}						

            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(tot_admin_qty));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(CommonBean.checkForNull(bean.getUomDisplay(facility_id,admin_uom))));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(pres_qty));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(CommonBean.checkForNull(bean.getUomDisplay(facility_id,pres_base_uom))));
            _bw.write(_wl_block1Bytes, _wl_block1);

										}
										//Added Newly if condition  for the SKR-SCF-0489 on 18/05/2012 
										else if(!tot_admin_qty.equals("")  && !tot_admin_qty.equals("0") && dosage_type.equals("S")){  //Added !tot_admin_qty.equals("0") for SKR-SCF-0550[Inc:33338]
											tot_admin_qty = Float.toString( Float.parseFloat(tot_admin_qty) * Float.parseFloat(strength_value) );	// Added for IN-30262 & 31883 
											len= tot_admin_qty.length();
											if( len > 0 && Float.parseFloat(tot_admin_qty)>1 ){//Float.parseFloat(tot_admin_qty) added for MMS-SCF-037
												temp = tot_admin_qty;
												point= temp.indexOf(".")+1;
												if(point!=0 && temp.charAt(point)=='0')
													tot_admin_qty = tot_admin_qty.substring(0,point-1);
											}						
											if(alternates.equals("Y")) // MMS-KH-SCF-0052
												admin_uom = pres_base_uom;


            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(tot_admin_qty));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(CommonBean.checkForNull(bean.getUomDisplay(facility_id,admin_uom))));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(pres_qty));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(CommonBean.checkForNull(bean.getUomDisplay(facility_id,pres_base_uom))));
            _bw.write(_wl_block1Bytes, _wl_block1);

										}
										if(Integer.parseInt(admin_dose_chng_reason_cnt) > 0){

            _bw.write(_wl_block151Bytes, _wl_block151);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block152Bytes, _wl_block152);

										}

            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(ht_wt_title));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(reissue_qty));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(reissue_uom));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(reissue_date_time));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(ht_wt_title));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(reissue_qty));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(reissue_uom));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(reissue_date_time,"DMYHM","en",locale)));
            _bw.write(_wl_block158Bytes, _wl_block158);
										
										if(alternates.equals("N") || reissue_date_time.equals("")){//Added for ML-BRU-SCF-1394[IN0501010]-Start

            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(ht_wt_title));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(reissue_qty));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(reissue_uom));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(reissue_date_time,"DMYHM","en",locale)));
            _bw.write(_wl_block41Bytes, _wl_block41);
	
										}
										else if(alternates.equals("Y") && !reissue_date_time.equals("")){

            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(line_status_text));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(allocate_finding));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(fill_finding));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(allocate_remarks_code));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(fill_remarks_code));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(java.net.URLEncoder.encode(verify_remarks,"UTF-8")));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block142Bytes, _wl_block142);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block124Bytes, _wl_block124);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block161Bytes, _wl_block161);

											if(alt_drug_remarks!=null && !alt_drug_remarks.equals("")){
												stkey = order_id+"~"+order_line_num;
												stkey = order_id+"~"+order_line_num;
												if(!alt_drug_remarks.equals(""))
													bean.setAltDrugRemarks(stkey, alt_drug_remarks);

            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(stkey));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(alt_drug_remarks_ind));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block162Bytes, _wl_block162);

											}

            _bw.write(_wl_block163Bytes, _wl_block163);

									   }//Added for ML-BRU-SCF-1394[IN0501010]-End
									}
									if(colCount==7){ //Code Added CRF - 0034  Start

            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(fntColor));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(backgrndColor));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(ht_wt_title));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(dtls));
            _bw.write(_wl_block66Bytes, _wl_block66);
 
									}
									else if(colCount==8  && records.get(55) != null && ((String)records.get(55)).equals("Y")){ //Code Added CRF - 0034 End


            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(ht_wt_title));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(patient_id ));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block169Bytes, _wl_block169);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block170Bytes, _wl_block170);
								
									}
									else{ // Else block Added for 10.X-CRF-SRR20056-CRF-0675-PH-SL-2 -- start
										if(site){
											if( colCount!=12){

            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block171Bytes, _wl_block171);

											}
										}else{
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block172Bytes, _wl_block172);
	}
										if(colCount==8){
											if(sliding_scale_yn!=null && sliding_scale_yn.equals("Y") ){// && ReqDb.equals("") added for MMS-DM-CRF-115.4

            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block175Bytes, _wl_block175);

												ArrayList sliding_scale_details =   bean.getSlidingScaleTemplateDetails(order_id,order_line_num,"",encounter_id);
												String sRemarks="&nbsp;";
												boolean blTempFound = false;

												if(sliding_scale_details.size()>1){
													blTempFound = true;

            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf((String)sliding_scale_details.get(9)));
            _bw.write(_wl_block177Bytes, _wl_block177);

            if (_jsp__tag49(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block178Bytes, _wl_block178);

            if (_jsp__tag50(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block178Bytes, _wl_block178);

            if (_jsp__tag51(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block178Bytes, _wl_block178);

            if (_jsp__tag52(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block178Bytes, _wl_block178);

            if (_jsp__tag53(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block179Bytes, _wl_block179);

            if (_jsp__tag54(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block180Bytes, _wl_block180);

														String toRan="";
														String admUnit="";
														for(int sl=1;sl<sliding_scale_details.size();sl+=9){
															toRan=((String)sliding_scale_details.get(sl+3)).equals("0")?(">"+(String)sliding_scale_details.get(sl+2)):(String)sliding_scale_details.get(sl+3);
															admUnit=(String)sliding_scale_details.get(sl+4);
															if(admUnit!=null && !admUnit.equals("")){
																float admUnitValue=Float.parseFloat(admUnit);
																if(admUnitValue>0.0 && admUnitValue<1.0)
																	admUnit=Float.parseFloat(admUnit)+"";
															}
															if(((String)sliding_scale_details.get(sl+7)).equalsIgnoreCase("null") || ((String)sliding_scale_details.get(sl+7)).equals(" ") || sliding_scale_details.get(sl+7) ==null)
																sRemarks = "&nbsp;&nbsp;";
															else
																sRemarks = java.net.URLDecoder.decode((String)sliding_scale_details.get(sl+7),"UTF-8");

            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf((String)sliding_scale_details.get(sl+2)));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(toRan));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf((String)sliding_scale_details.get(sl+5)));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(admUnit));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf((String)sliding_scale_details.get(sl+6)));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(sRemarks));
            _bw.write(_wl_block185Bytes, _wl_block185);

														}
													}
													else{
														blTempFound = false;

            _bw.write(_wl_block186Bytes, _wl_block186);

													}

            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(sliding_scale_yn));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(blTempFound));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag55(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block190Bytes, _wl_block190);

												}
                                               
										}
if(dtls!=""){

            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(ht_wt_title));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(dtls));
            _bw.write(_wl_block193Bytes, _wl_block193);

}
									} //Added/Modified for 10.X-CRF-SRR20056-CRF-0675-PH-SL-2 -- End
									if(colCount==13){
										

            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block1Bytes, _wl_block1);
 
										//if(!disp_qty.equals("") || alternates.equals("Y") || line_status.equals("IP") || line_status.equals("AL") || line_status.equals("DP")|| line_status.equals("DC")){ //if condition added for ML-BRU-SCF-0430 IN[035169]  //line_status added for ML-BRU-SCF-1116 [IN:044786]
							   			dispense_count 		= CommonBean.checkForNull((String)records.get(69));//Added for MMS-SCF-0196
										if(!disp_qty.equals("") || alternates.equals("Y") || line_status.equals("IP") || line_status.equals("AL") || line_status.equals("DP")|| line_status.equals("DF") || (!dispense_count.equals("") && !dispense_count.equals("0"))){ //if condition added for ML-BRU-SCF-0430 IN[035169]  //line_status added for ML-BRU-SCF-1116 [IN:044786]

            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(line_status_text));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(allocate_finding));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(fill_finding));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(allocate_remarks_code));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(fill_remarks_code));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(java.net.URLEncoder.encode(verify_remarks,"UTF-8")));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block197Bytes, _wl_block197);

            if (_jsp__tag56(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block198Bytes, _wl_block198);

										
										}
									}

            _bw.write(_wl_block87Bytes, _wl_block87);

								}
							}

            _bw.write(_wl_block42Bytes, _wl_block42);

						}
						int index1=-1;
						if (result.size()<index1){

            _bw.write(_wl_block199Bytes, _wl_block199);

							return;
						}

            _bw.write(_wl_block200Bytes, _wl_block200);

				out.flush();

            _bw.write(_wl_block201Bytes, _wl_block201);


			}
			else{

            _bw.write(_wl_block202Bytes, _wl_block202);

			}
			out.println(CommonBean.setForm ( request ,"../../eCA/jsp/MedicationOrdersResult.jsp", searched) );
		} 
		catch(Exception e) {
			//out.print("Exception @ Result JSP :"+e.toString());//COMMON-ICN-0181
			e.printStackTrace();
		}//Added  for ml-mmoh-crf-0510 start
		finally{
			

			if(con != null)
				ConnectionManager.returnConnection(con,request);
		
		}
		//Added  for ml-mmoh-crf-0510 end

            _bw.write(_wl_block203Bytes, _wl_block203);
 
	putObjectInBean(bean_id,bean,request); 

            _bw.write(_wl_block204Bytes, _wl_block204);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Prescribed/DispensedDrug.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.GenericName.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DiscCancelDrugDtls.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DiscCancelDrugDtls.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DiscCancelDrugDtls.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Route.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DosageDetail.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.StartDate.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enddate.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientclass.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PrescribedQuantity.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PrescribingUnit.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DispensingUnit.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DispenseQuantity.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PrescribingUnit.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DispensingUnit.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ReturnQuantity/Date.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdminQuantity.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PrescribedQuantity.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ReissuedQuantity.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PrescribedBy.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderingLocation.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderID.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.facility.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PrescribedBy.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Transcribed.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.by.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DispenseDetail.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Dispensed.label", java.lang.String .class,"key"));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Remarks.label", java.lang.String .class,"key"));
        __tag33.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AlternateDrugs.label", java.lang.String .class,"key"));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Dispensed.label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Remarks.label", java.lang.String .class,"key"));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AlternateDrugs.label", java.lang.String .class,"key"));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Dispensed.label", java.lang.String .class,"key"));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AlternateDrugs.label", java.lang.String .class,"key"));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Dispensed.label", java.lang.String .class,"key"));
        __tag40.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AlternateDrugs.label", java.lang.String .class,"key"));
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
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Dispensed.label", java.lang.String .class,"key"));
        __tag42.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Remarks.label", java.lang.String .class,"key"));
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
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ChangeDoseDetailExist.label", java.lang.String .class,"key"));
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
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AlternateDrugs.label", java.lang.String .class,"key"));
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
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Dispensed.label", java.lang.String .class,"key"));
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
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Remarks.label", java.lang.String .class,"key"));
        __tag47.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MultipleFlowRate.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag49(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag49 = null ;
        int __result__tag49 = 0 ;

        if (__tag49 == null ){
            __tag49 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag49);
        }
        __tag49.setPageContext(pageContext);
        __tag49.setParent(null);
        __tag49.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.FROMRANGE.label", java.lang.String .class,"key"));
        __tag49.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag49;
        __result__tag49 = __tag49.doStartTag();

        if (__result__tag49!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag49== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag49.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag49);
            return true;
        }
        _activeTag=__tag49.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag49);
        __tag49.release();
        return false;
    }

    private boolean _jsp__tag50(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag50 = null ;
        int __result__tag50 = 0 ;

        if (__tag50 == null ){
            __tag50 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag50);
        }
        __tag50.setPageContext(pageContext);
        __tag50.setParent(null);
        __tag50.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.TORANGE.label", java.lang.String .class,"key"));
        __tag50.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag50;
        __result__tag50 = __tag50.doStartTag();

        if (__result__tag50!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag50== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag50.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag50);
            return true;
        }
        _activeTag=__tag50.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag50);
        __tag50.release();
        return false;
    }

    private boolean _jsp__tag51(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag51 = null ;
        int __result__tag51 = 0 ;

        if (__tag51 == null ){
            __tag51 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag51);
        }
        __tag51.setPageContext(pageContext);
        __tag51.setParent(null);
        __tag51.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.RangeUOM.label", java.lang.String .class,"key"));
        __tag51.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag51;
        __result__tag51 = __tag51.doStartTag();

        if (__result__tag51!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag51== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag51.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag51);
            return true;
        }
        _activeTag=__tag51.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag51);
        __tag51.release();
        return false;
    }

    private boolean _jsp__tag52(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag52 = null ;
        int __result__tag52 = 0 ;

        if (__tag52 == null ){
            __tag52 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag52);
        }
        __tag52.setPageContext(pageContext);
        __tag52.setParent(null);
        __tag52.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdminUnits.label", java.lang.String .class,"key"));
        __tag52.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag52;
        __result__tag52 = __tag52.doStartTag();

        if (__result__tag52!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag52== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag52.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag52);
            return true;
        }
        _activeTag=__tag52.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag52);
        __tag52.release();
        return false;
    }

    private boolean _jsp__tag53(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag53 = null ;
        int __result__tag53 = 0 ;

        if (__tag53 == null ){
            __tag53 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag53);
        }
        __tag53.setPageContext(pageContext);
        __tag53.setParent(null);
        __tag53.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdminUnitsUOM.label", java.lang.String .class,"key"));
        __tag53.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag53;
        __result__tag53 = __tag53.doStartTag();

        if (__result__tag53!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag53== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag53.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag53);
            return true;
        }
        _activeTag=__tag53.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag53);
        __tag53.release();
        return false;
    }

    private boolean _jsp__tag54(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag54 = null ;
        int __result__tag54 = 0 ;

        if (__tag54 == null ){
            __tag54 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag54);
        }
        __tag54.setPageContext(pageContext);
        __tag54.setParent(null);
        __tag54.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag54.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag54;
        __result__tag54 = __tag54.doStartTag();

        if (__result__tag54!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag54== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag54.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag54);
            return true;
        }
        _activeTag=__tag54.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag54);
        __tag54.release();
        return false;
    }

    private boolean _jsp__tag55(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag55 = null ;
        int __result__tag55 = 0 ;

        if (__tag55 == null ){
            __tag55 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag55);
        }
        __tag55.setPageContext(pageContext);
        __tag55.setParent(null);
        __tag55.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SlidingScale.label", java.lang.String .class,"key"));
        __tag55.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag55;
        __result__tag55 = __tag55.doStartTag();

        if (__result__tag55!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag55== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag55.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag55);
            return true;
        }
        _activeTag=__tag55.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag55);
        __tag55.release();
        return false;
    }

    private boolean _jsp__tag56(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag56 = null ;
        int __result__tag56 = 0 ;

        if (__tag56 == null ){
            __tag56 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag56);
        }
        __tag56.setPageContext(pageContext);
        __tag56.setParent(null);
        __tag56.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DispensedLocns.label", java.lang.String .class,"key"));
        __tag56.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag56;
        __result__tag56 = __tag56.doStartTag();

        if (__result__tag56!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag56== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag56.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag56);
            return true;
        }
        _activeTag=__tag56.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag56);
        __tag56.release();
        return false;
    }
}
