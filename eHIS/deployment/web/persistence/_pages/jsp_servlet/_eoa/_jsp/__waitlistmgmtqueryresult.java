package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
import eCommon.XSSRequestWrapper;

public final class __waitlistmgmtqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/WaitListMgmtQueryResult.jsp", 1732098738449L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="     \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<HTML>\n\t<head>\n\t\t<script src=\"../../eOP/js/menu.js\" language=\"JavaScript1.2\"></script>\n\t\t<script src=\"../../eOA/js/QueryLocnForDay.js\"></script>\n\t\t<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link>\n\t\t -->\n\t\t ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eOA/js/WaitListMgmt.js\' language=\'javascript\'></script>\n\t\t</head>\n\n\t\t\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t<body OnMouseDown=\'CodeArrest();\'onKeyDown = \'lockKey()\' onscroll=\'scrollTitle()\' >\n\t\t<form name=\'QueryApptForPatient\' id=\'QueryApptForPatient\'>\n\t\t\t<input type=hidden name=\'from\' id=\'from\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>\n\t\t\t\t\t\t<input type=hidden name=\'to\' id=\'to\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n\t\t\t\t\t\t<input type=hidden name=\'start\' id=\'start\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n\t\t\t\t\t\t<input type=hidden name=\'end\' id=\'end\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n\n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\n\t<table width=\'90%\' border=0 align=\'center\' >\n\t\t<tr>\n\t\t<td align=\'right\' class=\'NONURGENT\'>\n\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t<a href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =",";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =")\' id=\'prev\' text-decoration=\'none\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</a>\n\t\t<input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'prev\'>\n\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =")\' id=\'next\' text-decoration=\'none\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</a><input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'next\'>\n\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\n\t</td>\n\t </tr>\n\t\t</table>\n\n\t\t\n\t\t<table border=\"1\" width=\"150%\" bgColor=white cellspacing=\'0\' cellpadding=\'0\' id=\'tb3\'>\n\t\t\t\t<td class=\"COLUMNHEADER\" width=\'8%\'><div  id=\'head1\'  class=\'myClass\' nowrap >";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</div></td>\n\t\t\t\t<td class=\"COLUMNHEADER\" width=\'12%\'><div  id=\'head2\'  class=\'myClass\' nowrap >";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</div></td>\n\t\t\t\t<td class=\"COLUMNHEADER\" width=\'17%\'><div  id=\'head3\'  class=\'myClass\' nowrap >";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</div></td>\n\t\t\t\t<td class=\"COLUMNHEADER\" width=\'13%\'><div  id=\'head4\'  class=\'myClass\' nowrap >";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</div></td>\n\n\t\t\t\t<td class=\"COLUMNHEADER\" width=\'13%\'><div  id=\'head11\'  class=\'myClass\' nowrap >";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</div></td>\n\n\t\t\t\t<td class=\"COLUMNHEADER\" width=\'10%\'><div  id=\'head5\'  class=\'myClass\' nowrap >";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</div></td>\n\t\t\t\t<td class=\"COLUMNHEADER\" width=\'16%\'><div  id=\'head6\'  class=\'myClass\' nowrap >";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</div></td>\n\t\t\t\t<td class=\"COLUMNHEADER\" width=\'15%\'><div  id=\'head7\'  class=\'myClass\' nowrap >";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</div></td>\n\t\t\t\t<td class=\"COLUMNHEADER\" width=\'30%\'><div  id=\'head8\'  class=\'myClass\' nowrap >";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</div></td>\n\t\t\t\t<td class=\'COLUMNHEADER\' nowrap width=\'13%\'><div  id=\'head9\'  class=\'myClass\' nowrap >";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</div></td>\n\t\t\t\t<td class=\"COLUMNHEADER\" width=\'30%\'><div  id=\'head10\'  class=\'myClass\' nowrap >";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</div></td>\n\t\t\n\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\t<tr >\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' id=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\"  onMouseOver=\'hideToolTip(\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\")\' width=\'8%\' onClick=\"displayToolTip(\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\',\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\',\t\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\')\" ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="> \n\t\t\t\t\t\t<a href=\"javascript:callDummy()\">";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</a>&nbsp;</td>\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' width=\'8%\'><a href=\"javascript:show_ModifyWin(\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\',\'Y\')\">";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</a></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\')\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="><a href=\"javascript:callDummy()\">";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</a>&nbsp;\n\t\t\t\t\t\t</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' width=\'8%\'>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\"  onClick=\'hideToolTip()\' width=\'12%\'>";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="&nbsp;</td>\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\"   width=\'17%\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\"  width=\'13%\' nowrap>";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="&nbsp;&nbsp;</td>\n                    <td class=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\"  width=\'10%\' nowrap>";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\"  width=\'16%\' nowrap>";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="&nbsp;</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\n\t\t\t\t\t\t<td  class=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\'  width=\'15%\' nowrap>";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="/";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="&nbsp;</td>\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\'  width=\'30%\' nowrap>";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\'  onClick=\'hideToolTip()\' width=\'13%\' ><a href=\'javascript:onclick=past_visits_view(\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\")\'>";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\'  width=\'13%\' nowrap>&nbsp;</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t\t<td  class=\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="&nbsp;</td>\n\t\t\t\t\t\t\n\t\t\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t\t<script>alert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));\n\t\t\tparent.frames[3].location.href=\'../../eCommon/html/blank.html\';</script>\n\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t\t<script >\n\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'hidden\';\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t<script >\n\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'visible\';\n\t\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t<input type=\'hidden\' name=\'oper_stn_id\' id=\'oper_stn_id\' value=\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\'>\n\t\t\t<input type=\'hidden\' name=\'ALCN_CRITERIA_YN\' id=\'ALCN_CRITERIA_YN\' value=\'";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\'>\n\t\t\t<input type=\'hidden\' name=\'specCode\' id=\'specCode\' value=\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\'>\n\t\t\t<input type=hidden name=\'elaspsed\' id=\'elaspsed\' value=\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\'>\n\t\t\t<input type=hidden name=\'cliniccode\' id=\'cliniccode\' value=\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\'>\n\t\t\t<input type=hidden name=\'practcode\' id=\'practcode\' value=\'";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\'>\n\t\t\t<input type=hidden name=\'waitListfrmdate\' id=\'waitListfrmdate\' value=\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\'>\n\t\t\t<input type=hidden name=\'waitListTodate\' id=\'waitListTodate\' value=\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\'>\n\t\t\t<input type=hidden name=\'clinic_type\' id=\'clinic_type\' value=\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\'>\n\t\t\t<input type=hidden name=\'res_type\' id=\'res_type\' value=\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\'>\n\t\t\t<input type=hidden name=\'elapsed_grace_period\' id=\'elapsed_grace_period\' value=\'";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\'>\n\t\t\t<input type=hidden name=\'wtlt_category\' id=\'wtlt_category\' value=\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\'>\n\t\t\t<input type=hidden name=\'wtlt_category_one\' id=\'wtlt_category_one\' value=\'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\'>\n\t\t\t<input type=hidden name=\'nat_id_no\' id=\'nat_id_no\' value=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\">\n\t\t\t<input type=hidden name=\'alt_id1_no\' id=\'alt_id1_no\' value=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\">\n\t\t\t<input type=hidden name=\'alt_id1_type\' id=\'alt_id1_type\' value=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\">\n\t\t\t<input type=hidden name=\'alt_id2_no\' id=\'alt_id2_no\' value=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\">\n\t\t\t<input type=hidden name=\'alt_id2_type\' id=\'alt_id2_type\' value=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\">\n\t\t\t<input type=hidden name=\'alt_id3_no\' id=\'alt_id3_no\' value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\">\n\t\t\t<input type=hidden name=\'alt_id3_type\' id=\'alt_id3_type\' value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\">\n\t\t\t<input type=hidden name=\'alt_id4_no\' id=\'alt_id4_no\' value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\">\n\t\t\t<input type=hidden name=\'alt_id4_type\' id=\'alt_id4_type\' value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\">\n\t\t\t<input type=hidden name=\'other_alt_Id\' id=\'other_alt_Id\' value=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\">\n\t\t\t<input type=hidden name=\'other_alt_type\' id=\'other_alt_type\' value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\">\n\t\t\t<input type=hidden name=\'nat_id_code\' id=\'nat_id_code\' value=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\">\n\t\t\t<input type=hidden name=\'r_area\' id=\'r_area\' value=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\">\n\t\t\t<input type=hidden name=\'m_area\' id=\'m_area\' value=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\">\n\t\t\t<input type=hidden name=\'r_region\' id=\'r_region\' value=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\">\n\t\t\t<input type=hidden name=\'m_region\' id=\'m_region\' value=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\">\n\t\t\t<input type=hidden name=\'r_town\' id=\'r_town\' value=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\">\n\t\t\t<input type=hidden name=\'m_town\' id=\'m_town\' value=\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\">\n\t\t\t<input type=hidden name=\'priority\' id=\'priority\' value=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\">\n\t\t\t<input type=hidden name=\'reason_for_modify\' id=\'reason_for_modify\' value=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\">\n\t\t\t<input type=hidden name=\'cntval\' id=\'cntval\' value=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\">\n\t\t\t<input type=hidden name=\'web_no_show_flag\' id=\'web_no_show_flag\' value=\"\">\n\t\t\t<!--below line is added for Bru-HIMS-CRF-173-->\n\t\t\t<input type=hidden name=\'wtListControl\' id=\'wtListControl\' value=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\">\n\t\t\t<input type=hidden name=\'rd_appt_yn\' id=\'rd_appt_yn\' value=\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\">\n\t\t\t</table>\n  ";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="  \n<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:15%; visibility:hidden;\' bgcolor=\'blue\'>\n<table id=\'tooltiptable\' cellpadding=0 cellspacing=0 border=\'0\' width=\'auto\' height=\'100%\' align=\'center\'>\n<tr><td width=\'100%\' id=\'t\'></td></tr>\n</table>\n</center>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
 
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		String fac_id		= (String) session.getValue( "facility_id" ) ;
		String locale = (String)session.getAttribute("LOCALE");
		StringBuffer sql=new StringBuffer("") ;
		String web_request_yn="N";
		String patientid	=   request.getParameter("patientid")== null?"":request.getParameter("patientid");
		String practitioner	=   request.getParameter("practitioner")== null?"":request.getParameter("practitioner");
		
		
		String rd_appt_yn	=	request.getParameter("rd_appt_yn")== null?"N":request.getParameter("rd_appt_yn");
		String WaitListNo	=	request.getParameter("WaitListNo")== null?"":request.getParameter("WaitListNo");
		String patientname	=	request.getParameter("patientname")== null?"":request.getParameter("patientname");
		String cliniccode	=	request.getParameter("cliniccode")== null?"":request.getParameter("cliniccode");
		String practcode	=	request.getParameter("practcode")== null?"":request.getParameter("practcode");
		String gender		=	request.getParameter("gender")== null?"":request.getParameter("gender");
		String waitListfrmdate	=	request.getParameter("waitListfrmdate")== null?"":request.getParameter("waitListfrmdate");
		String waitListTodate	=	request.getParameter("waitListTodate") == null?"":request.getParameter("waitListTodate");
		String stylSetter="";
		String patient_name_yn="N";		
		waitListfrmdate=DateUtils.convertDate(waitListfrmdate,"DMY",locale,"en");
		waitListTodate=DateUtils.convertDate(waitListTodate,"DMY",locale,"en");
		
		String clinic_type=	request.getParameter("clinic_type") == null?"":request.getParameter("clinic_type");
		String res_type=	request.getParameter("res_type") == null?"":request.getParameter("res_type");
		String specCode=	request.getParameter("specCode") == null?"":request.getParameter("specCode");
	//	String frmClinicCode=	request.getParameter("frmClinicCode") == null?"":request.getParameter("frmClinicCode");
	//	out.println("cliniccode--->"+cliniccode);
		String elapsed=request.getParameter("elaspsed")==null?"":request.getParameter("elaspsed");
		String oper_stn_id=request.getParameter("oper_stn_id")==null?"":request.getParameter("oper_stn_id");
		String ALCN_CRITERIA_YN=request.getParameter("ALCN_CRITERIA_YN");
		if(ALCN_CRITERIA_YN ==null) ALCN_CRITERIA_YN="";
		String elapsed_grace_period=request.getParameter("elapsed_grace_period");
		if(elapsed_grace_period ==null) elapsed_grace_period="";
		String nat_id_no=request.getParameter("nat_id_no");
		if(nat_id_no ==null) nat_id_no="";
		String alt_id1_no=request.getParameter("alt_id1_no");
		if(alt_id1_no ==null) alt_id1_no="";
		String alt_id1_type=request.getParameter("alt_id1_type");
		if(alt_id1_type ==null) alt_id1_type="";
		String alt_id2_no=request.getParameter("alt_id2_no");
		if(alt_id2_no ==null) alt_id2_no="";
		String alt_id2_type=request.getParameter("alt_id2_type");
		if(alt_id2_type ==null) alt_id2_type="";
		String alt_id3_no=request.getParameter("alt_id3_no");
		if(alt_id3_no ==null) alt_id3_no="";
		String alt_id3_type=request.getParameter("alt_id3_type");
		if(alt_id3_type ==null) alt_id3_type="";
		String alt_id4_no=request.getParameter("alt_id4_no");
		if(alt_id4_no ==null) alt_id4_no="";
		String alt_id4_type=request.getParameter("alt_id4_type");
		if(alt_id4_type ==null) alt_id4_type="";
		String other_alt_Id=request.getParameter("other_alt_Id");
		if(other_alt_Id ==null) other_alt_Id="";
		String other_alt_type=request.getParameter("other_alt_type");
		if(other_alt_type ==null) other_alt_type="";

		String nat_id_code=request.getParameter("nat_id_code");
		if(nat_id_code ==null) nat_id_code="";
		String r_area_code=request.getParameter("r_area");
		if(r_area_code ==null) r_area_code="";
		String m_area_code=request.getParameter("m_area");
		if(m_area_code ==null) m_area_code="";
		String r_region_code=request.getParameter("r_region");
		if(r_region_code ==null) r_region_code="";
		String m_region_code=request.getParameter("m_region");
		if(m_region_code ==null) m_region_code="";
		String r_town_code=request.getParameter("r_town");
		if(r_town_code ==null) r_town_code="";
		String m_town_code=request.getParameter("m_town");
		if(m_town_code ==null) m_town_code="";
		String wtlt_category=request.getParameter("wtlt_category");
		if(wtlt_category ==null) wtlt_category="";
		
		String wtlt_category_one=request.getParameter("wtlt_category_one");
		if(wtlt_category_one ==null) wtlt_category_one="";

		String priority1=request.getParameter("priority");
		if(priority1==null)priority1="";
		
		String from = request.getParameter( "from" ) ;
		String to = request.getParameter( "to" ) ;
		String classValue	 = "";
		String waitListNo="";
		String priority="";
		String patientId="";
		String patientName="";
		String preferedDate="";
		String preferedDate_disp="";
		String specialityDesc="";
		String locationDesc="";
		//String resourceClass="";
		//String res_class_desc="";
		String resource="";
		String clinicDesc="";
		String careLocnTypeInd="";
		String clinicCode="";
		String resourceId="";
		String specialityCode="";
		String resClass="";
		String SPECIALITY_DESC="";
		String WAITLIST_CAT_DESC="";
		String reason_for_modify="";
		String wait_list_ref_no="";
		String rd_waitlist_yn="";
		String order_catalog_code="";
		//String	start_index	= "";	
		//String end_index =	"";
		//start_index		=	(request.getParameter("start_index")==null)		?	"0"		:	request.getParameter("start_index");
		//end_index		=	(request.getParameter("end_index")==null)		?	"11"	:	request.getParameter("end_index");
		
		/*added for Bru-HIMS-CRF-173*/
		String wtListControl = request.getParameter("wtListControl")==null?"":request.getParameter("wtListControl");
		
		

		if (!patientName.equals(""))
		{
			patientName		= 	patientName + "%" ;
		}
	int start = 0 ;
	int end = 0 ;
int s=1;
	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 15 ;
	else
		end = Integer.parseInt( to ) ;



		String req_start = "", req_end = "";
		Statement stmt				= null;
		ResultSet rs				= null;
		Connection conn=null;
		Statement st=null;
		ResultSet rsSet=null;

		req_start       =   (request.getParameter("start")==null)?"0" :   request.getParameter("start");
		req_end         =   (request.getParameter("end")==null)?"0" :   request.getParameter("end");
	
            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

try
{
			conn = ConnectionManager.getConnection(request);

			stmt	 = conn.createStatement();			
			//StringBuffer sql2 = new StringBuffer();
			StringBuffer sql3 = new StringBuffer();
			//String sqlmain="";
			StringBuffer sqlmain2= new StringBuffer();
			int i=0;	
			if(elapsed ==null) elapsed="N";
			//commented the following linfg code as it was developed for web request demo  
			/*Below Query Modified for this [35078]*/
			/*Below query commented by venkatesh against GHL-SCF-992  on 18-02-2016 */
			//sql.append("select nvl(WAIT_LIST_NO,'') wait_list_no, decode(WAIT_LIST_PRIORITY,'U','Urgent','S','Semi Urgent','N','Normal') priority , nvl(PATIENT_ID,'') patient_id,  to_char(PREFERRED_DATE_TIME,'dd/mm/yyyy') pref_date_time , nvl(SPECIALTY_CODE,'') spec_desc, nvl(AM_GET_DESC.AM_CARE_LOCN_TYPE((select clinic_type from op_clinic where facility_id='"+fac_id+"' and CLINIC_CODE=locn_code),'"+locale+"','1'), '') locn_desc , nvl(RESOURCE_CLASS,'') resc_class, decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(resource_id,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, resource_id,'"+locale+"','2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, resource_id,'"+locale+"','2'),'O', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, resource_id,'"+locale+"','2')) PRACTITIONER_SHORT_NAME, (decode(care_locn_type_ind, 'N', (IP_GET_DESC.IP_NURSING_UNIT(FACILITY_ID, locn_code,'"+locale+"','2')))), OP_GET_DESC.OP_CLINIC(FACILITY_ID, locn_code, '"+locale+"','1') CLINIC_SHORT_DESC, SPECIALTY_CODE, care_locn_type_ind, locn_code clinic_code, resource_id PRACTITIONER_ID, resource_class, AM_GET_DESC.AM_SPECIALITY(specialty_code,'"+locale+"','2') SPECIALITY_DESC, (CASE WHEN pr_wait_list.waitlist_category_code IS NOT NULL THEN (SELECT long_desc FROM oa_waitlist_category_lang_vw WHERE waitlist_category_code = pr_wait_list.waitlist_category_code and language_id = '"+locale+"') END) WAITLIST_CAT_DESC, decode('"+locale+"','en',patient_name, nvl(patient_name_loc_lang, patient_name)) patient_name,AM_GET_DESC.AM_CONTACT_REASON(REASON_FOR_MODIFY,'"+locale+"','1')  REASON_FOR_MODIFY,wait_list_ref_no,rd_waitlist_yn,order_catalog_code  from pr_wait_list where facility_id = '"+fac_id+"'  and wait_list_status='O'");
			
			/* Below query Modified by venkatesh against GHL-SCF-992 on 18-02-2016 */
			sql.append("SELECT wait_list_no, priority,patient_id, pref_date_time, spec_desc, locn_desc, resc_class, practitioner_short_name, clinic_short_desc,specialty_code, care_locn_type_ind, clinic_code, practitioner_id,resource_class, speciality_desc, waitlist_cat_desc, patient_name, reason_for_modify, wait_list_ref_no, rd_waitlist_yn, order_catalog_code, eff_status FROM (select nvl(WAIT_LIST_NO,'') wait_list_no, decode(WAIT_LIST_PRIORITY,'U','Urgent','S','Semi Urgent','N','Normal') priority , nvl(PATIENT_ID,'') patient_id,  to_char(PREFERRED_DATE_TIME,'dd/mm/yyyy') pref_date_time , nvl(SPECIALTY_CODE,'') spec_desc, nvl(AM_GET_DESC.AM_CARE_LOCN_TYPE((select clinic_type from op_clinic where facility_id='"+fac_id+"' and CLINIC_CODE=locn_code),'"+locale+"','1'), '') locn_desc , nvl(RESOURCE_CLASS,'') resc_class, decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(resource_id,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, resource_id,'"+locale+"','2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, resource_id,'"+locale+"','2'),'O', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, resource_id,'"+locale+"','2')) PRACTITIONER_SHORT_NAME, (decode(care_locn_type_ind, 'N', (IP_GET_DESC.IP_NURSING_UNIT(FACILITY_ID, locn_code,'"+locale+"','2')))), OP_GET_DESC.OP_CLINIC(FACILITY_ID, locn_code, '"+locale+"','1') CLINIC_SHORT_DESC, SPECIALTY_CODE, care_locn_type_ind, locn_code clinic_code, resource_id PRACTITIONER_ID, resource_class, AM_GET_DESC.AM_SPECIALITY(specialty_code,'"+locale+"','2') SPECIALITY_DESC, (CASE WHEN pr_wait_list.waitlist_category_code IS NOT NULL THEN (SELECT long_desc FROM oa_waitlist_category_lang_vw WHERE waitlist_category_code = pr_wait_list.waitlist_category_code and language_id = '"+locale+"') END) WAITLIST_CAT_DESC, decode('"+locale+"','en',patient_name, nvl(patient_name_loc_lang, patient_name)) patient_name,AM_GET_DESC.AM_CONTACT_REASON(REASON_FOR_MODIFY,'"+locale+"','1')  REASON_FOR_MODIFY,wait_list_ref_no,rd_waitlist_yn,order_catalog_code ,(CASE WHEN (    pr_wait_list.resource_class = 'P'AND pr_wait_list.resource_id IS NOT NULL)  THEN (SELECT eff_status FROM am_practitioner   WHERE practitioner_id =  pr_wait_list.resource_id)   WHEN (    pr_wait_list.resource_class = 'R'  AND pr_wait_list.resource_id IS NOT NULL   ) THEN (SELECT eff_status   FROM am_facility_room  WHERE operating_facility_id =  pr_wait_list.facility_id  AND room_num = pr_wait_list.resource_id)  WHEN (    pr_wait_list.resource_class = 'E' AND pr_wait_list.resource_id IS NOT NULL ) THEN (SELECT eff_status FROM am_resource WHERE facility_id = pr_wait_list.facility_id AND resource_class = 'E' AND resource_id = pr_wait_list.resource_id) WHEN (    pr_wait_list.resource_class = 'O' AND pr_wait_list.resource_id IS NOT NULL ) THEN (SELECT eff_status FROM am_resource WHERE facility_id = pr_wait_list.facility_id AND resource_class = 'O' AND resource_id = pr_wait_list.resource_id) END ) eff_status   from pr_wait_list where facility_id = '"+fac_id+"'  and wait_list_status='O'");
			
			//sql.append("select nvl(WAIT_LIST_NO,'') wait_list_no, decode(WAIT_LIST_PRIORITY,'U','Urgent','S','Semi Urgent','N','Normal') priority , nvl(PATIENT_ID,'') patient_id,  to_char(PREFERRED_DATE_TIME,'dd/mm/yyyy') pref_date_time , nvl(SPECIALTY_CODE,'') spec_desc, nvl(AM_GET_DESC.AM_CARE_LOCN_TYPE(CARE_LOCN_TYPE_IND,'"+locale+"','1'), '') locn_desc , nvl(RESOURCE_CLASS,'') resc_class, decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(resource_id,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, resource_id,'"+locale+"','2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, resource_id,'"+locale+"','2'),'O', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, resource_id,'"+locale+"','2')) PRACTITIONER_SHORT_NAME, (decode(care_locn_type_ind, 'N', (IP_GET_DESC.IP_NURSING_UNIT(FACILITY_ID, locn_code,'"+locale+"','2')))), OP_GET_DESC.OP_CLINIC(FACILITY_ID, locn_code, '"+locale+"','1') CLINIC_SHORT_DESC, SPECIALTY_CODE, care_locn_type_ind, locn_code clinic_code, resource_id PRACTITIONER_ID, resource_class, AM_GET_DESC.AM_SPECIALITY(specialty_code,'"+locale+"','2') SPECIALITY_DESC, (CASE WHEN pr_wait_list.waitlist_category_code IS NOT NULL THEN (SELECT long_desc FROM oa_waitlist_category_lang_vw WHERE waitlist_category_code = pr_wait_list.waitlist_category_code and language_id = '"+locale+"') END) WAITLIST_CAT_DESC, decode('"+locale+"','en',patient_name, nvl(patient_name_loc_lang, patient_name)) patient_name,AM_GET_DESC.AM_CONTACT_REASON(REASON_FOR_MODIFY,'"+locale+"','1')  REASON_FOR_MODIFY  from pr_wait_list where facility_id = '"+fac_id+"'  and wait_list_status='O'");

				
			if (elapsed.equals("N")){
				sql.append(" and ( trunc(PREFERRED_DATE_TIME)>=trunc(sysdate)  or trunc(PREFERRED_DATE_TIME) is null ) ");
			}else if (elapsed.equals("Y")){
				sql.append(" and ( trunc(PREFERRED_DATE_TIME) between (sysdate- "+elapsed_grace_period+") and (sysdate)  or trunc(PREFERRED_DATE_TIME) is null )");
			}

			if (!specCode.equals("")) 
				sql3=sql3.append(" and SPECIALTY_CODE='"+specCode+"'");
				
			if(cliniccode.equals("") && wtListControl.equals("")) res_type="";

			if (!clinic_type.equals("")) 
			sql3.append(" and CARE_LOCN_TYPE_IND='"+clinic_type+"'");
			if(clinic_type.equals("") && !wtListControl.equals(""))
				sql3.append(" and CARE_LOCN_TYPE_IND !='N'");

			if (!cliniccode.equals("")) 
				sql3.append(" and NVL(LOCN_CODE,'*')='"+cliniccode+"'");

			if (!res_type.equals("")) 
				sql3.append(" and resource_class='"+res_type+"'");
				
			if(!priority1.equals(""))
				sql3.append(" and WAIT_LIST_PRIORITY='"+priority1+"'");

			if (!practcode.equals("")) 
				sql3.append(" and NVL(RESOURCE_ID,'*')='"+practcode+"'");

			if (!gender.equals(""))  
				sql3.append(" and gender='"+gender+"'");

             if (!practitioner.equals(""))  
				sql3.append(" and resource_id='"+practitioner+"'");


			if (!WaitListNo.equals("")) 
				sql3=sql3.append(" and WAIT_LIST_NO='"+WaitListNo+"'");

			/*if (!resource1.equals("")) 
				sql3=sql3.append(" and PRACTITIONER_SHORT_NAME='"+resource1+"'");*/

			if (!patientid.equals(""))  
				sql3.append(" and patient_id='"+patientid+"'");

			if (!patientname.equals(""))
				{
				
				sql3.append(" and UPPER(patient_name) like upper('"+patientname+"%')");
					
				}
			if (!waitListfrmdate.equals("")) 
				sql3.append("  and trunc(preferred_date_time)>=to_date('"+waitListfrmdate+"','dd/mm/yyyy')");

			if (!waitListTodate.equals(""))  
				sql3.append(" and trunc(preferred_date_time)<=to_date('"+waitListTodate+"','dd/mm/yyyy')");

			if (!nat_id_no.equals(""))
				sql3.append(" and NATIONAL_ID_NO='"+nat_id_no+"'");

			if (!alt_id1_no.equals(""))
				sql3.append(" and ALT_ID1_NO='"+alt_id1_no+"'");

			if (!alt_id1_type.equals(""))
				sql3.append(" and ALT_ID1_TYPE='"+alt_id1_type+"'");

			if (!alt_id2_no.equals(""))
				sql3.append(" and ALT_ID2_NO='"+alt_id2_no+"'");

			if (!alt_id2_type.equals(""))
				sql3.append(" and ALT_ID2_TYPE='"+alt_id2_type+"'");

			if (!alt_id3_no.equals(""))
				sql3.append(" and ALT_ID3_NO='"+alt_id3_no+"'");

			if (!alt_id3_type.equals(""))
				sql3.append(" and ALT_ID3_TYPE='"+alt_id3_type+"'");

			if (!alt_id4_no.equals("") )
				sql3.append(" and ALT_ID4_NO='"+alt_id4_no+"'");

			if (!alt_id4_type.equals("") )
				sql3.append(" and ALT_ID4_TYPE='"+alt_id4_type+"'");
			
			if (!other_alt_Id.equals(""))
				sql3.append(" and OTH_ALT_ID_NO='"+other_alt_Id+"'");
			
			if (!other_alt_type.equals(""))
				sql3.append(" and OTH_ALT_ID_TYPE='"+other_alt_type+"'");

			if	(!nat_id_code.equals(""))
				sql3.append(" and NATIONALITY_CODE ='"+nat_id_code+"'");

			if	(!r_area_code.equals(""))
				sql3.append(" and RES_AREA_CODE ='"+r_area_code+"'");

			if	(!m_area_code.equals(""))
				sql3.append(" and MAIL_AREA_CODE ='"+m_area_code+"'");

			if	(!r_town_code.equals(""))
				sql3.append(" and RES_TOWN_CODE ='"+r_town_code+"'");

			if	(!m_town_code.equals(""))
				sql3.append(" and MAIL_TOWN_CODE ='"+m_town_code+"'");

			if	(!r_region_code.equals(""))
				sql3.append(" and RES_REGION_CODE ='"+r_region_code+"'");

			if	(!m_region_code.equals(""))
				sql3.append(" and MAIL_REGION_CODE ='"+m_region_code+"'");

			if(!wtlt_category.equals(""))
				sql3.append("and ORDER_CATALOG_CODE='"+wtlt_category+"'");

			if(!wtlt_category_one.equals(""))
				sql3.append(" and WAITLIST_CATEGORY_CODE='"+wtlt_category_one+"'");

				sqlmain2.append(sql.toString()+sql3.toString());
				sql3.setLength(0);
				sql.setLength(0);
				/*Below query commented by venkatesh against GHL-SCF-992  on 18-02-2016 */
				//sqlmain2.append(" ORDER BY WAIT_LIST_PRIORITY DESC ,PREFERRED_DATE_TIME,to_number(WAIT_LIST_NO)");
				/* Below query Modified by venkatesh against GHL-SCF-992 on 18-02-2016 */
				sqlmain2.append(" ORDER BY WAIT_LIST_PRIORITY DESC ,PREFERRED_DATE_TIME,to_number(WAIT_LIST_NO))  WHERE (eff_status != 'D' OR eff_status IS NULL) ORDER BY priority DESC, pref_date_time, TO_NUMBER (wait_list_no) ");
				
				rs 	= stmt.executeQuery(sqlmain2.toString());
				sqlmain2.setLength(0);


		
		
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(start));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(end));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(start));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(end));
            _bw.write(_wl_block13Bytes, _wl_block13);

				int rowcolor=0;
				if ( start != 1 )
				for( int j=1; j<start; s++,j++ )
				{
					rs.next() ;
				}
				if(rs != null)
				{
					while ( s<=end && rs.next())
					{
						if(i==0)
						{
						
            _bw.write(_wl_block14Bytes, _wl_block14);

		if ( !(start <= 1)) {
	
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf((start-15)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf((end-15)));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

		}
	//	if ( !((start+15) > i ))
			{
	
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf((start+15)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf((end+15)));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

		}
	
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
 }
				
			
						waitListNo =rs.getString("wait_list_no");
						priority = rs.getString("priority");	
						patientId = rs.getString("patient_id");	
					
						patientName	=rs.getString("patient_name");	
						if(patientName==null || patientName.equals("")){
							patient_name_yn="N";
						}else{
							patient_name_yn="Y";
						}
					
						preferedDate =rs.getString("pref_date_time")	;

						preferedDate_disp=DateUtils.convertDate(preferedDate,"DMY","en",locale);

						specialityDesc	=rs.getString("spec_desc")	;
						locationDesc =rs.getString("locn_desc"); 
						String resourceClass=rs.getString("resc_class"); 
						if(resourceClass ==null) resourceClass="";
							
							String res_class_desc="";
						if(resourceClass.equals("P"))
						{
						res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
						}else if(resourceClass.equals("E"))
						{
						res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
						}else if(resourceClass.equals("R"))
						{
						 res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
						}else if(resourceClass.equals("O"))
						{
						res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
						}

						resource =rs.getString("PRACTITIONER_SHORT_NAME");
						if (resource==null) resource="";
						//out.println("resource==="+resource);
                        
						clinicDesc=rs.getString("CLINIC_SHORT_DESC");
						specialityCode=rs.getString("SPECIALTY_CODE");
						careLocnTypeInd=rs.getString("care_locn_type_ind");
						clinicCode=rs.getString("clinic_code");
						resourceId=rs.getString("PRACTITIONER_ID");
						resClass=rs.getString("resource_class");
						SPECIALITY_DESC=rs.getString("SPECIALITY_DESC");
						//out.println("SPECIALITY_DESC=="+SPECIALITY_DESC);
						reason_for_modify=rs.getString("REASON_FOR_MODIFY");
						if(reason_for_modify ==null)	 reason_for_modify="";
						WAITLIST_CAT_DESC=rs.getString("WAITLIST_CAT_DESC");
						//commented the following linfg code as it was developed for web request demo
						//web_request_yn=rs.getString("web_request_yn");
						if (waitListNo==null) waitListNo="";
						if (priority==null) priority="";
						if (patientId==null) patientId="";
						if (patientName==null) 
							patientName="";
						else
						if (patientName.length() >= 25) patientName=patientName.substring(0,25);
						
						if (locationDesc==null) locationDesc="";
						if (resourceClass==null) resourceClass="";
						if (res_class_desc ==null) res_class_desc="";
						if (preferedDate==null) preferedDate ="";
						if (specialityDesc==null) specialityDesc="";
						
						if (clinicDesc==null) clinicDesc="";
						if (careLocnTypeInd==null) careLocnTypeInd="";
						if (clinicCode==null) clinicCode="";
						if (resourceId==null) resourceId="";
						//out.println("resourceId=="+resourceId);
						if (specialityCode==null) specialityCode="";
						if (resClass==null) resClass="";
						if (WAITLIST_CAT_DESC ==null) WAITLIST_CAT_DESC="";

						wait_list_ref_no=rs.getString("wait_list_ref_no");
						if(wait_list_ref_no ==null)	 wait_list_ref_no="";
						rd_waitlist_yn = rs.getString("rd_waitlist_yn")==null?"N":rs.getString("rd_waitlist_yn");
						order_catalog_code = rs.getString("order_catalog_code")==null?"":rs.getString("order_catalog_code");
						
						if ( rowcolor % 2 == 0 )
							classValue = "QRYEVEN" ;
						else
							classValue = "QRYODD" ;
						if(web_request_yn.equals("Y")){
							stylSetter="style='BackGround-color:yellow'";
						}else{
							stylSetter="";
						}
						
            _bw.write(_wl_block33Bytes, _wl_block33);
	/*changed for Bru-HIMS-CRF-173 starts*/
						if (elapsed.equals("N")&& (wtListControl.equals("") ||wtListControl.equals("B"))){System.err.println("rad_appt_yn--111-->"+rd_appt_yn);
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(waitListNo));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(waitListNo));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(waitListNo));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(preferedDate));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(res_class_desc));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(java.net.URLEncoder.encode(resource)));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(careLocnTypeInd));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(clinicCode));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(resourceId));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(specialityCode));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(resClass));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(web_request_yn));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(patient_name_yn));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(rd_waitlist_yn));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(stylSetter));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(waitListNo));
            _bw.write(_wl_block42Bytes, _wl_block42);
}else if (elapsed.equals("Y") && (wtListControl.equals("") ||wtListControl.equals("B"))){System.err.println("rad_appt_yn--222-->"+rd_appt_yn);
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(waitListNo));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(waitListNo));
            _bw.write(_wl_block45Bytes, _wl_block45);
}else if(!wtListControl.equals("") && wtListControl.equals("B")){
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(waitListNo));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(waitListNo));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(waitListNo));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(preferedDate));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(res_class_desc));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(java.net.URLEncoder.encode(resource)));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(careLocnTypeInd));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(clinicCode));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(resourceId));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(specialityCode));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(resClass));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(web_request_yn));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(patient_name_yn));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(stylSetter));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(waitListNo));
            _bw.write(_wl_block49Bytes, _wl_block49);
}else if(!wtListControl.equals("") && wtListControl.equals("V")){
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(waitListNo));
            _bw.write(_wl_block51Bytes, _wl_block51);
}/*changed for Bru-HIMS-CRF-173 Ends*/
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(patientName));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(preferedDate_disp));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(wait_list_ref_no));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(SPECIALITY_DESC));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(WAITLIST_CAT_DESC));
            _bw.write(_wl_block60Bytes, _wl_block60);
if(clinicDesc.length() >1) {
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(locationDesc));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(clinicDesc));
            _bw.write(_wl_block64Bytes, _wl_block64);
}else{
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(locationDesc));
            _bw.write(_wl_block64Bytes, _wl_block64);
}
            _bw.write(_wl_block65Bytes, _wl_block65);
if(resource.length() >1) {
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(res_class_desc));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(resource));
            _bw.write(_wl_block64Bytes, _wl_block64);
}else{
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(res_class_desc));
            _bw.write(_wl_block64Bytes, _wl_block64);
}
            _bw.write(_wl_block67Bytes, _wl_block67);
if(!patientId.equals("")){
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block70Bytes, _wl_block70);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);
}else{
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block71Bytes, _wl_block71);
}
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(reason_for_modify));
            _bw.write(_wl_block73Bytes, _wl_block73);

					rowcolor++;
					s++;
					i++;
				}//while loop
		}//if

		if(i == 0)
		{
            _bw.write(_wl_block74Bytes, _wl_block74);
}

		if ( i < 15 || (!rs.next()) ) {
		
            _bw.write(_wl_block75Bytes, _wl_block75);
 
				} else {
            _bw.write(_wl_block76Bytes, _wl_block76);
}


		
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(ALCN_CRITERIA_YN));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(specCode));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(elapsed));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(cliniccode));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(practcode));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(waitListfrmdate));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(waitListTodate));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(clinic_type));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(res_type));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(elapsed_grace_period));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(wtlt_category));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(wtlt_category_one));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(nat_id_no));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(alt_id1_no));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(alt_id1_type));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(alt_id2_no));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(alt_id2_type));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(alt_id3_no));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(alt_id3_type));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(alt_id4_no));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(alt_id4_type));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(other_alt_Id));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(other_alt_type));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(nat_id_code));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(r_area_code));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(m_area_code));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(r_region_code));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(m_region_code));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(r_town_code));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(m_town_code));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(priority1));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(reason_for_modify));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(i));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(wtListControl));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(rd_appt_yn));
            _bw.write(_wl_block113Bytes, _wl_block113);
// }// any rec present

	if ( rs != null ) rs.close() ;
	if ( rsSet!=null) rsSet.close();
	if ( stmt != null ) stmt.close() ;
	if ( st != null ) st.close();

}	catch ( Exception e ){
	//out.println("Exception : "+e);
	e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}finally
{
	ConnectionManager.returnConnection(conn,request);
}

            _bw.write(_wl_block114Bytes, _wl_block114);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.waitlistno.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PreferredDate.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referenceno.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.category1.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.resource.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PreviousEncounters.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reason.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PreviousEncounters.label", java.lang.String .class,"key"));
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
}
