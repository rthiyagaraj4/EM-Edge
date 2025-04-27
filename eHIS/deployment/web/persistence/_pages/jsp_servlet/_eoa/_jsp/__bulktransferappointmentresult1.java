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
import eCommon.XSSRequestWrapper;

public final class __bulktransferappointmentresult1 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/BulkTransferAppointmentResult1.jsp", 1729083060314L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n     \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n\t<script language=\"javascript\" src=\"../../eOA/js/BulkTransferAppointment.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"> </script>\n\n\t ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n<link rel=\'stylesheet\' type=\'text/css\'  href=\'../../eCommon/html/CommonCalendar.css\'></link>\n    <Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n\t<script src=\'../../eCommon/js/CommonLookup.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t </head>\n\t\t <script>\nfunction scrollheader()\n{\n  var x = document.body.scrollTop;\n\n  if(x == 0){\n\t \n   \n    document.getElementById(\"head1\").style.position=\'static\';\n   document.getElementById(\"head1\").style.posTop  = 0;\n   document.getElementById(\"head2\").style.position=\'static\';\n   document.getElementById(\"head2\").style.posTop  = 0;\n   document.getElementById(\"head3\").style.position=\'static\';\n   document.getElementById(\"head3\").style.posTop  = 0;\n     document.getElementById(\"head4\").style.position=\'static\';\n   document.getElementById(\"head4\").style.posTop  = 0;\n     document.getElementById(\"head5\").style.position=\'static\';\n   document.getElementById(\"head5\").style.posTop  = 0;\n     document.getElementById(\"head6\").style.position=\'static\';\n   document.getElementById(\"head6\").style.posTop  = 0;\n \n\n   }else{\n\t\n\tdocument.getElementById(\"head1\").style.position = \'relative\';\n\tdocument.getElementById(\"head1\").style.posTop  = x-2;\n\tdocument.getElementById(\"head2\").style.position = \'relative\';\n\tdocument.getElementById(\"head2\").style.posTop  = x-2;\n\tdocument.getElementById(\"head3\").style.position = \'relative\';\n\tdocument.getElementById(\"head3\").style.posTop  = x-2;\n\tdocument.getElementById(\"head4\").style.position = \'relative\';\n\tdocument.getElementById(\"head4\").style.posTop  = x-2;\n\tdocument.getElementById(\"head5\").style.position = \'relative\';\n\tdocument.getElementById(\"head5\").style.posTop  = x-2;\n\tdocument.getElementById(\"head6\").style.position = \'relative\';\n\tdocument.getElementById(\"head6\").style.posTop  = x-2;\n\n\t\n\t }\n}\t\n</script>\n<body OnMouseDown=\'CodeArrest();\'onKeyDown = \'lockKey()\' onscroll=\"scrollheader()\">\n<form name=\"bulktransferapptresult1\" id=\"bulktransferapptresult1\">\n\t<table border=\"1\" width=\"100%\" cellspacing=\'0\'  cellpadding=\'0\' id=\'results1\'>\n\n\n<tr>\n\t\t\n\t\t\t<th class=\'COLUMNHEADER\' ><div  id=\'head1\' class=\'myClass\' style=\'height:50px\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</div></th>\n\t\t\t<th class=\'COLUMNHEADER\'  ><div  id=\'head2\' width=\'12%\' class=\'myClass\' style=\'height:50px\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</div></th>\n\t\t\t<th class=\'COLUMNHEADER\' ><div  id=\'head3\'  class=\'myClass\' style=\'height:50px\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</div></th>\n\t\t\t<th class=\'COLUMNHEADER\'  ><div  id=\'head4\' width=\'12%\' class=\'myClass\' style=\'height:50px\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</div></th>\n\t\t\t<th class=\'COLUMNHEADER\' ><div  id=\'head5\' class=\'myClass\' style=\'height:50px\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</div></th>\n\t\t\t<th class=\'COLUMNHEADER\' ><div  id=\'head6\' class=\'myClass\' style=\'height:50px\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</div></th>\n</tr>\n\n\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\t\n\t\t\t\t\t\t<script>alert(getMessage(\'APPT_CAN_NOT_TRANS_OTH_CAT\',\'OA\'));</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t<script>alert(getMessage(\'APPT_TRANS_OTH_CAT\',\'OA\'));</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\n\n<tr>\n\n\n\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t<td width=\"10%\" ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" class=\'OARED\' title=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t\t\t<td width=\"10%\" ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" class=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" >";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="<input type=\'hidden\' name=\'o_appt_ref_no\' name=\'o_appt_ref_no";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' id=\'o_appt_ref_no";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' ></td>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="  class=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' ></td>\n\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t\t\t\t\t\t<td width=\"10%\" ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</td>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t\t\t\t\t\t<td width=\"10%\" ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" >\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =" <input type=\'hidden\'  name=\'o_appt_ref_no";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' ></td>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t\t\t   <td width=\"10%\" ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' ></td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<td width=\"10%\" ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</td>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t  \t\t\t\t\t\t<td width=\"10%\" ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="<input type=\'hidden\'  name=\'o_appt_ref_no";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' ></td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\"<input type=\'hidden\' name=\'o_appt_ref_no\' name=\'o_appt_ref_no";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' ></td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<td width=\"10%\" ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 =" class=\'OAFORCED\'  Title=\'Forced Appointment\'>";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="<input type=\'hidden\' name=\'o_appt_ref_no";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t<td width=\"10%\" ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =" <input type=\'hidden\' name=\'o_appt_ref_no\' name=\'o_appt_ref_no";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' ></td>\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\t\n\t\t\t\t\t\t\t\t\t\t<td width=\'10%\' ";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 =" <input type=\'hidden\' name=\'o_appt_ref_no";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\' ></td>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t\t\t\t<td width=\"10%\" ";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\' > </td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<td width=\"10%\" ";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t\t\t<td width=\"10%\" ";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\' ></td>\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t<td width=\"10%\" ";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 =" class=\'oablock\'>\n\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t\n\t\t\t\t<input type=\'hidden\' name=\'o_appt_ref_no\' name=\'o_appt_ref_no";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\' ></td>\n\t\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t\t\t\n\t\t\t\t\t<td width=\"10%\" ";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="  class=\'oared\'  title =\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\">\n\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 =" \n\t\t\t\t\n\t\t\t\t\t<input type=\'hidden\' name=\'o_appt_ref_no\' name=\'o_appt_ref_no";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\' ></td>\n\t\t\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t\t\t<td width=\"10%\" ";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t<td width=\"10%\" ";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">&nbsp; <input type=\'hidden\' name=\'o_appt_ref_no\' name=\'o_appt_ref_no";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\' ></td>\n\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\n\t\t\t<td width=\"11%\" ";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 =" class=\"OARED\" title=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="</td>\n\t\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t\t";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t\t\t<td width=\"11%\" ";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 =" class=\"OAFORCED\" Title=\"Forced Appointment\">";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="</td>\n\t\t\t";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t\t\n\t\t\t\t\t<td width=\"11%\" ";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="</td>\n\t\t\t\t\n\n\t\t\t";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\n\t\t";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t\t<td width=\"11%\" ";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 =" class=\'oablock\'>";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="</td>\n\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t\n\t\t<td width=\"11%\" ";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 =" class=\'OARED\'  title =\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n\t<td width=\"11%\" ";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\">&nbsp;</td>\n";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\t\t\t<td width=\'23%\' ";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="&nbsp;";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="&nbsp;,";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t\t\t\t<td width=\'23%\' ";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\">***</td>\n\t\t\t";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\t\t\t\t\n\t\t\t\t<td width=\'23%\' ";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 =" class=\'OARED\'>&nbsp;</td>\n\t\t\t";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\t\t\t\t<td width=\'23%\' class=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 =":&nbsp;<b>";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="</b></td>\n\t\t\t";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\t\t\t\t \n\t\t\t\t<td width=\'23%\' class=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\">&nbsp;</td>\n\t\t\t";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 =" \n\t\t<td width=\'12%\' ";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="  style=\"background-color:";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 =";FONT-SIZE:8pt;\">";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="&nbsp;</td>\n\t\t";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\n\t\t\t<td width=\'13%\' ";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\t\t\t\n\t\t\t<td width=\'13%\' class=\"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\">&nbsp;</td>\n\t\t";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\n\t\t<td width=\'14%\' class=\"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\">\n<a href=\"javascript:show_Reference_details_results(\'";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\',\'";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\')\">\n\t\t\t";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\n\t\t</a>&nbsp;</td>\n\t";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\n\t\t<td width=\'13%\' class=\"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\">&nbsp;</td>\n\t";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\n</tr>\n";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\n<input type=\'hidden\' name=\'counter\' id=\'counter\' value=";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 =">\n<input type=\'hidden\' name=\'locn_type\' id=\'locn_type\' value=";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 =">\n<input type=\'hidden\' name=\'from_locn\' id=\'from_locn\' value=";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 =">\n<input type=\'hidden\' name=\'from_res_class\' id=\'from_res_class\' value=";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 =">\n<input type=\'hidden\' name=\'from_resc\' id=\'from_resc\' value=";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 =">\n<input type=\'hidden\' name=\'from_booked_normal_slots\' id=\'from_booked_normal_slots\' value=";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 =">\n<input type=\'hidden\' name=\'from_blocked_slots\' id=\'from_blocked_slots\' value=";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 =">\n<input type=\'hidden\' name=\'from_booked_over_slots\' id=\'from_booked_over_slots\' value=";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 =">\n<input type=\'hidden\' name=\'from_max_slots\' id=\'from_max_slots\' value=\'";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\'>\n<input type=\'hidden\' name=\'Max_Forced\' id=\'Max_Forced\' value=\'";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\'>\n<input type=\'hidden\' name=\'Total_Forced\' id=\'Total_Forced\' value=\'";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\'>\n<input type=\'hidden\' name=\'no_of_normal_first_visits\' id=\'no_of_normal_first_visits\' value=\'";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\'>\n<input type=\'hidden\' name=\'no_of_normal_other_visits\' id=\'no_of_normal_other_visits\' value=\'";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\'>\n<input type=\'hidden\' name=\'no_of_overbooked_first_visits\' id=\'no_of_overbooked_first_visits\' value=\'";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\'>\n<input type=\'hidden\' name=\'no_of_overbooked_other_visits\' id=\'no_of_overbooked_other_visits\' value=\'";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\'>\n\n<!-- Added for ML-BRU-CRF-0628.1 -->\n<input type=\"hidden\" name=\"p_o_ext_slot_status\" id=\"p_o_ext_slot_status\" value=\"";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\">\n<input type=\"hidden\" name=\"p_o_reserved_slot_dtls\" id=\"p_o_reserved_slot_dtls\" value=\"";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\">\n<input type=\"hidden\" name=\"p_o_appt_slot_dtls\" id=\"p_o_appt_slot_dtls\" value=\"";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\">\n<input type=\"hidden\" name=\"p_o_block_slot_dtls\" id=\"p_o_block_slot_dtls\" value=\"";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\">\n<input type=\"hidden\" name=\"p_o_break_slot_dtls\" id=\"p_o_break_slot_dtls\" value=\"";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\">\n<input type=\"hidden\" name=\"isSlotStartMidEndAppl\" id=\"isSlotStartMidEndAppl\" value=\"";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\">\n<!-- End ML-BRU-CRF-0628.1 -->\n\n</form>\n<script>\n\t\n/* Added for ML-BRU-CRF-0628.1 */\nif (document.forms[0].isSlotStartMidEndAppl.value==\'true\'){\n\n\tvar ext_slt=document.forms[0].p_o_ext_slot_status.value;\n\tvar res_slt=document.forms[0].p_o_reserved_slot_dtls.value;\n\tvar appt_slt=document.forms[0].p_o_appt_slot_dtls.value;\n\tvar blk_slt=document.forms[0].p_o_block_slot_dtls.value;\n\tvar brk_slt=document.forms[0].p_o_break_slot_dtls.value;\n\n\n\tvar ext_slot_arr=ext_slt.split(\"|\");\n\tvar res_slot_arr=res_slt.split(\"|\");\n\tvar appt_slot_arr=appt_slt.split(\"|\");\n\tvar blk_slot_arr=blk_slt.split(\"|\");\n\tvar brk_slot_arr=brk_slt.split(\"|\");\n\n\n\tfor(var i=0;i<=ext_slot_arr.length;i++){\n\t\t\n\t\tif(ext_slot_arr[i]==\'Y\') {\n\n\t\t\tif(blk_slot_arr[i]==\'N\' && brk_slot_arr[i]==\'N\') {\n\t\t\t\tif(res_slot_arr[i] !=\'N\'){\n\t\t\t\t\n\t\t\t\t\tdocument.getElementById(\"results1\").rows(i+1).cells(0).style.backgroundColor = \"Bisque\";\n\t\t\t\t\tdocument.getElementById(\"results1\").rows(i+1).cells(1).style.backgroundColor = \"Bisque\";\n\t\t\t\t\tdocument.getElementById(\"results1\").rows(i+1).cells(0).style.Color = \"Black\";\n\t\t\t\t\tdocument.getElementById(\"results1\").rows(i+1).cells(1).style.Color = \"Black\";\n\t\t\t\t\tdocument.getElementById(\"results1\").rows(i+1).cells(2).style.backgroundColor = \"Bisque\";\n\t\t\t\t\tdocument.getElementById(\"results1\").rows(i+1).cells(2).innerText = \"BRU Health Reservation : \"+res_slot_arr[i];\n\n\t\t\t\t}else {\n\t\t\t\t\tdocument.getElementById(\"results1\").rows(i+1).cells(0).style.backgroundColor = \"Bisque\";\n\t\t\t\t\tdocument.getElementById(\"results1\").rows(i+1).cells(1).style.backgroundColor = \"Bisque\";\n\t\t\t\t}\n\t\t\t}\n\n\t\t\t\n\t\t}\n\t\t\t\n\t}\n}\n/* End ML-BRU-CRF-0628.1 */\n</script>\n\n";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\n</body>\n</html>\n";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );


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
            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection con = null;
	Statement stmt = null; 
	PreparedStatement pstmt=null;
	CallableStatement statement=null;
	CallableStatement cstmt = null;
	CallableStatement statement_bru = null;
	PreparedStatement pstmt_label = null;
	ResultSet rs32 = null;
	ResultSet rsps=null;
	ResultSet rs=null;
	String fac_id    	= (String) session.getValue( "facility_id" ) ;

	//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
	Boolean isSlotStartMidEndAppl = false;
	String p_o_ext_slot_status = "";
	String p_o_reserved_slot_dtls = "";
	String p_o_appt_slot_dtls = "";
	String p_o_block_slot_dtls = "";
	String p_o_break_slot_dtls = "";
	String max_patients_per_slab = "";
	String P_O_MAX_FORCED_BOOK = "";
	String P_O_FORCED_BOOK = "";
	String P_O_MAX_GLOBAL_BOOK = "";
	String P_O_GLOBAL_BOOK = "";

try{
		con = ConnectionManager.getConnection(request);
		 stmt   	= con.createStatement() ;	

	isSlotStartMidEndAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "OA", "BRU_HEALTH_INTG");//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1

	String locale=(String)session.getAttribute("LOCALE");
	String curr_user_id=(String)session.getValue("login_user");
	String from_speciality = request.getParameter("from_speciality") ;
	if(from_speciality ==null) from_speciality="";
	String to_speciality = request.getParameter("to_speciality") ;
	if(to_speciality ==null) to_speciality="";
	String locn_type=request.getParameter("locn_type");
	if(locn_type ==null) locn_type="";
	String from_locn=request.getParameter("from_locn");
	if(from_locn ==null) from_locn="";
	String to_locn=request.getParameter("to_locn");
	if(to_locn ==null) to_locn="";
	String from_resc=request.getParameter("from_resc");
	if(from_resc ==null)from_resc="";
	String to_resc=request.getParameter("to_resc");
	if(to_resc ==null) to_resc="";
	String from_date=request.getParameter("from_date");
	if(from_date ==null) from_date="";
	String to_date=request.getParameter("to_date");
	if(to_date ==null) to_date="";
	String from_res_class=request.getParameter("from_res_class");
	if(from_res_class ==null) from_res_class="";
	String to_res_class=request.getParameter("to_res_class");
	if(to_res_class ==null) to_res_class="";
	String oper_stn=request.getParameter("oper_stn");
	if(oper_stn ==null) oper_stn="";
	String visit_limit_rule=request.getParameter("visit_limit_rule");
	if(visit_limit_rule ==null) visit_limit_rule="N";
	PreparedStatement stmtps=null;
	int max_patient			=0;
	int total_booked		=0;
	int block_count=0;
	boolean normal_booking_allow_flag = true;
	boolean allow_revise=true;
	ArrayList arrLst=new ArrayList();
String holdArr[]=new String[5];
String P_O_CLINIC="",P_O_PRACTITIONER="",P_O_MAX_PAT="",P_O_MAX_OVER_BOOK="",P_O_BOOKED="",P_O_OVER_BOOKED="",P_O_OVER_BOOKING="N",P_O_TIME_TAB_TYPE="",P_O_STATUS="",P_O_FROM_TIME="",P_O_TO_TIME="",P_O_APPT_REF_NO="",P_O_PATIENT_NAME="",tmp_Hld_var="",P_O_END_TIME="",P_O_VISIT_TYPE_IND="",P_O_NO_OF_SLOTS="",P_O_Max_Forced="",P_O_Total_Forced="",P_O_Max_Global="",P_O_Total_Global="",P_O_PATIENT_ID="",book_appt_yn="",book_appt_wo_pid_yn="",obook_appt_yn="",book_appt_across_catg_yn="",tfr_appt_yn="",tfr_appt_across_catg_yn="",canc_appt_yn="",FORCED_BOOK_APPT_YN="",GLOBAL_BOOK_APPT_YN="",mode_find="";
String P_APPT_OTH_DTL       ="";


/*Below variable Added for this CRF [Bru-HIMS-CRF-177]*/
String P_O_VISIT_TYPE_CODE ="", colour_indicator="";


String blkStatus="";
String blkRemark="";
String nowarp1 ="";



            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);


		/* Added for ML-BRU-CRF-0628.1 */
		if(isSlotStartMidEndAppl){
			cstmt = con.prepareCall("{call oa_external_slots_BRU(?,?,?,?,?,?,?,?,?)}");
			cstmt.setString( 1, fac_id );
			cstmt.setString( 2, from_locn );
			cstmt.setString( 3, from_resc );
			cstmt.setString( 4, from_date );
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
		
		if(isSlotStartMidEndAppl){
			
			StringBuffer sql_label = new StringBuffer();

			sql_label.append("select time_table_type, max_patients_per_slab, max_patients_per_day, nvl(max_over_booking,0) max_over_booking, nvl(total_slots_booked,0) total_slots_booked, nvl(total_slots_overbooked,0)total_slots_overbooked, to_char(end_time,'hh24:mi')end_time, nvl(MAX_FORCED_IN_BOOKING,0)MAX_FORCED_IN_BOOKING, nvl(TOTAL_FORCED_IN_BOOKED,0)TOTAL_FORCED_IN_BOOKED, nvl(MAX_GLOBAL_BOOKING,0)MAX_GLOBAL_BOOKING, nvl(TOTAL_GLOBAL_BOOKED,0)TOTAL_GLOBAL_BOOKED from oa_clinic_schedule where facility_id=? and clinic_date  =to_date(?,'dd/mm/yyyy') and clinic_code=?  and care_locn_type_ind =? and resource_class=? and ");

			if(from_resc.equals("")){
				sql_label.append("practitioner_id is null ");
			}else{
				sql_label.append("practitioner_id = ?");
			}

			pstmt_label = con.prepareStatement(sql_label.toString());

			pstmt_label.setString(1,fac_id);
			pstmt_label.setString(2,from_date);
			pstmt_label.setString(3,from_locn);
			pstmt_label.setString(4,locn_type);
			pstmt_label.setString(5,from_res_class);
			if(!from_resc.equals("")){
				pstmt_label.setString(6,from_resc);
			}

			rs32 = pstmt_label.executeQuery();
			sql_label=null;

			if( rs32 !=null && rs32.next() ){

				P_O_TIME_TAB_TYPE = rs32.getString("time_table_type" );   

				max_patients_per_slab = rs32.getString("max_patients_per_slab");
				if(max_patients_per_slab==null) max_patients_per_slab="";

				P_O_MAX_PAT = rs32.getString("max_patients_per_day");
				if(P_O_MAX_PAT==null) P_O_MAX_PAT="";

				P_O_MAX_OVER_BOOK = rs32.getString("max_over_booking" );        
				if(P_O_MAX_OVER_BOOK==null) P_O_MAX_OVER_BOOK="";

				P_O_BOOKED = rs32.getString("total_slots_booked" );   
				if(P_O_BOOKED ==null) P_O_BOOKED="";

				P_O_OVER_BOOKED = rs32.getString( "total_slots_overbooked" );    
				if(P_O_OVER_BOOKED ==null) P_O_OVER_BOOKED="";

				P_O_END_TIME = rs32.getString("end_time"); 
				if( P_O_END_TIME == null) P_O_END_TIME="";	

				P_O_MAX_FORCED_BOOK = rs32.getString("MAX_FORCED_IN_BOOKING");
				if(P_O_MAX_FORCED_BOOK==null)P_O_MAX_FORCED_BOOK="";

				P_O_FORCED_BOOK	= rs32.getString("TOTAL_FORCED_IN_BOOKED");
				if(P_O_FORCED_BOOK==null)P_O_FORCED_BOOK="";

				P_O_MAX_GLOBAL_BOOK = rs32.getString("MAX_GLOBAL_BOOKING");
				if(P_O_MAX_GLOBAL_BOOK==null)P_O_MAX_GLOBAL_BOOK="";

				P_O_GLOBAL_BOOK	= rs32.getString("TOTAL_GLOBAL_BOOKED");
				if(P_O_GLOBAL_BOOK==null)P_O_GLOBAL_BOOK="";
			}
		}

		if(isSlotStartMidEndAppl && P_O_TIME_TAB_TYPE.equals("2") && !max_patients_per_slab.equals("1")){

			System.err.println("Before execute oa_slabs_BRU---in Param---fac_id-->"+fac_id+"  from_locn-->"+from_locn+"  from_resc-->"+from_resc+"  from_date-->"+from_date);

			statement_bru = con.prepareCall("{call oa_slabs_BRU(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			statement_bru.setString( 1, fac_id);
			statement_bru.setString( 2, from_locn);
			statement_bru.setString( 3, from_resc);
			statement_bru.setString( 4, from_date);
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

		

			P_O_CLINIC = from_locn;

			P_O_PRACTITIONER = from_resc;

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

			tmp_Hld_var = statement_bru.getString(9); 
			if( tmp_Hld_var == null) tmp_Hld_var="";
			holdArr[0]=tmp_Hld_var;

			tmp_Hld_var = statement_bru.getString(10); 
			if( tmp_Hld_var == null) tmp_Hld_var="";
			holdArr[1]=tmp_Hld_var;

			tmp_Hld_var = statement_bru.getString(12); 
			if( tmp_Hld_var == null) tmp_Hld_var="";
			holdArr[2]=tmp_Hld_var;

			tmp_Hld_var = statement_bru.getString(17); 
			if( tmp_Hld_var == null) tmp_Hld_var="";
			holdArr[3]=tmp_Hld_var;

			tmp_Hld_var = statement_bru.getString(13); 
			if( tmp_Hld_var == null) tmp_Hld_var="";
			holdArr[4]=tmp_Hld_var;

			P_O_VISIT_TYPE_IND = statement_bru.getString(14); 
			if( P_O_VISIT_TYPE_IND == null) P_O_VISIT_TYPE_IND="";

			P_O_PATIENT_ID = statement_bru.getString(15); 
			if( P_O_PATIENT_ID == null) P_O_PATIENT_ID="";

			P_O_VISIT_TYPE_CODE = statement_bru.getString(11); 
			if( P_O_VISIT_TYPE_CODE == null) P_O_VISIT_TYPE_CODE="";

			P_APPT_OTH_DTL = statement_bru.getString(22); 
			if( P_APPT_OTH_DTL == null) P_APPT_OTH_DTL="";

			P_O_FROM_TIME = statement_bru.getString(24);     
			if(P_O_FROM_TIME == null) P_O_FROM_TIME="";

			P_O_TO_TIME = statement_bru.getString(25);	
			if(P_O_TO_TIME == null) P_O_TO_TIME="";

			P_O_NO_OF_SLOTS = statement_bru.getString(26); 
			if( P_O_NO_OF_SLOTS == null) P_O_NO_OF_SLOTS="";

		}else{
		/* End ML-BRU-CRF-0628.1 */

		System.err.println("Before execute get_day_status---in Param---fac_id-->"+fac_id+"  from_locn-->"+from_locn+"  from_resc-->"+from_resc+"  from_date-->"+from_date);

		statement=con.prepareCall("{call oa_schedules.get_day_status( ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

		
		statement.setString( 1, fac_id);
		statement.setString( 2, from_date);
		statement.setString( 3, from_locn);
		statement.setString( 4, from_resc);
		statement.setString( 5, locn_type);
		statement.setString( 6, from_res_class);

	
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

	System.err.println("After execute get_day_status---in Param---fac_id-->"+fac_id+"  from_locn-->"+from_locn+"  from_resc-->"+from_resc+"  from_date-->"+from_date);

	P_O_CLINIC=statement.getString( 7 ); if(P_O_CLINIC == null) P_O_CLINIC="";
	P_O_PRACTITIONER=statement.getString( 8 ); if(P_O_PRACTITIONER == null) P_O_PRACTITIONER="";
	P_O_MAX_PAT=statement.getString( 9 ); if(P_O_MAX_PAT == null) P_O_MAX_PAT="";
	P_O_MAX_OVER_BOOK     =statement.getString( 10 );        if(P_O_MAX_OVER_BOOK==null) P_O_MAX_OVER_BOOK="";
	P_O_BOOKED                 =statement.getString(11 );   if( P_O_BOOKED ==null) P_O_BOOKED="";
	P_O_OVER_BOOKED        =statement.getString( 12 );    if(  P_O_OVER_BOOKED ==null) P_O_OVER_BOOKED="";
	P_O_OVER_BOOKING        =statement.getString( 13 );     if(P_O_OVER_BOOKING == null) 	P_O_OVER_BOOKING="";
	P_O_TIME_TAB_TYPE          =statement.getString( 14 );if(P_O_TIME_TAB_TYPE == null) P_O_TIME_TAB_TYPE="";
	P_O_STATUS                    =statement.getString(15);if(P_O_STATUS == null) P_O_STATUS="";
	P_O_FROM_TIME            =statement.getString( 16 );     if(P_O_FROM_TIME == null) P_O_FROM_TIME="";
	P_O_TO_TIME              =statement.getString( 17 );	if(P_O_TO_TIME == null) P_O_TO_TIME="";
	P_O_APPT_REF_NO         =statement.getString(18 );      if(P_O_APPT_REF_NO ==null) P_O_APPT_REF_NO="";
	P_O_PATIENT_NAME        =statement.getString( 19 );      if(P_O_PATIENT_NAME ==null) P_O_PATIENT_NAME="";
	tmp_Hld_var                       =statement.getString( 20 );		if(tmp_Hld_var ==null) tmp_Hld_var="";
	holdArr[0]=tmp_Hld_var;
	tmp_Hld_var                    =statement.getString( 21 );	if(tmp_Hld_var ==null) tmp_Hld_var="";
	holdArr[1]=tmp_Hld_var;
	tmp_Hld_var    =statement.getString( 22 );        if(tmp_Hld_var ==null) tmp_Hld_var="";
	holdArr[2]=tmp_Hld_var;
	tmp_Hld_var                =statement.getString( 23 );		if(tmp_Hld_var ==null) tmp_Hld_var="";
	holdArr[3]=tmp_Hld_var;
	tmp_Hld_var       =statement.getString( 24 );		if(tmp_Hld_var == null) tmp_Hld_var="";
	holdArr[4]=tmp_Hld_var;
	P_O_END_TIME = statement.getString(25); if( P_O_END_TIME == null) P_O_END_TIME="";
	P_O_VISIT_TYPE_IND = statement.getString(26); if( P_O_VISIT_TYPE_IND == null) P_O_VISIT_TYPE_IND="";
	P_O_NO_OF_SLOTS = statement.getString(27); if( P_O_NO_OF_SLOTS == null) P_O_NO_OF_SLOTS="";

	P_O_Max_Forced=statement.getString(28); if( P_O_Max_Forced == null) P_O_Max_Forced="";
	P_O_Total_Forced=statement.getString(29); if( P_O_Total_Forced == null) P_O_Total_Forced="";

	P_O_Max_Global=statement.getString(30); if( P_O_Max_Global == null) P_O_Max_Global="";
	P_O_Total_Global=statement.getString(31); if( P_O_Total_Global == null) P_O_Total_Global="";

	P_O_PATIENT_ID=statement.getString(32); if( P_O_PATIENT_ID == null) P_O_PATIENT_ID="";	
	/*Below Line Added for this CRF [Bru-HIMS-CRF-177]*/
	P_O_VISIT_TYPE_CODE = statement.getString(35);
	if( P_O_VISIT_TYPE_CODE == null) P_O_VISIT_TYPE_CODE="";	
	//End[Bru-HIMS-CRF-177]

	P_APPT_OTH_DTL= statement.getString(40); if( P_APPT_OTH_DTL == null) P_APPT_OTH_DTL="";
	
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
	System.err.println("holdArr[0]-------->"+holdArr[0]);
	System.err.println("holdArr[1]-------->"+holdArr[1]);
	System.err.println("holdArr[2]-------->"+holdArr[2]);
	System.err.println("holdArr[3]-------->"+holdArr[3]);
	System.err.println("holdArr[4]-------->"+holdArr[4]);	
	System.err.println("P_O_END_TIME-------->"+P_O_END_TIME);
	System.err.println("P_O_VISIT_TYPE_IND-------->"+P_O_VISIT_TYPE_IND);
	System.err.println("P_O_NO_OF_SLOTS-------->"+P_O_NO_OF_SLOTS);
	System.err.println("P_O_Max_Forced-------->"+P_O_Max_Forced);
	System.err.println("P_O_Total_Forced-------->"+P_O_Total_Forced);
	System.err.println("P_O_Max_Global-------->"+P_O_Max_Global);
	System.err.println("P_O_Total_Global-------->"+P_O_Total_Global);
	System.err.println("P_O_PATIENT_ID-------->"+P_O_PATIENT_ID);
	System.err.println("P_O_VISIT_TYPE_CODE-------->"+P_O_VISIT_TYPE_CODE);
	System.err.println("P_APPT_OTH_DTL-------->"+P_APPT_OTH_DTL);

			int no_of_normal_first_visits=0;
			int no_of_normal_other_visits=0;
			int no_of_overbooked_first_visits=0;
			int no_of_overbooked_other_visits=0;
			int no_of_non_overbooked_tokens=0; 
			int j=1;
			String next_token1="";
			String next_token2="";

			if(Integer.parseInt(P_O_OVER_BOOKED) > 0){
				StringTokenizer token1 = new StringTokenizer(P_O_VISIT_TYPE_IND, "|");
				StringTokenizer token2 = new StringTokenizer(P_O_NO_OF_SLOTS, "|");
				int counter=token1.countTokens();
				no_of_non_overbooked_tokens=counter - (Integer.parseInt(P_O_OVER_BOOKED));
				
				while(token1.hasMoreTokens()){	
					next_token1=token1.nextToken();
					next_token2=token2.nextToken();
					if(j <= no_of_non_overbooked_tokens){
						if(next_token1.equals("F")){
							if(Integer.parseInt(next_token2) > 1)
								no_of_normal_first_visits=no_of_normal_first_visits+Integer.parseInt(next_token2);
							else
								no_of_normal_first_visits++;
						}
						else if(!next_token1.equals("F") && !next_token1.equals("~")){
							if(Integer.parseInt(next_token2) > 1)
								no_of_normal_other_visits=no_of_normal_other_visits+Integer.parseInt(next_token2);
							else
								no_of_normal_other_visits++;
						}
					}
					else{
						if(next_token1.equals("F"))
							no_of_overbooked_first_visits++;
						else if(!next_token1.equals("F") && !next_token1.equals("~"))
							no_of_overbooked_other_visits++;					

					}
					j++;
				}				 
			}	
		


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
			while (token.hasMoreTokens())
				{
				to_time[track]=token.nextToken();
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
			for(int ij=0;ij<holdArr.length;ij++){
				token=null;
				track=0;
				String popArr[]=new String[counter];
				token = new StringTokenizer(holdArr[ij], "|");

				while (token.hasMoreTokens()){
					popArr[track]=token.nextToken();
					track++;
				}
				 arrLst.add(popArr);				 
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
			token = new StringTokenizer(P_O_NO_OF_SLOTS, "|");
			String no_of_slots[]=new String[counter];
			while (token.hasMoreTokens())
			{
			no_of_slots[track]=token.nextToken();
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
			
		/*Below Line Added for this CRF [Bru-HIMS-CRF-177]*/
			token=null;
			track=0;
			token = new StringTokenizer(P_O_VISIT_TYPE_CODE, "|");
			String visit_type_code[]=new String[counter];
			while (token.hasMoreTokens())
			{   
				visit_type_code[track]=token.nextToken();
				track++;
				
			}
		//End [Bru-HIMS-CRF-177]	
				
			
			

	//String sql_access="select book_appt_yn,book_appt_wo_pid_yn,obook_appt_yn,book_appt_across_catg_yn,tfr_appt_yn,tfr_appt_across_catg_yn,canc_appt_yn,FORCED_BOOK_APPT_YN,GLOBAL_BOOK_APPT_YN from am_os_user_locn_access_vw  where facility_id='"+fac_id+"' and locn_code='"+from_locn+"'  and oper_stn_id='"+oper_stn+"' and appl_user_id='"+curr_user_id+"' and (book_appt_yn='Y' or book_appt_wo_pid_yn='Y' or obook_appt_yn='Y' or book_appt_across_catg_yn='Y' or tfr_appt_yn='Y' or tfr_appt_across_catg_yn='Y' or canc_appt_yn='Y') ";
	String sql_access="select book_appt_yn,book_appt_wo_pid_yn,obook_appt_yn,book_appt_across_catg_yn,tfr_appt_yn,tfr_appt_across_catg_yn,canc_appt_yn,FORCED_BOOK_APPT_YN,GLOBAL_BOOK_APPT_YN from am_os_user_locn_access_vw  where facility_id=? and locn_code=? and oper_stn_id=? and appl_user_id=? and (book_appt_yn='Y' or book_appt_wo_pid_yn='Y' or obook_appt_yn='Y' or book_appt_across_catg_yn='Y' or tfr_appt_yn='Y' or tfr_appt_across_catg_yn='Y' or canc_appt_yn='Y') ";

		//rs = stmt.executeQuery(sql_access);
		pstmt = con.prepareStatement(sql_access);
		pstmt.setString(1,fac_id);
		pstmt.setString(2,from_locn);
		pstmt.setString(3,oper_stn);
		pstmt.setString(4,curr_user_id);
		rs = pstmt.executeQuery();
	
			if(rs !=null){
			while ( rs.next() )
			{
						book_appt_yn= rs.getString("book_appt_yn");
						if(book_appt_yn ==null) book_appt_yn="";
						book_appt_wo_pid_yn= rs.getString("book_appt_wo_pid_yn");
						if(book_appt_wo_pid_yn==null) book_appt_wo_pid_yn="";
						obook_appt_yn= rs.getString("obook_appt_yn");
						if(obook_appt_yn ==null) obook_appt_yn="";
						book_appt_across_catg_yn= rs.getString("book_appt_across_catg_yn");
						if(book_appt_across_catg_yn ==null) book_appt_across_catg_yn="";
						tfr_appt_yn= rs.getString("tfr_appt_yn");
						if(tfr_appt_yn==null) tfr_appt_yn="";
						tfr_appt_across_catg_yn= rs.getString("tfr_appt_across_catg_yn");
						if(tfr_appt_across_catg_yn ==null) tfr_appt_across_catg_yn="";
						canc_appt_yn= rs.getString("canc_appt_yn");
						if(canc_appt_yn ==null) canc_appt_yn="";
						FORCED_BOOK_APPT_YN= rs.getString("FORCED_BOOK_APPT_YN");
						if(FORCED_BOOK_APPT_YN ==null) FORCED_BOOK_APPT_YN="";
						GLOBAL_BOOK_APPT_YN = rs.getString("GLOBAL_BOOK_APPT_YN");
						if(GLOBAL_BOOK_APPT_YN ==null) GLOBAL_BOOK_APPT_YN="";
			}
			}
		if(rs !=null) rs.close();

		if(mode_find !=null && mode_find.equals("revise")){
			
				if(max_patient!=0){
				if(max_patient==total_booked){
					if(tfr_appt_across_catg_yn!=null && tfr_appt_across_catg_yn.equalsIgnoreCase("N")){
					allow_revise=false;
					
            _bw.write(_wl_block16Bytes, _wl_block16);

					}
					else{
            _bw.write(_wl_block17Bytes, _wl_block17);
allow_revise=true;
					}
				}
				}
				else
				{
				allow_revise=true;
				}
		}
		if(allow_revise){

	/*Below Code Added for this CRF [Bru-HIMS-CRF-177] */   
        java.util.HashMap hm=eMP.ChangePatientDetails.getColorCode(con,fac_id);			
       // End [Bru-HIMS-CRF-177] 		


String classValue="";
int slots = 0;
String same_appt = "N";
String pat_name = "";
for(int init=0;init<counter;init++)
{

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



            _bw.write(_wl_block18Bytes, _wl_block18);

String u=from_time[init];
String z=status[init];
String z1=status1[init];
String u1=to_time[init];

//Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112
if(u1.equals("00:00")){
	u1 = "23:59";
}

String reason ="";
String reason1=z.substring(0,2);
if( z.length() > 2)
	reason=z.substring(2,z.length());
else
	reason="";
z=reason1;



String chk_blank_row_patient=patient_name[init];

	if( ! u .equals("~")) //u represents from_time
	{
		
	if(z.equals("FL") || z.equals("OL") || z.equals("VL")||z.equals("VT"))
		{
		
			if(!(mode_find.equals("revise")) || mode_find.equals(""))
			{
			
				if(chk_blank_row_patient.equals("~"))
					{ 
					
						if(book_appt_yn.equalsIgnoreCase("Y"))
						{
							if(slots > 0)
							{
								
            _bw.write(_wl_block19Bytes, _wl_block19);
if(blkStatus.equals("B")){
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(blkRemark));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(u));
            _bw.write(_wl_block23Bytes, _wl_block23);
}else{
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(u));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(init));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(init));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block30Bytes, _wl_block30);
}
            _bw.write(_wl_block19Bytes, _wl_block19);
slots--;
								same_appt = "Y";
							}
							else
							{
					          if (z.equals("VT"))
								{
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(u));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(init));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(init));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block32Bytes, _wl_block32);
}
							   else{
								    if (z.equals("FL")&&(!normal_booking_allow_flag)){
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(u));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(init));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(init));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block30Bytes, _wl_block30);
}
									else{
										if(blkStatus.equals("B")){
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(blkRemark));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(u));
            _bw.write(_wl_block34Bytes, _wl_block34);
}else{
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(u));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(init));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(init));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block38Bytes, _wl_block38);
}
									}
								   
							   }
							}
						}
						else 
						{
							if(book_appt_yn!=null && book_appt_yn.equalsIgnoreCase("N"))
							{ 
								if (z.equals("FL")&&(!normal_booking_allow_flag)){
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(u));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(init));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(init));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block40Bytes, _wl_block40);
}else{
									if(blkStatus.equals("B")){
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(blkRemark));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(u));
            _bw.write(_wl_block42Bytes, _wl_block42);
}else{
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(u));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(init));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(init));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block30Bytes, _wl_block30);
}
								}
							}
						}
					}
					else
					{
                      if (z.equals("VT"))
						{
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(u));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(init));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(init));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block45Bytes, _wl_block45);
}
					  else
						{
							if (z.equals("FL")&&(!normal_booking_allow_flag)){
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(u));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(init));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(init));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block47Bytes, _wl_block47);
}else{
								if(blkStatus.equals("B")){
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(blkRemark));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(u));
            _bw.write(_wl_block49Bytes, _wl_block49);
}else{
            _bw.write(_wl_block50Bytes, _wl_block50);
if(z1.equals("OL*F")){
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(u));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(init));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(init));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block30Bytes, _wl_block30);
}else if(z1.equals("OL*")){
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(u));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(init));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(init));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block55Bytes, _wl_block55);
}else if(z1.equals("OL*M")){
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(u));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(init));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(init));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block58Bytes, _wl_block58);
}else{
            _bw.write(_wl_block59Bytes, _wl_block59);
if(z.equals("VL")){
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(u));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(init));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(init));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block38Bytes, _wl_block38);
}else{
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(u));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(init));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(init));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block38Bytes, _wl_block38);
}
            _bw.write(_wl_block60Bytes, _wl_block60);
}
            _bw.write(_wl_block19Bytes, _wl_block19);
}
							}
						}
						pat_name = patient_name[init];
						slots--;
					}
			}
			else
			{
					if(chk_blank_row_patient.equals("~"))
					{
						if (z.equals("FL")&&(!normal_booking_allow_flag)){
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf( u));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(init));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(init));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block62Bytes, _wl_block62);
}else{
							if(blkStatus.equals("B")){
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(blkRemark));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(u));
            _bw.write(_wl_block64Bytes, _wl_block64);
}else{
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf( u));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(init));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(init));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block47Bytes, _wl_block47);
}
						}
					}
					else
					{
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf( u));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(init));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(init));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block66Bytes, _wl_block66);
}
		   	}
		}
		else 
		{
			if(z.equals("RN"))
			{
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(u));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(init));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(init));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block70Bytes, _wl_block70);
}	
			else
			{
				if(z.equals("BN"))
				{
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(reason));
            _bw.write(_wl_block73Bytes, _wl_block73);
block_count++;
            out.print( String.valueOf( u));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(init));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(init));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block75Bytes, _wl_block75);
}	
				else
				{
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf( u));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(init));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(init));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block75Bytes, _wl_block75);
}
			}
		}
	}
	else
	{
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(init));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(init));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block79Bytes, _wl_block79);
}

if( ! u1 .equals("~"))
{
	if(z.equals("FL") || z.equals("OL") || z.equals("VL") || z.equals("FN")||z.equals("VT"))
	{
		if(blkStatus.equals("B")){
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(blkRemark));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(u1));
            _bw.write(_wl_block82Bytes, _wl_block82);
}else{
            _bw.write(_wl_block83Bytes, _wl_block83);
if(z1.equals("OL*F")){
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(u1));
            _bw.write(_wl_block86Bytes, _wl_block86);
}else{
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(u1));
            _bw.write(_wl_block88Bytes, _wl_block88);
}
            _bw.write(_wl_block89Bytes, _wl_block89);
}
            _bw.write(_wl_block90Bytes, _wl_block90);
}
	else
	if(z.equals("RN"))
	{
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(u1));
            _bw.write(_wl_block93Bytes, _wl_block93);
}
	else
	if(z.equals("BN"))
	{
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(reason));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(u1));
            _bw.write(_wl_block93Bytes, _wl_block93);
}
}
else{
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block97Bytes, _wl_block97);
}

String dispArr2[]=(String []) arrLst.get(1);

String u32=dispArr2[init];



String u2=patient_name[init];
String pat_id=patient_id[init];
if(pat_id.equals("~"))
	pat_id="";
else
	pat_id=pat_id+" , ";
	if( ! u2 .equals("~")){
		if(z.equals("FL") || z.equals("OL") || z.equals("VL") || z.equals("FN")||z.equals("VT")){
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(pat_id));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(u2));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(u32));
            _bw.write(_wl_block82Bytes, _wl_block82);
}else	{
			if(same_appt.equals("Y")){
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block102Bytes, _wl_block102);
}else{
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block104Bytes, _wl_block104);
}
		}
	}else{
		if(same_appt.equals("Y")){
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(pat_name));
            _bw.write(_wl_block82Bytes, _wl_block82);
}	else{
			if(z.equals("BN")){
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block99Bytes, _wl_block99);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(reason));
            _bw.write(_wl_block107Bytes, _wl_block107);
}else{
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block109Bytes, _wl_block109);
}
			
		}
	}	
	

// code opt by Jith
for(int kkk=3;kkk<arrLst.size();kkk++){
	int kkk1=0;
	if(kkk==3){
		kkk1=3;
	}else if(kkk==4) {
		kkk1=2;
	}else{
		kkk1=kkk;
	}
	
	String dispArr[]=(String []) arrLst.get(kkk1);

	String u3=dispArr[init];
	if( ! u3 .equals("~"))	{
		if(z.equals("FL") || z.equals("OL") || z.equals("VL") || z.equals("FN")|| z.equals("VT")){
		// Below "IF" conditions Added for this CRF [Bru-HIMS-CRF-177] 
		     if(kkk1==3){	              		   
		      String vist_code=checkForNull(visit_type_code[init]);
              colour_indicator =checkForNull((String)hm.get(vist_code));      	 
		
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(colour_indicator));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf( u3));
            _bw.write(_wl_block113Bytes, _wl_block113);
}if(kkk1==2){	
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(u3));
            _bw.write(_wl_block113Bytes, _wl_block113);
}		
		}else{
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block116Bytes, _wl_block116);
}
	}else
	{
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block116Bytes, _wl_block116);

	}
}
// end JIth
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
	String sql="select count(appt_ref_no) count from oa_resource_for_appt where appt_ref_no = '"+tmp_ref_no+"' and FACILITY_ID='"+fac_id+"'";
		out.println("sec cnt sql " + sql);
		stmtps=con.prepareStatement(sql);
		rsps=stmtps.executeQuery();
		if ( rsps != null && rsps.next()){	
				sec_cnt=rsps.getInt("count");	
			
		}
}
out.println("sec cnt  " + sec_cnt);

if (stmtps !=null) stmtps.close();
if (rsps !=null) rsps.close();
*/

            _bw.write(_wl_block90Bytes, _wl_block90);
if(sec_cnt>0){
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(tmp_ref_no));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(fac_id));
            _bw.write(_wl_block120Bytes, _wl_block120);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block121Bytes, _wl_block121);
}else{
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block123Bytes, _wl_block123);
}
            _bw.write(_wl_block2Bytes, _wl_block2);


if (stmtps !=null) stmtps.close();
if (rsps !=null) rsps.close();
            _bw.write(_wl_block124Bytes, _wl_block124);

}
}

            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(locn_type));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(from_locn));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(from_res_class));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(from_resc));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(P_O_BOOKED));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(block_count));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(P_O_OVER_BOOKED));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(P_O_MAX_PAT));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(P_O_Max_Forced));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(P_O_Total_Forced));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(no_of_normal_first_visits));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(no_of_normal_other_visits));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(no_of_overbooked_first_visits));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(no_of_overbooked_other_visits));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(p_o_ext_slot_status));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(p_o_reserved_slot_dtls));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(p_o_appt_slot_dtls));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(p_o_block_slot_dtls));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(p_o_break_slot_dtls));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(isSlotStartMidEndAppl));
            _bw.write(_wl_block146Bytes, _wl_block146);

	if(stmt !=null) stmt.close();
	if (statement != null) statement.close();
	if(rs !=null) rs.close();
	if (cstmt != null) cstmt.close();
	if (pstmt_label != null) pstmt_label.close();
	if (rs32 != null) rs32.close();
	if (statement_bru != null) statement_bru.close();


}catch(Exception es){
	//out.println("Exception in querycriteria"+ es.toString());
	es.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally { 
	ConnectionManager.returnConnection(con,request);
}		

            _bw.write(_wl_block147Bytes, _wl_block147);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.fromtime.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.totime.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.visittype.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReasonForContact.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.SecondaryResources.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.blocked.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reason.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.details.label", java.lang.String .class,"key"));
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
