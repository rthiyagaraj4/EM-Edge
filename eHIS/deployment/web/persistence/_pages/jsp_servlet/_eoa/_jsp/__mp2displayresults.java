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
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import eCommon.XSSRequestWrapper;

public final class __mp2displayresults extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/MP2DisplayResults.jsp", 1743078673251L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n  ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<Script src=\"../../eOA/js/ChangeDateFor2Vw.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n  <!-- this line Added for this CRFBru-HIMS-CRF-191 [IN:030391]  -->\n  <script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script> \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="     \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="  \n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<html>\n\t\t<head>\t\t\n\t</head>\n\t<script src=\"../../eOP/js/ManageSPatQueue.js\"></script>\n    <script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'></link>\n\n<body onLoad=visiblelity() OnMouseDown=\"CodeArrest()\"onKeyDown = \'lockKey()\' onscroll=\"scrollheader();scrollTitle();\">\n<form name=\"multi_pract\" id=\"multi_pract\">\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n\n\t<div id=\"labeldiv_one\" style=\"visibility:visible;backgroundColor:white;overflow:scroll\">\n\t<table cellspacing=\'0\' width=\'100%\' cellpadding=\'0\' border=\'0\'>\n\t<tr>\n\t<td class=\'label\' nowrap><b>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="/";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t/";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</b></td><td class=\'label\'>&nbsp;</td>\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t<td class=\'label\' colspan=\'4\'>&nbsp;</td>\n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t</tr>\n\t<tr><td class=\'label\' colspan=\'5\'></td></tr>\n\t<tr><td class=\'label\' colspan=\'5\'>&nbsp;</td></tr>\n\t<tr><td colspan=5 class=\'label\' align=\'center\'><b>\n\t<script>\n\tvar error=getMessage(\"SCH_NOT_AVAILABLE_DAY\",\"OA\");\n\talert(error);\n\t</script>\n\t</b></td></tr>\n\t<tr><td class=\'label\' colspan=\'5\'>&nbsp;</td></tr>\n\t<tr><td class=\'label\' colspan=\'5\'></td></tr>\n\t<tr><td class=\'label\' colspan=\'5\'></td></tr>\n\t<tr><td class=\'label\' colspan=\'5\'></td></tr>\n\t<tr><td class=\'label\' colspan=\'5\'></td></tr>\n\t</table>\n\t\t<input type=\'hidden\' name=\'reason_for_revise\' id=\'reason_for_revise\'  value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" >\n\n\t</div>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\n\n\t\t<div id=\"labeldiv2\" style=\"visibility:visible;backgroundColor:white;overflow:scroll\">\n\t\t<table cellspacing=\'0\' width=\'112%\' cellpadding=\'0\' border=\'0\'>\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\' nowrap  ><b>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\n\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t<td class=\'label\' width=\'30%\'><a href=\"javascript:allocationDetails(\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\',\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\')\"><b>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</b>\n\t\t\t\t</a></td>\n\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t<td class=\'label\' width=\'30%\'>&nbsp;</td>\n\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\n\t\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t\t<td  align=\"center\" class=\'label\' id=\'bli\'  nowrap WIDTH=\'20%\'>\n\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="<a href=\'javascript:moveNext_labels0()\'><b>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</b></a><input type=\'hidden\' name=\'dummy\' id=\'dummy\' >";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\n\t\t\t</td>\n\t\t\t\t\t\t\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t\n\t\t\t<td class=\'label\' nowrap colspan=\'2\' ><b>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t/  ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t    ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="/ ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</b>\n\t\t\n\t\t\t\t</td>\n\t\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t</tr>\t\n\t\t\t\n\t\t</table>\n\t\t<table width=\'112%\' cellspacing=\'0\' cellpadding=\'0\' border=\'1\'>\n\t\t\t<tr>\n\t\t\t<td class=\'label\' width=\"2%\">&nbsp;</td>\n\t\t\t<td class=\'label\' align=middle>\n\n\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t<b>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</b>\n\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t</td>\t\n\t\t\t<td class=\'label\' align=middle><b>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</b></td>\n\t\t\t<td class=\'label\' align=middle><b>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</b></td>\n\t\t\t<td class=\'label\' align=middle>\n\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\t\t\n\t\t\t\t<b>";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t&nbsp;\n\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t</td>\n            <!--Below line Modified for this CRF ML-MMOH-CRF-0606--> \n\t\t\t<!--Below line Modified for this CRF ML-MMOH-CRF-0609 by Mano-->\n\t\t\t<td class=\'label\' align=middle><b>";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="&nbsp;";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</b></td>\n\t\t\t<!--End this CRF ML-MMOH-CRF-0609-->\n\t\t\t<!--End this CRF ML-MMOH-CRF-0606-->\n\t\t\t</tr>\n\n\t\t\t<tr>\n\t\t\t<td class=\'label\' width=\"2%\"><b>";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t</td>\t\n\t\t\t<td class=\'label\' align=middle>\n\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t&nbsp;\n\t\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t\t<b>";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</b>\n\t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</td>\n\t\t\t<td class=\'label\' align=middle>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t</td>\n\t\t\t<td class=\'label\' align=middle><b>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</b></td>\n\n\t\t\t<td class=\'label\' align=middle><b>";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</b> </td>\n\t\t\t<td class=\'label\' align=middle>\n\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t</td>\n\n\t\t\t<td class=\'label\' >&nbsp;</td>\n\t\t\t<td class=\'label\' >&nbsp;</td>\n\n\t\t\t\n\t\t\t</tr>\n\n\t\t\t<tr>\n\t\t\t<td class=\'label\' width=\"2%\"><b>";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</b></td>\t\n\t\t\t<td class=\'label\' align=middle><b>";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t</td>\n\t\t\t\n\t\t\t<td class=\'label\' >&nbsp;</td>\n\t\t\t<td class=\'label\' >&nbsp;</td>\n\t\t\t\n\t\t\t</tr>\n\t\t\n\t\t\t<!-- <tr> \n\t\t\t<td colspan = \'7\' class=\'label\'  align=center> </td>\n\t\t\t</tr> -->\n\n\t\t<!-- </table>\n\t\t<table width=\'100%\' cellspacing=\'0\' cellpadding=\'0\' border=\'0\'> -->\n\t\t<tr>\n\t\t<!--Below line Modified for this CRF ML-MMOH-CRF-0606-->\t\t\n\t\t<td class=\'label\' nowrap width=\'2%\'>&nbsp;</td>\n\t\t<td class=\'label\' >&nbsp;</td>\n\t\t<td class=\'label\' >&nbsp;</td>\n\t\t<td class=\'label\' >&nbsp;</td>\n\t\t<td class=\'label\' >&nbsp;</td>\n\t\t<td class=\'label\' >&nbsp;</td>\n\t\t<td class=\'label\' >&nbsp;</td>\n\t\t<td class=\'label\' align=middle><b>";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</b> </td>\n\t\t<td class=\'label\' align=middle><b>";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</b> </td>\n\t\t\n\t\t</tr>\n\t\t\n\t\t</table></div>\n\n\t\t<br>\n\t\t\t\n\t\t<!-- <div id=\'header\' style=\"visibility:visible;backgroundColor:white;overflow:scroll\"> -->\n\t<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\' id=\'results1\'>\n\t<th align=\'left\' width=\'9%\' ><div  id=\'head1\'  class=\'myClass\' nowrap >";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</div></th>\n\t<th align=\'left\' width=\'11%\' ><div  id=\'head2\'  class=\'myClass\' nowrap >";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</div></th>\n\t<th align=\'left\' width=\'22%\'><div  id=\'head3\'  class=\'myClass\' nowrap >";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</div></th>\n\t<th align=\'left\' width=\'18%\' ><div  id=\'head4\'  class=\'myClass\' nowrap >";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</div></th>\n\t\n\t<!--Below line added for this CRF GHL-CRF-0414 -->\n\t<th align=\'left\' width=\'18%\' ><div  id=\'head13\'  class=\'myClass\' nowrap >";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</div></th>\n\t<!--End GHL-CRF-0414 -->\n\t\n\t<th align=\'left\' width=\'25%\' ><div  id=\'head5\'  class=\'myClass\' nowrap >";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</div></th>\n\t<th align=\'left\' width=\'12%\' ><div  id=\'head6\'  class=\'myClass\' nowrap >";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</div></th><!-- </table></div> -->\n    \t <!--Below line Added for this CRF Bru-HIMS-CRF-165.1 [IN:035659]   -->\n    <th align=\'left\' width=\'12%\'><div  id=\'head12\'  class=\'myClass\' nowrap >";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="</div></th>\n  <!-- End this CRF Bru-HIMS-CRF-165.1 [IN:035659]  -->\t\t\t\t\n\t\t\t<!--   <table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\' id=\'results\'> -->\n\t<!--Added by Thamizh selvi on 17th July 2018 against ML-MMOH-CRF-1058 Start-->\n\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t<th align=\'left\' width=\'12%\'><div  id=\'head14\'  class=\'myClass\' nowrap >";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</div></th>\n\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t<!--End-->\n\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\n\n\n\n";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\t\n\t\t\t\t\t<script>alert(getMessage(\'APPT_CAN_NOT_TRANS_OTH_CAT\',\'OA\'));</script>\n\t\t\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t\t\t<script>alert(getMessage(\'APPT_TRANS_OTH_CAT\',\'OA\'));</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\n\t\t<script>\n\t\nfunction doDateCheckAlert(from,to) {\n\tvar fromarray; var toarray;\n\tvar fromdate = from ;\n\tvar todate = to ;\n\tif(fromdate.length > 0 && todate.length > 0 ) {\n\t\t\tfromarray = fromdate.split(\"/\");\n\t\t\ttoarray = todate.split(\"/\");\n\t\t\tfromarray[1]=fromarray[1]-1;\n\t\t\ttoarray[1]=toarray[1]-1;\n\t\t\tvar fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);\n\t\t\tvar todt = new Date(toarray[2],toarray[1],toarray[0]);\t\n\t\t\tif(Date.parse(todt) < Date.parse(fromdt)) {\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\telse if(Date.parse(todt) >= Date.parse(fromdt)) return true;\n\t}\t\nreturn true;\n}\n\n\t\tvar u1;\n\t\tvar u2;\n\t\tvar value1;\n\t\tvar value2;\n\t\tvar value3;\n\t\tvar value4;\n\t\tvar value5;\n\t\tvar value6;\n\t\tvar value7;\n\t\tvar value8;\n\t\tvar value9;\n\t\tvar value10;\n\t\tvar value11;\n\t\tvar sys_date;\n\t\tvar sys_time;\n\t\tvar value12;\n\t\tvar value13;\n\t\tvar value14;\n\t\tvar value15;\n\t\n\tvar clinic_code2;\n\tvar practitioner_id2;\nfunction row(Obj)\n{\n\tu1=Obj.rowIndex;\n\tu1=u1-1;\n}\n\t\t\nfunction col(Obj)\n{\n\n\t u2=Obj.cellIndex;\n}\n\nfunction moveNext_results0(pVal){\n\tvar latter=document.getElementById(\'results1\').rows[u1].cells[2].innerText ;\n\tvar old_clinic=document.forms[0].old_clinic.value;\n\tvar old_practitioner=document.forms[0].old_practitioner.value;\n\tvar value_chk=document.forms[0].value_chk.value;\n\tvar appt_date=\"\";\n\n\tvar appt_refno = eval(\'document.forms[0].o_appt_ref_no\'+u1).value;\n\n\t/* Added for ML-BRU-CRF-0628.1 */\n\text_slot=document.forms[0].p_o_ext_slot_status.value;\n\tvar s_arr=ext_slot.split(\"|\");\n\tif (s_arr[u1] ==\'Y\' && appt_refno == \"~\") {\n\t\talert(getMessage(\"BRU_HEALTH_SLOT_SELECTED\",\"OA\"));\n\n\t}else{\n\t\n\tif(value_chk ==\"display0\"){\n\t\tvalue1=document.forms[0].clinic_code.value;\n\t\tvalue2=document.forms[0].clinic_name.value;\n\t\tvalue3=document.forms[0].pract_id.value;\n\t\tvalue4=document.forms[0].pract_name.value;\n\t\tvalue5=document.forms[0].appt_date.value;\n\t\tappt_date=document.forms[0].appt_date.value;\n\t}else{\n\t\tvalue1=document.forms[0].clinic_code2.value;\n\t\tvalue2=document.forms[0].clinic_name.value;\n\t\tvalue3=document.forms[0].practitioner_id2.value;\n\t\tvalue4=document.forms[0].pract_name.value;\n\t\tvalue5=document.forms[0].appt_date2.value;\n\t\tappt_date=document.forms[0].appt_date2.value;\n\t}\n\tvalue6= document.getElementById(\"results1\").rows[u1+1].cells[u2].innerText;\n\tvalue7=document.getElementById(\"results1\").rows[u1+1].cells[u2+1].innerText;\n\tvalue8=document.forms[0].over_booked.value;\n\tvalue9=document.forms[0].P_O_TIME_TAB_TYPE.value;\n\tvalue10=document.forms[0].patient_id.value;\n\tvalue11=document.forms[0].elements[u1].value;\n\tvalue12=document.forms[0].reason_for_revise.value;\n\tvalue13=document.forms[0].ref_no.value;\n\tvar  old_date=document.forms[0].old_date.value;\n\tif( old_date.length == 0) document.forms[0].old_date.value=value5;\n\tvalue14= document.forms[0].old_from_time.value;\n\tvalue15= document.forms[0].old_to_time.value;\n\tsys_date=document.forms[0].sys_date.value;\n\tsys_time=document.forms[0].sys_time.value;\t\n\tfromtimeharray=sys_time.split(\":\");\n\tfrom_time=value6.split(\":\");\n\tto_displayed_time=value7.split(\":\");\n\tvar fromhtm=new Date(1,1,1,fromtimeharray[0],fromtimeharray[1],0,0);\n\tvar tohtm=new Date(1,1,1,from_time[0],from_time[1],0,0);\n\tvar to_displayed=new Date(1,1,1,to_displayed_time[0],to_displayed_time[1],0,0);\n\tpractitioner_id2=document.forms[0].practitioner_id2.value;\n\tclinic_code2=document.forms[0].clinic_code2.value;\n\tif(!pVal) pVal=\'NO\';\n\tif(old_clinic.length == 0 || old_clinic ==null || old_clinic== \"undefined\")\n\told_clinic =value1;\n\tif(old_practitioner.length == 0 || old_practitioner ==null || old_practitioner== \"undefined\")\n\told_practitioner = value3;\t\n\tif( old_clinic == value1){\n\t\tif(old_practitioner == value3){\n\t\t\tif(eval(\'document.forms[0].o_appt_ref_no\'+u1).value == \"~\"){\t\n\t\t\t//if(document.forms[0].elements(u1).value == \"~\"){\t\n\t\t\t\tif(doDateCheckAlert(appt_date ,document.forms[0].sys_date.value)){\n\t\t\t\t\tif(value9 == \"1\"){\n\t\t\t\t\t\tif((Date.parse(fromhtm) >= Date.parse(to_displayed))){\n\t\t\t\t\t\t\talert(getMessage(\"FR_TIME_CAN_NOT_SYS_TIME\",\"OA\"));\n\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\tif(document.forms[0].r_appt_status.value == \"Revise\"){\n\t\t\t\t\t\t\t\tcallBookAppointmentDetails_results0(pVal);\n\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\tif(value12.length == 0){\n\t\t\t\t\t\t\t\t\tcallBookAppointment_results0();\n\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\tcallBookAppointmentDetails_results0(pVal);\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t}\t\t\t\n\t\t\t\t\t\t}\t\t\t\n\t\t\t\t\t} // e.o.f value 9\n\t\t\t\t\tif(value9 == \"2\" || value9 == \"3\"){\n\t\t\t\t\t\tif((Date.parse(to_displayed)<Date.parse(fromhtm))){\n\t\t\t\t\t\t\tif(latter.length != 1){\n\t\t\t\t\t\t\t\tcallBookAppointmentDetails2_results0();\n\t\t\t\t\t\t\t}else\n\t\t\t\t\t\t\t\talert(getMessage(\'ST_TM_LESS_SY_TM\',\'OA\'));\n\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\tif(document.forms[0].r_appt_status.value == \"Revise\"){\n\t\t\t\t\t\t\t\tcallBookAppointmentDetails_results0(pVal);\n\t\t\t\t\t\t\t}else{\t\n\t\t\t\t\t\t\t\tif(value12.length == 0)\n\t\t\t\t\t\t\t\t\tcallBookAppointment_results0();\n\t\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t\t\tcallBookAppointmentDetails_results0(pVal);\n\t\t\t\t\t\t\t}\t\t\t\t\n\t\t\t\t\t\t}\t\t\t\n\t\t\t\t\t} // e.o.f value 9\n\t\t\t\t}else{\n\t\t\t\t\tif( document.forms[0].r_appt_status.value == \"Revise\"){\n\t\t\t\t\t\tcallBookAppointmentDetails_results0(pVal);\n\t\t\t\t\t}else{\n\t\t\t\t\t\tif(value12.length == 0){ \n\t\t\t\t\t\t\t callBookAppointment_results0();\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse{ \n\t\t\t\t\t\t\tcallBookAppointmentDetails_results0(pVal);\n\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\t\t\n\t\t}  // e.o.outer if\n\telse\n\t{\n\t\t\n\t\tif( doDateCheckAlert(appt_date ,document.forms[0].sys_date.value))\n\t\t{\n\t\t\t\n\t\t\tif(value9 == \"1\")\n\t\t\t\t{\n\t\t\t\t\tif(( Date.parse(tohtm) < Date.parse(fromhtm) ))\n\t\t\t\t\t\n\t\t\t\t\t{\t\n\t\t\t\t\t\tif(latter.length != 1)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tcallBookAppointmentDetails2_results0();\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse\n\t\t\t\t\t\talert(getMessage(\'FR_TIME_CAN_NOT_SYS_TIME\',\'OA\'));\t\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tif( document.forms[0].r_appt_status.value == \"Revise\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\talert(getMessage(\'REVISION_NOT_ALLOWED\',\'OA\'));\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\tcallBookAppointmentDetails_results0(pVal);\n\t\t\t\t\t\t}\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t}\n\t\t\n\t\t\tif(value9 == \"2\" || value9 == \"3\")\n\t\t\t\t{\n\t\t\t\t\tif(( Date.parse(to_displayed) < Date.parse(fromhtm) )  )\n\t\t\t\t\t{\n\t\t\t\t\tif(latter.length != 1)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\tcallBookAppointmentDetails2_results0();\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\telse\n\t\t\t\t\talert(getMessage(\'ST_TM_LESS_SY_TM\',\'OA\'));\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tif( document.forms[0].r_appt_status.value == \"Revise\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\talert(getMessage(\'REVISION_NOT_ALLOWED\',\'OA\'));\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\tcallBookAppointmentDetails_results0(pVal);\n\t\t\t\t\t\t}\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t}\t\t\n\t\t\n\t\t}\n\t\telse\n\t\t{\n\t\t\t\tif( document.forms[0].r_appt_status.value == \"Revise\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\talert(getMessage(\'REVISION_NOT_ALLOWED\',\'OA\'));\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\tcallBookAppointmentDetails_results0(pVal);\n\t\t\t\t\t\t}\t\t\t\t\t\t\t\n\t\t}\n\t\t\n\t}\n\n}\n\telse\n\talert(getMessage(\'REV_NOT_ALLOW_PRACT\',\'OA\'));\n\n\n}\n\telse\n\talert(getMessage(\'REV_NOT_ALLOW_CLINIC\',\'OA\'));\n\n\t}\n}\n\t\n\t</script>\n\n\n\n\n\n \n";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\n\n<tr onClick=\'row(this)\'>\n";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t\t\t\t\t\t\t<td width=\'9%\' class=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\" onClick=\'col(this)\'>";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="<input type=\'hidden\'  name=\'o_appt_ref_no";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\' id=\'o_appt_ref_no";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\' value=\'";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\' > </td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" >";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\' > </td>\n\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t\t\t\t\t\t\t<td width=\'9%\' class=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="</a> <input type=\'hidden\'  name=\'o_appt_ref_no";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t\t\t\t\t\t\t\t\t<td  width=\'9%\'  class=\'OARED\' title=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\">";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="</td>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t\t\t\t\t\t\t\t\t<td  width=\'9%\' class=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\" onClick=\'col(this)\'><a href= \"javascript:GroupappointmentSelect(\'\',\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\')\">";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\' > </td>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\" onClick=\'col(this)\'><a href= javascript:moveNext_results0(\'\')>";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\t\t\t\t\t\t\t\t<td  width=\'9%\' class=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\' > </td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t\t\t\t\t\t\t\t<td  width=\'9%\'  class=\'OARED\' title=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="</td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n\t\t\t\t\t\t\t\t\t<td  width=\'9%\' class=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t\t\t\t\t<td  width=\'9%\' class=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 =" <input type=\'hidden\'  name=\'o_appt_ref_no";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\' > </td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n\t\t\t\t\t\t<td  width=\'9%\' class=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t\t\t\t\t\t\t<td  width=\'9%\'  class=\'OARED\' title=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\t\t\t\t\t\t\t\t\t<td  width=\'9%\'  class=\'OAFORCED\' onClick=\'col(this)\' Title=\'Forced Appointment\'><a href= javascript:moveNext_results0(\'F\')>";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\' >  </td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<td  width=\'9%\'  class=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\" onClick=\'col(this)\'><a href= javascript:moveNext_results0(\'NF\')>";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\' ></td>\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\t\n\t\t\t\t\t\t\t\t\t<td  width=\'9%\'  class=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\" onClick=\'col(this)\'><a href= javascript:moveNext_results0(\'M\')>";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\' ></td>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\t\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\n\t\t\t\t\t\t\t\t\t<td  width=\'9%\'  class=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\' ></td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<td  width=\'9%\'  class=\"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\' ></td>\t\t\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\n\t\t\t\t\t\t\t<td  width=\'9%\' class=\"";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\' > </td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\n\t\t\t\t\t\t\t\t<td  width=\'9%\'  class=\'OARED\' title=\"";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\n\t\t\t\t\t\t<td width=\'9%\' class=\"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\n\t\t<td  width=\'9%\' class=\'OABLOCK\' title =";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 =">";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\' ></td>\n\t\t";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\n\t\t<td  width=\'9%\' class=\'OARED\' title =\"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\n\t\t<td width=\'9%\' class=\"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\' > </td>\n\t\t";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\n\t\t<td  width=\'9%\' class=\"";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\">&nbsp; <input type=\'hidden\'  name=\'o_appt_ref_no";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\n\t\t\t<td  width=\'11%\' class=\"OARED\" title=\"";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="</td>\n\t\t";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\n\t\t\t";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\n\t\t\t\t<td  width=\'11%\' class=\"OAFORCED\" Title=\"Forced Appointment\">";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="</td>\n\t\t\t";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\n\t\t\t\t<td  width=\'11%\' class=\"";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\n\t\t";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\n\t\t\t<td  width=\'11%\' class=\'OABLOCK\' title =\"";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\n\t\t\t<td  width=\'11%\' class=\'OARED\' title =\"";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\n\t\t<td  width=\'11%\' class=\"";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\">&nbsp;</td>\n";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\n\t\t\t<td width=\'22%\' class=\"";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\" wrap>";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="<img src=\'../../eCommon/images/PI_VIP.gif\'>";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\n\t\t\t\t<td width=\'22%\' class=\"";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\">***</td>\n\t\t\t";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\n\t\t\t\t<td width=\'22%\' class=\'OARED\' title =\"";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\">&nbsp;</td>\n\t\t\t";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\n\t\t\t<td width=\'22%\'  class=\"";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 =":<b>";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="</b></td>\n\t\t\t";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\t\t\t\t \n\t\t\t\t<td width=\'22%\' class=\"";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\n\t\t\t\t<td width=\'20%\' class=\"";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\" style=\"background-color:";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 =";FONT-SIZE:8pt;\">";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\n\t\t\t<td width=\'20%\' class=\'OARED\' title =\"";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\n\t\t\n\t\t<td width=\'20%\'  class=\"";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\">&nbsp;</td>\n\t\t";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\n\t\t\t <td width=\'20%\' class=\"";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="</td>\t\t\t\n\t\t";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\t\t\n\t\t       <td width=\'20%\'  class=\"";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\n\t\t<td width=\'25%\' class=\"";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\n\t\t<td width=\'25%\' class=\'OARED\' title =\"";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\n\t<td width=\'18%\' class=\"";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\">\n\t";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\n\t\t<a href=\"javascript:show_Reference_details_results0(\'";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\')\">\n\t\t\t";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\n\t\t</a>\n\t";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="&nbsp;</td>\n\t<!--Below line Added for this CRF Bru-HIMS-CRF-165.1 [IN:035659]  -->\n\t<td width=\'12%\' class=\"";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\" onClick=\'col(this)\' >";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="<a href=\"javascript:show_order_select(\'\',\'";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\n\t\t</a>";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="<input type=\'hidden\'  name=\'order_appt_ref_no";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\' id=\'order_appt_ref_no";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\' ></td>\n\t<!-- End this CRF Bru-HIMS-CRF-165.1 [IN:035659] -->\n\n\t<!--Added by Thamizh selvi on 17th July 2018 against ML-MMOH-CRF-1058 Start-->\n\t";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\n\t\t<td width=\'12%\' class=\"";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="<a href=\"javascript:dispApptRemarks(\'";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\')\">\n\t\t";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="</td>\n\t";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\n\t<!--End-->\n   \n  </tr>\n   ";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\n\n</table>\n\n\n\n<input type=\'hidden\' name=\'r_appt_status\' id=\'r_appt_status\' value=\'null\' >\n<input type=\'hidden\' name=\'clinic_code\' id=\'clinic_code\' value=\'";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\' >\n<input type=\'hidden\' name=\'clinic_name\' id=\'clinic_name\' value=\'";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\' >\n<input type=\'hidden\' name=\'pract_id\' id=\'pract_id\' value=\'";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\' >\n<input type=\"hidden\" name=\"P_O_OBVISIT_FLAG\" id=\"P_O_OBVISIT_FLAG\" value=\"";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\">\n\n<input type=\'hidden\' name=\'pract_name\' id=\'pract_name\' value=\'";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\' >\n<input type=\'hidden\' name=\'appt_date\' id=\'appt_date\' value=\'";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\' >\n\t<input type=\'hidden\' name=\'appt_date2\' id=\'appt_date2\' value=\'";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\' >\n\n<input type=\'hidden\' name=\'over_booked\' id=\'over_booked\' value=\'";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\' >\n\t <input type=\'hidden\' name=\'over_booked_label\' id=\'over_booked_label\' value=\'";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\' >\n\n<input type=\'hidden\' name=\'P_O_TIME_TAB_TYPE\' id=\'P_O_TIME_TAB_TYPE\' value=\'";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\' >\n<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\'null\'>\n<input type=\'hidden\' name=\'sys_date\' id=\'sys_date\' value=\'";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\' >\n<input type=\'hidden\' name=\'sys_time\' id=\'sys_time\' value=\'";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\' >\n\n<input type=\'hidden\' name=\'ref_no\' id=\'ref_no\' value= \'";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\' >\n\n<input type=\'hidden\' name=\'clinic_code2\' id=\'clinic_code2\' value=\'";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\' >\n<input type=\'hidden\' name=\'practitioner_id2\' id=\'practitioner_id2\' value=\'";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\' >\n\n<input type=\'hidden\' name=\'old_clinic\' id=\'old_clinic\' value=\'";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\' >\n<input type=\'hidden\' name=\'old_practitioner\' id=\'old_practitioner\' value=\'";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\' >\n\n<input type=\'hidden\' name=\'p_o_end_time\' id=\'p_o_end_time\' value =\'";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\' >\n<input type=\'hidden\' name=\'old_date\' id=\'old_date\' value=\'";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\' >\n\n<input type=\'hidden\' name=\'old_from_time\' id=\'old_from_time\' value=\'";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\' >\n<input type=\'hidden\' name=\'old_to_time\' id=\'old_to_time\' value=\'";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\' >\n<input type=\'hidden\' name=\'book_appt_yn\' id=\'book_appt_yn\' value=\'";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\' >\n<input type=\'hidden\' name=\'book_appt_wo_pid_yn\' id=\'book_appt_wo_pid_yn\' value=\'";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\' >\n<input type=\'hidden\' name=\'obook_appt_yn\' id=\'obook_appt_yn\' value=\'";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\' >\n<input type=\'hidden\' name=\'book_appt_across_catg_yn\' id=\'book_appt_across_catg_yn\' value=\'";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\' >\n<input type=\'hidden\' name=\'tfr_appt_yn\' id=\'tfr_appt_yn\' value=\'";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\' >\n<input type=\'hidden\' name=\'tfr_appt_across_catg_yn\' id=\'tfr_appt_across_catg_yn\' value=\'";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\' >\n<input type=\'hidden\' name=\'canc_appt_yn\' id=\'canc_appt_yn\' value=\'";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\' >\n<input type=\'hidden\' name=\'ca_mode\' id=\'ca_mode\' value=\'";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\' >\n<input type=\'hidden\' name=\'ca_patient_id\' id=\'ca_patient_id\' value=\'";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\' >\n<input type=\'hidden\' name=\'date1\' id=\'date1\' value=\'";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\' >\n<input type=\"hidden\" name=\"maxForced\" id=\"maxForced\" value=\"";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\">\n<input type=\"hidden\" name=\"totForced\" id=\"totForced\" value=\"";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\">\n<input type=\"hidden\" name=\"maxGlobal\" id=\"maxGlobal\" value=\"";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\">\n<input type=\"hidden\" name=\"totGlobal\" id=\"totGlobal\" value=\"";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\">\n\n<input type=\"hidden\" name=\"clinic_type1\" id=\"clinic_type1\" value=\"";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\">\n<input type=\"hidden\" name=\"res_type1\" id=\"res_type1\" value=\"";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\">\n<input type=\"hidden\" name=\"clinic_type2\" id=\"clinic_type2\" value=\"";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\">\n<input type=\"hidden\" name=\"res_type2\" id=\"res_type2\" value=\"";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\">\n<input type=\"hidden\" name=\"clinic_type3\" id=\"clinic_type3\" value=\"";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\">\n<input type=\"hidden\" name=\"res_type3\" id=\"res_type3\" value=\"";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\">\n<input type=\"hidden\" name=\"or_catalogue_code\" id=\"or_catalogue_code\" value=\"";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\">\n<input type=\"hidden\" name=\"order_id\" id=\"order_id\" value=\"";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\">\n<input type=\"hidden\" name=\"order_catalog_code\" id=\"order_catalog_code\" value=\"";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\">\n<input type=\"hidden\" name=\"order_line_num\" id=\"order_line_num\" value=\"";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\">\n<input type=\"hidden\" name=\"oper_stn_id\" id=\"oper_stn_id\" value=\"";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\">\n<input type=\"hidden\" name=\"alcn_criteria\" id=\"alcn_criteria\" value=\"";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\">\n<input type=\"hidden\" name=\"slot_appt_ctrl\" id=\"slot_appt_ctrl\" value=\"";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\">\n<input type=\"hidden\" name=\"visit_limit_rule\" id=\"visit_limit_rule\" value=\"";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="\">\n<input type=\"hidden\" name=\"override_no_of_slots_yn\" id=\"override_no_of_slots_yn\" value=\"";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="\">\n<input type=\"hidden\" name=\"callingMode\" id=\"callingMode\" value=\"";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\">\n<input type=\'hidden\' name=\"req_id\" id=\"req_id\" value=\"";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="\">\n<input type=\"hidden\" name=\"install_yn_val\" id=\"install_yn_val\" value=\"";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="\">\n<input type=\"hidden\" name=\"value_chk\" id=\"value_chk\" value=\"";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\">\n<input type=\"hidden\" name=\"P_O_MAX_PAT\" id=\"P_O_MAX_PAT\" value=\"";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="\">\n<input type=\'hidden\' name=\'reason_for_revise\' id=\'reason_for_revise\'  value=\"";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="\" >\n<input type=\'hidden\' name=\'visit_flag_OP\' id=\'visit_flag_OP\'  value=\"";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\" >\n<input type=\"hidden\" name=\'capture_fin_dtls_yn\' id=\'capture_fin_dtls_yn\' value=\'";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="\'>\n<input type=\"hidden\" name=\'from_page\' id=\'from_page\' value=\'";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="\'>\n<input type=\"hidden\" name=\"refID\" id=\"refID\" value=\"";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="\">\n<input type=\"hidden\" name=\"ForcedAllowed\" id=\"ForcedAllowed\" value=\"";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="\">\n<input type=\"hidden\" name=\"GlobalAllowed\" id=\"GlobalAllowed\" value=\"";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\">\n<input type=\"hidden\" name=\"create_wait_list_yn\" id=\"create_wait_list_yn\" value=\"";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="\">\n<input type=\"hidden\" name=\'min_ela_per_resc_noshow_in_day\' id=\'min_ela_per_resc_noshow_in_day\' value=\'";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="\'>\n<input type=\"hidden\" name=\'noshow_ctrl_by_splty_or_clinic\' id=\'noshow_ctrl_by_splty_or_clinic\' value=\'";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="\'>\n<input type=\"hidden\" name=\'contact_num_reqd_yn\' id=\'contact_num_reqd_yn\' value=\'";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="\'>\n<input type=\"hidden\" name=\'no_of_noshow_appts_for_alert\' id=\'no_of_noshow_appts_for_alert\' value=\'";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="\'>\n<input type=\"hidden\" name=\'per_chk_for_no_show_alert\' id=\'per_chk_for_no_show_alert\' value=\'";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="\'>\n<input type=\"hidden\" name=\"LocGlbChk\" id=\"LocGlbChk\" value=\"";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="\" >\n\n<input type=\"hidden\" name=\'from_facility_id\' id=\'from_facility_id\' value=\'";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="\'>\n<input type=\"hidden\" name=\'from_encounter_id\' id=\'from_encounter_id\' value=\'";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 ="\'>\n<input type=\"hidden\" name=\'rd_appt_yn\' id=\'rd_appt_yn\' value=\'";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="\'>\n<input type=\"hidden\" name=\'max_patients_per_slab\' id=\'max_patients_per_slab\' value=\'";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="\'>\n\n<input type=\"hidden\" name=\'isIncRemarksLengthAppl\' id=\'isIncRemarksLengthAppl\' value=\'";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="\'><!--Added by Thamizh selvi on 16th July 2018 against ML-MMOH-CRF-1184-->\n\n<!-- Added for ML-BRU-CRF-0628.1 -->\n<input type=\"hidden\" name=\"p_o_ext_slot_status\" id=\"p_o_ext_slot_status\" value=\"";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 ="\">\n<input type=\"hidden\" name=\"p_o_reserved_slot_dtls\" id=\"p_o_reserved_slot_dtls\" value=\"";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 ="\">\n<input type=\"hidden\" name=\"p_o_appt_slot_dtls\" id=\"p_o_appt_slot_dtls\" value=\"";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="\">\n<input type=\"hidden\" name=\"p_o_block_slot_dtls\" id=\"p_o_block_slot_dtls\" value=\"";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 ="\">\n<input type=\"hidden\" name=\"p_o_break_slot_dtls\" id=\"p_o_break_slot_dtls\" value=\"";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 ="\">\n<input type=\"hidden\" name=\"isSlotStartMidEndAppl\" id=\"isSlotStartMidEndAppl\" value=\"";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="\">\n<!-- End ML-BRU-CRF-0628.1 -->\n\n";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 ="\n<input type=\"hidden\" name=\"calling_mode\" id=\"calling_mode\" value=\"";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 ="\">\n\n\n<script>\n\n/* Added for ML-BRU-CRF-0628.1 */\nif (document.forms[0].isSlotStartMidEndAppl.value==\'true\'){\n\n\tvar ext_slt=document.forms[0].p_o_ext_slot_status.value;\n\tvar res_slt=document.forms[0].p_o_reserved_slot_dtls.value;\n\tvar appt_slt=document.forms[0].p_o_appt_slot_dtls.value;\n\tvar blk_slt=document.forms[0].p_o_block_slot_dtls.value;\n\tvar brk_slt=document.forms[0].p_o_break_slot_dtls.value;\n\tvar pract_id=document.forms[0].pract_id.value;\n\tvar practitioner_id2=document.forms[0].practitioner_id2.value;\n\n\tvar ext_slot_arr=ext_slt.split(\"|\");\n\tvar res_slot_arr=res_slt.split(\"|\");\n\tvar appt_slot_arr=appt_slt.split(\"|\");\n\tvar blk_slot_arr=blk_slt.split(\"|\");\n\tvar brk_slot_arr=brk_slt.split(\"|\");\n\n\tfor(var i=0;i<=ext_slot_arr.length;i++){\n\t\t\n\t\tif(ext_slot_arr[i]==\'Y\') {\n\n\t\t\tif(blk_slot_arr[i]==\'N\' && brk_slot_arr[i]==\'N\') {\n\t\t\t\tif(res_slot_arr[i] !=\'N\'){\n\t\t\t\t\n\t\t\t\t\tdocument.getElementById(\"results1\").rows[i+1].cells[0].style.backgroundColor = \"Bisque\";\n\t\t\t\t\tdocument.getElementById(\"results1\").rows[i+1].cells[1].style.backgroundColor = \"Bisque\";\n\t\t\t\t\tdocument.getElementById(\"results1\").rows[i+1].cells[0].style.Color = \"Black\";\n\t\t\t\t\tdocument.getElementById(\"results1\").rows[i+1].cells[0].style.Color = \"Black\";\n\t\t\t\t\tdocument.getElementById(\"results1\").rows[i+1].cells[2].style.backgroundColor = \"Bisque\";\n\t\t\t\t\tdocument.getElementById(\"results1\").rows[i+1].cells[2].innerText = \"BRU Health Reservation : \"+res_slot_arr[i];\n\n\t\t\t\t}else {\n\t\t\t\t\tdocument.getElementById(\"results1\").rows[i+1].cells[0].style.backgroundColor = \"Bisque\";\n\t\t\t\t\tdocument.getElementById(\"results1\").rows[i+1].cells[0].style.backgroundColor = \"Bisque\";\n\t\t\t\t}\n\t\t\t}\n\n\t\t\t\n\t\t}\n\t\t\t\n\t}\n}\n/* End ML-BRU-CRF-0628.1 */\n\t\t\nasync function allocationDetails(clinicCode,clinicDate,practID){\n\n\t\tvar dialogTop = \"60\" ;\n\t\tvar dialogHeight= \"20\" ;\n\t\tvar dialogWidth\t= \"40\" ;\n\t\tvar status = \"no\";\n\t\tvar arguments\t= \"\" ;\n\t\tvar tit=\"locn_Srch\";\n\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; scroll=no; status:\" + status;\n\t\tvar retVal = await window.showModalDialog(\"../../eOA/jsp/ClinicAllocationDetails.jsp?clinic_code=\"+clinicCode+\"&clinic_date=\"+clinicDate+\"&practitioner_id=\"+practID,arguments,features);\t\n}\n\t\n</script>\n<input type=\'hidden\' name=\'pre_pat_alcn_catg_code\' id=\'pre_pat_alcn_catg_code\' value=\'";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 ="\' >\n\n\t";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 ="\n<script>\n/*Below line Added for this CRF Bru-HIMS-CRF-165.1 [IN:035659]*/\n\nasync function show_order_select(pVal,refno,facilityid,cliniccode,apptstatus){ \n\t \n\t/*var latter=document.getElementById(\"results1\").rows(u1).cells(3).innerText ; \n\tvalue1=document.forms[0].clinic_code.value;\n\tvalue2=document.forms[0].clinic_name.value;\n\tvalue3=document.forms[0].pract_id.value;\n\tvalue4=document.forms[0].pract_name.value;*/\n\tvalue5=document.forms[0].appt_date.value;\n\tvalue6= document.getElementById(\"results1\").rows[u1].cells[u2].innerText;\t\n\tvar s = value6.substr(0,5); \n\tvalue6 = s;\t\n\tvalue7=document.getElementById(\"results1\").rows[u1+1].cells[0].innerText;\t\n\tvalue8=document.forms[0].over_booked.value;\n\tvalue9=document.forms[0].P_O_TIME_TAB_TYPE.value;\n\tvalue10=document.forms[0].patient_id.value;\n\tsys_date=document.forms[0].sys_date.value;\n\tsys_time=document.forms[0].sys_time.value;\n\tfromtimeharray=sys_time.split(\":\");\n\tfrom_time=value6.split(\":\");\n\tto_displayed_time=value7.split(\":\");\n\tvar fromhtm=new Date(1,1,1,fromtimeharray[0],fromtimeharray[1],0,0);\n\tvar tohtm=new Date(1,1,1,from_time[0],from_time[1],0,0);\n\tvar to_displayed=new Date(1,1,1,to_displayed_time[0],to_displayed_time[1],0,0);\n\t//var  old_date=document.forms[0].old_date.value;\n\t//if( old_date.length == 0) document.forms[0].old_date.value=value5;\n\t\n\tvar Mode=\"Record\";\t\n\tif(!pVal) pVal=\'NO\';\t\n\tif(refno != \"\"){\n\t\tif(DateCompare4(document.forms[0].appt_date ,document.forms[0].sys_date)){\t\t\t\t\t\t\t\t\t\n\t\t\t\tif(( Date.parse(fromhtm) >= Date.parse(to_displayed))){\t\t\t\t\t\n\t\t\t\t\tMode=\"View\";\n\t\t\t\t}else if(apptstatus==\"VT\"){\n\t\t\t\t   Mode=\"View\";\n\t\t\t\t}\n    \n          }\n\t}\n\n\n   \n\tvar retVal\t\t=    new String();\n    var dialogHeight= \"95vh\";\t\n\tvar dialogWidth = \"70vw\";\n\tvar dialogTop\t= \"70\";\n\tvar center\t\t= \"1\";\n\tvar status\t\t= \"no\";\n\tvar features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\tvar arguments   = \"\" ;\n\t\n\tvar getUrl = \"../../eOR/jsp/ORApptRefCatalogAddModifyView.jsp?appt_ref_no=\"+refno+\"&Mode=\"+Mode+\"&facilityid=\"+facilityid+\"&p_clinic_code=\"+cliniccode+\"\";\n\t\t\n\tretVal = await top.window.showModalDialog(getUrl,arguments,features);     \n\tif(retVal != null && retVal != \"\"){\n\t\n\t}\t\n\t\n}\n//End this CRF Bru-HIMS-CRF-165.1 [IN:035659]\n\n</script>\n</form>\n</body>\n</html>\n<!--Added for this CRF Bru-CRF-177 -->\n\n";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );


public static String checkForNull(String inputString)
{
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);
  
    // Modified for CRF - SRR -0425 -- Order Catalog. 
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		//String alcn_catg_code="";
		String blkStatus="";
		String blkRemark="";
		String book_appt_yn ="";                  
		String book_appt_wo_pid_yn="";            
		String obook_appt_yn ="";                  
		String book_appt_across_catg_yn  ="";     
		String tfr_appt_yn="";                    
		String tfr_appt_across_catg_yn="";        
		String canc_appt_yn  ="";  
		String alcn_crit="";
		String sql_access="";
		String curr_user_id=(String)session.getValue("login_user");
		String mode_find="";
		String current_date="";
		String current_time="";
		boolean allow_revise=true;
		int max_patient			=0;
		int total_booked		=0;
		String global_locn_yn="";
		PreparedStatement pstmt_label		= null;
		PreparedStatement pstmt=null;
		PreparedStatement pstmt_access		= null;
		CallableStatement cstmt = null;
		CallableStatement statement_bru = null;

		//this CRF Bru-HIMS-CRF-165.1 [IN:035659]	
		int groupCnt = 0;
		 int order_clinic_count=	0; 	
		 Statement stApptgroup=null;
		 ResultSet rsApptgroup=null;
		String groupApptYN = "N";
		int max_patients_per_slab = 0;
		 int group_check=0;
		//End Bru-HIMS-CRF-191 [IN:030391]
		
	//Below variable declare for this  [Bru-HIMS-CRF-177]	
	  String colour_indicator="";
	  /*Added by Thamizh selvi on 17th July 2018 against ML-MMOH-CRF-1058 Start*/
	  boolean isIncRemarksLengthAppl = false;
	  String apptRemarks = "";
	  /*End*/

	   //Added by Ashwini on 27-May-2020 for MOHE-CRF-0017
	   boolean isOverBookingAppl = false;
	   String time_elapsed_yn = "";
	   int sch_cnt = 0;

	   //Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112
	   String schedule_extend_yn="N";

	   //Added by Ashwini on 24-Jun-2020 for PMG2020-MOHE-CRF-0001  
	   int future_slot_count = 0; 

	    //Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
		 Boolean isSlotStartMidEndAppl = false;
		 String p_o_ext_slot_status = "";
		 String p_o_reserved_slot_dtls = "";
		 String p_o_appt_slot_dtls = "";
		 String p_o_block_slot_dtls = "";
		 String p_o_break_slot_dtls = "";
 
try{ 

		String locale = (String)session.getAttribute("LOCALE");
		String callingMode = request.getParameter("callingMode");
		if (callingMode==null) callingMode = "";
		String date=(String)request.getParameter("Date");
		String date1=(String)request.getParameter("Date1");
		mode_find=(String)request.getParameter("mode_find");
		if(mode_find==null) mode_find="";
		String pre_pat_alcn_catg_code = request.getParameter("pre_pat_alcn_catg_code");
		if( pre_pat_alcn_catg_code == null) pre_pat_alcn_catg_code="";
		String clinic_code=(String)request.getParameter("clinic_code1");
		String practitioner_id=(String)request.getParameter("practitioner_id1");
		String from_page=request.getParameter("from_page");
		if(from_page ==null) from_page="";
		String clinic_code2=(String)request.getParameter("clinic_code2");
		String practitioner_id2=(String)request.getParameter("practitioner_id2");

		String facilityid=(String)session.getValue("facility_id");
		String value12=(String)request.getParameter("value12");
		
		if( value12 == null || value12.equals("null")) value12="";
		String value13=(String)request.getParameter("value13");
		if( value13 == null || value13.equals("null"))  value13=""; 
		String old_clinic=(String)request.getParameter("old_clinic");
		if(old_clinic  == null || old_clinic.equals("null"))old_clinic="";

		String old_practitioner=(String)request.getParameter("old_practitioner");
		if(old_practitioner== null || old_practitioner.equals("null"))old_practitioner="";

		String old_from_time = request.getParameter("old_from_time");
		if( old_from_time == null) old_from_time="";

		String old_to_time = request.getParameter("old_to_time");
		if( old_to_time == null) old_to_time="";
			String create_wait_list_yn=request.getParameter("create_wait_list_yn");
			if(create_wait_list_yn ==null) create_wait_list_yn="";

		String old_date=(String)request.getParameter("old_date");
		if(old_date  == null || old_date.equals("null")) old_date="";

		String ca_mode=(String)request.getParameter("ca_mode");

		String ca_patient_id=request.getParameter("ca_patient_id");
		if(ca_patient_id==null) ca_patient_id="";


		String slot_appt_ctrl=request.getParameter("slot_appt_ctrl")==null?"":request.getParameter("slot_appt_ctrl");
		String visit_limit_rule=request.getParameter("visit_limit_rule")==null?"":request.getParameter("visit_limit_rule");
		String alcn_criteria=request.getParameter("alcn_criteria")==null?"":request.getParameter("alcn_criteria");
		String override_no_of_slots_yn=request.getParameter("override_no_of_slots_yn")==null?"":request.getParameter("override_no_of_slots_yn");
		String capture_fin_dtls_yn=request.getParameter("capture_fin_dtls_yn")==null?"N":request.getParameter("capture_fin_dtls_yn");
		String min_ela_per_resc_noshow_in_day=request.getParameter("min_ela_per_resc_noshow_in_day")==null?"":request.getParameter("min_ela_per_resc_noshow_in_day");
		String noshow_ctrl_by_splty_or_clinic=request.getParameter("noshow_ctrl_by_splty_or_clinic")==null?"":request.getParameter("noshow_ctrl_by_splty_or_clinic");
		String contact_num_reqd_yn=request.getParameter("contact_num_reqd_yn")==null?"N":request.getParameter("contact_num_reqd_yn");
		String no_of_noshow_appts_for_alert=request.getParameter("no_of_noshow_appts_for_alert")==null?"":request.getParameter("no_of_noshow_appts_for_alert");
		String per_chk_for_no_show_alert=request.getParameter("per_chk_for_no_show_alert")==null?"":request.getParameter("per_chk_for_no_show_alert");




			//MR by suman 
		String req_id=request.getParameter("req_id");
		if(req_id ==null) req_id="";
		
			String install_yn_val=request.getParameter("install_yn_val");
		if(install_yn_val ==null) install_yn_val="";

		String order_id=request.getParameter("order_id");
		if(order_id==null) order_id="";
		String order_line_num=request.getParameter("order_line_num");
		if(order_line_num == null) order_line_num="";
		String order_catalog_code=request.getParameter("order_catalog_code");
		if(order_catalog_code ==null) order_catalog_code="";

		String clinic_type1=request.getParameter("clinic_type1");
		String res_type1=request.getParameter("res_type1");
		String clinic_type2=request.getParameter("clinic_type2");
		String res_type2=request.getParameter("res_type2");

		String clinic_type3=request.getParameter("clinic_type3");
	
		String value_chk=request.getParameter("value_chk");
		//out.println("value_chk:"+value_chk);
		String res_type3=request.getParameter("res_type3");


		String or_catalogue_code=request.getParameter("or_catalogue_code");
		if(or_catalogue_code == null)  or_catalogue_code="";
		String oper_stn_id=request.getParameter("oper_stn_id");
		if(oper_stn_id == null ) oper_stn_id="";

		if (clinic_type1==null) clinic_type1 = "C";
		if (res_type1==null) res_type1 = "P";

		if (clinic_type2==null) clinic_type2 = "C";
		if (res_type2==null) res_type2 = "P";

		if (clinic_type3==null) clinic_type3 = "C";
		if (res_type3==null) res_type3 = "P";

		String visit_flag_OP=request.getParameter("visit_flag_OP");
		if(visit_flag_OP==null) visit_flag_OP="N";		

		String rd_appt_yn=request.getParameter("rd_appt_yn")==null?"N":request.getParameter("rd_appt_yn");

//OPCheckout
		String from_facility_id= request.getParameter("from_facility_id");
		if(from_facility_id ==null) from_facility_id="";
		String from_encounter_id= request.getParameter("from_encounter_id");
		if(from_encounter_id ==null) from_encounter_id="";

		String P_O_CLINIC             ="";       
		String P_O_PRACTITIONER       ="";   

		//Added by Ashwini on 27-May-2020 for MOHE-CRF-0017
		String P_O_CLINIC_CODE        ="";       
		String P_O_PRACTITIONER_CODE  ="";
		String P_O_SCH_END_TIME		  ="";
		
		String P_O_MAX_PAT            ="";       
		String P_O_MAX_OVER_BOOK      ="";       
		String P_O_BOOKED             ="";       
		String P_O_OVER_BOOKED        ="";       
		String P_O_OVER_BOOKING       ="N";       
		String P_O_TIME_TAB_TYPE     ="";        
		String P_O_STATUS             ="";       
		String P_O_FROM_TIME          ="";       
		String P_O_TO_TIME            ="";       
		String P_O_APPT_REF_NO        ="";       
		String P_O_PATIENT_NAME       ="";    
		String P_O_PATIENT_ID       =""; 

        String P_O_VISIT_TYPE_CODE   =""; //Added for this CRF Bru-CRF-177  
        String P_LAST_APPT_BOOKED   =""; //Added for this CRF Bru-CRF-177    		

		String P_O_AGE                ="";       
		String P_O_GENDER             ="";       
		String P_O_REASON_FOR_CON    ="";        
		String P_O_VISIT_TYPE         ="";       
		String P_O_CONTACT            ="";     
		String P_O_END_TIME= "";
		String P_O_VISIT_TYPE_IND     ="";
		String P_O_NO_OF_SLOTS= "";
		String FORCED_BOOK_APPT_YN="";
		String GLOBAL_BOOK_APPT_YN="";
		String P_O_MAX_FORCED_BOOK    ="";
		String P_O_FORCED_BOOK		  =""; 	
		String P_O_MAX_GLOBAL_BOOK    ="";
		String P_O_GLOBAL_BOOK		  =""; 	
		String P_O_MAX_SLOTS_FOR_FIRST_VISITS = "";
		String P_O_TOTAL_VIRST_VISIT_SLOTS_BOOKED="";
		String P_O_MAX_FIRST_VISITS = "";
		String P_O_TOTAL_FIRST_VISIT = "";
		String P_O_OBVISIT_FLAG = "N";
		String P_O_MAX_SLOTS_PER_DAY="";
		String P_O_MAX_OTHER_VISITS="";
		String P_O_TOTAL_OTHER_VISITS="";
		String clinic_name="";
		String pract_name="";

		String TOTAL_NORMAL_TFR="";
		String TOTAL_BULK_TFR="";
		String P_APPT_OTH_DTL       ="";

		Connection con = null;
		CallableStatement statement = null;
		ResultSet rs = null;
		ResultSet rs32= null;
		//Statement stmtsd=null;
		Statement stmt=null;
		//Statement stmtn=null;
		//String sql="";
		//String sys_date="";
		//String sys_time="";
		String P_O_Max_Forced= "";
		String P_O_Total_Forced= "";
		String P_O_Max_Global= "";
		String P_O_Total_Global= "";

		String total_booked1="";
		//String max_patients_per_day="";
		boolean normal_booking_allow_flag = true;
		String care_locn_ind_desc="";
		String P_O_pat_cat      ="";
		if(value_chk.equals("display0"))
		{
				if(clinic_type1.equals("C")){
			care_locn_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
		}else if(clinic_type1.equals("E")){
			care_locn_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels");
		}else if(clinic_type1.equals("D")){
			care_locn_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels");
		}

		
		}else
		{
			if(clinic_type2.equals("C")){
			care_locn_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
		}else if(clinic_type2.equals("E")){
			care_locn_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels");
		}else if(clinic_type2.equals("D")){
			care_locn_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels");
		}

			
		}
		String res_class_desc="";

	



		if(value_chk.equals("display0"))
		{
				if(res_type1.equals("P"))
				{
				res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
				}else if(res_type1.equals("E"))
				{
				res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
				}else if(res_type1.equals("R"))
				{
			   res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
				}else if(res_type1.equals("O"))
				{
				res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
				}

		}else
		{
			if(res_type2.equals("P"))
				{
				res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
				}else if(res_type2.equals("E"))
				{
				res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
				}else if(res_type2.equals("R"))
				{
			   res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
				}else if(res_type2.equals("O"))
				{
				res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
				}

			
		}
		String calling_mode=request.getParameter("callingMode");
		if(calling_mode==null) calling_mode="N";
		String 	ref_id=(String) session.getValue("ref_id");
		if(ref_id==null) ref_id="N";

try{
	con = ConnectionManager.getConnection(request);
	isIncRemarksLengthAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "OA","INCREASE_APPT_REMARKS_LENGTH");//Added by Thamizh selvi on 17th July 2018 against ML-MMOH-CRF-1058

	isOverBookingAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "OA","SCH_APPT_OVER_BOOKING");//Added by Ashwini on 27-May-2020 for MOHE-CRF-0017

	isSlotStartMidEndAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "OA", "BRU_HEALTH_INTG");//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1

	  /*Below line Added for this CRF Bru-HIMS-CRF-165.1 [IN:035659] */
    stApptgroup=con.createStatement();	
	//String oderclinicquery="select count(*) order_count_clinic from op_catalog_for_clinic a where a.facility_id='"+facilityid+"' AND a.CLINIC_CODE='"+clinic_code+"'";
	//rsApptgroup=stApptgroup.executeQuery(oderclinicquery);
	String oderclinicquery="select count(*) order_count_clinic from op_catalog_for_clinic a where a.facility_id=? AND a.CLINIC_CODE=?";
	pstmt = con.prepareStatement(oderclinicquery);
	pstmt.setString(1,facilityid);
	pstmt.setString(2,clinic_code);
	rsApptgroup = pstmt.executeQuery();
	if(rsApptgroup.next()) {
		order_clinic_count=rsApptgroup.getInt("order_count_clinic");
		
	}
	if(stApptgroup!=null) stApptgroup.close();
	if(rsApptgroup!=null) rsApptgroup.close();
 //End this CRF Bru-HIMS-CRF-165.1 [IN:035659]	
			//stmtsd=con.createStatement();
			//stmtn=con.createStatement();

	/*if (slot_appt_ctrl.equals("P")){

		if(value_chk.equals("display0")){
			alcn_crit="select nvl(max_patients_per_day,0) max_patients_per_day, nvl(total_first_visit,0)+nvl(total_follow_up,0)+nvl(total_routine,0)+nvl(total_series,0)+nvl(total_consult,0)+nvl(total_emergency,0) +nvl(total_first_visits_blocked,0)+ nvl(total_other_visits_blocked,0) total_booked from oa_clinic_schedule  where facility_id='"+facilityid+"' and clinic_date =to_date('"+date+"','dd/mm/yyyy') and clinic_code='"+clinic_code+"'and Nvl(Practitioner_id,'X') =nvl('"+practitioner_id+"' ,'X') and care_locn_type_ind='"+clinic_type1+"' and resource_class='"+res_type1+"'";
		}else{
			alcn_crit="select nvl(max_patients_per_day,0) max_patients_per_day, nvl(total_first_visit,0)+nvl(total_follow_up,0)+nvl(total_routine,0)+nvl(total_series,0)+nvl(total_consult,0)+nvl(total_emergency,0) +nvl(total_first_visits_blocked,0)+ nvl(total_other_visits_blocked,0) total_booked from oa_clinic_schedule  where facility_id='"+facilityid+"' and clinic_date =to_date('"+date1+"','dd/mm/yyyy') and clinic_code='"+clinic_code2+"'and Nvl(Practitioner_id,'X') =nvl('"+practitioner_id2+"' ,'X') and care_locn_type_ind='"+clinic_type2+"' and resource_class='"+res_type2+"'";
		}
		rs = stmtsd.executeQuery(alcn_crit);
		if(rs !=null){
			while ( rs.next() ){
					max_patients_per_day= rs.getString("max_patients_per_day");
					total_booked1		= rs.getString("total_booked");
			}
		
		}   
		
		if(rs !=null) rs.close();
		if (max_patients_per_day.equals(total_booked1))
			normal_booking_allow_flag=false;
	}
	*/
			//if(value_chk.equals("display0")){
				//sql_access="select book_appt_yn,book_appt_wo_pid_yn,obook_appt_yn,book_appt_across_catg_yn,tfr_appt_yn,tfr_appt_across_catg_yn,canc_appt_yn,FORCED_BOOK_APPT_YN,GLOBAL_BOOK_APPT_YN,global_locn_yn from am_os_user_locn_access_vw  where facility_id=? and locn_code=?  and oper_stn_id=? and appl_user_id=? and (book_appt_yn='Y' or book_appt_wo_pid_yn='Y' or obook_appt_yn='Y' or book_appt_across_catg_yn='Y' or tfr_appt_yn='Y' or tfr_appt_across_catg_yn='Y' or canc_appt_yn='Y')";

			//}else{
				//sql_access="select book_appt_yn,book_appt_wo_pid_yn,obook_appt_yn,book_appt_across_catg_yn,tfr_appt_yn,tfr_appt_across_catg_yn,canc_appt_yn,FORCED_BOOK_APPT_YN,GLOBAL_BOOK_APPT_YN,global_locn_yn,(select count(*) count_value from oa_group_hdr a ,oa_group_dtls b where eff_status='E' and LOCN_CODE='"+clinic_code+"' and a.GROUP_ID=b.GROUP_ID) groupCnt,(SELECT group_appt_yn FROM oa_param WHERE module_id = 'OA') group_appt_yn from am_os_user_locn_access_vw  where facility_id=? and locn_code=?  and oper_stn_id=? and appl_user_id=? and (book_appt_yn='Y' or book_appt_wo_pid_yn='Y' or obook_appt_yn='Y' or book_appt_across_catg_yn='Y' or tfr_appt_yn='Y' or tfr_appt_across_catg_yn='Y' or canc_appt_yn='Y')";
				sql_access="select book_appt_yn,book_appt_wo_pid_yn,obook_appt_yn,book_appt_across_catg_yn,tfr_appt_yn,tfr_appt_across_catg_yn,canc_appt_yn,FORCED_BOOK_APPT_YN,GLOBAL_BOOK_APPT_YN,global_locn_yn,(select count(*) count_value from oa_group_hdr a ,oa_group_dtls b where eff_status='E' and LOCN_CODE=? and a.GROUP_ID=b.GROUP_ID) groupCnt,(SELECT group_appt_yn FROM oa_param WHERE module_id = 'OA') group_appt_yn from am_os_user_locn_access_vw  where facility_id=? and locn_code=?  and oper_stn_id=? and appl_user_id=? and (book_appt_yn='Y' or book_appt_wo_pid_yn='Y' or obook_appt_yn='Y' or book_appt_across_catg_yn='Y' or tfr_appt_yn='Y' or tfr_appt_across_catg_yn='Y' or canc_appt_yn='Y')";

			//}
	
				pstmt_access = con.prepareStatement(sql_access);

				pstmt_access.setString(1,clinic_code);
				pstmt_access.setString(2,facilityid);
				if(value_chk.equals("display0")){
					pstmt_access.setString(3,clinic_code);
				}else{
					pstmt_access.setString(3,clinic_code2);
				}
				pstmt_access.setString(4,oper_stn_id);
				pstmt_access.setString(5,curr_user_id);


			rs = pstmt_access.executeQuery();
		if(rs !=null)
		{
			while ( rs.next() )
			{
					book_appt_yn= rs.getString("book_appt_yn");
					book_appt_wo_pid_yn= rs.getString("book_appt_wo_pid_yn");
					obook_appt_yn= rs.getString("obook_appt_yn");
					book_appt_across_catg_yn= rs.getString("book_appt_across_catg_yn");
					tfr_appt_yn= rs.getString("tfr_appt_yn");
					tfr_appt_across_catg_yn= rs.getString("tfr_appt_across_catg_yn");
					canc_appt_yn= rs.getString("canc_appt_yn");
					FORCED_BOOK_APPT_YN= rs.getString("FORCED_BOOK_APPT_YN");
					GLOBAL_BOOK_APPT_YN = rs.getString("GLOBAL_BOOK_APPT_YN");					
					global_locn_yn= rs.getString("global_locn_yn");
					if(global_locn_yn==null)global_locn_yn="N";
					groupCnt = rs.getInt("groupCnt");
					groupApptYN = rs.getString("group_appt_yn")==null?"N":rs.getString("group_appt_yn");
			}
		}
			if(rs !=null) rs.close();

	StringBuffer sql_label=new StringBuffer();

	//if(value_chk.equals("display0")){

		sql_label.append("select OP_GET_DESC.OP_CLINIC(FACILITY_ID, CLINIC_CODE,?,'1') clinic_name, clinic_code, decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(practitioner_id,?,'1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, practitioner_id,?,'2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, practitioner_id,?,'2'),'O', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, practitioner_id,?,'2'))  practitioner_name, practitioner_id, time_table_type, max_patients_per_day, nvl(max_over_booking,0) max_over_booking, nvl(total_slots_booked,0) total_slots_booked, nvl(total_slots_overbooked,0)total_slots_overbooked,  to_char(start_time,'hh24:mi') start_time, to_char(end_time,'hh24:mi')end_time, nvl(total_first_visit_slots_booked,0) total_first_visit_slots_booked, nvl(max_slots_for_first_visit,0) max_slots_for_first_visit, nvl(total_first_visit,0) total_first_visit, nvl(max_other_visits,0) max_other_visits, nvl(total_follow_up,0)+nvl(total_routine,0)+nvl(total_series,0)+nvl(total_consult,0)+nvl(total_emergency,0) total_other_visits, nvl(max_first_visits,0) max_first_visits, nvl(max_slots_per_day,0) max_slots_per_day, nvl(MAX_FORCED_IN_BOOKING,0)MAX_FORCED_IN_BOOKING, nvl(TOTAL_FORCED_IN_BOOKED,0)TOTAL_FORCED_IN_BOOKED, nvl(MAX_GLOBAL_BOOKING,0)MAX_GLOBAL_BOOKING, nvl(TOTAL_GLOBAL_BOOKED,0)TOTAL_GLOBAL_BOOKED, nvl(total_first_visits_blocked,0) total_first_visits_blocked, nvl(total_other_visits_blocked,0) total_other_visits_blocked ,NVL(Schedule_status,'A') Schedulestatus,Remarks, to_char(sysdate,'dd/mm/yyyy') current_date,to_char(sysdate,'hh24:mi') current_time, TOTAL_NORMAL_TFR, TOTAL_BULK_TFR,nvl(total_first_visit,0)+nvl(total_follow_up,0)+nvl(total_routine,0)+nvl(total_series,0)+nvl(total_consult,0)+nvl(total_emergency,0) +nvl(total_first_visits_blocked,0)+ nvl(total_other_visits_blocked,0) total_booked_count,max_patients_per_slab, schedule_extend_yn  from oa_clinic_schedule where facility_id=? and clinic_date  =to_date(?,'dd/mm/yyyy') and clinic_code=?  and care_locn_type_ind =? and resource_class=? and ");
		//Modified by Ashwini on 27-May-2020 for MOHE-CRF-0017


		if(value_chk.equals("display0")){
		
			if(practitioner_id.equals("")){
				sql_label.append(" practitioner_id is null ");
			}else{
				sql_label.append(" practitioner_id =? ");
			}
		}else{
			if(practitioner_id2.equals("")){
				sql_label.append(" practitioner_id is null ");
			}else{
				sql_label.append(" practitioner_id =? ");
			}
		}

	
	//}else{

		//sql_label.append("select OP_GET_DESC.OP_CLINIC(FACILITY_ID, CLINIC_CODE,?,'1') clinic_name, decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(practitioner_id,?,'1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, practitioner_id,?,'2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, practitioner_id,?,'2'),'O', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, practitioner_id,?,'2'))  practitioner_name, time_table_type, max_patients_per_day, nvl(max_over_booking,0) max_over_booking, nvl(total_slots_booked,0) total_slots_booked, nvl(total_slots_overbooked,0)total_slots_overbooked,  to_char(start_time,'hh24:mi') start_time, to_char(end_time,'hh24:mi')end_time, nvl(total_first_visit_slots_booked,0) total_first_visit_slots_booked, nvl(max_slots_for_first_visit,0) max_slots_for_first_visit, nvl(total_first_visit,0) total_first_visit, nvl(max_other_visits,0) max_other_visits, nvl(total_follow_up,0)+nvl(total_routine,0)+nvl(total_series,0)+nvl(total_consult,0)+nvl(total_emergency,0) total_other_visits, nvl(max_first_visits,0) max_first_visits, nvl(max_slots_per_day,0) max_slots_per_day, nvl(MAX_FORCED_IN_BOOKING,0)MAX_FORCED_IN_BOOKING, nvl(TOTAL_FORCED_IN_BOOKED,0)TOTAL_FORCED_IN_BOOKED, nvl(MAX_GLOBAL_BOOKING,0)MAX_GLOBAL_BOOKING, nvl(TOTAL_GLOBAL_BOOKED,0)TOTAL_GLOBAL_BOOKED, nvl(total_first_visits_blocked,0) total_first_visits_blocked, nvl(total_other_visits_blocked,0) total_other_visits_blocked ,NVL(Schedule_status,'A') Schedulestatus,Remarks, to_char(sysdate,'dd/mm/yyyy') current_date,to_char(sysdate,'hh24:mi') current_time, TOTAL_NORMAL_TFR, TOTAL_BULK_TFR,nvl(total_first_visit,0)+nvl(total_follow_up,0)+nvl(total_routine,0)+nvl(total_series,0)+nvl(total_consult,0)+nvl(total_emergency,0) +nvl(total_first_visits_blocked,0)+ nvl(total_other_visits_blocked,0) total_booked_count  from oa_clinic_schedule where facility_id=? and clinic_date  =to_date(?,'dd/mm/yyyy') and clinic_code=?  and care_locn_type_ind =? and resource_class=? and ");
		
		//if(practitioner_id2.equals("")){
			//sql_label.append(" practitioner_id is null ");
		//}else{
			//sql_label.append(" practitioner_id =? ");
		//}
			

	//}
		

		pstmt_label = con.prepareStatement(sql_label.toString());

		pstmt_label.setString(1,locale);
		pstmt_label.setString(2,locale);
		pstmt_label.setString(3,locale);
		pstmt_label.setString(4,locale);
		pstmt_label.setString(5,locale);
		pstmt_label.setString(6,facilityid);
		
		if(value_chk.equals("display0")){

			pstmt_label.setString(7,date);
			pstmt_label.setString(8,clinic_code);
			pstmt_label.setString(9,clinic_type1);
			pstmt_label.setString(10,res_type1);

			if(!practitioner_id.equals("")){
				pstmt_label.setString(11,practitioner_id);
			}
		}else{
			pstmt_label.setString(7,date1);
			pstmt_label.setString(8,clinic_code2);
			pstmt_label.setString(9,clinic_type2);
			pstmt_label.setString(10,res_type2);

			if(!practitioner_id2.equals("")){
				pstmt_label.setString(11,practitioner_id2);
			}
		}

		rs32 = pstmt_label.executeQuery();
	
		while ( rs32.next() )
		{
			P_O_CLINIC			= rs32.getString("clinic_name");
			P_O_PRACTITIONER 	= rs32.getString("practitioner_name");
			if( P_O_PRACTITIONER == null) P_O_PRACTITIONER="";
			
			//Added by Ashwini on 27-May-2020 for MOHE-CRF-0017
			P_O_CLINIC_CODE 	= rs32.getString("clinic_code");
			if( P_O_CLINIC_CODE == null) P_O_CLINIC_CODE="";
			P_O_PRACTITIONER_CODE 	= rs32.getString("practitioner_id");
			if( P_O_PRACTITIONER_CODE == null) P_O_PRACTITIONER_CODE="";

			P_O_MAX_PAT 		= rs32.getString("max_patients_per_day");
			P_O_TIME_TAB_TYPE    = rs32.getString("time_table_type" );   
			P_O_MAX_OVER_BOOK   =rs32.getString("max_over_booking" );        if(P_O_MAX_OVER_BOOK==null) P_O_MAX_OVER_BOOK="";
			P_O_BOOKED                 	=rs32.getString("total_slots_booked" );   if( P_O_BOOKED ==null) P_O_BOOKED="";

			P_O_MAX_FORCED_BOOK  =rs32.getString("MAX_FORCED_IN_BOOKING");
			if(P_O_MAX_FORCED_BOOK==null)P_O_MAX_FORCED_BOOK="";
			P_O_FORCED_BOOK	=rs32.getString("TOTAL_FORCED_IN_BOOKED");
			if(P_O_FORCED_BOOK==null)P_O_FORCED_BOOK="";

			schedule_extend_yn=rs32.getString("schedule_extend_yn");
			if(schedule_extend_yn==null) schedule_extend_yn="N";

			P_O_MAX_GLOBAL_BOOK  =rs32.getString("MAX_GLOBAL_BOOKING");
			if(P_O_MAX_GLOBAL_BOOK==null)P_O_MAX_GLOBAL_BOOK="";
			P_O_GLOBAL_BOOK	=rs32.getString("TOTAL_GLOBAL_BOOKED");
			if(P_O_GLOBAL_BOOK==null)P_O_GLOBAL_BOOK="";
			blkStatus= rs32.getString("Schedulestatus");
			if(blkStatus ==null) blkStatus="";
			blkRemark=rs32.getString("Remarks");
			if(blkRemark ==null) blkRemark="";
			current_date=rs32.getString("current_date");
			if(current_date ==null) current_date="";
			current_time=rs32.getString("current_time");
			if(current_time ==null) current_time="";

			if (slot_appt_ctrl.equals("P")){
				total_booked1		= rs32.getString("total_booked_count");
				if (P_O_MAX_PAT.equals(total_booked1))
					normal_booking_allow_flag=false;
			}

			P_O_OVER_BOOKED        =rs32.getString( "total_slots_overbooked" );    if(  P_O_OVER_BOOKED ==null) P_O_OVER_BOOKED="";

			P_O_TO_TIME                  =rs32.getString("start_time" );	if(P_O_TO_TIME == null) P_O_TO_TIME="";
			P_O_SCH_END_TIME = rs32.getString("end_time"); if( P_O_SCH_END_TIME == null) P_O_SCH_END_TIME="";//Added by Ashwini on 27-May-2020 for MOHE-CRF-0017
			P_O_MAX_SLOTS_FOR_FIRST_VISITS = rs32.getString("max_slots_for_first_visit"); if( P_O_MAX_SLOTS_FOR_FIRST_VISITS == null) P_O_MAX_SLOTS_FOR_FIRST_VISITS="";
			P_O_TOTAL_VIRST_VISIT_SLOTS_BOOKED= rs32.getString("total_first_visit_slots_booked"); if( P_O_TOTAL_VIRST_VISIT_SLOTS_BOOKED == null) P_O_TOTAL_VIRST_VISIT_SLOTS_BOOKED="";
			P_O_MAX_FIRST_VISITS = rs32.getString("max_first_visits"); if( P_O_MAX_FIRST_VISITS == null) P_O_MAX_FIRST_VISITS="";
			P_O_TOTAL_FIRST_VISIT = rs32.getString("total_first_visit"); if( P_O_TOTAL_FIRST_VISIT == null) P_O_TOTAL_FIRST_VISIT="";

			TOTAL_NORMAL_TFR=rs32.getString("TOTAL_NORMAL_TFR");
			if(TOTAL_NORMAL_TFR ==null) TOTAL_NORMAL_TFR="0";

			TOTAL_BULK_TFR=rs32.getString("TOTAL_BULK_TFR");
			if(TOTAL_BULK_TFR ==null) TOTAL_BULK_TFR="0";


			max_patients_per_slab = rs32.getInt("max_patients_per_slab"); 
			P_O_MAX_OTHER_VISITS = rs32.getString("max_other_visits"); 
			if( P_O_MAX_OTHER_VISITS == null) P_O_MAX_OTHER_VISITS="";
			P_O_TOTAL_OTHER_VISITS = rs32.getString("total_other_visits"); 
			if( P_O_TOTAL_OTHER_VISITS == null) P_O_TOTAL_OTHER_VISITS="";
			clinic_name	= rs32.getString("clinic_name");
			if(clinic_name ==null) clinic_name="";
			pract_name	= rs32.getString("practitioner_name");
			if(pract_name == null) pract_name="";
			P_O_MAX_SLOTS_PER_DAY= rs32.getString("max_slots_per_day"); 
			if( P_O_MAX_SLOTS_PER_DAY== null) P_O_MAX_SLOTS_PER_DAY="";
			if (P_O_TIME_TAB_TYPE.equals("1") && slot_appt_ctrl.equals("P"))
			P_O_BOOKED = 	String.valueOf(Integer.parseInt(P_O_TOTAL_FIRST_VISIT)+Integer.parseInt(P_O_TOTAL_OTHER_VISITS)+Integer.parseInt(rs32.getString("total_first_visits_blocked"))+Integer.parseInt(rs32.getString("total_other_visits_blocked")));
			P_O_TOTAL_FIRST_VISIT   = String.valueOf(Integer.parseInt(P_O_TOTAL_FIRST_VISIT)+Integer.parseInt(rs32.getString("total_first_visits_blocked")));
			P_O_TOTAL_OTHER_VISITS  = String.valueOf(Integer.parseInt(P_O_TOTAL_OTHER_VISITS)+Integer.parseInt(rs32.getString("total_other_visits_blocked")));
		
		//Added by Ashwini on 27-May-2020 for MOHE-CRF-0017
		time_elapsed_yn = eOA.OACommonBean.getTimeElapsedYN(con,P_O_SCH_END_TIME,current_time);
		sch_cnt = eOA.OACommonBean.getScheduleCount(con,P_O_CLINIC_CODE,P_O_PRACTITIONER_CODE,facilityid,P_O_TO_TIME);
		
		if(isOverBookingAppl)
		{
			if(("1").equals(P_O_TIME_TAB_TYPE) || ("2").equals(P_O_TIME_TAB_TYPE))
			{
				if(!("Y").equals(P_O_OVER_BOOKING))
				{
					if(date.equals(current_date))
					{
						if(("Y").equals(time_elapsed_yn))
						{
							if(Integer.parseInt(P_O_OVER_BOOKED) < Integer.parseInt(P_O_MAX_OVER_BOOK))
							{
								P_O_OVER_BOOKING = "Y";
							}
						}else
						{
							if(sch_cnt > 0)
							{
								//Added by Ashwini on 24-Jun-2020 for PMG2020-MOHE-CRF-0001
								future_slot_count = eOA.OACommonBean.getFutureSlotCount(con,P_O_CLINIC_CODE,P_O_PRACTITIONER_CODE,facilityid,P_O_TO_TIME,P_O_SCH_END_TIME);
								
								if(future_slot_count == 0)
								{
									if(Integer.parseInt(P_O_OVER_BOOKED) < Integer.parseInt(P_O_MAX_OVER_BOOK))
									{
										P_O_OVER_BOOKING = "Y";
									}
								}
							}
						}
					}
				}
			}
		}
	
		if (!visit_limit_rule.equals("N"))
		{
				if(! P_O_MAX_FIRST_VISITS.equals("") &&  !P_O_TOTAL_FIRST_VISIT.equals("") && !P_O_MAX_OVER_BOOK.equals("") && !P_O_OVER_BOOKED.equals(""))
				{
					if (Integer.parseInt(P_O_MAX_FIRST_VISITS) <= Integer.parseInt(P_O_TOTAL_FIRST_VISIT)  &&  Integer.parseInt(P_O_MAX_OVER_BOOK)  > Integer.parseInt(P_O_OVER_BOOKED)&&Integer.parseInt(P_O_MAX_FIRST_VISITS)>0)
					{
						P_O_OVER_BOOKING         ="Y";
						P_O_OBVISIT_FLAG		 ="F";
					}
				}
				if(! P_O_MAX_OTHER_VISITS.equals("") &&  !P_O_TOTAL_OTHER_VISITS.equals("") && !P_O_MAX_OVER_BOOK.equals("") && !P_O_OVER_BOOKED.equals(""))
				{
						if (Integer.parseInt(P_O_MAX_OTHER_VISITS) <= Integer.parseInt(P_O_TOTAL_OTHER_VISITS)  &&  Integer.parseInt(P_O_MAX_OVER_BOOK)  > Integer.parseInt(P_O_OVER_BOOKED)&&Integer.parseInt(P_O_MAX_OTHER_VISITS)>0)
						{
							P_O_OVER_BOOKING         ="Y";
							if(P_O_OBVISIT_FLAG.equals("F"))
								P_O_OBVISIT_FLAG		 ="A";
							else
								P_O_OBVISIT_FLAG		 ="O";
						}
					}		
		}
		if(! P_O_MAX_PAT.equals("") &&  !P_O_BOOKED.equals("") && !P_O_MAX_OVER_BOOK.equals("") && !P_O_OVER_BOOKED.equals(""))
		{
		 	if (Integer.parseInt(P_O_MAX_PAT) == Integer.parseInt(P_O_BOOKED)  &&  Integer.parseInt(P_O_MAX_OVER_BOOK)  > Integer.parseInt(P_O_OVER_BOOKED))
			{
				P_O_OVER_BOOKING         ="Y";
				P_O_OBVISIT_FLAG		 ="A";
			}
		}



	}//end of while loop
	String  over_booked_label="";
over_booked_label=P_O_OVER_BOOKING;

if(blkStatus.equals("B")){
	P_O_OVER_BOOKING="N";
}
		if(rs32 !=null) rs32.close();
		
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

		if(P_O_MAX_PAT==null || P_O_MAX_PAT.equals(""))
			{
		if(P_O_PRACTITIONER==null) P_O_PRACTITIONER="";


            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(care_locn_ind_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(clinic_name));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(res_class_desc));
            _bw.write(_wl_block13Bytes, _wl_block13);

	if(!pract_name.equals("")){
	
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(pract_name));
            _bw.write(_wl_block15Bytes, _wl_block15);

	}else{
	
            _bw.write(_wl_block16Bytes, _wl_block16);

	}
	
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(value12));
            _bw.write(_wl_block18Bytes, _wl_block18);

}else{
if( P_O_CLINIC.length() !=0) { 


            _bw.write(_wl_block2Bytes, _wl_block2);

	String group_sql="";
	if(!alcn_criteria.equals("")){
		if(value_chk.equals("display0")){
			//group_sql="select alcn_criteria from oa_clinic_schedule where clinic_date=to_date('"+date+"','dd/mm/yyyy') and facility_id='"+facilityid+"' and clinic_code='"+clinic_code+"' and nvl(practitioner_id,'X')=nvl('"+practitioner_id+"','X')";
			group_sql="select alcn_criteria from oa_clinic_schedule where clinic_date=to_date(?,'dd/mm/yyyy') and facility_id=? and clinic_code=? and nvl(practitioner_id,'X')=nvl(?,'X')";
		}else{
			//group_sql="select alcn_criteria from oa_clinic_schedule where clinic_date=to_date('"+date+"','dd/mm/yyyy') and facility_id='"+facilityid+"' and clinic_code='"+clinic_code2+"' and nvl(practitioner_id,'X')=nvl('"+practitioner_id2+"','X')";
			group_sql="select alcn_criteria from oa_clinic_schedule where clinic_date=to_date(?,'dd/mm/yyyy') and facility_id=? and clinic_code=? and nvl(practitioner_id,'X')=nvl(?,'X')";
		}
		//stmt=con.createStatement();
		//rs=stmt.executeQuery(group_sql);
		pstmt = con.prepareStatement(group_sql);
		pstmt.setString(1,date);
		pstmt.setString(2,facilityid);
		if(value_chk.equals("display0")){
		pstmt.setString(3,clinic_code);
		pstmt.setString(4,practitioner_id);
		}else{
		pstmt.setString(3,clinic_code2);
		pstmt.setString(4,practitioner_id2);
		}
		rs = pstmt.executeQuery();
		while(rs!=null && rs.next()){
			 alcn_criteria=rs.getString("alcn_criteria")==null?"":rs.getString("alcn_criteria");
		}
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();
	}

 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(care_locn_ind_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(P_O_CLINIC ));
            _bw.write(_wl_block20Bytes, _wl_block20);
 if(value_chk.equals("display0"))
	            {
				if(!alcn_criteria.equals("")) {
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(date));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
}else{
            _bw.write(_wl_block25Bytes, _wl_block25);
}
				}
				else
            if(!alcn_criteria.equals("")) {
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(clinic_code2));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(date));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(practitioner_id2));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
}else{
            _bw.write(_wl_block25Bytes, _wl_block25);
}
				
            _bw.write(_wl_block26Bytes, _wl_block26);
if(P_O_OVER_BOOKING.equals("Y") && global_locn_yn.equals("N")){
				if((calling_mode.equals("")) ||((calling_mode).equals("OP") && ref_id.equals("N")) || (calling_mode.equals("CA") || (calling_mode.equals("OR")) )){
				
					
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

				
					}
				}
				
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(res_class_desc));
            _bw.write(_wl_block30Bytes, _wl_block30);
if(! P_O_PRACTITIONER.equals("")){ 
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(P_O_PRACTITIONER ));
            _bw.write(_wl_block32Bytes, _wl_block32);
}else{P_O_PRACTITIONER=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOA.Notidentified.label","oa_labels"); 
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(P_O_PRACTITIONER ));
            _bw.write(_wl_block30Bytes, _wl_block30);
}
            _bw.write(_wl_block34Bytes, _wl_block34);
  if (P_O_TIME_TAB_TYPE.equals("1") && slot_appt_ctrl.equals("S")){
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
}else{
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
}
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
if (!P_O_TIME_TAB_TYPE.equals("3")){
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
}else{
            _bw.write(_wl_block41Bytes, _wl_block41);
}
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
if (P_O_TIME_TAB_TYPE.equals("1") && slot_appt_ctrl.equals("S")){
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(P_O_MAX_SLOTS_PER_DAY));
            _bw.write(_wl_block36Bytes, _wl_block36);
}else{
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(P_O_MAX_PAT));
            _bw.write(_wl_block36Bytes, _wl_block36);
}
            _bw.write(_wl_block45Bytes, _wl_block45);
if(P_O_MAX_FIRST_VISITS.equals("0")){
            _bw.write(_wl_block46Bytes, _wl_block46);
}else{
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(P_O_MAX_FIRST_VISITS));
            _bw.write(_wl_block48Bytes, _wl_block48);
}
            _bw.write(_wl_block49Bytes, _wl_block49);
if(P_O_MAX_OTHER_VISITS.equals("0")){
            _bw.write(_wl_block46Bytes, _wl_block46);
}else{
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(P_O_MAX_OTHER_VISITS));
            _bw.write(_wl_block48Bytes, _wl_block48);
}
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(P_O_MAX_OVER_BOOK));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(P_O_MAX_GLOBAL_BOOK));
            _bw.write(_wl_block52Bytes, _wl_block52);
if (!P_O_TIME_TAB_TYPE.equals("3")){
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(P_O_MAX_FORCED_BOOK));
            _bw.write(_wl_block36Bytes, _wl_block36);
}else{
            _bw.write(_wl_block41Bytes, _wl_block41);
}
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(P_O_BOOKED));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(P_O_TOTAL_FIRST_VISIT));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(P_O_TOTAL_OTHER_VISITS));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(P_O_OVER_BOOKED));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(P_O_GLOBAL_BOOK));
            _bw.write(_wl_block39Bytes, _wl_block39);
if (!P_O_TIME_TAB_TYPE.equals("3")){
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(P_O_FORCED_BOOK));
            _bw.write(_wl_block36Bytes, _wl_block36);
}else{
            _bw.write(_wl_block41Bytes, _wl_block41);
}
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(TOTAL_NORMAL_TFR));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(TOTAL_BULK_TFR));
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);
 if(isIncRemarksLengthAppl){ 
            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);
 } 
            _bw.write(_wl_block68Bytes, _wl_block68);
}
		}
		
            _bw.write(_wl_block69Bytes, _wl_block69);
 if(mode_find !=null && mode_find.equals("revise"))
{
	if(date !=null && date.equals(old_date))
	{
		allow_revise=true;
	}
	else
	{
		alcn_crit="";

		

	}//else
}//revise

	if(rs !=null) rs.close();

	//PreparedStatement pstmtststus=null;
	//ResultSet rsststus=null;
	

		/* Added for ML-BRU-CRF-0628.1 */
		if(isSlotStartMidEndAppl){
			cstmt = con.prepareCall("{call oa_external_slots_BRU(?,?,?,?,?,?,?,?,?)}");

			if(value_chk.equals("display0"))
			{
				cstmt.setString( 1, facilityid );
				cstmt.setString( 2, clinic_code );
				cstmt.setString( 3, practitioner_id );
				cstmt.setString( 4, date );
			}else
			{
				cstmt.setString( 1, facilityid );
				cstmt.setString( 2, clinic_code2 );
				cstmt.setString( 3, practitioner_id2 );
				cstmt.setString( 4, date1 );
			}
			cstmt.registerOutParameter( 5, Types.VARCHAR );
			cstmt.registerOutParameter( 6, Types.VARCHAR );
			cstmt.registerOutParameter( 7, Types.VARCHAR );
			cstmt.registerOutParameter( 8, Types.VARCHAR );
			cstmt.registerOutParameter( 9, Types.VARCHAR );

			cstmt.execute() ;

			p_o_ext_slot_status = cstmt.getString( 5 ); 
			if(p_o_ext_slot_status == null) p_o_ext_slot_status = "";
			
			p_o_reserved_slot_dtls = cstmt.getString( 6 );
			if(p_o_reserved_slot_dtls == null) p_o_reserved_slot_dtls = "";

			p_o_appt_slot_dtls = cstmt.getString( 7 );
			if(p_o_appt_slot_dtls == null) p_o_appt_slot_dtls = "";

			p_o_block_slot_dtls = cstmt.getString( 8 );
			if(p_o_block_slot_dtls == null) p_o_block_slot_dtls = "";

			p_o_break_slot_dtls = cstmt.getString( 9 );
			if(p_o_break_slot_dtls == null) p_o_break_slot_dtls = "";
		}
		
		if(isSlotStartMidEndAppl && P_O_TIME_TAB_TYPE.equals("2") && max_patients_per_slab != 1){

			System.err.println("Before execute oa_slabs_BRU---in Param---facilityid-->"+facilityid+"  clinic_code-->"+clinic_code+"  practitioner_id-->"+practitioner_id+"  date-->"+date);
			System.err.println("Before execute oa_slabs_BRU---in Param---facilityid-->"+facilityid+"  clinic_code2-->"+clinic_code2+"  practitioner_id2-->"+practitioner_id2+"  date1-->"+date1);

			statement_bru = con.prepareCall("{call oa_slabs_BRU(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			
			if(value_chk.equals("display0"))
			{
				statement_bru.setString( 1, facilityid );
				statement_bru.setString( 2, clinic_code );
				statement_bru.setString( 3, practitioner_id );
				statement_bru.setString( 4, date );
			}else
			{
				statement_bru.setString( 1, facilityid );
				statement_bru.setString( 2, clinic_code2 );
				statement_bru.setString( 3, practitioner_id2 );
				statement_bru.setString( 4, date1 );
			}

			statement_bru.registerOutParameter( 5, Types.CLOB );
			statement_bru.registerOutParameter( 6, Types.CLOB );
			statement_bru.registerOutParameter( 7, Types.CLOB );
			statement_bru.registerOutParameter( 8, Types.CLOB );
			statement_bru.registerOutParameter( 9, Types.CLOB );
			statement_bru.registerOutParameter(10, Types.CLOB );
			statement_bru.registerOutParameter(11, Types.CLOB );
			statement_bru.registerOutParameter(12, Types.CLOB );
			statement_bru.registerOutParameter(13, Types.CLOB );
			statement_bru.registerOutParameter(14, Types.CLOB );
			statement_bru.registerOutParameter(15, Types.CLOB );
			statement_bru.registerOutParameter(16, Types.CLOB );
			statement_bru.registerOutParameter(17, Types.CLOB );
			statement_bru.registerOutParameter(18, Types.CLOB );
			statement_bru.registerOutParameter(19, Types.CLOB );
			statement_bru.registerOutParameter(20, Types.CLOB );
			statement_bru.registerOutParameter(21, Types.CLOB );
			statement_bru.registerOutParameter(22, Types.CLOB );
			statement_bru.registerOutParameter(23, Types.CLOB );
			statement_bru.registerOutParameter(24, Types.CLOB );
			statement_bru.registerOutParameter(25, Types.CLOB );
			statement_bru.registerOutParameter(26, Types.CLOB );

			statement_bru.execute() ;

			P_O_CLINIC = P_O_CLINIC_CODE;

			P_O_PRACTITIONER = P_O_PRACTITIONER_CODE;

			P_O_END_TIME = P_O_SCH_END_TIME;

			P_O_Max_Forced = P_O_MAX_FORCED_BOOK;

			P_O_Total_Forced = P_O_FORCED_BOOK;

			P_O_Max_Global = P_O_MAX_GLOBAL_BOOK;
				
			P_O_Total_Global = P_O_GLOBAL_BOOK;

			P_O_STATUS = statement_bru.getString(6); 
			if( P_O_STATUS == null) P_O_STATUS="";

			P_O_APPT_REF_NO = statement_bru.getString(7); 
			if( P_O_APPT_REF_NO == null) P_O_APPT_REF_NO="";

			P_O_PATIENT_NAME = statement_bru.getString(8); 
			if( P_O_PATIENT_NAME == null) P_O_PATIENT_NAME="";

			P_O_AGE = statement_bru.getString(9); 
			if( P_O_AGE == null) P_O_AGE="";

			P_O_GENDER = statement_bru.getString(10); 
			if( P_O_GENDER == null) P_O_GENDER="";

			P_O_REASON_FOR_CON = statement_bru.getString(12); 
			if( P_O_REASON_FOR_CON == null) P_O_REASON_FOR_CON="";

			P_O_VISIT_TYPE = statement_bru.getString(17); 
			if( P_O_VISIT_TYPE == null) P_O_VISIT_TYPE="";

			P_O_CONTACT = statement_bru.getString(13); 
			if( P_O_CONTACT == null) P_O_CONTACT="";

			P_O_VISIT_TYPE_IND = statement_bru.getString(14); 
			if( P_O_VISIT_TYPE_IND == null) P_O_VISIT_TYPE_IND="";

			P_O_PATIENT_ID = statement_bru.getString(15); 
			if( P_O_PATIENT_ID == null) P_O_PATIENT_ID="";

			P_LAST_APPT_BOOKED = statement_bru.getString(16); 
			if( P_LAST_APPT_BOOKED == null) P_LAST_APPT_BOOKED="";

			P_O_VISIT_TYPE_CODE = statement_bru.getString(11); 
			if( P_O_VISIT_TYPE_CODE == null) P_O_VISIT_TYPE_CODE="";

			P_APPT_OTH_DTL = statement_bru.getString(22); 
			if( P_APPT_OTH_DTL == null) P_APPT_OTH_DTL="";

			P_O_pat_cat = statement_bru.getString(23); 
			if( P_O_pat_cat == null) P_O_pat_cat="";

			P_O_FROM_TIME = statement_bru.getString(24);     
			if(P_O_FROM_TIME == null) P_O_FROM_TIME="";

			P_O_TO_TIME = statement_bru.getString(25);	
			if(P_O_TO_TIME == null) P_O_TO_TIME="";

			P_O_NO_OF_SLOTS = statement_bru.getString(26); 
			if( P_O_NO_OF_SLOTS == null) P_O_NO_OF_SLOTS="";

		}else{
		/* End ML-BRU-CRF-0628.1 */
		
		System.err.println("Before execute get_day_status---in Param---facilityid-->"+facilityid+"  date-->"+date+"  clinic_code-->"+clinic_code+"  practitioner_id-->"+practitioner_id+"  clinic_type1-->"+clinic_type1+"  res_type1-->"+res_type1);
		System.err.println("Before execute get_day_status---in Param---facilityid-->"+facilityid+"  date1-->"+date1+"  clinic_code2-->"+clinic_code2+"  practitioner_id2-->"+practitioner_id2+"  clinic_type2-->"+clinic_type2+"  res_type2-->"+res_type2);

		statement=con.prepareCall("{call oa_schedules.get_day_status( ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
					
		statement.setString( 1, facilityid);
		if(value_chk.equals("display0"))
		{
			statement.setString( 2, date);
			statement.setString( 3, clinic_code);
			statement.setString( 4, practitioner_id);
			statement.setString( 5, clinic_type1);
			statement.setString( 6, res_type1);
		}else
		{
			statement.setString( 2, date1);
			statement.setString( 3, clinic_code2);
			statement.setString( 4, practitioner_id2);
			statement.setString( 5, clinic_type2);
			statement.setString( 6, res_type2);
		}

		statement.registerOutParameter(7, Types.VARCHAR );
		statement.registerOutParameter(8, Types.VARCHAR );
		
		/*
		statement.registerOutParameter(7, Types.CLOB );
		statement.registerOutParameter(8, Types.CLOB );
		*/
		statement.registerOutParameter(9, Types.INTEGER);
		statement.registerOutParameter(10, Types.INTEGER);
		statement.registerOutParameter(11, Types.INTEGER);
		statement.registerOutParameter(12, Types.INTEGER);

		statement.registerOutParameter(13, Types.VARCHAR );
		statement.registerOutParameter(14, Types.VARCHAR );
		statement.registerOutParameter(15, Types.VARCHAR );
		statement.registerOutParameter(16, Types.VARCHAR );
		statement.registerOutParameter(17, Types.VARCHAR );
		statement.registerOutParameter(18, Types.VARCHAR );
		statement.registerOutParameter(19, Types.VARCHAR );
		statement.registerOutParameter(20, Types.VARCHAR );
		statement.registerOutParameter(21, Types.VARCHAR );
		statement.registerOutParameter(22, Types.VARCHAR );
		statement.registerOutParameter(23, Types.VARCHAR );
		statement.registerOutParameter(24 ,Types.VARCHAR );
		statement.registerOutParameter(25 ,Types.VARCHAR );
		statement.registerOutParameter(26 ,Types.VARCHAR );
		statement.registerOutParameter(27 ,Types.VARCHAR );
		statement.registerOutParameter(28 ,Types.VARCHAR );
		statement.registerOutParameter(29 ,Types.VARCHAR );
		statement.registerOutParameter(30 ,Types.VARCHAR );
		statement.registerOutParameter(31 ,Types.VARCHAR );
		statement.registerOutParameter(32 ,Types.VARCHAR );
		statement.registerOutParameter(33 ,Types.VARCHAR );
		
		/*
		statement.registerOutParameter(13, Types.CLOB );
		statement.registerOutParameter(14, Types.CLOB );
		statement.registerOutParameter(15, Types.CLOB );
		statement.registerOutParameter(16, Types.CLOB );
		statement.registerOutParameter(17, Types.CLOB );
		statement.registerOutParameter(18, Types.CLOB );
		statement.registerOutParameter(19, Types.CLOB );
		statement.registerOutParameter(20, Types.CLOB );
		statement.registerOutParameter(21, Types.CLOB );
		statement.registerOutParameter(22, Types.CLOB );
		statement.registerOutParameter(23, Types.CLOB );
		statement.registerOutParameter(24 ,Types.CLOB );
		statement.registerOutParameter(25 ,Types.CLOB );
		statement.registerOutParameter(26 ,Types.CLOB );
		statement.registerOutParameter(27 ,Types.CLOB );
		statement.registerOutParameter(28 ,Types.INTEGER );
		statement.registerOutParameter(29 ,Types.INTEGER);
		statement.registerOutParameter(30 ,Types.INTEGER );
		statement.registerOutParameter(31 ,Types.INTEGER );
		statement.registerOutParameter(32 ,Types.CLOB );
		statement.registerOutParameter(33 ,Types.CLOB );	
		*/
		statement.setString( 34, locale);

		statement.registerOutParameter(35 ,Types.VARCHAR );
		statement.registerOutParameter(36 ,Types.VARCHAR );
		statement.registerOutParameter(37 ,Types.VARCHAR );
		statement.registerOutParameter(38 ,Types.VARCHAR );
		statement.registerOutParameter(39 ,Types.VARCHAR );
		statement.registerOutParameter(40 ,Types.VARCHAR );
		statement.registerOutParameter(41 ,Types.VARCHAR );
		/*
		statement.registerOutParameter(35 ,Types.CLOB );
		statement.registerOutParameter(36 ,Types.CLOB );
		statement.registerOutParameter(37 ,Types.CLOB );
		statement.registerOutParameter(38 ,Types.CLOB );
		statement.registerOutParameter(39 ,Types.CLOB );
		statement.registerOutParameter(40 ,Types.CLOB );
		*/

		statement.execute() ;

		System.err.println("After execute get_day_status---in Param---facilityid-->"+facilityid+"  date-->"+date+"  clinic_code-->"+clinic_code+"  practitioner_id-->"+practitioner_id+"  clinic_type1-->"+clinic_type1+"  res_type1-->"+res_type1);
		System.err.println("After execute get_day_status---in Param---facilityid-->"+facilityid+"  date1-->"+date1+"  clinic_code2-->"+clinic_code2+"  practitioner_id2-->"+practitioner_id2+"  clinic_type2-->"+clinic_type2+"  res_type2-->"+res_type2);

		P_O_CLINIC=statement.getString( 7 ); if(P_O_CLINIC == null) P_O_CLINIC="";
		P_O_PRACTITIONER=statement.getString( 8 ); if(P_O_PRACTITIONER == null) P_O_PRACTITIONER="";
		P_O_MAX_PAT=statement.getString( 9 ); if(P_O_MAX_PAT == null) P_O_MAX_PAT="";
		P_O_MAX_OVER_BOOK     =statement.getString( 10 );        if(P_O_MAX_OVER_BOOK==null) P_O_MAX_OVER_BOOK="";
		P_O_BOOKED                 =statement.getString(11 );   if( P_O_BOOKED ==null) P_O_BOOKED="";
		P_O_OVER_BOOKED        =statement.getString( 12 );    if(  P_O_OVER_BOOKED ==null) P_O_OVER_BOOKED="";
		P_O_OVER_BOOKING         =statement.getString( 13 );     if(P_O_OVER_BOOKING == null) P_O_OVER_BOOKING="";
		P_O_TIME_TAB_TYPE          =statement.getString( 14 );   
		P_O_STATUS                    =statement.getString(15);
		P_O_FROM_TIME            =statement.getString( 16 );     if(P_O_FROM_TIME == null) P_O_FROM_TIME="";
		P_O_TO_TIME                   =statement.getString( 17 );	if(P_O_TO_TIME == null) P_O_TO_TIME="";
		P_O_APPT_REF_NO         =statement.getString(18 );      if(P_O_APPT_REF_NO ==null) P_O_APPT_REF_NO="";
		P_O_PATIENT_NAME        =statement.getString( 19 );      if(P_O_PATIENT_NAME ==null) P_O_PATIENT_NAME="";
		P_O_AGE                       =statement.getString( 20 );		if(P_O_AGE ==null) P_O_AGE="";
		P_O_GENDER                    =statement.getString( 21 );	if(P_O_GENDER ==null) P_O_GENDER="";
		P_O_REASON_FOR_CON    =statement.getString( 22 );        if(P_O_REASON_FOR_CON ==null) P_O_REASON_FOR_CON="";
		P_O_VISIT_TYPE                =statement.getString( 23 );		if(P_O_VISIT_TYPE ==null) P_O_VISIT_TYPE="";
		P_O_CONTACT       =statement.getString( 24 );		if(P_O_CONTACT == null) P_O_CONTACT="";
		P_O_END_TIME = statement.getString(25); if( P_O_END_TIME == null) P_O_END_TIME="";
		P_O_VISIT_TYPE_IND = statement.getString(26); if( P_O_VISIT_TYPE_IND == null) P_O_VISIT_TYPE_IND="";
		P_O_NO_OF_SLOTS = statement.getString(27); if( P_O_NO_OF_SLOTS == null) P_O_NO_OF_SLOTS="";
		P_O_Max_Forced=statement.getString(28); if( P_O_Max_Forced == null) P_O_Max_Forced="";
		P_O_Total_Forced=statement.getString(29); if( P_O_Total_Forced == null) P_O_Total_Forced="";
		P_O_Max_Global=statement.getString(30); if( P_O_Max_Global == null) P_O_Max_Global="";
		P_O_Total_Global=statement.getString(31); if( P_O_Total_Global == null) P_O_Total_Global="";
		P_O_PATIENT_ID=statement.getString(32); if( P_O_PATIENT_ID == null) P_O_PATIENT_ID="";
		P_LAST_APPT_BOOKED= statement.getString(33);	if( P_LAST_APPT_BOOKED == null) P_LAST_APPT_BOOKED=""; //Added for this CRF Bru-CRF-177
		P_O_VISIT_TYPE_CODE = statement.getString(35);	if( P_O_VISIT_TYPE_CODE == null) P_O_VISIT_TYPE_CODE=""; //Added for this CRF Bru-CRF-177
		P_APPT_OTH_DTL= statement.getString(40); if( P_APPT_OTH_DTL == null) P_APPT_OTH_DTL="";
		P_O_pat_cat= statement.getString(41); if( P_O_pat_cat == null) P_O_pat_cat="";

		}

		System.err.println("P_O_CLINIC-------->"+P_O_CLINIC);
		System.err.println("P_O_PRACTITIONER-------->"+P_O_PRACTITIONER);
		System.err.println("P_O_MAX_PAT-------->"+P_O_MAX_PAT);
		System.err.println("P_O_MAX_OVER_BOOK-------->"+P_O_MAX_OVER_BOOK);
		System.err.println("P_O_BOOKED-------->"+P_O_BOOKED);
		System.err.println("P_O_OVER_BOOKED-------->"+P_O_OVER_BOOKED);
		System.err.println("P_O_OVER_BOOKING-------->"+P_O_OVER_BOOKING);
		System.err.println("P_O_TIME_TAB_TYPE-------->"+P_O_TIME_TAB_TYPE);
		System.err.println("P_O_STATUS-------->"+P_O_STATUS);
		System.err.println("P_O_FROM_TIME-------->"+P_O_FROM_TIME);
		System.err.println("P_O_TO_TIME-------->"+P_O_TO_TIME);
		System.err.println("P_O_APPT_REF_NO-------->"+P_O_APPT_REF_NO);
		System.err.println("P_O_PATIENT_NAME-------->"+P_O_PATIENT_NAME);
		System.err.println("P_O_AGE-------->"+P_O_AGE);
		System.err.println("P_O_GENDER-------->"+P_O_GENDER);
		System.err.println("P_O_REASON_FOR_CON-------->"+P_O_REASON_FOR_CON);
		System.err.println("P_O_VISIT_TYPE-------->"+P_O_VISIT_TYPE);
		System.err.println("P_O_CONTACT-------->"+P_O_CONTACT);	
		System.err.println("P_O_END_TIME-------->"+P_O_END_TIME);
		System.err.println("P_O_VISIT_TYPE_IND-------->"+P_O_VISIT_TYPE_IND);
		System.err.println("P_O_NO_OF_SLOTS-------->"+P_O_NO_OF_SLOTS);
		System.err.println("P_O_Max_Forced-------->"+P_O_Max_Forced);
		System.err.println("P_O_Total_Forced-------->"+P_O_Total_Forced);
		System.err.println("P_O_Max_Global-------->"+P_O_Max_Global);
		System.err.println("P_O_Total_Global-------->"+P_O_Total_Global);
		System.err.println("P_O_PATIENT_ID-------->"+P_O_PATIENT_ID);
		System.err.println("P_LAST_APPT_BOOKED-------->"+P_LAST_APPT_BOOKED);
		System.err.println("P_O_VISIT_TYPE_CODE-------->"+P_O_VISIT_TYPE_CODE);
		System.err.println("P_APPT_OTH_DTL-------->"+P_APPT_OTH_DTL);
		System.err.println("P_O_pat_cat-------->"+P_O_pat_cat);

		StringTokenizer token = new StringTokenizer(P_O_FROM_TIME, "|");
		int counter=token.countTokens();          
			
			String from_time[]=new String[counter];
			int track=0;
			while (token.hasMoreTokens())
				{
				from_time[track]=token.nextToken();
				track++;
				}
			
			token=null;
			track=0;
			token = new StringTokenizer(P_O_TO_TIME, "|");			
			String to_time[]=new String[counter];
			String end_time ="";
			int tot_token= token.countTokens();

			while (token.hasMoreTokens())
			{
				end_time=token.nextToken();

				if(schedule_extend_yn.equals("Y") && P_O_TIME_TAB_TYPE.equals("1")) { // to handle last slot for extended

					if (tot_token-track == 1) {					
						end_time="00:00";
					}
				}
				
				to_time[track]=end_time;

				track++;
			}

			token=null;
			track=0;
			token = new StringTokenizer(P_O_PATIENT_NAME, "|");
			String patient_name[]=new String[counter];
			while (token.hasMoreTokens())
				{
				patient_name[track]=token.nextToken();
				track++;
				}				
			
			token=null;
			track=0;
			token = new StringTokenizer(P_O_PATIENT_ID, "|");
			String patient_id[]=new String[counter];
			while (token.hasMoreTokens())
				{
				patient_id[track]=token.nextToken();
				track++;
				}

			token=null;
			track=0;
			token = new StringTokenizer(P_O_REASON_FOR_CON, "|") ;
			String reason_for_contact[]=new String[counter];
			while (token.hasMoreTokens())
				{
				reason_for_contact[track]=token.nextToken();
				track++;
				}		
				
			token=null;
			track=0;
			token = new StringTokenizer(P_O_VISIT_TYPE, "|");		
			String visit_type[]=new String[counter];
			while (token.hasMoreTokens())
				{
				visit_type[track]=token.nextToken();
				track++;
				}	

			token=null;
			track=0;
			token = new StringTokenizer(P_O_APPT_REF_NO, "|");
			String o_appt_ref_no[]=new String[counter];
			while (token.hasMoreTokens())
			{
			o_appt_ref_no[track]=token.nextToken();
			track++;
			}		
			


			token=null;
			track=0;

			token = new StringTokenizer(P_APPT_OTH_DTL, "|");
			String appt_ot_dtl[]=new String[counter];
			
			while (token.hasMoreTokens())
			{
			appt_ot_dtl[track]=token.nextToken();
			track++;
			}

			token=null;
			track=0;

			token = new StringTokenizer(P_O_STATUS, "|");
			String status[]=new String[counter];
			String status1[]=new String[counter];
			while (token.hasMoreTokens())
			{
			status[track]=token.nextToken();
			status1[track]=status[track];
			track++;
			}

			token=null;
			track=0;
			token = new StringTokenizer(P_O_VISIT_TYPE_IND, "|");
			String visit_type_ind[]=new String[counter];
			while (token.hasMoreTokens())
			{
			visit_type_ind[track]=token.nextToken();
			track++;
			}

			token=null;
			track=0;
			token = new StringTokenizer(P_O_NO_OF_SLOTS, "|");
			String no_of_slots[]=new String[counter];
			while (token.hasMoreTokens())
			{
			no_of_slots[track]=token.nextToken();
			track++;
			}	

            //Added for this CRF Bru-CRF-177
			
			token=null;
			track=0;
			token = new StringTokenizer(P_LAST_APPT_BOOKED, "|");
			String last_appt_booked[]=new String[counter];
			while (token.hasMoreTokens())
			{
			last_appt_booked[track]=token.nextToken();
			track++;
			}
			
			token=null;
			track=0;
			
			token = new StringTokenizer(P_O_VISIT_TYPE_CODE, "|");			
			String visit_type_code[]=new String[counter];
			
			while (token.hasMoreTokens())
			{
				visit_type_code[track]=token.nextToken();
				track++;
			}

            //End Bru-CRF-177			

			token=null;
			track=0;
			token = new StringTokenizer(P_O_pat_cat, "|");
			String pat_cat[]=new String[counter];
			while (token.hasMoreTokens())
			{
				pat_cat[track]=token.nextToken();
				track++;
			}
	
	if(mode_find !=null && mode_find.equals("revise"))
	{
		if(date !=null && date.equals(old_date))
		{
			allow_revise=true;
		}
		else{
		if(max_patient!=0)
		{
			if(max_patient==total_booked)
			{
				if(tfr_appt_across_catg_yn!=null && tfr_appt_across_catg_yn.equalsIgnoreCase("N"))
				{
					allow_revise=false;
					
            _bw.write(_wl_block70Bytes, _wl_block70);
}
				else{
            _bw.write(_wl_block71Bytes, _wl_block71);
allow_revise=true;
				}
			}
		}
		else
		{
		allow_revise=true;
		}
	}//END OF ELSE
}//END OF REVISE


if(allow_revise)
{
            _bw.write(_wl_block72Bytes, _wl_block72);
	

 /*Below Code Added for this CRF [Bru-HIMS-CRF-177] */  
 java.util.HashMap hm=eMP.ChangePatientDetails.getColorCode(con,facilityid); 			
		
int maxval=0; String appt_ref_assign_value="";
for (int maxchk = 0; maxchk < o_appt_ref_no.length; maxchk++) 
{
   appt_ref_assign_value=o_appt_ref_no[maxchk];   
   if(!appt_ref_assign_value.equals("~")){
       while(Integer.parseInt(appt_ref_assign_value)>maxval)
       { 
          maxval=Integer.parseInt(appt_ref_assign_value);
       }
   } 
}

// End [Bru-HIMS-CRF-177] 

String classValue="";
int slots = 0;
String same_appt = "N";
String pat_name = "";
for(int init=0;init<counter;init++)
{
	/*Added by Thamizh selvi on 11th July 2018 against ML-MMOH-CRF-1058 Start*/
	if(isIncRemarksLengthAppl && !o_appt_ref_no[init].equals(""))
		apptRemarks		= eOA.OACommonBean.getApptRemarks(con,facilityid,o_appt_ref_no[init]);	
	/*End*/
same_appt = "N";

if( !(no_of_slots[init].equals("~")) && (Integer.parseInt(no_of_slots[init]) > 1) ) 
{
	slots = Integer.parseInt(no_of_slots[init]);
	pat_name = patient_name[init];
}

if ( init % 2 == 0 )
		classValue = "OAQRYEVEN" ;
			else
		classValue = "OAQRYODD" ;

            _bw.write(_wl_block73Bytes, _wl_block73);


String u=from_time[init];
String z=status[init];
String z1=status1[init];

String reason ="";
String reason1=z.substring(0,2);
if( z.length() > 2)
	reason=z.substring(2,z.length());
else
	reason="";
z=reason1;
if( ! u .equals("~")) 
		{
		String chk_blank_row_patient=patient_name[init];
		if(z.equals("FL") || z.equals("OL") || z.equals("VL")||z.equals("VT")){		 
		
			if(!(mode_find.equals("revise")) || mode_find.equals("")){
				
					if(chk_blank_row_patient.equals("~")){ 
						if(book_appt_yn.equalsIgnoreCase("Y")){
						if(slots > 0)
							{
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(u));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(init));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(init));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block79Bytes, _wl_block79);
slots--;
								same_appt = "Y";
							}
							else
							{
                             if (z.equals("VT"))
							 {
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(u));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(init));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(init));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block81Bytes, _wl_block81);
}
							 else
							{
								if (z.equals("FL")&&(!normal_booking_allow_flag)){
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(u));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(init));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(init));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block79Bytes, _wl_block79);
}else{
									if(blkStatus.equals("B")){
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(blkRemark));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(u));
            _bw.write(_wl_block86Bytes, _wl_block86);
}else{
										if(P_O_TIME_TAB_TYPE.equals("2")&& groupApptYN.equals("Y") && groupCnt>0 && callingMode.equals("") && (from_page.equals("") || from_page.equals("schedule_appt"))){
											
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(u));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(init));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(init));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block90Bytes, _wl_block90);

										}else{
										
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(u));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(init));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(init));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block90Bytes, _wl_block90);
}}
								}

							 }

							}
						}
						else if(book_appt_yn!=null && book_appt_yn.equalsIgnoreCase("N")){
							if (z.equals("FL")&&(!normal_booking_allow_flag)){
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf( u));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(init));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(init));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block93Bytes, _wl_block93);
}else{
								if(blkStatus.equals("B")){
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(blkRemark));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(u));
            _bw.write(_wl_block95Bytes, _wl_block95);
}else{
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(u));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(init));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(init));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block79Bytes, _wl_block79);
}
							}
						}
					}
					else{
                    if(z.equals("VT"))
					{
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(u));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(init));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(init));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block99Bytes, _wl_block99);
}
					else
					{
					if (z.equals("FL")&&(!normal_booking_allow_flag)){
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf( u));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(init));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(init));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block99Bytes, _wl_block99);
}else{
						if(blkStatus.equals("B")){
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(blkRemark));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(u));
            _bw.write(_wl_block102Bytes, _wl_block102);
}else{
            _bw.write(_wl_block103Bytes, _wl_block103);
if(z1.equals("OL*F")){
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(u));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(init));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(init));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block105Bytes, _wl_block105);
}else if(z1.equals("OL*")){
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(u));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(init));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(init));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block108Bytes, _wl_block108);
}else if(z1.equals("OL*M")){
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(u));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(init));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(init));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block111Bytes, _wl_block111);
}else{
            _bw.write(_wl_block112Bytes, _wl_block112);
if(z.equals("VL")){
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(u));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(init));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(init));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block114Bytes, _wl_block114);
}else{
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(u));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(init));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(init));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block116Bytes, _wl_block116);
}
            _bw.write(_wl_block117Bytes, _wl_block117);
}
            _bw.write(_wl_block118Bytes, _wl_block118);
}
					}

					}
					pat_name = patient_name[init];
					slots--;
					}
			}
			else{
					if(chk_blank_row_patient.equals("~")){
						if (z.equals("FL")&&(!normal_booking_allow_flag)){
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf( u));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(init));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(init));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block120Bytes, _wl_block120);
}else{
							if(blkStatus.equals("B")){
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(blkRemark));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(u));
            _bw.write(_wl_block122Bytes, _wl_block122);
}else{
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf( u));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(init));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(init));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block93Bytes, _wl_block93);
}
						}
					}
					else{
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(u));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(init));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(init));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block99Bytes, _wl_block99);

					}
		   }
		}
		else if(z.equals("RN")){
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(reason));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(u));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(init));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(init));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block126Bytes, _wl_block126);
}	

		else if(z.equals("BN")){
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(reason));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf( u));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(init));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(init));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block126Bytes, _wl_block126);
}	

		else{
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf( u));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(init));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(init));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block129Bytes, _wl_block129);
}
		}
		else{
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(init));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(init));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block126Bytes, _wl_block126);

		}

String u1=to_time[init];

//Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112
if(u1.equals("00:00")){
	u1 = "23:59";
}

if( ! u1 .equals("~")){
	if(z.equals("FL") || z.equals("OL") || z.equals("VL") || z.equals("FN")||z.equals("VT")){
		if(blkStatus.equals("B")){
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(blkRemark));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf( u1));
            _bw.write(_wl_block133Bytes, _wl_block133);
}else{
            _bw.write(_wl_block134Bytes, _wl_block134);
if(z1.equals("OL*F")){
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(u1));
            _bw.write(_wl_block136Bytes, _wl_block136);
}else{
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(u1));
            _bw.write(_wl_block136Bytes, _wl_block136);
}
            _bw.write(_wl_block138Bytes, _wl_block138);
}
            _bw.write(_wl_block13Bytes, _wl_block13);
}else{
		if (z.equals("RN")){
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(reason));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf( u1));
            _bw.write(_wl_block133Bytes, _wl_block133);
}else{
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(reason));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(u1));
            _bw.write(_wl_block133Bytes, _wl_block133);
}
	}
}else{
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block142Bytes, _wl_block142);
}



String u2=patient_name[init];
String pat_id=patient_id[init];
if(pat_id.equals("~"))
	pat_id="";
else
	pat_id=pat_id+" , ";

	if( ! u2 .equals("~")){
		if(z.equals("FL") || z.equals("OL") || z.equals("VL") || z.equals("FN")||z.equals("VT")){
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(pat_id));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(u2));
 if(pat_cat[init].equals("V")){
            _bw.write(_wl_block145Bytes, _wl_block145);
}
            _bw.write(_wl_block133Bytes, _wl_block133);
}else{
			if(same_appt.equals("Y")){
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block147Bytes, _wl_block147);
}else{
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(reason));
            _bw.write(_wl_block149Bytes, _wl_block149);
}
		}
	}else{
		if(same_appt.equals("Y")){
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(pat_name));
            _bw.write(_wl_block133Bytes, _wl_block133);
}	else{
			if(z.equals("BN")){
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block85Bytes, _wl_block85);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(reason));
            _bw.write(_wl_block152Bytes, _wl_block152);
}else{
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block149Bytes, _wl_block149);
}
			
		}
	}
		

	String u6=visit_type[init];
	if( ! u6 .equals("~"))
		{
			if(z.equals("FL") || z.equals("OL") || z.equals("VL") || z.equals("FN")||z.equals("VT")){
			
			// Below Line Added for this CRF [Bru-HIMS-CRF-177] 		
		   String retval=checkForNull(visit_type_code[init]);		   
		 
		   colour_indicator =(String)hm.get(retval);
			
			 //End [Bru-HIMS-CRF-177] 
			
			
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(colour_indicator));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf( u6));
            _bw.write(_wl_block136Bytes, _wl_block136);
}
			else{
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(reason));
            _bw.write(_wl_block149Bytes, _wl_block149);
}
			}
		else{
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block159Bytes, _wl_block159);
}

/*Below line added for this CRF GH-CRF-0414*/
String visit_ind_code=checkForNull(visit_type_ind[init]);
String visit_type_indcator="";
	if( ! visit_ind_code.equals("~"))
		{
		  /*Below line added for this CRF GHL-CRF-0414*/            
			if(visit_ind_code.equals("F"))
			visit_type_indcator=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.first.label","common_labels");
			if(visit_ind_code.equals("L"))
			visit_type_indcator=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.followup.label","common_labels");
			if(visit_ind_code.equals("R"))
			visit_type_indcator=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
			if(visit_ind_code.equals("E"))
			visit_type_indcator=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
			if(visit_ind_code.equals("S"))
			visit_type_indcator=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Series.label","common_labels");
			if(visit_ind_code.equals("C"))
			visit_type_indcator=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ReferralfoConsult.label","op_labels");
	       //End GHL-CRF-0414 
		
		
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(visit_type_indcator));
            _bw.write(_wl_block161Bytes, _wl_block161);
}else{
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block159Bytes, _wl_block159);
}
/*End GHL-CRF-0414*/

	String u5=reason_for_contact[init];
	if( ! u5 .equals("~"))
		{
		if(z.equals("FL") || z.equals("OL") || z.equals("VL") || z.equals("FN")||z.equals("VT")){
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(u5));
            _bw.write(_wl_block133Bytes, _wl_block133);
}
		else{
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(reason));
            _bw.write(_wl_block159Bytes, _wl_block159);
}
		}
		else{
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block159Bytes, _wl_block159);
}

	String tmp_ref_no=o_appt_ref_no[init];
	String oth_dtls=appt_ot_dtl[init];

	int sec_cnt=0;
	if(tmp_ref_no.equals("~")) tmp_ref_no="";

	StringTokenizer tmp_oth_dtl = new StringTokenizer(oth_dtls, "*");
	while (tmp_oth_dtl.hasMoreTokens())	{
		sec_cnt=Integer.parseInt(tmp_oth_dtl.nextToken());
		tmp_oth_dtl.nextToken();
		tmp_oth_dtl.nextToken();		
	}
	


	/*if(!tmp_ref_no.equals("")){
		sql="select count(appt_ref_no) count from oa_resource_for_appt where appt_ref_no = '"+tmp_ref_no+"' and FACILITY_ID='"+facilityid+"'";
			out.println("sec cnt sql " + sql);
			
		rs=stmtsd.executeQuery(sql);
		if ( rs != null && rs.next()){	
			sec_cnt=rs.getInt("count");	
		}
	}
	if(rs !=null) rs.close();
	*/
	
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block166Bytes, _wl_block166);
if(sec_cnt>0){
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(tmp_ref_no));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block168Bytes, _wl_block168);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block169Bytes, _wl_block169);
}
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block171Bytes, _wl_block171);
if(!tmp_ref_no.equals("") && order_clinic_count>0){
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(z));
            _bw.write(_wl_block168Bytes, _wl_block168);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block173Bytes, _wl_block173);
}else{ 
            _bw.write(_wl_block43Bytes, _wl_block43);
} 
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(init));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(init));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block176Bytes, _wl_block176);
 if(isIncRemarksLengthAppl){ 
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block171Bytes, _wl_block171);
if(!("").equals(apptRemarks)){
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block179Bytes, _wl_block179);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block173Bytes, _wl_block173);
 }else{ 
            _bw.write(_wl_block43Bytes, _wl_block43);
} 
            _bw.write(_wl_block180Bytes, _wl_block180);
 } 
            _bw.write(_wl_block181Bytes, _wl_block181);
}	
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf( clinic_code ));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(P_O_CLINIC ));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(practitioner_id ));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(P_O_OBVISIT_FLAG));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(P_O_PRACTITIONER ));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(date ));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(date1));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(P_O_OVER_BOOKING ));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(over_booked_label));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(P_O_TIME_TAB_TYPE));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(current_date));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf( current_time ));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf( value13));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf( clinic_code2 ));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(practitioner_id2 ));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(old_clinic));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(old_practitioner ));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(P_O_END_TIME));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(old_date));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(old_from_time));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(old_to_time));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(book_appt_yn));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(book_appt_wo_pid_yn));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(obook_appt_yn));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(book_appt_across_catg_yn));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(tfr_appt_yn));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(tfr_appt_across_catg_yn));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(canc_appt_yn));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(ca_mode));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(ca_patient_id));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(date1));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(P_O_Max_Forced));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(P_O_Total_Forced));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(P_O_Max_Global));
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(P_O_Total_Global));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(clinic_type1));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(res_type1));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(clinic_type2));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(res_type2));
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(clinic_type3));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(res_type3));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(or_catalogue_code));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(alcn_criteria));
            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(slot_appt_ctrl));
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(visit_limit_rule));
            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf(override_no_of_slots_yn));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(callingMode));
            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf(req_id));
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(install_yn_val));
            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf(value_chk));
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(P_O_MAX_PAT));
            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf(value12));
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(visit_flag_OP));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(capture_fin_dtls_yn));
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(from_page));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(ref_id));
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(FORCED_BOOK_APPT_YN));
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf(GLOBAL_BOOK_APPT_YN));
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf(create_wait_list_yn));
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(min_ela_per_resc_noshow_in_day));
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(noshow_ctrl_by_splty_or_clinic));
            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(contact_num_reqd_yn));
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(no_of_noshow_appts_for_alert));
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(per_chk_for_no_show_alert));
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(global_locn_yn));
            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(from_facility_id));
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(from_encounter_id));
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf(rd_appt_yn));
            _bw.write(_wl_block254Bytes, _wl_block254);
            out.print( String.valueOf(max_patients_per_slab));
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(isIncRemarksLengthAppl));
            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf(p_o_ext_slot_status));
            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(p_o_reserved_slot_dtls));
            _bw.write(_wl_block258Bytes, _wl_block258);
            out.print( String.valueOf(p_o_appt_slot_dtls));
            _bw.write(_wl_block259Bytes, _wl_block259);
            out.print( String.valueOf(p_o_block_slot_dtls));
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(p_o_break_slot_dtls));
            _bw.write(_wl_block261Bytes, _wl_block261);
            out.print( String.valueOf(isSlotStartMidEndAppl));
            _bw.write(_wl_block262Bytes, _wl_block262);
String calling_mode2=request.getParameter("callingMode");
if(calling_mode2==null) calling_mode2="N";
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.print( String.valueOf(calling_mode2));
            _bw.write(_wl_block264Bytes, _wl_block264);
            out.print( String.valueOf(pre_pat_alcn_catg_code));
            _bw.write(_wl_block265Bytes, _wl_block265);
 
	}
	if (rs != null) rs.close();
	//if (stmtsd != null) stmtsd.close();
	if (statement != null) statement.close();
	//if (stmtn !=null) stmtn.close();
	if(pstmt_access !=null)pstmt_access.close();
	if(pstmt_label !=null)pstmt_label.close();
	if (cstmt != null) cstmt.close();
	if (statement_bru != null) statement_bru.close();

}catch(Exception e) {
	e.printStackTrace();
}
finally
{
	
	ConnectionManager.returnConnection(con,request);
}

} catch(Exception e){
	e.printStackTrace();
 }



            _bw.write(_wl_block266Bytes, _wl_block266);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.Allocation.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.Allocation.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.overbooking.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Slot.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patient.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.FV.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.OV.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.OB.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.Global.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.Forced.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.NormalReschedule.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.count.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.BulkReschedule.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.count.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.maximum.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.booked.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.fromtime.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.totime.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.visittype.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Visit.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.INDICATOR.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReasonForContact.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.SecondaryResources.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Order.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Selection.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.block.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reason.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.details.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Order.label", java.lang.String .class,"key"));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Detail.label", java.lang.String .class,"key"));
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
}
