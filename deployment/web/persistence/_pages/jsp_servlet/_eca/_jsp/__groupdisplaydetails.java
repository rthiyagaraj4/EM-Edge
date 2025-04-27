package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCA.*;
import eCA.Common.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __groupdisplaydetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/GroupDisplayDetails.jsp", 1738424857247L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n    <head>\n    <style>\n    .test\n    {\n    clear: both;\n    }\n\n.container {\n\t/*overflow: scroll; -- commented for IN068145*/\n\t/*height: 50px;  -- commented for IN068145*/\n}\ntd span {\n\tfont-weight:bold;\n\tfont-size:12px;\n\t\n}\n.gridTooltipData\n{\n\tbackground-color: #FEFFE5;\n\tfont-family: Verdana;\n\tfont-size: 8pt;\n\tcolor: #000000;\n\tfont-weight:normal;\n\ttext-align:left;\n\tpadding-left:10px;\n\tpadding-right:10px;\n\tpadding-top:10px;\n\tpadding-bottom:10px;\n\tvertical-align:middle;\n\tborder-bottom:1px;\n\tborder-top:1px;\n\tborder-left:1px;\n\tborder-right:1px;\n\tborder-style:solid;\n\tborder-color:#DCDCDC;\n} \n.gridDataSelect\n{\n\tbackground-color: #CDE5FF;\n\tfont-family: Verdana;\n\tfont-size: 8pt;\n\tcolor: #000000;\n\tfont-weight:normal;\n\ttext-align:left;\n\tpadding-left:10px;\n\tpadding-right:10px;\n\tvertical-align:middle;\n\tborder-bottom:1px;\n\tborder-top:1px;\n\tborder-left:1px;\n\tborder-right:1px;\n\tborder-style:solid;\n\tborder-color:#0460B5;\n} \n    </style>\n    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n    <title>Untitled Document</title>\n\t<link rel=\"stylesheet\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\" type=\"text/css\" />\n    <link href=\"../../eCA/html/GroupDisplayStyle.css\" rel=\"stylesheet\" type=\"text/css\" />\n    <link href=\"../../eCA/html/GroupDisplayWeb.css\" rel=\"stylesheet\" type=\"text/css\" />\n    <script type=\"text/javascript\" src=\"../../eCA/js/GroupDisplay.js\"></script>\n    <script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n    <script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n\n    </head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n    <body>\n    <form name=\"grpdispdetail\" id=\"grpdispdetail\">\n    <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n      <tr>\n        <td align=\"left\" valign=\"middle\" class=\"HeaderMenu\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n            <tr>\n            ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n            <td width=\"4%\" align=\"left\" valign=\"top\" onclick=\"loadgroup(\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\')\" class=\"HeaderMenutxt HMselect\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n            ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\')\" class=\"HeaderMenutxt\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n           ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n             <td width=\"96%\" align=\"left\" valign=\"top\"  class=\"\">&nbsp;</td>\n          </tr>\n          </table></td>\n      </tr>\n      </table>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n<input type=\"hidden\" name=\"totaltreecount\" id=\"totaltreecount\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"/>\n\t <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"overflow:auto; position:relative;\">\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\t\n\t  <tr>\n        <td align=\"left\" valign=\"top\"><div>\n            <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n            <tr>\n                <td align=\"left\" valign=\"top\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"space\">\n                ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n                  <tr>\n                    <td align=\"left\" valign=\"top\" value=\"Y\" id=\"group";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" onclick=\"hidepanel(\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\')\" class=\"AcctxtimgSelect AcctxtimgSub\" >";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n                    <input type=\"hidden\" name=\"grpselectflg";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" id=\"grpselectflg";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" value=\'Y\'/>\n                    <input type=\"hidden\" name=\"grpid";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" id=\"grpid";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" value=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="/>\n                  </tr>\n                  ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n                  <tr>\n                    <td align=\"left\" valign=\"top\" value=\"N\" class=\"Acctxtimg\" id=\"group";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\')\" >";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" value=\'N\'/>\n                    <input type=\"hidden\" name=\"grpid";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n                  <tr>\n                    <td style=\"display:none\" id=\"panelview";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" value=\"N\"><div  class=\"panelview\">\n                    <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td align=\"left\" valign=\"top\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td width=\"12%\" align=\"left\" valign=\"top\" bgcolor=\"#f8f8f8\"><div class=\"Maxheightpanel\">\n\t\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"space\">\n\t\t\t\t\t\t  \t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td align=\"left\" valign=\"top\"><div>\n\t\t\t\t\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n                    ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t\t\t\t\t\t  <tr>\n\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" valign=\"top\" id=\"year";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" value=\"Y\" onclick=\"hidemonth(\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\',\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\');\" class=\"AcctxtimgSelect AcctxtimgSub\">";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</td>\n\t\t\t\t\t\t\t\t    \t\t </tr>\n\t\t\t\t\t\t\t\t    \t\t ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t\t\t    \t\t  <tr>\n\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" valign=\"top\" id=\"year";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" value=\"N\" onclick=\"hidemonth(\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\');\" class=\"Acctxtimg\">";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t\t\t\t    \t\t \n\t\t\t\t\t\t\t\t  \t\t\t <tr>\n\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"display:none\" id=\"month";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" value=\"N\" ><div >\n\t\t\t\t\t\t\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"5\" cellpadding=\"0\" class=\"space\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" valign=\"top\" value=\"N\" id=\"monthsub";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" onclick=\"loadvalues(\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\',this)\" class=\"Acctxtimg\">";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</td>\n\t\t\t\t\t\t\t\t\t\t  \t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t  \t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\t\t\t\t\t  \t\t\t\t\t \t<tr>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" valign=\"top\" value=\"N\" id=\"monthsub";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t\t  \t\t\t\t</div></td> \n\t\t\t\t\t\t\t\t\t  \t\t </tr>\n";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\t\t\t\t\t\t\t\t\t\t\t  \t\t\t\t\n\t\t\t\t\t\t\t\t  \t\t\t \n\t\t\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t  \t\t\t</div></td>\n\t\t\t\t\t\t  \t\t\t</tr>\n\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t  \t\t</div></td>\n\t\t\t\t\t\t<td width=\"88%\" align=\"left\" valign=\"top\" class=\"test\">\n\t\t\t\t\t\t\t<table width=\"100%\" >\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td  id=\"details";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</table>\n                     \n\t\t\t\t\t\t</td>\n\t\t\t\t  \t</tr>\n\t\t\t\t    </table></td>\n\t\t\t \t</tr>\n\t\t  \t\t</table>\n            \t</div></td>\n\t\t\t</tr>\n          </table></td>\n\t\t</tr>\n\t\t</table>\n\t\t</div></td>\n\t</tr>\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n    </table>\n    \n<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\"/>\n<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\"/>\n<input type=\"hidden\" name=\"locale\" id=\"locale\" value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\"/>\n<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\"/>\n<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\"/>\n<input type=\"hidden\" name=\"from_date\" id=\"from_date\" value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\"/>\n<input type=\"hidden\" name=\"to_date\" id=\"to_date\" value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\"/>\n<input type=\"hidden\" name=\"grphistory_type\" id=\"grphistory_type\" value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\"/>\n<input type=\"hidden\" name=\"lastopenmonth\" id=\"lastopenmonth\" value=\"\"/>\n<input type=\"hidden\" name=\"lastopengroup\" id=\"lastopengroup\" value=\"\"/>\n<input type=\"hidden\" name=\"orderCatalogNature\" id=\"orderCatalogNature\" value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\"/>\n<input type=\"hidden\" name=\"clinician_id\" id=\"clinician_id\" value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\"/>\n<input type=\"hidden\" name=\"resp_id\" id=\"resp_id\" value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\"/>\n<input type=\'hidden\' name=\'txtFlagComments\' id=\'txtFlagComments\' value=\"N\">\n<input type=\'hidden\' name=\'txtFlagQuickText\' id=\'txtFlagQuickText\' value=\"N\">\n<input type=\'hidden\' name=\'normalcy\' id=\'normalcy\' value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n<input type=\'hidden\' name=\'queryStringForComments\' id=\'queryStringForComments\' value=\"\">\n<input type=\"hidden\" name=\"fac_id\" id=\"fac_id\" value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n\n\n</form>\n</body>\n<div name=\'tooltiplayer\' id=\'tooltiplayer\'  style=\'position:absolute; width:30%; visibility:hidden;\' bgcolor=\'yellow\'>\n\t<table id=\'tooltiptable\' cellpadding=0 cellspacing=0 border=\'0\'  width=\'100%\' height=\'100%\' align=\'center\'>\n\t\t<tr>\n\t\t\t<td width=\'100%\' class=\'gridTooltipData\' id=\'t\' nowrap></td>\n\t\t\t</td>\n\t\t</tr>\n\t</table>\n</div>\n<script>\nloadYearMonth(\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\');\n</script>\n<script>\n\t\t\tif(top.content!=null)\n\t\t\t{\n\t\t\t\ttop.content.messageFrame.location.href=\"../../eCommon/html/blank.html\";\t\n\t\t\t}else\n\t\t\t{\n\t\t\t\tparent.parent.parent.messageFrame.location.href=\"../../eCommon/html/blank.html\";\t\n\t\t\t}\n</script>\n";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t<script>\n\t\t\t//parent.dataFrame.location.href=\"../../eCommon/html/blank.html\";\n\t\t\tif(top.content!=null)\n\t\t\t{\n\t\t\t\ttop.content.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=APP-002415 Query caused no records to be retrieved.\";\t\n\t\t\t}else\n\t\t\t{\n\t\t\t\tparent.parent.parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=APP-002415 Query caused no records to be retrieved.\";\t\n\t\t\t}\n\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n</html>\n\n";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );
	
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
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History   	Name        		Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
18/04/2018	IN061884		Raja S			18/04/2018		Ramesh G		ML-MMOH-CRF-0536
22/10/2018	IN068145		Raja S			22/10/2018		Ramesh G		ML-MMOH-CRF-1212
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

            _bw.write(_wl_block2Bytes, _wl_block2);

	Properties p;
	session = request.getSession(false);
	p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	Connection con = null;
	ArrayList eventClassArr = new ArrayList() ;
	ArrayList groupTreeArr = new ArrayList() ;
	String bean_id					= "GroupCompDetailBean" ;
	String bean_name				= "eCA.GroupCompDetailBean";
	String patient_id				= request.getParameter("patient_id");
	String clinician_id			= (String) session.getValue("ca_practitioner_id");
	String resp_id = (String)session.getValue("responsibility_id");
	String encounterId = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String strNormalcyInd = request.getParameter("normalcy")==null?"N":request.getParameter("normalcy");
	String fromDate="",toDate="";
	String fac_id = (String)session.getValue("facility_id");
	fromDate = request.getParameter("from_date")==null	?"":request.getParameter("from_date");
	toDate = request.getParameter("to_date")==null	?"":request.getParameter("to_date");
	
	if (toDate.equals(""))
		toDate		= com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
	


	String grphistory_type			= request.getParameter("grphistory_type")==null	?"":request.getParameter("grphistory_type");
	String loadDefaultGrp			= request.getParameter("loadDefaultGrp")==null	?"":request.getParameter("loadDefaultGrp");
	String loadDefaultclass			= request.getParameter("loadDefaultclass")==null	?"":request.getParameter("loadDefaultclass");
	String loadDefaultYear			= request.getParameter("loadDefaultYear")==null	?"":request.getParameter("loadDefaultYear");
	String loadDefaultMonth			= request.getParameter("loadDefaultMonth")==null	?"":request.getParameter("loadDefaultMonth");
	String catalog_nature			= request.getParameter("orderCatalogNature")==null	?"":request.getParameter("orderCatalogNature");
	GroupCompDetailBean bean	= (GroupCompDetailBean)getBeanObject( bean_id, bean_name , request) ; 

try
{
	con = ConnectionManager.getConnection(request);	
	eventClassArr = bean.getEventClass(con,locale,patient_id,encounterId,clinician_id,resp_id,catalog_nature,grphistory_type,fromDate,toDate);
	if(eventClassArr!=null && !(eventClassArr.isEmpty()) )
	{
	
            _bw.write(_wl_block9Bytes, _wl_block9);
for(int i=0;i<eventClassArr.size();i++) {
            	String[] eventClassStr =(String[])eventClassArr.get(i);
            
            if(loadDefaultclass.equals("")){
            	loadDefaultclass=(String)eventClassStr[0];
            }
            if(loadDefaultclass.equals(eventClassStr[0])){
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(eventClassStr[0]));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(eventClassStr[1]));
            _bw.write(_wl_block12Bytes, _wl_block12);
}else{
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(eventClassStr[0]));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(eventClassStr[1]));
            _bw.write(_wl_block14Bytes, _wl_block14);
}
            } 
            _bw.write(_wl_block15Bytes, _wl_block15);

	groupTreeArr=bean.getGroupTree(con,locale,grphistory_type,catalog_nature,loadDefaultclass,patient_id,encounterId,clinician_id,resp_id,fromDate,toDate);
	String tempGroupTest = "";
	String tempGroupYear = "";
	String tempGroupMonth = "";
	
	int totcount= groupTreeArr.size();

            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(totcount));
            _bw.write(_wl_block17Bytes, _wl_block17);
 	
for(int j=0;j<totcount;j++) {
	String groupStr[] =(String[])groupTreeArr.get(j);
	
	if(loadDefaultGrp.equals("")){
	loadDefaultGrp=groupStr[0];
	}

	if(!tempGroupTest.equals(groupStr[0])){
	tempGroupTest=groupStr[0];
	tempGroupYear = "";
	tempGroupMonth = "";

            _bw.write(_wl_block18Bytes, _wl_block18);
if(loadDefaultGrp.equals(groupStr[0])) {
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(groupStr[0]));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(groupStr[0]));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(groupStr[1]));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(j));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(j));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(j));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(j));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(groupStr[0]));
            _bw.write(_wl_block27Bytes, _wl_block27);
}else{ 
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(groupStr[0]));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(groupStr[0]));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(groupStr[1]));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(j));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(j));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(j));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(j));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(groupStr[0]));
            _bw.write(_wl_block27Bytes, _wl_block27);
} 
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(groupStr[0]));
            _bw.write(_wl_block32Bytes, _wl_block32);
for(int i=0;i<totcount;i++) {
					String[] yearValues= (String[])groupTreeArr.get(i);
			
					if(!tempGroupYear.equals(yearValues[2]) && tempGroupTest.equals(yearValues[0])) {
						tempGroupYear=(String)yearValues[2];

						if(loadDefaultYear.equals("")){
							loadDefaultYear=yearValues[2];
						}

            _bw.write(_wl_block33Bytes, _wl_block33);
if(loadDefaultYear.equals(yearValues[2]) && loadDefaultGrp.equals(yearValues[0])) {
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(tempGroupTest));
            out.print( String.valueOf(tempGroupYear));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(tempGroupTest));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(tempGroupYear));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(yearValues[2]));
            _bw.write(_wl_block38Bytes, _wl_block38);
}else{
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(tempGroupTest));
            out.print( String.valueOf(tempGroupYear));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(tempGroupTest));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(tempGroupYear));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(yearValues[2]));
            _bw.write(_wl_block38Bytes, _wl_block38);
} 
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(tempGroupTest));
            out.print( String.valueOf(tempGroupYear));
            _bw.write(_wl_block43Bytes, _wl_block43);
	for(int k=0;k<totcount;k++){
													String[] MonthValues= (String[])groupTreeArr.get(k);
													if(loadDefaultMonth.equals("")){
														loadDefaultMonth=MonthValues[3];
													}
													
														if(tempGroupYear.equals(MonthValues[2]) && tempGroupTest.equals(MonthValues[0])){
														
		
														
            _bw.write(_wl_block44Bytes, _wl_block44);
if(loadDefaultMonth.equals(MonthValues[3]) && loadDefaultGrp.equals(MonthValues[0])) {
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(tempGroupTest));
            out.print( String.valueOf(tempGroupYear));
            out.print( String.valueOf(MonthValues[3]));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(loadDefaultclass));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(tempGroupTest));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(tempGroupYear));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(MonthValues[3]));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(MonthValues[3]));
            _bw.write(_wl_block48Bytes, _wl_block48);
}else{
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(tempGroupTest));
            out.print( String.valueOf(tempGroupYear));
            out.print( String.valueOf(MonthValues[3]));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(loadDefaultclass));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(tempGroupTest));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(tempGroupYear));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(MonthValues[3]));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(MonthValues[3]));
            _bw.write(_wl_block48Bytes, _wl_block48);
} 
            _bw.write(_wl_block50Bytes, _wl_block50);
	}
													}
            _bw.write(_wl_block51Bytes, _wl_block51);
 						  
					 }
						  
					}

            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(tempGroupTest));
            _bw.write(_wl_block53Bytes, _wl_block53);
	}
} 
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(encounterId));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(fromDate));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(toDate));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(grphistory_type));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(catalog_nature));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(clinician_id));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(resp_id));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(strNormalcyInd));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(fac_id));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(loadDefaultclass));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(loadDefaultGrp));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(loadDefaultYear));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(loadDefaultMonth));
            _bw.write(_wl_block68Bytes, _wl_block68);
	}
	else{
		
		
            _bw.write(_wl_block69Bytes, _wl_block69);

		}

}
catch(Exception e)
{
	e.printStackTrace();
}
finally
{
	if(con!=null)ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block70Bytes, _wl_block70);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
