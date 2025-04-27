package jsp_servlet._emo._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
import org.json.simple.*;
import java.util.*;
import com.ehis.util.*;

public final class __momanagedeceasedsearchresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emo/jsp/MOManageDeceasedSearchResult.jsp", 1742812645423L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<HTML>\n\t<head>\n\t\n\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\t\n\t<Script src=\"../../eCommon/js/jquery-3.6.3.js\" language=\"JavaScript\"></Script>\n\t<script src=\"../../eOP/js/menu.js\" language=\"JavaScript1.2\"></script>\n\t<script src=\"../../eMO/js/MOManageDeceased.js\"></script>\n\t<script src=\"../../eMO/js/MORegisterAttn.js\"></script>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n    <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script language=\'javascript\' src=\'../../eMO/js/MORegDetailsQuery.js\'> </script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\' > </script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n    ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<script>\n\tvar refreshparam;\n\tvar checkout_yn;\n\tvar queue_refresh_interval =parent.frames[1].document.forms[0].queue_refresh_interval.value;\n\tif(queue_refresh_interval != \"\"){\n\trefreshparam=queue_refresh_interval*60*1000;\n\tself.setInterval(\'callSamepage()\',refreshparam);\n\tparent.frames[1].document.getElementById(\'sys_date\').innerHTML = getCurrentDate(\"HM\",\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\");\t\n\n\t}else{\n\t\tvar msg=getMessage(\'CAN_NOT_BE_BLANK\',\'common\');\n\t\tmsg=msg.replace(\'$\',getLabel(\'Common.RefreshInterval.label\',\'common\'));\n\t\talert(msg);\n\t\tparent.frames[1].QueryLocnForDayResult.queue_refresh_interval.focus();\n\t\tparent.frames[1].document.forms[0].search.disabled=false;\n\t\tparent.frames[3].location.href=\'../../eCommon/html/blank.html\';\n   \n\t\t\n\t\t}\n    </script>\n ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n   \n \n\n\t\n\t</head>\n\t<body OnMouseDown=\'CodeArrest();\' onKeyDown = \'lockKey()\'>\n\t<form name=\'QueryLocnForDayResult\' id=\'QueryLocnForDayResult\' >\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t  \n\t  <script>//parent.MOFrame.location.href=\'../../eCommon/html/blank.html\';\n\t\t  alert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'common\')); </script> \n\t  ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t   <script>\n\t\t\t/*var oldurl = \tparent.MOFrame.location.href;\n\t\t\tif(oldurl.indexOf(\"blank.html\")!=-1)\n\t\t\t{\n\t\t\t\t\tparent.MOFrame.location.href=\'../../eMO/jsp/MOManagePatTabs.jsp\'; \n\t\t\t}*/\n\t\t\t</script> \n\t\t  ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\n\t\n   <table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'101%\' id=\'TitleTab\'>\n<tr>\n        <td align=left width=\'10%\'>\n            <table align=left >\n                \n            </table>\n        </td>\n        <td  width=\'10%\'>\n            <table  align=right>\n                <tr>\n                    <td >\n\t\n\n    ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n</td>\n                </tr>\n            </table>\n        </td>\n    </tr>\n</table>\n    <!--backgroundheader added by shagar for ML-MMOH-CRF-0749 -->\n\n \n\n\t<table border=\"1\" width=\"115%\" cellspacing=\'1px\' cellpadding=\'0\'>\n\t<th ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =">&nbsp;</th>\n\t<th ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" rowspan=1 >";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</th><!-- 22856 -->\n\t<th ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</th> \n\t<th ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" nowrap>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</th>\n    <th ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" align = \"center\" nowrap>\n\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&nbsp;";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\n\t<th ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</th>\n\t<th ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</th>\n\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t<th ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" </th>\n\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" nowrap >";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\t<!--nowrap removed below by Santhosh for ML-MMOH-CRF-1947>-->\n\t<th ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</th>\n\n\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t<tr><th ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" colspan=16 align=left><B>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</B></th></tr>\n\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t<tr><th ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="/";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</B></th></tr>\n\t<tr>\n\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =" \n\t<td style=\'background-color:maroon;color:white\' width=\'3%\'>&nbsp;P</td>\n\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t<td style=\'background-color:yellow;color:maroon\' width=\'3%\'>&nbsp;P</td>\n\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t<td>&nbsp;</Td>\n\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t<td>";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =" </td><!-- 22856 -->\n\t<td class=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="> <font size=\'1\'>";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</td>\n\t<td class=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</td>\n\n\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="<!--Below Script Condition Changed Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg-->\n        <td  style=\'background-color:black;color:white;\'>\n\t\t<a name=\'desc1\' style=\"color:white\" href=\'javascript:showOperations(\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\",\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\")\' > <font size=1>";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</a></td>\t\n\t\n\t\t ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t<td class=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 =">\n\t\t<a name=\'desc1\' href=\'javascript:showOperations(\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</a></td>\t\n\t ";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\t\t\n\t\t<td  style=\'background-color:black;\'>\n\t\t<a name=\'desc1\' style=\"color:white\" \n\t\thref=\'javascript:showAllowedOperations(\"a\",\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</a></td>\n\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="<!--Below Script Condition Changed Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg-->\n\t\t<td class=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 =">\n\t\t<a name=\'desc1\' href=\'javascript:showAllowedOperations(\"a\",\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</a></td>\n\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t<td  style=\'background-color:black;\'>\n     <a name=\'desc1\' style=\"color:white\"  href=\'javascript:showChart(\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</a></td>\t\n\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t        <td class=\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 =">\n\t\t\t<a name=\'desc1\'href=\'javascript:showChart(\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\n\t\n\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t   <!-- <td  style=\'background-color:black;color=white\' > -->\n\t\t<!-- <font size=1>";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</td> -->\t\n\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t<!-- <td class=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 =">\t -->\n\t\t<!-- <font size=1>";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="</td> -->\n\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\t<!--Below Script Condition Changed Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg-->\t\n\t\t<td  style=\'background-color:black;\'>\n\t   <a name=\'desc1\' style=\'color:white\' href=\'javascript:showOperations(\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</a></td>\t\n\t\n\t   ";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="<!--Below Script Condition Changed Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg-->\n\t \t<td class=\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 =">\n\t\t <a name=\'desc1\' href=\'javascript:showOperations(\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\t\t\n\t\t <!--Below Script Condition Changed Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg-->\n\t\t <td  style=\'background-color:black;color:white;\'>\n\t\t <a name=\'desc1\' style=\'color:white\'  href=\'javascript:showAllowedOperations(\"b\",\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\")\' ><font size=1>";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="</a></td>\n\t\t\n\t\t ";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t<!--Below Script Condition Changed Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg-->\n\t\t<td class=\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 =">\n\t\t<a name=\'desc1\'  href=\'javascript:showAllowedOperations(\"b\",\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="</a></td>\n\t\t ";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 =">\n\t\t<a name=\'desc1\'  href=\'javascript:RevertRelease(\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t\t<td  style=\'background-color:black;color:white\'>\n\t\t    <a name=\'desc1\' style=\'color:white\' ; href=\"javascript:showChart(\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\',\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\')\" ><font size=1>";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t\t\t\n\t\t<td class=\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 =">\n\t\t<a name=\'desc1\' href=\"javascript:showChart(\'";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t<!-- <td  style=\'background-color:black;color:white\'>\n\t\t<font size=1>";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="</td> -->\n\t\t";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t\t\t<!-- <td class=\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="  ><font size=1>";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="</td> -->\n\t\t\t\n\t\t";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t<td class=\'";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="> <font size=1>";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="</td> \n\t<td class=\'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="> <font size=1>&nbsp;&nbsp;";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 =" nowrap> <font size=1>";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="</td>\n\t";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n\t <td class=\'";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="> <font size=1>&nbsp;</td>\n\t ";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="</td>\n\t\t";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\t\t";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="><font size=1> ";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n\n\t";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="<!--Style Added by Santhosh for ML-MMOH-CRF-1947>-->\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 =" style=\'word-wrap:break-word;width:300px;\'> <font size=1>";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\n\t\t</tr>\n\t";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\n\t      <script>//parent.MOFrame.location.href=\'../../eCommon/html/blank.html\';\n\t\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'common\'));</script> \n\t    ";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\n\t\t\t <script>\n\t\t\t\t\t/*var oldurl = \tparent.MOFrame.location.href;\n\t\t\t\t\tif(oldurl.indexOf(\"blank.html\")!=-1)\n\t\t\t\t\t{\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tparent.MOFrame.location.href=\'../../eMO/jsp/MOManagePatTabs.jsp\';\n\t\t\t\t\t}*/\n\n\t\t\t</script> \n\t\t\t";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n\t\n\t \t<p>\n    <table align=\'right\'>\n    <tr>\n    <td>\n\t\n    ";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\n</td>\n</tr>\n</table >\n</p>\n<BR><BR>\n\t  <!-- backgroundheader added by shagar for ML-MMOH-CRF-0749-->\n\t  <table border=\"1\" width=\"115%\" cellspacing=\'1px\' cellpadding=\'0\'>\n\t<th ";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="> ";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 =" align = \"center\">\n\t";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n\t</td>\n\n\t<th ";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 =" </th>\n\t ";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 =" colspan=13 align=left><B>";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 =" \n\t<td style=\'background-color:maroon;color:white\' width=3%>&nbsp;P</td>\n\t";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\n\t<td style=\'background-color:yellow;color:maroon\' width=3%>&nbsp;P</td>\n\t";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 =" > <font size=1>";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="</td>\n\t\n\t";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\n\t\t<!--Below Script Condition Changed Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg-->\n\t\t<td  style=\'background-color:black;color:white;\'>\n\t\t\n\t\t<a name=\'desc1\'style=\"color:white\"  href=\'javascript:showOperations(\"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="</a></td>\t\n        ";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\t\n\t\t<!--Below Script Condition Changed Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg-->\n\t\t<td class=\'";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="</a></td>\t\n        \n\t\t";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\n\t\t<!--Below Script Condition Changed Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg-->\n\t\t<td  style=\'background-color:black;color:white;\'>\n\t\t<a name=\'desc1\' style=\'color:white\' href=\'javascript:showAllowedOperations(\"a\",\"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\t\t\n\t\t<!--Below Script Condition Changed Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg-->\n\t\t<td class=\'";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 =">\n\t\t<a name=\'desc1\'  href=\'javascript:showAllowedOperations(\"a\",\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="</a></td>\n\t\t\n\t";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\n\t\t<td  style=\'background-color:black;color:white;\'>\n\t\t<a name=\'desc1\' style=\"color:white\" href=\'javascript:showChart(\"";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="</a></td>\t\n\t\t\n\t\t\t";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="><a name=\'desc1\' href=\'javascript:showChart(\"";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\n\t\t\n\t";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\n\t\t<!-- <font size=1>";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 =" -->\n\t\t";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\n\t\t<!--Below Script Condition Changed Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg-->\n\t\t<td  style=\'background-color:black;color:white;\'>\n\t\t<a name=\'desc1\'style=\"color:white\"  \n\t   href=\'javascript:showOperations(\"";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="</a></td>\t\n\t";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\n\t<!--Below Script Condition Changed Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg-->\n\t<td class=\'";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 =">\n\t   <a name=\'desc1\' href=\'javascript:showOperations(\"";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\n\t\t\t{<td  style=\'background-color:black;color:white;\'>\n\t\t<!--Below Script Condition Changed Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg-->\n\t\t<a name=\'desc1\'style=\"color:white\"  \n\t  href=\'javascript:showAllowedOperations(\"b\",\"";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="</a></td>}\n\t\t";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 =">\n\t   <a name=\'desc1\' href=\'javascript:showAllowedOperations(\"b\",\"";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 =">\n\t\t<a name=\'desc1\'  href=\'javascript:RevertRelease(\"b\",\"";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\n\t\t\t<td  style=\'background-color:black;color:white;\'>\n\t\t   <a name=\'desc1\'  style=\'color:white;\'href=\"javascript:showChart(\'";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="</a></td>\n\t\t\t";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 =">\n\t\t\t<a name=\'desc1\' href=\"javascript:showChart(\'";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\t\n\t\t";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="<!-- <td  style=\'background-color:black;color:white;\'> -->\n\t\t<!-- <font size=1>";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="</td> -->\n\t\t\t";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\n\t\t\n\t\t";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\'";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\n\t\n\t";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\n\t</table>\n\t\n\t\n\t<br><center>\n\t";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\n\t<script>parent.frames[0].document.forms[0].search.disabled=false</script>\n\t  ";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\n\t<script>parent.frames[1].document.forms[0].search.disabled=false</script>\n\t";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\n\t</center>\n<input type=\'hidden\' name=\'called_from_ca\' id=\'called_from_ca\' value=";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 =">\n<input type=\'hidden\' name=\'parameters\' id=\'parameters\' value=";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 =">\n<input type=\'hidden\' name=\'callfrommoreg\' id=\'callfrommoreg\' value=\"";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\">\n<input type=\'hidden\' name=\'registration_no\' id=\'registration_no\' value=\"";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\">\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\">\n<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\"";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\">\n<input type=\'hidden\' name=\'burial_permit_reqd_yn\' id=\'burial_permit_reqd_yn\' value=\"";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\">\n\n    ";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\n\t\n\t<input type=\'hidden\' name=\'queue_refresh_interval\' id=\'queue_refresh_interval\' value=\"";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\">\n ";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\n<input type=\'hidden\' name=\'embalm_completed\' id=\'embalm_completed\' id=\"embalm_completed\" value=\"\">\n<!-- Below line added for this ML-MMOH-CRF-0860.2-->\n<input type=\'hidden\' name=\'increasedaddressLength\' id=\'increasedaddressLength\' id=\"increasedaddressLength\" value=\"";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\"> \n\n</form>\n</body>\n\n</html>\n\n";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\n\n\n";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

	// To Handle java.lang.NullPointerException.
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equalsIgnoreCase("null"))) ? "" : inputString );
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
	}


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
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History      Name			Description
--------------------------------------------------------------------------------------------------------------
22-06-2023        22856      Srinivasa N T                      22-06-2023            Ramesh G    ML-MMOH-CRF-1778
---------------------------------------------------------------------------------------------------------------
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

	String locale = ((String)session.getAttribute("LOCALE"));
	int cnt=0;
	String backgroundheader="style='color:black'";
	String causeOfDeathReg="N";        
	String colordisplay="";
	String  no_days_mortuary="";
	String  burial_permit_reqd_yn="N";
	String  HOURS="";
	String  MINUTES="";
	String  RELIGION="";
	String	REGISTRATION_NO		 = "";
	String	MO_REGN_DATE_TIME	 = "";
	String	PATIENT_NAME		 = ""; 
	String	PATIENT_ID			 = ""; 
	String	AGE					 = "";	
	String	SEX					 = "";
	//String	sex_converted		 = "" ;
	String	PM_YN				 = "";	
	String  pm_yn_converted      = "" ;
	String  encounter_id		 = "";
	String	POSTMORTEM_STATUS	 = "";
	String brought_dead_yn       =""; 
	String bur_per_no="";
	String postmortem_type ="";
	String area_type_desc="";
	String highriskbody="";
	String dispose_body_yn="";
	String  AREA_TYPE			 = "";
	String	assign_area_code	 = "";	
	String	assign_area_code_desc	 = "";	

	String	assign_area_desc	 = "";	
    String or_installyn          ="";  
	String  bed_no               = "";
    String order_catalog_code ="";
    String rfid_tag_num ="";
	String POSTMORTEM_STATUS_DESC="";
	String BODY_PART_OBTAINED_FROM_DESC="";
	String queue_refresh_interval="0";
    String BDY_PRT_OBT_FROM="";
    request.setCharacterEncoding("UTF-8");

	String fac_id				 = (String) session.getValue( "facility_id" ) ;
	String login_user			= (String) session.getValue("login_user");//Added by Ajay Hatwate for MMS-DM-CRF-0210.1
	StringBuffer  sql				     = new StringBuffer();
	String assign_area_code_prev = "";
	String patient_class	= "";
	String area_code	        = request.getParameter("area_code");
	String registration_id		= request.getParameter("registration_no");
	String patient_id			= request.getParameter("patient_id");
	String function_id			= request.getParameter("function_id");
    if(function_id == null) function_id = "";

	String burial_permit_no		= request.getParameter("burial_permit_no")==null?"":request.getParameter("burial_permit_no");
	String obtained_from			= request.getParameter("obt_frm")==null?"":request.getParameter("obt_frm");
	
	StringBuffer sql1 = new StringBuffer();
	String gender				= request.getParameter("gender");
	String parameters			=  request.getQueryString() ;
	if(parameters==null)parameters="";
	String called_from_ca		= request.getParameter("called_from_ca")==null?"N":request.getParameter("called_from_ca");
	String callfrommoreg		= request.getParameter("callfrommoreg")==null?"":request.getParameter("callfrommoreg");
	 

	String BODY_PART_OBTAINED_FROM		= request.getParameter("body_part_obtained_from")==null?"":request.getParameter("body_part_obtained_from");

	if(callfrommoreg.equals("callfrommanage"))callfrommoreg="";

	StringBuffer sql2 = new StringBuffer();
	int count = 0;
	String frmdate					  = request.getParameter("frmdate")==null||request.getParameter("frmdate").equals("")?"01/01/1800 00:00":request.getParameter("frmdate");
	String todate                     = request.getParameter("todate")==null?"":request.getParameter("todate");
    String atype                      = request.getParameter("atype")==null?"":request.getParameter("atype");
	String pmstatus					  = request.getParameter("pmstatus")==null?"":request.getParameter("pmstatus");
	String rstatus                    = request.getParameter("rstatus")==null?"":request.getParameter("rstatus");
	String CLAIMANT_TYPE  			  ="";   // Added Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg
	String RELEASE_TO_FACILITY		  ="";   // Added Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg


	String external="N";
	if(area_code == null || area_code.equals("null"))    area_code = "";
	if(registration_id == null || registration_id.equals("null"))	   registration_id = "";
	if(patient_id == null || patient_id.equals("null"))				   patient_id = "";
	if(gender == null || gender.equals("null"))						   gender = "";
    if(gender.equals("M"))											
	gender="MALE";
	else if(gender.equals("F"))										
	gender="FEMALE";

	int i			= 1;
	int maxRecord	= 0;
	java.sql.Statement stmt	= null;
	ResultSet rset	= null;
	java.sql.Statement stmt1	= null;
	ResultSet rset1	= null;
    Connection conn = null;
    PreparedStatement pstmt = null;
    String hide_pat_unauth_pract = "N";
   	String access_res_pat_yn = "N";

	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	int start = 0 ;
	int end = 0 ;
	int l=1;
    if ( from == null )
	start = 1 ;
	else
	start = Integer.parseInt( from ) ;
    if ( to == null )
	end = 8 ;
	else
	end = Integer.parseInt( to ) ;
        int sCount=start;//22856
	 //Added for this CRF ML-MMOH-CRF-0860.2
	 Boolean increasedaddressLength=false;

	try {
		
		conn     = ConnectionManager.getConnection(request);	
		stmt	 = conn.createStatement();
		
	//Added for this CRF ML-MMOH-CRF-0860.2
	 increasedaddressLength = eCommon.Common.CommonBean.isSiteSpecific(conn, "MP","INCREASED_ADDRESS_LINE_LENGTH");
				JSONObject json = new JSONObject(); // added by mujafar for ML-MMOH-CRF-0996 start
				json			 = eMO.MOCommonBean.getMOParam(conn, fac_id); 
				String enable_rfid_yn = (String)json.get("enable_rfid_yn"); // added by mujafar for ML-MMOH-CRF-0996 end


            _bw.write(_wl_block6Bytes, _wl_block6);

     String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
 
	if(callfrommoreg.equals("") || callfrommoreg.equals("releaseDeceased")  ){
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block10Bytes, _wl_block10);
 } 
            _bw.write(_wl_block11Bytes, _wl_block11);


	//Added by Ajay Hatwate for MMS-DM-CRF-0210
    pstmt = conn.prepareStatement("select (select HIDE_PAT_UNAUTH_PRACT_YN from CA_PARAM_BY_FACILITY where facility_id = ?) hide_pat_unauth_pract_yn, (SELECT a.access_res_pat_yn FROM ca_access_view_restr_patient a WHERE a.practitioner_id = (SELECT func_role_id FROM sm_appl_user WHERE appl_user_id = ?) AND a.facility_id = ? AND (   (    a.access_from_date IS NULL AND a.access_to_date IS NOT NULL AND TO_DATE (SYSDATE, 'DD/MM/YYYY') <= TO_DATE (a.access_to_date, 'DD/MM/YYYY') ) OR (    a.access_from_date IS NOT NULL AND a.access_to_date IS NULL AND TO_DATE (SYSDATE, 'DD/MM/YYYY') >= TO_DATE (a.access_from_date, 'DD/MM/YYYY') ) OR (    a.access_from_date IS NOT NULL AND a.access_to_date IS NOT NULL AND TO_DATE (SYSDATE, 'DD/MM/YYYY') >= TO_DATE (a.access_from_date, 'DD/MM/YYYY') AND TO_DATE (SYSDATE, 'DD/MM/YYYY') <= TO_DATE (a.access_to_date, 'DD/MM/YYYY') ) ))access_res_pat_yn from dual ");
   	pstmt.setString(1, fac_id);
   	pstmt.setString(2, login_user);
   	pstmt.setString(3, fac_id);
   	rset = pstmt.executeQuery();
   	rset.next();
   	hide_pat_unauth_pract = checkForNull(rset.getString("hide_pat_unauth_pract_yn"),"N");
   	access_res_pat_yn = checkForNull(rset.getString("access_res_pat_yn"), "N");
   // System.out.println(hide_pat_unauth_pract + " : hide_pat_unauth_pract; " +access_res_pat_yn + " : access_res_pat_yn");
    if(pstmt!=null) pstmt.close();
    if(rset!=null) rset.close();
	//End of MMS-DM-CRF-0210
	
	
	

	String orinst="Select OPERATIONAL_YN from SM_MODULES_FACILITY where module_id='OR' and FACILITY_ID='"+fac_id+"'";
     rset = stmt.executeQuery(orinst);	
     if(rset.next())
	 {
	  or_installyn=rset.getString("OPERATIONAL_YN")==null?"":rset.getString("OPERATIONAL_YN");
	 }
	 if(rset!=null)rset.close();
	 if(stmt!=null)stmt.close();
	
   if((or_installyn.equals("Y")) && (!(callfrommoreg.equals("callfrommoreg"))))
	{
    sql.setLength(0);
	sql.append(" where NVL(BODY_PART_OBTAINED_FROM,'*') like '"+BODY_PART_OBTAINED_FROM+"%' and postmortem_status like '"+pmstatus+"%' and  facility_id='"+fac_id+"' and NVL(area_code,decode(registration_no,null,'$','*')) like '"+area_code+"%' and  NVL(patient_id,'*') like '"+patient_id+"%' and sex like '"+gender+"%' and NVL(registration_no,'*') like '"+registration_id+"%' and NVL(AREA_TYPE,'*') like '"+atype+"%' and (to_date(substr(BODY_RECEIVED_DATE,1,10),'dd/mm/yyyy') between to_date('"+frmdate+"','dd/mm/yyyy')  ");
	
	if(!todate.equals(""))
	 {
	 sql.append(" and to_date('"+todate+"','dd/mm/yyyy'))");
	 }else
	  {
	  sql.append(" and sysdate");
	  }
	 //sql.append(" or to_date(substr(ord_date_time,1,10),'dd/mm/yyyy') between to_date('"+frmdate+"','dd/mm/yyyy') ");
	 if(!todate.equals(""))
	 {
	 //sql.append(" and to_date('"+todate+"','dd/mm/yyyy'))");
	  }else
	  {
	     //sql.append(" and sysdate)");
	  }
	  
	   if(callfrommoreg.equals("RevertRelease")){
		 sql.append("  AND release_body_date is not null ");
	  }else{
		sql.append("and (('"+rstatus+"' is null) or ( '"+rstatus+"' is not null and '"+rstatus+"'='C' and release_body_date is null) or ('"+rstatus+"' is not null and '"+rstatus+"'='R' and release_body_date is not null ))");
	  }
	
	 if(callfrommoreg.equals("releaseDeceased"))
	  {
		 sql.append("  AND area_type = 'R' ");
	  }
	 if(callfrommoreg.equals("ExpoOfDeceased"))
	  {
		 sql.append("  AND exportation_doc_iss_date IS NULL AND exportation_reqd_yn = 'Y'  ");
	  }
	 
	 if(obtained_from.equals("C"))
     {
       sql.append(" and  BODY_PART_OBTAINED_FROM is  null");
     }else if(obtained_from.equals("A")||obtained_from.equals("U")||obtained_from.equals("D")||(!obtained_from.equals("C")))
     {
       sql.append(" and  BODY_PART_OBTAINED_FROM like '"+obtained_from+"%'");
     }else 
	  if(callfrommoreg.equals(""))
	  {
	  }else
	  if(callfrommoreg.equals("callfrombdyprt"))
	  {
	    sql.append(" and  BODY_PART_OBTAINED_FROM is not null");
	  }else if(callfrommoreg.equals("callfrommoreg"))
	  { sql.append(" and  BODY_PART_OBTAINED_FROM is  null");
	  }

      sql.append(" and  NVL(BURIAL_PERMIT_NO,'*') LIKE '"+burial_permit_no+"%'");
      //Added by Ajay Hatwate fior MMS-DM-CRF-0210
     if(access_res_pat_yn.equals("N") && hide_pat_unauth_pract.equals("Y")){
    	 sql.append(" and patient_id in (select patient_id from mp_patient mp where mp.patient_id = patient_id  and mp.restrict_reinstate_yn ='N') ");
     }
	
	  sql.append(" order by area_code,registration_no");	  
	
	
	  sql1.append("select count(distinct(registration_no))total from MO_MANAGE_DECEASED_VW ");
	  
	  sql1.append(sql.toString());
	  if(stmt!=null)stmt.close();
	  if(rset!=null)rset.close();

	  stmt	 = conn.createStatement();
	  rset = stmt.executeQuery(sql1.toString());	
      sql1.setLength(0);
	  if(rset.next())
	  maxRecord = rset.getInt("total");
	  if(maxRecord == 0) 
		{
		  
            _bw.write(_wl_block12Bytes, _wl_block12);

		}
	  else 
		{ 
		  
            _bw.write(_wl_block13Bytes, _wl_block13);

	/*  sql1.append("select BODY_PART_OBTAINED_FROM, HIGH_RISK_BODY_YN,MO_GET_DESC.MO_AREA(AREA_CODE,'"+localeName+"','2') AREA_DESC,AREA_TYPE_DESC,AREA_CODE,REGISTRATION_NO,BODY_RECEIVED_DATE, decode('"+localeName+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name)) PATIENT_NAME,PATIENT_ID, AGE, SEX, PM_YN, POSTMORTEM_STATUS,POSTMORTEM_STATUS_DESC, AREA_TYPE,BED_NO,ENCOUNTER_ID, DISPOSE_BODY_YN, MLC_YN,BROUGHT_DEAD_YN,POSTMORTEM_TYPE, POSTMORTEM_TYPE_DESC, STATUS, ORDER_CATALOG_CODE,RELEASE_BODY_DATE,BODY_PART_OBTAINED_FROM_DESC,BURIAL_PERMIT_NO from MO_MANAGE_DECEASED_VW"); */
	    //sql1.append("SELECT EXTERNAL_YN,body_part_obtained_from, high_risk_body_yn, area_desc, area_type_desc,area_code, registration_no, body_received_date, patient_name,patient_id, age, sex, pm_yn, postmortem_status, postmortem_status_desc,area_type, bed_no, encounter_id, dispose_body_yn, mlc_yn, brought_dead_yn, postmortem_type, postmortem_type_desc, status, order_catalog_code, release_body_date, body_part_obtained_from_desc, burial_permit_no,FLOOR (NVL (TO_DATE (release_body_date, 'DD/MM/YYYY HH24:MI'), SYSDATE) - TO_DATE (body_received_date, 'DD/MM/YYYY HH24:MI')) no_days_mortuary,trunc(((NVL (TO_DATE (release_body_date, 'DD/MM/YYYY HH24:MI'),SYSDATE ) - TO_DATE (body_received_date, 'DD/MM/YYYY HH24:MI') ) - trunc((NVL (TO_DATE (release_body_date, 'DD/MM/YYYY HH24:MI'),SYSDATE ) - TO_DATE (body_received_date, 'DD/MM/YYYY HH24:MI')))) * 24) hours,trunc(((((NVL (TO_DATE (release_body_date, 'DD/MM/YYYY HH24:MI'), SYSDATE )  - TO_DATE (body_received_date, 'DD/MM/YYYY HH24:MI')  ) - trunc((NVL (TO_DATE (release_body_date, 'DD/MM/YYYY HH24:MI'), SYSDATE ) - TO_DATE (body_received_date, 'DD/MM/YYYY HH24:MI')))) * 24) - trunc(((NVL (TO_DATE (release_body_date, 'DD/MM/YYYY HH24:MI'),SYSDATE ) - TO_DATE (body_received_date, 'DD/MM/YYYY HH24:MI')) - trunc((NVL (TO_DATE (release_body_date, 'DD/MM/YYYY HH24:MI'),SYSDATE ) - TO_DATE (body_received_date, 'DD/MM/YYYY HH24:MI')))) * 24)) *60) minutes,religion,(select BURIAL_PERMIT_REQD_YN from MO_PARAMETER where facility_id = '"+fac_id+"') burial_permit_reqd_yn,rfid_tag_num FROM mo_manage_deceased_vw");
	// Below Query Modified Against CRF Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg	
	sql1.append("SELECT EXTERNAL_YN,body_part_obtained_from, high_risk_body_yn, area_desc, area_type_desc,area_code, registration_no, body_received_date, patient_name,patient_id, age, sex, pm_yn, postmortem_status, postmortem_status_desc,area_type, bed_no, encounter_id, dispose_body_yn, mlc_yn, brought_dead_yn, postmortem_type, postmortem_type_desc, status, release_body_date, body_part_obtained_from_desc, burial_permit_no,FLOOR (NVL (TO_DATE (release_body_date, 'DD/MM/YYYY HH24:MI'), SYSDATE) - TO_DATE (body_received_date, 'DD/MM/YYYY HH24:MI')) no_days_mortuary,trunc(((NVL (TO_DATE (release_body_date, 'DD/MM/YYYY HH24:MI'),SYSDATE ) - TO_DATE (body_received_date, 'DD/MM/YYYY HH24:MI') ) - trunc((NVL (TO_DATE (release_body_date, 'DD/MM/YYYY HH24:MI'),SYSDATE ) - TO_DATE (body_received_date, 'DD/MM/YYYY HH24:MI')))) * 24) hours,trunc(((((NVL (TO_DATE (release_body_date, 'DD/MM/YYYY HH24:MI'), SYSDATE )  - TO_DATE (body_received_date, 'DD/MM/YYYY HH24:MI')  ) - trunc((NVL (TO_DATE (release_body_date, 'DD/MM/YYYY HH24:MI'), SYSDATE ) - TO_DATE (body_received_date, 'DD/MM/YYYY HH24:MI')))) * 24) - trunc(((NVL (TO_DATE (release_body_date, 'DD/MM/YYYY HH24:MI'),SYSDATE ) - TO_DATE (body_received_date, 'DD/MM/YYYY HH24:MI')) - trunc((NVL (TO_DATE (release_body_date, 'DD/MM/YYYY HH24:MI'),SYSDATE ) - TO_DATE (body_received_date, 'DD/MM/YYYY HH24:MI')))) * 24)) *60) minutes,religion,(select BURIAL_PERMIT_REQD_YN from MO_PARAMETER where facility_id = '"+fac_id+"') burial_permit_reqd_yn,rfid_tag_num,(Select CLAIMANT_TYPE from MO_CLAIMANT_VW where FACILITY_ID=mo_manage_deceased_vw.FACILITY_ID and REGISTRATION_NO=mo_manage_deceased_vw.REGISTRATION_NO and PATIENT_ID=mo_manage_deceased_vw.PATIENT_ID)CLAIMANT_TYPE, (Select RELEASE_TO_FACILITY from MO_CLAIMANT_VW where FACILITY_ID=mo_manage_deceased_vw.FACILITY_ID and REGISTRATION_NO=mo_manage_deceased_vw.REGISTRATION_NO and PATIENT_ID=mo_manage_deceased_vw.PATIENT_ID)RELEASE_TO_FACILITY FROM mo_manage_deceased_vw");
		
	  sql1.append(sql.toString());
      if(rset!=null)rset.close();
      if(stmt!=null)stmt.close();
	  stmt	 = conn.createStatement();
	  rset = stmt.executeQuery(sql1.toString());
	  sql1.setLength(0);
	
            _bw.write(_wl_block14Bytes, _wl_block14);

if ( !(start <= 1) )
	out.println("<A HREF='../jsp/MOManageDeceasedSearchResult.jsp?function_id="+function_id+"&from="+(start-8)+"&to="+(end-8)+"&area_code="+URLEncoder.encode(area_code)+"&registration_no="+URLEncoder.encode(registration_id)+"&patient_id="+URLEncoder.encode(patient_id)+"&burial_permit_no="+URLEncoder.encode(burial_permit_no)+"&obt_frm="+URLEncoder.encode(obtained_from)+"&gender="+URLEncoder.encode(gender)+"&called_from_ca="+URLEncoder.encode(called_from_ca)+"&callfrommoreg="+URLEncoder.encode(callfrommoreg)+"&body_part_obtained_from="+URLEncoder.encode(BODY_PART_OBTAINED_FROM)+"&frmdate="+URLEncoder.encode(frmdate)+"&todate="+URLEncoder.encode(todate)+"&atype="+URLEncoder.encode(atype)+"&pmstatus="+URLEncoder.encode(pmstatus)+"&rstatus="+URLEncoder.encode(rstatus)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+8) > maxRecord ) )
	out.println("<A HREF='../jsp/MOManageDeceasedSearchResult.jsp?function_id="+function_id+"&from="+(start+8)+"&to="+(end+8)+"&area_code="+URLEncoder.encode(area_code)+"&registration_no="+URLEncoder.encode(registration_id)+"&patient_id="+URLEncoder.encode(patient_id)+"&burial_permit_no="+URLEncoder.encode(burial_permit_no)+"&obt_frm="+URLEncoder.encode(obtained_from)+"&gender="+URLEncoder.encode(gender)+"&called_from_ca="+URLEncoder.encode(called_from_ca)+"&callfrommoreg="+URLEncoder.encode(callfrommoreg)+"&body_part_obtained_from="+URLEncoder.encode(BODY_PART_OBTAINED_FROM)+"&frmdate="+URLEncoder.encode(frmdate)+"&todate="+URLEncoder.encode(todate)+"&atype="+URLEncoder.encode(atype)+"&pmstatus="+URLEncoder.encode(pmstatus)+"&rstatus="+URLEncoder.encode(rstatus)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");


            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(backgroundheader));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(backgroundheader));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(backgroundheader));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(backgroundheader));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(backgroundheader));
            _bw.write(_wl_block23Bytes, _wl_block23);
if(obtained_from.equals("C"))
     {
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
}else{
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
}
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(backgroundheader));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(backgroundheader));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(backgroundheader));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(backgroundheader));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(backgroundheader));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(backgroundheader));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(backgroundheader));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(backgroundheader));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(backgroundheader));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

	if(enable_rfid_yn.equals("Y")) // added by mujafar for ML-MMOH-CRF-0996
	{
	
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(backgroundheader));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

	}
	if(!obtained_from.equals("C"))
     {
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(backgroundheader));
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
}
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(backgroundheader));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);
 
	String classValue	= "";
	int rowIndex		= 1;
	if ( start != 1 )
	for( int j=1; j<start; l++,j++ ){
	rset.next() ;
    }
	while (rset.next()&&l<=end)
	{
	classValue				=	((rowIndex%2)==0)? "QRYEVEN" : "QRYODD";
	rowIndex++;
	
	//order_catalog_code		= rset.getString("order_catalog_code");
	//order_catalog_code= (order_catalog_code == null)?"":order_catalog_code;
	CLAIMANT_TYPE		= rset.getString("CLAIMANT_TYPE");   // Added Against Bru-HIMS-CRF-366 [IN-039612]
	CLAIMANT_TYPE= (CLAIMANT_TYPE == null)?"":CLAIMANT_TYPE; // Added Against Bru-HIMS-CRF-366 [IN-039612]
	RELEASE_TO_FACILITY		= rset.getString("RELEASE_TO_FACILITY");  //Added Against Bru-HIMS-CRF-366 [IN-039612]
	RELEASE_TO_FACILITY= (RELEASE_TO_FACILITY == null)?"":RELEASE_TO_FACILITY; //Added Against Bru-HIMS-CRF-366 [IN-039612]
	
	dispose_body_yn		= rset.getString("dispose_body_yn");
	dispose_body_yn= (dispose_body_yn == null)?"":dispose_body_yn;
	assign_area_desc		= rset.getString("AREA_DESC");
	assign_area_desc 		= (assign_area_desc == null)?"":assign_area_desc;
	assign_area_code		= rset.getString("AREA_CODE");
	assign_area_code 		= (assign_area_code == null)?"":assign_area_code;
	REGISTRATION_NO			= rset.getString("REGISTRATION_NO"); 
	REGISTRATION_NO 		= (REGISTRATION_NO == null)?"":REGISTRATION_NO;
	MO_REGN_DATE_TIME		= rset.getString("body_received_date"); 
	MO_REGN_DATE_TIME 		= (MO_REGN_DATE_TIME == null)?"":MO_REGN_DATE_TIME;
	if(MO_REGN_DATE_TIME!=null && !MO_REGN_DATE_TIME.equals(""))
		MO_REGN_DATE_TIME	=  DateUtils.convertDate(MO_REGN_DATE_TIME,"DMYHM","en",localeName); 
	PATIENT_NAME			= rset.getString("PATIENT_NAME");
	PATIENT_NAME 			= (PATIENT_NAME == null)?"":PATIENT_NAME;
	PATIENT_ID				= rset.getString("PATIENT_ID");
	PATIENT_ID 				= (PATIENT_ID == null)?"":PATIENT_ID;
	burial_permit_reqd_yn         =rset.getString("burial_permit_reqd_yn")==null?"":rset.getString("burial_permit_reqd_yn");
	brought_dead_yn         =rset.getString("BROUGHT_DEAD_YN")==null?"":rset.getString("BROUGHT_DEAD_YN");
	brought_dead_yn         =rset.getString("BROUGHT_DEAD_YN")==null?"":rset.getString("BROUGHT_DEAD_YN");
	BDY_PRT_OBT_FROM =rset.getString("BODY_PART_OBTAINED_FROM")==null?"":rset.getString("BODY_PART_OBTAINED_FROM");
	AGE						= rset.getString("AGE");
	AGE 					= (AGE == null)?"":AGE;
	SEX						= rset.getString("SEX");
	SEX 					= (SEX == null)?"":SEX;
	if(SEX!=null && !SEX.equals("") && SEX.equals("Male"))
		SEX = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
		//sex_converted = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
	else if(SEX!=null && !SEX.equals("") && SEX.equals("Female"))
		SEX = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
		//sex_converted = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
	else if(SEX!=null && !SEX.equals("") && SEX.equals("Unknown"))
		SEX = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
		//sex_converted = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");


	bur_per_no						= rset.getString("BURIAL_PERMIT_NO");
	bur_per_no 					= (bur_per_no == null)?"":bur_per_no;

	no_days_mortuary						= rset.getString("no_days_mortuary");
	external=rset.getString("EXTERNAL_YN")==null?"N":rset.getString("EXTERNAL_YN");

	 if(no_days_mortuary.length()==2)
		{
		no_days_mortuary = "&nbsp;&nbsp;"+no_days_mortuary;
		}
		if(no_days_mortuary.length()==1)
		{
		no_days_mortuary = "&nbsp;&nbsp;&nbsp;"+no_days_mortuary;
		}
	if( no_days_mortuary.equals("&nbsp;&nbsp;&nbsp;0") ){ no_days_mortuary="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"; }
   String days ="   Days";

    if( no_days_mortuary.equals("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")){
	 days = "";
    }
	no_days_mortuary = no_days_mortuary + days ;

	HOURS						= rset.getString("HOURS");

	   if(HOURS.length()==1)
		{
		HOURS = "0"+HOURS;
		}
		String hours1 ="h:";

	/*	if( HOURS.equals("00") ){
			HOURS="&nbsp;&nbsp;&nbsp;";
			hours1="&nbsp;&nbsp;&nbsp;";

		} */

	
	HOURS = HOURS + hours1 ;

	MINUTES						= rset.getString("MINUTES");

    if(MINUTES.length()==1)
		{
		MINUTES = "0"+MINUTES;
		}
	String minutes1 ="m";
	MINUTES = MINUTES + minutes1 ;

	String hours_minutes ="";
	 hours_minutes = HOURS + MINUTES ;

	RELIGION						= rset.getString("RELIGION");
	RELIGION 					= (RELIGION == null)?"&nbsp;":RELIGION;

	PM_YN					= rset.getString("PM_YN");
	PM_YN 					= (PM_YN == null)?"":PM_YN;	
	if(PM_YN!=null && !PM_YN.equals("") && PM_YN.equals("N"))
		pm_yn_converted = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels");
	else if(PM_YN!=null && !PM_YN.equals("") && PM_YN.equals("Y"))
		pm_yn_converted = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels");

	assign_area_desc		= rset.getString("AREA_DESC");
	assign_area_desc 		= (assign_area_desc == null)?"":assign_area_desc;
	//area_type_desc          = rset.getString("AREA_TYPE_DESC")==null?"":rset.getString("AREA_TYPE_DESC");
	POSTMORTEM_STATUS		= rset.getString("POSTMORTEM_STATUS");
	POSTMORTEM_STATUS 		= (POSTMORTEM_STATUS == null)?"":POSTMORTEM_STATUS;
	//POSTMORTEM_STATUS_DESC		= rset.getString("POSTMORTEM_STATUS_DESC");
	//POSTMORTEM_STATUS_DESC 		= (POSTMORTEM_STATUS_DESC == null)?"":POSTMORTEM_STATUS_DESC;

	if(POSTMORTEM_STATUS!=null && !POSTMORTEM_STATUS.equals("") && POSTMORTEM_STATUS.equals("N"))
		POSTMORTEM_STATUS_DESC = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");
	else if(POSTMORTEM_STATUS!=null && !POSTMORTEM_STATUS.equals("") && POSTMORTEM_STATUS.equals("A"))
		POSTMORTEM_STATUS_DESC = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.NotRequested.label","mo_labels");
	else if(POSTMORTEM_STATUS!=null && !POSTMORTEM_STATUS.equals("") && POSTMORTEM_STATUS.equals("R"))
		POSTMORTEM_STATUS_DESC = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Requested.label","common_labels");
	else if(POSTMORTEM_STATUS!=null && !POSTMORTEM_STATUS.equals("") && POSTMORTEM_STATUS.equals("S"))
		POSTMORTEM_STATUS_DESC = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InProgress.label","common_labels");
	else if(POSTMORTEM_STATUS!=null && !POSTMORTEM_STATUS.equals("") && POSTMORTEM_STATUS.equals("E"))
		POSTMORTEM_STATUS_DESC = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.completed.label","common_labels");
	else if(POSTMORTEM_STATUS!=null && !POSTMORTEM_STATUS.equals("") && POSTMORTEM_STATUS.equals("C"))
		POSTMORTEM_STATUS_DESC = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels");
	
	//BODY_PART_OBTAINED_FROM_DESC		= rset.getString("BODY_PART_OBTAINED_FROM_DESC");
	//BODY_PART_OBTAINED_FROM_DESC=(BODY_PART_OBTAINED_FROM_DESC == null)?"":BODY_PART_OBTAINED_FROM_DESC;

	if(BDY_PRT_OBT_FROM!=null && !BDY_PRT_OBT_FROM.equals("") && BDY_PRT_OBT_FROM.equals("A"))
		BODY_PART_OBTAINED_FROM_DESC = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.AmputatedBodyPart.label","mo_labels");
	else if(BDY_PRT_OBT_FROM!=null && !BDY_PRT_OBT_FROM.equals("") && BDY_PRT_OBT_FROM.equals("D"))
		BODY_PART_OBTAINED_FROM_DESC = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.DeadFetus.label","mo_labels");
	else if(BDY_PRT_OBT_FROM!=null && !BDY_PRT_OBT_FROM.equals("") && BDY_PRT_OBT_FROM.equals("U"))
		BODY_PART_OBTAINED_FROM_DESC = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.UnidentifiedBodyPart.label","mo_labels");
	else 
		BODY_PART_OBTAINED_FROM_DESC = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");




	highriskbody 		=  rset.getString("HIGH_RISK_BODY_YN")==null?"":rset.getString("HIGH_RISK_BODY_YN"); 
	if(highriskbody.equals("Y"))
	{
	colordisplay="style='background-color:orange'";
	}else 
		{
		colordisplay="";
	}
	postmortem_type 		=  rset.getString("postmortem_type")==null?"":rset.getString("postmortem_type"); 
	AREA_TYPE		= rset.getString("AREA_TYPE");
	AREA_TYPE 		= (AREA_TYPE == null)?"":AREA_TYPE;
	
	if(AREA_TYPE!=null && !AREA_TYPE.equals("") && AREA_TYPE.equals("R"))
		area_type_desc  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.ReleaseArea.label","mo_labels");
	else if(AREA_TYPE!=null && !AREA_TYPE.equals("") && AREA_TYPE.equals("S"))
		area_type_desc  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.StorageArea.label","mo_labels");
	else if(AREA_TYPE!=null && !AREA_TYPE.equals("") && AREA_TYPE.equals("P"))
		area_type_desc  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.PostmortemArea.label","mo_labels");
	else if(AREA_TYPE!=null && !AREA_TYPE.equals("") && AREA_TYPE.equals("O"))
		area_type_desc  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels");


	bed_no			= rset.getString("BED_NO");
	bed_no 			= (bed_no == null)?"":bed_no;
	encounter_id	= rset.getString("encounter_id");
	encounter_id	= (encounter_id == null)?"":encounter_id;
	rfid_tag_num	= rset.getString("rfid_tag_num")==null?"": rset.getString("rfid_tag_num");
	
	if(called_from_ca.equals("Y"))
	{
		sql2.append("SELECT count(*) from MO_MORTUARY_REGN_VW where facility_id='"+fac_id+"' and encounter_id = '"+encounter_id+"' and 	registration_no='"+REGISTRATION_NO+"'");
		// and ATTEND_PRACTITIONER_ID is not null"); //modified for ML-BRU-SCF-0829 [IN:039636]
		stmt1 = conn.createStatement();
		rset1 = stmt1.executeQuery(sql2.toString());
		while(rset1.next())
		{
			count = rset1.getInt(1);
		}
		 if(stmt1!=null) stmt1.close();
	     if(rset1!=null) rset1.close();
	}
	
	sql2.setLength(0);
	sql2.append("select patient_class from pr_encounter where encounter_id = '"+encounter_id+"' and facility_id='"+fac_id+"'");
	stmt1 = conn.createStatement();
	rset1 = stmt1.executeQuery(sql2.toString());
	patient_class="";//modified for ML-BRU-SCF-0829 [IN:039636]
	while(rset1.next())
	{
	 patient_class = rset1.getString(1);
	}	
	//modified for ML-BRU-SCF-0829 [IN:039636] - start
	if(patient_class != null && patient_class.equals("")){
		patient_class="XT";
		encounter_id="";
	}
	//modified for ML-BRU-SCF-0829 [IN:039636] - end
	if(stmt1!=null) stmt1.close();
	if(rset1!=null) rset1.close();
	sql2.setLength(0);
	if(assign_area_code.equals("") &&(!REGISTRATION_NO.equals("")))
		{
		assign_area_code="Unassigned";
		assign_area_code_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Unassigned.label","common_labels");
		}
	
	if(REGISTRATION_NO.equals(""))
		{
		assign_area_code="Unregistered";
		assign_area_code_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.Unregistered.label","mo_labels");
		}
	if(assign_area_code.equals(assign_area_code_prev)){}
	else{
		assign_area_code_prev=assign_area_code;
	if(assign_area_code.equals("Unassigned")||assign_area_code.equals("Unregistered"))
	{
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(backgroundheader));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(assign_area_code_desc));
            _bw.write(_wl_block37Bytes, _wl_block37);
}else {
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(backgroundheader));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(assign_area_desc));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(assign_area_code_desc));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(area_type_desc));
            _bw.write(_wl_block40Bytes, _wl_block40);
}
	} 

	if(!encounter_id.equals(""))
	 {
	String deathcnt="Select count(*) cnt from mr_death_register_diag_dtl  where  facility_id='"+fac_id+"' and    encounter_id='"+encounter_id+"' and diagnosis_group='C' ";
	

	stmt1	 = conn.createStatement();
	rset1 = stmt1.executeQuery(deathcnt);
	 
	 if(rset1.next())
	  {
	   cnt=rset1.getInt("cnt");

	  if(cnt>0)
		  {
		  causeOfDeathReg="Y"; 
		  }else
		  {
		  causeOfDeathReg="N"; 
		  }
	  }
	  
	  }
	if(rset1!=null)rset1.close();
	if(stmt1!=null)stmt1.close();
	if(postmortem_type.equals("M"))
		{
	
            _bw.write(_wl_block41Bytes, _wl_block41);
}else if(postmortem_type.equals("C")){
            _bw.write(_wl_block42Bytes, _wl_block42);
}else{
            _bw.write(_wl_block43Bytes, _wl_block43);
}
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(sCount++ ));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(REGISTRATION_NO));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(MO_REGN_DATE_TIME));
            _bw.write(_wl_block49Bytes, _wl_block49);

		
	if(assign_area_code.equals("Unassigned"))
	{   if(callfrommoreg.equals("callfrommoreg")||callfrommoreg.equals("releaseDeceased") ||   callfrommoreg.equals("ExpoOfDeceased")||callfrommoreg.equals("callfrombdyprt"))
		{
	    if(brought_dead_yn.equals("Y"))
	    {
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(java.net.URLEncoder.encode(encounter_id)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(PATIENT_ID)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(REGISTRATION_NO)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(bur_per_no)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(BDY_PRT_OBT_FROM)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(PM_YN)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(causeOfDeathReg)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(external));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(CLAIMANT_TYPE)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(RELEASE_TO_FACILITY)));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(PATIENT_NAME));
            _bw.write(_wl_block53Bytes, _wl_block53);
}else
		   {
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(java.net.URLEncoder.encode(encounter_id)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(PATIENT_ID)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(REGISTRATION_NO)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(bur_per_no)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(BDY_PRT_OBT_FROM)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(PM_YN)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(causeOfDeathReg)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(external));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(PATIENT_NAME));
            _bw.write(_wl_block56Bytes, _wl_block56);
}}else		
		if(called_from_ca.equals("N")&&callfrommoreg.equals(""))
		{
	    if(brought_dead_yn.equals("Y"))
	    {
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(java.net.URLEncoder.encode(assign_area_desc)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(REGISTRATION_NO)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(PATIENT_NAME)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(SEX)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(PM_YN)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(POSTMORTEM_STATUS)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(assign_area_code)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(AREA_TYPE)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(bed_no)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(PATIENT_ID)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(or_installyn)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(order_catalog_code)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(encounter_id)));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(PATIENT_NAME));
            _bw.write(_wl_block58Bytes, _wl_block58);
	}else{
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(java.net.URLEncoder.encode(assign_area_desc)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(REGISTRATION_NO)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(PATIENT_NAME)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(SEX)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(PM_YN)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(POSTMORTEM_STATUS)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(assign_area_code)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(AREA_TYPE)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(bed_no)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(PATIENT_ID)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(or_installyn)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(order_catalog_code)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(encounter_id)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(CLAIMANT_TYPE)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(RELEASE_TO_FACILITY)));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(PATIENT_NAME));
            _bw.write(_wl_block61Bytes, _wl_block61);
}
	
		}
		//if(called_from_ca.equals("Y") && count == 1) //modified for ML-BRU-SCF-0829 [IN:039636]
		if(called_from_ca.equals("Y"))
		{if(brought_dead_yn.equals("Y"))
	    {
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(java.net.URLEncoder.encode(encounter_id)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(patient_class)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(patient_id)));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(PATIENT_NAME));
            _bw.write(_wl_block63Bytes, _wl_block63);
}else{
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(java.net.URLEncoder.encode(encounter_id)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(patient_class)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(PATIENT_ID)));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(PATIENT_NAME));
            _bw.write(_wl_block63Bytes, _wl_block63);
}
            _bw.write(_wl_block66Bytes, _wl_block66);
}//modified for ML-BRU-SCF-0829 [IN:039636] start
	//if(called_from_ca.equals("Y") && count == 0)
	//{ if(brought_dead_yn.equals("Y"))
	    //{
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(PATIENT_NAME));
            _bw.write(_wl_block68Bytes, _wl_block68);
//}else{
            _bw.write(_wl_block26Bytes, _wl_block26);
//}
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(PATIENT_NAME));
            _bw.write(_wl_block71Bytes, _wl_block71);
//}//modified for ML-BRU-SCF-0829 [IN:039636] end
	}else {
		 if(callfrommoreg.equals("callfrommoreg")||callfrommoreg.equals("releaseDeceased") || callfrommoreg.equals("ExpoOfDeceased")||callfrommoreg.equals("callfrombdyprt"))
		{
	   if(brought_dead_yn.equals("Y"))
	    {
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(java.net.URLEncoder.encode(encounter_id)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(PATIENT_ID)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(REGISTRATION_NO)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(bur_per_no)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(BDY_PRT_OBT_FROM)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(PM_YN)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(causeOfDeathReg)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(external));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(CLAIMANT_TYPE)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(RELEASE_TO_FACILITY)));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(PATIENT_NAME));
            _bw.write(_wl_block73Bytes, _wl_block73);
}else{
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(java.net.URLEncoder.encode(encounter_id)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(PATIENT_ID)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(REGISTRATION_NO)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(bur_per_no)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(BDY_PRT_OBT_FROM)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(PM_YN)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(causeOfDeathReg)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(external));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(CLAIMANT_TYPE)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(RELEASE_TO_FACILITY)));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(PATIENT_NAME));
            _bw.write(_wl_block73Bytes, _wl_block73);
}
		
		}else	if(called_from_ca.equals("N")&&callfrommoreg.equals("")){
		
		 if(brought_dead_yn.equals("Y"))
	    {
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(java.net.URLEncoder.encode(assign_area_desc)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(REGISTRATION_NO)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(PATIENT_NAME)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(SEX)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(PM_YN)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(POSTMORTEM_STATUS)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(assign_area_code)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(AREA_TYPE)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(bed_no)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(PATIENT_ID)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(or_installyn)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(order_catalog_code)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(encounter_id)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(CLAIMANT_TYPE)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(RELEASE_TO_FACILITY)));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(PATIENT_NAME));
            _bw.write(_wl_block78Bytes, _wl_block78);
}else{
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(java.net.URLEncoder.encode(assign_area_desc)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(REGISTRATION_NO)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(PATIENT_NAME)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(SEX)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(PM_YN)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(POSTMORTEM_STATUS)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(assign_area_code)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(AREA_TYPE)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(bed_no)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(PATIENT_ID)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(or_installyn)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(order_catalog_code)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(encounter_id)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(CLAIMANT_TYPE)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(RELEASE_TO_FACILITY)));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(PATIENT_NAME));
            _bw.write(_wl_block81Bytes, _wl_block81);
}
		}else if(callfrommoreg.equals("RevertRelease")) {
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(java.net.URLEncoder.encode(REGISTRATION_NO)));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(PATIENT_NAME));
            _bw.write(_wl_block81Bytes, _wl_block81);
}
		//if(called_from_ca.equals("Y") && count == 1){//modified for ML-BRU-SCF-0829 [IN:039636]
		if(called_from_ca.equals("Y") ){
		if(brought_dead_yn.equals("Y"))
	    {
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(java.net.URLEncoder.encode(PATIENT_ID)));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(PATIENT_NAME));
            _bw.write(_wl_block61Bytes, _wl_block61);
}else{
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(java.net.URLEncoder.encode(PATIENT_ID)));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(PATIENT_NAME));
            _bw.write(_wl_block61Bytes, _wl_block61);
}}//modified for ML-BRU-SCF-0829 [IN:039636] 
		//if(called_from_ca.equals("Y") && count == 0){
		//if(brought_dead_yn.equals("Y"))
	    //{
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(PATIENT_NAME));
            _bw.write(_wl_block89Bytes, _wl_block89);
//}else
			//{
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(PATIENT_NAME));
            _bw.write(_wl_block92Bytes, _wl_block92);
//}}
		}
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(PATIENT_ID));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(AGE));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(SEX));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(pm_yn_converted));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(POSTMORTEM_STATUS_DESC));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(no_days_mortuary));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(hours_minutes));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(RELIGION));
            _bw.write(_wl_block99Bytes, _wl_block99);
if(encounter_id.equals(""))
     {
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block101Bytes, _wl_block101);
}else
		{
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block103Bytes, _wl_block103);
}
            _bw.write(_wl_block26Bytes, _wl_block26);
if(bed_no.equals(""))
     {
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block101Bytes, _wl_block101);
}else
		{
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(bed_no));
            _bw.write(_wl_block103Bytes, _wl_block103);
}
            _bw.write(_wl_block104Bytes, _wl_block104);

		if(enable_rfid_yn.equals("Y")) // added by mujafar for ML-MMOH-CRF-0996
		{
		if(rfid_tag_num.equals(""))
     {
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block101Bytes, _wl_block101);
}else
		{
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(rfid_tag_num));
            _bw.write(_wl_block103Bytes, _wl_block103);
}
		}
		
            _bw.write(_wl_block26Bytes, _wl_block26);
if(!obtained_from.equals("C"))
     {
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(BODY_PART_OBTAINED_FROM_DESC));
            _bw.write(_wl_block99Bytes, _wl_block99);
}
            _bw.write(_wl_block106Bytes, _wl_block106);
if(bur_per_no.equals(""))
     {
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block101Bytes, _wl_block101);
}else
		{
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(bur_per_no));
            _bw.write(_wl_block103Bytes, _wl_block103);
}
            _bw.write(_wl_block109Bytes, _wl_block109);
			
	l++;
		}
		
		
	  if(rset!=null) rset.close();
	  if(stmt!=null) stmt.close();
	i++;
	}



	   }else 
		{  
          sql.setLength(0);	  
	      sql.append("   where NVL(BODY_PART_OBTAINED_FROM,'*') like '"+BODY_PART_OBTAINED_FROM+"%' and postmortem_status like '"+pmstatus+"%'  and facility_id='"+fac_id+"' and NVL(area_code,decode(registration_no,null,'$','*')) like '"+area_code+"%' and NVL(patient_id,'*') like '"+patient_id+"%' and sex like '"+gender+"%' and registration_no like '"+registration_id+"%' and NVL(AREA_TYPE,'*') like '"+atype+"%' and to_date(substr(BODY_RECEIVED_DATE,1,10),'dd/mm/yyyy') between to_date('"+frmdate+"','dd/mm/yyyy' )"); 
	     
		 

	  if(!todate.equals(""))
		{
		  sql.append(" and to_date('"+todate+"','dd/mm/yyyy')");
		}else
		{
		 sql.append(" and sysdate");
		}

		sql.append("and (('"+rstatus+"' is null) or ( '"+rstatus+"' is not null and '"+rstatus+"'='C' and release_body_date is null) or ('"+rstatus+"' is not null and '"+rstatus+"'='R' and release_body_date is not null ))");
	    
		 if(callfrommoreg.equals("releaseDeceased"))
		 {
			 sql.append("  AND area_type = 'R'  ");
		 }
		 if(callfrommoreg.equals("ExpoOfDeceased"))
		 {
			 sql.append("  AND exportation_doc_iss_date IS NULL AND exportation_reqd_yn = 'Y'  ");
		 }
        if(obtained_from.equals("C"))
         {
              sql.append(" and  BODY_PART_OBTAINED_FROM is  null");
         }else if(obtained_from.equals("A")||obtained_from.equals("U")||obtained_from.equals("D"))
          {
            sql.append(" and  BODY_PART_OBTAINED_FROM like '"+obtained_from+"%'");
          }else  if(callfrommoreg.equals(""))
	      {
	      } else  if(callfrommoreg.equals("callfrombdyprt"))
	      {
	        sql.append(" and  BODY_PART_OBTAINED_FROM is not null");
	      }else if(callfrommoreg.equals("callfrommoreg"))
	      { sql.append(" and  BODY_PART_OBTAINED_FROM is  null");
	      }

	
		sql.append(" and  NVL(BURIAL_PERMIT_NO,'*') LIKE '"+burial_permit_no+"%'");
		sql.append(" order by area_code,registration_no");	  
    	sql1.append("select count(*) as total from MO_MORTUARY_REGN_VW");
	    sql1.append(sql.toString());
		stmt	 = conn.createStatement();
	    rset = stmt.executeQuery(sql1.toString());	
	    sql1.setLength(0);
	    if(rset.next())
	    maxRecord = rset.getInt("total");
	    if(maxRecord == 0) 
			{
			
            _bw.write(_wl_block110Bytes, _wl_block110);

			}
		else 
		{ 
			
            _bw.write(_wl_block111Bytes, _wl_block111);

     	//sql1.append("select BODY_PART_OBTAINED_FROM,BURIAL_PERMIT_NO,BROUGHT_DEAD_YN, MO_GET_DESC.MO_AREA('"+fac_id+"',AREA_CODE,'"+localeName+"','2') AREA_DESC,AREA_CODE,HIGH_RISK_BODY_YN,area_type_desc,REGISTRATION_NO,body_received_date,decode('"+localeName+"', 'en', PATIENT_NAME,nvl(PATIENT_NAME_LOC_LANG, PATIENT_NAME))  PATIENT_NAME,PATIENT_ID,AGE,SEX,PM_YN,POSTMORTEM_STATUS,POSTMORTEM_STATUS_DESC,AREA_TYPE,BED_NO,encounter_id,dispose_body_yn,MLC_YN,POSTMORTEM_TYPE,BODY_PART_OBTAINED_FROM_DESC, POSTMORTEM_TYPE_DESC, 'REGD' STATUS, RELEASE_BODY_DATE, ORDER_CATALOG_CODE,RFID_TAG_NUM,EXTERNAL_YN from MO_MORTUARY_REGN_VW");
		sql1.append("select BODY_PART_OBTAINED_FROM,BURIAL_PERMIT_NO,BROUGHT_DEAD_YN, MO_GET_DESC.MO_AREA('"+fac_id+"',AREA_CODE,'"+localeName+"','2') AREA_DESC,AREA_CODE,HIGH_RISK_BODY_YN,area_type_desc,REGISTRATION_NO,body_received_date,decode('"+localeName+"', 'en', PATIENT_NAME,nvl(PATIENT_NAME_LOC_LANG, PATIENT_NAME))  PATIENT_NAME,PATIENT_ID,AGE,SEX,PM_YN,POSTMORTEM_STATUS,POSTMORTEM_STATUS_DESC,AREA_TYPE,BED_NO,encounter_id,dispose_body_yn,MLC_YN,POSTMORTEM_TYPE,BODY_PART_OBTAINED_FROM_DESC, POSTMORTEM_TYPE_DESC, 'REGD' STATUS, RELEASE_BODY_DATE,RFID_TAG_NUM,EXTERNAL_YN from MO_MORTUARY_REGN_VW");

		
	    sql1.append(sql.toString());
		stmt	 = conn.createStatement();
		rset = stmt.executeQuery(sql1.toString());
	    sql1.setLength(0);
	  
            _bw.write(_wl_block112Bytes, _wl_block112);

if ( !(start <= 1) )
	out.println("<A HREF='../jsp/MOManageDeceasedSearchResult.jsp?function_id="+function_id+"&from="+(start-8)+"&to="+(end-8)+"&area_code="+URLEncoder.encode(area_code)+"&registration_no="+URLEncoder.encode(registration_id)+"&patient_id="+URLEncoder.encode(patient_id)+"&burial_permit_no="+URLEncoder.encode(burial_permit_no)+"&obt_frm="+URLEncoder.encode(obtained_from)+"&gender="+URLEncoder.encode(gender)+"&called_from_ca="+URLEncoder.encode(called_from_ca)+"&callfrommoreg="+URLEncoder.encode(callfrommoreg)+"&body_part_obtained_from="+URLEncoder.encode(BODY_PART_OBTAINED_FROM)+"&frmdate="+URLEncoder.encode(frmdate)+"&todate="+URLEncoder.encode(todate)+"&atype="+URLEncoder.encode(atype)+"&pmstatus="+URLEncoder.encode(pmstatus)+"&rstatus="+URLEncoder.encode(rstatus)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+8) > maxRecord ) )
	out.println("<A HREF='../jsp/MOManageDeceasedSearchResult.jsp?function_id="+function_id+"&from="+(start+8)+"&to="+(end+8)+"&area_code="+URLEncoder.encode(area_code)+"&registration_no="+URLEncoder.encode(registration_id)+"&patient_id="+URLEncoder.encode(patient_id)+"&burial_permit_no="+URLEncoder.encode(burial_permit_no)+"&obt_frm="+URLEncoder.encode(obtained_from)+"&gender="+URLEncoder.encode(gender)+"&called_from_ca="+URLEncoder.encode(called_from_ca)+"&callfrommoreg="+URLEncoder.encode(callfrommoreg)+"&body_part_obtained_from="+URLEncoder.encode(BODY_PART_OBTAINED_FROM)+"&frmdate="+URLEncoder.encode(frmdate)+"&todate="+URLEncoder.encode(todate)+"&atype="+URLEncoder.encode(atype)+"&pmstatus="+URLEncoder.encode(pmstatus)+"&rstatus="+URLEncoder.encode(rstatus)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");


            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(backgroundheader));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(backgroundheader));
            _bw.write(_wl_block114Bytes, _wl_block114);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(backgroundheader));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(backgroundheader));
            _bw.write(_wl_block115Bytes, _wl_block115);
if(obtained_from.equals("C"))
     {
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
}else{
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
}
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(backgroundheader));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(backgroundheader));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(backgroundheader));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(backgroundheader));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(backgroundheader));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(backgroundheader));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(backgroundheader));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

	if(enable_rfid_yn.equals("Y")) // added by mujafar for ML-MMOH-CRF-0996
	{
	
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(backgroundheader));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

	}
	if(!obtained_from.equals("C"))
     {
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(backgroundheader));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block117Bytes, _wl_block117);
}
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(backgroundheader));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

	String classValue	= "";
	int rowIndex		= 1;
	
	for( int j=1; j<start; l++,j++ ){
	rset.next() ;
    }
	
	
	while (rset.next()&&l<=end)
	{
	classValue				=	((rowIndex%2)==0)? "QRYEVEN" : "QRYODD";
	rowIndex++;
	dispose_body_yn		= rset.getString("dispose_body_yn");
	dispose_body_yn= (dispose_body_yn == null)?"":dispose_body_yn;
	assign_area_desc		= rset.getString("AREA_DESC");
	assign_area_desc 		= (assign_area_desc == null)?"":assign_area_desc;
	assign_area_code		= rset.getString("AREA_CODE");
	assign_area_code 		= (assign_area_code == null)?"":assign_area_code;
	BDY_PRT_OBT_FROM =rset.getString("BODY_PART_OBTAINED_FROM")==null?"":rset.getString("BODY_PART_OBTAINED_FROM");
	REGISTRATION_NO			= rset.getString("REGISTRATION_NO"); 
	REGISTRATION_NO 		= (REGISTRATION_NO == null)?"":REGISTRATION_NO;
	//BODY_PART_OBTAINED_FROM_DESC		= rset.getString("BODY_PART_OBTAINED_FROM_DESC");
	//BODY_PART_OBTAINED_FROM_DESC=(BODY_PART_OBTAINED_FROM_DESC == null)?"":BODY_PART_OBTAINED_FROM_DESC;
	if(BDY_PRT_OBT_FROM!=null && !BDY_PRT_OBT_FROM.equals("") && BDY_PRT_OBT_FROM.equals("A"))
		BODY_PART_OBTAINED_FROM_DESC = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.AmputatedBodyPart.label","mo_labels");
	else if(BDY_PRT_OBT_FROM!=null && !BDY_PRT_OBT_FROM.equals("") && BDY_PRT_OBT_FROM.equals("D"))
		BODY_PART_OBTAINED_FROM_DESC = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.DeadFetus.label","mo_labels");
	else if(BDY_PRT_OBT_FROM!=null && !BDY_PRT_OBT_FROM.equals("") && BDY_PRT_OBT_FROM.equals("U"))
		BODY_PART_OBTAINED_FROM_DESC = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.UnidentifiedBodyPart.label","mo_labels");
	else 
		BODY_PART_OBTAINED_FROM_DESC = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");

	bur_per_no						= rset.getString("BURIAL_PERMIT_NO");
	bur_per_no 					= (bur_per_no == null)?"":bur_per_no;
	brought_dead_yn= rset.getString("brought_dead_yn")==null?"":rset.getString("brought_dead_yn");
	//area_type_desc          = rset.getString("AREA_TYPE_DESC")==null?"":rset.getString("AREA_TYPE_DESC");
	highriskbody 		=  rset.getString("HIGH_RISK_BODY_YN")==null?"":rset.getString("HIGH_RISK_BODY_YN"); 
	if(highriskbody.equals("Y"))
		{
	colordisplay="style='background-color:orange'";
		}else 
		{
		colordisplay="";
	}
	MO_REGN_DATE_TIME		= rset.getString("body_received_date"); 
	MO_REGN_DATE_TIME 		= (MO_REGN_DATE_TIME == null)?"":MO_REGN_DATE_TIME;
	if(MO_REGN_DATE_TIME!=null && !MO_REGN_DATE_TIME.equals(""))
		MO_REGN_DATE_TIME	=  DateUtils.convertDate(MO_REGN_DATE_TIME,"DMYHM","en",localeName); 
	PATIENT_NAME			= rset.getString("PATIENT_NAME");
	PATIENT_NAME 			= (PATIENT_NAME == null)?"":PATIENT_NAME;
	PATIENT_ID				= rset.getString("PATIENT_ID");
	PATIENT_ID 				= (PATIENT_ID == null)?"":PATIENT_ID;
	AGE						= rset.getString("AGE");
	AGE 					= (AGE == null)?"":AGE;
	SEX						= rset.getString("SEX");
	SEX 					= (SEX == null)?"":SEX;
	if(SEX!=null && !SEX.equals("") && SEX.equals("Male"))
		SEX = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
		//sex_converted = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
	else if(SEX!=null && !SEX.equals("") && SEX.equals("Female"))
		SEX = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
		//sex_converted = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
	else if(SEX!=null && !SEX.equals("") && SEX.equals("Unknown"))
		SEX = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

		//sex_converted = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

	PM_YN					= rset.getString("PM_YN");
	PM_YN 					= (PM_YN == null)?"":PM_YN;	
	if(PM_YN!=null && !PM_YN.equals("") && PM_YN.equals("N"))
		pm_yn_converted = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels");
	else if(PM_YN!=null && !PM_YN.equals("") && PM_YN.equals("Y"))
		pm_yn_converted = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels");

	//assign_area_desc		= rset.getString("AREA_DESC");
	//assign_area_desc 		= (assign_area_desc == null)?"":assign_area_desc;
	POSTMORTEM_STATUS		= rset.getString("POSTMORTEM_STATUS");
	POSTMORTEM_STATUS 		= (POSTMORTEM_STATUS == null)?"":POSTMORTEM_STATUS;
	//POSTMORTEM_STATUS_DESC		= rset.getString("POSTMORTEM_STATUS_DESC");
	//POSTMORTEM_STATUS_DESC 		= (POSTMORTEM_STATUS_DESC == null)?"":POSTMORTEM_STATUS_DESC;
	
	if(POSTMORTEM_STATUS!=null && !POSTMORTEM_STATUS.equals("") && POSTMORTEM_STATUS.equals("N"))
		POSTMORTEM_STATUS_DESC = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");
	else if(POSTMORTEM_STATUS!=null && !POSTMORTEM_STATUS.equals("") && POSTMORTEM_STATUS.equals("A"))
		POSTMORTEM_STATUS_DESC = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.NotRequested.label","mo_labels");
	else if(POSTMORTEM_STATUS!=null && !POSTMORTEM_STATUS.equals("") && POSTMORTEM_STATUS.equals("R"))
		POSTMORTEM_STATUS_DESC = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Requested.label","common_labels");
	else if(POSTMORTEM_STATUS!=null && !POSTMORTEM_STATUS.equals("") && POSTMORTEM_STATUS.equals("S"))
		POSTMORTEM_STATUS_DESC = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InProgress.label","common_labels");
	else if(POSTMORTEM_STATUS!=null && !POSTMORTEM_STATUS.equals("") && POSTMORTEM_STATUS.equals("E"))
		POSTMORTEM_STATUS_DESC = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.completed.label","common_labels");
	else if(POSTMORTEM_STATUS!=null && !POSTMORTEM_STATUS.equals("") && POSTMORTEM_STATUS.equals("C"))
		POSTMORTEM_STATUS_DESC = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels");

	AREA_TYPE		= rset.getString("AREA_TYPE");
	AREA_TYPE 		= (AREA_TYPE == null)?"":AREA_TYPE;

	if(AREA_TYPE!=null && !AREA_TYPE.equals("") && AREA_TYPE.equals("R"))
		area_type_desc  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.ReleaseArea.label","mo_labels");
	else if(AREA_TYPE!=null && !AREA_TYPE.equals("") && AREA_TYPE.equals("S"))
		area_type_desc  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.StorageArea.label","mo_labels");
	else if(AREA_TYPE!=null && !AREA_TYPE.equals("") && AREA_TYPE.equals("P"))
		area_type_desc  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.PostmortemArea.label","mo_labels");
	else if(AREA_TYPE!=null && !AREA_TYPE.equals("") && AREA_TYPE.equals("O"))
		area_type_desc  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels");

	bed_no			= rset.getString("BED_NO");
	bed_no 			= (bed_no == null)?"":bed_no;
	encounter_id	= rset.getString("encounter_id");
	encounter_id	= (encounter_id == null)?"":encounter_id;
	postmortem_type         = rset.getString("POSTMORTEM_TYPE")==null?"":rset.getString("POSTMORTEM_TYPE");   
	
	rfid_tag_num         = rset.getString("RFID_TAG_NUM")==null?"":rset.getString("RFID_TAG_NUM");   
	//mlc_yn=rset.getString("mlc_yn")==null?"":rset.getString("mlc_yn");   
	external=rset.getString("EXTERNAL_YN")==null?"N":rset.getString("EXTERNAL_YN"); 
	if(called_from_ca.equals("Y"))
	{
		sql2.append("SELECT count(*) from MO_MORTUARY_REGN_VW where facility_id='"+fac_id+"' and encounter_id = '"+encounter_id+"' and 	registration_no='"+REGISTRATION_NO+"'");
		//and ATTEND_PRACTITIONER_ID is not null"); //modified for ML-BRU-SCF-0829 [IN:039636]
		stmt1 = conn.createStatement();
		rset1 = stmt1.executeQuery(sql2.toString());
		while(rset1.next())
		{
			count = rset1.getInt(1);
		}
		 if(stmt1!=null) stmt1.close();
	     if(rset1!=null) rset1.close();
	}
	sql2.setLength(0);
	sql2.append("select patient_class from pr_encounter where encounter_id = '"+encounter_id+"' and facility_id='"+fac_id+"'");
	stmt1 = conn.createStatement();
	rset1 = stmt1.executeQuery(sql2.toString());
	patient_class="";//modified for ML-BRU-SCF-0829 [IN:039636]
	while(rset1.next())
	{
	 patient_class = rset1.getString(1);
	}
	//modified for ML-BRU-SCF-0829 [IN:039636] - start
	if(patient_class != null && patient_class.equals("")){
		patient_class="XT";
		encounter_id="";
	}
	//modified for ML-BRU-SCF-0829 [IN:039636] - end
	     if(stmt1!=null) stmt1.close();
	     if(rset1!=null) rset1.close();
	sql2.setLength(0);
	
	if(!encounter_id.equals(""))
	 {
	String deathcnt="Select count(*) cnt from PR_DIAGNOSIS_ENC_DTL where  FACILITY_ID='"+fac_id+"' and   ENCOUNTER_ID='"+encounter_id+"' and CAUSE_OF_DEATH_YN='Y'";
	stmt1	 = conn.createStatement();
	rset1 = stmt1.executeQuery(deathcnt);
	 
	 if(rset1.next())
	  {
	  cnt= rset1.getInt("cnt");
		  if(cnt>0)
		  {
		  causeOfDeathReg="Y"; 
		  }else
		  {
		  causeOfDeathReg="N"; 
		  }
	  }
	 }
	
	
	if(rset1!=null)rset1.close();
	if(stmt1!=null)stmt1.close();
	if(assign_area_code.equals("") &&(!REGISTRATION_NO.equals("")))
		{
		assign_area_code="Unassigned";
		assign_area_code_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Unassigned.label","common_labels");
		}
	
	if(REGISTRATION_NO.equals(""))
		{
		assign_area_code="Unregistered";
		assign_area_code_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.Unregistered.label","mo_labels");
		}
	
	if(assign_area_code.equals(assign_area_code_prev)){}
	else{
		assign_area_code_prev=assign_area_code;
	if(assign_area_code.equals("Unassigned")||assign_area_code.equals("Unregistered"))
	{
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(backgroundheader));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(assign_area_code_desc));
            _bw.write(_wl_block37Bytes, _wl_block37);
}else {
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(backgroundheader));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(assign_area_desc));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(assign_area_code_desc));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(area_type_desc));
            _bw.write(_wl_block40Bytes, _wl_block40);
}
            _bw.write(_wl_block26Bytes, _wl_block26);


	} 
		
	if(postmortem_type.equals("M"))
		{
	
            _bw.write(_wl_block119Bytes, _wl_block119);
}else if(postmortem_type.equals("C")){
            _bw.write(_wl_block120Bytes, _wl_block120);
}else{
            _bw.write(_wl_block43Bytes, _wl_block43);
}
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(REGISTRATION_NO));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(MO_REGN_DATE_TIME));
            _bw.write(_wl_block122Bytes, _wl_block122);

	if(assign_area_code.equals("Unassigned"))
	{   if(callfrommoreg.equals("callfrommoreg")||callfrommoreg.equals("releaseDeceased") || callfrommoreg.equals("ExpoOfDeceased")||callfrommoreg.equals("callfrombdyprt"))
		{
	    if(brought_dead_yn.equals("Y")){
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(java.net.URLEncoder.encode(encounter_id)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(PATIENT_ID)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(REGISTRATION_NO)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(bur_per_no)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(BDY_PRT_OBT_FROM)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(PM_YN)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(causeOfDeathReg)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(external));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(CLAIMANT_TYPE)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(RELEASE_TO_FACILITY)));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(PATIENT_NAME));
            _bw.write(_wl_block124Bytes, _wl_block124);
}else{
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(java.net.URLEncoder.encode(encounter_id)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(PATIENT_ID)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(REGISTRATION_NO)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(bur_per_no)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(BDY_PRT_OBT_FROM)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(PM_YN)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(causeOfDeathReg)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(external));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(CLAIMANT_TYPE)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(RELEASE_TO_FACILITY)));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(PATIENT_NAME));
            _bw.write(_wl_block126Bytes, _wl_block126);
}
            _bw.write(_wl_block104Bytes, _wl_block104);
}else		
		if(called_from_ca.equals("N")&&callfrommoreg.equals(""))
		{if(brought_dead_yn.equals("Y")){
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(java.net.URLEncoder.encode(assign_area_desc)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(REGISTRATION_NO)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(PATIENT_NAME)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(SEX)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(PM_YN)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(POSTMORTEM_STATUS)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(assign_area_code)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(AREA_TYPE)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(bed_no)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(PATIENT_ID)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(or_installyn)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(order_catalog_code)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(encounter_id)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(CLAIMANT_TYPE)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(RELEASE_TO_FACILITY)));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(PATIENT_NAME));
            _bw.write(_wl_block61Bytes, _wl_block61);
}else{	
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(java.net.URLEncoder.encode(assign_area_desc)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(REGISTRATION_NO)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(PATIENT_NAME)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(SEX)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(PM_YN)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(POSTMORTEM_STATUS)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(assign_area_code)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(AREA_TYPE)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(bed_no)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(PATIENT_ID)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(or_installyn)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(order_catalog_code)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(encounter_id)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(CLAIMANT_TYPE)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(RELEASE_TO_FACILITY)));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(PATIENT_NAME));
            _bw.write(_wl_block130Bytes, _wl_block130);

		}}
		
		//if(called_from_ca.equals("Y") && count == 1) //modified for ML-BRU-SCF-0829 [IN:039636]
		if(called_from_ca.equals("Y") )
			{
			
			if(brought_dead_yn.equals("Y")){
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(java.net.URLEncoder.encode(encounter_id)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(patient_class)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(PATIENT_ID)));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(PATIENT_NAME));
            _bw.write(_wl_block132Bytes, _wl_block132);
}else{
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(java.net.URLEncoder.encode(encounter_id)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(patient_class)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(PATIENT_ID)));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(PATIENT_NAME));
            _bw.write(_wl_block63Bytes, _wl_block63);
}
            _bw.write(_wl_block134Bytes, _wl_block134);
}//modified for ML-BRU-SCF-0829 [IN:039636]
	//if(called_from_ca.equals("Y") && count == 0)
	//{
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(PATIENT_NAME));
            _bw.write(_wl_block136Bytes, _wl_block136);
//}
	}else {
            _bw.write(_wl_block104Bytes, _wl_block104);

		 if(callfrommoreg.equals("callfrommoreg")||callfrommoreg.equals("releaseDeceased") || callfrommoreg.equals("ExpoOfDeceased")||callfrommoreg.equals("callfrombdyprt"))
		{ if(brought_dead_yn.equals("Y")){
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(java.net.URLEncoder.encode(encounter_id)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(PATIENT_ID)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(REGISTRATION_NO)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(bur_per_no)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(BDY_PRT_OBT_FROM)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(PM_YN)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(causeOfDeathReg)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(external));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(CLAIMANT_TYPE)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(RELEASE_TO_FACILITY)));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(PATIENT_NAME));
            _bw.write(_wl_block138Bytes, _wl_block138);
}else	{
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(java.net.URLEncoder.encode(encounter_id)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(PATIENT_ID)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(REGISTRATION_NO)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(bur_per_no)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(BDY_PRT_OBT_FROM)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(PM_YN)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(causeOfDeathReg)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(external));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(CLAIMANT_TYPE)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(RELEASE_TO_FACILITY)));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(PATIENT_NAME));
            _bw.write(_wl_block63Bytes, _wl_block63);
}
		}else	if(called_from_ca.equals("N")&&callfrommoreg.equals("")){
		if(brought_dead_yn.equals("Y")){
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(java.net.URLEncoder.encode(assign_area_desc)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(REGISTRATION_NO)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(PATIENT_NAME)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(SEX)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(PM_YN)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(POSTMORTEM_STATUS)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(assign_area_code)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(AREA_TYPE)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(bed_no)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(PATIENT_ID)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(or_installyn)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(order_catalog_code)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(encounter_id)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(CLAIMANT_TYPE)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(RELEASE_TO_FACILITY)));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(PATIENT_NAME));
            _bw.write(_wl_block142Bytes, _wl_block142);
}else{
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(java.net.URLEncoder.encode(assign_area_desc)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(REGISTRATION_NO)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(PATIENT_NAME)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(SEX)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(PM_YN)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(POSTMORTEM_STATUS)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(assign_area_code)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(AREA_TYPE)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(bed_no)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(PATIENT_ID)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(or_installyn)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(order_catalog_code)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(encounter_id)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(CLAIMANT_TYPE)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(RELEASE_TO_FACILITY)));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(PATIENT_NAME));
            _bw.write(_wl_block61Bytes, _wl_block61);
}
		}else if(callfrommoreg.equals("RevertRelease")) {
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(java.net.URLEncoder.encode(assign_area_desc)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(REGISTRATION_NO)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(PATIENT_NAME)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(SEX)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(PM_YN)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(POSTMORTEM_STATUS)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(assign_area_code)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(AREA_TYPE)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(bed_no)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(PATIENT_ID)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(or_installyn)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(order_catalog_code)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(java.net.URLEncoder.encode(encounter_id)));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(PATIENT_NAME));
            _bw.write(_wl_block81Bytes, _wl_block81);
}
		//if(called_from_ca.equals("Y") && count == 1){ //modified for ML-BRU-SCF-0829 [IN:039636]
		if(called_from_ca.equals("Y") && count == 1){
	
		if(brought_dead_yn.equals("Y")){
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(java.net.URLEncoder.encode(PATIENT_ID)));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(PATIENT_NAME));
            _bw.write(_wl_block146Bytes, _wl_block146);
}else{
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(java.net.URLEncoder.encode(PATIENT_ID)));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(PATIENT_NAME));
            _bw.write(_wl_block61Bytes, _wl_block61);
}
            _bw.write(_wl_block148Bytes, _wl_block148);
}//modified for ML-BRU-SCF-0829 [IN:039636] 
		//if(called_from_ca.equals("Y") && count == 0){
			//if(brought_dead_yn.equals("Y")){
			
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(PATIENT_NAME));
            _bw.write(_wl_block150Bytes, _wl_block150);
//}else{
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(PATIENT_NAME));
            _bw.write(_wl_block150Bytes, _wl_block150);
//}
            _bw.write(_wl_block151Bytes, _wl_block151);
//}
		}
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(PATIENT_ID));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(AGE));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(SEX));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(pm_yn_converted));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(POSTMORTEM_STATUS_DESC));
            _bw.write(_wl_block99Bytes, _wl_block99);
if(encounter_id.equals(""))
     {
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block101Bytes, _wl_block101);
}else
		{
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block103Bytes, _wl_block103);
}
            _bw.write(_wl_block26Bytes, _wl_block26);
if(bed_no.equals(""))
     {
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block101Bytes, _wl_block101);
}else
		{
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(bed_no));
            _bw.write(_wl_block103Bytes, _wl_block103);
}
            _bw.write(_wl_block104Bytes, _wl_block104);

		if(enable_rfid_yn.equals("Y")) // added by mujafar for ML-MMOH-CRF-0996
		{
		if(rfid_tag_num.equals(""))
     {
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block101Bytes, _wl_block101);
}else
		{
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(rfid_tag_num));
            _bw.write(_wl_block103Bytes, _wl_block103);
}
		}
		
            _bw.write(_wl_block153Bytes, _wl_block153);
if(!obtained_from.equals("C"))
     {
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(BODY_PART_OBTAINED_FROM_DESC));
            _bw.write(_wl_block99Bytes, _wl_block99);
}
            _bw.write(_wl_block106Bytes, _wl_block106);
if(bur_per_no.equals(""))
     {
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block101Bytes, _wl_block101);
}else
		{
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(bur_per_no));
            _bw.write(_wl_block103Bytes, _wl_block103);
}
            _bw.write(_wl_block109Bytes, _wl_block109);
			
	l++;
		}
		
		if(rset!=null) rset.close();
	  if(stmt!=null) stmt.close();
	i++;
	

	
	}
	}
	
            _bw.write(_wl_block154Bytes, _wl_block154);
	  if(callfrommoreg.equals("callfrombdyprt"))
	  { 
            _bw.write(_wl_block155Bytes, _wl_block155);
}else{
            _bw.write(_wl_block156Bytes, _wl_block156);
}
            _bw.write(_wl_block26Bytes, _wl_block26);
  
		if (rset != null ) rset.close() ;
		if (rset1!= null)  rset1.close();
		if (stmt != null ) stmt.close() ;	
		if (stmt1!= null)  stmt1.close();
	}	
	catch ( Exception e ){
		out.println("Exception in MOManageDeceasedSearchResult "+e.toString());
		e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(conn,request);
	}
	
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(called_from_ca));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(parameters));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(callfrommoreg));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(REGISTRATION_NO));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(burial_permit_reqd_yn));
            _bw.write(_wl_block164Bytes, _wl_block164);
 
	if(callfrommoreg.equals("") || callfrommoreg.equals("releaseDeceased")  ){
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(queue_refresh_interval));
            _bw.write(_wl_block166Bytes, _wl_block166);
 } 
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(increasedaddressLength));
            _bw.write(_wl_block168Bytes, _wl_block168);
            _bw.write(_wl_block169Bytes, _wl_block169);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Sno.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.registrationno.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RegnDate/Time.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.deceased.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.age.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.PMYN.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.PostmortemStatus.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.DurationinMortuary.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.religion.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.RFIDTag.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.BodyPartType.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.BurialPermitNo.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.registrationno.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RegnDate/Time.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.deceased.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.age.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.PMYN.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.PostmortemStatus.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.RFIDTag.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.BodyPartType.label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.BurialPermitNo.label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
