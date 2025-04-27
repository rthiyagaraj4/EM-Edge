package jsp_servlet._eop._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import javax.servlet.jsp.JspWriter;
import webbeans.eCommon.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;

public final class __visitregistrationapptrecds extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/VisitRegistrationApptRecds.jsp", 1723178303057L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--    Function Name VisitRegistration\n    Created by M.Sathis Kumar on 13/12/2000 -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\t\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n\t<meta http-equiv=\"Expires\" content=\"0\">\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t\n\t<script language=\'javascript\' src=\'../../eOP/js/VisitRegistration1.js\'></script>\t\n\t<Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n    <body class=\'content\' onKeyDown=\'lockKey();\' topmargin=\'0\' bottommargin=\'0\' onscroll=\'scrollTitle();\' ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="onload=\"displayApptRefDtls();\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" >\n        <form name=\"apptrecds\" id=\"apptrecds\">\n           \n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\n\t<!--Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187-->\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' align=\'center\' width=\'100%\'>\n\t\t<tr>\n\t\t\t<input type=\"button\" style=\'display:none\' class=button name=\'appt_list\' id=\'appt_list\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&nbsp;";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' title=\'Appointment List\' onClick=\"displayApptList();\"></input>\n\t\t\t<input type=\"button\" style=\'display:none\' class=button name=\'ref_list\' id=\'ref_list\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' title=\'Referral List\' onClick=\"displayRefList();\"></input>\n\t\t</tr>\n\t</table>\n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\t\n\t\t\t\t\t\t<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' align=\'center\' width=\'100%\' id=\'appt_button_list\' style=\'display:none\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' align=\'center\' width=\'100%\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<th align=\'left\' nowrap colspan=\'10\'>\n\t\t\t\t\t\t\t<div  id=\'divTitleTable\' class=\'myClass\'> ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</div>\n\t\t\t\t\t\t\t</th>\n\t\t\t\t\t\t</tr>               \n\t\t\t\t\t\t<th align=\'center\'  width=\'5%\' nowrap><div  id=\'head1\' class=\'myClass\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</div></th>\n\t\t\t\t\t\t<th align=\'center\'  width=\'5%\' nowrap><div  id=\'head2\' class=\'myClass\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</div></th>\n\t\t\t\t\t\t<th align=\'center\'  width=\'13%\' nowrap><div  id=\'head3\' class=\'myClass\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</div></th>        \n\t\t\t\t\t\t<th align=\'center\'  width=\'10%\' nowrap><div  id=\'head4\' class=\'myClass\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</div></th>      \n\t\t\t\t\t\t<th align=\'center\'  width=\'13%\' nowrap><div  id=\'head5\' class=\'myClass\'>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</div></th>\n\t\t\t\t\t\t<th align=\'center\'  width=\'10%\' nowrap><div  id=\'head6\' class=\'myClass\'>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</div></th>        \t\n\t\t\t\t\t\t<th align=\'center\'  width=\'13%\' nowrap><div  id=\'head7\' class=\'myClass\'>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</div></th> \n\t\t\t\t\t\t<th align=\'center\'  width=\'17%\' nowrap><div  id=\'head8\' class=\'myClass\'>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</div> </th> \t\t\t\t\n\t\t\t\t    \t <th align=\'center\'  width=\'14%\' nowrap><div  id=\'head9\' class=\'myClass\'>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</div></th>  \n\t\t\t\t    \t<!--Added By Dharma on 25th June 2019 against KDAH-CRF-0525.1 [IN:070446] Start-->\n\t\t\t\t\t\t ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t\t <th align=\'center\'  width=\'14%\' nowrap><div  id=\'head9\' class=\'myClass\'>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</div></th>  \n\t\t\t\t\t\t ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t <!--Added By Dharma on 25th June 2019 against KDAH-CRF-0525.1 [IN:070446] End-->\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t\n\t\t\t\t\t\t\t<tr>\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t\t\t\t<td width=\"5%\" align=\"left\" class= \"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\"><font size=\'1\' nowrap>\n\t\t\t\t\t\t\t\t\t<a href=\"javascript:tab_click_add_visitapptrecds(\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\',\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\',\'R\',\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\',\'N\',\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\',\'\',\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\')\">";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</a>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t\t\t\t<td width=\"5%\" align=\"left\" class=\"apptclass\" ><font size=\'1\' nowrap>";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</td>\n\t\t\t\t\t\t\t    ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\n\t\t\t\t\t\t\t\t   ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t\t\t\t   <td align=\'left\' width=\'5%\' class= \'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' nowrap><font size=\'1\'>";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\t\t   <td align=\'left\' width=\'5%\' class= \'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="   \n\t\t\t\t\t\t\t\t   \n\t\t\t\t\t\t\t\t    ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t\t\t\t   <td align=\'left\' width=\'13%\' class= \'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</td>\n\t\t\t\t\t\t\t         ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\t\t\t      <td align=\'left\' width=\'13%\' class= \'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' nowrap><font     size=\'1\'>";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</td>\n\t\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="   \n\t\t\t\t\t\t\t\t   ";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t\t\t   <td align=\'left\' width=\'10%\' class= \'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</td>\n\t\t\t\t\t\t\t\t   ";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t\t\t\t          <td align=\'left\' width=\'10%\' class= \'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 =" \n\t\t\t\t\t\t\t\t   \n\t\t\t\t\t\t\t\t   ";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\t\t\t\t\t\t\t\t   ";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t\t\t\t     <td align=\'left\' width=\'13%\' class= \'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' nowrap><font   size=\'1\'>";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 =" \n\t\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t\t\t\t\t\t   <td align=\'left\' width=\'10%\'class= \'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</td>\n\t\t\t\t\t\t\t       ";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t\t\t\t\t      <td align=\'left\' width=\'10%\' class= \'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 =" \n\t\t\t\t\t\t\t\t   \n\t\t\t\t\t\t\t\t \t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t\t\t\t\t\t    <td align=\'left\' width=\'13%\' class= \'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="</td>\n\t\t\t\t\t\t\t          ";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t\t\t\t        <td align=\'left\' width=\'13%\' class= \'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</td>\n\t\t\t\t\t\t\t     \t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 =" \n\t\t\t\t\t\t\t\t   ";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t\t\t\t\t\t\t   <td align=\'left\' width=\'17%\' class= \'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="/";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="</td>\t\t   \n\t\t\t\t\t\t\t        ";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\t\t\t\t\t        <td align=\'left\' width=\'17%\' class= \'";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n                                    <td align=\'left\' width=\'17%\' class= \'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\' nowrap><font    size=\'1\'>";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="</td>\n\t\t\t\t\t\t\t\t\t<!--Added By Dharma on 25th June 2019 against KDAH-CRF-0525.1 [IN:070446] Start-->\n\t\t\t\t\t\t\t\t\t<!--Modified by Ashwini on 01-Dec-2021 for ML-BRU-CRF-0628.6-->\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="&nbsp;</td>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t\t\t\t\t\t\t\t<!--Added By Dharma on 25th June 2019 against KDAH-CRF-0525.1 [IN:070446] End-->\n\t\t\t\t\t\t\t         </tr>    \n\t\t\t\t\t\t\n\t\t\t\t\t\t \t\t\t   \n\t\t\t\t\t\t\t\t   ";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t</table> \t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\n\t\t\t\t\t\t<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' align=\'center\' width=\'100%\' id=\'ref_button_list\' style=\'display:none\'>\n\n\t\t\t\t\t\t<th align=\'center\'  width=\'5%\' nowrap><div class=\'myClass\'>&nbsp;</div></th>\n\n\t\t\t\t\t\t<th align=\'center\'  width=\'20%\' nowrap><div class=\'myClass\'>";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="</div></th>\n\n\t\t\t\t\t\t<th align=\'center\'  width=\'20%\' nowrap><div class=\'myClass\'>";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="</div></th>\n\n\t\t\t\t\t\t<th align=\'center\'  width=\'35%\' nowrap><div class=\'myClass\'>";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="</div></th>      \n\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\n\t\t\t\t\t\t<tr>\n\n\t\t\t\t\t\t<td align=\'left\' style = \'vertical-align:text-top\' width=\'5%\' class= \'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\' nowrap><font size=\'1\'><a href =\"javascript:showRefDtls(\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\')\">+</a></td>\n\t\t\t\t\t\t<td align=\'left\' style = \'vertical-align:text-top\' width=\'20%\' class= \'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\' nowrap><font size=\'1\'><a href=\"javascript:populateLocationValues(\'";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\');\">";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="</a></td>\n\t\t\t\t\t\t<td align=\'left\' style = \'vertical-align:text-top\' width=\'20%\' class= \'";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="</td>\n\t\t\t\t\t\t<td align=\'left\' style = \'vertical-align:text-top\' width=\'20%\' class= \'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="&nbsp;</td>\n\t\t\t\t\t\t<td align=\'left\' style = \'vertical-align:text-top\' width=\'35%\' class= \'";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="</td>\n\n\t\t\t\t\t\t</tr>\n\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\t\t\t\t\t\t</table>\n\t\t\t\t";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n\t\t<input type=\'hidden\' name=\'register_visit_walkin\' id=\'register_visit_walkin\' value=\'";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\'>\n\t\t<input type=\'hidden\' name=\'register_visit_referral\' id=\'register_visit_referral\' value=\'";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\'>\n\t\t<input type=\'hidden\' name=\'bl_interface_yn\' id=\'bl_interface_yn\' value=\'";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\'>\n\t\t<input type=\'hidden\' name=\'build_episode_rule\' id=\'build_episode_rule\' value=\'";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\'>\n\t\t<input type=\'hidden\' name=\'or_install_yn\' id=\'or_install_yn\' value=\'";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\'>\n\t\t<input type=\'hidden\' name=\'oa_install_yn\' id=\'oa_install_yn\' value=\'";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\'>\n\t\t<!-- <input type=\'hidden\' name=\'reason\' id=\'reason\' value=\'";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\'>\n\t\t<input type=\'hidden\' name=\'contact_reason_code\' id=\'contact_reason_code\' value=\'";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\'> -->\n\t\t\n\t\t<input type=\'hidden\' name=\'oper_stn_id\' id=\'oper_stn_id\' value=\'";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\'>\n\t\t<input type=\'hidden\' name=\'emer_regn_allow_yn\' id=\'emer_regn_allow_yn\' value=\'";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\'>\n\t\t\n\t\t<input type=\'hidden\' name=\'call_from\' id=\'call_from\' value=\'";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\'>\n\t\t<input type=\'hidden\' name=\'practitioner\' id=\'practitioner\' value=\'";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\'>\n\t\t<input type=\'hidden\' name=\'multi_speciality_yn\' id=\'multi_speciality_yn\' value=\'";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\'><!-- Added for the CRF Bru-HIMS-CRF-198 -->\n\t\t<!--Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187-->\n\t\t<input type=\'hidden\' name=\'appt_count\' id=\'appt_count\' value=\'";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\'>\n\t\t<input type=\'hidden\' name=\'ref_count\' id=\'ref_count\' value=\'";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\'>\n\t\t\n\t\t";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\n    </body>\n        </form>\n</html>\n\n";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

	public static String checkForNull(String inputString)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-Content-Type-Options", "nosniff");

	Connection con  = null; 
	PreparedStatement pstmt=null;       
	PreparedStatement multiPrepdStmt=null;       
	ResultSet rs=null; 
	ResultSet multirset=null; 
	String q_patient_id     = "";
	String q_appt_time  = "";   
	String contact_reason_code="";
	String reason="";
	String status       = "";
	String patientName  = "";
	String location     = "";
	String practitioner     = "";
	String practitioner_id="";
	String resource_class="";
	String resource_desc="";
	String q_appt_ref_no = "";        
	String nationality = "";
	String ordering_facility_id="";
	String order_id="";
	String order_line_num="";
	String order_type_code="";
	String order_catalog_code="";
	String order_catalog_desc="";
	String referral_id="";
	String recur_wo_sec_res="";
	StringBuffer sql1=new StringBuffer();
	String ref_reg_yn="";
	String locn_type="";
	String locn_code="";
	String service_code="";
	String cur_appt_ref_no="";
	
	// Variable defined for showing Multi colors        
	String classValue   = "";
	int row_even_or_odd = 1;
	String national_id_no = "";
	String nat_id_prompt = "";
	//int maxrecds=0;
	//String retunVal = "";
	String locale=checkForNull((String)session.getAttribute("LOCALE"));
	String nbsp_disp="&nbsp;";
	int count=0;
	//Added by Ashwini on 01-Dec-2021 for ML-BRU-CRF-0628.6
	Boolean isSlotStartMidEndAppl = false;

	//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
	Boolean isImproveReferralProcessAppl = false;
	StringBuffer sqlRef = new StringBuffer();
	PreparedStatement pstmtRef = null;     
	ResultSet rsRef = null;
	int ref_count = 0;
	String q_referral_id = "";
	String q_added_date = "";
	String q_preferred_date = "";
	String q_from_referral = "";
	String q_referral_priority = "";
	String q_prev_referral_priority ="";
	StringBuffer from_referral = new StringBuffer();
	from_referral.setLength(0);

try{
		con = ConnectionManager.getConnection(request);

		isSlotStartMidEndAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "OA", "BRU_HEALTH_INTG");//Added by Ashwini on 01-Dec-2021 for ML-BRU-CRF-0628.6

		//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
		isImproveReferralProcessAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"OP","IMPROVE_REFERRAL_PROCESS");
		String selected_loc_code   = request.getParameter("selected_loc_code")==null?"":request.getParameter("selected_loc_code");

		String Facility_Id  = checkForNull((String) session.getValue("facility_id"));
		String patient_id   = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String build_episode_rule=request.getParameter("build_episode_rule")==null?"":request.getParameter("build_episode_rule");
		String oa_install_yn=request.getParameter("oa_install_yn")==null?"":request.getParameter("oa_install_yn");
		String or_install_yn=request.getParameter("or_install_yn")==null?"":request.getParameter("or_install_yn");
		String bl_interface_yn=request.getParameter("bl_interface_yn")==null?"":request.getParameter("bl_interface_yn");
		//String userid         = (String) session.getValue("login_user");
		String emer_regn_allow_yn=request.getParameter("emer_regn_allow_yn")==null?"":request.getParameter("emer_regn_allow_yn");
		String oper_stn_id  = (request.getParameter("oper_stn_id") == null)?"":request.getParameter("oper_stn_id");
		String register_visit_walkin=(request.getParameter("register_visit_walkin") == null)?"":request.getParameter("register_visit_walkin");
		nat_id_prompt=request.getParameter("nat_id_prompt") == null?"":request.getParameter("nat_id_prompt");
		
		String register_visit_referral=(request.getParameter("register_visit_referral") == null)?"":request.getParameter("register_visit_referral"); 
		
		String functionId=(request.getParameter("function_id") == null)?"":request.getParameter("function_id"); 
		String call_from=request.getParameter("call_from") == null?"":request.getParameter("call_from");	
		//Added the below code for SRR20056-SCF-3046.1 [IN:026060] by Suresh M on 21.01.2010
		String visit_for_inpat_yn="";
		visit_for_inpat_yn=request.getParameter("visit_for_inpat_yn") == null?"":request.getParameter("visit_for_inpat_yn");		
		//Ends
		
		String multi_speciality_yn=request.getParameter("multi_speciality_yn") == null?"N":request.getParameter("multi_speciality_yn");//Added for the CRF Bru-HIMS-CRF-0198
		String speciality_code=request.getParameter("speciality_code") == null?"":request.getParameter("speciality_code");//Added for the CRF Bru-HIMS-CRF-0198
		String Speciality=request.getParameter("speciality") == null?"":request.getParameter("speciality");//Added for MMS-DM-CRF-0223 BY KAMATCHI S
		String multi_pract_sql="";//Added for the CRF Bru-HIMS-CRF-0198

		/*Added By Dharma on 25th June 2019 against KDAH-CRF-0525.1 [IN:070446] Start*/
		String isPractoApptYn = "N";
		String ext_appt_ref_no	= "";
		Boolean isPractoApptApplYN = CommonBean.isSiteSpecific(con,"OP","OP_AUTO_APPLY_PRACTO_APPT");
		/*Added By Dharma on 25th June 2019 against KDAH-CRF-0525.1 [IN:070446] End*/
	

            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	// #A0A0A0
	cur_appt_ref_no= (request.getParameter("cur_appt_ref_no") == null)?"":request.getParameter("cur_appt_ref_no");

//naren - pass from criteria page    
	/*pstmt = con.prepareStatement("select nvl(nat_id_prompt,'National ID No') nat_id_prompt from mp_param_lang_vw where language_id='"+locale+"' and  module_id='MP'");
	rs = pstmt.executeQuery();
	if (rs != null && rs.next())
		nat_id_prompt = rs.getString(1);

	if(rs != null) rs.close();
	if(pstmt != null) pstmt.close();*/

		
// naren - to be removed
/*	sql1.append("select count(*) as total from oa_appt a, op_clinic b where a.facility_id='"+Facility_Id+"' and  a.patient_id = '"+patient_id+"' and trunc(a.appt_date)=trunc(sysdate) and  a.facility_id = b.facility_id and a.appt_status != 'A' and b.clinic_code = a.clinic_code ");

	if(functionId.equals("VISIT_REGISTRATION"))
	{							
		sql1.append("and b.clinic_type = 'C'");
	}
	else if(functionId.equals("PROCD_REGISTRATION"))
	{		
		sql1.append("and b.clinic_type = 'E'");
	}				

	pstmt   = con.prepareStatement(sql1.toString());						
	rs = pstmt.executeQuery();
	if(rs != null && rs.next())
	{				
		maxrecds = rs.getInt(1);				 
	}

	if(rs != null) rs.close();
	if(pstmt != null) pstmt.close();

	sql1.setLength(0);*/

    
            _bw.write(_wl_block9Bytes, _wl_block9);
if(isImproveReferralProcessAppl){
            _bw.write(_wl_block10Bytes, _wl_block10);
}
            _bw.write(_wl_block11Bytes, _wl_block11);

			if(!patient_id.equals(""))
			{
			  
//naren - change as avbl in visitregistrationqueryresult.jsp				
		//int i=1;		
  sql1.append("SELECT   TO_CHAR(a.appt_time,  'hh24:mi') appt_time,  a.appt_status appt_status,  decode('"+locale+"', 'en', a.patient_name, nvl(a.patient_name_loc_lang, a.patient_name)) patient_name,  NVL(a.patient_id,  '') patient_id,  OP_GET_DESC.OP_CLINIC(a.FACILITY_ID, a.CLINIC_CODE,'"+locale+"','1') clinic_desc,    DECODE(a.resource_class,  'P', am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1),  'R',  a.practitioner_id,  AM_GET_DESC.AM_RESOURCE(a.FACILITY_ID, a.practitioner_id,'"+locale+"','2')) practitioner_name,  a.CLINIC_CODE  clinic_code,  a.practitioner_id practitioner_id,  a.appt_ref_no appt_ref_no,  a.appt_type_code,  MP_GET_DESC.MP_COUNTRY(a.country_code,'"+locale+"','3') nationality,  national_id_no,a.clinic_code,  a.care_locn_type_ind clinic_type,  a.resource_class resource_class, a.service_code service_code, a.resource_class  resource_desc,  a.recur_wo_sec_res recur_wo_sec_res,MULTI_SPECIALITY_YN,a.SPECIALITY_CODE ");
  if(or_install_yn.equals("Y"))
   {
     sql1.append(",a.ordering_facility_id ordering_facility_id,a.order_id order_id,a.order_line_num order_line_num,a.order_type_code order_type_code, a.order_catalog_code order_catlog_code,   d.short_desc order_catalog_desc ");
     } 
   
     sql1.append(",NVL(a.referral_id,'')referral_id,a.recur_wo_sec_res recur_wo_sec_res,a.care_locn_type_ind clinic_type,am_get_desc.am_contact_reason(CONTACT_REASON_CODE,'"+locale+"',1)  reason,CONTACT_REASON_CODE,a.EXT_APPT_REF_NO FROM   oa_appt a");
  if(or_install_yn.equals("Y"))
   {
     sql1.append(",or_order_catalog d");  
   }
     sql1.append(" WHERE  a.facility_id = '"+Facility_Id+"' AND  a.appt_status != 'A'  AND  a.patient_id = '"+patient_id+"' AND rd_appt_yn = 'N' AND a.appt_date=TRUNC(SYSDATE)");
     if(functionId.equals("VISIT_REGISTRATION"))
	 {		
		sql1.append(" and a.care_locn_type_ind in ('C','E') ");
	 }
	 else if(functionId.equals("PROCD_REGISTRATION"))
	 {
		sql1.append(" and a.care_locn_type_ind = 'E'");
	 }
 
    sql1.append(" AND  a.clinic_code IN (SELECT LOCN_CODE FROM am_locn_for_oper_stn b1 WHERE B1.facility_id = '"+Facility_Id+"' AND  b1.oper_stn_id = '"+oper_stn_id+"'  AND  b1.eff_status = 'E') ");

    if(or_install_yn.equals("Y"))
     {sql1.append("AND   a.order_catalog_code=d.order_catalog_code(+) ");
     }
	 sql1.append("ORDER BY a.appt_time");
				
			/*	sql1.append("select to_char(a.appt_time,'hh24:mi') appt_time,a.appt_status appt_status, a.patient_name patient_name,");
				sql1.append("nvl(a.patient_id,'') patient_id,b.short_desc clinic_desc, decode(b.primary_resource_class,'P',c.short_name,'R',a.practitioner_id,'E',a.practitioner_id,'O',a.practitioner_id, c.practitioner_name) practitioner_name,b.clinic_code clinic_code,");
				sql1.append("a.practitioner_id practitioner_id,a.appt_ref_no appt_ref_no,a.appt_type_code,cntry.long_desc nationality, national_id_no,b.primary_resource_class resource_class,decode(b.primary_resource_class,'P','Practitioner','R','Room','E','Equipment','O','Others','Practitioner') resource_desc");
				if(or_install_yn.equals("Y"))
				{
				sql1.append(",a.ordering_facility_id ordering_facility_id,a.order_id order_id,a.order_line_num order_line_num,a.order_type_code order_type_code,a.order_catalog_code order_catlog_code,d.short_desc order_catalog_desc ");
				}
				sql1.append(",nvl(a.referral_id,'')referral_id,a.recur_wo_sec_res recur_wo_sec_res,b.clinic_type clinic_type from oa_appt a,");
				sql1.append(" op_clinic b,am_practitioner c, mp_country cntry ");
				if(or_install_yn.equals("Y"))
				{
					sql1.append(",or_order_catalog d ");
				}
				sql1.append(" where a.appt_status != 'A' and b.clinic_code = a.clinic_code ");
				sql1.append("and a.facility_id='"+Facility_Id+"' and  a.patient_id = '"+patient_id+"' and a.country_code = cntry.country_code (+) and trunc(a.appt_date)=trunc(sysdate)");

				if(functionId.equals("VISIT_REGISTRATION"))
				{
					sql1.append(" and b.clinic_type = 'C'");
				}
				else if(functionId.equals("PROCD_REGISTRATION"))
				{
					sql1.append(" and b.clinic_type = 'E'");
				}
						
				sql1.append(" and c.practitioner_id(+) = a.practitioner_id  and  a.facility_id = b.facility_id");
				sql1.append(" and a.clinic_code in (SELECT LOCN_CODE FROM am_locn_for_oper_stn b1 WHERE B1.facility_id = '"+Facility_Id+"' AND b1.oper_stn_id = '"+oper_stn_id+"'  AND b1.eff_status = 'E') ");
				if(or_install_yn.equals("Y"))
				{
					sql1.append(" and a.order_catalog_code=d.order_catalog_code(+)");
				}
				sql1.append(" order by appt_time "); */     
				
				

                pstmt   = con.prepareStatement(sql1.toString());			
              
				rs = pstmt.executeQuery();
				//if( rs.next()) 
				//{ //rs.previous();
				
				//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
				if(isImproveReferralProcessAppl && !selected_loc_code.equals("")){
					sqlRef.append("SELECT patient_id, to_locn_code, to_locn_type, from_locn_code, referral_priority, a.added_date created_date, referral_id, TO_CHAR (a.added_date, 'dd/mm/yyyy') added_date, TO_CHAR (preferred_treatment_date, 'dd/mm/yyyy') preferred_date, DECODE (from_ref_type, 'X', am_get_desc.am_referral (from_ref_code, '"+locale+"', 1), sm_get_desc.sm_facility_param (from_facility_id, '"+locale+"', '1') ) from_source_desc, op_get_desc.op_clinic (from_facility_id, from_locn_code, '"+locale+"', '1' ) from_locn_desc, DECODE (from_ref_type, 'X', NVL (from_pract_name, am_get_desc.am_ext_practitioner (from_pract_id, '"+locale+"', '1' ) ), am_get_desc.am_practitioner (from_pract_id, '"+locale+"', '1') ) from_pract_name FROM pr_referral_search_vw a WHERE to_facility_id = '"+Facility_Id+"' AND ( (TRUNC (preferred_treatment_date) = TRUNC (SYSDATE)) OR (preferred_treatment_date IS NULL) ) AND close_encounter_id IS NULL AND TRUNC (added_date) BETWEEN TO_DATE (TO_CHAR (SYSDATE - 30, 'DD/MM/YYYY' ), 'DD/MM/RRRR' ) AND TO_DATE (TO_CHAR (SYSDATE, 'dd/mm/yyyy'), 'DD/MM/RRRR' ) AND to_locn_type IN ('C')  AND to_speciality_code = '"+Speciality+"' AND patient_id = '"+patient_id+"' ORDER BY referral_priority, created_date DESC, referral_id");

//Commented for MMS-DM-CRF-0223 BY KAMATCHI S
/*sqlRef.append("SELECT patient_id, to_locn_code, to_locn_type, from_locn_code, referral_priority, a.added_date created_date, referral_id, TO_CHAR (a.added_date, 'dd/mm/yyyy') added_date, TO_CHAR (preferred_treatment_date, 'dd/mm/yyyy') preferred_date, DECODE (from_ref_type, 'X', am_get_desc.am_referral (from_ref_code, '"+locale+"', 1), sm_get_desc.sm_facility_param (from_facility_id, '"+locale+"', '1') ) from_source_desc, op_get_desc.op_clinic (from_facility_id, from_locn_code, '"+locale+"', '1' ) from_locn_desc, DECODE (from_ref_type, 'X', NVL (from_pract_name, am_get_desc.am_ext_practitioner (from_pract_id, '"+locale+"', '1' ) ), am_get_desc.am_practitioner (from_pract_id, '"+locale+"', '1') ) from_pract_name FROM pr_referral_search_vw a WHERE to_facility_id = '"+Facility_Id+"' AND ( (TRUNC (preferred_treatment_date) = TRUNC (SYSDATE)) OR (preferred_treatment_date IS NULL) ) AND close_encounter_id IS NULL AND TRUNC (added_date) BETWEEN TO_DATE (TO_CHAR (SYSDATE - 30, 'DD/MM/YYYY' ), 'DD/MM/RRRR' ) AND TO_DATE (TO_CHAR (SYSDATE, 'dd/mm/yyyy'), 'DD/MM/RRRR' ) AND to_locn_code = '"+selected_loc_code+"' AND to_locn_type IN ('E','C') AND patient_id = '"+patient_id+"' ORDER BY referral_priority, created_date DESC, referral_id");*/					
					pstmtRef = con.prepareStatement(sqlRef.toString());
              
					rsRef = pstmtRef.executeQuery();
				}

				
            _bw.write(_wl_block12Bytes, _wl_block12);
if(isImproveReferralProcessAppl){
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
}
            _bw.write(_wl_block17Bytes, _wl_block17);
						
						while( rs.next() ) 
						{if(count==0){
							
            _bw.write(_wl_block18Bytes, _wl_block18);
if(isImproveReferralProcessAppl){
            _bw.write(_wl_block19Bytes, _wl_block19);
}else{
            _bw.write(_wl_block20Bytes, _wl_block20);
}
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(nat_id_prompt));
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
if(isPractoApptApplYN){
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
}
            _bw.write(_wl_block34Bytes, _wl_block34);
count++;}
							
							if (row_even_or_odd == 1)
							{
								row_even_or_odd = 2;
								classValue = "QRYODD";
							}
							else
							{
								classValue = "QRYEVEN";                 
								row_even_or_odd = 1;                    
							    }
							
							q_patient_id=(rs.getString("patient_id") == null)?"":rs.getString("patient_id");					

							q_appt_time=(rs.getString("appt_time") == null)?"":rs.getString("appt_time");
											
							status = rs.getString("appt_status");
							if(status == null ) status = "";
							
							patientName  = rs.getString("patient_name");
							if(patientName == null ) patientName = "";

							resource_class=rs.getString("resource_class");
							if(resource_class == null ) resource_class = "";

						resource_desc=rs.getString("resource_desc")==null?"":rs.getString("resource_desc");

							if(resource_desc.equals("P"))
							{
							resource_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
							
							
							}else if(resource_desc.equals("R"))
							{
							resource_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
							
							
							}else if(resource_desc.equals("E"))
							{
							resource_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
							}else if(resource_desc.equals("O"))
							{
						resource_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels");
							}


									
							location = rs.getString("clinic_desc");
							if(location == null ) location ="";
							
							practitioner = rs.getString("practitioner_name");
							if(practitioner == null ) practitioner = "";



							//if(resource_class.equals("P"))
							//{
								practitioner_id=rs.getString("practitioner_id");	
								
							//}
							//Added for the CRF Bru-HIMS-CRF-0198 - start
								multi_speciality_yn=rs.getString("multi_speciality_yn")==null?"N":rs.getString("multi_speciality_yn");
							    
							    if(multi_speciality_yn.equals("Y")){
							    	speciality_code=rs.getString("SPECIALITY_CODE")==null?"":rs.getString("SPECIALITY_CODE");
							    	multi_pract_sql="select practitioner_id, practitioner_name from am_practitioner_lang_vw where PRIMARY_SPECIALITY_CODE='"+speciality_code+"' and language_id='"+locale+"'";
							    	multiPrepdStmt   = con.prepareStatement(multi_pract_sql);				
							    	multirset = multiPrepdStmt.executeQuery();
							    	if(multirset!=null && multirset.next()){
							    		practitioner_id=multirset.getString("practitioner_id");							    		
							    	}
							    }
							    if(multirset!=null) multirset.close();
							    if(multiPrepdStmt!=null)multiPrepdStmt.close();
							  //Added for the CRF Bru-HIMS-CRF-0198 - End

							if(practitioner_id == null ) practitioner_id = "";
							
							q_appt_ref_no = rs.getString("appt_ref_no");
							if(q_appt_ref_no == null ) q_appt_ref_no = "";				

							nationality = rs.getString("nationality");
							if(nationality == null ) nationality = "";

							national_id_no = rs.getString("national_id_no");
							if(national_id_no == null ) national_id_no = "";
							contact_reason_code=(rs.getString("contact_reason_code") == null)?"":rs.getString("contact_reason_code");
                           reason=(rs.getString("reason") == null)?"":rs.getString("reason");
							if(or_install_yn.equals("Y"))
							{
								ordering_facility_id=(rs.getString("ordering_facility_id") == null)?"":rs.getString("ordering_facility_id");
								order_id=(rs.getString("order_id") == null)?"":rs.getString("order_id");
								order_line_num=(rs.getString("order_line_num") == null)?"":rs.getString("order_line_num");
								order_type_code=(rs.getString("order_type_code") == null)?"":rs.getString("order_type_code");	
								order_catalog_code=(rs.getString("order_catlog_code") == null)?"":rs.getString("order_catlog_code");
								order_catalog_desc=(rs.getString("order_catalog_desc") == null)?"":rs.getString("order_catalog_desc");
							        }
							

							referral_id=(rs.getString("referral_id") == null)?"":rs.getString("referral_id");

							String referral_id_dis = "";

							if(referral_id.equals(""))
								referral_id_dis = "&nbsp;";
							else
								referral_id_dis = referral_id;

							recur_wo_sec_res=(rs.getString("recur_wo_sec_res") == null)?"":rs.getString("recur_wo_sec_res");
							ref_reg_yn = "";
							locn_type=(rs.getString("clinic_type") == null)?"":rs.getString("clinic_type");
							locn_code=(rs.getString("clinic_code") == null)?"":rs.getString("clinic_code");	
							
							service_code=(rs.getString("service_code") == null)?"":rs.getString("service_code");					
							/*Added By Dharma on 25th June 2019 against KDAH-CRF-0525.1 [IN:070446] Start*/
							ext_appt_ref_no=(rs.getString("EXT_APPT_REF_NO") == null)?"":rs.getString("EXT_APPT_REF_NO");	
							isPractoApptYn = "N";
							if(!ext_appt_ref_no.equals(""))
								isPractoApptYn = "Y";
							/*Added By Dharma on 25th June 2019 against KDAH-CRF-0525.1 [IN:070446] End*/
									
// naren - check and remove it										
					/*		cs = con.prepareCall("{call GET_ACCESS_RIGHTS_FOR_OPER_STN(?,?,?,?,?)}") ;
							cs.setString(1, Facility_Id);
							cs.setString(2, userid);    
							cs.setString(3, locn_type);    
							cs.setString(4, locn_code);    
							cs.registerOutParameter( 5,java.sql.Types.VARCHAR);
							cs.execute() ;
							if(cs.getString(5) == null || cs.getString(5).equals("null")) 
								retunVal = "";
							else
								retunVal = cs.getString(5);

							if(!retunVal.equals(""))
							   ref_reg_yn = retunVal.substring(8,9);
										
							if(cs != null)  cs.close() ;  */                            
										
							
            _bw.write(_wl_block35Bytes, _wl_block35);


							//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
							if(isImproveReferralProcessAppl){ 
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(q_patient_id));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(locn_code));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(q_appt_ref_no));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(rs.getString(10)));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(rs.getString(8)));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(resource_class));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(ordering_facility_id));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(order_type_code));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(order_catalog_desc));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(referral_id));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(ref_reg_yn));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(recur_wo_sec_res));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(q_appt_ref_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(functionId));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(contact_reason_code));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(reason));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(locn_type));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(service_code));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(visit_for_inpat_yn));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(q_appt_time));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(multi_speciality_yn));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(isPractoApptYn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(q_appt_ref_no));
            _bw.write(_wl_block43Bytes, _wl_block43);

							}else{
							if(!cur_appt_ref_no.equals(q_appt_ref_no))
							{
								
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(q_patient_id));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(locn_code));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(q_appt_ref_no));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(rs.getString(10)));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(rs.getString(8)));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(resource_class));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(ordering_facility_id));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(order_type_code));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(order_catalog_desc));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(referral_id));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(ref_reg_yn));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(recur_wo_sec_res));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(q_appt_ref_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(functionId));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(contact_reason_code));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(reason));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(locn_type));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(service_code));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(visit_for_inpat_yn));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(q_appt_time));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(multi_speciality_yn));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(isPractoApptYn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(q_appt_ref_no));
            _bw.write(_wl_block43Bytes, _wl_block43);

							   }
							     else
							    {
							     
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(q_appt_ref_no));
            _bw.write(_wl_block45Bytes, _wl_block45);

						    	} 
							}
            _bw.write(_wl_block46Bytes, _wl_block46);
 if(!q_appt_time.equals(""))
							         { 
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(q_appt_time));
            _bw.write(_wl_block45Bytes, _wl_block45);
} else {   
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(nbsp_disp));
            _bw.write(_wl_block50Bytes, _wl_block50);
}
            _bw.write(_wl_block51Bytes, _wl_block51);
 if(!patientName.equals(""))
							         { 
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(patientName));
            _bw.write(_wl_block53Bytes, _wl_block53);
} else {   
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(nbsp_disp));
            _bw.write(_wl_block56Bytes, _wl_block56);
}
            _bw.write(_wl_block57Bytes, _wl_block57);
 if(!q_patient_id.equals(""))
							         { 
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(q_patient_id));
            _bw.write(_wl_block59Bytes, _wl_block59);
} else {   
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(nbsp_disp));
            _bw.write(_wl_block59Bytes, _wl_block59);
}
            _bw.write(_wl_block61Bytes, _wl_block61);
 if(!national_id_no.equals(""))
							       { 
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(national_id_no));
            _bw.write(_wl_block62Bytes, _wl_block62);
} else {   
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(nbsp_disp));
            _bw.write(_wl_block56Bytes, _wl_block56);
}
            _bw.write(_wl_block65Bytes, _wl_block65);
 if(!nationality.equals(""))
						      	 { 
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(nationality));
            _bw.write(_wl_block67Bytes, _wl_block67);
} else {   
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(nbsp_disp));
            _bw.write(_wl_block56Bytes, _wl_block56);
}
            _bw.write(_wl_block69Bytes, _wl_block69);
 if(!location.equals(""))
							        { 
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(location));
            _bw.write(_wl_block71Bytes, _wl_block71);
} else {   
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(nbsp_disp));
            _bw.write(_wl_block73Bytes, _wl_block73);
}
            _bw.write(_wl_block74Bytes, _wl_block74);
 if(!resource_desc.equals("") && !practitioner.equals(""))
							        { 
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(resource_desc));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(practitioner));
            _bw.write(_wl_block77Bytes, _wl_block77);
} else {   
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(nbsp_disp));
            _bw.write(_wl_block73Bytes, _wl_block73);
}
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(referral_id_dis));
            _bw.write(_wl_block81Bytes, _wl_block81);
if(isPractoApptApplYN && isSlotStartMidEndAppl){
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block80Bytes, _wl_block80);
if(isPractoApptYn.equals("Y")){

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
}else{

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
}
            _bw.write(_wl_block82Bytes, _wl_block82);
}else if(isPractoApptApplYN && !isSlotStartMidEndAppl){
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block80Bytes, _wl_block80);
if(isPractoApptYn.equals("Y")){

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
}else{

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
}
            _bw.write(_wl_block82Bytes, _wl_block82);
}
            _bw.write(_wl_block83Bytes, _wl_block83);
							   
						}

						
            _bw.write(_wl_block84Bytes, _wl_block84);

					//}	
	
				/*Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187*/
				if(isImproveReferralProcessAppl && !selected_loc_code.equals("")){
					while( rsRef.next()) 
					{
						if(ref_count==0){
						
            _bw.write(_wl_block85Bytes, _wl_block85);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block86Bytes, _wl_block86);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block86Bytes, _wl_block86);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block87Bytes, _wl_block87);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block88Bytes, _wl_block88);

						ref_count++;
						}

						if (row_even_or_odd == 1)
						{
						row_even_or_odd = 2;
						classValue = "QRYODD";
						}
						else
						{
						classValue = "QRYEVEN";                 
						row_even_or_odd = 1;                    
						}

						q_referral_id = (rsRef.getString("referral_id") == null)?"":rsRef.getString("referral_id");

						q_added_date = (rsRef.getString("added_date") == null)?"":rsRef.getString("added_date");

						q_preferred_date = (rsRef.getString("preferred_date") == null)?"":rsRef.getString("preferred_date");

						from_referral.setLength(0);

						if(rsRef.getString("from_source_desc")!=null && rsRef.getString("from_source_desc") !="")
						from_referral.append(rsRef.getString("from_source_desc")).append("<br>");

						if(rsRef.getString("from_locn_desc")!=null && rsRef.getString("from_locn_desc") !="")
						from_referral.append(rsRef.getString("from_locn_desc")).append("<br>"); 

						if(rsRef.getString("from_pract_name")!=null && rsRef.getString("from_pract_name") !="")
						from_referral.append(rsRef.getString("from_pract_name"));

						if(from_referral.toString().equals("")) from_referral.append("&nbsp;");

						q_from_referral = from_referral.toString();

						q_referral_priority = (rsRef.getString("referral_priority") == null)?"":rsRef.getString("referral_priority");
						
						if(!q_referral_priority.equalsIgnoreCase(q_prev_referral_priority)) {
						out.println("<tr>");
						out.println("<td colspan = 10 align = 'left' class='CAGROUPHEADING' nowrap><font size='1'>");

						if((q_referral_priority.equalsIgnoreCase("E"))) 
						out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels"));
						if((q_referral_priority.equalsIgnoreCase("L")))
						out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.elective.label","common_labels"));
						if((q_referral_priority.equalsIgnoreCase("U"))) 
						out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.semiemergency.label","common_labels"));
						
						out.println("</td></tr>");
						}
						q_prev_referral_priority = q_referral_priority;
						
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(q_referral_id));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(q_referral_id));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(q_referral_id));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(q_added_date));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(q_preferred_date));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(q_from_referral));
            _bw.write(_wl_block97Bytes, _wl_block97);
							   
					}	
            _bw.write(_wl_block98Bytes, _wl_block98);
}
				/*End MMS-DM-CRF-0187*/
					 
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					sql1.setLength(0);

					if(rsRef != null) rsRef.close();
					if(pstmtRef != null) pstmtRef.close();
					sqlRef.setLength(0);
					from_referral.setLength(0);
       
				}


            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(register_visit_walkin));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(register_visit_referral));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(bl_interface_yn));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(build_episode_rule));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(or_install_yn));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(oa_install_yn));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(reason));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(contact_reason_code));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(emer_regn_allow_yn));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(call_from));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(practitioner));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(multi_speciality_yn));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(count));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(ref_count));
            _bw.write(_wl_block114Bytes, _wl_block114);

			}catch(Exception e) { out.println(e.toString());}
finally 
{
	try{
	if(rs != null)   rs.close();
	if(pstmt != null) pstmt.close();

	if(rsRef != null) rsRef.close();
	if(pstmtRef != null) pstmtRef.close();

	}catch(Exception ee){}


	if(con != null) ConnectionManager.returnConnection(con,request);
}
			
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block115Bytes, _wl_block115);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Appointment.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.List.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referral.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.List.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOP.todayapptfor.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${op_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.apptno.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.time.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nationality.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.resource.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referralid.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.AppointmentSource.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.BruHealth.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EM.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.Practo.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EM.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referralid.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CreatedOn.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PreferredDate.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReferredFrom.label", java.lang.String .class,"key"));
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
}
