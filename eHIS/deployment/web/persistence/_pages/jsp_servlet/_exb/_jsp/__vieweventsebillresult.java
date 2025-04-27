package jsp_servlet._exb._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eXB.XBDBAdapter;
import java.sql.*;
import java.util.*;
import java.util.regex.Pattern;
import java.io.*;
import eXB.*;
import eXH.XHUtil;
import java.util.*;
import com.ehis.util.*;

public final class __vieweventsebillresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exb/jsp/ViewEventseBillResult.jsp", 1709122250243L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<HEAD>\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n<link rel=\'stylesheet\' href=\'../../eXH/html/menu.css\' type=\'text/css\'></link>\n<link rel=\'stylesheet\' href=\'../../eXH/html/ViewEvents.css\' type=\'text/css\'></link>\n<style>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \t\t\t\t\t   \n\tdiv {float: left}\t\t\t\t\t\t\t\t\t \t\t\t\t\t\t\t\t\t   \n\t.testSty\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\t{\n\t\twidth:expression(document.getElementById(\"indicatorTable\").clientWidth-document.getElementById(\"left_child\").clientWidth);\n\t\toverflow: scroll;\n\t}\n\n\tinput.bigcheck { \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t     \n\t\theight: 11px; \n\t\twidth: 12px; \n\t\t} \n\n</style>\n<SCRIPT language=\'javascript\' src=\'../../eXH/js/menu.js\'></script> \t\t \n<script Language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\" ></script>\t\t\t\t\t\t\t\t\t    \n<script Language=\"javascript\" src=\"../../eXH/js/Validate.js\" ></script>\t\t\t\t\t\t    \n<script Language=\"javascript\" src=\"../../eCommon/js/common.js\" ></script>\n<Script Language=\"javascript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n<script language=\'javascript\' src=\'../../eXH/js/jquery-1.7.min.js\'></script>\n<script language=\'javascript\' src=\'../../eXH/js/GatewayServer.js\'></script>\n<script language=\'javascript\' src=\'../../eXB/js/ViewEventsOutbound.js\'></script>\n<script language=\'javascript\' src=\'../../eXB/js/ViewEvents.js\'></script>\n<script language=\"javascript\">\n\n//function callForOrderBy\nfunction callForOrderBy(obj,order)\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \n{\t\n//\talert(\"order : \"+order);\n\tif(order == \'A\') obj = obj + \' asc\';\n\tif(order == \'D\') obj = obj + \' desc\';\n\tvar url = \'&orderBy=\' + obj + \'&order=\' + order;\n\n\tthis.document.forms[0].action_type.value = \"\";\n\tthis.document.forms[0].action = \"../../eXB/jsp/ViewEventseBillResult.jsp?\"+url;\n\tthis.document.forms[0].target = \"f_query_add_mod_dtl\";\n\tthis.document.forms[0].submit();\n}\n\n</script>\n\n<BODY  leftmargin=0 topmargin=0  bgcolor=\'#F0F0F2\' onMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\'>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<form name=\"ApplicationEventListForMessageTypeForm\" id=\"ApplicationEventListForMessageTypeForm\" target=\'messageFrame\' method=\'post\' >\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n<script>\nalert(getMessage(\"XH1021\",\"XH\"));history.go(-1);\n</script>  \n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<table id=\"indicatorTable\" cellspacing=0 cellpadding=3 width=\'100%\' align=center>\n\n<tr>\n\t<td colspan=\"10\" align=\"center\" class=\"COLUMNHEADER\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n</tr>\n<tr>\t   \n\t<td align=\"left\" class=\"CAGROUP\" colspan=\"5\">\n\t\t<A class=\'linkClass1\' onmouseover=\'hotStateImage(this)\' onmouseout=\'restorePrevState(this)\' style=\'cursor:pointer\' onClick=\"editQuery();\" TITLE=\"Edit Query\">\n\t\t\tEditQuery\n\t\t</A>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    \n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t<A class=\'linkClass1\' onmouseover=\'hotStateImage(this)\' onmouseout=\'restorePrevState(this)\' style=\'cursor:pointer\' onClick=\"refreshResults(\'ViewEventseBillResult\');\" TITLE=\"Refresh Events\">\n\t\t\tRefresh\n\t\t</A>\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\t\t\t\t\t\t\t\t\t\t\t\t   \n\t</td>\n\t<!--<td align=\"right\" class=\"CAGROUP\"> \n\t\t<A class=\'label\' style=\'cursor:pointer\' onClick=\"funAction(\'P\')\">Previous</A>\n\t\t<A class=\'label\' onClick=\"funAction(\'N\')\" style=\'cursor:pointer\'>Next</A>\n\t</td> -->\n<!--</tr>\n<tr> -->\n\t<td colspan=\"5\" align=\"right\" class=\"CAGROUP\" > \n\t<A class=\'label\' style=\'cursor:pointer\' onClick=\"funAction(\'P\')\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</A>\n\t<A class=\'label\'  onClick=\"funAction(\'N\')\" style=\'cursor:pointer\' >";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</A>\n\t</td>\n</tr> \t\t\t\t\t\t\t\t\t    \n</table>\n\n<div id=\"left_child\" style=\"display:none;\"> \n<table id=\"table1\" cellspacing=0 cellpadding=3 border=1 width=\'60%\'>\t\n    <tr>\n\t    ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t<td class=\'COLUMNHEADER\' nowrap style=\"height:10px\"> <input type=checkbox  name=\'SelectAll\' id=\'SelectAll\' value=\'\' onClick=\'selectAll();\'> \n\t\t\t\n\t\t\t</td>\n\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n<!--\t\t<td class=\'COLUMNHEADER\'  style=\"height:26px\" title=\"Event Status\" nowrap>\n\t\t\t$ </td> -->\n\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t<td class=\'COLUMNHEADER\' title=\"Message Status\"  style=\"height:10px\" nowrap>\n\t\t\t# </td>\n\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t<td class=\'COLUMNHEADER\'  style=\"height:24px\" nowrap> <a id=\'a001\' href=\"javascript:callForOrderBy(\'lpad(Message_ID,20)\',\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\');\" onclick=\'\'><font color=white>MessageID</td>\t\t\n\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n<!--\t\t<td class=\'COLUMNHEADER\'>ApplicationID</td> -->\n\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t<td class=\'COLUMNHEADER\' nowrap style=\"height:24px\"> <a id=\'a001\' href=\"javascript:callForOrderBy(\'EVENT_TYPE\',\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\');\"onclick=\'\'><font color=white>Event Type</td>\n\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t<td class=\'COLUMNHEADER\'  style=\"height:24px\" nowrap><a id=\'a001\' href=\"javascript:callForOrderBy(\'MESSAGE_DATE\',\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\');\"onclick=\'\'><font color=white>MessageDate</td>\t\t\n\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t<td class=\'COLUMNHEADER\' style=\"height:24px\" nowrap><a id=\'a001\' href=\"javascript:callForOrderBy(\'FACILITY_ID\',\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\');\"onclick=\'\'><font color=white>FacilityID</td>\n\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t<td class=\'COLUMNHEADER\' style=\"height:24px\" nowrap><a id=\'a001\' href=\"javascript:callForOrderBy(\'ACCESSION_ NUM\',\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\');\"onclick=\'\'><font color=white>Accession Number</td>\n\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n </tr>\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t<tr>\n\t\t\t    ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\t \t\t\t\t   \n\t\t\t\t\t\t<td class=\'QRYODD\' style=\"height:25px\">\t\t\n\t\t\t\t\t\t\n\t\t\t\t   ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t   <input class=\"bigcheck\" type=checkbox id=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'    value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' onClick=\"dispAmount(this,\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\',\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\');\"         ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" >       \n\t\t\t\t<input type=\'hidden\'  id=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' name=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'  value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' >\t \t\t\t\n\t\t\t\t   ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t <input class=\"bigcheck\" type=checkbox id=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\');\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =" disabled >      \n\t\t\t\t<input type=\'hidden\'  id=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' >\t\n\t  ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\n\t\t\t\t\t\t\t \t   \n\t\t\t\t\t\t\t\t <input type=\'hidden\' name=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' id=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' >\n\t\t\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    \t   \n\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t<!--\t<td nowrap class=\'QRYEVEN\' style=\"height:25px\"> <img src=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'  height=10> </img> </td>  \t-->\n\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t<td nowrap class=\'QRYODD\'  style=\"height:25px\" ><img src=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'  height=10 width=\'10\'> </img> </td>\n\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t<td class=\'QRYEVEN\' style=\"height:25px\" nowrap><font size=1>";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t<input type=hidden name=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' > </td>\n\n\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t<!--\t<td class=\'QRYEVEN\' ><font size=1>";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</td> -->\n\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t<td class=\'QRYODD\' style=\"height:25px\" nowrap> <font size=1>";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</td>\n\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t<td class=\'QRYEVEN\' nowrap style=\"height:25px\"><font size=1>";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</td>\t\t\n\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t<td class=\'QRYODD\' style=\"height:10px\" nowrap><font size=1>";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="</td>\n";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</td>\n\n";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t</tr>\n\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n </table>\n </div>\n\n<div id=\"right_child\" class=\"testSty\" style=\"overflow-y:scroll;overflow:-moz-scrollbars-vertical;display:none;\">\n<table id=\"table2\" cellspacing=0 cellpadding=3 border=1 width=\'50%\'> \n <tr> \n";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t<td class=\'COLUMNHEADER\'  style=\"height:26px\"><a id=\'a001\' href=\"javascript:callForOrderBy(\'FACILITY_NAME\',\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\');\"onclick=\'\'><font color=white>FacilityName</td>\n\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t<td class=\'COLUMNHEADER\'  style=\"height:26px\" ><a id=\'a001\' href=\"javascript:callForOrderBy(\'INV_NO\',\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\');\"onclick=\'\'><font color=white>InvNo</td>\n\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t<td class=\'COLUMNHEADER\'  style=\"height:26px\" ><a id=\'a001\' href=\"javascript:callForOrderBy(\'INV_DATE\',\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\');\"onclick=\'\'><font color=white>InvDate</td>\n\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t<td class=\'COLUMNHEADER\'  style=\"height:26px\"><a id=\'a001\' href=\"javascript:callForOrderBy(\'PATIENT_ID\',\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\');\"onclick=\'\'><font color=white>HospitalNo</td>\n\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t<td class=\'COLUMNHEADER\'  style=\"height:26px\"><a id=\'a001\' href=\"javascript:callForOrderBy(\'INV_AMOUNT\',\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\');\"onclick=\'\'><font color=white>InvAmount</td>\n\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t<td class=\'COLUMNHEADER\' style=\"height:26px\"><a id=\'a001\'\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   href=\"javascript:callForOrderBy(\'VISIT_DATE\',\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\');\"onclick=\'\'><font color=white>VisitDate</td>\n\t\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t\t<td class=\'COLUMNHEADER\' style=\"height:26px\"><a id=\'a001\' href=\"javascript:callForOrderBy(\'PATIENT_NAME\',\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\');\"onclick=\'\'><font color=white>PatientName</td>\n\t\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t<td class=\'COLUMNHEADER\'  style=\"height:26px\"><a id=\'a001\' href=\"javascript:callForOrderBy(\'PATIENT_TYPE\',\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\');\"onclick=\'\'><font color=white>PatientType</td>\n\t\t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t<td class=\'COLUMNHEADER\'  style=\"height:26px\"><a id=\'a001\' href=\"javascript:callForOrderBy(\'CARD_ID\',\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\');\"onclick=\'\'><font color=white>CardId</td>\n\t\t";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t<td class=\'COLUMNHEADER\' style=\"height:25px\"><a id=\'a001\' href=\"javascript:callForOrderBy(\'CARD_ISSUE_DATE\',\'";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\');\"onclick=\'\'><font color=white>CardIssueDate</td>\n\t\t";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t<td class=\'COLUMNHEADER\'  style=\"height:26px\"><a id=\'a001\' href=\"javascript:callForOrderBy(\'CITIZEN_ID\',\'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\');\"onclick=\'\'><font color=white>CitizenID</td>\t\n\t\t";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t\t<td class=\'COLUMNHEADER\'  nowrap style=\"height:26px\"><a id=\'a001\' href=\"javascript:callForOrderBy(\'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\');\"onclick=\'\'><font color=white>Status Text</td>\t\n\t\t";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\');\"onclick=\'\'><font color=white>Last Comm Start Time</td>\t\n\t\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\');\"onclick=\'\'><font color=white>Query Id</td>\t \n\t\t";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\');\"onclick=\'\'><font color=white>Episode Type</td>\t\n\t\t";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\');\"onclick=\'\'><font color=white>Episode Id</td>\t\n\t\t";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\');\"onclick=\'\'><font color=white>Application Name</td>\t\n\t\t";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\');\"onclick=\'\'><font color=white>";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="</td>\t\n\t\t";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\t\t\t   \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n </tr>\n ";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t\t<tr>\n\n\t\t";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n\t\t<td class=\'QRYEVEN\'  nowrap style=\"height:25px\"><font size=1>";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\t\t<td class=\'QRYEVEN\'  nowrap style=\"height:25px\" ><font size=1>";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\t\t<td class=\'QRYODD\' nowrap style=\"height:25px\" ><font size=1>";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\t\t\t\t\t\t\t\t\t\t\t\t\t  \n\t\t<td class=\'QRYEVEN\'  nowrapstyle=\"height:25px\" ><font size=1>";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\t\t\n\t\t<td class=\'QRYODD\' nowrap  style=\"height:25px\">\n\t\t<font size=1>";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="</td>\n\t\t\t\t<input type=hidden name=\'";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\' > </td>\n\t\t";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\n\t\t\t\t<td class=\'QRYODD\'  nowrapstyle=\"height:25px\"><font size=1>";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="</td>\n\t\t\t";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\n\t\t\t\t<td class=\'QRYODD\'nowrap  style=\"height:25px\"><font size=1>";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="</td>\n    \t\t";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\n\t\t<td class=\'QRYODD\' nowrap  style=\"height:25px\"><font size=1>";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\t\t\t\t\t\t\t    \n\t\t<td class=\'QRYEVEN\'  nowrap style=\"height:25px\"><font size=1>";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 =" </td>\n\t\t";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n </table>\t\t\t\t\t\t\t  \n</div>\n\n\n<table width=\'100%\' >\n    <tr> </tr>\t  <tr> </tr>\t    <tr> </tr>\n\t\t<tr>\n\t\t\t<td  class=label >Count  </td> <td> ";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 =" </td>\n\t\t\t<td width=\'25%\' > </td> <td class=label >Cumulative Sum  &nbsp;<input type = \"text\" size=\"10\"  name=\'cum_amount\' id=\'cum_amount\' value = \'0\' disabled> </td>\n\t\t\t<td width=\'15%\' > </td>\t\t<td  class=label >Total Sum  </td> <td> ";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 =" </td>\n<!--\t\t\t<input type = \"button\" name=\"Show Total Sum\" id=\"Show Total Sum\" value=\' Show Total Sum \'  title=\'Show Total Sum\' onClick=\'ShowTotal();\'> \t</td> -->\n\t\t</tr>\n   <tr> </tr>\n</table>\t \n\n<div id=\'export\' style=";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 =">\t\t\t\t\t\t    \n<table cellspacing=0 cellpadding=3 width=\'100%\' align=center>\n\t<tr>\n\t\t<td class=\"CAGROUP\" width=\'5%\'>\n\t\t\t<A class=\'linkClass1\' onmouseover=\'hotStateImage(this)\' onmouseout=\'restorePrevState(this)\' style=\'cursor:pointer\' onClick=\"genExport();\" TITLE=\"Export\"> Export\t</A> &nbsp;&nbsp; \n\t\t\t<A class=\'linkClass1\' onmouseover=\'hotStateImage(this)\' onmouseout=\'restorePrevState(this)\' style=\'cursor:pointer\' onClick=\"genExcel();\" TITLE=\"WriteToExcel\" > WriteToExcel\t</A> \n\t\t</td>\n\t</tr>\n</table>\t \n<div>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\n <SCRIPT>\n\t\n\tdocument.getElementById(\"left_child\").style.display = \"block\";\n\t document.getElementById(\"right_child\").style.display = \"block\";\n// alert(\"Footer\");\n parent.f_query_add_mod_footer.location.href = \"../../eXB/jsp/ViewEventsOutboundFooter.jsp?commType=outbound\";\n</SCRIPT>\n\n";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \n<input type=\"hidden\" name=\'message_type\' id=\'message_type\' value=\'";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\'>\n<input type=\"hidden\" name=\'rsCount\' id=\'rsCount\' value=\'";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\'>\n<input type=\"hidden\" name=\'QryCols\' id=\'QryCols\' value=\'";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\'>\n<input type=\"hidden\" name=\'whereClause\' id=\'whereClause\' value=\'";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\'>\n<input type=\"hidden\" name=\'Tot_Inv_Amount\' id=\'Tot_Inv_Amount\' value=\'";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\'>\n<input type=\"hidden\" name=\'msg_status\' id=\'msg_status\' value=\'";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\'>\n<input type=\"hidden\" name=\'eventtype\' id=\'eventtype\' value=\'";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\'>\n<input type=\"hidden\" name=\"protocolLinkID\" id=\"protocolLinkID\" id=\"protocolLinkID\" value=\"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\" >\n<input type=\"hidden\" name=\"applnname\" id=\"applnname\" id=\"applnname\" value=\"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\" >\n<input type=\"hidden\" name=\"facilityID\" id=\"facilityID\" id=\"facilityID\" value=\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\" >\n<input type=\'hidden\' name=\'action_type\' id=\'action_type\' value=\'\'>\n<input type=\'hidden\' name=\'orderBy\' id=\'orderBy\' value=\'";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\'> \n<input type=\'hidden\' name=\'order\' id=\'order\' value=\'";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\'>\n<input type=\'hidden\' name=\'DataLinestr\' id=\'DataLinestr\' value=\'";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\'>\n<input type=\'hidden\' name=\'totalMsgList\' id=\'totalMsgList\' value=\'";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\'>\n<input type=\'hidden\' name=\'g\' id=\'g\' value=\'";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\'>\n<input type=\'hidden\' name=\'acccount\' id=\'acccount\' value=\'";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\'>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

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
request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block5Bytes, _wl_block5);
 String locale = ((String)session.getAttribute("LOCALE")); 
locale = "en"; 
		 int g=0;
		 int acccount=1;
		 
            _bw.write(_wl_block1Bytes, _wl_block1);
 
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

Connection con=null;
Statement stmt1=null;
ResultSet rs1=null;
int rsCount = 0;
String QryCols = "";
String emptyString = "";
float Tot_Inv_Amount = 0.00f;
//String disabled = "disabled";
String msg_status= null;
String eventtype= null;
String protocolLinkID = null;
String applnname = null;
String facility = null;
String styleExport = "display:none";
String orderBy = null;
String order = null;															     
String whereClause =" ";
String DataLinestr="";

            _bw.write(_wl_block8Bytes, _wl_block8);
	
Pattern Regex1=null;
//String qry_id = "VIEW_GENERAL_EVENTS_EBILL";
 String totalMsgList=XBDBAdapter.checkNull(request.getParameter("totalMsgList")); 
  try{
			Regex1 = Pattern.compile("\\$!",Pattern.MULTILINE);
		}
		catch(Exception e)
		{
			System.out.println("erorr"+e);
		}															    

try			 	
{
	boolean boolToggle =  true;	
	String strTDClass = "";

	String msg_dt1= null;
	String msg_dt2= null;
	String msg_id1= null;
	String msg_id2= null;	
	String comm_mode= null;
	String event_status = null;
	String protocol_link_name= null;
//	String purge_status= null;						    
	String dispMode= null;
	String interface_module= null;
	
	msg_dt1			= XBDBAdapter.checkNull(request.getParameter("msg_dt1"));
	msg_dt2			= XBDBAdapter.checkNull(request.getParameter("msg_dt2"));
	msg_id1			= XBDBAdapter.checkNull(request.getParameter("msg_id1"));
	msg_id2			= XBDBAdapter.checkNull(request.getParameter("msg_id2"));
	applnname		= XBDBAdapter.checkNull(request.getParameter("applnname"));
	eventtype			= XBDBAdapter.checkNull(request.getParameter("eventtype"));
	comm_mode		= XBDBAdapter.checkNull(request.getParameter("comm_mode"));
	facility				= XBDBAdapter.checkNull(request.getParameter("facility"));
	event_status		= XBDBAdapter.checkNull(request.getParameter("event_status"));
	msg_status		= XBDBAdapter.checkNullNoTrim(request.getParameter("msg_status"));
	protocol_link_name	= XBDBAdapter.checkNull(request.getParameter("protocol_link_name"));
	dispMode					= XBDBAdapter.checkNull(request.getParameter("dispMode"));
	interface_module		= XBDBAdapter.checkNull(request.getParameter("interface_module"));
	orderBy			= XBDBAdapter.checkNull(request.getParameter("orderBy"));
	order				= XBDBAdapter.checkNull(request.getParameter("order"));
    String accVal	=  XBDBAdapter.checkNull(request.getParameter("acccount"));
	String gVal		=  XBDBAdapter.checkNull(request.getParameter("g"));
	protocolLinkID = new XHUtil().singleParamExeQry("SELECT DISTINCT protocol_link_id FROM xh_data_group_detail WHERE event_type = '" + eventtype + "'");	

	if(!accVal.equals("") && !accVal.equals("null") && !accVal.equals(null) ) 
		acccount		=	Integer.parseInt(accVal);
	if(!gVal.equals("") && !gVal.equals("null") && !gVal.equals(null) ) 
		g					=	Integer.parseInt(gVal);

	if(msg_status.equals("H") && !eventtype.equals("") ){
	//	disabled = "";
		styleExport="display:block";
	}

	String NewColList = XBDBAdapter.checkNull(request.getParameter("NewColList"));
	//	System.out.println("NewColList : "+NewColList);
	con=ConnectionManager.getConnection();
//	String qry = "SELECT * FROM XB_EVENT_APPL_MESSAGE_XL_VW  ";				   

	String ResultQry = "";
	Pattern Regex=null;
//	String Colstatus = "";
//	String ColVal = "";
	String EvntStatusColor = "../../eXH/images/black_square.jpg";
	String MsgStatusColor = "../../eXH/images/blue_square.jpg";

	 try{

		 File file1 = new File(config.getServletContext().getRealPath("/")+"eXB/html/XB_EVENT_APPL_MESSAGE_VW.html"  );

           if(NewColList.length()>0){
		 			FileOutputStream fileoutput = new FileOutputStream(file1);
					fileoutput.write(NewColList.getBytes());
					if (fileoutput != null)  fileoutput.close();	
		   }
	   		 File file2 = new File(config.getServletContext().getRealPath("/")+"eXB/html/XB_EVENT_APPL_MESSAGE_VW.html"  );
//			 boolean exists = file2.exists();	
			 BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file2)));
			 DataLinestr = br.readLine();
			 br.close();
		}
		catch(Exception e) {
			e.printStackTrace();
       }
	//		System.out.println("ViewEventseBillDtlsResultPage.jsp DataLinestr :"+DataLinestr);
		try{
			Regex = Pattern.compile("\\,",Pattern.MULTILINE);
// System.out.println("ViewEventseBillDtlsResultPage.jsp Regex :"+Regex);

		}
		catch(Exception e)
		{
			System.out.println("ViewEventseBillResult.jsp erorr"+e);
		}															    
																				    
		String[] array=Regex.split(DataLinestr);

//		int lastElementIndex=(array.length-1);
//	    System.out.println("array.length : "+array.length);
		for(int i=0;i<array.length;i++)
		{
// String name=array[i].replaceFirst("_"," ");					 
	if(array[i].equals("INV_NO")){
				QryCols = QryCols+"SUBSTR(SYS_DEF_MESSAGE_TEXT,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,4)+1,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,5) - INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,4)-1)  INV_NO,";
			}
			else  if(array[i].equals("INV_DATE")){
				QryCols = QryCols+"SUBSTR(SYS_DEF_MESSAGE_TEXT,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,5)+1,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,6) - INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,5)-1)  INV_DATE,";
			}
			else if(array[i].equals("INV_AMOUNT")){
				QryCols = QryCols+"SUBSTR(SYS_DEF_MESSAGE_TEXT,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,6)+1,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,7) - INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,6)-1) INV_AMOUNT,";
			}
			else if(array[i].equals("VISIT_DATE")){
				QryCols = QryCols+"SUBSTR(SYS_DEF_MESSAGE_TEXT,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,7)+1,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,8) - INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,7)-1)  VISIT_DATE,";
			}
			else if(array[i].equals("PATIENT_NAME")){
				QryCols = QryCols+"SUBSTR(SYS_DEF_MESSAGE_TEXT,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,8)+1,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,9) - INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,8)-1)  PATIENT_NAME,";
			}
			else if(array[i].equals("PATIENT_TYPE")){
				QryCols = QryCols+"SUBSTR(SYS_DEF_MESSAGE_TEXT,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,9)+1,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,10) - INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,9)-1) PATIENT_TYPE,";
			}
			else if(array[i].equals("CARD_ID")){
				QryCols = QryCols+"SUBSTR(SYS_DEF_MESSAGE_TEXT,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,10)+1,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,11) - INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,10)-1)  CARD_ID,";
			}
			else if(array[i].equals("CARD_ISSUE_DATE")){
				QryCols = QryCols+"SUBSTR(SYS_DEF_MESSAGE_TEXT,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,11)+1,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,12) - INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,11)-1)  CARD_ISSUE_DATE,";
			}
			else if(array[i].equals("CITIZEN_ID")){
//				QryCols = QryCols+"SUBSTR(SYS_DEF_MESSAGE_TEXT,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,12)+1)  CITIZEN_ID,";
				QryCols = QryCols+"SUBSTR(SYS_DEF_MESSAGE_TEXT,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,12)+1,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,13) - INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,12)-1) CITIZEN_ID,";
			}
			else{									  
				QryCols = QryCols+array[i]+",";	
			}
		}
		QryCols = QryCols.substring(0,QryCols.length()-1);


//	try
//	{  
		//facility	
		if((facility != null ) && (!(facility.equals(""))))			
		{
			whereClause =whereClause + " FACILITY_ID = NVL('"+facility+"',FACILITY_ID)";
//			flag=true;
		} 

		//application_id
		if( (applnname != null) && (!(applnname.equals(""))))			
		{
			whereClause =whereClause + " AND APPLICATION_ID = NVL('"+applnname+"',APPLICATION_ID) ";
		}																   

		//msgstatus
		if( (msg_status != null) && (!msg_status.equals("")))			
		{
			if(msg_status.equals(" "))
				whereClause =whereClause +" AND MESSAGE_STATUS IS NULL ";
			else
				whereClause =whereClause +" AND MESSAGE_STATUS = "+"NVL('"+msg_status+"',MESSAGE_STATUS)";
		}  

		//msg_id1
		if((msg_id1 != null) && (!(msg_id1.equals(""))))			
		{
			if((msg_id2 != null) && ((msg_id2.equals(""))))
			{
				whereClause = whereClause +" AND message_id >="+ 	
								"  nvl(lpad('"+msg_id1+"'',20),message_id)";
			}
			else
			{
				whereClause =whereClause +" AND message_id BETWEEN"+ 	
								"  nvl('"+msg_id1+"',message_id) AND nvl('"+msg_id2+"',message_id)";
			}
		} 

		//msg_id2
		if( (msg_id2 != null) && (!(msg_id2.equals(""))))			
		{		
			if((msg_id1 != null) && (!(msg_id1.equals("")))){}
			else
			{
				whereClause = whereClause +" AND message_id <"+ 	
								"  nvl('"+msg_id2+"',message_id)";
			}
		} 

		//msg_dt1

		String messageDateFrom = msg_dt1;
		String messageDateTo = msg_dt2;
		// Converting the message date from thai to english locale
		if("th".equalsIgnoreCase(locale) && ((msg_dt1 != null) && (!(msg_dt1.equals("")))))
		{
			messageDateFrom = com.ehis.util.DateUtils.convertDate(msg_dt1,"DMY","th","en");
			if(!("".equals(msg_dt2)))
			{
				messageDateTo = com.ehis.util.DateUtils.convertDate(msg_dt2,"DMY","th","en");
			}
		}

		if( (msg_dt1 != null) && (!(msg_dt1.equals(""))))			
		{
			whereClause =whereClause +" AND TO_DATE(MESSAGE_DATE) BETWEEN  "+  	
								"TO_DATE(NVL('"+messageDateFrom+"',TO_CHAR(MESSAGE_DATE,'dd/mm/yyyy')),'dd/mm/yyyy')"+
								" AND "+ "TO_DATE(NVL('"+messageDateTo+"',TO_CHAR(MESSAGE_DATE,'dd/mm/yyyy')),'dd/mm/yyyy')";
		} 


		//msg_dt2
		if( (msg_dt2 != null) && (!(msg_dt2.equals(""))))			
		{
			if((msg_dt1 != null) && (!(msg_dt1.equals("")))) {}
			else
			{
				whereClause = whereClause +" AND TO_DATE(MESSAGE_DATE) <  "+  								
								" TO_DATE(NVL('"+messageDateTo+"',TO_CHAR(MESSAGE_DATE,'dd/mm/yyyy')),'dd/mm/yyyy')";
			}
		}		

		if((order != null) && (order.equals("A")))
		{
			order="D";
		}
		else
		{
			order="A";
		}	

		if(orderBy != null && !orderBy.equals("")) {
				ResultQry = "Select "+QryCols+" FROM XB_EVENT_APPL_MESSAGE_XL_VW WHERE EVENT_TYPE = NVL('"+eventtype+"',EVENT_TYPE)  "+whereClause+"  ORDER BY "+orderBy; 
		}else {
  			    orderBy = " MESSAGE_ID";
				ResultQry = "Select "+QryCols+" FROM XB_EVENT_APPL_MESSAGE_XL_VW WHERE EVENT_TYPE = NVL('"+eventtype+"',EVENT_TYPE)  "+whereClause+"  ORDER BY "+orderBy; 
		}

	System.out.println("ResultQry : "+ResultQry);
	request.setAttribute("Query",ResultQry);	  
//  request.setAttribute("selectAll",selectAll);					 
	request.setAttribute("action_attr","");	     
	XHElectronicBillsControllerBean	xhBean = XHElectronicBillsControllerBean.getBean(XHElectronicBillsControllerBean.strBeanName,request,session);	   
	xhBean.action(request,con);					    
	HashMap resultsQry = xhBean.getResultSet(); 	
	ArrayList  arrRow = (ArrayList)resultsQry.get("qry_result"); 
		
//	System.out.println("ViewEventseBillResult.jsp QryCols : "+QryCols);
/*	request.setAttribute(XBQueryRender.strQueryId,qry_id);
	request.setAttribute(XBQueryRender.maxRec,"12");
	request.setAttribute(XBQueryRender.vwEvntsQuery,ResultQry);				  
	request.setAttribute(XBQueryRender.col,array.length);
	HashMap resultsQry = XBQueryRender.getResults(request,session,con);		  
*/
//	ArrayList arrRow = (ArrayList)resultsQry.get("qry_result"); 
//	System.out.println("arrRow.size() : "+arrRow.size());  
				ArrayList arrCol = null;
				boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
				boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
				String strPrevious = "Previous"; 
				String strNext  = "Next"; 
				if (boolPrevious == true)
				{
					strPrevious = "Previous"; 
				}
				else
				{
					strPrevious = " ";
				}
				if (boolNext== true)
				{
						strNext  = "Next"; 
				}
				else
				{
					strNext  = " ";
				}																   
			
if(arrRow.size()==0)
{  																	 
//	System.out.println("if arrRow.size() : "+arrRow.size());

            _bw.write(_wl_block9Bytes, _wl_block9);
 } else {
//	System.out.println("else arrRow.size() : "+arrRow.size());
	
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
 // if(authToRebuild || authToReplay){ 
            _bw.write(_wl_block12Bytes, _wl_block12);
 // } 
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf( strPrevious ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf( strNext ));
            _bw.write(_wl_block15Bytes, _wl_block15);
 if( !eventtype.equals("") && msg_status.equals("H") ) { 
            _bw.write(_wl_block16Bytes, _wl_block16);
 }	
            _bw.write(_wl_block1Bytes, _wl_block1);
	for(int i=0;i<array.length;i++)
		{
//				String name=array[i].replaceFirst("_"," ");					   
				String name=array[i].replace("_"," ");
// System.out.println("name : "+name);
		
//	if(name.equals("EVENT STATUS")) { 
            _bw.write(_wl_block17Bytes, _wl_block17);
// }
		if(name.equals("MESSAGE STATUS")) {
            _bw.write(_wl_block18Bytes, _wl_block18);
 } if(name.equals("MESSAGE ID")) {  
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(order));
            _bw.write(_wl_block20Bytes, _wl_block20);
 //} if(name.equals("APPLICATION ID")) { 
            _bw.write(_wl_block21Bytes, _wl_block21);
 }  if((name.trim()).equals("EVENT TYPE")) {
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(order));
            _bw.write(_wl_block23Bytes, _wl_block23);
 } if(name.equals("MESSAGE DATE")) { 
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(order));
            _bw.write(_wl_block25Bytes, _wl_block25);
 }  if(name.equals("FACILITY ID")) { 
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(order));
            _bw.write(_wl_block27Bytes, _wl_block27);
} if(name.equals("ACCESSION NUM")) { 
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(order));
            _bw.write(_wl_block29Bytes, _wl_block29);

		}
	}

            _bw.write(_wl_block30Bytes, _wl_block30);

		float amount = 0.00f;	
		String acc_nu_field="";
		String event_stat = "";
		String msg_stat = "";
		 String accnum="";
//		 int g=0;
//		 int acccount=1;
//		while(rs1.next()) {
			for (int j=0; j<arrRow.size();j++){
			   	
				String[] acc_number;
				arrCol = (ArrayList)arrRow.get(j);
//				System.out.println("arrcol(0) : "+XBDBAdapter.checkNull((String)arrCol.get(0)));
				String acc_num=XBDBAdapter.checkNull((String)arrCol.get(8));
			   if(acc_num.equals(""))
			   {

				}
				else
				{
			
//				 System.out.println("acc_num :"+acc_num);
				 acc_number=Regex1.split(acc_num);
				 accnum=acc_number[2].substring(1,acc_number[2].length());
//				   int accnumbers=Integer.parseInt(accnum);
//				 System.out.println(" accnumbers   "+accnumbers);

				 acc_nu_field=acc_number[0]+"$!"+acc_number[1]+"$!";	     
			
				   if(acccount==1)
					{
					   g=0;
					   String accQry="select  count(*) from XB_EVENT where ACCESSION_NUM like ('%"+acc_nu_field+"%') and EVENT_TYPE = NVL('"+(String)arrCol.get(5)+"',EVENT_TYPE) and event_status='S'";
//					   System.out.println("accQry 687 : "+accQry);
					   stmt1 = con.createStatement();		 
					   rs1 = stmt1.executeQuery(accQry);	
					  																									 
						 while(rs1.next()) { 	
							  acccount=rs1.getInt(1);		  										   
						 }
					}
					else
					{
						  if(acccount==1)
						{
						   g=0;
						}
						else
						{

						   acccount--;
						   g++;
						}
					}
				}
					   
				if (boolToggle == true)
				{
					strTDClass = "class='QRYEVEN'";
					boolToggle =  false;
				}
				else
				{
					strTDClass = "class='QRYODD'";
					boolToggle =  true;
				}

//			event_stat = XBDBAdapter.checkNull(rs1.getString("EVENT_STATUS"));
			event_stat = (String)arrCol.get(1);

//			msg_stat = XBDBAdapter.checkNull(rs1.getString("MESSAGE_STATUS"));
			msg_stat = (String)arrCol.get(2);

			if(event_stat.equalsIgnoreCase("S"))  EvntStatusColor="../../eXH/images/green_square.jpg" ;
			if(event_stat.equalsIgnoreCase("N"))  EvntStatusColor="../../eXH/images/black_square.jpg" ;
			if(event_stat.equalsIgnoreCase("E"))  EvntStatusColor="../../eXH/images/red_square.jpg" ;
			if(event_stat.equalsIgnoreCase("A"))  EvntStatusColor = "../../eXH/images/yello_square.jpg" ;
			if(event_stat.equalsIgnoreCase(""))  EvntStatusColor = "../../eXH/images/blue_square.jpg" ; 

			if(msg_stat.equalsIgnoreCase("S"))  MsgStatusColor="../../eXH/images/green_square.jpg" ;
			if(msg_stat.equalsIgnoreCase("A"))  MsgStatusColor="../../eXH/images/yello_square.jpg" ;
			if(msg_stat.equalsIgnoreCase("R"))  MsgStatusColor="../../eXH/images/black_square.jpg" ;
			if(msg_stat.equalsIgnoreCase("F"))  MsgStatusColor="../../eXH/images/pink_square.jpg" ;
			if(msg_stat.equalsIgnoreCase("E"))  MsgStatusColor="../../eXH/images/red_square.jpg" ;
			if(msg_stat.equalsIgnoreCase("H"))  MsgStatusColor="../../eXH/images/brown_square.gif" ;
 
            _bw.write(_wl_block31Bytes, _wl_block31);
 if( !eventtype.equals("") && msg_status.equals("H") ) { 
            _bw.write(_wl_block32Bytes, _wl_block32);
if(g==0)
				   { 
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf("select_yn_"+rsCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf((String)arrCol.get(0)));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(rsCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(acccount));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(((String)arrCol.get(0)).equals("Y")?"checked":""));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf("select_yn_dubli"+rsCount));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(arrCol.get(3)+"_check"));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf((String)arrCol.get(0)));
            _bw.write(_wl_block41Bytes, _wl_block41);
}else
	 {
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf("select_yn_"+rsCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf((String)arrCol.get(0)));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(rsCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(acccount));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(((String)arrCol.get(0)).equals("Y")?"checked":""));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf("select_yn_dubli"+rsCount));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(arrCol.get(3)+"_check"));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf((String)arrCol.get(0)));
            _bw.write(_wl_block45Bytes, _wl_block45);
}
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf("acc_no_"+rsCount));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf("acc_no_"+rsCount));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(acc_nu_field+"^"));
            _bw.write(_wl_block49Bytes, _wl_block49);
 } 
            _bw.write(_wl_block50Bytes, _wl_block50);
	for(int i=0;i<array.length;i++)
		{																	   
		String name=array[i].replaceFirst("_"," ");							  
		// System.out.println("name : "+name); MsgStatusColor width='3%' 
	//	if(name.equals("EVENT STATUS")) {
			
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(EvntStatusColor));
            _bw.write(_wl_block52Bytes, _wl_block52);
 //}
			if(name.equals("MESSAGE STATUS")) {
				
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(MsgStatusColor));
            _bw.write(_wl_block54Bytes, _wl_block54);
 } if(name.equals("MESSAGE ID")) {  
					
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(arrCol.get(3) ));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf("msg_id_"+rsCount));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf("msg_id_"+rsCount));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(arrCol.get(3).equals("")?"&nbsp;":arrCol.get(3)));
            _bw.write(_wl_block57Bytes, _wl_block57);
 //} if(name.equals("APPLICATION ID")) {		 
							
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(arrCol.get(3) ));
            _bw.write(_wl_block59Bytes, _wl_block59);
 } if((name.trim()).equals("EVENT TYPE")) { 
								
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(arrCol.get(5)));
            _bw.write(_wl_block61Bytes, _wl_block61);
 } if((name.trim()).equals("MESSAGE DATE")) { 
									
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(arrCol.get(6) ));
            _bw.write(_wl_block63Bytes, _wl_block63);
 }  if(name.equals("FACILITY ID")) { 
											
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(arrCol.get(7) ));
            _bw.write(_wl_block65Bytes, _wl_block65);

		}  if(name.equals("ACCESSION NUM")) { 
											
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(arrCol.get(8) ));
            _bw.write(_wl_block66Bytes, _wl_block66);

		} 											   



	}
	
            _bw.write(_wl_block67Bytes, _wl_block67);

	rsCount++;
} // end of rs.next() end of for
 
            _bw.write(_wl_block68Bytes, _wl_block68);
	for(int i=8;i<array.length;i++)
		{
//				String name=array[i].replaceFirst("_"," ");
				String name=array[i].replace("_"," ");
															   
		 if(name.equals("FACILITY NAME")) { 
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(order));
            _bw.write(_wl_block70Bytes, _wl_block70);
 } else if(name.equals("INV NO")) { 
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(order));
            _bw.write(_wl_block72Bytes, _wl_block72);
 }else  if(name.equals("INV DATE")) { 
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(order));
            _bw.write(_wl_block74Bytes, _wl_block74);
 }else if(name.equals("PATIENT ID")) { 
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(order));
            _bw.write(_wl_block76Bytes, _wl_block76);
 } else if(name.equals("INV AMOUNT")) { 		
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(order));
            _bw.write(_wl_block78Bytes, _wl_block78);
 }else if(name.equals("VISIT DATE")) { 
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(order));
            _bw.write(_wl_block80Bytes, _wl_block80);
 }else if(name.equals("PATIENT NAME")) { 
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(order));
            _bw.write(_wl_block82Bytes, _wl_block82);
 }else if(name.equals("PATIENT TYPE")) { 		
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(order));
            _bw.write(_wl_block84Bytes, _wl_block84);
 }else if(name.equals("CARD ID")) { 
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(order));
            _bw.write(_wl_block86Bytes, _wl_block86);
 }else if(name.equals("CARD ISSUE DATE")) { 
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(order));
            _bw.write(_wl_block88Bytes, _wl_block88);
 }else if(name.equals("CITIZEN ID")) { 		
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(order));
            _bw.write(_wl_block90Bytes, _wl_block90);
	} else if(name.equals("STATUS TEXT")) {  
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf((name.trim()).toLowerCase()));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(order));
            _bw.write(_wl_block92Bytes, _wl_block92);
 }else if(name.equals("LAST COMM START TIME")) {  
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf((name.trim()).toLowerCase()));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(order));
            _bw.write(_wl_block93Bytes, _wl_block93);
 } 
		 else if(name.equals("QUERY ID")) {  
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf((name.trim()).toLowerCase()));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(order));
            _bw.write(_wl_block94Bytes, _wl_block94);
 } else if(name.equals("EPISODE TYPE")) {  
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf((name.trim()).toLowerCase()));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(order));
            _bw.write(_wl_block95Bytes, _wl_block95);
 } 
		 else if(name.equals("EPISODE ID")) {  
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf((name.trim()).toLowerCase()));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(order));
            _bw.write(_wl_block96Bytes, _wl_block96);
 } else if(name.equals("APPLICATION NAME")) {  
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf((name.trim()).toLowerCase()));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(order));
            _bw.write(_wl_block97Bytes, _wl_block97);
 }  else{  
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf((name.trim()).toLowerCase()));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(order));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf((name.trim())));
            _bw.write(_wl_block99Bytes, _wl_block99);
 } 
		 }

            _bw.write(_wl_block100Bytes, _wl_block100);

//		 rs1.beforeFirst();
/*		stmt1 = con.createStatement();		 
		 rs1 = stmt1.executeQuery(ResultQry);	
		 rsCount = 0;
		 while(rs1.next()) { */
		 rsCount = 0;

		for (int j=0; j<arrRow.size();j++){
				arrCol = (ArrayList)arrRow.get(j);
//				System.out.println("878 arrCol :"+arrCol);

 
            _bw.write(_wl_block101Bytes, _wl_block101);
	for(int i=8;i<array.length;i++)
		{
		
//		 String name=array[i].replaceFirst("_"," ");
 		 String name=array[i].replace("_"," ");	

		 if(name.equals("FACILITY NAME")) {    
						
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(arrCol.get((i+1)).equals("")?"&nbsp;":arrCol.get((i+1)) ));
            _bw.write(_wl_block61Bytes, _wl_block61);

			} else if(name.equals("INV NO")) { 
						
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(arrCol.get((i+1)).equals("")?"&nbsp;":arrCol.get((i+1)) ));
            _bw.write(_wl_block61Bytes, _wl_block61);
 }else if(name.equals("INV DATE")) { 
										
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(arrCol.get((i+1)).equals("")?"&nbsp;":arrCol.get((i+1)) ));
            _bw.write(_wl_block61Bytes, _wl_block61);
 }else if(name.equals("PATIENT ID")) { 
										
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(arrCol.get((i+1)).equals("")?"&nbsp;":arrCol.get((i+1)) ));
            _bw.write(_wl_block61Bytes, _wl_block61);
 }else if(name.equals("INV AMOUNT")) { 
										
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(arrCol.get((i+1)).equals("")?"&nbsp;":arrCol.get((i+1))));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf("inv_amnt_"+rsCount));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf("inv_amnt_"+rsCount));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(arrCol.get((i+1)).equals("")?"&nbsp;":arrCol.get((i+1))));
            _bw.write(_wl_block108Bytes, _wl_block108);
	if(!arrCol.get((i+1)).equals("")) { amount = Float.parseFloat((String)arrCol.get((i+1)));
				 Tot_Inv_Amount = Tot_Inv_Amount+amount; }
		 } else if(name.equals("VISIT DATE")) { 
										
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(arrCol.get((i+1)).equals("")?"&nbsp;":arrCol.get((i+1)) ));
            _bw.write(_wl_block61Bytes, _wl_block61);
 }else if(name.equals("PATIENT NAME")) { 
			if(((String)arrCol.get((i+1))).length()>15) {
										
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf( arrCol.get((i+1)).equals("")?"&nbsp;":((String)arrCol.get((i+1))).substring(0,14) ));
            _bw.write(_wl_block110Bytes, _wl_block110);
 } else { 
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf( arrCol.get((i+1)).equals("")?"&nbsp;":arrCol.get((i+1)) ));
            _bw.write(_wl_block112Bytes, _wl_block112);
 } 
		}else if(name.equals("PATIENT TYPE")) { 
										
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf( arrCol.get((i+1)).equals("")?"&nbsp;":arrCol.get((i+1)) ));
            _bw.write(_wl_block61Bytes, _wl_block61);
 }else if(name.equals("CARD ID")) { 
										
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(arrCol.get((i+1)).equals("")?"&nbsp;":arrCol.get((i+1)) ));
            _bw.write(_wl_block61Bytes, _wl_block61);

			}else if(name.equals("CARD ISSUE DATE")) { 
										
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(arrCol.get((i+1)).equals("")?"&nbsp;":arrCol.get((i+1)) ));
            _bw.write(_wl_block61Bytes, _wl_block61);
 }else if(name.equals("CITIZEN ID")) { 
										
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(arrCol.get((i+1)).equals("")?"&nbsp;":arrCol.get((i+1))  ));
            _bw.write(_wl_block115Bytes, _wl_block115);
	} else { 
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf( arrCol.get((i+1)).equals("") || arrCol.get(i).equals("null")?"&nbsp;":arrCol.get((i+1))  ));
            _bw.write(_wl_block115Bytes, _wl_block115);
		
			}
		}
			
            _bw.write(_wl_block67Bytes, _wl_block67);

	rsCount++;
} // end of rs.next()
 
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(rsCount));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(Tot_Inv_Amount));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(styleExport));
            _bw.write(_wl_block119Bytes, _wl_block119);

 } // end of else
}catch(Exception e1)
{																							 
		System.out.println("ViewEventseBillResult.jsp Exc : "+e1.toString());
		e1.printStackTrace(System.err);
}
finally									 
{
			try{												  
			if(stmt1!=null)stmt1.close();							 						 
			if(rs1!=null)rs1.close();
			ConnectionManager.returnConnection(con);
				}catch(Exception e)
				{
				System.out.println("Exception in ViewEventseBillResult.jsp :  "+e);
				}			
}
		
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf( emptyString ));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf( rsCount ));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf( java.net.URLEncoder.encode(QryCols) ));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(java.net.URLEncoder.encode(whereClause)));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(Tot_Inv_Amount));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(msg_status));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(eventtype));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf( protocolLinkID ));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf( applnname ));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf( facility ));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(orderBy ));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(order));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(DataLinestr));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(totalMsgList));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(g));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(acccount));
            _bw.write(_wl_block136Bytes, _wl_block136);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.OutboundEvents.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
