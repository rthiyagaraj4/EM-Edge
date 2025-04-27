package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import eCommon.XSSRequestWrapper;
import webbeans.eCommon.ConnectionManager;
import eXH.XHDBAdapter;
import java.sql.*;
import java.util.*;
import eXH.*;
import webbeans.eCommon.ConnectionManager;
import java.net.*;
import java.util.*;
import com.ehis.util.*;

public final class __communicationclientmaster extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/CommunicationClientMaster.jsp", 1742462139776L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- Comment added on 2/7/2008 --> \n<HTML>\t     \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<HEAD>\t\t\t\t    \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n \t\t\t\t\t   \n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link> \n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\t\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\" ></script>\n<script language=\'javascript\' src=\'../../eXH/js/CommnClients.js\'></script>\t\t\t\t\t\t\t\t\t \n<script language=\"javascript\" src=\"../../eXH/js/Validate.js\" ></script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n<script Language=\"JavaScript\"  src=\"../../eCommon/js/ValidateControl.js\" ></script>\n<script language=\'javascript\' src=\'../../eXH/js/ExternalApplication.js\'></script>\n\t<Script src=\"../../eCommon/js/jquery-3.6.3.js\" language=\"JavaScript\"></Script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n</HEAD>\t\t\t\t\t\t \n\n<BODY  leftmargin=0 topmargin=0 onMouseDown=\"CodeArrest()\" onKeyDown =\'lockKey()\' onLoad=\'onLoadOfpage();forwardRequest();\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<form name=\"Master_client_comm_form\" id=\"Master_client_comm_form\" method=\'post\' action=\'../../servlet/eXH.CommunicationClientMasterServlet\'>\n<table cellpadding=3 width=\"100%\" align=center>\n\n<tr>\n<td class=label >";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n<td class=\'fields\'>\n\t<input type=text name=client_id id=client_id size=20 maxlength=\"20\" value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' title=\'Client ID\' ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" onblur=\'ChangeUpperCase(this);checkSpecialChar(this);\'>\n\t<img src=\'../../eCommon/images/mandatory.gif\' align=middle>\n</td>\n<td class=\"label\">IP Address</td>\n<td>\n\t<input type=\"text\" name=\"inbound_tcp_addr\" id=\"inbound_tcp_addr\" size=\"20\" maxlength=\"15\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" title=\"IP Address (required if this gateway has to be started from application)\">\n</td>\n</tr>\n<tr>\n<td class=label >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n<td class=\'fields\'>\n\t<input type=text name =client_name size=20 maxlength=\"15\" value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' title=\'Client Name\'>\n\t<img src=\'../../eCommon/images/mandatory.gif\' align=middle>\n</td>\n<td class=\"label\">Port No</td>\n<td>\n\t<input type=\"text\" name=\"inbound_port_num\" id=\"inbound_port_num\" size=\"20\" maxlength=\"15\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" title=\"Port No (required if this gateway has to be started from application)\">\n</td>\n</tr>\n<tr>\n<td class=\"label\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n<td class=\'fields\'>\n\t<input type=checkbox name=main_outbound_in_use id=main_outbound_in_use ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" onClick=\'validatecheckbox(this);\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' flag=\'O\'>\n</td><td></td><td></td></tr>\n<tr>\n<td class=\"label\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n<td class=\'fields\'>\n\t<input type=checkbox name =main_inbound_in_use ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' flag=\'I\'>\n</td><td></td><td></td></tr>\n\n<tr>\n<td class=label >";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n<td class=\'fields\'><input type=checkbox name =main_in_use ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n\t\n</td></tr>\n\t<!--\n<tr>\n<td class=label ></td>\n<td class=\'fields\'>\n\n <input type=\'button\' class=\'button\' name=\'CheckEligibility\' id=\'CheckEligibility\' \n\t\t\t\t\t\t\t\t\t\t\t\t\tvalue=\'CheckEligibility\' \n\t\t\t\t\t\t\t\t\t\t\t\t\tonclick=\"openBLeligibilityCriteria();\">\n\n <input type=\'button\' class=\'button\' name=\'openePOS\' id=\'openePOS\' \n\t\t\t\t\t\t\t\t\t\t\t\t\tvalue=\'open POS\' \n\t\t\t\t\t\t\t\t\t\t\t\t\tonclick=\"OpenPOS();\">\n\n <input type=\'button\' class=\'button\' name=\'printUCAF\' id=\'printUCAF\' \n\t\t\t\t\t\t\t\t\t\t\t\t\tvalue=\'print UCAF\' \n\t\t\t\t\t\t\t\t\t\t\t\t\tonclick=\"openEpad();\">\n\n <input type=\'button\' class=\'button\' name=\'eNotification\' id=\'eNotification\' \n\t\t\t\t\t\t\t\t\t\t\t\t\tvalue=\'eNotification\' \n\t\t\t\t\t\t\t\t\t\t\t\t\tonclick=\"checkEnotification();\">\n\n</td></tr>\n-->\n</table>\n\n<table cellspacing=\'0\' cellpadding=\'0\' width=\'100%\' border=0 align=\'center\'>\n        <tr><td class=\'white\'>\n\t\t<ul id=\"tablist\" class=\"tablist\" style=padding-left:0px;>\n\t\t\t<li class=\"tablistitem\" title=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t\t\t\t<a onclick=\"callJSPs(\'out\')\" class=\"tabClicked\" id=\'out\' >\n\t\t\t\t\t<span class=\"tabAspan\" id=\"out_tabspan\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</span>\n\t\t\t\t</a>\n\t\t\t </li>\n\t\t\t <li class=\"tablistitem\" title=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\t\t\t\t<a onclick=\"callJSPs(\'inb\')\" class=\"tabA\" id=\"inb\" >\n\t\t\t\t\t<span class=\"tabAspan\" id=\"inb_tabspan\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</span>\n\t\t\t\t</a>\n\t\t   </li>\n\t\t   </ul>\n\t </td>\n   </tr>\n</table>\n  \n<!---------------------------------outbound------------------------------>\n<div id=\'outbounddiv\' style=\'display:none\'>\n<table border=1 cellspacing=0 cellpadding=3 width=\'100%\' align=center>\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n<table border=1 cellspacing=0 cellpadding=3 width=\'100%\' align=center>\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n<tr>\n\t<td colspan=\"5\" align=\"right\" class=\"CAGROUP\">\n\t<A class=\'label\' style=\'cursor:pointer\' onClick=\"funAction(\'P\')\">";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</A>\n\t<A class=\'label\' style=\'cursor:pointer\' onClick=\"funAction(\'N\')\">";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</A>\n\t</td>\n</tr>\n<tr>\n<td class=\'COLUMNHEADER\' colspan=4 align=center>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>\n</tr>\n<tr></tr>\n<tr>\n\t<td class=\'COLUMNHEADER\' width=\'30%\'>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td>\n\t<td class=\'COLUMNHEADER\' width=\'20%\'>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\t\n\t<td class=\'COLUMNHEADER\' width=\'20%\'>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</td>\t\n\t<td class=\'COLUMNHEADER\' width=\'10%\'>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</td>\t\n</tr>\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n<tr>\t\t\t\t\t  \n\t\n\t<input type=\"hidden\" id=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' name=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'> \n\n\t<td class=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' width=\"25%\">\n\t\t<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\" value=\"XX\">\n\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =" <font color=green> ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =" </font> ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t</td>\t\t\t\n\n\t<td class=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' width=\"35%\">\n\t\t\n\t\t<input type=\"hidden\" name=\"PID\" id=\"PID\" value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n\t\t\t\n\n\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\t\t   \n\t\t <input type=\"hidden\" id=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" name=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\"> \t\t\n\t\t<input type=\"text\" size=\"40\" id=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' \n\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =" name=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" id=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'\n\t\tonBlur=\"protocolLink(\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\',\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\',\'O\');\">\n\t\t\t\n\t\t<input type=\"hidden\" id=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\t\t\t    \n\t\t\n\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t<input class=\'BUTTON\' type=\"button\" name=protocolLinkVal id=protocolLinkVal value=\'?\'\t\t\n\t\tonClick=\"protocolLink(\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\',\'O\');\">\n\t\t<img src=\'../../eCommon/images/mandatory.gif\' align=middle>\n\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\n\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t<input type=\"button\" class=\'BUTTON\' name=protocolLinkVal id=protocolLinkVal value=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\'\n\t\t\tonClick=\"addProtocolLinkID(\t\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\',\n\t\t\t\t\t\t\t\t\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\',\n\t\t\t\t\t\t\t\t\'O\',\n\t\t\t\t\t\t\t\t\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\');\">\t\t\n\n\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t</td>\n\t<td class=\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\' width=\"20%\">\n\t\t<div id=\'out_";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="_cb\' ";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 =">\n\t\t\t<INPUT TYPE=\"text\" NAME=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="_reportOPDir1\" maxlength=\"100\" ID=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="_reportOPDir1\" VALUE=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" onBlur=\"pathValidation(this,";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="_reportOPDir)\">\t\t\n\t\t<img src=\'../../eCommon/images/mandatory.gif\' align=middle>\n\t\t</div>\n\t\t<div id=\'out_";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="_cb_nodisp\' ";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="_reportOPDir2\" VALUE=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="_reportOPDir)\">\n\t\t</div>\n\t\t<input type=\"hidden\" NAME=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="_reportOPDir\" ID=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="_reportOPDir\" VALUE=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\">\n\t</td>\n\n\t<td class=\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\' align=\"center\" width=\"10%\">\t\t\n\t\t<input type=checkbox name=\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\' ";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 =" flag=\'O\' id=\'out_";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\' onClick=validatecheckbox1(this,\'out_";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="_cb\',\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="_reportOPDir\',\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\',\'out_";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\');\t\t   value=\'";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\'>\n\t</td>\t\n</tr>\t\t\t\t    \n\t\t\n";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t<tr>\n\t\t<td colspan=6 class=label><img src=\'../../eXH/images/green_square.jpg\' width=40 height=15 >";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="</td>\n\t\t</tr>\n";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n</table>\n<br></br>\n</div>\n\n<!----------------------------------inbound------------------------->\n<div id=\'inbounddiv\' style=\'display:none\'>\n<table border=0 cellspacing=0 cellpadding=3 width=\'100%\' align=center>\n<tr>\n<td class=\'COLUMNHEADER\' colspan=2 align=center>";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="</td>\n</tr>\n<tr></tr>\n</table>\n";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n<table border=1 cellspacing=0 cellpadding=3 width=\'100%\' align=center>\n\n";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\n<tr>\n\t<td colspan=\"5\" align=\"right\" class=\"CAGROUP\">\n\t<A class=\'label\' style=\'cursor:pointer\' onClick=\"funAction(\'PI\')\">";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="</A>\n\t<A class=\'label\' style=\'cursor:pointer\' onClick=\"funAction(\'NI\')\">";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="</A>\n\t</td>\n</tr>\n<tr>\n<td class=\'COLUMNHEADER\' width=\'30%\'>";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="</td>\n<td class=\'COLUMNHEADER\' width=\'20%\'>";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="</td>\n<td class=\'COLUMNHEADER\' width=\'10%\'>";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="</td>\n</tr>\n";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n\t<tr>\n\t<input type=\"hidden\" id=\'";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\'> \n\t<td class=\'";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\' width=\"25%\">\n\t";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 =" \n\t\t<font color=green> \n\t";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 =" \n\t\t</font> \n\t";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\t</td>\t\t\t\n\t<td class=\'";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\' width=\"35%\">\n\t\t\t\n\t";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\t\t\t\t\t\n\t<input type=\"text\" size=\"40\" id=";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 =" value=\'";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\' \n\t";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\"\tid=\'";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\'\n\tonBlur=\"protocolLink(\'";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\',\'I\');\">\t  \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\t<input type=\"hidden\" id=\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\">\n\t <input type=\"hidden\" id=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\">   \n\t";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\n\t<input class=\'BUTTON\' type=\"button\" name=protocolLinkVal id=protocolLinkVal value=\'?\' onClick=\"protocolLink(\'";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\',\'I\');\">\n\t<img src=\'../../eCommon/images/mandatory.gif\' align=middle>\n\t";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    \n\n\t";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\n\t<input type=\"button\" class=\'BUTTON\' name=protocolLinkVal id=protocolLinkVal value=\'";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\'\n\tonClick=\"addProtocolLinkID(\'";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\',\n\t\t\t\t\t\t\'";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\',\t\t\t\t\n\t\t\t\t\t\t\'";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\',\n\t\t\t\t\t\t\'I\',\'";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\');\">\t\t\t\n\n\t";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\n\n\t</td>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \n\t<td class=\'";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\' width=\"20%\">\t\t\n\t\t<div id=\"in_";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="_cb\" name=\"in_";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="_cb\" ";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="_reportOPDir)\">\n\t\t\t<img src=\'../../eCommon/images/mandatory.gif\' align=middle>\n\t\t</div>\n\t\t<div id=\"in_";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="_cb_nodisp\" ";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="_reportOPDir2\" maxlength=\"100\" ID=\"";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="_reportOPDir)\">\t\t\t\n\t\t</div>\n\t\t<input type=\"hidden\" NAME=\"";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\">\n\t</td>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \n\n\t<td class=\'";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\' align=\"center\" width=\"10%\">\t\t\t\t\n\t\t<input type=\"checkbox\" name=\'";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 =" flag=\'I\' id=\'in_";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\' onClick=validatecheckbox1(this,\'in_";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\',\'in_";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\')   value=\'";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\' INBOUND_APPLICATION_ID=\'";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\'>\n\t</td>\n\t</tr>\n";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\n\t\t<tr>\n\t\t\t<td colspan=6 class=label><img src=\'../../eXH/images/green_square.jpg\' width=40 height=15 >\n\t\t\t\t";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\n\t\t\t</td>\n\t\t</tr>\n";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\n</table>\n<br></br>\n</div>\n<input type=\"hidden\" name=tab_mode id=tab_mode value=\'";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\'>\n<input type=\"hidden\" name=message id=message id=\"message\" value=\'";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\'>\n<input type=\"hidden\" name=locale id=locale value=\'";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\'/>\n<input type=\"hidden\" name=mode id=mode value=\'";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\'/>\n<input type=\"hidden\" name=flag id=flag />\n<input type=\'hidden\' name=\'action_type\' id=\'action_type\' value=\'R\'>\n<input type=\'hidden\' name=\'OUTBOUND_YN\' id=\'OUTBOUND_YN\' id=\'OUTBOUND_YN\' value=\'";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\'>\n<input type=\'hidden\' name=\'INBOUND_YN\' id=\'INBOUND_YN\' id=\'INBOUND_YN\' value=\'";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\'>\n<input type=\'hidden\' name=\'IN_USE_YN\' id=\'IN_USE_YN\' id=\'IN_USE_YN\' value=\'";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\'>\t\n\n<input type=\'hidden\' name=\'dmode\' id=\'dmode\' value=\'";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\'>\n<input type=\'hidden\' name=\'id\' id=\'id\' value=\'";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\'>\n<input type=\'hidden\' name=\'inID\' id=\'inID\' value=\'";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\'>\n<input type=\'hidden\' id=\"update_mode\" name=\'update_mode\' id=\'update_mode\' value=\'\'>\n<input type=\'hidden\' id=\"del_application_id\" name=\'del_application_id\' id=\'del_application_id\' value=\'\'>\n<input type=\'hidden\' id=\"del_facility_id\" name=\'del_facility_id\' id=\'del_facility_id\' value=\'\'>\n<input type=\'hidden\' id=\"del_protocol_link\" name=\'del_protocol_link\' id=\'del_protocol_link\' value=\'\'>\n<input type=\'hidden\' id=\"del_client_id\" name=\'del_client_id\' id=\'del_client_id\' value=\'\'>\n<input type=\'hidden\' id=\"forward_request\" name=\'del_client_id\' id=\'del_client_id\' value=\'";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\'>\n\n\n\t";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\n<input type=\'hidden\' name=\'inbound_tcp_addr\' id=\'inbound_tcp_addr\' value=\'000.00.000.000\'>\n<input type=\'hidden\' name=\'inbound_port_num\' id=\'inbound_port_num\' value=\'0000\'>\n</form>\t\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);

request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
String locale = ((String)session.getAttribute("LOCALE"));

            _bw.write(_wl_block5Bytes, _wl_block5);

try
{	
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
System.out.println("PATH 11 "+request.getRequestURI());
System.out.println("PATH 12 "+request.getContextPath());

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

String CLIENT_ID = "";              
String CLIENT_NAME = "";            
String OUTBOUND_YN = "";            		 
String INBOUND_YN = "";             
String INBOUND_IP_ADDRESS = "";     	  
String INBOUND_PORT_NUMBER = "";    
String INBOUND_IP_ADDRESSF = "";     
String INBOUND_PORT_NUMBERF = ""; 
String IN_USE_YN = "Y";              
String INBOUND_APPLICATION_ID = ""; 
String INBOUND_PROTOCOL_LINK_ID = "";
String OUTBOUND_APPLICATION_ID = "";
//String INBOUND_FACILITY_ID = "";
//String OUTBOUND_FACILITY_ID=""; 
String PROTOCOL_LINK_ID = "";      
String IN_USE_YN_COMM = "";
String mode = request.getParameter("mode");
String reportOPDir = "";

CLIENT_ID = XHDBAdapter.checkNull(request.getParameter("client_id"));
CLIENT_NAME = XHDBAdapter.checkNull(request.getParameter("client_name"));
OUTBOUND_YN = XHDBAdapter.checkNull(request.getParameter("main_outbound_in_use"));
INBOUND_YN = XHDBAdapter.checkNull(request.getParameter("main_inbound_in_use"));
IN_USE_YN = XHDBAdapter.checkNull(request.getParameter("main_in_use"));
INBOUND_IP_ADDRESS = XHDBAdapter.checkNull(request.getParameter("inbound_tcp_addr"));
INBOUND_PORT_NUMBER = XHDBAdapter.checkNull(request.getParameter("inbound_port_num"));
String message = XHDBAdapter.checkNull(request.getParameter("message"));

String dmode = request.getParameter("dmode");
//String protocol_link_id = request.getParameter("protocol_link_id");

boolean updateMode = false;

ResultSet rs1=null;
Statement stmt1=null;
Connection con=null;
int id = 0;
int inID = 0;
String outboundID = "";
String inboundID = "";

String sql1="";
try
{
	con=ConnectionManager.getConnection();
}catch(Exception ex ){
	System.out.println("(CommunicationClientMaster:Exception) :"+ex.toString());}

if(INBOUND_IP_ADDRESS==null) INBOUND_IP_ADDRESSF=""; else INBOUND_IP_ADDRESSF=INBOUND_IP_ADDRESS;
if(INBOUND_PORT_NUMBER==null) INBOUND_PORT_NUMBERF=""; else INBOUND_PORT_NUMBERF=INBOUND_PORT_NUMBER;

if(mode.equals("U"))
{
	CLIENT_ID=request.getParameter("client_id");

	sql1="SELECT CLIENT_NAME,OUTBOUND_YN,INBOUND_YN,INBOUND_IP_ADDRESS,INBOUND_PORT_NUMBER,IN_USE_YN FROM XH_COMM_CLIENT WHERE CLIENT_ID='"+CLIENT_ID+"'";
	try
	{
		if(mode != null && mode.equalsIgnoreCase("U")) updateMode = true;

		stmt1=con.createStatement();
		rs1=stmt1.executeQuery(sql1);
		if(rs1.next())
		{
			CLIENT_NAME = rs1.getString(1);
			OUTBOUND_YN = rs1.getString(2);
			INBOUND_YN = rs1.getString(3);
			INBOUND_IP_ADDRESS = rs1.getString(4);
			INBOUND_PORT_NUMBER = rs1.getString(5);
			IN_USE_YN = rs1.getString(6);
		}
		if(INBOUND_IP_ADDRESS==null) INBOUND_IP_ADDRESSF=""; else INBOUND_IP_ADDRESSF = INBOUND_IP_ADDRESS;
		if(INBOUND_PORT_NUMBER==null) INBOUND_PORT_NUMBERF=""; else INBOUND_PORT_NUMBERF = INBOUND_PORT_NUMBER;

	}
	catch(Exception e1)
	{
		System.out.println("(CommunicationClientMaster:Exception-1) "+e1.toString());
		e1.printStackTrace(System.err);
	}
	finally
	{
		try
		{
			if(rs1!=null)rs1.close();
			if(stmt1!=null)stmt1.close();				
		}
		catch(Exception e)
		{
			out.println("(CommunicationClientMaster:Exception-2) "+e);
		}
	}//end of finally block
}//end of mode=U

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(CLIENT_ID));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(mode.equals("U")?"readonly":""));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf( INBOUND_IP_ADDRESSF ));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(CLIENT_NAME));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf( INBOUND_PORT_NUMBERF ));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(OUTBOUND_YN.equals("Y")?"checked":""));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(OUTBOUND_YN.equals("Y")?"Y":"N"));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(INBOUND_YN.equals("Y")?"checked":""));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(INBOUND_YN.equals("Y")?"Y":"N"));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(IN_USE_YN.equals("Y")?"checked":""));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(IN_USE_YN.equals("Y")?"Y":"N"));
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


boolean boolToggle =  true;	
String strTDClass = "";
String strBeanName = XHFacilityControllerBean.strBeanName;
try
{
	XHFacilityControllerBean	xhBean = XHFacilityControllerBean.getBean(strBeanName,request,session);
	xhBean.action(request,con);
	HashMap resultsQry1 = xhBean.getResultSet();
	ArrayList arrRow1 = (ArrayList)resultsQry1.get("qry_result"); 
	ArrayList arrCol1 = null;	
	boolean boolNext = ((Boolean)resultsQry1.get("next")).booleanValue(); 
	boolean boolPrevious = ((Boolean)resultsQry1.get("previous")).booleanValue(); 
	String strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
	String strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
	if (boolPrevious == true)
	{
		strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
	}
	else
	{
		strPrevious = " ";
	}
	if (boolNext== true)
	{
		strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
	}
	else
	{
		strNext  = " ";
	}
	
            _bw.write(_wl_block27Bytes, _wl_block27);

if(arrRow1.size()==0)
{

            _bw.write(_wl_block2Bytes, _wl_block2);
 } else { 
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(strPrevious));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(strNext));
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);

String outbound_status = "";
String outbound_disabled = "";
boolean outbound_status_color = false;
for (int j=0; j<arrRow1.size();j++)
{	
	arrCol1 = (ArrayList)arrRow1.get(j);
	if (boolToggle == true)
	{
		strTDClass = "QRYEVEN";
		boolToggle =  false;
	}
	else
	{
		strTDClass = "QRYODD";
		boolToggle =  true;
	}

	OUTBOUND_APPLICATION_ID = ((String)arrCol1.get(0)).equals("null")?"":(String)arrCol1.get(0);			
	IN_USE_YN_COMM = XHDBAdapter.checkNull((String)arrCol1.get(4));
	PROTOCOL_LINK_ID = XHDBAdapter.checkNull((String)arrCol1.get(5));
	
	String id_for_outbound_select = OUTBOUND_APPLICATION_ID+PROTOCOL_LINK_ID+"_OUTBOUND_SELECT";


	outbound_status = XHDBAdapter.checkNull((String)arrCol1.get(7));
	outbound_disabled = "";	
	reportOPDir = XHDBAdapter.checkNull((String)arrCol1.get(8)); 

            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(id_for_outbound_select));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(id_for_outbound_select+"APP"));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(OUTBOUND_APPLICATION_ID));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block40Bytes, _wl_block40);
if(outbound_status != null && outbound_status.equalsIgnoreCase("Y")) { 
		outbound_status_color = true;
		outbound_disabled = "disabled"; 
            _bw.write(_wl_block41Bytes, _wl_block41);
}
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(((String)arrCol1.get(1)).equals("null")?"":(String)arrCol1.get(1)));
            _bw.write(_wl_block42Bytes, _wl_block42);
if(outbound_status != null && outbound_status.equalsIgnoreCase("Y")) {
            _bw.write(_wl_block43Bytes, _wl_block43);
}
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf((String)arrCol1.get(5)));
            _bw.write(_wl_block46Bytes, _wl_block46);

			String protocolID = id_for_outbound_select+"_protocolLinkID"; 
			String protocolName = id_for_outbound_select+"_protocolLinkName";
				String protocolIDName=id_for_outbound_select+"_protocolID"; 
			outboundID = "out"+id;
			id++;			
		
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(protocolIDName));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(protocolIDName));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(((String)arrCol1.get(9))==null?"":(String)arrCol1.get(9)));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(outboundID));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(((String)arrCol1.get(5))==null?"":(String)arrCol1.get(6)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(updateMode?"disabled":""));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(protocolName));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(protocolName));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(protocolID));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(protocolName));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(id_for_outbound_select));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(protocolID));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(protocolID));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(((String)arrCol1.get(5))==null?"":(String)arrCol1.get(5)));
            _bw.write(_wl_block57Bytes, _wl_block57);
 if(!mode.equalsIgnoreCase("U")) { 
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(protocolID));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(protocolName));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(id_for_outbound_select));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(protocolIDName));
            _bw.write(_wl_block59Bytes, _wl_block59);
 } 
            _bw.write(_wl_block60Bytes, _wl_block60);
 if(mode.equalsIgnoreCase("U")) { 
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(OUTBOUND_APPLICATION_ID));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(((String)arrCol1.get(1)).equals("null")?"":(String)arrCol1.get(1)));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf((String)arrCol1.get(5)));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(CLIENT_ID));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(outboundID));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(CLIENT_NAME));
            _bw.write(_wl_block65Bytes, _wl_block65);
 } 
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(outboundID));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(IN_USE_YN_COMM.equals("Y")?"style='display:block;'":"style='display:none;'"));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(id_for_outbound_select));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(outboundID));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(reportOPDir));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(outboundID));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(outboundID));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(IN_USE_YN_COMM.equals("Y")?"style='display:none;'":"style='display:block;'"));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(id_for_outbound_select));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(outboundID));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(reportOPDir));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(outboundID));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(id_for_outbound_select));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(outboundID));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(reportOPDir));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(id_for_outbound_select));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(IN_USE_YN_COMM.equals("Y")?"checked":""));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(outboundID));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(outboundID));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(outboundID));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(protocolIDName));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(outboundID));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(IN_USE_YN_COMM.equals("Y")?"Y":"N"));
            _bw.write(_wl_block88Bytes, _wl_block88);

}
if(outbound_status_color) { 
            _bw.write(_wl_block89Bytes, _wl_block89);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block90Bytes, _wl_block90);
 } 
}
if(resultsQry1!=null) resultsQry1.clear();
if(arrCol1!=null) arrCol1.clear();
if(arrRow1!=null) arrRow1.clear();
}
catch(Exception exception)
{
	System.out.println("EXCEPTION IN  first CommunicationClientmasterOutbound.jsp :"+exception.toString());
	exception.printStackTrace(System.err);
}

            _bw.write(_wl_block91Bytes, _wl_block91);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block92Bytes, _wl_block92);

try
{ 
	String strBeanName1 = XHFacilityInboundControllerBean.strBeanName;
	XHFacilityInboundControllerBean	xhBean1 = XHFacilityInboundControllerBean.getBean(strBeanName1,request,session);
	xhBean1.action(request,con);
	HashMap resultsQry = xhBean1.getResultSet();
	ArrayList arrRow = (ArrayList)resultsQry.get("qry_result"); 
	ArrayList arrCol = null;
	boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
	boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
	String strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
	String strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
	if (boolPrevious == true)
	{
		strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
	}
	else
	{
		strPrevious = " ";
	}
	if (boolNext== true)
	{
		strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
	}
	else
	{
		strNext  = " ";
	}
	
            _bw.write(_wl_block93Bytes, _wl_block93);

if(arrRow.size()==0)
{

            _bw.write(_wl_block2Bytes, _wl_block2);
 } else { 
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(strPrevious));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(strNext));
            _bw.write(_wl_block96Bytes, _wl_block96);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block97Bytes, _wl_block97);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block97Bytes, _wl_block97);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block99Bytes, _wl_block99);

	boolean inbound_status_color = false;
boolToggle = true;
for (int j=0; j<arrRow.size();j++)
{
	arrCol = (ArrayList)arrRow.get(j);
	if (boolToggle == true)
	{
		strTDClass = "QRYEVEN";
		boolToggle =  false;
	}
	else
	{
		strTDClass = "QRYODD";
		boolToggle =  true;
	}

	INBOUND_APPLICATION_ID=((String)arrCol.get(0)).equals("null")?"":(String)arrCol.get(0);				
	INBOUND_PROTOCOL_LINK_ID=XHDBAdapter.checkNull((String)arrCol.get(5));			
	IN_USE_YN_COMM=((String)arrCol.get(4)).equals("null")?"":(String)arrCol.get(4);  

	String id_for_inbound_select = INBOUND_APPLICATION_ID+INBOUND_PROTOCOL_LINK_ID+"_INBOUND_SELECT";
	String inbound_status = XHDBAdapter.checkNull((String)arrCol.get(7));
	String inbound_disabled = "";
	reportOPDir = XHDBAdapter.checkNull((String)arrCol.get(8));

	
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(id_for_inbound_select));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(id_for_inbound_select+"APP"));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(INBOUND_APPLICATION_ID));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block102Bytes, _wl_block102);
if(inbound_status != null && inbound_status.equalsIgnoreCase("Y")) 
		{
		inbound_disabled="disabled";
		inbound_status_color = true;
	
            _bw.write(_wl_block103Bytes, _wl_block103);
}
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(((String)arrCol.get(1)).equals("null")?"":(String)arrCol.get(1)));
            _bw.write(_wl_block42Bytes, _wl_block42);
if(inbound_status != null && inbound_status.equalsIgnoreCase("Y")) {
            _bw.write(_wl_block104Bytes, _wl_block104);
}
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block106Bytes, _wl_block106);

		String inboundProtocolID = id_for_inbound_select+"_protocolLinkID"; 
		String inboundProtocolName = id_for_inbound_select+"_protocolLinkName";		    
		String proprotocolID=id_for_inbound_select+"_protocolID"; 
		inboundID = "in"+inID;
		inID++;				
	
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(inboundID));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(((String)arrCol.get(5))==null?"":(String)arrCol.get(6)));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(updateMode?"disabled":""));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(inboundProtocolName));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(inboundProtocolName));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(inboundProtocolID));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(inboundProtocolName));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(id_for_inbound_select));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(proprotocolID));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(inboundProtocolID));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(inboundProtocolID));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(((String)arrCol.get(5))==null?"":(String)arrCol.get(5)));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(proprotocolID));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(proprotocolID));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(((String)arrCol.get(9))==null?"":(String)arrCol.get(9)));
            _bw.write(_wl_block114Bytes, _wl_block114);
 if(!mode.equalsIgnoreCase("U")) { 
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(inboundProtocolID));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(inboundProtocolName));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(id_for_inbound_select));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(proprotocolID));
            _bw.write(_wl_block116Bytes, _wl_block116);
 } 
            _bw.write(_wl_block117Bytes, _wl_block117);
 if(mode.equalsIgnoreCase("U")) { 
            _bw.write(_wl_block118Bytes, _wl_block118);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(INBOUND_APPLICATION_ID));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(((String)arrCol.get(1)).equals("null")?"":(String)arrCol.get(1)));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(((String)arrCol.get(5))));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(CLIENT_ID));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(inboundID));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(CLIENT_NAME));
            _bw.write(_wl_block123Bytes, _wl_block123);
 } 
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(inboundID));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(inboundID));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(IN_USE_YN_COMM.equals("Y")?"style='display:block;'":"style='display:none;'"));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(id_for_inbound_select));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(inboundID));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(reportOPDir));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(inboundID));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(inboundID));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(IN_USE_YN_COMM.equals("Y")?"style='display:none;'":"style='display:block;'"));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(id_for_inbound_select));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(inboundID));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(reportOPDir));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(inboundID));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(id_for_inbound_select));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(inboundID));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(reportOPDir));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(id_for_inbound_select));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(IN_USE_YN_COMM.equals("Y")?"checked":""));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(inboundID));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(inboundID));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(inboundID));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(proprotocolID));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(inboundID));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(IN_USE_YN_COMM.equals("Y")?"Y":"N"));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(INBOUND_APPLICATION_ID));
            _bw.write(_wl_block139Bytes, _wl_block139);
 
}
if(inbound_status_color) { 

            _bw.write(_wl_block140Bytes, _wl_block140);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block141Bytes, _wl_block141);
}
}
if(resultsQry!=null) resultsQry.clear();
if(arrCol!=null) arrCol.clear();
if(arrRow!=null) arrRow.clear();
}
catch(Exception exception)
{
	System.out.println("EXCEPTION IN second coomunicationclientmasteroutbound.jsp :"+exception.toString());
	exception.printStackTrace(System.err);
}
finally
{
	ConnectionManager.returnConnection(con);
}

            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(message));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(OUTBOUND_YN));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(INBOUND_YN));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(IN_USE_YN));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(dmode));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(id));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(inID));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf((String)request.getParameter("forwardRequest")));
            _bw.write(_wl_block153Bytes, _wl_block153);

}
catch(Exception exp)
{
	exp.printStackTrace(System.err);
}	

            _bw.write(_wl_block154Bytes, _wl_block154);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.identification.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.Outbound.Label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.Inbound.Label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enabled.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.Outbound.Label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.Outbound.Label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.Inbound.Label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.Inbound.Label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.OutboundSettings.Label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Application.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.Protocol.Label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.LogDir.Label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enabled.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Add.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.Recently.Label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.InboundSettings.Label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Application.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.Protocol.Label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.LogDir.Label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enabled.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Add.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.Recently.Label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
