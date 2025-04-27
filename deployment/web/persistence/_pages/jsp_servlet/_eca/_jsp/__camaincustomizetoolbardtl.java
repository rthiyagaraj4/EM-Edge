package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __camaincustomizetoolbardtl extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CAMainCustomizeToolbarDtl.jsp", 1742377551957L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\' />\n\t<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script><script src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script src=\'../../eCommon/js/common.js\'></script>\n\t<script src=\'../js/CAMenu.js\' language=\'javascript\'></script>\n    \n</head>\n<style>\n\nTD.CUSTMSGHEADER {\n\tFONT-FAMILY: verdana;\n\tFONT-SIZE: 8PT ;\n\tCOLOR: #4C4C4C;\n\tPADDING-LEFT:5PX;\n\tPADDING-RIGHT:5PX;\n}\nTABLE.CUSTDISPMSG\n{\n\tHEIGHT:28px;\n\tBACKGROUND-COLOR:#D5E3E6;\n}\n\nTABLE.CUSTOUTERTAB\n{\n\tBORDER-LEFT:1PX;\n\tBORDER-RIGHT:1PX;\n\tBORDER-TOP:1PX;\n\tBORDER-BOTTOM:1PX;\n\tBORDER-COLOR:#666666;\n\tBORDER-STYLE:SOLID;\n\tMARGIN:0;\n\tBORDER-COLLAPSE: COLLAPSE;\n}\n\nTD.CUSTPREVNEXT\n{\n\t/*BACKGROUND-COLOR:#E2E2E2;*/\n\tHEIGHT:0PX;\n\tWIDTH:0PX;\n\tFONT-FAMILY: VERDANA;\n\tFONT-SIZE: 8PT;\n\tCOLOR:#333333;\n\tFONT-WEIGHT:NORMAL;\n\tTEXT-ALIGN:RIGHT;\n\tPADDING-LEFT:0PX;\n\tPADDING-RIGHT:0PX;\n\tVERTICAL-ALIGN:TEXT-TOP;\n\tBORDER-BOTTOM:1PX;\n\tBORDER-TOP:0PX;\n\tBORDER-LEFT:0PX;\n\tBORDER-RIGHT:0PX;\n\tBORDER-STYLE:SOLID;\n\tBORDER-COLOR:#EEEEEE;\n}\n\nTD.CUSTMSGDESC\n{\n\tHEIGHT:30PX;\n\tWIDTH:247PX;\n\tFONT-FAMILY: VERDANA;\n\tFONT-SIZE: 8PT;\n\tCOLOR:#333333;\n\tFONT-WEIGHT:NORMAL;\n\tTEXT-ALIGN:LEFT;\n\tPADDING-LEFT:0PX;\n\tPADDING-RIGHT:0PX;\n\tVERTICAL-ALIGN:MIDDLE;\n\tBORDER-BOTTOM:1PX;\n\tBORDER-TOP:0PX;\n\tBORDER-LEFT:0PX;\n\tBORDER-RIGHT:0PX;\n\tBORDER-STYLE:SOLID;\n\tBORDER-COLOR:#EEEEEE;\n}\n\nTD.CUSTCHECKBOX\n{\n\tWIDTH:10PX;\n\tFONT-FAMILY: VERDANA;\n\tFONT-SIZE: 8PT;\n\tCOLOR:#333333;\n\tFONT-WEIGHT:NORMAL;\n\tTEXT-ALIGN:LEFT;\n\tPADDING-LEFT:0PX;\n\tPADDING-RIGHT:0PX;\n\tVERTICAL-ALIGN:MIDDLE;\n\tBORDER-BOTTOM:1PX;\n\tBORDER-TOP:0PX;\n\tBORDER-LEFT:0PX;\n\tBORDER-RIGHT:0PX;\n\tBORDER-STYLE:SOLID;\n\tBORDER-COLOR:#EEEEEE;\n}\n\nTD.CUSTIMGICON\n{\n\tWIDTH:32PX;\n\tFONT-FAMILY: VERDANA;\n\tFONT-SIZE: 8PT;\n\tCOLOR:#333333;\n\tFONT-WEIGHT:NORMAL;\n\tTEXT-ALIGN:LEFT;\n\tPADDING-LEFT:0PX;\n\tPADDING-RIGHT:0PX;\n\tVERTICAL-ALIGN:MIDDLE;\n\tBORDER-BOTTOM:1PX;\n\tBORDER-TOP:0PX;\n\tBORDER-LEFT:0PX;\n\tBORDER-RIGHT:0PX;\n\tBORDER-STYLE:SOLID;\n\tBORDER-COLOR:#EEEEEE;\n}\n\nTD.CUSTPREVMSGDESC\n{\n\tBACKGROUND-COLOR:#E2E2E2;\n\tHEIGHT:30PX;\n\tWIDTH:247PX;\n\tFONT-FAMILY: VERDANA;\n\tFONT-SIZE: 8PT;\n\tCOLOR:#888888;\n\tFONT-WEIGHT:NORMAL;\n\tTEXT-ALIGN:LEFT;\n\tPADDING-LEFT:0PX;\n\tPADDING-RIGHT:0PX;\n\tVERTICAL-ALIGN:MIDDLE;\n\tBORDER-BOTTOM:1PX;\n\tBORDER-TOP:0PX;\n\tBORDER-LEFT:0PX;\n\tBORDER-RIGHT:0PX;\n\tBORDER-STYLE:SOLID;\n\tBORDER-COLOR:#EEEEEE;\n}\n\nTD.CUSTPREVIMGICON\n{\n\tBACKGROUND-COLOR:#E2E2E2;\n\tWIDTH:32PX;\n\tFONT-FAMILY: VERDANA;\n\tFONT-SIZE: 8PT;\n\tCOLOR:#888888;\n\tFONT-WEIGHT:NORMAL;\n\tTEXT-ALIGN:LEFT;\n\tPADDING-LEFT:0PX;\n\tPADDING-RIGHT:0PX;\n\tVERTICAL-ALIGN:MIDDLE;\n\tBORDER-BOTTOM:1PX;\n\tBORDER-TOP:0PX;\n\tBORDER-LEFT:0PX;\n\tBORDER-RIGHT:0PX;\n\tBORDER-STYLE:SOLID;\n\tBORDER-COLOR:#EEEEEE;\n}\n\nTD.CUSTPREVCHECKBOX\n{\n\tBACKGROUND-COLOR:#E2E2E2;\n\tWIDTH:10PX;\n\tFONT-FAMILY: VERDANA;\n\tFONT-SIZE: 8PT;\n\tCOLOR:#333333;\n\tFONT-WEIGHT:NORMAL;\n\tTEXT-ALIGN:LEFT;\n\tPADDING-LEFT:0PX;\n\tPADDING-RIGHT:0PX;\n\tVERTICAL-ALIGN:MIDDLE;\n\tBORDER-BOTTOM:1PX;\n\tBORDER-TOP:0PX;\n\tBORDER-LEFT:0PX;\n\tBORDER-RIGHT:0PX;\n\tBORDER-STYLE:SOLID;\n\tBORDER-COLOR:#EEEEEE;\t\n}\n\nTD.CUSTPREVMSG\n{\n\tBACKGROUND-COLOR:#E2E2E2;\n\tWIDTH:91px;\n\tFONT-FAMILY: VERDANA;\n\tFONT-SIZE: 8PT;\n\tCOLOR:#8A0000;\n\tFONT-WEIGHT:NORMAL;\n\tTEXT-ALIGN:RIGHT;\n\tPADDING-LEFT:0PX;\n\tPADDING-RIGHT:0PX;\n\tVERTICAL-ALIGN:MIDDLE;\n\tBORDER-BOTTOM:1PX;\n\tBORDER-TOP:0PX;\n\tBORDER-LEFT:0PX;\n\tBORDER-RIGHT:0PX;\n\tBORDER-STYLE:SOLID;\n\tBORDER-COLOR:#EEEEEE;\n}\n\n\n\n</style>\n<body class=\'CONTENT\' OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\">\n<form name=\'CAMainCustomizeToolbarDtl\' id=\'CAMainCustomizeToolbarDtl\' action=\"CAMainCustomizeToolbarDtl.jsp?";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"  method=\'post\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\t\n\n\t \n     <table class=\'CUSTDISPMSG\' width=\'100%\' align=\'center\' id=tableId  cellpadding=\'0\' cellspacing=\'0\' border=\'0\'>\n\t     <tr>\n\t        <td class=\'CUSTMSGHEADER\' id=\'checkcount\' width=\'5%\'/>\n\t\t\t<!-- IN057229 starts -->\n\t\t\t<!--<td id=\'checkcount1\' class=\'CUSTMSGHEADER\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&nbsp;&nbsp;(Maximum 18)</td> -->\n\t\t\t<td id=\'checkcount1\' class=\'CUSTMSGHEADER\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t<!-- IN057229 ends -->\n\t     </tr>\n\t  </table>\n\t  <table width=\'100%\' class=\'CUSTOUTERTAB\' id=tableId>\n\t  <tr>\n\t  <td width=\'100%\'>\n\t\t <table border=\'0\'  cellpadding=\'0\' cellspacing=\'0\' width=\'100%\'>\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t<tr >\n\n\t\t\t\t<!-- <td  class=\'CUSTCHECKBOXDESC\'><input type=\'checkbox\' name=\"chk";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" id=\"chk";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" onclick=\'getCount(this)\'></td>\n\t\t\t\t<td class=\'CUSTIMGICON\'><img src=\'../../eCA/images/";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' alt=\'\' class=\'IMAGE\'></img>\n\t\t\t\t</td>\n\t\t\t\t<td class=\'CUSTMSGDESC\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td> -->\n\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t\t\t<td  class=\'CUSTCHECKBOX\'><input type=\'checkbox\' name=\"chk";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" onclick=\'getCount(this)\'></td>\n\t\t\t\t\t\t\t\t<td class=\'CUSTIMGICON\'><img src=\'../../eCA/images/";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' alt=\'\' class=\'IMAGE\'></img>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td class=\'CUSTMSGDESC\' colspan=\'2\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t\t\t\t<td  class=\'CUSTPREVCHECKBOX\'><input type=\'checkbox\' name=\"chk";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" onclick=\'getCount(this)\'></td>\n\t\t\t\t\t\t\t\t\t<td class=\'CUSTPREVIMGICON\'><img src=\'../../eCA/images/";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' alt=\'\' class=\'IMAGE\'></img>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=\'CUSTPREVMSGDESC\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t\t\t\t\t\t\t\t<td class=\'CUSTPREVMSG\' align=\'center\'>[";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="]</img></td>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t</tr>\n\n\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\n\t\t\n\t\t</table>\n\t\t\n\t\t<input type=hidden name=from value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n\t\t<input type=hidden name=to value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\n\t\t<input type=hidden name=\'start\' id=\'start\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n\t\t<input type=hidden name=\'end\' id=\'end\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n\t\t<input type=hidden name=\'practitioner_id\' id=\'practitioner_id\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n\t\t<input type=hidden name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n\t\t<input type=hidden name=\'menuId\' id=\'menuId\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n\t\t<input type=hidden name=\'patientclass\' id=\'patientclass\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n\t\t<input type=hidden name=\'mode\' id=\'mode\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n\t<script>\n\t\t\t\t//document.getElementById(\'checkcount\').innerText = \'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\';\n\t\t\t\tdocument.getElementById(\'checkcount\').innerText = \'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\';\n\t</script>\n\t</td>\n\t</tr>\n\t<tr>\n\t<td>\n\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\'>\n\t\t<tr>\n\t\t\t<td class=\'CUSTPREVNEXT\' width=\'100%\'>\n\t\n\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t<a href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =",";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =")\' text-decoration=\'none\'><img id=\'imgPrv\' src=\'../../eCommon/images/prev.jpg\' style=\'visibility:visible\'></img></a>\n\t\t\t\t<input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'prev\'>\n\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t<img id=\'imgPrv\' src=\'../../eCommon/images/prev.jpg\' style=\'visibility:hidden\'></img>\n\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =")\' text-decoration=\'none\'><img id=\'imgNext\' src=\'../../eCommon/images/next.jpg\' style=\'visibility:visible\'></img></a>\n\t\t\t\t<input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'next\'>\n\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t<img id=\'imgNext\' src=\'../../eCommon/images/next.jpg\' style=\'visibility:hidden\'></img>\n\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t</td>\n\t\t</tr>\n\t </table>\t\n\n\n\n\n</td>\n\t\t</tr>\n\t </table>\n\t ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n</form>\n</body>\n<script>\n\tfunction submitPrevNext(from, to)\n\t{\n\t\tdocument.CAMainCustomizeToolbarDtl.from.value = from;\n        document.CAMainCustomizeToolbarDtl.to.value = to; \n        document.CAMainCustomizeToolbarDtl.target = \"detailFrame\"\n        document.CAMainCustomizeToolbarDtl.submit();\n\t}\n\tfunction getCount(obj)\n\t{\n\t\tvar count;\n\t\tif(document.getElementById(\'checkcount\').innerText == \'undefined\' || document.getElementById(\'checkcount\').innerText == \'\')\n\t\t\tcount = 0;\n\t\telse\n\t\t\tcount = document.getElementById(\'checkcount\').innerText;\n\t\t\tcount = parseInt(count,10);\n\t\tif(obj.checked == true)\n\t\t{\n\t\t\tcount = count+1;\n\t\t}\n\t\telse\n\t\t{\n\t\t\tcount = count-1;\n\t\t}\n\t\t//IN057229 starts\n\t\t/*if(count >= 19)\n\t\t{*/\n\t\t\t//var msg = getMessage(\"MAXIMUM_ICONS_ALLOWED\",\"CA\");\n\t\t\t//msg = msg + \" 19\";\n\t\t\t//parent.messageFrame.location.href = \"../../eCommon/jsp/MstCodeError.jsp?err_num=\"+msg+\"&err_value=0\";\n\t\t/*\tdocument.getElementById(\'checkcount\').style.color=\'#8A0000\';\n\t\t\tdocument.getElementById(\'checkcount1\').style.color=\'#8A0000\';\n\t\t\tobj.checked = false;\n\t\t\treturn false;\n\n\t\t}\n\t\telse{*/\n\t\t//IN057229 ends\n\t\t\tdocument.getElementById(\'checkcount\').innerText = count;\n\t\t\tdocument.getElementById(\'checkcount\').style.color=\'#4C4C4C\';\n\t\t\tdocument.getElementById(\'checkcount1\').style.color=\'#4C4C4C\';\n\t\t//}IN057229\n\t\t\t\n\t}\n\t/*function updateIcons()\n\t{\n\t\tdocument.CAMainCustomizeToolbarDtl.action = \"../../servlet/eCA.CAMainCustomizeToolbarServlet?";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\"\n        document.CAMainCustomizeToolbarDtl.submit();\n\t}*/\n</script>\n</html>\n\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );
	
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
 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History	Name			Rev.Date		Rev.Name			Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           										created

28/08/2015		IN057229	Vijayakumar K	28/08/2015		Ramesh Goli			Regression-EM-Alpha-Unable to access 
																				CA functions in Desktop as well as in patient Chart.
-------------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	webbeans.eCommon.RecordSet CustomizeIcons = (webbeans.eCommon.RecordSet)getObjectFromBean("CustomizeIcons","webbeans.eCommon.RecordSet",session);
	//eCA.CAMainOptionBean CAMainMenu = (eCA.CAMainOptionBean)getObjectFromBean("CAMainMenu","eCA.CAMainOptionBean",session);

            _bw.write(_wl_block4Bytes, _wl_block4);

String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String from			= request.getParameter("from") ;
	String to			= request.getParameter("to") ;
	String checkedOnes	= "";
	String  req_start   =   "", req_end     =   "";

	String menu_id = request.getParameter("menuId")==null?"MED_DFLT":request.getParameter("menuId");
	String patientclass = request.getParameter("patientclass") == null ? "" : request.getParameter("patientclass");

	String practitioner_id	= (String) session.getValue("ca_practitioner_id");
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String mode = request.getParameter("mode")==null?"V":request.getParameter("mode");
	String episode_id = request.getParameter("episode_id")==null?"":request.getParameter("episode_id");
	String speciality_code = request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code");

	String resp_id				= (String)session.getValue("responsibility_id");
	//String reln_id				= (String)session.getValue("relationship_id");
	String reln_id				= request.getParameter("relationship_id");
	String facilityId			= (String)session.getValue("facility_id");
	//String ClassValue = "";
	if(resp_id == null) resp_id = "";
	if(reln_id == null) reln_id = "";

	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Connection con = null;

	int maxRecord = 0;
	int start = 0 ;
	int end = 0 ;
	int i=1;
	
	if (from == null){ start = 1 ;  }   else {  start = Integer.parseInt( from ) ; }
	if (to == null){ end = 10 ; }   else {  end = Integer.parseInt( to ) ; }


	req_start       =   (request.getParameter("start")==null)   ?   "0" : request.getParameter("start");
	req_end         =   (request.getParameter("end")==null)     ?   "0" : request.getParameter("end");

	//String facility_id = (String)session.getValue("facility_id");
	//String occurance = request.getParameter("occurance");

	if(from != null && to != null ) {
		int j=0;
		for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++){
			if(request.getParameter("chk"+(i-1)) != null) {
				checkedOnes = request.getParameter("chk"+(i-1));
				if(!(CustomizeIcons.containsObject(checkedOnes))){
					CustomizeIcons.putObject(checkedOnes);
				}

				j++;
			}
		}
		out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
		out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
	}
	putObjectInBean("CustomizeIcons", CustomizeIcons,session);
	i = 1;

	try
	{
		con = ConnectionManager.getConnection(request);
		//String classValue = "";
		String option_id	= "";
		String short_desc	= "";
		String icon_file_name= "";
		String executable_name= "";
		int ilCkeckedYN = 0;
		int recordCount = 0;
		String checkStatus  = "";	
		String checkProp = "";
		String desktop_yn = "";
		String pat_appl_yn = "";
		String hist_or_record = "";
		String allow_yn = "";
		StringBuffer sql = new StringBuffer();
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	    String locale = (String) p.getProperty("LOCALE");
		sql.append("select a.OPTION_ID, LONG_DESC, ICON_FILE_NAME, EXECUTABLE_NAME, DESKTOP_YN ");

		if(!patient_id.equals(""))
		{
			if(patientclass.equals(""))
				patientclass = "XT";

			sql.append(", APPL_"+patientclass+"_YN Pat_APPL_YN , a.HIST_OR_RECORD HIST_OR_RECORD");
		}
		else
		{
			sql.append(", 'N' Pat_APPL_YN , '' HIST_OR_RECORD ");
		}
		
		sql.append(" , NVL((SELECT 'Y' FROM CA_APPL_TASK ia WHERE ia.option_id = a.option_id and 'A' = Get_Task_Applicability(APPL_TASK_ID,DFLT_PRIVILEGE_STATUS,?,?,?,?,?) and  (ia.BASE_MODULE_ID = 'CA' or  exists( select 1 from sm_module where install_yn = 'Y' and MODULE_ID = ia.BASE_MODULE_ID ");
		if(!patient_id.equals(""))
		{
			sql.append(" and ( MODULE_GROUP_ID! = 'SS' OR EXISTS (SELECT 1 FROM AM_SPLTY_FOR_SPLTY_MODULES WHERE MODULE_ID = ia.BASE_MODULE_ID AND  SPECIALITY_CODE = ? )) ");
		}
		sql.append(" )) and rownum=1),'N') Allow_yn from ca_option_lang_vw a, CA_MENU_DETAIL b where ");

		if(!patient_id.equals(""))
		{
			sql.append(" DESKTOP_YN = 'N' ");
		}
		else
		{
			sql.append(" DESKTOP_YN = 'Y' ");
		}

		//sql.append(" and a.language_id='"+locale+"' and b.MENU_ID = '"+menu_id+"' and b.option_id = a.option_id and exists (SELECT 'Y' FROM CA_APPL_TASK ia WHERE ia.option_id = a.option_id and   (ia.BASE_MODULE_ID = 'CA' or  exists( select 1 from sm_module where install_yn = 'Y' and MODULE_ID = ia.BASE_MODULE_ID ))) and ICON_FILE_NAME is not null order by a.ORDER_SEQ_NO");//common-icn-0180
		sql.append(" and a.language_id= ? and b.MENU_ID = ? and b.option_id = a.option_id and exists (SELECT 'Y' FROM CA_APPL_TASK ia WHERE ia.option_id = a.option_id and   (ia.BASE_MODULE_ID = 'CA' or  exists( select 1 from sm_module where install_yn = 'Y' and MODULE_ID = ia.BASE_MODULE_ID ))) and ICON_FILE_NAME is not null order by a.ORDER_SEQ_NO");//common-icn-0180

		pstmt = con.prepareStatement(sql.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		
		
		int indval =1;

		pstmt.setString(indval++,resp_id);
		pstmt.setString(indval++,reln_id);
		pstmt.setString(indval++,facilityId);
		pstmt.setString(indval++,episode_id);
		pstmt.setString(indval++,patient_id);
		if(!patient_id.equals(""))
			pstmt.setString(indval++,speciality_code);
		//pstmt.setString(indval++,resp_id);
		//pstmt.setString(indval++,reln_id);
		//pstmt.setString(indval++,facilityId);
		//pstmt.setString(indval++,episode_id);
		//pstmt.setString(indval++,patient_id);
        pstmt.setString(indval++,locale);//common-icn-0180
        pstmt.setString(indval++,menu_id);//common-icn-0180

		rs = pstmt.executeQuery();
		rs.last();
		maxRecord = rs.getRow();
		rs.beforeFirst();

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

			if (start != 0){
            for(int j=1; j<start; i++,j++){
                rs.next() ;
             }
			 ilCkeckedYN+=start;
             --ilCkeckedYN ;
			}
			recordCount			=	CustomizeIcons.getSize();

			//classValue  = "";
			while(rs.next()&& i<=end)
			{
				option_id = rs.getString("OPTION_ID")==null?"":rs.getString("OPTION_ID");
				short_desc = rs.getString("LONG_DESC")==null?"":rs.getString("LONG_DESC");
				icon_file_name = rs.getString("ICON_FILE_NAME")==null?"":rs.getString("ICON_FILE_NAME");
				executable_name = rs.getString("EXECUTABLE_NAME")==null?"":rs.getString("EXECUTABLE_NAME");
				desktop_yn = rs.getString("DESKTOP_YN")==null?"":rs.getString("DESKTOP_YN");
				pat_appl_yn = rs.getString("Pat_APPL_YN")==null?"":rs.getString("Pat_APPL_YN");
				hist_or_record = rs.getString("HIST_OR_RECORD")==null?"":rs.getString("HIST_OR_RECORD");
				allow_yn = rs.getString("Allow_yn")==null?"":rs.getString("Allow_yn");
				//if(CAMainMenu.chkContainsValue(option_id)){

				try
				{
					if(CustomizeIcons.containsObject(option_id))
					{

						checkStatus = "Y";
					}
					else
					{
						checkStatus = "N";
					}

					int recordIndex = CustomizeIcons.indexOfObject(option_id);
					if(recordIndex!=-1){
						if(checkStatus.equals("Y")){
							CustomizeIcons.removeObject(recordIndex);
						}
					}
				} catch(Exception e) {
              //  out.println("Exception in CAMainCustomizeToolbarDtl.jsp: "+e.toString());//COMMON-ICN-0181
                  e.printStackTrace();//COMMON-ICN-0181
				}
				if(checkStatus.trim().equals("Y")) {
					checkProp = " CHECKED "; 
				} else {
					checkProp = "";
				}

		
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(ilCkeckedYN));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(ilCkeckedYN));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(option_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(checkProp));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(icon_file_name));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block17Bytes, _wl_block17);

				if(!patient_id.equals(""))
				{
					if((eCA._ca_license_rights.getKey()).equals("CABASIC"))
					{
						if(!option_id.equals("CLINICAL_NOTES") && !option_id.equals("CLINICAL_NOTES_NEW") && !option_id.equals("PATCHIEFCOMPLAINT") && !option_id.equals("REL_PAT_TREAT_PAT") && !option_id.equals("CA_TASK_LIST") && !option_id.equals("CA_TASK_LIST_DT"))
						{
							if(mode.equals("V"))
							{
								if( pat_appl_yn.equals("Y") && !hist_or_record.equals("R") && allow_yn.equals("Y")){
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(ilCkeckedYN));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(ilCkeckedYN));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(option_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(checkProp));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(icon_file_name));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);
}else{
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(ilCkeckedYN));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(ilCkeckedYN));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(option_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(checkProp));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(icon_file_name));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
}
							}
							else
							{
								if(pat_appl_yn.equals("Y") && allow_yn.equals("Y")){
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(ilCkeckedYN));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(ilCkeckedYN));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(option_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(checkProp));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(icon_file_name));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);
}else{
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(ilCkeckedYN));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(ilCkeckedYN));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(option_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(checkProp));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(icon_file_name));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
}
							}
						}
						else{
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(ilCkeckedYN));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(ilCkeckedYN));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(option_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(checkProp));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(icon_file_name));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
}
					}
					else
					{
						if(mode.equals("V"))
						{
							if( pat_appl_yn.equals("Y") && !hist_or_record.equals("R") && allow_yn.equals("Y")){
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(ilCkeckedYN));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(ilCkeckedYN));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(option_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(checkProp));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(icon_file_name));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);
}
							else{
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(ilCkeckedYN));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(ilCkeckedYN));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(option_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(checkProp));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(icon_file_name));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
}
						}
						else
						{
							if(pat_appl_yn.equals("Y") && allow_yn.equals("Y")){
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(ilCkeckedYN));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(ilCkeckedYN));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(option_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(checkProp));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(icon_file_name));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);
}
							else{
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(ilCkeckedYN));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(ilCkeckedYN));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(option_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(checkProp));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(icon_file_name));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
}
						}
					}
				}
				else
				{
					if((eCA._ca_license_rights.getKey()).equals("CABASIC"))
					{
						if(!option_id.equals("CA_TASK_LIST") && !option_id.equals("REL_PAT_TREAT") && !option_id.equals("CA_TASK_LIST_DT"))
						{
							if(desktop_yn.equals("Y") && allow_yn.equals("Y")){
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(ilCkeckedYN));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(ilCkeckedYN));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(option_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(checkProp));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(icon_file_name));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);
}
							else{
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(ilCkeckedYN));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(ilCkeckedYN));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(option_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(checkProp));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(icon_file_name));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
}
						}
						else{
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(ilCkeckedYN));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(ilCkeckedYN));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(option_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(checkProp));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(icon_file_name));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
}
					}
					else
					{
						if(desktop_yn.equals("Y") && allow_yn.equals("Y")){
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(ilCkeckedYN));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(ilCkeckedYN));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(option_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(checkProp));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(icon_file_name));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);
}
						else{
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(ilCkeckedYN));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(ilCkeckedYN));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(option_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(checkProp));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(icon_file_name));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
}
					}
				}
		
            _bw.write(_wl_block27Bytes, _wl_block27);

				ilCkeckedYN = ilCkeckedYN + 1;		
				i=i+1;
				//}
			}
			out.println("<input type=hidden name='count' id='count' value="+(ilCkeckedYN-1)+">");
 			out.println("<input type='hidden' name='recordCount' id='recordCount' value='"+ recordCount +"'>");
			out.println("<input type=hidden name=occurance value='next'>");
			
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(start));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(end));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(start));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(end));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(menu_id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(patientclass));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(recordCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(recordCount));
            _bw.write(_wl_block39Bytes, _wl_block39);

		if ( !(start <= 1)) 
		{
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf((start-10)));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf((end-10)));
            _bw.write(_wl_block42Bytes, _wl_block42);
}else
			{
            _bw.write(_wl_block43Bytes, _wl_block43);
}
	
		if ( !((start+10) > maxRecord ))
		{
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf((start+10)));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf((end+10)));
            _bw.write(_wl_block44Bytes, _wl_block44);
}
			else
			{
            _bw.write(_wl_block45Bytes, _wl_block45);
}
	
            _bw.write(_wl_block46Bytes, _wl_block46);

		}
		catch(Exception e){
			//out.println("Exception in CAMainCustomizeToolbarDtl.jsp"+e.toString());//COMMON-ICN-0181
                           e.printStackTrace();//COMMON-ICN-0181
		}finally{
		    if(con != null)ConnectionManager.returnConnection(con,request);
		}
	 
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block48Bytes, _wl_block48);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.IconsSelected.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.IconsSelected.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.NoPrivilege.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.NoPrivilege.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.NoPrivilege.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.NoPrivilege.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.NoPrivilege.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.NoPrivilege.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.NoPrivilege.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.NoPrivilege.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
