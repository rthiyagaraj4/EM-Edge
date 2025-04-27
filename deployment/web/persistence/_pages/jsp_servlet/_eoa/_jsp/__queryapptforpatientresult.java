package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import webbeans.eCommon.ConnectionManager;
import com.ehis.util.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __queryapptforpatientresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/QueryApptForPatientResult.jsp", 1729080708954L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<HTML>\n\t<head>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<title>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</title>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<script src=\"../../eOP/js/menu.js\" language=\"JavaScript1.2\"></script>\n\t<script src=\"../../eOA/js/QueryApptForPatient.js\"></script>\n\n\n\t ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'></link>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></SCRIPT>\n\t<script src=\"../../eCommon/js/common.js\"></script>\n\t\n\t<script>\n\n\t</script>\n\t</head>\n\t<body OnMouseDown=\'CodeArrest();\' onKeyDown = \'lockKey()\'>\n\t<form name=\'QueryApptForPatient\' id=\'QueryApptForPatient\'>\n\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t<P>\n\t\t\t<table align=\'right\' >\n\t\t\t<tr>\n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t<td align =\'right\' id=\'prev\'><A HREF=\'../../eOA/jsp/QueryApptForPatientResult.jsp?appt_ref_no=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&patientid=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&patcat_code=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&function_id=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&cliniccode=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&care_locn=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&resource_type=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&practcode=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&order=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&orderCriteria=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&apptfromdate=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&appttodate=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&facility=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&from=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&to=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="&whereclause=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="&speciality=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&MODULE_ID=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</A></td>\n\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t<td align =\'right\' id=\'next\' style=\'visibility:hidden\'><A HREF=\'../../eOA/jsp/QueryApptForPatientResult.jsp?appt_ref_no=";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="&patname=";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\n\n\n\n\n\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t</tr>\n\t\t\t</table><br>\n\t\t\t\t\t</P>\n\t\t<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\'>\n\n\t\t<td class=\'COLUMNHEADER\' nowrap onclick =\"sort(\'apptno\',\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\');\" style=\'cursor:pointer\' width=\'7%\' >";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="<img src=\'../../eAE/images/Ascending.gif\'  border=none  align=right name=\'apptnoGif\' style=\'visibility:hidden\'></td>\n\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t<td class=\'COLUMNHEADER\' nowrap onclick =\"sort(\'patientId\',\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\');\" style=\'cursor:pointer\' width=\'7%\'>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="<img src=\'../../eAE/images/Ascending.gif\'  border=none  align=right name=\'patientGif\' style=\'visibility:hidden\'></td>\n\t\t\t\t<td class=\'COLUMNHEADER\' nowrap onclick =\"sort(\'PatientName\',\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="<img src=\'../../eAE/images/Ascending.gif\'  border=none  align=right name=\'patnameGif\' style=\'visibility:hidden\'></td>\n\t\t\t\t<td class=\'COLUMNHEADER\' nowrap onclick =\"sort(\'gender\',\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="<img src=\'../../eAE/images/Ascending.gif\'  border=none  align=right name=\'genderGif\' style=\'visibility:hidden\'></td>\n\t\t\t\t<td class=\'COLUMNHEADER\' nowrap onclick =\"sort(\'age\',\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="<img src=\'../../eAE/images/Ascending.gif\'  border=none  align=right name=\'ageGif\' style=\'visibility:hidden\'></td>\n\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\n\t\t\t<td class=\'COLUMNHEADER\' nowrap onclick =\"sort(\'MobileNo\',\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="<img src=\'../../eAE/images/Ascending.gif\'  border=none  align=right name=\'mobileGif\' style=\'visibility:hidden\'></td>\n\t\t\t\n\t\t\t<td class=\'COLUMNHEADER\' nowrap  onclick =\"sort(\'Category\',\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="<img src=\'../../eAE/images/Ascending.gif\'  border=none  align=right name=\'catGip\' style=\'visibility:hidden\'></td>\t\n\t\t\t\n\t\t<td class=\'COLUMNHEADER\' nowrap onclick =\"sort(\'apptdate\',\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="<img src=\'../../eAE/images/Ascending.gif\'  border=none  align=right name=\'apptdateGif\' style=\'visibility:hidden\'></td>\n\t\t<td class=\'COLUMNHEADER\' nowrap onclick =\"sort(\'fromtime\',\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="<img src=\'../../eAE/images/Ascending.gif\'  border=none  align=right name=\'fromdateGif\' style=\'visibility:hidden\'></td>\n\t\t<td class=\'COLUMNHEADER\' nowrap onclick =\"sort(\'totime\',\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="<img src=\'../../eAE/images/Ascending.gif\'  border=none  align=right name=\'todateGif\' style=\'visibility:hidden\'></td>\n\t\t<td class=\'COLUMNHEADER\' nowrap onclick =\"sort(\'duration\',\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="<img src=\'../../eAE/images/Ascending.gif\'  border=none  align=right name=\'durationGif\' style=\'visibility:hidden\'></td>\n\t\t<td class=\'COLUMNHEADER\' nowrap onclick =\"sort(\'visittype\',\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="<img src=\'../../eAE/images/Ascending.gif\'  border=none  align=right name=\'visittypeGif\' style=\'visibility:hidden\'></td>\n\t\t<td class=\'COLUMNHEADER\' nowrap onclick =\"sort(\'Location\',\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="<img src=\'../../eAE/images/Ascending.gif\'  border=none  align=right name=\'locationGif\' style=\'visibility:hidden\'></td>\n\t\t<td class=\'COLUMNHEADER\' nowrap onclick =\"sort(\'resource\',\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="<img src=\'../../eAE/images/Ascending.gif\'  border=none  align=right name=\'resourceGif\' style=\'visibility:hidden\'></td>\n\t\t<td class=\'COLUMNHEADER\' nowrap onclick =\"sort(\'speciality\',\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="<img src=\'../../eAE/images/Ascending.gif\'  border=none  align=right name=\'specialityGif\' style=\'visibility:hidden\'></td>\n\t\t<td class=\'COLUMNHEADER\' nowrap onclick =\"sort(\'ordercatalog\',\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="<img src=\'../../eAE/images/Ascending.gif\'  border=none  align=right name=\'ordercatalogGif\' style=\'visibility:hidden\'> </td>\n\t\t<td class=\'COLUMNHEADER\' nowrap onclick =\"sort(\'referralid\',\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="<img src=\'../../eAE/images/Ascending.gif\'  border=none  align=right name=\'referralidGif\' style=\'visibility:hidden\'></td>\n\n\t\t<td class=\'COLUMNHEADER\' nowrap onclick =\"sort(\'patinstructions\',\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="<img src=\'../../eAE/images/Ascending.gif\'  border=none  align=right name=\'apptgnGif1\' style=\'visibility:hidden\'></td>\n\t\t\n\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t<td class=\'COLUMNHEADER\' nowrap style=\'cursor:pointer\' width=\'7%\'>Translator Override Reason<img src=\'../../eAE/images/Ascending.gif\'  border=none  align=right name=\'apptgnGif1\' style=\'visibility:hidden\'></td>\n\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\n\n\t\t<td class=\'COLUMNHEADER\' nowrap onclick =\"sort(\'ApptGivenBy\',\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="<img src=\'../../eAE/images/Ascending.gif\'  border=none  align=right name=\'apptgnGif\' style=\'visibility:hidden\'></td>\n\t\t<td class=\'COLUMNHEADER\' nowrap onclick =\"sort(\'ApptGivenOn\',\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="<img src=\'../../eAE/images/Ascending.gif\'  border=none  align=right name=\'apptgoGif\' style=\'visibility:hidden\'></td>\n\t\t<td class=\'COLUMNHEADER\' nowrap onclick =\"sort(\'status\',\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="<img src=\'../../eAE/images/Ascending.gif\'  border=none  align=right name=\'statusGif\' style=\'visibility:hidden\'></td>\n\n\t\t<td class=\'COLUMNHEADER\' nowrap onclick =\"sort(\'LastModifiedBy\',\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="<img src=\'../../eAE/images/Ascending.gif\'  border=none  align=right name=\'lastmbGif\' style=\'visibility:hidden\'></td>\n\n\t\t<td class=\'COLUMNHEADER\' nowrap onclick =\"sort(\'Lastmodifiedon\',\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="<img src=\'../../eAE/images/Ascending.gif\'  border=none  align=right name=\'lastmoGif\' style=\'visibility:hidden\'></td>\n\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t\t<tr>\n\t\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t\t<td nowrap class=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\' style=\"color:blue;cursor:pointer;\" onclick=\"show_Reference_details(\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\',\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\')\">";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</td><!-- Bru-HIMS-CRF-302 [IN:035020] -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t\t\t<td nowrap class=\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="</td>\n\t\t\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="</td>\n\t\t\t\t\t<td nowrap class=\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t\t\t\t\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t<td nowrap class=\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="</td> \n\t\t\t\t<td nowrap class=\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\'>&nbsp";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="</td>\n\t\t\t\t<td nowrap class=\'";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="</td>\n\t\t\t\t<td nowrap style=\"background-color:";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 =";FONT-SIZE:8pt;\">";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="</td> ";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="&nbsp;/&nbsp;";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="&nbsp;</td>\t\n\n\t\t\t\t<td align=\'left\' nowrap class=\'";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\'>\n\t\t\t\t";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t\t\t</td>\t\n\t\t\t\t";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\' style=\"color:blue;cursor:pointer;\"  onclick=\"show_patinstructions(\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\'>&nbsp;</td>\n\t\t\t\t";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="</td>\n\t\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t\t\t<input type = \'hidden\' name = \'patientid\' value = \'";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\'>\n\t\t\t<input type = \'hidden\' name = \'apptfromdate\' value = \'";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\'>\n\t\t\t<input type = \'hidden\' name = \'appttodate\' value = \'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\'>\n\t\t\t<input type = \'hidden\' name = \'MODULE_ID\' value = \'";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\'>\n\t\t\t<input type = \'hidden\' name = \'orderCriteria_sensor\' value = \'";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\'>\n\t\t\t<input type = \'hidden\' name = \'orderCriteria\' value = \'apptno\'>\t\t\t\n\t\t\t<input type = \'hidden\' name = \'asc_desc\' value = \'";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\'>\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n\t\t<script>\n\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));\n\t\t\tparent.frames[2].location.href =\'../../eCommon/html/blank.html\' ;\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t\t\t<script >\n\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'hidden\';\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n\t\t\t<script >\n\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'visible\';\n\t\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t\t";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\t</table>\n\t<br><center>\n\t";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n</center>\n\n";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\n\t<script>\n\t\tparent.frames[1].document.forms[0].select.disabled=false;\n\t</script>\n";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n<script>\ntoggleGifs(\'";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\')\n</script>\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

	// To Handle java.lang.NullPointerException.
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equalsIgnoreCase("null"))) ? "" : inputString );
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);


    request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String fac_id		= (String) session.getValue( "facility_id" ) ;
	StringBuffer sql = new StringBuffer("") ;
	String appt_no1="";
	String age="";
	String appt_no2="";
	String rsource="";
	String sql4="";
	String apptfromdate_greg="";
	String appttodate_greg="";
	String fac_id2=(String) session.getValue( "facility_id" );
	String appt_ref_no ="";
	String patientid	=	request.getParameter("patientid") ;
	String patname	=	request.getParameter("patientname") ;
	String cliniccode	=	request.getParameter("cliniccode") ;
	String practcode	=	request.getParameter("practcode") ;
	String gender		=	request.getParameter("gender") ;
	String apptfromdate	=	request.getParameter("apptfromdate") ;
	String MODULE_ID	=	request.getParameter("MODULE_ID") ;
	String function_id = request.getParameter("function_id")==null?"":request.getParameter("function_id");
	String showInstructionsYN="N";
	String module_id	=	request.getParameter("MODULE_ID") ;
	String patientCatDesc="";
	if(module_id == null )
		module_id="";
   /*"patcat_code" Added for this CRF [RUT-CRF-0011]*/		
      String patcat_code=request.getParameter("patcat_code")==null?"":request.getParameter("patcat_code") ;		   
	/*End [RUT-CRF-0011]*/
	
	//Below variable declare for this  [Bru-HIMS-CRF-177]
	 String colour_indicator="";

	 
 // String schedule_gender=request.getParameter("schedule_gender")==null?"":request.getParameter("schedule_gender") ; // Added for this CRF [Bru-HIMS-CRF-167]
	 
/*1*/	String oth_contact_no=	request.getParameter("oth_contact_no") ;
           if(oth_contact_no == null)	oth_contact_no = "";
	String appttodate	=	request.getParameter("appttodate") ;
	String referral_priority	=	request.getParameter("referral_priority") ;
	String speciality	=	request.getParameter("speciality") ;
	String service	=	request.getParameter("service") ;
	String facility =	request.getParameter("facility")==null?fac_id:request.getParameter("facility");//modified for the SCF - ML-BRU-SCF-1045 [IN043888]
	String cancel_appt =	request.getParameter("cancel_appt") ;
	String care_locn =	request.getParameter("care_locn") ;
	String resource_type =	request.getParameter("resource_type") ;
	String orderCriteria_sensor =	request.getParameter("orderCriteria_sensor") == null?"apptno":request.getParameter("orderCriteria_sensor");
	String short_desc1 =	request.getParameter("short_desc") ;
	String patientname1		=	request.getParameter("patientname")== null?"":request.getParameter("patientname");
	String locale = (String)session.getAttribute("LOCALE");
	String incld_past_appts		=	request.getParameter("incld_past_appts")== null?"":request.getParameter("incld_past_appts");
	apptfromdate_greg=DateUtils.convertDate(apptfromdate,"DMY",locale,"en");
	appttodate_greg=DateUtils.convertDate(appttodate,"DMY",locale,"en");

	
	StringBuffer orderByClause  = new StringBuffer();

   String orderCriteria	=	(request.getParameter("orderCriteria")==null)	? "apptno" : request.getParameter("orderCriteria");
   String asc_desc	=	(request.getParameter("asc_desc")==null)	? " asc" : request.getParameter("asc_desc");

if(orderCriteria.equals("")) orderCriteria="apptno" ;
appt_ref_no	=	(request.getParameter("appt_ref_no")==null)	? "" : request.getParameter("appt_ref_no"); 
age	=	(request.getParameter("age")==null)	? "" : request.getParameter("age"); 




	//if(appt_ref_no == null || appt_ref_no.equals("null"))	appt_ref_no = "";
	if(cancel_appt == null || cancel_appt.equals("null"))	cancel_appt = "";
	if(patientid == null || patientid.equals("null"))	patientid = "";
	if(patname == null || patname.equals("null"))	patname = "";
	if(cliniccode == null || cliniccode.equals("null"))	cliniccode = "";
	if(practcode == null || practcode.equals("null"))	practcode = "";
	if(gender == null || gender.equals("null"))	gender = "";
	if(apptfromdate == null || apptfromdate.equals("null"))	apptfromdate = "";
	if(appttodate == null || appttodate.equals("null"))	appttodate = "";
	if(referral_priority == null || referral_priority.equals("null"))	referral_priority = "";
	if(service == null || service.equals("null"))	service = "";
	if(speciality == null || speciality.equals("null"))	speciality = "";
	if(resource_type == null || resource_type.equals("null"))	resource_type = "";
	if(care_locn == null || care_locn.equals("null"))	care_locn = "";
	if(short_desc1 == null || short_desc1.equals("null"))	short_desc1 = "";




	String patientname = patname;
	String referralId	="";
	String order_catalog_code="";
	
	String classValue	 = "";
	String patient_id_one="";
	String p_name="";
	
	String practitioner_full_name="";
	String DECEASED_YN="";
	String translator_override_reason="";

	if (!patientname.equals(""))
	{
		patientname		= 	patientname + "%" ;
		
	}
	if (!patientname1.equals(""))
	{
	patientname1   =   patientname1 +"%";
	}
	if (!oth_contact_no.equals(""))
	{
		oth_contact_no		= 	oth_contact_no + "%" ;
	
	}


	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;

	int start = 0 ;
	int end = 0 ;
    int i=1;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
		end = 14 ;
	else
		end = Integer.parseInt( to ) ;

		/*******order by creation logic********************/

	if(orderCriteria.equals("appt"))
		{
			orderByClause.append(" ORDER BY appt_ref_no");
		}

 if(orderCriteria.equals("apptno"))
		{
			orderByClause.append(" ORDER BY ");
			orderByClause.append(" appt_ref_no"+asc_desc+" ");
		}
	else if(orderCriteria.equals("patientId"))
		{
			orderByClause.append(" ORDER BY ");
			orderByClause.append("patient_id ");
			orderByClause.append(""+asc_desc+" ");
		}
	else if(orderCriteria.equals("PatientName"))
		{	
			orderByClause.append(" ORDER BY ");
			orderByClause.append("patient_name"+asc_desc+" ");

		}
else if(orderCriteria.equals("gender"))
		{
				orderByClause.append(" ORDER BY ");
			orderByClause.append("GENDER"+asc_desc+" ");
		}
else if(orderCriteria.equals("age"))
		{
			orderByClause.append(" ORDER BY ");
			orderByClause.append("AGE"+asc_desc+" ");
		}

else if(orderCriteria.equals("MobileNo"))
		{
				orderByClause.append(" ORDER BY ");
			orderByClause.append("oth_contact_no"+asc_desc+" ");
		}
else if(orderCriteria.equals("apptdate"))
		{
				orderByClause.append(" ORDER BY ");
			orderByClause.append(" appt_date"+asc_desc+" ");
		}
else if(orderCriteria.equals("fromtime"))
		{
				orderByClause.append(" ORDER BY ");
	        orderByClause.append("appt_slab_from_time ");
			orderByClause.append(""+asc_desc+" ");
		}
		else if(orderCriteria.equals("totime"))
		{
				orderByClause.append(" ORDER BY ");
	        orderByClause.append("appt_slab_to_time ");
			orderByClause.append(""+asc_desc+" ");
		}


		else if(orderCriteria.equals("duration"))
		{
				orderByClause.append(" ORDER BY ");
	        orderByClause.append("appt_duration ");
			orderByClause.append(""+asc_desc+" ");
		}
		else if(orderCriteria.equals("visittype"))
		{
				orderByClause.append(" ORDER BY ");
	        orderByClause.append("visit_type_short_desc ");
			orderByClause.append(""+asc_desc+" ");
		}else if(orderCriteria.equals("Location"))
		{
				orderByClause.append(" ORDER BY ");
	        orderByClause.append("clinic_short_desc  ");
			orderByClause.append(""+asc_desc+" ");
		}else if(orderCriteria.equals("resource"))
		{
				orderByClause.append(" ORDER BY ");
	        orderByClause.append("practitioner_full_name ");
			orderByClause.append(""+asc_desc+" ");
		}else if(orderCriteria.equals("speciality"))
		{
				orderByClause.append(" ORDER BY ");
	        orderByClause.append("speciality_desc ");
			orderByClause.append(""+asc_desc+" ");
		}else if(orderCriteria.equals("ordercatalog"))
		{
				orderByClause.append(" ORDER BY ");
	        orderByClause.append("order_catalog_code ");
			orderByClause.append(""+asc_desc+" ");
		}else if(orderCriteria.equals("referralid"))
		{
				orderByClause.append(" ORDER BY ");
	        orderByClause.append("referral_id ");
			orderByClause.append(""+asc_desc+" ");
		}
		else if(orderCriteria.equals("ApptGivenBy"))
		{
				orderByClause.append(" ORDER BY ");
	        orderByClause.append("added_by ");
			orderByClause.append(""+asc_desc+" ");
		}
		
		else if(orderCriteria.equals("ApptGivenOn"))
		{
				orderByClause.append(" ORDER BY ");
	        orderByClause.append("added_date ");
			orderByClause.append(""+asc_desc+" ");
		}
		else if(orderCriteria.equals("status"))
		{
				orderByClause.append(" ORDER BY ");
	        orderByClause.append("appt_status ");
			orderByClause.append(""+asc_desc+" ");
		}
		else if(orderCriteria.equals("LastModifiedBy"))
		{
				orderByClause.append(" ORDER BY ");
	        orderByClause.append("modified_by ");
			orderByClause.append(""+asc_desc+" ");
		}
		else if(orderCriteria.equals("Lastmodifiedon"))
		{
				orderByClause.append(" ORDER BY ");
	        orderByClause.append("modified_date ");
			orderByClause.append(""+asc_desc+" ");
		} 
		
		else if(orderCriteria.equals("Category"))
		{
				orderByClause.append(" ORDER BY ");
	        orderByClause.append("patient_cat_code ");
			orderByClause.append(""+asc_desc+" ");
		} 
/*Checking "Category", Above else if condition Added for this CRF [RUT-CRF-0011]*/
/*******order by creation logic********************/


	Statement stmt				= null;
	ResultSet rs				= null;
	PreparedStatement pstmt=null;
	Statement stmt1				= null;
	ResultSet rs1				= null;
	ResultSet rs2				= null;
	Connection conn=null;
	
try {
	conn = ConnectionManager.getConnection(request);
	stmt = conn.createStatement();
	stmt1	 = conn.createStatement();
	//out.println("<script>alert('MODULE_ID--->'+"MODULE_ID"')</script>");
	
            _bw.write(_wl_block6Bytes, _wl_block6);
if(MODULE_ID!=null && MODULE_ID.equals("PH")){
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);
}
            _bw.write(_wl_block9Bytes, _wl_block9);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block11Bytes, _wl_block11);






	if (appt_ref_no ==null) appt_ref_no="";

		sql.append(" where ");
		if(!patientid.equals("")){
			sql.append(" patient_id='"+patientid+"' and ") ;
		}
		if(!cliniccode.equals("")){
			sql.append(" clinic_code = '"+cliniccode+"' and ");
		}
		if(!practcode.equals("")){
			sql.append(" practitioner_id = '"+practcode+"' and ") ;
		}
		if(!care_locn.equals("")){
			sql.append(" CARE_LOCN_TYPE_IND = '"+care_locn+"' and ") ;
		}
		if(!resource_type.equals("")){
			sql.append(" RESOURCE_CLASS =  '"+resource_type+"' and ") ;
		}
		if(!speciality.equals("")){
			sql.append(" speciality_code =  '"+speciality+"' and ") ;
		}
		if(!appt_ref_no.equals("")){
			sql.append(" appt_ref_no =  '"+appt_ref_no+"' and ") ;
		}
		//Saanthaakumar  Below Condition Added Bru-HIMS-CRF-302 [IN:035020] 
		if(!facility.equals("")){
			sql.append(" FACILITY_ID =  '"+facility+"' and ") ;
		}
		// Condition End Bru-HIMS-CRF-302 [IN:035020] 
		
	 /*Below Condition Added for this CRF [RUT-CRF-0011]*/
		if(!patcat_code.equals("")){
			sql.append(" patient_cat_code =  '"+patcat_code+"' and ") ;
		}
     /*End [RUT-CRF-0011]*/	

    /*Below Condition Added for this CRF [Bru-HIMS-CRF-167]*/	
	//if(!schedule_gender.equals("")){
	//		sql.append("pract_gender = '"+schedule_gender+"' and ") ;
	//	}	
	//End [Bru-HIMS-CRF-167]
				

	sql.append("appt_date between to_date(nvl('"+apptfromdate_greg+"','01/01/1400'),'dd/mm/yyyy') and ");
	sql.append(" to_date(nvl('"+appttodate_greg+"','31/12/5000'),'dd/mm/yyyy') ");
    
	
	
if (patientid.equals("")) 
	{

	sql.append(" and UPPER(PATIENT_NAME) like upper('%"+patientname1+"%')"); 

	
	}

	 if (!(incld_past_appts.equals("")|| incld_past_appts.equals(null)))
	 {
		if (incld_past_appts.equals("N"))
		{
			sql.append("AND appt_date>=trunc(sysdate)");
		}
	 }
		 if (!oth_contact_no.equals(""))
{

	sql.append(" and UPPER(oth_contact_no) like upper('%"+oth_contact_no+"%')"); 
	}
if(!orderCriteria.equals(""))
	{
sql.append(orderByClause);
	}

/*	if (patientid.equals("")) 
	{
	sql.append(" order by 1,appt_date,appt_slab_from_time1") ;
	}else
	{
sql.append(" order by appt_date,appt_slab_from_time1") ;
	} */
	int maxRecord = 0;


		
            _bw.write(_wl_block12Bytes, _wl_block12);

		StringBuffer sqlStr = new StringBuffer("");
		//sqlStr.append(" Select patient_id,AM_GET_DESC.AM_CARE_LOCN_TYPE((select clinic_type from op_clinic where facility_id=oa_appt_patient_vw.facility_id and CLINIC_CODE=oa_appt_patient_vw.clinic_code),'"+locale+"','1')CARE_LOCN_TYPE_DESC , RESOURCE_CLASS ,CLINIC_CODE,CARE_LOCN_TYPE_IND,appt_ref_no, to_char(appt_date,'dd/mm/rrrr') appt_date1,appt_date,referral_id, nvl(to_char(appt_slab_from_time,'hh24:mi'),' ') appt_slab_from_time, appt_slab_from_time appt_slab_from_time1, nvl(to_char(appt_slab_to_time,'hh24:mi'),' ')appt_slab_to_time,nvl(to_char(appt_duration,'hh24:mi'),' ')appt_duration,OP_GET_DESC.OP_VISIT_TYPE(FACILITY_ID, APPT_TYPE_CODE,'"+locale+"','2') visit_type_short_desc , OP_GET_DESC.OP_CLINIC(FACILITY_ID,CLINIC_CODE,'"+locale+"','1') CLINIC_SHORT_DESC ,decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2')) practitioner_full_name ,sm_get_desc.sm_appl_user(modified_by_id,'"+locale+"','1') modified_by,sm_get_desc.sm_appl_user(added_by_id,'"+locale+"','1') added_by,to_char(added_date,'dd/mm/yyyy hh24:mi') added_date, FACILITY_ID,  to_char(modified_date,'dd/mm/yyyy hh24:mi') modified_date ,AM_GET_DESC.AM_SPECIALITY(speciality_code,'"+locale+"','2')  SPECIALITY_DESC , SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,'"+locale+"',1)FACILITY_NAME ,appt_status,ORDER_CATALOG_CODE,decode('"+locale+"','en',patient_name, nvl(patient_name_loc_lang, patient_name)) patient_name,GENDER ,oth_contact_no,get_age(DATE_OF_BIRTH) age,(select DECEASED_YN from mp_patient where patient_id=oa_appt_patient_vw.patient_id) DECEASED_YN  from  ");
		
		sqlStr.append(" Select patient_id,MP_GET_DESC.MP_PAT_CATEGORY(patient_cat_code,'en','1') patientCatDesc,AM_GET_DESC.AM_CARE_LOCN_TYPE((select clinic_type from op_clinic where facility_id=oa_appt_patient_vw.facility_id and CLINIC_CODE=oa_appt_patient_vw.clinic_code),'"+locale+"','1')CARE_LOCN_TYPE_DESC , RESOURCE_CLASS ,CLINIC_CODE,CARE_LOCN_TYPE_IND,appt_ref_no, to_char(appt_date,'dd/mm/rrrr') appt_date1,appt_date,referral_id, nvl(to_char(appt_slab_from_time,'hh24:mi'),' ') appt_slab_from_time, appt_slab_from_time appt_slab_from_time1, nvl(to_char(appt_slab_to_time,'hh24:mi'),' ')appt_slab_to_time,nvl(to_char(appt_duration,'hh24:mi'),' ')appt_duration,OP_GET_DESC.OP_VISIT_TYPE(FACILITY_ID, APPT_TYPE_CODE,'"+locale+"','2') visit_type_short_desc , OP_GET_DESC.OP_CLINIC(FACILITY_ID,CLINIC_CODE,'"+locale+"','1') CLINIC_SHORT_DESC ,decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2')) practitioner_full_name ,sm_get_desc.sm_appl_user(modified_by_id,'"+locale+"','1') modified_by,sm_get_desc.sm_appl_user(added_by_id,'"+locale+"','1') added_by,to_char(added_date,'dd/mm/yyyy hh24:mi') added_date, FACILITY_ID,  to_char(modified_date,'dd/mm/yyyy hh24:mi') modified_date ,AM_GET_DESC.AM_SPECIALITY(speciality_code,'"+locale+"','2')  SPECIALITY_DESC , SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,'"+locale+"',1)FACILITY_NAME ,appt_status,ORDER_CATALOG_CODE,decode('"+locale+"','en',patient_name, nvl(patient_name_loc_lang, patient_name)) patient_name,GENDER ,oth_contact_no,get_age(DATE_OF_BIRTH) age,(select DECEASED_YN from mp_patient where patient_id=oa_appt_patient_vw.patient_id) DECEASED_YN,(select COLOR_INDICATOR from op_visit_type where facility_id=oa_appt_patient_vw.facility_id and VISIT_TYPE_CODE=oa_appt_patient_vw.APPT_TYPE_CODE) COLOR_INDICATOR,(select contact_reason from am_contact_reason_lang_vw where contact_reason_code=oa_appt_patient_vw.TRANS_EXCEED_REASON_CODE and nvl(trans_exceed_reason_yn,'N') = 'Y' and  language_id='"+localeName+"')translator_override_reason,(select rule_appl_yn from oa_param)rule_appl_yn   from  ");
		 //Above Query Modified for this CRF [Bru-HIMS-CRF-177] 
 
		sqlStr.append("oa_appt_patient_vw ");		
 
		sqlStr.append(sql.toString()) ; 

      
			if (rs!=null) rs.close();

             
			rs = stmt.executeQuery(sqlStr.toString());
			sqlStr.setLength(0);

		
		 if ( start != 1 )
		 for( int j=1; j<start; i++,j++ ){
		  rs.next() ;
		}
		if ( rs != null ){	

			while ( i<=end && rs.next() ){
				String rule_appl_yn=rs.getString("rule_appl_yn")==null?"N":rs.getString("rule_appl_yn");			
				if(maxRecord==0)
				{
	


			
            _bw.write(_wl_block13Bytes, _wl_block13);

			if ( !(start <= 1) ) { 
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(appt_ref_no));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(patcat_code));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(cliniccode));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(care_locn));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(resource_type));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(practcode));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(asc_desc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(orderCriteria));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(apptfromdate));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(appttodate));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(facility));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((start-14)));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf((end-14)));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(URLEncoder.encode(sql.toString())));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(speciality));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(MODULE_ID));
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
 }
		//	if ( !( (start+14) > maxRecord ) )
				{ 
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(appt_ref_no));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(patcat_code));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(patientname));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(cliniccode));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(care_locn));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(resource_type));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(practcode));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(asc_desc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(orderCriteria));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(apptfromdate));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(appttodate));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(facility));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((start+14)));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf((end+14)));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(URLEncoder.encode(sql.toString())));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(speciality));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(MODULE_ID));
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
 } 
            _bw.write(_wl_block36Bytes, _wl_block36);
sql.setLength(0);
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(appt_ref_no));
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
if (patientid.equals("")) {
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(appt_ref_no));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(appt_ref_no));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(appt_ref_no));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(appt_ref_no));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);
}else{
            _bw.write(_wl_block46Bytes, _wl_block46);
}
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(appt_ref_no));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(appt_ref_no));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(appt_ref_no));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(appt_ref_no));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(appt_ref_no));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(appt_ref_no));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(appt_ref_no));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(appt_ref_no));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(appt_ref_no));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(appt_ref_no));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(appt_ref_no));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(appt_ref_no));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(appt_ref_no));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);
if(rule_appl_yn.equals("Y")){
            _bw.write(_wl_block61Bytes, _wl_block61);
}
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(appt_ref_no));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(appt_ref_no));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(appt_ref_no));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(appt_ref_no));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(appt_ref_no));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);
 }
		
				DECEASED_YN=rs.getString("DECEASED_YN");
				if(DECEASED_YN==null) DECEASED_YN = "";

				if ( i % 2 == 0 )
					classValue = "QRYEVEN" ;
				else
					classValue = "QRYODD" ;
			if(DECEASED_YN.equals("Y"))	classValue = "DECEASEDPATLINE";
					
				referralId =rs.getString("referral_id");
				if(referralId==null) referralId = "&nbsp;";
				
				patient_id_one=rs.getString("PATIENT_ID");
				/*Below Line Added for this CRF [RUT-CRF-0011]*/
						
				patientCatDesc=checkForNull(rs.getString("patientCatDesc"));

                /*Below Line Added for this CRF [Bru-HIMS-CRF-177] */
				colour_indicator=checkForNull(rs.getString("COLOR_INDICATOR"));	
				
				
				if(patient_id_one ==null) patient_id_one="&nbsp;";
              oth_contact_no=rs.getString("oth_contact_no");
				if(oth_contact_no ==null) oth_contact_no="&nbsp;";

				appt_no1 =rs.getString("appt_ref_no");

				sql4="select count(appt_ref_no) cnt from oa_resource_for_appt where appt_ref_no = '"+appt_no1+"' and FACILITY_ID='"+fac_id+"'";

			
				appt_no2="";
				rs1 = stmt1.executeQuery(sql4);
				if ( rs1 != null ){
					while(rs1.next()){	
						appt_no2=rs1.getString("cnt");
						
					}
				}

				if(rs1 !=null)rs1.close();
				showInstructionsYN="N";
				sql4="select *  from oa_appt_pat_instructions where facility_id='"+fac_id+"' and appt_ref_no='"+appt_no1+"'";
				rs1 = stmt1.executeQuery(sql4);
				if ( rs1 != null ){
					if(rs1!=null && rs1.next()){	
						showInstructionsYN="Y";					
					}
				}
				if(rs1 !=null)rs1.close();
				if(showInstructionsYN.equals("N")){
					sql4="select *  from oa_appt_proc_instructions where facility_id='"+fac_id+"' and appt_ref_no='"+appt_no1+"'";
					rs1 = stmt1.executeQuery(sql4);
					if ( rs1 != null ){
						if(rs1!=null && rs1.next()){	
							showInstructionsYN="Y";					
						}
					}
				}
				if(appt_no2==null) appt_no2 = "";
				rsource= rs.getString("RESOURCE_CLASS");
				if(rsource==null) rsource = "";
				String rsource_name="";

				if(rsource.equals("P"))
						{
						rsource_name=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
						}else if(rsource.equals("R"))
						{
						rsource_name=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
						}else if(rsource.equals("E"))
						{
						rsource_name=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
						}else if(rsource.equals("O"))
						{
						rsource_name=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels");
						}


				practitioner_full_name =rs.getString("practitioner_full_name");
				if(practitioner_full_name==null) practitioner_full_name = "&nbsp;";
				
				String appt_status=rs.getString("appt_status")	;
				String appt_status_desc="";

				if(appt_status.equals("1"))
				{
				appt_status_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.open.label","common_labels");
				}else if(appt_status.equals("A"))
				{
				appt_status_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOA.VisitRegistered.label","oa_labels");
				}

				String gender_code=rs.getString("GENDER");
				String genderdesc="";

				 if(gender_code.equals("M")) 
				{
					genderdesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
				}
				else if(gender_code.equals("F")) {
					genderdesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
				}
				else if(gender_code.equals("U")) {
					genderdesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
				}

				String appt_date=rs.getString("appt_date1");
				String appt_date_disp=DateUtils.convertDate(appt_date,"DMY","en",locale);

				String added_date=rs.getString("added_date");
				String added_date_disp=DateUtils.convertDate(added_date,"DMYHM","en",locale);

				String modified_date=rs.getString("modified_date");
				String modified_date_disp=DateUtils.convertDate(modified_date,"DMYHM","en",locale);

				
				p_name= rs.getString("PATIENT_NAME");
				
				
				order_catalog_code=rs.getString("ORDER_CATALOG_CODE");
				translator_override_reason=rs.getString("translator_override_reason")==null?"":rs.getString("translator_override_reason");
				String or_cat_desc="";
				String install_yn_val="";	
if(order_catalog_code ==null) order_catalog_code="";
					if ( !order_catalog_code.equals("") )
					{
				//String sql_OR="select Operational_yn from sm_modules_facility where facility_id = '"+facility+"' and module_id = 'OR' "; //Bru-HIMS-CRF-302 [IN:035020] 
				String sql_OR="select Operational_yn from sm_modules_facility where facility_id = ? and module_id = 'OR' "; //Bru-HIMS-CRF-302 [IN:035020] 
				//rs2=stmt1.executeQuery(sql_OR);
				pstmt = conn.prepareStatement(sql_OR);
				pstmt.setString(1,facility);
				rs2 = pstmt.executeQuery();
					if(rs2 !=null )
					{
						while (rs2.next())
						{
						install_yn_val=rs2.getString("Operational_yn");
						}

					}
					

			if(rs2 !=null)rs2.close();
				if(rs1 !=null)rs1.close();

					if(order_catalog_code ==null) order_catalog_code="";
					if(install_yn_val.equals("Y"))
				{
					String order_cat_or="select short_desc from OR_ORDER_CATALOG_lang_vw where 	 ORDER_CATALOG_CODE='"+order_catalog_code+"' and language_id='"+locale+"'";
					rs1 = stmt1.executeQuery(order_cat_or);
					if ( rs1 != null ){
						while(rs1.next()){	
							or_cat_desc=rs1.getString("short_desc");
							
						}
					}
				
				if (rs1 !=null)	 rs1.close();
				}
				}
				
            _bw.write(_wl_block68Bytes, _wl_block68);
 if(!appt_no2.equals("0") ){ 
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(appt_no1));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(facility));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(appt_no1));
            _bw.write(_wl_block73Bytes, _wl_block73);

					appt_no2="";
				}else
				{	 
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(rs.getString("appt_ref_no")));
            _bw.write(_wl_block75Bytes, _wl_block75);
 } 
            _bw.write(_wl_block76Bytes, _wl_block76);
if (patientid.equals("")) {
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(patient_id_one));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(p_name));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(genderdesc));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(rs.getString("age")));
            _bw.write(_wl_block78Bytes, _wl_block78);
}else {
            _bw.write(_wl_block76Bytes, _wl_block76);
}
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(oth_contact_no));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(patientCatDesc));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(appt_date_disp));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(rs.getString("appt_slab_from_time")));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(rs.getString("appt_slab_to_time")));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(rs.getString("appt_duration")));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(colour_indicator));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(rs.getString("visit_type_short_desc")));
            _bw.write(_wl_block85Bytes, _wl_block85);
/*modified for this CRF [Bru-HIMS-CRF-177]*/
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(rs.getString("CARE_LOCN_TYPE_DESC")));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(rs.getString("clinic_short_desc")));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(rsource_name));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(practitioner_full_name));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(rs.getString("speciality_desc")));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(or_cat_desc));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block88Bytes, _wl_block88);

				out.println(referralId);
				
            _bw.write(_wl_block89Bytes, _wl_block89);
if(showInstructionsYN.equals("Y")){
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(appt_no1));
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block75Bytes, _wl_block75);
}else{
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block91Bytes, _wl_block91);
}
            _bw.write(_wl_block46Bytes, _wl_block46);
if(rule_appl_yn.equals("Y")){
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(translator_override_reason));
            _bw.write(_wl_block75Bytes, _wl_block75);
}
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(rs.getString("added_by")));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(added_date_disp));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(appt_status_desc));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(rs.getString("modified_by")));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(modified_date_disp));
            _bw.write(_wl_block92Bytes, _wl_block92);

				i++;
				maxRecord++;
			}// while

			
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(apptfromdate));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(appttodate));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(MODULE_ID));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(orderCriteria_sensor));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(asc_desc));
            _bw.write(_wl_block99Bytes, _wl_block99);

		}

		if(maxRecord == 0)
		{
            _bw.write(_wl_block100Bytes, _wl_block100);
}

		if ( maxRecord < 14 || (!rs.next()) ) {
		
            _bw.write(_wl_block101Bytes, _wl_block101);
 
				} else {
            _bw.write(_wl_block102Bytes, _wl_block102);
}

	
            _bw.write(_wl_block103Bytes, _wl_block103);

	if ( rs != null ) rs.close() ;	
	if ( rs1 != null ) rs1.close() ;	
	if(stmt1!=null) stmt1.close() ;
	if ( stmt != null ) stmt.close() ;

	  if((orderByClause != null) && (orderByClause.length() > 0))
		{
			orderByClause.delete(0,orderByClause.length());
		}
	
}catch ( Exception e ){
	//out.println("Exception QueryApptForPatientResult.jsp " + e);
	e.printStackTrace();
}
finally{

	ConnectionManager.returnConnection(conn,request);
}

            _bw.write(_wl_block104Bytes, _wl_block104);
if(!module_id.equals("PH")){
            _bw.write(_wl_block105Bytes, _wl_block105);
}
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(orderCriteria));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(asc_desc));
            _bw.write(_wl_block107Bytes, _wl_block107);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ViewPatientDetails.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.apptno.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MobileNo.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.category.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.apptdate.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.fromtime.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.totime.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.duration.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.visittype.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.resource.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ordercatalog.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referralid.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.PatInstructions.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.ApptGivenBy.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.ApptGivenOn.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.LastModifiedBy.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.Lastmodifiedon.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.details.label", java.lang.String .class,"key"));
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
}
